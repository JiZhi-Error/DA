package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class r extends h {
    private static String v = "GPUSharpen";
    private int r;
    private float s;
    private int t;
    private int u;

    public r() {
        this(0.0f);
    }

    public r(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float imageWidthFactor; \nuniform float imageHeightFactor; \nuniform float sharpness;\n\nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate; \nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n\nvarying float centerMultiplier;\nvarying float edgeMultiplier;\n\nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy + heightStep;     \n    bottomTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    \n    centerMultiplier = 1.0 + 4.0 * sharpness;\n    edgeMultiplier = sharpness;\n}", "precision highp float;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 leftTextureCoordinate;\nvarying highp vec2 rightTextureCoordinate; \nvarying highp vec2 topTextureCoordinate;\nvarying highp vec2 bottomTextureCoordinate;\n\nvarying highp float centerMultiplier;\nvarying highp float edgeMultiplier;\n\nuniform sampler2D inputImageTexture;\n\nvoid main()\n{\n    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n\n    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), 1.0);\n}");
        this.s = f2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15025);
        boolean b2 = super.b();
        this.r = GLES20.glGetUniformLocation(p(), "sharpness");
        this.t = GLES20.glGetUniformLocation(p(), "imageWidthFactor");
        this.u = GLES20.glGetUniformLocation(p(), "imageHeightFactor");
        a(this.s);
        AppMethodBeat.o(15025);
        return b2;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15026);
        super.a(i2, i3);
        a(this.t, 1.0f / ((float) i2));
        a(this.u, 1.0f / ((float) i3));
        AppMethodBeat.o(15026);
    }

    public void a(float f2) {
        AppMethodBeat.i(15027);
        this.s = f2;
        TXCLog.i(v, "set Sharpness ".concat(String.valueOf(f2)));
        a(this.r, this.s);
        AppMethodBeat.o(15027);
    }
}