package com.tencent.mm.media.g;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.media.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Ljava/io/Closeable;", "scene", "", "(J)V", "frameBufferId", "", "memRelease", "", "tid", "allocatedTid", "bind", "", "close", "finalize", "isClosed", "toString", "", "Companion", "plugin-mediaeditor_release"})
public final class a implements Closeable {
    public static final C0415a igq = new C0415a((byte) 0);
    volatile boolean ign;
    public int igo = -1;
    private long igp = 2;
    int tid = -1;

    static {
        AppMethodBeat.i(93684);
        AppMethodBeat.o(93684);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/globject/GLFrameBufferObject$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.g.a$a  reason: collision with other inner class name */
    public static final class C0415a {
        private C0415a() {
        }

        public /* synthetic */ C0415a(byte b2) {
            this();
        }
    }

    public a(long j2) {
        int i2 = 0;
        AppMethodBeat.i(93683);
        this.igp = j2;
        b bVar = b.igr;
        b.aMw();
        this.tid = Process.myTid();
        c.a aVar = c.ilt;
        int[] iArr = new int[1];
        GLES30.glGenFramebuffers(1, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("MicroMsg.GLEnvironmentUtil", "gen frame buffer error");
        } else {
            i2 = iArr[0];
        }
        this.igo = i2;
        Log.i("MicroMsg.GLFrameBufferObject", "create frameBuffer:" + this.igo + " tid:" + this.tid + ", stackTrace:\t" + b.getStack());
        AppMethodBeat.o(93683);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(93680);
        if (this.ign) {
            Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close already close");
            AppMethodBeat.o(93680);
            return;
        }
        int myTid = Process.myTid();
        if (this.tid != myTid) {
            Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked by different thread!!!  scene：" + this.igp + "  created in:" + this.tid + " release in:" + myTid + ", stackTrace:\t" + b.getStack());
            b bVar = b.igr;
            b.aMz();
            AppMethodBeat.o(93680);
            return;
        }
        this.ign = true;
        c.a aVar = c.ilt;
        GLES20.glDeleteFramebuffers(1, new int[]{this.igo}, 0);
        Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " close framebuffer:" + this.igo);
        AppMethodBeat.o(93680);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(93681);
        if (!this.ign) {
            b bVar = b.igr;
            b.zH(this.igp);
            b bVar2 = b.igr;
            b.aMx();
            Log.e("MicroMsg.GLFrameBufferObject", hashCode() + " Leaked !!!  scene：" + this.igp);
            AppMethodBeat.o(93681);
            return;
        }
        Log.i("MicroMsg.GLFrameBufferObject", hashCode() + " release success!");
        AppMethodBeat.o(93681);
    }

    public final String toString() {
        AppMethodBeat.i(93682);
        String str = "hashcode:" + hashCode() + " frameBufferId:" + this.igo + " memRelease:" + this.ign + " scene:" + this.igp + " create-tid:" + this.tid;
        AppMethodBeat.o(93682);
        return str;
    }
}
