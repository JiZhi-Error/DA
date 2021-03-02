package com.tencent.mm.pluginsdk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.ui.widget.snackbar.a;

public final class f implements v {
    @Override // com.tencent.mm.plugin.fav.a.v
    public final void a(int i2, int i3, Activity activity, a.b bVar) {
        AppMethodBeat.i(232139);
        e.a(i2, activity, bVar);
        AppMethodBeat.o(232139);
    }
}
