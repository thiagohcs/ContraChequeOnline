
$(function() {
	$("#new").focus();

	DadosProxy.findAll().done(findAllOk);

	MetadataProxy.getDemoiselleVersion().done(function(data) {
		$("#demoiselle-version").html(data);
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});

	$("#new").click(function() {
		location.href = "dados-edit.html";
	});

	$("#delete").click(function() {
		var ids = [];

		$("input:checked").each(function(index, value) {
			ids.push($(value).val());
		});

		if (ids.length == 0) {
			bootbox.alert({
				message : "Nenhum registro selecionado"
			});
		} else {
			bootbox.confirm("Tem certeza que deseja apagar?", function(result) {
				if (result) {
					DadosProxy.remove(ids).done(removeOk);
				}
			});
		}
	});
});

function findAllOk(data) {
	$('#resultList').dataTable({
		"aoColumns" : [ {
			"aTargets" : [ 0 ],
			"mDataProp" : "id",
			"mRender" : function(id) {
				return '<input id="remove-' + id + '" type="checkbox" value="' + id + '">';
			}

		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "folhaCompetencia",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.folhaCompetencia + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "cpfFuncionario",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.cpfFuncionario + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "nomeCompleto",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.nomeCompleto + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "tipoCodigo",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.tipoCodigo + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "descricao",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.descricao + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "salario",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.salario + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "dtNascimento",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.dtNascimento + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "cargo",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.cargo + '</a>';
		}

	
		}, {
		"aTargets" : [ 1 ],
		"mDataProp" : "folhaValor",
		"mRender" : function(data, type, full) {
			return '<a href="dados-edit.html?id=' + full.id + '">' + full.folhaValor + '</a>';
		}

							
		} ],
		"oLanguage" : {
			"sInfo" : "Mostrando _START_ a _END_ de _TOTAL_ registros",
			"sEmptyTable" : "Não há dados disponíveis na tabela",
			"sLengthMenu" : "Mostrar _MENU_ registros",
			"sInfoThousands" : "",
			"oPaginate" : {
				"sFirst" : "Primeiro",
				"sLast" : "Último",
				"sNext" : "Próximo",
				"sPrevious" : "Anterior"
			}
		},
		"bFilter" : false,
		"bDestroy" : true,
		"sPaginationType" : "bs_full",
		"aaData" : data,
		"bSort" : true
	});
}

function removeOk() {
	DadosProxy.findAll().done(findAllOk);
}