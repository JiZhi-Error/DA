package com.tencent.mm.plugin.mmsight.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.plugin.mmsight.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;

public final class n implements w {
    @Override // com.tencent.mm.modelvideo.w
    public final void Qk(String str) {
        boolean z;
        AppMethodBeat.i(89443);
        final s Qq = o.bhj().Qq(str);
        if (Qq == null) {
            AppMethodBeat.o(89443);
            return;
        }
        o.bhj();
        final String Qw = t.Qw(str);
        cly cly = Qq.jsx;
        VideoTransPara bba = e.baZ().bba();
        if (cly != null) {
            Log.i("MicroMsg.MMSightVideoMsgSendCallback", "beforeVideoSend count %d filename %s filePath %s", Integer.valueOf(cly.vUh), str, Qw);
            if (cly.vUh > 1) {
                u.QE(str);
                AppMethodBeat.o(89443);
                return;
            }
        }
        boolean a2 = m.a(Qw, bba, cly, new e() {
            /* class com.tencent.mm.plugin.mmsight.model.n.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.mmsight.model.e
            public final boolean ehT() {
                AppMethodBeat.i(89441);
                Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile1 %s", Qw);
                Qq.iKP = t.Qy(Qw);
                Qq.cSx = 32;
                o.bhj().c(Qq);
                AppMethodBeat.o(89441);
                return true;
            }
        });
        if (cly != null) {
            Log.i("MicroMsg.MMSightVideoMsgSendCallback", "filename: %s need ret: %s", str, Boolean.valueOf(a2));
            if (!a2) {
                z = true;
            } else {
                z = false;
            }
            cly.Mrq = z;
            Qq.jsx = cly;
            Qq.cSx = 536870912;
            o.bhj().c(Qq);
        }
        if (a2) {
            if (cly != null) {
                cly.vUh++;
                Qq.jsx = cly;
            }
            Qq.cSx = 536870912;
            o.bhj().c(Qq);
            c.QE(Qq.jso);
            if (m.b(Qw, bba, cly, new e() {
                /* class com.tencent.mm.plugin.mmsight.model.n.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.mmsight.model.e
                public final boolean ehT() {
                    AppMethodBeat.i(89442);
                    c.QF(Qq.jso);
                    Log.i("MicroMsg.MMSightVideoMsgSendCallback", "iUpdateVideoFile2 %s", Qw);
                    Qq.iKP = t.Qy(Qw);
                    Qq.cSx = 32;
                    o.bhj().c(Qq);
                    AppMethodBeat.o(89442);
                    return true;
                }
            }) < 0) {
                Log.i("MicroMsg.MMSightRecorderIDKeyStat", "mark720CapturePostCompressFailed");
                h.INSTANCE.idkeyStat(440, 45, 1, false);
                u.QE(str);
                AppMethodBeat.o(89443);
                return;
            } else if (cly != null) {
                cly.Mrq = true;
                Qq.jsx = cly;
                Qq.cSx = 536870912;
                o.bhj().c(Qq);
            }
        }
        AppMethodBeat.o(89443);
    }
}
