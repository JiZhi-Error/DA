package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.ad;
import java.util.ArrayList;

public final class t extends BaseAdapter {
    ad Iks = null;
    private Context mContext;
    ArrayList<ad> mData = null;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(71256);
        ad aeV = aeV(i2);
        AppMethodBeat.o(71256);
        return aeV;
    }

    public t(Context context, ArrayList<ad> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        AppMethodBeat.i(71253);
        if (this.mData != null) {
            int size = this.mData.size();
            AppMethodBeat.o(71253);
            return size;
        }
        AppMethodBeat.o(71253);
        return 0;
    }

    public final ad aeV(int i2) {
        AppMethodBeat.i(71254);
        if (this.mData == null || getCount() <= i2) {
            AppMethodBeat.o(71254);
            return null;
        }
        ad adVar = this.mData.get(i2);
        AppMethodBeat.o(71254);
        return adVar;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(71255);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.caa, null);
            a aVar2 = new a(this, (byte) 0);
            aVar2.hbb = (TextView) view.findViewById(R.id.ipm);
            aVar2.Ikt = (ImageView) view.findViewById(R.id.hix);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ad aeV = aeV(i2);
        if (aeV != null) {
            aVar.hbb.setText(aeV.field_wallet_name);
            if (aeV.field_wallet_selected == 1) {
                this.Iks = aeV;
                aVar.Ikt.setImageResource(R.raw.radio_on);
            } else {
                aVar.Ikt.setImageResource(R.raw.radio_off);
            }
        }
        AppMethodBeat.o(71255);
        return view;
    }

    class a {
        ImageView Ikt;
        TextView hbb;

        private a() {
        }

        /* synthetic */ a(t tVar, byte b2) {
            this();
        }
    }
}
