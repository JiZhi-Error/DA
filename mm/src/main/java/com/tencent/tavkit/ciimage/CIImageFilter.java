package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.TextureInfo;

/* access modifiers changed from: package-private */
public class CIImageFilter extends TextureFilter {
    private final String TAG = ("CIImageFilter@" + Integer.toHexString(hashCode()));
    private int clearColor;
    private TextureInfo destTextureInfo;
    private TextureFilter oesFilter;
    private TextureFilter rgbFilter;

    CIImageFilter() {
        AppMethodBeat.i(197314);
        if (this.rgbFilter == null) {
            this.rgbFilter = new TextureFilter();
        }
        if (this.oesFilter == null) {
            this.oesFilter = new TextureFilter();
        }
        AppMethodBeat.o(197314);
    }

    @Override // com.tencent.tavkit.ciimage.TextureFilter
    public void clearBufferBuffer(int i2) {
        AppMethodBeat.i(197315);
        this.clearColor = i2;
        if (this.oesFilter != null) {
            this.oesFilter.clearBufferBuffer(i2);
        }
        if (this.rgbFilter != null) {
            this.rgbFilter.clearBufferBuffer(i2);
        }
        AppMethodBeat.o(197315);
    }

    @Override // com.tencent.tavkit.ciimage.TextureFilter
    public void setOutputTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(197316);
        this.destTextureInfo = textureInfo;
        if (this.oesFilter != null) {
            this.oesFilter.setOutputTextureInfo(textureInfo);
        }
        if (this.rgbFilter != null) {
            this.rgbFilter.setOutputTextureInfo(textureInfo);
        }
        AppMethodBeat.o(197316);
    }

    @Override // com.tencent.tavkit.ciimage.TextureFilter
    public void release() {
        AppMethodBeat.i(197317);
        if (this.oesFilter != null) {
            this.oesFilter.release();
        }
        if (this.rgbFilter != null) {
            this.rgbFilter.release();
        }
        AppMethodBeat.o(197317);
    }

    @Override // com.tencent.tavkit.ciimage.TextureFilter
    public TextureInfo applyFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2, CGRect cGRect) {
        AppMethodBeat.i(197318);
        if (textureInfo == null) {
            AppMethodBeat.o(197318);
            return null;
        } else if (textureInfo.textureType == 36197) {
            TextureInfo tryApplyOESFilter = tryApplyOESFilter(textureInfo, matrix, matrix2, f2, cGRect);
            AppMethodBeat.o(197318);
            return tryApplyOESFilter;
        } else {
            TextureInfo tryApplyRGBFilter = tryApplyRGBFilter(textureInfo, matrix, matrix2, f2, cGRect);
            AppMethodBeat.o(197318);
            return tryApplyRGBFilter;
        }
    }

    private TextureInfo tryApplyOESFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2, CGRect cGRect) {
        AppMethodBeat.i(197319);
        TextureInfo applyFilter = this.oesFilter.applyFilter(textureInfo, matrix, matrix2, f2, cGRect);
        AppMethodBeat.o(197319);
        return applyFilter;
    }

    private TextureInfo tryApplyRGBFilter(TextureInfo textureInfo, Matrix matrix, Matrix matrix2, float f2, CGRect cGRect) {
        AppMethodBeat.i(197320);
        TextureInfo applyFilter = this.rgbFilter.applyFilter(textureInfo, matrix, matrix2, f2, cGRect);
        AppMethodBeat.o(197320);
        return applyFilter;
    }

    @Override // com.tencent.tavkit.ciimage.TextureFilter
    public String toString() {
        AppMethodBeat.i(197321);
        String str = "CIImageFilter{program=" + this.program + ", clearColor=" + this.clearColor + ", destTextureInfo=" + this.destTextureInfo + '}';
        AppMethodBeat.o(197321);
        return str;
    }
}
