package com.tencent.mm.xeffect.effect;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectType;", "", "(Ljava/lang/String;I)V", "PAGTransitionEffect", "PAGStickerEffect", "PAGTextEffect", "PAGVideoTemplateEffect", "PAGGlobalAnimateEffect", "LutFilterEffect", "BrightnessFilterEffect", "ContrastFilterEffect", "SaturationFilterEffect", "HueFilterEffect", "WhiteBalanceFilterEffect", "ImageEnhanceEffect", "GradientBlurEffect", "FadeEffect", "BlurEffect", "StickerEffect", "BlendEffect", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "renderlib_release"})
public enum j {
    PAGTransitionEffect,
    PAGStickerEffect,
    PAGTextEffect,
    PAGVideoTemplateEffect,
    PAGGlobalAnimateEffect,
    LutFilterEffect,
    BrightnessFilterEffect,
    ContrastFilterEffect,
    SaturationFilterEffect,
    HueFilterEffect,
    WhiteBalanceFilterEffect,
    ImageEnhanceEffect,
    GradientBlurEffect,
    FadeEffect,
    BlurEffect,
    StickerEffect,
    BlendEffect,
    Rym;

    static {
        AppMethodBeat.i(237075);
        AppMethodBeat.o(237075);
    }

    public static j valueOf(String str) {
        AppMethodBeat.i(237077);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(237077);
        return jVar;
    }
}
