package com.tencent.mm.plugin.editor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.adapter.a.a;
import com.tencent.mm.plugin.editor.adapter.a.c;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends RecyclerView.a<a> {
    private final String TAG = "MicroMsg.EditorAdapter";
    private j qNG;
    private c qOl;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* bridge */ /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(181642);
        a(aVar, i2);
        AppMethodBeat.o(181642);
    }

    public b(j jVar) {
        AppMethodBeat.i(181638);
        this.qNG = jVar;
        this.qOl = new c();
        AppMethodBeat.o(181638);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(181639);
        int size = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
        AppMethodBeat.o(181639);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(181640);
        com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(i2);
        if (Fw != null) {
            int type = Fw.getType();
            AppMethodBeat.o(181640);
            return type;
        }
        Log.e("MicroMsg.EditorAdapter", "getItemViewType, item is null, position is %d", Integer.valueOf(i2));
        AppMethodBeat.o(181640);
        return 0;
    }

    private synchronized void a(a aVar, int i2) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(181641);
            com.tencent.mm.plugin.editor.model.a.a Fw = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(i2);
            if (Fw == null || Fw.getType() != aVar.cCY()) {
                Object[] objArr = new Object[2];
                if (Fw != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i2);
                Log.e("MicroMsg.EditorAdapter", "onBindViewHolder, item is null %b, position is %d", objArr);
                AppMethodBeat.o(181641);
            } else {
                aVar.a(Fw, i2, Fw.getType());
                AppMethodBeat.o(181641);
            }
        }
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(181643);
        Log.i("MicroMsg.EditorAdapter", "onCreateViewHolder viewType = ".concat(String.valueOf(i2)));
        a a2 = c.a(i2, LayoutInflater.from(viewGroup.getContext()).inflate(this.qOl.qOp.get(i2), viewGroup, false), this.qNG);
        AppMethodBeat.o(181643);
        return a2;
    }
}
