package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleApiAvailabilityCache {
    private final SparseIntArray zzug;
    private GoogleApiAvailabilityLight zzuh;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
        AppMethodBeat.i(11839);
        AppMethodBeat.o(11839);
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        AppMethodBeat.i(11840);
        this.zzug = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zzuh = googleApiAvailabilityLight;
        AppMethodBeat.o(11840);
    }

    public void flush() {
        AppMethodBeat.i(11842);
        this.zzug.clear();
        AppMethodBeat.o(11842);
    }

    public int getClientAvailability(Context context, Api.Client client) {
        int i2;
        AppMethodBeat.i(11841);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        if (!client.requiresGooglePlayServices()) {
            AppMethodBeat.o(11841);
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i3 = this.zzug.get(minApkVersion, -1);
        if (i3 != -1) {
            AppMethodBeat.o(11841);
            return i3;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= this.zzug.size()) {
                i2 = i3;
                break;
            }
            int keyAt = this.zzug.keyAt(i4);
            if (keyAt > minApkVersion && this.zzug.get(keyAt) == 0) {
                i2 = 0;
                break;
            }
            i4++;
        }
        if (i2 == -1) {
            i2 = this.zzuh.isGooglePlayServicesAvailable(context, minApkVersion);
        }
        this.zzug.put(minApkVersion, i2);
        AppMethodBeat.o(11841);
        return i2;
    }
}
