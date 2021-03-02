package com.tencent.wxa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import java.util.concurrent.LinkedBlockingQueue;

public final class a {
    public k.c SxT;
    private LinkedBlockingQueue<b> SxU = new LinkedBlockingQueue<>();
    private k.c SxV = new k.c() {
        /* class com.tencent.wxa.a.a.AnonymousClass1 */

        @Override // io.flutter.plugin.a.k.c
        public final void a(j jVar, k.d dVar) {
            AppMethodBeat.i(206310);
            String str = jVar.method;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2021996674:
                    if (str.equals("onDartChannelReady")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "onMethodCall onDartChannelReady", new Object[0]);
                    if (!a.this.chu) {
                        a.this.hrL();
                        AppMethodBeat.o(206310);
                        return;
                    }
                    break;
                default:
                    if (a.this.SxT != null) {
                        a.this.SxT.a(jVar, dVar);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(206310);
        }
    };
    private k bbv;
    boolean chu = true;

    public a(c cVar, String str) {
        AppMethodBeat.i(206312);
        this.bbv = new k(cVar, str);
        this.bbv.a(this.SxV);
        this.bbv.a("onCheckDartChannelReady", null, new k.d() {
            /* class com.tencent.wxa.a.a.AnonymousClass2 */

            @Override // io.flutter.plugin.a.k.d
            public final void ba(Object obj) {
                AppMethodBeat.i(206311);
                if (!a.this.chu) {
                    a.this.hrL();
                }
                AppMethodBeat.o(206311);
            }

            @Override // io.flutter.plugin.a.k.d
            public final void b(String str, String str2, Object obj) {
            }

            @Override // io.flutter.plugin.a.k.d
            public final void dLv() {
            }
        });
        AppMethodBeat.o(206312);
    }

    public final void a(String str, Object obj, k.d dVar) {
        AppMethodBeat.i(206313);
        if (this.chu) {
            this.bbv.a(str, obj, dVar);
            com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod invoke method %s", str);
            AppMethodBeat.o(206313);
            return;
        }
        this.SxU.offer(new b(str, obj, dVar));
        com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "invokeMethod add invoke method %s", str);
        AppMethodBeat.o(206313);
    }

    public final void hrL() {
        AppMethodBeat.i(206314);
        this.chu = true;
        while (!this.SxU.isEmpty()) {
            b poll = this.SxU.poll();
            if (poll != null) {
                this.bbv.a(poll.method, poll.SxX, poll.SxY);
                com.tencent.wxa.c.a.d("WxaRouter.SafeMethodChannel", "notifyChannelReady doing invoke method %s", poll.method);
            }
        }
        AppMethodBeat.o(206314);
    }
}
