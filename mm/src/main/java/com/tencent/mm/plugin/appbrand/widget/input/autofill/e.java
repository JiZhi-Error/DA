package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    e(Context context) {
        super(context, null, 0);
        AppMethodBeat.i(136645);
        this.mContext = context;
        this.arA.setInputMethodMode(2);
        this.arA.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.b7x));
        this.arz = true;
        this.arA.setFocusable(false);
        this.ark = false;
        this.arl = true;
        this.arA.setAnimationStyle(R.anim.a7);
        AppMethodBeat.o(136645);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase
    public final void show() {
        AppMethodBeat.i(136646);
        super.show();
        AppMethodBeat.o(136646);
    }
}
