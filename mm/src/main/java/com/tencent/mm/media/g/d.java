package com.tencent.mm.media.g;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Process;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.nio.Buffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\"\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\u000fJ \u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010 \u001a\u00020\u0003J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010$\u001a\u00020\bH\u0002J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\b\u0010&\u001a\u00020'H\u0016J\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/media/globject/GLTextureObject;", "Ljava/io/Closeable;", "sampler2D", "", "scene", "", "(ZJ)V", "height", "", "internalFormat", "memRelease", "texID", "tid", "width", "allocTexMem", "", "pixels", "Ljava/nio/Buffer;", "minMagFilter", "wrapST", "allocTexMemFromBitmap", "bitmap", "Landroid/graphics/Bitmap;", "allocatedTid", "bind", "bindFrameBuffer", "frameBuffer", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "checkFrameBufferStatus", "close", "finalize", "initInGLThread", "isClosed", "isExternalTexture", "isSample2DTexture", "setSize", "texFormatByteSize", "texMemorySize", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class d implements Closeable {
    public static final a igy = new a((byte) 0);
    public int height = -1;
    volatile boolean ign = true;
    private long igp = 2;
    public int igv = -1;
    private boolean igw;
    private int igx = NativeBitmapStruct.GLFormat.GL_RGBA;
    int tid = -1;
    public int width = -1;

    static {
        AppMethodBeat.i(93708);
        AppMethodBeat.o(93708);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/globject/GLTextureObject$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(boolean z, long j2) {
        AppMethodBeat.i(93707);
        this.igp = j2;
        if (this.igp < 0) {
            this.igp = 15;
        }
        b bVar = b.igr;
        b.aMu();
        this.ign = false;
        this.tid = Process.myTid();
        this.igw = z;
        if (z) {
            c.a aVar = c.ilt;
            this.igv = c.a.aMZ();
        } else {
            c.a aVar2 = c.ilt;
            int[] iArr = new int[1];
            GLES30.glGenTextures(1, iArr, 0);
            GLES30.glBindTexture(36197, iArr[0]);
            GLES30.glTexParameteri(36197, 10241, 9729);
            GLES30.glTexParameteri(36197, Task.EXTRAS_LIMIT_BYTES, 9729);
            GLES30.glTexParameteri(36197, 10242, 33071);
            GLES30.glTexParameteri(36197, 10243, 33071);
            GLES30.glBindTexture(36197, 0);
            c.a.Hr("glGenTextures");
            this.igv = iArr[0];
        }
        Log.i("MicroMsg.GLTextureObject", hashCode() + " create texID:" + this.igv + "  sampler2D:" + z + " tid:" + this.tid + ", stackTrace:\t" + b.getStack());
        AppMethodBeat.o(93707);
    }

    public final void setSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    public static /* synthetic */ void a(d dVar, int i2, int i3, int i4, Buffer buffer, int i5, int i6, int i7) {
        AppMethodBeat.i(93700);
        dVar.a(i2, i3, (i7 & 4) != 0 ? NativeBitmapStruct.GLFormat.GL_RGBA : i4, (i7 & 8) != 0 ? null : buffer, (i7 & 16) != 0 ? 9729 : i5, (i7 & 32) != 0 ? 10497 : i6);
        AppMethodBeat.o(93700);
    }

    public final void a(int i2, int i3, int i4, Buffer buffer, int i5, int i6) {
        AppMethodBeat.i(93699);
        if (i2 == this.width && i3 == this.height && i4 == this.igx && buffer == null) {
            AppMethodBeat.o(93699);
            return;
        }
        Log.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMem, width:" + i2 + ", height:" + i3 + ", internalFormat:" + i4 + ", memorySize:" + aMB());
        GLES20.glBindTexture(3553, this.igv);
        GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i4, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
        GLES20.glTexParameterf(3553, 10241, (float) i5);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, (float) i5);
        GLES20.glTexParameterf(3553, 10242, (float) i6);
        GLES20.glTexParameterf(3553, 10243, (float) i6);
        this.width = i2;
        this.height = i3;
        this.igx = i4;
        AppMethodBeat.o(93699);
    }

    public static /* synthetic */ void a(d dVar, Bitmap bitmap) {
        AppMethodBeat.i(93701);
        dVar.c(bitmap, 9729, 10497);
        AppMethodBeat.o(93701);
    }

    public final void c(Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(218748);
        p.h(bitmap, "bitmap");
        if (!(this.width == bitmap.getWidth() && this.height == bitmap.getHeight() && this.igx == this.igx)) {
            Log.i("MicroMsg.GLTextureObject", hashCode() + " allocTexMemFromBitmap, width:" + bitmap.getWidth() + ", height:" + bitmap.getHeight() + ", internalFormat:" + this.igx + ", memorySize:" + aMB());
        }
        GLES20.glBindTexture(3553, this.igv);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameterf(3553, 10241, (float) i2);
        GLES20.glTexParameterf(3553, Task.EXTRAS_LIMIT_BYTES, (float) i2);
        GLES20.glTexParameterf(3553, 10242, (float) i3);
        GLES20.glTexParameterf(3553, 10243, (float) i3);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
        this.igx = GLUtils.getInternalFormat(bitmap);
        AppMethodBeat.o(218748);
    }

    public final void a(a aVar, int i2, int i3) {
        String str;
        AppMethodBeat.i(93702);
        if (aVar != null) {
            c.a aVar2 = c.ilt;
            c.a.a(aVar, this, i2, i3);
        }
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            switch (glCheckFramebufferStatus) {
                case 36054:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT";
                    break;
                case 36055:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT";
                    break;
                case 36056:
                case 36058:
                case 36059:
                case 36060:
                default:
                    str = "unknown error";
                    break;
                case 36057:
                    str = "GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS";
                    break;
                case 36061:
                    str = "GL_FRAMEBUFFER_UNSUPPORTED";
                    break;
            }
            Log.e("MicroMsg.GLTextureObject", "bind framebuffer status not complete, status:" + glCheckFramebufferStatus + " error:" + str);
        }
        AppMethodBeat.o(93702);
    }

    private final int aMC() {
        switch (this.igx) {
            case NativeBitmapStruct.GLFormat.GL_RGB:
                return 24;
            case NativeBitmapStruct.GLFormat.GL_RGBA:
            case 6409:
            case 6410:
                return 32;
            default:
                return 24;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(93704);
        if (this.ign) {
            Log.i("MicroMsg.GLTextureObject", hashCode() + " tex already close");
            AppMethodBeat.o(93704);
            return;
        }
        int myTid = Process.myTid();
        if (this.tid != myTid) {
            Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked by different thread!!!  scene：" + this.igp + "  created in:" + this.tid + " release in:" + myTid + ", stackTrace:\t" + b.getStack());
            b bVar = b.igr;
            b.aMy();
            this.ign = false;
            AppMethodBeat.o(93704);
            return;
        }
        this.ign = true;
        c.a aVar = c.ilt;
        GLES20.glDeleteTextures(1, new int[]{this.igv}, 0);
        Log.i("MicroMsg.GLTextureObject", hashCode() + " close texID:" + this.igv + "  sampler2D:" + this.igw + ", stacks:" + b.getStack());
        AppMethodBeat.o(93704);
    }

    public final boolean aMD() {
        return !this.igw;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(93705);
        if (!this.ign) {
            b bVar = b.igr;
            b.aMv();
            b bVar2 = b.igr;
            b.zG(this.igp);
            Log.e("MicroMsg.GLTextureObject", hashCode() + " Leaked !!!  scene：" + this.igp);
            AppMethodBeat.o(93705);
            return;
        }
        Log.i("MicroMsg.GLTextureObject", hashCode() + " release success!");
        AppMethodBeat.o(93705);
    }

    public final String toString() {
        AppMethodBeat.i(93706);
        String str = "hashcode:" + hashCode() + " texID:" + this.igv + " sampler2D:" + this.igw + " memRelease:" + this.ign + " scene:" + this.igp + " create-tid:" + this.tid + " width:" + this.width + " height:" + this.height;
        AppMethodBeat.o(93706);
        return str;
    }

    private int aMB() {
        AppMethodBeat.i(93703);
        if (this.igw) {
            int aMC = this.width * this.height * aMC();
            AppMethodBeat.o(93703);
            return aMC;
        }
        int i2 = ((this.width * this.height) * 3) / 2;
        AppMethodBeat.o(93703);
        return i2;
    }
}
