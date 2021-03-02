package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class p extends BaseAdapter {
    private SparseArray<a> NOO;
    public n PWg;
    boolean PWh;
    boolean PWi;
    protected int scene;

    /* access modifiers changed from: protected */
    public abstract a va(int i2);

    public p(n nVar, boolean z, int i2, boolean z2) {
        this.PWg = nVar;
        this.PWh = z;
        this.NOO = new SparseArray<>();
        this.scene = i2;
        this.PWi = z2;
    }

    public p(n nVar, boolean z, int i2) {
        this(nVar, z, i2, false);
    }

    public final n hYG() {
        return this.PWg;
    }

    public boolean eWh() {
        return this.PWh;
    }

    public int gUt() {
        return 0;
    }

    public final void hYH() {
        this.PWh = true;
    }

    public final void Cp(boolean z) {
        this.PWh = z;
        notifyDataSetChanged();
    }

    /* renamed from: anH */
    public final a getItem(int i2) {
        if (this.NOO.indexOfKey(i2) >= 0) {
            return this.NOO.get(i2);
        }
        if (i2 < 0 || i2 >= getCount()) {
            Log.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i2));
            return null;
        }
        a va = va(i2);
        if (va != null) {
            va.poB = c(va);
            this.NOO.put(i2, va);
            Log.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", Integer.valueOf(va.qcr), Integer.valueOf(i2));
            return va;
        }
        Log.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", Integer.valueOf(i2));
        return va;
    }

    /* access modifiers changed from: protected */
    public boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i2) {
        return -1;
    }

    public int getItemViewType(int i2) {
        if (getItem(i2) != null) {
            return getItem(i2).qcr;
        }
        Log.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", Integer.valueOf(getCount()), Integer.valueOf(i2));
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        a anH = getItem(i2);
        if (view == null) {
            view = anH.bmx().a(this.PWg.getActivity(), viewGroup);
        }
        a.C2110a aVar = (a.C2110a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!anH.PZZ) {
            anH.a(this.PWg.getActivity(), aVar);
            anH.PZZ = true;
        }
        anH.PWh = eWh();
        anH.bmx().a(this.PWg.getActivity(), aVar, anH, this.PWg.b(anH), this.PWg.a(anH));
        return view;
    }

    public final void clearCache() {
        if (this.NOO != null) {
            this.NOO.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean anI(int i2) {
        return false;
    }
}
