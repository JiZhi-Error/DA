package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0003%&'B3\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\b\u0010!\u001a\u00020\"H\u0016J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "color", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "faceModel", "", "mouthShape", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;)V", "getAlpha", "()F", "getColor", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "getFaceModel", "()I", "getMouthShape", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getIdentityDesc", "", "hashCode", "toString", "Color", "LipStickType", "MouthShape", "luggage-xweb-ext_release"})
public final class n implements h {
    public final float alpha;
    public final a cGU;
    public final b cGV;
    public final c cGW;
    public final int cGc;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (kotlin.g.b.p.j(r3.cGW, r4.cGW) != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 215965(0x34b9d, float:3.02631E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x003c
            boolean r0 = r4 instanceof com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n
            if (r0 == 0) goto L_0x0041
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n r4 = (com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n) r4
            float r0 = r3.alpha
            float r1 = r4.alpha
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 != 0) goto L_0x0041
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$a r0 = r3.cGU
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$a r1 = r4.cGU
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$b r0 = r3.cGV
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$b r1 = r4.cGV
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
            int r0 = r3.cGc
            int r1 = r4.cGc
            if (r0 != r1) goto L_0x0041
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$c r0 = r3.cGW
            com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n$c r1 = r4.cGW
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0041
        L_0x003c:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0040:
            return r0
        L_0x0041:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0040
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(215964);
        int floatToIntBits = Float.floatToIntBits(this.alpha) * 31;
        a aVar = this.cGU;
        int hashCode = ((aVar != null ? aVar.hashCode() : 0) + floatToIntBits) * 31;
        b bVar = this.cGV;
        int hashCode2 = ((((bVar != null ? bVar.hashCode() : 0) + hashCode) * 31) + this.cGc) * 31;
        c cVar = this.cGW;
        if (cVar != null) {
            i2 = cVar.hashCode();
        }
        int i3 = hashCode2 + i2;
        AppMethodBeat.o(215964);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(215963);
        String str = "LipStickInfo(alpha=" + this.alpha + ", color=" + this.cGU + ", type=" + this.cGV + ", faceModel=" + this.cGc + ", mouthShape=" + this.cGW + ")";
        AppMethodBeat.o(215963);
        return str;
    }

    public n(float f2, a aVar, b bVar, int i2, c cVar) {
        p.h(aVar, "color");
        p.h(bVar, "type");
        p.h(cVar, "mouthShape");
        AppMethodBeat.i(215962);
        this.alpha = f2;
        this.cGU = aVar;
        this.cGV = bVar;
        this.cGc = i2;
        this.cGW = cVar;
        AppMethodBeat.o(215962);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.h
    public final String Qc() {
        return "LipStickInfo()";
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "", "colorR", "", "colorG", "colorB", "(III)V", "getColorB", "()I", "getColorG", "getColorR", "component1", "component2", "component3", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "luggage-xweb-ext_release"})
    public static final class a {
        public final int cGX;
        public final int cGY;
        public final int cGZ;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.cGX == aVar.cGX && this.cGY == aVar.cGY && this.cGZ == aVar.cGZ)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.cGX * 31) + this.cGY) * 31) + this.cGZ;
        }

        public final String toString() {
            AppMethodBeat.i(215954);
            String str = "Color(colorR=" + this.cGX + ", colorG=" + this.cGY + ", colorB=" + this.cGZ + ")";
            AppMethodBeat.o(215954);
            return str;
        }

        public a(int i2, int i3, int i4) {
            this.cGX = i2;
            this.cGY = i3;
            this.cGZ = i4;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "SATIN", "MOIST", "HIGH_LIGHT", "PEARL", "METALLIC_LIGHT", "NEON_LIGHT", "Companion", "luggage-xweb-ext_release"})
    public enum b {
        MATTE(0),
        SATIN(1),
        MOIST(2),
        HIGH_LIGHT(3),
        PEARL(4),
        METALLIC_LIGHT(5),
        NEON_LIGHT(6);
        
        public static final a cHi = new a((byte) 0);
        public final int jsonVal;

        public static b valueOf(String str) {
            AppMethodBeat.i(215957);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(215957);
            return bVar;
        }

        private b(int i2) {
            this.jsonVal = i2;
        }

        static {
            AppMethodBeat.i(215955);
            AppMethodBeat.o(215955);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "typeInt", "", "luggage-xweb-ext_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static final b hZ(int i2) {
            AppMethodBeat.i(215958);
            b[] values = values();
            for (b bVar : values) {
                if (i2 == bVar.jsonVal) {
                    AppMethodBeat.o(215958);
                    return bVar;
                }
            }
            AppMethodBeat.o(215958);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "STANDARD", "luggage-xweb-ext_release"})
    public enum c {
        STANDARD;
        
        public final int jsonVal = 0;

        public static c valueOf(String str) {
            AppMethodBeat.i(215961);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(215961);
            return cVar;
        }

        /* JADX WARN: Incorrect types in method signature: (I)V */
        private c(String str) {
        }

        static {
            AppMethodBeat.i(215959);
            AppMethodBeat.o(215959);
        }
    }
}
