package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class k extends c {
    public k(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127698);
        Log.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127698);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(final ae aeVar) {
        AppMethodBeat.i(127699);
        Log.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
        final Activity activity = this.activity;
        h.c(this.activity, aeVar.content, "", this.activity.getString(R.string.b98), this.activity.getString(R.string.b96), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.platformtools.k.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(196837);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", aeVar.url);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                a.jRt.i(intent, activity);
                AppMethodBeat.o(196837);
            }
        }, null);
        AppMethodBeat.o(127699);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127700);
        Log.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127700);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127701);
        Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127701);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127702);
        Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127702);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196839);
        Log.d("MicroMsg.ErrorConfirmProcessor", "handleDoneBack");
        final Activity activity = this.activity;
        h.c(this.activity, aeVar.content, "", this.activity.getString(R.string.b98), this.activity.getString(R.string.b96), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.platformtools.k.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(196838);
                activity.finish();
                AppMethodBeat.o(196838);
            }
        }, null);
        AppMethodBeat.o(196839);
        return true;
    }
}
