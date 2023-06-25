$(document).on("click", "#btnagregar", function(){
    $("#txtnomMar").val("");
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomMar").val($(this).attr("data-nomMar"));
    $("#modalNuevo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/Marca/registrarMarca",
        contentType: "application/json",
        data: JSON.stringify({
            codMar: $("#hddcodMar").val(),
            nomMar: $("#txtnomMar").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarMarca();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

$(document).on("click", ".btneliminar", function(){
    $("#hddcodMareliminar").val($(this).attr("data-codMar"));
    $("#textomodaleliminar").text("¿Está seguro de eliminar la Marca "+
        $(this).attr("data-nomMar")+ "?");
    $("#modalEliminar").modal("show");
})

$(document).on("click", "#btneliminar", function(){
    var codMar = $("#hddcodMareliminar").val();
    $.ajax({
        type: "DELETE",
        url: "/Marca/eliminarMarca",
        contentType: "application/json",
        data: JSON.stringify({
            codMar: codMar
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarMarca();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalEliminar").modal("hide");
});

function ListarMarca(){
    $.ajax({
        type: "GET",
        url: "/Marca/listarMarcas",
        dataType: "json",
        success: function(resultado){
            $("#tblmarca > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblmarca > tbody").append("<tr>"+
                    "<td>"+value.codMar+"</td>"+
                    "<td>"+value.nomMar+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-codMar='"+value.codMar+"'"+
                                     "data-nomMar='"+value.nomMar+"'"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-codMar='"+value.codMar+"'"+
                                     "data-nomMar='"+value.nomMar+"'><i class='fas fa-trash-alt'></i></button>"+
                    "</td></tr>");
            })
        }
    })
}