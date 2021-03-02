package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.f.a.k;
import com.tencent.mm.plugin.story.f.a.m;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.plugin.story.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\fH\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\bH\u0002J \u0010.\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\bH\u0016J,\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0018\u00107\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0016J\"\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u001dH\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\bH\u0002J\b\u0010>\u001a\u00020\u001eH\u0016J\b\u0010?\u001a\u00020\u001eH\u0016J*\u0010@\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J \u0010D\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010E\u001a\u00020\bH\u0016J\b\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J\b\u0010I\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0018\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R,\u0010\u001b\u001a \u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001cX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", ch.COL_USERNAME, "", "galleryCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "forSns", "", "justNew", "(Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;ZZ)V", "deleteItemIndex", "", "firstNotify", "getForSns", "()Z", "getGalleryCallback", "()Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryState", "getJustNew", "lastVisitorEnable", "privateItemIndex", "selectedIndex", "storyCommentChangeListener", "Lkotlin/Function4;", "", "", "getUsername", "()Ljava/lang/String;", "cancelDeleteItem", "row", "column", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onItemRemovedCallback", "isOk", "onMsgListState", FirebaseAnalytics.b.INDEX, "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "onSetFavoriteCallback", "favorite", "success", "storyId", "onSetPrivacyCallback", "isPrivacy", "pause", "resume", "setFavorite", "nowFavorite", "replaceInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateCommentRead", "Companion", "plugin-story_release"})
public final class h extends f implements com.tencent.mm.ak.i {
    private static boolean FrR = true;
    public static final a Fsp = new a((byte) 0);
    private static final String TAG = TAG;
    private final r<Long, Boolean, String, String, x> FpA;
    private int Frg;
    private final ArrayList<com.tencent.mm.plugin.story.f.d.h> Fsh;
    private int Fsi;
    private int Fsj;
    private boolean Fsk;
    private boolean Fsl;
    final c Fsm;
    private final boolean Fsn;
    private final boolean Fso;
    private int bxP;
    private final String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class j extends q implements r<Long, Boolean, String, String, x> {
        final /* synthetic */ h Fsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(h hVar) {
            super(4);
            this.Fsq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Boolean bool, String str, String str2) {
            final int i2;
            AppMethodBeat.i(119262);
            long longValue = l.longValue();
            final boolean booleanValue = bool.booleanValue();
            String str3 = str2;
            p.h(str, "fromUser");
            p.h(str3, "storyOwner");
            if (booleanValue) {
                a aVar = h.Fsp;
                h.FrR = true;
            }
            Iterator it = this.Fsq.Fsh.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((com.tencent.mm.plugin.story.f.d.h) it.next()).FoU.edx == longValue) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            int size = this.Fsq.Fsh.size();
            if (i2 >= 0 && size > i2) {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                if (Util.isEqual(str3, j.b.fau())) {
                    p.g(this.Fsq.Fsh.get(i2), "galleryItems[index]");
                    j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
                    final com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(longValue);
                    if (KA != null) {
                        h.a aVar2 = com.tencent.mm.plugin.story.f.d.h.FoY;
                        final com.tencent.mm.plugin.story.f.d.h b2 = h.a.b(KA);
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.h.j.AnonymousClass1 */
                            final /* synthetic */ j Fsv;

                            {
                                this.Fsv = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119261);
                                if (booleanValue && !KA.frL()) {
                                    this.Fsv.Fsq.Fsh.set(i2, b2);
                                    this.Fsv.Fsq.Fsm.u(0, this.Fsv.Fsq.Fsh);
                                    this.Fsv.Fsq.Fsm.aA(0, i2, 1);
                                    this.Fsv.Fsq.Fsm.fpA();
                                    h.g(this.Fsv.Fsq);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(119261);
                                return xVar;
                            }
                        });
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119262);
            return xVar;
        }
    }

    public /* synthetic */ h(String str, c cVar, byte b2) {
        this(str, cVar);
    }

    public static final /* synthetic */ void g(h hVar) {
        AppMethodBeat.i(119283);
        hVar.fpG();
        AppMethodBeat.o(119283);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$Companion;", "", "()V", "TAG", "", "needLoadRemote", "", "getNeedLoadRemote", "()Z", "setNeedLoadRemote", "(Z)V", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private h(String str, c cVar) {
        p.h(str, ch.COL_USERNAME);
        p.h(cVar, "galleryCallback");
        AppMethodBeat.i(119281);
        this.username = str;
        this.Fsm = cVar;
        this.Fsn = false;
        this.Fso = false;
        this.Fsh = new ArrayList<>();
        this.Fsi = -1;
        this.Fsj = -1;
        this.bxP = -1;
        this.Fsk = true;
        this.FpA = new j(this);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().a(273, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().a(764, this);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.f(this.FpA);
        this.Fsm.aaL(1);
        this.Fsl = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
        AppMethodBeat.o(119281);
    }

    static {
        AppMethodBeat.i(119282);
        AppMethodBeat.o(119282);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaP(int i2) {
    }

    private final void vP(boolean z) {
        AppMethodBeat.i(119263);
        com.tencent.mm.ac.d.h(new d(this, z));
        AppMethodBeat.o(119263);
    }

    private final void a(boolean z, boolean z2, long j2) {
        AppMethodBeat.i(119264);
        com.tencent.mm.ac.d.h(new e(this, j2, z, z2));
        AppMethodBeat.o(119264);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaK(int i2) {
        AppMethodBeat.i(119265);
        this.Frg = i2;
        if (i2 == 0) {
            cJk();
            AppMethodBeat.o(119265);
            return;
        }
        boolean fng = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
        fpw();
        if (fng) {
            com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
            com.tencent.mm.plugin.story.f.b.b.at(false, false);
        }
        if (this.Fsl != fng) {
            this.Fsl = fng;
            this.Fsm.u(0, this.Fsh);
            this.Fsm.aaN(0);
        }
        AppMethodBeat.o(119265);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void B(int i2, int i3, boolean z) {
        AppMethodBeat.i(119266);
        if (i2 == 3) {
            if (!z) {
                fpx();
            } else if (i3 == 0) {
                j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new i(this));
                AppMethodBeat.o(119266);
                return;
            } else {
                if (i3 == 1) {
                    fpx();
                }
                AppMethodBeat.o(119266);
                return;
            }
        }
        AppMethodBeat.o(119266);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpz() {
        ArrayList cu;
        AppMethodBeat.i(119267);
        Log.i(TAG, "LogStory: initLoad");
        com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsh, 0);
        if (this.Fso) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (T t : f.a.cu(this.username, this.Fsn)) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                if (i2 == 0) {
                    arrayList.add(t);
                }
                i2 = i3;
            }
            cu = arrayList;
        } else {
            cu = f.a.cu(this.username, this.Fsn);
        }
        Log.i(TAG, "LogStory: preload Db count " + cu.size());
        com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(cu, 0);
        if (hVar == null || hVar2 == null || hVar.edx == hVar2.edx) {
            c.b u = f.a.u(this.Fsh, cu);
            this.Fsm.u(0, this.Fsh);
            this.Fsm.fpA();
            u.a(new c(this, cu));
        } else {
            this.Fsh.clear();
            this.Fsh.addAll(cu);
            this.Fsm.u(0, this.Fsh);
            this.Fsm.aaN(0);
            this.Fsm.fpA();
        }
        if (com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
            if (this.Fsk) {
                this.Fsk = false;
            }
            cJk();
            AppMethodBeat.o(119267);
        }
        fpG();
        cJk();
        AppMethodBeat.o(119267);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/story/presenter/SelfGalleryPresenter$initLoad$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-story_release"})
    public static final class c implements android.support.v7.h.d {
        final /* synthetic */ h Fsq;
        final /* synthetic */ List Fsr;

        c(h hVar, List list) {
            this.Fsq = hVar;
            this.Fsr = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(119247);
            Log.i(h.TAG, "onChanged: " + i2 + ' ' + i3);
            this.Fsq.Fsh.clear();
            this.Fsq.Fsh.addAll(this.Fsr);
            this.Fsq.Fsm.u(0, this.Fsq.Fsh);
            this.Fsq.Fsm.fpA();
            this.Fsq.Fsm.aA(0, i2, i3);
            AppMethodBeat.o(119247);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(119248);
            Log.i(h.TAG, "onMoved: " + i2 + ' ' + i3);
            AppMethodBeat.o(119248);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(119249);
            Log.i(h.TAG, "onInserted: " + i2 + ' ' + i3);
            this.Fsq.Fsh.clear();
            this.Fsq.Fsh.addAll(this.Fsr);
            this.Fsq.Fsm.u(0, this.Fsq.Fsh);
            this.Fsq.Fsm.fpA();
            this.Fsq.Fsm.ay(0, i2, i3);
            AppMethodBeat.o(119249);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(119250);
            Log.i(h.TAG, "onRemoved: " + i2 + ' ' + i3);
            this.Fsq.Fsh.clear();
            this.Fsq.Fsh.addAll(this.Fsr);
            this.Fsq.Fsm.u(0, this.Fsq.Fsh);
            this.Fsq.Fsm.fpA();
            this.Fsq.Fsm.az(0, i2, i3);
            AppMethodBeat.o(119250);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void cJk() {
        AppMethodBeat.i(119268);
        if (FrR && this.Frg == 0) {
            FrR = false;
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).loadStory(j.b.fau(), null);
        }
        AppMethodBeat.o(119268);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void je(int i2, int i3) {
        AppMethodBeat.i(119269);
        Log.i(TAG, "LogStory: deleteItem ".concat(String.valueOf(i3)));
        if (i3 >= 0 && i3 < this.Fsh.size()) {
            this.Fsi = i3;
            com.tencent.mm.plugin.story.f.d.h hVar = this.Fsh.get(i3);
            p.g(hVar, "galleryItems[column]");
            com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
            Log.i(TAG, "LogStory: deleteItem1 storyinfo " + hVar2 + " deleteItemIndex " + this.Fsi + " localid " + hVar2.FoT.ecf);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba(hVar2.FoT.ecf);
            j.b bVar2 = com.tencent.mm.plugin.story.f.j.Fmy;
            j.b.foc().aSz(new StringBuilder().append(hVar2.FoT.ecf).append('_').append(hVar2.FoT.iXu).toString());
            if (aba != null) {
                Log.i(TAG, "LogStory: deleteItem2 storyinfo " + hVar2 + " deleteItemIndex " + this.Fsi + " localid " + hVar2.FoT.ecf + ' ' + aba.field_storyID);
                if (aba.field_storyID == 0) {
                    n.a aVar = n.FmM;
                    n.a.aaH(hVar2.FoT.ecf);
                    vP(true);
                } else if (this.Fsi != -1) {
                    n.a aVar2 = n.FmM;
                    n.a.Z(aba.field_storyID, hVar2.FoT.ecf);
                }
            }
            if (hVar2.FoT.foV()) {
                j.b bVar3 = com.tencent.mm.plugin.story.f.j.Fmy;
                j.b.eJP().post(new b(hVar2));
            }
        }
        AppMethodBeat.o(119269);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.story.f.d.h Frn;

        b(com.tencent.mm.plugin.story.f.d.h hVar) {
            this.Frn = hVar;
        }

        public final void run() {
            AppMethodBeat.i(119246);
            Log.i(h.TAG, "LogStory: deleteItem fake " + this.Frn);
            n.a aVar = n.FmM;
            n.a.aaH(this.Frn.FoT.ecf);
            com.tencent.mm.plugin.story.f.e.a aVar2 = com.tencent.mm.plugin.story.f.e.a.Fpl;
            com.tencent.mm.plugin.story.f.e.a.aLh(this.Frn.FoT.taskId);
            com.tencent.mm.plugin.story.f.e.a aVar3 = com.tencent.mm.plugin.story.f.e.a.Fpl;
            com.tencent.mm.plugin.story.f.e.a.aLi(this.Frn.FoT.taskId);
            AppMethodBeat.o(119246);
        }
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpy() {
        AppMethodBeat.i(119270);
        this.Fsi = -1;
        n.a aVar = n.FmM;
        n.a.fov();
        AppMethodBeat.o(119270);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void jf(int i2, int i3) {
        AppMethodBeat.i(119271);
        this.bxP = i3;
        if (this.Frg == 1) {
            fpw();
        }
        AppMethodBeat.o(119271);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void C(int i2, int i3, boolean z) {
        long j2;
        AppMethodBeat.i(119272);
        Log.i(TAG, "LogStory: setPrivacy ".concat(String.valueOf(i3)));
        if (i3 >= 0 && i3 < this.Fsh.size()) {
            this.Fsj = i3;
            boolean z2 = !z;
            com.tencent.mm.plugin.story.f.d.h hVar = this.Fsh.get(i3);
            p.g(hVar, "galleryItems[column]");
            com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
            Log.i(TAG, "LogStory: setPrivacy storyinfo " + hVar2 + " setPrivacyItemIndex " + this.Fsj + " localid " + hVar2.FoT.ecf + " targetPrivacy:" + z2);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) hVar2.FoV.systemRowid);
            if (aba != null) {
                com.tencent.mm.plugin.story.h.e eVar = com.tencent.mm.plugin.story.h.e.Fuh;
                com.tencent.mm.plugin.story.h.e.vT(z2);
                if (z2) {
                    j2 = 3;
                } else {
                    j2 = 4;
                }
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 1L, 0L, 24);
                n.a aVar = n.FmM;
                n.a.c(aba.field_storyID, (int) aba.systemRowid, z2, false);
                AppMethodBeat.o(119272);
                return;
            }
        }
        AppMethodBeat.o(119272);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void D(int i2, int i3, boolean z) {
        boolean z2;
        long j2;
        AppMethodBeat.i(119273);
        Log.i(TAG, "LogStory: setFavorite ".concat(String.valueOf(i3)));
        if (i3 >= 0 && i3 < this.Fsh.size()) {
            if (!z) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.plugin.story.f.d.h hVar = this.Fsh.get(i3);
            p.g(hVar, "galleryItems[column]");
            com.tencent.mm.plugin.story.f.d.h hVar2 = hVar;
            Log.i(TAG, "LogStory: setFavorite storyinfo " + hVar2 + " localid " + hVar2.FoT.ecf + " targetFavorite:" + z2);
            j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
            com.tencent.mm.plugin.story.i.j aba = j.b.foc().aba((int) hVar2.FoV.systemRowid);
            if (aba != null) {
                com.tencent.mm.plugin.story.h.e eVar = com.tencent.mm.plugin.story.h.e.Fuh;
                com.tencent.mm.plugin.story.h.e.vS(z2);
                if (z2) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                com.tencent.mm.plugin.story.h.h hVar3 = com.tencent.mm.plugin.story.h.h.FuH;
                com.tencent.mm.plugin.story.h.h.a(j2, String.valueOf(aba.field_storyID), 1L, 0L, 24);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(Long.valueOf(aba.field_storyID));
                arrayList2.add(Integer.valueOf((int) aba.systemRowid));
                n.a aVar = n.FmM;
                n.a.b(arrayList, arrayList2, z2);
                AppMethodBeat.o(119273);
                return;
            }
        }
        AppMethodBeat.o(119273);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ h Fsq;

        i(h hVar) {
            this.Fsq = hVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            Boolean bool = null;
            AppMethodBeat.i(119260);
            com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsq.Fsh, this.Fsq.bxP);
            if (hVar != null) {
                gVar = hVar.FoU;
            } else {
                gVar = null;
            }
            String str = h.TAG;
            StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsq.bxP).append(", ");
            if (gVar != null) {
                bool = Boolean.valueOf(gVar.FoN);
            }
            Log.i(str, append.append(bool).toString());
            if (gVar != null && gVar.FoS.size() > 0) {
                com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                long j2 = gVar.edx;
                com.tencent.mm.plugin.story.f.b.a last = gVar.FoS.getLast();
                p.g(last, "comment.visitorList.last");
                com.tencent.mm.plugin.story.f.b.b.b(j2, last);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.story.g.h.i.AnonymousClass1 */
                    final /* synthetic */ i Fsu;

                    {
                        this.Fsu = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(119259);
                        gVar.FoN = false;
                        Iterator<T> it = gVar.FoS.iterator();
                        while (it.hasNext()) {
                            it.next().FnW = false;
                        }
                        this.Fsu.Fsq.Fsm.fpA();
                        x xVar = x.SXb;
                        AppMethodBeat.o(119259);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(119260);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.g.h$h  reason: collision with other inner class name */
    public static final class RunnableC1765h implements Runnable {
        final /* synthetic */ h Fsq;

        RunnableC1765h(h hVar) {
            this.Fsq = hVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            com.tencent.mm.plugin.story.i.j jVar;
            Boolean bool = null;
            AppMethodBeat.i(119258);
            com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsq.Fsh, this.Fsq.bxP);
            if (hVar != null) {
                gVar = hVar.FoU;
            } else {
                gVar = null;
            }
            com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsq.Fsh, this.Fsq.bxP);
            if (hVar2 != null) {
                jVar = hVar2.FoV;
            } else {
                jVar = null;
            }
            String str = h.TAG;
            StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsq.bxP).append(", ");
            if (gVar != null) {
                bool = Boolean.valueOf(gVar.FnW);
            }
            Log.i(str, append.append(bool).toString());
            if (!com.tencent.mm.plugin.story.c.a.e.Fln.fng()) {
                if (jVar != null && jVar.frF()) {
                    jVar.vX(false);
                    n.a aVar = n.FmM;
                    n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                }
                if (gVar != null && gVar.commentList.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.commentList.getLast();
                    p.g(last, "comment.commentList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.h.RunnableC1765h.AnonymousClass2 */
                            final /* synthetic */ RunnableC1765h Fst;

                            {
                                this.Fst = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119257);
                                gVar.FoN = false;
                                gVar.FoO = false;
                                gVar.FnW = false;
                                Iterator<T> it = gVar.commentList.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                Iterator<T> it2 = gVar.FoQ.iterator();
                                while (it2.hasNext()) {
                                    it2.next().FnW = false;
                                }
                                Iterator<T> it3 = gVar.FoS.iterator();
                                while (it3.hasNext()) {
                                    it3.next().FnW = false;
                                }
                                h.g(this.Fst.Fsq);
                                this.Fst.Fsq.Fsm.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119257);
                                return xVar;
                            }
                        });
                    }
                }
            } else if (jVar != null && jVar.frF()) {
                jVar.vX(false);
                n.a aVar2 = n.FmM;
                n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.story.g.h.RunnableC1765h.AnonymousClass1 */
                    final /* synthetic */ RunnableC1765h Fst;

                    {
                        this.Fst = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(119256);
                        this.Fst.Fsq.Fsm.fpA();
                        x xVar = x.SXb;
                        AppMethodBeat.o(119256);
                        return xVar;
                    }
                });
                AppMethodBeat.o(119258);
                return;
            }
            AppMethodBeat.o(119258);
        }
    }

    private final void fpw() {
        AppMethodBeat.i(119274);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new RunnableC1765h(this));
        AppMethodBeat.o(119274);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ h Fsq;

        g(h hVar) {
            this.Fsq = hVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            Boolean bool = null;
            AppMethodBeat.i(119255);
            com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsq.Fsh, this.Fsq.bxP);
            if (hVar != null) {
                gVar = hVar.FoU;
            } else {
                gVar = null;
            }
            String str = h.TAG;
            StringBuilder append = new StringBuilder("setSelectedRead ").append(this.Fsq.bxP).append(", ");
            if (gVar != null) {
                bool = Boolean.valueOf(gVar.FoO);
            }
            Log.i(str, append.append(bool).toString());
            if (gVar != null && gVar.FoQ.size() > 0) {
                com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                long j2 = gVar.edx;
                com.tencent.mm.plugin.story.f.b.a last = gVar.FoQ.getLast();
                p.g(last, "comment.msgList.last");
                com.tencent.mm.plugin.story.f.b.b.b(j2, last);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.story.g.h.g.AnonymousClass1 */
                    final /* synthetic */ g Fss;

                    {
                        this.Fss = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(119254);
                        gVar.FoO = false;
                        Iterator<T> it = gVar.FoQ.iterator();
                        while (it.hasNext()) {
                            it.next().FnW = false;
                        }
                        this.Fss.Fsq.Fsm.fpA();
                        x xVar = x.SXb;
                        AppMethodBeat.o(119254);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(119255);
        }
    }

    private final void fpx() {
        AppMethodBeat.i(119275);
        j.b bVar = com.tencent.mm.plugin.story.f.j.Fmy;
        j.b.eJP().post(new g(this));
        AppMethodBeat.o(119275);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void fpG() {
        /*
        // Method dump skipped, instructions count: 135
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.h.fpG():void");
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void resume() {
        AppMethodBeat.i(119277);
        Log.i(TAG, "LogStory: resume");
        fpz();
        AppMethodBeat.o(119277);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void pause() {
        AppMethodBeat.i(119278);
        Log.i(TAG, "LogStory: pause");
        AppMethodBeat.o(119278);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void destroy() {
        AppMethodBeat.i(119279);
        Log.i(TAG, "LogStory: destroy");
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "MMKernel.network()");
        aAg.azz().b(273, this);
        com.tencent.mm.kernel.b aAg2 = com.tencent.mm.kernel.g.aAg();
        p.g(aAg2, "MMKernel.network()");
        aAg2.azz().b(764, this);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.g(this.FpA);
        AppMethodBeat.o(119279);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        com.tencent.mm.plugin.story.f.a.a foQ;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(119280);
        Log.i(TAG, "LogStory: " + i2 + ' ' + i3 + ' ' + str);
        if (!(qVar instanceof com.tencent.mm.plugin.story.f.a.i) || !Util.isEqual(((com.tencent.mm.plugin.story.f.a.i) qVar).userName, this.username)) {
            if ((qVar instanceof com.tencent.mm.plugin.story.f.a.f) && (foQ = ((com.tencent.mm.plugin.story.f.a.f) qVar).foQ()) != null) {
                if (foQ instanceof com.tencent.mm.plugin.story.f.a.l) {
                    if (i3 == 0) {
                        Iterator<T> it = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                        while (it.hasNext()) {
                            int intValue = it.next().intValue();
                            n.a aVar = n.FmM;
                            n.a.aaH(intValue);
                        }
                    }
                    vP(i3 == 0);
                    AppMethodBeat.o(119280);
                    return;
                }
                if (foQ instanceof m) {
                    Log.i(TAG, "onSceneEnd MMSTORY_OBJ_OP_VISIBILITY_TYPE errType:" + i2 + ", errcode:" + i3);
                    if (i3 == 0) {
                        Iterator<T> it2 = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                        while (it2.hasNext()) {
                            int intValue2 = it2.next().intValue();
                            n.a aVar2 = n.FmM;
                            n.a.jc(intValue2, ((m) foQ).FnU);
                        }
                        com.tencent.mm.ac.d.h(new f(this));
                        AppMethodBeat.o(119280);
                        return;
                    }
                } else if (foQ instanceof k) {
                    if (i3 == 0) {
                        Iterator<T> it3 = ((com.tencent.mm.plugin.story.f.a.f) qVar).FnH.iterator();
                        while (it3.hasNext()) {
                            int intValue3 = it3.next().intValue();
                            Log.i(TAG, "onSceneEnd update story favorite: errType " + i2 + ", errcode " + i3 + ", localId " + intValue3 + ", favorite:" + ((k) foQ).FnT);
                            n.a aVar3 = n.FmM;
                            n.a.jd(intValue3, ((k) foQ).FnT);
                        }
                        if (((k) foQ).FnT == 1) {
                            z = true;
                        }
                        a(z, true, foQ.edx);
                        AppMethodBeat.o(119280);
                        return;
                    }
                    a.C1768a aVar4 = com.tencent.mm.plugin.story.i.a.FvD;
                    if (i3 == com.tencent.mm.plugin.story.i.a.Fva) {
                        if (((k) foQ).FnT != 1) {
                            z2 = false;
                        }
                        a(z2, false, foQ.edx);
                    }
                }
                AppMethodBeat.o(119280);
                return;
            }
        } else if (i2 == 0 || i2 == 4) {
            int i4 = ((com.tencent.mm.plugin.story.f.a.i) qVar).source;
            a.C1768a aVar5 = com.tencent.mm.plugin.story.i.a.FvD;
            if (i4 == com.tencent.mm.plugin.story.i.a.Fvy) {
                FrR = false;
                fpz();
                AppMethodBeat.o(119280);
                return;
            }
        }
        AppMethodBeat.o(119280);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h Fsq;
        final /* synthetic */ boolean vSM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar, boolean z) {
            super(0);
            this.Fsq = hVar;
            this.vSM = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119251);
            if (this.vSM) {
                int size = this.Fsq.Fsh.size();
                int i2 = this.Fsq.Fsi;
                if (i2 >= 0 && size > i2) {
                    this.Fsq.Fsh.remove(this.Fsq.Fsi);
                    this.Fsq.Fsm.u(0, this.Fsq.Fsh);
                    this.Fsq.Fsm.az(0, this.Fsq.Fsi, 1);
                    this.Fsq.Fsm.fpA();
                }
            }
            this.Fsq.Fsm.vQ(this.vSM);
            this.Fsq.Fsi = -1;
            x xVar = x.SXb;
            AppMethodBeat.o(119251);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ h Fsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(h hVar) {
            super(0);
            this.Fsq = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119253);
            int size = this.Fsq.Fsh.size();
            int i2 = this.Fsq.Fsj;
            if (i2 >= 0 && size > i2) {
                this.Fsq.Fsh.remove(this.Fsq.Fsj);
                this.Fsq.Fsm.u(0, this.Fsq.Fsh);
                this.Fsq.Fsm.az(0, this.Fsq.Fsj, 1);
                this.Fsq.Fsm.fpA();
            }
            this.Fsq.Fsj = -1;
            x xVar = x.SXb;
            AppMethodBeat.o(119253);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ long Foo;
        final /* synthetic */ boolean Frr;
        final /* synthetic */ h Fsq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar, long j2, boolean z, boolean z2) {
            super(0);
            this.Fsq = hVar;
            this.Foo = j2;
            this.Frr = z;
            this.$success = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119252);
            com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(this.Fsq.Fsh, this.Fsq.bxP);
            if (hVar != null && hVar.edx == this.Foo) {
                this.Fsq.Fsm.au(this.Frr, this.$success);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119252);
            return xVar;
        }
    }
}
