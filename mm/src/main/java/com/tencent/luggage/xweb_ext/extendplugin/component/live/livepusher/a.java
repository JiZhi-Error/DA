package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001(BE\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\b\u0010%\u001a\u00020\u0007H\u0016J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "leftBlusherPath", "", "leftBlusherPathMd5", "rightBlusherPath", "rightBlusherPathMd5", "faceModel", "", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftBlusherPath", "()Ljava/lang/String;", "getLeftBlusherPathMd5", "getRightBlusherPath", "getRightBlusherPathMd5", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "hashCode", "toString", "BlusherStickType", "luggage-xweb-ext_release"})
public final class a implements h {
    public final float alpha;
    public final EnumC0190a cFX;
    public final String cFY;
    private final String cFZ;
    public final String cGa;
    private final String cGb;
    public final int cGc;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (r3.cGc == r4.cGc) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215916(0x34b6c, float:3.02563E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0050
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
            if (r0 == 0) goto L_0x0055
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a) r4
            float r0 = r3.alpha
            float r1 = r4.alpha
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0055
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a$a r0 = r3.cFX
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a$a r1 = r4.cFX
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cFY
            java.lang.String r1 = r4.cFY
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cFZ
            java.lang.String r1 = r4.cFZ
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cGa
            java.lang.String r1 = r4.cGa
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r3.cGb
            java.lang.String r1 = r4.cGb
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215915);
        int floatToIntBits = Float.floatToIntBits(this.alpha) * 31;
        EnumC0190a aVar = this.cFX;
        int hashCode = ((aVar != null ? aVar.hashCode() : 0) + floatToIntBits) * 31;
        String str = this.cFY;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.cFZ;
        int hashCode3 = ((str2 != null ? str2.hashCode() : 0) + hashCode2) * 31;
        String str3 = this.cGa;
        int hashCode4 = ((str3 != null ? str3.hashCode() : 0) + hashCode3) * 31;
        String str4 = this.cGb;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = ((hashCode4 + i2) * 31) + this.cGc;
        AppMethodBeat.o(215915);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(215914);
        String str = "BlusherStickInfo(alpha=" + this.alpha + ", type=" + this.cFX + ", leftBlusherPath=" + this.cFY + ", leftBlusherPathMd5=" + this.cFZ + ", rightBlusherPath=" + this.cGa + ", rightBlusherPathMd5=" + this.cGb + ", faceModel=" + this.cGc + ")";
        AppMethodBeat.o(215914);
        return str;
    }

    public a(float f2, EnumC0190a aVar, String str, String str2, String str3, String str4, int i2) {
        p.h(aVar, "type");
        p.h(str, "leftBlusherPath");
        p.h(str2, "leftBlusherPathMd5");
        p.h(str3, "rightBlusherPath");
        p.h(str4, "rightBlusherPathMd5");
        AppMethodBeat.i(215913);
        this.alpha = f2;
        this.cFX = aVar;
        this.cFY = str;
        this.cFZ = str2;
        this.cGa = str3;
        this.cGb = str4;
        this.cGc = i2;
        AppMethodBeat.o(215913);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        AppMethodBeat.i(215912);
        String str = "BlusherStickInfo(leftBlusherPath='" + this.cFY + "', leftBlusherPathMd5='" + this.cFZ + "', rightBlusherPath='" + this.cGa + "', rightBlusherPathMd5='" + this.cGb + '\'' + ")";
        AppMethodBeat.o(215912);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "luggage-xweb-ext_release"})
    /* renamed from: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a$a  reason: collision with other inner class name */
    public enum EnumC0190a {
        MATTE;
        
        public final int jsonVal = 0;

        public static EnumC0190a valueOf(String str) {
            AppMethodBeat.i(215911);
            EnumC0190a aVar = (EnumC0190a) Enum.valueOf(EnumC0190a.class, str);
            AppMethodBeat.o(215911);
            return aVar;
        }

        /* JADX WARN: Incorrect types in method signature: (I)V */
        private EnumC0190a(String str) {
        }

        static {
            AppMethodBeat.i(215909);
            AppMethodBeat.o(215909);
        }
    }
}
