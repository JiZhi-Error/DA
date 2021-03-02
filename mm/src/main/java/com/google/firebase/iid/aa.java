package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class aa implements l {
    private final FirebaseInstanceId bMu;
    private final String bMv;
    private final String bMw;

    aa(FirebaseInstanceId firebaseInstanceId, String str, String str2) {
        this.bMu = firebaseInstanceId;
        this.bMv = str;
        this.bMw = str2;
    }

    @Override // com.google.firebase.iid.l
    public final String zzp() {
        AppMethodBeat.i(4229);
        FirebaseInstanceId firebaseInstanceId = this.bMu;
        String str = this.bMv;
        String str2 = this.bMw;
        String str3 = (String) FirebaseInstanceId.a(firebaseInstanceId.bLk.q(str, str2));
        FirebaseInstanceId.bLg.b("", str, str2, str3, firebaseInstanceId.bLj.yn());
        AppMethodBeat.o(4229);
        return str3;
    }
}
