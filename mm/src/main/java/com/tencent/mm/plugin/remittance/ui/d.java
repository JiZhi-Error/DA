package com.tencent.mm.plugin.remittance.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.a.f;

public final class d {
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    public final void a(ResendMsgInfo resendMsgInfo, final f.c cVar) {
        AppMethodBeat.i(67942);
        if (resendMsgInfo == null) {
            Log.i("MicroMsg.RemindCollectionDialog", "init() resendMsgInfo == null");
            AppMethodBeat.o(67942);
            return;
        }
        View inflate = View.inflate(this.mContext, R.layout.bmi, null);
        a bdb = a.bdb();
        String str = resendMsgInfo.JQW;
        c.a aVar = new c.a();
        aVar.jbq = R.drawable.cll;
        bdb.a(str, (ImageView) inflate.findViewById(R.id.h0a), aVar.bdv());
        ((MMNeat7extView) inflate.findViewById(R.id.be9)).aw(resendMsgInfo.description);
        f.a aVar2 = new f.a(this.mContext);
        aVar2.aC(resendMsgInfo.title).hu(inflate).boB(resendMsgInfo.lHA).boA(resendMsgInfo.lHB);
        aVar2.c(new f.c() {
            /* class com.tencent.mm.plugin.remittance.ui.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(67941);
                Log.i("MicroMsg.RemindCollectionDialog", "onDialogClick() bOk:%s", Boolean.valueOf(z));
                if (cVar != null) {
                    cVar.e(z, str);
                }
                AppMethodBeat.o(67941);
            }
        }).show();
        AppMethodBeat.o(67942);
    }
}
