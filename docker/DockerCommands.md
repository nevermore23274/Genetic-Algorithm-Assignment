# To Build
- Podman
```podman build -f docker/Dockerfile -t genetic-algo .```

- Docker
```podman build -f docker/Dockerfile -t genetic-algo .```

# For Test
- Podman
```podman run -it --name java-container genetic-algo /bin/sh```

- Docker
```docker run -it --name java-container genetic-algo /bin/sh```

# To Run, the First Time
- Podman
```podman run --name java-container genetic-algo```

- Docker
```docker run --name java-container genetic-algo```

# If you haven't Run the Cleanup
- Podman
```podman run genetic-algo```

- Docker
```docker run genetic-algo```

# To Cleanup
- Podman
```podman system prune -af```

- Docker
```docker system prune -af```