# FEF System Information (JavaFX + MVC)

Aplicacion de escritorio para gestionar informacion de equipos de futbol:

- Equipo (`nombreEQ`, `ciudad`, `estado`)
- Personal de utileria (`ci`, `nombres`, `ocupacion`)
- Directivos (`ci`, `nombres`, `cargo`)
- Equipo tecnico (`ci`, `nombres`, `nacionalidad`, `cargo`)
- Jugadores (`ci`, `nombres`, `posicion`, `edad`, `peso`)

## Arquitectura

- **Modelo**: `src/main/java/ec/edu/upse/FEF/modelo`
- **Controlador**: `src/main/java/ec/edu/upse/FEF/controlador`
- **Servicio (logica de negocio)**: `src/main/java/ec/edu/upse/FEF/general`
- **Vista (FXML)**: `src/main/resources/ec/edu/upse/FEF/vista/fef-view.fxml`

## Requisitos

- JDK 17 o superior
- Maven (o usar el wrapper `mvnw.cmd` en Windows)

## Ejecutar

```powershell
.\mvnw.cmd clean javafx:run
```

## Probar

```powershell
.\mvnw.cmd test
```

## Flujo de uso rapido

1. Registrar un equipo en la pestana **Equipo**.
2. Registrar utileros, directivos, tecnicos y jugadores seleccionando el equipo en cada pestana.
3. Ir a **Resumen**, elegir el equipo y presionar **Ver resumen**.

