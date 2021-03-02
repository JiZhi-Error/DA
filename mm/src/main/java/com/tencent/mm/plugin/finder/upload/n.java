package com.tencent.mm.plugin.finder.upload;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.o;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0006\u000e\u0018\u0000 Q2\u00020\u0001:\u0001QB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u001fH\u0002J\u0006\u00105\u001a\u00020\u0014J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\u0002J\b\u00108\u001a\u00020+H\u0002J\u0012\u00109\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010:\u001a\u00020+H\u0016J\b\u0010;\u001a\u00020\fH\u0016J\u0010\u0010<\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0014H\u0002J\u0010\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0002J \u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020@2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u0018\u0010A\u001a\u00020+2\u0006\u0010D\u001a\u00020@2\u0006\u0010,\u001a\u00020\u001fH\u0002J\u001c\u0010E\u001a\u00020+2\b\u00107\u001a\u0004\u0018\u00010\f2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\u0010\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\fH\u0002J\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001fH\u0002J\u0016\u0010L\u001a\u00020+2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001f0NH\u0002J\u0010\u0010O\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001fH\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010K\u001a\u00020\u001fH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\tX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n \"*\u0004\u0018\u00010!0!¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0)X\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", ch.COL_POSTINFO, "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "isRemoteUpload", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class n extends j {
    private static final String TAG = TAG;
    private static boolean vTs;
    public static final a vTt = new a((byte) 0);
    private List<String> pQE = new ArrayList();
    private long startTime;
    FinderItem vRO;
    private boolean vTi;
    private final cjm vTj = this.vRO.field_postinfo;
    private final Map<String, Float> vTk = new LinkedHashMap();
    private final ConcurrentLinkedQueue<String> vTl = new ConcurrentLinkedQueue<>();
    private boolean vTm;
    private List<cjl> vTn = new ArrayList();
    private boolean vTo;
    private final List<g> vTp = new ArrayList();
    private final c vTq = new c(this);
    private final b vTr = new b(this);

    public n(FinderItem finderItem) {
        p.h(finderItem, "finderObj");
        AppMethodBeat.i(167796);
        this.vRO = finderItem;
        AppMethodBeat.o(167796);
    }

    public static final /* synthetic */ void a(n nVar, j jVar) {
        AppMethodBeat.i(167802);
        nVar.d(jVar);
        AppMethodBeat.o(167802);
    }

    public static final /* synthetic */ void a(n nVar, boolean z) {
        AppMethodBeat.i(167801);
        nVar.oG(z);
        AppMethodBeat.o(167801);
    }

    public static final /* synthetic */ String awb(String str) {
        AppMethodBeat.i(253131);
        String awa = awa(str);
        AppMethodBeat.o(253131);
        return awa;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167797);
        AppMethodBeat.o(167797);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<hg> {
        final /* synthetic */ n vTu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(n nVar) {
            this.vTu = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hg hgVar) {
            AppMethodBeat.i(253120);
            hg hgVar2 = hgVar;
            if (!(hgVar2 == null || hgVar2.dLJ.localId == 0 || hgVar2.dLJ.localId != this.vTu.vRO.getLocalId())) {
                a aVar = n.vTt;
                Log.i(n.TAG, "feedDeleteListener localId:" + hgVar2.dLJ.localId);
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                if (!c.a.FR(this.vTu.vRO.getLocalId())) {
                    this.vTu.vTm = true;
                    com.tencent.mm.ac.d.i(new a(this, hgVar2));
                    n.a(this.vTu, j.OK);
                }
            }
            AppMethodBeat.o(253120);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderUploadTask$feedDeleteListener$1$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ hg $event$inlined;
            final /* synthetic */ c vTv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, hg hgVar) {
                super(0);
                this.vTv = cVar;
                this.$event$inlined = hgVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(253119);
                LinkedList<cjl> linkedList = new LinkedList();
                linkedList.addAll(this.vTv.vTu.vRO.getHalfVideoMediaExtList());
                linkedList.addAll(this.vTv.vTu.vRO.getMediaList());
                linkedList.addAll(this.vTv.vTu.vRO.getLongVideoMediaExtList());
                for (cjl cjl : linkedList) {
                    String mD5String = MD5Util.getMD5String(cjl.url);
                    p.g(mD5String, "MD5Util.getMD5String(mediaObject.url)");
                    String awb = n.awb(mD5String);
                    if (!Util.isNullOrNil(awb)) {
                        a aVar = n.vTt;
                        Log.i(n.TAG, "feedDeleteListener cancelSendTask ".concat(String.valueOf(awb)));
                        f.baQ().Ob(awb);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(253119);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.j
    public final void start() {
        AppMethodBeat.i(253123);
        this.vTq.alive();
        this.vRO.trackPost("upload");
        FinderFeedReportObject finderFeedReportObject = this.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.postStage = 3;
        }
        this.startTime = cl.aWA();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtZ().value().intValue() > 0 && (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED)) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            Thread.sleep(com.tencent.mm.plugin.finder.storage.c.dtZ().value().longValue() * 1000);
        }
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dra().value().intValue() == 2) {
            d(j.Fail);
            AppMethodBeat.o(253123);
            return;
        }
        LinkedList<cjl> linkedList = new LinkedList<>();
        linkedList.addAll(this.vRO.getHalfVideoMediaExtList());
        linkedList.addAll(this.vRO.getMediaList());
        linkedList.addAll(this.vRO.getLongVideoMediaExtList());
        this.vTn.addAll(this.vRO.getLongVideoMediaExtList());
        aE(linkedList);
        AppMethodBeat.o(253123);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/upload/FinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class b implements g.a {
        final /* synthetic */ n vTu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(n nVar) {
            this.vTu = nVar;
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
            String str2;
            cjl cjl;
            cjl cjl2;
            T t;
            T t2;
            azr azr;
            azk azk;
            azr azr2;
            azk azk2;
            azr azr3;
            azk azk3;
            azr azr4;
            LinkedList<aop> linkedList;
            aop aop;
            bei bei;
            cng cng;
            cnl cnl;
            T t3;
            T t4;
            T t5;
            String str3;
            T t6;
            T t7;
            T t8;
            azr azr5;
            String str4;
            T t9;
            T t10;
            T t11;
            AppMethodBeat.i(167791);
            a aVar = n.vTt;
            String str5 = n.TAG;
            String str6 = "on cdn callback someOneFailed:" + this.vTu.vTo + ", mediaId = %s, startRet = %d, sceneResult %s";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i2);
            if (dVar == null || (str2 = dVar.toString()) == null) {
                str2 = BuildConfig.COMMAND;
            }
            objArr[2] = str2;
            Log.i(str5, str6, objArr);
            if (this.vTu.vTm || this.vTu.vTo) {
                AppMethodBeat.o(167791);
                return 0;
            }
            n.a(this.vTu, str, cVar);
            if (i2 != 0) {
                a aVar2 = n.vTt;
                Log.e(n.TAG, "start failed : %d, media id is :%s", Integer.valueOf(i2), str);
                if (i2 != -21005) {
                    List list = this.vTu.pQE;
                    if (str == null) {
                        str4 = "";
                    } else {
                        str4 = str;
                    }
                    list.add(str4);
                    this.vTu.vTo = true;
                    Iterator<T> it = this.vTu.vRO.getHalfVideoMediaExtList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t9 = null;
                            break;
                        }
                        T next = it.next();
                        if (p.j(next.mediaId, n.awc(str))) {
                            t9 = next;
                            break;
                        }
                    }
                    T t12 = t9;
                    if (t12 != null) {
                        n.a(this.vTu, i2, t12);
                        x xVar = x.SXb;
                    }
                    Iterator<T> it2 = this.vTu.vRO.getMediaList().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            t10 = null;
                            break;
                        }
                        T next2 = it2.next();
                        if (p.j(next2.mediaId, n.awc(str))) {
                            t10 = next2;
                            break;
                        }
                    }
                    T t13 = t10;
                    if (t13 != null) {
                        n.a(this.vTu, i2, t13);
                        x xVar2 = x.SXb;
                    }
                    Iterator<T> it3 = this.vTu.vRO.getLongVideoMediaExtList().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            t11 = null;
                            break;
                        }
                        T next3 = it3.next();
                        if (p.j(next3.mediaId, n.awc(str))) {
                            t11 = next3;
                            break;
                        }
                    }
                    T t14 = t11;
                    if (t14 != null) {
                        n.a(this.vTu, i2, t14);
                        x xVar3 = x.SXb;
                    }
                    n.a(this.vTu, false);
                    n.a(this.vTu, j.Fail);
                }
                AppMethodBeat.o(167791);
                return 0;
            }
            if (!Util.isNullOrNil(str) && dVar != null) {
                a aVar3 = n.vTt;
                Log.i(n.TAG, "retCode %d, fileId %s, url %s", Integer.valueOf(dVar.field_retCode), dVar.field_fileId, dVar.field_fileUrl);
                if (dVar.field_retCode != 0) {
                    List list2 = this.vTu.pQE;
                    if (str == null) {
                        str3 = "";
                    } else {
                        str3 = str;
                    }
                    list2.add(str3);
                    this.vTu.vTo = true;
                    Iterator<T> it4 = this.vTu.vRO.getHalfVideoMediaExtList().iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            t6 = null;
                            break;
                        }
                        T next4 = it4.next();
                        if (p.j(next4.mediaId, n.awc(str))) {
                            t6 = next4;
                            break;
                        }
                    }
                    T t15 = t6;
                    if (t15 != null) {
                        n.a(this.vTu, dVar.field_retCode, t15);
                        x xVar4 = x.SXb;
                    }
                    Iterator<T> it5 = this.vTu.vRO.getMediaList().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            t7 = null;
                            break;
                        }
                        T next5 = it5.next();
                        if (p.j(next5.mediaId, n.awc(str))) {
                            t7 = next5;
                            break;
                        }
                    }
                    T t16 = t7;
                    if (t16 != null) {
                        n.a(this.vTu, dVar.field_retCode, t16);
                        x xVar5 = x.SXb;
                    }
                    Iterator<T> it6 = this.vTu.vRO.getLongVideoMediaExtList().iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            t8 = null;
                            break;
                        }
                        T next6 = it6.next();
                        if (p.j(next6.mediaId, n.awc(str))) {
                            t8 = next6;
                            break;
                        }
                    }
                    T t17 = t8;
                    if (t17 != null) {
                        n.a(this.vTu, dVar.field_retCode, t17);
                        x xVar6 = x.SXb;
                    }
                    FinderObjectDesc finderObjectDesc = this.vTu.vRO.getFeedObject().objectDesc;
                    azk azk4 = (finderObjectDesc == null || (azr5 = finderObjectDesc.feedBgmInfo) == null) ? null : azr5.musicInfo;
                    if (azk4 != null && p.j(MD5Util.getMD5String(azk4.LJi), n.awc(str))) {
                        h.INSTANCE.n(1530, 3, 1);
                    }
                    n.a(this.vTu, false);
                    n.a(this.vTu, j.Fail);
                    AppMethodBeat.o(167791);
                    return 0;
                }
                this.vTu.vTl.remove(str);
                LinkedList<cjl> mediaList = this.vTu.vRO.getMediaList();
                LinkedList<cjl> longVideoMediaExtList = this.vTu.vRO.getLongVideoMediaExtList();
                LinkedList<cjl> halfVideoMediaExtList = this.vTu.vRO.getHalfVideoMediaExtList();
                int size = this.vTu.vTl.size();
                a aVar4 = n.vTt;
                Log.i(n.TAG, "%s waitToUpload %d media localId:" + this.vTu.vRO.getLocalId(), Long.valueOf(this.vTu.vRO.getLocalId()), Integer.valueOf(size));
                boolean z2 = false;
                boolean z3 = false;
                if (mediaList != null) {
                    Iterator<T> it7 = mediaList.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            t5 = null;
                            break;
                        }
                        T next7 = it7.next();
                        if (p.j(next7.mediaId, n.awc(str))) {
                            t5 = next7;
                            break;
                        }
                    }
                    cjl = t5;
                } else {
                    cjl = null;
                }
                if (cjl == null) {
                    if (longVideoMediaExtList != null) {
                        Iterator<T> it8 = longVideoMediaExtList.iterator();
                        while (true) {
                            if (!it8.hasNext()) {
                                t4 = null;
                                break;
                            }
                            T next8 = it8.next();
                            if (p.j(next8.mediaId, n.awc(str))) {
                                t4 = next8;
                                break;
                            }
                        }
                        cjl = t4;
                    } else {
                        cjl = null;
                    }
                    z2 = cjl != null;
                }
                if (cjl == null) {
                    Iterator<T> it9 = halfVideoMediaExtList.iterator();
                    while (true) {
                        if (!it9.hasNext()) {
                            t3 = null;
                            break;
                        }
                        T next9 = it9.next();
                        if (p.j(next9.mediaId, n.awc(str))) {
                            t3 = next9;
                            break;
                        }
                    }
                    T t18 = t3;
                    cjl2 = t18;
                    z3 = t18 != null;
                } else {
                    cjl2 = cjl;
                }
                if (cjl2 != null) {
                    a aVar5 = n.vTt;
                    Log.i(n.TAG, "hitMedia, isLongVideo:" + z2 + ", isHalf:" + z3);
                    cjl2.mediaId = MD5Util.getMD5String(cjl2.url);
                    cjl2.MoM = dVar.field_fileUrl;
                    cjl2.MoN = dVar.field_thumbUrl;
                    cjl2.md5sum = dVar.field_filemd5;
                    if (z2) {
                        aoq aoq = this.vTu.vRO.getFeedObject().attachmentList;
                        if (!(aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) kotlin.a.j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null || (cnl = cng.MtG) == null)) {
                            cnl.media = o.aC(longVideoMediaExtList);
                        }
                    } else if (!z3) {
                        this.vTu.vRO.setMediaList(mediaList);
                    }
                    n.a(this.vTu, 0, cjl2);
                    c.a aVar6 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    Boolean.valueOf(c.a.r(this.vTu.vRO));
                }
                if (cjl2 == null) {
                    FinderObjectDesc finderObjectDesc2 = this.vTu.vRO.getFeedObject().objectDesc;
                    azk azk5 = (finderObjectDesc2 == null || (azr4 = finderObjectDesc2.feedBgmInfo) == null) ? null : azr4.musicInfo;
                    if (azk5 != null) {
                        String str7 = azk5.LJi;
                        if (str7 == null) {
                            str7 = "";
                        }
                        if (p.j(MD5Util.getMD5String(str7), n.awc(str))) {
                            FinderObjectDesc finderObjectDesc3 = this.vTu.vRO.getFeedObject().objectDesc;
                            if (!(finderObjectDesc3 == null || (azr3 = finderObjectDesc3.feedBgmInfo) == null || (azk3 = azr3.musicInfo) == null)) {
                                azk3.LJi = dVar.field_fileUrl;
                            }
                            FinderObjectDesc finderObjectDesc4 = this.vTu.vRO.getFeedObject().objectDesc;
                            if (!(finderObjectDesc4 == null || (azr2 = finderObjectDesc4.feedBgmInfo) == null || (azk2 = azr2.musicInfo) == null)) {
                                azk2.wWb = "";
                            }
                            FinderObjectDesc finderObjectDesc5 = this.vTu.vRO.getFeedObject().objectDesc;
                            if (!(finderObjectDesc5 == null || (azr = finderObjectDesc5.feedBgmInfo) == null || (azk = azr.musicInfo) == null)) {
                                azk.name = "";
                            }
                            c.a aVar7 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                            c.a.r(this.vTu.vRO);
                        }
                    }
                    Iterator<T> it10 = mediaList.iterator();
                    while (true) {
                        if (!it10.hasNext()) {
                            t = null;
                            break;
                        }
                        T next10 = it10.next();
                        String str8 = next10.coverUrl;
                        if (str8 == null) {
                            str8 = "";
                        }
                        if (p.j(MD5Util.getMD5String(str8), n.awc(str))) {
                            t = next10;
                            break;
                        }
                    }
                    T t19 = t;
                    if (t19 != null) {
                        a aVar8 = n.vTt;
                        Log.i(n.TAG, "upload cover ok, url:" + dVar.field_fileUrl);
                        t19.MoP = dVar.field_fileUrl;
                        x xVar7 = x.SXb;
                    }
                    Iterator<T> it11 = mediaList.iterator();
                    while (true) {
                        if (!it11.hasNext()) {
                            t2 = null;
                            break;
                        }
                        T next11 = it11.next();
                        String str9 = next11.MoR;
                        if (str9 == null) {
                            str9 = "";
                        }
                        if (p.j(MD5Util.getMD5String(str9), n.awc(str))) {
                            t2 = next11;
                            break;
                        }
                    }
                    T t20 = t2;
                    if (t20 != null) {
                        a aVar9 = n.vTt;
                        Log.i(n.TAG, "upload fullThumb ok, url:" + dVar.field_fileUrl);
                        t20.MoT = dVar.field_fileUrl;
                        x xVar8 = x.SXb;
                    }
                    c.a aVar72 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    c.a.r(this.vTu.vRO);
                }
                if (size == 0) {
                    n.a(this.vTu, true);
                    n.a(this.vTu, j.OK);
                }
            }
            AppMethodBeat.o(167791);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    }

    private static String awa(String str) {
        AppMethodBeat.i(253124);
        String concat = "upload_".concat(String.valueOf(str));
        AppMethodBeat.o(253124);
        return concat;
    }

    private final void d(j jVar) {
        AppMethodBeat.i(167793);
        this.vTq.dead();
        if (this.vTi) {
            Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.vTi);
            AppMethodBeat.o(167793);
            return;
        }
        a(jVar);
        AppMethodBeat.o(167793);
    }

    private final void Lu(int i2) {
        FinderFeedReportObject finderFeedReportObject = this.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.uploadLogicError = i2;
        }
    }

    private final void a(int i2, cjl cjl) {
        AppMethodBeat.i(253125);
        e(cjl);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.isBigFile = 1;
        }
        FinderMediaReportObject finderMediaReportObject2 = cjl.MoZ;
        if (finderMediaReportObject2 != null) {
            finderMediaReportObject2.cdnControl = i2;
            AppMethodBeat.o(253125);
            return;
        }
        AppMethodBeat.o(253125);
    }

    private final void e(cjl cjl) {
        AppMethodBeat.i(253126);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.mediaType = cjl.mediaType;
            finderMediaReportObject.mediaId = cjl.mediaId;
            finderMediaReportObject.cdnUploadTime = (int) (cl.aWA() - this.startTime);
            AppMethodBeat.o(253126);
            return;
        }
        FinderMediaReportObject finderMediaReportObject2 = new FinderMediaReportObject();
        finderMediaReportObject2.mediaType = cjl.mediaType;
        finderMediaReportObject2.mediaId = cjl.mediaId;
        finderMediaReportObject2.cdnUploadTime = (int) (cl.aWA() - this.startTime);
        FinderMediaReportInfo finderMediaReportInfo = new FinderMediaReportInfo();
        finderMediaReportInfo.width = (int) cjl.width;
        finderMediaReportInfo.height = (int) cjl.height;
        finderMediaReportInfo.fileSize = (int) s.boW(cjl.url);
        finderMediaReportInfo.videoDuration = cjl.videoDuration;
        finderMediaReportInfo.videoBitrate = cjl.bitrate;
        finderMediaReportObject2.videoFinalSize = finderMediaReportInfo.fileSize;
        finderMediaReportObject2.target = finderMediaReportInfo;
        cjl.MoZ = finderMediaReportObject2;
        AppMethodBeat.o(253126);
    }

    private final void oG(boolean z) {
        AppMethodBeat.i(167794);
        if (!z) {
            try {
                this.vTi = false;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(167794);
                return;
            }
        }
        if (!z) {
            this.vTj.Mpa = 2;
        } else {
            this.vTj.Mpa = 1;
        }
        this.vTj.hdA = cl.aWy() - this.startTime;
        FinderItem finderItem = this.vRO;
        cjm cjm = this.vTj;
        p.g(cjm, ch.COL_POSTINFO);
        finderItem.setPostInfo(cjm);
        r.c cVar = r.c.vhb;
        r.c.z(this.vTj.hdA, this.vRO.isLongVideo());
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(this.vRO);
        AppMethodBeat.o(167794);
    }

    private final int f(cjl cjl) {
        AppMethodBeat.i(253128);
        if (cjl.mediaType == 4 && !Util.isNullOrNil(cjl.coverUrl)) {
            if (!s.YS(cjl.coverUrl)) {
                Log.w(TAG, "upload failed, coverUrl not exist, " + cjl.coverUrl);
                AppMethodBeat.o(253128);
                return 5;
            }
            g gVar = new g();
            gVar.taskName = "task_FinderUploadTask_2";
            gVar.gqy = this.vTr;
            String mD5String = MD5Util.getMD5String(cjl.coverUrl);
            p.g(mD5String, "MD5Util.getMD5String(mediaObject.coverUrl)");
            gVar.field_mediaId = awa(mD5String);
            gVar.field_fullpath = cjl.coverUrl;
            gVar.field_thumbpath = cjl.coverUrl;
            gVar.field_talker = "";
            gVar.field_needStorage = true;
            Log.i(TAG, "upload cover file length " + s.boW(cjl.coverUrl));
            gVar.field_fileType = CdnLogic.kMediaTypeAppImageStorage;
            gVar.field_appType = 251;
            gVar.field_bzScene = 2;
            gVar.gqC = 120;
            gVar.gqD = 300;
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            this.vTl.add(gVar.field_mediaId);
            Map<String, Float> map = this.vTk;
            String str = gVar.field_mediaId;
            p.g(str, "info.field_mediaId");
            map.put(str, Float.valueOf(0.0f));
            this.vTp.add(gVar);
        }
        AppMethodBeat.o(253128);
        return 0;
    }

    private static com.tencent.mm.plugin.sight.base.a j(g gVar) {
        int i2;
        AppMethodBeat.i(253129);
        gVar.snsVersion = 1;
        com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(gVar.field_fullpath);
        if (aNx != null) {
            int i3 = aNx.videoBitrate;
            if (com.tencent.mm.modelvideo.r.isH265Video(gVar.field_fullpath)) {
                i2 = TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4;
            } else {
                i2 = 28;
            }
            String str = "videobitrate:" + i3 + "\r\nvideoformat:" + i2 + APLogFileUtil.SEPARATOR_LINE;
            Log.i(TAG, "customHeader ".concat(String.valueOf(str)));
            gVar.customHeader = str;
        }
        AppMethodBeat.o(253129);
        return aNx;
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(167795);
        String str = "upload_" + this.vRO.getLocalId();
        AppMethodBeat.o(167795);
        return str;
    }

    private final boolean g(cjl cjl) {
        AppMethodBeat.i(253130);
        Iterator<cjl> it = this.vTn.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (p.j(it.next().mediaId, cjl.mediaId)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            AppMethodBeat.o(253130);
            return true;
        }
        AppMethodBeat.o(253130);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0324  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aE(java.util.LinkedList<com.tencent.mm.protocal.protobuf.cjl> r14) {
        /*
        // Method dump skipped, instructions count: 1484
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.n.aE(java.util.LinkedList):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ n vTu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.vTu = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(253121);
            String auK = this.vTu.auK();
            AppMethodBeat.o(253121);
            return auK;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ n vTu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(n nVar) {
            super(0);
            this.vTu = nVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(253122);
            String auK = this.vTu.auK();
            AppMethodBeat.o(253122);
            return auK;
        }
    }

    public static final /* synthetic */ void a(n nVar, String str, com.tencent.mm.i.c cVar) {
        AppMethodBeat.i(167798);
        if (!Util.isNullOrNil(str)) {
            Map<String, Float> map = nVar.vTk;
            if (map == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                AppMethodBeat.o(167798);
                throw tVar;
            } else if (map.containsKey(str) && cVar != null) {
                float f2 = (1.0f * ((float) cVar.field_finishedLength)) / ((float) cVar.field_toltalLength);
                Log.d(TAG, "finished " + cVar.field_finishedLength + ", total " + cVar.field_toltalLength + ", progress " + f2);
                Float f3 = nVar.vTk.get(str);
                if (f3 == null) {
                    p.hyc();
                }
                if (f2 > f3.floatValue()) {
                    Map<String, Float> map2 = nVar.vTk;
                    if (str == null) {
                        p.hyc();
                    }
                    map2.put(str, Float.valueOf(f2));
                }
                float D = kotlin.a.j.D(nVar.vTk.values()) / ((float) nVar.vTk.size());
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int dre = com.tencent.mm.plugin.finder.storage.c.dre();
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int dre2 = dre + ((int) (((float) com.tencent.mm.plugin.finder.storage.c.dre()) * D));
                Log.i(TAG, "feed " + nVar.vRO.getLocalId() + " updateProgress  " + D + ", " + dre2);
                if (nVar.vRO.getPostInfo().Mpc < dre2) {
                    nVar.vRO.getPostInfo().Mpc = dre2;
                    c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                    c.a.r(nVar.vRO);
                }
                EventCenter eventCenter = EventCenter.instance;
                hk hkVar = new hk();
                hkVar.dLT.localId = nVar.vRO.getLocalId();
                hkVar.dLT.progress = nVar.vRO.getPostInfo().Mpc;
                eventCenter.publish(hkVar);
                AppMethodBeat.o(167798);
                return;
            }
        }
        AppMethodBeat.o(167798);
    }

    public static final /* synthetic */ String awc(String str) {
        AppMethodBeat.i(167799);
        if (str == null || !kotlin.n.n.J(str, "upload_", false)) {
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(167799);
            return str;
        }
        String substring = str.substring(7);
        p.g(substring, "(this as java.lang.String).substring(startIndex)");
        AppMethodBeat.o(167799);
        return substring;
    }

    public static final /* synthetic */ void a(n nVar, int i2, cjl cjl) {
        AppMethodBeat.i(167800);
        nVar.e(cjl);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.cdnUploadRetCode = i2;
        }
        FinderFeedReportObject finderFeedReportObject = nVar.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.retryCount = nVar.vRO.getPostInfo().ibG;
            finderFeedReportObject.cdnEndTime = cl.aWA();
            if (i2 == 0) {
                finderFeedReportObject.mediaList.add(cjl.MoZ);
            }
            AppMethodBeat.o(167800);
            return;
        }
        AppMethodBeat.o(167800);
    }
}
