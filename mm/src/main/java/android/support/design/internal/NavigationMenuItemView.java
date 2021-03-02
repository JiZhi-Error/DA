package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.a.f;
import android.support.v4.view.a;
import android.support.v4.view.a.c;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.bb;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public class NavigationMenuItemView extends ForegroundLinearLayout implements p.a {
    private static final int[] jV = {16842912};
    private final int hC;
    boolean iJ;
    private boolean kQ;
    final CheckedTextView kR;
    FrameLayout kS;
    private ColorStateList kT;
    private boolean kU;
    private Drawable kV;
    private final a kW;
    private j kg;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.kW = new a() {
            /* class android.support.design.internal.NavigationMenuItemView.AnonymousClass1 */

            @Override // android.support.v4.view.a
            public final void onInitializeAccessibilityNodeInfo(View view, c cVar) {
                super.onInitializeAccessibilityNodeInfo(view, cVar);
                cVar.setCheckable(NavigationMenuItemView.this.iJ);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.zj, (ViewGroup) this, true);
        this.hC = context.getResources().getDimensionPixelSize(R.dimen.zf);
        this.kR = (CheckedTextView) findViewById(R.id.bnc);
        this.kR.setDuplicateParentStateEnabled(true);
        u.a(this.kR, this.kW);
    }

    @Override // android.support.v7.view.menu.p.a
    public final void a(j jVar) {
        boolean z;
        StateListDrawable stateListDrawable;
        this.kg = jVar;
        setVisibility(jVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.fx, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(jV, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            u.a(this, stateListDrawable);
        }
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setTitle(jVar.getTitle());
        setIcon(jVar.getIcon());
        setActionView(jVar.getActionView());
        setContentDescription(jVar.getContentDescription());
        bb.a(this, jVar.getTooltipText());
        if (this.kg.getTitle() == null && this.kg.getIcon() == null && this.kg.getActionView() != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.kR.setVisibility(8);
            if (this.kS != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) this.kS.getLayoutParams();
                layoutParams.width = -1;
                this.kS.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.kR.setVisibility(0);
        if (this.kS != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) this.kS.getLayoutParams();
            layoutParams2.width = -2;
            this.kS.setLayoutParams(layoutParams2);
        }
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.kS == null) {
                this.kS = (FrameLayout) ((ViewStub) findViewById(R.id.bnb)).inflate();
            }
            this.kS.removeAllViews();
            this.kS.addView(view);
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.kg;
    }

    public void setTitle(CharSequence charSequence) {
        this.kR.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.iJ != z) {
            this.iJ = z;
            this.kW.sendAccessibilityEvent(this.kR, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.kR.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.kU) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = android.support.v4.graphics.drawable.a.i(drawable).mutate();
                android.support.v4.graphics.drawable.a.a(drawable, this.kT);
            }
            drawable.setBounds(0, 0, this.hC, this.hC);
        } else if (this.kQ) {
            if (this.kV == null) {
                this.kV = f.c(getResources(), R.drawable.ami, getContext().getTheme());
                if (this.kV != null) {
                    this.kV.setBounds(0, 0, this.hC, this.hC);
                }
            }
            drawable = this.kV;
        }
        q.a(this.kR, drawable, null, null, null);
    }

    @Override // android.support.v7.view.menu.p.a
    public final boolean bC() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.kg != null && this.kg.isCheckable() && this.kg.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jV);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.kT = colorStateList;
        this.kU = this.kT != null;
        if (this.kg != null) {
            setIcon(this.kg.getIcon());
        }
    }

    public void setTextAppearance(int i2) {
        q.d(this.kR, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.kR.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.kQ = z;
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIconPadding(int i2) {
        this.kR.setCompoundDrawablePadding(i2);
    }
}
