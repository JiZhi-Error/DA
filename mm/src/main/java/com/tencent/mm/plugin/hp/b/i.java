package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.protocal.b.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i {
    public static void a(final String str, final String str2, final String str3, final DialogInterface.OnClickListener onClickListener, final String str4, final DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(117443);
        if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
            AppMethodBeat.o(117443);
            return;
        }
        Log.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.hp.b.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(117442);
                kk kkVar = new kk();
                b bVar = new b();
                bVar.title = str;
                bVar.msg = str2;
                bVar.KBq = new LinkedList<>();
                a aVar = new a();
                aVar.KBo = str3;
                bVar.KBq.add(aVar);
                a aVar2 = new a();
                aVar2.KBo = str4;
                bVar.KBq.add(aVar2);
                kkVar.dPw.type = 1;
                kkVar.dPw.dPx = bVar;
                kkVar.dPw.dPy = onClickListener;
                kkVar.dPw.dPz = onClickListener2;
                EventCenter.instance.publish(kkVar);
                AppMethodBeat.o(117442);
            }
        });
        AppMethodBeat.o(117443);
    }
}
