package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bo;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.conversation.a.e;

public final class k extends b {
    LinearLayout Qii = null;

    public k(final Context context) {
        super(context);
        AppMethodBeat.i(38799);
        this.Qii = new LinearLayout(context);
        this.Qii.setVisibility(8);
        bo.aVL().iDY = new bo.b() {
            /* class com.tencent.mm.ui.conversation.a.k.AnonymousClass1 */

            @Override // com.tencent.mm.model.bo.b
            public final void onNotify() {
                AppMethodBeat.i(38798);
                k.this.Qii.post(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.a.k.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(38797);
                        if (k.this.Qii != null) {
                            k.this.Qii.setVisibility(8);
                            k.this.Qii.removeAllViews();
                        }
                        a a2 = e.a(context, e.a.ABTEST_BANNER, null);
                        if (a2 == null) {
                            a2 = e.a(context, e.a.MAIN_FRAME_BANNER, null);
                        }
                        if (!(a2 == null || a2.getView() == null)) {
                            Log.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a2, a2.getView());
                            k.this.Qii.setVisibility(0);
                            k.this.Qii.addView(a2.getView(), new LinearLayout.LayoutParams(-1, -2));
                        }
                        AppMethodBeat.o(38797);
                    }
                });
                AppMethodBeat.o(38798);
            }
        };
        bo.aVL().iDY.onNotify();
        AppMethodBeat.o(38799);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final boolean bYa() {
        AppMethodBeat.i(38800);
        if (this.Qii == null || this.Qii.getVisibility() != 0) {
            AppMethodBeat.o(38800);
            return false;
        }
        AppMethodBeat.o(38800);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b, com.tencent.mm.pluginsdk.ui.b.a
    public final View getView() {
        return this.Qii;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
        AppMethodBeat.i(38801);
        bo.aVL().iDY = null;
        AppMethodBeat.o(38801);
    }
}
