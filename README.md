# TAREA 1 ARSW (LOC Counting Assignment Kit)

Write a program to Count the Lines of Code of a source file. The Lines Of Code (LOC) of a program are often used as software metric to compare complexity and to measure productivity

# LOC/h. Rendimiento

1. desde las 11:00 am, hasta las 12:30 pm - fueron en total 32 lineas
2. desde las 7:36 pm, hasta las 8:55 pm - fueron en total 102 lineas


LOC = (134L/2.5h)

## 53.6 LOC

# Documentación

la documentacion de este proyecto esta en la siguiente ruta del proyecto:
```
raiz /README.md
```
## EMPEZAR

Copie el proyecto via git clone en cualquier diretorio para empezar a trabajar:
```
git clone https://github.com/vashigo/LOC-Counting-Assignment-Kit_Tarea1-ARSW.git
```

### Prerequisitos

Tener instalado Java jdk versiones 7+, Maven comandos y git

### Instalando

1. Ejecutar en terminal:

```
$$ mvn package
```
2.(opcional):
si requiere la documentacion del codigo ejecute y estara en raiz /target:

```
mvn javadoc:javadoc
```

2. (Demostracion):
   compile el proyecto desde la carpeta raiz ejecutando la siguiente linea dependendiendo del metodo de lectura si es 'loc' o 'phy' y poniendo la ruta del archivo a analizar (recuerde que esto entra como parametro)

```
java -cp ".\target\classes" edu.escuelaing.arsw.app.App loc D:\Escritorio\arsw-i-Lab01\Test\Test1.java

```
![Imágen 1](img/1.png)
Nota: Hay dos archivos en la carpeta Test para que haga sus pruebas

3. En el siguiente diagramas de clases vemos como la clase principal App hace uso de las clases Loc, donde esta lo unico que hace es devolver uno por cada linea que encuentra mientras que la clase Phy devuelve 1 si el codigo no esta comentado o no esta dentro de comentarios de varias lineas:
   ![Imágen 2](img/2.png)

## Built con

* [Maven](https://maven.apache.org/) - Dependency Management
* [JAVA JDK 8](http://www.oracle.com/technetwork/java/javase/overview/index.html) - construcción


## Autor

* **Juan Mateo Mejia Zuluaga** - *Initial work* - [MatiwsxD](https://github.com/MatiwsxD)


## Licencia

This project is licensed under the GNU General Public License - see the [LICENSE](LICENSE) file for details
