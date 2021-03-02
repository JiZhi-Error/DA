package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.map.tools.EncryptAesUtils;
import com.tencent.map.tools.sheet.SheetNetworkStateMonitor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i {

    /* renamed from: a  reason: collision with root package name */
    public Context f1344a;

    /* renamed from: b  reason: collision with root package name */
    public a f1345b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1346c = false;

    /* renamed from: d  reason: collision with root package name */
    SheetNetworkStateMonitor f1347d;

    /* renamed from: e  reason: collision with root package name */
    private String f1348e = i.class.getSimpleName();

    /* renamed from: f  reason: collision with root package name */
    private o f1349f;

    /* renamed from: g  reason: collision with root package name */
    private List<p> f1350g;

    public i(Context context, Looper looper) {
        AppMethodBeat.i(180800);
        this.f1344a = context;
        this.f1345b = new a(looper);
        this.f1349f = new o(context);
        this.f1347d = new SheetNetworkStateMonitor(context);
        AppMethodBeat.o(180800);
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final void handleMessage(Message message) {
            AppMethodBeat.i(180799);
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 10006:
                        i.a(i.this);
                        AppMethodBeat.o(180799);
                        return;
                    case CdnLogic.kMediaTypeFavoriteBigFile /*{ENCODED_INT: 10007}*/:
                        List<p> list = (List) message.obj;
                        i.this.f1350g = list;
                        i.this.f1349f.f1384a = list;
                        i.this.f1349f.a();
                        AppMethodBeat.o(180799);
                        return;
                    case 10009:
                        if (i.this.f1350g != null && i.this.f1349f.f1385b < 4) {
                            i.this.f1349f.f1384a = i.this.f1350g;
                            i.this.f1349f.a();
                        }
                        q.a(g.a(i.this.f1344a).f1332b, 10005, 0);
                        break;
                }
                AppMethodBeat.o(180799);
            } catch (Throwable th) {
                AppMethodBeat.o(180799);
            }
        }
    }

    private boolean a(String str) {
        ArrayList arrayList;
        AppMethodBeat.i(180801);
        String b2 = b(EncryptAesUtils.decryptAes256Base64(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q", t.G));
        if (b2 == null) {
            AppMethodBeat.o(180801);
            return false;
        }
        List<p> a2 = x.a(b2);
        if (a2.isEmpty() || y.f1437e < 0) {
            arrayList = null;
        } else {
            int i2 = s.a(this.f1344a).f1397a;
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            boolean z = false;
            for (p pVar : a2) {
                if (!x.a(pVar.f1388a)) {
                    i3++;
                    arrayList2.add(pVar);
                } else if (pVar.f1388a == i2) {
                    arrayList2.add(pVar);
                    z = true;
                }
                i3 = i3;
            }
            if (y.f1437e == 0) {
                arrayList = arrayList2;
            } else if (i3 > 0 && z) {
                arrayList = arrayList2;
            } else if (z && i3 == 0 && arrayList2.size() == 1) {
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            AppMethodBeat.o(180801);
            return false;
        }
        String b3 = x.b(this.f1344a, t.v, "preference_default");
        List<p> a3 = x.a(b3);
        if ((b3.equals("preference_default") || a3.isEmpty()) ? false : x.a(arrayList, a3)) {
            AppMethodBeat.o(180801);
            return false;
        }
        List<p> a4 = x.a(x.b(this.f1344a, t.B, "preference_default"));
        if (a4.isEmpty() ? false : x.a(arrayList, a4)) {
            AppMethodBeat.o(180801);
            return false;
        }
        q.a(this.f1345b, (int) CdnLogic.kMediaTypeFavoriteBigFile, arrayList);
        AppMethodBeat.o(180801);
        return true;
    }

    private static String b(String str) {
        AppMethodBeat.i(180802);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            g.a().a("DRG", "statucode:".concat(String.valueOf(string)));
            if (string.equals("-3")) {
                AppMethodBeat.o(180802);
                return null;
            } else if (string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                String str2 = "";
                JSONArray jSONArray = jSONObject.getJSONArray("compList");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    str2 = str2 + jSONObject2.getInt("compId") + "," + jSONObject2.getString("compVer") + "," + jSONObject2.getString("compName") + "," + jSONObject2.getInt("size") + "," + jSONObject2.getString("md5") + ",;";
                }
                AppMethodBeat.o(180802);
                return str2;
            } else if (string.equals("-1")) {
                AppMethodBeat.o(180802);
                return null;
            } else if (string.equals("-2")) {
                AppMethodBeat.o(180802);
                return null;
            } else if (string.equals("-4")) {
                AppMethodBeat.o(180802);
                return null;
            } else {
                if (string.equals("-5")) {
                    AppMethodBeat.o(180802);
                    return null;
                }
                AppMethodBeat.o(180802);
                return null;
            }
        } catch (Exception e2) {
            g.a().a("DRG", "statucode:" + e2.toString());
        }
    }

    private boolean a() {
        AppMethodBeat.i(180803);
        String b2 = b();
        if (b2 == null) {
            AppMethodBeat.o(180803);
            return false;
        }
        byte[] bytes = b2.getBytes();
        if (bytes != null) {
            new HashMap();
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 3) {
                    break;
                }
                byte[] a2 = r.a("https://cc.map.qq.com?desc_c", bytes);
                if (a2 != null) {
                    String str = new String(a2);
                    g.a(this.f1344a).a("DRG", "response suc,try:".concat(String.valueOf(i3)));
                    boolean a3 = a(str);
                    AppMethodBeat.o(180803);
                    return a3;
                }
                i2 = i3;
            }
        }
        AppMethodBeat.o(180803);
        return false;
    }

    private String b() {
        String b2;
        AppMethodBeat.i(180804);
        List<p> a2 = x.a(x.b(this.f1344a, t.q, BuildConfig.KINDA_DEFAULT));
        if (a2.isEmpty()) {
            AppMethodBeat.o(180804);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("projName", a.f1309a);
            jSONObject.put("appkey", x.a(this.f1344a));
            jSONObject.put("appversion", x.b(this.f1344a));
            jSONObject.put("imei", x.c(this.f1344a));
            jSONObject.put("coverSDKver", t.k);
            jSONObject.put("model", x.b() + "_" + x.a());
            jSONObject.put("APILevel", x.c());
            JSONArray jSONArray = new JSONArray();
            for (p pVar : a2) {
                if (pVar != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("compId", pVar.f1388a);
                    jSONObject2.put("compVer", pVar.f1389b);
                    jSONObject2.put("size", pVar.f1391d);
                    Context context = this.f1344a;
                    int i2 = s.a(context).f1397a;
                    if (x.a(pVar.f1388a)) {
                        b2 = x.b(context, x.f1426c + File.separator + t.F[i2] + File.separator + pVar.f1390c);
                    } else {
                        b2 = x.b(context, x.f1424a + File.separator + pVar.f1390c);
                    }
                    jSONObject2.put("md5", x.a(new File(b2)));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("compList", jSONArray);
            String jSONObject3 = jSONObject.toString();
            g.a(this.f1344a).a("DRG", "req:".concat(String.valueOf(jSONObject3)));
            String encryptAes256Base64 = EncryptAesUtils.encryptAes256Base64(jSONObject3, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q", t.G);
            AppMethodBeat.o(180804);
            return encryptAes256Base64;
        } catch (Exception e2) {
            g.a(this.f1344a).a("DRG", "reqDerror:" + e2.toString());
            AppMethodBeat.o(180804);
            return null;
        }
    }

    static /* synthetic */ boolean a(i iVar) {
        boolean z;
        AppMethodBeat.i(180805);
        if (!iVar.f1346c) {
            if (System.currentTimeMillis() - x.b(iVar.f1344a, t.x, (Long) 0L).longValue() > 0) {
                z = true;
            } else {
                z = false;
            }
            g.a(iVar.f1344a).a("DRG", "t:" + z + ",i:" + iVar.f1346c);
            if (!z) {
                AppMethodBeat.o(180805);
                return false;
            }
        }
        boolean a2 = iVar.a();
        x.a(iVar.f1344a, t.x, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(180805);
        return a2;
    }
}
