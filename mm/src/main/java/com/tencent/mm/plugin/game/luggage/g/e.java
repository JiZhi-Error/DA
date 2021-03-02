package com.tencent.mm.plugin.game.luggage.g;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.v;

public final class e extends v {
    public boolean xxO = false;
    public a xxP;

    public interface a {
        boolean Lw();

        void dTp();

        void dTq();
    }

    public e(Activity activity) {
        super(activity);
        AppMethodBeat.i(83126);
        this.ctk = h.class;
        this.ctn.E(com.tencent.mm.plugin.game.luggage.b.a.dTr());
        AppMethodBeat.o(83126);
    }

    @Override // com.tencent.luggage.d.i
    public final void Lu() {
        AppMethodBeat.i(186933);
        super.Lu();
        this.xxO = true;
        if (this.xxP != null) {
            this.xxP.dTp();
        }
        AppMethodBeat.o(186933);
    }

    @Override // com.tencent.luggage.d.i
    public final void Lv() {
        AppMethodBeat.i(186934);
        super.Lv();
        this.xxO = false;
        if (this.xxP != null) {
            this.xxP.dTq();
        }
        AppMethodBeat.o(186934);
    }

    @Override // com.tencent.luggage.d.i
    public final boolean Lw() {
        AppMethodBeat.i(186935);
        if (this.xxP != null) {
            boolean Lw = this.xxP.Lw();
            AppMethodBeat.o(186935);
            return Lw;
        }
        boolean Lw2 = super.Lw();
        AppMethodBeat.o(186935);
        return Lw2;
    }
}
