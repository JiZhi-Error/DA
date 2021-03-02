package com.tencent.tav.core.compositing;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

public class VideoCompositionRenderContext {
    RectF edgeWidths;
    private RenderContext renderContext;
    private float renderScale;
    private Matrix renderTransform;
    private CGSize size;
    private VideoComposition videoComposition;
    private TextureInfo videoTexture;

    public CGSize getSize() {
        return this.size;
    }

    public Matrix getRenderTransform() {
        return this.renderTransform;
    }

    public float getRenderScale() {
        return this.renderScale;
    }

    public RectF getEdgeWidths() {
        return this.edgeWidths;
    }

    public VideoComposition getVideoComposition() {
        return this.videoComposition;
    }

    public void setVideoComposition(VideoComposition videoComposition2) {
        this.videoComposition = videoComposition2;
    }

    public VideoCompositionRenderContext(RenderContext renderContext2) {
        AppMethodBeat.i(218021);
        this.renderContext = renderContext2;
        this.size = new CGSize((float) renderContext2.width(), (float) renderContext2.height());
        AppMethodBeat.o(218021);
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    public TextureInfo newTextureInfo() {
        AppMethodBeat.i(218022);
        if (this.videoTexture == null) {
            RenderContext.checkEglError("newSampleBuffer");
            this.videoTexture = new TextureInfo(RenderContext.createTexture(3553), 3553, (int) this.size.width, (int) this.size.height, 0);
        }
        TextureInfo textureInfo = this.videoTexture;
        AppMethodBeat.o(218022);
        return textureInfo;
    }

    public String toString() {
        AppMethodBeat.i(218023);
        String str = "VideoCompositionRenderContext{size=" + this.size + ", renderContext=" + this.renderContext + '}';
        AppMethodBeat.o(218023);
        return str;
    }
}
