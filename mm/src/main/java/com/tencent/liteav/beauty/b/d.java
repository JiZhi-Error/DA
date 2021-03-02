package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d extends h {
    private float r = 2.0f;
    private int s;
    private int t;

    d() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;  \n \nuniform sampler2D inputImageTexture;  \nvarying highp vec2 textureCoordinate; \nuniform float texelWidthOffset; \nuniform float texelHeightOffset; \nvec2 pos[9]; \n \nvoid main()  \n{  \n\tpos[0] = textureCoordinate + vec2(-texelWidthOffset, -texelHeightOffset); \n\tpos[1] = textureCoordinate + vec2(-texelWidthOffset, 0.0); \n\tpos[2] = textureCoordinate + vec2(-texelWidthOffset, texelHeightOffset); \n\tpos[3] = textureCoordinate + vec2(0.0, -texelHeightOffset); \n\tpos[4] = textureCoordinate + vec2(0.0, 0.0); \n\tpos[5] = textureCoordinate + vec2(0.0, texelHeightOffset); \n\tpos[6] = textureCoordinate + vec2(texelWidthOffset, -texelHeightOffset); \n\tpos[7] = textureCoordinate + vec2(texelWidthOffset, 0.0); \n\tpos[8] = textureCoordinate + vec2(texelWidthOffset, texelHeightOffset); \n\tvec4 fragmentColor = texture2D(inputImageTexture, pos[0]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[1]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[2]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[3]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[4]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[5]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[6]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[7]);  \n\tfragmentColor += texture2D(inputImageTexture, pos[8]);  \n \n\tgl_FragColor = fragmentColor / 9.0;  \n} \n");
    }

    @Override // com.tencent.liteav.basic.c.h
    public boolean b() {
        AppMethodBeat.i(15080);
        if (super.b()) {
            this.s = GLES20.glGetUniformLocation(this.f300a, "texelWidthOffset");
            this.t = GLES20.glGetUniformLocation(this.f300a, "texelHeightOffset");
            AppMethodBeat.o(15080);
            return true;
        }
        AppMethodBeat.o(15080);
        return false;
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(15081);
        super.a(i2, i3);
        a(this.r);
        AppMethodBeat.o(15081);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        AppMethodBeat.i(15082);
        this.r = f2;
        a(this.s, this.r / ((float) this.f304e));
        a(this.t, this.r / ((float) this.f305f));
        AppMethodBeat.o(15082);
    }
}
