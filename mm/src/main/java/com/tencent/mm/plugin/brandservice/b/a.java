package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0005\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u00112\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aJ\u0006\u0010\u001b\u001a\u00020\u000bJ\u0016\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J0\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0006J&\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/model/BizPayLogic;", "", "()V", "TAG", "", "isPayReadingOpen", "", "()I", "setPayReadingOpen", "(I)V", "payMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getPayMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "setPayMMkv", "(Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V", "appMsgPaySuccess", "", "url", "itemShowType", "getPayIcon", "scene", "isPaid", "", "onPaySuccessNotify", "values", "", "payMmkv", "setPayStatus", "setPayStatusById", "id", "setTitleText", "text", "", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "isPaySubscribe", "item", "Lcom/tencent/mm/message/BizReaderItem;", "plugin-brandservice_release"})
public final class a {
    private static final String TAG = TAG;
    private static MultiProcessMMKV pmR;
    private static int pmS = -1;
    public static final a pmT = new a();

    static {
        AppMethodBeat.i(6497);
        AppMethodBeat.o(6497);
    }

    private a() {
    }

    private static MultiProcessMMKV clq() {
        int azs;
        MultiProcessMMKV mmkv;
        AppMethodBeat.i(6488);
        if (pmR != null) {
            mmkv = pmR;
            if (mmkv == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
                AppMethodBeat.o(6488);
                throw tVar;
            }
            AppMethodBeat.o(6488);
        } else {
            if (MMApplicationContext.isMainProcess()) {
                p.g(g.aAf(), "MMKernel.account()");
                azs = com.tencent.mm.kernel.a.getUin();
            } else {
                azs = com.tencent.mm.kernel.a.azs();
            }
            mmkv = MultiProcessMMKV.getMMKV("appMsgPay_".concat(String.valueOf(azs)), 2);
            pmR = mmkv;
            if (mmkv == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.sdk.platformtools.MultiProcessMMKV");
                AppMethodBeat.o(6488);
                throw tVar2;
            }
            AppMethodBeat.o(6488);
        }
        return mmkv;
    }

    public static void aH(String str, boolean z) {
        AppMethodBeat.i(6489);
        p.h(str, "url");
        g gVar = g.pnw;
        String ahJ = g.ahJ(str);
        if (z) {
            clq().encode(ahJ, 1);
            AppMethodBeat.o(6489);
            return;
        }
        clq().remove(ahJ);
        AppMethodBeat.o(6489);
    }

    public static boolean ahI(String str) {
        AppMethodBeat.i(6490);
        if (str == null) {
            AppMethodBeat.o(6490);
            return false;
        }
        MultiProcessMMKV clq = clq();
        g gVar = g.pnw;
        if (clq.decodeInt(g.ahJ(str), 0) == 1) {
            AppMethodBeat.o(6490);
            return true;
        }
        AppMethodBeat.o(6490);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.HONGKONG) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r1 == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(162409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.TAIWAN) != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006b, code lost:
        if (r2 == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(162409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(162409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.HONGKONG) != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ba, code lost:
        if (r1 == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bc, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(162409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        if (r0.equals(com.tencent.mm.sdk.platformtools.LocaleUtil.TAIWAN) != false) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d6, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(162409);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return com.tencent.mm.R.drawable.bzu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return com.tencent.mm.R.drawable.bzr;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return com.tencent.mm.R.drawable.bzx;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return com.tencent.mm.R.drawable.c00;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return com.tencent.mm.R.drawable.c03;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int cG(java.lang.String r5, int r6) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.b.a.cG(java.lang.String, int):int");
    }

    public final void a(String str, MMNeat7extView mMNeat7extView, v vVar, int i2) {
        boolean z = true;
        AppMethodBeat.i(6492);
        p.h(str, "text");
        p.h(mMNeat7extView, "titleTv");
        p.h(vVar, "item");
        if (!(vVar.type == 0 && vVar.iwf == 1)) {
            z = false;
        }
        a(str, mMNeat7extView, z, vVar.url, i2);
        AppMethodBeat.o(6492);
    }

    public final void a(CharSequence charSequence, MMNeat7extView mMNeat7extView, boolean z, String str, int i2) {
        AppMethodBeat.i(6493);
        p.h(charSequence, "text");
        p.h(mMNeat7extView, "titleTv");
        if (!z || !cle()) {
            mMNeat7extView.aw(charSequence);
            AppMethodBeat.o(6493);
            return;
        }
        com.tencent.mm.plugin.bizui.a.a aVar = com.tencent.mm.plugin.bizui.a.a.pfC;
        Context context = mMNeat7extView.getContext();
        p.g(context, "titleTv.context");
        com.tencent.mm.plugin.bizui.a.a.a(context, mMNeat7extView, cG(str, i2), charSequence, i2);
        AppMethodBeat.o(6493);
    }

    public final void cE(String str, int i2) {
        AppMethodBeat.i(6494);
        p.h(str, "url");
        if (ahI(str)) {
            Log.d(TAG, "url pay status: already paid url=" + str + ", itemShowType=" + i2);
            AppMethodBeat.o(6494);
            return;
        }
        Log.i(TAG, "appMsgPaySuccess url=" + str + ", itemShowType=" + i2);
        m mVar = m.pCU;
        m.aii(str);
        aH(str, true);
        m.a(str, i2, 90, new Object[0]);
        w wVar = new w();
        wVar.dCO.dCP = true;
        EventCenter.instance.asyncPublish(wVar, Looper.getMainLooper());
        AppMethodBeat.o(6494);
    }

    public final void ab(Map<String, String> map) {
        AppMethodBeat.i(6495);
        p.h(map, "values");
        String str = map.get(".sysmsg.MMBizPaySubscribePayNotify.AppmsgUrl");
        int i2 = Util.getInt(map.get(".sysmsg.MMBizPaySubscribePayNotify.ItemShowType"), -1);
        Log.i(TAG, "onPaySuccessNotify url=" + str + ", itemShowType=" + i2);
        if (str != null && i2 >= 0) {
            cE(str, i2);
        }
        AppMethodBeat.o(6495);
    }

    public static boolean cle() {
        AppMethodBeat.i(6496);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(6496);
            return true;
        } else if (pmS == -1) {
            pmS = ((b) g.af(b.class)).a(b.a.clicfg_open_biz_pay_reading, 0);
            Log.i(TAG, "isPayReadingOpen open %d", Integer.valueOf(pmS));
            if (pmS == 1) {
                AppMethodBeat.o(6496);
                return true;
            }
            AppMethodBeat.o(6496);
            return false;
        } else if (pmS == 1) {
            AppMethodBeat.o(6496);
            return true;
        } else {
            AppMethodBeat.o(6496);
            return false;
        }
    }
}
