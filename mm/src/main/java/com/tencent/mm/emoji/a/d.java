package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "", "()V", "holderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "Lkotlin/collections/ArrayList;", "getHolderList", "()Ljava/util/ArrayList;", "createHolder", "msgId", "", "recyclerHolder", "", "holder", "plugin-emojisdk_release"})
public final class d {
    public final ArrayList<c> gVo = new ArrayList<>();

    public d() {
        AppMethodBeat.i(199885);
        AppMethodBeat.o(199885);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(199884);
        p.h(cVar, "holder");
        this.gVo.remove(cVar);
        AppMethodBeat.o(199884);
    }
}
