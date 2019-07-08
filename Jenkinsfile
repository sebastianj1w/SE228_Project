node ('jnlp-slave'){

  stage ('git clone'){
    checkout master
    tag = sh(returnStdout: true, script: "git log -n 1 --pretty=format:'%h'").trim()
    appname = "frontend-app"
    }
  
  stage ('show') {
    sh "echo 'a echo test'"
  }
  
}
