package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Util;

public class IconMsgPreference extends Preference {
    private String Bgn;
    private int CZk;
    private int CZl;
    private int OXO;
    private int OXP;
    private int OXQ;
    private ImageView OXR;
    private ViewGroup OXS;
    private TextView OXT;
    private String OXU;
    private Context context;
    private Drawable drawable;
    private int height;

    public IconMsgPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public IconMsgPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(142540);
        this.Bgn = "";
        this.CZk = -1;
        this.CZl = 8;
        this.OXO = 8;
        this.OXP = 0;
        this.OXQ = 8;
        this.OXR = null;
        this.OXS = null;
        this.height = -1;
        this.OXU = "";
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142540);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142541);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_2, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(R.dimen.k4));
        AppMethodBeat.o(142541);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142542);
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dvz);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.aeN != 0) {
                imageView.setImageResource(this.aeN);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
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
        this.OXR = (ImageView) view.findViewById(R.id.ikj);
        this.OXR.setVisibility(this.OXO);
        this.OXS = (ViewGroup) view.findViewById(R.id.h7f);
        this.OXS.setVisibility(this.OXP);
        this.OXT = (TextView) view.findViewById(16908310);
        TextView textView2 = (TextView) view.findViewById(R.id.ikr);
        if (Util.isNullOrNil(this.OXU)) {
            textView2.setVisibility(8);
            AppMethodBeat.o(142542);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(this.OXU);
        AppMethodBeat.o(142542);
    }
}
