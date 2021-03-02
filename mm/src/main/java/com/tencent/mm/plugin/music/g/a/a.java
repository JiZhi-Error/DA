package com.tencent.mm.plugin.music.g.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.plugin.music.cache.c;
import com.tencent.mm.plugin.music.cache.d;
import com.tencent.mm.plugin.music.cache.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.h;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public final class a implements IMediaHTTPConnection {
    private com.tencent.mm.plugin.music.cache.a Amp;
    public URL Amq = null;
    private byte[] Amr = new byte[1];
    private final Map<String, String> Ams;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private String mMimeType = "";
    private long mTotalSize = -1;
    private URL mURL = null;

    public a(Map<String, String> map) {
        AppMethodBeat.i(198190);
        this.Ams = map;
        AppMethodBeat.o(198190);
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public final boolean connect(URL url, Map<String, String> map) {
        String str;
        AppMethodBeat.i(137428);
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect");
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect: uri=" + url + ", headers=" + map);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.Amq = url;
        this.mHeaders = map;
        this.mTotalSize = -1;
        this.mMimeType = "";
        if (MMApplicationContext.isMMProcess()) {
            String url2 = this.mURL.toString();
            if (e.etK()) {
                str = ((c) b.aS(c.class)).aHr(url2);
            } else {
                Log.e("MicroMsg.Music.MusicDataStorageImpl", "IMusicDataStorage service not exist");
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(this.mURL.toString())) {
                Log.i("MicroMsg.Music.MMMediaHTTPConnection", "use temp shake music url to play:%s", str);
                try {
                    this.mURL = new URL(str);
                } catch (MalformedURLException e2) {
                    Log.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", e2, "playUrl", new Object[0]);
                }
            }
        }
        if (this.mURL != null) {
            g.H(this.mURL.toString(), map);
            String url3 = this.Amq.toString();
            Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "connect, originUrlStr: ".concat(String.valueOf(url3)));
            String str2 = this.Ams.get(url3);
            if (!"invalidReferrer".equals(str2)) {
                if (map != null) {
                    map.remove("referer");
                }
                if (!Util.isNullOrNil(str2)) {
                    Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, add referrer: ".concat(String.valueOf(str2)));
                    if (map == null) {
                        map = new HashMap<>();
                        this.mHeaders = map;
                    }
                    try {
                        map.put("Referer", str2);
                    } catch (Exception e3) {
                        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "connect, put referrer fail since " + e3.toString());
                        HashMap hashMap = new HashMap(map);
                        hashMap.put("Referer", str2);
                        map = hashMap;
                    }
                }
            }
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "headers=".concat(String.valueOf(map)));
        }
        this.Amp = new com.tencent.mm.plugin.music.cache.a(this);
        com.tencent.mm.plugin.music.cache.a aVar = this.Amp;
        String url4 = aVar.AiB.Amq.toString();
        aVar.AiC = new d(url4);
        aVar.AiC.jPY = aVar.AiB.getSize();
        d dVar = aVar.AiC;
        Log.i("MicroMsg.Music.IndexBitMgr", "initData");
        if (dVar.jPY <= 0) {
            Log.e("MicroMsg.Music.IndexBitMgr", "fileLength is invalid!");
        } else {
            if (dVar.jPY % 8192 == 0 || dVar.jPY < 8192) {
                dVar.count = (int) (dVar.jPY / 8192);
            } else {
                dVar.count = ((int) (dVar.jPY / 8192)) + 1;
            }
            if (dVar.jPY <= 8192) {
                Log.i("MicroMsg.Music.IndexBitMgr", "fileLength < PIECE_SIZE, count should be 1");
                dVar.count = 1;
            }
            Log.i("MicroMsg.Music.IndexBitMgr", "fileLength:%d, count:%d", Long.valueOf(dVar.jPY), Integer.valueOf(dVar.count));
            dVar.AiI = new BitSet(dVar.count);
            dVar.dSF = g.aHy(dVar.mUrl);
            if (TextUtils.isEmpty(dVar.dSF)) {
                Log.e("MicroMsg.Music.IndexBitMgr", "initData musicId is null!'");
            } else {
                Log.i("MicroMsg.Music.IndexBitMgr", "musicId:%s", dVar.dSF);
                j aHs = e.aHs(dVar.dSF);
                if (aHs == null) {
                    Log.e("MicroMsg.Music.IndexBitMgr", "initData pMusic is null!'");
                } else {
                    Log.i("MicroMsg.Music.IndexBitMgr", "initData music field_fileCacheComplete:%d", Integer.valueOf(aHs.jfB));
                    if (aHs.jfA == null || aHs.jfA.length == 0) {
                        Log.e("MicroMsg.Music.IndexBitMgr", "initData field_indexBitData is null!'");
                    } else {
                        dVar.AiI = d.a.bT(aHs.jfA);
                        if (dVar.AiI == null) {
                            Log.e("MicroMsg.Music.IndexBitMgr", "initData bitSet is null");
                            dVar.AiI = new BitSet(dVar.count);
                        } else if (dVar.count < dVar.AiI.cardinality()) {
                            Log.e("MicroMsg.Music.IndexBitMgr", "initData cont < bitSet.cardinality(), count:%d, cardinality:%d", Integer.valueOf(dVar.count), Integer.valueOf(dVar.AiI.cardinality()));
                            dVar.clearCache();
                        } else if (aHs.jfD != 1) {
                            Log.i("MicroMsg.Music.IndexBitMgr", "remove dirty bit set from db, reset cache complete to 0");
                            if (dVar.count > 1) {
                                dVar.SH(dVar.count - 1);
                                dVar.SH(dVar.count - 2);
                            } else {
                                dVar.SH(dVar.count - 1);
                            }
                            dVar.SE(0);
                        }
                        Log.i("MicroMsg.Music.IndexBitMgr", "initData bitSet:" + dVar.AiI.toString());
                        Log.i("MicroMsg.Music.IndexBitMgr", "initData bitSet count %d, cardinality:" + dVar.count + "," + dVar.AiI.cardinality());
                    }
                }
            }
        }
        aVar.AiD = new h(url4);
        if (!new o(aVar.AiD.fileName).exists()) {
            Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file not exist, clear cache!");
            aVar.AiC.clearCache();
        } else if (aVar.AiD.etL() != aVar.AiB.getSize() && aVar.AiB.getSize() != -1) {
            Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file length is not equals to real file length exist, clear cache!");
            aVar.AiC.clearCache();
            h hVar = aVar.AiD;
            Logger.i("MicroMsg.Music.PieceFileCache", "deleteFile");
            h.aHD(hVar.fileName);
        } else if (aVar.AiB.getSize() == -1) {
            Log.i("MicroMsg.Music.FileBytesCacheMgr", "getFileLength is -1, network is disconnect!");
        } else {
            Log.i("MicroMsg.Music.FileBytesCacheMgr", "piece file exist!");
        }
        long size = aVar.AiB.getSize();
        h hVar2 = aVar.AiD;
        Logger.i("MicroMsg.Music.PieceFileCache", WeChatBrands.Business.GROUP_OPEN);
        try {
            o oVar = new o(hVar2.fileName);
            if (!oVar.exists()) {
                Log.i("MicroMsg.Music.PieceFileCache", "create file:%b", Boolean.valueOf(oVar.createNewFile()));
            }
            hVar2.randomAccessFile = s.dB(aa.z(oVar.mUri), true);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (FileNotFoundException e4) {
            Logger.e("MicroMsg.Music.PieceFileCache", "file not found", e4);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (IOException e5) {
            Logger.e("MicroMsg.Music.PieceFileCache", "io ", e5);
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
        } catch (Throwable th) {
            Logger.e("MicroMsg.Music.PieceFileCache", "create RandomAccessFile file  %s  success", hVar2.fileName);
            AppMethodBeat.o(137428);
            throw th;
        }
        aVar.AiD.setLength(size);
        g.bc(url4, size);
        Log.i("MicroMsg.Music.FileBytesCacheMgr", "attach() fileLength is " + size + ",pieceFileCache length is " + aVar.AiD.getLength());
        String mIMEType = aVar.AiB.getMIMEType();
        if (!TextUtils.isEmpty(mIMEType) && !"application/octet-stream".equalsIgnoreCase(mIMEType)) {
            g.iW(url4, mIMEType);
        }
        aVar.fs = -1;
        aVar.mSize = 0;
        aVar.AiE = -1;
        aVar.AiF = 0;
        AppMethodBeat.o(137428);
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public final void disconnect() {
        AppMethodBeat.i(137429);
        Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "disconnect");
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        if (this.Amp != null) {
            com.tencent.mm.plugin.music.cache.a aVar = this.Amp;
            aVar.etB();
            aVar.AiC.etI();
            aVar.AiD.close();
            aVar.AiB = null;
            Log.i("MicroMsg.Music.FileBytesCacheMgr", "detach()");
            this.Amp = null;
        }
        AppMethodBeat.o(137429);
    }

    private void teardownConnection() {
        AppMethodBeat.i(137430);
        if (this.mInputStream != null) {
            try {
                this.mInputStream.close();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Music.MMMediaHTTPConnection", e2, "teardownConnection", new Object[0]);
            }
            this.mInputStream = null;
        }
        if (this.mConnection != null) {
            try {
                this.mConnection.getInputStream().close();
            } catch (Exception e3) {
                Log.e("MicroMsg.Music.MMMediaHTTPConnection", e3.getMessage());
            }
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
        AppMethodBeat.o(137430);
    }

    private static final boolean isLocalHost(URL url) {
        AppMethodBeat.i(137431);
        if (url == null) {
            AppMethodBeat.o(137431);
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            AppMethodBeat.o(137431);
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                AppMethodBeat.o(137431);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "isLocalHost IllegalArgumentException:%s", String.valueOf(e2));
        }
        AppMethodBeat.o(137431);
        return false;
    }

    private void seekTo(long j2) {
        int lastIndexOf;
        boolean z;
        AppMethodBeat.i(137432);
        teardownConnection();
        int i2 = 0;
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (isLocalHost) {
                    try {
                        this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                    } catch (IOException e2) {
                        e = e2;
                        i2 = i4;
                        this.mTotalSize = -1;
                        teardownConnection();
                        Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i2);
                        AppMethodBeat.o(137432);
                        throw e;
                    }
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                this.mConnection.setConnectTimeout(CommonUtils.MAX_TIMEOUT_MS);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                boolean z2 = false;
                Logger.d("MicroMsg.Music.MMMediaHTTPConnection", "mHeaders=" + this.mHeaders);
                if (this.mHeaders != null) {
                    for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                        this.mConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        if (z2 || !"Accept-Encoding".equals(entry.getKey())) {
                            z = z2;
                        } else {
                            z = true;
                        }
                        z2 = z;
                    }
                }
                if (j2 > 0) {
                    this.mConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
                }
                if (!z2) {
                    this.mConnection.setRequestProperty("Accept-Encoding", "");
                }
                int responseCode = this.mConnection.getResponseCode();
                g.eT(this.Amq.toString(), responseCode);
                if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                    int i5 = i3 + 1;
                    if (i5 > 20) {
                        NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i5)));
                        AppMethodBeat.o(137432);
                        throw noRouteToHostException;
                    }
                    String requestMethod = this.mConnection.getRequestMethod();
                    if (responseCode != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                        String headerField = this.mConnection.getHeaderField("Location");
                        if (headerField == null) {
                            NoRouteToHostException noRouteToHostException2 = new NoRouteToHostException("Invalid redirect");
                            AppMethodBeat.o(137432);
                            throw noRouteToHostException2;
                        }
                        url = new URL(this.mURL, headerField);
                        if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                            boolean equals = this.mURL.getProtocol().equals(url.getProtocol());
                            if (this.mAllowCrossProtocolRedirect || equals) {
                                boolean equals2 = this.mURL.getHost().equals(url.getHost());
                                if (this.mAllowCrossDomainRedirect || equals2) {
                                    if (responseCode != 307) {
                                        this.mURL = url;
                                    }
                                    i3 = i5;
                                    i4 = responseCode;
                                } else {
                                    NoRouteToHostException noRouteToHostException3 = new NoRouteToHostException("Cross-domain redirects are disallowed");
                                    AppMethodBeat.o(137432);
                                    throw noRouteToHostException3;
                                }
                            } else {
                                NoRouteToHostException noRouteToHostException4 = new NoRouteToHostException("Cross-protocol redirects are disallowed");
                                AppMethodBeat.o(137432);
                                throw noRouteToHostException4;
                            }
                        } else {
                            NoRouteToHostException noRouteToHostException5 = new NoRouteToHostException("Unsupported protocol redirect");
                            AppMethodBeat.o(137432);
                            throw noRouteToHostException5;
                        }
                    } else {
                        NoRouteToHostException noRouteToHostException6 = new NoRouteToHostException("Invalid redirect");
                        AppMethodBeat.o(137432);
                        throw noRouteToHostException6;
                    }
                } else {
                    if (this.mAllowCrossDomainRedirect) {
                        this.mURL = this.mConnection.getURL();
                    }
                    if (responseCode == 206) {
                        String headerField2 = this.mConnection.getHeaderField("Content-Range");
                        this.mTotalSize = -1;
                        if (headerField2 != null && (lastIndexOf = headerField2.lastIndexOf(47)) >= 0) {
                            try {
                                this.mTotalSize = Util.getLong(headerField2.substring(lastIndexOf + 1), 0);
                            } catch (NumberFormatException e3) {
                            }
                        }
                    } else if (responseCode != 200) {
                        IOException iOException = new IOException();
                        AppMethodBeat.o(137432);
                        throw iOException;
                    } else {
                        this.mTotalSize = (long) this.mConnection.getContentLength();
                    }
                    if (TextUtils.isEmpty(this.mMimeType)) {
                        this.mMimeType = this.mConnection.getContentType();
                        Log.i("MicroMsg.Music.MMMediaHTTPConnection", "mimeType:", this.mMimeType);
                    }
                    if (j2 <= 0 || responseCode == 206) {
                        this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                        this.mCurrentOffset = j2;
                        AppMethodBeat.o(137432);
                        return;
                    }
                    ProtocolException protocolException = new ProtocolException();
                    AppMethodBeat.o(137432);
                    throw protocolException;
                }
            }
        } catch (IOException e4) {
            e = e4;
            this.mTotalSize = -1;
            teardownConnection();
            Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "seekTo exception:%s", e + ", response:" + i2);
            AppMethodBeat.o(137432);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049 A[Catch:{ ProtocolException -> 0x00aa, NoRouteToHostException -> 0x01dc, UnknownServiceException -> 0x024d, IOException -> 0x02c3, Exception -> 0x034a }] */
    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int readAt(long r14, byte[] r16, int r17, int r18) {
        /*
        // Method dump skipped, instructions count: 995
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.g.a.a.readAt(long, byte[], int, int):int");
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public final long getSize() {
        AppMethodBeat.i(137434);
        if (this.mTotalSize > 0) {
            long j2 = this.mTotalSize;
            AppMethodBeat.o(137434);
            return j2;
        } else if (g.aHC(this.Amq.toString()) > 0) {
            this.mTotalSize = g.aHC(this.Amq.toString());
            long j3 = this.mTotalSize;
            AppMethodBeat.o(137434);
            return j3;
        } else {
            if (this.mConnection == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    seekTo(0);
                    Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getSize cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (IOException e2) {
                    Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getSize exception:%s", String.valueOf(e2));
                    this.mTotalSize = -1;
                }
            }
            if (this.mTotalSize > 0) {
                long j4 = this.mTotalSize;
                AppMethodBeat.o(137434);
                return j4;
            } else if (g.hv(this.Amq.toString()) > 0) {
                this.mTotalSize = g.hv(this.Amq.toString());
                long j5 = this.mTotalSize;
                AppMethodBeat.o(137434);
                return j5;
            } else {
                AppMethodBeat.o(137434);
                return -1;
            }
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public final String getMIMEType() {
        String contentType;
        AppMethodBeat.i(137435);
        if (!TextUtils.isEmpty(this.mMimeType)) {
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:" + this.mMimeType);
            String str = this.mMimeType;
            AppMethodBeat.o(137435);
            return str;
        }
        String aHB = g.aHB(this.Amq.toString());
        if (!TextUtils.isEmpty(aHB)) {
            this.mMimeType = aHB;
            AppMethodBeat.o(137435);
            return aHB;
        }
        if (this.mConnection == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                seekTo(0);
                contentType = this.mConnection.getContentType();
                Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (IOException e2) {
                Logger.e("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType exception:%s", String.valueOf(e2));
                contentType = "";
            }
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            contentType = this.mConnection.getContentType();
            Logger.i("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType mimeType:".concat(String.valueOf(contentType)));
            Log.d("MicroMsg.Music.MMMediaHTTPConnection", "getMIMEType cost time2 :%d!", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        }
        this.mMimeType = contentType;
        if (!TextUtils.isEmpty(contentType)) {
            AppMethodBeat.o(137435);
            return contentType;
        }
        String aHA = g.aHA(this.Amq.toString());
        this.mMimeType = aHA;
        if (!TextUtils.isEmpty(aHA)) {
            AppMethodBeat.o(137435);
            return aHA;
        }
        AppMethodBeat.o(137435);
        return "application/octet-stream";
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public final String getUri() {
        AppMethodBeat.i(137436);
        String url = this.mURL.toString();
        AppMethodBeat.o(137436);
        return url;
    }
}
