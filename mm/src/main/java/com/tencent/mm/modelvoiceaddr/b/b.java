package com.tencent.mm.modelvoiceaddr.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements i {
    public final void a(List<String> list, final String str, final String str2) {
        AppMethodBeat.i(148649);
        final ArrayList arrayList = new ArrayList(list);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.modelvoiceaddr.b.b.AnonymousClass2 */
            final /* synthetic */ int gsA = 10;

            public final void run() {
                AppMethodBeat.i(148648);
                LinkedList linkedList = new LinkedList();
                for (String str : arrayList) {
                    linkedList.add(new dqi().bhy(str));
                    Log.d("MicroMsg.NewVoiceInputReportManager", "mVoiceIdSet Id = %s", str);
                }
                dqi bhy = new dqi().bhy(str);
                dqi bhy2 = new dqi().bhy(str2);
                g.azz().a(228, b.this);
                a aVar = new a(linkedList.size(), linkedList, bhy, bhy2);
                int i2 = this.gsA;
                if (aVar.jxM != null) {
                    aVar.jxM.Scene = i2;
                }
                g.azz().a(aVar, 0);
                AppMethodBeat.o(148648);
            }
        });
        AppMethodBeat.o(148649);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(148650);
        g.azz().b(228, this);
        if (qVar instanceof a) {
            Log.i("MicroMsg.NewVoiceInputReportManager", "onSceneEnd errType = %s, errCode = %s, errMsg = %s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        AppMethodBeat.o(148650);
    }
}
