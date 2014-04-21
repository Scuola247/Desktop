Ext.define('Desktop.controller.TeacherRegister', {
	extend: 'Deft.mvc.ViewController',
	mixins: ['Deft.mixin.Injectable'],
	inject: ['sharedStorage'],
	requires: [], 

	config: {
		sharedStorage: null,
		descrizione: null,
		classe: null,
		docente: null,
		materia: null
	},
	
	control: {
		view: {
			show: 'onShow'
		},
		teacherRegisterTabPanel: {
			tabchange: 'onTeacherRegisterTabPanelChange'
		},
		judgmentGrid: true,
		studentsGrid: true,
		signaturesGrid: true,
		lessonsGrid: true,
		addPersonalNoteButton:{
			click : 'onClickAddPersonalNoteButton'
		},
		scheduleGridWeek:{
			change : 'onChangeScheduleGridWeek'
		},
		personalScheduleGridWeek:{
			change : 'onChangePersonalScheduleGridWeek'
		}
		
	},
	
	onShow: function() {
		var view = this.getView();

		var sharedStorage = this.getSharedStorage();
		this.setDescrizione(sharedStorage.sl_descrizione);
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
					
					var columns = this.getJudgmentGrid().columns;
					
					for (var i = 3; i < columns.length; i++){
						var colonna = columns[i];
						if (i < 50){
							colonna.setText("aa: " + i);
							colonna.setVisible(true);
						}
					}
					
					this.getJudgmentGrid().doLayout();

					
					this.getJudgmentGrid().getStore().load({
																params: {
																	classe:this.getClasse()
																}
					});
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
	onTeacherRegisterTabPanelChange: function ( tabPanel, newCard, oldCard, eOpts ) {
		// do nothing
	},
	onClickAddPersonalNoteButton: function (){
		alert("Inserisci nuova nota");
	},
	onChangeScheduleGridWeek:  function ( combo, newValue, oldValue, eOpts ){
		
	},
	onChangePersonalScheduleGridWeek: function ( combo, newValue, oldValue, eOpts ){
		
	}
	
});