package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KUserService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class b implements KUserService {
    @Override // com.tencent.kinda.gen.KUserService
    public void updateUserInfo(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(213354);
        Log.i("KindaUserInfoService", "updateUserInfo");
        AppMethodBeat.o(213354);
    }
}
