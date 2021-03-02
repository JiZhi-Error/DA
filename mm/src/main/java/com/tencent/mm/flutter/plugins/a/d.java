package com.tencent.mm.flutter.plugins.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;
import io.flutter.view.c;
import java.util.HashMap;
import java.util.Map;

public final class d implements io.flutter.embedding.engine.plugins.a, k.c {
    private k bbv;
    private a.b hgm;
    private final Map<Long, a> hgn = new HashMap();

    @Override // io.flutter.embedding.engine.plugins.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(199141);
        this.bbv = new k(bVar.SOH, "com.tencent.mm.flutter/videoPlayer");
        this.bbv.a(this);
        AppMethodBeat.o(199141);
    }

    @Override // io.flutter.embedding.engine.plugins.a
    public final void b(a.b bVar) {
        AppMethodBeat.i(199142);
        this.bbv.a(null);
        this.bbv = null;
        for (a aVar : this.hgn.values()) {
            aVar.dispose();
        }
        this.hgn.clear();
        AppMethodBeat.o(199142);
    }

    static class a {
        private final io.flutter.plugin.a.d bbw;
        b hgo;
        private final c.a hgp;
        c hgq = new c();
        private boolean isInitialized = false;
        private Surface surface;

        a(io.flutter.plugin.a.d dVar, c.a aVar, k.d dVar2, String str) {
            AppMethodBeat.i(199139);
            this.bbw = dVar;
            this.hgp = aVar;
            try {
                this.hgo = (b) Class.forName(str).newInstance();
            } catch (ClassNotFoundException | Exception e2) {
            }
            dVar.a(new d.c() {
                /* class com.tencent.mm.flutter.plugins.a.d.a.AnonymousClass1 */

                @Override // io.flutter.plugin.a.d.c
                public final void a(Object obj, d.a aVar) {
                    AppMethodBeat.i(199137);
                    a.this.hgq.a(aVar);
                    AppMethodBeat.o(199137);
                }

                @Override // io.flutter.plugin.a.d.c
                public final void sT() {
                    AppMethodBeat.i(199138);
                    a.this.hgq.a(null);
                    AppMethodBeat.o(199138);
                }
            });
            this.surface = new Surface(aVar.surfaceTexture());
            new a() {
                /* class com.tencent.mm.flutter.plugins.a.d.a.AnonymousClass2 */
            };
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", Long.valueOf(aVar.hxb()));
            dVar2.ba(hashMap);
            AppMethodBeat.o(199139);
        }

        /* access modifiers changed from: package-private */
        public final void dispose() {
            AppMethodBeat.i(199140);
            this.hgp.release();
            this.bbw.a(null);
            if (this.surface != null) {
                this.surface.release();
            }
            AppMethodBeat.o(199140);
        }
    }

    public d() {
        AppMethodBeat.i(199143);
        AppMethodBeat.o(199143);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0163, code lost:
        if (r6.equals("setLooping") != false) goto L_0x0151;
     */
    @Override // io.flutter.plugin.a.k.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(io.flutter.plugin.a.j r11, io.flutter.plugin.a.k.d r12) {
        /*
        // Method dump skipped, instructions count: 616
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.flutter.plugins.a.d.a(io.flutter.plugin.a.j, io.flutter.plugin.a.k$d):void");
    }
}
