package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.o;

public final class g implements a {
    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof f;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(158812);
        f fVar = (f) obj;
        parcel.writeString(fVar.getClass().getName());
        fVar.e(parcel);
        AppMethodBeat.o(158812);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        AppMethodBeat.i(158813);
        f fVar = (f) o.c(parcel.readString(), f.class);
        if (fVar != null) {
            fVar.readFromParcel(parcel);
            AppMethodBeat.o(158813);
            return fVar;
        }
        AppMethodBeat.o(158813);
        return null;
    }
}
