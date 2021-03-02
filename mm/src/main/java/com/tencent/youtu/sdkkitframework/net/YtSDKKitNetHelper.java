package com.tencent.youtu.sdkkitframework.net;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class YtSDKKitNetHelper {
    private static final String TAG = YtSDKKitNetHelper.class.getSimpleName();
    private static final int TIME_OUT = 10000;
    private static YtSDKKitNetHelper _instane;
    private HttpsURLConnection conn;
    private Thread networkThread;
    private HashMap<Integer, Thread> runningMap = new HashMap<>();

    static {
        AppMethodBeat.i(192707);
        AppMethodBeat.o(192707);
    }

    public static synchronized YtSDKKitNetHelper getInstance() {
        YtSDKKitNetHelper ytSDKKitNetHelper;
        synchronized (YtSDKKitNetHelper.class) {
            AppMethodBeat.i(192702);
            if (_instane == null) {
                _instane = new YtSDKKitNetHelper();
            }
            ytSDKKitNetHelper = _instane;
            AppMethodBeat.o(192702);
        }
        return ytSDKKitNetHelper;
    }

    public static synchronized void clearInstance() {
        synchronized (YtSDKKitNetHelper.class) {
            AppMethodBeat.i(192703);
            if (_instane != null) {
                _instane.stopNetworkRequest();
            }
            _instane = null;
            AppMethodBeat.o(192703);
        }
    }

    private YtSDKKitNetHelper() {
        AppMethodBeat.i(192704);
        AppMethodBeat.o(192704);
    }

    public void stopNetworkRequest() {
        AppMethodBeat.i(192705);
        for (Map.Entry<Integer, Thread> entry : this.runningMap.entrySet()) {
            if (entry.getValue() == this.networkThread) {
                this.runningMap.remove(entry.getKey());
                YtLogger.d(TAG, "network remove " + entry.getKey());
                AppMethodBeat.o(192705);
                return;
            }
        }
        AppMethodBeat.o(192705);
    }

    public void sendNetworkRequest(final String str, final String str2, final HashMap<String, String> hashMap, final YtSDKKitFramework.IYtSDKKitNetResponseParser iYtSDKKitNetResponseParser) {
        AppMethodBeat.i(192706);
        this.networkThread = new Thread(new Runnable() {
            /* class com.tencent.youtu.sdkkitframework.net.YtSDKKitNetHelper.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(192701);
                try {
                    YtSDKKitNetHelper.this.runningMap.put(Integer.valueOf(Process.myTid()), YtSDKKitNetHelper.this.networkThread);
                    URL url = new URL(str);
                    YtSDKKitNetHelper.this.conn = (HttpsURLConnection) url.openConnection();
                    YtSDKKitNetHelper.this.conn.setRequestMethod("POST");
                    YtSDKKitNetHelper.this.conn.setConnectTimeout(YtSDKKitFramework.getInstance().getNetworkRequestTimeoutMS());
                    if (hashMap != null) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            YtSDKKitNetHelper.this.conn.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Write buffer");
                    OutputStream outputStream = YtSDKKitNetHelper.this.conn.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                    bufferedWriter.write(str2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Wait response");
                    int responseCode = YtSDKKitNetHelper.this.conn.getResponseCode();
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Get response");
                    if (!YtSDKKitNetHelper.this.runningMap.containsKey(Integer.valueOf(Process.myTid()))) {
                        YtLogger.i(YtSDKKitNetHelper.TAG, "Exit network response handling");
                        YtSDKKitNetHelper.this.conn.disconnect();
                        return;
                    }
                    if (responseCode == 200) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(YtSDKKitNetHelper.this.conn.getInputStream()));
                        StringBuffer stringBuffer = new StringBuffer("");
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        }
                        bufferedReader.close();
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("response", stringBuffer.toString());
                        iYtSDKKitNetResponseParser.onNetworkResponseEvent(hashMap, null);
                    } else {
                        YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed ".concat(String.valueOf(responseCode)));
                        iYtSDKKitNetResponseParser.onNetworkResponseEvent(null, new Exception("Https Response Failed with code:".concat(String.valueOf(responseCode))));
                    }
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                    YtSDKKitNetHelper.this.conn.disconnect();
                    AppMethodBeat.o(192701);
                } catch (Exception e2) {
                    YtLogger.e(YtSDKKitNetHelper.TAG, "Network response failed " + e2.getLocalizedMessage());
                    iYtSDKKitNetResponseParser.onNetworkResponseEvent(null, e2);
                } finally {
                    YtLogger.d(YtSDKKitNetHelper.TAG, "Network disconnected");
                    YtSDKKitNetHelper.this.conn.disconnect();
                    AppMethodBeat.o(192701);
                }
            }
        });
        this.networkThread.setName("YtNetworkRequestThread");
        this.networkThread.start();
        AppMethodBeat.o(192706);
    }
}
