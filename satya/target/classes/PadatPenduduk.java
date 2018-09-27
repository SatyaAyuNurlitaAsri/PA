<!DOCTYPE html>
<html>
<title>Admin Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
  <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Menu</button>
  <span class="w3-bar-item w3-left">Dengue<strong>Risk</strong></span>
  <a href="/logout/do" class="w3-bar-item w3-button w3-right">Logout</a>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
  <div class="w3-container w3-row">
    <!--<div class="w3-col s4">
      <img src="/img/Niece.png" class="w3-circle w3-margin-right" style="width:46px">
    </div>-->
    <div class="w3-col s8 w3-bar">
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
    <a href="#" class="w3-bar-item w3-button w3-padding w3-blue" id="tampil-kasusdb"><i class="fa fa-edit fa-fw"></i>Kasus DB</a>
    <a href="#" class="w3-bar-item w3-button w3-padding" id="tampil-kepadatan"><i class="fa fa-edit fa-fw"></i>Kepadatan Penduduk</a>
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
        <div id="data-kasusdb">
          <div>
            <h5>Data Kasus DB</h5>
          </div>
          <hr>

          <div class="w3-col l12">
            <div class="w3-col l4 w3-left">
              <a class="w3-button w3-green w3-round-small w3-text-white" onclick="document.getElementById('modal-tambah').style.display='block'">Tambah Data</a>
              </div>
              <div class="w3-col l4 w3-right">
                <input type="text" id="search-bar" class="w3-input w3-border w3-round" onkeyup="search()" placeholder="Cari ID..">
              </div>
              <div class="w3-margin-bottom">&nbsp; 
              </div>

            <!-- menampilkan data Kasus DB -->
            <table class="w3-table w3-striped w3-white w3-bordered w3-border" id="kasus_db">
            <thead>
              <tr>
                <td><b>No</b></td>
                <td class="w3-center"><b>ID Kelurahan</b></td>
                <td class="w3-center"><b>Jumlah Kasus</b></td>
                <td class="w3-center"><b>Tahun</b></td>
                <td><b>Kelola</b></td>
              </tr>
            </thead>
            <tbody id="tbl_body_kasusdb"></tbody>
            </table>

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
                    <h3>Data Kasus DB</h3>
                  </header>
                  <br>
                  <div class="w3-container">
                    <div class="w3-col">

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">ID Kelurahan</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="idkel-kasusdb" placeholder="ID Kelurahan">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Jumlah Kasus</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="jumlah-kasusdb" placeholder="Jumlah Kasus">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Tahun</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="tahun-kasusdb" placeholder="tahun">
                      </div>
                      <br>
                    </div>

                    <div class="w3-right w3-margin-bottom">
                      <button class="w3-button w3-red w3-round w3-text-white" id="btn-batal-tambah" onclick="document.getElementById('modal-tambah').style.display='none'">Batal</button>
                      <button type="button" class="w3-button w3-green w3-round" id="btn-simpan-tambah" onclick="insertKasusDb()">Simpan</button>
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
                  <header class="w3-container w3-orange"> 
                    <span onclick="document.getElementById('modal-sunting').style.display='none'" 
                    class="w3-button w3-display-topright">&times;</span>
                    <h3 class="w3-text-white">Edit Data Kasus DB</h3>
                  </header>
                  <br>
                  <div class="w3-container">
                    <div class="w3-col">

                    <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">ID Kelurahan</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-id-kel" placeholder="ID Kelurahan">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Jumlah Kasus DB</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-jumlah-kasus" placeholder="Jumlah Kasus">
                      </div>

                      <div class="w3-row w3-margin-bottom">
                        <label class="w3-label w3-col l3">Tahun</label>
                        <input class="w3-col l9 w3-input w3-border w3-round" type="text" id="edit-tahun" placeholder="tahun">
                      </div>
                      <br>
                    </div>

                    <div class="w3-right w3-margin-bottom">
                      <button class="w3-button w3-red w3-round" id="btn-batal-sunting" onclick="document.getElementById('modal-sunting').style.display='none'">Batal</button>
                      <button type="button" class="w3-button w3-orange w3-round w3-text-white" id="btn-update-sunting" onclick="putEditKasusDb()">Update</button>
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
                      <button type="button" class="w3-button w3-grey w3-round w3-text-white w3-padding-small" id="btn-hapus-del" onclick="hapusKasusDb()">OK</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>


            <script>
            //untuk search berdasarkan nama
            function search(){
              let search = document.getElementById("search-bar");
              let filter = search.value.toUpperCase();
              let tabel = document.getElementById("kasus_db");
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

            function showTableKasusDb(){
                  let nomor = 1;
                  let tbl;
                  let xmlhttp = new XMLHttpRequest();

                  xmlhttp.onreadystatechange = function() {
                    if(this.readyState == 4 && this.status == 200) {
                      // console.log(JSON.parse(this.responseText));
                      let data = JSON.parse(this.responseText);
                      let tabelBody = document.getElementById("tbl_body_kasusdb");

                      data.forEach(function(datum){
                        // console.log(datum);
                        let trIdKel = document.createElement("tr");
                        let tdIdKel = document.createElement("td");
                        let tdNomor = document.createElement("td");
                        let tdJumlahKasusDb = document.createElement("td");
                        let tdTahun = document.createElement("td");
                        let tdKelola = document.createElement("td");
                        let btnEdit = document.createElement("button");
                        let btnHapus = document.createElement("button");

                        trIdKel.setAttribute("class", "baris-kasusdb");
                        btnEdit.setAttribute("class", "w3-button w3-orange w3-round-small w3-padding-small w3-text-white");
                        btnEdit.setAttribute("onclick", "updateKasusDb(" + datum.id + ")");
                        btnHapus.setAttribute("class", "w3-button w3-red w3-round-small w3-padding-small");
                        btnHapus.setAttribute("onclick", "tampilMdlHapusKasusDb(" + datum.id + ")");
                        tdIdKel.setAttribute("class", "w3-center");
                        tdJumlahKasusDb.setAttribute("class", "w3-center");
                        tdTahun.setAttribute("class", "w3-center");
                        

                        let nomorTeks = document.createTextNode(nomor);
                        let idkelTeks = document.createTextNode(datum.idKel);
                        let jumlahkasusdbTeks = document.createTextNode(datum.jmlKasus);
                        let tahunTeks = document.createTextNode(datum.tahun);
                        let editTeks = document.createTextNode("edit");
                        let hapusTeks = document.createTextNode("hapus");
                        let spasi = document.createTextNode(" ");

                        // namaParent.appendChild(namaChild)
                        btnEdit.appendChild(editTeks);
                        btnHapus.appendChild(hapusTeks);
                        tdNomor.appendChild(nomorTeks);
                        tdIdKel.appendChild(idkelTeks);     
                        tdJumlahKasusDb.appendChild(jumlahkasusdbTeks);
                        tdTahun.appendChild(tahunTeks);
                        tdKelola.appendChild(btnEdit);
                        tdKelola.appendChild(spasi);
                        tdKelola.appendChild(btnHapus);

                        trIdKel.appendChild(tdNomor);
                        trIdKel.appendChild(tdIdKel);
                        trIdKel.appendChild(tdJumlahKasusDb);
                        trIdKel.appendChild(tdTahun);
                        trIdKel.appendChild(tdKelola);
                        tabelBody.appendChild(trIdKel);

                        // console.log("sensor"+nomor);
                        nomor++;
                      });
                    }
                  };
                  xmlhttp.open("GET", "/api/kasus_db", true);
                  xmlhttp.send();
                }

                
                // function getKasusDb() {
                //   var xhttp = new XMLHttpRequest();
                  
                //   xhttp.onreadystatechange = function() {
                //     if (this.readyState == 4 && this.status == 200) {
                //       fillData(JSON.parse(this.responseText));
                //     }
                //   };

                //   xhttp.open("GET", "/api/kasus_db", true);
                //   xhttp.send();
                // }

                // tambah data kasusdb
                function insertKasusDb(){
                  let idKel = document.getElementById("idkel-kasusdb").value;
                  let jmlKasus = document.getElementById("jumlah-kasusdb").value;
                  let th = document.getElementById("tahun-kasusdb").value;

                  let JSONObject = {
                    "idKel" : idKel,
                    "jmlKasus" : jmlKasus,
                    "tahun" : th,
                    };

                    // console.log(idKel);
                  postKasusDb(JSONObject);
                  // console.log(idkelKasusDb);
                }

                function postKasusDb(data){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                      if(JSON.parse(this.responseText))
                      {
                        document.getElementById("modal-tambah").style.display = "none";
                        resetTabelKasusDb();
                        showTableKasusDb();
                      }
                    }
                  };

                  xhr.open("POST", "/api/kasus_db", true);
                  xhr.setRequestHeader("Content-type","application/json");
                  xhr.send(JSON.stringify(data));
                }

                function resetTabelKasusDb(){
                  let barisKasusDb = document.getElementsByClassName("baris-kasusdb");

                  while(barisKasusDb.length){
                    barisKasusDb[0].parentNode.removeChild(barisKasusDb[0]);
                  }
                }

                // edit & update data sensor
                var idEdit = 0;
                function updateKasusDb(id){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function(){
                    if (this.readyState == 4 && this.status == 200) {
                      idEdit = id;

                      editModalKasusDb(JSON.parse(this.responseText));
                    }
                  };

                  xhr.open("GET", "/api/kasus_db/" + id, true);
                  xhr.send();
                }

                function editModalKasusDb(data){
                    console.log(data)
                    document.getElementById("edit-id-kel").value = data.idKel;
                    document.getElementById("edit-jumlah-kasus").value = data.jmlKasus;
                    document.getElementById("edit-tahun").value = data.tahun;
                    
                    document.getElementById("modal-sunting").style.display = "block";
                }

                // meletakkan data sensor ke db
                function putEditKasusDb(){
                    let editId_Kel = document.getElementById("edit-id-kel").value;
                    let editJumlahKasusDb = document.getElementById("edit-jumlah-kasus").value;
                    let editTahun = document.getElementById("edit-tahun").value;
                    
                  let editJSONObject = {
                    "id" : idEdit,
                    "idKel" : editId_Kel,
                    "jmlKasus" : editJumlahKasusDb,
                    "tahun" : editTahun,
                    };
                    // console.log(editJSONObject);
                  postEditKasusDb(editJSONObject);
                }

                function postEditKasusDb(data){
                  let xhttp = new XMLHttpRequest();
                  
                  xhttp.onreadystatechange = function(){
                    // console.log(this);
                    if (this.readyState == 4 && this.status == 200) {
                      if(JSON.parse(this.responseText))
                      {
                        resetTabelKasusDb();
                        showTableKasusDb();
                        document.getElementById("modal-sunting").style.display = "none";
                      }
                    }
                  };

                  console.log(data);

                  xhttp.open("PUT", "/api/kasus_db", true);
                  xhttp.setRequestHeader("Content-type","application/json");
                  // console.log(data);
                  xhttp.send(JSON.stringify(data));
                }

                //fungsi u/ hapus
                let idToDelete = 0;
                function tampilMdlHapusKasusDb(id){
                  document.getElementById('modal-del').style.display='block';
                  idToDelete = id;
                }

                function hapusKasusDb(){
                  let xhr = new XMLHttpRequest();

                  xhr.onreadystatechange = function(){
                    if (this.readyState == 4 && this.status == 200) {
                      if (JSON.parse(this.responseText))
                      {
                        document.getElementById("modal-del").style.display = "none";
                        resetTabelKasusDb();
                        showTableKasusDb();
                      }
                    }
                  };
                  console.log(idToDelete);
                  xhr.open("DELETE", "/api/kasus_db/" +idToDelete, true);
                  xhr.send();
                }
                showTableKasusDb();
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
              xhttp.open("GET", "/api/sby_desa", true);
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

              data.forEach(function(kelurahan){
                // console.log("Isinya GEOM: "+kecamatan.geom);
                // console.log("Hallo");
                if (kelurahan.geom != null) {
                  var tepi = kelurahan.geom.replace("MULTIPOLYGON(((","").replace(")))","").split(",");
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

                      var kelurahanPoly = new google.maps.Polygon({
                          paths: batas,
                          strokeColor: '#000000',
                          strokeOpacity: 1,
                          strokeWeight: 0.5,
                          fillColor: warna,
                          fillOpacity: 0.6
                      });
                      //console.log(geom.warna);

                      google.maps.event.addListener(kelurahanPoly,'click',function() {
                          //console.log(kecamatan.daerah);
                           infoWindow.setContent('<b>' + kelurahan.daerah + '<br>Jumlah kejadian: ' + kelurahan.kejadian + '</b>');
                           infoWindow.setPosition(batas[0]);
                           infoWindow.open(map);
                      });
                        kelurahanPoly.setMap(map);
                }
              });

              infoWindow = new google.maps.InfoWindow;
            }

            getData();

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
