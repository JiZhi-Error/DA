package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.protocal.protobuf.cmx;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0011\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/platformtools/MediaExportLogic;", "", "()V", "MaxCacheSize", "", "TAG", "", "cacheMap", "Lcom/tencent/mm/memory/cache/DefaultResource;", "Lcom/tencent/mm/protocal/protobuf/MediaExportInfo;", "cachePath", "getExportUUID", "md5", "readFromCache", "", "saveExportUUID", "uuid", "saveToCache", "plugin-comm_release"})
public final class v {
    private static final String TAG = TAG;
    private static final String cachePath = (b.aKB() + "media_export.proto");
    private static final c<String, cmy> jNx = new c<>(500);
    public static final v jNy = new v();

    static {
        AppMethodBeat.i(169179);
        blJ();
        AppMethodBeat.o(169179);
    }

    private v() {
    }

    private static void blJ() {
        boolean z = true;
        AppMethodBeat.i(169175);
        Log.i(TAG, "readFromCache");
        byte[] aW = s.aW(cachePath, 0, -1);
        jNx.clear();
        if (aW != null) {
            if (aW.length == 0) {
                z = false;
            }
            if (z) {
                try {
                    cmx cmx = new cmx();
                    cmx.parseFrom(aW);
                    LinkedList<cmy> linkedList = cmx.Msv;
                    p.g(linkedList, "cache.exportInfoList");
                    for (T t : linkedList) {
                        jNx.put(t.md5, t);
                    }
                    AppMethodBeat.o(169175);
                    return;
                } catch (Exception e2) {
                    Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    s.deleteFile(cachePath);
                }
            }
        }
        AppMethodBeat.o(169175);
    }

    private static void blK() {
        AppMethodBeat.i(169176);
        Map<String, cmy> snapshot = jNx.snapshot();
        Log.i(TAG, "saveToCache " + snapshot.size());
        cmx cmx = new cmx();
        p.g(snapshot, "snapShot");
        for (Map.Entry<String, cmy> entry : snapshot.entrySet()) {
            cmx.Msv.add(entry.getValue());
        }
        try {
            s.C(cachePath, cmx.toByteArray());
            AppMethodBeat.o(169176);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(169176);
        }
    }

    public static void bR(String str, String str2) {
        AppMethodBeat.i(169177);
        if (!(str == null || str2 == null)) {
            cmy cmy = new cmy();
            cmy.md5 = str;
            cmy.uuid = str2;
            jNx.put(str, cmy);
            blK();
        }
        Log.i(TAG, "saveExportUUID " + str + ", " + str2);
        AppMethodBeat.o(169177);
    }

    public static String Ss(String str) {
        String str2;
        AppMethodBeat.i(169178);
        if (str == null) {
            AppMethodBeat.o(169178);
            return null;
        }
        cmy cmy = jNx.get(str);
        if (cmy != null) {
            str2 = cmy.uuid;
        } else {
            str2 = null;
        }
        blK();
        Log.i(TAG, "getExportUUID " + str + ", " + str2);
        AppMethodBeat.o(169178);
        return str2;
    }
}
