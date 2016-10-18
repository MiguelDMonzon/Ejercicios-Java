# Enunciado #
Se pide que se haga un analizador léxico para un tipo de archivos con extensión .upd (archivos de texto) con un cojunto de reglas léxicas determinadas. Esos archivos de texto pueden contener letras, dígitos, saltos de línea, tabuladores, espacios, caracteres como comillas simples, dobles… 

Mientras se analiza el archivo, se debe ir almacenando información sobre los lexemas que se consideren correctos en una clase llamada UpdClass, y al final mostrar en pantalla toda la información recogida, mientras que para los que se consideran erróneos se debe indicar el texto incorrecto y la línea en la que se encuentra.

El archivo .upd tiene que ser pasado por parámetro al analizador, así que si el archivo que se quiere analizar no tiene esa extensión, hay que indicarlo. Hay que poder recuperarse de posibles errores y tratar las excepciones que se den.

Puesto que hay algunas partes que son ambiguas, se ha decidido que:

1. Se dice que un identificador está formado por una letra seguida de un conjunto de caracteres. Ese conjunto se supone que pueden ser o letras o números.

2. Para los nombres de registros es algo similar. Se pide que esté formado por una longitud máxima de dos caracteres. Como en una computadora los principales registros son AX, BX, CX, SP, SI… es decir, letras, se va a suponer que se piden dos letras como máximo, sin números.

Se entiende “apertura” como expresión regular que da inicio a un tipo de lexema, por ejemplo para un identificador, su apertura será < ident >, o para una fecha será < date >.
A su vez, se entenderán como “cierres” al análogo de las aperturas pero para cerrar. En los ejemplos, sería < /ident > y < /date >. 

## Expresiones regulares ##
Para poder analizar los lexemas que se piden hay que crear unas expresiones regulares correctas para cada tipo que se pide:

### Identificadores ###

* < ident >: apertura de identificador

* < /ident >: cierre de identificado

* [a-zA-Z][a-zA-Z0-9]*: Es un identificador. Empieza por una letra y es seguida tanto de letras como números de 0 a N veces. Es decir, el carácter ‘a’ (sin comillas) se detectaría como identificador.

Cuando se detecta el identificador, se inserta en una variable y se envía a la clase UpdClass con el método setIdent();
No pueden incluir no saltos de línea ni tabuladores ni espacios entre medias. Así que si el analizador léxico, si se le inserta ‘ab cd’ (sin comillas), no lo detectaría entero como identificador porque hay un espacio entre medias. Lo que ocurre es que detecta dos identificadores diferentes: ab y cd.

### Fechas ###

* < date >: inicio de fecha

* < /date >: cierre de fecha

* ([0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]): Las fechas tienen el formato habitual de Día/Mes/Año (dd/mm/aaaa). No se necesita validar la fecha. 

Muy simple, hay que poner los dígitos en la secuencia exigida, sin necesidad de validación. La barra (/) no se considera metacaracter así que se puede poner directamente.
Tras detectar la fecha, la recoge en una variable y la escribe en la clase UpdClass con el método clase.setDate();

### Nombres de registros ###

* < name >: inicio de name
* < /name >: inicio de name
* '[a-zA-Z0-9][a-zA-Z0-9]?': Deben de tener una longitud máxima de dos caracteres, y estar delimitados por comillas simples.
Puesto que las comillas simples (‘) no son metacaracteres, no es necesario de acompañarlos con comillas dobles (“) o la barra invertida (\). Esta expresión abarca todos los lexemas que empiecen por una letra o un número y estén seguidos de otra letra o número, pero únicamente tienen que ser dos caracteres como máximo, siendo el segundo de ellos opcional.

Se guarda el nombre sin comillas simples por la función substring (explicado más abajo) y la intenta insertar en la HashTable. Si no se puede insertar porque ya existe, implica que está duplicado, luego el método de putReg() devolverá false y no se incrementará el número de registros. En caso contrario, se incrementa.

### Uso de los registros ###
 
* < use >: apertura de uso de registro
* < /use >: cierre de uso de registro
* \"(AllPurpose)\"|\"(Accumulator)\"|\"(ProgramPC)\"|\"(Index)\"|\"(FlagVector)\"|
\"(StackPointer)\": Están formados por cualquiera de las siguientes palabras reservadas: AllPurpose, Accumulator, ProgramPC, Index, FlagVector o StackPointer, delimitadas por comillas dobles.

Las comillas dobles sí que son metacaracteres, así que a su izquierda debe de encontrarse una barra invertida (\).
Significa que lo detecta si el texto escrito es “AllPurpose” o “Accumulator” o “ProgramPC”… Por eso están separados por un OR lógico.

Puesto que llevan comillas dobles, y la práctica especifica que no se deben insertar con esas comillas, para obtener el texto sin éstas se va llamar a la función substring(a, b), donde a es la posición dentro de la cadena por la que queremos empezar y b es por la que queremos terminar. Como queremos quitar un carácter al principio y otro al final, se hará: <code>
substring(1, yytext().length-1)</code>.

Una vez obtenido el nombre del uso del registro, se compara con todos los posibles usos y cuando se encuentre el adecuado se incrementará en 1 ese registro referenciado por la clase updClass.

### Número de bits 

* < bitSize >: apertura de tamaño de bits
* < /bitSize >: cierre de tamaño de bits
* [0-9]+: Está representado por cualquier secuencia de dígitos decimales, así que la expresión regular será muy sencilla. Se recuerda que los dígitos decimales abarcan desde el 0 al 9.
 
Llama al método addBits() después de haber hecho un cast (parser) a entero del texto reconocido (que lo coge como un String). Pueden aparecer dos explicaciones, que se detallarán al final.

### Máscara de bits ###
 
* < insBitCode >: apertura de máscara de bits
* < /insBitCode >: cierre de máscara de bits
* [0|1]+([x]+|[x]+[y]+|[x]+[y]+[z]+)?: Esta máscara se forma como cualquier combinación de secuencias de 0 y 1 (parte fija), seguida de otra opcional de ‟x‟, de “y‟ y/o de “z‟ (donde las y’s solo aparecen después de la x’s y las z’s después de las y’s). Significa: tenemos una secuencia de 0’s o 1’s, una o más veces, seguido de otra secuencia opcional (por el ?). ¿Cómo funciona esa secuencia de x, y, z?

* [x]+ : Pasará por aquí si hay solo x’s, y no hay ni y’s ni z’s. Puesto que está contenido en el paréntesis opcional ()?, en vez de poner [x]* se pone [x]+ porque si no contiene ninguna x, el opcional saltará. 
* * Ejemplo: 10101010x;  01010101xxxx

* [x]+[y]+ : Pasará por aquí cuando haya una sucesión de x’s acompañada de una o más y’s, y ninguna z

* * Ejemplo: 101010101xy; 0101010101xxxxyyyy

* [x]+[y]+[z]+: Este representa a cualquier cadena formada por x’s, y’s y z’s.
* * Ejemplo: 1010101xyz;  010101010xxxyyyzzzz

### Comentarios ###

Los comentarios están en un estado llamado COMMENT. Este estado es muy importante ya que tiene que separarse conceptualmente del estado inicial.

Nos piden que una vez se reciba una apertura < comment >, todo lo que venga después se obvie excepto si es el cierre < /comment >. Para ello, se coloca a < comment > como palabra reservada dentro del estado inicial, y cuando se detecte, llame al estado de comentario mediante la función yybegin(COMMENT).

En el estado comentario se encontrará:

* < /comment >: cierre de comentario. Cuando lo detecte, volverá al estado inicial

* . (punto) : significa que detecta todo lo demás. Cuando entre, no hará nada (lo obvia).
