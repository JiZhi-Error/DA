package com.tencent.tavkit.composition.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;

public class TAVVideoCompositionLayerInstruction implements VideoCompositionLayerInstruction {
    private final TAVVideoCompositionTrack imageSource;
    private Matrix preferredTransform;
    private CMTimeRange timeRange;
    private int trackID;
    private TAVVideoTransition transition;
    private final TAVVideoConfiguration videoConfiguration;

    public TAVVideoCompositionLayerInstruction(int i2, TAVVideoConfiguration tAVVideoConfiguration, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        AppMethodBeat.i(197633);
        this.trackID = i2;
        this.videoConfiguration = tAVVideoConfiguration;
        this.imageSource = tAVVideoCompositionTrack;
        this.preferredTransform = new Matrix();
        AppMethodBeat.o(197633);
    }

    public TAVVideoCompositionLayerInstruction(int i2, TAVTransitionableVideo tAVTransitionableVideo) {
        this(i2, tAVTransitionableVideo.getVideoConfiguration(), tAVTransitionableVideo);
        AppMethodBeat.i(197634);
        setTimeRange(tAVTransitionableVideo.getTimeRange());
        setTransition(tAVTransitionableVideo.getVideoTransition());
        AppMethodBeat.o(197634);
    }

    public void setTrackID(int i2) {
        this.trackID = i2;
    }

    public CMTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(CMTimeRange cMTimeRange) {
        this.timeRange = cMTimeRange;
    }

    public Matrix getPreferredTransform() {
        return this.preferredTransform;
    }

    public void setPreferredTransform(Matrix matrix) {
        this.preferredTransform = matrix;
    }

    public TAVVideoCompositionTrack getImageSource() {
        return this.imageSource;
    }

    public TAVVideoTransition getTransition() {
        return this.transition;
    }

    public void setTransition(TAVVideoTransition tAVVideoTransition) {
        this.transition = tAVVideoTransition;
    }

    public Bitmap applySourceImage(Bitmap bitmap, CMTime cMTime, CGSize cGSize) {
        return null;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public int getTrackID() {
        return this.trackID;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime cMTime) {
        return null;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime cMTime) {
        return null;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime) {
        return null;
    }

    public TAVVideoConfiguration getVideoConfiguration() {
        return this.videoConfiguration;
    }

    public String toString() {
        AppMethodBeat.i(197635);
        String str = "TAVVideoCompositionLayerInstruction{trackID=" + this.trackID + ", timeRange=" + this.timeRange.toSimpleString() + ", preferredTransform=" + this.preferredTransform + ", imageSource=" + this.imageSource + ", transition=" + this.transition + ", videoConfiguration=" + this.videoConfiguration + '}';
        AppMethodBeat.o(197635);
        return str;
    }
}
