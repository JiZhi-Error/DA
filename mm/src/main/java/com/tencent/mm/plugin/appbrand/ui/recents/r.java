package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class r extends RecyclerView.a {
    private final ArrayList<?> mDataList;
    private LayoutInflater mInflater;
    final SparseArray<s> oey = new SparseArray<>();

    r(ArrayList<?> arrayList) {
        AppMethodBeat.i(49283);
        this.mDataList = arrayList;
        AppMethodBeat.o(49283);
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        AppMethodBeat.i(49284);
        if (this.mDataList == null || Util.isNullOrNil(this.mDataList)) {
            AppMethodBeat.o(49284);
            return true;
        }
        AppMethodBeat.o(49284);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Object zy(int i2) {
        AppMethodBeat.i(49285);
        if (i2 < 0 || i2 >= getItemCount()) {
            AppMethodBeat.o(49285);
            return null;
        }
        Object obj = this.mDataList.get(i2);
        AppMethodBeat.o(49285);
        return obj;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(49286);
        s sVar = this.oey.get(i2);
        if (sVar == null) {
            AppMethodBeat.o(49286);
            return null;
        }
        Context context = viewGroup.getContext();
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(context);
        }
        RecyclerView.v a2 = sVar.a(this.mInflater, viewGroup);
        AppMethodBeat.o(49286);
        return a2;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(49287);
        s sVar = this.oey.get(getItemViewType(i2));
        if (sVar != null) {
            sVar.b(vVar, zy(i2));
        }
        AppMethodBeat.o(49287);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2, List list) {
        AppMethodBeat.i(49288);
        s sVar = this.oey.get(getItemViewType(i2));
        if (sVar == null) {
            super.a(vVar, i2, list);
            AppMethodBeat.o(49288);
            return;
        }
        if (list.size() > 0) {
            zy(i2);
            if (sVar.a(vVar, list.get(0))) {
                AppMethodBeat.o(49288);
                return;
            }
        }
        sVar.b(vVar, zy(i2));
        AppMethodBeat.o(49288);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(49289);
        Object zy = zy(i2);
        if (zy == null) {
            AppMethodBeat.o(49289);
            return 0;
        }
        int hashCode = zy.getClass().hashCode();
        AppMethodBeat.o(49289);
        return hashCode;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final long getItemId(int i2) {
        AppMethodBeat.i(49290);
        Object zy = zy(i2);
        s sVar = this.oey.get(getItemViewType(i2));
        if (zy == null || sVar == null) {
            AppMethodBeat.o(49290);
            return 0;
        }
        long cL = sVar.cL(zy);
        AppMethodBeat.o(49290);
        return cL;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(49291);
        if (this.mDataList == null) {
            AppMethodBeat.o(49291);
            return 0;
        }
        int size = this.mDataList.size();
        AppMethodBeat.o(49291);
        return size;
    }
}
