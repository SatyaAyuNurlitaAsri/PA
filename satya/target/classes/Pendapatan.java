<!DOCTYPE html>
<html>
<title>Admin Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" rel="stylesheet" /> 
<script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>


<style>
  
  html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
  .edit_cls {
    display: none;
    position: fixed; /* Stay in place */
      z-index: 1; /* Sit on top */
      padding-top: 100px; /* Location of the box */
      left: 21%;
      top: 0;
      width: 80%; /* Full width */
      height: 100%; /* Full height */
      overflow: auto; /* Enable scroll if needed */
  }
  .edit_ctn {
    position: relative;
      background-color: #fefefe;
      margin: auto;
      padding: 0;
      border: 1px solid #888;
      width: 80%;
      box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);
      -webkit-animation-name: animatetop;
      -webkit-animation-duration: 0.4s;
      animation-name: animatetop;
      animation-duration: 0.4s
  }
  /* Add Animation */
  @-webkit-keyframes animatetop {
      from {top:-300px; opacity:0} 
      to {top:0; opacity:1}
  }

  @keyframes animatetop {
      from {top:-300px; opacity:0}
      to {top:0; opacity:1}
  }
  .close {
      color: black;
      float: right;
      font-size: 28px;
      font-weight: bold;
  }

  .close: hover,
  .close: focus {
    cursor: pointer;
    color: #000;
      text-decoration: none;
  }
  .edit-header {
      padding: 2px 16px;
      background-color: #5cb85c;
      color: white;
  }

  .edit-body {padding: 2px 16px;}

  .edit-footer {
      padding: 2px 16px;
      background-color: #5cb85c;
      color: white;
  }

</style>

<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-indigo w3-large w3-text-white" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Menu</button>
  <span class="w3-bar-item w3-left">Dengue<strong>Risk</strong></span>
  <a href="/logout/do" class="w3-bar-item w3-button w3-right">Logout</a>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <div class="w3-col s4">
      <img src="/img/Niece.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>
    <div class="w3-col s4 w3-bar">
      <span>Welcome, <strong>Admin</strong></span><br>
    </div>
  </div>
  <hr>
  <div class="w3-container">
    <h5>Kelola Data</h5>
  </div>
  <div class="w3-bar-block">
    <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
    <!-- <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-eye fa-fw"></i>  Tampil Data</a> -->
    <a href="/AdminPage" class="w3-bar-item w3-button w3-padding" id="tampil-kasusdb"><i class="fa fa-edit fa-fw"></i>Kasus DB</a>
    <a href="/PadatPenduduk" class="w3-bar-item w3-button w3-padding w3-blue-gray" id="tampil-kepadatan"><i class="fa fa-edit fa-fw"></i>Kepadatan Penduduk</a>
    <a href="/Kemiskinan" class="w3-bar-item w3-button w3-padding" id="tampil-kemiskinan"><i class="fa fa-edit fa-fw"></i>Kemiskinan</a>
    <a href="/MelekHuruf" class="w3-bar-item w3-button w3-padding" id="tampil-melekhuruf"><i class="fa fa-edit fa-fw"></i>Angka Melek Huruf</a>
    <a href="#" class="w3-bar-item w3-button w3-padding" id="tampil-pendapatan"><i class="fa fa-edit fa-fw"></i>Pendapatan Perkapita</a>
    <a href="/DataKecamatan" class="w3-bar-item w3-button w3-padding" id="tampil-kecamatan"><i class="fa fa-edit fa-fw"></i>Data Kecamatan</a>
    <a href="#" class="w3-bar-item w3-button w3-padding"><i class="fa fa-cog fa-fw"></i>  Settings</a><br><br>
  </div>
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

  <!-- Header -->
  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Aset Database</b></h5>
  </header>

  <div class="w3-panel">
    <div class="w3-row-padding" style="margin:0 -16px">
      <div>
        <div class="w3-row">
        <div id="data-pendapatan">
          <div>
            <h5>Data Pendapatan Perkapita</h5>
          </div>
          <hr>

          <div class="w3-col l12">
            <div class="w3-col l4 w3-left">
                <a class="w3-button w3-blue w3-round-small w3-text-white w3-margin-bottom" onclick="document.getElementById('modal-tambah').style.display='block'">Tambah Data</a>
              </div>
              <div class="w3-col l4 w3-right">
                <input type="text" id="search-bar" class="w3-input w3-border w3-round" onkeyup="search()" placeholder="Cari ID Kecamatan">
              </div>
              <div class="w3-margin-bottom">&nbsp; 
              </div>

            <!-- menampilkan data Kasus DB -->
            <table class="w3-table w3-striped w3-white w3-bordered w3-border w3-margin-bottom" id="pendapatan_perkapita">
            <thead>
              <tr>
                <td><b>No</b></td>
                <td class="w3-center"><b>ID Kecamatan</b></td>
                <td class="w3-center"><b>Jumlah Pendapatan</b></td>
                <td class="w3-center"><b>Tahun</b></td>
                <td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kelola</b></td>
              </tr>
            </thead>
            <tbody id="tbl_body_pendapatan"></tbody>
            </table>

            <!-- pagination tabel kasus db -->
            <div class="w3-container">
                <div class="w3-center">
                  <div class="w3-bar w3-border" id="pagination">
                  </div>
                </div>
            </div>

            <!-- modal CRUD Kasus DB-->
            <!-- modal u/ insert -->
            <div class="w3-container">
              <div id="modal-tambah" class="w3-modal w3-cols">
                <div class="w3-col l3 w3-left">&nbsp;</div>
                <div class="w3-col l3 w3-right">&nbsp;</div>

                <div class="w3-modal-content w3-animate-top w3-card-4 w3-col l6">
                  <header class="w3-container w3-teal"> 
                    <span onclick="document.getElementById('modal-tambah').style.display='none'" 
                    class="w3-button w3-display-topright">&times;</span>
                    <h3>Data Pendapatan Perkapita</h3>
                  </header>
                  <br>
                  <div class="w3-container">
                    <div class="w3-col">

                      <!-- <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">ID Kecamatan</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="idkec-penduduk" placeholder="ID Kecamatan">
                      </div> -->

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">ID Kecamatan</label>
                        <select id="idkec" class="form-control select2"></select>
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Jumlah Pendapatan Perkapita</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="jmlpendapatan-pendapatan" placeholder="Jumlah Pendapatan">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Tahun</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="tahun-pendapatan" placeholder="tahun">
                      </div>
                      <br>
                    </div>

                    <div class="w3-right w3-margin-bottom">
                      <button class="w3-button w3-red w3-round w3-text-white" id="btn-batal-tambah" onclick="document.getElementById('modal-tambah').style.display='none'">Batal</button>
                      <button type="button" class="w3-button w3-green w3-round" id="btn-simpan-tambah" onclick="insertPendapatan()">Simpan</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- modal u/ edit -->
            <div class="w3-container">
              <div  id="modal-sunting" class="w3-modal w3-cols">
        
                <div class="w3-col l3 w3-left">&nbsp;</div>
                <div class="w3-col l3 w3-right">&nbsp;</div>

                <div class="w3-modal-content w3-animate-top w3-card-4 w3-col l6">
                  <header class="w3-container w3-green"> 
                    <span onclick="document.getElementById('modal-sunting').style.display='none'" 
                    class="w3-button w3-display-topright">&times;</span>
                    <h3 class="w3-text-white">Edit Data Pendapatan Perkapita</h3>
                  </header>
                  <br>
                  <div class="w3-container">
                    <div class="w3-col">

                    <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">ID Kecamatan</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-idkec" placeholder="ID Kecamatan">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Jumlah Pendapatan Perkapita</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-jmlpendapatan" placeholder="Jumlah Pendapatan Perkapita">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Tahun</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-tahun" placeholder="tahun">
                      </div>
                      <br>
                    </div>

                    <div class="w3-right w3-margin-bottom">
                      <button class="w3-button w3-red w3-round" id="btn-batal-sunting" onclick="document.getElementById('modal-sunting').style.display='none'">Batal</button>
                      <button type="button" class="w3-button w3-green w3-round w3-text-white" id="btn-update-sunting" onclick="putEditPendapatan()">Update</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- modal u/ hapus -->
            <div class="w3-container">
              <div id="modal-del" class="w3-modal w3-cols">

                <div class="w3-col l4 w3-left">&nbsp;</div>
                <div class="w3-col l4 w3-right">&nbsp;</div>
                <div class="w3-modal-content w3-animate-top w3-card-4 w3-col l4">
                  <div class="w3-container">
                    <div class="w3-margin-bottom w3-margin-top">
                      <p>Apakah anda yakin ingin menghapus data ini?</p>
                    </div>
                    <div class="w3-right w3-margin-top w3-margin-bottom">
                      <button class="w3-button w3-red w3-round w3-text-white w3-padding-small" id="btn-batal-del" onclick="document.getElementById('modal-del').style.display='none'">Batal</button>
                      <button type="button" class="w3-button w3-grey w3-round w3-text-white w3-padding-small" id="btn-hapus-del" onclick="hapusPendapatan()">OK</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <script>
            let halamanMax;
            let hal;
            let maxHal;
            //untuk search berdasarkan nama
            function search(){
              let search = document.getElementById("search-bar");
              let filter = search.value.toUpperCase();
              let tabel = document.getElementById("pendapatan_perkapita");
              let tr = tabel.getElementsByTagName("tr");
              // console.log(tr);

              for (var i = 0; i < tr.length; i++) {
                let td = tr[i].getElementsByTagName("td")[1];
                // console.log(td);

                if (td) {
                  if (td.innerHTML.toUpperCase().indexOf(filter) > -1){
                    tr[i].style.display = "";
                  } else {
                    tr[i].style.display = "none";
                  }
                }
              }
            }

            //pagination
             // hal = 1;
                function getPagination() {
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                      console.log(JSON.parse(this.responseText));
                    }
                  }

                  xhr.open("GET", "/api/pendapatan_perkapita?hal=" + hal, true);
                  xhr.send();
                }

                function openPage(halaman) {
                  if (halaman < 1) {
                        halaman = 1;
                    } else if(halaman >= maxHal){
                        halaman = maxHal;
                    }

                    hal = halaman;
                    resetTabelPendapatan();
                    showTablePendapatan();
                }

                function nextPage() {
                    openPage(hal+1);
                }

                function prevPage() {
                    openPage(hal-1);
                }
                function getMaxPage() {
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                      halamanMax = JSON.parse(this.responseText);
                      fillPagination();
                      openPage(1);
                    }
                  };

                  xhr.open("GET", "/api/max-hal/pendapatan", true);
                  xhr.send();
                }

                function fillPagination() {
                  let page = document.getElementById("pagination");

                  for (var i = 0; i < halamanMax+2; i++) {
                    let a = document.createElement("a");
                    let aTeks = document.createTextNode(i);

                    a.setAttribute("onclick", "openPage(" + i + ")");

                    if (i == 0) {
                        aTeks = document.createTextNode('\u00AB');
                        a.setAttribute("onclick","prevPage()");
                    } else if (i == halamanMax+1) {
                        console.log(i);
                        aTeks = document.createTextNode('\u00BB');
                        a.setAttribute("onclick","nextPage()");
                    }

                    a.setAttribute("class","w3-button");
                    a.appendChild(aTeks);
                    page.appendChild(a);
                  }
                }
                //finish pagination


            function showTablePendapatan(){
                  let nomor = 1;
                  let tbl;
                  let xmlhttp = new XMLHttpRequest();

                  xmlhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                      // console.log(JSON.parse(this.responseText));
                      let data = JSON.parse(this.responseText);
                      let tabelBody = document.getElementById("tbl_body_pendapatan");

                      data.forEach(function(datum){
                        // console.log(datum);
                        let trIdKec = document.createElement("tr");
                        let tdIdKec = document.createElement("td");
                        let tdNomor = document.createElement("td");
                        let tdJmlPendapatan = document.createElement("td");
                        let tdTahun = document.createElement("td");
                        let tdKelola = document.createElement("td");
                        let btnEdit = document.createElement("button");
                        let btnHapus = document.createElement("button");

                        trIdKec.setAttribute("class", "baris-pendapatan");
                        btnEdit.setAttribute("class", "w3-button w3-green w3-round-small w3-padding-small w3-text-white");
                        btnEdit.setAttribute("onclick", "updatePendapatan(" + datum.id + ")");
                        btnHapus.setAttribute("class", "w3-button w3-red w3-round-small w3-padding-small");
                        btnHapus.setAttribute("onclick", "tampilMdlHapusPendapatan(" + datum.id + ")");
                        tdIdKec.setAttribute("class", "w3-center");
                        tdJmlPendapatan.setAttribute("class", "w3-center");
                        tdTahun.setAttribute("class", "w3-center");
                        

                        let nomorTeks = document.createTextNode(nomor);
                        let idkecTeks = document.createTextNode(datum.idKec);
                        let jmlpendapatanTeks = document.createTextNode(datum.jmlPendapatan);
                        let tahunTeks = document.createTextNode(datum.tahun);
                        let editTeks = document.createTextNode("edit");
                        let hapusTeks = document.createTextNode("hapus");
                        let spasi = document.createTextNode(" ");

                        // namaParent.appendChild(namaChild)
                        btnEdit.appendChild(editTeks);
                        btnHapus.appendChild(hapusTeks);
                        tdNomor.appendChild(nomorTeks);
                        tdIdKec.appendChild(idkecTeks);     
                        tdJmlPendapatan.appendChild(jmlpendapatanTeks);
                        tdTahun.appendChild(tahunTeks);
                        tdKelola.appendChild(btnEdit);
                        tdKelola.appendChild(spasi);
                        tdKelola.appendChild(btnHapus);

                        trIdKec.appendChild(tdNomor);
                        trIdKec.appendChild(tdIdKec);
                        trIdKec.appendChild(tdJmlPendapatan);
                        trIdKec.appendChild(tdTahun);
                        trIdKec.appendChild(tdKelola);
                        tabelBody.appendChild(trIdKec);

                        // console.log("sensor"+nomor);
                        nomor++;
                      });
                    }
                  };
                  xmlhttp.open("GET", "/api/pendapatan?hal=" +hal, true);
                  xmlhttp.send();
                }

                // tambah data kasusdb
                function insertPendapatan(){
                  //let idKec = document.getElementById("idkec-penduduk").value;
                  let idKec = $("#idkec option:selected").val();
                  let jmlPendapatan = document.getElementById("jmlpendapatan-pendapatan").value;
                  let th = document.getElementById("tahun-pendapatan").value;

                  let JSONObject = {
                    "idKec" : idKec,
                    "jmlPendapatan" : jmlPendapatan,
                    "tahun" : th,
                    };

                    // console.log(idKel);
                  postPendapatan(JSONObject);
                  //document.getElementById("idkec-penduduk").value="";
                  $("#idkec").val('').trigger('change');
                  document.getElementById("jmlpendapatan-pendapatan").value="";
                  document.getElementById("tahun-pendapatan").value="";
                  // console.log(idkelKasusDb);
                }

                function postPendapatan(data){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                      if(JSON.parse(this.responseText))
                      {
                        document.getElementById("modal-tambah").style.display = "none";
                        resetTabelPendapatan();
                        showTablePendapatan();
                      }
                    }
                  };

                  xhr.open("POST", "/api/pendapatan", true);
                  xhr.setRequestHeader("Content-type","application/json");
                  xhr.send(JSON.stringify(data));
                }

                function resetTabelPendapatan(){
                  let barisPendapatan = document.getElementsByClassName("baris-pendapatan");

                  while(barisPendapatan.length){
                    barisPendapatan[0].parentNode.removeChild(barisPendapatan[0]);
                  }
                }

                // edit & update data sensor
                var idEdit = 0;
                function updatePendapatan(id){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function(){
                    if (this.readyState == 4 && this.status == 200) {
                      idEdit = id;

                      editModalPendapatan(JSON.parse(this.responseText));
                    }
                  };

                  xhr.open("GET", "/api/pendapatan/" + id, true);
                  xhr.send();
                }

                function editModalPendapatan(data){
                    console.log(data)
                    document.getElementById("edit-idkec").value = data.idKec;
                    document.getElementById("edit-jmlpendapatan").value = data.jmlPendapatan;
                    document.getElementById("edit-tahun").value = data.tahun;
                    
                    document.getElementById("modal-sunting").style.display = "block";
                }

                // meletakkan data sensor ke db
                function putEditPendapatan(){
                    let editIdKec = document.getElementById("edit-idkec").value;
                    let editJmlPendapatan = document.getElementById("edit-jmlpendapatan").value;
                    let editTahun = document.getElementById("edit-tahun").value;
                    
                  let editJSONObject = {
                    "id" : idEdit,
                    "idKec" : editIdKec,
                    "jmlPendapatan" : editJmlPendapatan,
                    "tahun" : editTahun,
                    };
                    // console.log(editJSONObject);
                  postEditPendapatan(editJSONObject);
                }

                function postEditPendapatan(data){
                  let xhttp = new XMLHttpRequest();
                  
                  xhttp.onreadystatechange = function(){
                    // console.log(this);
                    if (this.readyState == 4 && this.status == 200) {
                      if(JSON.parse(this.responseText))
                      {
                        resetTabelPendapatan();
                        showTablePendapatan();
                        document.getElementById("modal-sunting").style.display = "none";
                      }
                    }
                  };

                  console.log(data);

                  xhttp.open("PUT", "/api/pendapatan", true);
                  xhttp.setRequestHeader("Content-type","application/json");
                  // console.log(data);
                  xhttp.send(JSON.stringify(data));
                }

                //fungsi u/ hapus
                let idToDelete = 0;
                function tampilMdlHapusPendapatan(id){
                  document.getElementById('modal-del').style.display='block';
                  idToDelete = id;
                }

                function hapusPendapatan(){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function(){
                    if (this.readyState == 4 && this.status == 200) {
                      if (JSON.parse(this.responseText))
                      {
                        document.getElementById("modal-del").style.display = "none";
                        resetTabelPendapatan();
                        showTablePendapatan();
                      }
                    }
                  };
                  console.log(idToDelete);
                  xhr.open("DELETE", "/api/pendapatan/" +idToDelete, true);
                  xhr.send();
                }
                getMaxPage();
                //showTablePenduduk();
                //getKasusDb();
                //initMap();

                </script>
            </div>
          </div>
        </div>

        <script>
            
        </script>
            <br>


      <!-- tampilan map -->
      <div class="w3-container">
        <h5>Lokasi</h5>
        <div class="w3-grey">
          <!-- <div class="w3-container w3-center w3-padding w3-green" style="width:25%">+25%</div> -->
          <div id="map" style="width: 100%; height: 400px"></div>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCw4g4V9MtupcGa7PjP6APSX0UFNyOe-08"></script>
        
        <script>
            var infoWindow;
            var map;

            function getData() {
              var xhttp = new XMLHttpRequest();
              xhttp.onreadystatechange = function() {
                if (xhttp.readyState == 4 && xhttp.status == 200) {
                  fillMap(JSON.parse(xhttp.responseText));
                }
              };
              xhttp.open("GET", "/api/sby_kecamatan", true);
              xhttp.send();
            }

            function fillMap(data){
              // console.log(data);
              initMap(data);
            }

          function initMap(data = []) {
              map = new google.maps.Map(document.getElementById('map'), {
              center: {lat: -7.2763472, lng: 112.7192666},
              zoom: 12,
          mapTypeId: 'terrain'
            });

              data.forEach(function(kecamatan){
                // console.log("Isinya GEOM: "+kecamatan.geom);
                // console.log("Hallo");
                if (kecamatan.geom != null) {
                  var tepi = kecamatan.geom.replace("MULTIPOLYGON(((","").replace(")))","").split(",");
                      var batas = [];
                      // console.log(tepi);

                      var warna = '#b50c15';
                      // console.log(warna);

                      tepi.forEach(function(geom) {
                          var latLng = geom.split(" ");
                           // console.log(latLng);

                          batas.push({
                              lat: parseFloat(latLng[1]),
                              lng: parseFloat(latLng[0])
                          });
                          // console.log(batas);
                      });

                      var kecamatanPoly = new google.maps.Polygon({
                          paths: batas,
                          strokeColor: '#000000',
                          strokeOpacity: 1,
                          strokeWeight: 0.5,
                          fillColor: warna,
                          fillOpacity: 0.6
                      });
                      //console.log(geom.warna);

                      google.maps.event.addListener(kecamatanPoly,'click',function() {
                          //console.log(kecamatan.daerah);
                           infoWindow.setContent('<b>' + kecamatan.daerah + '<br>Jumlah kejadian: ' + kecamatan.kejadian + '</b>');
                           infoWindow.setPosition(batas[0]);
                           infoWindow.open(map);
                      });
                        kecamatanPoly.setMap(map);
                }
              });

              infoWindow = new google.maps.InfoWindow;
            }
            getData();
            </script>

            <!--Menampilkan option bar nama kecamatan-->
            <script>
            $(document).ready(function(){
              $('#idkec').select2({ 
                placeholder: 'Pilih Kecamatan', 
                ajax: {
                  url: 'http://localhost:8080/api/option/kecamatan',
                  type: 'GET', 
                  dataType: 'json', 
                  delay: 250, 
                  data: function(params){ 
                    // console.log(params); 
                    return{ 
                      keyword: params.term 
                    }; 
                  }, 
                  processResults: function (response) { 
                    // console.log(response); 
                    return { 
                      results: response 
                    }; 
                  } 
                }, 
                cache: true
              }).on('select2:select', function (evt) {
                var id_provinsi = $("#selKabAdd option:selected").val(); 
                // console.log(data);
              });

              $('#idkec-edit').select2({ 
                placeholder: 'Pilih Kecamatan', 
                ajax: {
                  url: 'http://localhost:8080/api/option/kecamatan',
                  type: 'GET', 
                  dataType: 'json', 
                  delay: 250, 
                  data: function(params){ 
                    // console.log(params); 
                    return{ 
                      keyword: params.term 
                    }; 
                  }, 
                  processResults: function (response) { 
                    // console.log(response); 
                    return { 
                      results: response 
                    }; 
                  } 
                }, 
                cache: true
              }).on('select2:select', function (evt) {
                var id_provinsi = $("#selKabAdd option:selected").val(); 
                // console.log(data);
              });

            });
            </script>

        </div>

      <!-- Footer -->
      <footer class="w3-container w3-padding-16 w3-light-grey">
        <!-- <h4>FOOTER</h4> -->
        <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
      </footer>

      <!-- End page content -->
    </div>

    <script>
    // Get the Sidebar
    var mySidebar = document.getElementById("mySidebar");

    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

    // Toggle between showing and hiding the sidebar, and add overlay effect
    function w3_open() {
        if (mySidebar.style.display === 'block') {
            mySidebar.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidebar.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

    // Close the sidebar with the close button
    function w3_close() {
        mySidebar.style.display = "none";
        overlayBg.style.display = "none";
    }
    </script>

    </body>
    </html>
