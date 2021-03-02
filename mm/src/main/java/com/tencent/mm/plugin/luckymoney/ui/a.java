package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.e;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends e {
    AbstractC1468a zbp;

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.a$a  reason: collision with other inner class name */
    public interface AbstractC1468a {
        void efU();
    }

    public a(Context context) {
        super(context, R.style.ht);
        AppMethodBeat.i(65412);
        gR();
        AppMethodBeat.o(65412);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(65413);
        super.onCreate(bundle);
        getWindow().setGravity(80);
        Display defaultDisplay = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = defaultDisplay.getWidth();
        getWindow().setAttributes(attributes);
        AppMethodBeat.o(65413);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(65414);
        if (this.zbp != null) {
            this.zbp.efU();
        }
        AppMethodBeat.o(65414);
    }
}
