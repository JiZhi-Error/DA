package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.danikula.videocache.file.FileCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

final class HttpProxyCacheServerClients {
    private final AtomicInteger clientsCount = new AtomicInteger(0);
    private final Config config;
    private final List<CacheListener> listeners = new CopyOnWriteArrayList();
    private volatile HttpProxyCache proxyCache;
    private final CacheListener uiCacheListener;
    private final String url;

    public HttpProxyCacheServerClients(String str, Config config2) {
        AppMethodBeat.i(183580);
        this.url = (String) Preconditions.checkNotNull(str);
        this.config = (Config) Preconditions.checkNotNull(config2);
        this.uiCacheListener = new UiListenerHandler(str, this.listeners);
        AppMethodBeat.o(183580);
    }

    public final void processRequest(GetRequest getRequest, Socket socket) {
        AppMethodBeat.i(223165);
        startProcessRequest();
        try {
            this.clientsCount.incrementAndGet();
            this.proxyCache.processRequest(getRequest, socket);
        } finally {
            finishProcessRequest();
            AppMethodBeat.o(223165);
        }
    }

    private synchronized void startProcessRequest() {
        AppMethodBeat.i(183581);
        this.proxyCache = this.proxyCache == null ? newHttpProxyCache() : this.proxyCache;
        AppMethodBeat.o(183581);
    }

    private synchronized void finishProcessRequest() {
        AppMethodBeat.i(183582);
        if (this.clientsCount.decrementAndGet() <= 0) {
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
        AppMethodBeat.o(183582);
    }

    public final void registerCacheListener(CacheListener cacheListener) {
        AppMethodBeat.i(223166);
        this.listeners.add(cacheListener);
        AppMethodBeat.o(223166);
    }

    public final void unregisterCacheListener(CacheListener cacheListener) {
        AppMethodBeat.i(223167);
        this.listeners.remove(cacheListener);
        AppMethodBeat.o(223167);
    }

    public final void shutdown() {
        AppMethodBeat.i(223168);
        this.listeners.clear();
        if (this.proxyCache != null) {
            this.proxyCache.registerCacheListener(null);
            this.proxyCache.shutdown();
            this.proxyCache = null;
        }
        this.clientsCount.set(0);
        AppMethodBeat.o(223168);
    }

    public final int getClientsCount() {
        AppMethodBeat.i(223169);
        int i2 = this.clientsCount.get();
        AppMethodBeat.o(223169);
        return i2;
    }

    private HttpProxyCache newHttpProxyCache() {
        AppMethodBeat.i(223170);
        HttpProxyCache httpProxyCache = new HttpProxyCache(new HttpUrlSource(this.url, this.config.sourceInfoStorage, this.config.headerInjector), new FileCache(this.config.generateCacheFile(this.url), this.config.diskUsage));
        httpProxyCache.registerCacheListener(this.uiCacheListener);
        AppMethodBeat.o(223170);
        return httpProxyCache;
    }

    static final class UiListenerHandler extends Handler implements CacheListener {
        private final List<CacheListener> listeners;
        private final String url;

        public UiListenerHandler(String str, List<CacheListener> list) {
            super(Looper.getMainLooper());
            AppMethodBeat.i(183577);
            this.url = str;
            this.listeners = list;
            AppMethodBeat.o(183577);
        }

        @Override // com.danikula.videocache.CacheListener
        public final void onCacheAvailable(File file, String str, int i2) {
            AppMethodBeat.i(223164);
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i2;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
            AppMethodBeat.o(223164);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(183579);
            for (CacheListener cacheListener : this.listeners) {
                cacheListener.onCacheAvailable((File) message.obj, this.url, message.arg1);
            }
            AppMethodBeat.o(183579);
        }
    }
}
