package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
public final class zzhh implements Callable<Boolean> {
    private final /* synthetic */ byte[] zzee;
    private final /* synthetic */ ParcelFileDescriptor zzfg;

    zzhh(zzhg zzhg, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        this.zzfg = parcelFileDescriptor;
        this.zzee = bArr;
    }

    private final Boolean zzd() {
        AppMethodBeat.i(101397);
        if (Log.isLoggable("WearableClient", 3)) {
            String valueOf = String.valueOf(this.zzfg);
            new StringBuilder(String.valueOf(valueOf).length() + 36).append("processAssets: writing data to FD : ").append(valueOf);
        }
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.zzfg);
        try {
            autoCloseOutputStream.write(this.zzee);
            autoCloseOutputStream.flush();
            if (Log.isLoggable("WearableClient", 3)) {
                String valueOf2 = String.valueOf(this.zzfg);
                new StringBuilder(String.valueOf(valueOf2).length() + 27).append("processAssets: wrote data: ").append(valueOf2);
            }
            Boolean bool = Boolean.TRUE;
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf3 = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf3).length() + 24).append("processAssets: closing: ").append(valueOf3);
                }
                autoCloseOutputStream.close();
            } catch (IOException e2) {
            }
            AppMethodBeat.o(101397);
            return bool;
        } catch (IOException e3) {
            String valueOf4 = String.valueOf(this.zzfg);
            new StringBuilder(String.valueOf(valueOf4).length() + 36).append("processAssets: writing data failed: ").append(valueOf4);
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf5 = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf5).length() + 24).append("processAssets: closing: ").append(valueOf5);
                }
                autoCloseOutputStream.close();
            } catch (IOException e4) {
            }
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(101397);
            return bool2;
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf6 = String.valueOf(this.zzfg);
                    new StringBuilder(String.valueOf(valueOf6).length() + 24).append("processAssets: closing: ").append(valueOf6);
                }
                autoCloseOutputStream.close();
            } catch (IOException e5) {
            }
            AppMethodBeat.o(101397);
            throw th;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() {
        AppMethodBeat.i(101398);
        Boolean zzd = zzd();
        AppMethodBeat.o(101398);
        return zzd;
    }
}
