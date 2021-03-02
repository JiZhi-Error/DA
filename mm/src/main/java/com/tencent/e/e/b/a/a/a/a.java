package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends e {
    @Override // com.tencent.e.e.b.a.a.e
    public final Intent getIntent() {
        AppMethodBeat.i(138435);
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setClassName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
        AppMethodBeat.o(138435);
        return intent;
    }

    @Override // com.tencent.e.e.b.a.a.e
    public final String a(Context context, IBinder iBinder) {
        AppMethodBeat.i(138436);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            iBinder.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
            AppMethodBeat.o(138436);
        }
    }
}
