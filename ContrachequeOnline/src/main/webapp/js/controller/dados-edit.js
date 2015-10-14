
$(function() {
	$("#delete").hide();

	if (id = App.getUrlParameterByName('id')) {
		DadosProxy.load(id).done(loadOk).fail(loadFailed);
	}

	MetadataProxy.getDemoiselleVersion().done(function(data) {
		$("#demoiselle-version").html(data);
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});	
	$("#save").click(function() {
	var data = {

			folhaCompetencia : $("#folhaCompetencia").val(),

			cpfFuncionario : $("#cpfFuncionario").val(),

			nomeCompleto : $("#nomeCompleto").val(),

			tipoCodigo : $("#tipoCodigo").val(),

			descricao : $("#descricao").val(),

			salario : $("#salario").val(),

			dtNascimento : $("#dtNascimento").val(),

			cargo : $("#cargo").val(),

			folhaValor : $("#folhaValor").val(),

		};
		if (id = $("#id").val()) {
			DadosProxy.update(id, data).done(saveOk).fail(saveFailed);
		} else {
			DadosProxy.insert(data).done(saveOk).fail(saveFailed);
		}
	});

	$("#delete").click(function() {
		bootbox.confirm("Tem certeza que deseja apagar?", function(result) {
			if (result) {
				DadosProxy.remove([ $("#id").val() ]).done(removeOk);
			}
		});
	});

	$("#back").click(function() {
		history.back();
	});


	$("#dtNascimento").datepicker({
	showButtonPanel : true,
	dateFormat : "yy-dd-mm",
	regional : "pt-BR"
});


});

function loadOk(data) {
	$("#id-row").show();
	$("#id-text").html(data.id);
	$("#id").val(data.id);
	
	$("#id").val(data.id);

	$("#folhaCompetencia").val(data.folhaCompetencia);

	$("#cpfFuncionario").val(data.cpfFuncionario);

	$("#nomeCompleto").val(data.nomeCompleto);

	$("#tipoCodigo").val(data.tipoCodigo);

	$("#descricao").val(data.descricao);

	$("#salario").val(data.salario);

	$("#dtNascimento").val(data.dtNascimento);

	$("#cargo").val(data.cargo);

	$("#folhaValor").val(data.folhaValor);
	
	$("#delete").show();
}

function loadFailed(request) {
	switch (request.status) {
		case 404:
			bootbox.alert("Você está tentando acessar um registro inexistente!", function() {
				location.href = "dados-list.html";
			});
			break;

		default:
			break;
	}
}

function saveOk(data) {
	location.href = 'dados-list.html';
}

function saveFailed(request) {
	switch (request.status) {
		case 422:
			$($("form input").get().reverse()).each(function() {
				var id = $(this).attr('id');
				var message = null;

				$.each(request.responseJSON, function(index, value) {
					if (id == value.property) {
						message = value.message;
						return;
					}
				});

				if (message) {
					$("#" + id + "-message").html(message).show();
					$(this).focus();
				} else {
					$("#" + id + "-message").hide();
				}
			});
			break;
		default:
			break;
	}
}
function removeOk(data) {
	location.href = 'dados-list.html';
}