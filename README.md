# Getting started with the project

## Setup local environment with Colima

1. Open terminal and navigate to the home directory.
2. Open the zshrc file.
   ```bash
   sudo nano ~/.zshrc
   ```
3. Add the following lines to the end of the file.
   ```bash
   export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock
   export TESTCONTAINERS_HOST_OVERRIDE=$(colima ls -j | jq -r '.address')
   export DOCKER_HOST="unix://${HOME}/.colima/default/docker.sock"
   ```
   If you are using a other profile name instead of 'default', replace the following lines to the end of the file.
   ```bash
   export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock
   export TESTCONTAINERS_HOST_OVERRIDE=$(colima ls -j | jq -r 'select(.name == "[PORFILE NAME]") | .address')
   export DOCKER_HOST="unix://${HOME}/.colima/[PROFILE NAME]/docker.sock"
   ```
4. Run the colima start command to start the Colima instance.
   ```bash
   colima start
   ```

## testing at IntelliJ

Run > Edit configurations... > 왼쪽 하단의 Edit configuration templates... > JUnit > Environment variables 에 아래 추가

```bash
TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock;TESTCONTAINERS_HOST_OVERRIDE=192.168.64.3;DOCKER_HOST=unix:///Users/al02531070/.colima/default/docker.sock
```