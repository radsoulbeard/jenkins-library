import com.sap.piper.ConfigurationLoader
import com.sap.piper.ConfigurationMerger

def call(Map parameters = [:], body) {

    handlePipelineStepErrors(stepName: 'npmExecute', stepParameters: parameters) {
        final script = parameters.script

        prepareDefaultValues script: script
        final Map stepDefaults = ConfigurationLoader.defaultStepConfiguration(script, 'npmExecute')

        final Map stepConfiguration = ConfigurationLoader.stepConfiguration(script, 'npmExecute')

        List parameterKeys = [
            'dockerImage',
            'dockerOptions'
        ]
        List stepConfigurationKeys = ['dockerImage']

        Map configuration = ConfigurationMerger.merge(parameters, parameterKeys, stepConfiguration, stepConfigurationKeys, stepDefaults)

        dockerExecute(dockerImage: configuration.dockerImage, dockerOptions: configuration.dockerOptions) { body() }
    }
}


