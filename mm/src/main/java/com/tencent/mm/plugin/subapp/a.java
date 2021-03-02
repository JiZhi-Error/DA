package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.api.k;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.subapp.e.c;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Map;

public final class a implements bd {
    static cu FIt;
    private Map<String, bd> FIu = new HashMap();
    private C1788a FIv;
    private com.tencent.mm.plugin.subapp.e.a FIw;
    private c FIx;
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.subapp.a.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(28832);
            if (d.JYo != null) {
                com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
                com.tencent.mm.plugin.subapp.jdbiz.d.fsX();
            }
            AppMethodBeat.o(28832);
        }
    };

    public a() {
        AppMethodBeat.i(28847);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        hashMap.put(com.tencent.mm.at.d.class.getName(), new com.tencent.mm.at.d());
        hashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        com.tencent.mm.plugin.subapp.d.d dVar = new com.tencent.mm.plugin.subapp.d.d();
        ay.a.iDt = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), dVar);
        com.tencent.mm.plugin.subapp.jdbiz.d dVar2 = new com.tencent.mm.plugin.subapp.jdbiz.d();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), dVar2);
        d.JYo = dVar2;
        this.FIu = hashMap;
        AppMethodBeat.o(28847);
    }

    @Override // com.tencent.mm.model.bd
    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        AppMethodBeat.i(28848);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        for (Map.Entry<String, bd> entry : this.FIu.entrySet()) {
            if (entry.getValue().getBaseDBFactories() != null) {
                hashMap.putAll(entry.getValue().getBaseDBFactories());
            }
        }
        AppMethodBeat.o(28848);
        return hashMap;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
        AppMethodBeat.i(28849);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Map.Entry<String, bd> entry : this.FIu.entrySet()) {
            entry.getValue().clearPluginData(i2);
        }
        AppMethodBeat.o(28849);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28850);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Map.Entry<String, bd> entry : this.FIu.entrySet()) {
            entry.getValue().onAccountPostReset(z);
        }
        if (this.FIv == null) {
            this.FIv = new C1788a();
        }
        if (this.FIw == null) {
            this.FIw = new com.tencent.mm.plugin.subapp.e.a();
        }
        if (this.FIx == null) {
            this.FIx = new c();
        }
        EventCenter.instance.addListener(this.FIv);
        EventCenter.instance.addListener(this.FIx);
        EventCenter.instance.addListener(this.FIw);
        this.appForegroundListener.alive();
        AppMethodBeat.o(28850);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(28851);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Map.Entry<String, bd> entry : this.FIu.entrySet()) {
            entry.getValue().onSdcardMount(z);
        }
        AppMethodBeat.o(28851);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(28852);
        Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        this.appForegroundListener.dead();
        for (Map.Entry<String, bd> entry : this.FIu.entrySet()) {
            entry.getValue().onAccountRelease();
        }
        if (this.FIv != null) {
            EventCenter.instance.removeListener(this.FIv);
        }
        if (this.FIw != null) {
            EventCenter.instance.removeListener(this.FIw);
        }
        if (this.FIx != null) {
            EventCenter.instance.removeListener(this.FIx);
        }
        AppMethodBeat.o(28852);
    }

    public final bd aSI(String str) {
        AppMethodBeat.i(28853);
        bd bdVar = this.FIu.get(str);
        AppMethodBeat.o(28853);
        return bdVar;
    }

    public final void b(String str, bd bdVar) {
        AppMethodBeat.i(28854);
        this.FIu.put(str, bdVar);
        AppMethodBeat.o(28854);
    }

    /* renamed from: com.tencent.mm.plugin.subapp.a$a  reason: collision with other inner class name */
    public static class C1788a extends IListener<gf> implements i {
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.a FIA;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.c FIB;
        private b FIC;
        private r FID;
        private int FIE;
        private volatile boolean FIF = false;
        private boolean FIG = false;
        private MTimerHandler FIH;
        private gf FII;
        private int FIJ;
        private Map<String, String> FIK = new HashMap();
        private int FIL;
        private boolean FIM = true;
        private long FIN = 0;
        private long FIO;
        private int dKi;
        private int dKj;
        private String dRL;
        private boolean hkH = false;
        private boolean lic;
        private String toUser;

        static /* synthetic */ void a(C1788a aVar, EnumC1790a aVar2) {
            AppMethodBeat.i(232065);
            aVar.a(aVar2);
            AppMethodBeat.o(232065);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gf gfVar) {
            AppMethodBeat.i(28846);
            boolean a2 = a(gfVar);
            AppMethodBeat.o(28846);
            return a2;
        }

        public C1788a() {
            AppMethodBeat.i(28838);
            this.__eventId = gf.class.getName().hashCode();
            AppMethodBeat.o(28838);
        }

        private boolean a(gf gfVar) {
            AppMethodBeat.i(28839);
            if (!(gfVar instanceof gf)) {
                Log.f("MicroMsg.SubCoreSubapp", "mismatched event");
                AppMethodBeat.o(28839);
                return false;
            } else if (gfVar.dJV.dJY == 2) {
                a(EnumC1790a.CANCEL);
                this.FIK.clear();
                Log.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                AppMethodBeat.o(28839);
                return true;
            } else if (gfVar.dJV.dJY == 1) {
                a(EnumC1790a.CANCEL);
                Log.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                AppMethodBeat.o(28839);
                return true;
            } else if (gfVar.dJV.dJY == 3) {
                a(EnumC1790a.CANCEL_BY_USER);
                Log.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
                AppMethodBeat.o(28839);
                return true;
            } else if (gfVar.dJV.dJY != 0) {
                Log.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.FII.dJV.dJY));
                AppMethodBeat.o(28839);
                return false;
            } else if (this.lic) {
                Log.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                AppMethodBeat.o(28839);
                return false;
            } else if (com.tencent.mm.modelvoice.o.bib() == null) {
                Log.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + Util.getStack());
                AppMethodBeat.o(28839);
                return false;
            } else {
                this.FII = gfVar;
                String str = this.FII.dJV.dJX;
                String str2 = this.FII.dJV.fileName;
                if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                    a(EnumC1790a.LOCAL_ERROR);
                    AppMethodBeat.o(28839);
                    return false;
                }
                fsL();
                String str3 = this.FIK.get(str2);
                if (!Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", str, str2);
                    a(str3, EnumC1790a.FINISH);
                    AppMethodBeat.o(28839);
                    return true;
                }
                cu bkZ = com.tencent.mm.modelvoice.o.bic().bkZ(str2);
                a.FIt = bkZ;
                if (bkZ == null || Util.isNullOrNil(a.FIt.field_content)) {
                    Log.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", Integer.valueOf(gfVar.dJV.scene));
                    this.FID = com.tencent.mm.modelvoice.o.bib().Rr(str2);
                    try {
                        if (this.FID == null) {
                            Log.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                            this.FID = new r();
                            this.FID.fileName = str2;
                            this.FID.createTime = System.currentTimeMillis() / 1000;
                            this.FID.clientId = str2;
                            this.FID.jsm = System.currentTimeMillis() / 1000;
                            this.FID.status = 1;
                            if (gfVar.dJV.scene == 8) {
                                this.FID.jso = -1;
                            } else {
                                this.FID.jso = Integer.valueOf(str).intValue();
                            }
                            int Qy = q.Qy(str2);
                            Log.i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(Qy));
                            this.FID.iKP = Qy;
                        }
                        if (this.FID.jso < 0) {
                            Log.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                        } else {
                            ca Hb = ((l) g.af(l.class)).eiy().Hb((long) this.FID.jso);
                            if (Hb.field_isSend == 1) {
                                this.dRL = z.aTY();
                                if (this.FII.dJV.scene == 4 || this.FII.dJV.scene == 5) {
                                    com.tencent.mm.al.a.c bs = ((k) g.af(k.class)).bs(Hb.field_bizChatId);
                                    if (bs != null) {
                                        this.toUser = bs.field_bizChatServId;
                                    } else {
                                        this.toUser = "";
                                    }
                                } else {
                                    this.toUser = Hb.field_talker;
                                }
                            } else if (Hb.field_isSend == 0) {
                                this.toUser = z.aTY();
                                if (this.FII.dJV.scene == 4 || this.FII.dJV.scene == 5) {
                                    com.tencent.mm.al.a.c bs2 = ((k) g.af(k.class)).bs(Hb.field_bizChatId);
                                    if (bs2 != null) {
                                        this.dRL = bs2.field_bizChatServId;
                                    } else {
                                        this.dRL = "";
                                    }
                                } else {
                                    this.dRL = Hb.field_talker;
                                }
                            }
                        }
                        this.FIL = this.FII.dJV.scene;
                        Log.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", this.dRL, this.toUser, Integer.valueOf(this.FIL));
                        com.tencent.mm.modelvoice.b bVar = null;
                        try {
                            com.tencent.mm.modelvoice.b Rf = s.Rf(this.FID.fileName);
                            this.FIE = Rf != null ? Rf.getFormat() : -1;
                            if (Rf != null) {
                                try {
                                    Rf.bhP();
                                } catch (Throwable th) {
                                }
                            }
                        } catch (Throwable th2) {
                        }
                        this.lic = true;
                        this.FIJ = 20;
                        a(EnumC1790a.CHECK);
                        AppMethodBeat.o(28839);
                        return true;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreSubapp", e2, "alvinluo set voiceInfo exception", new Object[0]);
                        a(EnumC1790a.LOCAL_ERROR);
                        AppMethodBeat.o(28839);
                        return true;
                    }
                } else {
                    Log.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", str, str2);
                    a(a.FIt.field_content, EnumC1790a.FINISH);
                    AppMethodBeat.o(28839);
                    return true;
                }
            }
        }

        private void fsL() {
            this.FIM = true;
            this.FIN = 0;
            this.FIO = 0;
            this.dKi = 0;
            this.dKj = 0;
            this.hkH = false;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        private void a(EnumC1790a aVar) {
            AppMethodBeat.i(28840);
            switch (aVar) {
                case CHECK:
                    Log.i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.FID.dTS > 0) {
                        Log.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.FID.dTS));
                        this.FIA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.FID.clientId, this.FID.iKP, this.FIE, this.FID.dTS, this.FID.fileName, this.FIL, this.dRL, this.toUser);
                    } else {
                        Log.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.FID.dTS));
                        this.FIA = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.FID.clientId, this.FID.iKP, this.FID.fileName, this.FIL, this.dRL, this.toUser);
                    }
                    bg.azz().a(this.FIA, 0);
                    bg.azz().a(this.FIA.getType(), this);
                    this.FIO = System.currentTimeMillis();
                    AppMethodBeat.o(28840);
                    return;
                case UPLOAD:
                    Log.i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.FIA == null) {
                        Log.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        AppMethodBeat.o(28840);
                        return;
                    }
                    this.FIB = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.FID.clientId, this.FIA.FNI, this.FIE, this.FID.fileName, this.FIL, this.dRL, this.toUser);
                    bg.azz().a(this.FIB, 0);
                    bg.azz().a(this.FIB.getType(), this);
                    AppMethodBeat.o(28840);
                    return;
                case UPLOAD_MORE:
                    Log.i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.FIB == null) {
                        Log.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        AppMethodBeat.o(28840);
                        return;
                    }
                    this.FIB = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.FIB);
                    bg.azz().a(this.FIB, 0);
                    bg.azz().a(this.FIB.getType(), this);
                    AppMethodBeat.o(28840);
                    return;
                case GET:
                    if (this.FIF) {
                        Log.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        AppMethodBeat.o(28840);
                        return;
                    }
                    Log.i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.FIA == null) {
                        Log.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                        AppMethodBeat.o(28840);
                        return;
                    }
                    this.FIF = true;
                    this.FIC = new b(this.FID.clientId);
                    bg.azz().a(this.FIC, 0);
                    bg.azz().a(this.FIC.getType(), this);
                    AppMethodBeat.o(28840);
                    return;
                case FINISH:
                    this.FIG = true;
                    AppMethodBeat.o(28840);
                    return;
                case CANCEL:
                    bg.azz().a(this.FIA);
                    bg.azz().a(this.FIB);
                    bg.azz().a(this.FIC);
                    this.hkH = true;
                    a((String) null, EnumC1790a.CANCEL);
                    AppMethodBeat.o(28840);
                    return;
                case LOCAL_ERROR:
                case SERVER_ERROR:
                    this.hkH = true;
                    a((String) null, aVar);
                    AppMethodBeat.o(28840);
                    return;
                case NETWORK_OVERTIME:
                    this.hkH = true;
                    a((String) null, aVar);
                    break;
            }
            AppMethodBeat.o(28840);
        }

        private void fsM() {
            AppMethodBeat.i(28841);
            if (this.FIM) {
                this.FIM = false;
                this.FIN = System.currentTimeMillis();
                this.dKi = (int) (this.FIN - this.FIO);
            }
            AppMethodBeat.o(28841);
        }

        private void a(String str, EnumC1790a aVar) {
            AppMethodBeat.i(28842);
            Log.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", aVar);
            if (this.FIH != null) {
                this.FIH.stopTimer();
            }
            bg.azz().b(546, this);
            bg.azz().b(547, this);
            bg.azz().b(548, this);
            if (this.FII != null) {
                if (!Util.isNullOrNil(str)) {
                    this.FIK.put(this.FII.dJV.fileName, str);
                    if ((a.FIt == null || Util.isNullOrNil(a.FIt.field_content)) && this.FII.dJV.from == 1) {
                        com.tencent.mm.modelvoice.o.bic().a(aSJ(str));
                    }
                } else if (aVar == EnumC1790a.FINISH) {
                    Log.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", this.FII.dJV.dJX);
                    this.FII.dJW.state = 2;
                }
                this.FII.dJW.brW = true;
                this.FII.dJW.content = str;
                if (aVar == EnumC1790a.CANCEL) {
                    this.FII.dJW.state = 1;
                } else if (aVar == EnumC1790a.LOCAL_ERROR || aVar == EnumC1790a.SERVER_ERROR) {
                    this.FII.dJW.state = 2;
                }
                Log.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", str);
                if (this.FII.dJV.dJZ != null) {
                    this.FII.dJV.dJZ.run();
                }
            }
            b(str, aVar);
            this.FIA = null;
            this.FIB = null;
            this.FIC = null;
            this.FII = null;
            this.lic = false;
            this.FIG = false;
            this.FIF = false;
            this.FIJ = 20;
            a.FIt = null;
            fsL();
            AppMethodBeat.o(28842);
        }

        private void b(String str, EnumC1790a aVar) {
            int i2;
            AppMethodBeat.i(28843);
            if (!this.hkH) {
                AppMethodBeat.o(28843);
            } else if (this.FID == null) {
                AppMethodBeat.o(28843);
            } else {
                int length = str != null ? str.length() : 0;
                if (aVar != EnumC1790a.FINISH) {
                    this.dKi = 0;
                    this.dKj = 0;
                    if (aVar == EnumC1790a.CANCEL) {
                        i2 = 5;
                        length = 0;
                    } else if (aVar == EnumC1790a.SERVER_ERROR) {
                        length = 0;
                        i2 = 3;
                    } else if (aVar == EnumC1790a.LOCAL_ERROR) {
                        i2 = 4;
                        length = 0;
                    } else if (aVar == EnumC1790a.NETWORK_OVERTIME) {
                        length = 0;
                        i2 = 2;
                    } else {
                        length = 0;
                        i2 = 0;
                    }
                } else if (!Util.isNullOrNil(str)) {
                    i2 = 1;
                } else {
                    this.dKi = 0;
                    this.dKj = 0;
                    length = 0;
                    i2 = 3;
                }
                Log.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", this.FID.clientId, Integer.valueOf(length), Integer.valueOf(this.dKi), Integer.valueOf(this.dKj), Integer.valueOf(i2));
                if (i2 != 0) {
                    com.tencent.mm.plugin.subapp.e.b.d(this.FID.clientId, length, this.dKi, this.dKj, i2);
                }
                AppMethodBeat.o(28843);
            }
        }

        private cu aSJ(String str) {
            AppMethodBeat.i(28844);
            Log.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", this.FII.dJV.dJX, this.FII.dJV.fileName);
            cu cuVar = new cu();
            cuVar.field_msgId = Long.valueOf(this.FII.dJV.dJX).longValue();
            cuVar.bkY(this.FII.dJV.fileName);
            cuVar.field_content = str;
            AppMethodBeat.o(28844);
            return cuVar;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            String str2 = null;
            AppMethodBeat.i(28845);
            Log.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                switch (qVar.getType()) {
                    case 546:
                        if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNG) {
                            Log.i("MicroMsg.SubCoreSubapp", "check result: done");
                            a(EnumC1790a.FINISH);
                            fsM();
                            this.dKj = 0;
                            this.hkH = true;
                            if (this.FIA.ftu()) {
                                str2 = this.FIA.FNH.NpE;
                            }
                            a(str2, EnumC1790a.FINISH);
                            AppMethodBeat.o(28845);
                            return;
                        } else if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNF) {
                            if (this.FIA.FNH != null) {
                                Util.isNullOrNil(this.FIA.FNH.NpE);
                            }
                            Log.i("MicroMsg.SubCoreSubapp", "check result: processing");
                            a(EnumC1790a.GET);
                            AppMethodBeat.o(28845);
                            return;
                        } else if (this.FIA.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.FNE) {
                            Log.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            a(EnumC1790a.UPLOAD);
                            AppMethodBeat.o(28845);
                            return;
                        } else if (this.FIA.FNJ != null) {
                            AppMethodBeat.o(28845);
                            return;
                        }
                        break;
                    case 547:
                        if (this.FIB.ftw()) {
                            Log.i("MicroMsg.SubCoreSubapp", "succeed upload");
                            a(EnumC1790a.GET);
                            AppMethodBeat.o(28845);
                            return;
                        }
                        Log.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.FIB.FNI.BsG), Integer.valueOf(this.FIB.FNI.BsH));
                        a(EnumC1790a.UPLOAD_MORE);
                        AppMethodBeat.o(28845);
                        return;
                    case 548:
                        final int i4 = this.FIC.FNL;
                        Log.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", Integer.valueOf(i4));
                        this.FIF = false;
                        fsM();
                        if (!this.FIC.isComplete() && this.FIC.ftu()) {
                            Log.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                            String str3 = this.FIC.FNH.NpE;
                            if (this.FII != null) {
                                this.FII.dJW.brW = false;
                                this.FII.dJW.content = str3;
                                Log.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", Boolean.valueOf(Util.isNullOrNil(str3)));
                                if (this.FII.dJV.dJZ != null) {
                                    this.FII.dJV.dJZ.run();
                                }
                            }
                        } else if (!this.FIC.ftu()) {
                            Log.d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.FIC.isComplete()) {
                            Log.i("MicroMsg.SubCoreSubapp", "succeed get");
                            if (this.FIC.ftu()) {
                                str2 = this.FIC.FNH.NpE;
                            }
                            a(EnumC1790a.FINISH);
                            this.dKj = (int) (System.currentTimeMillis() - this.FIN);
                            this.hkH = true;
                            a(str2, EnumC1790a.FINISH);
                            AppMethodBeat.o(28845);
                            return;
                        }
                        Log.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i4));
                        if (!this.FIG) {
                            int i5 = this.FIJ - 1;
                            this.FIJ = i5;
                            if (i5 < 0) {
                                Log.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", 20);
                                a(EnumC1790a.SERVER_ERROR);
                                AppMethodBeat.o(28845);
                                return;
                            }
                            if (this.FIH == null) {
                                this.FIH = new MTimerHandler(new MTimerHandler.CallBack() {
                                    /* class com.tencent.mm.plugin.subapp.a.C1788a.AnonymousClass1 */

                                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                                    public final boolean onTimerExpired() {
                                        AppMethodBeat.i(28834);
                                        if (C1788a.this.FIG) {
                                            AppMethodBeat.o(28834);
                                        } else {
                                            Log.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i4));
                                            C1788a.a(C1788a.this, EnumC1790a.GET);
                                            AppMethodBeat.o(28834);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            this.FIH.startTimer((long) (i4 * 1000));
                        }
                        AppMethodBeat.o(28845);
                        return;
                    default:
                        AppMethodBeat.o(28845);
                        return;
                }
            } else if (i2 == 2) {
                a(EnumC1790a.NETWORK_OVERTIME);
                AppMethodBeat.o(28845);
                return;
            } else {
                a(EnumC1790a.SERVER_ERROR);
            }
            AppMethodBeat.o(28845);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.subapp.a$a$a  reason: collision with other inner class name */
        public enum EnumC1790a {
            CHECK,
            UPLOAD,
            UPLOAD_MORE,
            GET,
            FINISH,
            ERROR,
            CANCEL,
            CANCEL_BY_USER,
            LOCAL_ERROR,
            SERVER_ERROR,
            NETWORK_OVERTIME;

            public static EnumC1790a valueOf(String str) {
                AppMethodBeat.i(28836);
                EnumC1790a aVar = (EnumC1790a) Enum.valueOf(EnumC1790a.class, str);
                AppMethodBeat.o(28836);
                return aVar;
            }

            static {
                AppMethodBeat.i(28837);
                AppMethodBeat.o(28837);
            }
        }
    }
}
