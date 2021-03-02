package com.tencent.mm.plugin.finder.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension;", "", "addSyncHandler", "", "cmdId", "", "handler", "Lcom/tencent/mm/plugin/finder/api/IFinderSyncHandler;", "doSync", "selector", "scene", "register", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "removeSyncHandler", "unregister", "Companion", "plugin-finder_release"})
public interface e {
    public static final a tss = a.tsu;

    void a(int i2, f fVar);

    void a(MMFinderUI mMFinderUI);

    void b(int i2, f fVar);

    void b(MMFinderUI mMFinderUI);

    void fX(int i2, int i3);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R%\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00190\u0018¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/api/IFinderSyncExtension$Companion;", "", "()V", "CmdId_GetFansCount", "", "CmdId_GetFollowCount", "CmdId_GetFollower", "CmdId_GetMention", "CmdId_GetMentionCount", "CmdId_GetMyAcct", "CmdId_GetNotInterestedConfig", "CmdId_GetRedDot", "CmdId_GetSpamObject", "CmdId_GetWxMentionCount", "CmdId_ObjectWordingConfig", "CmdId_PRE_FETCH", "CmdId_REVOKE_TAB_TIPS", "CmdId_ReInit", "CmdId_RevokeRedDot", "CmdId_TAB_TIPS", "MMFinder_Sync_Selctor_HotTabTitle", "SELECTOR_ALL", "SELECTOR_ALL_MSG", "SELECTOR_ARRAY", "", "Lkotlin/Pair;", "", "getSELECTOR_ARRAY", "()[Lkotlin/Pair;", "[Lkotlin/Pair;", "SELECTOR_FANS_COUNT", "SELECTOR_FOLLOWER", "SELECTOR_FOLLOW_COUNT", "SELECTOR_MENTION_COUNT", "SELECTOR_NOT_INTERESTED_CONFIG", "SELECTOR_OTHERS", "SELECTOR_PRE_FETCH", "SELECTOR_REDDOT", "SELECTOR_REINT", "SELECTOR_SPAM_OBJECT", "SELECTOR_TAB_REVOKE_TAB_TIPS", "SELECTOR_TAB_TIPS", "SELECTOR_TAB_TIPS_HOT", "SELECTOR_WX_MENTION_COUNT", "SYNC_SCENE_FROM_ENTER_TL", "SYNC_SCENE_FROM_EXPIRED_CHECK", "SYNC_SCENE_FROM_INIT", "SYNC_SCENE_FROM_LOOP", "SYNC_SCENE_FROM_MIN_SYNC", "SYNC_SCENE_FROM_MIN_SYNC_2", "SYNC_SCENE_FROM_START", "SYNC_SCENE_FROM_UI_PROFILE", "plugin-finder_release"})
    public static final class a {
        private static final o<Integer, String>[] tst = {new o<>(1, "MENTION_COUNT"), new o<>(4, "FOLLOWER"), new o<>(8, "REDDOT"), new o<>(16, "FOLLOW_COUNT"), new o<>(32, "FANS_COUNT"), new o<>(64, "SPAM_OBJECT"), new o<>(128, "WX_MENTION_COUNT"), new o<>(256, "NOT_INTERESTED_CONFIG"), new o<>(2048, "SELECTOR_PRE_FETCH"), new o<>(4096, "SELECTOR_TAB_TIPS"), new o<>(32768, "SELECTOR_TAB_TIPS_HOT")};
        static final /* synthetic */ a tsu = new a();

        static {
            AppMethodBeat.i(165146);
            AppMethodBeat.o(165146);
        }

        private a() {
        }

        public static o<Integer, String>[] cXG() {
            return tst;
        }
    }
}
