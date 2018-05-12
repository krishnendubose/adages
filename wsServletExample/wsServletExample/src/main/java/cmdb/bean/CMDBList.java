package cmdb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CMDBList implements Serializable {

	public List<CMDB> cmdbList;

	public CMDBList(){
		cmdbList = new ArrayList<CMDB>();
	}

	public List<CMDB> getCmdbList() {
		return cmdbList;
	}

	public void setCmdbList(List<CMDB> cmdbList) {
		this.cmdbList = cmdbList;
	}
	public String toString(){

		StringBuffer cmdbListData = new StringBuffer();
		for (CMDB data : cmdbList){
			cmdbListData = cmdbListData.append(data + "\n");
		}
		return cmdbListData.toString();

	}
}
