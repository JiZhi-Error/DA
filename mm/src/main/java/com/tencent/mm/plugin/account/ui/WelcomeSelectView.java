package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class WelcomeSelectView extends WelcomeView {
    private Context context;
    protected View kmM;
    protected Button ksD;
    protected Button ksE;
    protected TextView ksF;

    @TargetApi(11)
    public WelcomeSelectView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(128822);
        bh(context2);
        AppMethodBeat.o(128822);
    }

    public WelcomeSelectView(Context context2) {
        super(context2);
        AppMethodBeat.i(128823);
        bh(context2);
        AppMethodBeat.o(128823);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(128824);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(128824);
    }

    /* access modifiers changed from: package-private */
    public final void init() {
        AppMethodBeat.i(128825);
        String loadApplicationLanguageSettings = LocaleUtil.loadApplicationLanguageSettings(this.context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.context);
        this.ksF.setText(LocaleUtil.getLanguageName(this.context, R.array.q, R.string.w8));
        if (loadApplicationLanguageSettings != null && loadApplicationLanguageSettings.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
            this.ksF.setText(this.context.getString(R.string.eme));
        }
        this.ksD.setText(R.string.e3r);
        this.ksE.setText(R.string.e3q);
        AppMethodBeat.o(128825);
    }

    private void bh(Context context2) {
        AppMethodBeat.i(128826);
        this.context = context2;
        View inflate = LayoutInflater.from(context2).inflate(R.layout.cc9, this);
        this.kmM = inflate.findViewById(R.id.hi5);
        this.ksD = (Button) inflate.findViewById(R.id.hi4);
        this.ksE = (Button) inflate.findViewById(R.id.hil);
        this.ksF = (TextView) inflate.findViewById(R.id.jmw);
        this.kmM.setVisibility(8);
        this.ksF.setVisibility(8);
        this.ksF.setText(LocaleUtil.getLanguageName(context2, R.array.q, R.string.w8));
        AppMethodBeat.o(128826);
    }

    public final void bpY() {
        AppMethodBeat.i(128827);
        cs(this.kmM);
        cs(this.ksF);
        this.kmM.setVisibility(0);
        this.ksF.setVisibility(0);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.WelcomeSelectView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(128821);
                g.azz().a(new bu(new bu.a() {
                    /* class com.tencent.mm.plugin.account.ui.WelcomeSelectView.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.model.bu.a
                    public final void a(com.tencent.mm.network.g gVar) {
                    }
                }, "launch normal"), 0);
                AppMethodBeat.o(128821);
            }
        });
        AppMethodBeat.o(128827);
    }
}
