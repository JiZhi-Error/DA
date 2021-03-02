package com.tencent.mm.media.widget.b.a.c;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001e\u001a\u00020\u001f2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0018j\b\u0012\u0004\u0012\u00020\u0004`\u0019J\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0018j\b\u0012\u0004\u0012\u00020\u0004`\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/effect/sessionType/WCCameraEffectSessionType;", "", "()V", "KEY_NAME", "", "getKEY_NAME", "()Ljava/lang/String;", "KEY_SUPPORTTAG", "getKEY_SUPPORTTAG", "KEY_VALUE", "getKEY_VALUE", "TAG", "getTAG", "sessionTypeName", "getSessionTypeName", "setSessionTypeName", "(Ljava/lang/String;)V", "sessionValue", "", "getSessionValue", "()I", "setSessionValue", "(I)V", "supportTag", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSupportTag", "()Ljava/util/ArrayList;", "setSupportTag", "(Ljava/util/ArrayList;)V", "checkVendorTagSupported", "", "vendorTags", "initSessionType", "", NativeProtocol.WEB_DIALOG_PARAMS, "Lorg/json/JSONObject;", "plugin-mediaeditor_release"})
public final class a {
    private final String KEY_NAME = "name";
    private final String TAG = "MicroMsg.WCCameraEffectSessionType";
    private final String ipm = "value";
    private final String ipn = "supportTag";
    private String ipo;
    public int ipp;
    private ArrayList<String> ipq = new ArrayList<>();

    public a() {
        AppMethodBeat.i(94213);
        AppMethodBeat.o(94213);
    }

    public final void u(JSONObject jSONObject) {
        AppMethodBeat.i(94211);
        if (jSONObject == null) {
            AppMethodBeat.o(94211);
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        p.g(keys, "params.keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            if (p.j(next, this.KEY_NAME)) {
                this.ipo = jSONObject.optString(next);
            } else if (p.j(next, this.ipm)) {
                this.ipp = jSONObject.optInt(next);
            } else if (p.j(next, this.ipn)) {
                String optString = jSONObject.optString(next);
                p.g(optString, "params.optString(it)");
                List<String> a2 = n.a(optString, new String[]{","});
                ArrayList<String> arrayList = new ArrayList<>();
                String str = a2.get(0);
                switch (str.hashCode()) {
                    case 93090393:
                        if (str.equals("array")) {
                            Iterator<T> it = a2.subList(1, a2.size()).iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next());
                            }
                            break;
                        }
                        break;
                }
                this.ipq = arrayList;
            }
        }
        AppMethodBeat.o(94211);
    }

    public final boolean r(ArrayList<String> arrayList) {
        T t;
        AppMethodBeat.i(94212);
        p.h(arrayList, "vendorTags");
        Iterator<String> it = arrayList.iterator();
        boolean z = false;
        while (true) {
            if (!it.hasNext()) {
                AppMethodBeat.o(94212);
                break;
            }
            String next = it.next();
            Iterator<T> it2 = this.ipq.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (p.j(t, next)) {
                    break;
                }
            }
            if (t != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                AppMethodBeat.o(94212);
                break;
            }
        }
        return z;
    }
}
