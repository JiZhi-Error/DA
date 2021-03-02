package com.tencent.luggage.sdk.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public interface a extends com.tencent.luggage.a.b {

    public interface b {
        void o(Bitmap bitmap);
    }

    String Pa();

    void a(b bVar);

    /* renamed from: com.tencent.luggage.sdk.f.a$a  reason: collision with other inner class name */
    public static class C0186a {
        private static final a cCD = new a() {
            /* class com.tencent.luggage.sdk.f.a.C0186a.AnonymousClass1 */

            @Override // com.tencent.luggage.sdk.f.a
            public final void a(final b bVar) {
                AppMethodBeat.i(169459);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.luggage.sdk.f.a.C0186a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(169458);
                        bVar.o(null);
                        AppMethodBeat.o(169458);
                    }
                });
                AppMethodBeat.o(169459);
            }

            @Override // com.tencent.luggage.sdk.f.a
            public final String Pa() {
                return null;
            }
        };

        public static a b(f fVar) {
            AppMethodBeat.i(169460);
            a aVar = (a) fVar.M(a.class);
            if (aVar == null) {
                aVar = cCD;
            }
            AppMethodBeat.o(169460);
            return aVar;
        }

        static {
            AppMethodBeat.i(169461);
            AppMethodBeat.o(169461);
        }
    }
}
