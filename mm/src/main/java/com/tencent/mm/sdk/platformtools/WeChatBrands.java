package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.arch.a.c.a;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Looper;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pointers.PInt;
import java.util.ArrayList;
import java.util.List;

public class WeChatBrands {
    public static final String TAG = "MicroMsg.WeChatBrands";

    public interface IReplaceApply<I, O> {
        O apply(I i2, PInt pInt);

        void reload();
    }

    public static class UserInfo {
        public static final int kMMXAgreementId_MainlandOnWeixin = 1;
        public static final int kMMXAgreementId_Oversea = 2;
        public static final int kMMXAgreementId_UnSet = 0;
        public static final int kMMXAgreementId_WechatUS = 3;
        public static int xagreementId = 0;
    }

    public static void update(int i2) {
        AppMethodBeat.i(200969);
        if (i2 == 0) {
            i2 = AppInfo.current().getDefaultXAgreementId();
        }
        UserInfo.xagreementId = i2;
        updateEnableAutoSeparate();
        AppMethodBeat.o(200969);
    }

    public static void updateLang(String str) {
        AppMethodBeat.i(200970);
        AppInfo.lang = AppInfo.getBrandLang(str);
        updateEnableAutoSeparate();
        if (Wordings.handler.mReplacer != null) {
            Wordings.handler.mReplacer.reload();
        }
        AppMethodBeat.o(200970);
    }

    public static void updateReplacer(IReplaceApply<String, String> iReplaceApply) {
        AppMethodBeat.i(200971);
        Wordings.handler.attachReplacer(iReplaceApply);
        AppMethodBeat.o(200971);
    }

    private static void updateEnableAutoSeparate() {
        AppMethodBeat.i(200972);
        if (AppInfo.LANG_HK.equals(AppInfo.lang) || AppInfo.LANG_TW.equals(AppInfo.lang)) {
            boolean unused = Wordings.sEnableAutoSeparate = true;
            AppMethodBeat.o(200972);
            return;
        }
        boolean unused2 = Wordings.sEnableAutoSeparate = false;
        AppMethodBeat.o(200972);
    }

    public static void updateBizRestrictAlertSupplier(Business.AvailabilityAlertSupplier availabilityAlertSupplier) {
        Business.sAlertSupplier = availabilityAlertSupplier;
    }

    public static void updateBizRestrictHandler(a<Business.Entries, Boolean> aVar) {
        Business.sRestrictHanlder = aVar;
    }

    public static void updateBizRestrictAlertHandler(a<Business.Entries, Boolean> aVar) {
        Business.sAlertHandler = aVar;
    }

    public static class AppInfo {
        public static final String LANG_CN = "CN";
        public static final String LANG_EN = "EN";
        public static final String LANG_HK = "HK";
        public static final String LANG_TW = "TW";
        public static String lang = getBrandLang(LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));

        static {
            AppMethodBeat.i(200932);
            AppMethodBeat.o(200932);
        }

        public static boolean isSimplifiedChinese() {
            AppMethodBeat.i(200930);
            boolean equals = String.valueOf(lang).toUpperCase().equals(LANG_CN);
            AppMethodBeat.o(200930);
            return equals;
        }

        public static String getBrandLang(String str) {
            AppMethodBeat.i(200931);
            char c2 = 65535;
            switch (str.hashCode()) {
                case 3241:
                    if (str.equals(LocaleUtil.ENGLISH)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 115861276:
                    if (str.equals(LocaleUtil.CHINA)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 115861428:
                    if (str.equals(LocaleUtil.HONGKONG)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 115861812:
                    if (str.equals(LocaleUtil.TAIWAN)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    AppMethodBeat.o(200931);
                    return LANG_CN;
                case 1:
                    AppMethodBeat.o(200931);
                    return LANG_HK;
                case 2:
                    AppMethodBeat.o(200931);
                    return LANG_TW;
                default:
                    AppMethodBeat.o(200931);
                    return LANG_EN;
            }
        }

        public static WhichApp current() {
            return com.tencent.mm.cn.a.RwA;
        }

        public static final class WhichApp {
            private final int mDefaultXAgreementId;
            private final String mPackageName;
            private final String mUA;

            public final boolean isMainland() {
                return this.mDefaultXAgreementId == 0;
            }

            public final boolean isUS() {
                return this.mDefaultXAgreementId == 3;
            }

            public final String getPackageName() {
                return this.mPackageName;
            }

            public final String getUserAgent() {
                return this.mUA;
            }

            public final int getDefaultXAgreementId() {
                return this.mDefaultXAgreementId;
            }

            public WhichApp(String str, String str2, int i2) {
                this.mPackageName = str;
                this.mUA = str2;
                this.mDefaultXAgreementId = i2;
            }
        }
    }

    public static class Business {
        public static final String GROUP_ADS = "ads";
        public static final String GROUP_CHANNELS = "channels";
        public static final String GROUP_CROSS_DATA = "cross_data";
        public static final String GROUP_LIVE = "live";
        public static final String GROUP_MP = "mp";
        public static final String GROUP_OA = "oa";
        public static final String GROUP_OPEN = "open";
        public static final String GROUP_PAY = "pay";
        public static final String GROUP_SEARCH = "search";
        public static final String GROUP_SECONDARY = "secondary";
        public static final String GROUP_THIRD_PARTY = "third_party";
        public static final String GROUP_WECHAT_OUT = "wechat_out";
        public static final String GROUP_WECOM = "wecom";
        public static final int STATUS_O = 0;
        public static final int STATUS_R = 2;
        public static final int STATUS_X = 1;
        static a<Entries, Boolean> sAlertHandler = new a<Entries, Boolean>() {
            /* class com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* bridge */ /* synthetic */ Boolean apply(Entries entries) {
                AppMethodBeat.i(200936);
                Boolean apply = apply(entries);
                AppMethodBeat.o(200936);
                return apply;
            }

            public final Boolean apply(Entries entries) {
                AppMethodBeat.i(200935);
                Boolean valueOf = Boolean.valueOf(entries.signRequsted());
                AppMethodBeat.o(200935);
                return valueOf;
            }
        };
        static AvailabilityAlertSupplier sAlertSupplier = new AvailabilityAlertSupplier();
        static a<Entries, Boolean> sRestrictHanlder = new a<Entries, Boolean>() {
            /* class com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public final /* bridge */ /* synthetic */ Boolean apply(Entries entries) {
                AppMethodBeat.i(200934);
                Boolean apply = apply(entries);
                AppMethodBeat.o(200934);
                return apply;
            }

            public final Boolean apply(Entries entries) {
                AppMethodBeat.i(200933);
                Boolean valueOf = Boolean.valueOf(entries.restricted());
                AppMethodBeat.o(200933);
                return valueOf;
            }
        };

        public enum Entries {
            GlobalScan(Business.GROUP_PAY, 0),
            GlobalAppbrand(Business.GROUP_MP, 1),
            GlobalWeCom(Business.GROUP_WECOM, 1),
            Global3rdSrv(2),
            HomeMorePayment(Business.GROUP_PAY, 1),
            HomeMoreFeedback(2),
            HomeAppbrandDrawer(Business.GROUP_MP, 1),
            HomeNotifyMessage(Business.GROUP_OA, 1),
            HomeServiceOa(Business.GROUP_OA, 1),
            HomeServiceMp(Business.GROUP_OA, 1),
            HomePluginQQMail(Business.GROUP_THIRD_PARTY, 2),
            HomePluginSports(Business.GROUP_CROSS_DATA, 1),
            HomePluginWePay(Business.GROUP_PAY, 1),
            ContactNewFriendOa(Business.GROUP_OA, 1),
            ContactNewFriendWeWeCom(Business.GROUP_WECOM, 1),
            ContactOa(Business.GROUP_OA, 1),
            ContactWeCom(Business.GROUP_WECOM, 1),
            DiscoveryScanPayCode(Business.GROUP_PAY, 1),
            DiscoveryScanPayReward(Business.GROUP_PAY, 1),
            DiscoveryScanAppbrand(Business.GROUP_MP, 1),
            DiscoveryScanFace2Face(Business.GROUP_PAY, 1),
            DiscoveryScanRecognize(Business.GROUP_CROSS_DATA, 1),
            DiscoveryScanTranslate(Business.GROUP_CROSS_DATA, 1),
            DiscoveryScanSecondary(Business.GROUP_SECONDARY, 1),
            DiscoveryScanExtDevice(2),
            DiscoveryChannels(Business.GROUP_CHANNELS, 2),
            DiscoveryShake(Business.GROUP_CROSS_DATA, 1),
            DiscoveryLooks("search", 1),
            DiscoverySearch("search", 1),
            DiscoveryNearby(Business.GROUP_CROSS_DATA, 1),
            DiscoveryNearbyLiveFriends(Business.GROUP_CROSS_DATA, 1),
            DiscoveryShop(Business.GROUP_THIRD_PARTY, 1),
            DiscoveryGame(Business.GROUP_THIRD_PARTY, 1),
            DiscoveryAppbrand(Business.GROUP_MP, 1),
            DiscoveryWeChatOut(Business.GROUP_WECHAT_OUT, 1),
            MePayment(Business.GROUP_PAY, 1),
            MeCouponCard(Business.GROUP_PAY, 1),
            MeAvatarAddress(Business.GROUP_PAY, 1),
            MeAvatarInvoiceTitle(Business.GROUP_PAY, 1),
            MeAvatarWeChatId(2),
            MeStickerDeclare(2),
            MeSetSecurityVoicePrint(2),
            MeSetSecurityQQ(2),
            MeSetSecurityFacebook(2),
            MeSetSecurityApple(2),
            MeSetNewMsgChannels(Business.GROUP_CHANNELS, 2),
            MeSetPrivacyAddByQQ(2),
            MeSetPrivacyPermissions(Business.GROUP_OPEN, 1),
            MeSetAboutIntros(2),
            MeSetPlugin(2),
            MeSetDiscoveryChannels(0),
            MeSetDiscoveryShake(0),
            MeSetDiscoveryLooks(0),
            MeSetDiscoverySearch(0),
            MeSetDiscoveryNearby(0),
            MeSetDiscoveryNearbyLiveFriends(0),
            MeSetDiscoveryNearbyLiveFriendsPerson(0),
            MeSetDiscoveryShop(0),
            MeSetDiscoveryGame(0),
            MeSetDiscoveryAppbrand(0),
            MeSetDiscoveryWeChatOut(0),
            LoginRegistFacebook(2),
            LoginRegistApple(2),
            LoginFacebook(2),
            LoginApple(2),
            LoginQQ(2),
            LoginPasswordReset(0),
            ContextTranslate(Business.GROUP_CROSS_DATA, 1),
            ContextSearch("search", 1),
            SessionSpeech2TextSnd(Business.GROUP_CROSS_DATA, 1),
            SessionSpeech2TextRcv(Business.GROUP_CROSS_DATA, 1),
            SessionMusic(Business.GROUP_CROSS_DATA, 1),
            SessionLocation(Business.GROUP_CROSS_DATA, 1),
            SessionAppbrand(Business.GROUP_MP, 1),
            SessionOa(Business.GROUP_OA, 1),
            SessionLuckyMoney(Business.GROUP_PAY, 1),
            SessionPayment(Business.GROUP_PAY, 1),
            SessionCouponCard(Business.GROUP_PAY, 1),
            SessionGroupTools(Business.GROUP_MP, 1),
            SessionGroupSolitaire(Business.GROUP_MP, 0),
            SessionGroupLive(Business.GROUP_LIVE, 1),
            SessionChannels(Business.GROUP_CHANNELS, 2),
            SessionVoiceMsg(Business.GROUP_CROSS_DATA, 1),
            PaymentH5Jsb(Business.GROUP_PAY, 1),
            PaymentAppbrandJsb(Business.GROUP_PAY, 1),
            PaymentOpenSdk(Business.GROUP_PAY, 1),
            MomentChannels(Business.GROUP_CHANNELS, 2),
            MomentAds(Business.GROUP_ADS, 1),
            MomentApprand(Business.GROUP_MP, 1),
            Unknown("unknownKey", "unknownGroup", 2);
            
            public final String group;
            public final String identifier;
            public final int status;

            public static Entries valueOf(String str) {
                AppMethodBeat.i(200939);
                Entries entries = (Entries) Enum.valueOf(Entries.class, str);
                AppMethodBeat.o(200939);
                return entries;
            }

            static {
                AppMethodBeat.i(200950);
                AppMethodBeat.o(200950);
            }

            private Entries(int i2) {
                this.identifier = "";
                this.group = "";
                this.status = i2;
            }

            private Entries(String str, int i2) {
                this.identifier = "";
                this.group = str;
                this.status = i2;
            }

            private Entries(String str, String str2, int i2) {
                this.identifier = str;
                this.group = str2;
                this.status = i2;
            }

            public final boolean restricted() {
                AppMethodBeat.i(200940);
                boolean restricted = restricted(this.status);
                AppMethodBeat.o(200940);
                return restricted;
            }

            public final boolean signRequsted() {
                AppMethodBeat.i(200941);
                boolean signRequsted = signRequsted(this.status);
                AppMethodBeat.o(200941);
                return signRequsted;
            }

            public final boolean banned() {
                AppMethodBeat.i(200942);
                boolean banned = banned(this.status);
                AppMethodBeat.o(200942);
                return banned;
            }

            public final boolean checkAvailable(Context context) {
                AppMethodBeat.i(200943);
                boolean checkAvailable = checkAvailable(context, null);
                AppMethodBeat.o(200943);
                return checkAvailable;
            }

            public final boolean checkAvailable(Context context, c<Integer> cVar) {
                AppMethodBeat.i(200944);
                if (AppInfo.current().isMainland()) {
                    AppMethodBeat.o(200944);
                    return true;
                } else if (!Business.sRestrictHanlder.apply(this).booleanValue()) {
                    AppMethodBeat.o(200944);
                    return true;
                } else {
                    if (Business.sAlertHandler.apply(this).booleanValue()) {
                        showAlert(context, cVar);
                    }
                    AppMethodBeat.o(200944);
                    return false;
                }
            }

            public final boolean checkAvailableSlient(Context context, c<AvailabilityAlertSupplier> cVar) {
                AppMethodBeat.i(200945);
                if (AppInfo.current().isMainland()) {
                    AppMethodBeat.o(200945);
                    return true;
                } else if (!Business.sRestrictHanlder.apply(this).booleanValue()) {
                    AppMethodBeat.o(200945);
                    return true;
                } else {
                    if ((context instanceof Activity) && Business.sAlertHandler.apply(this).booleanValue() && cVar != null) {
                        cVar.accept(Business.sAlertSupplier);
                    }
                    AppMethodBeat.o(200945);
                    return false;
                }
            }

            public static boolean restricted(int i2) {
                boolean z = false;
                AppMethodBeat.i(200946);
                if (AppInfo.current().isMainland()) {
                    AppMethodBeat.o(200946);
                } else {
                    if (i2 != 0) {
                        z = true;
                    }
                    Log.i(WeChatBrands.TAG, "Business.Entry#isRestricted = ".concat(String.valueOf(z)));
                    AppMethodBeat.o(200946);
                }
                return z;
            }

            public static boolean signRequsted(int i2) {
                boolean z = true;
                AppMethodBeat.i(200947);
                if (AppInfo.current().isMainland()) {
                    AppMethodBeat.o(200947);
                    return false;
                }
                if (i2 != 1) {
                    z = false;
                }
                Log.i(WeChatBrands.TAG, "Business.Entry#signRequsted = ".concat(String.valueOf(z)));
                AppMethodBeat.o(200947);
                return z;
            }

            public static boolean banned(int i2) {
                boolean z = false;
                AppMethodBeat.i(200948);
                if (AppInfo.current().isMainland()) {
                    AppMethodBeat.o(200948);
                } else {
                    if (i2 == 2) {
                        z = true;
                    }
                    Log.i(WeChatBrands.TAG, "Business.Entry#isBanned = ".concat(String.valueOf(z)));
                    AppMethodBeat.o(200948);
                }
                return z;
            }

            public static void showAlert(final Context context, final c<Integer> cVar) {
                AppMethodBeat.i(200949);
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries.AnonymousClass1 */

                    public final void run() {
                        Object obj;
                        AppMethodBeat.i(200937);
                        if ((context instanceof Activity) || ((context instanceof ContextWrapper) && (((ContextWrapper) context).getBaseContext() instanceof Activity))) {
                            Business.sAlertSupplier.attach(cVar).showDialog(context);
                            AppMethodBeat.o(200937);
                            return;
                        }
                        StringBuilder sb = new StringBuilder("Business.Entry#showAlert error: the given context is not activty, context = ");
                        if (context == null) {
                            obj = BuildConfig.COMMAND;
                        } else {
                            obj = context.getClass();
                        }
                        Log.i(WeChatBrands.TAG, sb.append(obj).toString());
                        AppMethodBeat.o(200937);
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    r0.run();
                    AppMethodBeat.o(200949);
                    return;
                }
                h.RTc.aV(r0);
                AppMethodBeat.o(200949);
            }
        }

        static {
            AppMethodBeat.i(200951);
            AppMethodBeat.o(200951);
        }

        public static class AvailabilityAlertSupplier {
            public static final int ON_DISMISS = -1;
            public static final int ON_NO = 0;
            public static final int ON_YES = 1;
            protected String mBody;
            protected c<Integer> mCallback;
            protected String mNegativeBtnText;
            protected DialogInterface.OnClickListener mOnDismissListener;
            protected DialogInterface.OnClickListener mOnNegativeClickListener;
            protected DialogInterface.OnClickListener mOnPositiveClickListener;
            protected String mPositiveBtnText;
            protected String mTilte;

            public String getTilte() {
                return this.mTilte;
            }

            public AvailabilityAlertSupplier setTilte(String str) {
                this.mTilte = str;
                return this;
            }

            public String getBody() {
                return this.mBody;
            }

            public AvailabilityAlertSupplier setBody(String str) {
                this.mBody = str;
                return this;
            }

            public String getPositiveBtnText() {
                return this.mPositiveBtnText;
            }

            public AvailabilityAlertSupplier setPositiveBtnText(String str) {
                this.mPositiveBtnText = str;
                return this;
            }

            public String getNegativeBtnText() {
                return this.mNegativeBtnText;
            }

            public AvailabilityAlertSupplier setNegativeBtnText(String str) {
                this.mNegativeBtnText = str;
                return this;
            }

            public DialogInterface.OnClickListener getOnPositiveClickListener() {
                return this.mOnPositiveClickListener;
            }

            public AvailabilityAlertSupplier setOnPositiveClickListener(DialogInterface.OnClickListener onClickListener) {
                this.mOnPositiveClickListener = onClickListener;
                return this;
            }

            public DialogInterface.OnClickListener getOnNegativeClickListener() {
                return this.mOnNegativeClickListener;
            }

            public AvailabilityAlertSupplier setOnNegativeClickListener(DialogInterface.OnClickListener onClickListener) {
                this.mOnNegativeClickListener = onClickListener;
                return this;
            }

            public DialogInterface.OnClickListener getOnDismissListener() {
                return this.mOnDismissListener;
            }

            public AvailabilityAlertSupplier setOnDismissListener(DialogInterface.OnClickListener onClickListener) {
                this.mOnDismissListener = onClickListener;
                return this;
            }

            public c<Integer> getCallback() {
                return this.mCallback;
            }

            public AvailabilityAlertSupplier attach(c<Integer> cVar) {
                this.mCallback = cVar;
                return this;
            }

            public void showDialog(Context context) {
            }
        }
    }

    public static class Wordings {
        private static final char SYMBOL_LINEFEED = '\n';
        private static final char SYMBOL_SEPARATOR = ' ';
        private static final PlaceHolderHandler handler = new PlaceHolderHandler();
        private static boolean sEnableAutoSeparate = false;

        static /* synthetic */ boolean access$200(String str, String str2) {
            AppMethodBeat.i(200967);
            boolean shouldSeparate = shouldSeparate(str, str2);
            AppMethodBeat.o(200967);
            return shouldSeparate;
        }

        static {
            AppMethodBeat.i(200968);
            handler.attachJoiner(new a<List, String>() {
                /* class com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.a.c.a
                public final /* bridge */ /* synthetic */ String apply(List list) {
                    AppMethodBeat.i(200962);
                    String apply = apply(list);
                    AppMethodBeat.o(200962);
                    return apply;
                }

                public final String apply(List list) {
                    String str;
                    AppMethodBeat.i(200961);
                    StringBuilder sb = new StringBuilder();
                    int i2 = 0;
                    String str2 = null;
                    while (i2 < list.size()) {
                        Object obj = list.get(i2);
                        String obj2 = obj.toString();
                        if (TextUtils.isEmpty(obj2)) {
                            str = str2;
                        } else if (!(obj instanceof PlaceHolderHandler.PlaceHolderSpan) || !Wordings.sEnableAutoSeparate || ((PlaceHolderHandler.PlaceHolderSpan) obj).mIsDomainReplace) {
                            sb.append(obj2);
                            str = obj2;
                        } else {
                            if (!TextUtils.isEmpty(str2) && Wordings.access$200(str2, obj2)) {
                                sb.append(Wordings.SYMBOL_SEPARATOR);
                            }
                            sb.append(obj2);
                            if (i2 < list.size() - 1 && Wordings.access$200(obj2, list.get(i2 + 1).toString())) {
                                sb.append(Wordings.SYMBOL_SEPARATOR);
                            }
                            str = null;
                        }
                        i2++;
                        str2 = str;
                    }
                    String sb2 = sb.toString();
                    AppMethodBeat.o(200961);
                    return sb2;
                }
            });
            AppMethodBeat.o(200968);
        }

        public static String translate(String str) {
            AppMethodBeat.i(200963);
            String replace = handler.replace(str);
            AppMethodBeat.o(200963);
            return replace;
        }

        private static boolean shouldSeparate(String str, String str2) {
            AppMethodBeat.i(200964);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                AppMethodBeat.o(200964);
                return false;
            }
            char charAt = str.charAt(str.length() - 1);
            char charAt2 = str2.charAt(0);
            if (charAt == ' ' || charAt2 == ' ' || charAt == '\n' || charAt2 == '\n') {
                AppMethodBeat.o(200964);
                return false;
            } else if (isChineseMarks(charAt) || isChineseMarks(charAt2)) {
                AppMethodBeat.o(200964);
                return false;
            } else if (notSeparateChar(charAt) || notSeparateChar(charAt2)) {
                AppMethodBeat.o(200964);
                return false;
            } else if (isEnMarks(charAt2)) {
                AppMethodBeat.o(200964);
                return false;
            } else if (isEnMarks(charAt)) {
                AppMethodBeat.o(200964);
                return true;
            } else if (isAlphabet(charAt) || Character.isDigit(charAt)) {
                if (isLeftLinefeed(str)) {
                    AppMethodBeat.o(200964);
                    return false;
                } else if (!isLeftXmlFormat(str) || isAlphabet(charAt2)) {
                    AppMethodBeat.o(200964);
                    return true;
                } else {
                    AppMethodBeat.o(200964);
                    return false;
                }
            } else if (isAlphabet(charAt2) || Character.isDigit(charAt2)) {
                AppMethodBeat.o(200964);
                return true;
            } else {
                AppMethodBeat.o(200964);
                return false;
            }
        }

        private static boolean isLeftLinefeed(String str) {
            AppMethodBeat.i(200965);
            if (str.charAt(str.length() - 1) == 'n' && str.length() > 1 && str.charAt(str.length() - 2) == '\\') {
                AppMethodBeat.o(200965);
                return true;
            }
            AppMethodBeat.o(200965);
            return false;
        }

        private static boolean isLeftXmlFormat(String str) {
            AppMethodBeat.i(200966);
            if (str.charAt(str.length() - 1) == 's' && str.length() > 1 && str.charAt(str.length() - 2) == '%') {
                AppMethodBeat.o(200966);
                return true;
            }
            AppMethodBeat.o(200966);
            return false;
        }

        private static boolean isAlphabet(char c2) {
            return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z');
        }

        private static boolean isChineseMarks(char c2) {
            return c2 == 65292 || c2 == 12290 || c2 == 65281 || c2 == 65311 || c2 == 65306 || c2 == 65307 || c2 == 12289 || c2 == 12300 || c2 == 12301;
        }

        private static boolean notSeparateChar(char c2) {
            return c2 == '-' || c2 == '/' || c2 == '\\';
        }

        private static boolean isEnMarks(char c2) {
            return c2 == '.' || c2 == ',' || c2 == '?' || c2 == '!' || c2 == ';' || c2 == ':';
        }
    }

    public static class PlaceHolderHandler {
        private static final String SYMBOL_END = "}";
        private static final int SYMBOL_END_LEN = 1;
        private static final String SYMBOL_STR = "${";
        private static final int SYMBOL_STR_LEN = 2;
        a<List, String> mJoiner = new a<List, String>() {
            /* class com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.arch.a.c.a
            public /* bridge */ /* synthetic */ String apply(List list) {
                AppMethodBeat.i(200954);
                String apply = apply(list);
                AppMethodBeat.o(200954);
                return apply;
            }

            public String apply(List list) {
                AppMethodBeat.i(200953);
                StringBuilder sb = new StringBuilder();
                for (Object obj : list) {
                    sb.append(obj.toString());
                }
                String sb2 = sb.toString();
                AppMethodBeat.o(200953);
                return sb2;
            }
        };
        IReplaceApply<String, String> mReplacer = new IReplaceApply<String, String>() {
            /* class com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.pointers.PInt] */
            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply
            public /* bridge */ /* synthetic */ String apply(String str, PInt pInt) {
                AppMethodBeat.i(200952);
                String apply = apply(str, pInt);
                AppMethodBeat.o(200952);
                return apply;
            }

            public String apply(String str, PInt pInt) {
                return str;
            }

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.IReplaceApply
            public void reload() {
            }
        };

        public PlaceHolderHandler() {
            AppMethodBeat.i(200957);
            AppMethodBeat.o(200957);
        }

        public PlaceHolderHandler attachReplacer(IReplaceApply<String, String> iReplaceApply) {
            this.mReplacer = iReplaceApply;
            return this;
        }

        public PlaceHolderHandler attachJoiner(a<List, String> aVar) {
            this.mJoiner = aVar;
            return this;
        }

        public String replace(String str) {
            AppMethodBeat.i(200958);
            if (str == null) {
                AppMethodBeat.o(200958);
                return null;
            } else if (str.length() == 0) {
                AppMethodBeat.o(200958);
                return "";
            } else {
                Object computePlaceHolders = computePlaceHolders(str, this.mReplacer);
                if (computePlaceHolders instanceof String) {
                    String str2 = (String) computePlaceHolders;
                    AppMethodBeat.o(200958);
                    return str2;
                }
                String apply = this.mJoiner.apply((List) computePlaceHolders);
                AppMethodBeat.o(200958);
                return apply;
            }
        }

        private static Object computePlaceHolders(String str, IReplaceApply<String, String> iReplaceApply) {
            Object obj;
            AppMethodBeat.i(200959);
            try {
                Object iterateComputingPlaceHolders = iterateComputingPlaceHolders(str, iReplaceApply);
                AppMethodBeat.o(200959);
                obj = iterateComputingPlaceHolders;
            } catch (Throwable th) {
                Log.printErrStackTrace(WeChatBrands.TAG, th, "compute place holders error: " + th.getMessage() + ", input = " + str, new Object[0]);
                AppMethodBeat.o(200959);
                obj = str;
            }
            return obj;
        }

        private static Object iterateComputingPlaceHolders(String str, IReplaceApply<String, String> iReplaceApply) {
            AppMethodBeat.i(200960);
            int indexOf = str.indexOf(SYMBOL_STR);
            if (indexOf < 0) {
                AppMethodBeat.o(200960);
                return str;
            }
            ArrayList arrayList = new ArrayList(5);
            while (true) {
                if (indexOf > 0) {
                    arrayList.add(str.substring(0, indexOf));
                    str = str.substring(indexOf);
                    indexOf = str.indexOf(SYMBOL_STR);
                } else if (indexOf < 0) {
                    arrayList.add(str);
                    AppMethodBeat.o(200960);
                    return arrayList;
                } else {
                    int indexOf2 = str.indexOf(SYMBOL_END);
                    if (indexOf2 < 0 || SYMBOL_STR_LEN + indexOf >= str.length() - 1) {
                        arrayList.add(str);
                        AppMethodBeat.o(200960);
                    } else if (SYMBOL_STR_LEN + indexOf == indexOf2) {
                        arrayList.add(str.substring(indexOf, indexOf2 + 1));
                        str = str.substring(indexOf2 + 1);
                        indexOf = str.indexOf(SYMBOL_STR);
                    } else {
                        PlaceHolderSpan placeHolderSpan = new PlaceHolderSpan(str.substring(indexOf + SYMBOL_STR_LEN, indexOf2));
                        placeHolderSpan.attach(iReplaceApply);
                        arrayList.add(placeHolderSpan);
                        if (indexOf2 == str.length() - SYMBOL_END_LEN) {
                            AppMethodBeat.o(200960);
                            return arrayList;
                        }
                        str = str.substring(SYMBOL_END_LEN + indexOf2);
                        indexOf = str.indexOf(SYMBOL_STR);
                    }
                }
            }
            arrayList.add(str);
            AppMethodBeat.o(200960);
            return arrayList;
        }

        public static class StringSpan {
            protected final String mText;

            public StringSpan(String str) {
                this.mText = str;
            }

            public boolean isReplaceable() {
                return false;
            }

            public String toString() {
                AppMethodBeat.i(200956);
                String valueOf = String.valueOf(this.mText);
                AppMethodBeat.o(200956);
                return valueOf;
            }
        }

        public static class PlaceHolderSpan extends StringSpan {
            public static final int BrandReplacement = 0;
            public static final int DomainReplacement = 1;
            boolean mIsDomainReplace;
            IReplaceApply<String, String> mReplacer;

            public PlaceHolderSpan(String str) {
                super(str);
            }

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.StringSpan
            public boolean isReplaceable() {
                return true;
            }

            public PlaceHolderSpan attach(IReplaceApply<String, String> iReplaceApply) {
                this.mReplacer = iReplaceApply;
                return this;
            }

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.PlaceHolderHandler.StringSpan
            public String toString() {
                boolean z = true;
                AppMethodBeat.i(200955);
                if (this.mReplacer == null) {
                    String valueOf = String.valueOf(this.mText);
                    AppMethodBeat.o(200955);
                    return valueOf;
                }
                PInt pInt = new PInt();
                String apply = this.mReplacer.apply(this.mText, pInt);
                if (pInt.value != 1) {
                    z = false;
                }
                this.mIsDomainReplace = z;
                AppMethodBeat.o(200955);
                return apply;
            }
        }
    }
}
