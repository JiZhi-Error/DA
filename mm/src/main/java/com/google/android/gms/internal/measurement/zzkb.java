package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

final class zzkb extends SSLSocketFactory {
    private final SSLSocketFactory zzari;

    zzkb() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
        AppMethodBeat.i(2098);
        AppMethodBeat.o(2098);
    }

    private zzkb(SSLSocketFactory sSLSocketFactory) {
        this.zzari = sSLSocketFactory;
    }

    private final SSLSocket zza(SSLSocket sSLSocket) {
        AppMethodBeat.i(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
        zzkc zzkc = new zzkc(this, sSLSocket);
        AppMethodBeat.o(TXLiveConstants.PLAY_WARNING_VIDEO_DISCONTINUITY);
        return zzkc;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() {
        AppMethodBeat.i(2106);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket());
        AppMethodBeat.o(2106);
        return zza;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) {
        AppMethodBeat.i(2102);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(str, i2));
        AppMethodBeat.o(2102);
        return zza;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        AppMethodBeat.i(2104);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(str, i2, inetAddress, i3));
        AppMethodBeat.o(2104);
        return zza;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) {
        AppMethodBeat.i(2103);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(inetAddress, i2));
        AppMethodBeat.o(2103);
        return zza;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        AppMethodBeat.i(2105);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(inetAddress, i2, inetAddress2, i3));
        AppMethodBeat.o(2105);
        return zza;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z) {
        AppMethodBeat.i(2099);
        SSLSocket zza = zza((SSLSocket) this.zzari.createSocket(socket, str, i2, z));
        AppMethodBeat.o(2099);
        return zza;
    }

    public final String[] getDefaultCipherSuites() {
        AppMethodBeat.i(2100);
        String[] defaultCipherSuites = this.zzari.getDefaultCipherSuites();
        AppMethodBeat.o(2100);
        return defaultCipherSuites;
    }

    public final String[] getSupportedCipherSuites() {
        AppMethodBeat.i(2101);
        String[] supportedCipherSuites = this.zzari.getSupportedCipherSuites();
        AppMethodBeat.o(2101);
        return supportedCipherSuites;
    }
}
