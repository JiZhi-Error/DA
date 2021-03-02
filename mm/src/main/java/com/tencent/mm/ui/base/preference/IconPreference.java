package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.at;

public class IconPreference extends Preference {
    private String Bgn;
    private String Bgo;
    private int CZk;
    private int CZl;
    private Bitmap OBX;
    private int OXO;
    private int OXP;
    private int OXQ;
    private ImageView OXR;
    private ViewGroup OXS;
    private TextView OXT;
    protected Drawable OXV;
    RelativeLayout.LayoutParams OXW;
    private int OXX;
    private int OXY;
    private int OXZ;
    private int OYa;
    private int OYb;
    private int OYc;
    private View OYd;
    private View OYe;
    private TextView OYf;
    private TextView OYg;
    protected ImageView OYh;
    public boolean OYi;
    private boolean OYj;
    private boolean OYk;
    public boolean OYl;
    private int OYm;
    public boolean OYn;
    public boolean OYo;
    private boolean OYp;
    protected int OxP;
    private Context context;
    private String desc;
    public Drawable drawable;
    private TextView hPW;
    private int height;
    protected View mView;
    protected ImageView zkw;

    public IconPreference(Context context2) {
        this(context2, null);
    }

    public IconPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public IconPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(142543);
        this.OxP = -1;
        this.zkw = null;
        this.Bgn = "";
        this.CZk = -1;
        this.CZl = 8;
        this.OXO = 8;
        this.OXX = 8;
        this.desc = "";
        this.Bgo = "";
        this.OXY = -1;
        this.OXZ = 8;
        this.OYa = -1;
        this.OBX = null;
        this.OYb = 8;
        this.OXP = 0;
        this.OXQ = 8;
        this.OYc = 8;
        this.OXR = null;
        this.OXS = null;
        this.OYd = null;
        this.OYe = null;
        this.height = -1;
        this.OYk = false;
        this.OYl = false;
        this.OYm = -1;
        this.OYn = false;
        this.OYo = false;
        this.OYp = false;
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142543);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142544);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b99, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(142544);
        return view;
    }

    public final void gY(String str, int i2) {
        this.Bgn = str;
        this.CZk = i2;
    }

    public final void gZ(String str, int i2) {
        AppMethodBeat.i(142545);
        aS(str, i2, this.OYa);
        AppMethodBeat.o(142545);
    }

    public final void setDesc(String str) {
        AppMethodBeat.i(142546);
        this.desc = str;
        if (this.hPW != null) {
            this.hPW.setText(str);
        }
        AppMethodBeat.o(142546);
    }

    public final void aS(String str, int i2, int i3) {
        AppMethodBeat.i(142547);
        this.Bgo = str;
        this.OXY = i2;
        this.OYa = i3;
        if (this.OYf != null) {
            this.OYf.setText(str);
            if (i2 != -1) {
                this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(i2));
            }
            if (i3 != -1) {
                this.OYf.setTextColor(i3);
            }
        }
        AppMethodBeat.o(142547);
    }

    public final void alD(int i2) {
        AppMethodBeat.i(142548);
        this.CZl = i2;
        if (this.OYg != null) {
            this.OYg.setVisibility(i2);
        }
        AppMethodBeat.o(142548);
    }

    public final void alE(int i2) {
        AppMethodBeat.i(142549);
        this.OXZ = i2;
        if (this.OYf != null) {
            this.OYf.setVisibility(i2);
        }
        AppMethodBeat.o(142549);
    }

    public final void gLF() {
        AppMethodBeat.i(142550);
        this.OXX = 0;
        if (this.hPW != null) {
            this.hPW.setVisibility(0);
        }
        AppMethodBeat.o(142550);
    }

    public final void BB(boolean z) {
        AppMethodBeat.i(142551);
        this.OYk = z;
        if (this.OYf != null) {
            if (z) {
                this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.b1a, 0);
                this.OYf.setCompoundDrawablePadding((int) this.context.getResources().getDimension(R.dimen.k5));
                AppMethodBeat.o(142551);
                return;
            }
            this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        AppMethodBeat.o(142551);
    }

    public final void alF(int i2) {
        AppMethodBeat.i(142552);
        this.OXO = i2;
        if (this.OXR != null) {
            this.OXR.setVisibility(i2);
        }
        AppMethodBeat.o(142552);
    }

    public final void la(int i2, int i3) {
        this.OXO = i2;
        this.OYm = i3;
    }

    public final void aL(Bitmap bitmap) {
        AppMethodBeat.i(142553);
        this.OBX = bitmap;
        this.OxP = -1;
        this.OXV = null;
        if (this.zkw != null) {
            this.zkw.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(142553);
    }

    public final void alG(int i2) {
        AppMethodBeat.i(142554);
        this.OxP = i2;
        this.OBX = null;
        if (this.zkw != null) {
            this.zkw.setImageResource(i2);
        }
        AppMethodBeat.o(142554);
    }

    public final void D(Drawable drawable2) {
        AppMethodBeat.i(182566);
        this.OXV = drawable2;
        this.OBX = null;
        this.OxP = -1;
        if (this.zkw != null) {
            this.zkw.setImageDrawable(drawable2);
        }
        AppMethodBeat.o(182566);
    }

    public final void alH(int i2) {
        AppMethodBeat.i(142555);
        this.OYb = i2;
        if (this.zkw != null) {
            this.zkw.setVisibility(this.OYb);
        }
        AppMethodBeat.o(142555);
    }

    public final void alI(int i2) {
        AppMethodBeat.i(142556);
        this.OXP = i2;
        if (this.OXS != null) {
            this.OXS.setVisibility(this.OXP);
        }
        AppMethodBeat.o(142556);
    }

    public final void alJ(int i2) {
        AppMethodBeat.i(142557);
        this.OXQ = i2;
        if (this.OYd != null) {
            this.OYd.setVisibility(this.OXQ);
        }
        AppMethodBeat.o(142557);
    }

    public final void lb(int i2, int i3) {
        AppMethodBeat.i(142558);
        this.OXW = new RelativeLayout.LayoutParams(i2, i3);
        this.OXW.addRule(13);
        if (this.zkw == null) {
            AppMethodBeat.o(142558);
            return;
        }
        this.zkw.setLayoutParams(this.OXW);
        AppMethodBeat.o(142558);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public void onBindView(View view) {
        boolean z;
        AppMethodBeat.i(142559);
        super.onBindView(view);
        this.OYh = (ImageView) view.findViewById(R.id.dvz);
        if (this.OYh != null) {
            if (this.drawable != null) {
                this.OYh.setImageDrawable(this.drawable);
                this.OYh.setVisibility(0);
            } else if (this.aeN != 0) {
                ImageView imageView = this.OYh;
                Drawable drawable2 = this.mContext.getResources().getDrawable(this.aeN);
                this.drawable = drawable2;
                imageView.setImageDrawable(drawable2);
                this.OYh.setVisibility(0);
            } else {
                this.OYh.setVisibility(8);
            }
            if (this.Kxl != 0) {
                this.OYh.getDrawable().setColorFilter(this.Kxl, PorterDuff.Mode.SRC_ATOP);
            } else if (this.OYh.getDrawable() != null) {
                this.OYh.getDrawable().clearColorFilter();
            }
            if (this.OYi) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.OYh.getLayoutParams();
                layoutParams.topMargin = at.aH(this.mContext, R.dimen.cb);
                layoutParams.gravity = 48;
                this.OYh.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.OYh.getLayoutParams();
                layoutParams2.topMargin = 0;
                layoutParams2.gravity = 16;
                this.OYh.setLayoutParams(layoutParams2);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fg1);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(R.dimen.i0));
        if (this.OYj) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.h7_);
            if (linearLayout2 != null) {
                linearLayout2.setPadding(0, 0, 0, 0);
            }
            if (!(linearLayout.getParent() == null || linearLayout.getParent().getParent() == null || !(linearLayout.getParent().getParent() instanceof LinearLayout))) {
                ((LinearLayout) linearLayout.getParent().getParent()).setPadding(0, 0, 0, 0);
            }
        }
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        this.OYg = (TextView) view.findViewById(R.id.ikq);
        if (this.OYg != null) {
            if (this.OYl) {
                this.OYg.setCompoundDrawablesWithIntrinsicBounds(R.drawable.b1a, 0, 0, 0);
                this.OYg.setCompoundDrawablePadding((int) this.context.getResources().getDimension(R.dimen.k5));
            } else {
                this.OYg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.OYg.setVisibility(this.CZl);
            this.OYg.setText(this.Bgn);
            if (this.CZk != -1) {
                this.OYg.setBackgroundDrawable(this.context.getResources().getDrawable(this.CZk));
            }
        }
        this.OYf = (TextView) view.findViewById(this.OYo ? R.id.ikr : R.id.iks);
        if (this.OYf != null) {
            this.OYf.setVisibility(this.OXZ);
            this.OYf.setText(this.Bgo);
            if (this.OXY != -1) {
                this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(this.OXY));
                if (this.OXY == R.drawable.amr) {
                    this.OYf.setTextSize(0, ((float) a.aH(this.context, R.dimen.anf)) * a.ji(this.context));
                }
            }
            if (this.OYa != -1) {
                this.OYf.setTextColor(this.OYa);
            }
            if (this.OYk) {
                this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.b1a, 0);
                this.OYf.setCompoundDrawablePadding((int) this.context.getResources().getDimension(R.dimen.k5));
            } else {
                this.OYf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        this.OXR = (ImageView) view.findViewById(R.id.ikj);
        this.OXR.setVisibility(this.OXO);
        if (this.OYm != -1) {
            this.OXR.setImageResource(this.OYm);
        }
        this.zkw = (ImageView) view.findViewById(R.id.dwk);
        this.OXS = (ViewGroup) view.findViewById(R.id.h7f);
        this.OYe = view.findViewById(R.id.h72);
        this.OYe.setVisibility(this.OYc);
        this.OYd = view.findViewById(R.id.h7d);
        this.OYd.setVisibility(this.OXQ);
        if (this.OBX != null) {
            this.zkw.setImageBitmap(this.OBX);
        } else if (this.OxP != -1) {
            this.zkw.setImageResource(this.OxP);
        } else if (this.OXV != null) {
            this.zkw.setImageDrawable(this.OXV);
        }
        this.zkw.setVisibility(this.OYb);
        this.OXS.setVisibility(this.OXP);
        if (this.OXW != null) {
            this.zkw.setLayoutParams(this.OXW);
        }
        this.OXT = (TextView) view.findViewById(16908310);
        this.hPW = (TextView) view.findViewById(R.id.bmr);
        if (this.hPW != null) {
            this.hPW.setVisibility(this.OXX);
            this.hPW.setText(this.desc);
            if (this.OYn) {
                this.hPW.setTextColor(this.context.getResources().getColor(R.color.m5));
            } else {
                this.hPW.setTextColor(this.context.getResources().getColor(R.color.l4));
            }
        }
        if (this.OXT != null) {
            if (this.OYn) {
                this.OXT.setTextColor(this.context.getResources().getColor(R.color.m5));
            } else {
                this.OXT.setTextColor(this.context.getResources().getColor(R.color.FG_0));
            }
        }
        if (!this.OYn) {
            z = true;
        } else {
            z = false;
        }
        view.setEnabled(z);
        if (this.OYp && this.OXT != null) {
            this.OXT.setTextColor(this.OXT.getResources().getColor(R.color.m5));
        }
        AppMethodBeat.o(142559);
    }

    public final ImageView gLG() {
        return this.zkw;
    }
}
