 job('dsl_seed_wb') {
     scm {
         git {
             remote {
                 url('https://github.com/durgasai/jenkinsworkspace.git')
             }
             branches('*/master')
         }
     }
     triggers {
         upstream('seed','UNSTABLE')
     }
     wrappers {
         preBuildCleanup()
     }
     steps {
         dsl {
             external('./workbench/dsl_seeds_wb.groovy')
             removeAction('DELETE')
             removeViewAction('DELETE')
         }
     }
 }

