package org.scuola247.desktop.logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.ServletOutputStream;

import org.scuola247.desktop.config.DataHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageAccess {
	
	// institute logo
	public static byte[] getInstitutesLogo(long id) throws SQLException{
		byte[] output = null;
		Connection conn = null;
		CallableStatement by_id = null;
		try{
			conn = DataHelper.myConnection();
			by_id = conn.prepareCall("{ ? = call istituti_sel_logo(?) }");
			
			by_id.registerOutParameter(1, Types.BINARY);
			
			by_id.setLong(2, id);
			
			by_id.execute();
			
			output = by_id.getBytes(1);
		}
		catch (SQLException e){
			Logger logger = LoggerFactory.getLogger(ImageAccess.class);
			logger.error(e.getMessage(), e);
			throw e;
		}
		finally{
			if (by_id != null){
				by_id.close();
			}
			if (conn != null){
				conn.close();
			}
		}
		return output;
	}
	
	public static long updateInstitutesLogo(long rv, long id, byte[] logo) throws SQLException{
		long newRv = -1;

		Connection conn = null;
		CallableStatement by_id = null;
		try{
			conn = DataHelper.myConnection();
			by_id = conn.prepareCall("{ ? = call istituti_upd_logo(?,?,?) }");
			
			by_id.registerOutParameter(1, Types.BIGINT);
			
			by_id.setLong(2, rv);
			by_id.setLong(3, id);
			by_id.setBytes(4, logo);
			
			by_id.execute();
			
			newRv = by_id.getLong(1);
		}
		catch (SQLException e){
			Logger logger = LoggerFactory.getLogger(ImageAccess.class);
			logger.error(e.getMessage(), e);
			throw e;
		}
		finally{
			if (by_id != null){
				by_id.close();
			}
			if (conn != null){
				conn.close();
			}
		}

		
		return newRv;
	}

}
