package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class m extends c {
    public m(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127708);
        Log.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127708);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(ae aeVar) {
        AppMethodBeat.i(127709);
        Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
        h.a(this.activity, aeVar.content, "", this.activity.getString(R.string.w1), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(127709);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127710);
        Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
        h.a(this.activity, aeVar.content, "", this.activity.getString(R.string.w1), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(127710);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127711);
        Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
        h.a(this.activity, aeVar.content, "", this.activity.getString(R.string.w1), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(127711);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127712);
        Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
        h.a(this.activity, aeVar.content, "", this.activity.getString(R.string.w1), (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(127712);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196842);
        Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleDoneBack");
        final Activity activity = this.activity;
        h.a(this.activity, aeVar.content, "", this.activity.getString(R.string.w1), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.platformtools.m.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(196841);
                activity.finish();
                AppMethodBeat.o(196841);
            }
        });
        AppMethodBeat.o(196842);
        return true;
    }
}
