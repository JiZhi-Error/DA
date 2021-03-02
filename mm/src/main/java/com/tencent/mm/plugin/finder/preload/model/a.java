package com.tencent.mm.plugin.finder.preload.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.finder.loader.s;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 i2\u00020\u0001:\u0002ijB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020PJ,\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00050R2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020P2\u0006\u0010T\u001a\u00020\u0014H\u0002J\u0006\u0010U\u001a\u00020\u0000J\u0006\u0010V\u001a\u00020WJ\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020PJ(\u0010[\u001a\u00020W2\u0006\u0010\\\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020P2\u0006\u0010]\u001a\u00020\u0005H\u0002J\u0012\u0010^\u001a\u00020W2\b\u0010_\u001a\u0004\u0018\u00010`H\u0002J2\u0010a\u001a\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020\u00050R2\u0006\u0010b\u001a\u00020S2\u0006\u0010c\u001a\u00020\u00052\f\u0010d\u001a\b\u0012\u0004\u0012\u00020S0YH\u0002J\"\u0010e\u001a\u00020W2\u0006\u0010_\u001a\u00020`2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020h0gR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001a\u0010$\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u001a\u00100\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001a\u00103\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001a\u00106\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001a\u00109\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001a\u0010<\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010?\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001e\"\u0004\bA\u0010 R\u001a\u0010B\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010'\"\u0004\bD\u0010)R\u001a\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010'\"\u0004\bH\u0010)R\u001a\u0010I\u001a\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel;", "", "()V", "findSpecStepMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "getFindSpecStepMap", "()Lcom/tencent/mm/algorithm/MMLRUMap;", "hotMediaSet", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadObjectInfo;", "getHotMediaSet", "()Ljava/util/concurrent/ConcurrentHashMap;", "setHotMediaSet", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "hotMegaVideoMediaSet", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFinderPreloadObjectInfo;", "getHotMegaVideoMediaSet", "setHotMegaVideoMediaSet", "isMoovFailReady2DownloadAll", "", "()Z", "setMoovFailReady2DownloadAll", "(Z)V", "isOpenMultiBitRateDownload", "isSecondPreload", "setSecondPreload", "maxPreloadBitRate", "", "getMaxPreloadBitRate", "()J", "setMaxPreloadBitRate", "(J)V", "maxPreloadBytes", "getMaxPreloadBytes", "setMaxPreloadBytes", "maxPreloadPercent", "", "getMaxPreloadPercent", "()I", "setMaxPreloadPercent", "(I)V", "maxPreloadTaskCount", "getMaxPreloadTaskCount", "setMaxPreloadTaskCount", "megaVideoMaxBitrate", "getMegaVideoMaxBitrate", "setMegaVideoMaxBitrate", "megaVideoNextCount", "getMegaVideoNextCount", "setMegaVideoNextCount", "megaVideoPrevCount", "getMegaVideoPrevCount", "setMegaVideoPrevCount", "nextCount", "getNextCount", "setNextCount", "playConcurrentCount", "getPlayConcurrentCount", "setPlayConcurrentCount", "preloadConcurrentCount", "getPreloadConcurrentCount", "setPreloadConcurrentCount", "preloadId", "getPreloadId", "setPreloadId", "prevCount", "getPrevCount", "setPrevCount", "reportMap", "startPreloadPercent", "getStartPreloadPercent", "setStartPreloadPercent", "startPreloadSecs", "getStartPreloadSecs", "setStartPreloadSecs", "findTargetMedia", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "feedId", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "findTargetSpec", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/FinderMediaSpec;", "isPreload", "initConfig", "onExitFinder", "", "queryPreloadDetail", "", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "reportWithoutSpec", "defaultFileFormatV2", "targetFileFormat", "storePreloadInfo", "info", "Lcom/tencent/mm/protocal/protobuf/FinderPreloadInfo;", "tranToH265IfEnable", "spec", "step", "specList", "updatePreloadInfo", "feedSet", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "Companion", "Detail", "plugin-finder_release"})
public final class a {
    private static final boolean uUG = e.sX(4);
    public static final C1253a uUH = new C1253a((byte) 0);
    private ConcurrentHashMap<String, bax> uUA = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, cnt> uUB = new ConcurrentHashMap<>();
    public final h<String, String> uUC = new h<>(300);
    public final boolean uUD;
    public boolean uUE;
    public final ConcurrentHashMap<Long, Object> uUF;
    public boolean uUl;
    public int uUm = 1;
    public int uUn = 4;
    public int uUo = kotlin.h.a.cR(30.000002f);
    public long uUp = 2097152;
    public int uUq = 1;
    public int uUr = 1;
    public int uUs = 4;
    public int uUt = kotlin.h.a.cR(0.0f);
    public int uUu;
    public long uUv;
    public long uUw;
    public long uUx;
    public int uUy = 1;
    public int uUz = 2;

    public a() {
        AppMethodBeat.i(166481);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.uUD = com.tencent.mm.plugin.finder.storage.c.dsh();
        this.uUF = new ConcurrentHashMap<>();
        AppMethodBeat.o(166481);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Companion;", "", "()V", "CODING_H264", "", "CODING_H265", "TAG", "_2M", "", "defaultMaxPreloadTaskCount", "", "defaultNextCount", "defaultPlayConcurrentCount", "defaultPreloadConcurrentCount", "defaultPreloadMinSize", "defaultPreloadPercent", "", "defaultPrevCount", "defaultStartPreloadPercent", "defaultStartPreloadSecs", "isSupportH265", "", "getFinderMediaType", "Lcom/tencent/mm/plugin/finder/storage/FinderMediaType;", "fileFormat", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.preload.model.a$a  reason: collision with other inner class name */
    public static final class C1253a {
        private C1253a() {
        }

        public /* synthetic */ C1253a(byte b2) {
            this();
        }

        public static x aus(String str) {
            AppMethodBeat.i(249538);
            if (p.j(str, x.V0_VIDEO.detail)) {
                x xVar = x.V0_VIDEO;
                AppMethodBeat.o(249538);
                return xVar;
            } else if (p.j(str, x.V1_VIDEO.detail)) {
                x xVar2 = x.V1_VIDEO;
                AppMethodBeat.o(249538);
                return xVar2;
            } else if (p.j(str, x.V2_VIDEO.detail)) {
                x xVar3 = x.V2_VIDEO;
                AppMethodBeat.o(249538);
                return xVar3;
            } else if (p.j(str, x.V3_VIDEO.detail)) {
                x xVar4 = x.V3_VIDEO;
                AppMethodBeat.o(249538);
                return xVar4;
            } else if (p.j(str, x.V4_VIDEO.detail)) {
                x xVar5 = x.V4_VIDEO;
                AppMethodBeat.o(249538);
                return xVar5;
            } else if (p.j(str, x.V5_VIDEO.detail)) {
                x xVar6 = x.V5_VIDEO;
                AppMethodBeat.o(249538);
                return xVar6;
            } else if (p.j(str, x.V6_VIDEO.detail)) {
                x xVar7 = x.V6_VIDEO;
                AppMethodBeat.o(249538);
                return xVar7;
            } else if (p.j(str, x.V7_VIDEO.detail)) {
                x xVar8 = x.V7_VIDEO;
                AppMethodBeat.o(249538);
                return xVar8;
            } else if (p.j(str, x.V8_VIDEO.detail)) {
                x xVar9 = x.V8_VIDEO;
                AppMethodBeat.o(249538);
                return xVar9;
            } else if (p.j(str, x.V9_VIDEO.detail)) {
                x xVar10 = x.V9_VIDEO;
                AppMethodBeat.o(249538);
                return xVar10;
            } else if (p.j(str, x.V10_VIDEO.detail)) {
                x xVar11 = x.V10_VIDEO;
                AppMethodBeat.o(249538);
                return xVar11;
            } else {
                x xVar12 = x.V99_VIDEO;
                AppMethodBeat.o(249538);
                return xVar12;
            }
        }
    }

    static {
        AppMethodBeat.i(166482);
        AppMethodBeat.o(166482);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(249544);
            int a2 = kotlin.b.a.a(Integer.valueOf(((at) t).field_fileFormat.hashCode()), Integer.valueOf(((at) t2).field_fileFormat.hashCode()));
            AppMethodBeat.o(249544);
            return a2;
        }
    }

    public final void a(baw baw, HashMap<Long, FinderObject> hashMap) {
        LinkedList<aop> linkedList;
        aop aop;
        bei bei;
        cng cng;
        cnl cnl;
        LinkedList<cod> linkedList2;
        cod cod;
        FinderObjectDesc finderObjectDesc;
        LinkedList<FinderMedia> linkedList3;
        AppMethodBeat.i(249545);
        p.h(baw, "info");
        p.h(hashMap, "feedSet");
        this.uUw = baw.uUw;
        bav bav = baw.LKz;
        if (bav != null) {
            this.uUm = bav.uUm;
            this.uUn = bav.uUn;
            this.uUo = kotlin.h.a.cR(bav.LKu * 100.0f);
            this.uUv = (long) bav.LKt;
            this.uUp = (long) bav.LKv;
            this.uUq = j.mZ(1, bav.LKw);
            this.uUr = j.mZ(1, bav.uUr);
            this.uUs = bav.uUs;
            this.uUt = kotlin.h.a.cR(bav.LKx * 100.0f);
            this.uUu = bav.uUu;
            this.uUl = false;
            this.uUx = (long) bav.LKy;
            this.uUy = bav.uUy;
            this.uUz = bav.uUz;
            LinkedList<bax> linkedList4 = baw.LKA;
            if (linkedList4 != null) {
                for (T t : linkedList4) {
                    FinderObject finderObject = hashMap.get(Long.valueOf(t.feedId));
                    if (!(finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (linkedList3 = finderObjectDesc.media) == null)) {
                        for (T t2 : linkedList3) {
                            ConcurrentHashMap<String, bax> concurrentHashMap = this.uUA;
                            p.g(t2, LocaleUtil.ITALIAN);
                            String str = com.tencent.mm.plugin.finder.storage.data.j.a((FinderMedia) t2).mediaId;
                            if (str == null) {
                                str = "";
                            }
                            p.g(t, "hot");
                            concurrentHashMap.put(str, t);
                        }
                    }
                }
            }
            LinkedList<cnt> linkedList5 = baw.LKB;
            if (linkedList5 != null) {
                for (T t3 : linkedList5) {
                    for (Map.Entry<Long, FinderObject> entry : hashMap.entrySet()) {
                        aoq aoq = entry.getValue().attachmentList;
                        if (!(aoq == null || (linkedList = aoq.LAM) == null || (aop = (aop) kotlin.a.j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null)) {
                            if (!(cng.id == t3.feedId)) {
                                cng = null;
                            }
                            if (!(cng == null || (cnl = cng.MtG) == null || (linkedList2 = cnl.media) == null || (cod = (cod) kotlin.a.j.kt(linkedList2)) == null)) {
                                ConcurrentHashMap<String, cnt> concurrentHashMap2 = this.uUB;
                                String str2 = com.tencent.mm.plugin.finder.storage.data.j.a(cod).mediaId;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                p.g(t3, "info");
                                concurrentHashMap2.put(str2, t3);
                            }
                        }
                    }
                }
            }
        }
        Log.i("Finder.MediaPreloadModel", "[updatePreloadInfo]\nisSupportH265=" + uUG + '\n' + "[prev:next]Count=" + this.uUm + ':' + this.uUn + '\n' + "maxPreloadPercent=" + this.uUo + '\n' + "maxPreloadBitRate=" + this.uUv + ", maxPreloadBytes=" + Util.getSizeKB(this.uUp) + '\n' + "maxPreloadTaskCount=" + this.uUq + '\n' + "[preload:play]ConcurrentCount=" + this.uUr + ':' + this.uUs + '\n' + "[startPreloadSecs:startPreloadPercent]=" + this.uUu + ':' + this.uUt + '\n' + "isOpenMultiBitRateDownload=" + this.uUD + '\n' + "hotFeed=" + this.uUA.size() + '\n' + "megaVideo[prev:next]Count=" + this.uUy + ':' + this.uUz + '\n' + "megaVideoMaxBitrate=" + this.uUx + '\n' + "hotMegaVideoMediaSet=" + this.uUB.size() + '\n');
        if (baw != null) {
            LinkedList linkedList6 = new LinkedList(baw.LKA);
            baw.LKA.clear();
            byte[] byteArray = baw.toByteArray();
            com.tencent.mm.kernel.e aAh = g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_TIMELINE_LAST_PRELOAD_INFO_STRING_SYNC, Util.encodeHexString(byteArray));
            Log.i("Finder.MediaPreloadModel", "[storePreloadInfo] buffer size=" + Util.getSizeKB((long) byteArray.length));
            baw.LKA.addAll(linkedList6);
            AppMethodBeat.o(249545);
            return;
        }
        AppMethodBeat.o(249545);
    }

    public final List<b> a(cjl cjl) {
        String str;
        long j2;
        float f2;
        boolean z;
        Object obj;
        int i2;
        AppMethodBeat.i(249546);
        p.h(cjl, "media");
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.uUD;
        LinkedList linkedList = new LinkedList();
        String str2 = cjl.mediaId;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        p.g(str, "media.mediaId ?: \"\"");
        o<ayh, String> b2 = b(cjl);
        A a2 = b2.first;
        int i3 = n.I(a2.uUI, "h265", true) ? 2 : 1;
        if (z2) {
            d dVar = d.vGR;
            String str3 = cjl.mediaId;
            if (str3 == null) {
                str3 = "";
            }
            Iterator it = kotlin.a.j.a((Iterable) d.avI(str3), (Comparator) new c()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (((at) next).dkO()) {
                    obj = next;
                    break;
                }
            }
            at atVar = (at) obj;
            if (atVar != null) {
                String str4 = atVar.field_fileFormat;
                if (!(str4 == null || str4.length() == 0)) {
                    String str5 = a2.dVY;
                    if (str5 != null) {
                        i2 = str5.hashCode();
                    } else {
                        i2 = 0;
                    }
                    if (i2 > atVar.field_fileFormat.hashCode()) {
                        Log.w("Finder.MediaPreloadModel", "[query] continue to use high fileFormat, [" + cjl.mediaId + "] change[" + a2.dVY + "->" + atVar.field_fileFormat + ']');
                        a2.dVY = atVar.field_fileFormat;
                    }
                }
            }
        }
        if (!z2) {
            a2.dVY = x.V99_VIDEO.detail;
        }
        s sVar = new s(cjl, C1253a.aus(a2.dVY), i3, null, 8);
        if (a2.LEL > 0) {
            j2 = (long) a2.LEL;
        } else {
            j2 = 2097152;
        }
        String str6 = a2.dVY;
        if (str6 == null) {
            str6 = "";
        }
        String str7 = a2.uUI;
        if (str7 == null) {
            str7 = "";
        }
        linkedList.add(new b(1, j2, str6, str7, sVar, (byte) 0));
        if (!z2 || this.uUo <= 0) {
            this.uUE = false;
        } else {
            if (cjl.MoL == 3) {
                cnt cnt = this.uUB.get(str);
                f2 = cnt != null ? cnt.LKC : 0.0f;
            } else {
                bax bax = this.uUA.get(str);
                f2 = bax != null ? bax.LKC : 0.0f;
            }
            int min = Math.min(100, kotlin.h.a.cR(Math.max(1.0f, f2 * ((float) this.uUo))));
            if (cjl.MoL == 3) {
                z = this.uUB.get(str) != null;
            } else {
                z = this.uUA.get(str) != null;
            }
            if (z) {
                this.uUE = true;
                String str8 = a2.dVY;
                if (str8 == null) {
                    str8 = "";
                }
                String str9 = a2.uUI;
                if (str9 == null) {
                    str9 = "";
                }
                linkedList.add(new b(min, 2097152, str8, str9, sVar, (byte) 0));
            }
        }
        this.uUC.put(sVar.auA(), b2.second);
        StringBuilder append = new StringBuilder("[queryPreloadDetail] Cost=").append(System.currentTimeMillis() - currentTimeMillis).append(" isSecondPreload=").append(this.uUE).append(" mid=").append(str).append(" stage=[").append((String) b2.second).append(':').append(linkedList.size()).append("] target").append(b.a(a2)).append(" details=").append(linkedList).append(", allSpec=");
        LinkedList<ayh> linkedList2 = cjl.spec;
        p.g(linkedList2, "media.spec");
        LinkedList<ayh> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList3, 10));
        for (T t : linkedList3) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(b.a(t));
        }
        Log.i("Finder.MediaPreloadModel", append.append(arrayList).toString());
        LinkedList linkedList4 = linkedList;
        AppMethodBeat.o(249546);
        return linkedList4;
    }

    public final s a(long j2, cjl cjl) {
        int i2 = 1;
        AppMethodBeat.i(249547);
        p.h(cjl, "media");
        long currentTimeMillis = System.currentTimeMillis();
        o<ayh, String> b2 = b(cjl);
        A a2 = b2.first;
        if (n.I(a2.uUI, "h265", true)) {
            i2 = 2;
        }
        s sVar = new s(cjl, C1253a.aus(a2.dVY), i2, null, 8);
        this.uUC.put(sVar.auA(), b2.second);
        StringBuilder append = new StringBuilder("[findTargetMedia] feedId=").append(com.tencent.mm.ac.d.zs(j2)).append(" stage=").append((String) b2.second).append(' ').append("target").append(b.a(a2)).append(" allSpec=");
        LinkedList<ayh> linkedList = cjl.spec;
        p.g(linkedList, "media.spec");
        LinkedList<ayh> linkedList2 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
        for (T t : linkedList2) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(b.a(t));
        }
        Log.i("Finder.MediaPreloadModel", append.append(arrayList).append(" Cost=").append(System.currentTimeMillis() - currentTimeMillis).append(' ').toString());
        AppMethodBeat.o(249547);
        return sVar;
    }

    private final o<ayh, String> b(cjl cjl) {
        T t;
        ayh ayh;
        String str;
        ayh ayh2;
        T t2;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(249548);
        long j2 = cjl.MoL == 3 ? this.uUx : this.uUv;
        String str3 = uUG ? "h265" : "h264";
        String str4 = "step#1";
        LinkedList<ayh> linkedList = cjl.spec;
        p.g(linkedList, "media.spec");
        Iterator<T> it = linkedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            T t3 = next;
            if (!n.I(t3.uUI, str3, true) || ((long) t3.LGa) >= j2) {
                z3 = false;
                continue;
            } else {
                z3 = true;
                continue;
            }
            if (z3) {
                t = next;
                break;
            }
        }
        ayh ayh3 = t;
        if (ayh3 == null) {
            str4 = "step#2";
            LinkedList<ayh> linkedList2 = cjl.spec;
            p.g(linkedList2, "media.spec");
            LinkedList<ayh> linkedList3 = linkedList2;
            ListIterator<ayh> listIterator = linkedList3.listIterator(linkedList3.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    ayh2 = null;
                    break;
                }
                ayh previous = listIterator.previous();
                if (n.I(previous.uUI, str3, true)) {
                    ayh2 = previous;
                    break;
                }
            }
            ayh3 = ayh2;
            if (ayh3 == null) {
                LinkedList<ayh> linkedList4 = cjl.spec;
                p.g(linkedList4, "media.spec");
                Iterator<T> it2 = linkedList4.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next2 = it2.next();
                    T t4 = next2;
                    if (!n.I(t4.uUI, p.j(str3, "h265") ? "h264" : "h265", true) || ((long) t4.LGa) >= j2) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        t2 = next2;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 == null) {
                    str = "step#4";
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dvH().value().longValue() != 0) {
                        LinkedList<ayh> linkedList5 = cjl.spec;
                        p.g(linkedList5, "media.spec");
                        if (!linkedList5.isEmpty()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            if (p.j(str3, "h265")) {
                                str2 = x.V2_VIDEO.detail;
                            } else {
                                str2 = x.V1_VIDEO.detail;
                            }
                            ayh = new ayh();
                            ayh.dVY = str2;
                            ayh.uUI = str3;
                            ayh.LEL = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                        }
                    }
                    str2 = x.V0_VIDEO.detail;
                    ayh = new ayh();
                    ayh.dVY = str2;
                    ayh.uUI = str3;
                    ayh.LEL = TPMediaCodecProfileLevel.HEVCHighTierLevel6;
                } else {
                    ayh = t5;
                    str = "step#3";
                }
                LinkedList<ayh> linkedList6 = cjl.spec;
                p.g(linkedList6, "media.spec");
                o<ayh, String> a2 = a(ayh, str, linkedList6);
                AppMethodBeat.o(249548);
                return a2;
            }
        }
        ayh = ayh3;
        str = str4;
        LinkedList<ayh> linkedList62 = cjl.spec;
        p.g(linkedList62, "media.spec");
        o<ayh, String> a22 = a(ayh, str, linkedList62);
        AppMethodBeat.o(249548);
        return a22;
    }

    private static o<ayh, String> a(ayh ayh, String str, List<? extends ayh> list) {
        AppMethodBeat.i(249549);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dvS().value().intValue() != 1 || !uUG) {
            StringBuilder sb = new StringBuilder("[tranToH265IfEnable] config:");
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            Log.i("Finder.MediaPreloadModel", sb.append(com.tencent.mm.plugin.finder.storage.c.dvS().value().intValue() == 1).append(" , isSupportH265:").append(uUG).toString());
            o<ayh, String> oVar = new o<>(ayh, str);
            AppMethodBeat.o(249549);
            return oVar;
        }
        String str2 = ayh.dVY;
        String str3 = ayh.dVY;
        if (p.j(str3, x.V0_VIDEO.detail)) {
            if (list.isEmpty()) {
                ayh.dVY = x.V2_VIDEO.detail;
            } else {
                ayh.dVY = x.V0_VIDEO.detail;
            }
        } else if (p.j(str3, x.V1_VIDEO.detail)) {
            ayh.dVY = x.V2_VIDEO.detail;
        } else if (p.j(str3, x.V3_VIDEO.detail)) {
            ayh.dVY = x.V4_VIDEO.detail;
        } else if (p.j(str3, x.V5_VIDEO.detail)) {
            ayh.dVY = x.V6_VIDEO.detail;
        } else if (p.j(str3, x.V7_VIDEO.detail)) {
            ayh.dVY = x.V8_VIDEO.detail;
        } else if (p.j(str3, x.V9_VIDEO.detail)) {
            ayh.dVY = x.V10_VIDEO.detail;
        }
        Log.i("Finder.MediaPreloadModel", "[tranToH265IfEnable] oldFormat:" + str2 + " , newFormat:" + ayh.dVY);
        o<ayh, String> oVar2 = new o<>(ayh, "step#5");
        AppMethodBeat.o(249549);
        return oVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "", "preloadPercent", "", "preloadMinSize", "", "fileFormat", "", "codingFormat", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocalDefault", "", "(IJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Z)V", "getCodingFormat", "()Ljava/lang/String;", "getFileFormat", "()Z", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getPreloadMinSize", "()J", "getPreloadPercent", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "Companion", "plugin-finder_release"})
    public static final class b {
        private static final b uUK = new b(0, 0, "", "", new s(new cjl(), x.V99_VIDEO, 0, null, 12), (byte) 0);
        public static final C1254a uUL = new C1254a((byte) 0);
        public final String dVY;
        public final int gqZ;
        public final long preloadMinSize;
        public final s uPf;
        public final String uUI;
        private final boolean uUJ;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
            if (r5.uUJ == r6.uUJ) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 249543(0x3cec7, float:3.49684E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0040
                boolean r0 = r6 instanceof com.tencent.mm.plugin.finder.preload.model.a.b
                if (r0 == 0) goto L_0x0045
                com.tencent.mm.plugin.finder.preload.model.a$b r6 = (com.tencent.mm.plugin.finder.preload.model.a.b) r6
                int r0 = r5.gqZ
                int r1 = r6.gqZ
                if (r0 != r1) goto L_0x0045
                long r0 = r5.preloadMinSize
                long r2 = r6.preloadMinSize
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x0045
                java.lang.String r0 = r5.dVY
                java.lang.String r1 = r6.dVY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
                java.lang.String r0 = r5.uUI
                java.lang.String r1 = r6.uUI
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
                com.tencent.mm.plugin.finder.loader.s r0 = r5.uPf
                com.tencent.mm.plugin.finder.loader.s r1 = r6.uPf
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0045
                boolean r0 = r5.uUJ
                boolean r1 = r6.uUJ
                if (r0 != r1) goto L_0x0045
            L_0x0040:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x0044:
                return r0
            L_0x0045:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x0044
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.preload.model.a.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(249542);
            long j2 = this.preloadMinSize;
            int i3 = ((this.gqZ * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            String str = this.dVY;
            int hashCode = ((str != null ? str.hashCode() : 0) + i3) * 31;
            String str2 = this.uUI;
            int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
            s sVar = this.uPf;
            if (sVar != null) {
                i2 = sVar.hashCode();
            }
            int i4 = (hashCode2 + i2) * 31;
            boolean z = this.uUJ;
            if (z) {
                z = true;
            }
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = z ? 1 : 0;
            int i8 = i5 + i4;
            AppMethodBeat.o(249542);
            return i8;
        }

        private b(int i2, long j2, String str, String str2, s sVar) {
            p.h(str, "fileFormat");
            p.h(str2, "codingFormat");
            p.h(sVar, "media");
            AppMethodBeat.i(249540);
            this.gqZ = i2;
            this.preloadMinSize = j2;
            this.dVY = str;
            this.uUI = str2;
            this.uPf = sVar;
            this.uUJ = false;
            AppMethodBeat.o(249540);
        }

        public /* synthetic */ b(int i2, long j2, String str, String str2, s sVar, byte b2) {
            this(i2, j2, str, str2, sVar);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail$Companion;", "", "()V", "NIL", "Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "getNIL", "()Lcom/tencent/mm/plugin/finder/preload/model/MediaPreloadModel$Detail;", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.preload.model.a$b$a  reason: collision with other inner class name */
        public static final class C1254a {
            private C1254a() {
            }

            public /* synthetic */ C1254a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(249541);
            AppMethodBeat.o(249541);
        }

        public final String toString() {
            AppMethodBeat.i(249539);
            String str = this.gqZ + "%:" + this.preloadMinSize + ':' + this.dVY;
            AppMethodBeat.o(249539);
            return str;
        }
    }
}
