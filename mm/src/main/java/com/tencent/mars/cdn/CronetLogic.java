package com.tencent.mars.cdn;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class CronetLogic {
    private static boolean useHttpdns = false;

    public static class CertVerifyResult {
        public byte[][] certificateChain = null;
        public boolean isIssuedByKnownRoot = false;
        public int status = 0;
    }

    public static class CronetDownloadProgress {
        public long currentWriteByte = 0;
        public long totalByte = 0;
    }

    public static class CronetHttpsCreateResult {
        public int createRet = 0;
        public String taskId = "";
    }

    public interface CronetTaskCallback {
        int onCronetReceiveHeader(ResponseHeader responseHeader, int i2);

        void onCronetTaskCompleted(String str, CronetTaskResult cronetTaskResult);

        void onDownloadProgressChanged(String str, CronetDownloadProgress cronetDownloadProgress);
    }

    public static class DefaultHttpTaskParams {
        public int reportId = 0;
    }

    public static class HeaderMap {
        public String key = "";
        public String value = "";
    }

    public static class HostIPHint {
        public HostIpMap[] hostMap;
    }

    public static class HostIpMap {
        public String host;
        public String ip;
        public int port;
    }

    public static class QuicForceHost {
        public String host;
        public int port;
    }

    public static class QuicHostMap {
        public String host;
        public String ip;
        public int port;
    }

    public static class QuicTaskParams {
        public QuicForceHost[] quicForceHosts;
        public QuicHostMap[] quicHostMaps;
    }

    public static class ResponseHeader {
        public HeaderMap[] headers = null;
    }

    public static native void cancelCronetTask(String str);

    public static native WebPageProfile getWebPagePerformanceWithURL(String str);

    public static native void removeUserCert();

    public static native void setUserCertVerify(boolean z);

    public static native CronetHttpsCreateResult startCronetDefaultHttpTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetDownloadTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static native CronetHttpsCreateResult startCronetHttpTask(CronetRequestParams cronetRequestParams, CronetTaskCallback cronetTaskCallback);

    public static class CronetRequestParams {
        public byte[] bodyData = null;
        public boolean cachePerformance = false;
        public DefaultHttpTaskParams defaultHttpTaskParams = null;
        public boolean followRedirect = false;
        public String header = "";
        public HeaderMap[] headers = null;
        public HostIPHint hostIPHint = null;
        public int maxRedirectCount = 2;
        public String method = "";
        public boolean needGenerateId = true;
        public boolean needWirteCache = false;
        public String savePath = "";
        public String taskId = "";
        public int taskType = 0;
        public String url = "";
        public boolean useHttp2 = false;
        public boolean useMemoryCache = false;
        public boolean useNewdns = false;
        public boolean useQuic = false;

        public static class CronetTaskType {
            public static final int DEFAULT_HTTP_REQUEST = 8;
            public static final int HTTP2_DOWNLOAD = 4;
            public static final int HTTP2_REQUEST = 3;
            public static final int HTTP_DOWNLOAD = 2;
            public static final int HTTP_REQUEST = 1;
            public static final int HTTP_UPLOAD = 7;
            public static final int QUIC_DOWNLOAD = 6;
            public static final int QUIC_REQUEST = 5;
        }

        public void makeRequestHeader(Map<String, String> map) {
            if (map == null || !map.isEmpty()) {
                int size = map.size();
                int i2 = 0;
                this.headers = new HeaderMap[size];
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    HeaderMap headerMap = new HeaderMap();
                    headerMap.key = entry.getKey();
                    headerMap.value = entry.getValue();
                    this.headers[i2] = headerMap;
                    i2++;
                    if (i2 > size) {
                        return;
                    }
                }
            }
        }
    }

    public static class WebPageProfile {
        public long SSLconnectionEnd;
        public long SSLconnectionStart;
        public long connectEnd;
        public long connectStart;
        public long domainLookUpEnd;
        public long domainLookUpStart;
        public int downstreamThroughputKbpsEstimate;
        public long fetchStart;
        public int httpRttEstimate;
        public int networkTypeEstimate;
        public String peerIP = "";
        public int port;
        public String protocol = "";
        public long receivedBytedCount;
        public long redirectEnd;
        public long redirectStart;
        public long requestEnd;
        public long requestStart;
        public long responseEnd;
        public long responseStart;
        public int rtt;
        public long sendBytesCount;
        public boolean socketReused;
        public int statusCode;
        public int throughputKbps;
        public int transportRttEstimate;

        public String toString() {
            return "WebPageProfile{redirectStart=" + this.redirectStart + ", redirectEnd=" + this.redirectEnd + ", fetchStart=" + this.fetchStart + ", domainLookUpStart=" + this.domainLookUpStart + ", domainLookUpEnd=" + this.domainLookUpEnd + ", connectStart=" + this.connectStart + ", connectEnd=" + this.connectEnd + ", SSLconnectionStart=" + this.SSLconnectionStart + ", SSLconnectionEnd=" + this.SSLconnectionEnd + ", requestStart=" + this.requestStart + ", requestEnd=" + this.requestEnd + ", responseStart=" + this.responseStart + ", responseEnd=" + this.responseEnd + ", protocol='" + this.protocol + '\'' + ", rtt=" + this.rtt + ", statusCode=" + this.statusCode + ", networkTypeEstimate=" + this.networkTypeEstimate + ", httpRttEstimate=" + this.httpRttEstimate + ", transportRttEstimate=" + this.transportRttEstimate + ", downstreamThroughputKbpsEstimate=" + this.downstreamThroughputKbpsEstimate + ", throughputKbps=" + this.throughputKbps + ", peerIP='" + this.peerIP + '\'' + ", port=" + this.port + ", socketReused=" + this.socketReused + ", sendBytesCount=" + this.sendBytesCount + ", receivedBytedCount=" + this.receivedBytedCount + '}';
        }
    }

    public static Map<String, String> getHeaderMap(ResponseHeader responseHeader) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        if (!(responseHeader == null || responseHeader.headers == null)) {
            HeaderMap[] headerMapArr = responseHeader.headers;
            for (HeaderMap headerMap : headerMapArr) {
                if (!(headerMap == null || headerMap.key == null || headerMap.value == null)) {
                    identityHashMap.put(new String(headerMap.key), headerMap.value);
                }
            }
        }
        return identityHashMap;
    }

    public static Map<String, List<String>> getHeaderList(ResponseHeader responseHeader) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : getHeaderMap(responseHeader).entrySet()) {
            String key = entry.getKey();
            if (key != null && !key.isEmpty()) {
                String value = entry.getValue();
                List list = (List) hashMap.get(key);
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(value);
                hashMap.put(key, list);
            }
        }
        return hashMap;
    }

    public static class CronetTaskResult {
        public byte[] data = null;
        public int errorCode = 0;
        public String errorMsg = "";
        public HeaderMap[] headers = null;
        public String newLocation = "";
        public String originTaskId = "";
        public int quicErrorCode = 0;
        public String rawHeader = "";
        public int statusCode = 0;
        public String statusText = "";
        public long totalReceiveByte = 0;
        public long totalWriteByte = 0;
        public WebPageProfile webPageProfile;

        public String getDataString() {
            try {
                return new String(this.data, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (Exception e2) {
                return "";
            }
        }

        public Map<String, String> getHeaderMap() {
            IdentityHashMap identityHashMap = new IdentityHashMap();
            if (this.headers != null) {
                HeaderMap[] headerMapArr = this.headers;
                for (HeaderMap headerMap : headerMapArr) {
                    if (!(headerMap == null || headerMap.key == null || headerMap.value == null)) {
                        identityHashMap.put(new String(headerMap.key), headerMap.value);
                    }
                }
            }
            return identityHashMap;
        }

        public Map<String, List<String>> getHeaderMapList() {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : getHeaderMap().entrySet()) {
                String key = entry.getKey();
                if (key != null && !key.isEmpty()) {
                    String value = entry.getValue();
                    List list = (List) hashMap.get(key);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(value);
                    hashMap.put(key, list);
                }
            }
            return hashMap;
        }
    }

    public static String getSystemProperty(String str) {
        String property = System.getProperty(str);
        Log.d("cronet", "property " + str + " res " + property);
        return property;
    }

    public static CertVerifyResult convertToCronetResult(AndroidCertVerifyResult androidCertVerifyResult) {
        CertVerifyResult certVerifyResult = new CertVerifyResult();
        certVerifyResult.status = androidCertVerifyResult.getStatus();
        certVerifyResult.isIssuedByKnownRoot = androidCertVerifyResult.isIssuedByKnownRoot();
        certVerifyResult.certificateChain = androidCertVerifyResult.getCertificateChainEncoded();
        return certVerifyResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("cronet", r1.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0084, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("cronet", r1.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f0, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f1, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("cronet", r1.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x013c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013d, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("cronet", r1.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return convertToCronetResult(new com.tencent.mars.cdn.AndroidCertVerifyResult(-1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return convertToCronetResult(new com.tencent.mars.cdn.AndroidCertVerifyResult(-5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return convertToCronetResult(new com.tencent.mars.cdn.AndroidCertVerifyResult(-1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return convertToCronetResult(new com.tencent.mars.cdn.AndroidCertVerifyResult(-1));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c A[ExcHandler: KeyStoreException (r1v13 'e' java.security.KeyStoreException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f0 A[ExcHandler: NoSuchAlgorithmException (r1v9 'e' java.security.NoSuchAlgorithmException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013c A[ExcHandler: IOException (r1v1 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mars.cdn.CronetLogic.CertVerifyResult verifyCertWithUserCA(byte[][] r13) {
        /*
        // Method dump skipped, instructions count: 346
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mars.cdn.CronetLogic.verifyCertWithUserCA(byte[][]):com.tencent.mars.cdn.CronetLogic$CertVerifyResult");
    }

    public static void setUseHttpdns(boolean z) {
        Log.i("cronet", "use httpdns ".concat(String.valueOf(z)));
        useHttpdns = z;
    }

    public static boolean getUseHttpdns() {
        return useHttpdns;
    }
}
