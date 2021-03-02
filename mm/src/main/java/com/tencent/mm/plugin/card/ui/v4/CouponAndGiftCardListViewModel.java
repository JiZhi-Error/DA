package com.tencent.mm.plugin.card.ui.v4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J,\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0014\u0010\u0019\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016J$\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCouponCards", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mGiftCards", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "response", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class CouponAndGiftCardListViewModel extends CardsViewModel {
    public static final a qjf = new a((byte) 0);
    private final int qhC = 10;
    private final int qja = 5;
    private int qjb;
    private bly qjc;
    private final ArrayList<a> qjd = new ArrayList<>();
    private final ArrayList<a> qje = new ArrayList<>();

    static {
        AppMethodBeat.i(201663);
        AppMethodBeat.o(201663);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<c.a<bly>, x> {
        final /* synthetic */ CouponAndGiftCardListViewModel qjg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(CouponAndGiftCardListViewModel couponAndGiftCardListViewModel) {
            super(1);
            this.qjg = couponAndGiftCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bly> aVar) {
            String str;
            bly bly;
            AppMethodBeat.i(201653);
            c.a<bly> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.CouponAndGiftCardViewModel", "force get card list errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (bly = (bly) aVar2.iLC) != null) {
                    Log.i("MicroMsg.CouponAndGiftCardViewModel", "force get card list retcode: " + bly.LUH + ", retmsg: " + bly.pUa);
                    if (bly.LUH == 0) {
                        this.qjg.qjb = 0;
                        if (bly.LUI) {
                            this.qjg.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjg.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjg.qjc = bly;
                        this.qjg.qiN.postValue(bly.LUK);
                        this.qjg.qiP.postValue(CouponAndGiftCardListViewModel.b(this.qjg, bly));
                    } else {
                        str = bly.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjg.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201653);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel$performDeleteCard$1$1"})
    public static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ CouponAndGiftCardListViewModel qjg;
        final /* synthetic */ e qjh;
        final /* synthetic */ a qji;

        c(e eVar, CouponAndGiftCardListViewModel couponAndGiftCardListViewModel, a aVar) {
            this.qjh = eVar;
            this.qjg = couponAndGiftCardListViewModel;
            this.qji = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(201654);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            String str = "";
            this.qjg.qiR.postValue(Boolean.FALSE);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ago ago = (ago) aVar.iLC;
                Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card retCode: %s", Integer.valueOf(ago.pTZ));
                if (ago.pTZ == 0) {
                    this.qjg.qiQ.postValue(this.qjh);
                    this.qjg.qiP.postValue(CouponAndGiftCardListViewModel.a(this.qjg, this.qji));
                    x xVar = x.SXb;
                    AppMethodBeat.o(201654);
                    return xVar;
                }
                str = ((ago) aVar.iLC).pUa;
                p.g(str, "it.resp.ret_msg");
            }
            e.FAILED.ajT(str);
            this.qjg.qiQ.postValue(e.FAILED);
            x xVar2 = x.SXb;
            AppMethodBeat.o(201654);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<c.a<bly>, x> {
        final /* synthetic */ CouponAndGiftCardListViewModel qjg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(CouponAndGiftCardListViewModel couponAndGiftCardListViewModel) {
            super(1);
            this.qjg = couponAndGiftCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bly> aVar) {
            String str;
            bly bly;
            AppMethodBeat.i(201655);
            c.a<bly> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.CouponAndGiftCardViewModel", "refresh coupon and gift list errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (bly = (bly) aVar2.iLC) != null) {
                    Log.i("MicroMsg.CouponAndGiftCardViewModel", "refresh coupon and gift list retcode: " + bly.LUH + ", retmsg: " + bly.pUa);
                    if (bly.LUH == 0) {
                        this.qjg.qjb = 0;
                        if (bly.LUI) {
                            this.qjg.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjg.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjg.qjc = bly;
                        this.qjg.qiN.postValue(bly.LUK);
                        this.qjg.qiP.postValue(CouponAndGiftCardListViewModel.b(this.qjg, bly));
                    } else {
                        str = bly.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjg.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201655);
            return xVar;
        }
    }

    public CouponAndGiftCardListViewModel() {
        AppMethodBeat.i(201662);
        this.qiQ.postValue(e.IDLE);
        AppMethodBeat.o(201662);
    }

    public static final /* synthetic */ ArrayList b(CouponAndGiftCardListViewModel couponAndGiftCardListViewModel, bly bly) {
        AppMethodBeat.i(201664);
        ArrayList<a> a2 = couponAndGiftCardListViewModel.a(bly, true);
        AppMethodBeat.o(201664);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final ArrayList<a> a(bly bly, boolean z) {
        ArrayList<a> arrayList;
        ArrayList<a> arrayList2;
        boolean z2;
        AppMethodBeat.i(201656);
        if (bly != null) {
            ArrayList<a> arrayList3 = new ArrayList<>();
            if (!z) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = this.qjd;
            }
            if (!z) {
                arrayList2 = new ArrayList<>();
            } else {
                arrayList2 = this.qje;
            }
            adu adu = bly.LUM;
            if (adu != null) {
                LinkedList<ua> linkedList = adu.iAd;
                p.g(linkedList, "items");
                if (!linkedList.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (arrayList.isEmpty()) {
                        a aVar = new a();
                        aVar.type = 0;
                        aVar.title = adu.Lpm;
                        arrayList.add(aVar);
                    }
                    Iterator<ua> it = adu.iAd.iterator();
                    while (it.hasNext()) {
                        a aVar2 = new a();
                        aVar2.qiw = it.next();
                        aVar2.type = 2;
                        arrayList.add(aVar2);
                    }
                }
            }
            arrayList3.addAll(arrayList);
            adu adu2 = bly.LUN;
            if (adu2 != null) {
                LinkedList<ua> linkedList2 = adu2.iAd;
                p.g(linkedList2, "items");
                if (!linkedList2.isEmpty()) {
                    if (arrayList2.isEmpty()) {
                        a aVar3 = new a();
                        aVar3.type = 0;
                        aVar3.title = adu2.Lpm;
                        arrayList2.add(aVar3);
                    }
                    Iterator<ua> it2 = adu2.iAd.iterator();
                    while (it2.hasNext()) {
                        a aVar4 = new a();
                        aVar4.qiw = it2.next();
                        aVar4.type = 1;
                        arrayList2.add(aVar4);
                    }
                }
            }
            arrayList3.addAll(arrayList2);
            AppMethodBeat.o(201656);
            return arrayList3;
        }
        AppMethodBeat.o(201656);
        return null;
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxu() {
        int i2 = 0;
        AppMethodBeat.i(201660);
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        bly cul = a.C0902a.cul();
        if (cul == null) {
            AppMethodBeat.o(201660);
            return;
        }
        this.qiN.postValue(cul.LUK);
        ArrayList<a> a2 = a(cul, false);
        if (a2 != null) {
            i2 = a2.size();
        }
        this.qjb = i2;
        this.qiP.postValue(a2);
        AppMethodBeat.o(201660);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxv() {
        boolean z;
        boolean z2;
        String str;
        String str2;
        AppMethodBeat.i(201661);
        bly bly = this.qjc;
        if (bly != null) {
            adu adu = new adu();
            if (!this.qjd.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                a remove = this.qjd.remove(0);
                p.g(remove, "mGiftCards.removeAt(0)");
                a aVar = remove;
                if (aVar == null || (str2 = aVar.title) == null) {
                    str2 = "";
                }
                adu.Lpm = str2;
                Iterator<a> it = this.qjd.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.qiw != null) {
                        adu.iAd.add(next.qiw);
                    }
                }
            }
            bly.LUM = adu;
            adu adu2 = new adu();
            if (!this.qje.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                a remove2 = this.qje.remove(0);
                p.g(remove2, "mCouponCards.removeAt(0)");
                a aVar2 = remove2;
                if (aVar2 == null || (str = aVar2.title) == null) {
                    str = "";
                }
                adu2.Lpm = str;
                Iterator<a> it2 = this.qje.iterator();
                while (it2.hasNext()) {
                    a next2 = it2.next();
                    if (next2.qiw != null) {
                        adu2.iAd.add(next2.qiw);
                    }
                }
            }
            bly.LUN = adu2;
            a.C0902a aVar3 = com.tencent.mm.plugin.card.model.a.a.pVg;
            a.C0902a.a(bly);
            AppMethodBeat.o(201661);
            return;
        }
        AppMethodBeat.o(201661);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void c(com.tencent.mm.vending.e.b<?> bVar) {
        long j2;
        int i2;
        long j3 = 0;
        AppMethodBeat.i(201657);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING || value == e.UP_TO_DATE) {
            AppMethodBeat.o(201657);
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
            bly bly = this.qjc;
            if (bly != null) {
                j2 = bly.LUJ;
            } else {
                j2 = 0;
            }
            i2 = this.qhC;
            j3 = j2;
        }
        f aYI = new com.tencent.mm.plugin.card.model.c.c(j3, (long) i2).aYH().aYI();
        p.g(aYI, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new d(this)).b(bVar);
        AppMethodBeat.o(201657);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void d(com.tencent.mm.vending.e.b<?> bVar) {
        AppMethodBeat.i(201658);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING) {
            AppMethodBeat.o(201658);
            return;
        }
        this.qiQ.postValue(e.LOADING);
        int i2 = 0;
        if (this.qjb > 0) {
            i2 = this.qjb;
        } else {
            if (this.qjd.size() > 0) {
                i2 = this.qjd.size() + 0;
            }
            if (this.qje.size() > 0) {
                i2 += this.qje.size();
            }
        }
        if (i2 < this.qhC) {
            i2 = this.qhC;
        }
        int i3 = i2 + this.qja;
        this.qjd.clear();
        this.qje.clear();
        f aYI = new com.tencent.mm.plugin.card.model.c.c(0, (long) i3).aYH().aYI();
        p.g(aYI, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new b(this)).b(bVar);
        AppMethodBeat.o(201658);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void a(a aVar) {
        AppMethodBeat.i(201659);
        p.h(aVar, "cardDataModel");
        ua uaVar = aVar.qiw;
        if (uaVar != null) {
            Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card: %s", uaVar.KDM);
            e value = this.qiQ.getValue();
            if (value == e.LOADING || value == e.DELETING) {
                AppMethodBeat.o(201659);
                return;
            }
            this.qiR.postValue(Boolean.TRUE);
            this.qiQ.postValue(e.DELETING);
            String str = uaVar.KDM;
            p.g(str, "user_card_id");
            new com.tencent.mm.plugin.card.model.c.a(str).aYI().b(new c(value, this, aVar));
        }
        h.INSTANCE.a(19747, 3, 4);
        AppMethodBeat.o(201659);
    }

    public static final /* synthetic */ ArrayList a(CouponAndGiftCardListViewModel couponAndGiftCardListViewModel, a aVar) {
        AppMethodBeat.i(201665);
        ArrayList<a> value = couponAndGiftCardListViewModel.qiP.getValue();
        boolean remove = value != null ? value.remove(aVar) : false;
        StringBuilder append = new StringBuilder("remove card, is removed: ").append(remove).append(", data type: ").append(aVar.type).append(", errMsg: ");
        ua uaVar = aVar.qiw;
        Log.i("MicroMsg.CouponAndGiftCardViewModel", append.append(uaVar != null ? uaVar.KDM : null).toString());
        if (remove) {
            switch (aVar.type) {
                case 1:
                    couponAndGiftCardListViewModel.qje.remove(aVar);
                    if (couponAndGiftCardListViewModel.qje.size() == 1) {
                        a remove2 = couponAndGiftCardListViewModel.qje.remove(0);
                        p.g(remove2, "mCouponCards.removeAt(0)");
                        a aVar2 = remove2;
                        if (value != null) {
                            value.remove(aVar2);
                            break;
                        }
                    }
                    break;
                case 2:
                    couponAndGiftCardListViewModel.qjd.remove(aVar);
                    if (couponAndGiftCardListViewModel.qjd.size() == 1) {
                        a remove3 = couponAndGiftCardListViewModel.qjd.remove(0);
                        p.g(remove3, "mGiftCards.removeAt(0)");
                        a aVar3 = remove3;
                        if (value != null) {
                            value.remove(aVar3);
                            break;
                        }
                    }
                    break;
            }
        }
        AppMethodBeat.o(201665);
        return value;
    }
}
