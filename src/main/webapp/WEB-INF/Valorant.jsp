
<%@ page import="java.util.List" %>
<%@ page import="Games.Valorant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Valorant> pros = (List<Valorant>)request.getAttribute("pros");
    String show = "?show=" + (String)request.getAttribute("show");
    String sort = "&sort=" + (String)request.getAttribute("sort");
    String search = (String)request.getAttribute("search");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Valorant Pros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="css/valorant.css" rel="stylesheet">
</head>
<body>
<header class="bg-primary">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand text-light" href="#">Who's that pro?</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

                <form class="d-flex" action="valorant" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" value="<%= search %>">
                    <button class="btn btn-light" type="submit">Search</button>
                </form>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="filterDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Show
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="filterDropdown">
                        <li><a class="dropdown-item" href="valorant">All</a></li>
                        <li><a class="dropdown-item" href="valorant?show=EMEA<%= sort %>">EMEA</a></li>
                        <li><a class="dropdown-item" href="valorant?show=North+America<%= sort %>">North America</a></li>
                    </ul>
                </div>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="sortDropdown">
                        <li><a class="dropdown-item " href="valorant<%= show %>&sort=alphaAZ">Alphabetical (A to Z)</a></li>
                        <li><a class="dropdown-item " href="valorant<%= show %>&sort=alphaZA">Alphabetical (Z to A)</a></li>
                        <li><a class="dropdown-item " href="valorant<%= show %>&sort=regionAZ">Region (A to Z)</a></li>
                        <li><a class="dropdown-item " href="valorant<%= show %>&sort=regionZA">Region (Z to A)</a></li>
                    </ul>

                </div>
            </div>
        </div>
    </nav>

</header>
<div class="container my-4">
    <p class="lead">Showing <%= pros.size() %> Pros </p>
    <div class="row">
        <% for(Valorant pro: pros) { %>
        <div class="col-sm-12 col-md-4 col-lg-4 col-xl-3">
            <div class="card mb-4" style="width: 18rem;">
                <img src="https://assets-prd.ignimgs.com/2021/12/21/valorant-1640045685890.jpg" class="card-img-top" alt="<%= pro.getPlayer() %>" height="300" width="300">
                <div class="card-body">
                    <h5 class="card-title"><%= pro.getPlayer() %></h5>
                    <p class="card-text">Region: <%= pro.getRegion() %>
                        <br>Team: <%= pro.getTeam() %></p>
                    <button type="button" class="btn btn-primary btn-open" data-bs-toggle="modal" data-bs-target="#valorantModal"
                            data-title="<%= pro.getPlayer() %>"
                            data-team="<%= pro.getTeam() %>"
                            data-region="<%= pro.getRegion() %>"
                            >
                        Show more
                    </button>
                </div>
            </div>
        </div>
        <% } %>
    </div>
</div>

<div class=" modal fade" id="valorantModal" tabindex="-1" aria-labelledby="valorantModalLabel" aria-hidden="true">
    <% for(Valorant pro: pros) { %>
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="valorantModalLabel"><%= pro.getPlayer() %></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <img src="https://seeklogo.com/images/V/valorant-logo-FAB2CA0E55-seeklogo.com.png" height="200" width="200">
                <p> Region: <span class="modal-region"> <%= pro.getRegion()%> </span>
                    <br>Team: <span class="modal-team" > <%= pro.getTeam() %>  </span>
                    <br>Kill/Death Ratio: <span class="modal-kd"> <%= pro.getKd() %></span>
                    <br>Average Combat Score: <span class="modal-acs"> <%= pro.getAcs() %></span>
                    <br>Headshot Percentage: <span class="modal-hsp"> <%= pro.getHs() %></span>
                    <br> Kills, Assists, Survived and Traded:<span class="modal-kast"> <%= pro.getKast() %>%</span>
                    <br> Average Combat Score:<span class="modal-acs"> <%= pro.getAcs() %></span>
                    <br> opening Duel Win Rate:<span class="modal-od"> <%= pro.getOpeningDuelWinRate() %></span>
                    <br> Clutch Win Rate:<span class="modal-cw"> <%= pro.getClutches() %></span>

                </p>
            </div>
        </div>
    </div>
    <% } %>
</div>


<script src="https://code.jquery.com/jquery-3.6.4.slim.min.js"
        integrity="sha256-a2yjHM4jnF9f54xUQakjZGaqYs/V1CYvWpoqZzC2/Bw="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script src="scripts/valorant.js"></script>
</body>
</html>