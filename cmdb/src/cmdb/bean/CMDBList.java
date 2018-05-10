package cmdb.bean;

import java.io.Serializable;
import java.util.List;

public class CMDBList implements Serializable {

	public List<CMDB> cmdbList;

	public List<CMDB> getCmdbList() {
		return cmdbList;
	}

	public void setCmdbList(List<CMDB> cmdbList) {
		this.cmdbList = cmdbList;
	}
	
}
