package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public class RegByFacebookSetPwdUI extends SetPwdUI {
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128497);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(128497);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.account.ui.SetPwdUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128498);
        super.onDestroy();
        AppMethodBeat.o(128498);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmb;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128499);
        setMMTitle(R.string.fyx);
        AppMethodBeat.o(128499);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final ProgressDialog a(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(196889);
        q a2 = h.a(context, getString(R.string.fyo), true, onCancelListener);
        AppMethodBeat.o(196889);
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final com.tencent.mm.ak.q bpx() {
        AppMethodBeat.i(128501);
        an anVar = new an(this.ksb);
        AppMethodBeat.o(128501);
        return anVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final String bpy() {
        AppMethodBeat.i(128502);
        String obj = ((EditText) findViewById(R.id.gz_)).getText().toString();
        AppMethodBeat.o(128502);
        return obj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final String bpz() {
        AppMethodBeat.i(128503);
        String obj = ((EditText) findViewById(R.id.gz9)).getText().toString();
        AppMethodBeat.o(128503);
        return obj;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final int bpA() {
        return 382;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final void a(a.EnumC0518a aVar) {
        AppMethodBeat.i(128504);
        switch (aVar) {
            case TwoPasswordsNotMatch:
                h.n(this, R.string.fyk, R.string.fym);
                AppMethodBeat.o(128504);
                return;
            case BeyondMaximumLength:
                h.n(this, R.string.fyl, R.string.fym);
                AppMethodBeat.o(128504);
                return;
            case DisallowShortNumericPassword:
                h.n(this, R.string.hvj, R.string.u3);
                AppMethodBeat.o(128504);
                return;
            case NotReachMinimumLength:
                h.n(this, R.string.hvm, R.string.u3);
                break;
        }
        AppMethodBeat.o(128504);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.account.ui.SetPwdUI
    public final boolean o(int i2, int i3, String str) {
        AppMethodBeat.i(128505);
        if (i2 == 0 && i3 == 0) {
            g.aAh().azQ().set(57, (Object) 0);
            h.d(this, getString(R.string.fyv, new Object[]{(String) g.aAh().azQ().get(5, (Object) null)}), getString(R.string.fym), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(128495);
                    RegByFacebookSetPwdUI.this.finish();
                    AppMethodBeat.o(128495);
                }
            });
            AppMethodBeat.o(128505);
            return true;
        }
        boolean n = n(i2, i3, str);
        AppMethodBeat.o(128505);
        return n;
    }
}
