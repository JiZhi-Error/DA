package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 15}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/xeffect/effect/BlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setRadius", "", "radius", "", "setSampleFactor", "sampleFactor", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class b extends ad {
    public b(long j2) {
        super(j2);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.BlurEffect;
    }

    public final void setRadius(float f2) {
        AppMethodBeat.i(237050);
        VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.b(s.U(Integer.valueOf(o.BlurRadius.ordinal()), Float.valueOf(f2))));
        AppMethodBeat.o(237050);
    }
}
