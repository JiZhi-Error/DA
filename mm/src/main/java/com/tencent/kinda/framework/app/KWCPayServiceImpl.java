package com.tencent.kinda.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KWCPayService;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.a;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d;
import java.util.HashMap;
import java.util.Iterator;

public class KWCPayServiceImpl implements KWCPayService {
    private int mEntryScene;
    private int mPayChannel;
    private int mPayScene;
    private VoidITransmitKvDataCallback mQuitCallback = null;
    private int mReportScene;
    private String mUseCaseUrl;
    private IListener<zq> mWalletEndResultEventIListener = new IListener<zq>() {
        /* class com.tencent.kinda.framework.app.KWCPayServiceImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160754);
            this.__eventId = zq.class.getName().hashCode();
            AppMethodBeat.o(160754);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(zq zqVar) {
            AppMethodBeat.i(18375);
            boolean callback = callback(zqVar);
            AppMethodBeat.o(18375);
            return callback;
        }

        public boolean callback(zq zqVar) {
            AppMethodBeat.i(18374);
            KWCPayServiceImpl.this.mWalletEndResultEventIListener.dead();
            if (KWCPayServiceImpl.this.mQuitCallback == null) {
                AppMethodBeat.o(18374);
            } else {
                ITransmitKvData create = ITransmitKvData.create();
                if (zqVar.efK.result == -1) {
                    create.putBool("result", true);
                } else {
                    create.putBool("result", false);
                }
                KWCPayServiceImpl.this.mQuitCallback.call(create);
                AppMethodBeat.o(18374);
            }
            return false;
        }
    };

    public KWCPayServiceImpl() {
        AppMethodBeat.i(18377);
        AppMethodBeat.o(18377);
    }

    static /* synthetic */ int access$400(KWCPayServiceImpl kWCPayServiceImpl, int i2) {
        AppMethodBeat.i(18382);
        int collectReportScene = kWCPayServiceImpl.getCollectReportScene(i2);
        AppMethodBeat.o(18382);
        return collectReportScene;
    }

    private int getCollectReportScene(int i2) {
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 == 8) {
            return 4;
        }
        if (i2 == 4) {
            return 6;
        }
        return 1;
    }

    private void doRealnameSceneProgress(Context context) {
        AppMethodBeat.i(18378);
        MMActivity mMActivity = (MMActivity) context;
        mMActivity.getIntent().putExtra("process_id", a.class.hashCode());
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_activity", "kinda");
        bundle.putString("realname_verify_process_jump_plugin", "offline");
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", 8);
        bundle.putBoolean("process_finish_stay_orgpage", false);
        bundle.putBoolean("is_from_new_cashier", true);
        bundle.putString("start_activity_class", mMActivity.getClass().getName());
        com.tencent.mm.wallet_core.a.a(mMActivity, a.class, bundle, (d.a) null);
        d by = com.tencent.mm.wallet_core.a.by(mMActivity);
        if (!(by instanceof a)) {
            Log.e("WCPayService", "Fail to get correct wallet process in KWCPayServiceImpl, expect RealNameVerifyProcess got %s", by.getClass().getName());
            AppMethodBeat.o(18378);
            return;
        }
        ((a) by).HQO = new a.AbstractC1914a() {
            /* class com.tencent.kinda.framework.app.KWCPayServiceImpl.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.wallet_core.id_verify.a.AbstractC1914a
            public void run(Activity activity) {
                AppMethodBeat.i(18376);
                if (activity instanceof WalletPwdConfirmUI) {
                    if (KWCPayServiceImpl.this.mUseCaseUrl.equalsIgnoreCase("receipt")) {
                        f.aD(activity, KWCPayServiceImpl.access$400(KWCPayServiceImpl.this, KWCPayServiceImpl.this.mEntryScene));
                        AppMethodBeat.o(18376);
                        return;
                    } else if (KWCPayServiceImpl.this.mUseCaseUrl.equalsIgnoreCase("reward")) {
                        c.V(activity, "collect", ".reward.ui.QrRewardMainUI");
                    }
                }
                AppMethodBeat.o(18376);
            }
        };
        AppMethodBeat.o(18378);
    }

    @Override // com.tencent.kinda.gen.KWCPayService
    public void startUseCaseImpl(String str, ITransmitKvData iTransmitKvData, VoidITransmitKvDataCallback voidITransmitKvDataCallback) {
        AppMethodBeat.i(18379);
        MMActivity mMActivity = (MMActivity) KindaContext.get();
        if (!(mMActivity instanceof MMActivity)) {
            Log.e("PayServiceImpl", "Fail to start startUseCaseImpl due to incompatible context(%s)", mMActivity.getClass().getName());
            AppMethodBeat.o(18379);
            return;
        }
        this.mUseCaseUrl = str;
        this.mQuitCallback = voidITransmitKvDataCallback;
        this.mPayScene = iTransmitKvData.getInt("payScene");
        this.mPayChannel = iTransmitKvData.getInt("payChannel");
        this.mEntryScene = iTransmitKvData.getInt("entry_scene");
        this.mReportScene = iTransmitKvData.getInt("pay_receipt_scene");
        if (str.equalsIgnoreCase("receipt")) {
            if (isWCPayRegUser()) {
                f.aD(mMActivity, getCollectReportScene(this.mEntryScene));
                AppMethodBeat.o(18379);
                return;
            }
            doRealnameSceneProgress(mMActivity);
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("reward")) {
            if (isWCPayRegUser()) {
                c.V(mMActivity, "collect", ".reward.ui.QrRewardMainUI");
                AppMethodBeat.o(18379);
                return;
            }
            doRealnameSceneProgress(mMActivity);
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("groupaa")) {
            Intent intent = new Intent();
            if (this.mReportScene == 2) {
                intent.putExtra("enter_scene", 2);
            } else if (this.mReportScene == 1) {
                intent.putExtra("enter_scene", 4);
            }
            c.b(mMActivity, "aa", ".ui.AAEntranceUI", intent);
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("faceHongBao")) {
            c.V(mMActivity, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("transferBank")) {
            c.V(mMActivity, "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("walletLock")) {
            ((b) g.af(b.class)).j(mMActivity, new Intent());
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("paySecurity")) {
            Intent intent2 = new Intent();
            if (8 == this.mPayScene) {
                intent2.putExtra("wallet_lock_jsapi_scene", 2);
            }
            c.b(mMActivity, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent2);
            AppMethodBeat.o(18379);
        } else if (str.equalsIgnoreCase("pureBindCard")) {
            WalletJsapiData createJsapiData = createJsapiData(iTransmitKvData);
            Intent intent3 = new Intent();
            intent3.putExtra("appId", createJsapiData.appId);
            intent3.putExtra("timeStamp", createJsapiData.timeStamp);
            intent3.putExtra("nonceStr", createJsapiData.nonceStr);
            intent3.putExtra("packageExt", createJsapiData.packageExt);
            intent3.putExtra("signtype", createJsapiData.signType);
            intent3.putExtra("paySignature", createJsapiData.dVt);
            intent3.putExtra("url", createJsapiData.url);
            intent3.putExtra("key_bind_scene", 4);
            intent3.putExtra("pay_channel", createJsapiData.payChannel);
            intent3.putExtra("from_kinda", true);
            c.a((Context) mMActivity, "wallet", ".bind.ui.WalletBindUI", intent3, 0, false);
            this.mWalletEndResultEventIListener.alive();
            AppMethodBeat.o(18379);
        } else {
            if (str.equalsIgnoreCase("verifyPassword")) {
                WalletJsapiData createJsapiData2 = createJsapiData(iTransmitKvData);
                Intent intent4 = new Intent();
                intent4.putExtra("appId", createJsapiData2.appId);
                intent4.putExtra("timeStamp", createJsapiData2.timeStamp);
                intent4.putExtra("nonceStr", createJsapiData2.nonceStr);
                intent4.putExtra("packageExt", createJsapiData2.packageExt);
                intent4.putExtra("signtype", createJsapiData2.signType);
                intent4.putExtra("paySignature", createJsapiData2.dVt);
                intent4.putExtra("url", createJsapiData2.url);
                intent4.putExtra("scene", 1);
                intent4.putExtra("from_kinda", true);
                c.a((Context) mMActivity, "wallet_core", ".ui.WalletCheckPwdUI", intent4, 0, false);
                this.mWalletEndResultEventIListener.alive();
            }
            AppMethodBeat.o(18379);
        }
    }

    @Override // com.tencent.kinda.gen.KWCPayService
    public void getBannerInfoImpl(int i2, VoidITransmitKvDataCallback voidITransmitKvDataCallback) {
    }

    @Override // com.tencent.kinda.gen.KWCPayService
    public boolean isNeedWalletLock() {
        return false;
    }

    @Override // com.tencent.kinda.gen.KWCPayService
    public boolean isWCPayRegUser() {
        AppMethodBeat.i(18380);
        boolean fRk = t.fQI().fRk();
        AppMethodBeat.o(18380);
        return fRk;
    }

    private WalletJsapiData createJsapiData(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18381);
        HashMap hashMap = new HashMap();
        Iterator<String> it = iTransmitKvData.allKeys().iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap.put(next, iTransmitKvData.getString(next));
        }
        WalletJsapiData walletJsapiData = new WalletJsapiData(hashMap);
        AppMethodBeat.o(18381);
        return walletJsapiData;
    }
}
