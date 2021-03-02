package com.tencent.mm.model;

import android.content.Context;
import android.support.v4.e.k;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.fbv;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.ffg;
import com.tencent.mm.protocal.protobuf.ffh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.aa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public final class cr {
    private static Set<Runnable> iGh = Collections.emptySet();
    private static volatile boolean sInstalled = false;

    static /* synthetic */ MultiProcessMMKV KP(String str) {
        AppMethodBeat.i(197056);
        MultiProcessMMKV KM = KM(str);
        AppMethodBeat.o(197056);
        return KM;
    }

    static /* synthetic */ String aT(String str, String str2) {
        AppMethodBeat.i(197050);
        String aS = aS(str, str2);
        AppMethodBeat.o(197050);
        return aS;
    }

    static /* synthetic */ int aWK() {
        AppMethodBeat.i(197055);
        int aWE = aWE();
        AppMethodBeat.o(197055);
        return aWE;
    }

    static /* synthetic */ MultiProcessMMKV sq(int i2) {
        AppMethodBeat.i(197049);
        MultiProcessMMKV sl = sl(i2);
        AppMethodBeat.o(197049);
        return sl;
    }

    static /* synthetic */ MultiProcessMMKV sr(int i2) {
        AppMethodBeat.i(197051);
        MultiProcessMMKV sm = sm(i2);
        AppMethodBeat.o(197051);
        return sm;
    }

    static /* synthetic */ MultiProcessMMKV ss(int i2) {
        AppMethodBeat.i(197052);
        MultiProcessMMKV sn = sn(i2);
        AppMethodBeat.o(197052);
        return sn;
    }

    static /* synthetic */ void st(int i2) {
        AppMethodBeat.i(197053);
        sp(i2);
        AppMethodBeat.o(197053);
    }

    static {
        AppMethodBeat.i(197057);
        AppMethodBeat.o(197057);
    }

    private static MultiProcessMMKV KM(String str) {
        MultiProcessMMKV multiProcessMMKV = null;
        AppMethodBeat.i(197027);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(197027);
        } else {
            try {
                multiProcessMMKV = MultiProcessMMKV.getMMKV(str);
                AppMethodBeat.o(197027);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.XAgreementSettings", th, "try get mmkv fail!", new Object[0]);
                AppMethodBeat.o(197027);
            }
        }
        return multiProcessMMKV;
    }

    private static String aWD() {
        AppMethodBeat.i(197029);
        int azs = com.tencent.mm.kernel.a.azs();
        if (azs == 0) {
            AppMethodBeat.o(197029);
            return null;
        }
        String pVar = new p(azs).toString();
        AppMethodBeat.o(197029);
        return pVar;
    }

    private static int aWE() {
        MultiProcessMMKV KM;
        AppMethodBeat.i(197030);
        String aWD = aWD();
        if (aWD == null || (KM = KM("xagreement_id_store")) == null) {
            int defaultXAgreementId = WeChatBrands.AppInfo.current().getDefaultXAgreementId();
            Log.i("MicroMsg.XAgreementSettings", "Decode xagreementId return %s by default", Integer.valueOf(defaultXAgreementId));
            AppMethodBeat.o(197030);
            return defaultXAgreementId;
        }
        int decodeInt = KM.decodeInt(aWD);
        Log.i("MicroMsg.XAgreementSettings", "Decode xagreementId return %s for %s", Integer.valueOf(decodeInt), aWD);
        AppMethodBeat.o(197030);
        return decodeInt;
    }

    private static MultiProcessMMKV sl(int i2) {
        AppMethodBeat.i(197032);
        MultiProcessMMKV KM = KM("xagreement_domains_by_id_".concat(String.valueOf(i2)));
        AppMethodBeat.o(197032);
        return KM;
    }

    private static MultiProcessMMKV sm(int i2) {
        AppMethodBeat.i(197034);
        MultiProcessMMKV KM = KM("xagreement_wordings_by_id_".concat(String.valueOf(i2)));
        AppMethodBeat.o(197034);
        return KM;
    }

    private static String aS(String str, String str2) {
        AppMethodBeat.i(197035);
        String str3 = str + "@" + str2;
        AppMethodBeat.o(197035);
        return str3;
    }

    public static void z(long j2, long j3) {
        AppMethodBeat.i(197036);
        Log.i("MicroMsg.XAgreementSettings", "#saveFuncsSwith, FuncsSwitch = " + Long.toBinaryString(j2) + ", FuncsUserChoiceSwitch = " + Long.toBinaryString(j3));
        try {
            MultiProcessMMKV sn = sn(WeChatBrands.UserInfo.xagreementId);
            if (sn == null) {
                AppMethodBeat.o(197036);
                return;
            }
            sn.putInt(WeChatBrands.Business.GROUP_PAY, A(1, j2));
            sn.putInt(WeChatBrands.Business.GROUP_MP, A(2, j2));
            sn.putInt(WeChatBrands.Business.GROUP_OA, A(4, j2));
            sn.putInt(WeChatBrands.Business.GROUP_THIRD_PARTY, A(8, j2));
            sn.putInt(WeChatBrands.Business.GROUP_CROSS_DATA, A(16, j2));
            sn.putInt(WeChatBrands.Business.GROUP_WECOM, A(32, j2));
            sn.putInt(WeChatBrands.Business.GROUP_CHANNELS, A(64, j2));
            sn.putInt(WeChatBrands.Business.GROUP_SECONDARY, A(128, j2));
            sn.putInt("search", A(256, j2));
            sn.putInt(WeChatBrands.Business.GROUP_WECHAT_OUT, A(512, j2));
            sn.putInt(WeChatBrands.Business.GROUP_OPEN, A(1024, j2));
            sn.putInt(WeChatBrands.Business.GROUP_LIVE, A(2048, j2));
            sn.putInt(WeChatBrands.Business.GROUP_ADS, A(4096, j2));
            aQG();
            AppMethodBeat.o(197036);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.XAgreementSettings", th, "saveFuncsSwith fail", new Object[0]);
            AppMethodBeat.o(197036);
        }
    }

    private static int A(long j2, long j3) {
        if ((j3 & j2) == j2) {
            return 0;
        }
        return 1;
    }

    private static MultiProcessMMKV sn(int i2) {
        AppMethodBeat.i(197037);
        MultiProcessMMKV KM = KM("xagreement_biz_entry_by_id_".concat(String.valueOf(i2)));
        AppMethodBeat.o(197037);
        return KM;
    }

    public static String aWF() {
        AppMethodBeat.i(197038);
        String KN = KN("funcs_title");
        if (KN.equals("funcs_title")) {
            AppMethodBeat.o(197038);
            return null;
        }
        AppMethodBeat.o(197038);
        return KN;
    }

    public static String aWG() {
        AppMethodBeat.i(197039);
        String KN = KN("funcs_content");
        if (KN.equals("funcs_content")) {
            AppMethodBeat.o(197039);
            return null;
        }
        AppMethodBeat.o(197039);
        return KN;
    }

    public static String aWH() {
        AppMethodBeat.i(197040);
        String KN = KN("funcs_url");
        if (KN.equals("funcs_url")) {
            AppMethodBeat.o(197040);
            return null;
        }
        AppMethodBeat.o(197040);
        return KN;
    }

    public static void so(int i2) {
        MultiProcessMMKV KM;
        AppMethodBeat.i(197041);
        String aWD = aWD();
        Log.i("MicroMsg.XAgreementSettings", "#saveWalletRegion, walletRegion = " + i2 + ", uin = " + aWD);
        if (!(i2 == -1 || TextUtils.isEmpty(aWD) || (KM = KM("xagreement_wallet_region")) == null)) {
            KM.encode(aWD, i2);
        }
        AppMethodBeat.o(197041);
    }

    public static void aWI() {
        AppMethodBeat.i(197042);
        if (sInstalled) {
            Log.w("MicroMsg.XAgreementSettings", "[!] Already initialized.");
            AppMethodBeat.o(197042);
            return;
        }
        iGh = new HashSet();
        sp(aWE());
        WeChatBrands.updateBizRestrictHandler(new android.arch.a.c.a<WeChatBrands.Business.Entries, Boolean>() {
            /* class com.tencent.mm.model.cr.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* synthetic */ Boolean apply(WeChatBrands.Business.Entries entries) {
                AppMethodBeat.i(196999);
                Boolean valueOf = Boolean.valueOf(WeChatBrands.Business.Entries.restricted(a.C0447a.a(entries)));
                AppMethodBeat.o(196999);
                return valueOf;
            }
        });
        WeChatBrands.updateBizRestrictAlertHandler(new android.arch.a.c.a<WeChatBrands.Business.Entries, Boolean>() {
            /* class com.tencent.mm.model.cr.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* synthetic */ Boolean apply(WeChatBrands.Business.Entries entries) {
                boolean z;
                AppMethodBeat.i(197000);
                int a2 = a.C0447a.a(entries);
                if (WeChatBrands.Business.Entries.signRequsted(a2) || WeChatBrands.Business.Entries.banned(a2)) {
                    z = true;
                } else {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(197000);
                return valueOf;
            }
        });
        EventCenter.instance.add(new IListener<cp>() {
            /* class com.tencent.mm.model.cr.AnonymousClass3 */

            {
                AppMethodBeat.i(197001);
                this.__eventId = cp.class.getName().hashCode();
                AppMethodBeat.o(197001);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(cp cpVar) {
                AppMethodBeat.i(197002);
                g.aAi();
                cr.so(((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) -1)).intValue());
                AppMethodBeat.o(197002);
                return false;
            }
        });
        d.refresh();
        sInstalled = true;
        AppMethodBeat.o(197042);
    }

    private static void sp(int i2) {
        AppMethodBeat.i(197043);
        WeChatBrands.update(i2);
        WeChatBrands.updateReplacer(a.aWL());
        WeChatBrands.updateReplacer(new WeChatBrands.IReplaceApply<String, String>() {
            /* class com.tencent.mm.model.cr.AnonymousClass4 */
            WeChatBrands.IReplaceApply<String, String> iGi = a.aWL();

            {
                AppMethodBeat.i(197003);
                AppMethodBeat.o(197003);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.pointers.PInt] */
            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply
            public final /* synthetic */ String apply(String str, PInt pInt) {
                AppMethodBeat.i(197005);
                String str2 = str;
                if (str2.equals("BRAND_Pay") && !cr.access$100()) {
                    String apply = this.iGi.apply("BRAND_Pay_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply;
                } else if (str2.equals("BRAND_Credit_Card") && !cr.access$100()) {
                    String apply2 = this.iGi.apply("BRAND_Credit_Card_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply2;
                } else if (str2.equals("BRAND_Transfer") && !cr.access$100()) {
                    String apply3 = this.iGi.apply("BRAND_Transfer_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply3;
                } else if (str2.equals("BRAND_Scan_Payment") && !cr.access$100()) {
                    String apply4 = this.iGi.apply("BRAND_Scan_Payment_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply4;
                } else if (str2.equals("BRAND_Balance") && !cr.access$100()) {
                    String apply5 = this.iGi.apply("BRAND_Balance_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply5;
                } else if (str2.equals("Cards_and_Offers") && !cr.access$100()) {
                    String apply6 = this.iGi.apply("Cards_and_Offers_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply6;
                } else if (str2.equals("BRAND_Wallet") && !cr.access$100()) {
                    String apply7 = this.iGi.apply("BRAND_Wallet_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply7;
                } else if (str2.equals("BRAND_Split_Bill") && !cr.access$100()) {
                    String apply8 = this.iGi.apply("BRAND_Split_Bill_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply8;
                } else if (!str2.equals("BRAND_Movie_Tickets") || cr.access$100()) {
                    String apply9 = this.iGi.apply(str2, pInt);
                    AppMethodBeat.o(197005);
                    return apply9;
                } else {
                    String apply10 = this.iGi.apply("BRAND_Movie_Tickets_Oversea", pInt);
                    AppMethodBeat.o(197005);
                    return apply10;
                }
            }

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply
            public final void reload() {
                AppMethodBeat.i(197004);
                this.iGi.reload();
                AppMethodBeat.o(197004);
            }
        });
        AppMethodBeat.o(197043);
    }

    public static void F(Runnable runnable) {
        AppMethodBeat.i(197044);
        iGh.add(runnable);
        AppMethodBeat.o(197044);
    }

    private static void aQG() {
        AppMethodBeat.i(197045);
        for (Runnable runnable : iGh) {
            runnable.run();
        }
        AppMethodBeat.o(197045);
    }

    static class b {
        static HashMap<String, String> iGt;

        static synchronized void cP(Context context) {
            synchronized (b.class) {
                AppMethodBeat.i(197018);
                if (iGt != null) {
                    AppMethodBeat.o(197018);
                } else {
                    a.a(context, (int) R.raw.domain_mainland, new a.d() {
                        /* class com.tencent.mm.model.cr.b.AnonymousClass1 */

                        @Override // com.tencent.mm.model.cr.a.d
                        public final void w(JSONObject jSONObject) {
                            AppMethodBeat.i(197017);
                            HashMap<String, String> hashMap = new HashMap<>();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(jSONObject.optString(next), next);
                            }
                            b.iGt = hashMap;
                            AppMethodBeat.o(197017);
                        }
                    });
                    AppMethodBeat.o(197018);
                }
            }
        }
    }

    public static String KN(String str) {
        AppMethodBeat.i(197046);
        String apply = a.iGk.apply(str, new PInt());
        AppMethodBeat.o(197046);
        return apply;
    }

    public static String KO(String str) {
        String str2;
        String str3;
        AppMethodBeat.i(197047);
        if (WeChatBrands.UserInfo.xagreementId == 0 || WeChatBrands.UserInfo.xagreementId == 1) {
            AppMethodBeat.o(197047);
            return str;
        }
        int indexOf = str.indexOf("://");
        String str4 = "";
        if (indexOf >= 0) {
            str4 = str.substring(0, indexOf + 3);
            if (!str4.startsWith("http")) {
                AppMethodBeat.o(197047);
                return str;
            }
        }
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (indexOf2 >= 0) {
            str2 = str.substring(indexOf2);
        } else {
            str2 = "";
        }
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(":");
        if (indexOf3 >= 0) {
            String substring = str.substring(0, indexOf3);
            str3 = str.substring(indexOf3);
            str = substring;
        } else {
            str3 = "";
        }
        if (b.iGt == null) {
            b.cP(MMApplicationContext.getContext());
        }
        String str5 = str4 + a.iGk.apply(b.iGt.get(str), new PInt()) + str3 + str2;
        AppMethodBeat.o(197047);
        return str5;
    }

    /* access modifiers changed from: package-private */
    public static abstract class a implements WeChatBrands.IReplaceApply<String, String> {
        private static final a iGk = new a() {
            /* class com.tencent.mm.model.cr.a.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.pointers.PInt] */
            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply, com.tencent.mm.model.cr.a
            public final /* bridge */ /* synthetic */ String apply(String str, PInt pInt) {
                AppMethodBeat.i(197008);
                String apply = apply(str, pInt);
                AppMethodBeat.o(197008);
                return apply;
            }

            @Override // com.tencent.mm.model.cr.a
            public final String apply(String str, PInt pInt) {
                AppMethodBeat.i(197007);
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.o(197007);
                    return "";
                }
                String apply = super.apply(str, pInt);
                if (apply != null) {
                    AppMethodBeat.o(197007);
                    return apply;
                }
                String KQ = b.KQ(str);
                if (KQ != null) {
                    String a2 = a(str, KQ, (Integer) 0);
                    AppMethodBeat.o(197007);
                    return a2;
                }
                String KQ2 = c.KQ(str);
                if (KQ2 != null) {
                    pInt.value = 1;
                    String a3 = a(str, KQ2, (Integer) 1);
                    AppMethodBeat.o(197007);
                    return a3;
                }
                AppMethodBeat.o(197007);
                return str;
            }

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply
            public final void reload() {
                AppMethodBeat.i(197006);
                this.iGj = new ConcurrentHashMap();
                c.cO(MMApplicationContext.getContext());
                b.cN(MMApplicationContext.getContext());
                AppMethodBeat.o(197006);
            }
        };
        Map<String, k<String, Integer>> iGj = new ConcurrentHashMap();

        /* access modifiers changed from: package-private */
        public interface d {
            void w(JSONObject jSONObject);
        }

        a() {
        }

        /* JADX INFO: finally extract failed */
        static /* synthetic */ void a(Context context, int i2, d dVar) {
            StringWriter stringWriter;
            InputStream inputStream;
            Throwable th;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                inputStream = context.getResources().openRawResource(i2);
                try {
                    stringWriter = new StringWriter();
                } catch (IOException e2) {
                    e = e2;
                    stringWriter = null;
                    try {
                        Log.printErrStackTrace("MicroMsg.XAgreementSettings", e, "#loadDefTable fail, %s", Integer.valueOf(i2));
                        aa.closeQuietly(inputStream);
                        aa.closeQuietly(stringWriter);
                        Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th2) {
                        th = th2;
                        aa.closeQuietly(inputStream);
                        aa.closeQuietly(stringWriter);
                        throw th;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    stringWriter = null;
                    Log.printErrStackTrace("MicroMsg.XAgreementSettings", e, "#loadDefTable fail, %s", Integer.valueOf(i2));
                    aa.closeQuietly(inputStream);
                    aa.closeQuietly(stringWriter);
                    Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th3) {
                    th = th3;
                    stringWriter = null;
                    aa.closeQuietly(inputStream);
                    aa.closeQuietly(stringWriter);
                    throw th;
                }
                try {
                    char[] cArr = new char[1024];
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            stringWriter.write(cArr, 0, read);
                        }
                        inputStream.close();
                        dVar.w(new JSONObject(stringWriter.toString()));
                        aa.closeQuietly(inputStream);
                        aa.closeQuietly(stringWriter);
                        Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th4) {
                        inputStream.close();
                        throw th4;
                    }
                } catch (IOException | JSONException e4) {
                    e = e4;
                    Log.printErrStackTrace("MicroMsg.XAgreementSettings", e, "#loadDefTable fail, %s", Integer.valueOf(i2));
                    aa.closeQuietly(inputStream);
                    aa.closeQuietly(stringWriter);
                    Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (IOException e5) {
                e = e5;
                stringWriter = null;
                inputStream = null;
                Log.printErrStackTrace("MicroMsg.XAgreementSettings", e, "#loadDefTable fail, %s", Integer.valueOf(i2));
                aa.closeQuietly(inputStream);
                aa.closeQuietly(stringWriter);
                Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (JSONException e6) {
                e = e6;
                stringWriter = null;
                inputStream = null;
                Log.printErrStackTrace("MicroMsg.XAgreementSettings", e, "#loadDefTable fail, %s", Integer.valueOf(i2));
                aa.closeQuietly(inputStream);
                aa.closeQuietly(stringWriter);
                Log.i("MicroMsg.XAgreementSettings", "Load default res table %s spent %s(ms)", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th5) {
                th = th5;
                stringWriter = null;
                inputStream = null;
                aa.closeQuietly(inputStream);
                aa.closeQuietly(stringWriter);
                throw th;
            }
        }

        public String apply(String str, PInt pInt) {
            k<String, Integer> kVar = this.iGj.get(str);
            if (kVar == null) {
                return null;
            }
            pInt.value = kVar.second.intValue();
            return kVar.first;
        }

        public final String a(String str, String str2, Integer num) {
            this.iGj.put(str, k.c(str2, num));
            return str2;
        }

        /* access modifiers changed from: package-private */
        public static class c {
            private static boolean iGo = false;
            private static JSONObject iGq;
            private static int iGr = -1;

            c() {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
                if (com.tencent.mm.model.cr.a.c.iGq == null) goto L_0x0038;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
                if (com.tencent.mm.model.cr.a.c.iGr != com.tencent.mm.R.raw.domain_mainland) goto L_0x0038;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.c.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                com.tencent.mm.model.cr.a.c.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
                monitor-exit(com.tencent.mm.model.cr.a.c.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0034, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197015);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x0037, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0038, code lost:
                com.tencent.mm.model.cr.a.a(r4, (int) com.tencent.mm.R.raw.domain_mainland, new com.tencent.mm.model.cr.a.c.AnonymousClass1());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0045, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.c.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
                com.tencent.mm.model.cr.a.c.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0049, code lost:
                monitor-exit(com.tencent.mm.model.cr.a.c.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x004e, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0050, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197015);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0053, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x0054, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0057, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.c.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
                com.tencent.mm.model.cr.a.c.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x005c, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197015);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x005f, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0060, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x0062, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197015);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x0065, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static void cO(android.content.Context r4) {
                /*
                // Method dump skipped, instructions count: 102
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.cr.a.c.cO(android.content.Context):void");
            }

            /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static java.lang.String KQ(java.lang.String r4) {
                /*
                    r1 = 0
                    r3 = 197016(0x30198, float:2.76078E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    int r0 = com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo.xagreementId
                    com.tencent.mm.sdk.platformtools.MultiProcessMMKV r0 = com.tencent.mm.model.cr.sq(r0)
                    if (r0 == 0) goto L_0x0019
                    java.lang.String r0 = r0.getString(r4, r1)
                    if (r0 == 0) goto L_0x001a
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                L_0x0018:
                    return r0
                L_0x0019:
                    r0 = r1
                L_0x001a:
                    org.json.JSONObject r2 = com.tencent.mm.model.cr.a.c.iGq
                    if (r2 == 0) goto L_0x0024
                    org.json.JSONObject r0 = com.tencent.mm.model.cr.a.c.iGq
                    java.lang.String r0 = r0.optString(r4, r1)
                L_0x0024:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    goto L_0x0018
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.cr.a.c.KQ(java.lang.String):java.lang.String");
            }
        }

        static a aWL() {
            iGk.reload();
            return iGk;
        }

        static void clearCache() {
            iGk.iGj.clear();
        }

        /* access modifiers changed from: package-private */
        public static class b {
            private static JSONObject iGm;
            private static int iGn = -1;
            private static boolean iGo = false;

            b() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:9:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static java.lang.String KQ(java.lang.String r4) {
                /*
                    r1 = 0
                    r3 = 197012(0x30194, float:2.76073E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    java.lang.String r0 = com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.lang
                    java.lang.String r0 = com.tencent.mm.model.cr.aT(r4, r0)
                    int r2 = com.tencent.mm.sdk.platformtools.WeChatBrands.UserInfo.xagreementId
                    com.tencent.mm.sdk.platformtools.MultiProcessMMKV r2 = com.tencent.mm.model.cr.sr(r2)
                    if (r2 == 0) goto L_0x001f
                    java.lang.String r0 = r2.getString(r0, r1)
                    if (r0 == 0) goto L_0x0020
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                L_0x001e:
                    return r0
                L_0x001f:
                    r0 = r1
                L_0x0020:
                    org.json.JSONObject r2 = com.tencent.mm.model.cr.a.b.iGm
                    if (r2 == 0) goto L_0x002a
                    org.json.JSONObject r0 = com.tencent.mm.model.cr.a.b.iGm
                    java.lang.String r0 = r0.optString(r4, r1)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    goto L_0x001e
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.cr.a.b.KQ(java.lang.String):java.lang.String");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
                r3 = com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.lang;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
                switch(r3.hashCode()) {
                    case 2155: goto L_0x0042;
                    case 2217: goto L_0x0062;
                    case 2307: goto L_0x004c;
                    case 2691: goto L_0x0057;
                    default: goto L_0x0022;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
                r0 = 65535;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
                switch(r0) {
                    case 0: goto L_0x006d;
                    case 1: goto L_0x0071;
                    case 2: goto L_0x0075;
                    default: goto L_0x0026;
                };
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
                r0 = com.tencent.mm.R.raw.words_en_0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
                if (com.tencent.mm.model.cr.a.b.iGm == null) goto L_0x007f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
                if (com.tencent.mm.model.cr.a.b.iGn != r0) goto L_0x007f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.b.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
                com.tencent.mm.model.cr.a.b.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
                monitor-exit(com.tencent.mm.model.cr.a.b.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x0049, code lost:
                if (r3.equals(com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.LANG_CN) == false) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
                if (r3.equals(com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.LANG_HK) == false) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0055, code lost:
                r0 = 1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x005e, code lost:
                if (r3.equals(com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.LANG_TW) == false) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x0060, code lost:
                r0 = 2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0069, code lost:
                if (r3.equals(com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.LANG_EN) == false) goto L_0x0022;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x006b, code lost:
                r0 = 3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
                r0 = com.tencent.mm.R.raw.words_cn_0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x0071, code lost:
                r0 = com.tencent.mm.R.raw.words_hk_0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x0075, code lost:
                r0 = com.tencent.mm.R.raw.words_tw_0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:44:0x0079, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x007b, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197013);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:0x007e, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:0x007f, code lost:
                com.tencent.mm.model.cr.a.a(r6, r0, new com.tencent.mm.model.cr.a.b.AnonymousClass1());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x0089, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.b.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
                com.tencent.mm.model.cr.a.b.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:53:0x008d, code lost:
                monitor-exit(com.tencent.mm.model.cr.a.b.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:55:0x0092, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:57:0x0094, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197013);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:58:0x0097, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:59:0x0098, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:61:0x009b, code lost:
                monitor-enter(com.tencent.mm.model.cr.a.b.class);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
                com.tencent.mm.model.cr.a.b.iGo = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a0, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197013);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:0x00a3, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:68:0x00a4, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:70:0x00a6, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(197013);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:71:0x00a9, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static void cN(android.content.Context r6) {
                /*
                // Method dump skipped, instructions count: 198
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.model.cr.a.b.cN(android.content.Context):void");
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.model.cr$a$a  reason: collision with other inner class name */
        public static class C0447a {
            static Map<String, Integer> iGl = Collections.emptyMap();

            static {
                AppMethodBeat.i(197010);
                AppMethodBeat.o(197010);
            }

            public static int a(WeChatBrands.Business.Entries entries) {
                MultiProcessMMKV ss;
                AppMethodBeat.i(197009);
                if (iGl.containsKey(entries.group)) {
                    int intValue = iGl.get(entries.group).intValue();
                    AppMethodBeat.o(197009);
                    return intValue;
                } else if (WeChatSomeFeatureSwitch.blockBizEetnryRemoteConfigs() || (ss = cr.ss(WeChatBrands.UserInfo.xagreementId)) == null) {
                    int i2 = entries.status;
                    AppMethodBeat.o(197009);
                    return i2;
                } else {
                    int i3 = ss.getInt(entries.group, entries.status);
                    AppMethodBeat.o(197009);
                    return i3;
                }
            }
        }
    }

    public static class c {
        private static String iGu;

        public static synchronized String aWN() {
            String str;
            synchronized (c.class) {
                AppMethodBeat.i(197019);
                if (iGu == null) {
                    MMApplicationContext.getContext();
                    iGu = null;
                    Log.e("MicroMsg.XAgreementSettings", "hardcode_wechat_us_team is null!!!");
                }
                if (iGu != null) {
                    str = WeChatBrands.Wordings.translate(iGu);
                    AppMethodBeat.o(197019);
                } else {
                    str = "";
                    AppMethodBeat.o(197019);
                }
            }
            return str;
        }
    }

    public static final class d {
        private static int iGv = -1;

        static void refresh() {
            AppMethodBeat.i(197021);
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                /* class com.tencent.mm.model.cr.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(197020);
                    d.aWQ();
                    if (d.aWP()) {
                        cr.st(d.iGv);
                        cr.aWJ();
                    }
                    AppMethodBeat.o(197020);
                }
            });
            AppMethodBeat.o(197021);
        }

        public static void aWO() {
            String[] allKeys;
            String[] allKeys2;
            String[] allKeys3;
            String[] allKeys4;
            AppMethodBeat.i(197025);
            Log.i("MicroMsg.XAgreementSettings", ">>>>>>>>>> WeChat Brands Test Configs <<<<<<<<<<");
            Log.i("MicroMsg.XAgreementSettings", ">> test XagreementId = " + iGv);
            Log.i("MicroMsg.XAgreementSettings", ">> test BinEntry Dict:");
            MultiProcessMMKV KP = cr.KP("xagreement_test_configs");
            if (!(KP == null || (allKeys4 = KP.allKeys()) == null)) {
                for (String str : allKeys4) {
                    Log.i("MicroMsg.XAgreementSettings", str + " = " + KP.getInt(str, -1));
                }
            }
            Log.i("MicroMsg.XAgreementSettings", "\n");
            for (Integer num : Arrays.asList(0, 1, 2, 3)) {
                int intValue = num.intValue();
                Log.i("MicroMsg.XAgreementSettings", ">> cgi Wording Dict for xid " + intValue + ":");
                MultiProcessMMKV sr = cr.sr(intValue);
                if (!(sr == null || (allKeys3 = sr.allKeys()) == null)) {
                    for (String str2 : allKeys3) {
                        Log.i("MicroMsg.XAgreementSettings", str2 + " = " + sr.getString(str2, null));
                    }
                }
                Log.i("MicroMsg.XAgreementSettings", ">> cgi Domain Dict for xid " + intValue + ":");
                MultiProcessMMKV sq = cr.sq(WeChatBrands.UserInfo.xagreementId);
                if (!(sq == null || (allKeys2 = sq.allKeys()) == null)) {
                    for (String str3 : allKeys2) {
                        Log.i("MicroMsg.XAgreementSettings", str3 + " = " + sq.getString(str3, null));
                    }
                }
                Log.i("MicroMsg.XAgreementSettings", ">> cgi Business Dict for xid " + intValue + ":");
                MultiProcessMMKV ss = cr.ss(WeChatBrands.UserInfo.xagreementId);
                if (!(ss == null || (allKeys = ss.allKeys()) == null)) {
                    for (String str4 : allKeys) {
                        Log.i("MicroMsg.XAgreementSettings", str4 + " = " + ss.getInt(str4, -1));
                    }
                }
                Log.i("MicroMsg.XAgreementSettings", "\n");
            }
            Log.i("MicroMsg.XAgreementSettings", ">>>>>>>>>> WECHAT BRANDS TEST CONFIGS <<<<<<<<<<");
            AppMethodBeat.o(197025);
        }

        static boolean aWP() {
            return iGv != -1;
        }

        public static void sw(int i2) {
            AppMethodBeat.i(197022);
            MultiProcessMMKV KP = cr.KP("xagreement_test_configs");
            if (KP != null) {
                KP.putInt("test_xagreement_id", i2).commit();
            }
            refresh();
            AppMethodBeat.o(197022);
        }

        public static void am(String str, int i2) {
            AppMethodBeat.i(197023);
            MultiProcessMMKV KP = cr.KP("xagreement_test_configs");
            if (KP != null) {
                KP.putInt(str, i2).commit();
            }
            refresh();
            AppMethodBeat.o(197023);
        }

        public static void clearAll() {
            AppMethodBeat.i(197024);
            MultiProcessMMKV KP = cr.KP("xagreement_test_configs");
            if (KP != null) {
                KP.clearAll();
            }
            iGv = -1;
            cr.st(cr.aWK());
            refresh();
            AppMethodBeat.o(197024);
        }

        static /* synthetic */ void aWQ() {
            AppMethodBeat.i(197026);
            a.C0447a.iGl.clear();
            MultiProcessMMKV KP = cr.KP("xagreement_test_configs");
            if (!(KP == null || KP.allKeys() == null || KP.allKeys().length <= 0)) {
                String[] allKeys = KP.allKeys();
                for (String str : allKeys) {
                    int i2 = KP.getInt(str, -1);
                    if ("test_xagreement_id".equals(str)) {
                        iGv = i2;
                    } else {
                        if (a.C0447a.iGl == Collections.EMPTY_MAP) {
                            a.C0447a.iGl = new ConcurrentHashMap();
                        }
                        a.C0447a.iGl.put(str, Integer.valueOf(i2));
                    }
                }
            }
            AppMethodBeat.o(197026);
        }
    }

    public static void sk(int i2) {
        AppMethodBeat.i(197028);
        try {
            Log.i("MicroMsg.XAgreementSettings", "Save XAgreementId %s", Integer.valueOf(i2));
            if (WeChatBrands.UserInfo.xagreementId == i2) {
                Log.i("MicroMsg.XAgreementSettings", "no need to update current XAgreementId");
            } else {
                String aWD = aWD();
                if (aWD != null) {
                    MultiProcessMMKV KM = KM("xagreement_id_store");
                    if (KM != null) {
                        KM.encode(aWD, i2);
                    }
                } else {
                    Log.e("MicroMsg.XAgreementSettings", "[!] saving xagreementId, but uin is invalid");
                }
                if (d.aWP()) {
                    Log.w("MicroMsg.XAgreementSettings", "skip and ust test XAgreementId, update = " + i2 + ", test = " + d.iGv);
                } else {
                    sp(i2);
                }
            }
            a.clearCache();
            aQG();
            AppMethodBeat.o(197028);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.XAgreementSettings", th, "", new Object[0]);
            AppMethodBeat.o(197028);
        }
    }

    public static void a(ffe ffe) {
        MultiProcessMMKV sl;
        AppMethodBeat.i(197031);
        try {
            Log.i("MicroMsg.XAgreementSettings", "Save saveDomainSettingsImpl");
            if (ffe == null) {
                Log.w("MicroMsg.XAgreementSettings", "xAgreementDmSetting is null.");
            } else if (ffe.KKx == null) {
                Log.w("MicroMsg.XAgreementSettings", "xAgreementDmSetting.Items is null.");
            } else {
                SparseArray sparseArray = new SparseArray();
                Iterator<aho> it = ffe.KKx.iterator();
                while (it.hasNext()) {
                    aho next = it.next();
                    if (next == null) {
                        Log.w("MicroMsg.XAgreementSettings", "dmItem is null..");
                    } else if (next.Lrq < 0) {
                        Log.w("MicroMsg.XAgreementSettings", "[!] illegal id, XAgreementId = " + next.Lrq);
                    } else if (TextUtils.isEmpty(next.xMX)) {
                        Log.w("MicroMsg.XAgreementSettings", "[!] key is empty, XAgreementId = " + next.Lrq);
                    } else {
                        List list = (List) sparseArray.get(next.Lrq);
                        if (list == null) {
                            list = new ArrayList();
                            sparseArray.put(next.Lrq, list);
                        }
                        list.add(new k(next.xMX, next.Cyk));
                    }
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt = sparseArray.keyAt(i2);
                    List<k> list2 = (List) sparseArray.get(keyAt);
                    if (!(list2 == null || (sl = sl(keyAt)) == null)) {
                        for (k kVar : list2) {
                            Log.d("MicroMsg.XAgreementSettings", "xAgreementDmSetting: %s, %s, %s", Integer.valueOf(keyAt), kVar.first, kVar.second);
                            sl.putString(kVar.first, kVar.second);
                        }
                    }
                }
            }
            a.clearCache();
            aQG();
            AppMethodBeat.o(197031);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.XAgreementSettings", th, "", new Object[0]);
            AppMethodBeat.o(197031);
        }
    }

    public static void a(ffh ffh) {
        AppMethodBeat.i(197033);
        try {
            Log.i("MicroMsg.XAgreementSettings", "Save XAgreementWordSettings");
            if (ffh != null) {
                if (ffh.NAC != null) {
                    Iterator<ffg> it = ffh.NAC.iterator();
                    while (it.hasNext()) {
                        ffg next = it.next();
                        if (next != null) {
                            if (next.Lrq >= 0) {
                                Log.i("MicroMsg.XAgreementSettings", "XAgreementId = %s", Integer.valueOf(next.Lrq));
                                if (next.NAB != null) {
                                    MultiProcessMMKV sm = sm(next.Lrq);
                                    if (sm == null) {
                                        break;
                                    }
                                    Iterator<cgy> it2 = next.NAB.iterator();
                                    while (it2.hasNext()) {
                                        cgy next2 = it2.next();
                                        if (next2 == null) {
                                            Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings is null..", Integer.valueOf(next.Lrq));
                                        } else if (TextUtils.isEmpty(next2.xLl)) {
                                            Log.w("MicroMsg.XAgreementSettings", "[!] lang is empty, XAgreementId = " + next.Lrq);
                                        } else if (next2.KKx == null) {
                                            Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings(lang = %s).Items is null.", Integer.valueOf(next.Lrq), next2.xLl);
                                        } else {
                                            Iterator<fbv> it3 = next2.KKx.iterator();
                                            while (it3.hasNext()) {
                                                fbv next3 = it3.next();
                                                if (next3 == null) {
                                                    Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings(lang = %s).Items is null..", Integer.valueOf(next.Lrq), next2.xLl);
                                                } else if (TextUtils.isEmpty(next3.xMX)) {
                                                    Log.w("MicroMsg.XAgreementSettings", "[!] wodring key is empty, XAgreementId = " + next.Lrq + ", lang = " + next2.xLl);
                                                } else {
                                                    Log.d("MicroMsg.XAgreementSettings", "XAgreementWordings: %s, %s, %s", next2.xLl, next3.xMX, next3.Cyk);
                                                    sm.putString(aS(next3.xMX, next2.xLl), next3.Cyk);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Log.w("MicroMsg.XAgreementSettings", "[!] LangWordings is null.", Integer.valueOf(next.Lrq));
                                }
                            } else {
                                Log.w("MicroMsg.XAgreementSettings", "[!] illegal id, XAgreementId = " + next.Lrq);
                            }
                        } else {
                            Log.w("MicroMsg.XAgreementSettings", "xAgreementWording is null..");
                        }
                    }
                } else {
                    Log.w("MicroMsg.XAgreementSettings", "XAgreementWording is null.");
                }
            } else {
                Log.w("MicroMsg.XAgreementSettings", "xAgreementWordingSetting is null.");
            }
            a.clearCache();
            aQG();
            AppMethodBeat.o(197033);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.XAgreementSettings", th, "", new Object[0]);
            AppMethodBeat.o(197033);
        }
    }

    static /* synthetic */ boolean access$100() {
        int i2 = -1;
        AppMethodBeat.i(197048);
        String aWD = aWD();
        if (TextUtils.isEmpty(aWD)) {
            boolean isMainland = WeChatBrands.AppInfo.current().isMainland();
            AppMethodBeat.o(197048);
            return isMainland;
        }
        MultiProcessMMKV KM = KM("xagreement_wallet_region");
        if (KM != null) {
            i2 = KM.getInt(aWD, -1);
        }
        if (i2 == 0 || i2 == 1) {
            AppMethodBeat.o(197048);
            return true;
        }
        AppMethodBeat.o(197048);
        return false;
    }

    static /* synthetic */ void aWJ() {
        AppMethodBeat.i(197054);
        a.clearCache();
        AppMethodBeat.o(197054);
    }
}
