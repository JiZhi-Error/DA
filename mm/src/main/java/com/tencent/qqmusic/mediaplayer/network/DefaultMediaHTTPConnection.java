package com.tencent.qqmusic.mediaplayer.network;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Map;

public class DefaultMediaHTTPConnection implements IMediaHTTPConnection {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private long mTotalSize = -1;
    private URL mURL = null;

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public boolean connect(URL url, Map<String, String> map) {
        AppMethodBeat.i(76576);
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.mHeaders = map;
        AppMethodBeat.o(76576);
        return true;
    }

    private boolean parseBoolean(String str) {
        AppMethodBeat.i(76577);
        try {
            if (Long.parseLong(str) != 0) {
                AppMethodBeat.o(76577);
                return true;
            }
            AppMethodBeat.o(76577);
            return false;
        } catch (NumberFormatException e2) {
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                AppMethodBeat.o(76577);
                return true;
            }
            AppMethodBeat.o(76577);
            return false;
        }
    }

    private boolean filterOutInternalHeaders(String str, String str2) {
        AppMethodBeat.i(76578);
        if ("android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            this.mAllowCrossDomainRedirect = parseBoolean(str2);
            this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
            AppMethodBeat.o(76578);
            return true;
        }
        AppMethodBeat.o(76578);
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public void disconnect() {
        AppMethodBeat.i(76579);
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
        AppMethodBeat.o(76579);
    }

    private void teardownConnection() {
        AppMethodBeat.i(76580);
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
        AppMethodBeat.o(76580);
    }

    private static final boolean isLocalHost(URL url) {
        AppMethodBeat.i(76581);
        if (url == null) {
            AppMethodBeat.o(76581);
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            AppMethodBeat.o(76581);
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                AppMethodBeat.o(76581);
                return true;
            }
        } catch (IllegalArgumentException e2) {
            Logger.e(TAG, "isLocalHost", e2);
        }
        AppMethodBeat.o(76581);
        return false;
    }

    private void seekTo(long j2) {
        int lastIndexOf;
        boolean z;
        AppMethodBeat.i(76582);
        teardownConnection();
        try {
            URL url = this.mURL;
            boolean isLocalHost = isLocalHost(url);
            int i2 = 0;
            while (true) {
                if (isLocalHost) {
                    this.mConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
                } else {
                    this.mConnection = (HttpURLConnection) url.openConnection();
                }
                Logger.i(TAG, "setConnectTimeout " + this.mURL);
                this.mConnection.setConnectTimeout(30000);
                this.mConnection.setInstanceFollowRedirects(this.mAllowCrossDomainRedirect);
                boolean z2 = false;
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
                try {
                    int responseCode = this.mConnection.getResponseCode();
                    if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307) {
                        int i3 = i2 + 1;
                        if (i3 > 20) {
                            NoRouteToHostException noRouteToHostException = new NoRouteToHostException("Too many redirects: ".concat(String.valueOf(i3)));
                            AppMethodBeat.o(76582);
                            throw noRouteToHostException;
                        }
                        String requestMethod = this.mConnection.getRequestMethod();
                        if (responseCode != 307 || requestMethod.equals("GET") || requestMethod.equals("HEAD")) {
                            String headerField = this.mConnection.getHeaderField("Location");
                            if (headerField == null) {
                                NoRouteToHostException noRouteToHostException2 = new NoRouteToHostException("Invalid redirect");
                                AppMethodBeat.o(76582);
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
                                        i2 = i3;
                                    } else {
                                        NoRouteToHostException noRouteToHostException3 = new NoRouteToHostException("Cross-domain redirects are disallowed");
                                        AppMethodBeat.o(76582);
                                        throw noRouteToHostException3;
                                    }
                                } else {
                                    NoRouteToHostException noRouteToHostException4 = new NoRouteToHostException("Cross-protocol redirects are disallowed");
                                    AppMethodBeat.o(76582);
                                    throw noRouteToHostException4;
                                }
                            } else {
                                NoRouteToHostException noRouteToHostException5 = new NoRouteToHostException("Unsupported protocol redirect");
                                AppMethodBeat.o(76582);
                                throw noRouteToHostException5;
                            }
                        } else {
                            NoRouteToHostException noRouteToHostException6 = new NoRouteToHostException("Invalid redirect");
                            AppMethodBeat.o(76582);
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
                                    this.mTotalSize = Long.parseLong(headerField2.substring(lastIndexOf + 1));
                                } catch (NumberFormatException e2) {
                                }
                            }
                        } else if (responseCode != 200) {
                            IOException iOException = new IOException("failed! status code: ".concat(String.valueOf(responseCode)));
                            AppMethodBeat.o(76582);
                            throw iOException;
                        } else {
                            this.mTotalSize = (long) this.mConnection.getContentLength();
                        }
                        if (j2 <= 0 || responseCode == 206) {
                            this.mInputStream = new BufferedInputStream(this.mConnection.getInputStream());
                            this.mCurrentOffset = j2;
                            AppMethodBeat.o(76582);
                            return;
                        }
                        ProtocolException protocolException = new ProtocolException();
                        AppMethodBeat.o(76582);
                        throw protocolException;
                    }
                } catch (Exception e3) {
                    IOException iOException2 = new IOException("An suspicious exception occurred: " + e3.getMessage());
                    AppMethodBeat.o(76582);
                    throw iOException2;
                }
            }
        } catch (IOException e4) {
            this.mTotalSize = -1;
            this.mInputStream = null;
            this.mConnection = null;
            this.mCurrentOffset = -1;
            Logger.e(TAG, "seekTo", e4);
            AppMethodBeat.o(76582);
            throw e4;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public int readAt(long j2, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(76583);
        try {
            if (j2 != this.mCurrentOffset) {
                seekTo(j2);
            }
            int read = this.mInputStream.read(bArr, i2, i3);
            if (read == -1) {
                read = 0;
            }
            this.mCurrentOffset += (long) read;
            AppMethodBeat.o(76583);
            return read;
        } catch (ProtocolException e2) {
            Logger.w(TAG, "readAt " + j2 + " / " + i3 + " => " + e2);
            AppMethodBeat.o(76583);
            return -1010;
        } catch (NoRouteToHostException e3) {
            Logger.w(TAG, "readAt " + j2 + " / " + i3 + " => " + e3);
            AppMethodBeat.o(76583);
            return -1010;
        } catch (UnknownServiceException e4) {
            Logger.w(TAG, "readAt " + j2 + " / " + i3 + " => " + e4);
            AppMethodBeat.o(76583);
            return -1010;
        } catch (IOException e5) {
            AppMethodBeat.o(76583);
            return -2;
        } catch (Exception e6) {
            AppMethodBeat.o(76583);
            return -3;
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public long getSize() {
        AppMethodBeat.i(76584);
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (IOException e2) {
                Logger.e(TAG, "getSize", e2);
                AppMethodBeat.o(76584);
                return -1;
            }
        }
        long j2 = this.mTotalSize;
        AppMethodBeat.o(76584);
        return j2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getMIMEType() {
        AppMethodBeat.i(76585);
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (IOException e2) {
                Logger.e(TAG, "getMIMEType", e2);
                AppMethodBeat.o(76585);
                return "application/octet-stream";
            }
        }
        String contentType = this.mConnection.getContentType();
        AppMethodBeat.o(76585);
        return contentType;
    }

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection
    public String getUri() {
        AppMethodBeat.i(76586);
        String url = this.mURL.toString();
        AppMethodBeat.o(76586);
        return url;
    }
}
