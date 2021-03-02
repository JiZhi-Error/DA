package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

/* access modifiers changed from: package-private */
public class AnimationHelperImpl22 implements BackwardSupportUtil.AnimationHelper.IHelper {
    AnimationHelperImpl22() {
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper.IHelper
    @TargetApi(8)
    public void cancelAnimation(View view, Animation animation) {
        AppMethodBeat.i(215284);
        animation.cancel();
        AppMethodBeat.o(215284);
    }
}
