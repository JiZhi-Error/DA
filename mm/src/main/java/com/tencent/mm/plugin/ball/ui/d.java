package com.tencent.mm.plugin.ball.ui;

import android.animation.AnimatorListenerAdapter;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public class d implements com.tencent.mm.plugin.ball.c.d {
    private static d oYh;
    public volatile boolean oXd = false;
    public a oYi;
    private boolean oYj = false;

    static /* synthetic */ void a(d dVar, List list, BallInfo ballInfo) {
        AppMethodBeat.i(217062);
        dVar.b(list, ballInfo);
        AppMethodBeat.o(217062);
    }

    static /* synthetic */ void a(d dVar, boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217060);
        dVar.d(z, animatorListenerAdapter);
        AppMethodBeat.o(217060);
    }

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(217061);
        dVar.cjb();
        AppMethodBeat.o(217061);
    }

    private d() {
    }

    public static d ciX() {
        AppMethodBeat.i(106309);
        synchronized (d.class) {
            try {
                if (oYh == null) {
                    synchronized (d.class) {
                        try {
                            oYh = new d();
                        } catch (Throwable th) {
                            AppMethodBeat.o(106309);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(106309);
                throw th2;
            }
        }
        d dVar = oYh;
        AppMethodBeat.o(106309);
        return dVar;
    }

    public final boolean ciY() {
        return this.oYi != null;
    }

    public final void jQ(final boolean z) {
        AppMethodBeat.i(176970);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106303);
                if (d.this.ciY()) {
                    a aVar = d.this.oYi;
                    boolean z = z;
                    if (aVar.oXH != null) {
                        aVar.oXH.jQ(z);
                    }
                    if (!z) {
                        if (aVar.oXI != null) {
                            aVar.oXI.e((AnimatorListenerAdapter) null);
                        }
                        if (aVar.oXH != null) {
                            aVar.oXH.jQ(z);
                        }
                    }
                    if (z) {
                        d.b(d.this);
                    }
                }
                AppMethodBeat.o(106303);
            }
        });
        AppMethodBeat.o(176970);
    }

    public final void ciS() {
        AppMethodBeat.i(176971);
        if (ciY()) {
            this.oYi.ciS();
            AppMethodBeat.o(176971);
            return;
        }
        Log.w("MicroMsg.FloatBallUIManager", "clearVOIPView, container is null");
        AppMethodBeat.o(176971);
    }

    public final boolean ciT() {
        AppMethodBeat.i(106310);
        if (ciY()) {
            boolean ciT = this.oYi.ciT();
            AppMethodBeat.o(106310);
            return ciT;
        }
        AppMethodBeat.o(106310);
        return false;
    }

    public final int getPositionY() {
        AppMethodBeat.i(184615);
        if (ciY()) {
            int positionY = this.oYi.getPositionY();
            AppMethodBeat.o(184615);
            return positionY;
        }
        int cjh = com.tencent.mm.plugin.ball.f.d.cjh();
        AppMethodBeat.o(184615);
        return cjh;
    }

    public final void a(final boolean z, final ResultReceiver resultReceiver) {
        AppMethodBeat.i(217053);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(106305);
                if (d.this.ciY()) {
                    a aVar = d.this.oYi;
                    boolean z = z;
                    ResultReceiver resultReceiver = resultReceiver;
                    aVar.oXL.iOB = Util.nowMilliSecond();
                    if (!(aVar.oXH == null || aVar.oXI == null)) {
                        aVar.oXH.b(false, null);
                        aVar.oXI.setInLongPressMode(false);
                        aVar.oXI.setForceShowFloatMenu(true);
                        aVar.oXI.c(resultReceiver);
                        aVar.oXM = z;
                    }
                }
                AppMethodBeat.o(106305);
            }
        });
        AppMethodBeat.o(217053);
    }

    public final void c(final boolean z, final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217054);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            d(z, animatorListenerAdapter);
            AppMethodBeat.o(217054);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(106306);
                d.a(d.this, z, animatorListenerAdapter);
                AppMethodBeat.o(106306);
            }
        });
        AppMethodBeat.o(217054);
    }

    private void d(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217055);
        if (ciY()) {
            if (ciV()) {
                this.oYi.c(z, animatorListenerAdapter);
                AppMethodBeat.o(217055);
                return;
            } else if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(null);
            }
        }
        AppMethodBeat.o(217055);
    }

    private boolean ciV() {
        AppMethodBeat.i(217056);
        if (!ciY() || !this.oYi.ciV()) {
            AppMethodBeat.o(217056);
            return false;
        }
        AppMethodBeat.o(217056);
        return true;
    }

    public final void e(final boolean z, final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184616);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(106307);
                if (d.this.ciY()) {
                    d.this.oYi.b(z, animatorListenerAdapter);
                }
                AppMethodBeat.o(106307);
            }
        });
        AppMethodBeat.o(184616);
    }

    public final void b(final boolean z, final boolean z2, final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184617);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(106308);
                if (d.this.ciY()) {
                    a aVar = d.this.oYi;
                    boolean z = z;
                    boolean z2 = z2;
                    AnimatorListenerAdapter animatorListenerAdapter = animatorListenerAdapter;
                    if (aVar.oXH != null) {
                        Log.i("MicroMsg.FloatBallContainer", "resume FloatBallView, animation:%s", Boolean.valueOf(z));
                        aVar.oXH.c(z, z2, animatorListenerAdapter);
                    }
                    if (aVar.oXI != null) {
                        Log.i("MicroMsg.FloatBallContainer", "quickHide FloatMenuView");
                        aVar.oXI.e(animatorListenerAdapter);
                    }
                }
                AppMethodBeat.o(106308);
            }
        });
        AppMethodBeat.o(184617);
    }

    public final void ciZ() {
        AppMethodBeat.i(106312);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(176969);
                if (d.this.ciY()) {
                    d.c(d.this);
                    a aVar = d.this.oYi;
                    if (aVar.oXH.getVisibility() == 0 || aVar.oXI.getVisibility() == 0) {
                        if (aVar.oXH.getVisibility() == 0) {
                            boolean z = aVar.oXH.oYj;
                            Log.i("MicroMsg.FloatBallContainer", "detachFromWindow, hide floatBallView, needTranslateAnimation: %b", Boolean.valueOf(z));
                            if (z) {
                                FloatBallView floatBallView = aVar.oXH;
                                a.AnonymousClass5 r2 = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004f: CONSTRUCTOR  (r2v3 'r2' com.tencent.mm.plugin.ball.ui.a$5) = (r0v4 'aVar' com.tencent.mm.plugin.ball.ui.a) call: com.tencent.mm.plugin.ball.ui.a.5.<init>(com.tencent.mm.plugin.ball.ui.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.ball.ui.d.7.run():void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.ball.ui.a, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 34 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 192
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ball.ui.d.AnonymousClass7.run():void");
                            }
                        });
                        AppMethodBeat.o(106312);
                    }

                    public final void a(int i2, BallInfo ballInfo) {
                        AppMethodBeat.i(217057);
                        Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallAdded size: %d, state: %d, hidden: %b", Integer.valueOf(i2), Integer.valueOf(ballInfo.state), Boolean.valueOf(ballInfo.nno));
                        if (i2 == 1 && G(ballInfo)) {
                            this.oYj = true;
                        }
                        AppMethodBeat.o(217057);
                    }

                    public final void b(int i2, BallInfo ballInfo) {
                        AppMethodBeat.i(217058);
                        Log.v("MicroMsg.FloatBallUIManager", "alvinluo onFloatBallRemoved size: %d, state: %d, hidden: %b", Integer.valueOf(i2), Integer.valueOf(ballInfo.state), Boolean.valueOf(ballInfo.nno));
                        if (i2 == 0 && ciY() && G(ballInfo)) {
                            this.oYj = true;
                        }
                        AppMethodBeat.o(217058);
                    }

                    @Override // com.tencent.mm.plugin.ball.c.d
                    public final void a(final List<BallInfo> list, final BallInfo ballInfo) {
                        AppMethodBeat.i(106313);
                        Log.d("MicroMsg.FloatBallUIManager", "onFloatBallInfoChanged");
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            b(list, ballInfo);
                            AppMethodBeat.o(106313);
                            return;
                        }
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass8 */

                            public final void run() {
                                AppMethodBeat.i(217052);
                                d.a(d.this, list, ballInfo);
                                AppMethodBeat.o(217052);
                            }
                        });
                        AppMethodBeat.o(106313);
                    }

                    private void b(List<BallInfo> list, BallInfo ballInfo) {
                        AppMethodBeat.i(184618);
                        try {
                            if (!com.tencent.mm.plugin.ball.f.d.h(list)) {
                                Log.i("MicroMsg.FloatBallUIManager", "empty ball info list");
                                ciZ();
                                AppMethodBeat.o(184618);
                            } else if (!ciY()) {
                                Log.i("MicroMsg.FloatBallUIManager", "float ball did not create");
                                cja();
                                c(list, ballInfo);
                                AppMethodBeat.o(184618);
                            } else {
                                Log.i("MicroMsg.FloatBallUIManager", "float ball already created");
                                c(list, ballInfo);
                                AppMethodBeat.o(184618);
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.FloatBallUIManager", "onFloatBallInfoChangedInternal exp:%s", e2);
                            AppMethodBeat.o(184618);
                        }
                    }

                    private void cja() {
                        AppMethodBeat.i(184619);
                        this.oYi = new a(MMApplicationContext.getContext());
                        this.oYi.ciU();
                        cjb();
                        AppMethodBeat.o(184619);
                    }

                    private void c(List<BallInfo> list, BallInfo ballInfo) {
                        AppMethodBeat.i(184620);
                        if (ciY()) {
                            this.oYi.a(list, ballInfo);
                        }
                        AppMethodBeat.o(184620);
                    }

                    private void cjb() {
                        AppMethodBeat.i(217059);
                        if (this.oYj) {
                            this.oYi.setNeedTranslateAnimation(this.oYj);
                            this.oYj = false;
                        }
                        AppMethodBeat.o(217059);
                    }

                    private static boolean G(BallInfo ballInfo) {
                        return ballInfo.state != 0 && !ballInfo.nno;
                    }

                    static /* synthetic */ void b(d dVar) {
                        AppMethodBeat.i(106314);
                        if (dVar.oXd) {
                            Log.i("MicroMsg.FloatBallUIManager", "alvinluo checkFloatBallViewWhenForeground forceHideAllFloatBall and hide");
                            if (dVar.ciY()) {
                                dVar.oYi.b(false, null);
                            }
                        }
                        AppMethodBeat.o(106314);
                    }
                }
