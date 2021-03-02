package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 15}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0011\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H J)\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH J\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H J\u0011\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006 "}, hxF = {"Lcom/tencent/mm/xeffect/FaceTracker;", "", "modelRoot", "", "(Ljava/lang/String;)V", "nPtr", "", "getNPtr", "()J", "setNPtr", "(J)V", "destroy", "", "detect", "", "data", "Ljava/nio/Buffer;", "width", "height", "getFaceRect", "Landroid/graphics/RectF;", "getPoints", "", "Landroid/graphics/PointF;", "()[Landroid/graphics/PointF;", "nDestroy", "nDetect", "nGetFaceRect", "", "nGetPoints", "nInit", "Companion", "renderlib_release"})
public final class FaceTracker {
    public static final a Rxe = new a((byte) 0);
    public long Rxd;

    private final native float[] nGetPoints(long j2);

    private final native long nInit(String str);

    public final native void nDestroy(long j2);

    public final native int nDetect(long j2, Buffer buffer, int i2, int i3);

    public final native float[] nGetFaceRect(long j2);

    @l(hxD = {1, 1, 15}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/xeffect/FaceTracker$Companion;", "", "()V", "TAG", "", "renderlib_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FaceTracker(String str) {
        p.h(str, "modelRoot");
        AppMethodBeat.i(237039);
        this.Rxd = nInit(str);
        AppMethodBeat.o(237039);
    }

    static {
        AppMethodBeat.i(237040);
        d.load("xlabeffect");
        AppMethodBeat.o(237040);
    }
}
