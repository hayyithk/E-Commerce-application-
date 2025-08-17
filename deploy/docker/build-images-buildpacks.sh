#!/bin/bash

# Navigate to project root
cd ../..

echo "Building all microservices..."

# Build all services
echo "Building eureka-server..."
cd eureka && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building gateway..."
cd gateway && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building config-server..."
cd configserver && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building order-service..."
cd order && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building user-service..."
cd user && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building product-service..."
cd product && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "Building notification-service..."
cd notification && ./mvnw spring-boot:build-image -DskipTests && cd ..

echo "All services built successfully!"
echo "You can now run 'docker-compose up -d' from the deploy/docker directory"