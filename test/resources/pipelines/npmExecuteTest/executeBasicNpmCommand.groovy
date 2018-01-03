@Library('piper-library-os')

execute() {
    node() {
        npmExecute(script: this) {
            sh 'npm install'
        }
    }
}

return this
