package com.tencent.mm.plugin.finder.live.component;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.j;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$1$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$$inlined$multiLet$lambda$1 extends ResultReceiver {
    final /* synthetic */ j.b UJX;
    final /* synthetic */ j UJY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveLuckyMoneyBubblePresenter$openLuckyMoney$$inlined$multiLet$lambda$1(j.b bVar, Handler handler, j jVar) {
        super(handler);
        this.UJX = bVar;
        this.UJY = jVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(260399);
        Log.i("Finder.FinderLiveLuckyMoneyBubblePresenter", "openLuckyMoney result:".concat(String.valueOf(i2)));
        switch (i2) {
            case -1:
                s sVar = this.UJY.ujx;
                if (sVar != null) {
                    sVar.a(this.UJY.liveData.liveInfo.liveId, this.UJY.liveData.hFK, this.UJY.liveData.hwg, this.UJY.liveData.hIt, this.UJX.UJW.ViT);
                }
                j.a(this.UJY, this.UJX);
                AppMethodBeat.o(260399);
                return;
            case 0:
                AppMethodBeat.o(260399);
                return;
            case 1:
                j.a(this.UJY, this.UJX);
                break;
        }
        AppMethodBeat.o(260399);
    }
}
