package com.tencent.tavkit.composition.model;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public interface TAVCompositionTimeRange {
    CMTime getDuration();

    CMTime getStartTime();

    CMTimeRange getTimeRange();

    void setDuration(CMTime cMTime);

    void setStartTime(CMTime cMTime);
}
