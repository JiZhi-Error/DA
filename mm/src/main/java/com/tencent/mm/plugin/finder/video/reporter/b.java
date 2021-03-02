package com.tencent.mm.plugin.finder.video.reporter;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.en;
import com.tencent.mm.g.b.a.lg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    private static final LinkedList<aqj> whI = new LinkedList<>();
    private static final LinkedList<aqj> whJ = new LinkedList<>();
    public static final a whK = new a((byte) 0);
    public bbn ttO;
    public ConcurrentLinkedDeque<C1322b> whE = new ConcurrentLinkedDeque<>();
    public ConcurrentHashMap<Long, C1322b> whF = new ConcurrentHashMap<>();
    public com.tencent.mm.plugin.finder.video.statistics.a whG = new com.tencent.mm.plugin.finder.video.statistics.a("Finder.Stat.FirstFrame");
    private final int whH = 1505;

    public b(bbn bbn) {
        p.h(bbn, "contextObj");
        AppMethodBeat.i(254542);
        this.ttO = bbn;
        AppMethodBeat.o(254542);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254543);
        AppMethodBeat.o(254543);
    }

    /* renamed from: com.tencent.mm.plugin.finder.video.reporter.b$b */
    public static final class C1322b {
        public boolean bfW;
        public int frameRate;
        public int jpW;
        public int mEd;
        public String mediaPath = "";
        public long njx;
        public int playDecoderType;
        public String sessionId = "";
        public int tHQ;
        public long veh;
        public long vgm;
        public long vgn;
        public long vgo;
        public int vgq;
        public int vgr;
        public int vgu;
        public int vgv;
        public long whL;
        public String whM = "";
        public String whN = "";
        public String whO = "";
        public s whP;
        public cjl whQ;
        public long whR;
        public int whS;
        public int whT;
        public long whU;
        public int whV;
        public int whW;
        public int whX;
        public long whY;
        public long whZ;
        public float wiA;
        public float wiB;
        public int wiC;
        public int wiD = -1;
        public int wiE = -1;
        public int wiF = -1;
        public String wiG = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        public int wiH = -1;
        public long wia;
        public String wib = "";
        public long wic;
        public int wid;
        public int wie;
        public boolean wif;
        public int wig;
        public long wih;
        public long wii;
        public long wij;
        public int wik;
        public long wil;
        public long wim;
        public long win;
        public long wio;
        d wip;
        public c wiq;
        public boolean wir;
        public long wis;
        public LinkedList<bek> wit = new LinkedList<>();
        public HashSet<Integer> wiu = new HashSet<>();
        int wiv;
        String wiw = "";
        public int wix;
        public int wiy;
        public String wiz = "";

        public C1322b() {
            AppMethodBeat.i(254523);
            AppMethodBeat.o(254523);
        }

        public final void awK(String str) {
            AppMethodBeat.i(254522);
            p.h(str, "<set-?>");
            this.wiw = str;
            AppMethodBeat.o(254522);
        }
    }

    public static String a(String str, C1322b bVar) {
        AppMethodBeat.i(254535);
        String str2 = str + " feedId:" + com.tencent.mm.ac.d.zs(bVar.whL) + " mediaId:" + bVar.whM + " position:" + bVar.whS + " bgPreparedStatus:" + bVar.tHQ;
        AppMethodBeat.o(254535);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0065 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.finder.event.c.a r12) {
        /*
        // Method dump skipped, instructions count: 296
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.reporter.b.a(com.tencent.mm.plugin.finder.event.c$a):void");
    }

    public final void a(C1322b bVar) {
        String str;
        long j2;
        long j3;
        long j4;
        String H;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(254537);
        Log.i("Finder.FinderVideoPlayReporter", bVar != null ? String.valueOf(a("report19059", bVar)) : null);
        if (bVar == null) {
            AppMethodBeat.o(254537);
        } else if (bVar.whL == 0) {
            AppMethodBeat.o(254537);
        } else {
            s sVar = bVar.whP;
            if (sVar != null) {
                en enVar = new en();
                enVar.afI();
                enVar.rp(sVar.auA());
                enVar.mN((long) this.ttO.tCE);
                enVar.mj((long) sVar.uIw.videoDuration);
                enVar.mk(bVar.vgo);
                enVar.ml((long) bVar.whW);
                enVar.mm((long) bVar.whX);
                enVar.mn((long) sVar.uIw.fileSize);
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                if (sVar != null) {
                    str = sVar.auA();
                } else {
                    str = null;
                }
                at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str);
                if (avH != null) {
                    enVar.mn(avH.field_totalSize);
                    x xVar = x.SXb;
                }
                enVar.mo(bVar.whU);
                enVar.mp((long) bVar.whV);
                enVar.mq(bVar.whY);
                if (this.ttO.wzb) {
                    k kVar = k.vfA;
                    bm Fd = k.Fd(bVar.whL);
                    if (Fd != null) {
                        j2 = Fd.lT();
                    } else {
                        j2 = 0;
                    }
                } else {
                    j2 = bVar.whL;
                }
                en mx = enVar.mr(bVar.whZ).ms(bVar.wia).mt(bVar.njx).rq(bVar.wib).rr(bVar.sessionId).mu((long) bVar.whS).afL().mv((long) bVar.mEd).mw((long) bVar.wid).mx((long) bVar.wie);
                if (BuildInfo.DEBUG) {
                    j3 = 0;
                } else {
                    j3 = 59;
                }
                mx.my(j3).mz((long) bVar.jpW).mA((long) bVar.wig).mB(bVar.wih).mC(bVar.vgm).mD(bVar.wij).rs(com.tencent.mm.ac.d.zs(j2)).mE((long) bVar.wik).mF(bVar.win);
                if (this.ttO.wzb) {
                    enVar.rJ(com.tencent.mm.ac.d.zs(bVar.whL));
                }
                c cVar = bVar.wiq;
                if (cVar != null) {
                    enVar.mH((long) cVar.averageSpeed);
                    enVar.mK((long) cVar.averageConnectCost);
                    enVar.ru(cVar.wiK);
                    enVar.mL((long) cVar.wiL);
                    enVar.lf(cVar.retCode);
                    x xVar2 = x.SXb;
                }
                enVar.mR(bVar.wim);
                enVar.lg(bVar.wiC);
                if (bVar.vgu != bVar.vgv) {
                    bVar.wiv = 1;
                } else {
                    bVar.wiv = 0;
                }
                Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                    AppMethodBeat.o(254537);
                    throw tVar;
                }
                int streamMaxVolume = ((AudioManager) systemService).getStreamMaxVolume(3);
                enVar.rz(new StringBuilder().append((bVar.vgu * 100) / streamMaxVolume).append(';').append((bVar.vgv * 100) / streamMaxVolume).append(';').append(bVar.wiv).toString());
                JSONArray jSONArray = new JSONArray();
                for (T t : whI) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pos", t.whS);
                        jSONObject.put("spe", t.LCu);
                        jSONObject.put("loadCost", t.LCw);
                        jSONObject.put("fSize", t.LCr);
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                    }
                }
                String jSONArray2 = jSONArray.toString();
                p.g(jSONArray2, "historyInfoArray.toString()");
                enVar.rt(n.j(jSONArray2, ",", ";", false));
                enVar.mG(bVar.wio);
                enVar.mI(bVar.wic);
                enVar.mJ(bVar.wis);
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
                p.g(ah, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
                if (((com.tencent.mm.plugin.thumbplayer.a.a) ah).isOpenTPPlayer()) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                enVar.mM(j4);
                enVar.mO((long) bVar.vgr);
                enVar.mP((long) bVar.vgq);
                enVar.rA(bVar.wiz + ';' + bVar.wix + ';' + bVar.wiw + ';' + bVar.wiy + ';' + bVar.frameRate + ';' + bVar.wiA + ';' + bVar.wiB + ';');
                String str5 = this.ttO.sGQ;
                if (str5 == null) {
                    str5 = "";
                }
                enVar.rC(str5);
                String str6 = this.ttO.sGE;
                if (str6 == null) {
                    str6 = "";
                }
                enVar.rB(str6);
                if (!this.ttO.wzb) {
                    k kVar2 = k.vfA;
                    H = k.G(bVar.whL, this.ttO.tCE);
                } else {
                    k kVar3 = k.vfA;
                    H = k.H(bVar.whL, this.ttO.tCE);
                }
                enVar.rD(H);
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                enVar.mQ((long) com.tencent.mm.plugin.finder.storage.c.drF().first.intValue());
                enVar.rx(String.valueOf(bVar.whR));
                enVar.lh(bVar.wix);
                enVar.rE(bVar.wiz);
                enVar.rF(bVar.wiw);
                enVar.li(bVar.wiy);
                enVar.lj(bVar.frameRate);
                enVar.lk((int) (bVar.wiA * bVar.wiB));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("videoWidth", Float.valueOf(bVar.wiA));
                jSONObject2.put("videoHeight", Float.valueOf(bVar.wiB));
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                Resources resources = context.getResources();
                p.g(resources, "MMApplicationContext.getContext().resources");
                jSONObject2.put("screenWidth", resources.getDisplayMetrics().widthPixels);
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                Resources resources2 = context2.getResources();
                p.g(resources2, "MMApplicationContext.getContext().resources");
                jSONObject2.put("screenHeight", resources2.getDisplayMetrics().heightPixels);
                com.tencent.mm.plugin.finder.preload.model.a mediaPreloadModel = ((PluginFinder) g.ah(PluginFinder.class)).getMediaPreloadModel();
                jSONObject2.put("isMultiBitRate", mediaPreloadModel.uUD);
                jSONObject2.put("isSecondPre", mediaPreloadModel.uUE);
                jSONObject2.put("playLinkCnt", mediaPreloadModel.uUs);
                jSONObject2.put("preLinkCnt", mediaPreloadModel.uUr);
                jSONObject2.put("startPrePercent", mediaPreloadModel.uUt);
                jSONObject2.put("startPreSec", mediaPreloadModel.uUu);
                jSONObject2.put("preTaskCnt", mediaPreloadModel.uUq);
                jSONObject2.put("maxPrePercent", mediaPreloadModel.uUo);
                jSONObject2.put("maxPreBytes", mediaPreloadModel.uUp);
                jSONObject2.put("prevCnt", mediaPreloadModel.uUm);
                jSONObject2.put("nextCnt", mediaPreloadModel.uUn);
                jSONObject2.put("maxPreBitRate", mediaPreloadModel.uUv);
                String str7 = (String) mediaPreloadModel.uUC.get(enVar.getMediaId());
                if (str7 == null) {
                    str7 = "";
                }
                jSONObject2.put("findSpecStep", str7);
                jSONObject2.put("megaVideoMaxBitrate", mediaPreloadModel.uUx);
                jSONObject2.put("megaVideoPrevCount", mediaPreloadModel.uUy);
                jSONObject2.put("megaVideoNextCount", mediaPreloadModel.uUz);
                jSONObject2.put("playDecoderType", bVar.playDecoderType);
                jSONObject2.put("emcru", bVar.wiD);
                jSONObject2.put("mce", bVar.wiE);
                jSONObject2.put("mcru", bVar.wiF);
                jSONObject2.put("mcec", bVar.wiG);
                jSONObject2.put("mcid", bVar.wiH);
                jSONObject2.put("fvfrd", bVar.veh);
                jSONObject2.put("mpnn", bVar.whN);
                jSONObject2.put("mpdp", bVar.whO);
                x xVar3 = x.SXb;
                String jSONObject3 = jSONObject2.toString();
                p.g(jSONObject3, "JSONObject().apply {\n   …             }.toString()");
                enVar.rG(n.j(jSONObject3, ",", ";", false));
                String str8 = this.ttO.extraInfo;
                if (str8 == null || (str2 = n.j(str8, ",", ";", false)) == null) {
                    str2 = "";
                }
                enVar.rH(str2);
                String str9 = this.ttO.sGH;
                if (str9 == null || (str3 = n.j(str9, ",", ";", false)) == null) {
                    str3 = "";
                }
                enVar.rI(str3);
                if (!this.ttO.wzb) {
                    k kVar4 = k.vfA;
                    FinderItem Fc = k.Fc(bVar.whL);
                    if (Fc != null) {
                        enVar.rw(Fc.getUserName());
                        x xVar4 = x.SXb;
                    } else {
                        enVar.rw("");
                        x xVar5 = x.SXb;
                    }
                } else {
                    k kVar5 = k.vfA;
                    bm Fd2 = k.Fd(bVar.whL);
                    if (Fd2 != null) {
                        FinderContact finderContact = Fd2.contact;
                        if (finderContact == null || (str4 = finderContact.username) == null) {
                            str4 = "";
                        }
                        enVar.rw(str4);
                        x xVar6 = x.SXb;
                    }
                }
                JSONArray jSONArray3 = new JSONArray();
                for (T t2 : bVar.wit) {
                    try {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("waitMs", t2.LOf);
                        jSONObject4.put("percent", t2.percent);
                        jSONObject4.put("type", t2.type);
                        jSONArray3.put(jSONObject4);
                    } catch (Exception e3) {
                    }
                }
                String jSONArray4 = jSONArray3.toString();
                p.g(jSONArray4, "waitingDetails.toString()");
                enVar.rv(n.j(jSONArray4, ",", ";", false));
                String str10 = "";
                Iterator<T> it = bVar.wiu.iterator();
                while (it.hasNext()) {
                    str10 = str10 + it.next().intValue() + ';';
                }
                enVar.ry(str10);
                enVar.eOp();
                ArrayList<IDKey> arrayList = new ArrayList<>(8);
                if (enVar.afQ() > 0) {
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(this.whH);
                    iDKey.SetKey(0);
                    iDKey.SetValue(enVar.afQ());
                    arrayList.add(iDKey);
                }
                if (enVar.afN() > 0 && enVar.afQ() > 0) {
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(this.whH);
                    iDKey2.SetKey(1);
                    iDKey2.SetValue(enVar.afQ());
                    arrayList.add(iDKey2);
                }
                if (enVar.afN() > 0 && enVar.afJ() > 0) {
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(this.whH);
                    iDKey3.SetKey(2);
                    iDKey3.SetValue(1);
                    arrayList.add(iDKey3);
                }
                if (enVar.afN() > 0 && enVar.afO() > 0) {
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(this.whH);
                    iDKey4.SetKey(3);
                    iDKey4.SetValue(enVar.afO());
                    arrayList.add(iDKey4);
                    if (enVar.afO() <= 500) {
                        IDKey iDKey5 = new IDKey();
                        iDKey5.SetID(this.whH);
                        iDKey5.SetKey(5);
                        iDKey5.SetValue(1);
                        arrayList.add(iDKey5);
                    } else if (enVar.afO() <= 1000) {
                        IDKey iDKey6 = new IDKey();
                        iDKey6.SetID(this.whH);
                        iDKey6.SetKey(6);
                        iDKey6.SetValue(1);
                        arrayList.add(iDKey6);
                    } else if (enVar.afO() > 1000) {
                        IDKey iDKey7 = new IDKey();
                        iDKey7.SetID(this.whH);
                        iDKey7.SetKey(7);
                        iDKey7.SetValue(1);
                        arrayList.add(iDKey7);
                    }
                }
                if (enVar.afN() > 0 && enVar.afS() > 0) {
                    IDKey iDKey8 = new IDKey();
                    iDKey8.SetID(this.whH);
                    iDKey8.SetKey(4);
                    iDKey8.SetValue(enVar.afS());
                    arrayList.add(iDKey8);
                }
                if (enVar.afR() == 1) {
                    IDKey iDKey9 = new IDKey();
                    iDKey9.SetID(this.whH);
                    iDKey9.SetValue(1);
                    if (bVar.playDecoderType == 102) {
                        iDKey9.SetKey(104);
                        arrayList.add(iDKey9);
                    } else if (bVar.playDecoderType == 101) {
                        iDKey9.SetKey(105);
                        arrayList.add(iDKey9);
                    }
                }
                IDKey iDKey10 = new IDKey();
                iDKey10.SetID(this.whH);
                iDKey10.SetKey(100);
                iDKey10.SetValue(1);
                arrayList.add(iDKey10);
                if (enVar.afN() > 0) {
                    IDKey iDKey11 = new IDKey();
                    iDKey11.SetID(this.whH);
                    iDKey11.SetKey(101);
                    iDKey11.SetValue(1);
                    arrayList.add(iDKey11);
                }
                if (enVar.afN() > 0 && enVar.afO() > 0) {
                    IDKey iDKey12 = new IDKey();
                    iDKey12.SetID(this.whH);
                    iDKey12.SetKey(102);
                    iDKey12.SetValue(1);
                    arrayList.add(iDKey12);
                }
                if (enVar.afN() > 0 && enVar.afS() > 0) {
                    IDKey iDKey13 = new IDKey();
                    iDKey13.SetID(this.whH);
                    iDKey13.SetKey(103);
                    iDKey13.SetValue(1);
                    arrayList.add(iDKey13);
                }
                if (!arrayList.isEmpty()) {
                    h.INSTANCE.b(arrayList, false);
                }
                k kVar6 = k.vfA;
                k.a(enVar);
                c cVar3 = bVar.wiq;
                if (cVar3 != null) {
                    aqj aqj = new aqj();
                    aqj.feedId = bVar.whL;
                    aqj.LCp = 0;
                    aqj.LCu = (int) enVar.afP();
                    aqj.LCw = (int) enVar.afO();
                    aqj.LCr = (int) enVar.getFileSize();
                    aqj.LCq = kotlin.h.a.cR(((float) (enVar.getFileSize() * enVar.afK())) / 100.0f);
                    aqj.mzA = kotlin.h.a.cR(((float) (enVar.afM() * enVar.getFileSize())) / 100.0f);
                    aqj.scene = this.ttO.tCE;
                    aqj.duration = sVar.uIw.videoDuration;
                    aqj.whS = (int) enVar.getPosition();
                    aqj.LCv = cl.aWB();
                    aqj.LCs = (int) bVar.vgo;
                    aqj.LCt = (int) bVar.wim;
                    aqj.wit = bVar.wit;
                    aqj.dVY = bVar.wiw;
                    aqj.LCx = cVar3.averageConnectCost;
                    aqj.wiK = cVar3.wiK;
                    aqj.wiL = cVar3.wiL;
                    aqj.networkId = cVar3.netType;
                    aqj.whR = bVar.whR;
                    if (whI.size() > 2) {
                        whI.remove(0);
                    }
                    whI.add(aqj);
                    whJ.add(aqj);
                    Log.i("Finder.FinderVideoPlayReporter", "downloadInfoList " + whI.size());
                    x xVar7 = x.SXb;
                }
            }
            x xVar8 = x.SXb;
            AppMethodBeat.o(254537);
        }
    }

    public final void b(C1322b bVar) {
        String str;
        long j2;
        long j3;
        long j4;
        long j5;
        AppMethodBeat.i(254538);
        Log.i("Finder.FinderVideoPlayReporter", bVar != null ? String.valueOf(a("report17000", bVar)) : null);
        if (bVar != null) {
            y yVar = y.vXH;
            cjl cjl = bVar.whQ;
            d dVar = bVar.wip;
            c cVar = bVar.wiq;
            if (!(cjl == null || dVar == null || cVar == null)) {
                lg lgVar = new lg();
                com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                s sVar = bVar.whP;
                if (sVar == null || (str = sVar.auA()) == null) {
                    str = "";
                }
                long L = kotlin.h.a.L((double) (((float) (((long) bVar.whX) * com.tencent.mm.plugin.finder.storage.logic.d.avH(str).field_totalSize)) / 100.0f));
                lg ut = lgVar.ys(com.tencent.mm.ac.d.zs(bVar.whL)).tZ((long) (this.ttO.tCE + 100)).ua((long) bVar.wid).ub(bVar.whS == 0 ? 1 : 0).uc((long) cjl.videoDuration).ud(kotlin.h.a.L((double) (((float) (cjl.videoDuration * bVar.whV)) / 100.0f))).ue(bVar.wij).uf(bVar.whZ).ug(bVar.wis).aix().ui(0).uj((long) cVar.retCode).yt("").uk((long) bVar.wix).yu(String.valueOf(dVar.requestVideoFormat)).ul(cVar.jPY).um(cVar.recvedBytes).un(cVar.startTime).uo(cVar.endTime).up((long) cVar.retCode).uq(cVar.enQueueTime).ur((long) cVar.moovRequestTimes).us((long) cVar.moovCost).ut((long) cVar.moovSize);
                if (cVar.moovCompleted) {
                    j2 = 1;
                } else {
                    j2 = 0;
                }
                lg uz = ut.uu(j2).uv((long) cVar.moovFailReason).uw((long) cVar.firstConnectCost).ux((long) cVar.firstRequestCost).uy((long) cVar.firstRequestSize).uz((long) cVar.firstRequestDownloadSize);
                if (cVar.firstRequestCompleted) {
                    j3 = 1;
                } else {
                    j3 = 0;
                }
                lg yw = uz.uA(j3).uB((long) cVar.averageSpeed).uC((long) cVar.averageConnectCost).uD((long) cVar.netConnectTimes).yv(cVar.wiI).yw(cVar.clientIP);
                if (cVar.wiJ) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                lg lS = yw.uE(j4).uF(dVar.gra).uG(0).uH(bVar.wic).uI(bVar.njx).uJ(L).aiz().lR(cVar.transportProtocol).lS(cVar.transportProtocolError);
                if (BuildInfo.DEBUG) {
                    j5 = 0;
                } else {
                    j5 = 59;
                }
                lS.uK(j5).uL(cVar.traceId);
                if (bVar.wik == 0) {
                    lgVar.uh(0);
                } else {
                    lgVar.uh(bVar.wim / ((long) bVar.wik));
                }
                lgVar.bfK();
                k kVar = k.vfA;
                k.a(lgVar);
            }
            AppMethodBeat.o(254538);
            return;
        }
        AppMethodBeat.o(254538);
    }

    public final void d(bbn bbn) {
        AppMethodBeat.i(254539);
        p.h(bbn, "contextObj");
        this.ttO = bbn;
        AppMethodBeat.o(254539);
    }

    public static final class d {
        long gra;
        private final String mediaId;
        int requestVideoFormat;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(254534);
            if (this == obj || ((obj instanceof d) && p.j(this.mediaId, ((d) obj).mediaId))) {
                AppMethodBeat.o(254534);
                return true;
            }
            AppMethodBeat.o(254534);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(254533);
            String str = this.mediaId;
            if (str != null) {
                int hashCode = str.hashCode();
                AppMethodBeat.o(254533);
                return hashCode;
            }
            AppMethodBeat.o(254533);
            return 0;
        }

        public final String toString() {
            AppMethodBeat.i(254532);
            String str = "ReportTaskInfo(mediaId=" + this.mediaId + ")";
            AppMethodBeat.o(254532);
            return str;
        }

        public d(String str) {
            p.h(str, "mediaId");
            AppMethodBeat.i(254531);
            this.mediaId = str;
            AppMethodBeat.o(254531);
        }
    }

    public static final class c {
        int averageConnectCost;
        int averageSpeed;
        String clientIP = "";
        long enQueueTime;
        long endTime;
        int firstConnectCost;
        boolean firstRequestCompleted;
        int firstRequestCost;
        int firstRequestDownloadSize;
        int firstRequestSize;
        long jPY;
        private final String mediaId;
        boolean moovCompleted;
        int moovCost;
        int moovFailReason;
        int moovRequestTimes;
        int moovSize;
        int netConnectTimes;
        int netType;
        long recvedBytes;
        int retCode;
        long startTime;
        long traceId;
        int transportProtocol;
        int transportProtocolError;
        String wiI = "";
        boolean wiJ;
        String wiK = "";
        int wiL;

        public final boolean equals(Object obj) {
            AppMethodBeat.i(254530);
            if (this == obj || ((obj instanceof c) && p.j(this.mediaId, ((c) obj).mediaId))) {
                AppMethodBeat.o(254530);
                return true;
            }
            AppMethodBeat.o(254530);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(254529);
            String str = this.mediaId;
            if (str != null) {
                int hashCode = str.hashCode();
                AppMethodBeat.o(254529);
                return hashCode;
            }
            AppMethodBeat.o(254529);
            return 0;
        }

        public final String toString() {
            AppMethodBeat.i(254528);
            String str = "ReportSceneResult(mediaId=" + this.mediaId + ")";
            AppMethodBeat.o(254528);
            return str;
        }

        public c(String str) {
            p.h(str, "mediaId");
            AppMethodBeat.i(254527);
            this.mediaId = str;
            AppMethodBeat.o(254527);
        }

        public final void awL(String str) {
            AppMethodBeat.i(254524);
            p.h(str, "<set-?>");
            this.wiI = str;
            AppMethodBeat.o(254524);
        }

        public final void awM(String str) {
            AppMethodBeat.i(254525);
            p.h(str, "<set-?>");
            this.clientIP = str;
            AppMethodBeat.o(254525);
        }

        public final void awN(String str) {
            AppMethodBeat.i(254526);
            p.h(str, "<set-?>");
            this.wiK = str;
            AppMethodBeat.o(254526);
        }
    }

    private static d f(com.tencent.mm.i.h hVar) {
        AppMethodBeat.i(254540);
        p.h(hVar, "cloneTaskInfo");
        String str = hVar.field_mediaId;
        if (str == null) {
            str = "";
        }
        d dVar = new d(str);
        dVar.requestVideoFormat = hVar.field_requestVideoFormat;
        dVar.gra = hVar.gra;
        AppMethodBeat.o(254540);
        return dVar;
    }

    public static c b(com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(254541);
        p.h(dVar, "sceneResult");
        String str = dVar.mediaId;
        if (str == null) {
            str = "";
        }
        c cVar = new c(str);
        cVar.retCode = dVar.field_retCode;
        cVar.jPY = dVar.field_fileLength;
        cVar.recvedBytes = dVar.field_recvedBytes;
        cVar.endTime = dVar.field_endTime;
        cVar.startTime = dVar.field_startTime;
        cVar.enQueueTime = dVar.field_enQueueTime;
        cVar.moovRequestTimes = dVar.field_moovRequestTimes;
        cVar.moovCost = dVar.field_moovCost;
        cVar.moovSize = dVar.field_moovSize;
        cVar.moovCompleted = dVar.field_moovCompleted;
        cVar.moovFailReason = dVar.field_moovFailReason;
        cVar.firstConnectCost = dVar.field_firstConnectCost;
        cVar.firstRequestCost = dVar.field_firstRequestCost;
        cVar.firstRequestSize = dVar.field_firstRequestSize;
        cVar.firstRequestDownloadSize = dVar.field_firstRequestDownloadSize;
        cVar.firstRequestCompleted = dVar.field_firstRequestCompleted;
        cVar.averageSpeed = dVar.field_averageSpeed;
        cVar.averageConnectCost = dVar.field_averageConnectCost;
        cVar.netConnectTimes = dVar.field_netConnectTimes;
        String alM = dVar.alM();
        if (alM != null) {
            cVar.awL(alM);
        }
        String str2 = dVar.field_clientIP;
        if (str2 != null) {
            cVar.awM(str2);
        }
        cVar.wiJ = dVar.field_isCrossNet;
        cVar.transportProtocol = dVar.transportProtocol;
        cVar.transportProtocolError = dVar.transportProtocolError;
        String str3 = dVar.gqm;
        if (str3 != null) {
            cVar.awN(str3);
        }
        cVar.wiL = dVar.lastSvrPort;
        cVar.netType = dVar.lastNetType;
        cVar.traceId = dVar.traceId;
        AppMethodBeat.o(254541);
        return cVar;
    }
}
