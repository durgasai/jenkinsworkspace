pipelineJob('WB_Dev_MVN_Build'){
    publishers {
        plotBuildData {
            plot('Exciting plots', 'excitement.csv') {
                title('X vs Y')
                yAxis('Y')
                numberOfBuilds(42)
                useDescriptions()
                keepRecords()
                excludeZero()
                logarithmic()
                yAxisMinimum(10.0)
                yAxisMaximum(100.0)
                propertiesFile('my_data.properties') {
                    label('Builds')
                }
            }
        }
    }
    logRotator {
        numToKeep(5)
    }
    properties {
        githubProjectUrl('https://github.com/durgasai/mvnproject.git')
    }
    triggers {
        githubPush()
    }
    definition {
        cps {
            script(readFileFromWorkspace('./workbench/builds/pipeline_scripts/wb_mvn_project.groovy'))
            sandbox()
        }
    }
}