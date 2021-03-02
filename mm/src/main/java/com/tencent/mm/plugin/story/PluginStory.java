package com.tencent.mm.plugin.story;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.a.xd;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.i.h;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.k;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.api.m;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.story.f.f;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.f.r;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0003OPQB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0016\u0010\u0019\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0014\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00101\u001a\u00020\u0010H\u0016J\u0012\u00102\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u00104\u001a\u00020\u00102\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u00105\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\u0012\u00108\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00109\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u0010:\u001a\u00020\u0010H\u0016J\u0012\u0010;\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010<\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eH\u0016J\u001e\u0010=\u001a\u00020\n2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u0006\u0010?\u001a\u00020\bH\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020\bH\u0016J \u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0014H\u0016J\"\u0010F\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\bH\u0016J*\u0010I\u001a\u00020\n2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010H\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u0014H\u0016J\b\u0010K\u001a\u00020LH\u0016J\u001c\u0010M\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u0010N\u001a\u0004\u0018\u00010.H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/story/PluginStory;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/story/api/IPluginStory;", "()V", "STORAGE_STORY", "", "STORAGE_STORY_TEMP", "StoryMaxStorageSize", "", "addStoryPostListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "addStoryStatusNotifyListener", "Lcom/tencent/mm/plugin/story/api/IStoryStatusNotifyListener;", "canPostStory", "", "checkPost", "checkReportFromChatting", "clickScene", "", "user", "configure", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "enterGallery", "unreadList", "", "execute", "getAccStoryCachePath", "getAccStoryPath", "getAccStoryTmpPath", "getContactFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "getFavourUserChecker", "Lcom/tencent/mm/plugin/story/api/IFavourUserChecker;", "getStoryBasicConfig", "Lcom/tencent/mm/plugin/story/api/IStoryBasicConfig;", "getStoryNewFeatureConfig", "Lcom/tencent/mm/plugin/story/api/IStoryNewFeatureConfig;", "getStoryStateFetcher", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "talker", "getStoryUIFactory", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory;", "getStoryUserInfo", "Lcom/tencent/mm/protocal/protobuf/StoryUserInfo;", "hasNewStory", ch.COL_USERNAME, "isShowStoryCheck", "isStoryExist", "userName", "isStoryUnread", "loadStory", "roomId", "name", "preLoadVideoViewMgr", "preloadForSnsUser", "isEnter", "removeStoryPostListener", "removeStoryStatusNotifyListener", "reportWaitPlayList", "userList", "scene", "setPreviewEnterScene", "showStoryEntranceDialog", "context", "Landroid/content/Context;", "sessionId", "exposeOrder", "startStoryCapture", "jumpPageFrom", "videoObjectId", "startStoryCaptureForResult", "requestCode", "storyComment", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "updateStoryUserInfo", "userInfo", "Companion", "StoryCleanListener", "StorySynclistener", "plugin-story_release"})
public final class PluginStory extends f implements e {
    public static final a Fkn = new a((byte) 0);
    private static final String TAG = TAG;
    private final long Fkk = TPAudioFrame.TP_CH_STEREO_LEFT;
    private final String Fkl = "oneday/";
    private final String Fkm = "oneday/temp/";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/PluginStory$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(118565);
        AppMethodBeat.o(118565);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final String getAccStoryPath() {
        AppMethodBeat.i(118538);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "storage()");
        String sb2 = sb.append(aAh.getAccPath()).append(this.Fkl).toString();
        AppMethodBeat.o(118538);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final String getAccStoryTmpPath() {
        AppMethodBeat.i(118539);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "storage()");
        String sb2 = sb.append(aAh.getAccPath()).append(this.Fkm).toString();
        AppMethodBeat.o(118539);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final String getAccStoryCachePath() {
        AppMethodBeat.i(118540);
        String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + FilePathGenerator.ANDROID_DIR_SEP + this.Fkl;
        AppMethodBeat.o(118540);
        return str;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        com.tencent.mm.media.i.d.ihF = h.ijh;
    }

    @Override // com.tencent.mm.kernel.b.f
    public final void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(118541);
        if (gVar != null && gVar.aBb()) {
            Log.i(TAG, "PluginStory configure");
            pin(new y(j.class));
            com.tencent.mm.vfs.y.a("oneday", "oneday", this.Fkk, 7776000000L, 3);
        }
        AppMethodBeat.o(118541);
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public final String name() {
        return "plugin-story";
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean isStoryUnread(String str) {
        AppMethodBeat.i(118542);
        f.a aVar = com.tencent.mm.plugin.story.f.f.FlW;
        boolean isStoryUnread = f.a.isStoryUnread(str);
        AppMethodBeat.o(118542);
        return isStoryUnread;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean isStoryExist(String str) {
        boolean z;
        AppMethodBeat.i(118543);
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118543);
            return false;
        } else if (str == null) {
            AppMethodBeat.o(118543);
            return false;
        } else {
            j.b bVar = j.Fmy;
            if (!p.j(str, j.b.fau())) {
                j.b bVar2 = j.Fmy;
                z = j.b.fod().aRS(str).isValid();
                if (z) {
                    Log.i(TAG, "ret1 has story!");
                    AppMethodBeat.o(118543);
                    return true;
                }
            } else {
                z = false;
            }
            n.a aVar = n.FmM;
            int aWB = cl.aWB();
            i.a aVar2 = i.Fmb;
            boolean fM = n.a.fM(str, aWB - i.FlY);
            if (fM) {
                Log.i(TAG, "ret2 has story!");
            }
            if (z || fM) {
                AppMethodBeat.o(118543);
                return true;
            }
            AppMethodBeat.o(118543);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void loadStory(String str, String str2) {
        AppMethodBeat.i(118544);
        if (str == null) {
            AppMethodBeat.o(118544);
        } else if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118544);
        } else {
            j.b bVar = j.Fmy;
            boolean isEqual = Util.isEqual(str, j.b.fau());
            if (!isEqual && !o.fnr()) {
                com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
                if (Kn == null) {
                    AppMethodBeat.o(118544);
                    return;
                } else if (!Kn.arv()) {
                    Log.i(TAG, "filter by isOpenStrangerUserPage close ".concat(String.valueOf(str)));
                    AppMethodBeat.o(118544);
                    return;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.story.f.a.i iVar = new com.tencent.mm.plugin.story.f.a.i(str, isEqual, str2);
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(iVar);
            AppMethodBeat.o(118544);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final com.tencent.mm.plugin.story.api.l getStoryStateFetcher(String str) {
        AppMethodBeat.i(118545);
        com.tencent.mm.plugin.story.f.f.e eVar = com.tencent.mm.plugin.story.f.f.e.Fqp;
        com.tencent.mm.plugin.story.api.l aSj = com.tencent.mm.plugin.story.f.f.e.aSj(str);
        AppMethodBeat.o(118545);
        return aSj;
    }

    public final void addStoryPostListener(k kVar) {
        AppMethodBeat.i(118546);
        j.b bVar = j.Fmy;
        j.b.foi().a(kVar);
        AppMethodBeat.o(118546);
    }

    public final void removeStoryPostListener(k kVar) {
        AppMethodBeat.i(118547);
        j.b bVar = j.Fmy;
        j.b.foi().b(kVar);
        AppMethodBeat.o(118547);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void addStoryStatusNotifyListener(m mVar) {
        AppMethodBeat.i(118548);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.g fod = j.b.fod();
        if (mVar != null && !fod.Fwg.contains(mVar)) {
            fod.Fwg.add(mVar);
        }
        AppMethodBeat.o(118548);
    }

    public final void removeStoryStatusNotifyListener(m mVar) {
        AppMethodBeat.i(118549);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.g fod = j.b.fod();
        if (mVar != null) {
            fod.Fwg.remove(mVar);
        }
        AppMethodBeat.o(118549);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean isShowStoryCheck() {
        AppMethodBeat.i(118550);
        j.b bVar = j.Fmy;
        boolean foo = j.b.foo();
        AppMethodBeat.o(118550);
        return foo;
    }

    public final com.tencent.mm.plugin.story.api.h storyComment() {
        return com.tencent.mm.plugin.story.f.b.b.Fom;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final com.tencent.mm.plugin.story.api.n getStoryUIFactory() {
        return r.Fnv;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final com.tencent.mm.plugin.story.api.b getFavourUserChecker() {
        return com.tencent.mm.plugin.story.f.b.FlH;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void checkPost() {
        AppMethodBeat.i(118551);
        if (!isShowStoryCheck()) {
            AppMethodBeat.o(118551);
            return;
        }
        j.b bVar = j.Fmy;
        j.b.foi().checkPost();
        AppMethodBeat.o(118551);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean hasNewStory(String str) {
        AppMethodBeat.i(118552);
        if (!o.isShowStoryCheck()) {
            AppMethodBeat.o(118552);
            return false;
        }
        com.tencent.mm.plugin.story.f.k kVar = com.tencent.mm.plugin.story.f.k.FmH;
        boolean aRT = com.tencent.mm.plugin.story.f.k.aRT(str);
        AppMethodBeat.o(118552);
        return aRT;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean canPostStory() {
        AppMethodBeat.i(118553);
        com.tencent.mm.plugin.story.f.d dVar = com.tencent.mm.plugin.story.f.d.FlN;
        boolean canPostStory = com.tencent.mm.plugin.story.f.d.canPostStory();
        AppMethodBeat.o(118553);
        return canPostStory;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/PluginStory$StorySynclistener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StorySyncEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    public static final class c extends IListener<xd> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xd xdVar) {
            AppMethodBeat.i(118536);
            p.h(xdVar, "event");
            com.tencent.mm.kernel.b aAg = g.aAg();
            p.g(aAg, "MMKernel.network()");
            aAg.azz().b(new com.tencent.mm.plugin.story.f.a.h());
            AppMethodBeat.o(118536);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/story/PluginStory$StoryCleanListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/StoryFileCleanTaskEvent;", "()V", "callback", "", "event", "plugin-story_release"})
    public static final class b extends IListener<xc> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xc xcVar) {
            xc.a aVar;
            AppMethodBeat.i(118535);
            xc xcVar2 = xcVar;
            Integer valueOf = (xcVar2 == null || (aVar = xcVar2.edy) == null) ? null : Integer.valueOf(aVar.state);
            if (valueOf != null && valueOf.intValue() == 0) {
                Log.i(PluginStory.TAG, "receive a event start clean");
                com.tencent.mm.plugin.story.j.a aVar2 = com.tencent.mm.plugin.story.j.a.FwJ;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                Log.i(PluginStory.TAG, "receive a event to stop clean");
                com.tencent.mm.plugin.story.j.a aVar3 = com.tencent.mm.plugin.story.j.a.FwJ;
            }
            AppMethodBeat.o(118535);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final com.tencent.mm.plugin.story.api.f getStoryBasicConfig() {
        return com.tencent.mm.plugin.story.c.a.a.FkW;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean checkReportFromChatting(int i2, String str) {
        String str2;
        boolean z;
        String str3;
        String str4;
        String str5;
        AppMethodBeat.i(118554);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(118554);
            return false;
        }
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.g fod = j.b.fod();
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        com.tencent.mm.plugin.story.i.f aRS = fod.aRS(str2);
        boolean frA = aRS.frA();
        if (aRS.fry() > 0) {
            z = true;
        } else {
            z = false;
        }
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.clean();
        com.tencent.mm.plugin.story.h.b bVar2 = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.clean();
        com.tencent.mm.plugin.story.h.b bVar3 = com.tencent.mm.plugin.story.h.b.FtL;
        if (str == null) {
            str3 = "";
        } else {
            str3 = str;
        }
        p.h(str3, "user");
        com.tencent.mm.plugin.story.h.b.aaR(i2);
        com.tencent.mm.plugin.story.h.b.clean();
        com.tencent.mm.plugin.story.h.b.FtE = Util.nowMilliSecond();
        boolean z2 = NetStatusUtil.isWifi(MMApplicationContext.getContext()) || NetStatusUtil.is4G(MMApplicationContext.getContext());
        com.tencent.mm.plugin.story.h.b.tcf = z2;
        if (z2) {
            Log.i("MicroMsg.StoryBrowseDetailIDKeyStat", "chattingRight " + str3 + " isWifi:" + com.tencent.mm.plugin.story.h.b.tcf);
            com.tencent.mm.plugin.story.h.b.e(com.tencent.mm.plugin.story.h.b.oIi, 1, 1);
        }
        if (i2 == 1) {
            com.tencent.mm.plugin.story.h.c cVar2 = com.tencent.mm.plugin.story.h.c.Fuf;
            if (str == null) {
                str5 = "";
            } else {
                str5 = str;
            }
            p.h(str5, "user");
            com.tencent.mm.plugin.story.h.c.clean();
            com.tencent.mm.plugin.story.h.c.Fub = false;
            com.tencent.mm.plugin.story.h.c.FtW = new c.a(str5, 1);
            Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingRight ".concat(String.valueOf(str5)));
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(988, 1, 1);
            if (frA) {
                if (z) {
                    com.tencent.mm.plugin.story.h.c cVar3 = com.tencent.mm.plugin.story.h.c.Fuf;
                    com.tencent.mm.plugin.story.h.c.fpP();
                } else {
                    com.tencent.mm.plugin.story.h.c cVar4 = com.tencent.mm.plugin.story.h.c.Fuf;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.story.h.c.aSk(str);
                }
            }
        } else if (i2 == 2) {
            com.tencent.mm.plugin.story.h.c cVar5 = com.tencent.mm.plugin.story.h.c.Fuf;
            if (str == null) {
                str4 = "";
            } else {
                str4 = str;
            }
            p.h(str4, "user");
            com.tencent.mm.plugin.story.h.c.clean();
            com.tencent.mm.plugin.story.h.c.Fub = true;
            com.tencent.mm.plugin.story.h.c.FtW = new c.a(str4, 2);
            Log.i("MicroMsg.StoryBrowseIDKeyStat", "chattingDoubleCheck ".concat(String.valueOf(str4)));
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(988, 2, 1);
            if (frA) {
                if (z) {
                    com.tencent.mm.plugin.story.h.c cVar6 = com.tencent.mm.plugin.story.h.c.Fuf;
                    com.tencent.mm.plugin.story.h.c.fpQ();
                } else {
                    com.tencent.mm.plugin.story.h.c cVar7 = com.tencent.mm.plugin.story.h.c.Fuf;
                    if (str == null) {
                        str = "";
                    }
                    com.tencent.mm.plugin.story.h.c.aSl(str);
                }
            }
        }
        AppMethodBeat.o(118554);
        return true;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void enterGallery(List<String> list) {
        AppMethodBeat.i(118555);
        p.h(list, "unreadList");
        com.tencent.mm.plugin.story.h.c cVar = com.tencent.mm.plugin.story.h.c.Fuf;
        com.tencent.mm.plugin.story.h.c.hv(list);
        com.tencent.mm.plugin.story.h.b bVar = com.tencent.mm.plugin.story.h.b.FtL;
        com.tencent.mm.plugin.story.h.b.hv(list);
        AppMethodBeat.o(118555);
    }

    public final void setPreviewEnterScene(long j2) {
        AppMethodBeat.i(118556);
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqi().sl(j2);
        AppMethodBeat.o(118556);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean preLoadVideoViewMgr(String str) {
        AppMethodBeat.i(118557);
        com.tencent.mm.plugin.story.ui.view.gallery.o oVar = com.tencent.mm.plugin.story.ui.view.gallery.o.FIq;
        if (str == null) {
            str = "";
        }
        com.tencent.mm.plugin.story.ui.view.gallery.o.aSH(str);
        AppMethodBeat.o(118557);
        return true;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final l.c getContactFetcher() {
        return com.tencent.mm.plugin.story.f.f.a.FpB;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void preloadForSnsUser(String str, boolean z) {
        int a2;
        AppMethodBeat.i(118558);
        if (str == null) {
            AppMethodBeat.o(118558);
            return;
        }
        if (z) {
            a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_with_enter_sns, 1);
        } else {
            a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_story_preload_with_change_sns, 0);
        }
        Log.i(TAG, "preloadForSnsUser: " + a2 + " isEnter: " + z + " username " + str + ' ' + Util.getStack());
        if (a2 == 1) {
            f.a aVar = com.tencent.mm.plugin.story.g.f.FrJ;
            com.tencent.mm.plugin.story.f.d.h ct = f.a.ct(str, false);
            if (ct != null) {
                com.tencent.mm.plugin.story.ui.view.gallery.m.a(com.tencent.mm.plugin.story.ui.view.gallery.m.FHB, kotlin.a.j.listOf(ct.FoT));
                AppMethodBeat.o(118558);
                return;
            }
        }
        AppMethodBeat.o(118558);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void reportWaitPlayList(List<String> list, long j2) {
        AppMethodBeat.i(118559);
        p.h(list, "userList");
        com.tencent.mm.plugin.story.f.k kVar = com.tencent.mm.plugin.story.f.k.FmH;
        com.tencent.mm.plugin.story.f.k.reportWaitPlayList(list, j2);
        AppMethodBeat.o(118559);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final boolean showStoryEntranceDialog(Context context, String str, int i2) {
        AppMethodBeat.i(118560);
        p.h(context, "context");
        p.h(str, "sessionId");
        com.tencent.mm.plugin.story.h.h hVar = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqE().wN(str);
        com.tencent.mm.plugin.story.h.h hVar2 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqE().lG((int) System.currentTimeMillis());
        com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h hVar4 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.aaW(com.tencent.mm.plugin.story.h.h.fqE().ahr());
        com.tencent.mm.plugin.story.h.h hVar5 = com.tencent.mm.plugin.story.h.h.FuH;
        com.tencent.mm.plugin.story.h.h.fqE().lH(i2);
        com.tencent.mm.plugin.story.ui.sns.c cVar = new com.tencent.mm.plugin.story.ui.sns.c(context);
        cVar.setContentView(new com.tencent.mm.plugin.story.ui.sns.d(context, new d(cVar)));
        cVar.show();
        AppMethodBeat.o(118560);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.story.ui.sns.c Fko;

        d(com.tencent.mm.plugin.story.ui.sns.c cVar) {
            this.Fko = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(118537);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/PluginStory$showStoryEntranceDialog$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Fko.cancel();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/PluginStory$showStoryEntranceDialog$entranceView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(118537);
        }
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final eel getStoryUserInfo() {
        AppMethodBeat.i(118561);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.g fod = j.b.fod();
        j.b bVar2 = j.Fmy;
        eel frz = fod.aRS(j.b.fau()).frz();
        if (frz == null) {
            frz = new eel();
        }
        AppMethodBeat.o(118561);
        return frz;
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void updateStoryUserInfo(String str, eel eel) {
        byte[] bArr;
        AppMethodBeat.i(118562);
        j.b bVar = j.Fmy;
        com.tencent.mm.plugin.story.i.g fod = j.b.fod();
        if (str == null || eel == null) {
            AppMethodBeat.o(118562);
            return;
        }
        com.tencent.mm.plugin.story.i.f aRS = fod.aRS(str);
        if (eel != null) {
            bArr = eel.toByteArray();
        } else {
            bArr = null;
        }
        aRS.field_userInfo = bArr;
        fod.b(aRS);
        AppMethodBeat.o(118562);
    }

    public final void startStoryCapture(Context context, int i2, long j2) {
        AppMethodBeat.i(118563);
        startStoryCaptureForResult(context, i2, j2, -1);
        AppMethodBeat.o(118563);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final void startStoryCaptureForResult(Context context, int i2, long j2, int i3) {
        AppMethodBeat.i(118564);
        com.tencent.mm.plugin.story.f.e.a.Fpl.startStoryCapture(context, i2, j2);
        AppMethodBeat.o(118564);
    }

    @Override // com.tencent.mm.plugin.story.api.e
    public final com.tencent.mm.plugin.story.api.j getStoryNewFeatureConfig() {
        return com.tencent.mm.plugin.story.c.a.e.Fln;
    }
}
