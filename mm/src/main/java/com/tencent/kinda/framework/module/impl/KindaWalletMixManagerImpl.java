package com.tencent.kinda.framework.module.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaWalletMixManager;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.protocal.protobuf.exi;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class KindaWalletMixManagerImpl implements KindaWalletMixManager {
    private static final String TAG = "KindaWalletMixManagerImpl";
    private VoidCallback mCancelCallback;
    private VoidITransmitKvDataCallback mSuccessCallback;
    private IListener<aaa> mWalletPayResultEventIListener = new IListener<aaa>() {
        /* class com.tencent.kinda.framework.module.impl.KindaWalletMixManagerImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160759);
            this.__eventId = aaa.class.getName().hashCode();
            AppMethodBeat.o(160759);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(aaa aaa) {
            AppMethodBeat.i(18661);
            boolean callback = callback(aaa);
            AppMethodBeat.o(18661);
            return callback;
        }

        public boolean callback(aaa aaa) {
            AppMethodBeat.i(18660);
            int i2 = aaa.egJ.result;
            if (i2 == 0) {
                if (KindaWalletMixManagerImpl.this.mCancelCallback != null) {
                    KindaWalletMixManagerImpl.this.mCancelCallback.call();
                }
            } else if (i2 == -1 && KindaWalletMixManagerImpl.this.mSuccessCallback != null) {
                ITransmitKvData create = ITransmitKvData.create();
                Intent intent = aaa.egJ.intent;
                if (intent != null) {
                    create.putBool("is_jsapi_close_page", "1".equals(intent.getStringExtra("is_jsapi_close_page")));
                }
                KindaWalletMixManagerImpl.this.mSuccessCallback.call(create);
            }
            KindaWalletMixManagerImpl.this.mWalletPayResultEventIListener.dead();
            AppMethodBeat.o(18660);
            return false;
        }
    };

    public KindaWalletMixManagerImpl() {
        AppMethodBeat.i(18662);
        AppMethodBeat.o(18662);
    }

    @Override // com.tencent.kinda.gen.KindaWalletMixManager
    public void startWalletMixUseCaseImpl(String str, ITransmitKvData iTransmitKvData, VoidITransmitKvDataCallback voidITransmitKvDataCallback, VoidCallback voidCallback, VoidCallback voidCallback2) {
        AppMethodBeat.i(18663);
        exi genWalletMixSpGenPrePayRespFromUrl = genWalletMixSpGenPrePayRespFromUrl(str, iTransmitKvData);
        if (genWalletMixSpGenPrePayRespFromUrl != null && !Util.isNullOrNil(genWalletMixSpGenPrePayRespFromUrl.NuI)) {
            Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
            if (topOrUIPageFragmentActivity == null) {
                Log.e(TAG, "KindaWalletMixManagerImpl startWalletMixUseCaseImpl() KindaContext.getTopOrUIPageFragmentActivity() return null!");
                AppMethodBeat.o(18663);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("prepayId", iTransmitKvData.getString("prepayId"));
            intent.putExtra("is_jsapi_offline_pay", false);
            intent.putExtra("pay_gate_url", genWalletMixSpGenPrePayRespFromUrl.NuI);
            intent.putExtra("need_dialog", genWalletMixSpGenPrePayRespFromUrl.NuK);
            intent.putExtra("dialog_text", genWalletMixSpGenPrePayRespFromUrl.NuL);
            intent.putExtra("max_count", genWalletMixSpGenPrePayRespFromUrl.NuJ.LbT);
            intent.putExtra("inteval_time", genWalletMixSpGenPrePayRespFromUrl.NuJ.LbS);
            intent.putExtra("default_wording", genWalletMixSpGenPrePayRespFromUrl.NuJ.LbU);
            c.c(topOrUIPageFragmentActivity, "wallet_core", ".ui.WalletMixOrderInfoUI", intent);
        }
        this.mSuccessCallback = voidITransmitKvDataCallback;
        this.mCancelCallback = voidCallback;
        this.mWalletPayResultEventIListener.alive();
        AppMethodBeat.o(18663);
    }

    private exi genWalletMixSpGenPrePayRespFromUrl(String str, ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18664);
        if (TextUtils.isEmpty(str) || iTransmitKvData == null) {
            AppMethodBeat.o(18664);
            return null;
        }
        exi exi = new exi();
        exi.NuI = str;
        exi.NuK = false;
        exi.NuL = "";
        exi.NuJ = null;
        if (iTransmitKvData.getBool("hasCallbackRetryConf")) {
            exi.NuJ = new th();
            exi.NuJ.LbT = iTransmitKvData.getInt("maxCount");
            exi.NuJ.LbS = iTransmitKvData.getInt("intevalTime");
            exi.NuJ.LbU = iTransmitKvData.getString("defaultWording");
        }
        AppMethodBeat.o(18664);
        return exi;
    }
}
