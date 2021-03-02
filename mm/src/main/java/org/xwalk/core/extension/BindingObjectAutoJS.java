package org.xwalk.core.extension;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class BindingObjectAutoJS extends BindingObject {
    @Override // org.xwalk.core.extension.BindingObject
    public Object handleMessage(MessageInfo messageInfo) {
        AppMethodBeat.i(155185);
        Object obj = null;
        try {
            obj = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName()).handleMessage(messageInfo, this);
        } catch (Exception e2) {
            Log.e("BindingObjectAutoJs", e2.toString());
        }
        AppMethodBeat.o(155185);
        return obj;
    }

    public JsContextInfo getJsContextInfo() {
        AppMethodBeat.i(155186);
        JsContextInfo jsContextInfo = new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
        AppMethodBeat.o(155186);
        return jsContextInfo;
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, String str, Object... objArr) {
        JSONArray jSONArray;
        AppMethodBeat.i(155187);
        Object[] objArr2 = objArr;
        if (objArr2.length != 1 || !(objArr2[0] instanceof JSONArray)) {
            jSONArray = (JSONArray) ReflectionHelper.toSerializableObject(objArr);
        } else {
            jSONArray = (JSONArray) objArr2[0];
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "invokeCallback");
            jSONObject.put("callbackId", str);
            jSONObject.put("args", jSONArray);
            jsContextInfo.postMessage(jSONObject);
            AppMethodBeat.o(155187);
        } catch (Exception e2) {
            AppMethodBeat.o(155187);
        }
    }

    public void invokeJsCallback(String str, Object... objArr) {
        AppMethodBeat.i(155188);
        invokeJsCallback(getJsContextInfo(), str, objArr);
        AppMethodBeat.o(155188);
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, byte[] bArr) {
        AppMethodBeat.i(155189);
        jsContextInfo.postMessage(bArr);
        AppMethodBeat.o(155189);
    }

    public void invokeJsCallback(byte[] bArr) {
        AppMethodBeat.i(155190);
        getJsContextInfo().postMessage(bArr);
        AppMethodBeat.o(155190);
    }

    public static void dispatchEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        AppMethodBeat.i(155191);
        if (!jsContextInfo.getTargetReflect().isEventSupported(str)) {
            Log.w(jsContextInfo.getTag(), "Unsupport event in extension: ".concat(String.valueOf(str)));
            AppMethodBeat.o(155191);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "dispatchEvent");
            jSONObject.put("constructorName", jsContextInfo.getConstructorName());
            jSONObject.put("objectId", jsContextInfo.getObjectId());
            jSONObject.put("type", str);
            jSONObject.put("event", ReflectionHelper.toSerializableObject(obj));
            jsContextInfo.postMessage(jSONObject);
            AppMethodBeat.o(155191);
        } catch (Exception e2) {
            AppMethodBeat.o(155191);
        }
    }

    public void dispatchEvent(String str, Object obj) {
        AppMethodBeat.i(155192);
        dispatchEvent(getJsContextInfo(), str, obj);
        AppMethodBeat.o(155192);
    }

    public static void sendEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        AppMethodBeat.i(155193);
        jsContextInfo.getExtensionClient().sendEvent(str, obj);
        AppMethodBeat.o(155193);
    }

    public void sendEvent(String str, Object obj) {
        AppMethodBeat.i(155194);
        sendEvent(getJsContextInfo(), str, obj);
        AppMethodBeat.o(155194);
    }

    public static void updateProperty(JsContextInfo jsContextInfo, String str) {
        AppMethodBeat.i(155195);
        ReflectionHelper targetReflect = jsContextInfo.getTargetReflect();
        if (!targetReflect.hasProperty(str).booleanValue()) {
            Log.w(jsContextInfo.getTag(), "Unexposed property in extension: ".concat(String.valueOf(str)));
            AppMethodBeat.o(155195);
            return;
        }
        boolean z = targetReflect.getMemberInfo(str).isStatic;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "updateProperty");
            jSONObject.put("objectId", z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : jsContextInfo.getObjectId());
            jSONObject.put("constructorName", jsContextInfo.getConstructorName());
            jSONObject.put("name", str);
            jsContextInfo.postMessage(jSONObject);
            AppMethodBeat.o(155195);
        } catch (Exception e2) {
            AppMethodBeat.o(155195);
        }
    }

    public void updateProperty(String str) {
        AppMethodBeat.i(155196);
        updateProperty(getJsContextInfo(), str);
        AppMethodBeat.o(155196);
    }
}
