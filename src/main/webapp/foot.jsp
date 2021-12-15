<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <style>
        ul.menu {
            display: inline-block;

            margin-left: 10px;
            margin-right: 10px;
            list-style-type: none;
            white-space: nowrap;
            border: rgb(100, 100, 00) solid 0px;
            border-radius: 5px;
            padding: 5px 5px;
            background: transparent;
        }

        ul.menu ul {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            background: transparent;
            border: rgb(100, 100, 00) solid 0px;
            margin: 0px;
            padding: 0;
            border-radius: 2px;
            list-style-type: none;
        }

        ul.menu ul li {
            display: block;
            border: none;
            border-top: #333 solid 1px;
        }

        ul.menu ul li:first-child {
            border: none;
        }

        ul.menu li {
            position: relative;
            display: inline-block;
            zoom: 1;
            border-left: #333 solid 1px;
        }

        ul.menu li:first-child {
            border: none;
        }

        ul.menu li a {
            display: block;
            padding: 5px 10px;
            text-decoration: none;
            color: orange;
            text-decoration-style: solid;
        }

        ul.menu li a:hover {

            border: rgb(110, 110, 11) solid 1px;
             background: black;

        }

        ul.menu li:hover ul {
            display: block;
            zoom: 1;
            
        }

        ul.menu ul li:hover ul {
            display: inline-block;
            position: absolute;
            top: 0;
            left: 100%;
            background: black;
        }
    </style>
</head>

<body>
  <table align="center">
  <tr width= 100%>
  <td align="center">
    <ul class="menu">
      <li>
        <a class="menu" href="">Inicio</a>
      </li>
        <li>
            <a class="menu" href="">Atracciones</a>
            <ul>
                <li>
                    <a class="item" href="">Aventura</a>
                </li>
                <li>
                    <a class="item" href="#">Degustacion</a>
                </li>
                <li>
                    <a class="item" href="#">Paisajes</a>
                </li>
                
            </ul>
        </li>
        <li>
            <a class="item" href="#">Itinerario</a>
            <ul>
                <li>
                    <a class="item" href="#">Informacion</a>
                </li>
                <li>
                    <a class="item" href="#">Calendario</a>
                </li>
                <li>
                    <a class="item" href="#">Normas y sugerencias</a>
                </li>
            </ul>
        </li>
        <li>
            <a class="item" href="#">Promociones</a>
            <ul>
                <li><a class="item" href="#">Familiar</a>
                </li>
                <li>
                    <a class="item" href="#">Amigos</a>
                </li>
                <li>
                    <a class="item" href="#">Descuentos</a>
                </li>
            </ul>
        </li>
        <li>
            <a class="item" href="#">Contacto</a>
            <ul>
                <li><a class="item" href="#">Como llegar</a>
                </li>
                <li>
                    <a class="item" href="#">Redes sociales</a>
                </li>
                <li>
                    <a class="item" href="#">Quienes somos</a>
                </li>
            </ul>
        </li>
    </ul>
    </td>
    </tr>
    </table>
</body>

</html>