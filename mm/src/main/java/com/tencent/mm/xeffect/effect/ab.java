package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "", "getTextInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "setTextInfo", "", "textInfo", "Default", "renderlib_release"})
public interface ab {
    void a(h hVar);

    @l(hxD = {1, 1, 15}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/TextInfoEffect$Default;", "Lcom/tencent/mm/xeffect/effect/TextInfoEffect;", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "textInfo", "Lcom/tencent/mm/xeffect/effect/EffectTextInfo;", "getTextInfo", "setTextInfo", "", "renderlib_release"})
    public static final class a implements ab {
        private final ad GAn;
        private h RyY = new h(null, null, 31);

        public a(ad adVar) {
            p.h(adVar, "effect");
            AppMethodBeat.i(237118);
            this.GAn = adVar;
            AppMethodBeat.o(237118);
        }

        @Override // com.tencent.mm.xeffect.effect.ab
        public final void a(h hVar) {
            AppMethodBeat.i(237117);
            p.h(hVar, "textInfo");
            this.RyY = hVar;
            VLogEffectJNI.INSTANCE.setEffectText$renderlib_release(this.GAn.ptr, hVar);
            AppMethodBeat.o(237117);
        }
    }
}
