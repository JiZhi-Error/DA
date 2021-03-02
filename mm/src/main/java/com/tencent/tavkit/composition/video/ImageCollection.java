package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;

public class ImageCollection {
    private final List<TrackImagePair> overlayImages = new ArrayList();
    private final List<TrackImagePair> videoChannelImages = new ArrayList();

    public ImageCollection() {
        AppMethodBeat.i(197604);
        AppMethodBeat.o(197604);
    }

    public void addChannelImage(CIImage cIImage, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        AppMethodBeat.i(197605);
        this.videoChannelImages.add(new TrackImagePair(cIImage, tAVVideoCompositionTrack));
        AppMethodBeat.o(197605);
    }

    public void addOverlayImage(CIImage cIImage, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
        AppMethodBeat.i(197606);
        this.overlayImages.add(new TrackImagePair(cIImage, tAVVideoCompositionTrack));
        AppMethodBeat.o(197606);
    }

    public List<TrackImagePair> getVideoChannelImages() {
        return this.videoChannelImages;
    }

    public List<TrackImagePair> getOverlayImages() {
        return this.overlayImages;
    }

    public String toString() {
        AppMethodBeat.i(197607);
        String str = "ImageCollection{videoChannelImages=" + this.videoChannelImages + ", overlayImages=" + this.overlayImages + '}';
        AppMethodBeat.o(197607);
        return str;
    }

    public static class TrackImagePair {
        private final CIImage image;
        private final TAVVideoCompositionTrack track;

        TrackImagePair(CIImage cIImage, TAVVideoCompositionTrack tAVVideoCompositionTrack) {
            this.image = cIImage;
            this.track = tAVVideoCompositionTrack;
        }

        public TAVVideoCompositionTrack getTrack() {
            return this.track;
        }

        public CIImage getImage() {
            return this.image;
        }
    }
}
