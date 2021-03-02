package com.tencent.mm.plugin.soter;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.soter.b.f;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.g.b;

public final class a {
    private com.tencent.soter.a.a.a Fhf;
    private d Fhg;
    private b Fhh;

    /* renamed from: com.tencent.mm.plugin.soter.a$a  reason: collision with other inner class name */
    public interface AbstractC1741a {
        void a(int i2, com.tencent.soter.a.b.a aVar);

        void b(com.tencent.soter.a.b.a aVar);
    }

    public interface c {
        void a(com.tencent.soter.a.b.c cVar);

        void b(com.tencent.soter.a.b.c cVar);
    }

    public final void a(c cVar, e eVar) {
        AppMethodBeat.i(130800);
        a(cVar, true, 1, eVar, 0);
        AppMethodBeat.o(130800);
    }

    /* access modifiers changed from: package-private */
    public final void a(final c cVar, final boolean z, final int i2, final e eVar, final int i3) {
        AppMethodBeat.i(130801);
        Log.i("MicroMsg.SoterManager", "prepare auth key internal: %s, %s, %s", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
            /* class com.tencent.mm.plugin.soter.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
            @Override // com.tencent.soter.a.b.b
            public final /* synthetic */ void a(com.tencent.soter.a.b.c cVar) {
                AppMethodBeat.i(130797);
                com.tencent.soter.a.b.c cVar2 = cVar;
                if (cVar2.isSuccess()) {
                    m.aaz(0);
                    if (cVar != null) {
                        cVar.a(cVar2);
                    }
                } else {
                    if (i3 < m.Fia) {
                        if (i3 == 1) {
                            Log.w("MicroMsg.SoterManager", "need remove ask");
                            com.tencent.soter.core.a.hll();
                        }
                        Log.i("MicroMsg.SoterManager", "do prepare authkey retry: %s", Integer.valueOf(i3));
                        if (eVar instanceof q) {
                            ((q) eVar).reset();
                        }
                        a.this.a(cVar, z, i2, eVar, i3 + 1);
                    } else if (cVar != null) {
                        cVar.b(cVar2);
                    }
                    com.tencent.mm.plugin.soter.d.a.n(2, cVar2.errCode, 1);
                }
                String str = cVar2.errMsg;
                if (cVar2.errCode == 1003) {
                    str = m.Fic;
                } else if (cVar2.errCode == 1004) {
                    str = m.Fid;
                }
                com.tencent.mm.plugin.soter.d.a.t(cVar2.errCode, str, i3);
                AppMethodBeat.o(130797);
            }
        }, z, i2, eVar, new f());
        AppMethodBeat.o(130801);
    }

    public final void a(AbstractC1741a aVar, Context context, int i2, int i3, String str) {
        AppMethodBeat.i(130802);
        Log.i("MicroMsg.SoterManager", "request authorize and sign: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.Fhf == null) {
            this.Fhf = new com.tencent.soter.a.a.a();
        }
        this.Fhf.hlF();
        b.a aVar2 = new b.a();
        aVar2.aqM(i3);
        aVar2.aqL(i2);
        aVar2.lh(context);
        aVar2.a(this.Fhf);
        aVar2.bqn(str);
        if (this.Fhh != null) {
            this.Fhh.Fhn = null;
        }
        this.Fhh = new b(aVar, i3);
        aVar2.a(this.Fhh);
        if (this.Fhg != null) {
            this.Fhg.Fhn = null;
        }
        this.Fhg = new d(aVar, i2);
        com.tencent.soter.a.a.a(this.Fhg, aVar2.RQV);
        AppMethodBeat.o(130802);
    }

    public final void cancel() {
        AppMethodBeat.i(130803);
        Log.i("MicroMsg.SoterManager", "cancel");
        if (this.Fhf != null) {
            this.Fhf.DP(true);
        }
        if (this.Fhg != null) {
            this.Fhg.Fhn = null;
        }
        if (this.Fhh != null) {
            this.Fhh.Fhn = null;
        }
        AppMethodBeat.o(130803);
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.soter.a.a.b {
        AbstractC1741a Fhn;
        private int dFq;

        public b(AbstractC1741a aVar, int i2) {
            this.Fhn = aVar;
            this.dFq = i2;
        }

        @Override // com.tencent.soter.a.a.b
        public final void fly() {
        }

        @Override // com.tencent.soter.a.a.b
        public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        @Override // com.tencent.soter.a.a.b
        public final void flz() {
        }

        @Override // com.tencent.soter.a.a.b
        public final void onAuthenticationFailed() {
            AppMethodBeat.i(130798);
            Log.i("MicroMsg.SoterManager", "request authorize failed");
            if (this.dFq == 1 && this.Fhn != null) {
                this.Fhn.a(1, new com.tencent.soter.a.b.a());
            }
            AppMethodBeat.o(130798);
        }

        @Override // com.tencent.soter.a.a.b
        public final void onAuthenticationCancelled() {
        }

        @Override // com.tencent.soter.a.a.b
        public final void onAuthenticationError(int i2, CharSequence charSequence) {
        }
    }

    /* access modifiers changed from: package-private */
    public static class d implements com.tencent.soter.a.b.b<com.tencent.soter.a.b.a> {
        AbstractC1741a Fhn;
        private int scene;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.soter.a.b.e] */
        @Override // com.tencent.soter.a.b.b
        public final /* synthetic */ void a(com.tencent.soter.a.b.a aVar) {
            AppMethodBeat.i(130799);
            com.tencent.soter.a.b.a aVar2 = aVar;
            int flV = m.flV();
            Log.i("MicroMsg.SoterManager", "request authorize result: %s, %s, %s", Integer.valueOf(aVar2.errCode), aVar2.errMsg, Integer.valueOf(flV));
            if (aVar2.isSuccess()) {
                m.aaA(0);
                if (this.Fhn != null) {
                    this.Fhn.b(aVar2);
                }
            } else {
                if (aVar2.errCode == 1007 || aVar2.errCode == 1027 || aVar2.errCode == 1018) {
                    com.tencent.soter.a.a.aqK(this.scene);
                    int i2 = flV + 1;
                    if (i2 >= m.Fia) {
                        Log.w("MicroMsg.SoterManager", "authorize need remove ask");
                        com.tencent.soter.core.a.hll();
                    }
                    m.aaA(i2);
                }
                if (this.Fhn != null) {
                    this.Fhn.a(0, aVar2);
                }
            }
            com.tencent.mm.plugin.soter.d.a.cx(aVar2.errCode, aVar2.errMsg);
            AppMethodBeat.o(130799);
        }

        public d(AbstractC1741a aVar, int i2) {
            this.Fhn = aVar;
            this.scene = i2;
        }
    }
}
