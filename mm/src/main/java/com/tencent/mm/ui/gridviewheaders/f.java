package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class f extends BaseAdapter implements b {
    private e QkR;
    private List<b> QkS;

    public f(e eVar) {
        AppMethodBeat.i(142848);
        this.QkR = eVar;
        eVar.registerDataSetObserver(new a(this, (byte) 0));
        this.QkS = a(eVar);
        AppMethodBeat.o(142848);
    }

    public final int getCount() {
        AppMethodBeat.i(142849);
        int count = this.QkR.getCount();
        AppMethodBeat.o(142849);
        return count;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final int aob(int i2) {
        AppMethodBeat.i(142850);
        try {
            int i3 = this.QkS.get(i2).mCount;
            AppMethodBeat.o(142850);
            return i3;
        } catch (IndexOutOfBoundsException e2) {
            AppMethodBeat.o(142850);
            return 0;
        }
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final View a(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142851);
        View a2 = this.QkR.a(this.QkS.get(i2).QkU, view, viewGroup);
        AppMethodBeat.o(142851);
        return a2;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(142852);
        Object item = this.QkR.getItem(i2);
        AppMethodBeat.o(142852);
        return item;
    }

    public final long getItemId(int i2) {
        AppMethodBeat.i(142853);
        long itemId = this.QkR.getItemId(i2);
        AppMethodBeat.o(142853);
        return itemId;
    }

    @Override // com.tencent.mm.ui.gridviewheaders.b
    public final int gWs() {
        AppMethodBeat.i(142854);
        int size = this.QkS.size();
        AppMethodBeat.o(142854);
        return size;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142855);
        View view2 = this.QkR.getView(i2, view, viewGroup);
        AppMethodBeat.o(142855);
        return view2;
    }

    /* access modifiers changed from: protected */
    public final List<b> a(e eVar) {
        AppMethodBeat.i(142856);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < eVar.getCount(); i2++) {
            long EQ = eVar.EQ(i2);
            b bVar = (b) hashMap.get(Long.valueOf(EQ));
            if (bVar == null) {
                bVar = new b(i2);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(EQ), bVar);
        }
        AppMethodBeat.o(142856);
        return arrayList;
    }

    final class a extends DataSetObserver {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b2) {
            this();
        }

        public final void onChanged() {
            AppMethodBeat.i(142846);
            f.this.QkS = f.this.a(f.this.QkR);
            f.this.notifyDataSetChanged();
            AppMethodBeat.o(142846);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(142847);
            f.this.QkS = f.this.a(f.this.QkR);
            f.this.notifyDataSetInvalidated();
            AppMethodBeat.o(142847);
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        int QkU;
        int mCount = 0;

        public b(int i2) {
            this.QkU = i2;
        }
    }
}
