package com.tencent.mm.plugin.webview.f;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class c {
    private static final Pattern JbU = Pattern.compile(".*#.*wechat_redirect");
    private static final IPCRunCgi.b JbV = new IPCRunCgi.b() {
        /* class com.tencent.mm.plugin.webview.f.c.AnonymousClass2 */

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.b
        public final d a(d dVar) {
            AppMethodBeat.i(224456);
            d f2 = l.a.f(dVar);
            AppMethodBeat.o(224456);
            return f2;
        }
    };
    private int AOS = 0;
    public boolean IJS = false;
    private final HashSet<String> JbJ = new HashSet<>();
    private int JbK = ((int) System.currentTimeMillis());
    private boolean JbL = true;
    private boolean JbM = false;
    private int JbN = 0;
    private String JbO = null;
    private bhj JbP = null;
    private d JbQ = new d();
    private String JbR = "";
    private String JbS = "";
    private final HashMap<String, String> JbT = new HashMap<>();
    private String mAppId = "";
    private String mRa = "";
    private int mScene = 0;
    private byte[] yEg = new byte[0];
    private String zjn = "";

    public enum a {
        INTERCEPTED,
        NO_NEED,
        WILL_GET,
        FAILED;

        public static a valueOf(String str) {
            AppMethodBeat.i(224459);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(224459);
            return aVar;
        }

        static {
            AppMethodBeat.i(224460);
            AppMethodBeat.o(224460);
        }
    }

    public c() {
        AppMethodBeat.i(224461);
        AppMethodBeat.o(224461);
    }

    public final void setUsername(String str) {
        if (str == null) {
            str = "";
        }
        this.mRa = str;
    }

    public final void aZB(String str) {
        if (str == null) {
            str = "";
        }
        this.zjn = str;
    }

    public final void setScene(int i2) {
        this.mScene = i2;
    }

    public final void setFlag(int i2) {
        this.AOS = i2;
    }

    public final void DU(int i2) {
        this.JbK = i2;
    }

    public final void age(int i2) {
        this.JbN = i2;
    }

    public final void av(byte[] bArr) {
        this.yEg = bArr;
    }

    public final void aZC(String str) {
        if (str == null) {
            str = "";
        }
        this.JbR = str;
    }

    public final void aZD(String str) {
        this.JbS = str;
    }

    public final void k(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(224462);
        if (bArr == null || bArr2 == null) {
            AppMethodBeat.o(224462);
        } else if (bArr.length <= 0 || bArr2.length <= 0) {
            AppMethodBeat.o(224462);
        } else {
            bhi bhi = new bhi();
            bhj bhj = new bhj();
            try {
                bhi.parseFrom(bArr);
                bhj.parseFrom(bArr2);
                this.JbO = bhi.LRx.MTo;
            } catch (Exception e2) {
            }
            if (Util.isNullOrNil(this.JbO) || bhj.LRH == null) {
                Log.e("MicroMsg.LuggageGetA8Key", "ReqUrl or FullUrl is null");
                AppMethodBeat.o(224462);
                return;
            }
            this.JbP = bhj;
            AppMethodBeat.o(224462);
        }
    }

    public final void setAppId(String str) {
        this.mAppId = str;
    }

    public final JsapiPermissionWrapper aZE(String str) {
        AppMethodBeat.i(224463);
        JsapiPermissionWrapper aZE = this.JbQ.aZE(str);
        AppMethodBeat.o(224463);
        return aZE;
    }

    public final GeneralControlWrapper aZF(String str) {
        AppMethodBeat.i(224464);
        GeneralControlWrapper aZF = this.JbQ.aZF(str);
        AppMethodBeat.o(224464);
        return aZF;
    }

    public final boolean gs(String str, int i2) {
        AppMethodBeat.i(224465);
        if (aZE(str).aiW(i2) == 1) {
            AppMethodBeat.o(224465);
            return true;
        }
        AppMethodBeat.o(224465);
        return false;
    }

    public final String aZj(String str) {
        String nullAs;
        String substring;
        AppMethodBeat.i(224466);
        synchronized (this.JbT) {
            try {
                Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, fullUrl = %s", str);
                for (String str2 : this.JbT.keySet()) {
                    Log.i("MicroMsg.LuggageGetA8Key", "getShareUrl, Key = %s, value = %s", str2, this.JbT.get(str2));
                }
                String str3 = this.JbT.get(str);
                if (Util.isNullOrNil(str3)) {
                    HashMap<String, String> hashMap = this.JbT;
                    if (Util.isNullOrNil(str)) {
                        substring = "";
                    } else {
                        int indexOf = str.indexOf("#");
                        if (indexOf < 0) {
                            substring = str;
                        } else {
                            substring = str.substring(0, indexOf);
                        }
                    }
                    str3 = hashMap.get(substring);
                }
                nullAs = Util.nullAs(str3, str);
            } finally {
                AppMethodBeat.o(224466);
            }
        }
        return nullAs;
    }

    public static int aZG(String str) {
        AppMethodBeat.i(224467);
        c.g bgb = com.tencent.mm.protocal.c.bgb(str);
        if (bgb == null) {
            AppMethodBeat.o(224467);
            return -1;
        }
        int gtt = bgb.gtt();
        AppMethodBeat.o(224467);
        return gtt;
    }

    static {
        AppMethodBeat.i(224481);
        AppMethodBeat.o(224481);
    }

    public final int aZH(String str) {
        AppMethodBeat.i(263528);
        int cO = cO(str, false);
        AppMethodBeat.o(263528);
        return cO;
    }

    public final int cO(String str, boolean z) {
        AppMethodBeat.i(224469);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.LuggageGetA8Key", "getReason fail, url is null");
            AppMethodBeat.o(224469);
            return 0;
        } else if (this.JbL) {
            AppMethodBeat.o(224469);
            return 0;
        } else if (JbU.matcher(str).find()) {
            AppMethodBeat.o(224469);
            return 2;
        } else if (z || !b.aZA(str)) {
            AppMethodBeat.o(224469);
            return 1;
        } else {
            AppMethodBeat.o(224469);
            return 8;
        }
    }

    public final boolean aZI(String str) {
        AppMethodBeat.i(224470);
        boolean contains = this.JbJ.contains(str);
        AppMethodBeat.o(224470);
        return contains;
    }

    public final boolean gbE() {
        AppMethodBeat.i(224471);
        if (this.JbJ.size() > 0) {
            AppMethodBeat.o(224471);
            return true;
        }
        AppMethodBeat.o(224471);
        return false;
    }

    public final synchronized a a(String str, a<bhj> aVar) {
        a a2;
        AppMethodBeat.i(224472);
        a2 = a(str, -1, aVar);
        AppMethodBeat.o(224472);
        return a2;
    }

    public final synchronized a a(String str, int i2, a<bhj> aVar) {
        a a2;
        AppMethodBeat.i(224473);
        a2 = a(str, false, i2, aVar);
        AppMethodBeat.o(224473);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.tencent.mm.plugin.webview.f.c.a a(java.lang.String r7, boolean r8, final int r9, final com.tencent.mm.plugin.webview.f.a<com.tencent.mm.protocal.protobuf.bhj> r10) {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.f.c.a(java.lang.String, boolean, int, com.tencent.mm.plugin.webview.f.a):com.tencent.mm.plugin.webview.f.c$a");
    }

    private synchronized d at(String str, int i2) {
        d at;
        String str2;
        NetworkInfo activeNetworkInfo;
        AppMethodBeat.i(224475);
        at = l.a.at(str, i2);
        bhi bhi = (bhi) at.iLK.iLR;
        bhi.OpCode = 2;
        bhi.LRx = new dqi().bhy(str);
        bhi.Scene = this.mScene;
        bhi.UserName = this.mRa;
        bhi.LRF = this.JbR;
        bhi.LRG = this.JbS;
        bhi.KMd = i2;
        bhi.KHa = this.AOS;
        ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
            if (activeNetworkInfo.getType() == 1) {
                str2 = "WIFI";
            } else if (activeNetworkInfo.getExtraInfo() != null) {
                str2 = activeNetworkInfo.getExtraInfo().toLowerCase();
            }
            bhi.pLm = str2;
            bhi.LRB = this.JbK;
            bhi.LRC = this.zjn;
            bhi.LRD = this.JbN;
            bhi.LRu = new dqi().bhy(this.mAppId);
            bhi.LRE = new SKBuiltinBuffer_t().setBuffer(this.yEg);
            Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s,MsgUserName = %s, MsgID = %s", str, this.mRa, Integer.valueOf(this.mScene), Integer.valueOf(i2), Integer.valueOf(this.AOS), bhi.pLm, Integer.valueOf(this.JbK), this.mAppId, this.zjn, Integer.valueOf(this.JbN), Util.encodeHexString(this.yEg), this.JbR, this.JbS);
            AppMethodBeat.o(224475);
        }
        str2 = "no";
        bhi.pLm = str2;
        bhi.LRB = this.JbK;
        bhi.LRC = this.zjn;
        bhi.LRD = this.JbN;
        bhi.LRu = new dqi().bhy(this.mAppId);
        bhi.LRE = new SKBuiltinBuffer_t().setBuffer(this.yEg);
        Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key reqUrl = %s, username = %s, scene = %d, reason = %d, flag = %d, netType = %s, requestId = %d, appId = %s, functionId = %s, wallentRegion = %d, a8KeyCookie = %s,MsgUserName = %s, MsgID = %s", str, this.mRa, Integer.valueOf(this.mScene), Integer.valueOf(i2), Integer.valueOf(this.AOS), bhi.pLm, Integer.valueOf(this.JbK), this.mAppId, this.zjn, Integer.valueOf(this.JbN), Util.encodeHexString(this.yEg), this.JbR, this.JbS);
        AppMethodBeat.o(224475);
        return at;
    }

    private synchronized void b(final String str, final int i2, final a<bhj> aVar) {
        AppMethodBeat.i(224476);
        a(str, i2, new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.webview.f.c.AnonymousClass3 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(224457);
                Log.i("MicroMsg.LuggageGetA8Key", "ipcGetA8Key errType:%d, errCode:%d, errMsg:%s, destroyCalled:%b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(c.this.IJS));
                c.this.JbJ.remove(str);
                if (dVar.iLL.iLR instanceof bhj) {
                    c.a(c.this, str, i2, i2, i3, str, (bhj) dVar.iLL.iLR, aVar);
                    AppMethodBeat.o(224457);
                    return;
                }
                c.a(c.this, str, i2, i2, i3, str, null, aVar);
                Log.e("MicroMsg.LuggageGetA8Key", "ipcGetA8Key call back resp is null");
                AppMethodBeat.o(224457);
            }
        });
        AppMethodBeat.o(224476);
    }

    public final synchronized void a(String str, int i2, IPCRunCgi.a aVar) {
        AppMethodBeat.i(224477);
        IPCRunCgi.a(at(str, i2), JbV, aVar);
        AppMethodBeat.o(224477);
    }

    public final void destroy() {
        this.IJS = true;
    }

    private static void a(String str, int i2, boolean z, bhj bhj, a<bhj> aVar) {
        AppMethodBeat.i(224478);
        int i3 = bhj.KCD;
        String str2 = bhj.iAc;
        switch (i3) {
            case 1:
                if (str2 == null || str2.length() == 0) {
                    Log.e("MicroMsg.LuggageGetA8Key", "getA8key-text fail, invalid content");
                    AppMethodBeat.o(224478);
                    return;
                }
                aVar.C(i2, str, str2);
                AppMethodBeat.o(224478);
                return;
            case 2:
            case 6:
            case 7:
            case 30:
                aVar.a(i2, z, str, bhj.LRH, bhj);
                break;
        }
        AppMethodBeat.o(224478);
    }

    private static boolean kg(int i2, int i3) {
        return i2 == 4 && i3 == -2005;
    }

    public static Map<String, String> ij(List<ccc> list) {
        AppMethodBeat.i(224479);
        HashMap hashMap = new HashMap();
        if (list == null) {
            AppMethodBeat.o(224479);
            return hashMap;
        }
        for (ccc ccc : list) {
            hashMap.put(ccc.xMX, ccc.Cyk);
        }
        AppMethodBeat.o(224479);
        return hashMap;
    }

    static /* synthetic */ void a(c cVar, String str, int i2, int i3, int i4, String str2, bhj bhj, a aVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(224480);
        if (!cVar.IJS) {
            if (bhj == null || aVar == null) {
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(bhj == null);
                objArr[1] = Boolean.valueOf(aVar == null);
                objArr[2] = str;
                objArr[3] = Integer.valueOf(i2);
                Log.e("MicroMsg.LuggageGetA8Key", "WebView-Trace onSceneEnd resp or cb not found(%b/%b), reqUrl: %s, reason: %d", objArr);
                if (aVar != null) {
                    aVar.a(i2, str, i3, i4, Util.nullAsNil(str2));
                    aVar.bx(i2, str);
                }
                AppMethodBeat.o(224480);
                return;
            }
            Log.i("MicroMsg.LuggageGetA8Key", "WebView-Trace onSceneEnd, reqUrl: %s, errType: %d, errCode: %d, reason: %d", str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2));
            String str3 = bhj.LRH;
            cVar.JbJ.remove(str3);
            String replaceAll = Util.nullAsNil(str3).trim().replaceAll(" ", "%20");
            bhj.LRH = replaceAll;
            if (!Util.isNullOrNil(bhj.LRL)) {
                synchronized (cVar.JbT) {
                    try {
                        cVar.JbT.put(str, bhj.LRL);
                        cVar.JbT.put(replaceAll, bhj.LRL);
                    } catch (Throwable th) {
                        AppMethodBeat.o(224480);
                        throw th;
                    }
                }
            }
            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(z.a(bhj.LRQ));
            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bhj.LRK);
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 8:
                case 9:
                case 10:
                    if (!kg(i3, i4)) {
                        cVar.JbQ.a(str, jsapiPermissionWrapper, generalControlWrapper);
                    }
                    cVar.JbQ.a(replaceAll, jsapiPermissionWrapper, generalControlWrapper);
                    cVar.yEg = z.a(bhj.LRE);
                    aVar.a(i2, str, replaceAll, bhj);
                    break;
            }
            if (aVar == null || !aVar.b(i2, str, bhj)) {
                if (i3 == 0 && i4 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (!(i2 == 5 || i2 == 1)) {
                        a(str, i2, false, bhj, aVar);
                    }
                } else if (kg(i3, i4)) {
                    a(str, i2, true, bhj, aVar);
                } else {
                    if (i3 == 0 || i4 != -3300) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        cVar.JbM = true;
                    } else {
                        aVar.a(i2, str, i3, i4, Util.nullAsNil(str2));
                    }
                }
            }
            if (aVar != null) {
                aVar.bx(i2, str);
            }
        }
        AppMethodBeat.o(224480);
    }
}
