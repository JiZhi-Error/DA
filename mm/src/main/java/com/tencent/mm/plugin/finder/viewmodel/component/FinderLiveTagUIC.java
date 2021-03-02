package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagUIC;", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagBaseUIC;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "convertTagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "tagInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLayoutId", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveTagUIC extends FinderLiveTagBaseUIC {
    public static final a wyB = new a((byte) 0);
    public FinderLiveTagConstract.Presenter uXI;

    static {
        AppMethodBeat.i(255798);
        AppMethodBeat.o(255798);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveTagUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255797);
        AppMethodBeat.o(255797);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveTagUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static ArrayList<bo> eJ(List<? extends axk> list) {
        AppMethodBeat.i(255793);
        ArrayList<bo> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new al(it.next()));
        }
        AppMethodBeat.o(255793);
        return arrayList;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.afj;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255794);
        super.onCreate(bundle);
        dIl();
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_HAS_NEXT_ACTION", false);
        ArrayList arrayList = new ArrayList();
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_TAG_INFO");
        if (!(serializableExtra instanceof List)) {
            serializableExtra = null;
        }
        List<byte[]> list = (List) serializableExtra;
        if (list != null) {
            for (byte[] bArr : list) {
                axk axk = new axk();
                axk.parseFrom(bArr);
                arrayList.add(axk);
            }
        }
        this.uXI = new FinderLiveTagConstract.Presenter(eJ(arrayList), booleanExtra);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255794);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        FinderLiveTagConstract.Presenter presenter = this.uXI;
        if (presenter == null) {
            p.btv("presenter");
        }
        FinderLiveTagConstract.ViewCallback viewCallback = new FinderLiveTagConstract.ViewCallback(mMActivity, presenter);
        FinderLiveTagConstract.Presenter presenter2 = this.uXI;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        presenter2.a(viewCallback);
        AppMethodBeat.o(255794);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255795);
        super.onDestroy();
        if (this.uXI != null) {
            FinderLiveTagConstract.Presenter presenter = this.uXI;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255795);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        FinderLiveTagConstract.ViewCallback viewCallback;
        AppMethodBeat.i(255796);
        FinderLiveTagConstract.Presenter presenter = this.uXI;
        if (presenter == null) {
            p.btv("presenter");
        }
        if (i3 == -1 && i2 == 1 && (viewCallback = presenter.uXF) != null) {
            viewCallback.amT();
            AppMethodBeat.o(255796);
            return;
        }
        AppMethodBeat.o(255796);
    }
}
