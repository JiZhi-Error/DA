package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.s;

@kotlin.l(hxD = {1, 1, 15}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006 "}, hxF = {"Lcom/tencent/mm/xeffect/effect/GradientBlurEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "value", "", "blurBottom", "getBlurBottom", "()Z", "setBlurBottom", "(Z)V", "", "blurMaskRatio", "getBlurMaskRatio", "()F", "setBlurMaskRatio", "(F)V", "blurTop", "getBlurTop", "setBlurTop", "centerCropBlur", "getCenterCropBlur", "setCenterCropBlur", "contentOffset", "getContentOffset", "setContentOffset", "setRadius", "", "radius", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "renderlib_release"})
public final class l extends ad {
    private boolean Ryo = true;
    private float Ryp = 3.0f;
    private boolean Ryq = true;
    private boolean Ryr = true;

    public l(long j2) {
        super(j2);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.GradientBlurEffect;
    }

    public final void setRadius(float f2) {
        AppMethodBeat.i(237080);
        VLogEffectJNI.INSTANCE.setEffectParams$renderlib_release(this.ptr, ae.b(s.U(Integer.valueOf(o.BlurRadius.ordinal()), Float.valueOf(f2))));
        AppMethodBeat.o(237080);
    }

    public final void hix() {
        AppMethodBeat.i(237081);
        VLogEffectJNI.INSTANCE.nSetGradientBlurEffectCenterCropBlur(this.ptr, false);
        AppMethodBeat.o(237081);
    }

    public final void cM(float f2) {
        AppMethodBeat.i(237082);
        VLogEffectJNI.INSTANCE.nSetGradientBlurEffectContentOffset(this.ptr, f2);
        AppMethodBeat.o(237082);
    }
}
