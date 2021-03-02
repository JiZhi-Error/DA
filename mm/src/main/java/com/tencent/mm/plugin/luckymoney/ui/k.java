package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class k {
    public MMActivity qdG;
    public int ziK;
    private int ziL;

    public static final class a {
        public int oAk;
        public int olA;
        public Drawable ziM;
        public int ziN;
        public int ziO;
        public int ziP;
    }

    public k(MMActivity mMActivity) {
        AppMethodBeat.i(65941);
        this.qdG = mMActivity;
        if (egG()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.ziL = window.getStatusBarColor();
        }
        AppMethodBeat.o(65941);
    }

    public static boolean egG() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* access modifiers changed from: protected */
    public void A(Drawable drawable) {
        AppMethodBeat.i(65942);
        if (this.qdG.getSupportActionBar() != null) {
            this.qdG.getSupportActionBar().setBackgroundDrawable(drawable);
        }
        AppMethodBeat.o(65942);
    }
}
