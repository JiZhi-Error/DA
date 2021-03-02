package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\u0010\u000bJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "(Lcom/tencent/mm/vfs/VFSFile;)V", "name", "", "lastModified", "", "subMetas", "", "(Ljava/lang/String;JLjava/util/List;)V", "getSubMetas", "()Ljava/util/List;", "toJson", "Lorg/json/JSONObject;", "Companion", "luggage-xweb-ext_release"})
public final class g extends h {
    public static final a mJU = new a((byte) 0);
    final List<h> mJT;

    static {
        AppMethodBeat.i(216001);
        AppMethodBeat.o(216001);
    }

    public /* synthetic */ g(String str, long j2, List list, byte b2) {
        this(str, j2, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.tencent.mm.plugin.appbrand.jsapi.ag.c.h> */
    /* JADX WARN: Multi-variable type inference failed */
    private g(String str, long j2, List<? extends h> list) {
        super(str, j2);
        this.mJT = list;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/DirMetaData;", "unzipDir", "Lcom/tencent/mm/vfs/VFSFile;", "fromJson", "json", "Lorg/json/JSONObject;", "luggage-xweb-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g G(o oVar) {
            AppMethodBeat.i(215997);
            p.h(oVar, "unzipDir");
            if (oVar.isDirectory()) {
                g gVar = new g(oVar);
                AppMethodBeat.o(215997);
                return gVar;
            }
            AppMethodBeat.o(215997);
            return null;
        }

        public static g ai(JSONObject jSONObject) {
            g gVar;
            AppMethodBeat.i(215998);
            p.h(jSONObject, "json");
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("subMetas");
                f mY = j.mY(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
                Iterator it = mY.iterator();
                while (it.hasNext()) {
                    arrayList.add(jSONArray.getJSONObject(((ab) it).nextInt()));
                }
                ArrayList<JSONObject> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
                for (JSONObject jSONObject2 : arrayList2) {
                    h.a aVar = h.mJV;
                    p.g(jSONObject2, LocaleUtil.ITALIAN);
                    h aj = h.a.aj(jSONObject2);
                    if (aj == null) {
                        p.hyc();
                    }
                    arrayList3.add(aj);
                }
                String string = jSONObject.getString("name");
                long j2 = jSONObject.getLong("lastModified");
                p.g(string, "name");
                gVar = new g(string, j2, arrayList3, (byte) 0);
            } catch (Exception e2) {
                Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#fromJsonFile, fail since ".concat(String.valueOf(e2)));
                gVar = null;
            }
            AppMethodBeat.o(215998);
            return gVar;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(com.tencent.mm.vfs.o r10) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.c.g.<init>(com.tencent.mm.vfs.o):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.c.h
    public final JSONObject toJson() {
        JSONObject jSONObject;
        AppMethodBeat.i(215999);
        try {
            JSONObject json = super.toJson();
            if (json != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = this.mJT.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                json.put("subMetas", jSONArray);
                jSONObject = json;
            } else {
                jSONObject = null;
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "DirMetaData#toJson, fail since ".concat(String.valueOf(e2)));
            jSONObject = null;
        }
        AppMethodBeat.o(215999);
        return jSONObject;
    }
}
