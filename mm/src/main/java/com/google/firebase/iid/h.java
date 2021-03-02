package com.google.firebase.iid;

import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.google.firebase.iid.Registrar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class h implements d {
    static final d bLy = new h();

    static {
        AppMethodBeat.i(4163);
        AppMethodBeat.o(4163);
    }

    private h() {
    }

    @Override // com.google.firebase.components.d
    public final Object a(b bVar) {
        AppMethodBeat.i(4162);
        Registrar.a aVar = new Registrar.a((FirebaseInstanceId) bVar.y(FirebaseInstanceId.class));
        AppMethodBeat.o(4162);
        return aVar;
    }
}
