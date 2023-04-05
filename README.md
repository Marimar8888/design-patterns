# Design Patterns examples

## Introduction

This is a collection of samples of design patterns for training purposes.

## Code examples

- Pets. Implements the Singleton pattern.


### Solution

- He utilizado el patrón de diseño singleton.
- He creado una interface LoggerController en la carpeta pets
- He creado una clase Logger dentro de la carpeta infraestructure y le he implementado la    	interface LoggerController.

# Interface LoggerController

Define el método debug que posteriormente tiene que implementar la clase Logger.

# Class Logger

Tiene un campo global static (counter), que hace de contador para toda la aplicación y va incrementando un número cada línea que aparece en la consola.

Tiene un método debug, que recibe el mensaje que tiene que imprimir. Imprime en consola el mensaje recibido y además incrementa en 1 el atributo contador.

# controllers/CatController

Añado un campo private static de tipo Logger, para recibir los datos de la clase Logger y un atributo de tipo int (counter).

Modifico el constructor para recibir el objeto de tipo Logger y lo guardo en el atributo de tipo Logger.

En cada método guardo el valor de counter para actualizarlo y llamo al método debug para que imprima por consola el mensaje que le paso.

# controllers/DogController

Añado un campo private static de tipo Logger, para recibir los datos de la clase Logger y un atributo de tipo int (counter).

Modifico el constructor para recibir el objeto de tipo Logger y lo guardo en el atributo de tipo Logger.

En cada método guardo el valor de counter para actualizarlo y llamo al método debug para que imprima por consola el mensaje que le paso.

# controllers/ControllerFactory

Añado un campo private static de tipo Logger, para recibir los datos de la clase Logger.

Al modificar el constructor de las clases CatController y DogController, tengo que incluir el objeto recibido en el return que devuelve cada método, ya que devuelve el constructor de las clases DogController y CatController.


# infraestructure/bd/DbService

Añado un campo private static de tipo Logger, para recibir los datos de la clase Logger y un atributo de tipo int (counter).

Modifico el constructor para recibir el objeto de tipo Logger y lo guardo en el atributo de tipo Logger.

En cada método guardo el valor de counter para actualizarlo y llamo al método debug para que imprima por consola el mensaje que le paso.

# PetApp

Añado un campo private static de tipo Logger, para recibir los datos de la clase Logger y un atributo de tipo int (counter).

Modifico el constructor para recibir el objeto de tipo Logger y lo guardo en el atributo de tipo Logger.

En cada método guardo el valor de counter para actualizarlo y llamo al método debug para que imprima por consola el mensaje que le paso.


