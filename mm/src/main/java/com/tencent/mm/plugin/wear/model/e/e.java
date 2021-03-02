package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30077);
        ArrayList arrayList = new ArrayList();
        arrayList.add(11013);
        arrayList.add(11014);
        arrayList.add(11015);
        AppMethodBeat.o(30077);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30078);
        switch (i2) {
            case 11013:
                EventCenter.instance.publish(new oh());
                break;
            case 11014:
                ArrayList<ca> eiK = ((l) g.af(l.class)).eiy().eiK();
                if (eiK.size() != 1) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (Build.VERSION.SDK_INT < 16) {
                        intent.putExtra("resend_fail_messages", true);
                    }
                    intent.putExtra("From_fail_notify", true);
                    Log.d("MicroMsg.Wear.HttpFailMsgServer", "startMainUI");
                    c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", intent);
                    break;
                } else {
                    String str = eiK.get(0).field_talker;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Main_User", str);
                    intent2.putExtra("From_fail_notify", true);
                    intent2.addFlags(67108864);
                    intent2.addFlags(536870912);
                    if (Build.VERSION.SDK_INT < 16) {
                        intent2.putExtra("resend_fail_messages", true);
                    }
                    Log.d("MicroMsg.Wear.HttpFailMsgServer", "startChattingUI talker=%s", str);
                    c.f(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI", intent2);
                    break;
                }
            case 11015:
                EventCenter.instance.publish(new sj());
                break;
        }
        AppMethodBeat.o(30078);
        return null;
    }
}
