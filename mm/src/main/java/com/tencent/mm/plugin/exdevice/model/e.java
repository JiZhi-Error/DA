package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ee;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.er;
import com.tencent.mm.g.a.es;
import com.tencent.mm.g.a.et;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ew;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.g.a.ey;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fj;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.md;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.wz;
import com.tencent.mm.g.a.xa;
import com.tencent.mm.g.a.xj;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.exdevice.c.k;
import com.tencent.mm.plugin.exdevice.j.j;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.aa;
import com.tencent.mm.plugin.exdevice.model.h;
import com.tencent.mm.plugin.exdevice.model.i;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.t;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private final long cZY = 300000;
    MMHandler mHandler = new MMHandler("wifi_device_heart_beat");
    public IListener oVj = new IListener<ad>() {
        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass21 */

        {
            AppMethodBeat.i(161335);
            this.__eventId = ad.class.getName().hashCode();
            AppMethodBeat.o(161335);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ad adVar) {
            AppMethodBeat.i(23253);
            boolean cKz = e.cKz();
            AppMethodBeat.o(23253);
            return cKz;
        }
    };
    public IListener ryA = new IListener<xj>() {
        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass45 */

        {
            AppMethodBeat.i(161353);
            this.__eventId = xj.class.getName().hashCode();
            AppMethodBeat.o(161353);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xj xjVar) {
            boolean z;
            AppMethodBeat.i(23277);
            e eVar = e.this;
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive SyncExdeviceDataEvent");
            int aYS = bg.azz().aYS();
            if (aYS == 4 || aYS == 6) {
                String value = h.aqJ().getValue("DeviceAutoSyncClose");
                Log.i("MicroMsg.exdevice.Util", "handleSyncExdeviceDataEvent, auto sync has close : %s", value);
                if (Util.isNullOrNil(value) || !value.equalsIgnoreCase("1")) {
                    z = true;
                } else {
                    Log.i("MicroMsg.exdevice.Util", "auto sync has closed, ignore this sync request");
                    z = false;
                }
                if (!z) {
                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "not allowed to sync exdevice data");
                    AppMethodBeat.o(23277);
                    return false;
                } else if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(Build.VERSION.SDK_INT));
                    AppMethodBeat.o(23277);
                    return false;
                } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                    AppMethodBeat.o(23277);
                    return false;
                } else {
                    ad.cKS();
                    if (d.cKt() == 1) {
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "it is in brand");
                        AppMethodBeat.o(23277);
                        return false;
                    } else if (i.INSTANCE.lQ(false)) {
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now need to get bound harddevices");
                        i.INSTANCE.a(null, new i.a() {
                            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass38 */

                            @Override // com.tencent.mm.plugin.exdevice.model.i.a
                            public final void lP(boolean z) {
                                AppMethodBeat.i(23270);
                                e.cKv();
                                AppMethodBeat.o(23270);
                            }
                        });
                        AppMethodBeat.o(23277);
                        return true;
                    } else {
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now do not need to get bound device, do sync directly");
                        boolean cKv = e.cKv();
                        AppMethodBeat.o(23277);
                        return cKv;
                    }
                }
            } else {
                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, now state is %d", Integer.valueOf(aYS));
                AppMethodBeat.o(23277);
                return false;
            }
        }
    };
    public IListener ryB = new IListener<dz>() {
        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass46 */

        {
            AppMethodBeat.i(161354);
            this.__eventId = dz.class.getName().hashCode();
            AppMethodBeat.o(161354);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dz dzVar) {
            AppMethodBeat.i(23278);
            boolean z = dzVar.dHd.dHe;
            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "------handleGetBoundDeviceEvent------ check if need to get bound device after auth");
            if (i.INSTANCE.lQ(z)) {
                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "do get bound device after auth");
                i.INSTANCE.a(null, null);
            }
            AppMethodBeat.o(23278);
            return true;
        }
    };
    public IListener ryC = new IListener<eh>() {
        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass2 */

        {
            AppMethodBeat.i(161316);
            this.__eventId = eh.class.getName().hashCode();
            AppMethodBeat.o(161316);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(eh ehVar) {
            AppMethodBeat.i(23234);
            eh ehVar2 = ehVar;
            if (ehVar2 != null && (ehVar2 instanceof eh)) {
                eh ehVar3 = ehVar2;
                String str = ehVar3.dHC.dHE;
                boolean z = ehVar3.dHC.dHB;
                d cKS = ad.cKS();
                Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "ranging, uuid = %s, op = %s", str, String.valueOf(z));
                com.tencent.f.h.RTc.b(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: INVOKE  
                      (wrap: com.tencent.f.i : 0x0036: SGET  (r0v3 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                      (wrap: com.tencent.mm.plugin.exdevice.model.d$5 : 0x0033: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.exdevice.model.d$5) = (r2v0 'cKS' com.tencent.mm.plugin.exdevice.model.d), (r0v2 'str' java.lang.String), (r1v1 'z' boolean) call: com.tencent.mm.plugin.exdevice.model.d.5.<init>(com.tencent.mm.plugin.exdevice.model.d, java.lang.String, boolean):void type: CONSTRUCTOR)
                      ("MicroMsg.exdevice.ExdeviceConnectManager|ranging")
                     type: INTERFACE call: com.tencent.f.i.b(java.lang.Runnable, java.lang.String):com.tencent.f.i.d in method: com.tencent.mm.plugin.exdevice.model.e.2.callback(com.tencent.mm.g.a.eh):boolean, file: classes5.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0033: CONSTRUCTOR  (r3v1 com.tencent.mm.plugin.exdevice.model.d$5) = (r2v0 'cKS' com.tencent.mm.plugin.exdevice.model.d), (r0v2 'str' java.lang.String), (r1v1 'z' boolean) call: com.tencent.mm.plugin.exdevice.model.d.5.<init>(com.tencent.mm.plugin.exdevice.model.d, java.lang.String, boolean):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.model.e.2.callback(com.tencent.mm.g.a.eh):boolean, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.d, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r8 = 23234(0x5ac2, float:3.2558E-41)
                    r7 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                    com.tencent.mm.g.a.eh r10 = (com.tencent.mm.g.a.eh) r10
                    if (r10 == 0) goto L_0x003e
                    boolean r0 = r10 instanceof com.tencent.mm.g.a.eh
                    if (r0 == 0) goto L_0x003e
                    com.tencent.mm.g.a.eh r10 = (com.tencent.mm.g.a.eh) r10
                    com.tencent.mm.g.a.eh$a r0 = r10.dHC
                    java.lang.String r0 = r0.dHE
                    com.tencent.mm.g.a.eh$a r1 = r10.dHC
                    boolean r1 = r1.dHB
                    com.tencent.mm.plugin.exdevice.model.d r2 = com.tencent.mm.plugin.exdevice.model.ad.cKS()
                    java.lang.String r3 = "MicroMsg.exdevice.ExdeviceConnectManager"
                    java.lang.String r4 = "ranging, uuid = %s, op = %s"
                    r5 = 2
                    java.lang.Object[] r5 = new java.lang.Object[r5]
                    r6 = 0
                    r5[r6] = r0
                    java.lang.String r6 = java.lang.String.valueOf(r1)
                    r5[r7] = r6
                    com.tencent.mm.sdk.platformtools.Log.i(r3, r4, r5)
                    com.tencent.mm.plugin.exdevice.model.d$5 r3 = new com.tencent.mm.plugin.exdevice.model.d$5
                    r3.<init>(r0, r1)
                    com.tencent.f.i r0 = com.tencent.f.h.RTc
                    java.lang.String r1 = "MicroMsg.exdevice.ExdeviceConnectManager|ranging"
                    r0.b(r3, r1)
                L_0x003e:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.e.AnonymousClass2.callback(com.tencent.mm.sdk.event.IEvent):boolean");
            }
        };
        public IListener ryD = new IListener<eu>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass3 */

            {
                AppMethodBeat.i(161317);
                this.__eventId = eu.class.getName().hashCode();
                AppMethodBeat.o(161317);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(eu euVar) {
                AppMethodBeat.i(23235);
                boolean f2 = e.this.f(euVar);
                AppMethodBeat.o(23235);
                return f2;
            }
        };
        public IListener ryE = new IListener<ee>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass4 */

            {
                AppMethodBeat.i(161318);
                this.__eventId = ee.class.getName().hashCode();
                AppMethodBeat.o(161318);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ee eeVar) {
                AppMethodBeat.i(23236);
                boolean e2 = e.this.e(eeVar);
                AppMethodBeat.o(23236);
                return e2;
            }
        };
        public IListener ryF = new IListener<dw>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass5 */

            {
                AppMethodBeat.i(161319);
                this.__eventId = dw.class.getName().hashCode();
                AppMethodBeat.o(161319);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(dw dwVar) {
                boolean z = false;
                AppMethodBeat.i(23237);
                dw dwVar2 = dwVar;
                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleConnectDeviceEvent: brandName=%s, deviceId=%s, type=%b", dwVar2.dGU.brandName, dwVar2.dGU.dGL, Boolean.valueOf(dwVar2.dGU.dGW));
                String str = dwVar2.dGU.brandName;
                String str2 = dwVar2.dGU.dGL;
                boolean z2 = dwVar2.dGU.dGW;
                if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.exdevice.ExdeviceEventManager", "connectBluetoothDevice %s, %s, %s", str, str2, Boolean.valueOf(z2));
                } else {
                    com.tencent.mm.plugin.exdevice.i.b anJ = ad.cKL().anJ(str2);
                    if (anJ == null) {
                        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", str2);
                    } else if (!anJ.field_brandName.equals(str)) {
                        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", anJ.field_brandName, str);
                    } else if (Util.nullAsNil(anJ.field_connProto).contains("4")) {
                        e.d(str, anJ.field_url, -1, anJ.field_deviceType);
                        e.dh(str, -1);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz, Just leave");
                    } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                        Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        e.dh(str, 0);
                    } else {
                        e.dh(str, -1);
                        int a2 = e.a(anJ);
                        if (a2 == 1) {
                            if (!com.tencent.mm.plugin.d.a.e.a.ckN()) {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BC, but you phone not support BC.");
                            }
                        } else if (a2 == 0 && !com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                            e.dh(str, 1);
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                        }
                        if (z2) {
                            if (aa.cKI().rzT) {
                                aa.cKI().Gy(a2);
                            }
                            d cKS = ad.cKS();
                            if (!(cKS.ryc == null || cKS.ryc.size() == 0)) {
                                cKS.ryc.clear();
                            }
                            ad.cKS().b(anJ.field_brandName, anJ.field_mac, a2);
                        } else {
                            ad.cKS();
                            d.CM(anJ.field_mac);
                        }
                        z = true;
                    }
                }
                dwVar2.dGV.dGX = z;
                AppMethodBeat.o(23237);
                return z;
            }
        };
        public IListener ryG = new IListener<dy>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass6 */

            {
                AppMethodBeat.i(161320);
                this.__eventId = dy.class.getName().hashCode();
                AppMethodBeat.o(161320);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(dy dyVar) {
                AppMethodBeat.i(23238);
                dy dyVar2 = dyVar;
                com.tencent.mm.plugin.exdevice.i.b gc = ad.cKL().gc(dyVar2.dHa.dHc, dyVar2.dHa.dGL);
                if (gc == null || (gc.field_connStrategy & 16) != 0) {
                    dyVar2.dHb.dGX = false;
                } else {
                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "CONNECT_STRATEGY_IGNORE_ON_CHAT disable, (%s) do not disconnect ble device(%s)", dyVar2.dHa.dHc, dyVar2.dHa.dGL);
                    dyVar2.dHb.dGX = true;
                }
                AppMethodBeat.o(23238);
                return true;
            }
        };
        public IListener ryH = new IListener<ew>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass7 */

            {
                AppMethodBeat.i(161321);
                this.__eventId = ew.class.getName().hashCode();
                AppMethodBeat.o(161321);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ew ewVar) {
                AppMethodBeat.i(23239);
                boolean d2 = e.d(ewVar);
                AppMethodBeat.o(23239);
                return d2;
            }
        };
        public IListener ryI = new IListener<en>() {
            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass8 */

            {
                AppMethodBeat.i(161322);
                this.__eventId = en.class.getName().hashCode();
                AppMethodBeat.o(161322);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(en enVar) {
                AppMethodBeat.i(23240);
                en enVar2 = enVar;
                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleDeviceOPFromJSAPIEvent: %d", Integer.valueOf(enVar2.dHU.op));
                if (enVar2.dHU.op == 1) {
                    d cKS = ad.cKS();
                    if (cKS.rxY == null) {
                        cKS.rxY = new com.tencent.mm.plugin.exdevice.service.c();
                        cKS.rxY.rDx = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003c: IPUT  
                              (wrap: com.tencent.mm.plugin.exdevice.model.d$11 : 0x0039: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.exdevice.model.d$11) = (r0v3 'cKS' com.tencent.mm.plugin.exdevice.model.d) call: com.tencent.mm.plugin.exdevice.model.d.11.<init>(com.tencent.mm.plugin.exdevice.model.d):void type: CONSTRUCTOR)
                              (wrap: com.tencent.mm.plugin.exdevice.service.c : 0x0035: IGET  (r1v3 com.tencent.mm.plugin.exdevice.service.c) = (r0v3 'cKS' com.tencent.mm.plugin.exdevice.model.d) com.tencent.mm.plugin.exdevice.model.d.rxY com.tencent.mm.plugin.exdevice.service.c)
                             com.tencent.mm.plugin.exdevice.service.c.rDx com.tencent.mm.plugin.exdevice.service.c$a in method: com.tencent.mm.plugin.exdevice.model.e.8.callback(com.tencent.mm.g.a.en):boolean, file: classes8.dex
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
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0039: CONSTRUCTOR  (r2v1 com.tencent.mm.plugin.exdevice.model.d$11) = (r0v3 'cKS' com.tencent.mm.plugin.exdevice.model.d) call: com.tencent.mm.plugin.exdevice.model.d.11.<init>(com.tencent.mm.plugin.exdevice.model.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.model.e.8.callback(com.tencent.mm.g.a.en):boolean, file: classes8.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 24 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.d, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 28 more
                            */
                        /*
                            this = this;
                            r6 = 23240(0x5ac8, float:3.2566E-41)
                            r5 = 1
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                            com.tencent.mm.g.a.en r8 = (com.tencent.mm.g.a.en) r8
                            com.tencent.mm.g.a.en r8 = (com.tencent.mm.g.a.en) r8
                            java.lang.String r0 = "MicroMsg.exdevice.ExdeviceEventManager"
                            java.lang.String r1 = "handleDeviceOPFromJSAPIEvent: %d"
                            java.lang.Object[] r2 = new java.lang.Object[r5]
                            r3 = 0
                            com.tencent.mm.g.a.en$a r4 = r8.dHU
                            int r4 = r4.op
                            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
                            r2[r3] = r4
                            com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
                            com.tencent.mm.g.a.en$a r0 = r8.dHU
                            int r0 = r0.op
                            if (r0 != r5) goto L_0x0047
                            com.tencent.mm.plugin.exdevice.model.d r0 = com.tencent.mm.plugin.exdevice.model.ad.cKS()
                            com.tencent.mm.plugin.exdevice.service.c r1 = r0.rxY
                            if (r1 != 0) goto L_0x0047
                            com.tencent.mm.plugin.exdevice.service.c r1 = new com.tencent.mm.plugin.exdevice.service.c
                            r1.<init>()
                            r0.rxY = r1
                            com.tencent.mm.plugin.exdevice.service.c r1 = r0.rxY
                            com.tencent.mm.plugin.exdevice.model.d$11 r2 = new com.tencent.mm.plugin.exdevice.model.d$11
                            r2.<init>()
                            r1.rDx = r2
                            com.tencent.mm.plugin.exdevice.service.c r0 = r0.rxY
                            android.content.Context r1 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
                            r0.fc(r1)
                        L_0x0047:
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.e.AnonymousClass8.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                    }
                };
                public IListener ryJ = new IListener<eb>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass9 */

                    {
                        AppMethodBeat.i(161323);
                        this.__eventId = eb.class.getName().hashCode();
                        AppMethodBeat.o(161323);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(eb ebVar) {
                        AppMethodBeat.i(23241);
                        boolean c2 = e.c(ebVar);
                        AppMethodBeat.o(23241);
                        return c2;
                    }
                };
                public IListener ryK = new IListener<fa>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass10 */

                    {
                        AppMethodBeat.i(161324);
                        this.__eventId = fa.class.getName().hashCode();
                        AppMethodBeat.o(161324);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fa faVar) {
                        AppMethodBeat.i(23242);
                        fa faVar2 = faVar;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", faVar2.dIs.dGL, Integer.valueOf(faVar2.dIs.direction), Boolean.valueOf(faVar2.dIs.clear));
                        if (faVar2.dIs.clear) {
                            k.cKl().rxF.clear();
                            faVar2.dIt.dGX = true;
                        } else if (!Util.isNullOrNil(faVar2.dIs.dGL)) {
                            k cKl = k.cKl();
                            String str = faVar2.dIs.dGL;
                            int i2 = faVar2.dIs.direction;
                            if (!Util.isNullOrNil(str)) {
                                cKl.rxF.put(str, Integer.valueOf(i2));
                            }
                            faVar2.dIt.dGX = true;
                        } else {
                            faVar2.dIt.dGX = false;
                        }
                        AppMethodBeat.o(23242);
                        return true;
                    }
                };
                public IListener ryL = new IListener<fh>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass11 */

                    {
                        AppMethodBeat.i(161325);
                        this.__eventId = fh.class.getName().hashCode();
                        AppMethodBeat.o(161325);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fh fhVar) {
                        AppMethodBeat.i(23243);
                        fh fhVar2 = fhVar;
                        if (fhVar2 == null || !(fhVar2 instanceof fh)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTScanDeviceEvent");
                            AppMethodBeat.o(23243);
                            return false;
                        }
                        fh fhVar3 = fhVar2;
                        if (e.cKy()) {
                            fhVar3.dIF.dGX = true;
                        } else {
                            fhVar3.dIF.dGX = false;
                        }
                        AppMethodBeat.o(23243);
                        return true;
                    }
                };
                public IListener ryM = new IListener<fd>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass13 */

                    {
                        AppMethodBeat.i(161327);
                        this.__eventId = fd.class.getName().hashCode();
                        AppMethodBeat.o(161327);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fd fdVar) {
                        boolean ant;
                        AppMethodBeat.i(23245);
                        fd fdVar2 = fdVar;
                        e eVar = e.this;
                        if (fdVar2 == null || !(fdVar2 instanceof fd)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
                            AppMethodBeat.o(23245);
                            return false;
                        }
                        fd fdVar3 = fdVar2;
                        if (fdVar3.dIz.dGW) {
                            ant = eVar.anu(fdVar3.dIz.mac);
                        } else {
                            ant = e.ant(fdVar3.dIz.mac);
                        }
                        if (ant) {
                            fdVar3.dIA.dGX = true;
                        } else {
                            fdVar3.dIA.dGX = false;
                        }
                        AppMethodBeat.o(23245);
                        return true;
                    }
                };
                public IListener ryN = new IListener<fi>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass14 */

                    {
                        AppMethodBeat.i(161328);
                        this.__eventId = fi.class.getName().hashCode();
                        AppMethodBeat.o(161328);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fi fiVar) {
                        AppMethodBeat.i(23246);
                        fi fiVar2 = fiVar;
                        e eVar = e.this;
                        if (fiVar2 == null || !(fiVar2 instanceof fi)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
                            AppMethodBeat.o(23246);
                            return false;
                        }
                        fi fiVar3 = fiVar2;
                        if (eVar.n(fiVar3.dIG.mac, fiVar3.dIG.data)) {
                            fiVar3.dIH.dGX = true;
                        } else {
                            fiVar3.dIH.dGX = false;
                        }
                        AppMethodBeat.o(23246);
                        return true;
                    }
                };
                public IListener ryO = new IListener<fc>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass15 */

                    {
                        AppMethodBeat.i(161329);
                        this.__eventId = fc.class.getName().hashCode();
                        AppMethodBeat.o(161329);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fc fcVar) {
                        String str;
                        boolean z;
                        AppMethodBeat.i(23247);
                        fc fcVar2 = fcVar;
                        if (fcVar2 == null || !(fcVar2 instanceof fc)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTBindDeviceEvent");
                            AppMethodBeat.o(23247);
                            return false;
                        }
                        fc fcVar3 = fcVar2;
                        if (ad.cKL().Di(com.tencent.mm.plugin.exdevice.k.b.anY(fcVar3.dIv.mac)) != null) {
                            Log.d("MicroMsg.exdevice.ExdeviceEventManager", "device(" + fcVar3.dIv.mac + ") has been binded");
                            fcVar3.dIw.dGX = true;
                        } else {
                            String str2 = fcVar3.dIv.mac;
                            String str3 = fcVar3.dIv.dIx;
                            long j2 = fcVar3.dIv.dIy;
                            if (Util.isNullOrNil(str2)) {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                                z = false;
                            } else {
                                Object[] objArr = new Object[3];
                                objArr[0] = str2;
                                if (str3 == null) {
                                    str = BuildConfig.COMMAND;
                                } else {
                                    str = str3;
                                }
                                objArr[1] = str;
                                objArr[2] = Long.valueOf(j2);
                                Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTBindDevice. mac = %s, broadcastName = %s, profileType = %d", objArr);
                                int aYS = bg.azz().aYS();
                                if (aYS == 4 || aYS == 6) {
                                    if (!bg.azz().a(new m(com.tencent.mm.plugin.exdevice.k.b.anY(str2), str3, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, j2), 0)) {
                                        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "do NetSceneBindUnauthDevice fail");
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                } else {
                                    Log.e("MicroMsg.exdevice.ExdeviceEventManager", "net work state is not connected, current state is %d", Integer.valueOf(aYS));
                                    z = false;
                                }
                            }
                            if (z) {
                                fcVar3.dIw.dGX = true;
                            } else {
                                fcVar3.dIw.dGX = false;
                            }
                        }
                        AppMethodBeat.o(23247);
                        return true;
                    }
                };
                public IListener ryP = new IListener<fj>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass16 */

                    {
                        AppMethodBeat.i(161330);
                        this.__eventId = fj.class.getName().hashCode();
                        AppMethodBeat.o(161330);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fj fjVar) {
                        AppMethodBeat.i(23248);
                        fj fjVar2 = fjVar;
                        if (fjVar2 == null || !(fjVar2 instanceof fj)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                            AppMethodBeat.o(23248);
                            return false;
                        }
                        fj fjVar3 = fjVar2;
                        if (e.b(fjVar3.dII.mac, fjVar3.dII.brandName, fjVar3.dII.data)) {
                            fjVar3.dIJ.dGX = true;
                        } else {
                            fjVar3.dIJ.dGX = false;
                        }
                        AppMethodBeat.o(23248);
                        return true;
                    }
                };
                public IListener ryQ = new IListener<dv>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass17 */

                    {
                        AppMethodBeat.i(161331);
                        this.__eventId = dv.class.getName().hashCode();
                        AppMethodBeat.o(161331);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(dv dvVar) {
                        dv.b bVar;
                        boolean z = false;
                        AppMethodBeat.i(23249);
                        dv dvVar2 = dvVar;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceIsBoundEvent: deviceType(%s), deviceId(%s)", dvVar2.dGR.dGP, dvVar2.dGR.dGL);
                        if (dvVar2.dGR.dGP == null || dvVar2.dGR.dGL == null) {
                            bVar = dvVar2.dGS;
                        } else {
                            com.tencent.mm.plugin.exdevice.i.b gb = ad.cKL().gb(dvVar2.dGR.dGL, dvVar2.dGR.dGP);
                            bVar = dvVar2.dGS;
                            if (gb != null) {
                                z = true;
                            }
                        }
                        bVar.dGT = z;
                        AppMethodBeat.o(23249);
                        return true;
                    }
                };
                public IListener ryR = new IListener<du>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass18 */

                    {
                        AppMethodBeat.i(161332);
                        this.__eventId = du.class.getName().hashCode();
                        AppMethodBeat.o(161332);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(du duVar) {
                        AppMethodBeat.i(23250);
                        du duVar2 = duVar;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceCheckDeviceHasAbilityEvent: deviceType(%s), deviceId(%s)", duVar2.dGN.dGP, duVar2.dGN.dGL);
                        if (duVar2.dGN.dGP == null || duVar2.dGN.dGL == null) {
                            duVar2.dGO.dGQ = false;
                        } else {
                            com.tencent.mm.plugin.exdevice.i.b gc = ad.cKL().gc(duVar2.dGN.dGP, duVar2.dGN.dGL);
                            if (gc != null) {
                                String str = gc.fMh;
                                du.b bVar = duVar2.dGO;
                                ad.cKL();
                                bVar.dGQ = com.tencent.mm.plugin.exdevice.i.c.anK(str);
                            } else {
                                duVar2.dGO.dGQ = false;
                            }
                        }
                        AppMethodBeat.o(23250);
                        return true;
                    }
                };
                public IListener ryS = new IListener<ea>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass19 */

                    {
                        AppMethodBeat.i(161333);
                        this.__eventId = ea.class.getName().hashCode();
                        AppMethodBeat.o(161333);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ea eaVar) {
                        AppMethodBeat.i(23251);
                        ea eaVar2 = eaVar;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceGetCurrentSSIDEvent: opCode = %b", Boolean.valueOf(eaVar2.dHf.dGW));
                        if (eaVar2.dHf.dGW) {
                            String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
                            if (!Util.isNullOrNil(connectedWifiSsid)) {
                                eaVar2.dHg.dGX = true;
                                eaVar2.dHg.dHh = connectedWifiSsid.replaceAll("\"", "");
                                AppMethodBeat.o(23251);
                                return true;
                            }
                        }
                        eaVar2.dHg.dGX = false;
                        eaVar2.dHg.dHh = null;
                        AppMethodBeat.o(23251);
                        return true;
                    }
                };
                public IListener ryT = new IListener<ok>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass20 */

                    {
                        AppMethodBeat.i(161334);
                        this.__eventId = ok.class.getName().hashCode();
                        AppMethodBeat.o(161334);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ok okVar) {
                        AppMethodBeat.i(23252);
                        if (okVar == null) {
                            Log.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
                            AppMethodBeat.o(23252);
                        } else {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
                            AppMethodBeat.o(23252);
                        }
                        return false;
                    }
                };
                public IListener ryU = new IListener<oo>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass22 */

                    {
                        AppMethodBeat.i(161336);
                        this.__eventId = oo.class.getName().hashCode();
                        AppMethodBeat.o(161336);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(oo ooVar) {
                        AppMethodBeat.i(23254);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", MMApplicationContext.getProcessName());
                        if (!MMApplicationContext.isExdeviceProcess()) {
                            AppMethodBeat.o(23254);
                            return true;
                        }
                        AppMethodBeat.o(23254);
                        return false;
                    }
                };
                public IListener ryV = new IListener<ef>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass24 */

                    {
                        AppMethodBeat.i(161338);
                        this.__eventId = ef.class.getName().hashCode();
                        AppMethodBeat.o(161338);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ef efVar) {
                        boolean z;
                        AppMethodBeat.i(23256);
                        ef efVar2 = efVar;
                        long j2 = efVar2.dHy.msgId;
                        String str = efVar2.dHy.dHp;
                        List<com.tencent.mm.plugin.exdevice.i.b> cLA = ad.cKL().cLA();
                        if (cLA.size() > 0) {
                            if (j2 == -1 || j2 == Long.MIN_VALUE) {
                                z = false;
                            } else {
                                bg.aVF();
                                ca Hb = com.tencent.mm.model.c.aSQ().Hb(j2);
                                if (Hb.field_msgId == 0) {
                                    z = false;
                                } else {
                                    int type = Hb.getType();
                                    String str2 = Hb.field_content;
                                    if (Hb.dOQ()) {
                                        k.b HD = k.b.HD(str2);
                                        if (HD == null) {
                                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "get content is null");
                                            z = false;
                                        } else if (HD.type == 3 || HD.type == 76) {
                                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it = cLA.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    z = false;
                                                    break;
                                                }
                                                String str3 = it.next().fMh;
                                                if (str3 != null && str3.contains("wxmsg_music")) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        } else if (HD.type == 4) {
                                            z = false;
                                        } else if (HD.type == 6) {
                                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it2 = cLA.iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    z = false;
                                                    break;
                                                }
                                                String str4 = it2.next().fMh;
                                                if (str4 != null && str4.contains("wxmsg_file")) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        } else if (HD.type == 5) {
                                            z = e.o(HD.url, cLA);
                                        } else {
                                            if (HD.type == 2) {
                                                Iterator<com.tencent.mm.plugin.exdevice.i.b> it3 = cLA.iterator();
                                                while (true) {
                                                    if (!it3.hasNext()) {
                                                        z = false;
                                                        break;
                                                    }
                                                    String str5 = it3.next().fMh;
                                                    if (str5 != null && str5.contains("wxmsg_image")) {
                                                        z = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            z = false;
                                        }
                                    } else if (type == 3) {
                                        Iterator<com.tencent.mm.plugin.exdevice.i.b> it4 = cLA.iterator();
                                        while (true) {
                                            if (!it4.hasNext()) {
                                                z = false;
                                                break;
                                            }
                                            String str6 = it4.next().fMh;
                                            if (str6 != null && str6.contains("wxmsg_image")) {
                                                z = true;
                                                break;
                                            }
                                        }
                                    } else if (type == 48) {
                                        Iterator<com.tencent.mm.plugin.exdevice.i.b> it5 = cLA.iterator();
                                        while (true) {
                                            if (!it5.hasNext()) {
                                                z = false;
                                                break;
                                            }
                                            String str7 = it5.next().fMh;
                                            if (str7 != null && str7.contains("wxmsg_poi")) {
                                                z = true;
                                                break;
                                            }
                                        }
                                    } else {
                                        if (type == 62) {
                                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it6 = cLA.iterator();
                                            while (true) {
                                                if (!it6.hasNext()) {
                                                    break;
                                                }
                                                String str8 = it6.next().fMh;
                                                if (str8 != null && str8.contains("wxmsg_video")) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        }
                                        z = false;
                                    }
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsMsgType = " + z + ", msgType = " + type);
                                }
                            }
                            if (z || e.p(str, cLA)) {
                                efVar2.dHz.dGX = true;
                                AppMethodBeat.o(23256);
                                return true;
                            }
                        }
                        efVar2.dHz.dGX = false;
                        AppMethodBeat.o(23256);
                        return true;
                    }
                };
                public IListener ryW = new IListener<ed>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass25 */

                    {
                        AppMethodBeat.i(161339);
                        this.__eventId = ed.class.getName().hashCode();
                        AppMethodBeat.o(161339);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ed edVar) {
                        AppMethodBeat.i(23257);
                        e eVar = e.this;
                        ed edVar2 = edVar;
                        eVar.rzh = new g();
                        g gVar = eVar.rzh;
                        Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "startScanWCLanDevice...");
                        Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
                        gVar.rzp = false;
                        new MTimerHandler(new MTimerHandler.CallBack() {
                            /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass7 */

                            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                            public final boolean onTimerExpired() {
                                AppMethodBeat.i(23325);
                                int size = g.this.rzD.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (g.this.rzD.get(i2).fMh.contains("internet_to_device") && g.this.rzD.get(i2).fMh.contains("wechat_to_device") && !g.this.rzE.contains(g.this.rzD.get(i2))) {
                                        g.this.rzE.add(g.this.rzD.get(i2));
                                        g.dm(g.this.rzE);
                                    }
                                }
                                AppMethodBeat.o(23325);
                                return true;
                            }
                        }, false).startTimer(3000);
                        g gVar2 = eVar.rzh;
                        long j2 = edVar2.dHn.msgId;
                        String str = edVar2.dHn.dHp;
                        String str2 = edVar2.dHn.dHq;
                        String str3 = edVar2.dHn.dHr;
                        ArrayList arrayList = new ArrayList();
                        gVar2.gof = j2;
                        gVar2.rzs = str;
                        gVar2.rzt = str2;
                        gVar2.rzu = str3;
                        int size = gVar2.rzE.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("deviceType", gVar2.rzE.get(i2).field_deviceType);
                            hashMap.put("deviceID", gVar2.rzE.get(i2).field_deviceID);
                            hashMap.put("displayName", g.c(gVar2.rzE.get(i2)));
                            hashMap.put("iconUrl", gVar2.rzE.get(i2).iconUrl);
                            hashMap.put("ability", gVar2.rzE.get(i2).fMh);
                            hashMap.put("abilityInf", gVar2.rzE.get(i2).fMi);
                            arrayList.add(hashMap);
                        }
                        if (arrayList.size() > 0) {
                            edVar2.dHo.dHs = arrayList;
                            edVar2.dHo.dGX = true;
                        } else {
                            edVar2.dHo.dGX = false;
                        }
                        AppMethodBeat.o(23257);
                        return true;
                    }
                };
                public IListener ryX = new IListener<ey>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass26 */

                    {
                        AppMethodBeat.i(161340);
                        this.__eventId = ey.class.getName().hashCode();
                        AppMethodBeat.o(161340);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    /* JADX WARNING: Removed duplicated region for block: B:108:0x04b8  */
                    /* JADX WARNING: Removed duplicated region for block: B:111:0x04cf  */
                    /* JADX WARNING: Removed duplicated region for block: B:90:0x03d5  */
                    /* JADX WARNING: Removed duplicated region for block: B:93:0x03e7  */
                    @Override // com.tencent.mm.sdk.event.IListener
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final /* synthetic */ boolean callback(com.tencent.mm.g.a.ey r25) {
                        /*
                        // Method dump skipped, instructions count: 1706
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.e.AnonymousClass26.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                    }
                };
                public IListener ryY = new IListener<fl>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass27 */

                    {
                        AppMethodBeat.i(161341);
                        this.__eventId = fl.class.getName().hashCode();
                        AppMethodBeat.o(161341);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fl flVar) {
                        AppMethodBeat.i(23259);
                        fl flVar2 = flVar;
                        g gVar = e.this.rzh;
                        if (!gVar.rzp) {
                            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                            Java2CExDevice.stopScanWCLanDevice();
                            gVar.rzp = true;
                        }
                        bg.aAk().postToWorker(new Runnable() {
                            /* class com.tencent.mm.plugin.exdevice.model.g.AnonymousClass8 */

                            public final void run() {
                                AppMethodBeat.i(23326);
                                Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "releaseWCLanDeviceLib...");
                                Java2CExDevice.releaseWCLanDeviceLib();
                                AppMethodBeat.o(23326);
                            }
                        });
                        bg.azz().b(1717, gVar);
                        j.cKC().b(14, gVar.rzI);
                        j.cKC().b(12, gVar.rzJ);
                        j.cKC().b(13, gVar.rzK);
                        j.cKC().b(15, gVar.rzL);
                        flVar2.dIL.isSuccess = true;
                        AppMethodBeat.o(23259);
                        return true;
                    }
                };
                public IListener ryZ = new IListener<fb>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass28 */

                    {
                        AppMethodBeat.i(161342);
                        this.__eventId = fb.class.getName().hashCode();
                        AppMethodBeat.o(161342);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fb fbVar) {
                        AppMethodBeat.i(23260);
                        fb fbVar2 = fbVar;
                        if (ad.cKL().cLB().size() > 0) {
                            fbVar2.dIu.dGX = true;
                        } else {
                            fbVar2.dIu.dGX = false;
                        }
                        AppMethodBeat.o(23260);
                        return true;
                    }
                };
                List<b> ryr = new LinkedList();
                Map<String, b> rys = new HashMap();
                public IListener ryt = new IListener<md>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass1 */

                    {
                        AppMethodBeat.i(161315);
                        this.__eventId = md.class.getName().hashCode();
                        AppMethodBeat.o(161315);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(md mdVar) {
                        c.b cG;
                        c.b.C0261b UZ;
                        AppMethodBeat.i(23233);
                        md mdVar2 = mdVar;
                        e eVar = e.this;
                        int i2 = mdVar2.dRC.opType;
                        int i3 = mdVar2.dRC.viewId;
                        String str = mdVar2.dRC.dRD;
                        if (i2 == 1) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Just enter, so clear previous state.");
                            or orVar = new or();
                            orVar.dUI.op = 3;
                            orVar.dUI.dRD = mdVar2.dRC.dRD;
                            EventCenter.instance.publish(orVar);
                        }
                        LinkedList<com.tencent.mm.plugin.exdevice.i.b> anL = ad.cKL().anL(str);
                        com.tencent.mm.api.c fJ = g.fJ(str);
                        if (!(fJ == null || (cG = fJ.cG(false)) == null || (UZ = cG.UZ()) == null || !UZ.Vi() || UZ.dih != 1)) {
                            LinkedList<com.tencent.mm.plugin.exdevice.i.b> cLC = ad.cKL().cLC();
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat sport biz...");
                            if (cLC.size() != 0) {
                                for (com.tencent.mm.plugin.exdevice.i.b bVar : cLC) {
                                    if (0 != (bVar.fMg & 1)) {
                                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE connected device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d), connProto(%s)", Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.fMg), bVar.field_connProto);
                                        anL.add(bVar);
                                    }
                                }
                            }
                        }
                        if (anL == null) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName failed : %s", str);
                            AppMethodBeat.o(23233);
                            return false;
                        } else if (anL.size() == 0) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get hdinfo by brandName(%s) result count is 0 ", str);
                            AppMethodBeat.o(23233);
                            return true;
                        } else {
                            if (i2 == 2) {
                                Log.d("MicroMsg.exdevice.ExdeviceEventManager", "exit chattingui, clear observers.");
                                eVar.rys.clear();
                            }
                            LinkedList linkedList = new LinkedList();
                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it = anL.iterator();
                            boolean z = false;
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.exdevice.i.b next = it.next();
                                if (next == null || Util.isNullOrNil(next.field_brandName)) {
                                    AppMethodBeat.o(23233);
                                    return false;
                                }
                                String nullAsNil = Util.nullAsNil(next.field_connProto);
                                if (nullAsNil.contains("4")) {
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi biz.");
                                    linkedList.add(next);
                                } else {
                                    if (nullAsNil.contains("1") || nullAsNil.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || nullAsNil.contains("5") || nullAsNil.length() == 0) {
                                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BlueTooth biz.");
                                        if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                                            Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                            z = true;
                                        } else {
                                            z = false;
                                            e.a(next, i2, i3);
                                        }
                                    }
                                    z = z;
                                }
                            }
                            int size = linkedList.size();
                            if (size > 0) {
                                eVar.o(linkedList, i2);
                                com.tencent.mm.plugin.exdevice.i.b bVar2 = linkedList.get(size - 1);
                                if (size == anL.size()) {
                                    e.d(bVar2.field_brandName, bVar2.field_url, 0, bVar2.field_deviceID);
                                }
                            }
                            e.dh(str, z ? 0 : -1);
                            AppMethodBeat.o(23233);
                            return false;
                        }
                    }
                };
                public IListener ryu = new IListener<mc>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass12 */

                    {
                        AppMethodBeat.i(161326);
                        this.__eventId = mc.class.getName().hashCode();
                        AppMethodBeat.o(161326);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(mc mcVar) {
                        AppMethodBeat.i(23244);
                        u.cLy().a(new com.tencent.mm.plugin.exdevice.j.i(mcVar.dRB.opType));
                        AppMethodBeat.o(23244);
                        return true;
                    }
                };
                public IListener ryv = new IListener<es>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass23 */

                    {
                        AppMethodBeat.i(161337);
                        this.__eventId = es.class.getName().hashCode();
                        AppMethodBeat.o(161337);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(es esVar) {
                        AppMethodBeat.i(23255);
                        e eVar = e.this;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
                        es esVar2 = esVar;
                        if (Util.isNullOrNil(esVar2.dIa.userName)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
                            AppMethodBeat.o(23255);
                            return false;
                        }
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
                        e.dh(esVar2.dIa.userName, -1);
                        if ((esVar2.dIa.op == 0 || esVar2.dIa.op == 3) && i.INSTANCE.lQ(false)) {
                            i.INSTANCE.a(esVar2.dIa.context, new i.a(esVar2) {
                                /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass39 */
                                final /* synthetic */ es rzm;

                                {
                                    this.rzm = r2;
                                }

                                @Override // com.tencent.mm.plugin.exdevice.model.i.a
                                public final void lP(boolean z) {
                                    AppMethodBeat.i(23271);
                                    if (z) {
                                        e.this.aR(this.rzm.dIa.op, this.rzm.dIa.userName);
                                    }
                                    AppMethodBeat.o(23271);
                                }
                            });
                            AppMethodBeat.o(23255);
                            return true;
                        }
                        boolean aR = eVar.aR(esVar2.dIa.op, esVar2.dIa.userName);
                        AppMethodBeat.o(23255);
                        return aR;
                    }
                };
                public IListener ryw = new IListener<dr>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass34 */

                    {
                        AppMethodBeat.i(161348);
                        this.__eventId = dr.class.getName().hashCode();
                        AppMethodBeat.o(161348);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(dr drVar) {
                        AppMethodBeat.i(23266);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceBindHardDeviceEvent");
                        dr drVar2 = drVar;
                        int i2 = drVar2.dGF.opType;
                        int i3 = drVar2.dGF.dGI;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now optype is %d, subscribeFlag is %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i2 == 1) {
                            l lVar = new l(drVar2.dGF.dGH, i3);
                            bg.azz().a(lVar, 0);
                            drVar2.dGG.dGJ = lVar;
                        } else if (i2 == 2 && drVar2.dGF.dGJ != null) {
                            bg.azz().a((l) drVar2.dGF.dGJ);
                        }
                        AppMethodBeat.o(23266);
                        return true;
                    }
                };
                public IListener ryx = new IListener<fm>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass42 */

                    {
                        AppMethodBeat.i(161350);
                        this.__eventId = fm.class.getName().hashCode();
                        AppMethodBeat.o(161350);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(fm fmVar) {
                        AppMethodBeat.i(23274);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
                        ad.cKS().Gw(0);
                        fm fmVar2 = fmVar;
                        if (Util.isNullOrNil(fmVar2.dIM.brandName)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                            AppMethodBeat.o(23274);
                            return false;
                        }
                        cat cat = new cat();
                        cat.oTH = "";
                        cat.KLO = fmVar2.dIM.brandName;
                        bg.azz().a(new x(cat, 1), 0);
                        AppMethodBeat.o(23274);
                        return true;
                    }
                };
                public IListener ryy = new IListener<wz>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass43 */

                    {
                        AppMethodBeat.i(161351);
                        this.__eventId = wz.class.getName().hashCode();
                        AppMethodBeat.o(161351);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(wz wzVar) {
                        AppMethodBeat.i(23275);
                        boolean cKw = e.cKw();
                        AppMethodBeat.o(23275);
                        return cKw;
                    }
                };
                public IListener ryz = new IListener<xa>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass44 */

                    {
                        AppMethodBeat.i(161352);
                        this.__eventId = xa.class.getName().hashCode();
                        AppMethodBeat.o(161352);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(xa xaVar) {
                        AppMethodBeat.i(23276);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
                        ad.cKS();
                        d.lO(xaVar.edt.edu);
                        AppMethodBeat.o(23276);
                        return true;
                    }
                };
                public IListener rza = new IListener<ds>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass29 */

                    {
                        AppMethodBeat.i(161343);
                        this.__eventId = ds.class.getName().hashCode();
                        AppMethodBeat.o(161343);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(ds dsVar) {
                        AppMethodBeat.i(23261);
                        e eVar = e.this;
                        String str = dsVar.dGK.dGL;
                        g gVar = eVar.rzh;
                        gVar.rzA.remove(str);
                        if (gVar.rzG.get(str) != null) {
                            Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.rzG.get(str));
                            Java2CExDevice.cancelWCLanDeviceTask(gVar.rzG.get(str).intValue());
                        }
                        AppMethodBeat.o(23261);
                        return true;
                    }
                };
                public IListener rzb = new IListener<et>() {
                    /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass30 */

                    {
                        AppMethodBeat.i(161344);
                        this.__eventId = et.class.getName().hashCode();
                        AppMethodBeat.o(161344);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(et etVar) {
                        AppMethodBeat.i(23262);
                        e eVar = e.this;
                        et etVar2 = etVar;
                        if (eVar.rzg == null) {
                            eVar.rzg = new ExdeviceWCLanSDKUtil();
                        }
                        ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil = eVar.rzg;
                        if (etVar2.dIb.dGW) {
                            Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "initWCLanDeviceLib...");
                            Java2CExDevice.initWCLanDeviceLib();
                            j.cKC().a(14, exdeviceWCLanSDKUtil.rzI);
                            j.cKC().a(10, exdeviceWCLanSDKUtil.rAa);
                            j.cKC().a(13, exdeviceWCLanSDKUtil.rzK);
                            j.cKC().a(16, exdeviceWCLanSDKUtil.rAb);
                        } else {
                            bg.aAk().postToWorker(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: INVOKE  
                                  (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x005b: INVOKE  (r1v3 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.model.bg.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                                  (wrap: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$5 : 0x0061: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$5) = (r0v1 'exdeviceWCLanSDKUtil' com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil) call: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.5.<init>(com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.exdevice.model.e.30.callback(com.tencent.mm.g.a.et):boolean, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0061: CONSTRUCTOR  (r2v0 com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil$5) = (r0v1 'exdeviceWCLanSDKUtil' com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil) call: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.5.<init>(com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.exdevice.model.e.30.callback(com.tencent.mm.g.a.et):boolean, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 19 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 25 more
                                */
                            /*
                            // Method dump skipped, instructions count: 163
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.e.AnonymousClass30.callback(com.tencent.mm.sdk.event.IEvent):boolean");
                        }
                    };
                    public IListener rzc = new IListener<fk>() {
                        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass31 */

                        {
                            AppMethodBeat.i(161345);
                            this.__eventId = fk.class.getName().hashCode();
                            AppMethodBeat.o(161345);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(fk fkVar) {
                            AppMethodBeat.i(23263);
                            if (fkVar.dIK.dGW) {
                                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "startScanWCLanDevice...");
                                Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
                            } else {
                                Log.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "stopScanWCLanDevice...");
                                Java2CExDevice.stopScanWCLanDevice();
                            }
                            AppMethodBeat.o(23263);
                            return true;
                        }
                    };
                    public IListener rzd = new IListener<dx>() {
                        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass32 */

                        {
                            AppMethodBeat.i(161346);
                            this.__eventId = dx.class.getName().hashCode();
                            AppMethodBeat.o(161346);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(dx dxVar) {
                            AppMethodBeat.i(23264);
                            e eVar = e.this;
                            dx dxVar2 = dxVar;
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceConnectLanDeviceEvent: brandName=%s, deviceId=%s, type=%b", dxVar2.dGY.brandName, dxVar2.dGY.dGL, Boolean.valueOf(dxVar2.dGY.dGW));
                            if (!e.ans(dxVar2.dGY.brandName)) {
                                dxVar2.dGZ.dGX = false;
                                AppMethodBeat.o(23264);
                                return false;
                            }
                            com.tencent.mm.plugin.exdevice.i.b anJ = ad.cKL().anJ(dxVar2.dGY.dGL);
                            if (anJ == null) {
                                dxVar2.dGZ.dGX = false;
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo null, %s", dxVar2.dGY.dGL);
                                AppMethodBeat.o(23264);
                                return false;
                            } else if (!anJ.field_brandName.equals(dxVar2.dGY.brandName)) {
                                dxVar2.dGZ.dGX = false;
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "brand name not match. %s != %s", anJ.field_brandName, dxVar2.dGY.brandName);
                                AppMethodBeat.o(23264);
                                return false;
                            } else {
                                boolean aR = eVar.rzg.aR(dxVar2.dGY.dGL, dxVar2.dGY.dGW);
                                dxVar2.dGZ.dGX = aR;
                                AppMethodBeat.o(23264);
                                return aR;
                            }
                        }
                    };
                    public IListener rze = new IListener<ex>() {
                        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass33 */

                        {
                            AppMethodBeat.i(161347);
                            this.__eventId = ex.class.getName().hashCode();
                            AppMethodBeat.o(161347);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(ex exVar) {
                            AppMethodBeat.i(23265);
                            e eVar = e.this;
                            ex exVar2 = exVar;
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceSendDataToLanDeviceEvent: brandName=%s, deviceId=%s", exVar2.dIj.brandName, exVar2.dIj.dGL);
                            if (!e.ans(exVar2.dIj.brandName) || Util.isNullOrNil(exVar2.dIj.data)) {
                                exVar2.dIk.dGX = false;
                                AppMethodBeat.o(23265);
                                return false;
                            } else if (ad.cKL().anJ(exVar2.dIj.dGL) == null) {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                                exVar2.dIk.dGX = false;
                                AppMethodBeat.o(23265);
                                return false;
                            } else {
                                exVar2.dIk.dGX = eVar.rzg.ga(exVar2.dIj.dGL, exVar2.dIj.data);
                                AppMethodBeat.o(23265);
                                return true;
                            }
                        }
                    };
                    public IListener rzf = new IListener<ec>() {
                        /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass35 */

                        {
                            AppMethodBeat.i(161349);
                            this.__eventId = ec.class.getName().hashCode();
                            AppMethodBeat.o(161349);
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(ec ecVar) {
                            AppMethodBeat.i(23267);
                            boolean b2 = e.this.b(ecVar);
                            AppMethodBeat.o(23267);
                            return b2;
                        }
                    };
                    ExdeviceWCLanSDKUtil rzg;
                    g rzh;
                    private boolean rzi = false;
                    private c rzj;

                    public interface b {
                        void b(String str, byte[] bArr, boolean z);

                        void c(String str, int i2, long j2);

                        void p(String str, String str2, boolean z);
                    }

                    public e() {
                        AppMethodBeat.i(23284);
                        AppMethodBeat.o(23284);
                    }

                    /* access modifiers changed from: package-private */
                    public final boolean b(IEvent iEvent) {
                        AppMethodBeat.i(23285);
                        ec ecVar = (ec) iEvent;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", ecVar.dHl.brandName, ecVar.dHl.context);
                        if (!ans(ecVar.dHl.brandName)) {
                            ecVar.dHm.dHk = null;
                            ecVar.dHm.dGX = false;
                            AppMethodBeat.o(23285);
                        } else {
                            LinkedList<com.tencent.mm.plugin.exdevice.i.b> anL = ad.cKL().anL(ecVar.dHl.brandName);
                            JSONArray jSONArray = new JSONArray();
                            try {
                                Iterator<com.tencent.mm.plugin.exdevice.i.b> it = anL.iterator();
                                while (it.hasNext()) {
                                    com.tencent.mm.plugin.exdevice.i.b next = it.next();
                                    if (!anL.isEmpty() && Util.nullAsNil(next.field_connProto).contains("4")) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("deviceId", next.field_deviceID);
                                        if (this.rzg.anw(next.field_deviceID)) {
                                            jSONObject.put("state", "connected");
                                        } else {
                                            jSONObject.put("state", "disconnected");
                                        }
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e2.getMessage());
                            }
                            ecVar.dHm.dHk = jSONArray;
                            ecVar.dHm.dGX = true;
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
                            AppMethodBeat.o(23285);
                        }
                        return true;
                    }

                    static boolean o(String str, List<com.tencent.mm.plugin.exdevice.i.b> list) {
                        JSONArray jSONArray;
                        AppMethodBeat.i(23286);
                        String host = Uri.parse(str).getHost();
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
                        JSONArray jSONArray2 = null;
                        boolean z = false;
                        for (com.tencent.mm.plugin.exdevice.i.b bVar : list) {
                            String str2 = bVar.fMh;
                            String str3 = bVar.fMi;
                            if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
                                try {
                                    jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
                                } catch (JSONException e2) {
                                    Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                                    jSONArray = jSONArray2;
                                }
                                int length = jSONArray.length();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length) {
                                        break;
                                    }
                                    try {
                                        if (jSONArray.getString(i2).equals(host)) {
                                            z = true;
                                            break;
                                        }
                                        i2++;
                                    } catch (JSONException e3) {
                                        Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e3, "", new Object[0]);
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                jSONArray2 = jSONArray;
                            }
                        }
                        AppMethodBeat.o(23286);
                        return z;
                    }

                    static boolean p(String str, List<com.tencent.mm.plugin.exdevice.i.b> list) {
                        boolean z;
                        AppMethodBeat.i(23287);
                        if (str == null) {
                            AppMethodBeat.o(23287);
                            return false;
                        }
                        kf kfVar = new kf();
                        kfVar.dPf.dHp = str;
                        EventCenter.instance.publish(kfVar);
                        TimeLineObject timeLineObject = kfVar.dPg.dPh;
                        int i2 = timeLineObject.ContentObj.LoU;
                        if (i2 == 1) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                String str2 = it.next().fMh;
                                if (str2 != null && str2.contains("wxmsg_image")) {
                                    z = true;
                                    break;
                                }
                            }
                        } else if (i2 == 4 || i2 == 42) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = false;
                                    break;
                                }
                                String str3 = it2.next().fMh;
                                if (str3 != null && str3.contains("wxmsg_music")) {
                                    z = true;
                                    break;
                                }
                            }
                        } else if (i2 == 15) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it3 = list.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    z = false;
                                    break;
                                }
                                String str4 = it3.next().fMh;
                                if (str4 != null && str4.contains("wxmsg_video")) {
                                    z = true;
                                    break;
                                }
                            }
                        } else {
                            z = i2 == 3 ? o(timeLineObject.ContentObj.Url, list) : false;
                        }
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
                        AppMethodBeat.o(23287);
                        return z;
                    }

                    static boolean c(IEvent iEvent) {
                        AppMethodBeat.i(23288);
                        eb ebVar = (eb) iEvent;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", ebVar.dHi.brandName, ebVar.dHi.context);
                        LinkedList<com.tencent.mm.plugin.exdevice.i.b> anL = ad.cKL().anL(ebVar.dHi.brandName);
                        JSONArray jSONArray = new JSONArray();
                        try {
                            Iterator<com.tencent.mm.plugin.exdevice.i.b> it = anL.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.exdevice.i.b next = it.next();
                                if (!anL.isEmpty()) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("deviceId", next.field_deviceID);
                                    if (u.cLx().CW(next.field_mac)) {
                                        jSONObject.put("state", "connected");
                                    } else {
                                        jSONObject.put("state", "disconnected");
                                    }
                                    jSONArray.put(jSONObject);
                                }
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", e2.getMessage());
                        }
                        ebVar.dHj.dHk = jSONArray;
                        ebVar.dHj.dGX = true;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", jSONArray.toString());
                        AppMethodBeat.o(23288);
                        return true;
                    }

                    static boolean d(IEvent iEvent) {
                        AppMethodBeat.i(23289);
                        ew ewVar = (ew) iEvent;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", ewVar.dIh.brandName, ewVar.dIh.dGL);
                        if (Util.isNullOrNil(ewVar.dIh.data)) {
                            ewVar.dIi.dGX = false;
                            AppMethodBeat.o(23289);
                            return false;
                        }
                        com.tencent.mm.plugin.exdevice.i.b anJ = ad.cKL().anJ(ewVar.dIh.dGL);
                        if (anJ == null) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                            ewVar.dIi.dGX = false;
                            AppMethodBeat.o(23289);
                            return false;
                        } else if (!u.cLx().CW(anJ.field_mac)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
                            ewVar.dIi.dGX = false;
                            AppMethodBeat.o(23289);
                            return false;
                        } else if (!u.cLx().Dc(anJ.field_mac)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
                            ewVar.dIi.dGX = false;
                            AppMethodBeat.o(23289);
                            return false;
                        } else {
                            if (aa.cKI().rzT) {
                                aa.cKI().Gy(a(anJ));
                            }
                            u.cLy().a(new com.tencent.mm.plugin.exdevice.j.g(ewVar.dIh.data, 10001, anJ.field_mac));
                            ewVar.dIi.dGX = true;
                            AppMethodBeat.o(23289);
                            return true;
                        }
                    }

                    static int a(com.tencent.mm.plugin.exdevice.i.b bVar) {
                        AppMethodBeat.i(23290);
                        int i2 = -1;
                        if (Util.nullAsNil(bVar.field_connProto).contains("1")) {
                            i2 = 1;
                        } else if (Util.nullAsNil(bVar.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                            i2 = 0;
                        }
                        AppMethodBeat.o(23290);
                        return i2;
                    }

                    /* access modifiers changed from: package-private */
                    public final boolean e(IEvent iEvent) {
                        AppMethodBeat.i(23291);
                        final ee eeVar = (ee) iEvent;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", eeVar.dHt.brandName, eeVar.dHt.dGL, Integer.valueOf(eeVar.dHt.type));
                        boc boc = new boc();
                        boc.LWr = eeVar.dHt.type;
                        boc.LWs = 0;
                        boc.KOZ = new cat();
                        boc.KOZ.oTH = eeVar.dHt.dGL;
                        boc.KOZ.KLO = eeVar.dHt.brandName;
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(boc);
                        AnonymousClass36 r2 = new com.tencent.mm.ak.i() {
                            /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass36 */

                            @Override // com.tencent.mm.ak.i
                            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                                boe boe;
                                boolean z;
                                AppMethodBeat.i(23268);
                                if (qVar == null || qVar.getType() != 543) {
                                    eeVar.dHu.dHw = true;
                                    eeVar.dHu.dHx = null;
                                    if (eeVar.callback != null) {
                                        eeVar.callback.run();
                                    }
                                    AppMethodBeat.o(23268);
                                    return;
                                }
                                bg.azz().b(543, this);
                                if (i2 == 0 && i3 == 0) {
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                    z zVar = (z) qVar;
                                    if (zVar.hhm == null || zVar.hhm.iLL.iLR == null) {
                                        boe = null;
                                    } else {
                                        boe = (boe) zVar.hhm.iLL.iLR;
                                    }
                                    Iterator<bof> it = boe.LWv.iterator();
                                    boolean z2 = false;
                                    while (it.hasNext()) {
                                        bof next = it.next();
                                        if (next != null) {
                                            String str2 = null;
                                            String str3 = null;
                                            if (next.KOZ != null) {
                                                str2 = next.KOZ.oTH;
                                                str3 = next.KOZ.KLO;
                                            }
                                            if (next.Ret != 0 || Util.isNullOrNil(next.Bri)) {
                                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "deviceId(%s) get ticket fail. ret=%d, ticket=%s", str2, Integer.valueOf(next.Ret), next.Bri);
                                            } else {
                                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "GetHardDeviceOperTicket end. deviceId=%s, deviceType=%s, ticket=%s, oper=%d", str2, str3, next.Bri, Integer.valueOf(next.LWr));
                                                eeVar.dHu.dHw = true;
                                                eeVar.dHu.dHx = next.Bri;
                                                if (eeVar.callback != null) {
                                                    eeVar.callback.run();
                                                    z = true;
                                                } else {
                                                    z = z2;
                                                }
                                                z2 = z;
                                            }
                                        }
                                    }
                                    if (!z2) {
                                        eeVar.dHu.dHw = true;
                                        eeVar.dHu.dHx = null;
                                        if (eeVar.callback != null) {
                                            eeVar.callback.run();
                                        }
                                    }
                                    AppMethodBeat.o(23268);
                                    return;
                                }
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "getTicketSceneEndImpl errType = [%s], errCode = [%s]， errMsg = [%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                eeVar.dHu.dHw = true;
                                eeVar.dHu.dHx = null;
                                if (eeVar.callback != null) {
                                    eeVar.callback.run();
                                }
                                AppMethodBeat.o(23268);
                            }
                        };
                        z zVar = new z(linkedList, eeVar.dHt.brandName, eeVar.dHt.dHv);
                        bg.azz().a(543, r2);
                        if (!bg.azz().a(zVar, 0)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
                            bg.azz().b(543, r2);
                            eeVar.dHu.dHw = true;
                            eeVar.dHu.dHx = null;
                            if (eeVar.callback != null) {
                                eeVar.callback.run();
                            }
                            AppMethodBeat.o(23291);
                            return true;
                        }
                        AppMethodBeat.o(23291);
                        return false;
                    }

                    /* access modifiers changed from: package-private */
                    public final boolean f(IEvent iEvent) {
                        AppMethodBeat.i(23292);
                        eu euVar = (eu) iEvent;
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", euVar.dIc.brandName, Boolean.valueOf(euVar.dIc.dGW), Integer.valueOf(euVar.dIc.dIe));
                        int i2 = euVar.dIc.dIe;
                        if (!(i2 == 0 || i2 == 1)) {
                            if (com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                                Log.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", Integer.valueOf(i2));
                                i2 = 0;
                            } else {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", Integer.valueOf(i2));
                                euVar.dId.dGX = false;
                                AppMethodBeat.o(23292);
                                return false;
                            }
                        }
                        if (euVar.dIc.dGW) {
                            aa cKI = aa.cKI();
                            String str = euVar.dIc.brandName;
                            AnonymousClass37 r5 = new aa.a() {
                                /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass37 */

                                @Override // com.tencent.mm.plugin.exdevice.model.aa.a
                                public final void a(String str, byte[] bArr, boolean z) {
                                    AppMethodBeat.i(23269);
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", str);
                                    if (bArr == null) {
                                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", str, Boolean.valueOf(z));
                                    } else {
                                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z));
                                    }
                                    er erVar = new er();
                                    erVar.dHZ.dHR = bArr;
                                    erVar.dHZ.dGL = str;
                                    erVar.dHZ.brW = z;
                                    EventCenter.instance.asyncPublish(erVar, Looper.getMainLooper());
                                    AppMethodBeat.o(23269);
                                }
                            };
                            Log.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", str);
                            if (Util.isNullOrNil(str)) {
                                Log.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
                            } else {
                                cKI.rzn = str;
                                cKI.rAF = r5;
                                cKI.rAG.clear();
                                Iterator<q> it = cKI.rAH.iterator();
                                while (it.hasNext()) {
                                    q next = it.next();
                                    if (next != null) {
                                        bg.azz().a(next);
                                    }
                                }
                                cKI.rAH.clear();
                                synchronized (aa.duI) {
                                    try {
                                        aa.rAI.clear();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(23292);
                                        throw th;
                                    }
                                }
                                if (!cKI.rzT) {
                                    cKI.rzT = true;
                                    bg.azz().a(542, cKI);
                                    ad.cKS().a(i2, cKI);
                                    Log.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                                    cKI.klF.startTimer(12000);
                                } else {
                                    Log.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                                }
                            }
                        } else {
                            aa.cKI().Gy(i2);
                        }
                        euVar.dId.dGX = true;
                        AppMethodBeat.o(23292);
                        return true;
                    }

                    static boolean ans(String str) {
                        AppMethodBeat.i(23293);
                        com.tencent.mm.api.c fJ = g.fJ(str);
                        if (fJ == null) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
                            AppMethodBeat.o(23293);
                            return false;
                        }
                        c.b cG = fJ.cG(false);
                        if (cG == null || cG.UZ() == null || !cG.UZ().Vi()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
                            AppMethodBeat.o(23293);
                            return false;
                        }
                        AppMethodBeat.o(23293);
                        return true;
                    }

                    /* access modifiers changed from: package-private */
                    public class c implements Runnable {
                        List<com.tencent.mm.plugin.exdevice.i.b> iHg;

                        public c(List<com.tencent.mm.plugin.exdevice.i.b> list) {
                            this.iHg = list;
                        }

                        public final void run() {
                            AppMethodBeat.i(23283);
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
                            if (this.iHg != null && this.iHg.size() > 0) {
                                for (com.tencent.mm.plugin.exdevice.i.b bVar : this.iHg) {
                                    u.cLy().a(new com.tencent.mm.plugin.exdevice.j.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                                }
                                e.this.mHandler.postDelayed(this, 300000);
                            }
                            AppMethodBeat.o(23283);
                        }
                    }

                    static boolean a(com.tencent.mm.plugin.exdevice.i.b bVar, int i2, int i3) {
                        AppMethodBeat.i(23294);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
                        if (bVar == null) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
                            AppMethodBeat.o(23294);
                            return false;
                        }
                        String str = bVar.field_brandName;
                        f.a CY = u.cLx().CY(bVar.field_mac);
                        if (CY == null) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
                            AppMethodBeat.o(23294);
                            return false;
                        }
                        if (CY.dHO == 2) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", str);
                            u.cLy().a(new j(i2, i3, bVar.field_mac));
                        }
                        ad.cKS().Gw(i2 == 1 ? 1 : 0);
                        if (i2 == 2) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
                            MTimerHandler remove = ad.cKS().rya.remove(Long.valueOf(bVar.field_mac));
                            if (remove != null) {
                                remove.stopTimer();
                            }
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", Integer.valueOf(bVar.field_closeStrategy));
                            if (!((bVar.field_closeStrategy & 1) == 0 && u.cLx().Dc(CY.rDD) && (2 == CY.dHO || CY.dHO == 0))) {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", Integer.valueOf(CY.dHO), str);
                                if (u.cLy().rxT != null) {
                                    u.cLy().rxT.De(CY.rDD);
                                }
                            }
                            if (f.b(bVar)) {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", Long.valueOf(bVar.field_mac));
                                ant(com.tencent.mm.plugin.exdevice.k.b.Dj(bVar.field_mac));
                            }
                            AppMethodBeat.o(23294);
                            return true;
                        } else if (2 == CY.dHO || o.e.JSY == null || !o.e.JSY.fVV()) {
                            AppMethodBeat.o(23294);
                            return true;
                        } else {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
                            AppMethodBeat.o(23294);
                            return false;
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public final boolean o(List<com.tencent.mm.plugin.exdevice.i.b> list, int i2) {
                        AppMethodBeat.i(23295);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
                        if (list.size() == 0) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
                            AppMethodBeat.o(23295);
                            return false;
                        }
                        int i3 = -1;
                        switch (i2) {
                            case 1:
                                if (this.rzi) {
                                    this.mHandler.removeCallbacks(this.rzj);
                                }
                                this.rzj = new c(list);
                                this.mHandler.postDelayed(this.rzj, 300000);
                                this.rzi = true;
                                i3 = 2;
                                break;
                            case 2:
                                if (this.rzi) {
                                    this.mHandler.removeCallbacks(this.rzj);
                                    this.rzi = false;
                                }
                                i3 = 0;
                                break;
                        }
                        for (com.tencent.mm.plugin.exdevice.i.b bVar : list) {
                            u.cLy().a(new com.tencent.mm.plugin.exdevice.j.k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i3));
                        }
                        AppMethodBeat.o(23295);
                        return true;
                    }

                    static boolean cKv() {
                        AppMethodBeat.i(23296);
                        LinkedList<com.tencent.mm.plugin.exdevice.i.b> cLC = ad.cKL().cLC();
                        if (cLC.isEmpty()) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
                            AppMethodBeat.o(23296);
                            return false;
                        }
                        ad.cKS().Gw(2);
                        Iterator<com.tencent.mm.plugin.exdevice.i.b> it = cLC.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.exdevice.i.b next = it.next();
                            bg.aVF();
                            as Kn = com.tencent.mm.model.c.aSN().Kn(next.field_brandName);
                            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                                Log.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", next.field_brandName);
                            } else if ((next.field_connStrategy & 4) == 0) {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", Integer.valueOf(next.field_connStrategy));
                            } else {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", next.field_brandName);
                                ad.cKS().a(next.field_brandName, next.field_mac, 0, true);
                            }
                        }
                        AppMethodBeat.o(23296);
                        return true;
                    }

                    static boolean cKw() {
                        AppMethodBeat.i(23297);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
                        ad.cKS();
                        d.lO(false);
                        ad.cKS().cKu();
                        AppMethodBeat.o(23297);
                        return true;
                    }

                    /* access modifiers changed from: package-private */
                    public final boolean aR(int i2, String str) {
                        c.b.C0261b UZ;
                        int i3;
                        int i4;
                        int i5;
                        AppMethodBeat.i(23298);
                        Log.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
                        com.tencent.mm.api.c fJ = g.fJ(str);
                        if (fJ == null) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
                            AppMethodBeat.o(23298);
                            return false;
                        }
                        c.b cG = fJ.cG(false);
                        if (cG == null || (UZ = cG.UZ()) == null || !UZ.Vi()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
                            AppMethodBeat.o(23298);
                            return false;
                        }
                        LinkedList<com.tencent.mm.plugin.exdevice.i.b> anL = ad.cKL().anL(str);
                        if (UZ.dih == 1) {
                            LinkedList<com.tencent.mm.plugin.exdevice.i.b> cLC = ad.cKL().cLC();
                            if (cLC.size() != 0) {
                                for (com.tencent.mm.plugin.exdevice.i.b bVar : cLC) {
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.fMg));
                                    if (0 != (bVar.fMg & 1)) {
                                        anL.add(bVar);
                                    }
                                }
                            }
                        }
                        if (anL == null) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                            AppMethodBeat.o(23298);
                            return false;
                        } else if (anL.size() == 0) {
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                            AppMethodBeat.o(23298);
                            return true;
                        } else {
                            int i6 = 0;
                            int i7 = 0;
                            for (com.tencent.mm.plugin.exdevice.i.b bVar2 : anL) {
                                if (bVar2 == null) {
                                    Log.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                                } else if (Util.nullAsNil(bVar2.field_connProto).contains("4")) {
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", bVar2.field_brandName);
                                } else if ((bVar2.field_connStrategy & 16) != 0) {
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy));
                                } else {
                                    if (Util.nullAsNil(bVar2.field_connProto).contains("1")) {
                                        int i8 = i6 + 1;
                                        if (!com.tencent.mm.plugin.d.a.e.a.ckN()) {
                                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", bVar2.field_brandName);
                                            i6 = i8;
                                        } else {
                                            i3 = 1;
                                            i4 = i7;
                                            i5 = i8;
                                        }
                                    } else if (Util.nullAsNil(bVar2.field_connProto).contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                        int i9 = i7 + 1;
                                        if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                            i7 = i9;
                                        } else {
                                            i3 = 0;
                                            i4 = i9;
                                            i5 = i6;
                                        }
                                    } else {
                                        i3 = -1;
                                        i4 = i7;
                                        i5 = i6;
                                    }
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", Integer.valueOf(i2), bVar2.field_brandName, bVar2.field_connProto);
                                    if (i2 == 0) {
                                        d cKS = ad.cKS();
                                        long j2 = bVar2.field_mac;
                                        Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", Long.valueOf(j2));
                                        if (cKS.ryb.containsKey(Long.valueOf(j2))) {
                                            Log.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                            MTimerHandler remove = cKS.ryb.remove(Long.valueOf(j2));
                                            if (remove != null) {
                                                remove.stopTimer();
                                            } else {
                                                Log.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", Long.valueOf(j2));
                                            }
                                        }
                                        if (u.cLx().CW(bVar2.field_mac)) {
                                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", bVar2.field_brandName, Long.valueOf(bVar2.field_mac));
                                            if (u.cLx().Dc(bVar2.field_mac)) {
                                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                                d(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                                i7 = i4;
                                                i6 = i5;
                                            } else {
                                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                                i7 = i4;
                                                i6 = i5;
                                            }
                                        } else if (!d.fd(MMApplicationContext.getContext())) {
                                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                            i7 = i4;
                                            i6 = i5;
                                        } else if (f.b(bVar2)) {
                                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac), bVar2.field_brandName);
                                            a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                            anu(com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac));
                                            i7 = i4;
                                            i6 = i5;
                                        } else {
                                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac), bVar2.field_brandName);
                                            ad.cKS().Gw(1);
                                            ad.cKS().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                            ad.cKS().b(bVar2.field_brandName, bVar2.field_mac, i3);
                                            i7 = i4;
                                            i6 = i5;
                                        }
                                    } else if (i2 != 1) {
                                        if (i2 == 2) {
                                            if (f.b(bVar2)) {
                                                ant(com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac));
                                                i7 = i4;
                                                i6 = i5;
                                            } else {
                                                ad.cKS();
                                                d.CM(bVar2.field_mac);
                                            }
                                        }
                                        i7 = i4;
                                        i6 = i5;
                                    } else if (f.b(bVar2)) {
                                        a(bVar2.field_brandName + bVar2.field_mac, new a(bVar2.field_brandName, com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                        anu(com.tencent.mm.plugin.exdevice.k.b.Dj(bVar2.field_mac));
                                        i7 = i4;
                                        i6 = i5;
                                    } else {
                                        ad.cKS().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                        ad.cKS().b(bVar2.field_brandName, bVar2.field_mac, i3);
                                        i7 = i4;
                                        i6 = i5;
                                    }
                                }
                            }
                            if (i6 + i7 <= 0) {
                                dh(str, -1);
                            } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                                Log.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                                dh(str, 0);
                            } else if (i7 > 0 && i6 == 0 && !com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                                dh(str, 1);
                            }
                            AppMethodBeat.o(23298);
                            return true;
                        }
                    }

                    private static boolean cKx() {
                        AppMethodBeat.i(23299);
                        if (!com.tencent.mm.plugin.d.a.e.a.eL(MMApplicationContext.getContext())) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", Integer.valueOf(Build.VERSION.SDK_INT));
                            AppMethodBeat.o(23299);
                            return false;
                        } else if (!com.tencent.mm.plugin.d.a.e.a.ckP()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
                            AppMethodBeat.o(23299);
                            return false;
                        } else {
                            AppMethodBeat.o(23299);
                            return true;
                        }
                    }

                    public static boolean cKy() {
                        AppMethodBeat.i(23300);
                        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
                        if (!cKx()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
                            AppMethodBeat.o(23300);
                            return false;
                        }
                        ad.cKX().cKB();
                        AppMethodBeat.o(23300);
                        return true;
                    }

                    public static boolean ant(String str) {
                        AppMethodBeat.i(23301);
                        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", str);
                        if (!cKx()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
                            AppMethodBeat.o(23301);
                            return false;
                        } else if (Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                            AppMethodBeat.o(23301);
                            return false;
                        } else {
                            ad.cKX();
                            h.CM(com.tencent.mm.plugin.exdevice.k.b.anY(str));
                            AppMethodBeat.o(23301);
                            return true;
                        }
                    }

                    public final boolean anu(String str) {
                        AppMethodBeat.i(23302);
                        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
                        if (!cKx()) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
                            AppMethodBeat.o(23302);
                            return false;
                        } else if (Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
                            AppMethodBeat.o(23302);
                            return false;
                        } else {
                            ad.cKX().a(com.tencent.mm.plugin.exdevice.k.b.anY(str), new h.a() {
                                /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass40 */

                                @Override // com.tencent.mm.plugin.exdevice.model.h.a
                                public final void a(long j2, int i2, int i3, int i4, long j3) {
                                    LinkedList<b> linkedList;
                                    AppMethodBeat.i(23272);
                                    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j3));
                                    e eVar = e.this;
                                    String Dj = com.tencent.mm.plugin.exdevice.k.b.Dj(j2);
                                    synchronized (eVar.ryr) {
                                        try {
                                            linkedList = new LinkedList(eVar.ryr);
                                        } catch (Throwable th) {
                                            AppMethodBeat.o(23272);
                                            throw th;
                                        }
                                    }
                                    for (b bVar : linkedList) {
                                        bVar.c(Dj, i3, j3);
                                    }
                                    linkedList.clear();
                                    for (b bVar2 : eVar.rys.values()) {
                                        bVar2.c(Dj, i3, j3);
                                    }
                                    fe feVar = new fe();
                                    feVar.dIB.mac = Dj;
                                    feVar.dIB.dHO = i3;
                                    feVar.dIB.dIy = j3;
                                    EventCenter.instance.asyncPublish(feVar, Looper.getMainLooper());
                                    AppMethodBeat.o(23272);
                                }
                            });
                            AppMethodBeat.o(23302);
                            return true;
                        }
                    }

                    public final boolean n(String str, byte[] bArr) {
                        AppMethodBeat.i(23303);
                        if (Util.isNullOrNil(str) || Util.isNullOrNil(bArr)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = Util.isNullOrNil(str) ? BuildConfig.COMMAND : TPDownloadProxyEnum.USER_MAC;
                            objArr[1] = Integer.valueOf(Util.isNullOrNil(bArr) ? 0 : bArr.length);
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, dataLen = %d", objArr);
                            AppMethodBeat.o(23303);
                            return false;
                        }
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Util.isNullOrNil(str) ? BuildConfig.COMMAND : str;
                        objArr2[1] = Integer.valueOf(Util.isNullOrNil(bArr) ? 0 : bArr.length);
                        Log.e("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d", objArr2);
                        long anY = com.tencent.mm.plugin.exdevice.k.b.anY(str);
                        f.a CZ = ad.cKX().rzU.CZ(anY);
                        if (CZ == null) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
                            AppMethodBeat.o(23303);
                            return false;
                        } else if (CZ.dHO != 2) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
                            AppMethodBeat.o(23303);
                            return false;
                        } else {
                            ad.cKX();
                            boolean a2 = h.a(anY, bArr, new t.a() {
                                /* class com.tencent.mm.plugin.exdevice.model.e.AnonymousClass41 */

                                @Override // com.tencent.mm.plugin.exdevice.service.t
                                public final void b(long j2, int i2, int i3, String str) {
                                    boolean z;
                                    LinkedList<b> linkedList;
                                    AppMethodBeat.i(23273);
                                    Object[] objArr = new Object[4];
                                    objArr[0] = Long.valueOf(j2);
                                    objArr[1] = Integer.valueOf(i2);
                                    objArr[2] = Integer.valueOf(i3);
                                    if (str == null) {
                                        str = BuildConfig.COMMAND;
                                    }
                                    objArr[3] = str;
                                    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onSendEnd. mac=%d, errType=%d, errCode=%d, errMsg=%s", objArr);
                                    e eVar = e.this;
                                    String Dj = com.tencent.mm.plugin.exdevice.k.b.Dj(j2);
                                    if (i3 == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "notifySimpleBTOnSend, mac : %s, isSucc : %s", Dj, Boolean.valueOf(z));
                                    if (!z) {
                                        synchronized (eVar.ryr) {
                                            try {
                                                linkedList = new LinkedList(eVar.ryr);
                                            } finally {
                                                AppMethodBeat.o(23273);
                                            }
                                        }
                                        for (b bVar : linkedList) {
                                            bVar.b(Dj, null, false);
                                        }
                                        linkedList.clear();
                                        for (b bVar2 : eVar.rys.values()) {
                                            bVar2.b(Dj, null, false);
                                        }
                                    }
                                }
                            });
                            AppMethodBeat.o(23303);
                            return a2;
                        }
                    }

                    public static boolean b(String str, String str2, byte[] bArr) {
                        AppMethodBeat.i(23304);
                        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || Util.isNullOrNil(bArr)) {
                            Object[] objArr = new Object[3];
                            if (Util.isNullOrNil(str)) {
                                str = BuildConfig.COMMAND;
                            }
                            objArr[0] = str;
                            if (Util.isNullOrNil(str2)) {
                                str2 = BuildConfig.COMMAND;
                            }
                            objArr[1] = str2;
                            objArr[2] = Integer.valueOf(Util.isNullOrNil(bArr) ? 0 : bArr.length);
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "input error. mac = %s, brandName = %s, dataLen = %d", objArr);
                            AppMethodBeat.o(23304);
                            return false;
                        }
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Util.isNullOrNil(str) ? BuildConfig.COMMAND : str;
                        objArr2[1] = Util.isNullOrNil(str2) ? BuildConfig.COMMAND : str2;
                        objArr2[2] = Integer.valueOf(Util.isNullOrNil(bArr) ? 0 : bArr.length);
                        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d", objArr2);
                        com.tencent.mm.plugin.exdevice.i.b Di = ad.cKL().Di(com.tencent.mm.plugin.exdevice.k.b.anY(str));
                        if (Di == null) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", str, str2);
                            AppMethodBeat.o(23304);
                            return false;
                        }
                        com.tencent.mm.plugin.d.a.b.a.a aX = com.tencent.mm.plugin.d.a.b.a.a.aX(bArr);
                        if (1 != aX.phx) {
                            Log.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", 1L, Long.valueOf(aX.phx));
                            AppMethodBeat.o(23304);
                            return false;
                        }
                        com.tencent.mm.plugin.d.a.b.a.f fVar = (com.tencent.mm.plugin.d.a.b.a.f) aX;
                        Calendar instance = Calendar.getInstance();
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        ((com.tencent.mm.plugin.sport.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sport.a.b.class)).b(Di.field_deviceID, Di.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.pjj, "");
                        AppMethodBeat.o(23304);
                        return true;
                    }

                    public final void o(String str, String str2, boolean z) {
                        LinkedList<b> linkedList;
                        AppMethodBeat.i(23305);
                        synchronized (this.ryr) {
                            try {
                                linkedList = new LinkedList(this.ryr);
                            } catch (Throwable th) {
                                AppMethodBeat.o(23305);
                                throw th;
                            }
                        }
                        for (b bVar : linkedList) {
                            bVar.p(str, str2, z);
                        }
                        linkedList.clear();
                        for (b bVar2 : this.rys.values()) {
                            bVar2.p(str, str2, z);
                        }
                        Log.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
                        fg fgVar = new fg();
                        fgVar.dID.dIx = str;
                        fgVar.dID.mac = str2;
                        fgVar.dID.brW = z;
                        EventCenter.instance.asyncPublish(fgVar, Looper.getMainLooper());
                        AppMethodBeat.o(23305);
                    }

                    public static void d(String str, String str2, int i2, String str3) {
                        AppMethodBeat.i(23306);
                        or orVar = new or();
                        orVar.dUI.op = 2;
                        orVar.dUI.dRD = str;
                        orVar.dUI.dHO = i2;
                        orVar.dUI.url = str2;
                        orVar.dUI.dGL = str3;
                        EventCenter.instance.asyncPublish(orVar, Looper.getMainLooper());
                        AppMethodBeat.o(23306);
                    }

                    public static void dh(String str, int i2) {
                        AppMethodBeat.i(23307);
                        or orVar = new or();
                        orVar.dUI.op = 1;
                        orVar.dUI.dRD = str;
                        orVar.dUI.bDZ = i2;
                        EventCenter.instance.asyncPublish(orVar, Looper.getMainLooper());
                        AppMethodBeat.o(23307);
                    }

                    public static void c(String str, String str2, byte[] bArr) {
                        AppMethodBeat.i(23308);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", str, str2);
                        eq eqVar = new eq();
                        eqVar.dHY.dGL = str;
                        eqVar.dHY.brandName = str2;
                        eqVar.dHY.data = bArr;
                        EventCenter.instance.asyncPublish(eqVar, Looper.getMainLooper());
                        AppMethodBeat.o(23308);
                    }

                    public static void aQ(String str, boolean z) {
                        AppMethodBeat.i(23309);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", str, Boolean.valueOf(z));
                        ep epVar = new ep();
                        epVar.dHX.dGL = str;
                        epVar.dHX.dGT = z;
                        EventCenter.instance.asyncPublish(epVar, Looper.getMainLooper());
                        AppMethodBeat.o(23309);
                    }

                    public final boolean a(b bVar) {
                        AppMethodBeat.i(23310);
                        if (this.ryr.contains(bVar)) {
                            AppMethodBeat.o(23310);
                            return false;
                        }
                        boolean add = this.ryr.add(bVar);
                        AppMethodBeat.o(23310);
                        return add;
                    }

                    public final boolean b(b bVar) {
                        AppMethodBeat.i(23311);
                        if (this.ryr.remove(bVar)) {
                            AppMethodBeat.o(23311);
                            return true;
                        }
                        AppMethodBeat.o(23311);
                        return false;
                    }

                    private b a(String str, b bVar) {
                        AppMethodBeat.i(23312);
                        b put = this.rys.put(str, bVar);
                        AppMethodBeat.o(23312);
                        return put;
                    }

                    static boolean cKz() {
                        AppMethodBeat.i(23313);
                        Log.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
                        Context context = MMApplicationContext.getContext();
                        try {
                            ad.cKS().cKu();
                        } catch (Exception e2) {
                            Log.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e2, "", new Object[0]);
                        }
                        com.tencent.mm.br.c.o(new Intent(context, ExDeviceService.class), "exdevice");
                        AppMethodBeat.o(23313);
                        return true;
                    }

                    public class a implements b {
                        private String dfJ;
                        private String mURL;
                        private String rzn;
                        private String rzo;

                        public a(String str, String str2, String str3, String str4) {
                            AppMethodBeat.i(23279);
                            this.rzn = str;
                            this.dfJ = str2;
                            this.mURL = str3;
                            this.rzo = str4;
                            Log.d("MicroMsg.exdevice.ExdeviceEventManager", "brandName : %s, mac : %s.", str, str2);
                            AppMethodBeat.o(23279);
                        }

                        @Override // com.tencent.mm.plugin.exdevice.model.e.b
                        public final void p(String str, String str2, boolean z) {
                            AppMethodBeat.i(23280);
                            if (this.dfJ == null || !this.dfJ.equals(str2)) {
                                Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onScanResult, mac(%s) is null or not correct.(mac : %s, isCompleted : %s)", this.dfJ, str2, Boolean.valueOf(z));
                                AppMethodBeat.o(23280);
                                return;
                            }
                            AppMethodBeat.o(23280);
                        }

                        @Override // com.tencent.mm.plugin.exdevice.model.e.b
                        public final void b(String str, byte[] bArr, boolean z) {
                            AppMethodBeat.i(23281);
                            if (this.dfJ == null || !this.dfJ.equals(str)) {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onRecvFromDevice, mac(%s) is null or not correct.(mac : %s, succ : %s)", this.dfJ, str, Boolean.valueOf(z));
                                AppMethodBeat.o(23281);
                                return;
                            }
                            if (z && bArr != null) {
                                try {
                                    ad.cKW();
                                    if (!e.b(this.dfJ, this.rzn, bArr)) {
                                        Log.w("MicroMsg.exdevice.ExdeviceEventManager", "The parser isn't a correct type.");
                                        AppMethodBeat.o(23281);
                                        return;
                                    }
                                    AppMethodBeat.o(23281);
                                    return;
                                } catch (Exception e2) {
                                    Log.e("MicroMsg.exdevice.ExdeviceEventManager", "Read data from bytes failed.");
                                }
                            }
                            AppMethodBeat.o(23281);
                        }

                        @Override // com.tencent.mm.plugin.exdevice.model.e.b
                        public final void c(String str, int i2, long j2) {
                            AppMethodBeat.i(23282);
                            if (this.dfJ == null || !this.dfJ.equals(str)) {
                                Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, mac(%s) is null or not correct.(mac : %s, state : %s, type : %s)", this.dfJ, str, Integer.valueOf(i2), Long.valueOf(j2));
                                AppMethodBeat.o(23282);
                                return;
                            }
                            Log.i("MicroMsg.exdevice.ExdeviceEventManager", "mac(%s), connectState(%s), profileType(%s)", str, Integer.valueOf(i2), Long.valueOf(j2));
                            switch (i2) {
                                case 0:
                                    e.d(this.rzn, this.mURL, 0, this.rzo);
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device state none.(mac : %s)", str);
                                    AppMethodBeat.o(23282);
                                    return;
                                case 1:
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device is connectiong.(mac: %s)", str);
                                    e.d(this.rzn, this.mURL, 1, this.rzo);
                                    AppMethodBeat.o(23282);
                                    return;
                                case 2:
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device connected now start send data to it.(mac : %s)", str);
                                    e.d(this.rzn, this.mURL, 2, this.rzo);
                                    com.tencent.mm.plugin.d.a.b.a.f fVar = new com.tencent.mm.plugin.d.a.b.a.f();
                                    fVar.pie = com.tencent.mm.plugin.d.a.b.a.f.pjh;
                                    fVar.pif = 2;
                                    ad.cKW().n(this.dfJ, com.tencent.mm.plugin.exdevice.k.b.de(fVar));
                                    AppMethodBeat.o(23282);
                                    return;
                                case 3:
                                default:
                                    Log.d("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, out of range(mac : %s, state : %s, type : %s).", str, Integer.valueOf(i2), Long.valueOf(j2));
                                    e.d(this.rzn, this.mURL, -1, this.rzo);
                                    AppMethodBeat.o(23282);
                                    return;
                                case 4:
                                    e.d(this.rzn, this.mURL, 4, this.rzo);
                                    Log.i("MicroMsg.exdevice.ExdeviceEventManager", "onConnectStateChanged, device disconnected.(mac : %s)", str);
                                    AppMethodBeat.o(23282);
                                    return;
                            }
                        }
                    }
                }
