package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.List;

public interface BubbleGroup {
    public static final int INVALID_BUBBLE_ID = -1;

    int addBubble(BubbleOptions bubbleOptions);

    void clearBubbleGroup();

    boolean containsBubble(int i2);

    List<Integer> getBubbleIds();

    boolean remove(int i2);

    boolean updateBubble(int i2, BubbleOptions bubbleOptions);
}
