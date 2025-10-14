# Imagen base con Java 17
FROM eclipse-temurin:17-jdk-alpine

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el código fuente del proyecto
COPY . .

# Dar permisos de ejecución a Maven Wrapper
RUN chmod +x ./mvnw

# Compilar el proyecto sin ejecutar los tests
RUN ./mvnw clean package -DskipTests

# Exponer el puerto de la app (el mismo que tienes en application.properties)
EXPOSE 8081

# Ejecutar el JAR generado
ENTRYPOINT ["java", "-jar", "target/hospital_crud-0.0.1-SNAPSHOT.jar"]
