package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "", "text", "", "fontSize", "", "fontFamily", "italic", "", "bold", "(Ljava/lang/String;FLjava/lang/String;ZZ)V", "getBold", "()Z", "setBold", "(Z)V", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontSize", "()F", "setFontSize", "(F)V", "getItalic", "setItalic", "getText", "setText", "renderlib_release"})
public final class h {
    boolean RxU;
    String fontFamily;
    float fontSize;
    boolean sYW;
    String text;

    public h() {
        this(null, null, 31);
    }

    public h(String str, float f2, String str2, boolean z, boolean z2) {
        p.h(str, "text");
        p.h(str2, "fontFamily");
        AppMethodBeat.i(237073);
        this.text = str;
        this.fontSize = f2;
        this.fontFamily = str2;
        this.RxU = z;
        this.sYW = z2;
        AppMethodBeat.o(237073);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ h(java.lang.String r8, java.lang.String r9, int r10) {
        /*
            r7 = this;
            r6 = 237074(0x39e12, float:3.32211E-40)
            r4 = 0
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0021
            java.lang.String r1 = ""
        L_0x000b:
            r0 = r10 & 4
            if (r0 == 0) goto L_0x001f
            java.lang.String r3 = ""
        L_0x0012:
            r2 = 0
            r0 = r7
            r5 = r4
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x001f:
            r3 = r9
            goto L_0x0012
        L_0x0021:
            r1 = r8
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.xeffect.effect.h.<init>(java.lang.String, java.lang.String, int):void");
    }
}
