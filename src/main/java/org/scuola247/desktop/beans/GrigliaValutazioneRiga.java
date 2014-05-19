package org.scuola247.desktop.beans;

import ch.rasc.extclassgenerator.Model;
import ch.rasc.extclassgenerator.ModelField;

@Model(value = "Desktop.model.GrigliaValutazioneRiga", 
readMethod = "valutazioniService.griglia_valutazioni_righe_by_classe_docente_materia",
/*updateMethod = "valutazioniService.update_valutazione",*/
paging = true)
public class GrigliaValutazioneRiga {

	@ModelField
	private long alunno;

	@ModelField
	private String cognome;

	@ModelField
	private String nome;

	@ModelField
	private int assenze;

	@ModelField
	private int ritardi;

	@ModelField
	private int uscite;

	@ModelField
	private int fuori_classe;

	@ModelField
	private int note;

	@ModelField
	private int mancanze;

	@ModelField
	private String condotta;

	@ModelField(useNull=true)
	private Long va_1;
	@ModelField(useNull=true)
	private Long rv_1;
	@ModelField(useNull=true)
	private Long vo_1;
	@ModelField(useNull=true)
	private Long va_2;
	@ModelField(useNull=true)
	private Long rv_2;
	@ModelField(useNull=true)
	private Long vo_2;
	@ModelField(useNull=true)
	private Long va_3;
	@ModelField(useNull=true)
	private Long rv_3;
	@ModelField(useNull=true)
	private Long vo_3;
	@ModelField(useNull=true)
	private Long va_4;
	@ModelField(useNull=true)
	private Long rv_4;
	@ModelField(useNull=true)
	private Long vo_4;
	@ModelField(useNull=true)
	private Long va_5;
	@ModelField(useNull=true)
	private Long rv_5;
	@ModelField(useNull=true)
	private Long vo_5;
	@ModelField(useNull=true)
	private Long va_6;
	@ModelField(useNull=true)
	private Long rv_6;
	@ModelField(useNull=true)
	private Long vo_6;
	@ModelField(useNull=true)
	private Long va_7;
	@ModelField(useNull=true)
	private Long rv_7;
	@ModelField(useNull=true)
	private Long vo_7;
	@ModelField(useNull=true)
	private Long va_8;
	@ModelField(useNull=true)
	private Long rv_8;
	@ModelField(useNull=true)
	private Long vo_8;
	@ModelField(useNull=true)
	private Long va_9;
	@ModelField(useNull=true)
	private Long rv_9;
	@ModelField(useNull=true)
	private Long vo_9;
	@ModelField(useNull=true)
	private Long va_10;
	@ModelField(useNull=true)
	private Long rv_10;
	@ModelField(useNull=true)
	private Long vo_10;
	@ModelField(useNull=true)
	private Long va_11;
	@ModelField(useNull=true)
	private Long rv_11;
	@ModelField(useNull=true)
	private Long vo_11;
	@ModelField(useNull=true)
	private Long va_12;
	@ModelField(useNull=true)
	private Long rv_12;
	@ModelField(useNull=true)
	private Long vo_12;
	@ModelField(useNull=true)
	private Long va_13;
	@ModelField(useNull=true)
	private Long rv_13;
	@ModelField(useNull=true)
	private Long vo_13;
	@ModelField(useNull=true)
	private Long va_14;
	@ModelField(useNull=true)
	private Long rv_14;
	@ModelField(useNull=true)
	private Long vo_14;
	@ModelField(useNull=true)
	private Long va_15;
	@ModelField(useNull=true)
	private Long rv_15;
	@ModelField(useNull=true)
	private Long vo_15;
	@ModelField(useNull=true)
	private Long va_16;
	@ModelField(useNull=true)
	private Long rv_16;
	@ModelField(useNull=true)
	private Long vo_16;
	@ModelField(useNull=true)
	private Long va_17;
	@ModelField(useNull=true)
	private Long rv_17;
	@ModelField(useNull=true)
	private Long vo_17;
	@ModelField(useNull=true)
	private Long va_18;
	@ModelField(useNull=true)
	private Long rv_18;
	@ModelField(useNull=true)
	private Long vo_18;
	@ModelField(useNull=true)
	private Long va_19;
	@ModelField(useNull=true)
	private Long rv_19;
	@ModelField(useNull=true)
	private Long vo_19;
	@ModelField(useNull=true)
	private Long va_20;
	@ModelField(useNull=true)
	private Long rv_20;
	@ModelField(useNull=true)
	private Long vo_20;
	@ModelField(useNull=true)
	private Long va_21;
	@ModelField(useNull=true)
	private Long rv_21;
	@ModelField(useNull=true)
	private Long vo_21;
	@ModelField(useNull=true)
	private Long va_22;
	@ModelField(useNull=true)
	private Long rv_22;
	@ModelField(useNull=true)
	private Long vo_22;
	@ModelField(useNull=true)
	private Long va_23;
	@ModelField(useNull=true)
	private Long rv_23;
	@ModelField(useNull=true)
	private Long vo_23;
	@ModelField(useNull=true)
	private Long va_24;
	@ModelField(useNull=true)
	private Long rv_24;
	@ModelField(useNull=true)
	private Long vo_24;
	@ModelField(useNull=true)
	private Long va_25;
	@ModelField(useNull=true)
	private Long rv_25;
	@ModelField(useNull=true)
	private Long vo_25;
	@ModelField(useNull=true)
	private Long va_26;
	@ModelField(useNull=true)
	private Long rv_26;
	@ModelField(useNull=true)
	private Long vo_26;
	@ModelField(useNull=true)
	private Long va_27;
	@ModelField(useNull=true)
	private Long rv_27;
	@ModelField(useNull=true)
	private Long vo_27;
	@ModelField(useNull=true)
	private Long va_28;
	@ModelField(useNull=true)
	private Long rv_28;
	@ModelField(useNull=true)
	private Long vo_28;
	@ModelField(useNull=true)
	private Long va_29;
	@ModelField(useNull=true)
	private Long rv_29;
	@ModelField(useNull=true)
	private Long vo_29;
	@ModelField(useNull=true)
	private Long va_30;
	@ModelField(useNull=true)
	private Long rv_30;
	@ModelField(useNull=true)
	private Long vo_30;
	@ModelField(useNull=true)
	private Long va_31;
	@ModelField(useNull=true)
	private Long rv_31;
	@ModelField(useNull=true)
	private Long vo_31;
	@ModelField(useNull=true)
	private Long va_32;
	@ModelField(useNull=true)
	private Long rv_32;
	@ModelField(useNull=true)
	private Long vo_32;
	@ModelField(useNull=true)
	private Long va_33;
	@ModelField(useNull=true)
	private Long rv_33;
	@ModelField(useNull=true)
	private Long vo_33;
	@ModelField(useNull=true)
	private Long va_34;
	@ModelField(useNull=true)
	private Long rv_34;
	@ModelField(useNull=true)
	private Long vo_34;
	@ModelField(useNull=true)
	private Long va_35;
	@ModelField(useNull=true)
	private Long rv_35;
	@ModelField(useNull=true)
	private Long vo_35;
	@ModelField(useNull=true)
	private Long va_36;
	@ModelField(useNull=true)
	private Long rv_36;
	@ModelField(useNull=true)
	private Long vo_36;
	@ModelField(useNull=true)
	private Long va_37;
	@ModelField(useNull=true)
	private Long rv_37;
	@ModelField(useNull=true)
	private Long vo_37;
	@ModelField(useNull=true)
	private Long va_38;
	@ModelField(useNull=true)
	private Long rv_38;
	@ModelField(useNull=true)
	private Long vo_38;
	@ModelField(useNull=true)
	private Long va_39;
	@ModelField(useNull=true)
	private Long rv_39;
	@ModelField(useNull=true)
	private Long vo_39;
	@ModelField(useNull=true)
	private Long va_40;
	@ModelField(useNull=true)
	private Long rv_40;
	@ModelField(useNull=true)
	private Long vo_40;
	@ModelField(useNull=true)
	private Long va_41;
	@ModelField(useNull=true)
	private Long rv_41;
	@ModelField(useNull=true)
	private Long vo_41;
	@ModelField(useNull=true)
	private Long va_42;
	@ModelField(useNull=true)
	private Long rv_42;
	@ModelField(useNull=true)
	private Long vo_42;
	@ModelField(useNull=true)
	private Long va_43;
	@ModelField(useNull=true)
	private Long rv_43;
	@ModelField(useNull=true)
	private Long vo_43;
	@ModelField(useNull=true)
	private Long va_44;
	@ModelField(useNull=true)
	private Long rv_44;
	@ModelField(useNull=true)
	private Long vo_44;
	@ModelField(useNull=true)
	private Long va_45;
	@ModelField(useNull=true)
	private Long rv_45;
	@ModelField(useNull=true)
	private Long vo_45;
	@ModelField(useNull=true)
	private Long va_46;
	@ModelField(useNull=true)
	private Long rv_46;
	@ModelField(useNull=true)
	private Long vo_46;
	@ModelField(useNull=true)
	private Long va_47;
	@ModelField(useNull=true)
	private Long rv_47;
	@ModelField(useNull=true)
	private Long vo_47;
	@ModelField(useNull=true)
	private Long va_48;
	@ModelField(useNull=true)
	private Long rv_48;
	@ModelField(useNull=true)
	private Long vo_48;
	@ModelField(useNull=true)
	private Long va_49;
	@ModelField(useNull=true)
	private Long rv_49;
	@ModelField(useNull=true)
	private Long vo_49;
	@ModelField(useNull=true)
	private Long va_50;
	@ModelField(useNull=true)
	private Long rv_50;
	@ModelField(useNull=true)
	private Long vo_50;
	@ModelField(useNull=true)
	private Long va_51;
	@ModelField(useNull=true)
	private Long rv_51;
	@ModelField(useNull=true)
	private Long vo_51;
	@ModelField(useNull=true)
	private Long va_52;
	@ModelField(useNull=true)
	private Long rv_52;
	@ModelField(useNull=true)
	private Long vo_52;
	@ModelField(useNull=true)
	private Long va_53;
	@ModelField(useNull=true)
	private Long rv_53;
	@ModelField(useNull=true)
	private Long vo_53;
	@ModelField(useNull=true)
	private Long va_54;
	@ModelField(useNull=true)
	private Long rv_54;
	@ModelField(useNull=true)
	private Long vo_54;
	@ModelField(useNull=true)
	private Long va_55;
	@ModelField(useNull=true)
	private Long rv_55;
	@ModelField(useNull=true)
	private Long vo_55;
	@ModelField(useNull=true)
	private Long va_56;
	@ModelField(useNull=true)
	private Long rv_56;
	@ModelField(useNull=true)
	private Long vo_56;
	@ModelField(useNull=true)
	private Long va_57;
	@ModelField(useNull=true)
	private Long rv_57;
	@ModelField(useNull=true)
	private Long vo_57;
	@ModelField(useNull=true)
	private Long va_58;
	@ModelField(useNull=true)
	private Long rv_58;
	@ModelField(useNull=true)
	private Long vo_58;
	@ModelField(useNull=true)
	private Long va_59;
	@ModelField(useNull=true)
	private Long rv_59;
	@ModelField(useNull=true)
	private Long vo_59;
	@ModelField(useNull=true)
	private Long va_60;
	@ModelField(useNull=true)
	private Long rv_60;
	@ModelField(useNull=true)
	private Long vo_60;
	@ModelField(useNull=true)
	private Long va_61;
	@ModelField(useNull=true)
	private Long rv_61;
	@ModelField(useNull=true)
	private Long vo_61;
	@ModelField(useNull=true)
	private Long va_62;
	@ModelField(useNull=true)
	private Long rv_62;
	@ModelField(useNull=true)
	private Long vo_62;
	@ModelField(useNull=true)
	private Long va_63;
	@ModelField(useNull=true)
	private Long rv_63;
	@ModelField(useNull=true)
	private Long vo_63;
	@ModelField(useNull=true)
	private Long va_64;
	@ModelField(useNull=true)
	private Long rv_64;
	@ModelField(useNull=true)
	private Long vo_64;
	@ModelField(useNull=true)
	private Long va_65;
	@ModelField(useNull=true)
	private Long rv_65;
	@ModelField(useNull=true)
	private Long vo_65;
	@ModelField(useNull=true)
	private Long va_66;
	@ModelField(useNull=true)
	private Long rv_66;
	@ModelField(useNull=true)
	private Long vo_66;
	@ModelField(useNull=true)
	private Long va_67;
	@ModelField(useNull=true)
	private Long rv_67;
	@ModelField(useNull=true)
	private Long vo_67;
	@ModelField(useNull=true)
	private Long va_68;
	@ModelField(useNull=true)
	private Long rv_68;
	@ModelField(useNull=true)
	private Long vo_68;
	@ModelField(useNull=true)
	private Long va_69;
	@ModelField(useNull=true)
	private Long rv_69;
	@ModelField(useNull=true)
	private Long vo_69;
	@ModelField(useNull=true)
	private Long va_70;
	@ModelField(useNull=true)
	private Long rv_70;
	@ModelField(useNull=true)
	private Long vo_70;
	@ModelField(useNull=true)
	private Long va_71;
	@ModelField(useNull=true)
	private Long rv_71;
	@ModelField(useNull=true)
	private Long vo_71;
	@ModelField(useNull=true)
	private Long va_72;
	@ModelField(useNull=true)
	private Long rv_72;
	@ModelField(useNull=true)
	private Long vo_72;
	@ModelField(useNull=true)
	private Long va_73;
	@ModelField(useNull=true)
	private Long rv_73;
	@ModelField(useNull=true)
	private Long vo_73;
	@ModelField(useNull=true)
	private Long va_74;
	@ModelField(useNull=true)
	private Long rv_74;
	@ModelField(useNull=true)
	private Long vo_74;
	@ModelField(useNull=true)
	private Long va_75;
	@ModelField(useNull=true)
	private Long rv_75;
	@ModelField(useNull=true)
	private Long vo_75;
	@ModelField(useNull=true)
	private Long va_76;
	@ModelField(useNull=true)
	private Long rv_76;
	@ModelField(useNull=true)
	private Long vo_76;
	@ModelField(useNull=true)
	private Long va_77;
	@ModelField(useNull=true)
	private Long rv_77;
	@ModelField(useNull=true)
	private Long vo_77;
	@ModelField(useNull=true)
	private Long va_78;
	@ModelField(useNull=true)
	private Long rv_78;
	@ModelField(useNull=true)
	private Long vo_78;
	@ModelField(useNull=true)
	private Long va_79;
	@ModelField(useNull=true)
	private Long rv_79;
	@ModelField(useNull=true)
	private Long vo_79;
	@ModelField(useNull=true)
	private Long va_80;
	@ModelField(useNull=true)
	private Long rv_80;
	@ModelField(useNull=true)
	private Long vo_80;
	@ModelField(useNull=true)
	private Long va_81;
	@ModelField(useNull=true)
	private Long rv_81;
	@ModelField(useNull=true)
	private Long vo_81;
	@ModelField(useNull=true)
	private Long va_82;
	@ModelField(useNull=true)
	private Long rv_82;
	@ModelField(useNull=true)
	private Long vo_82;
	@ModelField(useNull=true)
	private Long va_83;
	@ModelField(useNull=true)
	private Long rv_83;
	@ModelField(useNull=true)
	private Long vo_83;
	@ModelField(useNull=true)
	private Long va_84;
	@ModelField(useNull=true)
	private Long rv_84;
	@ModelField(useNull=true)
	private Long vo_84;
	@ModelField(useNull=true)
	private Long va_85;
	@ModelField(useNull=true)
	private Long rv_85;
	@ModelField(useNull=true)
	private Long vo_85;
	@ModelField(useNull=true)
	private Long va_86;
	@ModelField(useNull=true)
	private Long rv_86;
	@ModelField(useNull=true)
	private Long vo_86;
	@ModelField(useNull=true)
	private Long va_87;
	@ModelField(useNull=true)
	private Long rv_87;
	@ModelField(useNull=true)
	private Long vo_87;
	@ModelField(useNull=true)
	private Long va_88;
	@ModelField(useNull=true)
	private Long rv_88;
	@ModelField(useNull=true)
	private Long vo_88;
	@ModelField(useNull=true)
	private Long va_89;
	@ModelField(useNull=true)
	private Long rv_89;
	@ModelField(useNull=true)
	private Long vo_89;
	@ModelField(useNull=true)
	private Long va_90;
	@ModelField(useNull=true)
	private Long rv_90;
	@ModelField(useNull=true)
	private Long vo_90;
	@ModelField(useNull=true)
	private Long va_91;
	@ModelField(useNull=true)
	private Long rv_91;
	@ModelField(useNull=true)
	private Long vo_91;
	@ModelField(useNull=true)
	private Long va_92;
	@ModelField(useNull=true)
	private Long rv_92;
	@ModelField(useNull=true)
	private Long vo_92;
	@ModelField(useNull=true)
	private Long va_93;
	@ModelField(useNull=true)
	private Long rv_93;
	@ModelField(useNull=true)
	private Long vo_93;
	@ModelField(useNull=true)
	private Long va_94;
	@ModelField(useNull=true)
	private Long rv_94;
	@ModelField(useNull=true)
	private Long vo_94;
	@ModelField(useNull=true)
	private Long va_95;
	@ModelField(useNull=true)
	private Long rv_95;
	@ModelField(useNull=true)
	private Long vo_95;
	@ModelField(useNull=true)
	private Long va_96;
	@ModelField(useNull=true)
	private Long rv_96;
	@ModelField(useNull=true)
	private Long vo_96;
	@ModelField(useNull=true)
	private Long va_97;
	@ModelField(useNull=true)
	private Long rv_97;
	@ModelField(useNull=true)
	private Long vo_97;
	@ModelField(useNull=true)
	private Long va_98;
	@ModelField(useNull=true)
	private Long rv_98;
	@ModelField(useNull=true)
	private Long vo_98;
	@ModelField(useNull=true)
	private Long va_99;
	@ModelField(useNull=true)
	private Long rv_99;
	@ModelField(useNull=true)
	private Long vo_99;
	@ModelField(useNull=true)
	private Long va_100;
	@ModelField(useNull=true)
	private Long rv_100;
	@ModelField(useNull=true)
	private Long vo_100;
	@ModelField(useNull=true)
	private Long va_101;
	@ModelField(useNull=true)
	private Long rv_101;
	@ModelField(useNull=true)
	private Long vo_101;
	@ModelField(useNull=true)
	private Long va_102;
	@ModelField(useNull=true)
	private Long rv_102;
	@ModelField(useNull=true)
	private Long vo_102;
	@ModelField(useNull=true)
	private Long va_103;
	@ModelField(useNull=true)
	private Long rv_103;
	@ModelField(useNull=true)
	private Long vo_103;
	@ModelField(useNull=true)
	private Long va_104;
	@ModelField(useNull=true)
	private Long rv_104;
	@ModelField(useNull=true)
	private Long vo_104;
	@ModelField(useNull=true)
	private Long va_105;
	@ModelField(useNull=true)
	private Long rv_105;
	@ModelField(useNull=true)
	private Long vo_105;
	@ModelField(useNull=true)
	private Long va_106;
	@ModelField(useNull=true)
	private Long rv_106;
	@ModelField(useNull=true)
	private Long vo_106;
	@ModelField(useNull=true)
	private Long va_107;
	@ModelField(useNull=true)
	private Long rv_107;
	@ModelField(useNull=true)
	private Long vo_107;
	@ModelField(useNull=true)
	private Long va_108;
	@ModelField(useNull=true)
	private Long rv_108;
	@ModelField(useNull=true)
	private Long vo_108;
	@ModelField(useNull=true)
	private Long va_109;
	@ModelField(useNull=true)
	private Long rv_109;
	@ModelField(useNull=true)
	private Long vo_109;
	@ModelField(useNull=true)
	private Long va_110;
	@ModelField(useNull=true)
	private Long rv_110;
	@ModelField(useNull=true)
	private Long vo_110;
	@ModelField(useNull=true)
	private Long va_111;
	@ModelField(useNull=true)
	private Long rv_111;
	@ModelField(useNull=true)
	private Long vo_111;
	@ModelField(useNull=true)
	private Long va_112;
	@ModelField(useNull=true)
	private Long rv_112;
	@ModelField(useNull=true)
	private Long vo_112;
	@ModelField(useNull=true)
	private Long va_113;
	@ModelField(useNull=true)
	private Long rv_113;
	@ModelField(useNull=true)
	private Long vo_113;
	@ModelField(useNull=true)
	private Long va_114;
	@ModelField(useNull=true)
	private Long rv_114;
	@ModelField(useNull=true)
	private Long vo_114;
	@ModelField(useNull=true)
	private Long va_115;
	@ModelField(useNull=true)
	private Long rv_115;
	@ModelField(useNull=true)
	private Long vo_115;
	@ModelField(useNull=true)
	private Long va_116;
	@ModelField(useNull=true)
	private Long rv_116;
	@ModelField(useNull=true)
	private Long vo_116;
	@ModelField(useNull=true)
	private Long va_117;
	@ModelField(useNull=true)
	private Long rv_117;
	@ModelField(useNull=true)
	private Long vo_117;
	@ModelField(useNull=true)
	private Long va_118;
	@ModelField(useNull=true)
	private Long rv_118;
	@ModelField(useNull=true)
	private Long vo_118;
	@ModelField(useNull=true)
	private Long va_119;
	@ModelField(useNull=true)
	private Long rv_119;
	@ModelField(useNull=true)
	private Long vo_119;
	@ModelField(useNull=true)
	private Long va_120;
	@ModelField(useNull=true)
	private Long rv_120;
	@ModelField(useNull=true)
	private Long vo_120;
	@ModelField(useNull=true)
	private Long va_121;
	@ModelField(useNull=true)
	private Long rv_121;
	@ModelField(useNull=true)
	private Long vo_121;
	@ModelField(useNull=true)
	private Long va_122;
	@ModelField(useNull=true)
	private Long rv_122;
	@ModelField(useNull=true)
	private Long vo_122;
	@ModelField(useNull=true)
	private Long va_123;
	@ModelField(useNull=true)
	private Long rv_123;
	@ModelField(useNull=true)
	private Long vo_123;
	@ModelField(useNull=true)
	private Long va_124;
	@ModelField(useNull=true)
	private Long rv_124;
	@ModelField(useNull=true)
	private Long vo_124;
	@ModelField(useNull=true)
	private Long va_125;
	@ModelField(useNull=true)
	private Long rv_125;
	@ModelField(useNull=true)
	private Long vo_125;
	@ModelField(useNull=true)
	private Long va_126;
	@ModelField(useNull=true)
	private Long rv_126;
	@ModelField(useNull=true)
	private Long vo_126;
	@ModelField(useNull=true)
	private Long va_127;
	@ModelField(useNull=true)
	private Long rv_127;
	@ModelField(useNull=true)
	private Long vo_127;
	@ModelField(useNull=true)
	private Long va_128;
	@ModelField(useNull=true)
	private Long rv_128;
	@ModelField(useNull=true)
	private Long vo_128;
	@ModelField(useNull=true)
	private Long va_129;
	@ModelField(useNull=true)
	private Long rv_129;
	@ModelField(useNull=true)
	private Long vo_129;
	@ModelField(useNull=true)
	private Long va_130;
	@ModelField(useNull=true)
	private Long rv_130;
	@ModelField(useNull=true)
	private Long vo_130;
	@ModelField(useNull=true)
	private Long va_131;
	@ModelField(useNull=true)
	private Long rv_131;
	@ModelField(useNull=true)
	private Long vo_131;
	@ModelField(useNull=true)
	private Long va_132;
	@ModelField(useNull=true)
	private Long rv_132;
	@ModelField(useNull=true)
	private Long vo_132;
	@ModelField(useNull=true)
	private Long va_133;
	@ModelField(useNull=true)
	private Long rv_133;
	@ModelField(useNull=true)
	private Long vo_133;
	@ModelField(useNull=true)
	private Long va_134;
	@ModelField(useNull=true)
	private Long rv_134;
	@ModelField(useNull=true)
	private Long vo_134;
	@ModelField(useNull=true)
	private Long va_135;
	@ModelField(useNull=true)
	private Long rv_135;
	@ModelField(useNull=true)
	private Long vo_135;
	@ModelField(useNull=true)
	private Long va_136;
	@ModelField(useNull=true)
	private Long rv_136;
	@ModelField(useNull=true)
	private Long vo_136;
	@ModelField(useNull=true)
	private Long va_137;
	@ModelField(useNull=true)
	private Long rv_137;
	@ModelField(useNull=true)
	private Long vo_137;
	@ModelField(useNull=true)
	private Long va_138;
	@ModelField(useNull=true)
	private Long rv_138;
	@ModelField(useNull=true)
	private Long vo_138;
	@ModelField(useNull=true)
	private Long va_139;
	@ModelField(useNull=true)
	private Long rv_139;
	@ModelField(useNull=true)
	private Long vo_139;
	@ModelField(useNull=true)
	private Long va_140;
	@ModelField(useNull=true)
	private Long rv_140;
	@ModelField(useNull=true)
	private Long vo_140;
	@ModelField(useNull=true)
	private Long va_141;
	@ModelField(useNull=true)
	private Long rv_141;
	@ModelField(useNull=true)
	private Long vo_141;
	@ModelField(useNull=true)
	private Long va_142;
	@ModelField(useNull=true)
	private Long rv_142;
	@ModelField(useNull=true)
	private Long vo_142;
	@ModelField(useNull=true)
	private Long va_143;
	@ModelField(useNull=true)
	private Long rv_143;
	@ModelField(useNull=true)
	private Long vo_143;
	@ModelField(useNull=true)
	private Long va_144;
	@ModelField(useNull=true)
	private Long rv_144;
	@ModelField(useNull=true)
	private Long vo_144;
	@ModelField(useNull=true)
	private Long va_145;
	@ModelField(useNull=true)
	private Long rv_145;
	@ModelField(useNull=true)
	private Long vo_145;
	@ModelField(useNull=true)
	private Long va_146;
	@ModelField(useNull=true)
	private Long rv_146;
	@ModelField(useNull=true)
	private Long vo_146;
	@ModelField(useNull=true)
	private Long va_147;
	@ModelField(useNull=true)
	private Long rv_147;
	@ModelField(useNull=true)
	private Long vo_147;
	@ModelField(useNull=true)
	private Long va_148;
	@ModelField(useNull=true)
	private Long rv_148;
	@ModelField(useNull=true)
	private Long vo_148;
	@ModelField(useNull=true)
	private Long va_149;
	@ModelField(useNull=true)
	private Long rv_149;
	@ModelField(useNull=true)
	private Long vo_149;
	@ModelField(useNull=true)
	private Long va_150;
	@ModelField(useNull=true)
	private Long rv_150;
	@ModelField(useNull=true)
	private Long vo_150;
	@ModelField(useNull=true)
	private Long va_151;
	@ModelField(useNull=true)
	private Long rv_151;
	@ModelField(useNull=true)
	private Long vo_151;
	@ModelField(useNull=true)
	private Long va_152;
	@ModelField(useNull=true)
	private Long rv_152;
	@ModelField(useNull=true)
	private Long vo_152;
	@ModelField(useNull=true)
	private Long va_153;
	@ModelField(useNull=true)
	private Long rv_153;
	@ModelField(useNull=true)
	private Long vo_153;
	@ModelField(useNull=true)
	private Long va_154;
	@ModelField(useNull=true)
	private Long rv_154;
	@ModelField(useNull=true)
	private Long vo_154;
	@ModelField(useNull=true)
	private Long va_155;
	@ModelField(useNull=true)
	private Long rv_155;
	@ModelField(useNull=true)
	private Long vo_155;
	@ModelField(useNull=true)
	private Long va_156;
	@ModelField(useNull=true)
	private Long rv_156;
	@ModelField(useNull=true)
	private Long vo_156;
	@ModelField(useNull=true)
	private Long va_157;
	@ModelField(useNull=true)
	private Long rv_157;
	@ModelField(useNull=true)
	private Long vo_157;
	@ModelField(useNull=true)
	private Long va_158;
	@ModelField(useNull=true)
	private Long rv_158;
	@ModelField(useNull=true)
	private Long vo_158;
	@ModelField(useNull=true)
	private Long va_159;
	@ModelField(useNull=true)
	private Long rv_159;
	@ModelField(useNull=true)
	private Long vo_159;
	@ModelField(useNull=true)
	private Long va_160;
	@ModelField(useNull=true)
	private Long rv_160;
	@ModelField(useNull=true)
	private Long vo_160;
	@ModelField(useNull=true)
	private Long va_161;
	@ModelField(useNull=true)
	private Long rv_161;
	@ModelField(useNull=true)
	private Long vo_161;
	@ModelField(useNull=true)
	private Long va_162;
	@ModelField(useNull=true)
	private Long rv_162;
	@ModelField(useNull=true)
	private Long vo_162;
	@ModelField(useNull=true)
	private Long va_163;
	@ModelField(useNull=true)
	private Long rv_163;
	@ModelField(useNull=true)
	private Long vo_163;
	@ModelField(useNull=true)
	private Long va_164;
	@ModelField(useNull=true)
	private Long rv_164;
	@ModelField(useNull=true)
	private Long vo_164;
	@ModelField(useNull=true)
	private Long va_165;
	@ModelField(useNull=true)
	private Long rv_165;
	@ModelField(useNull=true)
	private Long vo_165;
	@ModelField(useNull=true)
	private Long va_166;
	@ModelField(useNull=true)
	private Long rv_166;
	@ModelField(useNull=true)
	private Long vo_166;
	@ModelField(useNull=true)
	private Long va_167;
	@ModelField(useNull=true)
	private Long rv_167;
	@ModelField(useNull=true)
	private Long vo_167;
	@ModelField(useNull=true)
	private Long va_168;
	@ModelField(useNull=true)
	private Long rv_168;
	@ModelField(useNull=true)
	private Long vo_168;
	@ModelField(useNull=true)
	private Long va_169;
	@ModelField(useNull=true)
	private Long rv_169;
	@ModelField(useNull=true)
	private Long vo_169;
	@ModelField(useNull=true)
	private Long va_170;
	@ModelField(useNull=true)
	private Long rv_170;
	@ModelField(useNull=true)
	private Long vo_170;
	@ModelField(useNull=true)
	private Long va_171;
	@ModelField(useNull=true)
	private Long rv_171;
	@ModelField(useNull=true)
	private Long vo_171;
	@ModelField(useNull=true)
	private Long va_172;
	@ModelField(useNull=true)
	private Long rv_172;
	@ModelField(useNull=true)
	private Long vo_172;
	@ModelField(useNull=true)
	private Long va_173;
	@ModelField(useNull=true)
	private Long rv_173;
	@ModelField(useNull=true)
	private Long vo_173;
	@ModelField(useNull=true)
	private Long va_174;
	@ModelField(useNull=true)
	private Long rv_174;
	@ModelField(useNull=true)
	private Long vo_174;
	@ModelField(useNull=true)
	private Long va_175;
	@ModelField(useNull=true)
	private Long rv_175;
	@ModelField(useNull=true)
	private Long vo_175;
	@ModelField(useNull=true)
	private Long va_176;
	@ModelField(useNull=true)
	private Long rv_176;
	@ModelField(useNull=true)
	private Long vo_176;
	@ModelField(useNull=true)
	private Long va_177;
	@ModelField(useNull=true)
	private Long rv_177;
	@ModelField(useNull=true)
	private Long vo_177;
	@ModelField(useNull=true)
	private Long va_178;
	@ModelField(useNull=true)
	private Long rv_178;
	@ModelField(useNull=true)
	private Long vo_178;
	@ModelField(useNull=true)
	private Long va_179;
	@ModelField(useNull=true)
	private Long rv_179;
	@ModelField(useNull=true)
	private Long vo_179;
	@ModelField(useNull=true)
	private Long va_180;
	@ModelField(useNull=true)
	private Long rv_180;
	@ModelField(useNull=true)
	private Long vo_180;
	@ModelField(useNull=true)
	private Long va_181;
	@ModelField(useNull=true)
	private Long rv_181;
	@ModelField(useNull=true)
	private Long vo_181;
	@ModelField(useNull=true)
	private Long va_182;
	@ModelField(useNull=true)
	private Long rv_182;
	@ModelField(useNull=true)
	private Long vo_182;
	@ModelField(useNull=true)
	private Long va_183;
	@ModelField(useNull=true)
	private Long rv_183;
	@ModelField(useNull=true)
	private Long vo_183;
	@ModelField(useNull=true)
	private Long va_184;
	@ModelField(useNull=true)
	private Long rv_184;
	@ModelField(useNull=true)
	private Long vo_184;
	@ModelField(useNull=true)
	private Long va_185;
	@ModelField(useNull=true)
	private Long rv_185;
	@ModelField(useNull=true)
	private Long vo_185;
	@ModelField(useNull=true)
	private Long va_186;
	@ModelField(useNull=true)
	private Long rv_186;
	@ModelField(useNull=true)
	private Long vo_186;
	@ModelField(useNull=true)
	private Long va_187;
	@ModelField(useNull=true)
	private Long rv_187;
	@ModelField(useNull=true)
	private Long vo_187;
	@ModelField(useNull=true)
	private Long va_188;
	@ModelField(useNull=true)
	private Long rv_188;
	@ModelField(useNull=true)
	private Long vo_188;
	@ModelField(useNull=true)
	private Long va_189;
	@ModelField(useNull=true)
	private Long rv_189;
	@ModelField(useNull=true)
	private Long vo_189;
	@ModelField(useNull=true)
	private Long va_190;
	@ModelField(useNull=true)
	private Long rv_190;
	@ModelField(useNull=true)
	private Long vo_190;
	@ModelField(useNull=true)
	private Long va_191;
	@ModelField(useNull=true)
	private Long rv_191;
	@ModelField(useNull=true)
	private Long vo_191;
	@ModelField(useNull=true)
	private Long va_192;
	@ModelField(useNull=true)
	private Long rv_192;
	@ModelField(useNull=true)
	private Long vo_192;
	@ModelField(useNull=true)
	private Long va_193;
	@ModelField(useNull=true)
	private Long rv_193;
	@ModelField(useNull=true)
	private Long vo_193;
	@ModelField(useNull=true)
	private Long va_194;
	@ModelField(useNull=true)
	private Long rv_194;
	@ModelField(useNull=true)
	private Long vo_194;
	@ModelField(useNull=true)
	private Long va_195;
	@ModelField(useNull=true)
	private Long rv_195;
	@ModelField(useNull=true)
	private Long vo_195;
	@ModelField(useNull=true)
	private Long va_196;
	@ModelField(useNull=true)
	private Long rv_196;
	@ModelField(useNull=true)
	private Long vo_196;
	@ModelField(useNull=true)
	private Long va_197;
	@ModelField(useNull=true)
	private Long rv_197;
	@ModelField(useNull=true)
	private Long vo_197;
	@ModelField(useNull=true)
	private Long va_198;
	@ModelField(useNull=true)
	private Long rv_198;
	@ModelField(useNull=true)
	private Long vo_198;
	@ModelField(useNull=true)
	private Long va_199;
	@ModelField(useNull=true)
	private Long rv_199;
	@ModelField(useNull=true)
	private Long vo_199;
	@ModelField(useNull=true)
	private Long va_200;
	@ModelField(useNull=true)
	private Long rv_200;
	@ModelField(useNull=true)
	private Long vo_200;



	public GrigliaValutazioneRiga() {
		super();
	}

	public GrigliaValutazioneRiga(long alunno, String cognome, String nome,
			int assenze, int ritardi, int uscite, int fuori_classe, int note,
			int mancanze, String condotta) {
		super();
		this.alunno = alunno;
		this.cognome = cognome;
		this.nome = nome;
		this.assenze = assenze;
		this.ritardi = ritardi;
		this.uscite = uscite;
		this.fuori_classe = fuori_classe;
		this.note = note;
		this.mancanze = mancanze;
		this.condotta = condotta;
	}
	public void setValutazione(int i, Long rv, Long valutazione, Long voto) {
		switch(i){
		case 1:
			this.va_1 = valutazione;
			this.vo_1 = voto;
			this.rv_1 = rv;
			break;
		case 2:
			this.va_2 = valutazione;
			this.vo_2 = voto;
			this.rv_2 = rv;
			break;
		case 3:
			this.va_3 = valutazione;
			this.vo_3 = voto;
			this.rv_3 = rv;
			break;
		case 4:
			this.va_4 = valutazione;
			this.vo_4 = voto;
			this.rv_4 = rv;
			break;
		case 5:
			this.va_5 = valutazione;
			this.vo_5 = voto;
			this.rv_5 = rv;
			break;
		case 6:
			this.va_6 = valutazione;
			this.vo_6 = voto;
			this.rv_6 = rv;
			break;
		case 7:
			this.va_7 = valutazione;
			this.vo_7 = voto;
			this.rv_7 = rv;
			break;
		case 8:
			this.va_8 = valutazione;
			this.vo_8 = voto;
			this.rv_8 = rv;
			break;
		case 9:
			this.va_9 = valutazione;
			this.vo_9 = voto;
			this.rv_9 = rv;
			break;
		case 10:
			this.va_10 = valutazione;
			this.vo_10 = voto;
			this.rv_10 = rv;
			break;
		case 11:
			this.va_11 = valutazione;
			this.vo_11 = voto;
			this.rv_11 = rv;
			break;
		case 12:
			this.va_12 = valutazione;
			this.vo_12 = voto;
			this.rv_12 = rv;
			break;
		case 13:
			this.va_13 = valutazione;
			this.vo_13 = voto;
			this.rv_13 = rv;
			break;
		case 14:
			this.va_14 = valutazione;
			this.vo_14 = voto;
			this.rv_14 = rv;
			break;
		case 15:
			this.va_15 = valutazione;
			this.vo_15 = voto;
			this.rv_15 = rv;
			break;
		case 16:
			this.va_16 = valutazione;
			this.vo_16 = voto;
			this.rv_16 = rv;
			break;
		case 17:
			this.va_17 = valutazione;
			this.vo_17 = voto;
			this.rv_17 = rv;
			break;
		case 18:
			this.va_18 = valutazione;
			this.vo_18 = voto;
			this.rv_18 = rv;
			break;
		case 19:
			this.va_19 = valutazione;
			this.vo_19 = voto;
			this.rv_19 = rv;
			break;
		case 20:
			this.va_20 = valutazione;
			this.vo_20 = voto;
			this.rv_20 = rv;
			break;
		case 21:
			this.va_21 = valutazione;
			this.vo_21 = voto;
			this.rv_21 = rv;
			break;
		case 22:
			this.va_22 = valutazione;
			this.vo_22 = voto;
			this.rv_22 = rv;
			break;
		case 23:
			this.va_23 = valutazione;
			this.vo_23 = voto;
			this.rv_23 = rv;
			break;
		case 24:
			this.va_24 = valutazione;
			this.vo_24 = voto;
			this.rv_24 = rv;
			break;
		case 25:
			this.va_25 = valutazione;
			this.vo_25 = voto;
			this.rv_25 = rv;
			break;
		case 26:
			this.va_26 = valutazione;
			this.vo_26 = voto;
			this.rv_26 = rv;
			break;
		case 27:
			this.va_27 = valutazione;
			this.vo_27 = voto;
			this.rv_27 = rv;
			break;
		case 28:
			this.va_28 = valutazione;
			this.vo_28 = voto;
			this.rv_28 = rv;
			break;
		case 29:
			this.va_29 = valutazione;
			this.vo_29 = voto;
			this.rv_29 = rv;
			break;
		case 30:
			this.va_30 = valutazione;
			this.vo_30 = voto;
			this.rv_30 = rv;
			break;
		case 31:
			this.va_31 = valutazione;
			this.vo_31 = voto;
			this.rv_31 = rv;
			break;
		case 32:
			this.va_32 = valutazione;
			this.vo_32 = voto;
			this.rv_32 = rv;
			break;
		case 33:
			this.va_33 = valutazione;
			this.vo_33 = voto;
			this.rv_33 = rv;
			break;
		case 34:
			this.va_34 = valutazione;
			this.vo_34 = voto;
			this.rv_34 = rv;
			break;
		case 35:
			this.va_35 = valutazione;
			this.vo_35 = voto;
			this.rv_35 = rv;
			break;
		case 36:
			this.va_36 = valutazione;
			this.vo_36 = voto;
			this.rv_36 = rv;
			break;
		case 37:
			this.va_37 = valutazione;
			this.vo_37 = voto;
			this.rv_37 = rv;
			break;
		case 38:
			this.va_38 = valutazione;
			this.vo_38 = voto;
			this.rv_38 = rv;
			break;
		case 39:
			this.va_39 = valutazione;
			this.vo_39 = voto;
			this.rv_39 = rv;
			break;
		case 40:
			this.va_40 = valutazione;
			this.vo_40 = voto;
			this.rv_40 = rv;
			break;
		case 41:
			this.va_41 = valutazione;
			this.vo_41 = voto;
			this.rv_41 = rv;
			break;
		case 42:
			this.va_42 = valutazione;
			this.vo_42 = voto;
			this.rv_42 = rv;
			break;
		case 43:
			this.va_43 = valutazione;
			this.vo_43 = voto;
			this.rv_43 = rv;
			break;
		case 44:
			this.va_44 = valutazione;
			this.vo_44 = voto;
			this.rv_44 = rv;
			break;
		case 45:
			this.va_45 = valutazione;
			this.vo_45 = voto;
			this.rv_45 = rv;
			break;
		case 46:
			this.va_46 = valutazione;
			this.vo_46 = voto;
			this.rv_46 = rv;
			break;
		case 47:
			this.va_47 = valutazione;
			this.vo_47 = voto;
			this.rv_47 = rv;
			break;
		case 48:
			this.va_48 = valutazione;
			this.vo_48 = voto;
			this.rv_48 = rv;
			break;
		case 49:
			this.va_49 = valutazione;
			this.vo_49 = voto;
			this.rv_49 = rv;
			break;
		case 50:
			this.va_50 = valutazione;
			this.vo_50 = voto;
			this.rv_50 = rv;
			break;
		case 51:
			this.va_51 = valutazione;
			this.vo_51 = voto;
			this.rv_51 = rv;
			break;
		case 52:
			this.va_52 = valutazione;
			this.vo_52 = voto;
			this.rv_52 = rv;
			break;
		case 53:
			this.va_53 = valutazione;
			this.vo_53 = voto;
			this.rv_53 = rv;
			break;
		case 54:
			this.va_54 = valutazione;
			this.vo_54 = voto;
			this.rv_54 = rv;
			break;
		case 55:
			this.va_55 = valutazione;
			this.vo_55 = voto;
			this.rv_55 = rv;
			break;
		case 56:
			this.va_56 = valutazione;
			this.vo_56 = voto;
			this.rv_56 = rv;
			break;
		case 57:
			this.va_57 = valutazione;
			this.vo_57 = voto;
			this.rv_57 = rv;
			break;
		case 58:
			this.va_58 = valutazione;
			this.vo_58 = voto;
			this.rv_58 = rv;
			break;
		case 59:
			this.va_59 = valutazione;
			this.vo_59 = voto;
			this.rv_59 = rv;
			break;
		case 60:
			this.va_60 = valutazione;
			this.vo_60 = voto;
			this.rv_60 = rv;
			break;
		case 61:
			this.va_61 = valutazione;
			this.vo_61 = voto;
			this.rv_61 = rv;
			break;
		case 62:
			this.va_62 = valutazione;
			this.vo_62 = voto;
			this.rv_62 = rv;
			break;
		case 63:
			this.va_63 = valutazione;
			this.vo_63 = voto;
			this.rv_63 = rv;
			break;
		case 64:
			this.va_64 = valutazione;
			this.vo_64 = voto;
			this.rv_64 = rv;
			break;
		case 65:
			this.va_65 = valutazione;
			this.vo_65 = voto;
			this.rv_65 = rv;
			break;
		case 66:
			this.va_66 = valutazione;
			this.vo_66 = voto;
			this.rv_66 = rv;
			break;
		case 67:
			this.va_67 = valutazione;
			this.vo_67 = voto;
			this.rv_67 = rv;
			break;
		case 68:
			this.va_68 = valutazione;
			this.vo_68 = voto;
			this.rv_68 = rv;
			break;
		case 69:
			this.va_69 = valutazione;
			this.vo_69 = voto;
			this.rv_69 = rv;
			break;
		case 70:
			this.va_70 = valutazione;
			this.vo_70 = voto;
			this.rv_70 = rv;
			break;
		case 71:
			this.va_71 = valutazione;
			this.vo_71 = voto;
			this.rv_71 = rv;
			break;
		case 72:
			this.va_72 = valutazione;
			this.vo_72 = voto;
			this.rv_72 = rv;
			break;
		case 73:
			this.va_73 = valutazione;
			this.vo_73 = voto;
			this.rv_73 = rv;
			break;
		case 74:
			this.va_74 = valutazione;
			this.vo_74 = voto;
			this.rv_74 = rv;
			break;
		case 75:
			this.va_75 = valutazione;
			this.vo_75 = voto;
			this.rv_75 = rv;
			break;
		case 76:
			this.va_76 = valutazione;
			this.vo_76 = voto;
			this.rv_76 = rv;
			break;
		case 77:
			this.va_77 = valutazione;
			this.vo_77 = voto;
			this.rv_77 = rv;
			break;
		case 78:
			this.va_78 = valutazione;
			this.vo_78 = voto;
			this.rv_78 = rv;
			break;
		case 79:
			this.va_79 = valutazione;
			this.vo_79 = voto;
			this.rv_79 = rv;
			break;
		case 80:
			this.va_80 = valutazione;
			this.vo_80 = voto;
			this.rv_80 = rv;
			break;
		case 81:
			this.va_81 = valutazione;
			this.vo_81 = voto;
			this.rv_81 = rv;
			break;
		case 82:
			this.va_82 = valutazione;
			this.vo_82 = voto;
			this.rv_82 = rv;
			break;
		case 83:
			this.va_83 = valutazione;
			this.vo_83 = voto;
			this.rv_83 = rv;
			break;
		case 84:
			this.va_84 = valutazione;
			this.vo_84 = voto;
			this.rv_84 = rv;
			break;
		case 85:
			this.va_85 = valutazione;
			this.vo_85 = voto;
			this.rv_85 = rv;
			break;
		case 86:
			this.va_86 = valutazione;
			this.vo_86 = voto;
			this.rv_86 = rv;
			break;
		case 87:
			this.va_87 = valutazione;
			this.vo_87 = voto;
			this.rv_87 = rv;
			break;
		case 88:
			this.va_88 = valutazione;
			this.vo_88 = voto;
			this.rv_88 = rv;
			break;
		case 89:
			this.va_89 = valutazione;
			this.vo_89 = voto;
			this.rv_89 = rv;
			break;
		case 90:
			this.va_90 = valutazione;
			this.vo_90 = voto;
			this.rv_90 = rv;
			break;
		case 91:
			this.va_91 = valutazione;
			this.vo_91 = voto;
			this.rv_91 = rv;
			break;
		case 92:
			this.va_92 = valutazione;
			this.vo_92 = voto;
			this.rv_92 = rv;
			break;
		case 93:
			this.va_93 = valutazione;
			this.vo_93 = voto;
			this.rv_93 = rv;
			break;
		case 94:
			this.va_94 = valutazione;
			this.vo_94 = voto;
			this.rv_94 = rv;
			break;
		case 95:
			this.va_95 = valutazione;
			this.vo_95 = voto;
			this.rv_95 = rv;
			break;
		case 96:
			this.va_96 = valutazione;
			this.vo_96 = voto;
			this.rv_96 = rv;
			break;
		case 97:
			this.va_97 = valutazione;
			this.vo_97 = voto;
			this.rv_97 = rv;
			break;
		case 98:
			this.va_98 = valutazione;
			this.vo_98 = voto;
			this.rv_98 = rv;
			break;
		case 99:
			this.va_99 = valutazione;
			this.vo_99 = voto;
			this.rv_99 = rv;
			break;
		case 100:
			this.va_100 = valutazione;
			this.vo_100 = voto;
			this.rv_100 = rv;
			break;
		case 101:
			this.va_101 = valutazione;
			this.vo_101 = voto;
			this.rv_101 = rv;
			break;
		case 102:
			this.va_102 = valutazione;
			this.vo_102 = voto;
			this.rv_102 = rv;
			break;
		case 103:
			this.va_103 = valutazione;
			this.vo_103 = voto;
			this.rv_103 = rv;
			break;
		case 104:
			this.va_104 = valutazione;
			this.vo_104 = voto;
			this.rv_104 = rv;
			break;
		case 105:
			this.va_105 = valutazione;
			this.vo_105 = voto;
			this.rv_105 = rv;
			break;
		case 106:
			this.va_106 = valutazione;
			this.vo_106 = voto;
			this.rv_106 = rv;
			break;
		case 107:
			this.va_107 = valutazione;
			this.vo_107 = voto;
			this.rv_107 = rv;
			break;
		case 108:
			this.va_108 = valutazione;
			this.vo_108 = voto;
			this.rv_108 = rv;
			break;
		case 109:
			this.va_109 = valutazione;
			this.vo_109 = voto;
			this.rv_109 = rv;
			break;
		case 110:
			this.va_110 = valutazione;
			this.vo_110 = voto;
			this.rv_110 = rv;
			break;
		case 111:
			this.va_111 = valutazione;
			this.vo_111 = voto;
			this.rv_111 = rv;
			break;
		case 112:
			this.va_112 = valutazione;
			this.vo_112 = voto;
			this.rv_112 = rv;
			break;
		case 113:
			this.va_113 = valutazione;
			this.vo_113 = voto;
			this.rv_113 = rv;
			break;
		case 114:
			this.va_114 = valutazione;
			this.vo_114 = voto;
			this.rv_114 = rv;
			break;
		case 115:
			this.va_115 = valutazione;
			this.vo_115 = voto;
			this.rv_115 = rv;
			break;
		case 116:
			this.va_116 = valutazione;
			this.vo_116 = voto;
			this.rv_116 = rv;
			break;
		case 117:
			this.va_117 = valutazione;
			this.vo_117 = voto;
			this.rv_117 = rv;
			break;
		case 118:
			this.va_118 = valutazione;
			this.vo_118 = voto;
			this.rv_118 = rv;
			break;
		case 119:
			this.va_119 = valutazione;
			this.vo_119 = voto;
			this.rv_119 = rv;
			break;
		case 120:
			this.va_120 = valutazione;
			this.vo_120 = voto;
			this.rv_120 = rv;
			break;
		case 121:
			this.va_121 = valutazione;
			this.vo_121 = voto;
			this.rv_121 = rv;
			break;
		case 122:
			this.va_122 = valutazione;
			this.vo_122 = voto;
			this.rv_122 = rv;
			break;
		case 123:
			this.va_123 = valutazione;
			this.vo_123 = voto;
			this.rv_123 = rv;
			break;
		case 124:
			this.va_124 = valutazione;
			this.vo_124 = voto;
			this.rv_124 = rv;
			break;
		case 125:
			this.va_125 = valutazione;
			this.vo_125 = voto;
			this.rv_125 = rv;
			break;
		case 126:
			this.va_126 = valutazione;
			this.vo_126 = voto;
			this.rv_126 = rv;
			break;
		case 127:
			this.va_127 = valutazione;
			this.vo_127 = voto;
			this.rv_127 = rv;
			break;
		case 128:
			this.va_128 = valutazione;
			this.vo_128 = voto;
			this.rv_128 = rv;
			break;
		case 129:
			this.va_129 = valutazione;
			this.vo_129 = voto;
			this.rv_129 = rv;
			break;
		case 130:
			this.va_130 = valutazione;
			this.vo_130 = voto;
			this.rv_130 = rv;
			break;
		case 131:
			this.va_131 = valutazione;
			this.vo_131 = voto;
			this.rv_131 = rv;
			break;
		case 132:
			this.va_132 = valutazione;
			this.vo_132 = voto;
			this.rv_132 = rv;
			break;
		case 133:
			this.va_133 = valutazione;
			this.vo_133 = voto;
			this.rv_133 = rv;
			break;
		case 134:
			this.va_134 = valutazione;
			this.vo_134 = voto;
			this.rv_134 = rv;
			break;
		case 135:
			this.va_135 = valutazione;
			this.vo_135 = voto;
			this.rv_135 = rv;
			break;
		case 136:
			this.va_136 = valutazione;
			this.vo_136 = voto;
			this.rv_136 = rv;
			break;
		case 137:
			this.va_137 = valutazione;
			this.vo_137 = voto;
			this.rv_137 = rv;
			break;
		case 138:
			this.va_138 = valutazione;
			this.vo_138 = voto;
			this.rv_138 = rv;
			break;
		case 139:
			this.va_139 = valutazione;
			this.vo_139 = voto;
			this.rv_139 = rv;
			break;
		case 140:
			this.va_140 = valutazione;
			this.vo_140 = voto;
			this.rv_140 = rv;
			break;
		case 141:
			this.va_141 = valutazione;
			this.vo_141 = voto;
			this.rv_141 = rv;
			break;
		case 142:
			this.va_142 = valutazione;
			this.vo_142 = voto;
			this.rv_142 = rv;
			break;
		case 143:
			this.va_143 = valutazione;
			this.vo_143 = voto;
			this.rv_143 = rv;
			break;
		case 144:
			this.va_144 = valutazione;
			this.vo_144 = voto;
			this.rv_144 = rv;
			break;
		case 145:
			this.va_145 = valutazione;
			this.vo_145 = voto;
			this.rv_145 = rv;
			break;
		case 146:
			this.va_146 = valutazione;
			this.vo_146 = voto;
			this.rv_146 = rv;
			break;
		case 147:
			this.va_147 = valutazione;
			this.vo_147 = voto;
			this.rv_147 = rv;
			break;
		case 148:
			this.va_148 = valutazione;
			this.vo_148 = voto;
			this.rv_148 = rv;
			break;
		case 149:
			this.va_149 = valutazione;
			this.vo_149 = voto;
			this.rv_149 = rv;
			break;
		case 150:
			this.va_150 = valutazione;
			this.vo_150 = voto;
			this.rv_150 = rv;
			break;
		case 151:
			this.va_151 = valutazione;
			this.vo_151 = voto;
			this.rv_151 = rv;
			break;
		case 152:
			this.va_152 = valutazione;
			this.vo_152 = voto;
			this.rv_152 = rv;
			break;
		case 153:
			this.va_153 = valutazione;
			this.vo_153 = voto;
			this.rv_153 = rv;
			break;
		case 154:
			this.va_154 = valutazione;
			this.vo_154 = voto;
			this.rv_154 = rv;
			break;
		case 155:
			this.va_155 = valutazione;
			this.vo_155 = voto;
			this.rv_155 = rv;
			break;
		case 156:
			this.va_156 = valutazione;
			this.vo_156 = voto;
			this.rv_156 = rv;
			break;
		case 157:
			this.va_157 = valutazione;
			this.vo_157 = voto;
			this.rv_157 = rv;
			break;
		case 158:
			this.va_158 = valutazione;
			this.vo_158 = voto;
			this.rv_158 = rv;
			break;
		case 159:
			this.va_159 = valutazione;
			this.vo_159 = voto;
			this.rv_159 = rv;
			break;
		case 160:
			this.va_160 = valutazione;
			this.vo_160 = voto;
			this.rv_160 = rv;
			break;
		case 161:
			this.va_161 = valutazione;
			this.vo_161 = voto;
			this.rv_161 = rv;
			break;
		case 162:
			this.va_162 = valutazione;
			this.vo_162 = voto;
			this.rv_162 = rv;
			break;
		case 163:
			this.va_163 = valutazione;
			this.vo_163 = voto;
			this.rv_163 = rv;
			break;
		case 164:
			this.va_164 = valutazione;
			this.vo_164 = voto;
			this.rv_164 = rv;
			break;
		case 165:
			this.va_165 = valutazione;
			this.vo_165 = voto;
			this.rv_165 = rv;
			break;
		case 166:
			this.va_166 = valutazione;
			this.vo_166 = voto;
			this.rv_166 = rv;
			break;
		case 167:
			this.va_167 = valutazione;
			this.vo_167 = voto;
			this.rv_167 = rv;
			break;
		case 168:
			this.va_168 = valutazione;
			this.vo_168 = voto;
			this.rv_168 = rv;
			break;
		case 169:
			this.va_169 = valutazione;
			this.vo_169 = voto;
			this.rv_169 = rv;
			break;
		case 170:
			this.va_170 = valutazione;
			this.vo_170 = voto;
			this.rv_170 = rv;
			break;
		case 171:
			this.va_171 = valutazione;
			this.vo_171 = voto;
			this.rv_171 = rv;
			break;
		case 172:
			this.va_172 = valutazione;
			this.vo_172 = voto;
			this.rv_172 = rv;
			break;
		case 173:
			this.va_173 = valutazione;
			this.vo_173 = voto;
			this.rv_173 = rv;
			break;
		case 174:
			this.va_174 = valutazione;
			this.vo_174 = voto;
			this.rv_174 = rv;
			break;
		case 175:
			this.va_175 = valutazione;
			this.vo_175 = voto;
			this.rv_175 = rv;
			break;
		case 176:
			this.va_176 = valutazione;
			this.vo_176 = voto;
			this.rv_176 = rv;
			break;
		case 177:
			this.va_177 = valutazione;
			this.vo_177 = voto;
			this.rv_177 = rv;
			break;
		case 178:
			this.va_178 = valutazione;
			this.vo_178 = voto;
			this.rv_178 = rv;
			break;
		case 179:
			this.va_179 = valutazione;
			this.vo_179 = voto;
			this.rv_179 = rv;
			break;
		case 180:
			this.va_180 = valutazione;
			this.vo_180 = voto;
			this.rv_180 = rv;
			break;
		case 181:
			this.va_181 = valutazione;
			this.vo_181 = voto;
			this.rv_181 = rv;
			break;
		case 182:
			this.va_182 = valutazione;
			this.vo_182 = voto;
			this.rv_182 = rv;
			break;
		case 183:
			this.va_183 = valutazione;
			this.vo_183 = voto;
			this.rv_183 = rv;
			break;
		case 184:
			this.va_184 = valutazione;
			this.vo_184 = voto;
			this.rv_184 = rv;
			break;
		case 185:
			this.va_185 = valutazione;
			this.vo_185 = voto;
			this.rv_185 = rv;
			break;
		case 186:
			this.va_186 = valutazione;
			this.vo_186 = voto;
			this.rv_186 = rv;
			break;
		case 187:
			this.va_187 = valutazione;
			this.vo_187 = voto;
			this.rv_187 = rv;
			break;
		case 188:
			this.va_188 = valutazione;
			this.vo_188 = voto;
			this.rv_188 = rv;
			break;
		case 189:
			this.va_189 = valutazione;
			this.vo_189 = voto;
			this.rv_189 = rv;
			break;
		case 190:
			this.va_190 = valutazione;
			this.vo_190 = voto;
			this.rv_190 = rv;
			break;
		case 191:
			this.va_191 = valutazione;
			this.vo_191 = voto;
			this.rv_191 = rv;
			break;
		case 192:
			this.va_192 = valutazione;
			this.vo_192 = voto;
			this.rv_192 = rv;
			break;
		case 193:
			this.va_193 = valutazione;
			this.vo_193 = voto;
			this.rv_193 = rv;
			break;
		case 194:
			this.va_194 = valutazione;
			this.vo_194 = voto;
			this.rv_194 = rv;
			break;
		case 195:
			this.va_195 = valutazione;
			this.vo_195 = voto;
			this.rv_195 = rv;
			break;
		case 196:
			this.va_196 = valutazione;
			this.vo_196 = voto;
			this.rv_196 = rv;
			break;
		case 197:
			this.va_197 = valutazione;
			this.vo_197 = voto;
			this.rv_197 = rv;
			break;
		case 198:
			this.va_198 = valutazione;
			this.vo_198 = voto;
			this.rv_198 = rv;
			break;
		case 199:
			this.va_199 = valutazione;
			this.vo_199 = voto;
			this.rv_199 = rv;
			break;
		case 200:
			this.va_200 = valutazione;
			this.vo_200 = voto;
			this.rv_200 = rv;
			break;

		}
	}

	public long getAlunno() {
		return alunno;
	}

	public void setAlunno(long alunno) {
		this.alunno = alunno;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAssenze() {
		return assenze;
	}

	public void setAssenze(int assenze) {
		this.assenze = assenze;
	}

	public int getRitardi() {
		return ritardi;
	}

	public void setRitardi(int ritardi) {
		this.ritardi = ritardi;
	}

	public int getUscite() {
		return uscite;
	}

	public void setUscite(int uscite) {
		this.uscite = uscite;
	}

	public int getFuori_classe() {
		return fuori_classe;
	}

	public void setFuori_classe(int fuori_classe) {
		this.fuori_classe = fuori_classe;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getMancanze() {
		return mancanze;
	}

	public void setMancanze(int mancanze) {
		this.mancanze = mancanze;
	}

	public String getCondotta() {
		return condotta;
	}

	public void setCondotta(String condotta) {
		this.condotta = condotta;
	}

	public Long getVa_1() {
		return va_1;
	}

	public void setVa_1(Long va_1) {
		this.va_1 = va_1;
	}

	public Long getRv_1() {
		return rv_1;
	}

	public void setRv_1(Long rv_1) {
		this.rv_1 = rv_1;
	}

	public Long getVo_1() {
		return vo_1;
	}

	public void setVo_1(Long vo_1) {
		this.vo_1 = vo_1;
	}

	public Long getVa_2() {
		return va_2;
	}

	public void setVa_2(Long va_2) {
		this.va_2 = va_2;
	}

	public Long getRv_2() {
		return rv_2;
	}

	public void setRv_2(Long rv_2) {
		this.rv_2 = rv_2;
	}

	public Long getVo_2() {
		return vo_2;
	}

	public void setVo_2(Long vo_2) {
		this.vo_2 = vo_2;
	}

	public Long getVa_3() {
		return va_3;
	}

	public void setVa_3(Long va_3) {
		this.va_3 = va_3;
	}

	public Long getRv_3() {
		return rv_3;
	}

	public void setRv_3(Long rv_3) {
		this.rv_3 = rv_3;
	}

	public Long getVo_3() {
		return vo_3;
	}

	public void setVo_3(Long vo_3) {
		this.vo_3 = vo_3;
	}

	public Long getVa_4() {
		return va_4;
	}

	public void setVa_4(Long va_4) {
		this.va_4 = va_4;
	}

	public Long getRv_4() {
		return rv_4;
	}

	public void setRv_4(Long rv_4) {
		this.rv_4 = rv_4;
	}

	public Long getVo_4() {
		return vo_4;
	}

	public void setVo_4(Long vo_4) {
		this.vo_4 = vo_4;
	}

	public Long getVa_5() {
		return va_5;
	}

	public void setVa_5(Long va_5) {
		this.va_5 = va_5;
	}

	public Long getRv_5() {
		return rv_5;
	}

	public void setRv_5(Long rv_5) {
		this.rv_5 = rv_5;
	}

	public Long getVo_5() {
		return vo_5;
	}

	public void setVo_5(Long vo_5) {
		this.vo_5 = vo_5;
	}

	public Long getVa_6() {
		return va_6;
	}

	public void setVa_6(Long va_6) {
		this.va_6 = va_6;
	}

	public Long getRv_6() {
		return rv_6;
	}

	public void setRv_6(Long rv_6) {
		this.rv_6 = rv_6;
	}

	public Long getVo_6() {
		return vo_6;
	}

	public void setVo_6(Long vo_6) {
		this.vo_6 = vo_6;
	}

	public Long getVa_7() {
		return va_7;
	}

	public void setVa_7(Long va_7) {
		this.va_7 = va_7;
	}

	public Long getRv_7() {
		return rv_7;
	}

	public void setRv_7(Long rv_7) {
		this.rv_7 = rv_7;
	}

	public Long getVo_7() {
		return vo_7;
	}

	public void setVo_7(Long vo_7) {
		this.vo_7 = vo_7;
	}

	public Long getVa_8() {
		return va_8;
	}

	public void setVa_8(Long va_8) {
		this.va_8 = va_8;
	}

	public Long getRv_8() {
		return rv_8;
	}

	public void setRv_8(Long rv_8) {
		this.rv_8 = rv_8;
	}

	public Long getVo_8() {
		return vo_8;
	}

	public void setVo_8(Long vo_8) {
		this.vo_8 = vo_8;
	}

	public Long getVa_9() {
		return va_9;
	}

	public void setVa_9(Long va_9) {
		this.va_9 = va_9;
	}

	public Long getRv_9() {
		return rv_9;
	}

	public void setRv_9(Long rv_9) {
		this.rv_9 = rv_9;
	}

	public Long getVo_9() {
		return vo_9;
	}

	public void setVo_9(Long vo_9) {
		this.vo_9 = vo_9;
	}

	public Long getVa_10() {
		return va_10;
	}

	public void setVa_10(Long va_10) {
		this.va_10 = va_10;
	}

	public Long getRv_10() {
		return rv_10;
	}

	public void setRv_10(Long rv_10) {
		this.rv_10 = rv_10;
	}

	public Long getVo_10() {
		return vo_10;
	}

	public void setVo_10(Long vo_10) {
		this.vo_10 = vo_10;
	}

	public Long getVa_11() {
		return va_11;
	}

	public void setVa_11(Long va_11) {
		this.va_11 = va_11;
	}

	public Long getRv_11() {
		return rv_11;
	}

	public void setRv_11(Long rv_11) {
		this.rv_11 = rv_11;
	}

	public Long getVo_11() {
		return vo_11;
	}

	public void setVo_11(Long vo_11) {
		this.vo_11 = vo_11;
	}

	public Long getVa_12() {
		return va_12;
	}

	public void setVa_12(Long va_12) {
		this.va_12 = va_12;
	}

	public Long getRv_12() {
		return rv_12;
	}

	public void setRv_12(Long rv_12) {
		this.rv_12 = rv_12;
	}

	public Long getVo_12() {
		return vo_12;
	}

	public void setVo_12(Long vo_12) {
		this.vo_12 = vo_12;
	}

	public Long getVa_13() {
		return va_13;
	}

	public void setVa_13(Long va_13) {
		this.va_13 = va_13;
	}

	public Long getRv_13() {
		return rv_13;
	}

	public void setRv_13(Long rv_13) {
		this.rv_13 = rv_13;
	}

	public Long getVo_13() {
		return vo_13;
	}

	public void setVo_13(Long vo_13) {
		this.vo_13 = vo_13;
	}

	public Long getVa_14() {
		return va_14;
	}

	public void setVa_14(Long va_14) {
		this.va_14 = va_14;
	}

	public Long getRv_14() {
		return rv_14;
	}

	public void setRv_14(Long rv_14) {
		this.rv_14 = rv_14;
	}

	public Long getVo_14() {
		return vo_14;
	}

	public void setVo_14(Long vo_14) {
		this.vo_14 = vo_14;
	}

	public Long getVa_15() {
		return va_15;
	}

	public void setVa_15(Long va_15) {
		this.va_15 = va_15;
	}

	public Long getRv_15() {
		return rv_15;
	}

	public void setRv_15(Long rv_15) {
		this.rv_15 = rv_15;
	}

	public Long getVo_15() {
		return vo_15;
	}

	public void setVo_15(Long vo_15) {
		this.vo_15 = vo_15;
	}

	public Long getVa_16() {
		return va_16;
	}

	public void setVa_16(Long va_16) {
		this.va_16 = va_16;
	}

	public Long getRv_16() {
		return rv_16;
	}

	public void setRv_16(Long rv_16) {
		this.rv_16 = rv_16;
	}

	public Long getVo_16() {
		return vo_16;
	}

	public void setVo_16(Long vo_16) {
		this.vo_16 = vo_16;
	}

	public Long getVa_17() {
		return va_17;
	}

	public void setVa_17(Long va_17) {
		this.va_17 = va_17;
	}

	public Long getRv_17() {
		return rv_17;
	}

	public void setRv_17(Long rv_17) {
		this.rv_17 = rv_17;
	}

	public Long getVo_17() {
		return vo_17;
	}

	public void setVo_17(Long vo_17) {
		this.vo_17 = vo_17;
	}

	public Long getVa_18() {
		return va_18;
	}

	public void setVa_18(Long va_18) {
		this.va_18 = va_18;
	}

	public Long getRv_18() {
		return rv_18;
	}

	public void setRv_18(Long rv_18) {
		this.rv_18 = rv_18;
	}

	public Long getVo_18() {
		return vo_18;
	}

	public void setVo_18(Long vo_18) {
		this.vo_18 = vo_18;
	}

	public Long getVa_19() {
		return va_19;
	}

	public void setVa_19(Long va_19) {
		this.va_19 = va_19;
	}

	public Long getRv_19() {
		return rv_19;
	}

	public void setRv_19(Long rv_19) {
		this.rv_19 = rv_19;
	}

	public Long getVo_19() {
		return vo_19;
	}

	public void setVo_19(Long vo_19) {
		this.vo_19 = vo_19;
	}

	public Long getVa_20() {
		return va_20;
	}

	public void setVa_20(Long va_20) {
		this.va_20 = va_20;
	}

	public Long getRv_20() {
		return rv_20;
	}

	public void setRv_20(Long rv_20) {
		this.rv_20 = rv_20;
	}

	public Long getVo_20() {
		return vo_20;
	}

	public void setVo_20(Long vo_20) {
		this.vo_20 = vo_20;
	}

	public Long getVa_21() {
		return va_21;
	}

	public void setVa_21(Long va_21) {
		this.va_21 = va_21;
	}

	public Long getRv_21() {
		return rv_21;
	}

	public void setRv_21(Long rv_21) {
		this.rv_21 = rv_21;
	}

	public Long getVo_21() {
		return vo_21;
	}

	public void setVo_21(Long vo_21) {
		this.vo_21 = vo_21;
	}

	public Long getVa_22() {
		return va_22;
	}

	public void setVa_22(Long va_22) {
		this.va_22 = va_22;
	}

	public Long getRv_22() {
		return rv_22;
	}

	public void setRv_22(Long rv_22) {
		this.rv_22 = rv_22;
	}

	public Long getVo_22() {
		return vo_22;
	}

	public void setVo_22(Long vo_22) {
		this.vo_22 = vo_22;
	}

	public Long getVa_23() {
		return va_23;
	}

	public void setVa_23(Long va_23) {
		this.va_23 = va_23;
	}

	public Long getRv_23() {
		return rv_23;
	}

	public void setRv_23(Long rv_23) {
		this.rv_23 = rv_23;
	}

	public Long getVo_23() {
		return vo_23;
	}

	public void setVo_23(Long vo_23) {
		this.vo_23 = vo_23;
	}

	public Long getVa_24() {
		return va_24;
	}

	public void setVa_24(Long va_24) {
		this.va_24 = va_24;
	}

	public Long getRv_24() {
		return rv_24;
	}

	public void setRv_24(Long rv_24) {
		this.rv_24 = rv_24;
	}

	public Long getVo_24() {
		return vo_24;
	}

	public void setVo_24(Long vo_24) {
		this.vo_24 = vo_24;
	}

	public Long getVa_25() {
		return va_25;
	}

	public void setVa_25(Long va_25) {
		this.va_25 = va_25;
	}

	public Long getRv_25() {
		return rv_25;
	}

	public void setRv_25(Long rv_25) {
		this.rv_25 = rv_25;
	}

	public Long getVo_25() {
		return vo_25;
	}

	public void setVo_25(Long vo_25) {
		this.vo_25 = vo_25;
	}

	public Long getVa_26() {
		return va_26;
	}

	public void setVa_26(Long va_26) {
		this.va_26 = va_26;
	}

	public Long getRv_26() {
		return rv_26;
	}

	public void setRv_26(Long rv_26) {
		this.rv_26 = rv_26;
	}

	public Long getVo_26() {
		return vo_26;
	}

	public void setVo_26(Long vo_26) {
		this.vo_26 = vo_26;
	}

	public Long getVa_27() {
		return va_27;
	}

	public void setVa_27(Long va_27) {
		this.va_27 = va_27;
	}

	public Long getRv_27() {
		return rv_27;
	}

	public void setRv_27(Long rv_27) {
		this.rv_27 = rv_27;
	}

	public Long getVo_27() {
		return vo_27;
	}

	public void setVo_27(Long vo_27) {
		this.vo_27 = vo_27;
	}

	public Long getVa_28() {
		return va_28;
	}

	public void setVa_28(Long va_28) {
		this.va_28 = va_28;
	}

	public Long getRv_28() {
		return rv_28;
	}

	public void setRv_28(Long rv_28) {
		this.rv_28 = rv_28;
	}

	public Long getVo_28() {
		return vo_28;
	}

	public void setVo_28(Long vo_28) {
		this.vo_28 = vo_28;
	}

	public Long getVa_29() {
		return va_29;
	}

	public void setVa_29(Long va_29) {
		this.va_29 = va_29;
	}

	public Long getRv_29() {
		return rv_29;
	}

	public void setRv_29(Long rv_29) {
		this.rv_29 = rv_29;
	}

	public Long getVo_29() {
		return vo_29;
	}

	public void setVo_29(Long vo_29) {
		this.vo_29 = vo_29;
	}

	public Long getVa_30() {
		return va_30;
	}

	public void setVa_30(Long va_30) {
		this.va_30 = va_30;
	}

	public Long getRv_30() {
		return rv_30;
	}

	public void setRv_30(Long rv_30) {
		this.rv_30 = rv_30;
	}

	public Long getVo_30() {
		return vo_30;
	}

	public void setVo_30(Long vo_30) {
		this.vo_30 = vo_30;
	}

	public Long getVa_31() {
		return va_31;
	}

	public void setVa_31(Long va_31) {
		this.va_31 = va_31;
	}

	public Long getRv_31() {
		return rv_31;
	}

	public void setRv_31(Long rv_31) {
		this.rv_31 = rv_31;
	}

	public Long getVo_31() {
		return vo_31;
	}

	public void setVo_31(Long vo_31) {
		this.vo_31 = vo_31;
	}

	public Long getVa_32() {
		return va_32;
	}

	public void setVa_32(Long va_32) {
		this.va_32 = va_32;
	}

	public Long getRv_32() {
		return rv_32;
	}

	public void setRv_32(Long rv_32) {
		this.rv_32 = rv_32;
	}

	public Long getVo_32() {
		return vo_32;
	}

	public void setVo_32(Long vo_32) {
		this.vo_32 = vo_32;
	}

	public Long getVa_33() {
		return va_33;
	}

	public void setVa_33(Long va_33) {
		this.va_33 = va_33;
	}

	public Long getRv_33() {
		return rv_33;
	}

	public void setRv_33(Long rv_33) {
		this.rv_33 = rv_33;
	}

	public Long getVo_33() {
		return vo_33;
	}

	public void setVo_33(Long vo_33) {
		this.vo_33 = vo_33;
	}

	public Long getVa_34() {
		return va_34;
	}

	public void setVa_34(Long va_34) {
		this.va_34 = va_34;
	}

	public Long getRv_34() {
		return rv_34;
	}

	public void setRv_34(Long rv_34) {
		this.rv_34 = rv_34;
	}

	public Long getVo_34() {
		return vo_34;
	}

	public void setVo_34(Long vo_34) {
		this.vo_34 = vo_34;
	}

	public Long getVa_35() {
		return va_35;
	}

	public void setVa_35(Long va_35) {
		this.va_35 = va_35;
	}

	public Long getRv_35() {
		return rv_35;
	}

	public void setRv_35(Long rv_35) {
		this.rv_35 = rv_35;
	}

	public Long getVo_35() {
		return vo_35;
	}

	public void setVo_35(Long vo_35) {
		this.vo_35 = vo_35;
	}

	public Long getVa_36() {
		return va_36;
	}

	public void setVa_36(Long va_36) {
		this.va_36 = va_36;
	}

	public Long getRv_36() {
		return rv_36;
	}

	public void setRv_36(Long rv_36) {
		this.rv_36 = rv_36;
	}

	public Long getVo_36() {
		return vo_36;
	}

	public void setVo_36(Long vo_36) {
		this.vo_36 = vo_36;
	}

	public Long getVa_37() {
		return va_37;
	}

	public void setVa_37(Long va_37) {
		this.va_37 = va_37;
	}

	public Long getRv_37() {
		return rv_37;
	}

	public void setRv_37(Long rv_37) {
		this.rv_37 = rv_37;
	}

	public Long getVo_37() {
		return vo_37;
	}

	public void setVo_37(Long vo_37) {
		this.vo_37 = vo_37;
	}

	public Long getVa_38() {
		return va_38;
	}

	public void setVa_38(Long va_38) {
		this.va_38 = va_38;
	}

	public Long getRv_38() {
		return rv_38;
	}

	public void setRv_38(Long rv_38) {
		this.rv_38 = rv_38;
	}

	public Long getVo_38() {
		return vo_38;
	}

	public void setVo_38(Long vo_38) {
		this.vo_38 = vo_38;
	}

	public Long getVa_39() {
		return va_39;
	}

	public void setVa_39(Long va_39) {
		this.va_39 = va_39;
	}

	public Long getRv_39() {
		return rv_39;
	}

	public void setRv_39(Long rv_39) {
		this.rv_39 = rv_39;
	}

	public Long getVo_39() {
		return vo_39;
	}

	public void setVo_39(Long vo_39) {
		this.vo_39 = vo_39;
	}

	public Long getVa_40() {
		return va_40;
	}

	public void setVa_40(Long va_40) {
		this.va_40 = va_40;
	}

	public Long getRv_40() {
		return rv_40;
	}

	public void setRv_40(Long rv_40) {
		this.rv_40 = rv_40;
	}

	public Long getVo_40() {
		return vo_40;
	}

	public void setVo_40(Long vo_40) {
		this.vo_40 = vo_40;
	}

	public Long getVa_41() {
		return va_41;
	}

	public void setVa_41(Long va_41) {
		this.va_41 = va_41;
	}

	public Long getRv_41() {
		return rv_41;
	}

	public void setRv_41(Long rv_41) {
		this.rv_41 = rv_41;
	}

	public Long getVo_41() {
		return vo_41;
	}

	public void setVo_41(Long vo_41) {
		this.vo_41 = vo_41;
	}

	public Long getVa_42() {
		return va_42;
	}

	public void setVa_42(Long va_42) {
		this.va_42 = va_42;
	}

	public Long getRv_42() {
		return rv_42;
	}

	public void setRv_42(Long rv_42) {
		this.rv_42 = rv_42;
	}

	public Long getVo_42() {
		return vo_42;
	}

	public void setVo_42(Long vo_42) {
		this.vo_42 = vo_42;
	}

	public Long getVa_43() {
		return va_43;
	}

	public void setVa_43(Long va_43) {
		this.va_43 = va_43;
	}

	public Long getRv_43() {
		return rv_43;
	}

	public void setRv_43(Long rv_43) {
		this.rv_43 = rv_43;
	}

	public Long getVo_43() {
		return vo_43;
	}

	public void setVo_43(Long vo_43) {
		this.vo_43 = vo_43;
	}

	public Long getVa_44() {
		return va_44;
	}

	public void setVa_44(Long va_44) {
		this.va_44 = va_44;
	}

	public Long getRv_44() {
		return rv_44;
	}

	public void setRv_44(Long rv_44) {
		this.rv_44 = rv_44;
	}

	public Long getVo_44() {
		return vo_44;
	}

	public void setVo_44(Long vo_44) {
		this.vo_44 = vo_44;
	}

	public Long getVa_45() {
		return va_45;
	}

	public void setVa_45(Long va_45) {
		this.va_45 = va_45;
	}

	public Long getRv_45() {
		return rv_45;
	}

	public void setRv_45(Long rv_45) {
		this.rv_45 = rv_45;
	}

	public Long getVo_45() {
		return vo_45;
	}

	public void setVo_45(Long vo_45) {
		this.vo_45 = vo_45;
	}

	public Long getVa_46() {
		return va_46;
	}

	public void setVa_46(Long va_46) {
		this.va_46 = va_46;
	}

	public Long getRv_46() {
		return rv_46;
	}

	public void setRv_46(Long rv_46) {
		this.rv_46 = rv_46;
	}

	public Long getVo_46() {
		return vo_46;
	}

	public void setVo_46(Long vo_46) {
		this.vo_46 = vo_46;
	}

	public Long getVa_47() {
		return va_47;
	}

	public void setVa_47(Long va_47) {
		this.va_47 = va_47;
	}

	public Long getRv_47() {
		return rv_47;
	}

	public void setRv_47(Long rv_47) {
		this.rv_47 = rv_47;
	}

	public Long getVo_47() {
		return vo_47;
	}

	public void setVo_47(Long vo_47) {
		this.vo_47 = vo_47;
	}

	public Long getVa_48() {
		return va_48;
	}

	public void setVa_48(Long va_48) {
		this.va_48 = va_48;
	}

	public Long getRv_48() {
		return rv_48;
	}

	public void setRv_48(Long rv_48) {
		this.rv_48 = rv_48;
	}

	public Long getVo_48() {
		return vo_48;
	}

	public void setVo_48(Long vo_48) {
		this.vo_48 = vo_48;
	}

	public Long getVa_49() {
		return va_49;
	}

	public void setVa_49(Long va_49) {
		this.va_49 = va_49;
	}

	public Long getRv_49() {
		return rv_49;
	}

	public void setRv_49(Long rv_49) {
		this.rv_49 = rv_49;
	}

	public Long getVo_49() {
		return vo_49;
	}

	public void setVo_49(Long vo_49) {
		this.vo_49 = vo_49;
	}

	public Long getVa_50() {
		return va_50;
	}

	public void setVa_50(Long va_50) {
		this.va_50 = va_50;
	}

	public Long getRv_50() {
		return rv_50;
	}

	public void setRv_50(Long rv_50) {
		this.rv_50 = rv_50;
	}

	public Long getVo_50() {
		return vo_50;
	}

	public void setVo_50(Long vo_50) {
		this.vo_50 = vo_50;
	}

	public Long getVa_51() {
		return va_51;
	}

	public void setVa_51(Long va_51) {
		this.va_51 = va_51;
	}

	public Long getRv_51() {
		return rv_51;
	}

	public void setRv_51(Long rv_51) {
		this.rv_51 = rv_51;
	}

	public Long getVo_51() {
		return vo_51;
	}

	public void setVo_51(Long vo_51) {
		this.vo_51 = vo_51;
	}

	public Long getVa_52() {
		return va_52;
	}

	public void setVa_52(Long va_52) {
		this.va_52 = va_52;
	}

	public Long getRv_52() {
		return rv_52;
	}

	public void setRv_52(Long rv_52) {
		this.rv_52 = rv_52;
	}

	public Long getVo_52() {
		return vo_52;
	}

	public void setVo_52(Long vo_52) {
		this.vo_52 = vo_52;
	}

	public Long getVa_53() {
		return va_53;
	}

	public void setVa_53(Long va_53) {
		this.va_53 = va_53;
	}

	public Long getRv_53() {
		return rv_53;
	}

	public void setRv_53(Long rv_53) {
		this.rv_53 = rv_53;
	}

	public Long getVo_53() {
		return vo_53;
	}

	public void setVo_53(Long vo_53) {
		this.vo_53 = vo_53;
	}

	public Long getVa_54() {
		return va_54;
	}

	public void setVa_54(Long va_54) {
		this.va_54 = va_54;
	}

	public Long getRv_54() {
		return rv_54;
	}

	public void setRv_54(Long rv_54) {
		this.rv_54 = rv_54;
	}

	public Long getVo_54() {
		return vo_54;
	}

	public void setVo_54(Long vo_54) {
		this.vo_54 = vo_54;
	}

	public Long getVa_55() {
		return va_55;
	}

	public void setVa_55(Long va_55) {
		this.va_55 = va_55;
	}

	public Long getRv_55() {
		return rv_55;
	}

	public void setRv_55(Long rv_55) {
		this.rv_55 = rv_55;
	}

	public Long getVo_55() {
		return vo_55;
	}

	public void setVo_55(Long vo_55) {
		this.vo_55 = vo_55;
	}

	public Long getVa_56() {
		return va_56;
	}

	public void setVa_56(Long va_56) {
		this.va_56 = va_56;
	}

	public Long getRv_56() {
		return rv_56;
	}

	public void setRv_56(Long rv_56) {
		this.rv_56 = rv_56;
	}

	public Long getVo_56() {
		return vo_56;
	}

	public void setVo_56(Long vo_56) {
		this.vo_56 = vo_56;
	}

	public Long getVa_57() {
		return va_57;
	}

	public void setVa_57(Long va_57) {
		this.va_57 = va_57;
	}

	public Long getRv_57() {
		return rv_57;
	}

	public void setRv_57(Long rv_57) {
		this.rv_57 = rv_57;
	}

	public Long getVo_57() {
		return vo_57;
	}

	public void setVo_57(Long vo_57) {
		this.vo_57 = vo_57;
	}

	public Long getVa_58() {
		return va_58;
	}

	public void setVa_58(Long va_58) {
		this.va_58 = va_58;
	}

	public Long getRv_58() {
		return rv_58;
	}

	public void setRv_58(Long rv_58) {
		this.rv_58 = rv_58;
	}

	public Long getVo_58() {
		return vo_58;
	}

	public void setVo_58(Long vo_58) {
		this.vo_58 = vo_58;
	}

	public Long getVa_59() {
		return va_59;
	}

	public void setVa_59(Long va_59) {
		this.va_59 = va_59;
	}

	public Long getRv_59() {
		return rv_59;
	}

	public void setRv_59(Long rv_59) {
		this.rv_59 = rv_59;
	}

	public Long getVo_59() {
		return vo_59;
	}

	public void setVo_59(Long vo_59) {
		this.vo_59 = vo_59;
	}

	public Long getVa_60() {
		return va_60;
	}

	public void setVa_60(Long va_60) {
		this.va_60 = va_60;
	}

	public Long getRv_60() {
		return rv_60;
	}

	public void setRv_60(Long rv_60) {
		this.rv_60 = rv_60;
	}

	public Long getVo_60() {
		return vo_60;
	}

	public void setVo_60(Long vo_60) {
		this.vo_60 = vo_60;
	}

	public Long getVa_61() {
		return va_61;
	}

	public void setVa_61(Long va_61) {
		this.va_61 = va_61;
	}

	public Long getRv_61() {
		return rv_61;
	}

	public void setRv_61(Long rv_61) {
		this.rv_61 = rv_61;
	}

	public Long getVo_61() {
		return vo_61;
	}

	public void setVo_61(Long vo_61) {
		this.vo_61 = vo_61;
	}

	public Long getVa_62() {
		return va_62;
	}

	public void setVa_62(Long va_62) {
		this.va_62 = va_62;
	}

	public Long getRv_62() {
		return rv_62;
	}

	public void setRv_62(Long rv_62) {
		this.rv_62 = rv_62;
	}

	public Long getVo_62() {
		return vo_62;
	}

	public void setVo_62(Long vo_62) {
		this.vo_62 = vo_62;
	}

	public Long getVa_63() {
		return va_63;
	}

	public void setVa_63(Long va_63) {
		this.va_63 = va_63;
	}

	public Long getRv_63() {
		return rv_63;
	}

	public void setRv_63(Long rv_63) {
		this.rv_63 = rv_63;
	}

	public Long getVo_63() {
		return vo_63;
	}

	public void setVo_63(Long vo_63) {
		this.vo_63 = vo_63;
	}

	public Long getVa_64() {
		return va_64;
	}

	public void setVa_64(Long va_64) {
		this.va_64 = va_64;
	}

	public Long getRv_64() {
		return rv_64;
	}

	public void setRv_64(Long rv_64) {
		this.rv_64 = rv_64;
	}

	public Long getVo_64() {
		return vo_64;
	}

	public void setVo_64(Long vo_64) {
		this.vo_64 = vo_64;
	}

	public Long getVa_65() {
		return va_65;
	}

	public void setVa_65(Long va_65) {
		this.va_65 = va_65;
	}

	public Long getRv_65() {
		return rv_65;
	}

	public void setRv_65(Long rv_65) {
		this.rv_65 = rv_65;
	}

	public Long getVo_65() {
		return vo_65;
	}

	public void setVo_65(Long vo_65) {
		this.vo_65 = vo_65;
	}

	public Long getVa_66() {
		return va_66;
	}

	public void setVa_66(Long va_66) {
		this.va_66 = va_66;
	}

	public Long getRv_66() {
		return rv_66;
	}

	public void setRv_66(Long rv_66) {
		this.rv_66 = rv_66;
	}

	public Long getVo_66() {
		return vo_66;
	}

	public void setVo_66(Long vo_66) {
		this.vo_66 = vo_66;
	}

	public Long getVa_67() {
		return va_67;
	}

	public void setVa_67(Long va_67) {
		this.va_67 = va_67;
	}

	public Long getRv_67() {
		return rv_67;
	}

	public void setRv_67(Long rv_67) {
		this.rv_67 = rv_67;
	}

	public Long getVo_67() {
		return vo_67;
	}

	public void setVo_67(Long vo_67) {
		this.vo_67 = vo_67;
	}

	public Long getVa_68() {
		return va_68;
	}

	public void setVa_68(Long va_68) {
		this.va_68 = va_68;
	}

	public Long getRv_68() {
		return rv_68;
	}

	public void setRv_68(Long rv_68) {
		this.rv_68 = rv_68;
	}

	public Long getVo_68() {
		return vo_68;
	}

	public void setVo_68(Long vo_68) {
		this.vo_68 = vo_68;
	}

	public Long getVa_69() {
		return va_69;
	}

	public void setVa_69(Long va_69) {
		this.va_69 = va_69;
	}

	public Long getRv_69() {
		return rv_69;
	}

	public void setRv_69(Long rv_69) {
		this.rv_69 = rv_69;
	}

	public Long getVo_69() {
		return vo_69;
	}

	public void setVo_69(Long vo_69) {
		this.vo_69 = vo_69;
	}

	public Long getVa_70() {
		return va_70;
	}

	public void setVa_70(Long va_70) {
		this.va_70 = va_70;
	}

	public Long getRv_70() {
		return rv_70;
	}

	public void setRv_70(Long rv_70) {
		this.rv_70 = rv_70;
	}

	public Long getVo_70() {
		return vo_70;
	}

	public void setVo_70(Long vo_70) {
		this.vo_70 = vo_70;
	}

	public Long getVa_71() {
		return va_71;
	}

	public void setVa_71(Long va_71) {
		this.va_71 = va_71;
	}

	public Long getRv_71() {
		return rv_71;
	}

	public void setRv_71(Long rv_71) {
		this.rv_71 = rv_71;
	}

	public Long getVo_71() {
		return vo_71;
	}

	public void setVo_71(Long vo_71) {
		this.vo_71 = vo_71;
	}

	public Long getVa_72() {
		return va_72;
	}

	public void setVa_72(Long va_72) {
		this.va_72 = va_72;
	}

	public Long getRv_72() {
		return rv_72;
	}

	public void setRv_72(Long rv_72) {
		this.rv_72 = rv_72;
	}

	public Long getVo_72() {
		return vo_72;
	}

	public void setVo_72(Long vo_72) {
		this.vo_72 = vo_72;
	}

	public Long getVa_73() {
		return va_73;
	}

	public void setVa_73(Long va_73) {
		this.va_73 = va_73;
	}

	public Long getRv_73() {
		return rv_73;
	}

	public void setRv_73(Long rv_73) {
		this.rv_73 = rv_73;
	}

	public Long getVo_73() {
		return vo_73;
	}

	public void setVo_73(Long vo_73) {
		this.vo_73 = vo_73;
	}

	public Long getVa_74() {
		return va_74;
	}

	public void setVa_74(Long va_74) {
		this.va_74 = va_74;
	}

	public Long getRv_74() {
		return rv_74;
	}

	public void setRv_74(Long rv_74) {
		this.rv_74 = rv_74;
	}

	public Long getVo_74() {
		return vo_74;
	}

	public void setVo_74(Long vo_74) {
		this.vo_74 = vo_74;
	}

	public Long getVa_75() {
		return va_75;
	}

	public void setVa_75(Long va_75) {
		this.va_75 = va_75;
	}

	public Long getRv_75() {
		return rv_75;
	}

	public void setRv_75(Long rv_75) {
		this.rv_75 = rv_75;
	}

	public Long getVo_75() {
		return vo_75;
	}

	public void setVo_75(Long vo_75) {
		this.vo_75 = vo_75;
	}

	public Long getVa_76() {
		return va_76;
	}

	public void setVa_76(Long va_76) {
		this.va_76 = va_76;
	}

	public Long getRv_76() {
		return rv_76;
	}

	public void setRv_76(Long rv_76) {
		this.rv_76 = rv_76;
	}

	public Long getVo_76() {
		return vo_76;
	}

	public void setVo_76(Long vo_76) {
		this.vo_76 = vo_76;
	}

	public Long getVa_77() {
		return va_77;
	}

	public void setVa_77(Long va_77) {
		this.va_77 = va_77;
	}

	public Long getRv_77() {
		return rv_77;
	}

	public void setRv_77(Long rv_77) {
		this.rv_77 = rv_77;
	}

	public Long getVo_77() {
		return vo_77;
	}

	public void setVo_77(Long vo_77) {
		this.vo_77 = vo_77;
	}

	public Long getVa_78() {
		return va_78;
	}

	public void setVa_78(Long va_78) {
		this.va_78 = va_78;
	}

	public Long getRv_78() {
		return rv_78;
	}

	public void setRv_78(Long rv_78) {
		this.rv_78 = rv_78;
	}

	public Long getVo_78() {
		return vo_78;
	}

	public void setVo_78(Long vo_78) {
		this.vo_78 = vo_78;
	}

	public Long getVa_79() {
		return va_79;
	}

	public void setVa_79(Long va_79) {
		this.va_79 = va_79;
	}

	public Long getRv_79() {
		return rv_79;
	}

	public void setRv_79(Long rv_79) {
		this.rv_79 = rv_79;
	}

	public Long getVo_79() {
		return vo_79;
	}

	public void setVo_79(Long vo_79) {
		this.vo_79 = vo_79;
	}

	public Long getVa_80() {
		return va_80;
	}

	public void setVa_80(Long va_80) {
		this.va_80 = va_80;
	}

	public Long getRv_80() {
		return rv_80;
	}

	public void setRv_80(Long rv_80) {
		this.rv_80 = rv_80;
	}

	public Long getVo_80() {
		return vo_80;
	}

	public void setVo_80(Long vo_80) {
		this.vo_80 = vo_80;
	}

	public Long getVa_81() {
		return va_81;
	}

	public void setVa_81(Long va_81) {
		this.va_81 = va_81;
	}

	public Long getRv_81() {
		return rv_81;
	}

	public void setRv_81(Long rv_81) {
		this.rv_81 = rv_81;
	}

	public Long getVo_81() {
		return vo_81;
	}

	public void setVo_81(Long vo_81) {
		this.vo_81 = vo_81;
	}

	public Long getVa_82() {
		return va_82;
	}

	public void setVa_82(Long va_82) {
		this.va_82 = va_82;
	}

	public Long getRv_82() {
		return rv_82;
	}

	public void setRv_82(Long rv_82) {
		this.rv_82 = rv_82;
	}

	public Long getVo_82() {
		return vo_82;
	}

	public void setVo_82(Long vo_82) {
		this.vo_82 = vo_82;
	}

	public Long getVa_83() {
		return va_83;
	}

	public void setVa_83(Long va_83) {
		this.va_83 = va_83;
	}

	public Long getRv_83() {
		return rv_83;
	}

	public void setRv_83(Long rv_83) {
		this.rv_83 = rv_83;
	}

	public Long getVo_83() {
		return vo_83;
	}

	public void setVo_83(Long vo_83) {
		this.vo_83 = vo_83;
	}

	public Long getVa_84() {
		return va_84;
	}

	public void setVa_84(Long va_84) {
		this.va_84 = va_84;
	}

	public Long getRv_84() {
		return rv_84;
	}

	public void setRv_84(Long rv_84) {
		this.rv_84 = rv_84;
	}

	public Long getVo_84() {
		return vo_84;
	}

	public void setVo_84(Long vo_84) {
		this.vo_84 = vo_84;
	}

	public Long getVa_85() {
		return va_85;
	}

	public void setVa_85(Long va_85) {
		this.va_85 = va_85;
	}

	public Long getRv_85() {
		return rv_85;
	}

	public void setRv_85(Long rv_85) {
		this.rv_85 = rv_85;
	}

	public Long getVo_85() {
		return vo_85;
	}

	public void setVo_85(Long vo_85) {
		this.vo_85 = vo_85;
	}

	public Long getVa_86() {
		return va_86;
	}

	public void setVa_86(Long va_86) {
		this.va_86 = va_86;
	}

	public Long getRv_86() {
		return rv_86;
	}

	public void setRv_86(Long rv_86) {
		this.rv_86 = rv_86;
	}

	public Long getVo_86() {
		return vo_86;
	}

	public void setVo_86(Long vo_86) {
		this.vo_86 = vo_86;
	}

	public Long getVa_87() {
		return va_87;
	}

	public void setVa_87(Long va_87) {
		this.va_87 = va_87;
	}

	public Long getRv_87() {
		return rv_87;
	}

	public void setRv_87(Long rv_87) {
		this.rv_87 = rv_87;
	}

	public Long getVo_87() {
		return vo_87;
	}

	public void setVo_87(Long vo_87) {
		this.vo_87 = vo_87;
	}

	public Long getVa_88() {
		return va_88;
	}

	public void setVa_88(Long va_88) {
		this.va_88 = va_88;
	}

	public Long getRv_88() {
		return rv_88;
	}

	public void setRv_88(Long rv_88) {
		this.rv_88 = rv_88;
	}

	public Long getVo_88() {
		return vo_88;
	}

	public void setVo_88(Long vo_88) {
		this.vo_88 = vo_88;
	}

	public Long getVa_89() {
		return va_89;
	}

	public void setVa_89(Long va_89) {
		this.va_89 = va_89;
	}

	public Long getRv_89() {
		return rv_89;
	}

	public void setRv_89(Long rv_89) {
		this.rv_89 = rv_89;
	}

	public Long getVo_89() {
		return vo_89;
	}

	public void setVo_89(Long vo_89) {
		this.vo_89 = vo_89;
	}

	public Long getVa_90() {
		return va_90;
	}

	public void setVa_90(Long va_90) {
		this.va_90 = va_90;
	}

	public Long getRv_90() {
		return rv_90;
	}

	public void setRv_90(Long rv_90) {
		this.rv_90 = rv_90;
	}

	public Long getVo_90() {
		return vo_90;
	}

	public void setVo_90(Long vo_90) {
		this.vo_90 = vo_90;
	}

	public Long getVa_91() {
		return va_91;
	}

	public void setVa_91(Long va_91) {
		this.va_91 = va_91;
	}

	public Long getRv_91() {
		return rv_91;
	}

	public void setRv_91(Long rv_91) {
		this.rv_91 = rv_91;
	}

	public Long getVo_91() {
		return vo_91;
	}

	public void setVo_91(Long vo_91) {
		this.vo_91 = vo_91;
	}

	public Long getVa_92() {
		return va_92;
	}

	public void setVa_92(Long va_92) {
		this.va_92 = va_92;
	}

	public Long getRv_92() {
		return rv_92;
	}

	public void setRv_92(Long rv_92) {
		this.rv_92 = rv_92;
	}

	public Long getVo_92() {
		return vo_92;
	}

	public void setVo_92(Long vo_92) {
		this.vo_92 = vo_92;
	}

	public Long getVa_93() {
		return va_93;
	}

	public void setVa_93(Long va_93) {
		this.va_93 = va_93;
	}

	public Long getRv_93() {
		return rv_93;
	}

	public void setRv_93(Long rv_93) {
		this.rv_93 = rv_93;
	}

	public Long getVo_93() {
		return vo_93;
	}

	public void setVo_93(Long vo_93) {
		this.vo_93 = vo_93;
	}

	public Long getVa_94() {
		return va_94;
	}

	public void setVa_94(Long va_94) {
		this.va_94 = va_94;
	}

	public Long getRv_94() {
		return rv_94;
	}

	public void setRv_94(Long rv_94) {
		this.rv_94 = rv_94;
	}

	public Long getVo_94() {
		return vo_94;
	}

	public void setVo_94(Long vo_94) {
		this.vo_94 = vo_94;
	}

	public Long getVa_95() {
		return va_95;
	}

	public void setVa_95(Long va_95) {
		this.va_95 = va_95;
	}

	public Long getRv_95() {
		return rv_95;
	}

	public void setRv_95(Long rv_95) {
		this.rv_95 = rv_95;
	}

	public Long getVo_95() {
		return vo_95;
	}

	public void setVo_95(Long vo_95) {
		this.vo_95 = vo_95;
	}

	public Long getVa_96() {
		return va_96;
	}

	public void setVa_96(Long va_96) {
		this.va_96 = va_96;
	}

	public Long getRv_96() {
		return rv_96;
	}

	public void setRv_96(Long rv_96) {
		this.rv_96 = rv_96;
	}

	public Long getVo_96() {
		return vo_96;
	}

	public void setVo_96(Long vo_96) {
		this.vo_96 = vo_96;
	}

	public Long getVa_97() {
		return va_97;
	}

	public void setVa_97(Long va_97) {
		this.va_97 = va_97;
	}

	public Long getRv_97() {
		return rv_97;
	}

	public void setRv_97(Long rv_97) {
		this.rv_97 = rv_97;
	}

	public Long getVo_97() {
		return vo_97;
	}

	public void setVo_97(Long vo_97) {
		this.vo_97 = vo_97;
	}

	public Long getVa_98() {
		return va_98;
	}

	public void setVa_98(Long va_98) {
		this.va_98 = va_98;
	}

	public Long getRv_98() {
		return rv_98;
	}

	public void setRv_98(Long rv_98) {
		this.rv_98 = rv_98;
	}

	public Long getVo_98() {
		return vo_98;
	}

	public void setVo_98(Long vo_98) {
		this.vo_98 = vo_98;
	}

	public Long getVa_99() {
		return va_99;
	}

	public void setVa_99(Long va_99) {
		this.va_99 = va_99;
	}

	public Long getRv_99() {
		return rv_99;
	}

	public void setRv_99(Long rv_99) {
		this.rv_99 = rv_99;
	}

	public Long getVo_99() {
		return vo_99;
	}

	public void setVo_99(Long vo_99) {
		this.vo_99 = vo_99;
	}

	public Long getVa_100() {
		return va_100;
	}

	public void setVa_100(Long va_100) {
		this.va_100 = va_100;
	}

	public Long getRv_100() {
		return rv_100;
	}

	public void setRv_100(Long rv_100) {
		this.rv_100 = rv_100;
	}

	public Long getVo_100() {
		return vo_100;
	}

	public void setVo_100(Long vo_100) {
		this.vo_100 = vo_100;
	}

	public Long getVa_101() {
		return va_101;
	}

	public void setVa_101(Long va_101) {
		this.va_101 = va_101;
	}

	public Long getRv_101() {
		return rv_101;
	}

	public void setRv_101(Long rv_101) {
		this.rv_101 = rv_101;
	}

	public Long getVo_101() {
		return vo_101;
	}

	public void setVo_101(Long vo_101) {
		this.vo_101 = vo_101;
	}

	public Long getVa_102() {
		return va_102;
	}

	public void setVa_102(Long va_102) {
		this.va_102 = va_102;
	}

	public Long getRv_102() {
		return rv_102;
	}

	public void setRv_102(Long rv_102) {
		this.rv_102 = rv_102;
	}

	public Long getVo_102() {
		return vo_102;
	}

	public void setVo_102(Long vo_102) {
		this.vo_102 = vo_102;
	}

	public Long getVa_103() {
		return va_103;
	}

	public void setVa_103(Long va_103) {
		this.va_103 = va_103;
	}

	public Long getRv_103() {
		return rv_103;
	}

	public void setRv_103(Long rv_103) {
		this.rv_103 = rv_103;
	}

	public Long getVo_103() {
		return vo_103;
	}

	public void setVo_103(Long vo_103) {
		this.vo_103 = vo_103;
	}

	public Long getVa_104() {
		return va_104;
	}

	public void setVa_104(Long va_104) {
		this.va_104 = va_104;
	}

	public Long getRv_104() {
		return rv_104;
	}

	public void setRv_104(Long rv_104) {
		this.rv_104 = rv_104;
	}

	public Long getVo_104() {
		return vo_104;
	}

	public void setVo_104(Long vo_104) {
		this.vo_104 = vo_104;
	}

	public Long getVa_105() {
		return va_105;
	}

	public void setVa_105(Long va_105) {
		this.va_105 = va_105;
	}

	public Long getRv_105() {
		return rv_105;
	}

	public void setRv_105(Long rv_105) {
		this.rv_105 = rv_105;
	}

	public Long getVo_105() {
		return vo_105;
	}

	public void setVo_105(Long vo_105) {
		this.vo_105 = vo_105;
	}

	public Long getVa_106() {
		return va_106;
	}

	public void setVa_106(Long va_106) {
		this.va_106 = va_106;
	}

	public Long getRv_106() {
		return rv_106;
	}

	public void setRv_106(Long rv_106) {
		this.rv_106 = rv_106;
	}

	public Long getVo_106() {
		return vo_106;
	}

	public void setVo_106(Long vo_106) {
		this.vo_106 = vo_106;
	}

	public Long getVa_107() {
		return va_107;
	}

	public void setVa_107(Long va_107) {
		this.va_107 = va_107;
	}

	public Long getRv_107() {
		return rv_107;
	}

	public void setRv_107(Long rv_107) {
		this.rv_107 = rv_107;
	}

	public Long getVo_107() {
		return vo_107;
	}

	public void setVo_107(Long vo_107) {
		this.vo_107 = vo_107;
	}

	public Long getVa_108() {
		return va_108;
	}

	public void setVa_108(Long va_108) {
		this.va_108 = va_108;
	}

	public Long getRv_108() {
		return rv_108;
	}

	public void setRv_108(Long rv_108) {
		this.rv_108 = rv_108;
	}

	public Long getVo_108() {
		return vo_108;
	}

	public void setVo_108(Long vo_108) {
		this.vo_108 = vo_108;
	}

	public Long getVa_109() {
		return va_109;
	}

	public void setVa_109(Long va_109) {
		this.va_109 = va_109;
	}

	public Long getRv_109() {
		return rv_109;
	}

	public void setRv_109(Long rv_109) {
		this.rv_109 = rv_109;
	}

	public Long getVo_109() {
		return vo_109;
	}

	public void setVo_109(Long vo_109) {
		this.vo_109 = vo_109;
	}

	public Long getVa_110() {
		return va_110;
	}

	public void setVa_110(Long va_110) {
		this.va_110 = va_110;
	}

	public Long getRv_110() {
		return rv_110;
	}

	public void setRv_110(Long rv_110) {
		this.rv_110 = rv_110;
	}

	public Long getVo_110() {
		return vo_110;
	}

	public void setVo_110(Long vo_110) {
		this.vo_110 = vo_110;
	}

	public Long getVa_111() {
		return va_111;
	}

	public void setVa_111(Long va_111) {
		this.va_111 = va_111;
	}

	public Long getRv_111() {
		return rv_111;
	}

	public void setRv_111(Long rv_111) {
		this.rv_111 = rv_111;
	}

	public Long getVo_111() {
		return vo_111;
	}

	public void setVo_111(Long vo_111) {
		this.vo_111 = vo_111;
	}

	public Long getVa_112() {
		return va_112;
	}

	public void setVa_112(Long va_112) {
		this.va_112 = va_112;
	}

	public Long getRv_112() {
		return rv_112;
	}

	public void setRv_112(Long rv_112) {
		this.rv_112 = rv_112;
	}

	public Long getVo_112() {
		return vo_112;
	}

	public void setVo_112(Long vo_112) {
		this.vo_112 = vo_112;
	}

	public Long getVa_113() {
		return va_113;
	}

	public void setVa_113(Long va_113) {
		this.va_113 = va_113;
	}

	public Long getRv_113() {
		return rv_113;
	}

	public void setRv_113(Long rv_113) {
		this.rv_113 = rv_113;
	}

	public Long getVo_113() {
		return vo_113;
	}

	public void setVo_113(Long vo_113) {
		this.vo_113 = vo_113;
	}

	public Long getVa_114() {
		return va_114;
	}

	public void setVa_114(Long va_114) {
		this.va_114 = va_114;
	}

	public Long getRv_114() {
		return rv_114;
	}

	public void setRv_114(Long rv_114) {
		this.rv_114 = rv_114;
	}

	public Long getVo_114() {
		return vo_114;
	}

	public void setVo_114(Long vo_114) {
		this.vo_114 = vo_114;
	}

	public Long getVa_115() {
		return va_115;
	}

	public void setVa_115(Long va_115) {
		this.va_115 = va_115;
	}

	public Long getRv_115() {
		return rv_115;
	}

	public void setRv_115(Long rv_115) {
		this.rv_115 = rv_115;
	}

	public Long getVo_115() {
		return vo_115;
	}

	public void setVo_115(Long vo_115) {
		this.vo_115 = vo_115;
	}

	public Long getVa_116() {
		return va_116;
	}

	public void setVa_116(Long va_116) {
		this.va_116 = va_116;
	}

	public Long getRv_116() {
		return rv_116;
	}

	public void setRv_116(Long rv_116) {
		this.rv_116 = rv_116;
	}

	public Long getVo_116() {
		return vo_116;
	}

	public void setVo_116(Long vo_116) {
		this.vo_116 = vo_116;
	}

	public Long getVa_117() {
		return va_117;
	}

	public void setVa_117(Long va_117) {
		this.va_117 = va_117;
	}

	public Long getRv_117() {
		return rv_117;
	}

	public void setRv_117(Long rv_117) {
		this.rv_117 = rv_117;
	}

	public Long getVo_117() {
		return vo_117;
	}

	public void setVo_117(Long vo_117) {
		this.vo_117 = vo_117;
	}

	public Long getVa_118() {
		return va_118;
	}

	public void setVa_118(Long va_118) {
		this.va_118 = va_118;
	}

	public Long getRv_118() {
		return rv_118;
	}

	public void setRv_118(Long rv_118) {
		this.rv_118 = rv_118;
	}

	public Long getVo_118() {
		return vo_118;
	}

	public void setVo_118(Long vo_118) {
		this.vo_118 = vo_118;
	}

	public Long getVa_119() {
		return va_119;
	}

	public void setVa_119(Long va_119) {
		this.va_119 = va_119;
	}

	public Long getRv_119() {
		return rv_119;
	}

	public void setRv_119(Long rv_119) {
		this.rv_119 = rv_119;
	}

	public Long getVo_119() {
		return vo_119;
	}

	public void setVo_119(Long vo_119) {
		this.vo_119 = vo_119;
	}

	public Long getVa_120() {
		return va_120;
	}

	public void setVa_120(Long va_120) {
		this.va_120 = va_120;
	}

	public Long getRv_120() {
		return rv_120;
	}

	public void setRv_120(Long rv_120) {
		this.rv_120 = rv_120;
	}

	public Long getVo_120() {
		return vo_120;
	}

	public void setVo_120(Long vo_120) {
		this.vo_120 = vo_120;
	}

	public Long getVa_121() {
		return va_121;
	}

	public void setVa_121(Long va_121) {
		this.va_121 = va_121;
	}

	public Long getRv_121() {
		return rv_121;
	}

	public void setRv_121(Long rv_121) {
		this.rv_121 = rv_121;
	}

	public Long getVo_121() {
		return vo_121;
	}

	public void setVo_121(Long vo_121) {
		this.vo_121 = vo_121;
	}

	public Long getVa_122() {
		return va_122;
	}

	public void setVa_122(Long va_122) {
		this.va_122 = va_122;
	}

	public Long getRv_122() {
		return rv_122;
	}

	public void setRv_122(Long rv_122) {
		this.rv_122 = rv_122;
	}

	public Long getVo_122() {
		return vo_122;
	}

	public void setVo_122(Long vo_122) {
		this.vo_122 = vo_122;
	}

	public Long getVa_123() {
		return va_123;
	}

	public void setVa_123(Long va_123) {
		this.va_123 = va_123;
	}

	public Long getRv_123() {
		return rv_123;
	}

	public void setRv_123(Long rv_123) {
		this.rv_123 = rv_123;
	}

	public Long getVo_123() {
		return vo_123;
	}

	public void setVo_123(Long vo_123) {
		this.vo_123 = vo_123;
	}

	public Long getVa_124() {
		return va_124;
	}

	public void setVa_124(Long va_124) {
		this.va_124 = va_124;
	}

	public Long getRv_124() {
		return rv_124;
	}

	public void setRv_124(Long rv_124) {
		this.rv_124 = rv_124;
	}

	public Long getVo_124() {
		return vo_124;
	}

	public void setVo_124(Long vo_124) {
		this.vo_124 = vo_124;
	}

	public Long getVa_125() {
		return va_125;
	}

	public void setVa_125(Long va_125) {
		this.va_125 = va_125;
	}

	public Long getRv_125() {
		return rv_125;
	}

	public void setRv_125(Long rv_125) {
		this.rv_125 = rv_125;
	}

	public Long getVo_125() {
		return vo_125;
	}

	public void setVo_125(Long vo_125) {
		this.vo_125 = vo_125;
	}

	public Long getVa_126() {
		return va_126;
	}

	public void setVa_126(Long va_126) {
		this.va_126 = va_126;
	}

	public Long getRv_126() {
		return rv_126;
	}

	public void setRv_126(Long rv_126) {
		this.rv_126 = rv_126;
	}

	public Long getVo_126() {
		return vo_126;
	}

	public void setVo_126(Long vo_126) {
		this.vo_126 = vo_126;
	}

	public Long getVa_127() {
		return va_127;
	}

	public void setVa_127(Long va_127) {
		this.va_127 = va_127;
	}

	public Long getRv_127() {
		return rv_127;
	}

	public void setRv_127(Long rv_127) {
		this.rv_127 = rv_127;
	}

	public Long getVo_127() {
		return vo_127;
	}

	public void setVo_127(Long vo_127) {
		this.vo_127 = vo_127;
	}

	public Long getVa_128() {
		return va_128;
	}

	public void setVa_128(Long va_128) {
		this.va_128 = va_128;
	}

	public Long getRv_128() {
		return rv_128;
	}

	public void setRv_128(Long rv_128) {
		this.rv_128 = rv_128;
	}

	public Long getVo_128() {
		return vo_128;
	}

	public void setVo_128(Long vo_128) {
		this.vo_128 = vo_128;
	}

	public Long getVa_129() {
		return va_129;
	}

	public void setVa_129(Long va_129) {
		this.va_129 = va_129;
	}

	public Long getRv_129() {
		return rv_129;
	}

	public void setRv_129(Long rv_129) {
		this.rv_129 = rv_129;
	}

	public Long getVo_129() {
		return vo_129;
	}

	public void setVo_129(Long vo_129) {
		this.vo_129 = vo_129;
	}

	public Long getVa_130() {
		return va_130;
	}

	public void setVa_130(Long va_130) {
		this.va_130 = va_130;
	}

	public Long getRv_130() {
		return rv_130;
	}

	public void setRv_130(Long rv_130) {
		this.rv_130 = rv_130;
	}

	public Long getVo_130() {
		return vo_130;
	}

	public void setVo_130(Long vo_130) {
		this.vo_130 = vo_130;
	}

	public Long getVa_131() {
		return va_131;
	}

	public void setVa_131(Long va_131) {
		this.va_131 = va_131;
	}

	public Long getRv_131() {
		return rv_131;
	}

	public void setRv_131(Long rv_131) {
		this.rv_131 = rv_131;
	}

	public Long getVo_131() {
		return vo_131;
	}

	public void setVo_131(Long vo_131) {
		this.vo_131 = vo_131;
	}

	public Long getVa_132() {
		return va_132;
	}

	public void setVa_132(Long va_132) {
		this.va_132 = va_132;
	}

	public Long getRv_132() {
		return rv_132;
	}

	public void setRv_132(Long rv_132) {
		this.rv_132 = rv_132;
	}

	public Long getVo_132() {
		return vo_132;
	}

	public void setVo_132(Long vo_132) {
		this.vo_132 = vo_132;
	}

	public Long getVa_133() {
		return va_133;
	}

	public void setVa_133(Long va_133) {
		this.va_133 = va_133;
	}

	public Long getRv_133() {
		return rv_133;
	}

	public void setRv_133(Long rv_133) {
		this.rv_133 = rv_133;
	}

	public Long getVo_133() {
		return vo_133;
	}

	public void setVo_133(Long vo_133) {
		this.vo_133 = vo_133;
	}

	public Long getVa_134() {
		return va_134;
	}

	public void setVa_134(Long va_134) {
		this.va_134 = va_134;
	}

	public Long getRv_134() {
		return rv_134;
	}

	public void setRv_134(Long rv_134) {
		this.rv_134 = rv_134;
	}

	public Long getVo_134() {
		return vo_134;
	}

	public void setVo_134(Long vo_134) {
		this.vo_134 = vo_134;
	}

	public Long getVa_135() {
		return va_135;
	}

	public void setVa_135(Long va_135) {
		this.va_135 = va_135;
	}

	public Long getRv_135() {
		return rv_135;
	}

	public void setRv_135(Long rv_135) {
		this.rv_135 = rv_135;
	}

	public Long getVo_135() {
		return vo_135;
	}

	public void setVo_135(Long vo_135) {
		this.vo_135 = vo_135;
	}

	public Long getVa_136() {
		return va_136;
	}

	public void setVa_136(Long va_136) {
		this.va_136 = va_136;
	}

	public Long getRv_136() {
		return rv_136;
	}

	public void setRv_136(Long rv_136) {
		this.rv_136 = rv_136;
	}

	public Long getVo_136() {
		return vo_136;
	}

	public void setVo_136(Long vo_136) {
		this.vo_136 = vo_136;
	}

	public Long getVa_137() {
		return va_137;
	}

	public void setVa_137(Long va_137) {
		this.va_137 = va_137;
	}

	public Long getRv_137() {
		return rv_137;
	}

	public void setRv_137(Long rv_137) {
		this.rv_137 = rv_137;
	}

	public Long getVo_137() {
		return vo_137;
	}

	public void setVo_137(Long vo_137) {
		this.vo_137 = vo_137;
	}

	public Long getVa_138() {
		return va_138;
	}

	public void setVa_138(Long va_138) {
		this.va_138 = va_138;
	}

	public Long getRv_138() {
		return rv_138;
	}

	public void setRv_138(Long rv_138) {
		this.rv_138 = rv_138;
	}

	public Long getVo_138() {
		return vo_138;
	}

	public void setVo_138(Long vo_138) {
		this.vo_138 = vo_138;
	}

	public Long getVa_139() {
		return va_139;
	}

	public void setVa_139(Long va_139) {
		this.va_139 = va_139;
	}

	public Long getRv_139() {
		return rv_139;
	}

	public void setRv_139(Long rv_139) {
		this.rv_139 = rv_139;
	}

	public Long getVo_139() {
		return vo_139;
	}

	public void setVo_139(Long vo_139) {
		this.vo_139 = vo_139;
	}

	public Long getVa_140() {
		return va_140;
	}

	public void setVa_140(Long va_140) {
		this.va_140 = va_140;
	}

	public Long getRv_140() {
		return rv_140;
	}

	public void setRv_140(Long rv_140) {
		this.rv_140 = rv_140;
	}

	public Long getVo_140() {
		return vo_140;
	}

	public void setVo_140(Long vo_140) {
		this.vo_140 = vo_140;
	}

	public Long getVa_141() {
		return va_141;
	}

	public void setVa_141(Long va_141) {
		this.va_141 = va_141;
	}

	public Long getRv_141() {
		return rv_141;
	}

	public void setRv_141(Long rv_141) {
		this.rv_141 = rv_141;
	}

	public Long getVo_141() {
		return vo_141;
	}

	public void setVo_141(Long vo_141) {
		this.vo_141 = vo_141;
	}

	public Long getVa_142() {
		return va_142;
	}

	public void setVa_142(Long va_142) {
		this.va_142 = va_142;
	}

	public Long getRv_142() {
		return rv_142;
	}

	public void setRv_142(Long rv_142) {
		this.rv_142 = rv_142;
	}

	public Long getVo_142() {
		return vo_142;
	}

	public void setVo_142(Long vo_142) {
		this.vo_142 = vo_142;
	}

	public Long getVa_143() {
		return va_143;
	}

	public void setVa_143(Long va_143) {
		this.va_143 = va_143;
	}

	public Long getRv_143() {
		return rv_143;
	}

	public void setRv_143(Long rv_143) {
		this.rv_143 = rv_143;
	}

	public Long getVo_143() {
		return vo_143;
	}

	public void setVo_143(Long vo_143) {
		this.vo_143 = vo_143;
	}

	public Long getVa_144() {
		return va_144;
	}

	public void setVa_144(Long va_144) {
		this.va_144 = va_144;
	}

	public Long getRv_144() {
		return rv_144;
	}

	public void setRv_144(Long rv_144) {
		this.rv_144 = rv_144;
	}

	public Long getVo_144() {
		return vo_144;
	}

	public void setVo_144(Long vo_144) {
		this.vo_144 = vo_144;
	}

	public Long getVa_145() {
		return va_145;
	}

	public void setVa_145(Long va_145) {
		this.va_145 = va_145;
	}

	public Long getRv_145() {
		return rv_145;
	}

	public void setRv_145(Long rv_145) {
		this.rv_145 = rv_145;
	}

	public Long getVo_145() {
		return vo_145;
	}

	public void setVo_145(Long vo_145) {
		this.vo_145 = vo_145;
	}

	public Long getVa_146() {
		return va_146;
	}

	public void setVa_146(Long va_146) {
		this.va_146 = va_146;
	}

	public Long getRv_146() {
		return rv_146;
	}

	public void setRv_146(Long rv_146) {
		this.rv_146 = rv_146;
	}

	public Long getVo_146() {
		return vo_146;
	}

	public void setVo_146(Long vo_146) {
		this.vo_146 = vo_146;
	}

	public Long getVa_147() {
		return va_147;
	}

	public void setVa_147(Long va_147) {
		this.va_147 = va_147;
	}

	public Long getRv_147() {
		return rv_147;
	}

	public void setRv_147(Long rv_147) {
		this.rv_147 = rv_147;
	}

	public Long getVo_147() {
		return vo_147;
	}

	public void setVo_147(Long vo_147) {
		this.vo_147 = vo_147;
	}

	public Long getVa_148() {
		return va_148;
	}

	public void setVa_148(Long va_148) {
		this.va_148 = va_148;
	}

	public Long getRv_148() {
		return rv_148;
	}

	public void setRv_148(Long rv_148) {
		this.rv_148 = rv_148;
	}

	public Long getVo_148() {
		return vo_148;
	}

	public void setVo_148(Long vo_148) {
		this.vo_148 = vo_148;
	}

	public Long getVa_149() {
		return va_149;
	}

	public void setVa_149(Long va_149) {
		this.va_149 = va_149;
	}

	public Long getRv_149() {
		return rv_149;
	}

	public void setRv_149(Long rv_149) {
		this.rv_149 = rv_149;
	}

	public Long getVo_149() {
		return vo_149;
	}

	public void setVo_149(Long vo_149) {
		this.vo_149 = vo_149;
	}

	public Long getVa_150() {
		return va_150;
	}

	public void setVa_150(Long va_150) {
		this.va_150 = va_150;
	}

	public Long getRv_150() {
		return rv_150;
	}

	public void setRv_150(Long rv_150) {
		this.rv_150 = rv_150;
	}

	public Long getVo_150() {
		return vo_150;
	}

	public void setVo_150(Long vo_150) {
		this.vo_150 = vo_150;
	}

	public Long getVa_151() {
		return va_151;
	}

	public void setVa_151(Long va_151) {
		this.va_151 = va_151;
	}

	public Long getRv_151() {
		return rv_151;
	}

	public void setRv_151(Long rv_151) {
		this.rv_151 = rv_151;
	}

	public Long getVo_151() {
		return vo_151;
	}

	public void setVo_151(Long vo_151) {
		this.vo_151 = vo_151;
	}

	public Long getVa_152() {
		return va_152;
	}

	public void setVa_152(Long va_152) {
		this.va_152 = va_152;
	}

	public Long getRv_152() {
		return rv_152;
	}

	public void setRv_152(Long rv_152) {
		this.rv_152 = rv_152;
	}

	public Long getVo_152() {
		return vo_152;
	}

	public void setVo_152(Long vo_152) {
		this.vo_152 = vo_152;
	}

	public Long getVa_153() {
		return va_153;
	}

	public void setVa_153(Long va_153) {
		this.va_153 = va_153;
	}

	public Long getRv_153() {
		return rv_153;
	}

	public void setRv_153(Long rv_153) {
		this.rv_153 = rv_153;
	}

	public Long getVo_153() {
		return vo_153;
	}

	public void setVo_153(Long vo_153) {
		this.vo_153 = vo_153;
	}

	public Long getVa_154() {
		return va_154;
	}

	public void setVa_154(Long va_154) {
		this.va_154 = va_154;
	}

	public Long getRv_154() {
		return rv_154;
	}

	public void setRv_154(Long rv_154) {
		this.rv_154 = rv_154;
	}

	public Long getVo_154() {
		return vo_154;
	}

	public void setVo_154(Long vo_154) {
		this.vo_154 = vo_154;
	}

	public Long getVa_155() {
		return va_155;
	}

	public void setVa_155(Long va_155) {
		this.va_155 = va_155;
	}

	public Long getRv_155() {
		return rv_155;
	}

	public void setRv_155(Long rv_155) {
		this.rv_155 = rv_155;
	}

	public Long getVo_155() {
		return vo_155;
	}

	public void setVo_155(Long vo_155) {
		this.vo_155 = vo_155;
	}

	public Long getVa_156() {
		return va_156;
	}

	public void setVa_156(Long va_156) {
		this.va_156 = va_156;
	}

	public Long getRv_156() {
		return rv_156;
	}

	public void setRv_156(Long rv_156) {
		this.rv_156 = rv_156;
	}

	public Long getVo_156() {
		return vo_156;
	}

	public void setVo_156(Long vo_156) {
		this.vo_156 = vo_156;
	}

	public Long getVa_157() {
		return va_157;
	}

	public void setVa_157(Long va_157) {
		this.va_157 = va_157;
	}

	public Long getRv_157() {
		return rv_157;
	}

	public void setRv_157(Long rv_157) {
		this.rv_157 = rv_157;
	}

	public Long getVo_157() {
		return vo_157;
	}

	public void setVo_157(Long vo_157) {
		this.vo_157 = vo_157;
	}

	public Long getVa_158() {
		return va_158;
	}

	public void setVa_158(Long va_158) {
		this.va_158 = va_158;
	}

	public Long getRv_158() {
		return rv_158;
	}

	public void setRv_158(Long rv_158) {
		this.rv_158 = rv_158;
	}

	public Long getVo_158() {
		return vo_158;
	}

	public void setVo_158(Long vo_158) {
		this.vo_158 = vo_158;
	}

	public Long getVa_159() {
		return va_159;
	}

	public void setVa_159(Long va_159) {
		this.va_159 = va_159;
	}

	public Long getRv_159() {
		return rv_159;
	}

	public void setRv_159(Long rv_159) {
		this.rv_159 = rv_159;
	}

	public Long getVo_159() {
		return vo_159;
	}

	public void setVo_159(Long vo_159) {
		this.vo_159 = vo_159;
	}

	public Long getVa_160() {
		return va_160;
	}

	public void setVa_160(Long va_160) {
		this.va_160 = va_160;
	}

	public Long getRv_160() {
		return rv_160;
	}

	public void setRv_160(Long rv_160) {
		this.rv_160 = rv_160;
	}

	public Long getVo_160() {
		return vo_160;
	}

	public void setVo_160(Long vo_160) {
		this.vo_160 = vo_160;
	}

	public Long getVa_161() {
		return va_161;
	}

	public void setVa_161(Long va_161) {
		this.va_161 = va_161;
	}

	public Long getRv_161() {
		return rv_161;
	}

	public void setRv_161(Long rv_161) {
		this.rv_161 = rv_161;
	}

	public Long getVo_161() {
		return vo_161;
	}

	public void setVo_161(Long vo_161) {
		this.vo_161 = vo_161;
	}

	public Long getVa_162() {
		return va_162;
	}

	public void setVa_162(Long va_162) {
		this.va_162 = va_162;
	}

	public Long getRv_162() {
		return rv_162;
	}

	public void setRv_162(Long rv_162) {
		this.rv_162 = rv_162;
	}

	public Long getVo_162() {
		return vo_162;
	}

	public void setVo_162(Long vo_162) {
		this.vo_162 = vo_162;
	}

	public Long getVa_163() {
		return va_163;
	}

	public void setVa_163(Long va_163) {
		this.va_163 = va_163;
	}

	public Long getRv_163() {
		return rv_163;
	}

	public void setRv_163(Long rv_163) {
		this.rv_163 = rv_163;
	}

	public Long getVo_163() {
		return vo_163;
	}

	public void setVo_163(Long vo_163) {
		this.vo_163 = vo_163;
	}

	public Long getVa_164() {
		return va_164;
	}

	public void setVa_164(Long va_164) {
		this.va_164 = va_164;
	}

	public Long getRv_164() {
		return rv_164;
	}

	public void setRv_164(Long rv_164) {
		this.rv_164 = rv_164;
	}

	public Long getVo_164() {
		return vo_164;
	}

	public void setVo_164(Long vo_164) {
		this.vo_164 = vo_164;
	}

	public Long getVa_165() {
		return va_165;
	}

	public void setVa_165(Long va_165) {
		this.va_165 = va_165;
	}

	public Long getRv_165() {
		return rv_165;
	}

	public void setRv_165(Long rv_165) {
		this.rv_165 = rv_165;
	}

	public Long getVo_165() {
		return vo_165;
	}

	public void setVo_165(Long vo_165) {
		this.vo_165 = vo_165;
	}

	public Long getVa_166() {
		return va_166;
	}

	public void setVa_166(Long va_166) {
		this.va_166 = va_166;
	}

	public Long getRv_166() {
		return rv_166;
	}

	public void setRv_166(Long rv_166) {
		this.rv_166 = rv_166;
	}

	public Long getVo_166() {
		return vo_166;
	}

	public void setVo_166(Long vo_166) {
		this.vo_166 = vo_166;
	}

	public Long getVa_167() {
		return va_167;
	}

	public void setVa_167(Long va_167) {
		this.va_167 = va_167;
	}

	public Long getRv_167() {
		return rv_167;
	}

	public void setRv_167(Long rv_167) {
		this.rv_167 = rv_167;
	}

	public Long getVo_167() {
		return vo_167;
	}

	public void setVo_167(Long vo_167) {
		this.vo_167 = vo_167;
	}

	public Long getVa_168() {
		return va_168;
	}

	public void setVa_168(Long va_168) {
		this.va_168 = va_168;
	}

	public Long getRv_168() {
		return rv_168;
	}

	public void setRv_168(Long rv_168) {
		this.rv_168 = rv_168;
	}

	public Long getVo_168() {
		return vo_168;
	}

	public void setVo_168(Long vo_168) {
		this.vo_168 = vo_168;
	}

	public Long getVa_169() {
		return va_169;
	}

	public void setVa_169(Long va_169) {
		this.va_169 = va_169;
	}

	public Long getRv_169() {
		return rv_169;
	}

	public void setRv_169(Long rv_169) {
		this.rv_169 = rv_169;
	}

	public Long getVo_169() {
		return vo_169;
	}

	public void setVo_169(Long vo_169) {
		this.vo_169 = vo_169;
	}

	public Long getVa_170() {
		return va_170;
	}

	public void setVa_170(Long va_170) {
		this.va_170 = va_170;
	}

	public Long getRv_170() {
		return rv_170;
	}

	public void setRv_170(Long rv_170) {
		this.rv_170 = rv_170;
	}

	public Long getVo_170() {
		return vo_170;
	}

	public void setVo_170(Long vo_170) {
		this.vo_170 = vo_170;
	}

	public Long getVa_171() {
		return va_171;
	}

	public void setVa_171(Long va_171) {
		this.va_171 = va_171;
	}

	public Long getRv_171() {
		return rv_171;
	}

	public void setRv_171(Long rv_171) {
		this.rv_171 = rv_171;
	}

	public Long getVo_171() {
		return vo_171;
	}

	public void setVo_171(Long vo_171) {
		this.vo_171 = vo_171;
	}

	public Long getVa_172() {
		return va_172;
	}

	public void setVa_172(Long va_172) {
		this.va_172 = va_172;
	}

	public Long getRv_172() {
		return rv_172;
	}

	public void setRv_172(Long rv_172) {
		this.rv_172 = rv_172;
	}

	public Long getVo_172() {
		return vo_172;
	}

	public void setVo_172(Long vo_172) {
		this.vo_172 = vo_172;
	}

	public Long getVa_173() {
		return va_173;
	}

	public void setVa_173(Long va_173) {
		this.va_173 = va_173;
	}

	public Long getRv_173() {
		return rv_173;
	}

	public void setRv_173(Long rv_173) {
		this.rv_173 = rv_173;
	}

	public Long getVo_173() {
		return vo_173;
	}

	public void setVo_173(Long vo_173) {
		this.vo_173 = vo_173;
	}

	public Long getVa_174() {
		return va_174;
	}

	public void setVa_174(Long va_174) {
		this.va_174 = va_174;
	}

	public Long getRv_174() {
		return rv_174;
	}

	public void setRv_174(Long rv_174) {
		this.rv_174 = rv_174;
	}

	public Long getVo_174() {
		return vo_174;
	}

	public void setVo_174(Long vo_174) {
		this.vo_174 = vo_174;
	}

	public Long getVa_175() {
		return va_175;
	}

	public void setVa_175(Long va_175) {
		this.va_175 = va_175;
	}

	public Long getRv_175() {
		return rv_175;
	}

	public void setRv_175(Long rv_175) {
		this.rv_175 = rv_175;
	}

	public Long getVo_175() {
		return vo_175;
	}

	public void setVo_175(Long vo_175) {
		this.vo_175 = vo_175;
	}

	public Long getVa_176() {
		return va_176;
	}

	public void setVa_176(Long va_176) {
		this.va_176 = va_176;
	}

	public Long getRv_176() {
		return rv_176;
	}

	public void setRv_176(Long rv_176) {
		this.rv_176 = rv_176;
	}

	public Long getVo_176() {
		return vo_176;
	}

	public void setVo_176(Long vo_176) {
		this.vo_176 = vo_176;
	}

	public Long getVa_177() {
		return va_177;
	}

	public void setVa_177(Long va_177) {
		this.va_177 = va_177;
	}

	public Long getRv_177() {
		return rv_177;
	}

	public void setRv_177(Long rv_177) {
		this.rv_177 = rv_177;
	}

	public Long getVo_177() {
		return vo_177;
	}

	public void setVo_177(Long vo_177) {
		this.vo_177 = vo_177;
	}

	public Long getVa_178() {
		return va_178;
	}

	public void setVa_178(Long va_178) {
		this.va_178 = va_178;
	}

	public Long getRv_178() {
		return rv_178;
	}

	public void setRv_178(Long rv_178) {
		this.rv_178 = rv_178;
	}

	public Long getVo_178() {
		return vo_178;
	}

	public void setVo_178(Long vo_178) {
		this.vo_178 = vo_178;
	}

	public Long getVa_179() {
		return va_179;
	}

	public void setVa_179(Long va_179) {
		this.va_179 = va_179;
	}

	public Long getRv_179() {
		return rv_179;
	}

	public void setRv_179(Long rv_179) {
		this.rv_179 = rv_179;
	}

	public Long getVo_179() {
		return vo_179;
	}

	public void setVo_179(Long vo_179) {
		this.vo_179 = vo_179;
	}

	public Long getVa_180() {
		return va_180;
	}

	public void setVa_180(Long va_180) {
		this.va_180 = va_180;
	}

	public Long getRv_180() {
		return rv_180;
	}

	public void setRv_180(Long rv_180) {
		this.rv_180 = rv_180;
	}

	public Long getVo_180() {
		return vo_180;
	}

	public void setVo_180(Long vo_180) {
		this.vo_180 = vo_180;
	}

	public Long getVa_181() {
		return va_181;
	}

	public void setVa_181(Long va_181) {
		this.va_181 = va_181;
	}

	public Long getRv_181() {
		return rv_181;
	}

	public void setRv_181(Long rv_181) {
		this.rv_181 = rv_181;
	}

	public Long getVo_181() {
		return vo_181;
	}

	public void setVo_181(Long vo_181) {
		this.vo_181 = vo_181;
	}

	public Long getVa_182() {
		return va_182;
	}

	public void setVa_182(Long va_182) {
		this.va_182 = va_182;
	}

	public Long getRv_182() {
		return rv_182;
	}

	public void setRv_182(Long rv_182) {
		this.rv_182 = rv_182;
	}

	public Long getVo_182() {
		return vo_182;
	}

	public void setVo_182(Long vo_182) {
		this.vo_182 = vo_182;
	}

	public Long getVa_183() {
		return va_183;
	}

	public void setVa_183(Long va_183) {
		this.va_183 = va_183;
	}

	public Long getRv_183() {
		return rv_183;
	}

	public void setRv_183(Long rv_183) {
		this.rv_183 = rv_183;
	}

	public Long getVo_183() {
		return vo_183;
	}

	public void setVo_183(Long vo_183) {
		this.vo_183 = vo_183;
	}

	public Long getVa_184() {
		return va_184;
	}

	public void setVa_184(Long va_184) {
		this.va_184 = va_184;
	}

	public Long getRv_184() {
		return rv_184;
	}

	public void setRv_184(Long rv_184) {
		this.rv_184 = rv_184;
	}

	public Long getVo_184() {
		return vo_184;
	}

	public void setVo_184(Long vo_184) {
		this.vo_184 = vo_184;
	}

	public Long getVa_185() {
		return va_185;
	}

	public void setVa_185(Long va_185) {
		this.va_185 = va_185;
	}

	public Long getRv_185() {
		return rv_185;
	}

	public void setRv_185(Long rv_185) {
		this.rv_185 = rv_185;
	}

	public Long getVo_185() {
		return vo_185;
	}

	public void setVo_185(Long vo_185) {
		this.vo_185 = vo_185;
	}

	public Long getVa_186() {
		return va_186;
	}

	public void setVa_186(Long va_186) {
		this.va_186 = va_186;
	}

	public Long getRv_186() {
		return rv_186;
	}

	public void setRv_186(Long rv_186) {
		this.rv_186 = rv_186;
	}

	public Long getVo_186() {
		return vo_186;
	}

	public void setVo_186(Long vo_186) {
		this.vo_186 = vo_186;
	}

	public Long getVa_187() {
		return va_187;
	}

	public void setVa_187(Long va_187) {
		this.va_187 = va_187;
	}

	public Long getRv_187() {
		return rv_187;
	}

	public void setRv_187(Long rv_187) {
		this.rv_187 = rv_187;
	}

	public Long getVo_187() {
		return vo_187;
	}

	public void setVo_187(Long vo_187) {
		this.vo_187 = vo_187;
	}

	public Long getVa_188() {
		return va_188;
	}

	public void setVa_188(Long va_188) {
		this.va_188 = va_188;
	}

	public Long getRv_188() {
		return rv_188;
	}

	public void setRv_188(Long rv_188) {
		this.rv_188 = rv_188;
	}

	public Long getVo_188() {
		return vo_188;
	}

	public void setVo_188(Long vo_188) {
		this.vo_188 = vo_188;
	}

	public Long getVa_189() {
		return va_189;
	}

	public void setVa_189(Long va_189) {
		this.va_189 = va_189;
	}

	public Long getRv_189() {
		return rv_189;
	}

	public void setRv_189(Long rv_189) {
		this.rv_189 = rv_189;
	}

	public Long getVo_189() {
		return vo_189;
	}

	public void setVo_189(Long vo_189) {
		this.vo_189 = vo_189;
	}

	public Long getVa_190() {
		return va_190;
	}

	public void setVa_190(Long va_190) {
		this.va_190 = va_190;
	}

	public Long getRv_190() {
		return rv_190;
	}

	public void setRv_190(Long rv_190) {
		this.rv_190 = rv_190;
	}

	public Long getVo_190() {
		return vo_190;
	}

	public void setVo_190(Long vo_190) {
		this.vo_190 = vo_190;
	}

	public Long getVa_191() {
		return va_191;
	}

	public void setVa_191(Long va_191) {
		this.va_191 = va_191;
	}

	public Long getRv_191() {
		return rv_191;
	}

	public void setRv_191(Long rv_191) {
		this.rv_191 = rv_191;
	}

	public Long getVo_191() {
		return vo_191;
	}

	public void setVo_191(Long vo_191) {
		this.vo_191 = vo_191;
	}

	public Long getVa_192() {
		return va_192;
	}

	public void setVa_192(Long va_192) {
		this.va_192 = va_192;
	}

	public Long getRv_192() {
		return rv_192;
	}

	public void setRv_192(Long rv_192) {
		this.rv_192 = rv_192;
	}

	public Long getVo_192() {
		return vo_192;
	}

	public void setVo_192(Long vo_192) {
		this.vo_192 = vo_192;
	}

	public Long getVa_193() {
		return va_193;
	}

	public void setVa_193(Long va_193) {
		this.va_193 = va_193;
	}

	public Long getRv_193() {
		return rv_193;
	}

	public void setRv_193(Long rv_193) {
		this.rv_193 = rv_193;
	}

	public Long getVo_193() {
		return vo_193;
	}

	public void setVo_193(Long vo_193) {
		this.vo_193 = vo_193;
	}

	public Long getVa_194() {
		return va_194;
	}

	public void setVa_194(Long va_194) {
		this.va_194 = va_194;
	}

	public Long getRv_194() {
		return rv_194;
	}

	public void setRv_194(Long rv_194) {
		this.rv_194 = rv_194;
	}

	public Long getVo_194() {
		return vo_194;
	}

	public void setVo_194(Long vo_194) {
		this.vo_194 = vo_194;
	}

	public Long getVa_195() {
		return va_195;
	}

	public void setVa_195(Long va_195) {
		this.va_195 = va_195;
	}

	public Long getRv_195() {
		return rv_195;
	}

	public void setRv_195(Long rv_195) {
		this.rv_195 = rv_195;
	}

	public Long getVo_195() {
		return vo_195;
	}

	public void setVo_195(Long vo_195) {
		this.vo_195 = vo_195;
	}

	public Long getVa_196() {
		return va_196;
	}

	public void setVa_196(Long va_196) {
		this.va_196 = va_196;
	}

	public Long getRv_196() {
		return rv_196;
	}

	public void setRv_196(Long rv_196) {
		this.rv_196 = rv_196;
	}

	public Long getVo_196() {
		return vo_196;
	}

	public void setVo_196(Long vo_196) {
		this.vo_196 = vo_196;
	}

	public Long getVa_197() {
		return va_197;
	}

	public void setVa_197(Long va_197) {
		this.va_197 = va_197;
	}

	public Long getRv_197() {
		return rv_197;
	}

	public void setRv_197(Long rv_197) {
		this.rv_197 = rv_197;
	}

	public Long getVo_197() {
		return vo_197;
	}

	public void setVo_197(Long vo_197) {
		this.vo_197 = vo_197;
	}

	public Long getVa_198() {
		return va_198;
	}

	public void setVa_198(Long va_198) {
		this.va_198 = va_198;
	}

	public Long getRv_198() {
		return rv_198;
	}

	public void setRv_198(Long rv_198) {
		this.rv_198 = rv_198;
	}

	public Long getVo_198() {
		return vo_198;
	}

	public void setVo_198(Long vo_198) {
		this.vo_198 = vo_198;
	}

	public Long getVa_199() {
		return va_199;
	}

	public void setVa_199(Long va_199) {
		this.va_199 = va_199;
	}

	public Long getRv_199() {
		return rv_199;
	}

	public void setRv_199(Long rv_199) {
		this.rv_199 = rv_199;
	}

	public Long getVo_199() {
		return vo_199;
	}

	public void setVo_199(Long vo_199) {
		this.vo_199 = vo_199;
	}

	public Long getVa_200() {
		return va_200;
	}

	public void setVa_200(Long va_200) {
		this.va_200 = va_200;
	}

	public Long getRv_200() {
		return rv_200;
	}

	public void setRv_200(Long rv_200) {
		this.rv_200 = rv_200;
	}

	public Long getVo_200() {
		return vo_200;
	}

	public void setVo_200(Long vo_200) {
		this.vo_200 = vo_200;
	}
}