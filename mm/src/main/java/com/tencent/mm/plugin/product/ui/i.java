package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends BaseAdapter {
    private c BaP = com.tencent.mm.plugin.product.a.a.eDc();
    LinkedList<m> BbA;
    AdapterView.OnItemClickListener BbB;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(67030);
        m Uv = Uv(i2);
        AppMethodBeat.o(67030);
        return Uv;
    }

    public i(Context context) {
        AppMethodBeat.i(67026);
        this.mContext = context;
        com.tencent.mm.plugin.product.a.a.eDb();
        AppMethodBeat.o(67026);
    }

    public final int getCount() {
        AppMethodBeat.i(67027);
        if (this.BbA != null) {
            int size = this.BbA.size();
            AppMethodBeat.o(67027);
            return size;
        }
        AppMethodBeat.o(67027);
        return 0;
    }

    private m Uv(int i2) {
        AppMethodBeat.i(67028);
        m mVar = this.BbA.get(i2);
        AppMethodBeat.o(67028);
        return mVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        Pair pair;
        AppMethodBeat.i(67029);
        m Uv = Uv(i2);
        if (view == null || view.getTag() == null) {
            aVar = new a();
            view = View.inflate(this.mContext, R.layout.bj8, null);
            aVar.BbC = (TextView) view.findViewById(R.id.f9m);
            aVar.BbD = (MaxGridView) view.findViewById(R.id.f9k);
            aVar.BbE = new j(this.mContext);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.BbC.setText(Uv.Baf);
        aVar.BbD.setOnItemClickListener(this.BbB);
        j jVar = aVar.BbE;
        c cVar = this.BaP;
        String str = Uv.Bae;
        String str2 = cVar.AZj.containsKey(str) ? cVar.AZj.get(str) : null;
        jVar.BbG = Uv;
        jVar.BbH = str2;
        Context context = this.mContext;
        LinkedList<h> linkedList = Uv.Bag;
        int fromDPToPix = context.getResources().getDisplayMetrics().widthPixels - (com.tencent.mm.cb.a.fromDPToPix(context, 16) * 2);
        TextPaint paint = ((TextView) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.bj7, (ViewGroup) null)).getPaint();
        float f2 = 0.0f;
        Iterator<h> it = linkedList.iterator();
        while (it.hasNext()) {
            float measureText = paint.measureText(it.next().name);
            if (f2 >= measureText) {
                measureText = f2;
            }
            f2 = measureText;
        }
        int fromDPToPix2 = ((int) f2) + (com.tencent.mm.cb.a.fromDPToPix(context, 10) * 2);
        int[] iArr = new int[4];
        int fromDPToPix3 = com.tencent.mm.cb.a.fromDPToPix(context, 12);
        for (int i3 = 0; i3 < 4; i3++) {
            iArr[i3] = (fromDPToPix - (fromDPToPix3 * i3)) / (i3 + 1);
        }
        int i4 = 4;
        while (true) {
            if (i4 <= 0) {
                pair = new Pair(1, Integer.valueOf(fromDPToPix));
                break;
            } else if (fromDPToPix2 < iArr[i4 - 1]) {
                pair = new Pair(Integer.valueOf(i4), Integer.valueOf(iArr[i4 - 1]));
                break;
            } else {
                i4--;
            }
        }
        Log.d("MicroMsg.MallProductImageAdapter", Uv.Baf + " numColumns = " + pair);
        aVar.BbD.setColumnWidth(((Integer) pair.second).intValue());
        aVar.BbE.notifyDataSetChanged();
        aVar.BbD.setAdapter((ListAdapter) aVar.BbE);
        AppMethodBeat.o(67029);
        return view;
    }

    class a {
        public TextView BbC = null;
        public MaxGridView BbD = null;
        public j BbE = null;

        a() {
        }
    }
}
