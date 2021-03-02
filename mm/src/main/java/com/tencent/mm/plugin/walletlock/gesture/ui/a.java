package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

/* access modifiers changed from: package-private */
public final class a {
    TextView Iwa = null;
    FrameLayout Iwb = null;
    PatternLockView Iwc = null;
    TextView Iwd = null;
    View mView = null;

    public a(Activity activity) {
        AppMethodBeat.i(129853);
        this.mView = View.inflate(activity, R.layout.aw0, null);
        this.Iwa = (TextView) this.mView.findViewById(R.id.ixq);
        this.Iwb = (FrameLayout) this.mView.findViewById(R.id.g97);
        this.Iwc = (PatternLockView) this.mView.findViewById(R.id.g96);
        this.Iwd = (TextView) this.mView.findViewById(R.id.ixf);
        AppMethodBeat.o(129853);
    }
}
