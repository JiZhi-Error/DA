package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;

public abstract class d extends q implements m {
    private h Fhs;

    public abstract void MO(int i2);

    public abstract void d(int i2, int i3, String str, s sVar);

    public abstract void dKB();

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z = true;
        Log.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.Fhs = new h(new a(this, (byte) 0));
        this.Fhs.Fhv = -3202;
        h hVar = this.Fhs;
        if (i3 == 4 && i4 == -3200) {
            com.tencent.soter.a.a.a(new b<c>() {
                /* class com.tencent.mm.plugin.soter.b.h.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
                @Override // com.tencent.soter.a.b.b
                public final /* synthetic */ void a(c cVar) {
                    AppMethodBeat.i(130825);
                    c cVar2 = cVar;
                    Log.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar2.errCode), cVar2.errMsg);
                    if (!cVar2.isSuccess()) {
                        a.n(1, cVar2.errCode, 1);
                        if (h.this.Fhu != null) {
                            h.this.Fhu.aas(cVar2.errCode);
                        }
                    } else if (h.this.Fhu != null) {
                        h.this.Fhu.flA();
                        AppMethodBeat.o(130825);
                        return;
                    }
                    AppMethodBeat.o(130825);
                }
            }, true, new f());
        } else if (i3 != 4 || i4 != hVar.Fhv) {
            z = false;
        } else if (hVar.Fhu != null) {
            hVar.Fhu.flA();
        }
        if (!z) {
            d(i3, i4, str, sVar);
        }
    }

    class a implements a {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.soter.b.a
        public final void flA() {
            AppMethodBeat.i(130809);
            d.this.dKB();
            AppMethodBeat.o(130809);
        }

        @Override // com.tencent.mm.plugin.soter.b.a
        public final void aas(int i2) {
            AppMethodBeat.i(130810);
            d.this.MO(i2);
            AppMethodBeat.o(130810);
        }
    }
}
