package com.tencent.mm.plugin.recordvideo.b;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\u0006\u0010$\u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u0011\u0010\u001e\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\f¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/ImageToVideoConfig;", "", "()V", "CheckRemuxFlag", "", "getCheckRemuxFlag", "()Z", "setCheckRemuxFlag", "(Z)V", "FrameRate", "", "getFrameRate", "()I", "setFrameRate", "(I)V", "Height", "getHeight", "setHeight", "IFrameInterval", "getIFrameInterval", "setIFrameInterval", "MaxSize", "RemuxFlag", "getRemuxFlag", "setRemuxFlag", "VIDEO_DURATION", "getVIDEO_DURATION", "Width", "getWidth", "setWidth", "maxSize", "getMaxSize", "getScaleSize", "Landroid/graphics/Point;", "origWidth", "origHeight", "setupWindowSize", "plugin-recordvideo_release"})
public final class e {
    private static final int BNg = 15000;
    private static int BNh = 15;
    private static int BNi = 10;
    private static int BNj;
    private static boolean BNk = true;
    private static boolean BNl;
    public static final e BNm = new e();
    private static int Height;
    private static int Width;

    static {
        AppMethodBeat.i(75372);
        AppMethodBeat.o(75372);
    }

    private e() {
    }

    public static int eJs() {
        return BNg;
    }

    public static int getFrameRate() {
        return BNh;
    }

    public static int getWidth() {
        return Width;
    }

    public static int getHeight() {
        return Height;
    }

    public static boolean eJt() {
        return BNk;
    }

    public static void ta(boolean z) {
        BNk = z;
    }

    public static boolean eJu() {
        return BNl;
    }

    public static void tb(boolean z) {
        BNl = z;
    }

    public final int getMaxSize() {
        AppMethodBeat.i(75370);
        if (BNj <= 0) {
            eJv();
        }
        int i2 = BNj;
        AppMethodBeat.o(75370);
        return i2;
    }

    public final synchronized Point eJv() {
        Point point;
        AppMethodBeat.i(75371);
        if (Width <= 0 || Height <= 0) {
            com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
            p.g(baZ, "SubCoreVideoControl.getCore()");
            VideoTransPara bbd = baZ.bbd();
            int i2 = bbd.width;
            f.a aVar = f.ilG;
            int ro = f.a.ro(bbd.width);
            if (ro % 16 != 0) {
                ro = d.QH(ro);
            }
            if (i2 % 16 != 0) {
                i2 = d.QH(i2);
            }
            Width = i2;
            Height = ro;
            BNj = Width;
        }
        point = new Point(Width, Height);
        AppMethodBeat.o(75371);
        return point;
    }
}
