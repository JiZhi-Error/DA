package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0012\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "(Ljava/lang/String;J)V", "getLastModified", "()J", "getName", "()Ljava/lang/String;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"})
public class h {
    public static final a mJV = new a((byte) 0);
    final long kSb;
    final String name;

    static {
        AppMethodBeat.i(216007);
        AppMethodBeat.o(216007);
    }

    public h(String str, long j2) {
        p.h(str, "name");
        AppMethodBeat.i(216005);
        this.name = str;
        this.kSb = j2;
        AppMethodBeat.o(216005);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipFile", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "fromJsonFile", "luggage-xweb-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h aj(JSONObject jSONObject) {
            AppMethodBeat.i(216002);
            p.h(jSONObject, "json");
            if (jSONObject.has("subMetas")) {
                g.a aVar = g.mJU;
                g ai = g.a.ai(jSONObject);
                AppMethodBeat.o(216002);
                return ai;
            }
            h ak = ak(jSONObject);
            AppMethodBeat.o(216002);
            return ak;
        }

        private static h ak(JSONObject jSONObject) {
            h hVar;
            AppMethodBeat.i(216003);
            try {
                String string = jSONObject.getString("name");
                long j2 = jSONObject.getLong("lastModified");
                p.g(string, "name");
                hVar = new h(string, j2);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#fromJsonFile, fail since ".concat(String.valueOf(e2)));
                hVar = null;
            }
            AppMethodBeat.o(216003);
            return hVar;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(com.tencent.mm.vfs.o r6) {
        /*
            r5 = this;
            r4 = 216006(0x34bc6, float:3.02689E-40)
            java.lang.String r0 = "unzipFile"
            kotlin.g.b.p.h(r6, r0)
            java.lang.String r0 = r6.getName()
            java.lang.String r1 = "unzipFile.name"
            kotlin.g.b.p.g(r0, r1)
            long r2 = r6.lastModified()
            r5.<init>(r0, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.h.<init>(com.tencent.mm.vfs.o):void");
    }

    public JSONObject toJson() {
        JSONObject jSONObject;
        AppMethodBeat.i(216004);
        try {
            jSONObject = new JSONObject();
            jSONObject.put("name", this.name);
            jSONObject.put("lastModified", this.kSb);
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "FileMetaData#toJson, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(216004);
        return jSONObject;
    }
}
