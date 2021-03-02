package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.Transform;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableVideoCompositionLayerInstruction implements VideoCompositionLayerInstruction {
    private AssetTrack assetTrack;
    private List<VideoCompositionLayerInstruction.CropRectangleRamp> cropRectangleRampList = new ArrayList();
    private CMTime duration = new CMTime(2147483647L);
    private boolean flipX = false;
    private boolean flipY = false;
    private List<VideoCompositionLayerInstruction.OpacityRamp> opacityRampList = new ArrayList();
    private int trackID;
    private List<VideoCompositionLayerInstruction.TransformRamp> transformRampList = new ArrayList();

    public void setFlipX(boolean z) {
        this.flipX = z;
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
    }

    public MutableVideoCompositionLayerInstruction(AssetTrack assetTrack2) {
        AppMethodBeat.i(218029);
        this.trackID = assetTrack2.getTrackID();
        this.assetTrack = assetTrack2;
        this.duration = assetTrack2.getDuration();
        AppMethodBeat.o(218029);
    }

    public MutableVideoCompositionLayerInstruction(int i2) {
        AppMethodBeat.i(218030);
        this.trackID = i2;
        AppMethodBeat.o(218030);
    }

    public MutableVideoCompositionLayerInstruction() {
        AppMethodBeat.i(218031);
        AppMethodBeat.o(218031);
    }

    public void setTrackID(int i2) {
        this.trackID = i2;
    }

    public void setTransformRampFromStartTransform(Transform transform, Transform transform2, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218032);
        VideoCompositionLayerInstruction.TransformRamp transformRamp = new VideoCompositionLayerInstruction.TransformRamp(cMTimeRange);
        transformRamp.startTransform = transform;
        transformRamp.endTransform = transform2;
        Iterator<VideoCompositionLayerInstruction.TransformRamp> it = this.transformRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.TransformRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.transformRampList.size()) {
                VideoCompositionLayerInstruction.TransformRamp transformRamp2 = this.transformRampList.get(i3);
                if (transformRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                    this.transformRampList.remove(transformRamp2);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                this.transformRampList.add(transformRamp);
                AppMethodBeat.o(218032);
                return;
            }
        }
    }

    public void setTransform(Transform transform, CMTime cMTime) {
        CMTime cMTime2;
        AppMethodBeat.i(218033);
        CMTime cMTime3 = this.duration;
        Iterator<VideoCompositionLayerInstruction.TransformRamp> it = this.transformRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                cMTime2 = cMTime3;
                break;
            }
            VideoCompositionLayerInstruction.TransformRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                CMTime end = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                cMTime2 = end;
                break;
            }
        }
        VideoCompositionLayerInstruction.TransformRamp transformRamp = new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        transformRamp.startTransform = transform;
        transformRamp.endTransform = transform;
        this.transformRampList.add(transformRamp);
        AppMethodBeat.o(218033);
    }

    public void setOpacityRampFromStartOpacity(float f2, float f3, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218034);
        VideoCompositionLayerInstruction.OpacityRamp opacityRamp = new VideoCompositionLayerInstruction.OpacityRamp(cMTimeRange);
        opacityRamp.startOpacity = f2;
        opacityRamp.endOpacity = f3;
        Iterator<VideoCompositionLayerInstruction.OpacityRamp> it = this.opacityRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.OpacityRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.opacityRampList.size()) {
                VideoCompositionLayerInstruction.OpacityRamp opacityRamp2 = this.opacityRampList.get(i3);
                if (opacityRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                    this.opacityRampList.remove(opacityRamp2);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                this.opacityRampList.add(opacityRamp);
                AppMethodBeat.o(218034);
                return;
            }
        }
    }

    public void setOpacity(float f2, CMTime cMTime) {
        CMTime cMTime2;
        AppMethodBeat.i(218035);
        CMTime cMTime3 = this.duration;
        Iterator<VideoCompositionLayerInstruction.OpacityRamp> it = this.opacityRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                cMTime2 = cMTime3;
                break;
            }
            VideoCompositionLayerInstruction.OpacityRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                CMTime end = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                cMTime2 = end;
                break;
            }
        }
        VideoCompositionLayerInstruction.OpacityRamp opacityRamp = new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        opacityRamp.startOpacity = f2;
        opacityRamp.endOpacity = f2;
        this.opacityRampList.add(opacityRamp);
        AppMethodBeat.o(218035);
    }

    public void setCropRectangleRampFromStartCropRectangle(CGRect cGRect, CGRect cGRect2, CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218036);
        VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp = new VideoCompositionLayerInstruction.CropRectangleRamp(cMTimeRange);
        cropRectangleRamp.startCropRectangle = cGRect;
        cropRectangleRamp.endCropRectangle = cGRect2;
        Iterator<VideoCompositionLayerInstruction.CropRectangleRamp> it = this.cropRectangleRampList.iterator();
        if (it.hasNext()) {
            VideoCompositionLayerInstruction.CropRectangleRamp next = it.next();
            CMTime start = next.timeRange.getStart();
            CMTime end = next.timeRange.getEnd();
            if (cMTimeRange.containsTime(start) && cMTimeRange.containsTime(end)) {
                next.timeRange = CMTimeRange.CMTimeRangeInvalid;
            } else if (cMTimeRange.containsTime(start) && !cMTimeRange.containsTime(end)) {
                next.timeRange = new CMTimeRange(cMTimeRange.getEnd(), next.timeRange.getEnd().sub(cMTimeRange.getEnd()));
            } else if (cMTimeRange.containsTime(end) && !cMTimeRange.containsTime(start)) {
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTimeRange.getStart().sub(next.timeRange.getStart()));
            }
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cropRectangleRampList.size()) {
                VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp2 = this.cropRectangleRampList.get(i3);
                if (cropRectangleRamp2.timeRange == CMTimeRange.CMTimeRangeInvalid) {
                    this.cropRectangleRampList.remove(cropRectangleRamp2);
                    i3--;
                }
                i2 = i3 + 1;
            } else {
                this.cropRectangleRampList.add(cropRectangleRamp);
                AppMethodBeat.o(218036);
                return;
            }
        }
    }

    public void setCropRectangle(CGRect cGRect, CMTime cMTime) {
        CMTime cMTime2;
        AppMethodBeat.i(218037);
        CMTime cMTime3 = this.duration;
        Iterator<VideoCompositionLayerInstruction.CropRectangleRamp> it = this.cropRectangleRampList.iterator();
        while (true) {
            if (!it.hasNext()) {
                cMTime2 = cMTime3;
                break;
            }
            VideoCompositionLayerInstruction.CropRectangleRamp next = it.next();
            if (next.timeRange.containsTime(cMTime)) {
                CMTime end = next.timeRange.getEnd();
                next.timeRange = new CMTimeRange(next.timeRange.getStart(), cMTime.sub(next.timeRange.getStart()));
                cMTime2 = end;
                break;
            }
        }
        VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp = new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(cMTime, cMTime2.sub(cMTime)));
        cropRectangleRamp.startCropRectangle = cGRect;
        cropRectangleRamp.endCropRectangle = cGRect;
        this.cropRectangleRampList.add(cropRectangleRamp);
        AppMethodBeat.o(218037);
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public int getTrackID() {
        return this.trackID;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime cMTime) {
        AppMethodBeat.i(218038);
        for (VideoCompositionLayerInstruction.TransformRamp transformRamp : this.transformRampList) {
            if (transformRamp.timeRange.containsTime(cMTime)) {
                AppMethodBeat.o(218038);
                return transformRamp;
            }
        }
        VideoCompositionLayerInstruction.TransformRamp transformRamp2 = new VideoCompositionLayerInstruction.TransformRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
        AppMethodBeat.o(218038);
        return transformRamp2;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime cMTime) {
        AppMethodBeat.i(218039);
        for (VideoCompositionLayerInstruction.OpacityRamp opacityRamp : this.opacityRampList) {
            if (opacityRamp.timeRange.containsTime(cMTime)) {
                AppMethodBeat.o(218039);
                return opacityRamp;
            }
        }
        VideoCompositionLayerInstruction.OpacityRamp opacityRamp2 = new VideoCompositionLayerInstruction.OpacityRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
        AppMethodBeat.o(218039);
        return opacityRamp2;
    }

    @Override // com.tencent.tav.core.composition.VideoCompositionLayerInstruction
    public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime cMTime) {
        AppMethodBeat.i(218040);
        for (VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp : this.cropRectangleRampList) {
            if (cropRectangleRamp.timeRange.containsTime(cMTime)) {
                AppMethodBeat.o(218040);
                return cropRectangleRamp;
            }
        }
        VideoCompositionLayerInstruction.CropRectangleRamp cropRectangleRamp2 = new VideoCompositionLayerInstruction.CropRectangleRamp(new CMTimeRange(CMTime.CMTimeZero, this.duration));
        AppMethodBeat.o(218040);
        return cropRectangleRamp2;
    }
}
