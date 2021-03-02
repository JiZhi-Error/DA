package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public final class zzf extends a<Void> implements SignInConnectionListener {
    private Semaphore zzet = new Semaphore(0);
    private Set<GoogleApiClient> zzeu;

    public zzf(Context context, Set<GoogleApiClient> set) {
        super(context);
        AppMethodBeat.i(88316);
        this.zzeu = set;
        AppMethodBeat.o(88316);
    }

    private final Void zzm() {
        AppMethodBeat.i(88317);
        int i2 = 0;
        for (GoogleApiClient googleApiClient : this.zzeu) {
            i2 = googleApiClient.maybeSignIn(this) ? i2 + 1 : i2;
        }
        try {
            this.zzet.tryAcquire(i2, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
        }
        AppMethodBeat.o(88317);
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.support.v4.content.a
    public final /* synthetic */ Void loadInBackground() {
        AppMethodBeat.i(88320);
        Void zzm = zzm();
        AppMethodBeat.o(88320);
        return zzm;
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        AppMethodBeat.i(88319);
        this.zzet.release();
        AppMethodBeat.o(88319);
    }

    @Override // android.support.v4.content.c
    public final void onStartLoading() {
        AppMethodBeat.i(88318);
        this.zzet.drainPermits();
        forceLoad();
        AppMethodBeat.o(88318);
    }
}
