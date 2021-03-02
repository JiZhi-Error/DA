package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class AppBrandPipContainerView extends FrameLayout {
    public static final int oka = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 196);
    public static final int okb = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 119);
    public static final int okc = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
    public static final int okd = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 99);
    public static final int oke = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 119);
    public static final int okf = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 196);
    public static final int okg = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 99);
    public static final int okh = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6);
    private static final int oki = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
    private static final int okj = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 56);
    private static final int okk = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 52);
    private static final int okl = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
    private static final int okm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 80);
    private static final int okn = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 52);
    public static final int oko = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    public static final int okp = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    public static final int okq = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    public static final int okr = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    public static final int oks = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10);
    public static final int okt = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    private static final int oku = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
    private static final Point okv = new Point();
    public Point inq;
    public int mCurOrientation;
    private int nCG;
    private PointF okA;
    private PointF okB;
    public float okC;
    private boolean okD;
    public boolean okE;
    public int okF;
    public int okG;
    public Set<a> okH;
    private Float okI;
    public ViewOutlineProvider okJ;
    private ValueAnimator okK;
    public ViewGroup okL;
    private View okM;
    public View okN;
    private ViewGroup okO;
    private View okP;
    private View okQ;
    private View okR;
    private boolean okS;
    public boolean okT;
    private boolean okU;
    private ai okV;
    public Integer okw;
    private int okx;
    public Point oky;
    private boolean okz;

    public interface a {
        void ev(int i2, int i3);
    }

    static /* synthetic */ void a(AppBrandPipContainerView appBrandPipContainerView, float f2) {
        AppMethodBeat.i(176822);
        appBrandPipContainerView.a(f2, true);
        AppMethodBeat.o(176822);
    }

    static /* synthetic */ void a(AppBrandPipContainerView appBrandPipContainerView, float f2, float f3) {
        AppMethodBeat.i(176821);
        appBrandPipContainerView.O(f2, f3);
        AppMethodBeat.o(176821);
    }

    static /* synthetic */ void a(AppBrandPipContainerView appBrandPipContainerView, int i2, int i3) {
        AppMethodBeat.i(219611);
        appBrandPipContainerView.eC(i2, i3);
        AppMethodBeat.o(219611);
    }

    static {
        AppMethodBeat.i(176823);
        AppMethodBeat.o(176823);
    }

    public AppBrandPipContainerView(Context context) {
        this(context, null);
    }

    public AppBrandPipContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandPipContainerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(176792);
        this.okw = null;
        this.oky = okv;
        this.inq = okv;
        this.okz = false;
        this.okA = new PointF();
        this.okB = new PointF();
        this.okC = -1.0f;
        this.okD = false;
        this.okE = false;
        this.okH = null;
        this.nCG = okc;
        this.okI = null;
        this.okJ = new ViewOutlineProvider() {
            /* class com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.AnonymousClass1 */

            public final void getOutline(View view, Outline outline) {
                AppMethodBeat.i(176789);
                outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), (float) AppBrandPipContainerView.oku);
                AppMethodBeat.o(176789);
            }
        };
        this.okS = true;
        this.okT = true;
        this.okU = false;
        this.okV = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.en, this);
        setBackgroundColor(0);
        this.okQ = inflate.findViewById(R.id.q3);
        this.okR = inflate.findViewById(R.id.q2);
        this.okR.setOutlineProvider(this.okJ);
        this.okR.setClipToOutline(true);
        this.okL = (ViewGroup) inflate.findViewById(R.id.q4);
        this.okM = inflate.findViewById(R.id.q1);
        this.okN = inflate.findViewById(R.id.q7);
        this.okN.setVisibility(4);
        this.okO = (ViewGroup) inflate.findViewById(R.id.q8);
        this.okO.setVisibility(4);
        this.okP = inflate.findViewById(R.id.q9);
        this.okP.setVisibility(4);
        b(this.nCG, okp, oko, okq, okr, oks, okt);
        this.okx = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mCurOrientation = context.getResources().getConfiguration().orientation;
        this.inq = az(context);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.inq);
        AppMethodBeat.o(176792);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(176793);
        if (!this.okS) {
            AppMethodBeat.o(176793);
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.okz = false;
                this.okA.x = motionEvent.getRawX();
                this.okA.y = motionEvent.getRawY();
                this.okB.x = (float) ((int) getX());
                this.okB.y = (float) ((int) getY());
                Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.okA + ", viewPosOnDown: " + this.okB);
                break;
            case 1:
            case 3:
                if (this.okz || G(motionEvent)) {
                    if (this.okz) {
                        this.okz = false;
                    }
                    int H = H(motionEvent);
                    int width = getWidth();
                    int I = I(motionEvent);
                    int height = getHeight();
                    Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + H + ", width: " + width + ", startPositionY: " + I + ", height: " + height);
                    z(H, I, eD(H, width), eE(I, height));
                    AppMethodBeat.o(176793);
                    return true;
                }
            case 2:
                if (!this.okz && G(motionEvent)) {
                    this.okz = true;
                }
                if (this.okz) {
                    O((float) H(motionEvent), (float) I(motionEvent));
                    break;
                }
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(176793);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(176794);
        super.onLayout(z, i2, i3, i4, i5);
        View view = (View) getParent();
        if (view == null) {
            Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
            AppMethodBeat.o(176794);
            return;
        }
        if (okv == this.oky) {
            this.oky = new Point(view.getWidth(), view.getHeight());
            Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.oky);
            a(getY(), true);
        }
        AppMethodBeat.o(176794);
    }

    public final void iZ(boolean z) {
        AppMethodBeat.i(219603);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: ".concat(String.valueOf(z)));
        this.okU = z;
        if (!z) {
            ai.b(this.okQ, null);
        } else if (this.okV != null) {
            Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
            ai.b(this.okQ, this.okV);
            AppMethodBeat.o(219603);
            return;
        }
        AppMethodBeat.o(219603);
    }

    public final void ja(boolean z) {
        AppMethodBeat.i(176797);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
        this.okM.setVisibility(z ? 0 : 4);
        this.okS = true;
        AppMethodBeat.o(176797);
    }

    public final void bZX() {
        AppMethodBeat.i(176798);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
        this.okM.setVisibility(4);
        this.okS = false;
        AppMethodBeat.o(176798);
    }

    public final void setOnCloseButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(176799);
        this.okM.setOnClickListener(onClickListener);
        AppMethodBeat.o(176799);
    }

    public final void bZY() {
        AppMethodBeat.i(219604);
        Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
        this.okN.setVisibility(4);
        AppMethodBeat.o(219604);
    }

    public final void bZZ() {
        AppMethodBeat.i(219605);
        this.okO.setVisibility(4);
        this.okP.setVisibility(4);
        this.okI = null;
        AppMethodBeat.o(219605);
    }

    public final void aV(float f2) {
        AppMethodBeat.i(176800);
        if (!this.okT) {
            AppMethodBeat.o(176800);
            return;
        }
        this.okO.setVisibility(0);
        this.okP.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.okP.getLayoutParams();
        layoutParams.width = (int) ((((float) this.nCG) * f2) / 100.0f);
        this.okP.setLayoutParams(layoutParams);
        this.okI = Float.valueOf(f2);
        AppMethodBeat.o(176800);
    }

    public final void b(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(176801);
        this.nCG = i2;
        if (this.okI != null) {
            aV(this.okI.floatValue());
        }
        this.okQ.setPadding(i3, i4, i3, i5);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.okR.getLayoutParams();
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        layoutParams.topMargin = i4;
        layoutParams.bottomMargin = i5;
        this.okR.setLayoutParams(layoutParams);
        ai.a aVar = new ai.a();
        aVar.nYT = i6;
        aVar.nYW = Color.parseColor("#4C000000");
        aVar.SE = i7;
        aVar.mOffsetX = 0;
        aVar.mOffsetY = i8;
        ai bXO = aVar.bXO();
        if (this.okU) {
            ai.b(this.okQ, bXO);
            AppMethodBeat.o(176801);
            return;
        }
        this.okV = bXO;
        AppMethodBeat.o(176801);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(219606);
        if (this.okH == null) {
            this.okH = new HashSet();
        }
        this.okH.add(aVar);
        AppMethodBeat.o(219606);
    }

    public final void setStablePos(Point point) {
        AppMethodBeat.i(219607);
        Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: ".concat(String.valueOf(point)));
        this.okF = point.x;
        this.okG = point.y;
        this.okE = true;
        AppMethodBeat.o(219607);
    }

    public final void eA(int i2, int i3) {
        AppMethodBeat.i(176802);
        this.okF = eD(i2, i3);
        AppMethodBeat.o(176802);
    }

    public final void eB(int i2, int i3) {
        AppMethodBeat.i(176803);
        this.okG = eE(i2, i3);
        AppMethodBeat.o(176803);
    }

    public final int getStablePosX() {
        AppMethodBeat.i(176804);
        Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.okF);
        int i2 = this.okF;
        AppMethodBeat.o(176804);
        return i2;
    }

    public final int getStablePosY() {
        AppMethodBeat.i(176805);
        Log.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.okG);
        int i2 = this.okG;
        AppMethodBeat.o(176805);
        return i2;
    }

    public final void eC(int i2, int i3) {
        AppMethodBeat.i(219608);
        if (this.okH == null) {
            AppMethodBeat.o(219608);
            return;
        }
        for (a aVar : this.okH) {
            aVar.ev(i2, i3);
        }
        AppMethodBeat.o(219608);
    }

    private boolean G(MotionEvent motionEvent) {
        AppMethodBeat.i(176806);
        if (Math.abs(motionEvent.getRawX() - this.okA.x) > ((float) this.okx) || Math.abs(motionEvent.getRawY() - this.okA.y) > ((float) this.okx)) {
            AppMethodBeat.o(176806);
            return true;
        }
        AppMethodBeat.o(176806);
        return false;
    }

    private int H(MotionEvent motionEvent) {
        AppMethodBeat.i(176807);
        int i2 = this.oky.x;
        if (i2 <= 0) {
            i2 = this.inq.x;
            Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
        }
        int max = (int) Math.max(Math.min((this.okB.x + motionEvent.getRawX()) - this.okA.x, (float) (i2 - getWidth())), 0.0f);
        AppMethodBeat.o(176807);
        return max;
    }

    private int I(MotionEvent motionEvent) {
        AppMethodBeat.i(176808);
        int i2 = this.oky.y;
        if (i2 <= 0) {
            i2 = this.inq.y;
            Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
        }
        int max = (int) Math.max(Math.min((this.okB.y + motionEvent.getRawY()) - this.okA.y, (float) (i2 - getHeight())), 0.0f);
        AppMethodBeat.o(176808);
        return max;
    }

    private void O(float f2, float f3) {
        AppMethodBeat.i(219609);
        float x = getX();
        float x2 = getX();
        if (!(x == f2 && x2 == f3)) {
            setX(f2);
            setY(f3);
            a(f3, false);
        }
        AppMethodBeat.o(219609);
    }

    private int eD(int i2, int i3) {
        AppMethodBeat.i(176810);
        int minX = getMinX();
        if (!eF(i2, i3)) {
            minX = zL(i3);
        }
        AppMethodBeat.o(176810);
        return minX;
    }

    public final int eE(int i2, int i3) {
        AppMethodBeat.i(176811);
        int minY = getMinY();
        if (i2 < minY) {
            i2 = minY;
        } else {
            int zM = zM(i3);
            if (i2 > zM) {
                i2 = zM;
            }
        }
        AppMethodBeat.o(176811);
        return i2;
    }

    private boolean eF(int i2, int i3) {
        AppMethodBeat.i(219610);
        int i4 = this.oky.x;
        if (i4 <= 0) {
            i4 = this.inq.x;
            Log.w("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.oky + ", mScreenSize: " + this.inq);
        }
        this.okD = (i3 / 2) + i2 <= i4 / 2;
        boolean z = this.okD;
        AppMethodBeat.o(219610);
        return z;
    }

    public final void z(final int i2, final int i3, final int i4, final int i5) {
        AppMethodBeat.i(176813);
        if (this.okK != null && this.okK.isRunning()) {
            this.okK.cancel();
        }
        this.okK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.okK.setInterpolator(new AccelerateDecelerateInterpolator());
        this.okK.setDuration(100L);
        this.okK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(176790);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AppBrandPipContainerView.a(AppBrandPipContainerView.this, (float) (i2 + ((int) (((((float) i4) * 1.0f) - ((float) i2)) * floatValue))), (float) (((int) (floatValue * ((((float) i5) * 1.0f) - ((float) i3)))) + i3));
                AppMethodBeat.o(176790);
            }
        });
        this.okK.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.AnonymousClass3 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(176791);
                super.onAnimationEnd(animator);
                AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.getY());
                AppBrandPipContainerView.this.okF = i4;
                AppBrandPipContainerView.this.okG = i5;
                Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + AppBrandPipContainerView.this.okF + ", mStablePosY: " + AppBrandPipContainerView.this.okG);
                AppBrandPipContainerView.a(AppBrandPipContainerView.this, AppBrandPipContainerView.this.okF, AppBrandPipContainerView.this.okG);
                AppMethodBeat.o(176791);
            }
        });
        this.okK.start();
        AppMethodBeat.o(176813);
    }

    public final int getMinX() {
        AppMethodBeat.i(176814);
        int marginHorizontal = getMarginHorizontal();
        AppMethodBeat.o(176814);
        return marginHorizontal;
    }

    public final int zL(int i2) {
        AppMethodBeat.i(176815);
        int i3 = this.oky.x;
        int marginHorizontal = getMarginHorizontal();
        int i4 = (i3 - i2) - marginHorizontal;
        if (i4 < 0) {
            i4 = (this.inq.x - i2) - marginHorizontal;
        }
        AppMethodBeat.o(176815);
        return i4;
    }

    public final int getMinY() {
        AppMethodBeat.i(176816);
        if (this.okw != null) {
            int intValue = this.okw.intValue();
            AppMethodBeat.o(176816);
            return intValue;
        }
        int marginTopDefault = getMarginTopDefault();
        AppMethodBeat.o(176816);
        return marginTopDefault;
    }

    public final int zM(int i2) {
        AppMethodBeat.i(176817);
        int i3 = this.oky.y;
        int marginBottom = getMarginBottom();
        int i4 = (i3 - i2) - marginBottom;
        if (i4 < 0) {
            i4 = (this.inq.y - i2) - marginBottom;
        }
        AppMethodBeat.o(176817);
        return i4;
    }

    private int getMarginHorizontal() {
        return 1 == this.mCurOrientation ? okl : oki;
    }

    private int getMarginTopDefault() {
        return 1 == this.mCurOrientation ? okm : okj;
    }

    private int getMarginBottom() {
        return 1 == this.mCurOrientation ? okn : okk;
    }

    public final void a(float f2, boolean z) {
        AppMethodBeat.i(176818);
        if (z) {
            int minY = getMinY();
            int zM = zM(getHeight());
            this.okC = (Math.min(Math.max(f2, (float) minY), (float) zM) - ((float) minY)) / ((float) (zM - minY));
        }
        AppMethodBeat.o(176818);
    }

    public final int getTargetPositionXWhenOrientationChanged() {
        AppMethodBeat.i(176819);
        int minX = getMinX();
        if (!this.okD) {
            minX = zL(getWidth());
        }
        AppMethodBeat.o(176819);
        return minX;
    }

    public static Point az(Context context) {
        AppMethodBeat.i(176820);
        Point point = new Point();
        if (context == null) {
            AppMethodBeat.o(176820);
            return point;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (Build.VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e2) {
                }
            }
            defaultDisplay.getSize(point);
        }
        AppMethodBeat.o(176820);
        return point;
    }
}
