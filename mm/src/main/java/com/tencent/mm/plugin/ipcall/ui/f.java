package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private List<a> bXV = new ArrayList();
    private String kdi;
    private List<a> list;
    private IPCallCountryCodeSelectUI yuO;
    int[] yuP;
    boolean yuQ = false;
    boolean yuR = false;

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list2) {
        AppMethodBeat.i(25715);
        this.yuO = iPCallCountryCodeSelectUI;
        this.list = list2;
        ebk();
        ebl();
        AppMethodBeat.o(25715);
    }

    private void ebk() {
        AppMethodBeat.i(25716);
        int size = this.list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bXV.add(this.list.get(i2));
        }
        this.yuO.yuH.setVisibility(8);
        AppMethodBeat.o(25716);
    }

    private void ebl() {
        AppMethodBeat.i(25717);
        this.yuP = new int[this.list.size()];
        int size = this.list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.yuP[i2] = this.list.get(i2).ebc();
        }
        AppMethodBeat.o(25717);
    }

    public final int getCount() {
        AppMethodBeat.i(25718);
        int size = this.list.size();
        AppMethodBeat.o(25718);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(25719);
        a aVar = this.list.get(i2);
        AppMethodBeat.o(25719);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final void SM(String str) {
        AppMethodBeat.i(25720);
        if (str != null) {
            this.kdi = str.trim();
            this.list.clear();
            int size = this.bXV.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bXV.get(i2).jbZ.toUpperCase().contains(this.kdi.toUpperCase()) || this.bXV.get(i2).jca.toUpperCase().contains(this.kdi.toUpperCase()) || this.bXV.get(i2).countryCode.contains(this.kdi)) {
                    this.list.add(this.bXV.get(i2));
                }
            }
            ebl();
            if (this.list.size() == 0) {
                this.yuO.yuH.setVisibility(0);
            } else {
                this.yuO.yuH.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
        AppMethodBeat.o(25720);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(25721);
        a aVar2 = (a) getItem(i2);
        if (view == null) {
            view = View.inflate(this.yuO, R.layout.awj, null);
            aVar = new a();
            aVar.yuS = (TextView) view.findViewById(R.id.bdr);
            aVar.gwR = (TextView) view.findViewById(R.id.bdw);
            aVar.yuT = (TextView) view.findViewById(R.id.be1);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i3 = i2 > 0 ? this.yuP[i2 - 1] : -1;
        if (i2 == 0) {
            aVar.yuS.setVisibility(0);
            if (this.yuR) {
                aVar.yuS.setText(R.string.foz);
            } else {
                aVar.yuS.setText(Ph(this.yuP[i2]));
            }
        } else if (i2 <= 0 || this.yuP[i2] == i3) {
            aVar.yuS.setVisibility(8);
        } else {
            aVar.yuS.setVisibility(0);
            aVar.yuS.setText(Ph(this.yuP[i2]));
        }
        if (!Util.isNullOrNil(this.kdi)) {
            aVar.gwR.setText(com.tencent.mm.plugin.fts.a.f.b(aVar2.jbZ, this.kdi));
            aVar.yuT.setText(com.tencent.mm.plugin.fts.a.f.b(" (+" + aVar2.countryCode + ")", this.kdi));
        } else {
            aVar.gwR.setText(aVar2.jbZ);
            aVar.yuT.setText(" (+" + aVar2.countryCode + ")");
        }
        if (this.yuQ) {
            aVar.yuT.setVisibility(0);
        } else {
            aVar.yuT.setVisibility(4);
        }
        AppMethodBeat.o(25721);
        return view;
    }

    private static String Ph(int i2) {
        AppMethodBeat.i(25722);
        String valueOf = String.valueOf((char) i2);
        for (String str : IPCallCountryCodeScrollbar.yuU) {
            if (str.equals(String.valueOf((char) i2))) {
                AppMethodBeat.o(25722);
                return valueOf;
            }
        }
        AppMethodBeat.o(25722);
        return "#";
    }

    static class a {
        TextView gwR;
        TextView yuS;
        TextView yuT;

        a() {
        }
    }
}
