package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"checkSlot", "T", "slotId", "", "key", "", "invoke", "(JLjava/lang/String;)Ljava/lang/Object;"})
final class BaseSlotManager$findSlot$1 extends q implements m<Long, String, T> {
    final /* synthetic */ BaseSlotManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSlotManager$findSlot$1(BaseSlotManager baseSlotManager) {
        super(2);
        this.this$0 = baseSlotManager;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.m
    public final /* synthetic */ Object invoke(Long l, String str) {
        AppMethodBeat.i(156368);
        Object invoke = invoke(l.longValue(), str);
        AppMethodBeat.o(156368);
        return invoke;
    }

    public final T invoke(long j2, String str) {
        AppMethodBeat.i(156369);
        p.h(str, "key");
        int access$getToSlot$p = BaseSlotManager.access$getToSlot$p(this.this$0, j2);
        T t = (T) this.this$0.getSlotByKey(BaseSlotManager.access$getKey$p(this.this$0, access$getToSlot$p), j2);
        if (this.this$0.containsKey(t, str)) {
            BaseSlotManager.access$getVerifiedCache$p(this.this$0)[access$getToSlot$p] = -1;
            AppMethodBeat.o(156369);
            return t;
        }
        AppMethodBeat.o(156369);
        return null;
    }
}
