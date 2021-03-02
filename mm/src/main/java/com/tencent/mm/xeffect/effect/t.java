package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "Lcom/tencent/mm/xeffect/effect/PagEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public class t extends r implements p {
    private final p.a RxQ = new p.a(this);

    public t(long j2) {
        super(j2);
        AppMethodBeat.i(237098);
        AppMethodBeat.o(237098);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public j hiu() {
        return j.PAGStickerEffect;
    }

    @Override // com.tencent.mm.xeffect.effect.p
    public final void a(f fVar) {
        AppMethodBeat.i(237097);
        kotlin.g.b.p.h(fVar, "layoutInfo");
        this.RxQ.a(fVar);
        AppMethodBeat.o(237097);
    }
}
