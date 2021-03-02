package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;

public final class c extends BaseAdapter {
    private List<b.a> bXV = new ArrayList();
    private Context context;
    private String kdi;
    private List<b.a> list;
    int[] yuP;
    boolean yuQ = false;

    public c(Context context2, List<b.a> list2) {
        AppMethodBeat.i(38986);
        this.context = context2;
        this.list = list2;
        ebk();
        ebl();
        AppMethodBeat.o(38986);
    }

    private void ebk() {
        AppMethodBeat.i(38987);
        int size = this.list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.bXV.add(this.list.get(i2));
        }
        AppMethodBeat.o(38987);
    }

    private void ebl() {
        AppMethodBeat.i(38988);
        this.yuP = new int[this.list.size()];
        int size = this.list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.yuP[i2] = this.list.get(i2).jcb;
        }
        AppMethodBeat.o(38988);
    }

    public final int getCount() {
        AppMethodBeat.i(38989);
        int size = this.list.size();
        AppMethodBeat.o(38989);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(38990);
        b.a aVar = this.list.get(i2);
        AppMethodBeat.o(38990);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final void SM(String str) {
        AppMethodBeat.i(38991);
        if (str != null) {
            this.kdi = str.trim();
            this.list.clear();
            int size = this.bXV.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.bXV.get(i2).jbZ.toUpperCase().contains(this.kdi.toUpperCase()) || this.bXV.get(i2).jca.toUpperCase().contains(this.kdi.toUpperCase()) || this.bXV.get(i2).jbY.contains(this.kdi)) {
                    this.list.add(this.bXV.get(i2));
                }
            }
            ebl();
            super.notifyDataSetChanged();
        }
        AppMethodBeat.o(38991);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        AppMethodBeat.i(38992);
        b.a aVar2 = (b.a) getItem(i2);
        if (view == null) {
            if (!LocaleUtil.isTraditionalChineseAppLang()) {
                view2 = View.inflate(this.context, R.layout.yj, null);
            } else {
                view2 = View.inflate(this.context, R.layout.yk, null);
            }
            aVar = new a();
            aVar.yuS = (TextView) view2.findViewById(R.id.bdr);
            aVar.gwR = (TextView) view2.findViewById(R.id.bdw);
            aVar.yuT = (TextView) view2.findViewById(R.id.be1);
            view2.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        int i3 = i2 > 0 ? this.yuP[i2 - 1] : -1;
        if (i2 == 0) {
            aVar.yuS.setVisibility(0);
            aVar.yuS.setText(Ph(this.yuP[i2]));
        } else if (i2 <= 0 || this.yuP[i2] == i3) {
            aVar.yuS.setVisibility(8);
        } else {
            aVar.yuS.setVisibility(0);
            aVar.yuS.setText(Ph(this.yuP[i2]));
        }
        aVar.gwR.setText(aVar2.jbZ);
        aVar.yuT.setText(aVar2.jbY);
        if (this.yuQ) {
            aVar.yuT.setVisibility(0);
        } else {
            aVar.yuT.setVisibility(4);
        }
        AppMethodBeat.o(38992);
        return view2;
    }

    private static String Ph(int i2) {
        AppMethodBeat.i(38993);
        if (LocaleUtil.isTraditionalChineseAppLang()) {
            String str = Integer.toString(i2) + "劃";
            AppMethodBeat.o(38993);
            return str;
        }
        String valueOf = String.valueOf((char) i2);
        AppMethodBeat.o(38993);
        return valueOf;
    }

    static class a {
        TextView gwR;
        TextView yuS;
        TextView yuT;

        a() {
        }
    }
}
