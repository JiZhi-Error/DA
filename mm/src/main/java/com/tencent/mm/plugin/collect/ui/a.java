package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    private Context mContext;
    List<com.tencent.mm.plugin.collect.model.a> qzs = new ArrayList();

    public a(Context context) {
        AppMethodBeat.i(64030);
        this.mContext = context;
        AppMethodBeat.o(64030);
    }

    public final int getCount() {
        AppMethodBeat.i(64031);
        int size = this.qzs.size();
        AppMethodBeat.o(64031);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(64032);
        com.tencent.mm.plugin.collect.model.a aVar = this.qzs.get(i2);
        AppMethodBeat.o(64032);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(64033);
        if (view == null) {
            view = aa.jQ(this.mContext).inflate(R.layout.uy, viewGroup, false);
            view.setTag(new C0932a(view));
        }
        com.tencent.mm.plugin.collect.model.a aVar = this.qzs.get(i2);
        C0932a aVar2 = (C0932a) view.getTag();
        aVar2.qpf.setText(new SimpleDateFormat(this.mContext.getString(R.string.b65)).format(new Date(aVar.timestamp * 1000)));
        aVar2.qzt.setText(e.Fb(aVar.dFu));
        if (!Util.isNullOrNil(aVar.desc)) {
            aVar2.jVn.setText(aVar.desc);
            aVar2.jVn.setVisibility(0);
        } else {
            aVar2.jVn.setVisibility(8);
        }
        AppMethodBeat.o(64033);
        return view;
    }

    /* renamed from: com.tencent.mm.plugin.collect.ui.a$a  reason: collision with other inner class name */
    static class C0932a {
        TextView jVn;
        TextView qpf;
        WalletTextView qzt;

        public C0932a(View view) {
            AppMethodBeat.i(64029);
            this.qpf = (TextView) view.findViewById(R.id.b60);
            this.qzt = (WalletTextView) view.findViewById(R.id.b6g);
            this.jVn = (TextView) view.findViewById(R.id.b61);
            AppMethodBeat.o(64029);
        }
    }
}
