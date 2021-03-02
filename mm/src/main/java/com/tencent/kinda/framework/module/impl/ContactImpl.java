package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KContact;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.as;

public class ContactImpl implements KContact {
    private as contact;

    public ContactImpl(String str) {
        AppMethodBeat.i(18620);
        g.aAi();
        this.contact = ((l) g.af(l.class)).aSN().Kn(str);
        AppMethodBeat.o(18620);
    }

    @Override // com.tencent.kinda.gen.KContact
    public String userName() {
        return this.contact.field_username;
    }

    @Override // com.tencent.kinda.gen.KContact
    public String displayName() {
        AppMethodBeat.i(18621);
        String arJ = this.contact.arJ();
        AppMethodBeat.o(18621);
        return arJ;
    }
}
