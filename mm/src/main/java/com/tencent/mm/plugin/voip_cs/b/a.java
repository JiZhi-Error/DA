package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.e;
import com.tencent.mm.protocal.protobuf.etc;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class a extends IListener<zg> {
    public a() {
        AppMethodBeat.i(161685);
        this.__eventId = zg.class.getName().hashCode();
        AppMethodBeat.o(161685);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(zg zgVar) {
        AppMethodBeat.i(125337);
        boolean a2 = a(zgVar);
        AppMethodBeat.o(125337);
        return a2;
    }

    private static boolean a(zg zgVar) {
        AppMethodBeat.i(125336);
        if (zgVar instanceof zg) {
            if (!g.aAc()) {
                AppMethodBeat.o(125336);
                return false;
            }
            e fMs = c.fMs();
            byte[] bArr = zgVar.efr.efs;
            if (!(bArr == null || bArr.length == 0)) {
                byte[] bArr2 = new byte[(bArr.length - 1)];
                System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                etc etc = new etc();
                try {
                    etc.parseFrom(bArr2);
                    Log.i("MicroMsg.voipcs.VoipCSService", "notify status = " + etc.NqE + ",notifySeq = " + fMs.HrF);
                    etj etj = new etj();
                    etj.NeG = etc.NeG;
                    etj.Lta = etc.Lta;
                    etj.NqC = etc.NqC;
                    etj.NqE = etc.NqE;
                    etj.NqF = etc.NqF;
                    etj.NqG = etc.NqG;
                    etj.NqD = etc.NqD;
                    fMs.a(etj);
                } catch (IOException e2) {
                    Log.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", e2);
                }
            }
        }
        AppMethodBeat.o(125336);
        return false;
    }
}
