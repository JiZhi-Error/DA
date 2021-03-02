package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v4.view.y;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.support.v7.view.menu.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class ActionBarContextView extends a {
    private CharSequence Hn;
    private CharSequence Md;
    private TextView Xy;
    private View ahI;
    private View ahJ;
    private LinearLayout ahK;
    private TextView ahL;
    private int ahM;
    private int ahN;
    public boolean ahO;
    private int ahP;

    @Override // android.support.v7.widget.a
    public final /* bridge */ /* synthetic */ y c(int i2, long j2) {
        return super.c(i2, j2);
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.am);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        az a2 = az.a(context, attributeSet, a.C0040a.ActionMode, i2, 0);
        u.a(this, a2.getDrawable(0));
        this.ahM = a2.getResourceId(5, 0);
        this.ahN = a2.getResourceId(4, 0);
        this.ahu = a2.getLayoutDimension(3, 0);
        this.ahP = a2.getResourceId(2, R.layout.am);
        a2.ayy.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.aht != null) {
            this.aht.hideOverflowMenu();
            this.aht.iH();
        }
    }

    @Override // android.support.v7.widget.a
    public void setContentHeight(int i2) {
        this.ahu = i2;
    }

    public void setCustomView(View view) {
        if (this.ahJ != null) {
            removeView(this.ahJ);
        }
        this.ahJ = view;
        if (!(view == null || this.ahK == null)) {
            removeView(this.ahK);
            this.ahK = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        iw();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.Md = charSequence;
        iw();
    }

    public CharSequence getTitle() {
        return this.Hn;
    }

    public CharSequence getSubtitle() {
        return this.Md;
    }

    private void iw() {
        int i2;
        int i3 = 8;
        boolean z = true;
        if (this.ahK == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.ah, this);
            this.ahK = (LinearLayout) getChildAt(getChildCount() - 1);
            this.Xy = (TextView) this.ahK.findViewById(R.id.cg);
            this.ahL = (TextView) this.ahK.findViewById(R.id.cf);
            if (this.ahM != 0) {
                this.Xy.setTextAppearance(getContext(), this.ahM);
            }
            if (this.ahN != 0) {
                this.ahL.setTextAppearance(getContext(), this.ahN);
            }
        }
        this.Xy.setText(this.Hn);
        this.ahL.setText(this.Md);
        boolean z2 = !TextUtils.isEmpty(this.Hn);
        if (TextUtils.isEmpty(this.Md)) {
            z = false;
        }
        TextView textView = this.ahL;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        LinearLayout linearLayout = this.ahK;
        if (z2 || z) {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
        if (this.ahK.getParent() == null) {
            addView(this.ahK);
        }
    }

    public final void c(final b bVar) {
        if (this.ahI == null) {
            this.ahI = LayoutInflater.from(getContext()).inflate(this.ahP, (ViewGroup) this, false);
            addView(this.ahI);
        } else if (this.ahI.getParent() == null) {
            addView(this.ahI);
        }
        this.ahI.findViewById(R.id.d5).setOnClickListener(new View.OnClickListener() {
            /* class android.support.v7.widget.ActionBarContextView.AnonymousClass1 */

            public final void onClick(View view) {
                bVar.finish();
            }
        });
        h hVar = (h) bVar.getMenu();
        if (this.aht != null) {
            this.aht.iG();
        }
        this.aht = new ActionMenuPresenter(getContext());
        this.aht.iF();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        hVar.a(this.aht, this.ahr);
        this.ahs = (ActionMenuView) this.aht.c(this);
        u.a(this.ahs, (Drawable) null);
        addView(this.ahs, layoutParams);
    }

    public final void ix() {
        if (this.ahI == null) {
            iy();
        }
    }

    public final void iy() {
        removeAllViews();
        this.ahJ = null;
        this.ahs = null;
    }

    @Override // android.support.v7.widget.a
    public final boolean showOverflowMenu() {
        if (this.aht != null) {
            return this.aht.showOverflowMenu();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size;
        int i4;
        int i5;
        int i6 = 1073741824;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int size2 = View.MeasureSpec.getSize(i2);
            if (this.ahu > 0) {
                size = this.ahu;
            } else {
                size = View.MeasureSpec.getSize(i3);
            }
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size2 - getPaddingLeft()) - getPaddingRight();
            int i7 = size - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE);
            if (this.ahI != null) {
                int j2 = j(this.ahI, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ahI.getLayoutParams();
                paddingLeft = j2 - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.ahs != null && this.ahs.getParent() == this) {
                paddingLeft = j(this.ahs, paddingLeft, makeMeasureSpec);
            }
            if (this.ahK != null && this.ahJ == null) {
                if (this.ahO) {
                    this.ahK.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.ahK.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.ahK.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = j(this.ahK, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.ahJ != null) {
                ViewGroup.LayoutParams layoutParams = this.ahJ.getLayoutParams();
                if (layoutParams.width != -2) {
                    i4 = 1073741824;
                } else {
                    i4 = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i6 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    i5 = Math.min(layoutParams.height, i7);
                } else {
                    i5 = i7;
                }
                this.ahJ.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i5, i6));
            }
            if (this.ahu <= 0) {
                int childCount = getChildCount();
                int i8 = 0;
                int i9 = 0;
                while (i8 < childCount) {
                    int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
                    if (measuredHeight <= i9) {
                        measuredHeight = i9;
                    }
                    i8++;
                    i9 = measuredHeight;
                }
                setMeasuredDimension(size2, i9);
                return;
            }
            setMeasuredDimension(size2, size);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean d2 = bh.d(this);
        int paddingRight = d2 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        if (!(this.ahI == null || this.ahI.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ahI.getLayoutParams();
            int i6 = d2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = d2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int c2 = c(paddingRight, i6, d2);
            paddingRight = c(c2 + a(this.ahI, c2, paddingTop, paddingTop2, d2), i7, d2);
        }
        if (!(this.ahK == null || this.ahJ != null || this.ahK.getVisibility() == 8)) {
            paddingRight += a(this.ahK, paddingRight, paddingTop, paddingTop2, d2);
        }
        if (this.ahJ != null) {
            a(this.ahJ, paddingRight, paddingTop, paddingTop2, d2);
        }
        int paddingLeft = d2 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        if (this.ahs != null) {
            a(this.ahs, paddingLeft, paddingTop, paddingTop2, !d2);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.Hn);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.ahO) {
            requestLayout();
        }
        this.ahO = z;
    }
}
