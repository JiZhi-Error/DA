package com.tencent.mm.plugin.voip.video.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.cm.a.k;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.video.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class g implements GLSurfaceView.Renderer {
    public int FfM;
    public boolean HiC = false;
    public k HkU;
    public int HkV = 5;
    public float HkW = 0.0f;
    public volatile d Hma;
    public volatile c Hmb;
    private int Hmc = 0;
    private int Hmd = 0;
    public boolean Hme = false;
    public int Hmf = 3;
    public ByteBuffer Hmg = ByteBuffer.allocate(0);
    public ByteBuffer Hmh = ByteBuffer.allocate(0);
    public ByteBuffer Hmi = ByteBuffer.allocate(0);
    public ByteBuffer Hmj = ByteBuffer.allocate(0);
    public boolean Hmk;
    public int Hml = 0;
    public int Hmm = 0;
    public boolean Hmn = false;
    public volatile boolean Hmo = false;
    public int Hmp = 0;
    public int Hmq = 0;
    public int Hmr = 0;
    private final String TAG = "MicroMsg.VoipRenderer";
    public int hEm = 0;
    private volatile boolean ijr = false;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public int mVideoHeight = 0;
    public int mVideoWidth = 0;
    public ByteBuffer y = ByteBuffer.allocate(0);

    public g() {
        AppMethodBeat.i(115744);
        AppMethodBeat.o(115744);
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(115745);
        Log.i("MicroMsg.VoipRenderer", "onSurfaceCreated and render type is %s", Integer.valueOf(this.hEm));
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        if (this.Hma == null) {
            this.Hma = new d();
        }
        if (this.Hmb == null) {
            this.Hmb = new c();
        }
        this.HkU = new k();
        this.Hmp = 0;
        this.Hmq = 0;
        AppMethodBeat.o(115745);
    }

    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        AppMethodBeat.i(115746);
        Log.i("MicroMsg.VoipRenderer", "onSurfaceChanged and render type is %s, dataType is %s ", Integer.valueOf(this.hEm), Integer.valueOf(this.Hmf));
        GLES20.glViewport(0, 0, i2, i3);
        if (this.Hma == null) {
            this.Hma = new d();
        }
        if (this.Hmb == null) {
            this.Hmb = new c();
        }
        this.mScreenHeight = i3;
        this.mScreenWidth = i2;
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            aE(this.mVideoWidth, this.mVideoHeight, this.Hmr);
        }
        if (this.Hma != null) {
            d dVar = this.Hma;
            Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged, width: %s, height: %s, surfaceWidth: %s, surfaceHeight: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(dVar.surfaceWidth), Integer.valueOf(dVar.surfaceHeight));
            if (!(i2 == dVar.surfaceWidth && dVar.surfaceHeight == i3)) {
                dVar.surfaceWidth = i2;
                dVar.surfaceHeight = i3;
                b bVar = dVar.HlI;
                Log.i("MicroMsg.VoipGLSProgram", "onSurfaceChanged: %s %s", Integer.valueOf(i2), Integer.valueOf(i3));
                bVar.surfaceWidth = i2;
                bVar.surfaceHeight = i3;
                f fVar = dVar.HkZ;
                fVar.surfaceWidth = i2;
                fVar.surfaceHeight = i3;
            }
        }
        this.Hmn = true;
        Log.d("MicroMsg.VoipRenderer", "onSurfaceChanged width: %s * height: %s , and video size is width %s * height %s ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight));
        AppMethodBeat.o(115746);
    }

    public final void adY(int i2) {
        AppMethodBeat.i(115747);
        if (this.hEm != i2) {
            Log.i("MicroMsg.VoipRenderer", "setRenderType: %s, screenWidth: %s, screenHeight: %s", Integer.valueOf(i2), Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight));
            this.hEm = i2;
            if (i2 != 1 && this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                aE(this.mVideoWidth, this.mVideoHeight, this.Hmr);
            }
        }
        AppMethodBeat.o(115747);
    }

    public final void jK(int i2, int i3) {
        AppMethodBeat.i(115748);
        Log.i("MicroMsg.VoipRenderer", "setHWDecVideoSize: width:%s, height:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.Hmc = i2;
        this.Hmd = i3;
        a(this.Hmc, this.Hmd, c.ilm, c.HlE);
        AppMethodBeat.o(115748);
    }

    public final void onDrawFrame(GL10 gl10) {
        boolean z;
        d dVar;
        boolean z2;
        AppMethodBeat.i(115749);
        synchronized (this) {
            try {
                GLES20.glViewport(0, 0, this.mScreenWidth, this.mScreenHeight);
                GLES20.glClear(16640);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                if (this.ijr) {
                    Log.i("MicroMsg.VoipRenderer", "onDrawFrame clearFrame, renderType:%s", Integer.valueOf(this.hEm));
                    this.ijr = false;
                    if (this.hEm == 1 && this.Hmb != null) {
                        this.Hmb.updateTexImage();
                    }
                    return;
                }
                if (this.hEm == 0) {
                    if (!this.Hmo || this.Hma == null) {
                        Log.e("MicroMsg.VoipRenderer", "render soft draw error, cannot draw yuv now");
                    } else {
                        if (this.y.capacity() == this.mVideoHeight * this.mVideoWidth) {
                            this.y.position(0);
                            int i2 = (this.mVideoHeight * this.mVideoWidth) / 4;
                            if (this.Hmf == 3) {
                                if (this.Hmj.capacity() == i2 * 2) {
                                    this.Hmj.position(0);
                                    d dVar2 = this.Hma;
                                    ByteBuffer byteBuffer = this.y;
                                    ByteBuffer byteBuffer2 = this.Hmj;
                                    int i3 = this.mVideoWidth;
                                    int i4 = this.mVideoHeight;
                                    dVar2.a(byteBuffer, i3, i4, 0);
                                    dVar2.HlF[1].a(i3 / 2, i4 / 2, 6410, byteBuffer2, 9729, 33071);
                                } else {
                                    Log.e("MicroMsg.VoipRenderer", "RENDER_NV21 draw error, uv buffer size not match, uv.capacity:%s, videoSize:%sx%s", Integer.valueOf(this.Hmj.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight));
                                }
                            } else if (this.Hmh.capacity() == i2 && this.Hmi.capacity() == i2) {
                                this.Hmh.position(0);
                                this.Hmi.position(0);
                                d dVar3 = this.Hma;
                                ByteBuffer byteBuffer3 = this.y;
                                ByteBuffer byteBuffer4 = this.Hmh;
                                ByteBuffer byteBuffer5 = this.Hmi;
                                int i5 = this.mVideoWidth;
                                int i6 = this.mVideoHeight;
                                dVar3.a(byteBuffer3, i5, i6, 0);
                                dVar3.a(byteBuffer4, i5 / 2, i6 / 2, 1);
                                dVar3.a(byteBuffer5, i5 / 2, i6 / 2, 2);
                            } else {
                                Log.e("MicroMsg.VoipRenderer", "RENDER_YV12/RENDER_YV12Edge draw error, uv buffer size not match, u.capacity:%s, v.capacity:%s, videoSize:%sx%s", Integer.valueOf(this.Hmh.capacity()), Integer.valueOf(this.Hmi.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight));
                            }
                        } else {
                            Log.e("MicroMsg.VoipRenderer", "draw error, y buffer size not match, y.capacity:%s, videoSize:%sx%s", Integer.valueOf(this.y.capacity()), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight));
                        }
                        try {
                            if (this.Hmm == 1) {
                                d dVar4 = this.Hma;
                                int i7 = this.HkV;
                                float f2 = this.HkW;
                                if (dVar4.HlO) {
                                    dVar4.HkZ.apH(i7);
                                    dVar4.HkZ.cH(f2);
                                }
                            }
                            d dVar5 = this.Hma;
                            int i8 = this.Hmf;
                            int i9 = this.Hml;
                            boolean z3 = this.HiC;
                            if (i8 == 0 || i8 == 1) {
                                dVar5.HlM = false;
                                dVar = dVar5;
                            } else {
                                if ((i9 & 8) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                dVar5.HlM = z2;
                                if ((i9 & 32) != 0) {
                                    z = true;
                                    dVar = dVar5;
                                    dVar.HlO = z;
                                    if (z3 && !(dVar5.HlM == dVar5.HlN && dVar5.HlO == dVar5.HlP)) {
                                        dVar5.HlN = dVar5.HlM;
                                        dVar5.HlP = dVar5.HlO;
                                        if (!dVar5.HlO && dVar5.HlM) {
                                            dVar5.HlI.rl(dVar5.HlK.igv);
                                            dVar5.HkZ.apK(dVar5.HlK.igv);
                                            dVar5.HkZ.DA(false);
                                        } else if (!dVar5.HlO && !dVar5.HlM) {
                                            dVar5.HkZ.DA(true);
                                        } else if (!dVar5.HlO && dVar5.HlM) {
                                            dVar5.HlI.rl(dVar5.HlJ.igv);
                                        }
                                    }
                                    if (!dVar5.HlO && dVar5.HlM) {
                                        dVar5.HlJ.a(dVar5.HlL, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.d(dVar5.HlT, dVar5.HlU);
                                        GLES20.glViewport(0, 0, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.adX(i8);
                                        d.aMY();
                                        dVar5.HkZ.apK(dVar5.HlK.igv);
                                        int i10 = dVar5.HlJ.igv;
                                        dVar5.b(dVar5.HlR, dVar5.HlS, dVar5.HlQ);
                                        dVar5.HkZ.a(dVar5.HlJ.igv, i10, i10, dVar5.HkX, dVar5.HkY);
                                        d.aMY();
                                        dVar5.HlI.c(dVar5.HlR, dVar5.HlS);
                                        dVar5.HlI.fLD();
                                        d.aMY();
                                    } else if (!dVar5.HlO && !dVar5.HlM) {
                                        dVar5.HlJ.a(dVar5.HlL, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.d(dVar5.HlT, dVar5.HlU);
                                        GLES20.glViewport(0, 0, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.adX(i8);
                                        d.aMY();
                                        int i11 = dVar5.HlJ.igv;
                                        dVar5.b(dVar5.HlR, dVar5.HlS, dVar5.HlQ);
                                        dVar5.HkZ.a(dVar5.HlJ.igv, i11, i11, dVar5.HkX, dVar5.HkY);
                                        d.aMY();
                                    } else if (!dVar5.HlO || !dVar5.HlM) {
                                        dVar5.adX(i8);
                                    } else {
                                        dVar5.HlJ.a(dVar5.HlL, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.d(dVar5.HlT, dVar5.HlU);
                                        GLES20.glViewport(0, 0, dVar5.outputWidth, dVar5.outputHeight);
                                        dVar5.adX(i8);
                                        d.aMY();
                                        dVar5.HlI.c(dVar5.HlR, dVar5.HlS);
                                        dVar5.HlI.fLD();
                                        d.aMY();
                                    }
                                    d.aMY();
                                } else {
                                    dVar = dVar5;
                                }
                            }
                            z = false;
                            dVar.HlO = z;
                            dVar5.HlN = dVar5.HlM;
                            dVar5.HlP = dVar5.HlO;
                            if (!dVar5.HlO) {
                            }
                            if (!dVar5.HlO) {
                            }
                            dVar5.HlI.rl(dVar5.HlJ.igv);
                            if (!dVar5.HlO) {
                            }
                            if (!dVar5.HlO) {
                            }
                            if (!dVar5.HlO) {
                            }
                            dVar5.adX(i8);
                            d.aMY();
                        } catch (Exception e2) {
                            Log.w("MicroMsg.VoipRenderer", e2.getMessage());
                        }
                    }
                    this.Hmo = false;
                } else if (this.Hmb != null) {
                    this.Hmq++;
                    if (this.Hmq % 100 == 0) {
                        Log.i("MicroMsg.VoipRenderer", "steve: remote HW texture videoSize:%sx%s, mHardDrawCnt:%d", Integer.valueOf(this.Hmc), Integer.valueOf(this.Hmd), Integer.valueOf(this.Hmq));
                    }
                    a(this.Hmc, this.Hmd, c.ilm, c.HlE);
                    c cVar = this.Hmb;
                    if (cVar.surfaceTexture != null) {
                        try {
                            cVar.updateTexImage();
                            GLES20.glUseProgram(cVar.HlC);
                            int glGetAttribLocation = GLES20.glGetAttribLocation(cVar.HlC, "vPosition");
                            int glGetAttribLocation2 = GLES20.glGetAttribLocation(cVar.HlC, "vTexCoord");
                            int glGetUniformLocation = GLES20.glGetUniformLocation(cVar.HlC, "sTexture");
                            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) cVar.mVertexBuffer);
                            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
                            GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) cVar.HlD);
                            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
                            GLES20.glActiveTexture(33984);
                            GLES20.glBindTexture(36197, cVar.HcD.igv);
                            GLES20.glUniform1i(glGetUniformLocation, 0);
                            GLES20.glBindFramebuffer(36160, 0);
                            GLES20.glDrawArrays(5, 0, 4);
                            GLES20.glFinish();
                            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
                            GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
                            GLES20.glBindTexture(36197, 0);
                        } catch (Exception e3) {
                            Log.printErrStackTrace("MicroMsg.VoipGLHProgram", e3, "renderThis error", new Object[0]);
                        }
                    }
                }
                AppMethodBeat.o(115749);
            } finally {
                AppMethodBeat.o(115749);
            }
        }
    }

    public final void aE(int i2, int i3, int i4) {
        AppMethodBeat.i(235903);
        if (!(this.hEm == 1 || this.Hma == null)) {
            if (this.Hmf == 0 || this.Hmf == 1) {
                a(i2, i3, true, this.Hma.HlS, this.Hma.HlR, 0);
                AppMethodBeat.o(235903);
                return;
            }
            a(i2, i3, false, this.Hma.HlS, this.Hma.HlR, i4);
        }
        AppMethodBeat.o(235903);
    }

    private void a(int i2, int i3, boolean z, float[] fArr, float[] fArr2, int i4) {
        float f2;
        float f3;
        float f4;
        AppMethodBeat.i(235904);
        float f5 = 0.0f;
        float f6 = 0.0f;
        if (i4 == 90 || i4 == 270) {
            if (z) {
                float f7 = 0.005f + ((64.0f / ((float) i2)) / 2.0f);
                float f8 = ((64.0f / ((float) i3)) / 2.0f) + 0.005f;
                int i5 = i2 - 64;
                int i6 = i3 - 64;
                if (this.mScreenHeight * i5 < this.mScreenWidth * i6) {
                    f6 = (0.5f - (((((float) i5) * 1.0f) * ((float) this.mScreenHeight)) / ((2.0f * ((float) i3)) * ((float) this.mScreenWidth)))) + 0.005f;
                } else {
                    f5 = (0.5f - (((1.0f * ((float) i6)) * ((float) this.mScreenWidth)) / ((2.0f * ((float) i2)) * ((float) this.mScreenHeight)))) + 0.005f;
                }
                if (f5 <= f7) {
                    f5 = f7;
                }
                if (f6 <= f8) {
                    f6 = f8;
                }
                f2 = f5;
            } else if (this.mScreenHeight * i2 < this.mScreenWidth * i3) {
                f6 = 0.5f - (((1.0f * ((float) i2)) * ((float) this.mScreenHeight)) / ((2.0f * ((float) i3)) * ((float) this.mScreenWidth)));
                f2 = 0.0f;
            } else {
                f2 = 0.5f - (((1.0f * ((float) i3)) * ((float) this.mScreenWidth)) / ((2.0f * ((float) i2)) * ((float) this.mScreenHeight)));
            }
        } else if (z) {
            float f9 = 0.005f + ((64.0f / ((float) i2)) / 2.0f);
            float f10 = ((64.0f / ((float) i3)) / 2.0f) + 0.005f;
            int i7 = i2 - 64;
            int i8 = i3 - 64;
            if (this.mScreenWidth * i7 < this.mScreenHeight * i8) {
                f6 = (0.5f - (((((float) i7) * 1.0f) * ((float) this.mScreenWidth)) / ((2.0f * ((float) i3)) * ((float) this.mScreenHeight)))) + 0.005f;
            } else {
                f5 = (0.5f - (((1.0f * ((float) i8)) * ((float) this.mScreenHeight)) / ((2.0f * ((float) i2)) * ((float) this.mScreenWidth)))) + 0.005f;
            }
            if (f5 <= f9) {
                f5 = f9;
            }
            if (f6 <= f10) {
                f6 = f10;
            }
            f2 = f5;
        } else if (this.mScreenWidth * i2 < this.mScreenHeight * i3) {
            f6 = 0.5f - (((1.0f * ((float) i2)) * ((float) this.mScreenWidth)) / ((2.0f * ((float) i3)) * ((float) this.mScreenHeight)));
            f2 = 0.0f;
        } else {
            f2 = 0.5f - (((1.0f * ((float) i3)) * ((float) this.mScreenHeight)) / ((2.0f * ((float) i2)) * ((float) this.mScreenWidth)));
        }
        switch (this.FfM) {
            case 1:
                fArr[0] = f2;
                fArr[1] = this.Hmk ? 1.0f - f6 : f6;
                fArr[2] = 1.0f - f2;
                if (this.Hmk) {
                    f3 = 1.0f - f6;
                } else {
                    f3 = f6;
                }
                fArr[3] = f3;
                fArr[4] = f2;
                fArr[5] = this.Hmk ? f6 : 1.0f - f6;
                fArr[6] = 1.0f - f2;
                if (!this.Hmk) {
                    f6 = 1.0f - f6;
                }
                fArr[7] = f6;
                fArr2[0] = 1.0f;
                fArr2[1] = 1.0f;
                fArr2[2] = 1.0f;
                fArr2[3] = -1.0f;
                fArr2[4] = -1.0f;
                fArr2[5] = 1.0f;
                fArr2[6] = -1.0f;
                fArr2[7] = -1.0f;
                break;
            case 3:
                fArr[0] = f2;
                fArr[1] = this.Hmk ? 1.0f - f6 : f6;
                fArr[2] = 1.0f - f2;
                if (this.Hmk) {
                    f4 = 1.0f - f6;
                } else {
                    f4 = f6;
                }
                fArr[3] = f4;
                fArr[4] = f2;
                fArr[5] = this.Hmk ? f6 : 1.0f - f6;
                fArr[6] = 1.0f - f2;
                if (!this.Hmk) {
                    f6 = 1.0f - f6;
                }
                fArr[7] = f6;
                fArr2[0] = -1.0f;
                fArr2[1] = -1.0f;
                fArr2[2] = -1.0f;
                fArr2[3] = 1.0f;
                fArr2[4] = 1.0f;
                fArr2[5] = -1.0f;
                fArr2[6] = 1.0f;
                fArr2[7] = 1.0f;
                break;
        }
        c.e(i4, fArr);
        if (this.Hma != null) {
            this.Hma.d(fArr2, fArr);
        }
        AppMethodBeat.o(235904);
    }

    private void a(int i2, int i3, float[] fArr, float[] fArr2) {
        float f2;
        float f3;
        AppMethodBeat.i(115752);
        if (this.mScreenWidth * i3 < this.mScreenHeight * i2) {
            f3 = 0.5f - (((((float) i3) * 1.0f) * ((float) this.mScreenWidth)) / ((((float) i2) * 2.0f) * ((float) this.mScreenHeight)));
            f2 = 0.0f;
        } else {
            f2 = 0.5f - (((((float) i2) * 1.0f) * ((float) this.mScreenHeight)) / ((((float) i3) * 2.0f) * ((float) this.mScreenWidth)));
            f3 = 0.0f;
        }
        fArr2[0] = f2;
        fArr2[1] = 1.0f - f3;
        fArr2[2] = 1.0f - f2;
        fArr2[3] = 1.0f - f3;
        fArr2[4] = f2;
        fArr2[5] = f3;
        fArr2[6] = 1.0f - f2;
        fArr2[7] = f3;
        fArr[0] = -1.0f;
        fArr[1] = 1.0f;
        fArr[2] = -1.0f;
        fArr[3] = -1.0f;
        fArr[4] = 1.0f;
        fArr[5] = 1.0f;
        fArr[6] = 1.0f;
        fArr[7] = -1.0f;
        if (this.Hmb != null) {
            this.Hmb.d(fArr, fArr2);
        }
        AppMethodBeat.o(115752);
    }

    public final boolean fLM() {
        AppMethodBeat.i(115753);
        Log.printInfoStack("MicroMsg.VoipRenderer", "attachGLContext isContextAttached:%b, mHProgram:%s", Boolean.valueOf(this.Hme), this.Hmb);
        if (!this.Hme && this.Hmb != null) {
            try {
                t tVar = t.GYO;
                t.fHB();
                c cVar = this.Hmb;
                c.fLG();
                this.Hme = true;
                Log.i("MicroMsg.VoipRenderer", "attachGLContext done!");
            } catch (Exception e2) {
                this.Hme = false;
                Log.printErrStackTrace("MicroMsg.VoipRenderer", e2, "attachGLContext error!", new Object[0]);
                t tVar2 = t.GYO;
                t.fHC();
            }
        }
        boolean z = this.Hme;
        AppMethodBeat.o(115753);
        return z;
    }

    public final boolean fLN() {
        AppMethodBeat.i(115754);
        Log.printInfoStack("MicroMsg.VoipRenderer", "detachGLContext isContextAttached:%b!", Boolean.valueOf(this.Hme));
        if (this.Hme && this.Hmb != null) {
            try {
                t tVar = t.GYO;
                t.fHD();
                c cVar = this.Hmb;
                c.fLH();
                this.Hme = false;
                Log.i("MicroMsg.VoipRenderer", "detachGLContext done!");
            } catch (Exception e2) {
                this.Hme = true;
                Log.printErrStackTrace("MicroMsg.VoipRenderer", e2, "detachGLContext error!", new Object[0]);
                t tVar2 = t.GYO;
                t.fHE();
            }
        }
        boolean z = this.Hme;
        AppMethodBeat.o(115754);
        return z;
    }

    public final void a(SurfaceTexture surfaceTexture, d dVar) {
        AppMethodBeat.i(115755);
        if (this.Hmb != null) {
            this.Hmb.a(surfaceTexture, dVar);
        }
        AppMethodBeat.o(115755);
    }

    public final a fLJ() {
        AppMethodBeat.i(115756);
        if (this.Hma != null) {
            a fLJ = this.Hma.fLJ();
            AppMethodBeat.o(115756);
            return fLJ;
        }
        AppMethodBeat.o(115756);
        return null;
    }

    public final b fJk() {
        AppMethodBeat.i(235905);
        if (this.Hma != null) {
            b fJk = this.Hma.fJk();
            AppMethodBeat.o(235905);
            return fJk;
        }
        AppMethodBeat.o(235905);
        return null;
    }
}
