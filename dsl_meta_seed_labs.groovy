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
     definition {
         cps {
             def pipelinescript = readFileFromWorkspace('dsl_meta_seed_labs.groovy')
             script(pipelinescript)
             def scriptApproval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]
             scriptApproval.approveScript(scriptApproval.hash(pipelinescript, 'groovy'))
         }
     }
 }

