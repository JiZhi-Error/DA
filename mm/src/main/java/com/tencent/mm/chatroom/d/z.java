package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hm;
import com.tencent.mm.g.b.a.hn;
import com.tencent.mm.g.b.a.ho;
import com.tencent.mm.model.ab;

public final class z {
    public static void a(String str, int i2, int i3, int i4, int i5, String str2, String str3) {
        AppMethodBeat.i(194037);
        int i6 = 1;
        if (ab.JO(str)) {
            i6 = 2;
        }
        ho hoVar = new ho();
        hoVar.vp(str);
        hoVar.enM = (long) i6;
        hoVar.eMc = (long) i2;
        hoVar.eLz = (long) i3;
        hoVar.ejW = (long) i4;
        hoVar.eMf = (long) i5;
        hoVar.vq(str2);
        hoVar.vr(str3);
        hoVar.bfK();
        AppMethodBeat.o(194037);
    }

    public static void a(String str, int i2, int i3, String str2, String str3) {
        AppMethodBeat.i(194038);
        int i4 = 0;
        if (ab.JO(str)) {
            i4 = 2;
        } else if (ab.JN(str)) {
            i4 = 1;
        }
        hm hmVar = new hm();
        hmVar.vj(str);
        hmVar.enM = (long) i4;
        hmVar.eLz = (long) i2;
        hmVar.erw = (long) i3;
        hmVar.aha();
        hmVar.vk(str2);
        hmVar.vl(str3);
        hmVar.bfK();
        AppMethodBeat.o(194038);
    }

    public static void a(String str, int i2, int i3, int i4, String str2, String str3) {
        AppMethodBeat.i(194039);
        int i5 = 0;
        if (ab.JO(str)) {
            i5 = 2;
        } else if (ab.JN(str)) {
            i5 = 1;
        }
        hn hnVar = new hn();
        hnVar.vm(str);
        hnVar.enM = (long) i5;
        hnVar.eLz = (long) i2;
        hnVar.ejW = (long) i3;
        hnVar.eMc = (long) i4;
        hnVar.vn(str2);
        hnVar.vo(str3);
        hnVar.bfK();
        AppMethodBeat.o(194039);
    }
}
