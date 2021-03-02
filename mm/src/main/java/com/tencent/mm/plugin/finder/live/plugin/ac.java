package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.e;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.util.Util;
import kotlin.g.b.p;
import kotlin.l;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "curGiftId", "giftPlayView", "Lorg/libpag/PAGView;", "canClearScreen", "", "playGiftAnimation", "", "isForceReplace", "showGift", "giftId", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class ac extends d {
    private final String TAG = "Finder.FinderLiveGiftPlayPlugin";
    private final b hOp;
    String upm;
    final PAGView upx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ac(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246669);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.cqu);
        p.g(findViewById, "root.findViewById(R.id.finder_live_gift_play_view)");
        this.upx = (PAGView) findViewById;
        AppMethodBeat.o(246669);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ ac upy;

        a(ac acVar) {
            this.upy = acVar;
        }

        public final void run() {
            AppMethodBeat.i(246667);
            e eVar = e.uiD;
            if (e.getDebug()) {
                PAGView pAGView = this.upy.upx;
                Context context = this.upy.hwr.getContext();
                p.g(context, "root.context");
                AssetManager assets = context.getAssets();
                e eVar2 = e.uiD;
                String atz = e.atz(this.upy.upm);
                if (atz == null) {
                    atz = "";
                }
                pAGView.setFile(PAGFile.Load(assets, atz));
            } else {
                PAGView pAGView2 = this.upy.upx;
                e eVar3 = e.uiD;
                String atz2 = e.atz(this.upy.upm);
                if (atz2 == null) {
                    atz2 = "";
                }
                pAGView2.setFile(PAGFile.Load(atz2));
            }
            this.upy.upx.setScaleMode(3);
            this.upy.upx.setRepeatCount(0);
            this.upy.upx.addListener(new PAGView.PAGViewListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ac.a.AnonymousClass1 */
                final /* synthetic */ a upz;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.upz = r1;
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public final void onAnimationRepeat(PAGView pAGView) {
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public final void onAnimationEnd(PAGView pAGView) {
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public final void onAnimationCancel(PAGView pAGView) {
                }

                @Override // org.libpag.PAGView.PAGViewListener
                public final void onAnimationStart(PAGView pAGView) {
                    AppMethodBeat.i(246666);
                    this.upz.upy.upx.setVisibility(0);
                    AppMethodBeat.o(246666);
                }
            });
            this.upy.upx.play();
            AppMethodBeat.o(246667);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        String str;
        boolean z;
        AppMethodBeat.i(246668);
        p.h(cVar, "status");
        switch (ad.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle == null || (str = bundle.getString("PARAM_LIVE_GIFT_INFO")) == null) {
                    str = "";
                }
                p.g(str, "param?.getString(ILiveSt…RAM_LIVE_GIFT_INFO) ?: \"\"");
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", false);
                } else {
                    z = false;
                }
                if (str != null) {
                    e eVar = e.uiD;
                    s atA = e.atA(str);
                    if (atA == null || Util.isNullOrNil(atA.field_animationPagUrl)) {
                        Log.i(this.TAG, "skip show full screen gift id:" + str + ", giftPath is null");
                    } else {
                        Log.i(this.TAG, "show full screen gift,id:" + str + ", info:" + atA + ",isForceReplace:" + z);
                        this.upm = str;
                        rg(0);
                        Log.i(this.TAG, "playGiftAnimation playViewIsPlaying:" + this.upx.isPlaying() + ", isForceReplace:" + z + ", isLandscape:" + isLandscape());
                        if ((!this.upx.isPlaying() || z) && !isLandscape()) {
                            this.upx.post(new a(this));
                            AppMethodBeat.o(246668);
                            return;
                        }
                        AppMethodBeat.o(246668);
                        return;
                    }
                }
                AppMethodBeat.o(246668);
                return;
            case 2:
                rg(8);
                this.upx.stop();
                break;
        }
        AppMethodBeat.o(246668);
    }
}
