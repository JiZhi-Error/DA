package com.tencent.mm.live.view.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.o;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006&"}, hxF = {"Lcom/tencent/mm/live/view/adapter/CommentData;", "", "identityId", "", "headImageUrl", "content", "", "msgType", "", "time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;II)V", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "getHeadImageUrl", "()Ljava/lang/String;", "setHeadImageUrl", "(Ljava/lang/String;)V", "getIdentityId", "setIdentityId", "getMsgType", "()I", "setMsgType", "(I)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-logic_release"})
public final class a {
    public String hXp;
    String hXq;
    public CharSequence hXr;
    public int hXs;
    public int msgType;

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r3.hXs == r4.hXs) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 208652(0x32f0c, float:2.92384E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0038
            boolean r0 = r4 instanceof com.tencent.mm.live.view.a.a
            if (r0 == 0) goto L_0x003d
            com.tencent.mm.live.view.a.a r4 = (com.tencent.mm.live.view.a.a) r4
            java.lang.String r0 = r3.hXp
            java.lang.String r1 = r4.hXp
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = r3.hXq
            java.lang.String r1 = r4.hXq
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            java.lang.CharSequence r0 = r3.hXr
            java.lang.CharSequence r1 = r4.hXr
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x003d
            int r0 = r3.msgType
            int r1 = r4.msgType
            if (r0 != r1) goto L_0x003d
            int r0 = r3.hXs
            int r1 = r4.hXs
            if (r0 != r1) goto L_0x003d
        L_0x0038:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x003c:
            return r0
        L_0x003d:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x003c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.view.a.a.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(208651);
        String str = this.hXp;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hXq;
        int hashCode2 = ((str2 != null ? str2.hashCode() : 0) + hashCode) * 31;
        CharSequence charSequence = this.hXr;
        if (charSequence != null) {
            i2 = charSequence.hashCode();
        }
        int i3 = ((((hashCode2 + i2) * 31) + this.msgType) * 31) + this.hXs;
        AppMethodBeat.o(208651);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(208650);
        String str = "CommentData(identityId=" + this.hXp + ", headImageUrl=" + this.hXq + ", content=" + this.hXr + ", msgType=" + this.msgType + ", time=" + this.hXs + ")";
        AppMethodBeat.o(208650);
        return str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private /* synthetic */ a() {
        this("", "", "", o.d.aFy(), 0);
        o.d dVar = o.d.hGL;
        AppMethodBeat.i(208649);
        AppMethodBeat.o(208649);
    }

    public a(String str, String str2, CharSequence charSequence, int i2, int i3) {
        p.h(str, "identityId");
        p.h(str2, "headImageUrl");
        p.h(charSequence, "content");
        AppMethodBeat.i(208648);
        this.hXp = str;
        this.hXq = str2;
        this.hXr = charSequence;
        this.msgType = i2;
        this.hXs = i3;
        AppMethodBeat.o(208648);
    }
}
