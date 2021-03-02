package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.jsapi.d {
    private static final int CTRL_INDEX = 528;
    private static final String NAME = "compressImage";

    interface c {
        a a(f fVar, String str, int i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(139870);
        if (fVar == null) {
            Log.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
            AppMethodBeat.o(139870);
        } else if (jSONObject == null) {
            Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(139870);
        } else {
            final String optString = jSONObject.optString("src");
            if (Util.isNullOrNil(optString)) {
                Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
                fVar.i(i2, h("fail:data src is null", null));
                AppMethodBeat.o(139870);
            } else if (fVar.getFileSystem() == null) {
                Log.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
                fVar.i(i2, h("fail:runtime fileSystem is null", null));
                AppMethodBeat.o(139870);
            } else {
                final int optInt = jSONObject.optInt("quality", 80);
                if (optInt <= 0 || optInt > 100) {
                    Log.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
                    optInt = 80;
                }
                Log.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", Integer.valueOf(optInt), optString);
                final WeakReference weakReference = new WeakReference(fVar);
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.h.AnonymousClass1 */

                    public final void run() {
                        c dVar;
                        AppMethodBeat.i(139867);
                        if (Util.isNullOrNil(optString) || !optString.startsWith("wxfile://")) {
                            dVar = new d((byte) 0);
                        } else {
                            dVar = new b((byte) 0);
                        }
                        a a2 = dVar.a(fVar, optString, optInt);
                        if (weakReference.get() == null || !((f) weakReference.get()).isRunning()) {
                            Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
                            AppMethodBeat.o(139867);
                            return;
                        }
                        f fVar = (f) weakReference.get();
                        if (!a2.success && Util.isNullOrNil(a2.result)) {
                            Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
                            fVar.i(i2, h.this.h("fail:compress image fail", null));
                            AppMethodBeat.o(139867);
                        } else if (!a2.success) {
                            Log.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", a2.result);
                            fVar.i(i2, h.this.h(a2.result, null));
                            AppMethodBeat.o(139867);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempFilePath", a2.result);
                            fVar.i(i2, h.this.n("ok", hashMap));
                            AppMethodBeat.o(139867);
                        }
                    }
                }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", optString, Integer.valueOf(optInt)), 10);
                AppMethodBeat.o(139870);
            }
        }
    }

    static class b implements c {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x012f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0130, code lost:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.h.a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.o(139868);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0150, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0151, code lost:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.h.a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.o(139868);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0195, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0196, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x012f A[ExcHandler: OutOfMemoryError (r0v7 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:7:0x0049] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0150 A[ExcHandler: NullPointerException (r0v5 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:7:0x0049] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.h.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.appbrand.jsapi.media.h.a a(com.tencent.mm.plugin.appbrand.jsapi.f r11, java.lang.String r12, int r13) {
            /*
            // Method dump skipped, instructions count: 408
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.h.b.a(com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String, int):com.tencent.mm.plugin.appbrand.jsapi.media.h$a");
        }
    }

    static class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0141, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0142, code lost:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.h.a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.o(139869);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0162, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0163, code lost:
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.h.a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.o(139869);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a7, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a8, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0141 A[ExcHandler: OutOfMemoryError (r0v12 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:12:0x006b] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0162 A[ExcHandler: NullPointerException (r0v10 'e' java.lang.NullPointerException A[CUSTOM_DECLARE]), Splitter:B:12:0x006b] */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.h.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.plugin.appbrand.jsapi.media.h.a a(com.tencent.mm.plugin.appbrand.jsapi.f r11, java.lang.String r12, int r13) {
            /*
            // Method dump skipped, instructions count: 426
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.h.d.a(com.tencent.mm.plugin.appbrand.jsapi.f, java.lang.String, int):com.tencent.mm.plugin.appbrand.jsapi.media.h$a");
        }
    }

    static class a {
        String result;
        boolean success;

        public a(boolean z, String str) {
            this.success = z;
            this.result = str;
        }
    }
}
