package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import com.danikula.videocache.file.DiskUsage;
import com.danikula.videocache.file.FileNameGenerator;
import com.danikula.videocache.file.Md5FileNameGenerator;
import com.danikula.videocache.file.TotalCountLruDiskUsage;
import com.danikula.videocache.file.TotalSizeLruDiskUsage;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpProxyCacheServer {
    private static final String PROXY_HOST = "127.0.0.1";
    private final Object clientsLock;
    private final Map<String, HttpProxyCacheServerClients> clientsMap;
    private final Config config;
    private final int port;
    private final ServerSocket serverSocket;
    private final ExecutorService socketProcessor;
    private final Thread waitConnectionThread;

    static /* synthetic */ void access$100(HttpProxyCacheServer httpProxyCacheServer) {
        AppMethodBeat.i(223162);
        httpProxyCacheServer.waitForRequest();
        AppMethodBeat.o(223162);
    }

    static /* synthetic */ void access$200(HttpProxyCacheServer httpProxyCacheServer, Socket socket) {
        AppMethodBeat.i(223163);
        httpProxyCacheServer.processSocket(socket);
        AppMethodBeat.o(223163);
    }

    public HttpProxyCacheServer(Context context) {
        this(Builder.access$000(new Builder(context)));
        AppMethodBeat.i(223144);
        AppMethodBeat.o(223144);
    }

    private HttpProxyCacheServer(Config config2) {
        AppMethodBeat.i(183572);
        this.clientsLock = new Object();
        this.socketProcessor = Executors.newFixedThreadPool(8);
        this.clientsMap = new ConcurrentHashMap();
        this.config = (Config) Preconditions.checkNotNull(config2);
        try {
            this.serverSocket = new ServerSocket(0, 8, InetAddress.getByName(PROXY_HOST));
            this.port = this.serverSocket.getLocalPort();
            IgnoreHostProxySelector.install(PROXY_HOST, this.port);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.waitConnectionThread = new Thread(new WaitRequestsRunnable(countDownLatch));
            this.waitConnectionThread.start();
            countDownLatch.await();
            AppMethodBeat.o(183572);
        } catch (IOException | InterruptedException e2) {
            this.socketProcessor.shutdown();
            IllegalStateException illegalStateException = new IllegalStateException("Error starting local proxy server", e2);
            AppMethodBeat.o(183572);
            throw illegalStateException;
        }
    }

    public String getProxyUrl(String str) {
        AppMethodBeat.i(223145);
        String proxyUrl = getProxyUrl(str, true);
        AppMethodBeat.o(223145);
        return proxyUrl;
    }

    public String getProxyUrl(String str, boolean z) {
        AppMethodBeat.i(223146);
        if (!z || !getCacheFile(str).exists()) {
            String appendToProxyUrl = appendToProxyUrl(str);
            AppMethodBeat.o(223146);
            return appendToProxyUrl;
        }
        File cacheFile = getCacheFile(str);
        touchFileSafely(cacheFile);
        String uri = Uri.fromFile(cacheFile).toString();
        AppMethodBeat.o(223146);
        return uri;
    }

    public void registerCacheListener(CacheListener cacheListener, String str) {
        AppMethodBeat.i(223147);
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).registerCacheListener(cacheListener);
            } catch (ProxyCacheException e2) {
                Logger.warn("Error registering cache listener");
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(223147);
                throw th;
            }
        }
        AppMethodBeat.o(223147);
    }

    public void unregisterCacheListener(CacheListener cacheListener, String str) {
        AppMethodBeat.i(223148);
        Preconditions.checkAllNotNull(cacheListener, str);
        synchronized (this.clientsLock) {
            try {
                getClients(str).unregisterCacheListener(cacheListener);
            } catch (ProxyCacheException e2) {
                Logger.warn("Error registering cache listener");
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(223148);
                throw th;
            }
        }
        AppMethodBeat.o(223148);
    }

    public void unregisterCacheListener(CacheListener cacheListener) {
        AppMethodBeat.i(223149);
        Preconditions.checkNotNull(cacheListener);
        synchronized (this.clientsLock) {
            try {
                for (HttpProxyCacheServerClients httpProxyCacheServerClients : this.clientsMap.values()) {
                    httpProxyCacheServerClients.unregisterCacheListener(cacheListener);
                }
            } finally {
                AppMethodBeat.o(223149);
            }
        }
    }

    public boolean isCached(String str) {
        AppMethodBeat.i(223150);
        Preconditions.checkNotNull(str, "Url can't be null!");
        boolean exists = getCacheFile(str).exists();
        AppMethodBeat.o(223150);
        return exists;
    }

    public void shutdown() {
        AppMethodBeat.i(223151);
        Logger.info("Shutdown proxy server");
        shutdownClients();
        this.config.sourceInfoStorage.release();
        this.waitConnectionThread.interrupt();
        try {
            if (!this.serverSocket.isClosed()) {
                this.serverSocket.close();
            }
            AppMethodBeat.o(223151);
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error shutting down proxy server", e2));
            AppMethodBeat.o(223151);
        }
    }

    private String appendToProxyUrl(String str) {
        AppMethodBeat.i(223152);
        String format = String.format(Locale.US, "http://%s:%d/%s", PROXY_HOST, Integer.valueOf(this.port), ProxyCacheUtils.encode(str));
        AppMethodBeat.o(223152);
        return format;
    }

    public File getCacheFile(String str) {
        AppMethodBeat.i(183573);
        File file = new File(this.config.cacheRoot, this.config.fileNameGenerator.generate(str));
        AppMethodBeat.o(183573);
        return file;
    }

    public File getTempCacheFile(String str) {
        AppMethodBeat.i(223153);
        File file = new File(this.config.cacheRoot, this.config.fileNameGenerator.generate(str) + ".download");
        AppMethodBeat.o(223153);
        return file;
    }

    public File getCacheRoot() {
        return this.config.cacheRoot;
    }

    private void touchFileSafely(File file) {
        AppMethodBeat.i(223154);
        try {
            this.config.diskUsage.touch(file);
            AppMethodBeat.o(223154);
        } catch (IOException e2) {
            Logger.error("Error touching file ".concat(String.valueOf(file)));
            AppMethodBeat.o(223154);
        }
    }

    private void shutdownClients() {
        AppMethodBeat.i(223155);
        synchronized (this.clientsLock) {
            try {
                for (HttpProxyCacheServerClients httpProxyCacheServerClients : this.clientsMap.values()) {
                    httpProxyCacheServerClients.shutdown();
                }
                this.clientsMap.clear();
            } finally {
                AppMethodBeat.o(223155);
            }
        }
    }

    private void waitForRequest() {
        AppMethodBeat.i(223156);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket accept = this.serverSocket.accept();
                Logger.debug("Accept new socket ".concat(String.valueOf(accept)));
                this.socketProcessor.submit(new SocketProcessorRunnable(accept));
            } catch (IOException e2) {
                onError(new ProxyCacheException("Error during waiting connection", e2));
                AppMethodBeat.o(223156);
                return;
            }
        }
        AppMethodBeat.o(223156);
    }

    private void processSocket(Socket socket) {
        AppMethodBeat.i(223157);
        try {
            GetRequest read = GetRequest.read(socket.getInputStream());
            Logger.debug("Request to cache proxy:".concat(String.valueOf(read)));
            getClients(ProxyCacheUtils.decode(read.uri)).processRequest(read, socket);
        } catch (SocketException e2) {
            Logger.debug("Closing socket… Socket is closed by client.");
        } catch (ProxyCacheException | IOException e3) {
            onError(new ProxyCacheException("Error processing request", e3));
        } finally {
            releaseSocket(socket);
            Logger.debug("Opened connections: " + getClientsCount());
            AppMethodBeat.o(223157);
        }
    }

    private HttpProxyCacheServerClients getClients(String str) {
        HttpProxyCacheServerClients httpProxyCacheServerClients;
        AppMethodBeat.i(183574);
        synchronized (this.clientsLock) {
            try {
                httpProxyCacheServerClients = this.clientsMap.get(str);
                if (httpProxyCacheServerClients == null) {
                    httpProxyCacheServerClients = new HttpProxyCacheServerClients(str, this.config);
                    this.clientsMap.put(str, httpProxyCacheServerClients);
                }
            } finally {
                AppMethodBeat.o(183574);
            }
        }
        return httpProxyCacheServerClients;
    }

    private int getClientsCount() {
        int i2;
        AppMethodBeat.i(183575);
        synchronized (this.clientsLock) {
            try {
                i2 = 0;
                for (HttpProxyCacheServerClients httpProxyCacheServerClients : this.clientsMap.values()) {
                    i2 = httpProxyCacheServerClients.getClientsCount() + i2;
                }
            } finally {
                AppMethodBeat.o(183575);
            }
        }
        return i2;
    }

    private void releaseSocket(Socket socket) {
        AppMethodBeat.i(183576);
        closeSocketInput(socket);
        closeSocketOutput(socket);
        closeSocket(socket);
        AppMethodBeat.o(183576);
    }

    private void closeSocketInput(Socket socket) {
        AppMethodBeat.i(223158);
        try {
            if (!socket.isInputShutdown()) {
                socket.shutdownInput();
            }
            AppMethodBeat.o(223158);
        } catch (SocketException e2) {
            Logger.debug("Releasing input stream… Socket is closed by client.");
            AppMethodBeat.o(223158);
        } catch (IOException e3) {
            onError(new ProxyCacheException("Error closing socket input stream", e3));
            AppMethodBeat.o(223158);
        }
    }

    private void closeSocketOutput(Socket socket) {
        AppMethodBeat.i(223159);
        try {
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
            AppMethodBeat.o(223159);
        } catch (IOException e2) {
            Logger.warn("Failed to close socket on proxy side: {}. It seems client have already closed connection.");
            AppMethodBeat.o(223159);
        }
    }

    private void closeSocket(Socket socket) {
        AppMethodBeat.i(223160);
        try {
            if (!socket.isClosed()) {
                socket.close();
            }
            AppMethodBeat.o(223160);
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket", e2));
            AppMethodBeat.o(223160);
        }
    }

    private void onError(Throwable th) {
        AppMethodBeat.i(223161);
        Logger.error("HttpProxyCacheServer error");
        AppMethodBeat.o(223161);
    }

    final class WaitRequestsRunnable implements Runnable {
        private final CountDownLatch startSignal;

        public WaitRequestsRunnable(CountDownLatch countDownLatch) {
            this.startSignal = countDownLatch;
        }

        public final void run() {
            AppMethodBeat.i(183571);
            this.startSignal.countDown();
            HttpProxyCacheServer.access$100(HttpProxyCacheServer.this);
            AppMethodBeat.o(183571);
        }
    }

    /* access modifiers changed from: package-private */
    public final class SocketProcessorRunnable implements Runnable {
        private final Socket socket;

        public SocketProcessorRunnable(Socket socket2) {
            this.socket = socket2;
        }

        public final void run() {
            AppMethodBeat.i(183570);
            HttpProxyCacheServer.access$200(HttpProxyCacheServer.this, this.socket);
            AppMethodBeat.o(183570);
        }
    }

    public static final class Builder {
        private static final long DEFAULT_MAX_SIZE = 536870912;
        private File cacheRoot;
        private DiskUsage diskUsage = new TotalSizeLruDiskUsage(536870912);
        private FileNameGenerator fileNameGenerator = new Md5FileNameGenerator();
        private HeaderInjector headerInjector = new EmptyHeadersInjector();
        private SourceInfoStorage sourceInfoStorage;

        static /* synthetic */ Config access$000(Builder builder) {
            AppMethodBeat.i(223143);
            Config buildConfig = builder.buildConfig();
            AppMethodBeat.o(223143);
            return buildConfig;
        }

        public Builder(Context context) {
            AppMethodBeat.i(183569);
            this.sourceInfoStorage = SourceInfoStorageFactory.newSourceInfoStorage(context);
            this.cacheRoot = StorageUtils.getIndividualCacheDirectory(context);
            AppMethodBeat.o(183569);
        }

        public final Builder cacheDirectory(File file) {
            AppMethodBeat.i(223135);
            this.cacheRoot = (File) Preconditions.checkNotNull(file);
            AppMethodBeat.o(223135);
            return this;
        }

        public final Builder fileNameGenerator(FileNameGenerator fileNameGenerator2) {
            AppMethodBeat.i(223136);
            this.fileNameGenerator = (FileNameGenerator) Preconditions.checkNotNull(fileNameGenerator2);
            AppMethodBeat.o(223136);
            return this;
        }

        public final Builder maxCacheSize(long j2) {
            AppMethodBeat.i(223137);
            this.diskUsage = new TotalSizeLruDiskUsage(j2);
            AppMethodBeat.o(223137);
            return this;
        }

        public final Builder maxCacheFilesCount(int i2) {
            AppMethodBeat.i(223138);
            this.diskUsage = new TotalCountLruDiskUsage(i2);
            AppMethodBeat.o(223138);
            return this;
        }

        public final Builder diskUsage(DiskUsage diskUsage2) {
            AppMethodBeat.i(223139);
            this.diskUsage = (DiskUsage) Preconditions.checkNotNull(diskUsage2);
            AppMethodBeat.o(223139);
            return this;
        }

        public final Builder headerInjector(HeaderInjector headerInjector2) {
            AppMethodBeat.i(223140);
            this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector2);
            AppMethodBeat.o(223140);
            return this;
        }

        public final HttpProxyCacheServer build() {
            AppMethodBeat.i(223141);
            HttpProxyCacheServer httpProxyCacheServer = new HttpProxyCacheServer(buildConfig());
            AppMethodBeat.o(223141);
            return httpProxyCacheServer;
        }

        private Config buildConfig() {
            AppMethodBeat.i(223142);
            Config config = new Config(this.cacheRoot, this.fileNameGenerator, this.diskUsage, this.sourceInfoStorage, this.headerInjector);
            AppMethodBeat.o(223142);
            return config;
        }
    }
}
