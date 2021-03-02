package com.tencent.mm.plugin.performance.diagnostic.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.performance.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class c implements com.tencent.mm.plugin.performance.a.c {
    private static final String ATk = b.aJR("ù³¼¶ý¨¤¯¨¦¦¹¿­¦è¡¥µ¡«");
    private static final String ATl = (ATk + b.aJR("êá²¦²¦§·"));
    private static final String ATm = (ATk + b.aJR("åà«£³·®°¨"));
    private static final String ATn = (ATk + b.aJR("æí¤ª© µ¥¦§»"));
    private static final String ATo = (ATk + b.aJR("åàµ´¨£¤±°"));
    private static final String ATp = (ATk + b.aJR("çî­­©£° ¶«"));
    private static final String ATq = b.aJR("·¨¤ª");
    private static final String ATr = b.aJR(" ¬º");
    private static Map<String, d<Boolean>> ATs = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private static Map<String, d<Void>> ATt = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private static MMHandler ATu = new MMHandler(b.aJR("©§¨¦¦¹¿­¦ë¡¥µ¡«"));
    private static final String PACKAGE_NAME = MMApplicationContext.getContext().getPackageName();
    private static final String TAG = b.aJR("¿´¢¾ «ãª¼ª¢¥±§¯¦« ");

    static /* synthetic */ String access$000() {
        AppMethodBeat.i(124945);
        String bUg = bUg();
        AppMethodBeat.o(124945);
        return bUg;
    }

    static /* synthetic */ String c(Map map, String str, String str2) {
        AppMethodBeat.i(124948);
        String b2 = b(map, str, str2);
        AppMethodBeat.o(124948);
        return b2;
    }

    static {
        AppMethodBeat.i(124950);
        ATs.put(ATq, new d<Boolean>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124919);
                Boolean valueOf = Boolean.valueOf(c.ATq.equalsIgnoreCase(c.access$000()));
                AppMethodBeat.o(124919);
                return valueOf;
            }
        });
        ATs.put(ATr, new d<Boolean>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* bridge */ /* synthetic */ Object dO(Map<String, String> map) {
                return Boolean.TRUE;
            }
        });
        ATt.put(b.aJR("¦¤µ¢í ²¨"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124921);
                Void eBY = eBY();
                AppMethodBeat.o(124921);
                return eBY;
            }

            private static Void eBY() {
                AppMethodBeat.i(124920);
                try {
                    c.W(b.V(new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir)));
                } catch (Throwable th) {
                    Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 2.", new Object[0]);
                }
                AppMethodBeat.o(124920);
                return null;
            }
        });
        ATt.put(b.aJR("©¥¶£ê¯¥§»"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124923);
                Void eBY = eBY();
                AppMethodBeat.o(124923);
                return eBY;
            }

            private static Void eBY() {
                AppMethodBeat.i(124922);
                try {
                    o jn = c.jn(b.aJR("©¥¶£ê¯¥§»"), ".zip");
                    o oVar = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
                    String[] strArr = Build.SUPPORTED_ABIS;
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        o oVar2 = new o(oVar.heq(), "oat/" + b.aJS(strArr[i2]) + "/base.odex");
                        if (oVar2.canRead()) {
                            b.a(oVar2, jn, null);
                            c.W(jn);
                            AppMethodBeat.o(124922);
                            return null;
                        }
                    }
                    IOException iOException = new IOException("cannot find readable base odex path.");
                    AppMethodBeat.o(124922);
                    throw iOException;
                } catch (Throwable th) {
                    Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 3.", new Object[0]);
                }
            }
        });
        ATt.put(b.aJR("©¥¶£ê¶¥§»"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124925);
                Void eBY = eBY();
                AppMethodBeat.o(124925);
                return eBY;
            }

            private static Void eBY() {
                AppMethodBeat.i(124924);
                try {
                    o jn = c.jn(b.aJR("©¥¶£ê¶¥§»"), ".zip");
                    o oVar = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
                    String[] strArr = Build.SUPPORTED_ABIS;
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        o oVar2 = new o(oVar.heq(), "oat/" + b.aJS(strArr[i2]) + "/base.vdex");
                        if (oVar2.canRead()) {
                            b.a(oVar2, jn, null);
                            c.W(jn);
                            AppMethodBeat.o(124924);
                            return null;
                        }
                    }
                    IOException iOException = new IOException("cannot find readable base vdex path.");
                    AppMethodBeat.o(124924);
                    throw iOException;
                } catch (Throwable th) {
                    Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 4.", new Object[0]);
                }
            }
        });
        ATt.put(b.aJR("§§´¥ì±¬"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass7 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124928);
                Void aC = aC(map);
                AppMethodBeat.o(124928);
                return aC;
            }

            private Void aC(Map<String, String> map) {
                AppMethodBeat.i(124927);
                String str = map.get(c.ATn);
                if (TextUtils.isEmpty(str)) {
                    Log.e(c.TAG, "[-] Explained by src 5.");
                    AppMethodBeat.o(124927);
                } else {
                    try {
                        o jn = c.jn(b.aJR("§§´¥ì±¬"), ".zip");
                        o oVar = new o(MMApplicationContext.getContext().getApplicationInfo().sourceDir);
                        String[] strArr = Build.SUPPORTED_ABIS;
                        int length = strArr.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            o oVar2 = new o(oVar.heq(), "lib/" + b.aJS(strArr[i2]));
                            if (oVar2.canRead()) {
                                final Pattern compile = Pattern.compile(str);
                                b.a(oVar2, jn, new q() {
                                    /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass7.AnonymousClass1 */

                                    @Override // com.tencent.mm.vfs.q
                                    public final boolean accept(o oVar) {
                                        AppMethodBeat.i(176899);
                                        boolean matches = compile.matcher(oVar.getName()).matches();
                                        AppMethodBeat.o(176899);
                                        return matches;
                                    }
                                });
                                c.W(jn);
                                AppMethodBeat.o(124927);
                            }
                        }
                        IOException iOException = new IOException("cannot find readable lib dir.");
                        AppMethodBeat.o(124927);
                        throw iOException;
                    } catch (Throwable th) {
                        Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 6: %s", str);
                    }
                }
                return null;
            }
        });
        ATt.put(b.aJR("­ ²°"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass8 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124930);
                Void aC = aC(map);
                AppMethodBeat.o(124930);
                return aC;
            }

            private static Void aC(Map<String, String> map) {
                String str;
                AppMethodBeat.i(124929);
                String aJU = c.aJU(c.c(map, c.ATo, ""));
                try {
                    if (TextUtils.isEmpty(aJU)) {
                        str = c.PACKAGE_NAME;
                    } else {
                        str = c.PACKAGE_NAME + ":" + aJU;
                    }
                    a.bo(MMApplicationContext.getContext(), str);
                } catch (Throwable th) {
                    Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 7: %s", aJU);
                }
                AppMethodBeat.o(124929);
                return null;
            }
        });
        ATt.put(b.aJR("´­ ²°"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(124932);
                Void aC = aC(map);
                AppMethodBeat.o(124932);
                return aC;
            }

            private static Void aC(Map<String, String> map) {
                String str;
                AppMethodBeat.i(124931);
                String aJU = c.aJU(c.c(map, c.ATo, ""));
                try {
                    if (TextUtils.isEmpty(aJU)) {
                        str = c.PACKAGE_NAME;
                    } else {
                        str = c.PACKAGE_NAME + ":" + aJU;
                    }
                    a.bp(MMApplicationContext.getContext(), str);
                } catch (Throwable th) {
                    Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 8: %s", aJU);
                }
                AppMethodBeat.o(124931);
                return null;
            }
        });
        ATt.put(b.aJR("µ¾³ì±¬"), new d<Void>() {
            /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass10 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.performance.diagnostic.a.a
            public final /* synthetic */ Object dO(Map<String, String> map) {
                AppMethodBeat.i(201045);
                Void aC = aC(map);
                AppMethodBeat.o(201045);
                return aC;
            }

            private static Void aC(Map<String, String> map) {
                AppMethodBeat.i(201044);
                String str = map.get(c.ATp);
                if (TextUtils.isEmpty(str)) {
                    Log.e(c.TAG, "filePath NULL");
                    AppMethodBeat.o(201044);
                } else {
                    try {
                        o jn = c.jn(b.aJR("µ¾³ì±¬"), ".zip");
                        b.a(new o(str), jn, null);
                        c.W(jn);
                    } catch (Throwable th) {
                        Log.printErrStackTrace(c.TAG, th, "[-] faild op %s", str);
                    }
                    AppMethodBeat.o(201044);
                }
                return null;
            }
        });
        AppMethodBeat.o(124950);
    }

    private static String b(Map<String, String> map, String str, String str2) {
        AppMethodBeat.i(124941);
        String str3 = map.get(str);
        if (str3 != null) {
            AppMethodBeat.o(124941);
            return str3;
        }
        AppMethodBeat.o(124941);
        return str2;
    }

    private static String bUg() {
        AppMethodBeat.i(124942);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            String str = ATq;
            AppMethodBeat.o(124942);
            return str;
        }
        String str2 = ATr;
        AppMethodBeat.o(124942);
        return str2;
    }

    public c() {
        AppMethodBeat.i(124943);
        a.K(MMApplicationContext.getContext());
        AppMethodBeat.o(124943);
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final void eBD() {
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final void aA(final Map<String, String> map) {
        AppMethodBeat.i(201046);
        final String str = map.get(ATl);
        if (Util.isNullOrNil(str)) {
            Log.e(TAG, "[-] Target is null or empty!");
            AppMethodBeat.o(201046);
        } else if (!ATt.containsKey(str)) {
            Log.e(TAG, "[-] Target is absent.");
            AppMethodBeat.o(201046);
        } else {
            String b2 = b(map, ATm, ATq);
            if (!ATs.containsKey(b2)) {
                Log.e(TAG, "[-] Explained by src 9: %s", b2);
                AppMethodBeat.o(201046);
            } else if (!ATs.get(b2).dO(map).booleanValue()) {
                Log.w(TAG, "[!] Explained by src 10: %s, %s", bUg(), b2);
                AppMethodBeat.o(201046);
            } else {
                Log.i(TAG, "[+] Explained by src 11: %s, %s, %s", str, b2, bUg());
                ATu.post(new Runnable() {
                    /* class com.tencent.mm.plugin.performance.diagnostic.a.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(201043);
                        ((d) c.ATt.get(str)).dO(map);
                        AppMethodBeat.o(201043);
                    }
                });
                AppMethodBeat.o(201046);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends BroadcastReceiver {
        private static final String ACTION = (NativeProtocol.WEB_DIALOG_ACTION + c.ATk);
        private static final String ATA = WeChatPermissions.PERMISSION_MM_MESSAGE();
        private static final String ATB = b.aJR("µ´¨£¤±°");
        private static final String ATC = b.aJR("­­©£° ¶«");
        private static a ATD = null;

        private a() {
        }

        static {
            AppMethodBeat.i(124940);
            AppMethodBeat.o(124940);
        }

        static synchronized void K(Context context) {
            synchronized (a.class) {
                AppMethodBeat.i(124934);
                if (ATD != null) {
                    AppMethodBeat.o(124934);
                } else {
                    ATD = new a();
                    try {
                        context.registerReceiver(ATD, new IntentFilter(ACTION), ATA, null);
                        AppMethodBeat.o(124934);
                    } catch (Throwable th) {
                        Log.printErrStackTrace(c.TAG, th, "[-] Fail to register receiver.", new Object[0]);
                        Log.appenderFlush();
                        AppMethodBeat.o(124934);
                    }
                }
            }
        }

        static void bo(Context context, String str) {
            AppMethodBeat.i(124935);
            Intent intent = new Intent(ACTION);
            intent.putExtra("op", 1);
            intent.putExtra(ATB, str);
            context.sendBroadcast(intent, ATA);
            AppMethodBeat.o(124935);
        }

        static void bp(Context context, String str) {
            AppMethodBeat.i(124936);
            Intent intent = new Intent(ACTION);
            intent.putExtra("op", 2);
            intent.putExtra(ATB, str);
            context.sendBroadcast(intent, ATA);
            AppMethodBeat.o(124936);
        }

        private static void bq(Context context, String str) {
            AppMethodBeat.i(124937);
            Intent intent = new Intent(ACTION);
            intent.putExtra("op", 3);
            intent.putExtra(ATC, str);
            context.sendBroadcast(intent, ATA);
            AppMethodBeat.o(124937);
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(124938);
            String action = intent.getAction();
            if (!ACTION.equals(action)) {
                Log.e(c.TAG, "[-] Explained by src 12: %s", action);
                AppMethodBeat.o(124938);
                return;
            }
            int intExtra = intent.getIntExtra("op", 0);
            switch (intExtra) {
                case 1:
                    String stringExtra = intent.getStringExtra(ATB);
                    if (TextUtils.isEmpty(stringExtra)) {
                        Log.e(c.TAG, "[-] Explained by src 13.");
                        AppMethodBeat.o(124938);
                        return;
                    } else if (!stringExtra.equals(MMApplicationContext.getProcessName())) {
                        AppMethodBeat.o(124938);
                        return;
                    } else {
                        try {
                            int aJT = b.aJT(stringExtra);
                            if (aJT == 0) {
                                IOException iOException = new IOException("cannot find process: ".concat(String.valueOf(stringExtra)));
                                AppMethodBeat.o(124938);
                                throw iOException;
                            }
                            o V = b.V(new o("/proc/" + aJT + "/maps"));
                            o jn = c.jn(stringExtra.replace(':', '-') + "-" + b.aJR("­ ²°"), ".zip");
                            b.a(V, jn, null);
                            bq(context, aa.z(jn.her()));
                            AppMethodBeat.o(124938);
                            return;
                        } catch (Throwable th) {
                            Log.printErrStackTrace(c.TAG, th, "[-] Explained by src 14: %s", stringExtra);
                            AppMethodBeat.o(124938);
                            return;
                        }
                    }
                case 2:
                    String stringExtra2 = intent.getStringExtra(ATB);
                    if (TextUtils.isEmpty(stringExtra2)) {
                        Log.e(c.TAG, "[-] Explained by src 15.");
                        AppMethodBeat.o(124938);
                        return;
                    } else if (!stringExtra2.equals(MMApplicationContext.getProcessName())) {
                        AppMethodBeat.o(124938);
                        return;
                    } else {
                        try {
                            int aJT2 = b.aJT(stringExtra2);
                            if (aJT2 == 0) {
                                IOException iOException2 = new IOException("cannot find process: ".concat(String.valueOf(stringExtra2)));
                                AppMethodBeat.o(124938);
                                throw iOException2;
                            }
                            o V2 = b.V(new o("/proc/" + aJT2 + "/smaps"));
                            o jn2 = c.jn(stringExtra2.replace(':', '-') + "-" + b.aJR("´­ ²°"), ".zip");
                            b.a(V2, jn2, null);
                            bq(context, aa.z(jn2.her()));
                            AppMethodBeat.o(124938);
                            return;
                        } catch (Throwable th2) {
                            Log.printErrStackTrace(c.TAG, th2, "[-] Explained by src 16: %s", stringExtra2);
                            AppMethodBeat.o(124938);
                            return;
                        }
                    }
                case 3:
                    if (!MMApplicationContext.isMainProcess()) {
                        AppMethodBeat.o(124938);
                        return;
                    }
                    String stringExtra3 = intent.getStringExtra(ATC);
                    if (stringExtra3 == null || stringExtra3.isEmpty()) {
                        Log.e(c.TAG, "[-] Explained by src 17: %s", stringExtra3);
                        AppMethodBeat.o(124938);
                        return;
                    }
                    try {
                        c.W(new o(stringExtra3));
                        AppMethodBeat.o(124938);
                        return;
                    } catch (Throwable th3) {
                        Log.printErrStackTrace(c.TAG, th3, "[-] Explained by src 18.", new Object[0]);
                        AppMethodBeat.o(124938);
                        return;
                    }
                default:
                    Log.e(c.TAG, "[-] Unknown op: %s", Integer.valueOf(intExtra));
                    AppMethodBeat.o(124938);
                    return;
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object
        public final void finalize() {
            AppMethodBeat.i(124939);
            try {
                MMApplicationContext.getContext().unregisterReceiver(this);
            } catch (Throwable th) {
            }
            super.finalize();
            AppMethodBeat.o(124939);
        }
    }

    @Override // com.tencent.mm.plugin.performance.a.c
    public final String eBC() {
        return ATk;
    }

    static /* synthetic */ void W(o oVar) {
        long j2;
        AppMethodBeat.i(176900);
        try {
            g.aAf();
            j2 = (long) com.tencent.mm.kernel.a.getUin();
        } catch (Throwable th) {
            j2 = 0;
        }
        t azz = g.azz();
        String z = aa.z(oVar.her());
        if (azz.iMw == null) {
            Log.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            azz.iMw.d(z, j2, null);
        }
        Log.i(TAG, "[+] Explained by src 1: %s", aa.z(oVar.her()));
        AppMethodBeat.o(176900);
    }

    static /* synthetic */ o jn(String str, String str2) {
        AppMethodBeat.i(176901);
        String str3 = MMApplicationContext.getContext().getExternalCacheDir().getPath() + str + str2;
        if (!s.bpa(str3)) {
            IOException iOException = new IOException("cannot createNewFile:".concat(String.valueOf(str3)));
            AppMethodBeat.o(176901);
            throw iOException;
        }
        o oVar = new o(str3);
        AppMethodBeat.o(176901);
        return oVar;
    }

    static /* synthetic */ String aJU(String str) {
        int i2 = 0;
        AppMethodBeat.i(124949);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(124949);
            return str;
        }
        if (str.charAt(0) == ':') {
            i2 = 1;
        }
        while (i2 < str.length() && str.charAt(i2) == ':') {
            i2++;
        }
        String substring = str.substring(i2);
        AppMethodBeat.o(124949);
        return substring;
    }
}
