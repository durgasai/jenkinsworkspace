//This is the root for all seed jobs
job('dsl_seed_wb') {
    scm {
        git {
            remote {
                url('https://github.com/durgasai/jenkinsworkspace.git')
                credentials('cceb261e-9648-4220-9ed9-c7e315178821')
            }
            branches('*/master')
        }
    }
}