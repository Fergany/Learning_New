- Docker is a tool for running app in an isolated environment.
 
- its ability to reduce the amount of time it takes to set up the environments where applications run and are developed. 
Just look at how long it takes to set up an environment where you have a node and express API for backend, which also needs Mongo. 


Kubernetes (K8s) is an open-source system for automating deployment, scaling, and management of containerized applications. 
It groups containers that make up an application into logical units for easy management and discovery. Kubernetes builds upon 15 years of experience of running production workloads at Google, combined with best-of-breed ideas and practices from the community.


Scenarios:
==========
- Setting up a new project.
- Same setup across different systems.
- Same setup across different projects or developers.

how can you guarantee every developer will run the same environment resources, let alone the same versions? 

Deploy your first Docker application:
--------------------------------------
Create two files: 
'DockerFile' is the blueprint for your container.
'.dockerignore'

Explore base commands:
----------------------
docker 
docker images
docker rmi image_id
docker run -p port:port image_name
docker ps // list container what we have right now
docker stop
docket start

to push/pull images from docker hub:
docker pull image_name

