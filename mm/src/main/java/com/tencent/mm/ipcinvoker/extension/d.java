package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements a {
    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof Parcelable;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(158797);
        parcel.writeParcelable((Parcelable) obj, 0);
        AppMethodBeat.o(158797);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        AppMethodBeat.i(158798);
        Parcelable readParcelable = parcel.readParcelable(getClass().getClassLoader());
        AppMethodBeat.o(158798);
        return readParcelable;
    }
}
