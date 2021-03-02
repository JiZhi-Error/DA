package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/xeffect/effect/StickerEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "setSize", "width", "", "height", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class aa extends ad implements p {
    private final p.a RxQ = new p.a(this);

    public aa(long j2) {
        super(j2);
        AppMethodBeat.i(237116);
        AppMethodBeat.o(237116);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.StickerEffect;
    }

    @Override // com.tencent.mm.xeffect.effect.p
    public final void a(f fVar) {
        AppMethodBeat.i(237114);
        kotlin.g.b.p.h(fVar, "layoutInfo");
        this.RxQ.a(fVar);
        AppMethodBeat.o(237114);
    }

    public final void setSize(int i2, int i3) {
        AppMethodBeat.i(237115);
        VLogEffectJNI.INSTANCE.setStickerSize$renderlib_release(this.ptr, i2, i3);
        AppMethodBeat.o(237115);
    }
}
