package com.tencent.mm.plugin.story.f.b;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.protocal.protobuf.ede;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edi;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0016H\u0016J,\u0010'\u001a\u00020\u001b2$\u0010&\u001a \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0#J \u0010(\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0018J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J\u000e\u0010-\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+J(\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u00072\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\u0005J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001dH\u0002J\"\u00105\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\u0005H\u0002J\u0006\u00106\u001a\u00020\u001bJ\u0006\u00107\u001a\u00020\u001bJ\u0016\u00108\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001fJ*\u0010:\u001a\u00020\u001b2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020A2\u0006\u00104\u001a\u00020\u001dH\u0002J0\u0010B\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020\u0005J8\u0010F\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0007JV\u0010H\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u00020\u0007H\u0002J\u0010\u0010K\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001dH\u0002J0\u0010L\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010E\u001a\u00020\u0005J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0016H\u0016J,\u0010N\u001a\u00020\u001b2$\u0010&\u001a \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0#J \u0010O\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0018J\u0010\u0010P\u001a\u00020\u001b2\u0006\u0010Q\u001a\u00020AH\u0002J\u0010\u0010R\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010S\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001aJ\u0016\u0010T\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u001fJ\u0010\u0010U\u001a\u00020A2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010V\u001a\u00020\u001bH\u0002J\u0016\u0010W\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u0019J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0012\u0010[\u001a\u00020\u001b2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0002J\u0006\u0010^\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R&\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00180\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000RZ\u0010!\u001aN\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0#0\"j&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b0#`$X\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/story/model/comment/StoryCommentLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/api/IStoryComment;", "()V", "CacheFilePath", "", "MaxCacheSize", "", "MaxRetryCount", "OldCacheFilePath", "StateDeleted", "StateDeleting", "StateNone", "StatePosted", "StatePosting", "TAG", "commentCache", "Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "getCommentCache", "()Lcom/tencent/mm/protocal/protobuf/StoryCommentCache;", "commentChangeListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/story/api/IStoryComment$CommentChangeListener;", "commentPostStateListeners", "Lkotlin/Function2;", "", "", "", "currentCommentOp", "Lcom/tencent/mm/protocal/protobuf/StoryCommentOp;", "currentPostCommentItem", "Lcom/tencent/mm/plugin/story/model/comment/StoryCommentItem;", "opIndex", "storyCommentChangeListeners", "Ljava/util/ArrayList;", "Lkotlin/Function4;", "Lkotlin/collections/ArrayList;", "addCommentChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addStoryCommentChangeListener", "addStoryCommentPostStateListener", "addSyncComment", "syncMsg", "Lcom/tencent/mm/protocal/protobuf/StorySyncMsg;", "addSyncVisit", "delSyncComment", "deleteComment", "storyId", "commentId", "sessionId", "content", "deleteCommentToRemote", "commentOp", "deleteCommentToStoryInfo", "destroy", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initCommentSync", "commentItem", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "opToDetail", "Lcom/tencent/mm/protocal/protobuf/StoryCommentDetail;", "postBubble", "toUsername", "doubleClick", "storyOwner", "postComment", "replyCommentId", "postCommentOrBubble", "enhance", "commentFlag", "postCommentToRemote", "postVisit", "removeCommentChangeListener", "removeStoryCommentChangeListener", "removeStoryCommentPostStateListener", "saveCommentToStoryInfo", "commentDetail", "saveCommentToStoryInfoWithObj", "setAllCommentRead", "setCommentRead", "syncMsgToDetail", "tryStart", "updateCommentRead", "hasUnread", "force", "updateLastCommentSync", "updateStoryInfoByComment", "storyObj", "Lcom/tencent/mm/protocal/protobuf/StoryObject;", "writeCacheToFile", "plugin-story_release"})
public final class b implements com.tencent.mm.ak.i, com.tencent.mm.plugin.story.api.h {
    public static final String DNm;
    public static final String Fod;
    private static final int Foe = 50;
    public static final ede Fof = new ede();
    private static edg Fog = null;
    private static a Foh = null;
    private static int Foi = -1;
    private static final ArrayList<r<Long, Boolean, String, String, x>> Foj = new ArrayList<>();
    private static final LinkedList<Object> Fok = new LinkedList<>();
    private static final LinkedList<m<Boolean, Long, x>> Fol = new LinkedList<>();
    public static final b Fom = new b();
    public static final String TAG = TAG;
    private static final int wSn = Integer.MAX_VALUE;

    static {
        AppMethodBeat.i(118882);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Fod = sb.append(aAh.getAccPath()).append("story/commentCache.proto").toString();
        StringBuilder sb2 = new StringBuilder();
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
        p.g(ah, "MMKernel.plugin(IPluginStory::class.java)");
        DNm = sb2.append(((com.tencent.mm.plugin.story.api.e) ah).getAccStoryPath()).append("commentCache.proto").toString();
        AppMethodBeat.o(118882);
    }

    private b() {
    }

    public static final /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(222910);
        fbQ();
        AppMethodBeat.o(222910);
    }

    public static final /* synthetic */ edf b(edg edg) {
        AppMethodBeat.i(118885);
        edf a2 = a(edg);
        AppMethodBeat.o(118885);
        return a2;
    }

    public static final /* synthetic */ void b(eea eea) {
        AppMethodBeat.i(118886);
        a(eea);
        AppMethodBeat.o(118886);
    }

    public static final /* synthetic */ void l(long j2, int i2, String str) {
        AppMethodBeat.i(118883);
        k(j2, i2, str);
        AppMethodBeat.o(118883);
    }

    public static void foR() {
        AppMethodBeat.i(118862);
        s.C(DNm, Fof.toByteArray());
        AppMethodBeat.o(118862);
    }

    public static void f(r<? super Long, ? super Boolean, ? super String, ? super String, x> rVar) {
        AppMethodBeat.i(118863);
        p.h(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!Foj.contains(rVar)) {
            Foj.add(rVar);
        }
        AppMethodBeat.o(118863);
    }

    public static void g(r<? super Long, ? super Boolean, ? super String, ? super String, x> rVar) {
        AppMethodBeat.i(118864);
        p.h(rVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Foj.remove(rVar);
        AppMethodBeat.o(118864);
    }

    public static void i(m<? super Boolean, ? super Long, x> mVar) {
        AppMethodBeat.i(118865);
        p.h(mVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!Fol.contains(mVar)) {
            Fol.add(mVar);
        }
        AppMethodBeat.o(118865);
    }

    public static void j(m<? super Boolean, ? super Long, x> mVar) {
        AppMethodBeat.i(118866);
        p.h(mVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Fol.remove(mVar);
        AppMethodBeat.o(118866);
    }

    public final a b(long j2, String str, String str2, String str3, String str4, int i2) {
        AppMethodBeat.i(118867);
        p.h(str, "content");
        p.h(str2, "toUsername");
        p.h(str4, "storyOwner");
        Log.i(TAG, "postComment: " + j2 + ' ' + str + ' ' + str2);
        a a2 = a(this, j2, str2, str, false, str3, str4, i2, 0, 256);
        AppMethodBeat.o(118867);
        return a2;
    }

    public final void b(long j2, int i2, String str, String str2) {
        AppMethodBeat.i(118868);
        p.h(str2, "content");
        Log.i(TAG, "deleteComment storyId:" + j2 + " commentId:" + i2 + " sessionId:" + str + " content:" + str2);
        if (i2 != 0) {
            StringBuilder sb = new StringBuilder();
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            String sb2 = sb.append(j.b.fau()).append(Util.currentTicks()).toString();
            Charset charset = kotlin.n.d.UTF_8;
            if (sb2 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(118868);
                throw tVar;
            }
            byte[] bytes = sb2.getBytes(charset);
            p.g(bytes, "(this as java.lang.String).getBytes(charset)");
            String messageDigest = com.tencent.xweb.util.d.getMessageDigest(bytes);
            edg edg = new edg();
            edg.edx = j2;
            edg.clientId = messageDigest;
            edg.FnS = i2;
            edg.iXu = cl.aWB();
            edg.state = 3;
            edg.sessionId = str;
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            edg.dRL = j.b.fau();
            edg.toUser = "";
            Fof.Ndz.add(edg);
            fbQ();
        }
        j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new c(j2, i2, str2));
        AppMethodBeat.o(118868);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ long Foo;
        final /* synthetic */ int Fop;
        final /* synthetic */ String grJ;

        c(long j2, int i2, String str) {
            this.Foo = j2;
            this.Fop = i2;
            this.grJ = str;
        }

        public final void run() {
            AppMethodBeat.i(118851);
            b bVar = b.Fom;
            b.l(this.Foo, this.Fop, this.grJ);
            AppMethodBeat.o(118851);
        }
    }

    public static void a(long j2, a aVar) {
        AppMethodBeat.i(118869);
        p.h(aVar, "commentItem");
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.c Kw = j.b.fof().Kw(j2);
        if (Kw == null) {
            Kw = new com.tencent.mm.plugin.story.i.c();
            Kw.field_storyId = j2;
        }
        Kw.field_readCommentId = aVar.FnS;
        Kw.field_readCommentTime = aVar.iXu;
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fof().update(Kw, new String[0]);
        AppMethodBeat.o(118869);
    }

    public static boolean b(long j2, a aVar) {
        AppMethodBeat.i(118870);
        p.h(aVar, "commentDetail");
        z.f fVar = new z.f();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        fVar.SYG = (T) j.b.fof().Kw(j2);
        if (fVar.SYG == null) {
            fVar.SYG = (T) new com.tencent.mm.plugin.story.i.c();
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_storyId = j2;
        }
        if (((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentId == aVar.FnS || ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime >= aVar.iXu) {
            AppMethodBeat.o(118870);
            return false;
        }
        ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentId = aVar.FnS;
        ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime = aVar.iXu;
        fVar.SYG.aSr(aVar.dRL);
        fVar.SYG.aSd(aVar.Foa);
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fof().update(fVar.SYG, new String[0]);
        com.tencent.mm.ac.d.h(new i(fVar));
        AppMethodBeat.o(118870);
        return true;
    }

    public static void Kk(long j2) {
        byte[] bArr;
        edf edf;
        boolean z;
        AppMethodBeat.i(118871);
        z.f fVar = new z.f();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        fVar.SYG = (T) j.b.fof().Kw(j2);
        if (fVar.SYG == null) {
            fVar.SYG = (T) new com.tencent.mm.plugin.story.i.c();
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_storyId = j2;
        }
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(j2);
        if (KA == null) {
            AppMethodBeat.o(118871);
            return;
        }
        eea eea = new eea();
        if (KA != null) {
            try {
                bArr = KA.field_attrBuf;
            } catch (Exception e2) {
            }
        } else {
            bArr = null;
        }
        eea.parseFrom(bArr);
        LinkedList<edf> linkedList = eea.Nen;
        p.g(linkedList, "storyObj.CommentList");
        LinkedList<edf> linkedList2 = linkedList;
        ListIterator<edf> listIterator = linkedList2.listIterator(linkedList2.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                edf = null;
                break;
            }
            edf previous = listIterator.previous();
            if (previous.MYT != 0) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                edf = previous;
                break;
            }
        }
        edf edf2 = edf;
        if (edf2 != null) {
            if (((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentId != edf2.MYT && ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime < edf2.CreateTime) {
                ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentId = edf2.MYT;
                ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime = edf2.CreateTime;
                String str = edf2.xNH;
                p.g(str, "it.FromUserName");
                fVar.SYG.aSr(str);
                T t = fVar.SYG;
                String str2 = KA.field_userName;
                if (str2 == null) {
                    str2 = "";
                }
                t.aSd(str2);
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.fof().update(fVar.SYG, new String[0]);
                com.tencent.mm.ac.d.h(new h(fVar, KA));
            }
            AppMethodBeat.o(118871);
            return;
        }
        AppMethodBeat.o(118871);
    }

    public static void at(boolean z, boolean z2) {
        AppMethodBeat.i(118872);
        boolean cO = com.tencent.mm.y.c.axV().cO(352279, 266241);
        Log.i(TAG, "updateCommentRead: " + cO + ", " + z);
        if (cO != z || z2) {
            com.tencent.mm.ac.d.h(new j(z));
        }
        AppMethodBeat.o(118872);
    }

    public static void fbQ() {
        boolean z = false;
        AppMethodBeat.i(118873);
        ArrayList arrayList = new ArrayList();
        int size = Fof.Ndz.size();
        for (int i2 = 0; i2 < size; i2++) {
            edg edg = Fof.Ndz.get(i2);
            if (edg.state == 1 || edg.state == 3) {
                int i3 = edg.iXu;
                int aWB = cl.aWB();
                i.a aVar = com.tencent.mm.plugin.story.f.i.Fmb;
                if (i3 > aWB - com.tencent.mm.plugin.story.f.i.fnT()) {
                    arrayList.add(edg);
                }
            }
        }
        Fof.Ndz.clear();
        Fof.Ndz.addAll(arrayList);
        Foi++;
        if (arrayList.size() == 0) {
            Foi = -1;
            AppMethodBeat.o(118873);
            return;
        }
        Foi %= arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i4 = 0;
        for (Object obj : arrayList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                kotlin.a.j.hxH();
            }
            if (i4 >= Foi && ((edg) obj).retryCount < wSn) {
                arrayList2.add(obj);
            }
            i4 = i5;
        }
        edg edg2 = (edg) kotlin.a.j.kt(arrayList2);
        if (edg2 == null || edg2.state != 1) {
            if (edg2 != null && edg2.state == 3) {
                Log.i(TAG, "deleteCommentToRemote " + edg2.toUser + ' ' + edg2.edx + ' ' + edg2.FnS + ' ' + edg2.iXu);
                Fog = edg2;
                ArrayList arrayList3 = new ArrayList();
                long j2 = edg2.edx;
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                arrayList3.add(new com.tencent.mm.plugin.story.f.a.j(j2, com.tencent.mm.plugin.story.i.a.Fvc, edg2.FnS));
                com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
                p.g(aAg, "network()");
                aAg.azz().b(new com.tencent.mm.plugin.story.f.a.f(arrayList3));
            }
            AppMethodBeat.o(118873);
            return;
        }
        Log.i(TAG, "postCommentToRemote " + edg2.toUser + ' ' + edg2.edx + ' ' + edg2.NdF + ' ' + edg2.iXu);
        Fog = edg2;
        edf a2 = a(edg2);
        String str = a2.iAc;
        if (str == null || str.length() == 0) {
            z = true;
        }
        if (z) {
            com.tencent.mm.plugin.story.h.e eVar = com.tencent.mm.plugin.story.h.e.Fuh;
            com.tencent.mm.plugin.story.h.e.fpX();
        } else {
            com.tencent.mm.plugin.story.h.e eVar2 = com.tencent.mm.plugin.story.h.e.Fuh;
            com.tencent.mm.plugin.story.h.e.fpY();
        }
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "network()");
        com.tencent.mm.ak.t azz = aAg2.azz();
        String str2 = edg2.clientId;
        p.g(str2, "commentOp.clientId");
        azz.b(new com.tencent.mm.plugin.story.f.a.c(str2, a2, edg2.sessionId, Foh));
        AppMethodBeat.o(118873);
    }

    public static /* synthetic */ a a(b bVar, long j2, String str, String str2, boolean z, String str3, String str4, int i2, int i3, int i4) {
        AppMethodBeat.i(222909);
        a a2 = bVar.a(j2, str, str2, z, str3, str4, (i4 & 128) != 0 ? 0 : i2, (i4 & 256) != 0 ? 0 : i3);
        AppMethodBeat.o(222909);
        return a2;
    }

    private final a a(long j2, String str, String str2, boolean z, String str3, String str4, int i2, int i3) {
        AppMethodBeat.i(118874);
        StringBuilder sb = new StringBuilder();
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        String sb2 = sb.append(j.b.fau()).append(Util.currentTicks()).toString();
        Charset charset = kotlin.n.d.UTF_8;
        if (sb2 == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(118874);
            throw tVar;
        }
        byte[] bytes = sb2.getBytes(charset);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String messageDigest = com.tencent.xweb.util.d.getMessageDigest(bytes);
        edg edg = new edg();
        edg.clientId = messageDigest;
        edg.edx = j2;
        edg.content = str2;
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        edg.dRL = j.b.fau();
        edg.toUser = str;
        edg.iXu = cl.aWB();
        edg.state = 1;
        edg.NdF = 0;
        edg.NdG = z ? 1 : 0;
        edg.sessionId = str3;
        edg.Foa = str4;
        edg.Fob = i2;
        edg.ECO = i3;
        Fof.Ndz.add(edg);
        Foh = new a(edg);
        fbQ();
        j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new g(edg));
        a aVar = Foh;
        if (aVar == null) {
            p.hyc();
        }
        AppMethodBeat.o(118874);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ edg Fot;

        g(edg edg) {
            this.Fot = edg;
        }

        public final void run() {
            AppMethodBeat.i(118857);
            b bVar = b.Fom;
            b.a(b.b(this.Fot));
            AppMethodBeat.o(118857);
        }
    }

    private static edf a(edg edg) {
        AppMethodBeat.i(118876);
        edf edf = new edf();
        edf.Id = edg.edx;
        edf.MYT = edg.FnS;
        edf.xNH = edg.dRL;
        edf.xNG = edg.toUser;
        edf.iAc = edg.content;
        edf.CreateTime = edg.iXu;
        edf.NdD = edg.NdF;
        edf.NdE = edg.NdG;
        edf.MYS = edg.Fob;
        edf.MYX = edg.ECO;
        AppMethodBeat.o(118876);
        return edf;
    }

    private static void a(eea eea) {
        int i2;
        AppMethodBeat.i(118877);
        if (eea != null) {
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(eea.Id);
            if (KA == null) {
                KA = new com.tencent.mm.plugin.story.i.j();
            }
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            if (Util.isEqual(j.b.fau(), KA.field_userName)) {
                KA.vX(true);
            }
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            if (Util.isEqual(j.b.fau(), eea.UserName)) {
                a.C1768a aVar = com.tencent.mm.plugin.story.i.a.FvD;
                i2 = com.tencent.mm.plugin.story.i.a.FuJ;
            } else {
                a.C1768a aVar2 = com.tencent.mm.plugin.story.i.a.FvD;
                i2 = com.tencent.mm.plugin.story.i.a.FuK;
            }
            n.a aVar3 = n.FmM;
            n.a.a(KA, eea, i2);
            AppMethodBeat.o(118877);
            return;
        }
        AppMethodBeat.o(118877);
    }

    public static void k(long j2, int i2, String str) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(118879);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(j2);
        if (KA == null) {
            AppMethodBeat.o(118879);
            return;
        }
        eea eea = new eea();
        try {
            eea.parseFrom(KA.field_attrBuf);
        } catch (Exception e2) {
        }
        if (i2 != 0) {
            LinkedList<edf> linkedList = eea.Nen;
            p.g(linkedList, "storyObj.CommentList");
            Iterator<edf> it = linkedList.iterator();
            i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().MYT == i2) {
                    break;
                }
                i3++;
            }
        } else {
            LinkedList<edf> linkedList2 = eea.Nen;
            p.g(linkedList2, "storyObj.CommentList");
            Iterator<edf> it2 = linkedList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                } else if (Util.isEqual(it2.next().iAc, str)) {
                    break;
                } else {
                    i4++;
                }
            }
            i3 = i4;
        }
        if (i3 != -1) {
            eea.Nen.remove(i3);
            eea.CommentCount = eea.Nen.size();
            try {
                KA.field_attrBuf = eea.toByteArray();
            } catch (Exception e3) {
            }
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().e(KA);
        }
        AppMethodBeat.o(118879);
    }

    public static void Kl(long j2) {
        edf edf;
        edf edf2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        T t;
        boolean z;
        edf edf3;
        edf edf4;
        boolean z2;
        edf edf5;
        boolean z3;
        boolean z4;
        String str2;
        AppMethodBeat.i(118880);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(j2);
        z.f fVar = new z.f();
        j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
        T t2 = (T) j.b.fof().Kw(j2);
        if (t2 == null) {
            AppMethodBeat.o(118880);
            return;
        }
        fVar.SYG = t2;
        if (KA == null) {
            Log.i(TAG, "updateLastCommentSync will reset to 0 0");
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime = 0;
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentId = 0;
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_syncCommentTime = 0;
            ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_syncCommentId = 0;
            fVar.SYG.aSr("");
        } else {
            eea eea = new eea();
            try {
                eea.parseFrom(KA.field_attrBuf);
            } catch (Exception e2) {
            }
            LinkedList<edf> linkedList = eea.Nen;
            p.g(linkedList, "storyObj.CommentList");
            LinkedList<edf> linkedList2 = linkedList;
            ListIterator<edf> listIterator = linkedList2.listIterator(linkedList2.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    edf = null;
                    break;
                }
                edf previous = listIterator.previous();
                edf edf6 = previous;
                if (edf6.MYT == 0 || edf6.CreateTime > ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime) {
                    z4 = false;
                    continue;
                } else {
                    z4 = true;
                    continue;
                }
                if (z4) {
                    edf = previous;
                    break;
                }
            }
            edf edf7 = edf;
            if (edf7 == null) {
                if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                    LinkedList<edf> linkedList3 = eea.Net;
                    p.g(linkedList3, "storyObj.VisitorList");
                    LinkedList<edf> linkedList4 = linkedList3;
                    ListIterator<edf> listIterator2 = linkedList4.listIterator(linkedList4.size());
                    while (true) {
                        if (!listIterator2.hasPrevious()) {
                            edf5 = null;
                            break;
                        }
                        edf previous2 = listIterator2.previous();
                        edf edf8 = previous2;
                        if (edf8.MYT == 0 || edf8.CreateTime > ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime) {
                            z3 = false;
                            continue;
                        } else {
                            z3 = true;
                            continue;
                        }
                        if (z3) {
                            edf5 = previous2;
                            break;
                        }
                    }
                    edf4 = edf5;
                } else {
                    LinkedList<edf> linkedList5 = eea.Nep;
                    p.g(linkedList5, "storyObj.BubbleList");
                    LinkedList<edf> linkedList6 = linkedList5;
                    ListIterator<edf> listIterator3 = linkedList6.listIterator(linkedList6.size());
                    while (true) {
                        if (!listIterator3.hasPrevious()) {
                            edf3 = null;
                            break;
                        }
                        edf previous3 = listIterator3.previous();
                        edf edf9 = previous3;
                        if (edf9.MYT == 0 || edf9.CreateTime > ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            edf3 = previous3;
                            break;
                        }
                    }
                    edf4 = edf3;
                }
                edf2 = edf4;
            } else {
                edf2 = edf7;
            }
            Log.i(TAG, "updateLastCommentSync will reset to " + (edf2 != null ? Integer.valueOf(edf2.CreateTime) : null) + ' ' + (edf2 != null ? Integer.valueOf(edf2.MYT) : null));
            T t3 = fVar.SYG;
            if (edf2 != null) {
                i2 = edf2.CreateTime;
            } else {
                i2 = 0;
            }
            ((com.tencent.mm.plugin.story.i.c) t3).field_readCommentTime = i2;
            T t4 = fVar.SYG;
            if (edf2 != null) {
                i3 = edf2.MYT;
            } else {
                i3 = 0;
            }
            ((com.tencent.mm.plugin.story.i.c) t4).field_readCommentId = i3;
            T t5 = fVar.SYG;
            if (edf2 != null) {
                i4 = edf2.CreateTime;
            } else {
                i4 = 0;
            }
            ((com.tencent.mm.plugin.story.i.c) t5).field_syncCommentTime = i4;
            T t6 = fVar.SYG;
            if (edf2 != null) {
                i5 = edf2.MYT;
            } else {
                i5 = 0;
            }
            ((com.tencent.mm.plugin.story.i.c) t6).field_syncCommentId = i5;
            T t7 = fVar.SYG;
            if (edf2 == null || (str = edf2.xNH) == null) {
                str = "";
            }
            t7.aSr(str);
            LinkedList<edf> linkedList7 = eea.Nen;
            p.g(linkedList7, "storyObj.CommentList");
            Iterator<T> it = linkedList7.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                T t8 = next;
                if (t8.MYT == 0 || t8.CreateTime <= ((com.tencent.mm.plugin.story.i.c) fVar.SYG).field_readCommentTime) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            if (t == null) {
                KA.vX(false);
                n.a aVar = n.FmM;
                n.a.aa(KA.field_storyID, KA.field_localFlag);
            }
        }
        T t9 = fVar.SYG;
        if (KA == null || (str2 = KA.field_userName) == null) {
            str2 = "";
        }
        t9.aSd(str2);
        j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.fof().replace(fVar.SYG);
        com.tencent.mm.ac.d.h(new k(fVar));
        AppMethodBeat.o(118880);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        long j2;
        long j3;
        int i4 = 0;
        AppMethodBeat.i(118881);
        p.h(qVar, "scene");
        int type = qVar.getType();
        Log.i(TAG, "onSceneEnd " + i2 + ", " + i3 + ", " + str + ", " + type);
        if (type == 354) {
            com.tencent.mm.bw.a aYK = ((com.tencent.mm.plugin.story.f.a.c) qVar).rr.aYK();
            if (aYK == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryCommentResponse");
                AppMethodBeat.o(118881);
                throw tVar;
            }
            edi edi = (edi) aYK;
            a aVar = ((com.tencent.mm.plugin.story.f.a.c) qVar).FnB;
            if (i2 == 0 && i3 == 0) {
                String str2 = TAG;
                StringBuilder sb = new StringBuilder("post comment success ");
                edg edg = Fog;
                Log.i(str2, sb.append(edg != null ? edg.content : null).append(' ').append(edi.MYT).toString());
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new d(edi));
                if (aVar != null) {
                    aVar.FnS = edi.MYT;
                }
                for (T t : Fol) {
                    t.invoke(Boolean.TRUE, Long.valueOf(aVar != null ? aVar.edx : 0));
                }
                edg edg2 = Fog;
                if (edg2 != null) {
                    edg2.FnS = edi.MYT;
                }
                edg edg3 = Fog;
                if (edg3 != null) {
                    edg3.state = 2;
                }
                Fog = null;
                j3 = 100;
            } else {
                String str3 = TAG;
                StringBuilder sb2 = new StringBuilder("post comment fail ");
                edg edg4 = Fog;
                Log.i(str3, sb2.append(edg4 != null ? edg4.content : null).toString());
                edg edg5 = Fog;
                if (edg5 != null) {
                    i4 = edg5.retryCount;
                }
                if (i2 == 4) {
                    edg edg6 = Fog;
                    if (edg6 != null) {
                        edg6.retryCount = wSn;
                    }
                } else {
                    edg edg7 = Fog;
                    if (edg7 != null) {
                        edg7.retryCount = i4 + 1;
                    }
                }
                Fog = null;
                for (T t2 : Fol) {
                    t2.invoke(Boolean.FALSE, Long.valueOf(aVar != null ? aVar.edx : 0));
                }
                j3 = 300000;
            }
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.eJP().postDelayed(e.For, j3);
            AppMethodBeat.o(118881);
            return;
        }
        if (type == 764 && (((com.tencent.mm.plugin.story.f.a.f) qVar).foQ() instanceof com.tencent.mm.plugin.story.f.a.j)) {
            if (i2 == 0 && i3 == 0) {
                String str4 = TAG;
                StringBuilder sb3 = new StringBuilder("delete comment success ");
                edg edg8 = Fog;
                Log.i(str4, sb3.append(edg8 != null ? edg8.content : null).toString());
                edg edg9 = Fog;
                if (edg9 != null) {
                    edg9.state = 4;
                }
                Fog = null;
                j2 = 100;
            } else {
                String str5 = TAG;
                StringBuilder sb4 = new StringBuilder("delete comment fail ");
                edg edg10 = Fog;
                Log.i(str5, sb4.append(edg10 != null ? edg10.content : null).toString());
                edg edg11 = Fog;
                int i5 = edg11 != null ? edg11.retryCount : 0;
                if (i2 == 4) {
                    edg edg12 = Fog;
                    if (edg12 != null) {
                        edg12.retryCount = wSn;
                    }
                } else {
                    edg edg13 = Fog;
                    if (edg13 != null) {
                        edg13.retryCount = i5 + 1;
                    }
                }
                Fog = null;
                j2 = 60000;
            }
            j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.eJP().postDelayed(f.Fos, j2);
        }
        AppMethodBeat.o(118881);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ edi Foq;

        d(edi edi) {
            this.Foq = edi;
        }

        public final void run() {
            AppMethodBeat.i(118852);
            b bVar = b.Fom;
            b.b(this.Foq.NdL);
            AppMethodBeat.o(118852);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        public static final e For = new e();

        static {
            AppMethodBeat.i(118854);
            AppMethodBeat.o(118854);
        }

        e() {
        }

        public final void run() {
            AppMethodBeat.i(118853);
            b.a(b.Fom);
            AppMethodBeat.o(118853);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        public static final f Fos = new f();

        static {
            AppMethodBeat.i(118856);
            AppMethodBeat.o(118856);
        }

        f() {
        }

        public final void run() {
            AppMethodBeat.i(118855);
            b.a(b.Fom);
            AppMethodBeat.o(118855);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f Fon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z.f fVar) {
            super(0);
            this.Fon = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118849);
            b bVar = b.Fom;
            for (r rVar : b.Foj) {
                rVar.invoke(Long.valueOf(((com.tencent.mm.plugin.story.i.c) this.Fon.SYG).field_storyId), Boolean.TRUE, this.Fon.SYG.dRL, this.Fon.SYG.Foa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118849);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.f.b.b$b  reason: collision with other inner class name */
    public static final class C1751b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f Fon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1751b(z.f fVar) {
            super(0);
            this.Fon = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118850);
            b bVar = b.Fom;
            for (r rVar : b.Foj) {
                rVar.invoke(Long.valueOf(((com.tencent.mm.plugin.story.i.c) this.Fon.SYG).field_storyId), Boolean.TRUE, this.Fon.SYG.dRL, this.Fon.SYG.Foa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118850);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f Fon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(z.f fVar) {
            super(0);
            this.Fon = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118859);
            b bVar = b.Fom;
            for (r rVar : b.Foj) {
                rVar.invoke(Long.valueOf(((com.tencent.mm.plugin.story.i.c) this.Fon.SYG).field_storyId), Boolean.FALSE, this.Fon.SYG.dRL, this.Fon.SYG.Foa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118859);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/model/comment/StoryCommentLogic$setAllCommentRead$1$1"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f Fou;
        final /* synthetic */ com.tencent.mm.plugin.story.i.j Fov;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(z.f fVar, com.tencent.mm.plugin.story.i.j jVar) {
            super(0);
            this.Fou = fVar;
            this.Fov = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118858);
            b bVar = b.Fom;
            for (r rVar : b.Foj) {
                rVar.invoke(Long.valueOf(((com.tencent.mm.plugin.story.i.c) this.Fou.SYG).field_storyId), Boolean.FALSE, this.Fou.SYG.dRL, this.Fou.SYG.Foa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118858);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean Fow;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(boolean z) {
            super(0);
            this.Fow = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118860);
            b bVar = b.Fom;
            Iterator it = b.Fok.iterator();
            while (it.hasNext()) {
                it.next();
            }
            com.tencent.mm.y.c.axV().A(352279, this.Fow);
            x xVar = x.SXb;
            AppMethodBeat.o(118860);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ z.f Fon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(z.f fVar) {
            super(0);
            this.Fon = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(118861);
            b bVar = b.Fom;
            for (r rVar : b.Foj) {
                rVar.invoke(Long.valueOf(((com.tencent.mm.plugin.story.i.c) this.Fon.SYG).field_storyId), Boolean.TRUE, this.Fon.SYG.dRL, this.Fon.SYG.Foa);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(118861);
            return xVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.tencent.mm.protocal.protobuf.eeg r12) {
        /*
        // Method dump skipped, instructions count: 446
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.f.b.b.a(com.tencent.mm.protocal.protobuf.eeg):void");
    }

    public static final /* synthetic */ void a(edf edf) {
        boolean z;
        T t;
        boolean z2;
        T t2;
        boolean z3;
        AppMethodBeat.i(118884);
        long j2 = edf.Id;
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(j2);
        if (KA == null) {
            AppMethodBeat.o(118884);
            return;
        }
        eea eea = new eea();
        try {
            eea.parseFrom(KA.field_attrBuf);
        } catch (Exception e2) {
        }
        if (Util.isNullOrNil(edf.iAc)) {
            if (edf.MYT != 0) {
                LinkedList<edf> linkedList = eea.Nep;
                p.g(linkedList, "storyObj.BubbleList");
                Iterator<T> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next = it.next();
                    if (next.MYT == edf.MYT) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        t2 = next;
                        break;
                    }
                }
                if (t2 == null) {
                    eea.Nep.add(edf);
                    z = true;
                }
                z = false;
            } else {
                eea.Nep.add(edf);
                z = true;
            }
        } else if (edf.MYT != 0) {
            LinkedList<edf> linkedList2 = eea.Nen;
            p.g(linkedList2, "storyObj.CommentList");
            Iterator<T> it2 = linkedList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                T next2 = it2.next();
                if (next2.MYT == edf.MYT) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    t = next2;
                    break;
                }
            }
            if (t == null) {
                eea.Nen.add(edf);
                z = true;
            }
            z = false;
        } else {
            eea.Nen.add(edf);
            z = true;
        }
        if (z) {
            eea.CommentCount = eea.Nen.size();
            eea.Neo = eea.Nep.size();
            try {
                KA.field_attrBuf = eea.toByteArray();
            } catch (Exception e3) {
            }
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().e(KA);
            String str = KA.field_userName;
            if (str != null) {
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                com.tencent.mm.plugin.story.i.f aRS = j.b.fod().aRS(str);
                aRS.field_interactTime = cl.aWy();
                j.b bVar4 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.fod().b(aRS);
                AppMethodBeat.o(118884);
                return;
            }
        }
        AppMethodBeat.o(118884);
    }
}
