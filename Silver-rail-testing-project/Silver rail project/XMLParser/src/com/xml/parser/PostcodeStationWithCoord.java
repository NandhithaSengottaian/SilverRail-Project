package com.xml.parser;

public class PostcodeStationWithCoord implements Comparable<PostcodeStationWithCoord>{
	
	private String crs;

	private double distance;

	public String getCrs() {
		return crs;
	}

	public void setCrs(String crs) {
		this.crs = crs;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "PostcodeStationWithCoord [crs=" + crs + ", distance=" + distance + "]";
	}

	@Override
	public int compareTo(PostcodeStationWithCoord o) {
		if(this.getDistance() > o.getDistance())
			return 1;
		if(this.getDistance() == o.getDistance())
			return 0;
		else
			return -1;
	}
}
