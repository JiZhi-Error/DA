package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.SecureCtrItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class KindaSecureCtrItemImpl implements SecureCtrItem {
    private String rawValue;

    @Override // com.tencent.kinda.gen.SecureCtrItem
    public void setRawValue(String str) {
        this.rawValue = str;
    }

    @Override // com.tencent.kinda.gen.SecureCtrItem
    public String getValue() {
        AppMethodBeat.i(18656);
        String desedeEncode = new Encrypt().desedeEncode(this.rawValue);
        AppMethodBeat.o(18656);
        return desedeEncode;
    }
}
