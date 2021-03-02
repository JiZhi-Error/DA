package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

final class bf extends g {
    bf() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128926);
        boolean optBoolean = jSONObject.optBoolean("recursive", false);
        FileStructStat fileStructStat = new FileStructStat();
        m a2 = fVar.getFileSystem().a(str, fileStructStat);
        switch (a2) {
            case OK:
                if (!fileStructStat.isDirectory() || !optBoolean) {
                    i.a N = new i.a("ok", new Object[0]).N(a(fileStructStat, new HashMap()));
                    AppMethodBeat.o(128926);
                    return N;
                }
                i.a g2 = g(fVar, str);
                AppMethodBeat.o(128926);
                return g2;
            case RET_NOT_EXISTS:
            case ERR_PARENT_DIR_NOT_EXISTS:
                i.a aVar = new i.a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(128926);
                return aVar;
            case ERR_PERMISSION_DENIED:
                i.a aVar2 = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128926);
                return aVar2;
            default:
                i.a aVar3 = new i.a("fail " + a2.name(), new Object[0]);
                AppMethodBeat.o(128926);
                return aVar3;
        }
    }

    private static i.a g(f fVar, String str) {
        AppMethodBeat.i(128927);
        LinkedList linkedList = new LinkedList();
        m h2 = fVar.getFileSystem().h(str, linkedList);
        switch (h2) {
            case OK:
                i.a aVar = new i.a("ok", new Object[0]);
                for (x xVar : linkedList) {
                    aVar.q(xVar.kTh, a(xVar, new HashMap()));
                }
                AppMethodBeat.o(128927);
                return aVar;
            default:
                i.a aVar2 = new i.a("fail " + h2.name(), new Object[0]);
                AppMethodBeat.o(128927);
                return aVar2;
        }
    }

    private static Map<String, Object> a(FileStructStat fileStructStat, Map<String, Object> map) {
        AppMethodBeat.i(128928);
        map.put("mode", Integer.valueOf(fileStructStat.st_mode));
        map.put("size", Long.valueOf(fileStructStat.st_size));
        map.put("lastAccessedTime", Long.valueOf(fileStructStat.st_atime));
        map.put("lastModifiedTime", Long.valueOf(fileStructStat.st_mtime));
        AppMethodBeat.o(128928);
        return map;
    }
}
