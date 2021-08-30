#!/bin/bash
command=$1
profile=$2

build_project(){
  ./mvnw clean package
}

up_docker_compose(){
  docker compose -f ./docker/docker-compose.yml --profile $profile up -d
}

down_docker_compose(){
  docker compose -f ./docker/docker-compose.yml --profile $profile down
}

clean_docker(){
  docker rm $(docker ps -a -q)
  docker rmi $(docker images -q)
  docker volume prune
  docker system prune --all --force --volumes
}

estimular_sistema_transacao(){
  ../../curl-7.78.0-win64-mingw/bin/curl.exe --location --request POST 'http://localhost:8081/api/cartoes' --header 'Content-Type:application/json' --data-raw '{"id":"5541da9c-79c5-44fb-b701-cc50ed07b45d","email":"luram.archanjo@zup.com.br"}'
}

desestimular_sistema_transacao(){
  ../../curl-7.78.0-win64-mingw/bin/curl.exe --location --request DELETE 'http://localhost:8081/api/cartoes/5541da9c-79c5-44fb-b701-cc50ed07b45d'
}

case $command in
  "start")
    if [ "$profile" = "producao" ];
    then
      build_project
    fi
    up_docker_compose
  ;;
  "end")
    down_docker_compose
    clean_docker
  ;;
  "transacao-start")
    estimular_sistema_transacao
  ;;
  "transacao-end")
    desestimular_sistema_transacao
  ;;
  *)
    echo "Comando nao existe!!"
  ;;
esac