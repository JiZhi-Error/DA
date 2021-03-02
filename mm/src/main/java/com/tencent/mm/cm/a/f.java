package com.tencent.mm.cm.a;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    private static int RfI = -1;
    public ByteBuffer Hlu;
    private d RfC;
    private e RfD;
    private a RfE;
    private i RfF;
    private int[] RfG;
    private int RfH = -1;
    c RfJ;
    public byte[] RfK;
    private boolean RfL = false;
    private boolean RfM = false;
    private FloatBuffer RfN = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private FloatBuffer RfO;
    protected List<a> Rfm;
    private int[] Rfn;
    private int[] Rfo;
    private final FloatBuffer Rfr;
    protected List<a> aby = new ArrayList();
    public int outputHeight = 0;
    public int outputWidth = 0;
    private int rod;
    public int surfaceHeight;
    public int surfaceWidth;

    public f() {
        AppMethodBeat.i(190240);
        this.RfN.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.RfN.position(0);
        this.RfO = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.RfO.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        this.RfO.position(0);
        float[] a2 = l.a(j.ROTATION_180, false);
        this.Rfr = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.Rfr.put(a2).position(0);
        this.RfJ = new c();
        this.RfC = new d();
        this.RfD = new e();
        this.RfF = new i();
        this.RfL = false;
        this.aby.add(this.RfC);
        this.aby.add(this.RfD);
        hfd();
        AppMethodBeat.o(190240);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void MC() {
        AppMethodBeat.i(190241);
        super.MC();
        this.RfJ.lU(this.mOutputWidth, this.mOutputHeight);
        for (a aVar : this.aby) {
            aVar.init();
        }
        i iVar = this.RfF;
        iVar.RfU = new int[1];
        GLES20.glGenFramebuffers(1, iVar.RfU, 0);
        AppMethodBeat.o(190241);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void onDestroy() {
        AppMethodBeat.i(190242);
        hfb();
        i iVar = this.RfF;
        GLES20.glDeleteFramebuffers(iVar.RfU.length, iVar.RfU, 0);
        for (a aVar : this.aby) {
            aVar.destroy();
        }
        super.onDestroy();
        this.outputHeight = 0;
        this.outputWidth = 0;
        AppMethodBeat.o(190242);
    }

    private void hfb() {
        AppMethodBeat.i(190243);
        if (this.Rfo != null) {
            GLES20.glDeleteTextures(this.Rfo.length, this.Rfo, 0);
            this.Rfo = null;
        }
        if (this.Rfn != null) {
            GLES20.glDeleteFramebuffers(this.Rfn.length, this.Rfn, 0);
            this.Rfn = null;
        }
        if (this.RfG != null) {
            GLES20.glDeleteFramebuffers(this.RfG.length, this.RfG, 0);
            this.RfG = null;
        }
        AppMethodBeat.o(190243);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void lS(int i2, int i3) {
        AppMethodBeat.i(190244);
        if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(190244);
            return;
        }
        if (!(this.outputWidth == i2 && this.outputHeight == i3 && !this.RfM)) {
            this.outputWidth = i2;
            this.outputHeight = i3;
            super.lS(this.outputWidth, this.outputHeight);
            if (this.Rfn != null) {
                hfb();
            }
            if (this.Rfo != null) {
                GLES20.glDeleteTextures(this.Rfo.length, this.Rfo, 0);
                this.Rfo = null;
            }
            c cVar = this.RfJ;
            int i4 = this.outputWidth;
            int i5 = this.outputHeight;
            if (cVar.Rfu != -1) {
                if (cVar.Gxi != -1) {
                    GLES20.glDeleteTextures(1, new int[]{cVar.Gxi}, 0);
                    cVar.Gxi = -1;
                }
                if (cVar.Rfu != -1) {
                    GLES20.glDeleteFramebuffers(0, new int[]{cVar.Rfu}, 0);
                    cVar.Rfu = -1;
                }
            }
            cVar.lU(i4, i5);
            int size = this.aby.size();
            for (int i6 = 0; i6 < size; i6++) {
                if (i6 < size - 1 || !this.RfL) {
                    this.aby.get(i6).lS(this.outputWidth, this.outputHeight);
                } else {
                    this.aby.get(i6).lS(this.surfaceWidth, this.surfaceHeight);
                }
            }
            if (this.Rfm != null && this.Rfm.size() > 0) {
                int size2 = this.Rfm.size();
                this.Rfn = new int[(size2 - 1)];
                this.Rfo = new int[(size2 - 1)];
                for (int i7 = 0; i7 < size2 - 1; i7++) {
                    GLES20.glGenFramebuffers(1, this.Rfn, i7);
                    GLES20.glBindFramebuffer(36160, this.Rfn[i7]);
                    GLES20.glGenTextures(1, this.Rfo, i7);
                    GLES20.glBindTexture(3553, this.Rfo[i7]);
                    GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.outputWidth, this.outputHeight, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                    GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[i7], 0);
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                }
                if (!this.RfL) {
                    if (this.RfG == null) {
                        this.RfG = new int[1];
                    }
                    GLES20.glGenFramebuffers(1, this.RfG, 0);
                }
                int i8 = this.outputWidth;
                int i9 = this.outputHeight;
                int size3 = this.Rfm.size();
                for (int i10 = 0; i10 < size3 - 1; i10++) {
                    if (this.Rfo[i10] == RfI) {
                        GLES20.glBindFramebuffer(36160, this.Rfn[i10]);
                        GLES20.glGenTextures(1, this.Rfo, i10);
                        GLES20.glBindTexture(3553, this.Rfo[i10]);
                        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i8, i9, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[i10], 0);
                        GLES20.glBindTexture(3553, 0);
                        GLES20.glBindFramebuffer(36160, 0);
                    }
                }
                if (!this.RfL && this.RfG[0] == RfI) {
                    GLES20.glGenFramebuffers(1, this.RfG, 0);
                }
            }
        }
        AppMethodBeat.o(190244);
    }

    @Override // com.tencent.mm.cm.a.a
    @SuppressLint({"WrongCall"})
    public final void a(int i2, int i3, int i4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i5;
        AppMethodBeat.i(190245);
        heZ();
        if (!this.Rfh || this.Rfn == null || this.Rfo == null) {
            AppMethodBeat.o(190245);
            return;
        }
        if (this.Rfm != null) {
            try {
                GLES20.glBindFramebuffer(36160, this.Rfn[0]);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                this.RfC.a(i2, this.RfH, i2, this.RfN, this.RfO);
                GLES20.glBindFramebuffer(36160, 0);
                if (this.RfL) {
                    GLES20.glBindFramebuffer(36160, this.Rfn[1]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    this.RfD.a(i2, this.RfH, this.Rfo[0], this.RfN, this.Rfr);
                    if (this.Hlu == null || this.Hlu.capacity() < this.outputHeight * this.outputWidth * 4) {
                        this.Hlu = ByteBuffer.allocateDirect(this.outputHeight * this.outputWidth * 4).order(ByteOrder.nativeOrder());
                    }
                    this.Hlu.position(0);
                    GLES20.glReadPixels(0, 0, this.outputWidth, this.outputHeight, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.Hlu);
                    this.Hlu.position(0);
                    this.RfK = this.Hlu.array();
                    GLES20.glBindFramebuffer(36160, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                    this.RfE.a(this.Rfo[1], i2, i2, floatBuffer, floatBuffer2);
                } else {
                    GLES20.glBindFramebuffer(36160, this.RfG[0]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    this.RfD.a(i2, this.RfH, this.Rfo[0], this.RfN, this.RfO);
                    GLES20.glBindFramebuffer(36160, 0);
                }
                i iVar = this.RfF;
                int i6 = this.mOutputWidth;
                int i7 = this.mOutputHeight;
                int i8 = this.rod;
                int i9 = this.RfH;
                int[] iArr = new int[1];
                if (i8 == -1) {
                    i5 = -1;
                } else {
                    if (i9 == -1) {
                        GLES20.glGenTextures(1, iArr, 0);
                        GLES20.glBindTexture(3553, iArr[0]);
                        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i6, i7, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                    } else {
                        GLES20.glBindFramebuffer(36160, iVar.RfU[0]);
                        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i8, 0);
                        GLES20.glCheckFramebufferStatus(36160);
                        GLES20.glBindTexture(3553, i9);
                        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, i6, i7);
                        GLES20.glBindFramebuffer(36160, 0);
                        GLES20.glBindTexture(3553, 0);
                        iArr[0] = i9;
                    }
                    i5 = iArr[0];
                }
                this.RfH = i5;
                AppMethodBeat.o(190245);
                return;
            } catch (IndexOutOfBoundsException e2) {
                AppMethodBeat.o(190245);
                return;
            } catch (Exception e3) {
            }
        }
        AppMethodBeat.o(190245);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void apH(int i2) {
        AppMethodBeat.i(190246);
        if (i2 >= 5) {
            this.RfC.apI(1);
            this.RfD.apJ(1);
            AppMethodBeat.o(190246);
            return;
        }
        this.RfC.apI(0);
        this.RfD.apJ(0);
        AppMethodBeat.o(190246);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void cH(float f2) {
        AppMethodBeat.i(190247);
        this.RfC.cH(f2);
        AppMethodBeat.o(190247);
    }

    private void hfe() {
        AppMethodBeat.i(190248);
        if (!this.RfL) {
            if (this.RfG == null) {
                this.RfG = new int[1];
                GLES20.glGenFramebuffers(1, this.RfG, 0);
            }
            GLES20.glBindFramebuffer(36160, this.RfG[0]);
            GLES20.glBindTexture(3553, this.rod);
            GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, this.outputWidth, this.outputHeight, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.rod, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(190248);
    }

    public final void apK(int i2) {
        AppMethodBeat.i(190249);
        if (!this.RfL) {
            this.rod = i2;
            hfe();
        }
        AppMethodBeat.o(190249);
    }

    public final void DA(boolean z) {
        AppMethodBeat.i(190250);
        this.RfL = z;
        if (this.RfE == null) {
            this.RfE = new a();
            this.aby.add(this.RfE);
            this.RfM = true;
            hfd();
            this.RfE.init();
            lS(this.outputWidth, this.outputHeight);
        }
        this.RfM = false;
        AppMethodBeat.o(190250);
    }

    public static void e(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(190251);
        for (int i2 = 0; i2 < 8; i2++) {
            fArr2[i2] = fArr[i2];
        }
        swap(fArr2, 0, 6);
        swap(fArr2, 1, 7);
        swap(fArr2, 2, 4);
        swap(fArr2, 3, 5);
        AppMethodBeat.o(190251);
    }

    private static void swap(float[] fArr, int i2, int i3) {
        float f2 = fArr[i2];
        fArr[i2] = fArr[i3];
        fArr[i3] = f2;
    }

    private void hfd() {
        AppMethodBeat.i(190252);
        if (this.aby == null) {
            AppMethodBeat.o(190252);
            return;
        }
        if (this.Rfm == null) {
            this.Rfm = new ArrayList();
        } else {
            this.Rfm.clear();
        }
        for (a aVar : this.aby) {
            if (aVar instanceof b) {
                ((b) aVar).hfd();
                List<a> hfc = ((b) aVar).hfc();
                if (hfc != null && !hfc.isEmpty()) {
                    this.Rfm.addAll(hfc);
                }
            } else {
                this.Rfm.add(aVar);
            }
        }
        AppMethodBeat.o(190252);
    }
}
