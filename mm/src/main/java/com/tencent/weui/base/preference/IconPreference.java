package com.tencent.weui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class IconPreference extends Preference {
    private String Bgn;
    private String Bgo;
    private int CZk;
    private int CZl;
    private ImageView EbJ;
    private Bitmap OBX;
    private int OXO;
    private int OXP;
    private int OXQ;
    private ImageView OXR;
    private ViewGroup OXS;
    private TextView OXT;
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
    private ImageView OYh;
    private boolean OYk;
    private boolean OYl;
    private int OYm;
    private boolean OYn;
    private int OZz;
    protected int OxP;
    private Context context;
    private String desc;
    private Drawable drawable;
    private TextView hPW;
    private int height;
    protected ImageView zkw;

    public IconPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public IconPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(159990);
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
        this.OXP = 8;
        this.OXQ = 8;
        this.OYc = 8;
        this.OZz = 0;
        this.OXR = null;
        this.OXS = null;
        this.OYd = null;
        this.OYe = null;
        this.EbJ = null;
        this.height = -1;
        this.OYk = false;
        this.OYl = false;
        this.OYm = -1;
        this.OYn = false;
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(159990);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(159991);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.bil, viewGroup2);
        AppMethodBeat.o(159991);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        boolean z;
        AppMethodBeat.i(159992);
        super.onBindView(view);
        this.OYh = (ImageView) view.findViewById(R.id.dvz);
        if (this.OYh != null) {
            if (this.drawable != null) {
                this.OYh.setImageDrawable(this.drawable);
                this.OYh.setVisibility(0);
            } else if (getIcon() != null) {
                ImageView imageView = this.OYh;
                Drawable icon = getIcon();
                this.drawable = icon;
                imageView.setImageDrawable(icon);
                this.OYh.setVisibility(0);
            } else {
                this.OYh.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fg1);
        linearLayout.setMinimumHeight(view.getResources().getDimensionPixelSize(R.dimen.k4));
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
        this.OYf = (TextView) view.findViewById(R.id.iks);
        if (this.OYf != null) {
            this.OYf.setVisibility(this.OXZ);
            this.OYf.setText(this.Bgo);
            if (this.OXY != -1) {
                this.OYf.setBackgroundDrawable(this.context.getResources().getDrawable(this.OXY));
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
        this.EbJ = (ImageView) view.findViewById(R.id.h6o);
        this.EbJ.setVisibility(this.OZz);
        if (this.OBX != null) {
            this.zkw.setImageBitmap(this.OBX);
        } else if (this.OxP != -1) {
            this.zkw.setImageResource(this.OxP);
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
                this.hPW.setTextColor(this.context.getResources().getColor(R.color.uj));
            }
        }
        if (this.OXT != null) {
            if (this.OYn) {
                this.OXT.setTextColor(this.context.getResources().getColor(R.color.m5));
            } else {
                this.OXT.setTextColor(this.context.getResources().getColor(R.color.a2x));
            }
        }
        if (!this.OYn) {
            z = true;
        } else {
            z = false;
        }
        view.setEnabled(z);
        AppMethodBeat.o(159992);
    }
}
