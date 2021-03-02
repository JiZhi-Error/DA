package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;

public final class e extends p {
    private a Rvx;

    public interface a {
        void bmr();
    }

    public e(a aVar) {
        super(7, (u) null);
        this.Rvx = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void onClick(View view) {
        AppMethodBeat.i(214337);
        if (this.Rvx != null) {
            this.Rvx.bmr();
        }
        AppMethodBeat.o(214337);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(214338);
        super.updateDrawState(textPaint);
        ao.a(textPaint, 0.8f);
        AppMethodBeat.o(214338);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void setColorConfig(int i2) {
        AppMethodBeat.i(214339);
        Context context = MMApplicationContext.getContext();
        super.setColorConfig(i2);
        if (i2 == 7) {
            setColor(context.getResources().getColor(R.color.Link), context.getResources().getColor(R.color.FG_3));
            AppMethodBeat.o(214339);
            return;
        }
        if (i2 == 6) {
            setColor(context.getResources().getColor(R.color.aj), context.getResources().getColor(R.color.aa));
        }
        AppMethodBeat.o(214339);
    }
}
