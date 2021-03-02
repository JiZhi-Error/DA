package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\b\u0010 \u001a\u00020\u0005H\u0016J\t\u0010!\u001a\u00020\nHÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006#"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftEyeBrowPath", "", "leftEyeBrowPathMd5", "rightEyeBrowPath", "rightEyeBrowPathMd5", "faceModel", "", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftEyeBrowPath", "()Ljava/lang/String;", "getLeftEyeBrowPathMd5", "getRightEyeBrowPath", "getRightEyeBrowPathMd5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "hashCode", "toString", "luggage-xweb-ext_release"})
public final class b implements h {
    public final float alpha;
    public final int cGc;
    public final String cGf;
    private final String cGg;
    public final String cGh;
    private final String cGi;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r3.cGc == r4.cGc) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215921(0x34b71, float:3.0257E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0046
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b
            if (r0 == 0) goto L_0x004b
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b) r4
            float r0 = r3.alpha
            float r1 = r4.alpha
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x004b
            java.lang.String r0 = r3.cGf
            java.lang.String r1 = r4.cGf
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = r3.cGg
            java.lang.String r1 = r4.cGg
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = r3.cGh
            java.lang.String r1 = r4.cGh
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = r3.cGi
            java.lang.String r1 = r4.cGi
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x004b
            int r0 = r3.cGc
            int r1 = r4.cGc
            if (r0 != r1) goto L_0x004b
        L_0x0046:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x004a:
            return r0
        L_0x004b:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x004a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215920);
        int floatToIntBits = Float.floatToIntBits(this.alpha) * 31;
        String str = this.cGf;
        int hashCode = ((str != null ? str.hashCode() : 0) + floatToIntBits) * 31;
        String str2 = this.cGg;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.cGh;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.cGi;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = ((hashCode3 + i2) * 31) + this.cGc;
        AppMethodBeat.o(215920);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(215919);
        String str = "EyeBrowInfo(alpha=" + this.alpha + ", leftEyeBrowPath=" + this.cGf + ", leftEyeBrowPathMd5=" + this.cGg + ", rightEyeBrowPath=" + this.cGh + ", rightEyeBrowPathMd5=" + this.cGi + ", faceModel=" + this.cGc + ")";
        AppMethodBeat.o(215919);
        return str;
    }

    public b(float f2, String str, String str2, String str3, String str4, int i2) {
        p.h(str, "leftEyeBrowPath");
        p.h(str2, "leftEyeBrowPathMd5");
        p.h(str3, "rightEyeBrowPath");
        p.h(str4, "rightEyeBrowPathMd5");
        AppMethodBeat.i(215918);
        this.alpha = f2;
        this.cGf = str;
        this.cGg = str2;
        this.cGh = str3;
        this.cGi = str4;
        this.cGc = i2;
        AppMethodBeat.o(215918);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        AppMethodBeat.i(215917);
        String str = "EyeBrowInfo(leftEyeBrowPath='" + this.cGf + "', leftEyeBrowPathMd5='" + this.cGg + "', rightEyeBrowPath='" + this.cGh + "', rightEyeBrowPathMd5='" + this.cGi + '\'' + ")";
        AppMethodBeat.o(215917);
        return str;
    }
}
