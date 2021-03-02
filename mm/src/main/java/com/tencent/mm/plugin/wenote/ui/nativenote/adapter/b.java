package com.tencent.mm.plugin.wenote.ui.nativenote.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.a;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends RecyclerView.a<a> {
    private k JJu;
    private h JKK;
    public boolean JKL = false;
    private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(30845);
        a(aVar, i2);
        AppMethodBeat.o(30845);
    }

    public b(k kVar) {
        AppMethodBeat.i(30841);
        this.JJu = kVar;
        this.JKK = new h();
        AppMethodBeat.o(30841);
    }

    private synchronized void a(a aVar, int i2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(30842);
            c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i2);
            if (ahp == null || ahp.getType() != aVar.cCY()) {
                Object[] objArr = new Object[2];
                if (ahp != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i2);
                Log.e("MicroMsg.Note.NoteRecyclerViewAdapter", "onBindViewHolder, item is null %b, position is %d", objArr);
                AppMethodBeat.o(30842);
            } else {
                aVar.a(ahp, i2, ahp.getType());
                AppMethodBeat.o(30842);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(30843);
        c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(i2);
        if (ahp != null) {
            int type = ahp.getType();
            AppMethodBeat.o(30843);
            return type;
        } else if (!this.JKL || i2 != com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size()) {
            Log.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", Integer.valueOf(i2));
            AppMethodBeat.o(30843);
            return 0;
        } else {
            AppMethodBeat.o(30843);
            return 30;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(30844);
        if (this.JKL) {
            int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size() + 1;
            AppMethodBeat.o(30844);
            return size;
        }
        int size2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().size();
        AppMethodBeat.o(30844);
        return size2;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(30846);
        Log.i("MicroMsg.Note.NoteRecyclerViewAdapter", "onCreateViewHolder viewType = ".concat(String.valueOf(i2)));
        a a2 = h.a(i2, LayoutInflater.from(viewGroup.getContext()).inflate(this.JKK.JKV.get(i2).intValue(), viewGroup, false), this.JJu);
        AppMethodBeat.o(30846);
        return a2;
    }
}
