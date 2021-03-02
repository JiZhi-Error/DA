package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

public class LookupFilter extends MultiTextureFilter {
    private static final String FRAGMENT_SHADER = "sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}";
    private static final String FRAGMENT_SHADER_PREFIX = "uniform sampler2D  ";
    private static final String FRAGMENT_SHADER_PREFIX_OES = " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES ";
    private static final String VERTEX_SHADER = "uniform vec2 uScreenSize;\nuniform vec2 uTextureSize;\nuniform mat3 uMatrix;\nuniform mat3 stMatrix;\nattribute vec2 aPosition;\nvarying vec2 vTextureCoord;\nvoid main() {\n  vec3 position = uMatrix * vec3(aPosition, 1);\n  vec2 clipSpace = (position.xy / uScreenSize) * 2.0 - 1.0;\n  gl_Position = vec4(clipSpace, 0, 1);\n  vec3 coord = vec3(aPosition / uTextureSize, 1);\n  vTextureCoord = (stMatrix * coord).xy;\n}\n";
    public float intensity;
    private int intensityHandle;
    public Bitmap lookupBitmap;
    public String lookupBitmapPath;
    private int lookupTextureID;
    private int sLookupTextureHandle;

    public LookupFilter(Bitmap bitmap) {
        this(bitmap, 1.0f);
    }

    public LookupFilter(Bitmap bitmap, float f2) {
        this.intensity = 1.0f;
        this.lookupTextureID = -1;
        this.lookupBitmap = bitmap;
        this.intensity = f2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.core.MultiTextureFilter
    public void initShaderForTextureInfo(TextureInfo textureInfo) {
        AppMethodBeat.i(217908);
        if (textureInfo.textureType == 36197) {
            initShaders(VERTEX_SHADER, " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}");
        } else {
            initShaders(VERTEX_SHADER, "uniform sampler2D  sTexture;\nprecision mediump float;\nuniform sampler2D sLookupTexture; // lookup texture\nvarying highp vec2 vTextureCoord;\n\nuniform lowp float intensity;\nuniform lowp float uAlpha;\n\nvoid main()\n{\n    highp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    textureColor = clamp(textureColor, 0.0, 1.0);\n    highp float blueColor = textureColor.b * 63.0;\n    \n    highp vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n    \n    highp vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n    \n    highp float redPos = 0.125 * textureColor.r;\n    highp float greenPos = 0.125 * textureColor.g;\n    redPos = clamp(redPos, 2.0/512.0, 0.125- 2.0/512.0);\n    greenPos = clamp(greenPos, 2.0/512.0, 0.125- 2.0/512.0);\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + redPos;\n    texPos1.y = (quad1.y * 0.125)  + greenPos;\n    \n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125)  + redPos;\n    texPos2.y = (quad2.y * 0.125) + greenPos;\n    \n    lowp vec4 newColor1 = texture2D(sLookupTexture, texPos1);\n    lowp vec4 newColor2 = texture2D(sLookupTexture, texPos2);\n    \n    lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    newColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n    gl_FragColor = mix(vec4(0,0,0,1), newColor, uAlpha);\n}");
        }
        this.sLookupTextureHandle = GLES20.glGetUniformLocation(this.program, "sLookupTexture");
        RenderContext.checkEglError("glGetUniformLocation sLookupTexture");
        if (this.sLookupTextureHandle == -1) {
            RuntimeException runtimeException = new RuntimeException("Could not get uniform location for sLookupTexture");
            AppMethodBeat.o(217908);
            throw runtimeException;
        }
        this.intensityHandle = GLES20.glGetUniformLocation(this.program, "intensity");
        RenderContext.checkEglError("glGetUniformLocation intensity");
        if (this.intensityHandle == -1) {
            RuntimeException runtimeException2 = new RuntimeException("Could not get uniform location for intensity");
            AppMethodBeat.o(217908);
            throw runtimeException2;
        }
        if (this.lookupTextureID == -1) {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i2 = iArr[0];
            GLES20.glBindTexture(3553, i2);
            RenderContext.checkEglError("glBindTexture mTextureID");
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            RenderContext.checkEglError("glTexParameter");
            GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGB, getRendererWidth(), getRendererHeight(), 0, NativeBitmapStruct.GLFormat.GL_RGB, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLUtils.texImage2D(3553, 0, this.lookupBitmap, 0);
            this.lookupTextureID = i2;
        }
        AppMethodBeat.o(217908);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.core.MultiTextureFilter
    public void prepareDraw(TextureInfo textureInfo, float[] fArr) {
        AppMethodBeat.i(217909);
        super.prepareDraw(textureInfo, fArr);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.lookupTextureID);
        GLES20.glUniform1i(this.sLookupTextureHandle, 1);
        GLES20.glUniform1f(this.intensityHandle, this.intensity);
        AppMethodBeat.o(217909);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tav.core.MultiTextureFilter
    public void finishDraw(TextureInfo textureInfo) {
        AppMethodBeat.i(217910);
        super.finishDraw(textureInfo);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(217910);
    }

    @Override // com.tencent.tav.core.MultiTextureFilter
    public void release() {
        AppMethodBeat.i(217911);
        super.release();
        if (this.lookupTextureID != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.lookupTextureID}, 0);
            this.lookupTextureID = -1;
        }
        AppMethodBeat.o(217911);
    }

    @Override // com.tencent.tav.core.MultiTextureFilter, com.tencent.tav.core.MultiTextureFilter
    public MultiTextureFilter clone() {
        AppMethodBeat.i(217912);
        LookupFilter lookupFilter = new LookupFilter(this.lookupBitmap, this.intensity);
        if (this.subFilter != null) {
            lookupFilter.setSubFilter(this.subFilter.clone());
        }
        AppMethodBeat.o(217912);
        return lookupFilter;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(217913);
        if (obj == this) {
            AppMethodBeat.o(217913);
            return true;
        } else if (obj.getClass() != getClass()) {
            AppMethodBeat.o(217913);
            return false;
        } else if (this.intensity != ((LookupFilter) obj).intensity) {
            AppMethodBeat.o(217913);
            return false;
        } else if (this.lookupBitmap != ((LookupFilter) obj).lookupBitmap) {
            AppMethodBeat.o(217913);
            return false;
        } else {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(217913);
            return equals;
        }
    }
}
