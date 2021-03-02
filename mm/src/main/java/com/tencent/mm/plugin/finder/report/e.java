package com.tencent.mm.plugin.finder.report;

import android.media.AudioManager;
import android.util.LongSparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bw;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.h;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.reporter.b;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.k;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

public abstract class e extends com.tencent.mm.plugin.finder.event.base.d {
    private static final String TAG = TAG;
    public static final a vdS = new a((byte) 0);
    public bbn ttO;
    final MMFragmentActivity uLr;
    private g vdO = new g(this) {
        /* class com.tencent.mm.plugin.finder.report.e.AnonymousClass1 */
        final /* synthetic */ e vdT;

        {
            this.vdT = r1;
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void b(ca caVar, az azVar, boolean z, i.c cVar) {
            AppMethodBeat.i(250538);
            this.vdT.dnL();
            AppMethodBeat.o(250538);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(ca caVar, i.c cVar, boolean[] zArr) {
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(ca caVar, az azVar, boolean z, i.c cVar) {
        }
    };
    final b vdP = new b();
    private final long vdQ = 1277;
    public final com.tencent.mm.plugin.finder.video.reporter.b vdR = new com.tencent.mm.plugin.finder.video.reporter.b(this.ttO);
    boolean visible;

    public static final class b {
        boolean vdU;
        boolean vdV;
    }

    public e(MMFragmentActivity mMFragmentActivity, bbn bbn) {
        p.h(mMFragmentActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        this.uLr = mMFragmentActivity;
        this.ttO = bbn;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ((l) af).aST().a(this.vdO);
        this.visible = true;
    }

    public final bbn getContextObj() {
        return this.ttO;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ void a(bbn bbn, long j2, int i2, String str, long j3, bm bmVar, int i3) {
            AppMethodBeat.i(250540);
            a(bbn, j2, i2, str, (i3 & 16) != 0 ? cl.aWA() : j3, (i3 & 32) != 0 ? null : bmVar);
            AppMethodBeat.o(250540);
        }

        public static void a(bbn bbn, long j2, int i2, String str, long j3, bm bmVar) {
            long j4;
            String str2;
            String str3;
            String str4;
            String str5;
            cnl cnl;
            LinkedList<cod> linkedList;
            cod cod;
            AppMethodBeat.i(250539);
            p.h(bbn, "contextObj");
            p.h(str, "actionValue");
            y yVar = y.vXH;
            if (!y.Gj(j2)) {
                Log.i(e.TAG, "feedId:" + j2 + " is loacl fake feed,not report 18054");
                AppMethodBeat.o(250539);
                return;
            }
            bw bwVar = new bw();
            bwVar.ko(com.tencent.mm.ac.d.zs(j2));
            bwVar.eR((long) bbn.tCE);
            bwVar.jY(i2);
            bwVar.kp(n.j(str, ",", ";", false));
            bwVar.jZ(BuildInfo.DEBUG ? 0 : 43);
            bwVar.eP(j3);
            bwVar.kq(bbn.sessionId);
            if (bmVar != null) {
                bwVar.ka(4);
                k kVar = k.vfA;
                String H = k.H(bmVar.lT(), bbn.tCE);
                if (H == null || (str5 = n.j(H, ",", ";", false)) == null) {
                    str5 = "";
                }
                bwVar.kr(str5);
                cng cng = bmVar.tuP;
                bwVar.eQ((long) ((cng == null || (cnl = cng.MtG) == null || (linkedList = cnl.media) == null || (cod = (cod) j.kt(linkedList)) == null) ? 0 : cod.Mur));
                bwVar.ky(com.tencent.mm.ac.d.zs(bmVar.lT()));
            } else {
                k kVar2 = k.vfA;
                FinderItem Fc = k.Fc(j2);
                if (Fc != null) {
                    bwVar.ka(Fc.getMediaType());
                    cjl cjl = (cjl) j.kt(Fc.getMediaList());
                    if (cjl != null) {
                        j4 = (long) cjl.videoDuration;
                    } else {
                        j4 = 0;
                    }
                    bwVar.eQ(j4);
                }
            }
            k kVar3 = k.vfA;
            String G = k.G(j2, bbn.tCE);
            if (G == null || (str2 = n.j(G, ",", ";", false)) == null) {
                str2 = "";
            }
            bwVar.kr(str2);
            bwVar.ks(com.tencent.mm.ac.d.zs(bbn.wyW));
            String str6 = bbn.wyX;
            if (str6 == null) {
                str6 = "";
            }
            bwVar.kt(str6);
            bwVar.ku(bbn.sGE);
            bwVar.kv(bbn.sGQ);
            String str7 = bbn.extraInfo;
            if (str7 == null || (str3 = n.j(str7, ",", ";", false)) == null) {
                str3 = "";
            }
            bwVar.kw(str3);
            String str8 = bbn.sGH;
            if (str8 == null || (str4 = n.j(str8, ",", ";", false)) == null) {
                str4 = "";
            }
            bwVar.kx(str4);
            y yVar2 = y.vXH;
            k kVar4 = k.vfA;
            bwVar.eS(y.a(yVar2, k.Kx(bbn.tCE), 0, 2) ? 1 : 0);
            bwVar.eOp();
            k kVar5 = k.vfA;
            k.a(bwVar);
            AppMethodBeat.o(250539);
        }

        public static JSONObject a(int i2, String... strArr) {
            AppMethodBeat.i(250541);
            p.h(strArr, "values");
            JSONObject jSONObject = new JSONObject();
            switch (i2) {
                case 4:
                    jSONObject.put("len", strArr[0]);
                    jSONObject.put("idx_last", strArr[1]);
                    jSONObject.put("idx_now", strArr[2]);
                    jSONObject.put("is_video", strArr[3]);
                    jSONObject.put("video_play_percent", strArr[4]);
                    jSONObject.put("video_replay_count", strArr[5]);
                    jSONObject.put("idx_type", strArr[6]);
                    break;
                case 8:
                    jSONObject.put("scene", strArr[0]);
                    break;
                case 10:
                    jSONObject.put("type", strArr[0]);
                    jSONObject.put(ch.COL_USERNAME, strArr[1]);
                    break;
                case 13:
                    jSONObject.put("type", strArr[0]);
                    break;
                case 15:
                    jSONObject.put("type", strArr[0]);
                    break;
                case 16:
                    jSONObject.put("type", strArr[0]);
                    break;
            }
            AppMethodBeat.o(250541);
            return jSONObject;
        }

        public static String ah(Map<String, ? extends Object> map) {
            AppMethodBeat.i(250542);
            p.h(map, "maps");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Exception e2) {
                }
            }
            String jSONObject2 = jSONObject.toString();
            p.g(jSONObject2, "json.toString()");
            String j2 = n.j(jSONObject2, ",", ";", false);
            AppMethodBeat.o(250542);
            return j2;
        }

        public static void a(bbn bbn, p pVar) {
            long j2;
            String str;
            long j3;
            ard foldedLayout;
            LinkedList<FinderObject> linkedList;
            LongSparseArray<k> longSparseArray;
            ard foldedLayout2;
            ard foldedLayout3;
            AppMethodBeat.i(250544);
            p.h(bbn, "contextObj");
            p.h(pVar, "record");
            ce ceVar = new ce();
            ceVar.ll(bbn.sessionId);
            ceVar.lm(bbn.sGQ);
            ceVar.ln(bbn.sGE);
            ceVar.fF((long) bbn.tCE);
            ceVar.lo(com.tencent.mm.ac.d.zs(pVar.feedId));
            FinderItem finderItem = pVar.tHo;
            if (finderItem == null || (foldedLayout3 = finderItem.getFoldedLayout()) == null) {
                j2 = 0;
            } else {
                j2 = (long) foldedLayout3.gAZ;
            }
            ceVar.fG(j2);
            FinderItem finderItem2 = pVar.tHo;
            if (finderItem2 == null || (foldedLayout2 = finderItem2.getFoldedLayout()) == null || (str = foldedLayout2.username) == null) {
                str = "";
            }
            ceVar.lp(str);
            ceVar.lq("");
            long j4 = 0;
            FinderFoldedScrollLayout.a aVar = FinderFoldedScrollLayout.wmQ;
            if (FinderFoldedScrollLayout.wmM != 0) {
                FinderFoldedScrollLayout.a aVar2 = FinderFoldedScrollLayout.wmQ;
                ceVar.fI(FinderFoldedScrollLayout.wmM);
                j3 = 0;
            } else {
                FinderFoldedScrollLayout.a aVar3 = FinderFoldedScrollLayout.wmQ;
                if (FinderFoldedScrollLayout.wmN != 0) {
                    FinderFoldedScrollLayout.a aVar4 = FinderFoldedScrollLayout.wmQ;
                    ceVar.fH(FinderFoldedScrollLayout.wmN);
                    j3 = 0;
                } else {
                    FinderFoldedScrollLayout.a aVar5 = FinderFoldedScrollLayout.wmQ;
                    if (FinderFoldedScrollLayout.wmP != 0) {
                        FinderFoldedScrollLayout.a aVar6 = FinderFoldedScrollLayout.wmQ;
                        j4 = FinderFoldedScrollLayout.wmO;
                        FinderFoldedScrollLayout.a aVar7 = FinderFoldedScrollLayout.wmQ;
                        j3 = FinderFoldedScrollLayout.wmP;
                    } else {
                        j3 = 0;
                    }
                }
            }
            FinderItem finderItem3 = pVar.tHo;
            if (!(finderItem3 == null || (foldedLayout = finderItem3.getFoldedLayout()) == null || (linkedList = foldedLayout.LCW) == null)) {
                int i2 = 0;
                for (T t : linkedList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    com.tencent.mm.view.recyclerview.i iVar = pVar.tIw;
                    k kVar = (iVar == null || (longSparseArray = iVar.Rrh) == null) ? null : longSparseArray.get(t2.id);
                    if (kVar == null) {
                        a aVar8 = e.vdS;
                        if (j4 == t2.id) {
                            ceVar.lq(ceVar.ada() + com.tencent.mm.ac.d.zs(t2.id) + ';' + i2 + ";0;" + j3 + '#');
                            i2 = i3;
                        } else {
                            ceVar.lq(ceVar.ada() + com.tencent.mm.ac.d.zs(t2.id) + ';' + i2 + ";0;0#");
                            i2 = i3;
                        }
                    } else if (j4 == kVar.Rrp.lT()) {
                        ceVar.lq(ceVar.ada() + com.tencent.mm.ac.d.zs(kVar.Rrp.lT()) + ';' + i2 + ';' + kVar.Rrq + ';' + j3 + '#');
                        i2 = i3;
                    } else {
                        ceVar.lq(ceVar.ada() + com.tencent.mm.ac.d.zs(kVar.Rrp.lT()) + ';' + i2 + ';' + kVar.Rrq + ";0#");
                        i2 = i3;
                    }
                }
            }
            FinderFoldedScrollLayout.a aVar9 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmM = 0;
            FinderFoldedScrollLayout.a aVar10 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmP = 0;
            FinderFoldedScrollLayout.a aVar11 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmO = 0;
            FinderFoldedScrollLayout.a aVar12 = FinderFoldedScrollLayout.wmQ;
            FinderFoldedScrollLayout.wmN = 0;
            ceVar.eOp();
            k kVar2 = k.vfA;
            k.a(ceVar);
            AppMethodBeat.o(250544);
        }

        public static void o(String str, String str2, String str3, String str4) {
            String str5;
            AppMethodBeat.i(250545);
            ck ckVar = new ck();
            if (str == null) {
                str = "";
            }
            ckVar.mb(str);
            if (str2 == null || (str5 = n.j(str2, ",", ";", false)) == null) {
                str5 = "";
            }
            ckVar.mc(str5);
            if (str3 == null) {
                str3 = "";
            }
            ckVar.md(str3);
            if (str4 == null) {
                str4 = "";
            }
            ckVar.me(str4);
            ckVar.bfK();
            AppMethodBeat.o(250545);
        }

        public static void a(bbn bbn, p pVar, int i2) {
            String str;
            long j2 = 0;
            AppMethodBeat.i(250543);
            p.h(bbn, "contextObj");
            p.h(pVar, "record");
            FinderItem finderItem = pVar.tHo;
            if (finderItem != null) {
                cj cjVar = new cj();
                cjVar.lO(com.tencent.mm.ac.d.zs(finderItem.getId()));
                cjVar.fY((long) finderItem.getMediaType());
                cjVar.lP(bbn.sessionId);
                cjVar.gm((long) bbn.tCE);
                cjVar.fZ(pVar.uOV);
                cjVar.ga((long) finderItem.getLikeCount());
                cjVar.gb((long) finderItem.getCommentCount());
                w wVar = w.vXp;
                cjVar.lQ(n.j(w.z(finderItem), ",", ";", false));
                String str2 = finderItem.getFeedObject().recommendReason;
                if (str2 == null) {
                    str2 = "";
                }
                cjVar.lR(str2);
                cjVar.gc(p.j(finderItem.getUserName(), z.aUg()) ? 1 : 0);
                cjVar.gd((long) finderItem.getCreateTime());
                if (finderItem.getLocation().latitude > 0.0f && finderItem.getLocation().dTj > 0.0f) {
                    cjVar.adg();
                }
                cjVar.ge((long) finderItem.getMediaList().size());
                if (finderItem.getMediaType() == 4 && finderItem.getMediaList().size() > 0) {
                    cjVar.gf((long) finderItem.getMediaList().get(0).videoDuration);
                }
                cjVar.gg(pVar.endTime - pVar.startTime);
                if (!BuildInfo.DEBUG) {
                    j2 = 5;
                }
                cjVar.gh(j2);
                cjVar.gi((long) finderItem.getFeedObject().recommendType);
                cjVar.lS(finderItem.getUserName());
                cjVar.gj((long) finderItem.getFeedObject().orgRecommendType);
                String str3 = finderItem.getFeedObject().warnWording;
                if (str3 == null) {
                    str3 = "";
                }
                cjVar.lT(str3);
                cjVar.gk((long) finderItem.getFeedObject().warnFlag);
                cjVar.gl((long) i2);
                String str4 = bbn.sGQ;
                if (str4 == null) {
                    str4 = "";
                }
                cjVar.lU(str4);
                cjVar.lV(com.tencent.mm.ac.d.zs(bbn.wyW));
                String str5 = bbn.wyX;
                if (str5 == null) {
                    str5 = "";
                }
                cjVar.lW(str5);
                String str6 = bbn.sGE;
                if (str6 == null) {
                    str6 = "";
                }
                cjVar.lX(str6);
                cjVar.gn((long) pVar.vfP);
                k kVar = k.vfA;
                cjVar.go(k.Kt(bbn.tCE));
                k kVar2 = k.vfA;
                cjVar.lY(k.G(finderItem.getId(), bbn.tCE));
                j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
                LinkedList<FinderCommentInfo> p = com.tencent.mm.plugin.finder.upload.action.j.vUv.p(finderItem.getFeedObject());
                cjVar.gp((long) p.size());
                if (p.size() > 3) {
                    cjVar.gq(3);
                } else {
                    cjVar.gq((long) p.size());
                }
                cjVar.lZ("");
                int i3 = 0;
                for (T t : p) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.a.j.hxH();
                    }
                    T t2 = t;
                    if (i3 <= 2) {
                        cjVar.lZ(cjVar.adh() + t2.username + '|');
                    }
                    i3 = i4;
                }
                cjVar.gr((long) finderItem.getFeedObject().commentList.size());
                LinkedList<FinderCommentInfo> linkedList = finderItem.getFeedObject().commentList;
                p.g(linkedList, "it.feedObject.commentList");
                FinderCommentInfo finderCommentInfo = (FinderCommentInfo) kotlin.a.j.kt(linkedList);
                if (finderCommentInfo == null || (str = finderCommentInfo.username) == null) {
                    str = "";
                }
                cjVar.ma(str);
                y yVar = y.vXH;
                if (y.B(finderItem)) {
                    cjVar.gs((long) finderItem.getFeedObject().incFriendLikeCount);
                }
                LinkedList<FinderCommentInfo> linkedList2 = finderItem.getFeedObject().commentList;
                p.g(linkedList2, "it.feedObject.commentList");
                ArrayList arrayList = new ArrayList();
                for (T t3 : linkedList2) {
                    if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isFriend(t3.username)) {
                        arrayList.add(t3);
                    }
                }
                cjVar.gt((long) arrayList.size());
                cjVar.gu((long) finderItem.getFeedObject().commentList.size());
                cjVar.eOp();
                k kVar3 = k.vfA;
                k.a(cjVar);
                AppMethodBeat.o(250543);
                return;
            }
            AppMethodBeat.o(250543);
        }
    }

    public static final class c {
        private static final String vdW = "1";
        public static final a vdX = new a((byte) 0);

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(250546);
            AppMethodBeat.o(250546);
        }
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public void onRelease() {
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        com.tencent.mm.ac.d.c(FinderReporterUIC.kWD, new d(this));
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
        p.h(cVar, "dispatcher");
        p.h(bVar, "event");
        if (bVar instanceof c.a) {
            return true;
        }
        return false;
    }

    public void dnL() {
    }

    @Override // com.tencent.mm.plugin.finder.event.base.d
    public void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
        int i2;
        FinderMediaReportObject finderMediaReportObject;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i3;
        int i4;
        boolean z;
        long Ff;
        String str9;
        float f2;
        float f3;
        FeedData feedData;
        FeedData feedData2;
        int i5;
        int i6;
        int i7;
        String str10;
        int i8;
        p.h(bVar, "event");
        if (this.ttO.tCE == 0) {
            Log.i(TAG, "[onEventHappen] invalid scene");
        } else if (bVar instanceof c.a) {
            switch (((c.a) bVar).type) {
                case 1:
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(this.vdQ, 1, 1, false);
                    com.tencent.mm.plugin.finder.video.reporter.b bVar2 = this.vdR;
                    c.a aVar = (c.a) bVar;
                    p.h(aVar, "event");
                    b.C1322b bVar3 = bVar2.whF.get(Long.valueOf(aVar.feedId));
                    if (bVar3 != null) {
                        bVar3.bfW = true;
                        bVar3.vgn = aVar.tHW;
                        if (bVar3.wii > 0) {
                            bVar3.wih += aVar.tHW - bVar3.wii;
                            bVar3.wii = 0;
                        }
                        StringBuilder sb = new StringBuilder();
                        p.g(bVar3, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onResume", bVar3)).append(" onResume:").append(bVar3.wih).toString());
                        return;
                    }
                    return;
                case 2:
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(this.vdQ, 2, 1, false);
                    com.tencent.mm.plugin.finder.video.reporter.b bVar4 = this.vdR;
                    c.a aVar2 = (c.a) bVar;
                    p.h(aVar2, "event");
                    b.C1322b bVar5 = bVar4.whF.get(Long.valueOf(aVar2.feedId));
                    if (bVar5 != null) {
                        bVar5.wie++;
                        return;
                    }
                    return;
                case 3:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar6 = this.vdR;
                    c.a aVar3 = (c.a) bVar;
                    p.h(aVar3, "event");
                    b.C1322b bVar7 = bVar6.whF.get(Long.valueOf(aVar3.feedId));
                    if (bVar7 != null) {
                        bVar7.wiu.add(Integer.valueOf(aVar3.offset));
                        y yVar = y.vXH;
                        int gq = y.gq(aVar3.offset, aVar3.jcu);
                        if (gq > bVar7.whV) {
                            bVar7.whV = gq;
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(this.vdQ, 0, 1, false);
                    com.tencent.mm.plugin.finder.video.reporter.b bVar8 = this.vdR;
                    c.a aVar4 = (c.a) bVar;
                    p.h(aVar4, "event");
                    b.C1322b bVar9 = new b.C1322b();
                    String cMD = ((com.tencent.mm.plugin.expt.b.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD();
                    if (cMD == null) {
                        cMD = "";
                    }
                    p.h(cMD, "<set-?>");
                    bVar9.sessionId = cMD;
                    bVar9.whL = aVar4.feedId;
                    s sVar = aVar4.tHN;
                    if (sVar == null || (str4 = sVar.auA()) == null) {
                        str4 = "";
                    }
                    p.h(str4, "<set-?>");
                    bVar9.whM = str4;
                    bVar9.whP = aVar4.tHN;
                    bVar9.whQ = aVar4.tHM;
                    com.tencent.mm.plugin.finder.video.s sVar2 = aVar4.tHL;
                    if (sVar2 == null || (feedData2 = sVar2.wgm) == null || (str5 = feedData2.getNickName()) == null) {
                        str5 = "-1";
                    }
                    p.h(str5, "<set-?>");
                    bVar9.whN = str5;
                    com.tencent.mm.plugin.finder.video.s sVar3 = aVar4.tHL;
                    if (sVar3 == null || (feedData = sVar3.wgm) == null || (str6 = feedData.getDescription()) == null) {
                        str6 = "-1";
                    }
                    String awf = h.awf(str6);
                    p.g(awf, "FinderFeedParser.simpleD…ata?.description ?: \"-1\")");
                    p.h(awf, "<set-?>");
                    bVar9.whO = awf;
                    s sVar4 = aVar4.tHN;
                    if (sVar4 == null || (str7 = sVar4.getPath()) == null) {
                        str7 = "";
                    }
                    p.h(str7, "<set-?>");
                    bVar9.mediaPath = str7;
                    bVar9.njx = aVar4.tHW;
                    bVar9.whS = aVar4.position;
                    bVar9.whT = 1;
                    bVar9.wif = true;
                    bVar9.tHQ = aVar4.tHQ;
                    bVar9.wig = CdnLogic.getRecentAverageSpeed(2);
                    Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                    if (systemService == null) {
                        throw new t("null cannot be cast to non-null type android.media.AudioManager");
                    }
                    bVar9.vgu = ((AudioManager) systemService).getStreamVolume(3);
                    com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    s sVar5 = aVar4.tHN;
                    if (sVar5 == null || (str8 = sVar5.auA()) == null) {
                        str8 = "";
                    }
                    at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str8);
                    if (bVar9.tHQ > 0) {
                        i3 = bVar9.tHQ + 1;
                    } else {
                        i3 = avH.dkP() > 0 ? 1 : 0;
                    }
                    bVar9.whW = i3;
                    if (avH.field_hasPlayed) {
                        i4 = 0;
                    } else {
                        i4 = 1;
                    }
                    bVar9.wid = i4;
                    bVar9.whX = avH.dkP();
                    String str11 = avH.field_fileFormat;
                    if (str11 == null) {
                        str11 = "";
                    }
                    bVar9.awK(str11);
                    if (bVar9.whX != 100) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar9.wif = z;
                    String netTypeString = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                    p.g(netTypeString, "NetStatusUtil.getNetType…tionContext.getContext())");
                    p.h(netTypeString, "<set-?>");
                    bVar9.wib = netTypeString;
                    k kVar = k.vfA;
                    bVar9.wic = (long) k.dod();
                    if (!bVar8.ttO.wzb) {
                        k kVar2 = k.vfA;
                        Ff = k.Fe(bVar9.whL);
                    } else {
                        k kVar3 = k.vfA;
                        Ff = k.Ff(bVar9.whL);
                    }
                    bVar9.win = Ff;
                    if (com.tencent.mm.modelcontrol.e.sX(4)) {
                        str9 = "h265";
                    } else {
                        str9 = "h264";
                    }
                    p.h(str9, "<set-?>");
                    bVar9.wiz = str9;
                    bVar9.whR = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMediaPreloadModel().uUw;
                    cjl cjl = aVar4.tHM;
                    if (cjl != null) {
                        f2 = cjl.width;
                    } else {
                        f2 = 0.0f;
                    }
                    bVar9.wiA = f2;
                    cjl cjl2 = aVar4.tHM;
                    if (cjl2 != null) {
                        f3 = cjl2.height;
                    } else {
                        f3 = 0.0f;
                    }
                    bVar9.wiB = f3;
                    bVar9.tHQ = aVar4.tHQ;
                    bVar8.whF.put(Long.valueOf(aVar4.feedId), bVar9);
                    Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onStartPlay", bVar9) + " firstplay:" + bVar9.wid + ' ' + "posterNickName:" + bVar9.whN + " mediaDesc:" + bVar9.whO);
                    return;
                case 5:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar10 = this.vdR;
                    c.a aVar5 = (c.a) bVar;
                    p.h(aVar5, "event");
                    b.C1322b bVar11 = bVar10.whF.get(Long.valueOf(aVar5.feedId));
                    if (bVar11 != null) {
                        bVar11.wif = false;
                        if (bVar11.wil > 0) {
                            long j2 = aVar5.tHW - bVar11.wil;
                            bVar11.wim += j2;
                            bek bek = new bek();
                            bek.LOf = (int) j2;
                            bek.percent = bVar11.whV;
                            if (bVar11.wik == 1 && bVar11.wis == 0) {
                                bek.type = 2;
                            } else {
                                bek.type = 0;
                            }
                            bVar11.wit.add(bek);
                            bVar11.wil = 0;
                            StringBuilder sb2 = new StringBuilder();
                            p.g(bVar11, "this");
                            Log.i("Finder.FinderVideoPlayReporter", sb2.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onWaitingEnd", bVar11)).append(" totalWaitingTime:").append(bVar11.wim).toString());
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(this.vdQ, 3, 1, false);
                    com.tencent.mm.plugin.finder.video.reporter.b bVar12 = this.vdR;
                    c.a aVar6 = (c.a) bVar;
                    p.h(aVar6, "event");
                    b.C1322b bVar13 = bVar12.whF.get(Long.valueOf(aVar6.feedId));
                    if (bVar13 != null && bVar13.whL == aVar6.feedId) {
                        String str12 = bVar13.whM;
                        s sVar6 = aVar6.tHN;
                        if (sVar6 != null) {
                            str = sVar6.auA();
                        } else {
                            str = null;
                        }
                        if (p.j(str12, str)) {
                            bVar13.vgo = aVar6.tHW - bVar13.njx;
                            if (bVar13.wii > 0) {
                                bVar13.wih += aVar6.tHW - bVar13.wii;
                                bVar13.wii = 0;
                            }
                            if (bVar13.vgn > 0) {
                                bVar13.vgm += aVar6.tHW - bVar13.vgn;
                                bVar13.vgn = 0;
                            }
                            if (bVar13.wil > 0) {
                                bVar13.wim += aVar6.tHW - bVar13.wil;
                                bVar13.wil = 0;
                                bek bek2 = new bek();
                                bek2.LOf = (int) (aVar6.tHW - bVar13.wil);
                                bek2.percent = bVar13.whV;
                                bek2.type = 0;
                                bVar13.wit.add(bek2);
                            }
                            Object systemService2 = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                            if (systemService2 == null) {
                                throw new t("null cannot be cast to non-null type android.media.AudioManager");
                            }
                            bVar13.vgv = ((AudioManager) systemService2).getStreamVolume(3);
                            if (bVar13.wij == 0 && bVar13.wif && bVar13.whV < 5) {
                                bVar13.jpW = 1;
                            }
                            com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                            s sVar7 = aVar6.tHN;
                            if (sVar7 == null || (str2 = sVar7.auA()) == null) {
                                str2 = "";
                            }
                            String str13 = com.tencent.mm.plugin.finder.storage.logic.d.avH(str2).field_fileFormat;
                            if (str13 == null) {
                                str13 = "";
                            }
                            bVar13.awK(str13);
                            s sVar8 = aVar6.tHN;
                            if (sVar8 == null || (str3 = sVar8.getPath()) == null) {
                                str3 = "";
                            }
                            com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(str3);
                            if (aNx != null) {
                                bVar13.wix = aNx.videoBitrate;
                                bVar13.wiy = aNx.audioBitrate;
                                bVar13.frameRate = aNx.frameRate;
                            }
                            if (!bVar13.wir) {
                                bVar12.a(bVar13);
                            } else {
                                bVar12.whE.add(bVar13);
                            }
                            bVar12.whF.remove(Long.valueOf(aVar6.feedId));
                            StringBuilder sb3 = new StringBuilder();
                            p.g(bVar13, "this");
                            Log.i("Finder.FinderVideoPlayReporter", sb3.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onStopPlay", bVar13)).append(" playTime:").append(bVar13.vgo).append(" pauseTotalTime:").append(bVar13.wih).append(" realPlayTime:").append(bVar13.vgm).append(" playStatus:").append(bVar13.jpW).toString());
                            return;
                        }
                        return;
                    }
                    return;
                case 7:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar14 = this.vdR;
                    c.a aVar7 = (c.a) bVar;
                    p.h(aVar7, "event");
                    b.C1322b bVar15 = bVar14.whF.get(Long.valueOf(aVar7.feedId));
                    if (bVar15 != null) {
                        if (bVar15.whZ == 0) {
                            bVar15.whZ = (aVar7.tHW - bVar15.njx) - bVar15.wih;
                        }
                        bVar15.wia = (long) (aVar7.offset + aVar7.jcu);
                        bVar15.wif = false;
                        StringBuilder sb4 = new StringBuilder();
                        p.g(bVar15, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb4.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onMoovReady", bVar15)).append(" moovReadyTime:").append(bVar15.whZ).toString());
                        return;
                    }
                    return;
                case 8:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar16 = this.vdR;
                    c.a aVar8 = (c.a) bVar;
                    p.h(aVar8, "event");
                    b.C1322b bVar17 = bVar16.whF.get(Long.valueOf(aVar8.feedId));
                    if (bVar17 != null) {
                        y yVar2 = y.vXH;
                        int gq2 = y.gq(aVar8.offset, aVar8.jcu);
                        if (gq2 > bVar17.mEd) {
                            bVar17.mEd = gq2;
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar18 = this.vdR;
                    c.a aVar9 = (c.a) bVar;
                    p.h(aVar9, "event");
                    b.C1322b bVar19 = bVar18.whF.get(Long.valueOf(aVar9.feedId));
                    if (bVar19 != null) {
                        bVar19.wif = true;
                        bVar19.wil = aVar9.tHW;
                        bVar19.wik++;
                        if (bVar19.wij > 0) {
                            bVar19.wis++;
                        }
                        p.g(bVar19, "this");
                        Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onWaiting", bVar19)));
                        return;
                    }
                    return;
                case 10:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar20 = this.vdR;
                    c.a aVar10 = (c.a) bVar;
                    p.h(aVar10, "event");
                    b.C1322b bVar21 = bVar20.whF.get(Long.valueOf(aVar10.feedId));
                    if (bVar21 != null) {
                        bVar21.vgr = 1;
                        return;
                    }
                    return;
                case 11:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar22 = this.vdR;
                    c.a aVar11 = (c.a) bVar;
                    p.h(aVar11, "event");
                    b.C1322b bVar23 = bVar22.whF.get(Long.valueOf(aVar11.feedId));
                    if (bVar23 != null) {
                        bVar23.bfW = false;
                        bVar23.wii = aVar11.tHW;
                        if (bVar23.vgn > 0) {
                            bVar23.vgm += aVar11.tHW - bVar23.vgn;
                            bVar23.vgn = 0;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        p.g(bVar23, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb5.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onPause", bVar23)).append(" realPlayTime:").append(bVar23.vgm).toString());
                        return;
                    }
                    return;
                case 12:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar24 = this.vdR;
                    c.a aVar12 = (c.a) bVar;
                    p.h(aVar12, "event");
                    b.C1322b bVar25 = bVar24.whF.get(Long.valueOf(aVar12.feedId));
                    if (bVar25 != null) {
                        if (bVar25.wij == 0) {
                            bVar25.wij = aVar12.tHW - bVar25.njx;
                            if (bVar25.wij > bVar25.wih) {
                                bVar25.wij -= bVar25.wih;
                            }
                            com.tencent.mm.plugin.finder.video.statistics.a aVar13 = bVar24.whG;
                            long j3 = bVar25.wij;
                            aVar13.wiN = j3;
                            aVar13.wiM = j3 + aVar13.wiM;
                            aVar13.count++;
                            Log.i(aVar13.TAG, "count:" + aVar13.count + " current:" + aVar13.wiN + ",  average:" + ((1.0f * ((float) aVar13.wiM)) / ((float) aVar13.count)));
                        }
                        if (bVar25.whU == 0) {
                            bVar25.whU = aVar12.tHR;
                        }
                        cjl cjl3 = aVar12.tHM;
                        if (cjl3 == null || (finderMediaReportObject = cjl3.MoZ) == null) {
                            i2 = 0;
                        } else {
                            i2 = finderMediaReportObject.playDecoderType;
                        }
                        bVar25.playDecoderType = i2;
                        StringBuilder sb6 = new StringBuilder();
                        p.g(bVar25, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb6.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onFirstFrameUpdate", bVar25)).append(" firstFrameTime:").append(bVar25.wij).append(" firstLoadTime:").append(bVar25.whU).append(" playDecoderType=").append(bVar25.playDecoderType).toString());
                        return;
                    }
                    return;
                case 13:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar26 = this.vdR;
                    c.a aVar14 = (c.a) bVar;
                    p.h(aVar14, "event");
                    b.C1322b bVar27 = bVar26.whF.get(Long.valueOf(aVar14.feedId));
                    if (bVar27 != null && bVar27.wio == 0) {
                        bVar27.wio = (long) (aVar14.offset + aVar14.jcu);
                        return;
                    }
                    return;
                case 14:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar28 = this.vdR;
                    c.a aVar15 = (c.a) bVar;
                    p.h(aVar15, "event");
                    b.C1322b bVar29 = bVar28.whF.get(Long.valueOf(aVar15.feedId));
                    if (bVar29 != null) {
                        bVar29.whY = aVar15.tHW - bVar29.njx;
                        com.tencent.mm.i.d dVar3 = aVar15.hmq;
                        if (dVar3 != null && bVar29.wiq == null) {
                            bVar29.wiq = com.tencent.mm.plugin.finder.video.reporter.b.b(dVar3);
                        }
                        p.g(bVar29, "this");
                        Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onDownloadFinish", bVar29)));
                        return;
                    }
                    return;
                case 15:
                    this.vdR.a((c.a) bVar);
                    return;
                case 16:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar30 = this.vdR;
                    c.a aVar16 = (c.a) bVar;
                    p.h(aVar16, "event");
                    b.C1322b bVar31 = bVar30.whF.get(Long.valueOf(aVar16.feedId));
                    if (bVar31 != null) {
                        bVar31.wir = true;
                        p.g(bVar31, "this");
                        Log.i("Finder.FinderVideoPlayReporter", String.valueOf(com.tencent.mm.plugin.finder.video.reporter.b.a("onDownloadStart", bVar31)));
                        return;
                    }
                    return;
                case 17:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar32 = this.vdR;
                    c.a aVar17 = (c.a) bVar;
                    p.h(aVar17, "event");
                    b.C1322b bVar33 = bVar32.whF.get(Long.valueOf(aVar17.feedId));
                    if (bVar33 != null) {
                        bVar33.vgq = 1;
                        return;
                    }
                    return;
                case 18:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar34 = this.vdR;
                    c.a aVar18 = (c.a) bVar;
                    p.h(aVar18, "event");
                    b.C1322b bVar35 = bVar34.whF.get(Long.valueOf(aVar18.feedId));
                    if (bVar35 != null) {
                        bVar35.wiC = aVar18.ret;
                        StringBuilder sb7 = new StringBuilder();
                        p.g(bVar35, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb7.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onPlayError", bVar35)).append(" playerErrCode:").append(bVar35.wiC).toString());
                        return;
                    }
                    return;
                case 19:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar36 = this.vdR;
                    c.a aVar19 = (c.a) bVar;
                    p.h(aVar19, "event");
                    b.C1322b bVar37 = bVar36.whF.get(Long.valueOf(aVar19.feedId));
                    if (bVar37 != null) {
                        if (bVar37.veh == 0) {
                            bVar37.veh = aVar19.tHW - bVar37.njx;
                            if (bVar37.veh > bVar37.wih) {
                                bVar37.veh -= bVar37.wih;
                            }
                        }
                        StringBuilder sb8 = new StringBuilder();
                        p.g(bVar37, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb8.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onFirstVideoFrameRendered", bVar37)).append(" firstVideoFrameRendered:").append(bVar37.veh).toString());
                        return;
                    }
                    return;
                case 20:
                    com.tencent.mm.plugin.finder.video.reporter.b bVar38 = this.vdR;
                    c.a aVar20 = (c.a) bVar;
                    p.h(aVar20, "event");
                    b.C1322b bVar39 = bVar38.whF.get(Long.valueOf(aVar20.feedId));
                    if (bVar39 != null) {
                        com.tencent.mm.plugin.finder.video.reporter.c cVar = aVar20.tHS;
                        if (cVar != null) {
                            i5 = cVar.dGa();
                        } else {
                            i5 = -1;
                        }
                        bVar39.wiD = i5;
                        com.tencent.mm.plugin.finder.video.reporter.c cVar2 = aVar20.tHS;
                        if (cVar2 != null) {
                            i6 = cVar2.dGb();
                        } else {
                            i6 = -1;
                        }
                        bVar39.wiE = i6;
                        com.tencent.mm.plugin.finder.video.reporter.c cVar3 = aVar20.tHS;
                        if (cVar3 != null) {
                            i7 = cVar3.dGc();
                        } else {
                            i7 = -1;
                        }
                        bVar39.wiF = i7;
                        com.tencent.mm.plugin.finder.video.reporter.c cVar4 = aVar20.tHS;
                        if (cVar4 == null || (str10 = cVar4.dGd()) == null) {
                            str10 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        p.h(str10, "<set-?>");
                        bVar39.wiG = str10;
                        com.tencent.mm.plugin.finder.video.reporter.c cVar5 = aVar20.tHS;
                        if (cVar5 != null) {
                            i8 = cVar5.dGe();
                        } else {
                            i8 = -1;
                        }
                        bVar39.wiH = i8;
                        StringBuilder sb9 = new StringBuilder();
                        p.g(bVar39, "this");
                        Log.i("Finder.FinderVideoPlayReporter", sb9.append(com.tencent.mm.plugin.finder.video.reporter.b.a("onPlayerConfig", bVar39)).append(' ').append("mediaCodecInitDuration ").append(bVar39.wiH).append(" enableMediaCodecReuse:").append(bVar39.wiD).append(" mediaCodecReuseEnabled:").append(bVar39.wiE).append(' ').append("mediaCodecReused:").append(bVar39.wiF).append(" mediaCodecErrorCode:").append(bVar39.wiG).toString());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void d(bbn bbn) {
        p.h(bbn, "contextObj");
        this.ttO = bbn;
        this.vdR.d(bbn);
    }

    public void onVisible() {
        this.visible = true;
    }

    public void onInvisible() {
        this.visible = false;
    }

    public LinkedList<ecq> dnM() {
        return new LinkedList<>();
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e vdT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.vdT = eVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(250547);
            if (this.vdT.vdO != null) {
                com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                ((l) af).aST().b(this.vdT.vdO);
                this.vdT.vdO = null;
            }
            com.tencent.mm.plugin.finder.video.reporter.b bVar = this.vdT.vdR;
            StringBuilder sb = new StringBuilder("onRelease(), size:");
            ConcurrentHashMap<Long, b.C1322b> concurrentHashMap = bVar.whF;
            Log.i("Finder.FinderVideoPlayReporter", sb.append((concurrentHashMap != null ? Integer.valueOf(concurrentHashMap.size()) : null).intValue()).toString());
            ConcurrentHashMap<Long, b.C1322b> concurrentHashMap2 = bVar.whF;
            if (concurrentHashMap2 != null) {
                for (Map.Entry<Long, b.C1322b> entry : concurrentHashMap2.entrySet()) {
                    b.C1322b value = entry.getValue();
                    if (value != null) {
                        Object systemService = MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                        if (systemService == null) {
                            t tVar = new t("null cannot be cast to non-null type android.media.AudioManager");
                            AppMethodBeat.o(250547);
                            throw tVar;
                        }
                        value.vgv = ((AudioManager) systemService).getStreamVolume(3);
                        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(value.mediaPath);
                        if (aNx != null) {
                            value.wix = aNx.videoBitrate;
                            value.wiy = aNx.audioBitrate;
                        }
                        long aWA = cl.aWA();
                        if (value.vgo == 0) {
                            value.vgo = aWA - value.njx;
                            if (value.wii > 0) {
                                value.wih += aWA - value.wii;
                                value.wii = 0;
                            }
                            if (value.vgn > 0) {
                                value.vgm += aWA - value.vgn;
                                value.vgn = 0;
                            }
                        }
                        if (value.wil > 0) {
                            value.wim += aWA - value.wil;
                            value.wil = 0;
                            bek bek = new bek();
                            bek.LOf = (int) (aWA - value.wil);
                            bek.percent = value.whV;
                            bek.type = 0;
                            value.wit.add(bek);
                        }
                        if (value.wij == 0 && value.wif && value.whV < 5) {
                            value.jpW = 1;
                        }
                        Log.i("Finder.FinderVideoPlayReporter", com.tencent.mm.plugin.finder.video.reporter.b.a("onRelease", value) + " playTime:" + value.vgo + " pauseTotalTime:" + value.wih + " realPlayTime:" + value.vgm + " playStatus:" + value.jpW);
                        bVar.a(value);
                        bVar.b(value);
                    }
                }
            }
            bVar.whF = new ConcurrentHashMap<>();
            x xVar = x.SXb;
            AppMethodBeat.o(250547);
            return xVar;
        }
    }
}
