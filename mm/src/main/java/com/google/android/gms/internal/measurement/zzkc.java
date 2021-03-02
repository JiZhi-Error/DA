package com.google.android.gms.internal.measurement;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* access modifiers changed from: package-private */
public final class zzkc extends SSLSocket {
    private final SSLSocket zzarj;

    zzkc(zzkb zzkb, SSLSocket sSLSocket) {
        this.zzarj = sSLSocket;
    }

    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        AppMethodBeat.i(2115);
        this.zzarj.addHandshakeCompletedListener(handshakeCompletedListener);
        AppMethodBeat.o(2115);
    }

    @Override // java.net.Socket
    public final void bind(SocketAddress socketAddress) {
        AppMethodBeat.i(2126);
        this.zzarj.bind(socketAddress);
        AppMethodBeat.o(2126);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        AppMethodBeat.i(2127);
        this.zzarj.close();
        AppMethodBeat.o(2127);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) {
        AppMethodBeat.i(2128);
        this.zzarj.connect(socketAddress);
        AppMethodBeat.o(2128);
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i2) {
        AppMethodBeat.i(2129);
        this.zzarj.connect(socketAddress, i2);
        AppMethodBeat.o(2129);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(2167);
        boolean equals = this.zzarj.equals(obj);
        AppMethodBeat.o(2167);
        return equals;
    }

    public final SocketChannel getChannel() {
        AppMethodBeat.i(2130);
        SocketChannel channel = this.zzarj.getChannel();
        AppMethodBeat.o(2130);
        return channel;
    }

    public final boolean getEnableSessionCreation() {
        AppMethodBeat.i(2125);
        boolean enableSessionCreation = this.zzarj.getEnableSessionCreation();
        AppMethodBeat.o(2125);
        return enableSessionCreation;
    }

    public final String[] getEnabledCipherSuites() {
        AppMethodBeat.i(2110);
        String[] enabledCipherSuites = this.zzarj.getEnabledCipherSuites();
        AppMethodBeat.o(2110);
        return enabledCipherSuites;
    }

    public final String[] getEnabledProtocols() {
        AppMethodBeat.i(2113);
        String[] enabledProtocols = this.zzarj.getEnabledProtocols();
        AppMethodBeat.o(2113);
        return enabledProtocols;
    }

    public final InetAddress getInetAddress() {
        AppMethodBeat.i(2131);
        InetAddress inetAddress = this.zzarj.getInetAddress();
        AppMethodBeat.o(2131);
        return inetAddress;
    }

    @Override // java.net.Socket
    public final InputStream getInputStream() {
        AppMethodBeat.i(2132);
        InputStream inputStream = this.zzarj.getInputStream();
        AppMethodBeat.o(2132);
        return inputStream;
    }

    @Override // java.net.Socket
    public final boolean getKeepAlive() {
        AppMethodBeat.i(2133);
        boolean keepAlive = this.zzarj.getKeepAlive();
        AppMethodBeat.o(2133);
        return keepAlive;
    }

    public final InetAddress getLocalAddress() {
        AppMethodBeat.i(2134);
        InetAddress localAddress = this.zzarj.getLocalAddress();
        AppMethodBeat.o(2134);
        return localAddress;
    }

    public final int getLocalPort() {
        AppMethodBeat.i(2135);
        int localPort = this.zzarj.getLocalPort();
        AppMethodBeat.o(2135);
        return localPort;
    }

    public final SocketAddress getLocalSocketAddress() {
        AppMethodBeat.i(2136);
        SocketAddress localSocketAddress = this.zzarj.getLocalSocketAddress();
        AppMethodBeat.o(2136);
        return localSocketAddress;
    }

    public final boolean getNeedClientAuth() {
        AppMethodBeat.i(2122);
        boolean needClientAuth = this.zzarj.getNeedClientAuth();
        AppMethodBeat.o(2122);
        return needClientAuth;
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() {
        AppMethodBeat.i(2137);
        boolean oOBInline = this.zzarj.getOOBInline();
        AppMethodBeat.o(2137);
        return oOBInline;
    }

    @Override // java.net.Socket
    public final OutputStream getOutputStream() {
        AppMethodBeat.i(2138);
        OutputStream outputStream = this.zzarj.getOutputStream();
        AppMethodBeat.o(2138);
        return outputStream;
    }

    public final int getPort() {
        AppMethodBeat.i(2139);
        int port = this.zzarj.getPort();
        AppMethodBeat.o(2139);
        return port;
    }

    @Override // java.net.Socket
    public final synchronized int getReceiveBufferSize() {
        int receiveBufferSize;
        AppMethodBeat.i(2140);
        receiveBufferSize = this.zzarj.getReceiveBufferSize();
        AppMethodBeat.o(2140);
        return receiveBufferSize;
    }

    public final SocketAddress getRemoteSocketAddress() {
        AppMethodBeat.i(2141);
        SocketAddress remoteSocketAddress = this.zzarj.getRemoteSocketAddress();
        AppMethodBeat.o(2141);
        return remoteSocketAddress;
    }

    @Override // java.net.Socket
    public final boolean getReuseAddress() {
        AppMethodBeat.i(2142);
        boolean reuseAddress = this.zzarj.getReuseAddress();
        AppMethodBeat.o(2142);
        return reuseAddress;
    }

    @Override // java.net.Socket
    public final synchronized int getSendBufferSize() {
        int sendBufferSize;
        AppMethodBeat.i(2143);
        sendBufferSize = this.zzarj.getSendBufferSize();
        AppMethodBeat.o(2143);
        return sendBufferSize;
    }

    public final SSLSession getSession() {
        AppMethodBeat.i(2114);
        SSLSession session = this.zzarj.getSession();
        AppMethodBeat.o(2114);
        return session;
    }

    @Override // java.net.Socket
    public final int getSoLinger() {
        AppMethodBeat.i(2144);
        int soLinger = this.zzarj.getSoLinger();
        AppMethodBeat.o(2144);
        return soLinger;
    }

    @Override // java.net.Socket
    public final synchronized int getSoTimeout() {
        int soTimeout;
        AppMethodBeat.i(2145);
        soTimeout = this.zzarj.getSoTimeout();
        AppMethodBeat.o(2145);
        return soTimeout;
    }

    public final String[] getSupportedCipherSuites() {
        AppMethodBeat.i(TXLiteAVCode.WARNING_SW_DECODER_START_FAIL);
        String[] supportedCipherSuites = this.zzarj.getSupportedCipherSuites();
        AppMethodBeat.o(TXLiteAVCode.WARNING_SW_DECODER_START_FAIL);
        return supportedCipherSuites;
    }

    public final String[] getSupportedProtocols() {
        AppMethodBeat.i(2112);
        String[] supportedProtocols = this.zzarj.getSupportedProtocols();
        AppMethodBeat.o(2112);
        return supportedProtocols;
    }

    @Override // java.net.Socket
    public final boolean getTcpNoDelay() {
        AppMethodBeat.i(2146);
        boolean tcpNoDelay = this.zzarj.getTcpNoDelay();
        AppMethodBeat.o(2146);
        return tcpNoDelay;
    }

    @Override // java.net.Socket
    public final int getTrafficClass() {
        AppMethodBeat.i(2147);
        int trafficClass = this.zzarj.getTrafficClass();
        AppMethodBeat.o(2147);
        return trafficClass;
    }

    public final boolean getUseClientMode() {
        AppMethodBeat.i(2119);
        boolean useClientMode = this.zzarj.getUseClientMode();
        AppMethodBeat.o(2119);
        return useClientMode;
    }

    public final boolean getWantClientAuth() {
        AppMethodBeat.i(2123);
        boolean wantClientAuth = this.zzarj.getWantClientAuth();
        AppMethodBeat.o(2123);
        return wantClientAuth;
    }

    public final boolean isBound() {
        AppMethodBeat.i(2148);
        boolean isBound = this.zzarj.isBound();
        AppMethodBeat.o(2148);
        return isBound;
    }

    public final boolean isClosed() {
        AppMethodBeat.i(2149);
        boolean isClosed = this.zzarj.isClosed();
        AppMethodBeat.o(2149);
        return isClosed;
    }

    public final boolean isConnected() {
        AppMethodBeat.i(2150);
        boolean isConnected = this.zzarj.isConnected();
        AppMethodBeat.o(2150);
        return isConnected;
    }

    public final boolean isInputShutdown() {
        AppMethodBeat.i(2151);
        boolean isInputShutdown = this.zzarj.isInputShutdown();
        AppMethodBeat.o(2151);
        return isInputShutdown;
    }

    public final boolean isOutputShutdown() {
        AppMethodBeat.i(2152);
        boolean isOutputShutdown = this.zzarj.isOutputShutdown();
        AppMethodBeat.o(2152);
        return isOutputShutdown;
    }

    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        AppMethodBeat.i(2116);
        this.zzarj.removeHandshakeCompletedListener(handshakeCompletedListener);
        AppMethodBeat.o(2116);
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i2) {
        AppMethodBeat.i(2153);
        this.zzarj.sendUrgentData(i2);
        AppMethodBeat.o(2153);
    }

    public final void setEnableSessionCreation(boolean z) {
        AppMethodBeat.i(2124);
        this.zzarj.setEnableSessionCreation(z);
        AppMethodBeat.o(2124);
    }

    public final void setEnabledCipherSuites(String[] strArr) {
        AppMethodBeat.i(2111);
        this.zzarj.setEnabledCipherSuites(strArr);
        AppMethodBeat.o(2111);
    }

    public final void setEnabledProtocols(String[] strArr) {
        AppMethodBeat.i(2108);
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.zzarj.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.zzarj.setEnabledProtocols(strArr);
        AppMethodBeat.o(2108);
    }

    @Override // java.net.Socket
    public final void setKeepAlive(boolean z) {
        AppMethodBeat.i(2154);
        this.zzarj.setKeepAlive(z);
        AppMethodBeat.o(2154);
    }

    public final void setNeedClientAuth(boolean z) {
        AppMethodBeat.i(2120);
        this.zzarj.setNeedClientAuth(z);
        AppMethodBeat.o(2120);
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) {
        AppMethodBeat.i(2155);
        this.zzarj.setOOBInline(z);
        AppMethodBeat.o(2155);
    }

    public final void setPerformancePreferences(int i2, int i3, int i4) {
        AppMethodBeat.i(2156);
        this.zzarj.setPerformancePreferences(i2, i3, i4);
        AppMethodBeat.o(2156);
    }

    @Override // java.net.Socket
    public final synchronized void setReceiveBufferSize(int i2) {
        AppMethodBeat.i(2157);
        this.zzarj.setReceiveBufferSize(i2);
        AppMethodBeat.o(2157);
    }

    @Override // java.net.Socket
    public final void setReuseAddress(boolean z) {
        AppMethodBeat.i(TPCodecParamers.TP_PROFILE_H264_HIGH_10_INTRA);
        this.zzarj.setReuseAddress(z);
        AppMethodBeat.o(TPCodecParamers.TP_PROFILE_H264_HIGH_10_INTRA);
    }

    @Override // java.net.Socket
    public final synchronized void setSendBufferSize(int i2) {
        AppMethodBeat.i(2159);
        this.zzarj.setSendBufferSize(i2);
        AppMethodBeat.o(2159);
    }

    @Override // java.net.Socket
    public final void setSoLinger(boolean z, int i2) {
        AppMethodBeat.i(2160);
        this.zzarj.setSoLinger(z, i2);
        AppMethodBeat.o(2160);
    }

    @Override // java.net.Socket
    public final synchronized void setSoTimeout(int i2) {
        AppMethodBeat.i(2161);
        this.zzarj.setSoTimeout(i2);
        AppMethodBeat.o(2161);
    }

    @Override // java.net.Socket
    public final void setTcpNoDelay(boolean z) {
        AppMethodBeat.i(2162);
        this.zzarj.setTcpNoDelay(z);
        AppMethodBeat.o(2162);
    }

    @Override // java.net.Socket
    public final void setTrafficClass(int i2) {
        AppMethodBeat.i(2163);
        this.zzarj.setTrafficClass(i2);
        AppMethodBeat.o(2163);
    }

    public final void setUseClientMode(boolean z) {
        AppMethodBeat.i(2118);
        this.zzarj.setUseClientMode(z);
        AppMethodBeat.o(2118);
    }

    public final void setWantClientAuth(boolean z) {
        AppMethodBeat.i(2121);
        this.zzarj.setWantClientAuth(z);
        AppMethodBeat.o(2121);
    }

    @Override // java.net.Socket
    public final void shutdownInput() {
        AppMethodBeat.i(2164);
        this.zzarj.shutdownInput();
        AppMethodBeat.o(2164);
    }

    @Override // java.net.Socket
    public final void shutdownOutput() {
        AppMethodBeat.i(2165);
        this.zzarj.shutdownOutput();
        AppMethodBeat.o(2165);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() {
        AppMethodBeat.i(2117);
        this.zzarj.startHandshake();
        AppMethodBeat.o(2117);
    }

    public final String toString() {
        AppMethodBeat.i(2166);
        String sSLSocket = this.zzarj.toString();
        AppMethodBeat.o(2166);
        return sSLSocket;
    }
}
