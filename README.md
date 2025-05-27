# Getting started with the project

## Install colima with homebrew
   Reference site : https://github.com/abiosoft/colima
1. Download colima
   ```bash
   brew install colima
   ```

## Setup IntelliJ development environment with Colima
1. Run the colima start command to start the Colima instance.
   ```bash
   colima start --network-address
   ```
2. Set environment variables
   Run >   
   Edit configurations... >    
   In the lower left corner, click the Edit configuration templates... >   
   JUnit > Add the following to Environment variables
   ```bash
   TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock;TESTCONTAINERS_HOST_OVERRIDE=[docker_IP];DOCKER_HOST=unix:///Users/[home_directory]/.colima/default/docker.sock
   ```
   * Get value of docker_IP
     ```bash
     colima list
     ```
3. Before running the test, check the Gradle settings.
   - Open > File > Settings > Build, Execution, Deployment > Build Tools > Gradle
   - Build and run using value should be set to IntelliJ IDEA.

### Without IntelliJ
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