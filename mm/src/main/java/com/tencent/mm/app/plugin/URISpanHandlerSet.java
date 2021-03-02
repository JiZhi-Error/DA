package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.ui.ManagerRoomByWeworkUI;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.tr;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.b.a.lh;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCheckWxaShortLinkUI;
import com.tencent.mm.plugin.box.a.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.egl;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;

/* access modifiers changed from: package-private */
public class URISpanHandlerSet {
    Context mContext = null;

    /* access modifiers changed from: package-private */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        PRIORITY Xq() default PRIORITY.NORMAL;
    }

    /* access modifiers changed from: package-private */
    public enum PRIORITY {
        LOW,
        NORMAL,
        HIGH;

        public static PRIORITY valueOf(String str) {
            AppMethodBeat.i(19725);
            PRIORITY priority = (PRIORITY) Enum.valueOf(PRIORITY.class, str);
            AppMethodBeat.o(19725);
            return priority;
        }

        static {
            AppMethodBeat.i(19726);
            AppMethodBeat.o(19726);
        }
    }

    public URISpanHandlerSet(Context context) {
        AppMethodBeat.i(19768);
        this.mContext = context == null ? MMApplicationContext.getContext() : this.mContext;
        AppMethodBeat.o(19768);
    }

    /* access modifiers changed from: package-private */
    public abstract class BaseUriSpanHandler {
        /* access modifiers changed from: package-private */
        public abstract int[] Xp();

        /* access modifiers changed from: package-private */
        public abstract boolean a(View view, u uVar, i iVar);

        /* access modifiers changed from: package-private */
        public abstract boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle);

        /* access modifiers changed from: package-private */
        public abstract u gx(String str);

        public BaseUriSpanHandler() {
        }
    }

    @a
    class StoryEntranceHandler extends BaseUriSpanHandler {
        StoryEntranceHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{48};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231453);
            if (uVar.type == 48) {
                String str = uVar.username;
                if (TextUtils.isEmpty(str)) {
                    AppMethodBeat.o(231453);
                    return false;
                }
                if (com.tencent.mm.plugin.sns.f.a.aOE(str)) {
                    o.bB(URISpanHandlerSet.this.mContext, str);
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231453);
                return true;
            }
            AppMethodBeat.o(231453);
            return false;
        }
    }

    @a
    class HttpUriSpanHandler extends BaseUriSpanHandler {
        private final String doh = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/newsubscribemsg?action=subscribepage");

        HttpUriSpanHandler() {
            super();
            AppMethodBeat.i(231434);
            AppMethodBeat.o(231434);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            u uVar;
            AppMethodBeat.i(19719);
            if (str.trim().toLowerCase().startsWith("http")) {
                uVar = new u(str, 1, null);
            } else {
                uVar = null;
            }
            AppMethodBeat.o(19719);
            return uVar;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{1};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0090  */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.view.View r11, com.tencent.mm.pluginsdk.ui.applet.u r12, com.tencent.mm.pluginsdk.ui.span.i r13) {
            /*
            // Method dump skipped, instructions count: 602
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.plugin.URISpanHandlerSet.HttpUriSpanHandler.a(android.view.View, com.tencent.mm.pluginsdk.ui.applet.u, com.tencent.mm.pluginsdk.ui.span.i):boolean");
        }
    }

    @a
    class FlightNumberSpanHandler extends BaseUriSpanHandler {
        FlightNumberSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{50};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            long j2;
            AppMethodBeat.i(231428);
            if (iVar != null) {
                iVar.a(uVar);
            }
            if (uVar.type == 50) {
                Log.i("MicroMsg.URISpanHandlerSet", "FlightNumberSpanHandler click %s", uVar.url);
                if (uVar.data == null || !(uVar.data instanceof Bundle)) {
                    j2 = 0;
                } else {
                    j2 = ((Bundle) uVar.data).getLong("msgSvrId");
                }
                ((c) g.af(c.class)).b(URISpanHandlerSet.this.mContext, uVar.url, j2);
            }
            if (iVar != null) {
                iVar.b(uVar);
            }
            AppMethodBeat.o(231428);
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class TopicSpanHandler extends BaseUriSpanHandler {
        TopicSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{58};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            com.tencent.mm.bw.a aVar;
            int i2;
            String str;
            String str2;
            String[] split;
            f eSr;
            AppMethodBeat.i(231455);
            if (uVar.type == 58) {
                SecDataUIC.a aVar2 = SecDataUIC.CWq;
                p.h(view, "view");
                Context context = view.getContext();
                p.g(context, "view.context");
                SecDataUIC gU = SecDataUIC.a.gU(context);
                Map eSo = (gU == null || (eSr = gU.eSr()) == null) ? null : eSr.eSo();
                if (eSo == null || !eSo.containsKey(String.valueOf(view.hashCode()))) {
                    ViewParent parent = view.getParent();
                    while (parent != null && (eSo == null || !eSo.containsKey(String.valueOf(parent.hashCode())))) {
                        parent = parent.getParent();
                    }
                    if (eSo != null) {
                        aVar = (com.tencent.mm.bw.a) eSo.get(String.valueOf(parent != null ? parent.hashCode() : 0));
                    } else {
                        aVar = null;
                    }
                } else {
                    aVar = (com.tencent.mm.bw.a) eSo.get(String.valueOf(view.hashCode()));
                }
                egl egl = (egl) aVar;
                Log.i("MicroMsg.URISpanHandlerSet", "TopicSpanHandler click %s %s", uVar.url, egl);
                long j2 = 0;
                int i3 = 0;
                String str3 = "";
                long aWB = (long) cl.aWB();
                int i4 = 0;
                if (egl != null) {
                    j2 = egl.KMf;
                    i3 = egl.Ngu;
                    String str4 = egl.Ngv;
                    aWB = egl.KMc;
                    i2 = egl.Ngw;
                    int i5 = egl.Ngx;
                    int i6 = egl.Ngy;
                    if (i3 == 3 && !TextUtils.isEmpty(str4) && (split = str4.split("#")) != null && split.length >= 2) {
                        String str5 = split[1];
                        if ((TextUtils.isEmpty(str5) || TextUtils.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO, str5)) && i6 != 0) {
                            Log.i("MicroMsg.WebSearch.WebSearchReportLogic", "need correct feeId");
                            SnsInfo Zr = aj.faO().Zr(i6);
                            if (!(Zr == null || Zr.field_snsId == 0)) {
                                split[1] = r.Jb(Zr.field_snsId);
                                StringBuilder sb = new StringBuilder();
                                for (int i7 = 0; i7 < split.length; i7++) {
                                    sb.append(split[i7]);
                                    if (i7 != split.length - 1) {
                                        sb.append("#");
                                    }
                                }
                                str2 = sb.toString();
                                i4 = i5;
                                str3 = str2;
                            }
                        }
                    }
                    str2 = str4;
                    i4 = i5;
                    str3 = str2;
                } else {
                    i2 = 0;
                }
                if (uVar.data != null && (uVar.data instanceof Bundle)) {
                    j2 = ((Bundle) uVar.data).getLong("msgSvrId");
                }
                String str6 = uVar.url;
                int i8 = 73;
                if (i3 == 1 || i3 == 2) {
                    i8 = 73;
                } else if (i3 == 3) {
                    i8 = 79;
                } else if (i3 == 4 || i3 == 5) {
                    i8 = 80;
                }
                String Nj = d.Nj(i8);
                ag agVar = new ag();
                agVar.context = URISpanHandlerSet.this.mContext;
                agVar.scene = i8;
                agVar.query = str6;
                agVar.title = str6;
                agVar.sessionId = Nj;
                agVar.IEk = true;
                agVar.IEl = true;
                agVar.IEm = true;
                agVar.IEn = 1;
                agVar.statusBarColor = com.tencent.mm.cb.a.n(URISpanHandlerSet.this.mContext, R.color.afz);
                agVar.IEo = true;
                agVar.dVU.put("msgSvrId", String.valueOf(j2));
                agVar.dVU.put("parentSearchID", "");
                agVar.dVU.put("fromTagSearch", "1");
                agVar.IEt.put("ShareSceneId", str3);
                agVar.IEt.put("SnsContentType", String.valueOf(i4));
                ((h) g.af(h.class)).a(agVar);
                lh lhVar = new lh();
                lhVar.enl = 1;
                lhVar.eua = (long) cl.aWB();
                lhVar.eYp = 1;
                if (TextUtils.isEmpty(str6) || !str6.startsWith("#")) {
                    str = str6;
                } else {
                    str = str6.substring(1);
                }
                lhVar.eYq = lhVar.x("ResultQuery", str, true);
                lhVar.eYr = (long) i3;
                lhVar.eYs = lhVar.x("ShareSceneId", str3, true);
                lhVar.eYt = aWB;
                lhVar.eYu = (long) i2;
                lhVar.eYv = lhVar.x("SearchSessionId", Nj, true);
                lhVar.bfK();
                ar.a(lhVar);
            }
            AppMethodBeat.o(231455);
            return true;
        }
    }

    @a
    class AddressUriSpanHandler extends BaseUriSpanHandler {
        AddressUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{44};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231416);
            if (uVar.type == 44) {
                Uri parse = Uri.parse(WebView.SCHEME_GEO + Uri.encode(uVar.url));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                if (intent.resolveActivity(MMApplicationContext.getContext().getPackageManager()) != null) {
                    Context context = MMApplicationContext.getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$AddressUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12809, 9, "");
                } else {
                    Log.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12809, 8, "");
                AppMethodBeat.o(231416);
                return true;
            }
            AppMethodBeat.o(231416);
            return false;
        }
    }

    @a
    class ContactUriSpanHandler extends BaseUriSpanHandler {
        ContactUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            u uVar = null;
            AppMethodBeat.i(19687);
            if (str.trim().equals("weixin://contacts/all/")) {
                uVar = new u(str, 23, new ah("@all.android", null, URISpanHandlerSet.this.mContext.getString(R.string.dvj), null, true, true));
            } else if (str.trim().equals("weixin://contacts/microblog/")) {
                uVar = new u(str, 22, ai.Kc(URISpanHandlerSet.this.mContext.getString(R.string.dwu)));
            } else if (str.trim().equals("weixin://contacts/micromessenger/")) {
                uVar = new u(str, 2, new ah("@micromsg.qq.com", null, URISpanHandlerSet.this.mContext.getString(R.string.dwv), null, true, true));
            } else if (str.trim().startsWith("weixin://contacts/")) {
                String substring = str.trim().substring(0, str.trim().length() - 1);
                int lastIndexOf = substring.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                if (lastIndexOf == -1) {
                    AppMethodBeat.o(19687);
                    return uVar;
                }
                uVar = new u(str, 21, ai.aN("@".concat(String.valueOf(substring.substring(lastIndexOf + 1))), URISpanHandlerSet.this.mContext.getString(R.string.dvl)));
            }
            AppMethodBeat.o(19687);
            return uVar;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{23, 21, 22, 2};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19689);
            if (str.equals("weixin://contacts/microblog/") || str.equals("weixin://contacts/micromessenger/") || str.equals("weixin://contacts/all/")) {
                ah Kc = ai.Kc(URISpanHandlerSet.this.mContext.getString(R.string.dwv));
                if (str.equals("weixin://contacts/microblog/")) {
                    Kc = ai.Kc(URISpanHandlerSet.this.mContext.getString(R.string.dwu));
                }
                if (str.equals("weixin://contacts/micromessenger/")) {
                    Kc = ai.Kc(URISpanHandlerSet.this.mContext.getString(R.string.dwv));
                }
                if (str.equals("weixin://contacts/all/")) {
                    Kc = ai.Kc(URISpanHandlerSet.this.mContext.getString(R.string.dvj));
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", Kc.getType()).putExtra("Contact_GroupFilter_Str", Kc.aVj()).putExtra("Contact_GroupFilter_DisplayName", Kc.arI());
                intent.addFlags(268435456);
                AppMethodBeat.o(19689);
                return true;
            }
            AppMethodBeat.o(19689);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(231421);
            int i2 = uVar.type;
            if (i2 == 23 || i2 == 21 || i2 == 22 || i2 == 2) {
                ah ahVar = (ah) uVar.ba(ah.class);
                if (iVar != null) {
                    iVar.a(uVar);
                }
                if (ahVar == null) {
                    com.tencent.mm.ui.base.h.c(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.eeb), URISpanHandlerSet.this.mContext.getString(R.string.zb), true);
                    AppMethodBeat.o(231421);
                    return false;
                }
                if (ahVar.getType().equals("@t.qq.com")) {
                    if (((l) g.af(l.class)).aSW().aEY("@t.qq.com") != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        com.tencent.mm.ui.base.h.c(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.eeb), URISpanHandlerSet.this.mContext.getString(R.string.zb), true);
                    }
                }
                if (ahVar.getType().equals("@domain.android")) {
                    List<ci> eiS = ((l) g.af(l.class)).aSW().eiS();
                    if (eiS.size() > 0) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= eiS.size()) {
                                break;
                            } else if (eiS.get(i3).isEnable()) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        com.tencent.mm.ui.base.h.c(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.eeb), URISpanHandlerSet.this.mContext.getString(R.string.zb), true);
                    }
                }
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", ahVar.getType()).putExtra("Contact_GroupFilter_Str", ahVar.aVj()).putExtra("Contact_GroupFilter_DisplayName", ahVar.arI());
                intent.addFlags(268435456);
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$ContactUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231421);
                return true;
            }
            AppMethodBeat.o(231421);
            return false;
        }
    }

    @a
    class ProfileUriSpanHandler extends BaseUriSpanHandler {
        ProfileUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19732);
            if (str.trim().startsWith("weixin://contacts/profile/")) {
                u uVar = new u(str, 3, str.trim().replace("weixin://contacts/profile/", "").replace(FilePathGenerator.ANDROID_DIR_SEP, ""));
                AppMethodBeat.o(19732);
                return uVar;
            }
            AppMethodBeat.o(19732);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{3};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19734);
            if (str.startsWith("weixin://contacts/profile/")) {
                String replace = str.trim().replace("weixin://contacts/profile/", "").replace(FilePathGenerator.ANDROID_DIR_SEP, "");
                if (Util.isNullOrNil(replace)) {
                    Log.e("MicroMsg.URISpanHandlerSet", "jumpToActivity fail, user is null");
                    AppMethodBeat.o(19734);
                    return true;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", replace);
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(replace);
                if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    e.a(intent, replace);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(19734);
                return true;
            }
            AppMethodBeat.o(19734);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231445);
            if (uVar.type == 3) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                String str = (String) uVar.ba(String.class);
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", str);
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(str);
                if (Kn != null && ((int) Kn.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    e.a(intent, str);
                }
                if (Util.nullAsNil(str).length() > 0) {
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231445);
                return true;
            }
            AppMethodBeat.o(231445);
            return false;
        }
    }

    @a
    class VerifyContactUriSpanHandler extends BaseUriSpanHandler {
        VerifyContactUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19764);
            if (str.trim().startsWith("weixin://findfriend/verifycontact")) {
                u uVar = new u(str, 4, null);
                AppMethodBeat.o(19764);
                return uVar;
            }
            AppMethodBeat.o(19764);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{4};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231459);
            if (uVar.type == 4) {
                if (iVar != null) {
                    iVar.a(uVar);
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231459);
                return true;
            }
            AppMethodBeat.o(231459);
            return false;
        }
    }

    @a
    class VoipCallAgainUrilSpanHandler extends BaseUriSpanHandler {
        VoipCallAgainUrilSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19766);
            if (str.trim().startsWith("weixin://voip/callagain/")) {
                u uVar = new u(str, 38, null);
                AppMethodBeat.o(19766);
                return uVar;
            }
            AppMethodBeat.o(19766);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{38};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231460);
            if (uVar.type == 38) {
                Uri parse = Uri.parse(uVar.url);
                String queryParameter = parse.getQueryParameter(ch.COL_USERNAME);
                String queryParameter2 = parse.getQueryParameter("isvideocall");
                zj zjVar = new zj();
                zjVar.efx.dKy = 5;
                zjVar.efx.talker = queryParameter;
                zjVar.efx.context = URISpanHandlerSet.this.mContext;
                if (queryParameter != null && !queryParameter.equals("")) {
                    if (queryParameter2 == null || !queryParameter2.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                        zjVar.efx.eft = 4;
                    } else {
                        zjVar.efx.eft = 2;
                    }
                    EventCenter.instance.publish(zjVar);
                    AppMethodBeat.o(231460);
                    return true;
                }
            }
            AppMethodBeat.o(231460);
            return false;
        }
    }

    @a
    class BindMobileUrilSpanHandler extends BaseUriSpanHandler {
        BindMobileUrilSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19681);
            if (str.trim().startsWith("weixin://setting/bindphone")) {
                u uVar = new u(str, 5, null);
                AppMethodBeat.o(19681);
                return uVar;
            }
            AppMethodBeat.o(19681);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{5};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19683);
            if (str.equals("weixin://setting/bindphone")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                MMWizardActivity.ay(URISpanHandlerSet.this.mContext, intent);
                AppMethodBeat.o(19683);
                return true;
            }
            AppMethodBeat.o(19683);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231419);
            if (uVar.type == 5) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                MMWizardActivity.ay(URISpanHandlerSet.this.mContext, new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class));
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231419);
                return true;
            }
            AppMethodBeat.o(231419);
            return false;
        }
    }

    @a
    class SettingHeadImgUriSpanHandler extends BaseUriSpanHandler {
        SettingHeadImgUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19742);
            if (str.trim().startsWith("weixin://setting/setheadimage")) {
                u uVar = new u(str, 6, null);
                AppMethodBeat.o(19742);
                return uVar;
            }
            AppMethodBeat.o(19742);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{6};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19744);
            if (str.equals("weixin://setting/setheadimage")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", z.aTY());
                intent.putExtra("Contact_Nick", z.aUa());
                intent.putExtra("User_Avatar", true);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(19744);
                return true;
            }
            AppMethodBeat.o(19744);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231448);
            if (uVar.type == 6) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231448);
                return true;
            }
            AppMethodBeat.o(231448);
            return false;
        }
    }

    @a
    class SettingBindEmailUriSpanHandler extends BaseUriSpanHandler {
        SettingBindEmailUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19737);
            if (str.trim().startsWith("weixin://setting/bindemail")) {
                u uVar = new u(str, 7, null);
                AppMethodBeat.o(19737);
                return uVar;
            }
            AppMethodBeat.o(19737);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{7};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231446);
            if (uVar.type == 7) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231446);
                return true;
            }
            AppMethodBeat.o(231446);
            return false;
        }
    }

    @a
    class SettingNotifyUriSpanHandler extends BaseUriSpanHandler {
        SettingNotifyUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19745);
            if (str.trim().startsWith("weixin://setting/notify")) {
                u uVar = new u(str, 9, null);
                AppMethodBeat.o(19745);
                return uVar;
            }
            AppMethodBeat.o(19745);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{9};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19747);
            if (str.equals("weixin://setting/notify")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                Intent intent = new Intent();
                intent.addFlags(67108864);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI", intent);
                AppMethodBeat.o(19747);
                return true;
            }
            AppMethodBeat.o(19747);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231449);
            if (uVar.type == 9) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsNotificationUI");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231449);
                return true;
            }
            AppMethodBeat.o(231449);
            return false;
        }
    }

    @a
    class SettingPluginQQMailUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMailUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19751);
            if (str.trim().startsWith("weixin://setting/plugin/qqmail")) {
                u uVar = new u(str, 10, null);
                AppMethodBeat.o(19751);
                return uVar;
            }
            AppMethodBeat.o(19751);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{10};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19753);
            if (str.equals("weixin://setting/plugin/qqmail")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(19753);
                return true;
            }
            AppMethodBeat.o(19753);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231451);
            if (uVar.type == 10) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "qqmail");
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231451);
                return true;
            }
            AppMethodBeat.o(231451);
            return false;
        }
    }

    @a
    class SettingPluginSxMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginSxMsgUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19755);
            if (str.trim().startsWith("weixin://setting/plugin/sxmsg")) {
                u uVar = new u(str, 11, null);
                AppMethodBeat.o(19755);
                return uVar;
            }
            AppMethodBeat.o(19755);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{11};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingPluginLomoUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginLomoUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19748);
            if (str.trim().startsWith("weixin://setting/plugin/lomo")) {
                u uVar = new u(str, 12, null);
                AppMethodBeat.o(19748);
                return uVar;
            }
            AppMethodBeat.o(19748);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{12};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19750);
            if (str.equals("weixin://setting/plugin/lomo")) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(19750);
                return true;
            }
            AppMethodBeat.o(19750);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231450);
            if (uVar.type == 12) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "weibo");
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231450);
                return true;
            }
            AppMethodBeat.o(231450);
            return false;
        }
    }

    @a
    class SettingPluginQQMsgUriSpanHandler extends BaseUriSpanHandler {
        SettingPluginQQMsgUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19754);
            if (str.trim().startsWith("weixin://setting/plugin/qqmsg")) {
                u uVar = new u(str, 13, null);
                AppMethodBeat.o(19754);
                return uVar;
            }
            AppMethodBeat.o(19754);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{13};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class SettingBlacklistUriSpanHandler extends BaseUriSpanHandler {
        SettingBlacklistUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19739);
            if (str.trim().startsWith("weixin://setting/blacklist")) {
                u uVar = new u(str, 14, null);
                AppMethodBeat.o(19739);
                return uVar;
            }
            AppMethodBeat.o(19739);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{14};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19741);
            if (str.equals("weixin://setting/blacklist")) {
                ah Kb = ai.Kb(URISpanHandlerSet.this.mContext.getString(R.string.dvk));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, AddressUI.class);
                intent.putExtra("Contact_GroupFilter_Type", Kb.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", Kb.arI());
                intent.addFlags(67108864);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(19741);
                return true;
            }
            AppMethodBeat.o(19741);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231447);
            if (uVar.type == 14) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                ah Kb = ai.Kb(URISpanHandlerSet.this.mContext.getString(R.string.dvk));
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SelectContactUI.class);
                intent.putExtra("Contact_GroupFilter_Type", Kb.getType());
                intent.putExtra("Contact_GroupFilter_DisplayName", Kb.arI());
                intent.addFlags(67108864);
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$SettingBlacklistUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231447);
                return true;
            }
            AppMethodBeat.o(231447);
            return false;
        }
    }

    @a
    class SettingPrivacyUriSpanHandler extends BaseUriSpanHandler {
        SettingPrivacyUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19756);
            if (str.trim().startsWith("weixin://setting/privacy")) {
                u uVar = new u(str, 15, null);
                AppMethodBeat.o(19756);
                return uVar;
            }
            AppMethodBeat.o(19756);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{15};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19758);
            if (str.equals("weixin://setting/privacy")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                AppMethodBeat.o(19758);
                return true;
            }
            AppMethodBeat.o(19758);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231452);
            if (uVar.type == 15) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPrivacyUI");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231452);
                return true;
            }
            AppMethodBeat.o(231452);
            return false;
        }
    }

    @a
    class PluginUriSpanHandler extends BaseUriSpanHandler {
        PluginUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19730);
            if (str.trim().startsWith("weixin://plugin")) {
                u uVar = new u(str, 26, null);
                AppMethodBeat.o(19730);
                return uVar;
            }
            AppMethodBeat.o(19730);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{26};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19731);
            if (str.equals("weixin://plugin")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "setting", ".ui.setting.SettingsPluginsUI", intent);
                AppMethodBeat.o(19731);
                return true;
            }
            AppMethodBeat.o(19731);
            return false;
        }
    }

    @a
    class FlowStatUriSpanHandler extends BaseUriSpanHandler {
        FlowStatUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19705);
            if (str.trim().startsWith("weixin://flowstat")) {
                u uVar = new u(str, 16, null);
                AppMethodBeat.o(19705);
                return uVar;
            }
            AppMethodBeat.o(19705);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{16};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19707);
            if (str.equals("weixin://flowstat")) {
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                AppMethodBeat.o(19707);
                return true;
            }
            AppMethodBeat.o(19707);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231429);
            if (uVar.type == 16) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                LauncherUI instance = LauncherUI.getInstance();
                if (instance != null) {
                    instance.ODR.getMainTabUI().blU("tab_settings");
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231429);
                return true;
            }
            AppMethodBeat.o(231429);
            return false;
        }
    }

    @a
    class FriendSearchUriSpanHandler extends BaseUriSpanHandler {
        FriendSearchUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19711);
            if (str.trim().startsWith("weixin://findfriend/search")) {
                u uVar = new u(str, 17, null);
                AppMethodBeat.o(19711);
                return uVar;
            }
            AppMethodBeat.o(19711);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{17};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19713);
            if (str.equals("weixin://findfriend/search")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI", intent);
                AppMethodBeat.o(19713);
                return true;
            }
            AppMethodBeat.o(19713);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231431);
            if (uVar.type == 17) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "subapp", ".ui.pluginapp.ContactSearchUI");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231431);
                return true;
            }
            AppMethodBeat.o(231431);
            return false;
        }
    }

    @a
    class FriendShareUriSpanHandler extends BaseUriSpanHandler {
        FriendShareUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19714);
            if (str.trim().startsWith("weixin://findfriend/share")) {
                u uVar = new u(str, 18, null);
                AppMethodBeat.o(19714);
                return uVar;
            }
            AppMethodBeat.o(19714);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{18};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19716);
            if (str.equals("weixin://findfriend/share")) {
                Intent intent = new Intent();
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI", intent);
                AppMethodBeat.o(19716);
                return true;
            }
            AppMethodBeat.o(19716);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231432);
            if (uVar.type == 18) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "setting", ".ui.qrcode.ShareMicroMsgChoiceUI");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231432);
                return true;
            }
            AppMethodBeat.o(231432);
            return false;
        }
    }

    @a
    class FriendMobileUriSpanHandler extends BaseUriSpanHandler {
        FriendMobileUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19708);
            if (str.trim().startsWith("weixin://findfriend/mobile")) {
                u uVar = new u(str, 20, null);
                AppMethodBeat.o(19708);
                return uVar;
            }
            AppMethodBeat.o(19708);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{20};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19710);
            if (str.equals("weixin://findfriend/mobile")) {
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(19710);
                return true;
            }
            AppMethodBeat.o(19710);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231430);
            if (uVar.type == 20) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                Intent intent = new Intent(URISpanHandlerSet.this.mContext, MobileFriendUI.class);
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$FriendMobileUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231430);
                return true;
            }
            AppMethodBeat.o(231430);
            return false;
        }
    }

    @a
    class PayUriSpanHandler extends BaseUriSpanHandler {
        PayUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{28};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231443);
            if (uVar.type == 28) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                je jeVar = new je();
                jeVar.dNT.actionCode = 11;
                jeVar.dNT.result = uVar.url;
                jeVar.dNT.context = URISpanHandlerSet.this.mContext;
                jeVar.dNT.dNV = new Bundle();
                jeVar.dNT.dNV.putInt("pay_channel", 6);
                EventCenter.instance.asyncPublish(jeVar, Looper.myLooper());
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231443);
                return true;
            }
            AppMethodBeat.o(231443);
            return false;
        }
    }

    @a
    class EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
        EmotionStoreUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19697);
            if (str.trim().startsWith("weixin://emoticonstore/")) {
                int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                String str2 = "";
                if (lastIndexOf != -1) {
                    str2 = str.substring(lastIndexOf + 1);
                }
                u uVar = new u(str, 29, str2);
                AppMethodBeat.o(19697);
                return uVar;
            }
            AppMethodBeat.o(19697);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{29};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231423);
            if (uVar.type == 29) {
                if (iVar != null) {
                    iVar.a(uVar);
                }
                Intent intent = new Intent();
                intent.putExtra("download_entrance_scene", 21);
                intent.putExtra("extra_id", (String) uVar.ba(String.class));
                intent.putExtra("preceding_scence", 3);
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "emoji", ".ui.EmojiStoreDetailUI", intent);
                if (iVar != null) {
                    iVar.b(uVar);
                }
                AppMethodBeat.o(231423);
                return true;
            }
            AppMethodBeat.o(231423);
            return false;
        }
    }

    @a(Xq = PRIORITY.LOW)
    class DeeplinkUriSpanHandler extends BaseUriSpanHandler {
        DeeplinkUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19694);
            Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", str);
            if (str.trim().toLowerCase().startsWith("weixin://")) {
                u uVar = new u(str, 30, null);
                AppMethodBeat.o(19694);
                return uVar;
            }
            AppMethodBeat.o(19694);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{30};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            final String str;
            AppMethodBeat.i(231422);
            Log.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", Integer.valueOf(uVar.type), uVar.url);
            if (iVar != null) {
                str = (String) iVar.a(uVar);
            } else {
                str = null;
            }
            if (uVar.type == 30) {
                final String nullAsNil = Util.nullAsNil(uVar.url);
                if (nullAsNil.startsWith("weixin://shieldBrandMsg/") || nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                    if (Util.isNullOrNil(str)) {
                        Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                        AppMethodBeat.o(231422);
                        return true;
                    }
                    final com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(str);
                    if (fJ == null) {
                        Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                        AppMethodBeat.o(231422);
                        return true;
                    } else if (nullAsNil.startsWith("weixin://shieldBrandMsg/")) {
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.hmn, (int) R.string.zb, (int) R.string.hmm, (int) R.string.amn, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(19690);
                                int i3 = fJ.field_brandFlag;
                                fJ.field_brandFlag |= 1;
                                Log.i("MicroMsg.URISpanHandlerSet", "shield biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i3), Integer.valueOf(fJ.field_brandFlag));
                                com.tencent.mm.al.g.i(fJ);
                                AppMethodBeat.o(19690);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    } else if (nullAsNil.startsWith("weixin://receiveBrandMsg/")) {
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.hml, (int) R.string.zb, (int) R.string.hmk, (int) R.string.amn, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(19691);
                                int i3 = fJ.field_brandFlag;
                                fJ.field_brandFlag &= -2;
                                Log.i("MicroMsg.URISpanHandlerSet", "receive biz msg %s, %s, old = %d, new = %d", nullAsNil, str, Integer.valueOf(i3), Integer.valueOf(fJ.field_brandFlag));
                                com.tencent.mm.al.g.i(fJ);
                                AppMethodBeat.o(19691);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    }
                } else if (com.tencent.mm.pluginsdk.g.w(Uri.parse(nullAsNil))) {
                    com.tencent.mm.pluginsdk.g.P(URISpanHandlerSet.this.mContext, str, nullAsNil);
                } else if (nullAsNil.startsWith("weixin://receiveWeAppKFMsg")) {
                    if (Util.isNullOrNil(str)) {
                        Log.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", nullAsNil);
                        AppMethodBeat.o(231422);
                        return true;
                    }
                    com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.qz, (int) R.string.zb, (int) R.string.qy, (int) R.string.amn, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(19692);
                            Log.i("MicroMsg.URISpanHandlerSet", "AppBrandServiceHelper switchTo to receive msg for username %s", str);
                            com.tencent.mm.ui.appbrand.e.l(URISpanHandlerSet.this.mContext, str, true);
                            AppMethodBeat.o(19692);
                        }
                    }, (DialogInterface.OnClickListener) null);
                } else if (nullAsNil.startsWith("weixin://xmail/bind")) {
                    Intent putExtra = new Intent().putExtra("Contact_User", "qqmail");
                    putExtra.putExtra("key_need_rebind_xmail", true);
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, Scopes.PROFILE, ".ui.ContactInfoUI", putExtra);
                } else {
                    com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.this.mContext, nullAsNil, str, 1, nullAsNil, (g.a) null);
                }
                AppMethodBeat.o(231422);
                return true;
            }
            AppMethodBeat.o(231422);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19696);
            if (Util.isNullOrNil(str) || bundle == null) {
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(str == null);
                objArr[1] = Boolean.valueOf(bundle == null);
                Log.e("MicroMsg.URISpanHandlerSet", "url is null ? %b, paramsBundle is null ? %b", objArr);
                AppMethodBeat.o(19696);
                return false;
            } else if (com.tencent.mm.pluginsdk.g.w(Uri.parse(str))) {
                int i2 = bundle.getInt("key_scene", -1);
                Log.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", Integer.valueOf(i2), str);
                if (i2 == -1) {
                    i2 = 5;
                }
                final q a2 = com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, "", true, (DialogInterface.OnCancelListener) null);
                com.tencent.mm.pluginsdk.g.a(URISpanHandlerSet.this.mContext, str, i2, new g.a() {
                    /* class com.tencent.mm.app.plugin.URISpanHandlerSet.DeeplinkUriSpanHandler.AnonymousClass4 */

                    @Override // com.tencent.mm.pluginsdk.g.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.q qVar, boolean z) {
                        ekq bfD;
                        AppMethodBeat.i(19693);
                        if (a2 != null && a2.isShowing()) {
                            a2.dismiss();
                        }
                        if (!(qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac) || (bfD = ((ac) qVar).bfD()) == null || URISpanHandlerSet.this.mContext == null || Util.isNullOrNil(bfD.NjR))) {
                            com.tencent.mm.ui.base.u.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.zb) + " : " + Util.nullAsNil(bfD.NjR), 0).show();
                        }
                        AppMethodBeat.o(19693);
                    }
                });
                AppMethodBeat.o(19696);
                return true;
            } else {
                AppMethodBeat.o(19696);
                return false;
            }
        }
    }

    @a
    class ExposeUriSpanHandler extends BaseUriSpanHandler {
        ExposeUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19700);
            if (str.trim().toLowerCase().equals("weixin://expose/")) {
                u uVar = new u(str, 31, null);
                AppMethodBeat.o(19700);
                return uVar;
            }
            AppMethodBeat.o(19700);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{31};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            int i2;
            AppMethodBeat.i(231426);
            if (uVar.type == 31) {
                Intent intent = new Intent();
                if (iVar == null) {
                    AppMethodBeat.o(231426);
                    return false;
                }
                String str = (String) iVar.a(uVar);
                intent.putExtra("k_username", str);
                if (Util.isNullOrNil(str) || !str.endsWith("@chatroom")) {
                    i2 = 39;
                } else {
                    i2 = 36;
                }
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format(e.C2115e.OyU, Integer.valueOf(i2)));
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(231426);
                return true;
            }
            AppMethodBeat.o(231426);
            return false;
        }
    }

    @a
    class JumpActivityUriSpanHandler extends BaseUriSpanHandler {
        JumpActivityUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19721);
            if (str.toLowerCase().startsWith("weixin://jump/")) {
                String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
                String str2 = split[split.length - 1];
                if ("mainframe".equalsIgnoreCase(str2)) {
                    Intent intent = new Intent(URISpanHandlerSet.this.mContext, LauncherUI.class);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    intent.addFlags(67108864);
                    Context context = URISpanHandlerSet.this.mContext;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpActivityUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if ("shake".equalsIgnoreCase(str2)) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10221, "1");
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent2.addFlags(268435456);
                    }
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "shake", ".ui.ShakeReportUI", intent2);
                    if (URISpanHandlerSet.this.mContext != null && (URISpanHandlerSet.this.mContext instanceof Activity)) {
                        ((Activity) URISpanHandlerSet.this.mContext).finish();
                    }
                } else if ("scanqrcode".equalsIgnoreCase(str2)) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("BaseScanUI_select_scan_mode", 1);
                    intent3.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
                    intent3.setFlags(65536);
                    intent3.addFlags(67108864);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent3.addFlags(268435456);
                    }
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent3);
                }
                AppMethodBeat.o(19721);
                return true;
            }
            AppMethodBeat.o(19721);
            return false;
        }
    }

    @a
    class ScanQrCodeUriSpanHandler extends BaseUriSpanHandler {
        ScanQrCodeUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            boolean z2 = false;
            AppMethodBeat.i(19735);
            if (!str.equals("weixin://scanqrcode/")) {
                AppMethodBeat.o(19735);
                return false;
            } else if (!z) {
                Log.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
                AppMethodBeat.o(19735);
                return true;
            } else {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                if (bundle != null && bundle.getInt("fromScene") == 100) {
                    z2 = true;
                }
                if (!z2) {
                    intent.addFlags(67108864);
                }
                if (URISpanHandlerSet.this.mContext instanceof Service) {
                    intent.addFlags(268435456);
                }
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.o(19735);
                return true;
            }
        }
    }

    @a
    class SetSafeDeviceUriSpanHandler extends BaseUriSpanHandler {
        SetSafeDeviceUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19736);
            if (str.equals("weixin://setting/account/safedevice")) {
                bg.aVF();
                bg.aVF();
                String str2 = (String) com.tencent.mm.model.c.azQ().get(4097, "");
                if (!Util.isNullOrNil((String) com.tencent.mm.model.c.azQ().get(6, ""))) {
                    Intent intent = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "account", ".security.ui.MySafeDeviceListUI");
                } else if (!Util.isNullOrNil(str2)) {
                    Intent intent2 = new Intent(URISpanHandlerSet.this.mContext, BindMContactIntroUI.class);
                    intent2.putExtra("bind_scene", 1);
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent2.addFlags(268435456);
                    }
                    MMWizardActivity.ay(URISpanHandlerSet.this.mContext, intent2);
                } else {
                    Intent intent3 = new Intent();
                    if (URISpanHandlerSet.this.mContext instanceof Service) {
                        intent3.addFlags(268435456);
                    }
                    com.tencent.mm.br.c.a(URISpanHandlerSet.this.mContext, "account", ".security.ui.BindSafeDeviceUI", intent3);
                }
                AppMethodBeat.o(19736);
                return true;
            }
            AppMethodBeat.o(19736);
            return false;
        }
    }

    @a
    class PayTransferUriSpanHandler extends BaseUriSpanHandler {
        PayTransferUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            com.tencent.mm.plugin.wallet.a aVar;
            String str2;
            String str3;
            AppMethodBeat.i(19727);
            if (str.startsWith("wxpay://")) {
                if (uVar != null) {
                    str2 = uVar.glZ().toString();
                    Object gma = uVar.gma();
                    aVar = gma instanceof com.tencent.mm.plugin.wallet.a ? (com.tencent.mm.plugin.wallet.a) gma : null;
                } else {
                    aVar = null;
                    str2 = null;
                }
                if (Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
                    AppMethodBeat.o(19727);
                    return false;
                }
                String substring = str.substring(8);
                if (substring.indexOf("&") > 0) {
                    substring = substring.split("&")[0];
                }
                int indexOf = substring.indexOf("=");
                if (indexOf >= 0) {
                    str3 = substring.substring(indexOf + 1);
                } else {
                    str3 = "";
                }
                if (Util.getInt(str3, 0) == 1) {
                    if (z.aUp() || z.aUq()) {
                        com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.this.mContext, 5, str2, 11, aVar);
                    } else {
                        com.tencent.mm.pluginsdk.wallet.f.a(URISpanHandlerSet.this.mContext, 2, str2, 11, aVar);
                    }
                    AppMethodBeat.o(19727);
                    return true;
                }
                Toast.makeText(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.gku), 0).show();
                AppMethodBeat.o(19727);
                return false;
            }
            AppMethodBeat.o(19727);
            return false;
        }
    }

    @a
    class EnterRoomUriSpanHandler extends BaseUriSpanHandler {
        EnterRoomUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            int lastIndexOf;
            AppMethodBeat.i(19699);
            if (!str.startsWith("weixin://jump/mainframe/") || (lastIndexOf = str.trim().lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP)) < 0 || lastIndexOf >= str.trim().length() - 1) {
                AppMethodBeat.o(19699);
                return false;
            }
            String substring = str.trim().substring(lastIndexOf + 1);
            if (ab.Eq(substring)) {
                bg.aVF();
                as Kn = com.tencent.mm.model.c.aSN().Kn(substring);
                if (Kn == null || ((int) Kn.gMZ) == 0) {
                    as asVar = new as();
                    asVar.setUsername(substring);
                    bg.aVF();
                    com.tencent.mm.model.c.aSN().ap(asVar);
                }
            }
            Intent putExtra = new Intent(URISpanHandlerSet.this.mContext, ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
            if (URISpanHandlerSet.this.mContext instanceof Service) {
                putExtra.addFlags(268435456);
            }
            Context context = URISpanHandlerSet.this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterRoomUriSpanHandler", "handleUriJump", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/UriJumpCallback;Landroid/os/Bundle;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(19699);
            return true;
        }
    }

    @a
    class CardUriSpanHandler extends BaseUriSpanHandler {
        CardUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[0];
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            AppMethodBeat.i(19686);
            if (str.startsWith("wxcard://cardjumptype=1")) {
                String str2 = null;
                if (uVar != null) {
                    str2 = uVar.glZ().toString();
                }
                Intent intent = new Intent();
                intent.putExtra("user_name", str2);
                intent.putExtra("view_type", 1);
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "card", ".ui.CardViewUI", intent);
                AppMethodBeat.o(19686);
                return true;
            }
            AppMethodBeat.o(19686);
            return false;
        }
    }

    @a
    class AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
        AlphaInstallUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19678);
            if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
                u uVar = new u(str, 32, null);
                AppMethodBeat.o(19678);
                return uVar;
            }
            AppMethodBeat.o(19678);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{32};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231417);
            if (uVar.type == 32) {
                String replace = uVar.url.replace("weixin://alphainstall?", "");
                String str = b.aKJ() + Uri.parse(replace).getQueryParameter("md5") + ".apk";
                if (s.YS(str)) {
                    com.tencent.mm.pluginsdk.model.app.r.b(MMApplicationContext.getContext(), str, null, false);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", replace.toString());
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "webview", ".ui.tools.WebViewUI", intent);
                }
                AppMethodBeat.o(231417);
                return true;
            }
            AppMethodBeat.o(231417);
            return false;
        }
    }

    @a
    class PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
        PhoneEmailUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{25, 24};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            String str;
            AppMethodBeat.i(231444);
            if (iVar != null) {
                iVar.a(uVar);
            }
            if (uVar.type == 25) {
                String str2 = uVar.username;
                Bundle bundle = new Bundle();
                if (str2 != null && !str2.equals(z.aTY())) {
                    bundle.putString("Contact_User", str2);
                    com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str2);
                    if (SR == null || Util.isNullOrNil(SR.getMd5())) {
                        str = null;
                    } else {
                        str = Util.nullAsNil(SR.bnP()).replace(" ", "");
                    }
                    bundle.putString("Contact_Mobile_MD5", str);
                }
                bundle.putInt("fromScene", 1);
                n.a(URISpanHandlerSet.this.mContext, uVar.url, (DialogInterface.OnDismissListener) null, bundle);
                AppMethodBeat.o(231444);
                return true;
            }
            if (uVar.type == 24) {
                n.b(URISpanHandlerSet.this.mContext, uVar.url, null);
            }
            if (iVar != null) {
                iVar.b(uVar);
            }
            AppMethodBeat.o(231444);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a(Xq = PRIORITY.HIGH)
    class LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
        LuckyMoneyUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19722);
            if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/") || str.trim().toLowerCase().startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")) {
                u uVar = new u(str, 33, null);
                AppMethodBeat.o(19722);
                return uVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinunionhongbao/")) {
                u uVar2 = new u(str, 59, null);
                AppMethodBeat.o(19722);
                return uVar2;
            } else {
                AppMethodBeat.o(19722);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{33, 59};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231441);
            if (uVar.type == 33) {
                Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_NORMAL");
                if (iVar == null) {
                    Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
                    AppMethodBeat.o(231441);
                    return false;
                }
                Intent intent = new Intent();
                intent.putExtra("key_native_url", uVar.url);
                intent.putExtra("key_username", (String) iVar.a(uVar));
                intent.putExtra("key_lucky_money_can_received", true);
                intent.putExtra("key_jump_from", 4);
                intent.putExtra("scene_id", 1002);
                if (uVar.url.startsWith("frhb://c2cbizmessagehandler/hongbao/receivehongbao")) {
                    intent.putExtra("key_hk_scene", 1);
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "luckymoney", ".hk.ui.LuckyMoneyHKBeforeDetailUI", intent);
                } else {
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12097, 11, 0, Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 4, 1);
                AppMethodBeat.o(231441);
                return true;
            } else if (uVar.type == 59) {
                Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == MMSpanConstants.Type.TYPE_LUCKY_MONEY_UNION");
                if (iVar == null) {
                    Log.i("MicroMsg.URISpanHandlerSet", "LuckyMoneyUriSpanHandler handleSpanClick() clickCallback == null");
                    AppMethodBeat.o(231441);
                    return false;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("key_native_url", uVar.url);
                intent2.putExtra("key_username", (String) iVar.a(uVar));
                intent2.putExtra("key_lucky_money_can_received", true);
                intent2.putExtra("key_jump_from", 4);
                intent2.putExtra("scene_id", 1005);
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "luckymoney", ".ui.LuckyMoneyBeforeDetailUI", intent2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(12097, 11, 0, Long.valueOf(System.currentTimeMillis()));
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11850, 4, 1);
                AppMethodBeat.o(231441);
                return true;
            } else {
                AppMethodBeat.o(231441);
                return false;
            }
        }
    }

    @a
    class FeedbackUriSpanHandler extends BaseUriSpanHandler {
        FeedbackUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19702);
            if (str.trim().startsWith("weixin://feedback/next/")) {
                u uVar = new u(str, 34, null);
                AppMethodBeat.o(19702);
                return uVar;
            }
            AppMethodBeat.o(19702);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{34};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231427);
            if (uVar.type == 34) {
                String replace = uVar.url.trim().replace("weixin://feedback/next/", "");
                Log.d("MicroMsg.URISpanHandlerSet", "FeedbackUriSpanHandler, url:%s, content:%s", uVar.url, replace);
                bg.azz().a(new m(com.tencent.mm.compatible.deviceinfo.q.aoL(), replace, 8), 0);
                AppMethodBeat.o(231427);
                return true;
            }
            AppMethodBeat.o(231427);
            return false;
        }
    }

    @a
    class BizMsgMenuUriSpanHandler extends BaseUriSpanHandler {
        BizMsgMenuUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19684);
            if (str.trim().startsWith("weixin://bizmsgmenu")) {
                u uVar = new u(str, 43, null);
                AppMethodBeat.o(19684);
                return uVar;
            }
            AppMethodBeat.o(19684);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{43};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231420);
            if (43 != uVar.type) {
                AppMethodBeat.o(231420);
                return false;
            } else if (Util.isNullOrNil(uVar.username)) {
                Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler Username is null.");
                AppMethodBeat.o(231420);
                return true;
            } else {
                if (uVar.fromScene == 1 && uVar.dTX != null) {
                    com.tencent.mm.al.l.S(uVar.dTX);
                }
                Log.d("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler, url:%s", uVar.url);
                Uri parse = Uri.parse(uVar.url.trim());
                String queryParameter = parse.getQueryParameter("msgmenuid");
                String queryParameter2 = parse.getQueryParameter("msgmenucontent");
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14522, Util.nullAsNil(queryParameter), uVar.username);
                if (Util.isNullOrNil(queryParameter) || Util.isNullOrNil(queryParameter2)) {
                    Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler id or msgContent is null.");
                    AppMethodBeat.o(231420);
                    return true;
                }
                try {
                    String decode = URLDecoder.decode(queryParameter2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    HashMap hashMap = new HashMap();
                    hashMap.put("bizmsgmenuid", queryParameter);
                    o.e Pl = com.tencent.mm.modelmulti.o.Pl(uVar.username);
                    Pl.toUser = uVar.username;
                    Pl.content = decode;
                    o.e tD = Pl.tD(ab.JG(uVar.username));
                    tD.cSx = 1;
                    tD.jdQ = hashMap;
                    tD.jdR = 5;
                    tD.bdQ().execute();
                } catch (UnsupportedEncodingException e2) {
                    Log.w("MicroMsg.URISpanHandlerSet", "BizMsgMenuUriSpanHandler exp, msg = %s", e2.getMessage());
                }
                AppMethodBeat.o(231420);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AAUriSpanHandler extends BaseUriSpanHandler {
        AAUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19675);
            if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/opendetail")) {
                u uVar = new u(str, 35, null);
                AppMethodBeat.o(19675);
                return uVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeurgenotify")) {
                u uVar2 = new u(str, 36, null);
                AppMethodBeat.o(19675);
                return uVar2;
            } else if (str.trim().toLowerCase().startsWith("weixin://weixinnewaa/closeaa")) {
                u uVar3 = new u(str, 37, null);
                AppMethodBeat.o(19675);
                return uVar3;
            } else {
                AppMethodBeat.o(19675);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{35, 36, 37};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            String obj;
            AppMethodBeat.i(231415);
            if (uVar.type == 35) {
                try {
                    Uri parse = Uri.parse(uVar.url);
                    String queryParameter = parse.getQueryParameter("billno");
                    if (Util.isNullOrNil(queryParameter)) {
                        Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                        AppMethodBeat.o(231415);
                        return true;
                    }
                    int i2 = Util.getInt(parse.getQueryParameter("scene"), 3);
                    if (uVar.data instanceof Bundle) {
                        obj = ((Bundle) uVar.data).getString("chatroom_name");
                    } else if (uVar.data instanceof String) {
                        obj = uVar.data.toString();
                    } else {
                        Log.e("MicroMsg.URISpanHandlerSet", "illegal data type, %s", uVar);
                        AppMethodBeat.o(231415);
                        return true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("bill_no", queryParameter);
                    intent.putExtra("enter_scene", i2);
                    intent.putExtra("chatroom", obj);
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "aa", ".ui.PaylistAAUI", intent);
                    AppMethodBeat.o(231415);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa open detail link error: %s, url: %s", e2.getMessage(), uVar.url);
                }
            } else {
                if (uVar.type == 37) {
                    try {
                        final String queryParameter2 = Uri.parse(uVar.url).getQueryParameter("billno");
                        if (Util.isNullOrNil(queryParameter2)) {
                            Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.o(231415);
                            return true;
                        } else if (!(uVar.data instanceof Bundle)) {
                            Log.e("MicroMsg.URISpanHandlerSet", "error data!");
                            AppMethodBeat.o(231415);
                            return true;
                        } else {
                            Bundle bundle = (Bundle) uVar.data;
                            final String string = bundle.getString("chatroom_name");
                            if (Util.isNullOrNil(string)) {
                                Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                                AppMethodBeat.o(231415);
                                return true;
                            }
                            final long j2 = bundle.getLong("msg_id", -1);
                            if (j2 < 0) {
                                Log.e("MicroMsg.URISpanHandlerSet", "msgId is null");
                                AppMethodBeat.o(231415);
                                return true;
                            }
                            com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.hdh, -1, (int) R.string.hdk, (int) R.string.amn, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(19673);
                                    cc ccVar = new cc();
                                    ccVar.dFj.dFk = queryParameter2;
                                    ccVar.dFj.dFl = string;
                                    ccVar.dFj.dFm = j2;
                                    EventCenter.instance.publish(ccVar);
                                    AppMethodBeat.o(19673);
                                }
                            }, (DialogInterface.OnClickListener) null);
                        }
                    } catch (Exception e3) {
                        Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa close link error: %s, url: %s", e3.getMessage(), uVar.url);
                    }
                } else if (uVar.type == 36) {
                    try {
                        final String queryParameter3 = Uri.parse(uVar.url).getQueryParameter("billno");
                        if (Util.isNullOrNil(queryParameter3)) {
                            Log.e("MicroMsg.URISpanHandlerSet", "url error, billno is null");
                            AppMethodBeat.o(231415);
                            return true;
                        }
                        Bundle bundle2 = null;
                        if (uVar.data instanceof Bundle) {
                            bundle2 = (Bundle) uVar.data;
                        }
                        if (bundle2 == null || Util.isNullOrNil(bundle2.getString("chatroom_name"))) {
                            Log.e("MicroMsg.URISpanHandlerSet", "empty chatroom!");
                            AppMethodBeat.o(231415);
                            return true;
                        }
                        final String string2 = bundle2.getString("chatroom_name");
                        final long j3 = bundle2.getLong("msg_id", -1);
                        com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, (int) R.string.hdi, -1, (int) R.string.hdj, (int) R.string.amn, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.app.plugin.URISpanHandlerSet.AAUriSpanHandler.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(19674);
                                cd cdVar = new cd();
                                cdVar.dFn.dFk = queryParameter3;
                                cdVar.dFn.dFl = string2;
                                cdVar.dFn.dFm = j3;
                                EventCenter.instance.publish(cdVar);
                                AppMethodBeat.o(19674);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    } catch (Exception e4) {
                        Log.e("MicroMsg.URISpanHandlerSet", "handle click new aa urge notify link error: %s, url: %s", e4.getMessage(), uVar.url);
                    }
                }
                AppMethodBeat.o(231415);
                return false;
            }
        }
    }

    @a
    class TransferUriSpanHandler extends BaseUriSpanHandler {
        TransferUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19761);
            if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/retrysendmsg")) {
                u uVar = new u(str, 39, null);
                AppMethodBeat.o(19761);
                return uVar;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/rebacksendmsg")) {
                u uVar2 = new u(str, 40, null);
                AppMethodBeat.o(19761);
                return uVar2;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchbalance")) {
                u uVar3 = new u(str, 41, null);
                AppMethodBeat.o(19761);
                return uVar3;
            } else if (str.trim().toLowerCase().startsWith("weixin://wcpay/transfer/watchlqt")) {
                u uVar4 = new u(str, 42, null);
                AppMethodBeat.o(19761);
                return uVar4;
            } else if (str.trim().toLowerCase().startsWith("wechat://wcpay/transfer/transferquery")) {
                u uVar5 = new u(str, 49, null);
                AppMethodBeat.o(19761);
                return uVar5;
            } else if (str.trim().toLowerCase().startsWith("weixin://wxpay/transfer/remindrcvmsg")) {
                u uVar6 = new u(str, 56, null);
                AppMethodBeat.o(19761);
                return uVar6;
            } else {
                AppMethodBeat.o(19761);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{39, 40, 41, 42, 49, 56};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231456);
            if (uVar != null) {
                if (uVar.type == 42) {
                    com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    AppMethodBeat.o(231456);
                    return true;
                } else if (uVar.type == 41) {
                    com.tencent.mm.br.c.V(URISpanHandlerSet.this.mContext, "wallet", ".balance.ui.WalletBalanceManagerUI");
                    AppMethodBeat.o(231456);
                    return true;
                } else if (uVar.type == 39) {
                    if (uVar.data != null && (uVar.data instanceof Bundle)) {
                        final Bundle bundle = (Bundle) uVar.data;
                        ((com.tencent.mm.plugin.wxpaysdk.api.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.wxpaysdk.api.b.class)).a(URISpanHandlerSet.this.mContext, (ResendMsgInfo) bundle.getParcelable("resend_msg_info"), new f.c() {
                            /* class com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(19760);
                                if (z) {
                                    String string = bundle.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                                    String string2 = bundle.getString("transfer_id");
                                    String string3 = bundle.getString("receiver_name");
                                    Intent intent = new Intent();
                                    intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, string);
                                    intent.putExtra("transfer_id", string2);
                                    intent.putExtra("receiver_name", string3);
                                    intent.putExtra("resend_msg_from_flag", 3);
                                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceResendMsgUI", intent);
                                }
                                AppMethodBeat.o(19760);
                            }
                        });
                    }
                    AppMethodBeat.o(231456);
                    return true;
                } else if (uVar.type == 40) {
                    if (uVar.data != null && (uVar.data instanceof Bundle)) {
                        Bundle bundle2 = (Bundle) uVar.data;
                        rp rpVar = new rp();
                        rpVar.dYf.dDM = bundle2.getString(FirebaseAnalytics.b.TRANSACTION_ID);
                        rpVar.dYf.dQp = bundle2.getString("transfer_id");
                        rpVar.dYf.dYg = bundle2.getInt("total_fee");
                        rpVar.dYf.dYh = bundle2.getString("sender_name");
                        EventCenter.instance.publish(rpVar);
                    }
                    AppMethodBeat.o(231456);
                    return true;
                } else if (uVar.type == 49) {
                    Uri parse = Uri.parse(uVar.url);
                    String queryParameter = parse.getQueryParameter("transfer_id");
                    String queryParameter2 = parse.getQueryParameter("trans_id");
                    String str = "";
                    if (uVar.data == null || !(uVar.data instanceof Bundle)) {
                        Log.i("MicroMsg.URISpanHandlerSet", "hrefInfo.getType() == TYPE_TRANSFER_QUERY_MSG senderName == null");
                    } else {
                        str = ((Bundle) uVar.data).getString("sender_name");
                    }
                    Intent intent = new Intent();
                    intent.putExtra("transfer_id", queryParameter);
                    intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, queryParameter2);
                    intent.putExtra("sender_name", str);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                    AppMethodBeat.o(231456);
                    return true;
                } else if (uVar.type == 56) {
                    Uri parse2 = Uri.parse(uVar.url);
                    String queryParameter3 = parse2.getQueryParameter("transferid");
                    String queryParameter4 = parse2.getQueryParameter("fromusername");
                    String queryParameter5 = parse2.getQueryParameter("transfer_msg_type");
                    Log.i("MicroMsg.URISpanHandlerSet", "click MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, transferId: %s，msgType:%s", queryParameter3, queryParameter5);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20467, "transfer_to_change", "click message", "", "", "", "", 3, queryParameter3, queryParameter5);
                    if (!Util.isNullOrNil(queryParameter3) && !Util.isNullOrNil(queryParameter4)) {
                        Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG");
                        com.tencent.mm.plugin.remittance.a.c.eMU();
                        com.tencent.mm.plugin.remittance.b.c aLW = com.tencent.mm.plugin.remittance.a.c.eMW().aLW(queryParameter3);
                        if (aLW == null || aLW.field_locaMsgId <= 0) {
                            Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, cannot find local msg");
                            new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(R.string.g3e)).apb(MMApplicationContext.getContext().getResources().getColor(R.color.x0)).apa(R.string.e2u).b(new f.c() {
                                /* class com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler.AnonymousClass3 */

                                @Override // com.tencent.mm.ui.widget.a.f.c
                                public final void e(boolean z, String str) {
                                }
                            }).show();
                        } else {
                            Log.i("MicroMsg.URISpanHandlerSet", "handle MSpanConstants.Type.TYPE_TRANSFER_REMINDE_RECEIVE_MSG, localMsgId: %s", Long.valueOf(aLW.field_locaMsgId));
                            if (((l) com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(aLW.field_locaMsgId).field_msgId <= 0) {
                                Log.i("MicroMsg.URISpanHandlerSet", "cannot find msg in msg storage!");
                                new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(R.string.g3e)).apb(MMApplicationContext.getContext().getResources().getColor(R.color.x0)).apa(R.string.e2u).b(new f.c() {
                                    /* class com.tencent.mm.app.plugin.URISpanHandlerSet.TransferUriSpanHandler.AnonymousClass2 */

                                    @Override // com.tencent.mm.ui.widget.a.f.c
                                    public final void e(boolean z, String str) {
                                    }
                                }).show();
                            } else {
                                tr trVar = new tr();
                                trVar.eae.msgId = aLW.field_locaMsgId;
                                trVar.eae.dkU = queryParameter4;
                                EventCenter.instance.publish(trVar);
                            }
                        }
                    }
                    AppMethodBeat.o(231456);
                    return true;
                }
            }
            AppMethodBeat.o(231456);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }

    @a
    class AppBrandLinkSpanHandler extends BaseUriSpanHandler {
        AppBrandLinkSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{45};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231418);
            if (uVar.type == 45) {
                if (uVar.fromScene == 1 && uVar.dTX != null) {
                    com.tencent.mm.al.l.S(uVar.dTX);
                }
                if (iVar != null) {
                    Log.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
                    iVar.b(uVar);
                    AppMethodBeat.o(231418);
                    return true;
                }
                Log.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
            }
            AppMethodBeat.o(231418);
            return false;
        }
    }

    @a
    class HoneyPayLinkSpanHandler extends BaseUriSpanHandler {
        HoneyPayLinkSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(19717);
            if (str.trim().startsWith("native://wcpay/honeypay")) {
                u uVar = new u(str, 46, null);
                AppMethodBeat.o(19717);
                return uVar;
            } else if (str.trim().startsWith("weixin://wcpay/bankCardList")) {
                u uVar2 = new u(str, 47, null);
                AppMethodBeat.o(19717);
                return uVar2;
            } else {
                AppMethodBeat.o(19717);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{46, 47};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231433);
            if (uVar.type == 46) {
                Log.i("MicroMsg.URISpanHandlerSet", "go to honey pay proxy");
                if (uVar.data != null && (uVar.data instanceof Bundle)) {
                    Uri parse = Uri.parse(uVar.url);
                    String queryParameter = parse.getQueryParameter("cardNo");
                    boolean equals = parse.getQueryParameter("isPayer").equals("1");
                    Intent intent = new Intent();
                    intent.putExtra("key_card_no", queryParameter);
                    intent.putExtra("key_is_payer", equals);
                    com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "honey_pay", ".ui.HoneyPayProxyUI", intent);
                }
            } else if (uVar.type == 47) {
                Log.i("MicroMsg.URISpanHandlerSet", "go to bank card list");
                Intent intent2 = new Intent();
                intent2.putExtra("intent_finish_self", true);
                com.tencent.mm.br.c.b(URISpanHandlerSet.this.mContext, "wallet", ".bind.ui.WalletBankcardManageUI", intent2);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 1);
            }
            AppMethodBeat.o(231433);
            return false;
        }
    }

    @a
    class OfflineFQFSpanHandler extends BaseUriSpanHandler {
        OfflineFQFSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(169680);
            if (str.trim().startsWith("weixin://wcpay/fqf/opentinyapp")) {
                u uVar = new u(str, 51, null);
                AppMethodBeat.o(169680);
                return uVar;
            }
            AppMethodBeat.o(169680);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{51};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231442);
            if (uVar.type == 51) {
                Log.i("MicroMsg.URISpanHandlerSet", "go to offline fqf");
                if (uVar.data != null && (uVar.data instanceof Bundle)) {
                    Bundle bundle = (Bundle) uVar.data;
                    String string = bundle.getString("repayment_tiny_app_username");
                    String string2 = bundle.getString("repayment_tiny_app_path");
                    wq wqVar = new wq();
                    wqVar.ecI.userName = string;
                    wqVar.ecI.ecK = Util.nullAs(string2, "");
                    wqVar.ecI.ecL = 0;
                    EventCenter.instance.publish(wqVar);
                }
                if (iVar != null) {
                    iVar.b(uVar);
                }
            }
            AppMethodBeat.o(231442);
            return false;
        }
    }

    @a
    class UnKnowToUrlSpanHandler extends BaseUriSpanHandler {
        UnKnowToUrlSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{2147483646};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231457);
            if (uVar.type == 2147483646) {
                if (uVar.data instanceof Bundle) {
                    String string = ((Bundle) uVar.data).getString("rawUrl");
                    if (Util.isNullOrNil(string)) {
                        Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL url == null");
                    } else {
                        com.tencent.mm.plugin.account.a.b.a.b(MMApplicationContext.getContext(), string, 0, true);
                    }
                } else {
                    Log.i("MicroMsg.URISpanHandlerSet", "TYPE_UNKNOW_TO_URL hrefInfo.getData() no instanceof Bundle");
                }
                AppMethodBeat.o(231457);
                return true;
            }
            AppMethodBeat.o(231457);
            return false;
        }
    }

    @a
    class WeWorkUrlSpanHandler extends BaseUriSpanHandler {
        private final String dol = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2o) + "/wework_admin/commdownload");

        WeWorkUrlSpanHandler() {
            super();
            AppMethodBeat.i(231461);
            AppMethodBeat.o(231461);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(179567);
            if (str.trim().toLowerCase().startsWith("wxwork://jump?")) {
                u uVar = new u(str, 52, null);
                AppMethodBeat.o(179567);
                return uVar;
            }
            AppMethodBeat.o(179567);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{52};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        private static String getAppName(Context context, String str) {
            AppMethodBeat.i(179569);
            PackageManager packageManager = context.getPackageManager();
            try {
                String charSequence = packageManager.getApplicationInfo(str, 0).loadLabel(packageManager).toString();
                AppMethodBeat.o(179569);
                return charSequence;
            } catch (PackageManager.NameNotFoundException e2) {
                AppMethodBeat.o(179569);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231462);
            if (uVar.type == 52) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(uVar.url));
                intent.setPackage("com.tencent.wework");
                intent.setFlags(268435456);
                try {
                    boolean b2 = com.tencent.mm.pluginsdk.model.app.h.b(MMApplicationContext.getContext(), intent, getAppName(MMApplicationContext.getContext(), "com.tencent.wework"));
                    if (!b2) {
                        com.tencent.mm.plugin.account.a.b.a.b(MMApplicationContext.getContext(), this.dol, 0, true);
                    }
                    Log.i("MicroMsg.URISpanHandlerSet", "WeWorkUrlSpanHandler result:%s", Boolean.valueOf(b2));
                    AppMethodBeat.o(231462);
                    return true;
                } catch (Exception e2) {
                    AppMethodBeat.o(231462);
                    return false;
                }
            } else {
                AppMethodBeat.o(231462);
                return false;
            }
        }
    }

    @a
    class UpgradeAssociateChatRoomUrlSpanHandler extends BaseUriSpanHandler {
        UpgradeAssociateChatRoomUrlSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(179565);
            if (str.trim().toLowerCase().startsWith("weixin://weixingroupupdate?")) {
                u uVar = new u(str, 53, null);
                AppMethodBeat.o(179565);
                return uVar;
            }
            AppMethodBeat.o(179565);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{53};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231458);
            if (uVar.type == 53) {
                Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl");
                try {
                    String queryParameter = Uri.parse(uVar.url).getQueryParameter("roomname");
                    if (Util.isNullOrNil(queryParameter)) {
                        Log.w("MicroMsg.URISpanHandlerSet", "Username is null.");
                        AppMethodBeat.o(231458);
                        return true;
                    }
                    if (ab.Eq(queryParameter)) {
                        com.tencent.mm.storage.ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(queryParameter);
                        if (Kd == null) {
                            Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl %s member is null", queryParameter);
                            AppMethodBeat.o(231458);
                            return true;
                        }
                        Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl room:%s chatroomStatus:%s owener:%s", queryParameter, Integer.valueOf(Kd.field_chatroomStatus), Util.nullAs(Kd.field_roomowner, ""));
                        boolean z = Kd.field_memberCount >= v.aTT();
                        if (ab.ID(queryParameter)) {
                            if (!Kd.JO(z.aTY())) {
                                Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：no owner");
                                if (URISpanHandlerSet.this.mContext != null) {
                                    com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.ax0), "", URISpanHandlerSet.this.mContext.getString(R.string.w0), false, (DialogInterface.OnClickListener) null);
                                } else {
                                    Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
                                }
                                int i2 = 1;
                                if (z) {
                                    i2 = 3;
                                }
                                ManagerRoomByWeworkUI.c(queryParameter, 2, 2, i2);
                                AppMethodBeat.o(231458);
                                return true;
                            }
                        } else if (ab.IB(queryParameter) && !Kd.JO(z.aTY())) {
                            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：isAssociateChatRoom ");
                            if (URISpanHandlerSet.this.mContext != null) {
                                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.awx), "", URISpanHandlerSet.this.mContext.getString(R.string.w0), false, (DialogInterface.OnClickListener) null);
                            } else {
                                Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
                            }
                            AppMethodBeat.o(231458);
                            return true;
                        }
                        if (z) {
                            Log.i("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：exceed maxnum");
                            if (URISpanHandlerSet.this.mContext != null) {
                                com.tencent.mm.ui.base.h.a(URISpanHandlerSet.this.mContext, URISpanHandlerSet.this.mContext.getString(R.string.awy), "", URISpanHandlerSet.this.mContext.getString(R.string.w0), false, (DialogInterface.OnClickListener) null);
                            } else {
                                Log.e("MicroMsg.URISpanHandlerSet", "handleClickUpgradeAssociateChatRoomUrl：mContext is null");
                            }
                            ManagerRoomByWeworkUI.c(queryParameter, 2, 2, 2);
                            AppMethodBeat.o(231458);
                            return true;
                        }
                        com.tencent.mm.plugin.newtips.a.exl().TC(25);
                        com.tencent.mm.plugin.newtips.a.exl().TC(26);
                        com.tencent.mm.plugin.newtips.a.exl().TC(27);
                        Intent intent = new Intent();
                        intent.setClass(MMApplicationContext.getContext(), ManagerRoomByWeworkUI.class);
                        intent.addFlags(268435456);
                        intent.putExtra("RoomInfo_Id", queryParameter);
                        intent.putExtra("upgrade_openim_room_from_scene", 2);
                        Context context = MMApplicationContext.getContext();
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$UpgradeAssociateChatRoomUrlSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    }
                    AppMethodBeat.o(231458);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", e2.getMessage(), uVar.url);
                }
            } else {
                AppMethodBeat.o(231458);
                return false;
            }
        }
    }

    @a
    class TodoSystemMsgUrlSpanHandler extends BaseUriSpanHandler {
        TodoSystemMsgUrlSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(179563);
            if (str.trim().toLowerCase().startsWith("weixin://roomtoolstodo?")) {
                u uVar = new u(str, 54, null);
                AppMethodBeat.o(179563);
                return uVar;
            }
            AppMethodBeat.o(179563);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{54};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            boolean z;
            AppMethodBeat.i(231454);
            if (uVar.type == 54) {
                Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl");
                try {
                    Uri parse = Uri.parse(uVar.url);
                    String str = uVar.chatroomName;
                    String queryParameter = parse.getQueryParameter("todoid");
                    parse.getQueryParameter("related_msgid");
                    String queryParameter2 = parse.getQueryParameter(ch.COL_USERNAME);
                    String queryParameter3 = parse.getQueryParameter("path");
                    com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(str, queryParameter);
                    if (Util.isEqual("roomannouncement@app.origin", queryParameter2)) {
                        y.f(MMApplicationContext.getContext(), str, true);
                    } else {
                        com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                        gVar.username = queryParameter2;
                        gVar.kHw = queryParameter3;
                        gVar.scene = 1160;
                        gVar.kHG = str;
                        if (ai != null) {
                            gVar.cyr = ai.field_shareKey;
                            gVar.cyq = ai.field_shareName;
                        }
                        ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(URISpanHandlerSet.this.mContext, gVar);
                    }
                    boolean e2 = y.e(ai);
                    if (e2) {
                        boolean b2 = y.b(ai);
                        if (b2) {
                            nt ntVar = new nt();
                            ntVar.dTT.op = 3;
                            ntVar.dTT.dOe = ai.field_roomname;
                            ntVar.dTT.dTU = queryParameter;
                            EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
                        }
                        z = b2;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.chatroom.d.z.a(str, Util.isEqual("roomannouncement@app.origin", queryParameter2) ? 1 : 0, 2, queryParameter, queryParameter2);
                    Log.i("MicroMsg.URISpanHandlerSet", "handleClickTodoSystemMsgUrl stoTodo(%s %s %s) update finish(%s)", Boolean.valueOf(Util.isNullOrNil(queryParameter)), Boolean.valueOf(Util.isNullOrNil(queryParameter2)), Boolean.valueOf(e2), Boolean.valueOf(z));
                } catch (Exception e3) {
                    Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", e3.getMessage(), uVar.url);
                }
                AppMethodBeat.o(231454);
                return true;
            }
            AppMethodBeat.o(231454);
            return false;
        }
    }

    @a
    class EnterChatRoomUriSpanHandler extends BaseUriSpanHandler {
        EnterChatRoomUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(231424);
            if (str.trim().toLowerCase().startsWith("weixin://jump/chatroom/")) {
                u uVar = new u(str, 55, null);
                AppMethodBeat.o(231424);
                return uVar;
            }
            AppMethodBeat.o(231424);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{55};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231425);
            if (uVar.type == 55) {
                Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl");
                try {
                    String str = uVar.url;
                    int lastIndexOf = str.trim().lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                    if (lastIndexOf >= 0 && lastIndexOf < str.trim().length() - 1) {
                        String substring = str.trim().substring(lastIndexOf + 1);
                        if (ab.Eq(substring)) {
                            bg.aVF();
                            as Kn = com.tencent.mm.model.c.aSN().Kn(substring);
                            if (Kn == null || ((int) Kn.gMZ) == 0) {
                                as asVar = new as();
                                asVar.setUsername(substring);
                                bg.aVF();
                                com.tencent.mm.model.c.aSN().ap(asVar);
                            }
                        }
                        Intent putExtra = new Intent(URISpanHandlerSet.this.mContext, ChattingUI.class).putExtra("Chat_User", substring).putExtra("Chat_Mode", 1);
                        if (URISpanHandlerSet.this.mContext instanceof Service) {
                            putExtra.addFlags(268435456);
                        }
                        Context context = URISpanHandlerSet.this.mContext;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$EnterChatRoomUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        if (uVar.fRg == 1) {
                            String nullAs = Util.nullAs(uVar.chatroomName, "");
                            com.tencent.mm.chatroom.c.b.f(Util.nullAs(substring, ""), nullAs, 3);
                            Log.i("MicroMsg.URISpanHandlerSet", "handleClickEnterChatRoomSystemMsgUrl migrate(%s -> %s)", nullAs, Util.nullAs(substring, ""));
                        }
                        AppMethodBeat.o(231425);
                        return true;
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.URISpanHandlerSet", "handle click link error: %s, url: %s", e2.getMessage(), uVar.url);
                }
            }
            AppMethodBeat.o(231425);
            return false;
        }
    }

    @a
    class JumpPatSettingDialogUriSpanHandler extends BaseUriSpanHandler {
        JumpPatSettingDialogUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(231436);
            if (str.trim().toLowerCase().startsWith("weixin://jump/setpat_bottom_sheet/")) {
                u uVar = new u(str, 61, null);
                AppMethodBeat.o(231436);
                return uVar;
            }
            AppMethodBeat.o(231436);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{61};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231437);
            if (uVar.type == 61) {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                ((czj) SecDataUIC.a.c(view.getContext(), 4, czj.class)).MEF = 1;
                com.tencent.mm.plugin.patmsg.ui.b bVar = new com.tencent.mm.plugin.patmsg.ui.b(view.getContext());
                bVar.show();
                bVar.getWindow().setLayout(-1, -1);
            }
            AppMethodBeat.o(231437);
            return false;
        }
    }

    @a
    class JumpPatSettingUriSpanHandler extends BaseUriSpanHandler {
        JumpPatSettingUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(231439);
            if (str.trim().toLowerCase().startsWith("weixin://jump/setpat/")) {
                u uVar = new u(str, 57, null);
                AppMethodBeat.o(231439);
                return uVar;
            }
            AppMethodBeat.o(231439);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{57};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231440);
            if (uVar.type == 57) {
                Log.i("MicroMsg.URISpanHandlerSet", "handleClickJumpToPatSetting");
                Intent intent = new Intent();
                intent.setClass(URISpanHandlerSet.this.mContext, SettingsPersonalInfoUI.class);
                intent.putExtra("jumptoPat", true);
                Context context = URISpanHandlerSet.this.mContext;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/app/plugin/URISpanHandlerSet$JumpPatSettingUriSpanHandler", "handleSpanClick", "(Landroid/view/View;Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickCallback;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.app.plugin.URISpanHandlerSet.JumpPatSettingUriSpanHandler.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(231438);
                    LauncherUI instance = LauncherUI.getInstance();
                    if (instance != null) {
                        instance.closeChatting(false);
                        instance.ODR.getMainTabUI().blU("tab_settings");
                    }
                    AppMethodBeat.o(231438);
                }
            }, 2000);
            AppMethodBeat.o(231440);
            return false;
        }
    }

    @a
    class WxaShortLinkUriSpanHandler extends BaseUriSpanHandler {
        WxaShortLinkUriSpanHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final u gx(String str) {
            AppMethodBeat.i(231463);
            if (str.trim().toLowerCase().startsWith("mp://")) {
                u uVar = new u(str, 60, null);
                AppMethodBeat.o(231463);
                return uVar;
            }
            AppMethodBeat.o(231463);
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final int[] Xp() {
            return new int[]{60};
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(View view, u uVar, i iVar) {
            AppMethodBeat.i(231464);
            Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] handleSpanClick ");
            Object obj = uVar.data;
            if (obj instanceof Bundle) {
                String string = ((Bundle) obj).getString("key_wxa_short_link_launch_scene", "");
                if (string.isEmpty()) {
                    Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] scene is null ");
                    if (BuildInfo.IS_FLAVOR_RED) {
                        Error error = new Error("[WxaShortLinkUriSpanHandler]  scene must not is null");
                        AppMethodBeat.o(231464);
                        throw error;
                    }
                } else {
                    t.b valueOf = t.b.valueOf(string);
                    Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] sceneName=%s  scene=%d  preScene=%d", string, Integer.valueOf(valueOf.Kss), Integer.valueOf(valueOf.Kst));
                    AppBrandCheckWxaShortLinkUI.a(URISpanHandlerSet.this.mContext, uVar.url, valueOf);
                }
            } else {
                Log.i("MicroMsg.URISpanHandlerSet", "[WxaShortLinkUriSpanHandler] HrefInfo has not data");
                if (BuildInfo.IS_FLAVOR_RED) {
                    Error error2 = new Error("[WxaShortLinkUriSpanHandler] HrefInfo has not data");
                    AppMethodBeat.o(231464);
                    throw error2;
                }
            }
            AppMethodBeat.o(231464);
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler
        public final boolean a(String str, boolean z, com.tencent.mm.pluginsdk.u uVar, Bundle bundle) {
            return false;
        }
    }
}
