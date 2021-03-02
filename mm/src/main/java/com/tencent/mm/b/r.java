package com.tencent.mm.b;

import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class r {
    public static String a(o oVar, boolean z, String str) {
        s.nz(aa.z(oVar.mUri), str);
        if (z) {
            s.dy(aa.z(oVar.mUri), true);
        }
        return str;
    }
}
