package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class a implements g {
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected View.OnClickListener kuO;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected TextView oeJ;
    protected b pQV;
    protected View qlr;
    protected ImageView qls;

    /* access modifiers changed from: protected */
    public abstract void cxM();

    /* access modifiers changed from: protected */
    public abstract void cxN();

    public a(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public final void i(b bVar) {
        this.pQV = bVar;
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public final View jz() {
        int i2;
        if (this.pQV == null || this.pQV.csQ() == null) {
            Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.mInflater;
        if (!this.pQV.csy()) {
            if (this.pQV.csz()) {
                i2 = R.layout.p5;
            } else if (this.pQV.csx()) {
                i2 = R.layout.o4;
            } else if (this.pQV.csA()) {
                i2 = R.layout.mr;
            } else if (this.pQV.csB()) {
                i2 = R.layout.nt;
            }
            this.qlr = layoutInflater.inflate(i2, (ViewGroup) null);
            this.qls = (ImageView) this.qlr.findViewById(R.id.s4);
            this.oeJ = (TextView) this.qlr.findViewById(R.id.s_);
            cxM();
            refreshView();
            return this.qlr;
        }
        i2 = R.layout.mi;
        this.qlr = layoutInflater.inflate(i2, (ViewGroup) null);
        this.qls = (ImageView) this.qlr.findViewById(R.id.s4);
        this.oeJ = (TextView) this.qlr.findViewById(R.id.s_);
        cxM();
        refreshView();
        return this.qlr;
    }

    private void refreshView() {
        if (this.pQV == null || this.pQV.csQ() == null) {
            Log.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        cxO();
        cxN();
    }

    /* access modifiers changed from: protected */
    public final View cxL() {
        return this.qlr;
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public final void release() {
        this.kuO = null;
        this.mContext = null;
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void EK(int i2) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void kD(boolean z) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public final void d(b bVar) {
        this.pQV = bVar;
        refreshView();
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void a(ShapeDrawable shapeDrawable) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void kE(boolean z) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void H(boolean z, boolean z2) {
    }

    @Override // com.tencent.mm.plugin.card.widget.g
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kuO = onClickListener;
    }

    private void cxO() {
        if (!Util.isNullOrNil(this.pQV.csQ().iwv)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.v4);
            if (this.pQV.csv() && this.pQV.csy()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.v2);
            } else if (this.pQV.csv() && this.pQV.csx()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.vr);
            } else if (this.pQV.csv() && this.pQV.csz()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.w3);
            } else if (this.pQV.csB()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                n.a(this.qls, this.pQV.csQ().iwv, dimensionPixelSize, (int) R.drawable.ci4, true);
            }
        }
        if (!Util.isNullOrNil(this.pQV.csQ().gTG)) {
            this.oeJ.setText(this.pQV.csQ().gTG);
        }
    }
}
