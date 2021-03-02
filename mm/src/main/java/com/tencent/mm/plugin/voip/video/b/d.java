package com.tencent.mm.plugin.voip.video.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.c;
import com.tencent.mm.plugin.voip.video.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class d {
    FloatBuffer HkX;
    FloatBuffer HkY;
    public f HkZ;
    com.tencent.mm.media.g.d[] HlF = new com.tencent.mm.media.g.d[3];
    private int[] HlG = new int[3];
    private FloatBuffer HlH;
    public b HlI;
    com.tencent.mm.media.g.d HlJ = null;
    com.tencent.mm.media.g.d HlK = null;
    a HlL = null;
    boolean HlM = false;
    boolean HlN = false;
    boolean HlO = false;
    boolean HlP = false;
    public float[] HlQ = new float[8];
    public float[] HlR = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public float[] HlS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    float[] HlT = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    float[] HlU = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int mProgram = 0;
    private FloatBuffer mVertexBuffer;
    public int outputHeight = 0;
    public int outputWidth = 0;
    int surfaceHeight = 0;
    int surfaceWidth = 0;

    public d() {
        AppMethodBeat.i(115730);
        fLF();
        fLI();
        AppMethodBeat.o(115730);
    }

    static void aMY() {
        AppMethodBeat.i(115732);
        GLES20.glFinish();
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glUseProgram(0);
        AppMethodBeat.o(115732);
    }

    /* access modifiers changed from: package-private */
    public final void a(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        AppMethodBeat.i(115733);
        this.HlF[i4].a(i2, i3, 6409, byteBuffer, 9729, 33071);
        AppMethodBeat.o(115733);
    }

    public final void b(float[] fArr, float[] fArr2, float[] fArr3) {
        AppMethodBeat.i(235898);
        if (this.HkX == null || this.HkX.capacity() != fArr.length) {
            this.HkX = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.HkX.put(fArr);
        this.HkX.position(0);
        f.e(fArr2, fArr3);
        if (this.HkY == null || this.HkY.capacity() != fArr3.length) {
            this.HkY = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.HkY.put(fArr3);
        this.HkY.position(0);
        AppMethodBeat.o(235898);
    }

    public final void d(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(115734);
        if (this.mVertexBuffer == null || this.mVertexBuffer.capacity() != fArr.length) {
            this.mVertexBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.mVertexBuffer.put(fArr);
        this.mVertexBuffer.position(0);
        if (this.HlH == null || this.HlH.capacity() != fArr2.length) {
            this.HlH = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        this.HlH.put(fArr2);
        this.HlH.position(0);
        AppMethodBeat.o(115734);
    }

    private void fLI() {
        AppMethodBeat.i(115735);
        this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
        for (int i2 = 0; i2 < this.HlF.length; i2++) {
            this.HlF[i2] = c.a(true, 14);
        }
        this.HlI = new b();
        b bVar = this.HlI;
        bVar.fLF();
        bVar.Hlk = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "varying highp vec2 tc;\nuniform sampler2D inputImageTexture;\nuniform mediump float smoothDegree;\nuniform mediump int showCounter;\nuniform mediump int showMode;\n\nuniform mediump float brightness;\nuniform mediump float texelWidth;\nuniform mediump float texelHeight;\n\nprecision highp float;\nconst mat3 RGBtoYUV = mat3(0.299,  0.587, 0.114, 0.5, -0.4187, -0.0813, -0.169, -0.3313,  0.5 );    //full range\nconst mat3 YUVtoRGB = mat3(1.1643, 1.5958, 0.0, 1.1643, -0.8129, -0.3917, 1.1643, 0.0, 2.017 );\n\nconst highp mat3 saturateMatrix = mat3(\n1.1102, -0.0598, -0.061,\n-0.0774, 1.0826, -0.1186,\n-0.0228, -0.0228, 1.1772);\n\n\nvec3 rgb2hsv(vec3 c)\n{\n    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n    vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n    vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n\n    float d = q.x - min(q.w, q.y);\n    float e = 1.0e-10;\n    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n}\n\nvec3 hsv2rgb(vec3 c)\n{\n    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);\n    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);\n    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);\n}\n\nvec3 yuv2rgb(vec3 c)\n{\n    vec3 rgb = YUVtoRGB*c;\n    return rgb;\n}\nvec3 rgb2yuv(vec3 c)\n{\n    vec3 yuv = c*RGBtoYUV;\n    return yuv;\n}\nmediump float hardLight(mediump float color){\n    if (color <= 0.5)\n    color = color * color * 2.0;\n    else\n    color = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n    return color;\n}\n\nfloat lum(vec3 v)\n{\n    return dot(v, vec3(0.299, 0.587, 0.114));\n}\n\nvec4 getValue(vec4 newValue, vec4 originValue)\n{\n    return mix(newValue, originValue, step(lum(newValue.rgb), lum(originValue.rgb)));\n}\n\nvec4 Sobel2()\n{\n    vec2 samplerSteps = vec2(1.0/texelWidth, 1.0/texelHeight);\n    vec2 coords[8];\n    coords[0] = tc - samplerSteps * 2.0;\n    coords[1] = tc + vec2(0.0, -samplerSteps.y) * 2.0;\n    coords[2] = tc + vec2(samplerSteps.x, -samplerSteps.y) * 2.0;\n\n    coords[3] = tc - vec2(samplerSteps.x, 0.0) * 2.0;\n    coords[4] = tc + vec2(samplerSteps.x, 0.0) * 2.0;\n\n    coords[5] = tc + vec2(-samplerSteps.x, samplerSteps.y) * 2.0;\n    coords[6] = tc + vec2(0.0, samplerSteps.y) * 2.0;\n    coords[7] = tc + vec2(samplerSteps.x, samplerSteps.y) * 2.0;\n\n    vec3 colors[8];\n    for(int i = 0; i < 8; ++i)\n    {\n        colors[i] = texture2D(inputImageTexture, coords[i]).rgb;\n    }\n\n    vec4 src = texture2D(inputImageTexture, tc);\n    vec3 h = -colors[0] - 2.0 * colors[1] - colors[2] + colors[5] + 2.0 * colors[6] + colors[7];\n    vec3 v = -colors[0] + colors[2] - 2.0 * colors[3] + 2.0 * colors[4] - colors[5] + colors[7];\n    return vec4(mix(src.rgb, sqrt(h * h + v * v), 1.0), src.a);\n}\n\nvec4 maxFilter()\n{\n    vec2 samplerSteps = vec2(1.0/texelWidth, 1.0/texelHeight);\n    vec2 texCoord[13];\n    vec4 vMin;\n    vec2 thisCoord = tc;\n\n    texCoord[0] = thisCoord + vec2(0, -samplerSteps.y * 2.0);\n    texCoord[1] = thisCoord - samplerSteps;\n    texCoord[2] = thisCoord + vec2(0, -samplerSteps.y);\n    texCoord[3] = thisCoord + vec2(samplerSteps.x, -samplerSteps.y);\n    texCoord[4] = thisCoord + vec2(-samplerSteps.x * 2.0, 0.0);\n    texCoord[5] = thisCoord + vec2(-samplerSteps.x, 0.0);\n    texCoord[6] = thisCoord;\n    texCoord[7] = thisCoord + vec2(samplerSteps.x, 0.0);\n    texCoord[8] = thisCoord + vec2(samplerSteps.x * 2.0, 0.0);\n    texCoord[9] = thisCoord + vec2(-samplerSteps.x, samplerSteps.y);\n    texCoord[10] = thisCoord + vec2(0.0, samplerSteps.y);\n    texCoord[11] = thisCoord + samplerSteps;\n    texCoord[12] = thisCoord + vec2(0.0, 2.0* samplerSteps.y);\n\n\n\n    {\n        vec4 vTemp;\n\n        vMin = texture2D(inputImageTexture, texCoord[0]);\n\n        vTemp = texture2D(inputImageTexture, texCoord[1]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[2]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[3]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[4]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[5]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[6]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[7]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[8]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[9]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[10]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[11]);\n        vMin = getValue(vTemp, vMin);\n\n        vTemp = texture2D(inputImageTexture, texCoord[12]);\n        vMin = getValue(vTemp, vMin);\n    }\n    return vMin;\n}\n\nvoid main()\n{\n    //highp vec4 smoothNew;\n    highp vec3 yuv;\n    highp vec3 rgb;\n\n    vec3 centralColor = texture2D(inputImageTexture,  tc ).rgb;\n    //vec3 maxFilt = texture2D(inputImageTexture3, tc).rgb;  //canny\n    //vec3 lunkuo  = texture2D(inputImageTexture3, tc).rgb;\n\n    vec2 blurCoordinates[20];\n    vec2 imageStep = vec2(1.5/texelWidth, 1.5/texelHeight);\n\n    //重新调整了滤波的范围和权重，减少水波纹\n    blurCoordinates[0] = tc + vec2(0.0, -4.0) * imageStep;\n    blurCoordinates[1] = tc + vec2(2.0, -3.0) * imageStep;\n    blurCoordinates[2] = tc + vec2(3.0, -2.0) * imageStep;\n    blurCoordinates[3] = tc + vec2(4.0, 0.0) * imageStep;\n    blurCoordinates[4] = tc + vec2(3.0, 2.0) * imageStep;\n    blurCoordinates[5] = tc + vec2(2.0, 3.0) * imageStep;\n    blurCoordinates[6] = tc + vec2(0.0, 4.0) * imageStep;\n    blurCoordinates[7] = tc + vec2(-2.0, 3.0) * imageStep;\n    blurCoordinates[8] = tc + vec2(-3.0, 2.0) * imageStep;\n    blurCoordinates[9] = tc + vec2(-4.0, 0.0) * imageStep;\n    blurCoordinates[10] = tc + vec2(-3.0, -2.0) * imageStep;\n    blurCoordinates[11] = tc + vec2(-2.0, -3.0) * imageStep;\n\n    blurCoordinates[12] = tc + vec2(0.0, -2.0) * imageStep;\n    blurCoordinates[13] = tc + vec2(-1.0, -1.0) * imageStep;\n    blurCoordinates[14] = tc + vec2(-2.0, 0.0) * imageStep;\n    blurCoordinates[15] = tc + vec2(-1.0, 1.0) * imageStep;\n    blurCoordinates[16] = tc + vec2(0.0, 2.0) * imageStep;\n    blurCoordinates[17] = tc + vec2(1.0, 1.0) * imageStep;\n    blurCoordinates[18] = tc + vec2(2.0, 0.0) * imageStep;\n    blurCoordinates[19] = tc + vec2(1.0, -1.0) * imageStep;\n\n    //vec3 centralColor = texture2D(inputImageTexture, tc).rgb;\n    //float sampleColor = centralColor.g * 24.0;\n    vec3 sampleColor = centralColor * 24.0;\n\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[0]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[1]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[2]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[3]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[4]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[5]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[6]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[7]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[8]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[9]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[10]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[11]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[12]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[13]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[14]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[15]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[16]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[17]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[18]).rgb;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[19]).rgb;\n\n    sampleColor = sampleColor/44.0;\n\n    float dis = centralColor.g - sampleColor.g + 0.5;   //high\n\n    for (int i = 0; i < 5; i++) {\n        dis = hardLight(dis);\n    }\n\n    // 0.065 -> 1.125, 加大滤波强度\n    vec3 result = centralColor * 1.125 - dis * 0.125; //central+(central-dis)*0.065\n\n    float hue = dot(result, vec3(0.299,0.587,0.114)) - 0.3;   //luminance\n    hue = pow(clamp(hue, 0.0, 1.0), 0.3);\n\n    yuv= rgb2yuv(sampleColor);\n    float cr=yuv.y-0.094;\n    float cb=yuv.z+0.0745;\n\n    float tx = ((25.59*cr-19.19*cb)*255.0 + 51.0)*0.04;\n    float ty = ((25.59*cr+19.19*cb)*255.0 + 77.0)*0.07;\n    float val0 = tx*tx + ty*ty;\n\n    float chroma_sum=yuv.y+yuv.z+1.0;\n    float chroma_diff=yuv.y-yuv.z;\n    float chroma_diff_th = 0.1-(yuv.x/10.0);\n\n    float face = 1.0;\n    if(yuv.z>-0.1667 && yuv.z<0.0294 && chroma_sum>0.7804 && chroma_sum<1.098 && chroma_diff>chroma_diff_th){\n        if(yuv.x<0.3922) {\n            if(val0<1700.0) {\n                face = 0.0;\n            } else {\n                hue = 0.0;\n            }\n        } else {\n            if(val0<3150.0) {\n                face = 0.0;\n            } else {\n                hue = 0.0;\n            }\n        }\n    } else {\n        hue = 0.0;\n    }\n\n    result = centralColor * (1.0 - hue) + result * hue;\n    result = result+vec3(brightness*0.1);\n\n    // 这里可以进一步简化计算\n    if(showMode == 1 /*|| showMode == 2*/)\n    {\n         result = vec3(hue);\n    }\n    else if(showMode == 0)\n    {\n        result = centralColor;\n    }\n\n    vec3 smoothNew = mix(centralColor, result, smoothDegree);\n\n\n//showCounter用于显示mask\nif(showCounter == 1)\n{\n    smoothNew =vec3(face);\n}\n\n//mode3:显示边缘\nif(showMode == 3)\n{\n    vec3 maxValue = maxFilter().rgb;\n    float lumOrigin = lum(centralColor);\n    float lumMax = lum(maxValue) + 0.001;\n    float blendColor = min(lumOrigin / lumMax, 1.0);\n\n    float smoothDegree2 =  0.8 + (smoothDegree/5.0); //约束范围：0.8~1.0\n    smoothNew =mix(centralColor, vec3(blendColor), smoothDegree2);\n}\n\n//mode4:显示轮廓\nif(showMode == 4)\n{\n    vec4 src  = Sobel2();\n    // saturation合并到level中\n    max(src.r, src.g);\n    float lum = (max(max(src.r, src.g),src.b) + min(min(src.r, src.g), src.b)) / 2.0;\n    src = vec4(mix(vec3(lum), src.rgb, 0.0), src.a);  //intensity = 0.0\n\n    // level filter: colorLevel.x = dark = 0.33, colorLevel.y = light = 0.60\n    float colorLevelx = 0.3;\n    float colorLevely = 0.60;\n    //float gamma = 0.99;\n    float gamma = smoothDegree;\n    src.rgb = clamp((src.rgb - colorLevelx) / (colorLevely - colorLevelx), 0.0, 1.0);\n    src.rgb = clamp(pow(src.rgb, vec3(gamma)), 0.0, 1.0);\n    smoothNew = src.rgb;\n}\n\ngl_FragColor = vec4(smoothNew, 1.0);\n}");
        bVar.Hll = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision mediump float;\nvarying vec2 tc;\nuniform sampler2D inputImageTexture;\nvoid main() {\n    vec4 color = texture2D(inputImageTexture, tc);\n    gl_FragColor = color;\n}");
        this.HlJ = f.fLz();
        this.HlL = f.fLA();
        Log.i("MicroMsg.VoipGLSProgram", "initRenderOutputFbo, texture:%s, fbo:%s", this.HlJ, this.HlL);
        this.HlK = f.fLz();
        Log.i("MicroMsg.VoipGLSProgram", "init stFilterOutputTexture, texture:%s ", this.HlK);
        b bVar2 = this.HlI;
        int i3 = this.HlK.igv;
        Log.i("MicroMsg.VoipGLSProgram", "initData, texture:%s", Integer.valueOf(i3));
        bVar2.Hlm = i3;
        b.q(bVar2.Hly);
        float[] fArr = bVar2.Hlx;
        float[] fArr2 = bVar2.Hly;
        bVar2.Hlp = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        bVar2.Hlp.put(fArr);
        bVar2.Hlp.position(0);
        bVar2.HlA = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        bVar2.HlA.put(fArr2);
        bVar2.HlA.position(0);
        this.HkZ = new f();
        this.HkZ.MC();
        this.HkZ.lS(this.outputWidth, this.outputHeight);
        this.HkZ.apK(this.HlK.igv);
        AppMethodBeat.o(115735);
    }

    public final synchronized void fLF() {
        synchronized (this) {
            AppMethodBeat.i(115736);
            Log.i("MicroMsg.VoipGLSProgram", "%s do destroy", Integer.valueOf(hashCode()));
            if (this.HlJ != null) {
                this.HlJ.close();
            }
            if (this.HlK != null) {
                this.HlK.close();
            }
            com.tencent.mm.media.g.d[] dVarArr = this.HlF;
            for (com.tencent.mm.media.g.d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.close();
                }
            }
            if (this.HlL != null) {
                this.HlL.close();
            }
            GLES20.glDeleteProgram(this.mProgram);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glFinish();
            if (this.HlH != null) {
                this.HlH.clear();
            }
            if (this.mVertexBuffer != null) {
                this.mVertexBuffer.clear();
            }
            this.HlJ = null;
            this.HlK = null;
            this.HlL = null;
            this.mVertexBuffer = null;
            this.HlH = null;
            this.mProgram = 0;
            if (this.HlI != null) {
                this.HlI.fLF();
            }
            if (this.HkZ != null) {
                this.HkZ.onDestroy();
            }
            AppMethodBeat.o(115736);
        }
    }

    public final a fLJ() {
        AppMethodBeat.i(115737);
        if (this.HlI != null) {
            b bVar = this.HlI;
            if (bVar.HlB == null || bVar.outputHeight == 0 || bVar.outputWidth == 0) {
                AppMethodBeat.o(115737);
                return null;
            }
            a aVar = new a(bVar.outputWidth, bVar.outputHeight, 1, bVar.Hlu);
            AppMethodBeat.o(115737);
            return aVar;
        }
        AppMethodBeat.o(115737);
        return null;
    }

    public final b fJk() {
        ByteBuffer byteBuffer;
        AppMethodBeat.i(235899);
        if (this.HkZ != null) {
            int i2 = this.HkZ.outputWidth;
            int i3 = this.HkZ.outputHeight;
            f fVar = this.HkZ;
            if (fVar.RfK == null || fVar.outputHeight == 0 || fVar.outputWidth == 0) {
                byteBuffer = null;
            } else {
                byteBuffer = fVar.Hlu;
            }
            if (byteBuffer == null || this.outputHeight == 0 || this.outputWidth == 0) {
                AppMethodBeat.o(235899);
                return null;
            }
            b bVar = new b(i2, i3, byteBuffer);
            AppMethodBeat.o(235899);
            return bVar;
        }
        AppMethodBeat.o(235899);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void adX(int i2) {
        int i3 = 2;
        AppMethodBeat.i(115731);
        GLES20.glUseProgram(this.mProgram);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        if (glGetAttribLocation < 0) {
            Log.e("MicroMsg.VoipGLSProgram", "int mPositionHandle error: %s, reinit program", Integer.valueOf(glGetAttribLocation));
            GLES20.glDeleteProgram(this.mProgram);
            this.mProgram = f.createProgram("attribute vec4 vPosition;attribute vec2 vTexCoord;varying vec2 tc;void main() {  gl_Position = vPosition;  tc = vTexCoord;}", "precision highp float;uniform sampler2D samplerY;uniform sampler2D samplerU;uniform sampler2D samplerV;uniform sampler2D samplerUV;uniform int yuvType;varying vec2 tc;void main() {  vec4 c = vec4((texture2D(samplerY, tc).r - 16./255.) * 1.164);  vec4 U; vec4 V; if (yuvType == 0 || yuvType == 1){      U = vec4(texture2D(samplerU, tc).r - 128./255.);      V = vec4(texture2D(samplerV, tc).r - 128./255.);  } else {      U = vec4(texture2D(samplerUV, tc).a - 128./255.);      V = vec4(texture2D(samplerUV, tc).r - 128./255.);  }   c += V * vec4(1.596, -0.813, 0, 0);  c += U * vec4(0, -0.392, 2.017, 0);  c.a = 1.0;  gl_FragColor = c;}");
            glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, "vPosition");
        }
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) this.mVertexBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgram, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) this.HlH);
        if (i2 == 0 || i2 == 1) {
            this.HlG[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
            this.HlG[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerU");
            this.HlG[2] = GLES20.glGetUniformLocation(this.mProgram, "samplerV");
            i3 = 3;
        } else if (i2 == 3) {
            this.HlG[0] = GLES20.glGetUniformLocation(this.mProgram, "samplerY");
            this.HlG[1] = GLES20.glGetUniformLocation(this.mProgram, "samplerUV");
        } else {
            i3 = 0;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            GLES20.glActiveTexture(33984 + i4);
            GLES20.glBindTexture(3553, this.HlF[i4].igv);
            GLES20.glUniform1i(this.HlG[i4], i4);
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "yuvType");
        if (glGetUniformLocation >= 0) {
            GLES20.glUniform1i(glGetUniformLocation, i2);
        }
        GLES20.glDrawArrays(5, 0, 4);
        AppMethodBeat.o(115731);
    }
}
