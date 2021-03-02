package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "", "showDarkAlways", "", "mScene", "", "sceneSessionID", "", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "(ZILjava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "getMScene", "()I", "getSceneSessionID", "()Ljava/lang/String;", "getShowDarkAlways", "()Z", "Builder", "Companion", "plugin-wxpay_release"})
public final class e {
    public static final b HMM = new b((byte) 0);
    public final boolean HMJ;
    public final String HMK;
    public final com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> HML;
    public final int mScene;

    static {
        AppMethodBeat.i(212699);
        AppMethodBeat.o(212699);
    }

    public e(boolean z, int i2, String str, com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar) {
        this.HMJ = z;
        this.mScene = i2;
        this.HMK = str;
        this.HML = eVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam$Companion;", "", "()V", "build", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "block", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam$Builder;", "", "Lkotlin/ExtensionFunctionType;", "plugin-wxpay_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam$Builder;", "", "()V", "callback", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "getCallback", "()Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "setCallback", "(Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;)V", "mScene", "", "getMScene", "()I", "setMScene", "(I)V", "sceneSessionID", "", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "showDarkAlways", "getShowDarkAlways", "()Z", "setShowDarkAlways", "(Z)V", "build", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "plugin-wxpay_release"})
    public static final class a {
        public boolean HMJ;
        String HMK = "";
        com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> HML;
        public int mScene = -1;

        public final e fPD() {
            AppMethodBeat.i(212698);
            e eVar = new e(this.HMJ, this.mScene, this.HMK, this.HML);
            AppMethodBeat.o(212698);
            return eVar;
        }
    }
}
