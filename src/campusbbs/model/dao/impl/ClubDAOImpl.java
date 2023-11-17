package campusbbs.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import campusbbs.model.dao.ClubDAO;
import campusbbs.model.utils.SQLUtils;
import campusbbs.model.vo.Club;
import campusbbs.model.vo.ClubType;

public class ClubDAOImpl implements ClubDAO {
	
	private static final String CLUB_TABLE="club";
	
	@Override
	public void saveClub(Club club) {
		// TODO Auto-generated method stub

		String sql="insert into "+CLUB_TABLE+"(clubName,clubIcon,clubDescribe,clubTypeId) value("
				+ "\""+club.getClubName()+"\","
						+ "\""+club.getClubIcon()+"\","
								+ "\""+club.getClubDescribe()+"\","
									+club.getClubTypeId()+");";
		
		SQLUtils.updateRecord(sql);
		
	}

	@Override
	public void deleteClub(String clubName) {
		// TODO Auto-generated method stub

		String sql="delete from "+CLUB_TABLE+" where clubName='"+clubName+"';";
		SQLUtils.updateRecord(sql);

	}

	@Override
	public void updateClub(String clubName,Club club) {
		// TODO Auto-generated method stub

		String sql="update "+CLUB_TABLE+" set ";
		int c=0;
		ArrayList<Object> arr=new ArrayList<>();
		
		if(club.getClubName()!=null){
			sql+=" clubName=? ";
			arr.add(club.getClubName());
			c++;
		}
		
		if(club.getClubIcon()!=null){
			sql+=" clubIcon=? ";
			arr.add(club.getClubIcon());
			c++;
		}
		
		if(club.getClubDescribe()!=null){
			if(c!=0){
				sql+=",";
			}
			sql+=" clubDescribe=? ";
			arr.add(club.getClubDescribe());
			c++;
		}
		
		if(club.getClubTypeId()>0){
			if(c!=0){
				sql+=",";
			}
			sql+=" clubTypeId=? ";
			arr.add(club.getClubTypeId());
			c++;
		}
		
		sql+="where clubName='"+clubName+"';";

		SQLUtils.updateRecord(sql,arr.toArray());
		
	}

	@Override
	public Club findClub(String clubName) {
		// TODO Auto-generated method stub

		String sql="select c.clubName,clubIcon,clubDescribe,clubTypeId,count(postId) postNum,sum(replyNum) replyNum "
				+ "from (select * from club where club.clubName='"+clubName+"') c "
				+ "left join ( "
				+ "select post.postId,post.clubName,count(replyId) replyNum from post "
				+ "left join reply "
				+ "on reply.postId=post.postId "
				+ "group by post.postId) p "
				+ "on c.clubName=p.clubName "
				+ "group by c.clubName;";

		return SQLUtils.queryRecordById(sql, Club.class);
		
	}

	@Override
	public List<Club> findAllClub() {
		// TODO Auto-generated method stub

		String sql="select club.clubName,clubIcon,clubDescribe,clubTypeId,count(postId) postNum,sum(replyNum) replyNum from club "
						+ "left join ( "
						+ "select post.postId,post.clubName,count(replyId) replyNum from post "
						+ "left join reply "
						+ "on reply.postId=post.postId "
						+ "group by post.postId) p "
					+ "on club.clubName=p.clubName "
					+ "group by club.clubName;";
		
		return SQLUtils.queryRecordList(sql, Club.class);
		
	}
	
	@Override
	public List<Club> findPreClub(int num) {
		// TODO Auto-generated method stub

		String sql="select r.clubName,clubIcon,clubDescribe,clubTypeId,postNum,replyNum from ( "
					 + "select club.clubName,clubIcon,clubDescribe,clubTypeId,count(postId) postNum,sum(replyNum) replyNum from club  "
					 + "left join ( "
						 + "select post.postId,post.clubName,count(replyId) replyNum from post "
						 + "left join reply  "
						 + "on reply.postId=post.postId "
						 + "group by post.postId) p "
					 + "on club.clubName=p.clubName "
					 + "group by club.clubName "
					 + "order by postNum "
				 + ") r "
				 + "order by (r.postNum+r.replyNum) desc "
				 + "limit 0,"+num+";";

		return SQLUtils.queryRecordList(sql, Club.class);
		
	}

	@Override
	public long getClubCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from "+CLUB_TABLE+";";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public long getClubTypeCount() {
		// TODO Auto-generated method stub
		String sql="select count(*) from club_type;";
		return SQLUtils.getRecordCount(sql);
	}

	@Override
	public ClubType getClubTypeById(int typeId) {
		// TODO Auto-generated method stub
		String sql="select * from club_type where clubTypeId="+typeId+";";
		return SQLUtils.queryRecordById(sql, ClubType.class);
	}

	@Override
	public void addClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		String sql="insert into club_type(clubType) value('"+clubType.getClubType()+"');";
		SQLUtils.updateRecord(sql);	
	}

	@Override
	public void updateCLubType(ClubType clubType) {
		// TODO Auto-generated method stub
		String sql="update club_type set clubType='"+clubType.getClubType()+"' where clubTypeId="+clubType.getClubTypeId()+";";
		SQLUtils.updateRecord(sql);	
	}

	@Override
	public void deleteClubType(ClubType clubType) {
		// TODO Auto-generated method stub
		String sql="delete from club_type where clubTypeId="+clubType.getClubTypeId()+";";
		SQLUtils.updateRecord(sql);	
	}

	@Override
	public List<ClubType> getClubTypeList() {
		// TODO Auto-generated method stub
		String sql="select * from club_type order by clubTypeId;";
		return SQLUtils.queryRecordList(sql, ClubType.class);
	}	

}




























