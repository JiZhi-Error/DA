package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    int FbA;
    protected Context mContext;
    ArrayList<Object> mItems = new ArrayList<>();

    protected b(Context context) {
        this.mContext = context;
        this.FbA = 3;
    }

    public void hl(List<?> list) {
        clear();
        hk(list);
        this.mItems.addAll(list);
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        dT(obj);
        this.mItems.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i2, Object obj) {
        dT(obj);
        this.mItems.add(i2, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.mItems.size();
    }

    public Object getItem(int i2) {
        return this.mItems.get(i2);
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.d
    public final int getColumnCount() {
        return this.FbA;
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.d
    public void iT(int i2, int i3) {
        if (i3 < getCount()) {
            ArrayList<Object> arrayList = this.mItems;
            arrayList.add(i3, arrayList.remove(i2));
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.d
    public boolean aaf(int i2) {
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ui.previewimageview.d
    public boolean aag(int i2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.mContext;
    }

    public void clear() {
        this.Fbz.clear();
        this.mItems.clear();
        notifyDataSetChanged();
    }
}
