package com.tencent.mm.plugin.topstory.ui.multitask.uic;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J,\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/topstory/ui/multitask/uic/TopStoryMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "onMultiTaskItemClick", "", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "", "ui-topstory_release"})
public final class TopStoryMultiTaskUIC extends MultiTaskUIComponent {
    private final String TAG = "MicroMsg.TopStory.TopStoryMultiTaskUIC";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopStoryMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(236426);
        AppMethodBeat.o(236426);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopStoryMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(236427);
        AppMethodBeat.o(236427);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        AppMethodBeat.i(236425);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        byte[] bArr = multiTaskInfo.field_data;
        eiv eiv = new eiv();
        try {
            eiv.parseFrom(bArr);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "handleBallInfoClicked exception:%s", e2);
        }
        if (eiv.Mub.size() > 0) {
            eit eit = new eit();
            eit.scene = eiv.scene;
            eit.Nid = eiv.Nid;
            eit.Nic = eiv.Mub.get(0);
            eit.NhX = eit.Nic.psI;
            eit.NhZ = eiv.NhZ;
            eit.NhY = eiv.NhY;
            eit.Nia = eiv.Nia;
            eit.Nib = eiv.Nib;
            eit.sGQ = eiv.sGQ;
            eit.Nik = eiv.Nik;
            eit.offset = eiv.offset;
            eit.dDv = eiv.dDv;
            eit.IDO = eiv.IDO;
            Log.i(this.TAG, "handleBallInfoClicked, contextId:%s videoId:%s", eit.sGQ, eit.Nic.psI);
            ai.a(getActivity(), eit, crq);
            getActivity().overridePendingTransition(0, 0);
            AppMethodBeat.o(236425);
            return;
        }
        Log.e(this.TAG, "handleBallInfoClicked, cache video list size == 0");
        AppMethodBeat.o(236425);
    }
}
