package com.tencent.mm.ipcinvoker.extension;

import android.os.Bundle;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.o;

public final class b implements a {
    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof a;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(158790);
        a aVar = (a) obj;
        parcel.writeString(aVar.getClass().getName());
        parcel.writeBundle(aVar.toBundle());
        AppMethodBeat.o(158790);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        AppMethodBeat.i(158791);
        String readString = parcel.readString();
        Bundle readBundle = parcel.readBundle();
        a aVar = (a) o.c(readString, a.class);
        if (aVar != null) {
            aVar.fromBundle(readBundle);
            AppMethodBeat.o(158791);
            return aVar;
        }
        AppMethodBeat.o(158791);
        return null;
    }
}
