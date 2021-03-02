package com.tencent.mm.ui.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e implements b {
    private final RenderScript PcD;
    private final ScriptIntrinsicBlur PcE;
    private Allocation PcF;
    private int PcG = -1;
    private int PcH = -1;

    public e(Context context) {
        AppMethodBeat.i(142743);
        this.PcD = RenderScript.create(context);
        this.PcE = ScriptIntrinsicBlur.create(this.PcD, Element.U8_4(this.PcD));
        AppMethodBeat.o(142743);
    }

    @Override // com.tencent.mm.ui.blur.b
    public final Bitmap b(Bitmap bitmap, float f2) {
        boolean z;
        AppMethodBeat.i(142744);
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
        AppMethodBeat.o(142744);
        return bitmap;
    }

    @Override // com.tencent.mm.ui.blur.b
    public final void destroy() {
        AppMethodBeat.i(142745);
        this.PcE.destroy();
        this.PcD.destroy();
        if (this.PcF != null) {
            this.PcF.destroy();
        }
        AppMethodBeat.o(142745);
    }

    @Override // com.tencent.mm.ui.blur.b
    public final Bitmap.Config gMq() {
        return Bitmap.Config.ARGB_8888;
    }
}
