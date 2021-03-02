package com.tencent.mm.plugin.webview.modeltools;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.d;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static final String Jas = Integer.toString(100028);
    private static ArrayList<String> Jat;

    static {
        AppMethodBeat.i(79119);
        AppMethodBeat.o(79119);
    }

    private static void a(String str, List<String> list, com.tencent.xweb.c cVar) {
        AppMethodBeat.i(79115);
        if (!Util.isNullOrNil(list)) {
            String host = Uri.parse(str).getHost();
            String[] split = host.split("\\.");
            String str2 = split.length <= 1 ? "" : split[split.length - 2] + "." + split[split.length - 1];
            Log.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", host);
            Log.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", str2);
            for (String str3 : list) {
                if (!Util.isNullOrNil(str3)) {
                    cVar.setCookie(str, str3 + "=");
                    cVar.setCookie(str, str3 + "=;path=/");
                    if (!Util.isNullOrNil(str2)) {
                        cVar.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
        AppMethodBeat.o(79115);
    }

    public static void gdm() {
        LinkedList linkedList;
        AppMethodBeat.i(79116);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(Jat != null ? Jat.size() : 0);
        Log.i("MicroMsg.WebView.CookiesCleanup", "clearWebViewData url list size %d", objArr);
        if (Util.isNullOrNil(Jat)) {
            AppMethodBeat.o(79116);
            return;
        }
        if (!Util.isNullOrNil(Jat)) {
            ArrayList<String> arrayList = Jat;
            com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
            for (String str : arrayList) {
                Log.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", str);
                String cookie = hsp.getCookie(str);
                if (Util.isNullOrNil(cookie)) {
                    linkedList = null;
                } else {
                    String[] split = cookie.split(";");
                    int length = split.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        split[i2] = split[i2].trim();
                    }
                    linkedList = new LinkedList();
                    for (String str2 : split) {
                        if (!Util.isNullOrNil(str2) && str2.contains("=")) {
                            linkedList.add(str2.split("=")[0]);
                        }
                    }
                    if (linkedList.isEmpty()) {
                        linkedList = null;
                    }
                }
                a(str, linkedList, hsp);
            }
            d.lA(MMApplicationContext.getContext());
            d.sync();
            Log.i("MicroMsg.WebView.CookiesCleanup", "clearHostCookies end");
        }
        Iterator<String> it = Jat.iterator();
        while (it.hasNext()) {
            String aZo = aZo(it.next());
            aa hsY = aa.hsY();
            if (hsY.SAd == null) {
                org.xwalk.core.Log.e("WebStorage", "deleteOrigin failed webStg is null, cur core kind is " + WebView.getCurWebType());
            } else {
                hsY.SAd.deleteOrigin(aZo);
            }
        }
        Jat.clear();
        AppMethodBeat.o(79116);
    }

    public static void cN(String str, boolean z) {
        AppMethodBeat.i(79117);
        if (!z) {
            AppMethodBeat.o(79117);
            return;
        }
        if (Jat == null) {
            Jat = new ArrayList<>();
        }
        if (Jat.contains(str)) {
            AppMethodBeat.o(79117);
            return;
        }
        Jat.add(str);
        AppMethodBeat.o(79117);
    }

    private static String aZo(String str) {
        AppMethodBeat.i(79118);
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            if (Util.isNullOrNil(scheme)) {
                AppMethodBeat.o(79118);
                return null;
            }
            StringBuilder sb = new StringBuilder(scheme);
            sb.append("://");
            sb.append(uri.getHost());
            int port = uri.getPort();
            if (!(port == -1 || (scheme.equalsIgnoreCase("http") && port == 80) || (scheme.equalsIgnoreCase("https") && port == 443))) {
                sb.append(":");
                sb.append(uri.getPort());
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(79118);
            return sb2;
        } catch (Exception e2) {
            Log.e("MicroMsg.WebView.CookiesCleanup", "getOrigin fail %s", e2.getMessage());
            AppMethodBeat.o(79118);
            return null;
        }
    }
}
