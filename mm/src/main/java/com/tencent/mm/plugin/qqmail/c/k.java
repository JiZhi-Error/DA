package com.tencent.mm.plugin.qqmail.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.sdk.platformtools.Log;

public class k implements i, b<Bundle, Bundle> {
    private String BqZ;
    private d<Bundle> hny;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
        AppMethodBeat.i(198593);
        Bundle bundle2 = bundle;
        this.BqZ = bundle2.getString("mail_id");
        int i2 = bundle2.getInt("mail_status");
        this.hny = dVar;
        g.azz().a(new f(this.BqZ, i2), 0);
        g.azz().a(11480, this);
        AppMethodBeat.o(198593);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(198592);
        Log.i("MicroMsg.UpdateMailStatusTask", "read mail, errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!((f) qVar).BqZ.equals(this.BqZ)) {
            Log.w("MicroMsg.UpdateMailStatusTask", "not my scene, ignore");
            AppMethodBeat.o(198592);
            return;
        }
        g.azz().b(11480, this);
        if (this.hny != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("err_type", i2);
            bundle.putInt("err_code", i3);
            bundle.putString("err_msg", str);
            bundle.putString("mail_id", this.BqZ);
            this.hny.bn(bundle);
        }
        AppMethodBeat.o(198592);
    }
}
