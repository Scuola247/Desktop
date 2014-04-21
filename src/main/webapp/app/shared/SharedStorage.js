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
            'spazioLavoroChanged'
        );
    },
    changeSpazioLavoro : function (spazioLavoro) {
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
			spazioLavoroDefaultService.setSpazioLavoroDefault(this.sl_spazio_lavoro, function(provider, response) {
				   // process response
					if (response.result != "OK"){
						//response.result è il messaggio di errore
						Ext.Msg.show({
		                	title:i18n.workspace_selection_error,
		                	buttons: Ext.Msg.OK,
		                	msg: response.result,
		                	icon: Ext.MessageBox.ERROR
		                });
					}
				}, this);
		}
    }
});