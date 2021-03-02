package com.tencent.mm.view.footer;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.h;
import com.tencent.mm.bt.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

public final class d extends a {
    private Bitmap Rpv;
    private Bitmap Rpw;

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final void hgh() {
        AppMethodBeat.i(9425);
        super.hgh();
        this.Rpv = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.crop_video_unselected));
        this.Rpw = BitmapUtil.transformDrawableToBitmap(getResources().getDrawable(R.raw.crop_video_selected));
        AppMethodBeat.o(9425);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final Bitmap a(h hVar, boolean z) {
        if (hVar == h.CROP_VIDEO) {
            return z ? this.Rpw : this.Rpv;
        }
        return null;
    }

    public d(Context context, b bVar) {
        super(context, bVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.view.footer.a
    public final boolean apX(int i2) {
        AppMethodBeat.i(9426);
        boolean apX = super.apX(i2);
        switch (apW(i2)) {
            case CROP_VIDEO:
                apX = false;
                break;
        }
        AppMethodBeat.o(9426);
        return apX;
    }
}
