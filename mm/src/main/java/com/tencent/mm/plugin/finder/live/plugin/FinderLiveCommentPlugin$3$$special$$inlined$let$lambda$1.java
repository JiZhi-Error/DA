package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$3$1$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLiveCommentPlugin$3$$special$$inlined$let$lambda$1 extends ResultReceiver {
    final /* synthetic */ fgy ULD;
    final /* synthetic */ v.AnonymousClass3 ULE;
    final /* synthetic */ fgy ULF;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveCommentPlugin$3$$special$$inlined$let$lambda$1(fgy fgy, Handler handler, v.AnonymousClass3 r3, fgy fgy2) {
        super(handler);
        this.ULD = fgy;
        this.ULE = r3;
        this.ULF = fgy2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(260594);
        Log.i("Finder.LiveCommentPlugin", "openLuckyMoney result:".concat(String.valueOf(i2)));
        switch (i2) {
            case -1:
                o oVar = o.ujN;
                s finderLiveAssistant = o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.a(this.ULE.uoA.getLiveData().liveInfo.liveId, this.ULE.uoA.getLiveData().hFK, this.ULE.uoA.getLiveData().hwg, this.ULE.uoA.getLiveData().hIt, this.ULD.ViT);
                }
                b bVar = this.ULE.uoA.hOp;
                b.c cVar = b.c.vSj;
                Bundle bundle2 = new Bundle();
                bundle2.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.ULD.ViT);
                bVar.statusChange(cVar, bundle2);
                AppMethodBeat.o(260594);
                return;
            case 0:
                AppMethodBeat.o(260594);
                return;
            case 1:
                b bVar2 = this.ULE.uoA.hOp;
                b.c cVar2 = b.c.vSj;
                Bundle bundle3 = new Bundle();
                bundle3.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", this.ULD.ViT);
                bVar2.statusChange(cVar2, bundle3);
                break;
        }
        AppMethodBeat.o(260594);
    }
}
