job('dsl_seed_wb_builds') {
    scm {
        git {
            remote {
                url('https://github.com/durgasai/jenkinsworkspace.git')
            }
        branches('*/master')
        }
    }
    triggers {
        upstream('dsl_seed_wb','UNSTABLE')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
        dsl {
            external('./workbench/builds/builds_wb.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}