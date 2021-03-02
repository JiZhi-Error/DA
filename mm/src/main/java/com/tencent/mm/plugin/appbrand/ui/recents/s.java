package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/* access modifiers changed from: package-private */
public abstract class s<_Data, _ViewHolder extends RecyclerView.v> {
    public abstract _ViewHolder a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract void b(_ViewHolder _viewholder, _Data _data);

    public abstract long cL(_Data _data);

    s() {
    }

    public boolean a(_ViewHolder _viewholder, Object obj) {
        return false;
    }
}
