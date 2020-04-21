nestedView('Workbench') { //Creates or updates a view that allows grouping views into multiple levels.
    views { //Adds nested Views
        categorizedJobsView('Workbench Overview') {
            jobs {
                regex(/WB.*/) // regex will be applied to all job names
            }
            categorizationCriteria { //Add grouping rules
                regexGroupingRule(/WB_Dev*.*_Build/, "WB Dev Builds") // Adds a rule to build groups of jobs that will be categorized by using a regular expression.
                regexGroupingRule(/WB_Dev_*.*_Deploy*.*/, "WB Dev Deploys")
                regexGroupingRule(/WB_Dev*.*_Build_PR/, "WB PR Builds")
                regexGroupingRule(/WB_*.*_Promote*.*/, "WB Promotes")
                regexGroupingRule(/WB_QA_*.*_Deploy*.*/, "WB QA Deploys")
            }
            columns { //Add columns to the views
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }
        listView('Workbench Dev Builds') {
            jobs {
                regex(/WB_Dev*.*_Build/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }//end list view
        listView('Workbench Dev Deploys') {
            jobs {
                regex(/WB_Dev_*.*_Deploy*.*/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }//end list view
        listView('Workbench Promotes') {
            jobs {
                regex(/WB_*.*_Promote*.*/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }//end list view
        listView('Workbench Dev Pull Request Builds') {
            jobs {
                regex(/WB_Dev*.*_Build_PR/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }//end list view

        listView('Workbench QA Deploys') {
            jobs {
                regex(/WB_QA_*.*_Deploy*.*/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }//end list view
    }
    configure { view ->
        view / defaultView('Workbench Overview')
    }
}