package campusbbs.model.dao;

import java.util.List;

import campusbbs.model.vo.MailServer;

public interface MailDAO {
	public List<MailServer> findMailServerList();
	public long getMailServerCount();
}
