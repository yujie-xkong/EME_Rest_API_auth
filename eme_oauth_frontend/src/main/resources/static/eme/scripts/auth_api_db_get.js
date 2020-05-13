function get_contact(id, statuses, searchText){
  if (statuses.length == 0)
     statuses = 'ALL'
  var xhr = new XMLHttpRequest();
  xhr.open("GET", 
           "http://localhost:8888/Authorization/v1/getAuthDashboard?searchText=" + searchText + " &companyName=ALL&jobNumber=ALL&testReason=ALL&statusContext=" + statuses,
           true);
  xhr.onload = function () {
    if (this.readyState == 4 && this.status == 200) {
        var response_json = JSON.parse(xhr.responseText);
        // add error handling TBD 
        createTable(response_json.value);
    }
  };
  xhr.send();
}

function createTable(tableData){
  generateTableRows(tableData);
}

function generateTableRows(data) {
    var table = $('#Dashboard_table').DataTable({
        "retrieve": true,
        "data": data,
        "columns": [
          { "data": "lastName" },
          { "data": "firstName"},
          { "data": "dob"},
          { "data": "jobNumber"},
          { "data": "testReasonDescription"},
          { "data": "companyName"},
          { "data": "status"},
          { "data": "lastUpdate"}
        ],
        "dom": '<"top"i>rt<"bottom"lp><"clear">'
    });  
    table.clear();
    table.rows.add(data);
    table.draw();
}
