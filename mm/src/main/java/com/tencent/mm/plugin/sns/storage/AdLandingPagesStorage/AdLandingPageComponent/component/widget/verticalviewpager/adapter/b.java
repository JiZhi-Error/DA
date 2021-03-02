package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b extends i {
    public List<Fragment> fragments = new ArrayList();

    public b(g gVar, List<Fragment> list) {
        super(gVar);
        AppMethodBeat.i(97124);
        this.fragments = list;
        AppMethodBeat.o(97124);
    }

    @Override // android.support.v4.app.i
    public final Fragment getItem(int i2) {
        AppMethodBeat.i(97125);
        Fragment fragment = this.fragments.get(i2);
        AppMethodBeat.o(97125);
        return fragment;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(97126);
        int size = this.fragments.size();
        AppMethodBeat.o(97126);
        return size;
    }

    @Override // android.support.v4.view.q
    public final CharSequence getPageTitle(int i2) {
        return "";
    }

    public final void c(Fragment fragment, int i2) {
        AppMethodBeat.i(97127);
        this.fragments.remove(fragment);
        if (i2 >= this.fragments.size()) {
            this.fragments.add(fragment);
            AppMethodBeat.o(97127);
            return;
        }
        this.fragments.add(i2, fragment);
        AppMethodBeat.o(97127);
    }
}
