package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.eol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public final class b extends a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView hbb;
    private boolean qeD = false;
    protected ImageView qlA;
    protected TextView qlt;
    protected TextView qlu;
    protected Button qlv;
    protected LinearLayout qlw;
    protected TextView qlx;
    protected ImageView qly;
    protected View qlz;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxM() {
        AppMethodBeat.i(113893);
        this.hbb = (TextView) this.qlr.findViewById(R.id.api);
        this.qlt = (TextView) this.qlr.findViewById(R.id.apa);
        this.qlu = (TextView) this.qlr.findViewById(R.id.akc);
        this.qlv = (Button) this.qlr.findViewById(R.id.alk);
        this.qlw = (LinearLayout) this.qlr.findViewById(R.id.jnu);
        this.qly = (ImageView) this.qlw.findViewById(R.id.si);
        this.qlz = this.qlr.findViewById(R.id.akq);
        this.qlA = (ImageView) this.qlr.findViewById(R.id.alc);
        this.qlx = (TextView) this.qlr.findViewById(R.id.aoa);
        AppMethodBeat.o(113893);
    }

    private void cxP() {
        AppMethodBeat.i(113895);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qlw.getLayoutParams();
        if (this.pQV.csv()) {
            this.qls.setVisibility(0);
            this.qly.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.v1);
        } else if (this.pQV.csw() && this.qeD) {
            this.qls.setVisibility(8);
            this.qly.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.pQV.csw()) {
            this.qls.setVisibility(0);
            this.qly.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.v1);
        }
        this.qlw.setLayoutParams(layoutParams);
        AppMethodBeat.o(113895);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void EK(int i2) {
        AppMethodBeat.i(113896);
        this.qlw.setBackgroundResource(i2);
        this.qly.setVisibility(8);
        if (i2 == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qlw.getLayoutParams();
            if (this.pQV.csv()) {
                this.qls.setVisibility(8);
                layoutParams.topMargin = 0;
                this.qly.setVisibility(0);
                n.a(this.qly, this.pQV.csQ().iwv, this.mContext.getResources().getDimensionPixelSize(R.dimen.uv), (int) R.drawable.ci4, false);
            } else if (this.pQV.csw() && this.qeD) {
                this.qls.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.qlw.setLayoutParams(layoutParams);
            this.qlw.invalidate();
        } else {
            cxP();
        }
        cxQ();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.qlz.getLayoutParams();
        if (i2 == 0) {
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
        } else {
            layoutParams2.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.r);
            layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.r);
        }
        this.qlz.setLayoutParams(layoutParams2);
        this.qlz.invalidate();
        this.qlr.invalidate();
        AppMethodBeat.o(113896);
    }

    private void cxQ() {
        AppMethodBeat.i(113897);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qlv.getLayoutParams();
        if (this.pQV.csR().Lcz != null && !TextUtils.isEmpty(this.pQV.csR().Lcz.pRZ)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ir);
        } else if (this.pQV.csR().LcA != null && !TextUtils.isEmpty(this.pQV.csR().LcA.pRY)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ir);
        } else if (this.pQV.csQ().LeC == null || this.pQV.csQ().LeC.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.hv);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ir);
        }
        this.qlv.setLayoutParams(layoutParams);
        AppMethodBeat.o(113897);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(113898);
        super.setOnClickListener(onClickListener);
        if (this.qlv != null) {
            this.qlv.setOnClickListener(onClickListener);
        }
        if (this.qlA != null) {
            this.qlA.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(113898);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void H(boolean z, boolean z2) {
        AppMethodBeat.i(113899);
        if (this.qlv != null) {
            abz abz = this.pQV.csR().LcA;
            if (abz != null && !TextUtils.isEmpty(abz.title) && abz.LfD != 0 && this.pQV.csM()) {
                this.qlv.setClickable(false);
                this.qlv.setVisibility(0);
                this.qlA.setVisibility(8);
                AppMethodBeat.o(113899);
                return;
            } else if (this.pQV.csR().Lcz != null && !TextUtils.isEmpty(this.pQV.csR().Lcz.title) && !TextUtils.isEmpty(this.pQV.csR().Lcz.url) && this.pQV.csM()) {
                this.qlv.setVisibility(0);
                this.qlv.setEnabled(true);
                if (TextUtils.isEmpty(this.pQV.csR().code) || this.pQV.csR().Lcr == 0) {
                    this.qlA.setVisibility(8);
                    AppMethodBeat.o(113899);
                    return;
                }
                this.qlA.setVisibility(0);
                AppMethodBeat.o(113899);
                return;
            } else if (z && !TextUtils.isEmpty(this.pQV.csR().code) && this.pQV.csM()) {
                this.qlv.setVisibility(0);
                this.qlv.setEnabled(z2);
                this.qlA.setVisibility(8);
                AppMethodBeat.o(113899);
                return;
            } else if (!z || this.pQV.csM()) {
                this.qlv.setVisibility(8);
                this.qlA.setVisibility(8);
            } else {
                this.qlv.setVisibility(0);
                this.qlv.setEnabled(false);
                this.qlA.setVisibility(8);
                AppMethodBeat.o(113899);
                return;
            }
        }
        AppMethodBeat.o(113899);
    }

    public final void cvI() {
        AppMethodBeat.i(113900);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qlw.getLayoutParams();
        if (this.pQV.csw()) {
            this.qls.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.v1);
        }
        this.qlw.setLayoutParams(layoutParams);
        this.qlw.invalidate();
        AppMethodBeat.o(113900);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void kE(boolean z) {
        AppMethodBeat.i(113901);
        this.qeD = z;
        if (z) {
            this.qlz.setVisibility(0);
            AppMethodBeat.o(113901);
            return;
        }
        this.qlz.setVisibility(8);
        AppMethodBeat.o(113901);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxN() {
        AppMethodBeat.i(113894);
        if (this.pQV.csQ().LeC != null && this.pQV.csQ().LeC.size() > 0) {
            abz abz = this.pQV.csQ().LeC.get(0);
            if (!Util.isNullOrNil(abz.title)) {
                this.hbb.setText(abz.title);
            }
            if (!Util.isNullOrNil(abz.pRY)) {
                this.qlt.setText(abz.pRY);
                this.qlt.setVisibility(0);
            } else {
                this.qlt.setVisibility(8);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qlt.getLayoutParams();
            if (!Util.isNullOrNil(abz.pRZ)) {
                this.qlu.setText(abz.pRZ);
                this.qlu.setVisibility(0);
                layoutParams.bottomMargin = 0;
            } else {
                this.qlu.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.hv);
            }
            this.qlt.setLayoutParams(layoutParams);
            this.qlt.invalidate();
        }
        if (this.qlv == null || this.qlA == null) {
            Log.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.pQV.csR() == null) {
            Log.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.qlv.setVisibility(8);
            this.qlA.setVisibility(8);
        } else {
            if (this.pQV.csR().Lcz != null) {
                Log.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.pQV.csR().Lcz.title);
                Log.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.pQV.csR().Lcz.url);
                Log.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.pQV.csR().Lcz.pRZ);
            }
            abz abz2 = this.pQV.csR().LcA;
            if (abz2 != null) {
                Log.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + abz2.title);
                Log.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + abz2.LfD);
                Log.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + abz2.pRZ);
            }
            eol eol = this.pQV.csQ().LeT;
            LinearLayout linearLayout = (LinearLayout) this.qlw.findViewById(R.id.aly);
            if (eol == null || Util.isNullOrNil(eol.Nmm)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator<abz> it = eol.Nmm.iterator();
                while (it.hasNext()) {
                    abz next = it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.mm, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.am1)).setText(next.title);
                    ((TextView) inflate.findViewById(R.id.alx)).setText(next.pRY);
                    linearLayout.addView(inflate);
                }
            }
            if (abz2 != null && !TextUtils.isEmpty(abz2.title) && abz2.LfD != 0 && this.pQV.csM()) {
                this.qlv.setClickable(false);
                this.qlv.setVisibility(0);
                this.qlv.setTextColor(this.mContext.getResources().getColor(R.color.ag5));
                this.qlv.setText(abz2.title);
                if (abz2 == null || TextUtils.isEmpty(abz2.pRY)) {
                    this.qlx.setVisibility(8);
                } else {
                    this.qlx.setText(abz2.pRY);
                    this.qlx.setVisibility(0);
                }
                this.qlA.setVisibility(8);
                if ((abz2.LfD & 2) > 0) {
                    this.qlv.setBackgroundDrawable(l.U(this.mContext, l.convertStringToRGB(this.pQV.csQ().ixw, 150)));
                    this.qlx.setTextColor(l.ake(this.pQV.csQ().ixw));
                } else if ((abz2.LfD & 4) > 0) {
                    this.qlv.setBackgroundDrawable(l.U(this.mContext, this.mContext.getResources().getColor(R.color.wt)));
                    this.qlx.setTextColor(this.mContext.getResources().getColor(R.color.a2t));
                } else {
                    this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
                    this.qlx.setTextColor(this.mContext.getResources().getColor(R.color.a2t));
                }
            } else if (this.pQV.csR().Lcz != null && !TextUtils.isEmpty(this.pQV.csR().Lcz.title) && !TextUtils.isEmpty(this.pQV.csR().Lcz.url) && this.pQV.csM()) {
                this.qlv.setClickable(true);
                this.qlv.setVisibility(0);
                this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
                this.qlv.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
                this.qlv.setText(this.pQV.csR().Lcz.title);
                if (this.pQV.csR().Lcz == null || TextUtils.isEmpty(this.pQV.csR().Lcz.pRZ)) {
                    this.qlx.setVisibility(8);
                } else {
                    this.qlx.setTextColor(this.mContext.getResources().getColor(R.color.a2t));
                    this.qlx.setText(this.pQV.csR().Lcz.pRZ);
                    this.qlx.setVisibility(0);
                }
                if (!TextUtils.isEmpty(this.pQV.csR().code)) {
                    this.qlA.setVisibility(0);
                } else {
                    this.qlA.setVisibility(8);
                }
            } else if (!TextUtils.isEmpty(this.pQV.csR().code) && this.pQV.csM()) {
                Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.qlA.setVisibility(8);
                this.qlx.setVisibility(8);
                this.qlv.setClickable(true);
                this.qlv.setVisibility(0);
                this.qlv.setBackgroundDrawable(l.U(this.mContext, l.ake(this.pQV.csQ().ixw)));
                this.qlv.setTextColor(this.mContext.getResources().getColorStateList(R.color.ag5));
                this.qlv.setText(R.string.ata);
            } else if (!this.pQV.csM()) {
                Log.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.pQV.csR().status);
                this.qlA.setVisibility(8);
                this.qlx.setVisibility(8);
                this.qlv.setClickable(true);
                this.qlv.setVisibility(0);
                this.qlv.setTextColor(this.mContext.getResources().getColor(R.color.tx));
                this.qlv.setBackgroundDrawable(l.U(this.mContext, this.mContext.getResources().getColor(R.color.hi)));
                if (!TextUtils.isEmpty(this.pQV.csQ().LeY)) {
                    this.qlv.setText(this.pQV.csQ().LeY);
                } else {
                    n.h(this.qlv, this.pQV.csR().status);
                }
            } else {
                Log.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.qlv.setVisibility(8);
                this.qlx.setVisibility(8);
                this.qlA.setVisibility(8);
            }
        }
        cxP();
        this.qlw.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.c2n));
        cxQ();
        this.qlr.invalidate();
        AppMethodBeat.o(113894);
    }
}
