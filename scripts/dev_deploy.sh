#!/usr/bin/env bash

USER=$1
HOST=$2
PORT=$3

mvn -P dev package
docker build . --tag music_room:latest
docker save big_bro_eye:latest postgres:11.3 > images.tar
rsync -avhe "ssh -p $PORT" --progress docker-compose-dev.yml $USER@$HOST:~/music_room/docker-compose.yml
rsync -avhe "ssh -p $PORT" --progress images.tar $USER@$HOST:~/music_room
ssh $USER@$HOST -p $PORT "
cd music_room
sudo docker load < images.tar
sudo docker-compose up -d
cd ..
sudo docker image prune -f
"
docker image prune -f
rm images.tar