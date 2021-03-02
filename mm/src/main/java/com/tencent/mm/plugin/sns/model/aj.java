package com.tencent.mm.plugin.sns.model;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.app.o;
import com.tencent.mm.ay.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.g.a.de;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.oj;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.wc;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.a.ye;
import com.tencent.mm.g.a.ys;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.o;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.sns.ad.g.m;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.d;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.lucky.a.f;
import com.tencent.mm.plugin.sns.lucky.a.j;
import com.tencent.mm.plugin.sns.lucky.a.l;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.q;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SdcardUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;

public final class aj implements bd, k {
    private static String DKR = "";
    protected static HashMap<Integer, h.b> DKS = new HashMap<>();
    public static boolean DKh = true;
    private static int DKi = 0;
    private static int DKj = 0;
    private static int DKn;
    private static int DKo;
    private static MMHandler DLa;
    private static int DLb = 103;
    private static int DLc = a.fromDPToPix(MMApplicationContext.getContext(), 130);
    private static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass7 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(202735);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    rq rqVar = new rq();
                    rqVar.dYj.state = 1;
                    EventCenter.instance.publish(rqVar);
                }
            }
            AppMethodBeat.o(202735);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(202736);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    rq rqVar = new rq();
                    rqVar.dYj.state = 0;
                    EventCenter.instance.publish(rqVar);
                    EventCenter.instance.publish(new ye());
                }
            }
            AppMethodBeat.o(202736);
        }
    };
    private static Point imX = new Point();
    private IListener AgM = new IListener<mw>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass35 */

        {
            AppMethodBeat.i(202751);
            this.__eventId = mw.class.getName().hashCode();
            AppMethodBeat.o(202751);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mw mwVar) {
            AppMethodBeat.i(202752);
            mw mwVar2 = mwVar;
            if (mwVar2 instanceof mw) {
                switch (mwVar2.dSw.action) {
                    case -6:
                        List<SnsInfo> cp = aj.faO().cp(mwVar2.dSw.dSy.jfn, z.aTY().equals(mwVar2.dSw.dSy.jfn));
                        mwVar2.dSx.dLA = new ArrayList();
                        for (SnsInfo snsInfo : cp) {
                            mwVar2.dSx.dLA.add(i.a(aj.getAccPath(), snsInfo.getTimeLine(), 8, null));
                        }
                        break;
                    case -5:
                        n faO = aj.faO();
                        Cursor rawQuery = faO.iFy.rawQuery("select *,rowid from SnsInfo where (type = 4 ORtype = 42) AND  (sourceType & 2 != 0 ) " + n.Emu, null, 2);
                        ArrayList<SnsInfo> arrayList = new ArrayList();
                        while (rawQuery.moveToNext()) {
                            SnsInfo snsInfo2 = new SnsInfo();
                            snsInfo2.convertFrom(rawQuery);
                            arrayList.add(snsInfo2);
                        }
                        rawQuery.close();
                        mwVar2.dSx.dLA = new ArrayList();
                        for (SnsInfo snsInfo3 : arrayList) {
                            mwVar2.dSx.dLA.add(i.a(aj.getAccPath(), snsInfo3.getTimeLine(), 1, null));
                        }
                        break;
                }
            }
            AppMethodBeat.o(202752);
            return false;
        }
    };
    private ExecutorService CDQ;
    private x DKA;
    private v DKB;
    private aq.a DKC;
    private c DKD;
    private be DKE;
    private as DKF;
    private c DKG;
    private com.tencent.mm.plugin.sns.h.g DKH;
    private aw DKI;
    private at DKJ;
    private p DKK;
    private m DKL;
    private as DKM = new as();
    private boolean DKN = true;
    private aa DKO = new aa();
    private boolean DKP = false;
    private byte[] DKQ = new byte[0];
    private d DKT;
    private com.tencent.mm.plugin.sns.g.a DKU;
    private az DKV;
    private f DKW = new f();
    private j DKX = new j();
    private com.tencent.mm.plugin.sns.lucky.a.d DKY = new com.tencent.mm.plugin.sns.lucky.a.d();
    private l DKZ = new l();
    private ExecutorService DKk;
    private ExecutorService DKl;
    private ExecutorService DKm;
    private r DKp;
    private n DKq;
    private com.tencent.mm.plugin.sns.storage.c DKr;
    private b DKs;
    private ac DKt;
    private g DKu;
    private com.tencent.mm.plugin.sns.storage.m DKv;
    private com.tencent.mm.plugin.sns.storage.i DKw;
    private t DKx;
    private com.tencent.mm.plugin.sns.storage.k DKy;
    private ag DKz;
    private IListener DLA = new IListener<dc>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass26 */

        {
            AppMethodBeat.i(160668);
            this.__eventId = dc.class.getName().hashCode();
            AppMethodBeat.o(160668);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dc dcVar) {
            AppMethodBeat.i(95785);
            e.aPM("100004");
            e.aPM("100007");
            AppMethodBeat.o(95785);
            return false;
        }
    };
    private IListener DLB = new IListener<ye>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass27 */

        {
            AppMethodBeat.i(160669);
            this.__eventId = ye.class.getName().hashCode();
            AppMethodBeat.o(160669);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ye yeVar) {
            AppMethodBeat.i(95786);
            Log.i("MicroMsg.SnsCore", "triger snslogmgr try report");
            aj.faI().eXu();
            AppMethodBeat.o(95786);
            return false;
        }
    };
    private IListener DLC = new IListener<vh>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass28 */

        {
            AppMethodBeat.i(176267);
            this.__eventId = vh.class.getName().hashCode();
            AppMethodBeat.o(176267);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vh vhVar) {
            AppMethodBeat.i(176268);
            an.fbq();
            aj.faO().iFy.execSQL(gk.TABLE_NAME, "delete from SnsInfo");
            aj.faS().aQo("@__weixintimtline");
            AppMethodBeat.o(176268);
            return false;
        }
    };
    private IListener DLD = new IListener<sa>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass29 */

        {
            AppMethodBeat.i(160670);
            this.__eventId = sa.class.getName().hashCode();
            AppMethodBeat.o(160670);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sa saVar) {
            AppMethodBeat.i(95788);
            boolean a2 = a(saVar);
            AppMethodBeat.o(95788);
            return a2;
        }

        private static boolean a(sa saVar) {
            String str;
            boolean z;
            m faI;
            int i2;
            char c2;
            int i3;
            Object[] objArr;
            Object[] objArr2;
            AppMethodBeat.i(202748);
            SnsAdClick snsAdClick = saVar.dYC.dYl;
            try {
                if (saVar.dYC.dYD == 1) {
                    if (snsAdClick.jkW == 1) {
                        AdSnsInfo JE = aj.faR().JE(snsAdClick.ece);
                        if (JE == null || !JE.isRecExpAd()) {
                            faI = aj.faI();
                            i2 = 13155;
                            Object[] objArr3 = new Object[7];
                            objArr3[0] = Long.valueOf(snsAdClick.ece);
                            objArr3[1] = JE.getAdInfo().uxInfo;
                            objArr3[2] = Integer.valueOf(snsAdClick.jkT);
                            objArr3[3] = Long.valueOf(snsAdClick.startTime);
                            objArr3[4] = Long.valueOf(System.currentTimeMillis());
                            c2 = 5;
                            if (JE != null) {
                                i3 = JE.getRecSrc();
                                objArr = objArr3;
                                objArr2 = objArr3;
                            } else {
                                i3 = -1;
                                objArr = objArr3;
                                objArr2 = objArr3;
                            }
                        } else {
                            faI = aj.faI();
                            i2 = 14647;
                            Object[] objArr4 = new Object[7];
                            objArr4[0] = Long.valueOf(snsAdClick.ece);
                            objArr4[1] = JE.getAdInfo().uxInfo;
                            objArr4[2] = Integer.valueOf(snsAdClick.jkT);
                            objArr4[3] = Long.valueOf(snsAdClick.startTime);
                            objArr4[4] = Long.valueOf(System.currentTimeMillis());
                            c2 = 5;
                            i3 = JE.getRecSrc();
                            objArr = objArr4;
                            objArr2 = objArr4;
                        }
                        objArr[c2] = Integer.valueOf(i3);
                        objArr2[6] = "";
                        faI.a(i2, objArr2);
                        com.tencent.mm.modelsns.k tP = com.tencent.mm.modelsns.k.tP(750);
                        tP.PH(new StringBuilder().append(snsAdClick.ece).toString()).PH(JE.getAdInfo().uxInfo).tR(snsAdClick.jkT).PH(new StringBuilder().append(snsAdClick.startTime).toString()).PH(new StringBuilder().append(System.currentTimeMillis()).toString());
                        tP.bfK();
                    } else {
                        AdSnsInfo JE2 = aj.faR().JE(snsAdClick.ece);
                        if (JE2 != null) {
                            str = JE2.getAdInfo().uxInfo;
                            z = JE2.isRecExpAd();
                        } else {
                            str = saVar.dYC.uxInfo;
                            if (str == null) {
                                str = "";
                            }
                            Log.i("MicroMsg.SnsCore", "ReportSnsEvent, AdSnsInfo==null, uxInfo=".concat(String.valueOf(str)));
                            z = false;
                        }
                        String str2 = (com.tencent.mm.plugin.sns.ad.g.j.a(snsAdClick.ece, snsAdClick, str, Integer.valueOf(snsAdClick.jkT), Long.valueOf(snsAdClick.startTime), Long.valueOf(System.currentTimeMillis())) + String.format(",%s", new StringBuilder().append(snsAdClick.jkX).toString())) + String.format(",%s", new StringBuilder().append((System.currentTimeMillis() - snsAdClick.startTime) - snsAdClick.jkZ).toString());
                        if (z) {
                            aj.faI().a(14643, str2);
                        } else {
                            aj.faI().a(12013, str2);
                        }
                        com.tencent.mm.modelsns.k tP2 = com.tencent.mm.modelsns.k.tP(733);
                        tP2.PH(new StringBuilder().append(snsAdClick.ece).toString()).PH(str).tR(snsAdClick.jkT).PH(new StringBuilder().append(snsAdClick.startTime).toString()).PH(new StringBuilder().append(System.currentTimeMillis()).toString());
                        tP2.bfK();
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsCore", e2, "report ad click error", new Object[0]);
            }
            AppMethodBeat.o(202748);
            return false;
        }
    };
    private IListener DLE = new IListener<wc>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass30 */

        {
            AppMethodBeat.i(160671);
            this.__eventId = wc.class.getName().hashCode();
            AppMethodBeat.o(160671);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wc wcVar) {
            AppMethodBeat.i(95789);
            boolean fbk = fbk();
            AppMethodBeat.o(95789);
            return fbk;
        }

        private static boolean fbk() {
            AppMethodBeat.i(202749);
            com.tencent.mm.plugin.sns.lucky.a.g.eZK();
            ar.a aVar = ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLMARKFULLSCREEN_STRING_SYNC;
            com.tencent.mm.plugin.sns.j.i iVar = new com.tencent.mm.plugin.sns.j.i();
            try {
                g.aAi();
                g.aAh().azQ().set(aVar, new String(iVar.toByteArray(), Charset.forName(KindaConfigCacheStg.SAVE_CHARSET)));
            } catch (IOException e2) {
                Log.w("MicroMsg.RedDotUtil", "mardRedotList save exception:" + e2.getLocalizedMessage());
            }
            AppMethodBeat.o(202749);
            return false;
        }
    };
    private IListener DLF = new IListener<bx>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass31 */

        {
            AppMethodBeat.i(160672);
            this.__eventId = bx.class.getName().hashCode();
            AppMethodBeat.o(160672);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bx bxVar) {
            AppMethodBeat.i(95791);
            com.tencent.mm.plugin.sns.storage.m faS = aj.faS();
            System.currentTimeMillis();
            Log.i("MicroMsg.SnsExtStorage", "clean Error sql %s ret  %s", "update snsExtInfo3 set md5 = '', faults = '';", Boolean.valueOf(faS.iFy.execSQL("snsExtInfo3", "update snsExtInfo3 set md5 = '', faults = '';")));
            AppMethodBeat.o(95791);
            return false;
        }
    };
    private IListener DLG = new IListener<os>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass32 */

        {
            AppMethodBeat.i(176271);
            this.__eventId = os.class.getName().hashCode();
            AppMethodBeat.o(176271);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(os osVar) {
            String p;
            AppMethodBeat.i(176272);
            os osVar2 = osVar;
            if (osVar2.dUJ.source == 1) {
                p = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.feB().n(osVar2.dUJ.pageId, osVar2.dUJ.dFN, osVar2.dUJ.dUL, osVar2.dUJ.dUM);
            } else {
                p = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.m.feB().p(Util.safeParseLong(osVar2.dUJ.pageId), osVar2.dUJ.dUL, osVar2.dUJ.dUM);
            }
            osVar2.dUK.xml = p;
            AppMethodBeat.o(176272);
            return false;
        }
    };
    private boolean DLH = false;
    private IListener DLI = new IListener<vt>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass36 */

        {
            AppMethodBeat.i(202753);
            this.__eventId = vt.class.getName().hashCode();
            AppMethodBeat.o(202753);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vt vtVar) {
            AppMethodBeat.i(202754);
            vt vtVar2 = vtVar;
            if (vtVar2 instanceof vt) {
                com.tencent.mm.plugin.sns.lucky.a.b.pl(vtVar2.ebU.key);
            }
            AppMethodBeat.o(202754);
            return false;
        }
    };
    private IListener DLJ = new IListener<sm>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass37 */

        {
            AppMethodBeat.i(202756);
            this.__eventId = sm.class.getName().hashCode();
            AppMethodBeat.o(202756);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sm smVar) {
            AppMethodBeat.i(202757);
            sm smVar2 = smVar;
            final ArrayList arrayList = smVar2.dZa.dZb;
            final String str = smVar2.dZa.dZc;
            Log.i("MicroMsg.SnsCore", "ResendSnsByUpdateXmlEvent, try resend sns");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass37.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(202755);
                    aq.g(arrayList, str);
                    AppMethodBeat.o(202755);
                }
            });
            AppMethodBeat.o(202757);
            return false;
        }
    };
    private IListener DLK = new IListener<ia>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass38 */

        {
            AppMethodBeat.i(202759);
            this.__eventId = ia.class.getName().hashCode();
            AppMethodBeat.o(202759);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ia iaVar) {
            AppMethodBeat.i(202760);
            final ia iaVar2 = iaVar;
            if (!(iaVar2 == null || iaVar2.dMC == null || iaVar2.dMC.localId <= 0)) {
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass38.AnonymousClass1 */

                    public final void run() {
                        TimeLineObject timeLine;
                        AppMethodBeat.i(202758);
                        n faO = aj.faO();
                        ArrayList<SnsInfo> arrayList = new ArrayList();
                        String str = "select *,rowid from SnsInfo  where " + n.EmA;
                        Cursor rawQuery = faO.iFy.rawQuery(str, null, 2);
                        Log.d("MicroMsg.SnsInfoStorage", "getLastUpload ".concat(String.valueOf(str)));
                        while (rawQuery.moveToNext()) {
                            SnsInfo snsInfo = new SnsInfo();
                            snsInfo.convertFrom(rawQuery);
                            arrayList.add(snsInfo);
                        }
                        rawQuery.close();
                        for (SnsInfo snsInfo2 : arrayList) {
                            if (!(snsInfo2 == null || (timeLine = snsInfo2.getTimeLine()) == null || timeLine.ContentObj == null || timeLine.ContentObj.dME == null || timeLine.ContentObj.dME.localId != iaVar2.dMC.localId)) {
                                if (!iaVar2.dMC.dMD || iaVar2.dMC.dME == null) {
                                    com.tencent.mm.plugin.sns.k.e.DUQ.DVE.esJ = 1;
                                    com.tencent.mm.plugin.sns.k.e.DUQ.fcF();
                                    com.tencent.mm.plugin.sns.k.e.DUQ.DVD = 0;
                                    snsInfo2.cleanPostHolding();
                                    snsInfo2.setItemDie();
                                } else {
                                    timeLine.ContentObj.dME = iaVar2.dMC.dME;
                                    com.tencent.mm.plugin.sns.k.e.DUQ.DVE.ql(timeLine.ContentObj.dME.objectId);
                                    snsInfo2.setTimeLine(timeLine);
                                    snsInfo2.cleanPostHolding();
                                }
                                aj.faO().S(snsInfo2);
                                aj.faK().eZn();
                                AppMethodBeat.o(202758);
                                return;
                            }
                        }
                        AppMethodBeat.o(202758);
                    }
                });
            }
            AppMethodBeat.o(202760);
            return false;
        }
    };
    private final be.a DLL = new be.a() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass39 */

        @Override // com.tencent.mm.plugin.sns.model.be.a
        public final void fbl() {
        }

        @Override // com.tencent.mm.plugin.sns.model.be.a
        public final void aP(final int i2, boolean z) {
            AppMethodBeat.i(202763);
            if (z && ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag() && i2 > 0) {
                ((com.tencent.mm.plugin.secdata.g) g.ah(com.tencent.mm.plugin.secdata.g.class)).getWithClear(2, "SnsPostEnd_".concat(String.valueOf(i2)), com.tencent.mm.plugin.sns.j.j.class, new com.tencent.mm.plugin.secdata.i<com.tencent.mm.plugin.sns.j.j>() {
                    /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass39.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, com.tencent.mm.bw.a] */
                    @Override // com.tencent.mm.plugin.secdata.i
                    public final /* synthetic */ void a(int i2, boolean z, com.tencent.mm.plugin.sns.j.j jVar) {
                        AppMethodBeat.i(202762);
                        com.tencent.mm.plugin.sns.j.j jVar2 = jVar;
                        if (jVar2 == null || TextUtils.isEmpty(jVar2.sessionId)) {
                            AppMethodBeat.o(202762);
                            return;
                        }
                        final String str = jVar2.sessionId;
                        final long aWB = (long) cl.aWB();
                        com.tencent.f.h.RTc.b(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass39.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(202761);
                                SnsInfo Zr = aj.faO().Zr(i2);
                                if (Zr == null || Zr.field_snsId == 0) {
                                    AppMethodBeat.o(202761);
                                    return;
                                }
                                TimeLineObject timeLine = Zr.getTimeLine();
                                if (timeLine == null) {
                                    AppMethodBeat.o(202761);
                                    return;
                                }
                                String str = timeLine.ContentDesc;
                                if (TextUtils.isEmpty(str)) {
                                    AppMethodBeat.o(202761);
                                    return;
                                }
                                String Jb = com.tencent.mm.plugin.sns.data.r.Jb(Zr.field_snsId);
                                Matcher matcher = k.a.Krb.matcher(str);
                                while (matcher.find()) {
                                    SnsUploadUI.a(3, matcher.group(), Jb, aWB, str);
                                }
                                AppMethodBeat.o(202761);
                            }
                        }, "WebSearchReportLogic.TagSearchReport");
                        AppMethodBeat.o(202762);
                    }
                });
            }
            AppMethodBeat.o(202763);
        }
    };
    private com.tencent.mm.plugin.sns.n DLd;
    private com.tencent.mm.plugin.sns.k DLe;
    private com.tencent.mm.plugin.sns.e DLf;
    private q DLg;
    private com.tencent.mm.plugin.sns.h DLh;
    private com.tencent.mm.plugin.sns.g DLi;
    private com.tencent.mm.plugin.sns.m DLj;
    private com.tencent.mm.plugin.sns.j DLk;
    private com.tencent.mm.plugin.sns.b DLl;
    private com.tencent.mm.plugin.sns.c DLm;
    private com.tencent.mm.plugin.sns.f DLn;
    private IListener DLo = new IListener<ps>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass13 */

        {
            AppMethodBeat.i(160656);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(160656);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            boolean z = true;
            AppMethodBeat.i(95767);
            int i2 = com.tencent.mm.n.h.aqJ().getInt("SnsHEVCSwitch", 0);
            int i3 = com.tencent.mm.n.h.aqJ().getInt("SnsWXPCSwitch", 0);
            boolean z2 = i2 == 1;
            if (i3 != 1) {
                z = false;
            }
            SharedPreferences.Editor edit = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false).edit();
            edit.putBoolean("sw_use_vcodec_img", z2);
            edit.putBoolean("sw_use_wxpc_img", z);
            edit.commit();
            AppMethodBeat.o(95767);
            return false;
        }
    };
    private IListener DLp = new IListener<com.tencent.mm.g.a.g>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass14 */

        {
            AppMethodBeat.i(160657);
            this.__eventId = com.tencent.mm.g.a.g.class.getName().hashCode();
            AppMethodBeat.o(160657);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.g gVar) {
            AppMethodBeat.i(95769);
            String str = gVar.dBU.dBV;
            if (!Util.isNullOrNil(str)) {
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.aQj(str);
            }
            AppMethodBeat.o(95769);
            return false;
        }
    };
    private IListener DLq = new IListener<dd>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass15 */

        {
            AppMethodBeat.i(160658);
            this.__eventId = dd.class.getName().hashCode();
            AppMethodBeat.o(160658);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(dd ddVar) {
            AppMethodBeat.i(95771);
            g.aAi();
            String str = g.aAh().cachePath;
            g.aAi();
            String str2 = g.aAh().hqF;
            Log.i("MicroMsg.SnsCore", "dump %s", str2);
            s.deleteFile(str2 + "sns.dump");
            s.nw(str + "SnsMicroMsg.db", str2 + "sns.dump");
            AppMethodBeat.o(95771);
            return false;
        }
    };
    private IListener DLr = new IListener<wy>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass16 */

        {
            AppMethodBeat.i(160659);
            this.__eventId = wy.class.getName().hashCode();
            AppMethodBeat.o(160659);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wy wyVar) {
            AppMethodBeat.i(95772);
            final wy wyVar2 = wyVar;
            if (wyVar2.edp.dJY != 9 && wyVar2.edp.dJY == 7) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass16.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(176262);
                        com.tencent.mm.plugin.sns.storage.i faT = aj.faT();
                        String concat = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= ".concat(String.valueOf((int) wyVar2.edp.edr));
                        Log.i("MicroMsg.SnsCommentStorage", "updateToread ".concat(String.valueOf(concat)));
                        Log.i("MicroMsg.SnsCore", "update msg read ".concat(String.valueOf(faT.iFy.execSQL("SnsComment", concat))));
                        v.fai();
                        AppMethodBeat.o(176262);
                    }
                });
            }
            AppMethodBeat.o(95772);
            return false;
        }
    };
    private IListener DLs = new IListener<kd>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass17 */

        {
            AppMethodBeat.i(160660);
            this.__eventId = kd.class.getName().hashCode();
            AppMethodBeat.o(160660);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kd kdVar) {
            AppMethodBeat.i(95774);
            kdVar.dPd.isResume = aj.faY().fgK();
            AppMethodBeat.o(95774);
            return false;
        }
    };
    private IListener DLt = new IListener<jf>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass18 */

        {
            AppMethodBeat.i(160661);
            this.__eventId = jf.class.getName().hashCode();
            AppMethodBeat.o(160661);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jf jfVar) {
            AppMethodBeat.i(95776);
            jfVar.dNW.dNX = aj.faO().eZl();
            AppMethodBeat.o(95776);
            return false;
        }
    };
    private IListener DLu = new IListener<oj>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass19 */

        {
            AppMethodBeat.i(160662);
            this.__eventId = oj.class.getName().hashCode();
            AppMethodBeat.o(160662);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oj ojVar) {
            AppMethodBeat.i(95777);
            boolean a2 = a(ojVar);
            AppMethodBeat.o(95777);
            return a2;
        }

        private static boolean a(oj ojVar) {
            AppMethodBeat.i(202744);
            ArrayList arrayList = ojVar.dUw.dNX;
            n faO = aj.faO();
            h dataDB = aj.getDataDB();
            long beginTransaction = dataDB.beginTransaction(-1);
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    SnsInfo Zr = faO.Zr((int) longValue);
                    if (Zr != null) {
                        Zr.setOmittedFailResend();
                        Log.d("MicroMsg.SnsInfoStorage", "snsInfoId:%d, setOmitFailResend", Long.valueOf(longValue));
                        faO.d((int) longValue, Zr);
                    }
                }
                return false;
            } finally {
                dataDB.endTransaction(beginTransaction);
                AppMethodBeat.o(202744);
            }
        }
    };
    private IListener DLv = new IListener<sn>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass20 */

        {
            AppMethodBeat.i(160663);
            this.__eventId = sn.class.getName().hashCode();
            AppMethodBeat.o(160663);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sn snVar) {
            AppMethodBeat.i(95778);
            final long j2 = (long) snVar.dZd.dZe;
            Log.d("MicroMsg.SnsCore", "try resend msg for SnsInfoId:%d", Long.valueOf(j2));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass20.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(202745);
                    an.YB((int) j2);
                    aj.faK().eZn();
                    EventCenter.instance.publish(new ys());
                    AppMethodBeat.o(202745);
                }
            });
            AppMethodBeat.o(95778);
            return false;
        }
    };
    private IListener DLw = new IListener<vk>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass21 */

        {
            AppMethodBeat.i(160664);
            this.__eventId = vk.class.getName().hashCode();
            AppMethodBeat.o(160664);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vk vkVar) {
            AppMethodBeat.i(95779);
            aj.b(aj.this);
            AppMethodBeat.o(95779);
            return false;
        }
    };
    private IListener DLx = new IListener<rr>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass22 */

        {
            AppMethodBeat.i(160665);
            this.__eventId = rr.class.getName().hashCode();
            AppMethodBeat.o(160665);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rr rrVar) {
            AppMethodBeat.i(95780);
            boolean a2 = a(rrVar);
            AppMethodBeat.o(95780);
            return a2;
        }

        private static boolean a(rr rrVar) {
            ADInfo adInfo;
            AppMethodBeat.i(202746);
            try {
                SnsAdClick snsAdClick = rrVar.dYk.dYl;
                AdSnsInfo JE = aj.faR().JE(snsAdClick.ece);
                if (JE == null) {
                    AppMethodBeat.o(202746);
                    return false;
                }
                SnsInfo convertToSnsInfo = JE.convertToSnsInfo();
                if (snsAdClick.source == 2) {
                    adInfo = convertToSnsInfo.getAtAdInfo();
                } else {
                    adInfo = convertToSnsInfo.getAdInfo();
                }
                if (adInfo != null) {
                    String str = adInfo.waidPkg;
                    String aRy = com.tencent.mm.plugin.sns.waid.b.aRy(str);
                    com.tencent.mm.plugin.sns.ad.g.a aVar = new com.tencent.mm.plugin.sns.ad.g.a();
                    aVar.Dup = com.tencent.mm.plugin.sns.data.k.r(convertToSnsInfo);
                    aVar.Duq = com.tencent.mm.plugin.sns.data.k.s(convertToSnsInfo);
                    aVar.Dur = (int) snsAdClick.jlc;
                    if (snsAdClick.source == 2) {
                        Log.i("MicroMsg.SnsCore", "at_friend_detail report ad click, exposureTime=" + snsAdClick.jlb + ", clkPos=" + snsAdClick.jkU + ", pkg=" + str + ", waid=" + aRy);
                        com.tencent.mm.plugin.sns.ad.g.f fVar = new com.tencent.mm.plugin.sns.ad.g.f(snsAdClick.ece, adInfo.viewId, snsAdClick.jkU, snsAdClick.jkV, snsAdClick.jkT, "", convertToSnsInfo.getAdType(), convertToSnsInfo.getTimeLine().statExtStr, snsAdClick.jla, convertToSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSourceInfo(), convertToSnsInfo.getAdSnsInfo().getAtFriendRemindInfoSelfInfo(), snsAdClick.jlb, str, aRy, aVar);
                        g.aAi();
                        g.aAg().hqi.a(fVar, 0);
                    } else {
                        Log.i("MicroMsg.SnsCore", "report ad click, exposureTime=" + snsAdClick.jlb + ", clkPos=" + snsAdClick.jkU + ", source=" + snsAdClick.source + ", pkg=" + str + ", waid=" + aRy);
                        com.tencent.mm.plugin.sns.ad.g.f fVar2 = new com.tencent.mm.plugin.sns.ad.g.f(snsAdClick.ece, adInfo.viewId, snsAdClick.jkU, snsAdClick.jkV, snsAdClick.jkT, "", convertToSnsInfo.getAdType(), convertToSnsInfo.getTimeLine().statExtStr, snsAdClick.jla, convertToSnsInfo.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), convertToSnsInfo.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), snsAdClick.jlb, str, aRy, aVar);
                        g.aAi();
                        g.aAg().hqi.a(fVar2, 0);
                    }
                    AppMethodBeat.o(202746);
                    return true;
                }
                AppMethodBeat.o(202746);
                return false;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsCore", e2, "report ad click error", new Object[0]);
            }
        }
    };
    private IListener DLy = new IListener<rs>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass24 */

        {
            AppMethodBeat.i(160666);
            this.__eventId = rs.class.getName().hashCode();
            AppMethodBeat.o(160666);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(rs rsVar) {
            AppMethodBeat.i(95782);
            boolean a2 = a(rsVar);
            AppMethodBeat.o(95782);
            return a2;
        }

        private static boolean a(rs rsVar) {
            ADInfo adInfo;
            AppMethodBeat.i(202747);
            try {
                SnsAdClick snsAdClick = rsVar.dYm.dYl;
                AdSnsInfo JE = aj.faR().JE(snsAdClick.ece);
                if (JE != null) {
                    SnsInfo convertToSnsInfo = JE.convertToSnsInfo();
                    if (snsAdClick.source == 2) {
                        adInfo = convertToSnsInfo.getAtAdInfo();
                    } else {
                        adInfo = convertToSnsInfo.getAdInfo();
                    }
                    if (adInfo != null) {
                        if (snsAdClick.source == 2) {
                            Log.i("MicroMsg.SnsCore", "at_friend_detail report ad h5 load");
                        } else {
                            Log.i("MicroMsg.SnsCore", "report ad h5 load");
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(16972, Long.valueOf(snsAdClick.ece), Integer.valueOf(snsAdClick.jkT), adInfo.uxInfo, Integer.valueOf(convertToSnsInfo.getAdRecSrc()), convertToSnsInfo.getTimeLine().statExtStr, rsVar.dYm.url, Integer.valueOf(rsVar.dYm.dYn), Integer.valueOf(rsVar.dYm.errorCode), Long.valueOf(rsVar.dYm.timestamp));
                        AppMethodBeat.o(202747);
                        return true;
                    }
                    AppMethodBeat.o(202747);
                    return false;
                }
                SnsInfo JJ = aj.faO().JJ(snsAdClick.ece);
                Log.i("MicroMsg.SnsCore", "report ad h5, AdSnsInfo==null, uxInfo=" + rsVar.dYm.uxInfo + ", snsInfo==null?" + (JJ == null));
                if (JJ != null) {
                    String str = rsVar.dYm.uxInfo;
                    int adRecSrc = JJ.getAdRecSrc();
                    TimeLineObject timeLine = JJ.getTimeLine();
                    String str2 = timeLine == null ? "" : timeLine.statExtStr;
                    if (str2 == null) {
                        str2 = "";
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(16972, Long.valueOf(snsAdClick.ece), Integer.valueOf(snsAdClick.jkT), str, Integer.valueOf(adRecSrc), str2, rsVar.dYm.url, Integer.valueOf(rsVar.dYm.dYn), Integer.valueOf(rsVar.dYm.errorCode), Long.valueOf(rsVar.dYm.timestamp));
                    AppMethodBeat.o(202747);
                    return true;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(16972, Long.valueOf(snsAdClick.ece), Integer.valueOf(snsAdClick.jkT), rsVar.dYm.uxInfo, 0, "", rsVar.dYm.url, Integer.valueOf(rsVar.dYm.dYn), Integer.valueOf(rsVar.dYm.errorCode), Long.valueOf(rsVar.dYm.timestamp));
                AppMethodBeat.o(202747);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.SnsCore", e2, "report load ad h5 error", new Object[0]);
            }
        }
    };
    private IListener DLz = new IListener<de>() {
        /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass25 */

        {
            AppMethodBeat.i(160667);
            this.__eventId = de.class.getName().hashCode();
            AppMethodBeat.o(160667);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(de deVar) {
            AppMethodBeat.i(95784);
            aj.fbj();
            AppMethodBeat.o(95784);
            return false;
        }
    };
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private h hqK;
    private byte[] lock = new byte[0];
    private boolean tnN = false;

    static {
        AppMethodBeat.i(95843);
        DKS.put(Integer.valueOf("CanvasInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("UxCanvasInfo".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ac.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSMEDIA_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass23 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return r.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass34 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return n.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass40 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return n.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("ADSNSINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass41 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.sns.storage.c.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSEXT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass42 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.sns.storage.m.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSCOMMENT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass43 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.sns.storage.i.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSTAGINFO_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass44 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return t.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSKVREPORT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return p.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSDRAFT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.sns.storage.k.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSWSFOLDGROUP_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return x.SQL_CREATE;
            }
        });
        DKS.put(Integer.valueOf("SNSWSFOLDDETAIL_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return v.SQL_CREATE;
            }
        });
        AppMethodBeat.o(95843);
    }

    public static String getAccPath() {
        AppMethodBeat.i(95792);
        g.aAf().azk();
        g.aAi();
        String str = g.aAh().hqG;
        AppMethodBeat.o(95792);
        return str;
    }

    public static String fau() {
        AppMethodBeat.i(95793);
        g.aAi();
        String str = (String) g.aAh().azQ().get(2, (Object) null);
        AppMethodBeat.o(95793);
        return str;
    }

    public static int fav() {
        AppMethodBeat.i(95794);
        g.aAi();
        g.aAf();
        int uin = com.tencent.mm.kernel.a.getUin();
        AppMethodBeat.o(95794);
        return uin;
    }

    public static h getDataDB() {
        AppMethodBeat.i(95795);
        h hVar = faw().hqK;
        AppMethodBeat.o(95795);
        return hVar;
    }

    private static aj faw() {
        int i2;
        AppMethodBeat.i(95796);
        aj ajVar = (aj) y.at(aj.class);
        if (!ajVar.DKP) {
            synchronized (ajVar.DKQ) {
                try {
                    if (!ajVar.DKP) {
                        Log.i("MicroMsg.SnsCore", "onAccInit because bug!");
                        ajVar.onAccountPostReset(true);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(95796);
                    throw th;
                }
            }
        }
        if (ajVar.tnN) {
            synchronized (ajVar.lock) {
                try {
                    Log.i("MicroMsg.SnsCore", "getCore need reset DB now " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " " + ajVar.hashCode());
                    if (ajVar.tnN) {
                        ajVar.DKN = false;
                        aa aaVar = ajVar.DKO;
                        HashMap<Integer, h.b> hashMap = DKS;
                        if (aaVar.EmY) {
                            Log.i("MicroMsg.TrimSnsDb", "pass hasTrim");
                        } else {
                            g.aAi();
                            if (g.aAf().azp()) {
                                int i3 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("AndroidCleanSnsDb"), 0);
                                Log.i("MicroMsg.TrimSnsDb", "pass dynamic? ".concat(String.valueOf(i3)));
                                if (i3 <= 0) {
                                    g.aAi();
                                    String str = g.aAh().cachePath;
                                    if (s.YS(str + "SnsMicroMsg2.db.ini")) {
                                        aa.aQM(str);
                                        s.deleteFile(str + "SnsMicroMsg2.db.ini");
                                    }
                                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
                                    if (Util.secondsToNow(sharedPreferences.getLong("check_trim_time", 0)) < 604800) {
                                        Log.i("MicroMsg.TrimSnsDb", "trim sns pass because time short");
                                    } else {
                                        sharedPreferences.edit().putLong("check_trim_time", Util.nowSecond()).commit();
                                        aaVar.EmY = true;
                                        long currentTimeMillis = System.currentTimeMillis();
                                        int ats = com.tencent.mm.p.a.ats();
                                        if (ats == 1 || ats == 2) {
                                            Log.i("MicroMsg.TrimSnsDb", "trim sns error space dangerous");
                                        } else {
                                            if (s.YS(str + "sns_mark.ini")) {
                                                if (Util.milliSecondsToNow(s.boX(str + "sns_mark.ini")) < 2592000000L) {
                                                    Log.i("MicroMsg.TrimSnsDb", "mark file exist and return");
                                                    aa.aQM(str);
                                                } else {
                                                    s.deleteFile(str + "sns_mark.ini");
                                                }
                                            }
                                            long boW = s.boW(str + "SnsMicroMsg.db");
                                            Log.i("MicroMsg.TrimSnsDb", "trim sns ".concat(String.valueOf(boW)));
                                            if (boW < 52428800) {
                                                Log.i("MicroMsg.TrimSnsDb", "trim sns free pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                            } else {
                                                s.bpa(str + "sns_mark.ini");
                                                String str2 = str + "SnsMicroMsg2.db";
                                                h hVar = new h();
                                                if (!hVar.a(str2, (HashMap<Integer, h.b>) null, false)) {
                                                    com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
                                                    AppMethodBeat.o(95796);
                                                    throw bVar;
                                                }
                                                h hVar2 = new h();
                                                if (!hVar2.a(str + "SnsMicroMsg.db", hashMap, true)) {
                                                    com.tencent.mm.model.b bVar2 = new com.tencent.mm.model.b((byte) 0);
                                                    AppMethodBeat.o(95796);
                                                    throw bVar2;
                                                }
                                                long currentTimeMillis2 = System.currentTimeMillis();
                                                if (!aa.a(hVar2, hVar)) {
                                                    i2 = -1;
                                                } else {
                                                    long currentTimeMillis3 = System.currentTimeMillis();
                                                    aa.a(hVar2, hVar, "snsExtInfo3");
                                                    Log.i("MicroMsg.TrimSnsDb", "copysns ret_ext:" + hVar.execSQL("", "insert into " + "snsExtInfo3" + " select * from old." + "snsExtInfo3") + " passed " + (System.currentTimeMillis() - currentTimeMillis3));
                                                    aa.a(hVar2, hVar, "SnsComment");
                                                    Log.i("MicroMsg.TrimSnsDb", "copysns ret_msg:" + hVar.execSQL("", "insert into " + "SnsComment" + " select * from old." + "SnsComment") + " passed " + (System.currentTimeMillis() - currentTimeMillis3));
                                                    aa.a(hVar2, hVar, gk.TABLE_NAME);
                                                    Log.i("MicroMsg.TrimSnsDb", "copysns ret_sns:" + hVar.execSQL("", "insert into " + gk.TABLE_NAME + " select * from old." + gk.TABLE_NAME + " where  (sourceType & 2 != 0 ) " + n.Emu + " limit 200") + " passed " + (System.currentTimeMillis() - currentTimeMillis3));
                                                    Log.i("MicroMsg.TrimSnsDb", "update ext info  passed  %s  updateRet %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3), Boolean.valueOf(hVar.execSQL("", "update snsExtinfo3 set md5 = '', faults = '';")));
                                                    hVar.execSQL("", "DETACH DATABASE old");
                                                    i2 = 1;
                                                }
                                                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis2;
                                                Log.i("MicroMsg.TrimSnsDb", "copysns insert all %d passed ret:".concat(String.valueOf(i2)), Long.valueOf(currentTimeMillis4));
                                                hVar2.closeDB();
                                                hVar.closeDB();
                                                if (i2 >= 0) {
                                                    g.aAi();
                                                    String str3 = g.aAh().cachePath;
                                                    s.deleteFile(str3 + "SnsMicroMsg.db");
                                                    Log.i("MicroMsg.TrimSnsDb", "rename file ".concat(String.valueOf(s.bo(str3, "SnsMicroMsg2.db", "SnsMicroMsg.db"))));
                                                    s.deleteFile(str3 + "SnsMicroMsg.db-shm");
                                                    s.deleteFile(str3 + "SnsMicroMsg.db-wal");
                                                    s.deleteFile(str3 + "SnsMicroMsg.db.ini");
                                                    s.nw("SnsMicroMsg2.db.ini", "SnsMicroMsg.db.ini");
                                                    s.deleteFile(str3 + "SnsMicroMsg2.db.ini");
                                                    s.deleteFile(str3 + "SnsMicroMsg2.db");
                                                    s.deleteFile(str3 + "sns_mark.ini");
                                                }
                                                long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis2;
                                                Log.i("MicroMsg.TrimSnsDb", "copysns data ret=%d all: %d copytime %d ", Integer.valueOf(i2), Long.valueOf(currentTimeMillis5), Long.valueOf(currentTimeMillis5 - currentTimeMillis4));
                                                Log.i("MicroMsg.TrimSnsDb", "trim sns done pass: " + (System.currentTimeMillis() - currentTimeMillis));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (ajVar.hqK == null) {
                            ajVar.hqK = new h();
                            g.aAi();
                            String str4 = g.aAh().cachePath + "SnsMicroMsg.db";
                            if (!ajVar.hqK.a(str4, DKS, true)) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 82);
                                fax();
                                ajVar.hqK = new h();
                                boolean a2 = ajVar.hqK.a(str4, DKS, true);
                                Log.i("MicroMsg.SnsCore", "one more time result:%s:", Boolean.valueOf(a2));
                                if (a2) {
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 83);
                                }
                            }
                        }
                        ajVar.tnN = false;
                        Log.i("MicroMsg.SnsCore", "resetdb done");
                    }
                } finally {
                    AppMethodBeat.o(95796);
                }
            }
        }
        return ajVar;
    }

    private static void fax() {
        AppMethodBeat.i(202764);
        g.aAi();
        String[] list = new File(g.aAh().cachePath).list();
        if (list != null) {
            for (String str : list) {
                Log.i("MicroMsg.SnsCore", "removeDirtyDB file:%s", str);
                if (str != null && str.contains("SnsMicroMsg")) {
                    Log.i("MicroMsg.SnsCore", "removeDirtyDB will delete:%s", str);
                    s.deleteFile(str);
                }
            }
        }
        AppMethodBeat.o(202764);
    }

    public static boolean isInValid() {
        AppMethodBeat.i(95797);
        faw();
        if (!g.aAf().azp()) {
            AppMethodBeat.o(95797);
            return true;
        }
        AppMethodBeat.o(95797);
        return false;
    }

    public aj() {
        AppMethodBeat.i(95798);
        Log.i("MicroMsg.SnsCore", "snscore create! " + Thread.currentThread().getId());
        if (this.DKl == null) {
            this.DKl = com.tencent.f.h.RTc.a("SnsCore_CDNDownload_handler", 6, 6, new LinkedBlockingQueue());
        }
        if (this.CDQ == null) {
            this.CDQ = com.tencent.f.h.RTc.a("SnsCore_thumbDecode_handler", 6, 6, new LinkedBlockingQueue());
        }
        if (this.DKk == null) {
            this.DKk = com.tencent.f.h.RTc.bqp("SnsCore#File");
        }
        if (this.DKm == null) {
            this.DKm = com.tencent.f.h.RTc.bqp("SnsCore#Task");
        }
        if (((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass() > 256 && Build.VERSION.SDK_INT != 24) {
            int i2 = Build.VERSION.SDK_INT;
        }
        AppMethodBeat.o(95798);
    }

    public static MMHandler eJP() {
        AppMethodBeat.i(95799);
        if (DLa == null) {
            DLa = new MMHandler("MicroMsg.SnsCore#WorkingHandler");
        }
        MMHandler mMHandler = DLa;
        AppMethodBeat.o(95799);
        return mMHandler;
    }

    public static ExecutorService fay() {
        AppMethodBeat.i(179089);
        ExecutorService executorService = faw().DKl;
        AppMethodBeat.o(179089);
        return executorService;
    }

    public static ExecutorService faz() {
        AppMethodBeat.i(179090);
        ExecutorService executorService = faw().CDQ;
        AppMethodBeat.o(179090);
        return executorService;
    }

    protected static ExecutorService faA() {
        AppMethodBeat.i(179091);
        ExecutorService executorService = faw().DKk;
        AppMethodBeat.o(179091);
        return executorService;
    }

    public static ExecutorService faB() {
        AppMethodBeat.i(179092);
        ExecutorService executorService = faw().DKm;
        AppMethodBeat.o(179092);
        return executorService;
    }

    public static MMHandler dRd() {
        AppMethodBeat.i(95804);
        MMHandler mMHandler = faw().handler;
        AppMethodBeat.o(95804);
        return mMHandler;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.i(95805);
        String accSnsPath = ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
        AppMethodBeat.o(95805);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.i(95806);
        String accSnsTmpPath = ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
        AppMethodBeat.o(95806);
        return accSnsTmpPath;
    }

    public static String getSnsAdPath() {
        AppMethodBeat.i(95807);
        String snsAdPath = ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getSnsAdPath();
        AppMethodBeat.o(95807);
        return snsAdPath;
    }

    public static bv faC() {
        AppMethodBeat.i(95808);
        g.aAi();
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN();
        AppMethodBeat.o(95808);
        return aSN;
    }

    public static r faD() {
        AppMethodBeat.i(95809);
        g.aAf().azk();
        if (faw().DKp == null) {
            faw().DKp = new r(faw().hqK);
        }
        r rVar = faw().DKp;
        AppMethodBeat.o(95809);
        return rVar;
    }

    public static aq.a faE() {
        AppMethodBeat.i(95810);
        g.aAf().azk();
        if (faw().DKC == null) {
            faw().DKC = new aq.a();
            com.tencent.mm.plugin.sns.b.o.DCR = faw().DKC;
        }
        aq.a aVar = faw().DKC;
        AppMethodBeat.o(95810);
        return aVar;
    }

    public static c faF() {
        AppMethodBeat.i(95811);
        g.aAf().azk();
        if (faw().DKG == null) {
            faw().DKG = new c();
        }
        c cVar = faw().DKG;
        AppMethodBeat.o(95811);
        return cVar;
    }

    public static com.tencent.mm.plugin.sns.h.g faG() {
        AppMethodBeat.i(95812);
        g.aAf().azk();
        if (faw().DKH == null) {
            faw().DKH = new com.tencent.mm.plugin.sns.h.g();
        }
        com.tencent.mm.plugin.sns.h.g gVar = faw().DKH;
        AppMethodBeat.o(95812);
        return gVar;
    }

    public static p faH() {
        AppMethodBeat.i(95813);
        g.aAf().azk();
        if (faw().DKK == null) {
            faw().DKK = new p(faw().hqK);
        }
        p pVar = faw().DKK;
        AppMethodBeat.o(95813);
        return pVar;
    }

    public static m faI() {
        AppMethodBeat.i(95814);
        g.aAf().azk();
        if (faw().DKL == null) {
            faw().DKL = new m();
        }
        m mVar = faw().DKL;
        AppMethodBeat.o(95814);
        return mVar;
    }

    public static c faJ() {
        AppMethodBeat.i(95815);
        g.aAf().azk();
        if (faw().DKD == null) {
            faw().DKD = new c();
        }
        c cVar = faw().DKD;
        AppMethodBeat.o(95815);
        return cVar;
    }

    public static be faK() {
        AppMethodBeat.i(95816);
        g.aAf().azk();
        if (faw().DKE == null) {
            faw().DKE = new be();
            com.tencent.mm.plugin.sns.b.o.DCL = faw().DKE;
        }
        be beVar = faw().DKE;
        AppMethodBeat.o(95816);
        return beVar;
    }

    public static g faL() {
        AppMethodBeat.i(95817);
        g.aAf().azk();
        if (faw().DKu == null) {
            faw().DKu = new g();
            com.tencent.mm.plugin.sns.b.o.DCM = faw().DKu;
        }
        g gVar = faw().DKu;
        AppMethodBeat.o(95817);
        return gVar;
    }

    public static az faM() {
        AppMethodBeat.i(95818);
        g.aAf().azk();
        if (faw().DKV == null) {
            faw().DKV = new az();
        }
        az azVar = faw().DKV;
        AppMethodBeat.o(95818);
        return azVar;
    }

    public static ag faN() {
        AppMethodBeat.i(95819);
        g.aAf().azk();
        if (faw().DKz == null) {
            aj faw = faw();
            StringBuilder sb = new StringBuilder();
            g.aAi();
            faw.DKz = new ag(sb.append(g.aAh().cachePath).append("snsAsyncQueue.data").toString());
        }
        ag agVar = faw().DKz;
        AppMethodBeat.o(95819);
        return agVar;
    }

    public static n faO() {
        AppMethodBeat.i(95820);
        g.aAf().azk();
        if (faw().DKq == null) {
            faw().DKq = new n(faw().hqK);
            com.tencent.mm.plugin.sns.b.o.DCS = faw().DKq;
        }
        n nVar = faw().DKq;
        AppMethodBeat.o(95820);
        return nVar;
    }

    public static b faP() {
        AppMethodBeat.i(95821);
        g.aAf().azk();
        if (faw().DKs == null) {
            faw().DKs = new b(faw().hqK);
        }
        b bVar = faw().DKs;
        AppMethodBeat.o(95821);
        return bVar;
    }

    public static ac faQ() {
        AppMethodBeat.i(95822);
        g.aAf().azk();
        if (faw().DKt == null) {
            faw().DKt = new ac(faw().hqK);
        }
        ac acVar = faw().DKt;
        AppMethodBeat.o(95822);
        return acVar;
    }

    public static com.tencent.mm.plugin.sns.storage.c faR() {
        AppMethodBeat.i(95823);
        g.aAf().azk();
        if (faw().DKr == null) {
            faw().DKr = new com.tencent.mm.plugin.sns.storage.c(faw().hqK);
        }
        com.tencent.mm.plugin.sns.storage.c cVar = faw().DKr;
        AppMethodBeat.o(95823);
        return cVar;
    }

    public static com.tencent.mm.plugin.sns.storage.m faS() {
        AppMethodBeat.i(95824);
        g.aAf().azk();
        if (faw().DKv == null) {
            faw().DKv = new com.tencent.mm.plugin.sns.storage.m(faw().hqK, new al());
            com.tencent.mm.plugin.sns.b.o.DCN = faw().DKv;
        }
        com.tencent.mm.plugin.sns.storage.m mVar = faw().DKv;
        AppMethodBeat.o(95824);
        return mVar;
    }

    public static com.tencent.mm.plugin.sns.storage.i faT() {
        AppMethodBeat.i(95825);
        g.aAf().azk();
        if (faw().DKw == null) {
            faw().DKw = new com.tencent.mm.plugin.sns.storage.i(faw().hqK);
            com.tencent.mm.plugin.sns.b.o.DCO = faw().DKw;
        }
        com.tencent.mm.plugin.sns.storage.i iVar = faw().DKw;
        AppMethodBeat.o(95825);
        return iVar;
    }

    public static t faU() {
        AppMethodBeat.i(95826);
        g.aAf().azk();
        if (faw().DKx == null) {
            faw().DKx = new t(faw().hqK);
            com.tencent.mm.plugin.sns.b.o.DCP = faw().DKx;
        }
        t tVar = faw().DKx;
        AppMethodBeat.o(95826);
        return tVar;
    }

    public static com.tencent.mm.plugin.sns.storage.k faV() {
        AppMethodBeat.i(176273);
        g.aAf().azk();
        if (faw().DKy == null) {
            faw().DKy = new com.tencent.mm.plugin.sns.storage.k(faw().hqK);
        }
        com.tencent.mm.plugin.sns.storage.k kVar = faw().DKy;
        AppMethodBeat.o(176273);
        return kVar;
    }

    public static x faW() {
        AppMethodBeat.i(202765);
        g.aAf().azk();
        if (faw().DKA == null) {
            faw().DKA = new x(faw().hqK);
        }
        x xVar = faw().DKA;
        AppMethodBeat.o(202765);
        return xVar;
    }

    public static v faX() {
        AppMethodBeat.i(202766);
        g.aAf().azk();
        if (faw().DKB == null) {
            faw().DKB = new v(faw().hqK);
        }
        v vVar = faw().DKB;
        AppMethodBeat.o(202766);
        return vVar;
    }

    public static as faY() {
        AppMethodBeat.i(95827);
        g.aAf().azk();
        if (faw().DKF == null) {
            faw().DKF = new as();
        }
        as asVar = faw().DKF;
        AppMethodBeat.o(95827);
        return asVar;
    }

    public static aw faZ() {
        AppMethodBeat.i(179093);
        g.aAf().azk();
        if (faw().DKI == null) {
            faw().DKI = new aw();
        }
        aw awVar = faw().DKI;
        AppMethodBeat.o(179093);
        return awVar;
    }

    public static at fba() {
        AppMethodBeat.i(202767);
        g.aAf().azk();
        if (faw().DKJ == null) {
            faw().DKJ = new at();
        }
        at atVar = faw().DKJ;
        AppMethodBeat.o(202767);
        return atVar;
    }

    public static int fbb() {
        AppMethodBeat.i(95828);
        int fromDPToPix = (ejr().x - a.fromDPToPix(MMApplicationContext.getContext(), DLb)) / 3;
        DKn = fromDPToPix;
        int i2 = fromDPToPix > DLc ? DLc : DKn;
        DKn = i2;
        if (i2 <= 10) {
            Log.e("MicroMsg.SnsCore", "can not get multiThumbDisplaySize or the multiThumbDisplaySize < 10");
            AppMethodBeat.o(95828);
            return 150;
        }
        int i3 = DKn;
        AppMethodBeat.o(95828);
        return i3;
    }

    public static int fbc() {
        AppMethodBeat.i(95829);
        if (DKo <= 0) {
            DKo = 200;
            DKo = a.fromDPToPix(MMApplicationContext.getContext(), DKo);
        }
        int i2 = DKo;
        AppMethodBeat.o(95829);
        return i2;
    }

    public static void k(Point point) {
        imX = point;
    }

    public static Point ejr() {
        AppMethodBeat.i(95830);
        if (imX.x == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            imX.x = displayMetrics.widthPixels;
            imX.y = displayMetrics.heightPixels;
        }
        Point point = imX;
        AppMethodBeat.o(95830);
        return point;
    }

    public static boolean fbd() {
        boolean z;
        AppMethodBeat.i(95831);
        SharedPreferences sharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
        if (sharedPreferences.contains("st_sw_use_vcodec_img")) {
            z = sharedPreferences.getBoolean("st_sw_use_vcodec_img", false);
            Log.w("MicroMsg.SnsCore", "isUseVCodecImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = sharedPreferences.getBoolean("sw_use_vcodec_img", false);
            Log.d("MicroMsg.SnsCore", "isUseVCodecImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(95831);
        return z;
    }

    public static boolean fbe() {
        AppMethodBeat.i(202768);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_download_use_wxam, false);
        AppMethodBeat.o(202768);
        return a2;
    }

    public static boolean fbf() {
        AppMethodBeat.i(202769);
        if (BuildInfo.IS_FLAVOR_RED) {
            AppMethodBeat.o(202769);
            return true;
        }
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_upload_use_wxam, false);
        AppMethodBeat.o(202769);
        return a2;
    }

    public static boolean fbg() {
        boolean z;
        AppMethodBeat.i(95832);
        SharedPreferences sharedPreferences = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "sp_sns_dynswitch_stg", 4, false);
        if (sharedPreferences.contains("st_sw_use_wxpc_img")) {
            z = sharedPreferences.getBoolean("st_sw_use_wxpc_img", false);
            Log.w("MicroMsg.SnsCore", "isUseWxpcImg: %b (set statically outside)", Boolean.valueOf(z));
        } else {
            z = sharedPreferences.getBoolean("sw_use_wxpc_img", false);
            Log.d("MicroMsg.SnsCore", "isUseWxpcImg: %b", Boolean.valueOf(z));
        }
        AppMethodBeat.o(95832);
        return z;
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(95833);
        m faI = faI();
        g.aAi();
        g.aAg().hqi.b(1802, faI);
        as asVar = this.DKM;
        EventCenter.instance.removeListener(asVar.DML);
        EventCenter.instance.removeListener(asVar.DMM);
        EventCenter.instance.removeListener(asVar.DMN);
        EventCenter.instance.removeListener(this.DLF);
        EventCenter.instance.removeListener(this.DLG);
        EventCenter.instance.removeListener(this.DLE);
        EventCenter.instance.removeListener(this.DLD);
        EventCenter.instance.removeListener(this.DLs);
        EventCenter.instance.removeListener(this.DLq);
        EventCenter.instance.removeListener(this.DLr);
        EventCenter.instance.removeListener(this.DLt);
        EventCenter.instance.removeListener(this.DLu);
        EventCenter.instance.removeListener(this.DLv);
        EventCenter.instance.removeListener(this.DLg);
        EventCenter.instance.removeListener(this.DLh);
        EventCenter.instance.removeListener(this.DLx);
        EventCenter.instance.removeListener(this.DLz);
        appForegroundListener.dead();
        EventCenter.instance.removeListener(this.DLd);
        EventCenter.instance.removeListener(this.DLe);
        EventCenter.instance.removeListener(this.DLf);
        EventCenter.instance.removeListener(this.DLi);
        EventCenter.instance.removeListener(this.DLj);
        EventCenter.instance.removeListener(this.DLk);
        EventCenter.instance.removeListener(this.DLl);
        EventCenter.instance.removeListener(this.DLm);
        EventCenter.instance.removeListener(this.DLn);
        EventCenter.instance.removeListener(this.DLw);
        EventCenter.instance.removeListener(this.DKT);
        EventCenter.instance.removeListener(this.DLA);
        EventCenter.instance.removeListener(this.DLB);
        EventCenter.instance.removeListener(this.AgM);
        EventCenter.instance.removeListener(this.DLI);
        EventCenter.instance.removeListener(this.DLC);
        EventCenter.instance.removeListener(this.DLo);
        EventCenter.instance.removeListener(this.DLp);
        EventCenter.instance.removeListener(this.DLJ);
        EventCenter.instance.removeListener(this.DLy);
        EventCenter.instance.removeListener(this.DLK);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = a.e.DXp;
        if (aVar.DXi) {
            try {
                Log.w("MicroMsg.AdDownloadApkMgr", "clearCallback, unregister package receiver");
                MMApplicationContext.getContext().unregisterReceiver(aVar.DXh);
                aVar.DXi = false;
            } catch (IllegalArgumentException e2) {
                Log.e("MicroMsg.AdDownloadApkMgr", "unregister install receiver exception", e2.getMessage());
            }
        }
        com.tencent.mm.plugin.downloader.model.f.cBv();
        com.tencent.mm.plugin.downloader.model.c.b(aVar.DXm);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewYearSNSCtrl2016", this.DKW, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewYearSNSTips2016", this.DKX, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("NewYearSNSAmountLevelCtrl2016", this.DKY, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("SnsAd", this.DKZ, true);
        faw().handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(202734);
                aj.faK().b(aj.this.DLL);
                AppMethodBeat.o(202734);
            }
        });
        be faK = faK();
        g.aAi();
        g.aAg().hqi.b(207, faK);
        g.aAi();
        g.aAg().hqi.b(209, faK);
        aj ajVar = (aj) y.at(aj.class);
        if (ajVar != null) {
            Log.d("MicroMsg.SnsCore", "SnsCore close db");
            if (ajVar.hqK != null) {
                ajVar.hqK.closeDB();
                ajVar.hqK = null;
            }
            if (ajVar.DKl != null) {
                ajVar.DKl.shutdownNow();
            }
            if (ajVar.CDQ != null) {
                ajVar.CDQ.shutdownNow();
            }
            if (ajVar.DKk != null) {
                ajVar.DKk.shutdownNow();
            }
            if (ajVar.DKm != null) {
                ajVar.DKm.shutdownNow();
            }
        }
        com.tencent.mm.plugin.sns.g.a aVar2 = this.DKU;
        faJ().b(aVar2);
        EventCenter.instance.removeListener(aVar2.DFm);
        au.unInit();
        com.tencent.mm.memory.g.ity.aRR();
        com.tencent.mm.memory.c.itr.aRR();
        com.tencent.mm.memory.o.itM.aRR();
        az faM = faM();
        faM.DOh = null;
        synchronized (faM.DOl) {
            try {
                faM.DOl.clear();
            } finally {
                AppMethodBeat.o(95833);
            }
        }
        faM.DOj.clear();
        faM.DOi.clear();
        synchronized (faM.DOk) {
            try {
                faM.DOk.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        EventCenter.instance.removeListener(faM.DOo);
        EventCenter.instance.removeListener(faM.DMM);
        EventCenter.instance.removeListener(faM.DMN);
        com.tencent.mm.plugin.sns.f.a.destroy();
        AppMethodBeat.o(95833);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(95834);
        Log.i("MicroMsg.SnsCore", "onAccountPostReset " + Thread.currentThread().getId() + " isAccInit: " + this.DKP);
        if (this.DKP) {
            AppMethodBeat.o(95834);
            return;
        }
        this.DKP = true;
        this.tnN = true;
        checkDir();
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSCtrl2016", (cj.a) this.DKW, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSTips2016", (cj.a) this.DKX, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("NewYearSNSAmountLevelCtrl2016", (cj.a) this.DKY, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("SnsAd", (cj.a) this.DKZ, true);
        com.tencent.mm.plugin.sns.b.o.DCL = faK();
        com.tencent.mm.plugin.sns.b.o.DCM = faL();
        com.tencent.mm.plugin.sns.b.o.DCN = faS();
        com.tencent.mm.plugin.sns.b.o.DCO = faT();
        com.tencent.mm.plugin.sns.b.o.DCP = faU();
        com.tencent.mm.plugin.sns.b.o.DCR = faE();
        com.tencent.mm.plugin.sns.b.o.DCQ = this;
        com.tencent.mm.plugin.sns.b.o.DCS = faO();
        EventCenter.instance.addListener(this.DLF);
        EventCenter.instance.addListener(this.DLG);
        EventCenter.instance.addListener(this.DLs);
        EventCenter.instance.addListener(this.DLq);
        EventCenter.instance.addListener(this.DLr);
        EventCenter.instance.addListener(this.DLt);
        EventCenter.instance.addListener(this.DLu);
        EventCenter.instance.addListener(this.DLv);
        EventCenter.instance.addListener(this.DLw);
        EventCenter.instance.addListener(this.DLx);
        EventCenter.instance.addListener(this.DLz);
        EventCenter.instance.addListener(this.DLA);
        EventCenter.instance.addListener(this.DLB);
        EventCenter.instance.addListener(this.DLJ);
        EventCenter.instance.addListener(this.DLK);
        appForegroundListener.alive();
        this.DLd = new com.tencent.mm.plugin.sns.n();
        this.DLe = new com.tencent.mm.plugin.sns.k();
        this.DLf = new com.tencent.mm.plugin.sns.e();
        this.DLg = new q();
        this.DLh = new com.tencent.mm.plugin.sns.h();
        this.DLi = new com.tencent.mm.plugin.sns.g();
        this.DLj = new com.tencent.mm.plugin.sns.m();
        this.DLk = new com.tencent.mm.plugin.sns.j();
        this.DLl = new com.tencent.mm.plugin.sns.b();
        this.DLm = new com.tencent.mm.plugin.sns.c();
        this.DLn = new com.tencent.mm.plugin.sns.f();
        EventCenter.instance.addListener(this.DLE);
        EventCenter.instance.addListener(this.DLD);
        EventCenter.instance.addListener(this.DLg);
        EventCenter.instance.addListener(this.DLd);
        EventCenter.instance.addListener(this.DLe);
        EventCenter.instance.addListener(this.DLf);
        EventCenter.instance.addListener(this.DLh);
        EventCenter.instance.addListener(this.DLi);
        EventCenter.instance.addListener(this.DLj);
        EventCenter.instance.addListener(this.DLk);
        EventCenter.instance.addListener(this.DLl);
        EventCenter.instance.addListener(this.DLm);
        EventCenter.instance.addListener(this.DLn);
        EventCenter.instance.addListener(this.AgM);
        this.DKT = new d();
        EventCenter.instance.addListener(this.DKT);
        EventCenter.instance.addListener(this.DLI);
        EventCenter.instance.addListener(this.DLo);
        EventCenter.instance.addListener(this.DLp);
        EventCenter.instance.addListener(this.DLC);
        EventCenter.instance.addListener(this.DLy);
        m faI = faI();
        m.Dwb = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog2GSendSize", 20480);
        m.Dwc = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLog3GSendSize", 30720);
        m.Dwd = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogWifiSendSize", 51200);
        m.Dwe = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMinRandTime", 60);
        m.Dwf = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMaxRandTime", 1800);
        m.Dwg = com.tencent.mm.n.h.aqJ().getInt("MMUxAdLogMaxExceptionTime", 43200);
        Log.i("MicroMsg.SnsLogMgr", "init " + m.Dwb + ";" + m.Dwc + ";" + m.Dwd + ";" + m.Dwe + ";" + m.Dwf + ";" + m.Dwg);
        if (m.Dwf - m.Dwe < 0) {
            m.Dwf = m.Dwe;
        }
        g.aAi();
        g.aAg().hqi.a(1802, faI);
        be faK = faK();
        g.aAi();
        g.aAg().hqi.a(207, faK);
        g.aAi();
        g.aAg().hqi.a(209, faK);
        as asVar = this.DKM;
        EventCenter.instance.addListener(asVar.DML);
        EventCenter.instance.addListener(asVar.DMM);
        EventCenter.instance.addListener(asVar.DMN);
        this.DKU = new com.tencent.mm.plugin.sns.g.a();
        au.init();
        com.tencent.mm.modelsns.l lVar = com.tencent.mm.modelsns.l.jlw;
        com.tencent.mm.modelsns.l.bfL();
        ah.far();
        if (com.tencent.mm.memory.l.aRZ()) {
            com.tencent.mm.memory.c cVar = com.tencent.mm.memory.c.itr;
            com.tencent.mm.memory.c cVar2 = com.tencent.mm.memory.c.itr;
            cVar2.getClass();
            cVar.a(new com.tencent.mm.memory.e<Bitmap, Integer>.a(cVar2) {
                /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass8 */
                final int DLN = 120;

                {
                    r4.getClass();
                    AppMethodBeat.i(202737);
                    AppMethodBeat.o(202737);
                }

                @Override // com.tencent.mm.memory.e.a
                public final long aRU() {
                    return 10485760;
                }

                @Override // com.tencent.mm.memory.e.a
                public final int aRV() {
                    return -1;
                }

                @Override // com.tencent.mm.memory.e.a
                public final /* synthetic */ Comparable aRT() {
                    AppMethodBeat.i(202738);
                    Integer valueOf = Integer.valueOf(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 120) * com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 120));
                    AppMethodBeat.o(202738);
                    return valueOf;
                }
            });
        }
        com.tencent.mm.memory.o oVar = com.tencent.mm.memory.o.itM;
        com.tencent.mm.memory.o oVar2 = com.tencent.mm.memory.o.itM;
        oVar2.getClass();
        oVar.a(new com.tencent.mm.memory.e<Bitmap, o.b>.a(oVar2) {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass9 */

            {
                r3.getClass();
                AppMethodBeat.i(202739);
                AppMethodBeat.o(202739);
            }

            @Override // com.tencent.mm.memory.e.a
            public final long aRU() {
                return -1;
            }

            @Override // com.tencent.mm.memory.e.a
            public final int aRV() {
                return 3;
            }

            @Override // com.tencent.mm.memory.e.a
            public final /* synthetic */ Comparable aRT() {
                AppMethodBeat.i(202740);
                o.b bVar = new o.b(320, 240);
                AppMethodBeat.o(202740);
                return bVar;
            }
        });
        com.tencent.mm.memory.g gVar = com.tencent.mm.memory.g.ity;
        com.tencent.mm.memory.g gVar2 = com.tencent.mm.memory.g.ity;
        gVar2.getClass();
        gVar.a(new com.tencent.mm.memory.e<byte[], Integer>.a(gVar2) {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass10 */

            {
                r3.getClass();
                AppMethodBeat.i(202741);
                AppMethodBeat.o(202741);
            }

            @Override // com.tencent.mm.memory.e.a
            public final long aRU() {
                return 0;
            }

            @Override // com.tencent.mm.memory.e.a
            public final int aRV() {
                return 5;
            }

            @Override // com.tencent.mm.memory.e.a
            public final /* synthetic */ Comparable aRT() {
                AppMethodBeat.i(202742);
                AppMethodBeat.o(202742);
                return 1024;
            }
        });
        faM();
        com.tencent.mm.plugin.sns.f.a.init();
        try {
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("TrackDataSource");
            if (!Util.isNullOrNil(mmkv.getString("path", ""))) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(150, 74);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17832, Integer.valueOf(mmkv.getInt("type", 0)), mmkv.getString("path", ""), Long.valueOf(mmkv.getLong("ts", 0)), mmkv.getString("media-url", ""), mmkv.getString("thumb-url", ""), Long.valueOf(mmkv.getLong("prepare-ts", 0)), mmkv.getString("prepare-path", ""));
                mmkv.putInt("type", 0);
                mmkv.putString("path", "");
                mmkv.putLong("ts", 0);
                mmkv.putString("media-url", "");
                mmkv.putString("thumb-url", "");
                mmkv.putLong("prepare-ts", 0);
                mmkv.commit();
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.SnsCore", th, "videoCrashKvReport", new Object[0]);
        }
        faw().handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass11 */

            {
                AppMethodBeat.i(160655);
                AppMethodBeat.o(160655);
            }

            public final void run() {
                AppMethodBeat.i(202743);
                aj.faK().a(aj.this.DLL);
                AppMethodBeat.o(202743);
            }
        });
        AppMethodBeat.o(95834);
    }

    private static void checkDir() {
        AppMethodBeat.i(95835);
        s.boN(((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath());
        s.boN(((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath());
        s.bpc(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.few());
        AppMethodBeat.o(95835);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
        AppMethodBeat.i(95836);
        checkDir();
        AppMethodBeat.o(95836);
    }

    @Override // com.tencent.mm.plugin.sns.b.k
    public final void a(bb bbVar) {
        AppMethodBeat.i(95837);
        v.a(bbVar);
        AppMethodBeat.o(95837);
    }

    @Override // com.tencent.mm.plugin.sns.b.k
    public final void b(bb bbVar) {
        AppMethodBeat.i(95838);
        v.b(bbVar);
        AppMethodBeat.o(95838);
    }

    public static String fbh() {
        AppMethodBeat.i(95839);
        if (Util.isNullOrNil(DKR)) {
            Iterator<SdcardUtil.StatMountParse> it = SdcardUtil.getWritableStatMountParseForStorage().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SdcardUtil.StatMountParse next = it.next();
                if (com.tencent.mm.loader.j.b.aKD().equals(next.mountDir)) {
                    DKR = next.fileSystem;
                    break;
                }
            }
            Log.i("MicroMsg.SnsCore", "get filesys " + DKR);
        }
        String nullAs = Util.nullAs(DKR, "");
        AppMethodBeat.o(95839);
        return nullAs;
    }

    public static void fbi() {
        long j2;
        Throwable th;
        Exception e2;
        com.tencent.mm.plugin.sns.storage.m faS;
        long j3;
        Throwable th2;
        Exception e3;
        v faX;
        long j4;
        Throwable th3;
        Exception e4;
        x faW;
        long j5 = 0;
        AppMethodBeat.i(202770);
        MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVDeleteTable", true);
        n faO = faO();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            j2 = faO.iFy.beginTransaction(-1);
            try {
                faO.iFy.execSQL(gk.TABLE_NAME, "DROP TABLE SnsInfo");
                faO.iFy.execSQL(gk.TABLE_NAME, n.SQL_CREATE[0]);
                faO.iFy.endTransaction(j2);
            } catch (Exception e5) {
                e2 = e5;
                try {
                    Log.e("MicroMsg.SnsInfoStorage", "drop table Error :" + e2.getMessage());
                    faO.iFy.endTransaction(j2);
                    Log.i("MicroMsg.SnsInfoStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    faS = faS();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    j3 = faS.iFy.beginTransaction(-1);
                    try {
                        faS.iFy.execSQL("snsExtInfo3", "DROP TABLE snsExtInfo3");
                        faS.iFy.execSQL("snsExtInfo3", com.tencent.mm.plugin.sns.storage.m.SQL_CREATE[0]);
                        faS.iFy.endTransaction(j3);
                    } catch (Exception e6) {
                        e3 = e6;
                        try {
                            Log.e("MicroMsg.SnsExtStorage", "drop table Error :" + e3.getMessage());
                            faS.iFy.endTransaction(j3);
                            Log.i("MicroMsg.SnsExtStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            faX = faX();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            j4 = faX.iFy.beginTransaction(-1);
                            faX.iFy.execSQL("SnsWsFoldGroupDetail", "DROP TABLE SnsWsFoldGroupDetail");
                            faX.iFy.execSQL("SnsWsFoldGroupDetail", v.SQL_CREATE[0]);
                            faX.EmT.clear();
                            faX.iFy.endTransaction(j4);
                            Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                            faW = faW();
                            long currentTimeMillis4 = System.currentTimeMillis();
                            j5 = faW.iFy.beginTransaction(-1);
                            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
                            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
                            faW.iFy.endTransaction(j5);
                            Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis4));
                            com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
                            AppMethodBeat.o(202770);
                        } catch (Throwable th4) {
                            th2 = th4;
                            faS.iFy.endTransaction(j3);
                            AppMethodBeat.o(202770);
                            throw th2;
                        }
                    }
                    Log.i("MicroMsg.SnsExtStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    faX = faX();
                    long currentTimeMillis32 = System.currentTimeMillis();
                    j4 = faX.iFy.beginTransaction(-1);
                    try {
                        faX.iFy.execSQL("SnsWsFoldGroupDetail", "DROP TABLE SnsWsFoldGroupDetail");
                        faX.iFy.execSQL("SnsWsFoldGroupDetail", v.SQL_CREATE[0]);
                        faX.EmT.clear();
                        faX.iFy.endTransaction(j4);
                    } catch (Exception e7) {
                        e4 = e7;
                        try {
                            Log.e("MicroMsg.SnsWsFoldDetailStorage", "drop table Error :" + e4.getMessage());
                            faX.iFy.endTransaction(j4);
                            Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis32));
                            faW = faW();
                            long currentTimeMillis42 = System.currentTimeMillis();
                            j5 = faW.iFy.beginTransaction(-1);
                            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
                            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
                            faW.iFy.endTransaction(j5);
                            Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis42));
                            com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
                            AppMethodBeat.o(202770);
                        } catch (Throwable th5) {
                            th3 = th5;
                            faX.iFy.endTransaction(j4);
                            AppMethodBeat.o(202770);
                            throw th3;
                        }
                    }
                    Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis32));
                    faW = faW();
                    long currentTimeMillis422 = System.currentTimeMillis();
                    j5 = faW.iFy.beginTransaction(-1);
                    faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
                    faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
                    faW.iFy.endTransaction(j5);
                    Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis422));
                    com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
                    AppMethodBeat.o(202770);
                } catch (Throwable th6) {
                    th = th6;
                    faO.iFy.endTransaction(j2);
                    AppMethodBeat.o(202770);
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            j2 = 0;
            Log.e("MicroMsg.SnsInfoStorage", "drop table Error :" + e2.getMessage());
            faO.iFy.endTransaction(j2);
            Log.i("MicroMsg.SnsInfoStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            faS = faS();
            long currentTimeMillis22 = System.currentTimeMillis();
            j3 = faS.iFy.beginTransaction(-1);
            faS.iFy.execSQL("snsExtInfo3", "DROP TABLE snsExtInfo3");
            faS.iFy.execSQL("snsExtInfo3", com.tencent.mm.plugin.sns.storage.m.SQL_CREATE[0]);
            faS.iFy.endTransaction(j3);
            Log.i("MicroMsg.SnsExtStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis22));
            faX = faX();
            long currentTimeMillis322 = System.currentTimeMillis();
            j4 = faX.iFy.beginTransaction(-1);
            faX.iFy.execSQL("SnsWsFoldGroupDetail", "DROP TABLE SnsWsFoldGroupDetail");
            faX.iFy.execSQL("SnsWsFoldGroupDetail", v.SQL_CREATE[0]);
            faX.EmT.clear();
            faX.iFy.endTransaction(j4);
            Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis322));
            faW = faW();
            long currentTimeMillis4222 = System.currentTimeMillis();
            j5 = faW.iFy.beginTransaction(-1);
            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
            faW.iFy.endTransaction(j5);
            Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis4222));
            com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
            AppMethodBeat.o(202770);
        } catch (Throwable th7) {
            th = th7;
            j2 = 0;
            faO.iFy.endTransaction(j2);
            AppMethodBeat.o(202770);
            throw th;
        }
        Log.i("MicroMsg.SnsInfoStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        faS = faS();
        long currentTimeMillis222 = System.currentTimeMillis();
        try {
            j3 = faS.iFy.beginTransaction(-1);
            faS.iFy.execSQL("snsExtInfo3", "DROP TABLE snsExtInfo3");
            faS.iFy.execSQL("snsExtInfo3", com.tencent.mm.plugin.sns.storage.m.SQL_CREATE[0]);
            faS.iFy.endTransaction(j3);
        } catch (Exception e9) {
            e3 = e9;
            j3 = 0;
            Log.e("MicroMsg.SnsExtStorage", "drop table Error :" + e3.getMessage());
            faS.iFy.endTransaction(j3);
            Log.i("MicroMsg.SnsExtStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis222));
            faX = faX();
            long currentTimeMillis3222 = System.currentTimeMillis();
            j4 = faX.iFy.beginTransaction(-1);
            faX.iFy.execSQL("SnsWsFoldGroupDetail", "DROP TABLE SnsWsFoldGroupDetail");
            faX.iFy.execSQL("SnsWsFoldGroupDetail", v.SQL_CREATE[0]);
            faX.EmT.clear();
            faX.iFy.endTransaction(j4);
            Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3222));
            faW = faW();
            long currentTimeMillis42222 = System.currentTimeMillis();
            j5 = faW.iFy.beginTransaction(-1);
            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
            faW.iFy.endTransaction(j5);
            Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis42222));
            com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
            AppMethodBeat.o(202770);
        } catch (Throwable th8) {
            th2 = th8;
            j3 = 0;
            faS.iFy.endTransaction(j3);
            AppMethodBeat.o(202770);
            throw th2;
        }
        Log.i("MicroMsg.SnsExtStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis222));
        faX = faX();
        long currentTimeMillis32222 = System.currentTimeMillis();
        try {
            j4 = faX.iFy.beginTransaction(-1);
            faX.iFy.execSQL("SnsWsFoldGroupDetail", "DROP TABLE SnsWsFoldGroupDetail");
            faX.iFy.execSQL("SnsWsFoldGroupDetail", v.SQL_CREATE[0]);
            faX.EmT.clear();
            faX.iFy.endTransaction(j4);
        } catch (Exception e10) {
            e4 = e10;
            j4 = 0;
            Log.e("MicroMsg.SnsWsFoldDetailStorage", "drop table Error :" + e4.getMessage());
            faX.iFy.endTransaction(j4);
            Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis32222));
            faW = faW();
            long currentTimeMillis422222 = System.currentTimeMillis();
            j5 = faW.iFy.beginTransaction(-1);
            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
            faW.iFy.endTransaction(j5);
            Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis422222));
            com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
            AppMethodBeat.o(202770);
        } catch (Throwable th9) {
            th3 = th9;
            j4 = 0;
            faX.iFy.endTransaction(j4);
            AppMethodBeat.o(202770);
            throw th3;
        }
        Log.i("MicroMsg.SnsWsFoldDetailStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis32222));
        faW = faW();
        long currentTimeMillis4222222 = System.currentTimeMillis();
        try {
            j5 = faW.iFy.beginTransaction(-1);
            faW.iFy.execSQL("SnsWsFoldGroup", "DROP TABLE SnsWsFoldGroup");
            faW.iFy.execSQL("SnsWsFoldGroup", x.SQL_CREATE[0]);
            faW.iFy.endTransaction(j5);
        } catch (Exception e11) {
            Log.e("MicroMsg.SnsWsFoldGroupStorage", "drop table Error :" + e11.getMessage());
            faW.iFy.endTransaction(j5);
        } catch (Throwable th10) {
            faW.iFy.endTransaction(j5);
            AppMethodBeat.o(202770);
            throw th10;
        }
        Log.i("MicroMsg.SnsWsFoldGroupStorage", "deleteTable cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis4222222));
        com.tencent.mm.plugin.sns.b.o.DCR.a(2, z.aTY(), true, 0);
        AppMethodBeat.o(202770);
    }

    static /* synthetic */ void b(aj ajVar) {
        AppMethodBeat.i(202771);
        if (!ajVar.DLH) {
            faw().DKm.execute(new Runnable() {
                /* class com.tencent.mm.plugin.sns.model.aj.AnonymousClass33 */

                public final void run() {
                    AppMethodBeat.i(202750);
                    aj.c(aj.this);
                    AppMethodBeat.o(202750);
                }
            });
        }
        AppMethodBeat.o(202771);
    }

    static /* synthetic */ void fbj() {
        int i2;
        int i3;
        AppMethodBeat.i(202772);
        Log.i("MicroMsg.SnsCore", "dumptable");
        StringBuffer stringBuffer = new StringBuffer();
        long feV = faO().feV();
        r faD = faD();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = faD.iFy.rawQuery("select count(*) from SnsMedia", null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        } else {
            i2 = 0;
        }
        rawQuery.close();
        Log.i("MicroMsg.snsMediaStorage", "media table count %d passed %d", Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.plugin.sns.storage.m faS = faS();
        long currentTimeMillis2 = System.currentTimeMillis();
        Cursor rawQuery2 = faS.iFy.rawQuery("select count(*) from snsExtInfo3", null, 2);
        if (rawQuery2.moveToFirst()) {
            i3 = rawQuery2.getInt(0);
        } else {
            i3 = 0;
        }
        rawQuery2.close();
        Log.i("MicroMsg.SnsExtStorage", "ext table count %d passed %d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        stringBuffer.append(" snscount ".concat(String.valueOf(feV)));
        stringBuffer.append(" mediacount ".concat(String.valueOf(i2)));
        stringBuffer.append(" extcount ".concat(String.valueOf(i3)));
        Log.i("MicroMsg.SnsCore", "dump table " + stringBuffer.toString());
        AppMethodBeat.o(202772);
    }

    static /* synthetic */ String c(aj ajVar) {
        com.tencent.mm.vfs.o[] het;
        AppMethodBeat.i(202773);
        if (ajVar.DLH) {
            AppMethodBeat.o(202773);
            return "";
        }
        ajVar.DLH = true;
        com.tencent.mm.vfs.o[] het2 = new com.tencent.mm.vfs.o(getAccSnsPath()).het();
        Log.i("MicroMsg.SnsCore", "snscheckfile start");
        long j2 = 0;
        for (com.tencent.mm.vfs.o oVar : het2) {
            com.tencent.mm.vfs.o[] het3 = oVar.het();
            if (het3 != null) {
                for (int i2 = 0; i2 < het3.length; i2++) {
                    String[] list = het3[i2].list();
                    if (!(list == null || (het = het3[i2].het()) == null)) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (com.tencent.mm.vfs.o oVar2 : het) {
                            j2 += oVar2.length();
                            String str = com.tencent.mm.vfs.aa.z(oVar2.her()) + " " + oVar2.length() + " " + oVar2.lastModified() + " " + ((String) DateFormat.format("yyyy-M-d kk:mm", oVar2.lastModified()));
                            stringBuffer.append(str + APLogFileUtil.SEPARATOR_LINE);
                            Log.i("MicroMsg.SnsCore", str);
                        }
                        Log.i("MicroMsg.SnsCore", "filepath %s %d", com.tencent.mm.vfs.aa.z(het3[i2].her()), Integer.valueOf(list.length));
                    }
                }
            }
        }
        Log.i("MicroMsg.SnsCore", "snscheckfile end ".concat(String.valueOf(j2)));
        ajVar.DLH = false;
        AppMethodBeat.o(202773);
        return "";
    }
}
