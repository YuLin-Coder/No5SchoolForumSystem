package campusbbs.model.dao.impl;

import java.util.List;

import campusbbs.model.dao.MailDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.MailServer;

public class MailDAOImpl implements MailDAO {

	@Override
	public List<MailServer> findMailServerList() {
		// TODO Auto-generated method stub
		
		String sql="select * from mail_server;";
		
		return  SQLUtils.queryRecordList(sql, MailServer.class);
		
	}

	@Override
	public long getMailServerCount() {
		// TODO Auto-generated method stub
		
		String sql="select count(*) from mail_server;";
		
		return SQLUtils.getRecordCount(sql);
		
	}
	
}

































