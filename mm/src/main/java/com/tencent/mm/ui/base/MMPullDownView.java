package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.k;

public class MMPullDownView extends FrameLayout implements GestureDetector.OnGestureListener {
    private static int OSv = 400;
    private static final int OSy = Color.parseColor("#00000000");
    public View GEr;
    private int OPU;
    private int OPi;
    private g ORV;
    private e ORW;
    private int ORX;
    private int ORY;
    private boolean ORZ;
    private int OSA;
    private b OSB;
    private boolean OSa;
    private boolean OSb;
    protected boolean OSc;
    private boolean OSd;
    private boolean OSe;
    private boolean OSf;
    private c OSg;
    private d OSh;
    public View OSi;
    private int OSj;
    private int OSk;
    private int OSl;
    private boolean OSm;
    private f OSn;
    private boolean OSo;
    private boolean OSp;
    public boolean OSq;
    private k OSr;
    private boolean OSs;
    private a OSt;
    private int OSu;
    private MMHandler OSw;
    boolean OSx;
    private boolean OSz;
    private int bgColor;
    protected Context context;
    private GestureDetector jKk;
    private Scroller mScroller;
    private boolean onY;

    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface b {
        void cLT();
    }

    public interface c {
        boolean cAl();
    }

    public interface d {
        boolean cAk();
    }

    public interface e {
        boolean cAj();
    }

    public interface f {
        void bY(float f2);

        void fjr();
    }

    public interface g {
        boolean cAm();
    }

    public MMPullDownView(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public MMPullDownView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(142077);
        this.OPU = 1;
        this.ORZ = false;
        this.OSa = false;
        this.onY = false;
        this.OSb = false;
        this.OSc = true;
        this.OSd = false;
        this.OSe = true;
        this.OSf = true;
        this.OSk = 4;
        this.OSl = 4;
        this.OSm = false;
        this.OSo = true;
        this.OSp = true;
        this.OSq = false;
        this.OSs = false;
        this.bgColor = MMApplicationContext.getContext().getResources().getColor(R.color.afz);
        this.OSu = this.bgColor;
        this.OSw = new MMHandler() {
            /* class com.tencent.mm.ui.base.MMPullDownView.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(142076);
                super.handleMessage(message);
                switch (MMPullDownView.this.OSj) {
                    case 0:
                        if (MMPullDownView.this.ORV != null) {
                            MMPullDownView.this.OSc = MMPullDownView.this.ORV.cAm();
                        }
                        if (MMPullDownView.this.OSc && MMPullDownView.this.OSi.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ORX);
                            break;
                        }
                    case 1:
                        if (MMPullDownView.this.ORW != null) {
                            MMPullDownView.this.OSc = MMPullDownView.this.ORW.cAj();
                        }
                        if (MMPullDownView.this.OSc && MMPullDownView.this.GEr.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ORX);
                            break;
                        }
                }
                Log.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(MMPullDownView.this.OSj), Boolean.valueOf(MMPullDownView.this.OSc));
                AppMethodBeat.o(142076);
            }
        };
        this.OSx = false;
        this.OSz = false;
        this.OSA = Integer.MIN_VALUE;
        this.mScroller = new Scroller(context2, new AccelerateInterpolator());
        this.OPi = this.OPU;
        this.jKk = new GestureDetector(context2, this);
        this.OSr = new k(context2);
        this.context = context2;
        this.bgColor = context2.getResources().getColor(R.color.afz);
        this.OSu = this.bgColor;
        AppMethodBeat.o(142077);
    }

    /* access modifiers changed from: protected */
    public void cAG() {
        AppMethodBeat.i(142078);
        View inflate = inflate(this.context, R.layout.b29, null);
        View inflate2 = inflate(this.context, R.layout.b29, null);
        addView(inflate, 0, new FrameLayout.LayoutParams(-1, -2));
        addView(inflate2, new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(142078);
    }

    public void setCanOverScrool(boolean z) {
        this.OSo = z;
    }

    public void setEnableGesture(boolean z) {
        this.OSp = z;
    }

    public void setIsTopShowAll(boolean z) {
        AppMethodBeat.i(142079);
        Log.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.OSe), Util.getStack());
        this.OSe = z;
        AppMethodBeat.o(142079);
    }

    public void setIsBottomShowAll(boolean z) {
        AppMethodBeat.i(142080);
        Log.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.OSf), Util.getStack());
        this.OSf = z;
        AppMethodBeat.o(142080);
    }

    public void setOnTopLoadDataListener(g gVar) {
        this.ORV = gVar;
    }

    public void setOnBottomLoadDataListener(e eVar) {
        this.ORW = eVar;
    }

    public void setAtTopCallBack(d dVar) {
        this.OSh = dVar;
    }

    public void setAtBottomCallBack(c cVar) {
        this.OSg = cVar;
    }

    public void setOnSrcollDistance(f fVar) {
        this.OSn = fVar;
    }

    public void setOnMMFlingListener(k.a aVar) {
        this.OSr.Quy = aVar;
    }

    public void setTopView(View view) {
        AppMethodBeat.i(142081);
        if (view == null) {
            this.OSl = 4;
            if (this.OSi != null) {
                this.OSi.setVisibility(4);
                AppMethodBeat.o(142081);
                return;
            }
        } else {
            removeViewAt(0);
            this.OSi = view;
            this.OSi.setVisibility(0);
            this.OSl = 0;
            addView(this.OSi, 0, new FrameLayout.LayoutParams(-1, -2));
            this.ORX = 0;
        }
        AppMethodBeat.o(142081);
    }

    public void setBottomView(View view) {
        AppMethodBeat.i(142082);
        if (view == null) {
            this.OSk = 4;
            if (this.GEr != null) {
                this.GEr.setVisibility(4);
                AppMethodBeat.o(142082);
                return;
            }
        } else {
            this.GEr = view;
            this.GEr.setVisibility(0);
            this.OSk = 0;
            removeViewAt(getChildCount() - 1);
            addView(this.GEr, new FrameLayout.LayoutParams(-1, -2));
            this.ORY = 0;
        }
        AppMethodBeat.o(142082);
    }

    public void setBottomViewVisible(boolean z) {
        AppMethodBeat.i(142083);
        this.OSk = z ? 0 : 4;
        if (this.GEr != null) {
            this.GEr.setVisibility(this.OSk);
        }
        Log.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), Util.getStack());
        AppMethodBeat.o(142083);
    }

    public void setTopViewVisible(boolean z) {
        AppMethodBeat.i(142084);
        this.OSl = z ? 0 : 4;
        if (this.OSi != null) {
            this.OSi.setVisibility(this.OSl);
        }
        Log.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(142084);
    }

    public static void n(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(142085);
        Log.i("MicroMsg.MMPullDownView", "fix android O progress bar bug. visibility=".concat(String.valueOf(i2)));
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            if (viewGroup.getTag() == null) {
                viewGroup.setTag(viewGroup.findViewById(R.id.aww));
            }
            View view = (View) viewGroup.getTag();
            if (view != null) {
                view.setVisibility(i2);
            }
        }
        AppMethodBeat.o(142085);
    }

    private void gKT() {
        AppMethodBeat.i(142086);
        n((ViewGroup) this.OSi, 0);
        n((ViewGroup) this.GEr, 0);
        AppMethodBeat.o(142086);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(142087);
        if (!this.OSm) {
            cAG();
            this.OSm = true;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(142087);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142088);
        Log.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        int i6 = 0;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i6, childAt.getMeasuredWidth(), i6 + measuredHeight);
                } catch (ArrayIndexOutOfBoundsException e2) {
                    Log.printErrStackTrace("MicroMsg.MMPullDownView", e2, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i7), Integer.valueOf(measuredHeight));
                }
                i6 += measuredHeight;
            }
        }
        this.OSi = getChildAt(0);
        this.GEr = getChildAt(getChildCount() - 1);
        this.OSi.setVisibility(this.OSl);
        this.GEr.setVisibility(this.OSk);
        this.ORX = this.OSi.getHeight();
        this.ORY = this.GEr.getHeight();
        this.OSA = this.ORX;
        if (!this.OSd && this.ORX != 0) {
            this.OSd = true;
            scrollTo(0, this.ORX);
        }
        AppMethodBeat.o(142088);
    }

    public int getCurScreen() {
        return this.OPi;
    }

    static {
        AppMethodBeat.i(142100);
        AppMethodBeat.o(142100);
    }

    public void computeScroll() {
        AppMethodBeat.i(142089);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        } else if (this.OSb) {
            Log.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.OSb = false;
            this.OSw.sendEmptyMessageDelayed(0, (long) OSv);
            gKT();
        }
        this.mScroller.isFinished();
        AppMethodBeat.o(142089);
    }

    public int getTopHeight() {
        return this.ORX;
    }

    public int getBottomHeight() {
        return this.ORY;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142090);
        if (this.OSt != null) {
            this.OSt.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(142090);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142091);
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.ORX < 0) {
                    this.ORZ = true;
                }
                if (getScrollY() > this.ORY) {
                    this.OSa = true;
                }
                gKU();
                break;
        }
        AppMethodBeat.o(142091);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142092);
        if (!this.OSp) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(142092);
            return dispatchTouchEvent;
        } else if (!this.OSq || motionEvent.getAction() != 2) {
            this.OSq = false;
            k kVar = this.OSr;
            if (kVar.Quy != null) {
                GestureDetector gestureDetector = kVar.aYg;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/tools/MMGestureDetector", "onTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            }
            if (!this.OSc) {
                AppMethodBeat.o(142092);
                return true;
            }
            if (this.OSh == null) {
                this.ORZ = false;
            } else {
                this.ORZ = this.OSh.cAk();
            }
            if (this.OSg == null) {
                this.OSa = false;
            } else {
                this.OSa = this.OSg.cAl();
            }
            if (this.OSl == 0) {
                if (this.OSe) {
                    this.OSi.setVisibility(4);
                } else {
                    this.OSi.setVisibility(0);
                }
            }
            if (this.OSk == 0) {
                if (this.OSf) {
                    this.GEr.setVisibility(4);
                } else {
                    this.GEr.setVisibility(0);
                }
            }
            if (motionEvent.getAction() == 1) {
                gKU();
                boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(142092);
                return dispatchTouchEvent2;
            } else if (motionEvent.getAction() == 3) {
                gKU();
                if (this.OSs) {
                    boolean dispatchTouchEvent3 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(142092);
                    return dispatchTouchEvent3;
                }
                AppMethodBeat.o(142092);
                return false;
            } else {
                GestureDetector gestureDetector2 = this.jKk;
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, bl2.axQ(), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                if (com.tencent.mm.hellhoundlib.a.a.a(gestureDetector2, gestureDetector2.onTouchEvent((MotionEvent) bl2.pG(0)), "com/tencent/mm/ui/base/MMPullDownView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z")) {
                    motionEvent.setAction(3);
                    this.OSx = true;
                    boolean dispatchTouchEvent4 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(142092);
                    return dispatchTouchEvent4;
                }
                try {
                    boolean dispatchTouchEvent5 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(142092);
                    return dispatchTouchEvent5;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.MMPullDownView", e2, "", new Object[0]);
                    AppMethodBeat.o(142092);
                    return true;
                }
            }
        } else {
            boolean dispatchTouchEvent6 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(142092);
            return dispatchTouchEvent6;
        }
    }

    public void Bx(boolean z) {
        AppMethodBeat.i(142093);
        Log.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", Boolean.valueOf(z), Boolean.valueOf(this.OSb), Boolean.valueOf(this.OSc), Boolean.valueOf(this.OSe), Integer.valueOf(getScrollY()));
        if (z) {
            if (this.OSi != null) {
                this.OSi.setVisibility(this.OSl);
            }
            if (this.OSe) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ORX + (-getScrollY()), 200);
            } else {
                if (this.OSi != null && this.OSi.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORX + (-getScrollY()), 200);
                }
                if (this.OSi != null && this.OSi.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.OSj = 0;
                this.OSb = true;
                this.OSc = false;
            }
            postInvalidate();
        } else {
            if (!this.OSc) {
                this.OSc = true;
                this.OSb = false;
                if (this.OSi != null && this.OSi.getVisibility() == 0) {
                    scrollTo(0, this.ORX);
                }
            }
            if (this.OSi != null && this.OSi.getVisibility() == 0) {
                this.OSi.setVisibility(8);
            }
        }
        if (!this.OSe) {
            gKT();
        }
        AppMethodBeat.o(142093);
    }

    public final void By(boolean z) {
        AppMethodBeat.i(142094);
        Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", Boolean.valueOf(z), Boolean.valueOf(this.OSb), Boolean.valueOf(this.OSc), Boolean.valueOf(this.OSf), Integer.valueOf(getScrollY()));
        if (z) {
            if (this.GEr != null) {
                this.GEr.setVisibility(this.OSl);
            }
            if (this.OSf) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
            } else {
                if (this.GEr != null && this.GEr.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
                }
                if (this.GEr != null && this.GEr.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORY + (this.ORY - getScrollY()), 200);
                }
                this.OSj = 1;
                this.OSb = true;
                this.OSc = false;
            }
            postInvalidate();
            AppMethodBeat.o(142094);
            return;
        }
        if (!this.OSc) {
            this.OSc = true;
            this.OSb = false;
        }
        if (this.GEr != null && this.GEr.getVisibility() == 0) {
            Log.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.ORX);
        }
        if (this.GEr != null && this.GEr.getVisibility() == 0) {
            this.GEr.setVisibility(8);
        }
        AppMethodBeat.o(142094);
    }

    private void gKU() {
        AppMethodBeat.i(142095);
        if (this.OSn != null) {
            this.OSn.fjr();
        }
        if (getScrollY() - this.ORX < 0) {
            if (this.OSe) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ORX + (-getScrollY()), 200);
            } else {
                if (this.OSi.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORX + (-getScrollY()), 200);
                }
                if (this.OSi.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.OSj = 0;
                this.OSb = true;
                this.OSc = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.ORY) {
            if (this.OSf) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
            } else {
                if (this.GEr.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORY - getScrollY(), 200);
                }
                if (this.GEr.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ORY + (this.ORY - getScrollY()), 200);
                }
                this.OSj = 1;
                this.OSb = true;
                this.OSc = false;
            }
            postInvalidate();
        }
        this.onY = false;
        AppMethodBeat.o(142095);
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(142096);
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        AppMethodBeat.o(142096);
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(142097);
        Log.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f2), Float.valueOf(f3));
        AppMethodBeat.o(142097);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(205238);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(205238);
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        boolean z;
        AppMethodBeat.i(142098);
        if (f3 > 0.0f) {
            this.onY = true;
        } else {
            this.onY = false;
        }
        if (Math.abs(f3) > Math.abs(f2)) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.OSn != null) {
            this.OSn.bY(f3);
        }
        if (!this.OSa || ((!this.onY && getScrollY() - this.ORX <= 0) || !z)) {
            if (!this.ORZ || ((this.onY && getScrollY() - this.ORX >= 0) || !z)) {
                AppMethodBeat.o(142098);
                return false;
            } else if (this.OSo || (this.OSi.getVisibility() == 0 && (this.onY || getScrollY() > 0))) {
                int i2 = (int) (((double) f3) * 0.5d);
                if (i2 == 0) {
                    i2 = f3 > 0.0f ? 1 : -1;
                }
                if (getScrollY() + i2 > this.ORX) {
                    i2 = this.ORX - getScrollY();
                } else if (!this.OSo && getScrollY() + i2 < 0) {
                    i2 = -getScrollY();
                }
                scrollBy(0, i2);
                AppMethodBeat.o(142098);
                return true;
            } else {
                AppMethodBeat.o(142098);
                return true;
            }
        } else if (this.OSo || (this.GEr.getVisibility() == 0 && (!this.onY || getScrollY() < this.ORX * 2))) {
            int i3 = (int) (((double) f3) * 0.5d);
            if (i3 == 0) {
                i3 = f3 > 0.0f ? 1 : -1;
            }
            Log.v("check", "moveUp:" + i3 + " distanceY:" + f3 + " scrollY:" + getScrollY());
            if (getScrollY() + i3 < this.ORX && !this.onY) {
                i3 = this.ORX - getScrollY();
            } else if (!this.OSo && getScrollY() + i3 >= this.ORX * 2) {
                i3 = (this.ORX * 2) - getScrollY();
            }
            scrollBy(0, i3);
            AppMethodBeat.o(142098);
            return true;
        } else {
            AppMethodBeat.o(142098);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(205239);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/base/MMPullDownView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(205239);
        return false;
    }

    public void setShowBackground(boolean z) {
        this.OSz = z;
    }

    public void setBgColor(int i2) {
        this.bgColor = i2;
        this.OSu = this.bgColor;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142099);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.OSB != null) {
            this.OSB.cLT();
        }
        if (!this.OSz) {
            AppMethodBeat.o(142099);
            return;
        }
        if (this.OSA == Integer.MIN_VALUE) {
            this.OSA = this.ORX;
            Log.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.OSA);
        }
        if (i3 > this.OSA || this.OSu == OSy) {
            if (i3 > this.OSA && this.OSu != this.bgColor) {
                Log.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                setBackgroundColor(this.bgColor);
                this.OSu = this.bgColor;
            }
            AppMethodBeat.o(142099);
            return;
        }
        setBackgroundResource(R.drawable.aij);
        this.OSu = OSy;
        Log.d("MicroMsg.MMPullDownView", "onScrollChanged full");
        AppMethodBeat.o(142099);
    }

    public void setOnScrollChangedListener(b bVar) {
        this.OSB = bVar;
    }

    public void setOnInterceptTouchEventListener(a aVar) {
        this.OSt = aVar;
    }

    public void setIsReturnSuperDispatchWhenCancel(boolean z) {
        this.OSs = z;
    }
}
