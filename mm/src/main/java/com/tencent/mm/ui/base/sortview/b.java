package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.sortview.a;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    protected SparseArray<a> OZO;
    protected Runnable OZP;
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract a CY(int i2);

    /* access modifiers changed from: protected */
    public abstract Object[] CZ(int i2);

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.OZO = new SparseArray<>();
        this.OZP = new Runnable() {
            /* class com.tencent.mm.ui.base.sortview.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(142686);
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(142686);
            }
        };
    }

    public int getCount() {
        return this.OZO.size();
    }

    public int getItemViewType(int i2) {
        if (getItem(i2) == null) {
            Log.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", Integer.valueOf(getCount()), Integer.valueOf(i2));
            return 0;
        } else if (getItem(i2) == null) {
            return 0;
        } else {
            return getItem(i2).type;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    /* renamed from: Dc */
    public a getItem(int i2) {
        if (i2 < 0 || i2 > getCount()) {
            Log.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", Integer.valueOf(i2));
            return null;
        }
        a aVar = this.OZO.get(i2);
        if (aVar != null) {
            return aVar;
        }
        a CY = CY(i2);
        this.OZO.put(i2, CY);
        return CY;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        a.AbstractC2082a aVar;
        long currentTimeMillis = System.currentTimeMillis();
        a Dc = getItem(i2);
        if (Dc == null) {
            Log.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            a.b clS = Dc.clS();
            if (clS == null) {
                Log.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                if (view == null) {
                    view = clS.c(this.mContext, view);
                    aVar = Dc.clT();
                    clS.a(view, aVar);
                    view.setTag(aVar);
                } else {
                    aVar = (a.AbstractC2082a) view.getTag();
                }
                Object[] CZ = CZ(i2);
                Assert.assertNotNull(aVar);
                if (!Dc.gLT()) {
                    Dc.a(this.mContext, aVar, CZ);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                clS.a(this.mContext, aVar, Dc);
                Log.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", Integer.valueOf(i2), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
            }
        }
        return view;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        a Dc = getItem(i2);
        if (Dc == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            return;
        }
        a.b clS = Dc.clS();
        if (clS == null) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        } else if (clS.a(this.mContext, Dc, CZ(i2))) {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        } else {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        }
    }
}
