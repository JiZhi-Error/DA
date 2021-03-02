package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.d;

public final class e {
    d IIH;

    public e(d dVar) {
        this.IIH = dVar;
    }

    public final void onResume() {
        AppMethodBeat.i(80796);
        this.IIH.onResume();
        AppMethodBeat.o(80796);
    }

    public final void onPause() {
        AppMethodBeat.i(80797);
        this.IIH.onPause();
        AppMethodBeat.o(80797);
    }

    public final void c(Bundle bundle, int i2) {
        AppMethodBeat.i(80798);
        this.IIH.s(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"), bundle.getInt("websearch_is_test_draw_json"), i2);
        AppMethodBeat.o(80798);
    }

    public final void bh(Bundle bundle) {
        AppMethodBeat.i(80799);
        this.IIH.aWY((String) bundle.get("widgetId"));
        AppMethodBeat.o(80799);
    }

    public final void bi(Bundle bundle) {
        AppMethodBeat.i(80800);
        this.IIH.aWZ(bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.o(80800);
    }

    public final void bj(Bundle bundle) {
        AppMethodBeat.i(80801);
        this.IIH.lG(bundle.getString("fts_key_json_data"), bundle.getString("fts_key_widget_view_cache_key"));
        AppMethodBeat.o(80801);
    }

    public final void onDestroy() {
        AppMethodBeat.i(80802);
        this.IIH.onDestroy();
        AppMethodBeat.o(80802);
    }
}
