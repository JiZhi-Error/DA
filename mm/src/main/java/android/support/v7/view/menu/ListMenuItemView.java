package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.support.v7.view.menu.p;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.R;

public class ListMenuItemView extends LinearLayout implements p.a, AbsListView.SelectionBoundsAdjuster {
    private ImageView Xx;
    private TextView Xy;
    private j aeV;
    private boolean afG;
    private RadioButton afT;
    private CheckBox afU;
    private TextView afV;
    private ImageView afW;
    private ImageView afX;
    private LinearLayout afY;
    private Drawable afZ;
    private int aga;
    private Context agb;
    private boolean agc;
    private Drawable agd;
    private boolean age;
    private int agf;
    private LayoutInflater mInflater;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.s_);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        az a2 = az.a(getContext(), attributeSet, a.C0040a.MenuView, i2, 0);
        this.afZ = a2.getDrawable(5);
        this.aga = a2.getResourceId(1, -1);
        this.agc = a2.getBoolean(7, false);
        this.agb = context;
        this.agd = a2.getDrawable(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.jt, 0);
        this.age = obtainStyledAttributes.hasValue(0);
        a2.ayy.recycle();
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        u.a(this, this.afZ);
        this.Xy = (TextView) findViewById(R.id.ipm);
        if (this.aga != -1) {
            this.Xy.setTextAppearance(this.agb, this.aga);
        }
        this.afV = (TextView) findViewById(R.id.hqo);
        this.afW = (ImageView) findViewById(R.id.idd);
        if (this.afW != null) {
            this.afW.setImageDrawable(this.agd);
        }
        this.afX = (ImageView) findViewById(R.id.dln);
        this.afY = (LinearLayout) findViewById(R.id.be9);
    }

    @Override // android.support.v7.view.menu.p.a
    public final void a(j jVar) {
        String sb;
        int i2 = 0;
        this.aeV = jVar;
        this.agf = 0;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a(this));
        setCheckable(jVar.isCheckable());
        if (!jVar.im() || !this.aeV.im()) {
            i2 = 8;
        }
        if (i2 == 0) {
            TextView textView = this.afV;
            j jVar2 = this.aeV;
            char ik = jVar2.ik();
            if (ik == 0) {
                sb = "";
            } else {
                Resources resources = jVar2.aaQ.mContext.getResources();
                StringBuilder sb2 = new StringBuilder();
                if (ViewConfiguration.get(jVar2.aaQ.mContext).hasPermanentMenuKey()) {
                    sb2.append(resources.getString(R.string.c1));
                }
                int i3 = jVar2.aaQ.hY() ? jVar2.aeL : jVar2.aeJ;
                j.a(sb2, i3, 65536, resources.getString(R.string.bx));
                j.a(sb2, i3, 4096, resources.getString(R.string.bt));
                j.a(sb2, i3, 2, resources.getString(R.string.bs));
                j.a(sb2, i3, 1, resources.getString(R.string.by));
                j.a(sb2, i3, 4, resources.getString(R.string.c0));
                j.a(sb2, i3, 8, resources.getString(R.string.bw));
                switch (ik) {
                    case '\b':
                        sb2.append(resources.getString(R.string.bu));
                        break;
                    case '\n':
                        sb2.append(resources.getString(R.string.bv));
                        break;
                    case ' ':
                        sb2.append(resources.getString(R.string.bz));
                        break;
                    default:
                        sb2.append(ik);
                        break;
                }
                sb = sb2.toString();
            }
            textView.setText(sb);
        }
        if (this.afV.getVisibility() != i2) {
            this.afV.setVisibility(i2);
        }
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    private void A(View view, int i2) {
        if (this.afY != null) {
            this.afY.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.afG = z;
        this.agc = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Xy.setText(charSequence);
            if (this.Xy.getVisibility() != 0) {
                this.Xy.setVisibility(0);
            }
        } else if (this.Xy.getVisibility() != 8) {
            this.Xy.setVisibility(8);
        }
    }

    @Override // android.support.v7.view.menu.p.a
    public j getItemData() {
        return this.aeV;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.afT != null || this.afU != null) {
            if (this.aeV.in()) {
                if (this.afT == null) {
                    hT();
                }
                compoundButton = this.afT;
                compoundButton2 = this.afU;
            } else {
                if (this.afU == null) {
                    hU();
                }
                compoundButton = this.afU;
                compoundButton2 = this.afT;
            }
            if (z) {
                compoundButton.setChecked(this.aeV.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
                    compoundButton2.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.afU != null) {
                this.afU.setVisibility(8);
            }
            if (this.afT != null) {
                this.afT.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.aeV.in()) {
            if (this.afT == null) {
                hT();
            }
            compoundButton = this.afT;
        } else {
            if (this.afU == null) {
                hU();
            }
            compoundButton = this.afU;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.afW != null) {
            this.afW.setVisibility(z ? 0 : 8);
        }
    }

    private void setShortcut$25d965e(boolean z) {
        int i2 = (!z || !this.aeV.im()) ? 8 : 0;
        if (i2 == 0) {
            this.afV.setText(this.aeV.il());
        }
        if (this.afV.getVisibility() != i2) {
            this.afV.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.aeV.aaQ.agE || this.afG;
        if (!z && !this.agc) {
            return;
        }
        if (this.Xx != null || drawable != null || this.agc) {
            if (this.Xx == null) {
                this.Xx = (ImageView) getInflater().inflate(R.layout.aw, (ViewGroup) this, false);
                A(this.Xx, 0);
            }
            if (drawable != null || this.agc) {
                ImageView imageView = this.Xx;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.Xx.getVisibility() != 0) {
                    this.Xx.setVisibility(0);
                    return;
                }
                return;
            }
            this.Xx.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.Xx != null && this.agc) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Xx.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i2, i3);
    }

    private void hT() {
        this.afT = (RadioButton) getInflater().inflate(R.layout.ay, (ViewGroup) this, false);
        A(this.afT, -1);
    }

    private void hU() {
        this.afU = (CheckBox) getInflater().inflate(R.layout.av, (ViewGroup) this, false);
        A(this.afU, -1);
    }

    @Override // android.support.v7.view.menu.p.a
    public final boolean bC() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }

    public void setGroupDividerEnabled(boolean z) {
        if (this.afX != null) {
            this.afX.setVisibility((this.age || !z) ? 8 : 0);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.afX != null && this.afX.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.afX.getLayoutParams();
            rect.top = layoutParams.bottomMargin + this.afX.getHeight() + layoutParams.topMargin + rect.top;
        }
    }
}
