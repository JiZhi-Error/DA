package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* access modifiers changed from: package-private */
public final class zzhi implements Runnable {
    private final /* synthetic */ Uri zzco;
    private final /* synthetic */ boolean zzcp;
    private final /* synthetic */ String zzcs;
    private final /* synthetic */ BaseImplementation.ResultHolder zzfh;
    private final /* synthetic */ zzhg zzfi;

    zzhi(zzhg zzhg, Uri uri, BaseImplementation.ResultHolder resultHolder, boolean z, String str) {
        this.zzfi = zzhg;
        this.zzco = uri;
        this.zzfh = resultHolder;
        this.zzcp = z;
        this.zzcs = str;
    }

    public final void run() {
        AppMethodBeat.i(101399);
        Log.isLoggable("WearableClient", 2);
        if (!"file".equals(this.zzco.getScheme())) {
            this.zzfh.setFailedResult(new Status(10, "Channel.receiveFile used with non-file URI"));
            AppMethodBeat.o(101399);
            return;
        }
        File file = new File(this.zzco.getPath());
        try {
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (this.zzcp ? TPMediaCodecProfileLevel.HEVCHighTierLevel62 : 0) | 671088640);
            try {
                ((zzep) this.zzfi.getService()).zza(new zzhf(this.zzfh), this.zzcs, open);
                try {
                    open.close();
                    AppMethodBeat.o(101399);
                } catch (IOException e2) {
                    AppMethodBeat.o(101399);
                }
            } catch (RemoteException e3) {
                this.zzfh.setFailedResult(new Status(8));
                try {
                    open.close();
                    AppMethodBeat.o(101399);
                } catch (IOException e4) {
                    AppMethodBeat.o(101399);
                }
            } catch (Throwable th) {
                try {
                    open.close();
                } catch (IOException e5) {
                }
                AppMethodBeat.o(101399);
                throw th;
            }
        } catch (FileNotFoundException e6) {
            String valueOf = String.valueOf(file);
            new StringBuilder(String.valueOf(valueOf).length() + 49).append("File couldn't be opened for Channel.receiveFile: ").append(valueOf);
            this.zzfh.setFailedResult(new Status(13));
            AppMethodBeat.o(101399);
        }
    }
}
