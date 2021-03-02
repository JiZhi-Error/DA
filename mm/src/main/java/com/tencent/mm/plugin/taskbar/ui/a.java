package com.tencent.mm.plugin.taskbar.ui;

import android.animation.Animator;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PointF;
import android.os.Build;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AbsListView;
import android.widget.ListView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.dynamicbackground.model.DynamicBackgroundNative;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.b.c;
import com.tencent.mm.plugin.taskbar.ui.b.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import java.util.Timer;
import java.util.TimerTask;

public final class a extends b {
    private int DBe;
    private boolean FSA = true;
    private boolean FSB = false;
    private boolean FSC = false;
    private View FSD;
    private boolean FSE = true;
    private int FSF = 0;
    private int FSG = 0;
    private int FSH = 0;
    private Runnable FSI = null;
    private Runnable FSJ = null;
    private com.tencent.f.i.b FSK = null;
    private com.tencent.f.i.b FSL = null;
    private boolean FSM = false;
    private boolean FSN = false;
    private boolean FSO = true;
    private boolean FSP = false;
    private boolean FSQ = false;
    private int FSR = 0;
    private boolean FSS = false;
    private boolean FST = true;
    private boolean FSU = true;
    private boolean FSV = false;
    private boolean FSW = false;
    private int FSX = 0;
    private int FSY = 0;
    private int FSZ = 0;
    private float FSs = 0.2f;
    private float FSt = 0.05f;
    private int FSu = 0;
    private int FSv = 0;
    private com.tencent.mm.plugin.taskbar.api.a FSw;
    private DynamicBgContainer FSx;
    private DynamicBackgroundGLSurfaceView FSy;
    private View FSz;
    private int FTa = 0;
    private int FTb = 0;
    private com.tencent.mm.plugin.appbrand.widget.c.a FTc;
    private boolean FTd = false;
    private Runnable FTe;
    private boolean FTf = true;
    private boolean FTg = false;
    private boolean FTh = false;
    private Runnable FTi;
    private PointF FTj = new PointF();
    private PointF FTk = new PointF();
    private boolean FTl = false;
    private Runnable FTm = new Runnable() {
        /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass7 */

        public final void run() {
            AppMethodBeat.i(238112);
            a.this.xbw = false;
            AppMethodBeat.o(238112);
        }
    };
    private boolean FTn = true;
    private GyroView FTo;
    private View FTp;
    private View FTq;
    private boolean FTr = true;
    private boolean FTs = false;
    private boolean FTt = false;
    private int Fgj = -2;
    private boolean Vbp = false;
    private View azm;
    private Context mContext;
    private ListView mListView;
    private View nZg;
    private HeaderContainer onh;
    private Vibrator ooM;
    private boolean pJi = false;
    private int vaf = 0;
    private boolean xbw;

    static /* synthetic */ void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(238154);
        aVar.a(false, false, i2, i3);
        AppMethodBeat.o(238154);
    }

    static /* synthetic */ void e(a aVar) {
        AppMethodBeat.i(238152);
        aVar.aby(4);
        AppMethodBeat.o(238152);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(238153);
        aVar.ax(true, false);
        AppMethodBeat.o(238153);
    }

    static /* synthetic */ void n(a aVar) {
        AppMethodBeat.i(238155);
        aVar.fuJ();
        AppMethodBeat.o(238155);
    }

    public a(Context context, ListView listView, HeaderContainer headerContainer) {
        AppMethodBeat.i(238118);
        this.mContext = context;
        this.mListView = listView;
        this.onh = headerContainer;
        this.ooM = (Vibrator) context.getSystemService("vibrator");
        this.DBe = au.eu(this.mContext) + au.getStatusBarHeight(this.mContext);
        boolean post = listView.post(new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(238105);
                a.this.DBe = au.eu(a.this.mContext) + au.getStatusBarHeight(a.this.mContext);
                Log.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:%d UIUtilsStatusBar:%d WeUIToolHelperStatusBar:%d", Integer.valueOf(a.this.DBe), Integer.valueOf(ao.getStatusBarHeight(a.this.mContext)), Integer.valueOf(au.getStatusBarHeight(a.this.mContext)));
                AppMethodBeat.o(238105);
            }
        });
        e.fur();
        this.FSU = e.atB();
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo init AppBrandDesktopAnimController isEnableDynamicBackground: %b mScrollOffset:%s ret:%s", Boolean.valueOf(this.FSU), Integer.valueOf(this.DBe), Boolean.valueOf(post));
        fuH();
        fuI();
        cMc();
        fuz();
        this.FTc = new com.tencent.mm.plugin.appbrand.widget.c.a(this.mContext.getResources().getColor(R.color.FG_0), ar.fj(this.mContext.getResources().getColor(R.color.BW_100_Alpha_0_8), 60));
        AppMethodBeat.o(238118);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void fuz() {
        AppMethodBeat.i(238119);
        this.vaf = this.mContext.getResources().getColor(R.color.f3043a);
        AppMethodBeat.o(238119);
    }

    private void cMc() {
        AppMethodBeat.i(238120);
        try {
            this.FSF = (int) (((float) this.mContext.getResources().getDisplayMetrics().heightPixels) * 0.2f);
            this.FSG = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16);
            if (this.FSF < this.FSG) {
                this.FSG = 0;
            }
            this.FSH = this.FSF;
            this.FSZ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 100);
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo configAnim mStartAlphaAnimDisFromBottom: %d, mAlphaAnimationDistance: %d, mGyroViewAnimateAlphaDistance: %d", Integer.valueOf(this.FSF), Integer.valueOf(this.FSH), Integer.valueOf(this.FSZ));
            AppMethodBeat.o(238120);
        } catch (Exception e2) {
            AppMethodBeat.o(238120);
        }
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void fux() {
        AppMethodBeat.i(238121);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo openHeader isVisibleHeader: %b, headerOpen: %b", Boolean.valueOf(fuw()), Boolean.valueOf(this.FSV));
        if (!fuw()) {
            AppMethodBeat.o(238121);
            return;
        }
        if (this.FTr && this.FTs) {
            PlaySound.play(this.mContext, (int) R.string.qc, 3);
        }
        this.FTg = true;
        this.FSQ = false;
        this.mListView.removeCallbacks(this.FTi);
        ListView listView = this.mListView;
        AnonymousClass4 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(238109);
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
                a.this.mListView.smoothScrollBy(a.this.onh.getTop(), 600);
                a.e(a.this);
                a.f(a.this);
                AppMethodBeat.o(238109);
            }
        };
        this.FTi = r1;
        listView.post(r1);
        if (!this.FSU) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor not enableNativeBackground not need to monitor");
            AppMethodBeat.o(238121);
            return;
        }
        com.tencent.mm.plugin.taskbar.ui.a.a aVar = com.tencent.mm.plugin.taskbar.ui.a.a.FUZ;
        if (!com.tencent.mm.plugin.taskbar.ui.a.a.fuZ()) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor no need to check");
            AppMethodBeat.o(238121);
            return;
        }
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo checkAndStartPerformanceMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b", Boolean.valueOf(this.FSM), Boolean.valueOf(this.FSN));
        if (!this.FSM && !this.FSN) {
            this.FSM = true;
            if (this.FSK != null) {
                this.FSK.cancel();
            }
            this.FSK = new com.tencent.f.i.b() {
                /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass2 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "MicroMsg.AppBrandDesktopAnimController#startMonitorRunnable";
                }

                public final void run() {
                    AppMethodBeat.i(238106);
                    if (!c.INSTANCE.hki) {
                        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStart performanceMonitor");
                        c cVar = c.INSTANCE;
                        if (!cVar.hki) {
                            cVar.hki = true;
                            Log.i("MicroMsg.Metronome", "[start] stack:%s", Util.getStack());
                            cVar.axF().postFrameCallback(cVar);
                        }
                        d dVar = d.INSTANCE;
                        synchronized (dVar.hkp) {
                            try {
                                if (dVar.isRunning) {
                                    Log.w("MicroMsg.PerformanceMonitor", "alvinluo already running and ignore this requestStartMonitor. If you want run a new one, stop first.");
                                } else {
                                    if (dVar.mTimer != null) {
                                        dVar.mTimer.cancel();
                                    }
                                    System.gc();
                                    dVar.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
                                    dVar.hkn.clear();
                                    dVar.hkn.put(1, new com.tencent.mm.plugin.taskbar.ui.b.a());
                                    dVar.mTimer.scheduleAtFixedRate(new TimerTask() {
                                        /* class com.tencent.mm.plugin.taskbar.ui.b.d.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(238323);
                                            synchronized (d.this.hkp) {
                                                try {
                                                    if (d.this.isRunning) {
                                                        for (b bVar : d.this.hkn.values()) {
                                                            bVar.axE();
                                                        }
                                                    } else {
                                                        Log.w("MicroMsg.PerformanceMonitor", "hy: already stopped");
                                                        cancel();
                                                    }
                                                } finally {
                                                    AppMethodBeat.o(238323);
                                                }
                                            }
                                        }
                                    }, 0, 5);
                                    dVar.isRunning = true;
                                }
                            } finally {
                                AppMethodBeat.o(238106);
                            }
                        }
                        a.o(a.this);
                    }
                }
            };
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute startMonitorRunnable");
            h.RTc.b(this.FSK, "AppBrandDesktopPerformanceMonitor");
        }
        AppMethodBeat.o(238121);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void abu(final int i2) {
        AppMethodBeat.i(238122);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader isVisibleHeader: %b, reason: %d", Boolean.valueOf(fuw()), Integer.valueOf(i2));
        this.FSQ = true;
        this.pJi = false;
        aby(0);
        if (!fuw()) {
            wm(false);
            AppMethodBeat.o(238122);
            return;
        }
        this.FTg = true;
        this.mListView.removeCallbacks(this.FTi);
        ListView listView = this.mListView;
        AnonymousClass5 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass5 */

            public final void run() {
                int i2;
                AppMethodBeat.i(238110);
                int bottom = a.this.onh.getBottom() - a.this.DBe;
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", Integer.valueOf(bottom), Integer.valueOf(a.this.onh.getBottom()));
                int i3 = a.this.FSS ? 10 : 600;
                a.this.mListView.smoothScrollBy(bottom, i3);
                a.h(a.this);
                a.this.FSS = false;
                if (a.this.FSR != 0) {
                    i2 = a.this.FSR;
                    a.this.FSR = 0;
                } else {
                    i2 = i2;
                }
                a.a(a.this, i2, i3);
                AppMethodBeat.o(238110);
            }
        };
        this.FTi = r1;
        listView.post(r1);
        AppMethodBeat.o(238122);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void i(long j2, final int i2, final boolean z) {
        AppMethodBeat.i(238123);
        super.i(j2, i2, z);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader delay: %d, type: %d fast:%s", Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z));
        if (this.FSJ != null) {
            this.mListView.removeCallbacks(this.FSJ);
        }
        ListView listView = this.mListView;
        AnonymousClass6 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(238111);
                a.this.FSS = z;
                a.this.abu(i2);
                AppMethodBeat.o(238111);
            }
        };
        this.FSJ = r1;
        listView.postDelayed(r1, j2);
        AppMethodBeat.o(238123);
    }

    private int fuB() {
        AppMethodBeat.i(238124);
        if (this.onh.getMeasuredHeight() == 0) {
            AppMethodBeat.o(238124);
            return 0;
        }
        int bottom = this.onh.getBottom() - this.DBe;
        AppMethodBeat.o(238124);
        return bottom;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(238125);
        if (motionEvent.getAction() == 0) {
            ac(motionEvent);
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.pJi = false;
            this.FTk.set(motionEvent.getRawX(), motionEvent.getRawY());
            if (this.onh != null && this.onh.getBackUpFooterRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && fuE()) {
                if (this.FSR == 0) {
                    this.FSR = 12;
                }
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp reason: %d", Integer.valueOf(this.FSR));
            }
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onTouch ActionUp");
            onScrollStateChanged(this.mListView, -1);
        }
        AppMethodBeat.o(238125);
        return false;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void ac(MotionEvent motionEvent) {
        AppMethodBeat.i(238126);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionDownEvent %d, x: %f, y: %f", Integer.valueOf(motionEvent.getAction()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()));
        this.mListView.removeCallbacks(this.FTi);
        this.mListView.removeCallbacks(this.FSJ);
        this.FTj.set(motionEvent.getRawX(), motionEvent.getRawY());
        this.FTh = false;
        this.FTd = false;
        this.pJi = true;
        AppMethodBeat.o(238126);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        boolean z;
        AppMethodBeat.i(238127);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged scrollState: %d, isMoveUp: %b", Integer.valueOf(i2), Boolean.valueOf(fuE()));
        this.FSC = true;
        this.Fgj = i2;
        if (i2 == 0 || i2 == -1) {
            this.FSW = false;
            if (!this.FTg || i2 != 0) {
                int fuB = fuB() - 60;
                Log.i("MicroMsg.AppBrandDesktopAnimController", "checkOpen moveUp:%b offset:%d openLimit:%d", Boolean.valueOf(fuE()), Integer.valueOf(fuB), Integer.valueOf(fuF()));
                if ((this.onh == null || this.onh.getBottom() > 0) && !fuE()) {
                    z = fuB > fuF();
                } else {
                    z = false;
                }
                if (z) {
                    fux();
                    AppMethodBeat.o(238127);
                    return;
                } else if (fuE() && i2 == -1) {
                    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader");
                    abu(4);
                    AppMethodBeat.o(238127);
                    return;
                } else if (i2 == -1) {
                    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScrollStateChanged closeHeader auto");
                    abu(0);
                    this.FSP = true;
                    AppMethodBeat.o(238127);
                    return;
                }
            } else {
                Log.i("MicroMsg.AppBrandDesktopAnimController", "isScrollingByAnim True!!!");
                this.FTg = false;
                AppMethodBeat.o(238127);
                return;
            }
        } else if (i2 == 2) {
            this.xbw = true;
            this.FSW = true;
            AppMethodBeat.o(238127);
            return;
        } else if (i2 == 1) {
            this.xbw = false;
            this.FST = true;
            this.FSW = true;
            if (fuE()) {
                this.xbw = false;
                this.FSR = 4;
            }
        }
        AppMethodBeat.o(238127);
    }

    private void aby(int i2) {
        AppMethodBeat.i(238128);
        Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo setActionBarVisible: %d", Integer.valueOf(i2));
        if (!(this.nZg == null || this.nZg.getVisibility() == i2)) {
            this.nZg.setVisibility(i2);
        }
        AppMethodBeat.o(238128);
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        boolean z;
        AppMethodBeat.i(238129);
        if (this.FTd || !absListView.isInLayout() || this.FSQ || this.onh.getBottom() >= this.onh.getHeight() - 5 || !this.FSV) {
            if (this.FTh && !this.FTg && this.xbw && i2 <= 0 && fuw()) {
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo [onScroll] stop fling!");
                this.mListView.scrollBy(0, 0);
                abu(4);
            }
            if (!(this.onh == null || this.onh.getHeight() == this.FTa)) {
                this.FTb = ((int) (((float) this.onh.getHeight()) * this.FSs)) + 60;
                this.FSX = ((int) (((float) this.onh.getHeight()) * this.FSs)) + 60;
                this.FSY = this.onh.getHeight() - this.DBe;
                this.FSu = (int) (((float) this.onh.getHeight()) * this.FSs);
                this.FSv = (int) (((float) this.onh.getHeight()) * this.FSt);
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo initAnimationOffset headerContainer height: %d, old: %d, listBgStartAlphaOffset: %d, startAlphaOffset: %d, endAlphaOffset: %d, openLimit: %d, closeLimit: %d", Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.FTa), Integer.valueOf(this.FTb), Integer.valueOf(this.FSX), Integer.valueOf(this.FSY), Integer.valueOf(this.FSu), Integer.valueOf(this.FSv));
                this.FTa = this.onh.getHeight();
            }
            Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onScroll isFling: %b, firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d, isNeedCheckStopFling: %b, listBgStartAlphaOffset: %d", Boolean.valueOf(this.xbw), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(this.FTh), Integer.valueOf(this.FSX));
            if (!this.FTh && i2 == 0 && this.onh != null) {
                Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disX: %d, disY: %d, mScrollOffset: %d, headerContainer height: %d, headerContainer bottom: %d, canShowSurfaceView: %b", 0, Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.DBe), Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.onh.getBottom()), Boolean.valueOf(this.FSC));
                if (!(this.FSy == null && this.FSD == null)) {
                    if (!this.FSU) {
                        this.FSA = true;
                        this.FSB = true;
                        if (this.FSy != null) {
                            this.FSy.setVisibility(8);
                            this.FSy.onPause();
                        }
                        if (!(!fuw() || this.FSD == null || (this.FSD.getVisibility() == 0 && this.FSD.getAlpha() == 1.0f))) {
                            this.FSD.setAlpha(1.0f);
                            this.FSD.setVisibility(0);
                        }
                    } else if (fuw() && this.FSA && this.FSC) {
                        this.FSA = false;
                        this.FSD.setVisibility(0);
                        this.FSx.erz();
                        if (this.FSB && this.FSy != null) {
                            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo showSurfaceView onResume");
                            this.FSy.onResume();
                            this.FSB = false;
                        }
                    }
                }
                if (!this.FST) {
                    Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader disableUpdateListAlpha");
                } else {
                    int fuB = fuB();
                    float min = 1.0f - Math.min(1.0f, Math.max(0.0f, (1.0f * ((float) (fuB - this.FTb))) / ((float) ((this.onh.getMeasuredHeight() - this.DBe) - this.FTb))));
                    cb(min);
                    int height = (this.onh.getHeight() - this.DBe) - this.FSF;
                    int fuB2 = fuB() - height;
                    float min2 = Math.min(1.0f, Math.max(0.0f, (1.0f * ((float) fuB2)) / ((float) (this.FSF - this.FSG))));
                    Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo onDragHeader scrollOffset: %d, percent: %f, diff: %d, fromOffset: %d, actionBarAlpha: %f", Integer.valueOf(fuB), Float.valueOf(min), Integer.valueOf(fuB2), Integer.valueOf(height), Float.valueOf(min2));
                    if (fuB < this.FTb / 2) {
                        this.Vbp = false;
                    } else if (!this.Vbp) {
                        this.Vbp = true;
                        this.onh.hWQ();
                    }
                    if (fuB < this.FTb || fuB < this.FSX) {
                        aby(0);
                        f(1.0f, this.vaf, fuB);
                        cc(1.0f);
                    } else if (min2 >= 0.0f) {
                        aby(4);
                        f(min2, this.mContext.getResources().getColor(R.color.d4), fuB);
                        cc(1.0f - min2);
                    }
                    for (int i5 = i2; i5 < i2 + i3; i5++) {
                        View childAt = absListView.getChildAt(i5);
                        if (!(childAt == null || i5 == 0)) {
                            childAt.setAlpha(min);
                        }
                    }
                }
            }
            if (this.mListView != null && ((Build.VERSION.SDK_INT < 23 || g.isMIUIV8()) && Build.VERSION.SDK_INT >= 21 && !esy() && this.onh != null && this.onh.getBottom() <= this.DBe + 20)) {
                if (this.FSD != null) {
                    this.FSD.setVisibility(8);
                }
                if (this.FSy != null) {
                    this.FSA = true;
                    this.FSB = true;
                    this.FSx.ery();
                }
            }
            if (!fuw()) {
                this.FTh = true;
                int fuB3 = fuB() - 60;
                Log.i("MicroMsg.AppBrandDesktopAnimController", "checkClose moveUp:%b offset:%d closeLimit:%d", Boolean.valueOf(fuE()), Integer.valueOf(fuB3), Integer.valueOf(fuG()));
                if ((this.onh != null && this.onh.getBottom() <= 0) || !fuE()) {
                    z = false;
                } else if (fuB3 < fuG()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && this.FSW) {
                    ax(false, true);
                } else if (this.FTl && this.FSW) {
                    ax(false, true);
                }
            } else {
                this.FTh = false;
            }
            if (this.FTo == null) {
                this.FTo = (GyroView) this.onh.findViewById(R.id.dmt);
            }
            if (this.FTp == null) {
                this.FTp = this.onh.findViewById(R.id.nq);
            }
            if (this.FTq == null) {
                this.FTq = this.onh.findViewById(R.id.bnw);
            }
            if (i2 <= 0) {
                int fuF = fuF();
                int bottom = this.onh.getBottom();
                int fuB4 = fuB();
                int i6 = this.FSY - this.FSX;
                float f2 = (1.0f * ((float) (fuB4 - this.FSX))) / ((float) i6);
                this.FTp.setAlpha(f2);
                this.FTq.setAlpha(f2);
                if (f2 < 0.2f) {
                    this.onh.setBlurAlpha(5.0f * f2);
                } else {
                    this.onh.setBlurAlpha(1.0f);
                }
                int i7 = fuB4 - 60;
                Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo handleGyroView dis: %d, totalDis: %d, offsetY: %d, percent: %f, start: %d, end: %d, isFling: %b, limit: %d, bottom: %d, headerContainerHeight: %d, gyroView height: %d", Integer.valueOf(fuB4), Integer.valueOf(i6), Integer.valueOf(i7), Float.valueOf(f2), Integer.valueOf(this.FSX), Integer.valueOf(this.FSY), Boolean.valueOf(this.xbw), Integer.valueOf(fuF), Integer.valueOf(bottom), Integer.valueOf(this.onh.getHeight()), Integer.valueOf(this.FTo.getHeight()));
                if ((!this.xbw && bottom >= 5) || this.FSP) {
                    if (fuF >= i7) {
                        this.FTo.c((float) i7, fuF);
                        this.FTo.setAlpha(1.0f);
                    } else {
                        this.FTo.c((float) fuF, fuF);
                    }
                }
                float f3 = 1.0f - ((1.0f * ((float) (i7 - fuF))) / ((float) this.FSZ));
                GyroView gyroView = this.FTo;
                gyroView.setTranslationY(((float) (-(fuB4 - gyroView.getHeight()))) / 2.0f);
                this.FTo.setAlpha(f3);
                if (i7 >= fuF && this.FTt && fuw() && !absListView.isInLayout()) {
                    this.ooM.vibrate(10);
                    this.FTt = false;
                }
                if (bottom < this.DBe + 10) {
                    fuH();
                }
            }
            this.FTl = fuw();
            if (fuw() && this.pJi) {
                wk(false);
            } else if (!this.FSV) {
                wk(true);
            } else if (this.FSV) {
                wk(false);
            }
            MMHandlerThread.removeRunnable(this.FTm);
            MMHandlerThread.postToMainThreadDelayed(this.FTm, 60);
            AppMethodBeat.o(238129);
            return;
        }
        Log.i("MicroMsg.AppBrandDesktopAnimController", "isInLayout");
        abu(0);
        AppMethodBeat.o(238129);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void wl(boolean z) {
        AppMethodBeat.i(238130);
        super.wl(z);
        this.FSR = 0;
        this.FSV = true;
        if (this.FSD != null && this.FSD.getVisibility() == 0) {
            this.FSD.invalidate();
        }
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpenHeader isToClose: %b, isEnableDynamicBackgroud: %b", Boolean.valueOf(this.FSQ), Boolean.valueOf(this.FSU));
        if (this.azm == null) {
            AppMethodBeat.o(238130);
        } else if (this.FSQ) {
            fuy();
            AppMethodBeat.o(238130);
        } else if (!fuw()) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onOpen header not visible");
            this.azm.setTranslationY(0.0f);
            AppMethodBeat.o(238130);
        } else {
            this.azm.animate().translationY((float) this.azm.getHeight()).setDuration(260).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass8 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(238113);
                    a.this.azm.setVisibility(4);
                    a.this.azm.animate().setListener(null);
                    AppMethodBeat.o(238113);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            fuC();
            AppMethodBeat.o(238130);
        }
    }

    private void fuC() {
        AppMethodBeat.i(238131);
        this.FTd = true;
        if (this.FTe != null) {
            this.mListView.removeCallbacks(this.FTe);
        }
        ListView listView = this.mListView;
        AnonymousClass9 r1 = new Runnable() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(238114);
                Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIgnoreInLayout false");
                a.this.FTd = false;
                AppMethodBeat.o(238114);
            }
        };
        this.FTe = r1;
        listView.postDelayed(r1, 500);
        AppMethodBeat.o(238131);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void fuy() {
        AppMethodBeat.i(238132);
        if (this.azm != null) {
            this.FSQ = true;
            this.azm.setTranslationY(0.0f);
        }
        AppMethodBeat.o(238132);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void wm(boolean z) {
        long j2;
        AppMethodBeat.i(238133);
        super.wm(z);
        this.FSV = false;
        fuI();
        fuD();
        if (this.azm == null) {
            AppMethodBeat.o(238133);
            return;
        }
        this.azm.setVisibility(0);
        ViewPropertyAnimator translationY = this.azm.animate().translationY(0.0f);
        if (this.azm.getTranslationY() == 0.0f) {
            j2 = 130;
        } else {
            j2 = 260;
        }
        translationY.setDuration(j2).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass10 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(238115);
                a.this.azm.animate().setListener(null);
                a.this.azm.setTranslationY(0.0f);
                AppMethodBeat.o(238115);
            }

            public final void onAnimationCancel(Animator animator) {
                AppMethodBeat.i(238116);
                a.this.azm.animate().setListener(null);
                a.this.azm.setTranslationY(0.0f);
                AppMethodBeat.o(238116);
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        fuC();
        AppMethodBeat.o(238133);
    }

    private void fuD() {
        AppMethodBeat.i(238134);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: request delayHideBackgroundView %b", Boolean.valueOf(this.FSO));
        if (this.FSI != null) {
            MMHandlerThread.removeRunnable(this.FSI);
        }
        if (this.FSO) {
            AnonymousClass11 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(238117);
                    Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: delayHideBackgroundView");
                    a.n(a.this);
                    AppMethodBeat.o(238117);
                }
            };
            this.FSI = r0;
            MMHandlerThread.postToMainThreadDelayed(r0, 500);
            AppMethodBeat.o(238134);
            return;
        }
        fuJ();
        AppMethodBeat.o(238134);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void abv(int i2) {
        AppMethodBeat.i(238135);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "updateScrollOffset %d", Integer.valueOf(i2));
        this.DBe = i2;
        AppMethodBeat.o(238135);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void iE() {
        AppMethodBeat.i(238136);
        cMc();
        f(1.0f, this.vaf, 0);
        cb(1.0f);
        this.FST = false;
        AppMethodBeat.o(238136);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void wk(boolean z) {
        AppMethodBeat.i(238137);
        if (this.onh.isFullScreen() && z != this.FTn) {
            if (WeChatEnvironment.hasDebugger()) {
                Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo enableBottomTabSwitch enable: %b, last: %b", Boolean.valueOf(z), Boolean.valueOf(this.FTn));
            }
            this.FTn = z;
            dq dqVar = new dq();
            dqVar.dGE.enable = z;
            EventCenter.instance.publish(dqVar);
        }
        AppMethodBeat.o(238137);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final boolean esy() {
        AppMethodBeat.i(238138);
        if (!fuw() || !this.FSV) {
            AppMethodBeat.o(238138);
            return false;
        }
        AppMethodBeat.o(238138);
        return true;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final boolean fuw() {
        AppMethodBeat.i(238139);
        Log.v("MicroMsg.AppBrandDesktopAnimController", "alvinluo isVisibleHeader bottom: %d, scrollOffset: %d, firstVisiblePosition: %d HeaderOpen:%b", Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.DBe), Integer.valueOf(this.mListView.getFirstVisiblePosition()), Boolean.valueOf(this.FSV));
        if (this.onh.getBottom() < this.DBe + 10 || this.mListView.getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(238139);
            return false;
        }
        AppMethodBeat.o(238139);
        return true;
    }

    private boolean fuE() {
        AppMethodBeat.i(238140);
        if (Math.abs(this.FTk.y - this.FTj.y) <= 5.0f || this.FTk.y <= this.FTj.y) {
            AppMethodBeat.o(238140);
            return true;
        }
        AppMethodBeat.o(238140);
        return false;
    }

    private int fuF() {
        AppMethodBeat.i(238141);
        if (this.FSu == 0) {
            this.FSu = (int) (((float) this.onh.getHeight()) * this.FSs);
        }
        int i2 = this.FSu;
        AppMethodBeat.o(238141);
        return i2;
    }

    private int fuG() {
        AppMethodBeat.i(238142);
        if (this.FSv == 0) {
            this.FSv = (int) (((float) this.onh.getHeight()) * this.FSt);
        }
        int i2 = this.FSv;
        AppMethodBeat.o(238142);
        return i2;
    }

    private void fuH() {
        this.FTt = true;
        this.FTr = true;
    }

    private void fuI() {
        AppMethodBeat.i(238143);
        if (this.FTo != null) {
            this.FTo.c(0.0f, fuF());
            this.FTo.setTranslationY(0.0f);
        }
        AppMethodBeat.o(238143);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void setTabView(View view) {
        this.azm = view;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void setActionBar(View view) {
        this.nZg = view;
    }

    private void fuJ() {
        AppMethodBeat.i(238144);
        boolean z = this.FSU;
        this.FSU = e.atB() && this.FSy != null;
        Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView refresh isEnableDynamicBackground: %b, lastEnable: %b", Boolean.valueOf(this.FSU), Boolean.valueOf(z));
        if (!this.FSO || !fuw()) {
            if (z) {
                if (this.FSy != null && !this.FSA) {
                    Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView SurfaceView onPause and set GONE");
                    this.FSx.ery();
                    this.FSA = true;
                    this.FSB = true;
                    AppMethodBeat.o(238144);
                    return;
                }
            } else if (this.FSy != null) {
                Log.i("MicroMsg.AppBrandDesktopAnimController", "virbg: hideBackgroundView SurfaceView set GONE");
                this.FSy.setVisibility(8);
            }
            AppMethodBeat.o(238144);
            return;
        }
        AppMethodBeat.o(238144);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final int getAnimationScrollOffset() {
        return this.FTb;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void setActionBarUpdateCallback(com.tencent.mm.plugin.taskbar.api.a aVar) {
        this.FSw = aVar;
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void o(View view, View view2) {
        AppMethodBeat.i(238145);
        this.FSx = (DynamicBgContainer) view;
        if (e.atB()) {
            this.FSy = (DynamicBackgroundGLSurfaceView) ((com.tencent.mm.plugin.taskbar.api.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).ho(view.getContext());
            com.tencent.mm.plugin.multitask.ui.bg.a erA = com.tencent.mm.plugin.multitask.ui.bg.a.erA();
            this.FSy.setColor(erA.gRQ, erA.gRR, erA.gRS, erA.gRT, erA.gRU);
        }
        if (this.FSy == null) {
            this.FSU = false;
        }
        this.FSD = view2;
        this.FSx.setGradientBgView((GradientColorBackgroundView) this.FSD);
        if (this.FSy != null && (this.FSD instanceof GradientColorBackgroundView)) {
            this.FSx.erx();
        }
        AppMethodBeat.o(238145);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void setStatusBarMaskView(View view) {
        this.FSz = view;
    }

    private void cb(float f2) {
        int d2;
        AppMethodBeat.i(238146);
        int d3 = com.tencent.mm.plugin.taskbar.ui.c.a.d(f2, this.mContext.getResources().getColor(R.color.f3043a));
        if (Build.VERSION.SDK_INT < 23 || g.isMIUIV8()) {
            d2 = Build.VERSION.SDK_INT >= 21 ? com.tencent.mm.plugin.taskbar.ui.c.a.d(f2, ar.v(this.mContext.getResources().getColor(R.color.a_7), this.mContext.getResources().getColor(R.color.f3043a))) : d3;
        } else {
            d2 = d3;
        }
        if (this.mListView != null) {
            this.mListView.setBackgroundColor(d3);
        }
        if (this.FSz != null) {
            this.FSz.setBackgroundColor(d2);
        }
        AppMethodBeat.o(238146);
    }

    private void f(float f2, int i2, int i3) {
        AppMethodBeat.i(238147);
        Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarBgColor ratio: %f, scrollOffset: %d", Float.valueOf(f2), Integer.valueOf(i3));
        int d2 = com.tencent.mm.plugin.taskbar.ui.c.a.d(f2, i2);
        if (this.FSw != null) {
            this.FSw.f(f2, d2, i3);
        }
        if (this.onh != null) {
            this.onh.abx(d2);
        }
        AppMethodBeat.o(238147);
    }

    private void cc(float f2) {
        AppMethodBeat.i(238148);
        Log.d("MicroMsg.AppBrandDesktopAnimController", "alvinluo updateActionBarFgColor ratio: %f", Float.valueOf(f2));
        int aW = this.FTc.aW(1.0f - f2);
        if (this.FSw != null) {
            this.FSw.g(f2, aW, aW);
        }
        if (this.onh != null) {
            this.onh.ji(aW, aW);
        }
        AppMethodBeat.o(238148);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void setIsCurrentMainUI(boolean z) {
        AppMethodBeat.i(238149);
        this.FTf = z;
        if (!z && this.FSV) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo setIsCurrentMainUI and header open, close");
            i(0, 0, true);
        }
        AppMethodBeat.o(238149);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void onResume() {
        AppMethodBeat.i(238150);
        super.onResume();
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume isVisibleHeader: %b, bottom: %d, height: %d, isCurrentMainUI: %b", Boolean.valueOf(fuw()), Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.onh.getHeight()), Boolean.valueOf(this.FTf));
        if (fuw() && this.onh.getBottom() < this.onh.getHeight()) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume fastCloseHeader");
            i(0, 0, true);
        }
        if (!this.FSV) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume enableBottomTabSwitch true");
            wk(true);
            AppMethodBeat.o(238150);
            return;
        }
        if (!this.FTf) {
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo onResume not main ui and header open, then close header");
            i(0, 0, true);
        }
        AppMethodBeat.o(238150);
    }

    @Override // com.tencent.mm.plugin.taskbar.api.b
    public final void onDestroy() {
        AppMethodBeat.i(238151);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo DesktopAnimController onDestroy");
        if (this.mListView != null) {
            if (this.FSJ != null) {
                this.mListView.removeCallbacks(this.FSJ);
                this.FSJ = null;
            }
            if (this.FSI != null) {
                this.mListView.removeCallbacks(this.FSI);
                this.FSI = null;
            }
            if (this.FTe != null) {
                this.mListView.removeCallbacks(this.FTe);
                this.FTe = null;
            }
        }
        h.RTc.bqo("AppBrandDesktopPerformanceMonitor");
        d.INSTANCE.axH();
        d.INSTANCE.release();
        this.FSM = false;
        if (this.FSy != null) {
            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = this.FSy;
            com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "release", new Object[0]);
            DynamicBackgroundGLSurfaceView.b bVar = dynamicBackgroundGLSurfaceView.gRw;
            if (bVar != null) {
                try {
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo NativeRender release", new Object[0]);
                    DynamicBackgroundNative dynamicBackgroundNative = bVar.gRA;
                    if (dynamicBackgroundNative != null) {
                        dynamicBackgroundNative.nativeRelease();
                    }
                    bVar.gRF = null;
                    com.tencent.mm.dynamicbackground.a.c.i("MicroMsg.DynamicBgSurfaceView", "alvinluo SurfaceView reset and nativeRelease", new Object[0]);
                    bVar.gRD = 0;
                    bVar.gRE = 0;
                    bVar.gRM = false;
                } catch (Throwable th) {
                    com.tencent.mm.dynamicbackground.a.c.printErrStackTrace("MicroMsg.DynamicBgSurfaceView", th, "alvinluo nativeRelease exception", new Object[0]);
                }
            }
            dynamicBackgroundGLSurfaceView.gRw = null;
        }
        AppMethodBeat.o(238151);
    }

    static /* synthetic */ void h(a aVar) {
        boolean z;
        if (!aVar.FSS) {
            z = true;
        } else {
            z = false;
        }
        aVar.FSO = z;
    }

    static /* synthetic */ void o(a aVar) {
        AppMethodBeat.i(238156);
        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo delayStopMonitor hasStartMonitor: %b, hasDelayStopMonitor: %b, delay: %d", Boolean.valueOf(aVar.FSM), Boolean.valueOf(aVar.FSN), 10000L);
        if (aVar.FSM && !aVar.FSN) {
            if (aVar.FSL != null) {
                aVar.FSL.cancel();
            }
            aVar.FSL = new com.tencent.f.i.b() {
                /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass3 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public final String getKey() {
                    return "MicroMsg.AppBrandDesktopAnimController#stopMonitorRunnable";
                }

                public final void run() {
                    com.tencent.mm.plugin.taskbar.ui.b.a aVar;
                    SharedPreferences.Editor edit;
                    SharedPreferences.Editor putInt;
                    SharedPreferences.Editor edit2;
                    SharedPreferences.Editor putInt2;
                    AppMethodBeat.i(238108);
                    if (c.INSTANCE.hki) {
                        Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor");
                        c cVar = c.INSTANCE;
                        cVar.hkf = 0;
                        cVar.hkg = 0;
                        cVar.hki = false;
                        Log.i("MicroMsg.Metronome", "[stop] stack:%s", Util.getStack());
                        cVar.axF().removeFrameCallback(cVar);
                        d.INSTANCE.axH();
                        com.tencent.mm.plugin.taskbar.ui.b.b bVar = d.INSTANCE.hkn.get(1);
                        if (bVar instanceof com.tencent.mm.plugin.taskbar.ui.b.a) {
                            bVar.axD();
                            aVar = (com.tencent.mm.plugin.taskbar.ui.b.a) bVar;
                        } else {
                            aVar = null;
                        }
                        if (aVar != null) {
                            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doStop performanceMonitor dump fps, max: %f, min: %f, average: %f", Double.valueOf(aVar.idX), Double.valueOf(aVar.idW), Double.valueOf(aVar.FVh));
                            com.tencent.mm.plugin.taskbar.ui.a.a aVar2 = com.tencent.mm.plugin.taskbar.ui.a.a.FUZ;
                            double d2 = aVar.FVh;
                            Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps currentDrawFps: %d, appFps: %f", Integer.valueOf(com.tencent.mm.plugin.taskbar.ui.a.a.FUW), Double.valueOf(d2));
                            if (d2 >= 45.0d) {
                                e.wj(true);
                                if (d2 >= 55.0d) {
                                    com.tencent.mm.plugin.taskbar.ui.a.a.FUW = 20;
                                } else if (d2 >= 50.0d) {
                                    com.tencent.mm.plugin.taskbar.ui.a.a.FUW = 15;
                                } else if (d2 >= 45.0d) {
                                    com.tencent.mm.plugin.taskbar.ui.a.a.FUW = 5;
                                }
                            } else if (com.tencent.mm.plugin.taskbar.ui.a.a.FUW == 2) {
                                Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps disable DynamicBackground");
                                e.wj(false);
                            } else {
                                com.tencent.mm.plugin.taskbar.ui.a.a.FUW = 2;
                                e.wj(true);
                            }
                            com.tencent.mm.plugin.taskbar.ui.a.a.FUY = (int) d2;
                            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
                            if (!(defaultPreference == null || (edit2 = defaultPreference.edit()) == null || (putInt2 = edit2.putInt("current_draw_fps", com.tencent.mm.plugin.taskbar.ui.a.a.FUW)) == null)) {
                                putInt2.apply();
                            }
                            if (!(defaultPreference == null || (edit = defaultPreference.edit()) == null || (putInt = edit.putInt("current_app_fps", (int) d2)) == null)) {
                                putInt.apply();
                            }
                            Log.i("MicroMsg.DynamicBackgroundConfig", "alvinluo adjustDynamicBackgroundDrawFps appFps: %f, FRAME_PER_SECOND: %d", Double.valueOf(d2), Integer.valueOf(com.tencent.mm.plugin.taskbar.ui.a.a.FUW));
                            com.tencent.mm.plugin.taskbar.ui.a.a.fva();
                        }
                        d.INSTANCE.release();
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.taskbar.ui.a.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(238107);
                                a.this.FSM = false;
                                a.this.FSN = false;
                                AppMethodBeat.o(238107);
                            }
                        });
                    }
                    AppMethodBeat.o(238108);
                }
            };
            Log.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo execute stopMonitorRunnable");
            aVar.FSN = true;
            h.RTc.a(aVar.FSL, 10000, "AppBrandDesktopPerformanceMonitor");
        }
        AppMethodBeat.o(238156);
    }
}
