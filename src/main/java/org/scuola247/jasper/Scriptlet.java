package org.scuola247.jasper;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.fill.JRFillParameter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Scriptlet  extends JRDefaultScriptlet {
	public InputStream persona_foto_miniatura(Long persona) throws JRScriptletException, SQLException
	{
		
		CallableStatement cs = null;
		
		Connection conn = (Connection)(this.getParameterValue( JRFillParameter.REPORT_CONNECTION));
		

        cs = conn.prepareCall("{? = call persone_sel_foto_miniatura(?) }");

  	 	cs.registerOutParameter(1, java.sql.Types.BINARY);
  	 	cs.setLong(2, persona);
  	 	
  		cs.execute();
  		
  		return new ByteArrayInputStream(cs.getBytes(1));
	}

	public String HelloWorld() throws JRScriptletException
	{
		
  		return "Hello World !!!";
	}

}
