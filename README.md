# Final_POO_JeronimoSepulveda

## EnvíaYa – Sistema de despachos

## Hecho por:
-Jeronimo Sepulveda


## Solucion del Problema 

### 1. Un molde general para todos los paquetes
Todos los envíos tienen cosas en común: una **guía**, una **zona** y un **peso**. Por eso cree una clase general llamada `Paquete` que guarda esos datos.

Después un tipo de paquete por cada servicio. Cada uno hereda de `Paquete`:
- `Estandar`: el envío normal.
- `Express`: más rápido y más caro.
- `Fragil`: lleva algo delicado y hay que decir qué es.

### 2. Revisar los datos apenas se crea el paquete
Cuando se crea un paquete, primero se revisa que los datos estén bien. Si algo está mal, sale un error y el paquete **no se crea**:
- La guía debe ser `EY` + 4 números (ejemplo: `EY2001`).
- El peso debe ser mayor a 0 kg y máximo 20 kg, porque va en moto.
- Un paquete frágil debe decir qué contiene (por ejemplo "vajilla").

### 3. Calcular el precio
Todos parten del mismo **costo base**:

costo base = tarifa de la zona + 1000 × peso

Después cada servicio cambia el precio a su manera:
- **Estándar:** paga solo el costo base.
- **Express:** paga el costo base × 1.5.
- **Frágil:** paga el costo base + 5000.

### 4. Subir los paquetes a la moto (el despacho)
Cada mensajero tiene un `Despacho`, que es su carga del día. Antes de subir un paquete se revisan dos cosas:
- Que no haya otro paquete con **la misma guía**.
- Que con ese paquete el despacho **no pase de 30 kg**.

Si alguna falla, sale un error y ese paquete no se sube. Los paquetes que ya estaban siguen igual.

### 5. Ordenar las entregas
Para saber en qué orden entregar, se ordenan así:
1. Primero los **Express**, porque son urgentes.
2. Luego por **zona**, en el orden de la ruta: Centro → Norte → Sur → Oriente.
3. Si hay empate, por número de **guía**.

### 6. Imprimir el manifiesto
Al final se imprime una tabla con todos los paquetes en ese orden. Abajo se muestran el **peso total**, el **costo total** y las **advertencias**.

### 7. Los errores no detienen el programa
Cada error tiene su propia clase (guía inválida, peso inválido, guía repetida, etc.). En el `Main` cada paquete se agrega dentro de un `try/catch`. Así, si uno falla, se muestra el mensaje y el programa sigue con los demás.

## SOLID 

### 1. Abierto/Cerrado 
se puede agregar cosas nuevas sin cambiar lo que ya funciona.

Clases: `Paquete`, `Estandar`, `Express`, `Fragil`, `ManejoEspecial`.

Si mañana queremos un servicio nuevo, por ejemplo **Refrigerado**, solo creamos una clase nueva que herede de `Paquete` y le ponemos su propio precio en `costoEnvio()`. No hay que tocar `Despacho`, porque ellos tratan a todos los envíos como un `Paquete`.

### 2. Segregación 
no obligar a una clase a tener métodos que no necesita.

Clase: `ManejoEspecial`.

La advertencia de "cuidado, es frágil" está en una interfazaparte. Solo la usa `Fragil`, que es el único que la necesita. `Estandar` y `Express` no tienen que cargar con ese método.
