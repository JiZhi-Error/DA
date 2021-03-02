package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a;
import com.tencent.mm.protocal.protobuf.agl;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J2\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0014\u0010\u001a\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016J$\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class MemberHistoryCardListViewModel extends CardsViewModel {
    public static final a qjC = new a((byte) 0);
    private final int qhC = 10;
    private bqi qjB;
    private final int qja = 5;
    private int qjb;
    private final ArrayList<a> qjk = new ArrayList<>();

    static {
        AppMethodBeat.i(201723);
        AppMethodBeat.o(201723);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.b<c.a<bqi>, x> {
        final /* synthetic */ MemberHistoryCardListViewModel qjD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(MemberHistoryCardListViewModel memberHistoryCardListViewModel) {
            super(1);
            this.qjD = memberHistoryCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bqi> aVar) {
            String str;
            bqi bqi;
            AppMethodBeat.i(201713);
            c.a<bqi> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.MemberHistoryCardListViewModel", "force refresh member history card, errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (bqi = (bqi) aVar2.iLC) != null) {
                    Log.i("MicroMsg.MemberHistoryCardListViewModel", "retcode: " + bqi.LUH + ", retmsg: " + bqi.pUa);
                    if (bqi.LUH == 0) {
                        this.qjD.qjb = 0;
                        if (bqi.LUI) {
                            this.qjD.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjD.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjD.qjB = bqi;
                        this.qjD.qiN.postValue(bqi.LUK);
                        MutableLiveData<ArrayList<a>> mutableLiveData = this.qjD.qiP;
                        MemberHistoryCardListViewModel memberHistoryCardListViewModel = this.qjD;
                        LinkedList<ua> linkedList = bqi.iAd;
                        p.g(linkedList, "resp.items");
                        mutableLiveData.postValue(MemberHistoryCardListViewModel.a(memberHistoryCardListViewModel, linkedList));
                    } else {
                        str = bqi.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjD.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201713);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel$performDeleteCard$1$1"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ MemberHistoryCardListViewModel qjD;
        final /* synthetic */ e qjh;
        final /* synthetic */ a qji;

        c(e eVar, MemberHistoryCardListViewModel memberHistoryCardListViewModel, a aVar) {
            this.qjh = eVar;
            this.qjD = memberHistoryCardListViewModel;
            this.qji = aVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(201714);
            c.a aVar = (c.a) obj;
            Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card, errtype: %s, errcode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            String str = "";
            this.qjD.qiR.postValue(Boolean.FALSE);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                agl agl = (agl) aVar.iLC;
                Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card, retCode: %s", Integer.valueOf(agl.pTZ));
                if (agl.pTZ == 0) {
                    this.qjD.qiQ.postValue(this.qjh);
                    this.qjD.qiP.postValue(MemberHistoryCardListViewModel.a(this.qjD, this.qji));
                    x xVar = x.SXb;
                    AppMethodBeat.o(201714);
                    return xVar;
                }
                str = ((agl) aVar.iLC).pUa;
                p.g(str, "it.resp.ret_msg");
            }
            e.FAILED.ajT(str);
            this.qjD.qiQ.postValue(e.FAILED);
            x xVar2 = x.SXb;
            AppMethodBeat.o(201714);
            return xVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.b<c.a<bqi>, x> {
        final /* synthetic */ MemberHistoryCardListViewModel qjD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MemberHistoryCardListViewModel memberHistoryCardListViewModel) {
            super(1);
            this.qjD = memberHistoryCardListViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(c.a<bqi> aVar) {
            String str;
            bqi bqi;
            AppMethodBeat.i(201715);
            c.a<bqi> aVar2 = aVar;
            if (aVar2 != null) {
                Log.i("MicroMsg.MemberHistoryCardListViewModel", "refresh member history card, errType: " + aVar2.errType + ", errCode: " + aVar2.errCode + ", errMsg: " + aVar2.errMsg);
                if (aVar2.errType == 0 && aVar2.errCode == 0 && (bqi = (bqi) aVar2.iLC) != null) {
                    Log.i("MicroMsg.MemberHistoryCardListViewModel", "refresh member history card, retcode: " + bqi.LUH + ", retmsg: " + bqi.pUa);
                    if (bqi.LUH == 0) {
                        this.qjD.qjb = 0;
                        if (bqi.LUI) {
                            this.qjD.qiQ.postValue(e.UP_TO_DATE);
                        } else {
                            this.qjD.qiQ.postValue(e.INCOMPLETE);
                        }
                        this.qjD.qjB = bqi;
                        this.qjD.qiN.postValue(bqi.LUK);
                        MutableLiveData<ArrayList<a>> mutableLiveData = this.qjD.qiP;
                        MemberHistoryCardListViewModel memberHistoryCardListViewModel = this.qjD;
                        LinkedList<ua> linkedList = bqi.iAd;
                        p.g(linkedList, "resp.items");
                        mutableLiveData.postValue(MemberHistoryCardListViewModel.a(memberHistoryCardListViewModel, linkedList));
                    } else {
                        str = bqi.pUa;
                        p.g(str, "resp.ret_msg");
                    }
                } else {
                    str = "";
                }
                e.FAILED.ajT(str);
                this.qjD.qiQ.postValue(e.FAILED);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(201715);
            return xVar;
        }
    }

    public MemberHistoryCardListViewModel() {
        AppMethodBeat.i(201722);
        this.qiQ.postValue(e.IDLE);
        AppMethodBeat.o(201722);
    }

    public static final /* synthetic */ ArrayList a(MemberHistoryCardListViewModel memberHistoryCardListViewModel, List list) {
        AppMethodBeat.i(201724);
        ArrayList<a> d2 = memberHistoryCardListViewModel.d(list, true);
        AppMethodBeat.o(201724);
        return d2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel$Companion;", "", "()V", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final ArrayList<a> d(List<? extends ua> list, boolean z) {
        ArrayList<a> arrayList;
        AppMethodBeat.i(201716);
        if (list != null) {
            if (!z) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = this.qjk;
            }
            for (ua uaVar : list) {
                a aVar = new a();
                aVar.qiw = uaVar;
                aVar.type = 4;
                arrayList.add(aVar);
            }
            AppMethodBeat.o(201716);
            return arrayList;
        }
        AppMethodBeat.o(201716);
        return null;
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxu() {
        int i2;
        AppMethodBeat.i(201720);
        a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
        bqi cun = a.C0902a.cun();
        if (cun != null) {
            this.qiN.postValue(cun.LUK);
            LinkedList<ua> linkedList = cun.iAd;
            p.g(linkedList, "items");
            ArrayList<a> d2 = d(linkedList, false);
            if (d2 != null) {
                i2 = d2.size();
            } else {
                i2 = 0;
            }
            this.qjb = i2;
            this.qiP.postValue(d2);
            AppMethodBeat.o(201720);
            return;
        }
        AppMethodBeat.o(201720);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void cxv() {
        AppMethodBeat.i(201721);
        bqi bqi = this.qjB;
        if (bqi != null) {
            LinkedList<ua> linkedList = new LinkedList<>();
            if (!this.qjk.isEmpty()) {
                Iterator<a> it = this.qjk.iterator();
                while (it.hasNext()) {
                    ua uaVar = it.next().qiw;
                    if (uaVar != null) {
                        linkedList.add(uaVar);
                    }
                }
            }
            bqi.iAd = linkedList;
            a.C0902a aVar = com.tencent.mm.plugin.card.model.a.a.pVg;
            p.h(bqi, "response");
            Log.d(com.tencent.mm.plugin.card.model.a.a.TAG, "save coupon History card list snapshot");
            com.tencent.mm.ac.d.i(new a.C0902a.f(bqi));
            AppMethodBeat.o(201721);
            return;
        }
        AppMethodBeat.o(201721);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void c(com.tencent.mm.vending.e.b<?> bVar) {
        long j2;
        int i2;
        long j3 = 0;
        AppMethodBeat.i(201717);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING || value == e.UP_TO_DATE) {
            AppMethodBeat.o(201717);
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
            bqi bqi = this.qjB;
            if (bqi != null) {
                j2 = bqi.LUJ;
            } else {
                j2 = 0;
            }
            i2 = this.qhC;
            j3 = j2;
        }
        f aYI = new com.tencent.mm.plugin.card.model.c.d(j3, (long) i2).aYH().aYI();
        p.g(aYI, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new d(this)).b(bVar);
        AppMethodBeat.o(201717);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void d(com.tencent.mm.vending.e.b<?> bVar) {
        AppMethodBeat.i(201718);
        p.h(bVar, "keeper");
        e value = this.qiQ.getValue();
        if (value == e.LOADING || value == e.DELETING) {
            AppMethodBeat.o(201718);
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
        f aYI = new com.tencent.mm.plugin.card.model.c.d(0, (long) i3).aYH().aYI();
        p.g(aYI, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
        com.tencent.mm.ac.d.b(aYI, new b(this)).b(bVar);
        AppMethodBeat.o(201718);
    }

    @Override // com.tencent.mm.plugin.card.ui.v4.CardsViewModel
    public final void a(a aVar) {
        AppMethodBeat.i(201719);
        p.h(aVar, "cardDataModel");
        ua uaVar = aVar.qiw;
        if (uaVar != null) {
            Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card: %s", uaVar.KDM);
            e value = this.qiQ.getValue();
            if (value == e.LOADING || value == e.DELETING) {
                AppMethodBeat.o(201719);
                return;
            }
            this.qiR.postValue(Boolean.TRUE);
            this.qiQ.postValue(e.DELETING);
            String str = uaVar.KDM;
            p.g(str, "user_card_id");
            new com.tencent.mm.plugin.card.model.a.b(str).aYI().b(new c(value, this, aVar));
            AppMethodBeat.o(201719);
            return;
        }
        AppMethodBeat.o(201719);
    }

    public static final /* synthetic */ ArrayList a(MemberHistoryCardListViewModel memberHistoryCardListViewModel, a aVar) {
        String str = null;
        AppMethodBeat.i(201725);
        ArrayList<a> arrayList = memberHistoryCardListViewModel.qjk;
        StringBuilder append = new StringBuilder("remove card, is removed: ").append(arrayList != null ? Boolean.valueOf(arrayList.remove(aVar)) : null).append(", data type: ").append(aVar.type).append(", errMsg: ");
        ua uaVar = aVar.qiw;
        if (uaVar != null) {
            str = uaVar.KDM;
        }
        Log.i("MicroMsg.MemberHistoryCardListViewModel", append.append(str).toString());
        AppMethodBeat.o(201725);
        return arrayList;
    }
}
