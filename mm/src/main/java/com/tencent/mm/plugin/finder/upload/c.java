package com.tencent.mm.plugin.finder.upload;

import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.b.a.kk;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderMediaReportInfo;
import com.tencent.mm.protocal.protobuf.FinderMediaReportObject;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.protocal.protobuf.erf;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.vfs.s;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 D2\u00020\u0001:\u0001DB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u001c\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002JL\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015H\u0002J\\\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,H\u0002J¢\u0001\u0010-\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00103\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\b\u00104\u001a\u0004\u0018\u00010\u00112\u0006\u00105\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u00106\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t\u0018\u000108H\u0002J\u0018\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010;\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020\tH\u0016J\b\u0010=\u001a\u00020\u0011H\u0016JN\u0010>\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020\"2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask;", "Lcom/tencent/mm/plugin/finder/upload/FinderTask;", "finderObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFinderObj", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderObj", "checkProgressException", "", ch.COL_LOCALID, "", "isLongVideo", "", "isCancel", "checkVideoInfoMatch", "path", "", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "chooseMixType", "", "originAudio", "addAudio", "compositionToCropInfo", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "exportMedia", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "remuxComposition", "Lkotlin/Pair;", "", "startRemuxerTick", FirebaseAnalytics.b.INDEX, "outputPath", "mediaReportObject", "Lcom/tencent/mm/protocal/protobuf/FinderMediaReportObject;", "size", "remuxLongVideoComposition", "localMedia", "vcPerformanceStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "remuxNormalVideo", "videoWidth", "videoHeight", "width", "height", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "localFinderMedia", "musicPath", "mixType", "isLongVideoAttachShort", "onUpdateProgress", "Lkotlin/Function1;", "rotateRect", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "saveFinderObject", "start", "uniqueId", "updateMedia", ch.COL_REPORTOBJECT, "audioQuality", "videoQuality", "updateProgress", "avgProgress", "Companion", "plugin-finder_release"})
public final class c extends j {
    private static final String TAG = TAG;
    private static final MMHandler vRP;
    public static final a vRQ = new a((byte) 0);
    FinderItem vRO;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.upload.c$c  reason: collision with other inner class name */
    public static final class C1307c extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ int puW;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.c vRU;
        final /* synthetic */ int vRV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1307c(c cVar, z.c cVar2, int i2, int i3) {
            super(1);
            this.vRT = cVar;
            this.vRU = cVar2;
            this.puW = i2;
            this.vRV = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(253049);
            float floatValue = f2.floatValue();
            if (floatValue - this.vRU.SYD > 0.1f) {
                c.c(this.vRT.vRO.getLocalId(), false, false);
                this.vRT.bi((((float) this.puW) + floatValue) / ((float) this.vRV));
                this.vRU.SYD = floatValue;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253049);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ int puW;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.d vRW;
        final /* synthetic */ FinderMediaReportObject vRX;
        final /* synthetic */ long vRY;
        final /* synthetic */ String vRZ;
        final /* synthetic */ aco vSa;
        final /* synthetic */ VideoTransPara vSb;
        final /* synthetic */ acn vSc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, z.d dVar, int i2, FinderMediaReportObject finderMediaReportObject, long j2, String str, aco aco, VideoTransPara videoTransPara, acn acn, Object obj, z.a aVar) {
            super(1);
            this.vRT = cVar;
            this.vRW = dVar;
            this.puW = i2;
            this.vRX = finderMediaReportObject;
            this.vRY = j2;
            this.vRZ = str;
            this.vSa = aco;
            this.vSb = videoTransPara;
            this.vSc = acn;
            this.tpZ = obj;
            this.tqa = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            int i2 = -1;
            AppMethodBeat.i(253050);
            boolean booleanValue = bool.booleanValue();
            c.c(this.vRT.vRO.getLocalId(), false, true);
            z.d dVar = this.vRW;
            if (!booleanValue) {
                a aVar = c.vRQ;
                Log.i(c.TAG, "remuxer failed " + this.puW + " localId:" + this.vRT.vRO.getLocalId());
                r.c cVar = r.c.vhb;
                r.c.nU(false);
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vRY);
                this.vRX.remuxRetCode = -1;
            } else {
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vRY);
                this.vRX.remuxRetCode = 0;
                r.c cVar2 = r.c.vhb;
                r.c.u(Util.ticksToNow(this.vRY), false);
                a aVar2 = c.vRQ;
                Log.i(c.TAG, "remuxer succ " + this.puW + ", cost: " + Util.ticksToNow(this.vRY) + ", path:" + this.vRZ + " localId:" + this.vRT.vRO.getLocalId());
                long boW = s.boW(this.vRZ);
                long currentTicks = Util.currentTicks();
                a aVar3 = c.vRQ;
                int a2 = a.a(this.vRZ, this.vSa.targetWidth, this.vSa.targetHeight, this.vSb, this.vRT.vRO.getLocalId(), false);
                com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (boW > com.tencent.mm.plugin.finder.storage.c.dqI()) {
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dtH() != 1) {
                        this.vRX.zipTime = (int) Util.ticksToNow(currentTicks);
                        if (a2 == 0) {
                            this.vRX.zipRetCode = 1;
                        } else {
                            this.vRX.zipRetCode = 2;
                        }
                    }
                }
                if (!TextUtils.isEmpty(this.vSc.iiv) || this.vSc.Lnd.size() > 1 || this.vSc.Gxx.Lna.size() > 0 || this.vSc.Gxx.Lnb) {
                    com.tencent.mm.plugin.recordvideo.e.c cVar5 = com.tencent.mm.plugin.recordvideo.e.c.Cic;
                    com.tencent.mm.plugin.recordvideo.e.c.aLJ(this.vRZ);
                }
                i2 = a2;
            }
            dVar.SYE = i2;
            synchronized (this.tpZ) {
                try {
                    this.tqa.SYB = true;
                    this.tpZ.notify();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(253050);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(253050);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ int puW;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.c vRU;
        final /* synthetic */ int vRV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar, z.c cVar2, int i2, int i3) {
            super(1);
            this.vRT = cVar;
            this.vRU = cVar2;
            this.puW = i2;
            this.vRV = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(261413);
            float floatValue = f2.floatValue();
            if (floatValue - this.vRU.SYD > 0.1f) {
                c.c(this.vRT.vRO.getLocalId(), true, false);
                this.vRT.bi((((float) this.puW) + floatValue) / ((float) this.vRV));
                this.vRU.SYD = floatValue;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261413);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ z.d UUW;
        final /* synthetic */ z.d UUX;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.d vRW;
        final /* synthetic */ FinderMediaReportObject vRX;
        final /* synthetic */ long vRY;
        final /* synthetic */ String vRZ;
        final /* synthetic */ VideoTransPara vSb;
        final /* synthetic */ boolean vSf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar, z.d dVar, FinderMediaReportObject finderMediaReportObject, long j2, String str, boolean z, z.d dVar2, z.d dVar3, VideoTransPara videoTransPara, Object obj, z.a aVar) {
            super(1);
            this.vRT = cVar;
            this.vRW = dVar;
            this.vRX = finderMediaReportObject;
            this.vRY = j2;
            this.vRZ = str;
            this.vSf = z;
            this.UUW = dVar2;
            this.UUX = dVar3;
            this.vSb = videoTransPara;
            this.tpZ = obj;
            this.tqa = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            int i2;
            AppMethodBeat.i(253052);
            boolean booleanValue = bool.booleanValue();
            a aVar = c.vRQ;
            Log.i(c.TAG, "buildFromFilePath: success ".concat(String.valueOf(booleanValue)));
            z.d dVar = this.vRW;
            if (!booleanValue) {
                a aVar2 = c.vRQ;
                Log.i(c.TAG, "remuxer failed longvideo localId:" + this.vRT.vRO.getLocalId());
                r.c cVar = r.c.vhb;
                r.c.nU(true);
                r.c cVar2 = r.c.vhb;
                r.c.nU(true);
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vRY);
                this.vRX.remuxRetCode = -1;
                i2 = -1;
            } else {
                this.vRX.remuxTime = (int) Util.ticksToNow(this.vRY);
                this.vRX.remuxRetCode = 0;
                r.c cVar3 = r.c.vhb;
                r.c.u(Util.ticksToNow(this.vRY), true);
                long boW = s.boW(this.vRZ);
                a aVar3 = c.vRQ;
                Log.i(c.TAG, "remuxer succ longvideo, size:" + boW + ", cost: " + Util.ticksToNow(this.vRY) + ", path:" + this.vRZ + " localId:" + this.vRT.vRO.getLocalId());
                i2 = 0;
                if (!this.vSf) {
                    long currentTicks = Util.currentTicks();
                    a aVar4 = c.vRQ;
                    i2 = a.a(this.vRZ, this.UUW.SYE, this.UUX.SYE, this.vSb, this.vRT.vRO.getLocalId(), !this.vSf);
                    com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (boW > com.tencent.mm.plugin.finder.storage.c.dqI()) {
                        com.tencent.mm.plugin.finder.storage.c cVar5 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        if (com.tencent.mm.plugin.finder.storage.c.dtH() != 1) {
                            this.vRX.zipTime = (int) Util.ticksToNow(currentTicks);
                            if (i2 == 0) {
                                this.vRX.zipRetCode = 1;
                            } else {
                                this.vRX.zipRetCode = 2;
                            }
                        }
                    }
                } else {
                    com.tencent.mm.plugin.finder.storage.c cVar6 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (boW > com.tencent.mm.plugin.finder.storage.c.dqL()) {
                        a aVar5 = c.vRQ;
                        Log.i(c.TAG, "remux longvideo, size out of range");
                        r.b bVar = r.b.vgJ;
                        r.b.dov();
                        FinderFeedReportObject finderFeedReportObject = this.vRT.vRO.field_reportObject;
                        if (finderFeedReportObject != null) {
                            finderFeedReportObject.longVideoSizeInvalid = 1;
                        }
                        c.a(this.vRT);
                        i2 = -4;
                    }
                }
            }
            dVar.SYE = i2;
            synchronized (this.tpZ) {
                try {
                    this.tqa.SYB = true;
                    this.tpZ.notifyAll();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(253052);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(253052);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ kotlin.g.a.b vSk;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(kotlin.g.a.b bVar) {
            super(1);
            this.vSk = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(253053);
            float floatValue = f2.floatValue();
            kotlin.g.a.b bVar = this.vSk;
            if (bVar != null) {
                bVar.invoke(Float.valueOf(floatValue));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253053);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class h extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ int puW;
        final /* synthetic */ Object tpZ;
        final /* synthetic */ z.a tqa;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.d vRW;
        final /* synthetic */ FinderMediaReportObject vRX;
        final /* synthetic */ long vRY;
        final /* synthetic */ VideoTransPara vSb;
        final /* synthetic */ kk vSd;
        final /* synthetic */ boolean vSf;
        final /* synthetic */ cjl vSl;
        final /* synthetic */ boolean vSm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar, cjl cjl, kk kkVar, long j2, boolean z, z.d dVar, int i2, boolean z2, FinderMediaReportObject finderMediaReportObject, int i3, int i4, VideoTransPara videoTransPara, Object obj, z.a aVar) {
            super(1);
            this.vRT = cVar;
            this.vSl = cjl;
            this.vSd = kkVar;
            this.vRY = j2;
            this.vSf = z;
            this.vRW = dVar;
            this.puW = i2;
            this.vSm = z2;
            this.vRX = finderMediaReportObject;
            this.cKE = i3;
            this.cKF = i4;
            this.vSb = videoTransPara;
            this.tpZ = obj;
            this.tqa = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
            if ((r1 != null ? r1.retryCount : 0) >= 2) goto L_0x0055;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8 A[SYNTHETIC, Splitter:B:29:0x00c8] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00f3  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(java.lang.String r13) {
            /*
            // Method dump skipped, instructions count: 538
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.h.invoke(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$start$4$3"})
    static final class i extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ int puW;
        final /* synthetic */ c vRT;
        final /* synthetic */ z.c vRU;
        final /* synthetic */ List vSn;
        final /* synthetic */ List vSo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(z.c cVar, int i2, c cVar2, List list, List list2) {
            super(1);
            this.vRU = cVar;
            this.puW = i2;
            this.vRT = cVar2;
            this.vSn = list;
            this.vSo = list2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            AppMethodBeat.i(253055);
            float floatValue = f2.floatValue();
            if (floatValue - this.vRU.SYD > 0.1f) {
                this.vRT.bi((((float) this.puW) + floatValue) / ((float) this.vSo.size()));
                this.vRU.SYD = floatValue;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(253055);
            return xVar;
        }
    }

    public c(FinderItem finderItem) {
        p.h(finderItem, "finderObj");
        AppMethodBeat.i(167734);
        this.vRO = finderItem;
        AppMethodBeat.o(167734);
    }

    public static final /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(253062);
        cVar.dAR();
        AppMethodBeat.o(253062);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ>\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0017J6\u0010$\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion;", "", "()V", "RemuxTypeNoNeedRemux", "", "RemuxTypeNormalVideo", "RemuxTypeTavkit", "TAG", "", "getTAG", "()Ljava/lang/String;", "_5_min", "", "checkProgressExceptionHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "checkRemuxVideo", "path", "width", "height", "videoParams", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", ch.COL_LOCALID, "isLongVideoAttachShort", "", "convertViewRect", "Landroid/graphics/Rect;", "viewRect", "Lcom/tencent/mm/protocal/protobuf/ViewRect;", "getABAResult", "Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "input", "durationSec", "", "startTimeSec", "videoTransPara", "isLongVideo", "getAudioQualityLevel", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "samplerate", WeChatBrands.Business.GROUP_CHANNELS, "enableAuQA", "useOriAu", "ABAResult", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static Rect a(erf erf) {
            AppMethodBeat.i(167726);
            p.h(erf, "viewRect");
            Rect rect = new Rect(erf.left, erf.top, erf.right, erf.bottom);
            AppMethodBeat.o(167726);
            return rect;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x002a, code lost:
            if (com.tencent.mm.plugin.finder.storage.c.dtH() == 1) goto L_0x002c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int a(java.lang.String r22, int r23, int r24, com.tencent.mm.modelcontrol.VideoTransPara r25, long r26, boolean r28) {
            /*
            // Method dump skipped, instructions count: 268
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.a.a(java.lang.String, int, int, com.tencent.mm.modelcontrol.VideoTransPara, long, boolean):int");
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/upload/FinderMediaProcessTask$Companion$ABAResult;", "", "errCode", "", "width", "height", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.upload.c$a$a  reason: collision with other inner class name */
        public static final class C1306a {
            public final int bitrate;
            public final int errCode;
            public final int height;
            public final int[] vRR;
            public final int width;

            /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
                if (kotlin.g.b.p.j(r3.vRR, r4.vRR) != false) goto L_0x0030;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 167725(0x28f2d, float:2.35033E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0030
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.upload.c.a.C1306a
                    if (r0 == 0) goto L_0x0035
                    com.tencent.mm.plugin.finder.upload.c$a$a r4 = (com.tencent.mm.plugin.finder.upload.c.a.C1306a) r4
                    int r0 = r3.errCode
                    int r1 = r4.errCode
                    if (r0 != r1) goto L_0x0035
                    int r0 = r3.width
                    int r1 = r4.width
                    if (r0 != r1) goto L_0x0035
                    int r0 = r3.height
                    int r1 = r4.height
                    if (r0 != r1) goto L_0x0035
                    int r0 = r3.bitrate
                    int r1 = r4.bitrate
                    if (r0 != r1) goto L_0x0035
                    int[] r0 = r3.vRR
                    int[] r1 = r4.vRR
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x0035
                L_0x0030:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x0034:
                    return r0
                L_0x0035:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x0034
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.a.C1306a.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                AppMethodBeat.i(167724);
                int i2 = ((((((this.errCode * 31) + this.width) * 31) + this.height) * 31) + this.bitrate) * 31;
                int[] iArr = this.vRR;
                int hashCode = (iArr != null ? Arrays.hashCode(iArr) : 0) + i2;
                AppMethodBeat.o(167724);
                return hashCode;
            }

            public final String toString() {
                AppMethodBeat.i(167723);
                String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.vRR) + ")";
                AppMethodBeat.o(167723);
                return str;
            }

            public C1306a(int i2, int i3, int i4, int i5, int[] iArr) {
                this.errCode = i2;
                this.width = i3;
                this.height = i4;
                this.bitrate = i5;
                this.vRR = iArr;
            }
        }

        public static C1306a a(String str, int i2, int i3, float f2, float f3, VideoTransPara videoTransPara, boolean z) {
            int i4;
            int i5;
            AppMethodBeat.i(253048);
            p.h(str, "input");
            p.h(videoTransPara, "videoTransPara");
            if (z) {
                try {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    float dqJ = ((float) com.tencent.mm.plugin.finder.storage.c.dqJ()) / (1.0f * ((float) com.tencent.mm.plugin.finder.storage.c.dqs()));
                    com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    videoTransPara.iTo = (int) (dqJ * com.tencent.mm.plugin.finder.storage.c.dqt());
                    Log.i(c.TAG, "ABA:  finder video maxVideoSize:" + videoTransPara + ".maxVideoSize");
                } catch (Throwable th) {
                }
            }
            Log.i(c.TAG, "ABA:  finder video video endtime:" + f2 + " starttime:" + f3);
            com.tencent.mm.plugin.finder.storage.c cVar4 = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dqB()) {
                int[] a2 = AdaptiveAdjustBitrate.a(str, i3, i2, videoTransPara.fps, videoTransPara.videoBitrate, f2, f3, 4, videoTransPara.iTi, videoTransPara.iTj, videoTransPara.iTk, videoTransPara.iTl, videoTransPara.iTm, videoTransPara.iTn, videoTransPara.iTo, false);
                int i6 = videoTransPara.videoBitrate;
                int i7 = -1;
                if (a2 != null) {
                    i6 = a2[0] * 1000;
                    i7 = 0;
                    Log.i(c.TAG, "getABAResult use videoBitrate:".concat(String.valueOf(i6)));
                }
                if (a2 == null || a2[5] <= 0) {
                    i4 = i3;
                    i5 = i2;
                } else {
                    int i8 = a2[1];
                    i7 = 0;
                    i4 = a2[2];
                    i5 = i8;
                }
                Log.i(c.TAG, "ABA:  finder video bitrate:" + i6 + " width: " + i5 + " height:" + i4);
                if (o.bhk() != null) {
                    com.tencent.mm.an.e.s(a2);
                }
                C1306a aVar = new C1306a(i7, i5, i4, i6, a2);
                AppMethodBeat.o(253048);
                return aVar;
            }
            C1306a aVar2 = new C1306a(-1, 0, 0, 0, null);
            AppMethodBeat.o(253048);
            return aVar2;
        }
    }

    static {
        AppMethodBeat.i(167735);
        MMHandler mMHandler = new MMHandler(TAG + "#checkProgressExceptionHandler", b.vRS);
        mMHandler.setLogging(false);
        vRP = mMHandler;
        AppMethodBeat.o(167735);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "msg", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class b implements MMHandler.Callback {
        public static final b vRS = new b();

        static {
            AppMethodBeat.i(253046);
            AppMethodBeat.o(253046);
        }

        b() {
        }

        public final boolean handleMessage(Message message) {
            boolean z = false;
            AppMethodBeat.i(253045);
            boolean z2 = message.arg1 == 1;
            long j2 = (long) message.what;
            r.c cVar = r.c.vhb;
            r.c.nX(z2);
            FinderItem Fz = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(j2);
            if (Fz != null) {
                FinderFeedReportObject finderFeedReportObject = Fz.field_reportObject;
                if (finderFeedReportObject != null) {
                    finderFeedReportObject.uploadLogicError = 3;
                }
                c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                c.a.r(Fz);
                com.tencent.mm.plugin.finder.report.i iVar = com.tencent.mm.plugin.finder.report.i.vfo;
                com.tencent.mm.plugin.finder.report.i.Fb(Fz.getLocalId());
            }
            a aVar2 = c.vRQ;
            String str = c.TAG;
            StringBuilder sb = new StringBuilder("[checkProgressException] timeout update progress, item is null=");
            if (Fz == null) {
                z = true;
            }
            Log.e(str, sb.append(z).append(" localId=").append(Fz != null ? Long.valueOf(Fz.getLocalId()) : null).toString());
            AppMethodBeat.o(253045);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03b7, code lost:
        if ((r2 == null || r2.length() == 0) != false) goto L_0x03b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x032b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x062b A[Catch:{ Throwable -> 0x108d }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0644 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0651  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x06f0  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x06f5  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0722  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0732  */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0735  */
    /* JADX WARNING: Removed duplicated region for block: B:547:0x0e48  */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0eae  */
    /* JADX WARNING: Removed duplicated region for block: B:553:0x0edb  */
    /* JADX WARNING: Removed duplicated region for block: B:564:0x0f29  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x0f3e  */
    /* JADX WARNING: Removed duplicated region for block: B:606:0x1015  */
    /* JADX WARNING: Removed duplicated region for block: B:608:0x101b  */
    /* JADX WARNING: Removed duplicated region for block: B:621:0x1075  */
    /* JADX WARNING: Removed duplicated region for block: B:635:0x10c4  */
    /* JADX WARNING: Removed duplicated region for block: B:639:0x10d5  */
    /* JADX WARNING: Removed duplicated region for block: B:681:0x1072 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0275  */
    @Override // com.tencent.mm.plugin.finder.upload.j
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void start() {
        /*
        // Method dump skipped, instructions count: 4328
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.start():void");
    }

    private final void dAR() {
        AppMethodBeat.i(253057);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(this.vRO);
        AppMethodBeat.o(253057);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        if ((r2 != null ? r2.retryCount : 0) >= 2) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int a(long r44, int r46, java.lang.String r47, int r48, int r49, int r50, int r51, int r52, com.tencent.mm.modelcontrol.VideoTransPara r53, com.tencent.mm.protocal.protobuf.cjl r54, com.tencent.mm.protocal.protobuf.FinderMediaReportObject r55, java.lang.String r56, int r57, boolean r58, boolean r59, com.tencent.mm.g.b.a.kk r60, kotlin.g.a.b<? super java.lang.Float, kotlin.x> r61) {
        /*
        // Method dump skipped, instructions count: 359
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.a(long, int, java.lang.String, int, int, int, int, int, com.tencent.mm.modelcontrol.VideoTransPara, com.tencent.mm.protocal.protobuf.cjl, com.tencent.mm.protocal.protobuf.FinderMediaReportObject, java.lang.String, int, boolean, boolean, com.tencent.mm.g.b.a.kk, kotlin.g.a.b):int");
    }

    private final kotlin.o<Integer, Float> a(long j2, int i2, String str, VideoTransPara videoTransPara, cjl cjl, FinderMediaReportObject finderMediaReportObject, int i3) {
        aco aco;
        int i4;
        AppMethodBeat.i(253059);
        Log.i(TAG, "remuxComposition outputPath:".concat(String.valueOf(str)));
        acn acn = cjl.MfU;
        if (acn == null) {
            acn = new acn();
        }
        p.g(acn, "media.videoCompositionInfo ?: CompositionInfo()");
        z.d dVar = new z.d();
        dVar.SYE = -1;
        if (acn == null || (aco = acn.Gxw) == null) {
            aco = new aco();
        }
        aco.rpE = str;
        aco.Lnr = w.fBu() || w.fBv();
        Object obj = new Object();
        z.a aVar = new z.a();
        aVar.SYB = false;
        com.tencent.mm.plugin.vlog.model.f fVar = new com.tencent.mm.plugin.vlog.model.f();
        cjx cjx = cjl.uOR;
        if (cjx != null) {
            i4 = cjx.retryCount;
        } else {
            i4 = 0;
        }
        fVar.retryCount = i4;
        fVar.Gxj = true;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dqB()) {
            fVar.r(videoTransPara);
        }
        z.c cVar2 = new z.c();
        cVar2.SYD = 0.0f;
        fVar.N(new C1307c(this, cVar2, i2, i3));
        float a2 = fVar.a(acn, new d(this, dVar, i2, finderMediaReportObject, j2, str, aco, videoTransPara, acn, obj, aVar));
        synchronized (obj) {
            try {
                if (!aVar.SYB) {
                    Log.i(TAG, "wait ".concat(String.valueOf(i2)));
                    obj.wait();
                    Log.i(TAG, "notify " + i2 + ", " + dVar.SYE);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(253059);
                throw th;
            }
        }
        kotlin.o<Integer, Float> oVar = new kotlin.o<>(Integer.valueOf(dVar.SYE), Float.valueOf(a2));
        AppMethodBeat.o(253059);
        return oVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.o<java.lang.Integer, java.lang.Float> a(long r24, com.tencent.mm.modelcontrol.VideoTransPara r26, com.tencent.mm.protocal.protobuf.cjl r27, java.lang.String r28, com.tencent.mm.protocal.protobuf.FinderMediaReportObject r29, boolean r30, int r31, int r32) {
        /*
        // Method dump skipped, instructions count: 642
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.upload.c.a(long, com.tencent.mm.modelcontrol.VideoTransPara, com.tencent.mm.protocal.protobuf.cjl, java.lang.String, com.tencent.mm.protocal.protobuf.FinderMediaReportObject, boolean, int, int):kotlin.o");
    }

    private static void a(VideoTransPara videoTransPara, cjl cjl, String str, cjl cjl2, int i2, FinderMediaReportObject finderMediaReportObject, float f2, float f3, boolean z) {
        int i3;
        FinderMediaReportInfo finderMediaReportInfo;
        FinderMediaReportInfo finderMediaReportInfo2;
        FinderMediaReportInfo finderMediaReportInfo3;
        FinderMediaReportInfo finderMediaReportInfo4;
        FinderMediaReportInfo finderMediaReportInfo5;
        FinderMediaReportInfo finderMediaReportInfo6;
        FinderMediaReportObject finderMediaReportObject2;
        acm acm;
        LinkedList<jn> linkedList;
        FinderMediaReportInfo finderMediaReportInfo7;
        FinderMediaReportInfo finderMediaReportInfo8;
        aty aty;
        aco aco;
        AppMethodBeat.i(253061);
        p.h(videoTransPara, "videoParams");
        p.h(cjl, "localMedia");
        p.h(str, "outputPath");
        p.h(cjl2, "media");
        p.h(finderMediaReportObject, ch.COL_REPORTOBJECT);
        y yVar = y.vXH;
        com.tencent.mm.plugin.sight.base.a awl = y.awl(str);
        if (awl != null) {
            cjl.width = (float) awl.width;
            cjl.height = (float) awl.height;
            cjl2.width = (float) awl.width;
            cjl2.height = (float) awl.height;
        }
        int i4 = videoTransPara.iTf;
        int i5 = (int) ((cjl.height / cjl.width) * ((float) i4));
        String ag = f.vSz.ag(str, i4, i5);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtU()) {
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            i3 = AdaptiveAdjustBitrate.getVideoImageQuality(com.tencent.mm.plugin.finder.storage.c.dqC(), 0, i4, i5, 0.8f);
        } else {
            i3 = 0;
        }
        cjl2.MoZ = finderMediaReportObject;
        cjl2.url = str;
        cjl2.thumbUrl = ag;
        if (!z && !cjl.MoY && (aty = cjl2.MoU) != null) {
            try {
                acn acn = cjl.MfU;
                if (!(acn == null || (aco = acn.Gxw) == null)) {
                    float f4 = cjl2.width / ((float) aco.xlg);
                    float f5 = cjl2.height / ((float) aco.xlh);
                    Rect rect = new Rect((int) (aty.left * f4), (int) (aty.top * f5), (int) (f4 * aty.right), (int) (aty.bottom * f5));
                    int i6 = videoTransPara.iTf;
                    al alVar = al.waC;
                    String awE = al.awE(str);
                    f fVar = f.vSz;
                    cjl2.thumbUrl = f.a(str, awE, i6, (int) ((((float) rect.height()) / ((float) rect.width())) * ((float) i6)), new Rect(rect.left, rect.bottom, rect.right, rect.top));
                    cjl2.MoR = ag;
                    x xVar = x.SXb;
                }
            } catch (Exception e2) {
                Log.e(TAG, "crop halfThumb from " + ag + " fail:" + e2.getLocalizedMessage());
                x xVar2 = x.SXb;
            }
        }
        cjl2.MoO = false;
        cjl2.mediaId = MD5Util.getMD5String(cjl.url);
        cjl2.fileSize = (int) s.boW(str);
        FinderMediaReportObject finderMediaReportObject3 = cjl2.MoZ;
        if (finderMediaReportObject3 != null) {
            finderMediaReportObject3.target = new FinderMediaReportInfo();
        }
        FinderMediaReportObject finderMediaReportObject4 = cjl2.MoZ;
        if (!(finderMediaReportObject4 == null || (finderMediaReportInfo8 = finderMediaReportObject4.target) == null)) {
            finderMediaReportInfo8.fileSize = cjl2.fileSize;
        }
        FinderMediaReportObject finderMediaReportObject5 = cjl2.MoZ;
        if (finderMediaReportObject5 != null) {
            FinderMediaReportObject finderMediaReportObject6 = cjl2.MoZ;
            finderMediaReportObject5.videoFinalSize = (finderMediaReportObject6 == null || (finderMediaReportInfo7 = finderMediaReportObject6.target) == null) ? 0 : finderMediaReportInfo7.fileSize;
        }
        acn acn2 = cjl2.MfU;
        if (acn2 != null) {
            acn2.Lng = false;
        }
        if (cjl2.codec_info == null) {
            cjl2.codec_info = new ayg();
        }
        ayg ayg = cjl2.codec_info;
        if (ayg != null) {
            ayg.LIt = f3;
            ayg.LIv = f2;
            ayg.LIw = (float) i3;
            acn acn3 = cjl2.MfU;
            ayg.LIy = ((acn3 == null || (acm = acn3.Gxx) == null || (linkedList = acm.Lna) == null) ? 0 : linkedList.size()) > 0;
            Log.i(TAG, "codec_info video_score:" + ayg.LIt + ",video_cover_score:" + ayg.LIu + ",video_audio_score:" + ayg.LIv + ",thumb_score:" + ayg.LIw + ",hdimg_score:" + ayg.LIx + ",has_stickers:" + ayg.LIy);
        }
        FinderMediaReportObject finderMediaReportObject7 = cjl2.MoZ;
        if ((finderMediaReportObject7 != null ? finderMediaReportObject7.codecInfo : null) == null && (finderMediaReportObject2 = cjl2.MoZ) != null) {
            finderMediaReportObject2.codecInfo = cjl2.codec_info;
        }
        MultiMediaVideoChecker.a aTV = MultiMediaVideoChecker.GyY.aTV(str);
        if (aTV != null) {
            cjl2.videoDuration = kotlin.h.a.cR(((float) aTV.duration) / 1000.0f);
            FinderMediaReportObject finderMediaReportObject8 = cjl2.MoZ;
            if (!(finderMediaReportObject8 == null || (finderMediaReportInfo6 = finderMediaReportObject8.target) == null)) {
                finderMediaReportInfo6.videoDuration = (int) aTV.duration;
            }
            FinderMediaReportObject finderMediaReportObject9 = cjl2.MoZ;
            if (!(finderMediaReportObject9 == null || (finderMediaReportInfo5 = finderMediaReportObject9.target) == null)) {
                finderMediaReportInfo5.width = aTV.width;
            }
            FinderMediaReportObject finderMediaReportObject10 = cjl2.MoZ;
            if (!(finderMediaReportObject10 == null || (finderMediaReportInfo4 = finderMediaReportObject10.target) == null)) {
                finderMediaReportInfo4.height = aTV.height;
            }
            FinderMediaReportObject finderMediaReportObject11 = cjl2.MoZ;
            if (!(finderMediaReportObject11 == null || (finderMediaReportInfo3 = finderMediaReportObject11.target) == null)) {
                finderMediaReportInfo3.videoBitrate = aTV.bitrate;
            }
            FinderMediaReportObject finderMediaReportObject12 = cjl2.MoZ;
            if (!(finderMediaReportObject12 == null || (finderMediaReportInfo2 = finderMediaReportObject12.target) == null)) {
                finderMediaReportInfo2.audioBitrate = aTV.audioBitrate;
            }
            FinderMediaReportObject finderMediaReportObject13 = cjl2.MoZ;
            if (!(finderMediaReportObject13 == null || (finderMediaReportInfo = finderMediaReportObject13.target) == null)) {
                finderMediaReportInfo.fps = (int) aTV.cKu;
            }
        }
        Log.i(TAG, "processList index " + i2 + " url " + cjl.url + " thumbUrl: " + cjl.thumbUrl + " newMd5: " + MD5Util.getMD5String(cjl.url) + " size:" + Util.getSizeKB(s.boW(cjl.url)));
        m mVar = m.Gyi;
        m.l(str, f3);
        m mVar2 = m.Gyi;
        m.fBf();
        AppMethodBeat.o(253061);
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        AppMethodBeat.i(167732);
        String valueOf = String.valueOf(this.vRO.getLocalId());
        AppMethodBeat.o(167732);
        return valueOf;
    }

    public final void bi(float f2) {
        AppMethodBeat.i(167733);
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int drd = (int) (((float) com.tencent.mm.plugin.finder.storage.c.drd()) * f2);
        Log.i(TAG, "feed " + this.vRO.getLocalId() + " updateProgress  " + f2 + ", " + drd);
        if (this.vRO.getPostInfo().Mpc < drd) {
            this.vRO.getPostInfo().Mpc = drd;
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.r(this.vRO);
        }
        EventCenter eventCenter = EventCenter.instance;
        hk hkVar = new hk();
        hkVar.dLT.localId = this.vRO.getLocalId();
        hkVar.dLT.progress = this.vRO.getPostInfo().Mpc;
        eventCenter.publish(hkVar);
        AppMethodBeat.o(167733);
    }

    public static final /* synthetic */ void c(long j2, boolean z, boolean z2) {
        AppMethodBeat.i(253063);
        vRP.removeMessages((int) j2);
        if (!z2) {
            MMHandler mMHandler = vRP;
            Message obtainMessage = mMHandler.obtainMessage((int) j2);
            obtainMessage.arg1 = z ? 1 : 0;
            mMHandler.sendMessageDelayed(obtainMessage, 300000);
        }
        AppMethodBeat.o(253063);
    }
}
