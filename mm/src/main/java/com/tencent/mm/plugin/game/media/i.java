package com.tencent.mm.plugin.game.media;

import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class i extends android.support.v4.app.i {
    private ArrayList<GameGalleryFragment> xAU;

    public i(g gVar, ArrayList<GameGalleryFragment> arrayList) {
        super(gVar);
        this.xAU = arrayList;
    }

    @Override // android.support.v4.app.i
    public final Fragment getItem(int i2) {
        AppMethodBeat.i(40995);
        ArrayList<GameGalleryFragment> arrayList = this.xAU;
        GameGalleryFragment gameGalleryFragment = arrayList.get(i2 % arrayList.size());
        AppMethodBeat.o(40995);
        return gameGalleryFragment;
    }

    @Override // android.support.v4.view.q
    public final int getCount() {
        AppMethodBeat.i(40996);
        int size = this.xAU.size();
        AppMethodBeat.o(40996);
        return size;
    }
}
