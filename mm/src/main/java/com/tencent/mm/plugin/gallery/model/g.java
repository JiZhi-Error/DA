package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public final class g {
    static int DEFAULT_CORE_POOL_SIZE;
    MMHandler hAk;
    MMHandler xiA = null;
    MMHandler xiB;
    ExecutorService xiC;
    ExecutorService xiD;
    ExecutorService xiE;
    HandlerThread xiF;
    MMHandler xiG;
    HandlerThread xiy = new HandlerThread("smartGalleryQueryHandlerThread", 10);
    HandlerThread xiz;

    g() {
        int i2 = 2;
        AppMethodBeat.i(111298);
        Log.d("MicroMsg.GalleryHandlerThread", "GalleryHandlerThread init.");
        this.xiy.start();
        this.xiz = new HandlerThread("galleryAssistHandlerThread", 10);
        this.xiB = null;
        this.xiz.start();
        this.hAk = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors() / 2;
        if (availableProcessors >= 2) {
            if (availableProcessors > 4) {
                i2 = 4;
            } else {
                i2 = availableProcessors;
            }
        }
        DEFAULT_CORE_POOL_SIZE = i2;
        i iVar = h.RTc;
        int i3 = DEFAULT_CORE_POOL_SIZE;
        this.xiC = iVar.a("gly-tp_q", i3, i3, new LinkedBlockingQueue());
        i iVar2 = h.RTc;
        int i4 = DEFAULT_CORE_POOL_SIZE;
        this.xiD = iVar2.a("gly-tp", i4, i4, new LinkedBlockingQueue());
        this.xiE = h.RTc.a("gly-tp-p", DEFAULT_CORE_POOL_SIZE / 2, DEFAULT_CORE_POOL_SIZE / 2, new LinkedBlockingQueue());
        this.xiF = new HandlerThread("galleryQuerySubHandlerThread", 10);
        this.xiG = null;
        this.xiF.start();
        AppMethodBeat.o(111298);
    }

    /* access modifiers changed from: package-private */
    public final MMHandler dRc() {
        AppMethodBeat.i(111301);
        if (this.xiB == null && this.xiz != null) {
            this.xiB = new MMHandler(this.xiz.getLooper());
        }
        MMHandler mMHandler = this.xiB;
        AppMethodBeat.o(111301);
        return mMHandler;
    }

    public final MMHandler dRd() {
        AppMethodBeat.i(111302);
        if (this.hAk == null) {
            this.hAk = new MMHandler(Looper.getMainLooper());
        }
        MMHandler mMHandler = this.hAk;
        AppMethodBeat.o(111302);
        return mMHandler;
    }

    public final void aq(Runnable runnable) {
        AppMethodBeat.i(257727);
        MMHandler dRc = dRc();
        if (dRc != null) {
            dRc.post(runnable);
            AppMethodBeat.o(257727);
            return;
        }
        Log.w("MicroMsg.GalleryHandlerThread", "assistHandler is null.");
        AppMethodBeat.o(257727);
    }

    public final void postToMainThread(Runnable runnable) {
        AppMethodBeat.i(111306);
        if (runnable == null) {
            Log.e("MicroMsg.GalleryHandlerThread", "postToMainThread, runnable is null");
            AppMethodBeat.o(111306);
            return;
        }
        dRd().post(runnable);
        AppMethodBeat.o(111306);
    }

    public final void ar(Runnable runnable) {
        AppMethodBeat.i(173731);
        if (this.xiC != null) {
            this.xiC.execute(runnable);
        }
        AppMethodBeat.o(173731);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r1 = r7.get(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.gallery.model.h<java.lang.String> r6, java.util.HashMap<java.lang.String, com.tencent.mm.plugin.gallery.model.c.C1385c> r7) {
        /*
            r5 = this;
            r4 = 111307(0x1b2cb, float:1.55974E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r6 == 0) goto L_0x0048
            if (r7 == 0) goto L_0x0048
            java.util.concurrent.ExecutorService r0 = r5.xiD
            if (r0 == 0) goto L_0x0048
        L_0x000e:
            com.tencent.mm.plugin.gallery.model.c r0 = com.tencent.mm.plugin.gallery.model.e.dQJ()
            boolean r0 = r0.dQz()
            if (r0 == 0) goto L_0x0048
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0048
            java.lang.Object r0 = r6.dRl()
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r7.containsKey(r0)
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r7.get(r0)
            com.tencent.mm.plugin.gallery.model.c$c r1 = (com.tencent.mm.plugin.gallery.model.c.C1385c) r1
            if (r1 == 0) goto L_0x000e
            boolean r2 = r1.mCancel
            if (r2 != 0) goto L_0x000e
            com.tencent.mm.plugin.gallery.model.c r2 = com.tencent.mm.plugin.gallery.model.e.dQJ()
            r2.dQA()
            java.util.concurrent.ExecutorService r2 = r5.xiD
            com.tencent.mm.plugin.gallery.model.g$1 r3 = new com.tencent.mm.plugin.gallery.model.g$1
            r3.<init>(r1, r0)
            r2.execute(r3)
            goto L_0x000e
        L_0x0048:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.model.g.a(com.tencent.mm.plugin.gallery.model.h, java.util.HashMap):void");
    }

    public final void a(h<c.b> hVar, h<c.b> hVar2) {
        AppMethodBeat.i(111308);
        if (!(hVar == null || hVar2 == null || this.xiE == null)) {
            while (e.dQJ().dQB() && !hVar.isEmpty()) {
                final c.b dRl = hVar.dRl();
                if (dRl != null && !dRl.mCancel) {
                    hVar2.add(dRl);
                    e.dQJ().dQC();
                    this.xiE.execute(new Runnable() {
                        /* class com.tencent.mm.plugin.gallery.model.g.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(111297);
                            final boolean doInBackground = dRl.doInBackground();
                            g.this.dRd().post(new Runnable() {
                                /* class com.tencent.mm.plugin.gallery.model.g.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(111296);
                                    c.b bVar = dRl;
                                    boolean z = doInBackground;
                                    c.this.xhT.remove(bVar);
                                    c.this.xhR++;
                                    c.this.dQD();
                                    if (z) {
                                        c.this.xhN.a(bVar.mFilePath, bVar.bitmap, bVar.xhX, null, true, -1, bVar.xhY);
                                    }
                                    AppMethodBeat.o(111296);
                                }
                            });
                            AppMethodBeat.o(111297);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(111308);
    }

    /* access modifiers changed from: package-private */
    public final MMHandler dRe() {
        AppMethodBeat.i(173732);
        if (this.xiG == null && this.xiF != null) {
            this.xiG = new MMHandler(this.xiF.getLooper());
        }
        MMHandler mMHandler = this.xiG;
        AppMethodBeat.o(173732);
        return mMHandler;
    }

    public final void as(Runnable runnable) {
        AppMethodBeat.i(173733);
        if (runnable == null) {
            Log.e("MicroMsg.GalleryHandlerThread", "postToQuerySubWorker runnable is null");
            AppMethodBeat.o(173733);
            return;
        }
        MMHandler dRe = dRe();
        if (dRe != null) {
            dRe.post(runnable);
            AppMethodBeat.o(173733);
            return;
        }
        Log.w("MicroMsg.GalleryHandlerThread", "querySubHandler is null.");
        AppMethodBeat.o(173733);
    }

    public final MMHandler dRf() {
        AppMethodBeat.i(111300);
        if (this.xiA == null && this.xiy != null) {
            this.xiA = new MMHandler(this.xiy.getLooper());
        }
        MMHandler mMHandler = this.xiA;
        AppMethodBeat.o(111300);
        return mMHandler;
    }
}
