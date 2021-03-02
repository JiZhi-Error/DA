package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.xeffect.effect.ad;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012¨\u0006#"}, hxF = {"Lcom/tencent/mm/videocomposition/TrackTransition;", "", "path", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "(Ljava/lang/String;Lcom/tencent/mm/xeffect/effect/VLogEffect;J)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "endTime", "getEndTime", "setEndTime", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "value", "startTime", "getStartTime", "setStartTime", "isValid", "video_composition_release"})
public final class k {
    public ad GAn;
    public boolean bGB;
    public long duration;
    public long endTime;
    public String path;
    public long startTime;

    public /* synthetic */ k() {
        this("", null, 1000);
        AppMethodBeat.i(216762);
        AppMethodBeat.o(216762);
    }

    public k(String str, ad adVar, long j2) {
        p.h(str, "path");
        AppMethodBeat.i(216761);
        this.path = str;
        this.GAn = adVar;
        this.duration = j2;
        AppMethodBeat.o(216761);
    }

    public final void setPath(String str) {
        AppMethodBeat.i(216760);
        p.h(str, "<set-?>");
        this.path = str;
        AppMethodBeat.o(216760);
    }

    public final boolean isValid() {
        AppMethodBeat.i(216759);
        if (this.path.length() > 0) {
            AppMethodBeat.o(216759);
            return true;
        }
        AppMethodBeat.o(216759);
        return false;
    }
}
