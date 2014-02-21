package com.ge.pmplugin;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import android.content.pm.PackageManager;

public class pmPlugin extends CordovaPlugin
{
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
	{
		PackageManager pm = context.getPackageManager();
		JSONObject arg_object = args.getJSONObject(0);
		try 
		{
			if (ACTION_CHECK_FEATURE.equals("hasFeature"))
			{
				String feature = arg_object.getString("feature");
				if (pm.hasSystemFeature(PackageManager[feature])) //.FEATURE_CAMERA)) 
				{
					callbackContext.success();
					return true;
				}
				return false;
			}
			callbackContext.error("Invalid action");
			return false;
		} 
		catch(Exception e) 
		{
			System.err.println("Exception: " + e.getMessage());
			callbackContext.error(e.getMessage());
			return false;
		} 
	}
}