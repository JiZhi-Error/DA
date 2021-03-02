package com.tencent.mm.media.widget.b.a.a;

import android.util.Range;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\u001fR\u001e\u0010(\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010+\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\u001f¨\u00067"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/request/WCCameraEffectRequestTag;", "", "()V", "KEY_CAMERAID", "", "getKEY_CAMERAID", "()Ljava/lang/String;", "KEY_CHILD", "getKEY_CHILD", "KEY_DEFAULTVALUE", "getKEY_DEFAULTVALUE", "KEY_PARENT", "getKEY_PARENT", "KEY_STREAM", "getKEY_STREAM", "KEY_SUPPORTVALUE", "getKEY_SUPPORTVALUE", "KEY_VENDORTAG", "getKEY_VENDORTAG", "TAG", "getTAG", "cameraId", "", "getCameraId", "()Ljava/lang/Integer;", "setCameraId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "childKey", "getChildKey", "setChildKey", "(Ljava/lang/String;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "parentKey", "getParentKey", "setParentKey", "stream", "getStream", "setStream", "supportValue", "getSupportValue", "setSupportValue", "vendorTag", "getVendorTag", "setVendorTag", "initEffectTag", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "parseData", "parseSupportValue", "plugin-mediaeditor_release"})
public final class a {
    private final String TAG = "MicroMsg.WCCameraEffectRequestTag";
    public Object aEX;
    private final String ioC = "cameraId";
    private final String ioD = "parentKey";
    private final String ioE = "childKey";
    private final String ioF = "vendorTag";
    private final String ioG = "supportValue";
    private final String ioH = "stream";
    private final String ioI = "defaultValue";
    public String ioJ;
    public Integer ioK;
    public String ioL;
    public Object ioM;
    public String ioN;
    public Integer ioO;

    /* JADX DEBUG: Multi-variable search result rejected for r1v23, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r1v25, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void s(JSONObject jSONObject) {
        Range range;
        AppMethodBeat.i(94192);
        if (jSONObject == null) {
            AppMethodBeat.o(94192);
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
            } else if (p.j(next, this.ioE)) {
                this.ioL = jSONObject.optString(next);
            } else if (p.j(next, this.ioF)) {
                this.ioN = jSONObject.optString(next);
            } else if (p.j(next, this.ioG)) {
                String optString = jSONObject.optString(next);
                p.g(optString, "params.optString(it)");
                List<String> a2 = n.a(optString, new String[]{","});
                String str = a2.get(0);
                switch (str.hashCode()) {
                    case 93090393:
                        if (str.equals("array")) {
                            Object obj = this.aEX;
                            if (!(obj instanceof Boolean)) {
                                if (!(obj instanceof String)) {
                                    if (obj instanceof Integer) {
                                        ArrayList arrayList = new ArrayList();
                                        Iterator<T> it = a2.subList(1, a2.size()).iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(Integer.valueOf(Integer.parseInt(it.next())));
                                        }
                                        range = arrayList;
                                        break;
                                    }
                                } else {
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<T> it2 = a2.subList(1, a2.size()).iterator();
                                    while (it2.hasNext()) {
                                        arrayList2.add(it2.next());
                                    }
                                    range = arrayList2;
                                    break;
                                }
                            } else {
                                ArrayList arrayList3 = new ArrayList();
                                Iterator<T> it3 = a2.subList(1, a2.size()).iterator();
                                while (it3.hasNext()) {
                                    arrayList3.add(Boolean.valueOf(Boolean.parseBoolean(it3.next())));
                                }
                                range = arrayList3;
                                break;
                            }
                        }
                        range = null;
                        break;
                    case 108280125:
                        if (str.equals("range")) {
                            range = new Range(Integer.valueOf(Integer.parseInt(a2.get(1))), Integer.valueOf(Integer.parseInt(a2.get(2))));
                            break;
                        }
                        range = null;
                        break;
                    default:
                        range = null;
                        break;
                }
                this.ioM = range;
            } else if (p.j(next, this.ioI)) {
                this.aEX = jSONObject.opt(next);
            } else if (p.j(next, this.ioH)) {
                this.ioO = Integer.valueOf(jSONObject.optInt(next));
            }
        }
        AppMethodBeat.o(94192);
    }

    public final String aPV() {
        AppMethodBeat.i(94193);
        Object obj = this.ioM;
        if (obj instanceof Range) {
            StringBuilder sb = new StringBuilder("range:");
            Object obj2 = this.ioM;
            if (obj2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
                AppMethodBeat.o(94193);
                throw tVar;
            }
            StringBuilder append = sb.append((Integer) ((Range) obj2).getLower()).append(" ~");
            Object obj3 = this.ioM;
            if (obj3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.util.Range<kotlin.Int>");
                AppMethodBeat.o(94193);
                throw tVar2;
            }
            String sb2 = append.append((Integer) ((Range) obj3).getUpper()).toString();
            AppMethodBeat.o(94193);
            return sb2;
        } else if (obj instanceof ArrayList) {
            StringBuffer stringBuffer = new StringBuffer();
            Object obj4 = this.ioM;
            if (obj4 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<*> /* = java.util.ArrayList<*> */");
                AppMethodBeat.o(94193);
                throw tVar3;
            }
            for (Object obj5 : (ArrayList) obj4) {
                stringBuffer.append(new StringBuilder().append(obj5).append((char) 12289).toString());
            }
            String str = "array:" + stringBuffer;
            AppMethodBeat.o(94193);
            return str;
        } else {
            AppMethodBeat.o(94193);
            return "";
        }
    }
}
