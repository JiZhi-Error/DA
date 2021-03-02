package com.tencent.mm.plugin.wallet.wecoin.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.g;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0006\u0010\r\u001a\u00020\t\u001a\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u001a\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002\u001a\u0006\u0010\u001d\u001a\u00020\u001e\u001a\u0006\u0010\u001f\u001a\u00020\u001e\u001a\u001e\u0010 \u001a\u00020\u001e\"\b\b\u0000\u0010!*\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$\u001a\u0006\u0010%\u001a\u00020\u001e\u001a\u0006\u0010&\u001a\u00020\u001e\u001a\u0006\u0010'\u001a\u00020\u001e\u001a\u0006\u0010(\u001a\u00020\u0001\u001a\b\u0010)\u001a\u0004\u0018\u00010*\u001a\b\u0010+\u001a\u0004\u0018\u00010,\u001a\b\u0010-\u001a\u0004\u0018\u00010.\u001a\u0016\u0010/\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u000203\u001a\u000e\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u0001\u001a\u000e\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020*\u001a\u000e\u00108\u001a\u00020\u00122\u0006\u00107\u001a\u00020,\u001a\u000e\u00109\u001a\u00020\u00122\u0006\u00107\u001a\u00020.\u001a\u0016\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\f\u001a\u0006\u0010>\u001a\u00020\u0012\u001a\u0006\u0010?\u001a\u00020\u0012\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006@"}, hxF = {"lastClickSaveButtonTime", "", "getLastClickSaveButtonTime", "()J", "setLastClickSaveButtonTime", "(J)V", "divide", "", "d1", "", "d2", "roundingMode", "", "generateUniqueID", "getRealBottomHeight", "context", "Landroid/content/Context;", "handleNetRespError", "", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "handleWeCoinInterceptWin", "interceptWin", "Lcom/tencent/mm/protocal/protobuf/InterceptPopUp;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "handleWeCoinJumpItem", "jumpItem", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "hasShowWecoinEntranceTutorial", "", "hasShowWecoinTutorial", "isCgiReturnError", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "callback", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "isFastClick", "isMidasInitOnceABTest", "isWeCoinCloseEntranceABTestHit", "loadWecoinBalanceSnapshot", "loadWecoinIncomePageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "loadWecoinPageInfoResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "loadWecoinPriceListResponseSnapshot", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "multiply", "printPbLog", "tag", "originObj", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "saveWecoinBalanceSnapshot", "balance", "saveWecoinIncomePageInfoResponseSnapshot", "response", "saveWecoinPageInfoResponseSnapshot", "saveWecoinPriceListResponseSnapshot", "setFixedTextSize", "textView", "Landroid/widget/TextView;", "dpSize", "setHasShowWecoinEntranceTutorial", "setHasShowWecoinTutorial", "plugin-wxpay_release"})
public final class c {
    private static long HBw;

    public static final boolean isFastClick() {
        AppMethodBeat.i(212925);
        if (Util.ticksToNow(HBw) < 600) {
            Log.d("MicroMsg.WeCoinUtils", "button click too soon, save time " + HBw);
            AppMethodBeat.o(212925);
            return true;
        }
        HBw = Util.currentTicks();
        AppMethodBeat.o(212925);
        return false;
    }

    public static final String fPE() {
        AppMethodBeat.i(212926);
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "uuid.toString()");
        AppMethodBeat.o(212926);
        return uuid;
    }

    public static final void o(TextView textView, int i2) {
        AppMethodBeat.i(212927);
        p.h(textView, "textView");
        float ez = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
        float gvi = com.tencent.mm.cc.a.gvi();
        Log.d("MicroMsg.WeCoinUtils", "setFixedTextSize, fontScale: " + ez + ", viewScale: " + gvi);
        if (!(ez == 1.0f && gvi == 1.0f)) {
            textView.setTextSize(0, (float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), i2));
        }
        AppMethodBeat.o(212927);
    }

    public static final void d(String str, com.tencent.mm.bw.a aVar) {
        AppMethodBeat.i(212928);
        p.h(str, "tag");
        p.h(aVar, "originObj");
        JSONObject jSONObject = new JSONObject();
        try {
            g.a(aVar, jSONObject);
        } catch (Exception e2) {
            Log.e("MicroMsg.WeCoinUtils", "printPbLog account exception, error: " + e2.getMessage() + ", stack trace: " + Util.stackTraceToString(e2));
        }
        String jSONObject2 = jSONObject.toString();
        p.g(jSONObject2, "jsonObject.toString()");
        Log.i(str, jSONObject2);
        AppMethodBeat.o(212928);
    }

    public static final <T extends dpc> boolean h(c.a<T> aVar) {
        AppMethodBeat.i(212929);
        p.h(aVar, "callback");
        if (aVar.errType == 0 && aVar.errCode == 0) {
            AppMethodBeat.o(212929);
            return false;
        }
        AppMethodBeat.o(212929);
        return true;
    }

    public static final void a(Context context, com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
        AppMethodBeat.i(212930);
        p.h(context, "context");
        if (aVar != null) {
            if (!(aVar.dGe == 0 && aVar.errorCode == 0)) {
                String str = aVar.errorMsg;
                if (str == null || str.length() == 0) {
                    h.a(context, context.getString(R.string.j2j), "", context.getString(R.string.j2c), false, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(212930);
                    return;
                }
                h.a(context, aVar.errorMsg, "", context.getString(R.string.j2c), false, (DialogInterface.OnClickListener) null);
            }
            AppMethodBeat.o(212930);
            return;
        }
        AppMethodBeat.o(212930);
    }

    public static final void a(Context context, cdg cdg, com.tencent.mm.plugin.wallet.wecoin.model.b bVar) {
        AppMethodBeat.i(212931);
        p.h(context, "context");
        if (cdg != null) {
            switch (cdg.Mje) {
                case 1:
                    h.a(context, cdg.dQx, "", cdg.Mjc.dQx, false, (DialogInterface.OnClickListener) new a(cdg, context, bVar));
                    AppMethodBeat.o(212931);
                    return;
                case 2:
                    h.a(context, cdg.dQx, "", cdg.Mjd.dQx, cdg.Mjc.dQx, false, (DialogInterface.OnClickListener) new b(cdg, context, bVar), (DialogInterface.OnClickListener) new DialogInterface$OnClickListenerC1909c(cdg, context, bVar));
                    break;
            }
            AppMethodBeat.o(212931);
            return;
        }
        AppMethodBeat.o(212931);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$1"})
    static final class a implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ cdg HPq;
        final /* synthetic */ com.tencent.mm.plugin.wallet.wecoin.model.b HPr;

        a(cdg cdg, Context context, com.tencent.mm.plugin.wallet.wecoin.model.b bVar) {
            this.HPq = cdg;
            this.$context$inlined = context;
            this.HPr = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(212919);
            c.a(this.$context$inlined, this.HPq.Mjc, this.HPr);
            AppMethodBeat.o(212919);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$2"})
    static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ cdg HPq;
        final /* synthetic */ com.tencent.mm.plugin.wallet.wecoin.model.b HPr;

        b(cdg cdg, Context context, com.tencent.mm.plugin.wallet.wecoin.model.b bVar) {
            this.HPq = cdg;
            this.$context$inlined = context;
            this.HPr = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(212920);
            c.a(this.$context$inlined, this.HPq.Mjd, this.HPr);
            AppMethodBeat.o(212920);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/utils/WeCoinUtilsKt$handleWeCoinInterceptWin$1$3"})
    /* renamed from: com.tencent.mm.plugin.wallet.wecoin.c.c$c  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC1909c implements DialogInterface.OnClickListener {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ cdg HPq;
        final /* synthetic */ com.tencent.mm.plugin.wallet.wecoin.model.b HPr;

        DialogInterface$OnClickListenerC1909c(cdg cdg, Context context, com.tencent.mm.plugin.wallet.wecoin.model.b bVar) {
            this.HPq = cdg;
            this.$context$inlined = context;
            this.HPr = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(212921);
            c.a(this.$context$inlined, this.HPq.Mjc, this.HPr);
            AppMethodBeat.o(212921);
        }
    }

    public static final int lp(String str, String str2) {
        int i2;
        AppMethodBeat.i(212933);
        p.h(str, "d1");
        p.h(str2, "d2");
        try {
            double d2 = Util.getDouble(str, 0.0d);
            double d3 = Util.getDouble(str2, 0.0d);
            if (d2 == 0.0d) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d3 == 0.0d) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            i2 = bigDecimal.multiply(new BigDecimal(str2)).intValue();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WeCoinUtils", e2, "", new Object[0]);
            i2 = 0;
        }
        AppMethodBeat.o(212933);
        return i2;
    }

    public static final boolean fPK() {
        AppMethodBeat.i(212934);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wecoin_init_midas_sdk_once, 1);
        Log.i("MicroMsg.WeCoinUtils", "isMidasInitOnceABTest, %s", Integer.valueOf(a2));
        if (a2 == 0) {
            AppMethodBeat.o(212934);
            return false;
        }
        AppMethodBeat.o(212934);
        return true;
    }

    public static final long hXG() {
        AppMethodBeat.i(258764);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_WECOIN_BALANCE_LONG_SYNC, (Object) 0L);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Long");
            AppMethodBeat.o(258764);
            throw tVar;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(258764);
        return longValue;
    }

    public static final void LS(long j2) {
        AppMethodBeat.i(212935);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_WECOIN_BALANCE_LONG_SYNC, Long.valueOf(j2));
        AppMethodBeat.o(212935);
    }

    public static final byp fPL() {
        boolean z;
        byp byp;
        AppMethodBeat.i(212936);
        Log.d("MicroMsg.WeCoinUtils", "load WecoinPageInfoResponse snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().get(ar.a.USERINFO_WECOIN_PAGE_INFO_RESPONSE_STRING_SYNC, "");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(212936);
            return null;
        }
        byp byp2 = new byp();
        Charset charset = kotlin.n.d.ISO_8859_1;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(212936);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        try {
            byp2.parseFrom(bytes);
            byp = byp2;
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            byp = null;
        }
        byp byp3 = byp;
        AppMethodBeat.o(212936);
        return byp3;
    }

    public static final bop fPM() {
        boolean z;
        bop bop;
        AppMethodBeat.i(212937);
        Log.d("MicroMsg.WeCoinUtils", "load WecoinIncomePageInfoResponse snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().get(ar.a.USERINFO_WECOIN_INCOME_PAGE_INFO_RESPONSE_STRING_SYNC, "");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(212937);
            return null;
        }
        bop bop2 = new bop();
        Charset charset = kotlin.n.d.ISO_8859_1;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(212937);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        try {
            bop2.parseFrom(bytes);
            bop = bop2;
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            bop = null;
        }
        bop bop3 = bop;
        AppMethodBeat.o(212937);
        return bop3;
    }

    public static final byr fPN() {
        boolean z;
        byr byr;
        AppMethodBeat.i(212938);
        Log.d("MicroMsg.WeCoinUtils", "load WecoinPriceListResponse snapshot");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String str = (String) aAh.azQ().get(ar.a.USERINFO_WECOIN_PRICE_LIST_RESPONSE_STRING_SYNC, "");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(212938);
            return null;
        }
        byr byr2 = new byr();
        Charset charset = kotlin.n.d.ISO_8859_1;
        if (str == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(212938);
            throw tVar;
        }
        byte[] bytes = str.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        try {
            byr2.parseFrom(bytes);
            byr = byr2;
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            byr = null;
        }
        byr byr3 = byr;
        AppMethodBeat.o(212938);
        return byr3;
    }

    public static final double lo(String str, String str2) {
        double d2;
        String obj;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(212932);
        p.h(str, "d1");
        p.h(str2, "d2");
        try {
            String str3 = str;
            int length = str3.length() - 1;
            boolean z4 = false;
            int i2 = 0;
            while (i2 <= length) {
                if (str3.charAt(!z4 ? i2 : length) <= ' ') {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z4) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (!z3) {
                    z4 = true;
                } else {
                    i2++;
                }
            }
            if (Util.getDouble(str3.subSequence(i2, length + 1).toString(), 0.0d) == 0.0d) {
                obj = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else {
                String str4 = str;
                int length2 = str4.length() - 1;
                boolean z5 = false;
                int i3 = 0;
                while (i3 <= length2) {
                    if (str4.charAt(!z5 ? i3 : length2) <= ' ') {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z5) {
                        if (!z) {
                            break;
                        }
                        length2--;
                    } else if (!z) {
                        z5 = true;
                    } else {
                        i3++;
                    }
                }
                obj = str4.subSequence(i3, length2 + 1).toString();
            }
            BigDecimal bigDecimal = new BigDecimal(obj);
            String str5 = str2;
            int length3 = str5.length() - 1;
            boolean z6 = false;
            int i4 = 0;
            while (i4 <= length3) {
                if (str5.charAt(!z6 ? i4 : length3) <= ' ') {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z6) {
                    if (!z2) {
                        break;
                    }
                    length3--;
                } else if (!z2) {
                    z6 = true;
                } else {
                    i4++;
                }
            }
            d2 = bigDecimal.divide(new BigDecimal(str5.subSequence(i4, length3 + 1).toString()), 5, 2).doubleValue();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WeCoinUtils", e2, "", new Object[0]);
            d2 = 0.0d;
        }
        AppMethodBeat.o(212932);
        return d2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ byp HPt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(byp byp) {
            super(0);
            this.HPt = byp;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212923);
            byte[] byteArray = this.HPt.toByteArray();
            p.g(byteArray, "response.toByteArray()");
            String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_WECOIN_PAGE_INFO_RESPONSE_STRING_SYNC, str);
            x xVar = x.SXb;
            AppMethodBeat.o(212923);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bop HPs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(bop bop) {
            super(0);
            this.HPs = bop;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212922);
            byte[] byteArray = this.HPs.toByteArray();
            p.g(byteArray, "response.toByteArray()");
            String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_WECOIN_INCOME_PAGE_INFO_RESPONSE_STRING_SYNC, str);
            x xVar = x.SXb;
            AppMethodBeat.o(212922);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ byr HPu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(byr byr) {
            super(0);
            this.HPu = byr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212924);
            byte[] byteArray = this.HPu.toByteArray();
            p.g(byteArray, "response.toByteArray()");
            String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_WECOIN_PRICE_LIST_RESPONSE_STRING_SYNC, str);
            x xVar = x.SXb;
            AppMethodBeat.o(212924);
            return xVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(Context context, ddc ddc, com.tencent.mm.plugin.wallet.wecoin.model.b bVar) {
        AppMethodBeat.i(212939);
        if (ddc != null) {
            switch (ddc.action) {
                case 1:
                    Log.d("MicroMsg.WeCoinUtils", "handleWeCoinJumpItem h5 url " + ddc.url);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ddc.url);
                    com.tencent.mm.wallet_core.ui.f.aA(context, intent);
                    AppMethodBeat.o(212939);
                    return;
                case 2:
                    Log.d("MicroMsg.WeCoinUtils", "handleWeCoinJumpItem TinyApp, username: " + ddc.username + ", pagepath: " + ddc.Cqk);
                    com.tencent.mm.wallet_core.ui.f.u(ddc.username, ddc.Cqk, 0, 1188);
                    AppMethodBeat.o(212939);
                    return;
                case 3:
                    if (bVar != null) {
                        bVar.a(ddc);
                        AppMethodBeat.o(212939);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(212939);
            return;
        }
        AppMethodBeat.o(212939);
    }
}
