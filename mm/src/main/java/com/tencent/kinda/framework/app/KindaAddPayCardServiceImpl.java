package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.BindCardContext;
import com.tencent.kinda.gen.KAddPayCardService;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaAddPayCardServiceImpl implements KAddPayCardService {
    @Override // com.tencent.kinda.gen.KAddPayCardService
    public boolean isBanBindCard() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KAddPayCardService
    public String getBanBindCardTitle() {
        return "todo: @zhihongwang";
    }

    @Override // com.tencent.kinda.gen.KAddPayCardService
    public BindCardContext enterBindCardProcess(int i2) {
        AppMethodBeat.i(18383);
        BindCardContext bindCardContext = new BindCardContext();
        AppMethodBeat.o(18383);
        return bindCardContext;
    }

    @Override // com.tencent.kinda.gen.KAddPayCardService
    public boolean clearBindCardProcess() {
        return false;
    }
}
