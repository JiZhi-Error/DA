package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

class BaseWXApiImplV10 implements IWXAPI {
    protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname;
    private byte _hellAccFlag_;
    protected String appId;
    protected boolean checkSignature = false;
    protected Context context;
    protected boolean detached = false;
    private int wxSdkVersion;

    BaseWXApiImplV10(Context context2, String str, boolean z) {
        AppMethodBeat.i(3790);
        Log.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z);
        this.context = context2;
        this.appId = str;
        this.checkSignature = z;
        b.f1496a = context2.getApplicationContext();
        AppMethodBeat.o(3790);
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(3825);
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            Log.e(TAG, "checkSumConsistent fail, invalid arguments");
            AppMethodBeat.o(3825);
            return false;
        } else if (bArr.length != bArr2.length) {
            Log.e(TAG, "checkSumConsistent fail, length is different");
            AppMethodBeat.o(3825);
            return false;
        } else {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    AppMethodBeat.o(3825);
                    return false;
                }
            }
            AppMethodBeat.o(3825);
            return true;
        }
    }

    private boolean createChatroom(Context context2, Bundle bundle) {
        AppMethodBeat.i(3810);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3810);
        return true;
    }

    private String getTokenFromWX(Context context2) {
        AppMethodBeat.i(3800);
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.appId, "637928960"}, null);
        if (query == null || !query.moveToFirst()) {
            AppMethodBeat.o(3800);
            return null;
        }
        String string = query.getString(0);
        Log.i(TAG, "getTokenFromWX token is ".concat(String.valueOf(string)));
        query.close();
        AppMethodBeat.o(3800);
        return string;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        AppMethodBeat.i(3795);
        Log.i(TAG, "handleWxInternalRespType, extInfo = ".concat(String.valueOf(str)));
        try {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i(TAG, "handleWxInternalRespType, respType = ".concat(String.valueOf(queryParameter)));
            if (b.b(queryParameter)) {
                Log.e(TAG, "handleWxInternalRespType fail, respType is null");
                AppMethodBeat.o(3795);
                return false;
            } else if (queryParameter.equals("subscribemessage")) {
                SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
                String queryParameter2 = parse.getQueryParameter("ret");
                if (queryParameter2 != null && queryParameter2.length() > 0) {
                    resp.errCode = b.a(queryParameter2, 0);
                }
                resp.openId = parse.getQueryParameter(Scopes.OPEN_ID);
                resp.templateID = parse.getQueryParameter("template_id");
                resp.scene = b.a(parse.getQueryParameter("scene"), 0);
                resp.action = parse.getQueryParameter(NativeProtocol.WEB_DIALOG_ACTION);
                resp.reserved = parse.getQueryParameter("reserved");
                iWXAPIEventHandler.onResp(resp);
                AppMethodBeat.o(3795);
                return true;
            } else if (queryParameter.contains("invoice_auth_insert")) {
                WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
                String queryParameter3 = parse.getQueryParameter("ret");
                if (queryParameter3 != null && queryParameter3.length() > 0) {
                    resp2.errCode = b.a(queryParameter3, 0);
                }
                resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp2);
                AppMethodBeat.o(3795);
                return true;
            } else if (queryParameter.contains("payinsurance")) {
                WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
                String queryParameter4 = parse.getQueryParameter("ret");
                if (queryParameter4 != null && queryParameter4.length() > 0) {
                    resp3.errCode = b.a(queryParameter4, 0);
                }
                resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp3);
                AppMethodBeat.o(3795);
                return true;
            } else if (queryParameter.contains("nontaxpay")) {
                WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
                String queryParameter5 = parse.getQueryParameter("ret");
                if (queryParameter5 != null && queryParameter5.length() > 0) {
                    resp4.errCode = b.a(queryParameter5, 0);
                }
                resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
                iWXAPIEventHandler.onResp(resp4);
                AppMethodBeat.o(3795);
                return true;
            } else if ("subscribeminiprogrammsg".equals(queryParameter) || "5".equals(queryParameter)) {
                SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
                String queryParameter6 = parse.getQueryParameter("ret");
                if (queryParameter6 != null && queryParameter6.length() > 0) {
                    resp5.errCode = b.a(queryParameter6, 0);
                }
                resp5.openId = parse.getQueryParameter(Scopes.OPEN_ID);
                resp5.unionId = parse.getQueryParameter("unionid");
                resp5.nickname = parse.getQueryParameter("nickname");
                resp5.errStr = parse.getQueryParameter("errmsg");
                iWXAPIEventHandler.onResp(resp5);
                AppMethodBeat.o(3795);
                return true;
            } else {
                Log.e(TAG, "this open sdk version not support the request type");
                AppMethodBeat.o(3795);
                return false;
            }
        } catch (Exception e2) {
            Log.e(TAG, "handleWxInternalRespType fail, ex = " + e2.getMessage());
        }
    }

    private boolean joinChatroom(Context context2, Bundle bundle) {
        AppMethodBeat.i(3811);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3811);
        return true;
    }

    private void launchWXIfNeed() {
        AppMethodBeat.i(3802);
        if (Build.VERSION.SDK_INT >= 29) {
            launchWXUsingPendingIntent();
        }
        AppMethodBeat.o(3802);
    }

    private void launchWXUsingPendingIntent() {
        AppMethodBeat.i(190369);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
            AppMethodBeat.o(190369);
            throw illegalStateException;
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "openWXApp failed, not installed or signature check failed");
            AppMethodBeat.o(190369);
        } else {
            try {
                Log.i(TAG, "launchWXUsingPendingIntent");
                PendingIntent.getActivity(this.context, 1, this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"), 134217728).send(this.context, 2, null, new PendingIntent.OnFinished() {
                    /* class com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.AnonymousClass2 */

                    {
                        AppMethodBeat.i(190352);
                        AppMethodBeat.o(190352);
                    }

                    public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
                        AppMethodBeat.i(190353);
                        Log.d(BaseWXApiImplV10.TAG, "onSendFinished resultCode: " + i2 + ", resultData: " + str);
                        AppMethodBeat.o(190353);
                    }
                }, null);
                AppMethodBeat.o(190369);
            } catch (Exception e2) {
                Log.e(TAG, "launchWXUsingPendingIntent pendingIntent send failed: " + e2.getMessage());
                openWXApp();
                AppMethodBeat.o(190369);
            }
        }
    }

    private boolean sendAddCardToWX(Context context2, Bundle bundle) {
        AppMethodBeat.i(3803);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3803);
        return true;
    }

    private boolean sendChooseCardFromWX(Context context2, Bundle bundle) {
        AppMethodBeat.i(3804);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3804);
        return true;
    }

    private boolean sendFinderOpenFeed(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(258791);
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenFeed");
        WXChannelOpenFeed.Req req = (WXChannelOpenFeed.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenFeed"), null, null, new String[]{this.appId, req.feedID, req.nonceID, String.valueOf(req.notGetReleatedList)}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(258791);
        return true;
    }

    private boolean sendFinderOpenLive(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(258790);
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenLive");
        WXChannelOpenLive.Req req = (WXChannelOpenLive.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenLive"), null, null, new String[]{this.appId, req.feedID, req.nonceID}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(258790);
        return true;
    }

    private boolean sendFinderOpenProfile(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(258789);
        launchWXIfNeed();
        Log.i(TAG, "sendFinderOpenProfile");
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenProfile"), null, null, new String[]{this.appId, ((WXChannelOpenProfile.Req) baseReq).userName}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(258789);
        return true;
    }

    private boolean sendFinderShareVideo(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(258788);
        launchWXIfNeed();
        Log.i(TAG, "sendFinderShareVideo");
        WXChannelShareVideo.Req req = (WXChannelShareVideo.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderShareVideo"), null, null, new String[]{this.appId, req.videoPath, req.title, req.url, req.extData}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(258788);
        return true;
    }

    private boolean sendHandleScanResult(Context context2, Bundle bundle) {
        AppMethodBeat.i(3812);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3812);
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3815);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3815);
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context2, Bundle bundle) {
        AppMethodBeat.i(3808);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[]{this.appId}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3808);
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3820);
        launchWXIfNeed();
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{this.appId, req.userName, req.path, new StringBuilder().append(req.miniprogramType).toString(), req.extData}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3820);
        return true;
    }

    private boolean sendLaunchWXMiniprogramWithToken(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3819);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[]{this.appId, ((WXLaunchMiniProgramWithToken.Req) baseReq).token}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3819);
        return true;
    }

    private boolean sendNonTaxPay(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3816);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3816);
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context2, Bundle bundle) {
        AppMethodBeat.i(3809);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3809);
        return true;
    }

    private boolean sendOpenBusinessView(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3821);
        launchWXIfNeed();
        WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction, req.openId}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3821);
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3807);
        launchWXIfNeed();
        WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        String str = "";
        HashMap<String, String> hashMap = req.queryInfo;
        if (hashMap != null && hashMap.size() > 0) {
            str = new JSONObject(req.queryInfo).toString();
        }
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, new StringBuilder().append(req.businessType).toString(), str}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3807);
        return true;
    }

    private boolean sendOpenRankListReq(Context context2, Bundle bundle) {
        AppMethodBeat.i(3805);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3805);
        return true;
    }

    private boolean sendOpenWebview(Context context2, Bundle bundle) {
        AppMethodBeat.i(3806);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3806);
        return true;
    }

    private boolean sendPayInSurance(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3817);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3817);
        return true;
    }

    private boolean sendPayReq(Context context2, Bundle bundle) {
        AppMethodBeat.i(3801);
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context2).getString("_wxapp_pay_entry_classname_", null);
            Log.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context2.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e2) {
                    Log.e(TAG, "get from metaData failed : " + e2.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                AppMethodBeat.o(3801);
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        boolean send = MMessageActV2.send(context2, args);
        AppMethodBeat.o(3801);
        return send;
    }

    private boolean sendPreloadWXMiniProgramEnvironment(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(190370);
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogramEnvironment"), null, null, new String[]{this.appId, ((WXPreloadMiniProgramEnvironment.Req) baseReq).extData}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(190370);
        return true;
    }

    private boolean sendPreloadWXMiniprogram(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3818);
        WXPreloadMiniProgram.Req req = (WXPreloadMiniProgram.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram"), null, null, new String[]{this.appId, req.userName, req.path, new StringBuilder().append(req.miniprogramType).toString(), req.extData}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3818);
        return true;
    }

    private boolean sendSubscribeMessage(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3813);
        launchWXIfNeed();
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3813);
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(3814);
        launchWXIfNeed();
        Cursor query = context2.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "5", ((SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, null);
        if (query != null) {
            query.close();
        }
        AppMethodBeat.o(3814);
        return true;
    }

    private boolean sendToWxaRedirectingPage(Context context2, BaseReq baseReq) {
        AppMethodBeat.i(190371);
        launchWXIfNeed();
        WXLaunchWxaRedirectingPage.Req req = (WXLaunchWxaRedirectingPage.Req) baseReq;
        ContentResolver contentResolver = context2.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWxaOpenApiRedirectingPage");
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, this.appId);
            arrayList.addAll(Arrays.asList(req.toArray()));
            Cursor query = contentResolver.query(parse, null, null, (String[]) arrayList.toArray(new String[0]), null);
            if (query != null) {
                query.close();
            }
            return true;
        } finally {
            AppMethodBeat.o(190371);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void detach() {
        AppMethodBeat.i(3823);
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
        AppMethodBeat.o(3823);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public int getWXAppSupportAPI() {
        AppMethodBeat.i(3797);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3797);
            throw illegalStateException;
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            AppMethodBeat.o(3797);
            return 0;
        } else {
            this.wxSdkVersion = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            b.f1500e.submit(new Runnable() {
                /* class com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.AnonymousClass1 */

                {
                    AppMethodBeat.i(190387);
                    AppMethodBeat.o(190387);
                }

                public void run() {
                    AppMethodBeat.i(3764);
                    try {
                        MMSharedPreferences mMSharedPreferences = new MMSharedPreferences(BaseWXApiImplV10.this.context);
                        BaseWXApiImplV10.this.wxSdkVersion = mMSharedPreferences.getInt("_build_info_sdk_int_", 0);
                    } catch (Exception e2) {
                        Log.w(BaseWXApiImplV10.TAG, e2.getMessage());
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.o(3764);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w(TAG, e2.getMessage());
            }
            Log.d(TAG, "wxSdkVersion = " + this.wxSdkVersion);
            if (this.wxSdkVersion == 0) {
                try {
                    this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                    Log.d(TAG, "OPEN_SDK_VERSION = " + this.wxSdkVersion);
                } catch (Exception e3) {
                    Log.e(TAG, "get from metaData failed : " + e3.getMessage());
                }
            }
            int i2 = this.wxSdkVersion;
            AppMethodBeat.o(3797);
            return i2;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        AppMethodBeat.i(3794);
        try {
            if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
                Log.i(TAG, "handleIntent fail, intent not from weixin msg");
                AppMethodBeat.o(3794);
                return false;
            } else if (!this.detached) {
                String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
                int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
                String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
                if (stringExtra2 == null || stringExtra2.length() == 0) {
                    Log.e(TAG, "invalid argument");
                    AppMethodBeat.o(3794);
                    return false;
                } else if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), a.a(stringExtra, intExtra, stringExtra2))) {
                    Log.e(TAG, "checksum fail");
                    AppMethodBeat.o(3794);
                    return false;
                } else {
                    int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                    Log.i(TAG, "handleIntent, cmd = ".concat(String.valueOf(intExtra2)));
                    switch (intExtra2) {
                        case 1:
                            iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 2:
                            iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 3:
                            iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 4:
                            ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                            String str = req.message.messageExt;
                            if (str == null || !str.contains("wx_internal_resptype")) {
                                if (str != null && str.contains("openbusinesswebview")) {
                                    try {
                                        Uri parse = Uri.parse(str);
                                        if (parse == null || !"openbusinesswebview".equals(parse.getHost())) {
                                            Log.d(TAG, "not openbusinesswebview %".concat(String.valueOf(str)));
                                        } else {
                                            WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                            String queryParameter = parse.getQueryParameter("ret");
                                            if (queryParameter != null && queryParameter.length() > 0) {
                                                resp.errCode = b.a(queryParameter, 0);
                                            }
                                            resp.resultInfo = parse.getQueryParameter("resultInfo");
                                            resp.errStr = parse.getQueryParameter("errmsg");
                                            String queryParameter2 = parse.getQueryParameter("type");
                                            if (queryParameter2 != null && queryParameter2.length() > 0) {
                                                resp.businessType = b.a(queryParameter2, 0);
                                            }
                                            iWXAPIEventHandler.onResp(resp);
                                            AppMethodBeat.o(3794);
                                            return true;
                                        }
                                    } catch (Exception e2) {
                                        Log.e(TAG, "parse fail, ex = " + e2.getMessage());
                                    }
                                }
                                iWXAPIEventHandler.onReq(req);
                                AppMethodBeat.o(3794);
                                return true;
                            }
                            boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                            Log.i(TAG, "handleIntent, extInfo contains wx_internal_resptype, ret = ".concat(String.valueOf(handleWxInternalRespType)));
                            AppMethodBeat.o(3794);
                            return handleWxInternalRespType;
                        case 5:
                            iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 6:
                            iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 7:
                        case 8:
                        case 10:
                        case 11:
                        case 13:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        default:
                            Log.e(TAG, "unknown cmd = " + intExtra2);
                            break;
                        case 9:
                            iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 12:
                            iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 14:
                            iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 15:
                            iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 16:
                            iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 17:
                            iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 19:
                            iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 24:
                            iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 25:
                            iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 26:
                            iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 27:
                            iWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 28:
                            iWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 29:
                            iWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 30:
                            iWXAPIEventHandler.onResp(new WXLaunchWxaRedirectingPage.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 31:
                            iWXAPIEventHandler.onResp(new SendTdiAuth.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 32:
                            iWXAPIEventHandler.onResp(new WXPreloadMiniProgramEnvironment.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 33:
                            iWXAPIEventHandler.onResp(new WXChannelShareVideo.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 34:
                            iWXAPIEventHandler.onResp(new WXChannelOpenProfile.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 35:
                            iWXAPIEventHandler.onResp(new WXChannelOpenLive.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                        case 36:
                            iWXAPIEventHandler.onResp(new WXChannelOpenFeed.Resp(intent.getExtras()));
                            AppMethodBeat.o(3794);
                            return true;
                    }
                    AppMethodBeat.o(3794);
                    return false;
                }
            } else {
                IllegalStateException illegalStateException = new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
                AppMethodBeat.o(3794);
                throw illegalStateException;
            }
        } catch (Exception e3) {
            Log.e(TAG, "handleIntent fail, ex = " + e3.getMessage());
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean isWXAppInstalled() {
        AppMethodBeat.i(3796);
        if (!this.detached) {
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    AppMethodBeat.o(3796);
                    return false;
                }
                boolean validateAppSignature = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
                AppMethodBeat.o(3796);
                return validateAppSignature;
            } catch (Exception e2) {
                AppMethodBeat.o(3796);
                return false;
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3796);
            throw illegalStateException;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean openWXApp() {
        AppMethodBeat.i(3798);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3798);
            throw illegalStateException;
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            AppMethodBeat.o(3798);
            return false;
        } else {
            try {
                Context context2 = this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/opensdk/openapi/BaseWXApiImplV10", "openWXApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/opensdk/openapi/BaseWXApiImplV10", "openWXApp", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(3798);
                return true;
            } catch (Exception e2) {
                Log.e(TAG, "startActivity fail, exception = " + e2.getMessage());
                AppMethodBeat.o(3798);
                return false;
            }
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str) {
        AppMethodBeat.i(3791);
        boolean registerApp = registerApp(str, 0);
        AppMethodBeat.o(3791);
        return registerApp;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str, long j2) {
        AppMethodBeat.i(3792);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3792);
            throw illegalStateException;
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "register app failed for wechat app signature check failed");
            AppMethodBeat.o(3792);
            return false;
        } else {
            Log.d(TAG, "registerApp, appId = ".concat(String.valueOf(str)));
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "registerApp, appId = ".concat(String.valueOf(str)));
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "register app " + this.context.getPackageName());
            a.C0500a aVar = new a.C0500a();
            aVar.f1457a = "com.tencent.mm";
            aVar.f1458b = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            aVar.f1459c = "weixin://registerapp?appid=" + this.appId;
            aVar.f1460d = j2;
            boolean a2 = a.a(this.context, aVar);
            AppMethodBeat.o(3792);
            return a2;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendReq(BaseReq baseReq) {
        AppMethodBeat.i(3799);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3799);
            throw illegalStateException;
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "sendReq failed for wechat app signature check failed");
            AppMethodBeat.o(3799);
            return false;
        } else if (!baseReq.checkArgs()) {
            Log.e(TAG, "sendReq checkArgs fail");
            AppMethodBeat.o(3799);
            return false;
        } else {
            Log.i(TAG, "sendReq, req type = " + baseReq.getType());
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 5 || baseReq.getType() == 27) {
                boolean sendPayReq = sendPayReq(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendPayReq;
            } else if (baseReq.getType() == 9) {
                boolean sendAddCardToWX = sendAddCardToWX(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendAddCardToWX;
            } else if (baseReq.getType() == 16) {
                boolean sendChooseCardFromWX = sendChooseCardFromWX(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendChooseCardFromWX;
            } else if (baseReq.getType() == 11) {
                boolean sendOpenRankListReq = sendOpenRankListReq(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendOpenRankListReq;
            } else if (baseReq.getType() == 12) {
                boolean sendOpenWebview = sendOpenWebview(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendOpenWebview;
            } else if (baseReq.getType() == 25) {
                boolean sendOpenBusinessWebview = sendOpenBusinessWebview(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendOpenBusinessWebview;
            } else if (baseReq.getType() == 13) {
                boolean sendOpenBusiLuckyMoney = sendOpenBusiLuckyMoney(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendOpenBusiLuckyMoney;
            } else if (baseReq.getType() == 14) {
                boolean createChatroom = createChatroom(this.context, bundle);
                AppMethodBeat.o(3799);
                return createChatroom;
            } else if (baseReq.getType() == 15) {
                boolean joinChatroom = joinChatroom(this.context, bundle);
                AppMethodBeat.o(3799);
                return joinChatroom;
            } else if (baseReq.getType() == 17) {
                boolean sendHandleScanResult = sendHandleScanResult(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendHandleScanResult;
            } else if (baseReq.getType() == 18) {
                boolean sendSubscribeMessage = sendSubscribeMessage(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendSubscribeMessage;
            } else if (baseReq.getType() == 28) {
                boolean sendPreloadWXMiniprogram = sendPreloadWXMiniprogram(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendPreloadWXMiniprogram;
            } else if (baseReq.getType() == 29) {
                boolean sendLaunchWXMiniprogramWithToken = sendLaunchWXMiniprogramWithToken(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendLaunchWXMiniprogramWithToken;
            } else if (baseReq.getType() == 23) {
                boolean sendSubscribeMiniProgramMsg = sendSubscribeMiniProgramMsg(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendSubscribeMiniProgramMsg;
            } else if (baseReq.getType() == 19) {
                boolean sendLaunchWXMiniprogram = sendLaunchWXMiniprogram(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendLaunchWXMiniprogram;
            } else if (baseReq.getType() == 32) {
                boolean sendPreloadWXMiniProgramEnvironment = sendPreloadWXMiniProgramEnvironment(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendPreloadWXMiniProgramEnvironment;
            } else if (baseReq.getType() == 30) {
                boolean sendToWxaRedirectingPage = sendToWxaRedirectingPage(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendToWxaRedirectingPage;
            } else if (baseReq.getType() == 26) {
                boolean sendOpenBusinessView = sendOpenBusinessView(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendOpenBusinessView;
            } else if (baseReq.getType() == 33) {
                boolean sendFinderShareVideo = sendFinderShareVideo(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendFinderShareVideo;
            } else if (baseReq.getType() == 34) {
                boolean sendFinderOpenProfile = sendFinderOpenProfile(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendFinderOpenProfile;
            } else if (baseReq.getType() == 35) {
                boolean sendFinderOpenLive = sendFinderOpenLive(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendFinderOpenLive;
            } else if (baseReq.getType() == 36) {
                boolean sendFinderOpenFeed = sendFinderOpenFeed(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendFinderOpenFeed;
            } else if (baseReq.getType() == 20) {
                boolean sendInvoiceAuthInsert = sendInvoiceAuthInsert(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendInvoiceAuthInsert;
            } else if (baseReq.getType() == 21) {
                boolean sendNonTaxPay = sendNonTaxPay(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendNonTaxPay;
            } else if (baseReq.getType() == 22) {
                boolean sendPayInSurance = sendPayInSurance(this.context, baseReq);
                AppMethodBeat.o(3799);
                return sendPayInSurance;
            } else if (baseReq.getType() == 24) {
                boolean sendJumpToOfflinePayReq = sendJumpToOfflinePayReq(this.context, bundle);
                AppMethodBeat.o(3799);
                return sendJumpToOfflinePayReq;
            } else {
                if (baseReq.getType() == 2) {
                    SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                    int type = req.message.getType();
                    if (b.a(type)) {
                        if (getWXAppSupportAPI() < 620756993) {
                            WXWebpageObject wXWebpageObject = new WXWebpageObject();
                            wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                            req.message.mediaObject = wXWebpageObject;
                        } else if (type != 46 || getWXAppSupportAPI() >= 620953856) {
                            WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                            wXMiniProgramObject.userName += "@app";
                            String str = wXMiniProgramObject.path;
                            if (!b.b(str)) {
                                String[] split = str.split("\\?");
                                wXMiniProgramObject.path = split.length > 1 ? split[0] + ".html?" + split[1] : split[0] + ".html";
                            }
                        } else {
                            WXWebpageObject wXWebpageObject2 = new WXWebpageObject();
                            wXWebpageObject2.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                            req.message.mediaObject = wXWebpageObject2;
                        }
                        int i2 = req.scene;
                        if (!(i2 == 3 || i2 == 1)) {
                            req.scene = 0;
                        }
                        baseReq.toBundle(bundle);
                    }
                }
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendreq?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                if (baseReq.getType() == 2) {
                    try {
                        args.token = getTokenFromWX(this.context);
                    } catch (Exception e2) {
                        Log.e(TAG, "getTokenFromWX fail, exception = " + e2.getMessage());
                    }
                }
                boolean send = MMessageActV2.send(this.context, args);
                AppMethodBeat.o(3799);
                return send;
            }
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendResp(BaseResp baseResp) {
        AppMethodBeat.i(3822);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3822);
            throw illegalStateException;
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "sendResp failed for wechat app signature check failed");
            AppMethodBeat.o(3822);
            return false;
        } else if (!baseResp.checkArgs()) {
            Log.e(TAG, "sendResp checkArgs fail");
            AppMethodBeat.o(3822);
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseResp.toBundle(bundle);
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.bundle = bundle;
            args.content = "weixin://sendresp?appid=" + this.appId;
            args.targetPkgName = "com.tencent.mm";
            args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            boolean send = MMessageActV2.send(this.context, args);
            AppMethodBeat.o(3822);
            return send;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void setLogImpl(ILog iLog) {
        AppMethodBeat.i(3824);
        Log.setLogImpl(iLog);
        AppMethodBeat.o(3824);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void unregisterApp() {
        AppMethodBeat.i(3793);
        if (this.detached) {
            IllegalStateException illegalStateException = new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
            AppMethodBeat.o(3793);
            throw illegalStateException;
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "unregister app failed for wechat app signature check failed");
            AppMethodBeat.o(3793);
        } else {
            Log.d(TAG, "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                Log.e(TAG, "unregisterApp fail, appId is empty");
                AppMethodBeat.o(3793);
                return;
            }
            Log.d(TAG, "unregister app " + this.context.getPackageName());
            a.C0500a aVar = new a.C0500a();
            aVar.f1457a = "com.tencent.mm";
            aVar.f1458b = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            aVar.f1459c = "weixin://unregisterapp?appid=" + this.appId;
            a.a(this.context, aVar);
            AppMethodBeat.o(3793);
        }
    }
}
