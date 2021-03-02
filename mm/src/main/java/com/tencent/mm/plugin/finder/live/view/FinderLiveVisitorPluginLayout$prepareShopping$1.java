package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.live.j;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$prepareShopping$1 extends q implements b<Boolean, x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$prepareShopping$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(1);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Boolean bool) {
        AppMethodBeat.i(247622);
        invoke(bool.booleanValue());
        x xVar = x.SXb;
        AppMethodBeat.o(247622);
        return xVar;
    }

    public final void invoke(boolean z) {
        Boolean bool;
        AppMethodBeat.i(247623);
        String str = this.this$0.TAG;
        StringBuilder append = new StringBuilder("prepare shopping:").append(z).append(",list empty:");
        LinkedList<bo> linkedList = this.this$0.getLiveData().LGy;
        if (linkedList != null) {
            LinkedList<bo> linkedList2 = linkedList;
            bool = Boolean.valueOf(linkedList2 == null || linkedList2.isEmpty());
        } else {
            bool = null;
        }
        Log.i(str, append.append(bool).toString());
        if (z) {
            y yVar = y.vXH;
            g c2 = y.c(this.this$0.getLiveData().uEl);
            h hVar = h.ufY;
            h.a(this.this$0.getLiveData(), c2);
            j jVar = j.ugg;
            j.b(this.this$0.getLiveData(), c2);
        }
        AppMethodBeat.o(247623);
    }
}
