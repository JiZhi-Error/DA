package com.tencent.mm.xeffect.effect;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 15}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/xeffect/effect/FadeEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setAlphaRange", "", "startAlpha", "", "endAlpha", "setFadeBackgroundColor", "color", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class k extends ad {
    public k(long j2) {
        super(j2);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.FadeEffect;
    }

    public final void aE(float f2, float f3) {
        AppMethodBeat.i(237078);
        VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.e(s.U(Integer.valueOf(o.StartAlpha.ordinal()), Float.valueOf(f2)), s.U(Integer.valueOf(o.EndAlpha.ordinal()), Float.valueOf(f3))));
        AppMethodBeat.o(237078);
    }

    public final void aqr(int i2) {
        AppMethodBeat.i(237079);
        VLogEffectJNI.INSTANCE.nSetFadeEffectFadeBackgroundColor(this.ptr, ((float) Color.red(i2)) / 255.0f, ((float) Color.green(i2)) / 255.0f, ((float) Color.blue(i2)) / 255.0f);
        AppMethodBeat.o(237079);
    }
}
