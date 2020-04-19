definition {
    cps {
        def pipelinescript = readFileFromWorkspace('...*.groovy')
        script(pipelinescript)
        def scriptApproval = Jenkins.instance.get
    }
}