package com.tencent.mm.plugin.websearch.a;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lj;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J>\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic;", "", "()V", "TAG", "", "genTagSearchUrl", NativeProtocol.WEB_DIALOG_PARAMS, "", "putCommonUrlParams", "", "startTagSearchDialog", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "context", "Landroid/content/Context;", "talker", "enterType", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", SearchIntents.EXTRA_QUERY, "sessionId", "cursorIndex", "ui-websearch_release"})
public final class c {
    public static final c IFY = new c();
    public static final String TAG = TAG;

    static {
        AppMethodBeat.i(197950);
        AppMethodBeat.o(197950);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/websearch/tagsearch/TagSearchUILogic$startTagSearchDialog$listenerWrapper$1", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "appendSearchTag", "", "tag", "", "enterType", "", "onDismiss", "onSearchShare", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "ui-websearch_release"})
    public static final class a implements com.tencent.mm.plugin.websearch.a.a.a {
        final /* synthetic */ String $sessionId;
        final /* synthetic */ com.tencent.mm.plugin.websearch.a.a.a IFZ;
        final /* synthetic */ z.f IGa;
        final /* synthetic */ int IGb = 2;
        final /* synthetic */ String vdJ;

        public a(com.tencent.mm.plugin.websearch.a.a.a aVar, z.f fVar, String str, String str2) {
            this.IFZ = aVar;
            this.IGa = fVar;
            this.vdJ = str;
            this.$sessionId = str2;
        }

        @Override // com.tencent.mm.plugin.websearch.a.a.a
        public final void onDismiss() {
            long j2 = 2;
            AppMethodBeat.i(197945);
            this.IFZ.onDismiss();
            lj ljVar = new lj();
            ljVar.aiB();
            if (this.IGa.SYG.Ngq == 1) {
                ljVar.uR(1);
            } else {
                ljVar.uR(2);
            }
            ljVar.uS((long) this.IGb);
            ljVar.uT((long) cl.aWB());
            if (!ab.Eq(this.vdJ)) {
                j2 = 1;
            }
            ljVar.uU(j2);
            ljVar.yD(this.vdJ);
            ljVar.yE(this.$sessionId);
            ljVar.yF(this.IGa.SYG.dDv);
            ljVar.bfK();
            ar.a(ljVar);
            c cVar = c.IFY;
            Log.i(c.TAG, "stopTagSearchDialog url:" + this.IGa.SYG.url);
            AppMethodBeat.o(197945);
        }

        @Override // com.tencent.mm.plugin.websearch.a.a.a
        public final void gf(String str, int i2) {
            AppMethodBeat.i(197946);
            p.h(str, "tag");
            this.IFZ.gf(str, i2);
            AppMethodBeat.o(197946);
        }

        @Override // com.tencent.mm.plugin.websearch.a.a.a
        public final void a(buv buv) {
            AppMethodBeat.i(197947);
            p.h(buv, "shareContent");
            this.IFZ.a(buv);
            this.IGa.SYG.Ngq = 1;
            AppMethodBeat.o(197947);
        }
    }

    public static String bf(Map<String, String> map) {
        AppMethodBeat.i(197948);
        p.h(map, NativeProtocol.WEB_DIALOG_PARAMS);
        at afr = ai.afr(6);
        p.g(afr, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_TAGSEARCH)");
        String fYv = afr.fYv();
        bg(map);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(fYv);
        stringBuffer.append("?");
        stringBuffer.append(ai.toUrlParams(map));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(197948);
        return stringBuffer2;
    }

    public static void bg(Map<String, String> map) {
        AppMethodBeat.i(197949);
        String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        p.g(currentLanguage, "LocaleUtil.getCurrentLan…tionContext.getContext())");
        map.put("lang", currentLanguage);
        map.put(TPDownloadProxyEnum.USER_PLATFORM, "android");
        map.put("version", String.valueOf(ai.aft(6)));
        String ait = ai.ait();
        p.g(ait, "WebSearchApiLogic.getNetType()");
        map.put(DownloadInfo.NETTYPE, ait);
        String str = BuildInfo.CLIENT_VERSION;
        p.g(str, "BuildInfo.CLIENT_VERSION");
        map.put("wechatVersion", str);
        AppMethodBeat.o(197949);
    }
}
