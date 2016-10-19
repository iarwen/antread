package com.antread.bdp.core.timer;

public class LongTimer {

	private long beginTime;
	private long endTime;

	public LongTimer() {
		reset();
	}

	public void reset() {
		this.beginTime = System.currentTimeMillis();
	}

	public double getTime() {
		this.endTime = System.currentTimeMillis();

		double s = (endTime - beginTime) / 1000.00;
		System.out.println("----------" + s);
		return s;
	}

}
