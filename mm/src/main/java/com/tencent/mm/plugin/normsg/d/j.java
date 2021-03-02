package com.tencent.mm.plugin.normsg.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.normsg.b.a;
import com.tencent.mm.plugin.normsg.b.b;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alu;
import com.tencent.mm.protocal.r;
import com.tencent.mm.protocal.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class j implements i {
    public final void eyq() {
        AppMethodBeat.i(149106);
        g.azz().a(3644, this);
        g.azz().a(3789, this);
        g.azz().a(836, this);
        g.azz().a(3944, this);
        AppMethodBeat.o(149106);
    }

    public final void eyr() {
        AppMethodBeat.i(149107);
        g.azz().b(3644, this);
        g.azz().b(3789, this);
        g.azz().b(836, this);
        g.azz().b(3944, this);
        AppMethodBeat.o(149107);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        als als;
        AppMethodBeat.i(149108);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(qVar == null ? -1 : qVar.getType());
        Log.i("TrustRequestManager", String.format("onSceneEnd: errType = %s errCode = %s errMsg =  %s reqType = %s", objArr));
        if (i2 == 0 && i3 == 0) {
            if (qVar.getType() == 3644 || qVar.getType() == 3789) {
                alu alu = ((s.c) ((b) qVar).getReqResp().getRespObj()).KAb;
                if (!(alu == null || alu.Luw == null)) {
                    byte[] byteArray = alu.Luw.toByteArray();
                    Log.d("TrustRequestManager", "[debug] onScene end type:[init] dlen:[%d]", Integer.valueOf(byteArray.length));
                    d.INSTANCE.K(byteArray, 1, i3);
                }
            } else if (!((qVar.getType() != 836 && qVar.getType() != 3944) || (als = ((r.c) ((a) qVar).getReqResp().getRespObj()).KzX) == null || als.Luw == null)) {
                byte[] byteArray2 = als.Luw.toByteArray();
                Log.d("TrustRequestManager", "[debug] onScene end type:[refesh] dlen:[%d]", Integer.valueOf(byteArray2.length));
                d.INSTANCE.K(byteArray2, 2, i3);
            }
        }
        if (i3 != 0) {
            d.INSTANCE.K(null, 0, i3);
        }
        eyr();
        AppMethodBeat.o(149108);
    }
}
