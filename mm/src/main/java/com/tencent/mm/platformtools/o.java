package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends c {
    public o(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127718);
        Log.i("MicroMsg.ErrorYesNoProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127718);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(ae aeVar) {
        AppMethodBeat.i(127719);
        Log.d("MicroMsg.ErrorYesNoProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127719);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127720);
        Log.d("MicroMsg.ErrorYesNoProcessor", "handleIgnore");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127720);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127721);
        Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseLast");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127721);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127722);
        Log.d("MicroMsg.ErrorYesNoProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127722);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196844);
        Log.d("MicroMsg.ErrorYesNoProcessor", "handleDoneBack");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        this.activity.finish();
        AppMethodBeat.o(196844);
        return true;
    }
}
