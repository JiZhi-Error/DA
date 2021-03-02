package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends c {
    public l(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127703);
        Log.i("MicroMsg.ErrorLabelProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127703);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(ae aeVar) {
        AppMethodBeat.i(127704);
        Log.d("MicroMsg.ErrorLabelProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127704);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127705);
        Log.d("MicroMsg.ErrorLabelProcessor", "handleIgnore");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127705);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127706);
        Log.d("MicroMsg.ErrorLabelProcessor", "handleFalseLast");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127706);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127707);
        Log.d("MicroMsg.ErrorLabelProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127707);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196840);
        Log.d("MicroMsg.ErrorLabelProcessor", "handleDoneBack");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        this.activity.finish();
        AppMethodBeat.o(196840);
        return true;
    }
}
