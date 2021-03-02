package android.support.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public class ae implements ag {
    protected a DB;

    ae(Context context, ViewGroup viewGroup, View view) {
        this.DB = new a(context, viewGroup, view, this);
    }

    static ae M(View view) {
        ViewGroup viewGroup;
        View view2 = view;
        while (true) {
            if (view2 == null) {
                viewGroup = null;
                break;
            } else if (view2.getId() == 16908290 && (view2 instanceof ViewGroup)) {
                viewGroup = (ViewGroup) view2;
                break;
            } else if (view2.getParent() instanceof ViewGroup) {
                view2 = (ViewGroup) view2.getParent();
            }
        }
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof a) {
                return ((a) childAt).DG;
            }
        }
        return new y(viewGroup.getContext(), viewGroup, view);
    }

    @Override // android.support.transition.ag
    public final void add(Drawable drawable) {
        a aVar = this.DB;
        if (aVar.DF == null) {
            aVar.DF = new ArrayList<>();
        }
        if (!aVar.DF.contains(drawable)) {
            aVar.DF.add(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback(aVar);
        }
    }

    @Override // android.support.transition.ag
    public final void remove(Drawable drawable) {
        a aVar = this.DB;
        if (aVar.DF != null) {
            aVar.DF.remove(drawable);
            aVar.invalidate(drawable.getBounds());
            drawable.setCallback(null);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends ViewGroup {
        static Method DC;
        ViewGroup DD;
        View DE;
        ArrayList<Drawable> DF = null;
        ae DG;

        static {
            try {
                DC = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException e2) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, ae aeVar) {
            super(context);
            this.DD = viewGroup;
            this.DE = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.DG = aeVar;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        /* access modifiers changed from: protected */
        public final boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.DF != null && this.DF.contains(drawable));
        }

        public final void add(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.DD || viewGroup.getParent() == null || !u.aD(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.DD.getLocationOnScreen(iArr2);
                    u.u(view, iArr[0] - iArr2[0]);
                    u.s(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        public final void remove(View view) {
            boolean z;
            super.removeView(view);
            if (getChildCount() == 0 && (this.DF == null || this.DF.size() == 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.DD.removeView(this);
            }
        }

        public final void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public final void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.DD.getLocationOnScreen(iArr);
            this.DE.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.DE.getWidth(), this.DE.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.DF == null ? 0 : this.DF.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.DF.get(i2).draw(canvas);
            }
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        }

        public final ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.DD != null) {
                rect.offset(iArr[0], iArr[1]);
                if (this.DD instanceof ViewGroup) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    int[] iArr2 = new int[2];
                    int[] iArr3 = new int[2];
                    this.DD.getLocationOnScreen(iArr2);
                    this.DE.getLocationOnScreen(iArr3);
                    int[] iArr4 = {iArr3[0] - iArr2[0], iArr3[1] - iArr2[1]};
                    rect.offset(iArr4[0], iArr4[1]);
                    return super.invalidateChildInParent(iArr, rect);
                }
                invalidate(rect);
            }
            return null;
        }
    }
}
