package com.tencent.mm.plugin.story.f.f;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.plugin.story.i.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001c\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", ch.COL_USERNAME, "", "(Ljava/lang/String;)V", IssueStorage.COLUMN_EXT_INFO, "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "hasStory", "", "hasUnread", "isInBlackList", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1;", "checkStoryUnread", "destroy", "", "notifyListener", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pause", "registerNotifyListener", "resume", "start", "Companion", "plugin-story_release"})
public final class b implements com.tencent.mm.plugin.story.api.l, MStorage.IOnStorageChange {
    public static final a FpW = new a((byte) 0);
    private static final String TAG = TAG;
    private boolean BdH;
    private l.a FpR;
    private f FpS;
    private boolean FpT;
    private boolean FpU;
    private final c FpV = new c(this);
    private final String username;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(String str) {
        p.h(str, ch.COL_USERNAME);
        AppMethodBeat.i(119040);
        this.username = str;
        AppMethodBeat.o(119040);
    }

    public static final /* synthetic */ void g(b bVar) {
        AppMethodBeat.i(119042);
        bVar.fai();
        AppMethodBeat.o(119042);
    }

    static {
        AppMethodBeat.i(119041);
        AppMethodBeat.o(119041);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/model/sync/SingleUserStateFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class c extends IListener<vx> {
        final /* synthetic */ b FpX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(b bVar) {
            this.FpX = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vx vxVar) {
            boolean z;
            b bVar;
            boolean z2;
            AppMethodBeat.i(119032);
            vx vxVar2 = vxVar;
            if ((vxVar2 != null ? vxVar2.ebX : null) == null || !vxVar2.ebX.ebY || TextUtils.isEmpty(vxVar2.ebX.username) || (!p.j(this.FpX.username, vxVar2.ebX.username))) {
                AppMethodBeat.o(119032);
            } else {
                if (!vxVar2.ebX.eca) {
                    this.FpX.FpU = true;
                    this.FpX.BdH = false;
                    bVar = this.FpX;
                    z2 = false;
                } else {
                    this.FpX.FpU = false;
                    b bVar2 = this.FpX;
                    j.b bVar3 = j.Fmy;
                    g fod = j.b.fod();
                    String str = vxVar2.ebX.username;
                    p.g(str, "event.data.username");
                    bVar2.FpS = fod.aRS(str);
                    b bVar4 = this.FpX;
                    f fVar = this.FpX.FpS;
                    if (fVar != null) {
                        z = fVar.isValid();
                    } else {
                        z = false;
                    }
                    bVar4.BdH = z;
                    bVar = this.FpX;
                    f fVar2 = this.FpX.FpS;
                    if (fVar2 != null) {
                        z2 = fVar2.frA();
                    } else {
                        z2 = false;
                    }
                }
                bVar.FpT = z2;
                b.g(this.FpX);
                AppMethodBeat.o(119032);
            }
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void start() {
        AppMethodBeat.i(119035);
        com.tencent.mm.ac.d.b("SingleUserStateFetcher_start", new d(this));
        j.b bVar = j.Fmy;
        j.b.fod().add(this);
        EventCenter.instance.addListener(this.FpV);
        AppMethodBeat.o(119035);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void resume() {
        AppMethodBeat.i(119036);
        f fVar = this.FpS;
        if (fVar != null) {
            if (this.BdH && !fVar.isValid()) {
                Log.i(TAG, "LogStory: expired " + this.username);
                k kVar = k.FmH;
                k.aRQ(this.username);
            }
            AppMethodBeat.o(119036);
            return;
        }
        AppMethodBeat.o(119036);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void destroy() {
        AppMethodBeat.i(119037);
        j.b bVar = j.Fmy;
        j.b.fod().remove(this);
        EventCenter.instance.removeListener(this.FpV);
        AppMethodBeat.o(119037);
    }

    @Override // com.tencent.mm.plugin.story.api.l
    public final void a(l.a aVar) {
        this.FpR = aVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        l.a aVar;
        AppMethodBeat.i(119038);
        if (this.FpU) {
            AppMethodBeat.o(119038);
            return;
        }
        if (!(str == null || mStorageEventData == null || !(mStorageEventData.obj instanceof f))) {
            Object obj = mStorageEventData.obj;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
                AppMethodBeat.o(119038);
                throw tVar;
            }
            f fVar = (f) obj;
            if (!p.j(this.username, fVar.getUserName())) {
                AppMethodBeat.o(119038);
                return;
            } else if (p.j(str, "notify_story_read") || p.j(str, "notify_story_unread") || p.j(str, "notify_story_invalid") || p.j(str, "notify_story_valid")) {
                Log.i(TAG, "update user " + fVar.getUserName() + ' ' + fVar.field_syncId + ' ' + str);
                boolean z = this.FpT != fVar.frA();
                this.FpS = fVar;
                this.BdH = fVar.isValid();
                this.FpT = fVar.frA();
                fai();
                if (z && (aVar = this.FpR) != null) {
                    aVar.cs(this.username, this.FpT);
                    AppMethodBeat.o(119038);
                    return;
                }
            }
        }
        AppMethodBeat.o(119038);
    }

    private final void fai() {
        AppMethodBeat.i(119039);
        Log.i(TAG, "notifyListener: " + this.BdH + ' ' + this.FpT);
        com.tencent.mm.ac.d.h(new C1755b(this));
        AppMethodBeat.o(119039);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b FpX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.FpX = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean z;
            b bVar;
            boolean z2 = false;
            AppMethodBeat.i(119034);
            this.FpX.FpU = com.tencent.mm.plugin.sns.f.a.aOF(this.FpX.username);
            if (this.FpX.FpU) {
                this.FpX.BdH = false;
                bVar = this.FpX;
            } else {
                b bVar2 = this.FpX;
                j.b bVar3 = j.Fmy;
                bVar2.FpS = j.b.fod().aSw(this.FpX.username);
                b bVar4 = this.FpX;
                f fVar = this.FpX.FpS;
                if (fVar != null) {
                    z = fVar.isValid();
                } else {
                    z = false;
                }
                bVar4.BdH = z;
                bVar = this.FpX;
                f fVar2 = this.FpX.FpS;
                if (fVar2 != null) {
                    z2 = fVar2.frA();
                }
            }
            bVar.FpT = z2;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.story.f.f.b.d.AnonymousClass1 */
                final /* synthetic */ d FpY;

                {
                    this.FpY = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(119033);
                    l.a aVar = this.FpY.FpX.FpR;
                    if (aVar != null) {
                        aVar.cs(this.FpY.FpX.username, this.FpY.FpX.FpT);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(119033);
                    return xVar;
                }
            });
            b.g(this.FpX);
            x xVar = x.SXb;
            AppMethodBeat.o(119034);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.f.b$b  reason: collision with other inner class name */
    public static final class C1755b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b FpX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1755b(b bVar) {
            super(0);
            this.FpX = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119031);
            l.a aVar = this.FpX.FpR;
            if (aVar != null) {
                aVar.as(this.FpX.BdH, this.FpX.FpT);
            }
            if (this.FpX.BdH) {
                l.a aVar2 = this.FpX.FpR;
                if (aVar2 != null) {
                    aVar2.a(kotlin.a.j.listOf(this.FpX.username), new ArrayList<>());
                }
            } else {
                l.a aVar3 = this.FpX.FpR;
                if (aVar3 != null) {
                    aVar3.a(v.SXr, new ArrayList<>());
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119031);
            return xVar;
        }
    }
}
