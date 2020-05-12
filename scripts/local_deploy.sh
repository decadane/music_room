#!/usr/bin/env bash

mvn -P local package
docker build . --tag music_room:latest
docker-compose up -d
docker image prune -f
docker logs -f music_room_app
