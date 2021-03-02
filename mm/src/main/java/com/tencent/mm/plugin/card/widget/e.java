package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends a {
    protected TextView jVO;
    private LinearLayout pWO;
    private RelativeLayout qlM;
    private TextView qlN;
    private View qlO;
    private ImageView qlP;
    private ImageView qlQ;
    private ImageView qlR;
    private ImageView qlS;
    private ImageView qlT;

    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxM() {
        AppMethodBeat.i(113906);
        this.jVO = (TextView) cxL().findViewById(R.id.api);
        this.qlM = (RelativeLayout) cxL().findViewById(R.id.ao3);
        this.pWO = (LinearLayout) cxL().findViewById(R.id.ald);
        this.qlN = (TextView) cxL().findViewById(R.id.b5f);
        this.qlO = cxL().findViewById(R.id.alb);
        this.qlP = (ImageView) cxL().findViewById(R.id.alc);
        this.qlQ = (ImageView) this.qlr.findViewById(R.id.fcr);
        this.qlR = (ImageView) this.qlr.findViewById(R.id.fcq);
        this.qlS = (ImageView) this.qlr.findViewById(R.id.ao0);
        this.qlT = (ImageView) this.qlr.findViewById(R.id.ao2);
        AppMethodBeat.o(113906);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxN() {
        AppMethodBeat.i(113907);
        if (this.oeJ != null) {
            this.oeJ.setText(this.pQV.csQ().gTG);
        }
        if (this.pQV.csQ().LeC != null && this.pQV.csQ().LeC.size() > 0) {
            abz abz = this.pQV.csQ().LeC.get(0);
            if (!TextUtils.isEmpty(abz.title)) {
                this.jVO.setText(abz.title);
            } else {
                this.jVO.setText("");
            }
        }
        if (this.pQV.csM()) {
            kD(true);
            this.qlS.setAlpha(255);
            if (this.qlS.getBackground() != null) {
                this.qlS.getBackground().setAlpha(255);
            }
            String str = this.pQV.csR().code;
            if (!TextUtils.isEmpty(str)) {
                this.qlO.setOnClickListener(this.kuO);
                this.qlP.setOnClickListener(this.kuO);
                this.qlN.setOnClickListener(this.kuO);
                switch (this.pQV.csR().Lcr) {
                    case 0:
                        if (str.length() > 40) {
                            this.qlN.setText("");
                            break;
                        } else {
                            this.qlN.setText(n.akl(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.pQV.csF()) {
                                this.qlN.setText("");
                                break;
                            } else {
                                this.qlN.setText(n.akl(str));
                                break;
                            }
                        } else {
                            this.qlN.setText("");
                            break;
                        }
                }
            } else {
                Log.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
                kD(false);
            }
        } else {
            this.qlN.setText("");
            this.qlP.setVisibility(8);
            this.qlO.setVisibility(8);
            this.qlS.setAlpha(90);
            if (this.qlS.getBackground() != null) {
                this.qlS.getBackground().setAlpha(90);
            }
        }
        ViewGroup.LayoutParams layoutParams = this.qlM.getLayoutParams();
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.hv);
        int i2 = this.mContext.getResources().getDisplayMetrics().widthPixels - (dimensionPixelSize * 2);
        int i3 = (i2 * 3) / 5;
        layoutParams.height = i3;
        Log.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", Integer.valueOf(dimensionPixelSize), Integer.valueOf(i2), Integer.valueOf(i3));
        this.qlM.setLayoutParams(layoutParams);
        AppMethodBeat.o(113907);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void H(boolean z, boolean z2) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void kD(boolean z) {
        AppMethodBeat.i(113908);
        if (TextUtils.isEmpty(this.pQV.csR().code) || !z || this.pQV.csR().Lcr == 0 || this.pQV.csQ().Lfi) {
            this.qlP.setVisibility(8);
            this.qlO.setVisibility(8);
            AppMethodBeat.o(113908);
            return;
        }
        this.qlP.setVisibility(0);
        this.qlO.setVisibility(0);
        AppMethodBeat.o(113908);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void EK(int i2) {
        AppMethodBeat.i(113909);
        if (!TextUtils.isEmpty(this.pQV.csR().LcC)) {
            this.qlS.setBackgroundDrawable(null);
            this.qlT.setVisibility(0);
            cxR();
            AppMethodBeat.o(113909);
            return;
        }
        if (this.qlr != null) {
            this.qlS.setBackgroundResource(i2);
            this.qlT.setVisibility(8);
        }
        AppMethodBeat.o(113909);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void a(ShapeDrawable shapeDrawable) {
        AppMethodBeat.i(113910);
        if (!TextUtils.isEmpty(this.pQV.csR().LcC)) {
            this.qlS.setBackgroundDrawable(null);
            this.qlT.setVisibility(0);
            cxR();
            AppMethodBeat.o(113910);
            return;
        }
        if (this.qlr != null) {
            this.qlS.setBackgroundDrawable(shapeDrawable);
            this.qlT.setVisibility(8);
        }
        AppMethodBeat.o(113910);
    }

    private void cxR() {
        AppMethodBeat.i(113912);
        c.a aVar = new c.a();
        aVar.prefixPath = b.aKJ();
        q.bcW();
        aVar.jbw = null;
        aVar.fullPath = m.ajp(this.pQV.csR().LcC);
        aVar.jbf = true;
        aVar.iaT = true;
        aVar.jbx = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.vm);
        aVar.jby = true;
        aVar.jbd = true;
        aVar.jbq = R.drawable.m6;
        aVar.hZA = a.aG(this.mContext, R.dimen.vq);
        aVar.hZz = a.jn(this.mContext);
        q.bcV().a(this.pQV.csR().LcC, this.qlS, aVar.bdv());
        Log.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.pQV.csR().LcC);
        AppMethodBeat.o(113912);
    }

    @Override // com.tencent.mm.plugin.card.widget.g, com.tencent.mm.plugin.card.widget.a
    public final void kE(boolean z) {
        AppMethodBeat.i(113911);
        if (!TextUtils.isEmpty(this.pQV.csR().LcC)) {
            this.qlR.setVisibility(8);
            this.qlQ.setVisibility(8);
            AppMethodBeat.o(113911);
            return;
        }
        this.qlR.setVisibility(0);
        this.qlQ.setVisibility(0);
        AppMethodBeat.o(113911);
    }
}
