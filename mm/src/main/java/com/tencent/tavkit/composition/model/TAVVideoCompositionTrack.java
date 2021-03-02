package com.tencent.tavkit.composition.model;

import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavkit.ciimage.CIImage;

public interface TAVVideoCompositionTrack {
    Object getExtraTrackInfo(String str);

    int numberOfVideoTracks();

    void putExtraTrackInfo(String str, Object obj);

    CIImage sourceImageAtTime(CMTime cMTime, CGSize cGSize);

    CompositionTrack videoCompositionTrackForComposition(MutableComposition mutableComposition, int i2, boolean z);
}
