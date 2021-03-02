package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.wearable.PutDataRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgj {
    public static IntentFilter zza(String str, Uri uri, int i2) {
        AppMethodBeat.i(101353);
        IntentFilter intentFilter = new IntentFilter(str);
        if (uri.getScheme() != null) {
            intentFilter.addDataScheme(uri.getScheme());
        }
        if (uri.getAuthority() != null) {
            intentFilter.addDataAuthority(uri.getAuthority(), Integer.toString(uri.getPort()));
        }
        if (uri.getPath() != null) {
            intentFilter.addDataPath(uri.getPath(), i2);
        }
        AppMethodBeat.o(101353);
        return intentFilter;
    }

    public static IntentFilter zzc(String str) {
        AppMethodBeat.i(101352);
        IntentFilter intentFilter = new IntentFilter(str);
        intentFilter.addDataScheme(PutDataRequest.WEAR_URI_SCHEME);
        intentFilter.addDataAuthority("*", null);
        AppMethodBeat.o(101352);
        return intentFilter;
    }
}
