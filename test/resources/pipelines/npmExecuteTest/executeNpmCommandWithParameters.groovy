@Library('piper-library-os')

execute() {
    node() {
        npmExecute(script: this, dockerImage: 'myNodeImage') {
            sh 'npm install'
        }
    }
}

return this


