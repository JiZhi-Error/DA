package com.tencent.mm.plugin.normsg.d;

import android.app.ActivityManager;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.plugin.normsg.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a implements b.g {
    public static final C1564a<String> AFa;
    private long AFb;
    private long AFc;
    private long AFd;
    private long AFe;
    private long AFf;
    private int AFg;
    private boolean AFh;
    private long AFi;

    /* synthetic */ a(byte b2) {
        this();
    }

    static /* synthetic */ String cB(String str, String str2) {
        AppMethodBeat.i(149040);
        String jg = jg(str, str2);
        AppMethodBeat.o(149040);
        return jg;
    }

    static {
        AppMethodBeat.i(149041);
        C1564a<String> aVar = new C1564a<>((byte) 0);
        AFa = aVar;
        aVar.add("");
        AFa.add(":tools");
        AFa.add(":toolsmp");
        AFa.add(":appbrand0");
        AFa.add(":appbrand1");
        AFa.add(":appbrand2");
        AFa.add(":appbrand3");
        AFa.add(":appbrand4");
        AppMethodBeat.o(149041);
    }

    /* renamed from: com.tencent.mm.plugin.normsg.d.a$a  reason: collision with other inner class name */
    public static final class C1564a<T> extends HashSet<T> {
        private C1564a() {
        }

        /* synthetic */ C1564a(byte b2) {
            this();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(T t) {
            AppMethodBeat.i(149014);
            if (contains(t)) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(149014);
                throw unsupportedOperationException;
            }
            boolean add = super.add(t);
            AppMethodBeat.o(149014);
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            AppMethodBeat.i(149015);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(149015);
            throw unsupportedOperationException;
        }

        public final void clear() {
            AppMethodBeat.i(149016);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(149016);
            throw unsupportedOperationException;
        }

        public final boolean remove(Object obj) {
            AppMethodBeat.i(149017);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(149017);
            throw unsupportedOperationException;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set
        public final boolean removeAll(Collection<?> collection) {
            AppMethodBeat.i(149018);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(149018);
            throw unsupportedOperationException;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        static final a AFj = new a((byte) 0);

        static {
            AppMethodBeat.i(149019);
            AppMethodBeat.o(149019);
        }
    }

    public static a exW() {
        return b.AFj;
    }

    private a() {
        AppMethodBeat.i(149024);
        this.AFb = 0;
        this.AFc = 0;
        this.AFd = 0;
        this.AFe = 0;
        this.AFf = 0;
        this.AFg = 0;
        this.AFh = false;
        this.AFi = 0;
        exZ();
        AppMethodBeat.o(149024);
    }

    public final synchronized void TL(int i2) {
        this.AFg = i2;
    }

    @Override // com.tencent.mm.plugin.normsg.d.b.g
    public final void a(int i2, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        int i3 = 0;
        AppMethodBeat.i(149025);
        String view2 = view != null ? view.toString() : "";
        String TQ = TQ(i2);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = TQ;
        objArr[2] = view2;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        Log.i("MircoMsg.AEDHLP", "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b", objArr);
        if (list != null) {
            i3 = list.size();
        }
        eX(TQ, i3);
        if (c.eyb() && TQ != null && TQ.contains(d.aIJ(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
        AppMethodBeat.o(149025);
    }

    @Override // com.tencent.mm.plugin.normsg.d.b.g
    public final boolean a(int i2, int i3, View view) {
        AppMethodBeat.i(149026);
        String view2 = view != null ? view.toString() : "";
        String TQ = TQ(i3);
        Log.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", Integer.valueOf(i3), TQ, view2, Integer.valueOf(i2));
        i(i2, view);
        I(i2, TQ, view2);
        if (!c.eyb() || TQ == null || !TQ.contains(d.aIJ(">\u0010r\u001bc\u0001xV"))) {
            AppMethodBeat.o(149026);
            return true;
        }
        AppMethodBeat.o(149026);
        return false;
    }

    @Override // com.tencent.mm.plugin.normsg.d.b.g
    public final void onError(Throwable th) {
        AppMethodBeat.i(149027);
        Log.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        n(th);
        AppMethodBeat.o(149027);
    }

    public final synchronized long exX() {
        long j2;
        AppMethodBeat.i(149028);
        j2 = this.AFf;
        exY();
        AppMethodBeat.o(149028);
        return j2;
    }

    private synchronized void exY() {
        AppMethodBeat.i(149029);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.AFe >= 259200000) {
            this.AFf = 0;
            this.AFe = currentTimeMillis;
            cMZ();
        }
        AppMethodBeat.o(149029);
    }

    private synchronized void exZ() {
        DataInputStream dataInputStream;
        Throwable th;
        AppMethodBeat.i(149030);
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(MMApplicationContext.getContext().getCacheDir(), d.aIJ("ãçÜºÈ­Üòù")))));
            try {
                if (((long) dataInputStream.readInt()) != -606158847) {
                    IllegalStateException illegalStateException = new IllegalStateException("bad magic.");
                    AppMethodBeat.o(149030);
                    throw illegalStateException;
                }
                this.AFb = dataInputStream.readLong();
                this.AFc = dataInputStream.readLong();
                this.AFd = dataInputStream.readLong();
                this.AFe = dataInputStream.readLong();
                long readLong = dataInputStream.readLong();
                if (readLong > 0 && this.AFf <= 0) {
                    this.AFf = readLong;
                }
                Util.qualityClose(dataInputStream);
                AppMethodBeat.o(149030);
            } catch (Throwable th2) {
                th = th2;
                try {
                    Log.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.AFb = 0;
                    this.AFc = 0;
                    this.AFd = 0;
                    this.AFe = System.currentTimeMillis();
                    this.AFf = 0;
                    cMZ();
                    Util.qualityClose(dataInputStream);
                    AppMethodBeat.o(149030);
                } catch (Throwable th3) {
                    th = th3;
                    Util.qualityClose(dataInputStream);
                    AppMethodBeat.o(149030);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            Util.qualityClose(dataInputStream);
            AppMethodBeat.o(149030);
            throw th;
        }
    }

    private synchronized void cMZ() {
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(149031);
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(MMApplicationContext.getContext().getCacheDir(), d.aIJ("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeInt(-606158847);
                dataOutputStream.writeLong(this.AFb);
                dataOutputStream.writeLong(this.AFc);
                dataOutputStream.writeLong(this.AFd);
                dataOutputStream.writeLong(this.AFe);
                dataOutputStream.writeLong(this.AFf);
                Util.qualityClose(dataOutputStream);
                AppMethodBeat.o(149031);
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    Log.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure to save rec.", new Object[0]);
                    Util.qualityClose(dataOutputStream);
                    AppMethodBeat.o(149031);
                } catch (Throwable th4) {
                    th = th4;
                    Util.qualityClose(dataOutputStream);
                    AppMethodBeat.o(149031);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream = null;
            Util.qualityClose(dataOutputStream);
            AppMethodBeat.o(149031);
            throw th;
        }
    }

    private synchronized void i(int i2, View view) {
        AppMethodBeat.i(149032);
        if (view == null) {
            AppMethodBeat.o(149032);
        } else if (i2 != 16) {
            AppMethodBeat.o(149032);
        } else {
            synchronized (this) {
                try {
                    if (this.AFg != 0) {
                        if ((view instanceof Button) && view.getId() == this.AFg) {
                            this.AFf++;
                            cMZ();
                        }
                        AppMethodBeat.o(149032);
                    }
                } finally {
                    AppMethodBeat.o(149032);
                }
            }
        }
    }

    private synchronized void eX(String str, int i2) {
        AppMethodBeat.i(149033);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.AFb > Util.MILLSECONDS_OF_DAY) {
            h.INSTANCE.e("Normsg_AED", "findview, pkg: " + str + ", res_count: " + i2, null);
            this.AFb = currentTimeMillis;
            cMZ();
        }
        if (g.isMIUI() && c.eyd()) {
            eya();
        }
        AppMethodBeat.o(149033);
    }

    private synchronized void I(int i2, String str, String str2) {
        AppMethodBeat.i(149034);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.AFc > Util.MILLSECONDS_OF_DAY) {
            h.INSTANCE.e("Normsg_AED", "action: " + i2 + ", pkg: " + str + ", view: " + str2, null);
            this.AFc = currentTimeMillis;
            cMZ();
        }
        if (g.isMIUI() && c.eyd()) {
            eya();
        }
        AppMethodBeat.o(149034);
    }

    private synchronized void eya() {
        AppMethodBeat.i(149035);
        if (!this.AFh) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.AFi < 2000) {
                AppMethodBeat.o(149035);
            } else {
                this.AFi = currentTimeMillis;
                this.AFh = true;
                d.INSTANCE.Xj(-2147483647);
            }
        }
        AppMethodBeat.o(149035);
    }

    public final synchronized void n(Throwable th) {
        PrintWriter printWriter;
        Throwable th2;
        PrintWriter printWriter2;
        AppMethodBeat.i(149036);
        if (th == null) {
            AppMethodBeat.o(149036);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.AFd > Util.MILLSECONDS_OF_DAY) {
                StringWriter stringWriter = new StringWriter();
                try {
                    printWriter2 = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter2);
                        Util.qualityClose(printWriter2);
                    } catch (Throwable th3) {
                        th2 = th3;
                        printWriter = printWriter2;
                        Util.qualityClose(printWriter);
                        AppMethodBeat.o(149036);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    printWriter = null;
                    Util.qualityClose(printWriter);
                    AppMethodBeat.o(149036);
                    throw th2;
                }
                h.INSTANCE.e("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                this.AFd = currentTimeMillis;
                cMZ();
            }
            AppMethodBeat.o(149036);
        }
    }

    private static String TQ(int i2) {
        Throwable th;
        BufferedReader bufferedReader;
        Throwable th2;
        AppMethodBeat.i(149037);
        ActivityManager activityManager = (ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (activityManager == null) {
            AppMethodBeat.o(149037);
            return "";
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i2) {
                        String str = runningAppProcessInfo.processName;
                        AppMethodBeat.o(149037);
                        return str;
                    }
                }
            }
        } catch (Throwable th3) {
            Log.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i2) {
                        String str2 = runningServiceInfo.process;
                        AppMethodBeat.o(149037);
                        return str2;
                    }
                }
            }
        } catch (Throwable th4) {
            Log.printErrStackTrace("MircoMsg.AEDHLP", th4, "[tomys] failure on step2.", new Object[0]);
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, d.aIJ("ÃìîâÍè£À­É¥Ì¢Ç"), Integer.valueOf(i2))));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(149037);
                    return trim;
                }
                Util.qualityClose(bufferedReader);
                AppMethodBeat.o(149037);
                return "";
            } catch (Throwable th5) {
                th2 = th5;
                try {
                    Log.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure on step3.", new Object[0]);
                    Util.qualityClose(bufferedReader);
                    AppMethodBeat.o(149037);
                    return "";
                } catch (Throwable th6) {
                    th = th6;
                    bufferedReader2 = bufferedReader;
                    Util.qualityClose(bufferedReader2);
                    AppMethodBeat.o(149037);
                    throw th;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            Util.qualityClose(bufferedReader2);
            AppMethodBeat.o(149037);
            throw th;
        }
    }

    public static String gj(String str) {
        AppMethodBeat.i(149038);
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            String substring = str.substring(indexOf);
            AppMethodBeat.o(149038);
            return substring;
        }
        AppMethodBeat.o(149038);
        return "";
    }

    public static final class c {
        private c() {
        }

        public static boolean isEnabled() {
            AppMethodBeat.i(149020);
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(d.aIJ("Úà¯ßºÔ"));
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb2, sb.toString()))) {
                    AppMethodBeat.o(149020);
                    return true;
                }
                AppMethodBeat.o(149020);
                return false;
            } catch (Throwable th) {
                String sb3 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb3, sb.toString()))) {
                    AppMethodBeat.o(149020);
                    return true;
                }
                AppMethodBeat.o(149020);
                return false;
            }
        }

        static boolean eyb() {
            AppMethodBeat.i(149021);
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(d.aIJ("Þä¦Ê¡ã¡"));
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb2, sb.toString()))) {
                    AppMethodBeat.o(149021);
                    return true;
                }
                AppMethodBeat.o(149021);
                return false;
            } catch (Throwable th) {
                String sb3 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb3, sb.toString()))) {
                    AppMethodBeat.o(149021);
                    return true;
                }
                AppMethodBeat.o(149021);
                return false;
            }
        }

        public static int eyc() {
            int hashCode;
            int i2;
            Throwable th;
            int i3;
            Throwable th2;
            AppMethodBeat.i(149022);
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(d.aIJ("S\u0000D\u000fF(\\\tK"));
                int hashCode2 = (c.class.hashCode() >>> 31) | 1;
                String sb2 = sb.toString();
                if (hashCode2 != 0) {
                    try {
                        i3 = ((c.class.hashCode() >>> 31) | 1) ^ 1;
                        try {
                            sb.delete(0, sb.length());
                            sb.append(i3);
                            int i4 = Util.getInt(a.cB(sb2, sb.toString()), i3);
                            AppMethodBeat.o(149022);
                            return i4;
                        } catch (Throwable th3) {
                            th2 = th3;
                            sb.append(i3);
                            AppMethodBeat.o(149022);
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        i3 = hashCode2;
                        sb.append(i3);
                        AppMethodBeat.o(149022);
                        throw th2;
                    }
                } else {
                    AppMethodBeat.o(149022);
                    return hashCode2;
                }
            } catch (Throwable th5) {
                th = th5;
                sb.append(i2);
                AppMethodBeat.o(149022);
                throw th;
            }
        }

        static boolean eyd() {
            AppMethodBeat.i(149023);
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(d.aIJ("Àú¿ÑÄ"));
                String sb2 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb2, sb.toString()))) {
                    AppMethodBeat.o(149023);
                    return true;
                }
                AppMethodBeat.o(149023);
                return false;
            } catch (Throwable th) {
                String sb3 = sb.toString();
                sb.delete(0, sb.length());
                sb.append(((c.class.hashCode() >>> 31) | 1) ^ 1);
                if (!sb.toString().equals(a.cB(sb3, sb.toString()))) {
                    AppMethodBeat.o(149023);
                    return true;
                }
                AppMethodBeat.o(149023);
                return false;
            }
        }
    }

    private static String jg(String str, String str2) {
        AppMethodBeat.i(149039);
        try {
            com.tencent.mm.kernel.g.aAf().azk();
            try {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = a.C0356a.hnM;
                com.tencent.mm.storage.c Fu = com.tencent.mm.ipcinvoker.wx_extension.a.a.Fu("100373");
                if (Fu == null || !Fu.isValid()) {
                    Log.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                    AppMethodBeat.o(149039);
                    return str2;
                }
                Map<String, String> gzz = Fu.gzz();
                if (gzz == null) {
                    Log.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                    AppMethodBeat.o(149039);
                    return str2;
                }
                String str3 = gzz.get(str);
                if (str3 == null || str3.length() <= 0) {
                    AppMethodBeat.o(149039);
                    return str2;
                }
                AppMethodBeat.o(149039);
                return str3;
            } catch (com.tencent.mm.model.b e2) {
                Log.printErrStackTrace("MircoMsg.AEDHLP", e2, "check point 1-1, explained by src code.", new Object[0]);
                AppMethodBeat.o(149039);
                return str2;
            }
        } catch (com.tencent.mm.model.b e3) {
            Log.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
            AppMethodBeat.o(149039);
            return str2;
        }
    }
}
