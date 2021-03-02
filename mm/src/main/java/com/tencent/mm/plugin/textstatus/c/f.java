package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.festival.a.a;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/jump/FestivalJumpSingleton;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "()V", "doJump", "", "textStatusID", "", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class f implements b {
    @Override // com.tencent.mm.plugin.textstatus.c.b
    public final boolean F(String str, List<? extends r> list) {
        AppMethodBeat.i(258380);
        p.h(str, "textStatusID");
        p.h(list, "jumpInfos");
        Iterator<T> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str2 = it.next().GaO;
            if (str2 != null) {
                switch (str2.hashCode()) {
                    case 52:
                        if (str2.equals("4")) {
                            ((a) g.af(a.class)).ba(MMApplicationContext.getContext(), 12);
                            z = true;
                            break;
                        }
                        break;
                }
                z = z;
            }
        }
        AppMethodBeat.o(258380);
        return z;
    }
}
