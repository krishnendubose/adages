package cmdb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@XmlRootElement(name="cmdbList")
public class CMDBList implements Serializable {

	public List<CMDB> cmdbList;

	public CMDBList(){
		cmdbList = new ArrayList<CMDB>();
	}
    
	@XmlElement
	@XmlElementWrapper(name="cmdbs")
	public List<CMDB> getCmdbList() {
		return cmdbList;
	}

	public void setCmdbList(List<CMDB> cmdbList) {
		this.cmdbList = cmdbList;
	}
	
	@Override
	public String toString(){

		StringBuffer cmdbListData = new StringBuffer();
		for (CMDB data : cmdbList){
			cmdbListData = cmdbListData.append(data + "\n");
		}
		return cmdbListData.toString();

	}
}
