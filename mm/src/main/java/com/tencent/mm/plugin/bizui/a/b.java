package com.tencent.mm.plugin.bizui.a;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.a;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.d;

public final class b {
    public static d a(t tVar, String str, String str2, String str3, final y.a aVar, final y.a aVar2) {
        AppMethodBeat.i(123722);
        d.a aVar3 = new d.a(tVar.OGe);
        aVar3.b(a.decodeResource(tVar.OGe.getResources(), R.raw.dialog_successful_icon), false, 3);
        aVar3.Dk(false);
        aVar3.Dl(false);
        aVar3.bor(str).aoU(17);
        final d hbn = aVar3.hbn();
        AppCompatActivity appCompatActivity = tVar.OGe;
        if (Util.isNullOrNil(str3) || str3.length() == 0) {
            str3 = appCompatActivity.getResources().getString(R.string.b9_);
        }
        if (Util.isNullOrNil(str2) || str2.length() == 0) {
            str2 = appCompatActivity.getResources().getString(R.string.sz);
        }
        hbn.a(str3, true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.bizui.a.b.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(123720);
                hbn.dismiss();
                if (aVar2 != null) {
                    aVar2.a(true, hbn.hbk(), hbn.hbl());
                }
                AppMethodBeat.o(123720);
            }
        });
        hbn.b(str2, true, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.bizui.a.b.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(123721);
                hbn.dismiss();
                if (aVar != null) {
                    aVar.a(false, null, 0);
                }
                AppMethodBeat.o(123721);
            }
        });
        hbn.ajM(tVar.OGe.getResources().getColor(R.color.g7));
        hbn.show();
        AppMethodBeat.o(123722);
        return hbn;
    }
}
