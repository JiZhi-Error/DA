package com.tencent.mm.plugin.wallet.wecoin.model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.dpg;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0 J\u0006\u0010#\u001a\u00020\u0015J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190 J\u0010\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u000fJ\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050 J\u001a\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u00152\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eJ(\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010\u0017J\u000e\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020+R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "isShowProgressDialog", "Landroid/arch/lifecycle/MutableLiveData;", "", "mCgiRespInfo", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "mCtxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "mEncashResultPageInfo", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "mInterceptPopUp", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "mKVData", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "getMKVData", "()Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "setMKVData", "(Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;)V", "mLastFetchAccount", "", "mUniqueId", "", "wxTokenParams", "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "encashIncome", "", "token", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCgiRespInfo", "Landroid/arch/lifecycle/LiveData;", "getEncashResultPageInfo", "getInterceptPopUp", "getLastFetchAccount", "getWXTokenParams", "initKVData", "kvData", "prepareWecoinEncash", "amount", "reportCgiKVStatus", "operationType", "", "stepID", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "reportKVStatus", "value", "Companion", "plugin-wxpay_release"})
public final class WeCoinEncashViewModel extends ViewModel {
    public static final a HNn = new a((byte) 0);
    public final MutableLiveData<a> HMQ = new MutableLiveData<>();
    public final MutableLiveData<dek> HMS = new MutableLiveData<>();
    public final MutableLiveData<fbz> HNi = new MutableLiveData<>();
    public final MutableLiveData<ajj> HNj = new MutableLiveData<>();
    public long HNk;
    private com.tencent.mm.bw.b HNl;
    public WecoinEncashKVData HNm;
    public final MutableLiveData<Boolean> qiR = new MutableLiveData<>();
    public String zfX;

    static {
        AppMethodBeat.i(212721);
        AppMethodBeat.o(212721);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ WeCoinEncashViewModel HNo;
        final /* synthetic */ String HNp;
        final /* synthetic */ com.tencent.mm.vending.e.b HNq;

        b(WeCoinEncashViewModel weCoinEncashViewModel, String str, com.tencent.mm.vending.e.b bVar) {
            this.HNo = weCoinEncashViewModel;
            this.HNp = str;
            this.HNq = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            aji aji;
            dpg dpg;
            AppMethodBeat.i(212715);
            c.a aVar = (c.a) obj;
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNo.qiR, Boolean.FALSE);
            Log.i("MicroMsg.WeCoinEncashViewModel", "encashIncome errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                this.HNo.f(7, 3, aVar.errCode, aVar.errMsg);
                h.INSTANCE.dN(1581, 98);
                if (aVar.errCode != 10001 || (aji = (aji) aVar.iLC) == null || (dpg = aji.LoD) == null) {
                    this.HNo.HMQ.postValue(new a(aVar.errType, aVar.errCode, aVar.errMsg));
                } else {
                    T t = aVar.iLC;
                    p.g(t, "cgiBack.resp");
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinEncashViewModel", t);
                    com.tencent.f.h.RTc.o(new a(this, aVar), (long) dpg.MSB);
                }
            } else if (aVar.iLC == null) {
                h.INSTANCE.dN(1581, 98);
                this.HNo.HMQ.postValue(new a(3, -1, ""));
                this.HNo.f(7, 3, -1, "callback resp is null");
            } else {
                aji aji2 = (aji) aVar.iLC;
                if (aji2 != null) {
                    this.HNo.f(7, 3, 0, "");
                    h.INSTANCE.dN(1581, 97);
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinEncashViewModel", aji2);
                    this.HNo.HNj.postValue(aji2.LsS);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212715);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel$encashIncome$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ b HNr;
            final /* synthetic */ c.a HNs;

            a(b bVar, c.a aVar) {
                this.HNr = bVar;
                this.HNs = aVar;
            }

            public final void run() {
                AppMethodBeat.i(212714);
                this.HNr.HNo.a(this.HNr.HNp, this.HNr.HNq);
                AppMethodBeat.o(212714);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "kotlin.jvm.PlatformType", "call"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ WeCoinEncashViewModel HNo;

        public c(WeCoinEncashViewModel weCoinEncashViewModel) {
            this.HNo = weCoinEncashViewModel;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            cdg cdg;
            String str;
            AppMethodBeat.i(212716);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.WeCoinEncashViewModel", "prepareWecoinEncash errorType: " + aVar.errType + ", errorCode: " + aVar.errCode + ", errorMsg: " + aVar.errMsg);
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.HNo.qiR, Boolean.FALSE);
            p.g(aVar, "cgiBack");
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.h(aVar)) {
                h.INSTANCE.dN(1581, 92);
                dek dek = (dek) aVar.iLC;
                if (dek == null || (cdg = dek.MJy) == null) {
                    this.HNo.HMQ.postValue(new a(aVar.errType, aVar.errCode, aVar.errMsg));
                    this.HNo.f(6, 3, aVar.errCode, aVar.errMsg);
                } else {
                    T t = aVar.iLC;
                    p.g(t, "cgiBack.resp");
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinEncashViewModel", t);
                    h.INSTANCE.dN(1581, 99);
                    this.HNo.HMS.postValue(aVar.iLC);
                    WeCoinEncashViewModel weCoinEncashViewModel = this.HNo;
                    int i2 = aVar.errCode;
                    if (cdg != null) {
                        str = cdg.dQx;
                    } else {
                        str = null;
                    }
                    weCoinEncashViewModel.f(6, 3, i2, str);
                }
            } else if (aVar.iLC == null) {
                h.INSTANCE.dN(1581, 92);
                this.HNo.HMQ.postValue(new a(3, -1, ""));
                this.HNo.f(6, 3, 3, "callback resp is null");
            } else {
                dek dek2 = (dek) aVar.iLC;
                if (dek2 != null) {
                    h.INSTANCE.dN(1581, 91);
                    com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinEncashViewModel", dek2);
                    this.HNo.HNl = dek2.Loz;
                    this.HNo.HNi.postValue(dek2.MJx);
                    this.HNo.f(6, 3, 0, "");
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(212716);
            return xVar;
        }
    }

    public WeCoinEncashViewModel() {
        AppMethodBeat.i(212720);
        AppMethodBeat.o(212720);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(String str, com.tencent.mm.vending.e.b<?> bVar) {
        byte[] bArr;
        AppMethodBeat.i(212717);
        p.h(str, "token");
        p.h(bVar, "keeper");
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.TRUE);
        f(7, 1, 0, "");
        h.INSTANCE.dN(1581, 96);
        if (this.HNl == null) {
            Log.i("MicroMsg.WeCoinEncashViewModel", "mCtxBuff is null!");
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.FALSE);
            this.HMQ.postValue(new a(3, -1, ""));
            h.INSTANCE.dN(1581, 98);
            f(7, 3, -1, "mCtxBuff is null");
            AppMethodBeat.o(212717);
            return;
        }
        com.tencent.mm.network.b bjq = com.tencent.mm.network.b.bjq();
        com.tencent.mm.bw.b bVar2 = this.HNl;
        if (bVar2 != null) {
            bArr = bVar2.zy;
        } else {
            bArr = null;
        }
        byte[] az = bjq.az(bArr);
        if (az == null) {
            Log.i("MicroMsg.WeCoinEncashViewModel", "signedByte is null!");
            com.tencent.mm.plugin.wallet.wecoin.c.a.a(this.qiR, Boolean.FALSE);
            this.HMQ.postValue(new a(3, 4, ""));
            f(7, 3, 4, "sign data failed");
            h.INSTANCE.dN(1581, 98);
            h.INSTANCE.dN(1581, 100);
            AppMethodBeat.o(212717);
            return;
        }
        com.tencent.mm.bw.b bVar3 = this.HNl;
        if (bVar3 == null) {
            p.hyc();
        }
        new com.tencent.mm.plugin.wallet.wecoin.b.c(str, bVar3, new com.tencent.mm.bw.b(az)).aYI().b(new b(this, str, bVar)).a(bVar);
        AppMethodBeat.o(212717);
    }

    public final void aeH(int i2) {
        AppMethodBeat.i(212718);
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
            AppMethodBeat.o(212718);
            return;
        }
        AppMethodBeat.o(212718);
    }

    public final void f(int i2, int i3, int i4, String str) {
        String str2;
        AppMethodBeat.i(212719);
        WecoinEncashKVData wecoinEncashKVData = this.HNm;
        if (wecoinEncashKVData == null || (str2 = wecoinEncashKVData.HMK) == null) {
            str2 = "";
        }
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[7];
        WecoinEncashKVData wecoinEncashKVData2 = this.HNm;
        objArr[0] = wecoinEncashKVData2 != null ? Integer.valueOf(wecoinEncashKVData2.HNZ) : 1;
        objArr[1] = str2;
        objArr[2] = this.zfX;
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(i3);
        objArr[5] = Integer.valueOf(i4);
        objArr[6] = str;
        hVar.a(22129, objArr);
        AppMethodBeat.o(212719);
    }
}
