package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/EditRenderScript;", "", "path", "", "startMs", "", "endMS", "playRate", "", "(Ljava/lang/String;JJF)V", "getEndMS", "()J", "setEndMS", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getPlayRate", "()F", "setPlayRate", "(F)V", "getStartMs", "setStartMs", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-recordvideo_release"})
public final class a {
    public long Cgu;
    public long eiq;
    public float mwH;
    public String path;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (java.lang.Float.compare(r5.mwH, r6.mwH) == 0) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 237874(0x3a132, float:3.33332E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0032
            boolean r0 = r6 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a
            if (r0 == 0) goto L_0x0037
            com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a r6 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a) r6
            java.lang.String r0 = r5.path
            java.lang.String r1 = r6.path
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0037
            long r0 = r5.eiq
            long r2 = r6.eiq
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0037
            long r0 = r5.Cgu
            long r2 = r6.Cgu
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0037
            float r0 = r5.mwH
            float r1 = r6.mwH
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0037
        L_0x0032:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0036:
            return r0
        L_0x0037:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.ui.editor.item.b.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(237873);
        String str = this.path;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.eiq;
        long j3 = this.Cgu;
        int floatToIntBits = (((((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Float.floatToIntBits(this.mwH);
        AppMethodBeat.o(237873);
        return floatToIntBits;
    }

    public final String toString() {
        AppMethodBeat.i(237872);
        String str = "EditRenderScript(path=" + this.path + ", startMs=" + this.eiq + ", endMS=" + this.Cgu + ", playRate=" + this.mwH + ")";
        AppMethodBeat.o(237872);
        return str;
    }

    public a(String str, long j2, long j3, float f2) {
        p.h(str, "path");
        AppMethodBeat.i(237871);
        this.path = str;
        this.eiq = j2;
        this.Cgu = j3;
        this.mwH = f2;
        AppMethodBeat.o(237871);
    }
}
