package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCrtService;
import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.o;

public class KindaCrtServiceImpl implements KCrtService, i {
    private final String TAG = "KindaCrtServiceImpl";
    private VoidStringCallback m_failCallback;
    private KGenDigitalCrtReq m_req;
    private VoidCallback m_successCallback;

    @Override // com.tencent.kinda.gen.KCrtService
    public boolean hasCrt() {
        AppMethodBeat.i(18630);
        String crtNo = getCrtNo();
        if (crtNo == null || crtNo.isEmpty()) {
            AppMethodBeat.o(18630);
            return false;
        }
        AppMethodBeat.o(18630);
        return true;
    }

    @Override // com.tencent.kinda.gen.KCrtService
    public String getCrtNo() {
        AppMethodBeat.i(18631);
        ad.hhv();
        String crtNo = ad.getCrtNo();
        if (crtNo.isEmpty()) {
            Log.e("KindaCrtServiceImpl", "crt_no is empty.");
            AppMethodBeat.o(18631);
            return null;
        }
        Context context = KindaContext.get();
        if (context != null) {
            b.hhj().init(context);
        }
        b.hhj();
        if (!b.isCertExist(crtNo)) {
            Log.e("KindaCrtServiceImpl", "crt_no is not exist.");
            AppMethodBeat.o(18631);
            return null;
        }
        AppMethodBeat.o(18631);
        return crtNo;
    }

    @Override // com.tencent.kinda.gen.KCrtService
    public String sign(String str, byte[] bArr) {
        AppMethodBeat.i(18632);
        if (str == null || bArr == null) {
            AppMethodBeat.o(18632);
            return null;
        }
        Context context = KindaContext.get();
        if (context != null) {
            b.hhj().init(context);
        }
        b.hhj();
        String genUserSig = b.genUserSig(str, bArr);
        if (Util.isNullOrNil(genUserSig)) {
            h hVar = h.INSTANCE;
            b.hhj();
            hVar.a(20743, "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(b.getLastError()));
        }
        AppMethodBeat.o(18632);
        return genUserSig;
    }

    @Override // com.tencent.kinda.gen.KCrtService
    public void startGenDigitalCrtImpl(KGenDigitalCrtReq kGenDigitalCrtReq, VoidCallback voidCallback, VoidStringCallback voidStringCallback) {
        AppMethodBeat.i(18633);
        this.m_req = kGenDigitalCrtReq;
        this.m_successCallback = voidCallback;
        this.m_failCallback = voidStringCallback;
        g.aAg().hqi.a(1580, this);
        NetSceneKindaGenDigitalCert netSceneKindaGenDigitalCert = new NetSceneKindaGenDigitalCert(kGenDigitalCrtReq);
        Log.i("KindaCrtServiceImpl", "The Param of startGenDigitalCrtImpl is: " + kGenDigitalCrtReq.toString());
        g.azz().a(netSceneKindaGenDigitalCert, 0);
        AppMethodBeat.o(18633);
    }

    @Override // com.tencent.kinda.gen.KCrtService
    public void delCert() {
        AppMethodBeat.i(214450);
        ad.hhv();
        String crtNo = ad.getCrtNo();
        Log.i("KindaCrtServiceImpl", "do delete cert: %s", crtNo);
        ad.hhv().bpo(crtNo);
        g.azz().a(new o(crtNo), 0);
        AppMethodBeat.o(214450);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(18634);
        Log.e("KindaCrtServiceImpl", "onSceneEnd. errCode: " + i3 + " errMsg: " + str);
        if (qVar instanceof NetSceneKindaGenDigitalCert) {
            Log.e("KindaCrtServiceImpl", "NetSceneKindaGenDigitalCert");
            if (i3 == 0) {
                if (this.m_successCallback != null) {
                    this.m_successCallback.call();
                } else {
                    Log.e("KindaCrtServiceImpl", "m_successCallback is null!!");
                }
            } else if (this.m_failCallback != null) {
                this.m_failCallback.call(str);
            } else {
                Log.e("KindaCrtServiceImpl", "m_failCallback is null!!");
            }
            g.aAg().hqi.b(1580, this);
        }
        AppMethodBeat.o(18634);
    }
}
