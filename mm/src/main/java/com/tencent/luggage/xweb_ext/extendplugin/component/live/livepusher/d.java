package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\b\u0010#\u001a\u00020\u0006H\u0016J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006&"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "highLightAlpha", "", "shadowAlpha", "highLightContourPath", "", "highLightContourPathMd5", "shadowContourPath", "shadowContourPathMd5", "faceModel", "", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getFaceModel", "()I", "getHighLightAlpha", "()F", "getHighLightContourPath", "()Ljava/lang/String;", "getHighLightContourPathMd5", "getShadowAlpha", "getShadowContourPath", "getShadowContourPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class d implements h {
    public final int cGc;
    public final float cGt;
    public final float cGu;
    public final String cGv;
    private final String cGw;
    public final String cGx;
    private final String cGy;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r3.cGc == r4.cGc) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215934(0x34b7e, float:3.02588E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0050
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d
            if (r0 == 0) goto L_0x0055
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d) r4
            float r0 = r3.cGt
            float r1 = r4.cGt
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0055
            float r0 = r3.cGu
            float r1 = r4.cGu
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0055
            java.lang.String r0 = r3.cGv
            java.lang.String r1 = r4.cGv
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cGw
            java.lang.String r1 = r4.cGw
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cGx
            java.lang.String r1 = r4.cGx
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cGy
            java.lang.String r1 = r4.cGy
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            int r0 = r3.cGc
            int r1 = r4.cGc
            if (r0 != r1) goto L_0x0055
        L_0x0050:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0054:
            return r0
        L_0x0055:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215933);
        int floatToIntBits = ((Float.floatToIntBits(this.cGt) * 31) + Float.floatToIntBits(this.cGu)) * 31;
        String str = this.cGv;
        int hashCode = ((str != null ? str.hashCode() : 0) + floatToIntBits) * 31;
        String str2 = this.cGw;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.cGx;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.cGy;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = ((hashCode3 + i2) * 31) + this.cGc;
        AppMethodBeat.o(215933);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(215932);
        String str = "FaceContourInfo(highLightAlpha=" + this.cGt + ", shadowAlpha=" + this.cGu + ", highLightContourPath=" + this.cGv + ", highLightContourPathMd5=" + this.cGw + ", shadowContourPath=" + this.cGx + ", shadowContourPathMd5=" + this.cGy + ", faceModel=" + this.cGc + ")";
        AppMethodBeat.o(215932);
        return str;
    }

    public d(float f2, float f3, String str, String str2, String str3, String str4, int i2) {
        p.h(str, "highLightContourPath");
        p.h(str2, "highLightContourPathMd5");
        p.h(str3, "shadowContourPath");
        p.h(str4, "shadowContourPathMd5");
        AppMethodBeat.i(215931);
        this.cGt = f2;
        this.cGu = f3;
        this.cGv = str;
        this.cGw = str2;
        this.cGx = str3;
        this.cGy = str4;
        this.cGc = i2;
        AppMethodBeat.o(215931);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        AppMethodBeat.i(215930);
        String str = "FaceContourInfo(highLightContourPath='" + this.cGv + "', highLightContourPathMd5='" + this.cGw + "', shadowContourPath='" + this.cGx + "', shadowContourPathMd5='" + this.cGy + '\'' + ")";
        AppMethodBeat.o(215930);
        return str;
    }
}
