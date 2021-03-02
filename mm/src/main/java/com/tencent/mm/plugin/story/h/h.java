package com.tencent.mm.plugin.story.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jd;
import com.tencent.mm.g.b.a.je;
import com.tencent.mm.g.b.a.jg;
import com.tencent.mm.g.b.a.jh;
import com.tencent.mm.g.b.a.ji;
import com.tencent.mm.g.b.a.jj;
import com.tencent.mm.g.b.a.jk;
import com.tencent.mm.g.b.a.jl;
import com.tencent.mm.g.b.a.jm;
import com.tencent.mm.g.b.a.jn;
import com.tencent.mm.g.b.a.jo;
import com.tencent.mm.g.b.a.jp;
import com.tencent.mm.g.b.a.jr;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.g.b.a.jv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b3\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\nJ\u0010\u0010O\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010Q\u001a\u00020\u001e2\b\u0010P\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010R\u001a\u00020M2\u0006\u0010S\u001a\u00020\u001aJ\u000e\u0010T\u001a\u00020M2\u0006\u0010U\u001a\u00020\u001eJ\u0006\u0010V\u001a\u00020MJ\u0006\u0010W\u001a\u00020MJ\u0006\u0010X\u001a\u00020MJ\u0006\u0010Y\u001a\u00020MJ\u0006\u0010Z\u001a\u00020MJ\u0006\u0010[\u001a\u00020MJ\u0006\u0010\\\u001a\u00020MJ\u0006\u0010]\u001a\u00020MJ\u0006\u0010^\u001a\u00020MJ\u0006\u0010_\u001a\u00020MJ\u0006\u0010`\u001a\u00020MJ\u000e\u0010a\u001a\u00020M2\u0006\u0010b\u001a\u00020\nJ\u0006\u0010c\u001a\u00020MJ\u001e\u0010d\u001a\u00020M2\u0006\u0010S\u001a\u00020\u001a2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nJ\u000e\u0010g\u001a\u00020M2\u0006\u0010S\u001a\u00020\u001aJ\u000e\u0010h\u001a\u00020G2\u0006\u0010b\u001a\u00020\nJ\u0006\u0010i\u001a\u00020'J\u0006\u0010j\u001a\u00020,J\u0006\u0010k\u001a\u00020.J\u0006\u0010l\u001a\u000200J\u0006\u0010m\u001a\u000202J\u0006\u0010n\u001a\u000204J\u0006\u0010o\u001a\u000206J\u0006\u0010p\u001a\u000208J\u0006\u0010q\u001a\u00020<J\u0006\u0010r\u001a\u00020>J\u0006\u0010s\u001a\u00020IJ4\u0010t\u001a\u00020M2\u0006\u0010u\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u001a2\b\b\u0002\u0010v\u001a\u00020\u00042\b\b\u0002\u0010w\u001a\u00020\u00042\b\b\u0002\u0010x\u001a\u00020\u0004J\u0006\u0010y\u001a\u00020MJ\u0006\u0010z\u001a\u00020MJ\u0006\u0010{\u001a\u00020MJ\u0016\u0010|\u001a\u00020M2\u0006\u0010b\u001a\u00020\n2\u0006\u0010}\u001a\u00020\u001aJ\u001e\u0010~\u001a\u00020M2\u0006\u0010b\u001a\u00020\n2\u0006\u0010}\u001a\u00020\u001a2\u0006\u0010\u001a\u00020\u001eR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR2\u0010\u0018\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020G0FX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u001aXT¢\u0006\u0002\n\u0000R2\u0010K\u001a&\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a \u001b*\u0012\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010\u001c0\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/story/report/StoryReporter;", "", "()V", "cameraDot", "", "getCameraDot", "()J", "setCameraDot", "(J)V", "currentEntranceExposeTime", "", "getCurrentEntranceExposeTime", "()I", "setCurrentEntranceExposeTime", "(I)V", "currentProfileTabVideoObjectId", "getCurrentProfileTabVideoObjectId", "setCurrentProfileTabVideoObjectId", "lastTrace", "getLastTrace", "setLastTrace", "moreTabDot", "getMoreTabDot", "setMoreTabDot", "nameSet", "", "", "kotlin.jvm.PlatformType", "", "needCommentRpt", "", "getNeedCommentRpt", "()Z", "setNeedCommentRpt", "(Z)V", "needVisitorRpt", "getNeedVisitorRpt", "setNeedVisitorRpt", "storyChatTopBarEntranceExpose", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryChatTopBarEntranceExposeStruct;", "storyCommentDot", "getStoryCommentDot", "setStoryCommentDot", "storyDoubleTapHeadView", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoubleTapHeadViewStruct;", "storyDownloadReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDownloadReportStruct;", "storyEntranceExposeReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryEntranceExposeReportStruct;", "storyImageVideoRemux", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoRemuxStruct;", "storyImageVideoZip", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryImageVideoZipStruct;", "storyPageExposeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPageExposeStruct;", "storyPreviewReportStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryPreviewReportStruct;", "storyPreviewTraceStruct", "Lcom/tencent/mm/plugin/story/report/StoryBehaviorTraceData;", "storyProfileTabExposeReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryProfileTabExposeStruct;", "storySinglePreviewReport", "Lcom/tencent/mm/autogen/mmdata/rpt/StorySinglePreviewReportStruct;", "storyStatusChangeStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "getStoryStatusChangeStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;", "setStoryStatusChangeStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/StoryStatusChangeStruct;)V", "storyUploadMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryUploadReportStruct;", "storyVideoPublish", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryComposeReportStruct;", "tag", "videoIdSet", "addPreviewTrace", "", "aid", "checkRepeatUser", "name", "checkRepeatVideo", "doCommentPageExposeReport", "storyId", "doEntranceClearReport", "delete", "doStoryChatTopBarEntranceExposeReport", "doStoryDoubleTapHeadViewReport", "doStoryDownloadReport", "doStoryEntranceReport", "doStoryImageVideoRemuxReport", "doStoryImageVideoZipReport", "doStoryPageReport", "doStoryPreviewReport", "doStoryProfileTabExposeReport", "doStorySinglePreviewReport", "doStoryStatusChangeReport", "doStoryUploadReport", "storyLocalId", "doStoryVideoPublishReport", "doVisiteReport", "visitorCount", "commentCount", "doVisitorPageExposeReport", "getLastStoryUploadReporter", "getStoryChatTopBarEntranceExposeReporter", "getStoryDoubleTapHeadViewReporter", "getStoryDownloadReporter", "getStoryEntranceReport", "getStoryImageVideoRemuxReporter", "getStoryImageVideoZipReporter", "getStoryPageExposeReporter", "getStoryPreviewReporter", "getStoryProfileTabExposeReport", "getStorySinglePreviewReporter", "getStoryVideoPublishReporter", "reportStoryStatusChange", "status", "previewEnterScene", "profileSource", "isAlbumStarButton", "resetStoryPreviewReporter", "resetStoryPreviewTraceData", "resetStoryProfileTabExposeReport", "storyUploadReportCPMediaInfo", "path", "storyUploadReportOriMediaInfo", "isCaptureVideo", "plugin-story_release"})
public final class h {
    private static int BXD = -1;
    private static long FuA;
    private static long FuB;
    private static long FuC;
    private static long FuD;
    private static int FuE;
    private static jj FuF = new jj();
    private static ju FuG = new ju();
    public static final h FuH = new h();
    private static jn Fuk = new jn();
    private static jo Ful = new jo();
    private static a Fum = new a();
    private static Set<String> Fun = Collections.synchronizedSet(new HashSet());
    private static Set<String> Fuo = Collections.synchronizedSet(new HashSet());
    private static boolean Fup = true;
    private static boolean Fuq = true;
    private static jd Fur = new jd();
    private static jg Fus = new jg();
    private static je Fut = new je();
    private static jl Fuu = new jl();
    private static jm Fuv = new jm();
    private static jh Fuw = new jh();
    private static final HashMap<Integer, jv> Fux = new HashMap<>();
    private static jr Fuy = new jr();
    private static jp Fuz = new jp();

    static {
        AppMethodBeat.i(119464);
        AppMethodBeat.o(119464);
    }

    private h() {
    }

    public static void fqh() {
        BXD = 1;
    }

    public static boolean aSm(String str) {
        AppMethodBeat.i(119441);
        if (str == null) {
            AppMethodBeat.o(119441);
            return true;
        } else if (Fun.contains(str)) {
            AppMethodBeat.o(119441);
            return true;
        } else {
            Fun.add(str);
            AppMethodBeat.o(119441);
            return false;
        }
    }

    public static boolean aSn(String str) {
        AppMethodBeat.i(119442);
        if (str == null) {
            AppMethodBeat.o(119442);
            return true;
        } else if (Fuo.contains(str)) {
            AppMethodBeat.o(119442);
            return true;
        } else {
            Fuo.add(str);
            AppMethodBeat.o(119442);
            return false;
        }
    }

    public static jo fqi() {
        return Ful;
    }

    public static void aaT(int i2) {
        boolean z;
        AppMethodBeat.i(119443);
        if (BXD == -1 && i2 == 4) {
            BXD = i2;
            AppMethodBeat.o(119443);
        } else if (BXD == 10 && i2 == 11) {
            BXD = i2;
            AppMethodBeat.o(119443);
        } else {
            BXD = i2;
            a aVar = Fum;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("aid", i2);
            jSONObject.put("td", aVar.BXw.length() + 1);
            if (aVar.BXw.toString().length() + jSONObject.toString().length() > 1000) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                synchronized (aVar.lock) {
                    try {
                        aVar.BXw.put(jSONObject);
                    } finally {
                        AppMethodBeat.o(119443);
                    }
                }
                return;
            }
            AppMethodBeat.o(119443);
        }
    }

    public static void fqk() {
        AppMethodBeat.i(119445);
        Ful = new jo();
        fql();
        AppMethodBeat.o(119445);
    }

    public static void fql() {
        AppMethodBeat.i(119446);
        Fum = new a();
        BXD = -1;
        Fun.clear();
        Fuo.clear();
        AppMethodBeat.o(119446);
    }

    public static jn fqm() {
        return Fuk;
    }

    public static void fqn() {
        AppMethodBeat.i(119447);
        Fuk.bfK();
        Fuk = new jn();
        AppMethodBeat.o(119447);
    }

    public static void vU(boolean z) {
        Fup = z;
    }

    public static void aSo(String str) {
        AppMethodBeat.i(119448);
        p.h(str, "storyId");
        if (Fup) {
            Fuk.sj(8);
            Fuk.wR(str);
            fqn();
        }
        AppMethodBeat.o(119448);
    }

    public static void vV(boolean z) {
        Fuq = z;
    }

    public static void aSp(String str) {
        AppMethodBeat.i(119449);
        p.h(str, "storyId");
        if (Fuq) {
            Fuk.sj(5);
            Fuk.wR(str);
            fqn();
        }
        AppMethodBeat.o(119449);
    }

    public static jd fqo() {
        return Fur;
    }

    public static void fqp() {
        AppMethodBeat.i(119450);
        if (TextUtils.isEmpty(Fur.getUserName())) {
            AppMethodBeat.o(119450);
            return;
        }
        Fur.bfK();
        AppMethodBeat.o(119450);
    }

    public static jg fqq() {
        return Fus;
    }

    public static void fqr() {
        AppMethodBeat.i(119451);
        Fus.bfK();
        AppMethodBeat.o(119451);
    }

    public static je fqs() {
        return Fut;
    }

    public static void fqt() {
        AppMethodBeat.i(119452);
        Fut.bfK();
        Fut = new je();
        AppMethodBeat.o(119452);
    }

    public static jm fqu() {
        return Fuv;
    }

    public static void fqv() {
        AppMethodBeat.i(119453);
        Fuv.bfK();
        Fuv = new jm();
        AppMethodBeat.o(119453);
    }

    public static jh fqw() {
        return Fuw;
    }

    public static void fqx() {
        AppMethodBeat.i(119454);
        Fuw.bfK();
        Fuw = new jh();
        AppMethodBeat.o(119454);
    }

    public static jv aaU(int i2) {
        AppMethodBeat.i(119455);
        jv jvVar = Fux.get(Integer.valueOf(i2));
        if (jvVar == null) {
            jv jvVar2 = new jv();
            Fux.put(Integer.valueOf(i2), jvVar2);
            jvVar = jvVar2;
        }
        AppMethodBeat.o(119455);
        return jvVar;
    }

    public static void aaV(int i2) {
        AppMethodBeat.i(119456);
        jv jvVar = Fux.get(Integer.valueOf(i2));
        if (jvVar != null) {
            Log.d("MicroMsg.StoryReporter", "basic:\n" + jvVar.aim() + ' ' + jvVar.ahW() + ' ' + jvVar.ahX() + ' ' + jvVar.aik() + ' ' + jvVar.ahV() + ' ' + jvVar.ahT() + ' ' + jvVar.ahU());
            Log.d("MicroMsg.StoryReporter", "origin:\n" + jvVar.aia() + ' ' + jvVar.ahY() + ' ' + jvVar.ail() + ' ' + jvVar.aid() + ' ' + jvVar.aic() + ' ' + jvVar.aib() + ' ' + jvVar.ahZ());
            Log.d("MicroMsg.StoryReporter", "cp:\n" + jvVar.aig() + ' ' + jvVar.aie() + ' ' + jvVar.aij() + ' ' + jvVar.aii() + ' ' + jvVar.aih() + ' ' + jvVar.aif());
            jvVar.bfK();
            Fux.remove(Integer.valueOf(i2));
        }
        AppMethodBeat.o(119456);
    }

    public static jr fqy() {
        return Fuy;
    }

    public static void fqz() {
        AppMethodBeat.i(119457);
        if (Fuy.ahy() == 0) {
            Fuy = new jr();
            AppMethodBeat.o(119457);
            return;
        }
        Fuy.bfK();
        Fuy = new jr();
        AppMethodBeat.o(119457);
    }

    public static void Ks(long j2) {
        FuA = j2;
    }

    public static void Kt(long j2) {
        FuB = j2;
    }

    public static void Ku(long j2) {
        FuC = j2;
    }

    public static void Kv(long j2) {
        FuD = j2;
    }

    public static long fqA() {
        return FuD;
    }

    public static jp fqB() {
        return Fuz;
    }

    public static void fqC() {
        AppMethodBeat.i(119458);
        if (Fuz.ahK() != 0) {
            Fuz.bfK();
            Fuz.ahJ();
            Fuz.ahH();
            Fuz.ahG();
            Fuz.ahI();
            Fuz.sy(FuA);
            Fuz.sz(FuB);
            Fuz.sA(FuC);
        }
        AppMethodBeat.o(119458);
    }

    public static void aaW(int i2) {
        FuE = i2;
    }

    public static int fqD() {
        return FuE;
    }

    public static jj fqE() {
        return FuF;
    }

    public static void fqF() {
        AppMethodBeat.i(119459);
        FuF.bfK();
        FuF = new jj();
        AppMethodBeat.o(119459);
    }

    public static /* synthetic */ void a(long j2, String str, long j3, long j4, int i2) {
        AppMethodBeat.i(119461);
        a(j2, str, (i2 & 4) != 0 ? Ful.ahw() : j3, (i2 & 8) != 0 ? Ful.ahx() : j4, 0L);
        AppMethodBeat.o(119461);
    }

    public static void a(long j2, String str, long j3, long j4, long j5) {
        AppMethodBeat.i(119460);
        p.h(str, "storyId");
        FuG.xf(str);
        FuG.sS(j2);
        FuG.sV(j5);
        FuG.sT(j3);
        FuG.sU(j4);
        FuG.bfK();
        FuG = new ju();
        AppMethodBeat.o(119460);
    }

    public static void aC(String str, int i2, int i3) {
        AppMethodBeat.i(119462);
        p.h(str, "storyId");
        jk jkVar = new jk();
        jkVar.wQ(str);
        jkVar.se((long) i2);
        jkVar.sf((long) i3);
        jkVar.bfK();
        AppMethodBeat.o(119462);
    }

    public static void vW(boolean z) {
        long j2 = 1;
        AppMethodBeat.i(119463);
        ji jiVar = new ji();
        jiVar.sa(1);
        if (!z) {
            j2 = 0;
        }
        jiVar.sc(j2);
        jiVar.bfK();
        AppMethodBeat.o(119463);
    }

    public static void fqj() {
        AppMethodBeat.i(119444);
        if (0 == Ful.ahB()) {
            fql();
            AppMethodBeat.o(119444);
            return;
        }
        Ful.wT(Fum.eKV());
        jo joVar = Ful;
        joVar.sv(joVar.ahF() + Ful.ahD());
        Ful.bfK();
        Ful.sp(0);
        Ful.st(0);
        Ful.ss(0);
        Ful.sq(0);
        Ful.su(0);
        Ful.sm(0);
        Ful.sv(0);
        Ful.sx(0);
        Ful.wU("");
        fql();
        AppMethodBeat.o(119444);
    }
}
