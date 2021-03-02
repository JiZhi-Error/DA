package com.tencent.mm.plugin.ball.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningOperationParcel;
import com.tencent.mm.plugin.appbrand.backgroundrunning.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.f.c;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.plugin.ball.ui.a;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class d implements b, g.a, com.tencent.mm.plugin.ball.c.b {
    private static d oWT;
    volatile int displayHeight = 0;
    final List<BallInfo> oVq = new CopyOnWriteArrayList();
    private final List<BallInfo> oWU = new CopyOnWriteArrayList();
    private Set<com.tencent.mm.plugin.ball.c.d> oWV = new CopyOnWriteArraySet();
    private Set<com.tencent.mm.plugin.ball.c.g> oWW = new CopyOnWriteArraySet();
    private SparseArray<Set<e>> oWX = new SparseArray<>();
    private Map<String, ResultReceiver> oWY = new ConcurrentHashMap();
    private volatile BallInfo oWZ = null;
    private volatile BallInfo oXa = null;
    private volatile boolean oXb = false;
    volatile boolean oXc = false;
    volatile boolean oXd = false;
    volatile boolean oXe = false;
    private volatile boolean oXf = false;
    private volatile boolean oXg = true;
    private volatile long oXh = 0;
    private volatile int oXi = 0;
    private volatile int oXj = 0;
    private volatile boolean oXk = false;
    private View oXl;
    private volatile BallInfo oXm = null;
    private int oXn = -1;

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(106142);
        dVar.ciH();
        AppMethodBeat.o(106142);
    }

    static /* synthetic */ void a(d dVar, BallInfo ballInfo) {
        AppMethodBeat.i(184583);
        dVar.z(ballInfo);
        AppMethodBeat.o(184583);
    }

    static /* synthetic */ boolean a(d dVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(184582);
        boolean a2 = dVar.a(i2, i3, true, z, null);
        AppMethodBeat.o(184582);
        return a2;
    }

    private d() {
        AppMethodBeat.i(106097);
        AppMethodBeat.o(106097);
    }

    public static d ciB() {
        AppMethodBeat.i(106098);
        synchronized (d.class) {
            try {
                if (oWT == null) {
                    synchronized (d.class) {
                        try {
                            oWT = new d();
                        } catch (Throwable th) {
                            AppMethodBeat.o(106098);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(106098);
                throw th2;
            }
        }
        d dVar = oWT;
        AppMethodBeat.o(106098);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void dn(View view) {
        this.oXl = view;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chU() {
        this.oXl = null;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jR(boolean z) {
        AppMethodBeat.i(184564);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            ciX.oYi.oXK = z;
        }
        AppMethodBeat.o(184564);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jS(boolean z) {
        AppMethodBeat.i(185124);
        Log.i("MicroMsg.FloatBallService", "markForceHideAllFloatBall %b", Boolean.valueOf(z));
        this.oXd = z;
        com.tencent.mm.plugin.ball.ui.d.ciX().oXd = z;
        AppMethodBeat.o(185124);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chV() {
        return this.oXd;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chW() {
        AppMethodBeat.i(184565);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            ciX.oYi.chW();
        }
        AppMethodBeat.o(184565);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chX() {
        AppMethodBeat.i(184566);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            ciX.oYi.chX();
        }
        AppMethodBeat.o(184566);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void setEnableClick(boolean z) {
        AppMethodBeat.i(216991);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            a aVar = ciX.oYi;
            if (aVar.oXH != null) {
                aVar.oXH.setEnableClick(z);
            }
        }
        AppMethodBeat.o(216991);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(106099);
        Log.i("MicroMsg.FloatBallService", "onRegister:%s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(106099);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(106100);
        Log.i("MicroMsg.FloatBallService", "onUnregister:%s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(106100);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jQ(boolean z) {
        AppMethodBeat.i(176960);
        Log.i("MicroMsg.FloatBallService", "markWechatInForeground, foreground:%s", Boolean.valueOf(z));
        this.oXg = z;
        if (this.oXe) {
            Log.i("MicroMsg.FloatBallService", "markWechatInForeground, has marked QB file view page, mark Wechat in foreground");
            com.tencent.mm.plugin.ball.ui.d.ciX().jQ(true);
        } else {
            com.tencent.mm.plugin.ball.ui.d.ciX().jQ(z);
        }
        if (!this.oXg) {
            Log.i("MicroMsg.FloatBallService", "alvinluo resetReadyStatusBallInfo");
            this.oXa = null;
        }
        AppMethodBeat.o(176960);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jL(boolean z) {
        AppMethodBeat.i(106101);
        a(z, (AnimatorListenerAdapter) null);
        AppMethodBeat.o(106101);
    }

    public final void a(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        boolean z2;
        AppMethodBeat.i(184567);
        if (this.oXe) {
            Log.i("MicroMsg.FloatBallService", "hideFloatBall, has marked QB file view page, ignore hiding");
            AppMethodBeat.o(184567);
            return;
        }
        if (!chN() || this.oXd) {
            z2 = false;
        } else {
            z2 = true;
        }
        Log.i("MicroMsg.FloatBallService", "hideFloatBall forceHide: %b, canShowFloatBall: %b, videoBallInfo: %s", Boolean.valueOf(this.oXd), Boolean.valueOf(z2), ciC());
        if (z2) {
            AppMethodBeat.o(184567);
            return;
        }
        com.tencent.mm.plugin.ball.ui.d.ciX().e(z, animatorListenerAdapter);
        AppMethodBeat.o(184567);
    }

    private BallInfo ciC() {
        AppMethodBeat.i(216992);
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            for (BallInfo ballInfo : this.oVq) {
                if (com.tencent.mm.plugin.ball.f.d.H(ballInfo)) {
                    AppMethodBeat.o(216992);
                    return ballInfo;
                }
            }
        }
        AppMethodBeat.o(216992);
        return null;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void u(BallInfo ballInfo) {
        int i2;
        int i3;
        AppMethodBeat.i(216993);
        BallInfo ciC = ciC();
        if (ciC != null) {
            ciC.state = ballInfo.state;
            ciC.oWt = ballInfo.oWt;
            a aVar = com.tencent.mm.plugin.ball.ui.d.ciX().oYi;
            if (aVar.oXH != null) {
                FloatBallView floatBallView = aVar.oXH;
                Log.i("MicroMsg.FloatBallView", "alvinluo switchVoipVoice");
                if (ciC.oWt == null) {
                    Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo invalid and ignore");
                    AppMethodBeat.o(216993);
                    return;
                }
                Point point = new Point(ciC.oWt.oWv);
                if (floatBallView.Cc(floatBallView.oZZ)) {
                    boolean Ch = FloatBallView.Ch(floatBallView.oZZ);
                    boolean Ck = FloatBallView.Ck(floatBallView.oZZ);
                    point.x = floatBallView.h(Ch, Ck, true);
                    point.y = floatBallView.a(floatBallView.oZZ, Ch, Ck, true);
                }
                Point point2 = new Point(ciC.oWt.oWw);
                if (floatBallView.Cc(floatBallView.oZZ)) {
                    if (ciC.state == 8) {
                        point2.x = FloatBallView.paE + (FloatBallView.paQ * 2);
                        point2.y = FloatBallView.paF + (FloatBallView.paQ * 2);
                    } else if (ciC.state == 512 && point2.x < (i3 = FloatBallView.paA + (FloatBallView.paQ * 2))) {
                        point2.x = i3;
                    }
                }
                if (!FloatBallView.h(point) || !FloatBallView.h(point2)) {
                    Log.w("MicroMsg.FloatBallView", "switchVoip animationInfo size invalid and ignore");
                    AppMethodBeat.o(216993);
                    return;
                }
                floatBallView.pbQ = 80;
                int i4 = floatBallView.pbQ;
                if (floatBallView.pbC) {
                    i2 = 8388611;
                } else {
                    i2 = 8388613;
                }
                floatBallView.X(i2 | i4, true);
                FrameLayout frameLayout = floatBallView.paY;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
                Log.i("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch state: %d, startSize: %s, endSize: %s, current: %d, %d", Integer.valueOf(ciC.state), point, point2, Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(new AnimatorListenerAdapter(ciC, point, point2) {
                    /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass6 */
                    final /* synthetic */ BallInfo oVJ;
                    final /* synthetic */ Point pcc;
                    final /* synthetic */ Point pcd;

                    {
                        this.oVJ = r2;
                        this.pcc = r3;
                        this.pcd = r4;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(217073);
                        super.onAnimationEnd(animator);
                        if (this.oVJ.state == 512) {
                            FloatBallView.a(FloatBallView.this, 1024);
                            FloatBallView.c(FloatBallView.this);
                            FloatBallView.this.oWm = FloatBallView.this.pbL.oWt.oWw;
                        } else if (this.oVJ.state == 8) {
                            FloatBallView.a(FloatBallView.this, 16);
                            FloatBallView.this.pbN.x = Math.max(0, this.pcc.x - this.pcd.x);
                            FloatBallView.this.pbN.y = Math.max(0, this.pcc.y - this.pcd.y);
                            FloatBallView.this.oWm = FloatBallView.this.pbL.oWt.oWw;
                        }
                        Log.v("MicroMsg.FloatBallView", "animateVoipSwitch onAnimationEnd voipViewSize: %s, extraSize: %s", FloatBallView.this.oWm, FloatBallView.this.pbN);
                        AppMethodBeat.o(217073);
                    }
                });
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams, point, point2, frameLayout) {
                    /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass7 */
                    final /* synthetic */ View gPm;
                    final /* synthetic */ Point pcc;
                    final /* synthetic */ Point pcd;
                    final /* synthetic */ LinearLayout.LayoutParams pce;

                    {
                        this.pce = r2;
                        this.pcc = r3;
                        this.pcd = r4;
                        this.gPm = r5;
                    }

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(217075);
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.pce.width = (int) (((float) this.pcc.x) + (((float) (this.pcd.x - this.pcc.x)) * floatValue));
                        this.pce.height = (int) (((float) this.pcc.y) + (((float) (this.pcd.y - this.pcc.y)) * floatValue));
                        Log.v("MicroMsg.FloatBallView", "alvinluo animateVoipSwitch onAnimationUpdate value: %f, width: %d, height: %d", Float.valueOf(floatValue), Integer.valueOf(this.pce.width), Integer.valueOf(this.pce.height));
                        FloatBallView.this.cPw.post(new Runnable() {
                            /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass7.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(217074);
                                AnonymousClass7.this.gPm.setLayoutParams(AnonymousClass7.this.pce);
                                AppMethodBeat.o(217074);
                            }
                        });
                        AppMethodBeat.o(217075);
                    }
                });
                ofFloat.start();
            }
        }
        AppMethodBeat.o(216993);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184570);
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall, no float window permission");
            ciD();
            com.tencent.mm.plugin.ball.ui.d.ciX().ciZ();
            this.oXb = false;
            this.oVq.clear();
            e.ciJ().clear();
            ciH();
            AppMethodBeat.o(184570);
        } else if (!this.oXb) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall, restore data from storage");
            ciE();
            AppMethodBeat.o(184570);
        } else if (this.oXc && !chN()) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked no float ball page, ignore resuming");
            AppMethodBeat.o(184570);
        } else if (this.oXd) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall, has marked forceHideAllFloatBall, ignore resuming");
            AppMethodBeat.o(184570);
        } else if (this.oXf) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall, hasHideForKeyboardHeightChange, ignore resuming");
            AppMethodBeat.o(184570);
        } else if (!ciF()) {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall not singleBallInfoCondition, withAnimation:%s", Boolean.valueOf(z));
            com.tencent.mm.plugin.ball.ui.d.ciX().b(z, z2, animatorListenerAdapter);
            AppMethodBeat.o(184570);
        } else {
            Log.i("MicroMsg.FloatBallService", "resumeFloatBall singleBallInfoCondition, withAnimation:false");
            com.tencent.mm.plugin.ball.ui.d.ciX().b(false, z2, animatorListenerAdapter);
            c(this.oXm, true);
            AppMethodBeat.o(184570);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jN(boolean z) {
        AppMethodBeat.i(106103);
        jV(true);
        a(z, (AnimatorListenerAdapter) null);
        AppMethodBeat.o(106103);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jO(boolean z) {
        AppMethodBeat.i(106104);
        jV(false);
        a(z, true, (AnimatorListenerAdapter) null);
        AppMethodBeat.o(106104);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jP(boolean z) {
        AppMethodBeat.i(216994);
        com.tencent.mm.plugin.ball.ui.d.ciX().c(z, new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass1 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(216986);
                super.onAnimationEnd(animator);
                d.this.a((BallInfo) null, 1.0f);
                AppMethodBeat.o(216986);
            }
        });
        AppMethodBeat.o(216994);
    }

    private void ciD() {
        BallInfo ballInfo;
        AppMethodBeat.i(184571);
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            Iterator<BallInfo> it = this.oVq.iterator();
            while (true) {
                if (!it.hasNext()) {
                    ballInfo = null;
                    break;
                }
                ballInfo = it.next();
                if (ballInfo.type == 7) {
                    break;
                }
            }
            if (ballInfo != null) {
                Log.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, removed");
                l(ballInfo);
                AppMethodBeat.o(184571);
                return;
            }
            Log.i("MicroMsg.FloatBallService", "removeLocationBackgroundBallInfoIfNeed, ignore");
        }
        AppMethodBeat.o(184571);
    }

    private void ciE() {
        AppMethodBeat.i(184572);
        if (com.tencent.mm.kernel.g.aAc()) {
            e.ciJ();
            List<BallInfo> ciN = e.ciN();
            cb(ciN);
            this.oVq.clear();
            if (ao.isMultiTaskMode()) {
                this.oVq.addAll(com.tencent.mm.plugin.ball.f.d.ch(ciN));
            } else {
                this.oVq.addAll(ciN);
            }
            List<BallInfo> cg = com.tencent.mm.plugin.ball.f.d.cg(ciN);
            this.oWU.clear();
            this.oWU.addAll(cg);
            this.oXb = true;
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(184561);
                    d.a(d.this);
                    AppMethodBeat.o(184561);
                }
            }, 1000);
            AppMethodBeat.o(184572);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "restoreDataFromStorage, account not ready");
        AppMethodBeat.o(184572);
    }

    private static void cb(List<BallInfo> list) {
        AppMethodBeat.i(184573);
        Log.i("MicroMsg.FloatBallService", "restoreProcessNameWithFileType");
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(184573);
            return;
        }
        for (BallInfo ballInfo : list) {
            if (!(ballInfo == null || ballInfo.type != 4 || ballInfo.jkf == null)) {
                String string = ballInfo.jkf.getString("processName");
                if (!Util.isNullOrNil(string)) {
                    Log.i("MicroMsg.FloatBallService", "restore with process name: %s", string);
                    ballInfo.jkf.putString("processName", "");
                }
            }
        }
        AppMethodBeat.o(184573);
    }

    private boolean ciF() {
        AppMethodBeat.i(184574);
        BallInfo h2 = h(this.oXm);
        if (h2 == null || !com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            AppMethodBeat.o(184574);
            return false;
        }
        boolean f2 = com.tencent.mm.plugin.ball.f.d.f(this.oVq, h2);
        AppMethodBeat.o(184574);
        return f2;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chL() {
        AppMethodBeat.i(106105);
        Log.i("MicroMsg.FloatBallService", "onAccountInitialized:%s", Integer.valueOf(hashCode()));
        a(com.tencent.mm.plugin.ball.ui.d.ciX());
        a(e.ciJ());
        this.oXb = false;
        a(true, true, (AnimatorListenerAdapter) null);
        AppMethodBeat.o(106105);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void onAccountRelease() {
        AppMethodBeat.i(106106);
        Log.i("MicroMsg.FloatBallService", "onAccountRelease:%s", Integer.valueOf(hashCode()));
        b(com.tencent.mm.plugin.ball.ui.d.ciX());
        b(e.ciJ());
        this.oXb = false;
        com.tencent.mm.plugin.ball.ui.d.ciX().ciZ();
        AppMethodBeat.o(106106);
    }

    private void jV(boolean z) {
        AppMethodBeat.i(106107);
        Log.i("MicroMsg.FloatBallService", "markNoFloatBallPage:%s", Boolean.valueOf(z));
        this.oXc = z;
        AppMethodBeat.o(106107);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void Dw(boolean z) {
        AppMethodBeat.i(106108);
        Log.i("MicroMsg.FloatBallService", "markQBFileViewPage:%s", Boolean.valueOf(z));
        this.oXe = z;
        AppMethodBeat.o(106108);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chM() {
        return this.oXc;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chN() {
        AppMethodBeat.i(216995);
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            for (BallInfo ballInfo : this.oVq) {
                if (!ballInfo.nno && (com.tencent.mm.plugin.ball.f.d.H(ballInfo) || com.tencent.mm.plugin.ball.f.d.I(ballInfo))) {
                    AppMethodBeat.o(216995);
                    return true;
                }
            }
        }
        AppMethodBeat.o(216995);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chO() {
        return this.oXe;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void By(long j2) {
        this.oXh = j2;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final long dgY() {
        return this.oXh;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void chP() {
        AppMethodBeat.i(106109);
        Dw(false);
        jV(false);
        if (this.oXm != null) {
            Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, lastEnteredBallInfo:%s", this.oXm);
            q(h(this.oXm));
            AppMethodBeat.o(106109);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "fixFloatBallIfNeed, safe");
        AppMethodBeat.o(106109);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(final int i2, final int i3, boolean z, long j2) {
        boolean z2 = false;
        AppMethodBeat.i(184577);
        this.oXi = i2;
        this.oXj = i3;
        this.oXk = z;
        if (!com.tencent.mm.plugin.ball.ui.d.ciX().ciY()) {
            Log.i("MicroMsg.FloatBallService", "KeyboardHeightChanged, no float ball");
            AppMethodBeat.o(184577);
            return;
        }
        if (z) {
            jS(true);
        } else {
            jS(false);
        }
        if (j2 != 0) {
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(216987);
                    d.a(d.this, i2, i3, d.this.oXi != 0);
                    AppMethodBeat.o(216987);
                }
            }, j2);
            AppMethodBeat.o(184577);
            return;
        }
        if (this.oXi != 0) {
            z2 = true;
        }
        a(i2, i3, true, z2, null);
        AppMethodBeat.o(184577);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void dhp() {
        AppMethodBeat.i(106111);
        PlaySound.play(MMApplicationContext.getContext(), R.string.j06);
        AppMethodBeat.o(106111);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(i iVar) {
        AppMethodBeat.i(106112);
        if (com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            iVar.bH(new ArrayList(this.oVq));
            AppMethodBeat.o(106112);
            return;
        }
        iVar.bH(new ArrayList());
        AppMethodBeat.o(106112);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final List<BallInfo> chQ() {
        return this.oVq;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final List<BallInfo> chR() {
        return this.oWU;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final BallInfo h(BallInfo ballInfo) {
        BallInfo ballInfo2 = null;
        AppMethodBeat.i(106113);
        synchronized (this.oVq) {
            try {
                if (this.oVq.contains(ballInfo)) {
                    int indexOf = this.oVq.indexOf(ballInfo);
                    if (indexOf >= 0 && indexOf < this.oVq.size()) {
                        ballInfo2 = this.oVq.get(indexOf);
                        Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:true, responseBallInfo:%s", ballInfo2);
                        AppMethodBeat.o(106113);
                    }
                } else {
                    Log.i("MicroMsg.FloatBallService", "getBallInfo, existed:false");
                    AppMethodBeat.o(106113);
                }
            } finally {
                AppMethodBeat.o(106113);
            }
        }
        return ballInfo2;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean i(BallInfo ballInfo) {
        AppMethodBeat.i(106114);
        if (cip() >= 5) {
            Log.i("MicroMsg.FloatBallService", "canAddBallInfo, false");
            AppMethodBeat.o(106114);
            return false;
        }
        Log.i("MicroMsg.FloatBallService", "canAddBallInfo, true");
        AppMethodBeat.o(106114);
        return true;
    }

    private int cip() {
        AppMethodBeat.i(106115);
        List<BallInfo> cg = com.tencent.mm.plugin.ball.f.d.cg(this.oVq);
        if (com.tencent.mm.plugin.ball.f.d.h(cg)) {
            int size = cg.size();
            AppMethodBeat.o(106115);
            return size;
        }
        AppMethodBeat.o(106115);
        return 0;
    }

    private void z(BallInfo ballInfo) {
        AppMethodBeat.i(106117);
        if (!ballInfo.oWr && cip() >= 5) {
            Log.i("MicroMsg.FloatBallService", "addBallInfo, already add max count balls:%s", 5);
            FloatBallProxyUI.a(1, new FloatBallProxyUI.a() {
                /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a
                public final void eU(int i2, int i3) {
                    AppMethodBeat.i(216989);
                    Log.i("MicroMsg.FloatBallService", "addBallInfo, show reach count limit callback:%s, proxyMode: %d", Integer.valueOf(i3), Integer.valueOf(i2));
                    if (i3 == 1) {
                        Log.i("MicroMsg.FloatBallService", "addBallInfo, show float menu view");
                        d.ciG();
                    }
                    AppMethodBeat.o(216989);
                }
            });
            AppMethodBeat.o(106117);
        } else if (this.oVq.contains(ballInfo)) {
            Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:true, replaceExisted: %b, ballInfo:%s", Boolean.valueOf(ballInfo.oWq), ballInfo);
            if (ballInfo.oWq) {
                ballInfo.oWq = false;
                k(ballInfo);
            }
            AppMethodBeat.o(106117);
        } else if (!com.tencent.mm.plugin.ball.f.d.H(ballInfo) || !com.tencent.mm.plugin.ball.f.d.cn(this.oVq)) {
            long nowMilliSecond = Util.nowMilliSecond();
            ballInfo.oWp = nowMilliSecond;
            ballInfo.createTime = nowMilliSecond;
            ballInfo.oWs.opType = -1;
            if (ballInfo.type != 20) {
                ballInfo.oWs.hCZ = (!ballInfo.oWr || ballInfo.oWs.hCZ != 0) ? ballInfo.oWs.hCZ : 3;
            } else {
                ballInfo.oWs.hCZ = 5;
            }
            this.oVq.add(ballInfo);
            Log.i("MicroMsg.FloatBallService", "addBallInfo, existed:false, ballInfo:%s", ballInfo);
            if (!ballInfo.gqx) {
                b.a(ballInfo, this.oVq);
            }
            B(ballInfo);
            jW(true);
            Bundle bundle = new Bundle();
            bundle.putInt("type", ballInfo.type);
            bundle.putString("key", ballInfo.key);
            V(bundle);
            D(ballInfo);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).O(ballInfo);
            AppMethodBeat.o(106117);
        } else {
            Log.e("MicroMsg.FloatBallService", "addBallInfo video ball is already exist and can not add more");
            AppMethodBeat.o(106117);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void k(BallInfo ballInfo) {
        AppMethodBeat.i(106118);
        BallInfo h2 = h(ballInfo);
        if (h2 != null) {
            h2.w(ballInfo);
            Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:true, ballInfo:%s", h2);
            ciH();
            AppMethodBeat.o(106118);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "updateBallInfo, existed:false");
        AppMethodBeat.o(106118);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void l(BallInfo ballInfo) {
        AppMethodBeat.i(106119);
        if (this.oVq.contains(ballInfo)) {
            if (com.tencent.mm.plugin.ball.f.d.H(ballInfo)) {
                com.tencent.mm.plugin.ball.ui.d.ciX().ciS();
                ballInfo.vk = null;
            }
            this.oVq.remove(ballInfo);
            e.ciJ().l(ballInfo);
            b.b(ballInfo, this.oVq.isEmpty());
            Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:true, ballInfo:%s", ballInfo);
            if (this.oXm != null && this.oXm.equals(ballInfo)) {
                Log.i("MicroMsg.FloatBallService", "removeBallInfo, remove last enteredBallInfo");
                this.oXm = null;
            }
            C(ballInfo);
            jW(true);
            b(ballInfo, 3);
            E(ballInfo);
            ((com.tencent.mm.plugin.handoff.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).del(ballInfo.key);
            if (ballInfo.equals(this.oWZ)) {
                this.oWZ = null;
                AppMethodBeat.o(106119);
                return;
            }
        } else {
            Log.i("MicroMsg.FloatBallService", "removeBallInfo, existed:false");
        }
        AppMethodBeat.o(106119);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void t(BallInfo ballInfo) {
        boolean z;
        AppMethodBeat.i(216996);
        Object[] objArr = new Object[3];
        if (ballInfo == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = ballInfo;
        objArr[2] = this.oXa;
        Log.d("MicroMsg.FloatBallService", "alvinluo markMessageBallInfo ballInfo == null: %b, %s, readyInfo == null: %b", objArr);
        if (ballInfo != null) {
            if (this.oXa == null) {
                this.oXa = new BallInfo(20, ballInfo.key);
            }
            this.oXa.w(ballInfo);
            this.oXa.key = ballInfo.key;
            this.oXa.type = 20;
            this.oXa.state = 256;
            this.oXa.nno = false;
            this.oXa.oWr = true;
            this.oXa.crj = System.currentTimeMillis();
            if (ballInfo.type == 4 && this.oXa.jkf != null) {
                String string = this.oXa.jkf.getString("processName");
                if (!Util.isNullOrNil(string)) {
                    Log.d("MicroMsg.FloatBallService", "markMessageBallInfo reset processName: %s", string);
                    this.oXa.jkf.putString("processName", "");
                }
            }
        }
        AppMethodBeat.o(216996);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(long j2, b.a aVar) {
        int i2 = 1;
        AppMethodBeat.i(216997);
        if (this.oXa == null) {
            Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall readyMessageBallInfo is invalid");
            if (aVar != null) {
                aVar.BE(7);
            }
            AppMethodBeat.o(216997);
        } else if (!this.oXg && !this.oXe) {
            Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall isWechatForeground: %b", Boolean.valueOf(this.oXg));
            if (aVar != null) {
                aVar.BE(6);
            }
            this.oXa = null;
            AppMethodBeat.o(216997);
        } else if (!com.tencent.mm.plugin.ball.f.d.a(this.oXa, j2)) {
            Log.w("MicroMsg.FloatBallService", "alvinluo addMessageBall can not add message ball because of time over limit");
            if (aVar != null) {
                aVar.BE(5);
            }
            this.oXa = null;
            AppMethodBeat.o(216997);
        } else {
            if (this.oWZ == null) {
                this.oWZ = new BallInfo(20, this.oXa.key);
                this.oWZ.w(this.oXa);
                Log.i("MicroMsg.FloatBallService", "alvinluo addMessageBall existed: false, and add: %s", this.oWZ);
                j(this.oWZ);
            } else {
                BallInfo ballInfo = this.oXa;
                if (this.oWZ == null) {
                    Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo is null and ignore");
                } else if (h(this.oWZ) != null) {
                    this.oWZ.w(ballInfo);
                    this.oWZ.key = ballInfo.key;
                    Log.i("MicroMsg.FloatBallService", "alvinluo updateMessageBall existed: true, and update %s", this.oWZ);
                    k(this.oWZ);
                } else {
                    Log.w("MicroMsg.FloatBallService", "alvinluo updateMessageBall messageBallInfo not null but not added!!");
                }
                if (this.oWZ != null && !this.oWZ.gqx) {
                    this.oWZ.oWs.hCZ = 6;
                    b.a(this.oWZ, this.oVq);
                }
                i2 = 2;
            }
            this.oXa = null;
            if (aVar != null) {
                aVar.BE(i2);
            }
            AppMethodBeat.o(216997);
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void BD(int i2) {
        AppMethodBeat.i(216998);
        if (this.oWZ != null && this.oWZ.beK == i2) {
            Log.i("MicroMsg.FloatBallService", "alvinluo removeMessageBall type: %d", Integer.valueOf(i2));
            l(this.oWZ);
        }
        AppMethodBeat.o(216998);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void n(BallInfo ballInfo) {
        AppMethodBeat.i(106120);
        if (this.oVq.contains(ballInfo)) {
            Set<e> set = this.oWX.get(ballInfo.type);
            if (com.tencent.mm.plugin.ball.f.d.h(set)) {
                for (e eVar : set) {
                    eVar.d(ballInfo);
                }
            }
            Set<e> set2 = this.oWX.get(0);
            if (com.tencent.mm.plugin.ball.f.d.h(set2)) {
                for (e eVar2 : set2) {
                    eVar2.d(ballInfo);
                }
            }
            AppMethodBeat.o(106120);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "exposeBallInfo, existed:false");
        AppMethodBeat.o(106120);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final Point getBallPosition() {
        Point point;
        AppMethodBeat.i(106121);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            a aVar = ciX.oYi;
            point = aVar.oXH != null ? aVar.oXH.getBallPosition() : new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
        } else {
            point = new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
        }
        if (point == null) {
            point = new Point(com.tencent.mm.plugin.ball.f.d.cjg(), com.tencent.mm.plugin.ball.f.d.cjh());
        }
        Log.i("MicroMsg.FloatBallService", "getBallPosition, position:[%s, %s]", Integer.valueOf(point.x), Integer.valueOf(point.y));
        AppMethodBeat.o(106121);
        return point;
    }

    public final void a(BallInfo ballInfo, float f2) {
        AppMethodBeat.i(106122);
        if (f2 == 1.0f || com.tencent.mm.plugin.ball.f.d.f(this.oVq, ballInfo)) {
            MMHandlerThread.postToMainThread(new Runnable(f2) {
                /* class com.tencent.mm.plugin.ball.ui.d.AnonymousClass2 */
                final /* synthetic */ float oYm;

                {
                    this.oYm = r2;
                }

                public final void run() {
                    AppMethodBeat.i(106304);
                    if (d.this.ciY()) {
                        a aVar = d.this.oYi;
                        float f2 = this.oYm;
                        if (aVar.oXH != null) {
                            aVar.oXH.setFloatBallAlpha(f2);
                        }
                    }
                    AppMethodBeat.o(106304);
                }
            });
        }
        AppMethodBeat.o(106122);
    }

    public static void ciG() {
        AppMethodBeat.i(106123);
        com.tencent.mm.plugin.ball.ui.d.ciX().a(false, (ResultReceiver) null);
        AppMethodBeat.o(106123);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(ResultReceiver resultReceiver) {
        AppMethodBeat.i(216999);
        com.tencent.mm.plugin.ball.ui.d.ciX().a(true, resultReceiver);
        AppMethodBeat.o(216999);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void r(BallInfo ballInfo) {
        AppMethodBeat.i(217000);
        if (ballInfo != null) {
            b.a(ballInfo, this.oVq);
        }
        AppMethodBeat.o(217000);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void o(BallInfo ballInfo) {
        AppMethodBeat.i(258545);
        c(ballInfo, true);
        AppMethodBeat.o(258545);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void p(BallInfo ballInfo) {
        AppMethodBeat.i(106126);
        c(ballInfo, false);
        AppMethodBeat.o(106126);
    }

    /* access modifiers changed from: package-private */
    public final void c(BallInfo ballInfo, boolean z) {
        AppMethodBeat.i(106127);
        BallInfo h2 = h(ballInfo);
        if (h2 != null) {
            h2.oWp = Util.nowMilliSecond();
            this.oXm = h2;
            Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, set lastEnteredBallInfo:%s", this.oXm.cif());
            jW(z);
            AppMethodBeat.o(106127);
            return;
        }
        Object[] objArr = new Object[1];
        objArr[0] = ballInfo != null ? ballInfo.cif() : BuildConfig.COMMAND;
        Log.i("MicroMsg.FloatBallService", "onEnterBallInfoPage, no this ball info:%s", objArr);
        AppMethodBeat.o(106127);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void q(BallInfo ballInfo) {
        AppMethodBeat.i(106128);
        Object[] objArr = new Object[1];
        objArr[0] = this.oXm != null ? this.oXm.cif() : BuildConfig.COMMAND;
        Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, lastEnteredBallInfo:%s", objArr);
        this.oXm = null;
        BallInfo h2 = h(ballInfo);
        if (h2 != null) {
            Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, ballInfo:%s", h2);
            if (h2.oWs.opType == -1) {
                h2.oWs.opType = 0;
            } else {
                b.y(h2);
            }
            if (com.tencent.mm.plugin.ball.ui.d.ciX().ciT()) {
                A(ballInfo);
            } else if (!this.oXd) {
                a(ballInfo, 1.0f);
            }
            if (h2.nno) {
                h2.nno = false;
                ciH();
                AppMethodBeat.o(106128);
                return;
            }
        } else {
            Log.i("MicroMsg.FloatBallService", "onExitBallInfoPage, no this ball info");
            A(ballInfo);
        }
        AppMethodBeat.o(106128);
    }

    private void A(final BallInfo ballInfo) {
        AppMethodBeat.i(217002);
        com.tencent.mm.plugin.ball.ui.d.ciX().c(true, (AnimatorListenerAdapter) new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass6 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(216990);
                super.onAnimationEnd(animator);
                if (!d.this.oXd) {
                    d.this.a(ballInfo, 1.0f);
                }
                AppMethodBeat.o(216990);
            }
        });
        AppMethodBeat.o(217002);
    }

    private void jW(boolean z) {
        AppMethodBeat.i(106129);
        BallInfo h2 = h(this.oXm);
        if (h2 == null || !com.tencent.mm.plugin.ball.f.d.h(this.oVq)) {
            Object[] objArr = new Object[1];
            objArr[0] = this.oXm != null ? this.oXm.cif() : BuildConfig.COMMAND;
            Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, last enteredBallInfo:%s", objArr);
        } else if (com.tencent.mm.plugin.ball.f.d.e(this.oVq, h2)) {
            Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, has other balls, hidden current ball info");
            boolean ciT = com.tencent.mm.plugin.ball.ui.d.ciX().ciT();
            Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, canNotShowFloatBall:%s, withFloatBall:%s", Boolean.valueOf(ciT), Boolean.valueOf(z));
            if (!ciT && z) {
                a(h2, 1.0f);
            }
            for (BallInfo ballInfo : this.oVq) {
                if (!ballInfo.oWr && ballInfo.nno && !ballInfo.equals(h2)) {
                    ballInfo.nno = false;
                    b(ballInfo, 4);
                } else if (ballInfo.equals(h2)) {
                    ballInfo.nno = true;
                }
            }
        } else if (com.tencent.mm.plugin.ball.f.d.f(this.oVq, h2)) {
            Log.i("MicroMsg.FloatBallService", "recheckBallInfoList, no other balls, make float ball transparent");
            h2.nno = false;
            a(h2, 0.0f);
        }
        ciH();
        AppMethodBeat.o(106129);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(BallInfo ballInfo, boolean z) {
        AppMethodBeat.i(106130);
        BallInfo h2 = h(ballInfo);
        if (h2 != null) {
            h2.nno = !z;
            Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:true, visible:%s, ballInfo:%s", Boolean.valueOf(z), h2);
            ciH();
            AppMethodBeat.o(106130);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "updateBallVisibility, existed:false");
        AppMethodBeat.o(106130);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(int i2, e eVar) {
        AppMethodBeat.i(106131);
        Log.i("MicroMsg.FloatBallService", "addFloatBallInfoEventListener, type:%s", Integer.valueOf(i2));
        if (eVar != null) {
            Set<e> set = this.oWX.get(i2);
            if (set == null) {
                set = new HashSet<>();
                this.oWX.put(i2, set);
            }
            set.add(eVar);
        }
        AppMethodBeat.o(106131);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(int i2, e eVar) {
        Set<e> set;
        AppMethodBeat.i(106132);
        Log.i("MicroMsg.FloatBallService", "removeFloatBallInfoEventListener, type:%s", Integer.valueOf(i2));
        if (!(eVar == null || (set = this.oWX.get(i2)) == null)) {
            set.remove(eVar);
        }
        AppMethodBeat.o(106132);
    }

    private void B(BallInfo ballInfo) {
        AppMethodBeat.i(217003);
        Log.d("MicroMsg.FloatBallService", "onFloatBallAdded %s", ballInfo);
        com.tencent.mm.plugin.ball.ui.d.ciX().a(this.oVq.size(), ballInfo);
        AppMethodBeat.o(217003);
    }

    private void C(BallInfo ballInfo) {
        AppMethodBeat.i(217004);
        com.tencent.mm.plugin.ball.ui.d.ciX().b(this.oVq.size(), ballInfo);
        AppMethodBeat.o(217004);
    }

    private void D(BallInfo ballInfo) {
        AppMethodBeat.i(217005);
        int size = this.oWX.size();
        for (int i2 = 0; i2 < size; i2++) {
            Set<e> set = this.oWX.get(this.oWX.keyAt(i2));
            if (com.tencent.mm.plugin.ball.f.d.h(set)) {
                for (e eVar : set) {
                    eVar.g(ballInfo);
                }
            }
        }
        AppMethodBeat.o(217005);
    }

    private void E(BallInfo ballInfo) {
        AppMethodBeat.i(106133);
        Set<e> set = this.oWX.get(ballInfo.type);
        if (com.tencent.mm.plugin.ball.f.d.h(set)) {
            for (e eVar : set) {
                eVar.c(ballInfo);
            }
        }
        Set<e> set2 = this.oWX.get(0);
        if (com.tencent.mm.plugin.ball.f.d.h(set2)) {
            for (e eVar2 : set2) {
                eVar2.c(ballInfo);
            }
        }
        AppMethodBeat.o(106133);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(BallInfo ballInfo, ResultReceiver resultReceiver) {
        AppMethodBeat.i(106134);
        if (!(ballInfo == null || resultReceiver == null)) {
            String cif = ballInfo.cif();
            Log.i("MicroMsg.FloatBallService", "registerFloatBallEventReceiver, key:%s, receiver:%s", cif, Integer.valueOf(resultReceiver.hashCode()));
            this.oWY.put(cif, resultReceiver);
        }
        AppMethodBeat.o(106134);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void s(BallInfo ballInfo) {
        AppMethodBeat.i(106135);
        if (ballInfo != null) {
            String cif = ballInfo.cif();
            ResultReceiver remove = this.oWY.remove(cif);
            Object[] objArr = new Object[2];
            objArr[0] = cif;
            objArr[1] = remove != null ? Integer.valueOf(remove.hashCode()) : null;
            Log.i("MicroMsg.FloatBallService", "removeFloatBallEventReceiver, key:%s, receiver:%s", objArr);
        }
        AppMethodBeat.o(106135);
    }

    private void b(BallInfo ballInfo, int i2) {
        AppMethodBeat.i(106136);
        String cif = ballInfo.cif();
        ResultReceiver resultReceiver = this.oWY.get(cif);
        if (resultReceiver != null) {
            Log.i("MicroMsg.FloatBallService", "notifyResultReceiver, event:%s, ballInfoHashKey:%s, receiver:%s", Integer.valueOf(i2), cif, Integer.valueOf(resultReceiver.hashCode()));
            resultReceiver.send(i2, new Bundle());
        }
        AppMethodBeat.o(106136);
    }

    private void V(Bundle bundle) {
        AppMethodBeat.i(217006);
        for (ResultReceiver resultReceiver : this.oWY.values()) {
            resultReceiver.send(1, bundle);
        }
        AppMethodBeat.o(217006);
    }

    private void cc(List<BallInfo> list) {
        int size;
        AppMethodBeat.i(106137);
        if (!this.oWY.isEmpty() && this.oXn != (size = com.tencent.mm.plugin.ball.f.d.cg(list).size())) {
            this.oXn = size;
            Bundle bundle = new Bundle();
            bundle.putInt("ActiveCount", size);
            for (ResultReceiver resultReceiver : this.oWY.values()) {
                resultReceiver.send(5, bundle);
            }
        }
        AppMethodBeat.o(106137);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(com.tencent.mm.plugin.ball.c.d dVar) {
        AppMethodBeat.i(106138);
        this.oWV.add(dVar);
        AppMethodBeat.o(106138);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(com.tencent.mm.plugin.ball.c.d dVar) {
        AppMethodBeat.i(106139);
        this.oWV.remove(dVar);
        AppMethodBeat.o(106139);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void a(com.tencent.mm.plugin.ball.c.g gVar) {
        AppMethodBeat.i(217007);
        this.oWW.add(gVar);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            ciX.oYi.a(gVar);
        }
        AppMethodBeat.o(217007);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void b(com.tencent.mm.plugin.ball.c.g gVar) {
        AppMethodBeat.i(217008);
        this.oWW.remove(gVar);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            a aVar = ciX.oYi;
            if (aVar.oXH != null) {
                aVar.oXH.listeners.remove(gVar);
            }
        }
        AppMethodBeat.o(217008);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final Set<com.tencent.mm.plugin.ball.c.g> chS() {
        return this.oWW;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean chT() {
        AppMethodBeat.i(217009);
        com.tencent.mm.plugin.ball.ui.d ciX = com.tencent.mm.plugin.ball.ui.d.ciX();
        if (ciX.ciY()) {
            a aVar = ciX.oYi;
            if (aVar.oXH != null) {
                boolean z = aVar.oXH.pbC;
                AppMethodBeat.o(217009);
                return z;
            }
            AppMethodBeat.o(217009);
            return false;
        }
        e.ciJ();
        boolean ciM = e.ciM();
        AppMethodBeat.o(217009);
        return ciM;
    }

    private void ciH() {
        AppMethodBeat.i(106140);
        List<BallInfo> cd = com.tencent.mm.plugin.ball.f.d.cd(new Vector(this.oVq));
        Log.i("MicroMsg.FloatBallService", "notifyFloatBallInfoChanged, originSize: %d, sortedSize: %d, ballInfoList:%s", Integer.valueOf(this.oVq.size()), Integer.valueOf(cd.size()), cd);
        for (com.tencent.mm.plugin.ball.c.d dVar : this.oWV) {
            dVar.a(cd, this.oXm);
            cc(cd);
        }
        AppMethodBeat.o(106140);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundrunning.g.a
    public final void a(List<AppBrandBackgroundRunningApp> list, AppBrandBackgroundRunningOperationParcel appBrandBackgroundRunningOperationParcel, int i2) {
        AppMethodBeat.i(106141);
        Log.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation:%s, change:%s", appBrandBackgroundRunningOperationParcel, Integer.valueOf(i2));
        if (i2 == 0) {
            AppMethodBeat.o(106141);
        } else if (appBrandBackgroundRunningOperationParcel.dDe == 2 || appBrandBackgroundRunningOperationParcel.dDe == 3) {
            if ((appBrandBackgroundRunningOperationParcel.beL & 2) > 0) {
                F(new BallInfo(7, com.tencent.mm.plugin.ball.f.b.cB(appBrandBackgroundRunningOperationParcel.appId, appBrandBackgroundRunningOperationParcel.iOo)));
            }
            if ((appBrandBackgroundRunningOperationParcel.beL & 4) > 0) {
                String str = appBrandBackgroundRunningOperationParcel.appId;
                int i3 = appBrandBackgroundRunningOperationParcel.iOo;
                F(new BallInfo(17, String.format(Locale.US, "%s#%d", str, Integer.valueOf(i3))));
            }
            if ((appBrandBackgroundRunningOperationParcel.beL & 8) > 0) {
                F(new BallInfo(18, com.tencent.mm.plugin.ball.f.b.cA(appBrandBackgroundRunningOperationParcel.appId, appBrandBackgroundRunningOperationParcel.iOo)));
            }
            if ((appBrandBackgroundRunningOperationParcel.beL & 16) > 0) {
                F(new BallInfo(19, com.tencent.mm.plugin.ball.f.b.cA(appBrandBackgroundRunningOperationParcel.appId, appBrandBackgroundRunningOperationParcel.iOo)));
            }
            AppMethodBeat.o(106141);
        } else {
            Log.i("MicroMsg.FloatBallService", "onBackgroundRunningAppChanged, operation ignored");
            AppMethodBeat.o(106141);
        }
    }

    private void F(BallInfo ballInfo) {
        AppMethodBeat.i(217010);
        BallInfo h2 = h(ballInfo);
        if (h2 != null && h2.oWr) {
            Log.i("MicroMsg.FloatBallService", "removeAppBrandPassiveBallInfo, remove existedBallInfo:%s", h2);
            h2.oWs.opType = 10;
            l(h2);
        }
        AppMethodBeat.o(217010);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final boolean c(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184579);
        if (!com.tencent.mm.plugin.ball.ui.d.ciX().ciY()) {
            Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition, no float ball");
            AppMethodBeat.o(184579);
            return false;
        } else if (!this.oXk) {
            Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByPosition keyboard not show and ignore");
            AppMethodBeat.o(184579);
            return false;
        } else {
            boolean a2 = a(this.oXi, this.oXj, false, false, animatorListenerAdapter);
            AppMethodBeat.o(184579);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void BC(int i2) {
        this.displayHeight = i2;
    }

    private boolean a(int i2, int i3, boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        boolean z3;
        AppMethodBeat.i(184580);
        boolean chN = chN();
        Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight needShowFloatBall: %b", Boolean.valueOf(chN));
        if (!chN || this.oXk || !this.oXf) {
            int ciI = ciI();
            int positionY = com.tencent.mm.plugin.ball.ui.d.ciX().getPositionY();
            if ((z2 ? i3 : 0) + positionY + ciI + i2 < this.displayHeight || i2 <= 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            Log.i("MicroMsg.FloatBallService", "updateBallVisibilityByKbHeight, ballPositionY:[%s, %s], keyboardHeight:%s, screenHeight:%s, extraHeight: %d, hide: %b, checkBottomShadow: %b, checkExtraHeight: %b", Integer.valueOf(positionY), Integer.valueOf(ciI), Integer.valueOf(i2), Integer.valueOf(this.displayHeight), Integer.valueOf(i3), Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(z2));
            if (z3) {
                this.oXf = true;
                a(true, animatorListenerAdapter);
                AppMethodBeat.o(184580);
                return true;
            } else if (this.oXf) {
                this.oXf = false;
                a(true, true, animatorListenerAdapter);
                AppMethodBeat.o(184580);
                return true;
            } else {
                AppMethodBeat.o(184580);
                return false;
            }
        } else {
            this.oXf = false;
            if (this.oXl == null || this.oXl.getVisibility() == 0) {
                Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip and visible, not need to show");
                AppMethodBeat.o(184580);
                return false;
            }
            Log.d("MicroMsg.FloatBallService", "alvinluo updateBallVisibilityByKbHeight has voip but not visible and delay show animation");
            this.oXl.setVisibility(0);
            this.oXl.setAlpha(0.0f);
            a(true, false, animatorListenerAdapter);
            AppMethodBeat.o(184580);
            return true;
        }
    }

    private int ciI() {
        AppMethodBeat.i(184581);
        int i2 = com.tencent.mm.plugin.ball.f.e.oYK + com.tencent.mm.plugin.ball.f.e.oYL + com.tencent.mm.plugin.ball.f.e.oYM;
        if (this.oXl != null) {
            i2 = Math.max(this.oXl.getMeasuredHeight(), i2);
        }
        AppMethodBeat.o(184581);
        return i2;
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void jM(boolean z) {
        AppMethodBeat.i(106102);
        a(z, true, (AnimatorListenerAdapter) null);
        AppMethodBeat.o(106102);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void j(final BallInfo ballInfo) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(106116);
        if (ballInfo.type == 6 && ballInfo.oWs.oWx == 11) {
            z = true;
        } else {
            z = false;
        }
        if (!z || com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            int i2 = ballInfo.type;
            if (i2 == 7) {
                Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: location");
            } else if (i2 == 17) {
                Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: appbrand_voip");
            } else if (i2 == 18) {
                Log.i("MicroMsg.FloatBallService", "shouldCheckPermissionWhenAddBallInfo, ignore for ballType: audio_of_video_background_play");
            } else {
                z2 = true;
            }
            if (z2) {
                c.a(MMApplicationContext.getContext(), ballInfo.type, true, (c.a) new c.a() {
                    /* class com.tencent.mm.plugin.ball.service.d.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.ball.f.c.a
                    public final void ha(boolean z) {
                        AppMethodBeat.i(216988);
                        if (z) {
                            d.a(d.this, ballInfo);
                            AppMethodBeat.o(216988);
                            return;
                        }
                        Log.w("MicroMsg.FloatBallService", "no float window permission");
                        AppMethodBeat.o(216988);
                    }
                });
                AppMethodBeat.o(106116);
                return;
            }
            z(ballInfo);
            AppMethodBeat.o(106116);
            return;
        }
        Log.i("MicroMsg.FloatBallService", "isAskForPermissionAlready, no permission & no ask for");
        AppMethodBeat.o(106116);
    }

    @Override // com.tencent.mm.plugin.ball.c.b
    public final void m(BallInfo ballInfo) {
        AppMethodBeat.i(106124);
        int i2 = ballInfo.oWs.opType;
        if (!(i2 == 1 || i2 == 2 || i2 == 3)) {
            Log.w("MicroMsg.FloatBallReportLogic", "activeBallTypeReport unexpected opType:%d", Integer.valueOf(ballInfo.oWs.opType));
            ballInfo.oWs.opType = 3;
        }
        b.a(ballInfo, Util.nowMilliSecond() - ballInfo.oWp, 0, 0, 0);
        c(ballInfo, true);
        int i3 = ballInfo.type;
        if (i3 == 20) {
            i3 = ballInfo.beK;
        }
        Log.d("MicroMsg.FloatBallService", "alvinluo notifySingleBallInfoClicked type: %d, contentType: %d", Integer.valueOf(i3), Integer.valueOf(ballInfo.beK));
        Set<e> set = this.oWX.get(i3);
        if (com.tencent.mm.plugin.ball.f.d.h(set)) {
            for (e eVar : set) {
                eVar.b(ballInfo);
            }
        }
        Set<e> set2 = this.oWX.get(0);
        if (com.tencent.mm.plugin.ball.f.d.h(set2)) {
            for (e eVar2 : set2) {
                eVar2.b(ballInfo);
            }
        }
        AppMethodBeat.o(106124);
    }
}
