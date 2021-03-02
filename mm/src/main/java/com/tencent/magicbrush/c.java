package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, hxF = {"Lcom/tencent/magicbrush/MBExternalSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texId", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "(ILcom/tencent/magicbrush/MBRuntime;)V", "matrix", "", "getTexId", "()I", "destroy", "", "getMatrix", "getTransformMatrix", "mtx", "Companion", "lib-magicbrush-nano_release"})
public final class c extends SurfaceTexture {
    public static final a cKK = new a((byte) 0);
    private float[] cKH;
    private final int cKI;
    private final MBRuntime cKJ;

    static {
        AppMethodBeat.i(206819);
        AppMethodBeat.o(206819);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/magicbrush/MBExternalSurfaceTexture$Companion;", "", "()V", "TAG", "", "lib-magicbrush-nano_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void getTransformMatrix(float[] fArr) {
        AppMethodBeat.i(206817);
        p.h(fArr, "mtx");
        super.getTransformMatrix(fArr);
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        p.g(copyOf, "java.util.Arrays.copyOf(this, size)");
        this.cKH = copyOf;
        AppMethodBeat.o(206817);
    }

    public final void destroy() {
        AppMethodBeat.i(206818);
        setOnFrameAvailableListener(null);
        this.cKJ.nativeDestroyExternalTexture(this.cKJ.mNativeInst, this.cKI);
        AppMethodBeat.o(206818);
    }
}
