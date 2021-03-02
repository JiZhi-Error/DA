package org.xwalk.core.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkExternalExtensionManager;
import org.xwalk.core.XWalkNativeExtensionLoader;
import org.xwalk.core.XWalkView;

public class XWalkExternalExtensionManagerImpl extends XWalkExternalExtensionManager implements XWalkExtensionContextClient {
    private static final String TAG = "XWalkExternalExtensionManagerImpl";
    private final Context mContext;
    private final HashMap<String, XWalkExternalExtensionBridge> mExtensions = new HashMap<>();
    private boolean mLoadExternalExtensions;
    private final XWalkNativeExtensionLoader mNativeExtensionLoader;
    private final XWalkView mXWalkView;

    public XWalkExternalExtensionManagerImpl(XWalkView xWalkView) {
        super(xWalkView);
        AppMethodBeat.i(155305);
        this.mXWalkView = xWalkView;
        if (getBridge() == null) {
            Log.e(TAG, "Cannot load external extensions due to old version of runtime library");
            this.mContext = null;
            this.mLoadExternalExtensions = false;
            this.mNativeExtensionLoader = null;
            AppMethodBeat.o(155305);
            return;
        }
        this.mContext = getViewContext();
        this.mLoadExternalExtensions = true;
        this.mNativeExtensionLoader = new XWalkNativeExtensionLoader();
        loadNativeExtensions();
        AppMethodBeat.o(155305);
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void registerExtension(XWalkExternalExtension xWalkExternalExtension) {
        AppMethodBeat.i(155306);
        if (this.mExtensions.get(xWalkExternalExtension.getExtensionName()) != null) {
            Log.e(TAG, xWalkExternalExtension.getExtensionName() + "is already registered!");
            AppMethodBeat.o(155306);
            return;
        }
        this.mExtensions.put(xWalkExternalExtension.getExtensionName(), XWalkExternalExtensionBridgeFactory.createInstance(xWalkExternalExtension));
        AppMethodBeat.o(155306);
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void unregisterExtension(String str) {
        AppMethodBeat.i(155307);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = this.mExtensions.get(str);
        if (xWalkExternalExtensionBridge != null) {
            this.mExtensions.remove(str);
            xWalkExternalExtensionBridge.onDestroy();
        }
        AppMethodBeat.o(155307);
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public Activity getActivity() {
        if (this.mContext instanceof Activity) {
            return (Activity) this.mContext;
        }
        return null;
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(155308);
        ActivityNotFoundException activityNotFoundException = new ActivityNotFoundException("This method is no longer supported");
        AppMethodBeat.o(155308);
        throw activityNotFoundException;
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void loadExtension(String str) {
        String str2;
        AppMethodBeat.i(155309);
        if (!this.mLoadExternalExtensions) {
            AppMethodBeat.o(155309);
            return;
        }
        int length = str.length();
        if (str.charAt(length - 1) == File.separatorChar) {
            str = str.substring(0, length - 1);
        }
        String str3 = str + File.separator + str.substring(str.lastIndexOf(File.separatorChar) + 1) + ".json";
        try {
            try {
                JSONObject jSONObject = new JSONObject(getFileContent(this.mContext, str3, false));
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("class");
                String optString = jSONObject.optString("jsapi");
                if (optString == null || optString.length() == 0) {
                    str2 = optString;
                } else {
                    str2 = str + File.separator + optString;
                }
                String str4 = null;
                if (!(str2 == null || str2.length() == 0)) {
                    try {
                        str4 = getFileContent(this.mContext, str2, false);
                    } catch (IOException e2) {
                        Log.w(TAG, "Failed to read the file ".concat(String.valueOf(str2)));
                        AppMethodBeat.o(155309);
                        return;
                    }
                }
                if (!(string == null || string2 == null)) {
                    Log.i(TAG, "createExternalExtension: name: " + string + " className: " + string2);
                    createExternalExtension(string, string2, str4, this);
                }
                AppMethodBeat.o(155309);
            } catch (JSONException e3) {
                Log.w(TAG, "Failed to parse json file: ".concat(String.valueOf(str3)));
                AppMethodBeat.o(155309);
            }
        } catch (IOException e4) {
            Log.w(TAG, "Failed to read json file: ".concat(String.valueOf(str3)));
            AppMethodBeat.o(155309);
        }
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void postMessage(XWalkExternalExtension xWalkExternalExtension, int i2, String str) {
        AppMethodBeat.i(155310);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postMessage(i2, str);
        }
        AppMethodBeat.o(155310);
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void postBinaryMessage(XWalkExternalExtension xWalkExternalExtension, int i2, byte[] bArr) {
        AppMethodBeat.i(155311);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.postBinaryMessage(i2, bArr);
        }
        AppMethodBeat.o(155311);
    }

    @Override // org.xwalk.core.extension.XWalkExtensionContextClient
    public void broadcastMessage(XWalkExternalExtension xWalkExternalExtension, String str) {
        AppMethodBeat.i(155312);
        XWalkExternalExtensionBridge xWalkExternalExtensionBridge = this.mExtensions.get(xWalkExternalExtension.getExtensionName());
        if (xWalkExternalExtensionBridge != null) {
            xWalkExternalExtensionBridge.broadcastMessage(str);
        }
        AppMethodBeat.o(155312);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onStart() {
        AppMethodBeat.i(155313);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onStart();
        }
        AppMethodBeat.o(155313);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onResume() {
        AppMethodBeat.i(155314);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onResume();
        }
        AppMethodBeat.o(155314);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onPause() {
        AppMethodBeat.i(155315);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onPause();
        }
        AppMethodBeat.o(155315);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onStop() {
        AppMethodBeat.i(155316);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onStop();
        }
        AppMethodBeat.o(155316);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onDestroy() {
        AppMethodBeat.i(155317);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onDestroy();
        }
        this.mExtensions.clear();
        AppMethodBeat.o(155317);
    }

    @Override // org.xwalk.core.XWalkExternalExtensionManager
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(155318);
        for (XWalkExternalExtensionBridge xWalkExternalExtensionBridge : this.mExtensions.values()) {
            xWalkExternalExtensionBridge.onNewIntent(intent);
        }
        AppMethodBeat.o(155318);
    }

    public void setAllowExternalExtensions(boolean z) {
        this.mLoadExternalExtensions = z;
    }

    private String getFileContent(Context context, String str, boolean z) {
        AppMethodBeat.i(155319);
        InputStream inputStream = null;
        if (z) {
            try {
                Resources resources = context.getResources();
                String str2 = new File(str).getName().split("\\.")[0];
                int identifier = resources.getIdentifier(str2, ShareConstants.DEXMODE_RAW, context.getPackageName());
                if (identifier > 0) {
                    try {
                        inputStream = resources.openRawResource(identifier);
                    } catch (Resources.NotFoundException e2) {
                        Log.w(TAG, "Inputstream failed to open for R.raw." + str2 + ", try to find it in assets");
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    inputStream.close();
                }
                AppMethodBeat.o(155319);
                throw th;
            }
        }
        if (inputStream == null) {
            inputStream = context.getAssets().open(str);
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        String str3 = new String(bArr);
        if (inputStream != null) {
            inputStream.close();
        }
        AppMethodBeat.o(155319);
        return str3;
    }

    private void createExternalExtension(String str, String str2, String str3, XWalkExtensionContextClient xWalkExtensionContextClient) {
        AppMethodBeat.i(155320);
        try {
            xWalkExtensionContextClient.getContext().getClassLoader().loadClass(str2).getConstructor(String.class, String.class, XWalkExtensionContextClient.class).newInstance(str, str3, this);
            AppMethodBeat.o(155320);
        } catch (ClassNotFoundException e2) {
            handleException(e2);
            AppMethodBeat.o(155320);
        } catch (IllegalAccessException e3) {
            handleException(e3);
            AppMethodBeat.o(155320);
        } catch (InstantiationException e4) {
            handleException(e4);
            AppMethodBeat.o(155320);
        } catch (InvocationTargetException e5) {
            handleException(e5);
            AppMethodBeat.o(155320);
        } catch (NoSuchMethodException e6) {
            handleException(e6);
            AppMethodBeat.o(155320);
        }
    }

    private void loadNativeExtensions() {
        AppMethodBeat.i(155321);
        String str = null;
        try {
            str = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 0).nativeLibraryDir;
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (str != null && new File(str).isDirectory()) {
            this.mNativeExtensionLoader.registerNativeExtensionsInPath(str);
        }
        AppMethodBeat.o(155321);
    }

    private static void handleException(Exception exc) {
        AppMethodBeat.i(155322);
        Log.e(TAG, "Error in calling methods of external extensions. " + exc.toString());
        AppMethodBeat.o(155322);
    }
}
