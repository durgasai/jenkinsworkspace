pipelineJob('WB_Dev_MVN_Build'){
    logRotator {
        numToKeep(5)
    }
    properties {
        githubProjectUrl('https://github.com/durgasai/mvnproject.git')
    }
    definition {
        cps {
            script(readFileFromWorkspace('./workbench/builds/pipeline_scripts/wb_mvn_project.groovy'))
            sandbox()
        }
    }
}