package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

/**
 * @author zhangxu
 *
 */
@Table(tablename = "POP_ATTACHMENT_INFO")
public class PersistenceAttachment {
	@TableKey(strategy = Strategy.NORMAL)
	@TableField(columnName = "ID")
	private String ID;

	@TableField(columnName = "PATHNAME")
	private String pathname;
	
	@TableField(columnName = "IMAGE")
	private Object image;

	
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public Object getImage() {
		return image;
	}

	public void setImage(Object image) {
		this.image = image;
	}

	
}
