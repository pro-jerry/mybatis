package com.corejava.java_concurrency_in_practice.ch04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 基于监视器模式的车辆追踪
 * @author jerry
 *
 */
@ThreadSafe
public class MonitorVehicleTracker {

	@GuardedBy("this")
	private final Map<String,MutablePoint> locations;

	public MonitorVehicleTracker(Map<String,MutablePoint> locations) {
		
		this.locations = deepCopy(locations);
	}
	
	public synchronized Map<String,MutablePoint> getLocations(){
		
		return deepCopy(locations);
	}
	
	public synchronized MutablePoint getLocation(String id){
		
		MutablePoint loc = locations.get(id);
		return loc==null?null:new MutablePoint(loc);
	}
	

	public synchronized void setLocation(String id,int x,int y){
		
		MutablePoint loc = locations.get(id);
		if(loc==null)
			throw new IllegalArgumentException("no such ID:"+id);
		loc.x = x;
		loc.y = y;
	}
	
	private Map<String, MutablePoint> deepCopy(
			Map<String, MutablePoint> m) {

		Map<String,MutablePoint> result = new HashMap<String, MutablePoint>();
		for(String id:m.keySet())
			result.put(id, new MutablePoint(m.get(id)));
		
		return Collections.unmodifiableMap(result);
	}
	
	
}
