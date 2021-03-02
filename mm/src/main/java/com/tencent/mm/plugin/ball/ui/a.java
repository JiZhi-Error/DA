package com.tencent.mm.plugin.ball.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.d.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.ball.view.FloatBallView;
import com.tencent.mm.plugin.ball.view.FloatMenuView;
import com.tencent.mm.plugin.ball.view.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Set;

public final class a {
    int displayHeight = 0;
    private int lastOrientation = 1;
    b oWG;
    public FloatBallView oXH;
    FloatMenuView oXI;
    private c oXJ;
    public boolean oXK;
    final com.tencent.mm.plugin.ball.e.a oXL;
    boolean oXM = false;
    private WindowManager windowManager;

    public a(Context context) {
        AppMethodBeat.i(106273);
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.oWG = (b) g.af(b.class);
        this.oXL = new com.tencent.mm.plugin.ball.e.a();
        this.displayHeight = com.tencent.mm.cb.a.jo(context);
        this.oWG.BC(this.displayHeight);
        this.oXH = new FloatBallView(context);
        this.oWG.dn(this.oXH);
        this.oXJ = new c(context);
        this.oXH.setInnerView(this.oXJ.oZK);
        this.oXH.a(new com.tencent.mm.plugin.ball.c.g() {
            /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void chY() {
                AppMethodBeat.i(184602);
                Log.i("MicroMsg.FloatBallContainer", "onBallClicked");
                a.this.oXL.iOB = Util.nowMilliSecond();
                a.this.oXH.b(false, null);
                a.this.oXI.setInLongPressMode(false);
                a.this.oXI.cjD();
                AppMethodBeat.o(184602);
            }

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void chZ() {
                AppMethodBeat.i(184603);
                Log.i("MicroMsg.FloatBallContainer", "onBallLongPressed");
                a.this.oXL.iOB = Util.nowMilliSecond();
                a.this.oXH.b(false, null);
                a.this.oXI.setInLongPressMode(true);
                a.this.oXI.cjD();
                AppMethodBeat.o(184603);
            }

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.plugin.ball.c.g
            public final void M(MotionEvent motionEvent) {
                AppMethodBeat.i(184604);
                Log.i("MicroMsg.FloatBallContainer", "onBallLongPressTouchEvent");
                FloatMenuView floatMenuView = a.this.oXI;
                if (floatMenuView.oVp) {
                    switch (motionEvent.getAction()) {
                        case 1:
                            floatMenuView.P(motionEvent);
                            if (floatMenuView.pcC == null || !(floatMenuView.pcC.getTag() instanceof BallInfo)) {
                                Log.i("MicroMsg.FloatMenuView", "no lastTouchedItemView, call back pressed");
                                floatMenuView.cjK();
                            } else {
                                FloatMenuView.dp(floatMenuView.pcC);
                                BallInfo ballInfo = (BallInfo) floatMenuView.pcC.getTag();
                                if (ballInfo.oWr) {
                                    Log.i("MicroMsg.FloatMenuView", "passive ballInfo, call back pressed");
                                    floatMenuView.cjK();
                                } else {
                                    ballInfo.oWs.opType = 2;
                                    floatMenuView.M(ballInfo);
                                }
                            }
                            floatMenuView.oVp = false;
                            floatMenuView.pcC = null;
                            floatMenuView.pcD = -1;
                            AppMethodBeat.o(184604);
                            return;
                        case 2:
                            floatMenuView.P(motionEvent);
                            AppMethodBeat.o(184604);
                            return;
                        case 3:
                            Log.i("MicroMsg.FloatMenuView", "onBallLongPressTouchEvent, CANCEL(%s, %s)", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
                            break;
                    }
                }
                AppMethodBeat.o(184604);
            }

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void cia() {
                AppMethodBeat.i(184605);
                Log.i("MicroMsg.FloatBallContainer", "onBallDragStart needProcessFloatViewFlags: %b", Boolean.valueOf(a.this.oXK));
                if (a.this.oXK) {
                    a.this.chW();
                }
                AppMethodBeat.o(184605);
            }

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void cib() {
                AppMethodBeat.i(184606);
                Log.i("MicroMsg.FloatBallContainer", "onBallDragEnd needProcessFloatViewFlags: %b", Boolean.valueOf(a.this.oXK));
                if (a.this.oXK && a.this.oWG != null && !a.this.oWG.c(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass3.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(184601);
                        super.onAnimationEnd(animator);
                        a.this.chX();
                        AppMethodBeat.o(184601);
                    }
                })) {
                    a.this.chX();
                }
                AppMethodBeat.o(184606);
            }

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void a(int i2, int i3, int i4, boolean z, boolean z2) {
                AppMethodBeat.i(184607);
                if (z) {
                    Log.i("MicroMsg.FloatBallContainer", "onBallSettled, x:%s, y:%s, height:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    FloatMenuView floatMenuView = a.this.oXI;
                    floatMenuView.oVo = z2;
                    if (!(i2 == floatMenuView.pco && i3 == floatMenuView.pcp && i4 == floatMenuView.pcB)) {
                        Log.i("MicroMsg.FloatMenuView", "onBallPositionChanged, position:[%s, %s], height:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        floatMenuView.pcB = i4;
                        floatMenuView.post(new Runnable(i2, i3, z2) {
                            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass5 */
                            final /* synthetic */ boolean pcM;
                            final /* synthetic */ int val$x;
                            final /* synthetic */ int val$y;

                            {
                                this.val$x = r2;
                                this.val$y = r3;
                                this.pcM = r4;
                            }

                            public final void run() {
                                AppMethodBeat.i(217117);
                                FloatMenuView.a(FloatMenuView.this, this.val$x, this.val$y);
                                if (FloatMenuView.this.pcr != null) {
                                    FloatMenuView.this.pcr.oVo = this.pcM;
                                    FloatMenuView.this.pcr.atj.notifyChanged();
                                }
                                AppMethodBeat.o(217117);
                            }
                        });
                    }
                    e.ciJ();
                    if (i2 != e.oXw) {
                        e.oXw = i2;
                        MultiProcessMMKV.getMMKV(e.cik()).encode("pos_x", e.oXw);
                    }
                    if (i3 != e.oXx) {
                        e.oXx = i3;
                        MultiProcessMMKV.getMMKV(e.cik()).encode("pos_y", e.oXx);
                    }
                    if (z2 != e.oXy) {
                        e.oXy = z2;
                        MultiProcessMMKV.getMMKV(e.cik()).encode("dock_left", e.oXy);
                    }
                }
                AppMethodBeat.o(184607);
            }

            @Override // com.tencent.mm.plugin.ball.c.g
            public final void onOrientationChange(int i2) {
                AppMethodBeat.i(184608);
                a.a(a.this, i2);
                AppMethodBeat.o(184608);
            }
        });
        this.oXI = new FloatMenuView(context);
        FloatMenuView floatMenuView = this.oXI;
        floatMenuView.pcu.add(new com.tencent.mm.plugin.ball.d.c() {
            /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.ball.d.c
            public final void cic() {
                AppMethodBeat.i(106259);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V", this);
                Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackgroundClicked");
                a.this.oXL.BF(2);
                a.a(a.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackgroundClicked", "()V");
                AppMethodBeat.o(106259);
            }

            @Override // com.tencent.mm.plugin.ball.d.c
            public final void cid() {
                AppMethodBeat.i(106260);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V", this);
                Log.i("MicroMsg.FloatBallContainer", "onFloatMenuBackPressed");
                a.this.oXL.BF(5);
                a.a(a.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuBackPressed", "()V");
                AppMethodBeat.o(106260);
            }

            @Override // com.tencent.mm.plugin.ball.d.c
            public final void onOrientationChange(int i2) {
                AppMethodBeat.i(106261);
                a.a(a.this, i2);
                AppMethodBeat.o(106261);
            }

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void v(final BallInfo ballInfo) {
                AppMethodBeat.i(106262);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(ballInfo);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", this, bVar.axR());
                Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemClicked");
                a.this.oXL.BF(3);
                a.this.oXI.e(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass1.AnonymousClass1 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(106256);
                        super.onAnimationStart(animator);
                        a.this.oXH.cjy();
                        AppMethodBeat.o(106256);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(106257);
                        super.onAnimationEnd(animator);
                        a.this.oWG.m(ballInfo);
                        AppMethodBeat.o(106257);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(106258);
                        super.onAnimationEnd(animator);
                        a.this.oWG.m(ballInfo);
                        AppMethodBeat.o(106258);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V");
                AppMethodBeat.o(106262);
            }

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void a(BallInfo ballInfo, int i2) {
                AppMethodBeat.i(106263);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(ballInfo);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V", this, bVar.axR());
                Log.i("MicroMsg.FloatBallContainer", "onFloatMenuItemRemoved");
                ballInfo.oWs.opType = 9;
                a.this.oWG.l(ballInfo);
                if (!ballInfo.oWr && a.this.oXM) {
                    a.this.oXL.BF(4);
                    a.this.oXI.setCanAddFloatBallWhenHide(true);
                    a.a(a.this);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/ui/FloatBallContainer$1", "com/tencent/mm/plugin/ball/listener/OnFloatMenuViewListener", "onFloatMenuItemRemoved", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;I)V");
                AppMethodBeat.o(106263);
            }

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void d(BallInfo ballInfo) {
                AppMethodBeat.i(106264);
                a.this.oWG.n(ballInfo);
                AppMethodBeat.o(106264);
            }
        });
        this.oXI.setOnMeasuredListener(new d() {
            /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ball.d.d
            public final void cie() {
                AppMethodBeat.i(184600);
                Log.d("MicroMsg.FloatBallContainer", "alvinluo onMeasure floatMenuView height: %d", Integer.valueOf(a.this.oXI.getMeasuredHeight()));
                if (a.this.oXI.getMeasuredHeight() != a.this.displayHeight) {
                    a.this.displayHeight = a.this.oXI.getMeasuredHeight();
                    a.this.oWG.BC(a.this.displayHeight);
                }
                AppMethodBeat.o(184600);
            }
        });
        AppMethodBeat.o(106273);
    }

    /* access modifiers changed from: package-private */
    public final void ciR() {
        AppMethodBeat.i(106274);
        boolean z = AppForegroundDelegate.INSTANCE.cPB;
        boolean chO = this.oWG.chO();
        boolean chM = this.oWG.chM();
        Log.i("MicroMsg.FloatBallContainer", "checkShowFloatBallIfNeed, isAppForeground:%s, isQBFileViewPage:%s, isNoFloatBallPage", Boolean.valueOf(z), Boolean.valueOf(chO), Boolean.valueOf(chM));
        if (chM || (!z && !chO)) {
            Log.i("MicroMsg.FloatBallContainer", "wechat not in foreground or qb file view page, ignore showing float ball");
            AppMethodBeat.o(106274);
            return;
        }
        this.oXH.cjy();
        AppMethodBeat.o(106274);
    }

    public final void ciS() {
        AppMethodBeat.i(176968);
        if (this.oXH != null) {
            FloatBallView floatBallView = this.oXH;
            if (floatBallView.paY != null) {
                floatBallView.paY.removeAllViews();
                floatBallView.vk = null;
            }
        }
        AppMethodBeat.o(176968);
    }

    public final boolean ciT() {
        AppMethodBeat.i(106275);
        if (this.oXI == null || this.oXI.getVisibility() != 0) {
            AppMethodBeat.o(106275);
            return false;
        }
        AppMethodBeat.o(106275);
        return true;
    }

    public final int getPositionY() {
        AppMethodBeat.i(184610);
        if (this.oXH != null) {
            int positionY = this.oXH.getPositionY();
            AppMethodBeat.o(184610);
            return positionY;
        }
        int cjh = com.tencent.mm.plugin.ball.f.d.cjh();
        AppMethodBeat.o(184610);
        return cjh;
    }

    public final void b(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217042);
        if (this.oXH != null) {
            Log.i("MicroMsg.FloatBallContainer", "hide FloatBallView, animation:%s", Boolean.valueOf(z));
            this.oXH.b(z, animatorListenerAdapter);
        }
        if (this.oXI != null && !this.oXI.pcE) {
            Log.i("MicroMsg.FloatBallContainer", "hide FloatMenuView, animation:%s", Boolean.valueOf(z));
            this.oXI.e(animatorListenerAdapter);
        }
        AppMethodBeat.o(217042);
    }

    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(184611);
        List<BallInfo> ci = com.tencent.mm.plugin.ball.f.d.ci(list);
        Object[] objArr = new Object[2];
        objArr[0] = com.tencent.mm.plugin.ball.f.d.h(list) ? Integer.valueOf(list.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        objArr[1] = Integer.valueOf(ci.size());
        Log.d("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, size:%s, nonHidden: %d", objArr);
        if (com.tencent.mm.plugin.ball.f.d.h(ci)) {
            BallInfo ck = com.tencent.mm.plugin.ball.f.d.ck(ci);
            Log.d("MicroMsg.FloatBallContainer", "onFloaxtBallInfoChanged, videoBallInfo: %s", ck);
            if (ck != null && ci.size() == 1) {
                Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatMenuView for VIDEO");
                this.oXI.cjG();
            }
            boolean z = AppForegroundDelegate.INSTANCE.cPB;
            boolean z2 = ciT() || this.oWG.chM();
            if (!z || z2 || this.oWG.chV()) {
                Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, foreground:%s, canNotShowFloatBall:%s, forceHideAllFloatBall: %b", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(this.oWG.chV()));
            } else {
                Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView %b", Boolean.valueOf(this.oXH.oYj));
                if (!this.oXH.oYj) {
                    this.oXH.cjy();
                }
            }
            if (ck != null && !ciT() && !this.oWG.chV()) {
                Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, show FloatBallView for VIDEO, nonHiddenSize: %d", Integer.valueOf(ci.size()));
                this.oXH.cjy();
            }
        } else if (this.oXI.getVisibility() == 0) {
            Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView and FloatMenuView");
            this.oXI.e((AnimatorListenerAdapter) null);
            this.oXH.b(false, null);
        } else if (this.oXH.getVisibility() == 0) {
            Log.i("MicroMsg.FloatBallContainer", "onFloatBallInfoChanged, hide FloatBallView");
            this.oXH.b(false, null);
        }
        if (this.oXH != null) {
            this.oXH.a(list, ballInfo);
        }
        if (this.oXJ != null) {
            this.oXJ.a(list, ballInfo);
        }
        if (this.oXI != null) {
            this.oXI.a(list, ballInfo);
        }
        this.oXL.oWD = list;
        AppMethodBeat.o(184611);
    }

    public final void ciU() {
        AppMethodBeat.i(184612);
        this.oXI.setVisibility(8);
        if (this.windowManager != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (com.tencent.mm.compatible.util.d.oD(26)) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.format = 1;
            layoutParams.packageName = MMApplicationContext.getContext().getPackageName();
            layoutParams.flags = 65824;
            layoutParams.gravity = 8388659;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.x = com.tencent.mm.plugin.ball.f.d.cjg();
            layoutParams.y = com.tencent.mm.plugin.ball.f.d.cjh();
            try {
                this.windowManager.addView(this.oXI, layoutParams);
                Log.i("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow success");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatBallContainer", e2, "attachFloatMenuViewToWindow fail", new Object[0]);
            }
        } else {
            Log.e("MicroMsg.FloatBallContainer", "attachFloatMenuViewToWindow, window manager is null");
        }
        this.oXH.setVisibility(8);
        if (this.windowManager != null) {
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams();
            if (com.tencent.mm.compatible.util.d.oD(26)) {
                layoutParams2.type = 2038;
            } else {
                layoutParams2.type = 2002;
            }
            layoutParams2.format = 1;
            layoutParams2.packageName = MMApplicationContext.getContext().getPackageName();
            layoutParams2.flags = 196904;
            layoutParams2.gravity = 8388659;
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.x = com.tencent.mm.plugin.ball.f.d.cjg();
            layoutParams2.y = com.tencent.mm.plugin.ball.f.d.cjh();
            try {
                this.windowManager.addView(this.oXH, layoutParams2);
                Log.i("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow success");
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.FloatBallContainer", e3, "attachFloatBallViewToWindow fail", new Object[0]);
            }
        } else {
            Log.e("MicroMsg.FloatBallContainer", "attachFloatBallViewToWindow, window manager is null");
        }
        Set<com.tencent.mm.plugin.ball.c.g> chS = this.oWG.chS();
        Log.i("MicroMsg.FloatBallContainer", "attachToWindow, add floatBallViewListeners %s", Integer.valueOf(chS.size()));
        for (com.tencent.mm.plugin.ball.c.g gVar : chS) {
            a(gVar);
        }
        AppMethodBeat.o(184612);
    }

    public final void setNeedTranslateAnimation(boolean z) {
        AppMethodBeat.i(217043);
        if (this.oXH != null) {
            this.oXH.setNeedTranslateAnimation(z);
        }
        AppMethodBeat.o(217043);
    }

    public final void c(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217044);
        if (this.oXI != null) {
            if (z) {
                this.oXI.e(animatorListenerAdapter);
                AppMethodBeat.o(217044);
                return;
            }
            this.oXI.cjG();
        }
        AppMethodBeat.o(217044);
    }

    public final boolean ciV() {
        AppMethodBeat.i(217045);
        if (this.oXI == null || this.oXI.getVisibility() != 0) {
            AppMethodBeat.o(217045);
            return false;
        }
        AppMethodBeat.o(217045);
        return true;
    }

    public final void chW() {
        AppMethodBeat.i(184613);
        if (!(this.oXH == null || this.oXH.getLayoutParams() == null)) {
            ViewGroup.LayoutParams layoutParams = this.oXH.getLayoutParams();
            if (layoutParams instanceof WindowManager.LayoutParams) {
                Log.d("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag flag: %d", 131072);
                ((WindowManager.LayoutParams) layoutParams).flags |= 131072;
                this.oXH.setLayoutParams(layoutParams);
                Log.i("MicroMsg.FloatBallContainer", "alvinluo addFloatBallViewLayoutParamsFlag result: %d", Integer.valueOf(((WindowManager.LayoutParams) layoutParams).flags));
            }
        }
        AppMethodBeat.o(184613);
    }

    public final void chX() {
        AppMethodBeat.i(184614);
        if (!(this.oXH == null || this.oXH.getLayoutParams() == null)) {
            ViewGroup.LayoutParams layoutParams = this.oXH.getLayoutParams();
            if (layoutParams instanceof WindowManager.LayoutParams) {
                Log.d("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag flag: %d", 131072);
                ((WindowManager.LayoutParams) layoutParams).flags &= -131073;
                this.oXH.setLayoutParams(layoutParams);
                Log.i("MicroMsg.FloatBallContainer", "alvinluo removeFloatBallViewLayoutParamsFlag result: %d", Integer.valueOf(((WindowManager.LayoutParams) layoutParams).flags));
            }
        }
        AppMethodBeat.o(184614);
    }

    public final void a(com.tencent.mm.plugin.ball.c.g gVar) {
        AppMethodBeat.i(217046);
        if (this.oXH != null) {
            this.oXH.a(gVar);
        }
        AppMethodBeat.o(217046);
    }

    /* access modifiers changed from: package-private */
    public final void ciW() {
        AppMethodBeat.i(217047);
        try {
            if (this.windowManager != null) {
                if (this.oXH != null) {
                    this.oXH.listeners.clear();
                }
                this.windowManager.removeView(this.oXH);
                this.windowManager.removeView(this.oXI);
                if (this.oWG != null) {
                    this.oWG.chU();
                }
                Log.i("MicroMsg.FloatBallContainer", "detachFromWindowInternal, detach all views");
                AppMethodBeat.o(217047);
                return;
            }
            Log.e("MicroMsg.FloatBallContainer", "detachFromWindowInternal, window manager is null");
            AppMethodBeat.o(217047);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallContainer", e2, "detachFromWindowInternal exception", new Object[0]);
            AppMethodBeat.o(217047);
        }
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(106276);
        aVar.oXM = false;
        aVar.c(true, new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.ui.a.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(184609);
                super.onAnimationStart(animator);
                a.this.ciR();
                AppMethodBeat.o(184609);
            }
        });
        AppMethodBeat.o(106276);
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(106277);
        Log.i("MicroMsg.FloatBallContainer", "whenOrientationChange new:%d, last:%d, %d", Integer.valueOf(i2), Integer.valueOf(aVar.lastOrientation), Integer.valueOf(aVar.oXI.getMeasuredHeight()));
        if (aVar.lastOrientation != i2) {
            aVar.lastOrientation = i2;
            if (aVar.oXI.getVisibility() == 0) {
                aVar.oXI.setVisibility(8);
                aVar.ciR();
            }
        }
        AppMethodBeat.o(106277);
    }
}
