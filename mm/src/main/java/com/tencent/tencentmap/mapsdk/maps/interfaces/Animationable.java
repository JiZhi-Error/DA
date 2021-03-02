package com.tencent.tencentmap.mapsdk.maps.interfaces;

import com.tencent.tencentmap.mapsdk.maps.model.Animation;

public interface Animationable {
    void setAnimation(Animation animation);

    void startAnimation(Animation animation);

    boolean startAnimation();
}
