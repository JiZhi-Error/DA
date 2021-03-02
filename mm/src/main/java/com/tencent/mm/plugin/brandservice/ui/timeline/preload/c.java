package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.dra;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

public final class c {
    private static ConcurrentHashMap<String, String> pAn = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> pAo = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> pAp = new ConcurrentHashMap<>();

    public static final o H(o oVar) {
        AppMethodBeat.i(175480);
        p.h(oVar, "$this$create");
        if (!oVar.exists()) {
            String parent = oVar.getParent();
            if (parent == null) {
                p.hyc();
            }
            new o(parent).mkdirs();
            oVar.createNewFile();
        }
        AppMethodBeat.o(175480);
        return oVar;
    }

    private static final o e(o oVar, String str) {
        AppMethodBeat.i(175482);
        o oVar2 = new o(oVar.getPath() + '/' + str);
        AppMethodBeat.o(175482);
        return oVar2;
    }

    public static final o a(MMFileSlotManager mMFileSlotManager, String str) {
        AppMethodBeat.i(175483);
        p.h(mMFileSlotManager, "$this$getContentFile");
        p.h(str, "contentId");
        o e2 = e((o) mMFileSlotManager.getSlot(), str);
        AppMethodBeat.o(175483);
        return e2;
    }

    public static final o b(MMFileSlotManager mMFileSlotManager, String str) {
        AppMethodBeat.i(175484);
        p.h(mMFileSlotManager, "$this$findContentFile");
        p.h(str, "contentId");
        o oVar = (o) mMFileSlotManager.findSlot(str);
        if (oVar != null) {
            o e2 = e(oVar, str);
            AppMethodBeat.o(175484);
            return e2;
        }
        AppMethodBeat.o(175484);
        return null;
    }

    public static final boolean c(MMFileSlotManager mMFileSlotManager, String str) {
        AppMethodBeat.i(6556);
        p.h(mMFileSlotManager, "$this$contains");
        p.h(str, "contentId");
        if (mMFileSlotManager.findSlot(str) != null) {
            AppMethodBeat.o(6556);
            return true;
        }
        AppMethodBeat.o(6556);
        return false;
    }

    static {
        AppMethodBeat.i(6575);
        AppMethodBeat.o(6575);
    }

    public static final ConcurrentHashMap<String, String> cnw() {
        return pAn;
    }

    public static final ConcurrentHashMap<String, ConcurrentLinkedDeque<String>> cnx() {
        return pAp;
    }

    public static final synchronized void ahT(String str) {
        synchronized (c.class) {
            AppMethodBeat.i(6557);
            p.h(str, "domain");
            String str2 = MainProcessIPCService.dkO;
            p.g(str2, "MainProcessIPCService.PROCESS_NAME");
            com.tencent.mm.ipcinvoker.a.a(str2, new IPCString(str), a.pAq, null);
            String str3 = ToolsProcessIPCService.dkO;
            p.g(str3, "ToolsProcessIPCService.PROCESS_NAME");
            com.tencent.mm.ipcinvoker.a.a(str3, new IPCString(str), b.pAr, null);
            AppMethodBeat.o(6557);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r3 = ahZ(getHost(r13));
        r4 = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.C0886c(r14, r13);
        r1 = new java.lang.StringBuilder("matched_");
        r5 = new java.lang.String[]{"__biz", "mid", "idx"};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0064, code lost:
        if (r0 >= 3) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        r6 = r5[r0];
        r7 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt.getUrlParam(r13, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006c, code lost:
        if (r7 != null) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006e, code lost:
        r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt.clearShortUrl(r13, true);
        r1 = aid(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007a, code lost:
        if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1) != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAo.put(r13, r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(195553);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008e, code lost:
        r1 = java.lang.Integer.toString("not_matched_".concat(java.lang.String.valueOf(r4.aif(r0))).hashCode(), kotlin.n.a.avR(16));
        kotlin.g.b.p.g(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b1, code lost:
        if (r14 == false) goto L_0x00ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b9, code lost:
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.containsKey(r3) != false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00bb, code lost:
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.put(r3, new java.util.concurrent.ConcurrentLinkedDeque<>());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c7, code lost:
        r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cd, code lost:
        if (r0 != null) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        kotlin.g.b.p.hyc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d2, code lost:
        r0.add(r2);
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAo.put(r2, r1);
        com.tencent.mm.sdk.platformtools.Log.d("AppMsgContextEx", "#" + r1 + " hash from:" + r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ff, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(195553);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0105, code lost:
        r1.append(r6 + ':' + r7 + '-');
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0127, code lost:
        r1 = r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0131, code lost:
        if (com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.containsKey(r3) != false) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0133, code lost:
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.put(r3, new java.util.concurrent.ConcurrentLinkedDeque<>());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x013f, code lost:
        r0 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAp.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0145, code lost:
        if (r0 != null) goto L_0x014a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0147, code lost:
        kotlin.g.b.p.hyc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x014a, code lost:
        r0.add(r2);
        kotlin.g.b.p.g(r1, "this");
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.pAo.put(r2, r1);
        kotlin.g.b.p.g(r1, "key.toString()\n        .…acheKey] = this\n        }");
        com.tencent.matrix.trace.core.AppMethodBeat.o(195553);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String aI(java.lang.String r13, boolean r14) {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.aI(java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.preload.c$c */
    public static final class C0886c extends q implements kotlin.g.a.b<String, Integer> {
        final /* synthetic */ String mkH;
        final /* synthetic */ boolean pAs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0886c(boolean z, String str) {
            super(1);
            this.pAs = z;
            this.mkH = str;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(String str) {
            AppMethodBeat.i(259600);
            Integer valueOf = Integer.valueOf(aif(str));
            AppMethodBeat.o(259600);
            return valueOf;
        }

        public final int aif(String str) {
            int i2;
            String uri;
            String scheme;
            AppMethodBeat.i(259601);
            p.h(str, "$this$toHash");
            try {
                Uri parse = Uri.parse(str);
                if (!this.pAs || (scheme = parse.getScheme()) == null || !com.tencent.luggage.h.c.a(scheme, "http", true)) {
                    uri = parse.toString();
                    p.g(uri, "toString()");
                } else {
                    y yVar = y.pFf;
                    com.tencent.mm.plugin.ad.a aiu = y.aiu(this.mkH);
                    if (aiu == null || (uri = y.pFf.a(this.mkH, aiu)) == null) {
                        uri = this.mkH;
                    }
                }
                i2 = uri.hashCode();
            } catch (Exception e2) {
                Log.printErrStackTrace("hashUrl", e2, "hash url".concat(String.valueOf(str)), new Object[0]);
                i2 = 0;
            }
            AppMethodBeat.o(259601);
            return i2;
        }
    }

    public static final class d extends q implements kotlin.g.a.b<String, Integer> {
        final /* synthetic */ String mkH;
        final /* synthetic */ boolean pAs = false;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(1);
            this.mkH = str;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Integer invoke(String str) {
            AppMethodBeat.i(195550);
            Integer valueOf = Integer.valueOf(aif(str));
            AppMethodBeat.o(195550);
            return valueOf;
        }

        public final int aif(String str) {
            int i2;
            String uri;
            String scheme;
            AppMethodBeat.i(195551);
            p.h(str, "$this$toHash");
            try {
                Uri parse = Uri.parse(str);
                if (!this.pAs || (scheme = parse.getScheme()) == null || !com.tencent.luggage.h.c.a(scheme, "http", true)) {
                    uri = parse.toString();
                    p.g(uri, "toString()");
                } else {
                    y yVar = y.pFf;
                    com.tencent.mm.plugin.ad.a aiu = y.aiu(this.mkH);
                    if (aiu == null || (uri = y.pFf.a(this.mkH, aiu)) == null) {
                        uri = this.mkH;
                    }
                }
                i2 = uri.hashCode();
            } catch (Exception e2) {
                Log.printErrStackTrace("hashUrl", e2, "hash url".concat(String.valueOf(str)), new Object[0]);
                i2 = 0;
            }
            AppMethodBeat.o(195551);
            return i2;
        }
    }

    public static final String ahW(String str) {
        AppMethodBeat.i(195556);
        p.h(str, "url");
        String str2 = "_info_" + aI(str, false);
        AppMethodBeat.o(195556);
        return str2;
    }

    public static final String ahX(String str) {
        AppMethodBeat.i(6560);
        p.h(str, "url");
        String str2 = "_info_" + ahV(str);
        AppMethodBeat.o(6560);
        return str2;
    }

    public static final String getHost(String str) {
        String str2;
        AppMethodBeat.i(6561);
        p.h(str, "$this$host");
        try {
            Uri parse = Uri.parse(UrlExKt.getWithProtocol(str));
            p.g(parse, "Uri.parse(this.withProtocol)");
            str2 = parse.getHost();
            if (str2 == null) {
                str2 = "unknow";
            }
        } catch (Exception e2) {
            str2 = "unknow";
        }
        AppMethodBeat.o(6561);
        return str2;
    }

    public static final String getPath(String str) {
        String str2;
        AppMethodBeat.i(195557);
        p.h(str, "$this$path");
        try {
            Uri parse = Uri.parse(UrlExKt.getWithProtocol(str));
            p.g(parse, "Uri.parse(this.withProtocol)");
            str2 = parse.getPath();
            if (str2 == null) {
                str2 = "";
            }
        } catch (Exception e2) {
            str2 = "";
        }
        AppMethodBeat.o(195557);
        return str2;
    }

    public static /* synthetic */ String ahY(String str) {
        AppMethodBeat.i(195559);
        String aJ = aJ(str, false);
        AppMethodBeat.o(195559);
        return aJ;
    }

    public static final String aJ(String str, boolean z) {
        AppMethodBeat.i(195558);
        p.h(str, "url");
        String str2 = "_web_" + aI(str, z);
        AppMethodBeat.o(195558);
        return str2;
    }

    public static final String ff(String str, String str2) {
        AppMethodBeat.i(6564);
        p.h(str, "host");
        p.h(str2, "resUrl");
        String str3 = str + "/_web_res_" + ahV(str2);
        AppMethodBeat.o(6564);
        return str3;
    }

    public static /* synthetic */ String aia(String str) {
        AppMethodBeat.i(6567);
        String ahZ = ahZ(str);
        AppMethodBeat.o(6567);
        return ahZ;
    }

    private static String ahZ(String str) {
        AppMethodBeat.i(195560);
        p.h(str, "domain");
        String str2 = "_domain_" + str.hashCode();
        AppMethodBeat.o(195560);
        return str2;
    }

    public static final String aib(String str) {
        AppMethodBeat.i(6568);
        p.h(str, "url");
        String str2 = "_content_" + ahV(str);
        AppMethodBeat.o(6568);
        return str2;
    }

    public static final String aic(String str) {
        AppMethodBeat.i(6569);
        p.h(str, "url");
        String str2 = "_invalid_" + ahV(str);
        AppMethodBeat.o(6569);
        return str2;
    }

    public static final String a(fn fnVar) {
        AppMethodBeat.i(6570);
        p.h(fnVar, "$this$getContentId");
        String str = fnVar.Url;
        p.g(str, "this.Url");
        String aib = aib(str);
        AppMethodBeat.o(6570);
        return aib;
    }

    public static final int Dm(int i2) {
        boolean z = false;
        AppMethodBeat.i(6571);
        byte[] decodeBytes = u.coo().decodeBytes("_msg_scene_strip");
        if (decodeBytes != null) {
            if (!(decodeBytes.length == 0)) {
                z = true;
            }
            if (z) {
                dra dra = new dra();
                dra.parseFrom(decodeBytes);
                LinkedList<dqz> linkedList = dra.KOB;
                p.g(linkedList, "SceneControlSets().apply…(buff) }.SceneControlList");
                for (T t : linkedList) {
                    if (t.Scene == i2) {
                        if (t.MTH <= 0) {
                            Log.e("MicroMsg.AppMsgContextEx", "strip error " + i2 + ':' + t.MTH);
                        } else {
                            Log.i("MicroMsg.AppMsgContextEx", "strip " + i2 + ':' + t.MTH);
                            int i3 = t.MTH;
                            AppMethodBeat.o(6571);
                            return i3;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(6571);
        return 10;
    }

    private static MultiProcessMMKV cny() {
        int azs;
        AppMethodBeat.i(6572);
        if (MMApplicationContext.isMainProcess()) {
            p.g(g.aAf(), "MMKernel.account()");
            azs = com.tencent.mm.kernel.a.getUin();
        } else {
            azs = com.tencent.mm.kernel.a.azs();
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mpRelateData_".concat(String.valueOf(azs)), 2);
        p.g(mmkv, "MultiProcessMMKV.getMMKV…sMMKV.MULTI_PROCESS_MODE)");
        AppMethodBeat.o(6572);
        return mmkv;
    }

    private static String aid(String str) {
        AppMethodBeat.i(195561);
        p.h(str, "url");
        String decodeString = cny().decodeString("short_url_".concat(String.valueOf(str)), "");
        p.g(decodeString, "mpDataMmkv().decodeString(\"short_url_$url\", \"\")");
        AppMethodBeat.o(195561);
        return decodeString;
    }

    public static final String aie(String str) {
        AppMethodBeat.i(6573);
        p.h(str, "url");
        String ahV = ahV(str);
        AppMethodBeat.o(6573);
        return ahV;
    }

    public static final void fg(String str, String str2) {
        AppMethodBeat.i(6574);
        p.h(str, "shortUrl");
        p.h(str2, "longUrl");
        String clearShortUrl$default = UrlExKt.clearShortUrl$default(str, false, 2, null);
        String aie = aie(str2);
        cny().encode("short_url_".concat(String.valueOf(clearShortUrl$default)), aie);
        pAn.put(clearShortUrl$default, aie);
        AppMethodBeat.o(6574);
    }

    /* access modifiers changed from: package-private */
    public static final class a<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final a pAq = new a();

        static {
            AppMethodBeat.i(195545);
            AppMethodBeat.o(195545);
        }

        a() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195544);
            String str = iPCString.value;
            p.g(str, "ipcDomain.value");
            c.ahS(str);
            AppMethodBeat.o(195544);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        public static final b pAr = new b();

        static {
            AppMethodBeat.i(195547);
            AppMethodBeat.o(195547);
        }

        b() {
        }

        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(195546);
            String str = iPCString.value;
            p.g(str, "ipcDomain.value");
            c.ahS(str);
            AppMethodBeat.o(195546);
        }
    }

    public static final void ahS(String str) {
        AppMethodBeat.i(195552);
        p.h(str, "domain");
        String ahZ = ahZ(str);
        LinkedList linkedList = new LinkedList();
        synchronized (b.class) {
            try {
                ConcurrentLinkedDeque<String> concurrentLinkedDeque = pAp.get(ahZ);
                if (concurrentLinkedDeque != null) {
                    for (T t : concurrentLinkedDeque) {
                        String remove = pAn.remove(t);
                        if (remove != null) {
                            linkedList.add(remove);
                        }
                        String remove2 = pAo.remove(t);
                        if (remove2 != null) {
                            linkedList.add(remove2);
                        }
                    }
                    x xVar = x.SXb;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(195552);
                throw th;
            }
        }
        Log.i("AppMsgContextEx", "clearDomain:" + str + '#' + ahZ + ", [" + j.a(linkedList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + ']');
        AppMethodBeat.o(195552);
    }

    private static /* synthetic */ String ahV(String str) {
        AppMethodBeat.i(195555);
        String clearUrlParams = UrlExKt.clearUrlParams(n.oz(str, "#"), "from", "isappinstalled", "pass_ticket", "exportKey");
        String str2 = clearUrlParams + '-' + false;
        if (pAn.containsKey(str2)) {
            String str3 = (String) ae.e(pAn, str2);
            AppMethodBeat.o(195555);
            return str3;
        }
        String ahZ = ahZ(getHost(clearUrlParams));
        d dVar = new d(clearUrlParams);
        StringBuilder sb = new StringBuilder("matched_");
        String[] strArr = {"__biz", "mid", "idx"};
        for (int i2 = 0; i2 < 3; i2++) {
            String str4 = strArr[i2];
            String urlParam = UrlExKt.getUrlParam(clearUrlParams, str4);
            if (urlParam == null) {
                String clearShortUrl$default = UrlExKt.clearShortUrl$default(clearUrlParams, false, 2, null);
                String aid = aid(clearShortUrl$default);
                if (!Util.isNullOrNil(aid)) {
                    pAn.put(clearUrlParams, aid);
                    AppMethodBeat.o(195555);
                    return aid;
                }
                String num = Integer.toString("not_matched_".concat(String.valueOf(dVar.aif(clearShortUrl$default))).hashCode(), kotlin.n.a.avR(16));
                p.g(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                AppMethodBeat.o(195555);
                return num;
            }
            sb.append(str4 + ':' + urlParam + '-');
        }
        String sb2 = sb.toString();
        if (!pAp.containsKey(ahZ)) {
            pAp.put(ahZ, new ConcurrentLinkedDeque<>());
        }
        ConcurrentLinkedDeque<String> concurrentLinkedDeque = pAp.get(ahZ);
        if (concurrentLinkedDeque == null) {
            p.hyc();
        }
        concurrentLinkedDeque.add(str2);
        p.g(sb2, "this");
        pAn.put(str2, sb2);
        p.g(sb2, "key.toString()\n        .…acheKey] = this\n        }");
        AppMethodBeat.o(195555);
        return sb2;
    }
}
