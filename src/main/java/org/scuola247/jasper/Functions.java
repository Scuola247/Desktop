package org.scuola247.jasper;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/*
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
*/
import net.sf.jasperreports.functions.annotations.Function;
import net.sf.jasperreports.functions.annotations.FunctionCategories;
import net.sf.jasperreports.functions.annotations.FunctionParameter;
import net.sf.jasperreports.functions.annotations.FunctionParameters;

@FunctionCategories({ org.scuola247.jasper.Label.class })
public class Functions {

	@Function("HELLO_WORLD_MSG")
	public static String HELLO_WORLD_MSG() {
		return "Hello World!";
	}

	@Function("REPEAT_MSG")
	@FunctionParameters({ @FunctionParameter("message"),@FunctionParameter("times"), @FunctionParameter("forceUpperCase") })
	public static String REPEAT_MSG(String message, Integer times) {
		return REPEAT_MSG(message, times, false);
	}

	public static String REPEAT_MSG(String message, Integer times,
			Boolean forceUpperCase) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < times; i++) {
			sb.append(message).append("\n");
		}
		String txt = sb.toString();
		if (forceUpperCase) {
			txt = txt.toUpperCase();
		}
		return txt;
	}
	
	@Function("COGNOME_NOME_PERSONA")
	@FunctionParameters({ @FunctionParameter("persona") })
	public static String COGNOME_NOME_PERSONA(Long persona) {
/*
		CallableStatement cs = null;
		
		Connection conn = (Connection)(this.getParameterValue( JRFillParameter.REPORT_CONNECTION));
		
        cs = conn.prepareCall("{? = call persone_cognome_nome(?) }");

  	 	cs.registerOutParameter(1, java.sql.Types.VARCHAR);
  	 	cs.setLong(2, persona);
  	 	
  		cs.execute();
  		
  		return cs.getString(1);*/
		return "Nome e cognome della persona3";
	}
	@Function("FOTO_PERSONA")
	@FunctionParameters({ @FunctionParameter("persona") })
	public static InputStream FOTO_PERSONA(Long persona) {
		/*
		
		CallableStatement cs = null;
		
		Connection conn = (Connection)(this.getParameterValue( JRFillParameter.REPORT_CONNECTION));
		
        cs = conn.prepareCall("{? = call persone_sel_foto_miniatura(?) }");

  	 	cs.registerOutParameter(1, java.sql.Types.BINARY);
  	 	cs.setLong(2, persona);
  	 	
  		cs.execute();
  		return new ByteArrayInputStream(cs.getBytes(1));
*/
  		
  		return new ByteArrayInputStream(null);
	}


	
	
	
}