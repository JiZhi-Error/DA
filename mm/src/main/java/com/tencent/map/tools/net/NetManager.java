package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.adapter.AbsNetImpl;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

public class NetManager {
    private static final boolean DEBUG = false;
    private static final String TAG = "NetManager";
    private static NetManager sInstance;
    private NetAdapter mAdapter;
    private boolean mInited = false;

    public static synchronized NetManager getInstance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            AppMethodBeat.i(172915);
            if (sInstance == null) {
                sInstance = new NetManager();
            }
            netManager = sInstance;
            AppMethodBeat.o(172915);
        }
        return netManager;
    }

    private NetManager() {
        AppMethodBeat.i(172916);
        AppMethodBeat.o(172916);
    }

    public void setAdapter(Context context, NetAdapter netAdapter) {
        AppMethodBeat.i(172919);
        if (netAdapter == null) {
            AppMethodBeat.o(172919);
            return;
        }
        if (this.mAdapter != netAdapter) {
            this.mInited = false;
            this.mAdapter = netAdapter;
            init(context);
        }
        AppMethodBeat.o(172919);
    }

    private void init(Context context) {
        AppMethodBeat.i(180921);
        if (this.mInited || this.mAdapter == null) {
            AppMethodBeat.o(180921);
            return;
        }
        this.mAdapter.initNet(context.getApplicationContext());
        this.mInited = true;
        AppMethodBeat.o(180921);
    }

    public NetRequestBuilder builder() {
        AppMethodBeat.i(172920);
        NetRequestBuilder netRequestBuilder = new NetRequestBuilder();
        if (this.mAdapter instanceof AbsNetImpl) {
            netRequestBuilder.mForceHttps = ((AbsNetImpl) this.mAdapter).isForceHttps();
        }
        AppMethodBeat.o(172920);
        return netRequestBuilder;
    }

    public NetResponse doGet(String str, String str2, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        AppMethodBeat.i(172921);
        if (this.mAdapter == null) {
            AppMethodBeat.o(172921);
            return null;
        }
        NetResponse doGet = this.mAdapter.doGet(str, str2, i2, i3, hashMap, httpCanceler);
        AppMethodBeat.o(172921);
        return doGet;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        AppMethodBeat.i(172922);
        if (this.mAdapter == null) {
            AppMethodBeat.o(172922);
            return null;
        }
        NetResponse doPost = this.mAdapter.doPost(str, str2, bArr, i2, i3, hashMap, httpCanceler);
        AppMethodBeat.o(172922);
        return doPost;
    }

    public NetResponse doPostNoBuffer(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(172923);
        if (this.mAdapter == null) {
            AppMethodBeat.o(172923);
            return null;
        }
        NetResponse doPostNoBuffer = this.mAdapter.doPostNoBuffer(str, str2, bArr);
        AppMethodBeat.o(172923);
        return doPostNoBuffer;
    }

    public void doRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler) {
        AppMethodBeat.i(172924);
        if (this.mAdapter != null) {
            this.mAdapter.doRangePost(str, bArr, str2, str3, str4, str5, httpCanceler);
        }
        AppMethodBeat.o(172924);
    }

    public class NetRequestBuilder {
        private File mCacheFile;
        private HttpCanceler mCanceler;
        private boolean mForceHttps = true;
        private HashMap<String, String> mHeaders;
        private String mNonce;
        private byte[] mPostData;
        private long mRequestId = System.nanoTime();
        private int mRetryNum = 1;
        private String mStartTag;
        private int mTimeout = 10000;
        private String mTimestamp;
        private String mToken;
        private String mUrl;
        private String mUserAgent = NetUtil.MAP_USER_AGENT;

        NetRequestBuilder() {
            AppMethodBeat.i(180920);
            AppMethodBeat.o(180920);
        }

        public NetRequestBuilder url(String str) {
            this.mUrl = str;
            return this;
        }

        public NetRequestBuilder userAgent(String str) {
            this.mUserAgent = str;
            return this;
        }

        public NetRequestBuilder postData(byte[] bArr) {
            this.mPostData = bArr;
            return this;
        }

        public NetRequestBuilder retryNum(int i2) {
            this.mRetryNum = i2;
            return this;
        }

        public NetRequestBuilder timeOut(int i2) {
            this.mTimeout = i2;
            return this;
        }

        public NetRequestBuilder header(HashMap<String, String> hashMap) {
            this.mHeaders = hashMap;
            return this;
        }

        public NetRequestBuilder canceler(HttpCanceler httpCanceler) {
            this.mCanceler = httpCanceler;
            return this;
        }

        public NetRequestBuilder token(String str) {
            this.mToken = str;
            return this;
        }

        public NetRequestBuilder nonce(String str) {
            this.mNonce = str;
            return this;
        }

        public NetRequestBuilder timestamp(String str) {
            this.mTimestamp = str;
            return this;
        }

        public NetRequestBuilder startTag(String str) {
            this.mStartTag = str;
            return this;
        }

        public NetRequestBuilder file(File file) {
            this.mCacheFile = file;
            return this;
        }

        public NetRequestBuilder forceHttps(boolean z) {
            this.mForceHttps = z;
            return this;
        }

        public NetResponse doPost() {
            AppMethodBeat.i(172910);
            onRequestStart("doPost", this);
            NetResponse onRequestFinish = onRequestFinish(NetManager.this.doPost(this.mUrl, this.mUserAgent, this.mPostData, this.mRetryNum, this.mTimeout, this.mHeaders, this.mCanceler));
            AppMethodBeat.o(172910);
            return onRequestFinish;
        }

        public NetResponse doPostNoBuffer() {
            AppMethodBeat.i(172911);
            onRequestStart("doPostNoBuffer", this);
            NetResponse onRequestFinish = onRequestFinish(NetManager.this.doPostNoBuffer(urlChecking(this.mUrl), this.mUserAgent, this.mPostData));
            AppMethodBeat.o(172911);
            return onRequestFinish;
        }

        public void doRangePost() {
            AppMethodBeat.i(172912);
            onRequestStart("doRangePost", this);
            NetManager.this.doRangePost(urlChecking(this.mUrl), this.mPostData, this.mToken, this.mNonce, this.mTimestamp, this.mStartTag, this.mCanceler);
            AppMethodBeat.o(172912);
        }

        public NetResponse doGet() {
            AppMethodBeat.i(172913);
            onRequestStart("doGet", this);
            NetResponse onRequestFinish = onRequestFinish(NetManager.this.doGet(urlChecking(this.mUrl), this.mUserAgent, this.mRetryNum, this.mTimeout, this.mHeaders, this.mCanceler));
            AppMethodBeat.o(172913);
            return onRequestFinish;
        }

        private void onRequestStart(String str, NetRequestBuilder netRequestBuilder) {
        }

        private NetResponse onRequestFinish(NetResponse netResponse) {
            Throwable th;
            Exception e2;
            AppMethodBeat.i(193590);
            if (!(netResponse == null || this.mCacheFile == null)) {
                FileOutputStream fileOutputStream = null;
                try {
                    if (this.mCacheFile.isFile()) {
                        if (this.mCacheFile.exists()) {
                            this.mCacheFile.delete();
                        }
                        this.mCacheFile.getParentFile().mkdirs();
                        this.mCacheFile.createNewFile();
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.mCacheFile);
                    try {
                        NetUtil.writeBytesWithoutClose(netResponse.data, fileOutputStream2);
                        NetUtil.safeClose(fileOutputStream2);
                    } catch (Exception e3) {
                        e2 = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            NetUtil.safeClose(fileOutputStream);
                            netResponse = new NetResponse(e2);
                            NetUtil.safeClose(fileOutputStream);
                            AppMethodBeat.o(193590);
                            return netResponse;
                        } catch (Throwable th2) {
                            th = th2;
                            NetUtil.safeClose(fileOutputStream);
                            AppMethodBeat.o(193590);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = fileOutputStream2;
                        NetUtil.safeClose(fileOutputStream);
                        AppMethodBeat.o(193590);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    NetUtil.safeClose(fileOutputStream);
                    netResponse = new NetResponse(e2);
                    NetUtil.safeClose(fileOutputStream);
                    AppMethodBeat.o(193590);
                    return netResponse;
                }
            }
            AppMethodBeat.o(193590);
            return netResponse;
        }

        private String urlChecking(String str) {
            AppMethodBeat.i(193591);
            if (this.mForceHttps && str.startsWith(HttpWrapperBase.PROTOCAL_HTTP)) {
                str = str.replaceFirst(HttpWrapperBase.PROTOCAL_HTTP, HttpWrapperBase.PROTOCAL_HTTPS);
            }
            AppMethodBeat.o(193591);
            return str;
        }

        public String toString() {
            AppMethodBeat.i(172914);
            StringBuilder sb = new StringBuilder("NetRequestBuilder{");
            sb.append("mUrl='").append(this.mUrl).append('\'');
            sb.append(", mUserAgent='").append(this.mUserAgent).append('\'');
            sb.append(", mPostData=");
            if (this.mPostData == null) {
                sb.append(BuildConfig.COMMAND);
            } else {
                sb.append('[');
                int i2 = 0;
                while (i2 < this.mPostData.length) {
                    sb.append(i2 == 0 ? "" : ", ").append((int) this.mPostData[i2]);
                    i2++;
                }
                sb.append(']');
            }
            sb.append(", mRetryNum=").append(this.mRetryNum);
            sb.append(", mTimeout=").append(this.mTimeout);
            sb.append(", mHeaders=").append(this.mHeaders);
            sb.append(", mCanceler=").append(this.mCanceler);
            sb.append(", mToken='").append(this.mToken).append('\'');
            sb.append(", mNonce='").append(this.mNonce).append('\'');
            sb.append(", mTimestamp='").append(this.mTimestamp).append('\'');
            sb.append(", mStartTag='").append(this.mStartTag).append('\'');
            sb.append('}');
            String sb2 = sb.toString();
            AppMethodBeat.o(172914);
            return sb2;
        }

        public NetResponse downloadTo(File file) {
            AppMethodBeat.i(193592);
            onRequestStart("downloadTo[" + file + "]", this);
            NetResponse doGet = file(file).doGet();
            AppMethodBeat.o(193592);
            return doGet;
        }
    }
}
