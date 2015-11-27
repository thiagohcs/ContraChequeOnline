$(function() {
	$("#new").focus();

	UsuarioProxy.findAll().done(findAllOk);

	MetadataProxy.getDemoiselleVersion().done(function(data) {
		$("#demoiselle-version").html(data);
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});

	$("#new").click(function() {
		location.href = "usuario-edit.html";
	});

	$("#update").click(function() {

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
					UsuarioProxy.remove(ids).done(removeOk);
				}
			});
		}
	});
});

function findAllOk(data) {
	console.log(data);
	$('#resultList')
			.dataTable(
					{
						"aoColumns" : [
								{
									"aTargets" : [ 0 ],
									"mDataProp" : "id",
									"mRender" : function(id) {
										return '<input id="remove-' + id
												+ '" type="checkbox" value="'
												+ id + '">';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "nome",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">' + full.nome
												+ '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "login",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">' + full.login
												+ '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "senha",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">' + full.senha
												+ '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "ativo",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">'
												+ status(full.ativo) + '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "perfil",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">'
												+ perfil(full.perfil) + '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "empresa",
									"mRender" : function(data, type, full) {
										return '<a href="usuario-edit.html?id='
												+ full.id + '">' + full.empresa
												+ '</a>';
									}

								},
								{
									"aTargets" : [ 1 ],
									"mDataProp" : "empresa",
									"mRender" : function(data, type, full) {
										return '<div class="dropdown">'
												+ '<button class="btn btn-default dropdown-toggle" id="dropdownMenu1" type="button" data-toggle="dropdown"'
												+ 'aria-haspopup="true" aria-expanded="true"> <i class="icon-pencil"></i>'
												+ 'Ações'
												+ '<span class="caret"></span> '
												+ '</button> '
												+ '<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">'
												+ '<li><a href="#" data-toggle="modal" data-target="#editUsuario"><i class="icon-pencil"></i> Editar</a></li>'
												+ '<li><a href="#" data-toggle="modal" data-target="#removeUsuario"><i class="icon-trash"></i> Apagar</a></li>'
												+ '<li class="divider"></li>'
												+ '<li><a href="#" data-toggle="modal" data-target="#myModal"><i class="i"></i> Tornar Administrador</a></li>'
												+ '</ul>' + '</div>';
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
	UsuarioProxy.findAll().done(findAllOk);
}

function status(boolean) {
	if (boolean == true)
		return "Ativo";
	else
		return "Inativo";
}

function perfil(int) {
	if (int == 0)
		return "Usuário";
	else
		return "Adiministrador";
}