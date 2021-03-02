package com.tencent.mm.plugin.forcenotify.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/core/ForceNotifyReport;", "Lcom/tencent/mm/plugin/forcenotify/api/IForceNotifyReport;", "()V", "TAG", "", "_16505", "", "forcePushId", "clickType", "", "clickTime", "", "sessionId", "_16506", "toUsername", "_16507", "noticeState", "receiveTime", "plugin-force-notify_release"})
public final class b implements a {
    public static final b wLO = new b();

    static {
        AppMethodBeat.i(149158);
        AppMethodBeat.o(149158);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.a
    public final void f(String str, String str2, int i2, long j2) {
        int i3;
        AppMethodBeat.i(149154);
        p.h(str2, "sessionId");
        if (str == null) {
            try {
                p.hyc();
            } catch (Exception e2) {
                Log.e("ForceNotifyReport", "[_16505] ".concat(String.valueOf(e2)));
                AppMethodBeat.o(149154);
                return;
            }
        }
        String j3 = n.j(str, "@wxcontact", "", false);
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ca aEx = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().aEx(j3);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[6];
        objArr[0] = j3;
        objArr[1] = Integer.valueOf(i2);
        p.g(aEx, "msgInfo");
        objArr[2] = Long.valueOf(aEx.getCreateTime() / 1000);
        if (aEx.isSystem() || aEx.gDk()) {
            i3 = 0;
        } else {
            i3 = aEx.ajN() == 1 ? 1 : 2;
        }
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = str2;
        objArr[5] = Long.valueOf(j2);
        hVar.a(16505, objArr);
        AppMethodBeat.o(149154);
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.a
    public final void C(String str, int i2, long j2) {
        AppMethodBeat.i(149155);
        d dVar = new d();
        dVar.field_ForcePushId = str;
        if (com.tencent.mm.plugin.forcenotify.d.a.wLU.get(dVar, new String[0])) {
            f(str, String.valueOf(dVar.field_CreateTime / 1000) + dVar.field_UserName, i2, j2);
        }
        AppMethodBeat.o(149155);
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.a
    public final void B(String str, int i2, long j2) {
        AppMethodBeat.i(149156);
        h.INSTANCE.a(16506, str, Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(149156);
    }

    @Override // com.tencent.mm.plugin.forcenotify.a.a
    public final void A(String str, int i2, long j2) {
        AppMethodBeat.i(149157);
        h.INSTANCE.a(16507, str, Integer.valueOf(i2), Long.valueOf(j2));
        AppMethodBeat.o(149157);
    }
}
