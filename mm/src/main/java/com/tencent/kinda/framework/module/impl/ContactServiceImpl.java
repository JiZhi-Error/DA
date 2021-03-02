package com.tencent.kinda.framework.module.impl;

import android.widget.ImageView;
import com.tencent.kinda.framework.widget.base.MMKImageView;
import com.tencent.kinda.gen.KContact;
import com.tencent.kinda.gen.KContactService;
import com.tencent.kinda.gen.KImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.wallet_core.ui.f;

public class ContactServiceImpl implements KContactService {
    @Override // com.tencent.kinda.gen.KContactService
    public KContact get(String str) {
        AppMethodBeat.i(18622);
        ContactImpl contactImpl = new ContactImpl(str);
        AppMethodBeat.o(18622);
        return contactImpl;
    }

    @Override // com.tencent.kinda.gen.KContactService
    public void attachAvatar(String str, KImageView kImageView) {
        AppMethodBeat.i(18623);
        a.b.c((ImageView) ((MMKImageView) kImageView).getView(), str);
        AppMethodBeat.o(18623);
    }

    @Override // com.tencent.kinda.gen.KContactService
    public String getUserName() {
        AppMethodBeat.i(18624);
        String username = f.getUsername();
        AppMethodBeat.o(18624);
        return username;
    }

    @Override // com.tencent.kinda.gen.KContactService
    public boolean isEuropeRegUser() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KContactService
    public long getCryptUin() {
        return 0;
    }
}
