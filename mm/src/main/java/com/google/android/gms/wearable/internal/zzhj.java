package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzhj implements Runnable {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ long zzcq;
    private final /* synthetic */ long zzcr;
    private final /* synthetic */ String zzcs;
    private final /* synthetic */ BaseImplementation.ResultHolder zzfh;
    private final /* synthetic */ zzhg zzfi;

    zzhj(zzhg zzhg, Uri uri, BaseImplementation.ResultHolder resultHolder, String str, long j2, long j3) {
        this.zzfi = zzhg;
        this.zzco = uri;
        this.zzfh = resultHolder;
        this.zzcs = str;
        this.zzcq = j2;
        this.zzcr = j3;
    }

    public final void run() {
        AppMethodBeat.i(101400);
        Log.isLoggable("WearableClient", 2);
        if (!"file".equals(this.zzco.getScheme())) {
            this.zzfh.setFailedResult(new Status(10, "Channel.sendFile used with non-file URI"));
            AppMethodBeat.o(101400);
            return;
        }
        File file = new File(this.zzco.getPath());
        try {
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
            try {
                ((zzep) this.zzfi.getService()).zza(new zzhc(this.zzfh), this.zzcs, open, this.zzcq, this.zzcr);
                try {
                    open.close();
                    AppMethodBeat.o(101400);
                } catch (IOException e2) {
                    AppMethodBeat.o(101400);
                }
            } catch (RemoteException e3) {
                this.zzfh.setFailedResult(new Status(8));
                try {
                    open.close();
                    AppMethodBeat.o(101400);
                } catch (IOException e4) {
                    AppMethodBeat.o(101400);
                }
            } catch (Throwable th) {
                try {
                    open.close();
                } catch (IOException e5) {
                }
                AppMethodBeat.o(101400);
                throw th;
            }
        } catch (FileNotFoundException e6) {
            String valueOf = String.valueOf(file);
            new StringBuilder(String.valueOf(valueOf).length() + 46).append("File couldn't be opened for Channel.sendFile: ").append(valueOf);
            this.zzfh.setFailedResult(new Status(13));
            AppMethodBeat.o(101400);
        }
    }
}
