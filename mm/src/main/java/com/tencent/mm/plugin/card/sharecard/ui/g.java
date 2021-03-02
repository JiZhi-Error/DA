package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    Context mContext;
    c pXo;
    List<b> pXz;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(113095);
        b Ed = Ed(i2);
        AppMethodBeat.o(113095);
        return Ed;
    }

    public final int getCount() {
        AppMethodBeat.i(113092);
        int size = this.pXz.size();
        AppMethodBeat.o(113092);
        return size;
    }

    public final b Ed(int i2) {
        AppMethodBeat.i(113093);
        b bVar = this.pXz.get(i2);
        AppMethodBeat.o(113093);
        return bVar;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(113094);
        View a2 = this.pXo.a(i2, view, Ed(i2));
        AppMethodBeat.o(113094);
        return a2;
    }
}
