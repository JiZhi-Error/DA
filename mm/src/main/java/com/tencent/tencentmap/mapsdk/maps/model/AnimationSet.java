package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class AnimationSet extends BaseAnimation {
    public List<Animation> mAnimations = new ArrayList();
    public boolean mShareInterpolator;

    public AnimationSet(boolean z) {
        AppMethodBeat.i(173077);
        this.mShareInterpolator = z;
        AppMethodBeat.o(173077);
    }

    public boolean addAnimation(Animation animation) {
        AppMethodBeat.i(173080);
        this.mAnimations.add(animation);
        AppMethodBeat.o(173080);
        return true;
    }

    public void cleanAnimation() {
        AppMethodBeat.i(173081);
        this.mAnimations.clear();
        AppMethodBeat.o(173081);
    }
}
