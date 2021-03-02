package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
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
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0006\u000e\u0018\u0000 P2\u00020\u0001:\u0001PB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\nH\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u001eH\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020*H\u0002J\u0012\u00107\u001a\u00020\f2\b\u00105\u001a\u0004\u0018\u00010\fH\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0016J\b\u0010:\u001a\u00020\fH\u0016J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\u0013H\u0002J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020?H\u0002J \u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020\u00132\u0006\u0010B\u001a\u00020?2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u0018\u0010@\u001a\u00020*2\u0006\u0010C\u001a\u00020?2\u0006\u0010+\u001a\u00020\u001eH\u0002J\u001c\u0010D\u001a\u00020*2\b\u00105\u001a\u0004\u0018\u00010\f2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0010\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\fH\u0002J\u0010\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0016\u0010K\u001a\u00020*2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001e0MH\u0002J\u0010\u0010N\u001a\u00020?2\u0006\u0010J\u001a\u00020\u001eH\u0002J\u0010\u0010O\u001a\u00020?2\u0006\u0010J\u001a\u00020\u001eH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n !*\u0004\u0018\u00010 0 ¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0(X\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "cdnCallback", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1;", "cdnTaskInfoList", "", "Lcom/tencent/mm/cdn/keep_TaskInfo;", "failedList", "", "feedDeleteListener", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1;", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isDeleted", "", "isMarkFail", "()Z", "setMarkFail", "(Z)V", "itemProgress", "", "", "getItemProgress", "()Ljava/util/Map;", "longVideoList", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", ch.COL_POSTINFO, "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "kotlin.jvm.PlatformType", "getPostinfo", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "someOneFailed", "startTime", "", "uploadingFeed", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "checkReportObj", "", "updateMedia", "fillBigFile", "Lcom/tencent/mm/plugin/sight/base/MediaInfo;", "info", "invokeCallbackFun", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "isLongVideo", "media", "prefixMediaId", "mediaId", "resetUploadInfo", "revertMediaId", "saveToDb", "start", "uniqueId", "updatePostInfo", "isOk", "updatePostLogicError", "errCode", "", "updatePostReportMediaInfo", "isBigFile", "control", "retCode", "updateProgress", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "uploadAudioTrack", "path", "uploadCoverImage", "mediaObject", "uploadFinderContent", "mediaObjList", "Ljava/util/LinkedList;", "uploadFullThumbImage", "uploadLocalMedia", "Companion", "plugin-finder_release"})
public final class s extends j {
    private static final String TAG = TAG;
    public static final a vTN = new a((byte) 0);
    private static boolean vTs;
    private List<String> pQE = new ArrayList();
    private long startTime;
    final FinderItem vRO;
    private final c vTL = new c(this);
    private final b vTM = new b(this);
    private boolean vTi;
    private final cjm vTj = this.vRO.field_postinfo;
    private final Map<String, Float> vTk = new LinkedHashMap();
    private final ConcurrentLinkedQueue<String> vTl = new ConcurrentLinkedQueue<>();
    private boolean vTm;
    private List<cjl> vTn = new ArrayList();
    private boolean vTo;
    private final List<g> vTp = new ArrayList();

    public s(FinderItem finderItem) {
        p.h(finderItem, "finderObj");
        AppMethodBeat.i(253164);
        this.vRO = finderItem;
        AppMethodBeat.o(253164);
    }

    public static final /* synthetic */ void a(s sVar, j jVar) {
        AppMethodBeat.i(253167);
        sVar.d(jVar);
        AppMethodBeat.o(253167);
    }

    public static final /* synthetic */ void a(s sVar, boolean z) {
        AppMethodBeat.i(253171);
        sVar.oG(z);
        AppMethodBeat.o(253171);
    }

    public static final /* synthetic */ String awd(String str) {
        AppMethodBeat.i(253166);
        String awa = awa(str);
        AppMethodBeat.o(253166);
        return awa;
    }

    public static final /* synthetic */ void g(s sVar) {
        AppMethodBeat.i(253172);
        sVar.dBc();
        AppMethodBeat.o(253172);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "debugDeleteFileWhenUpload", "", "getDebugDeleteFileWhenUpload", "()Z", "setDebugDeleteFileWhenUpload", "(Z)V", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253165);
        AppMethodBeat.o(253165);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class c extends IListener<hg> {
        final /* synthetic */ s vTO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(s sVar) {
            this.vTO = sVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hg hgVar) {
            AppMethodBeat.i(253150);
            hg hgVar2 = hgVar;
            if (!(hgVar2 == null || hgVar2.dLJ.localId == 0 || hgVar2.dLJ.localId != this.vTO.vRO.getLocalId())) {
                a aVar = s.vTN;
                Log.i(s.TAG, "feedDeleteListener localId:" + hgVar2.dLJ.localId);
                c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                if (!c.a.FR(this.vTO.vRO.getLocalId())) {
                    this.vTO.vTm = true;
                    com.tencent.mm.ac.d.i(new a(this, hgVar2));
                    s.a(this.vTO, j.OK);
                }
            }
            AppMethodBeat.o(253150);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$feedDeleteListener$1$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ hg $event$inlined;
            final /* synthetic */ c vTP;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar, hg hgVar) {
                super(0);
                this.vTP = cVar;
                this.$event$inlined = hgVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(253149);
                LinkedList<cjl> linkedList = new LinkedList();
                linkedList.addAll(this.vTP.vTO.vRO.getMediaList());
                Iterator<T> it = this.vTP.vTO.vRO.getClipListExt().iterator();
                while (it.hasNext()) {
                    linkedList.addAll(it.next().getMediaList());
                }
                for (cjl cjl : linkedList) {
                    String mD5String = MD5Util.getMD5String(cjl.url);
                    p.g(mD5String, "MD5Util.getMD5String(mediaObject.url)");
                    String awd = s.awd(mD5String);
                    if (!Util.isNullOrNil(awd)) {
                        a aVar = s.vTN;
                        Log.i(s.TAG, "feedDeleteListener cancelSendTask ".concat(String.valueOf(awd)));
                        f.baQ().Ob(awd);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(253149);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.j
    public final void start() {
        T t;
        AppMethodBeat.i(253153);
        this.vTL.alive();
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
            AppMethodBeat.o(253153);
            return;
        }
        FinderObjectDesc finderObjectDesc = this.vRO.getFeedObject().objectDesc;
        axw axw = finderObjectDesc != null ? finderObjectDesc.mvInfo : null;
        if (axw == null) {
            d(j.Fail);
            AppMethodBeat.o(253153);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList<axz> linkedList2 = axw.LId;
        p.g(linkedList2, "mvInfo.orderedTrackList");
        ArrayList arrayList = new ArrayList();
        for (T t2 : linkedList2) {
            if (t2.refObjectId == 0) {
                arrayList.add(t2);
            }
        }
        linkedList.addAll(arrayList);
        LinkedList<cjl> linkedList3 = new LinkedList<>();
        linkedList3.addAll(this.vRO.getMediaList());
        int i2 = 0;
        for (Object obj : linkedList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            axz axz = (axz) obj;
            Iterator<T> it = this.vRO.getClipListExt().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (p.j(next.getObjectNonceId(), axz.LIm)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                linkedList3.addAll(t3.getMediaList());
            }
            i2 = i3;
        }
        aE(linkedList3);
        AppMethodBeat.o(253153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/upload/MusicMvFinderUploadTask$cdnCallback$1", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
    public static final class b implements g.a {
        final /* synthetic */ s vTO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(s sVar) {
            this.vTO = sVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:96:0x02cd  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0309  */
        @Override // com.tencent.mm.i.g.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.String r11, int r12, com.tencent.mm.i.c r13, com.tencent.mm.i.d r14, boolean r15) {
            /*
            // Method dump skipped, instructions count: 811
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.s.b.a(java.lang.String, int, com.tencent.mm.i.c, com.tencent.mm.i.d, boolean):int");
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
        AppMethodBeat.i(253154);
        String concat = "upload_".concat(String.valueOf(str));
        AppMethodBeat.o(253154);
        return concat;
    }

    private final void d(j jVar) {
        AppMethodBeat.i(253155);
        this.vTL.dead();
        if (this.vTi) {
            Log.i(TAG, "invoke_CallbackFun isMarkFail " + this.vTi);
            AppMethodBeat.o(253155);
            return;
        }
        a(jVar);
        AppMethodBeat.o(253155);
    }

    private final void Lu(int i2) {
        FinderFeedReportObject finderFeedReportObject = this.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.uploadLogicError = i2;
        }
    }

    private final void a(int i2, cjl cjl) {
        AppMethodBeat.i(253156);
        e(cjl);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.isBigFile = 1;
        }
        FinderMediaReportObject finderMediaReportObject2 = cjl.MoZ;
        if (finderMediaReportObject2 != null) {
            finderMediaReportObject2.cdnControl = i2;
            AppMethodBeat.o(253156);
            return;
        }
        AppMethodBeat.o(253156);
    }

    private final void e(cjl cjl) {
        AppMethodBeat.i(253157);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.mediaType = cjl.mediaType;
            finderMediaReportObject.mediaId = cjl.mediaId;
            finderMediaReportObject.cdnUploadTime = (int) (cl.aWA() - this.startTime);
            AppMethodBeat.o(253157);
            return;
        }
        FinderMediaReportObject finderMediaReportObject2 = new FinderMediaReportObject();
        finderMediaReportObject2.mediaType = cjl.mediaType;
        finderMediaReportObject2.mediaId = cjl.mediaId;
        finderMediaReportObject2.cdnUploadTime = (int) (cl.aWA() - this.startTime);
        FinderMediaReportInfo finderMediaReportInfo = new FinderMediaReportInfo();
        finderMediaReportInfo.width = (int) cjl.width;
        finderMediaReportInfo.height = (int) cjl.height;
        finderMediaReportInfo.fileSize = (int) com.tencent.mm.vfs.s.boW(cjl.url);
        finderMediaReportInfo.videoDuration = cjl.videoDuration;
        finderMediaReportInfo.videoBitrate = cjl.bitrate;
        finderMediaReportObject2.videoFinalSize = finderMediaReportInfo.fileSize;
        finderMediaReportObject2.target = finderMediaReportInfo;
        cjl.MoZ = finderMediaReportObject2;
        AppMethodBeat.o(253157);
    }

    private final void oG(boolean z) {
        AppMethodBeat.i(253158);
        if (!z) {
            try {
                this.vTi = false;
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(253158);
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
        dBc();
        AppMethodBeat.o(253158);
    }

    private final void dBc() {
        AppMethodBeat.i(253159);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.q(this.vRO);
        AppMethodBeat.o(253159);
    }

    private static com.tencent.mm.plugin.sight.base.a j(g gVar) {
        int i2;
        AppMethodBeat.i(253161);
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
        AppMethodBeat.o(253161);
        return aNx;
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(253162);
        String str = "upload_" + this.vRO.getLocalId();
        AppMethodBeat.o(253162);
        return str;
    }

    private final boolean g(cjl cjl) {
        AppMethodBeat.i(253163);
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
            AppMethodBeat.o(253163);
            return true;
        }
        AppMethodBeat.o(253163);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x02f9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0347  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x03c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void aE(java.util.LinkedList<com.tencent.mm.protocal.protobuf.cjl> r14) {
        /*
        // Method dump skipped, instructions count: 1344
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.s.aE(java.util.LinkedList):void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ s vTO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(s sVar) {
            super(0);
            this.vTO = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(253151);
            String auK = this.vTO.auK();
            AppMethodBeat.o(253151);
            return auK;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ s vTO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(s sVar) {
            super(0);
            this.vTO = sVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(253152);
            String auK = this.vTO.auK();
            AppMethodBeat.o(253152);
            return auK;
        }
    }

    public static final /* synthetic */ void a(s sVar, String str, com.tencent.mm.i.c cVar) {
        AppMethodBeat.i(253168);
        if (!Util.isNullOrNil(str)) {
            Map<String, Float> map = sVar.vTk;
            if (map == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
                AppMethodBeat.o(253168);
                throw tVar;
            } else if (map.containsKey(str) && cVar != null) {
                float f2 = (1.0f * ((float) cVar.field_finishedLength)) / ((float) cVar.field_toltalLength);
                Log.d(TAG, "finished " + cVar.field_finishedLength + ", total " + cVar.field_toltalLength + ", progress " + f2);
                Float f3 = sVar.vTk.get(str);
                if (f3 == null) {
                    p.hyc();
                }
                if (f2 > f3.floatValue()) {
                    Map<String, Float> map2 = sVar.vTk;
                    if (str == null) {
                        p.hyc();
                    }
                    map2.put(str, Float.valueOf(f2));
                }
                float D = kotlin.a.j.D(sVar.vTk.values()) / ((float) sVar.vTk.size());
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int dre = com.tencent.mm.plugin.finder.storage.c.dre();
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int dre2 = dre + ((int) (((float) com.tencent.mm.plugin.finder.storage.c.dre()) * D));
                Log.i(TAG, "feed " + sVar.vRO.getLocalId() + " updateProgress  " + D + ", " + dre2);
                if (sVar.vRO.getPostInfo().Mpc < dre2) {
                    sVar.vRO.getPostInfo().Mpc = dre2;
                    sVar.dBc();
                }
                EventCenter eventCenter = EventCenter.instance;
                hk hkVar = new hk();
                hkVar.dLT.localId = sVar.vRO.getLocalId();
                hkVar.dLT.progress = sVar.vRO.getPostInfo().Mpc;
                eventCenter.publish(hkVar);
                AppMethodBeat.o(253168);
                return;
            }
        }
        AppMethodBeat.o(253168);
    }

    public static final /* synthetic */ String awe(String str) {
        AppMethodBeat.i(253169);
        if (str == null || !n.J(str, "upload_", false)) {
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(253169);
            return str;
        }
        String substring = str.substring(7);
        p.g(substring, "(this as java.lang.String).substring(startIndex)");
        AppMethodBeat.o(253169);
        return substring;
    }

    public static final /* synthetic */ void a(s sVar, int i2, cjl cjl) {
        AppMethodBeat.i(253170);
        sVar.e(cjl);
        FinderMediaReportObject finderMediaReportObject = cjl.MoZ;
        if (finderMediaReportObject != null) {
            finderMediaReportObject.cdnUploadRetCode = i2;
        }
        FinderFeedReportObject finderFeedReportObject = sVar.vRO.field_reportObject;
        if (finderFeedReportObject != null) {
            finderFeedReportObject.retryCount = sVar.vRO.getPostInfo().ibG;
            finderFeedReportObject.cdnEndTime = cl.aWA();
            if (i2 == 0) {
                finderFeedReportObject.mediaList.add(cjl.MoZ);
            }
            AppMethodBeat.o(253170);
            return;
        }
        AppMethodBeat.o(253170);
    }
}
