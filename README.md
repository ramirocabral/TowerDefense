# Juego de Tower Defense

¡Bienvenido al juego de Tower Defense, donde el pensamiento estratégico y las decisiones rápidas son cruciales! Este juego está diseñado para 2 jugadores, <span style="color:red">Rojo</span> y <span style="color:blue">Azul</span>️, cada uno defendiendo su torre correspondiente. Prepárate para una batalla épica mientras despliegas una variedad de monstruos para proteger tu torre y lanzar ataques a la fortaleza del oponente.

## Descripción del Juego

- **Jugadores:** <span style="color:red">Rojo</span> y <span style="color:blue">Azul</span>.
- **Objetivo:** Defender tu torre mientras atacas la torre del enemigo.
- **Carriles:** Dos carriles: Oeste y Este.
- **Vidas:** Cada jugador comienza con 3 vidas.
- **Monstruos:** Los jugadores tienen una lista de monstruos para desplegar estratégicamente.

### Detalles del Juego

- **Basado en Rondas:** El juego avanza por rondas, cada una con una duración de 1.5 segundos 🕒.
- **Despliegue de Monstruos:** Los jugadores despliegan monstruos durante las rondas para ejecutar ataques.
- **Movimiento:** Los monstruos se mueven por los carriles, atacando o ingresando al castillo enemigo.
- **Variabilidad:** El orden de las rondas puede variar, afectando el resultado. Un jugador puede atacar dos veces consecutivamente.
- **Reglas del Carril:** Solo se permite un monstruo por jugador por carril.
- **Distancia del Castillo:** Cada carril tiene 3 celdas que separan los castillos.

### Mecánicas de Combate

- **Secuencias de Ataque:** Los monstruos atacan en secuencia, con resultados potencialmente diferentes.
- **Reducción de Vida:** Cuando un monstruo llega al castillo enemigo, el jugador opuesto pierde una vida ❤️.
- **Derrota del Jugador:** Un jugador pierde cuando su recuento de vidas llega a cero.
- **Confrontación de Monstruos:** Los monstruos de jugadores opuestos se enfrentan cuando comparten una celda. El combate se resuelve a través de ataques recíprocos.
- **Puntos de Salud:** Los monstruos tienen puntos de salud que disminuyen con cada ataque. Un monstruo es eliminado cuando su salud llega a cero.

___

## Historia del juego

Bienvenido a una experiencia única que fusiona la esencia de los tiempos actuales con un contexto 
antiguo, donde castillos y estandartes se entrelazan con la presencia de monstruos de eras 
pasadas. Este juego transporta a los jugadores a un mundo fascinante donde lo antiguo se 
mezcla con lo moderno, creando un escenario inmersivo lleno de misterio y maravilla.

### Roles

En el universo de nuestro juego, los roles desempeñan un papel crucial en la estrategia y la 
dinámica del juego. Describimos los roles a continuación:

* **<span style="color:grey">Sword</span>**: El rol de la Espada representa la 
esencia de la fuerza bruta y la habilidad con armas cuerpo a cuerpo. Los 
portadores de la Espada son expertos en combate cercano, destacando por su 
valentía y capacidad para enfrentar desafíos de manera directa.
* **<span style="color:darkviolet">Demon</span>**: Los Demonios personifican el 
caos y la oscuridad. Con habilidades místicas y una conexión con el inframundo, 
los portadores de este rol desatan poderes tenebrosos en el campo de batalla, 
sembrando la confusión y el temor entre sus enemigos.
* **<span style="color:pink">Psychic</span>**: Los Psíquicos poseen habilidades 
mentales extraordinarias. Capaces de manipular mentes y energías psíquicas, este 
rol destaca por su astucia estratégica y la capacidad de influir en el 
comportamiento de los adversarios.
* **<span style="color:red">Fire</span>**: Los portadores del elemento Fuego 
canalizan la ardiente furia de las llamas. Caracterizados por su poder destructivo,
los roles de Fuego infligen daño devastador a sus oponentes, convirtiendo el campo
de batalla en un espectáculo de caos y destrucción.
* **<span style="color:lightblue">Cold</span>**: El rol de Frío representa la 
frialdad y la astucia. Los personajes asociados con el Frío tienen la capacidad 
de congelar a sus enemigos, ralentizando y debilitando a aquellos que se cruzan en 
su camino.
* **<span style="color:brown">Beast</span>**: Los seres Bestiales encarnan la 
ferocidad y la agilidad. Con instintos salvajes y habilidades animales, los roles de
Bestia destacan por su velocidad y capacidad para emboscar a los oponentes.
* **<span style="color:blue">Water</span>**: Los portadores del elemento Agua son 
maestros de la fluidez y la adaptabilidad. Con la capacidad de manipular el agua, 
estos roles son versátiles en el campo de batalla, controlando el entorno y 
desafiando a sus enemigos.
* **<span style="color:yellow">Electric</span>**: El rol Eléctrico irradia energía 
y velocidad. Con la capacidad de canalizar la electricidad, estos personajes 
sorprenden a sus adversarios con movimientos rápidos y descargas eléctricas 
poderosas.
* **<span style="color:violet">Venom</span>**: Los roles de Veneno destacan por su
astucia y capacidad para infligir efectos debilitantes a través de toxinas mortales.
Su táctica se centra en socavar la resistencia de sus oponentes a lo largo del tiempo.
* **<span style="color:orange">Radiant</span>**: La luz y la benevolencia caracterizan
a los roles Radiantes. Dotados de habilidades curativas y protectores, estos personajes
son fundamentales en la preservación del equipo, ofreciendo apoyo vital en el campo
de batalla.


![Roles y sus representaciones](assets/readme/icons.svg)

A continuación, presentamos una visualización clara de cómo interactúan los roles entre sí, donde las
flechan parten de aquellos roles que son fuertes contra otros. Por ejemplo, el rol de Fire es fuerte 
contra el de Cold, mientras que el rol de Cold es fuerte contra el de Water.

![Roles y sus relaciones](assets/readme/counters.svg)


### Personajes

Antes de profundizar en los detalles específicos de los roles, conozcamos a los héroes y villanos que dan vida a 
esta emocionante trama. Cada personaje aporta su propio conjunto de habilidades y personalidad única al juego.

A continuacion se presentan los personajes del juego:

* **<span style="color:darkviolet">AbyssWalker</span>**: AbyssWalker, cuyo verdadero nombre es desconocido, era en sus días anteriores un valiente guerrero que luchaba por la justicia y la paz en el reino. Sin embargo, su vida dio un giro oscuro cuando fue enviado en una misión para derrotar al malévolo EvilBeast. En la confrontación final, AbyssWalker se vio enfrentado a una elección crucial: sacrificarse para destruir a EvilBeast o sucumbir a la oscuridad. Optó por el sacrificio, pero en el proceso, su alma fue corrompida, y renació como un ser vinculado a las profundidades del abismo.
* **<span style="color:orange">Archangel</span>**: Conocido como el mensajero celestial, Archangel es un ser divino enviado por los dioses para restaurar la paz en la tierra. Su presencia es invocada en tiempos de crisis, interviniendo como un rescatista en las batallas más desesperadas. Su propósito es luchar contra las fuerzas oscuras que amenazan con sumir al mundo en caos. Archangel es símbolo de esperanza y redención, guiando a aquellos que buscan la luz en medio de la oscuridad.
* **<span style="color:red">Blaze</span>**: Blaze, un mago poderoso, buscaba desentrañar los misterios de la creación. En un experimento para crear vida a través de la magia, accidentalmente dio origen al Golem de Fuego, una criatura ígnea que escapó de su control. Ahora, Blaze, sintiéndose responsable de la creación del Golem, se embarca en una búsqueda para contener y redirigir el poder destructivo de la criatura. Utiliza sus habilidades mágicas para mantener al Golem bajo cierto grado de supervisión, aunque la tarea es difícil debido a la naturaleza indomable de la criatura.
* **<span style="color:violet">Blob</span>**: Creado como un arma biológica para contrarrestar seres radiantes, Blob es una entidad amorfa con propiedades venenosas. Su origen se remonta a un laboratorio secreto donde científicos intentaban desarrollar un arma definitiva contra las fuerzas oscuras. Blob no tiene inclinaciones hacia el bien o el mal y, en cambio, busca la supervivencia en un mundo que lo percibe como una amenaza. Sus habilidades venenosas son una defensa natural, y su presencia en el campo de batalla puede ser tanto una bendición como una maldición, dependiendo de cómo se enfoque su poder.
* **<span style="color:pink">Cadabra</span>**: Cadabra es un hechicero solitario y misterioso que prefiere la soledad. Su pasado está envuelto en secretos, pero su magia es innegablemente poderosa. Evita involucrarse en conflictos, pero cuando se ve obligado a actuar, su destreza mágica es una fuerza imparable.
* **<span style="color:orange">Cleric</span>**: Residiendo en una antigua iglesia, Cleric es un invocador sagrado que posee la habilidad de llamar al Archangel en tiempos de necesidad. Su vida está dedicada a proteger el reino y luchar contra las fuerzas de la oscuridad que amenazan con invadir la tierra sagrada. Si bien su especialidad no es la lucha, pone todo de si en la batalla cuando se lo requiere.
* **<span style="color:violet">CrowApostate</span>**: Descendiente de aves místicas, CrowApostate es un ser oscuro que reside en una catedral malévola. Su conexión con la oscuridad le otorga habilidades sombrías y un deseo de venganza. Su presencia se siente en la penumbra, y su historia se entrelaza con antiguos secretos de la magia negra.
* **<span style="color:yellow">ElectroBOOM</span>**: Antaño un conocido youtuber de física, ElectroBOOM se electrocutó en un desafortunado experimento. En lugar de enfrentar la muerte, adquirió poderes de electricidad. Ahora, como maga elemental, utiliza sus habilidades para proteger el reino de amenazas sobrenaturales.
* **<span style="color:brown">EvilBeast</span>**: EvilBeast es la encarnación misma de la oscuridad. Antaño un ser benevolente, su corazón fue corrompido por fuerzas malignas, convirtiéndolo en una criatura sedienta de destrucción. Su origen está envuelto en misterio, pero se cree que siempre fue un ser del mal.
* **<span style="color:red">Golem</span>**: Golem, nacido de la ambición del mago Blaze, es una criatura de fuego imparable. Originalmente creado para ser controlado, el Golem se liberó de las ataduras de Blaze durante un experimento que salió mal. Ahora, vaga por el reino como una fuerza de destrucción incontrolada. Aunque su naturaleza es caótica, el Golem puede ser dirigido hacia el mal que amenaza el reino, convirtiéndolo en un aliado incierto pero poderoso.
* **<span style="color:orange">HolyKnight</span>**: HolyKnight es un caballero valiente que ha jurado proteger el reino de toda oscuridad. Armado con una espada sagrada y una armadura resplandeciente, HolyKnight personifica la virtud y la justicia. Su lealtad al bien lo lleva a enfrentarse a las fuerzas del mal con valentía y honor, sirviendo como un faro de esperanza para aquellos que lo siguen.
* **<span style="color:lightblue">IceBeast</span>**: IceBeast es una criatura majestuosa nacida de las heladas tierras del norte. Su presencia trae consigo una ola de frío intenso, capaz de congelar todo a su paso. Aunque no tiene una inclinación malévola, IceBeast es convocado en tiempos desesperados para detener el avance de las fuerzas oscuras con su aliento gélido y su fuerza titánica.
* **<span style="color:blue">Ninja</span>**: Ninja, maestro de las artes marciales y sigiloso protector, ha desarrollado una conexión única con el elemento agua. Su entrenamiento incluyó técnicas ancestrales que fusionan las habilidades del ninja con la fluidez del agua. En lugar de las sombras, el Ninja se desliza entre las corrientes y los reflejos líquidos, camuflándose en ambientes acuáticos para proteger sus propios intereses y garantizar el equilibrio en el reino.
* **<span style="color:orange">Siren</span>**: Siren, una criatura mítica que habita cerca del reino radiante, es conocida por su canto hipnotizador y su belleza cautivadora. Aunque su aspecto podría sugerir peligro, Siren no es inherentemente malévola. Su historia se remonta a un tiempo en que vivía en armonía con las fuerzas de la luz. Sin embargo, eventos pasados la han dejado sola y buscando conexión con aquellos que puedan comprender su verdadera naturaleza. Su canto puede tanto encantar como proteger, dependiendo de la intención de quien lo escuche.
* **<span style="color:grey">Spartan</span>**: Spartan, un guerrero imponente, es conocido por su lealtad inquebrantable al bien. Educado en las artes de la guerra desde temprana edad, Spartan es la personificación de la valentía y la disciplina. Su armadura reluce con la luz de la justicia, y su habilidad con la espada es incomparable. Se le llama en momentos críticos para liderar la defensa contra las hordas enemigas y mantener la esperanza en los corazones de los guerreros.


![Personajes](assets/readme/characters.svg)


___

## Como jugar


1. Utiliza el siguiente comando para clonar este repositorio en tu sistema:

``` bash
git clone https://github.com/ramirocabral/tpfinal.git
```

2. Navega al directorio del repositorio clonado, y luego al directorio donde se encuentra el archivo :

``` bash
cd tpfinal
cd src
```

3. Compilar:

``` bash
javac Main.java
```

4. Ejecutar:
``` bash
java Main
```

___
## Autores

Este proyecto fue desarrollado por:

- **[@ramirocabral](https://github.com/ramirocabral)**
- **[@ManuSavenia](https://github.com/ManuSavenia)**
- **[@gonblas](https://github.com/gonblas)**

___

## ¡Gracias por Visitar!

Gracias por explorar nuestro repositorio. Esperamos que disfrutes de 
la experiencia del juego. Si tienes preguntas, sugerencias o simplemente
quieres decir hola, no dudes en abrir un problema o ponerte en contacto 
con nosotros.

✨ ¡Que tengas un día increíble! ✨



