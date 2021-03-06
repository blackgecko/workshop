podTemplate(label: "dotnet-31",
            cloud: "openshift",
            inheritFrom: "maven",
            containers: [
                containerTemplate(name: "jnlp",
                                image: "registry.redhat.io/dotnet/dotnet-31-jenkins-agent-rhel7:latest",
                                ttyEnabled: true,
                                envVars: [
                                    envVar(key: "CONTAINER_HEAP_PERCENT", value: "0.25")
                                ])
            ],
            volumes: [
            ]) {
    node("dotnet-31") {
        stage("checkout") {
          sh 'printenv'
          checkout scm
        }
    }
}