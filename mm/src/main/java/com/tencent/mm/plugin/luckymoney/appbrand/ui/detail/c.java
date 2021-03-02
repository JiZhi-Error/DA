package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import java.util.LinkedList;
import java.util.List;

public final class c extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<cai> yQe = new LinkedList();
    private String yQf = null;
    boolean yQg = false;
    private int yQh = 1;
    private a yQi = null;

    interface a {
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(64911);
        cai PC = PC(i2);
        AppMethodBeat.o(64911);
        return PC;
    }

    public c(Context context) {
        AppMethodBeat.i(64906);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        AppMethodBeat.o(64906);
    }

    public final void fq(List<cai> list) {
        AppMethodBeat.i(64907);
        if (list == null) {
            this.yQe = new LinkedList();
        } else {
            this.yQe = list;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(64907);
    }

    public final int getCount() {
        AppMethodBeat.i(64908);
        int size = this.yQe.size();
        AppMethodBeat.o(64908);
        return size;
    }

    private cai PC(int i2) {
        AppMethodBeat.i(64909);
        cai cai = this.yQe.get(i2);
        AppMethodBeat.o(64909);
        return cai;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(64910);
        if (view == null) {
            view = this.mInflater.inflate(R.layout.b4c, viewGroup, false);
            b bVar2 = new b();
            bVar2.kHq = view.findViewById(R.id.h8v);
            bVar2.qyu = (ImageView) view.findViewById(R.id.f4j);
            bVar2.rMV = (TextView) view.findViewById(R.id.f4n);
            bVar2.yQj = (TextView) view.findViewById(R.id.f4o);
            bVar2.yQk = (TextView) view.findViewById(R.id.f4h);
            bVar2.yQl = (TextView) view.findViewById(R.id.f4i);
            bVar2.yQm = (TextView) view.findViewById(R.id.f4p);
            bVar2.yQn = (ImageView) view.findViewById(R.id.f4k);
            bVar2.yQo = (TextView) view.findViewById(R.id.f4l);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        cai PC = PC(i2);
        af.a(bVar.qyu, PC.yPH, PC.username);
        bVar.yQl.setVisibility(8);
        af.a(this.mContext, bVar.rMV, PC.nickname);
        bVar.yQk.setText(this.mContext.getString(R.string.eri, f.formatMoney2f(((double) PC.Mfy) / 100.0d)));
        bVar.yQj.setText(af.o(this.mContext, PC.Mfz * 1000));
        bVar.yQj.setVisibility(0);
        bVar.yQm.setVisibility(8);
        if (Util.isNullOrNil(PC.MfB)) {
            bVar.yQn.setVisibility(8);
            bVar.yQo.setVisibility(8);
        } else {
            bVar.yQo.setText(PC.MfB);
            if (this.yQh == 2) {
                bVar.yQn.setImageResource(R.drawable.cd2);
            } else {
                bVar.yQn.setImageResource(R.drawable.cbz);
            }
            bVar.yQn.setVisibility(0);
            bVar.yQo.setVisibility(0);
        }
        AppMethodBeat.o(64910);
        return view;
    }

    class b {
        View kHq;
        ImageView qyu;
        TextView rMV;
        TextView yQj;
        TextView yQk;
        TextView yQl;
        TextView yQm;
        ImageView yQn;
        TextView yQo;

        b() {
        }
    }
}
