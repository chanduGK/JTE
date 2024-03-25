void call() {
    stage("Compliance Check") {
        node {
            script {
                echo 'Checking the configuration files...'
                // This template requires package.json
                if (!fileExists('package.json')) {
                    //currentBuild.result = 'SUCCESS'
                    //error("Required file is missing: /package.json")
                }
                // This template requires a Dockerfile for containerization
                if (!fileExists('Dockerfile')) {
                    echo 'Dockerfile not found, see: https://palladium.kenvue.com/docs/default/component/ts-sw-palladium-user-guide/project-setup/'
                    //currentBuild.result = 'SUCCESS'
                    //error("Required file is missing: /Dockerfile")
                }
                // A catalog-info.yaml is required for the Palladium software catalog and for finding annotations
                if (!fileExists('catalog-info.yaml')) {
                    echo 'catalog-info.yaml not found, see: https://palladium.kenvue.com/docs/default/component/ts-sw-palladium-user-guide/project-setup/'
                    currentBuild.result = 'SUCCESS'
                    //error("Required file is missing: /catalog-info.yaml")
                }

            }
        }
    }
}