#!/bin/bash

# Navigate to project root
cd ../..

echo "Building all microservices..."

# Build all services
echo "Building eureka-server..."
cd eureka && ./mvnw clean compile jib:build && cd ..

echo "Building gateway..."
cd gateway && ./mvnw clean compile jib:build && cd ..

echo "Building config-server..."
cd configserver && ./mvnw clean compile jib:build && cd ..

echo "Building order-service..."
cd order && ./mvnw clean compile jib:build && cd ..

echo "Building user-service..."
cd user && ./mvnw clean compile jib:build && cd ..

echo "Building product-service..."
cd product && ./mvnw clean compile jib:build && cd ..

echo "Building notification-service..."
cd notification && ./mvnw clean compile jib:build && cd ..

echo "All services built successfully!"
echo "You can now run 'docker-compose up -d' from the deploy/docker directory"