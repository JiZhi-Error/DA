package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.card.model.c.e;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J,\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0014\u0010\u0019\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J$\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "Lcom/tencent/mm/protocal/protobuf/CouponAndGiftList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class CouponHistoryCardListViewModel extends CardsViewModel {
    public static final a qjl = new a((byte) 0);
    private final int qhC = 10;
    private final int qja = 5;
    private int qjb;
    private blw qjj;
    private final ArrayList<a> qjk = new ArrayList<>();

    static {
        AppMethodBeat.i(201676);
        AppMethodBeat.o(201676);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.b<c.a<blw>, x> {
        final /* synthetic */ CouponHistoryCardListViewModel qjm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CouponHistoryCardListViewModel couponHistoryCardListViewModel) {
            super(1);
            this.qjm = couponHistoryCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<blw> aVar) {
            String str;
            blw blw;
            AppMethodBeat.i(201666);
            c.a<blw> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.HistoryCardListViewModel", "Force refresh card, errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (blw = (blw) aVar2.iLC) != null) {
                    Log.i("MicroMsg.HistoryCardListViewModel", "Force refresh card, retcode: " + blw.LUH + ", retmsg: " + blw.pUa);
                    if (blw.LUH == 0) {
                        this.qjm.qjb = 0;
                        if (blw.LUI) {
                            this.qjm.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjm.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjm.qjj = blw;
                        this.qjm.qiN.postValue(blw.LUK);
                        MutableLiveData<ArrayList<a>> mutableLiveData = this.qjm.qiP;
                        CouponHistoryCardListViewModel couponHistoryCardListViewModel = this.qjm;
                        adu adu = blw.LUL;
                        p.g(adu, "resp.items_list");
                        mutableLiveData.postValue(CouponHistoryCardListViewModel.a(couponHistoryCardListViewModel, adu));
                    } else {
                        str = blw.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjm.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201666);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel$performDeleteCard$1$1"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ e qjh;
        final /* synthetic */ a qji;
        final /* synthetic */ CouponHistoryCardListViewModel qjm;

        c(e eVar, CouponHistoryCardListViewModel couponHistoryCardListViewModel, a aVar) {
            this.qjh = eVar;
            this.qjm = couponHistoryCardListViewModel;
            this.qji = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(201667);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.HistoryCardListViewModel", "do delete card, errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            String str = "";
            this.qjm.qiR.postValue(Boolean.FALSE);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                dmv dmv = (dmv) aVar.iLC;
                Log.i("MicroMsg.HistoryCardListViewModel", "do delete card, retCode: %s", Integer.valueOf(dmv.pTZ));
                if (dmv.pTZ == 0) {
                    this.qjm.qiQ.postValue(this.qjh);
                    this.qjm.qiP.postValue(CouponHistoryCardListViewModel.a(this.qjm, this.qji));
                    x xVar = x.SXb;
                    AppMethodBeat.o(201667);
                    return xVar;
                }
                str = ((dmv) aVar.iLC).pUa;
                p.g(str, "it.resp.ret_msg");
            }
            e.FAILED.ajT(str);
            this.qjm.qiQ.postValue(e.FAILED);
            x xVar2 = x.SXb;
            AppMethodBeat.o(201667);
            return xVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.b<c.a<blw>, x> {
        final /* synthetic */ CouponHistoryCardListViewModel qjm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CouponHistoryCardListViewModel couponHistoryCardListViewModel) {
            super(1);
            this.qjm = couponHistoryCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<blw> aVar) {
            String str;
            blw blw;
            AppMethodBeat.i(201668);
            c.a<blw> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.HistoryCardListViewModel", "refresh history card, errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (blw = (blw) aVar2.iLC) != null) {
                    Log.i("MicroMsg.HistoryCardListViewModel", "retcode: " + blw.LUH + ", retmsg: " + blw.pUa);
                    if (blw.LUH == 0) {
                        this.qjm.qjb = 0;
                        if (blw.LUI) {
                            this.qjm.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjm.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjm.qjj = blw;
                        this.qjm.qiN.postValue(blw.LUK);
                        MutableLiveData<ArrayList<a>> mutableLiveData = this.qjm.qiP;
                        CouponHistoryCardListViewModel couponHistoryCardListViewModel = this.qjm;
                        adu adu = blw.LUL;
                        p.g(adu, "resp.items_list");
                        mutableLiveData.postValue(CouponHistoryCardListViewModel.a(couponHistoryCardListViewModel, adu));
                    } else {
                        str = blw.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjm.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201668);
            return xVar;
        }
    }

    public CouponHistoryCardListViewModel() {
        AppMethodBeat.i(201675);
        this.qiQ.postValue(e.IDLE);
        AppMethodBeat.o(201675);
    }

    public static final /* synthetic */ ArrayList a(CouponHistoryCardListViewModel couponHistoryCardListViewModel, adu adu) {
        AppMethodBeat.i(201677);
        ArrayList<a> a2 = couponHistoryCardListViewModel.a(adu, true);
        AppMethodBeat.o(201677);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final ArrayList<a> a(adu adu, boolean z) {
        ArrayList<a> arrayList;
        AppMethodBeat.i(201669);
        if (adu != null) {
            if (!z) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = this.qjk;
            }
            Iterator<ua> it = adu.iAd.iterator();
            while (it.hasNext()) {
                ua next = it.next();
                a aVar = new a();
                aVar.qiw = next;
                if (next.LcU == 1) {
                    aVar.type = 5;
                } else {
                    aVar.type = 3;
                }
                arrayList.add(aVar);
            }
            AppMethodBeat.o(201669);
            return arrayList;
        }
        AppMethodBeat.o(201669);
        return null;
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxu() {
        int i2 = 0;
        AppMethodBeat.i(201673);
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        blw cum = a.C0902a.cum();
        if (cum != null) {
            this.qiN.postValue(cum.LUK);
            adu adu = cum.LUL;
            p.g(adu, "items_list");
            ArrayList<a> a2 = a(adu, false);
            if (a2 != null) {
                i2 = a2.size();
            }
            this.qjb = i2;
            this.qiP.postValue(a2);
            AppMethodBeat.o(201673);
            return;
        }
        AppMethodBeat.o(201673);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxv() {
        AppMethodBeat.i(201674);
        blw blw = this.qjj;
        if (blw != null) {
            adu adu = new adu();
            if (!this.qjk.isEmpty()) {
                Iterator<a> it = this.qjk.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.qiw != null) {
                        adu.iAd.add(next.qiw);
                    }
                }
            }
            blw.LUL = adu;
            a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
            p.h(blw, "response");
            Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save coupon History card list snapshot");
            com.tencent.mm.ac.d.i(new a.C0902a.c(blw));
            AppMethodBeat.o(201674);
            return;
        }
        AppMethodBeat.o(201674);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void c(com.tencent.mm.vending.e.b<?> bVar) {
        long j2;
        int i2;
        long j3 = 0;
        AppMethodBeat.i(201670);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING || value == e.UP_TO_DATE) {
            AppMethodBeat.o(201670);
            return;
        }
        this.qiQ.postValue(e.LOADING);
        if (this.qjb > 0) {
            int i3 = this.qjb;
            if (i3 < this.qhC) {
                i3 = this.qhC;
            }
            i2 = i3 + this.qjb;
        } else {
            blw blw = this.qjj;
            if (blw != null) {
                j2 = blw.LUJ;
            } else {
                j2 = 0;
            }
            i2 = this.qhC;
            j3 = j2;
        }
        f aYI = new com.tencent.mm.plugin.card.model.c.b(j3, (long) i2).aYH().aYI();
        p.g(aYI, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new d(this)).b(bVar);
        AppMethodBeat.o(201670);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void d(com.tencent.mm.vending.e.b<?> bVar) {
        AppMethodBeat.i(201671);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING) {
            AppMethodBeat.o(201671);
            return;
        }
        this.qiQ.postValue(e.LOADING);
        int i2 = 0;
        if (this.qjb > 0) {
            i2 = this.qjb;
        } else if (this.qjk.size() > 0) {
            i2 = this.qjk.size() + 0;
        }
        if (i2 < this.qhC) {
            i2 = this.qhC;
        }
        int i3 = i2 + this.qja;
        this.qjk.clear();
        f aYI = new com.tencent.mm.plugin.card.model.c.b(0, (long) i3).aYH().aYI();
        p.g(aYI, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new b(this)).b(bVar);
        AppMethodBeat.o(201671);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void a(a aVar) {
        AppMethodBeat.i(201672);
        p.h(aVar, "cardDataModel");
        ua uaVar = aVar.qiw;
        if (uaVar != null) {
            Log.i("MicroMsg.HistoryCardListViewModel", "do delete card: %s", uaVar.KDM);
            e value = this.qiQ.getValue();
            if (value == e.LOADING || value == e.DELETING) {
                AppMethodBeat.o(201672);
                return;
            }
            this.qiR.postValue(Boolean.TRUE);
            this.qiQ.postValue(e.DELETING);
            String str = uaVar.KDM;
            p.g(str, "user_card_id");
            new e(str).aYI().b(new c(value, this, aVar));
            AppMethodBeat.o(201672);
            return;
        }
        AppMethodBeat.o(201672);
    }

    public static final /* synthetic */ ArrayList a(CouponHistoryCardListViewModel couponHistoryCardListViewModel, a aVar) {
        String str = null;
        AppMethodBeat.i(201678);
        ArrayList<a> arrayList = couponHistoryCardListViewModel.qjk;
        StringBuilder append = new StringBuilder("remove card, is removed: ").append(arrayList != null ? Boolean.valueOf(arrayList.remove(aVar)) : null).append(", data type: ").append(aVar.type).append(", errMsg: ");
        ua uaVar = aVar.qiw;
        if (uaVar != null) {
            str = uaVar.KDM;
        }
        Log.i("MicroMsg.HistoryCardListViewModel", append.append(str).toString());
        AppMethodBeat.o(201678);
        return arrayList;
    }
}
