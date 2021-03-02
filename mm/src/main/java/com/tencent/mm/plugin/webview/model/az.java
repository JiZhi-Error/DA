package com.tencent.mm.plugin.webview.model;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class az {
    private static int Jaa = 0;
    private static int Jab = 0;
    public l IZL;
    public j IZM;
    public k IZN;
    public ax IZO;
    private ak IZP;
    public f IZQ;
    public b IZR;
    public g IZS;
    public d IZT;
    private e IZU;
    private i IZV;
    private h IZW;
    private c IZX;
    public a IZY;
    private au IZZ;
    public int Jac = ((int) (System.currentTimeMillis() / 1000));

    public static class h {
        public List<String> Jal;
    }

    public static class i {
        public List<String> Jal;
    }

    public static int bHy() {
        AppMethodBeat.i(79075);
        if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(79075);
            return 5;
        } else if (NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            AppMethodBeat.o(79075);
            return 7;
        } else {
            switch (NetStatusUtil.getNetType(MMApplicationContext.getContext())) {
                case -1:
                    AppMethodBeat.o(79075);
                    return 255;
                case 0:
                    AppMethodBeat.o(79075);
                    return 1;
                case 1:
                case 6:
                case 8:
                    AppMethodBeat.o(79075);
                    return 3;
                case 2:
                case 5:
                case 7:
                    AppMethodBeat.o(79075);
                    return 2;
                case 3:
                case 4:
                    AppMethodBeat.o(79075);
                    return 4;
                default:
                    AppMethodBeat.o(79075);
                    return 6;
            }
        }
    }

    public static String gcX() {
        AppMethodBeat.i(79076);
        ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(79076);
            return "no";
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(79076);
            return "no";
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(79076);
            return "WIFI";
        } else {
            Log.d("MicroMsg.WebviewReporter", "activeNetInfo extra=%s, type=%d, %s", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()), activeNetworkInfo.getExtraInfo());
            if (activeNetworkInfo.getExtraInfo() != null) {
                String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
                AppMethodBeat.o(79076);
                return lowerCase;
            }
            AppMethodBeat.o(79076);
            return "no";
        }
    }

    public az() {
        AppMethodBeat.i(175743);
        AppMethodBeat.o(175743);
    }

    public final l gcY() {
        AppMethodBeat.i(79077);
        if (this.IZL == null) {
            this.IZL = new l();
        }
        l lVar = this.IZL;
        AppMethodBeat.o(79077);
        return lVar;
    }

    public final j gcZ() {
        AppMethodBeat.i(79078);
        if (this.IZM == null) {
            this.IZM = new j();
        }
        j jVar = this.IZM;
        AppMethodBeat.o(79078);
        return jVar;
    }

    public final k gda() {
        AppMethodBeat.i(79079);
        if (this.IZN == null) {
            this.IZN = new k();
        }
        k kVar = this.IZN;
        AppMethodBeat.o(79079);
        return kVar;
    }

    public final e gdb() {
        AppMethodBeat.i(79080);
        if (this.IZU == null) {
            this.IZU = new e();
        }
        e eVar = this.IZU;
        AppMethodBeat.o(79080);
        return eVar;
    }

    public final ax gdc() {
        AppMethodBeat.i(211018);
        if (this.IZO == null) {
            this.IZO = new ax();
        }
        ax axVar = this.IZO;
        AppMethodBeat.o(211018);
        return axVar;
    }

    public final ak gdd() {
        AppMethodBeat.i(211019);
        if (this.IZP == null) {
            this.IZP = new ak();
        }
        ak akVar = this.IZP;
        AppMethodBeat.o(211019);
        return akVar;
    }

    public final f gde() {
        AppMethodBeat.i(79083);
        if (this.IZQ == null) {
            this.IZQ = new f();
        }
        f fVar = this.IZQ;
        AppMethodBeat.o(79083);
        return fVar;
    }

    public final b gdf() {
        AppMethodBeat.i(79084);
        if (this.IZR == null) {
            this.IZR = new b();
        }
        b bVar = this.IZR;
        AppMethodBeat.o(79084);
        return bVar;
    }

    public final g gdg() {
        AppMethodBeat.i(79085);
        if (this.IZS == null) {
            this.IZS = new g();
        }
        g gVar = this.IZS;
        AppMethodBeat.o(79085);
        return gVar;
    }

    public final d gdh() {
        AppMethodBeat.i(79086);
        if (this.IZT == null) {
            this.IZT = new d();
        }
        d dVar = this.IZT;
        AppMethodBeat.o(79086);
        return dVar;
    }

    public final i gdi() {
        AppMethodBeat.i(79087);
        if (this.IZV == null) {
            this.IZV = new i();
        }
        i iVar = this.IZV;
        AppMethodBeat.o(79087);
        return iVar;
    }

    public final h gdj() {
        AppMethodBeat.i(79088);
        if (this.IZW == null) {
            this.IZW = new h();
        }
        h hVar = this.IZW;
        AppMethodBeat.o(79088);
        return hVar;
    }

    public final c gdk() {
        AppMethodBeat.i(79089);
        if (this.IZX == null) {
            this.IZX = new c();
        }
        c cVar = this.IZX;
        AppMethodBeat.o(79089);
        return cVar;
    }

    public final au gdl() {
        AppMethodBeat.i(211020);
        if (this.IZZ == null) {
            this.IZZ = new au();
        }
        au auVar = this.IZZ;
        AppMethodBeat.o(211020);
        return auVar;
    }

    public final boolean aO(Bundle bundle) {
        AppMethodBeat.i(211021);
        if (bundle != null) {
            if (this.IZY != null) {
                this.IZY.dQL = null;
            }
            this.IZY = new a(bundle);
            AppMethodBeat.o(211021);
            return true;
        }
        AppMethodBeat.o(211021);
        return false;
    }

    public final void D(String str, Object obj) {
        AppMethodBeat.i(79091);
        if (this.IZY != null) {
            try {
                this.IZY.putValue(str, obj);
                AppMethodBeat.o(79091);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(79091);
    }

    public final void aZc(String str) {
        AppMethodBeat.i(79092);
        if (this.IZY != null) {
            try {
                a aVar = this.IZY;
                if (aVar.dQL.containsKey(str)) {
                    try {
                        aVar.putValue(str, Integer.valueOf(aVar.dQL.getInt(str) + 1));
                        AppMethodBeat.o(79092);
                        return;
                    } catch (Exception e2) {
                        AppMethodBeat.o(79092);
                        return;
                    }
                } else {
                    aVar.putValue(str, 1);
                    AppMethodBeat.o(79092);
                    return;
                }
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(79092);
    }

    public static void aU(boolean z, boolean z2) {
        if (z) {
            Jaa = 1;
        } else {
            Jaa = 0;
        }
        if (z2) {
            Jab = 1;
        } else {
            Jab = 0;
        }
    }

    public static void Md(long j2) {
        AppMethodBeat.i(79094);
        if (j2 <= 0) {
            AppMethodBeat.o(79094);
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j2);
        if (currentTimeMillis >= 0 && currentTimeMillis < 20000) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(16269, Integer.valueOf(currentTimeMillis), Integer.valueOf((int) (j2 / 1000)));
        }
        AppMethodBeat.o(79094);
    }

    public class l {
        public String Jak;
        public long costTime;
        public int ehX;
        public boolean isSuccess = true;
        public String url;

        public l() {
            az.this = r2;
        }
    }

    public class j {
        private String Jak;
        private HashMap<String, Long> Jam = new HashMap<>();
        private int ehX;

        public j() {
            az.this = r3;
            AppMethodBeat.i(79071);
            AppMethodBeat.o(79071);
        }

        public final void cM(String str, boolean z) {
            AppMethodBeat.i(79072);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                AppMethodBeat.o(79072);
                return;
            }
            if (this.Jam.containsKey(str)) {
                if (z) {
                    this.Jam.put(str, Long.valueOf(Util.nowMilliSecond() - this.Jam.get(str).longValue()));
                    AppMethodBeat.o(79072);
                    return;
                }
                this.Jam.put(str, -1L);
            }
            AppMethodBeat.o(79072);
        }

        public final void report() {
            AppMethodBeat.i(211015);
            int bHy = az.bHy();
            for (Map.Entry<String, Long> entry : this.Jam.entrySet()) {
                String key = entry.getKey();
                long longValue = entry.getValue().longValue();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 2, 1, true);
                if (longValue == -1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 13, 1, true);
                    Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report fail url : %s, netType : %d", key, Integer.valueOf(bHy));
                }
                if (longValue >= 0 && longValue <= Util.MILLSECONDS_OF_MINUTE) {
                    String str = this.Jak;
                    Object[] objArr = new Object[11];
                    objArr[0] = 2;
                    objArr[1] = Long.valueOf(longValue);
                    objArr[2] = Integer.valueOf(bHy);
                    objArr[3] = key == null ? key : key.replace(",", "!");
                    objArr[4] = 0;
                    objArr[5] = 0;
                    objArr[6] = 0;
                    objArr[7] = Integer.valueOf(az.Jaa);
                    objArr[8] = Integer.valueOf(az.Jab);
                    objArr[9] = Integer.valueOf(this.ehX);
                    objArr[10] = this.Jak;
                    az.r(str, objArr);
                    Log.i("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.report url : %s, cost time : %d, netType : %d, getA8KeyScene:%d, prePublishid:%s", key, Long.valueOf(longValue), Integer.valueOf(bHy), Integer.valueOf(this.ehX), this.Jak);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 6, longValue, true);
                }
            }
            AppMethodBeat.o(211015);
        }
    }

    public class k {
        public String Jak;
        public HashMap<String, Long> Jan = new HashMap<>();
        public int ehX;

        public final k cU(int i2, String str) {
            this.ehX = i2;
            this.Jak = str;
            return this;
        }

        public k() {
            az.this = r3;
            AppMethodBeat.i(79074);
            AppMethodBeat.o(79074);
        }

        public final void aZh(String str) {
            AppMethodBeat.i(211016);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                AppMethodBeat.o(211016);
                return;
            }
            if (!this.Jan.containsKey(str)) {
                this.Jan.put(str, Long.valueOf(Util.nowMilliSecond()));
            }
            AppMethodBeat.o(211016);
        }

        public final void aZi(String str) {
            AppMethodBeat.i(211017);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                AppMethodBeat.o(211017);
                return;
            }
            if (this.Jan.containsKey(str)) {
                this.Jan.put(str, Long.valueOf(Util.nowMilliSecond() - this.Jan.get(str).longValue()));
            }
            AppMethodBeat.o(211017);
        }
    }

    public class f {
        public String Jak;
        private boolean cxw = false;
        public int ehX;
        private long startTime = Util.nowMilliSecond();
        public String url;

        public f() {
            az.this = r4;
            AppMethodBeat.i(79068);
            AppMethodBeat.o(79068);
        }

        public final void report() {
            AppMethodBeat.i(211011);
            if (!this.cxw) {
                this.cxw = true;
                int bHy = az.bHy();
                long nowMilliSecond = Util.nowMilliSecond() - this.startTime;
                if (nowMilliSecond < 0 || nowMilliSecond > 180000) {
                    AppMethodBeat.o(211011);
                    return;
                }
                String str = this.Jak;
                Object[] objArr = new Object[11];
                objArr[0] = 4;
                objArr[1] = Long.valueOf(nowMilliSecond);
                objArr[2] = Integer.valueOf(bHy);
                objArr[3] = this.url == null ? this.url : this.url.replace(",", "!");
                objArr[4] = 0;
                objArr[5] = 0;
                objArr[6] = 0;
                objArr[7] = Integer.valueOf(az.Jaa);
                objArr[8] = Integer.valueOf(az.Jab);
                objArr[9] = Integer.valueOf(this.ehX);
                objArr[10] = this.Jak;
                az.r(str, objArr);
                Log.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", this.url, Long.valueOf(nowMilliSecond), Integer.valueOf(bHy), Integer.valueOf(az.Jaa), Integer.valueOf(az.Jab), Integer.valueOf(this.ehX), this.Jak);
            }
            AppMethodBeat.o(211011);
        }
    }

    public static class b {
        public boolean Jae = false;
        public String edo;
        public boolean loadFinished = false;

        public final b aZd(String str) {
            this.edo = str;
            return this;
        }
    }

    public static class g {
        private ArrayList<String> Jag = new ArrayList<>();

        public g() {
            AppMethodBeat.i(211012);
            AppMethodBeat.o(211012);
        }

        public final g D(Object... objArr) {
            AppMethodBeat.i(211013);
            for (int i2 = 0; i2 < 2; i2++) {
                Object obj = objArr[i2];
                this.Jag.add(obj != null ? obj.toString() : "");
            }
            AppMethodBeat.o(211013);
            return this;
        }

        public final void report() {
            AppMethodBeat.i(211014);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            com.tencent.mm.plugin.report.service.h.r(11576, this.Jag);
            AppMethodBeat.o(211014);
        }
    }

    public static class d {
        private ArrayList<String> Jag = new ArrayList<>();

        public d() {
            AppMethodBeat.i(211004);
            AppMethodBeat.o(211004);
        }

        public final d C(Object... objArr) {
            AppMethodBeat.i(211005);
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                this.Jag.add(obj == null ? "" : obj.toString());
            }
            AppMethodBeat.o(211005);
            return this;
        }

        public final void report() {
            AppMethodBeat.i(211006);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            com.tencent.mm.plugin.report.service.h.r(11577, this.Jag);
            AppMethodBeat.o(211006);
        }
    }

    public class a {
        public Bundle dQL = null;

        a(Bundle bundle) {
            az.this = r2;
            this.dQL = bundle;
        }

        public final void putValue(String str, Object obj) {
            AppMethodBeat.i(79061);
            if (this.dQL != null) {
                if (obj instanceof String) {
                    this.dQL.putString(str, (String) obj);
                    AppMethodBeat.o(79061);
                    return;
                } else if (obj instanceof Boolean) {
                    this.dQL.putBoolean(str, ((Boolean) obj).booleanValue());
                    AppMethodBeat.o(79061);
                    return;
                } else if (obj instanceof Integer) {
                    this.dQL.putInt(str, ((Integer) obj).intValue());
                    AppMethodBeat.o(79061);
                    return;
                } else {
                    Log.w("MicroMsg.WebviewReporter", "put unknow type value.");
                }
            }
            AppMethodBeat.o(79061);
        }
    }

    public class e {
        private ConcurrentHashMap<String, Long> Jah = new ConcurrentHashMap<>();
        private ConcurrentHashMap<String, Long> Jai = new ConcurrentHashMap<>();
        private boolean Jaj = true;
        private String Jak;
        private int ehX;
        private String nKc = "";

        public final e cT(int i2, String str) {
            this.ehX = i2;
            this.Jak = str;
            return this;
        }

        public e() {
            az.this = r3;
            AppMethodBeat.i(79063);
            AppMethodBeat.o(79063);
        }

        public final void aZe(String str) {
            AppMethodBeat.i(211007);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
                AppMethodBeat.o(211007);
                return;
            }
            this.nKc = str;
            this.Jaj = true;
            if (!this.Jah.containsKey(str)) {
                this.Jah.put(str, Long.valueOf(Util.nowMilliSecond()));
            }
            if (!this.Jai.containsKey(str)) {
                this.Jai.put(str, Long.valueOf(Util.nowMilliSecond()));
            }
            AppMethodBeat.o(211007);
        }

        public final void aZf(String str) {
            AppMethodBeat.i(211008);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                AppMethodBeat.o(211008);
                return;
            }
            try {
                if (!Util.isNullOrNil(this.nKc) && !str.equals(this.nKc) && this.Jaj) {
                    if (this.Jah.containsKey(this.nKc)) {
                        this.Jah.put(this.nKc, Long.valueOf(Util.nowMilliSecond() - this.Jah.get(this.nKc).longValue()));
                    }
                    this.Jaj = false;
                }
                AppMethodBeat.o(211008);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebviewReporter", e2, "onLoadResource", new Object[0]);
                AppMethodBeat.o(211008);
            }
        }

        public final void aZg(String str) {
            AppMethodBeat.i(211009);
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                AppMethodBeat.o(211009);
                return;
            }
            try {
                if (this.Jai.containsKey(str)) {
                    this.Jai.put(str, Long.valueOf(Util.nowMilliSecond() - this.Jai.get(str).longValue()));
                }
                AppMethodBeat.o(211009);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WebviewReporter", e2, "onPageFinish", new Object[0]);
                AppMethodBeat.o(211009);
            }
        }

        public final void report() {
            AppMethodBeat.i(211010);
            int bHy = az.bHy();
            for (Map.Entry<String, Long> entry : this.Jah.entrySet()) {
                String key = entry.getKey();
                long longValue = entry.getValue().longValue();
                if (longValue < 0 || longValue > 180000) {
                    AppMethodBeat.o(211010);
                    return;
                }
                String str = this.Jak;
                Object[] objArr = new Object[11];
                objArr[0] = 5;
                objArr[1] = Long.valueOf(longValue);
                objArr[2] = Integer.valueOf(bHy);
                if (key != null) {
                    key = key.replace(",", "!");
                }
                objArr[3] = key;
                objArr[4] = 0;
                objArr[5] = 0;
                objArr[6] = 0;
                objArr[7] = Integer.valueOf(az.Jaa);
                objArr[8] = Integer.valueOf(az.Jab);
                objArr[9] = Integer.valueOf(this.ehX);
                objArr[10] = this.Jak;
                az.r(str, objArr);
                if (az.Jaa == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 18, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 19, longValue, true);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 8, 1, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 9, longValue, true);
                Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report DomReady cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue), Integer.valueOf(bHy), Integer.valueOf(az.Jaa), Integer.valueOf(az.Jab), Integer.valueOf(this.ehX), this.Jak);
            }
            for (Map.Entry<String, Long> entry2 : this.Jai.entrySet()) {
                String key2 = entry2.getKey();
                long longValue2 = entry2.getValue().longValue();
                if (longValue2 < 0 || longValue2 > 180000) {
                    AppMethodBeat.o(211010);
                    return;
                }
                String str2 = this.Jak;
                Object[] objArr2 = new Object[11];
                objArr2[0] = 6;
                objArr2[1] = Long.valueOf(longValue2);
                objArr2[2] = Integer.valueOf(bHy);
                if (key2 != null) {
                    key2 = key2.replace(",", "!");
                }
                objArr2[3] = key2;
                objArr2[4] = 0;
                objArr2[5] = 0;
                objArr2[6] = 0;
                objArr2[7] = Integer.valueOf(az.Jaa);
                objArr2[8] = Integer.valueOf(az.Jab);
                objArr2[9] = Integer.valueOf(this.ehX);
                objArr2[10] = this.Jak;
                az.r(str2, objArr2);
                if (az.Jaa == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 20, 1, true);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 21, longValue2, true);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 10, 1, true);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(32, 11, longValue2, true);
                Log.i("MicroMsg.WebviewReporter", "WebViewRenderReporter.report Render cost time : %d, netType : %d, coreType %d, httpType %d, getA8KeyScene:%d, prePublishid:%s", Long.valueOf(longValue2), Integer.valueOf(bHy), Integer.valueOf(az.Jaa), Integer.valueOf(az.Jab), Integer.valueOf(this.ehX), this.Jak);
            }
            AppMethodBeat.o(211010);
        }
    }

    public static class c {
        private boolean Jaf = false;
        public boolean thE = false;

        public final void cW(String str) {
            AppMethodBeat.i(211003);
            if (!this.thE || this.Jaf) {
                AppMethodBeat.o(211003);
                return;
            }
            try {
                Uri parse = Uri.parse(str);
                if (!str.startsWith("http")) {
                    Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    AppMethodBeat.o(211003);
                    return;
                }
                String host = parse.getHost();
                if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(283, 0, 1, true);
                    this.Jaf = true;
                    Log.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", str);
                }
                AppMethodBeat.o(211003);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", str);
                AppMethodBeat.o(211003);
            }
        }
    }

    public static /* synthetic */ void r(String str, Object[] objArr) {
        AppMethodBeat.i(211022);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 11; i2++) {
            arrayList.add(String.valueOf(objArr[i2]));
        }
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        com.tencent.mm.plugin.report.service.h.r(11215, arrayList);
        if (str != null && str.startsWith("official_mall")) {
            com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
            com.tencent.mm.plugin.report.service.h.r(14919, arrayList);
        }
        AppMethodBeat.o(211022);
    }
}
