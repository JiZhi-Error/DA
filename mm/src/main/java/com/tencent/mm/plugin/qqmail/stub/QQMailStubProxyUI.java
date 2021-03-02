package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.plugin.qqmail.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;

@a(7)
public class QQMailStubProxyUI extends HellActivity {
    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122804);
        super.onCreate(bundle);
        Log.d("MicroMsg.QQMail.QQMailStubProxyUI", "onCreate");
        final c cVar = new c(this);
        cVar.a(new c.a() {
            /* class com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.qqmail.ui.c.a
            public final void eGt() {
                AppMethodBeat.i(122802);
                Log.d("MicroMsg.QQMail.QQMailStubProxyUI", "onAfterVerify");
                cVar.release();
                QQMailStubProxyUI.this.setResult(-1);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.o(122802);
            }

            @Override // com.tencent.mm.plugin.qqmail.ui.c.a
            public final void eGu() {
                AppMethodBeat.i(122803);
                Log.e("MicroMsg.QQMail.QQMailStubProxyUI", "onVerifyFail, finish self");
                cVar.release();
                QQMailStubProxyUI.this.setResult(0);
                QQMailStubProxyUI.this.finish();
                AppMethodBeat.o(122803);
            }
        });
        AppMethodBeat.o(122804);
    }
}
