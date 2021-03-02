package com.tencent.tav.core.composition;

import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;

public interface VideoCompositionLayerInstruction {
    CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime);

    OpacityRamp getOpacityRampForTime(CMTime cMTime);

    int getTrackID();

    TransformRamp getTransformRampForTime(CMTime cMTime);

    public static class TransformRamp {
        public boolean available = true;
        public Transform endTransform;
        public Transform startTransform;
        public CMTimeRange timeRange;

        public TransformRamp(CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }

    public static class OpacityRamp {
        public boolean available = true;
        public float endOpacity = 1.0f;
        public float startOpacity = 1.0f;
        public CMTimeRange timeRange;

        public OpacityRamp(CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }

    public static class CropRectangleRamp {
        public boolean available = true;
        public CGRect endCropRectangle;
        public CGRect startCropRectangle;
        public CMTimeRange timeRange;

        public CropRectangleRamp(CMTimeRange cMTimeRange) {
            this.timeRange = cMTimeRange;
        }
    }
}
