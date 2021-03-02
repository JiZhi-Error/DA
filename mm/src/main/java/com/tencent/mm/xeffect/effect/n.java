package com.tencent.mm.xeffect.effect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "(J)V", "setConfigJson", "", "config", "", "setScene", "scene", "", "setShowFaceLandmarks", "show", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "Scene", "renderlib_release"})
public final class n extends ad {

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect$Scene;", "", "(Ljava/lang/String;I)V", "Pet", "People", "Food", "Plant", "Flower", "Sky", "SunriseSunset", "Snow", "City", "Night", "Room", "Doc", "Origin", "renderlib_release"})
    public enum a {
        Pet,
        People,
        Food,
        Plant,
        Flower,
        Sky,
        SunriseSunset,
        Snow,
        City,
        Night,
        Room,
        Doc,
        Origin;

        static {
            AppMethodBeat.i(237083);
            AppMethodBeat.o(237083);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(237085);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(237085);
            return aVar;
        }
    }

    public n(long j2) {
        super(j2);
    }

    @Override // com.tencent.mm.xeffect.effect.ad
    public final j hiu() {
        return j.ImageEnhanceEffect;
    }

    public final void bpE(String str) {
        AppMethodBeat.i(237086);
        p.h(str, "config");
        VLogEffectJNI.INSTANCE.setConfigJson$renderlib_release(this.ptr, str);
        AppMethodBeat.o(237086);
    }

    public final void setScene(int i2) {
        AppMethodBeat.i(237087);
        VLogEffectJNI.INSTANCE.setScene$renderlib_release(this.ptr, i2);
        AppMethodBeat.o(237087);
    }

    public final void DL(boolean z) {
        AppMethodBeat.i(237088);
        VLogEffectJNI.INSTANCE.setShowLandmarks$renderlib_release(this.ptr, z);
        AppMethodBeat.o(237088);
    }
}
