iptables -F

docker swarm leave --force

docker swarm init

cd master

docker-compose up -d