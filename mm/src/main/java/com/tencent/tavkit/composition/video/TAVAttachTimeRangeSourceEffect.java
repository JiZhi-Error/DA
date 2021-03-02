package com.tencent.tavkit.composition.video;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public interface TAVAttachTimeRangeSourceEffect {

    public interface TimeAttachFilter {
        void attachPositionTime(CMTime cMTime);
    }

    void attachTimeRange(CMTimeRange cMTimeRange);
}
