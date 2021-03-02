package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.luggage.a.e;
import com.tencent.luggage.h.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class z {
    private static p.a KwS = null;
    private static final Pattern KwT = Pattern.compile("data:(image|img)/\\S+;base64,\\S+");
    private static int KwU = -1;
    private static int KwV = -1;
    private static int KwW = -1;
    private static QueueWorkerThread jNp = null;

    public interface a {
        void abE(String str);
    }

    public interface b {
        void cT(String str);
    }

    static {
        AppMethodBeat.i(103177);
        AppMethodBeat.o(103177);
    }

    @Deprecated
    public static String cr(Context context, String str) {
        AppMethodBeat.i(103155);
        String a2 = p.a(context, str, (p.a) e.M(p.a.class));
        AppMethodBeat.o(103155);
        return a2;
    }

    public static boolean bfF(String str) {
        AppMethodBeat.i(103156);
        if (str == null) {
            AppMethodBeat.o(103156);
            return false;
        }
        boolean contains = str.toLowerCase().contains(" MicroMessenger/".trim().toLowerCase());
        AppMethodBeat.o(103156);
        return contains;
    }

    public static boolean C(String str, String str2) {
        AppMethodBeat.i(103157);
        boolean C = l.C(str, str2);
        AppMethodBeat.o(103157);
        return C;
    }

    @Deprecated
    public static PackageInfo getPackageInfo(Context context, String str) {
        AppMethodBeat.i(103158);
        PackageInfo packageInfo = com.tencent.mm.plugin.appbrand.ac.b.getPackageInfo(context, str);
        AppMethodBeat.o(103158);
        return packageInfo;
    }

    public static void b(final Context context, final String str, final String str2, final boolean z) {
        AppMethodBeat.i(103159);
        com.tencent.mm.platformtools.p.a(context, new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(224520);
                if (z.jNp == null) {
                    QueueWorkerThread unused = z.jNp = new QueueWorkerThread(1, "webview-save-image", 1);
                }
                z.jNp.add(new c(context, str, str2, z));
                AppMethodBeat.o(224520);
            }
        }, new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(224521);
                Toast.makeText(context, context.getString(R.string.j4z), 1).show();
                AppMethodBeat.o(224521);
            }
        });
        AppMethodBeat.o(103159);
    }

    public static void a(Context context, String str, String str2, boolean z, a aVar) {
        AppMethodBeat.i(103160);
        if (jNp == null) {
            jNp = new QueueWorkerThread(1, "webview-save-image", 1);
        }
        jNp.add(new c(context, str, str2, z, 1, aVar));
        AppMethodBeat.o(103160);
    }

    public static void c(final WebView webView) {
        AppMethodBeat.i(103161);
        if (webView == null) {
            AppMethodBeat.o(103161);
            return;
        }
        a(new b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.z.b
            public final void cT(String str) {
                AppMethodBeat.i(224522);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.o(224522);
            }
        });
        AppMethodBeat.o(103161);
    }

    private static void a(final b bVar) {
        AppMethodBeat.i(103162);
        Log.d("MicroMsg.WebViewUtil", "initIFrame");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(224523);
                bVar.cT("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}");
                AppMethodBeat.o(224523);
            }
        });
        AppMethodBeat.o(103162);
    }

    public static void a(WebView webView, String str, String str2) {
        AppMethodBeat.i(103163);
        a(webView, str, str2, true);
        AppMethodBeat.o(103163);
    }

    public static void a(final WebView webView, String str, String str2, boolean z) {
        AppMethodBeat.i(103164);
        if (webView == null) {
            AppMethodBeat.o(103164);
            return;
        }
        a(new b() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.tools.z.b
            public final void cT(String str) {
                AppMethodBeat.i(224524);
                webView.evaluateJavascript(str, null);
                AppMethodBeat.o(224524);
            }
        }, str, str2, z);
        AppMethodBeat.o(103164);
    }

    private static void a(final b bVar, final String str, final String str2, final boolean z) {
        AppMethodBeat.i(103165);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WebViewUtil", "getJsResult fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.o(103165);
            return;
        }
        Log.d("MicroMsg.WebViewUtil", "getJsResult, scheme = %s, jsCode = %s", str, str2);
        a(bVar);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.tools.z.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(224525);
                if (z) {
                    bVar.cT("javascript:document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2);
                    AppMethodBeat.o(224525);
                    return;
                }
                bVar.cT("javascript:console.log('" + str + "' + " + str2 + ")");
                AppMethodBeat.o(224525);
            }
        });
        AppMethodBeat.o(103165);
    }

    public static String mH(String str, String str2) {
        AppMethodBeat.i(103166);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.WebViewUtil", "genJsCode fail, invalid argument, scheme = %s, jsCode = %s", str, str2);
            AppMethodBeat.o(103166);
            return null;
        }
        Log.d("MicroMsg.WebViewUtil", "genJsCode, scheme = %s, jsCode = %s", str, str2);
        String str3 = "document.getElementById('_edw_iframe_').src = '" + str + "' + " + str2;
        AppMethodBeat.o(103166);
        return str3;
    }

    static class c implements QueueWorkerThread.ThreadObject {
        private static Pattern Kxd = Pattern.compile("image/[A-Za-z0-9]+");
        private static Pattern Kxe = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
        private String Kxf;
        private String Kxg;
        private a Kxh;
        private Context context;
        private String imagePath;
        private String imageUrl;
        private int opType;
        private boolean qoo;

        static {
            AppMethodBeat.i(103154);
            AppMethodBeat.o(103154);
        }

        public c(Context context2, String str, String str2, boolean z) {
            this(context2, str, str2, z, 0, null);
        }

        public c(Context context2, String str, String str2, boolean z, int i2, a aVar) {
            this.context = context2;
            this.imageUrl = str;
            this.Kxg = str2;
            this.qoo = z;
            this.opType = i2;
            this.Kxh = aVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean onPostExecute() {
            AppMethodBeat.i(103149);
            if (1 == this.opType) {
                this.Kxh.abE(this.imagePath);
                AppMethodBeat.o(103149);
            } else {
                if (!Util.isNullOrNil(this.Kxf)) {
                    Toast.makeText(this.context, this.Kxf, 1).show();
                } else {
                    Toast.makeText(this.context, this.context.getString(R.string.j4z), 1).show();
                }
                AppMethodBeat.o(103149);
            }
            return true;
        }

        private String bfN(String str) {
            AppMethodBeat.i(224526);
            this.imagePath = s.getSysCameraDirPath() + String.format(Locale.US, "mmexport%s.%s", MD5Util.getMD5String(this.imageUrl), str);
            if (s.YS(this.imagePath)) {
                s.deleteFile(this.imagePath);
            }
            String str2 = this.imagePath;
            AppMethodBeat.o(224526);
            return str2;
        }

        private void gsO() {
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            Throwable th;
            Exception e2;
            AppMethodBeat.i(103150);
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.imageUrl).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("Cookie", this.Kxg);
                    httpURLConnection2.setAllowUserInteraction(true);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        if (responseCode == 301 || responseCode == 302) {
                            String headerField = httpURLConnection2.getHeaderField("Location");
                            if (headerField == null) {
                                headerField = httpURLConnection2.getHeaderField(FirebaseAnalytics.b.LOCATION);
                            }
                            Log.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                            if (!Util.isNullOrNil(headerField)) {
                                this.imageUrl = headerField;
                                gsO();
                                a(httpURLConnection2, null);
                                AppMethodBeat.o(103150);
                                return;
                            }
                        }
                        this.Kxf = this.context.getString(R.string.j4z);
                        a(httpURLConnection2, null);
                        AppMethodBeat.o(103150);
                        return;
                    }
                    String contentType = httpURLConnection2.getContentType();
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        a(contentType, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                        a(httpURLConnection2, inputStream);
                        AppMethodBeat.o(103150);
                    } catch (Exception e3) {
                        e2 = e3;
                        httpURLConnection = httpURLConnection2;
                        try {
                            Log.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e2.getMessage());
                            a(httpURLConnection, inputStream);
                            AppMethodBeat.o(103150);
                        } catch (Throwable th2) {
                            th = th2;
                            a(httpURLConnection, inputStream);
                            AppMethodBeat.o(103150);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        a(httpURLConnection, inputStream);
                        AppMethodBeat.o(103150);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    Log.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e2.getMessage());
                    a(httpURLConnection, inputStream);
                    AppMethodBeat.o(103150);
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    a(httpURLConnection, inputStream);
                    AppMethodBeat.o(103150);
                    throw th;
                }
            } catch (Exception e5) {
                e2 = e5;
                inputStream = null;
                httpURLConnection = null;
                Log.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", e2.getMessage());
                a(httpURLConnection, inputStream);
                AppMethodBeat.o(103150);
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                httpURLConnection = null;
                a(httpURLConnection, inputStream);
                AppMethodBeat.o(103150);
                throw th;
            }
        }

        private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
            AppMethodBeat.i(184502);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e2) {
                    Log.e("MicroMsg.WebViewUtil", e2.getMessage());
                }
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(184502);
                    return;
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.WebViewUtil", e3, "", new Object[0]);
                }
            }
            AppMethodBeat.o(184502);
        }

        private void a(String str, String str2, InputStream inputStream) {
            AppMethodBeat.i(177338);
            Log.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", str, str2);
            String str3 = null;
            if (!Util.isNullOrNil(str)) {
                Matcher matcher = Kxd.matcher(str);
                if (matcher.find()) {
                    str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
                }
            }
            if (Util.isNullOrNil(str3) && !Util.isNullOrNil(str2)) {
                Matcher matcher2 = Kxe.matcher(str2);
                if (matcher2.find()) {
                    str3 = matcher2.group().substring(matcher2.group().lastIndexOf(46) + 1);
                }
            }
            if (Util.isNullOrNil(str3)) {
                x xVar = new x(this.imageUrl);
                int lastIndexOf = xVar.mPath.lastIndexOf(46);
                if (lastIndexOf == -1) {
                    str3 = "jpg";
                } else {
                    str3 = xVar.mPath.substring(lastIndexOf + 1);
                }
            }
            this.imagePath = bfN(str3);
            OutputStream dw = s.dw(this.imagePath, false);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    dw.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.WebViewUtil", "close os failed : %s", e2.getMessage());
                    }
                }
            }
            dw.flush();
            dw.close();
            if (this.opType == 0) {
                this.Kxf = this.context.getString(R.string.bjr, s.getToastSysCameraPath());
                s.refreshMediaScanner(this.imagePath, this.context);
            }
            AppMethodBeat.o(177338);
        }

        @Override // com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject
        public final boolean doInBackground() {
            HttpsURLConnection httpsURLConnection;
            InputStream inputStream;
            Throwable th;
            Exception e2;
            OutputStream outputStream = null;
            AppMethodBeat.i(103153);
            if (!this.qoo) {
                this.Kxf = this.context.getString(R.string.j50);
                AppMethodBeat.o(103153);
                return true;
            } else if (Util.isNullOrNil(this.imageUrl)) {
                AppMethodBeat.o(103153);
                return false;
            } else {
                if (URLUtil.isDataUrl(this.imageUrl)) {
                    String str = "jpg";
                    if ((!Util.isNullOrNil(this.imageUrl) && this.imageUrl.startsWith("data:image/png")) || this.imageUrl.startsWith("data:image/png".toUpperCase())) {
                        str = "png";
                    }
                    this.imagePath = bfN(str);
                    try {
                        int indexOf = this.imageUrl.indexOf("base64");
                        if (indexOf > 0) {
                            this.imageUrl = this.imageUrl.substring(indexOf + 7);
                        }
                        OutputStream dw = s.dw(this.imagePath, false);
                        byte[] decode = Base64.decode(this.imageUrl, 0);
                        if (decode != null) {
                            dw.write(decode);
                        }
                        dw.flush();
                        dw.close();
                        this.Kxf = this.context.getString(R.string.bjr, s.getToastSysCameraPath());
                        s.refreshMediaScanner(this.imagePath, this.context);
                        if (dw != null) {
                            try {
                                dw.close();
                            } catch (Exception e3) {
                                Log.e("MicroMsg.WebViewUtil", "close OutputStream failed : %s", e3.getMessage());
                            }
                        }
                    } catch (Exception e4) {
                        Log.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", e4.getMessage());
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Exception e5) {
                                Log.e("MicroMsg.WebViewUtil", "close OutputStream failed : %s", e5.getMessage());
                            }
                        }
                    } catch (Throwable th2) {
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Exception e6) {
                                Log.e("MicroMsg.WebViewUtil", "close OutputStream failed : %s", e6.getMessage());
                            }
                        }
                        AppMethodBeat.o(103153);
                        throw th2;
                    }
                } else if (URLUtil.isHttpsUrl(this.imageUrl)) {
                    try {
                        HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) new URL(this.imageUrl).openConnection();
                        try {
                            httpsURLConnection2.setRequestMethod("GET");
                            httpsURLConnection2.setRequestProperty("Cookie", this.Kxg);
                            httpsURLConnection2.setAllowUserInteraction(true);
                            int responseCode = httpsURLConnection2.getResponseCode();
                            if (responseCode != 200) {
                                if (responseCode == 301 || responseCode == 302) {
                                    String headerField = httpsURLConnection2.getHeaderField("Location");
                                    if (headerField == null) {
                                        headerField = httpsURLConnection2.getHeaderField(FirebaseAnalytics.b.LOCATION);
                                    }
                                    Log.i("MicroMsg.WebViewUtil", "redirect url = %s", headerField);
                                    if (!Util.isNullOrNil(headerField)) {
                                        this.imageUrl = headerField;
                                        gsO();
                                        a(httpsURLConnection2, null);
                                    }
                                }
                                this.Kxf = this.context.getString(R.string.j4z);
                                a(httpsURLConnection2, null);
                            } else {
                                String contentType = httpsURLConnection2.getContentType();
                                InputStream inputStream2 = httpsURLConnection2.getInputStream();
                                try {
                                    a(contentType, httpsURLConnection2.getHeaderField("Content-Disposition"), inputStream2);
                                    a(httpsURLConnection2, inputStream2);
                                } catch (Exception e7) {
                                    e2 = e7;
                                    inputStream = inputStream2;
                                    httpsURLConnection = httpsURLConnection2;
                                    try {
                                        Log.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e2.getMessage());
                                        a(httpsURLConnection, inputStream);
                                        AppMethodBeat.o(103153);
                                        return true;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        a(httpsURLConnection, inputStream);
                                        AppMethodBeat.o(103153);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    inputStream = inputStream2;
                                    httpsURLConnection = httpsURLConnection2;
                                    a(httpsURLConnection, inputStream);
                                    AppMethodBeat.o(103153);
                                    throw th;
                                }
                            }
                        } catch (Exception e8) {
                            e2 = e8;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection2;
                            Log.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e2.getMessage());
                            a(httpsURLConnection, inputStream);
                            AppMethodBeat.o(103153);
                            return true;
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = null;
                            httpsURLConnection = httpsURLConnection2;
                            a(httpsURLConnection, inputStream);
                            AppMethodBeat.o(103153);
                            throw th;
                        }
                    } catch (Exception e9) {
                        e2 = e9;
                        inputStream = null;
                        httpsURLConnection = null;
                        Log.e("MicroMsg.WebViewUtil", "download https resource failed : %s", e2.getMessage());
                        a(httpsURLConnection, inputStream);
                        AppMethodBeat.o(103153);
                        return true;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = null;
                        httpsURLConnection = null;
                        a(httpsURLConnection, inputStream);
                        AppMethodBeat.o(103153);
                        throw th;
                    }
                } else {
                    gsO();
                }
                AppMethodBeat.o(103153);
                return true;
            }
        }
    }

    public static final String bS(Map<String, Object> map) {
        AppMethodBeat.i(103167);
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (!Util.isNullOrNil(str) && obj != null) {
                if (!(obj instanceof String) || !Util.isNullOrNil((String) obj)) {
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(str);
                    sb.append("=");
                    sb.append(obj);
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(103167);
        return sb2;
    }

    public static final String bfG(String str) {
        AppMethodBeat.i(103168);
        if (!Util.isNullOrNil(str)) {
            try {
                str = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
                AppMethodBeat.o(103168);
            } catch (UnsupportedEncodingException e2) {
                Log.e("MicroMsg.WebViewUtil", "URLEncode fail, throw : %s", e2.getMessage());
            }
            return str;
        }
        AppMethodBeat.o(103168);
        return str;
    }

    public static final String bfH(String str) {
        byte[] bytes;
        AppMethodBeat.i(103169);
        if (!Util.isNullOrNil(str)) {
            try {
                bytes = str.getBytes(ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                bytes = str.getBytes();
                Log.e("MicroMsg.WebViewUtil", "getBytes fail, throw : %s", e2.getMessage());
            }
            String encodeToString = Base64.encodeToString(bytes, 2);
            AppMethodBeat.o(103169);
            return encodeToString;
        }
        AppMethodBeat.o(103169);
        return str;
    }

    public static String bfI(String str) {
        AppMethodBeat.i(103172);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103172);
            return null;
        } else if (!KwT.matcher(str).matches()) {
            AppMethodBeat.o(103172);
            return null;
        } else {
            String trim = str.substring(str.indexOf("base64,") + 7).trim();
            AppMethodBeat.o(103172);
            return trim;
        }
    }

    public static String gcX() {
        AppMethodBeat.i(103173);
        ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(103173);
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(103173);
            return "no";
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(103173);
            return "WIFI";
        } else {
            Log.d("MicroMsg.WebViewUtil", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.o(103173);
                return lowerCase;
            }
            AppMethodBeat.o(103173);
            return "no";
        }
    }

    public static String bfJ(String str) {
        AppMethodBeat.i(103174);
        String str2 = "";
        if (str != null && str.startsWith("Refused to frame")) {
            String[] split = str.split("'");
            if (split.length > 2) {
                str2 = split[1];
            }
        }
        AppMethodBeat.o(103174);
        return str2;
    }

    @Deprecated
    public static String getMimeTypeByFilePath(String str) {
        AppMethodBeat.i(103175);
        String mimeTypeByFilePath = MimeTypeUtil.getMimeTypeByFilePath(str);
        AppMethodBeat.o(103175);
        return mimeTypeByFilePath;
    }

    public static String aYy(String str) {
        AppMethodBeat.i(103176);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(103176);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(103176);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(103176);
        return substring;
    }

    public static String bfK(String str) {
        AppMethodBeat.i(224527);
        String format = String.format("preverify://url=%s", URLEncoder.encode(aYy(Util.nullAsNil(str))));
        AppMethodBeat.o(224527);
        return format;
    }

    public static String bfL(String str) {
        AppMethodBeat.i(184503);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (ao.isDarkMode()) {
                    String optString = jSONObject.optString("dark");
                    AppMethodBeat.o(184503);
                    return optString;
                }
                String optString2 = jSONObject.optString("light");
                AppMethodBeat.o(184503);
                return optString2;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewUtil", e2.getMessage());
            }
        }
        AppMethodBeat.o(184503);
        return null;
    }

    public static boolean gsK() {
        AppMethodBeat.i(224528);
        if (KwU == -1) {
            int decodeInt = MultiProcessMMKV.getMMKV("bizCommand").decodeInt("sameLayerOpen", -1);
            KwU = decodeInt;
            if (decodeInt == -1) {
                KwU = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_video_use_same_layer_v2, 1);
                Log.i("MicroMsg.WebViewUtil", "useSameLayerForVideo useSameLayer=%d", Integer.valueOf(KwU));
                if (KwU == 1) {
                    AppMethodBeat.o(224528);
                    return true;
                }
                AppMethodBeat.o(224528);
                return false;
            } else if (KwU == 1) {
                AppMethodBeat.o(224528);
                return true;
            } else {
                AppMethodBeat.o(224528);
                return false;
            }
        } else if (KwU == 1) {
            AppMethodBeat.o(224528);
            return true;
        } else {
            AppMethodBeat.o(224528);
            return false;
        }
    }

    public static boolean gsL() {
        AppMethodBeat.i(224529);
        if (KwV == -1) {
            KwV = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_pagecommit_update_random_str_v2, 1);
            Log.i("MicroMsg.WebViewUtil", "updateRandomStr updateRandomStr=%d", Integer.valueOf(KwV));
            if (KwV == 1) {
                AppMethodBeat.o(224529);
                return true;
            }
            AppMethodBeat.o(224529);
            return false;
        } else if (KwV == 1) {
            AppMethodBeat.o(224529);
            return true;
        } else {
            AppMethodBeat.o(224529);
            return false;
        }
    }

    public static boolean gsM() {
        AppMethodBeat.i(224530);
        if (KwW != -1) {
            if (KwW == 1) {
                AppMethodBeat.o(224530);
                return true;
            }
            AppMethodBeat.o(224530);
            return false;
        } else if (BuildInfo.IS_FLAVOR_RED || (WeChatEnvironment.hasDebugger() && 1 > Log.getLogLevel())) {
            AppMethodBeat.o(224530);
            return true;
        } else {
            KwW = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_mp_video_share_to_sns, 0);
            Log.i("MicroMsg.WebViewUtil", "mpVideoShareToSns open=%d", Integer.valueOf(KwW));
            if (KwW == 1) {
                AppMethodBeat.o(224530);
                return true;
            }
            AppMethodBeat.o(224530);
            return false;
        }
    }

    public static boolean bfM(String str) {
        AppMethodBeat.i(224531);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(224531);
            return false;
        }
        try {
            if (!new URL(str).getHost().equals(WeChatHosts.domainString(R.string.e20))) {
                AppMethodBeat.o(224531);
                return false;
            }
            AppMethodBeat.o(224531);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewUtil", "create url fail : " + e2.getLocalizedMessage());
            AppMethodBeat.o(224531);
            return false;
        }
    }
}
