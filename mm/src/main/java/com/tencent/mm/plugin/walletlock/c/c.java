package com.tencent.mm.plugin.walletlock.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.plugin.walletlock.fingerprint.ui.FingerprintWalletLockUI;
import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends IListener<ww> {
    public c() {
        AppMethodBeat.i(161150);
        this.__eventId = ww.class.getName().hashCode();
        AppMethodBeat.o(161150);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ww wwVar) {
        AppMethodBeat.i(129894);
        ww wwVar2 = wwVar;
        if (wwVar2 != null) {
            Intent intent = wwVar2.edk.edm;
            int intExtra = intent.getIntExtra("key_wallet_lock_type", -1);
            if (wwVar2.edk.dKq != null) {
                Log.i("MicroMsg.StartWalletLockUIListener", "alvinluo startWalletLockUI type: %d", Integer.valueOf(intExtra));
                if (intExtra == 2) {
                    intent.setClass(wwVar2.edk.dKq, FingerprintWalletLockUI.class);
                } else if (intExtra == 1) {
                    intent.setClass(wwVar2.edk.dKq, GestureGuardLogicUI.class);
                }
                wwVar2.edk.dKq.startActivityForResult(intent, wwVar2.edk.requestCode);
                wwVar2.edl.isSuccess = true;
            } else {
                wwVar2.edl.isSuccess = false;
            }
            Log.i("MicroMsg.StartWalletLockUIListener", "alvinluo isSuccess: %b", Boolean.valueOf(wwVar2.edl.isSuccess));
        }
        AppMethodBeat.o(129894);
        return false;
    }
}
