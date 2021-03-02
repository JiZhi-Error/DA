package com.tencent.mm.plugin.sns.storage;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Keep
public class ADXml {
    public static final int AD_CONTENT_STYLE_CARD = 1;
    public static final int AD_CONTENT_STYLE_FINDER_TOPIC_CARD = 5;
    public static final int AD_CONTENT_STYLE_FULL_CARD = 3;
    public static final int AD_CONTENT_STYLE_LINK = 2;
    public static final int AD_CONTENT_STYLE_SPHERE_CARD = 4;
    public static final int AD_FULL_CARD_MEDIA_SIZE_W1_H1 = 1;
    public static final int AD_FULL_CARD_MEDIA_SIZE_W4_H3 = 0;
    public static final int AD_FULL_CARD_TITLE_LEFT_BOTTOM = 1;
    public static final int AD_FULL_CARD_TITLE_LEFT_TOP = 0;
    public static final int AD_MEDIA_DISPLAY_CENTER = 1;
    public static final int AD_MEDIA_DISPLAY_LEFT = 0;
    public static final int AD_MEDIA_DISPLAY_RIGHT = 2;
    public static final int AD_TURN_CARD_ANIMATION_TIME = 374;
    public static final String PRE_KEY_AD_ARGS = ".adxml.adArgs.arg";
    public static final String PRE_KEY_CARD_TAG_LIST = ".adxml.adCardInfo.adRatingCardInfo.tagList.tag";
    public static final String SUFF_KEY_CARD_TAG_BACKGROUND_DARK_MODE_COLOR = ".$tag_dark_bg_color";
    public static final String SUFF_KEY_CARD_TAG_BACKGROUND_LIGHT_MODE_COLOR = ".$tag_light_bg_color";
    public static final String SUFF_KEY_CARD_TAG_CONTENT_DARK_MODE_COLOR = ".$tag_dark_name_color";
    public static final String SUFF_KEY_CARD_TAG_CONTENT_LIGHT_MODE_COLOR = ".$tag_light_name_color";
    public static final String SUFF_KEY_CARD_TAG_ICON_DARK_MODE_URL = ".$dark_mode_url";
    public static final String SUFF_KEY_CARD_TAG_ICON_LIGHT_MODE_URL = ".$light_mode_url";
    public static final String TAG = "MicroMsg.ADXml";
    public String adActionLink;
    public int adActionLinkHidden = 0;
    public String adActionLinkIcon = "";
    public String adActionLinkName = "";
    public String adActionLinkTitle_cn = "";
    public String adActionLinkTitle_en = "";
    public String adActionLinkTitle_tw = "";
    public String adActionTitle;
    public Map<String, String> adArgs = new HashMap();
    public com.tencent.mm.plugin.sns.ad.a.a adAvatarFinderTopicInfo;
    public int adBasicRemWidth;
    public int adBasicRootFontSize;
    public int adBtnDisplayType;
    public String adCard3dHeadTitle;
    public String adCard3dHeadUrl;
    @Keep
    public AdCardActionBtnInfo adCardActionBtnInfo;
    public String adCardDesc;
    public c adCardTagInfo;
    public String adCardTitle;
    public int adContentDisplayType;
    public int adContentStyle;
    public com.tencent.mm.plugin.sns.ad.a.b adDynamicUpdateInfo;
    public String adExtInfo;
    public e adFeedbackInfo;
    public a adFinderInfo;
    public com.tencent.mm.plugin.sns.ad.a.c adFinderLiveInfo;
    public com.tencent.mm.plugin.sns.ad.a.d adFinderTopicInfo;
    public n adFloatWebViewInfo;
    public g adFullCardInfo;
    public com.tencent.mm.plugin.sns.ad.a.f adHeadFinderProfile;
    public com.tencent.mm.plugin.sns.ad.a.g adLiveInfo;
    public float adMediaDisplayHeight;
    public int adMediaDisplayMode;
    public float adMediaDisplayWidth;
    public float adMediaIconHeight;
    public float adMediaIconPaddingBottom;
    public float adMediaIconPaddingRight;
    public String adMediaIconUrl;
    public float adMediaIconWidth;
    public com.tencent.mm.plugin.sns.ad.a.h adPromotionInfo;
    public b adScanJumpInfo;
    private h adSelectInfo;
    public i adSphereCardInfo;
    public j adTurnInfo;
    public k adTwistInfo;
    public int adType;
    public boolean adVideoContinuePlay = false;
    public l adVoteInfo;
    public int addPlayIconOnCover;
    public Intent appMarketIntent;
    public int attachShareLinkIsHidden = 0;
    public String attachShareLinkUrl = "";
    public String attachShareLinkWording = "";
    boolean bLandingPagesAd;
    boolean bTurnLandingPagesAd;
    public int clientMaxVersion;
    public int clientMinVersion;
    public String compatibleUrl;
    public String expandInsideTitle_cn = "";
    public String expandInsideTitle_en = "";
    public String expandInsideTitle_tw = "";
    public String expandOutsideTitle_cn = "";
    public String expandOutsideTitle_en = "";
    public String expandOutsideTitle_tw = "";
    public String firstDownloadApkPkgName;
    public boolean forbiddenCustomAnimation = false;
    public String headClickParam = "";
    public int headClickRightBarShow = 0;
    public int headClickType = 0;
    public int isValidJumpCanvas = -1;
    public int newFeedbackPanel = 0;
    @Keep
    public String nickname;
    public long originSnsId;
    public String preferAvatar;
    public String preferNickName;
    public boolean preloadWeAppPkg = false;
    public int recExpId;
    public int recSrc;
    public int recType;
    public int toAdMarket = 0;
    public boolean usePreferedInfo;
    public int verticalVideoDisplayType = 0;
    public int videoPlayInStreamingMode = 0;
    public q weAppInfo;
    public int webrightBar = 0;
    public String xml = "";

    public static class a {
        public String DrX;
        public String finderUsername;
        public String objectNonceId;
    }

    public static class d {
        public String DWn;
        public String DWo;
        public String DWp;
        public String DWq;
        public String DWr;
        public String DWs;
        public String DWt;
    }

    public static class f {
        public String DQp = "";
        public String DWu = "";
        public String DWv = "";
        public String url = "";
    }

    public static class g {
        public String DWA;
        public int DWB;
        public String DWC;
        public int DWD;
        public aw DWE;
        public p DWF;
        public int DWw;
        public int DWx = 30;
        public int DWy;
        public a DWz;
        public String description;
        public String title;

        public static class a {
            public float DWG;
            public String DWH;
            public int color;
            public long endTime;
            public long startTime;
        }
    }

    public static class i {
        public int DWK;
        public String DWL;
        public String DWM;
        public String DWN;
        public String DWO;
        public int DWw;
        public int DWx = 30;
        public int DWy;
        public String description;
        public String title;
    }

    public static class o {
        public int DWw = 0;
        public String desc;
        public String title;
    }

    public static class p {
        public int DXc;
        public int DXd;
        public int DXe;
        public String DXf;
        public int DXg;
    }

    public static class q {
        public String appUserName;
        public String appVersion;
        public String dCx;
        public int weAppType;
    }

    public ADXml(String str) {
        AppMethodBeat.i(96269);
        feed(str);
        AppMethodBeat.o(96269);
    }

    private void feed(String str) {
        AppMethodBeat.i(202822);
        if (Util.isNullOrNil(str) || !str.trim().startsWith("<RecXml")) {
            feedAdXml(str);
            AppMethodBeat.o(202822);
            return;
        }
        feedRecXml(str);
        AppMethodBeat.o(202822);
    }

    private void feedRecXml(String str) {
        AppMethodBeat.i(202823);
        Map<String, String> feedXml = feedXml(str, ".RecXml", "RecXml");
        if (feedXml != null && !feedXml.isEmpty()) {
            this.recType = Util.safeParseInt(feedXml.get(".RecXml.$type"));
            this.recSrc = Util.safeParseInt(feedXml.get(".RecXml.$source"));
            this.recExpId = Util.safeParseInt(feedXml.get(".RecXml.$expId"));
            this.originSnsId = r.aOw(feedXml.get(".RecXml.$expOriginSnsId"));
        }
        AppMethodBeat.o(202823);
    }

    private void feedAdXml(String str) {
        AppMethodBeat.i(202824);
        feedXml(str, "", com.tencent.mm.g.c.f.COL_ADXML);
        AppMethodBeat.o(202824);
    }

    private Map<String, String> feedXml(String str, String str2, String str3) {
        a aVar;
        q qVar;
        com.tencent.mm.plugin.sns.ad.a.h hVar;
        String str4;
        AppMethodBeat.i(96270);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str3)) {
            AppMethodBeat.o(96270);
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.xml = str;
        Log.i(TAG, "feed xml %s, keyPrefix %s, tag %s", str, str2, str3);
        Map<String, String> parseXml = XmlParser.parseXml(str, str3, null);
        if (parseXml == null) {
            AppMethodBeat.o(96270);
            return null;
        }
        this.adType = Util.safeParseInt(parseXml.get(str2 + ".adxml.adType"));
        this.adActionTitle = Util.nullAs(parseXml.get(str2 + ".adxml.adActionTitle"), "");
        this.adActionLink = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLink"), "");
        this.nickname = Util.nullAs(parseXml.get(str2 + ".adxml.nickname"), "");
        this.webrightBar = Util.safeParseInt(parseXml.get(str2 + ".adxml.webviewRightBarShow"));
        this.adActionLinkHidden = Util.safeParseInt(parseXml.get(str2 + ".adxml.adActionLinkHidden"));
        this.adActionLinkName = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLinkName"), "");
        this.adActionLinkIcon = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLinkIcon"), "");
        this.adActionLinkTitle_cn = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLinkTitle.zh"), "");
        this.adActionLinkTitle_tw = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLinkTitle.tw"), "");
        this.adActionLinkTitle_en = Util.nullAs(parseXml.get(str2 + ".adxml.adActionLinkTitle.en"), "");
        this.attachShareLinkWording = Util.nullAs(parseXml.get(str2 + ".adxml.attachShareLinkWording"), "");
        this.attachShareLinkUrl = Util.nullAs(parseXml.get(str2 + ".adxml.attachShareLinkUrl"), "");
        this.attachShareLinkIsHidden = Util.safeParseInt(parseXml.get(str2 + ".adxml.attachShareLinkIsHidden"));
        if (Util.isNullOrNil(this.attachShareLinkWording) || Util.isNullOrNil(this.attachShareLinkUrl)) {
            this.attachShareLinkIsHidden = 1;
        }
        this.expandOutsideTitle_cn = Util.nullAs(parseXml.get(str2 + ".adxml.expandOutsideTitle.zh"), "");
        this.expandOutsideTitle_tw = Util.nullAs(parseXml.get(str2 + ".adxml.expandOutsideTitle.tw"), "");
        this.expandOutsideTitle_en = Util.nullAs(parseXml.get(str2 + ".adxml.expandOutsideTitle.en"), "");
        this.expandInsideTitle_cn = Util.nullAs(parseXml.get(str2 + ".adxml.expandInsideTitle.zh"), "");
        this.expandInsideTitle_tw = Util.nullAs(parseXml.get(str2 + ".adxml.expandInsideTitle.tw"), "");
        this.expandInsideTitle_en = Util.nullAs(parseXml.get(str2 + ".adxml.expandInsideTitle.en"), "");
        this.headClickType = Util.safeParseInt(parseXml.get(str2 + ".adxml.headClickType"));
        this.headClickParam = Util.nullAs(parseXml.get(str2 + ".adxml.headClickParam"), "");
        this.headClickRightBarShow = Util.safeParseInt(parseXml.get(str2 + ".adxml.headClickRightBarShow"));
        this.toAdMarket = Util.safeParseInt(parseXml.get(str2 + ".adxml.toAdMarket"));
        this.newFeedbackPanel = Util.safeParseInt(parseXml.get(str2 + ".adxml.newFeedback"));
        this.videoPlayInStreamingMode = Util.safeParseInt(parseXml.get(str2 + ".adxml.videoPlayInStreamingMode"));
        int i2 = 0;
        while (true) {
            String str5 = str2 + PRE_KEY_AD_ARGS + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".key";
            String str6 = parseXml.get(str5);
            if (str6 == null) {
                break;
            }
            String str7 = str2 + PRE_KEY_AD_ARGS + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".value";
            String str8 = parseXml.get(str7);
            Log.i(TAG, "newKey " + str5 + " " + str6 + " newValue : " + str7 + " " + str8);
            this.adArgs.put(str6, str8);
            i2++;
        }
        this.bLandingPagesAd = parseXml.containsKey(str2 + ".adxml.adCanvasInfo");
        this.usePreferedInfo = Util.safeParseInt(parseXml.get(new StringBuilder().append(str2).append(".adxml.usePreferedInfo").toString())) == 1;
        this.preferNickName = Util.nullAsNil(parseXml.get(str2 + ".adxml.preferNickname"));
        this.preferAvatar = Util.nullAsNil(parseXml.get(str2 + ".adxml.preferAvatar"));
        this.adContentDisplayType = Util.safeParseInt(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.contentDisplayType"));
        this.adMediaDisplayMode = Util.safeParseInt(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayMode"));
        this.adMediaDisplayWidth = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayWidth"));
        this.adMediaDisplayHeight = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaDisplayHeight"));
        this.adBtnDisplayType = Util.safeParseInt(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.btnDisplayType"));
        this.adMediaIconUrl = Util.nullAs(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconUrl"), "");
        this.adBasicRemWidth = Util.safeParseInt(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.basicRemWidth"));
        this.adBasicRootFontSize = Util.safeParseInt(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.basicRootFontSize"));
        this.adMediaIconWidth = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconWidth"));
        this.adMediaIconHeight = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconHeight"));
        this.adMediaIconPaddingRight = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingRight"));
        this.adMediaIconPaddingBottom = (float) Util.safeParseDouble(parseXml.get(str2 + ".adxml.adFeedDisplayInfo.mediaIconPaddingBottom"));
        this.adContentStyle = Util.safeParseInt(parseXml.get(str2 + ".adxml.adContentStyle"));
        this.adCardTitle = Util.nullAs(parseXml.get(str2 + ".adxml.adCardInfo.title"), "");
        this.adCardDesc = Util.nullAs(parseXml.get(str2 + ".adxml.adCardInfo.description"), "");
        this.adCardTagInfo = new c().G(parseXml, str2);
        this.adCard3dHeadTitle = Util.nullAsNil(parseXml.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headTitle"));
        this.adCard3dHeadUrl = Util.nullAsNil(parseXml.get(str2 + ".adxml.adCardInfo.adRatingCardInfo.headUrl"));
        String nullAs = Util.nullAs(parseXml.get(str2 + ".adxml.adSelectInfo.leftBtnTitle"), "");
        String nullAs2 = Util.nullAs(parseXml.get(str2 + ".adxml.adSelectInfo.rightBtnTitle"), "");
        if (!TextUtils.isEmpty(nullAs) && !TextUtils.isEmpty(nullAs2)) {
            this.adSelectInfo = new h();
            this.adSelectInfo.Dse = nullAs;
            this.adSelectInfo.DWI = nullAs2;
        }
        String nullAs3 = Util.nullAs(parseXml.get(str2 + ".adxml.adVoteInfo.componentUrl"), "");
        if (!TextUtils.isEmpty(nullAs3)) {
            this.adVoteInfo = new l();
            this.adVoteInfo.DWX = nullAs3;
            this.adVoteInfo.DWY = Util.nullAs(parseXml.get(str2 + ".adxml.adVoteInfo.voteLabel"), "");
            String str9 = str2 + ".adxml.adVoteInfo.optionList.option";
            int i3 = 0;
            while (true) {
                if (i3 != 0) {
                    str4 = str9 + i3;
                } else {
                    str4 = str9;
                }
                if (TextUtils.isEmpty(Util.nullAs(parseXml.get(str4 + ".title"), ""))) {
                    break;
                }
                m mVar = new m();
                mVar.title = Util.nullAs(parseXml.get(str4 + ".title"), "");
                mVar.msN = Util.nullAs(parseXml.get(str4 + ".shareTitle"), "");
                mVar.xDQ = Util.nullAs(parseXml.get(str4 + ".shareDesc"), "");
                mVar.DXa = Util.nullAs(parseXml.get(str4 + ".shareThumb"), "");
                mVar.DXb = Util.nullAs(parseXml.get(str4 + ".selectedTitle"), "");
                mVar.id = Util.nullAs(parseXml.get(str4 + ".id"), "");
                this.adVoteInfo.DWZ.add(mVar);
                i3++;
            }
        }
        this.bTurnLandingPagesAd = parseXml.containsKey(str2 + ".adxml.adTurnCanvasInfo");
        this.adTurnInfo = new j();
        this.adTurnInfo.I(parseXml, str2);
        this.adFeedbackInfo = new e().H(parseXml, str2);
        if (this.adContentStyle == 3) {
            this.adFullCardInfo = new g();
            String str10 = str2 + ".adxml.adFullCardInfo";
            g gVar = this.adFullCardInfo;
            gVar.DWw = Util.safeParseInt(parseXml.get(str10 + ".displayType"));
            gVar.title = Util.nullAsNil(parseXml.get(str10 + ".title"));
            gVar.description = Util.nullAsNil(parseXml.get(str10 + ".description"));
            gVar.DWx = Util.getInt(parseXml.get(str10 + ".markMaxAlpha"), 30);
            gVar.DWy = Util.safeParseInt(parseXml.get(str10 + ".titlePosition"));
            gVar.DWA = Util.nullAsNil(parseXml.get(str10 + ".maskImg"));
            gVar.DWB = Util.safeParseInt(parseXml.get(str10 + ".maskImgDisappearTime"));
            gVar.DWC = Util.nullAsNil(parseXml.get(str10 + ".coverImg"));
            gVar.DWD = Util.safeParseInt(parseXml.get(str10 + ".coverImgAppearTime"));
            if (!Util.isNullOrNil(parseXml.get(str10 + ".adGestureInfo.points"))) {
                gVar.DWz = new g.a();
                gVar.DWz.color = -1;
                gVar.DWz.startTime = (long) Util.safeParseInt(parseXml.get(str10 + ".adGestureInfo.startTime"));
                gVar.DWz.endTime = (long) Util.safeParseInt(parseXml.get(str10 + ".adGestureInfo.endTime"));
                gVar.DWz.DWG = Util.safeParseFloat(parseXml.get(str10 + ".adGestureInfo.distance"));
                gVar.DWz.color = Color.parseColor(Util.nullAsNil(parseXml.get(str10 + ".adGestureInfo.color")));
                gVar.DWz.DWH = Util.nullAsNil(parseXml.get(str10 + ".adGestureInfo.points"));
            }
            String str11 = str10 + ".endCoverInfo";
            if (parseXml.containsKey(str11)) {
                gVar.DWE = new aw();
                gVar.DWE.title = Util.nullAsNil(parseXml.get(str11 + ".title"));
                gVar.DWE.desc = Util.nullAsNil(parseXml.get(str11 + ".description"));
                gVar.DWE.EwS = Util.nullAsNil(parseXml.get(str11 + ".actionTitle"));
                gVar.DWE.coverImgUrl = Util.nullAsNil(parseXml.get(str11 + ".ambientImageUrl"));
                gVar.DWE.EwR = Util.nullAsNil(parseXml.get(str11 + ".titleImageUrl"));
                gVar.DWE.duration = Util.safeParseInt(parseXml.get(str11 + ".endCoverEndTime"));
            }
            String str12 = str10 + ".adLongPressGestureInfo";
            if (parseXml.containsKey(str12)) {
                gVar.DWF = new p();
                gVar.DWF.DXc = Util.safeParseInt(parseXml.get(str12 + ".pressStartTime"));
                gVar.DWF.DXd = Util.safeParseInt(parseXml.get(str12 + ".pressEndTime"));
                gVar.DWF.DXe = Util.safeParseInt(parseXml.get(str12 + ".pressDuration"));
                gVar.DWF.DXf = Util.nullAsNil(parseXml.get(str12 + ".spriteImageUrl"));
                gVar.DWF.DXg = Util.safeParseInt(parseXml.get(str12 + ".spriteType"));
            }
        } else if (this.adContentStyle == 4) {
            this.adSphereCardInfo = new i();
            String str13 = str2 + ".adxml.adSphereCardInfo";
            i iVar = this.adSphereCardInfo;
            iVar.DWw = Util.safeParseInt(parseXml.get(str13 + ".displayType"));
            iVar.title = Util.nullAsNil(parseXml.get(str13 + ".title"));
            iVar.description = Util.nullAsNil(parseXml.get(str13 + ".description"));
            iVar.DWx = Util.getInt(parseXml.get(str13 + ".markMaxAlpha"), 30);
            iVar.DWy = Util.safeParseInt(parseXml.get(str13 + ".titlePosition"));
            iVar.DWK = Util.safeParseInt(parseXml.get(str13 + ".gestureDelayTime"));
            iVar.DWM = Util.nullAsNil(parseXml.get(str13 + ".sphereThumbUrl"));
            iVar.DWN = Util.nullAsNil(parseXml.get(str13 + ".bgColor"));
            iVar.DWO = Util.nullAsNil(parseXml.get(str13 + ".bgColorAlpha"));
            iVar.DWL = Util.nullAsNil(parseXml.get(str13 + ".sphereImageUrl"));
        }
        this.clientMinVersion = Util.safeParseInt(parseXml.get(str2 + ".adxml.compatible.clientVersion.androidMin"));
        this.clientMaxVersion = Util.safeParseInt(parseXml.get(str2 + ".adxml.compatible.clientVersion.androidMax"));
        this.compatibleUrl = Util.nullAsNil(parseXml.get(str2 + ".adxml.compatible.jumpUrl"));
        String str14 = str2 + ".adxml.adCardInfo.adCardButton";
        if (parseXml.containsKey(str14)) {
            this.adCardActionBtnInfo = new AdCardActionBtnInfo();
            this.adCardActionBtnInfo.parse(parseXml, str14);
            if (!TextUtils.isEmpty(this.adCardActionBtnInfo.downloadApkPkgName)) {
                this.firstDownloadApkPkgName = this.adCardActionBtnInfo.downloadApkPkgName;
                Log.i(TAG, "findDownloadApkPkgName, adCardActionBtnInfo.pkg=" + this.adCardActionBtnInfo.downloadApkPkgName);
            }
        }
        if (TextUtils.isEmpty(this.firstDownloadApkPkgName)) {
            findDownloadApkPkgName(parseXml);
        }
        this.adExtInfo = com.tencent.mm.plugin.sns.data.i.aNZ(parseXml.get(str2 + ".adxml.adExtInfo"));
        try {
            com.tencent.mm.plugin.sns.device.appstore.a b2 = com.tencent.mm.plugin.sns.device.appstore.a.b(MMApplicationContext.getContext(), parseXml);
            if (b2 != null) {
                this.appMarketIntent = b2.eZA();
            }
        } catch (Throwable th) {
        }
        this.adScanJumpInfo = b.F(parseXml, str2 + ".adxml.adScanInfo");
        this.adFloatWebViewInfo = n.K(parseXml, str2 + ".adxml.adCanvasInfo.globalComponentItems.componentItem");
        String str15 = str2 + ".adxml.adFinderInfo";
        String nullAsNil = Util.nullAsNil(parseXml.get(str15 + ".objectNonceId"));
        String nullAsNil2 = Util.nullAsNil(parseXml.get(str15 + ".finderUsername"));
        String nullAsNil3 = Util.nullAsNil(parseXml.get(str15 + ".exportId"));
        if (TextUtils.isEmpty(nullAsNil3) || TextUtils.isEmpty(nullAsNil) || TextUtils.isEmpty(nullAsNil2)) {
            aVar = null;
        } else {
            aVar = new a();
            aVar.objectNonceId = nullAsNil;
            aVar.finderUsername = nullAsNil2;
            aVar.DrX = nullAsNil3;
        }
        this.adFinderInfo = aVar;
        this.addPlayIconOnCover = Util.safeParseInt(parseXml.get(str2 + ".adxml.addPlayIconOnCover"));
        this.adTwistInfo = k.J(parseXml, str2 + ".adxml.adTwistInfo");
        this.verticalVideoDisplayType = Util.safeParseInt(parseXml.get(str2 + ".adxml.verticalVideoDisplayType"));
        String str16 = str2 + ".adxml.headWeAppInfo";
        String nullAsNil4 = Util.nullAsNil(parseXml.get(str16 + ".appUserName"));
        String nullAsNil5 = Util.nullAsNil(parseXml.get(str16 + ".relativePagePath"));
        String nullAsNil6 = Util.nullAsNil(parseXml.get(str16 + ".appVersion"));
        int safeParseInt = Util.safeParseInt(parseXml.get(str16 + ".miniProgramType"));
        if (!TextUtils.isEmpty(nullAsNil4)) {
            qVar = new q();
            qVar.appUserName = nullAsNil4;
            qVar.dCx = nullAsNil5;
            qVar.appVersion = nullAsNil6;
            qVar.weAppType = safeParseInt;
        } else {
            qVar = null;
        }
        this.weAppInfo = qVar;
        this.forbiddenCustomAnimation = Util.safeParseInt(parseXml.get(new StringBuilder().append(str2).append(".adxml.forbiddenCustomAnimation").toString())) == 1;
        String str17 = str2 + ".adxml.adCardInfo.promotionInfo";
        if (com.tencent.mm.plugin.sns.ad.i.c.isEmpty(parseXml)) {
            hVar = null;
        } else {
            String str18 = parseXml.get(str17 + ".endTime");
            long safeParseLong = Util.safeParseLong(str18);
            if (TextUtils.isEmpty(str18) || safeParseLong == 0) {
                hVar = null;
            } else {
                com.tencent.mm.plugin.sns.ad.a.h hVar2 = new com.tencent.mm.plugin.sns.ad.a.h();
                hVar2.endTime = safeParseLong * 1000;
                hVar2.startTime = Util.safeParseLong(parseXml.get(str17 + ".startTime")) * 1000;
                hVar2.lco = Util.nullAs(parseXml.get(str17 + ".barBgColor"), "");
                hVar2.Dsc = Util.nullAs(parseXml.get(str17 + ".barBgAlpha"), "");
                hVar2.Dsd = Util.safeParseInt(parseXml.get(str17 + ".leftTitleType"));
                hVar2.Dse = Util.nullAs(parseXml.get(str17 + ".leftTitle"), "");
                hVar2.Dsf = Util.nullAs(parseXml.get(str17 + ".rightTitle"), "");
                hVar = hVar2;
            }
        }
        this.adPromotionInfo = hVar;
        this.adLiveInfo = com.tencent.mm.plugin.sns.ad.a.g.B(parseXml, str2 + ".adxml.adLiveInfo");
        this.adFinderLiveInfo = com.tencent.mm.plugin.sns.ad.a.c.v(parseXml, str2 + ".adxml.adFinderLiveInfo");
        this.adHeadFinderProfile = com.tencent.mm.plugin.sns.ad.a.f.A(parseXml, str2 + ".adxml.headFinderProfile");
        this.adFinderTopicInfo = com.tencent.mm.plugin.sns.ad.a.d.w(parseXml, str2 + ".adxml.adFinderTopicInfo");
        this.adAvatarFinderTopicInfo = com.tencent.mm.plugin.sns.ad.a.a.s(parseXml, str2 + ".adxml.headFinderTopicInfo");
        this.preloadWeAppPkg = Util.safeParseInt(parseXml.get(new StringBuilder().append(str2).append(".adxml.preloadWeAppPkg").toString())) == 1;
        this.adVideoContinuePlay = Util.safeParseInt(parseXml.get(new StringBuilder().append(str2).append(".adxml.adVideoContinuePlay").toString())) == 1;
        this.adDynamicUpdateInfo = com.tencent.mm.plugin.sns.ad.a.b.t(parseXml, str2 + ".adxml.adDynamicUpdateInfo");
        AppMethodBeat.o(96270);
        return parseXml;
    }

    public boolean hasActionBtn() {
        return this.adCardActionBtnInfo != null && this.adCardActionBtnInfo.clickActionType >= 0;
    }

    public boolean isLandingPagesAd() {
        return this.bLandingPagesAd || this.bTurnLandingPagesAd;
    }

    public String getCardSelectLeftTitle() {
        AppMethodBeat.i(96271);
        if (hasSelectInfo()) {
            String str = this.adSelectInfo.Dse;
            AppMethodBeat.o(96271);
            return str;
        } else if (hasVoteInfo()) {
            String str2 = this.adVoteInfo.DWZ.get(0).title;
            AppMethodBeat.o(96271);
            return str2;
        } else {
            AppMethodBeat.o(96271);
            return "";
        }
    }

    public String getCardSelectRightTitle() {
        AppMethodBeat.i(96272);
        if (hasSelectInfo()) {
            String str = this.adSelectInfo.DWI;
            AppMethodBeat.o(96272);
            return str;
        } else if (hasVoteInfo()) {
            String str2 = this.adVoteInfo.DWZ.get(1).title;
            AppMethodBeat.o(96272);
            return str2;
        } else {
            AppMethodBeat.o(96272);
            return "";
        }
    }

    public String getAdVoteComponentUrl() {
        AppMethodBeat.i(96273);
        if (hasVoteInfo()) {
            String str = this.adVoteInfo.DWX;
            AppMethodBeat.o(96273);
            return str;
        }
        AppMethodBeat.o(96273);
        return "";
    }

    public boolean isLinkAd() {
        return this.adContentStyle == 2;
    }

    public boolean isCardAd() {
        return this.adContentStyle == 1;
    }

    public boolean isFullCardAd() {
        return this.adContentStyle == 3;
    }

    public boolean isSphereCardAd() {
        return this.adContentStyle == 4;
    }

    public boolean isFinderTopicCard() {
        return this.adContentStyle == 5;
    }

    public boolean isLongPressGestureAd() {
        AppMethodBeat.i(202825);
        if (!isFullCardAd() || this.adFullCardInfo == null || this.adFullCardInfo.DWF == null || this.adFullCardInfo.DWF.DXc <= 0 || this.adFullCardInfo.DWF.DXd <= this.adFullCardInfo.DWF.DXc) {
            AppMethodBeat.o(202825);
            return false;
        }
        AppMethodBeat.o(202825);
        return true;
    }

    public boolean hasSelectInfo() {
        return this.adSelectInfo != null;
    }

    public class h {
        public String DWI;
        public String Dse;

        public h() {
        }
    }

    public boolean isNewStyleVote() {
        AppMethodBeat.i(96274);
        if (this.adVoteInfo == null || this.adVoteInfo.DWZ.size() <= 1 || TextUtils.isEmpty(this.adVoteInfo.DWZ.get(0).id) || TextUtils.isEmpty(this.adVoteInfo.DWZ.get(1).id)) {
            AppMethodBeat.o(96274);
            return false;
        }
        AppMethodBeat.o(96274);
        return true;
    }

    public boolean hasVoteInfo() {
        AppMethodBeat.i(96275);
        if (this.adVoteInfo == null || this.adVoteInfo.DWZ.size() <= 1) {
            AppMethodBeat.o(96275);
            return false;
        }
        AppMethodBeat.o(96275);
        return true;
    }

    public class l {
        public String DWX = "";
        public String DWY = "";
        public ArrayList<m> DWZ = new ArrayList<>();

        public l() {
            AppMethodBeat.i(96266);
            AppMethodBeat.o(96266);
        }

        public final String YR(int i2) {
            AppMethodBeat.i(96267);
            if (i2 < 0 || i2 >= this.DWZ.size()) {
                AppMethodBeat.o(96267);
                return "";
            }
            String str = this.DWZ.get(i2).DXb;
            AppMethodBeat.o(96267);
            return str;
        }

        public final String YS(int i2) {
            AppMethodBeat.i(96268);
            if (i2 < 0 || i2 >= this.DWZ.size()) {
                AppMethodBeat.o(96268);
                return "";
            }
            String str = this.DWZ.get(i2).title;
            AppMethodBeat.o(96268);
            return str;
        }
    }

    public class m {
        public String DXa = "";
        public String DXb = "";
        public String id = "";
        public String msN = "";
        public String title = "";
        public String xDQ = "";

        public m() {
        }
    }

    public String getLeftCanvasInfo() {
        AppMethodBeat.i(96276);
        String str = this.xml;
        if (str.contains("<adCanvasInfoLeft>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoRight[^>]*>.*?</adCanvasInfoRight>", "").replaceAll("adCanvasInfoLeft", "adCanvasInfo");
        }
        AppMethodBeat.o(96276);
        return str;
    }

    public String getRightCanvasInfo() {
        AppMethodBeat.i(96277);
        String str = this.xml;
        if (str.contains("<adCanvasInfoRight>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("(?s)<adCanvasInfoLeft[^>]*>.*?</adCanvasInfoLeft>", "").replaceAll("adCanvasInfoRight", "adCanvasInfo");
        }
        AppMethodBeat.o(96277);
        return str;
    }

    public String getTurnCanvasInfo() {
        AppMethodBeat.i(96278);
        String str = this.xml;
        if (str.contains("<adTurnCanvasInfo>")) {
            str = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adTurnCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.o(96278);
        return str;
    }

    public String getGestureCanvasInfo() {
        String str;
        AppMethodBeat.i(96279);
        String str2 = this.xml;
        if (this.adFullCardInfo == null || !str2.contains("<adFullCardGestureCanvasInfo>")) {
            str = "";
        } else {
            str = str2.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");
        }
        AppMethodBeat.o(96279);
        return str;
    }

    public static String getGestureCanvasInfo(String str) {
        String str2;
        AppMethodBeat.i(202826);
        if (str.contains("<adFullCardGestureCanvasInfo>")) {
            str2 = str.replaceAll("(?s)<adCanvasInfo[^>]*>.*?</adCanvasInfo>", "").replaceAll("adFullCardGestureCanvasInfo", "adCanvasInfo");
        } else {
            str2 = "";
        }
        AppMethodBeat.o(202826);
        return str2;
    }

    public boolean isRecExpAd() {
        return this.recSrc == 2;
    }

    public boolean isNormalAd() {
        return this.recSrc == 0;
    }

    public static class j {
        public List<o> DWP = new ArrayList();
        public String adActionLink = "";
        public String appUserName;
        public String appVersion;
        public String dCx;

        public j() {
            AppMethodBeat.i(96264);
            AppMethodBeat.o(96264);
        }

        public final void I(Map<String, String> map, String str) {
            String str2;
            AppMethodBeat.i(96265);
            this.adActionLink = Util.nullAs(map.get(str + ".adxml.adTurnActionLink"), "");
            String str3 = map.get(str + ".adxml.adTurnActionExtWeApp.appUserName");
            if (!TextUtils.isEmpty(str3)) {
                this.appUserName = str3;
                this.appVersion = map.get(str + ".adxml.adTurnActionExtWeApp.appVersion");
                this.dCx = map.get(str + ".adxml.adTurnActionExtWeApp.relativePagePath");
            }
            String str4 = str + ".adxml.adTurnInfo.materialInfo";
            int i2 = 0;
            while (true) {
                if (i2 > 0) {
                    str2 = str4 + i2;
                } else {
                    str2 = str4;
                }
                if (map.get(str2 + ".displayType") == null || map.get(str2 + ".displayType").length() <= 0) {
                    AppMethodBeat.o(96265);
                } else {
                    o oVar = new o();
                    oVar.title = Util.nullAs(map.get(str2 + ".title"), "");
                    oVar.desc = Util.nullAs(map.get(str2 + ".desc"), "");
                    oVar.DWw = Util.safeParseInt(map.get(str2 + ".displayType"));
                    this.DWP.add(oVar);
                    i2++;
                }
            }
            AppMethodBeat.o(96265);
        }
    }

    public static class e {
        public List<f> list = new LinkedList();

        public e() {
            AppMethodBeat.i(96262);
            AppMethodBeat.o(96262);
        }

        public final e H(Map<String, String> map, String str) {
            String str2;
            AppMethodBeat.i(96263);
            String str3 = str + ".adxml.feedbackInfo.feedbackList.item";
            int i2 = 0;
            while (true) {
                if (i2 > 0) {
                    str2 = str3 + i2;
                } else {
                    str2 = str3;
                }
                String str4 = str2 + ".url";
                if (map.get(str4) == null || map.get(str4).length() <= 0) {
                    AppMethodBeat.o(96263);
                } else {
                    f fVar = new f();
                    fVar.url = Util.nullAs(map.get(str4), "");
                    fVar.DWu = Util.nullAs(map.get(str2 + ".Wording.zh"), "");
                    fVar.DQp = Util.nullAs(map.get(str2 + ".Wording.en"), "");
                    fVar.DWv = Util.nullAs(map.get(str2 + ".Wording.tw"), "");
                    if (fVar.DWu.length() + fVar.DQp.length() + fVar.DWv.length() > 0) {
                        this.list.add(fVar);
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(96263);
            return this;
        }
    }

    @Keep
    public static class AdCardActionBtnInfo {
        public String appId;
        public String appPageUrl;
        public String appType;
        public String brandDesc;
        public String brandHead;
        public String brandName;
        public String brandUsername;
        public String btnTitle;
        public String btnTitleAfterAddBrand;
        public String btnTitleAfterOrder;
        public String cardExt;
        public String cardTpId;
        public String clickActionLink;
        public int clickActionType;
        public String couponAppId;
        public String couponDesc;
        public String couponName;
        public String couponSenderName;
        public String couponSenderPhoto;
        public String couponStockId;
        public String downloadApkAppId;
        public String downloadApkPkgName;
        public String finderAvatar;
        public String finderEncryptedTopicId;
        public String finderExportId;
        public String finderLiveFeedExportId;
        public String finderLiveFeedNonceId;
        @Keep
        public String finderLiveId;
        public String finderLiveNoticeId;
        public String finderLiveTitle;
        public String finderNickName;
        public String finderObjectNonceId;
        public String finderTopicName;
        @Keep
        public String finderUsername;
        public String iconUrl;
        public String subscribeContent;
        public long subscribeExpiredTime;
        public String subscribeExpiredTip;
        public String subscribeFailedTip;
        public String subscribeHeadImg;
        public String subscribeNickname;
        public String subscribeSubmitBtnTitle;
        public String subscribeSucTip;
        public String subscribeTitle;
        public String tempId;
        public int weAppType;
        public String weappPath;
        public String weappUserName;
        public int weappVersion;

        public void parse(Map<String, String> map, String str) {
            AppMethodBeat.i(202815);
            this.iconUrl = Util.nullAsNil(map.get(str + ".iconUrl"));
            this.btnTitle = Util.nullAsNil(map.get(str + ".btnTitle"));
            this.clickActionType = Util.getInt(map.get(str + ".clickActionType"), 0);
            this.clickActionLink = Util.nullAsNil(map.get(str + ".clickActionLink"));
            this.weappUserName = Util.nullAsNil(map.get(str + ".weappUserName"));
            this.weappPath = Util.nullAsNil(map.get(str + ".weappPath"));
            this.weappVersion = Util.getInt(map.get(str + ".weappVersion"), 0);
            this.weAppType = Util.safeParseInt(map.get(str + ".miniProgramType"));
            this.tempId = Util.nullAsNil(map.get(str + ".tempId"));
            this.btnTitleAfterOrder = Util.nullAsNil(map.get(str + ".btnTitleAfterOrder"));
            this.subscribeTitle = Util.nullAsNil(map.get(str + ".subscribeTitle"));
            this.subscribeContent = Util.nullAsNil(map.get(str + ".subscribeContent"));
            this.subscribeSubmitBtnTitle = Util.nullAsNil(map.get(str + ".subscribeSubmitBtnTitle"));
            this.subscribeFailedTip = Util.nullAsNil(map.get(str + ".subscribeFailedTip"));
            this.subscribeSucTip = Util.nullAsNil(map.get(str + ".subscribeSucTip"));
            this.appType = Util.nullAsNil(map.get(str + ".appType"));
            this.appId = Util.nullAsNil(map.get(str + ".appId"));
            this.subscribeHeadImg = Util.nullAsNil(map.get(str + ".subscribeHeadImg"));
            this.subscribeNickname = Util.nullAsNil(map.get(str + ".subscribeNickname"));
            this.subscribeExpiredTime = r.aOw(map.get(str + ".subscribeExpiredTime"));
            this.subscribeExpiredTip = Util.nullAsNil(map.get(str + ".subscribeExpiredTip"));
            this.downloadApkAppId = Util.nullAsNil(map.get(str + ".openSdkAppId"));
            this.downloadApkPkgName = Util.nullAsNil(map.get(str + ".packageName"));
            this.appPageUrl = Util.nullAsNil(map.get(str + ".appPageUrlAndroid"));
            this.cardTpId = Util.nullAsNil(map.get(str + ".cardTpId"));
            this.cardExt = Util.nullAsNil(map.get(str + ".cardExt"));
            this.brandUsername = Util.nullAsNil(map.get(str + ".brandUsername"));
            this.brandHead = Util.nullAsNil(map.get(str + ".brandHead"));
            this.brandName = Util.nullAsNil(map.get(str + ".brandName"));
            this.brandDesc = Util.nullAsNil(map.get(str + ".brandDesc"));
            this.btnTitleAfterAddBrand = Util.nullAsNil(map.get(str + ".btnTitleAfterAddBrand"));
            this.couponAppId = Util.nullAsNil(map.get(str + ".couponAppId"));
            this.couponStockId = Util.nullAsNil(map.get(str + ".couponStockId"));
            this.couponSenderPhoto = Util.nullAsNil(map.get(str + ".couponSenderPhoto"));
            this.couponSenderName = Util.nullAsNil(map.get(str + ".couponSenderName"));
            this.couponName = Util.nullAsNil(map.get(str + ".couponName"));
            this.couponDesc = Util.nullAsNil(map.get(str + ".couponDesc"));
            this.finderUsername = Util.nullAsNil(map.get(str + ".finderUsername"));
            this.finderLiveNoticeId = Util.nullAsNil(map.get(str + ".finderLiveNoticeId"));
            this.finderAvatar = Util.nullAsNil(map.get(str + ".finderAvatar"));
            this.finderNickName = Util.nullAsNil(map.get(str + ".finderNickname"));
            this.finderLiveTitle = Util.nullAsNil(map.get(str + ".finderLiveTitle"));
            this.finderLiveId = Util.nullAsNil(map.get(str + ".finderLiveId"));
            this.finderLiveFeedExportId = Util.nullAsNil(map.get(str + ".finderLiveFeedExportId"));
            this.finderLiveFeedNonceId = Util.nullAsNil(map.get(str + ".finderLiveFeedNonceId"));
            this.finderEncryptedTopicId = Util.nullAsNil(map.get(str + ".finderEncryptedTopicId"));
            this.finderTopicName = Util.nullAsNil(map.get(str + ".finderTopicName"));
            this.finderObjectNonceId = Util.nullAsNil(map.get(str + ".finderObjectNonceId"));
            this.finderExportId = Util.nullAsNil(map.get(str + ".finderExportId"));
            AppMethodBeat.o(202815);
        }
    }

    public static class c {
        public List<d> DWm = new ArrayList();

        public c() {
            AppMethodBeat.i(202816);
            AppMethodBeat.o(202816);
        }

        public final c G(Map<String, String> map, String str) {
            AppMethodBeat.i(202817);
            int i2 = 0;
            while (true) {
                String str2 = str + ADXml.PRE_KEY_CARD_TAG_LIST + (i2 == 0 ? "" : Integer.valueOf(i2));
                if (map.containsKey(str2)) {
                    Log.i(ADXml.TAG, "card ad tag %s", map.get(str2));
                    if (!Util.isNullOrNil(map.get(str2))) {
                        d dVar = new d();
                        dVar.DWn = Util.nullAs(map.get(str2), "");
                        String str3 = str2 + ADXml.SUFF_KEY_CARD_TAG_ICON_LIGHT_MODE_URL;
                        String str4 = str2 + ADXml.SUFF_KEY_CARD_TAG_ICON_DARK_MODE_URL;
                        String str5 = str2 + ADXml.SUFF_KEY_CARD_TAG_BACKGROUND_LIGHT_MODE_COLOR;
                        String str6 = str2 + ADXml.SUFF_KEY_CARD_TAG_BACKGROUND_DARK_MODE_COLOR;
                        String str7 = str2 + ADXml.SUFF_KEY_CARD_TAG_CONTENT_LIGHT_MODE_COLOR;
                        dVar.DWo = Util.nullAs(map.get(str3), "");
                        dVar.DWp = Util.nullAs(map.get(str4), "");
                        dVar.DWq = Util.nullAsNil(map.get(str5));
                        dVar.DWr = Util.nullAsNil(map.get(str6));
                        dVar.DWs = Util.nullAsNil(map.get(str7));
                        dVar.DWt = Util.nullAsNil(map.get(str2 + ADXml.SUFF_KEY_CARD_TAG_CONTENT_DARK_MODE_COLOR));
                        Log.i(ADXml.TAG, "Tag content = ", dVar.DWn + ", Tag light iconUrl = " + dVar.DWo + ", Tag dark iconUrl = " + dVar.DWp + ", Tag background light color = " + dVar.DWq + ", Tag background dark color = " + dVar.DWr + ", Tag content light color = " + dVar.DWs + ", Tag content dark color = " + dVar.DWt);
                        this.DWm.add(dVar);
                    }
                    i2++;
                } else {
                    AppMethodBeat.o(202817);
                    return this;
                }
            }
        }
    }

    public void findDownloadApkPkgName(Map<String, String> map) {
        AppMethodBeat.i(202827);
        if (map == null || map.isEmpty()) {
            AppMethodBeat.o(202827);
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith(".pkg") || str.endsWith(".appPackage")) {
                String str2 = map.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    this.firstDownloadApkPkgName = str2;
                    Log.i(TAG, "findDownloadApkPkgName, key=" + str + ", pkg=" + str2);
                    AppMethodBeat.o(202827);
                    return;
                }
            }
        }
        AppMethodBeat.o(202827);
    }

    public static class b {
        public String DWj;
        public String DWk;
        public int DWl;
        public String desc;
        public String pSE;

        public static b F(Map<String, String> map, String str) {
            AppMethodBeat.i(202814);
            String nullAsNil = Util.nullAsNil(map.get(str + ".bgImage"));
            String nullAsNil2 = Util.nullAsNil(map.get(str + ".desc"));
            String nullAsNil3 = Util.nullAsNil(map.get(str + ".descIcon"));
            String nullAsNil4 = Util.nullAsNil(map.get(str + ".detectSucIcon"));
            int safeParseInt = Util.safeParseInt(map.get(str + ".scanGestureType"));
            if (TextUtils.isEmpty(nullAsNil) || TextUtils.isEmpty(nullAsNil3) || TextUtils.isEmpty(nullAsNil4) || safeParseInt <= 0) {
                AppMethodBeat.o(202814);
                return null;
            }
            b bVar = new b();
            bVar.DWj = nullAsNil;
            bVar.desc = nullAsNil2;
            bVar.pSE = nullAsNil3;
            bVar.DWk = nullAsNil4;
            bVar.DWl = safeParseInt;
            AppMethodBeat.o(202814);
            return bVar;
        }
    }

    public static class n {
        public String lDS;
        public int type;

        public static n K(Map<String, String> map, String str) {
            String str2;
            AppMethodBeat.i(202821);
            int i2 = 0;
            while (true) {
                if (i2 == 0) {
                    str2 = str;
                } else {
                    str2 = str + i2;
                }
                String str3 = map.get(str2 + ".type");
                if (!TextUtils.isEmpty(str3)) {
                    int safeParseInt = Util.safeParseInt(str3);
                    if (safeParseInt == 136) {
                        n nVar = new n();
                        nVar.type = safeParseInt;
                        nVar.lDS = map.get(str2 + ".webViewUrl");
                        AppMethodBeat.o(202821);
                        return nVar;
                    }
                    i2++;
                } else {
                    AppMethodBeat.o(202821);
                    return null;
                }
            }
        }
    }

    public boolean isShowPlayIconOnCover() {
        return this.addPlayIconOnCover == 1;
    }

    public static class k implements Serializable {
        public int DWQ;
        public int DWR;
        public int DWS;
        public int DWT;
        public int DWU;
        public boolean DWV;
        public boolean DWW;
        public String desc;
        public String title;

        public static k J(Map<String, String> map, String str) {
            int i2;
            int i3;
            boolean z = true;
            AppMethodBeat.i(202818);
            if (map.containsKey(str)) {
                int safeParseInt = Util.safeParseInt(map.get(str + ".twistStartTime"));
                int safeParseInt2 = Util.safeParseInt(map.get(str + ".twistEndTime"));
                int safeParseInt3 = Util.safeParseInt(map.get(str + ".twistDegree"));
                int safeParseInt4 = Util.safeParseInt(map.get(str + ".coverStartTime"));
                int safeParseInt5 = Util.safeParseInt(map.get(str + ".coverEndTime"));
                if (safeParseInt4 == 0) {
                    i2 = safeParseInt;
                } else {
                    i2 = safeParseInt4;
                }
                if (safeParseInt5 == 0) {
                    i3 = safeParseInt2;
                } else {
                    i3 = safeParseInt5;
                }
                if (safeParseInt >= 0 && safeParseInt2 > safeParseInt && i3 >= i2 && i2 >= safeParseInt && i3 <= safeParseInt2 && safeParseInt3 > 0) {
                    int safeParseInt6 = Util.safeParseInt(map.get(str + ".isClockwise"));
                    int safeParseInt7 = Util.safeParseInt(map.get(str + ".showSimpleTransition"));
                    String nullAsNil = Util.nullAsNil(map.get(str + ".title"));
                    String nullAsNil2 = Util.nullAsNil(map.get(str + ".desc"));
                    k kVar = new k();
                    kVar.DWQ = safeParseInt;
                    kVar.DWR = safeParseInt2;
                    kVar.DWS = i2;
                    kVar.DWT = i3;
                    kVar.DWU = safeParseInt3;
                    kVar.title = nullAsNil;
                    kVar.desc = nullAsNil2;
                    kVar.DWV = safeParseInt6 == 1;
                    if (safeParseInt7 != 1) {
                        z = false;
                    }
                    kVar.DWW = z;
                    AppMethodBeat.o(202818);
                    return kVar;
                }
            }
            AppMethodBeat.o(202818);
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(202819);
            String str = "{twistStartTime=" + this.DWQ + ", twistEndTime=" + this.DWR + ", coverStartTime=" + this.DWS + ", coverEndTime=" + this.DWT + ", maxDegree=" + this.DWU + ", isClockWise=" + this.DWV + ", title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + '}';
            AppMethodBeat.o(202819);
            return str;
        }

        public static boolean aPT(String str) {
            AppMethodBeat.i(202820);
            if (str == null || !str.contains("<isTwistAnimView>1</isTwistAnimView>")) {
                AppMethodBeat.o(202820);
                return false;
            }
            AppMethodBeat.o(202820);
            return true;
        }
    }
}
