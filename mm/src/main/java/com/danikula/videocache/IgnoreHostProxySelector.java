package com.danikula.videocache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

class IgnoreHostProxySelector extends ProxySelector {
    private static final List<Proxy> NO_PROXY_LIST = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector defaultProxySelector;
    private final String hostToIgnore;
    private final int portToIgnore;

    static {
        AppMethodBeat.i(183599);
        AppMethodBeat.o(183599);
    }

    IgnoreHostProxySelector(ProxySelector proxySelector, String str, int i2) {
        AppMethodBeat.i(183595);
        this.defaultProxySelector = (ProxySelector) Preconditions.checkNotNull(proxySelector);
        this.hostToIgnore = (String) Preconditions.checkNotNull(str);
        this.portToIgnore = i2;
        AppMethodBeat.o(183595);
    }

    static void install(String str, int i2) {
        AppMethodBeat.i(183596);
        ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), str, i2));
        AppMethodBeat.o(183596);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        AppMethodBeat.i(183597);
        if (this.hostToIgnore.equals(uri.getHost()) && this.portToIgnore == uri.getPort()) {
            List<Proxy> list = NO_PROXY_LIST;
            AppMethodBeat.o(183597);
            return list;
        }
        List<Proxy> select = this.defaultProxySelector.select(uri);
        AppMethodBeat.o(183597);
        return select;
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        AppMethodBeat.i(183598);
        this.defaultProxySelector.connectFailed(uri, socketAddress, iOException);
        AppMethodBeat.o(183598);
    }
}
