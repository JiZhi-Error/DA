package com.tencent.mm.plugin.finder.music;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001e\u0010\u0014\u001a\u00020\u000e2\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0016J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eR*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayerManager;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "playerMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "Lkotlin/collections/HashMap;", "attach", "", "view", "player", "clear", "detach", "onDestroy", "pauseAll", "filter", "Lkotlin/Function1;", "Landroid/view/View;", "", "pauseFocusMusic", "resumeFocusMusic", "plugin-finder_release"})
public final class FinderImgFeedMusicPlayerManager extends UIComponent {
    public HashMap<FinderImgFeedMusicTag, a> uPC = new HashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImgFeedMusicPlayerManager(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(248933);
        AppMethodBeat.o(248933);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImgFeedMusicPlayerManager(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(248934);
        AppMethodBeat.o(248934);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(248928);
        super.onDestroy();
        clear();
        AppMethodBeat.o(248928);
    }

    public final void a(FinderImgFeedMusicTag finderImgFeedMusicTag, a aVar) {
        AppMethodBeat.i(248929);
        p.h(finderImgFeedMusicTag, "view");
        p.h(aVar, "player");
        if (!this.uPC.containsKey(finderImgFeedMusicTag)) {
            this.uPC.put(finderImgFeedMusicTag, aVar);
            Log.i("FinderImgFeedMusicPlayer", finderImgFeedMusicTag.getId() + " attach, player size:" + this.uPC.size());
            AppMethodBeat.o(248929);
            return;
        }
        a(finderImgFeedMusicTag);
        this.uPC.put(finderImgFeedMusicTag, aVar);
        Log.i("FinderImgFeedMusicPlayer", finderImgFeedMusicTag.getId() + " attach, already exist");
        AppMethodBeat.o(248929);
    }

    public final void a(FinderImgFeedMusicTag finderImgFeedMusicTag) {
        AppMethodBeat.i(248930);
        p.h(finderImgFeedMusicTag, "view");
        a aVar = this.uPC.get(finderImgFeedMusicTag);
        if (aVar != null) {
            aVar.release();
        }
        this.uPC.remove(finderImgFeedMusicTag);
        Log.i("FinderImgFeedMusicPlayer", finderImgFeedMusicTag.getId() + " dettach, player size:" + this.uPC.size());
        AppMethodBeat.o(248930);
    }

    public final void F(b<? super View, Boolean> bVar) {
        AppMethodBeat.i(248931);
        for (Map.Entry<FinderImgFeedMusicTag, a> entry : this.uPC.entrySet()) {
            Boolean invoke = bVar.invoke(entry.getKey());
            if (!(invoke != null ? invoke.booleanValue() : false)) {
                FinderImgFeedMusicTag key = entry.getKey();
                if (key.musicInfo == null || key.uPD == null) {
                    Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] musicInfo = " + key.musicInfo + ",player = " + key.uPD);
                } else {
                    a aVar = key.uPD;
                    if (aVar == null || aVar.isPlaying()) {
                        key.uPE = false;
                        key.uPF = false;
                        key.uPG = false;
                        if (key.musicInfo != null) {
                            a aVar2 = key.uPD;
                            if (aVar2 != null) {
                                aVar2.pause();
                            }
                            key.dld();
                        }
                    } else {
                        Log.i("FinderImgFeedMusicTag", "[pauseMusicAuto] music paused");
                    }
                }
            }
        }
        AppMethodBeat.o(248931);
    }

    public final void clear() {
        AppMethodBeat.i(248932);
        for (Map.Entry<FinderImgFeedMusicTag, a> entry : this.uPC.entrySet()) {
            entry.getValue().release();
        }
        this.uPC.clear();
        AppMethodBeat.o(248932);
    }
}
