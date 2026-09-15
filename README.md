# Sistema de Vacunación Veterinaria

Una aplicación de consola interactiva orientada a objetos que simula el proceso de evaluación y vacunación de mascotas (perros y gatos) en una clínica veterinaria. El sistema valida si una mascota cumple con los requisitos de edad, peso y dosis previas antes de administrar una nueva vacuna.

## Construido con (Built with)

* Java 17
* Maven
* JUnit Jupiter (JUnit 5) para pruebas unitarias
* **Entorno de desarrollo:** IntelliJ IDEA

## Comenzando (Getting started)

### Requisitos previos (Prerequisites)

Para ejecutar este proyecto desde la consola, necesitarás tener instalados:
* Java 17 o superior
* Maven 3.8+
* (Opcional: Un IDE compatible con Maven, como IntelliJ IDEA o Eclipse)

## Obteniendo el proyecto (Getting the Project)

Clona este repositorio en tu máquina local ejecutando el siguiente comando:

```bash
git clone [https://github.com/asantana4/visita-veterinario.git](https://github.com/asantana4/visita-veterinario.git)
cd visita-veterinario
```

Alternativamente, puedes descargar el repositorio como un archivo ZIP desde GitHub y extraerlo.

## Ejecutando el proyecto (Running the project)
Puedes compilar, ejecutar las pruebas y correr el programa directamente desde la línea de comandos de tu terminal usando Maven.

### Ejecutar las pruebas (Run tests)
Para correr las pruebas unitarias del sistema, ejecuta:

```Bash
mvn test
```

Esto compilará el proyecto y ejecutará todas las pruebas ubicadas en el directorio src/test/java.

### Ejecutar el programa (Run the program)
El proyecto está configurado con el plugin de ejecución de Maven. Para limpiar, compilar e iniciar el sistema en un solo paso, ejecuta el siguiente comando en la raíz del proyecto:

```Bash
mvn clean compile exec:java
```

Una vez iniciado, el programa limpiará la consola y te guiará paso a paso para ingresar los datos de la mascota y decidir si aplicar la vacuna.
