package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener;", "", "()V", "Companion", "plugin-expt_release"})
public final class a {
    public static final C1011a sCB = new C1011a((byte) 0);

    static {
        AppMethodBeat.i(220809);
        AppMethodBeat.o(220809);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/FinderBizListener$Companion;", "", "()V", "TAG", "", "callback", "", "pageName", "hashCode", "", "eventId", "(Ljava/lang/String;Ljava/lang/Integer;I)V", "plugin-expt_release"})
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.a.b.a$a  reason: collision with other inner class name */
    public static final class C1011a {
        private C1011a() {
        }

        public /* synthetic */ C1011a(byte b2) {
            this();
        }
    }

    public static final void a(String str, Integer num, int i2) {
        boolean z;
        AppMethodBeat.i(220810);
        if (str == null) {
            AppMethodBeat.o(220810);
        } else if (num != null) {
            num.intValue();
            c.a aVar = c.sFa;
            if (p.j("com.tencent.mm.plugin.finder.ui.FinderHomeUI", str) || p.j("com.tencent.mm.plugin.finder.ui.FinderConversationUI", str) || p.j("FinderHomeUI", str) || p.j("FinderConversationUI", str)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (i2 == 1 || i2 == 0) {
                    AppMethodBeat.o(220810);
                    return;
                } else if (i2 == 3 || i2 == 2) {
                    b.a aVar2 = b.sIy;
                    if (!p.j(b.a.cPQ(), "143")) {
                        AppMethodBeat.o(220810);
                        return;
                    }
                } else {
                    AppMethodBeat.o(220810);
                    return;
                }
            }
            hr hrVar = new hr();
            hrVar.dMk.eventId = i2;
            hrVar.dMk.dMl = str;
            hrVar.dMk.aHK = num.intValue();
            EventCenter.instance.publish(hrVar);
            AppMethodBeat.o(220810);
        } else {
            AppMethodBeat.o(220810);
        }
    }
}
