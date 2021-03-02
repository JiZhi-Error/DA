package com.tencent.mm.plugin.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a extends y implements b {
    private static a qmi;

    private a() {
        super(f.class);
    }

    public static synchronized a cxS() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(151474);
            if (qmi == null) {
                qmi = new a();
            }
            aVar = qmi;
            AppMethodBeat.o(151474);
        }
        return aVar;
    }

    @Override // com.tencent.mm.plugin.auth.a.b
    public final void a(j.h hVar, j.i iVar, boolean z) {
    }

    @Override // com.tencent.mm.plugin.auth.a.b
    public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(151475);
        if (bVar.KAj.rBx != 0) {
            final tc tcVar = bVar.KAj.KQK;
            final tc tcVar2 = bVar.KAj.KQL;
            final tc tcVar3 = bVar.KAj.KQM;
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.g.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(151473);
                    f.a aVar = new f.a();
                    long j2 = -1;
                    com.tencent.mm.an.f.baN();
                    if (!(com.tencent.mm.an.f.baP() == null || tcVar == null)) {
                        com.tencent.mm.an.f.baN();
                        com.tencent.mm.an.f.baP().a(tcVar, tcVar2, tcVar3);
                        j2 = aVar.apr();
                    }
                    Log.d("MicroMsg.PinCdnTransport", "dkrsa setautoauthtick [%d %d]", Long.valueOf(aVar.apr()), Long.valueOf(j2));
                    AppMethodBeat.o(151473);
                }
            });
        }
        AppMethodBeat.o(151475);
    }
}
