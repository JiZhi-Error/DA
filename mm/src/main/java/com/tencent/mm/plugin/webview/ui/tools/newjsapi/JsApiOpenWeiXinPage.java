package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u000212B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\"\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u0018\u0010/\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "PAGE_ABOUT_VERSION", "", "PAGE_CHAT_BACKGROUND", "PAGE_CHAT_LOG", "PAGE_CHAT_LOG_MIGRATE", "PAGE_CONTACT_BLACK_LIST", "PAGE_DARK_MODE", "PAGE_FREEZE_ACCOUNT", "PAGE_GLOBAL_SEARCH", "PAGE_GROUPS", "PAGE_MASS_SEND", "PAGE_SET_PAT", "PAGE_TEXT_SIZE", "PAGE_WX_CHAT_TEAM", "PAGE_WX_SPORT", "TAG", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "goBlackList", "", "context", "Landroid/content/Context;", "goDarkMode", "goFreezeAccount", "goSystemNotice", "goToSetPatSuffix", "goWebView", "url", "showShare", "", "handleMsg", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handlePageUrl", "pageUrl", "startChattingUI", "userName", "startContactInfo", ch.COL_USERNAME, "OpenWeiXinPageData", "OpenWeiXinPageTask", "plugin-webview_release"})
public final class JsApiOpenWeiXinPage extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = CDJ;
    public static final JsApiOpenWeiXinPage JxC = new JsApiOpenWeiXinPage();
    private static final String edq = edq;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements d<IPCBoolean> {
        final /* synthetic */ f CDE;
        final /* synthetic */ n pGr;

        b(f fVar, n nVar) {
            this.CDE = fVar;
            this.pGr = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPCBoolean iPCBoolean) {
            AppMethodBeat.i(210646);
            if (iPCBoolean.value) {
                this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok", null);
                AppMethodBeat.o(210646);
                return;
            }
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":fail", null);
            AppMethodBeat.o(210646);
        }
    }

    static {
        AppMethodBeat.i(210649);
        AppMethodBeat.o(210649);
    }

    private JsApiOpenWeiXinPage() {
    }

    public static final /* synthetic */ boolean a(JsApiOpenWeiXinPage jsApiOpenWeiXinPage, String str) {
        AppMethodBeat.i(210650);
        boolean bbg = bbg(str);
        AppMethodBeat.o(210650);
        return bbg;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210647);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        String str = (String) nVar.params.get("pageUrl");
        Log.i("MicroMsg.JsApiOpenWeiXinPage", "OpenWeiXinPage:".concat(String.valueOf(str)));
        XIPCInvoker.a(MainProcessIPCService.dkO, new OpenWeiXinPageData(str), a.class, new b(fVar, nVar));
        AppMethodBeat.o(210647);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
    static final class a implements com.tencent.mm.ipcinvoker.b<OpenWeiXinPageData, IPCBoolean> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(OpenWeiXinPageData openWeiXinPageData, d<IPCBoolean> dVar) {
            String str;
            AppMethodBeat.i(210645);
            OpenWeiXinPageData openWeiXinPageData2 = openWeiXinPageData;
            if (dVar != null) {
                JsApiOpenWeiXinPage jsApiOpenWeiXinPage = JsApiOpenWeiXinPage.JxC;
                if (openWeiXinPageData2 != null) {
                    str = openWeiXinPageData2.pageUrl;
                } else {
                    str = null;
                }
                dVar.bn(new IPCBoolean(JsApiOpenWeiXinPage.a(jsApiOpenWeiXinPage, str)));
                AppMethodBeat.o(210645);
                return;
            }
            AppMethodBeat.o(210645);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "Landroid/os/Parcelable;", "pageUrl", "", "(Ljava/lang/String;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPageUrl", "()Ljava/lang/String;", "setPageUrl", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-webview_release"})
    static final class OpenWeiXinPageData implements Parcelable {
        public static final a CREATOR = new a((byte) 0);
        String pageUrl;

        static {
            AppMethodBeat.i(210644);
            AppMethodBeat.o(210644);
        }

        public OpenWeiXinPageData(String str) {
            this.pageUrl = str;
        }

        public OpenWeiXinPageData(Parcel parcel) {
            p.h(parcel, "src");
            AppMethodBeat.i(210643);
            String readString = parcel.readString();
            this.pageUrl = readString == null ? "" : readString;
            AppMethodBeat.o(210643);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(210642);
            p.h(parcel, "dest");
            parcel.writeString(this.pageUrl);
            AppMethodBeat.o(210642);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage$OpenWeiXinPageData;", "plugin-webview_release"})
        public static final class a implements Parcelable.Creator<OpenWeiXinPageData> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OpenWeiXinPageData createFromParcel(Parcel parcel) {
                AppMethodBeat.i(210641);
                p.h(parcel, "parcel");
                OpenWeiXinPageData openWeiXinPageData = new OpenWeiXinPageData(parcel);
                AppMethodBeat.o(210641);
                return openWeiXinPageData;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OpenWeiXinPageData[] newArray(int i2) {
                return new OpenWeiXinPageData[i2];
            }
        }
    }

    private static boolean bbg(String str) {
        boolean z;
        AppMethodBeat.i(210648);
        try {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            Uri parse = Uri.parse(str);
            p.g(parse, ShareConstants.MEDIA_URI);
            String scheme = parse.getScheme();
            String I = p.I(parse.getHost(), parse.getPath());
            Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl scheme:" + scheme + " pagePath:" + I);
            if (kotlin.n.n.I(I, "page/wesport", true)) {
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn("gh_43f2581f6fd6");
                if (Kn == null || !Kn.arv()) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", "gh_43f2581f6fd6");
                    c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                    z = true;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Chat_User", "gh_43f2581f6fd6");
                    intent2.putExtra("finish_direct", true);
                    intent2.putExtra("chat_from_scene", 5);
                    c.f(context, ".ui.chatting.ChattingUI", intent2);
                    z = true;
                }
            } else if (kotlin.n.n.I(I, "page/wechatteam", true)) {
                Intent intent3 = new Intent();
                intent3.putExtra("Chat_User", "weixin");
                intent3.putExtra("finish_direct", true);
                intent3.putExtra("specific_chat_from_scene", 3);
                intent3.putExtra("preChatTYPE", 9);
                intent3.putExtra("chat_from_scene", 5);
                c.f(context, ".ui.chatting.ChattingUI", intent3);
                z = true;
            } else if (kotlin.n.n.I(I, "page/masssend", true)) {
                if (z.aUD()) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("finish_direct", true);
                    c.b(context, "masssend", ".ui.MassSendHistoryUI", intent4);
                    z = true;
                } else {
                    c.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    z = true;
                }
            } else if (kotlin.n.n.I(I, "page/groups", true)) {
                Intent intent5 = new Intent();
                intent5.setClassName(context, "com.tencent.mm.ui.contact.ChatroomContactUI");
                intent5.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/textsize", true)) {
                Intent intent6 = new Intent();
                intent6.setClassName(context, "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                intent6.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent6);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/securitycenter", true)) {
                String value = h.aqJ().getValue("WeChatSafeCenterUrl");
                Log.i("MicroMsg.JsApiOpenWeiXinPage", "safe center url %s", value);
                if (Util.isNullOrNil(value)) {
                    value = context.getString(R.string.j1x) + LocaleUtil.getApplicationLanguage();
                }
                Intent intent7 = new Intent();
                intent7.putExtra("rawUrl", value);
                intent7.putExtra("showShare", true);
                intent7.putExtra("show_bottom", false);
                intent7.putExtra("needRedirect", false);
                intent7.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                intent7.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent7);
                z = true;
            } else if (kotlin.n.n.I(I, "page/contactblacklist", true)) {
                ah Kb = ai.Kb(context.getString(R.string.dvk));
                Intent intent8 = new Intent();
                p.g(Kb, "blackList");
                intent8.putExtra("filter_type", Kb.getType());
                intent8.putExtra("titile", context.getString(R.string.gt3));
                intent8.putExtra("list_attr", 32768);
                intent8.addFlags(268435456);
                intent8.setClassName(context, "com.tencent.mm.ui.contact.SelectSpecialContactUI");
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent8);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl3.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goBlackList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/darkmode", true)) {
                MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath()).putBoolean("dark_mode_red_dot", false);
                Intent intent9 = new Intent();
                intent9.setClassName(context, "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode");
                intent9.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent9);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl4.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goDarkMode", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/aboutversion", true)) {
                p.g(g.aAf(), "MMKernel.account()");
                int uin = com.tencent.mm.kernel.a.getUin();
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(12304);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(210648);
                    throw tVar;
                }
                String string = context.getString(R.string.gv4, Integer.valueOf(uin), Integer.valueOf(Util.nullAsNil((Integer) obj)));
                p.g(string, "context.getString(R.stri…otice_url, uin, newCount)");
                if (!kotlin.n.n.aL(string)) {
                    e aAh2 = g.aAh();
                    p.g(aAh2, "MMKernel.storage()");
                    aAh2.azQ().set(12304, (Object) 0);
                    Intent intent10 = new Intent();
                    intent10.putExtra("title", context.getString(R.string.gv3));
                    intent10.putExtra("rawUrl", string);
                    intent10.putExtra("showShare", false);
                    c.b(context, "webview", ".ui.tools.WebViewUI", intent10);
                }
                z = true;
            } else if (kotlin.n.n.I(I, "page/globalsearch", true)) {
                com.tencent.mm.plugin.fts.a.d.b(context, ".ui.FTSMainUI", new Intent(), null);
                z = true;
            } else if (kotlin.n.n.I(I, "page/chatlogmigrate", true)) {
                Intent intent11 = new Intent();
                intent11.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                MMWizardActivity.ay(context, intent11);
                z = true;
            } else if (kotlin.n.n.I(I, "page/chatlog", true)) {
                Intent className = new Intent().setClassName(context, "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI");
                p.g(className, "Intent().setClassName(co…ackupChooseBackupModeUI\")");
                className.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(className);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl5.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl5.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/chatbackground", true)) {
                Intent intent12 = new Intent();
                intent12.setClassName(context, "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI");
                intent12.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl6 = new com.tencent.mm.hellhoundlib.b.a().bl(intent12);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl6.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl6.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "handlePageUrl", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else if (kotlin.n.n.I(I, "page/setpat", true)) {
                Intent intent13 = new Intent();
                intent13.setClassName(context, "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyPatSuffixUI");
                intent13.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl7 = new com.tencent.mm.hellhoundlib.b.a().bl(intent13);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl7.axQ(), "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl7.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOpenWeiXinPage", "goToSetPatSuffix", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                z = true;
            } else {
                Log.i("MicroMsg.JsApiOpenWeiXinPage", "handlePageUrl not exist path");
                z = false;
            }
            AppMethodBeat.o(210648);
            return z;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.JsApiOpenWeiXinPage", th, "handlePageErr!!", new Object[0]);
            AppMethodBeat.o(210648);
            return false;
        }
    }
}
