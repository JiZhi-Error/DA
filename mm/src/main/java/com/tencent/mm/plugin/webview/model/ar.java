package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ar {
    private int IZm = -1;
    private ArrayList<String> IZn;
    private ArrayList<String> IZo;
    private List<Integer> IZp;
    private final Map<String, Boolean> IZq;
    private final Set<String> IZr;
    private String IZs = null;
    private Context mContext;

    public ar(Context context) {
        AppMethodBeat.i(79032);
        this.mContext = context;
        this.IZp = new ArrayList();
        this.IZq = new HashMap();
        this.IZr = new HashSet();
        this.IZn = new ArrayList<>();
        this.IZo = new ArrayList<>();
        AppMethodBeat.o(79032);
    }

    public WebResourceResponse a(String str, WebResourceRequest webResourceRequest, boolean z, e eVar) {
        AppMethodBeat.i(79033);
        String uri = webResourceRequest != null ? webResourceRequest.getUrl().toString() : null;
        if (Util.isNullOrNil(uri)) {
            Log.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            AppMethodBeat.o(79033);
            return null;
        } else if (uri.startsWith("weixin://resourceid/")) {
            Log.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                Bitmap decodeFile = BitmapUtil.decodeFile(eVar.gu(uri, 2));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                decodeFile.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
                WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                AppMethodBeat.o(79033);
                return webResourceResponse;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", e2.getMessage());
                AppMethodBeat.o(79033);
                return null;
            }
        } else if (z && aYQ(uri)) {
            Log.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", uri);
            WebResourceResponse webResourceResponse2 = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
            AppMethodBeat.o(79033);
            return webResourceResponse2;
        } else if (a(uri, eVar)) {
            Log.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", uri);
            WebResourceResponse webResourceResponse3 = new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
            AppMethodBeat.o(79033);
            return webResourceResponse3;
        } else {
            try {
                if (d.isEnabled()) {
                    String geu = d.geu();
                    Uri parse = Uri.parse(uri);
                    String host = parse.getHost();
                    if (!(geu == null || host == null || !geu.equals(MD5Util.getMD5String(host + com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIJ("\u0003&+21"))))) {
                        Set<String> queryParameterNames = parse.getQueryParameterNames();
                        if (queryParameterNames != null && queryParameterNames.contains(ApplicationInfo.class.getSimpleName().substring(2, 3))) {
                            Log.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, something wicked this way comes.");
                            if (Util.isNullOrNil(uri)) {
                                Log.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                try {
                                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                    String str2 = "qaj_tick_" + MD5Util.getMD5String(uri);
                                    long j2 = sharedPreferences.getLong(str2, 0);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (currentTimeMillis - j2 > TimeUnit.HOURS.toMillis(24)) {
                                        sharedPreferences.edit().putLong(str2, currentTimeMillis).commit();
                                        com.tencent.mm.plugin.report.e.INSTANCE.a(16195, uri.replace(",", "%2C"), false, true);
                                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(943, 0, 1, false);
                                    }
                                } catch (Throwable th) {
                                    Log.printErrStackTrace("MicroMsg.WebViewReporter", th, "", new Object[0]);
                                }
                            }
                        }
                        if (d.isBlock()) {
                            Log.w("MicroMsg.WebViewResourceInterrupter", "[tomys] wv, block is enabled.");
                            if (Util.isNullOrNil(uri)) {
                                Log.w("MicroMsg.WebViewReporter", "p1 is null, skip rest logit.");
                            } else {
                                try {
                                    SharedPreferences sharedPreferences2 = MMApplicationContext.getContext().getSharedPreferences("qar_cycle_rec", 0);
                                    String str3 = "qab_tick_" + MD5Util.getMD5String(uri);
                                    long j3 = sharedPreferences2.getLong(str3, 0);
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    if (currentTimeMillis2 - j3 > TimeUnit.HOURS.toMillis(24)) {
                                        sharedPreferences2.edit().putLong(str3, currentTimeMillis2).commit();
                                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(943, 1, 1, false);
                                    }
                                } catch (Throwable th2) {
                                    Log.printErrStackTrace("MicroMsg.WebViewReporter", th2, "", new Object[0]);
                                }
                            }
                            WebResourceResponse webResourceResponse4 = new WebResourceResponse("text/plain", MimeTypeUtil.ContentType.DEFAULT_CHARSET, new ByteArrayInputStream(new byte[0]));
                            AppMethodBeat.o(79033);
                            return webResourceResponse4;
                        }
                    }
                }
            } catch (Throwable th3) {
            }
            AppMethodBeat.o(79033);
            return null;
        }
    }

    public final void axq(int i2) {
        AppMethodBeat.i(259609);
        if (i2 <= 0 || i2 > 65535) {
            Log.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", Integer.valueOf(i2));
        }
        if (!this.IZp.contains(Integer.valueOf(i2))) {
            this.IZp.add(Integer.valueOf(i2));
        }
        AppMethodBeat.o(259609);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean aYQ(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.model.ar.aYQ(java.lang.String):boolean");
    }

    private boolean a(String str, e eVar) {
        AppMethodBeat.i(79035);
        if (this.IZm == -1) {
            try {
                Bundle j2 = eVar.j(31, null);
                if (j2 != null) {
                    this.IZm = j2.getInt("webview_ad_intercept_control_flag");
                    this.IZn = j2.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.IZo = j2.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder sb = new StringBuilder();
                    sb.append("white domain list :\n");
                    Iterator<String> it = this.IZn.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next()).append("\n");
                    }
                    sb.append("black list domain list : \n");
                    Iterator<String> it2 = this.IZo.iterator();
                    while (it2.hasNext()) {
                        sb.append(it2.next()).append("\n");
                    }
                    Log.i("MicroMsg.WebViewResourceInterrupter", sb.toString());
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", e2.getMessage());
                this.IZm = 0;
            }
        }
        if (this.IZm == 0) {
            AppMethodBeat.o(79035);
            return false;
        }
        String host = Uri.parse(str).getHost();
        Log.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", host, this.IZq.get(host));
        if (Util.isNullOrNil(host)) {
            AppMethodBeat.o(79035);
            return false;
        } else if (this.IZq.containsKey(host)) {
            boolean booleanValue = this.IZq.get(host).booleanValue();
            AppMethodBeat.o(79035);
            return booleanValue;
        } else {
            if (this.IZn != null && this.IZn.size() > 0) {
                Iterator<String> it3 = this.IZn.iterator();
                while (it3.hasNext()) {
                    String next = it3.next();
                    if (!Util.isNullOrNil(next) && host.contains(next)) {
                        this.IZq.put(host, Boolean.FALSE);
                        Log.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                        AppMethodBeat.o(79035);
                        return false;
                    }
                }
            }
            if (this.IZo != null && this.IZo.size() > 0) {
                Iterator<String> it4 = this.IZo.iterator();
                while (it4.hasNext()) {
                    String next2 = it4.next();
                    if (!Util.isNullOrNil(next2) && host.contains(next2)) {
                        if (this.IZm == 1) {
                            this.IZq.put(host, Boolean.TRUE);
                            Log.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", next2, str);
                            AppMethodBeat.o(79035);
                            return true;
                        } else if (this.IZm == 2) {
                            Log.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", next2, str);
                            this.IZr.add(host);
                            this.IZq.put(host, Boolean.FALSE);
                            AppMethodBeat.o(79035);
                            return false;
                        }
                    }
                }
            }
            this.IZq.put(host, Boolean.FALSE);
            AppMethodBeat.o(79035);
            return false;
        }
    }

    public final boolean aYR(String str) {
        AppMethodBeat.i(211002);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(211002);
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (Util.isNullOrNil(host)) {
            AppMethodBeat.o(211002);
            return false;
        }
        boolean remove = this.IZr.remove(host);
        AppMethodBeat.o(211002);
        return remove;
    }
}
