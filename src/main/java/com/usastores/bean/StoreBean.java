package com.usastores.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="storetable")
public class StoreBean 
{
	@Id
	@GeneratedValue
	private int storeId;
	private String storeName;
	private String storeArea;
	private int zipcode;
	private float distanceInMiles;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreArea() {
		return storeArea;
	}
	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public float getDistanceInMiles() {
		return distanceInMiles;
	}
	public void setDistanceInMiles(float distanceInMiles) {
		this.distanceInMiles = distanceInMiles;
	}
	
	

}
