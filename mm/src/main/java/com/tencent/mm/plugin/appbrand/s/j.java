package com.tencent.mm.plugin.appbrand.s;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.RouteInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.util.InetAddressUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public enum j {
    ;

    public static j valueOf(String str) {
        AppMethodBeat.i(144367);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(144367);
        return jVar;
    }

    public static HashMap<String, String> adc(String str) {
        AppMethodBeat.i(144368);
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            Uri parse = Uri.parse(str);
            str2 = parse.getHost();
            str3 = parse.getScheme();
            str4 = String.valueOf(parse.getPort());
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "Exception: parseUrl error", new Object[0]);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("host", str2);
        hashMap.put("scheme", str3);
        hashMap.put("port", str4);
        AppMethodBeat.o(144368);
        return hashMap;
    }

    private static Map<String, String> an(JSONObject jSONObject) {
        AppMethodBeat.i(144369);
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        hashMap.put(next.toLowerCase(), optJSONObject.getString(next));
                    }
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "Exception: get header error", new Object[0]);
        }
        AppMethodBeat.o(144369);
        return hashMap;
    }

    public static Map<String, String> ao(JSONObject jSONObject) {
        AppMethodBeat.i(144370);
        HashMap hashMap = new HashMap();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("formData");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, optJSONObject.getString(next));
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "Exception: get form error", new Object[0]);
        }
        AppMethodBeat.o(144370);
        return hashMap;
    }

    public static boolean c(ArrayList<String> arrayList, String str) {
        AppMethodBeat.i(144371);
        boolean a2 = a(arrayList, str, false);
        AppMethodBeat.o(144371);
        return a2;
    }

    public static boolean a(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.i(144372);
        if (b(arrayList, str, z)) {
            AppMethodBeat.o(144372);
            return true;
        } else if (adf(adc(str).get("host")) == 2) {
            Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl, url in the same net %s", str);
            AppMethodBeat.o(144372);
            return true;
        } else {
            AppMethodBeat.o(144372);
            return false;
        }
    }

    public static boolean b(ArrayList<String> arrayList, String str, boolean z) {
        AppMethodBeat.i(144373);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.o(144373);
            return false;
        } else if (arrayList == null || arrayList.size() == 0) {
            Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, configUrls is empty");
            AppMethodBeat.o(144373);
            return false;
        } else {
            Log.i("MicroMsg.AppBrandNetworkUtil", "url ".concat(String.valueOf(str)));
            Log.i("MicroMsg.AppBrandNetworkUtil", "configUrl size " + arrayList.size());
            HashMap<String, String> adc = adc(str);
            String str2 = adc.get("host");
            String str3 = adc.get("scheme");
            String str4 = adc.get("port");
            if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                AppMethodBeat.o(144373);
                return false;
            }
            Log.i("MicroMsg.AppBrandNetworkUtil", "host %s  scheme %s port %s skipPortCheck %s", str2, str3, str4, Boolean.valueOf(z));
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Log.i("MicroMsg.AppBrandNetworkUtil", "configUrl ".concat(String.valueOf(next)));
                HashMap<String, String> adc2 = adc(next);
                String str5 = adc2.get("host");
                String str6 = adc2.get("scheme");
                String str7 = adc2.get("port");
                Log.i("MicroMsg.AppBrandNetworkUtil", "confighost %s  configscheme %s configport %s", str5, str6, str7);
                if (str2.equalsIgnoreCase(str5) && str3.equalsIgnoreCase(str6)) {
                    if (z || str4.equalsIgnoreCase(str7)) {
                        Log.i("MicroMsg.AppBrandNetworkUtil", "match!!");
                        AppMethodBeat.o(144373);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(144373);
            return false;
        }
    }

    private static boolean ade(String str) {
        AppMethodBeat.i(144374);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, url is null");
            AppMethodBeat.o(144374);
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
            AppMethodBeat.o(144374);
            return false;
        }
        for (String str2 : split) {
            int i2 = Util.getInt(str2, -1);
            if (i2 < 0 || i2 > 255) {
                Log.e("MicroMsg.AppBrandNetworkUtil", "matchUrl fail, invalid ip format");
                AppMethodBeat.o(144374);
                return false;
            }
        }
        AppMethodBeat.o(144374);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int adf(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.j.adf(java.lang.String):int");
    }

    private static int bPE() {
        AppMethodBeat.i(144376);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
            for (Network network : connectivityManager.getAllNetworks()) {
                for (RouteInfo routeInfo : connectivityManager.getLinkProperties(network).getRoutes()) {
                    String upperCase = routeInfo.getDestination().getAddress().getHostAddress().toUpperCase();
                    if (InetAddressUtils.isIPv4Address(upperCase)) {
                        int prefixLength = routeInfo.getDestination().getPrefixLength();
                        int yD = yD(prefixLength);
                        Log.i("MicroMsg.AppBrandNetworkUtil", "findNetworkMask sAddr:%s,getPrefixLength:%d,netmask:%d", upperCase, Integer.valueOf(prefixLength), Integer.valueOf(yD));
                        AppMethodBeat.o(144376);
                        return yD;
                    }
                }
            }
            AppMethodBeat.o(144376);
            return 0;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "Exception: findNetworkMask error ", new Object[0]);
            AppMethodBeat.o(144376);
            return 0;
        }
    }

    private static int yC(int i2) {
        int S;
        AppMethodBeat.i(144377);
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                Iterator<InterfaceAddress> it = networkInterface.getInterfaceAddresses().iterator();
                while (true) {
                    if (it.hasNext()) {
                        InterfaceAddress next = it.next();
                        if (!next.getAddress().isLoopbackAddress()) {
                            String upperCase = next.getAddress().getHostAddress().toUpperCase();
                            boolean isIPv4Address = InetAddressUtils.isIPv4Address(upperCase);
                            Log.i("MicroMsg.AppBrandNetworkUtil", "check ip:%s, isIPv4:%b", upperCase, Boolean.valueOf(isIPv4Address));
                            if (isIPv4Address) {
                                if (!ade(upperCase)) {
                                    S = 0;
                                } else {
                                    String[] split = upperCase.split("\\.");
                                    S = o.S(new byte[]{(byte) (Util.getInt(split[0], 0) & 255), (byte) (Util.getInt(split[1], 0) & 255), (byte) (Util.getInt(split[2], 0) & 255), (byte) (Util.getInt(split[3], 0) & 255)});
                                }
                                long yD = (long) yD(next.getNetworkPrefixLength());
                                Log.i("MicroMsg.AppBrandNetworkUtil", "matchAddress oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i2), Integer.valueOf(S), Long.valueOf(yD));
                                int e2 = e(yD, i2, S);
                                AppMethodBeat.o(144377);
                                return e2;
                            }
                        }
                    }
                }
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e3, "Exception: matchAddress error", new Object[0]);
        }
        AppMethodBeat.o(144377);
        return 0;
    }

    private static int yD(int i2) {
        AppMethodBeat.i(144378);
        int i3 = -1 << (32 - i2);
        int[] iArr = new int[4];
        for (int i4 = 0; i4 < 4; i4++) {
            iArr[3 - i4] = (i3 >> (i4 * 8)) & 255;
        }
        String str = "" + iArr[0];
        for (int i5 = 1; i5 < 4; i5++) {
            str = str + "." + iArr[i5];
        }
        Log.i("MicroMsg.AppBrandNetworkUtil", "calcMaskByPrefixLength result:%s", str);
        String[] split = str.split("\\.");
        int S = o.S(new byte[]{(byte) (Util.getInt(split[0], 0) & 255), (byte) (Util.getInt(split[1], 0) & 255), (byte) (Util.getInt(split[2], 0) & 255), (byte) (Util.getInt(split[3], 0) & 255)});
        AppMethodBeat.o(144378);
        return S;
    }

    private static int e(long j2, int i2, int i3) {
        AppMethodBeat.i(144379);
        int S = o.S(new byte[]{-1, -1, -1, 0});
        long[] Bm = Bm(j2);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= 4) {
                break;
            }
            i4 = (int) (((long) i4) + Bm[i5]);
            if (Bm[i5] < 0 || Bm[i5] > 255) {
                i4 = -1;
            } else {
                i5++;
            }
        }
        i4 = -1;
        if (i4 <= 0) {
            j2 = (long) S;
        }
        Log.i("MicroMsg.AppBrandNetworkUtil", "matchNetMask oldIpInt:%d, localIpInt:%d, netmask:%d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        if ((((long) i2) & j2) != (((long) i3) & j2)) {
            AppMethodBeat.o(144379);
            return 0;
        } else if (i2 == i3) {
            AppMethodBeat.o(144379);
            return 1;
        } else {
            AppMethodBeat.o(144379);
            return 2;
        }
    }

    private static long[] Bm(long j2) {
        long[] jArr = new long[4];
        if (j2 > 0) {
            jArr[0] = j2 >>> 24;
            jArr[1] = (16777215 & j2) >>> 16;
            jArr[2] = (65535 & j2) >>> 8;
            jArr[3] = 255 & j2;
        }
        return jArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(org.json.JSONObject r12, com.tencent.mm.plugin.appbrand.s.a r13) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.s.j.a(org.json.JSONObject, com.tencent.mm.plugin.appbrand.s.a):java.util.Map");
    }

    public static int a(a aVar, int i2) {
        switch (i2) {
            case 0:
                return aVar.nhE;
            case 1:
                return aVar.nhF;
            case 2:
                return aVar.nhG;
            case 3:
                return aVar.nhH;
            default:
                return 0;
        }
    }

    public static boolean rS(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 307;
    }

    public static String a(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144381);
        if (httpURLConnection == null) {
            AppMethodBeat.o(144381);
            return "";
        }
        URL url = httpURLConnection.getURL();
        if (url == null) {
            AppMethodBeat.o(144381);
            return "";
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (headerField == null) {
            headerField = httpURLConnection.getHeaderField(FirebaseAnalytics.b.LOCATION);
        }
        if (headerField == null) {
            AppMethodBeat.o(144381);
            return null;
        }
        try {
            String uri = url.toURI().resolve(headerField).toString();
            AppMethodBeat.o(144381);
            return uri;
        } catch (URISyntaxException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "URISyntaxException: resolve url error", new Object[0]);
            AppMethodBeat.o(144381);
            return headerField;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, final ArrayList<String> arrayList) {
        AppMethodBeat.i(144382);
        if (httpURLConnection == null) {
            AppMethodBeat.o(144382);
            return;
        }
        final HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier() {
            /* class com.tencent.mm.plugin.appbrand.s.j.AnonymousClass1 */

            public final boolean verify(String str, SSLSession sSLSession) {
                AppMethodBeat.i(144364);
                if (defaultHostnameVerifier.verify(str, sSLSession) || j.d(arrayList, str)) {
                    AppMethodBeat.o(144364);
                    return true;
                }
                AppMethodBeat.o(144364);
                return false;
            }
        });
        AppMethodBeat.o(144382);
    }

    public static SSLContext a(a aVar) {
        AppMethodBeat.i(144383);
        n b2 = b(aVar);
        if (b2 == null) {
            AppMethodBeat.o(144383);
            return null;
        }
        TrustManager[] trustManagerArr = {b2};
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, trustManagerArr, null);
            AppMethodBeat.o(144383);
            return instance;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "Exception: SSLContext init error", new Object[0]);
            AppMethodBeat.o(144383);
            return null;
        }
    }

    public static n b(a aVar) {
        AppMethodBeat.i(144384);
        LinkedList linkedList = new LinkedList();
        Iterator<byte[]> it = aVar.nhL.iterator();
        while (it.hasNext()) {
            byte[] next = it.next();
            if (!(next == null || next.length == 0)) {
                linkedList.add(new ByteArrayInputStream(next));
            }
        }
        if (!linkedList.isEmpty()) {
            n nVar = new n(aVar.nhO);
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                nVar.G((InputStream) it2.next());
            }
            nVar.init();
            AppMethodBeat.o(144384);
            return nVar;
        } else if (aVar.nhO) {
            Log.i("MicroMsg.AppBrandNetworkUtil", "getTrustManagerWithSelfSignedCertificates debug type");
            n nVar2 = new n(true);
            nVar2.init();
            AppMethodBeat.o(144384);
            return nVar2;
        } else {
            AppMethodBeat.o(144384);
            return null;
        }
    }

    public static boolean b(b bVar) {
        AppMethodBeat.i(144385);
        switch (bVar) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.o(144385);
                return true;
            default:
                AppMethodBeat.o(144385);
                return false;
        }
    }

    public static JSONObject b(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144387);
        if (httpURLConnection == null) {
            JSONObject c2 = c((Map<String, List<String>>) null, 2);
            AppMethodBeat.o(144387);
            return c2;
        }
        JSONObject c3 = c(httpURLConnection.getHeaderFields(), 2);
        AppMethodBeat.o(144387);
        return c3;
    }

    public static boolean I(f fVar) {
        AppMethodBeat.i(144388);
        switch (fVar.getAppState()) {
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.o(144388);
                return true;
            default:
                AppMethodBeat.o(144388);
                return false;
        }
    }

    public static JSONObject c(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(144389);
        if (httpURLConnection == null) {
            JSONObject c2 = c((Map<String, List<String>>) null, 1);
            AppMethodBeat.o(144389);
            return c2;
        }
        JSONObject c3 = c(httpURLConnection.getRequestProperties(), 1);
        AppMethodBeat.o(144389);
        return c3;
    }

    public static JSONObject c(Map<String, List<String>> map, int i2) {
        AppMethodBeat.i(144390);
        JSONObject jSONObject = new JSONObject();
        if (i2 == 1) {
            try {
                jSONObject.put("__AppBrandRemoteDebugRequestHeader__", true);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "JSONException: getHeaderJsonObject put REQUEST_HEADER header error", new Object[0]);
            }
        }
        if (map == null) {
            AppMethodBeat.o(144390);
            return jSONObject;
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!Util.isNullOrNil(key) && value != null && !value.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append(value.get(0));
                for (int i3 = 1; i3 < value.size(); i3++) {
                    sb.append(",");
                    sb.append(value.get(i3));
                }
                try {
                    jSONObject.put(key, sb.toString());
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e3, "JSONException: getHeaderJsonObject put header error", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(144390);
        return jSONObject;
    }

    public static Map<String, List<String>> X(Map<String, String> map) {
        AppMethodBeat.i(144391);
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
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
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandNetworkUtil", e2, "JSONException: put header error", new Object[0]);
        }
        AppMethodBeat.o(144391);
        return hashMap;
    }

    public static int Bn(long j2) {
        AppMethodBeat.i(144392);
        int i2 = i(j2, -1);
        AppMethodBeat.o(144392);
        return i2;
    }

    public static int i(long j2, int i2) {
        if (j2 <= 0) {
            return 8192;
        }
        if (i2 <= 0) {
            i2 = 3;
        }
        int i3 = (int) (j2 / ((long) i2));
        if (i3 > 524288 || i3 < 1024) {
            return i3 < 1024 ? 1024 : 524288;
        }
        return i3;
    }

    public static String adg(String str) {
        return str;
    }

    public static String ap(JSONObject jSONObject) {
        AppMethodBeat.i(144393);
        if (jSONObject == null) {
            AppMethodBeat.o(144393);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        if (!Util.isNullOrNil(linkedList)) {
            String join = TextUtils.join(", ", linkedList);
            AppMethodBeat.o(144393);
            return join;
        }
        AppMethodBeat.o(144393);
        return null;
    }

    public static String a(URI uri) {
        AppMethodBeat.i(144394);
        String scheme = uri.getScheme();
        if (Util.isNullOrNil(scheme)) {
            AppMethodBeat.o(144394);
            return null;
        }
        if (scheme.equalsIgnoreCase("wss")) {
            scheme = "https";
        } else if (scheme.equalsIgnoreCase("ws")) {
            scheme = "http";
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
        AppMethodBeat.o(144394);
        return sb2;
    }

    public static synchronized Map<String, Object> a(CronetLogic.WebPageProfile webPageProfile) {
        HashMap hashMap;
        synchronized (j.class) {
            AppMethodBeat.i(175394);
            hashMap = new HashMap();
            if (webPageProfile != null) {
                hashMap.put("redirectStart", Long.valueOf(webPageProfile.redirectStart));
                hashMap.put("redirectEnd", Long.valueOf(webPageProfile.redirectEnd));
                hashMap.put("fetchStart", Long.valueOf(webPageProfile.fetchStart));
                hashMap.put("domainLookUpStart", Long.valueOf(webPageProfile.domainLookUpStart));
                hashMap.put("domainLookUpEnd", Long.valueOf(webPageProfile.domainLookUpEnd));
                hashMap.put("connectStart", Long.valueOf(webPageProfile.connectStart));
                hashMap.put("connectEnd", Long.valueOf(webPageProfile.connectEnd));
                hashMap.put("SSLconnectionStart", Long.valueOf(webPageProfile.SSLconnectionStart));
                hashMap.put("SSLconnectionEnd", Long.valueOf(webPageProfile.SSLconnectionEnd));
                hashMap.put("requestStart", Long.valueOf(webPageProfile.requestStart));
                hashMap.put("requestEnd", Long.valueOf(webPageProfile.requestEnd));
                hashMap.put("responseStart", Long.valueOf(webPageProfile.responseStart));
                hashMap.put("responseEnd", Long.valueOf(webPageProfile.responseEnd));
                hashMap.put("rtt", Integer.valueOf(webPageProfile.rtt));
                hashMap.put("estimate_nettype", Integer.valueOf(webPageProfile.networkTypeEstimate));
                hashMap.put("httpRttEstimate", Integer.valueOf(webPageProfile.httpRttEstimate));
                hashMap.put("transportRttEstimate", Integer.valueOf(webPageProfile.transportRttEstimate));
                hashMap.put("downstreamThroughputKbpsEstimate", Integer.valueOf(webPageProfile.downstreamThroughputKbpsEstimate));
                hashMap.put("throughputKbps", Integer.valueOf(webPageProfile.throughputKbps));
                hashMap.put("peerIP", webPageProfile.peerIP);
                hashMap.put("port", Integer.valueOf(webPageProfile.port));
                hashMap.put("protocol", webPageProfile.protocol);
                hashMap.put("socketReused", Boolean.valueOf(webPageProfile.socketReused));
                hashMap.put("sendBytesCount", Long.valueOf(webPageProfile.sendBytesCount));
                hashMap.put("receivedBytedCount", Long.valueOf(webPageProfile.receivedBytedCount));
            }
            AppMethodBeat.o(175394);
        }
        return hashMap;
    }

    static /* synthetic */ boolean d(ArrayList arrayList, String str) {
        AppMethodBeat.i(144395);
        if (arrayList == null || str == null) {
            AppMethodBeat.o(144395);
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).contains(str)) {
                AppMethodBeat.o(144395);
                return true;
            }
        }
        AppMethodBeat.o(144395);
        return false;
    }
}
