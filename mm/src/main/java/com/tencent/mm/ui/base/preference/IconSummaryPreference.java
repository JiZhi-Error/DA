package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

public class IconSummaryPreference extends Preference {
    private String Bgn;
    private int CZk;
    public int CZl;
    private Bitmap OBX;
    private int OXP;
    private int OXQ;
    private ViewGroup OXS;
    RelativeLayout.LayoutParams OXW;
    private int OYb;
    private View OYd;
    private int OYq;
    private TextView OYr;
    private int OYs;
    private int OxP;
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView zkw;

    public IconSummaryPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public IconSummaryPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(142560);
        this.Bgn = "";
        this.CZk = -1;
        this.CZl = 8;
        this.OBX = null;
        this.OxP = -1;
        this.OYb = 8;
        this.OXP = 0;
        this.OXQ = 8;
        this.OYq = 8;
        this.zkw = null;
        this.OXS = null;
        this.OYd = null;
        this.OYr = null;
        this.OYs = -1;
        this.height = -1;
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142560);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142561);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b9_, viewGroup2);
        AppMethodBeat.o(142561);
        return onCreateView;
    }

    public final void bmk(String str) {
        this.Bgn = str;
        this.CZk = R.drawable.amr;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void setSummary(CharSequence charSequence) {
        AppMethodBeat.i(142562);
        super.setSummary(charSequence);
        if (!(this.OYr == null || getSummary() == null || getSummary().length() <= 0)) {
            this.OYr.setText(getSummary());
        }
        AppMethodBeat.o(142562);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void setSummary(int i2) {
        AppMethodBeat.i(142563);
        super.setSummary(i2);
        if (!(this.OYr == null || getSummary() == null || getSummary().length() <= 0)) {
            this.OYr.setText(getSummary());
        }
        AppMethodBeat.o(142563);
    }

    public final void gLH() {
        AppMethodBeat.i(142564);
        this.OYq = 0;
        if (this.OYr != null) {
            this.OYr.setVisibility(this.OYq);
        }
        AppMethodBeat.o(142564);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142565);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dvz);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.Xw != null) {
                imageView.setImageDrawable(this.Xw);
                imageView.setVisibility(0);
            } else if (this.aeN != 0) {
                imageView.setImageResource(this.aeN);
                imageView.setVisibility(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fg1);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(R.id.ikq);
        if (textView != null) {
            textView.setVisibility(this.CZl);
            textView.setText(this.Bgn);
            if (this.CZk != -1) {
                textView.setBackgroundDrawable(a.l(this.context, this.CZk));
            }
        }
        if (this.zkw == null) {
            this.zkw = (ImageView) view.findViewById(R.id.dwk);
        }
        if (this.OXS == null) {
            this.OXS = (ViewGroup) view.findViewById(R.id.h7f);
        }
        if (this.OYd == null) {
            this.OYd = view.findViewById(R.id.h7d);
        }
        this.OYd.setVisibility(this.OXQ);
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
        this.OYr = (TextView) view.findViewById(R.id.h7m);
        if (!(this.OYr == null || getSummary() == null || getSummary().length() <= 0)) {
            this.OYr.setText(getSummary());
            this.OYr.setVisibility(this.OYq);
        }
        if (!(this.OYr == null || this.OYs == -1)) {
            this.OYr.setCompoundDrawablesWithIntrinsicBounds(this.OYs, 0, 0, 0);
            this.OYr.setCompoundDrawablePadding(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 2.0f));
            this.OYr.setVisibility(this.OYq);
        }
        AppMethodBeat.o(142565);
    }
}
