package com.tencent.mm.protocal;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.a;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static Map<String, g> KyB = null;
    public static final String[] KyC = ((String[]) new LinkedList<String>() {
        /* class com.tencent.mm.protocal.c.AnonymousClass1 */

        {
            AppMethodBeat.i(152433);
            add("confirmDialog");
            add("openWebViewUseFastLoad");
            add("invokeMiniProgramAPI");
            add("handleMPPageAction");
            add("handleVideoAction");
            add("startSearchItemDetailPage");
            add("configMpAdAttrs");
            add(com.tencent.mm.plugin.appbrand.jsapi.cq.NAME);
            add(com.tencent.mm.plugin.appbrand.jsapi.av.NAME);
            AppMethodBeat.o(152433);
        }
    }.toArray(new String[0]));

    public static final class np {
        public static Set<String> KyG;
    }

    public static Bundle bga(String str) {
        AppMethodBeat.i(152434);
        Bundle bundle = new Bundle();
        bundle.putBoolean("handle", true);
        bundle.putString("handle_result", str);
        AppMethodBeat.o(152434);
        return bundle;
    }

    static {
        AppMethodBeat.i(152436);
        AppMethodBeat.o(152436);
    }

    public static g bgb(String str) {
        AppMethodBeat.i(152435);
        if (KyB == null || KyB.size() <= 0) {
            HashMap hashMap = new HashMap(128);
            KyB = hashMap;
            hashMap.put("log", new fc());
            KyB.put("imagePreview", new ek());
            KyB.put(Scopes.PROFILE, new ia());
            KyB.put("shareWeibo", new mt());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME, new lr());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.al.NAME, new o());
            KyB.put("streamingVideoPlay", new lo());
            KyB.put("addContact", new h());
            KyB.put("getWidgetCaptureImgUrl", new du());
            KyB.put("sendAppMessage", new jk());
            KyB.put("scanQRCode", new jc());
            KyB.put("hideOptionMenu", new eh());
            KyB.put("showOptionMenu", new ku());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.z.f.NAME, new cv());
            KyB.put("closeWindow", new aq());
            KyB.put(JsApiGetInstallState.NAME, new cq());
            KyB.put("setFontSizeCallback", new jy());
            KyB.put("jumpToInstallUrl", new er());
            KyB.put("launchApp", new ex());
            KyB.put("getBrandWCPayRequest", new cd());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.o.h.NAME, new je());
            KyB.put("wcpaySecurityCrosscutBack", new mj());
            KyB.put("editAddress", new bl());
            KyB.put("getHeadingAndPitch", new cn());
            KyB.put("sendEmail", new jp());
            KyB.put(JsApiAddDownloadTask.NAME, new k());
            KyB.put(JsApiCancelDownloadTask.NAME, new x());
            KyB.put(JsApiPauseDownloadTask.NAME, new hp());
            KyB.put(JsApiResumeDownloadTask.NAME, new ja());
            KyB.put(JsApiQueryDownloadTask.NAME, new id());
            KyB.put(JsApiInstallDownloadTask.NAME, new en());
            KyB.put("getLatestAddress", new da());
            KyB.put("openSpecificView", new gz());
            KyB.put("jumpWCMall", new et());
            KyB.put("launch3rdApp", new ew());
            KyB.put(JsApiWriteCommData.NAME, new na());
            KyB.put("openUrlByExtBrowser", new ha());
            KyB.put("geoLocation", new by());
            KyB.put("getBrandWCPayBindCardRequest", new cc());
            KyB.put("openProductView", new gs());
            KyB.put("openProductViewWithPid", new gt());
            KyB.put("jumpToBizProfile", new es());
            KyB.put("openTimelineCheckInList", new fj());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.i.p.NAME, new fi());
            KyB.put("timelineCheckIn", new fh());
            KyB.put("getBrandWCPayCreateCreditCardRequest", new hg());
            KyB.put("chooseCard", new ad());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.ay.NAME, new ah());
            KyB.put("sendServiceAppMessage", new jq());
            KyB.put("musicPlay", new ff());
            KyB.put("mmsf0001", new ci());
            KyB.put("connectToWiFi", new av());
            KyB.put("getTransferMoneyRequest", new dq());
            KyB.put("openWCPaySpecificView", new hc());
            KyB.put("setCloseWindowConfirmDialogInfo", new jw());
            KyB.put("batchAddCard", new s());
            KyB.put("preVerifyJSAPI", new hx());
            KyB.put(JsApiStartRecordVoice.NAME, new le());
            KyB.put(JsApiStopRecordVoice.NAME, new ll());
            KyB.put(JsApiStartPlayVoice.NAME, new hs());
            KyB.put(JsApiPausePlayVoice.NAME, new hq());
            KyB.put(JsApiStopPlayVoice.NAME, new ln());
            KyB.put("uploadVoice", new mf());
            KyB.put("downloadVoice", new bh());
            KyB.put(JsApiChooseImage.NAME, new ag());
            KyB.put("uploadImage", new mc());
            KyB.put("downloadImage", new bg());
            KyB.put("uploadMediaFile", new md());
            KyB.put("hideMenuItems", new ee());
            KyB.put("showMenuItems", new kr());
            KyB.put("hideAllNonBaseMenuItem", new ed());
            KyB.put("showAllNonBaseMenuItem", new ko());
            KyB.put("checkJsApi", new ac());
            KyB.put("translateVoice", new ls());
            KyB.put("shareQQ", new kl());
            KyB.put("shareWeiboApp", new kn());
            KyB.put("shareQZone", new km());
            KyB.put("getSendC2CMessageRequest", new dn());
            KyB.put("batchViewCard", new v());
            KyB.put("configWXDeviceWiFi", new at());
            KyB.put("getCurrentSSID", new cg());
            KyB.put("setPageOwner", new kd());
            KyB.put("getWechatVerifyTicket", new ds());
            KyB.put("openWXDeviceLib", new hh());
            KyB.put("startScanWXDevice", new lf());
            KyB.put("stopScanWXDevice", new lm());
            KyB.put("connectWXDevice", new aw());
            KyB.put("disconnectWXDevice", new bf());
            KyB.put("getWXDeviceTicket", new dw());
            KyB.put("getWXDeviceInfos", new dv());
            KyB.put("sendDataToWXDevice", new jm());
            KyB.put("closeWXDeviceLib", new as());
            KyB.put("setSendDataDirection", new kh());
            KyB.put("verifyWCPayPassword", new mh());
            KyB.put("getPaymentOrderRequest", new cz());
            KyB.put("openGameDetail", new gi());
            KyB.put("openGameCenter", new gh());
            KyB.put("setGameDebugConfig", new jz());
            KyB.put("startTempSession", new lh());
            KyB.put("getH5PrepayRequest", new co());
            KyB.put("getH5TransactionRequest", new cp());
            KyB.put("menu:share:timeline", new nl());
            KyB.put("menu:share:appmessage", new ni());
            KyB.put("menu:share:qq", new nj());
            KyB.put("menu:share:weiboApp", new nm());
            KyB.put("menu:setfont", new nh());
            KyB.put("menu:share:weibo", new nm());
            KyB.put("menu:share:QZone", new nk());
            KyB.put("getRecevieBizHongBaoRequest", new e());
            KyB.put("insertVideoPlayer", new em());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.video.d.e.NAME, new lz());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.video.d.d.NAME, new il());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.video.d.c.NAME, new hl());
            KyB.put("deleteSearchHistory", new bc());
            KyB.put("getSearchHistory", new dj());
            KyB.put("getSearchData", new df());
            KyB.put("showWeDrawHomeView", new nr());
            KyB.put("getFestivalLiveInfo", new nq());
            KyB.put("getChatSearchData", new ce());
            KyB.put("getPoiInfo", new cm());
            KyB.put("updateReddotTimeStamps", new lv());
            KyB.put("getTeachSearchData", new dp());
            KyB.put("getSearchGuideData", new di());
            KyB.put("getSearchAvatarList", new de());
            KyB.put("getSearchSnsImageList", new dl());
            KyB.put("getSearchImageList", new dk());
            KyB.put("getSearchDisplayNameList", new dg());
            KyB.put("startSearchItemDetailPage", new lg());
            KyB.put("reportSearchStatistics", new is());
            KyB.put("reportSearchRealTimeStatistics", new ir());
            KyB.put("searchDataHasResult", new jd());
            KyB.put("openEmotionPage", new bu());
            KyB.put("getSearchSuggestionData", new dm());
            KyB.put("setSearchInputWord", new kg());
            KyB.put("setSnsObjectXmlDescList", new ki());
            KyB.put("clickSnsMusicPlayButton", new ap());
            KyB.put("openWeAppPage", new hf());
            KyB.put("reportWeAppSearchRealtime", new mu());
            KyB.put("doSearchOperation", new bk());
            KyB.put("insertSearchWAWidgetView", new el());
            KyB.put("removeSearchWAWidgetView", new ik());
            KyB.put("updateSearchWAWidgetView", new lx());
            KyB.put("showSearchActionSheet", new kv());
            KyB.put("cancelSearchActionSheet", new z());
            KyB.put("showSearchToast", new ky());
            KyB.put("showSearchLoading", new kw());
            KyB.put("hideSearchLoading", new ei());
            KyB.put("updateWASearchTemplate", new ma());
            KyB.put("preloadSearchWeapp", new hv());
            KyB.put("uxSearchOpLog", new mg());
            KyB.put("querySearchWeb", new bw());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME, new gg());
            KyB.put("openFinderFeed", new gf());
            KyB.put("getCurrentLocation", new cf());
            KyB.put("navControl", new fg());
            KyB.put("showNavBarShadow", new kt());
            KyB.put("hideNavBarShadow", new eg());
            KyB.put("jumpToWXWallet", new eu());
            KyB.put("scanCover", new f());
            KyB.put("reportActionInfo", new im());
            KyB.put("openMyDeviceProfile", new gp());
            KyB.put("selectPedometerSource", new jh());
            KyB.put("nfcIsConnect", new fp());
            KyB.put("nfcConnect", new fm());
            KyB.put("nfcTransceive", new fq());
            KyB.put("nfcBatchTransceive", new fk());
            KyB.put("nfcGetId", new fn());
            KyB.put("nfcGetInfo", new fo());
            KyB.put("startMonitoringBeacons", new lc());
            KyB.put("stopMonitoringBeacons", new lj());
            KyB.put("nfcCheckState", new fl());
            KyB.put("videoProxyInit", new mm());
            KyB.put("videoProxyStartPlay", new mp());
            KyB.put("videoProxyStopPlay", new mq());
            KyB.put("videoProxySetPlayerState", new mn());
            KyB.put("videoProxySetRemainTime", new mo());
            KyB.put("videoProxyPreload", new ms());
            KyB.put("getWebPayCheckoutCounterRequst", new fb());
            KyB.put("addCustomMenuItems", new i());
            KyB.put("operateGameCenterMsg", new hk());
            KyB.put("openEnterpriseChat", new gd());
            KyB.put("enterEnterpriseChat", new bp());
            KyB.put("openEnterpriseContact", new ge());
            KyB.put("selectEnterpriseContact", new jg());
            KyB.put("getEnterpriseChat", new ck());
            KyB.put("reportIDKey", new ip());
            KyB.put("quicklyAddBrandContact", new ig());
            KyB.put("consumedShareCard", new ax());
            KyB.put("cache", new ml());
            KyB.put("publicCache", new mr());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.finder.d.NAME, new ev());
            KyB.put("realtimeReport", new ih());
            KyB.put("openUrlWithExtraWebview", new hb());
            KyB.put("selectSingleContact", new ji());
            KyB.put("sendAppMessageToSpecifiedContact", new jj());
            KyB.put("setLocalData", new ka());
            KyB.put("getLocalData", new cr());
            KyB.put("clearLocalData", new an());
            KyB.put("showKeyboard", new kq());
            KyB.put("showSmileyPanel", new kz());
            KyB.put("disableBounceScroll", new bd());
            KyB.put("clearBounceBackground", new al());
            KyB.put("setNavigationBarButtons", new kb());
            KyB.put("enableFullScreen", new bn());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.p.ai.NAME, new ks());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.p.f.NAME, new ef());
            KyB.put("enablePullDownRefresh", new bo());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.p.ak.NAME, new ld());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.p.al.NAME, new lk());
            KyB.put("disablePullDownRefresh", new be());
            KyB.put("setPageTitle", new ke());
            KyB.put("setStatusBarStyle", new kj());
            KyB.put("deleteAccountSuccess", new bb());
            KyB.put("chooseVideo", new ak());
            KyB.put("uploadVideo", new me());
            KyB.put("openMapNavigateMenu", new go());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.p.z.NAME, new kc());
            KyB.put("getWCPayRealnameVerify", new dr());
            KyB.put("openDesignerEmojiView", new fx());
            KyB.put("openDesignerProfile", new fz());
            KyB.put("openEmoticonTopicList", new gc());
            KyB.put("openDesignerEmojiViewLocal", new fy());
            KyB.put("openDesignerProfileLocal", new ga());
            KyB.put("openEmotionDetailViewLocal", new d());
            KyB.put("openNewPage", new gq());
            KyB.put("getSearchEmotionData", new dh());
            KyB.put("openEmotionUrl", new bm());
            KyB.put("WNNativeCallbackOnClick", new my());
            KyB.put("WNNativeCallbackOnLongClick", new mz());
            KyB.put("WNNativeCallbackOnCaretChange", new mx());
            KyB.put("WNNativeCallbackInitData", new mw());
            KyB.put("WNNativeAsyncCallback", new mv());
            KyB.put("WNNativeCallbackOnBecomeEditing", new ne());
            KyB.put("WNNativeCallbackOnBecomeEdited", new nf());
            KyB.put("changePayActivityView", new aa());
            KyB.put("selectWalletCurrency", new lp());
            KyB.put("scanLicence", new jb());
            KyB.put(JsApiOperateMusicPlayer.NAME, new b());
            KyB.put(JsApiGetMusicPlayerState.NAME, new a());
            KyB.put("clearWebviewCache", new ao());
            KyB.put("requireSoterBiometricAuthentication", new la());
            KyB.put("getSupportSoter", new lb());
            KyB.put("unbindBankCard", new lt());
            KyB.put("setBounceBackground", new jv());
            KyB.put("sendEnterpriseChat", new jn());
            KyB.put("doExposePreparation", new bj());
            KyB.put("getMsgProofItems", new cu());
            KyB.put("openSecurityView", new gx());
            KyB.put("startVoipCall", new li());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.az.NAME, new ai());
            KyB.put("getOpenDeviceId", new cx());
            KyB.put("getRouteUrl", new dd());
            KyB.put("idCardRealnameVerify", new ej());
            KyB.put("uploadIdCardSuccess", new no());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.r.f.NAME, new kp());
            KyB.put("openLuckyMoneyDetailView", new gm());
            KyB.put("resendRemittanceMsg", new iz());
            KyB.put("getGameCommInfo", new cl());
            KyB.put("openGameRegion", new gj());
            KyB.put("chooseIdCard", new af());
            KyB.put("getLocalImgData", new C2037c());
            KyB.put("openWeApp", new he());
            KyB.put("recordVideo", new ii());
            KyB.put("previewVideo", new hw());
            KyB.put("uploadEncryptMediaFile", new mb());
            KyB.put(JsApiChooseMedia.NAME, new aj());
            KyB.put("requestWxFacePictureVerify", new bq());
            KyB.put("openCustomWebview", new fw());
            KyB.put("forceUpdateWxaAttr", new bt());
            KyB.put("openLuckyMoneyHistory", new gn());
            KyB.put("menuitem:gameSendDesktop", new jo());
            KyB.put("getWePkgAuthResult", new dt());
            KyB.put("getLocalWePkgInfo", new cs());
            KyB.put("openGameWebView", new gl());
            KyB.put("reportGameWeb", new io());
            KyB.put("launchApplication", new ey());
            KyB.put("showSearchOfBizHistory", new kx());
            KyB.put("login", new fd());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.auth.k.NAME, new r());
            KyB.put("requestWxFacePictureVerifyUnionVideo", new br());
            KyB.put("checkIsSupportFaceDetect", new ab());
            KyB.put(JsApiOperateBackgroundAudio.NAME, new hj());
            KyB.put(JsApiSetBackgroundAudioState.NAME, new ju());
            KyB.put(JsApiGetBackgroundAudioState.NAME, new ca());
            KyB.put(JsApiAddDownloadTaskStraight.NAME, new l());
            KyB.put("setScreenOrientation", new kf());
            KyB.put("addToEmoticon", new n());
            KyB.put("shareEmoticon", new kk());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.bp.NAME, new fe());
            KyB.put(JsApiOpenAdCanvas.NAME, new fv());
            KyB.put("openSearchCanvas", new gu());
            KyB.put("opVoteAdData", new ho());
            KyB.put("opJumpView", new hn());
            KyB.put("opAdH5Func", new hm());
            KyB.put("requestWxFaceRegisterInternal", new iw());
            KyB.put("requestWxFaceVerifyInternal", new ix());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, new fa());
            KyB.put("reportMiniProgramPageData", new iq());
            KyB.put("selectContact", new jf());
            KyB.put("openSearchWAWidgetLogView", new gv());
            KyB.put("reloadSearchWAWidgetData", new ij());
            KyB.put("gotoEmoticonPad", new dx());
            KyB.put("querySimilarEmotion", new Cif());
            KyB.put("closeWindowAndGoNext", new ar());
            KyB.put("requestWxVoicePrintVerifyInternal", new iy());
            KyB.put("openBizChat", new fu());
            KyB.put("handleWCPayWalletBuffer", new ec());
            KyB.put("tapSearchWAWidgetView", new lq());
            KyB.put("getMatchContactList", new ct());
            KyB.put("openSearchWebView", new gw());
            KyB.put("openWXSearchPage", new hi());
            KyB.put("viewTypeChange", new mi());
            KyB.put("invokeMiniProgramAPI", new ep());
            KyB.put("openGameUrlWithExtraWebView", new gk());
            KyB.put("setGameData", new jx());
            KyB.put("getGameData", new ch());
            KyB.put("clearGameData", new am());
            KyB.put("openECard", new gb());
            KyB.put("reportGamePageTime", new in());
            KyB.put("setWCPayPassword", new jt());
            KyB.put("openWCPayCardList", new ft());
            KyB.put("bindEmail", new w());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.ca.NAME, new gr());
            KyB.put("bindEmail", new w());
            KyB.put("doGoToRecVideoList", new db());
            KyB.put("jumpWSRecVideoList", new ng());
            KyB.put("openWebSearchOutLinkItem", new nn());
            KyB.put("recordHistory", new bx());
            for (g gVar : gtr()) {
                KyB.put(gVar.getName(), gVar);
            }
            KyB.put("getSystemInfo", new Cdo());
            KyB.put("serviceClick", new js());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.autofill.f.NAME, new nd());
            KyB.put("sendSingleAppMessage", new jr());
            KyB.put("wcPrivacyPolicyResult", new mk());
            KyB.put("currentMpInfo", new ay());
            KyB.put("updateAppMessageShareData", new lw());
            KyB.put("updateTimelineShareData", new ly());
            KyB.put("getCCData", new nc());
            KyB.put("calRqt", new nb());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, new bs());
            KyB.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, new it());
            KyB.put("notifyPageInfo", new fr());
            KyB.put("updatePageAuth", new lu());
            KyB.put("jumpDownloaderWidget", new eq());
            KyB.put("batchUpdateWepkg", new u());
            KyB.put("addGameDownloadTask", new m());
            KyB.put("internelWxFaceVerify", new eo());
            KyB.put("getDownloadWidgetTaskInfos", new cj());
            KyB.put("chooseHaowanMedia", new ae());
            KyB.put("queryHaowanPublish", new ie());
            KyB.put("publishHaowanEdition", new ib());
            KyB.put("cancelHaowanPublish", new y());
            KyB.put("launchGameVideoEditor", new ez());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.pay.l.NAME, new iv());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.pay.e.NAME, new gy());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.pay.h.NAME, new iu());
            KyB.put(com.tencent.mm.plugin.appbrand.jsapi.bh.NAME, new cw());
            KyB.put("qqMailLoginResult", new ic());
        }
        g gVar2 = KyB.get(str);
        AppMethodBeat.o(152435);
        return gVar2;
    }

    private static List<g> gtr() {
        AppMethodBeat.i(223873);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new ba());
        linkedList.add(new az());
        linkedList.add(new bz());
        linkedList.add(new eb());
        linkedList.add(new dy());
        linkedList.add(new hu());
        linkedList.add(new ht());
        linkedList.add(new jl());
        linkedList.add(new dz());
        linkedList.add(new ea());
        linkedList.add(new j());
        linkedList.add(new hz());
        linkedList.add(new hy());
        linkedList.add(new bv());
        linkedList.add(new hd());
        linkedList.add(new au());
        linkedList.add(new cy());
        linkedList.add(new dc());
        linkedList.add(new t());
        linkedList.add(new fs());
        linkedList.add(new hr());
        linkedList.add(new p());
        linkedList.add(new q());
        linkedList.add(new cb());
        linkedList.add(new bi());
        AppMethodBeat.o(223873);
        return linkedList;
    }

    public static abstract class g {
        protected String KyD = "";
        protected int KyE = -1;
        protected boolean KyF = false;
        protected String NAME = "noName";

        public g() {
        }

        public g(String str, String str2, int i2, boolean z) {
            this.NAME = str;
            this.KyD = str2;
            this.KyE = i2;
            this.KyF = z;
        }

        public final String getName() {
            return this.NAME;
        }

        public final String gts() {
            return this.KyD;
        }

        public final int gtt() {
            return this.KyE;
        }

        public final boolean gtu() {
            return this.KyF;
        }
    }

    public static class la extends g {
        public la() {
            super("requireSoterBiometricAuthentication", "soter_biometric_authentication", 214, true);
        }
    }

    public static class lb extends g {
        public lb() {
            super("getSupportSoter", "getSupportSoter", 213, true);
        }
    }

    public static class fc extends g {
        public fc() {
            super("log", "", 0, false);
        }
    }

    public static class ek extends g {
        public ek() {
            super("imagePreview", "", 1, true);
        }
    }

    public static class ia extends g {
        public ia() {
            super(Scopes.PROFILE, Scopes.PROFILE, 2, false);
        }
    }

    public static class mt extends g {
        public mt() {
            super("shareWeibo", "share_weibo", 3, true);
        }
    }

    public static class lr extends g {
        public lr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.share.l.NAME, "share_timeline", 4, true);
        }
    }

    public static class o extends g {
        public o() {
            super(com.tencent.mm.plugin.appbrand.jsapi.al.NAME, "ad_data_report", TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, false);
        }
    }

    public static class lo extends g {
        public lo() {
            super("streamingVideoPlay", "playStreamingVideo", 209, false);
        }
    }

    public static class h extends g {
        public h() {
            super("addContact", "add_contact", 5, true);
        }
    }

    public static class du extends g {
        public du() {
            super("getWidgetCaptureImgUrl", "add_contact", 10000, false);
        }
    }

    public static class jk extends g {
        public jk() {
            super("sendAppMessage", "send_app_msg", 6, true);
        }
    }

    public static class jc extends g {
        public jc() {
            super("scanQRCode", "scanQRCode", 7, true);
        }
    }

    public static class eh extends g {
        public eh() {
            super("hideOptionMenu", "", 14, false);
        }
    }

    public static class ku extends g {
        public ku() {
            super("showOptionMenu", "", 14, false);
        }
    }

    public static class cv extends g {
        public cv() {
            super(com.tencent.mm.plugin.appbrand.jsapi.z.f.NAME, TPDownloadProxyEnum.USER_NETWORK_TYPE, 16, false);
        }
    }

    public static class aq extends g {
        public aq() {
            super("closeWindow", "close_window", 17, false);
        }
    }

    public static class cq extends g {
        public cq() {
            super(JsApiGetInstallState.NAME, "get_install_state", 25, false);
        }
    }

    public static class jy extends g {
        public jy() {
            super("setFontSizeCallback", "", -2, false);
        }
    }

    public static class er extends g {
        public er() {
            super("jumpToInstallUrl", "", 26, false);
        }
    }

    public static class ex extends g {
        public ex() {
            super("launchApp", "", 27, false);
        }
    }

    public static class cd extends g {
        public cd() {
            super("getBrandWCPayRequest", "get_brand_wcpay_request", 28, true);
        }
    }

    public static class je extends g {
        public je() {
            super(com.tencent.mm.plugin.appbrand.jsapi.o.h.NAME, "", TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, false);
        }
    }

    public static class mj extends g {
        public mj() {
            super("wcpaySecurityCrosscutBack", "", 355, true);
        }
    }

    public static class bl extends g {
        public bl() {
            super("editAddress", "edit_address", 29, true);
        }
    }

    public static class cn extends g {
        public cn() {
            super("getHeadingAndPitch", "get_heading_and_pitch", 33, false);
        }
    }

    public static class jp extends g {
        public jp() {
            super("sendEmail", "send_email", 35, false);
        }
    }

    public static class j extends g {
        public j() {
            super("addDownloadApp", "addDownloadApp", 344, true);
        }
    }

    public static class k extends g {
        public k() {
            super(JsApiAddDownloadTask.NAME, "add_download_task", 38, false);
        }
    }

    public static class x extends g {
        public x() {
            super(JsApiCancelDownloadTask.NAME, "cancel_download_task", 39, false);
        }
    }

    public static class hp extends g {
        public hp() {
            super(JsApiPauseDownloadTask.NAME, "cancel_download_task", TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, false);
        }
    }

    public static class ja extends g {
        public ja() {
            super(JsApiResumeDownloadTask.NAME, "resume_download_task", 240, true);
        }
    }

    public static class id extends g {
        public id() {
            super(JsApiQueryDownloadTask.NAME, "query_download_task", 40, false);
        }
    }

    public static class en extends g {
        public en() {
            super(JsApiInstallDownloadTask.NAME, "install_download_task", 41, false);
        }
    }

    public static class da extends g {
        public da() {
            super("getLatestAddress", "get_recently_used_address", 46, true);
        }
    }

    public static class gz extends g {
        public gz() {
            super("openSpecificView", "specific_view", 48, true);
        }
    }

    public static class et extends g {
        public et() {
            super("jumpWCMall", "jump_wcmall", 51, true);
        }
    }

    public static class ew extends g {
        public ew() {
            super("launch3rdApp", "launch_3rdApp", 52, true);
        }
    }

    public static class na extends g {
        public na() {
            super(JsApiWriteCommData.NAME, "write_comm_data", 53, false);
        }
    }

    public static class ha extends g {
        public ha() {
            super("openUrlByExtBrowser", "open_url_by_ext_browser", 55, false);
        }
    }

    public static class by extends g {
        public by() {
            super("geoLocation", "geo_location", 57, false);
        }
    }

    public static class cc extends g {
        public cc() {
            super("getBrandWCPayBindCardRequest", "get_brand_WCPay_bind_card_request", 58, true);
        }
    }

    public static class gs extends g {
        public gs() {
            super("openProductView", "open_product_view", 59, true);
        }
    }

    public static class gt extends g {
        public gt() {
            super("openProductViewWithPid", "open_product_view", 60, true);
        }
    }

    public static class es extends g {
        public es() {
            super("jumpToBizProfile", "jump_to_biz_profile", 61, true);
        }
    }

    public static class ng extends g {
        public ng() {
            super("jumpWSRecVideoList", "", com.tencent.mm.plugin.appbrand.jsapi.wifi.c.CTRL_INDEX, true);
        }
    }

    public static class nn extends g {
        public nn() {
            super("openWebSearchOutLinkItem", "", 320, true);
        }
    }

    public static class fj extends g {
        public fj() {
            super("openTimelineCheckInList", "open_timeline_checkin_list", 62, false);
        }
    }

    public static class fi extends g {
        public fi() {
            super(com.tencent.mm.plugin.appbrand.jsapi.i.p.NAME, "open_location", 63, true);
        }
    }

    public static class fh extends g {
        public fh() {
            super("timelineCheckIn", "timeline_check_in", 64, false);
        }
    }

    public static class hg extends g {
        public hg() {
            super("getBrandWCPayCreateCreditCardRequest", "get_wcpay_create_credit_card_request", 65, true);
        }
    }

    public static class ad extends g {
        public ad() {
            super("chooseCard", "choose_card", 70, true);
        }
    }

    public static class ah extends g {
        public ah() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ay.NAME, com.tencent.mm.plugin.appbrand.jsapi.ay.NAME, 202, true);
        }
    }

    public static class jq extends g {
        public jq() {
            super("sendServiceAppMessage", "send_service_app_msg", 67, true);
        }
    }

    public static class ff extends g {
        public ff() {
            super("musicPlay", "playMusic", 69, false);
        }
    }

    public static class ci extends g {
        public ci() {
            super("mmsf0001", "mmsf0001", -2, false);
        }
    }

    public static class av extends g {
        public av() {
            super("connectToWiFi", "connecttowifi", 71, false);
        }
    }

    public static class dq extends g {
        public dq() {
            super("getTransferMoneyRequest", "get_transfer_money_request", 74, true);
        }
    }

    public static class aa extends g {
        public aa() {
            super("changePayActivityView", "change_pay_activity_view", 207, true);
        }
    }

    public static class hc extends g {
        public hc() {
            super("openWCPaySpecificView", "open_wcpay_specific_view", 76, true);
        }
    }

    public static class jw extends g {
        public jw() {
            super("setCloseWindowConfirmDialogInfo", "setCloseWindowConfirmDialogInfo", 77, false);
        }
    }

    public static class s extends g {
        public s() {
            super("batchAddCard", "batch_add_card", 82, true);
        }
    }

    public static class hx extends g {
        public hx() {
            super("preVerifyJSAPI", "pre_verify_jsapi", -3, false);
        }
    }

    public static class le extends g {
        public le() {
            super(JsApiStartRecordVoice.NAME, JsApiStartRecordVoice.NAME, 96, false);
        }
    }

    public static class ll extends g {
        public ll() {
            super(JsApiStopRecordVoice.NAME, JsApiStopRecordVoice.NAME, 98, false);
        }
    }

    public static class hs extends g {
        public hs() {
            super(JsApiStartPlayVoice.NAME, JsApiStartPlayVoice.NAME, 99, false);
        }
    }

    public static class hq extends g {
        public hq() {
            super(JsApiPausePlayVoice.NAME, JsApiPausePlayVoice.NAME, 100, false);
        }
    }

    public static class ln extends g {
        public ln() {
            super(JsApiStopPlayVoice.NAME, JsApiStopPlayVoice.NAME, 101, false);
        }
    }

    public static class mf extends g {
        public mf() {
            super("uploadVoice", "uploadVoice", 102, true);
        }
    }

    public static class bh extends g {
        public bh() {
            super("downloadVoice", "downloadVoice", 103, true);
        }
    }

    public static class ag extends g {
        public ag() {
            super(JsApiChooseImage.NAME, JsApiChooseImage.NAME, 104, true);
        }
    }

    public static class mc extends g {
        public mc() {
            super("uploadImage", "uploadImage", 105, true);
        }
    }

    public static class bg extends g {
        public bg() {
            super("downloadImage", "downloadImage", 106, true);
        }
    }

    public static class md extends g {
        public md() {
            super("uploadMediaFile", "uploadMediaFile", TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, true);
        }
    }

    public static class ee extends g {
        public ee() {
            super("hideMenuItems", "hideMenuItems", 85, false);
        }
    }

    public static class kr extends g {
        public kr() {
            super("showMenuItems", "showMenuItems", 86, false);
        }
    }

    public static class ed extends g {
        public ed() {
            super("hideAllNonBaseMenuItem", "hideAllNonBaseMenuItem", 93, false);
        }
    }

    public static class ko extends g {
        public ko() {
            super("showAllNonBaseMenuItem", "showAllNonBaseMenuItem", 92, false);
        }
    }

    public static class dn extends g {
        public dn() {
            super("getSendC2CMessageRequest", "get_send_c2c_message_request", 83, true);
        }
    }

    public static class ac extends g {
        public ac() {
            super("checkJsApi", "checkJsApi", 84, false);
        }
    }

    public static class ls extends g {
        public ls() {
            super("translateVoice", "translateVoice", 97, true);
        }
    }

    public static class kl extends g {
        public kl() {
            super("shareQQ", "shareQQ", 90, true);
        }
    }

    public static class nj extends g {
        public nj() {
            super("menu:share:qq", "", 94, false);
        }
    }

    public static class kn extends g {
        public kn() {
            super("shareWeiboApp", "shareWeiboApp", 107, false);
        }
    }

    public static class nl extends g {
        public nl() {
            super("menu:share:timeline", "", 88, false);
        }
    }

    public static class ni extends g {
        public ni() {
            super("menu:share:appmessage", "", 89, false);
        }
    }

    public static class nm extends g {
        public nm() {
            super("menu:share:weiboApp", "", 109, false);
        }
    }

    public static class nk extends g {
        public nk() {
            super("menu:share:QZone", "", com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX, false);
        }
    }

    public static class nh extends g {
        public nh() {
            super("menu:setfont", "", 129, false);
        }
    }

    public static class v extends g {
        public v() {
            super("batchViewCard", "batchViewCard", 111, true);
        }
    }

    public static class at extends g {
        public at() {
            super("configWXDeviceWiFi", "configWXDeviceWiFi", 126, true);
        }
    }

    public static class cg extends g {
        public cg() {
            super("getCurrentSSID", "getCurrentSSID", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, true);
        }
    }

    public static class kd extends g {
        public kd() {
            super("setPageOwner", "setPageOwner", 114, false);
        }
    }

    public static class ds extends g {
        public ds() {
            super("getWechatVerifyTicket", "getWechatVerifyTicket", 112, false);
        }
    }

    public static class hh extends g {
        public hh() {
            super("openWXDeviceLib", "openWXDeviceLib", 117, false);
        }
    }

    public static class as extends g {
        public as() {
            super("closeWXDeviceLib", "closeWXDeviceLib", 118, false);
        }
    }

    public static class kh extends g {
        public kh() {
            super("setSendDataDirection", "setSendDataDirection", TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, false);
        }
    }

    public static class mh extends g {
        public mh() {
            super("verifyWCPayPassword", "verifyWCPayPassword", 115, true);
        }
    }

    public static class cz extends g {
        public cz() {
            super("getPaymentOrderRequest", "getPaymentOrderRequest", 116, true);
        }
    }

    public static class lc extends g {
        public lc() {
            super("startMonitoringBeacons", "startMonitoringBeacons", 151, false);
        }
    }

    public static class lj extends g {
        public lj() {
            super("stopMonitoringBeacons", "stopMonitoringBeacons", 152, false);
        }
    }

    public static class lf extends g {
        public lf() {
            super("startScanWXDevice", "startScanWXDevice", 121, true);
        }
    }

    public static class lm extends g {
        public lm() {
            super("stopScanWXDevice", "stopScanWXDevice", 122, true);
        }
    }

    public static class aw extends g {
        public aw() {
            super("connectWXDevice", "connectWXDevice", 123, true);
        }
    }

    public static class bf extends g {
        public bf() {
            super("disconnectWXDevice", "disconnectWXDevice", 124, true);
        }
    }

    public static class dw extends g {
        public dw() {
            super("getWXDeviceTicket", "getWXDeviceTicket", 125, true);
        }
    }

    public static class dv extends g {
        public dv() {
            super("getWXDeviceInfos", "getWXDeviceInfos", 119, true);
        }
    }

    public static class jm extends g {
        public jm() {
            super("sendDataToWXDevice", "sendDataToWXDevice", 120, true);
        }
    }

    public static class km extends g {
        public km() {
            super("shareQZone", "shareQZone", 132, true);
        }
    }

    public static class gi extends g {
        public gi() {
            super("openGameDetail", "openGameDetail", TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, true);
        }
    }

    public static class gh extends g {
        public gh() {
            super("openGameCenter", "openGameCenter", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, true);
        }
    }

    public static class jz extends g {
        public jz() {
            super("setGameDebugConfig", "setGameDebugConfig", 1111111, false);
        }
    }

    public static class lh extends g {
        public lh() {
            super("startTempSession", "startTempSession", 128, true);
        }
    }

    public static class e extends g {
        public e() {
            super("getRecevieBizHongBaoRequest", "getRecevieBizHongBaoRequest", com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX, true);
        }
    }

    public static class f extends g {
        public f() {
            super("scanCover", "scanCover", com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX, true);
        }
    }

    public static class im extends g {
        public im() {
            super("reportActionInfo", "reportActionInfo", TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, false);
        }
    }

    public static class co extends g {
        public co() {
            super("getH5PrepayRequest", "getH5PrepayRequest", 137, true);
        }
    }

    public static class gp extends g {
        public gp() {
            super("openMyDeviceProfile", "openMyDeviceProfile", 145, false);
        }
    }

    public static class jh extends g {
        public jh() {
            super("selectPedometerSource", "selectPedometerSource", 146, true);
        }
    }

    public static class cp extends g {
        public cp() {
            super("getH5TransactionRequest", "getH5TransactionRequest", 138, true);
        }
    }

    public static class eu extends g {
        public eu() {
            super("jumpToWXWallet", "jumpToWXWallet", TbsListener.ErrorCode.NEEDDOWNLOAD_8, true);
        }
    }

    public static class fp extends g {
        public fp() {
            super("nfcIsConnect", "nfcIsConnect", com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX, true);
        }
    }

    public static class fm extends g {
        public fm() {
            super("nfcConnect", "nfcConnect", 140, false);
        }
    }

    public static class fq extends g {
        public fq() {
            super("nfcTransceive", "nfcTransceive", 141, false);
        }
    }

    public static class fk extends g {
        public fk() {
            super("nfcBatchTransceive", "nfcBatchTransceive", TbsListener.ErrorCode.NEEDDOWNLOAD_3, false);
        }
    }

    public static class fn extends g {
        public fn() {
            super("nfcGetId", "nfcGetId", TbsListener.ErrorCode.NEEDDOWNLOAD_4, false);
        }
    }

    public static class fo extends g {
        public fo() {
            super("nfcGetInfo", "nfcGetInfo", 148, false);
        }
    }

    public static class fl extends g {
        public fl() {
            super("nfcCheckState", "nfcCheckState", 155, true);
        }
    }

    public static class mm extends g {
        public mm() {
            super("videoProxyInit", "videoProxyInit", 156, false);
        }
    }

    public static class mp extends g {
        public mp() {
            super("videoProxyStartPlay", "videoProxyStartPlay", 157, false);
        }
    }

    public static class mq extends g {
        public mq() {
            super("videoProxyStopPlay", "videoProxyStopPlay", 158, false);
        }
    }

    public static class mn extends g {
        public mn() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", JsApiGetBackgroundAudioState.CTRL_INDEX, false);
        }
    }

    public static class mo extends g {
        public mo() {
            super("videoProxySetPlayerState", "videoProxySetPlayerState", 160, false);
        }
    }

    public static class em extends g {
        public em() {
            super("insertVideoPlayer", "", 10000, false);
        }
    }

    public static class lz extends g {
        public lz() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.d.e.NAME, "", 10000, false);
        }
    }

    public static class il extends g {
        public il() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.d.d.NAME, "", 10000, false);
        }
    }

    public static class hl extends g {
        public hl() {
            super(com.tencent.mm.plugin.appbrand.jsapi.video.d.c.NAME, "", 10000, false);
        }
    }

    public static class dj extends g {
        public dj() {
            super("getSearchHistory", "", 10000, false);
        }
    }

    public static class bc extends g {
        public bc() {
            super("deleteSearchHistory", "", 10000, false);
        }
    }

    public static class df extends g {
        public df() {
            super("getSearchData", "", 10000, false);
        }
    }

    public static class nr extends g {
        public nr() {
            super("showWeDrawHomeView", "", 10000, false);
        }
    }

    public static class nq extends g {
        public nq() {
            super("getFestivalLiveInfo", "", 10000, false);
        }
    }

    public static class ce extends g {
        public ce() {
            super("getChatSearchData", "", 10000, false);
        }
    }

    public static class bw extends g {
        public bw() {
            super("querySearchWeb", "", 10000, false);
        }
    }

    public static class gg extends g {
        public gg() {
            super(com.tencent.mm.plugin.appbrand.jsapi.finder.h.NAME, "", 10000, false);
        }
    }

    public static class gf extends g {
        public gf() {
            super("openFinderFeed", "", 10000, false);
        }
    }

    public static class cf extends g {
        public cf() {
            super("getCurrentLocation", "", 10000, false);
        }
    }

    public static class fg extends g {
        public fg() {
            super("navControl", "", 10000, false);
        }
    }

    public static class kt extends g {
        public kt() {
            super("showNavBarShadow", "", 10000, false);
        }
    }

    public static class eg extends g {
        public eg() {
            super("hideNavBarShadow", "", 10000, false);
        }
    }

    public static class cm extends g {
        public cm() {
            super("getPoiInfo", "", 10000, false);
        }
    }

    public static class lv extends g {
        public lv() {
            super("updateReddotTimeStamps", "", 10000, false);
        }
    }

    public static class dp extends g {
        public dp() {
            super("getTeachSearchData", "", 10000, false);
        }
    }

    public static class di extends g {
        public di() {
            super("getSearchGuideData", "", 10000, false);
        }
    }

    public static class de extends g {
        public de() {
            super("getSearchAvatarList", "", 10000, false);
        }
    }

    public static class dl extends g {
        public dl() {
            super("getSearchSnsImageList", "", 10000, false);
        }
    }

    public static class dk extends g {
        public dk() {
            super("getSearchImageList", "", 10000, false);
        }
    }

    public static class dg extends g {
        public dg() {
            super("getSearchDisplayNameList", "getSearchDisplayNameList", 10000, false);
        }
    }

    public static class lg extends g {
        public lg() {
            super("startSearchItemDetailPage", "", 10000, false);
        }
    }

    public static class is extends g {
        public is() {
            super("reportSearchStatistics", "", 10000, false);
        }
    }

    public static class ir extends g {
        public ir() {
            super("reportSearchRealTimeStatistics", "", 10000, false);
        }
    }

    public static class jd extends g {
        public jd() {
            super("searchDataHasResult", "", 10000, false);
        }
    }

    public static class bu extends g {
        public bu() {
            super("openEmotionPage", "", 10000, false);
        }
    }

    public static class dm extends g {
        public dm() {
            super("getSearchSuggestionData", "", 10000, false);
        }
    }

    public static class kg extends g {
        public kg() {
            super("setSearchInputWord", "", 10000, false);
        }
    }

    public static class ki extends g {
        public ki() {
            super("setSnsObjectXmlDescList", "", 10000, false);
        }
    }

    public static class ap extends g {
        public ap() {
            super("clickSnsMusicPlayButton", "", 10000, false);
        }
    }

    public static class hf extends g {
        public hf() {
            super("openWeAppPage", "", 10000, false);
        }
    }

    public static class mu extends g {
        public mu() {
            super("reportWeAppSearchRealtime", "", 10000, false);
        }
    }

    public static class bk extends g {
        public bk() {
            super("doSearchOperation", "", 10000, false);
        }
    }

    public static class el extends g {
        public el() {
            super("insertSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class ik extends g {
        public ik() {
            super("removeSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class lx extends g {
        public lx() {
            super("updateSearchWAWidgetView", "", 10000, false);
        }
    }

    public static class kv extends g {
        public kv() {
            super("showSearchActionSheet", "showSearchActionSheet", 10000, false);
        }
    }

    public static class z extends g {
        public z() {
            super("cancelSearchActionSheet", "cancelSearchActionSheet", 10000, false);
        }
    }

    public static class ky extends g {
        public ky() {
            super("showSearchToast", "showSearchToast", 10000, false);
        }
    }

    public static class kw extends g {
        public kw() {
            super("showSearchLoading", "showSearchLoading", 10000, false);
        }
    }

    public static class ei extends g {
        public ei() {
            super("hideSearchLoading", "hideSearchLoading", 10000, false);
        }
    }

    public static class ma extends g {
        public ma() {
            super("updateWASearchTemplate", "updateWASearchTemplate", 10000, false);
        }
    }

    public static class hv extends g {
        public hv() {
            super("preloadSearchWeapp", "preloadSearchWeapp", 10000, false);
        }
    }

    public static class mg extends g {
        public mg() {
            super("uxSearchOpLog", "uxSearchOpLog", 10000, false);
        }
    }

    public static class hk extends g {
        public hk() {
            super("operateGameCenterMsg", "operateGameCenterMsg", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, false);
        }
    }

    public static class fb extends g {
        public fb() {
            super("getWebPayCheckoutCounterRequst", "getWebPayCheckoutCounterRequst", 161, true);
        }
    }

    public static class i extends g {
        public i() {
            super("addCustomMenuItems", "addCustomMenuItems", TbsListener.ErrorCode.STARTDOWNLOAD_5, false);
        }
    }

    public static class gd extends g {
        public gd() {
            super("openEnterpriseChat", "openEnterpriseChat", TbsListener.ErrorCode.STARTDOWNLOAD_6, false);
        }
    }

    public static class bp extends g {
        public bp() {
            super("enterEnterpriseChat", "enterEnterpriseChat", TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, false);
        }
    }

    public static class ge extends g {
        public ge() {
            super("openEnterpriseContact", "openEnterpriseContact", 183, true);
        }
    }

    public static class jg extends g {
        public jg() {
            super("selectEnterpriseContact", "selectEnterpriseContact", com.tencent.mm.plugin.appbrand.jsapi.az.CTRL_INDEX, true);
        }
    }

    public static class jn extends g {
        public jn() {
            super("sendEnterpriseChat", "sendEnterpriseChat", TbsListener.ErrorCode.UNLZMA_FAIURE, true);
        }
    }

    public static class ck extends g {
        public ck() {
            super("getEnterpriseChat", "getEnterpriseChat", 244, false);
        }
    }

    public static class li extends g {
        public li() {
            super("startVoipCall", "startVoipCall", 230, false);
        }
    }

    public static class ai extends g {
        public ai() {
            super(com.tencent.mm.plugin.appbrand.jsapi.az.NAME, com.tencent.mm.plugin.appbrand.jsapi.az.NAME, 288, true);
        }
    }

    public static class ip extends g {
        public ip() {
            super("reportIDKey", "reportIDKey", TbsListener.ErrorCode.STARTDOWNLOAD_4, false);
        }
    }

    public static class ig extends g {
        public ig() {
            super("quicklyAddBrandContact", "quicklyAddBrandContact", 166, true);
        }
    }

    public static class ax extends g {
        public ax() {
            super("consumedShareCard", "consumedShareCard", TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, true);
        }
    }

    public static class ml extends g {
        public ml() {
            super("cache", "cache", 150, false);
        }
    }

    public static class mr extends g {
        public mr() {
            super("publicCache", "publicCache", 149, false);
        }
    }

    public static class hb extends g {
        public hb() {
            super("openUrlWithExtraWebview", "openUrlWithExtraWebview", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3, false);
        }
    }

    public static class ms extends g {
        public ms() {
            super("videoProxyPreload", "videoProxyPreload", 172, false);
        }
    }

    public static class ev extends g {
        public ev() {
            super(com.tencent.mm.plugin.appbrand.jsapi.finder.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.finder.d.NAME, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, false);
        }
    }

    public static class ih extends g {
        public ih() {
            super("realtimeReport", "realtimeReport", TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1, false);
        }
    }

    public static class jj extends g {
        public jj() {
            super("sendAppMessageToSpecifiedContact", "sendAppMessageToSpecifiedContact", 168, true);
        }
    }

    public static class ji extends g {
        public ji() {
            super("selectSingleContact", "selectSingleContact", TbsListener.ErrorCode.STARTDOWNLOAD_8, true);
        }
    }

    public static class cr extends g {
        public cr() {
            super("getLocalData", "getLocalData", 179, false);
        }
    }

    public static class ka extends g {
        public ka() {
            super("setLocalData", "setLocalData", TXLiveConstants.RENDER_ROTATION_180, false);
        }
    }

    public static class an extends g {
        public an() {
            super("clearLocalData", "clearLocalData", 181, false);
        }
    }

    public static class kq extends g {
        public kq() {
            super("showKeyboard", "showKeyboard", 187, false);
        }
    }

    public static class kz extends g {
        public kz() {
            super("showSmileyPanel", "showSmileyPanel", TbsListener.ErrorCode.TPATCH_FAIL, false);
        }
    }

    public static class bd extends g {
        public bd() {
            super("disableBounceScroll", "disableBounceScroll", 188, false);
        }
    }

    public static class al extends g {
        public al() {
            super("clearBounceBackground", "clearBounceBackground", 189, false);
        }
    }

    public static class kb extends g {
        public kb() {
            super("setNavigationBarButtons", "setNavigationBarButtons", 195, false);
        }
    }

    public static class kj extends g {
        public kj() {
            super("setStatusBarStyle", "setStatusBarStyle", 206, false);
        }
    }

    public static class bn extends g {
        public bn() {
            super("enableFullScreen", "enableFullScreen", 196, false);
        }
    }

    public static class ks extends g {
        public ks() {
            super(com.tencent.mm.plugin.appbrand.jsapi.p.ai.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.ai.NAME, 197, false);
        }
    }

    public static class ef extends g {
        public ef() {
            super(com.tencent.mm.plugin.appbrand.jsapi.p.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.z.CTRL_INDEX, false);
        }
    }

    public static class bo extends g {
        public bo() {
            super("enablePullDownRefresh", "enablePullDownRefresh", 199, false);
        }
    }

    public static class ld extends g {
        public ld() {
            super(com.tencent.mm.plugin.appbrand.jsapi.p.ak.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.ak.NAME, 204, false);
        }
    }

    public static class lk extends g {
        public lk() {
            super(com.tencent.mm.plugin.appbrand.jsapi.p.al.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.al.NAME, 200, false);
        }
    }

    public static class be extends g {
        public be() {
            super("disablePullDownRefresh", "disablePullDownRefresh", 205, false);
        }
    }

    public static class ke extends g {
        public ke() {
            super("setPageTitle", "setPageTitle", 113, false);
        }
    }

    public static class bb extends g {
        public bb() {
            super("deleteAccountSuccess", "deleteAccountSuccess", 144, false);
        }
    }

    public static class ak extends g {
        public ak() {
            super("chooseVideo", "chooseVideo", 191, true);
        }
    }

    public static class me extends g {
        public me() {
            super("uploadVideo", "uploadVideo", 192, true);
        }
    }

    public static class go extends g {
        public go() {
            super("openMapNavigateMenu", "openMapNavigateMenu", 184, true);
        }
    }

    public static class jb extends g {
        public jb() {
            super("scanLicence", "scanLicence", 203, false);
        }
    }

    public static class kc extends g {
        public kc() {
            super(com.tencent.mm.plugin.appbrand.jsapi.p.z.NAME, com.tencent.mm.plugin.appbrand.jsapi.p.z.NAME, 182, false);
        }
    }

    public static class my extends g {
        public my() {
            super("WNNativeCallbackOnClick", "WNNativeCallbackOnClick", 10006, false);
        }
    }

    public static class dr extends g {
        public dr() {
            super("getWCPayRealnameVerify", "getWCPayRealnameVerify", 194, true);
        }
    }

    public static class fz extends g {
        public fz() {
            super("openDesignerProfile", "openDesignerProfile", 193, true);
        }
    }

    public static class fx extends g {
        public fx() {
            super("openDesignerEmojiView", "openDesignerEmojiView", 185, true);
        }
    }

    public static class gc extends g {
        public gc() {
            super("openEmoticonTopicList", "openEmoticonTopicList", 212, true);
        }
    }

    public static class lp extends g {
        public lp() {
            super("selectWalletCurrency", "selectWalletCurrency", 201, true);
        }
    }

    public static class ga extends g {
        public ga() {
            super("openDesignerProfileLocal", "openDesignerProfileLocal", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class fy extends g {
        public fy() {
            super("openDesignerEmojiViewLocal", "openDesignerEmojiViewLocal", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class d extends g {
        public d() {
            super("openEmotionDetailViewLocal", "openEmotionDetailViewLocal", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class gq extends g {
        public gq() {
            super("openNewPage", "openNewPage", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class dh extends g {
        public dh() {
            super("getSearchEmotionData", "getSearchEmotionData", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class bm extends g {
        public bm() {
            super("openEmotionUrl", "openEmotionUrl", com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT, false);
        }
    }

    public static class mz extends g {
        public mz() {
            super("WNNativeCallbackOnLongClick", "WNNativeCallbackOnLongClick", 10006, false);
        }
    }

    public static class mx extends g {
        public mx() {
            super("WNNativeCallbackOnCaretChange", "WNNativeCallbackOnCaretChange", 10006, false);
        }
    }

    public static class mw extends g {
        public mw() {
            super("WNNativeCallbackInitData", "WNNativeCallbackInitData", 10006, false);
        }
    }

    public static class mv extends g {
        public mv() {
            super("WNNativeAsyncCallback", "WNNativeAsyncCallback", 10006, false);
        }
    }

    public static class ne extends g {
        public ne() {
            super("WNNativeCallbackOnBecomeEditing", "WNNativeCallbackOnBecomeEditing", 10006, false);
        }
    }

    public static class nf extends g {
        public nf() {
            super("WNNativeCallbackOnBecomeEdited", "WNNativeCallbackOnBecomeEdited", 10006, false);
        }
    }

    public static class b extends g {
        public b() {
            super(JsApiOperateMusicPlayer.NAME, JsApiOperateMusicPlayer.NAME, 211, false);
        }
    }

    public static class a extends g {
        public a() {
            super(JsApiGetMusicPlayerState.NAME, JsApiGetMusicPlayerState.NAME, 210, false);
        }
    }

    public static class ao extends g {
        public ao() {
            super("clearWebviewCache", "clearWebviewCache", 208, false);
        }
    }

    public static class lt extends g {
        public lt() {
            super("unbindBankCard", "unbindBankCard", 216, true);
        }
    }

    public static class jv extends g {
        public jv() {
            super("setBounceBackground", "setBounceBackground", 218, false);
        }
    }

    public static class bj extends g {
        public bj() {
            super("doExposePreparation", "doExposePreparation", TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, false);
        }
    }

    public static class cu extends g {
        public cu() {
            super("getMsgProofItems", "getMsgProofItems", 226, true);
        }
    }

    public static class gx extends g {
        public gx() {
            super("openSecurityView", "openSecurityView", 229, false);
        }
    }

    public static class cx extends g {
        public cx() {
            super("getOpenDeviceId", "getOpenDeviceId", TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, false);
        }
    }

    public static class dd extends g {
        public dd() {
            super("getRouteUrl", "getRouteUrl", TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, false);
        }
    }

    public static class ej extends g {
        public ej() {
            super("idCardRealnameVerify", "idCardRealnameVerify", TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, true);
        }
    }

    public static class no extends g {
        public no() {
            super("uploadIdCardSuccess", "uploadIdCardSuccess", TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, false);
        }
    }

    public static class cl extends g {
        public cl() {
            super("getGameCommInfo", "getGameCommInfo", TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, false);
        }
    }

    public static class af extends g {
        public af() {
            super("chooseIdCard", "chooseIdCard", 247, true);
        }
    }

    public static class gj extends g {
        public gj() {
            super("openGameRegion", "openGameRegion", 242, true);
        }
    }

    public static class kp extends g {
        public kp() {
            super(com.tencent.mm.plugin.appbrand.jsapi.r.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.r.f.NAME, 248, true);
        }
    }

    public static class gm extends g {
        public gm() {
            super("openLuckyMoneyDetailView", "openLuckyMoneyDetailView", 245, false);
        }
    }

    public static class iz extends g {
        public iz() {
            super("resendRemittanceMsg", "resendRemittanceMsg", 246, true);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$c  reason: collision with other inner class name */
    public static class C2037c extends g {
        public C2037c() {
            super("getLocalImgData", "getLocalImgData", com.tencent.mm.plugin.appbrand.jsapi.cr.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class he extends g {
        he() {
            super("openWeApp", "openWeApp", 250, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ii extends g {
        ii() {
            super("recordVideo", "recordVideo", 251, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hw extends g {
        hw() {
            super("previewVideo", "previewVideo", 252, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class mb extends g {
        mb() {
            super("uploadEncryptMediaFile", "uploadEncryptMediaFile", 253, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fw extends g {
        fw() {
            super("openCustomWebview", "openCustomWebview", 256, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class aj extends g {
        aj() {
            super(JsApiChooseMedia.NAME, JsApiChooseMedia.NAME, 254, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bt extends g {
        bt() {
            super("forceUpdateWxaAttr", "forceUpdateWxaAttr", CdnLogic.kAppTypeFestivalImage, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gn extends g {
        gn() {
            super("openLuckyMoneyHistory", "openLuckyMoneyHistory", CdnLogic.kAppTypeFestivalVideo, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jo extends g {
        jo() {
            super("menuitem:gameSendDesktop", "menuitem:gameSendDesktop", 255, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bq extends g {
        bq() {
            super("requestWxFacePictureVerify", "requestWxFacePictureVerify", 259, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class dt extends g {
        dt() {
            super("getWePkgAuthResult", "getWePkgAuthResult", -3, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cs extends g {
        cs() {
            super("getLocalWePkgInfo", "getLocalWePkgInfo", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gl extends g {
        gl() {
            super("openGameWebView", "openGameWebView", 287, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ey extends g {
        ey() {
            super("launchApplication", "launchApplication", 260, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class kx extends g {
        kx() {
            super("showSearchOfBizHistory", "showSearchOfBizHistory", 266, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fd extends g {
        fd() {
            super("login", "login", 231, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class r extends g {
        r() {
            super(com.tencent.mm.plugin.appbrand.jsapi.auth.k.NAME, com.tencent.mm.plugin.appbrand.jsapi.auth.k.NAME, 232, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class br extends g {
        br() {
            super("requestWxFacePictureVerifyUnionVideo", "requestWxFacePictureVerifyUnionVideo", 264, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ab extends g {
        ab() {
            super("checkIsSupportFaceDetect", "checkIsSupportFaceDetect", 265, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hj extends g {
        hj() {
            super(JsApiOperateBackgroundAudio.NAME, JsApiOperateBackgroundAudio.NAME, 261, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ju extends g {
        ju() {
            super(JsApiSetBackgroundAudioState.NAME, JsApiSetBackgroundAudioState.NAME, 262, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ca extends g {
        ca() {
            super(JsApiGetBackgroundAudioState.NAME, JsApiGetBackgroundAudioState.NAME, 263, false);
        }
    }

    public static class l extends g {
        public l() {
            super(JsApiAddDownloadTaskStraight.NAME, "add_download_task_straight", 269, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class kf extends g {
        kf() {
            super("setScreenOrientation", "setScreenOrientation", 270, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n extends g {
        n() {
            super("addToEmoticon", "addToEmoticon", a.C0693a.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class kk extends g {
        kk() {
            super("shareEmoticon", "shareEmoticon", 275, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iw extends g {
        iw() {
            super("requestWxFaceRegisterInternal", "requestWxFaceRegisterInternal", 272, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ix extends g {
        ix() {
            super("requestWxFaceVerifyInternal", "requestWxFaceVerifyInternal", 273, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fa extends g {
        fa() {
            super(com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, 277, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bv extends g {
        bv() {
            super(com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.fakenative.d.NAME, 338, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iq extends g {
        iq() {
            super("reportMiniProgramPageData", "reportMiniProgramPageData", com.tencent.mm.plugin.appbrand.jsapi.p.ak.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fv extends g {
        fv() {
            super(JsApiOpenAdCanvas.NAME, JsApiOpenAdCanvas.NAME, com.tencent.mm.plugin.appbrand.jsapi.ct.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gu extends g {
        gu() {
            super("openSearchCanvas", "openSearchCanvas", com.tencent.mm.plugin.appbrand.jsapi.ct.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ho extends g {
        ho() {
            super("opVoteAdData", "", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hn extends g {
        hn() {
            super("opJumpView", "", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hm extends g {
        hm() {
            super("opAdH5Func", "", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jf extends g {
        jf() {
            super("selectContact", "selectContact", 10000, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gv extends g {
        gv() {
            super("openSearchWAWidgetLogView", "openSearchWAWidgetLogView", 10000, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class lq extends g {
        lq() {
            super("tapSearchWAWidgetView", "tapSearchWAWidgetView", 10000, false);
        }
    }

    public static class ij extends g {
        public ij() {
            super("reloadSearchWAWidgetData", "", 10000, false);
        }
    }

    public static class dx extends g {
        public dx() {
            super("gotoEmoticonPad", "", 10000, false);
        }
    }

    /* renamed from: com.tencent.mm.protocal.c$if  reason: invalid class name */
    public static class Cif extends g {
        public Cif() {
            super("querySimilarEmotion", "", 10000, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ct extends g {
        ct() {
            super("getMatchContactList", "getMatchContactList", 10000, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gw extends g {
        gw() {
            super("openSearchWebView", "openSearchWebView", 10000, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hi extends g {
        hi() {
            super("openWXSearchPage", "openWXSearchPage", 309, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class mi extends g {
        mi() {
            super("viewTypeChange", "", 10000, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fe extends g {
        fe() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bp.NAME, com.tencent.mm.plugin.appbrand.jsapi.bp.NAME, 356, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ec extends g {
        ec() {
            super("handleWCPayWalletBuffer", "handleWCPayWalletBuffer", 294, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ar extends g {
        ar() {
            super("closeWindowAndGoNext", "closeWindowAndGoNext", com.tencent.mm.plugin.appbrand.jsapi.audio.h.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iy extends g {
        iy() {
            super("requestWxVoicePrintVerifyInternal", "requestWxVoicePrintVerifyInternal", com.tencent.mm.plugin.appbrand.jsapi.audio.l.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ep extends g {
        ep() {
            super("invokeMiniProgramAPI", "invokeMiniProgramAPI", com.tencent.mm.plugin.appbrand.jsapi.audio.k.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gk extends g {
        gk() {
            super("openGameUrlWithExtraWebView", "openGameUrlWithExtraWebView", com.tencent.mm.plugin.appbrand.jsapi.audio.i.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jx extends g {
        jx() {
            super("setGameData", "setGameData", com.tencent.mm.plugin.appbrand.jsapi.af.g.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ch extends g {
        ch() {
            super("getGameData", "getGameData", com.tencent.mm.plugin.appbrand.jsapi.af.h.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fu extends g {
        fu() {
            super("openBizChat", "openBizChat", 296, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class am extends g {
        am() {
            super("clearGameData", "clearGameData", 300, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gb extends g {
        gb() {
            super("openECard", "openECard", 268, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class in extends g {
        in() {
            super("reportGamePageTime", "reportGamePageTime", 301, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jt extends g {
        jt() {
            super("setWCPayPassword", "setWCPayPassword", 289, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bx extends g {
        bx() {
            super("recordHistory", "recordHistory", TbsListener.ErrorCode.RENAME_EXCEPTION, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ft extends g {
        ft() {
            super("openWCPayCardList", "openWCPayCardList", TPNativePlayerInitConfig.INT_PIXEL_FORMAT, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gr extends g {
        gr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ca.NAME, com.tencent.mm.plugin.appbrand.jsapi.ca.NAME, 305, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class w extends g {
        w() {
            super("bindEmail", "bindEmail", TbsListener.ErrorCode.THROWABLE_QBSDK_INIT, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hu extends g {
        hu() {
            super(com.tencent.mm.plugin.appbrand.jsapi.cz.NAME, com.tencent.mm.plugin.appbrand.jsapi.cz.NAME, 302, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ht extends g {
        public ht() {
            super("preloadMiniProgramContacts", "preloadMiniProgramContacts", 303, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.protocal.c$do  reason: invalid class name */
    public static final class Cdo extends g {
        Cdo() {
            super("getSystemInfo", "getSystemInfo", TPNativePlayerInitConfig.INT_WIDTH, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class js extends g {
        js() {
            super("serviceClick", "serviceClick", 304, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class db extends g {
        db() {
            super("doGoToRecVideoList", "doGoToRecVideoList", 10000, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class nd extends g {
        nd() {
            super(com.tencent.mm.plugin.appbrand.jsapi.autofill.f.NAME, com.tencent.mm.plugin.appbrand.jsapi.autofill.f.NAME, 314, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jr extends g {
        jr() {
            super("sendSingleAppMessage", "sendSingleAppMessage", com.tencent.mm.plugin.appbrand.jsapi.wifi.a.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class jl extends g {
        public jl() {
            super("sendDataToMiniProgram", "sendDataToMiniProgram", TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_01, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ay extends g {
        public ay() {
            super("currentMpInfo", "currentMpInfo", com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, false);
        }
    }

    public static class ba extends g {
        public ba() {
            super("currentMpInfoShow", "currentMpInfoShow", com.tencent.mm.plugin.appbrand.jsapi.o.e.CTRL_INDEX, false);
        }
    }

    public static class az extends g {
        public az() {
            super("currentMpInfoHide", "currentMpInfoHide", com.tencent.mm.plugin.appbrand.jsapi.o.g.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class mk extends g {
        mk() {
            super("wcPrivacyPolicyResult", "wcPrivacyPolicyResult", com.tencent.mm.plugin.appbrand.jsapi.wifi.e.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ly extends g {
        ly() {
            super("updateTimelineShareData", "updateTimelineShareData", TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class lw extends g {
        lw() {
            super("updateAppMessageShareData", "updateAppMessageShareData", TbsListener.ErrorCode.TEST_THROWABLE_IS_NULL, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bs extends g {
        bs() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, com.tencent.mm.plugin.appbrand.jsapi.bio.face.d.NAME, TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class nc extends g {
        nc() {
            super("getCCData", "getCCData", 312, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class nb extends g {
        nb() {
            super("calRqt", "calRqt", TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class it extends g {
        it() {
            super(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fr extends g {
        fr() {
            super("notifyPageInfo", "notifyPageInfo", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class lu extends g {
        lu() {
            super("updatePageAuth", "updatePageAuth", -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class io extends g {
        io() {
            super("reportGameWeb", "reportGameWeb", TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_THROWABLE, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class eq extends g {
        eq() {
            super("jumpDownloaderWidget", "jumpDownloaderWidget", 339, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class u extends g {
        u() {
            super("batchUpdateWepkg", "batchUpdateWepkg", TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class m extends g {
        m() {
            super("addGameDownloadTask", "addGameDownloadTask", -1, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hz extends g {
        hz() {
            super("privateOpenWeappFunctionalPage", "privateOpenWeappFunctionalPage", TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hy extends g {
        hy() {
            super("privateCommonApi", "privateCommonApi", TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, true);
        }
    }

    public static final class eo extends g {
        eo() {
            super("internelWxFaceVerify", "internelWxFaceVerify", TbsListener.ErrorCode.THROWABLE_INITX5CORE, true);
        }
    }

    public static final class hd extends g {
        hd() {
            super("openWebViewUseFastLoad", "openWebViewUseFastLoad", 336, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class dz extends g {
        dz() {
            super("handleHaokanAction", "handleHaokanAction", 335, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ea extends g {
        ea() {
            super("handleMPPageAction", "handleMPPageAction", 345, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cj extends g {
        cj() {
            super("getDownloadWidgetTaskInfos", "getDownloadWidgetTaskInfos", 340, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class au extends g {
        au() {
            super("confirmDialog", "confirmDialog", com.tencent.mm.plugin.appbrand.jsapi.k.aa.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cy extends g {
        cy() {
            super("getPasteboardContent", "getPasteboardContent", 364, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class dc extends g {
        dc() {
            super("getRedPacketDone", "getRedPacketDone", 365, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ae extends g {
        ae() {
            super("chooseHaowanMedia", "chooseHaowanMedia", com.tencent.mm.plugin.appbrand.jsapi.nfc.f.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ie extends g {
        ie() {
            super("queryHaowanPublish", "queryHaowanPublish", com.tencent.mm.plugin.appbrand.jsapi.nfc.g.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ib extends g {
        ib() {
            super("publishHaowanEdition", "publishHaowanEdition", 351, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class y extends g {
        y() {
            super("cancelHaowanPublish", "cancelHaowanPublish", com.tencent.mm.plugin.appbrand.jsapi.nfc.h.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ez extends g {
        ez() {
            super("launchGameVideoEditor", "launchGameVideoEditor", 350, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iv extends g {
        iv() {
            super(com.tencent.mm.plugin.appbrand.jsapi.pay.l.NAME, com.tencent.mm.plugin.appbrand.jsapi.pay.l.NAME, com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class gy extends g {
        gy() {
            super(com.tencent.mm.plugin.appbrand.jsapi.pay.e.NAME, com.tencent.mm.plugin.appbrand.jsapi.pay.e.NAME, 359, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class iu extends g {
        iu() {
            super(com.tencent.mm.plugin.appbrand.jsapi.pay.h.NAME, com.tencent.mm.plugin.appbrand.jsapi.pay.h.NAME, v2helper.VOIP_ENC_HEIGHT_LV1, true);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cw extends g {
        cw() {
            super(com.tencent.mm.plugin.appbrand.jsapi.bh.NAME, com.tencent.mm.plugin.appbrand.jsapi.bh.NAME, 361, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bz extends g {
        bz() {
            super("getAdIdInfo", "getAdIdInfo", 375, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class eb extends g {
        eb() {
            super("handleVideoAction", "handleVideoAction", 371, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class dy extends g {
        dy() {
            super("handleDeviceInfo", "handleDeviceInfo", com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class t extends g {
        t() {
            super(com.tencent.mm.plugin.appbrand.jsapi.av.NAME, com.tencent.mm.plugin.appbrand.jsapi.av.NAME, 366, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ic extends g {
        ic() {
            super("qqMailLoginResult", "qqMailLoginResult", 357, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class fs extends g {
        fs() {
            super("onWebPageUrlExposed", "onWebPageUrlExposed", com.tencent.mm.plugin.appbrand.jsapi.b.c.CTRL_INDEX, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class hr extends g {
        hr() {
            super(com.tencent.mm.plugin.appbrand.jsapi.cj.NAME, com.tencent.mm.plugin.appbrand.jsapi.cj.NAME, 370, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class q extends g {
        q() {
            super(com.tencent.mm.plugin.appbrand.jsapi.as.NAME, com.tencent.mm.plugin.appbrand.jsapi.as.NAME, 377, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class p extends g {
        p() {
            super(com.tencent.mm.plugin.appbrand.jsapi.ar.NAME, com.tencent.mm.plugin.appbrand.jsapi.ar.NAME, 376, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cb extends g {
        cb() {
            super("requestBindPhoneNumber", "requestBindPhoneNumber", 387, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class bi extends g {
        bi() {
            super("doAuthCurrentUrl", "doAuthCurrentUrl", 397, false);
        }
    }
}
