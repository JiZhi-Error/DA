package com.tencent.mm.media.widget.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLiveConstants;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012JG\u0010\u001d\u001a\u00020\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012¢\u0006\u0002\u0010$J.\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "rs", "Landroid/renderscript/RenderScript;", "script", "Lcom/tencent/mm/ScriptC_ImageRenderScriptUtil;", "flipBitmap", "Landroid/graphics/Bitmap;", "bitmap", "isVertical", "", "newHeight", "", "angle", "newWidth", "release", "", "rotateBitmap", "yuv2Rgb", "data", "", "width", "height", "yuv2RgbWithCrop", "planes", "", "Landroid/media/Image$Plane;", "yuvBytes", "xOffset", "yOffset", "([Landroid/media/Image$Plane;[[BIIII)Landroid/graphics/Bitmap;", "Companion", "plugin-mediaeditor_release"})
public final class d {
    public static final a ioa = new a((byte) 0);
    c inY = new c(this.inZ);
    RenderScript inZ = RenderScript.create(this.mContext);
    private Context mContext;

    static {
        AppMethodBeat.i(94179);
        AppMethodBeat.o(94179);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camera2/RenderScriptImageHelper$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(Context context) {
        p.h(context, "mContext");
        AppMethodBeat.i(94178);
        this.mContext = context;
        AppMethodBeat.o(94178);
    }

    public final void release() {
        AppMethodBeat.i(94174);
        Log.i("MicroMsg.RenderScriptImageHelper", "release rs script ");
        c cVar = this.inY;
        if (cVar != null) {
            cVar.destroy();
        }
        RenderScript renderScript = this.inZ;
        if (renderScript != null) {
            renderScript.destroy();
            AppMethodBeat.o(94174);
            return;
        }
        AppMethodBeat.o(94174);
    }

    private static int d(Bitmap bitmap, int i2) {
        AppMethodBeat.i(94175);
        p.h(bitmap, "bitmap");
        if (i2 == 90 || i2 == 270) {
            int width = bitmap.getWidth();
            AppMethodBeat.o(94175);
            return width;
        }
        int height = bitmap.getHeight();
        AppMethodBeat.o(94175);
        return height;
    }

    private static int e(Bitmap bitmap, int i2) {
        AppMethodBeat.i(94176);
        p.h(bitmap, "bitmap");
        if (i2 == 90 || i2 == 270) {
            int height = bitmap.getHeight();
            AppMethodBeat.o(94176);
            return height;
        }
        int width = bitmap.getWidth();
        AppMethodBeat.o(94176);
        return width;
    }

    public final Bitmap f(Bitmap bitmap, int i2) {
        AppMethodBeat.i(94177);
        p.h(bitmap, "bitmap");
        if (i2 == 0) {
            AppMethodBeat.o(94177);
        } else {
            c cVar = this.inY;
            if (cVar != null) {
                cVar.iA(bitmap.getWidth());
            }
            c cVar2 = this.inY;
            if (cVar2 != null) {
                cVar2.iB(bitmap.getHeight());
            }
            Allocation createFromBitmap = Allocation.createFromBitmap(this.inZ, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            bitmap.recycle();
            c cVar3 = this.inY;
            if (cVar3 != null) {
                cVar3.a(createFromBitmap);
            }
            bitmap = Bitmap.createBitmap(e(bitmap, i2), d(bitmap, i2), bitmap.getConfig());
            Allocation createFromBitmap2 = Allocation.createFromBitmap(this.inZ, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            switch (i2) {
                case 90:
                    c cVar4 = this.inY;
                    if (cVar4 != null) {
                        cVar4.a(createFromBitmap2, createFromBitmap2);
                        break;
                    }
                    break;
                case TXLiveConstants.RENDER_ROTATION_180 /*{ENCODED_INT: 180}*/:
                    c cVar5 = this.inY;
                    if (cVar5 != null) {
                        cVar5.d(createFromBitmap2, createFromBitmap2);
                        break;
                    }
                    break;
                case 270:
                    c cVar6 = this.inY;
                    if (cVar6 != null) {
                        cVar6.b(createFromBitmap2, createFromBitmap2);
                        break;
                    }
                    break;
            }
            createFromBitmap2.copyTo(bitmap);
            createFromBitmap2.destroy();
            createFromBitmap.destroy();
            p.g(bitmap, "target");
            AppMethodBeat.o(94177);
        }
        return bitmap;
    }
}
