package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    public boolean dJM;
    public String userName;

    public d(String str, boolean z) {
        super(new SnsInfo());
        AppMethodBeat.i(99846);
        this.userName = str;
        this.dJM = z;
        hdm();
        AppMethodBeat.o(99846);
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.a, com.tencent.mm.vending.a.b
    public final Cursor fki() {
        boolean z;
        AppMethodBeat.i(99847);
        init();
        g.aAi();
        if (this.userName.equals((String) g.aAh().azQ().get(2, (Object) null))) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
        Cursor g2 = aj.faO().g(this.userName, z, fkf());
        AppMethodBeat.o(99847);
        return g2;
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String L(long j2, String str) {
        AppMethodBeat.i(179326);
        Log.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", Integer.valueOf(aj.faE().fbw()), str);
        String Jc = r.Jc(aj.faO().b(j2, aj.faE().aPn(this.userName), this.userName, this.dJM));
        if (!this.EvF.equals("") && Jc.compareTo(this.EvF) >= 0) {
            Jc = this.EvF;
        }
        ami feM = aj.faS().aQr(this.userName).feM();
        if (feM.Lvc == 0) {
            AppMethodBeat.o(179326);
            return Jc;
        }
        String Jc2 = r.Jc(feM.Lvc);
        if (Jc.equals("")) {
            AppMethodBeat.o(179326);
            return Jc2;
        } else if (Jc2.compareTo(Jc) > 0) {
            AppMethodBeat.o(179326);
            return Jc2;
        } else {
            AppMethodBeat.o(179326);
            return Jc;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.a.b.b
    public final String JV(long j2) {
        return null;
    }
}
