package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;

/* access modifiers changed from: package-private */
public abstract class a extends ViewGroup {
    protected final C0052a ahq = new C0052a();
    protected final Context ahr;
    protected ActionMenuView ahs;
    protected ActionMenuPresenter aht;
    protected int ahu;
    protected y ahv;
    private boolean ahw;
    private boolean ahx;

    a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.y, typedValue, true) || typedValue.resourceId == 0) {
            this.ahr = context;
        } else {
            this.ahr = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.C0040a.ActionBar, R.attr.a1, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        if (this.aht != null) {
            this.aht.iE();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.ahw = false;
        }
        if (!this.ahw) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.ahw = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.ahw = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.ahx = false;
        }
        if (!this.ahx) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.ahx = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.ahx = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.ahu = i2;
        requestLayout();
    }

    public int getContentHeight() {
        return this.ahu;
    }

    public int getAnimatedVisibility() {
        if (this.ahv != null) {
            return this.ahq.Ed;
        }
        return getVisibility();
    }

    public y c(int i2, long j2) {
        if (this.ahv != null) {
            this.ahv.cancel();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            y y = u.ah(this).y(1.0f);
            y.j(j2);
            y.a(this.ahq.a(y, i2));
            return y;
        }
        y y2 = u.ah(this).y(0.0f);
        y2.j(j2);
        y2.a(this.ahq.a(y2, i2));
        return y2;
    }

    public void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            if (this.ahv != null) {
                this.ahv.cancel();
            }
            super.setVisibility(i2);
        }
    }

    public boolean showOverflowMenu() {
        if (this.aht != null) {
            return this.aht.showOverflowMenu();
        }
        return false;
    }

    protected static int j(View view, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, (i2 - view.getMeasuredWidth()) + 0);
    }

    protected static int c(int i2, int i3, boolean z) {
        return z ? i2 - i3 : i2 + i3;
    }

    protected static int a(View view, int i2, int i3, int i4, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* access modifiers changed from: protected */
    /* renamed from: android.support.v7.widget.a$a  reason: collision with other inner class name */
    public class C0052a implements z {
        int Ed;
        private boolean mCanceled = false;

        protected C0052a() {
        }

        public final C0052a a(y yVar, int i2) {
            a.this.ahv = yVar;
            this.Ed = i2;
            return this;
        }

        @Override // android.support.v4.view.z
        public final void aI(View view) {
            a.super.setVisibility(0);
            this.mCanceled = false;
        }

        @Override // android.support.v4.view.z
        public final void aJ(View view) {
            if (!this.mCanceled) {
                a.this.ahv = null;
                a.super.setVisibility(this.Ed);
            }
        }

        @Override // android.support.v4.view.z
        public final void aK(View view) {
            this.mCanceled = true;
        }
    }
}
