package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class q {
    public static String k(String str, boolean z) {
        try {
            String k = s.k(str, z);
            if (k == null) {
                return str;
            }
            Log.i("MicroMsg.VFSFileOpEx", "exportExternalPath:%s to realPath:%s", str, k);
            return k;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.VFSFileOpEx", th, "exportExternalPath failed", new Object[0]);
            return str;
        }
    }
}
