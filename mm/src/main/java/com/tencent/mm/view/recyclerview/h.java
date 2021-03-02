package com.tencent.mm.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;

public class h extends RecyclerView.v {
    private final LinkedHashSet<Integer> RqY = new LinkedHashSet<>();
    private final LinkedHashSet<Integer> RqZ = new LinkedHashSet<>();
    public Object Rra;
    private final Context context;
    public RecyclerView hak = null;
    private RecyclerView.a hbg;
    private Object tag;

    public h(View view) {
        super(view);
        AppMethodBeat.i(164329);
        this.context = view.getContext();
        AppMethodBeat.o(164329);
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        this.hak = recyclerView;
    }

    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(164330);
        if (this.hak != null || !(this.aus.getParent() instanceof RecyclerView)) {
            RecyclerView recyclerView = this.hak;
            AppMethodBeat.o(164330);
            return recyclerView;
        }
        this.hak = (RecyclerView) this.aus.getParent();
        RecyclerView recyclerView2 = this.hak;
        AppMethodBeat.o(164330);
        return recyclerView2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final RecyclerView.a getAdapter() {
        return this.hbg;
    }

    public final h e(int i2, CharSequence charSequence) {
        AppMethodBeat.i(164331);
        ((TextView) Mn(i2)).setText(charSequence);
        AppMethodBeat.o(164331);
        return this;
    }

    public final h nm(int i2, int i3) {
        AppMethodBeat.i(259390);
        ((TextView) Mn(i2)).setText(i3);
        AppMethodBeat.o(259390);
        return this;
    }

    public final h me(int i2, int i3) {
        AppMethodBeat.i(206185);
        ((TextView) Mn(i2)).setTextColor(i3);
        AppMethodBeat.o(206185);
        return this;
    }

    public final h mf(int i2, int i3) {
        AppMethodBeat.i(164334);
        Mn(i2).setVisibility(i3);
        AppMethodBeat.o(164334);
        return this;
    }

    public final h b(RecyclerView.a aVar) {
        this.hbg = aVar;
        return this;
    }

    public final <T extends View> T Mn(int i2) {
        AppMethodBeat.i(164335);
        T t = (T) this.aus.findViewById(i2);
        AppMethodBeat.o(164335);
        return t;
    }

    public final <T> T hgv() {
        return (T) this.Rra;
    }

    public final void et(Object obj) {
        this.Rra = obj;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }
}
