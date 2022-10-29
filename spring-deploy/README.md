## Despliegue de apps Spring Boot en Heroku

Crear archivo 'system.properties' en el proyecto con el contenido:

---
java.runtime.version=17
---

1. Crear cuentas en heroku.com y github.com
2. Tener configurado git en el ordenador
   1. git config --global user.name
   2. git config --global user.email
3. Subir el protecto a GitHub desde IntelliJ IDEA desde la opcion: VCS > Share project on GitHub
4. Desde Heroku, crear app y elegir método GitHub y buscar el repositorio subido
5. Habilitar deploy automatico y ejecutar el Deploy