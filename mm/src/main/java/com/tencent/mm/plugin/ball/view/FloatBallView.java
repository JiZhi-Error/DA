package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.cb.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.ball.b.b;
import com.tencent.mm.plugin.ball.c.d;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aw;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatBallView extends FrameLayout implements d {
    public static final int paA = a.aH(MMApplicationContext.getContext(), R.dimen.a7c);
    private static final int paB = a.aH(MMApplicationContext.getContext(), R.dimen.a7a);
    private static final int paC = a.aH(MMApplicationContext.getContext(), R.dimen.a75);
    private static final int paD = a.aH(MMApplicationContext.getContext(), R.dimen.a73);
    public static final int paE = a.aH(MMApplicationContext.getContext(), R.dimen.a76);
    public static final int paF = a.aH(MMApplicationContext.getContext(), R.dimen.a74);
    private static final int paG = a.aH(MMApplicationContext.getContext(), R.dimen.a6k);
    private static final int paH = a.aH(MMApplicationContext.getContext(), R.dimen.a5r);
    private static final int paI = a.aH(MMApplicationContext.getContext(), R.dimen.a65);
    private static final int paJ = a.aH(MMApplicationContext.getContext(), R.dimen.a66);
    private static final int paK = a.aH(MMApplicationContext.getContext(), R.dimen.a63);
    private static final int paL = a.aH(MMApplicationContext.getContext(), R.dimen.a64);
    private static final int paM = a.aH(MMApplicationContext.getContext(), R.dimen.a5u);
    private static final int paN = a.aH(MMApplicationContext.getContext(), R.dimen.a5w);
    private static final int paO = a.aH(MMApplicationContext.getContext(), R.dimen.a5v);
    private static final int paP = a.aG(MMApplicationContext.getContext(), R.dimen.a5t);
    public static final int paQ = paJ;
    private static final int pac = a.aH(MMApplicationContext.getContext(), R.dimen.a5q);
    private static final int pad = a.aH(MMApplicationContext.getContext(), R.dimen.a5n);
    private static final int pae = a.aH(MMApplicationContext.getContext(), R.dimen.a5p);
    private static final int paf = a.aH(MMApplicationContext.getContext(), R.dimen.a5o);
    private static final int pag = a.aH(MMApplicationContext.getContext(), R.dimen.a6d);
    private static final int pah = a.aH(MMApplicationContext.getContext(), R.dimen.a6c);
    private static final int pai = a.aH(MMApplicationContext.getContext(), R.dimen.a6q);
    private static final int paj = a.aH(MMApplicationContext.getContext(), R.dimen.a6p);
    private static final int pak = a.aH(MMApplicationContext.getContext(), R.dimen.a6m);
    private static final int pal = a.aH(MMApplicationContext.getContext(), R.dimen.a6l);
    private static final int pam = a.aH(MMApplicationContext.getContext(), R.dimen.a6y);
    private static final int pan = a.aH(MMApplicationContext.getContext(), R.dimen.a6x);
    private static final int pao = a.aH(MMApplicationContext.getContext(), R.dimen.a71);
    private static final int pap = a.aH(MMApplicationContext.getContext(), R.dimen.a6z);
    private static final int paq = a.aH(MMApplicationContext.getContext(), R.dimen.a72);
    private static final int par = a.aH(MMApplicationContext.getContext(), R.dimen.a70);
    private static final int pas = a.aH(MMApplicationContext.getContext(), R.dimen.a6s);
    private static final int pat = a.aH(MMApplicationContext.getContext(), R.dimen.a6r);
    private static final int pau = a.aH(MMApplicationContext.getContext(), R.dimen.a6v);
    private static final int pav = a.aH(MMApplicationContext.getContext(), R.dimen.a6t);
    private static final int paw = a.aH(MMApplicationContext.getContext(), R.dimen.a6w);
    private static final int pax = a.aH(MMApplicationContext.getContext(), R.dimen.a6u);
    private static final int pay = a.aH(MMApplicationContext.getContext(), R.dimen.a7b);
    private static final int paz = a.aH(MMApplicationContext.getContext(), R.dimen.a7_);
    private Handler cPw;
    private boolean hbN;
    private long lastClickTime;
    private int lastOrientation;
    public Set<g> listeners;
    private View lrc;
    private boolean oVp;
    private Point oWm;
    public boolean oYj;
    public int oZZ;
    private int paR;
    private int paS;
    private Vibrator paT;
    private ValueAnimator paU;
    public b paV;
    private View paW;
    private LinearLayout paX;
    public FrameLayout paY;
    private FrameLayout paZ;
    private int paa;
    private int pab;
    private LayoutTransition pbA;
    private boolean pbB;
    public boolean pbC;
    private Point pbD;
    private PointF pbE;
    private Point pbF;
    private float pbG;
    private int pbH;
    private boolean pbI;
    private boolean pbJ;
    private boolean pbK;
    private BallInfo pbL;
    private BallInfo pbM;
    private Point pbN;
    private int pbO;
    private boolean pbP;
    public int pbQ;
    private boolean pbR;
    private boolean pbS;
    private boolean pbT;
    private int pbU;
    private Handler pbV;
    private Runnable pbW;
    private boolean pbX;
    private boolean pbY;
    private boolean pbZ;
    private FrameLayout pba;
    private FrameLayout pbb;
    private CircleAnimateView pbc;
    private CircleAnimateView pbd;
    private CircleAnimateView pbe;
    private CircleAnimateView pbf;
    private Drawable pbg;
    private Drawable pbh;
    private Drawable pbi;
    private Drawable pbj;
    private Drawable pbk;
    private Drawable pbl;
    private Drawable pbm;
    private Drawable pbn;
    private Drawable pbo;
    private Drawable pbp;
    private Drawable pbq;
    private Drawable pbr;
    private Drawable pbs;
    private Drawable pbt;
    private Drawable pbu;
    private Drawable pbv;
    private Drawable pbw;
    private Drawable pbx;
    private String pby;
    private List<BallInfo> pbz;
    private int pca;
    public View vk;
    private WindowManager windowManager;

    static /* synthetic */ void a(FloatBallView floatBallView, float f2) {
        AppMethodBeat.i(217108);
        floatBallView.setFloatBallAlphaInternal(f2);
        AppMethodBeat.o(217108);
    }

    static /* synthetic */ void c(FloatBallView floatBallView) {
        AppMethodBeat.i(217110);
        floatBallView.cjC();
        AppMethodBeat.o(217110);
    }

    static {
        AppMethodBeat.i(106478);
        AppMethodBeat.o(106478);
    }

    public FloatBallView(Context context) {
        this(context, null);
    }

    public FloatBallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatBallView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(106438);
        this.oZZ = 0;
        this.paa = 0;
        this.pab = 0;
        this.listeners = new CopyOnWriteArraySet();
        this.pbE = new PointF();
        this.pbF = new Point();
        this.pbG = -1.0f;
        this.pbH = 0;
        this.pbI = false;
        this.oYj = false;
        this.pbJ = false;
        this.pbK = true;
        this.oWm = null;
        this.pbN = new Point();
        this.pbO = 0;
        this.pbP = false;
        this.pbQ = 16;
        this.cPw = new Handler(Looper.getMainLooper());
        this.pbR = false;
        this.pbS = false;
        this.pbT = false;
        this.pbU = 0;
        this.hbN = false;
        this.oVp = false;
        this.pbV = new Handler(Looper.getMainLooper());
        this.pbW = new Runnable() {
            /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(106430);
                FloatBallView.this.oVp = true;
                FloatBallView.b(FloatBallView.this);
                for (g gVar : FloatBallView.this.listeners) {
                    gVar.chZ();
                }
                AppMethodBeat.o(106430);
            }
        };
        this.pbX = false;
        this.pbY = false;
        this.pbZ = false;
        this.pca = 0;
        View.inflate(context, R.layout.ayo, this);
        this.pbg = a.l(context, R.drawable.b99);
        this.pbh = a.l(context, R.drawable.b9a);
        this.pbi = a.l(context, R.drawable.b9c);
        this.pbj = a.l(context, R.drawable.b9_);
        this.pbk = a.l(context, R.drawable.b9b);
        this.pbl = a.l(context, R.drawable.b9d);
        this.pbm = a.l(context, R.drawable.b93);
        this.pbn = a.l(context, R.drawable.b95);
        this.pbo = a.l(context, R.drawable.b97);
        this.pbp = a.l(context, R.drawable.b94);
        this.pbq = a.l(context, R.drawable.b96);
        this.pbr = a.l(context, R.drawable.b98);
        this.pbs = a.l(context, R.drawable.b9i);
        this.pbt = a.l(context, R.drawable.b9j);
        this.pbu = a.l(context, R.drawable.b9k);
        this.pbv = a.l(context, R.drawable.b9i);
        this.pbw = a.l(context, R.drawable.b9j);
        this.pbx = a.l(context, R.drawable.b9k);
        this.paX = (LinearLayout) findViewById(R.id.a0a);
        this.pba = (FrameLayout) findViewById(R.id.a0_);
        this.paY = (FrameLayout) findViewById(R.id.jak);
        this.paZ = (FrameLayout) findViewById(R.id.g77);
        this.lrc = findViewById(R.id.bs9);
        this.pbb = (FrameLayout) findViewById(R.id.a0b);
        this.pbc = (CircleAnimateView) findViewById(R.id.ish);
        this.pbd = (CircleAnimateView) findViewById(R.id.aa3);
        this.pbe = (CircleAnimateView) findViewById(R.id.ilf);
        this.pbf = (CircleAnimateView) findViewById(R.id.d9m);
        this.paV = new b(this);
        this.paT = (Vibrator) context.getSystemService("vibrator");
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.paR = ViewConfiguration.get(context).getScaledTouchSlop();
        this.pbD = ao.az(context);
        if (ao.gJN() && aw.kB(context)) {
            this.pbD.x = ao.getDeviceWidth();
        }
        if (ao.gJK()) {
            this.pbD.x = ao.getDeviceHeight();
        }
        this.paS = ViewConfiguration.getLongPressTimeout();
        this.pbA = new LayoutTransition();
        this.paX.setLayoutTransition(this.pbA);
        this.lastOrientation = getResources().getConfiguration().orientation;
        AppMethodBeat.o(106438);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(106439);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V", this);
        super.onAttachedToWindow();
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        g(layoutParams.x, layoutParams.y, true, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onAttachedToWindow", "()V");
        AppMethodBeat.o(106439);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(106440);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V", this);
        super.onDetachedFromWindow();
        if (this.paU != null) {
            this.paU.cancel();
            this.paU = null;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "onDetachedFromWindow", "()V");
        AppMethodBeat.o(106440);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106441);
        Log.i("MicroMsg.FloatBallView", "onConfigurationChanged, orientation:%d, lastOrientation: %d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.lastOrientation));
        BR(configuration.orientation);
        int i2 = configuration.orientation;
        for (g gVar : this.listeners) {
            gVar.onOrientationChange(i2);
        }
        AppMethodBeat.o(106441);
    }

    private void BR(int i2) {
        AppMethodBeat.i(217076);
        Point point = this.pbD;
        this.pbD = ao.az(getContext());
        if (ao.gJN() && aw.kB(getContext())) {
            this.pbD.x = ao.getDeviceWidth();
        }
        if (ao.gJK()) {
            this.pbD.x = ao.getDeviceHeight();
        }
        Object[] objArr = new Object[2];
        objArr[0] = this.pbD;
        objArr[1] = point != null ? point : BuildConfig.COMMAND;
        Log.i("MicroMsg.FloatBallView", "processOrientationChanged, screenResolution: %s, lastResolution: %s", objArr);
        if (!(this.lastOrientation == i2 && (point == null || (point.x == this.pbD.x && point.y == this.pbD.y)))) {
            this.lastOrientation = i2;
            this.pbI = true;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            int i3 = layoutParams.x;
            int i4 = (int) (((float) this.pbD.y) * this.pbG);
            int max = Math.max(Math.min(i3, this.pbD.x), 0);
            int max2 = Math.max(Math.min(i4, this.pbD.y), 0);
            int targetPositionXWhenOrientationChanged = getTargetPositionXWhenOrientationChanged();
            int BU = BU(max2);
            boolean z = targetPositionXWhenOrientationChanged == 0;
            Log.i("MicroMsg.FloatBallView", "processOrientationChanged, layoutParams.x: %s, layoutParams.y: %s, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", Integer.valueOf(layoutParams.x), Integer.valueOf(layoutParams.y), Boolean.valueOf(z), Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(targetPositionXWhenOrientationChanged), Integer.valueOf(BU));
            d(z, max, max2, targetPositionXWhenOrientationChanged, BU);
        }
        AppMethodBeat.o(217076);
    }

    @Override // com.tencent.mm.plugin.ball.c.d
    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106442);
        String cs = cs(list);
        if (Util.isEqual(cs, this.pby)) {
            Log.d("MicroMsg.FloatBallView", "<<< onFloatBallInfoChanged, ignore refresh");
            AppMethodBeat.o(106442);
            return;
        }
        Log.i("MicroMsg.FloatBallView", ">>> onFloatBallInfoChanged, ballInfoList:%s", list);
        this.pby = cs;
        cr(list);
        cjw();
        boolean BT = BT(((WindowManager.LayoutParams) getLayoutParams()).x);
        f(true, BT, false);
        a(true, BT, false, this.oZZ);
        cjx();
        AppMethodBeat.o(106442);
    }

    private void cr(List<BallInfo> list) {
        AppMethodBeat.i(106443);
        this.paa = this.oZZ;
        this.oZZ = 0;
        if (AppForegroundDelegate.INSTANCE.cPB) {
            this.oZZ |= 32;
        }
        List<BallInfo> cj = com.tencent.mm.plugin.ball.f.d.cj(com.tencent.mm.plugin.ball.f.d.ch(com.tencent.mm.plugin.ball.f.d.ci(list)));
        this.pbz = com.tencent.mm.plugin.ball.f.d.ce(cj);
        int BK = com.tencent.mm.plugin.ball.f.d.BK(com.tencent.mm.plugin.ball.f.d.co(cj));
        boolean cf = com.tencent.mm.plugin.ball.f.d.cf(com.tencent.mm.plugin.ball.f.d.cm(list));
        if (cf) {
            this.oZZ |= 1;
        }
        if (BK == 1) {
            this.oZZ |= 2;
        } else if (BK == 2) {
            this.oZZ |= 4;
        } else if (BK == 3) {
            this.oZZ |= 64;
        } else if (BK == 4) {
            this.oZZ |= 128;
        }
        this.pab = BK;
        this.pbL = com.tencent.mm.plugin.ball.f.d.ck(list);
        boolean T = T(this.pbL);
        boolean K = K(this.pbL);
        boolean L = L(this.pbL);
        if (T) {
            this.oZZ |= 4096;
        } else {
            if (K) {
                this.oZZ |= 8;
            }
            if (L) {
                this.oZZ |= 16;
            }
        }
        if (this.pbL != null) {
            if (this.pbL.state == 512) {
                this.oZZ |= 1024;
            } else if (this.pbL.state == 1024) {
                this.oZZ |= 2048;
            }
        }
        if (!(this.pbL == null || this.pbL.vk == null)) {
            setCustomView(this.pbL);
        }
        this.pbM = com.tencent.mm.plugin.ball.f.d.cl(list);
        if (this.pbM != null) {
            if (this.pbM.state == 32) {
                this.oZZ |= 256;
            } else if (this.pbM.state == 64) {
                this.oZZ |= 512;
            }
        }
        Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayoutState, state:[%s => %s], active:%s, passiveCnt:%d, video:%s, audio:%s <<<", Integer.valueOf(this.paa), Integer.valueOf(this.oZZ), Boolean.valueOf(cf), Integer.valueOf(BK), Boolean.valueOf(K), Boolean.valueOf(L));
        AppMethodBeat.o(106443);
    }

    private static boolean T(BallInfo ballInfo) {
        return ballInfo != null && ballInfo.state == 2048;
    }

    private static boolean K(BallInfo ballInfo) {
        return ballInfo != null && (ballInfo.state == 4 || ballInfo.state == 512);
    }

    private static boolean L(BallInfo ballInfo) {
        return ballInfo != null && (ballInfo.state == 8 || ballInfo.state == 1024);
    }

    private void f(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(217077);
        if (this.pbS == z && this.pbT == z2 && this.pbR == z3 && this.pbU != 0 && this.pbU == this.oZZ) {
            Log.d("MicroMsg.FloatBallView", "<<< updateFloatBallViewLayout, ignore layout %b %b;%b %b; %b %b; %d %d", Boolean.valueOf(this.pbY), Boolean.valueOf(z), Boolean.valueOf(this.pbT), Boolean.valueOf(z2), Boolean.valueOf(this.pbR), Boolean.valueOf(z3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ));
            AppMethodBeat.o(217077);
            return;
        }
        Log.i("MicroMsg.FloatBallView", ">>> updateFloatBallViewLayout, isSettled:%s, isDockLeft:%s, isManual:%s, lastLayoutState:%s, currentLayoutState:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(this.pbU), Integer.valueOf(this.oZZ));
        this.pbR = z3;
        this.pbS = z;
        this.pbT = z2;
        this.pbU = this.oZZ;
        cjz();
        B(z, z2);
        AppMethodBeat.o(217077);
    }

    private void B(boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(217078);
        int paddingLeft = this.paX.getPaddingLeft();
        int paddingRight = this.paX.getPaddingRight();
        int paddingTop = this.paX.getPaddingTop();
        int paddingBottom = this.paX.getPaddingBottom();
        if (Cp(this.oZZ)) {
            if (z2) {
                i2 = this.pbQ | 8388611;
            } else {
                i2 = this.pbQ | 8388613;
            }
            X(i2, true);
            if (z) {
                if (z2) {
                    this.paX.setPadding(getExtendWidth(), paddingTop, paddingRight, paddingBottom);
                    this.paX.setLayoutTransition(this.pbA);
                    cjp();
                    AppMethodBeat.o(217078);
                    return;
                }
                this.paX.setPadding(paddingLeft, paddingTop, getExtendWidth(), paddingBottom);
                if ((Cr(this.paa) && Cv(this.oZZ)) || ((Cs(this.paa) && Cw(this.oZZ)) || ((Ct(this.paa) && Cx(this.oZZ)) || (Cu(this.paa) && Cy(this.oZZ))))) {
                    this.paX.setLayoutTransition(null);
                    cjr();
                    AppMethodBeat.o(217078);
                    return;
                } else if ((Cq(this.paa) && Cv(this.oZZ)) || ((Cq(this.paa) && Cw(this.oZZ)) || ((Cq(this.paa) && Cx(this.oZZ)) || (Cq(this.paa) && Cy(this.oZZ))))) {
                    this.paX.setLayoutTransition(null);
                    cjr();
                    AppMethodBeat.o(217078);
                    return;
                } else if ((!Cv(this.paa) || !Cq(this.oZZ)) && ((!Cw(this.paa) || !Cq(this.oZZ)) && ((!Cx(this.paa) || !Cq(this.oZZ)) && (!Cy(this.paa) || !Cq(this.oZZ))))) {
                    this.paX.setLayoutTransition(this.pbA);
                    cjr();
                    AppMethodBeat.o(217078);
                    return;
                } else {
                    this.paX.setLayoutTransition(null);
                    cjr();
                    AppMethodBeat.o(217078);
                    return;
                }
            } else if (Cv(this.oZZ) || Cw(this.oZZ) || Cx(this.oZZ) || Cy(this.oZZ)) {
                if (z2) {
                    cjt();
                    AppMethodBeat.o(217078);
                    return;
                }
                cju();
                AppMethodBeat.o(217078);
                return;
            } else if (Cr(this.oZZ) || Cs(this.oZZ) || Ct(this.oZZ) || Cu(this.oZZ)) {
                C(z2, false);
                AppMethodBeat.o(217078);
                return;
            } else if (Cq(this.oZZ)) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pba.getLayoutParams();
                layoutParams.gravity = 17;
                int i3 = paJ;
                int i4 = paJ;
                layoutParams.setMargins(i3, i3, i4, i4);
                this.pba.setLayoutParams(layoutParams);
                AppMethodBeat.o(217078);
                return;
            }
        } else if (!z) {
            X(this.pbQ | 1, false);
        } else if (z2) {
            this.paX.setPadding(getExtendWidth(), paddingTop, paddingRight, paddingBottom);
            this.paX.setLayoutTransition(this.pbA);
            X(this.pbQ | 8388611, true);
            this.lrc.setVisibility(8);
            if (Cf(this.oZZ)) {
                this.paZ.setVisibility(0);
                this.pba.setVisibility(8);
                this.pbb.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.paZ.getLayoutParams();
                layoutParams2.gravity = 8388627;
                this.paZ.setLayoutParams(layoutParams2);
                C(true, true);
            } else {
                this.paZ.setVisibility(8);
            }
            this.paY.setVisibility(0);
            if (this.pbL == null || this.pbL.oWu) {
                this.paY.setVisibility(8);
                AppMethodBeat.o(217078);
                return;
            }
            this.paY.setVisibility(0);
            boolean Cc = Cc(this.oZZ);
            if (Ch(this.oZZ) || Cg(this.oZZ)) {
                g(true, false, Cc);
                AppMethodBeat.o(217078);
                return;
            } else if (Ck(this.oZZ)) {
                g(false, true, Cc);
                AppMethodBeat.o(217078);
                return;
            } else {
                this.paY.setVisibility(8);
                AppMethodBeat.o(217078);
                return;
            }
        } else {
            this.paX.setPadding(paddingLeft, paddingTop, getExtendWidth(), paddingBottom);
            this.paX.setLayoutTransition(this.pbA);
            X(this.pbQ | 8388613, true);
            this.lrc.setVisibility(8);
            if (Cf(this.oZZ)) {
                this.paZ.setVisibility(0);
                this.pba.setVisibility(8);
                this.pbb.setVisibility(0);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.paZ.getLayoutParams();
                layoutParams3.gravity = 8388629;
                this.paZ.setLayoutParams(layoutParams3);
                C(false, true);
                cjv();
            } else {
                this.paZ.setVisibility(8);
            }
            this.paY.setVisibility(0);
            if (this.pbL == null || this.pbL.oWu) {
                this.paY.setVisibility(8);
            } else {
                this.paY.setVisibility(0);
                boolean Cc2 = Cc(this.oZZ);
                if (Ch(this.oZZ) || Cg(this.oZZ)) {
                    g(true, false, Cc2);
                } else if (Ck(this.oZZ)) {
                    g(false, true, Cc2);
                } else {
                    this.paY.setVisibility(8);
                }
            }
            boolean Cc3 = Cc(this.oZZ);
            if (Ch(this.oZZ) || Cg(this.oZZ)) {
                g(true, false, Cc3);
                AppMethodBeat.o(217078);
                return;
            } else if (Ck(this.oZZ)) {
                g(false, true, Cc3);
                AppMethodBeat.o(217078);
                return;
            } else {
                this.paY.setVisibility(8);
                AppMethodBeat.o(217078);
                return;
            }
        }
        AppMethodBeat.o(217078);
    }

    public final void X(int i2, boolean z) {
        AppMethodBeat.i(217079);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.paX.getLayoutParams();
        layoutParams.gravity = i2;
        this.paX.setLayoutParams(layoutParams);
        if (!z && !Cp(this.oZZ) && this.paZ.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.paZ.getLayoutParams();
            layoutParams2.gravity = 17;
            this.paZ.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(217079);
    }

    private void g(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(217080);
        int h2 = h(z, z2, z3);
        int a2 = a(this.oZZ, z, z2, z3);
        Log.v("MicroMsg.FloatBallView", "alvinluo updateCustomViewLayout width: %d, height: %d, margin: %d", Integer.valueOf(h2), Integer.valueOf(a2), Integer.valueOf(this.pbO));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.paY.getLayoutParams();
        layoutParams.width = h2;
        layoutParams.height = a2;
        if (this.pbO > 0) {
            layoutParams.setMargins(this.pbO, this.pbO, this.pbO, this.pbO);
        }
        this.paY.setLayoutParams(layoutParams);
        AppMethodBeat.o(217080);
    }

    private void cjp() {
        AppMethodBeat.i(176977);
        if (awy(this.oZZ)) {
            this.lrc.setVisibility((Cd(this.oZZ) || Ce(this.oZZ)) ? 0 : 4);
            this.paY.setVisibility(0);
            boolean Cc = Cc(this.oZZ);
            if (!Ch(this.oZZ) && !Cg(this.oZZ)) {
                if (Ck(this.oZZ)) {
                    if (CA(this.oZZ)) {
                        this.lrc.setVisibility(4);
                        g(false, true, Cc);
                        this.paZ.setVisibility(8);
                        AppMethodBeat.o(176977);
                        return;
                    }
                    g(false, true, Cc);
                    this.paZ.setVisibility(0);
                    cjq();
                }
                AppMethodBeat.o(176977);
            } else if (Cz(this.oZZ) || awz(this.oZZ)) {
                this.lrc.setVisibility(4);
                g(true, false, Cc);
                this.paZ.setVisibility(8);
                AppMethodBeat.o(176977);
            } else {
                g(true, false, Cc);
                this.paZ.setVisibility(0);
                cjq();
                AppMethodBeat.o(176977);
            }
        } else {
            this.lrc.setVisibility(8);
            this.paY.setVisibility(8);
            this.paZ.setVisibility(0);
            cjq();
            AppMethodBeat.o(176977);
        }
    }

    private void cjq() {
        AppMethodBeat.i(176978);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.paZ.getLayoutParams();
        layoutParams.gravity = awy(this.oZZ) ? 8388629 : 8388627;
        this.paZ.setLayoutParams(layoutParams);
        if (Cd(this.oZZ) && Ce(this.oZZ)) {
            cjt();
            AppMethodBeat.o(176978);
        } else if (CB(this.oZZ) || Cq(this.oZZ)) {
            this.pbb.setVisibility(8);
            this.pba.setVisibility(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.pba.getLayoutParams();
            layoutParams2.gravity = 8388629;
            int i2 = paJ;
            int i3 = paJ;
            layoutParams2.setMargins(i2, i2, i3, i3);
            this.pba.setLayoutParams(layoutParams2);
            AppMethodBeat.o(176978);
        } else {
            if (Ce(this.oZZ)) {
                this.pba.setVisibility(8);
                C(true, true);
            }
            AppMethodBeat.o(176978);
        }
    }

    private void cjr() {
        AppMethodBeat.i(176979);
        if (awy(this.oZZ)) {
            this.lrc.setVisibility((Cd(this.oZZ) || Ce(this.oZZ)) ? 0 : 4);
            this.paY.setVisibility(0);
            boolean Cc = Cc(this.oZZ);
            if (Ch(this.oZZ) || Cg(this.oZZ)) {
                if (Cz(this.oZZ) || awz(this.oZZ)) {
                    this.lrc.setVisibility(4);
                    g(true, false, Cc);
                    this.paZ.setVisibility(8);
                } else {
                    g(true, false, Cc);
                    this.paZ.setVisibility(0);
                    cjs();
                }
            } else if (CA(this.oZZ)) {
                this.lrc.setVisibility(4);
                g(false, true, Cc);
                this.paZ.setVisibility(8);
            } else {
                g(false, true, Cc);
                this.paZ.setVisibility(0);
                cjs();
            }
        } else {
            this.lrc.setVisibility(8);
            this.paY.setVisibility(8);
            this.paZ.setVisibility(0);
            cjs();
        }
        cjv();
        AppMethodBeat.o(176979);
    }

    private void Y(int i2, boolean z) {
        if (z) {
            this.pbG = ((float) i2) / ((float) this.pbD.y);
        }
        this.pbH = i2;
    }

    private void cjs() {
        AppMethodBeat.i(176980);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.paZ.getLayoutParams();
        layoutParams.gravity = awy(this.oZZ) ? 8388627 : 8388629;
        this.paZ.setLayoutParams(layoutParams);
        if (Cd(this.oZZ) && Ce(this.oZZ)) {
            cju();
            AppMethodBeat.o(176980);
        } else if (CB(this.oZZ) || Cq(this.oZZ)) {
            this.pbb.setVisibility(8);
            this.pba.setVisibility(0);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.pba.getLayoutParams();
            layoutParams2.gravity = 8388629;
            int i2 = paJ;
            int i3 = paJ;
            layoutParams2.setMargins(i2, i2, i3, i3);
            this.pba.setLayoutParams(layoutParams2);
            AppMethodBeat.o(176980);
        } else {
            if (Ce(this.oZZ)) {
                this.pba.setVisibility(8);
                C(false, true);
            }
            AppMethodBeat.o(176980);
        }
    }

    private int C(boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        AppMethodBeat.i(176983);
        this.pbb.setVisibility(0);
        boolean Co = Co(this.oZZ);
        boolean Cn = Cn(this.oZZ);
        boolean Cm = Cm(this.oZZ);
        boolean Cl = Cl(this.oZZ);
        boolean Cd = Cd(this.oZZ);
        boolean awy = awy(this.oZZ);
        int i13 = z ? 8388611 : 8388613;
        boolean z3 = !Cp(this.oZZ) && Cf(this.oZZ);
        int i14 = (Cl || z3) ? paK : paI;
        if (!z2 && !Cd && !awy) {
            if (Cl || Cn || Co || z3) {
                i12 = paK;
            } else {
                i12 = paL;
            }
            i3 = i12;
            i2 = i12;
        } else if (z) {
            i2 = (!Cd || awy) ? paJ : paI;
            i3 = Cd ? paI : paK;
        } else {
            i2 = Cd ? paI : paK;
            i3 = (!Cd || awy) ? paJ : paI;
        }
        if (Cl || z3) {
            this.pbc.setVisibility(0);
            this.pbd.setVisibility(8);
            this.pbe.setVisibility(8);
            this.pbf.setVisibility(8);
            int i15 = 0;
            if (!Cp(this.oZZ) && Cf(this.oZZ)) {
                i15 = getAppBrandVoipBallInfoIndex();
            }
            a(this.pbc, i15);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pbc.getLayoutParams();
            layoutParams.setMargins(i2, i14, i3, i14);
            layoutParams.gravity = i13;
            this.pbc.setLayoutParams(layoutParams);
        } else if (Cm || Cn || Co) {
            this.pbc.setVisibility(0);
            this.pbd.setVisibility(0);
            a(this.pbc, 0);
            a(this.pbd, 1);
            if (Cn) {
                this.pbe.setVisibility(0);
                this.pbf.setVisibility(8);
                a(this.pbe, 2);
                if (z) {
                    i11 = i2 + paG;
                    i10 = 0;
                    i4 = i3;
                    i9 = i2;
                } else {
                    i9 = 0;
                    i10 = i3;
                    i4 = paG + i3;
                    i11 = i2;
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.pbe.getLayoutParams();
                layoutParams2.setMargins(i9, 0, i10, 0);
                layoutParams2.gravity = i13 | 16;
                this.pbe.setLayoutParams(layoutParams2);
                i5 = i11;
            } else if (Co) {
                this.pbe.setVisibility(0);
                this.pbf.setVisibility(0);
                a(this.pbe, 2);
                a(this.pbf, 3);
                if (z) {
                    i6 = 0;
                    i7 = i3;
                    i5 = paG + i2;
                    i8 = i2;
                } else {
                    i6 = i3;
                    i7 = paG + i3;
                    i5 = i2;
                    i8 = 0;
                }
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.pbe.getLayoutParams();
                layoutParams3.setMargins(i8, i14, i6, 0);
                layoutParams3.gravity = i13;
                this.pbe.setLayoutParams(layoutParams3);
                FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.pbf.getLayoutParams();
                layoutParams4.setMargins(i8, layoutParams3.topMargin + paG, i6, 0);
                layoutParams4.gravity = i13;
                this.pbf.setLayoutParams(layoutParams4);
                i4 = i7;
            } else {
                this.pbf.setVisibility(8);
                this.pbe.setVisibility(8);
                i4 = i3;
                i5 = i2;
            }
            FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.pbc.getLayoutParams();
            layoutParams5.setMargins(i5, i14, i4, 0);
            layoutParams5.gravity = i13;
            this.pbc.setLayoutParams(layoutParams5);
            FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.pbd.getLayoutParams();
            layoutParams6.setMargins(i5, layoutParams5.topMargin + paG, i4, i14);
            layoutParams6.gravity = i13;
            this.pbd.setLayoutParams(layoutParams6);
        }
        FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) this.pbb.getLayoutParams();
        layoutParams7.gravity = i13 | 16;
        this.pbb.setLayoutParams(layoutParams7);
        if (Cn || Co) {
            int i16 = (paG * 2) + i2 + i3;
            AppMethodBeat.o(176983);
            return i16;
        }
        int i17 = paG + i2 + i3;
        AppMethodBeat.o(176983);
        return i17;
    }

    private void L(int i2, long j2) {
        AppMethodBeat.i(176984);
        if (i2 == 0) {
            a(this.pbc, j2);
            AppMethodBeat.o(176984);
        } else if (i2 == 1) {
            a(this.pbd, j2);
            AppMethodBeat.o(176984);
        } else if (i2 == 2) {
            a(this.pbe, j2);
            AppMethodBeat.o(176984);
        } else {
            if (i2 == 3) {
                a(this.pbf, j2);
            }
            AppMethodBeat.o(176984);
        }
    }

    private static void a(CircleAnimateView circleAnimateView, long j2) {
        AppMethodBeat.i(176985);
        if (j2 >= 0) {
            circleAnimateView.setProgress(j2);
            AppMethodBeat.o(176985);
            return;
        }
        circleAnimateView.setProgress(-2147483648L);
        AppMethodBeat.o(176985);
    }

    private void a(CircleAnimateView circleAnimateView, int i2) {
        AppMethodBeat.i(176986);
        if (com.tencent.mm.plugin.ball.f.d.h(this.pbz) && this.pbz.size() > i2) {
            BallInfo ballInfo = this.pbz.get(i2);
            int BM = com.tencent.mm.plugin.ball.f.d.BM(ballInfo.state);
            if (-1 != BM) {
                com.tencent.mm.svg.a.a aVar = new com.tencent.mm.svg.a.a();
                if (ImgUtil.isGif(MMApplicationContext.getContext(), BM) || !aVar.j(getResources(), BM)) {
                    circleAnimateView.setImageResource(BM);
                } else {
                    circleAnimateView.setImageBitmap(com.tencent.mm.svg.a.a.i(getResources(), BM));
                }
            }
            if (ballInfo.progress >= 0) {
                circleAnimateView.setProgress(ballInfo.progress);
                AppMethodBeat.o(176986);
                return;
            }
            circleAnimateView.setProgress(-2147483648L);
        }
        AppMethodBeat.o(176986);
    }

    private int getAppBrandVoipBallInfoIndex() {
        AppMethodBeat.i(217081);
        if (com.tencent.mm.plugin.ball.f.d.h(this.pbz)) {
            for (int i2 = 0; i2 < this.pbz.size(); i2++) {
                BallInfo ballInfo = this.pbz.get(i2);
                if (ballInfo != null && ballInfo.type == 17) {
                    AppMethodBeat.o(217081);
                    return i2;
                }
            }
        }
        AppMethodBeat.o(217081);
        return 0;
    }

    private boolean cjv() {
        AppMethodBeat.i(106451);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        int i2 = layoutParams.x;
        int i3 = layoutParams.y;
        if (BS(i2)) {
            int max = Math.max(Math.min(i2, this.pbD.x), 0);
            int max2 = Math.max(Math.min(i3, this.pbD.y), 0);
            int BV = BV(max);
            int BU = BU(max2);
            Log.i("MicroMsg.FloatBallView", "stickToScreenEdgeIfNeed, start:[%s, %s], target:[%s, %s]", Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(BV), Integer.valueOf(BU));
            if (!(max == BV && max2 == BU)) {
                e(BV, BU, true, false);
            }
            AppMethodBeat.o(106451);
            return true;
        }
        AppMethodBeat.o(106451);
        return false;
    }

    private boolean BS(int i2) {
        AppMethodBeat.i(176987);
        if (getCurrentStateWidth() + i2 != this.pbD.x) {
            AppMethodBeat.o(176987);
            return true;
        }
        AppMethodBeat.o(176987);
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(176988);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(176988);
        return dispatchTouchEvent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(217082);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (motionEvent.getAction() == 0) {
            N(motionEvent);
        }
        if (!com.tencent.mm.plugin.ball.f.d.q(this.vk, rawX, rawY)) {
            AppMethodBeat.o(217082);
            return true;
        } else if (motionEvent.getAction() != 2) {
            AppMethodBeat.o(217082);
            return false;
        } else {
            boolean G = G(motionEvent);
            AppMethodBeat.o(217082);
            return G;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106452);
        if (!this.pbB) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(106452);
            return onTouchEvent;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.hbN = false;
                N(motionEvent);
                a(true, this.pbC, true, this.oZZ);
                if (this.pbI) {
                    f(true, this.pbC, true);
                }
                this.oVp = false;
                if (Cp(this.oZZ) && !Cz(this.oZZ) && !CA(this.oZZ) && !awz(this.oZZ)) {
                    this.pbV.postDelayed(this.pbW, (long) this.paS);
                    break;
                }
            case 1:
            case 3:
                if (this.oVp) {
                    a(true, this.pbC, false, this.oZZ);
                    if (this.pbI) {
                        f(true, this.pbC, false);
                    }
                    O(motionEvent);
                    break;
                } else {
                    this.pbV.removeCallbacks(this.pbW);
                    if (!this.hbN && !G(motionEvent)) {
                        a(true, this.pbC, false, this.oZZ);
                        if (this.pbI) {
                            f(true, this.pbC, false);
                        }
                        e(this.pbF.x, this.pbF.y, true, false);
                        if (this.pbK) {
                            float f2 = this.pbE.x;
                            float f3 = this.pbE.y;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis > this.lastClickTime + 800) {
                                this.lastClickTime = currentTimeMillis;
                                if (!com.tencent.mm.plugin.ball.f.d.q(this.vk, (int) f2, (int) f3)) {
                                    if (!CA(this.oZZ) && !Cz(this.oZZ) && !awz(this.oZZ)) {
                                        if (!Cp(this.oZZ)) {
                                            if (!(this.pbM == null || com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) == null)) {
                                                Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked appbrand voip");
                                                this.pbM.oWs.opType = 3;
                                                ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).m(this.pbM);
                                                break;
                                            }
                                        } else {
                                            Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, wechat in foreground");
                                            for (g gVar : this.listeners) {
                                                gVar.chY();
                                            }
                                            break;
                                        }
                                    } else {
                                        Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, ignore click");
                                        break;
                                    }
                                } else {
                                    Log.w("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, click voip unexpectedly");
                                    break;
                                }
                            } else {
                                Log.i("MicroMsg.FloatBallView", "notifyBallClickedIfNeed, you clicked too fast!");
                                break;
                            }
                        }
                    } else {
                        a(false, this.pbC, false, this.oZZ);
                        if (this.hbN) {
                            this.hbN = false;
                            for (g gVar2 : this.listeners) {
                                gVar2.cib();
                            }
                        }
                        int H = H(motionEvent);
                        int I = I(motionEvent);
                        int BV = BV(H);
                        int BU = BU(I);
                        boolean z = BV == 0;
                        Log.i("MicroMsg.FloatBallView", "onTouchEvent, stickToLeft:%s, startSticky:[%s, %s]=>[%s, %s]", Boolean.valueOf(z), Integer.valueOf(H), Integer.valueOf(I), Integer.valueOf(BV), Integer.valueOf(BU));
                        d(z, H, I, BV, BU);
                        break;
                    }
                }
                break;
            case 2:
                if (this.oVp) {
                    O(motionEvent);
                    break;
                } else {
                    if (!this.hbN && G(motionEvent)) {
                        this.pbV.removeCallbacks(this.pbW);
                        this.hbN = true;
                        int i2 = this.pbF.x;
                        int i3 = this.pbF.y;
                        for (g gVar3 : this.listeners) {
                            gVar3.cia();
                        }
                    }
                    if (this.hbN) {
                        e(H(motionEvent), I(motionEvent), false, true);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(106452);
        return true;
    }

    private boolean G(MotionEvent motionEvent) {
        AppMethodBeat.i(106453);
        if (Math.abs(motionEvent.getRawX() - this.pbE.x) > ((float) this.paR) || Math.abs(motionEvent.getRawY() - this.pbE.y) > ((float) this.paR)) {
            AppMethodBeat.o(106453);
            return true;
        }
        AppMethodBeat.o(106453);
        return false;
    }

    private void N(MotionEvent motionEvent) {
        AppMethodBeat.i(217083);
        this.pbE.x = motionEvent.getRawX();
        this.pbE.y = motionEvent.getRawY();
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        this.pbF.x = layoutParams.x;
        this.pbF.y = layoutParams.y;
        AppMethodBeat.o(217083);
    }

    private int H(MotionEvent motionEvent) {
        AppMethodBeat.i(106454);
        int max = (int) Math.max(Math.min((((float) this.pbF.x) + motionEvent.getRawX()) - this.pbE.x, (float) this.pbD.x), 0.0f);
        AppMethodBeat.o(106454);
        return max;
    }

    private int I(MotionEvent motionEvent) {
        AppMethodBeat.i(106455);
        int max = (int) Math.max(Math.min((((float) this.pbF.y) + motionEvent.getRawY()) - this.pbE.y, (float) this.pbD.y), 0.0f);
        AppMethodBeat.o(106455);
        return max;
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(106456);
        f(i2, i3, z, z2);
        AppMethodBeat.o(106456);
    }

    private void f(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(217084);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        int i4 = layoutParams.x;
        int i5 = layoutParams.y;
        if (!(this.windowManager == null || (i4 == i2 && i5 == i3))) {
            layoutParams.x = i2;
            layoutParams.y = i3;
            try {
                this.windowManager.updateViewLayout(this, layoutParams);
                g(i2, i3, z, z2);
                AppMethodBeat.o(217084);
                return;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.FloatBallView", th, "updateBallPosition fail", new Object[0]);
            }
        }
        AppMethodBeat.o(217084);
    }

    public final void g(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(106457);
        this.pbC = BT(i2);
        a(z, this.pbC, z2, this.oZZ);
        f(z, this.pbC, z2);
        Y(i3, z);
        Log.i("MicroMsg.FloatBallView", "notifyBallPositionChanged, x:%s, y:%s, isSettled:%s, isManual:%s, isDockLeft:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(this.pbC));
        for (g gVar : this.listeners) {
            gVar.a(i2, i3, getCurrentStateHeight(), z, this.pbC);
        }
        AppMethodBeat.o(106457);
    }

    private void a(boolean z, boolean z2, boolean z3, int i2) {
        AppMethodBeat.i(176989);
        if (this.pbY == z && this.pbZ == z2 && this.pbX == z3 && this.pca == i2) {
            AppMethodBeat.o(176989);
            return;
        }
        Log.i("MicroMsg.FloatBallView", "updateFloatBallBackground, isSettled:%s, isDockLeft:%s, isManual:%s, state:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2));
        this.pca = i2;
        this.pbX = z3;
        this.pbY = z;
        this.pbZ = z2;
        boolean awy = awy(i2);
        boolean Cr = Cr(i2);
        if (z) {
            if (z2) {
                if (z3) {
                    if (awy) {
                        this.paX.setBackground(this.pbv);
                        AppMethodBeat.o(176989);
                    } else if (Cr) {
                        this.paX.setBackground(this.pbp);
                        AppMethodBeat.o(176989);
                    } else {
                        this.paX.setBackground(this.pbj);
                        AppMethodBeat.o(176989);
                    }
                } else if (awy) {
                    this.paX.setBackground(this.pbs);
                    AppMethodBeat.o(176989);
                } else if (Cr) {
                    this.paX.setBackground(this.pbm);
                    AppMethodBeat.o(176989);
                } else {
                    this.paX.setBackground(this.pbg);
                    AppMethodBeat.o(176989);
                }
            } else if (z3) {
                if (awy) {
                    this.paX.setBackground(this.pbw);
                    AppMethodBeat.o(176989);
                } else if (Cr) {
                    this.paX.setBackground(this.pbq);
                    AppMethodBeat.o(176989);
                } else {
                    this.paX.setBackground(this.pbk);
                    AppMethodBeat.o(176989);
                }
            } else if (awy) {
                this.paX.setBackground(this.pbt);
                AppMethodBeat.o(176989);
            } else if (Cr) {
                this.paX.setBackground(this.pbn);
                AppMethodBeat.o(176989);
            } else {
                this.paX.setBackground(this.pbh);
                AppMethodBeat.o(176989);
            }
        } else if (z3) {
            if (awy) {
                this.paX.setBackground(this.pbx);
                AppMethodBeat.o(176989);
            } else if (Cr) {
                this.paX.setBackground(this.pbr);
                AppMethodBeat.o(176989);
            } else {
                this.paX.setBackground(this.pbl);
                AppMethodBeat.o(176989);
            }
        } else if (awy) {
            this.paX.setBackground(this.pbu);
            AppMethodBeat.o(176989);
        } else if (Cr) {
            this.paX.setBackground(this.pbo);
            AppMethodBeat.o(176989);
        } else {
            this.paX.setBackground(this.pbi);
            AppMethodBeat.o(176989);
        }
    }

    public final boolean BT(int i2) {
        AppMethodBeat.i(106459);
        if ((getCurrentStateWidth() / 2) + i2 <= this.pbD.x / 2) {
            AppMethodBeat.o(106459);
            return true;
        }
        AppMethodBeat.o(106459);
        return false;
    }

    private void cjw() {
        AppMethodBeat.i(176990);
        for (int i2 = 0; i2 < this.pbz.size(); i2++) {
            long j2 = this.pbz.get(i2).progress;
            if (j2 >= 0) {
                L(i2, j2);
            }
        }
        AppMethodBeat.o(176990);
    }

    public void setEnableClick(boolean z) {
        AppMethodBeat.i(217086);
        Log.d("MicroMsg.FloatBallView", "alvinluo setEnableClick enable: %b", Boolean.valueOf(z));
        this.pbK = z;
        AppMethodBeat.o(217086);
    }

    public void setFloatBallAlpha(final float f2) {
        boolean z;
        AppMethodBeat.i(106460);
        b bVar = this.paV;
        if (bVar.chI() || bVar.chJ()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha later, alpha:%s", Float.valueOf(f2));
            this.paV.oWi.add(new Runnable() {
                /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(217070);
                    Log.i("MicroMsg.FloatBallView", "setFloatBallAlpha when animation ends, alpha:%s", Float.valueOf(f2));
                    FloatBallView.a(FloatBallView.this, f2);
                    AppMethodBeat.o(217070);
                }
            });
            AppMethodBeat.o(106460);
            return;
        }
        Log.printInfoStack("MicroMsg.FloatBallView", "setFloatBallAlpha right now, alpha:%s", Float.valueOf(f2));
        setFloatBallAlphaInternal(f2);
        AppMethodBeat.o(106460);
    }

    private void setFloatBallAlphaInternal(float f2) {
        AppMethodBeat.i(106461);
        setAlpha(f2);
        if (f2 == 0.0f) {
            Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, GONE");
            setVisibility(8);
            AppMethodBeat.o(106461);
            return;
        }
        Log.i("MicroMsg.FloatBallView", "setFloatBallAlphaInternal, VISIBLE, alpha:%s", Float.valueOf(f2));
        setVisibility(0);
        AppMethodBeat.o(106461);
    }

    public void setNeedTranslateAnimation(boolean z) {
        this.oYj = z;
    }

    private void d(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(217087);
        Log.i("MicroMsg.FloatBallView", "alvinluo showByTranslation");
        setNeedTranslateAnimation(false);
        if (this.paV != null) {
            this.paV.a(getCurrentStateWidth(), BT(((WindowManager.LayoutParams) getLayoutParams()).x), animatorListenerAdapter);
        }
        AppMethodBeat.o(217087);
    }

    public final void cjy() {
        AppMethodBeat.i(184622);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.en(false);
        bVar.bm(null);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, bVar.axR());
        c(false, false, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", "show", "(ZLandroid/animation/AnimatorListenerAdapter;)V");
        AppMethodBeat.o(184622);
    }

    public final void c(boolean z, boolean z2, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184623);
        if (getVisibility() == 0 && z2) {
            Log.i("MicroMsg.FloatBallView", "float ball already show");
            AppMethodBeat.o(184623);
        } else if (!z || this.paV == null) {
            Log.i("MicroMsg.FloatBallView", "show without animation");
            setVisibility(0);
            AppMethodBeat.o(184623);
        } else {
            Log.i("MicroMsg.FloatBallView", "show with animation");
            this.paV.a(animatorListenerAdapter);
            AppMethodBeat.o(184623);
        }
    }

    public final void b(boolean z, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(184624);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.en(z);
        bVar.bm(animatorListenerAdapter);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(ZLandroid/animation/AnimatorListenerAdapter;)V", this, bVar.axR());
        if (getVisibility() == 8) {
            Log.i("MicroMsg.FloatBallView", "float ball already hide");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(ZLandroid/animation/AnimatorListenerAdapter;)V");
            AppMethodBeat.o(184624);
            return;
        }
        if (!z || this.paV == null) {
            Log.i("MicroMsg.FloatBallView", "hide without animation");
            setVisibility(8);
            cjB();
        } else {
            Log.i("MicroMsg.FloatBallView", "hide with animation");
            this.paV.b(animatorListenerAdapter);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatBallView", "com/tencent/mm/plugin/ball/view/FloatBallView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(ZLandroid/animation/AnimatorListenerAdapter;)V");
        AppMethodBeat.o(184624);
    }

    private void d(boolean z, final int i2, final int i3, final int i4, final int i5) {
        AppMethodBeat.i(106464);
        Log.i("MicroMsg.FloatBallView", "start StickyAnimation, stickToLeft:%s, startPositionY: %d, targetPositionY: %d", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i5));
        if (this.paU != null && this.paU.isRunning()) {
            Log.i("MicroMsg.FloatBallView", "cancel StickyAnimation");
            this.paU.cancel();
        }
        this.paU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.paU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.paU.setDuration(100L);
        this.paU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(217071);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatBallView.this.e(i2 + ((int) (((((float) i4) * 1.0f) - ((float) i2)) * floatValue)), ((int) (floatValue * ((((float) i5) * 1.0f) - ((float) i3)))) + i3, false, false);
                AppMethodBeat.o(217071);
            }
        });
        this.paU.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass5 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(217072);
                super.onAnimationEnd(animator);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) FloatBallView.this.getLayoutParams();
                FloatBallView.this.g(layoutParams.x, layoutParams.y, true, false);
                AppMethodBeat.o(217072);
            }
        });
        this.paU.start();
        AppMethodBeat.o(106464);
    }

    private static int BU(int i2) {
        if (i2 < e.oYS) {
            return e.oYS;
        }
        if (i2 > e.oYT) {
            return e.oYT;
        }
        return i2;
    }

    private int BV(int i2) {
        AppMethodBeat.i(106465);
        int i3 = 0;
        if (!BT(i2)) {
            i3 = this.pbD.x - getCurrentStateWidth();
        }
        AppMethodBeat.o(106465);
        return i3;
    }

    private int getTargetPositionXWhenOrientationChanged() {
        AppMethodBeat.i(106466);
        int i2 = 0;
        if (!this.pbC) {
            i2 = this.pbD.x - getCurrentStateWidth();
        }
        AppMethodBeat.o(106466);
        return i2;
    }

    private int BW(int i2) {
        AppMethodBeat.i(217088);
        int width = getWidth();
        if (Cq(i2)) {
            width = pac;
        } else if (Cr(i2) || (!Cp(i2) && Cf(i2))) {
            width = paM;
        } else if (Cs(i2)) {
            width = paN;
        } else if (Ct(i2) || Cu(i2)) {
            width = paO;
        } else if (Cv(i2) || Cw(i2)) {
            width = pae;
        } else if (Cx(i2) || Cy(i2)) {
            width = pae + paG;
        }
        AppMethodBeat.o(217088);
        return width;
    }

    private int BX(int i2) {
        AppMethodBeat.i(217089);
        int height = getHeight();
        if (Cq(i2)) {
            height = pad;
        } else if (Cr(i2)) {
            height = paM;
        } else if (Cs(i2)) {
            height = paN;
        } else if (Ct(i2) || Cu(i2)) {
            height = paN;
        } else if (Cv(i2) || Cw(i2) || Cx(i2) || Cy(i2)) {
            height = paf;
        } else if (Cx(this.oZZ) || Cy(this.oZZ)) {
            height = paf;
        }
        AppMethodBeat.o(217089);
        return height;
    }

    public int getCurrentStateWidth() {
        int BW;
        AppMethodBeat.i(106467);
        int i2 = this.oZZ;
        Log.v("MicroMsg.FloatBallView", "getStateWidth state: %d", Integer.valueOf(i2));
        if (awy(i2)) {
            BW = Ca(i2) + (this.pbO * 2);
        } else {
            BW = BW(i2);
        }
        int i3 = BW + e.oYN;
        AppMethodBeat.o(106467);
        return i3;
    }

    private int getCurrentStateHeight() {
        int BX;
        AppMethodBeat.i(176991);
        int i2 = this.oZZ;
        Log.v("MicroMsg.FloatBallView", "getStateHeight state: %d", Integer.valueOf(i2));
        if (awy(i2)) {
            BX = Cb(i2) + (this.pbO * 2);
            if (Cd(i2) || Ce(i2)) {
                BX += paH + (paJ * 2) + paP;
            }
        } else {
            BX = BX(i2);
        }
        int i3 = BX + e.oYL + e.oYM;
        AppMethodBeat.o(176991);
        return i3;
    }

    private void cjz() {
        int i2;
        int i3;
        int i4;
        int i5;
        AppMethodBeat.i(106468);
        if (Cp(this.oZZ)) {
            if (awy(this.oZZ)) {
                i3 = (this.pbO * 2) + Ca(this.oZZ);
                i2 = Cb(this.oZZ) + (this.pbO * 2);
                if (Cd(this.oZZ) || Ce(this.oZZ)) {
                    i2 += paH + (paJ * 2) + paP;
                }
            } else {
                i3 = BW(this.oZZ);
                i2 = BX(this.oZZ);
            }
        } else if (awy(this.oZZ)) {
            if (this.pbL == null || !this.pbL.oWu) {
                i3 = (this.pbO * 2) + Ca(this.oZZ);
                i2 = Cb(this.oZZ) + (this.pbO * 2);
            } else {
                i2 = 0;
                i3 = 0;
            }
        } else if (Cf(this.oZZ)) {
            i3 = paM;
            i2 = paM;
        } else {
            i2 = 0;
            i3 = 0;
        }
        int verticalShadowSize = getVerticalShadowSize();
        int horizontalShadowSize = getHorizontalShadowSize();
        if (i3 == 0 || i2 == 0) {
            i4 = 0;
            i5 = 0;
        } else {
            i5 = this.pbN.x + i3 + verticalShadowSize + getExtendWidth();
            i4 = this.pbN.y + i2 + horizontalShadowSize;
        }
        eY(i5, i4);
        AppMethodBeat.o(106468);
    }

    private void eY(int i2, int i3) {
        AppMethodBeat.i(217090);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (i2 == 0 || i3 == 0) {
            layoutParams.width = 0;
            layoutParams.height = 0;
        } else {
            layoutParams.width = i2;
            layoutParams.height = i3;
        }
        try {
            this.windowManager.updateViewLayout(this, layoutParams);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallView", e2, "updateFloatBallViewSize exception", new Object[0]);
        }
        Log.i("MicroMsg.FloatBallView", "updateFloatBallViewSize, width:%s, height:%s", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        for (g gVar : this.listeners) {
            gVar.a(layoutParams.x, layoutParams.y, layoutParams.height, this.pbS, this.pbC);
        }
        AppMethodBeat.o(217090);
    }

    private int getExtendWidth() {
        AppMethodBeat.i(106469);
        if (!this.pbI) {
            AppMethodBeat.o(106469);
            return 0;
        } else if (!com.tencent.mm.plugin.ball.f.d.eF(getContext())) {
            AppMethodBeat.o(106469);
            return 0;
        } else {
            int rotation = this.windowManager.getDefaultDisplay().getRotation();
            if ((!this.pbC || rotation != 1) && (this.pbC || rotation != 3)) {
                AppMethodBeat.o(106469);
                return 0;
            }
            int aP = com.tencent.mm.plugin.ball.f.d.aP(getContext());
            AppMethodBeat.o(106469);
            return aP;
        }
    }

    public Point getBallPosition() {
        AppMethodBeat.i(106470);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            AppMethodBeat.o(106470);
            return null;
        } else if (this.pbC) {
            if (Ch(this.oZZ) || Cg(this.oZZ)) {
                Point point = new Point(layoutParams.x, layoutParams.y + e.oYL + paz);
                AppMethodBeat.o(106470);
                return point;
            } else if (Ck(this.oZZ)) {
                Point point2 = new Point(layoutParams.x, layoutParams.y + e.oYL + paD);
                AppMethodBeat.o(106470);
                return point2;
            } else {
                Point point3 = new Point(layoutParams.x, layoutParams.y + e.oYL);
                AppMethodBeat.o(106470);
                return point3;
            }
        } else if (Ch(this.oZZ) || Cg(this.oZZ)) {
            Point point4 = new Point(layoutParams.x + e.oYN, layoutParams.y + e.oYL + paz);
            AppMethodBeat.o(106470);
            return point4;
        } else if (Ck(this.oZZ)) {
            Point point5 = new Point(layoutParams.x + e.oYN, layoutParams.y + e.oYL + paD);
            AppMethodBeat.o(106470);
            return point5;
        } else {
            Point point6 = new Point(layoutParams.x + e.oYN, layoutParams.y + e.oYL);
            AppMethodBeat.o(106470);
            return point6;
        }
    }

    public Point getFloatBallPosition() {
        AppMethodBeat.i(217091);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            AppMethodBeat.o(217091);
            return null;
        } else if (this.pbC) {
            Point point = new Point(layoutParams.x, layoutParams.y + e.oYL);
            AppMethodBeat.o(217091);
            return point;
        } else {
            Point point2 = new Point(layoutParams.x + e.oYN, layoutParams.y + e.oYL);
            AppMethodBeat.o(217091);
            return point2;
        }
    }

    public Point getBallSize() {
        AppMethodBeat.i(217092);
        Log.v("MicroMsg.FloatBallView", "alvinluo getBallSize stateWidth: %d, stateHeight: %d", Integer.valueOf(getCurrentStateWidth()), Integer.valueOf(getCurrentStateHeight()));
        Point point = new Point(getCurrentStateWidth() - e.oYN, (getCurrentStateHeight() - e.oYL) - e.oYM);
        AppMethodBeat.o(217092);
        return point;
    }

    public float getPosYPercentOfScreen() {
        return this.pbG;
    }

    public int getPositionY() {
        return this.pbH;
    }

    public void setInnerView(View view) {
        AppMethodBeat.i(106471);
        if (view == this.paW) {
            AppMethodBeat.o(106471);
            return;
        }
        this.pba.removeAllViews();
        this.paW = view;
        if (this.paW != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.pba.addView(this.paW, layoutParams);
        }
        AppMethodBeat.o(106471);
    }

    public final void jQ(boolean z) {
        AppMethodBeat.i(176992);
        Log.i("MicroMsg.FloatBallView", "markWechatInForeground, visibility:%s, inForeground:%s", Integer.valueOf(getVisibility()), Boolean.valueOf(z));
        if (z) {
            this.oZZ |= 32;
        } else {
            this.oZZ &= -33;
            if (awy(this.oZZ) || Cf(this.oZZ)) {
                cjy();
                if (((int) getAlpha()) == 0) {
                    setAlpha(1.0f);
                }
            }
        }
        f(this.pbS, this.pbT, this.pbR);
        AppMethodBeat.o(176992);
    }

    public void setCustomView(BallInfo ballInfo) {
        AppMethodBeat.i(217093);
        View view = ballInfo.vk;
        if (view == this.vk) {
            Log.w("MicroMsg.FloatBallView", "setCustomView voipView not changed");
            AppMethodBeat.o(217093);
            return;
        }
        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            Log.i("MicroMsg.FloatBallView", "setCustomView remove from parent first");
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.paY.removeAllViews();
        this.vk = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.paY.addView(this.vk, layoutParams);
        this.oWm = ballInfo.oWm;
        this.pbP = true;
        cjC();
        if (this.pbL.oWt != null) {
            Point point = this.pbL.oWt.oWv;
            Point point2 = this.pbL.oWt.oWw;
            if (h(point) && h(point2)) {
                this.pbQ = 80;
                if (point.x < point2.x && point.y < point2.y) {
                    this.pbN.x = point2.x - point.x;
                    this.pbN.y = point2.y - point.y;
                    this.pbP = false;
                }
            }
            Log.v("MicroMsg.FloatBallView", "alvinluo updateVoipViewParams startSize: %s, endSize: %s, extraSize: %s, voipViewSize: %s", point, point2, this.pbN, this.oWm);
        }
        AppMethodBeat.o(217093);
    }

    public static boolean h(Point point) {
        return point != null && point.x > 0 && point.y > 0;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(106472);
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class) == null || !((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).chV()) {
            super.setVisibility(i2);
            int alpha = (int) getAlpha();
            if (alpha == 0) {
                this.pbB = false;
                Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, disableTouch", Integer.valueOf(i2), Integer.valueOf(alpha));
                AppMethodBeat.o(106472);
                return;
            }
            if (alpha == 1) {
                this.pbB = true;
                Log.printInfoStack("MicroMsg.FloatBallView", "setVisibility:%s, alphaInt:%s, enableTouch", Integer.valueOf(i2), Integer.valueOf(alpha));
                cjA();
            }
            AppMethodBeat.o(106472);
            return;
        }
        super.setVisibility(8);
        AppMethodBeat.o(106472);
    }

    public void setAlpha(float f2) {
        AppMethodBeat.i(106473);
        super.setAlpha(f2);
        Log.printInfoStack("MicroMsg.FloatBallView", "setAlpha:%s", Float.valueOf(f2));
        cjA();
        AppMethodBeat.o(106473);
    }

    private void cjA() {
        int i2;
        AppMethodBeat.i(217094);
        if (((int) getAlpha()) == 1 && getVisibility() == 0 && (i2 = getResources().getConfiguration().orientation) != this.lastOrientation) {
            Log.i("MicroMsg.FloatBallView", "alvinluo checkOrientationIfNeed currentOrientation: %d, lastOrientation: %d", Integer.valueOf(i2), Integer.valueOf(this.lastOrientation));
            BR(i2);
        }
        AppMethodBeat.o(217094);
    }

    private static String cs(List<BallInfo> list) {
        AppMethodBeat.i(106474);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BallInfo ballInfo = list.get(i2);
            sb.append(ballInfo.key).append(ballInfo.type).append(ballInfo.icon).append(ballInfo.noe).append(ballInfo.state).append(ballInfo.oWr).append(ballInfo.nno).append(ballInfo.progress);
            if (com.tencent.mm.plugin.ball.f.d.H(ballInfo) && ballInfo.vk != null) {
                sb.append(ballInfo.vk.hashCode());
            }
            sb.append("|");
        }
        String mD5String = MD5Util.getMD5String(sb.toString());
        AppMethodBeat.o(106474);
        return mD5String;
    }

    private void cjB() {
        AppMethodBeat.i(217095);
        if (!this.pbP) {
            AppMethodBeat.o(217095);
            return;
        }
        try {
            if (!(this.pbN.x == 0 && this.pbN.y == 0)) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
                int i2 = this.pbC ? 0 : layoutParams.x + this.pbN.x;
                cjC();
                this.pbQ = 16;
                cjz();
                e(i2, layoutParams.y + this.pbN.y, true, false);
            }
            AppMethodBeat.o(217095);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FloatBallView", e2, "alvinluo resetFloatBallViewSizeAndPosition", new Object[0]);
            AppMethodBeat.o(217095);
        }
    }

    private void cjC() {
        AppMethodBeat.i(217096);
        Log.v("MicroMsg.FloatBallView", "alvinluo resetExtraSize");
        this.pbN.x = 0;
        this.pbN.y = 0;
        AppMethodBeat.o(217096);
    }

    private void BY(int i2) {
        this.oZZ &= i2 ^ -1;
    }

    private void BZ(int i2) {
        this.oZZ |= i2;
    }

    private int Ca(int i2) {
        AppMethodBeat.i(217097);
        int h2 = h(Ch(i2) || Cg(i2), Ck(i2), Cc(i2));
        AppMethodBeat.o(217097);
        return h2;
    }

    public final int h(boolean z, boolean z2, boolean z3) {
        if (!z && !z2) {
            return 0;
        }
        if (this.oWm == null || this.oWm.x <= 0 || this.oWm.y <= 0) {
            return z ? z3 ? paA + (paQ * 2) : pay + (paQ * 2) : z3 ? paE + (paQ * 2) : paC + (paQ * 2);
        }
        int i2 = this.oWm.x;
        if (z3) {
            int i3 = z ? paA + (paQ * 2) : paE + (paQ * 2);
            if (i2 < i3) {
                return i3;
            }
        }
        return i2;
    }

    private int Cb(int i2) {
        AppMethodBeat.i(217098);
        int a2 = a(i2, Ch(i2) || Cg(i2), Ck(i2), Cc(i2));
        AppMethodBeat.o(217098);
        return a2;
    }

    public final int a(int i2, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(217099);
        int i3 = 0;
        if (z || z2) {
            if (this.oWm != null && this.oWm.x > 0 && this.oWm.y > 0) {
                i3 = this.oWm.y;
            } else if (z) {
                i3 = paz + (paQ * 2);
            } else {
                i3 = paD + (paQ * 2);
            }
            if (z3) {
                if (!Ci(i2) && !Cj(i2)) {
                    i3 = z ? paB + (paQ * 2) : paF + (paQ * 2);
                } else if (this.oWm == null || this.oWm.x <= 0 || this.oWm.y <= 0) {
                    i3 = paD + (paQ * 2);
                } else {
                    int i4 = this.oWm.y;
                    AppMethodBeat.o(217099);
                    return i4;
                }
            }
        }
        AppMethodBeat.o(217099);
        return i3;
    }

    private int getVerticalShadowSize() {
        if (this.pbL == null || this.pbL.oWn == null) {
            return e.oYL + e.oYM;
        }
        return this.pbL.oWn.x > 0 ? this.pbL.oWn.x : e.oYL + e.oYM;
    }

    private int getHorizontalShadowSize() {
        if (this.pbL == null || this.pbL.oWn == null) {
            return e.oYN * 2;
        }
        return this.pbL.oWn.y > 0 ? this.pbL.oWn.y : e.oYN * 2;
    }

    public final boolean Cc(int i2) {
        AppMethodBeat.i(217100);
        if (!Cd(i2) || this.pab < 3) {
            AppMethodBeat.o(217100);
            return false;
        }
        AppMethodBeat.o(217100);
        return true;
    }

    private void O(MotionEvent motionEvent) {
        AppMethodBeat.i(106475);
        for (g gVar : this.listeners) {
            gVar.M(motionEvent);
        }
        AppMethodBeat.o(106475);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(217101);
        this.listeners.add(gVar);
        AppMethodBeat.o(217101);
    }

    private static boolean Cd(int i2) {
        return (i2 & 1) != 0;
    }

    private static boolean Ce(int i2) {
        AppMethodBeat.i(176994);
        if (Cl(i2) || Cm(i2) || Cn(i2) || Co(i2)) {
            AppMethodBeat.o(176994);
            return true;
        }
        AppMethodBeat.o(176994);
        return false;
    }

    private static boolean Cf(int i2) {
        return ((i2 & 256) == 0 && (i2 & 512) == 0) ? false : true;
    }

    private static boolean awy(int i2) {
        AppMethodBeat.i(258549);
        if (Ch(i2) || Ck(i2) || Cg(i2)) {
            AppMethodBeat.o(258549);
            return true;
        }
        AppMethodBeat.o(258549);
        return false;
    }

    private static boolean Cg(int i2) {
        AppMethodBeat.i(217102);
        if ((i2 & 4096) != 0) {
            AppMethodBeat.o(217102);
            return true;
        }
        AppMethodBeat.o(217102);
        return false;
    }

    public static boolean Ch(int i2) {
        return (i2 & 8) != 0;
    }

    private static boolean Ci(int i2) {
        return (i2 & 1024) != 0;
    }

    private static boolean Cj(int i2) {
        return (i2 & 2048) != 0;
    }

    public static boolean Ck(int i2) {
        return (i2 & 16) != 0;
    }

    private static boolean Cl(int i2) {
        return (i2 & 2) != 0;
    }

    private static boolean Cm(int i2) {
        return (i2 & 4) != 0;
    }

    private static boolean Cn(int i2) {
        return (i2 & 64) != 0;
    }

    private static boolean Co(int i2) {
        return (i2 & 128) != 0;
    }

    private static boolean Cp(int i2) {
        return (i2 & 32) != 0;
    }

    private static boolean Cq(int i2) {
        AppMethodBeat.i(176996);
        if (!Cd(i2) || awy(i2) || Ce(i2)) {
            AppMethodBeat.o(176996);
            return false;
        }
        AppMethodBeat.o(176996);
        return true;
    }

    private static boolean Cr(int i2) {
        AppMethodBeat.i(176997);
        if (!Cl(i2) || awy(i2) || Cd(i2)) {
            AppMethodBeat.o(176997);
            return false;
        }
        AppMethodBeat.o(176997);
        return true;
    }

    private static boolean Cs(int i2) {
        AppMethodBeat.i(176998);
        if (!Cm(i2) || awy(i2) || Cd(i2)) {
            AppMethodBeat.o(176998);
            return false;
        }
        AppMethodBeat.o(176998);
        return true;
    }

    private static boolean Ct(int i2) {
        AppMethodBeat.i(176999);
        if (!Cn(i2) || awy(i2) || Cd(i2)) {
            AppMethodBeat.o(176999);
            return false;
        }
        AppMethodBeat.o(176999);
        return true;
    }

    private static boolean Cu(int i2) {
        AppMethodBeat.i(217103);
        if (!Co(i2) || awy(i2) || Cd(i2)) {
            AppMethodBeat.o(217103);
            return false;
        }
        AppMethodBeat.o(217103);
        return true;
    }

    private static boolean Cv(int i2) {
        AppMethodBeat.i(177000);
        if (!Cl(i2) || !Cd(i2) || awy(i2)) {
            AppMethodBeat.o(177000);
            return false;
        }
        AppMethodBeat.o(177000);
        return true;
    }

    private static boolean Cw(int i2) {
        AppMethodBeat.i(177001);
        if (!Cm(i2) || !Cd(i2) || awy(i2)) {
            AppMethodBeat.o(177001);
            return false;
        }
        AppMethodBeat.o(177001);
        return true;
    }

    private static boolean Cx(int i2) {
        AppMethodBeat.i(177002);
        if (!Cn(i2) || !Cd(i2) || awy(i2)) {
            AppMethodBeat.o(177002);
            return false;
        }
        AppMethodBeat.o(177002);
        return true;
    }

    private static boolean Cy(int i2) {
        AppMethodBeat.i(217104);
        if (!Co(i2) || !Cd(i2) || awy(i2)) {
            AppMethodBeat.o(217104);
            return false;
        }
        AppMethodBeat.o(217104);
        return true;
    }

    private static boolean Cz(int i2) {
        AppMethodBeat.i(217105);
        if (!Ch(i2) || Cd(i2) || Ce(i2)) {
            AppMethodBeat.o(217105);
            return false;
        }
        AppMethodBeat.o(217105);
        return true;
    }

    private static boolean CA(int i2) {
        AppMethodBeat.i(217106);
        if (!Ck(i2) || Cd(i2) || Ce(i2)) {
            AppMethodBeat.o(217106);
            return false;
        }
        AppMethodBeat.o(217106);
        return true;
    }

    private static boolean awz(int i2) {
        AppMethodBeat.i(258550);
        if (!Cg(i2) || Cd(i2) || Ce(i2)) {
            AppMethodBeat.o(258550);
            return false;
        }
        AppMethodBeat.o(258550);
        return true;
    }

    private static boolean CB(int i2) {
        AppMethodBeat.i(217107);
        if (!Cd(i2) || !awy(i2) || Ce(i2)) {
            AppMethodBeat.o(217107);
            return false;
        }
        AppMethodBeat.o(217107);
        return true;
    }

    private void cjt() {
        AppMethodBeat.i(176981);
        int C = C(true, true);
        this.pba.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pba.getLayoutParams();
        layoutParams.gravity = 8388627;
        int i2 = paJ;
        layoutParams.setMargins(C, i2, i2, paJ);
        this.pba.setLayoutParams(layoutParams);
        AppMethodBeat.o(176981);
    }

    private void cju() {
        AppMethodBeat.i(176982);
        int C = C(false, true);
        this.pba.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.pba.getLayoutParams();
        layoutParams.gravity = 8388629;
        int i2 = paJ;
        layoutParams.setMargins(i2, i2, C, paJ);
        this.pba.setLayoutParams(layoutParams);
        AppMethodBeat.o(176982);
    }

    private void cjx() {
        AppMethodBeat.i(217085);
        if (this.oYj) {
            d(new AnimatorListenerAdapter() {
                /* class com.tencent.mm.plugin.ball.view.FloatBallView.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(217067);
                    super.onAnimationStart(animator);
                    FloatBallView.this.pbJ = true;
                    AppMethodBeat.o(217067);
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(217068);
                    super.onAnimationEnd(animator);
                    FloatBallView.this.pbJ = false;
                    AppMethodBeat.o(217068);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(217069);
                    super.onAnimationCancel(animator);
                    FloatBallView.this.pbJ = false;
                    AppMethodBeat.o(217069);
                }
            });
        }
        AppMethodBeat.o(217085);
    }

    static /* synthetic */ void b(FloatBallView floatBallView) {
        AppMethodBeat.i(106476);
        if (floatBallView.paT != null) {
            floatBallView.paT.vibrate(10);
        }
        AppMethodBeat.o(106476);
    }

    static /* synthetic */ void a(FloatBallView floatBallView, int i2) {
        AppMethodBeat.i(217109);
        Log.i("MicroMsg.FloatBallView", "switchVoipState state: %d", Integer.valueOf(i2));
        if (i2 == 16) {
            floatBallView.BY(8);
            floatBallView.BZ(16);
        } else if (i2 == 1024) {
            floatBallView.BY(16);
            floatBallView.BZ(8);
            floatBallView.BY(2048);
            floatBallView.BZ(1024);
        }
        floatBallView.paa = floatBallView.oZZ;
        AppMethodBeat.o(217109);
    }
}
