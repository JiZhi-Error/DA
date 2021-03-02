package com.tencent.mm.plugin.card.ui;

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
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class l implements c {
    int kn;
    private Context mContext;
    private BaseAdapter pXY;
    private int pYc;
    protected LinkedList<CardTagTextView> pYg = new LinkedList<>();
    private int qej;
    int qek;

    public l(Context context, BaseAdapter baseAdapter) {
        AppMethodBeat.i(113592);
        this.mContext = context;
        this.pXY = baseAdapter;
        this.qej = this.mContext.getResources().getDimensionPixelSize(R.dimen.kb);
        this.pYc = this.mContext.getResources().getDimensionPixelSize(R.dimen.ib);
        this.qek = this.mContext.getResources().getDimensionPixelOffset(R.dimen.v_);
        this.kn = this.mContext.getResources().getDimensionPixelOffset(R.dimen.va);
        AppMethodBeat.o(113592);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void release() {
        AppMethodBeat.i(113593);
        this.mContext = null;
        this.pXY = null;
        if (this.pYg != null) {
            this.pYg.clear();
        }
        AppMethodBeat.o(113593);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final View a(int i2, View view, b bVar) {
        a aVar;
        String str;
        CardTagTextView removeFirst;
        View inflate;
        AppMethodBeat.i(113594);
        if (view == null) {
            if (bVar.csU().equals("PRIVATE_TICKET_TITLE")) {
                inflate = View.inflate(this.mContext, R.layout.ny, null);
                TextView textView = (TextView) inflate.findViewById(R.id.anm);
                if (textView != null) {
                    textView.setText(this.mContext.getString(R.string.atm));
                }
            } else if (bVar.csU().equals("PRIVATE_INVOICE_TITLE")) {
                inflate = View.inflate(this.mContext, R.layout.ny, null);
                TextView textView2 = (TextView) inflate.findViewById(R.id.anm);
                if (textView2 != null) {
                    textView2.setText(this.mContext.getString(R.string.aqi));
                }
            } else {
                inflate = View.inflate(this.mContext, R.layout.nw, null);
            }
            aVar = new a();
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
            inflate.setTag(aVar);
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar.pYn != null) {
            aVar.pYn.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.s));
        }
        if (this.pXY.getItem(i2) instanceof CardInfo) {
            CardInfo cardInfo = (CardInfo) this.pXY.getItem(i2);
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
        if (bVar.csC()) {
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
                    n.a(this.mContext, imageView, bVar.csQ().LeI, this.mContext.getResources().getDimensionPixelSize(R.dimen.vi), com.tencent.mm.plugin.card.d.l.ake(bVar.csQ().ixw));
                } else {
                    n.b(imageView, R.drawable.c2i, com.tencent.mm.plugin.card.d.l.ake(bVar.csQ().ixw));
                }
            } else {
                aVar.qdv.setVisibility(8);
                aVar.pYl.setVisibility(0);
                n.a(aVar.pYl, bVar.csQ().iwv, this.mContext.getResources().getDimensionPixelSize(R.dimen.vi), (int) R.drawable.ci4, true);
            }
            if (bVar.csx()) {
                if (Util.isNullOrNil(bVar.csR().LcC)) {
                    aVar.pYk.setBackgroundDrawable(com.tencent.mm.plugin.card.d.l.fi(com.tencent.mm.plugin.card.d.l.ake(bVar.csQ().ixw), this.qek));
                    aVar.qen.setVisibility(8);
                    aVar.qeo.setVisibility(8);
                    aVar.qep.setVisibility(0);
                } else {
                    aVar.pYk.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.le));
                    aVar.qen.setVisibility(0);
                    aVar.qeo.setVisibility(0);
                    ImageView imageView2 = aVar.qen;
                    String str2 = bVar.csR().LcC;
                    c.a aVar2 = new c.a();
                    aVar2.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                    q.bcW();
                    aVar2.jbw = null;
                    aVar2.fullPath = m.ajp(str2);
                    aVar2.jbf = true;
                    aVar2.jby = true;
                    aVar2.jbd = true;
                    aVar2.jbq = R.drawable.le;
                    aVar2.hZA = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.va);
                    aVar2.hZz = com.tencent.mm.cb.a.jn(this.mContext);
                    q.bcV().a(str2, imageView2, aVar2.bdv());
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
                aVar.pYn.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
                aVar.pYm.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
            }
        } else {
            aVar.pYl.setVisibility(8);
            aVar.pYn.setVisibility(8);
            aVar.pYm.setVisibility(8);
            aVar.qem.setVisibility(8);
            aVar.pYq.setVisibility(0);
            aVar.pYk.setBackgroundDrawable(com.tencent.mm.plugin.card.d.l.fi(this.mContext.getResources().getColor(R.color.i7), this.qek));
            aVar.pYq.setText(this.mContext.getResources().getString(R.string.arp));
        }
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
        AppMethodBeat.o(113594);
        return view;
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Y(View view, int i2) {
        AppMethodBeat.i(113595);
        ((a) view.getTag()).qel.setImageResource(i2);
        AppMethodBeat.o(113595);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void Z(View view, int i2) {
        AppMethodBeat.i(113596);
        ((a) view.getTag()).qel.setVisibility(i2);
        AppMethodBeat.o(113596);
    }

    @Override // com.tencent.mm.plugin.card.base.c
    public final void a(View view, int i2, View.OnClickListener onClickListener) {
        AppMethodBeat.i(113597);
        a aVar = (a) view.getTag();
        aVar.qel.setTag(Integer.valueOf(i2));
        aVar.qel.setOnClickListener(onClickListener);
        AppMethodBeat.o(113597);
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

        public a() {
        }
    }
}
