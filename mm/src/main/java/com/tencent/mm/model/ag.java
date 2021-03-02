package com.tencent.mm.model;

import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.f.i.e;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;

public final class ag {
    MMHandler handler;
    public a iCX = null;
    boolean iCY = false;
    String iCZ = "";
    BlockingQueue<c> iDa = new ArrayBlockingQueue(80);
    public b iDb = null;

    public interface b {
        void i(String str, String str2, int i2);
    }

    class c {
        String filename;
        boolean iDj = false;
        String iDk;
        int pos;
        String url;

        public c(String str, String str2, int i2, String str3) {
            AppMethodBeat.i(150159);
            this.url = str;
            if (ag.this.iCY) {
                this.url = t.OO(this.url);
            }
            this.filename = str2;
            this.pos = i2;
            this.iDj = false;
            this.iDk = str3;
            AppMethodBeat.o(150159);
        }
    }

    public ag(boolean z, String str) {
        AppMethodBeat.i(150160);
        g.aAi();
        this.handler = new MMHandler(g.aAk().getLooper()) {
            /* class com.tencent.mm.model.ag.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(150157);
                try {
                    if (ag.this.iDb != null) {
                        final c cVar = (c) message.obj;
                        if (cVar.iDj && t.bcZ()) {
                            String OP = t.OP(cVar.url);
                            Log.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", OP, cVar.filename, cVar.url);
                            Bitmap bitmapNative = BitmapUtil.getBitmapNative(cVar.filename);
                            if (bitmapNative == null) {
                                Log.d("MicroMsg.GetPicService", "decode webp picture failed");
                                ag.a(ag.this, 14, 1);
                            } else if (!Util.isNullOrNil(OP)) {
                                if (OP.toLowerCase().contains("png")) {
                                    Log.d("MicroMsg.GetPicService", "convert webp to png");
                                    BitmapUtil.saveBitmapToImage(bitmapNative, 100, Bitmap.CompressFormat.PNG, cVar.filename, true);
                                } else {
                                    Log.d("MicroMsg.GetPicService", "convert webp to jpg");
                                    BitmapUtil.saveBitmapToImage(bitmapNative, 100, Bitmap.CompressFormat.JPEG, cVar.filename, true);
                                }
                            }
                        }
                        int boW = (int) s.boW(cVar.filename);
                        if (boW > 0 && g.aAc()) {
                            ay.a.iDr.dl(boW, 0);
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.model.ag.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(150156);
                                if (ag.this.iDb != null) {
                                    ag.this.iDb.i(cVar.url, cVar.filename, cVar.pos);
                                }
                                AppMethodBeat.o(150156);
                            }
                        });
                    }
                    AppMethodBeat.o(150157);
                } catch (Exception e2) {
                    Log.e("MicroMsg.GetPicService", "exception:%s", Util.stackTraceToString(e2));
                    AppMethodBeat.o(150157);
                }
            }
        };
        this.iCX = null;
        this.iCY = z;
        this.iCZ = str;
        Log.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b isFromWebViewReffer:%s", Boolean.valueOf(z), str);
        AppMethodBeat.o(150160);
    }

    public class a implements e, h {
        Future<?> dBz;
        public boolean iDf = true;
        c iDg = null;
        final int iDh = 15;
        int iDi = 0;

        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:144:0x0507, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:0x0508, code lost:
            r4 = r3;
            r11 = null;
            r5 = null;
            r6 = r22;
            r7 = r23;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0704, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0705, code lost:
            r4 = r3;
            r11 = r20;
            r5 = null;
            r6 = r22;
            r7 = r23;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:216:0x07e3, code lost:
            r3 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x07e6, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
            r13.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x07ee, code lost:
            r12.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x07f3, code lost:
            r20.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x07f8, code lost:
            r21.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x080c, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:232:0x080d, code lost:
            r12 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x080f, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x0810, code lost:
            r12 = r22;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x0813, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:236:0x0814, code lost:
            r12 = r22;
            r13 = r23;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x081f, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x0820, code lost:
            r20 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:245:0x082f, code lost:
            r4 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:246:0x0830, code lost:
            r11 = null;
            r5 = null;
            r6 = null;
            r7 = null;
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:247:0x0839, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:248:0x083a, code lost:
            r4 = r3;
            r11 = null;
            r5 = null;
            r6 = null;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:251:0x0851, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:252:0x0852, code lost:
            r4 = r3;
            r11 = null;
            r5 = r21;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:253:0x085c, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:254:0x085d, code lost:
            r4 = r3;
            r11 = null;
            r5 = r21;
            r6 = r22;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:261:0x0889, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:262:0x088a, code lost:
            r4 = r3;
            r5 = null;
            r6 = null;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:263:0x0893, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x0894, code lost:
            r4 = r3;
            r11 = r20;
            r5 = null;
            r6 = null;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:265:0x089f, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:266:0x08a0, code lost:
            r4 = r3;
            r11 = r20;
            r5 = null;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:267:0x08aa, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:268:0x08ab, code lost:
            r4 = r3;
            r11 = r20;
            r5 = null;
            r6 = r22;
            r7 = null;
            r2 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0295, code lost:
            r6.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x029a, code lost:
            r11.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x029f, code lost:
            r5.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:217:0x07e6 A[ExcHandler: all (th java.lang.Throwable), PHI: r20 
          PHI: (r20v2 com.tencent.mm.network.y) = (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v9 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y) binds: [B:7:0x002b, B:19:0x0063, B:160:0x05c0, B:28:0x0114] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x002b] */
        /* JADX WARNING: Removed duplicated region for block: B:219:0x07e9 A[SYNTHETIC, Splitter:B:219:0x07e9] */
        /* JADX WARNING: Removed duplicated region for block: B:222:0x07ee A[Catch:{ Exception -> 0x080a }] */
        /* JADX WARNING: Removed duplicated region for block: B:224:0x07f3 A[Catch:{ Exception -> 0x080a }] */
        /* JADX WARNING: Removed duplicated region for block: B:226:0x07f8 A[Catch:{ Exception -> 0x080a }] */
        /* JADX WARNING: Removed duplicated region for block: B:231:0x080c A[ExcHandler: all (th java.lang.Throwable), PHI: r6 r20 
          PHI: (r6v6 java.io.InputStream) = (r6v14 java.io.InputStream), (r6v14 java.io.InputStream), (r6v31 java.io.InputStream), (r6v31 java.io.InputStream), (r6v57 java.io.InputStream), (r6v57 java.io.InputStream) binds: [B:200:0x0719, B:201:?, B:147:0x051c, B:148:?, B:81:0x02b0, B:82:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r20v6 com.tencent.mm.network.y) = (r20v9 com.tencent.mm.network.y), (r20v9 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y) binds: [B:200:0x0719, B:201:?, B:147:0x051c, B:148:?, B:81:0x02b0, B:82:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:81:0x02b0] */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x080f A[ExcHandler: all (th java.lang.Throwable), PHI: r20 r22 
          PHI: (r20v5 com.tencent.mm.network.y) = (r20v9 com.tencent.mm.network.y), (r20v9 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y) binds: [B:190:0x06d3, B:191:?, B:137:0x04d6, B:138:?, B:54:0x0211, B:55:?] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r22v1 java.io.InputStream) = (r22v3 java.io.InputStream), (r22v3 java.io.InputStream), (r22v6 java.io.InputStream), (r22v6 java.io.InputStream), (r22v9 java.io.InputStream), (r22v9 java.io.InputStream) binds: [B:190:0x06d3, B:191:?, B:137:0x04d6, B:138:?, B:54:0x0211, B:55:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:54:0x0211] */
        /* JADX WARNING: Removed duplicated region for block: B:235:0x0813 A[ExcHandler: all (th java.lang.Throwable), PHI: r20 r22 
          PHI: (r20v4 com.tencent.mm.network.y) = (r20v9 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y), (r20v0 com.tencent.mm.network.y) binds: [B:193:0x06f6, B:140:0x04f9, B:57:0x0234] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r22v0 java.io.InputStream) = (r22v3 java.io.InputStream), (r22v6 java.io.InputStream), (r22v9 java.io.InputStream) binds: [B:193:0x06f6, B:140:0x04f9, B:57:0x0234] A[DONT_GENERATE, DONT_INLINE], Splitter:B:57:0x0234] */
        /* JADX WARNING: Removed duplicated region for block: B:261:0x0889 A[ExcHandler: Exception (r3v25 'e' java.lang.Exception A[CUSTOM_DECLARE]), PHI: r11 
          PHI: (r11v3 com.tencent.mm.network.y) = (r11v4 com.tencent.mm.network.y), (r11v4 com.tencent.mm.network.y), (r11v13 com.tencent.mm.network.y), (r11v13 com.tencent.mm.network.y) binds: [B:183:0x06b0, B:184:?, B:157:0x05ab, B:158:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:157:0x05ab] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0290 A[SYNTHETIC, Splitter:B:71:0x0290] */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0295 A[Catch:{ Exception -> 0x07e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x029a A[Catch:{ Exception -> 0x07e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x029f A[Catch:{ Exception -> 0x07e2 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 2231
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.ag.a.run():void");
        }

        private boolean rS(int i2) {
            return ag.this.iCY && this.iDi < 15 && (i2 == 301 || i2 == 302);
        }

        @Override // com.tencent.f.i.e
        public final void a(Future<?> future) {
            this.dBz = future;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "GetPicService_getPic";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0120, code lost:
        if (r0 == false) goto L_0x0122;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c(java.lang.String r12, int r13, int r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 347
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.ag.c(java.lang.String, int, int, java.lang.String):java.lang.String");
    }

    static /* synthetic */ void a(ag agVar, long j2, long j3) {
        AppMethodBeat.i(150162);
        if (agVar.iCY) {
            Log.d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", Long.valueOf(j2), Long.valueOf(j3));
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(86, j2, j3, false);
        }
        AppMethodBeat.o(150162);
    }
}
