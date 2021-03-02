package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class k extends BaseAdapter {
    AdapterView.OnItemClickListener BbB;
    List<n> BbI;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(67039);
        n Ux = Ux(i2);
        AppMethodBeat.o(67039);
        return Ux;
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        AppMethodBeat.i(67036);
        if (this.BbI != null) {
            int size = this.BbI.size();
            AppMethodBeat.o(67036);
            return size;
        }
        AppMethodBeat.o(67036);
        return 0;
    }

    private n Ux(int i2) {
        AppMethodBeat.i(67037);
        n nVar = this.BbI.get(i2);
        AppMethodBeat.o(67037);
        return nVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(67038);
        n Ux = Ux(i2);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a();
            view = View.inflate(this.mContext, R.layout.bja, null);
            aVar2.BbC = (TextView) view.findViewById(R.id.f9q);
            aVar2.BbD = (MaxGridView) view.findViewById(R.id.f9p);
            aVar2.BbJ = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.BbC.setText(Ux.name);
        aVar.BbD.setOnItemClickListener(this.BbB);
        aVar.BbJ.BbL = Ux.AZH;
        aVar.BbJ.notifyDataSetChanged();
        aVar.BbD.setAdapter((ListAdapter) aVar.BbJ);
        AppMethodBeat.o(67038);
        return view;
    }

    class a {
        public TextView BbC = null;
        public MaxGridView BbD = null;
        public l BbJ = null;

        a() {
        }
    }
}
