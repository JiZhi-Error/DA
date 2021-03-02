package com.tencent.mm.plugin.finder.feed.logic;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0004J*\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eJ9\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u0015¢\u0006\u0002\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/logic/FinderExposeLogic;", "", "()V", "LIVE_EXPOSE_URL", "", "getLIVE_EXPOSE_URL", "()Ljava/lang/String;", "TAG", "getTAG", "exposeActivity", "", "context", "Landroid/content/Context;", "topicId", "", "exposeBgm", "groupId", "exposeFeed", "feedId", "commentId", "exposeScene", "", "exposeMegaVideoBullet", "bulletId", "liveExpose", "liveId", ch.COL_USERNAME, "commentSeq", "scene", "(Landroid/content/Context;JLjava/lang/String;Ljava/lang/Long;I)V", "plugin-finder_release"})
public final class a {
    private static final String TAG = TAG;
    private static final String tUu = tUu;
    public static final a tUv = new a();

    static {
        AppMethodBeat.i(166010);
        AppMethodBeat.o(166010);
    }

    private a() {
    }

    public static /* synthetic */ void a(Context context, long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(244532);
        a(context, j2, (i3 & 4) != 0 ? 0 : j3, (i3 & 8) != 0 ? 58 : i2);
        AppMethodBeat.o(244532);
    }

    public static void a(Context context, long j2, long j3, int i2) {
        com.tencent.mm.plugin.finder.event.a b2;
        AppMethodBeat.i(244531);
        p.h(context, "context");
        e.INSTANCE.idkeyStat(1278, 8, 1, false);
        ae aeVar = ae.SYK;
        String format = String.format(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2l) + "/security/readtemplate?t=weixin_report/w_type&scene=%s&wechat_real_lang=%s&content_ID=%s&comment_ID=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i2), LocaleUtil.getApplicationLanguage(), d.zs(j2), d.zs(j3)}, 4));
        p.g(format, "java.lang.String.format(format, *args)");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", format);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        k kVar = k.vfA;
        FinderItem Fc = k.Fc(j2);
        if (Fc != null) {
            FinderObject feedObject = Fc.getFeedObject();
            String str = ((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD() + ',' + k.Fg(feedObject.id) + ',' + feedObject.username + ',' + feedObject.recommendType + ',' + Fc.getMediaType();
            Log.i(k.TAG, "18974 ".concat(String.valueOf(str)));
            e.INSTANCE.kvStat(18974, str);
        }
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (fH == null || (b2 = FinderReporterUIC.b(fH)) == null) {
            AppMethodBeat.o(244531);
            return;
        }
        b2.cZR().Ex(j2);
        AppMethodBeat.o(244531);
    }

    public static /* synthetic */ void b(Context context, long j2, String str) {
        AppMethodBeat.i(244534);
        a(context, j2, str, (Long) null, 62);
        AppMethodBeat.o(244534);
    }

    public static void a(Context context, long j2, String str, Long l, int i2) {
        String str2;
        AppMethodBeat.i(244533);
        p.h(context, "context");
        p.h(str, ch.COL_USERNAME);
        Log.i(TAG, "liveExpose liveId:" + j2 + ",username:" + str + ",commentSeq:" + l);
        Intent intent = new Intent();
        intent.putExtra("showShare", false);
        ae aeVar = ae.SYK;
        String str3 = tUu;
        Object[] objArr = new Object[4];
        objArr[0] = 62;
        objArr[1] = Long.valueOf(j2);
        objArr[2] = str;
        if (l == null || (str2 = String.valueOf(l.longValue())) == null) {
            str2 = "";
        }
        objArr[3] = str2;
        String format = String.format(str3, Arrays.copyOf(objArr, 4));
        p.g(format, "java.lang.String.format(format, *args)");
        intent.putExtra("rawUrl", format);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(244533);
    }

    public static void aC(Context context, String str) {
        AppMethodBeat.i(244535);
        p.h(context, "context");
        p.h(str, "groupId");
        ae aeVar = ae.SYK;
        String format = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=64&wechat_real_lang=%s&topic_wording=%s", Arrays.copyOf(new Object[]{LocaleUtil.getApplicationLanguage(), str}, 2));
        p.g(format, "java.lang.String.format(format, *args)");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", format);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(244535);
    }

    public static void i(Context context, long j2) {
        AppMethodBeat.i(244536);
        p.h(context, "context");
        ae aeVar = ae.SYK;
        String format = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=68&topic_id=%s", Arrays.copyOf(new Object[]{d.zs(j2)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", format);
        c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(244536);
    }
}
