var DadosProxy = {

	url : "api/dados",

	findAll : function() {
		return $.ajax({
			type : "GET",
			url : this.url,
			beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}
		});
	},

	load : function(id) {
		return $.ajax({
			type : "GET",
			url : this.url + "/" + id,
			beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}
		});
	},

	insert : function(dados) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(dados),
			contentType : "application/json",
			beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}
		});
	},

	update : function(id, dados) {
		return $.ajax({
			type : "PUT",
			url : this.url + "/" + id,
			data : JSON.stringify(dados),
			contentType : "application/json",
			beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}
		});
	},

	remove : function(ids) {
		return $.ajax({
			type : "DELETE",
			url : this.url,
			data : JSON.stringify(ids),
			contentType : "application/json",
			beforeSend : function(jqXHR) {
				App.auth.setHeader(jqXHR)
			}
		});
	}
};