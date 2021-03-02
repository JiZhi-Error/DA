package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends t {
    private int r;
    private int s;

    public b() {
        super(" attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n varying vec2 textureCoordinate;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }\n", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n \n void main()\n {\n     lowp vec3 iColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n     lowp vec3 meanColor = texture2D(inputImageTexture2, textureCoordinate).rgb;\n     highp vec3 diffColor = (iColor - meanColor) * 7.07;\n     diffColor = min(diffColor * diffColor, 1.0);\n     gl_FragColor = vec4(diffColor, 1.0);\n }\n");
    }

    @Override // com.tencent.liteav.basic.c.h
    public void a(int i2, int i3) {
        AppMethodBeat.i(221450);
        float min = Math.min(1.0f, 360.0f / ((float) Math.min(i2, i3)));
        this.r = Math.round(((float) i2) * min);
        this.s = Math.round(min * ((float) i3));
        super.a(this.r, this.s);
        AppMethodBeat.o(221450);
    }

    @Override // com.tencent.liteav.basic.c.h
    public int b(int i2) {
        AppMethodBeat.i(221451);
        GLES20.glViewport(0, 0, this.r, this.s);
        int a2 = super.a(i2, this.m, this.n);
        AppMethodBeat.o(221451);
        return a2;
    }
}
