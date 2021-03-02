package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Size;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.videocomposition.b.f;
import com.tencent.mm.videocomposition.b.g;
import com.tencent.mm.videocomposition.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetExtension;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.composition.MutableVideoComposition;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 15}, hxE = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u0000 2\u00020\u0001:\u0003\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0000¢\u0006\u0002\u0010\u0007B\u0005¢\u0006\u0002\u0010\bJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u0004J\u0006\u0010=\u001a\u00020>J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u00032\u0006\u0010<\u001a\u00020\u0004H\u0002J\u0006\u0010A\u001a\u00020\u000fJ\u0016\u0010B\u001a\u00020C2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010D\u001a\u0002082\u0006\u0010E\u001a\u00020\u000fJL\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u001c\b\u0002\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000208\u0018\u00010K2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000208\u0018\u00010MJZ\u0010N\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u001c\b\u0002\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000208\u0018\u00010K2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000208\u0018\u00010MH\u0002JV\u0010Q\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010O\u001a\u0004\u0018\u00010P2\u001c\b\u0002\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000208\u0018\u00010K2\u0016\b\u0002\u0010L\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u000208\u0018\u00010MJ\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020\u001fJ\u0006\u0010U\u001a\u00020\u0016J\u0006\u0010V\u001a\u00020SJ\b\u0010W\u001a\u0004\u0018\u00010XJ\u0006\u0010Y\u001a\u00020ZJ\b\u0010[\u001a\u00020SH\u0007J\u0006\u0010\\\u001a\u00020\u0016J$\u0010]\u001a\u0002082\u0006\u0010^\u001a\u00020\n2\u0014\u00109\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010_\u0012\u0004\u0012\u0002080MJ\u0010\u0010`\u001a\u0004\u0018\u00010\u00042\u0006\u0010a\u001a\u00020\u0016J\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010c\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0010\u0010d\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010e\u001a\u0002082\u0006\u0010<\u001a\u00020\u0004J\u0016\u0010f\u001a\u0002082\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nJ\u0010\u0010i\u001a\u0002082\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010j\u001a\u0002082\u0006\u0010k\u001a\u00020\u000fJ\u000e\u0010l\u001a\u0002082\u0006\u0010m\u001a\u00020\u000fJ\u000e\u0010n\u001a\u0002082\u0006\u0010o\u001a\u00020\u001fJ\u000e\u0010p\u001a\u0002082\u0006\u0010o\u001a\u00020\u001fJ\u000e\u0010q\u001a\u0002082\u0006\u0010r\u001a\u00020#J\u0016\u0010s\u001a\u0002082\u0006\u0010t\u001a\u00020\u00162\u0006\u0010u\u001a\u00020\u0016J\u0018\u0010v\u001a\u0002082\u0006\u0010g\u001a\u00020\n2\u0006\u0010h\u001a\u00020\nH\u0007J\u000e\u0010w\u001a\u0002082\u0006\u0010x\u001a\u00020\u000fJ\u0014\u0010y\u001a\u0002082\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010z\u001a\u0002082\b\u00104\u001a\u0004\u0018\u000105J\u000e\u0010{\u001a\u0002082\u0006\u0010|\u001a\u00020\u000fJ\u0016\u0010}\u001a\u0002082\u0006\u0010~\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0004R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b%\u0010\u0018R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001a\u0010+\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u0011\u0010.\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0014\u00100\u001a\u00020\u0016XD¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0018R\u001e\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u000402j\b\u0012\u0004\u0012\u00020\u0004`3X\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/videocomposition/VideoComposition;", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "(Ljava/util/List;)V", FirebaseAnalytics.b.ORIGIN, "(Lcom/tencent/mm/videocomposition/VideoComposition;)V", "()V", "assetHeight", "", "assetWidth", "audioProcessorFactory", "Lcom/tencent/mm/videocomposition/audio/IAudioProcessorFactory;", "checkPerformance", "", "effect", "Lcom/tencent/mm/videocomposition/render/VLogDirectorMultiVideoCompositionEffect;", "enableOriginAudio", "exportSession", "Lcom/tencent/tav/core/AssetExportSession;", "id", "", "getId", "()J", "setId", "(J)V", "isAudioTracksMerge", "isRevert", "isVideoTracksMerge", "outputCrop", "Landroid/graphics/Rect;", "playEnd", "getPlayEnd", "playFps", "", "playStart", "getPlayStart", "renderCallback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallbackList;", "setEnd", "getSetEnd", "setSetEnd", "setStart", "getSetStart", "setSetStart", "sourceEnd", "getSourceEnd", "sourceStart", "getSourceStart", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "viewRect", "addRenderProcessCallback", "", "callback", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "addTrack", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "buildSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildTrackChannel", "Lcom/tencent/tavkit/composition/TAVClip;", "cancelExport", "createComposition", "Lcom/tencent/tavkit/composition/TAVComposition;", "enableVideoSound", "enable", AssetExtension.SCENE_EXPORT, "path", "", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "Lkotlin/Function2;", "progressCallback", "Lkotlin/Function1;", "exportImpl", "videoEncoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "exportWithCustomEncoder", "getAssetSize", "Landroid/util/Size;", "getDisplayScreenRect", "getDurationMs", "getOutputSize", "getPerformanceReport", "Lcom/tencent/mm/videocomposition/render/PerformanceTick;", "getPlayRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "getRenderSize", "getSourceDuration", "getThumbBitmap", "widthLimit", "Landroid/graphics/Bitmap;", "getTrackByTimeMs", "timeMs", "getTrackList", "isEnableOriginSound", "removeRenderProcessCallback", "removeTrack", "setAssetSize", "width", "height", "setAudioProcessorFactory", "setAudioTracksMerge", "audioTracksMerge", "setCheckPerformance", "check", "setDisplayScreenRect", "rect", "setOutputCrop", "setPlayFps", "fps", "setPlayRange", "start", "end", "setRenderSize", "setRevert", "revert", "setTrackList", "setVLogEffectMgr", "setVideoTracksMerge", "videoTracksMerge", "updateTrack", FirebaseAnalytics.b.INDEX, "Companion", "VideoOutputConfig", "video_composition_release"})
public final class n {
    public static final a Rhv = new a((byte) 0);
    public EffectManager GAw;
    public final ArrayList<d> Gzn = new ArrayList<>();
    private boolean Gzo;
    public boolean QEl;
    private final long Rhk;
    public long Rhl = -1;
    public long Rhm = -1;
    private int Rhn;
    private int Rho;
    public float Rhp = 30.0f;
    private final Rect Rhq = new Rect();
    private f Rhr = new f();
    public g Rhs;
    public com.tencent.mm.videocomposition.a.b Rht;
    private boolean Rhu;
    public AssetExportSession exportSession;
    public long id;
    private boolean isAudioTracksMerge;
    private boolean isVideoTracksMerge = true;
    public Rect viewRect = new Rect();

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "timeMs", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
    static final class d extends q implements m<Long, Bitmap, x> {
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(kotlin.g.a.b bVar) {
            super(2);
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Long l, Bitmap bitmap) {
            Integer num = null;
            AppMethodBeat.i(216771);
            Bitmap bitmap2 = bitmap;
            StringBuilder append = new StringBuilder("getThumbBitmap result, timeMs:").append(l.longValue()).append(", bitmap:").append(bitmap2).append(", size:[").append(bitmap2 != null ? Integer.valueOf(bitmap2.getWidth()) : null).append(", ");
            if (bitmap2 != null) {
                num = Integer.valueOf(bitmap2.getHeight());
            }
            com.tencent.mm.videocomposition.c.b.i("VideoComposition", append.append(num).append(']').toString(), new Object[0]);
            this.gWe.invoke(bitmap2);
            x xVar = x.SXb;
            AppMethodBeat.o(216771);
            return xVar;
        }
    }

    public n() {
        AppMethodBeat.i(216791);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "create VLogComposition", new Object[0]);
        AppMethodBeat.o(216791);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/videocomposition/VideoComposition$Companion;", "", "()V", "EXTRA_TRACK", "", "IMAGE_SIZE_LIMIT", "", "TAG", "video_composition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216792);
        h hVar = h.Rhg;
        h.efp();
        AppMethodBeat.o(216792);
    }

    private long hfn() {
        Object obj;
        AppMethodBeat.i(216772);
        ArrayList arrayList = new ArrayList();
        for (T t : this.Gzn) {
            if (t.fCr()) {
                arrayList.add(t);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (!it.hasNext()) {
                obj = next;
            } else {
                long j2 = ((d) next).endTimeMs;
                while (true) {
                    next = it.next();
                    long j3 = ((d) next).endTimeMs;
                    if (j2 >= j3) {
                        j3 = j2;
                        next = next;
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                    j2 = j3;
                }
                obj = next;
            }
        }
        d dVar = (d) obj;
        if (dVar != null) {
            long j4 = dVar.endTimeMs;
            AppMethodBeat.o(216772);
            return j4;
        }
        AppMethodBeat.o(216772);
        return 0;
    }

    public final long getPlayStart() {
        return this.Rhl >= 0 ? this.Rhl : this.Rhk;
    }

    public final long fBz() {
        AppMethodBeat.i(216773);
        if (this.Rhm >= 0) {
            long j2 = this.Rhm;
            AppMethodBeat.o(216773);
            return j2;
        }
        long hfn = hfn();
        AppMethodBeat.o(216773);
        return hfn;
    }

    public final void e(d dVar) {
        AppMethodBeat.i(216774);
        p.h(dVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        this.Gzn.add(dVar);
        AppMethodBeat.o(216774);
    }

    public final long getDurationMs() {
        AppMethodBeat.i(216775);
        long fBz = fBz() - getPlayStart();
        AppMethodBeat.o(216775);
        return fBz;
    }

    public final long getSourceDuration() {
        AppMethodBeat.i(216776);
        long hfn = hfn() - this.Rhk;
        AppMethodBeat.o(216776);
        return hfn;
    }

    public final void at(long j2, long j3) {
        AppMethodBeat.i(216777);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setPlayRange:[" + j2 + ", " + j3 + ']', new Object[0]);
        this.Rhl = j2;
        this.Rhm = j3;
        AppMethodBeat.o(216777);
    }

    public final CMTimeRange hfo() {
        AppMethodBeat.i(216778);
        CMTimeRange cMTimeRange = new CMTimeRange(new CMTime(getPlayStart(), 1000), new CMTime(fBz() - getPlayStart(), 1000));
        AppMethodBeat.o(216778);
        return cMTimeRange;
    }

    private final TAVComposition ka(List<d> list) {
        TAVClip tAVClip;
        List listOf;
        AppMethodBeat.i(216779);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "createComposition: track size " + list.size(), new Object[0]);
        if (list.isEmpty()) {
            TAVComposition tAVComposition = new TAVComposition();
            AppMethodBeat.o(216779);
            return tAVComposition;
        }
        TAVComposition tAVComposition2 = new TAVComposition();
        List<d> list2 = list;
        ArrayList arrayList = new ArrayList(j.a(list2, 10));
        for (T t : list2) {
            com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add track type:" + t.type + " startTime:" + t.startTimeMs + ", endTime:" + t.endTimeMs + ", trackStartTime:" + t.GGz + ", trackEndTime:" + t.GGA, new Object[0]);
            boolean z = this.Gzo;
            if (t.type != 0) {
                TAVClip tAVClip2 = new TAVClip(i.Rhj.c(t));
                tAVClip2.setStartTime(new CMTime(t.startTimeMs, 1000));
                tAVClip2.setDuration(new CMTime(t.getDurationMs(), 1000));
                TAVResource resource = tAVClip2.getResource();
                p.g(resource, "clip.resource");
                resource.setSourceTimeRange(new CMTimeRange(new CMTime(t.GGz, 1000), new CMTime(t.GGA - t.GGz, 1000)));
                if (t.type != 2 || z) {
                    TAVAudioConfiguration audioConfiguration = tAVClip2.getAudioConfiguration();
                    p.g(audioConfiguration, "clip.audioConfiguration");
                    audioConfiguration.setVolume(t.volume);
                } else {
                    TAVAudioConfiguration audioConfiguration2 = tAVClip2.getAudioConfiguration();
                    p.g(audioConfiguration2, "clip.audioConfiguration");
                    audioConfiguration2.setVolume(0.0f);
                }
                com.tencent.mm.videocomposition.c.b.i("CompositionTrack", t.id + " buildClip buildVideoClip, path:" + t.path + ", video startEnd:[" + t.GGz + ", " + t.GGA + "], material startEnd:[" + t.startTimeMs + ", " + t.endTimeMs + "], volume: " + t.volume, new Object[0]);
                tAVClip = tAVClip2;
            } else {
                tAVClip = new TAVClip(new TAVEmptyResource(CMTime.CMTimeZero));
            }
            com.tencent.mm.videocomposition.a.b bVar = this.Rht;
            if (bVar != null) {
                tAVClip.getAudioConfiguration().addAudioProcessorNode(bVar.f(t));
            }
            tAVClip.putExtraTrackInfo("key_extra_track", t);
            if (t.startTimeMs > 0) {
                TAVClip tAVClip3 = new TAVClip(new TAVEmptyResource(new CMTime(t.startTimeMs, 1000)));
                tAVClip3.setStartTime(CMTime.CMTimeZero);
                tAVClip3.setDuration(new CMTime(t.startTimeMs, 1000));
                com.tencent.mm.videocomposition.c.b.i("VideoComposition", "add front empty clip duration:" + t.startTimeMs, new Object[0]);
                listOf = j.listOf((Object[]) new TAVClip[]{tAVClip3, tAVClip});
            } else {
                listOf = j.listOf(tAVClip);
            }
            arrayList.add(listOf);
        }
        int i2 = 0;
        for (Object obj : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            List<? extends TAVTransitionableAudio> list3 = (List) obj;
            if (list.get(i2).fCr()) {
                tAVComposition2.addVideoChannel(list3);
            }
            if (list.get(i2).type == 2 || list.get(i2).type == 3 || list.get(i2).type == 1) {
                tAVComposition2.addAudioChannel(list3);
            }
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder("finish build composition, duration:");
        CMTime duration = tAVComposition2.getDuration();
        p.g(duration, "composition.duration");
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", sb.append(duration.getTimeUs() / 1000).toString(), new Object[0]);
        AppMethodBeat.o(216779);
        return tAVComposition2;
    }

    public final void lW(int i2, int i3) {
        AppMethodBeat.i(216780);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "setAssetSize: " + i2 + ", " + i3, new Object[0]);
        this.Rhn = i2;
        this.Rho = i3;
        g gVar = this.Rhs;
        if (gVar != null) {
            gVar.lY(i2, i3);
        }
        this.viewRect.set(0, 0, i2, i3);
        AppMethodBeat.o(216780);
    }

    public final Size hfp() {
        AppMethodBeat.i(216781);
        Size size = new Size(this.Rhn, this.Rho);
        AppMethodBeat.o(216781);
        return size;
    }

    public final void t(Rect rect) {
        AppMethodBeat.i(216782);
        p.h(rect, "rect");
        this.Rhq.set(rect);
        AppMethodBeat.o(216782);
    }

    public final Size hfq() {
        AppMethodBeat.i(216783);
        if (this.Rhq.isEmpty()) {
            Size hfp = hfp();
            AppMethodBeat.o(216783);
            return hfp;
        }
        Size size = new Size(this.Rhq.width(), this.Rhq.height());
        AppMethodBeat.o(216783);
        return size;
    }

    public final void wB(boolean z) {
        AppMethodBeat.i(216784);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "enableVideoSound:".concat(String.valueOf(z)), new Object[0]);
        this.Gzo = z;
        AppMethodBeat.o(216784);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(216785);
        if (eVar != null) {
            this.Rhr.b(eVar);
        }
        AppMethodBeat.o(216785);
    }

    public final TAVSource buildSource() {
        AppMethodBeat.i(216786);
        TAVComposition ka = ka(this.Gzn);
        g gVar = new g();
        this.Rhs = gVar;
        long currentTimeMillis = System.currentTimeMillis();
        EffectManager effectManager = this.GAw;
        if (effectManager != null) {
            effectManager.b(com.tencent.mm.xeffect.effect.j.PAGTransitionEffect);
        }
        int size = this.Gzn.size();
        for (int i2 = 1; i2 < size; i2++) {
            d dVar = this.Gzn.get(i2 - 1);
            p.g(dVar, "trackList[i - 1]");
            d dVar2 = dVar;
            d dVar3 = this.Gzn.get(i2);
            p.g(dVar3, "trackList[i]");
            d dVar4 = dVar3;
            k kVar = dVar4.Rhc;
            if (kVar.isValid()) {
                if (kVar.GAn == null) {
                    EffectManager effectManager2 = this.GAw;
                    kVar.GAn = effectManager2 != null ? effectManager2.a(com.tencent.mm.xeffect.effect.j.PAGTransitionEffect, kVar.path) : null;
                }
                ad adVar = kVar.GAn;
                if (adVar != null) {
                    adVar.aH(dVar4.startTimeMs, dVar2.endTimeMs);
                }
                EffectManager effectManager3 = this.GAw;
                if (effectManager3 != null) {
                    effectManager3.a(kVar.GAn);
                }
            }
        }
        new StringBuilder("buildSource: update transition cost ").append(System.currentTimeMillis() - currentTimeMillis);
        gVar.lY(this.Rhn, this.Rho);
        gVar.b(this.GAw);
        gVar.t(this.Rhq);
        gVar.Rhu = this.Rhu;
        gVar.Rib = this.Rhr;
        ka.setVideoMixEffect(new com.tencent.mm.videocomposition.b.b(gVar));
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(ka);
        tAVCompositionBuilder.setReloadChannels(false);
        tAVCompositionBuilder.setVideoTracksMerge(this.isVideoTracksMerge);
        tAVCompositionBuilder.setAudioTracksMerge(this.isAudioTracksMerge);
        new StringBuilder("buildSource, videoTracksMerge:").append(this.isVideoTracksMerge).append(", audioTracksMerge:").append(this.isAudioTracksMerge);
        TAVSource buildSource = tAVCompositionBuilder.buildSource();
        p.g(buildSource, "source");
        VideoComposition videoComposition = buildSource.getVideoComposition();
        if (videoComposition == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.tav.core.composition.MutableVideoComposition");
            AppMethodBeat.o(216786);
            throw tVar;
        }
        ((MutableVideoComposition) videoComposition).setFrameDuration(new CMTime(1000, (int) (this.Rhp * 1000.0f)));
        AppMethodBeat.o(216786);
        return buildSource;
    }

    public final void c(int i2, kotlin.g.a.b<? super Bitmap, x> bVar) {
        int i3;
        AppMethodBeat.i(216787);
        p.h(bVar, "callback");
        c.a aVar = c.RgU;
        c b2 = c.a.b(this);
        if (!this.Rhq.isEmpty()) {
            i3 = (int) (((((float) this.Rhq.height()) * 1.0f) / ((float) this.Rhq.width())) * ((float) i2));
        } else {
            i3 = (int) (((((float) this.Rho) * 1.0f) / ((float) this.Rhn)) * ((float) i2));
        }
        b2.setSize(i2, i3);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "getThumbBitmap request width:" + i2 + ", height:" + i3, new Object[0]);
        b2.b(j.listOf(Long.valueOf(getPlayStart())), new d(bVar));
        AppMethodBeat.o(216787);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fHÆ\u0001J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013¨\u0006-"}, hxF = {"Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "", "targetSize", "Landroid/util/Size;", "videoBitrate", "", "fps", "iFrameInterval", "audioBitrate", "audioSampleRate", "audioChannelCount", "highProfileEnable", "", "aacEncodeNeedCodecSpecificData", "outputHevc", "(Landroid/util/Size;IIIIIIZZZ)V", "getAacEncodeNeedCodecSpecificData", "()Z", "getAudioBitrate", "()I", "getAudioChannelCount", "getAudioSampleRate", "getFps", "getHighProfileEnable", "getIFrameInterval", "getOutputHevc", "getTargetSize", "()Landroid/util/Size;", "getVideoBitrate", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "video_composition_release"})
    public static final class b {
        final boolean Lnr;
        final Size Rhw;
        final boolean Rhx;
        final boolean Rhy;
        final int audioBitrate;
        public final int audioChannelCount;
        public final int audioSampleRate;
        final int fps;
        final int idB;
        final int videoBitrate;

        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0069, code lost:
            if ((r5.Lnr == r6.Lnr) != false) goto L_0x006b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
            // Method dump skipped, instructions count: 134
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.videocomposition.n.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            AppMethodBeat.i(216767);
            Size size = this.Rhw;
            int hashCode = (((((((((((((size != null ? size.hashCode() : 0) * 31) + this.videoBitrate) * 31) + this.fps) * 31) + this.idB) * 31) + this.audioBitrate) * 31) + this.audioSampleRate) * 31) + this.audioChannelCount) * 31;
            boolean z = this.Rhx;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (i3 + hashCode) * 31;
            boolean z2 = this.Rhy;
            if (z2) {
                z2 = true;
            }
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = (i7 + i6) * 31;
            boolean z3 = this.Lnr;
            if (!z3) {
                i2 = z3 ? 1 : 0;
            }
            int i11 = i10 + i2;
            AppMethodBeat.o(216767);
            return i11;
        }

        public final String toString() {
            AppMethodBeat.i(216766);
            String str = "VideoOutputConfig(targetSize=" + this.Rhw + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", iFrameInterval=" + this.idB + ", audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + ", highProfileEnable=" + this.Rhx + ", aacEncodeNeedCodecSpecificData=" + this.Rhy + ", outputHevc=" + this.Lnr + ")";
            AppMethodBeat.o(216766);
            return str;
        }

        public b(Size size, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3) {
            p.h(size, "targetSize");
            AppMethodBeat.i(216765);
            this.Rhw = size;
            this.videoBitrate = i2;
            this.fps = i3;
            this.idB = i4;
            this.audioBitrate = i5;
            this.audioSampleRate = i6;
            this.audioChannelCount = i7;
            this.Rhx = z;
            this.Rhy = z2;
            this.Lnr = z3;
            AppMethodBeat.o(216765);
        }

        public /* synthetic */ b(Size size, int i2, int i3, int i4, int i5, int i6, int i7) {
            this(size, i2, i3, i4, i5, i6, i7, true, true, false);
        }
    }

    private final AssetExportSession a(String str, b bVar, AssetWriterVideoEncoder assetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> mVar, kotlin.g.a.b<? super Float, x> bVar2) {
        AppMethodBeat.i(216788);
        TAVSource buildSource = buildSource();
        ExportConfig exportConfig = new ExportConfig(bVar.Rhw.getWidth(), bVar.Rhw.getHeight());
        exportConfig.setOutputFilePath(str);
        exportConfig.setVideoBitRate(bVar.videoBitrate);
        exportConfig.setVideoFrameRate(bVar.fps);
        exportConfig.setVideoIFrameInterval(bVar.idB);
        exportConfig.setHighProfile(bVar.Rhx);
        exportConfig.setAudioBitRate(bVar.audioBitrate);
        exportConfig.setAudioSampleRateHz(bVar.audioSampleRate);
        exportConfig.setAudioChannelCount(bVar.audioChannelCount);
        exportConfig.setAudioEncodeNeedCodecSpecificData(bVar.Rhy);
        exportConfig.setEncodeHevc(bVar.Lnr);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export: config: " + exportConfig.getOutputWidth() + ", " + exportConfig.getOutputHeight() + "; video: " + exportConfig.getVideoBitRate() + ", " + exportConfig.getVideoFrameRate() + ", " + bVar.idB + ", " + bVar.Rhx + "; audio: " + bVar.audioBitrate + ", " + bVar.audioSampleRate + ", " + bVar.audioChannelCount + ", aacEncodeNeedCodecSpecificData:" + bVar.Rhy + ',' + "outputHevc:" + bVar.Lnr, new Object[0]);
        AssetExportSession assetExportSession = new AssetExportSession(buildSource.getAsset(), exportConfig);
        assetExportSession.setOutputFilePath(str);
        assetExportSession.setOutputFileType("mp4");
        assetExportSession.setVideoComposition(buildSource.getVideoComposition());
        assetExportSession.setAudioMix(buildSource.getAudioMix());
        assetExportSession.setTimeRange(hfo());
        assetExportSession.setRevertMode(this.QEl);
        assetExportSession.setVideoEncoder(assetWriterVideoEncoder);
        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export duration:" + (hfn() - this.Rhk) + " playRange:" + hfo(), new Object[0]);
        assetExportSession.exportAsynchronouslyWithCompletionHandler(new c(bVar2, SystemClock.elapsedRealtime(), mVar));
        this.exportSession = assetExportSession;
        AppMethodBeat.o(216788);
        return assetExportSession;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "assetExportSession", "Lcom/tencent/tav/core/AssetExportSession;", "kotlin.jvm.PlatformType", "handlerCallback"})
    public static final class c implements AssetExportSession.ExportCallbackHandler {
        final /* synthetic */ kotlin.g.a.b Rhz;
        final /* synthetic */ m nzd;
        final /* synthetic */ long qVz;

        c(kotlin.g.a.b bVar, long j2, m mVar) {
            this.Rhz = bVar;
            this.qVz = j2;
            this.nzd = mVar;
        }

        @Override // com.tencent.tav.core.AssetExportSession.ExportCallbackHandler
        public final void handlerCallback(AssetExportSession assetExportSession) {
            AppMethodBeat.i(216770);
            p.g(assetExportSession, "assetExportSession");
            AssetExportSession.AssetExportSessionStatus status = assetExportSession.getStatus();
            int errCode = assetExportSession.getErrCode();
            float progress = assetExportSession.getProgress();
            if (status != null) {
                switch (o.$EnumSwitchMapping$0[status.ordinal()]) {
                    case 1:
                        kotlin.g.a.b bVar = this.Rhz;
                        if (bVar != null) {
                            bVar.invoke(Float.valueOf(progress));
                            AppMethodBeat.o(216770);
                            return;
                        }
                        AppMethodBeat.o(216770);
                        return;
                    case 2:
                        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export completed: " + progress + ", cost:" + (SystemClock.elapsedRealtime() - this.qVz), new Object[0]);
                        m mVar = this.nzd;
                        if (mVar != null) {
                            mVar.invoke(Boolean.TRUE, Integer.valueOf(errCode));
                            AppMethodBeat.o(216770);
                            return;
                        }
                        AppMethodBeat.o(216770);
                        return;
                    case 3:
                    case 4:
                    case 5:
                        com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed: status:" + status + ", progress:" + progress, new Object[0]);
                        m mVar2 = this.nzd;
                        if (mVar2 != null) {
                            mVar2.invoke(Boolean.FALSE, Integer.valueOf(errCode));
                            AppMethodBeat.o(216770);
                            return;
                        }
                        AppMethodBeat.o(216770);
                        return;
                }
            }
            com.tencent.mm.videocomposition.c.b.i("VideoComposition", "export failed other status:" + status + ", progress:" + progress, new Object[0]);
            m mVar3 = this.nzd;
            if (mVar3 != null) {
                mVar3.invoke(Boolean.FALSE, Integer.valueOf(errCode));
                AppMethodBeat.o(216770);
                return;
            }
            AppMethodBeat.o(216770);
        }
    }

    public final AssetExportSession a(String str, b bVar, m<? super Boolean, ? super Integer, x> mVar, kotlin.g.a.b<? super Float, x> bVar2) {
        AppMethodBeat.i(216789);
        p.h(str, "path");
        p.h(bVar, "config");
        AssetExportSession a2 = a(str, bVar, null, mVar, bVar2);
        AppMethodBeat.o(216789);
        return a2;
    }

    public final AssetExportSession b(String str, b bVar, AssetWriterVideoEncoder assetWriterVideoEncoder, m<? super Boolean, ? super Integer, x> mVar, kotlin.g.a.b<? super Float, x> bVar2) {
        AppMethodBeat.i(216790);
        p.h(str, "path");
        p.h(bVar, "config");
        AssetExportSession a2 = a(str, bVar, assetWriterVideoEncoder, mVar, bVar2);
        AppMethodBeat.o(216790);
        return a2;
    }
}
