package com.tencent.mm.plugin.wallet.wecoin.model;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.mm.ak.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.wecoin.b.i;
import com.tencent.mm.plugin.wallet.wecoin.b.k;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.faz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 H2\u00020\u0001:\u0002HIB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020\nJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\n0*J\u0006\u0010,\u001a\u00020&J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0*J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110*J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020 0*J\u0006\u00100\u001a\u00020&J\u0012\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0*J\u0006\u00102\u001a\u00020&J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0013J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040*J\u001e\u00105\u001a\u00020&2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020\bJ&\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ(\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\b\u0010D\u001a\u0004\u0018\u00010\nJ\u000e\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020\bJ\u0006\u0010G\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isCacheDataLoaded", "", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "mAgreementStatus", "", "mAgreementUrl", "", "mAgreementVersion", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mGetPriceListCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "mInterceptPopUp", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeInterceptWinInfo;", "mParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "getMParams", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "setMParams", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;)V", "mPrepareCgi", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "mPriceListResponse", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "mSceneID", "mSceneSessionID", "mSessionid", "mTotalBalance", "", "mUniqueId", "mWecoinPriceInfo", "", "Lcom/tencent/mm/protocal/protobuf/WecoinPriceInfo;", "cancelGetPriceListRequest", "", "cancelPrepareRecharge", "generateUniqueID", "getAgreementStatus", "Landroid/arch/lifecycle/LiveData;", "getAgreementUrl", "getCacheData", "getCgiRespInfo", "getInterceptPopUp", "getTotalBalance", "getWecoinBalanceRequest", "getWecoinPriceInfo", "getWecoinPriceListInfo", "initKVData", NativeProtocol.WEB_DIALOG_PARAMS, "prepareWecoinRecharge", "context", "Landroid/app/Activity;", "info", "scene", "rechargeByMidasSDK", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "response", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "env", "productID", "reportCgiKVStatus", "operationType", "stepID", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "reportKVStatus", "value", "resetCacheValue", "Companion", "MidasPayCallBackImpl", "plugin-wxpay_release"})
public final class RechargeProductsDialogViewModel extends ViewModel {
    public static final a HNb = new a((byte) 0);
    public final MutableLiveData<List<faz>> HMN = new MutableLiveData<>();
    public final MutableLiveData<String> HMO = new MutableLiveData<>();
    public final MutableLiveData<Integer> HMP = new MutableLiveData<>();
    public final MutableLiveData<a> HMQ = new MutableLiveData<>();
    public final MutableLiveData<Long> HMR = new MutableLiveData<>();
    public final MutableLiveData<d> HMS = new MutableLiveData<>();
    public byr HMT;
    public k HMU;
    public i HMV;
    public int HMW;
    public boolean HMX;
    public String HMY;
    public String HMZ;
    public e HNa;
    public final MutableLiveData<Boolean> qiR = new MutableLiveData<>();
    public int zbZ = -1;
    public String zfX;

    static {
        AppMethodBeat.i(212713);
        AppMethodBeat.o(212713);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ RechargeProductsDialogViewModel HNe;

        public c(RechargeProductsDialogViewModel rechargeProductsDialogViewModel) {
            this.HNe = rechargeProductsDialogViewModel;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212704);
            c.a aVar = (c.a) obj;
            byn byn = (byn) aVar.iLC;
            if (byn != null) {
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    this.HNe.HMR.postValue(Long.valueOf(byn.MdV));
                    com.tencent.mm.plugin.wallet.wecoin.c.c.LS(byn.MdV);
                }
                AppMethodBeat.o(212704);
                return byn;
            }
            AppMethodBeat.o(212704);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ RechargeProductsDialogViewModel HNe;

        public d(RechargeProductsDialogViewModel rechargeProductsDialogViewModel) {
            this.HNe = rechargeProductsDialogViewModel;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212705);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.RechargeProductsDialogViewModel", "getWecoinPriceListInfo errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            this.HNe.HMV = null;
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.qiR, Boolean.FALSE);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                if (this.HNe.HMT == null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.HMQ, new a(aVar.errType, aVar.errCode, aVar.errMsg));
                    this.HNe.fPF();
                }
                this.HNe.f(8, 3, aVar.errCode, aVar.errMsg);
            } else if (aVar.iLC == null) {
                if (this.HNe.HMT == null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.HMQ, new a(3, -1, ""));
                    this.HNe.fPF();
                }
                this.HNe.f(8, 3, 3, "callback resp is null");
            } else {
                byr byr = (byr) aVar.iLC;
                if (byr != null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.RechargeProductsDialogViewModel", byr);
                    this.HNe.HMN.postValue(byr.MdY);
                    this.HNe.HMO.postValue(byr.MdZ);
                    this.HNe.HMP.postValue(Integer.valueOf(byr.Mea));
                    this.HNe.HMW = byr.Meb;
                    this.HNe.HMT = byr;
                    p.h(byr, "response");
                    Log.d("MicroMsg.WeCoinUtils", "save WecoinPriceListResponse snapshot");
                    com.tencent.mm.ac.d.i(new c.f(byr));
                    this.HNe.f(8, 3, 0, "");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212705);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ Activity $context;
        final /* synthetic */ RechargeProductsDialogViewModel HNe;
        final /* synthetic */ faz HNf;

        public e(RechargeProductsDialogViewModel rechargeProductsDialogViewModel, faz faz, Activity activity) {
            this.HNe = rechargeProductsDialogViewModel;
            this.HNf = faz;
            this.$context = activity;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar;
            cdg cdg;
            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar2;
            AppMethodBeat.i(212706);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.RechargeProductsDialogViewModel", "prepareWecoinRecharge errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            this.HNe.HMU = null;
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.qiR, Boolean.FALSE);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                e eVar3 = this.HNe.HNa;
                if (!(eVar3 == null || (eVar2 = eVar3.HML) == null)) {
                    eVar2.p(aVar.errType, aVar.errCode, aVar.errMsg);
                }
                dep dep = (dep) aVar.iLC;
                if (dep == null || (cdg = dep.MJy) == null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.HMQ, new a(aVar.errType, aVar.errCode, aVar.errMsg));
                    this.HNe.fPF();
                    this.HNe.f(3, 3, aVar.errCode, aVar.errMsg);
                    h.INSTANCE.dN(1581, 22);
                } else {
                    T t = aVar.iLC;
                    p.g(t, "cgiBack.resp");
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.RechargeProductsDialogViewModel", t);
                    com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.HMS, new d((dep) aVar.iLC, this.HNf));
                    this.HNe.fPF();
                    this.HNe.f(3, 3, aVar.errCode, cdg.dQx);
                    h.INSTANCE.dN(1581, 27);
                    h.INSTANCE.dN(1581, 22);
                }
            } else if (aVar.iLC == null) {
                Log.e("MicroMsg.RechargeProductsDialogViewModel", "cgiBack.resp is null");
                e eVar4 = this.HNe.HNa;
                if (!(eVar4 == null || (eVar = eVar4.HML) == null)) {
                    eVar.p(3, -1, "");
                }
                com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNe.HMQ, new a(3, -1, ""));
                this.HNe.fPF();
                this.HNe.f(3, 3, 3, "callback resp is null");
                h.INSTANCE.dN(1581, 22);
            } else {
                dep dep2 = (dep) aVar.iLC;
                if (dep2 != null) {
                    Log.i("MicroMsg.RechargeProductsDialogViewModel", "prepareWecoinRecharge, product_id: " + this.HNf.AZx);
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.RechargeProductsDialogViewModel", dep2);
                    this.HNe.f(3, 3, 0, "");
                    h.INSTANCE.dN(1581, 21);
                    RechargeProductsDialogViewModel rechargeProductsDialogViewModel = this.HNe;
                    Activity activity = this.$context;
                    String str = this.HNf.AZx;
                    p.g(str, "info.product_id");
                    rechargeProductsDialogViewModel.a(activity, dep2, "release", str);
                }
                this.HNe.fPF();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212706);
            return xVar;
        }
    }

    public RechargeProductsDialogViewModel() {
        AppMethodBeat.i(212712);
        AppMethodBeat.o(212712);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J(\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogViewModel$MidasPayCallBackImpl;", "Lcom/tencent/midas/api/IAPMidasPayCallBack;", "billNo", "", "innerParams", "Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;", "sessionID", "(Ljava/lang/String;Lcom/tencent/mm/plugin/wallet/wecoin/model/RechargeProductsDialogParam;Ljava/lang/String;)V", "MidasPayCallBack", "", "response", "Lcom/tencent/midas/api/APMidasResponse;", "MidasPayNeedLogin", "cancelWecoinRechargeRequest", "reportCgiKVStatus", "operationType", "", "stepID", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "plugin-wxpay_release"})
    public static final class b implements IAPMidasPayCallBack {
        private final e HNc;
        private final String egU;
        private final String vPa;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "kotlin.jvm.PlatformType", "call"})
        static final class a<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
            final /* synthetic */ b HNd;

            a(b bVar) {
                this.HNd = bVar;
            }

            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(212700);
                c.a aVar = (c.a) obj;
                this.HNd.f(5, 3, aVar.errCode, aVar.errMsg);
                if (!(aVar.errType == 0 && aVar.errCode == 0)) {
                    Log.i("MicroMsg.RechargeProductsDialogViewModel", "cancelWecoinRechargeRequest errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(212700);
                return xVar;
            }
        }

        public b(String str, e eVar, String str2) {
            this.egU = str;
            this.HNc = eVar;
            this.vPa = str2;
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayNeedLogin() {
            AppMethodBeat.i(212701);
            Log.i("MicroMsg.RechargeProductsDialogViewModel", "Midas pay need login:");
            AppMethodBeat.o(212701);
        }

        @Override // com.tencent.midas.api.IAPMidasPayCallBack
        public final void MidasPayCallBack(APMidasResponse aPMidasResponse) {
            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar;
            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar2;
            AppMethodBeat.i(212702);
            if (aPMidasResponse != null) {
                Log.i("MicroMsg.RechargeProductsDialogViewModel", "MidasPayCallBack: resultCode: " + aPMidasResponse.resultCode + ", resultMsg: " + aPMidasResponse.resultMsg + ',' + " realSaveNum: " + aPMidasResponse.realSaveNum + ", payChannel: " + aPMidasResponse.payChannel + ", payState: " + aPMidasResponse.payState + ',' + "provideState: " + aPMidasResponse.provideState);
                switch (aPMidasResponse.resultCode) {
                    case 0:
                        f(4, 3, aPMidasResponse.resultCode, aPMidasResponse.resultMsg);
                        h.INSTANCE.dN(1581, 24);
                        e eVar3 = this.HNc;
                        if (eVar3 != null) {
                            if (eVar3.mScene != 0) {
                                com.tencent.mm.kernel.e aAh = g.aAh();
                                p.g(aAh, "MMKernel.storage()");
                                Object obj = aAh.azQ().get(ar.a.USERINFO_WECOIN_HAS_SHOW_ENTRANCE_TUTORIAL_BOOLEAN_SYNC, Boolean.FALSE);
                                if (obj == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
                                    AppMethodBeat.o(212702);
                                    throw tVar;
                                } else if (!((Boolean) obj).booleanValue()) {
                                    com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar4 = eVar3.HML;
                                    if (eVar4 != null) {
                                        eVar4.onSuccess(Boolean.TRUE);
                                    }
                                    com.tencent.mm.kernel.e aAh2 = g.aAh();
                                    p.g(aAh2, "MMKernel.storage()");
                                    aAh2.azQ().set(ar.a.USERINFO_WECOIN_HAS_SHOW_ENTRANCE_TUTORIAL_BOOLEAN_SYNC, Boolean.TRUE);
                                    AppMethodBeat.o(212702);
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.wallet.wecoin.a.e<Boolean> eVar5 = eVar3.HML;
                            if (eVar5 != null) {
                                eVar5.onSuccess(Boolean.FALSE);
                                AppMethodBeat.o(212702);
                                return;
                            }
                            AppMethodBeat.o(212702);
                            return;
                        }
                        AppMethodBeat.o(212702);
                        return;
                    case 1:
                    default:
                        e eVar6 = this.HNc;
                        if (!(eVar6 == null || (eVar2 = eVar6.HML) == null)) {
                            eVar2.p(3, aPMidasResponse.resultCode, aPMidasResponse.resultMsg);
                        }
                        f(4, 3, aPMidasResponse.resultCode, aPMidasResponse.resultMsg);
                        h.INSTANCE.dN(1581, 25);
                        AppMethodBeat.o(212702);
                        return;
                    case 2:
                        f(4, 3, aPMidasResponse.resultCode, aPMidasResponse.resultMsg);
                        h.INSTANCE.dN(1581, 26);
                        String str = this.egU;
                        String str2 = str;
                        if (!(str2 == null || str2.length() == 0)) {
                            f(5, 1, 0, "");
                            new com.tencent.mm.plugin.wallet.wecoin.b.a(str).aYI().h(new a(this));
                        }
                        e eVar7 = this.HNc;
                        if (eVar7 == null || (eVar = eVar7.HML) == null) {
                            AppMethodBeat.o(212702);
                            return;
                        }
                        eVar.p(3, -3, aPMidasResponse.resultMsg);
                        AppMethodBeat.o(212702);
                        return;
                }
            } else {
                AppMethodBeat.o(212702);
            }
        }

        public final void f(int i2, int i3, int i4, String str) {
            String str2;
            AppMethodBeat.i(212703);
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[7];
            e eVar = this.HNc;
            objArr[0] = eVar != null ? Integer.valueOf(eVar.mScene) : 1;
            e eVar2 = this.HNc;
            if (eVar2 != null) {
                str2 = eVar2.HMK;
            } else {
                str2 = null;
            }
            objArr[1] = str2;
            objArr[2] = this.vPa;
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = str;
            hVar.a(22129, objArr);
            AppMethodBeat.o(212703);
        }
    }

    public final void a(Activity activity, dep dep, String str, String str2) {
        AppMethodBeat.i(212707);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(dep, "response");
        p.h(str, "env");
        p.h(str2, "productID");
        if (dep.LYf != null) {
            String str3 = dep.MJH;
            if (!(str3 == null || str3.length() == 0)) {
                APMidasGoodsRequest aPMidasGoodsRequest = new APMidasGoodsRequest();
                aPMidasGoodsRequest.offerId = dep.LYf.MuV;
                aPMidasGoodsRequest.openId = dep.LYf.MuW;
                aPMidasGoodsRequest.openKey = dep.LYf.MuX;
                aPMidasGoodsRequest.sessionId = dep.LYf.session_id;
                aPMidasGoodsRequest.sessionType = dep.LYf.MuY;
                aPMidasGoodsRequest.pf = dep.LYf.pf;
                aPMidasGoodsRequest.pfKey = dep.LYf.MuZ;
                aPMidasGoodsRequest.zoneId = "1";
                aPMidasGoodsRequest.goodsTokenUrl = dep.MJH;
                aPMidasGoodsRequest.mpInfo.payChannel = "wechat";
                APMidasPayAPI.setLogEnable(false);
                APMidasPayAPI.setEnv(str);
                aPMidasGoodsRequest.tokenType = 1;
                aPMidasGoodsRequest.prodcutId = str2;
                aPMidasGoodsRequest.saveValue = dep.MJI;
                f(4, 1, 0, "");
                h.INSTANCE.dN(1581, 23);
                APMidasGoodsRequest aPMidasGoodsRequest2 = aPMidasGoodsRequest;
                String str4 = dep.KBs;
                e eVar = this.HNa;
                String str5 = this.HMZ;
                if (str5 == null) {
                    p.btv("mSessionid");
                }
                APMidasPayAPI.launchPay(activity, aPMidasGoodsRequest2, new b(str4, eVar, str5));
                AppMethodBeat.o(212707);
                return;
            }
        }
        Log.e("MicroMsg.RechargeProductsDialogViewModel", "rechargeByMidasSDK param error.");
        AppMethodBeat.o(212707);
    }

    public final String fPE() {
        AppMethodBeat.i(212708);
        String uuid = UUID.randomUUID().toString();
        p.g(uuid, "uuid.toString()");
        this.zfX = uuid;
        AppMethodBeat.o(212708);
        return uuid;
    }

    public final void aeH(int i2) {
        AppMethodBeat.i(212709);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.zbZ);
        String str = this.HMY;
        if (str == null) {
            p.btv("mSceneSessionID");
        }
        objArr[1] = str;
        String str2 = this.HMZ;
        if (str2 == null) {
            p.btv("mSessionid");
        }
        objArr[2] = str2;
        objArr[3] = Integer.valueOf(i2);
        hVar.a(21651, objArr);
        AppMethodBeat.o(212709);
    }

    public final void f(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(212710);
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.zbZ);
        String str2 = this.HMY;
        if (str2 == null) {
            p.btv("mSceneSessionID");
        }
        objArr[1] = str2;
        String str3 = this.HMZ;
        if (str3 == null) {
            p.btv("mSessionid");
        }
        objArr[2] = str3;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = str;
        hVar.a(22129, objArr);
        AppMethodBeat.o(212710);
    }

    public final void fPF() {
        AppMethodBeat.i(212711);
        Log.i("MicroMsg.RechargeProductsDialogViewModel", "resetCacheValue:");
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HMQ, null);
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, null);
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HMS, null);
        AppMethodBeat.o(212711);
    }
}
