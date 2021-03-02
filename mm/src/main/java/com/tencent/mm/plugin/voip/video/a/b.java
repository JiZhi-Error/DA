package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.f;
import com.tencent.mm.cm.a.k;
import com.tencent.mm.media.g.a;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public final class b {
    public static final float[] Hkt = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] ilm = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] iln = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    int HiD;
    public int HkA;
    public int HkB;
    public FloatBuffer HkC;
    public FloatBuffer HkD;
    private ByteBuffer HkE;
    public float[] HkF = ilm;
    public float[] HkG;
    public a HkH;
    public a HkI;
    public d HkJ;
    public d HkK;
    private int HkL;
    private int HkM;
    public volatile a HkN = null;
    private boolean HkO = false;
    public byte[] HkP;
    public byte[] HkQ;
    private com.tencent.mm.plugin.voip.video.b.a HkR = new com.tencent.mm.plugin.voip.video.b.a(this.kxW, this.kxX, 2, null);
    public l HkS;
    public int HkT;
    public k HkU;
    private int HkV = 5;
    private float HkW = 0.0f;
    private FloatBuffer HkX;
    private FloatBuffer HkY;
    public f HkZ;
    public d Hku;
    public d Hkv;
    public int Hkw;
    public d Hkx;
    public int Hky;
    public int Hkz;
    private int dYT;
    private int gRD;
    private int gRE;
    public FloatBuffer hDT;
    public FloatBuffer hDU;
    public d hEv;
    public volatile boolean htU = false;
    private boolean iju;
    public int ikB;
    public int ikC;
    public int ikD;
    public int ikE;
    public int ikH;
    private ByteBuffer ikI;
    public int ikO;
    private ByteBuffer ikP;
    private int kxW;
    private int kxX;
    private float[] kyb = new float[16];
    public float[] kyd = ilm;
    private int orientation;

    public b() {
        AppMethodBeat.i(115706);
        AppMethodBeat.o(115706);
    }

    public final void jj(int i2, int i3) {
        this.gRD = i2;
        this.gRE = i3;
    }

    public final synchronized void b(byte[] bArr, int i2, int i3, int i4, int i5, int i6) {
        boolean z;
        int i7;
        int i8;
        int i9;
        AppMethodBeat.i(235893);
        if (this.kxW == i2 && this.kxX == i3 && this.orientation == i6) {
            z = false;
        } else {
            z = true;
        }
        if (this.HkT != 0) {
            this.HkV = this.HkU.R(bArr, i2, i3);
            this.HkW = this.HkU.hff();
            this.HkZ.apH(this.HkV);
            this.HkZ.cH(this.HkW);
        }
        this.kxW = i2;
        this.kxX = i3;
        this.orientation = i6;
        int i10 = (i4 >> 2) & 3;
        if (i10 == 3) {
            this.dYT = 270;
        } else if (i10 == 1) {
            this.dYT = 90;
        }
        this.iju = ((i4 >> 4) & 1) == 1;
        this.HkO = OpenGlRender.His != 1;
        this.HiD = i5;
        if (this.HkN == null && i5 != 0) {
            if (this.HkT != 0) {
                this.HkN = new a();
                this.HkN.a(this.HkK, this.hEv, i5);
            } else {
                this.HkN = new a();
                this.HkN.a(this.HkJ, this.hEv, i5);
            }
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.HkO) {
            if (!(this.ikB == 0 || this.Hku == null || this.Hkv == null || this.kxW <= 0 || this.kxX <= 0 || bArr == null)) {
                if (this.ikI == null || this.ikP == null || this.ikI.capacity() != this.kxX * this.kxW || this.ikP.capacity() != (this.kxW * this.kxX) / 2) {
                    this.ikI = ByteBuffer.allocateDirect(this.kxX * this.kxW);
                    this.ikP = ByteBuffer.allocateDirect((this.kxW * this.kxX) / 2);
                    this.ikI.order(ByteOrder.nativeOrder());
                    this.ikP.order(ByteOrder.nativeOrder());
                }
                this.ikI.put(bArr, 0, this.kxW * this.kxX);
                this.ikI.position(0);
                this.ikP.put(bArr, this.kxW * this.kxX, (this.kxW * this.kxX) / 2);
                this.ikP.position(0);
                this.HkL = (this.dYT == 180 || this.dYT == 0) ? this.kxW : this.kxX;
                this.HkM = (this.dYT == 180 || this.dYT == 0) ? this.kxX : this.kxW;
                this.HkJ.a(this.HkH, this.HkL, this.HkM);
                GLES20.glViewport(0, 0, this.HkL, this.HkM);
                GLES20.glUseProgram(this.ikB);
                GLES20.glActiveTexture(33984);
                this.Hku.a(this.kxW, this.kxX, 6409, this.ikI, 9729, 33071);
                GLES20.glUniform1i(this.ikE, 0);
                GLES20.glActiveTexture(33985);
                this.Hkv.a(this.kxW / 2, this.kxX / 2, 6410, this.ikP, 9729, 33071);
                GLES20.glUniform1i(this.ikO, 1);
                Matrix.setIdentityM(this.kyb, 0);
                Matrix.setRotateM(this.kyb, 0, (float) this.dYT, 0.0f, 0.0f, -1.0f);
                if (this.iju) {
                    Matrix.scaleM(this.kyb, 0, -1.0f, 1.0f, 1.0f);
                } else {
                    Matrix.scaleM(this.kyb, 0, 1.0f, 1.0f, 1.0f);
                }
                GLES20.glUniformMatrix4fv(this.ikH, 1, false, this.kyb, 0);
                this.hDU.position(0);
                GLES20.glVertexAttribPointer(this.ikD, 2, 5126, false, 0, (Buffer) this.hDU);
                GLES20.glEnableVertexAttribArray(this.ikD);
                this.hDT.position(0);
                GLES20.glVertexAttribPointer(this.ikC, 2, 5126, false, 0, (Buffer) this.hDT);
                GLES20.glEnableVertexAttribArray(this.ikC);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisableVertexAttribArray(this.ikD);
                GLES20.glDisableVertexAttribArray(this.ikC);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glUseProgram(0);
                GLES20.glFinish();
            }
        } else if (!(this.Hkw == 0 || this.HkJ == null || this.kxW <= 0 || this.kxX <= 0 || bArr == null)) {
            if (this.HkE == null || this.HkE.capacity() != this.kxX * this.kxW * 4) {
                this.HkE = ByteBuffer.allocateDirect(this.kxX * this.kxW * 4);
                this.HkE.order(ByteOrder.nativeOrder());
            }
            this.HkE.put(bArr, 0, this.kxW * this.kxX * 4);
            this.HkE.position(0);
            this.HkL = (this.dYT == 180 || this.dYT == 0) ? this.kxW : this.kxX;
            this.HkM = (this.dYT == 180 || this.dYT == 0) ? this.kxX : this.kxW;
            this.HkJ.a(this.HkH, this.HkL, this.HkM);
            GLES20.glUseProgram(this.Hkw);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.Hkx.igv);
            GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.HkL, this.HkM, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.HkE);
            GLES20.glUniform1i(this.HkA, 0);
            Matrix.setIdentityM(this.kyb, 0);
            Matrix.setRotateM(this.kyb, 0, (float) this.dYT, 0.0f, 0.0f, -1.0f);
            if (this.iju) {
                Matrix.scaleM(this.kyb, 0, 1.0f, -1.0f, 1.0f);
            }
            GLES20.glUniformMatrix4fv(this.HkB, 1, false, this.kyb, 0);
            this.hDU.position(0);
            GLES20.glVertexAttribPointer(this.Hkz, 2, 5126, false, 0, (Buffer) this.hDU);
            GLES20.glEnableVertexAttribArray(this.Hkz);
            this.hDT.position(0);
            GLES20.glVertexAttribPointer(this.Hky, 2, 5126, false, 0, (Buffer) this.hDT);
            GLES20.glEnableVertexAttribArray(this.Hky);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.Hkz);
            GLES20.glDisableVertexAttribArray(this.Hky);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        if (i5 != 0 && (this.HkP == null || z)) {
            Log.i("MicroMsg.FilterRenderer", "%s frameSizeChange %s %s %s %s", Integer.valueOf(hashCode()), Integer.valueOf(this.HkL), Integer.valueOf(this.HkM), Integer.valueOf(this.gRD), Integer.valueOf(this.gRE));
            this.HkP = new byte[(this.HkL * this.HkM * 4)];
            this.HkN.Hkp = this.HkP;
        }
        if (!(this.HkT == 0 || this.HkZ == null)) {
            this.HkZ.apK(this.HkK.igv);
            if (z) {
                this.HkZ.lS(this.HkL, this.HkM);
            }
        }
        if (!(this.HkT == 0 || this.HkZ == null)) {
            int i11 = this.HkJ.igv;
            float[] fArr = ilm;
            float[] fArr2 = iln;
            float[] fArr3 = Hkt;
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
            this.HkZ.a(this.HkJ.igv, i11, i11, this.HkX, this.HkY);
        }
        if (i5 != 0) {
            a aVar = this.HkN;
            int i12 = this.HkL;
            int i13 = this.HkM;
            if (!(i13 == aVar.hDo && i12 == aVar.hDn)) {
                Log.i("MicroMsg.FilterProcessTex", "updateTextureSize:%s, %s", Integer.valueOf(i12), Integer.valueOf(i13));
            }
            aVar.hDn = i12;
            aVar.hDo = i13;
            if (aVar.hiH != null) {
                aVar.hiH.setSize(i12, i13);
            }
            aVar.BXr.cZ(i12, i13);
            aVar.Hkq = null;
            if (this.HkT == 0 || this.HkZ == null) {
                this.HkN.Hko = this.HkJ;
            } else {
                this.HkN.Hko = this.HkK;
            }
            a aVar2 = this.HkN;
            int i14 = this.dYT;
            Log.d("MicroMsg.FilterProcessTex", "setOutputRotate:%s", Integer.valueOf(i14));
            aVar2.Hkr = i14;
            aVar2.BXr.qx(i14);
            a aVar3 = this.HkN;
            long currentTicks = Util.currentTicks();
            try {
                aVar3.hiH.c(aVar3.Hko);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindTexture(3553, 0);
                aVar3.hDm.a(aVar3.hDn, aVar3.hDo, NativeBitmapStruct.GLFormat.GL_RGBA, null, 9729, 10497);
                GLES20.glViewport(0, 0, aVar3.hDn, aVar3.hDo);
                com.tencent.mm.plugin.xlabeffect.b.a(aVar3.hiH, aVar3.Hko, aVar3.hDm, false, 48);
                GLES20.glFinish();
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glBindTexture(3553, 0);
                if (aVar3.hDm == null) {
                    Log.e("MicroMsg.FilterProcessTex", "saveRenderOutputToBuffer, outputTexture is null");
                } else {
                    Log.d("MicroMsg.FilterProcessTex", "saveRenderOutputToBuffer, textureWidth:%s, textureHeight:%s, rotate:%s", Integer.valueOf(aVar3.hDn), Integer.valueOf(aVar3.hDo), Integer.valueOf(aVar3.Hkr));
                    if (aVar3.Hkr == 90 || aVar3.Hkr == 270) {
                        i8 = aVar3.hDo;
                        i9 = aVar3.hDn;
                    } else {
                        i8 = aVar3.hDn;
                        i9 = aVar3.hDo;
                    }
                    aVar3.BXr.cY(i8, i9);
                    aVar3.BXr.cZ(aVar3.hDn, aVar3.hDo);
                    aVar3.BXr.rl(aVar3.hDm.igv);
                    aVar3.BXr.ijM = true;
                    aVar3.BXr.aED();
                    c.aMY();
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FilterProcessTex", e2, "filterProcess error", new Object[0]);
            }
            Log.d("MicroMsg.FilterProcessTex", "filterProcess: cost %s", Long.valueOf(Util.ticksToNow(currentTicks)));
            this.HkS.hDl = this.hEv.igv;
        } else {
            this.HkS.hDl = this.HkJ.igv;
        }
        if (this.iju) {
            if (i6 == 0 || i6 == 180) {
                i6 = TXLiveConstants.RENDER_ROTATION_180;
            }
            this.HkS.qx(i6);
        } else {
            if (i6 == 0 || i6 == 180) {
                i7 = 0;
            } else {
                i7 = (360 - i6) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            this.HkS.qx(i7);
        }
        this.HkS.iju = true;
        this.HkS.cY(this.gRD, this.gRE);
        this.HkS.cZ(this.kxX, this.kxW);
        this.HkS.aED();
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(235893);
    }

    public final synchronized void destroy() {
        AppMethodBeat.i(115709);
        if (!this.htU) {
            AppMethodBeat.o(115709);
        } else {
            Log.i("MicroMsg.FilterRenderer", "%s do destroy", Integer.valueOf(hashCode()));
            if (this.HkN != null) {
                a aVar = this.HkN;
                Log.i("MicroMsg.FilterProcessTex", "clear %s %d", aVar, Long.valueOf(Thread.currentThread().getId()));
                try {
                    if (aVar.hiH != null) {
                        aVar.hiH.destroy();
                        aVar.hiH = null;
                    }
                    aVar.Hkp = null;
                    aVar.Hkq = null;
                    aVar.bfY = false;
                    if (aVar.BXr != null) {
                        aVar.BXr.release();
                        aVar.BXr = null;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FilterProcessTex", e2, "clear error: %s", e2.getMessage());
                }
                this.HkN = null;
            }
            if (this.HkS != null) {
                this.HkS.release();
                this.HkS = null;
            }
            if (this.HkZ != null) {
                this.HkZ.onDestroy();
            }
            d[] dVarArr = {this.Hku, this.Hkv, this.Hkx, this.HkJ, this.hEv};
            for (int i2 = 0; i2 < 5; i2++) {
                d dVar = dVarArr[i2];
                if (dVar != null) {
                    dVar.close();
                }
            }
            if (this.HkH != null) {
                this.HkH.close();
            }
            if (this.HkI != null) {
                this.HkI.close();
            }
            GLES20.glDeleteProgram(this.ikB);
            GLES20.glDeleteProgram(this.Hkw);
            this.HkP = null;
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glClear(16640);
            GLES20.glFinish();
            if (this.ikI != null) {
                this.ikI.clear();
            }
            if (this.ikP != null) {
                this.ikP.clear();
            }
            this.ikI = null;
            this.ikP = null;
            this.htU = false;
            AppMethodBeat.o(115709);
        }
    }

    public static d fLz() {
        AppMethodBeat.i(115710);
        d a2 = com.tencent.mm.media.g.c.a(true, 14);
        AppMethodBeat.o(115710);
        return a2;
    }

    private static int ac(String str, int i2) {
        AppMethodBeat.i(115711);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(115711);
            return 0;
        }
        AppMethodBeat.o(115711);
        return glCreateShader;
    }

    public static int aB(String str, String str2) {
        AppMethodBeat.i(115712);
        int[] iArr = new int[1];
        int ac = ac(str, 35633);
        if (ac == 0) {
            Log.e("MicroMsg.FilterRenderer", "load vertex shader failed");
            AppMethodBeat.o(115712);
            return 0;
        }
        int ac2 = ac(str2, 35632);
        if (ac2 == 0) {
            Log.e("MicroMsg.FilterRenderer", "load fragment shader failed");
            AppMethodBeat.o(115712);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, ac);
        GLES20.glAttachShader(glCreateProgram, ac2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            Log.e("MicroMsg.FilterRenderer", "link program failed");
            AppMethodBeat.o(115712);
            return 0;
        }
        GLES20.glDeleteShader(ac);
        GLES20.glDeleteShader(ac2);
        AppMethodBeat.o(115712);
        return glCreateProgram;
    }

    public static a fLA() {
        AppMethodBeat.i(115713);
        com.tencent.mm.media.g.c cVar = com.tencent.mm.media.g.c.igu;
        a zI = com.tencent.mm.media.g.c.zI(14);
        AppMethodBeat.o(115713);
        return zI;
    }

    public final com.tencent.mm.plugin.voip.video.b.a fLB() {
        AppMethodBeat.i(115714);
        if (this.HkN == null || this.HkN.fLy() == null || this.HiD == 0) {
            AppMethodBeat.o(115714);
            return null;
        }
        this.HkR.a(this.kxW, this.kxX, 2, this.HkN.fLy(), 0);
        com.tencent.mm.plugin.voip.video.b.a aVar = this.HkR;
        AppMethodBeat.o(115714);
        return aVar;
    }
}
