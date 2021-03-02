package com.tencent.mm.plugin.webview.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0007J\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCache;", "", "()V", "TAG", "", "jsapiWebComptMap", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "addJSAPIWebCompt", "", "url", "webCompts", "getJSAPIWebComptList", "list", "Lorg/json/JSONArray;", "getUrlKey", "webview-sdk_release"})
public final class f {
    private static Map<String, LinkedList<cel>> JEF = new ConcurrentHashMap();
    public static final f JEG = new f();

    static {
        AppMethodBeat.i(225215);
        AppMethodBeat.o(225215);
    }

    private f() {
    }

    public static final void g(String str, LinkedList<cel> linkedList) {
        AppMethodBeat.i(225212);
        p.h(str, "url");
        if (linkedList != null) {
            String ahz = ahz(str);
            Log.i("MicroMsg.WebComptCache", "addJSAPIWebCompt " + linkedList.size());
            if (ahz != null) {
                JEF.put(ahz, linkedList);
            }
            AppMethodBeat.o(225212);
            return;
        }
        AppMethodBeat.o(225212);
    }

    public static LinkedList<cel> c(String str, JSONArray jSONArray) {
        AppMethodBeat.i(225213);
        p.h(str, "url");
        p.h(jSONArray, "list");
        String ahz = ahz(str);
        LinkedList<cel> linkedList = new LinkedList<>();
        LinkedList<cel> linkedList2 = JEF.get(ahz);
        if (linkedList2 != null) {
            for (T t : linkedList2) {
                int length = jSONArray.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (Util.isEqual((String) jSONArray.get(i2), t.name)) {
                        linkedList.add(t);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        AppMethodBeat.o(225213);
        return linkedList;
    }

    private static String ahz(String str) {
        AppMethodBeat.i(225214);
        if (!((b) g.af(b.class)).isMpUrl(str)) {
            AppMethodBeat.o(225214);
            return str;
        }
        String ahz = ((b) g.af(b.class)).ahz(str);
        AppMethodBeat.o(225214);
        return ahz;
    }
}
