Ext.define('Desktop.controller.ClassRegister', {
	extend: 'Deft.mvc.ViewController',
	inject: ['sharedStorage'],
	requires: [], 

	config: {
		sharedStorage: null,
		descrizione: null,
		istituto: null,
		anno_Scolastico:null,
		classe: null,
		docente: null,
		materia: null
	},
	
	control: {
		view: {
			show: 'onShow'
		},
		classRegisterTabPanel: {
			tabchange: 'onClassRegisterTabPanelChange'
		},
		printRegisterButton: {
			click: 'onClickPrintRegisterButton'
		},
		studentsGrid: true,
		teachersGrid: true,
		signaturesGrid: true,
		lessonsGrid: true,
		notesGrid: true,
		scheduleGrid: true,
		scheduleGridWeek:{
			change : 'onChangeScheduleGridWeek'
		},
		teachersScheduleGrid: true,
		teachersScheduleGridWeek:{
			change : 'onChangeTeachersScheduleGridWeek'
		}
		
	},
	
	onShow: function() {
		var view = this.getView();

		var sharedStorage = this.getSharedStorage();
		this.setDescrizione(sharedStorage.sl_descrizione);
		
		this.setIstituto(sharedStorage.sl_istituto);
		this.setAnno_Scolastico(sharedStorage.sl_anno_scolastico);
		this.setClasse(sharedStorage.sl_classe);
		this.setDocente(sharedStorage.sl_docente);
		this.setMateria(sharedStorage.sl_materia);
		
		if (Ext.isEmpty(this.getClasse())){
			Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_class);
			view.destroy();
		}
		else{
			if (Ext.isEmpty(this.getDocente())){
				Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_teacher);
				view.destroy();
			}
			else{
				if (Ext.isEmpty(this.getMateria())){
					Desktop.ux.window.Notification.info(i18n.important, i18n.workspace_required_subject);
					view.destroy();
				}
				else{
					// ho tutto il necessario preparo la finistra
					view.setTitle(i18n.teacher_register_title + " - " + this.getDescrizione());
					
					this.getStudentsGrid().getStore().load({
																params: {
																	classe:this.getClasse()
																}
					});
					this.getSignaturesGrid().getStore().load({
																params: {
																	classe:this.getClasse(),
																	docente:this.getDocente()
																}
					});
					this.getLessonsGrid().getStore().load({
																params: {
																	classe:this.getClasse(),
																	docente:this.getDocente(),
																	materia:this.getMateria()
																}
					});
				}
			}
		}
	},
	onClassRegisterTabPanelChange: function ( tabPanel, newCard, oldCard, eOpts ) {
		// do nothing
	},
	onClickPrintRegisterButton: function ( button, e, eOpts ){
		var istituto = this.getIstituto();
		var anno_scolastico = this.getAnno_Scolastico();
		var classe = this.getClasse();
		
		var url = app_context_path + "/print/registroDiClasse/" + istituto + "/" + anno_scolastico + "/" + classe;
		window.open(url, i18n.class_register_title);
	},
	onChangeScheduleGridWeek:  function ( combo, newValue, oldValue, eOpts ){
		
	},
	onChangeTeachersScheduleGridWeek: function ( combo, newValue, oldValue, eOpts ){
		
	}
	
});