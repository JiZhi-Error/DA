package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientUtil {
    public static void setProxy(HttpClient httpClient) {
        AppMethodBeat.i(102014);
        String netStatus = DownloadHelper.getNetStatus();
        if (!TextUtils.isEmpty(netStatus)) {
            if (netStatus.equalsIgnoreCase("cmwap") || netStatus.equalsIgnoreCase("3gwap") || netStatus.equalsIgnoreCase("uniwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.172", 80));
                AppMethodBeat.o(102014);
                return;
            } else if (netStatus.equalsIgnoreCase("ctwap")) {
                httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
            }
        }
        AppMethodBeat.o(102014);
    }

    public static HttpClient createHttpClient() {
        AppMethodBeat.i(102015);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, CommonUtils.MAX_TIMEOUT_MS);
        HttpConnectionParams.setSoTimeout(basicHttpParams, CommonUtils.MAX_TIMEOUT_MS);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 4096);
        HttpClientParams.setRedirecting(basicHttpParams, false);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        AppMethodBeat.o(102015);
        return defaultHttpClient;
    }
}
