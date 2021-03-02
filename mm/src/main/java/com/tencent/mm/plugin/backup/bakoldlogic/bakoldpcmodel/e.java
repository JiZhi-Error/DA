package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.ur;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.d.a;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.plugin.backup.bakoldlogic.d.d;
import com.tencent.mm.plugin.backup.c.e;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.plugin.backup.i.q;
import com.tencent.mm.plugin.backup.i.r;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class e implements b.d {
    private d oRA;
    public c oRI;
    public a oRJ;
    public AbstractC0839e oRK;
    public d oRL = new d();
    public f oRM = new f();
    com.tencent.mm.plugin.backup.bakoldlogic.c.e oRN;
    private com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a oRO;
    public int oRP = -1;
    public String oRQ;
    public String oRR;
    public int oRS = -1;
    public int oRT = 1;
    private boolean oRU = false;

    public interface a extends b {
        void chm();
    }

    public interface b {
        void onError(int i2);
    }

    public interface c extends b {
        void Bx(int i2);

        void onEvent(int i2);
    }

    public interface d extends b {
        void By(int i2);

        void Bz(int i2);

        void ceL();

        void chn();

        void cho();
    }

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e$e  reason: collision with other inner class name */
    public interface AbstractC0839e extends b {
        void chp();
    }

    public e() {
        AppMethodBeat.i(21900);
        AppMethodBeat.o(21900);
    }

    public final void eR(String str, String str2) {
        this.oRQ = str;
        this.oRR = str2;
    }

    public final synchronized void jH(boolean z) {
        this.oRU = z;
    }

    public final synchronized boolean chh() {
        return this.oRU;
    }

    public final synchronized void chi() {
        this.oRA = null;
        this.oRL.oRA = null;
        this.oRM.oRA = null;
    }

    public final synchronized void a(d dVar) {
        AppMethodBeat.i(21901);
        if (dVar != null || !(this.oRA instanceof com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a)) {
            Log.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", dVar);
            this.oRA = dVar;
            this.oRL.oRA = dVar;
            this.oRM.oRA = dVar;
            AppMethodBeat.o(21901);
        } else {
            Log.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            AppMethodBeat.o(21901);
        }
    }

    public final void cgk() {
        AppMethodBeat.i(21902);
        if (this.oRM.oSd) {
            f fVar = this.oRM;
            Log.i("MicroMsg.RecoverPCServer", "startMerge");
            if (fVar.oKz) {
                Log.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                AppMethodBeat.o(21902);
                return;
            }
            fVar.oRG = 0;
            a.cgZ().cha().oRT = 6;
            fVar.oKz = true;
            com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().a(new b.a() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.backup.bakoldlogic.d.b.a
                public final void run() {
                    AppMethodBeat.i(21922);
                    f fVar = f.this;
                    int ca = f.ca(fVar.oSa);
                    Log.i("MicroMsg.RecoverPCServer", "all msg item Count : ".concat(String.valueOf(ca)));
                    Log.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
                    h.RTc.ba(new com.tencent.f.i.h(ca) {
                        /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass5 */
                        final /* synthetic */ int oSj;

                        {
                            this.oSj = r2;
                        }

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "RecoverPCServer_recoverFromSdcard";
                        }

                        public final void run() {
                            Exception e2;
                            int i2;
                            AppMethodBeat.i(21924);
                            e.reset();
                            e.cfp();
                            c cVar = new c();
                            cVar.begin();
                            HashMap<String, Integer> hashMap = new HashMap<>();
                            HashSet<String> hashSet = new HashSet<>();
                            int i3 = 0;
                            for (t tVar : f.this.oSa) {
                                try {
                                    int a2 = f.this.a(a.cgW() + "backupItem/" + a.agK(tVar.ID) + tVar.ID, hashMap, cVar, hashSet);
                                    if (a2 < 0) {
                                        cVar.end();
                                        Log.w("MicroMsg.RecoverPCServer", "Thread has been canceled");
                                        AppMethodBeat.o(21924);
                                        return;
                                    }
                                    i2 = a2 + i3;
                                    try {
                                        f.this.eT(i2, this.oSj);
                                        Log.i("MicroMsg.RecoverPCServer", "recover has done: %d", Integer.valueOf(i2));
                                        i3 = i2;
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        Log.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e2.toString());
                                        Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                                        Log.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e2.toString());
                                        i3 = i2;
                                    }
                                } catch (Exception e4) {
                                    e2 = e4;
                                    i2 = i3;
                                    Log.e("MicroMsg.RecoverPCServer", "Thread.run err:" + e2.toString());
                                    Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                                    Log.f("MicroMsg.RecoverPCServer", "recoverFromSdcard MMThread.run() " + e2.toString());
                                    i3 = i2;
                                }
                            }
                            d.h(hashMap);
                            cVar.end();
                            f.this.eT(100, 100);
                            Log.i("MicroMsg.RecoverPCServer", "build temDB finish!");
                            Log.appenderFlush();
                            com.tencent.mm.plugin.backup.bakoldlogic.d.b chw = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw();
                            chw.a(new Runnable(new Runnable() {
                                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(21923);
                                    Log.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
                                    Log.appenderFlush();
                                    a.cgZ().cha().oRT = 7;
                                    f.this.oSc = 0;
                                    if (f.this.oRA != null) {
                                        f.this.oRA.ceL();
                                    } else {
                                        Log.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                                    }
                                    e.chl();
                                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(8).cgA();
                                    Log.i("MicroMsg.RecoverPCServer", "recover ok");
                                    bg.aVF();
                                    com.tencent.mm.model.c.azQ().set(ar.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.TRUE);
                                    a.cgZ().chb().oRw++;
                                    a.cgZ().cha().oRS = 7;
                                    f.this.cancel();
                                    com.tencent.mm.plugin.backup.bakoldlogic.d.a chy = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chy();
                                    StringBuffer stringBuffer = new StringBuffer();
                                    Iterator<a.C0840a> it = chy.oQt.iterator();
                                    while (it.hasNext()) {
                                        a.C0840a next = it.next();
                                        if (next.type == 2 && next.obj != null && (next.obj instanceof String)) {
                                            stringBuffer.append(next.type + " : " + ((String) next.obj) + " ,");
                                        } else if (next.type == 1 && next.obj != null && (next.obj instanceof String)) {
                                            stringBuffer.append(next.type + " : " + ((String) next.obj) + " ,");
                                        }
                                    }
                                    Log.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
                                    AppMethodBeat.o(21923);
                                }
                            }) {
                                /* class com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass2 */
                                final /* synthetic */ Runnable oTa;

                                {
                                    this.oTa = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(22065);
                                    Log.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb closeTempDB ok");
                                    Log.appenderFlush();
                                    bg.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                                        /* class com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass2.AnonymousClass1 */

                                        @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                                        public final boolean onPostExecute() {
                                            AppMethodBeat.i(22062);
                                            Log.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
                                            AnonymousClass2.this.oTa.run();
                                            EventCenter.instance.publish(new ur());
                                            AppMethodBeat.o(22062);
                                            return false;
                                        }

                                        @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                                        public final boolean doInBackground() {
                                            AppMethodBeat.i(22063);
                                            Log.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
                                            Log.appenderFlush();
                                            b.chD();
                                            s.dy(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cgW(), true);
                                            a chy = b.this.chy();
                                            chy.handler.post(new Runnable() {
                                                /* class com.tencent.mm.plugin.backup.bakoldlogic.d.a.AnonymousClass2 */

                                                public final void run() {
                                                    AppMethodBeat.i(22055);
                                                    Iterator<C0840a> it = a.this.oQt.iterator();
                                                    while (it.hasNext()) {
                                                        C0840a next = it.next();
                                                        if (next.type == 2 && next.obj != null && (next.obj instanceof String)) {
                                                            String str = (String) next.obj;
                                                            Log.d("MicroMsg.BakOldRecoverDelayData", "getContact:".concat(String.valueOf(str)));
                                                            ay.a.iDq.aL(str, "");
                                                        } else if (next.type == 1 && next.obj != null && (next.obj instanceof String)) {
                                                            ao.eAR().bdF((String) next.obj);
                                                        }
                                                    }
                                                    a.this.oQt.clear();
                                                    AppMethodBeat.o(22055);
                                                }
                                            });
                                            Log.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
                                            Log.appenderFlush();
                                            AppMethodBeat.o(22063);
                                            return true;
                                        }

                                        public final String toString() {
                                            AppMethodBeat.i(22064);
                                            String str = super.toString() + "|bakoldRecoverFromTempDb";
                                            AppMethodBeat.o(22064);
                                            return str;
                                        }
                                    });
                                    AppMethodBeat.o(22065);
                                }
                            }, 10);
                            AppMethodBeat.o(21924);
                        }
                    });
                    AppMethodBeat.o(21922);
                }
            });
            AppMethodBeat.o(21902);
            return;
        }
        Log.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
        AppMethodBeat.o(21902);
    }

    public final void pause() {
        AppMethodBeat.i(21903);
        if (this.oRP == 1) {
            this.oRL.pause();
            AppMethodBeat.o(21903);
            return;
        }
        if (this.oRP == 6) {
            this.oRM.pause();
        }
        AppMethodBeat.o(21903);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void aA(int i2, String str) {
        AppMethodBeat.i(21904);
        Log.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", Integer.valueOf(i2), str);
        if (i2 == 10006 || i2 == 10008) {
            Log.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.oRS = -1;
            this.oRT = 1;
            chl();
            a.cgZ().chb().oRs = 2;
            a.cgZ().chb().aWm();
            if (this.oRI != null) {
                this.oRI.onError(i2);
            }
            if (this.oRJ != null) {
                this.oRJ.onError(i2);
            }
            if (this.oRA != null) {
                this.oRA.onError(i2);
            }
            if (this.oRK != null) {
                this.oRK.onError(i2);
            }
        }
        if (i2 == 10009 || i2 == 10004) {
            Log.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", Integer.valueOf(i2));
            a.cgZ().chb().oRs = 2;
            a.cgZ().chb().aWm();
            chj();
            AppMethodBeat.o(21904);
        } else {
            Log.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", Integer.valueOf(i2), this.oRJ, this.oRA, this.oRI);
            if (i2 == 15) {
                if (this.oRJ != null) {
                    this.oRJ.onError(i2);
                }
                if (this.oRA != null) {
                    this.oRA.onError(i2);
                }
                if (this.oRI != null) {
                    this.oRI.Bx(i2);
                }
            }
            if (i2 == -1) {
                if (this.oRJ != null) {
                    this.oRJ.onError(i2);
                    AppMethodBeat.o(21904);
                } else if (this.oRA != null) {
                    this.oRA.onError(i2);
                    AppMethodBeat.o(21904);
                } else if (this.oRI != null) {
                    this.oRI.Bx(i2);
                }
            }
            AppMethodBeat.o(21904);
        }
    }

    @Override // com.tencent.mm.plugin.backup.g.b.d
    public final void a(boolean z, int i2, byte[] bArr, int i3) {
        AppMethodBeat.i(21905);
        if (z && bArr != null) {
            aA(i2, new String(bArr));
        }
        if (i2 == 10001 || i2 == 10002) {
            a.cgZ().chb().oRs = 1;
            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.cgZ().oIV, a.cgZ().oIW, com.tencent.mm.plugin.backup.b.d.ceQ(), a.cgZ().oIU).cgA();
        }
        if (i2 == 3) {
            this.oRP = -1;
            ab abVar = new ab();
            try {
                abVar.parseFrom(bArr);
                Log.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", Integer.valueOf(abVar.oTl), Bw(abVar.oTl));
                switch (abVar.oTl) {
                    case 0:
                        if (!bg.aAc()) {
                            Log.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                            a(abVar.oTl, 1, null);
                            AppMethodBeat.o(21905);
                            return;
                        }
                        this.oRP = abVar.oTl;
                        if (this.oRJ != null) {
                            this.oRJ.chm();
                        } else {
                            Log.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                            Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                            className.addFlags(335544320);
                            className.putExtra("nofification_type", "back_to_pcmgr_notification");
                            className.putExtra("newPCBackup", false);
                            Context context = MMApplicationContext.getContext();
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakToPcUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                        this.oRS = 0;
                        this.oRT = 1;
                        AppMethodBeat.o(21905);
                        return;
                    case 1:
                        a.cgZ().chc().chd();
                        a.cgZ().chb().aWm();
                        aA(-1, null);
                        Log.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        AppMethodBeat.o(21905);
                        return;
                    case 3:
                        this.oRT = 2;
                        this.oRS = 3;
                        chl();
                        a(abVar.oTl, 0, null);
                        h.RTc.ba(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0174: INVOKE  
                              (wrap: com.tencent.f.i : 0x016d: SGET  (r1v31 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                              (wrap: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d$1 : 0x0171: CONSTRUCTOR  (r2v12 com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d$1) = 
                              (wrap: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d : 0x016b: IGET  (r0v57 com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d) = (r11v0 'this' com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.oRL com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d)
                             call: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.1.<init>(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d):void type: CONSTRUCTOR)
                             type: INTERFACE call: com.tencent.f.i.ba(java.lang.Runnable):com.tencent.f.i.d in method: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a(boolean, int, byte[], int):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0171: CONSTRUCTOR  (r2v12 com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d$1) = 
                              (wrap: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d : 0x016b: IGET  (r0v57 com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d) = (r11v0 'this' com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.oRL com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d)
                             call: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.1.<init>(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a(boolean, int, byte[], int):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 29 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 35 more
                            */
                        /*
                        // Method dump skipped, instructions count: 778
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.a(boolean, int, byte[], int):void");
                    }

                    public static void chj() {
                        AppMethodBeat.i(21906);
                        Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                        className.addFlags(335544320);
                        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
                        Context context = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakPcProcessMgr", "skipToBakErrorUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(21906);
                    }

                    public final int chk() {
                        AppMethodBeat.i(21907);
                        Log.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", Integer.valueOf(this.oRT));
                        if (this.oRT == 2 || this.oRT == 3) {
                            int i2 = this.oRL.oRF;
                            AppMethodBeat.o(21907);
                            return i2;
                        } else if (this.oRT == 4 || this.oRT == 5) {
                            int i3 = this.oRM.oSg;
                            AppMethodBeat.o(21907);
                            return i3;
                        } else if (this.oRT == 6 || this.oRT == 7) {
                            int i4 = this.oRM.oSc;
                            AppMethodBeat.o(21907);
                            return i4;
                        } else {
                            Log.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
                            AppMethodBeat.o(21907);
                            return 0;
                        }
                    }

                    public final void Bu(int i2) {
                        AppMethodBeat.i(21908);
                        if (i2 == 0) {
                            this.oRS = 1;
                        } else {
                            this.oRS = -1;
                        }
                        if (i2 == 1) {
                            ac acVar = new ac();
                            acVar.oTl = 0;
                            acVar.oTW = i2;
                            try {
                                Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(acVar.oTW));
                                com.tencent.mm.plugin.backup.g.b.N(acVar.toByteArray(), 4);
                                AppMethodBeat.o(21908);
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "buf to PacketCommandResponse err", new Object[0]);
                                AppMethodBeat.o(21908);
                            }
                        } else {
                            q qVar = new q();
                            qVar.oUh = 0;
                            qVar.oUj = Build.MANUFACTURER;
                            qVar.oTJ = Build.MODEL;
                            qVar.oUi = 0;
                            qVar.Version = Build.VERSION.RELEASE;
                            String str = ar.NSe;
                            if (new o(com.tencent.mm.loader.j.b.aKD()).exists() && com.tencent.mm.compatible.util.e.apn()) {
                                o oVar = new o(com.tencent.mm.loader.j.b.aKJ());
                                if (oVar.exists() || oVar.mkdirs()) {
                                    str = com.tencent.mm.loader.j.b.aKJ();
                                }
                            }
                            qVar.oUg = str;
                            qVar.oUf = z.aUa();
                            qVar.oUe = z.aTY();
                            qVar.oUd = new StringBuilder().append(com.tencent.mm.protocal.d.KyO).toString();
                            try {
                                PackageInfo packageInfo = MMApplicationContext.getContext().getPackageManager().getPackageInfo(MMApplicationContext.getContext().getPackageName(), 0);
                                qVar.oUd = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.KyO;
                            } catch (Exception e3) {
                                Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "get packageInfo failed", new Object[0]);
                            }
                            p.aYn();
                            Bitmap Mn = com.tencent.mm.aj.e.Mn(qVar.oUe);
                            byte[] bArr = null;
                            if (Mn != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                Mn.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                                bArr = byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception e4) {
                                    Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e4, "close", new Object[0]);
                                }
                            }
                            p.aYn();
                            String M = com.tencent.mm.aj.e.M(qVar.oUe, true);
                            Object[] objArr = new Object[2];
                            objArr[0] = M;
                            objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            Log.i("MicroMsg.BakPcProcessMgr", ", bmHDPath:%s, bm.buf.len:%d", objArr);
                            if (!Util.isNullOrNil(bArr)) {
                                qVar.oUk = new com.tencent.mm.bw.b(bArr);
                            }
                            byte[] aW = s.aW(M, 0, -1);
                            if (!Util.isNullOrNil(aW)) {
                                qVar.oUl = new com.tencent.mm.bw.b(aW);
                            }
                            ac acVar2 = new ac();
                            acVar2.oTl = 0;
                            acVar2.oTW = i2;
                            acVar2.oUN = qVar;
                            try {
                                Log.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", Integer.valueOf(acVar2.oTW));
                                com.tencent.mm.plugin.backup.g.b.N(acVar2.toByteArray(), 4);
                                AppMethodBeat.o(21908);
                            } catch (Exception e5) {
                                Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e5, "buf to PacketCommandResponse err", new Object[0]);
                                AppMethodBeat.o(21908);
                            }
                        }
                    }

                    public static void a(int i2, int i3, com.tencent.mm.plugin.backup.i.s sVar) {
                        AppMethodBeat.i(21909);
                        ac acVar = new ac();
                        acVar.oTl = i2;
                        acVar.oTW = i3;
                        acVar.oUQ = sVar;
                        try {
                            Log.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", Integer.valueOf(i3), Integer.valueOf(i2), Bw(i2));
                            com.tencent.mm.plugin.backup.g.b.N(acVar.toByteArray(), 4);
                            AppMethodBeat.o(21909);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "buf to PacketCommandResponse err", new Object[0]);
                            AppMethodBeat.o(21909);
                        }
                    }

                    public static void Bv(int i2) {
                        AppMethodBeat.i(21910);
                        ab abVar = new ab();
                        abVar.oTl = i2;
                        try {
                            Log.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", Integer.valueOf(i2), Bw(i2));
                            com.tencent.mm.plugin.backup.g.b.N(abVar.toByteArray(), 3);
                            AppMethodBeat.o(21910);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "buf to PacketCommandRequest err", new Object[0]);
                            AppMethodBeat.o(21910);
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public final synchronized void a(r rVar) {
                        AppMethodBeat.i(21911);
                        if (this.oRM != null) {
                            this.oRM.cancel();
                        }
                        this.oRM = new f();
                        f fVar = this.oRM;
                        LinkedList<t> linkedList = rVar.oUm;
                        LinkedList<t> linkedList2 = rVar.oUn;
                        long j2 = rVar.oTV;
                        fVar.oSa = linkedList;
                        fVar.oSb = linkedList2;
                        fVar.dLD = false;
                        fVar.ifz = false;
                        fVar.oRz.clear();
                        fVar.oRC = false;
                        fVar.oSd = false;
                        fVar.oKz = false;
                        fVar.oSc = 0;
                        fVar.oSf = 0;
                        fVar.oSe = j2;
                        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(0);
                        this.oRM.oRA = this.oRA;
                        Log.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", Integer.valueOf(rVar.oUm.size()), Integer.valueOf(rVar.oUn.size()), Long.valueOf(rVar.oTV));
                        f fVar2 = this.oRM;
                        fVar2.oRG = 0;
                        if (fVar2.oSb.size() < rVar.oUa || fVar2.oSa.size() < rVar.oTZ) {
                            com.tencent.mm.plugin.backup.g.b.a(3, new i() {
                                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass2 */

                                @Override // com.tencent.mm.ak.i
                                public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                                    AppMethodBeat.i(21920);
                                    ac acVar = (ac) ((com.tencent.mm.plugin.backup.g.b) qVar).cgq();
                                    if (acVar.oTl != 2) {
                                        AppMethodBeat.o(21920);
                                        return;
                                    }
                                    r rVar = acVar.oUP;
                                    f.this.oSb.addAll(rVar.oUn);
                                    f.this.oSa.addAll(rVar.oUm);
                                    Log.i("MicroMsg.RecoverPCServer", "MediaSize:[%d / %d], digestSize: [%d / %d]", Integer.valueOf(f.this.oSb.size()), Integer.valueOf(f.this.oSa.size()), Integer.valueOf(rVar.oUa), Integer.valueOf(rVar.oTZ));
                                    if (f.this.oSb.size() < rVar.oUa || f.this.oSa.size() < rVar.oTZ) {
                                        Log.i("MicroMsg.RecoverPCServer", "send restore info cmd again~");
                                        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).cgA();
                                        AppMethodBeat.o(21920);
                                        return;
                                    }
                                    f.this.oSe = rVar.oTV;
                                    Log.i("MicroMsg.RecoverPCServer", "down RestoreInfo complete, convDataSize:%d", Long.valueOf(f.this.oSe));
                                    com.tencent.mm.plugin.backup.g.b.b(3, this);
                                    h.RTc.aX(new com.tencent.f.i.h() {
                                        /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass2.AnonymousClass1 */

                                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                        public final String getKey() {
                                            return "RecoverPCServer_recover_getIDList";
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(21919);
                                            f.a(f.this);
                                            AppMethodBeat.o(21919);
                                        }
                                    });
                                    AppMethodBeat.o(21920);
                                }
                            });
                            Log.i("MicroMsg.RecoverPCServer", "send restore info cmd");
                            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).cgA();
                            AppMethodBeat.o(21911);
                        } else {
                            Log.i("MicroMsg.RecoverPCServer", "startRecover start directly");
                            h.RTc.aX(new com.tencent.f.i.h() {
                                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass1 */

                                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                                public final String getKey() {
                                    return "RecoverPCServer_recover";
                                }

                                public final void run() {
                                    AppMethodBeat.i(21918);
                                    f.a(f.this);
                                    AppMethodBeat.o(21918);
                                }
                            });
                            AppMethodBeat.o(21911);
                        }
                    }

                    public static void chl() {
                        AppMethodBeat.i(21912);
                        EventCenter.instance.publish(new pe());
                        AppMethodBeat.o(21912);
                    }

                    private static String Bw(int i2) {
                        AppMethodBeat.i(21913);
                        switch (i2) {
                            case -1:
                                AppMethodBeat.o(21913);
                                return "COMMAND_NOT_SUPPORT";
                            case 0:
                                AppMethodBeat.o(21913);
                                return "AUTHORIZE";
                            case 1:
                                AppMethodBeat.o(21913);
                                return "BACKUP_INFO";
                            case 2:
                                AppMethodBeat.o(21913);
                                return "RESTORE_INFO";
                            case 3:
                                AppMethodBeat.o(21913);
                                return "BACKUP_START";
                            case 4:
                                AppMethodBeat.o(21913);
                                return "BACKUP_CANCEL";
                            case 5:
                                AppMethodBeat.o(21913);
                                return "BACKUP_FINISH";
                            case 6:
                                AppMethodBeat.o(21913);
                                return "RESTORE_START";
                            case 7:
                                AppMethodBeat.o(21913);
                                return "RESTORE_CANCE";
                            case 8:
                                AppMethodBeat.o(21913);
                                return "RESTORE_FINISH";
                            case 9:
                                AppMethodBeat.o(21913);
                                return "BACKUP_PAUSE";
                            case 10:
                                AppMethodBeat.o(21913);
                                return "RESTORE_PAUSE";
                            case 11:
                                AppMethodBeat.o(21913);
                                return "BACKUP_RESUME";
                            case 12:
                                AppMethodBeat.o(21913);
                                return "RESTORE_RESUME";
                            case 13:
                                AppMethodBeat.o(21913);
                                return "MERGE_PROGRESS";
                            case 14:
                                AppMethodBeat.o(21913);
                                return "LOGOFF";
                            case 15:
                                AppMethodBeat.o(21913);
                                return "EXIT";
                            case 16:
                                AppMethodBeat.o(21913);
                                return "SHOW_BACKUP_RESTORE";
                            case 17:
                                AppMethodBeat.o(21913);
                                return "COMMAND_WECHAT_LEAVE";
                            default:
                                String valueOf = String.valueOf(i2);
                                AppMethodBeat.o(21913);
                                return valueOf;
                        }
                    }
                }
