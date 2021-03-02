package com.tencent.e.e.b.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends e {
    @Override // com.tencent.e.e.b.a.a.e
    public final Intent getIntent() {
        AppMethodBeat.i(138439);
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        AppMethodBeat.o(138439);
        return intent;
    }

    @Override // com.tencent.e.e.b.a.a.e
    public final String a(Context context, IBinder iBinder) {
        AppMethodBeat.i(138440);
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
            AppMethodBeat.o(138440);
        }
    }
}
