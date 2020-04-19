 job('dsl_seed_wb') {
     scm {
         git {
             remote {
                 url('https://github.com/durgasai/jenkinsworkspace.git')
             }
             branches('*/master')
         }
     }
     wrappers {
         prebuildclenup()
     }
     steps {
         dsl {
             external('./workbench/dsl_seeds_wb.groovy')
             removeAction('DELETE')
             removeViewAction('DELETE')
         }
     }
 }
