package com.tencent.mm.plugin.gallery.picker.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class c extends i {
    private final ArrayList<Fragment> fragments;

    public c(g gVar, ArrayList<Fragment> arrayList) {
        super(gVar);
        this.fragments = arrayList;
    }

    @Override // android.support.v4.app.i
    public final Fragment getItem(int i2) {
        AppMethodBeat.i(164774);
        Fragment fragment = this.fragments.get(i2);
        AppMethodBeat.o(164774);
        return fragment;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(164775);
        int size = this.fragments.size();
        AppMethodBeat.o(164775);
        return size;
    }
}
