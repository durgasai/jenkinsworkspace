definition {
    cps {
        def pipelinescript = readFileFromWorkspace('...*.groovy')
        script(pipelinescript)
        def scriptApproval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]
        scriptApproval.approveScript(scriptApproval.hash(pipelinescript, 'groovy'))
    }
}