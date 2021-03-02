package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015J\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0015J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015J\u0012\u0010\u001c\u001a\u00020\u00182\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015J\u0006\u0010$\u001a\u00020\u0018J \u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0012J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020'J\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isMidasSDKInitialized", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mHasShowTutorialFlag", "mIncomeBalance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "mTotalBalance", "", "mWeCoinPageInfoResp", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "mWecoinBillUrl", "", "mWecoinQaUrl", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getIncomeBalance", "getShowTutorialFlag", "", "getTotalBalance", "getWecoinBanner", "getWecoinBillUrl", "getWecoinPageInfoRequest", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getWecoinQaUrl", "hasShowTutorialFlag", "initMidasSdkInfo", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/content/Context;", "loadSnapshot", "reportCgiKVStatus", "stepID", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "reportKVStatus", "value", "saveSnapshot", "setShowTutorialFlag", "Companion", "plugin-wxpay_release"})
public final class WeCoinRechargeViewModel extends ViewModel {
    public static final a HNX = new a((byte) 0);
    public final MutableLiveData<a> HMQ = new MutableLiveData<>();
    public final MutableLiveData<Long> HMR = new MutableLiveData<>();
    public final MutableLiveData<Boolean> HNS = new MutableLiveData<>();
    public final MutableLiveData<String> HNT = new MutableLiveData<>();
    public final MutableLiveData<String> HNU = new MutableLiveData<>();
    public final MutableLiveData<Boolean> HNV = new MutableLiveData<>();
    public byp HNW;
    public final MutableLiveData<f> HNv = new MutableLiveData<>();
    public final MutableLiveData<abq> HNx = new MutableLiveData<>();

    static {
        AppMethodBeat.i(212742);
        AppMethodBeat.o(212742);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ WeCoinRechargeViewModel HNY;

        public b(WeCoinRechargeViewModel weCoinRechargeViewModel) {
            this.HNY = weCoinRechargeViewModel;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212735);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.WeCoinRechargeViewModel", "getWecoinPageInfoRequest errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                if (this.HNY.HNW == null) {
                    this.HNY.HMQ.postValue(new a(aVar.errType, aVar.errCode, aVar.errMsg));
                }
                WeCoinRechargeViewModel.L(3, aVar.errCode, aVar.errMsg);
            } else if (aVar.iLC == null) {
                if (this.HNY.HNW == null) {
                    this.HNY.HMQ.postValue(new a(3, -1, ""));
                }
                WeCoinRechargeViewModel.L(3, 3, "callback resp is null");
            } else {
                byp byp = (byp) aVar.iLC;
                if (byp != null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinRechargeViewModel", byp);
                    this.HNY.HNv.postValue(new f(byp.MdX, byp.LWJ));
                    this.HNY.HMR.postValue(Long.valueOf(byp.LoC));
                    this.HNY.HNT.postValue(byp.LWL);
                    this.HNY.HNU.postValue(byp.MdW);
                    this.HNY.HNx.postValue(byp.LWM);
                    this.HNY.HNW = byp;
                    com.tencent.mm.plugin.wallet.wecoin.c.c.LS(byp.LoC);
                    WeCoinRechargeViewModel.L(3, 0, "");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212735);
            return xVar;
        }
    }

    public WeCoinRechargeViewModel() {
        AppMethodBeat.i(212741);
        AppMethodBeat.o(212741);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel$initMidasSdkInfo$callback$1", "Lcom/tencent/mm/plugin/wallet/wecoin/api/WeCoinCommonCallback;", "", "onFailed", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "onSuccess", "data", "(Ljava/lang/Boolean;)V", "plugin-wxpay_release"})
    public static final class c implements e<Boolean> {
        final /* synthetic */ WeCoinRechargeViewModel HNY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(WeCoinRechargeViewModel weCoinRechargeViewModel) {
            this.HNY = weCoinRechargeViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final /* synthetic */ void onSuccess(Boolean bool) {
            AppMethodBeat.i(212736);
            this.HNY.HNS.postValue(bool);
            AppMethodBeat.o(212736);
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
        public final void p(int i2, int i3, String str) {
            AppMethodBeat.i(212737);
            this.HNY.HNS.postValue(Boolean.FALSE);
            AppMethodBeat.o(212737);
        }
    }

    public static void aeH(int i2) {
        AppMethodBeat.i(212738);
        h.INSTANCE.a(21650, Integer.valueOf(i2));
        AppMethodBeat.o(212738);
    }

    public static void L(int i2, int i3, String str) {
        AppMethodBeat.i(212739);
        h.INSTANCE.a(22129, 2, "", "", 11, Integer.valueOf(i2), Integer.valueOf(i3), str);
        AppMethodBeat.o(212739);
    }

    public static void fPI() {
        AppMethodBeat.i(212740);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_WECOIN_PAGE_HAS_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(212740);
    }
}
