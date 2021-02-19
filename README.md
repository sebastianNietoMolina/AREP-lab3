## _Despliegue en Heroku_ 
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://aqueous-plains-80854.herokuapp.com/)

 ## _Integración continua_ 
[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/sebastianNietoMolina/AREP-lab3)

## _Calidad del código_ 
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/1c87e9036fa24241bac6f42d854ffa2b)](https://www.codacy.com/gh/sebastianNietoMolina/AREP-lab3/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=sebastianNietoMolina/AREP-lab3&amp;utm_campaign=Badge_Grade)

# TALLER CLIENTES Y SERVICIOS

Este proyecto busca implementar un framwork parecido a Spark, al igual que Spark debe leer la petición get con parámetros una función lambda. Su alcance es explorar la arquitectura de sistemas distribuidos en la red, tiene como objetivo construir un modelo cliente servidor para hacer peticiones http, se debe poder desplegar en heroku, y adicional debe estar conectado a una base de datos y, se debe poder hacer peticiones ahí también, tambien puede consulta mas sobre su implementacion en el pdf.

NOTA: Esta hecha toda la implementación propuesta menos la de la base de datos. 

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

Para poder hacer uso de este proyecto se debe tener instalado:
 
  * MVN
  * Git
  * Java 11
  * HerokuCli (En caso de querer desplegar el proyecto localmente)

### Instalación 🔧

Lo primero que debe hacer es descargar el proyecto, lo pude hacer directamente descargando el .zip, o puede clonar el archivo con el siguiente comando.

```
git clone https://github.com/sebastianNietoMolina/AREP-lab3.git
```

Entramos al directorio del proyecto con el comando

```
cd AREP-lab3
```

Luego debe ingresar el siguiente comando para que se ejectue hasta la fase de empaquetamiento, debe asegurar que antes de ingresar este comando, que exista en la carpeta que esta un archivo llamado pom.xml

```
mvn clean install package
```

Tambien me gustaria aclarar que puedes descargar el javaDoc, este quedara guardado en una carpeta target, esta se genera una vez echo el comando anterior, y con el siguiente comando se creara la carpeta site, la ruta sera target/site.

```
mvn javadoc:javadoc
```

Si desea correr heroku localmente, hay un archivo que se llama Procfile, si su sistema operativo es Linux, use el siguiente comando.

```
web: java $JAVA_OPTS -cp target/classes edu.escuelaing.arep.app.myspark.App
```

Si falla agrega lo siguiente

```
web: java $JAVA_OPTS -cp "target/classes" edu.escuelaing.arep.app.myspark.App
```
Si usa windows use el siguiente.

```
web: java -cp target/classes edu.escuelaing.arep.app.myspark.App
```

Recuerde que para ver heroku localmente debe ingresar el siguiente comando en cmd 

```
heroku local web
```
Posteriormente debe escribir el siguiente link en su buscador: localhost:5000

Si por el contrario solo ejecuto el programa desde el main, o por comando, debe escribir el siguiente link en su buscador: localhost:36000

## Ejercicio 1

## Ejecutando las pruebas ⚙️

El anterior comando mvn package ya ejecuta las pruebas, pero si desea verlas por aparte puede ejecutar el siguiente comando.

```
mvn test.
```

### Analice las pruebas end-to-end 🔩

Se puede evidenciar cuando pasan las pruebas, no se deben ejecutar varias al mismo tiempo, puede ocasionar que no pase, pero de forma secuencial lo lograra.

![]()

## Autores ✒️

_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Sebastian Nieto** - [sebastianNieto](https://github.com/sebastianNietoMolina)

## Licencia 📄

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE.md](LICENSE.md) para detalles

## Expresiones de Gratitud 🎁

Reconocimientos a: [Villanuevand](https://github.com/Villanuevand), use su plantilla de README.md.
