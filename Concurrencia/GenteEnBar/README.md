# Enunciado #

Escribir un programa GenteEnBar, que cree un objeto de la clase Bar (lugar de encuentro) con una capacidad para 10 personas y 1000 threads de la clase Persona, identificados por un número entero entre el 1001 y el 2000. 

Un objeto de la clase Persona hace lo siguiente: espera un rato aleatorio entre 0,2 y 0,5 segundo, entra en el bar (si está lleno, se quedará esperando), se toma algo durante otro rato al azar entre 0,5 y 1 seg., sale del bar (dejando sitio para otro) y termina.

En el bar se debe saber en todo momento la identificación de las personas que están dentro. Cada vez que alguien entre o salga del bar, se refrescará la información que aparece en el campo de texto de la ventana de la aplicación. Un par de botones en dicha ventana, deberá permitir detener y reanudar la ejecución de todos los hilos (personas).
