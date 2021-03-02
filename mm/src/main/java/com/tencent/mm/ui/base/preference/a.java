package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends h {
    private SparseArray<View> OXo = new SparseArray<>();

    public a(Context context, ListView listView, SharedPreferences sharedPreferences) {
        super(context, listView, sharedPreferences);
        AppMethodBeat.i(142508);
        AppMethodBeat.o(142508);
    }

    @Override // com.tencent.mm.ui.base.preference.h
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(142509);
        View view2 = super.getView(i2, view, viewGroup);
        this.OXo.put(i2, view2);
        AppMethodBeat.o(142509);
        return view2;
    }

    public final View a(int i2, ListView listView) {
        AppMethodBeat.i(142510);
        if (i2 > listView.getLastVisiblePosition() || i2 < listView.getFirstVisiblePosition()) {
            AppMethodBeat.o(142510);
            return null;
        }
        View view = this.OXo.get(i2);
        AppMethodBeat.o(142510);
        return view;
    }
}
