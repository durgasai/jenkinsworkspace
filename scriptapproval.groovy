pipelineJob('script_approval')
        {
            definition {
                cps {
                    def pipelinescript = readFileFromWorkspace('dsl_meta_seed_labs.groovy')
                    script(pipelinescript)
                    def scriptApproval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]
                    scriptApproval.approveScript(scriptApproval.hash(pipelinescript, 'groovy'))
                }
            }
        }