package com.tencent.mm.platformtools;

import android.app.Activity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends c {
    public j(Activity activity) {
        super(activity);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127693);
        Log.i("MicroMsg.ErrorClientProcessor", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        AppMethodBeat.o(127693);
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean b(ae aeVar) {
        AppMethodBeat.i(127694);
        Log.d("MicroMsg.ErrorClientProcessor", "handleOpenUrl");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127694);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean c(ae aeVar) {
        AppMethodBeat.i(127695);
        Log.d("MicroMsg.ErrorClientProcessor", "handleIgnore");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127695);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean d(ae aeVar) {
        AppMethodBeat.i(127696);
        Log.d("MicroMsg.ErrorClientProcessor", "handleFalseLast");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127696);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean e(ae aeVar) {
        AppMethodBeat.i(127697);
        Log.d("MicroMsg.ErrorClientProcessor", "handleFalseCancel");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        AppMethodBeat.o(127697);
        return true;
    }

    @Override // com.tencent.mm.platformtools.c
    public final boolean f(ae aeVar) {
        AppMethodBeat.i(196836);
        Log.d("MicroMsg.ErrorClientProcessor", "handleDoneBack");
        Toast.makeText(this.activity, aeVar.content, 0).show();
        this.activity.finish();
        AppMethodBeat.o(196836);
        return true;
    }
}
