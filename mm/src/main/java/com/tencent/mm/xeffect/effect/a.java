package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.ac;
import com.tencent.mm.xeffect.effect.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/xeffect/effect/BlendEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect;", "Lcom/tencent/mm/xeffect/effect/TextureInfoEffect;", "ptr", "", "(J)V", "defaultLayout", "Lcom/tencent/mm/xeffect/effect/LayoutInfoEffect$Default;", "defaultTexture", "Lcom/tencent/mm/xeffect/effect/TextureInfoEffect$Default;", "getLayout", "Lcom/tencent/mm/xeffect/effect/EffectLayoutInfo;", "setLayout", "", "layoutInfo", "setTextureInfo", "textureId", "", "width", "height", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class a extends ad implements ac, p {
    private final p.a RxQ = new p.a(this);
    public final ac.a RxR = new ac.a(this);

    public a(long j2) {
        super(j2);
        AppMethodBeat.i(237049);
        AppMethodBeat.o(237049);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.BlendEffect;
    }

    @Override // com.tencent.mm.xeffect.effect.p
    public final void a(f fVar) {
        AppMethodBeat.i(237048);
        kotlin.g.b.p.h(fVar, "layoutInfo");
        this.RxQ.a(fVar);
        AppMethodBeat.o(237048);
    }
}
