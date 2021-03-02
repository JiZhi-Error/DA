package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class d implements bd, d.a {
    private a FJC = null;
    private c FJD = null;
    Map<String, Integer> FJE = new HashMap();
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.subapp.jdbiz.d.AnonymousClass1 */

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(28878);
            if (com.tencent.mm.pluginsdk.i.d.JYo != null) {
                d.fsQ();
                d.fsX();
            }
            AppMethodBeat.o(28878);
        }
    };
    private IListener gmC = new IListener<jw>() {
        /* class com.tencent.mm.plugin.subapp.jdbiz.d.AnonymousClass2 */

        {
            AppMethodBeat.i(161440);
            this.__eventId = jw.class.getName().hashCode();
            AppMethodBeat.o(161440);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jw jwVar) {
            AppMethodBeat.i(28879);
            jw jwVar2 = jwVar;
            if (jwVar2 != null && (jwVar2 instanceof jw)) {
                jwVar2.dOP.url = d.this.ftc();
            }
            AppMethodBeat.o(28879);
            return false;
        }
    };

    public d() {
        AppMethodBeat.i(28881);
        Log.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + Util.getStack());
        AppMethodBeat.o(28881);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28883);
        Log.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.FJC == null) {
            this.FJC = new a();
        }
        this.appForegroundListener.alive();
        bg.getSysCmdMsgExtension().a("jd", (cj.a) this.FJC, true);
        EventCenter.instance.addListener(this.gmC);
        AppMethodBeat.o(28883);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(28884);
        Log.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        this.appForegroundListener.dead();
        if (this.FJC != null) {
            EventCenter.instance.removeListener(this.FJC.FJi);
            bg.getSysCmdMsgExtension().b("jd", this.FJC, true);
        }
        this.FJE.clear();
        this.FJC = null;
        EventCenter.instance.removeListener(this.gmC);
        AppMethodBeat.o(28884);
    }

    public static boolean fsR() {
        AppMethodBeat.i(28885);
        bg.aVF();
        boolean equals = "1".equals((String) c.azQ().get(327939, ""));
        AppMethodBeat.o(28885);
        return equals;
    }

    public static boolean fsS() {
        AppMethodBeat.i(28886);
        bg.aVF();
        boolean equals = "1".equals((String) c.azQ().get(327938, ""));
        AppMethodBeat.o(28886);
        return equals;
    }

    public static void fsT() {
        AppMethodBeat.i(28887);
        bg.aVF();
        c.azQ().set(327938, "");
        AppMethodBeat.o(28887);
    }

    public static void fsU() {
        AppMethodBeat.i(28888);
        bg.aVF();
        c.azQ().set(327939, "");
        AppMethodBeat.o(28888);
    }

    public final c fsV() {
        AppMethodBeat.i(28889);
        if (this.FJD == null) {
            this.FJD = c.fsN();
        }
        c cVar = this.FJD;
        AppMethodBeat.o(28889);
        return cVar;
    }

    public static void b(c cVar) {
        AppMethodBeat.i(28890);
        g.aAf().azk();
        d fsQ = fsQ();
        if (fsQ.FJD == null) {
            fsQ.FJD = c.fsN();
        }
        Log.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", fsQ.FJD.aBz(), cVar.aBz());
        if (!cVar.a(fsQ.FJD)) {
            Log.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
            AppMethodBeat.o(28890);
            return;
        }
        if (!Util.isNullOrNil(cVar.FJp) || cVar.FJo) {
            bg.aVF();
            c.azQ().set(327939, "1");
        }
        if (cVar.FJn) {
            bg.aVF();
            c.azQ().set(327938, "1");
        } else {
            bg.aVF();
            c.azQ().set(327938, "");
        }
        fsQ.FJD = cVar;
        bg.aVF();
        c.azQ().set(327942, cVar.dWG);
        fsQ.fsW();
        g.aAh().azQ().set(ar.a.USERINFO_JD_ENTRANCE_RESET_EXPOSURE_FLAG_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(28890);
    }

    private void fsW() {
        AppMethodBeat.i(28891);
        new MMHandler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.jdbiz.d.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(28880);
                EventCenter.instance.publish(new lb());
                AppMethodBeat.o(28880);
            }
        });
        AppMethodBeat.o(28891);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (fsS() != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fsX() {
        /*
            r2 = 28892(0x70dc, float:4.0486E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            boolean r0 = com.tencent.mm.model.bg.aAc()
            if (r0 == 0) goto L_0x0053
            fsQ()
            boolean r0 = fsR()
            if (r0 != 0) goto L_0x001d
            fsQ()
            boolean r0 = fsS()
            if (r0 == 0) goto L_0x0053
        L_0x001d:
            com.tencent.mm.plugin.subapp.jdbiz.d r0 = fsQ()
            com.tencent.mm.plugin.subapp.jdbiz.c r0 = r0.fsV()
            java.lang.String r1 = r0.FJp
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r1)
            if (r1 == 0) goto L_0x0031
            boolean r1 = r0.FJo
            if (r1 == 0) goto L_0x0053
        L_0x0031:
            boolean r0 = r0.dMp()
            if (r0 == 0) goto L_0x0053
            java.lang.String r0 = "MicroMsg.SubCoreJdIP6"
            java.lang.String r1 = "clear red dot/friend dot"
            com.tencent.mm.sdk.platformtools.Log.i(r0, r1)
            fsQ()
            fsT()
            fsQ()
            fsU()
            com.tencent.mm.plugin.subapp.jdbiz.d r0 = fsQ()
            r0.fsW()
        L_0x0053:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.subapp.jdbiz.d.fsX():void");
    }

    public static String fO(String str, int i2) {
        AppMethodBeat.i(28893);
        if (-1 == str.indexOf(35)) {
            if (-1 == str.indexOf(63)) {
                str = str + "?wc_scene=" + i2;
            } else {
                str = str + "&wc_scene=" + i2;
            }
        }
        AppMethodBeat.o(28893);
        return str;
    }

    @Override // com.tencent.mm.pluginsdk.i.d.a
    public final boolean fsY() {
        AppMethodBeat.i(28894);
        String fsZ = fsZ();
        String fta = fta();
        String value = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigJumpWeAppUsername");
        if (Util.isNullOrNil(fsZ) || (Util.isNullOrNil(fta) && Util.isNullOrNil(value))) {
            AppMethodBeat.o(28894);
            return false;
        }
        AppMethodBeat.o(28894);
        return true;
    }

    public static String fsZ() {
        String value;
        AppMethodBeat.i(28895);
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
            value = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigName");
        } else if (LocaleUtil.isTraditionalChineseAppLang()) {
            value = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigNameEN");
        }
        AppMethodBeat.o(28895);
        return value;
    }

    public static String fta() {
        AppMethodBeat.i(28896);
        String value = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigJumpUrl");
        AppMethodBeat.o(28896);
        return value;
    }

    private static b ftb() {
        AppMethodBeat.i(232066);
        b bVar = new b();
        bVar.username = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigJumpWeAppUsername");
        bVar.path = com.tencent.mm.n.h.aqJ().getValue("JDEntranceConfigJumpWeAppPath");
        bVar.version = com.tencent.mm.n.h.aqJ().getInt("JDEntranceConfigJumpWeAppVersion", 0);
        AppMethodBeat.o(232066);
        return bVar;
    }

    public final String ftc() {
        int i2 = 1;
        AppMethodBeat.i(28897);
        String str = "";
        c fsV = fsV();
        if (fsR()) {
            if (!fsV.dMp() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(fsV.FJl) && !Util.isNullOrNil(fsV.jumpUrl)) {
                Log.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", fsV.jumpUrl);
                str = fsV.jumpUrl;
                i2 = 6;
            } else if (fsV.FJo) {
                i2 = 2;
            }
        }
        if ("2".equals(fsV.FJl) && !Util.isNullOrNil(fsV.jumpUrl) && fsV.fsO() && !fsV.fsP()) {
            str = fsV.jumpUrl;
            i2 = 3;
        }
        if (!Util.isNullOrNil(str)) {
            String fO = fO(str, i2);
            AppMethodBeat.o(28897);
            return fO;
        }
        String fta = fta();
        AppMethodBeat.o(28897);
        return fta;
    }

    public final b ftd() {
        AppMethodBeat.i(28898);
        b bVar = new b();
        c fsV = fsV();
        if (fsR() && !fsV.dMp() && TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(fsV.FJl)) {
            Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", fsV.FJl, fsV.FJz, fsV.FJA, Integer.valueOf(fsV.FJB));
            bVar.username = fsV.FJz;
            bVar.path = fsV.FJA;
            bVar.version = fsV.FJB;
        }
        if ("2".equals(fsV.FJl) && fsV.fsO() && !fsV.fsP()) {
            Log.i("MicroMsg.SubCoreJdIP6", "bizType %s, jumpWeapp update user:%s path:%s version:%d", fsV.FJl, fsV.FJz, fsV.FJA, Integer.valueOf(fsV.FJB));
            bVar.username = fsV.FJz;
            bVar.path = fsV.FJA;
            bVar.version = fsV.FJB;
        }
        if (!bVar.isValid()) {
            bVar = ftb();
        }
        AppMethodBeat.o(28898);
        return bVar;
    }

    public static d fsQ() {
        AppMethodBeat.i(28882);
        d dVar = (d) com.tencent.mm.pluginsdk.i.d.JYo;
        if (dVar == null) {
            dVar = new d();
            com.tencent.mm.pluginsdk.i.d.JYo = dVar;
        }
        AppMethodBeat.o(28882);
        return dVar;
    }
}
