package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.k.a.a;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

public final class b extends s<c> {
    a QhB = null;
    private ArrayList<c> krk = new ArrayList<>();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ c a(c cVar, Cursor cursor) {
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ c getItem(int i2) {
        AppMethodBeat.i(38769);
        c aoa = aoa(i2);
        AppMethodBeat.o(38769);
        return aoa;
    }

    public b(Context context) {
        super(context, null);
        AppMethodBeat.i(38763);
        anq();
        AppMethodBeat.o(38763);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(38764);
        anp();
        AppMethodBeat.o(38764);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(38765);
        this.krk.clear();
        if (this.QhB == null) {
            AppMethodBeat.o(38765);
            return;
        }
        this.krk.add(new c(this.QhB));
        notifyDataSetChanged();
        AppMethodBeat.o(38765);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(38766);
        int size = this.krk.size();
        AppMethodBeat.o(38766);
        return size;
    }

    public final c aoa(int i2) {
        AppMethodBeat.i(38767);
        c cVar = this.krk.get(i2);
        AppMethodBeat.o(38767);
        return cVar;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        d dVar;
        AppMethodBeat.i(38768);
        c cVar = this.krk.get(i2);
        if (view == null) {
            view = View.inflate(this.context, R.layout.cl, null);
            d dVar2 = new d();
            dVar2.QhD = view;
            dVar2.QhE = (Button) view.findViewById(R.id.fh);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            AppMethodBeat.o(38768);
            return null;
        }
        AppMethodBeat.o(38768);
        return view;
    }
}
