package com.tencent.tencentmap.mapsdk.maps.model;

public interface IAnimationSet extends Animation {
    boolean addAnimation(Animation animation);

    void cleanAnimation();
}
