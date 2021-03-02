package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;

public class PluginAuth extends f implements c {
    private static int Juw = -1;
    private final a Juv = new a((byte) 0);

    public PluginAuth() {
        AppMethodBeat.i(134223);
        AppMethodBeat.o(134223);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(134224);
        alias(c.class);
        AppMethodBeat.o(134224);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(134225);
        dependsOn(s.class);
        AppMethodBeat.o(134225);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(134226);
        bh.a(new bh.a() {
            /* class com.tencent.mm.plugin.auth.PluginAuth.AnonymousClass1 */

            @Override // com.tencent.mm.model.bh.a
            public final void a(j.h hVar, j.i iVar) {
                AppMethodBeat.i(134218);
                aj.a(iVar.Kzw, true);
                PluginAuth.this.getHandleAuthResponseCallbacks().a(hVar, iVar, true);
                AppMethodBeat.o(134218);
            }
        });
        AppMethodBeat.o(134226);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-auth";
    }

    /* access modifiers changed from: package-private */
    public static final class a extends com.tencent.mm.co.a<b> implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(final j.h hVar, final j.i iVar, final boolean z) {
            AppMethodBeat.i(134221);
            a(new a.AbstractC0297a<b>() {
                /* class com.tencent.mm.plugin.auth.PluginAuth.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(b bVar) {
                    AppMethodBeat.i(134219);
                    bVar.a(hVar, iVar, z);
                    AppMethodBeat.o(134219);
                }
            });
            AppMethodBeat.o(134221);
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(final x.b bVar, final String str, final int i2, final String str2, final String str3, final int i3) {
            AppMethodBeat.i(134222);
            a(new a.AbstractC0297a<b>() {
                /* class com.tencent.mm.plugin.auth.PluginAuth.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(b bVar) {
                    AppMethodBeat.i(134220);
                    bVar.a(bVar, str, i2, str2, str3, i3);
                    AppMethodBeat.o(134220);
                }
            });
            AppMethodBeat.o(134222);
        }
    }

    @Override // com.tencent.mm.plugin.auth.a.c
    public com.tencent.mm.vending.b.b addHandleAuthResponse(b bVar) {
        AppMethodBeat.i(134227);
        com.tencent.mm.vending.b.b add = this.Juv.add(bVar);
        AppMethodBeat.o(134227);
        return add;
    }

    public b getHandleAuthResponseCallbacks() {
        return this.Juv;
    }

    public static int getUserInfoPluginSwitch() {
        return Juw;
    }

    public static void setUserInfoPluginSwitch(int i2) {
        Juw = i2;
    }
}
