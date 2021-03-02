package com.tencent.mm.videocomposition;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.jsapi.z.n;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.videocomposition.c.b;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 f2\u00020\u0001:\u0001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\bJ\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020ZJ\u0010\u0010[\u001a\u00020U2\u0006\u0010V\u001a\u00020\bH\u0002J\u0006\u0010\\\u001a\u00020]J\u0006\u0010^\u001a\u00020\bJ\u0006\u0010_\u001a\u00020\bJ\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cH\u0002J\u0010\u0010d\u001a\u00020a2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010e\u001a\u00020aR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020&@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u001bR\u001a\u00104\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R\u001a\u00107\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R$\u0010:\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u001bR\u001a\u0010=\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u001bR\u001a\u0010@\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R$\u0010C\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u001bR$\u0010F\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010\u001bR\u001a\u0010I\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010.\"\u0004\bP\u00100R\u001a\u0010Q\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010)\"\u0004\bS\u0010+¨\u0006g"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionTrack;", "", "path", "", "type", "", "(Ljava/lang/String;I)V", "autoCenterCrop", "", "getAutoCenterCrop", "()Z", "setAutoCenterCrop", "(Z)V", "cropRect", "Landroid/graphics/Rect;", "getCropRect", "()Landroid/graphics/Rect;", "setCropRect", "(Landroid/graphics/Rect;)V", "durationMs", "", "getDurationMs", "()J", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "endWithTransition", "getEndWithTransition", "setEndWithTransition", "id", "getId", "setId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "getRotate", "()I", "setRotate", "(I)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "startWithTransition", "getStartWithTransition", "setStartWithTransition", "trackCropRect", "getTrackCropRect", "setTrackCropRect", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "getTransition", "()Lcom/tencent/mm/videocomposition/TrackTransition;", "setTransition", "(Lcom/tencent/mm/videocomposition/TrackTransition;)V", "getType", "setType", "volume", n.NAME, r.NAME, "buildClip", "Lcom/tencent/tavkit/composition/TAVClip;", "enableOriginAudio", "buildComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "getResource", "Lcom/tencent/tavkit/composition/resource/TAVResource;", "hasAudio", "hasVideo", "initImageClipInfo", "", "bitmap", "Landroid/graphics/Bitmap;", "initVideoClipInfo", ch.COL_UPDATETIME, "Companion", "video_composition_release"})
public final class d {
    public static final a Rhf = new a((byte) 0);
    public long GGA;
    public long GGz;
    public long GJB;
    public int Gzu;
    public int Gzv;
    public Rect Rha = new Rect();
    public boolean Rhb = true;
    public k Rhc = new k();
    public long Rhd;
    public long Rhe;
    public int dYT;
    public long endTimeMs;
    public long id;
    public Rect iiw = new Rect();
    public float mwH = 1.0f;
    public String path;
    public long startTimeMs;
    public int type;
    public float volume = 1.0f;

    static {
        AppMethodBeat.i(216744);
        AppMethodBeat.o(216744);
    }

    public d(String str, int i2) {
        p.h(str, "path");
        AppMethodBeat.i(216743);
        this.path = str;
        this.type = i2;
        b.i("CompositionTrack", "create VCLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id, new Object[0]);
        switch (this.type) {
            case 1:
                i.Rhj.c(this);
                Bitmap d2 = i.Rhj.d(this);
                if (d2 != null) {
                    this.Gzu = d2.getWidth();
                    this.Gzv = d2.getHeight();
                    b.i("CompositionTrack", "initImageClipInfo sourceWidth:" + this.Gzu + ", sourceHeight:" + this.Gzv, new Object[0]);
                    break;
                }
                break;
            case 2:
            case 3:
                m bpj = i.Rhj.bpj(this.path);
                if (bpj == null) {
                    b.i("CompositionTrack", "initVideoClipInfo failed", new Object[0]);
                    break;
                } else {
                    this.Gzu = bpj.width;
                    this.Gzv = bpj.height;
                    b.i("CompositionTrack", "initVideoClipInfo, sourceWidth:" + this.Gzu + ", sourceHeight:" + this.Gzv, new Object[0]);
                    break;
                }
        }
        CMTime duration = i.Rhj.c(this).getDuration();
        p.g(duration, "getResource().duration");
        this.GJB = duration.getTimeUs() / 1000;
        KQ(0);
        KR(this.GJB);
        KP(this.GGA);
        AppMethodBeat.o(216743);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/videocomposition/CompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "makeChain", "", "trackList", "", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "video_composition_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void jZ(List<d> list) {
            long j2;
            AppMethodBeat.i(216740);
            p.h(list, "trackList");
            if (list.isEmpty()) {
                AppMethodBeat.o(216740);
                return;
            }
            long j3 = 0;
            T t = null;
            long j4 = 0;
            for (T t2 : list) {
                long j5 = (long) (((float) (t2.GGA - t2.GGz)) / t2.mwH);
                if (t2.Rhc.isValid()) {
                    j2 = t2.Rhc.duration;
                } else {
                    j2 = 0;
                }
                long min = Math.min(j2, Math.min(j3, j5));
                if (t != null) {
                    t.Rhe = j4 - (min / 2);
                }
                t2.Rhd = j4 - (min / 2);
                t2.KO(j4 - min);
                t2.KP(t2.startTimeMs + j5);
                j4 = t2.endTimeMs;
                t = t2;
                j3 = j5;
            }
            d dVar = (d) j.ku(list);
            dVar.Rhe = dVar.endTimeMs;
            AppMethodBeat.o(216740);
        }
    }

    public final void KO(long j2) {
        if (j2 >= 0) {
            this.startTimeMs = j2;
        }
    }

    public final void KP(long j2) {
        if (j2 >= 0) {
            this.endTimeMs = j2;
        }
    }

    public final void KQ(long j2) {
        if (j2 >= 0) {
            this.GGz = j2;
        }
    }

    public final void KR(long j2) {
        if (j2 >= 0) {
            this.GGA = j2;
        }
    }

    public final void setPlayRate(float f2) {
        if (f2 > 0.0f) {
            this.mwH = f2;
        }
    }

    public final long getDurationMs() {
        return this.endTimeMs - this.startTimeMs;
    }

    public final TAVSource hfj() {
        AppMethodBeat.i(216741);
        TAVClip tAVClip = new TAVClip(i.Rhj.c(this));
        TAVVideoConfiguration videoConfiguration = tAVClip.getVideoConfiguration();
        p.g(videoConfiguration, "clip.videoConfiguration");
        videoConfiguration.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        TAVComposition tAVComposition = new TAVComposition();
        tAVComposition.addVideoChannel(j.listOf(tAVClip));
        TAVCompositionBuilder tAVCompositionBuilder = new TAVCompositionBuilder(tAVComposition);
        tAVCompositionBuilder.setReloadChannels(false);
        TAVSource buildSource = tAVCompositionBuilder.buildSource();
        p.g(buildSource, "builder.buildSource()");
        AppMethodBeat.o(216741);
        return buildSource;
    }

    public final void gKp() {
        AppMethodBeat.i(216742);
        KP((long) (((float) this.startTimeMs) + (((float) (this.GGA - this.GGz)) / this.mwH)));
        AppMethodBeat.o(216742);
    }

    public final boolean fCr() {
        return this.type == 1 || this.type == 2;
    }
}
