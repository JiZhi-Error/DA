package com.tencent.xweb.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p;
import org.xwalk.core.Log;

public class BSpatch {
    public native int nativeDoPatch(String str, String str2, String str3);

    public static int bv(String str, String str2, String str3) {
        AppMethodBeat.i(156987);
        Log.i("BSpatch", "doPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        h.hut();
        boolean z = false;
        if (str.equals(str3)) {
            str3 = str + ".temp";
            z = true;
        }
        int nativeDoPatch = new BSpatch().nativeDoPatch(str, str2, str3);
        if (nativeDoPatch < 0) {
            Log.i("BSpatch", "doPatch failed");
            h.huu();
        } else {
            Log.i("BSpatch", "doPatch successful");
            if (z) {
                if (!c.copyFile(str3, str)) {
                    Log.e("BSpatch", "doPatch same path, copy failed");
                    AppMethodBeat.o(156987);
                    return -1;
                }
                c.deleteFile(str3);
            }
            h.OX(System.currentTimeMillis() - currentTimeMillis);
        }
        AppMethodBeat.o(156987);
        return nativeDoPatch;
    }

    static {
        AppMethodBeat.i(156988);
        BSpatch.class.getClassLoader();
        if (p.SzF != null) {
            p.SzF.Ed("bspatch_utils");
            AppMethodBeat.o(156988);
            return;
        }
        System.loadLibrary("bspatch_utils");
        AppMethodBeat.o(156988);
    }
}
