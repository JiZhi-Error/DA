package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends BaseAdapter implements b {
    private ListAdapter QkP;
    private DataSetObserver Tr = new DataSetObserver() {
        /* class com.tencent.mm.ui.gridviewheaders.d.AnonymousClass1 */

        public final void onChanged() {
            AppMethodBeat.i(142839);
            d.this.notifyDataSetChanged();
            AppMethodBeat.o(142839);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(142840);
            d.this.notifyDataSetInvalidated();
            AppMethodBeat.o(142840);
        }
    };

    public d(ListAdapter listAdapter) {
        AppMethodBeat.i(142841);
        this.QkP = listAdapter;
        listAdapter.registerDataSetObserver(this.Tr);
        AppMethodBeat.o(142841);
    }

    public final int getCount() {
        AppMethodBeat.i(142842);
        int count = this.QkP.getCount();
        AppMethodBeat.o(142842);
        return count;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(142843);
        Object item = this.QkP.getItem(i2);
        AppMethodBeat.o(142843);
        return item;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(142844);
        long itemId = this.QkP.getItemId(i2);
        AppMethodBeat.o(142844);
        return itemId;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142845);
        View view2 = this.QkP.getView(i2, view, viewGroup);
        AppMethodBeat.o(142845);
        return view2;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final int aob(int i2) {
        return 0;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final int gWs() {
        return 0;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final View a(int i2, View view, ViewGroup viewGroup) {
        return null;
    }
}
