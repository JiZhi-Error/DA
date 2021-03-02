package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;

public final class q extends p {
    private a IiO;
    private boolean IiP;

    public interface a {
        void dF(View view);
    }

    public q(a aVar) {
        this(2, aVar);
    }

    public q(String str, a aVar) {
        this(2, aVar);
        AppMethodBeat.i(71104);
        if (!Util.isNullOrNil(str)) {
            setColor(Color.parseColor(str), MMApplicationContext.getContext().getResources().getColor(R.color.a91));
        }
        AppMethodBeat.o(71104);
    }

    public q(int i2, a aVar) {
        super(i2, (u) null);
        this.IiP = false;
        this.IiO = aVar;
    }

    public q(a aVar, byte b2) {
        super(6, (u) null);
        this.IiP = false;
        this.IiO = aVar;
        this.IiP = true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void onClick(View view) {
        AppMethodBeat.i(71105);
        if (this.IiO != null) {
            this.IiO.dF(view);
        }
        AppMethodBeat.o(71105);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void setColorConfig(int i2) {
        AppMethodBeat.i(71106);
        Context context = MMApplicationContext.getContext();
        super.setColorConfig(i2);
        if (i2 == 5) {
            setColor(context.getResources().getColor(R.color.afz), context.getResources().getColor(R.color.a91));
            AppMethodBeat.o(71106);
            return;
        }
        if (i2 == 6) {
            setColor(context.getResources().getColor(R.color.aj), context.getResources().getColor(R.color.aa));
        }
        AppMethodBeat.o(71106);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(214245);
        super.updateDrawState(textPaint);
        if (this.IiP) {
            ao.a(textPaint, 0.8f);
        }
        AppMethodBeat.o(214245);
    }
}
