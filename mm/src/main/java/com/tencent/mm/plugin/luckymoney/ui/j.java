package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class j extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ad> yQe = new LinkedList();
    String yQf;
    boolean yQg;
    int yQh = 1;
    View.OnClickListener ziC;
    b ziD = null;

    interface b {
        void a(c cVar, Context context);
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(65930);
        ad Qc = Qc(i2);
        AppMethodBeat.o(65930);
        return Qc;
    }

    public j(Context context) {
        AppMethodBeat.i(65925);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(65925);
    }

    public final void fq(List<ad> list) {
        AppMethodBeat.i(65926);
        if (list == null) {
            new LinkedList();
        } else {
            this.yQe = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(65926);
    }

    public final int getCount() {
        AppMethodBeat.i(65927);
        int size = this.yQe.size();
        AppMethodBeat.o(65927);
        return size;
    }

    private ad Qc(int i2) {
        AppMethodBeat.i(65928);
        ad adVar = this.yQe.get(i2);
        AppMethodBeat.o(65928);
        return adVar;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        c cVar;
        AppMethodBeat.i(65929);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.b4c, viewGroup, false);
            c cVar2 = new c();
            cVar2.kHq = view.findViewById(R.id.h8v);
            cVar2.qyu = (ImageView) view.findViewById(R.id.f4j);
            cVar2.rMV = (TextView) view.findViewById(R.id.f4n);
            cVar2.yQj = (TextView) view.findViewById(R.id.f4o);
            cVar2.yQk = (TextView) view.findViewById(R.id.f4h);
            cVar2.yQl = (TextView) view.findViewById(R.id.f4i);
            cVar2.yQm = (TextView) view.findViewById(R.id.f4p);
            cVar2.yQn = (ImageView) view.findViewById(R.id.f4k);
            cVar2.yQo = (TextView) view.findViewById(R.id.f4l);
            if (this.ziD != null) {
                this.ziD.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        ad Qc = Qc(i2);
        af.a(cVar.qyu, Qc.yWE, Qc.userName);
        if (!Util.nullAsNil(Qc.yVk).equals(this.yQf) || !this.yQg) {
            if (Util.isNullOrNil(Qc.yWF)) {
                cVar.yQl.setVisibility(8);
            } else {
                af.a(this.mContext, cVar.yQl, Qc.yWF);
                cVar.yQl.setVisibility(0);
            }
            cVar.yQj.setText(af.o(this.mContext, Util.getLong(Qc.yWp, 0) * 1000));
            cVar.yQj.setVisibility(0);
            cVar.yQm.setVisibility(8);
        } else {
            cVar.yQm.setOnClickListener(this.ziC);
            cVar.yQm.setVisibility(0);
            cVar.yQl.setVisibility(8);
            cVar.yQj.setVisibility(8);
        }
        af.a(this.mContext, cVar.rMV, Qc.yWD);
        cVar.yQk.setText(this.mContext.getString(R.string.eri, f.formatMoney2f(((double) Qc.yWo) / 100.0d)));
        if (Util.isNullOrNil(Qc.yWG)) {
            cVar.yQn.setVisibility(8);
            cVar.yQo.setVisibility(8);
        } else {
            cVar.yQo.setText(Qc.yWG);
            if (this.yQh == 2) {
                cVar.yQn.setImageResource(R.drawable.cd2);
            } else {
                cVar.yQn.setImageResource(R.drawable.cbz);
            }
            cVar.yQn.setVisibility(0);
            cVar.yQo.setVisibility(0);
        }
        AppMethodBeat.o(65929);
        return view;
    }

    class c {
        View kHq;
        ImageView qyu;
        TextView rMV;
        TextView yQj;
        TextView yQk;
        TextView yQl;
        TextView yQm;
        ImageView yQn;
        TextView yQo;

        c() {
        }
    }

    final class a implements b {
        a() {
        }

        @Override // com.tencent.mm.plugin.luckymoney.ui.j.b
        public final void a(c cVar, Context context) {
            AppMethodBeat.i(65924);
            int color = context.getResources().getColor(R.color.yg);
            int color2 = context.getResources().getColor(R.color.yh);
            int color3 = context.getResources().getColor(R.color.yv);
            cVar.kHq.setBackgroundResource(R.color.ac_);
            cVar.kHq.setPadding(0, context.getResources().getDimensionPixelOffset(R.dimen.ib), 0, context.getResources().getDimensionPixelOffset(R.dimen.ib));
            cVar.rMV.setTextColor(color);
            cVar.yQj.setTextColor(color2);
            cVar.yQk.setTextColor(color);
            cVar.yQl.setTextColor(color);
            cVar.yQm.setTextColor(color3);
            AppMethodBeat.o(65924);
        }
    }
}
