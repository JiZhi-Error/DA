package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.n.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class g {
    private static final String[] CAa = {"https://wx.tenpay.com/f2f", "wxp://f2f", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e26) + "/qr/"};
    private static final String[] CAb = {"m", "n"};
    private static List<String> CAc;
    public static final String CAd = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + "/r/");
    public static final String CAe = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/r/");
    public static final String CAf = (HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + "/q/");
    public static final String CAg = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/q/");
    private static final String[] CzW = {HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2m) + "/g/", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/g/"};
    private static final String[] CzX = {HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2i) + FilePathGenerator.ANDROID_DIR_SEP, HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2i) + FilePathGenerator.ANDROID_DIR_SEP};
    private static final String[] CzY = {HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2o) + "/u/", HttpWrapperBase.PROTOCAL_HTTP + WeChatHosts.domainString(R.string.e2o) + "/ct/", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2o) + "/u/", HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2o) + "/ct/"};
    private static final String[] CzZ = {"https://c.weixin.com/g/"};
    private static final String qtb = MMApplicationContext.getApplicationId();

    static /* synthetic */ Set access$000() {
        AppMethodBeat.i(151564);
        Set<String> eOL = eOL();
        AppMethodBeat.o(151564);
        return eOL;
    }

    static /* synthetic */ Set access$100() {
        AppMethodBeat.i(151565);
        Set<String> eOM = eOM();
        AppMethodBeat.o(151565);
        return eOM;
    }

    static {
        AppMethodBeat.i(223703);
        AppMethodBeat.o(223703);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (com.tencent.mm.ipcinvoker.c.axW().Fo(com.tencent.mm.plugin.scanner.g.qtb) == false) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ca(int r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.g.ca(int, java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        if (com.tencent.mm.ipcinvoker.c.axW().Fo(com.tencent.mm.plugin.scanner.g.qtb) == false) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean cb(int r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.g.cb(int, java.lang.String):boolean");
    }

    public static boolean cc(int i2, String str) {
        AppMethodBeat.i(151557);
        if (i2 != 19) {
            AppMethodBeat.o(151557);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151557);
            return false;
        } else {
            for (String str2 : CzX) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(151557);
                    return true;
                }
            }
            AppMethodBeat.o(151557);
            return false;
        }
    }

    public static boolean cd(int i2, String str) {
        AppMethodBeat.i(151558);
        if (i2 != 19) {
            AppMethodBeat.o(151558);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151558);
            return false;
        } else {
            for (String str2 : CzW) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(151558);
                    return true;
                }
            }
            AppMethodBeat.o(151558);
            return false;
        }
    }

    public static boolean ce(int i2, String str) {
        AppMethodBeat.i(151559);
        if (i2 != 19) {
            AppMethodBeat.o(151559);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151559);
            return false;
        } else {
            for (String str2 : CzY) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(151559);
                    return true;
                }
            }
            AppMethodBeat.o(151559);
            return false;
        }
    }

    public static boolean cf(int i2, String str) {
        AppMethodBeat.i(223701);
        if (i2 != 19) {
            AppMethodBeat.o(223701);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(223701);
            return false;
        } else {
            for (String str2 : CzZ) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(223701);
                    return true;
                }
            }
            AppMethodBeat.o(223701);
            return false;
        }
    }

    public static boolean cg(int i2, String str) {
        AppMethodBeat.i(177300);
        if (i2 != 22) {
            AppMethodBeat.o(177300);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177300);
            return false;
        } else {
            for (String str2 : CAb) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(177300);
                    return true;
                }
            }
            AppMethodBeat.o(177300);
            return false;
        }
    }

    public static boolean ch(int i2, String str) {
        AppMethodBeat.i(177301);
        if (i2 != 19) {
            AppMethodBeat.o(177301);
            return false;
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(177301);
            return false;
        } else {
            for (String str2 : CAa) {
                if (str.startsWith(str2)) {
                    AppMethodBeat.o(177301);
                    return true;
                }
            }
            AppMethodBeat.o(177301);
            return false;
        }
    }

    public static boolean ci(int i2, String str) {
        AppMethodBeat.i(151560);
        if (ca(i2, str) || cb(i2, str) || cd(i2, str) || cc(i2, str) || ce(i2, str) || ch(i2, str) || cg(i2, str)) {
            AppMethodBeat.o(151560);
            return true;
        }
        AppMethodBeat.o(151560);
        return false;
    }

    public static int cj(int i2, String str) {
        AppMethodBeat.i(151561);
        if (cb(i2, str)) {
            AppMethodBeat.o(151561);
            return 3;
        } else if (ca(i2, str)) {
            AppMethodBeat.o(151561);
            return 4;
        } else if (cd(i2, str)) {
            AppMethodBeat.o(151561);
            return 2;
        } else if (cc(i2, str)) {
            AppMethodBeat.o(151561);
            return 1;
        } else if (ce(i2, str)) {
            AppMethodBeat.o(151561);
            return 7;
        } else if (cg(i2, str)) {
            AppMethodBeat.o(151561);
            return 5;
        } else if (ch(i2, str)) {
            AppMethodBeat.o(151561);
            return 6;
        } else {
            AppMethodBeat.o(151561);
            return -1;
        }
    }

    private static Set<String> eOL() {
        String str;
        AppMethodBeat.i(151562);
        HashSet hashSet = new HashSet();
        hashSet.add("k");
        hashSet.add("l");
        if (MMApplicationContext.isMMProcess()) {
            d aqK = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqK();
            if (aqK != null) {
                str = aqK.aj("ScanCode", "weAppCodePrefix");
            } else {
                str = "";
            }
            Log.v("MicroMsg.QRCodeLogic", "getWxCodePrefix(%s)", str);
            if (!Util.isNullOrNil(str)) {
                String[] split = str.split("\\|");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!Util.isNullOrNil(split[i2])) {
                        hashSet.add(split[i2]);
                    }
                }
            }
        }
        AppMethodBeat.o(151562);
        return hashSet;
    }

    private static Set<String> eOM() {
        String str;
        AppMethodBeat.i(151563);
        HashSet hashSet = new HashSet();
        hashSet.add(CAd);
        hashSet.add(CAe);
        hashSet.add(CAf);
        hashSet.add(CAg);
        if (MMApplicationContext.isMainProcess()) {
            d aqK = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqK();
            if (aqK != null) {
                str = aqK.aj("ScanCode", "brandCodePrefix");
            } else {
                str = "";
            }
            Log.v("MicroMsg.QRCodeLogic", "getWxBrandCodePrefix(%s)", str);
            if (!Util.isNullOrNil(str)) {
                String[] split = str.split("\\|");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!Util.isNullOrNil(split[i2])) {
                        hashSet.add(split[i2]);
                    }
                }
            }
        }
        AppMethodBeat.o(151563);
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ck(int r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 157
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.g.ck(int, java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public static class b implements k<Bundle, Bundle> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(151554);
            Bundle bundle2 = new Bundle();
            Set access$000 = g.access$000();
            StringBuilder sb = new StringBuilder();
            if (access$000 != null && !access$000.isEmpty()) {
                Iterator it = access$000.iterator();
                sb.append((String) it.next());
                while (it.hasNext()) {
                    sb.append("|");
                    sb.append((String) it.next());
                }
                bundle2.putString("wxCodePrefix", sb.toString());
            }
            AppMethodBeat.o(151554);
            return bundle2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements k<Bundle, Bundle> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(151553);
            Bundle bundle2 = new Bundle();
            Set access$100 = g.access$100();
            StringBuilder sb = new StringBuilder();
            if (access$100 != null && !access$100.isEmpty()) {
                Iterator it = access$100.iterator();
                sb.append((String) it.next());
                while (it.hasNext()) {
                    sb.append("|");
                    sb.append((String) it.next());
                }
                bundle2.putString("brandCodePrefix", sb.toString());
            }
            AppMethodBeat.o(151553);
            return bundle2;
        }
    }
}
