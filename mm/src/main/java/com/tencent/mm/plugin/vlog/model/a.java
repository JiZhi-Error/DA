package com.tencent.mm.plugin.vlog.model;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.Arrays;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/ABAResult;", "", "errCode", "", "width", "height", FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, "abaParams", "", "(IIII[I)V", "getAbaParams", "()[I", "getBitrate", "()I", "getErrCode", "getHeight", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-vlog_release"})
public final class a {
    final int bitrate;
    final int errCode;
    final int height;
    final int[] vRR;
    final int width;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (kotlin.g.b.p.j(r3.vRR, r4.vRR) != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 190475(0x2e80b, float:2.66912E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0030
            boolean r0 = r4 instanceof com.tencent.mm.plugin.vlog.model.a
            if (r0 == 0) goto L_0x0035
            com.tencent.mm.plugin.vlog.model.a r4 = (com.tencent.mm.plugin.vlog.model.a) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.vlog.model.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(190474);
        int i2 = ((((((this.errCode * 31) + this.width) * 31) + this.height) * 31) + this.bitrate) * 31;
        int[] iArr = this.vRR;
        int hashCode = (iArr != null ? Arrays.hashCode(iArr) : 0) + i2;
        AppMethodBeat.o(190474);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(190473);
        String str = "ABAResult(errCode=" + this.errCode + ", width=" + this.width + ", height=" + this.height + ", bitrate=" + this.bitrate + ", abaParams=" + Arrays.toString(this.vRR) + ")";
        AppMethodBeat.o(190473);
        return str;
    }

    public a(int i2, int i3, int i4, int i5, int[] iArr) {
        this.errCode = i2;
        this.width = i3;
        this.height = i4;
        this.bitrate = i5;
        this.vRR = iArr;
    }
}
