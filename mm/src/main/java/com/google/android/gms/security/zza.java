package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends AsyncTask<Void, Void, Integer> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ ProviderInstaller.ProviderInstallListener zzacy;

    zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.val$context = context;
        this.zzacy = providerInstallListener;
    }

    private final Integer zza(Void... voidArr) {
        AppMethodBeat.i(5527);
        try {
            ProviderInstaller.installIfNeeded(this.val$context);
            AppMethodBeat.o(5527);
            return 0;
        } catch (GooglePlayServicesRepairableException e2) {
            Integer valueOf = Integer.valueOf(e2.getConnectionStatusCode());
            AppMethodBeat.o(5527);
            return valueOf;
        } catch (GooglePlayServicesNotAvailableException e3) {
            Integer valueOf2 = Integer.valueOf(e3.errorCode);
            AppMethodBeat.o(5527);
            return valueOf2;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
        AppMethodBeat.i(5529);
        Integer zza = zza(voidArr);
        AppMethodBeat.o(5529);
        return zza;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Integer num) {
        AppMethodBeat.i(5528);
        Integer num2 = num;
        if (num2.intValue() == 0) {
            this.zzacy.onProviderInstalled();
            AppMethodBeat.o(5528);
            return;
        }
        this.zzacy.onProviderInstallFailed(num2.intValue(), ProviderInstaller.zzdn().getErrorResolutionIntent(this.val$context, num2.intValue(), "pi"));
        AppMethodBeat.o(5528);
    }
}
