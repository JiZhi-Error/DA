package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static DexClassLoader f2170b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Looper f2171c = null;

    /* renamed from: d  reason: collision with root package name */
    private static d f2172d = null;

    /* renamed from: a  reason: collision with root package name */
    public String f2173a = "";

    public interface a {
        void a();

        void a(int i2);

        void a(Throwable th);
    }

    private d(Context context) {
        AppMethodBeat.i(53977);
        this.f2173a = context.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin";
        AppMethodBeat.o(53977);
    }

    public static d a(Context context) {
        AppMethodBeat.i(53978);
        if (f2172d == null) {
            f2172d = new d(context);
        }
        d dVar = f2172d;
        AppMethodBeat.o(53978);
        return dVar;
    }

    public void a(final String str, final WebView webView, final Context context) {
        AppMethodBeat.i(53979);
        final RelativeLayout relativeLayout = new RelativeLayout(context);
        final TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        String str2 = this.f2173a + File.separator + "DebugPlugin.tbs";
        f.b(new File(str2));
        a(str2, new a() {
            /* class com.tencent.smtt.utils.d.AnonymousClass1 */

            @Override // com.tencent.smtt.utils.d.a
            public void a() {
                AppMethodBeat.i(53870);
                webView.post(new Runnable() {
                    /* class com.tencent.smtt.utils.d.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(53948);
                        Toast.makeText(context, "下载成功", 0).show();
                        relativeLayout.setVisibility(4);
                        d.this.a(str, webView, context, d.f2171c);
                        AppMethodBeat.o(53948);
                    }
                });
                AppMethodBeat.o(53870);
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(final int i2) {
                AppMethodBeat.i(53871);
                webView.post(new Runnable() {
                    /* class com.tencent.smtt.utils.d.AnonymousClass1.AnonymousClass2 */

                    public void run() {
                        AppMethodBeat.i(54036);
                        textView.setText("已下载" + i2 + "%");
                        AppMethodBeat.o(54036);
                    }
                });
                AppMethodBeat.o(53871);
            }

            @Override // com.tencent.smtt.utils.d.a
            public void a(Throwable th) {
                AppMethodBeat.i(53872);
                webView.post(new Runnable() {
                    /* class com.tencent.smtt.utils.d.AnonymousClass1.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(53881);
                        Toast.makeText(context, "下载失败，请检查网络", 0).show();
                        AppMethodBeat.o(53881);
                    }
                });
                AppMethodBeat.o(53872);
            }
        });
        AppMethodBeat.o(53979);
    }

    @SuppressLint({"NewApi"})
    public static void a(final String str, final a aVar) {
        AppMethodBeat.i(53980);
        new Thread() {
            /* class com.tencent.smtt.utils.d.AnonymousClass2 */

            public final void run() {
                FileOutputStream fileOutputStream;
                InputStream inputStream;
                Throwable th;
                AppMethodBeat.i(53934);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://soft.tbs.imtt.qq.com/17421/tbs_res_imtt_tbs_DebugPlugin_DebugPlugin.tbs").openConnection();
                    int contentLength = httpURLConnection.getContentLength();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        fileOutputStream = f.d(new File(str));
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = null;
                        try {
                            aVar.a(e);
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                            }
                            try {
                                fileOutputStream.close();
                                AppMethodBeat.o(53934);
                            } catch (Exception e4) {
                                AppMethodBeat.o(53934);
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                inputStream.close();
                            } catch (Exception e5) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                            AppMethodBeat.o(53934);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                        inputStream.close();
                        fileOutputStream.close();
                        AppMethodBeat.o(53934);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[8192];
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            i2 += read;
                            fileOutputStream.write(bArr, 0, read);
                            aVar.a((i2 * 100) / contentLength);
                        }
                        aVar.a();
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                        try {
                            fileOutputStream.close();
                            AppMethodBeat.o(53934);
                        } catch (Exception e8) {
                            AppMethodBeat.o(53934);
                        }
                    } catch (Exception e9) {
                        e = e9;
                        aVar.a(e);
                        inputStream.close();
                        fileOutputStream.close();
                        AppMethodBeat.o(53934);
                    }
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = null;
                    inputStream = null;
                    aVar.a(e);
                    inputStream.close();
                    fileOutputStream.close();
                    AppMethodBeat.o(53934);
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    inputStream = null;
                    inputStream.close();
                    fileOutputStream.close();
                    AppMethodBeat.o(53934);
                    throw th;
                }
            }
        }.start();
        AppMethodBeat.o(53980);
    }

    @SuppressLint({"NewApi"})
    public void a(String str, WebView webView, Context context, Looper looper) {
        AppMethodBeat.i(53981);
        TbsLog.i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        String str2 = this.f2173a + File.separator + "DebugPlugin.apk";
        File file = new File(this.f2173a + File.separator + "DebugPlugin.tbs");
        File file2 = new File(str2);
        f2171c = looper;
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (!file2.exists()) {
            TbsLog.i("debugtbs", "showPluginView - going to download plugin...");
            a(str, webView, context);
            AppMethodBeat.o(53981);
            return;
        }
        TbsLog.d("debugtbs", "showPluginView -- going to show plugin view with ".concat(String.valueOf(str2)));
        try {
            String a2 = b.a(context, true, new File(str2));
            if (!"308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(a2)) {
                TbsLog.e("debugtbs", "verifyPlugin apk: " + str2 + " signature failed - sig: " + a2);
                Toast.makeText(context, "插件校验失败，请重试", 0).show();
                file.delete();
                file2.delete();
                AppMethodBeat.o(53981);
                return;
            }
            String str3 = this.f2173a + File.separator + "opt";
            File file3 = new File(str3);
            if (!file3.exists()) {
                file3.mkdirs();
            }
            if (f2170b == null) {
                f2170b = new DexClassLoader(str2, str3, null, context.getClassLoader());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("tbs_version", new StringBuilder().append(WebView.getTbsSDKVersion(context)).toString());
            hashMap.put("tbs_core_version", new StringBuilder().append(WebView.getTbsCoreVersion(context)).toString());
            if (f2171c != null) {
                hashMap.put("looper", looper);
            }
            Object newInstance = f2170b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(Context.class, Map.class).newInstance(context, hashMap);
            if (newInstance instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) newInstance;
                webView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                TbsLog.i("debugtbs", "show " + frameLayout + " successful in " + webView);
                AppMethodBeat.o(53981);
                return;
            }
            TbsLog.e("debugtbs", "get debugview failure: ".concat(String.valueOf(newInstance)));
            AppMethodBeat.o(53981);
        } catch (Exception e2) {
            f.b(file2);
            AppMethodBeat.o(53981);
        }
    }
}
