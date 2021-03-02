package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.j;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.q;
import com.tencent.mm.plugin.fts.ui.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class d extends BaseAdapter implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private int count;
    private AbsListView.OnScrollListener qqo;
    String query;
    private HashMap<String, Boolean> vtH = new HashMap<>();
    e xaG;
    private SparseArray<com.tencent.mm.plugin.fts.a.d.a.a> xaH;
    long xaI;
    a xaJ;

    public interface a {
        void ay(int i2, boolean z);
    }

    /* access modifiers changed from: protected */
    public abstract com.tencent.mm.plugin.fts.a.d.a.a No(int i2);

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z);

    /* access modifiers changed from: protected */
    public abstract void dPb();

    public final Context getContext() {
        return this.xaG.getContext();
    }

    public final e dPg() {
        return this.xaG;
    }

    public d(e eVar) {
        Log.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.xaG = eVar;
        this.xaH = new SparseArray<>();
    }

    /* access modifiers changed from: protected */
    public final void setCount(int i2) {
        Log.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", Integer.valueOf(i2));
        this.count = i2;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i2) {
        if (getItem(i2) != null) {
            return getItem(i2).qcr;
        }
        Log.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i2));
        return -1;
    }

    public int getViewTypeCount() {
        return 15;
    }

    /* access modifiers changed from: private */
    /* renamed from: Nq */
    public com.tencent.mm.plugin.fts.a.d.a.a getItem(int i2) {
        com.tencent.mm.plugin.fts.a.d.a.a aVar = null;
        if (this.xaH.indexOfKey(i2) >= 0) {
            return this.xaH.get(i2);
        }
        if (i2 >= 0 && i2 < getCount()) {
            aVar = No(i2);
        }
        if (aVar == null) {
            return this.xaH.get(0);
        }
        this.xaH.put(i2, aVar);
        return aVar;
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.fts.a.d.a.a Nq = getItem(i2);
        if (view == null) {
            view = Nq.axc().a(getContext(), viewGroup);
        }
        a.AbstractC1374a aVar = (a.AbstractC1374a) view.getTag();
        if (!Nq.wXJ) {
            Nq.a(getContext(), aVar, new Object[0]);
            a(getContext(), Nq);
            Nq.wXJ = true;
        }
        Nq.axc().a(getContext(), aVar, Nq, new Object[0]);
        return view;
    }

    public final String getQuery() {
        return this.query;
    }

    public final void auV(String str) {
        stopSearch();
        this.xaI = System.currentTimeMillis();
        this.query = str;
        Log.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", str);
        dPb();
    }

    public void stopSearch() {
        this.count = 0;
        this.query = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(this.vtH.keySet());
        Cursor a2 = ((l) g.af(l.class)).aST().a(arrayList, ab.iCF, (List<String>) null, "hidden_conv_parent");
        if (a2 != null) {
            while (a2.moveToNext()) {
                az azVar = new az();
                azVar.convertFrom(a2);
                h.INSTANCE.a(21170, 1, azVar.field_username, Integer.valueOf(ac.JT(azVar.field_username)));
            }
            a2.close();
        }
    }

    /* access modifiers changed from: protected */
    public void clearCache() {
        this.xaH.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (this.qqo != null) {
            this.qqo.onScrollStateChanged(absListView, i2);
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        if (this.qqo != null) {
            this.qqo.onScroll(absListView, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public final void ax(int i2, boolean z) {
        if (this.xaJ != null) {
            this.xaJ.ay(i2, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        b bVar = new b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.xaG.hideVKB();
        com.tencent.mm.plugin.fts.a.d.a.a Nq = getItem(i2 - this.xaG.getListView().getHeaderViewsCount());
        if (Nq != null) {
            this.xaG.a(Nq, a(view, Nq, Nq.axc().a(getContext(), view, Nq)));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBaseAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        if (aVar instanceof r) {
            this.vtH.put(((r) aVar).username, Boolean.TRUE);
        } else if (aVar instanceof q) {
            this.vtH.put(((q) aVar).username, Boolean.TRUE);
        } else if (aVar instanceof m) {
            this.vtH.put(((m) aVar).username, Boolean.TRUE);
        } else if (aVar instanceof j) {
            int i2 = ((j) aVar).xdl.field_featureId;
            if (i2 == 23) {
                this.vtH.put("qqmail", Boolean.TRUE);
            } else if (i2 == 27) {
                this.vtH.put("masssendapp", Boolean.TRUE);
            } else if (i2 == 28) {
                this.vtH.put("newsapp", Boolean.TRUE);
            } else if (i2 == 39) {
                this.vtH.put("filehelper", Boolean.TRUE);
            } else if (i2 == 43) {
                this.vtH.put("gh_43f2581f6fd6", Boolean.TRUE);
            } else if (i2 == 71) {
                this.vtH.put("appbrand_notify_message", Boolean.TRUE);
            } else if (i2 == 69) {
                this.vtH.put("appbrandcustomerservicemsg", Boolean.TRUE);
            } else if (i2 == 50 || i2 == 63 || i2 == 67) {
                this.vtH.put("officialaccounts", Boolean.TRUE);
            }
        } else if (aVar instanceof c) {
            this.vtH.put(((c) aVar).getUserName(), Boolean.TRUE);
        }
    }

    /* access modifiers changed from: protected */
    public int dOI() {
        return getCount();
    }
}
