package com.google.firebase.analytics.connector.internal;

import android.content.Context;
import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class a implements d {
    static final d bKD = new a();

    static {
        AppMethodBeat.i(116772);
        AppMethodBeat.o(116772);
    }

    private a() {
    }

    @Override // com.google.firebase.components.d
    public final Object a(b bVar) {
        AppMethodBeat.i(116771);
        com.google.firebase.analytics.connector.a ao = com.google.firebase.analytics.connector.b.ao((Context) bVar.y(Context.class));
        AppMethodBeat.o(116771);
        return ao;
    }
}
