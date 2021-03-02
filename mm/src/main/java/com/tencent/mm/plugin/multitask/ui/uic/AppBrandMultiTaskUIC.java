package com.tencent.mm.plugin.multitask.ui.uic;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.io.IOException;

public class AppBrandMultiTaskUIC extends MultiTaskUIComponent {
    public AppBrandMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
    }

    public AppBrandMultiTaskUIC(Fragment fragment) {
        super(fragment);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        AppMethodBeat.i(236429);
        er erVar = new er();
        try {
            erVar.parseFrom(multiTaskInfo.field_data);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandMultiTaskUIC", e2, "onMultiTaskItemClick exception:%s", e2.getMessage());
        }
        ParcelableMultiTaskData parcelableMultiTaskData = new ParcelableMultiTaskData();
        parcelableMultiTaskData.kHu = new ach();
        parcelableMultiTaskData.kHu.LmQ = crq;
        if (view != null) {
            SecDataUIC.a aVar = SecDataUIC.CWq;
            if (SecDataUIC.a.gU(view.getContext()) != null) {
                SecDataUIC.a aVar2 = SecDataUIC.CWq;
                crt crt = (crt) SecDataUIC.a.gU(view.getContext()).Xh(5);
                if (crt instanceof crt) {
                    parcelableMultiTaskData.kHu.sGQ = crt.sGQ;
                }
            }
        }
        g gVar = new g();
        gVar.username = erVar.username;
        gVar.appId = erVar.appId;
        gVar.iOo = erVar.iOo;
        Log.i("MicroMsg.AppBrandMultiTaskUIC", "onMultiTaskItemClick username:%s,appid:%s,versionType:%d", erVar.username, erVar.appId, Integer.valueOf(erVar.iOo));
        gVar.kHP = parcelableMultiTaskData;
        gVar.scene = 1187;
        ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.tUQ, gVar);
        AppMethodBeat.o(236429);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(MStorageEventData mStorageEventData) {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 1;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }
}
