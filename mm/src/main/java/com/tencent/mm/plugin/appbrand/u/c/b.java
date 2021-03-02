package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.plugin.appbrand.u.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;

public final class b extends d {
    private o nkh = null;

    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 7;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.d
    public final String b(i iVar, c cVar) {
        AppMethodBeat.i(147393);
        s sVar = cVar.cAJ;
        if (this.nkh == null) {
            AppBrandRuntime runtime = sVar.getRuntime();
            if (sVar.getRuntime().getFileSystem() instanceof v) {
                LinkedList<q> linkedList = ((v) runtime.getFileSystem()).kTe;
                int i2 = 0;
                while (true) {
                    if (i2 >= linkedList.size()) {
                        break;
                    }
                    q qVar = linkedList.get(i2);
                    if (qVar instanceof o) {
                        this.nkh = (o) qVar;
                        break;
                    }
                    i2++;
                }
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("getFlattenFileSystem not LuggageFileSystemRegistry");
                AppMethodBeat.o(147393);
                throw illegalStateException;
            }
        }
        o oVar = this.nkh;
        String str = null;
        if (oVar != null) {
            str = oVar.Wh(iVar.optString("path"));
        } else {
            Log.e("MicroMsg.GetFullPathOfFlatFSSync", "getFlattenFileSystem null");
        }
        Log.d("MicroMsg.GetFullPathOfFlatFSSync", "path:%s fullPath:%s", iVar.optString("path"), str);
        HashMap hashMap = new HashMap();
        hashMap.put("fullPath", str);
        String Y = cVar.Y(hashMap);
        AppMethodBeat.o(147393);
        return Y;
    }
}
