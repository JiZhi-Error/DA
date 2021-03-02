package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001bJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bJ\u0012\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bJ\u001a\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u000b2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\u001bJ\u0010\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u0012J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\u0006\u0010*\u001a\u00020 J2\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u00010\u000bJ\u000e\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020.J\u0006\u00104\u001a\u00020 R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00066"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCoinBanner", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "mFaqUrl", "", "mIncomeBalance", "", "mIncomeBillUrl", "mIncomePageInfoResponse", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mRealNameAuthInfo", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "mRealNameAuthored", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getFAQUrl", "getIncomeBalance", "getIncomeBillUrl", "getIncomePageInfoRequest", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getRealNameAuthInfo", "getRealNameAuthRequest", "token", "getRealNameAuthored", "getWeCoinBanner", "initKVData", "kvData", "loadSnapshot", "reportCgiKVStatus", "sessionID", "operationType", "", "stepID", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "reportKVStatus", "value", "saveSnapshot", "Companion", "plugin-wxpay_release"})
public final class WeCoinIncomeDetailViewModel extends ViewModel {
    public static final a HNA = new a((byte) 0);
    public final MutableLiveData<a> HMQ = new MutableLiveData<>();
    public WecoinEncashKVData HNm;
    public MutableLiveData<String> HNt = new MutableLiveData<>();
    public MutableLiveData<String> HNu = new MutableLiveData<>();
    public MutableLiveData<Long> HNv = new MutableLiveData<>();
    public MutableLiveData<djt> HNw = new MutableLiveData<>();
    public final MutableLiveData<abq> HNx = new MutableLiveData<>();
    public final MutableLiveData<Boolean> HNy = new MutableLiveData<>();
    public bop HNz;
    public final MutableLiveData<Boolean> qiR = new MutableLiveData<>();

    static {
        AppMethodBeat.i(212727);
        AppMethodBeat.o(212727);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetIncomePageInfoResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ WeCoinIncomeDetailViewModel HNB;

        public b(WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel) {
            this.HNB = weCoinIncomeDetailViewModel;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212722);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.WeCoinIncomeDetailViewModel", "getIncomePageInfoRequest errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                if (this.HNB.HNz == null) {
                    this.HNB.HMQ.postValue(new a(aVar.errType, aVar.errCode, aVar.errMsg));
                }
                this.HNB.a("", 9, 3, aVar.errCode, aVar.errMsg);
            } else if (aVar.iLC == null) {
                if (this.HNB.HNz == null) {
                    this.HNB.HMQ.postValue(new a(3, -1, ""));
                }
                this.HNB.a("", 9, 3, 3, "callback resp is null");
            } else {
                bop bop = (bop) aVar.iLC;
                if (bop != null) {
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinIncomeDetailViewModel", bop);
                    this.HNB.HNt.postValue(bop.LWK);
                    this.HNB.HNu.postValue(bop.LWL);
                    this.HNB.HNv.postValue(Long.valueOf(bop.LWJ));
                    this.HNB.HNw.postValue(bop.LWN);
                    this.HNB.HNx.postValue(bop.LWM);
                    this.HNB.HNz = bop;
                    this.HNB.a("", 9, 3, 0, "");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212722);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ WeCoinIncomeDetailViewModel HNB;
        final /* synthetic */ String HNC;

        public c(WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel, String str) {
            this.HNB = weCoinIncomeDetailViewModel;
            this.HNC = str;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212723);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.WeCoinIncomeDetailViewModel", "getRealNameAuthRequest errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNB.qiR, Boolean.FALSE);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                this.HNB.HMQ.postValue(new a(aVar.errType, aVar.errCode, aVar.errMsg));
                this.HNB.a(this.HNC, 10, 3, aVar.errCode, aVar.errMsg);
            } else if (aVar.iLC == null) {
                this.HNB.HMQ.postValue(new a(3, -1, ""));
                this.HNB.a(this.HNC, 10, 3, 3, "callback resp is null");
            } else {
                this.HNB.a(this.HNC, 10, 3, 0, "");
                this.HNB.HNy.postValue(Boolean.TRUE);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212723);
            return xVar;
        }
    }

    public WeCoinIncomeDetailViewModel() {
        AppMethodBeat.i(212726);
        AppMethodBeat.o(212726);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void aeH(int i2) {
        AppMethodBeat.i(212724);
        WecoinEncashKVData wecoinEncashKVData = this.HNm;
        if (wecoinEncashKVData != null) {
            int i3 = wecoinEncashKVData.HNZ;
            String str = wecoinEncashKVData.HMK;
            if (str == null) {
                str = "";
            }
            String str2 = wecoinEncashKVData.nZz;
            if (str2 == null) {
                str2 = "";
            }
            h.INSTANCE.a(21655, Integer.valueOf(i3), str, Integer.valueOf(i2), str2);
            AppMethodBeat.o(212724);
            return;
        }
        AppMethodBeat.o(212724);
    }

    public final void a(String str, int i2, int i3, int i4, String str2) {
        String str3;
        AppMethodBeat.i(212725);
        WecoinEncashKVData wecoinEncashKVData = this.HNm;
        if (wecoinEncashKVData == null || (str3 = wecoinEncashKVData.HMK) == null) {
            str3 = "";
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        WecoinEncashKVData wecoinEncashKVData2 = this.HNm;
        objArr[0] = wecoinEncashKVData2 != null ? Integer.valueOf(wecoinEncashKVData2.HNZ) : 1;
        objArr[1] = str3;
        objArr[2] = str;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = str2;
        hVar.a(22129, objArr);
        AppMethodBeat.o(212725);
    }
}
