package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001b\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH&J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fJ\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u001fJ\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fJ\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00180\u001fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u001fJ\b\u0010 \u001a\u00020\u001cH&J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\fH&J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%J\u0014\u0010&\u001a\u00020\u001c2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH&J\b\u0010'\u001a\u00020\u001cH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR&\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00180\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "cardListState", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "getCardListState", "()Landroid/arch/lifecycle/MutableLiveData;", "setCardListState", "(Landroid/arch/lifecycle/MutableLiveData;)V", "cardListViewData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getCardListViewData", "setCardListViewData", "isShowProgressDialog", "", "setShowProgressDialog", "jumpUrlOption", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "getJumpUrlOption", "setJumpUrlOption", "rightTopOptionMenuData", "", "getRightTopOptionMenuData", "setRightTopOptionMenuData", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Landroid/arch/lifecycle/LiveData;", "loadSnapshot", "performDeleteCard", "cardDataModel", "performMenuItemClicked", FirebaseAnalytics.b.INDEX, "", "refreshCardListIncrementally", "saveSnapshot", "plugin-card_release"})
public abstract class CardsViewModel extends ViewModel {
    MutableLiveData<List<ue>> qiN = new MutableLiveData<>();
    MutableLiveData<ue> qiO = new MutableLiveData<>();
    MutableLiveData<ArrayList<a>> qiP = new MutableLiveData<>();
    MutableLiveData<e> qiQ = new MutableLiveData<>();
    MutableLiveData<Boolean> qiR = new MutableLiveData<>();

    public abstract void a(a aVar);

    public abstract void c(b<?> bVar);

    public abstract void cxu();

    public abstract void cxv();

    public abstract void d(b<?> bVar);

    public final void EG(int i2) {
        MutableLiveData<ue> mutableLiveData = this.qiO;
        List<ue> value = this.qiN.getValue();
        mutableLiveData.postValue(value != null ? value.get(i2) : null);
    }
}
