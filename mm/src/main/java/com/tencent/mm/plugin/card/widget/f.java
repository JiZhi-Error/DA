package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public final class f extends a {
    protected TextView jVO;
    public ArrayList<us> pRc;
    private View qlU;
    private ImageView qlV;
    private TextView qlW;
    private TextView qlX;
    private View qlY;
    private TextView qlZ;
    private TextView qma;
    private ImageView qmb;
    private TextView qmc;

    public f(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxM() {
        AppMethodBeat.i(113913);
        this.jVO = (TextView) cxL().findViewById(R.id.api);
        this.qlU = cxL().findViewById(R.id.akq);
        this.qlV = (ImageView) cxL().findViewById(R.id.imi);
        this.qlW = (TextView) cxL().findViewById(R.id.imh);
        this.qlX = (TextView) cxL().findViewById(R.id.img);
        this.qlY = cxL().findViewById(R.id.imk);
        this.qlZ = (TextView) cxL().findViewById(R.id.imm);
        this.qma = (TextView) cxL().findViewById(R.id.iml);
        this.qmb = (ImageView) cxL().findViewById(R.id.imj);
        this.qmc = (TextView) cxL().findViewById(R.id.imf);
        AppMethodBeat.o(113913);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.card.widget.a
    public final void cxN() {
        AppMethodBeat.i(113914);
        if (this.pQV.csQ().Lfc != null && !TextUtils.isEmpty(this.pQV.csQ().Lfc.title)) {
            this.oeJ.setText(this.pQV.csQ().Lfc.title);
        } else if (!TextUtils.isEmpty(this.pQV.csQ().gTG)) {
            this.oeJ.setText(this.pQV.csQ().gTG);
        } else {
            this.oeJ.setText("");
        }
        if (this.pQV.csQ().Lfc == null || TextUtils.isEmpty(this.pQV.csQ().Lfc.pRY)) {
            this.jVO.setText("");
            this.jVO.setVisibility(8);
        } else {
            this.jVO.setText(this.pQV.csQ().Lfc.pRY);
            this.jVO.setVisibility(0);
        }
        Log.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (!Util.isNullOrNil(this.pQV.csQ().LeI)) {
            n.a(this.mContext, this.qlV, this.pQV.csQ().LeI, this.mContext.getResources().getDimensionPixelSize(R.dimen.w3), l.ake(this.pQV.csQ().ixw));
        } else {
            n.b(this.qlV, R.drawable.c2i, l.ake(this.pQV.csQ().ixw));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (this.pQV.csQ().LeC != null && this.pQV.csQ().LeC.size() >= 2) {
            Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            abz abz = this.pQV.csQ().LeC.get(0);
            abz abz2 = this.pQV.csQ().LeC.get(1);
            sb.append(abz.title).append(" - ").append(abz2.title);
            if (!TextUtils.isEmpty(abz.pRZ) && !TextUtils.isEmpty(abz2.pRZ)) {
                sb2.append(abz.pRZ).append(" ").append(abz.pRY);
                sb2.append(" - ");
                sb2.append(abz2.pRZ).append(" ").append(abz2.pRY);
            }
        } else if (this.pQV.csQ().LeC != null && this.pQV.csQ().LeC.size() == 1) {
            Log.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            abz abz3 = this.pQV.csQ().LeC.get(0);
            sb.append(abz3.title);
            sb2.append(abz3.pRY);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            this.qlW.setText(sb.toString());
        } else {
            this.qlW.setText("");
        }
        if (!TextUtils.isEmpty(sb2.toString())) {
            Log.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.qlX.setText(sb2.toString());
            this.qlX.setVisibility(0);
        } else if (!TextUtils.isEmpty(this.pQV.csQ().LeQ)) {
            Log.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.qlX.setText(this.pQV.csQ().LeQ);
            this.qlX.setVisibility(0);
        } else {
            this.qlX.setVisibility(8);
        }
        Log.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.pQV.csQ().LeF);
        if (this.pQV.csQ().LeF <= 0) {
            this.qlY.setVisibility(8);
            this.qmc.setVisibility(8);
        } else {
            this.qlY.setVisibility(0);
            this.qlY.setOnClickListener(this.kuO);
            n.b(this.qmb, R.drawable.c2j, l.ake(this.pQV.csQ().ixw));
            us usVar = null;
            if (this.pRc != null && this.pRc.size() > 0) {
                usVar = this.pRc.get(0);
            }
            if (this.pQV.csQ().LeF == 1 && usVar != null) {
                this.qlZ.setText(usVar.name);
                this.qma.setText(this.mContext.getString(R.string.at1, l.f(this.mContext, usVar.DWG), usVar.iUO));
                this.qmc.setVisibility(8);
                this.qlY.setTag(usVar.name);
            } else if (this.pQV.csQ().LeF > 1 && usVar != null) {
                this.qlZ.setText(usVar.name);
                this.qma.setText(this.mContext.getString(R.string.at1, l.f(this.mContext, usVar.DWG), usVar.iUO));
                this.qmc.setVisibility(0);
                this.qmc.setOnClickListener(this.kuO);
                this.qlY.setTag(usVar.name);
            } else if (this.pQV.csQ().LeF > 0) {
                this.qlZ.setText(R.string.ans);
                this.qma.setText(this.mContext.getString(R.string.atq, Integer.valueOf(this.pQV.csQ().LeF)));
                this.qmc.setVisibility(8);
                this.qmc.setOnClickListener(null);
                this.qlY.setTag(this.mContext.getString(R.string.ans));
            }
        }
        if (this.pQV.csP()) {
            this.qlU.setVisibility(8);
            AppMethodBeat.o(113914);
            return;
        }
        this.qlU.setVisibility(0);
        AppMethodBeat.o(113914);
    }
}
