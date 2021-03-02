package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class JsContextInfo {
    private int extInstanceId;
    private XWalkExternalExtension extensionClient;
    private String objectId;
    private Class<?> targetClass;

    JsContextInfo(int i2, XWalkExternalExtension xWalkExternalExtension, Class<?> cls, String str) {
        this.extensionClient = xWalkExternalExtension;
        this.extInstanceId = i2;
        this.objectId = str;
        this.targetClass = cls;
    }

    public String getTag() {
        AppMethodBeat.i(155221);
        String str = "Extension-" + this.extensionClient.getExtensionName();
        AppMethodBeat.o(155221);
        return str;
    }

    public ReflectionHelper getTargetReflect() {
        AppMethodBeat.i(155222);
        ReflectionHelper targetReflect = this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
        AppMethodBeat.o(155222);
        return targetReflect;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public XWalkExternalExtension getExtensionClient() {
        return this.extensionClient;
    }

    public String getConstructorName() {
        AppMethodBeat.i(155223);
        String simpleName = this.targetClass.getSimpleName();
        AppMethodBeat.o(155223);
        return simpleName;
    }

    public void postMessage(JSONObject jSONObject) {
        AppMethodBeat.i(155224);
        this.extensionClient.postMessage(this.extInstanceId, jSONObject.toString());
        AppMethodBeat.o(155224);
    }

    public void postMessage(byte[] bArr) {
        AppMethodBeat.i(155225);
        this.extensionClient.postBinaryMessage(this.extInstanceId, bArr);
        AppMethodBeat.o(155225);
    }
}
