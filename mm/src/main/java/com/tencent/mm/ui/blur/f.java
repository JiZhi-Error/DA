package com.tencent.mm.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class f implements b {
    private final RenderScript PcD;
    private final ScriptIntrinsicBlur PcE;
    private Allocation PcF;
    private int PcG = -1;
    private int PcH = -1;

    public f(Context context) {
        AppMethodBeat.i(142746);
        this.PcD = RenderScript.create(context);
        this.PcE = ScriptIntrinsicBlur.create(this.PcD, Element.U8_4(this.PcD));
        AppMethodBeat.o(142746);
    }

    @Override // com.tencent.mm.ui.blur.b
    public final Bitmap b(Bitmap bitmap, float f2) {
        boolean z;
        AppMethodBeat.i(142747);
        if (f2 <= 0.0f) {
            Log.w("MicroMsg.SupportRenderScriptBlur", "Radius(%s) out of range (0 < r <= 25), realRadius:%s", Float.valueOf(f2), Float.valueOf(1.0f));
            f2 = 1.0f;
        } else if (f2 > 25.0f) {
            Log.w("MicroMsg.SupportRenderScriptBlur", "Radius(%s) out of range (0 < r <= 25), realRadius:%s", Float.valueOf(f2), Float.valueOf(25.0f));
            f2 = 25.0f;
        }
        Allocation createFromBitmap = Allocation.createFromBitmap(this.PcD, bitmap);
        if (bitmap.getHeight() == this.PcH && bitmap.getWidth() == this.PcG) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (this.PcF != null) {
                this.PcF.destroy();
            }
            this.PcF = Allocation.createTyped(this.PcD, createFromBitmap.getType());
            this.PcG = bitmap.getWidth();
            this.PcH = bitmap.getHeight();
        }
        this.PcE.setRadius(f2);
        this.PcE.setInput(createFromBitmap);
        this.PcE.forEach(this.PcF);
        this.PcF.copyTo(bitmap);
        createFromBitmap.destroy();
        AppMethodBeat.o(142747);
        return bitmap;
    }

    @Override // com.tencent.mm.ui.blur.b
    public final void destroy() {
        AppMethodBeat.i(142748);
        this.PcE.destroy();
        this.PcD.destroy();
        if (this.PcF != null) {
            this.PcF.destroy();
        }
        AppMethodBeat.o(142748);
    }

    @Override // com.tencent.mm.ui.blur.b
    public final Bitmap.Config gMq() {
        return Bitmap.Config.ARGB_8888;
    }
}
