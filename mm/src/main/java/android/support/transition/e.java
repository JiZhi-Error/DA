package android.support.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mm.R;

@SuppressLint({"ViewConstructor"})
final class e extends View implements g {
    ViewGroup Bf;
    View Bg;
    int Bh;
    private int Bi;
    private int Bj;
    Matrix Bk;
    private final ViewTreeObserver.OnPreDrawListener Bl = new ViewTreeObserver.OnPreDrawListener() {
        /* class android.support.transition.e.AnonymousClass1 */

        public final boolean onPreDraw() {
            e.this.Bk = e.this.mView.getMatrix();
            u.X(e.this);
            if (e.this.Bf == null || e.this.Bg == null) {
                return true;
            }
            e.this.Bf.endViewTransition(e.this.Bg);
            u.X(e.this.Bf);
            e.this.Bf = null;
            e.this.Bg = null;
            return true;
        }
    };
    private final Matrix mMatrix = new Matrix();
    final View mView;

    static g a(View view, ViewGroup viewGroup) {
        FrameLayout frameLayout;
        e F = F(view);
        if (F == null) {
            ViewGroup viewGroup2 = viewGroup;
            while (true) {
                if (viewGroup2 instanceof FrameLayout) {
                    frameLayout = (FrameLayout) viewGroup2;
                    break;
                }
                ViewParent parent = viewGroup2.getParent();
                if (!(parent instanceof ViewGroup)) {
                    frameLayout = null;
                    break;
                }
                viewGroup2 = (ViewGroup) parent;
            }
            if (frameLayout == null) {
                return null;
            }
            F = new e(view);
            frameLayout.addView(F);
        }
        F.Bh++;
        return F;
    }

    static void E(View view) {
        e F = F(view);
        if (F != null) {
            F.Bh--;
            if (F.Bh <= 0) {
                ViewParent parent = F.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(F);
                    viewGroup.removeView(F);
                }
            }
        }
    }

    private e(View view) {
        super(view.getContext());
        this.mView = view;
        setLayerType(2, null);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mView.setTag(R.id.djy, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.mView.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (((float) iArr2[0]) - this.mView.getTranslationX());
        iArr2[1] = (int) (((float) iArr2[1]) - this.mView.getTranslationY());
        this.Bi = iArr2[0] - iArr[0];
        this.Bj = iArr2[1] - iArr[1];
        this.mView.getViewTreeObserver().addOnPreDrawListener(this.Bl);
        this.mView.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        this.mView.getViewTreeObserver().removeOnPreDrawListener(this.Bl);
        this.mView.setVisibility(0);
        this.mView.setTag(R.id.djy, null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        this.mMatrix.set(this.Bk);
        this.mMatrix.postTranslate((float) this.Bi, (float) this.Bj);
        canvas.setMatrix(this.mMatrix);
        this.mView.draw(canvas);
    }

    @Override // android.support.transition.g
    public final void setVisibility(int i2) {
        super.setVisibility(i2);
        this.mView.setVisibility(i2 == 0 ? 4 : 0);
    }

    @Override // android.support.transition.g
    public final void a(ViewGroup viewGroup, View view) {
        this.Bf = viewGroup;
        this.Bg = view;
    }

    private static e F(View view) {
        return (e) view.getTag(R.id.djy);
    }
}
