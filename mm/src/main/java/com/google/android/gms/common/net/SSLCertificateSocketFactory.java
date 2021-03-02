package com.google.android.gms.common.net;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLCertificateSocketFactory extends SSLSocketFactory {
    private static final TrustManager[] zzvf = {new zza()};
    @VisibleForTesting
    private final Context mContext;
    @VisibleForTesting
    private SSLSocketFactory zzvg = null;
    @VisibleForTesting
    private SSLSocketFactory zzvh = null;
    @VisibleForTesting
    private TrustManager[] zzvi = null;
    @VisibleForTesting
    private KeyManager[] zzvj = null;
    @VisibleForTesting
    private byte[] zzvk = null;
    @VisibleForTesting
    private byte[] zzvl = null;
    @VisibleForTesting
    private PrivateKey zzvm = null;
    @VisibleForTesting
    private final int zzvn;
    @VisibleForTesting
    private final boolean zzvo;
    @VisibleForTesting
    private final boolean zzvp;
    @VisibleForTesting
    private final String zzvq;

    static {
        AppMethodBeat.i(4948);
        AppMethodBeat.o(4948);
    }

    private SSLCertificateSocketFactory(Context context, int i2, boolean z, boolean z2, String str) {
        AppMethodBeat.i(4921);
        this.mContext = context.getApplicationContext();
        this.zzvn = i2;
        this.zzvo = z;
        this.zzvp = z2;
        this.zzvq = str;
        AppMethodBeat.o(4921);
    }

    public static SocketFactory getDefault(Context context, int i2) {
        AppMethodBeat.i(4922);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i2, false, true, null);
        AppMethodBeat.o(4922);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getDefaultWithCacheDir(int i2, Context context, String str) {
        AppMethodBeat.i(4924);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i2, true, true, str);
        AppMethodBeat.o(4924);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getDefaultWithSessionCache(int i2, Context context) {
        AppMethodBeat.i(4923);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i2, true, true, null);
        AppMethodBeat.o(4923);
        return sSLCertificateSocketFactory;
    }

    public static SSLSocketFactory getInsecure(Context context, int i2, boolean z) {
        AppMethodBeat.i(4925);
        SSLCertificateSocketFactory sSLCertificateSocketFactory = new SSLCertificateSocketFactory(context, i2, z, false, null);
        AppMethodBeat.o(4925);
        return sSLCertificateSocketFactory;
    }

    public static void verifyHostname(Socket socket, String str) {
        AppMethodBeat.i(4926);
        if (!(socket instanceof SSLSocket)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Attempt to verify non-SSL socket");
            AppMethodBeat.o(4926);
            throw illegalArgumentException;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            SSLException sSLException = new SSLException("Cannot verify SSL socket without session");
            AppMethodBeat.o(4926);
            throw sSLException;
        } else if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
            String valueOf = String.valueOf(str);
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(valueOf.length() != 0 ? "Cannot verify hostname: ".concat(valueOf) : new String("Cannot verify hostname: "));
            AppMethodBeat.o(4926);
            throw sSLPeerUnverifiedException;
        } else {
            AppMethodBeat.o(4926);
        }
    }

    @VisibleForTesting
    private static void zza(Socket socket, int i2) {
        AppMethodBeat.i(4946);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setHandshakeTimeout", Integer.TYPE).invoke(socket, Integer.valueOf(i2));
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) cause;
                    AppMethodBeat.o(4946);
                    throw runtimeException;
                }
                String valueOf = String.valueOf(socket.getClass());
                RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Failed to invoke setSocketHandshakeTimeout on ").append(valueOf).toString(), e2);
                AppMethodBeat.o(4946);
                throw runtimeException2;
            } catch (IllegalAccessException | NoSuchMethodException e3) {
                String valueOf2 = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 45).append(valueOf2).append(" does not implement setSocketHandshakeTimeout").toString(), e3);
                AppMethodBeat.o(4946);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(4946);
    }

    @VisibleForTesting
    private static void zza(Socket socket, PrivateKey privateKey) {
        AppMethodBeat.i(4947);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setChannelIdPrivateKey", PrivateKey.class).invoke(socket, privateKey);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) cause;
                    AppMethodBeat.o(4947);
                    throw runtimeException;
                }
                String valueOf = String.valueOf(socket.getClass());
                RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke setChannelIdPrivateKey on ").append(valueOf).toString(), e2);
                AppMethodBeat.o(4947);
                throw runtimeException2;
            } catch (IllegalAccessException | NoSuchMethodException e3) {
                String valueOf2 = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 42).append(valueOf2).append(" does not implement setChannelIdPrivateKey").toString(), e3);
                AppMethodBeat.o(4947);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(4947);
    }

    @VisibleForTesting
    private static void zza(Socket socket, byte[] bArr) {
        AppMethodBeat.i(4944);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setNpnProtocols", byte[].class).invoke(socket, bArr);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) cause;
                    AppMethodBeat.o(4944);
                    throw runtimeException;
                }
                String valueOf = String.valueOf(socket.getClass());
                RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to invoke setNpnProtocols on ").append(valueOf).toString(), e2);
                AppMethodBeat.o(4944);
                throw runtimeException2;
            } catch (IllegalAccessException | NoSuchMethodException e3) {
                String valueOf2 = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 35).append(valueOf2).append(" does not implement setNpnProtocols").toString(), e3);
                AppMethodBeat.o(4944);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(4944);
    }

    private static byte[] zza(byte[]... bArr) {
        AppMethodBeat.i(4930);
        if (bArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("items.length == 0");
            AppMethodBeat.o(4930);
            throw illegalArgumentException;
        }
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2.length == 0 || bArr2.length > 255) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(new StringBuilder(44).append("s.length == 0 || s.length > 255: ").append(bArr2.length).toString());
                AppMethodBeat.o(4930);
                throw illegalArgumentException2;
            }
            i2 += bArr2.length + 1;
        }
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            bArr3[i3] = (byte) bArr4.length;
            int length = bArr4.length;
            int i4 = 0;
            i3++;
            while (i4 < length) {
                bArr3[i3] = bArr4[i4];
                i4++;
                i3++;
            }
        }
        AppMethodBeat.o(4930);
        return bArr3;
    }

    @VisibleForTesting
    private static void zzb(Socket socket, byte[] bArr) {
        AppMethodBeat.i(4945);
        if (socket != null) {
            try {
                socket.getClass().getMethod("setAlpnProtocols", byte[].class).invoke(socket, bArr);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    RuntimeException runtimeException = (RuntimeException) cause;
                    AppMethodBeat.o(4945);
                    throw runtimeException;
                }
                String valueOf = String.valueOf(socket.getClass());
                RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 37).append("Failed to invoke setAlpnProtocols on ").append(valueOf).toString(), e2);
                AppMethodBeat.o(4945);
                throw runtimeException2;
            } catch (IllegalAccessException | NoSuchMethodException e3) {
                String valueOf2 = String.valueOf(socket.getClass());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 36).append(valueOf2).append(" does not implement setAlpnProtocols").toString(), e3);
                AppMethodBeat.o(4945);
                throw illegalArgumentException;
            }
        }
        AppMethodBeat.o(4945);
    }

    @VisibleForTesting
    private final synchronized SSLSocketFactory zzcx() {
        SSLSocketFactory sSLSocketFactory;
        AppMethodBeat.i(4927);
        if (!this.zzvp) {
            if (this.zzvg == null) {
                this.zzvg = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, zzvf, this.zzvo);
            }
            sSLSocketFactory = this.zzvg;
            AppMethodBeat.o(4927);
        } else {
            if (this.zzvq != null) {
                if (this.zzvh == null) {
                    this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactoryWithCacheDir(this.mContext, this.zzvj, this.zzvi, this.zzvq);
                }
            } else if (this.zzvh == null) {
                this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, this.zzvi, this.zzvo);
            }
            sSLSocketFactory = this.zzvh;
            AppMethodBeat.o(4927);
        }
        return sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        AppMethodBeat.i(4937);
        Socket createSocket = zzcx().createSocket();
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.o(4937);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) {
        AppMethodBeat.i(4941);
        Socket createSocket = zzcx().createSocket(str, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.o(4941);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) {
        AppMethodBeat.i(4940);
        Socket createSocket = zzcx().createSocket(str, i2, inetAddress, i3);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.o(4940);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) {
        AppMethodBeat.i(4939);
        Socket createSocket = zzcx().createSocket(inetAddress, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.o(4939);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) {
        AppMethodBeat.i(4938);
        Socket createSocket = zzcx().createSocket(inetAddress, i2, inetAddress2, i3);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        AppMethodBeat.o(4938);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) {
        AppMethodBeat.i(4936);
        Socket createSocket = zzcx().createSocket(socket, str, i2, z);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        AppMethodBeat.o(4936);
        return createSocket;
    }

    public byte[] getAlpnSelectedProtocol(Socket socket) {
        AppMethodBeat.i(4932);
        try {
            byte[] bArr = (byte[]) socket.getClass().getMethod("getAlpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
            AppMethodBeat.o(4932);
            return bArr;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4932);
                throw runtimeException;
            }
            String valueOf = String.valueOf(socket.getClass());
            RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to invoke getAlpnSelectedProtocol on ").append(valueOf).toString(), e2);
            AppMethodBeat.o(4932);
            throw runtimeException2;
        } catch (IllegalAccessException | NoSuchMethodException e3) {
            String valueOf2 = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 43).append(valueOf2).append(" does not implement getAlpnSelectedProtocol").toString(), e3);
            AppMethodBeat.o(4932);
            throw illegalArgumentException;
        }
    }

    public String[] getDefaultCipherSuites() {
        AppMethodBeat.i(4942);
        String[] defaultCipherSuites = zzcx().getDefaultCipherSuites();
        AppMethodBeat.o(4942);
        return defaultCipherSuites;
    }

    public byte[] getNpnSelectedProtocol(Socket socket) {
        AppMethodBeat.i(4931);
        try {
            byte[] bArr = (byte[]) socket.getClass().getMethod("getNpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
            AppMethodBeat.o(4931);
            return bArr;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4931);
                throw runtimeException;
            }
            String valueOf = String.valueOf(socket.getClass());
            RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke getNpnSelectedProtocol on ").append(valueOf).toString(), e2);
            AppMethodBeat.o(4931);
            throw runtimeException2;
        } catch (IllegalAccessException | NoSuchMethodException e3) {
            String valueOf2 = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 42).append(valueOf2).append(" does not implement getNpnSelectedProtocol").toString(), e3);
            AppMethodBeat.o(4931);
            throw illegalArgumentException;
        }
    }

    public String[] getSupportedCipherSuites() {
        AppMethodBeat.i(4943);
        String[] supportedCipherSuites = zzcx().getSupportedCipherSuites();
        AppMethodBeat.o(4943);
        return supportedCipherSuites;
    }

    public void setAlpnProtocols(byte[][] bArr) {
        AppMethodBeat.i(4929);
        this.zzvl = zza(bArr);
        AppMethodBeat.o(4929);
    }

    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.zzvm = privateKey;
    }

    public void setHostname(Socket socket, String str) {
        AppMethodBeat.i(4934);
        try {
            socket.getClass().getMethod("setHostname", String.class).invoke(socket, str);
            AppMethodBeat.o(4934);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4934);
                throw runtimeException;
            }
            String valueOf = String.valueOf(socket.getClass());
            RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Failed to invoke setHostname on ").append(valueOf).toString(), e2);
            AppMethodBeat.o(4934);
            throw runtimeException2;
        } catch (IllegalAccessException | NoSuchMethodException e3) {
            String valueOf2 = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 31).append(valueOf2).append(" does not implement setHostname").toString(), e3);
            AppMethodBeat.o(4934);
            throw illegalArgumentException;
        }
    }

    public void setKeyManagers(KeyManager[] keyManagerArr) {
        this.zzvj = keyManagerArr;
        this.zzvh = null;
        this.zzvg = null;
    }

    public void setNpnProtocols(byte[][] bArr) {
        AppMethodBeat.i(4928);
        this.zzvk = zza(bArr);
        AppMethodBeat.o(4928);
    }

    public void setSoWriteTimeout(Socket socket, int i2) {
        AppMethodBeat.i(4935);
        try {
            socket.getClass().getMethod("setSoWriteTimeout", Integer.TYPE).invoke(socket, Integer.valueOf(i2));
            AppMethodBeat.o(4935);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof SocketException) {
                SocketException socketException = (SocketException) cause;
                AppMethodBeat.o(4935);
                throw socketException;
            } else if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4935);
                throw runtimeException;
            } else {
                String valueOf = String.valueOf(socket.getClass());
                RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Failed to invoke setSoWriteTimeout on ").append(valueOf).toString(), e2);
                AppMethodBeat.o(4935);
                throw runtimeException2;
            }
        } catch (IllegalAccessException | NoSuchMethodException e3) {
            String valueOf2 = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 37).append(valueOf2).append(" does not implement setSoWriteTimeout").toString(), e3);
            AppMethodBeat.o(4935);
            throw illegalArgumentException;
        }
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.zzvi = trustManagerArr;
        this.zzvh = null;
    }

    public void setUseSessionTickets(Socket socket, boolean z) {
        AppMethodBeat.i(4933);
        try {
            socket.getClass().getMethod("setUseSessionTickets", Boolean.TYPE).invoke(socket, Boolean.valueOf(z));
            AppMethodBeat.o(4933);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4933);
                throw runtimeException;
            }
            String valueOf = String.valueOf(socket.getClass());
            RuntimeException runtimeException2 = new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to invoke setUseSessionTickets on ").append(valueOf).toString(), e2);
            AppMethodBeat.o(4933);
            throw runtimeException2;
        } catch (IllegalAccessException | NoSuchMethodException e3) {
            String valueOf2 = String.valueOf(socket.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 40).append(valueOf2).append(" does not implement setUseSessionTickets").toString(), e3);
            AppMethodBeat.o(4933);
            throw illegalArgumentException;
        }
    }
}
