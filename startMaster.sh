iptables -F

docker swarm leave --force

token = $(docker swarm init)

cd master

docker-compose up -d

echo $token