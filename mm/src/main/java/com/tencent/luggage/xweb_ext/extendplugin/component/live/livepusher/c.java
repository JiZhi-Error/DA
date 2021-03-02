package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001)BM\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003JS\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\b\u0010%\u001a\u00020\u0005H\u0016J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "leftMaskPath", "", "leftMaskPathMd5", "rightMaskPath", "rightMaskPathMd5", "shimmerPosPath", "shimmerPosPathMd5", "(FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()F", "getLeftMaskPath", "()Ljava/lang/String;", "getLeftMaskPathMd5", "getRightMaskPath", "getRightMaskPathMd5", "getShimmerPosPath", "getShimmerPosPathMd5", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "hashCode", "", "toString", "EyeShadowType", "luggage-xweb-ext_release"})
public final class c implements h {
    public final float alpha;
    private final a cGj;
    public final String cGk;
    private final String cGl;
    public final String cGm;
    private final String cGn;
    public final String cGo;
    private final String cGp;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (kotlin.g.b.p.j(r3.cGp, r4.cGp) != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215929(0x34b79, float:3.02581E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0054
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c
            if (r0 == 0) goto L_0x0059
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c) r4
            float r0 = r3.alpha
            float r1 = r4.alpha
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0059
            java.lang.String r0 = r3.cGk
            java.lang.String r1 = r4.cGk
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r3.cGl
            java.lang.String r1 = r4.cGl
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r3.cGm
            java.lang.String r1 = r4.cGm
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r3.cGn
            java.lang.String r1 = r4.cGn
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r3.cGo
            java.lang.String r1 = r4.cGo
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
            java.lang.String r0 = r3.cGp
            java.lang.String r1 = r4.cGp
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0059
        L_0x0054:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0058:
            return r0
        L_0x0059:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215928);
        int floatToIntBits = Float.floatToIntBits(this.alpha) * 31;
        String str = this.cGk;
        int hashCode = ((str != null ? str.hashCode() : 0) + floatToIntBits) * 31;
        String str2 = this.cGl;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        String str3 = this.cGm;
        int hashCode3 = ((str3 != null ? str3.hashCode() : 0) + hashCode2) * 31;
        String str4 = this.cGn;
        int hashCode4 = ((str4 != null ? str4.hashCode() : 0) + hashCode3) * 31;
        String str5 = this.cGo;
        int hashCode5 = ((str5 != null ? str5.hashCode() : 0) + hashCode4) * 31;
        String str6 = this.cGp;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode5 + i2;
        AppMethodBeat.o(215928);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(215927);
        String str = "EyeShadowInfo(alpha=" + this.alpha + ", leftMaskPath=" + this.cGk + ", leftMaskPathMd5=" + this.cGl + ", rightMaskPath=" + this.cGm + ", rightMaskPathMd5=" + this.cGn + ", shimmerPosPath=" + this.cGo + ", shimmerPosPathMd5=" + this.cGp + ")";
        AppMethodBeat.o(215927);
        return str;
    }

    public c(float f2, String str, String str2, String str3, String str4, String str5, String str6) {
        a aVar;
        p.h(str, "leftMaskPath");
        p.h(str2, "leftMaskPathMd5");
        p.h(str3, "rightMaskPath");
        p.h(str4, "rightMaskPathMd5");
        AppMethodBeat.i(215926);
        this.alpha = f2;
        this.cGk = str;
        this.cGl = str2;
        this.cGm = str3;
        this.cGn = str4;
        this.cGo = str5;
        this.cGp = str6;
        String str7 = this.cGo;
        if (str7 == null || str7.length() == 0) {
            aVar = a.MATTE;
        } else {
            aVar = a.FINE_FLASH;
        }
        this.cGj = aVar;
        AppMethodBeat.o(215926);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        AppMethodBeat.i(215925);
        String str = "EyeShadowInfo(leftMaskPath='" + this.cGk + "', leftMaskPathMd5='" + this.cGl + "', rightMaskPath='" + this.cGm + "', rightMaskPathMd5='" + this.cGn + "', shimmerPosPath=" + this.cGo + ", shimmerPosPathMd5='" + this.cGp + '\'' + ")";
        AppMethodBeat.o(215925);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo$EyeShadowType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "FINE_FLASH", "luggage-xweb-ext_release"})
    public enum a {
        MATTE(0),
        FINE_FLASH(1);
        
        private final int jsonVal;

        public static a valueOf(String str) {
            AppMethodBeat.i(215924);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(215924);
            return aVar;
        }

        private a(int i2) {
            this.jsonVal = i2;
        }

        static {
            AppMethodBeat.i(215922);
            AppMethodBeat.o(215922);
        }
    }
}
