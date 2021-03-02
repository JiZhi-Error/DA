package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;

public final class b implements GLTextureView.m {
    private int EkA;
    private int EkB;
    private final float[] EkC = new float[16];
    private FloatBuffer EkD;
    private FloatBuffer EkE;
    int EkF;
    public float EkG = 0.0f;
    public float EkH = 90.0f;
    public float EkI;
    final float[] EkJ = new float[16];
    protected float EkK = 1.0f;
    protected float EkL = 20.0f;
    protected float EkM = 0.0f;
    private int Ekz;
    protected Context mContext;
    final float[] mMVPMatrix = new float[16];
    private int mProgram;
    private int mSize;

    public b(Context context) {
        AppMethodBeat.i(97272);
        this.mContext = context;
        init();
        AppMethodBeat.o(97272);
    }

    private void init() {
        AppMethodBeat.i(97273);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 50; i2++) {
                for (int i3 = 0; i3 < 50; i3++) {
                    float f2 = (float) (((double) i2) * 0.019999999552965164d);
                    float f3 = (float) (((double) i3) * 0.019999999552965164d);
                    float f4 = (float) (((double) (i2 + 1)) * 0.019999999552965164d);
                    float f5 = (float) (((double) (i3 + 1)) * 0.019999999552965164d);
                    arrayList2.add(Float.valueOf(f3));
                    arrayList2.add(Float.valueOf(f2));
                    arrayList2.add(Float.valueOf((float) (((double) i3) * 0.019999999552965164d)));
                    arrayList2.add(Float.valueOf((float) (((double) (i2 + 1)) * 0.019999999552965164d)));
                    arrayList2.add(Float.valueOf(f5));
                    arrayList2.add(Float.valueOf(f4));
                    arrayList2.add(Float.valueOf(f5));
                    arrayList2.add(Float.valueOf(f4));
                    arrayList2.add(Float.valueOf((float) (((double) (i3 + 1)) * 0.019999999552965164d)));
                    arrayList2.add(Float.valueOf((float) (((double) i2) * 0.019999999552965164d)));
                    arrayList2.add(Float.valueOf(f3));
                    arrayList2.add(Float.valueOf(f2));
                    float sin = (float) (Math.sin((((double) i2) * 0.12566370614359174d) / 2.0d) * Math.cos(((double) i3) * 0.12566370614359174d));
                    float sin2 = (float) (Math.sin((((double) i2) * 0.12566370614359174d) / 2.0d) * Math.sin(((double) i3) * 0.12566370614359174d));
                    float cos = (float) Math.cos((((double) i2) * 0.12566370614359174d) / 2.0d);
                    float sin3 = (float) (Math.sin((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d) * Math.cos(((double) i3) * 0.12566370614359174d));
                    float cos2 = (float) Math.cos((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d);
                    float sin4 = (float) (Math.sin((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d) * Math.cos(((double) (i3 + 1)) * 0.12566370614359174d));
                    float sin5 = (float) (Math.sin((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d) * Math.sin(((double) (i3 + 1)) * 0.12566370614359174d));
                    float cos3 = (float) Math.cos((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d);
                    float sin6 = (float) (Math.sin((((double) i2) * 0.12566370614359174d) / 2.0d) * Math.cos(((double) (i3 + 1)) * 0.12566370614359174d));
                    float cos4 = (float) Math.cos((((double) i2) * 0.12566370614359174d) / 2.0d);
                    arrayList.add(Float.valueOf(sin));
                    arrayList.add(Float.valueOf(cos));
                    arrayList.add(Float.valueOf(sin2));
                    arrayList.add(Float.valueOf(sin3));
                    arrayList.add(Float.valueOf(cos2));
                    arrayList.add(Float.valueOf((float) (Math.sin((((double) (i2 + 1)) * 0.12566370614359174d) / 2.0d) * Math.sin(((double) i3) * 0.12566370614359174d))));
                    arrayList.add(Float.valueOf(sin4));
                    arrayList.add(Float.valueOf(cos3));
                    arrayList.add(Float.valueOf(sin5));
                    arrayList.add(Float.valueOf(sin4));
                    arrayList.add(Float.valueOf(cos3));
                    arrayList.add(Float.valueOf(sin5));
                    arrayList.add(Float.valueOf(sin6));
                    arrayList.add(Float.valueOf(cos4));
                    arrayList.add(Float.valueOf((float) (Math.sin((((double) i2) * 0.12566370614359174d) / 2.0d) * Math.sin(((double) (i3 + 1)) * 0.12566370614359174d))));
                    arrayList.add(Float.valueOf(sin));
                    arrayList.add(Float.valueOf(cos));
                    arrayList.add(Float.valueOf(sin2));
                }
            }
            this.mSize = arrayList.size() / 3;
            float[] fArr = new float[(this.mSize * 2)];
            for (int i4 = 0; i4 < fArr.length; i4++) {
                fArr[i4] = ((Float) arrayList2.get(i4)).floatValue();
            }
            this.EkE = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.EkE.put(fArr);
            this.EkE.position(0);
            float[] fArr2 = new float[(this.mSize * 3)];
            for (int i5 = 0; i5 < fArr2.length; i5++) {
                fArr2[i5] = ((Float) arrayList.get(i5)).floatValue();
            }
            this.EkD = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.EkD.put(fArr2);
            this.EkD.position(0);
            Log.i("SphereImageView.SphereRender", "init, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(97273);
        } catch (Throwable th) {
            Log.e("SphereImageView.SphereRender", "init, exp:" + th.toString());
            AppMethodBeat.o(97273);
        }
    }

    public final void an(float f2, float f3) {
        AppMethodBeat.i(97274);
        Log.i("SphereImageView.SphereRender", "setScaleParams, near=" + f2 + ", far=30.0, z=" + f3);
        if (f2 >= 30.0f) {
            AppMethodBeat.o(97274);
            return;
        }
        this.EkK = f2;
        this.EkL = 30.0f;
        this.EkM = f3;
        AppMethodBeat.o(97274);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.m
    public final void fet() {
        AppMethodBeat.i(97275);
        try {
            Matrix.rotateM(this.EkJ, 0, -this.EkG, 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(this.EkJ, 0, -this.EkH, 0.0f, 1.0f, 0.0f);
            Matrix.rotateM(this.EkJ, 0, -this.EkI, 0.0f, 0.0f, 1.0f);
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.EkF);
            int i2 = this.EkA;
            Matrix.multiplyMM(this.mMVPMatrix, 0, this.EkC, 0, this.EkJ, 0);
            Matrix.setIdentityM(this.EkJ, 0);
            GLES20.glUniformMatrix4fv(i2, 1, false, this.mMVPMatrix, 0);
            GLES20.glDrawArrays(4, 0, this.mSize);
            AppMethodBeat.o(97275);
        } catch (Throwable th) {
            Log.d("SphereImageView.SphereRender", "onDrawFrame, exp=" + th.toString());
            AppMethodBeat.o(97275);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.m
    public final void iF(int i2, int i3) {
        AppMethodBeat.i(97276);
        try {
            Log.i("SphereImageView.SphereRender", "onSurfaceChanged, w=" + i2 + ", h=" + i3 + "， textureID=" + this.EkF + ", near=" + this.EkK + ", far=" + this.EkL + ", z=" + this.EkM);
            long currentTimeMillis = System.currentTimeMillis();
            if (i3 == 0) {
                AppMethodBeat.o(97276);
                return;
            }
            GLES20.glViewport(0, 0, i2, i3);
            GLES20.glEnable(2884);
            float f2 = ((float) i2) / ((float) i3);
            Matrix.frustumM(this.EkC, 0, -f2, f2, -1.0f, 1.0f, this.EkK, this.EkL);
            Matrix.setIdentityM(this.EkJ, 0);
            Matrix.setIdentityM(this.mMVPMatrix, 0);
            Matrix.translateM(this.EkC, 0, 0.0f, 0.0f, this.EkM);
            Matrix.scaleM(this.EkC, 0, 4.0f, 4.0f, 4.0f);
            int glCreateProgram = GLES20.glCreateProgram();
            int glCreateShader = GLES20.glCreateShader(35632);
            int glCreateShader2 = GLES20.glCreateShader(35633);
            GLES20.glShaderSource(glCreateShader2, "attribute vec4 aPosition;attribute vec2 aTextureCoord;uniform mat4 uProjectMatrix;varying vec2 vTextureCoord;void main(){gl_Position = uProjectMatrix * aPosition;\nvTextureCoord = aTextureCoord;\n}");
            GLES20.glShaderSource(glCreateShader, "precision mediump float;varying vec2 vTextureCoord;uniform sampler2D uTexture;void main(){gl_FragColor = texture2D(uTexture, vTextureCoord);}");
            GLES20.glCompileShader(glCreateShader2);
            GLES20.glCompileShader(glCreateShader);
            GLES20.glAttachShader(glCreateProgram, glCreateShader2);
            GLES20.glAttachShader(glCreateProgram, glCreateShader);
            GLES20.glLinkProgram(glCreateProgram);
            this.mProgram = glCreateProgram;
            GLES20.glUseProgram(this.mProgram);
            this.Ekz = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
            this.EkA = GLES20.glGetUniformLocation(this.mProgram, "uProjectMatrix");
            this.EkB = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
            Log.i("SphereImageView.SphereRender", "aPosition:" + this.Ekz);
            Log.i("SphereImageView.SphereRender", "uProjectMatrix:" + this.EkA);
            Log.i("SphereImageView.SphereRender", "aTextureCoord:" + this.EkB);
            GLES20.glVertexAttribPointer(this.Ekz, 3, 5126, false, 0, (Buffer) this.EkD);
            GLES20.glVertexAttribPointer(this.EkB, 2, 5126, false, 0, (Buffer) this.EkE);
            GLES20.glEnableVertexAttribArray(this.Ekz);
            GLES20.glEnableVertexAttribArray(this.EkB);
            Log.i("SphereImageView.SphereRender", "onSurfaceChanged, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(97276);
        } catch (Throwable th) {
            Log.e("SphereImageView.SphereRender", "onSurfaceChanged, exp=" + th.toString());
            AppMethodBeat.o(97276);
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.m
    public final void fes() {
        AppMethodBeat.i(97277);
        Log.i("SphereImageView.SphereRender", "onSurfaceCreated");
        AppMethodBeat.o(97277);
    }
}
