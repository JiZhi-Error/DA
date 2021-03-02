package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.music.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderVideoCore$onInitialize$2", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderVideoCore$onInitialize$2 implements UILifecycleObserver {
    final /* synthetic */ AppCompatActivity vao;
    final /* synthetic */ k weX;

    FinderVideoCore$onInitialize$2(k kVar, AppCompatActivity appCompatActivity) {
        this.weX = kVar;
        this.vao = appCompatActivity;
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168030);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168030);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168031);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168031);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168032);
        p.h(lifecycleOwner, "var1");
        d.h(new FinderVideoRecycler.r(this.weX.dFx(), this.vao));
        for (Map.Entry<FinderImgFeedMusicTag, a> entry : this.weX.dFy().uPC.entrySet()) {
            if (entry.getKey().uPE && entry.getKey().getShouldMusicResume()) {
                entry.getValue().play();
            }
        }
        AppMethodBeat.o(168032);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168033);
        p.h(lifecycleOwner, "var1");
        this.weX.dFx().fJ(this.vao);
        for (Map.Entry<FinderImgFeedMusicTag, a> entry : this.weX.dFy().uPC.entrySet()) {
            if (entry.getKey().uPE) {
                entry.getKey().setShouldMusicResume(entry.getValue().isPlaying());
                entry.getKey().bdY();
            }
        }
        AppMethodBeat.o(168033);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168034);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(168034);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(168035);
        p.h(lifecycleOwner, "var1");
        AppForegroundDelegate.INSTANCE.b(this.weX);
        this.weX.dFy().clear();
        AppMethodBeat.o(168035);
    }
}
