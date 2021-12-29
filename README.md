                                                 #-- Tierra Media --#
Proyecto de finalizacion de cursada - "Tierra Media"

Proyecto de finalizacion de cursada que consiste en una aplicación web que ofrece atracciones y pack de atracciones a turistas en base a su gusto, dinero y tiempo disponible. Ademas cuenta con la funcionalidad de "administrador" para poder hacer el CRUD de las atracciones y los turistas que se inscriben para visitar las atracciones.

Pasos para clonar archivo:

1-Abrir la consola de Git Bash en el workspace de Eclipse.

2-Introducir el siguiente comando: git clone https://github.com/diegoo-villalba/tierraMedia.git

3-Desde eclipse importar el proyecto, para ello nos posicionamos sobre la pestaña "Workspace", click derecho, "Import" y alli buscamos la raiz donde clonamos el proyecto, le damos importar y listo.

Pasos para levantar la aplicacion web:

Se debe de instalar el contenedor de servlets "Apache Tomcat" el cual nos va a permitir compilar y ejecutar la aplicacion web, para ello hacemos los siguientes pasos:

1-Nos dirigimos a la pestaña "Servers", hacemos click sobre "Click this link to create a new server..."

2-Se nos abrira una ventana y elegiremos el servidor de tipo "Apache", especificamente la ultima version al dia de la fecha "Tomcat v10.0 Server"

3-Apretamos en "Next" y nos va a aparecer una ventana para especificar el directorio de instalacion del server, alli haremos click en la opcion "Download and Install", se nos abrira otra ventana con la licencia del servidor y le daremos "I accept the terms..."., se nos abrira una ventana para elegir la carpeta donde instalaremos el servidor (recomendamos hacerlo en la misma carpeta donde se encuentra su workspace), le daremos al boton de "Open" y comenzara la instalacion del servidor (se puede chequear en la esquina inferior derecha del IDE Eclipse el progreso de la instalacion).

4-Una vez finalizada la instalacion, haremos click en "Next" y nos llevara a la ventana "Add and Remove", alli nos mostrara los recursos disponibles para montar en el servidor por lo que trasladaremos de izquierda a derecha "tierraMdia(TierraMedia)" haciendo click sobre "Add>".

5-Por ultimo, hacemos click en "Finish" y nos dirigimos a la pestaña "Package Explorer", especificamente nos posicionamos sobre el proyecto "tierraMedia" y hacemos click derecho, se nos abrira un desplegable y haremos click sobre la opcion "Run as", seguido a esto haremos click sobre "Run on server", se nos abrira una nueva ventana llamada tambien "Run On Server" y alli seleccionaremos el boton "Finish".

6- Por ultimo se nos abrira una pestaña con la pagina principal del proyecto "Tierra Media" donde podremos loguearnos.
(NOTA IMPORTANTE: Para que funcione correctamente la aplicacion web deben editar el archivo `/turismo/src/main/resources/env.properties` y colocar la ruta correcta del archivo de la base de datos "tierra_media3.db". Para ver las FUNCIONALIDADES COMPLETAS del proyecto aconsejamos loguearse con Usuario: rober y Contraseña: rober1234)

7-LISTO, ya pueden navegar por la aplicacion web a su gusto. Bienvenidos y que la disfruten!!


-Usuario:

sam

gandalf

eowyn

galadriel

rober

-Password:

sam1234

gandalf1234

eowyn1234

galadriel1234

rober1234




Proyecto de fin de cursada "Argentina Programa 2021" realizado por: Casarré Clara, Calamullo Diego, Halbrandt Ivan, Kerkaert Nahuel y Villalba Diego.
