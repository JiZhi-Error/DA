package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final int[] TA = {16843828};
    static final boolean TB;
    private static final boolean TC;
    private final b TD;
    private float TE;
    private int TF;
    private int TG;
    private float TH;
    private Paint TI;
    final t TJ;
    final t TK;
    private final d TL;
    private final d TM;
    int TN;
    private int TO;
    private int TP;
    private int TQ;
    private int TR;
    private boolean TS;
    boolean TT;
    private c TU;
    private Drawable TV;
    private Drawable TW;
    CharSequence TX;
    CharSequence TY;
    Object TZ;
    private Drawable Ua;
    private Drawable Ub;
    private Drawable Uc;
    private Drawable Ud;
    private final ArrayList<View> Ue;
    private Rect Uf;
    private Matrix Ug;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    List<c> mListeners;
    boolean qw;
    private Drawable qx;

    public interface c {
        void F(float f2);

        void fW();

        void fX();
    }

    static {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 19) {
            z = true;
        } else {
            z = false;
        }
        TB = z;
        if (Build.VERSION.SDK_INT < 21) {
            z2 = false;
        }
        TC = z2;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TD = new b();
        this.TG = -1728053248;
        this.TI = new Paint();
        this.mFirstLayout = true;
        this.TO = 3;
        this.TP = 3;
        this.TQ = 3;
        this.TR = 3;
        this.Ua = null;
        this.Ub = null;
        this.Uc = null;
        this.Ud = null;
        setDescendantFocusability(TPMediaCodecProfileLevel.HEVCMainTierLevel52);
        float f2 = getResources().getDisplayMetrics().density;
        this.TF = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.TL = new d(3);
        this.TM = new d(5);
        this.TJ = t.a(this, 1.0f, this.TL);
        this.TJ.WJ = 1;
        this.TJ.WH = f3;
        this.TL.Us = this.TJ;
        this.TK = t.a(this, 1.0f, this.TM);
        this.TK.WJ = 2;
        this.TK.WH = f3;
        this.TM.Us = this.TK;
        setFocusableInTouchMode(true);
        u.p(this, 1);
        u.a(this, new a());
        setMotionEventSplittingEnabled(false);
        if (u.aq(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    /* class android.support.v4.widget.DrawerLayout.AnonymousClass1 */

                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        boolean z;
                        boolean z2 = true;
                        DrawerLayout drawerLayout = (DrawerLayout) view;
                        if (windowInsets.getSystemWindowInsetTop() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        drawerLayout.TZ = windowInsets;
                        drawerLayout.qw = z;
                        if (z || drawerLayout.getBackground() != null) {
                            z2 = false;
                        }
                        drawerLayout.setWillNotDraw(z2);
                        drawerLayout.requestLayout();
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(TA);
                try {
                    this.qx = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.qx = null;
            }
        }
        this.TE = f2 * 10.0f;
        this.Ue = new ArrayList<>();
    }

    public void setDrawerElevation(float f2) {
        this.TE = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (aP(childAt)) {
                u.l(childAt, this.TE);
            }
        }
    }

    public float getDrawerElevation() {
        if (TC) {
            return this.TE;
        }
        return 0.0f;
    }

    public void setScrimColor(int i2) {
        this.TG = i2;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        c cVar2;
        if (!(this.TU == null || (cVar2 = this.TU) == null || this.mListeners == null)) {
            this.mListeners.remove(cVar2);
        }
        if (!(cVar == null || cVar == null)) {
            if (this.mListeners == null) {
                this.mListeners = new ArrayList();
            }
            this.mListeners.add(cVar);
        }
        this.TU = cVar;
    }

    public void setDrawerLockMode(int i2) {
        C(i2, 3);
        C(i2, 5);
    }

    private void C(int i2, int i3) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i3, u.Z(this));
        switch (i3) {
            case 3:
                this.TO = i2;
                break;
            case 5:
                this.TP = i2;
                break;
            case 8388611:
                this.TQ = i2;
                break;
            case 8388613:
                this.TR = i2;
                break;
        }
        if (i2 != 0) {
            (absoluteGravity == 3 ? this.TJ : this.TK).cancel();
        }
        switch (i2) {
            case 1:
                View aW = aW(absoluteGravity);
                if (aW != null) {
                    aR(aW);
                    return;
                }
                return;
            case 2:
                View aW2 = aW(absoluteGravity);
                if (aW2 != null) {
                    aQ(aW2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int aL(View view) {
        if (!aP(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i2 = ((LayoutParams) view.getLayoutParams()).gravity;
        int Z = u.Z(this);
        switch (i2) {
            case 3:
                if (this.TO != 3) {
                    return this.TO;
                }
                int i3 = Z == 0 ? this.TQ : this.TR;
                if (i3 != 3) {
                    return i3;
                }
                break;
            case 5:
                if (this.TP != 3) {
                    return this.TP;
                }
                int i4 = Z == 0 ? this.TR : this.TQ;
                if (i4 != 3) {
                    return i4;
                }
                break;
            case 8388611:
                if (this.TQ != 3) {
                    return this.TQ;
                }
                int i5 = Z == 0 ? this.TO : this.TP;
                if (i5 != 3) {
                    return i5;
                }
                break;
            case 8388613:
                if (this.TR != 3) {
                    return this.TR;
                }
                int i6 = Z == 0 ? this.TP : this.TO;
                if (i6 != 3) {
                    return i6;
                }
                break;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void f(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || aP(childAt)) && (!z || childAt != view)) {
                u.p(childAt, 4);
            } else {
                u.p(childAt, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void p(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.Uj) {
            layoutParams.Uj = f2;
            if (this.mListeners != null) {
                for (int size = this.mListeners.size() - 1; size >= 0; size--) {
                    this.mListeners.get(size).F(f2);
                }
            }
        }
    }

    static float aM(View view) {
        return ((LayoutParams) view.getLayoutParams()).Uj;
    }

    /* access modifiers changed from: package-private */
    public final int aN(View view) {
        return android.support.v4.view.d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, u.Z(this));
    }

    /* access modifiers changed from: package-private */
    public final boolean x(View view, int i2) {
        return (aN(view) & i2) == i2;
    }

    private View fU() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).Ul & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final View aW(int i2) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(i2, u.Z(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((aN(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
        // Method dump skipped, instructions count: 493
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    private static boolean c(Drawable drawable, int i2) {
        if (drawable == null || !android.support.v4.graphics.drawable.a.e(drawable)) {
            return false;
        }
        android.support.v4.graphics.drawable.a.b(drawable, i2);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        float f2;
        this.mInLayout = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (aO(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (x(childAt, 3)) {
                        i6 = ((int) (((float) measuredWidth) * layoutParams.Uj)) + (-measuredWidth);
                        f2 = ((float) (measuredWidth + i6)) / ((float) measuredWidth);
                    } else {
                        i6 = i7 - ((int) (((float) measuredWidth) * layoutParams.Uj));
                        f2 = ((float) (i7 - i6)) / ((float) measuredWidth);
                    }
                    boolean z2 = f2 != layoutParams.Uj;
                    switch (layoutParams.gravity & 112) {
                        case 16:
                            int i9 = i5 - i3;
                            int i10 = (i9 - measuredHeight) / 2;
                            if (i10 < layoutParams.topMargin) {
                                i10 = layoutParams.topMargin;
                            } else if (i10 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i10 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i6, i10, measuredWidth + i6, measuredHeight + i10);
                            break;
                        case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                            int i11 = i5 - i3;
                            childAt.layout(i6, (i11 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i11 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i6, layoutParams.topMargin, measuredWidth + i6, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z2) {
                        p(childAt, f2);
                    }
                    int i12 = layoutParams.Uj > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i12) {
                        childAt.setVisibility(i12);
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).Uj);
        }
        this.TH = f2;
        boolean go = this.TJ.go();
        boolean go2 = this.TK.go();
        if (go || go2) {
            u.X(this);
        }
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.qx = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.qx;
    }

    public void setStatusBarBackground(int i2) {
        this.qx = i2 != 0 ? android.support.v4.content.b.l(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.qx = new ColorDrawable(i2);
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.qw && this.qx != null) {
            int systemWindowInsetTop = Build.VERSION.SDK_INT >= 21 ? this.TZ != null ? ((WindowInsets) this.TZ).getSystemWindowInsetTop() : 0 : 0;
            if (systemWindowInsetTop > 0) {
                this.qx.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.qx.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        int height = getHeight();
        boolean aO = aO(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (aO) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if (background == null) {
                        z = false;
                    } else if (background.getOpacity() == -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && aP(childAt) && childAt.getHeight() >= height) {
                        if (x(childAt, 3)) {
                            int right = childAt.getRight();
                            if (right <= i2) {
                                right = i2;
                            }
                            i2 = right;
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        if (this.TH > 0.0f && aO) {
            this.TI.setColor((((int) (((float) ((this.TG & WebView.NIGHT_MODE_COLOR) >>> 24)) * this.TH)) << 24) | (this.TG & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.TI);
        } else if (this.TV != null && x(view, 3)) {
            int intrinsicWidth = this.TV.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.TJ.WI), 1.0f));
            this.TV.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.TV.setAlpha((int) (255.0f * max));
            this.TV.draw(canvas);
        } else if (this.TW != null && x(view, 5)) {
            int intrinsicWidth2 = this.TW.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.TK.WI), 1.0f));
            this.TW.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.TW.setAlpha((int) (255.0f * max2));
            this.TW.draw(canvas);
        }
        return drawChild;
    }

    private static boolean aO(View view) {
        return ((LayoutParams) view.getLayoutParams()).gravity == 0;
    }

    static boolean aP(View view) {
        int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).gravity, u.Z(view));
        if ((absoluteGravity & 3) != 0) {
            return true;
        }
        if ((absoluteGravity & 5) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        View J;
        boolean z4;
        int actionMasked = motionEvent.getActionMasked();
        boolean j2 = this.TK.j(motionEvent) | this.TJ.j(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (this.TH <= 0.0f || (J = this.TJ.J((int) x, (int) y)) == null || !aO(J)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.TS = false;
                this.TT = false;
                break;
            case 1:
            case 3:
                O(true);
                this.TS = false;
                this.TT = false;
                z2 = false;
                break;
            case 2:
                t tVar = this.TJ;
                int length = tVar.Wy.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        if (tVar.be(i2)) {
                            float f2 = tVar.WA[i2] - tVar.Wy[i2];
                            float f3 = tVar.WB[i2] - tVar.Wz[i2];
                            z3 = (f2 * f2) + (f3 * f3) > ((float) (tVar.mTouchSlop * tVar.mTouchSlop));
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z = true;
                        } else {
                            i2++;
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.TL.fS();
                    this.TM.fS();
                    z2 = false;
                    break;
                }
                z2 = false;
                break;
            default:
                z2 = false;
                break;
        }
        if (!j2 && !z2) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    z4 = false;
                } else if (((LayoutParams) getChildAt(i3).getLayoutParams()).Uk) {
                    z4 = true;
                } else {
                    i3++;
                }
            }
            if (!z4 && !this.TT) {
                return false;
            }
        }
        return true;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.TH <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount != 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                if (this.Uf == null) {
                    this.Uf = new Rect();
                }
                childAt.getHitRect(this.Uf);
                if (this.Uf.contains((int) x, (int) y) && !aO(childAt)) {
                    if (!childAt.getMatrix().isIdentity()) {
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.offsetLocation((float) (getScrollX() - childAt.getLeft()), (float) (getScrollY() - childAt.getTop()));
                        Matrix matrix = childAt.getMatrix();
                        if (!matrix.isIdentity()) {
                            if (this.Ug == null) {
                                this.Ug = new Matrix();
                            }
                            matrix.invert(this.Ug);
                            obtain.transform(this.Ug);
                        }
                        dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                        obtain.recycle();
                    } else {
                        float scrollX = (float) (getScrollX() - childAt.getLeft());
                        float scrollY = (float) (getScrollY() - childAt.getTop());
                        motionEvent.offsetLocation(scrollX, scrollY);
                        dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                        motionEvent.offsetLocation(-scrollX, -scrollY);
                    }
                    if (dispatchGenericMotionEvent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View fU;
        this.TJ.k(motionEvent);
        this.TK.k(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.TS = false;
                this.TT = false;
                break;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View J = this.TJ.J((int) x2, (int) y2);
                if (J != null && aO(J)) {
                    float f2 = x2 - this.mInitialMotionX;
                    float f3 = y2 - this.mInitialMotionY;
                    int i2 = this.TJ.mTouchSlop;
                    if ((f2 * f2) + (f3 * f3) < ((float) (i2 * i2)) && (fU = fU()) != null) {
                        z = aL(fU) == 2;
                        O(z);
                        this.TS = false;
                        break;
                    }
                }
                z = true;
                O(z);
                this.TS = false;
            case 3:
                O(true);
                this.TS = false;
                this.TT = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.TS = z;
        if (z) {
            O(true);
        }
    }

    private void O(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (aP(childAt) && (!z || layoutParams.Uk)) {
                int width = childAt.getWidth();
                if (x(childAt, 3)) {
                    z2 |= this.TJ.h(childAt, -width, childAt.getTop());
                } else {
                    z2 |= this.TK.h(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.Uk = false;
            }
        }
        this.TL.fS();
        this.TM.fS();
        if (z2) {
            invalidate();
        }
    }

    private void aQ(View view) {
        if (!aP(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.Uj = 1.0f;
            layoutParams.Ul = 1;
            f(view, true);
        } else {
            layoutParams.Ul |= 2;
            if (x(view, 3)) {
                this.TJ.h(view, 0, view.getTop());
            } else {
                this.TK.h(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void aR(View view) {
        if (!aP(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.mFirstLayout) {
            layoutParams.Uj = 0.0f;
            layoutParams.Ul = 0;
        } else {
            layoutParams.Ul |= 4;
            if (x(view, 3)) {
                this.TJ.h(view, -view.getWidth(), view.getTop());
            } else {
                this.TK.h(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        boolean z;
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i4 = 0;
            boolean z2 = false;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (!aP(childAt)) {
                    this.Ue.add(childAt);
                    z = z2;
                } else if (!aP(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                } else {
                    if ((((LayoutParams) childAt.getLayoutParams()).Ul & 1) == 1) {
                        childAt.addFocusables(arrayList, i2, i3);
                        z = true;
                    }
                    z = z2;
                }
                i4++;
                z2 = z;
            }
            if (!z2) {
                int size = this.Ue.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.Ue.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.Ue.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final View fV() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (aP(childAt)) {
                if (!aP(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((LayoutParams) childAt.getLayoutParams()).Uj > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        if (i2 == 4) {
            if (fV() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View fV = fV();
        if (fV != null && aL(fV) == 0) {
            O(false);
        }
        if (fV != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View aW;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.Pm);
        if (!(savedState.Um == 0 || (aW = aW(savedState.Um)) == null)) {
            aQ(aW);
        }
        if (savedState.Un != 3) {
            C(savedState.Un, 3);
        }
        if (savedState.Uo != 3) {
            C(savedState.Uo, 5);
        }
        if (savedState.Up != 3) {
            C(savedState.Up, 8388611);
        }
        if (savedState.Uq != 3) {
            C(savedState.Uq, 8388613);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        LayoutParams layoutParams;
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            boolean z2 = layoutParams.Ul == 1;
            if (layoutParams.Ul == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z2 || z) {
                savedState.Um = layoutParams.gravity;
            } else {
                i2++;
            }
        }
        savedState.Um = layoutParams.gravity;
        savedState.Un = this.TO;
        savedState.Uo = this.TP;
        savedState.Up = this.TQ;
        savedState.Uq = this.TR;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (fU() != null || aP(view)) {
            u.p(view, 4);
        } else {
            u.p(view, 1);
        }
        if (!TB) {
            u.a(view, this.TD);
        }
    }

    static boolean aS(View view) {
        return (u.Y(view) == 4 || u.Y(view) == 2) ? false : true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class android.support.v4.widget.DrawerLayout.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        int Um = 0;
        int Un;
        int Uo;
        int Up;
        int Uq;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Um = parcel.readInt();
            this.Un = parcel.readInt();
            this.Uo = parcel.readInt();
            this.Up = parcel.readInt();
            this.Uq = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Um);
            parcel.writeInt(this.Un);
            parcel.writeInt(this.Uo);
            parcel.writeInt(this.Up);
            parcel.writeInt(this.Uq);
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends t.a {
        final int Ur;
        t Us;
        private final Runnable Ut = new Runnable() {
            /* class android.support.v4.widget.DrawerLayout.d.AnonymousClass1 */

            public final void run() {
                int width;
                View view;
                d dVar = d.this;
                int i2 = dVar.Us.WI;
                boolean z = dVar.Ur == 3;
                if (z) {
                    view = DrawerLayout.this.aW(3);
                    width = (view != null ? -view.getWidth() : 0) + i2;
                } else {
                    View aW = DrawerLayout.this.aW(5);
                    width = DrawerLayout.this.getWidth() - i2;
                    view = aW;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < width) || (!z && view.getLeft() > width)) && DrawerLayout.this.aL(view) == 0) {
                    dVar.Us.h(view, width, view.getTop());
                    ((LayoutParams) view.getLayoutParams()).Uk = true;
                    DrawerLayout.this.invalidate();
                    dVar.fY();
                    DrawerLayout drawerLayout = DrawerLayout.this;
                    if (!drawerLayout.TT) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            drawerLayout.getChildAt(i3).dispatchTouchEvent(obtain);
                        }
                        obtain.recycle();
                        drawerLayout.TT = true;
                    }
                }
            }
        };

        d(int i2) {
            this.Ur = i2;
        }

        public final void fS() {
            DrawerLayout.this.removeCallbacks(this.Ut);
        }

        @Override // android.support.v4.widget.t.a
        public final boolean c(View view, int i2) {
            return DrawerLayout.aP(view) && DrawerLayout.this.x(view, this.Ur) && DrawerLayout.this.aL(view) == 0;
        }

        @Override // android.support.v4.widget.t.a
        public final void L(int i2) {
            int i3;
            View rootView;
            DrawerLayout drawerLayout = DrawerLayout.this;
            View view = this.Us.WL;
            int i4 = drawerLayout.TJ.Wx;
            int i5 = drawerLayout.TK.Wx;
            if (i4 == 1 || i5 == 1) {
                i3 = 1;
            } else if (i4 == 2 || i5 == 2) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            if (view != null && i2 == 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.Uj == 0.0f) {
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams2.Ul & 1) == 1) {
                        layoutParams2.Ul = 0;
                        if (drawerLayout.mListeners != null) {
                            for (int size = drawerLayout.mListeners.size() - 1; size >= 0; size--) {
                                drawerLayout.mListeners.get(size).fX();
                            }
                        }
                        drawerLayout.f(view, false);
                        if (drawerLayout.hasWindowFocus() && (rootView = drawerLayout.getRootView()) != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                } else if (layoutParams.Uj == 1.0f) {
                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                    if ((layoutParams3.Ul & 1) == 0) {
                        layoutParams3.Ul = 1;
                        if (drawerLayout.mListeners != null) {
                            for (int size2 = drawerLayout.mListeners.size() - 1; size2 >= 0; size2--) {
                                drawerLayout.mListeners.get(size2).fW();
                            }
                        }
                        drawerLayout.f(view, true);
                        if (drawerLayout.hasWindowFocus()) {
                            drawerLayout.sendAccessibilityEvent(32);
                        }
                    }
                }
            }
            if (i3 != drawerLayout.TN) {
                drawerLayout.TN = i3;
                if (drawerLayout.mListeners != null) {
                    for (int size3 = drawerLayout.mListeners.size() - 1; size3 >= 0; size3--) {
                        drawerLayout.mListeners.get(size3);
                    }
                }
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void b(View view, int i2, int i3) {
            float width;
            int width2 = view.getWidth();
            if (DrawerLayout.this.x(view, 3)) {
                width = ((float) (width2 + i2)) / ((float) width2);
            } else {
                width = ((float) (DrawerLayout.this.getWidth() - i2)) / ((float) width2);
            }
            DrawerLayout.this.p(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.t.a
        public final void l(View view, int i2) {
            ((LayoutParams) view.getLayoutParams()).Uk = false;
            fY();
        }

        /* access modifiers changed from: package-private */
        public final void fY() {
            int i2 = 3;
            if (this.Ur == 3) {
                i2 = 5;
            }
            View aW = DrawerLayout.this.aW(i2);
            if (aW != null) {
                DrawerLayout.this.aR(aW);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final void a(View view, float f2, float f3) {
            int width;
            float aM = DrawerLayout.aM(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.x(view, 3)) {
                width = (f2 > 0.0f || (f2 == 0.0f && aM > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && aM > 0.5f)) {
                    width -= width2;
                }
            }
            this.Us.H(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.t.a
        public final void fZ() {
            DrawerLayout.this.postDelayed(this.Ut, 160);
        }

        @Override // android.support.v4.widget.t.a
        public final void D(int i2, int i3) {
            View aW;
            if ((i2 & 1) == 1) {
                aW = DrawerLayout.this.aW(3);
            } else {
                aW = DrawerLayout.this.aW(5);
            }
            if (aW != null && DrawerLayout.this.aL(aW) == 0) {
                this.Us.y(aW, i3);
            }
        }

        @Override // android.support.v4.widget.t.a
        public final int y(View view) {
            if (DrawerLayout.aP(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // android.support.v4.widget.t.a
        public final int e(View view, int i2) {
            if (DrawerLayout.this.x(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // android.support.v4.widget.t.a
        public final int d(View view, int i2) {
            return view.getTop();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        float Uj;
        boolean Uk;
        int Ul;
        public int gravity = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    class a extends android.support.v4.view.a {
        private final Rect Ui = new Rect();

        a() {
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
            if (DrawerLayout.TB) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
            } else {
                android.support.v4.view.a.c a2 = android.support.v4.view.a.c.a(cVar);
                super.onInitializeAccessibilityNodeInfo(view, a2);
                cVar.setSource(view);
                ViewParent aa = u.aa(view);
                if (aa instanceof View) {
                    cVar.setParent((View) aa);
                }
                Rect rect = this.Ui;
                a2.getBoundsInParent(rect);
                cVar.setBoundsInParent(rect);
                a2.getBoundsInScreen(rect);
                cVar.setBoundsInScreen(rect);
                cVar.setVisibleToUser(a2.isVisibleToUser());
                cVar.setPackageName(a2.Ro.getPackageName());
                cVar.setClassName(a2.Ro.getClassName());
                cVar.setContentDescription(a2.Ro.getContentDescription());
                cVar.setEnabled(a2.Ro.isEnabled());
                cVar.setClickable(a2.Ro.isClickable());
                cVar.setFocusable(a2.Ro.isFocusable());
                cVar.setFocused(a2.Ro.isFocused());
                cVar.setAccessibilityFocused(a2.isAccessibilityFocused());
                cVar.setSelected(a2.Ro.isSelected());
                cVar.setLongClickable(a2.Ro.isLongClickable());
                cVar.addAction(a2.Ro.getActions());
                a2.Ro.recycle();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (DrawerLayout.aS(childAt)) {
                        cVar.addChild(childAt);
                    }
                }
            }
            cVar.setClassName(DrawerLayout.class.getName());
            cVar.setFocusable(false);
            cVar.setFocused(false);
            cVar.a(c.a.Rq);
            cVar.a(c.a.Rr);
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // android.support.v4.view.a
        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View fV = DrawerLayout.this.fV();
            if (fV != null) {
                int aN = DrawerLayout.this.aN(fV);
                DrawerLayout drawerLayout = DrawerLayout.this;
                int absoluteGravity = android.support.v4.view.d.getAbsoluteGravity(aN, u.Z(drawerLayout));
                if (absoluteGravity == 3) {
                    charSequence = drawerLayout.TX;
                } else if (absoluteGravity == 5) {
                    charSequence = drawerLayout.TY;
                } else {
                    charSequence = null;
                }
                if (charSequence != null) {
                    text.add(charSequence);
                }
            }
            return true;
        }

        @Override // android.support.v4.view.a
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.TB || DrawerLayout.aS(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class b extends android.support.v4.view.a {
        b() {
        }

        @Override // android.support.v4.view.a
        public final void onInitializeAccessibilityNodeInfo(View view, android.support.v4.view.a.c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            if (!DrawerLayout.aS(view)) {
                cVar.setParent(null);
            }
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        Drawable drawable;
        Drawable drawable2;
        if (!TC) {
            int Z = u.Z(this);
            if (Z == 0) {
                if (this.Ua != null) {
                    c(this.Ua, Z);
                    drawable = this.Ua;
                }
                drawable = this.Uc;
            } else {
                if (this.Ub != null) {
                    c(this.Ub, Z);
                    drawable = this.Ub;
                }
                drawable = this.Uc;
            }
            this.TV = drawable;
            int Z2 = u.Z(this);
            if (Z2 == 0) {
                if (this.Ub != null) {
                    c(this.Ub, Z2);
                    drawable2 = this.Ub;
                }
                drawable2 = this.Ud;
            } else {
                if (this.Ua != null) {
                    c(this.Ua, Z2);
                    drawable2 = this.Ua;
                }
                drawable2 = this.Ud;
            }
            this.TW = drawable2;
        }
    }
}
