
<%@ page import="java.util.List" %>
<%@ page import="Games.Valorant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Valorant> pros = (List<Valorant>)request.getAttribute("pros");
    String show = "?show=" + (String)request.getAttribute("show");
    String search = (String)request.getAttribute("search");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>North American Pros</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
            </div>
        </div>
    </nav>

</header>
<div class="container my-4">
    <p class="lead">Showing <%= pros.size() %> Pros </p>
    <div class="row">
        <% for(Valorant pro: pros) { %>
        <div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
            <div class="card mb-4" style="width: 18rem;">
                <img src="https://valorant-esports.fandom.com/wiki/Category:Player_Images?file=<%=pro.getPlayer()%>_2020.png" class="card-img-top" alt="player <%= pro.getPlayer() %>" height="200">
                <div class="card-body">
                    <h5 class="card-title"><%= pro.getPlayer() %></h5>
                    <p class="card-text">Region: <%= pro.getRegion() %>
                        <br>Team: <%= pro.getTeam() %></p>
                    <button type="button" class="btn btn-primary btn-open" data-bs-toggle="modal" data-bs-target="#valorantModal"
                            data-title="<%= pro.getPlayer() %>"
                            data-population="<%= pro.getTeam() %>"
                            data-region="<%= pro.getRegion() %>">
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
                <p>
                    Region: <span class="modal-region"> <%= pro.getRegion()%> </span>
                    <br>Team: <span class="modal-team" > <%= pro.getTeam() %> <img src="https://seeklogo.com/images/V/valorant-logo-FAB2CA0E55-seeklogo.com.png" height="200" width="200"></span>
                    <br>Kill/Death Ratio: <span class="modal-kd"> <%= pro.getKd() %></span>
                    <br>Average Combat Score: <span class="modal-acs"> <%= pro.getAcs() %></span>
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
<script src="../scripts/valorant.js"></script>
</body>
</html>