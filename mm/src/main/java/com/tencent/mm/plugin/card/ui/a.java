package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    Context mContext;
    List<CardInfo> pXz = new ArrayList();
    HashMap<String, Integer> pYu = new HashMap<>();

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(113149);
        CardInfo Ep = Ep(i2);
        AppMethodBeat.o(113149);
        return Ep;
    }

    public a(Context context) {
        AppMethodBeat.i(113145);
        this.mContext = context;
        AppMethodBeat.o(113145);
    }

    public final int getCount() {
        AppMethodBeat.i(113146);
        int size = this.pXz.size();
        AppMethodBeat.o(113146);
        return size;
    }

    public final CardInfo Ep(int i2) {
        AppMethodBeat.i(113147);
        CardInfo cardInfo = this.pXz.get(i2);
        AppMethodBeat.o(113147);
        return cardInfo;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C0909a aVar;
        AppMethodBeat.i(113148);
        CardInfo Ep = Ep(i2);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.m0, null);
            aVar = new C0909a();
            aVar.pYk = (RelativeLayout) view.findViewById(R.id.aln);
            aVar.pYv = (LinearLayout) view.findViewById(R.id.apm);
            aVar.pYl = (ImageView) view.findViewById(R.id.an8);
            aVar.pYm = (TextView) view.findViewById(R.id.aku);
            aVar.pYn = (TextView) view.findViewById(R.id.ao6);
            aVar.pYo = (TextView) view.findViewById(R.id.idt);
            aVar.pYq = (TextView) view.findViewById(R.id.ao7);
            aVar.pYw = (ImageView) view.findViewById(R.id.anz);
            aVar.pYx = (TextView) view.findViewById(R.id.alp);
            aVar.pYy = (TextView) view.findViewById(R.id.ap7);
            view.setTag(aVar);
        } else {
            aVar = (C0909a) view.getTag();
        }
        if (Ep.csC()) {
            aVar.pYl.setVisibility(0);
            aVar.pYn.setVisibility(0);
            aVar.pYo.setVisibility(0);
            aVar.pYq.setVisibility(8);
            aVar.pYm.setVisibility(0);
            aVar.pYm.setText(Ep.csQ().gTG);
            if (!Ep.csz()) {
                aVar.pYn.setText(Ep.csQ().title);
            } else if (Ep.csQ().LeC != null && Ep.csQ().LeC.size() == 1) {
                aVar.pYn.setText(Ep.csQ().LeC.get(0).title);
            } else if (Ep.csQ().LeC != null && Ep.csQ().LeC.size() == 2) {
                aVar.pYn.setText(Ep.csQ().LeC.get(0).title + "-" + Ep.csQ().LeC.get(1).title);
            }
            if (Ep.csQ().LeZ == 1) {
                aVar.pYw.setVisibility(0);
            } else {
                aVar.pYw.setVisibility(8);
            }
            long j2 = Ep.field_begin_time;
            if (Ep.getEndTime() > 0 && j2 > 0) {
                aVar.pYo.setText(this.mContext.getString(R.string.att, l.AF(j2) + "  -  " + l.AF(Ep.getEndTime())));
                aVar.pYo.setVisibility(0);
            } else if (Ep.getEndTime() > 0) {
                aVar.pYo.setText(this.mContext.getString(R.string.ats, l.AF(Ep.getEndTime())));
                aVar.pYo.setVisibility(0);
            } else {
                aVar.pYo.setText("");
                aVar.pYo.setVisibility(8);
            }
            n.a(aVar.pYl, Ep.csQ().iwv, this.mContext.getResources().getDimensionPixelSize(R.dimen.vi), (int) R.drawable.ci4, true);
            if (Ep.csQ().LeX == 1) {
                aVar.pYl.setAlpha(255);
                aVar.pYy.setVisibility(8);
                aVar.pYn.setTextColor(this.mContext.getResources().getColor(R.color.hm));
                aVar.pYm.setTextColor(this.mContext.getResources().getColor(R.color.hm));
                aVar.pYo.setTextColor(this.mContext.getResources().getColor(R.color.tx));
            } else {
                aVar.pYy.setText(Ep.csQ().LeY);
                aVar.pYl.setAlpha(90);
                aVar.pYy.setVisibility(0);
                aVar.pYn.setTextColor(this.mContext.getResources().getColor(R.color.tx));
                aVar.pYm.setTextColor(this.mContext.getResources().getColor(R.color.tx));
                aVar.pYo.setTextColor(this.mContext.getResources().getColor(R.color.tx));
            }
            int intValue = this.pYu.get(Ep.csV()).intValue();
            if (intValue == 1) {
                aVar.pYx.setText("");
                aVar.pYx.setVisibility(8);
            } else {
                aVar.pYx.setText("x".concat(String.valueOf(intValue)));
                aVar.pYx.setVisibility(0);
            }
        } else {
            aVar.pYl.setVisibility(8);
            aVar.pYn.setVisibility(8);
            aVar.pYm.setVisibility(8);
            aVar.pYo.setVisibility(8);
            aVar.pYy.setVisibility(8);
            aVar.pYx.setVisibility(8);
            aVar.pYq.setVisibility(0);
            aVar.pYk.setBackgroundColor(this.mContext.getResources().getColor(R.color.i7));
            aVar.pYq.setText(this.mContext.getResources().getString(R.string.arp));
        }
        AppMethodBeat.o(113148);
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.a$a  reason: collision with other inner class name */
    public class C0909a {
        public RelativeLayout pYk;
        public ImageView pYl;
        public TextView pYm;
        public TextView pYn;
        public TextView pYo;
        public TextView pYq;
        public LinearLayout pYv;
        public ImageView pYw;
        public TextView pYx;
        public TextView pYy;

        public C0909a() {
        }
    }
}
