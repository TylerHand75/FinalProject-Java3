<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %><%
    Map<String, String> results = (Map<String, String>)request.getAttribute("results");
    if(results == null) {
        results = new HashMap<>();
    }
    String region = results.containsKey("region") ? results.get("region") : "";
    String team = results.containsKey("team") ? results.get("team") : "";
    String player = results.containsKey("player") ? results.get("player") : "";
    String acs = results.containsKey("acs") ? results.get("acs") : "";
    String kd = results.containsKey("kd") ? results.get("kd") : "";
    String kast = results.containsKey("kast") ? results.get("kast") : "";
    String hs = results.containsKey("hs") ? results.get("hs") : "";
    String clutches = results.containsKey("clutches") ? results.get("clutches") : "";
    String k = results.containsKey("k") ? results.get("k") : "";
    String d = results.containsKey("d") ? results.get("d") : "";
    String a = results.containsKey("a") ? results.get("a") : "";
    String openingDuelWinRate = results.containsKey("openingDuelWinRate") ? results.get("openingDuelWinRate") : "";

    String regionError = results.containsKey("regionError") ? results.get("regionError") : "";
    String teamError = results.containsKey("teamError") ? results.get("teamError") : "";
    String playerError = results.containsKey("playerError") ? results.get("playerError") : "";
    String acsError = results.containsKey("acsError") ? results.get("acsError") : "";
    String kdError = results.containsKey("kdError") ? results.get("kdError") : "";
    String kastError = results.containsKey("kastError") ? results.get("kastError") : "";
    String hsError = results.containsKey("hsError") ? results.get("hsError") : "";
    String clutchesError = results.containsKey("clutchesError") ? results.get("clutchesError") : "";
    String kError = results.containsKey("kError") ? results.get("kError") : "";
    String dError = results.containsKey("dError") ? results.get("dError") : "";
    String aError = results.containsKey("aError") ? results.get("aError") : "";
    String openingDuelWinRateError = results.containsKey("openingDuelWinRateError") ? results.get("openingDuelWinRateError") : "";

    String regionInvalid = results.containsKey("regionInvalid") ? results.get("regionInvalid") : "";
    String teamInvalid = results.containsKey("teamInvalid") ? results.get("teamInvalid") : "";
    String playerInvalid = results.containsKey("playerInvalid") ? results.get("playerInvalid") : "";
    String acsInvalid = results.containsKey("acsInvalid") ? results.get("acsInvalid") : "";
    String kdInvalid = results.containsKey("kdInvalid") ? results.get("kdInvalid") : "";
    String kastInvalid = results.containsKey("kastInvalid") ? results.get("kastInvalid") : "";
    String hsInvalid = results.containsKey("hsInvalid") ? results.get("hsInvalid") : "";
    String clutchesInvalid = results.containsKey("clutchesInvalid") ? results.get("clutchesInvalid") : "";
    String kInvalid = results.containsKey("kInvalid") ? results.get("kInvalid") : "";
    String dInvalid = results.containsKey("dInvalid") ? results.get("dInvalid") : "";
    String aInvalid = results.containsKey("aInvalid") ? results.get("aInvalid") : "";
    String openingDuelWinRateInvalid = results.containsKey("openingDuelWinRateInvalid") ? results.get("openingDuelWinRateInvalid") : "";



%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Player</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Add Player</h1>
    <form method="post" action="add-player">
        <div class="form-group">
            <label for="region">Region:</label>
            <input type="text" class="form-control <%= regionInvalid %>" id="region" name="region" value="<%= region %>" required>
            <span class="invalid-feedback"><%= regionError %></span>
        </div>
        <div class="form-group">
            <label for="team">Team:</label>
            <input type="text" class="form-control <%= teamInvalid %>" id="team" name="team" value="<%= team %>" required>
            <span class="invalid-feedback"><%= teamError %></span>
        </div>
        <div class="form-group">
            <label for="player">Player:</label>
            <input type="text" class="form-control <%= playerInvalid %>" id="player" name="player" value="<%= player %>" required>
            <span class="invalid-feedback"><%= playerError %></span>
        </div>
        <div class="form-group">
            <label for="acs">Average Combat Score:</label>
            <input type="text" class="form-control <%= acsInvalid %>" id="acs" name="acs" value="<%= acs %>" required>
            <span class="invalid-feedback"><%= acsError %></span>
        </div>
        <div class="form-group">
            <label for="kd">Kill/Death Ratio:</label>
            <input type="text" class="form-control <%= kdInvalid %>" id="kd" name="kd" value="<%=kd %>" required>
            <span class="invalid-feedback"><%= kdError %></span>
        </div>
        <div class="form-group">
            <label for="kast">Kill/Death/Assist/Trade Ratio:</label>
            <input type="text" class="form-control <%= kastInvalid %>" id="kast" name="kast" value="<%= kast %>" required>
            <span class="invalid-feedback"><%= kastError %></span>
        </div>
        <div class="form-group">
            <label for="hs">Headshot %:</label>
            <input type="text" class="form-control <%= hsInvalid %>" id="hs" name="hs" value="<%= hs %>" required>
            <span class="invalid-feedback"><%= hsError %></span>
        </div>
        <div class="form-group">
            <label for="clutches">Clutches:</label>
            <input type="text" class="form-control <%= clutchesInvalid %>" id="clutches" name="clutches" value="<%= clutches %>" required>
            <span class="invalid-feedback"><%= clutchesError %></span>
        </div>
        <div class="form-group">
            <label for="k">Kills:</label>
            <input type="text" class="form-control <%= kInvalid %>" id="k" name="k" value="<%= k %>" required>
            <span class="invalid-feedback"><%= kError %></span>
        </div>
        <div class="form-group">
            <label for="d">Deaths:</label>
            <input type="text" class="form-control <%= dInvalid %>" id="d" name="d" value="<%= d %>" required>
            <span class="invalid-feedback"><%= dError %></span>
        </div>
        <div class="form-group">
            <label for="a">Assists:</label>
            <input type="text" class="form-control <%= aInvalid %>" id="a" name="a" value="<%= a %>" required>
            <span class="invalid-feedback"><%= aError %></span>
        </div>
        <div class="form-group">
            <label for="openingDuelWinRate">Opening Duel Win Rate:</label>
            <input type="text" class="form-control <%= openingDuelWinRateInvalid %>" id="openingDuelWinRate" name="openingDuelWinRate" value="<%= openingDuelWinRate %> " required>
            <span class="invalid-feedback"><%= openingDuelWinRateError %></span>
        </div>

        <button class="w-100 btn btn-primary btn-lg" type="submit">Create new player</button>
    </form>
</div>
</div>
</body>
</html>
