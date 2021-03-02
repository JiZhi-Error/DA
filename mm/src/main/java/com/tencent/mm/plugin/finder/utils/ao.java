package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.dc;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.ap;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J*\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\"\u0010\u000e\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J2\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderOpenSdkApi;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderOpenSdkApi;", "()V", "TAG", "", "openFeed", "", "context", "Landroid/content/Context;", "appid", "feedId", "nonceId", "notGetRelatedList", "openLive", "openProfile", ch.COL_USERNAME, "shareVideo", "path", "desc", "extendingUrl", "plugin-finder_release"})
public final class ao implements ap {
    private static final String TAG = TAG;
    public static final ao UVd = new ao();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "ret", "", "kotlin.jvm.PlatformType", "onCallback", "(Ljava/lang/Integer;)V"})
    static final class a<T> implements af.a<Integer> {
        public static final a UVe = new a();

        static {
            AppMethodBeat.i(261464);
            AppMethodBeat.o(261464);
        }

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Integer num) {
            AppMethodBeat.i(261463);
            ao aoVar = ao.UVd;
            Log.i(ao.TAG, "openLive failed, errCode: ".concat(String.valueOf(num)));
            AppMethodBeat.o(261463);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPageResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String pmd;

        c(String str, Context context) {
            this.pmd = str;
            this.$context = context;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            String str;
            AppMethodBeat.i(261467);
            c.a aVar = (c.a) obj;
            if (aVar.errType == 0 && aVar.errCode == 0) {
                FinderContact finderContact = ((FinderUserPageResponse) aVar.iLC).contact;
                String str2 = finderContact != null ? finderContact.username : null;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    ao aoVar = ao.UVd;
                    Log.i(ao.TAG, "realUsername:".concat(String.valueOf(str2)));
                    String str4 = this.pmd;
                    Intent intent = new Intent();
                    intent.putExtra("finder_username", str2);
                    intent.putExtra("key_extra_info", str4);
                    String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(11, 8, 32, intent);
                    if (!Util.isNullOrNil(this.pmd)) {
                        h hVar = h.INSTANCE;
                        Object[] objArr = new Object[4];
                        if (fillContextIdToIntent == null) {
                            str = "";
                        } else {
                            str = fillContextIdToIntent;
                        }
                        objArr[0] = str;
                        objArr[1] = this.pmd;
                        objArr[2] = 0;
                        objArr[3] = str2;
                        hVar.a(21140, objArr);
                    }
                    com.tencent.mm.plugin.expt.hellhound.core.b.aoW(fillContextIdToIntent);
                    a aVar2 = a.vUU;
                    a.enterFinderProfileUI(this.$context, intent);
                } else {
                    ao aoVar2 = ao.UVd;
                    Log.i(ao.TAG, "realUsername empty");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(261467);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(261472);
        AppMethodBeat.o(261472);
    }

    private ao() {
    }

    @Override // com.tencent.mm.plugin.i.a.ap
    public final void I(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(261468);
        p.h(str, "appid");
        p.h(str2, "path");
        p.h(str3, "desc");
        p.h(str4, "extendingUrl");
        JSONObject jSONObject = new JSONObject();
        r rVar = r.vWn;
        jSONObject.put(r.dCc(), str2);
        r rVar2 = r.vWn;
        jSONObject.put(r.dCd(), "");
        r rVar3 = r.vWn;
        jSONObject.put(r.dCe(), 1);
        r rVar4 = r.vWn;
        jSONObject.put(r.dCf(), "");
        r rVar5 = r.vWn;
        jSONObject.put(r.hVu(), str3);
        r rVar6 = r.vWn;
        jSONObject.put(r.hVv(), str4);
        Intent intent = new Intent();
        dxx dxx = new dxx();
        dxx.vjQ = 2;
        dqh dqh = new dqh();
        dqh.businessType = "";
        dqh.dNI = str;
        dqh.extInfo = jSONObject.toString();
        dqh.UJy = true;
        dxx.MXA = dqh;
        intent.putExtra("KEY_POST_FROM_SHARE", dxx.toByteArray());
        a aVar = a.vUU;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        a.x(context, intent);
        AppMethodBeat.o(261468);
    }

    @Override // com.tencent.mm.plugin.i.a.ap
    public final void ae(Context context, String str, String str2) {
        AppMethodBeat.i(261469);
        p.h(str, "appid");
        p.h(str2, ch.COL_USERNAME);
        if (context == null) {
            Log.i(TAG, "openProfile context null");
            AppMethodBeat.o(261469);
            return;
        }
        Log.i(TAG, "openProfile appid:" + str + ", username:" + str2);
        new dc(str2).aYI().g(new c(str, context));
        AppMethodBeat.o(261469);
    }

    @Override // com.tencent.mm.plugin.i.a.ap
    public final void i(Context context, String str, String str2, String str3) {
        String str4;
        AppMethodBeat.i(261470);
        p.h(str, "appid");
        p.h(str2, "feedId");
        p.h(str3, "nonceId");
        if (context == null) {
            Log.i(TAG, "openLive context null");
            AppMethodBeat.o(261470);
            return;
        }
        Log.i(TAG, "openLive appid:" + str + ", feedId:" + str2 + ", nonceId:" + str3);
        String genContextId = ((aj) g.ah(aj.class)).genContextId(11, 8, 65);
        if (!Util.isNullOrNil(new String[0])) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[4];
            if (genContextId == null) {
                str4 = "";
            } else {
                str4 = genContextId;
            }
            objArr[0] = str4;
            objArr[1] = str;
            objArr[2] = "";
            objArr[3] = "";
            hVar.a(21140, objArr);
        }
        m mVar = m.vli;
        m.auP(str);
        com.tencent.mm.plugin.expt.hellhound.core.b.aoW(genContextId);
        p.g(genContextId, "contextId");
        new z().a("", str2, a.UVe, str3, 0, b.UVf, genContextId, str);
        AppMethodBeat.o(261470);
    }

    @Override // com.tencent.mm.plugin.i.a.ap
    public final void b(Context context, String str, String str2, String str3, String str4) {
        AppMethodBeat.i(261471);
        p.h(str, "appid");
        p.h(str2, "feedId");
        p.h(str3, "nonceId");
        if (context == null) {
            Log.i(TAG, "openFeed context null");
            AppMethodBeat.o(261471);
            return;
        }
        Log.i(TAG, "openFeed appid:" + str + ", feedId:" + str2 + ", nonceId:" + str3 + ", notGetRelatedList:" + str4);
        boolean j2 = p.j(str4, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Intent intent = new Intent();
        intent.putExtra("from_user", z.aTY());
        intent.putExtra("feed_encrypted_object_id", str2);
        intent.putExtra("feed_object_nonceId", str3);
        intent.putExtra("key_need_related_list", j2);
        intent.putExtra("key_comment_scene", 39);
        intent.putExtra("key_reuqest_scene", 0);
        intent.putExtra("key_session_id", "");
        intent.putExtra("key_extra_info", "");
        String fillContextIdToIntent = ((aj) g.ah(aj.class)).fillContextIdToIntent(11, 8, 39, intent);
        if (!Util.isNullOrNil(str)) {
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[4];
            if (fillContextIdToIntent == null) {
                fillContextIdToIntent = "";
            }
            objArr[0] = fillContextIdToIntent;
            objArr[1] = str;
            objArr[2] = str2;
            objArr[3] = "";
            hVar.a(21140, objArr);
        }
        intent.putExtra("report_scene", 0);
        intent.putExtra("tab_type", 9);
        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avn("entrance") != 0) {
            a aVar2 = a.vUU;
            a.fw(context);
            AppMethodBeat.o(261471);
            return;
        }
        a aVar3 = a.vUU;
        a.F(context, intent);
        d.INSTANCE.asyncReportFinderSecurityInfoThroughCgi(540999685);
        AppMethodBeat.o(261471);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class b<T> implements af.a<Void> {
        public static final b UVf = new b();

        static {
            AppMethodBeat.i(261466);
            AppMethodBeat.o(261466);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.i.a.af.a
        public final /* synthetic */ void bn(Void r4) {
            AppMethodBeat.i(261465);
            ao aoVar = ao.UVd;
            Log.i(ao.TAG, "openLive succ");
            AppMethodBeat.o(261465);
        }
    }
}
