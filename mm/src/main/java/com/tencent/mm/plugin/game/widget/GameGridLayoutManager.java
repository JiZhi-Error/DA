package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameGridLayoutManager extends GridLayoutManager {
    public GameGridLayoutManager(Context context) {
        super(4);
    }

    public GameGridLayoutManager() {
        super(2, 1);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(42619);
        try {
            super.onLayoutChildren(nVar, sVar);
            AppMethodBeat.o(42619);
        } catch (IndexOutOfBoundsException e2) {
            Log.e("MicroMsg.GameGridLayoutManager", "meet a IOOBE in RecyclerView");
            AppMethodBeat.o(42619);
        }
    }
}
