package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

@Deprecated
public final class l extends k.b {
    private cqm jgp = new cqm();

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10) {
        super(1);
        AppMethodBeat.i(43058);
        this.jgp.Mwf = 2048;
        this.jgp.Lqk = new dqi().bhy(Util.nullAsNil(str));
        this.jgp.Mjj = new dqi().bhy(Util.nullAsNil(str2));
        this.jgp.KDZ = 0;
        this.jgp.Mwg = new dqi().bhy(Util.nullAsNil(str3));
        this.jgp.Mwh = new dqi().bhy(Util.nullAsNil(str4));
        this.jgp.oTW = 0;
        byte[] aW = s.aW(Util.nullAsNil(str5), 0, -1);
        this.jgp.Mwd = new b(aW == null ? new byte[0] : aW);
        this.jgp.Mwc = aW == null ? 0 : aW.length;
        this.jgp.kdY = 0;
        this.jgp.kec = 0;
        this.jgp.keb = Util.nullAsNil(str6);
        this.jgp.kea = Util.nullAsNil(str7);
        this.jgp.kdZ = Util.nullAsNil(str8);
        this.jgp.KEc = i2;
        this.jgp.MmM = Util.nullAsNil(str9);
        this.jgp.Mwm = 0;
        this.jgp.ked = Util.nullAsNil(str10);
        this.jgp.MmO = 0;
        this.jgp.MmN = "";
        this.zqv = this.jgp;
        AppMethodBeat.o(43058);
    }
}
