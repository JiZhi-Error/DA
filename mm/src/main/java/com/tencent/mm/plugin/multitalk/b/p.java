package com.tencent.mm.plugin.multitalk.b;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bh.e;
import com.tencent.mm.bh.f;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitalk.b.k;
import com.tencent.mm.plugin.multitalk.b.l;
import com.tencent.mm.plugin.multitalk.b.r;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.model.s;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efj;
import com.tencent.mm.protocal.protobuf.eri;
import com.tencent.mm.protocal.protobuf.erj;
import com.tencent.mm.protocal.protobuf.erk;
import com.tencent.mm.protocal.protobuf.erl;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.erq;
import com.tencent.mm.protocal.protobuf.ers;
import com.tencent.mm.protocal.protobuf.ert;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.protocal.protobuf.erz;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.esd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum p {
    INSTANCE;
    
    public static int EMethodGetQosPara = 25;
    private final MMHandler luO;
    private boolean mIsInit;
    private MMHandler mainHandler;
    String mgS;
    public boolean qtA;
    boolean qtD;
    private long qtF;
    public boolean qtH;
    private int qtI;
    public boolean qtK;
    public boolean qtL;
    public boolean qtM;
    private boolean qtN;
    private boolean qtO;
    private final int qtP;
    public Runnable qtQ;
    private String qtj;
    private int qtl;
    int qtm;
    String sIX;
    private final r zHT;
    public final l zHU;
    public final f zHV;
    private final t zHW;
    private final i zHX;
    int zHY;
    a zHZ;
    public final k zHs;
    private a zHw;
    private l.a zIA;
    private l.a zIB;
    private l.a zIC;
    private boolean zID;
    private b<String> zIE;
    private d zIF;
    String zIG;
    private long zIH;
    String zII;
    String zIJ;
    int zIK;
    private boolean zIL;
    private boolean zIM;
    private boolean zIN;
    private LinkedList<esc> zIO;
    public b zIP;
    public h zIQ;
    LinkedList<acq> zIR;
    private boolean zIS;
    private efi zIT;
    public Network zIU;
    public ConnectivityManager.NetworkCallback zIV;
    public LinkedList<Integer> zIW;
    public Map<Long, ert> zIX;
    private int zIa;
    private int zIb;
    private b<a> zIc;
    private b<ArrayList<j>> zId;
    private l.a zIe;
    private l.a zIf;
    private l.a zIg;
    private l.a zIh;
    private l.a zIi;
    private l.a zIj;
    l.a zIk;
    l.a zIl;
    public l.a zIm;
    public l.a zIn;
    private l.a zIo;
    private l.a zIp;
    private l.a zIq;
    private l.a zIr;
    private l.a zIs;
    private l.a zIt;
    private l.a zIu;
    private l.a zIv;
    private l.a zIw;
    private l.a zIx;
    public l.a zIy;
    public l.a zIz;

    static /* synthetic */ void R(p pVar) {
        AppMethodBeat.i(239290);
        pVar.czg();
        AppMethodBeat.o(239290);
    }

    static /* synthetic */ void S(p pVar) {
        AppMethodBeat.i(239291);
        pVar.elM();
        AppMethodBeat.o(239291);
    }

    static /* synthetic */ int a(p pVar) {
        AppMethodBeat.i(239280);
        int elP = pVar.elP();
        AppMethodBeat.o(239280);
        return elP;
    }

    static /* synthetic */ int a(p pVar, a aVar) {
        AppMethodBeat.i(239278);
        int b2 = pVar.b(aVar);
        AppMethodBeat.o(239278);
        return b2;
    }

    static /* synthetic */ void a(p pVar, int i2, String str) {
        AppMethodBeat.i(239283);
        pVar.a(null, -10086, i2, str);
        AppMethodBeat.o(239283);
    }

    static /* synthetic */ void a(p pVar, b bVar) {
        AppMethodBeat.i(239281);
        pVar.b(bVar);
        AppMethodBeat.o(239281);
    }

    static /* synthetic */ void a(p pVar, b bVar, int i2, int i3, String str) {
        AppMethodBeat.i(239288);
        pVar.b(bVar, i2, i3, str);
        AppMethodBeat.o(239288);
    }

    static /* synthetic */ void ab(p pVar) {
        AppMethodBeat.i(239295);
        pVar.Hm(5000);
        AppMethodBeat.o(239295);
    }

    static /* synthetic */ void ae(p pVar) {
        AppMethodBeat.i(239297);
        pVar.hg(-10086, -6);
        AppMethodBeat.o(239297);
    }

    static /* synthetic */ void b(p pVar, b bVar) {
        AppMethodBeat.i(239289);
        pVar.c(bVar);
        AppMethodBeat.o(239289);
    }

    static /* synthetic */ void c(p pVar, b bVar) {
        AppMethodBeat.i(239296);
        pVar.d(bVar);
        AppMethodBeat.o(239296);
    }

    static /* synthetic */ int d(p pVar, String str) {
        AppMethodBeat.i(239287);
        int aFy = pVar.aFy(str);
        AppMethodBeat.o(239287);
        return aFy;
    }

    static /* synthetic */ void h(p pVar) {
        AppMethodBeat.i(239282);
        pVar.czf();
        AppMethodBeat.o(239282);
    }

    static /* synthetic */ void l(p pVar) {
        AppMethodBeat.i(239284);
        pVar.elN();
        AppMethodBeat.o(239284);
    }

    static /* synthetic */ void q(p pVar) {
        AppMethodBeat.i(239286);
        pVar.elL();
        AppMethodBeat.o(239286);
    }

    public static p valueOf(String str) {
        AppMethodBeat.i(239231);
        p pVar = (p) Enum.valueOf(p.class, str);
        AppMethodBeat.o(239231);
        return pVar;
    }

    static {
        AppMethodBeat.i(239298);
        AppMethodBeat.o(239298);
    }

    public final void rt(boolean z) {
        AppMethodBeat.i(239232);
        try {
            this.zHV.release();
            if (z && this.zHY == 1) {
                this.zHV.init();
                boolean czm = this.zHV.czm();
                boolean aai = this.zHV.aai();
                if (czm && aai) {
                    Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive restart audio device OK!");
                }
            }
            Log.i("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: ".concat(String.valueOf(z)));
            AppMethodBeat.o(239232);
        } catch (Throwable th) {
            Log.e("MicroMsg.Multitalk.ILinkService", "setRecordDevActive active: " + z + ", error:" + th);
            AppMethodBeat.o(239232);
        }
    }

    public enum b {
        ILinkMemberRoleUnknown,
        ILinkMemberRoleCreate,
        ILinkMemberRoleAccept,
        ILinkMemberRoleJoin;

        public static b valueOf(String str) {
            AppMethodBeat.i(239226);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(239226);
            return bVar;
        }

        static {
            AppMethodBeat.i(239227);
            AppMethodBeat.o(239227);
        }
    }

    public enum a {
        ReasonInterrupted(0),
        ReasonManual(1),
        ReasonDevice(2),
        ReasonInCommingCall(3),
        ReasonSessionUpdateFailed(4),
        ReasonWeappEnterBackground(5),
        ReasonUnknown(100);
        
        final int cND;

        public static a valueOf(String str) {
            AppMethodBeat.i(239223);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(239223);
            return aVar;
        }

        static {
            AppMethodBeat.i(239224);
            AppMethodBeat.o(239224);
        }

        private a(int i2) {
            this.cND = i2;
        }
    }

    private p(String str) {
        AppMethodBeat.i(239233);
        this.qtl = 0;
        this.qtm = 1;
        this.zIa = 2;
        this.zIb = 160;
        this.zIF = null;
        this.qtF = -1;
        this.qtH = false;
        this.qtI = 0;
        this.zII = "";
        this.zIJ = "";
        this.zIK = 4;
        this.zIL = false;
        this.zIM = false;
        this.zIN = false;
        this.sIX = null;
        this.zIP = b.ILinkMemberRoleUnknown;
        this.zIQ = null;
        this.zHw = null;
        this.zIR = null;
        this.zIS = false;
        this.zIT = null;
        this.zIU = null;
        this.zIV = null;
        this.zIW = new LinkedList<>();
        this.mainHandler = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass1 */
            TelephonyManager qtS;
            PhoneStateListener qtT;

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(239102);
                super.handleMessage(message);
                if (message.what == 272) {
                    if (this.qtS == null) {
                        this.qtS = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                        this.qtT = new PhoneStateListener() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass1.AnonymousClass1 */

                            public final void onCallStateChanged(int i2, String str) {
                                AppMethodBeat.i(239101);
                                super.onCallStateChanged(i2, str);
                                switch (i2) {
                                    case 1:
                                        p.this.aj(new Runnable() {
                                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(239100);
                                                Log.i("MicroMsg.Multitalk.ILinkService", "hy: hy: phone broken. exit room if in room");
                                                p.a(p.this, a.ReasonInCommingCall);
                                                AppMethodBeat.o(239100);
                                            }
                                        });
                                        break;
                                }
                                AppMethodBeat.o(239101);
                            }
                        };
                    }
                    TelephonyManager telephonyManager = this.qtS;
                    com.tencent.mm.hellhoundlib.b.a bl = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(this.qtT);
                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, bl.axQ(), "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                    telephonyManager.listen((PhoneStateListener) bl.pG(0), ((Integer) bl.pG(1)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(telephonyManager, "com/tencent/mm/plugin/multitalk/ilinkservice/ILinkService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
                }
                AppMethodBeat.o(239102);
            }
        };
        this.zIX = new ConcurrentHashMap();
        this.qtM = false;
        this.qtN = false;
        this.qtO = false;
        this.qtP = -9999;
        this.qtQ = new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass28 */

            public final void run() {
                AppMethodBeat.i(239197);
                if (p.this.zHY == 0 && !p.this.qtA) {
                    Log.i("MicroMsg.Multitalk.ILinkService", "hy: still not join room in %d ms. directly release", 180000L);
                    p.a(p.this);
                }
                AppMethodBeat.o(239197);
            }
        };
        this.zHT = new r();
        this.zHU = new l();
        this.zHs = new k();
        this.zHV = new f(this.zHs);
        this.zHW = new t(this.zHs);
        this.zHX = new i();
        this.zIF = new d(ac.eom());
        this.luO = new MMHandler("ILink_voip_worker");
        this.zHY = 0;
        this.mgS = null;
        Bundle bundle = (Bundle) h.a("com.tencent.mm", null, c.class);
        if (bundle != null) {
            String string = bundle.getString(DeviceRequestsHelper.DEVICE_INFO_PARAM, "");
            Log.v("MicroMsg.Multitalk.ILinkService", "hy: updatad device info %s", string);
            ae.DV(string);
        } else {
            Log.e("MicroMsg.Multitalk.ILinkService", "hy: can not get device info from mm");
        }
        this.qtA = false;
        this.mIsInit = false;
        this.zID = false;
        this.qtl = 0;
        this.qtm = 1;
        this.zIa = 2;
        this.zIb = 160;
        this.qtD = false;
        this.zIE = null;
        this.zIQ = null;
        this.qtK = false;
        this.qtL = false;
        this.zHw = new a();
        this.zIP = b.ILinkMemberRoleUnknown;
        this.zIM = false;
        this.zIR = null;
        this.zIS = false;
        this.qtH = false;
        this.zIT = new efi();
        this.zIU = null;
        this.zIV = null;
        this.zIW.clear();
        AppMethodBeat.o(239233);
    }

    public final void y(long j2, String str) {
        AppMethodBeat.i(239234);
        this.zIG = str;
        this.zIH = j2;
        Log.i("MicroMsg.Multitalk.ILinkService", "set name=%s, uin=%d", str, Long.valueOf(j2));
        AppMethodBeat.o(239234);
    }

    static class c implements k<Bundle, Bundle> {
        private c() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ Bundle invoke(Bundle bundle) {
            AppMethodBeat.i(239228);
            Bundle bundle2 = new Bundle();
            bundle2.putString(DeviceRequestsHelper.DEVICE_INFO_PARAM, g.aAh().azR().gEu());
            AppMethodBeat.o(239228);
            return bundle2;
        }
    }

    public final void e(final ArrayList<j> arrayList, final String str) {
        AppMethodBeat.i(239235);
        Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter newMultiTalkInvite. %s, %s", arrayList, str);
        this.zII = str;
        aj(new Runnable() {
            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(239153);
                p pVar = p.this;
                ArrayList arrayList = arrayList;
                String str = str;
                Log.i("MicroMsg.Multitalk.ILinkService", "steve:  enter inviteSync. %s, %s", arrayList, str);
                if (pVar.zHY == 1 || pVar.qtA) {
                    Log.w("MicroMsg.Multitalk.ILinkService", "hy: already in room or joining room!");
                    AppMethodBeat.o(239153);
                    return;
                }
                pVar.zHs.amZ();
                pVar.zHs.zHD = str;
                pVar.zHs.zHE = str;
                pVar.sIX = pVar.zIG;
                pVar.mgS = new String("wechat");
                pVar.zHZ = a.ReasonUnknown;
                pVar.qtH = false;
                pVar.qtA = true;
                pVar.qtD = false;
                pVar.zIP = b.ILinkMemberRoleCreate;
                pVar.a(new b<String>(arrayList) {
                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass32 */
                    final /* synthetic */ ArrayList jXR;

                    {
                        this.jXR = r2;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                    @Override // com.tencent.mm.plugin.multitalk.b.b
                    public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                        AppMethodBeat.i(239201);
                        Log.i("MicroMsg.Multitalk.ILinkService", "steve: initEngine done! %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            p.a(p.this, this.jXR);
                            AppMethodBeat.o(239201);
                            return;
                        }
                        p.a(p.this);
                        p.this.zIF.bH(16, p.this.zII);
                        Log.e("MicroMsg.Multitalk.ILinkService", "steve: initEngine fail errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        AppMethodBeat.o(239201);
                    }
                });
                AppMethodBeat.o(239153);
            }
        });
        AppMethodBeat.o(239235);
    }

    private void a(b<ArrayList<j>> bVar, int i2, int i3, String str) {
        AppMethodBeat.i(239236);
        this.qtA = false;
        synchronized (this.zHU) {
            try {
                this.zHU.b(3, this.zIk);
                this.zHU.b(4, this.zIl);
                this.zHU.b(22, this.zIm);
                this.zHU.b(23, this.zIn);
                this.zIk = null;
                this.zIl = null;
                this.zIm = null;
                this.zIn = null;
            } catch (Throwable th) {
                AppMethodBeat.o(239236);
                throw th;
            }
        }
        ArrayList<j> elF = this.zHs.elF();
        if (bVar != null) {
            bVar.a(i2, i3, str, elF);
        }
        if (i2 == 0 && i3 == 0) {
            this.zHY = 1;
            AppMethodBeat.o(239236);
        } else if (i3 == 15) {
            MMHandlerThread.postToMainThread(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0062: INVOKE  
                  (wrap: com.tencent.mm.plugin.multitalk.b.d$8 : 0x005f: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.multitalk.b.d$8) = 
                  (wrap: com.tencent.mm.plugin.multitalk.b.d : 0x005b: IGET  (r0v14 com.tencent.mm.plugin.multitalk.b.d) = (r5v0 'this' com.tencent.mm.plugin.multitalk.b.p A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.zIF com.tencent.mm.plugin.multitalk.b.d)
                 call: com.tencent.mm.plugin.multitalk.b.d.8.<init>(com.tencent.mm.plugin.multitalk.b.d):void type: CONSTRUCTOR)
                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.b.p.a(com.tencent.mm.plugin.multitalk.b.b<java.util.ArrayList<com.tencent.mm.plugin.multitalk.b.j>>, int, int, java.lang.String):void, file: classes7.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.multitalk.b.d$8) = 
                  (wrap: com.tencent.mm.plugin.multitalk.b.d : 0x005b: IGET  (r0v14 com.tencent.mm.plugin.multitalk.b.d) = (r5v0 'this' com.tencent.mm.plugin.multitalk.b.p A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.zIF com.tencent.mm.plugin.multitalk.b.d)
                 call: com.tencent.mm.plugin.multitalk.b.d.8.<init>(com.tencent.mm.plugin.multitalk.b.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.b.p.a(com.tencent.mm.plugin.multitalk.b.b<java.util.ArrayList<com.tencent.mm.plugin.multitalk.b.j>>, int, int, java.lang.String):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 21 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.d, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 27 more
                */
            /*
            // Method dump skipped, instructions count: 117
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.p.a(com.tencent.mm.plugin.multitalk.b.b, int, int, java.lang.String):void");
        }

        private void b(b<ArrayList<j>> bVar, int i2, int i3, String str) {
            AppMethodBeat.i(239237);
            this.qtA = false;
            synchronized (this.zHU) {
                try {
                    this.zHU.b(5, this.zIo);
                    this.zHU.b(6, this.zIp);
                    this.zHU.b(22, this.zIm);
                    this.zHU.b(23, this.zIn);
                    this.zHU.b(7, this.zIs);
                    this.zIo = null;
                    this.zIp = null;
                    this.zIm = null;
                    this.zIn = null;
                    this.zIs = null;
                } catch (Throwable th) {
                    AppMethodBeat.o(239237);
                    throw th;
                }
            }
            ArrayList<j> elF = this.zHs.elF();
            if (bVar != null) {
                bVar.a(i2, i3, str, elF);
            }
            if (i2 == 0 && i3 == 0) {
                this.zHY = 1;
                AppMethodBeat.o(239237);
                return;
            }
            this.zIF.bH(16, this.zII);
            AppMethodBeat.o(239237);
        }

        public final void hg(int i2, int i3) {
            AppMethodBeat.i(239238);
            this.qtA = false;
            synchronized (this.zHU) {
                try {
                    this.zHU.b(14, this.zIy);
                    this.zHU.b(15, this.zIz);
                    this.zHU.b(22, this.zIm);
                    this.zHU.b(23, this.zIn);
                    this.zIy = null;
                    this.zIz = null;
                    this.zIm = null;
                    this.zIn = null;
                    elL();
                } catch (Throwable th) {
                    AppMethodBeat.o(239238);
                    throw th;
                }
            }
            if (i2 == 0 && i3 == 0) {
                this.zHY = 1;
                AppMethodBeat.o(239238);
                return;
            }
            this.zIF.bH(2, this.zII);
            AppMethodBeat.o(239238);
        }

        private void elL() {
            AppMethodBeat.i(239239);
            synchronized (this.zHU) {
                try {
                    this.zHU.b(8, this.zIt);
                    this.zHU.b(9, this.zIu);
                    this.zHU.b(11, this.zIv);
                    this.zHU.b(16, this.zIA);
                    this.zIt = null;
                    this.zIu = null;
                    this.zIv = null;
                    this.zIA = null;
                } finally {
                    AppMethodBeat.o(239239);
                }
            }
        }

        public final void bK(byte[] bArr) {
            boolean z;
            AppMethodBeat.i(239240);
            eri eri = new eri();
            try {
                eri.parseFrom(bArr);
                Log.i("MicroMsg.Multitalk.ILinkService", "got banner msg from wxgroupid %s sdkgroupid %s roomid %d seq %d status %d", eri.NoW, eri.NoX, Long.valueOf(eri.Lnw), Long.valueOf(eri.NoZ), Integer.valueOf(eri.Npa));
                if ((eri.NoX == null || eri.NoX.equals("")) && eri.Npa != 0) {
                    AppMethodBeat.o(239240);
                    return;
                }
                ac.eom().eM(eri.NoW, 2);
                d dVar = this.zIF;
                Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onMultiTalkBannerChange:%s, status:%d, banner seq:%d", eri.NoW, Integer.valueOf(eri.Npa), Long.valueOf(eri.NoZ));
                String str = eri.NoW;
                if (eri.NoW == null || eri.NoW == "") {
                    AppMethodBeat.o(239240);
                    return;
                }
                try {
                    String str2 = (String) g.aAh().azQ().get(2, (Object) null);
                    if (str2 == null) {
                        Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "userName is null");
                        AppMethodBeat.o(239240);
                        return;
                    }
                    String str3 = eri.Npb;
                    f aFI = ac.eoi().aFI(str);
                    if (aFI != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (eri.Npa == 0 || aFI == null || aFI.field_ilinkRoomId == 0 || eri.Lnw == aFI.field_ilinkRoomId) {
                        if (!dVar.zHl.containsKey(str) || eri.NoZ >= dVar.zHl.get(str).longValue()) {
                            dVar.zHl.put(str, Long.valueOf(eri.NoZ));
                        } else if (eri.Npa == 2) {
                            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that expired wxgroupid %s roomid %d seq %d cached seq %d", str, Long.valueOf(eri.Lnw), Long.valueOf(eri.NoZ), dVar.zHl.get(str));
                            AppMethodBeat.o(239240);
                            return;
                        }
                        if (eri.Npa == 0 && z) {
                            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "get WxVoiceBannerEnd,dismiss bar!");
                            if (!ac.eop().aGg(str) && ac.eop().enT().contains(str) && ac.eop().iL(str, str2)) {
                                ac.eom();
                                q.aGd(str);
                            }
                            ac.eom().aGc(str);
                            ac.eom().aFX(str);
                            ac.eop().aFO(str);
                            ac.eop().aGf(str);
                            ac.eop().enT().remove(str);
                            AppMethodBeat.o(239240);
                        } else if (eri.Npa != 1 || z) {
                            if (eri.Npa == 2) {
                                Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange!2,member size : " + eri.NoY.size());
                                boolean z2 = false;
                                Iterator<esd> it = eri.NoY.iterator();
                                String str4 = "";
                                while (it.hasNext()) {
                                    esd next = it.next();
                                    if (!next.Npo.username.equals(str2)) {
                                        str4 = str4 + next.Npo.username + ",";
                                    } else {
                                        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", "");
                                        z2 = true;
                                    }
                                }
                                Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(str4)));
                                if (!z2) {
                                    if (!ac.eop().aGg(str) && ac.eop().enT().contains(str) && ac.eop().iL(str, str2)) {
                                        ac.eom();
                                        q.aGd(str);
                                    }
                                    ac.eop().aGf(str);
                                    ac.eop().enT().remove(str);
                                } else {
                                    ac.eop().enT().contains(str);
                                }
                                ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), z.aTY());
                                Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "WxVoiceBannerMemChange setWxUinAndUsrName:");
                                s eop = ac.eop();
                                Log.i("MicroMsg.MultiTalkRoomListMsg", "updateBanner  wxGroupId = %s", str);
                                f aFI2 = ac.eoi().aFI(str);
                                if (aFI2 == null) {
                                    Log.i("MicroMsg.MultiTalkRoomListMsg", "change,still show banner.");
                                    eop.a(str, eri);
                                } else if (aFI2.field_ilinkRoomId != eri.Lnw) {
                                    Log.i("MicroMsg.MultiTalkRoomListMsg", "roomid has changed! now return!multiTalkInfo.field_roomId:" + aFI2.field_roomId + "bannerinfo.roomid:" + eri.Lnw);
                                    AppMethodBeat.o(239240);
                                    return;
                                } else if (!s.b(str, eri)) {
                                    Log.e("MicroMsg.MultiTalkRoomListMsg", "update multiTalkMember failure!");
                                    AppMethodBeat.o(239240);
                                    return;
                                } else {
                                    eop.aGh(str);
                                    AppMethodBeat.o(239240);
                                    return;
                                }
                            }
                            AppMethodBeat.o(239240);
                        } else {
                            boolean z3 = false;
                            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "The count of banner member is %d, groupid[%s]", Integer.valueOf(eri.NoY.size()), str);
                            Iterator<esd> it2 = eri.NoY.iterator();
                            String str5 = "";
                            while (it2.hasNext()) {
                                esd next2 = it2.next();
                                if (!next2.Npo.username.equals(str2)) {
                                    str5 = str5 + next2.Npo.username + ",";
                                } else {
                                    Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Somebody invite me! username[%s]", "");
                                    z3 = true;
                                }
                            }
                            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "memberUserNames :".concat(String.valueOf(str5)));
                            if (!z3) {
                                ac.eop().aGf(str);
                                ac.eop().enT().remove(str);
                            } else {
                                ac.eop().enT().contains(str);
                            }
                            if (str2.equals(str3)) {
                                ac.eom().d(str, str3, false, false);
                            } else if (z3) {
                                ac.eom().d(str, str3, false, false);
                            } else {
                                ac.eom().d(str, str3, true, false);
                            }
                            ac.eop().a(str, eri);
                            ac.eol().zMd.dr(Util.nullAsNil((Integer) g.aAh().hqB.get(1)), z.aTY());
                            AppMethodBeat.o(239240);
                        }
                    } else {
                        Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "Ignore a banner msg that roomid not mathced wxgroupid %s roomid %d cached roomid %d", str, Long.valueOf(eri.Lnw), Long.valueOf(aFI.field_ilinkRoomId));
                        AppMethodBeat.o(239240);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.Multitalk.ILink2MtCallBack", "parse  bannerinfo  failure! xml" + e2.toString());
                    AppMethodBeat.o(239240);
                }
            } catch (IOException e3) {
                Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e3, "hy: unable to parse from data", new Object[0]);
                AppMethodBeat.o(239240);
            }
        }

        public final void Rb(final int i2) {
            AppMethodBeat.i(239241);
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(239122);
                    m.QZ(i2);
                    AppMethodBeat.o(239122);
                }
            });
            AppMethodBeat.o(239241);
        }

        public final void a(final b<String> bVar) {
            AppMethodBeat.i(239242);
            Log.i("MicroMsg.Multitalk.ILinkService", "steve: initsession : isInit :%b ", Boolean.valueOf(this.mIsInit));
            if (this.mIsInit && this.zHY == 0) {
                elM();
            }
            if (!this.mIsInit) {
                d.a aVar = new d.a();
                aVar.iLN = new erl();
                aVar.iLO = new erm();
                aVar.funcId = 573;
                aVar.uri = "/cgi-bin/micromsg-bin/voipmtgetauthcode";
                aVar.iLP = 0;
                aVar.respCmdId = 0;
                IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(239129);
                        p.this.aj(new Runnable() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(239128);
                                if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                    String yO = ((erm) dVar.iLL.iLR).Npe.yO();
                                    p.this.zIq = new l.a<String, String>() {
                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final boolean czb() {
                                            return true;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* synthetic */ String l(final int i2, String str) {
                                            AppMethodBeat.i(239125);
                                            p.this.aj(new Runnable() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(239124);
                                                    n.INSTANCE.cBn();
                                                    p.this.mIsInit = true;
                                                    Log.i("MicroMsg.Multitalk.ILinkService", "init engine success");
                                                    p.this.zHU.b(1, p.this.zIq);
                                                    if (bVar != null) {
                                                        bVar.a(i2, i2, str, null);
                                                    }
                                                    AppMethodBeat.o(239124);
                                                }
                                            });
                                            AppMethodBeat.o(239125);
                                            return "";
                                        }

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                            return new byte[0];
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                            return "";
                                        }
                                    };
                                    p.this.zIr = new l.a<String, String>() {
                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6.AnonymousClass1.AnonymousClass2 */

                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final boolean czb() {
                                            return true;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* synthetic */ String l(final int i2, String str) {
                                            AppMethodBeat.i(239127);
                                            p.this.aj(new Runnable() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass6.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(239126);
                                                    Log.i("MicroMsg.Multitalk.ILinkService", "init engine fail %d", Integer.valueOf(i2));
                                                    p.this.zID = true;
                                                    p.this.zHU.b(2, p.this.zIr);
                                                    if (bVar != null) {
                                                        bVar.a(i2, i2, str, null);
                                                    }
                                                    AppMethodBeat.o(239126);
                                                }
                                            });
                                            AppMethodBeat.o(239127);
                                            return "";
                                        }

                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                            return new byte[0];
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                        public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                            return "";
                                        }
                                    };
                                    p.this.zHU.a(1, p.this.zIq);
                                    p.this.zHU.a(2, p.this.zIr);
                                    int d2 = p.d(p.this, yO);
                                    if (d2 != 0) {
                                        Log.i("MicroMsg.Multitalk.ILinkService", "initEngine failed ret=%d", Integer.valueOf(d2));
                                        if (bVar != null) {
                                            bVar.a(-10086, -3, "initengine failed", "");
                                        }
                                        AppMethodBeat.o(239128);
                                        return;
                                    }
                                    AppMethodBeat.o(239128);
                                    return;
                                }
                                Log.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + i2 + ",errCode:" + i3);
                                AppMethodBeat.o(239128);
                            }
                        });
                        AppMethodBeat.o(239129);
                    }
                });
                AppMethodBeat.o(239242);
                return;
            }
            aj(new Runnable() {
                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(239130);
                    n.INSTANCE.cBn();
                    if (bVar != null) {
                        bVar.a(0, 0, null, null);
                    }
                    AppMethodBeat.o(239130);
                }
            });
            AppMethodBeat.o(239242);
        }

        private void elM() {
            AppMethodBeat.i(239243);
            if (this.mIsInit || this.zID) {
                Log.i("MicroMsg.Multitalk.ILinkService", "uninitEngine called!");
                this.zHT.akH(this.mgS);
                this.zHs.amZ();
                this.zHV.release();
                this.zHW.release();
                this.zHU.kK(true);
                this.mIsInit = false;
                this.zID = false;
                n.INSTANCE.cBo();
                this.zIL = false;
                this.zIN = false;
                this.zIM = false;
                this.qtA = false;
                if (this.zIR != null) {
                    this.zIR.clear();
                    this.zIR = null;
                }
                elW();
                this.zIU = null;
                this.zIV = null;
                this.zIW.clear();
                czf();
                m.cze();
            }
            AppMethodBeat.o(239243);
        }

        private int aFy(String str) {
            AppMethodBeat.i(239244);
            int a2 = m.a(str, this.qtl, this.zIa, this.zIb, this.zHU.kK(false));
            this.zIh = new l.a<String, String>() {
                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final boolean czb() {
                    return true;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final /* synthetic */ String l(int i2, String str) {
                    AppMethodBeat.i(239133);
                    Log.w("MicroMsg.Multitalk.ILinkService", "hy: session key expired!! reset session key");
                    p.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(239132);
                            if (Util.isNullOrNil(p.this.mgS) || p.this.zHY == 1) {
                                Log.w("MicroMsg.Multitalk.ILinkService", "hy: not in room now");
                                AppMethodBeat.o(239132);
                                return;
                            }
                            p.this.zHT.akH(p.this.mgS);
                            r rVar = p.this.zHT;
                            String str = p.this.mgS;
                            AnonymousClass1 r6 = new r.a() {
                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.multitalk.b.r.a
                                public final void a(int i2, int i3, q qVar) {
                                    AppMethodBeat.i(239131);
                                    if (i2 != 0 || i3 != 0 || qVar == null || !qVar.isValid()) {
                                        Log.w("MicroMsg.Multitalk.ILinkService", "hy: refresh session key error!");
                                        p.a(p.this, a.ReasonSessionUpdateFailed);
                                        AppMethodBeat.o(239131);
                                        return;
                                    }
                                    m.akF(qVar.quX);
                                    AppMethodBeat.o(239131);
                                }
                            };
                            q qVar = rVar.qva.get(str);
                            if (qVar == null || !qVar.isValid()) {
                                rVar.qva.remove(str);
                                d.a aVar = new d.a();
                                aVar.iLN = new erj();
                                aVar.iLO = new erk();
                                aVar.funcId = 3773;
                                aVar.uri = "/cgi-bin/micromsg-bin/voipmtgensession";
                                aVar.iLP = 0;
                                aVar.respCmdId = 0;
                                com.tencent.mm.ak.d aXF = aVar.aXF();
                                ((erj) aXF.iLK.iLR).dNI = str;
                                IPCRunCgi.a(aXF, new IPCRunCgi.a(r6, str) {
                                    /* class com.tencent.mm.plugin.multitalk.b.r.AnonymousClass2 */
                                    final /* synthetic */ String kFU;
                                    final /* synthetic */ a zKy;

                                    {
                                        this.zKy = r2;
                                        this.kFU = r3;
                                    }

                                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                                    public final void a(int i2, int i3, String str, d dVar) {
                                        AppMethodBeat.i(239302);
                                        if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                            q qVar = new q();
                                            qVar.quX = ((erk) dVar.iLL.iLR).Npc.yO();
                                            qVar.quZ = Util.currentTicks();
                                            qVar.quY = 0;
                                            Log.i("MicroMsg.Multitalk.ILinkSessionMgr", "hy: getSession sessionKey: %s", qVar);
                                            r.this.qva.put(this.kFU, qVar);
                                            r.a(r.this, 0, 0, "", qVar, true, this.zKy);
                                            AppMethodBeat.o(239302);
                                            return;
                                        }
                                        Log.e("MicroMsg.Multitalk.ILinkSessionMgr", "hy: get sessionkey fail,errType:" + i2 + ",errCode:" + i3);
                                        r.a(r.this, i2, i3, str, null, false, this.zKy);
                                        AppMethodBeat.o(239302);
                                    }
                                });
                                AppMethodBeat.o(239132);
                                return;
                            }
                            Log.d("MicroMsg.Multitalk.ILinkSessionMgr", "hy: has valid sessionKey");
                            rVar.a(0, 0, "", qVar, false, r6);
                            AppMethodBeat.o(239132);
                        }
                    });
                    AppMethodBeat.o(239133);
                    return "";
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                    return new byte[0];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                    return "";
                }
            };
            this.zHU.a(26, this.zIh);
            AppMethodBeat.o(239244);
            return a2;
        }

        public final void czf() {
            this.qtM = false;
            this.qtN = false;
            this.qtO = false;
        }

        /* access modifiers changed from: package-private */
        public final void b(b<ArrayList<j>> bVar) {
            int elE;
            int elD;
            int i2 = 1;
            AppMethodBeat.i(239245);
            Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger JoinSucc: %b %b %b", Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO));
            if (this.qtM && this.qtO && this.qtN) {
                if (this.qtD) {
                    f(bVar);
                    AppMethodBeat.o(239245);
                    return;
                }
                this.zHW.czm();
                boolean czm = this.zHV.czm();
                boolean aai = this.zHV.aai();
                if (czm && aai) {
                    i2 = 0;
                }
                o.qsR = i2;
                if (czm) {
                    elE = 0;
                } else {
                    elE = this.zHV.elE();
                }
                o.qsT = elE;
                if (aai) {
                    elD = 0;
                } else {
                    elD = this.zHV.elD();
                }
                o.qsS = elD;
                if (!czm || !aai) {
                    e(bVar);
                } else {
                    a(bVar, 0, 0, "ok");
                    AppMethodBeat.o(239245);
                    return;
                }
            }
            AppMethodBeat.o(239245);
        }

        private void c(b<ArrayList<j>> bVar) {
            int i2;
            int elE;
            int elD;
            AppMethodBeat.i(239246);
            Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger InviteSucc: %b %b %b %b %b", Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO), Boolean.valueOf(this.zIL), Boolean.valueOf(this.zIM));
            if (this.qtM && this.qtO && this.qtN && this.zIL && !this.zIM) {
                if (this.qtD) {
                    f(bVar);
                    AppMethodBeat.o(239246);
                    return;
                }
                this.zHW.czm();
                boolean czm = this.zHV.czm();
                boolean aai = this.zHV.aai();
                if (!czm || !aai) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                o.qsR = i2;
                if (czm) {
                    elE = 0;
                } else {
                    elE = this.zHV.elE();
                }
                o.qsT = elE;
                if (aai) {
                    elD = 0;
                } else {
                    elD = this.zHV.elD();
                }
                o.qsS = elD;
                if (!czm || !aai) {
                    e(bVar);
                } else {
                    b(bVar, 0, 0, "ok");
                    this.zIM = true;
                    AppMethodBeat.o(239246);
                    return;
                }
            }
            AppMethodBeat.o(239246);
        }

        public final void d(b<ArrayList<j>> bVar) {
            int elE;
            int elD;
            int i2 = 1;
            AppMethodBeat.i(239247);
            Log.i("MicroMsg.Multitalk.ILinkService", "hy: try trigger AcceptSucc: %b %b %b", Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO));
            if (this.qtM && this.qtO && this.qtN) {
                if (this.qtD) {
                    f(bVar);
                    AppMethodBeat.o(239247);
                    return;
                }
                this.zHW.czm();
                boolean czm = this.zHV.czm();
                boolean aai = this.zHV.aai();
                if (czm && aai) {
                    i2 = 0;
                }
                o.qsR = i2;
                if (czm) {
                    elE = 0;
                } else {
                    elE = this.zHV.elE();
                }
                o.qsT = elE;
                if (aai) {
                    elD = 0;
                } else {
                    elD = this.zHV.elD();
                }
                o.qsS = elD;
                if (!czm || !aai) {
                    e(bVar);
                } else {
                    hg(0, 0);
                    AppMethodBeat.o(239247);
                    return;
                }
            }
            AppMethodBeat.o(239247);
        }

        private void e(b<ArrayList<j>> bVar) {
            AppMethodBeat.i(239248);
            this.zIF.bH(4, this.zII);
            a(bVar, -10086, -7, "start audio device failed");
            b(a.ReasonDevice);
            AppMethodBeat.o(239248);
        }

        /* access modifiers changed from: package-private */
        public static class d implements k<Bundle, Bundle> {
            private d() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.k
            public final /* synthetic */ Bundle invoke(Bundle bundle) {
                AppMethodBeat.i(239229);
                Bundle bundle2 = new Bundle();
                boolean z = com.tencent.mm.q.a.att() || m.fKH() || m.isVoipStarted() || m.fKI();
                Log.i("MicroMsg.Multitalk.ILinkService", "steve: check voip state:%b,%b,%b,%b,%b", Boolean.valueOf(z), Boolean.valueOf(com.tencent.mm.q.a.att()), Boolean.valueOf(m.fKH()), Boolean.valueOf(m.isVoipStarted()), Boolean.valueOf(m.fKI()));
                bundle2.putBoolean("is_in_voip", z);
                AppMethodBeat.o(239229);
                return bundle2;
            }
        }

        private void f(b<ArrayList<j>> bVar) {
            AppMethodBeat.i(239249);
            Log.w("MicroMsg.Multitalk.ILinkService", "hy: require exit. try exit exit again");
            a(bVar, -10086, -9, "interrupted because already cancelled or entered background");
            int b2 = b(this.zHZ);
            if (this.zIE != null) {
                if (b2 == 0) {
                    this.zIE.a(0, 0, "ok", "");
                } else {
                    this.zIE.a(-10086, -17, "exit failed", "");
                }
            }
            this.qtD = false;
            this.zIE = null;
            AppMethodBeat.o(239249);
        }

        /* access modifiers changed from: package-private */
        public final void elN() {
            AppMethodBeat.i(239250);
            this.zIg = new l.a<ada, String>() {
                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final /* synthetic */ ada bf(byte[] bArr) {
                    AppMethodBeat.i(239161);
                    ada bj = bj(bArr);
                    AppMethodBeat.o(239161);
                    return bj;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                public final /* synthetic */ String l(int i2, ada ada) {
                    AppMethodBeat.i(239160);
                    final ada ada2 = ada;
                    Log.i("MicroMsg.Multitalk.ILinkService", "hy: on member changed");
                    p.this.aj(new Runnable() {
                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(239158);
                            Log.i("MicroMsg.Multitalk.ILinkService", "update members, imroomid:%d roomid:%d memberNum:%d seq:%d status:%d", Long.valueOf(ada2.Lnv), Long.valueOf(ada2.Lnw), Integer.valueOf(ada2.KHx.size()), Integer.valueOf(ada2.Lom), Integer.valueOf(ada2.Lon));
                            LinkedList<String> linkedList = new LinkedList<>();
                            Iterator<acz> it = ada2.KHx.iterator();
                            while (it.hasNext()) {
                                acz next = it.next();
                                String str = next.openid;
                                if (str != null) {
                                    Log.i("MicroMsg.Multitalk.ILinkService", "member %s status %d", next.openid, Integer.valueOf(next.status));
                                    linkedList.add(str);
                                }
                            }
                            if (linkedList.size() > 0) {
                                p.this.zIS = true;
                                i unused = p.this.zHX;
                                long unused2 = p.this.zIH;
                                String str2 = p.this.zII;
                                d.a aVar = new d.a();
                                aVar.iLN = new erp();
                                aVar.iLO = new erq();
                                aVar.funcId = 3602;
                                aVar.uri = "/cgi-bin/micromsg-bin/voipmtgetsdkuserinfo";
                                aVar.iLP = 0;
                                aVar.respCmdId = 0;
                                com.tencent.mm.ak.d aXF = aVar.aXF();
                                erp erp = (erp) aXF.iLK.iLR;
                                erp.Nph = linkedList;
                                erp.NoW = str2;
                                IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                                    public final void a(final int i2, final int i3, String str, final com.tencent.mm.ak.d dVar) {
                                        AppMethodBeat.i(239156);
                                        Log.i("MicroMsg.Multitalk.ILinkService", "on invite result: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                        p.this.aj(new Runnable() {
                                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @SuppressLint({"DefaultLocale"})
                                            public final void run() {
                                                int i2;
                                                AppMethodBeat.i(239155);
                                                if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                                    p.this.zHs.a(ada2, ((erq) dVar.iLL.iLR).Npi, p.this.zIG, p.this.sIX, new b<String>() {
                                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                                        @Override // com.tencent.mm.plugin.multitalk.b.b
                                                        public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                                                            AppMethodBeat.i(239154);
                                                            Log.i("MicroMsg.Multitalk.ILinkService", "steve: updateMembers done! %d, %d, %s, videoMidLst:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, p.this.zIR);
                                                            if (!(i2 == 0 && i3 == 0)) {
                                                                Log.e("MicroMsg.Multitalk.ILinkService", "steve: updateMembers fail errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                                            }
                                                            AppMethodBeat.o(239154);
                                                        }
                                                    });
                                                    p.this.zHs.zHI = (long) ada2.Lom;
                                                    p.this.zHW.a(ada2);
                                                    if (p.this.zIR != null) {
                                                        p.this.zHs.be(p.this.zIR);
                                                    }
                                                    Iterator<acz> it = ada2.KHx.iterator();
                                                    int i3 = 0;
                                                    int i4 = 0;
                                                    while (it.hasNext()) {
                                                        acz next = it.next();
                                                        if (next.openid != null) {
                                                            Log.i("MicroMsg.Multitalk.ILinkService", "member %s status %d", next.openid, Integer.valueOf(next.status));
                                                            if (next.status == 1) {
                                                                i4++;
                                                            }
                                                            if (next.status == 2 || next.status == 3) {
                                                                i2 = i3 + 1;
                                                            } else {
                                                                i2 = i3;
                                                            }
                                                            i3 = i2;
                                                        }
                                                    }
                                                    if (i4 == 0) {
                                                        j aFx = p.this.zHs.aFx(p.this.zHs.zHG);
                                                        if (aFx != null && aFx.mStatus == 5) {
                                                            d dVar = p.this.zIF;
                                                            k unused = p.this.zHs;
                                                            Log.i("MicroMsg.Multitalk.ILink2MtCallBack", "onCancelCreateMultiTalk");
                                                            MMHandlerThread.postToMainThread(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x016e: INVOKE  
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.d$4 : 0x016b: CONSTRUCTOR  (r3v25 com.tencent.mm.plugin.multitalk.b.d$4) = (r0v138 'dVar' com.tencent.mm.plugin.multitalk.b.d) call: com.tencent.mm.plugin.multitalk.b.d.4.<init>(com.tencent.mm.plugin.multitalk.b.d):void type: CONSTRUCTOR)
                                                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.b.p.13.1.1.1.run():void, file: classes7.dex
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
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x016b: CONSTRUCTOR  (r3v25 com.tencent.mm.plugin.multitalk.b.d$4) = (r0v138 'dVar' com.tencent.mm.plugin.multitalk.b.d) call: com.tencent.mm.plugin.multitalk.b.d.4.<init>(com.tencent.mm.plugin.multitalk.b.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.b.p.13.1.1.1.run():void, file: classes7.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	... 31 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.d, state: GENERATED_AND_UNLOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                	... 37 more
                                                                */
                                                            /*
                                                            // Method dump skipped, instructions count: 739
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1.AnonymousClass1.AnonymousClass1.run():void");
                                                        }
                                                    });
                                                    AppMethodBeat.o(239156);
                                                }
                                            });
                                            AppMethodBeat.o(239158);
                                            return;
                                        }
                                        Log.i("MicroMsg.Multitalk.ILinkService", "no member in room. remove the banner");
                                        p.this.zHs.a(ada2, null, p.this.zIG, p.this.sIX, new b<String>() {
                                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass13.AnonymousClass1.AnonymousClass2 */

                                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                            @Override // com.tencent.mm.plugin.multitalk.b.b
                                            public final /* synthetic */ void a(int i2, int i3, String str, String str2) {
                                                AppMethodBeat.i(239157);
                                                Log.i("MicroMsg.Multitalk.ILinkService", "steve: updateMembers done! %d, %d, %s, videoMidLst:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, p.this.zIR);
                                                if (!(i2 == 0 && i3 == 0)) {
                                                    Log.e("MicroMsg.Multitalk.ILinkService", "steve: updateMembers fail errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                                }
                                                AppMethodBeat.o(239157);
                                            }
                                        });
                                        p.this.zHs.zHI = (long) ada2.Lom;
                                        p.this.zHW.a(ada2);
                                        p.b(p.this, 0);
                                        p.R(p.this);
                                        p.S(p.this);
                                        AppMethodBeat.o(239158);
                                    }
                                });
                                AppMethodBeat.o(239160);
                                return "";
                            }

                            private static ada bj(byte[] bArr) {
                                AppMethodBeat.i(239159);
                                ada ada = new ada();
                                try {
                                    ada.parseFrom(bArr);
                                    AppMethodBeat.o(239159);
                                    return ada;
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e2, "hy: unable to parse from data", new Object[0]);
                                    AppMethodBeat.o(239159);
                                    return null;
                                }
                            }

                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final boolean czb() {
                                return true;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                return new byte[0];
                            }
                        };
                        this.zHU.a(20, this.zIg);
                        this.zIi = new l.a<acr, String>() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass14 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* synthetic */ acr bf(byte[] bArr) {
                                AppMethodBeat.i(239165);
                                acr bk = bk(bArr);
                                AppMethodBeat.o(239165);
                                return bk;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* synthetic */ String l(final int i2, acr acr) {
                                AppMethodBeat.i(239164);
                                final acr acr2 = acr;
                                Log.i("MicroMsg.Multitalk.ILinkService", "hy: on avmembers changed");
                                p.this.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass14.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(239162);
                                        Log.i("MicroMsg.Multitalk.ILinkService", "update avmembers, imroomid:%d roomid:%d memberList:%s", Long.valueOf(acr2.Lnv), Long.valueOf(acr2.Lnw), acr2.KHx);
                                        if (p.this.zHY != 1) {
                                            Log.i("MicroMsg.Multitalk.ILinkService", "hy: not in room. do not notify");
                                            AppMethodBeat.o(239162);
                                        } else if (i2 == 0) {
                                            ArrayList arrayList = new ArrayList();
                                            ArrayList arrayList2 = new ArrayList();
                                            Iterator<acq> it = acr2.KHx.iterator();
                                            while (it.hasNext()) {
                                                acq next = it.next();
                                                if ((next.Lnu & 2) != 0) {
                                                    arrayList.add(Integer.valueOf(next.Lnt));
                                                }
                                                if ((next.Lnu & 4) != 0) {
                                                    arrayList2.add(Integer.valueOf(next.Lnt));
                                                }
                                                Log.i("MicroMsg.Multitalk.ILinkService", "avmemberchange, mid:%d, avstatus:%d", Integer.valueOf(next.Lnt), Integer.valueOf(next.Lnu));
                                            }
                                            if (!p.this.zIS) {
                                                p.this.zIF.a(p.this.zHs, acr2.KHx);
                                            }
                                            p.this.zIR = acr2.KHx;
                                            Log.i("MicroMsg.Multitalk.ILinkService", "update avmembers, cachedMemberList:%s", p.this.zIR);
                                            AppMethodBeat.o(239162);
                                        } else {
                                            Log.e("MicroMsg.Multitalk.ILinkService", "hy: invalid avmember list change. will ignore");
                                            AppMethodBeat.o(239162);
                                        }
                                    }
                                });
                                AppMethodBeat.o(239164);
                                return "";
                            }

                            private static acr bk(byte[] bArr) {
                                AppMethodBeat.i(239163);
                                acr acr = new acr();
                                try {
                                    acr.parseFrom(bArr);
                                    AppMethodBeat.o(239163);
                                    return acr;
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e2, "hy: unable to parse from data", new Object[0]);
                                    AppMethodBeat.o(239163);
                                    return null;
                                }
                            }

                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final boolean czb() {
                                return true;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                return new byte[0];
                            }
                        };
                        this.zHU.a(21, this.zIi);
                        this.zIe = new l.a<String, String>() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass15 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* synthetic */ String l(int i2, String str) {
                                AppMethodBeat.i(239167);
                                Log.w("MicroMsg.Multitalk.ILinkService", "hy: call broken! %d, %s", Integer.valueOf(i2), str);
                                p.this.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass15.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(239166);
                                        if (p.this.zHZ != a.ReasonManual) {
                                            p.this.zHZ = a.ReasonInterrupted;
                                        }
                                        p.this.zIF.bH(8, p.this.zII);
                                        AppMethodBeat.o(239166);
                                    }
                                });
                                AppMethodBeat.o(239167);
                                return "";
                            }

                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final boolean czb() {
                                return true;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                return new byte[0];
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                return "";
                            }
                        };
                        this.zHU.a(24, this.zIe);
                        this.zIf = new l.a<String, act>() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass16 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                return null;
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* synthetic */ byte[] db(act act) {
                                AppMethodBeat.i(239171);
                                byte[] a2 = a(act);
                                AppMethodBeat.o(239171);
                                return a2;
                            }

                            private static byte[] a(act act) {
                                AppMethodBeat.i(239169);
                                if (act != null) {
                                    try {
                                        byte[] byteArray = act.toByteArray();
                                        AppMethodBeat.o(239169);
                                        return byteArray;
                                    } catch (IOException e2) {
                                        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e2, "hy: error when convert to byte array", new Object[0]);
                                    }
                                }
                                byte[] bArr = new byte[0];
                                AppMethodBeat.o(239169);
                                return bArr;
                            }

                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final boolean czb() {
                                return true;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                            @Override // com.tencent.mm.plugin.multitalk.b.l.a
                            public final /* synthetic */ act l(final int i2, String str) {
                                int i3;
                                int i4;
                                int i5;
                                int aal;
                                int i6 = -1;
                                AppMethodBeat.i(239170);
                                p.X(p.this);
                                o.qsU = p.this.zHV.zHq.zHu.audioManager.getMode();
                                f fVar = p.this.zHV;
                                if (fVar.qrH == null) {
                                    i3 = 0;
                                } else {
                                    i3 = fVar.qrH.dzd;
                                }
                                o.qsV = i3;
                                com.tencent.mm.plugin.voip.model.c cVar = p.this.zHV.zHq.zHu.qrz;
                                if (cVar != null) {
                                    i4 = cVar.bhV();
                                } else {
                                    i4 = -1;
                                }
                                o.qsW = i4;
                                if (p.this.zHV.zHq.zHu.qry) {
                                    i5 = 1;
                                } else {
                                    i5 = 0;
                                }
                                o.qsX = i5;
                                f fVar2 = p.this.zHV;
                                if (fVar2.qrH == null) {
                                    aal = 0;
                                } else {
                                    aal = fVar2.qrH.aal();
                                }
                                o.qsY = aal;
                                f fVar3 = p.this.zHV;
                                if (fVar3.zHq != null) {
                                    com.tencent.mm.plugin.voip.model.c cVar2 = fVar3.zHq.zHu.qrz;
                                    if (cVar2 != null) {
                                        i6 = cVar2.getVolume();
                                    }
                                } else {
                                    i6 = 0;
                                }
                                o.qsZ = i6;
                                act act = new act();
                                act.qsR = o.qsR;
                                act.qsS = o.qsS;
                                act.qsT = o.qsT;
                                act.qsY = o.qsY;
                                act.qsX = o.qsX;
                                act.qsV = o.qsV;
                                act.qsU = o.qsU;
                                act.qsW = o.qsW;
                                act.qsZ = o.qsZ;
                                p.this.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass16.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(239168);
                                        if (p.this.zHY != 1) {
                                            Log.w("MicroMsg.Multitalk.ILinkService", "hy: current not in room");
                                            p.this.qtF = -1;
                                            p.R(p.this);
                                            p.S(p.this);
                                            AppMethodBeat.o(239168);
                                            return;
                                        }
                                        if (p.this.zIc != null) {
                                            p.this.zIc.a(-10087, i2, "call end", p.this.zHZ);
                                        }
                                        p.this.qtF = -1;
                                        p.this.zIL = false;
                                        p.this.zIM = false;
                                        p.this.zHY = 0;
                                        p.this.qtA = false;
                                        p.ab(p.this);
                                        AppMethodBeat.o(239168);
                                    }
                                });
                                AppMethodBeat.o(239170);
                                return act;
                            }
                        };
                        this.zHU.a(25, this.zIf);
                        k kVar = this.zHs;
                        AnonymousClass17 r1 = new k.a() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass17 */

                            @Override // com.tencent.mm.plugin.multitalk.b.k.a
                            public final void Q(final ArrayList<j> arrayList) {
                                AppMethodBeat.i(239173);
                                Log.v("MicroMsg.Multitalk.ILinkService", "hy: current talking members are %s", arrayList);
                                p.this.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass17.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(239172);
                                        if (p.this.zHY != 1) {
                                            Log.w("MicroMsg.Multitalk.ILinkService", "hy: onSpeakerListChanged but not in room!");
                                            AppMethodBeat.o(239172);
                                            return;
                                        }
                                        if (p.this.zId != null) {
                                            p.this.zId.a(0, 0, "on talklist change", arrayList);
                                        }
                                        AppMethodBeat.o(239172);
                                    }
                                });
                                AppMethodBeat.o(239173);
                            }
                        };
                        synchronized (kVar.qst) {
                            try {
                                kVar.qst.add(r1);
                            } catch (Throwable th) {
                                AppMethodBeat.o(239250);
                                throw th;
                            }
                        }
                        k kVar2 = this.zHs;
                        k.AnonymousClass1 r12 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005c: CONSTRUCTOR  (r1v5 'r12' com.tencent.mm.plugin.multitalk.b.k$1) = (r0v11 'kVar2' com.tencent.mm.plugin.multitalk.b.k) call: com.tencent.mm.plugin.multitalk.b.k.1.<init>(com.tencent.mm.plugin.multitalk.b.k):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.b.p.elN():void, file: classes7.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.k, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 14 more
                            */
                        /*
                        // Method dump skipped, instructions count: 137
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.p.elN():void");
                    }

                    private void czg() {
                        AppMethodBeat.i(239251);
                        this.zHs.qsr.clear();
                        this.zHs.elG();
                        this.zHV.release();
                        this.zHW.release();
                        synchronized (this.zHU) {
                            try {
                                this.zHU.b(24, this.zIe);
                                this.zHU.b(27, this.zIj);
                                this.zHU.b(25, this.zIf);
                                this.zHU.b(20, this.zIg);
                                this.zIe = null;
                                this.zIf = null;
                                this.zIg = null;
                                this.zIh = null;
                                this.zIj = null;
                            } finally {
                                AppMethodBeat.o(239251);
                            }
                        }
                    }

                    public final void aj(Runnable runnable) {
                        AppMethodBeat.i(239252);
                        if (this.luO.getSerialTag().equals(com.tencent.f.j.a.hmF())) {
                            runnable.run();
                            AppMethodBeat.o(239252);
                            return;
                        }
                        this.luO.post(runnable);
                        AppMethodBeat.o(239252);
                    }

                    private void m(Runnable runnable, long j2) {
                        AppMethodBeat.i(239253);
                        this.luO.postDelayed(runnable, j2);
                        AppMethodBeat.o(239253);
                    }

                    private static int a(a aVar) {
                        AppMethodBeat.i(239254);
                        switch (aVar) {
                            case ReasonSessionUpdateFailed:
                            case ReasonUnknown:
                            case ReasonInterrupted:
                                AppMethodBeat.o(239254);
                                return 0;
                            case ReasonManual:
                                AppMethodBeat.o(239254);
                                return 1;
                            case ReasonInCommingCall:
                                AppMethodBeat.o(239254);
                                return 6;
                            case ReasonDevice:
                                AppMethodBeat.o(239254);
                                return 8;
                            case ReasonWeappEnterBackground:
                                AppMethodBeat.o(239254);
                                return 7;
                            default:
                                AppMethodBeat.o(239254);
                                return 0;
                        }
                    }

                    private int b(a aVar) {
                        AppMethodBeat.i(239255);
                        Log.i("MicroMsg.Multitalk.ILinkService", "hy: trigger exit with reason: %s", aVar);
                        this.zHZ = aVar;
                        if (this.qtA) {
                            Log.w("MicroMsg.Multitalk.ILinkService", "hy: current joining room. waiting for exiting after joining");
                            this.qtD = true;
                            AppMethodBeat.o(239255);
                            return -9999;
                        } else if (this.zHY == 0) {
                            Log.w("MicroMsg.Multitalk.ILinkService", "hy: not in room! maybe is joining room");
                            AppMethodBeat.o(239255);
                            return 0;
                        } else {
                            int EV = m.EV(a(aVar));
                            Hm(180000);
                            AppMethodBeat.o(239255);
                            return EV;
                        }
                    }

                    public final void elO() {
                        AppMethodBeat.i(239256);
                        if (this.zHY != 1) {
                            Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", Integer.valueOf(this.zHY));
                            AppMethodBeat.o(239256);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList<j> elF = this.zHs.elF();
                        if (elF == null || elF.size() == 0) {
                            AppMethodBeat.o(239256);
                            return;
                        }
                        LinkedList<efj> linkedList = new LinkedList<>();
                        LinkedList<efj> linkedList2 = new LinkedList<>();
                        Iterator<j> it = elF.iterator();
                        while (it.hasNext()) {
                            j next = it.next();
                            if (this.zIG.equals(next.goe)) {
                                Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", Integer.valueOf(next.qrD), next.goe);
                            } else {
                                int i2 = next.qrD;
                                efj efj = new efj();
                                efj.Lnt = i2;
                                efj.NfF = 480;
                                int QY = QY(i2);
                                if (QY == 102 || QY == 101) {
                                    efj.NfF = 240;
                                    linkedList2.add(efj);
                                } else {
                                    linkedList.add(efj);
                                }
                                Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", Integer.valueOf(i2), next.goe);
                            }
                        }
                        this.zIT.xuS = linkedList;
                        if (ac.eom().enw().zND) {
                            this.zIT.NfE = linkedList2;
                        } else {
                            this.zIT.NfE = null;
                        }
                        Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribe, videoMembers %s", arrayList);
                        m.a(this.zIT);
                        AppMethodBeat.o(239256);
                    }

                    public final int aFz(String str) {
                        AppMethodBeat.i(239257);
                        int i2 = -1;
                        j aFx = this.zHs.aFx(str);
                        if (aFx != null) {
                            i2 = aFx.qrD;
                        }
                        AppMethodBeat.o(239257);
                        return i2;
                    }

                    public final void az(final ArrayList<Integer> arrayList) {
                        AppMethodBeat.i(239258);
                        aj(new Runnable() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass30 */
                            final /* synthetic */ boolean zKa = false;

                            public final void run() {
                                int i2;
                                AppMethodBeat.i(239199);
                                if (p.this.zHY != 1) {
                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", Integer.valueOf(p.this.zHY));
                                    AppMethodBeat.o(239199);
                                } else if (arrayList == null) {
                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: no subscribers, return,  status: %d", Integer.valueOf(p.this.zHY));
                                    AppMethodBeat.o(239199);
                                } else if (arrayList.size() != 1 || this.zKa) {
                                    if (this.zKa) {
                                        i2 = 640;
                                    } else {
                                        i2 = 480;
                                    }
                                    LinkedList<efj> linkedList = new LinkedList<>();
                                    LinkedList<efj> linkedList2 = new LinkedList<>();
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        Integer num = (Integer) it.next();
                                        efj efj = new efj();
                                        efj.Lnt = num.intValue();
                                        efj.NfF = i2;
                                        int QY = p.this.QY(num.intValue());
                                        if (QY == 102 || QY == 101) {
                                            efj.NfF = 240;
                                            linkedList2.add(efj);
                                        } else {
                                            linkedList.add(efj);
                                        }
                                        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", num);
                                    }
                                    p.this.zIT.xuS = linkedList;
                                    if (ac.eom().enw().zND) {
                                        p.this.zIT.NfE = linkedList2;
                                    } else {
                                        p.this.zIT.NfE = null;
                                    }
                                    Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeByUserMids, videoMembers %s", p.this.zIT);
                                    m.a(p.this.zIT);
                                    AppMethodBeat.o(239199);
                                } else {
                                    p.this.elO();
                                    AppMethodBeat.o(239199);
                                }
                            }
                        });
                        AppMethodBeat.o(239258);
                    }

                    public final void d(ArrayList<String> arrayList, final boolean z) {
                        AppMethodBeat.i(239259);
                        if (this.zHY != 1) {
                            Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", Integer.valueOf(this.zHY));
                            AppMethodBeat.o(239259);
                            return;
                        }
                        final ArrayList arrayList2 = new ArrayList();
                        if (arrayList.size() > 0) {
                            Iterator<String> it = arrayList.iterator();
                            while (it.hasNext()) {
                                j aFx = this.zHs.aFx(it.next());
                                if (aFx != null) {
                                    arrayList2.add(Integer.valueOf(aFx.qrD));
                                }
                            }
                        }
                        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeScreenByUsernames, screen midlist:%s,memberName%s", arrayList2, arrayList);
                        aj(new Runnable() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass31 */
                            final /* synthetic */ int zKc = 1920;

                            public final void run() {
                                ArrayList<j> elF;
                                AppMethodBeat.i(239200);
                                if (p.this.zHY != 1) {
                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: not in room, status: %d", Integer.valueOf(p.this.zHY));
                                    AppMethodBeat.o(239200);
                                    return;
                                }
                                LinkedList<efj> linkedList = new LinkedList<>();
                                LinkedList<efj> linkedList2 = new LinkedList<>();
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    Iterator it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        Integer num = (Integer) it.next();
                                        efj efj = new efj();
                                        efj.Lnt = num.intValue();
                                        efj.NfF = this.zKc;
                                        linkedList2.add(efj);
                                        Log.i("MicroMsg.Multitalk.ILinkService", "subscribeByUserMids, videoMembers memberId:%d", num);
                                    }
                                }
                                if (!(!z || (elF = p.this.zHs.elF()) == null || elF.size() == 0)) {
                                    Iterator<j> it2 = elF.iterator();
                                    while (it2.hasNext()) {
                                        j next = it2.next();
                                        if (p.this.zIG.equals(next.goe)) {
                                            Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, skip myself memberId:%d,memberName%s", Integer.valueOf(next.qrD), next.goe);
                                        } else {
                                            int i2 = next.qrD;
                                            efj efj2 = new efj();
                                            efj2.Lnt = i2;
                                            efj2.NfF = 480;
                                            int QY = p.this.QY(i2);
                                            if (QY == 102 || QY == 101) {
                                                efj2.NfF = 240;
                                                linkedList2.add(efj2);
                                            } else {
                                                linkedList.add(efj2);
                                            }
                                            Log.i("MicroMsg.Multitalk.ILinkService", "subscribeAll, videoMembers memberId:%d,memberName%s", Integer.valueOf(i2), next.goe);
                                        }
                                    }
                                }
                                p.this.zIT.xuS = linkedList;
                                if (ac.eom().enw().zND) {
                                    p.this.zIT.NfE = linkedList2;
                                } else {
                                    p.this.zIT.NfE = null;
                                }
                                Log.i("MicroMsg.Multitalk.ILinkService", "hy: subscribeScreenByUserMids, videoMembers %s", p.this.zIT);
                                m.a(p.this.zIT);
                                AppMethodBeat.o(239200);
                            }
                        });
                        AppMethodBeat.o(239259);
                    }

                    public final int QY(int i2) {
                        AppMethodBeat.i(239260);
                        int QY = this.zHs.QY(i2);
                        AppMethodBeat.o(239260);
                        return QY;
                    }

                    private void Hm(long j2) {
                        AppMethodBeat.i(239261);
                        m(this.qtQ, j2);
                        AppMethodBeat.o(239261);
                    }

                    private int elP() {
                        AppMethodBeat.i(239262);
                        Log.i("MicroMsg.Multitalk.ILinkService", "hy: reset sync, sdkReset %b", Boolean.TRUE);
                        elM();
                        this.zHT.akH(this.mgS);
                        o.qsR = 0;
                        o.qsS = 0;
                        o.qsT = 0;
                        o.qsU = 0;
                        o.qsV = 0;
                        o.qsW = 0;
                        o.qsX = 0;
                        o.qsY = 0;
                        o.qsZ = 0;
                        this.mgS = null;
                        this.qtj = null;
                        czg();
                        this.mIsInit = false;
                        this.zID = false;
                        this.zIM = false;
                        this.qtA = false;
                        n.INSTANCE.cBo();
                        AppMethodBeat.o(239262);
                        return 0;
                    }

                    public final t elQ() {
                        return this.zHW;
                    }

                    public final int g(byte[] bArr, int i2, int i3, int i4) {
                        boolean z;
                        char c2;
                        int i5 = 1;
                        AppMethodBeat.i(239263);
                        if (this.qtK) {
                            if (m.e(EMethodGetQosPara, this.zHw.s2p, this.zHw.s2p.length) >= 0) {
                                a aVar = this.zHw;
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
                                a aVar2 = this.zHw;
                                Log.d("ILink[HWEnc]", "raw S2P:" + aVar2.s2p);
                                Log.d("ILink[HWEnc]", "-S2P- iKbps:" + ((int) aVar2.iKbps) + ", fps:" + ((int) aVar2.cFps) + ", IP:" + ((int) aVar2.cIPeriod) + ", Reso:" + ((int) aVar2.cResolution) + ", Codec:" + ((int) aVar2.qrE) + ", HWEnable:" + ((int) aVar2.qrF) + ", Skip:" + ((int) aVar2.cSkipFlag) + ", IReq:" + ((int) aVar2.cIReqFlag) + ", Rsvd1:" + ((int) aVar2.cRsvd1));
                            }
                            if (!this.qtK) {
                                this.qtL = false;
                            } else if (8 == this.zHw.qrE) {
                                this.qtL = true;
                            } else {
                                this.qtL = false;
                            }
                            if (this.zHw.qrF == 0) {
                                this.qtK = false;
                                this.qtL = false;
                            }
                            if (1 == this.zHw.cSkipFlag || !this.qtK || !this.qtL) {
                                c2 = 65535;
                            } else {
                                if (!this.qtK || this.zIQ != null) {
                                    h hVar = this.zIQ;
                                    a aVar3 = this.zHw;
                                    if (!(hVar.zHw == null || hVar.qsc == null)) {
                                        a aVar4 = hVar.zHw;
                                        aVar4.iKbps = aVar3.iKbps;
                                        aVar4.cFps = aVar3.cFps;
                                        aVar4.cIPeriod = aVar3.cIPeriod;
                                        aVar4.cResolution = aVar3.cResolution;
                                        aVar4.qrE = aVar3.qrE;
                                        aVar4.qrF = aVar3.qrF;
                                        aVar4.cSkipFlag = aVar3.cSkipFlag;
                                        aVar4.cIReqFlag = aVar3.cIReqFlag;
                                        aVar4.cRsvd1 = aVar3.cRsvd1;
                                        int i6 = (int) (((double) hVar.zHw.iKbps) * 1.1d);
                                        if (hVar.m_br_kbps != i6) {
                                            hVar.SetBitRate(i6);
                                            Log.i("ILink[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + hVar.m_br_kbps + ", tuneBR:" + i6);
                                            hVar.m_br_kbps = i6;
                                        }
                                        if (1 == hVar.zHw.cIReqFlag && h.frameID > 0) {
                                            if (hVar.qsc != null) {
                                                Log.v("ILink[HWEnc]", "steve: Sync frame request soon!");
                                                Bundle bundle = new Bundle();
                                                bundle.putInt("request-sync", 0);
                                                hVar.qsc.setParameters(bundle);
                                            }
                                            Log.i("ILink[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
                                        }
                                        if (hVar.zHw.cFps != hVar.m_framerate) {
                                            hVar.m_framerate = hVar.zHw.cFps;
                                        }
                                    }
                                } else {
                                    this.zIQ = new h(this.zHw.cFps, this.zHw.iKbps, "video/avc");
                                }
                                c2 = 0;
                            }
                            z = c2 < 0;
                        } else {
                            z = false;
                        }
                        if (!this.qtL) {
                            i5 = m.c(bArr, i2, i3, i4);
                        } else if (this.zIQ == null || z) {
                            i5 = -1;
                        } else {
                            int b2 = this.zIQ.b(bArr, i2, i3, i4);
                            if (b2 < 0) {
                                Log.e("MicroMsg.Multitalk.ILinkService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(b2)));
                                this.qtL = false;
                                i5 = -1;
                            }
                        }
                        AppMethodBeat.o(239263);
                        return i5;
                    }

                    public static u a(byte[] bArr, int i2, int i3, int i4, int i5, int[] iArr) {
                        AppMethodBeat.i(239264);
                        u a2 = m.a(bArr, i2, i3, i4, i5, iArr);
                        AppMethodBeat.o(239264);
                        return a2;
                    }

                    static int Y(byte[] bArr, int i2) {
                        AppMethodBeat.i(239265);
                        int W = m.W(bArr, i2);
                        AppMethodBeat.o(239265);
                        return W;
                    }

                    static boolean a(j jVar) {
                        AppMethodBeat.i(239266);
                        if (m.EU(jVar.qrD) > 0) {
                            AppMethodBeat.o(239266);
                            return true;
                        }
                        AppMethodBeat.o(239266);
                        return false;
                    }

                    public final List<String> elR() {
                        AppMethodBeat.i(239267);
                        ArrayList<j> elF = this.zHs.elF();
                        ArrayList arrayList = new ArrayList();
                        if (elF == null || elF.size() == 0) {
                            AppMethodBeat.o(239267);
                            return null;
                        } else if (this.zHY != 1) {
                            AppMethodBeat.o(239267);
                            return null;
                        } else {
                            Iterator<j> it = elF.iterator();
                            while (it.hasNext()) {
                                j next = it.next();
                                if (a(next)) {
                                    Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingMember, memberId:%d,memberName:%s", Integer.valueOf(next.qrD), next.goe);
                                    arrayList.add(next.goe);
                                }
                            }
                            AppMethodBeat.o(239267);
                            return arrayList;
                        }
                    }

                    public final Map<String, Integer> elS() {
                        AppMethodBeat.i(239268);
                        ArrayList<j> elF = this.zHs.elF();
                        HashMap hashMap = new HashMap();
                        if (elF == null || elF.size() == 0) {
                            AppMethodBeat.o(239268);
                            return null;
                        } else if (this.zHY != 1) {
                            AppMethodBeat.o(239268);
                            return null;
                        } else {
                            Iterator<j> it = elF.iterator();
                            while (it.hasNext()) {
                                j next = it.next();
                                int EU = m.EU(next.qrD);
                                if (EU > 0) {
                                    Log.d("MicroMsg.Multitalk.ILinkService", "getTalkingEnergyMember, memberId:%d,memberName:%s", Integer.valueOf(next.qrD), next.goe);
                                    hashMap.put(next.goe, Integer.valueOf(EU));
                                }
                            }
                            AppMethodBeat.o(239268);
                            return hashMap;
                        }
                    }

                    public final List<String> elT() {
                        AppMethodBeat.i(239269);
                        ArrayList<j> elF = this.zHs.elF();
                        ArrayList arrayList = new ArrayList();
                        if (elF != null && elF.size() > 0 && this.zHY == 1) {
                            Iterator<j> it = elF.iterator();
                            while (it.hasNext()) {
                                j next = it.next();
                                byte[] bArr = new byte[4];
                                if (m.X(bArr, next.qrD) >= 0) {
                                    int byteArrayToInt = Util.byteArrayToInt(bArr);
                                    Log.d("MicroMsg.Multitalk.ILinkService", "netStatus: %d", Integer.valueOf(byteArrayToInt));
                                    if (byteArrayToInt != -1 && byteArrayToInt <= 3) {
                                        arrayList.add(next.goe);
                                    }
                                }
                            }
                        }
                        AppMethodBeat.o(239269);
                        return arrayList;
                    }

                    static void G(byte[] bArr, int i2, int i3) {
                        AppMethodBeat.i(239270);
                        m.F(bArr, i2, i3);
                        AppMethodBeat.o(239270);
                    }

                    public static int f(int i2, byte[] bArr, int i3) {
                        AppMethodBeat.i(239271);
                        int e2 = m.e(i2, bArr, i3);
                        AppMethodBeat.o(239271);
                        return e2;
                    }

                    static int S(byte[] bArr, int i2) {
                        AppMethodBeat.i(239272);
                        int R = m.R(bArr, i2);
                        AppMethodBeat.o(239272);
                        return R;
                    }

                    /* access modifiers changed from: package-private */
                    public final void EZ(int i2) {
                        AppMethodBeat.i(239273);
                        this.zIK = i2;
                        m.EW(i2);
                        AppMethodBeat.o(239273);
                    }

                    /* access modifiers changed from: package-private */
                    public final void elU() {
                        AppMethodBeat.i(239274);
                        n nVar = n.INSTANCE;
                        this.zIK = n.elK();
                        AppMethodBeat.o(239274);
                    }

                    public final void elV() {
                        AppMethodBeat.i(239275);
                        Log.i("MicroMsg.Multitalk.ILinkService", "In networkRequestViaCellular");
                        if (com.tencent.mm.compatible.util.d.oD(21)) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                            NetworkRequest.Builder builder = new NetworkRequest.Builder();
                            builder.addTransportType(0);
                            builder.addCapability(12);
                            NetworkRequest build = builder.build();
                            Log.i("MicroMsg.Multitalk.ILinkService", "NetworkRequest toString: " + build.toString() + " hashCode: " + build.hashCode());
                            try {
                                connectivityManager.requestNetwork(build, new ConnectivityManager.NetworkCallback() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass37 */

                                    public final void onAvailable(Network network) {
                                        AppMethodBeat.i(239206);
                                        super.onAvailable(network);
                                        Parcel obtain = Parcel.obtain();
                                        network.writeToParcel(obtain, 0);
                                        Log.i("MicroMsg.Multitalk.ILinkService", "found requested network. netid: " + obtain.readInt() + " toString: " + network.toString());
                                        if (com.tencent.mm.compatible.util.d.oD(28)) {
                                            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                                            try {
                                                Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference ret ".concat(String.valueOf(connectivityManager.getMultipathPreference(network))));
                                            } catch (Exception e2) {
                                                Log.i("MicroMsg.Multitalk.ILinkService", "getMultipathPreference  Error");
                                                try {
                                                    connectivityManager.unregisterNetworkCallback(this);
                                                    AppMethodBeat.o(239206);
                                                    return;
                                                } catch (Exception e3) {
                                                    Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
                                                    AppMethodBeat.o(239206);
                                                    return;
                                                }
                                            }
                                        }
                                        p.this.zIU = network;
                                        if (p.this.zIW != null) {
                                            for (int i2 = 0; i2 < p.this.zIW.size(); i2++) {
                                                p.this.aE(p.this.zIW.get(i2).intValue(), true);
                                            }
                                        }
                                        p.this.zIV = this;
                                        Log.i("MicroMsg.Multitalk.ILinkService", "networkcallback hashCode: " + p.this.zIV.hashCode());
                                        AppMethodBeat.o(239206);
                                    }
                                });
                                AppMethodBeat.o(239275);
                            } catch (Exception e2) {
                                Log.i("MicroMsg.Multitalk.ILinkService", "missing the appropriate permissions");
                                AppMethodBeat.o(239275);
                            }
                        } else {
                            AppMethodBeat.o(239275);
                        }
                    }

                    public final void aE(int i2, boolean z) {
                        AppMethodBeat.i(239276);
                        Log.i("MicroMsg.Multitalk.ILinkService", "start bindSocket " + i2 + " ToNetwork " + this.zIU + " rebind " + z);
                        if (i2 == -1) {
                            elW();
                        }
                        if (!z) {
                            this.zIW.add(Integer.valueOf(i2));
                        }
                        if (this.zIU != null && com.tencent.mm.compatible.util.d.oD(23)) {
                            FileDescriptor fileDescriptor = new FileDescriptor();
                            try {
                                Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
                                declaredField.setAccessible(true);
                                declaredField.setInt(fileDescriptor, i2);
                                this.zIU.bindSocket(fileDescriptor);
                                Log.d("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork success: network" + this.zIU + "+socketfd" + i2);
                                AppMethodBeat.o(239276);
                                return;
                            } catch (Exception e2) {
                                Log.i("MicroMsg.Multitalk.ILinkService", "bindSocketToNetwork Error");
                            }
                        }
                        AppMethodBeat.o(239276);
                    }

                    private void elW() {
                        AppMethodBeat.i(239277);
                        Log.i("MicroMsg.Multitalk.ILinkService", "try to UnregisterCellularNetwork");
                        if (com.tencent.mm.compatible.util.d.oD(21)) {
                            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
                            if (this.zIV != null) {
                                Log.i("MicroMsg.Multitalk.ILinkService", "unregister networkcallback hashCode: " + this.zIV.hashCode());
                                try {
                                    connectivityManager.unregisterNetworkCallback(this.zIV);
                                } catch (Exception e2) {
                                    Log.i("MicroMsg.Multitalk.ILinkService", "unregisterNetworkCallback Error");
                                }
                                this.zIV = null;
                                this.zIU = null;
                            }
                        }
                        AppMethodBeat.o(239277);
                    }

                    static /* synthetic */ void a(p pVar, ArrayList arrayList) {
                        AppMethodBeat.i(239279);
                        LinkedList linkedList = new LinkedList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            linkedList.add(((j) it.next()).goe);
                        }
                        IPCRunCgi.a(i.bd(linkedList), new IPCRunCgi.a() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9 */
                            final /* synthetic */ b zJv = null;

                            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                            public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
                                AppMethodBeat.i(239150);
                                Log.i("MicroMsg.Multitalk.ILinkService", "on invite result: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                p.this.aj(new Runnable() {
                                    /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1 */

                                    @SuppressLint({"DefaultLocale"})
                                    public final void run() {
                                        AppMethodBeat.i(239149);
                                        if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                                            final LinkedList<esc> linkedList = ((ers) dVar.iLL.iLR).Npi;
                                            LinkedList linkedList2 = new LinkedList();
                                            ArrayList<j> arrayList = new ArrayList<>();
                                            Iterator<esc> it = linkedList.iterator();
                                            while (it.hasNext()) {
                                                esc next = it.next();
                                                if (!next.username.equals(p.this.zIG)) {
                                                    linkedList2.add(next.Npd);
                                                }
                                                j jVar = new j();
                                                jVar.openId = next.Npd;
                                                jVar.goe = next.username;
                                                arrayList.add(jVar);
                                                Log.i("MicroMsg.Multitalk.ILinkService", "on invite users: %s, usrname:%s", next.Npd, next.username);
                                            }
                                            p.this.zHs.zHF = arrayList;
                                            p.this.zIo = new l.a<acx, String>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ acx bf(byte[] bArr) {
                                                    AppMethodBeat.i(239138);
                                                    acx bN = bN(bArr);
                                                    AppMethodBeat.o(239138);
                                                    return bN;
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ String l(int i2, acx acx) {
                                                    AppMethodBeat.i(239137);
                                                    final acx acx2 = acx;
                                                    p.this.aj(new Runnable() {
                                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                        public final void run() {
                                                            esc esc;
                                                            AppMethodBeat.i(239135);
                                                            Log.i("MicroMsg.Multitalk.ILinkService", "invite success, roomid:%d, selfmemberid:%d, selfname:%s", Long.valueOf(acx2.Lnw), Integer.valueOf(acx2.Loj), p.this.zIG);
                                                            p.this.zHY = 1;
                                                            p.this.zHs.zHB = acx2.Lnw;
                                                            p.this.zHs.zHG = p.this.zIG;
                                                            p.this.zHs.zHJ = acx2.KBt;
                                                            p.this.qtF = acx2.Lnw;
                                                            p.this.qtN = true;
                                                            Iterator it = linkedList.iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    esc = null;
                                                                    break;
                                                                }
                                                                esc = (esc) it.next();
                                                                if (esc.username.equals(p.this.zIG)) {
                                                                    break;
                                                                }
                                                            }
                                                            MMHandlerThread.postToMainThread(
                                                            /*  JADX ERROR: Method code generation error
                                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00e0: INVOKE  
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.d$5 : 0x00dd: CONSTRUCTOR  (r3v5 com.tencent.mm.plugin.multitalk.b.d$5) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.d : 0x00cb: IGET  (r1v15 com.tencent.mm.plugin.multitalk.b.d) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p : 0x00c9: IGET  (r1v14 com.tencent.mm.plugin.multitalk.b.p) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9 : 0x00c7: IGET  (r1v13 com.tencent.mm.plugin.multitalk.b.p$9) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1 : 0x00c5: IGET  (r1v12 com.tencent.mm.plugin.multitalk.b.p$9$1) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1$1 : 0x00c3: IGET  (r1v11 com.tencent.mm.plugin.multitalk.b.p$9$1$1) = (r10v0 'this' com.tencent.mm.plugin.multitalk.b.p$9$1$1$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.zJA com.tencent.mm.plugin.multitalk.b.p$9$1$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.1.zJy com.tencent.mm.plugin.multitalk.b.p$9$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.zJw com.tencent.mm.plugin.multitalk.b.p$9)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.zIZ com.tencent.mm.plugin.multitalk.b.p)
                                                                 com.tencent.mm.plugin.multitalk.b.p.zIF com.tencent.mm.plugin.multitalk.b.d)
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.k : 0x00d7: IGET  (r2v9 com.tencent.mm.plugin.multitalk.b.k) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p : 0x00d5: IGET  (r2v8 com.tencent.mm.plugin.multitalk.b.p) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9 : 0x00d3: IGET  (r2v7 com.tencent.mm.plugin.multitalk.b.p$9) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1 : 0x00d1: IGET  (r2v6 com.tencent.mm.plugin.multitalk.b.p$9$1) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1$1 : 0x00cf: IGET  (r2v5 com.tencent.mm.plugin.multitalk.b.p$9$1$1) = (r10v0 'this' com.tencent.mm.plugin.multitalk.b.p$9$1$1$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.zJA com.tencent.mm.plugin.multitalk.b.p$9$1$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.1.zJy com.tencent.mm.plugin.multitalk.b.p$9$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.zJw com.tencent.mm.plugin.multitalk.b.p$9)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.zIZ com.tencent.mm.plugin.multitalk.b.p)
                                                                 com.tencent.mm.plugin.multitalk.b.p.zHs com.tencent.mm.plugin.multitalk.b.k)
                                                                 call: com.tencent.mm.plugin.multitalk.b.d.5.<init>(com.tencent.mm.plugin.multitalk.b.d, com.tencent.mm.plugin.multitalk.b.k):void type: CONSTRUCTOR)
                                                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.run():void, file: classes7.dex
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
                                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00dd: CONSTRUCTOR  (r3v5 com.tencent.mm.plugin.multitalk.b.d$5) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.d : 0x00cb: IGET  (r1v15 com.tencent.mm.plugin.multitalk.b.d) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p : 0x00c9: IGET  (r1v14 com.tencent.mm.plugin.multitalk.b.p) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9 : 0x00c7: IGET  (r1v13 com.tencent.mm.plugin.multitalk.b.p$9) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1 : 0x00c5: IGET  (r1v12 com.tencent.mm.plugin.multitalk.b.p$9$1) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1$1 : 0x00c3: IGET  (r1v11 com.tencent.mm.plugin.multitalk.b.p$9$1$1) = (r10v0 'this' com.tencent.mm.plugin.multitalk.b.p$9$1$1$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.zJA com.tencent.mm.plugin.multitalk.b.p$9$1$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.1.zJy com.tencent.mm.plugin.multitalk.b.p$9$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.zJw com.tencent.mm.plugin.multitalk.b.p$9)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.zIZ com.tencent.mm.plugin.multitalk.b.p)
                                                                 com.tencent.mm.plugin.multitalk.b.p.zIF com.tencent.mm.plugin.multitalk.b.d)
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.k : 0x00d7: IGET  (r2v9 com.tencent.mm.plugin.multitalk.b.k) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p : 0x00d5: IGET  (r2v8 com.tencent.mm.plugin.multitalk.b.p) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9 : 0x00d3: IGET  (r2v7 com.tencent.mm.plugin.multitalk.b.p$9) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1 : 0x00d1: IGET  (r2v6 com.tencent.mm.plugin.multitalk.b.p$9$1) = 
                                                                  (wrap: com.tencent.mm.plugin.multitalk.b.p$9$1$1 : 0x00cf: IGET  (r2v5 com.tencent.mm.plugin.multitalk.b.p$9$1$1) = (r10v0 'this' com.tencent.mm.plugin.multitalk.b.p$9$1$1$1 A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.zJA com.tencent.mm.plugin.multitalk.b.p$9$1$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.1.zJy com.tencent.mm.plugin.multitalk.b.p$9$1)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.1.zJw com.tencent.mm.plugin.multitalk.b.p$9)
                                                                 com.tencent.mm.plugin.multitalk.b.p.9.zIZ com.tencent.mm.plugin.multitalk.b.p)
                                                                 com.tencent.mm.plugin.multitalk.b.p.zHs com.tencent.mm.plugin.multitalk.b.k)
                                                                 call: com.tencent.mm.plugin.multitalk.b.d.5.<init>(com.tencent.mm.plugin.multitalk.b.d, com.tencent.mm.plugin.multitalk.b.k):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.multitalk.b.p.9.1.1.1.run():void, file: classes7.dex
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                	... 14 more
                                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.multitalk.b.d, state: GENERATED_AND_UNLOADED
                                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                	... 20 more
                                                                */
                                                            /*
                                                            // Method dump skipped, instructions count: 299
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass1.AnonymousClass1.run():void");
                                                        }
                                                    });
                                                    AppMethodBeat.o(239137);
                                                    return "";
                                                }

                                                private static acx bN(byte[] bArr) {
                                                    AppMethodBeat.i(239136);
                                                    acx acx = new acx();
                                                    try {
                                                        acx.parseFrom(bArr);
                                                        AppMethodBeat.o(239136);
                                                        return acx;
                                                    } catch (IOException e2) {
                                                        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e2, "hy: unable to parse from data", new Object[0]);
                                                        AppMethodBeat.o(239136);
                                                        return null;
                                                    }
                                                }

                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final boolean czb() {
                                                    return false;
                                                }

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                                    return new byte[0];
                                                }
                                            };
                                            p.this.zIp = new l.a<String, String>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass2 */

                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final boolean czb() {
                                                    return false;
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ String l(final int i2, String str) {
                                                    AppMethodBeat.i(239140);
                                                    p.this.aj(new Runnable() {
                                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                                        public final void run() {
                                                            AppMethodBeat.i(239139);
                                                            p.h(p.this);
                                                            p.a(p.this, AnonymousClass9.this.zJv, -10086, -5, "join room callback failed: " + i2);
                                                            AppMethodBeat.o(239139);
                                                        }
                                                    });
                                                    AppMethodBeat.o(239140);
                                                    return "";
                                                }

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                                    return new byte[0];
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                                    return "";
                                                }
                                            };
                                            p.this.zIm = new l.a<acs, String>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass3 */

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ acs bf(byte[] bArr) {
                                                    AppMethodBeat.i(239145);
                                                    acs bi = bi(bArr);
                                                    AppMethodBeat.o(239145);
                                                    return bi;
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ String l(int i2, acs acs) {
                                                    AppMethodBeat.i(239144);
                                                    final acs acs2 = acs;
                                                    p.this.aj(new Runnable() {
                                                        /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass3.AnonymousClass1 */

                                                        public final void run() {
                                                            AppMethodBeat.i(239142);
                                                            p.this.qtO = true;
                                                            p.this.zHV.a(acs2);
                                                            p.this.zHV.init();
                                                            p.b(p.this, new b<ArrayList<j>>() {
                                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                                                @Override // com.tencent.mm.plugin.multitalk.b.b
                                                                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<j> arrayList) {
                                                                    AppMethodBeat.i(239141);
                                                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: talk success! tryTriggerInviteSucc %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                                    if (i2 == 0 && i3 == 0) {
                                                                        p.this.zIF.b(p.this.zHs);
                                                                        AppMethodBeat.o(239141);
                                                                        return;
                                                                    }
                                                                    Log.e("MicroMsg.Multitalk.ILinkService", "steve: invite failed errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                                                    AppMethodBeat.o(239141);
                                                                }
                                                            });
                                                            AppMethodBeat.o(239142);
                                                        }
                                                    });
                                                    AppMethodBeat.o(239144);
                                                    return "";
                                                }

                                                private static acs bi(byte[] bArr) {
                                                    AppMethodBeat.i(239143);
                                                    acs acs = new acs();
                                                    try {
                                                        acs.parseFrom(bArr);
                                                        AppMethodBeat.o(239143);
                                                        return acs;
                                                    } catch (IOException e2) {
                                                        Log.printErrStackTrace("MicroMsg.Multitalk.ILinkService", e2, "hy: unable to parse from data", new Object[0]);
                                                        AppMethodBeat.o(239143);
                                                        return null;
                                                    }
                                                }

                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final boolean czb() {
                                                    return false;
                                                }

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                                    return new byte[0];
                                                }
                                            };
                                            p.this.zIn = new l.a<String, String>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass4 */

                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final boolean czb() {
                                                    return false;
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ String l(int i2, String str) {
                                                    AppMethodBeat.i(239146);
                                                    p.h(p.this);
                                                    p.a(p.this, AnonymousClass9.this.zJv, -10086, -6, "join room talk callback failed: ".concat(String.valueOf(i2)));
                                                    AppMethodBeat.o(239146);
                                                    return "";
                                                }

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                                    return new byte[0];
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                                    return "";
                                                }
                                            };
                                            p.this.zIs = new l.a<String, String>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass5 */

                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final boolean czb() {
                                                    return false;
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* synthetic */ String l(int i2, String str) {
                                                    AppMethodBeat.i(239147);
                                                    Log.i("MicroMsg.Multitalk.ILinkService", "accept call timeout");
                                                    p.this.zIF.d(p.this.zHs);
                                                    AppMethodBeat.o(239147);
                                                    return "";
                                                }

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ byte[] db(String str) {
                                                    return new byte[0];
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // com.tencent.mm.plugin.multitalk.b.l.a
                                                public final /* bridge */ /* synthetic */ String bf(byte[] bArr) {
                                                    return "";
                                                }
                                            };
                                            p.this.zHU.a(5, p.this.zIo);
                                            p.this.zHU.a(6, p.this.zIp);
                                            p.this.zHU.a(22, p.this.zIm);
                                            p.this.zHU.a(23, p.this.zIn);
                                            p.this.zHU.a(7, p.this.zIs);
                                            p.h(p.this);
                                            p.this.zHs.qsr.clear();
                                            p.l(p.this);
                                            p.this.elV();
                                            p.this.elU();
                                            int i2 = p.this.qtm;
                                            String unused = p.this.zII;
                                            int a2 = m.a(linkedList2, i2, p.this.zIK);
                                            if (a2 != 0) {
                                                p.a(p.this, AnonymousClass9.this.zJv, -10086, -4, "join room sdk failed: ".concat(String.valueOf(a2)));
                                                AppMethodBeat.o(239149);
                                                return;
                                            }
                                            p.this.qtM = true;
                                            p.b(p.this, new b<ArrayList<j>>() {
                                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass9.AnonymousClass1.AnonymousClass6 */

                                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                                @Override // com.tencent.mm.plugin.multitalk.b.b
                                                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<j> arrayList) {
                                                    AppMethodBeat.i(239148);
                                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: invite success, tryTriggerInviteSucc %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                    if (i2 == 0 && i3 == 0) {
                                                        p.this.zIF.b(p.this.zHs);
                                                        AppMethodBeat.o(239148);
                                                        return;
                                                    }
                                                    Log.e("MicroMsg.Multitalk.ILinkService", "steve: invite failed errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                                    AppMethodBeat.o(239148);
                                                }
                                            });
                                            AppMethodBeat.o(239149);
                                            return;
                                        }
                                        Log.e("MicroMsg.Multitalk.ILinkService", "hy: getroomId fail, errType:" + i2 + ",errCode:" + i3);
                                        p.a(p.this, AnonymousClass9.this.zJv, -10088, -10, String.format("invite failed.  errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str));
                                        AppMethodBeat.o(239149);
                                    }
                                });
                                AppMethodBeat.o(239150);
                            }
                        });
                        AppMethodBeat.o(239279);
                    }

                    static /* synthetic */ boolean elX() {
                        boolean z;
                        AppMethodBeat.i(239285);
                        TelephonyManager telephonyManager = (TelephonyManager) MMApplicationContext.getContext().getSystemService("phone");
                        Bundle bundle = (Bundle) h.a("com.tencent.mm", null, d.class);
                        if (bundle != null) {
                            z = bundle.getBoolean("is_in_voip");
                        } else {
                            z = false;
                        }
                        boolean z2 = z || e.bgH() || (com.tencent.mm.q.a.atu() && telephonyManager.getCallState() != 0);
                        Log.i("MicroMsg.Multitalk.ILinkService", "steve: isOnOtherCalling:%b,%b,%b,%b,%d", Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(e.bgH()), Boolean.valueOf(com.tencent.mm.q.a.atu()), Integer.valueOf(telephonyManager.getCallState()));
                        AppMethodBeat.o(239285);
                        return z2;
                    }

                    static /* synthetic */ void b(p pVar, int i2) {
                        AppMethodBeat.i(239292);
                        ArrayList<j> elF = pVar.zHs.elF();
                        LinkedList<esd> linkedList = new LinkedList<>();
                        Log.i("MicroMsg.Multitalk.ILinkService", "send banner msg for wxgroupid %s sdkgroupid %s roomid %d seq %d bannerstatus %d", pVar.zHs.zHD, pVar.zHs.zHJ, Long.valueOf(pVar.zHs.zHB), Long.valueOf(pVar.zHs.zHI), Integer.valueOf(i2));
                        Iterator<j> it = elF.iterator();
                        while (it.hasNext()) {
                            j next = it.next();
                            esd esd = new esd();
                            esc esc = new esc();
                            esc.username = next.goe;
                            esc.Npd = next.openId;
                            esd.Npo = esc;
                            esd.status = next.mStatus;
                            linkedList.add(esd);
                            Log.i("MicroMsg.Multitalk.ILinkService", "sendBannerMsg:username %s, openid %s, status %d", next.goe, next.openId, Integer.valueOf(next.mStatus));
                        }
                        eri eri = new eri();
                        eri.NoW = pVar.zHs.zHD;
                        eri.Lnw = pVar.zHs.zHB;
                        eri.NoX = pVar.zHs.zHJ;
                        eri.NoY = linkedList;
                        eri.NoZ = pVar.zHs.zHI;
                        eri.Npa = i2;
                        eri.Npb = pVar.zHs.zHG;
                        if ((eri.NoX != null && !eri.NoX.equals("")) || eri.Npa == 0) {
                            IPCRunCgi.a(i.a(pVar.zHs.zHD, pVar.zIG, eri), new IPCRunCgi.a() {
                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass20 */

                                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                                public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                                }
                            });
                        }
                        AppMethodBeat.o(239292);
                    }

                    static /* synthetic */ void U(p pVar) {
                        AppMethodBeat.i(239293);
                        Log.i("MicroMsg.Multitalk.ILinkService", "steve:readyToTalk");
                        if (pVar.zIP == b.ILinkMemberRoleCreate && pVar.zIG.equals(pVar.zHs.zHG)) {
                            pVar.c(new b<ArrayList<j>>() {
                                /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass10 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                                @Override // com.tencent.mm.plugin.multitalk.b.b
                                public final /* synthetic */ void a(int i2, int i3, String str, ArrayList<j> arrayList) {
                                    AppMethodBeat.i(239151);
                                    Log.i("MicroMsg.Multitalk.ILinkService", "steve: talk success! tryTriggerInviteSucc %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                    if (i2 == 0 && i3 == 0) {
                                        p.this.zIF.b(p.this.zHs);
                                        AppMethodBeat.o(239151);
                                        return;
                                    }
                                    Log.e("MicroMsg.Multitalk.ILinkService", "steve: trigger invite  failed errtype %d errcode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                                    AppMethodBeat.o(239151);
                                }
                            });
                        }
                        pVar.aj(new Runnable() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass11 */

                            public final void run() {
                                AppMethodBeat.i(239152);
                                d dVar = p.this.zIF;
                                if (dVar.zHj != null) {
                                    dVar.zHj.enE();
                                }
                                AppMethodBeat.o(239152);
                            }
                        });
                        AppMethodBeat.o(239293);
                    }

                    static /* synthetic */ void X(p pVar) {
                        AppMethodBeat.i(239294);
                        String str = "," + pVar.zHs.zHD + "," + pVar.zHs.zHJ + "," + pVar.zHs.zHB + "," + pVar.zHs.zHC + "," + pVar.qtM + "," + pVar.qtN + "," + pVar.qtO + "," + pVar.zHY;
                        Log.i("MicroMsg.Multitalk.ILinkService", "do svr report logid20434: %s", str);
                        erx erx = new erx();
                        erx.KAy = 20434;
                        erx.Npp = str;
                        LinkedList<erx> linkedList = new LinkedList<>();
                        linkedList.add(erx);
                        String str2 = pVar.zHs.zHD;
                        String str3 = pVar.zHs.zHJ;
                        String str4 = pVar.zIG;
                        d.a aVar = new d.a();
                        aVar.iLN = new ery();
                        aVar.iLO = new erz();
                        aVar.funcId = 4237;
                        aVar.uri = "/cgi-bin/micromsg-bin/voipmtreportlog";
                        aVar.iLP = 0;
                        aVar.respCmdId = 0;
                        com.tencent.mm.ak.d aXF = aVar.aXF();
                        ery ery = (ery) aXF.iLK.iLR;
                        esc esc = new esc();
                        esc.username = str4;
                        esc.Npd = null;
                        ery.Npm = esc;
                        ery.NoW = str2;
                        ery.NoX = str3;
                        ery.Npq = linkedList;
                        IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                            /* class com.tencent.mm.plugin.multitalk.b.p.AnonymousClass19 */

                            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                            public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                                AppMethodBeat.i(239176);
                                if (!(i2 == 0 && i3 == 0 && dVar.iLL.iLR != null)) {
                                    Log.e("MicroMsg.Multitalk.ILinkService", "hy: cgiReportLog fail, errType:" + i2 + ",errCode:" + i3);
                                }
                                AppMethodBeat.o(239176);
                            }
                        });
                        AppMethodBeat.o(239294);
                    }
                }
