package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.n;
import com.tencent.mm.plugin.appbrand.jsapi.z.r;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.b.d;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 a2\u00020\u0001:\u0001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010W\u001a\u00020XJ\u0010\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J\u001a\u0010]\u001a\u00020Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0_J\u0006\u0010`\u001a\u00020ZR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020'8F@FX\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u001a\u0010/\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001a\u00105\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001a\"\u0004\b7\u0010\u001cR$\u00108\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b9\u0010\u000f\"\u0004\b:\u0010\u0018R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR$\u0010C\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bD\u0010\u000f\"\u0004\bE\u0010\u0018R$\u0010F\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0018R\u0011\u0010I\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bJ\u0010$R\u0011\u0010K\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bL\u0010\u000fR\u0011\u0010M\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bN\u0010\u000fR\u001a\u0010O\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001a\"\u0004\bS\u0010\u001cR$\u0010T\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020'8F@FX\u000e¢\u0006\f\u001a\u0004\bU\u0010*\"\u0004\bV\u0010,¨\u0006b"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "value", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "hasTransition", "", "getHasTransition", "()Z", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "", "playRate", "getPlayRate", "()F", "setPlayRate", "(F)V", "sourceDuration", "getSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "getSourceScale", "setSourceScale", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "timeRange", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "getTimeRange", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "transAssetPath", "getTransAssetPath", "transDuration", "getTransDuration", "transEffectId", "getTransEffectId", "transId", "getTransId", "setTransId", "getType", "setType", "volume", n.NAME, r.NAME, "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "setTransition", "", "transition", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "transformTransEffectId", "effectMap", "", "updateTrack", "Companion", "plugin-vlog_release"})
public final class ad {
    public static final a GzB = new a((byte) 0);
    public final d Cev;
    public final com.tencent.mm.videocomposition.d GzA;
    int Gze;
    public int Gzu;
    public int Gzv;
    public float Gzw;
    public final j Gzx;
    public int Gzy;
    public final MediaEditReportInfo.EditItem Gzz;
    public final int id;
    public String path;
    public int type;

    public /* synthetic */ ad(String str, int i2) {
        this(str, i2, 0);
    }

    public ad(String str, int i2, int i3) {
        p.h(str, "path");
        AppMethodBeat.i(190710);
        this.path = str;
        this.type = i2;
        this.Gze = i3;
        this.id = hashCode();
        this.Cev = new d(0, false, 3);
        this.Gzw = 1.0f;
        this.Gzx = new j();
        this.Gzy = -1;
        this.Gzz = new MediaEditReportInfo.EditItem();
        Log.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
        String k = s.k(this.path, false);
        k = k == null ? "" : k;
        p.g(k, "VFSFileOp.exportExternalPath(path, false) ?: \"\"");
        this.GzA = new com.tencent.mm.videocomposition.d(k, this.type);
        AppMethodBeat.o(190710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack$Companion;", "", "()V", "TAG", "", "TypeAudio", "", "TypeImage", "TypeUnknown", "TypeVideo", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(190711);
        aa aaVar = aa.Gzi;
        aa.efp();
        i iVar = i.Rhj;
        i.hfm();
        AppMethodBeat.o(190711);
    }

    public final void KO(long j2) {
        AppMethodBeat.i(190703);
        this.GzA.KO(j2);
        AppMethodBeat.o(190703);
    }

    public final void KP(long j2) {
        AppMethodBeat.i(190704);
        this.GzA.KP(j2);
        AppMethodBeat.o(190704);
    }

    public final void setVolume(float f2) {
        this.GzA.volume = f2;
    }

    public final void KQ(long j2) {
        AppMethodBeat.i(190705);
        this.GzA.KQ(j2);
        AppMethodBeat.o(190705);
    }

    public final void KR(long j2) {
        AppMethodBeat.i(190706);
        this.GzA.KR(j2);
        AppMethodBeat.o(190706);
    }

    public final void setPlayRate(float f2) {
        AppMethodBeat.i(190707);
        this.GzA.setPlayRate(f2);
        AppMethodBeat.o(190707);
    }

    public final boolean fBG() {
        AppMethodBeat.i(190708);
        boolean isValid = this.GzA.Rhc.isValid();
        AppMethodBeat.o(190708);
        return isValid;
    }

    public final String fBH() {
        return this.GzA.Rhc.path;
    }

    public final long fBI() {
        com.tencent.mm.xeffect.effect.ad adVar = this.GzA.Rhc.GAn;
        if (adVar != null) {
            return adVar.id;
        }
        return 0;
    }

    public final void a(a.C1849a aVar) {
        AppMethodBeat.i(190709);
        if (aVar != null) {
            this.Gzy = aVar.order;
            this.GzA.Rhc.setPath(aVar.assetPath);
            this.GzA.Rhc.duration = aVar.duration;
            AppMethodBeat.o(190709);
            return;
        }
        this.Gzy = -1;
        this.GzA.Rhc.setPath("");
        this.GzA.Rhc.duration = 0;
        AppMethodBeat.o(190709);
    }

    public final long getDurationMs() {
        return this.GzA.endTimeMs - this.GzA.startTimeMs;
    }
}
