<%@ page import="java.util.List" %>
<%@ page import="com.practica.pokerest.mb.PokemonMB" %>
<%@ page import="com.practica.pokerest.bean.Pokemon" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:p="http://primefaces.org/ui">
<head>
    <title>Listar Pokemons</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped table-hover">
    <thead class="table-dark">

    <tr>
        <th scope="col">Pokemon Name</th>
        <th scope="col">View Detail</th>
    </tr>
    </thead>
    <tbody>
    <%
        PokemonMB pokemonMB = new PokemonMB();
        pokemonMB.listar();
        Pokemon[] pokemons = pokemonMB.getPokemons();
        Iterator<Pokemon> iter = Arrays.stream(pokemons).iterator();
        Pokemon pokemon=null;
        while (iter.hasNext()){
            pokemon = iter.next();
    %>
    <tr>
        <th scope="row"><%=pokemon.getName()%></th>
        <td><a href="<%=pokemon.getUrl()%>"><%=pokemon.getUrl()%></a></td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
