var claimData = [];

function getAllClaims() {
    $.get('http://localhost:8080/fetch/claims', function(data) {
        var str = `<table style="width:400px">
        <tr>
          <th>ID</th>
          <th>Name</th> 
          <th>Status</th>
          <th></th>
        </tr>`;
        data.forEach(element => {
            str += "<tr class='each-row'><td>" + element.claimId + "</td><td>" + element.name + "</td><td>" + element.status + "</td><td><button onclick='edit(" + element.claimId + ")' value='Edit status'>Edit status</button></td></tr>";
        });
        str += "</table>";
        $("#cont").empty().append(str);
    });
}

function save() {
    $.post("http://localhost:8080/save/claim", {
        name: $("#name").val(),
        status: $("#status").val()
    }, function (str) {
        $("#msg").empty().append(str);
        getAllClaims();
    });
}


function edit(id) {
    $.post("http://localhost:8080/update/claim", {
        ID: id,
        name: $("#name").val(),
        status: $("#status").val()
    }, function (str) {
        $("#msg").empty().append(str);
        getAllClaims();
    });
}

$('document').ready(function(event) {
    getAllClaims();

    $("#create").on("click", save);
});



