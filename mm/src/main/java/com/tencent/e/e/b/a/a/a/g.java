package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g extends e {
    @Override // com.tencent.e.e.b.a.a.e
    public final Intent getIntent() {
        AppMethodBeat.i(224046);
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        AppMethodBeat.o(224046);
        return intent;
    }

    @Override // com.tencent.e.e.b.a.a.e
    public final String a(Context context, IBinder iBinder) {
        AppMethodBeat.i(224047);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
            AppMethodBeat.o(224047);
        }
    }
}
