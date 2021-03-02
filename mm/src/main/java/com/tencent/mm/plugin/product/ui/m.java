package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class m implements u.a {
    public n.a BbM;
    public ImageView gBZ;
    public TextView titleTv;

    @Override // com.tencent.mm.platformtools.u.a
    public final void k(String str, final Bitmap bitmap) {
        AppMethodBeat.i(67045);
        if (this.BbM == null || Util.isNullOrNil(this.BbM.iconUrl)) {
            AppMethodBeat.o(67045);
            return;
        }
        if (str.equals(this.BbM.iconUrl)) {
            this.gBZ.post(new Runnable() {
                /* class com.tencent.mm.plugin.product.ui.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(67044);
                    m.this.gBZ.setImageBitmap(bitmap);
                    AppMethodBeat.o(67044);
                }
            });
        }
        AppMethodBeat.o(67045);
    }
}
