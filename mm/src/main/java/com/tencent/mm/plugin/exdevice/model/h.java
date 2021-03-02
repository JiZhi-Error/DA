package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.exdevice.k.b;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.j;
import com.tencent.mm.plugin.exdevice.service.k;
import com.tencent.mm.plugin.exdevice.service.s;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class h extends s.a {
    protected static final String TAG = h.class.getName();
    private boolean rzT = false;
    f rzU = new f();
    private j.a rzV = new j.a() {
        /* class com.tencent.mm.plugin.exdevice.model.h.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.exdevice.service.j
        public final void a(int i2, int i3, String str, String str2, String str3, int i4, byte[] bArr) {
            AppMethodBeat.i(23343);
            Log.d(h.TAG, "onScanCallback. messageType=%d, errCode=%d, errMsg=%s, deviceMac=%s, deviceName=%s, rssi=%d, advertisment=%s", Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4), b.bw(bArr));
            if (1 == i2) {
                ad.cKW().o(str3, str2, false);
            } else if (2 == i2) {
                ad.cKW().o(str3, str2, true);
            } else {
                Log.e(h.TAG, "unknown message type %d", Integer.valueOf(i2));
            }
            if (ad.cKL().Di(b.anY(str2)) != null) {
                Log.d(h.TAG, "the founded device hasn't been binded");
            }
            AppMethodBeat.o(23343);
        }
    };

    public interface a {
        void a(long j2, int i2, int i3, int i4, long j3);
    }

    public h() {
        AppMethodBeat.i(23345);
        AppMethodBeat.o(23345);
    }

    static {
        AppMethodBeat.i(23352);
        AppMethodBeat.o(23352);
    }

    public final void cKB() {
        AppMethodBeat.i(23346);
        if (this.rzT) {
            Log.d(TAG, "still scanning. return");
            AppMethodBeat.o(23346);
            return;
        }
        d cKS = ad.cKS();
        j.a aVar = this.rzV;
        Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTScan");
        if (cKS.rxY == null) {
            cKS.rxY = new c();
            cKS.rxY.rDx = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: IPUT  
                  (wrap: com.tencent.mm.plugin.exdevice.model.d$2 : 0x0033: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.exdevice.model.d$2) = (r0v1 'cKS' com.tencent.mm.plugin.exdevice.model.d), (r1v0 'aVar' com.tencent.mm.plugin.exdevice.service.j$a) call: com.tencent.mm.plugin.exdevice.model.d.2.<init>(com.tencent.mm.plugin.exdevice.model.d, com.tencent.mm.plugin.exdevice.service.j):void type: CONSTRUCTOR)
                  (wrap: com.tencent.mm.plugin.exdevice.service.c : 0x002f: IGET  (r2v4 com.tencent.mm.plugin.exdevice.service.c) = (r0v1 'cKS' com.tencent.mm.plugin.exdevice.model.d) com.tencent.mm.plugin.exdevice.model.d.rxY com.tencent.mm.plugin.exdevice.service.c)
                 com.tencent.mm.plugin.exdevice.service.c.rDx com.tencent.mm.plugin.exdevice.service.c$a in method: com.tencent.mm.plugin.exdevice.model.h.cKB():void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.exdevice.model.d$2) = (r0v1 'cKS' com.tencent.mm.plugin.exdevice.model.d), (r1v0 'aVar' com.tencent.mm.plugin.exdevice.service.j$a) call: com.tencent.mm.plugin.exdevice.model.d.2.<init>(com.tencent.mm.plugin.exdevice.model.d, com.tencent.mm.plugin.exdevice.service.j):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.model.h.cKB():void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 23 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.d, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
            // Method dump skipped, instructions count: 121
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.h.cKB():void");
        }

        public final void stopScan() {
            AppMethodBeat.i(23347);
            if (!this.rzT) {
                Log.d(TAG, "not yet scan. return");
                AppMethodBeat.o(23347);
                return;
            }
            d cKS = ad.cKS();
            j.a aVar = this.rzV;
            Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTStopScan");
            if (cKS.rxY == null) {
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.cLy().rxT == null) {
                Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.cLy().rxT.b(aVar)) {
                Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.rzT = false;
            AppMethodBeat.o(23347);
        }

        public final void a(long j2, final a aVar) {
            AppMethodBeat.i(23348);
            f.a CZ = this.rzU.CZ(j2);
            if (CZ == null || 2 != CZ.dHO) {
                d cKS = ad.cKS();
                AnonymousClass2 r1 = new k.a() {
                    /* class com.tencent.mm.plugin.exdevice.model.h.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.exdevice.service.k
                    public final void a(long j2, int i2, int i3, int i4, long j3) {
                        AppMethodBeat.i(23344);
                        Log.d(h.TAG, "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3));
                        f.a CZ = h.this.rzU.CZ(j2);
                        if (CZ != null) {
                            CZ.dHO = i3;
                            CZ.phx = j3;
                        } else {
                            Log.i(h.TAG, "get connect state faild : %d", Long.valueOf(j2));
                        }
                        aVar.a(j2, i2, i3, i4, j3);
                        AppMethodBeat.o(23344);
                    }
                };
                Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTConnect");
                if (cKS.rxY == null) {
                    cKS.rxY = new c();
                    cKS.rxY.rDx = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: IPUT  
                          (wrap: com.tencent.mm.plugin.exdevice.model.d$3 : 0x005c: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.exdevice.model.d$3) = 
                          (r0v2 'cKS' com.tencent.mm.plugin.exdevice.model.d)
                          (r10v0 'j2' long)
                          (r1v0 'r1' com.tencent.mm.plugin.exdevice.model.h$2)
                         call: com.tencent.mm.plugin.exdevice.model.d.3.<init>(com.tencent.mm.plugin.exdevice.model.d, long, com.tencent.mm.plugin.exdevice.service.k):void type: CONSTRUCTOR)
                          (wrap: com.tencent.mm.plugin.exdevice.service.c : 0x0058: IGET  (r2v4 com.tencent.mm.plugin.exdevice.service.c) = (r0v2 'cKS' com.tencent.mm.plugin.exdevice.model.d) com.tencent.mm.plugin.exdevice.model.d.rxY com.tencent.mm.plugin.exdevice.service.c)
                         com.tencent.mm.plugin.exdevice.service.c.rDx com.tencent.mm.plugin.exdevice.service.c$a in method: com.tencent.mm.plugin.exdevice.model.h.a(long, com.tencent.mm.plugin.exdevice.model.h$a):void, file: classes8.dex
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
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.exdevice.model.d$3) = 
                          (r0v2 'cKS' com.tencent.mm.plugin.exdevice.model.d)
                          (r10v0 'j2' long)
                          (r1v0 'r1' com.tencent.mm.plugin.exdevice.model.h$2)
                         call: com.tencent.mm.plugin.exdevice.model.d.3.<init>(com.tencent.mm.plugin.exdevice.model.d, long, com.tencent.mm.plugin.exdevice.service.k):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.model.h.a(long, com.tencent.mm.plugin.exdevice.model.h$a):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 28 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.d, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 32 more
                        */
                    /*
                    // Method dump skipped, instructions count: 146
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.h.a(long, com.tencent.mm.plugin.exdevice.model.h$a):void");
                }

                public static void CM(long j2) {
                    AppMethodBeat.i(23349);
                    d cKS = ad.cKS();
                    Log.d("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBTDisconnect");
                    if (cKS.rxY == null) {
                        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
                        AppMethodBeat.o(23349);
                    } else if (u.cLy().rxT == null) {
                        Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
                        AppMethodBeat.o(23349);
                    } else {
                        if (!u.cLy().rxT.Dh(j2)) {
                            Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "simpleBluetoothDisconnect failed!!!");
                        }
                        AppMethodBeat.o(23349);
                    }
                }

                public static boolean a(long j2, byte[] bArr, t tVar) {
                    boolean z = false;
                    AppMethodBeat.i(23350);
                    if (bArr == null || bArr.length <= 0) {
                        Log.e(TAG, "no data for transmit");
                        AppMethodBeat.o(23350);
                    } else if (u.cLy().rxT == null) {
                        Log.e(TAG, "can not send data");
                        AppMethodBeat.o(23350);
                    } else {
                        z = u.cLy().rxT.b(j2, bArr, tVar);
                        if (!z) {
                            Log.e(TAG, "simpleBluetoothSendData error");
                        }
                        AppMethodBeat.o(23350);
                    }
                    return z;
                }

                @Override // com.tencent.mm.plugin.exdevice.service.s
                public final void c(long j2, byte[] bArr) {
                    LinkedList<e.b> linkedList;
                    AppMethodBeat.i(23351);
                    if (bArr == null || bArr.length <= 0) {
                        Log.e(TAG, "data is null or nil");
                        AppMethodBeat.o(23351);
                        return;
                    }
                    Log.d(TAG, "onDataRecv. mac=%d, data=%s", Long.valueOf(j2), b.bw(bArr));
                    e cKW = ad.cKW();
                    String Dj = b.Dj(j2);
                    synchronized (cKW.ryr) {
                        try {
                            linkedList = new LinkedList(cKW.ryr);
                        } catch (Throwable th) {
                            AppMethodBeat.o(23351);
                            throw th;
                        }
                    }
                    for (e.b bVar : linkedList) {
                        bVar.b(Dj, bArr, true);
                    }
                    linkedList.clear();
                    for (e.b bVar2 : cKW.rys.values()) {
                        bVar2.b(Dj, bArr, true);
                    }
                    ff ffVar = new ff();
                    ffVar.dIC.mac = Dj;
                    ffVar.dIC.data = bArr;
                    EventCenter.instance.asyncPublish(ffVar, Looper.getMainLooper());
                    AppMethodBeat.o(23351);
                }
            }
