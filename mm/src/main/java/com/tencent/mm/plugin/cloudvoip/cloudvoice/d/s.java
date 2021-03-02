package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.blk;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* access modifiers changed from: package-private */
public final class s {
    final Map<String, r> qva = new ConcurrentHashMap(1);

    public interface a {
        void a(int i2, int i3, String str, r rVar, boolean z);
    }

    static /* synthetic */ void a(s sVar, int i2, int i3, String str, r rVar, boolean z, a aVar) {
        AppMethodBeat.i(90940);
        sVar.a(i2, i3, str, rVar, z, aVar);
        AppMethodBeat.o(90940);
    }

    s() {
        AppMethodBeat.i(90935);
        AppMethodBeat.o(90935);
    }

    public final void a(String str, String str2, a aVar) {
        AppMethodBeat.i(184490);
        r rVar = this.qva.get(str);
        if (rVar == null || !rVar.isValid()) {
            this.qva.remove(str);
            b(str, str2, aVar);
            AppMethodBeat.o(184490);
            return;
        }
        Log.d("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: has valid sessionKey");
        a(0, 0, "", rVar, false, aVar);
        AppMethodBeat.o(184490);
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, final int i3, final String str, final r rVar, final boolean z, final a aVar) {
        AppMethodBeat.i(90937);
        q.INSTANCE.aj(new Runnable() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(90933);
                aVar.a(i2, i3, str, rVar, z);
                AppMethodBeat.o(90933);
            }
        });
        AppMethodBeat.o(90937);
    }

    private void b(final String str, String str2, final a aVar) {
        AppMethodBeat.i(184491);
        d.a aVar2 = new d.a();
        aVar2.iLN = new blk();
        aVar2.iLO = new bll();
        aVar2.funcId = 2985;
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getcloudimsession";
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        d aXF = aVar2.aXF();
        blk blk = (blk) aXF.iLK.iLR;
        blk.dNI = str;
        blk.LUq = str2;
        IPCRunCgi.a(aXF, new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s.AnonymousClass2 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(90934);
                if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                    bll bll = (bll) dVar.iLL.iLR;
                    r rVar = new r();
                    rVar.quX = bll.KRf;
                    rVar.quZ = Util.currentTicks();
                    rVar.quY = (long) bll.LUr;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", rVar);
                    s.this.qva.put(str, rVar);
                    s.a(s.this, 0, 0, "", rVar, true, aVar);
                    AppMethodBeat.o(90934);
                    return;
                }
                Log.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + i2 + ",errCode:" + i3);
                s.a(s.this, i2, i3, str, null, false, aVar);
                AppMethodBeat.o(90934);
            }
        });
        AppMethodBeat.o(184491);
    }

    public final void akH(String str) {
        AppMethodBeat.i(90939);
        Log.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: on exit");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(90939);
            return;
        }
        this.qva.remove(str);
        AppMethodBeat.o(90939);
    }
}
