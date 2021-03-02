package com.tencent.mm.plugin.festival.finder;

import android.animation.IntEvaluator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ%\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0018RL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/BulletFlyEvalutor;", "Landroid/animation/IntEvaluator;", "flyDuration", "", "stayDuration", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "fraction", "", "flying", "", "(IILkotlin/jvm/functions/Function2;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "setCallback", "(Lkotlin/jvm/functions/Function2;)V", "flyAcceFactor", "flyFraction", "evaluate", "startValue", "endValue", "(FII)Ljava/lang/Integer;", "plugin-festival_release"})
public final class b extends IntEvaluator {
    private m<? super Float, ? super Boolean, x> gWp;
    private final int ulT;
    private final float ulU;

    private b(int i2, int i3) {
        AppMethodBeat.i(261998);
        this.gWp = null;
        this.ulT = (i3 + i2) / i2;
        this.ulU = 1.0f / ((float) this.ulT);
        AppMethodBeat.o(261998);
    }

    public /* synthetic */ b(int i2, int i3, byte b2) {
        this(i2, i3);
    }

    @Override // android.animation.IntEvaluator
    public final /* synthetic */ Integer evaluate(float f2, Integer num, Integer num2) {
        AppMethodBeat.i(261997);
        Integer c2 = c(f2, num.intValue(), num2.intValue());
        AppMethodBeat.o(261997);
        return c2;
    }

    @Override // android.animation.TypeEvaluator, android.animation.IntEvaluator
    public final /* synthetic */ Object evaluate(float f2, Object obj, Object obj2) {
        AppMethodBeat.i(261996);
        Integer c2 = c(f2, ((Number) obj).intValue(), ((Number) obj2).intValue());
        AppMethodBeat.o(261996);
        return c2;
    }

    private Integer c(float f2, int i2, int i3) {
        AppMethodBeat.i(261995);
        if (f2 < this.ulU) {
            m<? super Float, ? super Boolean, x> mVar = this.gWp;
            if (mVar != null) {
                mVar.invoke(Float.valueOf(f2), Boolean.TRUE);
            }
            i3 = (int) (((float) i2) + (((float) (i3 - i2)) * f2 * ((float) this.ulT)));
        } else {
            m<? super Float, ? super Boolean, x> mVar2 = this.gWp;
            if (mVar2 != null) {
                mVar2.invoke(Float.valueOf(f2), Boolean.FALSE);
            }
        }
        Integer valueOf = Integer.valueOf(i3);
        AppMethodBeat.o(261995);
        return valueOf;
    }
}
