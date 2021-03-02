package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KWordingService;
import com.tencent.kinda.gen.Wording;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class KindaWordingServiceImpl implements KWordingService {
    @Override // com.tencent.kinda.gen.KWordingService
    public Wording getWording(String str, String str2) {
        AppMethodBeat.i(18665);
        String str3 = "title";
        String str4 = "desc";
        Wording wording = new Wording(true, "entryTip", str3, "subTitle", str4, "subDesc");
        Context context = KindaContext.get();
        if (str.equals("valid_date")) {
            if (context != null) {
                str3 = context.getString(R.string.i9p);
                str4 = context.getString(R.string.i9q);
            }
            wording = new Wording(true, "entryTip", str3, "subTitle", str4, "subDesc");
        } else if (str.equals("cvv")) {
            if (context != null) {
                str3 = context.getString(R.string.bk7);
                str4 = context.getString(R.string.bk5);
            }
            wording = new Wording(true, "entryTip", str3, "subTitle", str4, "subDesc");
        } else if (!str.equals("phone_number") && !str.equals("sms")) {
            str.equals("person");
        }
        AppMethodBeat.o(18665);
        return wording;
    }
}
