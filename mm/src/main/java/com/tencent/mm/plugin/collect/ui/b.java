package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.plugin.collect.model.h;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context mContext;
    List<h> qzs = new ArrayList();

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(64047);
        h Fd = Fd(i2);
        AppMethodBeat.o(64047);
        return Fd;
    }

    public b(Context context) {
        AppMethodBeat.i(64041);
        this.mContext = context;
        AppMethodBeat.o(64041);
    }

    public final int getCount() {
        AppMethodBeat.i(64042);
        int size = this.qzs.size();
        AppMethodBeat.o(64042);
        return size;
    }

    public final h Fd(int i2) {
        AppMethodBeat.i(64043);
        h hVar = this.qzs.get(i2);
        AppMethodBeat.o(64043);
        return hVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(64044);
        if (view == null) {
            view = aa.jQ(this.mContext).inflate(R.layout.v0, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        h Fd = Fd(i2);
        aVar.qpf.setText(e.a(this.mContext, Fd.qwd, Fd.type));
        aVar.qzt.setText(e.Fb(Fd.dKt));
        aVar.jVn.setText(this.mContext.getString(R.string.b6g, Integer.valueOf(Fd.qwe)));
        AppMethodBeat.o(64044);
        return view;
    }

    public final void setData(List<h> list) {
        AppMethodBeat.i(64045);
        this.qzs.clear();
        this.qzs.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(64045);
    }

    public final void dd(List<h> list) {
        AppMethodBeat.i(64046);
        this.qzs.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(64046);
    }

    static class a {
        TextView jVn;
        TextView qpf;
        WalletTextView qzt;
        TextView qzu;

        public a(View view) {
            AppMethodBeat.i(64040);
            this.qpf = (TextView) view.findViewById(R.id.b69);
            this.qzu = (TextView) view.findViewById(R.id.b68);
            this.qzt = (WalletTextView) view.findViewById(R.id.b6d);
            this.jVn = (TextView) view.findViewById(R.id.b6_);
            AppMethodBeat.o(64040);
        }
    }
}
