# Stage 1: Build the React application
FROM node:20-alpine AS builder
WORKDIR /app

# Copy package files and install dependencies
COPY package*.json ./
RUN npm ci

# Copy the rest of the application code and build it
COPY . .
RUN npm run build

# Stage 2: Serve the static files using Nginx
FROM nginx:1.31.1-alpine AS runner

# Copy the compiled static production files from the build stage
# Note: If using Vite, the output folder is /app/dist. If using Create React App, it is /app/build.
COPY --from=builder /app/dist /usr/share/nginx/html

# Expose port 80 (the default Nginx port)
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
