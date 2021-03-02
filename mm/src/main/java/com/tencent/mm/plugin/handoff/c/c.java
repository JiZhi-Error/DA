package com.tencent.mm.plugin.handoff.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/handoff/service/BundlePair;", "", "block", "Lkotlin/Function1;", "Landroid/os/Bundle;", "", "(Lkotlin/jvm/functions/Function1;)V", "apply", "bundle", "plugin-handoff_release"})
public final class c {
    final b<Bundle, x> yhT;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.g.a.b<? super android.os.Bundle, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public c(b<? super Bundle, x> bVar) {
        p.h(bVar, "block");
        AppMethodBeat.i(199157);
        this.yhT = bVar;
        AppMethodBeat.o(199157);
    }
}
