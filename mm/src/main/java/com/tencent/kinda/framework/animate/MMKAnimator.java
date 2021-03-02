package com.tencent.kinda.framework.animate;

import com.tencent.kinda.gen.KindaAnimator;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKAnimator implements KindaAnimator {
    @Override // com.tencent.kinda.gen.KindaAnimator
    public void startAnimationImpl(float f2, final VoidCallback voidCallback) {
        AppMethodBeat.i(18340);
        KindaGlobalAnimator.startAnimate((long) (1000.0f * f2), new Runnable() {
            /* class com.tencent.kinda.framework.animate.MMKAnimator.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18337);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AppMethodBeat.o(18337);
            }
        });
        AppMethodBeat.o(18340);
    }

    @Override // com.tencent.kinda.gen.KindaAnimator
    public void startAnimationImpl(float f2, final VoidCallback voidCallback, final VoidCallback voidCallback2) {
        AppMethodBeat.i(18341);
        KindaGlobalAnimator.startAnimate((long) (1000.0f * f2), new Runnable() {
            /* class com.tencent.kinda.framework.animate.MMKAnimator.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(18338);
                if (voidCallback != null) {
                    voidCallback.call();
                }
                AppMethodBeat.o(18338);
            }
        }, new Runnable() {
            /* class com.tencent.kinda.framework.animate.MMKAnimator.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(18339);
                if (voidCallback2 != null) {
                    voidCallback2.call();
                }
                AppMethodBeat.o(18339);
            }
        });
        AppMethodBeat.o(18341);
    }
}
