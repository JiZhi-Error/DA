package com.tencent.mm.plugin.story.f.f;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0012\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002J\u0012\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0016J\u0006\u0010'\u001a\u00020\u0018J\u0012\u0010(\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u001eH\u0002J\u0012\u0010-\u001a\u00020\u00172\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0018\u00100\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u001eH\u0002J\u0018\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005H\u0016J:\u0010:\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160<0;j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160<j\b\u0012\u0004\u0012\u00020\u0016`>`=H\u0016J\b\u0010?\u001a\u000208H\u0016J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u000e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u0006\u0010D\u001a\u00020\u0018J\u0006\u0010E\u001a\u00020\u0018J\b\u0010F\u001a\u00020\u0018H\u0002J\u001c\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u00052\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0006\u0010K\u001a\u00020\u0018J\u0012\u0010L\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010M\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R,\u0010\u0014\u001a \u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0015X\u0004¢\u0006\u0002\n\u0000RN\u0010\u0019\u001aB\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001b0\u001b \t* \u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u001c0\u001aX\u0004¢\u0006\u0002\n\u0000RN\u0010\u001d\u001aB\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e \t* \u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u0005\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001e0\u001e\u0018\u00010\u001c0\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$IContactSyncFetcher;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "TAG", "", "displayNewList", "", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$StoryFetcherItemEntity;", "kotlin.jvm.PlatformType", "", "displayOlderUserList", "displayReplyUserList", "displayUnreadUserList", "listeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ContactSyncStateListener;", "snsPermissionNotifyListener", "com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1;", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "", "userReplyStateMap", "", "Lcom/tencent/mm/plugin/story/model/sync/StoryCommentReply;", "", "userStateMap", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "addNotifyListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "checkCommentState", "checkContactState", "checkRefreshUserList", "checkState", "checkStoryUnread", ch.COL_USERNAME, "destroy", "filterOut", "user", "filterRead", "isSelf", "storyExt", "filterStory", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "filterUnread", "filterUnreadComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "commentSync", "Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "getNewList", "getNewReplyCount", "", "storyOwner", "getNewReplyMap", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "Lkotlin/collections/ArrayList;", "getNewReplyTotalCount", "getOlderList", "getReadList", "getReplyUserList", "getUnreadList", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "notifyStoryList", "notifyUserList", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "pullTest", "removeNotifyListener", "updateUnreadList", "plugin-story_release"})
public final class a implements l.c, MStorage.IOnStorageChange {
    public static final r<Long, Boolean, String, String, x> FpA = j.FpN;
    public static final a FpB = new a();
    private static final Map<String, com.tencent.mm.plugin.story.i.f> Fpt = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final Map<String, c> Fpu = Collections.synchronizedMap(new ConcurrentHashMap());
    private static final List<String> Fpv = Collections.synchronizedList(new LinkedList());
    private static final List<String> Fpw = Collections.synchronizedList(new LinkedList());
    private static final List<String> Fpx = Collections.synchronizedList(new LinkedList());
    private static final List<l.d> Fpy = Collections.synchronizedList(new LinkedList());
    public static final i Fpz = new i();
    public static final String TAG = TAG;
    public static final LinkedList<l.b> ndV = new LinkedList<>();

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class j extends q implements r<Long, Boolean, String, String, x> {
        public static final j FpN = new j();

        static {
            AppMethodBeat.i(119000);
            AppMethodBeat.o(119000);
        }

        j() {
            super(4);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Boolean bool, String str, String str2) {
            AppMethodBeat.i(118999);
            final long longValue = l.longValue();
            final boolean booleanValue = bool.booleanValue();
            final String str3 = str;
            final String str4 = str2;
            p.h(str3, "fromUser");
            p.h(str4, "storyOwner");
            com.tencent.mm.ac.d.b("ContactSyncFetcher_checkContactState", new kotlin.g.a.a<x>() {
                /* class com.tencent.mm.plugin.story.f.f.a.j.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    HashMap<Long, Integer> hashMap;
                    HashMap<Long, Integer> hashMap2;
                    HashMap<Long, Integer> hashMap3;
                    HashMap<Long, Integer> hashMap4;
                    AppMethodBeat.i(118998);
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(longValue);
                    a aVar = a.FpB;
                    Log.i(a.TAG, "new comment in " + longValue + ", isUnread:" + booleanValue + ", storyOwner:" + str4 + ", fromUser:" + str3);
                    if (com.tencent.mm.plugin.story.c.a.a.FkW.fnu() || com.tencent.mm.plugin.story.c.a.a.FkW.fnd()) {
                        a aVar2 = a.FpB;
                        if (a.d(KA)) {
                            a aVar3 = a.FpB;
                            Log.i(a.TAG, "filterStory true");
                            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                            com.tencent.mm.plugin.story.i.c Kw = j.b.fof().Kw(longValue);
                            if (KA == null || Kw == null) {
                                a aVar4 = a.FpB;
                                c cVar = (c) a.Fpu.get(str4);
                                if (!(cVar == null || (hashMap2 = cVar.Fqa) == null)) {
                                    hashMap2.remove(Long.valueOf(longValue));
                                }
                                if (!(cVar == null || (hashMap = cVar.Fqa) == null || !hashMap.isEmpty())) {
                                    a aVar5 = a.FpB;
                                    a.Fpu.remove(str4);
                                    a aVar6 = a.FpB;
                                    a.Fpx.remove(str4);
                                }
                            } else {
                                eea eea = new eea();
                                try {
                                    eea.parseFrom(KA.field_attrBuf);
                                } catch (Exception e2) {
                                }
                                LinkedList<edf> linkedList = eea.Nen;
                                p.g(linkedList, "storyObj.CommentList");
                                ArrayList arrayList = new ArrayList();
                                for (T t : linkedList) {
                                    T t2 = t;
                                    a aVar7 = a.FpB;
                                    p.g(t2, LocaleUtil.ITALIAN);
                                    if (a.b(t2, Kw)) {
                                        arrayList.add(t);
                                    }
                                }
                                int size = arrayList.size();
                                a aVar8 = a.FpB;
                                Log.i(a.TAG, "commentCount ".concat(String.valueOf(size)));
                                if (size > 0) {
                                    a aVar9 = a.FpB;
                                    if (a.Fpu.get(str4) == null) {
                                        j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                                        long j2 = j.b.fod().aRS(str4).field_interactTime;
                                        a aVar10 = a.FpB;
                                        Map map = a.Fpu;
                                        p.g(map, "userReplyStateMap");
                                        String str = str4;
                                        String str2 = str4;
                                        LinkedList<edf> linkedList2 = eea.Nen;
                                        p.g(linkedList2, "storyObj.CommentList");
                                        c cVar2 = new c(str2, ((edf) kotlin.a.j.ku(linkedList2)).CreateTime, j2);
                                        cVar2.Fqa.put(Long.valueOf(longValue), Integer.valueOf(size));
                                        map.put(str, cVar2);
                                    } else {
                                        a aVar11 = a.FpB;
                                        c cVar3 = (c) a.Fpu.get(str4);
                                        if (cVar3 != null) {
                                            cVar3.Fqa.put(Long.valueOf(longValue), Integer.valueOf(size));
                                            LinkedList<edf> linkedList3 = eea.Nen;
                                            p.g(linkedList3, "storyObj.CommentList");
                                            cVar3.iXu = ((edf) kotlin.a.j.ku(linkedList3)).CreateTime;
                                        }
                                    }
                                } else {
                                    a aVar12 = a.FpB;
                                    if (a.Fpu.get(str4) != null) {
                                        a aVar13 = a.FpB;
                                        c cVar4 = (c) a.Fpu.get(str4);
                                        if (!(cVar4 == null || (hashMap4 = cVar4.Fqa) == null)) {
                                            hashMap4.remove(Long.valueOf(longValue));
                                        }
                                        if (!(cVar4 == null || (hashMap3 = cVar4.Fqa) == null || !hashMap3.isEmpty())) {
                                            a aVar14 = a.FpB;
                                            a.Fpu.remove(str4);
                                            a aVar15 = a.FpB;
                                            a.Fpx.remove(str4);
                                        }
                                    }
                                }
                            }
                            a.a(a.FpB);
                            com.tencent.mm.ac.d.h(AnonymousClass1.FpQ);
                            x xVar = x.SXb;
                            AppMethodBeat.o(118998);
                            return xVar;
                        }
                    }
                    a aVar16 = a.FpB;
                    Log.i(a.TAG, "filterStory false");
                    a aVar17 = a.FpB;
                    c cVar5 = (c) a.Fpu.get(str4);
                    if (cVar5 != null) {
                        cVar5.Fqa.remove(Long.valueOf(longValue));
                        if (cVar5.Fqa.isEmpty()) {
                            a aVar18 = a.FpB;
                            a.Fpu.remove(str4);
                            a aVar19 = a.FpB;
                            a.Fpx.remove(str4);
                        }
                    }
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(118998);
                    return xVar2;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(118999);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(119022);
        AppMethodBeat.o(119022);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(119024);
        aVar.fpe();
        AppMethodBeat.o(119024);
    }

    public static final /* synthetic */ boolean aSh(String str) {
        AppMethodBeat.i(119028);
        boolean aSg = aSg(str);
        AppMethodBeat.o(119028);
        return aSg;
    }

    public static final /* synthetic */ boolean b(edf edf, com.tencent.mm.plugin.story.i.c cVar) {
        AppMethodBeat.i(119030);
        boolean a2 = a(edf, cVar);
        AppMethodBeat.o(119030);
        return a2;
    }

    public static final /* synthetic */ boolean d(com.tencent.mm.plugin.story.i.j jVar) {
        AppMethodBeat.i(119029);
        boolean c2 = c(jVar);
        AppMethodBeat.o(119029);
        return c2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/story/model/sync/ContactSyncFetcher$snsPermissionNotifyListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsPermissionNotifyEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class i extends IListener<vx> {
        i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vx vxVar) {
            AppMethodBeat.i(118995);
            com.tencent.mm.ac.d.h(new C1754a(vxVar));
            AppMethodBeat.o(118995);
            return false;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.f.f.a$i$a  reason: collision with other inner class name */
        static final class C1754a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ vx FpM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1754a(vx vxVar) {
                super(0);
                this.FpM = vxVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(118994);
                vx vxVar = this.FpM;
                if ((vxVar != null ? vxVar.ebX : null) != null && this.FpM.ebX.ebY && !TextUtils.isEmpty(this.FpM.ebX.username)) {
                    a aVar = a.FpB;
                    if (!a.aSh(this.FpM.ebX.username)) {
                        if (!this.FpM.ebX.eca) {
                            a aVar2 = a.FpB;
                            a.Fpt.remove(this.FpM.ebX.username);
                        } else {
                            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                            com.tencent.mm.plugin.story.i.g fod = j.b.fod();
                            String str = this.FpM.ebX.username;
                            p.g(str, "event.data.username");
                            com.tencent.mm.plugin.story.i.f aRS = fod.aRS(str);
                            a aVar3 = a.FpB;
                            Map map = a.Fpt;
                            p.g(map, "userStateMap");
                            map.put(this.FpM.ebX.username, aRS);
                        }
                        a aVar4 = a.FpB;
                        a.fpi();
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(118994);
                return xVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class c<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(118978);
            int a2 = kotlin.b.a.a(Long.valueOf(((com.tencent.mm.plugin.story.i.f) t2).field_readTime), Long.valueOf(((com.tencent.mm.plugin.story.i.f) t).field_readTime));
            AppMethodBeat.o(118978);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class k<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            long j2;
            long j3;
            AppMethodBeat.i(119001);
            T t3 = t2;
            if (((com.tencent.mm.plugin.story.i.f) t3).field_updateTime == 0) {
                j2 = ((long) ((com.tencent.mm.plugin.story.i.f) t3).field_storyPostTime) * 1000;
            } else {
                j2 = ((com.tencent.mm.plugin.story.i.f) t3).field_updateTime;
            }
            Long valueOf = Long.valueOf(j2);
            T t4 = t;
            if (((com.tencent.mm.plugin.story.i.f) t4).field_updateTime == 0) {
                j3 = ((long) ((com.tencent.mm.plugin.story.i.f) t4).field_storyPostTime) * 1000;
            } else {
                j3 = ((com.tencent.mm.plugin.story.i.f) t4).field_updateTime;
            }
            int a2 = kotlin.b.a.a(valueOf, Long.valueOf(j3));
            AppMethodBeat.o(119001);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class l<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(119002);
            int a2 = kotlin.b.a.a(Integer.valueOf(t2.iXu), Integer.valueOf(t.iXu));
            AppMethodBeat.o(119002);
            return a2;
        }
    }

    public final void init() {
        AppMethodBeat.i(119003);
        Log.i(TAG, "init: ");
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fod().add(this);
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.foc().add(this);
        com.tencent.mm.ac.d.a(1000, d.FpF);
        Fpz.alive();
        com.tencent.mm.plugin.story.f.b.b bVar3 = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.f(FpA);
        AppMethodBeat.o(119003);
    }

    public static void fpb() {
        AppMethodBeat.i(119004);
        com.tencent.mm.ac.d.b("ContactSyncFetcher_pullTest", h.FpL);
        AppMethodBeat.o(119004);
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final void a(l.b bVar) {
        AppMethodBeat.i(119005);
        if (!ndV.contains(bVar)) {
            ndV.add(bVar);
        }
        AppMethodBeat.o(119005);
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final void b(l.b bVar) {
        AppMethodBeat.i(119006);
        ndV.remove(bVar);
        AppMethodBeat.o(119006);
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final List<String> fnn() {
        boolean z;
        AppMethodBeat.i(119007);
        LinkedList linkedList = new LinkedList();
        Set<Map.Entry<String, com.tencent.mm.plugin.story.i.f>> entrySet = Fpt.entrySet();
        synchronized (entrySet) {
            try {
                for (T t : entrySet) {
                    if (!aSg((String) t.getKey())) {
                        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                        boolean isEqual = Util.isEqual(j.b.fau(), (String) t.getKey());
                        Object value = t.getValue();
                        p.g(value, "it.value");
                        com.tencent.mm.plugin.story.i.f fVar = (com.tencent.mm.plugin.story.i.f) value;
                        if (isEqual) {
                            int i2 = fVar.field_storyPostTime;
                            i.a aVar = com.tencent.mm.plugin.story.f.i.Fmb;
                            if (!(i2 + com.tencent.mm.plugin.story.f.i.fnT() < cl.aWB())) {
                                j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                                if (!(Util.isEqual(j.b.fau(), fVar.getUserName()) && ((long) fVar.field_storyPostTime) > fVar.field_readTime / 1000)) {
                                    z = true;
                                }
                            }
                            z = false;
                        } else {
                            z = fVar.isValid() && !fVar.frA();
                        }
                        if (z) {
                            linkedList.add(t.getValue());
                        }
                    }
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(119007);
                throw th;
            }
        }
        LinkedList linkedList2 = linkedList;
        if (linkedList2.size() > 1) {
            kotlin.a.j.a((List) linkedList2, (Comparator) new c());
        }
        Log.i(TAG, "getReadList: size " + linkedList.size());
        LinkedList<com.tencent.mm.plugin.story.i.f> linkedList3 = linkedList;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList3, 10));
        for (com.tencent.mm.plugin.story.i.f fVar2 : linkedList3) {
            arrayList.add(fVar2.getUserName());
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(119007);
        return arrayList2;
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final List<String> fnj() {
        LinkedList linkedList;
        AppMethodBeat.i(119008);
        Log.i(TAG, "getUnreadList: size " + Fpw.size());
        List<String> list = Fpw;
        p.g(list, "displayUnreadUserList");
        synchronized (list) {
            try {
                linkedList = new LinkedList(Fpw);
            } finally {
                AppMethodBeat.o(119008);
            }
        }
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final List<String> fnk() {
        LinkedList linkedList;
        AppMethodBeat.i(119009);
        Log.i(TAG, "getOlderList: size " + Fpv.size());
        List<String> list = Fpv;
        p.g(list, "displayOlderUserList");
        synchronized (list) {
            try {
                linkedList = new LinkedList(Fpv);
            } finally {
                AppMethodBeat.o(119009);
            }
        }
        return linkedList;
    }

    public static List<String> fpc() {
        LinkedList linkedList;
        AppMethodBeat.i(119010);
        Log.i(TAG, "displaySortedReplyUserList: size " + Fpx.size());
        List<String> list = Fpx;
        p.g(list, "displayReplyUserList");
        synchronized (list) {
            try {
                linkedList = new LinkedList(Fpx);
            } finally {
                AppMethodBeat.o(119010);
            }
        }
        return linkedList;
    }

    public static List<l.d> fpd() {
        LinkedList linkedList;
        AppMethodBeat.i(119011);
        Log.i(TAG, "displayNewList: size " + Fpy.size());
        List<l.d> list = Fpy;
        p.g(list, "displayNewList");
        synchronized (list) {
            try {
                linkedList = new LinkedList(Fpy);
            } finally {
                AppMethodBeat.o(119011);
            }
        }
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final LinkedHashMap<String, ArrayList<Long>> fnl() {
        AppMethodBeat.i(119012);
        Log.i(TAG, "getNewReplyList: size " + Fpu.size());
        LinkedHashMap<String, ArrayList<Long>> linkedHashMap = new LinkedHashMap<>();
        synchronized (this) {
            try {
                Map<String, c> map = Fpu;
                p.g(map, "userReplyStateMap");
                for (Map.Entry<String, c> entry : map.entrySet()) {
                    String key = entry.getKey();
                    ArrayList<Long> arrayList = new ArrayList<>();
                    arrayList.addAll(entry.getValue().Fqa.keySet());
                    p.g(key, "storyOwner");
                    linkedHashMap.put(key, arrayList);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119012);
            }
        }
        return linkedHashMap;
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final int fnm() {
        AppMethodBeat.i(119013);
        int i2 = 0;
        Set<Map.Entry<String, c>> entrySet = Fpu.entrySet();
        synchronized (entrySet) {
            try {
                Iterator<T> it = entrySet.iterator();
                while (it.hasNext()) {
                    for (Map.Entry<Long, Integer> entry : ((c) it.next().getValue()).Fqa.entrySet()) {
                        i2 = entry.getValue().intValue() + i2;
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119013);
            }
        }
        return i2;
    }

    public final int aSf(String str) {
        int i2;
        HashMap<Long, Integer> hashMap;
        AppMethodBeat.i(119014);
        p.h(str, "storyOwner");
        Log.i(TAG, "getNewReplyCount: storyOwner ".concat(String.valueOf(str)));
        int i3 = 0;
        synchronized (this) {
            try {
                c cVar = Fpu.get(str);
                if (cVar == null || (hashMap = cVar.Fqa) == null) {
                    i2 = 0;
                } else {
                    for (Map.Entry<Long, Integer> entry : hashMap.entrySet()) {
                        i3 += entry.getValue().intValue();
                    }
                    x xVar = x.SXb;
                    i2 = i3;
                }
            } finally {
                AppMethodBeat.o(119014);
            }
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.story.api.l.c
    public final void fno() {
        AppMethodBeat.i(119015);
        com.tencent.mm.ac.d.b("ContactSyncFetcher_checkContactState", C1753a.FpC);
        AppMethodBeat.o(119015);
    }

    private final synchronized void fpe() {
        long j2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean frA;
        AppMethodBeat.i(119016);
        LinkedList<com.tencent.mm.plugin.story.i.f> linkedList = new LinkedList();
        Map<String, com.tencent.mm.plugin.story.i.f> map = Fpt;
        p.g(map, "userStateMap");
        synchronized (map) {
            try {
                for (Map.Entry<String, com.tencent.mm.plugin.story.i.f> entry : Fpt.entrySet()) {
                    if (!aSg(entry.getKey())) {
                        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                        boolean isEqual = Util.isEqual(j.b.fau(), entry.getKey());
                        com.tencent.mm.plugin.story.i.f value = entry.getValue();
                        p.g(value, "it.value");
                        com.tencent.mm.plugin.story.i.f fVar = value;
                        if (isEqual) {
                            frA = false;
                        } else {
                            frA = fVar.frA();
                        }
                        if (frA) {
                            linkedList.add(entry.getValue());
                        }
                    }
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(119016);
            }
        }
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
        int i2 = ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("StoryEntranceShouldShowInTimelineOfUnreadCount", 3);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        int i3 = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getInt("StoryShouldShowEntranceInTimelineOfTimeDuration", LocalCache.TIME_HOUR);
        Log.i(TAG, "updateUnreadList: unread " + linkedList.size() + ", displayUnread:" + Fpw.size() + ", displayOld:" + Fpv.size() + ", displayNewReply:" + Fpu.size() + ", totalCount:" + i2 + ", showDuration:" + i3);
        if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
            boolean z4 = false;
            if (Fpw.size() + Fpv.size() + Fpu.size() > 0) {
                z4 = true;
            }
            if (!z4 && linkedList.size() >= i2) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.n(1015, 10, 1);
                z4 = true;
            }
            if (!z4) {
                for (com.tencent.mm.plugin.story.i.f fVar2 : linkedList) {
                    long j3 = fVar2.field_updateTime;
                    if (j3 == 0) {
                        j3 = ((long) fVar2.field_storyPostTime) * 1000;
                    }
                    if (Util.secondsToNow(j3 / 1000) >= ((long) i3)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1015, 11, 1);
                        z3 = true;
                    } else {
                        z3 = z4;
                    }
                    z4 = z3;
                }
            }
            if (!z4) {
                AppMethodBeat.o(119016);
            }
        }
        LinkedList linkedList2 = linkedList;
        if (linkedList2.size() > 1) {
            kotlin.a.j.a((List) linkedList2, (Comparator) new k());
        }
        com.tencent.mm.plugin.story.i.f fVar3 = (com.tencent.mm.plugin.story.i.f) kotlin.a.j.kt(linkedList);
        if (fVar3 != null) {
            linkedList.remove(fVar3);
            linkedList.add(0, fVar3);
        }
        Fpw.clear();
        Fpv.clear();
        Fpx.clear();
        Fpy.clear();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_STORY_SNS_SHOW_TIME_LONG, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Fpu.values());
        for (c cVar : kotlin.a.j.a((Iterable) arrayList, (Comparator) new l())) {
            Fpx.add(cVar.Foa);
            if (((long) cVar.iXu) > a2 / 1000) {
                Fpy.add(new l.d(cVar.Foa, 1));
            }
        }
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        long a3 = aAh2.azQ().a(ar.a.USERINFO_STORY_SNS_UPDATE_TIME_LONG, 0);
        LinkedList<com.tencent.mm.plugin.story.i.f> linkedList3 = linkedList;
        synchronized (linkedList3) {
            try {
                for (com.tencent.mm.plugin.story.i.f fVar4 : linkedList3) {
                    j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.k foc = j.b.foc();
                    String userName = fVar4.getUserName();
                    int aWB = cl.aWB();
                    i.a aVar = com.tencent.mm.plugin.story.f.i.Fmb;
                    List<com.tencent.mm.plugin.story.i.j> j4 = foc.j(userName, false, aWB - com.tencent.mm.plugin.story.f.i.fnT());
                    j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.k foc2 = j.b.foc();
                    String userName2 = fVar4.getUserName();
                    int aWB2 = cl.aWB();
                    i.a aVar2 = com.tencent.mm.plugin.story.f.i.Fmb;
                    boolean z5 = com.tencent.mm.plugin.story.i.k.a(foc2, userName2, false, aWB2 - com.tencent.mm.plugin.story.f.i.fnT()).size() != j4.size();
                    if (!z5) {
                        j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
                        if (Util.isEqual(j.b.fau(), fVar4.getUserName())) {
                            j2 = ((long) fVar4.field_storyPostTime) * 1000;
                        } else {
                            j2 = fVar4.field_updateTime == 0 ? ((long) fVar4.field_storyPostTime) * 1000 : fVar4.field_updateTime;
                        }
                        if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                            Fpw.add(fVar4.getUserName());
                            if (j2 > a2) {
                                Fpy.add(new l.d(fVar4.getUserName(), 0));
                            }
                        } else if (j2 > a3) {
                            Fpw.add(fVar4.getUserName());
                        } else {
                            Fpv.add(fVar4.getUserName());
                        }
                        String str = TAG;
                        StringBuilder append = new StringBuilder("make list username:").append(fVar4.getUserName()).append(" updateTime:").append(fVar4.field_updateTime).append(" posTime:").append(fVar4.field_storyPostTime).append(" makeTime:").append(a3).append(" itUpdateTime ").append(j2).append(" result ");
                        if (j2 > a3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Log.i(str, append.append(z).append(" hasInvisibleItem:").append(z5).append(" lastShowEntranceTime:").append(a2).toString());
                    } else if (!j4.isEmpty()) {
                        long j5 = ((long) j4.get(0).field_createTime) * 1000;
                        if (j5 > fVar4.field_readTime) {
                            if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                                Fpw.add(fVar4.getUserName());
                                if (j5 > a2) {
                                    Fpy.add(new l.d(fVar4.getUserName(), 0));
                                }
                            } else if (j5 > a3) {
                                Fpw.add(fVar4.getUserName());
                            } else {
                                Fpv.add(fVar4.getUserName());
                            }
                        }
                        String str2 = TAG;
                        StringBuilder append2 = new StringBuilder("make list username:").append(fVar4.getUserName()).append(" updateTime:").append(fVar4.field_updateTime).append(" posTime:").append(fVar4.field_storyPostTime).append(" makeTime:").append(a3).append(" itUpdateTime ").append(j5).append(" result ");
                        if (j5 > a3) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        Log.i(str2, append2.append(z2).append(" hasInvisibleItem:").append(z5).append(" lastShowEntranceTime:").append(a2).toString());
                    }
                }
                x xVar2 = x.SXb;
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i(TAG, "update time " + a3 + " displayUnreadUserList " + Fpw + " displayOlderUserList " + Fpv + " userReplyStateMap " + Fpu + " displaySortedReplyUserList:" + Fpx + " displayNewList:" + Fpy);
        AppMethodBeat.o(119016);
    }

    private static boolean aSg(String str) {
        boolean z;
        AppMethodBeat.i(119017);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (!Util.isEqual(str, j.b.fau())) {
                AppMethodBeat.o(119017);
                return false;
            }
        }
        AppMethodBeat.o(119017);
        return true;
    }

    private static boolean a(edf edf, com.tencent.mm.plugin.story.i.c cVar) {
        AppMethodBeat.i(119018);
        if (edf.MYT != 0 && edf.CreateTime > cVar.field_readCommentTime) {
            String str = edf.xNH;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (!Util.isEqual(str, j.b.fau())) {
                AppMethodBeat.o(119018);
                return true;
            }
        }
        AppMethodBeat.o(119018);
        return false;
    }

    private static boolean c(com.tencent.mm.plugin.story.i.j jVar) {
        AppMethodBeat.i(119019);
        if (jVar == null) {
            AppMethodBeat.o(119019);
            return false;
        } else if (jVar.frL()) {
            boolean frK = jVar.frK();
            AppMethodBeat.o(119019);
            return frK;
        } else {
            String str = jVar.field_userName;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            if (!Util.isEqual(str, j.b.fau())) {
                AppMethodBeat.o(119019);
                return true;
            }
            AppMethodBeat.o(119019);
            return false;
        }
    }

    public static void fpf() {
        AppMethodBeat.i(119020);
        com.tencent.mm.ac.d.b("ContactSyncFetcher_checkContactState", e.FpG);
        AppMethodBeat.o(119020);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        r0 = r8.obj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r0 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r0 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryExtInfo");
        com.tencent.matrix.trace.core.AppMethodBeat.o(119021);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r7.equals("notify_story_invalid") != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r7.equals("notify_story_valid") != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005f, code lost:
        if (r7.equals("notify_story_read") != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        if (r7.equals("notify_story_preload") != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r0 = (com.tencent.mm.plugin.story.i.f) r0;
        r1 = r0.getUserName();
        com.tencent.mm.sdk.platformtools.Log.i(com.tencent.mm.plugin.story.f.f.a.TAG, "[StoryExtInfo] onNotifyChange: event " + r7 + ' ' + r1);
        r2 = com.tencent.mm.plugin.story.f.f.a.Fpt;
        kotlin.g.b.p.g(r2, "userStateMap");
        r2.put(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a5, code lost:
        if ((!kotlin.g.b.p.j(r7, "notify_story_preload")) == false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a7, code lost:
        com.tencent.mm.ac.d.b("ContactSyncFetcher_checkContactState", com.tencent.mm.plugin.story.f.f.a.f.FpI);
        com.tencent.matrix.trace.core.AppMethodBeat.o(119021);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r7.equals("notify_story_unread") != false) goto L_0x0034;
     */
    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNotifyChange(java.lang.String r7, com.tencent.mm.sdk.storage.MStorageEventData r8) {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.f.a.onNotifyChange(java.lang.String, com.tencent.mm.sdk.storage.MStorageEventData):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        public static final d FpF = new d();

        static {
            AppMethodBeat.i(118980);
            AppMethodBeat.o(118980);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118979);
            a aVar = a.FpB;
            a.fpg();
            x xVar = x.SXb;
            AppMethodBeat.o(118979);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        public static final h FpL = new h();

        static {
            AppMethodBeat.i(118993);
            AppMethodBeat.o(118993);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118992);
            a aVar = a.FpB;
            com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c(a.TAG);
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "service(IMessengerStorage::class.java)");
            Cursor gCq = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().gCq();
            if (gCq != null) {
                while (gCq.moveToNext()) {
                    as asVar = new as();
                    asVar.convertFrom(gCq);
                    ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).loadStory(asVar.getUsername(), "");
                }
                gCq.close();
            } else {
                a aVar2 = a.FpB;
                Log.w(a.TAG, "checkContactState: cursor is null");
            }
            cVar.aBw();
            a aVar3 = a.FpB;
            Log.i(a.TAG, "pullTest done ");
            x xVar = x.SXb;
            AppMethodBeat.o(118992);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.f.a$a  reason: collision with other inner class name */
    static final class C1753a extends q implements kotlin.g.a.a<x> {
        public static final C1753a FpC = new C1753a();

        static {
            AppMethodBeat.i(118975);
            AppMethodBeat.o(118975);
        }

        C1753a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118974);
            a.a(a.FpB);
            com.tencent.mm.ac.d.h(AnonymousClass1.FpD);
            x xVar = x.SXb;
            AppMethodBeat.o(118974);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        public static final b FpE = new b();

        static {
            AppMethodBeat.i(118977);
            AppMethodBeat.o(118977);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118976);
            a aVar = a.FpB;
            a.fpj();
            a aVar2 = a.FpB;
            a.fpk();
            a.a(a.FpB);
            a aVar3 = a.FpB;
            String str = a.TAG;
            StringBuilder sb = new StringBuilder("checkContactState: user size is ");
            a aVar4 = a.FpB;
            StringBuilder append = sb.append(a.Fpt.size()).append(", unread ");
            a aVar5 = a.FpB;
            Log.i(str, append.append(a.Fpw.size()).toString());
            x xVar = x.SXb;
            AppMethodBeat.o(118976);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        public static final e FpG = new e();

        static {
            AppMethodBeat.i(118984);
            AppMethodBeat.o(118984);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118983);
            a.a(a.FpB);
            com.tencent.mm.ac.d.h(AnonymousClass1.FpH);
            x xVar = x.SXb;
            AppMethodBeat.o(118983);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        public static final f FpI = new f();

        static {
            AppMethodBeat.i(118988);
            AppMethodBeat.o(118988);
        }

        f() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118987);
            a.a(a.FpB);
            com.tencent.mm.ac.d.h(AnonymousClass1.FpJ);
            x xVar = x.SXb;
            AppMethodBeat.o(118987);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ MStorageEventData oBN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MStorageEventData mStorageEventData) {
            super(0);
            this.oBN = mStorageEventData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            HashMap<Long, Integer> hashMap;
            AppMethodBeat.i(118991);
            Object obj = this.oBN.obj;
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.o(118991);
                throw tVar;
            }
            String str = ((com.tencent.mm.plugin.story.i.j) obj).field_userName;
            Object obj2 = this.oBN.obj;
            if (obj2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.storage.StoryInfo");
                AppMethodBeat.o(118991);
                throw tVar2;
            }
            long j2 = ((com.tencent.mm.plugin.story.i.j) obj2).field_storyID;
            a aVar = a.FpB;
            Log.i(a.TAG, "[StoryInfo] onNotifyChange: " + str + ' ' + j2);
            a aVar2 = a.FpB;
            c cVar = (c) a.Fpu.get(str);
            if (cVar != null) {
                hashMap = cVar.Fqa;
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                hashMap.remove(Long.valueOf(j2));
                if (hashMap.isEmpty()) {
                    a aVar3 = a.FpB;
                    a.Fpu.remove(str);
                    a aVar4 = a.FpB;
                    a.Fpx.remove(str);
                }
            }
            a.a(a.FpB);
            com.tencent.mm.ac.d.h(AnonymousClass1.FpK);
            x xVar = x.SXb;
            AppMethodBeat.o(118991);
            return xVar;
        }
    }

    public static final /* synthetic */ void fpg() {
        AppMethodBeat.i(119023);
        com.tencent.mm.ac.d.b("ContactSyncFetcher_checkContactState", b.FpE);
        AppMethodBeat.o(119023);
    }

    public static final /* synthetic */ void fpi() {
        AppMethodBeat.i(119025);
        Iterator<T> it = ndV.iterator();
        while (it.hasNext()) {
            it.next().fkX();
        }
        AppMethodBeat.o(119025);
    }

    public static final /* synthetic */ void fpj() {
        AppMethodBeat.i(119026);
        com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c(TAG);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "service(IMessengerStorage::class.java)");
        bv aSN = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN();
        p.g(aSN, "service(IMessengerStorage::class.java).contactStg");
        Cursor gCq = aSN.gCq();
        if (gCq != null) {
            while (gCq.moveToNext()) {
                as asVar = new as();
                asVar.convertFrom(gCq);
                String username = asVar.getUsername();
                if (!aSg(username) && !com.tencent.mm.plugin.sns.f.a.aOF(username)) {
                    Map<String, com.tencent.mm.plugin.story.i.f> map = Fpt;
                    p.g(map, "userStateMap");
                    j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                    com.tencent.mm.plugin.story.i.g fod = j.b.fod();
                    p.g(username, ch.COL_USERNAME);
                    map.put(username, fod.aRS(username));
                }
            }
            gCq.close();
        } else {
            Log.w(TAG, "checkContactState: cursor is null");
        }
        cVar.aBw();
        AppMethodBeat.o(119026);
    }

    public static final /* synthetic */ void fpk() {
        AppMethodBeat.i(119027);
        if (com.tencent.mm.plugin.story.c.a.a.FkW.fnu() || com.tencent.mm.plugin.story.c.a.a.FkW.fnd()) {
            com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c(TAG);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.b fof = j.b.fof();
            ArrayList<com.tencent.mm.plugin.story.i.c> arrayList = new ArrayList();
            Cursor rawQuery = fof.db.rawQuery(com.tencent.mm.plugin.story.i.b.FvX + " WHERE " + fof.FvW, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    com.tencent.mm.plugin.story.i.c cVar2 = new com.tencent.mm.plugin.story.i.c();
                    cVar2.convertFrom(rawQuery);
                    arrayList.add(cVar2);
                }
                rawQuery.close();
            }
            for (com.tencent.mm.plugin.story.i.c cVar3 : arrayList) {
                j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(cVar3.field_storyId);
                if (KA != null && c(KA)) {
                    String str = KA.field_userName;
                    eea eea = new eea();
                    try {
                        eea.parseFrom(KA.field_attrBuf);
                    } catch (Exception e2) {
                    }
                    LinkedList<edf> linkedList = eea.Nen;
                    p.g(linkedList, "storyObj.CommentList");
                    ArrayList arrayList2 = new ArrayList();
                    for (T t : linkedList) {
                        T t2 = t;
                        p.g(t2, LocaleUtil.ITALIAN);
                        if (a(t2, cVar3)) {
                            arrayList2.add(t);
                        }
                    }
                    int size = arrayList2.size();
                    if (str != null) {
                        if ((str.length() > 0) && size > 0) {
                            if (Fpu.get(str) == null) {
                                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                                long j2 = j.b.fod().aRS(str).field_interactTime;
                                Map<String, c> map = Fpu;
                                p.g(map, "userReplyStateMap");
                                LinkedList<edf> linkedList2 = eea.Nen;
                                p.g(linkedList2, "storyObj.CommentList");
                                c cVar4 = new c(str, ((edf) kotlin.a.j.ku(linkedList2)).CreateTime, j2);
                                cVar4.Fqa.put(Long.valueOf(KA.field_storyID), Integer.valueOf(size));
                                map.put(str, cVar4);
                            } else {
                                c cVar5 = Fpu.get(str);
                                if (cVar5 != null) {
                                    cVar5.Fqa.put(Long.valueOf(KA.field_storyID), Integer.valueOf(size));
                                }
                            }
                            Log.i(TAG, "checkCommentState " + Fpu.get(str));
                        }
                    }
                }
            }
            cVar.aBw();
        }
        AppMethodBeat.o(119027);
    }
}
