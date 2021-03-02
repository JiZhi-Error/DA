package com.tencent.tbs.one.impl.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.h;
import java.io.File;

public final class g implements TBSOneOnlineService {

    /* renamed from: a  reason: collision with root package name */
    j f2741a;

    /* renamed from: b  reason: collision with root package name */
    private i f2742b;

    public g(i iVar) {
        this.f2742b = iVar;
    }

    private void a(j jVar) {
        AppMethodBeat.i(173965);
        this.f2741a = null;
        jVar.a();
        AppMethodBeat.o(173965);
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(173967);
        if (gVar.f2741a != null) {
            gVar.f2741a.b();
        }
        AppMethodBeat.o(173967);
    }

    static /* synthetic */ void a(g gVar, Bundle bundle, final TBSOneCallback tBSOneCallback) {
        AppMethodBeat.i(188005);
        if (gVar.f2741a == null) {
            final i iVar = gVar.f2742b;
            String str = iVar.f2754b;
            final j i2 = iVar.i();
            if (i2 == null) {
                if (tBSOneCallback != null) {
                    tBSOneCallback.onError(502, "Failed to acquire update lock");
                }
                AppMethodBeat.o(188005);
            } else if (iVar.h()) {
                f.a("[%s] No need to update because another process has updated", str);
                if (tBSOneCallback != null) {
                    tBSOneCallback.onCompleted(null);
                }
                gVar.a(i2);
                AppMethodBeat.o(188005);
            } else {
                File g2 = iVar.g();
                if (!g2.exists()) {
                    c.b(g2);
                }
                gVar.f2741a = new j(iVar, bundle);
                gVar.f2741a.a((l) new com.tencent.tbs.one.impl.common.c<Void>() {
                    /* class com.tencent.tbs.one.impl.e.g.AnonymousClass3 */

                    @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                    public final void a(int i2, int i3) {
                        AppMethodBeat.i(174132);
                        tBSOneCallback.onProgressChanged(i2, i3);
                        AppMethodBeat.o(174132);
                    }

                    @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                    public final void a(int i2, String str, Throwable th) {
                        AppMethodBeat.i(174133);
                        d dVar = iVar.f2760h;
                        h.a(dVar != null ? dVar.f2555a : -1, "", -1, i2, str, th);
                        g.a(g.this, i2);
                        tBSOneCallback.onError(i2, str);
                        AppMethodBeat.o(174133);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                    public final /* synthetic */ void a(Void r4) {
                        AppMethodBeat.i(174134);
                        Void r42 = r4;
                        File g2 = iVar.g();
                        if (g2.exists()) {
                            c.c(g2);
                        }
                        g.a(g.this, i2);
                        tBSOneCallback.onCompleted(r42);
                        AppMethodBeat.o(174134);
                    }
                });
                AppMethodBeat.o(188005);
            }
        } else {
            gVar.f2741a.a((l) new com.tencent.tbs.one.impl.common.c<Void>() {
                /* class com.tencent.tbs.one.impl.e.g.AnonymousClass4 */

                @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                public final void a(int i2, int i3) {
                    AppMethodBeat.i(173960);
                    tBSOneCallback.onProgressChanged(i2, i3);
                    AppMethodBeat.o(173960);
                }

                @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                public final void a(int i2, String str, Throwable th) {
                    AppMethodBeat.i(173961);
                    tBSOneCallback.onError(i2, str);
                    AppMethodBeat.o(173961);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.tbs.one.impl.a.l, com.tencent.tbs.one.impl.common.c
                public final /* synthetic */ void a(Void r3) {
                    AppMethodBeat.i(173962);
                    tBSOneCallback.onCompleted(r3);
                    AppMethodBeat.o(173962);
                }
            });
            AppMethodBeat.o(188005);
        }
    }

    static /* synthetic */ void a(g gVar, j jVar) {
        AppMethodBeat.i(173968);
        gVar.a(jVar);
        AppMethodBeat.o(173968);
    }

    @Override // com.tencent.tbs.one.TBSOneOnlineService
    public final void cancelUpdate() {
        AppMethodBeat.i(173964);
        f.a("[%s] Canceling update", this.f2742b.f2754b);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.e.g.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(174075);
                g.a(g.this);
                AppMethodBeat.o(174075);
            }
        });
        AppMethodBeat.o(173964);
    }

    @Override // com.tencent.tbs.one.TBSOneOnlineService
    public final void update(final Bundle bundle, final TBSOneCallback<Void> tBSOneCallback) {
        AppMethodBeat.i(188004);
        String str = this.f2742b.f2754b;
        f.a("[%s] Updating", str);
        if (this.f2742b.h()) {
            f.a("[%s] No need to update because the last update has not applied", str);
            if (tBSOneCallback != null) {
                tBSOneCallback.onCompleted(null);
            }
            AppMethodBeat.o(188004);
            return;
        }
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.e.g.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(174138);
                g.a(g.this, bundle, tBSOneCallback);
                AppMethodBeat.o(174138);
            }
        });
        AppMethodBeat.o(188004);
    }
}
