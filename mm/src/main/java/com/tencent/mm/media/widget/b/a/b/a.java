package com.tencent.mm.media.widget.b.a.b;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u00020&H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\u001b¨\u0006*"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/result/WCCameraEffectResultTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_VALUETYPE", "getKEY_VALUETYPE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "parentKey", "getParentKey", "setParentKey", "(Ljava/lang/String;)V", "stream", "getStream", "setStream", "valueType", "getValueType", "setValueType", "vendorTag", "getVendorTag", "setVendorTag", "initEffectResultTag", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "parseData", "plugin-mediaeditor_release"})
public final class a {
    private final String TAG = "MicroMsg.WCCameraEffectResultTag";
    private final String ioC = "cameraId";
    private final String ioD = "parentKey";
    private final String ioF = "vendorTag";
    private final String ioH = "stream";
    public String ioJ;
    public Integer ioK;
    public String ioN;
    public Integer ioO;
    private final String ipe = "valueType";
    public String ipf;

    public final void t(JSONObject jSONObject) {
        AppMethodBeat.i(94205);
        if (jSONObject == null) {
            AppMethodBeat.o(94205);
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        p.g(keys, "params.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            if (p.j(next, this.ioC)) {
                this.ioK = Integer.valueOf(jSONObject.optInt(next));
            } else if (p.j(next, this.ioD)) {
                this.ioJ = jSONObject.optString(next);
            } else if (p.j(next, this.ioF)) {
                this.ioN = jSONObject.optString(next);
            } else if (p.j(next, this.ioH)) {
                this.ioO = Integer.valueOf(jSONObject.optInt(next));
            } else if (p.j(next, this.ipe)) {
                this.ipf = jSONObject.optString(next);
            }
        }
        AppMethodBeat.o(94205);
    }
}
