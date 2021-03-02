package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zze implements Runnable {
    private static final Logger zzer = new Logger("RevokeAccessOperation", new String[0]);
    private final StatusPendingResult zzes = new StatusPendingResult((GoogleApiClient) null);
    private final String zzz;

    static {
        AppMethodBeat.i(88315);
        AppMethodBeat.o(88315);
    }

    private zze(String str) {
        AppMethodBeat.i(88312);
        Preconditions.checkNotEmpty(str);
        this.zzz = str;
        AppMethodBeat.o(88312);
    }

    public static PendingResult<Status> zzg(String str) {
        AppMethodBeat.i(88314);
        if (str == null) {
            PendingResult<Status> immediateFailedResult = PendingResults.immediateFailedResult(new Status(4), null);
            AppMethodBeat.o(88314);
            return immediateFailedResult;
        }
        zze zze = new zze(str);
        new Thread(zze).start();
        StatusPendingResult statusPendingResult = zze.zzes;
        AppMethodBeat.o(88314);
        return statusPendingResult;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zze.run():void");
    }
}
