package com.google.android.gms.internal.stable;

import android.content.ContentResolver;
import android.net.Uri;
import com.google.android.gms.internal.stable.zze;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zze.zza {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.settings/partner");

    static {
        AppMethodBeat.i(5500);
        AppMethodBeat.o(5500);
    }

    public static int getInt(ContentResolver contentResolver, String str, int i2) {
        int i3 = -1;
        AppMethodBeat.i(5499);
        String string = getString(contentResolver, str);
        if (string != null) {
            try {
                i3 = Integer.parseInt(string);
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(5499);
        return i3;
    }

    private static String getString(ContentResolver contentResolver, String str) {
        AppMethodBeat.i(5497);
        String zza = zza(contentResolver, CONTENT_URI, str);
        AppMethodBeat.o(5497);
        return zza;
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        AppMethodBeat.i(5498);
        String string = getString(contentResolver, str);
        if (string != null) {
            str2 = string;
        }
        AppMethodBeat.o(5498);
        return str2;
    }
}
