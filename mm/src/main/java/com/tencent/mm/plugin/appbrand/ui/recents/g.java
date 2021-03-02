package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class g {
    public final View aus;
    private ThreeDotsLoadingView odq = ((ThreeDotsLoadingView) this.aus.findViewById(R.id.epy));
    View odr = this.aus.findViewById(R.id.d8y);
    private View ods = this.aus.findViewById(R.id.c3u);

    public final boolean bYD() {
        AppMethodBeat.i(227733);
        if (this.odq == null || !this.odq.isShown()) {
            AppMethodBeat.o(227733);
            return false;
        }
        AppMethodBeat.o(227733);
        return true;
    }

    public final void iT(boolean z) {
        AppMethodBeat.i(49139);
        if (z) {
            if (this.odq != null) {
                this.odq.setVisibility(0);
                this.odq.gZh();
            }
            if (this.ods != null) {
                this.ods.setVisibility(8);
                AppMethodBeat.o(49139);
                return;
            }
        } else {
            if (this.odq != null) {
                this.odq.gZi();
                this.odq.setVisibility(8);
            }
            if (this.ods != null) {
                this.ods.setVisibility(0);
            }
        }
        AppMethodBeat.o(49139);
    }

    public g(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(49140);
        this.aus = LayoutInflater.from(context).inflate(R.layout.ez, viewGroup, false);
        AppMethodBeat.o(49140);
    }

    public final void onDetached() {
        this.odq = null;
        this.ods = null;
    }

    public final View bYp() {
        return this.aus;
    }

    public final void bYE() {
        AppMethodBeat.i(49141);
        if (this.odr != null) {
            this.odr.setBackgroundResource(R.color.ac_);
        }
        AppMethodBeat.o(49141);
    }
}
