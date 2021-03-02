package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzb {
    private SharedPreferences zzs;

    public zzb(Context context) {
        AppMethodBeat.i(53030);
        try {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            this.zzs = remoteContext == null ? null : remoteContext.getSharedPreferences("google_ads_flags", 0);
            AppMethodBeat.o(53030);
        } catch (Throwable th) {
            this.zzs = null;
            AppMethodBeat.o(53030);
        }
    }

    public final boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(53031);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(53031);
                return false;
            }
            boolean z2 = this.zzs.getBoolean(str, false);
            AppMethodBeat.o(53031);
            return z2;
        } catch (Throwable th) {
            AppMethodBeat.o(53031);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final float getFloat(String str, float f2) {
        AppMethodBeat.i(53032);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(53032);
                return 0.0f;
            }
            float f3 = this.zzs.getFloat(str, 0.0f);
            AppMethodBeat.o(53032);
            return f3;
        } catch (Throwable th) {
            AppMethodBeat.o(53032);
            return 0.0f;
        }
    }

    /* access modifiers changed from: package-private */
    public final String getString(String str, String str2) {
        AppMethodBeat.i(53033);
        try {
            if (this.zzs == null) {
                AppMethodBeat.o(53033);
                return str2;
            }
            String string = this.zzs.getString(str, str2);
            AppMethodBeat.o(53033);
            return string;
        } catch (Throwable th) {
            AppMethodBeat.o(53033);
            return str2;
        }
    }
}
