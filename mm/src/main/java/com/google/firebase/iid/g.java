package com.google.firebase.iid;

import com.google.firebase.a;
import com.google.firebase.components.b;
import com.google.firebase.components.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final /* synthetic */ class g implements d {
    static final d bLy = new g();

    static {
        AppMethodBeat.i(4161);
        AppMethodBeat.o(4161);
    }

    private g() {
    }

    @Override // com.google.firebase.components.d
    public final Object a(b bVar) {
        AppMethodBeat.i(4160);
        FirebaseInstanceId firebaseInstanceId = new FirebaseInstanceId((a) bVar.y(a.class));
        AppMethodBeat.o(4160);
        return firebaseInstanceId;
    }
}
