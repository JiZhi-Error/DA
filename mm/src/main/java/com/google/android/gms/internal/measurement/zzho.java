package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

/* access modifiers changed from: package-private */
public final class zzho implements Callable<String> {
    private final /* synthetic */ zzhk zzanw;

    zzho(zzhk zzhk) {
        this.zzanw = zzhk;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() {
        AppMethodBeat.i(1743);
        String zzja = this.zzanw.zzgf().zzja();
        if (zzja != null) {
            AppMethodBeat.o(1743);
        } else {
            zzhk zzfu = this.zzanw.zzfu();
            if (zzfu.zzgd().zzjk()) {
                zzfu.zzge().zzim().log("Cannot retrieve app instance id from analytics worker thread");
                zzja = null;
            } else {
                zzfu.zzgd();
                if (zzgg.isMainThread()) {
                    zzfu.zzge().zzim().log("Cannot retrieve app instance id from main thread");
                    zzja = null;
                } else {
                    long elapsedRealtime = zzfu.zzbt().elapsedRealtime();
                    zzja = zzfu.zzae(120000);
                    long elapsedRealtime2 = zzfu.zzbt().elapsedRealtime() - elapsedRealtime;
                    if (zzja == null && elapsedRealtime2 < 120000) {
                        zzja = zzfu.zzae(120000 - elapsedRealtime2);
                    }
                }
            }
            if (zzja == null) {
                TimeoutException timeoutException = new TimeoutException();
                AppMethodBeat.o(1743);
                throw timeoutException;
            }
            this.zzanw.zzgf().zzbr(zzja);
            AppMethodBeat.o(1743);
        }
        return zzja;
    }
}
