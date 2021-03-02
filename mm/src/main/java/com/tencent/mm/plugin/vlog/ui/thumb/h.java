package com.tencent.mm.plugin.vlog.ui.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.vlog.model.ad;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0006\u0010$\u001a\u00020 R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\n¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", FFmpegMetadataRetriever.METADATA_KEY_TRACK, "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "(Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;)V", "frameWidth", "", "getFrameWidth", "()I", "setFrameWidth", "(I)V", "isDragLeft", "", "()Z", "setDragLeft", "(Z)V", "isDragRight", "setDragRight", "segmentStartTimeMs", "", "getSegmentStartTimeMs", "()J", "setSegmentStartTimeMs", "(J)V", "totalDuration", "getTotalDuration", "getTrack", "()Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackIndex", "getTrackIndex", "setTrackIndex", "cropToPlayRange", "", "start", "end", "isEmpty", "updateFrameInfoForTotalDuration", "Companion", "plugin-vlog_release"})
public final class h extends a {
    private static final ad GQd = new ad("", 0);
    public static final a GQe = new a((byte) 0);
    long GPZ;
    boolean GQa;
    boolean GQb;
    public final ad GQc;
    int kxW = 1;
    public int trackIndex = -1;

    public h(ad adVar) {
        p.h(adVar, FFmpegMetadataRetriever.METADATA_KEY_TRACK);
        AppMethodBeat.i(192162);
        this.GQc = adVar;
        if (this.GQc.GzA.Rhd >= 0) {
            this.GOD = this.GQc.GzA.GGz + (this.GQc.GzA.Rhd - this.GQc.GzA.startTimeMs);
        }
        if (this.GQc.GzA.Rhe >= 0) {
            this.GOE = this.GQc.GzA.GGA + (this.GQc.GzA.Rhe - this.GQc.GzA.endTimeMs);
        }
        AppMethodBeat.o(192162);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(192161);
        if (!p.j(this.GQc, GQd)) {
            if (!(this.GQc.path.length() == 0)) {
                AppMethodBeat.o(192161);
                return false;
            }
        }
        AppMethodBeat.o(192161);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo$Companion;", "", "()V", "MaxFrameThumbInterval", "", "emptyTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "emptyTrackThumb", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "drawWidth", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h fEy() {
            AppMethodBeat.i(192160);
            h hVar = new h(h.GQd);
            hVar.hEp = 0;
            AppMethodBeat.o(192160);
            return hVar;
        }
    }

    static {
        AppMethodBeat.i(192163);
        AppMethodBeat.o(192163);
    }
}
