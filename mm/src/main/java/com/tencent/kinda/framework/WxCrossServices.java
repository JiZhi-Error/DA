package com.tencent.kinda.framework;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.sns_cross.ISnsSceneService;
import com.tencent.kinda.framework.sns_cross.ISnsUseCaseCallback;
import com.tencent.kinda.framework.sns_cross.SnsSceneServiceFactory;
import com.tencent.kinda.framework.widget.tools.ActivityController;
import com.tencent.kinda.framework.widget.tools.ColorUtil;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aaa;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.id_verify.model.RealNameBundle;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletMixOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.ibg.WalletIbgOrderInfoUI;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.plugin.wallet_index.ui.OrderHandlerUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletBrandUI;
import com.tencent.mm.plugin.wallet_index.ui.WalletIapUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.WalletJsapiData;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WxCrossServices implements a {
    public static final int REPORT_IDKEY = 1004;
    public static final String TAG = "MicroMsg.WxCrossServices";
    private static final String TAG_SCAN_QR_CODE_PAY = "tag_scan_qrcode_pay";
    public static MaybeCrashReport report = new MaybeCrashReport();
    private IListener<l> appListener = new IListener<l>() {
        /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass11 */

        {
            AppMethodBeat.i(178754);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(178754);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(178756);
            boolean callback = callback(lVar);
            AppMethodBeat.o(178756);
            return callback;
        }

        public boolean callback(l lVar) {
            AppMethodBeat.i(178755);
            if (!(lVar == null || lVar.dCi == null)) {
                if (lVar.dCi.isActive) {
                    KindaApp.appKinda().applicationEnterForeground();
                } else {
                    KindaApp.appKinda().applicationEnterBackground();
                    WxCrossServices.report.reset();
                }
            }
            AppMethodBeat.o(178755);
            return false;
        }
    };
    private q mDialogForScanPay;
    private boolean mInitFlag = false;
    private p netListener = new p.a() {
        /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass12 */

        @Override // com.tencent.mm.network.p
        public void onNetworkChange(int i2) {
            AppMethodBeat.i(178757);
            b.hgC();
            if (!b.b(b.a.clicfg_kinda_open, true) || !WxCrossServices.this.mInitFlag || !KindaApp.appKinda().isInAnyUseCase()) {
                AppMethodBeat.o(178757);
                return;
            }
            ITransmitKvData create = ITransmitKvData.create();
            Context context = MMApplicationContext.getContext();
            if (!NetStatusUtil.isConnected(context)) {
                create.putString("type", "NON_NETWORK");
            } else if (NetStatusUtil.isWifi(context)) {
                create.putString("type", "WIFI");
                WifiInfo wifiInfo = NetStatusUtil.getWifiInfo(context);
                String ssid = wifiInfo.getSSID();
                String bssid = wifiInfo.getBSSID();
                if (!(ssid == null || bssid == null)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(TPDownloadProxyEnum.USER_SSID, ssid);
                    hashMap.put(TPDownloadProxyEnum.USER_BSSID, bssid);
                    bf aZ = k.aZ(hashMap);
                    create.putString("info", aZ.KEF);
                    create.putString("info_key", aZ.KEG);
                }
            } else {
                if (NetStatusUtil.is4G(context)) {
                    create.putString("type", "4G");
                } else if (NetStatusUtil.is3G(context)) {
                    create.putString("type", "3G");
                } else if (NetStatusUtil.is2G(context)) {
                    create.putString("type", "2G");
                } else {
                    create.putString("type", "UNKNOW");
                }
                List<NetStatusUtil.CellInfo> cellInfoList = NetStatusUtil.getCellInfoList(context);
                if (cellInfoList.size() > 0) {
                    NetStatusUtil.CellInfo cellInfo = cellInfoList.get(0);
                    String str = cellInfo.cellid;
                    String str2 = cellInfo.mcc;
                    String str3 = cellInfo.mnc;
                    if (!(str == null || str2 == null || str3 == null)) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("cellid", str);
                        hashMap2.put("mcc", str2);
                        hashMap2.put("mnc", str3);
                        bf aZ2 = k.aZ(hashMap2);
                        create.putString("info", aZ2.KEF);
                        create.putString("info_key", aZ2.KEG);
                    }
                }
            }
            KindaApp.appKinda().networkChange(create);
            AppMethodBeat.o(178757);
        }
    };

    public WxCrossServices() {
        AppMethodBeat.i(18276);
        AppMethodBeat.o(18276);
    }

    static {
        AppMethodBeat.i(18298);
        tryLoadLibrary();
        KindaContext.initStack();
        AppMethodBeat.o(18298);
    }

    public static void tryLoadLibrary() {
        AppMethodBeat.i(18277);
        if (KindaApp.isEnabled()) {
            com.tencent.mm.plugin.expansions.a.aoa("kinda_android");
        }
        AppMethodBeat.o(18277);
    }

    private void initIfNeed() {
        AppMethodBeat.i(18278);
        tryLoadLibrary();
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (aVar != null) {
            Log.i(TAG, "IFingerPrintMgr is not null");
            aVar.dJV();
        }
        if (!this.mInitFlag) {
            EventCenter.instance.add(this.appListener);
            g.aAg().a(this.netListener);
            KindaApp.instance().onCreate();
            this.mInitFlag = true;
        }
        ActivityController.resetFlag();
        AppMethodBeat.o(18278);
    }

    private void preparePayDesk() {
        AppMethodBeat.i(18279);
        k.aeJ(5);
        AppMethodBeat.o(18279);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public long getColorByMode(long j2, long j3) {
        AppMethodBeat.i(18280);
        DynamicColor dynamicColor = new DynamicColor();
        dynamicColor.mNormalColor = j2;
        dynamicColor.mDarkmodeColor = j3;
        long colorByMode = ColorUtil.getColorByMode(dynamicColor, false);
        AppMethodBeat.o(18280);
        return colorByMode;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public Activity getCrossActivity() {
        AppMethodBeat.i(18281);
        Activity topOrUIPageFragmentActivity = KindaContext.getTopOrUIPageFragmentActivity();
        AppMethodBeat.o(18281);
        return topOrUIPageFragmentActivity;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startWxpayAppPay(final Context context, Bundle bundle, String str, String str2, String str3, String str4) {
        final String str5;
        AppMethodBeat.i(18282);
        Log.i(TAG, "startWxpayAppPay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        h.INSTANCE.idkeyStat(1004, 11, 1, false);
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(2);
        PayReq payReq = new PayReq();
        payReq.fromBundle(bundle);
        final ITransmitKvData create = ITransmitKvData.create();
        create.putString("appid", payReq.appId);
        create.putString("partner_id", payReq.partnerId);
        create.putString("prepay_id", payReq.prepayId);
        create.putString("nonce_str", payReq.nonceStr);
        create.putString(AppMeasurement.Param.TIMESTAMP, payReq.timeStamp);
        create.putString("package", payReq.packageValue);
        create.putString("sign", payReq.sign);
        create.putString("sign_type", payReq.signType);
        create.putString("scene", str);
        create.putString(Constants.KEY_APP_PACKAGE_NAME, str2);
        create.putString("app_display_name", str3);
        create.putString("android_sign", str4);
        create.putString("android_sign", str4);
        create.putString("bundle_id", "");
        create.putInt("payScene", 2);
        if (bundle.getInt("_wxapi_command_type", 0) == 27) {
            str5 = "jointPay";
        } else {
            str5 = "appPay";
        }
        Log.i(TAG, "app url: %s", str5);
        if (!((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()) {
            Log.w(TAG, "soter has not initialized, wait 1s");
            h.INSTANCE.dN(1104, 48);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(170102);
                    Log.d(WxCrossServices.TAG, "soter initialized: %s", Boolean.valueOf(((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).hasInitBiometricManager()));
                    KindaApp.appKinda().startUseCase(str5, create, new UseCaseCallback() {
                        /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.kinda.gen.UseCaseCallback
                        public void call(ITransmitKvData iTransmitKvData) {
                            AppMethodBeat.i(170101);
                            if (context instanceof OrderHandlerUI) {
                                ((OrderHandlerUI) context).finish();
                            }
                            AppMethodBeat.o(170101);
                        }
                    });
                    AppMethodBeat.o(170102);
                }
            }, 1000);
            AppMethodBeat.o(18282);
            return;
        }
        KindaApp.appKinda().startUseCase(str5, create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass2 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(18268);
                if (context instanceof OrderHandlerUI) {
                    ((OrderHandlerUI) context).finish();
                    WxCrossServices.report.reset();
                }
                AppMethodBeat.o(18268);
            }
        });
        AppMethodBeat.o(18282);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startWxpayJsApiPay(final Context context, WalletJsapiData walletJsapiData, MMActivity.a aVar, int i2) {
        String str;
        AppMethodBeat.i(18283);
        h.INSTANCE.idkeyStat(1004, 12, 1, false);
        Log.i(TAG, "startWxpayJsApiPay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(walletJsapiData.dVv);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("appid", walletJsapiData.appId);
        create.putString("package", walletJsapiData.packageExt);
        create.putString("signType", walletJsapiData.signType);
        create.putString("timeStamp", walletJsapiData.timeStamp);
        create.putString("paySign", walletJsapiData.dVt);
        create.putString("nonce_str", walletJsapiData.nonceStr);
        create.putString("stepInAppUserName", walletJsapiData.dVu);
        create.putString("stepInURL", walletJsapiData.url);
        create.putInt("payChannel", walletJsapiData.payChannel);
        create.putInt("payScene", walletJsapiData.dVv);
        create.putInt("weappEnterScene", walletJsapiData.KxG);
        create.putString("weappPayCookies", walletJsapiData.iDk);
        create.putString("adUxInfo", walletJsapiData.KxO);
        KindaJSEvent kindaJSEvent = new KindaJSEvent();
        kindaJSEvent.setIMMOnActivityResult(aVar);
        kindaJSEvent.setRequestCode(i2);
        kindaJSEvent.setType(KindaJSEventType.WEB);
        create.putJSEvent("JSEvent", kindaJSEvent);
        if (walletJsapiData.KxN) {
            str = "jointPay";
        } else {
            str = "jsapiPay";
        }
        Log.i(TAG, "jsapi url: %s", str);
        KindaApp.appKinda().startUseCase(str, create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass3 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                String str;
                int i2;
                AppMethodBeat.i(18269);
                if (iTransmitKvData != null && (context instanceof WalletBrandUI)) {
                    String string = iTransmitKvData.getString("result");
                    WxCrossServices.report.reset();
                    if (string == null) {
                        Log.e(WxCrossServices.TAG, "JsApiPay UseCaseCallback get result null! ");
                        str = "";
                    } else {
                        str = string;
                    }
                    if (str.endsWith("ok")) {
                        i2 = -1;
                    } else if (str.endsWith("fail")) {
                        i2 = 5;
                    } else {
                        i2 = 0;
                    }
                    String string2 = iTransmitKvData.getString("total_fee_str");
                    WalletBrandUI walletBrandUI = (WalletBrandUI) context;
                    Log.i(WxCrossServices.TAG, "JsApiPay UseCaseCallback receive data, result: %s, resultCode:%d, total_fee_str: ", str, Integer.valueOf(i2), string2);
                    if (!com.tencent.matrix.trace.g.b.eP(string2)) {
                        String replaceAll = string2.replaceAll("[^0-9\\.]", "");
                        Log.i(WxCrossServices.TAG, "JsApiPay UseCaseCallback totalFee after format is: ".concat(String.valueOf(replaceAll)));
                        Intent intent = new Intent();
                        intent.putExtra("key_total_fee", replaceAll);
                        if (!Util.isNullOrNil(walletBrandUI.IrN) && walletBrandUI.IrN.equalsIgnoreCase("key_from_scene_appbrandgame")) {
                            walletBrandUI.n(i2, intent);
                        }
                    }
                    if (str.equals("pre_ok")) {
                        Log.i(WxCrossServices.TAG, "JsApiPay UseCaseCallback preSuccess!");
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_is_clear_failure", -1);
                        walletBrandUI.o(i2, intent2);
                        AppMethodBeat.o(18269);
                        return;
                    }
                    Log.i(WxCrossServices.TAG, "JsApiPay UseCaseCallback finish WalletBrandUI.");
                    walletBrandUI.finish();
                }
                AppMethodBeat.o(18269);
            }
        });
        AppMethodBeat.o(18283);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startWxpayH5Pay(final Context context, Bundle bundle, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(18284);
        h.INSTANCE.idkeyStat(1004, 14, 1, false);
        Log.i(TAG, "startWxpayH5Pay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(36);
        PayReq payReq = new PayReq();
        payReq.fromBundle(bundle);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("appid", payReq.appId);
        create.putString("partner_id", payReq.partnerId);
        create.putString("prepay_id", payReq.prepayId);
        create.putString("nonce_str", payReq.nonceStr);
        create.putString(AppMeasurement.Param.TIMESTAMP, payReq.timeStamp);
        create.putString("package", payReq.packageValue);
        create.putString("sign", payReq.sign);
        create.putString("sign_type", payReq.signType);
        create.putString("scene", str);
        create.putString(Constants.KEY_APP_PACKAGE_NAME, str2);
        create.putString("app_display_name", str3);
        create.putString("android_sign", str4);
        create.putString("android_sign", str4);
        create.putString("bundle_id", "");
        create.putInt("payScene", 36);
        KindaApp.appKinda().startUseCase("h5Pay", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass4 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(18270);
                if (context instanceof OrderHandlerUI) {
                    ((OrderHandlerUI) context).finish();
                    WxCrossServices.report.reset();
                }
                AppMethodBeat.o(18270);
            }
        });
        AppMethodBeat.o(18284);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startWxpayQueryCashierPay(String str, int i2) {
        AppMethodBeat.i(18285);
        h.INSTANCE.idkeyStat(1004, 15, 1, false);
        Log.i(TAG, "startWxpayQueryCashierPay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        report.markEnterPay(i2);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("req_key", str);
        create.putInt("payScene", i2);
        KindaApp.appKinda().startUseCase("queryCashierPay", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass5 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(170110);
                aaa aaa = new aaa();
                aaa.egJ.result = iTransmitKvData.getString("result").equals("ok") ? -1 : 0;
                EventCenter.instance.publish(aaa);
                WxCrossServices.report.reset();
                AppMethodBeat.o(170110);
            }
        });
        AppMethodBeat.o(18285);
    }

    public static void judgeReprot() {
        AppMethodBeat.i(214413);
        report.judgeReport();
        AppMethodBeat.o(214413);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startScanQRCodePay(Context context, int i2, String str, int i3) {
        AppMethodBeat.i(18286);
        h.INSTANCE.idkeyStat(1004, 13, 1, false);
        Log.i(TAG, "startScanQRCodePay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(1);
        ITransmitKvData create = ITransmitKvData.create();
        create.putInt("m_A8keyScene", i2);
        create.putString("qrCodeUrl", str);
        create.putInt("payChannel", i3);
        create.putInt("payScene", 1);
        if (this.mDialogForScanPay != null) {
            this.mDialogForScanPay.dismiss();
        }
        context.getString(R.string.ty);
        this.mDialogForScanPay = com.tencent.mm.ui.base.h.a(context, context.getString(R.string.inu), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass6 */

            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        Log.d(TAG_SCAN_QR_CODE_PAY, "扫码支付打开正在加载进度框。");
        KindaApp.appKinda().startUseCase("scanQRCodePay", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass7 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(18272);
                Log.i(WxCrossServices.TAG, "startScanQRCodePay call()");
                if (WxCrossServices.this.mDialogForScanPay != null) {
                    Log.d(WxCrossServices.TAG_SCAN_QR_CODE_PAY, "扫码支付关闭正在加载进度框。");
                    WxCrossServices.this.mDialogForScanPay.dismiss();
                    WxCrossServices.this.mDialogForScanPay = null;
                }
                aaa aaa = new aaa();
                aaa.egJ.result = iTransmitKvData.getInt("scanQRCodeState");
                aaa.egJ.egL = true;
                EventCenter.instance.publish(aaa);
                WxCrossServices.report.reset();
                AppMethodBeat.o(18272);
            }
        });
        AppMethodBeat.o(18286);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startSNSPay(final Context context, PayInfo payInfo) {
        AppMethodBeat.i(18287);
        h.INSTANCE.idkeyStat(1004, 10, 1, false);
        Log.i(TAG, "startSNSPay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(payInfo.dVv);
        if (!((a) g.af(a.class)).canOpenKindaCashier(context)) {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.string.ieo), "", context.getString(R.string.ame), new DialogInterface.OnClickListener() {
                /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass8 */

                public void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(178761);
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                    AppMethodBeat.o(178761);
                }
            });
            AppMethodBeat.o(18287);
            return;
        }
        ISnsSceneService createService = SnsSceneServiceFactory.createService(payInfo.dVv);
        ISnsUseCaseCallback createCallback = SnsSceneServiceFactory.createCallback(payInfo.dVv);
        createService.setData(context, payInfo);
        createCallback.setData(context, payInfo);
        KindaApp.appKinda().startUseCase("snsPay", createService.generateSnsUseCaseData(), createCallback);
        AppMethodBeat.o(18287);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startOfflinePay(Context context, String str, String str2, int i2) {
        AppMethodBeat.i(18288);
        h.INSTANCE.idkeyStat(1004, 18, 1, false);
        Log.i(TAG, "startOfflinePay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        com.tencent.mm.plugin.soter.d.a.flL();
        report.markEnterPay(8);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("req_key", str);
        create.putString("prefer_bind_serial", str2);
        create.putInt("payScene", 8);
        create.putInt("payChannel", i2);
        KindaApp.appKinda().startUseCase("offlinePay", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass9 */

            {
                AppMethodBeat.i(160753);
                AppMethodBeat.o(160753);
            }

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(170111);
                boolean bool = iTransmitKvData.getBool("pay_result");
                Log.i(WxCrossServices.TAG, "startOfflinePay UseCaseCallback pay_result: ".concat(String.valueOf(bool)));
                aaa aaa = new aaa();
                aaa.egJ.result = 0;
                if (bool) {
                    aaa.egJ.result = -1;
                    aaa.egJ.intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putInt("payScene", 8);
                    bundle.putString("pay_bind_serial", iTransmitKvData.getString("pay_bind_serial"));
                    aaa.egJ.intent.putExtras(bundle);
                }
                EventCenter.instance.publish(aaa);
                WxCrossServices.report.reset();
                AppMethodBeat.o(170111);
            }
        });
        AppMethodBeat.o(18288);
    }

    public void startOfflinePrePay(final Context context, int i2, int i3, int i4, Map<String, String> map) {
        AppMethodBeat.i(18289);
        Log.i(TAG, "startOfflinePrePay %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        ITransmitKvData create = ITransmitKvData.create();
        create.putInt("entry_scene", i2);
        create.putInt("payScene", 8);
        create.putInt("payChannel", i3);
        create.putInt("pay_receipt_scene", i4);
        if (map != null) {
            ITransmitKvData create2 = ITransmitKvData.create();
            create2.putString("card_id", map.get("card_id"));
            create2.putString("user_card_id", map.get("user_card_id"));
            create2.putString("card_code", map.get("card_code"));
            create.putKvData("member_card", create2);
        }
        KindaApp.appKinda().startUseCase("offline", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass10 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(178753);
                if (context instanceof WalletOfflineEntranceUI) {
                    ((WalletOfflineEntranceUI) context).finish();
                }
                AppMethodBeat.o(178753);
            }
        });
        AppMethodBeat.o(18289);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public boolean canOpenKindaCashier(Context context) {
        AppMethodBeat.i(18290);
        initIfNeed();
        com.tencent.mm.wallet_core.b.hgC();
        if (!com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true)) {
            AppMethodBeat.o(18290);
            return true;
        } else if (KindaApp.appKinda().getIsPaying()) {
            Log.i("canOpenKindaCashier", "is paying");
            AppMethodBeat.o(18290);
            return false;
        } else {
            Log.i("canOpenKindaCashier", "not paying");
            KindaApp.appKinda().stopUseCase("rootUseCase");
            AppMethodBeat.o(18290);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public boolean TenPaySDKABTestKindaEnable() {
        AppMethodBeat.i(18293);
        com.tencent.mm.wallet_core.b.hgC();
        boolean b2 = com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_open, true);
        AppMethodBeat.o(18293);
        return b2;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startBindCardUseCase(Context context, final Bundle bundle) {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(18294);
        h.INSTANCE.idkeyStat(1004, 16, 1, false);
        Log.i(TAG, "startBindCardUseCase %s", Util.getStack());
        initIfNeed();
        if (bundle.getInt("key_bind_scene", -1) == 1) {
            z = true;
        } else {
            z = false;
        }
        int i3 = bundle.getInt("reg_flag", -1);
        if (i3 == -1) {
            i3 = t.fQD().fRN().field_is_reg;
        }
        if (bundle.getInt("key_bind_scene") == 8) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (t.fQI().fRt()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        String trueName = t.fQI().getTrueName();
        ITransmitKvData create = ITransmitKvData.create();
        create.putBool("bPresent", z);
        create.putInt("regFlag", i3);
        create.putInt("cardUserFlag", i2);
        create.putString("trueName", trueName);
        create.putInt("addPayCardScene", bundle.getInt("key_bind_scene", -1));
        create.putInt("bindScene", bundle.getInt("key_bind_scene", -1));
        create.putInt("realnameScene", bundle.getInt("entry_scene", -1));
        create.putBool("isWebankLoadScene", z2);
        create.putString("password", bundle.getString("key_pwd1"));
        if (!bundle.getString("kreq_token", "").isEmpty()) {
            create.putString("token", bundle.getString("kreq_token"));
        }
        create.putBool("canChangeRealname", bundle.getBoolean("key_bind_show_change_card", false));
        create.putBool("canPassPwd", bundle.getBoolean("key_bind_card_can_pass_pwd", false));
        create.putString("usertoken", bundle.getString("key_bind_card_user_token", ""));
        RealNameBundle realNameBundle = null;
        if (bundle.containsKey("realname_verify_process_bundle")) {
            realNameBundle = (RealNameBundle) bundle.getParcelable("realname_verify_process_bundle");
        }
        if (realNameBundle != null) {
            create.putBool("isNewRealname", true);
            create.putString("rn_realname_scene", bundle.getString("key_realname_scene", ""));
            create.putString("rn_true_name", realNameBundle.HTZ);
            create.putString("rn_cre_type", new StringBuilder().append(realNameBundle.HUc).toString());
            create.putString("rn_cre_name", realNameBundle.HUd);
            create.putString("rn_identify_card_origin", realNameBundle.HUa);
            create.putString("rn_encry_identity_card", realNameBundle.HUb);
            create.putInt("rn_creid_renewal_origin", realNameBundle.HUj);
            create.putInt("rn_cre_expire_date_origin_year", realNameBundle.HUl);
            create.putInt("rn_cre_expire_date_origin_month", realNameBundle.HUm);
            create.putInt("rn_cre_expire_date_origin_day", realNameBundle.HUn);
            create.putInt("rn_cre_effect_date_origin_year", realNameBundle.HUx);
            create.putInt("rn_cre_effect_date_origin_month", realNameBundle.HUy);
            create.putInt("rn_cre_effect_date_origin_day", realNameBundle.HUz);
            create.putInt("rn_birth_date_origin_year", realNameBundle.HUp);
            create.putInt("rn_birth_date_origin_month", realNameBundle.HUq);
            create.putInt("rn_birth_date_origin_day", realNameBundle.HUr);
            create.putString("rn_country", realNameBundle.HUf);
            create.putString("rn_province", realNameBundle.HUg);
            create.putString("rn_city", realNameBundle.HUh);
            create.putString("rn_areaStr", realNameBundle.HUi);
            create.putString("rn_profession_type", new StringBuilder().append(realNameBundle.HUe.HTY).toString());
            create.putString("rn_profession_name", realNameBundle.HUe.HTX);
            create.putString("rn_iso_country_code", realNameBundle.HUs);
            create.putInt("rn_sex", realNameBundle.fuA);
            create.putString("rn_detail_address", realNameBundle.HUv);
            boolean z3 = bundle.getBoolean("realname_verify_process_need_face", false);
            create.putBool("rn_is_need_face", z3);
            if (z3) {
                create.putInt("rn_scene", (int) bundle.getLong("realname_verify_process_face_scene"));
                create.putString("rn_package", bundle.getString("realname_verify_process_face_package"));
                create.putString("rn_package_sign", bundle.getString("realname_verify_process_face_package_sign"));
            }
            create.putString("rn_session_id", bundle.getString("key_realname_sessionid", ""));
        }
        create.putInt("bindCardScene", bundle.getInt("key_bind_scene"));
        create.putString("bindCardUuid", z.getBindCardUuid());
        create.putString("deviceName", Build.MODEL);
        create.putString("deviceType", "");
        create.putBool("BindCardV2", true);
        KindaApp.appKinda().startUseCase("addPayCard", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass13 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(178758);
                Log.i(WxCrossServices.TAG, "startBindCardUseCase callback");
                lj ljVar = new lj();
                if (iTransmitKvData.getInt("retcode") == 1) {
                    ljVar.dQz.dQA = true;
                    ljVar.dQz.dQm = iTransmitKvData.getString("bind_serial");
                    ljVar.dQz.dQC = iTransmitKvData.getString("password");
                    ljVar.dQz.dQl = iTransmitKvData.getString("bank_type");
                    ljVar.dQz.dQD = iTransmitKvData.getString("mobile_no");
                    ljVar.dQz.dQE = iTransmitKvData.getString("realname_title");
                    ljVar.dQz.dQF = iTransmitKvData.getString("realname_desc");
                    ljVar.dQz.dQG = iTransmitKvData.getString("realname_btn_title");
                    ljVar.dQz.dQH = iTransmitKvData.getString("realname_err_jump_page");
                } else if (iTransmitKvData.getInt("retcode") == -1) {
                    ljVar.dQz.dQA = false;
                }
                ljVar.dQz.dQB = bundle.getBoolean("key_need_bind_response", false);
                EventCenter.instance.publish(ljVar);
                AppMethodBeat.o(178758);
            }
        });
        AppMethodBeat.o(18294);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startResetPwdUseCase(Context context, Bundle bundle) {
        AppMethodBeat.i(170112);
        h.INSTANCE.idkeyStat(1004, 17, 1, false);
        Log.i(TAG, "startResetPwdUseCase %s", Util.getStack());
        initIfNeed();
        ITransmitKvData create = ITransmitKvData.create();
        if (bundle == null) {
            create.putBool("bResetPwdFromPayManage", false);
            create.putInt("realnameScene", 0);
            create.putInt("payScene", 0);
        } else {
            create.putBool("bResetPwdFromPayManage", bundle.getBoolean("key_is_paymanager", false));
            create.putInt("realnameScene", 0);
            create.putInt("payScene", 0);
        }
        KindaApp.appKinda().startUseCase("resetPwdUseCase", create, null);
        AppMethodBeat.o(170112);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startJSApiWCPaySecurityCrosscut(Map<String, Object> map) {
        AppMethodBeat.i(18295);
        if (map == null) {
            AppMethodBeat.o(18295);
            return;
        }
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("secure_crosscut", "1");
        create.putString("appId", (String) map.get("appId"));
        create.putString("timeStamp", (String) map.get("timeStamp"));
        create.putString("nonceStr", (String) map.get("nonceStr"));
        create.putString("package", (String) map.get("package"));
        create.putString("signType", (String) map.get("signType"));
        create.putString("paySign", (String) map.get("paySign"));
        KindaApp.appKinda().notifyAllUseCases(create);
        AppMethodBeat.o(18295);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startJsApiComponentUseCase(Context context, WalletJsapiData walletJsapiData, final MMActivity.a aVar, final int i2) {
        AppMethodBeat.i(18296);
        initIfNeed();
        ITransmitKvData create = ITransmitKvData.create();
        if (walletJsapiData.KxP != null) {
            for (Map.Entry<String, String> entry : walletJsapiData.KxP.entrySet()) {
                create.putString(entry.getKey(), entry.getValue());
            }
        }
        create.putJSEvent("JSEvent", new KJSEvent() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass14 */

            @Override // com.tencent.kinda.gen.KJSEvent
            public KindaJSEventType kindaGetType() {
                return KindaJSEventType.WEB;
            }

            @Override // com.tencent.kinda.gen.KJSEvent
            public void kindaEndWithResult(String str, HashMap<String, String> hashMap) {
                int i2;
                AppMethodBeat.i(178759);
                if (aVar != null) {
                    if (str.endsWith("ok")) {
                        i2 = -1;
                    } else if (str.endsWith("fail")) {
                        i2 = 5;
                    } else {
                        i2 = 0;
                    }
                    Intent intent = new Intent();
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        intent.putExtra(entry.getKey(), entry.getValue());
                    }
                    aVar.d(i2, i2, intent);
                }
                AppMethodBeat.o(178759);
            }

            @Override // com.tencent.kinda.gen.KJSEvent
            public void kindaCloseWebViewImpl(boolean z, VoidCallback voidCallback) {
            }
        });
        KindaApp.appKinda().startUseCase(walletJsapiData.DWX, create, null);
        AppMethodBeat.o(18296);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void notifyUploadCardSuccess() {
        AppMethodBeat.i(18297);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("upload_id_success_notifycation", "1");
        KindaApp.appKinda().notifyAllUseCases(create);
        AppMethodBeat.o(18297);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startWalletBalanceFetchUseCase(final Context context, final Bundle bundle) {
        AppMethodBeat.i(170113);
        Log.i(TAG, "startWalletBalanceFetchUseCase %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        ITransmitKvData create = ITransmitKvData.create();
        create.putInt("payScene", bundle.getInt("payScene"));
        create.putString("totalFee", bundle.getString("totalFee"));
        create.putString("feeType", bundle.getString("feeType"));
        create.putString("bankType", bundle.getString("bankType"));
        create.putString("bindSerial", bundle.getString("bindSerial"));
        create.putString("operation", bundle.getString("operation"));
        KindaApp.appKinda().startUseCase("fetchBalance", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass15 */
            private byte _hellAccFlag_;

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(178760);
                if (!(context instanceof WalletBalanceFetchUI)) {
                    AppMethodBeat.o(178760);
                    return;
                }
                int i2 = iTransmitKvData.getInt("result");
                Log.i(WxCrossServices.TAG, "startWalletBalanceFetchUseCase result：%s", Integer.valueOf(i2));
                switch (i2) {
                    case 1:
                        Intent intent = new Intent(context, WalletBalanceManagerUI.class);
                        intent.addFlags(67108864);
                        Context context = context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/WxCrossServices$15", "call", "(Lcom/tencent/kinda/gen/ITransmitKvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(178760);
                        return;
                    case 2:
                        AppMethodBeat.o(178760);
                        return;
                    case 3:
                        h.INSTANCE.a(16398, bundle.getString("reportSessionId"), 8, "", "");
                        AppMethodBeat.o(178760);
                        return;
                    default:
                        Log.i(WxCrossServices.TAG, "startWalletBalanceFetch unknown result：%s", Integer.valueOf(i2));
                        AppMethodBeat.o(178760);
                        return;
                }
            }
        });
        AppMethodBeat.o(170113);
    }

    public void startLqtFixedDepositEntranceUseCase(final Context context, Bundle bundle) {
        AppMethodBeat.i(214414);
        Log.i(TAG, "start LqtFixedDepositEntranceUseCase");
        KindaApp.appKinda().startUseCase("LQTFixedDepositEntranceUseCase", ITransmitKvData.create(), new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass16 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(214403);
                if ((context instanceof WalletLqtDetailUI) && iTransmitKvData != null && iTransmitKvData.getInt("LQTMainPageShouldRefresh") == 1) {
                    ((WalletLqtDetailUI) context).bn(0, true);
                }
                AppMethodBeat.o(214403);
            }
        });
        AppMethodBeat.o(214414);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startLqtFixedDepositMakePlanUseCase(final Context context, Bundle bundle) {
        AppMethodBeat.i(214415);
        Log.i(TAG, "start LqtFixedDepositMakePlanUseCase");
        KindaApp.appKinda().startUseCase("LQTFixedDepositMakePlanUseCase", ITransmitKvData.create(), new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass17 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(214404);
                if ((context instanceof WalletLqtDetailUI) && iTransmitKvData != null && iTransmitKvData.getInt("LQTMainPageShouldRefresh") == 1) {
                    ((WalletLqtDetailUI) context).bn(0, true);
                }
                AppMethodBeat.o(214404);
            }
        });
        AppMethodBeat.o(214415);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startLqtFixedDepositPlanListUseCase(final Context context, Bundle bundle) {
        AppMethodBeat.i(214416);
        Log.i(TAG, "start LqtFixedDepositPlanListUseCase");
        KindaApp.appKinda().startUseCase("LQTFixedDepositPlanListUseCase", ITransmitKvData.create(), new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass18 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(214405);
                if ((context instanceof WalletLqtDetailUI) && iTransmitKvData != null && iTransmitKvData.getInt("LQTMainPageShouldRefresh") == 1) {
                    ((WalletLqtDetailUI) context).bn(0, true);
                }
                AppMethodBeat.o(214405);
            }
        });
        AppMethodBeat.o(214416);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startModifyPwdUseCase(Context context, Bundle bundle) {
        AppMethodBeat.i(214417);
        Log.i(TAG, "start startModifyPwdUseCase");
        ITransmitKvData create = ITransmitKvData.create();
        StringBuilder sb = new StringBuilder();
        g.aAf();
        create.putString("sessionId", sb.append(com.tencent.mm.kernel.a.ayV()).append("_").append(f.hhV()).toString());
        KindaApp.appKinda().startUseCase("modifyPwdUseCase", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass19 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
            }
        });
        AppMethodBeat.o(214417);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startFastBindUseCase(String str, int i2, final Runnable runnable) {
        AppMethodBeat.i(214418);
        Log.i(TAG, "start startFastBindUseCase");
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("qr_code", str);
        create.putInt("channel", i2);
        KindaApp.appKinda().startUseCase("fastbindcard", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass20 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(214406);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(214406);
            }
        });
        AppMethodBeat.o(214418);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startUseCase(String str, Object obj, Object obj2) {
        AppMethodBeat.i(214419);
        Log.i(TAG, "start common useCase");
        if (!(obj instanceof ITransmitKvData) || !(obj2 instanceof UseCaseCallback)) {
            Log.i(TAG, "startUseCase fail, data or callback is not the right type");
            AppMethodBeat.o(214419);
            return;
        }
        KindaApp.appKinda().startUseCase(str, (ITransmitKvData) obj, (UseCaseCallback) obj2);
        AppMethodBeat.o(214419);
    }

    public static class MaybeCrashReport {
        public void markEnterPay(int i2) {
            AppMethodBeat.i(214410);
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTER_PAY_TIME_LONG_SYNC, Long.valueOf(System.currentTimeMillis()));
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTER_PAY_SCENE_INT_SYNC, Integer.valueOf(i2));
            AppMethodBeat.o(214410);
        }

        public void reset() {
            AppMethodBeat.i(214411);
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTER_PAY_TIME_LONG_SYNC, (Object) 0L);
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_ENTER_PAY_SCENE_INT_SYNC, (Object) 0);
            AppMethodBeat.o(214411);
        }

        public void judgeReport() {
            AppMethodBeat.i(214412);
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_ENTER_PAY_TIME_LONG_SYNC, (Object) 0L)).longValue();
            if (longValue > 0) {
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_ENTER_PAY_SCENE_INT_SYNC, (Object) 0)).intValue();
                h.INSTANCE.a(20560, Integer.valueOf(intValue), Long.valueOf(longValue));
            }
            reset();
            AppMethodBeat.o(214412);
        }
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public boolean isSwitch2InWxAppPay(String str) {
        AppMethodBeat.i(214420);
        if (str == null) {
            Log.i(TAG, "isSwitch2InWxAppPay prepayId is null");
            AppMethodBeat.o(214420);
            return false;
        } else if (str.startsWith("ts_")) {
            AppMethodBeat.o(214420);
            return false;
        } else {
            AppMethodBeat.o(214420);
            return true;
        }
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public void startInWxAppPayUseCase(final Context context, final String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(214421);
        h.INSTANCE.idkeyStat(1004, 19, 1, false);
        Log.i(TAG, "startInWxAppPayUseCase %s", Util.getStack());
        initIfNeed();
        preparePayDesk();
        report.markEnterPay(i2);
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("prepay_id", str);
        create.putString("bank_type", str3);
        create.putString("bind_serial", str2);
        create.putInt("payScene", i2);
        create.putInt("payChannel", i3);
        if (context instanceof EmojiStoreV2RewardUI) {
            create.putString("succ_tip", context.getString(R.string.g3b));
        }
        KindaApp.appKinda().startUseCase("inWxAppPay", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass21 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                c cJ;
                AppMethodBeat.i(214407);
                if (context instanceof WalletLqtSaveFetchUI) {
                    String string = iTransmitKvData.getString("result");
                    String string2 = iTransmitKvData.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                    WalletLqtSaveFetchUI walletLqtSaveFetchUI = (WalletLqtSaveFetchUI) context;
                    String str = str;
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "onKindaInWxAppPayCallback result:%s transactionId:%s", string, string2);
                    if (walletLqtSaveFetchUI.HAM != null) {
                        ae aeVar = walletLqtSaveFetchUI.HAM;
                        String str2 = walletLqtSaveFetchUI.HBx;
                        if (string.equalsIgnoreCase("ok")) {
                            Log.i("MicroMsg.LqtSaveFetchLogic", "%s onKindaInWxAppPayCallback, doQueryPurchaseResult, accountType: %s, reqkey: %s", Integer.valueOf(aeVar.hashCode()), Integer.valueOf(aeVar.accountType), str);
                            aeVar.dDM = string2;
                            String str3 = aeVar.HuG.get(str);
                            if (!Util.isNullOrNil(str3)) {
                                aeVar.HuA = str3;
                            }
                            if (aeVar.Huz instanceof WalletLqtSaveFetchUI) {
                                ((WalletLqtSaveFetchUI) aeVar.Huz).xQ(true);
                                ((WalletLqtSaveFetchUI) aeVar.Huz).fNV();
                            }
                            aeVar.fW(str2, 0);
                        }
                    }
                } else if (context instanceof EmojiStoreV2RewardUI) {
                    String string3 = iTransmitKvData.getString("result");
                    EmojiStoreV2RewardUI emojiStoreV2RewardUI = (EmojiStoreV2RewardUI) context;
                    if (string3.equalsIgnoreCase("ok")) {
                        emojiStoreV2RewardUI.cIf();
                        h.INSTANCE.a(12738, emojiStoreV2RewardUI.rcq, Integer.valueOf(emojiStoreV2RewardUI.rln), Integer.valueOf(emojiStoreV2RewardUI.rbG), 1);
                        h.INSTANCE.idkeyStat(408, 9, 1, false);
                        emojiStoreV2RewardUI.lB(true);
                        emojiStoreV2RewardUI.finish();
                    } else if (string3.equalsIgnoreCase("cancel")) {
                        h.INSTANCE.a(12738, emojiStoreV2RewardUI.rcq, Integer.valueOf(emojiStoreV2RewardUI.rln), Integer.valueOf(emojiStoreV2RewardUI.rbG), 3);
                        h.INSTANCE.idkeyStat(408, 3, 1, false);
                    } else if (string3.equalsIgnoreCase("fail")) {
                        if (!emojiStoreV2RewardUI.rlA) {
                            emojiStoreV2RewardUI.rlA = true;
                            h.INSTANCE.a(12738, emojiStoreV2RewardUI.rcq, Integer.valueOf(emojiStoreV2RewardUI.rln), Integer.valueOf(emojiStoreV2RewardUI.rbG), 2);
                        }
                        h.INSTANCE.idkeyStat(408, 4, 1, false);
                    }
                } else if (context instanceof WalletIapUI) {
                    String string4 = iTransmitKvData.getString("result");
                    WalletIapUI walletIapUI = (WalletIapUI) context;
                    if (walletIapUI.Isj == null) {
                        Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback mPurchaseFinishedListener is null");
                    } else {
                        if (string4.equalsIgnoreCase("ok")) {
                            cJ = c.cJ(0, "");
                        } else if (string4.equalsIgnoreCase("cancel")) {
                            cJ = c.cJ(1, "");
                        } else {
                            cJ = c.cJ(6, "");
                        }
                        walletIapUI.Isj.a(cJ, new com.tencent.mm.plugin.wallet_index.b.a.c(walletIapUI.Irh.rcD, walletIapUI.Irh.Irm, walletIapUI.Irh.IqF, walletIapUI.Irh.IqG));
                        Log.i("MicroMsg.WalletIapUI", "onKindaInWxAppPayCallback result:%s iapResult:%s", string4, cJ);
                    }
                }
                WxCrossServices.report.reset();
                AppMethodBeat.o(214407);
            }
        });
        AppMethodBeat.o(214421);
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public boolean startOverseaWalletSuccPageUseCase(final Context context, Bundle bundle) {
        AppMethodBeat.i(214422);
        com.tencent.mm.wallet_core.b.hgC();
        if (!com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_hk_wallet_succ_page_android, false)) {
            Log.i(TAG, "startOverseaWalletSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
            AppMethodBeat.o(214422);
            return false;
        }
        h.INSTANCE.idkeyStat(1004, 20, 1, false);
        Log.i(TAG, "startOverseaWalletSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is true");
        initIfNeed();
        preparePayDesk();
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("appid", bundle.getString("appid"));
        create.putString(AppMeasurement.Param.TIMESTAMP, bundle.getString(AppMeasurement.Param.TIMESTAMP));
        create.putString("nonce_str", bundle.getString("nonce_str"));
        create.putString("package", bundle.getString("package"));
        create.putInt("input_pay_scene", bundle.getInt("input_pay_scene"));
        create.putString("sign_type", bundle.getString("sign_type"));
        create.putString("pay_sign", bundle.getString("pay_sign"));
        create.putString("req_key", bundle.getString("req_key"));
        create.putInt("origin_pay_scene", bundle.getInt("origin_pay_scene"));
        create.putString("order_id", bundle.getString("order_id"));
        create.putInt("retry_max_count", bundle.getInt("retry_max_count"));
        create.putInt("retry_interval_seconds", bundle.getInt("retry_interval_seconds"));
        create.putString("retry_default_wording", bundle.getString("retry_default_wording"));
        KindaApp.appKinda().startUseCase("overseaWalletSuccPage", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass22 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                int i2 = 0;
                AppMethodBeat.i(214408);
                if (context instanceof WalletMixOrderInfoUI) {
                    String string = iTransmitKvData.getString("result");
                    boolean bool = iTransmitKvData.getBool("is_pending");
                    boolean bool2 = iTransmitKvData.getBool("is_jsapi_close_page");
                    WalletMixOrderInfoUI walletMixOrderInfoUI = (WalletMixOrderInfoUI) context;
                    Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack begin, result=%s is_pending=%b is_jsapi_close_page=%b", string, Boolean.valueOf(bool), Boolean.valueOf(bool2));
                    walletMixOrderInfoUI.Ihg = bool;
                    if (string.equalsIgnoreCase("pre_succ")) {
                        Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack not handle pre_succ");
                        AppMethodBeat.o(214408);
                        return;
                    } else if (string.equalsIgnoreCase("after_show_succ_page")) {
                        Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle after_show_succ_page, payScene=%d", Integer.valueOf(walletMixOrderInfoUI.efQ));
                        if (walletMixOrderInfoUI.efQ == 1) {
                            WalletMixOrderInfoUI.aeS(-1);
                            walletMixOrderInfoUI.setResult(-1);
                            walletMixOrderInfoUI.finish();
                            AppMethodBeat.o(214408);
                            return;
                        }
                    } else if (string.equalsIgnoreCase("ok")) {
                        Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle ok, payScene=%d prepayId=%s", Integer.valueOf(walletMixOrderInfoUI.efQ), walletMixOrderInfoUI.prepayId);
                        if (walletMixOrderInfoUI.efQ == 2) {
                            WalletMixOrderInfoUI.aeS(-1);
                            if (!Util.isNullOrNil(walletMixOrderInfoUI.prepayId)) {
                                aaa aaa = new aaa();
                                Intent intent = new Intent();
                                intent.putExtra("intent_pay_end", true);
                                if (bool2) {
                                    i2 = 1;
                                }
                                intent.putExtra("is_jsapi_close_page", i2);
                                aaa.egJ.intent = intent;
                                aaa.egJ.dDL = walletMixOrderInfoUI.prepayId;
                                aaa.egJ.result = -1;
                                aaa.egJ.egM = 1;
                                EventCenter.instance.publish(aaa);
                            }
                            walletMixOrderInfoUI.setResult(-1);
                            walletMixOrderInfoUI.finish();
                            AppMethodBeat.o(214408);
                            return;
                        }
                    } else {
                        Log.i("MicroMsg.WalletMixOrderInfoUI", "onKindaOverseaWalletSuccPageBack handle else, payScene=%d prepayId=%s", Integer.valueOf(walletMixOrderInfoUI.efQ), walletMixOrderInfoUI.prepayId);
                        WalletMixOrderInfoUI.aeS(0);
                        aaa aaa2 = new aaa();
                        aaa2.egJ.dDL = walletMixOrderInfoUI.prepayId;
                        aaa2.egJ.result = 0;
                        EventCenter.instance.publish(aaa2);
                        walletMixOrderInfoUI.setResult(0);
                        walletMixOrderInfoUI.finish();
                    }
                }
                AppMethodBeat.o(214408);
            }
        });
        AppMethodBeat.o(214422);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.wallet.a
    public boolean startPayIBGJsGetSuccPageUseCase(final Context context, Bundle bundle) {
        AppMethodBeat.i(214423);
        com.tencent.mm.wallet_core.b.hgC();
        if (!com.tencent.mm.wallet_core.b.b(b.a.clicfg_kinda_hk_wallet_succ_page_android, false)) {
            Log.i(TAG, "startPayIBGJsGetSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is false");
            AppMethodBeat.o(214423);
            return false;
        }
        h.INSTANCE.idkeyStat(1004, 21, 1, false);
        Log.i(TAG, "startPayIBGJsGetSuccPageUseCase, isKindaOverseaWalletSuccPageEnable is true");
        initIfNeed();
        preparePayDesk();
        ITransmitKvData create = ITransmitKvData.create();
        create.putString("appid", bundle.getString("appid"));
        create.putString(AppMeasurement.Param.TIMESTAMP, bundle.getString(AppMeasurement.Param.TIMESTAMP));
        create.putString("nonce_str", bundle.getString("nonce_str"));
        create.putString("package", bundle.getString("package"));
        create.putString("sign_type", bundle.getString("sign_type"));
        create.putString("pay_sign", bundle.getString("pay_sign"));
        create.putString("webview_url", bundle.getString("webview_url"));
        KindaApp.appKinda().startUseCase("payIbgGetSuccPage", create, new UseCaseCallback() {
            /* class com.tencent.kinda.framework.WxCrossServices.AnonymousClass23 */

            @Override // com.tencent.kinda.gen.UseCaseCallback
            public void call(ITransmitKvData iTransmitKvData) {
                AppMethodBeat.i(214409);
                if (context instanceof WalletIbgOrderInfoUI) {
                    String string = iTransmitKvData.getString("result");
                    String string2 = iTransmitKvData.getString("subscribe_username");
                    WalletIbgOrderInfoUI walletIbgOrderInfoUI = (WalletIbgOrderInfoUI) context;
                    Log.i("MicroMsg.WalletIbgOrderInfoUI", "onKindaPayIBGGetSuccPageBack, result: %s", string);
                    if (string.equalsIgnoreCase("fail")) {
                        walletIbgOrderInfoUI.setResult(0);
                    } else if (string.equalsIgnoreCase("ok")) {
                        if (!Util.isNullOrNil(string2)) {
                            Log.i("MicroMsg.WalletIbgOrderInfoUI", "hy: doing netscene subscribe...subscribe_username: %s", string2);
                            g.aAi();
                            g.aAg().hqi.a(new com.tencent.mm.wallet_core.c.t(string2), 0);
                        }
                        walletIbgOrderInfoUI.setResult(-1);
                    }
                    walletIbgOrderInfoUI.finish();
                }
                AppMethodBeat.o(214409);
            }
        });
        AppMethodBeat.o(214423);
        return true;
    }
}
