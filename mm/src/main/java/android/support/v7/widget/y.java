package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.widget.m;
import android.support.v7.d.a.c;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import java.lang.reflect.Field;

/* access modifiers changed from: package-private */
public class y extends ListView {
    private final Rect amS = new Rect();
    private int amT = 0;
    private int amU = 0;
    private int amV = 0;
    private int amW = 0;
    private int amX;
    private Field amY;
    private a amZ;
    private boolean ana;
    private boolean anb;
    private boolean anc;
    private android.support.v4.view.y and;
    private m ane;
    b anf;

    y(Context context, boolean z) {
        super(context, null, R.attr.jt);
        this.anb = z;
        setCacheColorHint(0);
        try {
            this.amY = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.amY.setAccessible(true);
        } catch (NoSuchFieldException e2) {
        }
    }

    public boolean isInTouchMode() {
        return (this.anb && this.ana) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.anb || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.anb || super.isFocused();
    }

    public boolean hasFocus() {
        return this.anb || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.amZ = drawable != null ? new a(drawable) : null;
        super.setSelector(this.amZ);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.amT = rect.left;
        this.amU = rect.top;
        this.amV = rect.right;
        this.amW = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.anf == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            jG();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.amX = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        if (this.anf != null) {
            b bVar = this.anf;
            y.this.anf = null;
            y.this.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public int e(int i2, int i3, int i4, int i5, int i6) {
        int makeMeasureSpec;
        int i7;
        int i8;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i9 = listPaddingBottom + listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i10 = 0;
        View view = null;
        int i11 = 0;
        int count = adapter.getCount();
        int i12 = 0;
        while (i12 < count) {
            int itemViewType = adapter.getItemViewType(i12);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i12, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, makeMeasureSpec);
            view.forceLayout();
            if (i12 > 0) {
                i7 = i9 + dividerHeight;
            } else {
                i7 = i9;
            }
            i9 = view.getMeasuredHeight() + i7;
            if (i9 >= i5) {
                return (i6 < 0 || i12 <= i6 || i10 <= 0 || i9 == i5) ? i5 : i10;
            }
            if (i6 < 0 || i12 < i6) {
                i8 = i10;
            } else {
                i8 = i9;
            }
            i12++;
            i10 = i8;
        }
        return i9;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.amZ != null) {
            this.amZ.mEnabled = z;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c {
        boolean mEnabled = true;

        a(Drawable drawable) {
            super(drawable);
        }

        @Override // android.support.v7.d.a.c
        public final boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // android.support.v7.d.a.c
        public final void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.d.a.c
        public final void setHotspot(float f2, float f3) {
            if (this.mEnabled) {
                super.setHotspot(f2, f3);
            }
        }

        @Override // android.support.v7.d.a.c
        public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.mEnabled) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        @Override // android.support.v7.d.a.c
        public final boolean setVisible(boolean z, boolean z2) {
            if (this.mEnabled) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.anf == null) {
            this.anf = new b();
            b bVar = this.anf;
            y.this.post(bVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition == -1 || pointToPosition == getSelectedItemPosition()) {
                return onHoverEvent;
            }
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
            }
            jG();
            return onHoverEvent;
        }
        setSelection(-1);
        return onHoverEvent;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.anf = null;
        super.onDetachedFromWindow();
    }

    public boolean f(MotionEvent motionEvent, int i2) {
        boolean z;
        View childAt;
        boolean z2 = true;
        boolean z3 = false;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z2 = false;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                if (findPointerIndex >= 0) {
                    int x = (int) motionEvent.getX(findPointerIndex);
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                        float f2 = (float) x;
                        float f3 = (float) y;
                        this.anc = true;
                        if (Build.VERSION.SDK_INT >= 21) {
                            drawableHotspotChanged(f2, f3);
                        }
                        if (!isPressed()) {
                            setPressed(true);
                        }
                        layoutChildren();
                        if (!(this.amX == -1 || (childAt = getChildAt(this.amX - getFirstVisiblePosition())) == null || childAt == childAt2 || !childAt.isPressed())) {
                            childAt.setPressed(false);
                        }
                        this.amX = pointToPosition;
                        float left = f2 - ((float) childAt2.getLeft());
                        float top = f3 - ((float) childAt2.getTop());
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt2.drawableHotspotChanged(left, top);
                        }
                        if (!childAt2.isPressed()) {
                            childAt2.setPressed(true);
                        }
                        Drawable selector = getSelector();
                        if (selector == null || pointToPosition == -1) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            selector.setVisible(false, false);
                        }
                        Rect rect = this.amS;
                        rect.set(childAt2.getLeft(), childAt2.getTop(), childAt2.getRight(), childAt2.getBottom());
                        rect.left -= this.amT;
                        rect.top -= this.amU;
                        rect.right += this.amV;
                        rect.bottom += this.amW;
                        try {
                            boolean z4 = this.amY.getBoolean(this);
                            if (childAt2.isEnabled() != z4) {
                                this.amY.set(this, Boolean.valueOf(!z4));
                                if (pointToPosition != -1) {
                                    refreshDrawableState();
                                }
                            }
                        } catch (IllegalAccessException e2) {
                        }
                        if (z) {
                            Rect rect2 = this.amS;
                            float exactCenterX = rect2.exactCenterX();
                            float exactCenterY = rect2.exactCenterY();
                            selector.setVisible(getVisibility() == 0, false);
                            android.support.v4.graphics.drawable.a.a(selector, exactCenterX, exactCenterY);
                        }
                        Drawable selector2 = getSelector();
                        if (!(selector2 == null || pointToPosition == -1)) {
                            android.support.v4.graphics.drawable.a.a(selector2, f2, f3);
                        }
                        setSelectorEnabled(false);
                        refreshDrawableState();
                        z2 = true;
                        if (actionMasked == 1) {
                            performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                            break;
                        }
                    } else {
                        z3 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
                break;
            case 3:
                z2 = false;
                break;
        }
        if (!z2 || z3) {
            this.anc = false;
            setPressed(false);
            drawableStateChanged();
            View childAt3 = getChildAt(this.amX - getFirstVisiblePosition());
            if (childAt3 != null) {
                childAt3.setPressed(false);
            }
            if (this.and != null) {
                this.and.cancel();
                this.and = null;
            }
        }
        if (z2) {
            if (this.ane == null) {
                this.ane = new m(this);
            }
            this.ane.L(true);
            this.ane.onTouch(this, motionEvent);
        } else if (this.ane != null) {
            this.ane.L(false);
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.ana = z;
    }

    private void jG() {
        Drawable selector = getSelector();
        if (selector != null && this.anc && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Runnable {
        b() {
        }

        public final void run() {
            y.this.anf = null;
            y.this.drawableStateChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.amS.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.amS);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }
}
