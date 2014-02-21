var pmPlugin = 
{
    hasFeature: function(feature, successCallback, errorCallback) 
	{
        cordova.exec(
            successCallback, 	// callback fn on success
            errorCallback, 		// callback fn on failure
            'pmPlugin', 		// mapped to "pmPlugin" Java class
            'hasFeature', 		// action to execute
            [{                  // arguments
                "feature": feature
            }]
        ); 
    }
}

module.exports = pmPlugin;