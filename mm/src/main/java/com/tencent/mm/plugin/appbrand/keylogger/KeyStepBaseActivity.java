package com.tencent.mm.plugin.appbrand.keylogger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class KeyStepBaseActivity extends HellActivity {
    static final /* synthetic */ boolean $assertionsDisabled = (!KeyStepBaseActivity.class.desiredAssertionStatus());
    private TextView mPa;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.bv);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.be9);
        LayoutInflater from = LayoutInflater.from(this);
        int layoutId = getLayoutId();
        if ($assertionsDisabled || layoutId != 0) {
            from.inflate(layoutId, frameLayout);
            this.mPa = (TextView) findViewById(R.id.eg);
            findViewById(R.id.ei).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.keylogger.KeyStepBaseActivity.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(221271);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/keylogger/KeyStepBaseActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    KeyStepBaseActivity.this.finish();
                    a.a(this, "com/tencent/mm/plugin/appbrand/keylogger/KeyStepBaseActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(221271);
                }
            });
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public final void setTitle(String str) {
        this.mPa.setText(str);
    }
}
