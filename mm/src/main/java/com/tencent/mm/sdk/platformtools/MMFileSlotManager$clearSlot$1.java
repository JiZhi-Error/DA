package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
public final class MMFileSlotManager$clearSlot$1 implements w {
    final /* synthetic */ long $slotId;

    MMFileSlotManager$clearSlot$1(long j2) {
        this.$slotId = j2;
    }

    @Override // com.tencent.mm.vfs.w
    public final boolean accept(o oVar, String str) {
        AppMethodBeat.i(215484);
        p.h(str, "name");
        boolean z = !p.j(str, String.valueOf(this.$slotId));
        AppMethodBeat.o(215484);
        return z;
    }
}
