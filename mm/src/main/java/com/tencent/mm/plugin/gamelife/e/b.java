package com.tencent.mm.plugin.gamelife.e;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/gamelife/conversation/GameLifeConversationInfo;", "", "talker", "", "msgId", "", "externInfo", "msgType", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getExternInfo", "()Ljava/lang/String;", "setExternInfo", "(Ljava/lang/String;)V", "getMsgId", "()J", "setMsgId", "(J)V", "getMsgType", "()I", "setMsgType", "(I)V", "getTalker", "setTalker", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-gamelife_release"})
public final class b {
    public long msgId;
    public int msgType;
    public String talker;
    public String xEl;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r5.msgType == r6.msgType) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 241344(0x3aec0, float:3.38195E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            if (r5 == r6) goto L_0x0030
            boolean r0 = r6 instanceof com.tencent.mm.plugin.gamelife.e.b
            if (r0 == 0) goto L_0x0035
            com.tencent.mm.plugin.gamelife.e.b r6 = (com.tencent.mm.plugin.gamelife.e.b) r6
            java.lang.String r0 = r5.talker
            java.lang.String r1 = r6.talker
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0035
            long r0 = r5.msgId
            long r2 = r6.msgId
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0035
            java.lang.String r0 = r5.xEl
            java.lang.String r1 = r6.xEl
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0035
            int r0 = r5.msgType
            int r1 = r6.msgType
            if (r0 != r1) goto L_0x0035
        L_0x0030:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x0034:
            return r0
        L_0x0035:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gamelife.e.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(241343);
        String str = this.talker;
        int hashCode = str != null ? str.hashCode() : 0;
        long j2 = this.msgId;
        int i3 = ((hashCode * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        String str2 = this.xEl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i4 = ((i3 + i2) * 31) + this.msgType;
        AppMethodBeat.o(241343);
        return i4;
    }

    public final String toString() {
        AppMethodBeat.i(241342);
        String str = "GameLifeConversationInfo(talker=" + this.talker + ", msgId=" + this.msgId + ", externInfo=" + this.xEl + ", msgType=" + this.msgType + ")";
        AppMethodBeat.o(241342);
        return str;
    }

    public b(String str, long j2, String str2, int i2) {
        this.talker = str;
        this.msgId = j2;
        this.xEl = str2;
        this.msgType = i2;
    }

    private /* synthetic */ b() {
        this("", 0, "", 0);
        AppMethodBeat.i(241341);
        AppMethodBeat.o(241341);
    }
}
