package com.tencent.mm.sdk.platformtools;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

/* access modifiers changed from: package-private */
public class AnimationHelperImpl21below implements BackwardSupportUtil.AnimationHelper.IHelper {
    AnimationHelperImpl21below() {
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper.IHelper
    public void cancelAnimation(View view, Animation animation) {
        AppMethodBeat.i(215283);
        if (view != null) {
            view.setAnimation(null);
        }
        AppMethodBeat.o(215283);
    }
}
