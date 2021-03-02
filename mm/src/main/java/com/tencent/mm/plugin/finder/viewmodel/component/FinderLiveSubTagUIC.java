package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSubTagUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveSubTagUIC extends FinderLiveTagBaseUIC {
    public static final a wyz = new a((byte) 0);
    public FinderLiveSubTagConstract.Presenter uXC;

    static {
        AppMethodBeat.i(255792);
        AppMethodBeat.o(255792);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveSubTagUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255791);
        AppMethodBeat.o(255791);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSubTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static ArrayList<bo> eJ(List<? extends axk> list) {
        AppMethodBeat.i(255788);
        ArrayList<bo> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new al(it.next()));
            }
        }
        AppMethodBeat.o(255788);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aff;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        LinkedList<axk> linkedList = null;
        AppMethodBeat.i(255789);
        super.onCreate(bundle);
        dIl();
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
        axk axk = new axk();
        try {
            axk.parseFrom(getIntent().getByteArrayExtra("KEY_TAG_INFO"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            axk = null;
        }
        axk axk2 = axk;
        if (axk2 != null) {
            linkedList = axk2.LHT;
        }
        this.uXC = new FinderLiveSubTagConstract.Presenter(axk2, eJ(linkedList), booleanExtra);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255789);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        FinderLiveSubTagConstract.Presenter presenter = this.uXC;
        if (presenter == null) {
            p.btv("presenter");
        }
        FinderLiveSubTagConstract.ViewCallback viewCallback = new FinderLiveSubTagConstract.ViewCallback(mMActivity, presenter);
        FinderLiveSubTagConstract.Presenter presenter2 = this.uXC;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        presenter2.a(viewCallback);
        AppMethodBeat.o(255789);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255790);
        super.onDestroy();
        if (this.uXC != null) {
            FinderLiveSubTagConstract.Presenter presenter = this.uXC;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255790);
    }
}
