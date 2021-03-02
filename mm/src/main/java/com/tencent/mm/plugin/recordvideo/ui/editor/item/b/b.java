package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TTSInfo;", "", "path", "", "durationMs", "", "(Ljava/lang/String;J)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class b {
    public long durationMs;
    public String path;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        if (r5.durationMs == r6.durationMs) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 237880(0x3a138, float:3.33341E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0020
            boolean r0 = r6 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b
            if (r0 == 0) goto L_0x0025
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b r6 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b) r6
            java.lang.String r0 = r5.path
            java.lang.String r1 = r6.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0025
            long r0 = r5.durationMs
            long r2 = r6.durationMs
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0025
        L_0x0020:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0024:
            return r0
        L_0x0025:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.b.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(237879);
        String str = this.path;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.durationMs;
        int i2 = (hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)));
        AppMethodBeat.o(237879);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(237878);
        String str = "TTSInfo(path=" + this.path + ", durationMs=" + this.durationMs + ")";
        AppMethodBeat.o(237878);
        return str;
    }

    public /* synthetic */ b() {
        this("");
        AppMethodBeat.i(237877);
        AppMethodBeat.o(237877);
    }

    private b(String str) {
        p.h(str, "path");
        AppMethodBeat.i(237876);
        this.path = str;
        this.durationMs = 0;
        AppMethodBeat.o(237876);
    }

    public final void setPath(String str) {
        AppMethodBeat.i(237875);
        p.h(str, "<set-?>");
        this.path = str;
        AppMethodBeat.o(237875);
    }
}
