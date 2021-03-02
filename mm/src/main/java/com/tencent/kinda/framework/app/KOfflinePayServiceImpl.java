package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KOfflinePayService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;

public class KOfflinePayServiceImpl implements KOfflinePayService {
    private static final String TAG = "KOfflinePayServiceImpl";

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getDeviceid() {
        AppMethodBeat.i(18347);
        k.ezn();
        String TX = k.TX(196628);
        AppMethodBeat.o(18347);
        return TX;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean setDeviceid(String str) {
        AppMethodBeat.i(18348);
        if (!b.eP(str)) {
            k.ezn();
            k.bN(196628, str);
            AppMethodBeat.o(18348);
            return true;
        }
        AppMethodBeat.o(18348);
        return false;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getCodever() {
        AppMethodBeat.i(18349);
        String sb = new StringBuilder().append(g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, "")).toString();
        AppMethodBeat.o(18349);
        return sb;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean setCodever(String str) {
        AppMethodBeat.i(18350);
        if (!b.eP(str)) {
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, str);
            AppMethodBeat.o(18350);
            return true;
        }
        AppMethodBeat.o(18350);
        return false;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getCertid() {
        AppMethodBeat.i(18351);
        k.ezn();
        String TX = k.TX(196617);
        AppMethodBeat.o(18351);
        return TX;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean setCertid(String str) {
        AppMethodBeat.i(18352);
        if (!b.eP(str)) {
            k.ezn();
            k.bN(196617, str);
            AppMethodBeat.o(18352);
            return true;
        }
        AppMethodBeat.o(18352);
        return false;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void removeCertid() {
        AppMethodBeat.i(18353);
        k.ezn();
        k.bN(196617, "");
        AppMethodBeat.o(18353);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getLastSelectedCardBindSerial() {
        AppMethodBeat.i(18354);
        String eAv = a.eAv();
        AppMethodBeat.o(18354);
        return eAv;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void setLastSelectedCardBindSerial(String str) {
        AppMethodBeat.i(18355);
        a.aJk(str);
        AppMethodBeat.o(18355);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getCftToken(String str) {
        AppMethodBeat.i(18356);
        com.tencent.mm.wallet_core.c.b.hhj();
        String token = com.tencent.mm.wallet_core.c.b.getToken(str);
        AppMethodBeat.o(18356);
        return token;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public int getRemainCftTokenNum(String str) {
        AppMethodBeat.i(18357);
        k.ezn();
        k.ezq();
        int ezm = i.ezm();
        AppMethodBeat.o(18357);
        return ezm;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getTokenPin() {
        AppMethodBeat.i(18358);
        String tokenPin = a.getTokenPin();
        AppMethodBeat.o(18358);
        return tokenPin;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean setTokenPin(String str) {
        AppMethodBeat.i(18359);
        if (!b.eP(str)) {
            k.ezn();
            k.bN(196647, str);
            AppMethodBeat.o(18359);
            return true;
        }
        AppMethodBeat.o(18359);
        return false;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getCftCertSign(String str, String str2) {
        AppMethodBeat.i(18360);
        com.tencent.mm.wallet_core.c.b.hhj();
        String genUserSig = com.tencent.mm.wallet_core.c.b.genUserSig(str, str2);
        AppMethodBeat.o(18360);
        return genUserSig;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void cleanCftToken(String str) {
        AppMethodBeat.i(18361);
        com.tencent.mm.wallet_core.c.b.hhj();
        com.tencent.mm.wallet_core.c.b.clearToken(str);
        AppMethodBeat.o(18361);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean deleteCftCert(String str) {
        AppMethodBeat.i(18362);
        com.tencent.mm.wallet_core.c.b.hhj();
        com.tencent.mm.wallet_core.c.b.clearCert(str);
        AppMethodBeat.o(18362);
        return true;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean setCftTokenCode(String str, String str2, boolean z) {
        AppMethodBeat.i(18363);
        com.tencent.mm.wallet_core.c.b.hhj();
        boolean F = com.tencent.mm.wallet_core.c.b.F(str2, str, z);
        AppMethodBeat.o(18363);
        return F;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void setLastTokenUpdateTs(long j2) {
        AppMethodBeat.i(18364);
        k.ezn();
        k.bN(196632, String.valueOf(j2));
        AppMethodBeat.o(18364);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public long getLastTokenUpdateTs() {
        AppMethodBeat.i(18365);
        long j2 = 0;
        try {
            j2 = Long.valueOf(a.eAt()).longValue();
        } catch (NumberFormatException e2) {
        }
        AppMethodBeat.o(18365);
        return j2;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void setTokenUpdateInterval(int i2) {
        AppMethodBeat.i(18366);
        k.ezn();
        k.bN(196649, String.valueOf(i2));
        AppMethodBeat.o(18366);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public int getTokenUpdateInterval() {
        AppMethodBeat.i(18367);
        int eAF = a.eAF();
        AppMethodBeat.o(18367);
        return eAF;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void setRegetTokenNum(int i2) {
        AppMethodBeat.i(18368);
        a.Uh(i2);
        AppMethodBeat.o(18368);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public int getRegetTokenNum() {
        AppMethodBeat.i(18369);
        int eAM = a.eAM();
        AppMethodBeat.o(18369);
        return eAM;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public void setOfflinePayHasSuccess() {
        AppMethodBeat.i(18370);
        g.aAh().azQ().set(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(18370);
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean getOfflinePayHasSuccess() {
        AppMethodBeat.i(18371);
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(18371);
        return booleanValue;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public String getCftCSR(String str) {
        AppMethodBeat.i(18372);
        com.tencent.mm.wallet_core.c.b.hhj().hhk();
        com.tencent.mm.wallet_core.c.b hhj = com.tencent.mm.wallet_core.c.b.hhj();
        com.tencent.mm.wallet_core.b.hgC();
        String hr = hhj.hr(str, com.tencent.mm.wallet_core.b.hgE() ? 1 : 0);
        AppMethodBeat.o(18372);
        return hr;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public boolean importCftCert(String str, String str2) {
        AppMethodBeat.i(18373);
        boolean importCert = com.tencent.mm.wallet_core.c.b.hhj().importCert(str, str2);
        AppMethodBeat.o(18373);
        return importCert;
    }

    @Override // com.tencent.kinda.gen.KOfflinePayService
    public ArrayList<ITransmitKvData> getPaymentCardList() {
        return null;
    }
}
