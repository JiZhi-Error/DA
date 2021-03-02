package com.tencent.e.e.b.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.tencent.e.e.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends e {
    @Override // com.tencent.e.e.b.a.a.e
    public final Intent getIntent() {
        AppMethodBeat.i(138443);
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        AppMethodBeat.o(138443);
        return intent;
    }

    @Override // com.tencent.e.e.b.a.a.e
    public final String a(Context context, IBinder iBinder) {
        String str;
        int i2 = 0;
        AppMethodBeat.i(138444);
        String packageName = context.getPackageName();
        Signature[] cQ = b.cQ(context, packageName);
        if (cQ != null) {
            int length = cQ.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Signature signature = cQ[i2];
                if (AndroidUtilsLight.DIGEST_ALGORITHM_SHA1.equals(AndroidUtilsLight.DIGEST_ALGORITHM_SHA1)) {
                    str = b.a(signature, AndroidUtilsLight.DIGEST_ALGORITHM_SHA1);
                    break;
                }
                i2++;
            }
        }
        str = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
            obtain.writeString(packageName);
            obtain.writeString(str);
            obtain.writeString("OUID");
            iBinder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
            AppMethodBeat.o(138444);
        }
    }
}
