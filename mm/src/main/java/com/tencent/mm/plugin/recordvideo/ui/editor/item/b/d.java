package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 '2\u00020\u0001:\u0001'B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000J$\u0010\u0015\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000J\b\u0010\u0019\u001a\u00020\u0013H\u0004J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0003J\u0016\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003J\b\u0010%\u001a\u00020&H\u0016R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "startBase", "", "(JZ)V", "end", "getEnd", "()J", "endPoint", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "getEndPoint", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "start", "getStart", "startPoint", "getStartPoint", "after", "", "target", "align", "alignStart", "alignEnd", "before", "finalize", "isIntersect", LocaleUtil.TURKEY, "pivotEnd", "pivotStart", "setDuration", "setEndOffset", "endOffset", "setOffset", "startOffset", "setStartOffset", "setTime", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class d {
    public static final a Cgz = new a((byte) 0);
    public final c Cgx;
    public final c Cgy;

    static {
        AppMethodBeat.i(237894);
        AppMethodBeat.o(237894);
    }

    public d() {
        this(0, false, 3);
    }

    private d(long j2, boolean z) {
        AppMethodBeat.i(237892);
        this.Cgx = new c((byte) 0);
        this.Cgy = new c((byte) 0);
        if (z) {
            this.Cgy.a(this.Cgx);
            this.Cgy.Il(j2);
            AppMethodBeat.o(237892);
            return;
        }
        this.Cgx.a(this.Cgy);
        this.Cgx.Il(-j2);
        AppMethodBeat.o(237892);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(long j2, boolean z, int i2) {
        this((i2 & 1) != 0 ? 0 : j2, (i2 & 2) != 0 ? true : z);
        AppMethodBeat.i(237893);
        AppMethodBeat.o(237893);
    }

    public final long getStart() {
        AppMethodBeat.i(261700);
        long time = this.Cgx.getTime();
        AppMethodBeat.o(261700);
        return time;
    }

    public final long getEnd() {
        AppMethodBeat.i(261701);
        long time = this.Cgy.getTime();
        AppMethodBeat.o(261701);
        return time;
    }

    public final void ai(long j2, long j3) {
        AppMethodBeat.i(237889);
        c cVar = this.Cgx;
        cVar.Il(cVar.offset + (j2 - this.Cgx.getTime()));
        c cVar2 = this.Cgy;
        cVar2.Il(cVar2.offset + (j3 - this.Cgy.getTime()));
        AppMethodBeat.o(237889);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(237890);
        this.Cgx.a(null);
        this.Cgy.a(null);
        AppMethodBeat.o(237890);
    }

    public final String toString() {
        AppMethodBeat.i(237891);
        String str = "start:" + getStart() + "  end:" + getEnd();
        AppMethodBeat.o(237891);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange$Companion;", "", "()V", "chain", "", "ranges", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimeRange;", "chainWithOffset", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static /* synthetic */ void a(d dVar, d dVar2) {
        c cVar = null;
        AppMethodBeat.i(237888);
        dVar.Cgx.a(dVar2 != null ? dVar2.Cgx : null);
        dVar.Cgx.Il(0);
        c cVar2 = dVar.Cgy;
        if (dVar2 != null) {
            cVar = dVar2.Cgy;
        }
        cVar2.a(cVar);
        dVar.Cgy.Il(0);
        AppMethodBeat.o(237888);
    }
}
