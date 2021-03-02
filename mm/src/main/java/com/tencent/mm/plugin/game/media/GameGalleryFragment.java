package com.tencent.mm.plugin.game.media;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameGalleryFragment extends Fragment {
    View mView;
    private int xzP;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(40905);
        Log.i("MicroMsg.GameGalleryFragment", "onCreateView");
        if (this.mView != null) {
            View view = this.mView;
            AppMethodBeat.o(40905);
            return view;
        }
        View inflate = layoutInflater.inflate(this.xzP, viewGroup);
        AppMethodBeat.o(40905);
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(40906);
        Log.i("MicroMsg.GameGalleryFragment", "onViewCreated");
        AppMethodBeat.o(40906);
    }
}
