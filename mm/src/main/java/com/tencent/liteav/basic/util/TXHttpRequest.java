package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class TXHttpRequest {
    private static final int CON_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static final String TAG = "TXHttpRequest";
    private long mNativeHttps = 0;

    private native void nativeOnRecvMessage(long j2, int i2, byte[] bArr);

    static /* synthetic */ void access$100(TXHttpRequest tXHttpRequest, long j2, int i2, byte[] bArr) {
        AppMethodBeat.i(14710);
        tXHttpRequest.nativeOnRecvMessage(j2, i2, bArr);
        AppMethodBeat.o(14710);
    }

    public TXHttpRequest(long j2) {
        this.mNativeHttps = j2;
    }

    public static byte[] getHttpPostRsp(Map<String, String> map, String str, byte[] bArr) {
        AppMethodBeat.i(14705);
        TXCLog.i(TAG, "getHttpPostRsp->request: ".concat(String.valueOf(str)));
        TXCLog.i(TAG, "getHttpPostRsp->data size: " + bArr.length);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str.replace(" ", "%20")).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setRequestMethod("POST");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    TXCLog.i(TAG, "getHttpsPostRsp->rsp size: " + byteArrayOutputStream.size());
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(14705);
                    return byteArray;
                }
            }
        } else {
            TXCLog.i(TAG, "getHttpPostRsp->response code: ".concat(String.valueOf(responseCode)));
            Exception exc = new Exception("response: ".concat(String.valueOf(responseCode)));
            AppMethodBeat.o(14705);
            throw exc;
        }
    }

    public int sendHttpsRequest(Map<String, String> map, String str, byte[] bArr) {
        AppMethodBeat.i(14706);
        TXCLog.i(TAG, "sendHttpsRequest->enter action: " + str + ", data size: " + bArr.length);
        asyncPostRequest(map, str.getBytes(), bArr);
        AppMethodBeat.o(14706);
        return 0;
    }

    public int sendHttpsRequest(String str, byte[] bArr) {
        AppMethodBeat.i(14707);
        TXCLog.i(TAG, "sendHttpsRequest->enter action: " + str + ", data size: " + bArr.length);
        asyncPostRequest(null, str.getBytes(), bArr);
        AppMethodBeat.o(14707);
        return 0;
    }

    public static byte[] getHttpsPostRsp(Map<String, String> map, String str, byte[] bArr) {
        AppMethodBeat.i(14708);
        TXCLog.i(TAG, "getHttpsPostRsp->request: ".concat(String.valueOf(str)));
        TXCLog.i(TAG, "getHttpsPostRsp->data: " + bArr.length);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str.replace(" ", "%20")).openConnection();
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setConnectTimeout(5000);
        httpsURLConnection.setReadTimeout(5000);
        httpsURLConnection.setRequestMethod("POST");
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpsURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    inputStream.close();
                    httpsURLConnection.disconnect();
                    TXCLog.i(TAG, "getHttpsPostRsp->rsp size: " + byteArrayOutputStream.size());
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    AppMethodBeat.o(14708);
                    return byteArray;
                }
            }
        } else {
            TXCLog.i(TAG, "getHttpsPostRsp->response code: ".concat(String.valueOf(responseCode)));
            Exception exc = new Exception("response: ".concat(String.valueOf(responseCode)));
            AppMethodBeat.o(14708);
            throw exc;
        }
    }

    public void asyncPostRequest(Map<String, String> map, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(14709);
        new a(this, map).execute(bArr, bArr2);
        AppMethodBeat.o(14709);
    }

    /* access modifiers changed from: package-private */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f444a = 1;

        /* renamed from: b  reason: collision with root package name */
        public String f445b = "";

        /* renamed from: c  reason: collision with root package name */
        public byte[] f446c = "".getBytes();

        b() {
            AppMethodBeat.i(14698);
            AppMethodBeat.o(14698);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends AsyncTask<byte[], Void, b> {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<TXHttpRequest> f438a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f439b = null;

        /* renamed from: c  reason: collision with root package name */
        private Map<String, String> f440c;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* synthetic */ b doInBackground(byte[][] bArr) {
            AppMethodBeat.i(14732);
            b a2 = a(bArr);
            AppMethodBeat.o(14732);
            return a2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public /* synthetic */ void onPostExecute(b bVar) {
            AppMethodBeat.i(14731);
            a(bVar);
            AppMethodBeat.o(14731);
        }

        public a(TXHttpRequest tXHttpRequest, Map<String, String> map) {
            AppMethodBeat.i(14728);
            this.f440c = map;
            this.f438a = new WeakReference<>(tXHttpRequest);
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.f439b = new Handler(myLooper);
                AppMethodBeat.o(14728);
                return;
            }
            this.f439b = null;
            AppMethodBeat.o(14728);
        }

        /* access modifiers changed from: protected */
        public b a(byte[]... bArr) {
            AppMethodBeat.i(14729);
            b bVar = new b();
            try {
                if (new String(bArr[0]).startsWith("https")) {
                    bVar.f446c = TXHttpRequest.getHttpsPostRsp(this.f440c, new String(bArr[0]), bArr[1]);
                } else {
                    bVar.f446c = TXHttpRequest.getHttpPostRsp(this.f440c, new String(bArr[0]), bArr[1]);
                }
                bVar.f444a = 0;
            } catch (Exception e2) {
                bVar.f445b = e2.toString();
                bVar.f444a = 1;
            }
            TXCLog.i(TXHttpRequest.TAG, "TXPostRequest->result: " + bVar.f444a + "|" + bVar.f445b);
            AppMethodBeat.o(14729);
            return bVar;
        }

        /* access modifiers changed from: protected */
        public void a(final b bVar) {
            AppMethodBeat.i(14730);
            super.onPostExecute(bVar);
            final TXHttpRequest tXHttpRequest = this.f438a.get();
            if (!(tXHttpRequest == null || tXHttpRequest.mNativeHttps == 0)) {
                if (this.f439b != null) {
                    this.f439b.post(new Runnable() {
                        /* class com.tencent.liteav.basic.util.TXHttpRequest.a.AnonymousClass1 */

                        public void run() {
                            AppMethodBeat.i(14704);
                            TXCLog.i(TXHttpRequest.TAG, "TXPostRequest->recvMsg: " + bVar.f444a + "|" + bVar.f445b);
                            TXHttpRequest.access$100(tXHttpRequest, tXHttpRequest.mNativeHttps, bVar.f444a, bVar.f446c);
                            AppMethodBeat.o(14704);
                        }
                    });
                    AppMethodBeat.o(14730);
                    return;
                }
                TXCLog.i(TXHttpRequest.TAG, "TXPostRequest->recvMsg: " + bVar.f444a + "|" + bVar.f445b);
                TXHttpRequest.access$100(tXHttpRequest, tXHttpRequest.mNativeHttps, bVar.f444a, bVar.f446c);
            }
            AppMethodBeat.o(14730);
        }
    }
}
