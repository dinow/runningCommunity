package be.dno.running.entities;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
 
import be.dno.running.helper.ConvertHelper;

@PersistenceCapable
public class BestTimes implements Serializable{
	private static final long serialVersionUID = 6343622664697425165L;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	private double distance;
	private long time;
	
	public BestTimes() {
		super();
	}
	
	public BestTimes(Double distance, long bestTime){
		this.distance = distance;
		this.time = bestTime;
	}
	
	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getDisplay(){
		return ConvertHelper.toPace(time/1000);
	}
	
	
	
}
