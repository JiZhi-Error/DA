package com.google.android.gms.common.api.internal;

import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzaf extends GoogleApiClient {
    private final String zzhe;

    public zzaf(String str) {
        this.zzhe = str;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        AppMethodBeat.i(11189);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11189);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(11190);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11190);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        AppMethodBeat.i(11193);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11193);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        AppMethodBeat.i(11188);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11188);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        AppMethodBeat.i(11191);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11191);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AppMethodBeat.i(11203);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11203);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        AppMethodBeat.i(11187);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11187);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        AppMethodBeat.i(11186);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11186);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        AppMethodBeat.i(11195);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11195);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        AppMethodBeat.i(11196);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11196);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11198);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11198);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11201);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11201);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        AppMethodBeat.i(11192);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11192);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11197);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11197);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11200);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11200);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(11194);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11194);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        AppMethodBeat.i(11199);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11199);
        throw unsupportedOperationException;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.i(11202);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(this.zzhe);
        AppMethodBeat.o(11202);
        throw unsupportedOperationException;
    }
}
