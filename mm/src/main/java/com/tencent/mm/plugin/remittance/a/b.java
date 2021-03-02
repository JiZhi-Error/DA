package com.tencent.mm.plugin.remittance.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.ui.d;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.ui.widget.a.f;

public final class b implements com.tencent.mm.plugin.wxpaysdk.api.b {
    @Override // com.tencent.mm.plugin.wxpaysdk.api.b
    public final void a(Context context, String str, String str2, String str3, String str4, String str5, f.c cVar) {
        AppMethodBeat.i(67336);
        d dVar = new d(context);
        ResendMsgInfo resendMsgInfo = new ResendMsgInfo();
        resendMsgInfo.title = str;
        resendMsgInfo.JQW = str2;
        resendMsgInfo.description = str3;
        resendMsgInfo.lHA = str4;
        resendMsgInfo.lHB = str5;
        dVar.a(resendMsgInfo, cVar);
        AppMethodBeat.o(67336);
    }

    @Override // com.tencent.mm.plugin.wxpaysdk.api.b
    public final void a(Context context, ResendMsgInfo resendMsgInfo, f.c cVar) {
        AppMethodBeat.i(67337);
        new d(context).a(resendMsgInfo, cVar);
        AppMethodBeat.o(67337);
    }
}
