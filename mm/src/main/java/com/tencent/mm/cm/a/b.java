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

public final class b extends a {
    static final float[] Rfs = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] Rft = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    protected List<a> Rfm;
    private int[] Rfn;
    private int[] Rfo;
    private final FloatBuffer Rfp;
    private final FloatBuffer Rfq;
    private final FloatBuffer Rfr;
    protected List<a> aby;

    public b() {
        this((byte) 0);
    }

    private b(byte b2) {
        AppMethodBeat.i(190227);
        this.aby = null;
        if (this.aby == null) {
            this.aby = new ArrayList();
        } else {
            hfd();
        }
        this.Rfp = ByteBuffer.allocateDirect(Rfs.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.Rfp.put(Rfs).position(0);
        this.Rfq = ByteBuffer.allocateDirect(Rft.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.Rfq.put(Rft).position(0);
        float[] a2 = l.a(j.NORMAL, true);
        this.Rfr = ByteBuffer.allocateDirect(a2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.Rfr.put(a2).position(0);
        AppMethodBeat.o(190227);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void MC() {
        AppMethodBeat.i(190228);
        super.MC();
        for (a aVar : this.aby) {
            aVar.init();
        }
        AppMethodBeat.o(190228);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void onDestroy() {
        AppMethodBeat.i(190229);
        hfb();
        for (a aVar : this.aby) {
            aVar.destroy();
        }
        super.onDestroy();
        AppMethodBeat.o(190229);
    }

    private void hfb() {
        AppMethodBeat.i(190230);
        if (this.Rfo != null) {
            GLES20.glDeleteTextures(this.Rfo.length, this.Rfo, 0);
            this.Rfo = null;
        }
        if (this.Rfn != null) {
            GLES20.glDeleteFramebuffers(this.Rfn.length, this.Rfn, 0);
            this.Rfn = null;
        }
        AppMethodBeat.o(190230);
    }

    @Override // com.tencent.mm.cm.a.a
    public final void lS(int i2, int i3) {
        AppMethodBeat.i(190231);
        super.lS(i2, i3);
        if (this.Rfn != null) {
            hfb();
        }
        int size = this.aby.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.aby.get(i4).lS(i2, i3);
        }
        if (this.Rfm != null && this.Rfm.size() > 0) {
            int size2 = this.Rfm.size();
            this.Rfn = new int[(size2 - 1)];
            this.Rfo = new int[(size2 - 1)];
            for (int i5 = 0; i5 < size2 - 1; i5++) {
                GLES20.glGenFramebuffers(1, this.Rfn, i5);
                GLES20.glGenTextures(1, this.Rfo, i5);
                GLES20.glBindTexture(3553, this.Rfo[i5]);
                GLES20.glTexImage2D(3553, 0, NativeBitmapStruct.GLFormat.GL_RGBA, i2, i3, 0, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.Rfn[i5]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Rfo[i5], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        AppMethodBeat.o(190231);
    }

    @Override // com.tencent.mm.cm.a.a
    @SuppressLint({"WrongCall"})
    public final void a(int i2, int i3, int i4, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(190232);
        heZ();
        if (!this.Rfh || this.Rfn == null || this.Rfo == null) {
            AppMethodBeat.o(190232);
            return;
        }
        if (this.Rfm != null) {
            int size = this.Rfm.size();
            int i5 = 0;
            int i6 = i2;
            while (i5 < size) {
                a aVar = this.Rfm.get(i5);
                boolean z = i5 < size + -1;
                if (z) {
                    GLES20.glBindFramebuffer(36160, this.Rfn[i5]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i5 == 0) {
                    aVar.a(i6, i2, i2, floatBuffer, floatBuffer2);
                } else if (i5 == size - 1) {
                    aVar.a(i6, i2, i2, this.Rfp, size % 2 == 0 ? this.Rfr : this.Rfq);
                } else {
                    aVar.a(i6, i2, i2, this.Rfp, this.Rfq);
                }
                if (z) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i6 = this.Rfo[i5];
                }
                i5++;
            }
        }
        AppMethodBeat.o(190232);
    }

    public final List<a> hfc() {
        return this.Rfm;
    }

    public final void hfd() {
        AppMethodBeat.i(190233);
        if (this.aby == null) {
            AppMethodBeat.o(190233);
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
                List<a> list = ((b) aVar).Rfm;
                if (list != null && !list.isEmpty()) {
                    this.Rfm.addAll(list);
                }
            } else {
                this.Rfm.add(aVar);
            }
        }
        AppMethodBeat.o(190233);
    }
}
