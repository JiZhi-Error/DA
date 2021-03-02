package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b¸\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$goGetLuckMoney$1$1$onCgiBack$2$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "plugin-finder_release", "com/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout$goGetLuckMoney$1$1$onCgiBack$$inlined$let$lambda$1"})
public final class FinderBaseLivePluginLayout$goGetLuckMoney$$inlined$let$lambda$1$1 extends ResultReceiver {
    final /* synthetic */ LinkedList Ccw;
    final /* synthetic */ FinderBaseLivePluginLayout.h UNl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderBaseLivePluginLayout$goGetLuckMoney$$inlined$let$lambda$1$1(LinkedList linkedList, Handler handler, FinderBaseLivePluginLayout.h hVar) {
        super(handler);
        this.Ccw = linkedList;
        this.UNl = hVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public final void onReceiveResult(int i2, Bundle bundle) {
        String str;
        String str2 = null;
        AppMethodBeat.i(260763);
        Log.i(this.UNl.uxy.TAG, "openLuckyMoney result:".concat(String.valueOf(i2)));
        switch (i2) {
            case -1:
                s finderLiveAssistant = this.UNl.uxy.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    long j2 = this.UNl.uxy.getLiveData().liveInfo.liveId;
                    long j3 = this.UNl.uxy.getLiveData().hFK;
                    String str3 = this.UNl.uxy.getLiveData().hwg;
                    byte[] bArr = this.UNl.uxy.getLiveData().hIt;
                    fgy fgy = (fgy) this.Ccw.get(0);
                    if (fgy != null) {
                        str = fgy.ViT;
                    } else {
                        str = null;
                    }
                    finderLiveAssistant.a(j2, j3, str3, bArr, str);
                }
                FinderBaseLivePluginLayout finderBaseLivePluginLayout = this.UNl.uxy;
                b.c cVar = b.c.vSj;
                Bundle bundle2 = new Bundle();
                fgy fgy2 = (fgy) this.Ccw.get(0);
                if (fgy2 != null) {
                    str2 = fgy2.ViT;
                }
                bundle2.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", str2);
                finderBaseLivePluginLayout.statusChange(cVar, bundle2);
                AppMethodBeat.o(260763);
                return;
            case 0:
                AppMethodBeat.o(260763);
                return;
            case 1:
                FinderBaseLivePluginLayout finderBaseLivePluginLayout2 = this.UNl.uxy;
                b.c cVar2 = b.c.vSj;
                Bundle bundle3 = new Bundle();
                fgy fgy3 = (fgy) this.Ccw.get(0);
                if (fgy3 != null) {
                    str2 = fgy3.ViT;
                }
                bundle3.putString("PARAM_FINDER_LIVE_LUCKY_MONEY_SEND_ID", str2);
                finderBaseLivePluginLayout2.statusChange(cVar2, bundle3);
                break;
        }
        AppMethodBeat.o(260763);
    }
}
