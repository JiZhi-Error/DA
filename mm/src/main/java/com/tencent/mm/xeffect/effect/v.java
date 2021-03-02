package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.ab;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/PagTextEffect;", "Lcom/tencent/mm/xeffect/effect/PagStickerEffect;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "ptr", "", "(J)V", "defaultText", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "getTextInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setTextInfo", "", "textInfo", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class v extends t implements ab {
    private final ab.a RyX = new ab.a(this);

    public v(long j2) {
        super(j2);
        AppMethodBeat.i(237100);
        AppMethodBeat.o(237100);
    }

    @Override // com.tencent.mm.xeffect.effect.t, com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.PAGTextEffect;
    }

    @Override // com.tencent.mm.xeffect.effect.ab
    public final void a(h hVar) {
        AppMethodBeat.i(237099);
        p.h(hVar, "textInfo");
        this.RyX.a(hVar);
        AppMethodBeat.o(237099);
    }
}
