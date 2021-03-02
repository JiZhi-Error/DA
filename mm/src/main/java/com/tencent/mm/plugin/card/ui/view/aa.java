package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.d.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.l;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class aa implements c {
    int kn;
    private Context mContext;
    private BaseAdapter pXY;
    private int pYc;
    protected LinkedList<CardTagTextView> pYg = new LinkedList<>();
    private int qej;
    int qek;

    public aa(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(113721);
        this.mContext = context;
        this.pXY = baseAdapter;
        this.qej = this.mContext.getResources().getDimensionPixelSize(R.dimen.kb);
        this.pYc = this.mContext.getResources().getDimensionPixelSize(R.dimen.ib);
        this.qek = this.mContext.getResources().getDimensionPixelOffset(R.dimen.v_);
        this.kn = this.mContext.getResources().getDimensionPixelOffset(R.dimen.va);
        AppMethodBeat.o(113721);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void release() {
        AppMethodBeat.i(113722);
        this.mContext = null;
        this.pXY = null;
        if (this.pYg != null) {
            this.pYg.clear();
        }
        AppMethodBeat.o(113722);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final View a(int i2, View view, b bVar) {
        a aVar;
        String str;
        CardTagTextView removeFirst;
        View inflate;
        TextView textView;
        AppMethodBeat.i(113723);
        if (view == null) {
            switch (this.pXY.getItemViewType(i2)) {
                case 0:
                    inflate = View.inflate(this.mContext, R.layout.ny, null);
                    if (!bVar.csU().equals("PRIVATE_TICKET_TITLE")) {
                        if (bVar.csU().equals("PRIVATE_INVOICE_TITLE") && (textView = (TextView) inflate.findViewById(R.id.anm)) != null) {
                            textView.setText(this.mContext.getString(R.string.aqi));
                            break;
                        }
                    } else {
                        TextView textView2 = (TextView) inflate.findViewById(R.id.anm);
                        if (textView2 != null) {
                            textView2.setText(this.mContext.getString(R.string.atm));
                            break;
                        }
                    }
                    break;
                case 1:
                    inflate = View.inflate(this.mContext, R.layout.nw, null);
                    break;
                case 2:
                    inflate = View.inflate(this.mContext, R.layout.o1, null);
                    break;
                default:
                    inflate = View.inflate(this.mContext, R.layout.nw, null);
                    break;
            }
            aVar = new a();
            if (bVar.csU().equals("PRIVATE_TICKET_TITLE") || bVar.csU().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.qkI = (TextView) inflate.findViewById(R.id.anm);
            } else if (bVar.csB()) {
                aVar.qkJ = (TextView) inflate.findViewById(R.id.ant);
                aVar.qkK = (TextView) inflate.findViewById(R.id.anp);
                aVar.qkL = (TextView) inflate.findViewById(R.id.anr);
                aVar.qkM = (TextView) inflate.findViewById(R.id.ans);
            } else {
                aVar.pYk = (RelativeLayout) inflate.findViewById(R.id.aln);
                aVar.pYl = (ImageView) inflate.findViewById(R.id.an8);
                aVar.qdv = inflate.findViewById(R.id.apo);
                aVar.qdw = (ImageView) inflate.findViewById(R.id.apn);
                aVar.pYm = (TextView) inflate.findViewById(R.id.aku);
                aVar.pYn = (TextView) inflate.findViewById(R.id.ao6);
                aVar.pYq = (TextView) inflate.findViewById(R.id.ao7);
                aVar.qel = (ImageView) inflate.findViewById(R.id.ak9);
                aVar.qen = (ImageView) inflate.findViewById(R.id.akn);
                aVar.qeo = (ImageView) inflate.findViewById(R.id.akp);
                aVar.qep = (ImageView) inflate.findViewById(R.id.ako);
                aVar.qem = (LinearLayout) inflate.findViewById(R.id.aou);
            }
            inflate.setTag(aVar);
            view = inflate;
        } else {
            a aVar2 = (a) view.getTag();
            if (aVar2.qkI != null) {
                if (bVar.csU().equals("PRIVATE_TICKET_TITLE")) {
                    aVar2.qkI.setText(this.mContext.getString(R.string.atm));
                    aVar = aVar2;
                } else {
                    aVar2.qkI.setText(this.mContext.getString(R.string.aqi));
                }
            }
            aVar = aVar2;
        }
        if (aVar.pYn != null) {
            aVar.pYn.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.s));
        }
        if (bVar.csC()) {
            if (bVar.csU().equals("PRIVATE_TICKET_TITLE")) {
                aVar.qkI.setText(this.mContext.getString(R.string.atm));
            } else if (bVar.csU().equals("PRIVATE_INVOICE_TITLE")) {
                aVar.qkI.setText(this.mContext.getString(R.string.aqi));
            } else if (bVar.csB()) {
                LinkedList<abz> linkedList = bVar.csQ().LeC;
                aVar.qkJ.setText(linkedList.get(0).pRY);
                aVar.qkL.setText(linkedList.get(1).pRY);
                LinkedList<abz> linkedList2 = bVar.csR().Lcs;
                aVar.qkM.setText(String.format(this.mContext.getString(R.string.aqt), linkedList2.get(0).pRY));
                if (linkedList2.size() >= 2) {
                    aVar.qkK.setText(linkedList2.get(1).pRY);
                }
            } else {
                if (this.pXY.getItem(i2) instanceof CardInfo) {
                    CardInfo cardInfo = (CardInfo) this.pXY.getItem(i2);
                    if (!cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") && !cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
                        boolean z = false;
                        if (cardInfo.field_stickyIndex % 10 != 0) {
                            if (cardInfo.field_stickyIndex > 0) {
                                z = true;
                                str = j.a(this.mContext, cardInfo.field_stickyIndex, cardInfo);
                            }
                            str = null;
                        } else {
                            if (!Util.isNullOrNil(cardInfo.field_label_wording)) {
                                z = true;
                                str = cardInfo.field_label_wording;
                            }
                            str = null;
                        }
                        if (z) {
                            for (int i3 = 0; i3 < aVar.qem.getChildCount(); i3++) {
                                this.pYg.add((CardTagTextView) aVar.qem.getChildAt(i3));
                            }
                            aVar.qem.removeAllViews();
                            aVar.qem.setVisibility(0);
                            if (this.pYg.size() == 0) {
                                removeFirst = new CardTagTextView(this.mContext);
                            } else {
                                removeFirst = this.pYg.removeFirst();
                            }
                            removeFirst.setPadding(this.pYc, this.qej, this.pYc, this.qej);
                            removeFirst.setGravity(17);
                            removeFirst.setMinWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.vf));
                            removeFirst.setMinHeight(this.mContext.getResources().getDimensionPixelSize(R.dimen.ve));
                            if (cardInfo.csx()) {
                                removeFirst.setTextColor(com.tencent.mm.cb.a.n(this.mContext, R.color.ag2));
                                removeFirst.setFillColor(com.tencent.mm.cb.a.n(this.mContext, R.color.i8));
                            } else {
                                removeFirst.setTextColor(com.tencent.mm.cb.a.n(this.mContext, R.color.x0));
                                removeFirst.setFillColor(0);
                            }
                            removeFirst.setText(str);
                            removeFirst.setTextSize(1, 10.0f);
                            aVar.qem.addView(removeFirst);
                        } else {
                            aVar.qem.setVisibility(8);
                        }
                    }
                }
                aVar.pYk.setVisibility(0);
                aVar.pYl.setVisibility(0);
                aVar.pYn.setVisibility(0);
                aVar.pYq.setVisibility(8);
                aVar.pYm.setVisibility(0);
                aVar.pYm.setText(bVar.csQ().gTG);
                aVar.pYn.setText(bVar.csQ().title);
                if (bVar.csz()) {
                    aVar.qdv.setVisibility(0);
                    aVar.pYl.setVisibility(4);
                    ImageView imageView = aVar.qdw;
                    if (!TextUtils.isEmpty(bVar.csQ().LeI)) {
                        n.a(this.mContext, imageView, bVar.csQ().LeI, this.mContext.getResources().getDimensionPixelSize(R.dimen.vi), l.ake(bVar.csQ().ixw));
                    } else {
                        n.b(imageView, R.drawable.c2i, l.ake(bVar.csQ().ixw));
                    }
                } else {
                    aVar.qdv.setVisibility(8);
                    aVar.pYl.setVisibility(0);
                    n.a(aVar.pYl, bVar.csQ().iwv, this.mContext.getResources().getDimensionPixelSize(R.dimen.vi), (int) R.drawable.ci4, true);
                }
                if (bVar.csx()) {
                    if (Util.isNullOrNil(bVar.csR().LcC)) {
                        aVar.pYk.setBackgroundDrawable(l.fi(l.ake(bVar.csQ().ixw), this.qek));
                        aVar.qen.setVisibility(8);
                        aVar.qeo.setVisibility(8);
                        aVar.qep.setVisibility(0);
                    } else {
                        aVar.pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.le));
                        aVar.qen.setVisibility(0);
                        aVar.qeo.setVisibility(0);
                        ImageView imageView2 = aVar.qen;
                        String str2 = bVar.csR().LcC;
                        c.a aVar3 = new c.a();
                        aVar3.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                        q.bcW();
                        aVar3.jbw = null;
                        aVar3.fullPath = m.ajp(str2);
                        aVar3.jbf = true;
                        aVar3.jby = true;
                        aVar3.jbd = true;
                        aVar3.jbq = R.drawable.le;
                        aVar3.hZA = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.va);
                        aVar3.hZz = com.tencent.mm.cb.a.jn(this.mContext);
                        q.bcV().a(str2, imageView2, aVar3.bdv());
                        imageView2.setImageMatrix(new Matrix());
                        aVar.qep.setVisibility(8);
                    }
                    aVar.pYm.setTextColor(this.mContext.getResources().getColor(R.color.ag2));
                    aVar.pYn.setTextColor(this.mContext.getResources().getColor(R.color.ag2));
                } else {
                    aVar.qep.setVisibility(8);
                    aVar.qen.setVisibility(8);
                    aVar.qeo.setVisibility(8);
                    aVar.pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.le));
                    aVar.pYn.setTextColor(this.mContext.getResources().getColor(R.color.hm));
                    aVar.pYm.setTextColor(this.mContext.getResources().getColor(R.color.hm));
                }
            }
        } else if (!bVar.csU().equals("PRIVATE_TICKET_TITLE") && !bVar.csU().equals("PRIVATE_INVOICE_TITLE") && !bVar.csB()) {
            aVar.pYl.setVisibility(8);
            aVar.pYn.setVisibility(8);
            aVar.pYm.setVisibility(8);
            aVar.qem.setVisibility(8);
            aVar.pYq.setVisibility(0);
            aVar.pYk.setBackgroundDrawable(l.fi(this.mContext.getResources().getColor(R.color.i7), this.qek));
            aVar.pYq.setText(this.mContext.getResources().getString(R.string.arp));
        }
        if (!bVar.csU().equals("PRIVATE_TICKET_TITLE") && !bVar.csU().equals("PRIVATE_INVOICE_TITLE") && !bVar.csB()) {
            bVar.csQ();
            if (i2 != this.pXY.getCount() - 1 || aVar.pYk == null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.pYk.getLayoutParams();
                if (layoutParams.bottomMargin != 0) {
                    layoutParams.bottomMargin = 0;
                    aVar.pYk.setLayoutParams(layoutParams);
                }
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar.pYk.getLayoutParams();
                if (layoutParams2.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.dimen.i2)) {
                    layoutParams2.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.i2);
                    aVar.pYk.setLayoutParams(layoutParams2);
                }
            }
        }
        AppMethodBeat.o(113723);
        return view;
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Y(View view, int i2) {
        AppMethodBeat.i(113724);
        ((l.a) view.getTag()).qel.setImageResource(i2);
        AppMethodBeat.o(113724);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Z(View view, int i2) {
        AppMethodBeat.i(113725);
        ((l.a) view.getTag()).qel.setVisibility(i2);
        AppMethodBeat.o(113725);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void a(View view, int i2, View.OnClickListener onClickListener) {
        AppMethodBeat.i(113726);
        CardInfo cardInfo = (CardInfo) this.pXY.getItem(i2);
        if (cardInfo.field_card_id.equals("PRIVATE_TICKET_TITLE") || cardInfo.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            AppMethodBeat.o(113726);
            return;
        }
        a aVar = (a) view.getTag();
        aVar.qel.setTag(Integer.valueOf(i2));
        aVar.qel.setOnClickListener(onClickListener);
        AppMethodBeat.o(113726);
    }

    public class a {
        public RelativeLayout pYk;
        public ImageView pYl;
        public TextView pYm;
        public TextView pYn;
        public TextView pYq;
        public View qdv;
        public ImageView qdw;
        public ImageView qel;
        public LinearLayout qem;
        public ImageView qen;
        public ImageView qeo;
        public ImageView qep;
        public TextView qkI;
        public TextView qkJ;
        public TextView qkK;
        public TextView qkL;
        public TextView qkM;

        public a() {
        }
    }
}
