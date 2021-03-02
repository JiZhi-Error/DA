package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.p;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ab;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ActionMenuItemView extends AppCompatTextView implements p.a, ActionMenuView.a, View.OnClickListener {
    private CharSequence Hn;
    private Drawable Xw;
    j aeV;
    h.b aeW;
    private ab aeX;
    b aeY;
    private boolean aeZ;
    private boolean afa;
    private int afb;
    private int afc;
    private int mMinWidth;

    public static abstract class b {
        public abstract s hO();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.aeZ = hK();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ActionMenuItemView, i2, 0);
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.afc = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.afb = -1;
        setSaveEnabled(false);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.aeZ = hK();
        hL();
    }

    private boolean hK() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.afb = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.aeV;
    }

    @Override // android.support.v7.view.menu.p.a
    public final void a(j jVar) {
        this.aeV = jVar;
        setIcon(jVar.getIcon());
        setTitle(jVar.a(this));
        setId(jVar.getItemId());
        setVisibility(jVar.isVisible() ? 0 : 8);
        setEnabled(jVar.isEnabled());
        if (jVar.hasSubMenu() && this.aeX == null) {
            this.aeX = new a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.aeV.hasSubMenu() || this.aeX == null || !this.aeX.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onClick(View view) {
        if (this.aeW != null) {
            this.aeW.f(this.aeV);
        }
    }

    public void setItemInvoker(h.b bVar) {
        this.aeW = bVar;
    }

    public void setPopupCallback(b bVar) {
        this.aeY = bVar;
    }

    @Override // android.support.v7.view.menu.p.a
    public final boolean bC() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.afa != z) {
            this.afa = z;
            if (this.aeV != null) {
                this.aeV.aaQ.ie();
            }
        }
    }

    private void hL() {
        CharSequence charSequence;
        boolean z = false;
        CharSequence charSequence2 = null;
        boolean z2 = !TextUtils.isEmpty(this.Hn);
        if (this.Xw == null || (this.aeV.is() && (this.aeZ || this.afa))) {
            z = true;
        }
        boolean z3 = z2 & z;
        if (z3) {
            charSequence = this.Hn;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.aeV.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.aeV.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.aeV.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence2 = this.aeV.getTitle();
            }
            bb.a(this, charSequence2);
            return;
        }
        bb.a(this, tooltipText);
    }

    public void setIcon(Drawable drawable) {
        this.Xw = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.afc) {
                float f2 = ((float) this.afc) / ((float) intrinsicWidth);
                intrinsicWidth = this.afc;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f2);
            }
            if (intrinsicHeight > this.afc) {
                float f3 = ((float) this.afc) / ((float) intrinsicHeight);
                intrinsicHeight = this.afc;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f3);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        hL();
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.Hn = charSequence;
        hL();
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public final boolean hM() {
        return hasText() && this.aeV.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.a
    public final boolean hN() {
        return hasText();
    }

    @Override // android.support.v7.widget.AppCompatTextView
    public void onMeasure(int i2, int i3) {
        boolean hasText = hasText();
        if (hasText && this.afb >= 0) {
            super.setPadding(this.afb, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.mMinWidth) : this.mMinWidth;
        if (mode != 1073741824 && this.mMinWidth > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i3);
        }
        if (!hasText && this.Xw != null) {
            super.setPadding((getMeasuredWidth() - this.Xw.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    class a extends ab {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.ab
        public final s hO() {
            if (ActionMenuItemView.this.aeY != null) {
                return ActionMenuItemView.this.aeY.hO();
            }
            return null;
        }

        @Override // android.support.v7.widget.ab
        public final boolean hP() {
            s hO;
            if (ActionMenuItemView.this.aeW == null || !ActionMenuItemView.this.aeW.f(ActionMenuItemView.this.aeV) || (hO = hO()) == null || !hO.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
