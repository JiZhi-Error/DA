package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.stubs.logger.Log;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class g implements Handler.Callback {
    private static volatile b Vmi = null;
    private static volatile boolean Vmj = true;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context sContext = null;
    l Vmk;
    private int Vml;
    private e Vmm;
    final l Vmn;
    final File Vmo;
    final HandlerThread Vmp;
    private final c Vmq;
    private final Handler Vmr;
    private volatile long Vms;
    private volatile long Vmt;
    private volatile boolean Vmu;
    volatile d Vmv;
    volatile boolean Vmw;
    private volatile BroadcastReceiver Vmx;
    final Context mContext;
    final Object mLock;

    public interface b {
        Key Z(String str, Map<String, String> map);
    }

    public interface d {
        void bh(boolean z, boolean z2);

        void hdV();
    }

    /* synthetic */ g(byte b2) {
        this();
    }

    final class c extends BroadcastReceiver {
        private CancellationSignal NHn;
        private boolean cSX;
        private boolean pPV;

        private c() {
        }

        /* synthetic */ c(g gVar, byte b2) {
            this();
        }

        private void hee() {
            AppMethodBeat.i(187654);
            Log.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.cSX + ", interactive = " + this.pPV);
            if (!this.cSX || this.pPV || this.NHn != null) {
                if ((!this.cSX || this.pPV) && this.NHn != null) {
                    g.this.Vmr.removeMessages(2);
                    this.NHn.cancel();
                    this.NHn = null;
                    Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
                }
                AppMethodBeat.o(187654);
                return;
            }
            long j2 = g.this.Vms;
            if (j2 < 0) {
                AppMethodBeat.o(187654);
                return;
            }
            this.NHn = new CancellationSignal();
            g.this.Vmr.sendMessageDelayed(Message.obtain(g.this.Vmr, 2, this.NHn), j2);
            Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + (j2 / 1000) + " seconds.");
            AppMethodBeat.o(187654);
        }

        /* access modifiers changed from: package-private */
        public final void kM(Context context) {
            AppMethodBeat.i(187655);
            this.pPV = ((PowerManager) context.getSystemService("power")).isScreenOn();
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.cSX = intExtra == 2 || intExtra == 5;
            }
            hee();
            AppMethodBeat.o(187655);
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(13114);
            String action = intent.getAction();
            if (action == null) {
                AppMethodBeat.o(13114);
                return;
            }
            char c2 = 65535;
            switch (action.hashCode()) {
                case -2128145023:
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1454123155:
                    if (action.equals("android.intent.action.SCREEN_ON")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    this.pPV = true;
                    break;
                case 1:
                    this.pPV = false;
                    break;
                case 2:
                    this.cSX = true;
                    break;
                case 3:
                    this.cSX = false;
                    break;
            }
            hee();
            AppMethodBeat.o(13114);
        }
    }

    static final class f {
        @SuppressLint({"StaticFieldLeak"})
        static final g Rcm;

        static {
            AppMethodBeat.i(13116);
            g gVar = new g((byte) 0);
            Rcm = gVar;
            g.c(gVar);
            AppMethodBeat.o(13116);
        }
    }

    public static g hYQ() {
        return f.Rcm;
    }

    public static void setContext(Context context) {
        AppMethodBeat.i(13117);
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        sContext = context;
        AppMethodBeat.o(13117);
    }

    public static void a(b bVar) {
        Vmi = bVar;
    }

    static b hYR() {
        return Vmi;
    }

    public static void FL(boolean z) {
        Vmj = z;
    }

    public static final class e {
        final FileSystem.b Rcl;
        final int bpo;
        final String path;

        /* synthetic */ e(FileSystem.b bVar, String str, int i2, byte b2) {
            this(bVar, str, i2);
        }

        private e(FileSystem.b bVar, String str, int i2) {
            this.Rcl = bVar;
            this.path = str;
            this.bpo = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean valid() {
            return this.Rcl != null;
        }

        public final String toString() {
            AppMethodBeat.i(13115);
            if (!valid()) {
                AppMethodBeat.o(13115);
                return "[INVALID]";
            }
            String str = this.path + " -> " + this.Rcl.toString();
            AppMethodBeat.o(13115);
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r1 = r0.boV(r6.getScheme());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r1 != null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(13118);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        r1 = r1.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r1 != null) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(13118);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r7 = new com.tencent.mm.vfs.g.e((com.tencent.mm.vfs.FileSystem.b) r1.first, (java.lang.String) r1.second, r2, (byte) 0);
        com.tencent.matrix.trace.core.AppMethodBeat.o(13118);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.vfs.g.e a(android.net.Uri r6, com.tencent.mm.vfs.g.e r7) {
        /*
            r5 = this;
            r4 = 13118(0x333e, float:1.8382E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.Object r1 = r5.mLock
            monitor-enter(r1)
            if (r7 == 0) goto L_0x0015
            int r0 = r7.bpo     // Catch:{ all -> 0x002a }
            int r2 = r5.Vml     // Catch:{ all -> 0x002a }
            if (r0 != r2) goto L_0x0015
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0014:
            return r7
        L_0x0015:
            com.tencent.mm.vfs.l r0 = r5.Vmk
            int r2 = r5.Vml
            com.tencent.mm.vfs.g$e r7 = r5.Vmm
            monitor-exit(r1)
            java.lang.String r1 = r6.getScheme()
            com.tencent.mm.vfs.SchemeResolver$a r1 = r0.boV(r1)
            if (r1 != 0) goto L_0x0030
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0014
        L_0x002a:
            r0 = move-exception
            monitor-exit(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        L_0x0030:
            android.util.Pair r1 = r1.a(r0, r6)
            if (r1 != 0) goto L_0x003a
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0014
        L_0x003a:
            com.tencent.mm.vfs.g$e r7 = new com.tencent.mm.vfs.g$e
            java.lang.Object r0 = r1.first
            com.tencent.mm.vfs.FileSystem$b r0 = (com.tencent.mm.vfs.FileSystem.b) r0
            java.lang.Object r1 = r1.second
            java.lang.String r1 = (java.lang.String) r1
            r3 = 0
            r7.<init>(r0, r1, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.g.a(android.net.Uri, com.tencent.mm.vfs.g$e):com.tencent.mm.vfs.g$e");
    }

    public final class a {
        final HashMap<String, m> Rce = new HashMap<>();
        final HashMap<String, f> Rcf = new HashMap<>();
        final HashMap<String, f> Rcg = new HashMap<>();
        final TreeMap<String, String> Rch = new TreeMap<>();
        final HashMap<String, String> Rci = new HashMap<>();
        f Rcj = null;
        boolean Rck = false;

        public a() {
            AppMethodBeat.i(13105);
            AppMethodBeat.o(13105);
        }

        public final a a(String str, SchemeResolver schemeResolver) {
            AppMethodBeat.i(13106);
            this.Rce.put(str, schemeResolver == null ? null : new m(schemeResolver));
            AppMethodBeat.o(13106);
            return this;
        }

        public final a a(String str, FileSystem fileSystem) {
            AppMethodBeat.i(13107);
            this.Rcf.put(str, fileSystem == null ? null : new f(fileSystem));
            AppMethodBeat.o(13107);
            return this;
        }

        public final a boO(String str) {
            AppMethodBeat.i(184814);
            this.Rcf.put(str, null);
            AppMethodBeat.o(184814);
            return this;
        }

        public final a b(String str, FileSystem fileSystem) {
            AppMethodBeat.i(187653);
            this.Rcg.put(str, new f(fileSystem));
            AppMethodBeat.o(187653);
            return this;
        }

        public final a ns(String str, String str2) {
            AppMethodBeat.i(13108);
            this.Rch.put(aa.q(str, true, false), str2);
            AppMethodBeat.o(13108);
            return this;
        }

        public final a boP(String str) {
            AppMethodBeat.i(13109);
            this.Rch.put(aa.q(str, true, false), null);
            AppMethodBeat.o(13109);
            return this;
        }

        public final a nt(String str, String str2) {
            AppMethodBeat.i(13110);
            this.Rci.put(str, str2);
            AppMethodBeat.o(13110);
            return this;
        }

        public final a boQ(String str) {
            AppMethodBeat.i(13111);
            this.Rci.put(str, null);
            AppMethodBeat.o(13111);
            return this;
        }

        public final void commit() {
            AppMethodBeat.i(13112);
            Dx(g.this.Vmw);
            AppMethodBeat.o(13112);
        }

        public final void Dx(boolean z) {
            AppMethodBeat.i(13113);
            g.a(g.this, this, z);
            this.Rcf.clear();
            this.Rch.clear();
            this.Rci.clear();
            this.Rck = false;
            AppMethodBeat.o(13113);
        }
    }

    public final a hYS() {
        AppMethodBeat.i(13119);
        a aVar = new a();
        AppMethodBeat.o(13119);
        return aVar;
    }

    public final void aQ(long j2, long j3) {
        AppMethodBeat.i(187656);
        long j4 = this.Vms;
        if (j2 >= 0 && j4 < 0) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            this.mContext.registerReceiver(this.Vmq, intentFilter);
            this.Vmq.kM(this.mContext);
        } else if (j2 < 0 && j4 >= 0) {
            this.mContext.unregisterReceiver(this.Vmq);
            this.Vmr.removeMessages(2);
        }
        this.Vms = j2;
        this.Vmt = j3;
        this.Vmu = true;
        AppMethodBeat.o(187656);
    }

    public final k hYT() {
        l lVar;
        synchronized (this.mLock) {
            lVar = this.Vmk;
        }
        return lVar;
    }

    public final Map<String, FileSystem> hec() {
        AppMethodBeat.i(187657);
        Map<String, FileSystem> hec = hYT().hec();
        AppMethodBeat.o(187657);
        return hec;
    }

    public final Map<String, String> hYU() {
        AppMethodBeat.i(187658);
        Map<String, String> hej = hYT().hej();
        AppMethodBeat.o(187658);
        return hej;
    }

    private g() {
        AppMethodBeat.i(13122);
        this.mLock = new Object();
        this.mContext = sContext;
        if (this.mContext == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
            AppMethodBeat.o(13122);
            throw illegalStateException;
        }
        File parentFile = this.mContext.getFilesDir().getParentFile();
        this.Vmo = new File(parentFile == null ? this.mContext.getCacheDir() : parentFile, ".vfs");
        this.Vmp = new HandlerThread("VFS.Maintenance", 4);
        this.Vmp.start();
        this.Vmr = new Handler(this.Vmp.getLooper(), this);
        this.Vmq = new c(this, (byte) 0);
        this.Vms = -1;
        this.Vmt = MAlarmHandler.NEXT_FIRE_INTERVAL;
        this.Vmw = true;
        Context context = this.mContext;
        HashMap hashMap = new HashMap();
        hashMap.put(null, FileSchemeResolver.hdX());
        hashMap.put("", FileSchemeResolver.hdX());
        hashMap.put("file", FileSchemeResolver.hdX());
        hashMap.put("wcf", WcfSchemeResolver.hdX());
        Map<String, f> singletonMap = Collections.singletonMap(BuildConfig.COMMAND, NullFileSystem.heh());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("data", context.getCacheDir().getParent());
        hashMap2.put("dataCache", context.getCacheDir().getPath());
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            hashMap2.put("extData", externalCacheDir.getParent());
            hashMap2.put("extCache", externalCacheDir.getPath());
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            hashMap2.put("storage", externalStorageDirectory.getPath());
        }
        this.Vmn = new l().a(hashMap, singletonMap, Collections.emptyMap(), new TreeMap(), hashMap2, null);
        this.Vmk = this.Vmn;
        this.Vml = 0;
        this.Vmm = new e(null, null, this.Vml, (byte) 0);
        AppMethodBeat.o(13122);
    }

    private void bD(Bundle bundle) {
        AppMethodBeat.i(13123);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getInt("pid") == Process.myPid()) {
            Log.v("VFS.FileSystemManager", "Ignore filesystem change broadcast from the same process.");
            AppMethodBeat.o(13123);
            return;
        }
        l by = l.by(bundle);
        synchronized (this.mLock) {
            try {
                this.Vmk = by;
                this.Vml++;
                this.Vmm = new e(null, null, this.Vml, (byte) 0);
            } catch (Throwable th) {
                AppMethodBeat.o(13123);
                throw th;
            }
        }
        StringBuilder sb = new StringBuilder(2048);
        sb.append("[Schemes]\n");
        a(by.Rde, sb);
        sb.append("[File systems]\n");
        a(by.Rdf, sb);
        sb.append("[Maintenance-only] ").append(by.Rdg.size()).append('\n');
        sb.append("[Mount points]\n");
        a(by.Rdh, sb);
        sb.append("[Environment]\n");
        a(by.Rdj, sb);
        sb.append("[Root]\n  ").append(by.Rdk.toString()).append('\n');
        Log.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + sb.toString());
        AppMethodBeat.o(13123);
    }

    private static <K, V> void a(Map<K, V> map, StringBuilder sb) {
        AppMethodBeat.i(13124);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append("  ").append((Object) entry.getKey());
            if (entry.getValue() == null) {
                sb.append(" (deleted)\n");
            } else {
                sb.append(" => ").append(entry.getValue().toString()).append('\n');
            }
        }
        AppMethodBeat.o(13124);
    }

    public final boolean handleMessage(Message message) {
        boolean z;
        l lVar;
        FileSystem.b bVar;
        AppMethodBeat.i(13126);
        switch (message.what) {
            case 1:
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(FileSystem.class.getClassLoader());
                Log.i("VFS.FileSystemManager", "Refresh file system from broadcast.");
                try {
                    bD(intent.getExtras());
                } catch (Throwable th) {
                    Log.e("VFS.FileSystemManager", th, "Failed to refresh file system from broadcast.");
                }
                AppMethodBeat.o(13126);
                return true;
            case 2:
                CancellationSignal cancellationSignal = (CancellationSignal) message.obj;
                long j2 = this.Vmt;
                long bpi = aa.bpi("maintain");
                if (bpi < j2) {
                    Log.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. %d / %d", Long.valueOf(bpi), Long.valueOf(j2));
                } else {
                    boolean z2 = this.Vmu;
                    if (z2) {
                        z = this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0;
                    } else {
                        z = z2;
                    }
                    PowerManager.WakeLock newWakeLock = z ? ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance") : null;
                    d dVar = this.Vmv;
                    try {
                        Log.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(z)));
                        if (dVar != null) {
                            dVar.hdV();
                        }
                        if (newWakeLock != null) {
                            newWakeLock.acquire(1200000);
                        }
                        synchronized (this.mLock) {
                            try {
                                lVar = this.Vmk;
                            } catch (Throwable th2) {
                                AppMethodBeat.o(13126);
                                throw th2;
                            }
                        }
                        for (String str : lVar.Rde.keySet()) {
                            Log.i("VFS.FileSystemManager", "[Maintenance] " + str + " => " + lVar.boV(str).hem().toString());
                        }
                        for (String str2 : lVar.Rdf.keySet()) {
                            FileSystem.b boT = lVar.boT(str2);
                            Log.i("VFS.FileSystemManager", "[Maintenance] " + str2 + " => " + boT.hdQ().toString());
                            boT.a(cancellationSignal);
                        }
                        for (String str3 : lVar.Rdg.keySet()) {
                            f fVar = lVar.Rdg.get(str3);
                            if (fVar == null) {
                                bVar = null;
                            } else {
                                if (fVar.RbK == null) {
                                    fVar.RbK = fVar.RbM.cj(lVar.hej());
                                }
                                bVar = fVar.RbK;
                            }
                            Log.i("VFS.FileSystemManager", "[Maintenance] " + str3 + " => " + bVar.hdQ().toString());
                            bVar.a(cancellationSignal);
                        }
                        aa.bph("maintain");
                        Log.i("VFS.FileSystemManager", "Maintenance finished.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        if (dVar != null) {
                            dVar.bh(false, false);
                        }
                    } catch (OperationCanceledException e2) {
                        Log.i("VFS.FileSystemManager", "Maintenance cancelled.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        if (dVar != null) {
                            dVar.bh(true, false);
                        }
                    } catch (Exception e3) {
                        Log.e("VFS.FileSystemManager", e3, "Maintenance failed.");
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        if (dVar != null) {
                            dVar.bh(false, true);
                        }
                    } catch (Throwable th3) {
                        if (newWakeLock != null && newWakeLock.isHeld()) {
                            newWakeLock.release();
                        }
                        if (dVar != null) {
                            dVar.bh(false, false);
                        }
                        AppMethodBeat.o(13126);
                        throw th3;
                    }
                }
                AppMethodBeat.o(13126);
                return true;
            default:
                AppMethodBeat.o(13126);
                return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(l lVar) {
        DataOutputStream dataOutputStream;
        Throwable th;
        IOException e2;
        AppMethodBeat.i(13125);
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(lVar.Rde.size());
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, m> entry : lVar.Rde.entrySet()) {
            SchemeResolver schemeResolver = entry.getValue().Rds;
            Integer num = (Integer) hashMap.get(schemeResolver);
            if (num == null) {
                num = Integer.valueOf(arrayList.size());
                arrayList.add(schemeResolver);
                hashMap.put(schemeResolver, num);
            }
            bundle2.putInt(entry.getKey(), num.intValue());
        }
        bundle.putParcelableArrayList("sl", arrayList);
        bundle.putBundle("sm", bundle2);
        Bundle bundle3 = new Bundle();
        for (Map.Entry<String, f> entry2 : lVar.Rdf.entrySet()) {
            bundle3.putParcelable(entry2.getKey(), entry2.getValue().RbM);
        }
        bundle.putBundle("fs", bundle3);
        Bundle bundle4 = new Bundle();
        for (Map.Entry<String, f> entry3 : lVar.Rdg.entrySet()) {
            bundle4.putParcelable(entry3.getKey(), entry3.getValue().RbM);
        }
        bundle.putBundle("mfs", bundle4);
        Bundle bundle5 = new Bundle();
        for (Map.Entry<String, String> entry4 : lVar.Rdh.entrySet()) {
            bundle5.putString(entry4.getKey(), entry4.getValue());
        }
        bundle.putBundle(WeChatBrands.Business.GROUP_MP, bundle5);
        Bundle bundle6 = new Bundle();
        for (Map.Entry<String, String> entry5 : lVar.Rdj.entrySet()) {
            bundle6.putString(entry5.getKey(), entry5.getValue());
        }
        bundle.putBundle("env", bundle6);
        bundle.putParcelable("root", lVar.Rdk.RbM);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(this.Vmo, "fs.bin")));
            try {
                dataOutputStream.writeInt(4);
                dataOutputStream.write(marshall);
                aa.closeQuietly(dataOutputStream);
            } catch (IOException e3) {
                e2 = e3;
                try {
                    Log.e("VFS.FileSystemManager", "Cannot write parcel file: " + e2.getMessage());
                    aa.closeQuietly(dataOutputStream);
                    Intent intent = new Intent(this.mContext.getPackageName() + ".REFRESH_VFS");
                    intent.putExtras(bundle);
                    intent.putExtra("pid", Process.myPid());
                    this.mContext.sendBroadcast(intent);
                    StringBuilder sb = new StringBuilder(2048);
                    sb.append("[Schemes]\n");
                    a(lVar.Rde, sb);
                    sb.append("[File systems]\n");
                    a(lVar.Rdf, sb);
                    sb.append("[Maintenance-only] ").append(lVar.Rdg.size()).append('\n');
                    sb.append("[Mount points]\n");
                    a(lVar.Rdh, sb);
                    sb.append("[Environment]\n");
                    a(lVar.Rdj, sb);
                    sb.append("[Root]\n  ").append(lVar.Rdk.toString()).append('\n');
                    Log.i("VFS.FileSystemManager", "Filesystem published:\n" + sb.toString());
                    AppMethodBeat.o(13125);
                } catch (Throwable th2) {
                    th = th2;
                    aa.closeQuietly(dataOutputStream);
                    AppMethodBeat.o(13125);
                    throw th;
                }
            }
        } catch (IOException e4) {
            e2 = e4;
            dataOutputStream = null;
            Log.e("VFS.FileSystemManager", "Cannot write parcel file: " + e2.getMessage());
            aa.closeQuietly(dataOutputStream);
            Intent intent2 = new Intent(this.mContext.getPackageName() + ".REFRESH_VFS");
            intent2.putExtras(bundle);
            intent2.putExtra("pid", Process.myPid());
            this.mContext.sendBroadcast(intent2);
            StringBuilder sb2 = new StringBuilder(2048);
            sb2.append("[Schemes]\n");
            a(lVar.Rde, sb2);
            sb2.append("[File systems]\n");
            a(lVar.Rdf, sb2);
            sb2.append("[Maintenance-only] ").append(lVar.Rdg.size()).append('\n');
            sb2.append("[Mount points]\n");
            a(lVar.Rdh, sb2);
            sb2.append("[Environment]\n");
            a(lVar.Rdj, sb2);
            sb2.append("[Root]\n  ").append(lVar.Rdk.toString()).append('\n');
            Log.i("VFS.FileSystemManager", "Filesystem published:\n" + sb2.toString());
            AppMethodBeat.o(13125);
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            aa.closeQuietly(dataOutputStream);
            AppMethodBeat.o(13125);
            throw th;
        }
        Intent intent22 = new Intent(this.mContext.getPackageName() + ".REFRESH_VFS");
        intent22.putExtras(bundle);
        intent22.putExtra("pid", Process.myPid());
        this.mContext.sendBroadcast(intent22);
        StringBuilder sb22 = new StringBuilder(2048);
        sb22.append("[Schemes]\n");
        a(lVar.Rde, sb22);
        sb22.append("[File systems]\n");
        a(lVar.Rdf, sb22);
        sb22.append("[Maintenance-only] ").append(lVar.Rdg.size()).append('\n');
        sb22.append("[Mount points]\n");
        a(lVar.Rdh, sb22);
        sb22.append("[Environment]\n");
        a(lVar.Rdj, sb22);
        sb22.append("[Root]\n  ").append(lVar.Rdk.toString()).append('\n');
        Log.i("VFS.FileSystemManager", "Filesystem published:\n" + sb22.toString());
        AppMethodBeat.o(13125);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void c(com.tencent.mm.vfs.g r12) {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vfs.g.c(com.tencent.mm.vfs.g):void");
    }

    static /* synthetic */ void a(g gVar, a aVar, boolean z) {
        l lVar;
        int i2;
        l a2;
        f fVar = null;
        AppMethodBeat.i(13128);
        HashMap<String, m> hashMap = aVar.Rce;
        HashMap<String, f> hashMap2 = aVar.Rcf;
        HashMap<String, f> hashMap3 = aVar.Rcg;
        TreeMap<String, String> treeMap = aVar.Rch;
        HashMap<String, String> hashMap4 = aVar.Rci;
        if (!(aVar.Rcj == null || aVar.Rcj.RbM == null)) {
            fVar = aVar.Rcj;
        }
        boolean z2 = aVar.Rck;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("[CLEAN ALL]\n");
        }
        if (!hashMap.isEmpty()) {
            sb.append("[Scheme]\n");
            a(hashMap, sb);
        }
        if (!hashMap2.isEmpty()) {
            sb.append("[File systems]\n");
            a(hashMap2, sb);
        }
        if (!hashMap3.isEmpty()) {
            sb.append("[Maintenance-only file systems]\n");
            a(hashMap3, sb);
        }
        if (!treeMap.isEmpty()) {
            sb.append("[Mount points]\n");
            a(treeMap, sb);
        }
        if (!hashMap4.isEmpty()) {
            sb.append("[Environment]\n");
            a(hashMap4, sb);
        }
        if (fVar != null) {
            sb.append("[Root]\n  ").append(fVar).append('\n');
        }
        Log.i("VFS.FileSystemManager", "File system configuration changed:\n" + sb.toString());
        synchronized (gVar.mLock) {
            if (z2) {
                try {
                    lVar = gVar.Vmn;
                } catch (Throwable th) {
                    AppMethodBeat.o(13128);
                    throw th;
                }
            } else {
                lVar = gVar.Vmk;
            }
            i2 = gVar.Vml;
        }
        while (true) {
            a2 = lVar.a(hashMap, hashMap2, hashMap3, treeMap, hashMap4, fVar);
            synchronized (gVar.mLock) {
                try {
                    if (i2 == gVar.Vml) {
                        break;
                    }
                    lVar = z2 ? gVar.Vmn : gVar.Vmk;
                    i2 = gVar.Vml;
                } finally {
                    AppMethodBeat.o(13128);
                }
            }
        }
        gVar.Vmk = a2;
        gVar.Vml = i2 + 1;
        gVar.Vmm = new e(null, null, gVar.Vml, (byte) 0);
        if (z) {
            gVar.a(a2);
        }
    }
}
