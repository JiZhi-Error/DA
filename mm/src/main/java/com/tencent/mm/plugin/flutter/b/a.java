package com.tencent.mm.plugin.flutter.b;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import io.flutter.embedding.engine.b.b;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.m;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public io.flutter.embedding.engine.a wJi;
    private com.tencent.mm.plugin.flutter.ui.a wJj;
    private HashMap<Integer, Pair<Integer, String>> wJk = new HashMap<>();
    private AtomicInteger wJl = new AtomicInteger(0);
    public k wJm;
    public m wJn;
    private b wJo = new b() {
        /* class com.tencent.mm.plugin.flutter.b.a.AnonymousClass3 */

        @Override // io.flutter.embedding.engine.b.b
        public final void dLt() {
            AppMethodBeat.i(240929);
            Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onFlutterUiDisplayed");
            AppMethodBeat.o(240929);
        }

        @Override // io.flutter.embedding.engine.b.b
        public final void dLu() {
        }
    };

    public a() {
        AppMethodBeat.i(148849);
        AppMethodBeat.o(148849);
    }

    public final boolean dLq() {
        AppMethodBeat.i(240933);
        if (this.wJi == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.wJi = new io.flutter.embedding.engine.a(MMApplicationContext.getContext());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            Log.i("MicroMsg.Flutter.FlutterEngineMgr", "flutter engine new use time: %d", Long.valueOf(currentTimeMillis2));
            h.INSTANCE.dN(1529, 0);
            h.INSTANCE.n(1529, 1, currentTimeMillis2);
        }
        AppMethodBeat.o(240933);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.content.Context] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.flutter.a.c r10, java.lang.String r11, android.app.Activity r12) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.flutter.b.a.a(com.tencent.mm.plugin.flutter.a.c, java.lang.String, android.app.Activity):boolean");
    }

    public final void a(com.tencent.mm.plugin.flutter.ui.a aVar) {
        AppMethodBeat.i(240935);
        Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onCreate %s InstanceCount %d", Integer.valueOf(aVar.hashCode()), Integer.valueOf(this.wJl.incrementAndGet()));
        AppMethodBeat.o(240935);
    }

    public final void b(com.tencent.mm.plugin.flutter.ui.a aVar) {
        AppMethodBeat.i(240936);
        if (aVar.equals(this.wJj)) {
            this.wJi.SNZ.hxd();
        }
        AppMethodBeat.o(240936);
    }

    public final void c(com.tencent.mm.plugin.flutter.ui.a aVar) {
        AppMethodBeat.i(240937);
        this.wJj = aVar;
        this.wJi.SNZ.hxc();
        AppMethodBeat.o(240937);
    }

    public final void d(com.tencent.mm.plugin.flutter.ui.a aVar) {
        AppMethodBeat.i(240938);
        if (this.wJj.equals(aVar)) {
            this.wJi.SNZ.hxe();
            this.wJj = null;
        }
        AppMethodBeat.o(240938);
    }

    public final void onDestroy() {
        AppMethodBeat.i(148851);
        if (this.wJl.decrementAndGet() <= 0) {
            this.wJk.clear();
            if (this.wJi != null) {
                this.wJi.destroy();
            }
            this.wJi = null;
        }
        AppMethodBeat.o(148851);
    }

    public final void dLr() {
        AppMethodBeat.i(148852);
        this.wJi.SOc.dLr();
        AppMethodBeat.o(148852);
    }

    public final com.tencent.mm.plugin.flutter.ui.a dLs() {
        return this.wJj;
    }

    public final boolean gA(int i2, int i3) {
        AppMethodBeat.i(240939);
        try {
            Pair<Integer, String> pair = this.wJk.get(Integer.valueOf(i2));
            if (pair != null) {
                Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onActivityResult %s %d %d", pair.second, pair.first, Integer.valueOf(i3));
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(240939);
        return false;
    }

    public final void fP(final Context context) {
        AppMethodBeat.i(240940);
        if (this.wJm == null) {
            Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error. platformChannel is null.");
            ((Activity) context).finish();
            AppMethodBeat.o(240940);
            return;
        }
        this.wJm.a("canPop", null, new k.d() {
            /* class com.tencent.mm.plugin.flutter.b.a.AnonymousClass4 */

            @Override // io.flutter.plugin.a.k.d
            public final void ba(Object obj) {
                AppMethodBeat.i(240930);
                if (obj == null || !(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
                    Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed success can not pop.");
                    a.this.dLr();
                    AppMethodBeat.o(240930);
                    return;
                }
                a.this.dLr();
                AppMethodBeat.o(240930);
            }

            @Override // io.flutter.plugin.a.k.d
            public final void b(String str, String str2, Object obj) {
                AppMethodBeat.i(240931);
                Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed error");
                ((Activity) context).finish();
                AppMethodBeat.o(240931);
            }

            @Override // io.flutter.plugin.a.k.d
            public final void dLv() {
                AppMethodBeat.i(240932);
                Log.i("MicroMsg.Flutter.FlutterEngineMgr", "onBackPressed notImplemented");
                ((Activity) context).finish();
                AppMethodBeat.o(240932);
            }
        });
        AppMethodBeat.o(240940);
    }
}
