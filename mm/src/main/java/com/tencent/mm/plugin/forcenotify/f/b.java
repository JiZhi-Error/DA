package com.tencent.mm.plugin.forcenotify.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.plugin.forcenotify.c.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nJ\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyUtil;", "", "()V", "TAG", "", "transformLiveItem", "", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "result", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "transformMsgItem", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "plugin-force-notify_release"})
public final class b {
    public static final b UWP = new b();

    static {
        AppMethodBeat.i(261879);
        AppMethodBeat.o(261879);
    }

    private b() {
    }

    public static void a(d dVar, kotlin.g.a.b<? super h, x> bVar) {
        String str;
        String str2;
        AppMethodBeat.i(261877);
        p.h(dVar, "info");
        p.h(bVar, "result");
        String str3 = dVar.field_ForcePushId;
        p.g(str3, "info.field_ForcePushId");
        if (n.nm(str3, "@miniapp")) {
            ((q) g.af(q.class)).a(dVar.field_UserName, new a(dVar, bVar));
            AppMethodBeat.o(261877);
            return;
        }
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(dVar.field_UserName);
        StringBuilder append = new StringBuilder("transformMsgItem, forcePushId:").append(dVar.field_ForcePushId).append(" username:").append(dVar.field_UserName).append(" nickname:");
        if (Kn == null || (str = Kn.arJ()) == null) {
            str = "";
        }
        Log.i("ForceNotifyUtil", append.append(str).toString());
        String str4 = dVar.field_ForcePushId;
        p.g(str4, "info.field_ForcePushId");
        String str5 = dVar.field_UserName;
        p.g(str5, "info.field_UserName");
        if (Kn == null || (str2 = Kn.arJ()) == null) {
            str2 = "";
        }
        String string = MMApplicationContext.getContext().getString(R.string.jd3);
        p.g(string, "MMApplicationContext.get…rce_notify_receive_a_msg)");
        bVar.invoke(new h(str4, str5, str2, string));
        AppMethodBeat.o(261877);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
    public static final class a implements q.a {
        final /* synthetic */ kotlin.g.a.b UWQ;
        final /* synthetic */ d wLM;

        a(d dVar, kotlin.g.a.b bVar) {
            this.wLM = dVar;
            this.UWQ = bVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.service.q.a
        public final void b(WxaAttributes wxaAttributes) {
            AppMethodBeat.i(261876);
            if (wxaAttributes == null) {
                AppMethodBeat.o(261876);
                return;
            }
            Log.i("ForceNotifyUtil", "transformMsgItem, forcePushId:" + this.wLM.field_ForcePushId + " username:" + this.wLM.field_UserName + " nickname:" + this.wLM.field_Description + " avatarUrl:" + wxaAttributes.field_brandIconURL);
            kotlin.g.a.b bVar = this.UWQ;
            String str = this.wLM.field_ForcePushId;
            p.g(str, "info.field_ForcePushId");
            String str2 = this.wLM.field_UserName;
            p.g(str2, "info.field_UserName");
            String str3 = this.wLM.field_Description;
            p.g(str3, "info.field_Description");
            String string = MMApplicationContext.getContext().getString(R.string.jd3);
            p.g(string, "MMApplicationContext.get…rce_notify_receive_a_msg)");
            bVar.invoke(new h(str, str2, str3, string, wxaAttributes.field_brandIconURL));
            AppMethodBeat.o(261876);
        }
    }

    public static void b(d dVar, kotlin.g.a.b<? super com.tencent.mm.plugin.forcenotify.c.g, x> bVar) {
        AppMethodBeat.i(261878);
        p.h(dVar, "info");
        p.h(bVar, "result");
        i iVar = new i(dVar.field_ExtInfo);
        String optString = iVar.optString("auth_icon_url", "");
        String optString2 = iVar.optString("nickname", "");
        Log.i("ForceNotifyUtil", "transformLiveItem, forcePushId:" + dVar.field_ForcePushId + " avatarUrl:" + dVar.field_UserIcon + " nickname:" + optString2 + " authIconUrl:" + optString);
        String str = dVar.field_ForcePushId;
        p.g(str, "info.field_ForcePushId");
        String str2 = dVar.field_UserIcon;
        p.g(str2, "info.field_UserIcon");
        p.g(optString2, "nickname");
        String string = MMApplicationContext.getContext().getString(R.string.jd4);
        p.g(string, "MMApplicationContext.get…notify_start_finder_live)");
        bVar.invoke(new com.tencent.mm.plugin.forcenotify.c.g(str, str2, optString2, string, optString));
        AppMethodBeat.o(261878);
    }
}
