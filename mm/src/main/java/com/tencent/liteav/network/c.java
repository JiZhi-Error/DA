package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c {

    /* renamed from: a  reason: collision with root package name */
    public b f920a = null;

    /* renamed from: b  reason: collision with root package name */
    public int f921b = 5;

    /* renamed from: c  reason: collision with root package name */
    private final String f922c = "https://tcdns.myqcloud.com/queryip";

    /* renamed from: d  reason: collision with root package name */
    private final String f923d = "https://tcdnsipv6.myqcloud.com/queryip";

    /* renamed from: e  reason: collision with root package name */
    private final String f924e = "forward_stream";

    /* renamed from: f  reason: collision with root package name */
    private final String f925f = "forward_num";

    /* renamed from: g  reason: collision with root package name */
    private final String f926g = "request_type";

    /* renamed from: h  reason: collision with root package name */
    private final String f927h = "sdk_version";

    /* renamed from: i  reason: collision with root package name */
    private final String f928i = "51451748-d8f2-4629-9071-db2983aa7251";

    /* renamed from: j  reason: collision with root package name */
    private final int f929j = 5;
    private final int k = 2;
    private Thread l = null;

    c() {
    }

    static /* synthetic */ String a(c cVar, String str, int i2, String str2) {
        AppMethodBeat.i(222377);
        String a2 = cVar.a(str, i2, str2);
        AppMethodBeat.o(222377);
        return a2;
    }

    static /* synthetic */ ArrayList a(c cVar, String str) {
        AppMethodBeat.i(15397);
        ArrayList<a> a2 = cVar.a(str);
        AppMethodBeat.o(15397);
        return a2;
    }

    public void a(final String str, final int i2) {
        AppMethodBeat.i(15387);
        this.l = new Thread("TXCPushRoute") {
            /* class com.tencent.liteav.network.c.AnonymousClass1 */

            public void run() {
                String str;
                AppMethodBeat.i(15469);
                if (c.this.f920a == null) {
                    AppMethodBeat.o(15469);
                    return;
                }
                ArrayList<a> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < 7; i2++) {
                    if (i2 < 5) {
                        str = "https://tcdns.myqcloud.com/queryip";
                    } else {
                        str = "https://tcdnsipv6.myqcloud.com/queryip";
                    }
                    try {
                        String a2 = c.a(c.this, str, i2, str);
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                                break;
                            }
                        } catch (Exception e2) {
                            TXCLog.e("TXCIntelligentRoute", "get value from json failed.", e2);
                        }
                        arrayList = c.a(c.this, a2);
                        if (arrayList != null && arrayList.size() > 0) {
                            break;
                        }
                        sleep(1000, 0);
                    } catch (Exception e3) {
                        TXCLog.e("TXCIntelligentRoute", "get json string failed.", e3);
                    }
                }
                c.this.f920a.onFetchDone(0, arrayList);
                AppMethodBeat.o(15469);
            }
        };
        this.l.start();
        AppMethodBeat.o(15387);
    }

    private String a(String str, int i2, String str2) {
        AppMethodBeat.i(222374);
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            InputStream b2 = b(str, i2, str2);
            if (b2 == null) {
                AppMethodBeat.o(222374);
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b2));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(222374);
            return stringBuffer2;
        } catch (IOException e2) {
            TXCLog.e("TXCIntelligentRoute", "get json string from url failed.", e2);
        }
    }

    private InputStream b(String str, int i2, String str2) {
        InputStream inputStream;
        AppMethodBeat.i(222375);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("forward_stream", str);
            httpURLConnection.setRequestProperty("forward_num", "2");
            httpURLConnection.setRequestProperty("sdk_version", TXCCommonUtil.getSDKVersionStr());
            if (i2 == 1) {
                httpURLConnection.setRequestProperty("request_type", "1");
            } else if (i2 == 2) {
                httpURLConnection.setRequestProperty("request_type", "2");
            } else {
                httpURLConnection.setRequestProperty("request_type", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
            if (this.f921b > 0) {
                httpURLConnection.setConnectTimeout(this.f921b * 1000);
                httpURLConnection.setReadTimeout(this.f921b * 1000);
            }
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                AppMethodBeat.o(222375);
                return inputStream;
            }
        } catch (Exception e2) {
            TXCLog.e("TXCIntelligentRoute", "http failed.", e2);
        }
        inputStream = null;
        AppMethodBeat.o(222375);
        return inputStream;
    }

    private ArrayList<a> a(String str) {
        JSONException e2;
        ArrayList<a> arrayList = null;
        AppMethodBeat.i(15390);
        ArrayList<a> arrayList2 = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("state") != 0) {
                AppMethodBeat.o(15390);
            } else {
                JSONArray jSONArray = jSONObject.getJSONObject("content").getJSONArray("list");
                if (jSONArray == null) {
                    AppMethodBeat.o(15390);
                } else {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        a a2 = a((JSONObject) jSONArray.opt(i2));
                        if (a2 != null && a2.f897c) {
                            arrayList2.add(a2);
                        }
                    }
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        a a3 = a((JSONObject) jSONArray.opt(i3));
                        if (a3 != null && !a3.f897c) {
                            arrayList2.add(a3);
                        }
                    }
                    if (com.tencent.liteav.basic.d.c.a().a("Network", "EnableRouteOptimize") != 1 || !i.a().c()) {
                        long a4 = com.tencent.liteav.basic.d.c.a().a("Network", "RouteSamplingMaxCount");
                        if (a4 >= 1) {
                            long a5 = i.a().a("51451748-d8f2-4629-9071-db2983aa7251");
                            if (a5 <= a4) {
                                arrayList = a(arrayList2, false);
                                i.a().a("51451748-d8f2-4629-9071-db2983aa7251", a5 + 1);
                                a(arrayList);
                                AppMethodBeat.o(15390);
                            }
                        }
                        arrayList = arrayList2;
                        a(arrayList);
                        AppMethodBeat.o(15390);
                    } else {
                        arrayList = a(arrayList2, true);
                        try {
                            a(arrayList);
                            AppMethodBeat.o(15390);
                        } catch (JSONException e3) {
                            e2 = e3;
                            TXCLog.e("TXCIntelligentRoute", "get records from json string failed.", e2);
                            AppMethodBeat.o(15390);
                            return arrayList;
                        }
                    }
                }
            }
        } catch (JSONException e4) {
            e2 = e4;
            arrayList = arrayList2;
            TXCLog.e("TXCIntelligentRoute", "get records from json string failed.", e2);
            AppMethodBeat.o(15390);
            return arrayList;
        }
        return arrayList;
    }

    private a a(JSONObject jSONObject) {
        AppMethodBeat.i(15391);
        a aVar = new a();
        try {
            aVar.f895a = jSONObject.getString("ip");
            aVar.f896b = jSONObject.getString("port");
            aVar.f899e = 0;
            aVar.f897c = false;
            aVar.f898d = c(aVar.f895a);
            if (jSONObject.has("type") && jSONObject.getInt("type") == 2) {
                aVar.f897c = true;
            }
            AppMethodBeat.o(15391);
            return aVar;
        } catch (JSONException e2) {
            TXCLog.e("TXCIntelligentRoute", "get ip record from json object failed.", e2);
            AppMethodBeat.o(15391);
            return null;
        }
    }

    private boolean b(String str) {
        AppMethodBeat.i(15392);
        if (str.split(":").length > 1) {
            AppMethodBeat.o(15392);
            return true;
        }
        AppMethodBeat.o(15392);
        return false;
    }

    private boolean c(String str) {
        AppMethodBeat.i(15393);
        if (b(str)) {
            AppMethodBeat.o(15393);
            return false;
        }
        if (str != null) {
            for (String str2 : str.split("[.]")) {
                if (!d(str2)) {
                    AppMethodBeat.o(15393);
                    return true;
                }
            }
        }
        AppMethodBeat.o(15393);
        return false;
    }

    private boolean d(String str) {
        AppMethodBeat.i(222376);
        boolean matches = Pattern.compile("[0-9]*").matcher(str).matches();
        AppMethodBeat.o(222376);
        return matches;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.ArrayList<com.tencent.liteav.network.a> */
    /* JADX WARN: Multi-variable type inference failed */
    private ArrayList<a> a(ArrayList<a> arrayList, boolean z) {
        a aVar;
        AppMethodBeat.i(15394);
        if (arrayList == null || arrayList.size() == 0) {
            AppMethodBeat.o(15394);
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<a> it = arrayList.iterator();
        a aVar2 = null;
        while (it.hasNext()) {
            a next = it.next();
            if (next.f897c) {
                arrayList2.add(next);
            } else if (next.f898d) {
                aVar2 = next;
            } else {
                arrayList3.add(next);
            }
        }
        ArrayList<a> arrayList4 = new ArrayList<>();
        while (true) {
            if (arrayList2.size() <= 0 && arrayList3.size() <= 0) {
                break;
            }
            if (z) {
                if (aVar2 != null) {
                    arrayList4.add(aVar2);
                }
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
            } else {
                if (arrayList2.size() > 0) {
                    arrayList4.add(arrayList2.get(0));
                    arrayList2.remove(0);
                }
                if (aVar2 != null) {
                    arrayList4.add(aVar2);
                }
            }
            if (arrayList3.size() > 0) {
                arrayList4.add(arrayList3.get(0));
                arrayList3.remove(0);
            }
        }
        int size = arrayList4.size();
        if (size > 0 && (aVar = (a) arrayList4.get(size - 1)) != null && !c(aVar.f895a) && aVar2 != null) {
            arrayList4.add(aVar2);
        }
        AppMethodBeat.o(15394);
        return arrayList4;
    }

    private void a(ArrayList<a> arrayList) {
        AppMethodBeat.i(15395);
        if (arrayList != null && arrayList.size() > 0) {
            String str = "";
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                str = str + " \n Nearest IP: " + next.f895a + " Port: " + next.f896b + " Q Channel: " + next.f897c;
            }
            TXCLog.e("TXCIntelligentRoute", str);
        }
        AppMethodBeat.o(15395);
    }
}
