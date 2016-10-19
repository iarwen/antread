package com.antread.bdp.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import com.antread.bdp.framework.exception.BaseException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class DtoUtils {

	/**
	 * 获取某ID的值
	 * 
	 * @param beanlist
	 * @param propName
	 * @return
	 */
	public static Set<String> getIdsSetFromBeanList(List<?> beanlist, String propName) {

		Set<String> ids = new HashSet<String>();

		for (Object obj : beanlist) {
			try {
				String id = BeanUtils.getSimpleProperty(obj, propName);
				ids.add(id);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
				break;
			}
		}

		return ids;

	}

	/**
	 * 获取某个字段Id的值
	 * 
	 * @param beanlist
	 * @param propName
	 * @return
	 */
	public static Set<String> getIdsSetFromBeanListByFileId(List<?> beanlist, String propName) {

		Set<String> ids = new HashSet<String>();

		for (Object obj : beanlist) {
			try {
				String id = BeanUtils.getSimpleProperty(obj, propName);
				if (id != null) {
					ids.add(id);
				}
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
				break;
			}
		}

		return ids;

	}

	public static List makeViewDtoList(Class dtoClass, List beanlist) {
		List dtoList = new ArrayList();
		try {
			for (Object o : beanlist) {

				Object dtoInfo;

				dtoInfo = dtoClass.newInstance();

				BeanUtils.copyProperties(dtoInfo, o);

				dtoList.add(dtoInfo);

			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new BaseException("makeViewDtoList error!", e);
		}

		return dtoList;
	}

	public static List makeViewDtoList(Class dtoClass, List beanlist, String propname, List propList) {
		Map<String, List> dataMap = new HashMap<String, List>();
		dataMap.put(propname, propList);
		return makeViewDtoList(dtoClass, beanlist, dataMap);

	}

	public static List makeViewDtoList(Class dtoClass, List beanlist, Map<String, List> dataMap) {
		return makeViewDtoList(dtoClass, beanlist, dataMap, null);
	}

	public static List makeViewDtoList(Class dtoClass, List beanlist, Map<String, List> dataMap, Map<String, Map<String, String>> keymapping) {

		List dtoList = new ArrayList();

		try {

			Map<String, Map<String, Object>> datamapping = new HashMap<String, Map<String, Object>>();
			Iterator<Entry<String, List>> it = dataMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, List> entry = it.next();
				String key = entry.getKey();
				List datalist = entry.getValue();
				Map<String, Object> dd = new HashMap<String, Object>();
				for (Object oo : datalist) {
					dd.put(BeanUtils.getSimpleProperty(oo, "fid").toString(), oo);
				}
				datamapping.put(key, dd);
			}

			BeanCopier bc = null;

			for (Object o : beanlist) {
				if (bc == null) {
					bc = BeanCopier.create(o.getClass(), dtoClass, false);
				}
				Object dtoInfo = dtoClass.newInstance();
				// BeanUtils.copyProperties(dtoInfo, o);
				bc.copy(o, dtoInfo, null);

				it = dataMap.entrySet().iterator();
				while (it.hasNext()) {
					Entry<String, List> entry = it.next();
					String key = entry.getKey();
					Map<String, Object> dd = datamapping.get(key);
					String value = BeanUtils.getSimpleProperty(o, key);
					if (value == null) {
						continue;
					}
					Object data = dd.get(value);

					if (keymapping != null && keymapping.containsKey(key)) {
						Map<String, String> mp = keymapping.get(key);
						Iterator<Entry<String, String>> tt = mp.entrySet().iterator();
						while (tt.hasNext()) {
							Entry<String, String> tkey = tt.next();
							try {
								BeanUtils.setProperty(dtoInfo, tkey.getKey(), BeanUtils.getSimpleProperty(data, tkey.getValue()));
							} catch (Exception ex) {
							}
						}
					} else {

						try {
							BeanUtils.setProperty(dtoInfo, key.replaceAll("Id", "Name"), BeanUtils.getSimpleProperty(data, "name"));
						} catch (Exception ex) {
						}
					}
				}

				dtoList.add(dtoInfo);

			}
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new BaseException("makeViewDtoList error!", e);
		}

		return dtoList;
	}

	/**
	 * 获取fid的值列表
	 * 
	 * @param beanlist
	 * @return
	 */
	public static List<String> extractFidList(List<?> beanlist) {
		Set<String> idset = getIdsSetFromBeanList(beanlist, "fid");
		return new ArrayList<String>(idset);
	}

}
