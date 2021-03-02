package com.tencent.mm.plugin.finder.upload;

import android.net.Uri;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.cgi.cb;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.d;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.bak;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bdq;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\u0018\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 H\u0002J \u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020*H\u0002J \u0010-\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u00100\u001a\u00020\r2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\"\u00106\u001a\u00020\u00192\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u001bH\u0002J,\u0010;\u001a\u00020\u00192\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u001b2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u000202H\u0002J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010?\u001a\u000202H\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\b\u0010B\u001a\u00020\u0019H\u0016J\u0010\u0010C\u001a\u00020\u00192\u0006\u0010?\u001a\u000202H\u0002J\b\u0010D\u001a\u00020\u001bH\u0016J\u0010\u0010E\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "mvClipListener", "getMvClipListener", "()Lcom/tencent/mm/modelbase/IOnSceneEnd;", "postClipFailed", "", "getPostClipFailed", "()Z", "setPostClipFailed", "(Z)V", "postingClipSet", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderDraftPost;", "Lkotlin/collections/HashSet;", "getPostingClipSet", "()Ljava/util/HashSet;", "checkIfNeedMarkDelete", "", "preUrl", "", "clearPostFile", "dealDumpCgi", "feedObject", "postScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "dealLongVideoCgi", "doMvPostScene", "doMvPostSceneContinue", "doPostScene", "doPostSceneContinue", "fillReportProcessCostTime", "finderItem", "succ", "costTime", "", "fillReportTotalCostTime", "svrId", "fillReportUploadCostTime", "isInPosting", "path", "isToManyTry", ch.COL_POSTINFO, "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "moveFileToPost", "moveFileToPostForNormal", "moveFileToPostForVLog", "notifyError", "errType", "", "errCode", "errMsg", "onSceneEnd", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "postFinderFeed", "postInfo", "postMvFeed", "saveToDb", "start", "tryPost", "uniqueId", "updateTryCount", "Companion", "plugin-finder_release"})
public class h extends j implements i {
    private static boolean vSQ;
    public static final a vSR = new a((byte) 0);
    FinderItem vRO;
    final HashSet<az> vSN = new HashSet<>();
    boolean vSO;
    final i vSP = new f(this);

    static {
        AppMethodBeat.i(167777);
        AppMethodBeat.o(167777);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ h vSS;
        final /* synthetic */ FinderItem vST;
        final /* synthetic */ cb vSU;

        b(h hVar, FinderItem finderItem, cb cbVar) {
            this.vSS = hVar;
            this.vST = finderItem;
            this.vSU = cbVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(253080);
            c.a aVar = (c.a) obj;
            FinderFeedReportObject finderFeedReportObject = this.vST.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.dumpCgiErrorType = aVar.errType;
            }
            FinderFeedReportObject finderFeedReportObject2 = this.vST.field_reportObject;
            if (finderFeedReportObject2 != null) {
                finderFeedReportObject2.dumpCgiErrorCode = aVar.errCode;
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vST);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                Log.i("Finder.LogPost.FinderPostTask", "dumpcgi, waitType:" + ((ara) aVar.iLC).LCN + " url:" + ((ara) aVar.iLC).url + ", thumbUrl:" + ((ara) aVar.iLC).thumbUrl);
                FinderObjectDesc finderObjectDesc = this.vSU.twb.LKf;
                if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null)) {
                    String str = ((ara) aVar.iLC).url;
                    if (str == null) {
                        str = "";
                    }
                    finderMedia.url = str;
                    String str2 = ((ara) aVar.iLC).thumbUrl;
                    if (str2 == null) {
                        str2 = "";
                    }
                    finderMedia.thumbUrl = str2;
                }
                this.vSU.twb.LCN = ((ara) aVar.iLC).LCN;
                Boolean valueOf = Boolean.valueOf(h.a(this.vSS, this.vSU));
                AppMethodBeat.o(253080);
                return valueOf;
            }
            this.vSS.a(com.tencent.mm.loader.g.j.Wait);
            x xVar = x.SXb;
            AppMethodBeat.o(253080);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoPostResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ h vSS;
        final /* synthetic */ FinderItem vST;
        final /* synthetic */ cb vSU;

        c(h hVar, FinderItem finderItem, cb cbVar) {
            this.vSS = hVar;
            this.vST = finderItem;
            this.vSU = cbVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            String str;
            AppMethodBeat.i(253081);
            c.a aVar = (c.a) obj;
            FinderFeedReportObject finderFeedReportObject = this.vST.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.megaCgiErrorType = aVar.errType;
            }
            FinderFeedReportObject finderFeedReportObject2 = this.vST.field_reportObject;
            if (finderFeedReportObject2 != null) {
                finderFeedReportObject2.megaCgiErrorCode = aVar.errCode;
            }
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vST);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                cng cng = ((cog) aVar.iLC).LIA;
                baq baq = this.vSU.twb;
                aoq aoq = new aoq();
                aoq.LAM = new LinkedList<>();
                LinkedList<aop> linkedList = aoq.LAM;
                aop aop = new aop();
                aop.type = 1;
                bei bei = new bei();
                bei.id = cng != null ? cng.id : 0;
                bei.LIA = cng;
                if (cng == null || (str = cng.LOd) == null) {
                    str = "";
                }
                bei.LOd = str;
                aop.LAL = bei;
                linkedList.add(aop);
                baq.attachmentList = aoq;
                Boolean valueOf = Boolean.valueOf(h.a(this.vSS, this.vSU));
                AppMethodBeat.o(253081);
                return valueOf;
            }
            this.vSS.a(com.tencent.mm.loader.g.j.Wait);
            x xVar = x.SXb;
            AppMethodBeat.o(253081);
            return xVar;
        }
    }

    public h(FinderItem finderItem) {
        p.h(finderItem, "finderObj");
        AppMethodBeat.i(167776);
        this.vRO = finderItem;
        AppMethodBeat.o(167776);
    }

    public static final /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(253097);
        hVar.dBd();
        AppMethodBeat.o(253097);
    }

    public static final /* synthetic */ void a(h hVar, FinderItem finderItem) {
        AppMethodBeat.i(167778);
        hVar.u(finderItem);
        AppMethodBeat.o(167778);
    }

    public static final /* synthetic */ boolean a(h hVar, cb cbVar) {
        AppMethodBeat.i(253102);
        boolean a2 = hVar.a(cbVar);
        AppMethodBeat.o(253102);
        return a2;
    }

    public static final /* synthetic */ void b(h hVar) {
        AppMethodBeat.i(253098);
        hVar.dBc();
        AppMethodBeat.o(253098);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderPostTask$Companion;", "", "()V", "TAG", "", "debugDeleteFileWhenMoveFile", "", "getDebugDeleteFileWhenMoveFile", "()Z", "setDebugDeleteFileWhenMoveFile", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.j
    public final void start() {
        int i2;
        boolean z;
        AppMethodBeat.i(253088);
        d dVar = d.vSt;
        long localId = this.vRO.getLocalId();
        int i3 = this.vRO.getPostInfo().Mpc;
        synchronized (dVar) {
            try {
                Iterator<d.a> it = d.vSq.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (it.next().localId == localId) {
                        i2 = i4;
                        break;
                    }
                    i4++;
                }
                if (i2 >= 0) {
                    Log.i(d.TAG, "exist check " + localId + ", progress:" + i3);
                } else {
                    d.vSq.add(new d.a(localId, i3, cl.aWy()));
                    Log.i(d.TAG, "add check " + localId + ", progress:" + i3);
                }
                if (!d.vSp) {
                    d.vSp = true;
                    com.tencent.f.h.RTc.o(new d.b(), d.vSr);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(253088);
                throw th;
            }
        }
        cjm postInfo = this.vRO.getPostInfo();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!((Boolean) com.tencent.mm.plugin.finder.storage.c.dsU().value()).booleanValue() || Log.getLogLevel() < 0) {
            if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                com.tencent.mm.plugin.finder.storage.c.dqv();
            }
            int i5 = postInfo.ibG;
            com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (i5 > com.tencent.mm.plugin.finder.storage.c.dqu()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                avW("try to post this feed too many times!");
                AppMethodBeat.o(253088);
                return;
            }
            r.d dVar2 = r.d.vhx;
            r.d.oc(this.vRO.isLongVideo());
            FinderItem finderItem = this.vRO;
            cjm postInfo2 = finderItem.getPostInfo();
            postInfo2.ibG++;
            finderItem.setPostInfo(postInfo2);
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(finderItem);
            if (this.vRO.isMvFeed()) {
                dBe();
                if (postInfo.Mpa == 1) {
                    c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    if (c.a.FR(this.vRO.getLocalId())) {
                        dBd();
                        AppMethodBeat.o(253088);
                        return;
                    }
                    Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
                    a(com.tencent.mm.loader.g.j.Wait);
                    AppMethodBeat.o(253088);
                    return;
                }
                c.a aVar3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                if (!c.a.FR(this.vRO.getLocalId())) {
                    Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
                    a(com.tencent.mm.loader.g.j.Wait);
                    AppMethodBeat.o(253088);
                    return;
                }
                g.a aVar4 = g.vSJ;
                g gVar = g.vSH;
                r rVar = new r(this.vRO);
                C1309h hVar = new C1309h(this);
                p.h(rVar, "processTask");
                p.h(hVar, "callback");
                gVar.vSD.a(rVar, hVar);
                AppMethodBeat.o(253088);
                return;
            }
            if (postInfo.Mpa == 1) {
                c.a aVar5 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                if (!c.a.FR(this.vRO.getLocalId())) {
                    Log.i("Finder.LogPost.FinderPostTask", "post before doscene2 cancel because feed is deleted");
                    a(com.tencent.mm.loader.g.j.Wait);
                    AppMethodBeat.o(253088);
                    return;
                }
            } else {
                Log.i("Finder.LogPost.FinderPostTask", "try post need upload task " + this.vRO.getLocalId());
                FinderObject finderObject = this.vRO.getFinderObject();
                if ((finderObject != null ? finderObject.objectDesc : null) != null && this.vRO.getRefObjectFlag() == 0) {
                    dBe();
                    c.a aVar6 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    if (!c.a.FR(this.vRO.getLocalId())) {
                        Log.i("Finder.LogPost.FinderPostTask", "post before mediaprocess cancel because feed is deleted");
                        a(com.tencent.mm.loader.g.j.Wait);
                        AppMethodBeat.o(253088);
                        return;
                    }
                    g.a aVar7 = g.vSJ;
                    g gVar2 = g.vSH;
                    c cVar4 = new c(this.vRO);
                    g gVar3 = new g(this);
                    p.h(cVar4, "processTask");
                    p.h(gVar3, "callback");
                    gVar2.vSC.a(cVar4, gVar3);
                    AppMethodBeat.o(253088);
                    return;
                }
            }
            u(this.vRO);
            AppMethodBeat.o(253088);
            return;
        }
        Log.i("Finder.LogPost.FinderPostTask", "debug failed");
        avW("failed for debug");
        com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
        com.tencent.mm.plugin.finder.storage.c.dsU().reset();
        AppMethodBeat.o(253088);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    public static final class g implements com.tencent.mm.loader.g.f<c> {
        final /* synthetic */ h vSS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(h hVar) {
            this.vSS = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(c cVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(253085);
            c cVar2 = cVar;
            p.h(cVar2, "task");
            p.h(jVar, "status");
            h.a(this.vSS, this.vSS.vRO, jVar == com.tencent.mm.loader.g.j.OK, cVar2.dBi());
            if (jVar != com.tencent.mm.loader.g.j.OK) {
                this.vSS.a(com.tencent.mm.loader.g.j.Wait);
                Log.i("Finder.LogPost.FinderPostTask", "process media failed.");
                r.d dVar = r.d.vhx;
                r.d.of(this.vSS.vRO.isLongVideo());
                AppMethodBeat.o(253085);
                return;
            }
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            if (!c.a.FR(this.vSS.vRO.getLocalId())) {
                Log.i("Finder.LogPost.FinderPostTask", "post before upload cancel because feed is deleted");
                this.vSS.a(com.tencent.mm.loader.g.j.Wait);
                AppMethodBeat.o(253085);
                return;
            }
            g.a aVar2 = g.vSJ;
            g gVar = g.vSH;
            n nVar = new n(this.vSS.vRO);
            a aVar3 = new a(this);
            p.h(nVar, "uploadTask");
            p.h(aVar3, "callback");
            gVar.vSA.a(nVar, aVar3);
            AppMethodBeat.o(253085);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostTask$postFinderFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
        public static final class a implements com.tencent.mm.loader.g.f<n> {
            final /* synthetic */ g vSV;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(g gVar) {
                this.vSV = gVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
            @Override // com.tencent.mm.loader.g.f
            public final /* synthetic */ void a(n nVar, com.tencent.mm.loader.g.j jVar) {
                AppMethodBeat.i(253084);
                n nVar2 = nVar;
                p.h(nVar2, "task");
                p.h(jVar, "status");
                h.b(this.vSV.vSS, this.vSV.vSS.vRO, jVar == com.tencent.mm.loader.g.j.OK, nVar2.dBi());
                com.tencent.mm.plugin.finder.utils.f fVar = com.tencent.mm.plugin.finder.utils.f.vVo;
                com.tencent.mm.plugin.finder.utils.f fVar2 = com.tencent.mm.plugin.finder.utils.f.vVo;
                com.tencent.mm.plugin.finder.utils.f.b(com.tencent.mm.plugin.finder.utils.f.dBB());
                Log.i("Finder.LogPost.FinderPostTask", "try post need upload task result " + this.vSV.vSS.vRO.getLocalId() + " ret " + jVar);
                if (jVar == com.tencent.mm.loader.g.j.OK) {
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    if (c.a.FR(this.vSV.vSS.vRO.getLocalId())) {
                        h.a(this.vSV.vSS, this.vSV.vSS.vRO);
                        AppMethodBeat.o(253084);
                        return;
                    }
                    Log.i("Finder.LogPost.FinderPostTask", "post before doScene cancel because feed is deleted");
                    this.vSV.vSS.a(com.tencent.mm.loader.g.j.Wait);
                    AppMethodBeat.o(253084);
                    return;
                }
                this.vSV.vSS.a(com.tencent.mm.loader.g.j.Wait);
                r.d dVar = r.d.vhx;
                r.d.oh(this.vSV.vSS.vRO.isLongVideo());
                AppMethodBeat.o(253084);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderMediaProcessTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.upload.h$h  reason: collision with other inner class name */
    public static final class C1309h implements com.tencent.mm.loader.g.f<r> {
        final /* synthetic */ h vSS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1309h(h hVar) {
            this.vSS = hVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(r rVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(253087);
            r rVar2 = rVar;
            p.h(rVar2, "task");
            p.h(jVar, "status");
            h.a(this.vSS, this.vSS.vRO, jVar == com.tencent.mm.loader.g.j.OK, rVar2.dBi());
            if (jVar != com.tencent.mm.loader.g.j.OK) {
                this.vSS.a(com.tencent.mm.loader.g.j.Wait);
                Log.i("Finder.LogPost.FinderPostTask", "process media failed.");
                r.d dVar = r.d.vhx;
                r.d.of(this.vSS.vRO.isLongVideo());
                AppMethodBeat.o(253087);
                return;
            }
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            if (!c.a.FR(this.vSS.vRO.getLocalId())) {
                Log.i("Finder.LogPost.FinderPostTask", "post before upload cancel because feed is deleted");
                this.vSS.a(com.tencent.mm.loader.g.j.Wait);
                AppMethodBeat.o(253087);
                return;
            }
            g.a aVar2 = g.vSJ;
            g gVar = g.vSH;
            s sVar = new s(this.vSS.vRO);
            a aVar3 = new a(this);
            p.h(sVar, "uploadTask");
            p.h(aVar3, "callback");
            gVar.vSE.a(sVar, aVar3);
            AppMethodBeat.o(253087);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostTask$postMvFeed$1$onLoaderFin$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.upload.h$h$a */
        public static final class a implements com.tencent.mm.loader.g.f<s> {
            final /* synthetic */ C1309h vSW;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(C1309h hVar) {
                this.vSW = hVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
            @Override // com.tencent.mm.loader.g.f
            public final /* synthetic */ void a(s sVar, com.tencent.mm.loader.g.j jVar) {
                AppMethodBeat.i(253086);
                s sVar2 = sVar;
                p.h(sVar2, "task");
                p.h(jVar, "status");
                h.b(this.vSW.vSS, this.vSW.vSS.vRO, jVar == com.tencent.mm.loader.g.j.OK, sVar2.dBi());
                com.tencent.mm.plugin.finder.utils.f fVar = com.tencent.mm.plugin.finder.utils.f.vVo;
                com.tencent.mm.plugin.finder.utils.f fVar2 = com.tencent.mm.plugin.finder.utils.f.vVo;
                com.tencent.mm.plugin.finder.utils.f.b(com.tencent.mm.plugin.finder.utils.f.dBB());
                Log.i("Finder.LogPost.FinderPostTask", "try post need upload task result " + this.vSW.vSS.vRO.getLocalId() + " ret " + jVar);
                if (jVar == com.tencent.mm.loader.g.j.OK) {
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    if (c.a.FR(this.vSW.vSS.vRO.getLocalId())) {
                        h.a(this.vSW.vSS);
                        AppMethodBeat.o(253086);
                        return;
                    }
                    Log.i("Finder.LogPost.FinderPostTask", "post before doScene cancel because feed is deleted");
                    this.vSW.vSS.a(com.tencent.mm.loader.g.j.Wait);
                    AppMethodBeat.o(253086);
                    return;
                }
                this.vSW.vSS.a(com.tencent.mm.loader.g.j.Wait);
                r.d dVar = r.d.vhx;
                r.d.oh(this.vSW.vSS.vRO.isLongVideo());
                AppMethodBeat.o(253086);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderPostTask$mvClipListener$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class f implements i {
        final /* synthetic */ h vSS;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(h hVar) {
            this.vSS = hVar;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            T t;
            long j2;
            String str2 = null;
            AppMethodBeat.i(253083);
            if ((qVar instanceof az) && this.vSS.vSN.contains(qVar)) {
                this.vSS.vSN.remove(qVar);
                if (i2 == 0 && i3 == 0) {
                    com.tencent.mm.bw.a aYK = ((az) qVar).iUB.aYK();
                    if (aYK == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostDraftResponse");
                        AppMethodBeat.o(253083);
                        throw tVar;
                    }
                    FinderObject finderObject = ((bak) aYK).LCD;
                    Iterator<T> it = this.vSS.vRO.getClipListExt().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (p.j(next.getObjectNonceId(), ((az) qVar).tuX.getObjectNonceId())) {
                            t = next;
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        t2.getFeedObject().id = finderObject != null ? finderObject.id : 0;
                    }
                    axz axz = ((az) qVar).tuY;
                    if (finderObject != null) {
                        j2 = finderObject.id;
                    } else {
                        j2 = 0;
                    }
                    axz.refObjectId = j2;
                    axz axz2 = ((az) qVar).tuY;
                    if (finderObject != null) {
                        str2 = finderObject.objectNonceId;
                    }
                    axz2.LIm = str2;
                    ((az) qVar).tuY.Ghw = 0;
                    h.b(this.vSS);
                } else {
                    this.vSS.vSO = true;
                }
                if (this.vSS.vSN.isEmpty() && !this.vSS.vSO) {
                    h.c(this.vSS);
                    AppMethodBeat.o(253083);
                    return;
                } else if (this.vSS.vSN.isEmpty() && this.vSS.vSO) {
                    this.vSS.a(com.tencent.mm.loader.g.j.Wait);
                }
            }
            AppMethodBeat.o(253083);
        }
    }

    private final void dBc() {
        AppMethodBeat.i(253089);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.q(this.vRO);
        AppMethodBeat.o(253089);
    }

    private final void dBd() {
        AppMethodBeat.i(253090);
        com.tencent.mm.ac.d.h(new d(this));
        AppMethodBeat.o(253090);
    }

    private final void u(FinderItem finderItem) {
        AppMethodBeat.i(167770);
        com.tencent.mm.ac.d.h(new e(this, finderItem));
        AppMethodBeat.o(167770);
    }

    private final boolean a(cb cbVar) {
        AppMethodBeat.i(253091);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dra().value().intValue() == 3) {
            a(com.tencent.mm.loader.g.j.Fail);
            AppMethodBeat.o(253091);
            return false;
        }
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(3585, this);
        boolean b2 = com.tencent.mm.kernel.g.azz().b(cbVar);
        AppMethodBeat.o(253091);
        return b2;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        FinderFeedReportObject finderFeedReportObject;
        FinderFeedReportObject finderFeedReportObject2;
        AppMethodBeat.i(167771);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(3585, this);
        if (qVar == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPost");
            AppMethodBeat.o(167771);
            throw tVar;
        }
        String str2 = ((cb) qVar).clientId;
        Log.i("Finder.LogPost.FinderPostTask", "errType %d, errCode %d, errMsg %s, clientId %s", Integer.valueOf(i2), Integer.valueOf(i3), str, str2);
        if (!str2.equals(this.vRO.getPostInfo().clientId)) {
            Log.w("Finder.LogPost.FinderPostTask", "not my feed!");
            AppMethodBeat.o(167771);
            return;
        }
        this.vRO.trackPost("doPostSceneEnd");
        if (i2 == 0 && i3 == 0) {
            long j2 = ((cb) qVar).feedObject.id;
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            FinderItem Fy = e.a.Fy(j2);
            if (!(Fy == null || (finderFeedReportObject2 = Fy.field_reportObject) == null)) {
                finderFeedReportObject2.postTaskCost += (int) dBi();
            }
            if (!(Fy == null || (finderFeedReportObject = Fy.field_reportObject) == null)) {
                i iVar = i.vSX;
                i.a(finderFeedReportObject, "postSuccess");
            }
            g.a aVar2 = g.vSJ;
            com.tencent.mm.ac.d.h(new g.e(g.vSH, this.vRO.getLocalId(), ((cb) qVar).feedObject.id));
            if (this.vRO.getPostInfo().Mpd > 0) {
                r.c cVar = r.c.vhb;
                r.c.y(cl.aWy() - this.vRO.getPostInfo().Mpd, this.vRO.isLongVideo());
            }
            a(com.tencent.mm.loader.g.j.OK);
            AppMethodBeat.o(167771);
            return;
        }
        a(com.tencent.mm.loader.g.j.Wait);
        if (this.vRO.isPostFailed()) {
            com.tencent.mm.plugin.finder.report.i iVar2 = com.tencent.mm.plugin.finder.report.i.vfo;
            com.tencent.mm.plugin.finder.report.i.j(this.vRO.getLocalId(), i2, i3);
            g.a aVar3 = g.vSJ;
            g.vSH.FY(this.vRO.getLocalId());
        }
        AppMethodBeat.o(167771);
    }

    @Override // com.tencent.mm.loader.g.c
    public String auK() {
        AppMethodBeat.i(167772);
        String str = "post_" + this.vRO.getLocalId();
        AppMethodBeat.o(167772);
        return str;
    }

    private final void avW(String str) {
        AppMethodBeat.i(167773);
        Log.w("Finder.LogPost.FinderPostTask", "post failed, errType %d, errCode %d, errMsg %s", -1, -1, str);
        this.vRO.setPostFailed();
        FinderFeedReportObject finderFeedReportObject = this.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.cgiErrorType = -1;
        }
        FinderFeedReportObject finderFeedReportObject2 = this.vRO.field_reportObject;
        if (finderFeedReportObject2 != null) {
            finderFeedReportObject2.cgiErrorCode = -1;
        }
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(this.vRO);
        a(com.tencent.mm.loader.g.j.Fail);
        g.a aVar2 = g.vSJ;
        g.vSH.FY(this.vRO.getLocalId());
        r.d dVar = r.d.vhx;
        r.d.ob(this.vRO.isLongVideo());
        AppMethodBeat.o(167773);
    }

    private final void dBe() {
        AppMethodBeat.i(167774);
        Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost");
        al alVar = al.waC;
        String dEH = al.dEH();
        s.boN(dEH);
        if (vSQ && Log.getLogLevel() <= 1) {
            Log.i("Finder.LogPost.FinderPostTask", "debugDeleteFileWhenMoveFile");
            s.dy(dEH, true);
        }
        if (!this.vRO.isMvFeed()) {
            if (this.vRO.getMediaExtList().size() != 1 || this.vRO.getMediaExtList().get(0).MfU == null) {
                dBg();
            } else {
                dBf();
            }
            this.vRO.setMediaList(this.vRO.getMediaList());
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vRO);
        }
        AppMethodBeat.o(167774);
    }

    private final void dBf() {
        String str;
        LinkedList<ejf> linkedList;
        T t;
        AppMethodBeat.i(253092);
        acn acn = this.vRO.getMediaExtList().get(0).MfU;
        if (!(acn == null || (linkedList = acn.Lnd) == null)) {
            for (T t2 : linkedList) {
                if (s.YS(t2.path)) {
                    String str2 = t2.path;
                    p.g(str2, "it.path");
                    al alVar = al.waC;
                    if (!n.J(str2, al.dEH(), false)) {
                        al alVar2 = al.waC;
                        String awC = al.awC(MD5Util.getMD5String(t2.path) + t2.hashCode());
                        String str3 = t2.path;
                        if (Build.VERSION.SDK_INT >= 30) {
                            Uri P = p.b.P(MMApplicationContext.getContext(), str3);
                            if (str3 != null) {
                                str3 = String.valueOf(P);
                            }
                        }
                        s.nw(str3, awC);
                        Log.i("Finder.LogPost.FinderPostTask", "copy " + t2.path + " to " + awC + "  real:" + s.k(awC, false) + ",result:" + s.YS(awC));
                        if (s.YS(awC)) {
                            if (t2.Gze == 1) {
                                com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                                com.tencent.mm.plugin.recordvideo.e.c.aLC(t2.path);
                            }
                            LinkedList<acp> linkedList2 = acn.Lnj;
                            kotlin.g.b.p.g(linkedList2, "compositionInfo.trackLabelInfoList");
                            Iterator<T> it = linkedList2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    t = null;
                                    break;
                                }
                                T next = it.next();
                                if (kotlin.g.b.p.j(next.path, t2.path)) {
                                    t = next;
                                    break;
                                }
                            }
                            T t3 = t;
                            if (t3 != null) {
                                t3.path = awC;
                            }
                            t2.path = awC;
                        }
                    }
                }
            }
        }
        String str4 = this.vRO.getMediaExtList().get(0).thumbUrl;
        if (s.YS(str4) && str4 != null) {
            al alVar3 = al.waC;
            if (!n.J(str4, al.dEH(), false)) {
                al alVar4 = al.waC;
                String awC2 = al.awC(MD5Util.getMD5String(str4) + str4.hashCode());
                if (Build.VERSION.SDK_INT >= 30) {
                    str = String.valueOf(p.b.O(MMApplicationContext.getContext(), str4));
                } else {
                    str = str4;
                }
                s.nw(str, awC2);
                Log.i("Finder.LogPost.FinderPostTask", "copy thumb" + str4 + " to " + awC2 + "  real:" + s.k(awC2, false) + ",result:" + s.YS(awC2));
                if (s.YS(awC2)) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar2 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.aLC(str4);
                    this.vRO.getMediaExtList().get(0).thumbUrl = awC2;
                }
            }
        }
        AppMethodBeat.o(253092);
    }

    private static boolean avX(String str) {
        AppMethodBeat.i(253093);
        if (str != null) {
            al alVar = al.waC;
            boolean J = n.J(str, al.dEH(), false);
            AppMethodBeat.o(253093);
            return J;
        }
        AppMethodBeat.o(253093);
        return false;
    }

    private final void dBg() {
        String str;
        AppMethodBeat.i(253094);
        int i2 = 0;
        for (T t : this.vRO.getMediaList()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            boolean YS = s.YS(t2.url);
            boolean YS2 = s.YS(t2.thumbUrl);
            boolean YS3 = s.YS(t2.coverUrl);
            String mD5String = MD5Util.getMD5String(t2.url);
            boolean avX = avX(t2.url);
            boolean avX2 = avX(t2.thumbUrl);
            boolean avX3 = avX(t2.coverUrl);
            Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost, mediaId: " + mD5String + ", fileExist:" + YS + ", thumbExist:" + YS2 + ", before url: " + t2.url + ", " + t2.thumbUrl + ", " + t2.coverUrl);
            if (YS || YS2) {
                switch (t2.mediaType) {
                    case 2:
                    case 7:
                        if (YS && YS2 && !avX2) {
                            Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image thumb");
                            f fVar = f.vSz;
                            String str2 = t2.url;
                            if (str2 == null) {
                                str2 = "";
                            }
                            String str3 = t2.thumbUrl;
                            if (str3 == null) {
                                str3 = "";
                            }
                            String gY = f.gY(str2, str3);
                            if (s.YS(gY)) {
                                t2.thumbUrl = gY;
                            }
                        }
                        if (YS && !avX) {
                            Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Image");
                            k kVar = new k(t2, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE, null, null, 12);
                            al alVar = al.waC;
                            String a2 = al.a(kVar, String.valueOf(this.vRO.m21getCreateTime()));
                            long nw = s.nw(t2.url, a2);
                            if (s.YS(a2)) {
                                t2.url = a2;
                                t2.mediaId = MD5Util.getMD5String(t2.url);
                                break;
                            } else {
                                Log.i("Finder.LogPost.FinderPostTask", "copy Image failed, copyRet:".concat(String.valueOf(nw)));
                                break;
                            }
                        }
                    case 4:
                        if (!this.vRO.isNeedCrop(i2)) {
                            if (YS && YS2 && !avX2) {
                                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video thumb");
                                String str4 = t2.thumbUrl;
                                if (str4 == null) {
                                    str4 = "";
                                }
                                kotlin.g.b.p.g(str4, "it.thumbUrl ?: \"\"");
                                f fVar2 = f.vSz;
                                String str5 = t2.url;
                                if (str5 == null) {
                                    str5 = "";
                                }
                                String str6 = t2.thumbUrl;
                                if (str6 == null) {
                                    str6 = "";
                                }
                                String gX = f.gX(str5, str6);
                                if (s.YS(gX)) {
                                    t2.thumbUrl = gX;
                                    if (!kotlin.g.b.p.j(str4, t2.thumbUrl)) {
                                        avY(str4);
                                    }
                                }
                            }
                            if (YS && !avX) {
                                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Video");
                                com.tencent.mm.plugin.finder.loader.s sVar = new com.tencent.mm.plugin.finder.loader.s(t2, com.tencent.mm.plugin.finder.storage.x.V99_VIDEO, 0, null, 12);
                                al alVar2 = al.waC;
                                String a3 = al.a(sVar, String.valueOf(this.vRO.m21getCreateTime()));
                                long nw2 = s.nw(t2.url, a3);
                                if (s.YS(a3)) {
                                    if (!kotlin.g.b.p.j(a3, t2.url)) {
                                        String str7 = t2.url;
                                        if (str7 == null) {
                                            str7 = "";
                                        }
                                        avY(str7);
                                    }
                                    t2.url = a3;
                                    String str8 = t2.url;
                                    if (str8 == null) {
                                        str8 = "";
                                    }
                                    t2.mediaId = MD5Util.getMD5String(str8);
                                } else {
                                    Log.i("Finder.LogPost.FinderPostTask", "copy Video failed, copyRet:".concat(String.valueOf(nw2)));
                                }
                            }
                        }
                        if (YS3 && !avX3 && (str = t2.coverUrl) != null) {
                            al alVar3 = al.waC;
                            if (n.J(str, al.dEH(), false)) {
                                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost Cover");
                                com.tencent.mm.plugin.finder.loader.q qVar = new com.tencent.mm.plugin.finder.loader.q(t2, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                                al alVar4 = al.waC;
                                String a4 = al.a(qVar, String.valueOf(this.vRO.m21getCreateTime()));
                                s.nw(t2.coverUrl, a4);
                                t2.coverUrl = a4;
                                break;
                            }
                        }
                        break;
                }
                Log.i("Finder.LogPost.FinderPostTask", "moveFileToPost, after mediaId: " + t2.mediaId + ", url: " + t2.url + ", " + t2.thumbUrl + ", " + t2.coverUrl);
            }
            i2 = i3;
        }
        AppMethodBeat.o(253094);
    }

    private static void avY(String str) {
        AppMethodBeat.i(167775);
        al alVar = al.waC;
        if (n.J(str, al.dEH(), false)) {
            f fVar = f.vSz;
            f.avV(str);
        }
        AppMethodBeat.o(167775);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ h vSS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(0);
            this.vSS = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            T t;
            AppMethodBeat.i(253082);
            Log.i("Finder.LogPost.FinderPostTask", "doMvPostScene " + this.vSS.vRO.getLocalId());
            r.d dVar = r.d.vhx;
            r.d.oi(this.vSS.vRO.isLongVideo());
            this.vSS.vRO.trackPost("doMvPostScene");
            FinderFeedReportObject finderFeedReportObject = this.vSS.vRO.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.postStage = 7;
            }
            h.b(this.vSS);
            FinderObjectDesc finderObjectDesc = this.vSS.vRO.getFeedObject().objectDesc;
            axw axw = finderObjectDesc != null ? finderObjectDesc.mvInfo : null;
            if (axw == null) {
                this.vSS.a(com.tencent.mm.loader.g.j.Fail);
            } else {
                com.tencent.mm.kernel.g.azz().a(6649, this.vSS.vSP);
                LinkedList<axz> linkedList = new LinkedList();
                LinkedList<axz> linkedList2 = axw.LId;
                kotlin.g.b.p.g(linkedList2, "mvInfo.orderedTrackList");
                ArrayList arrayList = new ArrayList();
                for (T t2 : linkedList2) {
                    if (t2.refObjectId == 0) {
                        arrayList.add(t2);
                    }
                }
                linkedList.addAll(arrayList);
                for (axz axz : linkedList) {
                    Iterator<T> it = this.vSS.vRO.getClipListExt().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (kotlin.g.b.p.j(next.getObjectNonceId(), axz.LIm)) {
                            t = next;
                            break;
                        }
                    }
                    T t3 = t;
                    if (t3 != null) {
                        this.vSS.vSN.add(new az(t3, axz, (byte) 0));
                    }
                }
                if (!this.vSS.vSN.isEmpty()) {
                    Iterator<T> it2 = this.vSS.vSN.iterator();
                    while (it2.hasNext()) {
                        com.tencent.mm.kernel.g.azz().b((q) it2.next());
                    }
                } else {
                    h.c(this.vSS);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253082);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ h vSS;
        final /* synthetic */ FinderItem vST;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar, FinderItem finderItem) {
            super(0);
            this.vSS = hVar;
            this.vST = finderItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            String str = null;
            AppMethodBeat.i(167766);
            Log.i("Finder.LogPost.FinderPostTask", "doPostScene " + this.vST.getLocalId());
            r.d dVar = r.d.vhx;
            r.d.oi(this.vST.isLongVideo());
            this.vST.trackPost("doPostScene");
            FinderFeedReportObject finderFeedReportObject = this.vST.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.postStage = 4;
            }
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vST);
            FinderItem finderItem = this.vST;
            String str2 = this.vST.getPostInfo().clientId;
            if (str2 == null) {
                str2 = "";
            }
            cb cbVar = new cb(finderItem, str2, this.vST.getLocalId());
            aoq aoq = this.vST.getFeedObject().attachmentList;
            if (!Util.isNullOrNil(aoq != null ? aoq.LAM : null)) {
                h.a(this.vSS, this.vST, cbVar);
            } else {
                dmr dmr = this.vST.getPostInfo().Mph;
                if (dmr != null) {
                    str = dmr.tsW;
                }
                if (!Util.isNullOrNil(str)) {
                    h.b(this.vSS, this.vST, cbVar);
                } else {
                    h.a(this.vSS, cbVar);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(167766);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(h hVar, FinderItem finderItem, boolean z, long j2) {
        AppMethodBeat.i(253095);
        FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.mediaProcessCost += (int) j2;
            finderFeedReportObject.postTaskCost += (int) hVar.dBi();
            hVar.dBj();
        }
        FinderFeedReportObject finderFeedReportObject2 = finderItem.field_reportObject;
        if (finderFeedReportObject2 != null) {
            i iVar = i.vSX;
            i.a(finderFeedReportObject2, z ? "processSucc" : "processFailed");
            AppMethodBeat.o(253095);
            return;
        }
        AppMethodBeat.o(253095);
    }

    public static final /* synthetic */ void b(h hVar, FinderItem finderItem, boolean z, long j2) {
        AppMethodBeat.i(253096);
        FinderFeedReportObject finderFeedReportObject = finderItem.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.uploadCost += (int) j2;
            finderFeedReportObject.postTaskCost += (int) hVar.dBi();
            hVar.dBj();
        }
        FinderFeedReportObject finderFeedReportObject2 = finderItem.field_reportObject;
        if (finderFeedReportObject2 != null) {
            i iVar = i.vSX;
            i.a(finderFeedReportObject2, z ? "uploadSucc" : "uploadFailed");
            AppMethodBeat.o(253096);
            return;
        }
        AppMethodBeat.o(253096);
    }

    public static final /* synthetic */ void c(h hVar) {
        AppMethodBeat.i(253099);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        if (c.a.FR(hVar.vRO.getLocalId())) {
            r.d dVar = r.d.vhx;
            r.d.oi(hVar.vRO.isLongVideo());
            hVar.vRO.trackPost("doMvPostScene");
            FinderFeedReportObject finderFeedReportObject = hVar.vRO.field_reportObject;
            if (finderFeedReportObject != null) {
                finderFeedReportObject.postStage = 4;
            }
            hVar.dBc();
            FinderItem finderItem = hVar.vRO;
            String str = hVar.vRO.getPostInfo().clientId;
            if (str == null) {
                str = "";
            }
            hVar.a(new cb(finderItem, str, hVar.vRO.getLocalId()));
            AppMethodBeat.o(253099);
            return;
        }
        Log.i("Finder.LogPost.FinderPostTask", "post before doScene cancel because feed is deleted");
        hVar.a(com.tencent.mm.loader.g.j.Wait);
        AppMethodBeat.o(253099);
    }

    public static final /* synthetic */ void a(h hVar, FinderItem finderItem, cb cbVar) {
        String str;
        String str2;
        String str3;
        cnp cnp;
        axt axt;
        aqp aqp;
        axt axt2;
        bdq bdq;
        coc coc = null;
        AppMethodBeat.i(253100);
        String str4 = finderItem.getPostInfo().clientId;
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        cnl cnl = new cnl();
        FinderObjectDesc finderObjectDesc = cbVar.twb.LKf;
        if (finderObjectDesc == null || (str2 = finderObjectDesc.description) == null) {
            str2 = "";
        }
        cnl.description = str2;
        LinkedList<cod> linkedList = new LinkedList<>();
        LinkedList<cjl> longVideoMediaExtList = finderItem.getLongVideoMediaExtList();
        ArrayList arrayList = new ArrayList(j.a(longVideoMediaExtList, 10));
        for (T t : longVideoMediaExtList) {
            cod d2 = o.d(t);
            d2.url = t.MoM;
            d2.thumbUrl = t.MoN;
            d2.md5sum = t.md5sum;
            arrayList.add(d2);
        }
        linkedList.addAll(arrayList);
        cnl.media = linkedList;
        cnl.mediaType = 0;
        FinderObjectDesc finderObjectDesc2 = cbVar.twb.LKf;
        if (finderObjectDesc2 == null || (bdq = finderObjectDesc2.topic) == null || (str3 = bdq.LNs) == null) {
            str3 = "";
        }
        cnl.MtR = str3;
        FinderObjectDesc finderObjectDesc3 = cbVar.twb.LKf;
        cnl.MtS = (finderObjectDesc3 == null || (axt2 = finderObjectDesc3.location) == null) ? null : aj.a(axt2);
        FinderObjectDesc finderObjectDesc4 = cbVar.twb.LKf;
        if (finderObjectDesc4 == null || (aqp = finderObjectDesc4.extReading) == null) {
            cnp = null;
        } else {
            kotlin.g.b.p.h(aqp, "$this$toMega");
            cnp = new cnp();
            cnp.link = aqp.link;
            cnp.title = aqp.title;
        }
        cnl.MtT = cnp;
        FinderObjectDesc finderObjectDesc5 = cbVar.twb.LKf;
        if (!(finderObjectDesc5 == null || (axt = finderObjectDesc5.feed_location) == null)) {
            coc = aj.a(axt);
        }
        cnl.MtU = coc;
        new ak(str, cnl).aYI().g(new c(hVar, finderItem, cbVar));
        AppMethodBeat.o(253100);
    }

    public static final /* synthetic */ void b(h hVar, FinderItem finderItem, cb cbVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        AppMethodBeat.i(253101);
        dmr dmr = finderItem.getPostInfo().Mph;
        String str7 = finderItem.getPostInfo().clientId;
        if (str7 == null) {
            str = "";
        } else {
            str = str7;
        }
        if (dmr == null || (str6 = dmr.tsW) == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        if (dmr == null || (str5 = dmr.dNI) == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        if (dmr == null || (str4 = dmr.tsX) == null) {
            str4 = "";
        }
        new com.tencent.mm.plugin.finder.cgi.j(str, str2, str3, str4).aYI().g(new b(hVar, finderItem, cbVar));
        AppMethodBeat.o(253101);
    }
}
