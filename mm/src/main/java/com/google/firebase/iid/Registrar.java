package com.google.firebase.iid;

import android.support.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.a;
import com.google.firebase.components.e;
import com.google.firebase.components.f;
import com.google.firebase.components.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
public final class Registrar implements e {

    static class a implements com.google.firebase.iid.a.a {
        private final FirebaseInstanceId bLr;

        public a(FirebaseInstanceId firebaseInstanceId) {
            this.bLr = firebaseInstanceId;
        }
    }

    @Override // com.google.firebase.components.e
    @Keep
    public final List<com.google.firebase.components.a<?>> getComponents() {
        AppMethodBeat.i(4148);
        a.C0121a a2 = com.google.firebase.components.a.z(FirebaseInstanceId.class).a(f.B(com.google.firebase.a.class)).a(g.bLy);
        r.b(a2.zzad == 0, "Instantiation type has already been set.");
        a2.zzad = 1;
        List<com.google.firebase.components.a<?>> asList = Arrays.asList(a2.xZ(), com.google.firebase.components.a.z(com.google.firebase.iid.a.a.class).a(f.B(FirebaseInstanceId.class)).a(h.bLy).xZ());
        AppMethodBeat.o(4148);
        return asList;
    }
}
