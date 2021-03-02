package com.tencent.mm.plugin.handoff.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0003R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "", "opCode", "", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "seq", "", "(ILjava/util/Collection;J)V", "getItems", "()Ljava/util/Collection;", "setItems", "(Ljava/util/Collection;)V", "getOpCode", "()I", "setOpCode", "(I)V", "getSeq", "()J", "setSeq", "(J)V", "buildXml", "", "deviceId", "networkStatus", "availableCount", "Companion", "api-handoff_release"})
public final class b {
    public static final a yhI = new a((byte) 0);
    public int dJY;
    public long seq;
    public Collection<? extends HandOff> yhH;

    static {
        AppMethodBeat.i(238052);
        AppMethodBeat.o(238052);
    }

    public b() {
        this(0, null, 0, 7);
    }

    private b(int i2, Collection<? extends HandOff> collection, long j2) {
        p.h(collection, "items");
        AppMethodBeat.i(238050);
        this.dJY = i2;
        this.yhH = collection;
        this.seq = j2;
        AppMethodBeat.o(238050);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(int r4, java.util.Collection r5, long r6, int r8) {
        /*
            r3 = this;
            r2 = 238051(0x3a1e3, float:3.3358E-40)
            r0 = r8 & 1
            if (r0 == 0) goto L_0x0008
            r4 = 0
        L_0x0008:
            r0 = r8 & 2
            if (r0 == 0) goto L_0x0022
            kotlin.a.v r0 = kotlin.a.v.SXr
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
        L_0x0012:
            r1 = r8 & 4
            if (r1 == 0) goto L_0x0018
            r6 = -1
        L_0x0018:
            r3.<init>(r4, r0, r6)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        L_0x0022:
            r0 = r5
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.handoff.model.b.<init>(int, java.util.Collection, long, int):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/handoff/model/HandOffList$Companion;", "", "()V", "SEQ_PLACEHOLDER", "", "api-handoff_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final String V(String str, String str2, int i2) {
        AppMethodBeat.i(238049);
        p.h(str, "deviceId");
        p.h(str2, "networkStatus");
        StringBuilder append = new StringBuilder("\n        <handofflist opcode=\"").append(this.dJY).append("\" seq=\"<![CSEQ]>\" deviceid=\"").append(str).append("\" networkstatus=\"");
        String lowerCase = str2.toLowerCase();
        p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        StringBuilder append2 = append.append(lowerCase).append("\" availablecount=\"").append(i2).append("\">\n        ");
        String str3 = "";
        Iterator<T> it = this.yhH.iterator();
        while (it.hasNext()) {
            str3 = str3 + it.next().build();
        }
        String sb = append2.append(str3).append("\n        </handofflist>\n        ").toString();
        if (sb == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(238049);
            throw tVar;
        }
        String obj = n.trim(sb).toString();
        AppMethodBeat.o(238049);
        return obj;
    }
}
