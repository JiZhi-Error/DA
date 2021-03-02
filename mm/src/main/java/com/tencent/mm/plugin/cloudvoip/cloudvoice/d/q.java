package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public enum q {
    INSTANCE;
    
    public static int EMethodGetQosPara = 25;
    private static final String qtb = MMApplicationContext.getApplicationId();
    private final MMHandler luO = new MMHandler("openvoice_voip_worker");
    private boolean mIsInit;
    private int mMaxHeight = 640;
    private int mMaxWidth = 480;
    public MMHandler mainHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass1 */
        TelephonyManager qtS;
        PhoneStateListener qtT;

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(184471);
            super.handleMessage(message);
            if (message.what == 272) {
                if (this.qtS == null) {
                    this.qtS = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                    this.qtT = new PhoneStateListener() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass1.AnonymousClass1 */

                        public final void onCallStateChanged(int i2, String str) {
                            AppMethodBeat.i(184470);
                            super.onCallStateChanged(i2, str);
                            switch (i2) {
                                case 1:
                                    q.this.aj(new Runnable() {
                                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(184469);
                                            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                                            q.a(q.this, a.ReasonInCommingCall);
                                            AppMethodBeat.o(184469);
                                        }
                                    });
                                    break;
                            }
                            AppMethodBeat.o(184470);
                        }
                    };
                }
                TelephonyManager telephonyManager = this.qtS;
                com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.qtT);
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            AppMethodBeat.o(184471);
        }
    };
    private String mgS = null;
    private final k qrJ = new k();
    a qsn = null;
    private boolean qtA;
    public boolean qtB = false;
    public boolean qtC = false;
    private boolean qtD;
    private b<String> qtE;
    public long qtF = -1;
    private boolean qtG = false;
    private boolean qtH = false;
    private int qtI = 0;
    public h qtJ = null;
    public boolean qtK;
    public boolean qtL;
    private boolean qtM = false;
    private boolean qtN = false;
    private boolean qtO = false;
    private final int qtP = -9999;
    public Runnable qtQ = new Runnable() {
        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(90867);
            if (q.this.qth == d.NotInRoom && !q.this.qtA) {
                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", 180000L);
                q.u(q.this);
            }
            AppMethodBeat.o(90867);
        }
    };
    private final s qtc = new s();
    private final l qtd = new l();
    public final f qte = new f(this.qrJ);
    public final t qtf = new t(this.qrJ);
    public e qtg = new e(MMApplicationContext.getContext());
    public d qth = d.NotInRoom;
    private a qti;
    private String qtj;
    private String qtk;
    private int qtl = 0;
    public int qtm = 1;
    private b<a> qtn;
    private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> qto;
    private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> qtp;
    private b<HashMap<String, LinkedList>> qtq;
    private l.a qtr;
    private l.a qts;
    private l.a qtt;
    private l.a qtu;
    private l.a qtv;
    private l.a qtw;
    private l.a qtx;
    private l.a qty;
    private l.a qtz;

    static /* synthetic */ int a(q qVar, a aVar) {
        AppMethodBeat.i(184483);
        int d2 = qVar.d(aVar);
        AppMethodBeat.o(184483);
        return d2;
    }

    static /* synthetic */ int a(q qVar, String str) {
        AppMethodBeat.i(186778);
        int akG = qVar.akG(str);
        AppMethodBeat.o(186778);
        return akG;
    }

    static /* synthetic */ void a(q qVar, b bVar) {
        AppMethodBeat.i(186782);
        qVar.a(bVar);
        AppMethodBeat.o(186782);
    }

    static /* synthetic */ void a(q qVar, b bVar, int i2, int i3, String str) {
        AppMethodBeat.i(186779);
        qVar.a(bVar, i2, i3, str);
        AppMethodBeat.o(186779);
    }

    static /* synthetic */ void j(q qVar) {
        AppMethodBeat.i(186783);
        qVar.czf();
        AppMethodBeat.o(186783);
    }

    static /* synthetic */ void r(q qVar) {
        AppMethodBeat.i(186784);
        qVar.czg();
        AppMethodBeat.o(186784);
    }

    static /* synthetic */ int u(q qVar) {
        AppMethodBeat.i(186785);
        int kL = qVar.kL(true);
        AppMethodBeat.o(186785);
        return kL;
    }

    public static q valueOf(String str) {
        AppMethodBeat.i(90898);
        q qVar = (q) Enum.valueOf(q.class, str);
        AppMethodBeat.o(90898);
        return qVar;
    }

    static {
        AppMethodBeat.i(90930);
        AppMethodBeat.o(90930);
    }

    public enum d {
        NotInRoom,
        SdkInRoom,
        InRoom;

        public static d valueOf(String str) {
            AppMethodBeat.i(90895);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(90895);
            return dVar;
        }

        static {
            AppMethodBeat.i(90896);
            AppMethodBeat.o(90896);
        }
    }

    public enum a {
        ReasonInterrupted(0),
        ReasonManual(1),
        ReasonDevice(2),
        ReasonInCommingCall(3),
        ReasonSessionUpdateFailed(4),
        ReasonWeappEnterBackground(5),
        ReasonWeappStopFromPassiveFloatBall(6),
        ReasonUnknown(100);
        
        public final int cND;

        public static a valueOf(String str) {
            AppMethodBeat.i(90890);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(90890);
            return aVar;
        }

        static {
            AppMethodBeat.i(90891);
            AppMethodBeat.o(90891);
        }

        private a(int i2) {
            this.cND = i2;
        }
    }

    private q(String str) {
        AppMethodBeat.i(90899);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(184479);
                Bundle bundle = (Bundle) h.a(q.qtb, null, b.class);
                if (bundle != null) {
                    String string = bundle.getString(DeviceRequestsHelper.DEVICE_INFO_PARAM, "");
                    Log.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", string);
                    ae.DV(string);
                    AppMethodBeat.o(184479);
                    return;
                }
                Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
                AppMethodBeat.o(184479);
            }
        }, "updateDeviceInfo");
        this.qtA = false;
        this.mIsInit = false;
        this.qtD = false;
        this.qtE = null;
        this.qtJ = null;
        this.qtK = true;
        this.qtL = false;
        this.qsn = new a();
        AppMethodBeat.o(90899);
    }

    static class b implements k<Bundle, Bundle> {
        private b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(90892);
            Bundle bundle2 = new Bundle();
            bundle2.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, g.aAh().azR().gEu());
            AppMethodBeat.o(90892);
            return bundle2;
        }
    }

    private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> bVar, int i2, int i3, String str) {
        AppMethodBeat.i(90900);
        this.qtA = false;
        if (i2 == 0 && i3 == 0) {
            this.qth = d.InRoom;
        }
        synchronized (this.qtd) {
            try {
                this.qtd.b(3, this.qtw);
                this.qtd.b(4, this.qtx);
                this.qtd.b(22, this.qty);
                this.qtd.b(23, this.qtz);
                this.qtw = null;
                this.qtx = null;
                this.qty = null;
                this.qtz = null;
            } finally {
                AppMethodBeat.o(90900);
            }
        }
        ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList = this.qrJ.qsr;
        if (bVar != null) {
            bVar.a(i2, i3, str, arrayList);
        }
    }

    private int akG(String str) {
        AppMethodBeat.i(90901);
        int a2 = m.a(this.qtj, this.mgS, str, this.qtl, this.mMaxWidth, this.mMaxHeight, this.qtd.kK(true));
        this.qtu = new l.a<String, String>() {
            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass25 */

            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
            public final boolean czb() {
                return true;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
            public final /* synthetic */ String l(int i2, String str) {
                AppMethodBeat.i(90881);
                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: session key expired!! reset session key");
                q.this.aj(new Runnable() {
                    /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass25.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(90880);
                        if (Util.isNullOrNil(q.this.mgS) || q.this.qth == d.NotInRoom) {
                            Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room now");
                            AppMethodBeat.o(90880);
                            return;
                        }
                        q.this.qtc.akH(q.this.mgS);
                        q.this.qtc.a(q.this.mgS, q.this.qtk, new s.a() {
                            /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass25.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s.a
                            public final void a(int i2, int i3, String str, r rVar, boolean z) {
                                AppMethodBeat.i(186766);
                                if (i2 != 0 || i3 != 0 || rVar == null || !rVar.isValid()) {
                                    Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: refresh session key error!");
                                    q.a(q.this, a.ReasonSessionUpdateFailed);
                                    AppMethodBeat.o(186766);
                                    return;
                                }
                                m.akF(rVar.quX);
                                AppMethodBeat.o(186766);
                            }
                        });
                        AppMethodBeat.o(90880);
                    }
                });
                AppMethodBeat.o(90881);
                return "";
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
            public final /* bridge */ /* synthetic */ byte[] db(String str) {
                return new byte[0];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
            public final /* synthetic */ String bf(byte[] bArr) {
                AppMethodBeat.i(186767);
                if (bArr == null) {
                    bArr = new byte[0];
                }
                String str = new String(bArr);
                AppMethodBeat.o(186767);
                return str;
            }
        };
        this.qtd.a(26, this.qtu);
        AppMethodBeat.o(90901);
        return a2;
    }

    private void czf() {
        this.qtM = false;
        this.qtN = false;
        this.qtO = false;
    }

    private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> bVar) {
        boolean z;
        int i2;
        int fFs;
        int i3;
        AppMethodBeat.i(90902);
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO));
        if (this.qtM && this.qtO && this.qtN) {
            if (this.qtD) {
                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
                a(bVar, -10086, -9, "interrupted because already cancelled or entered background");
                int d2 = d(this.qti);
                if (this.qtE != null) {
                    if (d2 == 0) {
                        this.qtE.a(0, 0, "ok", "");
                    } else {
                        this.qtE.a(-10086, -17, "exit failed", "");
                    }
                }
                this.qtD = false;
                this.qtE = null;
                AppMethodBeat.o(90902);
                return;
            }
            this.qtf.czm();
            f fVar = this.qte;
            if (fVar.qrL != 2) {
                Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
                z = false;
            } else if (fVar.qrG.a(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c7: INVOKE  (r3v3 int) = 
                  (wrap: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g : 0x00ba: IGET  (r3v2 com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.qrG com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g)
                  (wrap: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f$2 : 0x00be: CONSTRUCTOR  (r4v2 com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f$2) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.2.<init>(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f):void type: CONSTRUCTOR)
                  (wrap: int : 0x00c1: IGET  (r5v6 int) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.mSampleRate int)
                  (wrap: int : 0x00c3: IGET  (r6v1 int) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.mChannels int)
                  (wrap: int : 0x00c5: IGET  (r7v1 int) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.qrV int)
                 type: VIRTUAL call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g.a(com.tencent.mm.plugin.voip.model.b, int, int, int):int in method: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b<java.util.ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:128)
                	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:56)
                	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:45)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:141)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00be: CONSTRUCTOR  (r4v2 com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f$2) = (r0v6 'fVar' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f) call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f.2.<init>(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b<java.util.ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>>):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 29 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.f, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 35 more
                */
            /*
            // Method dump skipped, instructions count: 245
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b):void");
        }

        private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> bVar) {
            AppMethodBeat.i(90903);
            a(bVar, -10086, -7, "start audio device failed");
            d(a.ReasonDevice);
            AppMethodBeat.o(90903);
        }

        /* access modifiers changed from: package-private */
        public static class c implements k<Bundle, Bundle> {
            private c() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.k
            public final /* synthetic */ Bundle invoke(Bundle bundle) {
                AppMethodBeat.i(90893);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("is_in_voip", com.tencent.mm.q.a.att() || m.fKH() || m.isVoipStarted() || m.fKI());
                AppMethodBeat.o(90893);
                return bundle2;
            }
        }

        private void czg() {
            AppMethodBeat.i(90904);
            this.qrJ.qsr.clear();
            k kVar = this.qrJ;
            synchronized (kVar.qst) {
                try {
                    kVar.qst.clear();
                } finally {
                    AppMethodBeat.o(90904);
                }
            }
            if (kVar.qsu != null) {
                kVar.qsu.cancel();
            }
            f fVar = this.qte;
            if (fVar.qrG != null) {
                g gVar = fVar.qrG;
                synchronized (gVar.qrY) {
                    try {
                        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlay, isStart: %s %s", Boolean.valueOf(gVar.isStart), Integer.valueOf(gVar.hashCode()));
                        if (gVar.isStart) {
                            com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a aVar = gVar.qrZ;
                            com.tencent.mm.plugin.voip.model.c cVar = aVar.qrz;
                            if (cVar != null) {
                                cVar.fFr();
                                cVar.fFo();
                                aVar.qrz = null;
                            }
                            gVar.qsa.gLm = SystemClock.elapsedRealtime();
                            Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlaying cost: " + gVar.qsa.apr());
                            gVar.isStart = false;
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(90904);
                        throw th;
                    }
                }
            }
            fVar.qrT = false;
            if (fVar.qrH != null) {
                fVar.qrH.ZZ();
                fVar.qrH = null;
                Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "finish pauseRecord");
            }
            INSTANCE.kM(false);
            fVar.qrL = f.qrK;
            com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a aVar2 = fVar.qrG.qrZ;
            aVar2.cdV();
            aVar2.agq("openvoice");
            aVar2.jvG.apm();
            com.tencent.mm.plugin.audio.c.a.ceh();
            com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a.unInit();
            t tVar = this.qtf;
            Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "release");
            try {
                synchronized (tVar) {
                    try {
                        if (tVar.mStarted) {
                            tVar.mStarted = false;
                            if (tVar.mTimer != null) {
                                tVar.mTimer.cancel();
                                tVar.mTimer = null;
                            }
                            synchronized (tVar.qvg) {
                                try {
                                    tVar.qvg.clear();
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    } finally {
                        AppMethodBeat.o(90904);
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "release error:" + e2.toString());
            }
            synchronized (this.qtd) {
                try {
                    this.qtd.b(24, this.qtr);
                    this.qtd.b(25, this.qts);
                    this.qtd.b(20, this.qtt);
                    this.qtd.b(21, this.qtv);
                    this.qtd.b(26, this.qtu);
                    this.qtr = null;
                    this.qts = null;
                    this.qtt = null;
                    this.qtv = null;
                    this.qtu = null;
                } finally {
                    AppMethodBeat.o(90904);
                }
            }
        }

        public final void aj(Runnable runnable) {
            AppMethodBeat.i(90905);
            if (this.luO.getSerialTag().equals(com.tencent.f.j.a.hmF())) {
                runnable.run();
                AppMethodBeat.o(90905);
                return;
            }
            this.luO.post(runnable);
            AppMethodBeat.o(90905);
        }

        private void ak(Runnable runnable) {
            AppMethodBeat.i(90906);
            this.luO.postDelayed(runnable, 180000);
            AppMethodBeat.o(90906);
        }

        public final void a(final b<String> bVar, final a aVar) {
            AppMethodBeat.i(90907);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(90866);
                    int a2 = q.a(q.this, aVar);
                    if (a2 == -9999) {
                        Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
                        q.this.qtE = bVar;
                        AppMethodBeat.o(90866);
                        return;
                    }
                    if (bVar != null) {
                        if (a2 == 0) {
                            bVar.a(0, 0, "", "");
                            AppMethodBeat.o(90866);
                            return;
                        }
                        bVar.a(-10086, -17, "exit failed", "");
                    }
                    AppMethodBeat.o(90866);
                }
            });
            AppMethodBeat.o(90907);
        }

        private static int c(a aVar) {
            AppMethodBeat.i(90908);
            switch (aVar) {
                case ReasonSessionUpdateFailed:
                case ReasonUnknown:
                case ReasonInterrupted:
                    AppMethodBeat.o(90908);
                    return 0;
                case ReasonManual:
                    AppMethodBeat.o(90908);
                    return 1;
                case ReasonInCommingCall:
                    AppMethodBeat.o(90908);
                    return 6;
                case ReasonDevice:
                    AppMethodBeat.o(90908);
                    return 8;
                case ReasonWeappEnterBackground:
                    AppMethodBeat.o(90908);
                    return 7;
                default:
                    AppMethodBeat.o(90908);
                    return 0;
            }
        }

        private int d(a aVar) {
            AppMethodBeat.i(90909);
            this.qtB = false;
            MultiProcessMMKV.getMMKV(this.mgS + "_wxa_voip").putBoolean("isCameraStart", false);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", this.mgS);
            if (!czl()) {
                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
                stopRing();
            }
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", aVar);
            this.qti = aVar;
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync: release avcCodec: " + this.qtJ);
            this.qtJ = null;
            if (this.qtA) {
                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
                this.qtD = true;
                AppMethodBeat.o(90909);
                return -9999;
            } else if (this.qth == d.NotInRoom) {
                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
                AppMethodBeat.o(90909);
                return 0;
            } else {
                int EV = m.EV(c(aVar));
                czh();
                AppMethodBeat.o(90909);
                return EV;
            }
        }

        private void czh() {
            AppMethodBeat.i(90910);
            ak(this.qtQ);
            AppMethodBeat.o(90910);
        }

        private int kL(boolean z) {
            AppMethodBeat.i(90911);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", Boolean.valueOf(z));
            this.qtc.akH(this.mgS);
            p.qsR = 0;
            p.qsS = 0;
            p.qsT = 0;
            p.qsU = 0;
            p.qsV = 0;
            p.qsW = 0;
            p.qsX = 0;
            p.qsY = 0;
            p.qsZ = 0;
            this.mgS = null;
            this.qtj = null;
            czg();
            this.mIsInit = false;
            n nVar = n.INSTANCE;
            Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
            nVar.EX(1);
            if (z) {
                int cze = m.cze();
                AppMethodBeat.o(90911);
                return cze;
            }
            this.qtd.kK(false);
            this.mainHandler.sendEmptyMessage(272);
            AppMethodBeat.o(90911);
            return 0;
        }

        public final void a(final boolean z, final b<String> bVar) {
            AppMethodBeat.i(90912);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", Boolean.valueOf(z));
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass13 */

                public final void run() {
                    AppMethodBeat.i(184480);
                    if (q.this.qth != d.InRoom) {
                        Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                        if (bVar != null) {
                            bVar.a(-10086, -1001, "not in room", "");
                            AppMethodBeat.o(184480);
                            return;
                        }
                    }
                    q.this.qte.qrT = z;
                    if (bVar != null) {
                        bVar.a(0, 0, "ok", "");
                    }
                    AppMethodBeat.o(184480);
                }
            });
            AppMethodBeat.o(90912);
        }

        public final void b(final boolean z, final b<String> bVar) {
            AppMethodBeat.i(90913);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", Boolean.valueOf(z));
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass14 */

                public final void run() {
                    boolean z;
                    AppMethodBeat.i(184481);
                    if (q.this.qth != d.InRoom) {
                        Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                        if (bVar != null) {
                            bVar.a(-10086, -1001, "not in room", "");
                            AppMethodBeat.o(184481);
                            return;
                        }
                    }
                    f fVar = q.this.qte;
                    boolean z2 = z;
                    fVar.qrU = z2;
                    q qVar = q.INSTANCE;
                    Object[] objArr = new Object[1];
                    objArr[0] = z2 ? "mute" : "unMute";
                    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", objArr);
                    qVar.aj(new Runnable(z2) {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass19 */
                        final /* synthetic */ boolean quk;

                        {
                            this.quk = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(186760);
                            boolean z = !this.quk;
                            if (z == q.this.qtG) {
                                AppMethodBeat.o(186760);
                                return;
                            }
                            q.this.qtG = z;
                            m.b(q.this.qtG, q.this.qtH, q.this.qtI);
                            AppMethodBeat.o(186760);
                        }
                    });
                    if (fVar.qrH != null) {
                        fVar.qrH.de(z2);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (bVar != null) {
                        if (z) {
                            bVar.a(0, 0, "ok", "");
                            AppMethodBeat.o(184481);
                            return;
                        }
                        bVar.a(-10086, -15, "set mute failed", "");
                    }
                    AppMethodBeat.o(184481);
                }
            });
            AppMethodBeat.o(90913);
        }

        public final void c(final boolean z, final b<String> bVar) {
            AppMethodBeat.i(186770);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", Boolean.valueOf(z));
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass15 */

                public final void run() {
                    boolean ju;
                    AppMethodBeat.i(186756);
                    if (q.this.qth != d.InRoom) {
                        Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
                        if (bVar != null) {
                            bVar.a(-10086, -1001, "not in room", "");
                            AppMethodBeat.o(186756);
                            return;
                        }
                    }
                    f fVar = q.this.qte;
                    boolean z = z;
                    g gVar = fVar.qrG;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker beSpeakerphoneOn: ".concat(String.valueOf(z)));
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker ignoreBluetooth: false");
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isAvailable: " + gVar.qrZ.isAvailable());
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerSetFailed: " + gVar.qrZ.qry);
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoAvailable: " + com.tencent.mm.plugin.audio.d.b.a(gVar.qrZ.audioManager));
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoOn: " + gVar.qrZ.isBluetoothScoOn());
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isHeadsetPlugged: " + gVar.qrZ.cdW());
                    Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerphoneOn: " + gVar.qrZ.isSpeakerphoneOn());
                    if (!z || (!gVar.qrZ.isBluetoothScoOn() && !gVar.qrZ.cdW())) {
                        ju = gVar.qrZ.ju(z);
                    } else {
                        ju = false;
                    }
                    if (bVar != null) {
                        if (ju) {
                            bVar.a(0, 0, "ok", "");
                            AppMethodBeat.o(186756);
                            return;
                        }
                        bVar.a(-10086, -15, "set handsFree failed", "");
                    }
                    AppMethodBeat.o(186756);
                }
            });
            AppMethodBeat.o(186770);
        }

        public final void czi() {
            AppMethodBeat.i(186771);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", com.tencent.mm.plugin.appbrand.jsapi.camera.k.NAME);
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(186758);
                    if (!q.this.qtH) {
                        AppMethodBeat.o(186758);
                        return;
                    }
                    q.this.qtH = false;
                    MultiProcessMMKV.getMMKV(q.this.mgS + "_wxa_voip").putBoolean("isCameraStart", q.this.qtH);
                    m.b(q.this.qtG, q.this.qtH, q.this.qtI);
                    AppMethodBeat.o(186758);
                }
            });
            AppMethodBeat.o(186771);
        }

        public final void kM(final boolean z) {
            AppMethodBeat.i(186772);
            Object[] objArr = new Object[1];
            objArr[0] = z ? "yes" : "no";
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", objArr);
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass18 */

                public final void run() {
                    AppMethodBeat.i(186759);
                    if (z == q.this.qtG) {
                        AppMethodBeat.o(186759);
                        return;
                    }
                    q.this.qtG = z;
                    m.b(q.this.qtG, q.this.qtH, q.this.qtI);
                    AppMethodBeat.o(186759);
                }
            });
            AppMethodBeat.o(186772);
        }

        public final int czj() {
            return this.qtm;
        }

        public final t czk() {
            return this.qtf;
        }

        /* access modifiers changed from: package-private */
        public final void d(final byte[] bArr, final int i2, final int i3, final int i4) {
            AppMethodBeat.i(186773);
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass20 */

                public final void run() {
                    char c2;
                    boolean z = true;
                    AppMethodBeat.i(186761);
                    if (!q.this.qtB) {
                        AppMethodBeat.o(186761);
                        return;
                    }
                    if (q.this.qtK) {
                        q qVar = q.this;
                        if (m.e(q.EMethodGetQosPara, qVar.qsn.s2p, qVar.qsn.s2p.length) >= 0) {
                            a aVar = qVar.qsn;
                            ByteBuffer wrap = ByteBuffer.wrap(aVar.s2p);
                            wrap.order(ByteOrder.LITTLE_ENDIAN);
                            aVar.iKbps = wrap.getShort();
                            aVar.cFps = wrap.get();
                            aVar.cIPeriod = wrap.get();
                            aVar.cResolution = wrap.get();
                            aVar.qrE = wrap.get();
                            aVar.qrF = wrap.get();
                            aVar.cSkipFlag = wrap.get();
                            aVar.cIReqFlag = wrap.get();
                            aVar.cRsvd1 = wrap.get();
                            a aVar2 = qVar.qsn;
                            Log.d("OpenVoice[HWEnc]", "raw S2P:" + aVar2.s2p);
                            Log.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((int) aVar2.iKbps) + ", fps:" + ((int) aVar2.cFps) + ", IP:" + ((int) aVar2.cIPeriod) + ", Reso:" + ((int) aVar2.cResolution) + ", Codec:" + ((int) aVar2.qrE) + ", HWEnable:" + ((int) aVar2.qrF) + ", Skip:" + ((int) aVar2.cSkipFlag) + ", IReq:" + ((int) aVar2.cIReqFlag) + ", Rsvd1:" + ((int) aVar2.cRsvd1));
                        }
                        if (!qVar.qtK) {
                            qVar.qtL = false;
                        } else if (8 == qVar.qsn.qrE) {
                            qVar.qtL = true;
                        } else {
                            qVar.qtL = false;
                        }
                        if (qVar.qsn.qrF == 0) {
                            qVar.qtK = false;
                            qVar.qtL = false;
                        }
                        if (1 == qVar.qsn.cSkipFlag || !qVar.qtK || !qVar.qtL) {
                            c2 = 65535;
                        } else {
                            if (!qVar.qtK || qVar.qtJ != null) {
                                h hVar = qVar.qtJ;
                                a aVar3 = qVar.qsn;
                                if (!(hVar.qsn == null || hVar.qsc == null)) {
                                    a aVar4 = hVar.qsn;
                                    aVar4.iKbps = aVar3.iKbps;
                                    aVar4.cFps = aVar3.cFps;
                                    aVar4.cIPeriod = aVar3.cIPeriod;
                                    aVar4.cResolution = aVar3.cResolution;
                                    aVar4.qrE = aVar3.qrE;
                                    aVar4.qrF = aVar3.qrF;
                                    aVar4.cSkipFlag = aVar3.cSkipFlag;
                                    aVar4.cIReqFlag = aVar3.cIReqFlag;
                                    aVar4.cRsvd1 = aVar3.cRsvd1;
                                    int i2 = (int) (((double) hVar.qsn.iKbps) * 1.1d);
                                    if (hVar.m_br_kbps != i2) {
                                        hVar.SetBitRate(i2);
                                        Log.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + hVar.m_br_kbps + ", tuneBR:" + i2);
                                        hVar.m_br_kbps = i2;
                                    }
                                    if (1 == hVar.qsn.cIReqFlag && h.frameID > 0) {
                                        if (hVar.qsc != null) {
                                            Log.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
                                            Bundle bundle = new Bundle();
                                            bundle.putInt("request-sync", 0);
                                            hVar.qsc.setParameters(bundle);
                                        }
                                        Log.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
                                    }
                                    if (hVar.qsn.cFps != hVar.m_framerate) {
                                        hVar.m_framerate = hVar.qsn.cFps;
                                    }
                                }
                            } else {
                                qVar.qtJ = new h(qVar.qsn.cFps, qVar.qsn.iKbps, "video/avc");
                                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "create avcCodec: " + qVar.qtJ);
                            }
                            c2 = 0;
                        }
                        if (c2 >= 0) {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (!q.this.qtL) {
                        m.c(bArr, i2, i3, i4);
                    } else if (q.this.qtJ != null && !z) {
                        int b2 = q.this.qtJ.b(bArr, i2, i3, i4);
                        if (b2 < 0) {
                            Log.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(b2)));
                            q.this.qtL = false;
                        }
                        AppMethodBeat.o(186761);
                        return;
                    }
                    AppMethodBeat.o(186761);
                }
            });
            AppMethodBeat.o(186773);
        }

        static int bh(byte[] bArr) {
            AppMethodBeat.i(186774);
            int bg = m.bg(bArr);
            AppMethodBeat.o(186774);
            return bg;
        }

        static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b bVar) {
            AppMethodBeat.i(90915);
            if (m.EU(bVar.qrD) > 0) {
                AppMethodBeat.o(90915);
                return true;
            }
            AppMethodBeat.o(90915);
            return false;
        }

        static void G(byte[] bArr, int i2, int i3) {
            AppMethodBeat.i(90916);
            m.F(bArr, i2, i3);
            AppMethodBeat.o(90916);
        }

        static int f(int i2, byte[] bArr, int i3) {
            AppMethodBeat.i(90917);
            int e2 = m.e(i2, bArr, i3);
            AppMethodBeat.o(90917);
            return e2;
        }

        static int S(byte[] bArr, int i2) {
            AppMethodBeat.i(90918);
            int R = m.R(bArr, i2);
            AppMethodBeat.o(90918);
            return R;
        }

        static void EZ(int i2) {
            AppMethodBeat.i(90919);
            m.EW(i2);
            AppMethodBeat.o(90919);
        }

        public final void stopRing() {
            AppMethodBeat.i(186775);
            if (this.qtg != null) {
                this.qtg.stop();
            }
            AppMethodBeat.o(186775);
        }

        private boolean czl() {
            AppMethodBeat.i(186776);
            if (this.qtg != null) {
                boolean YZ = this.qtg.YZ();
                AppMethodBeat.o(186776);
                return YZ;
            }
            AppMethodBeat.o(186776);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
            if (r26.equalsIgnoreCase(r2) == false) goto L_0x00c3;
         */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0155  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0172  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x01cb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q r12, java.lang.String r13, java.lang.String r14, final java.lang.String r15, final java.lang.String r16, final int r17, int r18, int r19, int r20, int r21, final java.lang.String r22, java.lang.String r23, final long r24, java.lang.String r26, int r27, final com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b r28, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b r29, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b r30, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b r31, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b r32) {
            /*
            // Method dump skipped, instructions count: 472
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, int, java.lang.String, java.lang.String, long, java.lang.String, int, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b):void");
        }

        static /* synthetic */ void a(q qVar, long j2, final b bVar) {
            AppMethodBeat.i(186780);
            Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: cgiJoinRoom imroomId: ".concat(String.valueOf(j2)));
            qVar.czf();
            qVar.qtw = new l.a<String, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass27 */

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return false;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(int i2, String str) {
                    AppMethodBeat.i(90886);
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass27.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(90884);
                            if (q.this.qth == d.NotInRoom) {
                                q.this.qth = d.SdkInRoom;
                            }
                            q.this.qtN = true;
                            q.a(q.this, bVar);
                            AppMethodBeat.o(90884);
                        }
                    });
                    AppMethodBeat.o(90886);
                    return "";
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    AppMethodBeat.i(90887);
                    AppMethodBeat.o(90887);
                    return "";
                }
            };
            qVar.qtd.a(3, qVar.qtw);
            qVar.qtx = new l.a<String, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass28 */

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return false;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(final int i2, String str) {
                    AppMethodBeat.i(90888);
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass28.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(186769);
                            q.j(q.this);
                            q.a(q.this, bVar, -10086, -5, "join room callback failed: " + i2);
                            AppMethodBeat.o(186769);
                        }
                    });
                    AppMethodBeat.o(90888);
                    return "";
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    return "";
                }
            };
            qVar.qtd.a(4, qVar.qtx);
            qVar.qty = new l.a<acs, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ acs bf(byte[] bArr) {
                    AppMethodBeat.i(90854);
                    acs bi = bi(bArr);
                    AppMethodBeat.o(90854);
                    return bi;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(int i2, acs acs) {
                    AppMethodBeat.i(90853);
                    final acs acs2 = acs;
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            int b2;
                            AppMethodBeat.i(90851);
                            q.this.qtO = true;
                            f fVar = q.this.qte;
                            acs acs = acs2;
                            if (acs != null) {
                                fVar.mSampleRate = acs.Lnx.LqF;
                                fVar.mChannels = acs.Lnx.channels;
                                fVar.qrV = acs.Lnx.LqG;
                            }
                            f fVar2 = q.this.qte;
                            if (fVar2.qrL == 2) {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "dev start already...");
                            } else {
                                g gVar = fVar2.qrG;
                                gVar.qrZ.init();
                                com.tencent.mm.plugin.audio.c.a.ceg();
                                com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a aVar = gVar.qrZ;
                                Log.i("MicroMsg.OpenVoiceAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a.AY(3)), Boolean.valueOf(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a.AY(4)), Integer.valueOf(aVar.hashCode()));
                                aVar.jvG.requestFocus();
                                if (!com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a.cdZ()) {
                                    aVar.b("openvoice", (Integer) 1);
                                    aVar.qry &= aVar.kJ(true);
                                } else if (com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a.AY(4) && (b2 = aVar.b("openvoice", (Integer) 4)) != 0) {
                                    Log.e("MicroMsg.OpenVoiceAudioManager", "hy: start bluetooth failed %d", Integer.valueOf(b2));
                                    aVar.agq("openvoice");
                                }
                                Log.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "start device......");
                                fVar2.qrL = 2;
                                ae.gKu.dump();
                                byte[] bArr = {0};
                                byte[] bArr2 = new byte[2];
                                Log.i("MicroMsg.OpenVoice.OpenVoiceAudioCompatHelper", "hy: audio info dump begin");
                                ae.gKu.dump();
                                if (ae.gKu.gEo >= 0) {
                                    bArr2[0] = (byte) ae.gKu.gEo;
                                    q qVar = q.INSTANCE;
                                    q.f(406, bArr2, 1);
                                } else if (ae.gKu.gEo == -2) {
                                    q qVar2 = q.INSTANCE;
                                    q.f(407, bArr, 1);
                                }
                                if (ae.gKu.gEt >= 0) {
                                    byte[] bArr3 = new byte[7];
                                    if (ae.gKu.gEu >= 0 && ae.gKu.gEv >= 0) {
                                        bArr3[0] = (byte) ae.gKu.gEu;
                                        bArr3[1] = (byte) ae.gKu.gEv;
                                        if (ae.gKu.gEw >= 0) {
                                            bArr3[2] = (byte) ae.gKu.gEw;
                                            bArr3[3] = (byte) ae.gKu.gEt;
                                            bArr3[4] = (byte) ae.gKu.gEx;
                                            bArr3[5] = (byte) ae.gKu.gEy;
                                            bArr3[6] = (byte) ae.gKu.gEz;
                                            q qVar3 = q.INSTANCE;
                                            q.f(404, bArr3, 7);
                                        } else {
                                            q qVar4 = q.INSTANCE;
                                            q.f(404, bArr3, 2);
                                        }
                                    }
                                } else if (ae.gKu.gEt == -2) {
                                    q qVar5 = q.INSTANCE;
                                    q.f(405, bArr, 1);
                                }
                                if (ae.gKu.gEp >= 0) {
                                    bArr2[0] = (byte) ae.gKu.gEp;
                                    q qVar6 = q.INSTANCE;
                                    q.f(408, bArr2, 1);
                                } else if (ae.gKu.gEp == -2) {
                                    q qVar7 = q.INSTANCE;
                                    q.f(409, bArr, 1);
                                }
                                if (ae.gKu.gEP[0] > 0 || ae.gKu.gEP[1] > 0) {
                                    bArr2[0] = 0;
                                    bArr2[1] = 0;
                                    if (ae.gKu.gEP[0] > 0 && ae.gKu.gEP[0] < 10000) {
                                        bArr2[0] = (byte) ae.gKu.gEP[0];
                                    }
                                    if (ae.gKu.gEP[1] > 0 && ae.gKu.gEP[1] < 10000) {
                                        bArr2[1] = (byte) ae.gKu.gEP[1];
                                    }
                                    q qVar8 = q.INSTANCE;
                                    q.f(v2helper.EMethodSetNgStrength, bArr2, 2);
                                }
                                if (ae.gKu.gDN >= 0 || ae.gKu.gDP >= 0) {
                                    bArr2[0] = -1;
                                    bArr2[1] = -1;
                                    if (ae.gKu.gDN >= 0) {
                                        bArr2[0] = (byte) ae.gKu.gDN;
                                    }
                                    if (ae.gKu.gDP >= 0) {
                                        bArr2[1] = (byte) ae.gKu.gDP;
                                    }
                                    q qVar9 = q.INSTANCE;
                                    q.f(414, bArr2, 2);
                                }
                                if (ae.gKu.gDO >= 0 || ae.gKu.gDQ >= 0) {
                                    bArr2[0] = -1;
                                    bArr2[1] = -1;
                                    if (ae.gKu.gDO >= 0) {
                                        bArr2[0] = (byte) ae.gKu.gDO;
                                    }
                                    if (ae.gKu.gDQ >= 0) {
                                        bArr2[1] = (byte) ae.gKu.gDQ;
                                    }
                                    q qVar10 = q.INSTANCE;
                                    q.f(415, bArr2, 2);
                                }
                                if (ae.gKu.gDR >= 0 || ae.gKu.gDS >= 0) {
                                    bArr2[0] = -1;
                                    bArr2[1] = -1;
                                    if (ae.gKu.gDR >= 0) {
                                        bArr2[0] = (byte) ae.gKu.gDR;
                                    }
                                    if (ae.gKu.gDS >= 0) {
                                        bArr2[1] = (byte) ae.gKu.gDS;
                                    }
                                    q qVar11 = q.INSTANCE;
                                    q.f(v2helper.EMethodOutputVolumeGainEnable, bArr2, 2);
                                }
                                if (ae.gKu.gDX >= 0) {
                                    bArr2[0] = (byte) ae.gKu.gDX;
                                    q qVar12 = q.INSTANCE;
                                    q.f(416, bArr2, 1);
                                }
                                if (ae.gKu.gDY >= 0 && ae.gKu.gDY != 5) {
                                    bArr2[0] = (byte) ae.gKu.gDY;
                                    q qVar13 = q.INSTANCE;
                                    q.f(417, bArr2, 1);
                                }
                                if (ae.gKu.gDZ >= 0 && ae.gKu.gDZ != 5) {
                                    bArr2[0] = (byte) ae.gKu.gDZ;
                                    q qVar14 = q.INSTANCE;
                                    q.f(418, bArr2, 1);
                                }
                                if (ae.gKu.gEa >= 0) {
                                    bArr2[0] = (byte) ae.gKu.gEa;
                                    q qVar15 = q.INSTANCE;
                                    q.f(419, bArr2, 1);
                                }
                                if (1 == ae.gKu.gEN) {
                                    byte[] bArr4 = new byte[30];
                                    for (int i2 = 0; i2 < 15; i2++) {
                                        bArr4[i2 * 2] = (byte) (ae.gKu.gEO[i2] & 255);
                                        bArr4[(i2 * 2) + 1] = (byte) ((ae.gKu.gEO[i2] >> 8) & 255);
                                    }
                                    q qVar16 = q.INSTANCE;
                                    q.f(v2helper.EMethodSetPlayerPreCorrectCofOn, bArr4, 30);
                                }
                                if (ae.gKu.gEN == 0) {
                                    q qVar17 = q.INSTANCE;
                                    q.f(v2helper.EMethodSetPlayerPreCorrectCofOff, bArr, 1);
                                }
                                if (ae.gKu.gER > 0) {
                                    bArr2[0] = (byte) ae.gKu.gER;
                                    q qVar18 = q.INSTANCE;
                                    q.f(v2helper.EMethodSetSpkEnhance, bArr2, 1);
                                }
                                if (ae.gKu.gEb > 0) {
                                    bArr2[0] = (byte) ae.gKu.gEb;
                                    q qVar19 = q.INSTANCE;
                                    q.f(431, bArr2, 4);
                                }
                                if (ae.gKu.gEZ >= 0) {
                                    byte[] bArr5 = {(byte) ae.gKu.gEZ, (byte) ae.gKu.gFa, (byte) ae.gKu.gFb, (byte) ae.gKu.gFc};
                                    q qVar20 = q.INSTANCE;
                                    q.f(v2helper.EMethodSetAgcRxOn, bArr5, 4);
                                }
                                if (fVar2.qrM <= 10) {
                                    if (fVar2.qrM <= 0) {
                                        fVar2.qrP = 1;
                                    }
                                    fVar2.qrM = 92;
                                }
                                fVar2.qrH = new com.tencent.mm.audio.b.c(fVar2.mSampleRate, fVar2.mChannels, 1);
                                fVar2.qrH.jk(fVar2.qrV);
                                fVar2.qrH.dd(true);
                                fVar2.qrH.aag();
                                fVar2.qrH.dzk = -19;
                                fVar2.qrH.x(1, false);
                                fVar2.qrH.dc(true);
                                q qVar21 = q.INSTANCE;
                                q.f(401, new byte[1], 1);
                                fVar2.qrH.dzv = fVar2.qrW;
                            }
                            t tVar = q.this.qtf;
                            acs acs2 = acs2;
                            Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "set param.");
                            if (acs2 == null) {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "param is null!!!");
                            } else if (acs2.Lny == null) {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "param.video_param is null!!!");
                            } else if (acs2.Lny.LqQ != null) {
                                int i3 = acs2.Lny.LqQ.width;
                                int i4 = acs2.Lny.LqQ.height;
                                if ((1920 == i3 && i4 == 1080) || (1280 == i3 && i4 == 720)) {
                                    tVar.mWidth = i3;
                                    tVar.mHeight = i4;
                                    Log.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "set cap res: w: " + i3 + ", h: " + i4);
                                } else {
                                    Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "illegal res: w: " + i3 + ", h: " + i4);
                                }
                            } else {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "param.video_param.front_camera is null!!!");
                            }
                            t unused = q.this.qtf;
                            q.a(q.this, bVar);
                            AppMethodBeat.o(90851);
                        }
                    });
                    AppMethodBeat.o(90853);
                    return "";
                }

                private static acs bi(byte[] bArr) {
                    AppMethodBeat.i(186743);
                    acs acs = new acs();
                    try {
                        acs.parseFrom(bArr);
                        AppMethodBeat.o(186743);
                        return acs;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e2, "hy: unable to parse from data", new Object[0]);
                        AppMethodBeat.o(186743);
                        return null;
                    }
                }

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return false;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }
            };
            qVar.qtd.a(22, qVar.qty);
            qVar.qtz = new l.a<String, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return false;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(int i2, String str) {
                    AppMethodBeat.i(90856);
                    q.j(q.this);
                    q.a(q.this, bVar, -10086, -6, "join room talk callback failed: ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(90856);
                    return "";
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    AppMethodBeat.i(184473);
                    AppMethodBeat.o(184473);
                    return "";
                }
            };
            qVar.qtd.a(23, qVar.qtz);
            qVar.qrJ.qsr.clear();
            qVar.qtt = new l.a<ada, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass4 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ ada bf(byte[] bArr) {
                    AppMethodBeat.i(186745);
                    ada bj = bj(bArr);
                    AppMethodBeat.o(186745);
                    return bj;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(final int i2, ada ada) {
                    AppMethodBeat.i(90859);
                    final ada ada2 = ada;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: on member changed");
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(90857);
                            k kVar = q.this.qrJ;
                            ada ada = ada2;
                            if (ada == null || ada.KHx == null || ada.KHx.size() == 0) {
                                kVar.qsr.clear();
                            } else {
                                LinkedList<acz> linkedList = ada.KHx;
                                kVar.qsr.clear();
                                Iterator<acz> it = linkedList.iterator();
                                while (it.hasNext()) {
                                    acz next = it.next();
                                    com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b bVar = new com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b();
                                    bVar.qrD = next.Lnt;
                                    bVar.openId = next.openid;
                                    kVar.qsr.add(bVar);
                                }
                            }
                            t tVar = q.this.qtf;
                            ada ada2 = ada2;
                            Log.e("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "updateMembers");
                            if (!(ada2 == null || ada2.KHx == null || ada2.KHx.size() == 0)) {
                                LinkedList<acz> linkedList2 = ada2.KHx;
                                synchronized (tVar.qvg) {
                                    try {
                                        Iterator<acz> it2 = linkedList2.iterator();
                                        while (it2.hasNext()) {
                                            acz next2 = it2.next();
                                            c cVar = tVar.qvg.get(next2.openid);
                                            if (cVar != null) {
                                                cVar.ES(next2.Lnt);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(90857);
                                        throw th;
                                    }
                                }
                            }
                            if (q.this.qth != d.InRoom) {
                                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room. do not notify");
                                AppMethodBeat.o(90857);
                            } else if (q.this.qto == null) {
                                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: mCurrentMemeberChangeCallback is null");
                                AppMethodBeat.o(90857);
                            } else if (i2 == 0) {
                                q.this.qto.a(0, 0, "ok", q.this.qrJ.qsr);
                                AppMethodBeat.o(90857);
                            } else {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: invalid member list change. will ignore");
                                q.this.qto.a(-10087, i2, "error in member change", null);
                                AppMethodBeat.o(90857);
                            }
                        }
                    });
                    AppMethodBeat.o(90859);
                    return "";
                }

                private static ada bj(byte[] bArr) {
                    AppMethodBeat.i(186744);
                    ada ada = new ada();
                    try {
                        ada.parseFrom(bArr);
                        AppMethodBeat.o(186744);
                        return ada;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e2, "hy: unable to parse from data", new Object[0]);
                        AppMethodBeat.o(186744);
                        return null;
                    }
                }

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return true;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    AppMethodBeat.i(90860);
                    byte[] bArr = new byte[0];
                    AppMethodBeat.o(90860);
                    return bArr;
                }
            };
            qVar.qtd.a(20, qVar.qtt);
            qVar.qtv = new l.a<acr, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ acr bf(byte[] bArr) {
                    AppMethodBeat.i(186747);
                    acr bk = bk(bArr);
                    AppMethodBeat.o(186747);
                    return bk;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(final int i2, acr acr) {
                    AppMethodBeat.i(184475);
                    final acr acr2 = acr;
                    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: on avmembers changed");
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            String ET;
                            AppMethodBeat.i(90861);
                            HashMap hashMap = new HashMap();
                            hashMap.put("audioMembers", acr2.KHx);
                            LinkedList linkedList = new LinkedList();
                            Iterator<acq> it = acr2.KHx.iterator();
                            while (it.hasNext()) {
                                acq next = it.next();
                                int i2 = next.Lnt;
                                if (!((next.Lnu & 2) == 0 || (ET = q.this.qrJ.ET(i2)) == null)) {
                                    linkedList.add(ET);
                                }
                            }
                            hashMap.put("openIdList", linkedList);
                            if (q.this.qth != d.InRoom) {
                                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room. do not notify");
                                AppMethodBeat.o(90861);
                            } else if (q.this.qtq == null) {
                                Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: mCurrentVideoMemberChangeCallback is null");
                                AppMethodBeat.o(90861);
                            } else if (i2 == 0) {
                                q.this.qtq.a(0, 0, "ok", hashMap);
                                AppMethodBeat.o(90861);
                            } else {
                                Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: invalid avmember list change. will ignore");
                                q.this.qtq.a(-10087, i2, "error in avmember change", null);
                                AppMethodBeat.o(90861);
                            }
                        }
                    });
                    AppMethodBeat.o(184475);
                    return "";
                }

                private static acr bk(byte[] bArr) {
                    AppMethodBeat.i(186746);
                    acr acr = new acr();
                    try {
                        acr.parseFrom(bArr);
                        AppMethodBeat.o(186746);
                        return acr;
                    } catch (IOException e2) {
                        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e2, "hy: unable to parse from data", new Object[0]);
                        AppMethodBeat.o(186746);
                        return null;
                    }
                }

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return true;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    AppMethodBeat.i(184476);
                    byte[] bArr = new byte[0];
                    AppMethodBeat.o(184476);
                    return bArr;
                }
            };
            qVar.qtd.a(21, qVar.qtv);
            qVar.qtr = new l.a<String, String>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ String l(int i2, String str) {
                    AppMethodBeat.i(186748);
                    Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: call broken! %d, %s", Integer.valueOf(i2), str);
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(184477);
                            if (q.this.qti != a.ReasonManual) {
                                q.this.qti = a.ReasonInterrupted;
                            }
                            AppMethodBeat.o(184477);
                        }
                    });
                    AppMethodBeat.o(186748);
                    return "";
                }

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return false;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    return "";
                }
            };
            qVar.qtd.a(24, qVar.qtr);
            qVar.qts = new l.a<String, act>() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass7 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    return null;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ byte[] db(act act) {
                    AppMethodBeat.i(186753);
                    byte[] a2 = a(act);
                    AppMethodBeat.o(186753);
                    return a2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final /* synthetic */ act l(int i2, String str) {
                    AppMethodBeat.i(186752);
                    act Fa = Fa(i2);
                    AppMethodBeat.o(186752);
                    return Fa;
                }

                private static byte[] a(act act) {
                    AppMethodBeat.i(186750);
                    if (act != null) {
                        try {
                            byte[] byteArray = act.toByteArray();
                            AppMethodBeat.o(186750);
                            return byteArray;
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceService", e2, "hy: error when convert to byte array", new Object[0]);
                        }
                    }
                    byte[] bArr = new byte[0];
                    AppMethodBeat.o(186750);
                    return bArr;
                }

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l.a
                public final boolean czb() {
                    return true;
                }

                private act Fa(final int i2) {
                    int i3;
                    int i4;
                    int i5;
                    int i6 = -1;
                    int i7 = 0;
                    AppMethodBeat.i(186751);
                    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onResult");
                    if (q.this.qtC) {
                        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "call end, stop ring");
                        q.this.stopRing();
                    }
                    p.qsU = q.this.qte.qrG.qrZ.audioManager.getMode();
                    f fVar = q.this.qte;
                    if (fVar.qrH == null) {
                        i3 = 0;
                    } else {
                        i3 = fVar.qrH.dzd;
                    }
                    p.qsV = i3;
                    com.tencent.mm.plugin.voip.model.c cVar = q.this.qte.qrG.qrZ.qrz;
                    if (cVar != null) {
                        i4 = cVar.bhV();
                    } else {
                        i4 = -1;
                    }
                    p.qsW = i4;
                    if (q.this.qte.qrG.qrZ.qry) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    p.qsX = i5;
                    f fVar2 = q.this.qte;
                    if (fVar2.qrH != null) {
                        i7 = fVar2.qrH.aal();
                    }
                    p.qsY = i7;
                    com.tencent.mm.plugin.voip.model.c cVar2 = q.this.qte.qrG.qrZ.qrz;
                    if (cVar2 != null) {
                        i6 = cVar2.getVolume();
                    }
                    p.qsZ = i6;
                    act act = new act();
                    act.qsR = p.qsR;
                    act.qsS = p.qsS;
                    act.qsT = p.qsT;
                    act.qsY = p.qsY;
                    act.qsX = p.qsX;
                    act.qsV = p.qsV;
                    act.qsU = p.qsU;
                    act.qsW = p.qsW;
                    act.qsZ = p.qsZ;
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(186749);
                            if (q.this.qth != d.InRoom) {
                                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current not in room");
                                q.this.qtF = -1;
                                q.r(q.this);
                                AppMethodBeat.o(186749);
                                return;
                            }
                            if (q.this.qtn != null) {
                                q.this.qtn.a(-10087, i2, "call end", q.this.qti);
                            }
                            q.this.qtF = -1;
                            q.this.qth = d.NotInRoom;
                            q.r(q.this);
                            AppMethodBeat.o(186749);
                        }
                    });
                    AppMethodBeat.o(186751);
                    return act;
                }
            };
            qVar.qtd.a(25, qVar.qts);
            k kVar = qVar.qrJ;
            AnonymousClass8 r1 = new k.a() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k.a
                public final void Q(final ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b> arrayList) {
                    AppMethodBeat.i(186755);
                    Log.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: current talking members are %s", arrayList);
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(186754);
                            if (q.this.qth != d.InRoom) {
                                Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: onSpeakerListChanged but not in room!");
                                AppMethodBeat.o(186754);
                                return;
                            }
                            if (q.this.qtp != null) {
                                q.this.qtp.a(0, 0, "on talklist change", arrayList);
                            }
                            AppMethodBeat.o(186754);
                        }
                    });
                    AppMethodBeat.o(186755);
                }
            };
            synchronized (kVar.qst) {
                try {
                    kVar.qst.add(r1);
                } catch (Throwable th) {
                    AppMethodBeat.o(186780);
                    throw th;
                }
            }
            k kVar2 = qVar.qrJ;
            k.AnonymousClass1 r12 = 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b5: CONSTRUCTOR  (r1v11 'r12' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k$1) = (r0v22 'kVar2' com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k) call: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k.1.<init>(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q, long, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b):void, file: classes7.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.k, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                */
            /*
            // Method dump skipped, instructions count: 248
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.a(com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q, long, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.b):void");
        }

        static /* synthetic */ void a(q qVar, String str, String str2, String str3, int i2, final b bVar) {
            AppMethodBeat.i(186781);
            d.a aVar = new d.a();
            aVar.iLN = new cfa();
            aVar.iLO = new cfb();
            aVar.funcId = 1991;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/joincloudimroom";
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            com.tencent.mm.ak.d aXF = aVar.aXF();
            cfa cfa = (cfa) aXF.iLK.iLR;
            cfa.dNI = qVar.mgS;
            cfa.KBt = str2;
            cfa.signature = str;
            cfa.qwL = i2;
            cfa.Mju = str3;
            cfa.LUq = qVar.qtk;
            IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass26 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(186768);
                    q.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.AnonymousClass26.AnonymousClass1 */

                        @SuppressLint({"DefaultLocale"})
                        public final void run() {
                            AppMethodBeat.i(90882);
                            if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                q.this.qtF = ((cfb) dVar.iLL.iLR).Lnv;
                                q.a(q.this, q.this.qtF, bVar);
                                AppMethodBeat.o(90882);
                                return;
                            }
                            Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: getroomId fail, errType:" + i2 + ",errCode:" + i3);
                            q.a(q.this, bVar, -10088, -10, String.format("join room failed. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                            AppMethodBeat.o(90882);
                        }
                    });
                    AppMethodBeat.o(186768);
                }
            });
            AppMethodBeat.o(186781);
        }
    }
