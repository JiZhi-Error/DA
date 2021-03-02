package com.tencent.tavkit.composition.video;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;

class DefaultVideoMixFilter implements TAVVideoMixEffect.Filter {
    DefaultVideoMixFilter() {
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public CIImage apply(TAVVideoMixEffect tAVVideoMixEffect, ImageCollection imageCollection, RenderInfo renderInfo) {
        AppMethodBeat.i(197602);
        CIImage cIImage = new CIImage(renderInfo.getRenderSize());
        for (ImageCollection.TrackImagePair trackImagePair : imageCollection.getVideoChannelImages()) {
            CIImage image = trackImagePair.getImage();
            checkFillInRenderSize(renderInfo, trackImagePair, image);
            image.imageByCompositingOverImage(cIImage);
        }
        for (ImageCollection.TrackImagePair trackImagePair2 : imageCollection.getOverlayImages()) {
            CIImage image2 = trackImagePair2.getImage();
            checkFillInRenderSize(renderInfo, trackImagePair2, image2);
            image2.imageByCompositingOverImage(cIImage);
        }
        AppMethodBeat.o(197602);
        return cIImage;
    }

    private void checkFillInRenderSize(RenderInfo renderInfo, ImageCollection.TrackImagePair trackImagePair, CIImage cIImage) {
        AppMethodBeat.i(197603);
        if (!(trackImagePair.getTrack() instanceof TAVClip)) {
            AppMethodBeat.o(197603);
            return;
        }
        TAVVideoConfiguration videoConfiguration = ((TAVClip) trackImagePair.getTrack()).getVideoConfiguration();
        if (videoConfiguration.frameEnable()) {
            AppMethodBeat.o(197603);
            return;
        }
        cIImage.applyFillInFrame(new CGRect(new PointF(0.0f, 0.0f), renderInfo.getRenderSize()), videoConfiguration.getContentMode());
        AppMethodBeat.o(197603);
    }

    @Override // com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter
    public void release() {
    }
}
