package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.bgg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends BaseAdapter {
    private Context context;
    private String dDv = "";
    private LinkedList<a> iAd = new LinkedList<>();

    public static class a {
        public int actionType;
        public String appId;
        public String description;
        public String text;
        public int type;
        public String xWn;
    }

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(42385);
        a OB = OB(i2);
        AppMethodBeat.o(42385);
        return OB;
    }

    public s(Context context2) {
        AppMethodBeat.i(42380);
        this.context = context2;
        AppMethodBeat.o(42380);
    }

    static class b {
        TextView hbb;
        ViewGroup xWo;
        TextView xWp;
        TextView xWq;
        ViewGroup xWr;
        TextView xWs;
        ViewGroup xWt;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(42381);
        a OB = OB(i2);
        if (view == null) {
            view = View.inflate(this.context, R.layout.asj, null);
            b bVar2 = new b((byte) 0);
            bVar2.hbb = (TextView) view.findViewById(R.id.dim);
            bVar2.xWo = (ViewGroup) bVar2.hbb.getParent();
            bVar2.xWp = (TextView) view.findViewById(R.id.dil);
            bVar2.xWq = (TextView) view.findViewById(R.id.dij);
            bVar2.xWr = (ViewGroup) bVar2.xWp.getParent();
            bVar2.xWs = (TextView) view.findViewById(R.id.dik);
            bVar2.xWt = (ViewGroup) bVar2.xWs.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (OB.type) {
            case 1:
                bVar.xWo.setVisibility(0);
                bVar.xWr.setVisibility(8);
                bVar.xWt.setVisibility(8);
                bVar.xWo.setOnClickListener(null);
                bVar.hbb.setText(OB.text);
                break;
            case 2:
                bVar.xWo.setVisibility(8);
                bVar.xWr.setVisibility(0);
                bVar.xWt.setVisibility(8);
                bVar.xWp.setText(OB.text);
                bVar.xWq.setText(OB.description);
                break;
            case 3:
                bVar.xWo.setVisibility(8);
                bVar.xWr.setVisibility(8);
                bVar.xWt.setVisibility(0);
                bVar.xWs.setTextColor(this.context.getResources().getColor(R.color.a2x));
                int color = this.context.getResources().getColor(R.color.tg);
                int indexOf = OB.text.indexOf(this.dDv);
                if (indexOf < 0) {
                    bVar.xWs.setText(OB.text);
                    break;
                } else {
                    SpannableString spannableString = new SpannableString(OB.text);
                    spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.dDv.length() + indexOf, 33);
                    bVar.xWs.setText(spannableString);
                    break;
                }
        }
        AppMethodBeat.o(42381);
        return view;
    }

    public final int getCount() {
        AppMethodBeat.i(42382);
        int size = this.iAd.size();
        AppMethodBeat.o(42382);
        return size;
    }

    public final a OB(int i2) {
        AppMethodBeat.i(42383);
        a aVar = this.iAd.get(i2);
        AppMethodBeat.o(42383);
        return aVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final void b(String str, String str2, LinkedList<bgg> linkedList) {
        AppMethodBeat.i(42384);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(42384);
            return;
        }
        this.dDv = str;
        this.iAd.clear();
        if (Util.isNullOrNil(str)) {
            a aVar = new a();
            aVar.type = 1;
            if (!Util.isNullOrNil(str2)) {
                aVar.text = str2;
            } else {
                aVar.text = this.context.getString(R.string.dsd);
            }
            this.iAd.add(aVar);
        }
        Iterator<bgg> it = linkedList.iterator();
        while (it.hasNext()) {
            bgg next = it.next();
            a aVar2 = new a();
            aVar2.type = Util.isNullOrNil(str) ? 2 : 3;
            aVar2.appId = next.hik;
            aVar2.text = next.LPZ;
            aVar2.description = next.KHk;
            aVar2.actionType = next.KWb;
            aVar2.xWn = next.LPS;
            this.iAd.add(aVar2);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(42384);
    }
}
