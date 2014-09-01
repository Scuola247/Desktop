Ext.define('Desktop.shared.SharedStorage', {
    mixins: {
        observable: 'Ext.util.Observable'
    },
    
    singleton: true,

    //info utente collegato
    user: null,
    persona: null,

    //dati spazio lavoro
    sl_spazio_lavoro: null,
    sl_descrizione: null,
    sl_istituto: null,
    sl_anno_scolastico: null,
    sl_classe: null,
    sl_materia: null,
    sl_docente: null,
    sl_famigliare: null,
    sl_alunno: null,
    
    //costruttore
    constructor: function (config) {
        // The Observable constructor copies all of the properties of `config` on
        // to `this` using Ext.apply. Further, the `listeners` property is
        // processed to add listeners.
        //
        this.mixins.observable.constructor.call(this, config);

        this.addEvents(
            'spazioLavoroChanged',
            'reloadRoles'
        );
    },
    changeSpazioLavoro : function (spazioLavoro) {
    	
    	var reloadRoles = !Ext.isEmpty(this.sl_istituto) && this.sl_istituto != spazioLavoro.get("istituto");
    	
		this.sl_spazio_lavoro = spazioLavoro.get("spazio_lavoro");
		this.sl_descrizione = spazioLavoro.get("descrizione");
		this.sl_istituto = spazioLavoro.get("istituto");
		this.sl_anno_scolastico = spazioLavoro.get("anno_scolastico");
		this.sl_classe = spazioLavoro.get("classe");
		this.sl_materia = spazioLavoro.get("materia");
		this.sl_docente = spazioLavoro.get("docente");
		this.sl_famigliare = spazioLavoro.get("famigliare");
		this.sl_alunno = spazioLavoro.get("alunno");
		this.fireEvent('spazioLavoroChanged',{});
		
		if (!Ext.isEmpty(this.sl_spazio_lavoro) && this.sl_spazio_lavoro != -1){
			spazioLavoroDefaultService.setSpazioLavoroDefault(this.sl_spazio_lavoro, reloadRoles, function(provider, response) {
				   // process response
					if (!response.result.ok){
						Ext.Msg.show({
		                	title:i18n.workspace_selection_error,
		                	buttons: Ext.Msg.OK,
		                	msg: Desktop.ux.util.ExceptionDecoder.decode(response.result),
		                	icon: Ext.MessageBox.ERROR
		                });
					}
					else{
				    	if (reloadRoles){
				    		this.fireEvent('reloadRoles',{});
				    	}
					}
				}, this);
		}
    }
});