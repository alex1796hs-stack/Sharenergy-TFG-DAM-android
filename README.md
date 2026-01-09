# Sharenergy – TFG DAM

Este repositorio contiene el desarrollo del Trabajo de Fin de Grado del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM).  
El proyecto consiste en una aplicación Android que simula un sistema de alquiler de powerbanks, inspirado en los servicios de alquiler que se utilizan en algunos países asiáticos.

## Descripción general

La aplicación permite al usuario alquilar una powerbank de forma sencilla a través de un proceso guiado.  
El flujo de uso es el siguiente:

- Acceso inicial mediante un código QR simulado
- Registro básico del usuario mediante número de teléfono
- Selección de una powerbank disponible
- Uso del dispositivo con contador de tiempo
- Devolución de la powerbank y cálculo del precio final
- Simulación del proceso de recarga tras la devolución

El objetivo principal del proyecto es simular el funcionamiento básico de este tipo de servicios y validar la gestión de estados y el control de disponibilidad de los dispositivos.

## Funcionamiento del sistema

El sistema gestiona dos powerbanks para representar distintos escenarios posibles.  
Cada powerbank puede encontrarse en uno de los siguientes estados:

- Disponible
- No disponible (en uso)
- Recargando

Cuando una powerbank es alquilada, pasa a estado no disponible para el resto de usuarios.  
Tras la devolución, se inicia un tiempo de recarga simulado, durante el cual no puede volver a ser alquilada.

## Cálculo del precio

El precio del alquiler se calcula de la siguiente forma:

- Precio base de desbloqueo: 0,50 €
- Coste adicional por tiempo de uso: 0,02 € por minuto

El desglose del precio se muestra al usuario al finalizar el alquiler.

## Limitaciones

El proyecto tiene un enfoque académico, por lo que presenta algunas limitaciones:

- El código QR es únicamente representativo y no se realiza una lectura real.
- No existe integración con sistemas de pago reales.
- Los datos de usuarios y alquileres se gestionan solo en memoria.
- No se implementan sistemas avanzados de autenticación o notificaciones.

Estas limitaciones no afectan al objetivo principal del proyecto, que es la simulación del sistema de alquiler.

## Ejecución del proyecto

El proyecto puede ejecutarse desde Android Studio, utilizando un emulador o un dispositivo Android físico.

## Autor del proyecto: Alejandro Jesus Calvo Gonzalez

Proyecto realizado como Trabajo de Fin de Grado del ciclo de Desarrollo de Aplicaciones Multiplataforma (DAM).
