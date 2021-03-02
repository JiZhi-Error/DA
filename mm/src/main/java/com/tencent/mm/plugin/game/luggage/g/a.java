package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends i {
    public a(j jVar, Bundle bundle) {
        super(jVar, null, bundle);
        AppMethodBeat.i(83116);
        LK();
        ((h) this.ITd).setShouldCleanPkgWhenDestroy(true);
        this.mContentView.setTag("game_float_view_tag");
        AppMethodBeat.o(83116);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.luggage.d.s, com.tencent.mm.plugin.webview.luggage.g
    public final View Lf() {
        AppMethodBeat.i(83117);
        View Lf = super.Lf();
        this.ITf.setBackgroundColor(0);
        AppMethodBeat.o(83117);
        return Lf;
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.luggage.d.h, com.tencent.mm.plugin.webview.luggage.g
    public final void onForeground() {
        AppMethodBeat.i(83118);
        Log.i("MicroMsg.GameFloatLayerWebPage", "onForeground");
        super.onForeground();
        ec("微信游戏", 0);
        l lVar = this.ITe;
        lVar.setPullDownEnabled(false);
        lVar.IUf.setVisibility(8);
        lVar.IUe.setBackgroundColor(0);
        lVar.setBackgroundColor(0);
        AppMethodBeat.o(83118);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final void pJ(boolean z) {
        AppMethodBeat.i(186931);
        super.pJ(z);
        AppMethodBeat.o(186931);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final void dTA() {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.g
    public final void azH(String str) {
        AppMethodBeat.i(83119);
        this.ITe.setPullDownEnabled(false);
        AppMethodBeat.o(83119);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.g
    public final boolean cpz() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.g
    public final void ec(String str, int i2) {
        AppMethodBeat.i(83120);
        super.ec("微信游戏", i2);
        AppMethodBeat.o(83120);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.i, com.tencent.mm.plugin.webview.luggage.g
    public final void D(int i2, String str, String str2) {
        AppMethodBeat.i(180135);
        hb(false);
        AppMethodBeat.o(180135);
    }

    @Override // com.tencent.luggage.d.h, com.tencent.luggage.d.s
    public final boolean onBackPressed() {
        AppMethodBeat.i(186932);
        gbL();
        AppMethodBeat.o(186932);
        return true;
    }
}
