# INSTRUCCIONES
Lee cuidadosamente cada uno de los requerimientos que se te presentan a continuación y desarrolla la prueba de acuerdo con lo solicitado.

## DESCRIPCIÓN
Se solicita la creación de un sistema web fabricado expresamente en lenguaje **Java** y la especificación empresarial que sirva para consultar el **animal representante en el horóscopo chino** de acuerdo con el año de nacimiento.

El sistema debe poder **registrar los datos básicos del usuario** para crear una sesión y así permitir el inicio de sesión. **Usuarios no registrados no pueden visualizar el buscador.**

### Consulta tu horóscopo chino
Para conocer el signo del horóscopo chino, debemos **dividir el año de nacimiento entre 12**.  
El **resto**, que estará entre 0 y 11, está asociado a un signo según la siguiente tabla:

| Resto | Signo del Horóscopo Chino |
|-------|---------------------------|
| 0     | Mono                      |
| 1     | Gallo                     |
| 2     | Perro                     |
| 3     | Cerdo                     |
| 4     | Rata                      |
| 5     | Buey                      |
| 6     | Tigre                     |
| 7     | Conejo                    |
| 8     | Dragón                    |
| 9     | Serpiente                 |
| 10    | Caballo                   |
| 11    | Cabra                     |

### Lógica del sistema
- Para **conocer el signo del horóscopo chino**, se consulta primero la **base de datos**.
- El sistema debe tener un **método que reciba un usuario** como parámetro.
- El método obtendrá **todos los signos** junto con sus años correspondientes y los almacenará en una **lista de entidad `Horóscopo`**.

### Consideraciones
- El sistema debe garantizar que **solo los usuarios registrados puedan iniciar sesión** y acceder al buscador del horóscopo chino.
- Debe tener una **función de registro de usuarios** que capture los datos básicos necesarios para crear la sesión.

---

# Instrucciones para la Generación del Modelo de Datos

Se debe crear un modelo de datos que soporte la aplicación con las siguientes tablas. Además, es necesario cargar el archivo `horóscopo.xsl` (ubicado en el apoyo) para insertar los datos en la tabla **HOROSCOPO**.

## Especificación de las Tablas

```sql
CREATE TABLE HOROSCOPO (
  ANIMAL VARCHAR2(30 BYTE),
  FECHA_INICIO DATE,
  FECHA_FIN DATE
);

CREATE TABLE USUARIOS (
  ID NUMBER,
  NOMBRE VARCHAR2(30 BYTE),
  USERNAME VARCHAR2(30 BYTE),
  EMAIL VARCHAR2(30 BYTE),
  FECHA_NACIMIENTO DATE,
  PASSWORD VARCHAR2(30 BYTE),
  ANIMAL VARCHAR2(30 BYTE)
);
```

¡Suerte en el desarrollo del sistema!# horoscopo
