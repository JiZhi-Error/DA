package com.tencent.luggage.d;

import com.tencent.luggage.bridge.d;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.bridge.l;
import com.tencent.luggage.bridge.o;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.a.b;
import com.tencent.luggage.d.a.c;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public abstract class n implements c {
    final ConcurrentHashMap<String, Class<? extends b>> ctA = new ConcurrentHashMap<>();
    public a ctB;

    /* access modifiers changed from: package-private */
    public abstract o getBridge();

    public abstract String getUserAgent();

    public void destroy() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: com.tencent.luggage.d.c */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(List<Class<? extends b>> list, c cVar) {
        for (Class<? extends b> cls : list) {
            try {
                final b bVar = (b) cls.newInstance();
                try {
                    bVar.csZ = cVar;
                    this.ctA.put(bVar.name(), cls);
                    o bridge = getBridge();
                    bridge.csL.put(bVar.name(), new l() {
                        /* class com.tencent.luggage.d.n.AnonymousClass1 */

                        @Override // com.tencent.luggage.bridge.l
                        public final void a(k kVar) {
                            AppMethodBeat.i(221185);
                            n nVar = n.this;
                            b bVar = bVar;
                            nVar.LC().a(bVar.name(), new c(bVar, kVar) {
                                /* class com.tencent.luggage.d.n.AnonymousClass2 */
                                final /* synthetic */ b ctC;
                                final /* synthetic */ k ctE;

                                {
                                    this.ctC = r2;
                                    this.ctE = r3;
                                }

                                @Override // com.tencent.luggage.d.a.c
                                public final void a(b bVar) {
                                    AppMethodBeat.i(221186);
                                    if (bVar == b.PASS) {
                                        b bVar2 = this.ctC;
                                        b bVar3 = this.ctC;
                                        k kVar = this.ctE;
                                        b<CONTEXT>.a aVar = new b.a();
                                        aVar.cta = bVar3.csZ;
                                        aVar.ctb = kVar;
                                        bVar2.a(aVar);
                                        AppMethodBeat.o(221186);
                                        return;
                                    }
                                    this.ctE.c("system:access_denied", null);
                                    AppMethodBeat.o(221186);
                                }
                            });
                            AppMethodBeat.o(221185);
                        }
                    });
                } catch (Exception e2) {
                    Log.e("Luggage.LuggageRuntime", "registerJsApi: ".concat(String.valueOf(e2)));
                }
            } catch (Exception e3) {
                Log.e("Luggage.LuggageRuntime", "JsApi Initialize failed, %s, %s", cls.getName(), e3);
            }
        }
    }

    public final void a(final d dVar) {
        AnonymousClass3 r0 = new c() {
            /* class com.tencent.luggage.d.n.AnonymousClass3 */

            @Override // com.tencent.luggage.d.a.c
            public final void a(com.tencent.luggage.d.a.b bVar) {
                AppMethodBeat.i(221187);
                if (dVar == null) {
                    Log.e("Luggage.LuggageRuntime", "Null Event, Ignore");
                    AppMethodBeat.o(221187);
                    return;
                }
                if (bVar == com.tencent.luggage.d.a.b.PASS) {
                    o bridge = n.this.getBridge();
                    bridge.csJ.a(new d(dVar.name(), dVar.Ld()));
                }
                AppMethodBeat.o(221187);
            }
        };
        a LC = LC();
        dVar.name();
        LC.a(r0);
    }

    public final a LC() {
        return this.ctB == null ? a.ctX : this.ctB;
    }
}
