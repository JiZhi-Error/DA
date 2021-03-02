package com.tencent.mm.plugin.normsg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.e.e.a.a.f;
import com.tencent.e.e.a.d;
import com.tencent.e.e.a.e;
import com.tencent.i.a.h;
import com.tencent.i.a.i;
import com.tencent.i.a.j;
import com.tencent.i.a.m;
import com.tencent.i.a.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.d.c;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.normsg.a;
import com.tencent.mm.normsg.c;
import com.tencent.mm.normsgext.QValue;
import com.tencent.mm.normsgext.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.normsg.d.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

enum b implements a, com.tencent.mm.normsgext.a, com.tencent.mm.plugin.normsg.a.a {
    INSTANCE;
    
    private static final MMHandler AEv = new MMHandler("NormsgWorker");
    private final String[] AEw = {null};
    private final Map<String, String> AEx = new ConcurrentHashMap();

    private b(String str) {
        AppMethodBeat.i(187555);
        AppMethodBeat.o(187555);
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(148942);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(148942);
        return bVar;
    }

    static {
        AppMethodBeat.i(148981);
        AppMethodBeat.o(148981);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void au(int i2, int i3, int i4) {
        AppMethodBeat.i(148944);
        Context context = MMApplicationContext.getContext();
        if (i3 <= 0 || i3 > 4) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("action invalid: ".concat(String.valueOf(i3)));
            AppMethodBeat.o(148944);
            throw illegalArgumentException;
        }
        d.a aVar = new d.a(context, i2, i3, (byte) 0);
        long j2 = (long) (i4 * 1000);
        if (j2 < f.RMU) {
            aVar.Gfd = f.RMU;
        } else if (j2 > f.RMR * 12) {
            aVar.Gfd = f.RMR * 12;
        }
        aVar.Gfd = j2;
        e.hkD().a(new d(aVar, (byte) 0));
        AppMethodBeat.o(148944);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String aIJ(String str) {
        AppMethodBeat.i(148945);
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((char) ((str.charAt(i2) ^ 65447) ^ ((byte) (((i2 + 1) ^ length) ^ -1))));
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(148945);
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0501  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0504  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0511  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0515  */
    @Override // com.tencent.mm.plugin.normsg.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String TK(int r21) {
        /*
        // Method dump skipped, instructions count: 1304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b.TK(int):java.lang.String");
    }

    private static String aIK(String str) {
        AppMethodBeat.i(148947);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(148947);
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            switch (charAt) {
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                default:
                    if (charAt <= '~' && charAt != '[' && charAt != ']') {
                        sb.append(charAt);
                        break;
                    } else {
                        sb.append("&#").append((int) charAt).append(';');
                        break;
                    }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(148947);
        return sb2;
    }

    private static String hz(int i2, int i3) {
        PackageInfo packageInfo;
        AppMethodBeat.i(148948);
        String str = "";
        try {
            packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
            Log.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + MMApplicationContext.getPackageName());
        }
        if (packageInfo != null) {
            try {
                str = c.B(new File(packageInfo.applicationInfo.sourceDir));
                if (Util.isNullOrNil(str)) {
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(322, 13, 1, true);
                    com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 4013, String.format("%s|%s", Integer.valueOf(i2), Integer.valueOf(i3)));
                }
            } catch (Exception e3) {
                Log.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e3.getMessage());
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(322, 12, 1, true);
                com.tencent.mm.plugin.report.e.INSTANCE.a(11098, 4012, String.format("%s|%s|%s", Integer.valueOf(i2), Integer.valueOf(i3), e3.getMessage()));
            }
        }
        AppMethodBeat.o(148948);
        return str;
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        int i2 = 0;
        AppMethodBeat.i(148949);
        try {
            packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
            Log.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + MMApplicationContext.getPackageName());
        }
        if (packageInfo != null) {
            i2 = packageInfo.versionCode;
        }
        AppMethodBeat.o(148949);
        return i2;
    }

    private static String ait() {
        String str;
        AppMethodBeat.i(148950);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                str = "wifi";
            } else {
                str = new StringBuilder().append(activeNetworkInfo.getSubtype()).toString();
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", Util.stackTraceToString(e2));
            str = "";
        }
        AppMethodBeat.o(148950);
        return str;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String sv(boolean z) {
        AppMethodBeat.i(148951);
        String ac = c.p.ac(",", z);
        AppMethodBeat.o(148951);
        return ac;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exG() {
        AppMethodBeat.i(148952);
        if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
            AppMethodBeat.o(148952);
            return "";
        } else if (com.tencent.mm.plugin.normsg.d.e.aIX((String) g.aAh().azQ().get(274436, (Object) null))) {
            Log.w("MicroMsg.NormsgSourceImpl", "*** point 0, explained by source code.");
            AppMethodBeat.o(148952);
            return "";
        } else {
            List<PackageInfo> installedPackages = MMApplicationContext.getContext().getPackageManager().getInstalledPackages(0);
            StringBuilder sb = new StringBuilder(8192);
            for (PackageInfo packageInfo : installedPackages) {
                sb.append(packageInfo.packageName).append('\n');
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(148952);
            return sb2;
        }
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exJ() {
        int i2;
        AppMethodBeat.i(148959);
        if (g.aAc()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        byte[] aa = c.p.aa(0, i2);
        AppMethodBeat.o(148959);
        return aa;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(View view, Class<? extends IEvent> cls) {
        AppMethodBeat.i(148961);
        com.tencent.mm.plugin.normsg.d.c.a(view, cls);
        AppMethodBeat.o(148961);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void TL(int i2) {
        AppMethodBeat.i(148962);
        com.tencent.mm.plugin.normsg.d.a.exW().TL(i2);
        AppMethodBeat.o(148962);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean a(int i2, byte[] bArr, int i3, int i4, PInt pInt, PInt pInt2, PByteArray pByteArray) {
        AppMethodBeat.i(148963);
        QValue qValue = new QValue();
        QValue qValue2 = new QValue();
        QValue qValue3 = new QValue();
        boolean a2 = b.a.a(i2, bArr, i3, i4, qValue, qValue2, qValue3);
        if (a2) {
            pInt.value = ((Integer) qValue.getValue(0)).intValue();
            pInt2.value = ((Integer) qValue2.getValue(0)).intValue();
            pByteArray.value = (byte[]) qValue3.value;
        } else {
            pInt.value = 0;
            pInt2.value = 0;
            pByteArray.value = null;
        }
        AppMethodBeat.o(148963);
        return a2;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean a(int i2, byte[] bArr, int i3, int i4, PByteArray pByteArray) {
        AppMethodBeat.i(148964);
        QValue qValue = new QValue();
        QValue qValue2 = new QValue();
        QValue qValue3 = new QValue();
        boolean a2 = b.a.a(i2, bArr, i3, i4, qValue, qValue2, qValue3);
        if (a2) {
            dtd dtd = new dtd();
            dtd.MVj = ((Integer) qValue.getValue(0)).intValue();
            dtd.MVk = ((Integer) qValue2.getValue(0)).intValue();
            dtd.LoA = com.tencent.mm.bw.b.cD((byte[]) qValue3.value);
            try {
                pByteArray.value = dtd.toByteArray();
            } catch (IOException e2) {
                Log.e("MicroMsg.NormsgSourceImpl", "[-] pb deseralize failed");
            }
        }
        AppMethodBeat.o(148964);
        return a2;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exK() {
        AppMethodBeat.i(148975);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        e.hkD().Qt();
        Context context = MMApplicationContext.getContext();
        e.hkD().a(context, q.dr(true), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: INVOKE  
              (wrap: com.tencent.e.e.a.e : 0x002a: INVOKE  (r6v0 com.tencent.e.e.a.e) =  type: STATIC call: com.tencent.e.e.a.e.hkD():com.tencent.e.e.a.e)
              (r2v1 'context' android.content.Context)
              (wrap: java.lang.String : 0x001c: INVOKE  (r3v1 java.lang.String) = true type: STATIC call: com.tencent.mm.compatible.deviceinfo.q.dr(boolean):java.lang.String)
              (wrap: com.tencent.e.a.d$1 : 0x0030: CONSTRUCTOR  (r7v0 com.tencent.e.a.d$1) = 
              (wrap: com.tencent.mm.plugin.normsg.b$2 : 0x0022: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.normsg.b$2) = 
              (r9v0 'this' com.tencent.mm.plugin.normsg.b A[IMMUTABLE_TYPE, THIS])
              (r0v0 'byteArrayOutputStream' java.io.ByteArrayOutputStream A[SKIP_ARG])
              (r1v0 'countDownLatch' java.util.concurrent.CountDownLatch A[SKIP_ARG])
             call: com.tencent.mm.plugin.normsg.b.2.<init>(com.tencent.mm.plugin.normsg.b, java.io.ByteArrayOutputStream, java.util.concurrent.CountDownLatch):void type: CONSTRUCTOR)
              (wrap: com.tencent.e.b.c : 0x0027: CONSTRUCTOR  (r5v0 com.tencent.e.b.c) = (r2v1 'context' android.content.Context) call: com.tencent.e.b.c.<init>(android.content.Context):void type: CONSTRUCTOR)
             call: com.tencent.e.a.d.1.<init>(com.tencent.e.a.b, com.tencent.e.b.c):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.e.e.a.e.a(android.content.Context, java.lang.String, com.tencent.e.e.a.a.e):void in method: com.tencent.mm.plugin.normsg.b.exK():byte[], file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: CONSTRUCTOR  (r7v0 com.tencent.e.a.d$1) = 
              (wrap: com.tencent.mm.plugin.normsg.b$2 : 0x0022: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.normsg.b$2) = 
              (r9v0 'this' com.tencent.mm.plugin.normsg.b A[IMMUTABLE_TYPE, THIS])
              (r0v0 'byteArrayOutputStream' java.io.ByteArrayOutputStream A[SKIP_ARG])
              (r1v0 'countDownLatch' java.util.concurrent.CountDownLatch A[SKIP_ARG])
             call: com.tencent.mm.plugin.normsg.b.2.<init>(com.tencent.mm.plugin.normsg.b, java.io.ByteArrayOutputStream, java.util.concurrent.CountDownLatch):void type: CONSTRUCTOR)
              (wrap: com.tencent.e.b.c : 0x0027: CONSTRUCTOR  (r5v0 com.tencent.e.b.c) = (r2v1 'context' android.content.Context) call: com.tencent.e.b.c.<init>(android.content.Context):void type: CONSTRUCTOR)
             call: com.tencent.e.a.d.1.<init>(com.tencent.e.a.b, com.tencent.e.b.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.normsg.b.exK():byte[], file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.e.a.d, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            r8 = 148975(0x245ef, float:2.08758E-40)
            r3 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch
            r1.<init>(r3)
            com.tencent.e.e.a.e r2 = com.tencent.e.e.a.e.hkD()
            r2.Qt()
            android.content.Context r2 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
            java.lang.String r3 = com.tencent.mm.compatible.deviceinfo.q.dr(r3)
            com.tencent.mm.plugin.normsg.b$2 r4 = new com.tencent.mm.plugin.normsg.b$2
            r4.<init>(r0, r1)
            com.tencent.e.b.c r5 = new com.tencent.e.b.c
            r5.<init>(r2)
            com.tencent.e.e.a.e r6 = com.tencent.e.e.a.e.hkD()
            com.tencent.e.a.d$1 r7 = new com.tencent.e.a.d$1
            r7.<init>(r4, r5)
            r6.a(r2, r3, r7)
            r1.await()     // Catch:{ InterruptedException -> 0x0041 }
        L_0x0039:
            byte[] r0 = r0.toByteArray()
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            return r0
        L_0x0041:
            r1 = move-exception
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.normsg.b.exK():byte[]");
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] TM(int i2) {
        int i3;
        AppMethodBeat.i(148976);
        if (g.aAc()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        byte[] ea = c.p.ea(i2, i3);
        AppMethodBeat.o(148976);
        return ea;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final a exR() {
        return this;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final com.tencent.mm.normsgext.a exS() {
        return this;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void exT() {
        AppMethodBeat.i(187562);
        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src i1.");
        Context context = MMApplicationContext.getContext();
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(new BroadcastReceiver() {
                /* class com.tencent.mm.plugin.normsg.b.AnonymousClass3 */

                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(187553);
                    if (intent == null) {
                        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g1.");
                        AppMethodBeat.o(187553);
                    } else if (!"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) || !intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                        synchronized (b.this.AEw) {
                            try {
                                Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, invalidating sth.");
                                b.this.AEw[0] = null;
                                b.this.AEx.clear();
                            } finally {
                                AppMethodBeat.o(187553);
                            }
                        }
                    } else {
                        Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src, g2.");
                        AppMethodBeat.o(187553);
                    }
                }
            }, intentFilter);
            AppMethodBeat.o(187562);
        } else if (BuildInfo.DEBUG || CrashReportFactory.hasDebuger()) {
            IllegalStateException illegalStateException = new IllegalStateException("MMApplicationContext has not been initialized.");
            AppMethodBeat.o(187562);
            throw illegalStateException;
        } else {
            Log.e("MicroMsg.NormsgSourceImpl", "[-] MMApplicationContext has not been initialized.");
            AppMethodBeat.o(187562);
        }
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void eW(String str, int i2) {
        AppMethodBeat.i(187563);
        com.tencent.mm.plugin.normsg.c.a.a exU = com.tencent.mm.plugin.normsg.c.a.a.exU();
        exU.g(1, i2, str);
        exU.a(3, str, 4000);
        AppMethodBeat.o(187563);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void sw(boolean z) {
        AppMethodBeat.i(187565);
        try {
            i.a hpZ = i.hpZ();
            hpZ.Sqx = z;
            n.a(hpZ);
            AppMethodBeat.o(187565);
        } catch (Throwable th) {
            Log.i("MicroMsg.NormsgSourceImpl", "stop turing owner failed");
            AppMethodBeat.o(187565);
        }
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final String bkv() {
        String str;
        byte[] byteArray;
        AppMethodBeat.i(187566);
        synchronized (this.AEw) {
            try {
                if (this.AEw[0] == null) {
                    Log.i("MicroMsg.NormsgSourceImpl", "[+] Explained by src rf.");
                    Bundle cM = com.tencent.mm.lib.riskscanner.a.a.cM(MMApplicationContext.getContext());
                    if (!(cM == null || cM.getInt("errCode", -100) != 0 || (byteArray = cM.getByteArray("reqBufferBase64")) == null)) {
                        this.AEw[0] = Base64.encodeToString(byteArray, 2);
                    }
                }
                str = this.AEw[0] != null ? this.AEw[0] : "";
            } finally {
                AppMethodBeat.o(187566);
            }
        }
        return str;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final long bkw() {
        AppMethodBeat.i(187567);
        long exX = com.tencent.mm.plugin.normsg.d.a.exW().exX();
        AppMethodBeat.o(187567);
        return exX;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final void R(int i2, String str) {
        AppMethodBeat.i(187568);
        h.INSTANCE.kvStat(i2, str);
        AppMethodBeat.o(187568);
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final void O(int i2, int i3, int i4) {
        AppMethodBeat.i(187569);
        h.INSTANCE.n((long) i2, (long) i3, (long) i4);
        AppMethodBeat.o(187569);
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final void w(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(187570);
        h.INSTANCE.b(i2, i3, i4, i5, true);
        AppMethodBeat.o(187570);
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final String bkx() {
        AppMethodBeat.i(187571);
        String str = com.tencent.mm.plugin.soter.d.d.flM().FhU;
        if (str != null) {
            AppMethodBeat.o(187571);
            return str;
        }
        AppMethodBeat.o(187571);
        return "";
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final boolean bky() {
        AppMethodBeat.i(187572);
        boolean isConnected = k.isConnected();
        AppMethodBeat.o(187572);
        return isConnected;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final String bkz() {
        AppMethodBeat.i(187573);
        String str = com.tencent.mm.plugin.soter.d.d.flM().hFF;
        if (str != null) {
            AppMethodBeat.o(187573);
            return str;
        }
        AppMethodBeat.o(187573);
        return "";
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final String getDeviceId() {
        AppMethodBeat.i(187574);
        String aoG = q.aoG();
        AppMethodBeat.o(187574);
        return aoG;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final boolean k(String str, byte[] bArr) {
        AppMethodBeat.i(187575);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(new StringBuilder("gsmron").reverse().append(new StringBuilder("atadtsurt_").reverse().toString()).toString());
        if (!mmkv.encode(str, bArr)) {
            AppMethodBeat.o(187575);
            return false;
        }
        boolean commit = mmkv.commit();
        AppMethodBeat.o(187575);
        return commit;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final byte[] RW(String str) {
        AppMethodBeat.i(187576);
        byte[] decodeBytes = MultiProcessMMKV.getMMKV(new StringBuilder("gsmron").reverse().append(new StringBuilder("atadtsurt_").reverse().toString()).toString()).decodeBytes(str);
        AppMethodBeat.o(187576);
        return decodeBytes;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final void RX(String str) {
        AppMethodBeat.i(187577);
        MultiProcessMMKV.getMMKV(new StringBuilder("gsmron").reverse().append(new StringBuilder("atadtsurt_").reverse().toString()).toString()).remove(str).commit();
        AppMethodBeat.o(187577);
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a, com.tencent.mm.plugin.normsg.a.a
    public final String aoK() {
        AppMethodBeat.i(148980);
        try {
            com.tencent.e.e.b.a.a.c kV = com.tencent.e.e.b.a.a.b.kV(MMApplicationContext.getContext());
            if (kV.errorCode == 0) {
                String nullAsNil = Util.nullAsNil(kV.Dsg);
                AppMethodBeat.o(148980);
                return nullAsNil;
            }
            Log.e("MicroMsg.NormsgSourceImpl", "[-] Fail to get OAID, errorcode: %s", Integer.valueOf(kV.errorCode));
            AppMethodBeat.o(148980);
            return "";
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "Fail to get OAID.", new Object[0]);
            AppMethodBeat.o(148980);
            return "";
        }
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final String G(Context context, String str) {
        AppMethodBeat.i(187578);
        String str2 = this.AEx.get(str);
        if (str2 == null) {
            str2 = NormsgDataProvider.G(context, str);
            if (!TextUtils.isEmpty(str2)) {
                this.AEx.put(str, str2);
            }
        }
        String nullAsNil = Util.nullAsNil(str2);
        AppMethodBeat.o(187578);
        return nullAsNil;
    }

    @Override // com.tencent.mm.normsgext.a, com.tencent.mm.normsg.a
    public final boolean dn(Context context) {
        AppMethodBeat.i(187579);
        boolean dn = NormsgDataProvider.dn(context);
        AppMethodBeat.o(187579);
        return dn;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String[] aIU(String str) {
        AppMethodBeat.i(187580);
        cs csVar = new cs();
        csVar.dFQ.path = str;
        EventCenter.instance.publish(csVar);
        if (csVar.dFR.dFS != null) {
            String[] strArr = csVar.dFR.dFS;
            AppMethodBeat.o(187580);
            return strArr;
        } else if (csVar.dFR.isTimeout) {
            String[] strArr2 = {"<timeout>"};
            AppMethodBeat.o(187580);
            return strArr2;
        } else {
            AppMethodBeat.o(187580);
            return null;
        }
    }

    @Override // com.tencent.mm.normsg.a
    public final boolean bkA() {
        String decodeString;
        AppMethodBeat.i(187581);
        try {
            decodeString = (String) g.aAh().azQ().get(274436, (Object) null);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "[-] Error happened.", new Object[0]);
            decodeString = MultiProcessMMKV.getMMKV("mmkv_crossprocess_infos").decodeString("mmkv_key_user_reg_ic", null);
        }
        if (TextUtils.isEmpty(decodeString)) {
            AppMethodBeat.o(187581);
            return false;
        } else if (com.tencent.mm.plugin.normsg.d.e.aIX(decodeString)) {
            AppMethodBeat.o(187581);
            return true;
        } else {
            AppMethodBeat.o(187581);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] TJ(int i2) {
        AppMethodBeat.i(148943);
        byte[] aa = c.p.aa(i2, 0);
        AppMethodBeat.o(148943);
        return aa;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exH() {
        AppMethodBeat.i(148953);
        boolean ab = c.p.ab();
        AppMethodBeat.o(148953);
        return ab;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exI() {
        boolean z = false;
        AppMethodBeat.i(148954);
        try {
            z = c.p.ag();
            AppMethodBeat.o(148954);
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected error.", new Object[0]);
            AppMethodBeat.o(148954);
        }
        return z;
    }

    public static boolean isHookedByXposed() {
        AppMethodBeat.i(148955);
        boolean ah = c.p.ah();
        Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] alpha tom: %s", Boolean.valueOf(ah));
        AppMethodBeat.o(148955);
        return ah;
    }

    public static boolean isX86Env() {
        AppMethodBeat.i(148956);
        boolean ai = c.p.ai();
        Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] bravo jerry: %s", Boolean.valueOf(ai));
        AppMethodBeat.o(148956);
        return ai;
    }

    public static boolean isDualByTools() {
        AppMethodBeat.i(148957);
        boolean aj = c.p.aj();
        Log.i("MicroMsg.NormsgSourceImpl", "[tomys-edt] charlie brown: %s", Boolean.valueOf(aj));
        AppMethodBeat.o(148957);
        return aj;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean c(Object obj, Class cls) {
        AppMethodBeat.i(148958);
        boolean ca = c.p.ca(obj, cls);
        AppMethodBeat.o(148958);
        return ca;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean dH(Object obj) {
        AppMethodBeat.i(148960);
        boolean cb = c.p.cb(obj);
        AppMethodBeat.o(148960);
        return cb;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIL(String str) {
        AppMethodBeat.i(148965);
        c.p.da(str);
        AppMethodBeat.o(148965);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIM(String str) {
        AppMethodBeat.i(148966);
        c.p.db(str);
        AppMethodBeat.o(148966);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIN(String str) {
        AppMethodBeat.i(148967);
        c.p.dc(str);
        AppMethodBeat.o(148967);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean aIO(String str) {
        AppMethodBeat.i(148968);
        boolean dd = c.p.dd(str);
        AppMethodBeat.o(148968);
        return dd;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] aIP(String str) {
        AppMethodBeat.i(148969);
        byte[] de = c.p.de(str);
        AppMethodBeat.o(148969);
        return de;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aA(String str, String str2, String str3) {
        AppMethodBeat.i(187556);
        c.p.df(str, str2, str3);
        AppMethodBeat.o(187556);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void jf(String str, String str2) {
        AppMethodBeat.i(148970);
        c.p.df(str, str2, "");
        AppMethodBeat.o(148970);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(String str, MotionEvent motionEvent) {
        AppMethodBeat.i(148971);
        c.p.dg(str, motionEvent);
        AppMethodBeat.o(148971);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void aIQ(String str) {
        AppMethodBeat.i(148972);
        c.p.dh(str);
        AppMethodBeat.o(148972);
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean aIR(String str) {
        AppMethodBeat.i(148973);
        boolean di = c.p.di(str);
        AppMethodBeat.o(148973);
        return di;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] aIS(String str) {
        AppMethodBeat.i(148974);
        byte[] dj = c.p.dj(str);
        AppMethodBeat.o(148974);
        return dj;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String aIT(String str) {
        AppMethodBeat.i(187557);
        String dk = c.p.dk(str);
        AppMethodBeat.o(187557);
        return dk;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean K(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(148977);
        boolean eb = c.p.eb(bArr, i2, i3);
        AppMethodBeat.o(148977);
        return eb;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exL() {
        AppMethodBeat.i(148978);
        boolean ec = c.p.ec();
        AppMethodBeat.o(148978);
        return ec;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final byte[] exM() {
        AppMethodBeat.i(148979);
        byte[] ee = c.p.ee();
        AppMethodBeat.o(148979);
        return ee;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final boolean exN() {
        AppMethodBeat.i(187558);
        boolean al = c.p.al();
        AppMethodBeat.o(187558);
        return al;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exO() {
        AppMethodBeat.i(187559);
        String ef = c.p.ef();
        AppMethodBeat.o(187559);
        return ef;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exP() {
        AppMethodBeat.i(187560);
        String eg = c.p.eg();
        AppMethodBeat.o(187560);
        return eg;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final String exQ() {
        AppMethodBeat.i(187561);
        String eh = c.p.eh();
        AppMethodBeat.o(187561);
        return eh;
    }

    @Override // com.tencent.mm.plugin.normsg.a.a
    public final void a(com.tencent.mm.plugin.normsg.a.b bVar) {
        boolean z;
        AppMethodBeat.i(187564);
        try {
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                z = true;
            } else {
                z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_enable_turing_owner, false);
            }
            if (!z) {
                AppMethodBeat.o(187564);
                return;
            }
            m.a aVar = new m.a();
            aVar.SqJ = new j();
            n.a(MMApplicationContext.getContext(), aVar.hqb());
            AnonymousClass4 r0 = new com.tencent.i.a.e() {
                /* class com.tencent.mm.plugin.normsg.b.AnonymousClass4 */

                @Override // com.tencent.i.a.e
                public final boolean bW(byte[] bArr) {
                    AppMethodBeat.i(187554);
                    if (bArr != null && bArr.length > 0) {
                        sb sbVar = new sb();
                        sbVar.dYE.buffer = bArr;
                        EventCenter.instance.publish(sbVar);
                    }
                    AppMethodBeat.o(187554);
                    return true;
                }
            };
            h.a aVar2 = new h.a((byte) 0);
            aVar2.zfX = MD5Util.getMD5String(q.getAndroidId());
            aVar2.Sqp = 4;
            aVar2.Sqq = com.tencent.i.a.b.DATA_USAGE_TYPE_IDENTIFY_TRAIN;
            aVar2.Sqr = com.tencent.i.a.c.GESTURETYPE_SINGLE;
            aVar2.Sqv = bVar;
            n.a(aVar2, r0);
            AppMethodBeat.o(187564);
        } catch (Throwable th) {
            Log.i("MicroMsg.NormsgSourceImpl", "start turing owner failed");
            AppMethodBeat.o(187564);
        }
    }
}
