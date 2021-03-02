package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends c {
    public n(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127713);
        Log.i("MicroMsg.ErrorTextStripleProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127713);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(ae aeVar) {
        AppMethodBeat.i(127714);
        Log.d("MicroMsg.ErrorTextStripleProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127714);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127715);
        Log.d("MicroMsg.ErrorTextStripleProcessor", "handleIgnore");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127715);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127716);
        Log.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseLast");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127716);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127717);
        Log.d("MicroMsg.ErrorTextStripleProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127717);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196843);
        Log.d("MicroMsg.ErrorTextStripleProcessor", "handleDoneBack");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        this.activity.finish();
        AppMethodBeat.o(196843);
        return true;
    }
}
