package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.a;

public final class d implements a {
    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final boolean bp(Object obj) {
        return obj instanceof Parcel;
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final void a(Object obj, Parcel parcel) {
        AppMethodBeat.i(146414);
        Parcel parcel2 = (Parcel) obj;
        parcel2.setDataPosition(0);
        parcel.writeInt(parcel2.dataSize());
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        AppMethodBeat.o(146414);
    }

    @Override // com.tencent.mm.ipcinvoker.extension.a
    public final Object d(Parcel parcel) {
        AppMethodBeat.i(146415);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.appendFrom(parcel, parcel.dataPosition(), parcel.readInt());
        obtain.setDataPosition(0);
        AppMethodBeat.o(146415);
        return obtain;
    }
}
