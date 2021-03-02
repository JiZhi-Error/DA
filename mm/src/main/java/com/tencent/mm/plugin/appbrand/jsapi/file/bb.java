package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class bb extends g {
    bb() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128917);
        LinkedList<k> linkedList = new LinkedList();
        com.tencent.mm.plugin.appbrand.ac.i<List<k>> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
        m a2 = fVar.getFileSystem().a(str, iVar);
        b.c(linkedList, iVar.value);
        switch (a2) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                i.a aVar = new i.a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(128917);
                return aVar;
            case ERR_IS_FILE:
                i.a aVar2 = new i.a("fail not a directory \"%s\"", str);
                AppMethodBeat.o(128917);
                return aVar2;
            case ERR_PERMISSION_DENIED:
                i.a aVar3 = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128917);
                return aVar3;
            case ERR_SYMLINK:
                i.a aVar4 = new i.a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(128917);
                return aVar4;
            case OK:
                JSONArray jSONArray = new JSONArray();
                for (k kVar : linkedList) {
                    jSONArray.put(kVar.fileName);
                }
                i.a q = new i.a("ok", new Object[0]).q("files", jSONArray);
                AppMethodBeat.o(128917);
                return q;
            default:
                i.a aVar5 = new i.a("fail " + a2.name(), new Object[0]);
                AppMethodBeat.o(128917);
                return aVar5;
        }
    }
}
