package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.luggage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.imid.swipebacklayout.lib.b;

public class SwipeBackLayout extends FrameLayout {
    private static final int[] UaP = {1, 2, 8, 11};
    private CopyOnWriteArrayList<a> Sfj;
    private int TG;
    private float TH;
    private int UaQ;
    private b UaR;
    private Drawable UaS;
    private int UaT;
    private Drawable Uc;
    private Drawable Ud;
    private Rect Ui;
    private float hfn;
    private int hfo;
    private int hfp;
    private float hfr;
    private View mContentView;
    private boolean mEnable;
    private boolean mInLayout;

    public interface a {
        void LN();

        int bS(boolean z);

        void i(int i2, float f2);

        void n(MotionEvent motionEvent);
    }

    public interface b extends a {
        void bQF();
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.t);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        AppMethodBeat.i(140882);
        this.hfn = 0.3f;
        this.mEnable = true;
        this.TG = -1728053248;
        this.Ui = new Rect();
        this.UaR = b.a(this, new c(this, (byte) 0));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0162a.SwipeBackLayout, i2, R.style.uq);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(UaP[obtainStyledAttributes.getInt(0, 0)]);
        int resourceId = obtainStyledAttributes.getResourceId(3, R.drawable.bt9);
        int resourceId2 = obtainStyledAttributes.getResourceId(4, R.drawable.bt_);
        int resourceId3 = obtainStyledAttributes.getResourceId(2, R.drawable.bt8);
        ne(resourceId, 1);
        ne(resourceId2, 2);
        ne(resourceId3, 8);
        obtainStyledAttributes.recycle();
        float f2 = getResources().getDisplayMetrics().density * 400.0f;
        this.UaR.WH = f2;
        this.UaR.WG = f2 * 2.0f;
        AppMethodBeat.o(140882);
    }

    public void setMinVelocity(float f2) {
        this.UaR.WH = f2;
    }

    public void setMaxVelocity(float f2) {
        this.UaR.WG = f2;
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public View getTargetView() {
        return this.mContentView;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setEdgeTrackingEnabled(int i2) {
        this.UaQ = i2;
        this.UaR.WJ = this.UaQ;
    }

    public void setScrimColor(int i2) {
        AppMethodBeat.i(140883);
        this.TG = i2;
        invalidate();
        AppMethodBeat.o(140883);
    }

    public void setEdgeSize(int i2) {
        this.UaR.WI = i2;
    }

    @Deprecated
    public void setSwipeListener(a aVar) {
        AppMethodBeat.i(140884);
        a(aVar);
        AppMethodBeat.o(140884);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(140885);
        if (this.Sfj == null) {
            this.Sfj = new CopyOnWriteArrayList<>();
        }
        this.Sfj.add(aVar);
        AppMethodBeat.o(140885);
    }

    public void setScrollThresHold(float f2) {
        AppMethodBeat.i(140886);
        if (f2 >= 1.0f || f2 <= 0.0f) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Threshold value should be between 0 and 1.0");
            AppMethodBeat.o(140886);
            throw illegalArgumentException;
        }
        this.hfn = f2;
        AppMethodBeat.o(140886);
    }

    private void g(Drawable drawable, int i2) {
        AppMethodBeat.i(140887);
        if ((i2 & 1) != 0) {
            this.Uc = drawable;
        } else if ((i2 & 2) != 0) {
            this.Ud = drawable;
        } else if ((i2 & 8) != 0) {
            this.UaS = drawable;
        }
        invalidate();
        AppMethodBeat.o(140887);
    }

    private void ne(int i2, int i3) {
        AppMethodBeat.i(140888);
        g(getResources().getDrawable(i2), i3);
        AppMethodBeat.o(140888);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View J;
        View J2;
        AppMethodBeat.i(140889);
        if (!this.mEnable) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(140889);
            return dispatchTouchEvent;
        }
        if (this.Sfj != null && !this.Sfj.isEmpty()) {
            Iterator<a> it = this.Sfj.iterator();
            while (it.hasNext()) {
                it.next().n(motionEvent);
            }
        }
        if (this.UaR.Wx == 1) {
            this.UaR.k(motionEvent);
            AppMethodBeat.o(140889);
            return true;
        }
        try {
            b bVar = this.UaR;
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                bVar.cancel();
            }
            if (bVar.mVelocityTracker == null) {
                bVar.mVelocityTracker = VelocityTracker.obtain();
            }
            bVar.mVelocityTracker.addMovement(motionEvent);
            switch (actionMasked) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    int pointerId = motionEvent.getPointerId(0);
                    bVar.a(x, y, pointerId);
                    View J3 = bVar.J((int) x, (int) y);
                    if (J3 == bVar.WL && bVar.Wx == 2) {
                        bVar.z(J3, pointerId);
                    }
                    if ((bVar.UaW[pointerId] & bVar.WJ) != 0) {
                    }
                    break;
                case 1:
                case 3:
                    bVar.cancel();
                    break;
                case 2:
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        float x2 = motionEvent.getX(i2);
                        float y2 = motionEvent.getY(i2);
                        float f2 = x2 - bVar.Wy[pointerId2];
                        float f3 = y2 - bVar.Wz[pointerId2];
                        bVar.b(f2, f3, pointerId2);
                        if (bVar.Wx != 1 && ((J = bVar.J((int) x2, (int) y2)) == null || !bVar.c(J, f2, f3) || !bVar.z(J, pointerId2))) {
                        }
                        bVar.i(motionEvent);
                        break;
                    }
                    bVar.i(motionEvent);
                case 5:
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x3 = motionEvent.getX(actionIndex);
                    float y3 = motionEvent.getY(actionIndex);
                    bVar.a(x3, y3, pointerId3);
                    if (bVar.Wx != 0 && bVar.Wx == 2 && (J2 = bVar.J((int) x3, (int) y3)) == bVar.WL) {
                        bVar.z(J2, pointerId3);
                        break;
                    }
                case 6:
                    bVar.bd(motionEvent.getPointerId(actionIndex));
                    break;
            }
            if (bVar.Wx == 1) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(140889);
                return true;
            }
            super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(140889);
            return true;
        } catch (NullPointerException e2) {
            AppMethodBeat.o(140889);
            return false;
        } catch (IllegalArgumentException e3) {
            AppMethodBeat.o(140889);
            return false;
        } catch (ArrayIndexOutOfBoundsException e4) {
            AppMethodBeat.o(140889);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(140890);
        if (!this.mEnable) {
            AppMethodBeat.o(140890);
            return false;
        }
        this.UaR.k(motionEvent);
        AppMethodBeat.o(140890);
        return true;
    }

    public final void hPi() {
        AppMethodBeat.i(221355);
        this.hfr = 0.0f;
        this.UaR.cancel();
        this.UaR.bf(0);
        if (!(this.hfo == 0 && this.hfp == 0)) {
            this.hfp = 0;
            this.hfo = 0;
            requestLayout();
        }
        AppMethodBeat.o(221355);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(140891);
        this.mInLayout = true;
        if (this.mContentView != null) {
            this.mContentView.layout(this.hfo, this.hfp, this.hfo + this.mContentView.getMeasuredWidth(), this.hfp + this.mContentView.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.o(140891);
    }

    public void requestLayout() {
        AppMethodBeat.i(140892);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.o(140892);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        AppMethodBeat.i(140893);
        boolean z = view == this.mContentView;
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.TH > 0.0f && z && this.UaR.Wx != 0) {
            Rect rect = this.Ui;
            view.getHitRect(rect);
            if ((this.UaQ & 1) != 0) {
                this.Uc.setBounds(rect.left - this.Uc.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
                this.Uc.setAlpha((int) (this.TH * 255.0f));
                this.Uc.draw(canvas);
            }
            if ((this.UaQ & 2) != 0) {
                this.Ud.setBounds(rect.right, rect.top, rect.right + this.Ud.getIntrinsicWidth(), rect.bottom);
                this.Ud.setAlpha((int) (this.TH * 255.0f));
                this.Ud.draw(canvas);
            }
            if ((this.UaQ & 8) != 0) {
                this.UaS.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.UaS.getIntrinsicHeight());
                this.UaS.setAlpha((int) (this.TH * 255.0f));
                this.UaS.draw(canvas);
            }
            int i2 = (((int) (((float) ((this.TG & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.TH)) << 24) | (this.TG & 16777215);
            if ((this.UaT & 1) != 0) {
                canvas.clipRect(0, 0, view.getLeft(), getHeight());
            } else if ((this.UaT & 2) != 0) {
                canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
            } else if ((this.UaT & 8) != 0) {
                canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
            }
            canvas.drawColor(i2);
        }
        AppMethodBeat.o(140893);
        return drawChild;
    }

    public void computeScroll() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(140894);
        this.TH = 1.0f - this.hfr;
        b bVar = this.UaR;
        if (bVar.Wx == 2) {
            boolean computeScrollOffset = bVar.hgg.UD.computeScrollOffset();
            int currX = bVar.hgg.UD.getCurrX();
            int currY = bVar.hgg.UD.getCurrY();
            int left = currX - bVar.WL.getLeft();
            int top = currY - bVar.WL.getTop();
            if (left != 0) {
                bVar.WL.offsetLeftAndRight(left);
            }
            if (top != 0) {
                bVar.WL.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                bVar.UaX.l(bVar.WL, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == bVar.hgg.UD.getFinalX() && currY == bVar.hgg.UD.getFinalY()) {
                bVar.hgg.UD.abortAnimation();
                z2 = bVar.hgg.UD.isFinished();
            } else {
                z2 = computeScrollOffset;
            }
            if (!z2) {
                bVar.WN.post(bVar.WO);
            }
        }
        if (bVar.Wx == 2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            u.X(this);
        }
        AppMethodBeat.o(140894);
    }

    class c extends b.a {
        private boolean UaU;

        private c() {
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, byte b2) {
            this();
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final boolean pv(int i2) {
            boolean z = true;
            AppMethodBeat.i(140874);
            boolean nf = SwipeBackLayout.this.UaR.nf(SwipeBackLayout.this.UaQ, i2);
            if (nf) {
                if (SwipeBackLayout.this.UaR.nf(1, i2)) {
                    SwipeBackLayout.this.UaT = 1;
                } else if (SwipeBackLayout.this.UaR.nf(2, i2)) {
                    SwipeBackLayout.this.UaT = 2;
                } else if (SwipeBackLayout.this.UaR.nf(8, i2)) {
                    SwipeBackLayout.this.UaT = 8;
                }
                if (SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty()) {
                    Iterator it = SwipeBackLayout.this.Sfj.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        int unused = SwipeBackLayout.this.UaT;
                        aVar.LN();
                    }
                }
                this.UaU = true;
            }
            if (SwipeBackLayout.this.UaQ == 1 || SwipeBackLayout.this.UaQ == 2) {
                z = !SwipeBackLayout.this.UaR.hl(2, i2);
            } else if (SwipeBackLayout.this.UaQ == 8) {
                if (SwipeBackLayout.this.UaR.hl(1, i2)) {
                    z = false;
                }
            } else if (SwipeBackLayout.this.UaQ != 11) {
                z = false;
            }
            boolean z2 = nf & z & SwipeBackLayout.this.mEnable;
            AppMethodBeat.o(140874);
            return z2;
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final int awM() {
            AppMethodBeat.i(140875);
            int i2 = SwipeBackLayout.this.UaQ & 3;
            AppMethodBeat.o(140875);
            return i2;
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final int cg() {
            AppMethodBeat.i(140876);
            int i2 = SwipeBackLayout.this.UaQ & 8;
            AppMethodBeat.o(140876);
            return i2;
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final void l(View view, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(140877);
            super.l(view, i2, i3, i4, i5);
            if ((SwipeBackLayout.this.UaT & 1) != 0) {
                SwipeBackLayout.this.hfr = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.Uc.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.UaT & 2) != 0) {
                SwipeBackLayout.this.hfr = Math.abs(((float) i2) / ((float) (SwipeBackLayout.this.mContentView.getWidth() + SwipeBackLayout.this.Ud.getIntrinsicWidth())));
            } else if ((SwipeBackLayout.this.UaT & 8) != 0) {
                SwipeBackLayout.this.hfr = Math.abs(((float) i3) / ((float) (SwipeBackLayout.this.mContentView.getHeight() + SwipeBackLayout.this.UaS.getIntrinsicHeight())));
            }
            SwipeBackLayout.this.hfo = i2;
            SwipeBackLayout.this.hfp = i3;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.hfr < SwipeBackLayout.this.hfn && !this.UaU) {
                this.UaU = true;
            }
            if (SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty()) {
                Iterator it = SwipeBackLayout.this.Sfj.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).i(SwipeBackLayout.this.UaR.Wx, SwipeBackLayout.this.hfr);
                }
            }
            if (SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty() && SwipeBackLayout.this.UaR.Wx == 1 && SwipeBackLayout.this.hfr >= SwipeBackLayout.this.hfn && this.UaU) {
                this.UaU = false;
                Iterator it2 = SwipeBackLayout.this.Sfj.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
            if (SwipeBackLayout.this.hfr >= 1.0f && SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty()) {
                Iterator it3 = SwipeBackLayout.this.Sfj.iterator();
                while (it3.hasNext()) {
                    a aVar = (a) it3.next();
                    if (aVar instanceof b) {
                        ((b) aVar).bQF();
                    }
                }
            }
            AppMethodBeat.o(140877);
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final void a(View view, float f2, float f3) {
            int i2;
            AppMethodBeat.i(140878);
            int width = view.getWidth();
            int height = view.getHeight();
            int i3 = 0;
            if ((SwipeBackLayout.this.UaT & 1) != 0) {
                i2 = 0;
                i3 = (f2 > 0.0f || (f2 == 0.0f && SwipeBackLayout.this.hfr > SwipeBackLayout.this.hfn)) ? width + SwipeBackLayout.this.Uc.getIntrinsicWidth() + 10 : 0;
            } else if ((SwipeBackLayout.this.UaT & 2) != 0) {
                i2 = 0;
                i3 = (f2 < 0.0f || (f2 == 0.0f && SwipeBackLayout.this.hfr > SwipeBackLayout.this.hfn)) ? -(width + SwipeBackLayout.this.Uc.getIntrinsicWidth() + 10) : 0;
            } else if ((SwipeBackLayout.this.UaT & 8) != 0) {
                i2 = (f3 < 0.0f || (f3 == 0.0f && SwipeBackLayout.this.hfr > SwipeBackLayout.this.hfn)) ? -(SwipeBackLayout.this.UaS.getIntrinsicHeight() + height + 10) : 0;
            } else {
                i2 = 0;
            }
            if (SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty()) {
                Iterator it = SwipeBackLayout.this.Sfj.iterator();
                while (it.hasNext()) {
                    int bS = ((a) it.next()).bS(i3 != 0);
                    if (bS == 2) {
                        i3 = 0;
                    } else if (bS == 3) {
                        AppMethodBeat.o(140878);
                        return;
                    }
                }
            }
            b bVar = SwipeBackLayout.this.UaR;
            if (!bVar.WM) {
                IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                AppMethodBeat.o(140878);
                throw illegalStateException;
            }
            int xVelocity = (int) bVar.mVelocityTracker.getXVelocity(bVar.mActivePointerId);
            int yVelocity = (int) bVar.mVelocityTracker.getYVelocity(bVar.mActivePointerId);
            int left = bVar.WL.getLeft();
            int top = bVar.WL.getTop();
            int i4 = i3 - left;
            int i5 = i2 - top;
            if (i4 == 0 && i5 == 0) {
                bVar.hgg.UD.abortAnimation();
                bVar.bf(0);
            } else {
                int i6 = b.i(xVelocity, (int) bVar.WH, (int) bVar.WG);
                int i7 = b.i(yVelocity, (int) bVar.WH, (int) bVar.WG);
                int abs = Math.abs(i4);
                int abs2 = Math.abs(i5);
                int abs3 = Math.abs(i6);
                int abs4 = Math.abs(i7);
                int i8 = abs3 + abs4;
                int i9 = abs + abs2;
                bVar.hgg.startScroll(left, top, i4, i5, (int) (((i7 != 0 ? ((float) abs4) / ((float) i8) : ((float) abs2) / ((float) i9)) * ((float) bVar.h(i5, i7, bVar.UaX.cg()))) + ((i6 != 0 ? ((float) abs3) / ((float) i8) : ((float) abs) / ((float) i9)) * ((float) bVar.h(i4, i6, bVar.UaX.awM())))));
                bVar.bf(2);
            }
            SwipeBackLayout.this.invalidate();
            AppMethodBeat.o(140878);
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final int e(View view, int i2) {
            int i3 = 0;
            AppMethodBeat.i(140879);
            if ((SwipeBackLayout.this.UaT & 1) != 0) {
                i3 = Math.min(view.getWidth(), Math.max(i2, 0));
            } else if ((SwipeBackLayout.this.UaT & 2) != 0) {
                i3 = Math.min(0, Math.max(i2, -view.getWidth()));
            }
            AppMethodBeat.o(140879);
            return i3;
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final int d(View view, int i2) {
            int i3 = 0;
            AppMethodBeat.i(140880);
            if ((SwipeBackLayout.this.UaT & 8) != 0) {
                i3 = Math.min(0, Math.max(i2, -view.getHeight()));
            }
            AppMethodBeat.o(140880);
            return i3;
        }

        @Override // me.imid.swipebacklayout.lib.b.a
        public final void L(int i2) {
            AppMethodBeat.i(140881);
            super.L(i2);
            if (SwipeBackLayout.this.Sfj != null && !SwipeBackLayout.this.Sfj.isEmpty()) {
                Iterator it = SwipeBackLayout.this.Sfj.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).i(i2, SwipeBackLayout.this.hfr);
                }
            }
            AppMethodBeat.o(140881);
        }
    }
}
