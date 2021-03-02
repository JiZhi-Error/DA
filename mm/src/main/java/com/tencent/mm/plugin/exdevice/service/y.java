package com.tencent.mm.plugin.exdevice.service;

import android.bluetooth.BluetoothAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.b.e;
import com.tencent.mm.plugin.d.a.d.a;
import com.tencent.mm.plugin.exdevice.service.a;
import com.tencent.mm.plugin.exdevice.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

public final class y extends h.a implements com.tencent.mm.plugin.d.a.a.b, a.AbstractC0940a, g {
    private final MMHandler mHandler;
    private a rDY;
    private RemoteCallbackList<k> rDZ;
    private RemoteCallbackList<p> rEa;
    private RemoteCallbackList<j> rEb;
    private RemoteCallbackList<i> rEc;
    private RemoteCallbackList<q> rEd;
    private RemoteCallbackList<n> rEe;
    private final l rEf;
    private int rEg;
    private final com.tencent.mm.plugin.d.a.a.f rEh;
    private final com.tencent.mm.plugin.d.a.d.a rEi;
    private RemoteCallbackList<j> rEj;
    private RemoteCallbackList<k> rEk;
    private RemoteCallbackList<s> rEl;
    private RemoteCallbackList<t> rEm;
    com.tencent.mm.plugin.d.a.b.e rEn;
    private e.a rEo;

    static final class d {
        String lAr = null;
        long rDg = 0;
        int rxH = 0;
        int rxv = 0;
    }

    static /* synthetic */ void a(y yVar, long j2, int i2, int i3, String str) {
        AppMethodBeat.i(23764);
        yVar.d(j2, i2, i3, str);
        AppMethodBeat.o(23764);
    }

    static /* synthetic */ boolean a(y yVar, int i2, j jVar) {
        AppMethodBeat.i(23772);
        boolean f2 = yVar.f(i2, jVar);
        AppMethodBeat.o(23772);
        return f2;
    }

    static /* synthetic */ boolean a(y yVar, long j2, p pVar) {
        AppMethodBeat.i(23765);
        boolean b2 = yVar.b(j2, pVar);
        AppMethodBeat.o(23765);
        return b2;
    }

    static /* synthetic */ boolean b(y yVar, int i2, j jVar) {
        AppMethodBeat.i(23773);
        boolean g2 = yVar.g(i2, jVar);
        AppMethodBeat.o(23773);
        return g2;
    }

    static final class l {
        long rDg;

        private l() {
            this.rDg = 0;
        }

        /* synthetic */ l(byte b2) {
            this();
        }
    }

    final class a extends MMHandler {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(23725);
            switch (message.what) {
                case 0:
                    k kVar = (k) message.obj;
                    if (!y.a(y.this, kVar.rDg, kVar.rEx)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp failed!!!");
                    }
                    AppMethodBeat.o(23725);
                    return;
                case 1:
                    if (!y.a(y.this, ((Long) message.obj).longValue())) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp failed!!!");
                    }
                    AppMethodBeat.o(23725);
                    return;
                case 2:
                    d dVar = (d) message.obj;
                    y.a(y.this, dVar.rDg, dVar.rxH, dVar.rxv, dVar.lAr);
                    AppMethodBeat.o(23725);
                    return;
                case 3:
                    j jVar = (j) message.obj;
                    if (!y.a(y.this, jVar.pkb, jVar.rEw, jVar.rEs)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp failed!!!");
                    }
                    AppMethodBeat.o(23725);
                    return;
                case 4:
                    if (!y.b(y.this, ((Long) message.obj).longValue())) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp failed!!!");
                        AppMethodBeat.o(23725);
                        return;
                    }
                    break;
                case 5:
                    c cVar = (c) message.obj;
                    y.a(y.this, cVar.pkb, cVar.rDe, cVar.rDf, cVar.rxv);
                    AppMethodBeat.o(23725);
                    return;
                case 6:
                    b bVar = (b) message.obj;
                    y.a(y.this, bVar.mErrorCode, bVar.pkb, bVar.rxC, bVar.rDd, bVar.rxw);
                    AppMethodBeat.o(23725);
                    return;
                case 7:
                    e eVar = (e) message.obj;
                    if (!y.this.c(eVar.rAt, eVar.rEr, eVar.rEs)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl error");
                    }
                    AppMethodBeat.o(23725);
                    return;
                case 8:
                    long longValue = ((Long) message.obj).longValue();
                    y yVar = y.this;
                    Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTDisonnectImpl. mac=%d", Long.valueOf(longValue));
                    if (yVar.rEn != null) {
                        com.tencent.mm.plugin.d.a.b.e eVar2 = yVar.rEn;
                        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "disconnect. mac = %d", Long.valueOf(longValue));
                        if (!eVar2.ckE()) {
                            Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                            AppMethodBeat.o(23725);
                            return;
                        }
                        eVar2.ai(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0136: INVOKE  
                              (r2v4 'eVar2' com.tencent.mm.plugin.d.a.b.e)
                              (wrap: com.tencent.mm.plugin.d.a.b.e$5 : 0x0133: CONSTRUCTOR  (r3v5 com.tencent.mm.plugin.d.a.b.e$5) = (r2v4 'eVar2' com.tencent.mm.plugin.d.a.b.e), (r0v21 'longValue' long) call: com.tencent.mm.plugin.d.a.b.e.5.<init>(com.tencent.mm.plugin.d.a.b.e, long):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.tencent.mm.plugin.d.a.b.e.ai(java.lang.Runnable):void in method: com.tencent.mm.plugin.exdevice.service.y.a.handleMessage(android.os.Message):void, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0133: CONSTRUCTOR  (r3v5 com.tencent.mm.plugin.d.a.b.e$5) = (r2v4 'eVar2' com.tencent.mm.plugin.d.a.b.e), (r0v21 'longValue' long) call: com.tencent.mm.plugin.d.a.b.e.5.<init>(com.tencent.mm.plugin.d.a.b.e, long):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.service.y.a.handleMessage(android.os.Message):void, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 28 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.d.a.b.e, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 34 more
                            */
                        /*
                        // Method dump skipped, instructions count: 482
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.service.y.a.handleMessage(android.os.Message):void");
                    }
                }

                /* access modifiers changed from: package-private */
                public static final class c {
                    long phx;
                    long pkb;
                    int rDe;
                    int rDf;
                    int rxv;

                    private c() {
                        this.pkb = 0;
                        this.rDe = 0;
                        this.rDf = 0;
                        this.rxv = 0;
                        this.phx = 0;
                    }

                    /* synthetic */ c(byte b2) {
                        this();
                    }
                }

                static final class b {
                    int mErrorCode;
                    long pkb;
                    short rDd;
                    short rxC;
                    byte[] rxw;

                    private b() {
                        this.pkb = 0;
                        this.rxC = 0;
                        this.rDd = 0;
                        this.rxw = null;
                        this.mErrorCode = 0;
                    }

                    /* synthetic */ b(byte b2) {
                        this();
                    }
                }

                static final class k {
                    long rDg;
                    p rEx;

                    public k(long j2, p pVar) {
                        this.rDg = j2;
                        this.rEx = pVar;
                    }
                }

                static final class j {
                    long pkb;
                    k rEs;
                    int rEw;

                    public j(long j2, int i2, k kVar) {
                        this.pkb = j2;
                        this.rEw = i2;
                        this.rEs = kVar;
                    }
                }

                static final class e {
                    public long rAt;
                    public int rEr;
                    public k rEs;

                    private e() {
                    }

                    /* synthetic */ e(byte b2) {
                        this();
                    }
                }

                static final class i {
                    public byte[] mData;
                    public long rAt;
                    public t rEv;

                    private i() {
                    }

                    /* synthetic */ i(byte b2) {
                        this();
                    }
                }

                static final class h {
                    public String lAr;
                    public long rAt;
                    public int rxH;
                    public int rxv;

                    private h() {
                    }

                    /* synthetic */ h(byte b2) {
                        this();
                    }
                }

                static final class f {
                    public byte[] mData;
                    public long rAt;

                    private f() {
                    }

                    /* synthetic */ f(byte b2) {
                        this();
                    }
                }

                /* access modifiers changed from: package-private */
                public static final class g {
                    int lOO;
                    String mDeviceName;
                    String pkf;
                    boolean rEt;
                    byte[] rEu;

                    private g() {
                    }

                    /* synthetic */ g(byte b2) {
                        this();
                    }
                }

                public y() {
                    AppMethodBeat.i(23726);
                    this.rDY = null;
                    this.rDZ = new RemoteCallbackList<>();
                    this.rEa = new RemoteCallbackList<>();
                    this.rEb = new RemoteCallbackList<>();
                    this.rEc = new RemoteCallbackList<>();
                    this.rEd = new RemoteCallbackList<>();
                    this.rEe = new RemoteCallbackList<>();
                    this.rEf = new l((byte) 0);
                    this.rEg = 0;
                    this.rEj = new RemoteCallbackList<>();
                    this.rEk = new RemoteCallbackList<>();
                    this.rEl = new RemoteCallbackList<>();
                    this.rEm = new RemoteCallbackList<>();
                    this.rDY = new a(this);
                    this.mHandler = new a(v.cLz().jkv.getSerialTag());
                    if (Build.VERSION.SDK_INT >= 18) {
                        this.rEh = new com.tencent.mm.plugin.d.a.a.f(this);
                    } else {
                        this.rEh = null;
                    }
                    this.rEi = new com.tencent.mm.plugin.d.a.d.a(this);
                    this.rEo = new e.a() {
                        /* class com.tencent.mm.plugin.exdevice.service.y.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.d.a.b.e.a
                        public final void a(long j2, boolean z, long j3) {
                            int i2;
                            AppMethodBeat.i(23717);
                            Object[] objArr = new Object[3];
                            objArr[0] = Long.valueOf(j2);
                            objArr[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                            objArr[2] = Long.valueOf(j3);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onConnected. seesionId=%d, connected=%s, profileType=%d", objArr);
                            c cVar = new c((byte) 0);
                            cVar.pkb = j2;
                            if (z) {
                                i2 = 2;
                            } else {
                                i2 = 4;
                            }
                            cVar.rDf = i2;
                            cVar.rDe = 1;
                            cVar.rxv = 0;
                            cVar.phx = j3;
                            if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(9, cVar))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 9);
                            }
                            AppMethodBeat.o(23717);
                        }

                        @Override // com.tencent.mm.plugin.d.a.b.e.a
                        public final void b(long j2, byte[] bArr) {
                            AppMethodBeat.i(23718);
                            f fVar = new f((byte) 0);
                            fVar.rAt = j2;
                            fVar.mData = bArr;
                            if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(12, fVar))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 12);
                            }
                            AppMethodBeat.o(23718);
                        }

                        @Override // com.tencent.mm.plugin.d.a.b.e.a
                        public final void m(long j2, boolean z) {
                            AppMethodBeat.i(23719);
                            Object[] objArr = new Object[2];
                            objArr[0] = Long.valueOf(j2);
                            objArr[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onSend. sessionId=%d, success=%s", objArr);
                            h hVar = new h((byte) 0);
                            hVar.rAt = j2;
                            if (z) {
                                hVar.rxH = 0;
                                hVar.rxv = 0;
                            } else {
                                hVar.rxH = -1;
                                hVar.rxv = -1;
                            }
                            hVar.lAr = "";
                            if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(11, hVar))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 11);
                            }
                            AppMethodBeat.o(23719);
                        }

                        @Override // com.tencent.mm.plugin.d.a.b.e.a
                        public final void a(String str, String str2, int i2, byte[] bArr) {
                            AppMethodBeat.i(23720);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscover. deviceMac=%s, deviceName=%s", str, str2);
                            g gVar = new g((byte) 0);
                            gVar.rEt = false;
                            gVar.pkf = str;
                            gVar.mDeviceName = str2;
                            gVar.lOO = i2;
                            gVar.rEu = bArr;
                            if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 13);
                            }
                            AppMethodBeat.o(23720);
                        }

                        @Override // com.tencent.mm.plugin.d.a.b.e.a
                        public final void ckF() {
                            AppMethodBeat.i(23721);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDiscoverFinished");
                            g gVar = new g((byte) 0);
                            gVar.rEt = true;
                            gVar.pkf = null;
                            gVar.mDeviceName = null;
                            gVar.lOO = 0;
                            gVar.rEu = null;
                            if (!y.this.mHandler.sendMessage(y.this.mHandler.obtainMessage(13, gVar))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 13);
                            }
                            AppMethodBeat.o(23721);
                        }
                    };
                    com.tencent.mm.compatible.a.a.a(18, new a.AbstractC0298a() {
                        /* class com.tencent.mm.plugin.exdevice.service.y.AnonymousClass2 */

                        @Override // com.tencent.mm.compatible.a.a.AbstractC0298a
                        public final void run() {
                            AppMethodBeat.i(23722);
                            y.this.rEn = new com.tencent.mm.plugin.d.a.b.e(y.this.rEo);
                            AppMethodBeat.o(23722);
                        }
                    });
                    AppMethodBeat.o(23726);
                }

                private static IInterface a(long j2, RemoteCallbackList remoteCallbackList, int i2) {
                    AppMethodBeat.i(23727);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "findCallbackbyId, Id = %d, count = %d", Long.valueOf(j2), Integer.valueOf(i2));
                    for (int i3 = 0; i3 < i2; i3++) {
                        HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i3);
                        if (hashMap.containsKey(Long.valueOf(j2))) {
                            IInterface iInterface = (IInterface) hashMap.get(Long.valueOf(j2));
                            AppMethodBeat.o(23727);
                            return iInterface;
                        }
                    }
                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find id in the callback list");
                    AppMethodBeat.o(23727);
                    return null;
                }

                private boolean c(j jVar) {
                    AppMethodBeat.i(23728);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnscanCallback");
                    boolean unregister = this.rEb.unregister(jVar);
                    if (!unregister) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
                    } else {
                        this.rEg--;
                    }
                    AppMethodBeat.o(23728);
                    return unregister;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean b(final int i2, final j jVar) {
                    AppMethodBeat.i(23729);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---scan--- aBluetoothVersion = ".concat(String.valueOf(i2)));
                    if (jVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
                        AppMethodBeat.o(23729);
                        return false;
                    }
                    boolean post = this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.service.y.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(23723);
                            if (!y.a(y.this, i2, jVar)) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scanImp failed!!!");
                            }
                            AppMethodBeat.o(23723);
                        }
                    });
                    if (!post) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan: mHandler.post failed!!!");
                    }
                    AppMethodBeat.o(23729);
                    return post;
                }

                private boolean f(int i2, j jVar) {
                    boolean z;
                    AppMethodBeat.i(23730);
                    if (jVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("scanImp: null == aCallback");
                        AppMethodBeat.o(23730);
                        throw illegalArgumentException;
                    }
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnscanCallback");
                    boolean register = this.rEb.register(jVar);
                    if (!register) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.register Failed!!!");
                    } else {
                        this.rEg++;
                    }
                    if (!register) {
                        try {
                            jVar.a(0, -1, "scanImp: registScanCallback failed!!!", "", "", 0, null);
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                        AppMethodBeat.o(23730);
                        return false;
                    }
                    a aVar = this.rDY;
                    Log.i("MicroMsg.exdevice.BTDeviceManager", "------scan------ bluetooth version = %d", Integer.valueOf(i2));
                    if (!b.a(i2, aVar, new int[0])) {
                        Log.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.scan Failed!!!");
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.scan Failed!!!");
                        try {
                            jVar.a(0, -1, "scanImp: mBTDeviceMrg.scan failed!!!", "", "", 0, null);
                        } catch (RemoteException e3) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallback.onScanCallback failed!!! %s", e3.getMessage());
                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e3, "", new Object[0]);
                        }
                        if (!c(jVar)) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                        }
                    }
                    AppMethodBeat.o(23730);
                    return z;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean c(final int i2, final j jVar) {
                    AppMethodBeat.i(23731);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---stopScan--- aBluetoothVersion = ".concat(String.valueOf(i2)));
                    if (jVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback");
                        AppMethodBeat.o(23731);
                        return false;
                    }
                    boolean post = this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.service.y.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(23724);
                            if (!y.b(y.this, i2, jVar)) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp failed!!!");
                            }
                            AppMethodBeat.o(23724);
                        }
                    });
                    if (!post) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScan: mHandler.post failed!!!");
                    }
                    AppMethodBeat.o(23731);
                    return post;
                }

                private boolean g(int i2, j jVar) {
                    AppMethodBeat.i(23732);
                    if (jVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Error parameter: null == aCallback !!!");
                        AppMethodBeat.o(23732);
                        return false;
                    }
                    boolean Gz = a.Gz(i2);
                    if (!Gz) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                        try {
                            jVar.a(0, -1, "stopScanImp: mBTDeviceMrg.stopScan failed!!!", "", "", 0, null);
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopScanImp: aCallback.onScanCallback failed!!!, %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    if (!c(jVar)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistScanCallback failed!!!");
                    }
                    AppMethodBeat.o(23732);
                    return Gz;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final long[] cLa() {
                    AppMethodBeat.i(23733);
                    long[] cLa = a.cLa();
                    AppMethodBeat.o(23733);
                    return cLa;
                }

                private static boolean a(RemoteCallbackList remoteCallbackList, long j2, IInterface iInterface) {
                    AppMethodBeat.i(23734);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB, ID = %d", Long.valueOf(j2));
                    if (remoteCallbackList == null || iInterface == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
                        AppMethodBeat.o(23734);
                        return false;
                    }
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    do {
                        beginBroadcast--;
                        if (beginBroadcast < 0) {
                            break;
                        }
                    } while (!remoteCallbackList.getBroadcastItem(beginBroadcast).asBinder().equals(iInterface.asBinder()));
                    if (beginBroadcast < 0) {
                        Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Register a new process in callback list.");
                        HashMap hashMap = new HashMap();
                        hashMap.put(Long.valueOf(j2), iInterface);
                        remoteCallbackList.register(iInterface, hashMap);
                        remoteCallbackList.finishBroadcast();
                        AppMethodBeat.o(23734);
                        return true;
                    }
                    HashMap hashMap2 = (HashMap) remoteCallbackList.getBroadcastCookie(beginBroadcast);
                    if (hashMap2 == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
                        remoteCallbackList.finishBroadcast();
                        AppMethodBeat.o(23734);
                        return false;
                    }
                    hashMap2.put(Long.valueOf(j2), iInterface);
                    remoteCallbackList.finishBroadcast();
                    AppMethodBeat.o(23734);
                    return true;
                }

                private static boolean a(RemoteCallbackList remoteCallbackList, long j2, IInterface iInterface, int i2) {
                    AppMethodBeat.i(23735);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB, device id = %d, aCount = %d", Long.valueOf(j2), Integer.valueOf(i2));
                    if (remoteCallbackList == null || iInterface == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aCallbackList || null == aCallback");
                        AppMethodBeat.o(23735);
                        return false;
                    }
                    do {
                        i2--;
                        if (i2 < 0) {
                            break;
                        }
                    } while (!remoteCallbackList.getBroadcastItem(i2).asBinder().equals(iInterface.asBinder()));
                    if (i2 < 0) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Can not find callback in callback list");
                        AppMethodBeat.o(23735);
                        return false;
                    }
                    HashMap hashMap = (HashMap) remoteCallbackList.getBroadcastCookie(i2);
                    if (hashMap == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == map");
                        AppMethodBeat.o(23735);
                        return false;
                    } else if (((IInterface) hashMap.remove(Long.valueOf(j2))) == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find id in the map");
                        AppMethodBeat.o(23735);
                        return false;
                    } else if (!hashMap.isEmpty()) {
                        AppMethodBeat.o(23735);
                        return true;
                    } else {
                        Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "No id is in the map, unregister this process");
                        boolean unregister = remoteCallbackList.unregister(iInterface);
                        if (!unregister) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aCallbackList.unregister failed!!!");
                        }
                        AppMethodBeat.o(23735);
                        return unregister;
                    }
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean a(long j2, int i2, k kVar) {
                    AppMethodBeat.i(23736);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannel deviceId = %d, bluetoothVersion = %d", Long.valueOf(j2), Integer.valueOf(i2));
                    if (kVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == callback");
                        AppMethodBeat.o(23736);
                        return false;
                    } else if (j2 < 0) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j2));
                        AppMethodBeat.o(23736);
                        return false;
                    } else if (1 == i2 || i2 == 0) {
                        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(3, new j(j2, i2, kVar)))) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", 3);
                            AppMethodBeat.o(23736);
                            return false;
                        }
                        AppMethodBeat.o(23736);
                        return true;
                    } else {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i2));
                        AppMethodBeat.o(23736);
                        return false;
                    }
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean De(long j2) {
                    AppMethodBeat.i(23737);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannel deviceId = %d", Long.valueOf(j2));
                    if (j2 < 0) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j2));
                        AppMethodBeat.o(23737);
                        return false;
                    } else if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Long.valueOf(j2)))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! message what = %d", 4);
                        AppMethodBeat.o(23737);
                        return false;
                    } else {
                        AppMethodBeat.o(23737);
                        return true;
                    }
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean Df(long j2) {
                    return false;
                }

                private boolean b(long j2, p pVar) {
                    boolean z;
                    AppMethodBeat.i(23738);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTaskImp, task Id = %d", Long.valueOf(j2));
                    if (pVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
                        d(j2, -1, -1, "null == aTask");
                        AppMethodBeat.o(23738);
                        return false;
                    }
                    a aVar = this.rDY;
                    Log.i("MicroMsg.exdevice.BTDeviceManager", "startTask, taskId = %d", Long.valueOf(j2));
                    Assert.assertNotNull(pVar);
                    if (aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(8, new a.g(j2, pVar)))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startTask Failed ret = -1");
                        d(j2, -1, -1, "mBTDeviceMrg.startTask Failed!!!");
                        AppMethodBeat.o(23738);
                        return false;
                    } else if (!a(this.rEa, j2, pVar)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registerRemoteCB Fail!!!");
                        d(j2, -1, -1, "registerRemoteCB Fail!!!");
                        AppMethodBeat.o(23738);
                        return false;
                    } else {
                        AppMethodBeat.o(23738);
                        return true;
                    }
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final long a(p pVar) {
                    AppMethodBeat.i(23739);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startTask");
                    if (pVar == null) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "null == aTask");
                        AppMethodBeat.o(23739);
                        return -1;
                    }
                    l lVar = this.rEf;
                    if (MAlarmHandler.NEXT_FIRE_INTERVAL == lVar.rDg) {
                        Log.w("MicroMsg.TaskId", "TaskId Data-overrun!!!");
                        lVar.rDg = 0;
                    }
                    long j2 = lVar.rDg;
                    lVar.rDg = 1 + j2;
                    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(0, new k(j2, pVar)))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!! messsage what  = %d", 0);
                        AppMethodBeat.o(23739);
                        return -1;
                    }
                    AppMethodBeat.o(23739);
                    return j2;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean Dg(long j2) {
                    AppMethodBeat.i(23740);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask, task Id = %d", Long.valueOf(j2));
                    if (j2 < 0) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
                        AppMethodBeat.o(23740);
                        return false;
                    } else if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1, Long.valueOf(j2)))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage, message what = %d", 1);
                        AppMethodBeat.o(23740);
                        return false;
                    } else {
                        AppMethodBeat.o(23740);
                        return true;
                    }
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean a(i iVar) {
                    AppMethodBeat.i(23741);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registOnDeviceRequest");
                    boolean register = this.rEc.register(iVar);
                    if (!register) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.register Failed!!!");
                    }
                    AppMethodBeat.o(23741);
                    return register;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean b(i iVar) {
                    AppMethodBeat.i(23742);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegistOnDeviceRequest");
                    boolean unregister = this.rEc.unregister(iVar);
                    if (!unregister) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnDeviceReq.unregister Failed!!!");
                    }
                    AppMethodBeat.o(23742);
                    return unregister;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.g
                public final void a(int i2, int i3, String str, String str2, String str3, int i4, byte[] bArr) {
                    AppMethodBeat.i(23743);
                    int beginBroadcast = this.rEb.beginBroadcast();
                    for (int i5 = 0; i5 < beginBroadcast; i5++) {
                        try {
                            this.rEb.getBroadcastItem(i5).a(i2, i3, str, str2, str3, i4, bArr);
                            if (2 == i2 && !this.rEb.unregister(this.rEb.getBroadcastItem(i5))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mCBListOnScanCallback.unregister failed!!!");
                            }
                        } catch (RemoteException e2) {
                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception i = ".concat(String.valueOf(i5)));
                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                        }
                    }
                    this.rEb.finishBroadcast();
                    AppMethodBeat.o(23743);
                }

                private void d(long j2, int i2, int i3, String str) {
                    AppMethodBeat.i(23744);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEndImp taskId = %d, errType = %d, errCode =%d, errMsg = %s", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    int beginBroadcast = this.rEa.beginBroadcast();
                    p pVar = (p) a(j2, this.rEa, beginBroadcast);
                    if (pVar == null) {
                        Log.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By taskId = ".concat(String.valueOf(j2)));
                        this.rEa.finishBroadcast();
                        AppMethodBeat.o(23744);
                        return;
                    }
                    try {
                        pVar.cLr().a(j2, i2, i3, str, pVar);
                    } catch (RemoteException e2) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onTaskEnd Error!!!");
                        Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                    }
                    if (!a(this.rEa, j2, pVar, beginBroadcast)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unRegisterRemoteCB failed!!!");
                    }
                    this.rEa.finishBroadcast();
                    AppMethodBeat.o(23744);
                }

                @Override // com.tencent.mm.plugin.exdevice.service.g
                public final void c(long j2, int i2, int i3, String str) {
                    AppMethodBeat.i(23745);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onTaskEnd taskId = %d, errTpye = %d, errCode = %d, errMsg = %s", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    d dVar = new d();
                    dVar.rDg = j2;
                    dVar.rxH = i2;
                    dVar.rxv = i3;
                    dVar.lAr = str;
                    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(2, dVar))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, MessageWhat = %d", 2);
                    }
                    AppMethodBeat.o(23745);
                }

                @Override // com.tencent.mm.plugin.exdevice.service.g
                public final void a(int i2, long j2, short s, short s2, byte[] bArr) {
                    AppMethodBeat.i(23746);
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = Long.valueOf(j2);
                    objArr[2] = Short.valueOf(s);
                    objArr[3] = Short.valueOf(s2);
                    objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d", objArr);
                    b bVar = new b((byte) 0);
                    bVar.rDd = s2;
                    bVar.rxw = bArr;
                    bVar.pkb = j2;
                    bVar.rxC = s;
                    bVar.mErrorCode = i2;
                    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(6, bVar))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 6);
                    }
                    AppMethodBeat.o(23746);
                }

                @Override // com.tencent.mm.plugin.exdevice.service.g
                public final void a(long j2, int i2, int i3, int i4) {
                    AppMethodBeat.i(23747);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChange deviceId = " + j2 + " oldState" + i2 + " newState = " + i3 + " errCode = " + i4);
                    c cVar = new c((byte) 0);
                    cVar.pkb = j2;
                    cVar.rDe = i2;
                    cVar.rDf = i3;
                    cVar.rxv = i4;
                    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(5, cVar))) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, messagewhat = %d", 5);
                    }
                    AppMethodBeat.o(23747);
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final void setChannelSessionKey(long j2, byte[] bArr) {
                    AppMethodBeat.i(23748);
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "---setChannelSessionKey--- deviceId = %d", Long.valueOf(j2));
                    a aVar = this.rDY;
                    Log.i("MicroMsg.exdevice.BTDeviceManager", "------setChannelSessionKey------ deviceId = %d", Long.valueOf(j2));
                    if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(10, new a.f(j2, bArr)))) {
                        Log.e("MicroMsg.exdevice.BTDeviceManager", "mHandler.sendMessage failed!!! messageWhat = %d", 10);
                    }
                    AppMethodBeat.o(23748);
                }

                @Override // com.tencent.mm.plugin.exdevice.service.h
                public final boolean a(String str, boolean z, q qVar) {
                    boolean post;
                    AppMethodBeat.i(23749);
                    if (Build.VERSION.SDK_INT < 18 || this.rEh == null) {
                        AppMethodBeat.o(23749);
                        return false;
                    }
                    boolean hasSystemFeature = MMApplicationContext.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (!hasSystemFeature || defaultAdapter == null) {
                        AppMethodBeat.o(23749);
                        return false;
                    }
                    Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
                    if (!this.rEd.register(qVar)) {
                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.register failed!!!");
                        AppMethodBeat.o(23749);
                        return false;
                    }
                    try {
                        UUID fromString = UUID.fromString(str);
                        com.tencent.mm.plugin.d.a.a.f fVar = this.rEh;
                        com.tencent.mm.plugin.d.a.a.f.pfV = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).getBoolean("isNewScanning", false);
                        Object[] objArr = new Object[2];
                        objArr[0] = fromString == null ? "" : fromString.toString();
                        objArr[1] = String.valueOf(z);
                        Log.d("MicroMsg.exdevice.IBeaconServer", "Ranging, uuid = %s, op = %s", objArr);
                        if (fromString == null) {
                            Log.e("MicroMsg.exdevice.IBeaconServer", "error parameter: aUUID is null");
                            post = false;
                        } else if (z) {
                            post = fVar.mHandler.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c9: INVOKE  (r0v22 'post' boolean) = 
                                  (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x00c2: IGET  (r0v21 com.tencent.mm.sdk.platformtools.MMHandler) = (r4v2 'fVar' com.tencent.mm.plugin.d.a.a.f) com.tencent.mm.plugin.d.a.a.f.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
                                  (wrap: com.tencent.mm.plugin.d.a.a.f$6 : 0x00c6: CONSTRUCTOR  (r5v5 com.tencent.mm.plugin.d.a.a.f$6) = (r4v2 'fVar' com.tencent.mm.plugin.d.a.a.f), (r3v5 'fromString' java.util.UUID) call: com.tencent.mm.plugin.d.a.a.f.6.<init>(com.tencent.mm.plugin.d.a.a.f, java.util.UUID):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.exdevice.service.y.a(java.lang.String, boolean, com.tencent.mm.plugin.exdevice.service.q):boolean, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c6: CONSTRUCTOR  (r5v5 com.tencent.mm.plugin.d.a.a.f$6) = (r4v2 'fVar' com.tencent.mm.plugin.d.a.a.f), (r3v5 'fromString' java.util.UUID) call: com.tencent.mm.plugin.d.a.a.f.6.<init>(com.tencent.mm.plugin.d.a.a.f, java.util.UUID):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.service.y.a(java.lang.String, boolean, com.tencent.mm.plugin.exdevice.service.q):boolean, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 38 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.d.a.a.f, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 44 more
                                */
                            /*
                            // Method dump skipped, instructions count: 250
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.service.y.a(java.lang.String, boolean, com.tencent.mm.plugin.exdevice.service.q):boolean");
                        }

                        @Override // com.tencent.mm.plugin.d.a.a.b
                        public final void a(double d2, com.tencent.mm.plugin.d.a.a.c cVar) {
                            AppMethodBeat.i(23750);
                            if (cVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "aContext is null");
                                AppMethodBeat.o(23750);
                                return;
                            }
                            com.tencent.mm.plugin.d.a.a.h hVar = cVar.pfM.pfQ;
                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onRangingCallback, distance = %f, uuid = %s, major = %d, minor = %d ,minor&0xFFFF = %d", Double.valueOf(d2), com.tencent.mm.plugin.exdevice.k.b.bw(hVar.pgr), Short.valueOf(hVar.pgs), Short.valueOf(hVar.pgt), Integer.valueOf(hVar.pgt & ISelectionInterface.HELD_NOTHING));
                            try {
                                int beginBroadcast = this.rEd.beginBroadcast();
                                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                                    try {
                                        this.rEd.getBroadcastItem(i2).a(d2, hVar.pgs, hVar.pgt, hVar.pgr, cVar.pfN, cVar.pfM.pfQ.pgu, cVar.dfJ);
                                    } catch (RemoteException e2) {
                                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIBeaconCallback.getBroadcastItem failed!!!, i = %d, (%s)", Integer.valueOf(i2), e2.toString());
                                        Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                    }
                                }
                            } catch (Exception e3) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "[shakezb] beginBroadcast fail!", e3.toString());
                                Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e3, "", new Object[0]);
                            } finally {
                                this.rEd.finishBroadcast();
                                AppMethodBeat.o(23750);
                            }
                        }

                        @Override // com.tencent.mm.plugin.d.a.d.a.AbstractC0940a
                        public final void CM(int i2) {
                            AppMethodBeat.i(23751);
                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "OnBluetoothStateChange, state = %d", Integer.valueOf(i2));
                            for (int beginBroadcast = this.rEe.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("key_state", i2);
                                try {
                                    this.rEe.getBroadcastItem(beginBroadcast).n(0, bundle);
                                } catch (RemoteException e2) {
                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.getBroadcastItem(%d).onExdeviceInvoke failed!!!", Integer.valueOf(beginBroadcast));
                                    Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                }
                            }
                            this.rEe.finishBroadcast();
                            AppMethodBeat.o(23751);
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final void a(n nVar) {
                            AppMethodBeat.i(23752);
                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registExDeviceInvokerHandler");
                            if (!this.rEe.register(nVar)) {
                                Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListIExDeviceInvoker.register failed!!!");
                            }
                            AppMethodBeat.o(23752);
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean d(int i2, j jVar) {
                            boolean a2;
                            AppMethodBeat.i(23753);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothScan. bluetoothVersion=%d", Integer.valueOf(i2));
                            if (jVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "scan callback is null. just return");
                                AppMethodBeat.o(23753);
                                return false;
                            } else if (i2 != 0) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "this is not ble scan cmd");
                                AppMethodBeat.o(23753);
                                return false;
                            } else {
                                boolean register = this.rEj.register(jVar);
                                if (register) {
                                    Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback ok");
                                } else {
                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "regist simple ble scan callback fail");
                                }
                                if (this.rEn != null) {
                                    com.tencent.mm.plugin.d.a.b.e eVar = this.rEn;
                                    Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble scan");
                                    Assert.assertTrue(eVar.pgE != null);
                                    if (!eVar.ckE()) {
                                        Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                                        a2 = false;
                                    } else {
                                        a2 = eVar.pgE.a(true, eVar.pgH);
                                        if (a2) {
                                            eVar.phk.clear();
                                        }
                                    }
                                    if (!a2) {
                                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simple ble scan fail");
                                        try {
                                            jVar.a(0, -1, "simpleBLE.scan failed!!!", "", "", 0, null);
                                        } catch (RemoteException e2) {
                                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.scan callback failed!!!, %s", e2.getMessage());
                                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                        }
                                        if (register) {
                                            this.rEj.unregister(jVar);
                                        }
                                        AppMethodBeat.o(23753);
                                        return false;
                                    }
                                }
                                AppMethodBeat.o(23753);
                                return true;
                            }
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean e(int i2, j jVar) {
                            boolean a2;
                            AppMethodBeat.i(23754);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBlutoothStopScan. bluetoothVersion=%d", Integer.valueOf(i2));
                            if (jVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan callback is null. just return");
                                AppMethodBeat.o(23754);
                                return false;
                            } else if (this.rEn == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stop scan mBLESimpleMgr is null. just return");
                                AppMethodBeat.o(23754);
                                return false;
                            } else {
                                com.tencent.mm.plugin.d.a.b.e eVar = this.rEn;
                                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "simple ble stop scan");
                                Assert.assertTrue(eVar.pgE != null);
                                if (!eVar.ckE()) {
                                    Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                                    a2 = false;
                                } else {
                                    eVar.mHandler.removeCallbacks(eVar.mRunnable);
                                    a2 = eVar.pgE.a(false, eVar.pgH);
                                }
                                if (!a2) {
                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopScan Failed!!!");
                                    try {
                                        jVar.a(0, -1, "simpleBLE.stopScan failed!!!", "", "", 0, null);
                                    } catch (RemoteException e2) {
                                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBLE.onScanCallback failed!!!, %s", e2.getMessage());
                                        Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                    }
                                }
                                AppMethodBeat.o(23754);
                                return a2;
                            }
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean b(long j2, int i2, k kVar) {
                            AppMethodBeat.i(23755);
                            if (kVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
                                AppMethodBeat.o(23755);
                                return false;
                            } else if (j2 < 0) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j2));
                                AppMethodBeat.o(23755);
                                return false;
                            } else if (i2 != 0) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid bluetooth version = %d", Integer.valueOf(i2));
                                AppMethodBeat.o(23755);
                                return false;
                            } else {
                                e eVar = new e((byte) 0);
                                eVar.rAt = j2;
                                eVar.rEr = i2;
                                eVar.rEs = kVar;
                                if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(7, eVar))) {
                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 7);
                                    AppMethodBeat.o(23755);
                                    return false;
                                }
                                AppMethodBeat.o(23755);
                                return true;
                            }
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean Dh(long j2) {
                            AppMethodBeat.i(23756);
                            if (j2 < 0) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Invalid device id = %d", Long.valueOf(j2));
                                AppMethodBeat.o(23756);
                                return false;
                            } else if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(8, Long.valueOf(j2)))) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 8);
                                AppMethodBeat.o(23756);
                                return false;
                            } else {
                                AppMethodBeat.o(23756);
                                return true;
                            }
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean a(s sVar) {
                            AppMethodBeat.i(23757);
                            if (sVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
                                AppMethodBeat.o(23757);
                                return false;
                            }
                            boolean register = this.rEl.register(sVar);
                            if (!register) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBluetoothRegistOnRecv error");
                            }
                            AppMethodBeat.o(23757);
                            return register;
                        }

                        @Override // com.tencent.mm.plugin.exdevice.service.h
                        public final boolean b(long j2, byte[] bArr, t tVar) {
                            AppMethodBeat.i(23758);
                            if (0 > j2) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mac < 0");
                                AppMethodBeat.o(23758);
                                return false;
                            } else if (bArr == null || bArr.length <= 0) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "data is empty");
                                AppMethodBeat.o(23758);
                                return false;
                            } else if (tVar == null) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback is null");
                                AppMethodBeat.o(23758);
                                return false;
                            } else {
                                i iVar = new i((byte) 0);
                                iVar.rAt = j2;
                                iVar.mData = bArr;
                                iVar.rEv = tVar;
                                if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(10, iVar))) {
                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mHandler.sendMessage failed!!!, message what = %d", 10);
                                    AppMethodBeat.o(23758);
                                    return false;
                                }
                                AppMethodBeat.o(23758);
                                return true;
                            }
                        }

                        public final boolean c(long j2, int i2, k kVar) {
                            boolean z;
                            AppMethodBeat.i(23759);
                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTConnectImpl. mac=%d, bTVersion=%d", Long.valueOf(j2), Integer.valueOf(i2));
                            if (!a(this.rEk, j2, kVar)) {
                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register connect callback error");
                                try {
                                    kVar.a(j2, -1, 4, -1, 0);
                                } catch (RemoteException e2) {
                                    Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                }
                                AppMethodBeat.o(23759);
                                return false;
                            }
                            try {
                                kVar.a(j2, -1, 1, -1, 0);
                            } catch (RemoteException e3) {
                                Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e3, "", new Object[0]);
                            }
                            if (this.rEn != null) {
                                com.tencent.mm.plugin.d.a.b.e eVar = this.rEn;
                                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "connect. mac = %d", Long.valueOf(j2));
                                if (!eVar.ckE()) {
                                    Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                                    z = false;
                                } else {
                                    com.tencent.mm.plugin.d.a.b.f fVar = eVar.pgC.get(Long.valueOf(j2));
                                    if (fVar != null) {
                                        Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "session(mac=%s) has been in map");
                                        z = fVar.connect();
                                    } else {
                                        com.tencent.mm.plugin.d.a.b.f fVar2 = new com.tencent.mm.plugin.d.a.b.f(j2, eVar.mAppContext, eVar.phm);
                                        if (fVar2.connect()) {
                                            eVar.ai(
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00de: INVOKE  
                                                  (r1v3 'eVar' com.tencent.mm.plugin.d.a.b.e)
                                                  (wrap: com.tencent.mm.plugin.d.a.b.e$4 : 0x00db: CONSTRUCTOR  (r2v7 com.tencent.mm.plugin.d.a.b.e$4) = (r1v3 'eVar' com.tencent.mm.plugin.d.a.b.e), (r12v0 'j2' long), (r0v12 'fVar2' com.tencent.mm.plugin.d.a.b.f) call: com.tencent.mm.plugin.d.a.b.e.4.<init>(com.tencent.mm.plugin.d.a.b.e, long, com.tencent.mm.plugin.d.a.b.f):void type: CONSTRUCTOR)
                                                 type: VIRTUAL call: com.tencent.mm.plugin.d.a.b.e.ai(java.lang.Runnable):void in method: com.tencent.mm.plugin.exdevice.service.y.c(long, int, com.tencent.mm.plugin.exdevice.service.k):boolean, file: classes8.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00db: CONSTRUCTOR  (r2v7 com.tencent.mm.plugin.d.a.b.e$4) = (r1v3 'eVar' com.tencent.mm.plugin.d.a.b.e), (r12v0 'j2' long), (r0v12 'fVar2' com.tencent.mm.plugin.d.a.b.f) call: com.tencent.mm.plugin.d.a.b.e.4.<init>(com.tencent.mm.plugin.d.a.b.e, long, com.tencent.mm.plugin.d.a.b.f):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.service.y.c(long, int, com.tencent.mm.plugin.exdevice.service.k):boolean, file: classes8.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 38 more
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.d.a.b.e, state: GENERATED_AND_UNLOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	... 44 more
                                                */
                                            /*
                                            // Method dump skipped, instructions count: 257
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.service.y.c(long, int, com.tencent.mm.plugin.exdevice.service.k):boolean");
                                        }

                                        public final boolean c(long j2, byte[] bArr, t tVar) {
                                            boolean sendMessage;
                                            AppMethodBeat.i(23760);
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTSendDataImpl. mac=%d, data=%s", Long.valueOf(j2), com.tencent.mm.plugin.exdevice.k.b.bw(bArr));
                                            if (this.rEn != null) {
                                                com.tencent.mm.plugin.d.a.b.e eVar = this.rEn;
                                                Log.d("MicroMsg.exdevice.BluetoothLESimpleManager", "writeData. mac = %d", Long.valueOf(j2));
                                                if (!eVar.ckE()) {
                                                    Log.e("MicroMsg.exdevice.BluetoothLESimpleManager", "BLE Unsupport");
                                                    sendMessage = false;
                                                } else {
                                                    com.tencent.mm.plugin.d.a.b.f fVar = eVar.pgC.get(Long.valueOf(j2));
                                                    if (fVar == null) {
                                                        Log.w("MicroMsg.exdevice.BluetoothLESimpleManager", "session is null, may be this session is closed");
                                                        sendMessage = false;
                                                    } else {
                                                        Log.i("MicroMsg.exdevice.BluetoothLESimpleSession", "------writeData------parserobj, length = %d, mac=%s, name=%s", Integer.valueOf(bArr.length), com.tencent.mm.plugin.exdevice.k.b.Dj(fVar.mSessionId), fVar.lOM.getName());
                                                        sendMessage = fVar.mHandler.sendMessage(fVar.mHandler.obtainMessage(3, bArr));
                                                    }
                                                }
                                                if (!sendMessage) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "writeData error");
                                                    if (tVar != null) {
                                                        try {
                                                            tVar.b(j2, -1, -1, "start write data error");
                                                        } catch (RemoteException e2) {
                                                            Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                        }
                                                    }
                                                    AppMethodBeat.o(23760);
                                                    return false;
                                                }
                                            }
                                            if (!a(this.rEm, j2, tVar)) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "register on send end callback error");
                                                AppMethodBeat.o(23760);
                                                return false;
                                            }
                                            AppMethodBeat.o(23760);
                                            return true;
                                        }

                                        public final boolean b(long j2, int i2, int i3, int i4, long j3) {
                                            AppMethodBeat.i(23761);
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSateChangeImpl. mac=%d, oldstate = %d, newsate=%d, errcode=%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                                            k kVar = (k) a(j2, this.rEk, this.rEk.beginBroadcast());
                                            if (kVar == null) {
                                                Log.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j2)));
                                                this.rEk.finishBroadcast();
                                                AppMethodBeat.o(23761);
                                                return false;
                                            }
                                            try {
                                                kVar.a(j2, i2, i3, i4, j3);
                                                this.rEk.finishBroadcast();
                                                AppMethodBeat.o(23761);
                                                return true;
                                            } catch (RemoteException e2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
                                                Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                this.rEk.finishBroadcast();
                                                AppMethodBeat.o(23761);
                                                return false;
                                            } catch (Throwable th) {
                                                this.rEk.finishBroadcast();
                                                AppMethodBeat.o(23761);
                                                throw th;
                                            }
                                        }

                                        public final boolean e(long j2, int i2, int i3, String str) {
                                            AppMethodBeat.i(23762);
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnSendEndImpl. mac=%d, errType = %d, errCode=%d, errMsg=%s", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str);
                                            t tVar = (t) a(j2, this.rEm, this.rEm.beginBroadcast());
                                            if (tVar == null) {
                                                Log.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j2)));
                                                this.rEm.finishBroadcast();
                                                AppMethodBeat.o(23762);
                                                return false;
                                            }
                                            try {
                                                tVar.b(j2, i2, i3, str);
                                                return true;
                                            } catch (RemoteException e2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onSendEnd Failed!!!");
                                                Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                return false;
                                            } finally {
                                                this.rEm.finishBroadcast();
                                                AppMethodBeat.o(23762);
                                            }
                                        }

                                        public final boolean d(long j2, byte[] bArr) {
                                            AppMethodBeat.i(23763);
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Long.valueOf(j2);
                                            objArr[1] = bArr == null ? BuildConfig.COMMAND : com.tencent.mm.plugin.exdevice.k.b.bw(bArr);
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnRecvImpl. mac=%d, data = %s", objArr);
                                            int beginBroadcast = this.rEl.beginBroadcast();
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "SimpleOnRecvList size = %d", Integer.valueOf(beginBroadcast));
                                            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                                                try {
                                                    s broadcastItem = this.rEl.getBroadcastItem(i2);
                                                    if (broadcastItem != null) {
                                                        broadcastItem.c(j2, bArr);
                                                    } else {
                                                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "ISimpleBTOnRecv_AIDL callback is null");
                                                    }
                                                } catch (RemoteException e2) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onDataRecv Failed!!!");
                                                    Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                    this.rEl.finishBroadcast();
                                                } catch (Throwable th) {
                                                    this.rEl.finishBroadcast();
                                                    AppMethodBeat.o(23763);
                                                    throw th;
                                                }
                                            }
                                            this.rEl.finishBroadcast();
                                            AppMethodBeat.o(23763);
                                            return true;
                                        }

                                        static /* synthetic */ boolean a(y yVar, long j2) {
                                            AppMethodBeat.i(23766);
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTaskImp, task id = %d", Long.valueOf(j2));
                                            if (j2 < 0) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "taskId < 0");
                                                AppMethodBeat.o(23766);
                                                return false;
                                            }
                                            int beginBroadcast = yVar.rEa.beginBroadcast();
                                            p pVar = (p) a(j2, yVar.rEa, beginBroadcast);
                                            if (pVar == null) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopTask Failed, Cannot find such netCmd in RemoteCallbackList");
                                                yVar.rEa.finishBroadcast();
                                                AppMethodBeat.o(23766);
                                                return false;
                                            }
                                            a aVar = yVar.rDY;
                                            Log.i("MicroMsg.exdevice.BTDeviceManager", "stopTask taskId = %d", Long.valueOf(j2));
                                            aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(9, Long.valueOf(j2)));
                                            boolean a2 = a(yVar.rEa, j2, pVar, beginBroadcast);
                                            if (!a2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListTask.unregister Failed!!!");
                                            }
                                            yVar.rEa.finishBroadcast();
                                            AppMethodBeat.o(23766);
                                            return a2;
                                        }

                                        static /* synthetic */ void a(y yVar, long j2, int i2, int i3, int i4) {
                                            AppMethodBeat.i(23767);
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onStateChangeImp deviceId = " + j2 + " oldState" + i2 + " newState = " + i3 + " errCode = " + i4);
                                            k kVar = (k) a(j2, yVar.rDZ, yVar.rDZ.beginBroadcast());
                                            if (kVar == null) {
                                                Log.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "Cannot find Callback By deviceId = ".concat(String.valueOf(j2)));
                                                yVar.rDZ.finishBroadcast();
                                                AppMethodBeat.o(23767);
                                                return;
                                            }
                                            try {
                                                kVar.a(j2, i2, i3, i4, 0);
                                            } catch (RemoteException e2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "callback.onStateChange Failed!!!");
                                                Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                            }
                                            yVar.rDZ.finishBroadcast();
                                            AppMethodBeat.o(23767);
                                        }

                                        static /* synthetic */ boolean a(y yVar, long j2, int i2, k kVar) {
                                            AppMethodBeat.i(23768);
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "startChannelImp deviceId = %d, bluetoothVersion = %d", Long.valueOf(j2), Integer.valueOf(i2));
                                            Assert.assertNotNull(kVar);
                                            v cLz = v.cLz();
                                            Log.i("MicroMsg.exdevice.MMExDevicePushCore", "insertDeviceIdAndBluetoothVersion aDeviceId = %d, aBluetoothVersion = %d", Long.valueOf(j2), Integer.valueOf(i2));
                                            cLz.rDW.put(Long.valueOf(j2), Integer.valueOf(i2));
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange, deviceId = %d", Long.valueOf(j2));
                                            boolean a2 = a(yVar.rDZ, j2, kVar);
                                            if (!a2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnStateChange.register Failed!!!");
                                            }
                                            if (!a2) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "registChannelStateChange Failed!!!");
                                                yVar.a(j2, 1, 4, -1);
                                                AppMethodBeat.o(23768);
                                                return false;
                                            }
                                            a aVar = yVar.rDY;
                                            Log.i("MicroMsg.exdevice.BTDeviceManager", "startChannel deviceId = %d", Long.valueOf(j2));
                                            if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(11, Long.valueOf(j2)))) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.startChannel Failed!!!");
                                                Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange, deviceId = %d", Long.valueOf(j2));
                                                boolean a3 = a(yVar.rDZ, j2, kVar, yVar.rDZ.beginBroadcast());
                                                if (!a3) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mCBListOnScanCallback.unregister Failed!!!");
                                                }
                                                yVar.rDZ.finishBroadcast();
                                                if (!a3) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "unregistChannelStateChange");
                                                }
                                                yVar.a(j2, 1, 4, -1);
                                                AppMethodBeat.o(23768);
                                                return false;
                                            }
                                            AppMethodBeat.o(23768);
                                            return true;
                                        }

                                        static /* synthetic */ boolean b(y yVar, long j2) {
                                            AppMethodBeat.i(23769);
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "stopChannelImp deviceId = %d", Long.valueOf(j2));
                                            a aVar = yVar.rDY;
                                            Log.i("MicroMsg.exdevice.BTDeviceManager", "stopChannel deviceId = ".concat(String.valueOf(j2)));
                                            if (!aVar.mHandler.sendMessage(aVar.mHandler.obtainMessage(12, Long.valueOf(j2)))) {
                                                Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "mBTDeviceMrg.stopChannel Failed!!!");
                                                AppMethodBeat.o(23769);
                                                return false;
                                            }
                                            AppMethodBeat.o(23769);
                                            return true;
                                        }

                                        static /* synthetic */ void a(y yVar, int i2, long j2, short s, short s2, byte[] bArr) {
                                            AppMethodBeat.i(23770);
                                            Object[] objArr = new Object[5];
                                            objArr[0] = Integer.valueOf(i2);
                                            objArr[1] = Long.valueOf(j2);
                                            objArr[2] = Short.valueOf(s);
                                            objArr[3] = Short.valueOf(s2);
                                            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                            Log.i("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequestImp errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, data length = %d", objArr);
                                            int beginBroadcast = yVar.rEc.beginBroadcast();
                                            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                                                try {
                                                    i broadcastItem = yVar.rEc.getBroadcastItem(i3);
                                                    if (broadcastItem != null) {
                                                        broadcastItem.a(i2, j2, s, s2, bArr);
                                                    } else {
                                                        Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "get req callback failed, cmdId = %d", Short.valueOf(s2));
                                                    }
                                                } catch (Exception e2) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onDeviceRequest Failed!!! i = ".concat(String.valueOf(i3)));
                                                    Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                }
                                            }
                                            yVar.rEc.finishBroadcast();
                                            AppMethodBeat.o(23770);
                                        }

                                        static /* synthetic */ void a(y yVar, g gVar) {
                                            AppMethodBeat.i(23771);
                                            int beginBroadcast = yVar.rEj.beginBroadcast();
                                            Log.d("MicroMsg.exdevice.RemoteBTDeviceAdapter", "simpleBTOnDiscoverCallback size=%d", Integer.valueOf(beginBroadcast));
                                            if (beginBroadcast <= 0) {
                                                Log.w("MicroMsg.exdevice.RemoteBTDeviceAdapter", "no simpleBTOnDiscoverCallback");
                                            }
                                            for (int i2 = 0; i2 < beginBroadcast; i2++) {
                                                try {
                                                    if (gVar.rEt) {
                                                        yVar.rEj.getBroadcastItem(i2).a(2, 0, "scan finish", null, null, 0, null);
                                                        if (!yVar.rEj.unregister(yVar.rEj.getBroadcastItem(i2))) {
                                                            Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback: mSimpleOnScanCallbackList.unregister failed!!!");
                                                        }
                                                    } else {
                                                        yVar.rEj.getBroadcastItem(i2).a(1, 0, "discover device", gVar.pkf, gVar.mDeviceName, gVar.lOO, gVar.rEu);
                                                    }
                                                } catch (RemoteException e2) {
                                                    Log.e("MicroMsg.exdevice.RemoteBTDeviceAdapter", "onScanCallback Exception: " + e2.toString());
                                                    Log.printErrStackTrace("MicroMsg.exdevice.RemoteBTDeviceAdapter", e2, "", new Object[0]);
                                                    yVar.rEj.finishBroadcast();
                                                    AppMethodBeat.o(23771);
                                                    return;
                                                } catch (Throwable th) {
                                                    yVar.rEj.finishBroadcast();
                                                    AppMethodBeat.o(23771);
                                                    throw th;
                                                }
                                            }
                                            yVar.rEj.finishBroadcast();
                                            AppMethodBeat.o(23771);
                                        }
                                    }
