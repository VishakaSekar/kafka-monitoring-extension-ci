
DOCKER_RUN=$(DOCKER_COMPOSE) up -d --build
DOCKER_STOP=$(DOCKER_COMPOSE) down
dockerRun: ## Run MA in docker
	@echo starting container ##################%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&
	${DOCKER_RUN}
	@echo started container ##################%%%%%%%%%%%%%%%%%%%&&&&&&&&&&&&&&&&&&&&&&

dockerStop:
	${DOCKER_STOP}