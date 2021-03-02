package org.xwalk.core.extension;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class XWalkExternalExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExternalExtension.class.desiredAssertionStatus());
    private Map<Integer, ExtensionInstanceHelper> instanceHelpers;
    protected String[] mEntryPoints;
    protected XWalkExtensionContextClient mExtensionContext;
    protected MessageHandler mHandler;
    protected String mJsApi;
    protected String mName;
    protected ReflectionHelper mReflection;
    protected boolean useJsStubGeneration;

    static {
        AppMethodBeat.i(155303);
        AppMethodBeat.o(155303);
    }

    public XWalkExternalExtension(String str, String str2, XWalkExtensionContextClient xWalkExtensionContextClient) {
        this(str, str2, null, xWalkExtensionContextClient);
    }

    public XWalkExternalExtension(String str, String str2, String[] strArr, XWalkExtensionContextClient xWalkExtensionContextClient) {
        AppMethodBeat.i(155290);
        if ($assertionsDisabled || xWalkExtensionContextClient != null) {
            this.mName = str;
            this.mJsApi = str2;
            this.mEntryPoints = strArr;
            this.mExtensionContext = xWalkExtensionContextClient;
            this.instanceHelpers = new HashMap();
            this.mHandler = new MessageHandler();
            if (this.mJsApi == null || this.mJsApi.length() == 0) {
                this.useJsStubGeneration = true;
                this.mReflection = new ReflectionHelper(getClass());
                this.mJsApi = new JsStubGenerator(this.mReflection).generate();
                if (this.mJsApi == null || this.mJsApi.length() == 0) {
                    Log.e("Extension-" + this.mName, "Can't generate JavaScript stub for this extension.");
                    AppMethodBeat.o(155290);
                    return;
                }
            } else {
                this.mReflection = null;
                this.useJsStubGeneration = false;
            }
            this.mExtensionContext.registerExtension(this);
            AppMethodBeat.o(155290);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(155290);
        throw assertionError;
    }

    public final String getExtensionName() {
        return this.mName;
    }

    public final String getJsApi() {
        return this.mJsApi;
    }

    public final String[] getEntryPoints() {
        return this.mEntryPoints;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public void onInstanceCreated(int i2) {
        AppMethodBeat.i(155291);
        this.instanceHelpers.put(Integer.valueOf(i2), new ExtensionInstanceHelper(this, i2));
        AppMethodBeat.o(155291);
    }

    public void onInstanceDestroyed(int i2) {
        AppMethodBeat.i(155292);
        this.instanceHelpers.remove(Integer.valueOf(i2));
        AppMethodBeat.o(155292);
    }

    public boolean isAutoJS() {
        return this.useJsStubGeneration;
    }

    public void onMessage(int i2, String str) {
        AppMethodBeat.i(155293);
        if (this.useJsStubGeneration) {
            getInstanceHelper(i2).handleMessage(str);
        }
        AppMethodBeat.o(155293);
    }

    public void onBinaryMessage(int i2, byte[] bArr) {
        AppMethodBeat.i(155294);
        if (this.useJsStubGeneration) {
            getInstanceHelper(i2).handleMessage(bArr);
        }
        AppMethodBeat.o(155294);
    }

    public String onSyncMessage(int i2, String str) {
        AppMethodBeat.i(155295);
        Object obj = null;
        if (this.useJsStubGeneration) {
            obj = getInstanceHelper(i2).handleMessage(str);
        }
        if (obj != null) {
            String objToJSON = ReflectionHelper.objToJSON(obj);
            AppMethodBeat.o(155295);
            return objToJSON;
        }
        AppMethodBeat.o(155295);
        return "";
    }

    public ReflectionHelper getReflection() {
        return this.mReflection;
    }

    public MessageHandler getMessageHandler() {
        return this.mHandler;
    }

    public ReflectionHelper getTargetReflect(String str) {
        AppMethodBeat.i(155296);
        ReflectionHelper constructorReflection = this.mReflection.getConstructorReflection(str);
        if (constructorReflection != null) {
            AppMethodBeat.o(155296);
            return constructorReflection;
        }
        ReflectionHelper reflectionHelper = this.mReflection;
        AppMethodBeat.o(155296);
        return reflectionHelper;
    }

    /* access modifiers changed from: protected */
    public ExtensionInstanceHelper getInstanceHelper(int i2) {
        AppMethodBeat.i(155297);
        ExtensionInstanceHelper extensionInstanceHelper = this.instanceHelpers.get(Integer.valueOf(i2));
        AppMethodBeat.o(155297);
        return extensionInstanceHelper;
    }

    public void sendEvent(String str, Object obj) {
        AppMethodBeat.i(155298);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "onEvent");
            jSONObject.put("type", str);
            jSONObject.put("event", ReflectionHelper.objToJSON(obj));
            broadcastMessage(jSONObject.toString());
            AppMethodBeat.o(155298);
        } catch (Exception e2) {
            AppMethodBeat.o(155298);
        }
    }

    public final void postMessage(int i2, String str) {
        AppMethodBeat.i(155299);
        this.mExtensionContext.postMessage(this, i2, str);
        AppMethodBeat.o(155299);
    }

    public final void postBinaryMessage(int i2, byte[] bArr) {
        AppMethodBeat.i(155300);
        this.mExtensionContext.postBinaryMessage(this, i2, bArr);
        AppMethodBeat.o(155300);
    }

    public final void broadcastMessage(String str) {
        AppMethodBeat.i(155301);
        this.mExtensionContext.broadcastMessage(this, str);
        AppMethodBeat.o(155301);
    }

    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        AppMethodBeat.i(155302);
        ActivityNotFoundException activityNotFoundException = new ActivityNotFoundException("This method is no longer supported");
        AppMethodBeat.o(155302);
        throw activityNotFoundException;
    }
}
