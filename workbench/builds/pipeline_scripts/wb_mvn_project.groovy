pipeline {
    stages {
        stage('SCM') {
            steps {
                step([$class: 'WsCleanup'])
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'PathRestriction', excludedRegions: '', includedRegions: '']], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/durgasai/mvnproject.git']]])
            }
        }
        stage('Build') {
            steps {
                sh 'echo Hello World!'
                sh 'ls'
            }
        }
    }
}