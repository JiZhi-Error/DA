package com.tencent.mm.plugin.ext.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public class RedirectToChattingByPhoneStubUI extends HellActivity implements i {
    private q sOk = null;

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24512);
        super.onCreate(bundle);
        getString(R.string.a06);
        this.sOk = h.a((Context) this, "", false, (DialogInterface.OnCancelListener) null);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(24511);
                RedirectToChattingByPhoneStubUI.this.hideVKB();
                AppMethodBeat.o(24511);
            }
        }, 500);
        bg.azz().a(106, this);
        AppMethodBeat.o(24512);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(24513);
        super.onDestroy();
        bg.azz().b(106, this);
        if (this.sOk != null) {
            this.sOk.dismiss();
            this.sOk = null;
        }
        AppMethodBeat.o(24513);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24514);
        finish();
        AppMethodBeat.o(24514);
    }

    public final boolean hideVKB() {
        boolean z;
        AppMethodBeat.i(24515);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(24515);
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.o(24515);
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(24515);
            return false;
        }
        try {
            z = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e2) {
            Log.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e2);
            z = false;
        }
        Log.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(z));
        AppMethodBeat.o(24515);
        return z;
    }
}
