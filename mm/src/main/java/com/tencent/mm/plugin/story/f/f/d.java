package com.tencent.mm.plugin.story.f.f;

import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.protocal.protobuf.edd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001 \u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001FB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\u0010\u0010.\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u0005H\u0002J\u001c\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00104\u001a\u0004\u0018\u000105H\u0016J*\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u00052\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020(H\u0016J\u0012\u0010>\u001a\u00020(2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010?\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020(H\u0016J\b\u0010A\u001a\u00020(H\u0016J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002J\b\u0010D\u001a\u00020(H\u0002J\u0018\u0010E\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000Rb\u0010\n\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000Rb\u0010\u0019\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000Rb\u0010\u001a\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r \u000e*\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001cj\b\u0012\u0004\u0012\u00020\u0005`\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000RN\u0010$\u001aB\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r \u000e* \u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r\u0018\u00010&0%X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "talker", "", "(Ljava/lang/String;)V", "blackTagList", "", "chatRoomStgListener", "friendUnreadList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "kotlin.jvm.PlatformType", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "hasStory", "", "hasUnread", "isPause", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "nextFetchTime", "", "normalUnreadList", "readList", "roomMember", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "roomMemberReady", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1;", "tryStartFetchRunnable", "Ljava/lang/Runnable;", "userUpdateMap", "", "", "addNewUserStory", "", ch.COL_USERNAME, IssueStorage.COLUMN_EXT_INFO, "checkChatRoomState", "checkExpire", "checkFetch", "checkStoryUnread", "destroy", "isRoomMember", "userName", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "pause", "registerNotifyListener", "removeUserStory", "resume", "start", "tryStartFetch", "updateChatRoomState", "updateGalleryUserList", "updateUserState", "Companion", "plugin-story_release"})
public final class d implements com.tencent.mm.ak.i, com.tencent.mm.plugin.story.api.l, MStorage.IOnStorageChange {
    public static final a Fql = new a((byte) 0);
    private static final String TAG = TAG;
    private boolean BdH;
    private List<String> DFl;
    public l.a FpR;
    private boolean FpT;
    private final List<o<String, com.tencent.mm.plugin.story.i.f>> Fqb = Collections.synchronizedList(new ArrayList());
    private final List<o<String, com.tencent.mm.plugin.story.i.f>> Fqc = Collections.synchronizedList(new ArrayList());
    private final List<o<String, com.tencent.mm.plugin.story.i.f>> Fqd = Collections.synchronizedList(new ArrayList());
    private long Fqe;
    private final Map<String, com.tencent.mm.plugin.story.i.f> Fqf = Collections.synchronizedMap(new HashMap());
    private final Runnable Fqg;
    private final ArrayList<String> Fqh;
    private boolean Fqi;
    private final MStorage.IOnStorageChange Fqj;
    private final C1756d Fqk;
    private boolean dLD;
    private final MMHandler handler;
    private final String talker;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/StoryStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(String str) {
        p.h(str, "talker");
        AppMethodBeat.i(119069);
        this.talker = str;
        MMHandlerThread aAk = com.tencent.mm.kernel.g.aAk();
        p.g(aAk, "MMKernel.getPizzaWorkerThread()");
        this.handler = new MMHandler(aAk.getLooper());
        this.Fqg = new f(this);
        this.DFl = new LinkedList();
        this.Fqh = new ArrayList<>();
        this.Fqj = new b(this);
        this.Fqk = new C1756d(this);
        AppMethodBeat.o(119069);
    }

    public static final /* synthetic */ void a(d dVar, String str, com.tencent.mm.plugin.story.i.f fVar) {
        AppMethodBeat.i(119076);
        dVar.b(str, fVar);
        AppMethodBeat.o(119076);
    }

    public static final /* synthetic */ void b(d dVar, String str) {
        AppMethodBeat.i(119075);
        dVar.aSi(str);
        AppMethodBeat.o(119075);
    }

    public static final /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(119071);
        dVar.fpr();
        AppMethodBeat.o(119071);
    }

    public static final /* synthetic */ void j(d dVar) {
        AppMethodBeat.i(119077);
        dVar.fpp();
        AppMethodBeat.o(119077);
    }

    public static final /* synthetic */ void k(d dVar) {
        AppMethodBeat.i(119078);
        dVar.fpq();
        AppMethodBeat.o(119078);
    }

    static {
        AppMethodBeat.i(119070);
        AppMethodBeat.o(119070);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ d Fqm;

        f(d dVar) {
            this.Fqm = dVar;
        }

        public final void run() {
            AppMethodBeat.i(119052);
            d.h(this.Fqm);
            AppMethodBeat.o(119052);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class b implements MStorage.IOnStorageChange {
        final /* synthetic */ d Fqm;

        b(d dVar) {
            this.Fqm = dVar;
        }

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(119047);
            Log.i(d.TAG, "chatRoomStgListener ".concat(String.valueOf(str)));
            if (!this.Fqm.Fqi && p.j(str, this.Fqm.talker)) {
                com.tencent.mm.ac.d.b("StoryStateFetcher_updateChatRoom", new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.story.f.f.d.b.AnonymousClass1 */
                    final /* synthetic */ b Fqn;

                    {
                        this.Fqn = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(119046);
                        d.d(this.Fqn.Fqm);
                        x xVar = x.SXb;
                        AppMethodBeat.o(119046);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(119047);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/model/sync/StoryStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.f.f.d$d  reason: collision with other inner class name */
    public static final class C1756d extends IListener<vx> {
        final /* synthetic */ d Fqm;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1756d(d dVar) {
            this.Fqm = dVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vx vxVar) {
            AppMethodBeat.i(119050);
            com.tencent.mm.ac.d.h(new a(this, vxVar));
            AppMethodBeat.o(119050);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.f.d$d$a */
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ vx FpM;
            final /* synthetic */ C1756d Fqo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C1756d dVar, vx vxVar) {
                super(0);
                this.Fqo = dVar;
                this.FpM = vxVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                vx.a aVar;
                AppMethodBeat.i(119049);
                vx vxVar = this.FpM;
                if (vxVar != null) {
                    aVar = vxVar.ebX;
                } else {
                    aVar = null;
                }
                if (aVar != null && this.FpM.ebX.ebY && !TextUtils.isEmpty(this.FpM.ebX.username)) {
                    d dVar = this.Fqo.Fqm;
                    String str = this.FpM.ebX.username;
                    p.g(str, "event.data.username");
                    if (d.a(dVar, str)) {
                        if (!this.FpM.ebX.eca) {
                            d dVar2 = this.Fqo.Fqm;
                            String str2 = this.FpM.ebX.username;
                            p.g(str2, "event.data.username");
                            d.b(dVar2, str2);
                        } else {
                            j.b bVar = j.Fmy;
                            com.tencent.mm.plugin.story.i.g fod = j.b.fod();
                            String str3 = this.FpM.ebX.username;
                            p.g(str3, "event.data.username");
                            com.tencent.mm.plugin.story.i.f aRS = fod.aRS(str3);
                            d dVar3 = this.Fqo.Fqm;
                            String str4 = this.FpM.ebX.username;
                            p.g(str4, "event.data.username");
                            d.a(dVar3, str4, aRS);
                        }
                        d.j(this.Fqo.Fqm);
                        d.k(this.Fqo.Fqm);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(119049);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void start() {
        AppMethodBeat.i(119056);
        com.tencent.mm.ac.d.b("StoryStateFetcher_updateChatRoom", new e(this));
        this.Fqk.alive();
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().a(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, this);
        j.b bVar = j.Fmy;
        j.b.fod().add(this, Looper.getMainLooper());
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class);
        p.g(af, "MMKernel.service(IChatroomService::class.java)");
        ((com.tencent.mm.plugin.chatroom.a.c) af).aSX().add(this.Fqj);
        AppMethodBeat.o(119056);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class g<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(119053);
            int a2 = kotlin.b.a.a(Integer.valueOf(((com.tencent.mm.plugin.story.i.f) t2.second).field_storyPostTime), Integer.valueOf(((com.tencent.mm.plugin.story.i.f) t.second).field_storyPostTime));
            AppMethodBeat.o(119053);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class h<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(119054);
            int a2 = kotlin.b.a.a(Integer.valueOf(((com.tencent.mm.plugin.story.i.f) t2.second).field_storyPostTime), Integer.valueOf(((com.tencent.mm.plugin.story.i.f) t.second).field_storyPostTime));
            AppMethodBeat.o(119054);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class i<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(119055);
            int a2 = kotlin.b.a.a(Long.valueOf(((com.tencent.mm.plugin.story.i.f) t2.second).field_readTime), Long.valueOf(((com.tencent.mm.plugin.story.i.f) t.second).field_readTime));
            AppMethodBeat.o(119055);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void resume() {
        AppMethodBeat.i(119057);
        this.dLD = false;
        fpr();
        com.tencent.mm.ac.d.b("StoryStateFetcher_checkExpire", new c(this));
        AppMethodBeat.o(119057);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void pause() {
        AppMethodBeat.i(119058);
        this.dLD = true;
        this.handler.removeCallbacks(this.Fqg);
        AppMethodBeat.o(119058);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void destroy() {
        AppMethodBeat.i(119059);
        Log.i(TAG, "endSession " + this.talker + ' ' + hashCode());
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().b(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR, this);
        j.b bVar = j.Fmy;
        j.b.fod().remove(this);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.chatroom.a.c.class);
        p.g(af, "MMKernel.service(IChatroomService::class.java)");
        ((com.tencent.mm.plugin.chatroom.a.c) af).aSX().remove(this.Fqj);
        this.handler.removeCallbacks(this.Fqg);
        this.Fqk.dead();
        AppMethodBeat.o(119059);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void a(l.a aVar) {
        this.FpR = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fpp() {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.f.d.fpp():void");
    }

    private final void fpq() {
        String str;
        o<String, com.tencent.mm.plugin.story.i.f> oVar;
        o<String, com.tencent.mm.plugin.story.i.f> oVar2;
        o<String, com.tencent.mm.plugin.story.i.f> oVar3;
        AppMethodBeat.i(119062);
        ArrayList arrayList = new ArrayList();
        List<o<String, com.tencent.mm.plugin.story.i.f>> list = this.Fqd;
        p.g(list, "friendUnreadList");
        if (list.size() > 1) {
            kotlin.a.j.a((List) list, (Comparator) new g());
        }
        List<o<String, com.tencent.mm.plugin.story.i.f>> list2 = this.Fqc;
        p.g(list2, "normalUnreadList");
        if (list2.size() > 1) {
            kotlin.a.j.a((List) list2, (Comparator) new h());
        }
        String str2 = "";
        List<o<String, com.tencent.mm.plugin.story.i.f>> list3 = this.Fqc;
        p.g(list3, "normalUnreadList");
        List<o<String, com.tencent.mm.plugin.story.i.f>> list4 = list3;
        synchronized (list4) {
            try {
                Iterator<T> it = list4.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        x xVar = x.SXb;
                        str = str2;
                        break;
                    }
                    int i3 = i2 + 1;
                    T next = it.next();
                    String str3 = str2 + "unRead:" + i2 + ' ' + Util.getSizeKB(next.second.fry()) + "  userName:" + next.second.getUserName() + " |, ";
                    if (i2 > 2) {
                        str = str3;
                        break;
                    } else {
                        i2 = i3;
                        str2 = str3;
                    }
                }
            } finally {
                AppMethodBeat.o(119062);
            }
        }
        Log.i(TAG, "unRead preLoadCache: ".concat(String.valueOf(str)));
        ArrayList<String> arrayList2 = new ArrayList<>();
        List<o<String, com.tencent.mm.plugin.story.i.f>> list5 = this.Fqd;
        p.g(list5, "friendUnreadList");
        if (!list5.isEmpty()) {
            if (this.Fqd.get(0).second.fry() > 0) {
                oVar3 = this.Fqd.get(0);
                this.Fqd.remove(oVar3);
            } else {
                oVar3 = null;
            }
            List<o<String, com.tencent.mm.plugin.story.i.f>> list6 = this.Fqd;
            p.g(list6, "friendUnreadList");
            Collections.shuffle(list6, new Random());
            if (oVar3 != null) {
                this.Fqd.add(0, oVar3);
            }
            oVar = oVar3;
        } else {
            oVar = null;
        }
        List<o<String, com.tencent.mm.plugin.story.i.f>> list7 = this.Fqd;
        p.g(list7, "friendUnreadList");
        List<o<String, com.tencent.mm.plugin.story.i.f>> list8 = list7;
        synchronized (list8) {
            try {
                Iterator<T> it2 = list8.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(it2.next().first);
                }
                x xVar2 = x.SXb;
            } finally {
                AppMethodBeat.o(119062);
            }
        }
        if (arrayList2.isEmpty()) {
            List<o<String, com.tencent.mm.plugin.story.i.f>> list9 = this.Fqc;
            p.g(list9, "normalUnreadList");
            if (!list9.isEmpty()) {
                if (this.Fqc.get(0).second.fry() > 0) {
                    oVar2 = this.Fqc.get(0);
                    this.Fqc.remove(oVar2);
                } else {
                    oVar2 = oVar;
                }
                if (oVar2 != null) {
                    this.Fqc.add(0, oVar2);
                }
            }
        }
        List<o<String, com.tencent.mm.plugin.story.i.f>> list10 = this.Fqc;
        p.g(list10, "normalUnreadList");
        List<o<String, com.tencent.mm.plugin.story.i.f>> list11 = list10;
        synchronized (list11) {
            try {
                Iterator<T> it3 = list11.iterator();
                while (it3.hasNext()) {
                    arrayList2.add(it3.next().first);
                }
                x xVar3 = x.SXb;
            } finally {
                AppMethodBeat.o(119062);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        List<o<String, com.tencent.mm.plugin.story.i.f>> list12 = this.Fqb;
        p.g(list12, "readList");
        List<o<String, com.tencent.mm.plugin.story.i.f>> list13 = list12;
        synchronized (list13) {
            try {
                Iterator<T> it4 = list13.iterator();
                while (it4.hasNext()) {
                    arrayList3.add(it4.next());
                }
                x xVar4 = x.SXb;
            } finally {
                AppMethodBeat.o(119062);
            }
        }
        ArrayList<String> arrayList4 = new ArrayList();
        ArrayList arrayList5 = arrayList3;
        if (arrayList5.size() > 1) {
            kotlin.a.j.a((List) arrayList5, (Comparator) new i());
        }
        ArrayList<o> arrayList6 = arrayList3;
        synchronized (arrayList6) {
            try {
                for (o oVar4 : arrayList6) {
                    arrayList4.add(oVar4.first);
                }
                x xVar5 = x.SXb;
            } catch (Throwable th) {
                throw th;
            }
        }
        for (String str4 : arrayList2) {
            if (!arrayList.contains(str4)) {
                arrayList.add(str4);
            }
        }
        for (String str5 : arrayList4) {
            if (!arrayList.contains(str5)) {
                arrayList.add(str5);
            }
        }
        l.a aVar = this.FpR;
        if (aVar != null) {
            aVar.a(arrayList, arrayList2);
            AppMethodBeat.o(119062);
            return;
        }
        AppMethodBeat.o(119062);
    }

    private final void fpr() {
        long j2 = 0;
        AppMethodBeat.i(119063);
        long currentTimeMillis = this.Fqe - System.currentTimeMillis();
        if (currentTimeMillis < 0) {
            this.Fqe = System.currentTimeMillis();
        } else {
            j2 = currentTimeMillis;
        }
        this.handler.removeCallbacks(this.Fqg);
        this.handler.postDelayed(this.Fqg, j2);
        AppMethodBeat.o(119063);
    }

    private final void a(String str, com.tencent.mm.plugin.story.i.f fVar) {
        AppMethodBeat.i(119064);
        if (this.DFl.contains(str)) {
            AppMethodBeat.o(119064);
            return;
        }
        l.a aVar = this.FpR;
        if (aVar != null) {
            aVar.cs(str, fVar.frA());
        }
        aSi(str);
        b(str, fVar);
        fpp();
        fpq();
        AppMethodBeat.o(119064);
    }

    private final void aSi(String str) {
        T t;
        T t2;
        T t3;
        AppMethodBeat.i(119065);
        List<o<String, com.tencent.mm.plugin.story.i.f>> list = this.Fqc;
        p.g(list, "normalUnreadList");
        synchronized (list) {
            try {
                List<o<String, com.tencent.mm.plugin.story.i.f>> list2 = this.Fqc;
                p.g(list2, "normalUnreadList");
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.first, str)) {
                        t = next;
                        break;
                    }
                }
                T t4 = t;
                if (t4 != null) {
                    Boolean.valueOf(this.Fqc.remove(t4));
                }
            } finally {
                AppMethodBeat.o(119065);
            }
        }
        List<o<String, com.tencent.mm.plugin.story.i.f>> list3 = this.Fqd;
        p.g(list3, "friendUnreadList");
        synchronized (list3) {
            try {
                List<o<String, com.tencent.mm.plugin.story.i.f>> list4 = this.Fqd;
                p.g(list4, "friendUnreadList");
                Iterator<T> it2 = list4.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next2 = it2.next();
                    if (p.j(next2.first, str)) {
                        t2 = next2;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 != null) {
                    Boolean.valueOf(this.Fqd.remove(t5));
                }
            } finally {
                AppMethodBeat.o(119065);
            }
        }
        List<o<String, com.tencent.mm.plugin.story.i.f>> list5 = this.Fqb;
        p.g(list5, "readList");
        synchronized (list5) {
            try {
                List<o<String, com.tencent.mm.plugin.story.i.f>> list6 = this.Fqb;
                p.g(list6, "readList");
                Iterator<T> it3 = list6.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        t3 = null;
                        break;
                    }
                    T next3 = it3.next();
                    if (p.j(next3.first, str)) {
                        t3 = next3;
                        break;
                    }
                }
                T t6 = t3;
                if (t6 != null) {
                    Boolean.valueOf(this.Fqb.remove(t6));
                }
            } finally {
                AppMethodBeat.o(119065);
            }
        }
    }

    private final void b(String str, com.tencent.mm.plugin.story.i.f fVar) {
        AppMethodBeat.i(119066);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        boolean arv = Kn != null ? Kn.arv() : false;
        if (!fVar.frA()) {
            if (fVar.isValid()) {
                this.Fqb.add(new o<>(str, fVar));
            }
            AppMethodBeat.o(119066);
        } else if (arv) {
            this.Fqd.add(new o<>(str, fVar));
            AppMethodBeat.o(119066);
        } else {
            this.Fqc.add(new o<>(str, fVar));
            AppMethodBeat.o(119066);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(119067);
        if (!(str == null || mStorageEventData == null || !(mStorageEventData.obj instanceof com.tencent.mm.plugin.story.i.f))) {
            Object obj = mStorageEventData.obj;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.o(119067);
                throw tVar;
            }
            com.tencent.mm.plugin.story.i.f fVar = (com.tencent.mm.plugin.story.i.f) obj;
            if (!this.Fqh.contains(fVar.getUserName())) {
                AppMethodBeat.o(119067);
                return;
            } else if (com.tencent.mm.plugin.sns.f.a.aOF(fVar.getUserName())) {
                AppMethodBeat.o(119067);
                return;
            } else {
                Map<String, com.tencent.mm.plugin.story.i.f> map = this.Fqf;
                p.g(map, "userUpdateMap");
                map.put(fVar.getUserName(), fVar);
                if (p.j(str, "notify_story_read")) {
                    Log.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as read");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(119067);
                    return;
                } else if (p.j(str, "notify_story_unread")) {
                    Log.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as unread");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(119067);
                    return;
                } else if (p.j(str, "notify_story_preload")) {
                    Log.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + " as preload " + fVar.fry());
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(119067);
                    return;
                } else if (p.j(str, "notify_story_invalid")) {
                    Log.i(TAG, "update user " + fVar.getUserName() + " as invalid");
                    a(fVar.getUserName(), fVar);
                    AppMethodBeat.o(119067);
                    return;
                } else if (p.j(str, "notify_story_valid")) {
                    Log.i(TAG, "update user " + fVar.getUserName() + " as valid");
                    a(fVar.getUserName(), fVar);
                }
            }
        }
        AppMethodBeat.o(119067);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(119068);
        p.h(qVar, "scene");
        Log.i(TAG, "onSceneEnd " + i2 + ", " + i3 + ", " + str + ", " + qVar.getType());
        if (qVar.getType() == 998 && (qVar instanceof com.tencent.mm.plugin.story.f.a.b)) {
            if (!p.j(((com.tencent.mm.plugin.story.f.a.b) qVar).jVv, this.talker)) {
                AppMethodBeat.o(119068);
                return;
            } else if (i2 == 0 && i3 == 0) {
                com.tencent.mm.bw.a aYK = ((com.tencent.mm.plugin.story.f.a.b) qVar).rr.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryChatRoomSyncResponse");
                    AppMethodBeat.o(119068);
                    throw tVar;
                }
                edd edd = (edd) aYK;
                Log.i(TAG, "response: count " + edd.Ndw + ", interval " + edd.Ndy);
                j.b bVar = j.Fmy;
                this.Fqe = j.b.foe().aSB(this.talker).field_nextSyncTime;
                fpr();
                AppMethodBeat.o(119068);
                return;
            } else {
                j.b bVar2 = j.Fmy;
                this.Fqe = j.b.foe().aSB(this.talker).field_nextSyncTime;
                fpr();
            }
        }
        AppMethodBeat.o(119068);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Fqm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(0);
            this.Fqm = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119051);
            Log.i(d.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cl.aWy());
            Log.i(d.TAG, "startSession " + this.Fqm.talker + ' ' + this.Fqm.hashCode());
            j.b bVar = j.Fmy;
            com.tencent.mm.plugin.story.i.l aSB = j.b.foe().aSB(this.Fqm.talker);
            d dVar = this.Fqm;
            List<String> eZI = com.tencent.mm.plugin.sns.f.a.eZI();
            p.g(eZI, "StoryStateMiddleLayer.getBlackTagList()");
            dVar.DFl = eZI;
            this.Fqm.Fqe = aSB.field_nextSyncTime;
            Log.i(d.TAG, "next sync time " + this.Fqm.Fqe);
            d.c(this.Fqm);
            d.d(this.Fqm);
            x xVar = x.SXb;
            AppMethodBeat.o(119051);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d Fqm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar) {
            super(0);
            this.Fqm = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119048);
            ArrayList<String> arrayList = new ArrayList();
            List list = this.Fqm.Fqd;
            p.g(list, "friendUnreadList");
            List<o> list2 = list;
            synchronized (list2) {
                try {
                    for (o oVar : list2) {
                        if (!oVar.second.isValid()) {
                            arrayList.add(oVar.first);
                        }
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(119048);
                }
            }
            List list3 = this.Fqm.Fqc;
            p.g(list3, "normalUnreadList");
            List<o> list4 = list3;
            synchronized (list4) {
                try {
                    for (o oVar2 : list4) {
                        if (!oVar2.second.isValid()) {
                            arrayList.add(oVar2.first);
                        }
                    }
                    x xVar2 = x.SXb;
                } finally {
                    AppMethodBeat.o(119048);
                }
            }
            List list5 = this.Fqm.Fqb;
            p.g(list5, "readList");
            List<o> list6 = list5;
            synchronized (list6) {
                try {
                    for (o oVar3 : list6) {
                        if (!oVar3.second.isValid()) {
                            arrayList.add(oVar3.first);
                        }
                    }
                    x xVar3 = x.SXb;
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (String str : arrayList) {
                Log.i(d.TAG, "LogStory: expired ".concat(String.valueOf(str)));
                k kVar = k.FmH;
                k.aRQ(str);
            }
            x xVar4 = x.SXb;
            AppMethodBeat.o(119048);
            return xVar4;
        }
    }

    public static final /* synthetic */ void d(d dVar) {
        AppMethodBeat.i(119072);
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("checkChatRoomState");
        List<String> Ic = v.Ic(dVar.talker);
        if (Ic == null) {
            AppMethodBeat.o(119072);
            return;
        }
        dVar.Fqh.addAll(Ic);
        dVar.Fqi = dVar.Fqh.size() > 0;
        Log.i(TAG, "room member size " + dVar.Fqh.size());
        List<String> list = Ic;
        synchronized (list) {
            try {
                for (T t : list) {
                    if (t != null) {
                        j.b bVar = j.Fmy;
                        if (!Util.isEqual(j.b.fau(), (String) t) && !dVar.DFl.contains(t)) {
                            j.b bVar2 = j.Fmy;
                            com.tencent.mm.plugin.story.i.f aRS = j.b.fod().aRS(t);
                            boolean isValid = aRS.isValid();
                            boolean frA = aRS.frA();
                            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                            p.g(af, "service(IMessengerStorage::class.java)");
                            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(t);
                            boolean arv = Kn != null ? Kn.arv() : false;
                            if (frA) {
                                if (arv) {
                                    dVar.Fqd.add(new o<>(t, aRS));
                                } else {
                                    dVar.Fqc.add(new o<>(t, aRS));
                                }
                                dVar.fpp();
                            } else if (isValid) {
                                dVar.Fqb.add(new o<>(t, aRS));
                                dVar.fpp();
                            }
                        }
                    }
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(119072);
                throw th;
            }
        }
        dVar.fpq();
        cVar.aBw();
        AppMethodBeat.o(119072);
    }

    public static final /* synthetic */ void h(d dVar) {
        AppMethodBeat.i(119073);
        j.b bVar = j.Fmy;
        if (j.b.foo() && !Util.isNullOrNil(dVar.talker) && ab.Ix(dVar.talker)) {
            Log.i(TAG, "tryStartFetch " + dVar.talker);
            if (!com.tencent.mm.plugin.story.api.o.fnq()) {
                Log.i(TAG, "filter RoomSync");
            } else if (!dVar.dLD) {
                Log.i(TAG, "start fetch " + dVar.talker);
                com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                p.g(aAg, "network()");
                aAg.azz().b(new com.tencent.mm.plugin.story.f.a.b(dVar.talker));
                AppMethodBeat.o(119073);
                return;
            }
        }
        AppMethodBeat.o(119073);
    }

    public static final /* synthetic */ boolean a(d dVar, String str) {
        boolean z;
        T t;
        AppMethodBeat.i(119074);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(119074);
            return false;
        }
        ArrayList<String> arrayList = dVar.Fqh;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (p.j(next, str)) {
                    t = next;
                    break;
                }
            }
            if (t != null) {
                z = true;
                AppMethodBeat.o(119074);
                return z;
            }
        }
        z = false;
        AppMethodBeat.o(119074);
        return z;
    }
}
