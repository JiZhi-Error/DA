package com.tencent.mm.plugin.topstory.ui.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\nH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0014\u0010\f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/topstory/ui/multitask/TopStoryMultiTaskHelper;", "Lcom/tencent/mm/plugin/multitask/helper/PageMultiTaskHelper;", "pageAdapter", "Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;", "(Lcom/tencent/mm/plugin/multitask/adapter/IMultiTaskPageAdapter;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isSupportExitToMultiTask", "", "()Z", "isSupportSwipeToMultiTask", "isSupportSwipeToHome", "onCreate", "", "multiTaskType", "", "multiTaskId", "updateFloatBallData", "topStoryVideoContext", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoContext;", "currentVideoInfo", "Lcom/tencent/mm/protocal/protobuf/TopStoryVideoInfo;", "ui-topstory_release"})
public final class a extends c {
    private final String TAG;

    private /* synthetic */ a() {
        this(null);
    }

    public a(com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        this.TAG = "MicroMsg.TopStoryMultiTaskHelper";
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void G(int i2, String str) {
        AppMethodBeat.i(236421);
        super.G(i2, str);
        AppMethodBeat.o(236421);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPs() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean dki() {
        return true;
    }

    public final void a(eit eit, eiw eiw) {
        cru erh;
        AppMethodBeat.i(236422);
        p.h(eit, "topStoryVideoContext");
        p.h(eiw, "currentVideoInfo");
        Log.i(this.TAG, "updateFloatBallData contextId:%s videoId:%s", eit.sGQ, eiw.psI);
        eiv eiv = new eiv();
        eiv.NhX = eit.NhX;
        eiv.NhY = eit.NhY;
        if (Util.isNullOrNil(eit.hes)) {
            eiv.NhZ = eit.NhZ;
        } else {
            eiv.NhZ = eit.hes;
        }
        eiv.Nia = eit.Nia;
        eiv.Nid = eit.Nid;
        eiv.sGQ = eit.sGQ;
        eiv.Nik = eit.Nik;
        eiv.offset = eit.offset;
        eiv.Nib = eit.Nib;
        eiv.scene = eit.scene;
        eiv.dDv = eit.dDv;
        eiv.IDO = eiw.IDO;
        eiv.Mub.add(eiw);
        try {
            MultiTaskInfo multiTaskInfo = this.Abp;
            if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
                erh.title = eiw.title;
            }
            MultiTaskInfo multiTaskInfo2 = this.Abp;
            if (multiTaskInfo2 != null) {
                multiTaskInfo2.field_data = eiv.toByteArray();
            }
            eqX();
            AppMethodBeat.o(236422);
        } catch (Exception e2) {
            Log.printErrStackTrace(this.TAG, e2, "updateFloatBallData exception:%s", e2);
            AppMethodBeat.o(236422);
        }
    }
}
