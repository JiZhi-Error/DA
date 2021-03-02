package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aao;
import com.tencent.mm.g.a.aap;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.eys;
import com.tencent.mm.protocal.protobuf.eyt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public eys Iyu;

    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final List<Integer> fWe() {
        AppMethodBeat.i(30085);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf((int) ErrorCode.ERROR_OUTOF_MEMORY));
        AppMethodBeat.o(30085);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wear.model.e.a
    public final byte[] s(int i2, byte[] bArr) {
        AppMethodBeat.i(30086);
        if (i2 == 11002) {
            a.jZ(1, 0);
            a.aff(0);
            aao aao = new aao();
            aao.ehA.ehB = MMApplicationContext.getContext().getResources().getStringArray(R.array.l);
            aao.ehA.dDe = 1;
            EventCenter.instance.publish(aao);
            byte[] cw = com.tencent.mm.plugin.wear.model.a.fVM().cw(bArr);
            if (cw != null) {
                try {
                    eys eys = new eys();
                    eys.parseFrom(cw);
                    eyt eyt = new eyt();
                    String str = null;
                    for (int i3 = 20; i3 > 0; i3--) {
                        str = z.aTY();
                        if (!Util.isNullOrNil(str)) {
                            break;
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e2) {
                        }
                    }
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(30086);
                        return null;
                    }
                    eyt.Username = str;
                    String loadApplicationLanguageSettings = LocaleUtil.loadApplicationLanguageSettings(MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), MMApplicationContext.getContext());
                    String applicationLanguage = LocaleUtil.getApplicationLanguage();
                    if (loadApplicationLanguageSettings.equals(LocaleUtil.LANGUAGE_DEFAULT)) {
                        eyt.rBI = applicationLanguage;
                    } else {
                        eyt.rBI = loadApplicationLanguageSettings;
                    }
                    byte[] cx = com.tencent.mm.plugin.wear.model.a.fVM().cx(eyt.toByteArray());
                    if (cx != null) {
                        this.Iyu = eys;
                        aap aap = new aap();
                        aap.ehC.dDe = 9;
                        EventCenter.instance.asyncPublish(aap, Looper.getMainLooper());
                        AppMethodBeat.o(30086);
                        return cx;
                    }
                    AppMethodBeat.o(30086);
                    return null;
                } catch (IOException e3) {
                    Log.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e3, "", new Object[0]);
                }
            }
            com.tencent.mm.plugin.wear.model.a.fVR();
        }
        AppMethodBeat.o(30086);
        return null;
    }
}
