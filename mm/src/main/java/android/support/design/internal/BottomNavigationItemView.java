package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.r;
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class BottomNavigationItemView extends FrameLayout implements p.a {
    private static final int[] jV = {16842912};
    private ColorStateList hB;
    private final int jW;
    private float jX;
    private float jY;
    private float jZ;
    private int ka;
    private boolean kb;
    private ImageView kc;
    private final TextView kd;
    private final TextView ke;
    private int kf;
    private j kg;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.kf = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(R.layout.z8, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.rj);
        this.jW = resources.getDimensionPixelSize(R.dimen.z2);
        this.kc = (ImageView) findViewById(R.id.dt5);
        this.kd = (TextView) findViewById(R.id.hso);
        this.ke = (TextView) findViewById(R.id.e7p);
        u.p(this.kd, 2);
        u.p(this.ke, 2);
        setFocusable(true);
        b(this.kd.getTextSize(), this.ke.getTextSize());
    }

    @Override // android.support.v7.view.menu.p.a
    public final void a(j jVar) {
        this.kg = jVar;
        setCheckable(jVar.isCheckable());
        setChecked(jVar.isChecked());
        setEnabled(jVar.isEnabled());
        setIcon(jVar.getIcon());
        setTitle(jVar.getTitle());
        setId(jVar.getItemId());
        if (!TextUtils.isEmpty(jVar.getContentDescription())) {
            setContentDescription(jVar.getContentDescription());
        }
        bb.a(this, jVar.getTooltipText());
        setVisibility(jVar.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int i2) {
        this.kf = i2;
    }

    public int getItemPosition() {
        return this.kf;
    }

    public void setShifting(boolean z) {
        if (this.kb != z) {
            this.kb = z;
            if (this.kg != null) {
                setChecked(this.kg.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.ka != i2) {
            this.ka = i2;
            if (this.kg != null) {
                setChecked(this.kg.isChecked());
            }
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.kg;
    }

    public void setTitle(CharSequence charSequence) {
        this.kd.setText(charSequence);
        this.ke.setText(charSequence);
        if (this.kg == null || TextUtils.isEmpty(this.kg.getContentDescription())) {
            setContentDescription(charSequence);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.ke.setPivotX((float) (this.ke.getWidth() / 2));
        this.ke.setPivotY((float) this.ke.getBaseline());
        this.kd.setPivotX((float) (this.kd.getWidth() / 2));
        this.kd.setPivotY((float) this.kd.getBaseline());
        switch (this.ka) {
            case -1:
                if (!this.kb) {
                    if (!z) {
                        a(this.kc, this.jW, 49);
                        a(this.ke, this.jZ, this.jZ, 4);
                        a(this.kd, 1.0f, 1.0f, 0);
                        break;
                    } else {
                        a(this.kc, (int) (((float) this.jW) + this.jX), 49);
                        a(this.ke, 1.0f, 1.0f, 0);
                        a(this.kd, this.jY, this.jY, 4);
                        break;
                    }
                } else {
                    if (z) {
                        a(this.kc, this.jW, 49);
                        a(this.ke, 1.0f, 1.0f, 0);
                    } else {
                        a(this.kc, this.jW, 17);
                        a(this.ke, 0.5f, 0.5f, 4);
                    }
                    this.kd.setVisibility(4);
                    break;
                }
            case 0:
                if (z) {
                    a(this.kc, this.jW, 49);
                    a(this.ke, 1.0f, 1.0f, 0);
                } else {
                    a(this.kc, this.jW, 17);
                    a(this.ke, 0.5f, 0.5f, 4);
                }
                this.kd.setVisibility(4);
                break;
            case 1:
                if (!z) {
                    a(this.kc, this.jW, 49);
                    a(this.ke, this.jZ, this.jZ, 4);
                    a(this.kd, 1.0f, 1.0f, 0);
                    break;
                } else {
                    a(this.kc, (int) (((float) this.jW) + this.jX), 49);
                    a(this.ke, 1.0f, 1.0f, 0);
                    a(this.kd, this.jY, this.jY, 4);
                    break;
                }
            case 2:
                a(this.kc, this.jW, 17);
                this.ke.setVisibility(8);
                this.kd.setVisibility(8);
                break;
        }
        refreshDrawableState();
        setSelected(z);
    }

    private static void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private static void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.kd.setEnabled(z);
        this.ke.setEnabled(z);
        this.kc.setEnabled(z);
        if (z) {
            u.a(this, r.Y(getContext()));
        } else {
            u.a(this, (r) null);
        }
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (this.kg != null && this.kg.isCheckable() && this.kg.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jV);
        }
        return onCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = a.i(drawable).mutate();
            a.a(drawable, this.hB);
        }
        this.kc.setImageDrawable(drawable);
    }

    @Override // android.support.v7.view.menu.p.a
    public final boolean bC() {
        return false;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.hB = colorStateList;
        if (this.kg != null) {
            setIcon(this.kg.getIcon());
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.kc.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.kc.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int i2) {
        q.d(this.kd, i2);
        b(this.kd.getTextSize(), this.ke.getTextSize());
    }

    public void setTextAppearanceActive(int i2) {
        q.d(this.ke, i2);
        b(this.kd.getTextSize(), this.ke.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.kd.setTextColor(colorStateList);
            this.ke.setTextColor(colorStateList);
        }
    }

    private void b(float f2, float f3) {
        this.jX = f2 - f3;
        this.jY = (1.0f * f3) / f2;
        this.jZ = (1.0f * f2) / f3;
    }

    public void setItemBackground(int i2) {
        Drawable l;
        if (i2 == 0) {
            l = null;
        } else {
            l = b.l(getContext(), i2);
        }
        setItemBackground(l);
    }

    public void setItemBackground(Drawable drawable) {
        u.a(this, drawable);
    }
}
