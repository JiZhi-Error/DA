package com.tencent.mm.compatible.deviceinfo;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.v;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.xwalk.core.XWalkEnvironment;

public final class q {
    private static final b gIf = new b(new d("a") {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void ds(boolean z) {
            AppMethodBeat.i(155686);
            if (z) {
                r.ov(2);
            }
            AppMethodBeat.o(155686);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void aoQ() {
            AppMethodBeat.i(155685);
            r.ov(4);
            AppMethodBeat.o(155685);
        }
    }) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass5 */
        final a gIo = new c(CdnLogic.kAppTypeFestivalVideo);

        {
            AppMethodBeat.i(155692);
            AppMethodBeat.o(155692);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155693);
            String DU = this.gIo.DU("1234567890ABCDEF");
            if (!"1234567890ABCDEF".equals(DU)) {
                r.ov(0);
                AppMethodBeat.o(155693);
                return DU;
            }
            AppMethodBeat.o(155693);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final void aoS() {
            AppMethodBeat.i(155694);
            r.ov(3);
            AppMethodBeat.o(155694);
        }
    };
    private static final b gIg = new b(new d("c")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass6 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155695);
            Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSerial, %s", Util.getStack());
            if (Build.VERSION.SDK_INT < 9) {
                AppMethodBeat.o(155695);
                return null;
            } else if (Build.VERSION.SDK_INT < 26) {
                String str = Build.SERIAL;
                AppMethodBeat.o(155695);
                return str;
            } else {
                try {
                    String serial = Build.getSerial();
                    AppMethodBeat.o(155695);
                    return serial;
                } catch (Throwable th) {
                    AppMethodBeat.o(155695);
                    return null;
                }
            }
        }
    };
    private static final b gIh = new b(new d("d")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass7 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155696);
            AppMethodBeat.o(155696);
            return "02:00:00:00:00:00";
        }
    };
    private static final b gIi = new b(new d("e")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass8 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155697);
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
                AppMethodBeat.o(155697);
                return null;
            }
            String address = defaultAdapter.getAddress();
            AppMethodBeat.o(155697);
            return address;
        }
    };
    private static final b gIj = new b(new d("f") {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass9 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void ds(boolean z) {
            AppMethodBeat.i(155699);
            if (z) {
                r.ov(12);
            }
            AppMethodBeat.o(155699);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void aoQ() {
            AppMethodBeat.i(155698);
            r.ov(14);
            AppMethodBeat.o(155698);
        }
    }) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass10 */
        final a gIp = new c(259);

        {
            AppMethodBeat.i(155700);
            AppMethodBeat.o(155700);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155701);
            String DU = this.gIp.DU(null);
            if (DU != null) {
                r.ov(10);
                AppMethodBeat.o(155701);
                return DU;
            }
            String str = Build.MANUFACTURER + Build.MODEL + n.aor();
            AppMethodBeat.o(155701);
            return str;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final void aoS() {
            AppMethodBeat.i(155702);
            r.ov(13);
            AppMethodBeat.o(155702);
        }
    };
    private static final b gIk = new b(new d("g")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass11 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155703);
            try {
                String string = Settings.Secure.getString(MMApplicationContext.getContext().getContentResolver(), "android_id");
                AppMethodBeat.o(155703);
                return string;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "[-] Fail to get android id.", new Object[0]);
                AppMethodBeat.o(155703);
                return "";
            }
        }
    };
    private static final b gIl = new b(new d("h")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass12 */
        final c gIq = new c(256);

        {
            AppMethodBeat.i(155704);
            AppMethodBeat.o(155704);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            boolean z;
            AppMethodBeat.i(155705);
            StringBuilder sb = new StringBuilder();
            sb.append(q.getAndroidId());
            String DU = this.gIq.DU(null);
            if (DU == null) {
                DU = q.dr(false);
                Log.w("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", DU);
                z = false;
            } else {
                z = true;
            }
            Log.i("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", DU, Boolean.valueOf(z));
            if (z) {
                sb.append(DU);
            } else if (!TextUtils.isEmpty(DU)) {
                sb.append(("A" + DU + "123456789ABCDEF").substring(0, 15));
            } else {
                Random random = new Random();
                random.setSeed(System.currentTimeMillis());
                sb.append("A");
                for (int i2 = 0; i2 < 15; i2++) {
                    sb.append((char) (random.nextInt(25) + 65));
                }
                if (!this.gIq.gIv.gHO) {
                    r.ov(28);
                }
            }
            sb.append(q.aoF());
            String sb2 = sb.toString();
            Log.i("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", sb2);
            String str = "A" + g.getMessageDigest(sb2.getBytes()).substring(0, 15);
            AppMethodBeat.o(155705);
            return str;
        }
    };
    private static final b gIm = new b(new d("i")) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155687);
            if (Build.VERSION.SDK_INT < 14) {
                String str = Build.RADIO;
                AppMethodBeat.o(155687);
                return str;
            }
            String radioVersion = Build.getRadioVersion();
            AppMethodBeat.o(155687);
            return radioVersion;
        }
    };
    private static final b gIn = new b(new d("j") {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass3 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void ds(boolean z) {
            AppMethodBeat.i(155689);
            if (z) {
                r.ov(7);
            }
            AppMethodBeat.o(155689);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.d
        public final void aoQ() {
            AppMethodBeat.i(155688);
            r.ov(9);
            AppMethodBeat.o(155688);
        }
    }) {
        /* class com.tencent.mm.compatible.deviceinfo.q.AnonymousClass4 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final String aoR() {
            AppMethodBeat.i(155690);
            StringBuilder sb = new StringBuilder();
            sb.append(q.getAndroidId()).append('#').append(q.aoF()).append('#').append(System.currentTimeMillis()).append('#').append(SystemClock.elapsedRealtimeNanos());
            String uuid = UUID.nameUUIDFromBytes(sb.toString().getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET))).toString();
            AppMethodBeat.o(155690);
            return uuid;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.compatible.deviceinfo.q.b
        public final void aoS() {
            AppMethodBeat.i(155691);
            r.ov(8);
            AppMethodBeat.o(155691);
        }
    };

    static {
        AppMethodBeat.i(155741);
        AppMethodBeat.o(155741);
    }

    public static void aoy() {
        AppMethodBeat.i(155719);
        gIf.get();
        gIg.get();
        gIn.get();
        AppMethodBeat.o(155719);
    }

    public static String dr(boolean z) {
        AppMethodBeat.i(155720);
        String str = gIf.get();
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(155720);
            return str;
        } else if (z) {
            AppMethodBeat.o(155720);
            return "1234567890ABCDEF";
        } else {
            AppMethodBeat.o(155720);
            return "";
        }
    }

    public static String aoz() {
        AppMethodBeat.i(155721);
        String dr = dr(true);
        AppMethodBeat.o(155721);
        return dr;
    }

    public static String aoA() {
        AppMethodBeat.i(155722);
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        try {
            Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSubscriberId, %s", Util.getStack());
            String nullAsNil = Util.nullAsNil(telephonyManager.getSubscriberId());
            AppMethodBeat.o(155722);
            return nullAsNil;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "getIMSI", new Object[0]);
            AppMethodBeat.o(155722);
            return "";
        }
    }

    public static String aoB() {
        AppMethodBeat.i(155723);
        String nullAsNil = Util.nullAsNil(gIg.get());
        AppMethodBeat.o(155723);
        return nullAsNil;
    }

    @SuppressLint({"MissingPermission"})
    public static String aoC() {
        AppMethodBeat.i(155724);
        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            try {
                Log.d("MicroMsg.DeviceInfo", "READ_PHONE_STATE.getSimSerialNumber", Util.getStack());
                String nullAsNil = Util.nullAsNil(telephonyManager.getSimSerialNumber());
                AppMethodBeat.o(155724);
                return nullAsNil;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "getICCID", new Object[0]);
                AppMethodBeat.o(155724);
                return "";
            }
        } else {
            AppMethodBeat.o(155724);
            return "";
        }
    }

    public static String ct(Context context) {
        AppMethodBeat.i(155725);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String nullAsNil = Util.nullAsNil(telephonyManager.getSimOperatorName());
                AppMethodBeat.o(155725);
                return nullAsNil;
            }
            AppMethodBeat.o(155725);
            return "";
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "getMobileSPType", new Object[0]);
            AppMethodBeat.o(155725);
            return "";
        }
    }

    public static String getSimCountryIso() {
        AppMethodBeat.i(155726);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
            if (telephonyManager != null) {
                String nullAsNil = Util.nullAsNil(telephonyManager.getSimCountryIso());
                AppMethodBeat.o(155726);
                return nullAsNil;
            }
            AppMethodBeat.o(155726);
            return "";
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "getSimCountryIso", new Object[0]);
            AppMethodBeat.o(155726);
            return "";
        }
    }

    public static String aoD() {
        AppMethodBeat.i(155727);
        String nullAsNil = Util.nullAsNil(gIh.get());
        AppMethodBeat.o(155727);
        return nullAsNil;
    }

    public static String aoE() {
        AppMethodBeat.i(155728);
        String nullAsNil = Util.nullAsNil(gIi.get());
        AppMethodBeat.o(155728);
        return nullAsNil;
    }

    public static String aoF() {
        AppMethodBeat.i(155729);
        String nullAsNil = Util.nullAsNil(gIj.get());
        AppMethodBeat.o(155729);
        return nullAsNil;
    }

    public static String getAndroidId() {
        AppMethodBeat.i(155730);
        String nullAsNil = Util.nullAsNil(gIk.get());
        AppMethodBeat.o(155730);
        return nullAsNil;
    }

    public static String aoG() {
        AppMethodBeat.i(155731);
        String nullAsNil = Util.nullAsNil(gIl.get());
        AppMethodBeat.o(155731);
        return nullAsNil;
    }

    public static void aoH() {
        AppMethodBeat.i(155732);
        Log.w("MicroMsg.DeviceInfo", "[!] MMGUID refreshed, old: %s, new: %s", gIl.get(), gIl.aoU());
        AppMethodBeat.o(155732);
    }

    public static boolean aoI() {
        return true;
    }

    public static String aoJ() {
        AppMethodBeat.i(155733);
        String nullAsNil = Util.nullAsNil(gIn.get());
        AppMethodBeat.o(155733);
        return nullAsNil;
    }

    public static String aoK() {
        AppMethodBeat.i(155734);
        String nullAsNil = Util.nullAsNil(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aoK());
        AppMethodBeat.o(155734);
        return nullAsNil;
    }

    public static String aoL() {
        AppMethodBeat.i(155735);
        String str = "android-" + Build.MODEL + "-" + Build.VERSION.SDK_INT;
        AppMethodBeat.o(155735);
        return str;
    }

    public static String aoM() {
        AppMethodBeat.i(155736);
        String nullAsNil = Util.nullAsNil(gIm.get());
        AppMethodBeat.o(155736);
        return nullAsNil;
    }

    public static String[] aoN() {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        String[] strArr;
        AppMethodBeat.i(155737);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/cpuinfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            try {
                StringBuilder sb = new StringBuilder();
                String[] split = bufferedReader.readLine().split("\\s+");
                for (int i2 = 2; i2 < split.length; i2++) {
                    sb.append(split[i2]).append(' ');
                }
                strArr = new String[]{sb.toString(), bufferedReader.readLine().split("\\s+")[2]};
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(155737);
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    Log.printErrStackTrace("MicroMsg.DeviceInfo", th2, "getFirstCPUCoreDescs() failed.", new Object[0]);
                    strArr = new String[]{"", AppEventsConstants.EVENT_PARAM_VALUE_NO};
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155737);
                    return strArr;
                } catch (Throwable th4) {
                    th = th4;
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(155737);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155737);
            throw th;
        }
        return strArr;
    }

    public static Map<String, String> aoO() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(155738);
        HashMap hashMap = new HashMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(s.openRead("/proc/cpuinfo"), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!readLine.trim().isEmpty()) {
                        String[] split = readLine.split(":");
                        if (split.length > 1) {
                            hashMap.put(split[0].trim().toLowerCase(), split[1].trim());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        Log.printErrStackTrace("MicroMsg.DeviceInfo", th, "getCPUInfoMap() failed.", new Object[0]);
                        hashMap.clear();
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(155738);
                        return hashMap;
                    } catch (Throwable th3) {
                        th = th3;
                        Util.qualityClose(bufferedReader);
                        AppMethodBeat.o(155738);
                        throw th;
                    }
                }
            }
            Util.qualityClose(bufferedReader);
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Util.qualityClose(bufferedReader);
            AppMethodBeat.o(155738);
            throw th;
        }
        AppMethodBeat.o(155738);
        return hashMap;
    }

    public static int aoP() {
        AppMethodBeat.i(155739);
        try {
            Pattern compile = Pattern.compile("cpu[0-9]+");
            int i2 = 0;
            for (o oVar : new o("/sys/devices/system/cpu").het()) {
                if (compile.matcher(oVar.getName()).matches()) {
                    i2++;
                }
            }
            AppMethodBeat.o(155739);
            return i2;
        } catch (Throwable th) {
            AppMethodBeat.o(155739);
            return 1;
        }
    }

    public static boolean is64BitRuntime() {
        AppMethodBeat.i(155740);
        String str = Build.CPU_ABI;
        if (XWalkEnvironment.RUNTIME_ABI_ARM64_STR.equalsIgnoreCase(str) || "x86_64".equalsIgnoreCase(str) || "mips64".equalsIgnoreCase(str)) {
            AppMethodBeat.o(155740);
            return true;
        }
        AppMethodBeat.o(155740);
        return false;
    }

    static class e {
        private volatile LocalServerSocket gIC = null;
        private volatile int gID = 0;
        private final String mName;

        e(String str) {
            AppMethodBeat.i(155715);
            if (TextUtils.isEmpty(str)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("lockName is null or empty.");
                AppMethodBeat.o(155715);
                throw illegalArgumentException;
            }
            synchronized (this) {
                try {
                    this.mName = str;
                } finally {
                    AppMethodBeat.o(155715);
                }
            }
        }

        private synchronized boolean tryLock() {
            boolean z = true;
            synchronized (this) {
                AppMethodBeat.i(155716);
                if (this.gIC == null) {
                    try {
                        this.gIC = new LocalServerSocket(this.mName);
                        this.gID++;
                        AppMethodBeat.o(155716);
                    } catch (Throwable th) {
                        this.gIC = null;
                        z = false;
                        AppMethodBeat.o(155716);
                    }
                } else {
                    this.gID++;
                    AppMethodBeat.o(155716);
                }
            }
            return z;
        }

        /* access modifiers changed from: package-private */
        public final synchronized void lock() {
            AppMethodBeat.i(155717);
            while (!tryLock()) {
                try {
                    Thread.sleep(10);
                } catch (Throwable th) {
                }
            }
            AppMethodBeat.o(155717);
        }

        /* access modifiers changed from: package-private */
        public final synchronized void unlock() {
            AppMethodBeat.i(155718);
            if (this.gID > 0) {
                this.gID--;
            }
            if (this.gID != 0 || this.gIC == null) {
                AppMethodBeat.o(155718);
            } else {
                try {
                    this.gIC.close();
                } catch (Throwable th) {
                } finally {
                    this.gIC = null;
                    AppMethodBeat.o(155718);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class a {
        private boolean gIr;
        private boolean gIs;
        private final byte[] gIt;
        private String mValue;

        /* access modifiers changed from: protected */
        public abstract void DW(String str);

        /* access modifiers changed from: protected */
        public abstract String aoT();

        private a() {
            this.gIr = false;
            this.gIs = false;
            this.mValue = null;
            this.gIt = new byte[0];
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final String DU(String str) {
            synchronized (this.gIt) {
                if (this.gIr) {
                    str = this.mValue;
                } else {
                    this.mValue = aoT();
                    if (this.mValue != null) {
                        this.gIr = true;
                        str = this.mValue;
                    }
                }
            }
            return str;
        }

        /* access modifiers changed from: package-private */
        public final void DV(String str) {
            synchronized (this.gIt) {
                if (!this.gIr || !TextUtils.equals(this.mValue, str)) {
                    this.mValue = str;
                    this.gIr = true;
                    this.gIs = true;
                    DW(str);
                }
            }
        }
    }

    static class c extends a {
        final l gIv = l.aol();
        private final int mType;

        c(int i2) {
            super((byte) 0);
            AppMethodBeat.i(155706);
            this.mType = i2;
            AppMethodBeat.o(155706);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.compatible.deviceinfo.q.a
        public final String aoT() {
            AppMethodBeat.i(155707);
            String str = (String) this.gIv.get(this.mType);
            if (str == null && !this.gIv.gHO) {
                switch (this.mType) {
                    case 256:
                        r.ov(27);
                        break;
                    case CdnLogic.kAppTypeFestivalVideo:
                        r.ov(25);
                        break;
                    case 259:
                        r.ov(26);
                        break;
                }
            }
            AppMethodBeat.o(155707);
            return str;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.compatible.deviceinfo.q.a
        public final void DW(String str) {
            AppMethodBeat.i(155708);
            this.gIv.set(this.mType, str);
            AppMethodBeat.o(155708);
        }
    }

    static class d extends a {
        private static final Set<String> gIw = new HashSet();
        private final e gIA;
        private final boolean gIB;
        private final String gIx;
        private final int gIy;
        private final o gIz;

        static {
            AppMethodBeat.i(155714);
            AppMethodBeat.o(155714);
        }

        d(String str) {
            super((byte) 0);
            AppMethodBeat.i(155709);
            if (str == null || str.isEmpty()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("id is null or empty.");
                AppMethodBeat.o(155709);
                throw illegalArgumentException;
            } else if (gIw.contains(str)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("name: " + str + " is duplicated.");
                AppMethodBeat.o(155709);
                throw illegalArgumentException2;
            } else {
                gIw.add(str);
                this.gIx = UUID.nameUUIDFromBytes(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET))).toString();
                this.gIy = 5;
                this.gIA = new e(str);
                synchronized (this) {
                    try {
                        this.gIA.lock();
                        this.gIz = new o(MMApplicationContext.getContext().getFilesDir().getParentFile(), ".auth_cache/" + this.gIx);
                        if (this.gIz.exists()) {
                            this.gIB = false;
                        } else {
                            this.gIB = true;
                            if (!this.gIz.mkdirs()) {
                                Log.e("MicroMsg.DeviceInfo", "[-] Fail to make base dir: %s", aa.z(this.gIz.her()));
                            }
                        }
                        try {
                            this.gIA.unlock();
                        } finally {
                            AppMethodBeat.o(155709);
                        }
                    } catch (Throwable th) {
                        this.gIA.unlock();
                        AppMethodBeat.o(155709);
                        throw th;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void aoQ() {
        }

        /* access modifiers changed from: package-private */
        public void ds(boolean z) {
        }

        @Override // com.tencent.mm.compatible.deviceinfo.q.a
        public final synchronized String aoT() {
            String str;
            boolean z;
            AppMethodBeat.i(155710);
            try {
                this.gIA.lock();
                if (!this.gIz.exists()) {
                    Log.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, base cache will return defValue.");
                    this.gIA.unlock();
                    AppMethodBeat.o(155710);
                    str = null;
                } else {
                    int i2 = this.gIy;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i3 < this.gIy) {
                            o oVar = new o(this.gIz, String.valueOf(i3));
                            if (!oVar.exists()) {
                                i2--;
                            } else {
                                String c2 = c(oVar);
                                if (c2 != null) {
                                    this.gIA.unlock();
                                    AppMethodBeat.o(155710);
                                    str = c2;
                                    break;
                                }
                                i4++;
                            }
                            i3++;
                        } else {
                            if (i4 > 0) {
                                if (i4 == i2) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                ds(z);
                            }
                            Log.w("MicroMsg.DeviceInfo", "[!] Cache missed, base cache will return defValue.");
                            this.gIA.unlock();
                            AppMethodBeat.o(155710);
                            str = null;
                        }
                    }
                }
            } catch (Throwable th) {
                this.gIA.unlock();
                AppMethodBeat.o(155710);
                throw th;
            }
            return str;
        }

        @Override // com.tencent.mm.compatible.deviceinfo.q.a
        public final synchronized void DW(String str) {
            AppMethodBeat.i(155711);
            try {
                this.gIA.lock();
                if (!this.gIz.exists()) {
                    Log.e("MicroMsg.DeviceInfo", "[-] Base dir does not exist, skip rest logic.");
                    aoQ();
                } else {
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.gIy; i3++) {
                        o oVar = new o(this.gIz, String.valueOf(i3));
                        if (oVar.isDirectory()) {
                            Log.w("MicroMsg.DeviceInfo", "[!] Cache file %s is occupied by a directory, try to delete it first.");
                            oVar.delete();
                        }
                        if (!c(oVar, str)) {
                            i2++;
                        }
                    }
                    if (i2 == this.gIy) {
                        aoQ();
                    }
                    this.gIA.unlock();
                    AppMethodBeat.o(155711);
                }
            } finally {
                this.gIA.unlock();
                AppMethodBeat.o(155711);
            }
        }

        private static String c(o oVar) {
            BufferedReader bufferedReader;
            u uVar;
            Throwable th;
            Throwable th2;
            AppMethodBeat.i(175896);
            try {
                uVar = new u(oVar);
                try {
                    bufferedReader = new BufferedReader(uVar);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    Util.qualityClose(bufferedReader);
                    Util.qualityClose(uVar);
                    AppMethodBeat.o(175896);
                    throw th;
                }
                try {
                    String readLine = bufferedReader.readLine();
                    int lastIndexOf = readLine.lastIndexOf(44);
                    if (lastIndexOf < 0) {
                        Log.e("MicroMsg.DeviceInfo", "[-] Illegal cached data.");
                        Util.qualityClose(bufferedReader);
                        Util.qualityClose(uVar);
                        AppMethodBeat.o(175896);
                        return null;
                    }
                    String substring = readLine.substring(0, lastIndexOf);
                    String substring2 = readLine.substring(lastIndexOf + 1);
                    CRC32 crc32 = new CRC32();
                    crc32.update(substring.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                    if (crc32.getValue() != Long.parseLong(substring2)) {
                        Log.e("MicroMsg.DeviceInfo", "[-] crc32 of data mismatch.");
                        Util.qualityClose(bufferedReader);
                        Util.qualityClose(uVar);
                        AppMethodBeat.o(175896);
                        return null;
                    }
                    Util.qualityClose(bufferedReader);
                    Util.qualityClose(uVar);
                    AppMethodBeat.o(175896);
                    return substring;
                } catch (Throwable th4) {
                    th2 = th4;
                    Log.printErrStackTrace("MicroMsg.DeviceInfo", th2, "[-] Exception occurred when read from cache file.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    Util.qualityClose(uVar);
                    AppMethodBeat.o(175896);
                    return null;
                }
            } catch (Throwable th5) {
                th = th5;
                uVar = null;
                bufferedReader = null;
                Util.qualityClose(bufferedReader);
                Util.qualityClose(uVar);
                AppMethodBeat.o(175896);
                throw th;
            }
        }

        private static boolean c(o oVar, String str) {
            Throwable th;
            Throwable th2;
            PrintWriter printWriter = null;
            AppMethodBeat.i(175897);
            if (str == null) {
                try {
                    if (oVar.exists()) {
                        new PrintWriter(new v(oVar)).close();
                    } else {
                        Util.qualityClose(null);
                        AppMethodBeat.o(175897);
                        return true;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        Log.printErrStackTrace("MicroMsg.DeviceInfo", th2, "[-] Exception occurred when store value to file: %s", aa.z(oVar.her()));
                        Util.qualityClose(printWriter);
                        AppMethodBeat.o(175897);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        Util.qualityClose(printWriter);
                        AppMethodBeat.o(175897);
                        throw th;
                    }
                }
            }
            PrintWriter printWriter2 = new PrintWriter(new v(oVar));
            try {
                CRC32 crc32 = new CRC32();
                crc32.update(str.getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)));
                printWriter2.print(str + "," + crc32.getValue());
                Util.qualityClose(printWriter2);
                AppMethodBeat.o(175897);
                return true;
            } catch (Throwable th5) {
                th = th5;
                printWriter = printWriter2;
                Util.qualityClose(printWriter);
                AppMethodBeat.o(175897);
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class b {
        private final a gIu;

        /* access modifiers changed from: package-private */
        public abstract String aoR();

        b(a aVar) {
            this.gIu = aVar;
        }

        /* access modifiers changed from: package-private */
        public void aoS() {
        }

        /* access modifiers changed from: package-private */
        public final String get() {
            String DU = this.gIu.DU(null);
            if (!TextUtils.isEmpty(DU)) {
                return DU;
            }
            aoS();
            return aoU();
        }

        /* access modifiers changed from: package-private */
        public final String aoU() {
            String aoR = aoR();
            if (!TextUtils.isEmpty(aoR)) {
                this.gIu.DV(aoR);
            }
            return aoR;
        }
    }
}
