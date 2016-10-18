# Enunciado #

Un problema clásico de la programación concurrente es el de los procesos (threads) lectores y escritores.
Todos ellos acceden concurrentemente a un libro (metáfora de variable compartida), pero mientras que varios lectores pueden estar leyéndolo al mismo tiempo, cuando un escritor desea escribir en el libro, debe garantizársele que ningún otro proceso (thread) tenga acceso al libro. Para evitar un posible caso de inanición (starvation) debido a que los lectores acaparen el acceso al libro, cada vez que un escritor pretenda empezar a escribir, ningún otro proceso (lector o escritor) pueda acceder al libro. Si hay lectores usándolo, el escritor esperará a que termine el último de ellos antes de comenzar a escribir.
 
Se pide escribir un programa que simule un sistema compuesto por 15 lectores y 10 escritores que acceden concurrentemente a un libro compartido, que garantice su acceso, en la forma descrita, mediante:

1. El uso de monitores (acceso a variables compartidas en exclusión mutua, con regiones críticas condicionales).
2. Utilizando semáforos (java.util.concurrent.semaphore).
3. Haciendo uso de los locks de lectura/escritura (java.util.concurrent.ReadWriteLock).
 
El comportamiento de los threads debe ser el siguiente:

* El libro es un String inicialmente vacío (“”).

* Los escritores estarán identificados por un dígito del 0 al 9. Cada vez escritor escribe en el libro, añade al final del string un carácter igual a su número de identificación (“0”,”1”,..”9”).

* Los escritores realizan el siguiente ciclo: piensan durante un tiempo aleatorio entre 1 y 2 segundos y se van a escribir en el libro. Este ciclo lo repiten 5 veces.

* Los lectores estarán identificados por un número de dos cifras del 20 al 34.

* Su ciclo es el siguiente: pasean durante un tiempo al azar entre 1 y 2 segundos,  se van a leer el libro y se están entre 0,5 y 1,5 segundos leyendo. Luego vuelven a empezar, salvo que el libro esté terminado (tenga ya 50 caracteres), en cuyo caso, terminarán, imprimiendo por pantalla un mensaje del tipo:
 * * Leído por 26: 0416895326710139584824737605132968519026734850279”.
 
Escribir las clases necesarias para crear el programa, de forma que durante su ejecución se pueda ver por pantalla qué lectores están leyendo el libro en cada momento, qué escritor está escribiendo y cuál es el contenido del libro. Se puede hacer mediante un JFrame con 3 campos de texto para la visualización de dichos datos. (Añadir dos botones para detener y reanudar los threads lectores y escritores, y así comprobar que el sistema funciona correctamente).
