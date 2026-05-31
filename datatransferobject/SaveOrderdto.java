package com.example.Ekart.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveOrderdto 
{
	private String cargoname;
	private String cargodesc;
	private Double cargoweight;
	private Integer cargocount;
	private Integer loadingaddressid;
	private Integer unloadingaddressid;
//	public SaveOrderdto() {
//		super();
//	}
//	public SaveOrderdto(String cargoname, String cargodesc, Double cargoweight, Integer cargocount,
//			Integer loadingaddressid, Integer unloadingaddressid) {
//		super();
//		this.cargoname = cargoname;
//		this.cargodesc = cargodesc;
//		this.cargoweight = cargoweight;
//		this.cargocount = cargocount;
//		this.loadingaddressid = loadingaddressid;
//		this.unloadingaddressid = unloadingaddressid;
//	}
//	public String getCargoname() {
//		return cargoname;
//	}
//	public void setCargoname(String cargoname) {
//		this.cargoname = cargoname;
//	}
//	public String getCargodesc() {
//		return cargodesc;
//	}
//	public void setCargodesc(String cargodesc) {
//		this.cargodesc = cargodesc;
//	}
//	public Double getCargoweight() {
//		return cargoweight;
//	}
//	public void setCargoweight(Double cargoweight) {
//		this.cargoweight = cargoweight;
//	}
//	public Integer getCargocount() {
//		return cargocount;
//	}
//	public void setCargocount(Integer cargocount) {
//		this.cargocount = cargocount;
//	}
//	public Integer getLoadingaddressid() {
//		return loadingaddressid;
//	}
//	public void setLoadingaddressid(Integer loadingaddressid) {
//		this.loadingaddressid = loadingaddressid;
//	}
//	public Integer getUnloadingaddressid() {
//		return unloadingaddressid;
//	}
//	public void setUnloadingaddressid(Integer unloadingaddressid) {
//		this.unloadingaddressid = unloadingaddressid;
//	}
//	@Override
//	public String toString() {
//		return "SaveOrderdto [cargoname=" + cargoname + ", cargodesc=" + cargodesc + ", cargoweight=" + cargoweight
//				+ ", cargocount=" + cargocount + ", loadingaddressid=" + loadingaddressid + ", unloadingaddressid="
//				+ unloadingaddressid + "]";
//	}
}
	