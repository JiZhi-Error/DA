package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f71a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f72b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f73c = false;

    /* renamed from: d  reason: collision with root package name */
    public List<a> f74d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f75e = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f76f = false;

    public i(Context context, List<a> list, boolean z) {
        AppMethodBeat.i(222977);
        this.f71a = context;
        this.f76f = z;
        this.f72b = new ArrayList();
        this.f72b.addAll(list);
        this.f75e = new c(this.f71a);
        AppMethodBeat.o(222977);
    }

    public final boolean a(String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(222979);
        String d2 = q.d(m.a(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
        if (d2 == null) {
            AppMethodBeat.o(222979);
            return false;
        }
        this.f74d = q.e(d2);
        List<a> e2 = q.e(q.a(this.f71a, "__bad_dex_info___sapp", "preference_default_sapp"));
        if (!e2.isEmpty()) {
            z = l.a(e2, this.f74d);
        } else {
            z = false;
        }
        boolean a2 = a(this.f72b, this.f74d);
        List<a> e3 = q.e(q.a(this.f71a, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "preference_default_sapp"));
        if (!e3.isEmpty()) {
            z2 = l.a(e3, this.f74d);
        } else {
            z2 = false;
        }
        e.a(this.f71a).a("DRG", "need and samebad:" + a2 + "," + z);
        if (a2 || z || z2) {
            AppMethodBeat.o(222979);
            return false;
        }
        e.a(this.f71a).a("DRG", "to download:".concat(String.valueOf(d2)));
        this.f75e.b(this.f74d);
        AppMethodBeat.o(222979);
        return true;
    }

    public final boolean b() {
        AppMethodBeat.i(222983);
        if (System.currentTimeMillis() - q.a(this.f71a, "__last_check_update_time___sapp", (Long) 0L).longValue() > Util.MILLSECONDS_OF_HOUR) {
            AppMethodBeat.o(222983);
            return true;
        }
        AppMethodBeat.o(222983);
        return false;
    }

    public final boolean c() {
        AppMethodBeat.i(222981);
        String a2 = a();
        if (a2 == null) {
            AppMethodBeat.o(222981);
            return false;
        }
        byte[] bytes = a2.getBytes();
        if (bytes != null) {
            new HashMap();
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 3) {
                    break;
                }
                byte[] a3 = p.a("https://cc.map.qq.com?desc_c", bytes);
                if (a3 != null) {
                    String str = new String(a3);
                    e.a(this.f71a).a("DRG", "response suc,try:".concat(String.valueOf(i3)));
                    boolean a4 = a(str);
                    AppMethodBeat.o(222981);
                    return a4;
                }
                q.a(10000L);
                i2 = i3;
            }
        }
        AppMethodBeat.o(222981);
        return false;
    }

    public void run() {
        AppMethodBeat.i(222978);
        e.a(this.f71a).a("DRG", "t:" + b() + ",i:" + this.f76f);
        c();
        q.b(this.f71a, "__last_check_update_time___sapp", Long.valueOf(System.currentTimeMillis()));
        e.a(this.f71a).d();
        AppMethodBeat.o(222978);
    }

    public final boolean a(List<a> list, List<a> list2) {
        boolean z;
        AppMethodBeat.i(222980);
        boolean z2 = true;
        for (a aVar : list) {
            Iterator<a> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                a next = it.next();
                if (!next.f34c.contains(ShareConstants.DEX_SUFFIX)) {
                    next.f34c += ShareConstants.DEX_SUFFIX;
                }
                if (aVar.f34c.equals(next.f34c) && aVar.f35d == next.f35d && aVar.f36e.equals(next.f36e)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                z2 = false;
            }
        }
        AppMethodBeat.o(222980);
        return z2;
    }

    public final String a() {
        AppMethodBeat.i(222982);
        JSONObject jSONObject = new JSONObject();
        String str = this.f71a.getFilesDir().getAbsolutePath() + File.separator + q.f94b;
        try {
            jSONObject.put("appkey", q.l(this.f71a));
            jSONObject.put("appversion", q.c(this.f71a));
            jSONObject.put("imei", q.h(this.f71a));
            jSONObject.put("coverSDKver", h.f67a);
            jSONObject.put("model", q.e() + "_" + q.f());
            jSONObject.put("APILevel", q.b());
            JSONArray jSONArray = new JSONArray();
            if (this.f72b != null) {
                for (a aVar : this.f72b) {
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", aVar.f32a);
                        jSONObject2.put("compVer", aVar.f33b);
                        jSONObject2.put("size", aVar.f35d);
                        jSONObject2.put("md5", q.a(new File(str, aVar.f34c)));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
            String jSONObject3 = jSONObject.toString();
            e.a(this.f71a).a("DRG", "req:" + jSONObject3);
            String b2 = m.b(jSONObject3, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
            AppMethodBeat.o(222982);
            return b2;
        } catch (Exception e2) {
            e.a(this.f71a).a("DRG", "reqDerror:" + e2.toString());
            AppMethodBeat.o(222982);
            return null;
        }
    }
}
