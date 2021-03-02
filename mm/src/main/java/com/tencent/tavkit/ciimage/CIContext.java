package com.tencent.tavkit.ciimage;

import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;

public class CIContext {
    private final String TAG = ("CIContext@" + Integer.toHexString(hashCode()));
    private CIImageFilter copyFilter;
    private CIImageFilter filter;
    private final RenderContext renderContext;
    private TextureInfo textureInfo;

    public CIContext(RenderContext renderContext2) {
        AppMethodBeat.i(197275);
        this.renderContext = renderContext2;
        AppMethodBeat.o(197275);
    }

    public CMSampleBuffer renderToSampleBuffer(CIImage cIImage, CMTime cMTime, RenderContext renderContext2) {
        AppMethodBeat.i(197276);
        renderContext2.makeCurrent();
        if (!(this.textureInfo == null || (this.textureInfo.width == renderContext2.width() && this.textureInfo.height == renderContext2.height()))) {
            this.textureInfo.release();
            this.textureInfo = null;
        }
        if (this.textureInfo == null) {
            this.textureInfo = newTextureInfo(renderContext2.width(), renderContext2.height());
        }
        setDestImage(this.textureInfo);
        clear(WebView.NIGHT_MODE_COLOR);
        cIImage.draw(this.filter);
        CMSampleBuffer cMSampleBuffer = new CMSampleBuffer(cMTime, this.textureInfo, false);
        AppMethodBeat.o(197276);
        return cMSampleBuffer;
    }

    public static TextureInfo newTextureInfo(CGSize cGSize) {
        AppMethodBeat.i(197277);
        TextureInfo newTextureInfo = newTextureInfo(cGSize.width, cGSize.height);
        AppMethodBeat.o(197277);
        return newTextureInfo;
    }

    public static TextureInfo newTextureInfo(float f2, float f3) {
        AppMethodBeat.i(197278);
        TextureInfo newTextureInfo = newTextureInfo((int) f2, (int) f3);
        AppMethodBeat.o(197278);
        return newTextureInfo;
    }

    public static TextureInfo newTextureInfo(int i2, int i3) {
        AppMethodBeat.i(197279);
        TextureInfo textureInfo2 = new TextureInfo(RenderContext.createTexture(3553), 3553, i2, i3, null, 0);
        textureInfo2.setFormat(NativeBitmapStruct.GLFormat.GL_RGBA);
        AppMethodBeat.o(197279);
        return textureInfo2;
    }

    public TextureInfo convertImageToTexture(CIImage cIImage, TextureInfo textureInfo2) {
        AppMethodBeat.i(197280);
        if (textureInfo2 == null) {
            AppMethodBeat.o(197280);
            return null;
        }
        if (this.copyFilter == null) {
            this.copyFilter = new CIImageFilter();
        }
        this.copyFilter.setOutputTextureInfo(textureInfo2);
        this.copyFilter.clearBufferBuffer(WebView.NIGHT_MODE_COLOR);
        cIImage.draw(this.copyFilter);
        AppMethodBeat.o(197280);
        return textureInfo2;
    }

    public void clear(int i2) {
        AppMethodBeat.i(197281);
        this.filter.clearBufferBuffer(i2);
        AppMethodBeat.o(197281);
    }

    public RenderContext getRenderContext() {
        return this.renderContext;
    }

    private void setDestImage(TextureInfo textureInfo2) {
        AppMethodBeat.i(197282);
        if (this.filter == null) {
            this.filter = new CIImageFilter();
        }
        this.filter.setOutputTextureInfo(textureInfo2);
        AppMethodBeat.o(197282);
    }

    public void release() {
        AppMethodBeat.i(197283);
        Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
        if (this.filter != null) {
            this.filter.release();
        }
        if (this.textureInfo != null) {
            this.textureInfo.release();
        }
        if (this.copyFilter != null) {
            this.copyFilter.release();
        }
        Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
        AppMethodBeat.o(197283);
    }
}
