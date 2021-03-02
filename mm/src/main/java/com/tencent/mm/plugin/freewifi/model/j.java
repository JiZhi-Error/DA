package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.g.a.in;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.te;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.cj;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.freewifi.b.b;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.d.g;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.b;
import com.tencent.mm.plugin.freewifi.model.f;
import com.tencent.mm.plugin.freewifi.model.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class j implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private p netChanged = new p.a() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass7 */
        private byte[] glH = new byte[0];

        {
            AppMethodBeat.i(24817);
            AppMethodBeat.o(24817);
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(24818);
            synchronized (this.glH) {
                try {
                    if (!bg.aAc()) {
                        Log.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "account not ready");
                        return;
                    }
                    Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "onNetworkChange state=" + i2 + ".(-1=NETWORK_UNKNOWN; 0=NETWORK_UNAVAILABLE; 1=NETWORK_CONNECTED; 2=GATEWAY_FAILED; 3=SERVER_FAILED; 4=CONNECTTING; 5=CONNECTED; 6=SERVER_DOWN)");
                    ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                    if (connectivityManager == null) {
                        AppMethodBeat.o(24818);
                        return;
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null) {
                        Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "wifiNetwork:".concat(String.valueOf(networkInfo)));
                        Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " wifiNetwork.isAvailable()=%b,wifiNetwork.isConnected()=%b,wifiNetwork.isConnectedOrConnecting()=%b", Boolean.valueOf(networkInfo.isAvailable()), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()));
                    }
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null) {
                        Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", "mobileNetworkInfo", networkInfo2);
                        Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi.onNetworkChangeFreeWifi", " mobileNetworkInfo.isAvailable()=%b,mobileNetworkInfo.isConnected()=%b,mobileNetworkInfo.isConnectedOrConnecting()=%b", Boolean.valueOf(networkInfo2.isAvailable()), Boolean.valueOf(networkInfo2.isConnected()), Boolean.valueOf(networkInfo2.isConnectedOrConnecting()));
                    }
                    if (6 == i2 || 4 == i2 || i2 == 0 || -1 == i2 || -9 == i2) {
                        if (!networkInfo.isConnected()) {
                            f.a.dNj().dNg();
                            AppMethodBeat.o(24818);
                            return;
                        }
                        boolean ao = f.a.dNj().ao(m.axM("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.axN("MicroMsg.FreeWifi.SubCoreFreeWifi"), m.axO("MicroMsg.FreeWifi.SubCoreFreeWifi"));
                        Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "isWifiIndeedChanged=%b", Boolean.valueOf(ao));
                        if (ao) {
                            j.dNs().dMW();
                        }
                    }
                    AppMethodBeat.o(24818);
                } finally {
                    AppMethodBeat.o(24818);
                }
            }
        }
    };
    private IListener oVk = new IListener<ak>() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass3 */

        {
            AppMethodBeat.i(161371);
            this.__eventId = ak.class.getName().hashCode();
            AppMethodBeat.o(161371);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(ak akVar) {
            return false;
        }
    };
    private cj.a rBq = new cj.a() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass4 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(24816);
            e dNt = j.dNt();
            de deVar = aVar.heO;
            if (1 != i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0)) {
                i.a.dME().dU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 1);
            }
            if (deVar == null || deVar.KHn == null) {
                Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                AppMethodBeat.o(24816);
                return;
            }
            String a2 = z.a(deVar.KHn);
            Log.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", Long.valueOf(deVar.Brn), a2);
            if (m.eP(a2)) {
                Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                AppMethodBeat.o(24816);
                return;
            }
            a axQ = a.axQ(a2);
            if (axQ == null) {
                Log.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                AppMethodBeat.o(24816);
                return;
            }
            new d(m.axM("MicroMsg.FreeWifi.FreeWifiMessageService"), m.axN("MicroMsg.FreeWifi.FreeWifiMessageService"), m.axO("MicroMsg.FreeWifi.FreeWifiMessageService"), axQ.wOt, axQ.wOq, axQ.wOu, axQ.ssid, axQ.bssid).c(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a2: INVOKE  
                  (wrap: com.tencent.mm.plugin.freewifi.d.d : 0x009a: CONSTRUCTOR  (r0v9 com.tencent.mm.plugin.freewifi.d.d) = 
                  (wrap: java.lang.String : 0x0083: INVOKE  (r1v4 java.lang.String) = ("MicroMsg.FreeWifi.FreeWifiMessageService") type: STATIC call: com.tencent.mm.plugin.freewifi.m.axM(java.lang.String):java.lang.String)
                  (wrap: java.lang.String : 0x008a: INVOKE  (r2v1 java.lang.String) = ("MicroMsg.FreeWifi.FreeWifiMessageService") type: STATIC call: com.tencent.mm.plugin.freewifi.m.axN(java.lang.String):java.lang.String)
                  (wrap: java.lang.String : 0x007c: INVOKE  (r3v2 java.lang.String) = ("MicroMsg.FreeWifi.FreeWifiMessageService") type: STATIC call: com.tencent.mm.plugin.freewifi.m.axO(java.lang.String):java.lang.String)
                  (wrap: java.lang.String : 0x008e: IGET  (r4v2 java.lang.String) = (r9v0 'axQ' com.tencent.mm.plugin.freewifi.c.a) com.tencent.mm.plugin.freewifi.c.a.wOt java.lang.String)
                  (wrap: java.lang.String : 0x0090: IGET  (r5v0 java.lang.String) = (r9v0 'axQ' com.tencent.mm.plugin.freewifi.c.a) com.tencent.mm.plugin.freewifi.c.a.wOq java.lang.String)
                  (wrap: long : 0x0092: IGET  (r6v1 long) = (r9v0 'axQ' com.tencent.mm.plugin.freewifi.c.a) com.tencent.mm.plugin.freewifi.c.a.wOu long)
                  (wrap: java.lang.String : 0x0096: IGET  (r8v0 java.lang.String) = (r9v0 'axQ' com.tencent.mm.plugin.freewifi.c.a) com.tencent.mm.plugin.freewifi.c.a.ssid java.lang.String)
                  (wrap: java.lang.String : 0x0098: IGET  (r9v1 java.lang.String) = (r9v0 'axQ' com.tencent.mm.plugin.freewifi.c.a) com.tencent.mm.plugin.freewifi.c.a.bssid java.lang.String)
                 call: com.tencent.mm.plugin.freewifi.d.d.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                  (wrap: com.tencent.mm.plugin.freewifi.model.e$1 : 0x009f: CONSTRUCTOR  (r1v5 com.tencent.mm.plugin.freewifi.model.e$1) = (r10v0 'dNt' com.tencent.mm.plugin.freewifi.model.e), (r11v0 'deVar' com.tencent.mm.protocal.protobuf.de) call: com.tencent.mm.plugin.freewifi.model.e.1.<init>(com.tencent.mm.plugin.freewifi.model.e, com.tencent.mm.protocal.protobuf.de):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.plugin.freewifi.d.d.c(com.tencent.mm.ak.i):void in method: com.tencent.mm.plugin.freewifi.model.j.4.a(com.tencent.mm.ak.h$a):void, file: classes8.dex
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009f: CONSTRUCTOR  (r1v5 com.tencent.mm.plugin.freewifi.model.e$1) = (r10v0 'dNt' com.tencent.mm.plugin.freewifi.model.e), (r11v0 'deVar' com.tencent.mm.protocal.protobuf.de) call: com.tencent.mm.plugin.freewifi.model.e.1.<init>(com.tencent.mm.plugin.freewifi.model.e, com.tencent.mm.protocal.protobuf.de):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.freewifi.model.j.4.a(com.tencent.mm.ak.h$a):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 26 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.freewifi.model.e, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 32 more
                */
            /*
            // Method dump skipped, instructions count: 169
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j.AnonymousClass4.a(com.tencent.mm.ak.h$a):void");
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private volatile d wOY;
    private volatile com.tencent.mm.plugin.freewifi.g.d wOZ;
    private volatile b wPa;
    private volatile com.tencent.mm.plugin.freewifi.g.f wPb;
    private volatile c wPc;
    private volatile c wPd;
    private volatile a wPe;
    private volatile e wPf;
    private IListener wPg = new IListener<bv>() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass8 */

        {
            AppMethodBeat.i(161372);
            this.__eventId = bv.class.getName().hashCode();
            AppMethodBeat.o(161372);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bv bvVar) {
            String str;
            AppMethodBeat.i(24819);
            bv bvVar2 = bvVar;
            Log.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "receive CheckWechatFreeWifiEvent");
            if (d.getNetworkType() != 0) {
                Log.d("MicroMsg.FreeWifi.SubCoreFreeWifi", "not wifi");
            } else {
                j.dNm();
                bvVar2.dFa.dFc = h.b.dMD().getPingUrl();
                bvVar2.dFa.dFb = h.b.dMD().dMB();
                String dNf = d.dNf();
                String dNb = d.dNb();
                if (!Util.isNullOrNil(dNf) && !Util.isNullOrNil(dNb)) {
                    c aya = j.dNn().aya(dNf);
                    if (aya != null) {
                        bvVar2.dFa.dFd = aya.field_url;
                    }
                    bvVar2.dFa.ssid = dNf;
                    bvVar2.dFa.bssid = m.axN("MicroMsg.FreeWifi.FreeWifiManager");
                    bvVar2.dFa.dFe = m.axO("MicroMsg.FreeWifi.FreeWifiManager");
                    if (aya != null && dNf.equalsIgnoreCase(aya.field_ssid) && dNb.equalsIgnoreCase(aya.field_mac)) {
                        bv.a aVar = bvVar2.dFa;
                        if (aya == null) {
                            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "filterLang, freewifi info is null");
                            str = null;
                        } else {
                            String applicationLanguage = LocaleUtil.getApplicationLanguage();
                            if (applicationLanguage.equals(LocaleUtil.CHINA)) {
                                str = aya.field_showWordCn;
                            } else if (applicationLanguage.equals(LocaleUtil.TAIWAN) || applicationLanguage.equals(LocaleUtil.HONGKONG)) {
                                str = aya.field_showWordTw;
                            } else {
                                str = aya.field_showWordEn;
                            }
                        }
                        aVar.dFf = str;
                        if (!m.eP(bvVar2.dFa.dFf) && i.a.dME().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) != 1) {
                            i.a.dME().dU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 1);
                        }
                        if (aya.field_expiredTime - Util.nowSecond() < 0) {
                            j.dNs().dMW();
                        }
                    }
                }
            }
            AppMethodBeat.o(24819);
            return false;
        }
    };
    private IListener wPh = new IListener<te>() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass9 */

        {
            AppMethodBeat.i(161373);
            this.__eventId = te.class.getName().hashCode();
            AppMethodBeat.o(161373);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(te teVar) {
            AppMethodBeat.i(24821);
            te teVar2 = teVar;
            int networkType = d.getNetworkType();
            if (!(networkType == 0 || networkType == -1)) {
                Log.i("MicroMsg.FreeWifi.SubCoreFreeWifi", "networkType is " + networkType + ", start to scan and report near field wifi, to get a pushed message for connecting wifi.");
                final String str = teVar2.dZD.userName;
                h.b.dNk().a(new h.a() {
                    /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass9.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.freewifi.model.h.a
                    public final void eM(List<ScanResult> list) {
                        AppMethodBeat.i(24820);
                        if (list == null || list.size() == 0) {
                            AppMethodBeat.o(24820);
                            return;
                        }
                        dqu dqu = new dqu();
                        dqu.MTD = new LinkedList<>();
                        for (ScanResult scanResult : list) {
                            if (scanResult != null) {
                                ei eiVar = new ei();
                                eiVar.mac = scanResult.BSSID;
                                eiVar.gNm = scanResult.level;
                                eiVar.ssid = scanResult.SSID;
                                dqu.MTD.add(eiVar);
                            }
                        }
                        String dMJ = m.dMJ();
                        k.a dMF = k.dMF();
                        dMF.quX = dMJ;
                        dMF.wNd = k.b.ScanNearFieldWifiAndReport.wNO;
                        dMF.wNe = k.b.ScanNearFieldWifiAndReport.name;
                        dMF.channel = 8;
                        dMF.dMH().dMG();
                        new com.tencent.mm.plugin.freewifi.d.k(str, dqu, 8, dMJ).c(null);
                        AppMethodBeat.o(24820);
                    }
                });
            }
            AppMethodBeat.o(24821);
            return false;
        }
    };
    private IListener wPi = new IListener<in>() {
        /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass10 */

        {
            AppMethodBeat.i(161374);
            this.__eventId = in.class.getName().hashCode();
            AppMethodBeat.o(161374);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(in inVar) {
            AppMethodBeat.i(24823);
            boolean a2 = a(inVar);
            AppMethodBeat.o(24823);
            return a2;
        }

        private static boolean a(in inVar) {
            AppMethodBeat.i(24822);
            if (inVar.dNg.data == "MAIN_UI_EVENT_UPDATE_VIEW" && m.dMI()) {
                String str = "InterruptedProtocol31-" + System.currentTimeMillis();
                f.b dNh = f.a.dNj().dNh();
                if (dNh != null && !dNh.wON && System.currentTimeMillis() - dNh.wOB <= 180000 && !m.eP(dNh.wOL) && !m.eP(dNh.wOK) && !m.eP(dNh.wOM)) {
                    Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi switched to last time. apSSid=%s, apBssid=%s, mobileMac=%s, time=%d", str, 1, dNh.wOK, dNh.wOL, dNh.wOM, Long.valueOf(dNh.wOB));
                    Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=It gets info of the wifi connected right now. ", str, 2);
                    String axM = m.axM("MicroMsg.FreeWifi.Protocol31Handler");
                    if (m.removeSsidQuote(dNh.wOK).equals(axM)) {
                        String axN = m.axN("MicroMsg.FreeWifi.Protocol31Handler");
                        String axO = m.axO("MicroMsg.FreeWifi.Protocol31Handler");
                        synchronized (f.a.dNj()) {
                            try {
                                if (dNh == f.a.dNj().dNh()) {
                                    Log.i("MicroMsg.FreeWifi.Protocol31Handler", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=it starts net request [GetInterruptedProtocol31] for schema url. apSSid=%s, apBssid=%s, mobileMac=%s", str, 3, axM, axN, axO);
                                    new g(axM, axN, axO).c(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0103: INVOKE  
                                          (wrap: com.tencent.mm.plugin.freewifi.d.g : 0x00fb: CONSTRUCTOR  (r6v7 com.tencent.mm.plugin.freewifi.d.g) = (r2v14 'axM' java.lang.String), (r3v6 'axN' java.lang.String), (r4v6 'axO' java.lang.String) call: com.tencent.mm.plugin.freewifi.d.g.<init>(java.lang.String, java.lang.String, java.lang.String):void type: CONSTRUCTOR)
                                          (wrap: com.tencent.mm.plugin.freewifi.e.c$1 : 0x0100: CONSTRUCTOR  (r2v15 com.tencent.mm.plugin.freewifi.e.c$1) = (r0v5 'str' java.lang.String), (r1v3 'dNh' com.tencent.mm.plugin.freewifi.model.f$b) call: com.tencent.mm.plugin.freewifi.e.c.1.<init>(java.lang.String, com.tencent.mm.plugin.freewifi.model.f$b):void type: CONSTRUCTOR)
                                         type: VIRTUAL call: com.tencent.mm.plugin.freewifi.d.g.c(com.tencent.mm.ak.i):void in method: com.tencent.mm.plugin.freewifi.model.j.10.a(com.tencent.mm.g.a.in):boolean, file: classes8.dex
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
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:249)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:71)
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0100: CONSTRUCTOR  (r2v15 com.tencent.mm.plugin.freewifi.e.c$1) = (r0v5 'str' java.lang.String), (r1v3 'dNh' com.tencent.mm.plugin.freewifi.model.f$b) call: com.tencent.mm.plugin.freewifi.e.c.1.<init>(java.lang.String, com.tencent.mm.plugin.freewifi.model.f$b):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.freewifi.model.j.10.a(com.tencent.mm.g.a.in):boolean, file: classes8.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 46 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.freewifi.e.c, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 52 more
                                        */
                                    /*
                                    // Method dump skipped, instructions count: 265
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.model.j.AnonymousClass10.a(com.tencent.mm.g.a.in):boolean");
                                }
                            };
                            private IListener wPj = new IListener<fw>() {
                                /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass11 */

                                {
                                    AppMethodBeat.i(161375);
                                    this.__eventId = fw.class.getName().hashCode();
                                    AppMethodBeat.o(161375);
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(fw fwVar) {
                                    AppMethodBeat.i(24824);
                                    com.tencent.mm.plugin.freewifi.b.c.dMR().a(fwVar);
                                    AppMethodBeat.o(24824);
                                    return false;
                                }
                            };
                            private IListener wPk = new IListener<ft>() {
                                /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass12 */

                                {
                                    AppMethodBeat.i(161376);
                                    this.__eventId = ft.class.getName().hashCode();
                                    AppMethodBeat.o(161376);
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(ft ftVar) {
                                    AppMethodBeat.i(24825);
                                    b.a.dMQ().a(ftVar);
                                    AppMethodBeat.o(24825);
                                    return false;
                                }
                            };
                            private IListener wPl = new IListener<io>() {
                                /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass2 */

                                {
                                    AppMethodBeat.i(161370);
                                    this.__eventId = io.class.getName().hashCode();
                                    AppMethodBeat.o(161370);
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                                @Override // com.tencent.mm.sdk.event.IListener
                                public final /* synthetic */ boolean callback(io ioVar) {
                                    AppMethodBeat.i(24815);
                                    com.tencent.mm.plugin.freewifi.e.b.dNH();
                                    com.tencent.mm.plugin.freewifi.e.b.aB(ioVar.dNh.intent);
                                    AppMethodBeat.o(24815);
                                    return false;
                                }
                            };

                            public j() {
                                AppMethodBeat.i(24826);
                                AppMethodBeat.o(24826);
                            }

                            static {
                                AppMethodBeat.i(24838);
                                HashMap<Integer, h.b> hashMap = new HashMap<>();
                                baseDBFactories = hashMap;
                                hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new h.b() {
                                    /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass1 */

                                    @Override // com.tencent.mm.storagebase.h.b
                                    public final String[] getSQLs() {
                                        return com.tencent.mm.plugin.freewifi.g.d.SQL_CREATE;
                                    }
                                });
                                baseDBFactories.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new h.b() {
                                    /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass5 */

                                    @Override // com.tencent.mm.storagebase.h.b
                                    public final String[] getSQLs() {
                                        return com.tencent.mm.plugin.freewifi.g.b.SQL_CREATE;
                                    }
                                });
                                baseDBFactories.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new h.b() {
                                    /* class com.tencent.mm.plugin.freewifi.model.j.AnonymousClass6 */

                                    @Override // com.tencent.mm.storagebase.h.b
                                    public final String[] getSQLs() {
                                        return com.tencent.mm.plugin.freewifi.g.f.SQL_CREATE;
                                    }
                                });
                                AppMethodBeat.o(24838);
                            }

                            public static j dNl() {
                                AppMethodBeat.i(24827);
                                bg.aVz();
                                j jVar = (j) cg.KG("plugin.freewifi");
                                if (jVar == null) {
                                    Log.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
                                    jVar = new j();
                                    bg.aVz().a("plugin.freewifi", jVar);
                                }
                                AppMethodBeat.o(24827);
                                return jVar;
                            }

                            public static d dNm() {
                                AppMethodBeat.i(24828);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wOY == null) {
                                    dNl().wOY = new d();
                                }
                                d dVar = dNl().wOY;
                                AppMethodBeat.o(24828);
                                return dVar;
                            }

                            public static com.tencent.mm.plugin.freewifi.g.d dNn() {
                                AppMethodBeat.i(24829);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wOZ == null) {
                                    j dNl = dNl();
                                    bg.aVF();
                                    dNl.wOZ = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.getDataDB());
                                }
                                com.tencent.mm.plugin.freewifi.g.d dVar = dNl().wOZ;
                                AppMethodBeat.o(24829);
                                return dVar;
                            }

                            public static com.tencent.mm.plugin.freewifi.g.b dNo() {
                                AppMethodBeat.i(24830);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wPa == null) {
                                    j dNl = dNl();
                                    bg.aVF();
                                    dNl.wPa = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.getDataDB());
                                }
                                com.tencent.mm.plugin.freewifi.g.b bVar = dNl().wPa;
                                AppMethodBeat.o(24830);
                                return bVar;
                            }

                            public static com.tencent.mm.plugin.freewifi.g.f dNp() {
                                AppMethodBeat.i(24831);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wPb == null) {
                                    j dNl = dNl();
                                    bg.aVF();
                                    dNl.wPb = new com.tencent.mm.plugin.freewifi.g.f(com.tencent.mm.model.c.getDataDB());
                                }
                                com.tencent.mm.plugin.freewifi.g.f fVar = dNl().wPb;
                                AppMethodBeat.o(24831);
                                return fVar;
                            }

                            public static c dNq() {
                                AppMethodBeat.i(24832);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wPc == null) {
                                    dNl().wPc = new c();
                                }
                                c cVar = dNl().wPc;
                                AppMethodBeat.o(24832);
                                return cVar;
                            }

                            public static c dNr() {
                                AppMethodBeat.i(24833);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wPd == null) {
                                    dNl().wPd = new c();
                                }
                                c cVar = dNl().wPd;
                                AppMethodBeat.o(24833);
                                return cVar;
                            }

                            public static synchronized a dNs() {
                                a aVar;
                                synchronized (j.class) {
                                    AppMethodBeat.i(24834);
                                    com.tencent.mm.kernel.g.aAf().azk();
                                    if (dNl().wPe == null) {
                                        dNl().wPe = new a();
                                    }
                                    aVar = dNl().wPe;
                                    AppMethodBeat.o(24834);
                                }
                                return aVar;
                            }

                            @Override // com.tencent.mm.model.bd
                            public final void clearPluginData(int i2) {
                            }

                            @Override // com.tencent.mm.model.bd
                            public final void onAccountPostReset(boolean z) {
                                AppMethodBeat.i(24835);
                                bg.getSysCmdMsgExtension().a("freewifi", this.rBq, true);
                                bg.a(this.netChanged);
                                EventCenter.instance.addListener(this.wPg);
                                EventCenter.instance.addListener(this.wPh);
                                EventCenter.instance.addListener(this.wPi);
                                EventCenter.instance.addListener(this.wPj);
                                EventCenter.instance.addListener(this.wPk);
                                EventCenter.instance.addListener(this.wPl);
                                EventCenter.instance.addListener(this.oVk);
                                try {
                                    this.netChanged.onNetworkChange(-9);
                                } catch (RemoteException e2) {
                                    Log.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e2.getMessage());
                                }
                                b dMY = b.C1371b.dMY();
                                Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
                                try {
                                    ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                                    Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", networkInfo.toString());
                                    if (networkInfo == null || !networkInfo.isConnected()) {
                                        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                                        Log.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", networkInfo2.toString());
                                        if (networkInfo2 != null && networkInfo2.isConnected()) {
                                            b.a aVar = new b.a((byte) 0);
                                            aVar.wOB = System.currentTimeMillis();
                                            aVar.type = 0;
                                            aVar.ssid = "";
                                            aVar.bssid = "";
                                            aVar.wOC = m.axL(networkInfo2.getExtraInfo());
                                            b.a(dMY.wOy.dMX(), aVar);
                                            dMY.wOy = aVar;
                                        }
                                        IntentFilter intentFilter = new IntentFilter();
                                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                        dMY.dMu();
                                        MMApplicationContext.getContext().registerReceiver(dMY.wOz, intentFilter);
                                        AppMethodBeat.o(24835);
                                    }
                                    String removeSsidQuote = m.removeSsidQuote(m.axM("MicroMsg.FreeWifi.FreeWifiConnChangedManager"));
                                    String lowerCase = m.axN("MicroMsg.FreeWifi.FreeWifiConnChangedManager").toLowerCase();
                                    b.a aVar2 = new b.a((byte) 0);
                                    aVar2.wOB = System.currentTimeMillis();
                                    aVar2.type = 1;
                                    aVar2.ssid = removeSsidQuote;
                                    aVar2.bssid = lowerCase;
                                    aVar2.wOC = "";
                                    b.b(dMY.wOy.dMX(), aVar2);
                                    dMY.wOy = aVar2;
                                    IntentFilter intentFilter2 = new IntentFilter();
                                    intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                                    dMY.dMu();
                                    MMApplicationContext.getContext().registerReceiver(dMY.wOz, intentFilter2);
                                    AppMethodBeat.o(24835);
                                } catch (Exception e3) {
                                    k.a dMF = k.dMF();
                                    dMF.dFd = "UnExpectedException";
                                    dMF.result = -1;
                                    dMF.resultMsg = m.l(e3);
                                    dMF.dMH().dMG();
                                    Log.e("MicroMsg.FreeWifi.UnExcepctedException", m.m(e3));
                                }
                            }

                            @Override // com.tencent.mm.model.bd
                            public final void onSdcardMount(boolean z) {
                            }

                            @Override // com.tencent.mm.model.bd
                            public final void onAccountRelease() {
                                AppMethodBeat.i(24836);
                                bg.getSysCmdMsgExtension().b("freewifi", this.rBq, true);
                                dNm();
                                dNq().release();
                                bg.b(this.netChanged);
                                EventCenter.instance.removeListener(this.wPg);
                                EventCenter.instance.removeListener(this.wPh);
                                EventCenter.instance.removeListener(this.wPi);
                                EventCenter.instance.removeListener(this.wPj);
                                EventCenter.instance.removeListener(this.wPk);
                                EventCenter.instance.removeListener(this.wPl);
                                EventCenter.instance.removeListener(this.oVk);
                                b.C1371b.dMY().dMu();
                                AppMethodBeat.o(24836);
                            }

                            @Override // com.tencent.mm.model.bd
                            public final HashMap<Integer, h.b> getBaseDBFactories() {
                                return baseDBFactories;
                            }

                            public static e dNt() {
                                AppMethodBeat.i(24837);
                                com.tencent.mm.kernel.g.aAf().azk();
                                if (dNl().wPf == null) {
                                    dNl().wPf = new e();
                                }
                                e eVar = dNl().wPf;
                                AppMethodBeat.o(24837);
                                return eVar;
                            }
                        }
