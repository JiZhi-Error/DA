package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int aAa;
    private WeakReference<View> aAb;
    private a aAc;
    private int azZ;
    private LayoutInflater mInflater;

    public interface a {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.azZ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ViewStubCompat, i2, 0);
        this.aAa = obtainStyledAttributes.getResourceId(2, -1);
        this.azZ = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final int getInflatedId() {
        return this.aAa;
    }

    public final void setInflatedId(int i2) {
        this.aAa = i2;
    }

    public final int getLayoutResource() {
        return this.azZ;
    }

    public final void setLayoutResource(int i2) {
        this.azZ = i2;
    }

    public final void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    @SuppressLint({"MissingSuperCall"})
    public final void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public final void dispatchDraw(Canvas canvas) {
    }

    public final void setVisibility(int i2) {
        if (this.aAb != null) {
            View view = this.aAb.get();
            if (view != null) {
                view.setVisibility(i2);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i2);
        if (i2 == 0 || i2 == 4) {
            inflate();
        }
    }

    public final View inflate() {
        LayoutInflater from;
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.azZ != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (this.mInflater != null) {
                from = this.mInflater;
            } else {
                from = LayoutInflater.from(getContext());
            }
            View inflate = from.inflate(this.azZ, viewGroup, false);
            if (this.aAa != -1) {
                inflate.setId(this.aAa);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.aAb = new WeakReference<>(inflate);
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    public final void setOnInflateListener(a aVar) {
        this.aAc = aVar;
    }
}
