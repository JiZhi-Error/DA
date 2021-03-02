package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.n;
import com.tencent.mm.plugin.story.g.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001EBU\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u000fH\u0016J\u0018\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020%H\u0016J\b\u0010/\u001a\u00020%H\u0002J(\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u001b2\u0016\u00102\u001a\u0012\u0012\u0004\u0012\u0002030\u000bj\b\u0012\u0004\u0012\u000203`\rH\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00105\u001a\u00020\u000fH\u0016J \u00106\u001a\u00020%2\u0006\u00105\u001a\u00020\u000f2\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020\u0013H\u0016J*\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010?\u001a\u00020%2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020%2\u0006\u00101\u001a\u00020\u001bH\u0002J\b\u0010A\u001a\u00020%H\u0002J\b\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020%H\u0002J\u0010\u0010D\u001a\u00020%2\u0006\u00101\u001a\u00020\u001bH\u0002R\u000e\u0010\u0011\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0019\u001a&\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b \u001c*\u0012\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R,\u0010#\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0\nX\u0004¢\u0006\u0002\n\u0000R2\u0010&\u001a&\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b \u001c*\u0012\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b\u0018\u00010\u00040\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "users", "", "", "chatRoom", "groupCallback", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "storyFilterList", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "queryCondition", "", "(Ljava/util/List;Ljava/lang/String;Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;Ljava/util/Map;I)V", "TAG", "allUnread", "", "enableVisitor", "expectPos", "galleryState", "isForSns", "isLoadNetScene", "loadingUserQueue", "", "Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "kotlin.jvm.PlatformType", "needFilter", "needLoadRemote", "preloadLocalCount", "preloadRemoteCount", "selectedCol", "selectedRow", "storyCommentChangeListener", "Lkotlin/Function4;", "", "userList", "checkLoadMore", "row", "deleteItem", "column", "destroy", "initExpectPosition", "initLoad", "loadMore", "loadNextQueuedUser", "notifyUser", "user", "items", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "onGalleryState", "state", "onMsgListState", FirebaseAnalytics.b.INDEX, "isSelf", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSelected", "preloadForUser", "setSelectedCommentRead", "setSelectedRead", "setSelectedVisitRead", "updateUserGalleryItemsFromDb", "UserData", "plugin-story_release"})
public final class g extends f implements com.tencent.mm.ak.i {
    private final int FkI;
    private final r<Long, Boolean, String, String, x> FpA;
    private final int FrM;
    private final int FrN;
    private final List<a> FrO;
    private boolean FrP;
    private int FrQ;
    private boolean FrR;
    private boolean FrS;
    private final boolean FrT;
    private final boolean FrU;
    private final c FrV;
    private final Map<String, ArrayList<Long>> FrW;
    private int Fre;
    private int Frf;
    private int Frg;
    private boolean Frh;
    private final String TAG;
    private final List<a> iPH;
    private final String jVv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "storyId", "", "isSync", "", "fromUser", "", "storyOwner", "invoke"})
    static final class i extends q implements r<Long, Boolean, String, String, x> {
        final /* synthetic */ g FrY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(g gVar) {
            super(4);
            this.FrY = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Long l, Boolean bool, String str, String str2) {
            final int i2;
            final int i3;
            AppMethodBeat.i(119229);
            long longValue = l.longValue();
            final boolean booleanValue = bool.booleanValue();
            String str3 = str2;
            p.h(str, "fromUser");
            p.h(str3, "storyOwner");
            if (booleanValue) {
                this.FrY.FrR = true;
            }
            List list = this.FrY.iPH;
            p.g(list, "userList");
            int i4 = 0;
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (Util.isEqual(((a) it.next()).username, str3)) {
                    i2 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (i2 != -1) {
                final ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = ((a) this.FrY.iPH.get(i2)).lj;
                int i5 = 0;
                Iterator<com.tencent.mm.plugin.story.f.d.h> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (it2.next().edx == longValue) {
                        i3 = i5;
                        break;
                    }
                    i5++;
                }
                if (i3 != -1) {
                    j.b bVar = j.Fmy;
                    com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(longValue);
                    if (KA != null) {
                        h.a aVar = com.tencent.mm.plugin.story.f.d.h.FoY;
                        final com.tencent.mm.plugin.story.f.d.h b2 = h.a.b(KA);
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.g.i.AnonymousClass1 */
                            final /* synthetic */ i Fsg;

                            {
                                this.Fsg = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119228);
                                if (booleanValue) {
                                    Log.i(this.Fsg.FrY.TAG, "commentChanged, will update row:" + i2 + " col:" + i3);
                                    arrayList.set(i3, b2);
                                    this.Fsg.FrY.FrV.u(i2, arrayList);
                                    this.Fsg.FrY.FrV.aA(i2, i3, 1);
                                    this.Fsg.FrY.FrV.fpA();
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(119228);
                                return xVar;
                            }
                        });
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(119229);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(g gVar, a aVar) {
        AppMethodBeat.i(119244);
        gVar.a(aVar);
        AppMethodBeat.o(119244);
    }

    public static final /* synthetic */ void b(g gVar) {
        AppMethodBeat.i(119245);
        gVar.fpF();
        AppMethodBeat.o(119245);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(List list, String str, c cVar) {
        this(list, str, cVar, new HashMap(), d.fpB());
        d dVar = d.FrG;
        AppMethodBeat.i(119243);
        AppMethodBeat.o(119243);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.ArrayList<java.lang.Long>> */
    /* JADX WARN: Multi-variable type inference failed */
    public g(List<String> list, String str, c cVar, Map<String, ? extends ArrayList<Long>> map, int i2) {
        p.h(list, "users");
        p.h(cVar, "groupCallback");
        p.h(map, "storyFilterList");
        AppMethodBeat.i(119242);
        this.jVv = str;
        this.FrV = cVar;
        this.FrW = map;
        this.FkI = i2;
        this.TAG = "MicroMsg.MultiUserGalleryPresenter";
        this.FrM = 3;
        this.FrN = 1;
        this.iPH = Collections.synchronizedList(new ArrayList());
        this.FrO = Collections.synchronizedList(new LinkedList());
        this.Fre = -1;
        this.Frf = -1;
        int i3 = this.FkI;
        d dVar = d.FrG;
        this.FrS = com.tencent.mm.ac.d.cW(i3, d.fpE());
        int i4 = this.FkI;
        d dVar2 = d.FrG;
        this.FrT = com.tencent.mm.ac.d.cW(i4, d.fpC());
        int i5 = this.FkI;
        d dVar3 = d.FrG;
        this.FrU = com.tencent.mm.ac.d.cW(i5, d.fpD());
        this.FpA = new i(this);
        Log.i(this.TAG, "TimeDiff: local: " + System.currentTimeMillis() + ", server: " + cl.aWy());
        Log.i(this.TAG, "chatRoom is " + this.jVv);
        for (T t : list) {
            Log.i(this.TAG, "LogStory: ".concat(String.valueOf(t)));
            this.iPH.add(new a(t, new ArrayList()));
        }
        this.FrV.aaL(this.iPH.size());
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().a(273, this);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.f(this.FpA);
        this.Frh = com.tencent.mm.plugin.story.c.a.e.Fln.fng();
        AppMethodBeat.o(119242);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaP(int i2) {
        this.FrQ = i2;
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void destroy() {
        AppMethodBeat.i(119230);
        com.tencent.mm.kernel.b aAg = com.tencent.mm.kernel.g.aAg();
        p.g(aAg, "network()");
        aAg.azz().b(273, this);
        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
        com.tencent.mm.plugin.story.f.b.b.g(this.FpA);
        AppMethodBeat.o(119230);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void B(int i2, int i3, boolean z) {
        AppMethodBeat.i(119231);
        if (i2 == 3) {
            if (!z) {
                fpx();
            } else if (i3 == 0) {
                j.b bVar = j.Fmy;
                j.b.eJP().post(new h(this));
                AppMethodBeat.o(119231);
                return;
            } else {
                if (i3 == 1) {
                    fpx();
                }
                AppMethodBeat.o(119231);
                return;
            }
        }
        AppMethodBeat.o(119231);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaK(int i2) {
        AppMethodBeat.i(119232);
        this.Frg = i2;
        if (this.Frg == 1 && !this.Frh) {
            fpw();
        }
        AppMethodBeat.o(119232);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void fpz() {
        AppMethodBeat.i(119233);
        int size = this.iPH.size() <= 3 ? this.iPH.size() : 3;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.iPH.get(i2);
            p.g(aVar, "userList[i]");
            a(aVar);
        }
        if (this.iPH.size() > 0) {
            this.FrO.add(this.iPH.get(0));
            fpF();
        }
        AppMethodBeat.o(119233);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void cJk() {
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void je(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void jf(int i2, int i3) {
        AppMethodBeat.i(119234);
        this.Fre = i2;
        this.Frf = i3;
        if (this.Frg == 1) {
            fpw();
        }
        AppMethodBeat.o(119234);
    }

    @Override // com.tencent.mm.plugin.story.g.f
    public final void aaO(int i2) {
        AppMethodBeat.i(119235);
        List<a> list = this.iPH;
        p.g(list, "userList");
        a aVar = (a) kotlin.a.j.L(list, i2);
        if (aVar != null) {
            a(aVar);
        }
        List<a> list2 = this.iPH;
        p.g(list2, "userList");
        List<a> list3 = this.iPH;
        p.g(list3, "userList");
        com.tencent.mm.ac.d.b("MultiUserGalleryPresenter_checkLoadMore", new b(this, (a) kotlin.a.j.L(list2, this.FrM + i2), (a) kotlin.a.j.L(list3, this.FrN + i2)));
        AppMethodBeat.o(119235);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        ArrayList<com.tencent.mm.plugin.story.f.d.h> cu;
        AppMethodBeat.i(119236);
        p.h(qVar, "scene");
        if (this.FrO.size() <= 0) {
            AppMethodBeat.o(119236);
            return;
        }
        a aVar = this.FrO.get(0);
        int indexOf = this.iPH.indexOf(aVar);
        int size = this.iPH.size();
        if (indexOf < 0 || size <= indexOf) {
            this.FrO.remove(0);
            this.FrP = false;
            fpF();
            AppMethodBeat.o(119236);
            return;
        }
        Log.i(this.TAG, "LogStory: " + i2 + ' ' + i3 + ' ' + str + ", " + indexOf + ' ' + aVar);
        if (qVar instanceof com.tencent.mm.plugin.story.f.a.i) {
            int size2 = this.iPH.size();
            if (indexOf < 0) {
                AppMethodBeat.o(119236);
                return;
            } else if (size2 > indexOf && Util.isEqual(((com.tencent.mm.plugin.story.f.a.i) qVar).userName, aVar.username)) {
                this.FrO.remove(0);
                this.FrP = false;
                p.g(aVar, "user");
                Log.i(this.TAG, "LogStory: updateUserGalleryItemsFromDb " + aVar.username + ' ' + this.iPH.indexOf(aVar));
                if (this.FrU) {
                    cu = f.a.i(aVar.username, this.FrT, aVar.FrX);
                } else if (this.FrS) {
                    String str2 = aVar.username;
                    String str3 = aVar.username;
                    j.b bVar = j.Fmy;
                    cu = f.a.b(str2, Util.isEqual(str3, j.b.fau()), this.FrW.get(aVar.username));
                } else {
                    cu = f.a.cu(aVar.username, this.FrT);
                }
                Log.i(this.TAG, "LogStory: db data " + aVar + ' ' + cu.size());
                a(aVar, cu);
                fpF();
            }
        }
        AppMethodBeat.o(119236);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ g FrY;

        h(g gVar) {
            this.FrY = gVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            Boolean bool = null;
            AppMethodBeat.i(119227);
            if (this.FrY.Fre >= 0 && this.FrY.Fre < this.FrY.iPH.size() && (this.FrY.Fre == this.FrY.FrQ || this.FrY.FrQ == -1)) {
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(((a) this.FrY.iPH.get(this.FrY.Fre)).lj, this.FrY.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                String str = this.FrY.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.FrY.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FoN);
                }
                Log.i(str, append.append(bool).toString());
                if (gVar != null && gVar.FoS.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoS.getLast();
                    p.g(last, "comment.visitorList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.g.h.AnonymousClass1 */
                            final /* synthetic */ h Fsf;

                            {
                                this.Fsf = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119226);
                                gVar.FoN = false;
                                Iterator<T> it = gVar.FoS.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.Fsf.FrY.FrV.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119226);
                                return xVar;
                            }
                        });
                    }
                }
                this.FrY.FrQ = -1;
            }
            AppMethodBeat.o(119227);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ g FrY;

        f(g gVar) {
            this.FrY = gVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            Boolean bool = null;
            AppMethodBeat.i(119222);
            if (this.FrY.Fre >= 0 && this.FrY.Fre < this.FrY.iPH.size() && (this.FrY.Fre == this.FrY.FrQ || this.FrY.FrQ == -1)) {
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(((a) this.FrY.iPH.get(this.FrY.Fre)).lj, this.FrY.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                String str = this.FrY.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.FrY.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FoO);
                }
                Log.i(str, append.append(bool).toString());
                if (gVar != null && gVar.FoQ.size() > 0) {
                    com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                    long j2 = gVar.edx;
                    com.tencent.mm.plugin.story.f.b.a last = gVar.FoQ.getLast();
                    p.g(last, "comment.msgList.last");
                    if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.story.g.g.f.AnonymousClass1 */
                            final /* synthetic */ f Fsd;

                            {
                                this.Fsd = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(119221);
                                gVar.FoO = false;
                                Iterator<T> it = gVar.FoQ.iterator();
                                while (it.hasNext()) {
                                    it.next().FnW = false;
                                }
                                this.Fsd.FrY.FrV.fpA();
                                x xVar = x.SXb;
                                AppMethodBeat.o(119221);
                                return xVar;
                            }
                        });
                    }
                }
                this.FrY.FrQ = -1;
            }
            AppMethodBeat.o(119222);
        }
    }

    private final void fpx() {
        AppMethodBeat.i(119237);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new f(this));
        AppMethodBeat.o(119237);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.g.g$g  reason: collision with other inner class name */
    public static final class RunnableC1764g implements Runnable {
        final /* synthetic */ g FrY;

        RunnableC1764g(g gVar) {
            this.FrY = gVar;
        }

        public final void run() {
            final com.tencent.mm.plugin.story.f.d.g gVar;
            com.tencent.mm.plugin.story.i.j jVar;
            Boolean bool = null;
            AppMethodBeat.i(119225);
            if (this.FrY.Fre >= 0 && this.FrY.Fre < this.FrY.iPH.size() && (this.FrY.Fre == this.FrY.FrQ || this.FrY.FrQ == -1)) {
                a aVar = (a) this.FrY.iPH.get(this.FrY.Fre);
                com.tencent.mm.plugin.story.f.d.h hVar = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(aVar.lj, this.FrY.Frf);
                if (hVar != null) {
                    gVar = hVar.FoU;
                } else {
                    gVar = null;
                }
                com.tencent.mm.plugin.story.f.d.h hVar2 = (com.tencent.mm.plugin.story.f.d.h) kotlin.a.j.L(aVar.lj, this.FrY.Frf);
                if (hVar2 != null) {
                    jVar = hVar2.FoV;
                } else {
                    jVar = null;
                }
                String str = this.FrY.TAG;
                StringBuilder append = new StringBuilder("setSelectedRead ").append(this.FrY.Frf).append(", ");
                if (gVar != null) {
                    bool = Boolean.valueOf(gVar.FnW);
                }
                Log.i(str, append.append(bool).toString());
                if (!this.FrY.Frh) {
                    if (jVar != null && jVar.frF()) {
                        jVar.vX(false);
                        n.a aVar2 = n.FmM;
                        n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                    }
                    if (gVar != null && gVar.commentList.size() > 0) {
                        com.tencent.mm.plugin.story.f.b.b bVar = com.tencent.mm.plugin.story.f.b.b.Fom;
                        long j2 = gVar.edx;
                        com.tencent.mm.plugin.story.f.b.a last = gVar.commentList.getLast();
                        p.g(last, "comment.commentList.last");
                        if (com.tencent.mm.plugin.story.f.b.b.b(j2, last)) {
                            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                                /* class com.tencent.mm.plugin.story.g.g.RunnableC1764g.AnonymousClass2 */
                                final /* synthetic */ RunnableC1764g Fse;

                                {
                                    this.Fse = r2;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ x invoke() {
                                    AppMethodBeat.i(119224);
                                    gVar.FoN = false;
                                    gVar.FoO = false;
                                    gVar.FnW = false;
                                    Iterator<T> it = gVar.commentList.iterator();
                                    while (it.hasNext()) {
                                        it.next().FnW = false;
                                    }
                                    this.Fse.FrY.FrV.fpA();
                                    x xVar = x.SXb;
                                    AppMethodBeat.o(119224);
                                    return xVar;
                                }
                            });
                        }
                    }
                } else if (jVar != null && jVar.frF()) {
                    jVar.vX(false);
                    n.a aVar3 = n.FmM;
                    n.a.aa(jVar.field_storyID, jVar.field_localFlag);
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.story.g.g.RunnableC1764g.AnonymousClass1 */
                        final /* synthetic */ RunnableC1764g Fse;

                        {
                            this.Fse = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(119223);
                            this.Fse.FrY.FrV.fpA();
                            x xVar = x.SXb;
                            AppMethodBeat.o(119223);
                            return xVar;
                        }
                    });
                }
                this.FrY.FrQ = -1;
            }
            AppMethodBeat.o(119225);
        }
    }

    private final void fpw() {
        AppMethodBeat.i(119238);
        j.b bVar = j.Fmy;
        j.b.eJP().post(new RunnableC1764g(this));
        AppMethodBeat.o(119238);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.tencent.mm.plugin.story.g.g.a r10, java.util.ArrayList<com.tencent.mm.plugin.story.f.d.h> r11) {
        /*
        // Method dump skipped, instructions count: 256
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.g.a(com.tencent.mm.plugin.story.g.g$a, java.util.ArrayList):void");
    }

    private final void a(a aVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(119240);
        if (this.iPH.indexOf(aVar) < 0) {
            AppMethodBeat.o(119240);
        } else if (aVar.state != 0) {
            Log.i(this.TAG, "LogStory: preloadForUser already preload");
            AppMethodBeat.o(119240);
        } else {
            ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = new ArrayList<>();
            Log.i(this.TAG, "LogStory: preloadForUser " + aVar + ' ' + this.FrS + ' ' + this.FkI);
            if (this.FrU) {
                aVar.state = 1;
                int aWB = cl.aWB();
                i.a aVar2 = com.tencent.mm.plugin.story.f.i.Fmb;
                int i2 = aWB - com.tencent.mm.plugin.story.f.i.FlY;
                j.b bVar = j.Fmy;
                aVar.FrX = Math.max(i2, (int) (j.b.fod().aRS(aVar.username).field_readTime / 1000));
                ArrayList<com.tencent.mm.plugin.story.f.d.h> i3 = f.a.i(aVar.username, this.FrT, aVar.FrX);
                if (i3.isEmpty()) {
                    z2 = false;
                }
                if (z2) {
                    Log.i(this.TAG, "LogStory: preload add sync item and local item, " + i3.size());
                    arrayList.addAll(i3);
                }
            } else if (this.FrS) {
                aVar.state = 2;
                String str = aVar.username;
                String str2 = aVar.username;
                j.b bVar2 = j.Fmy;
                ArrayList<com.tencent.mm.plugin.story.f.d.h> b2 = f.a.b(str, Util.isEqual(str2, j.b.fau()), this.FrW.get(aVar.username));
                if (!b2.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.i(this.TAG, "LogStory: preload add sync item and local item, " + b2.size());
                    arrayList.addAll(b2);
                }
            } else {
                j.b bVar3 = j.Fmy;
                if (Util.isEqual(j.b.fau(), aVar.username)) {
                    aVar.state = 1;
                    ArrayList<com.tencent.mm.plugin.story.f.d.h> cu = f.a.cu(aVar.username, this.FrT);
                    if (cu.size() > 0) {
                        Log.i(this.TAG, "LogStory: preload add sync item and local item, " + cu.size());
                        arrayList.addAll(cu);
                    }
                } else {
                    aVar.state = 1;
                    com.tencent.mm.plugin.story.f.d.h ct = f.a.ct(aVar.username, this.FrT);
                    if (ct == null) {
                        a(aVar, arrayList);
                        AppMethodBeat.o(119240);
                        return;
                    }
                    ArrayList<com.tencent.mm.plugin.story.f.d.h> cu2 = f.a.cu(aVar.username, this.FrT);
                    if (cu2.size() > 0) {
                        Log.i(this.TAG, "LogStory: preload add sync item and local item, " + cu2.size());
                        if (cu2.get(0).edx != ct.edx) {
                            arrayList.add(ct);
                        }
                        arrayList.addAll(cu2);
                    } else {
                        Log.i(this.TAG, "LogStory: preload add sync item");
                        arrayList.add(ct);
                    }
                }
            }
            a(aVar, arrayList);
            AppMethodBeat.o(119240);
        }
    }

    private final void fpF() {
        AppMethodBeat.i(119241);
        while (!this.FrP && this.FrO.size() > 0) {
            a aVar = this.FrO.get(0);
            int indexOf = this.iPH.indexOf(aVar);
            int size = this.iPH.size();
            if (indexOf >= 0 && size > indexOf && aVar.state != 2) {
                aVar.state = 2;
                Log.i(this.TAG, "LogStory: loadRemoteForUser ".concat(String.valueOf(aVar)));
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).loadStory(aVar.username, this.jVv);
                this.FrP = true;
                AppMethodBeat.o(119241);
                return;
            }
            this.FrO.remove(0);
        }
        AppMethodBeat.o(119241);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JA\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "", ch.COL_USERNAME, "", "state", "", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "timestampBound", "(Ljava/lang/String;ILjava/util/ArrayList;I)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getState", "()I", "setState", "(I)V", "getTimestampBound", "setTimestampBound", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "plugin-story_release"})
    public static final class a {
        int FrX;
        ArrayList<com.tencent.mm.plugin.story.f.d.h> lj;
        int state;
        final String username;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r3.FrX == r4.FrX) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 119212(0x1d1ac, float:1.67052E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002e
                boolean r0 = r4 instanceof com.tencent.mm.plugin.story.g.g.a
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.plugin.story.g.g$a r4 = (com.tencent.mm.plugin.story.g.g.a) r4
                java.lang.String r0 = r3.username
                java.lang.String r1 = r4.username
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                int r0 = r3.state
                int r1 = r4.state
                if (r0 != r1) goto L_0x0033
                java.util.ArrayList<com.tencent.mm.plugin.story.f.d.h> r0 = r3.lj
                java.util.ArrayList<com.tencent.mm.plugin.story.f.d.h> r1 = r4.lj
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0033
                int r0 = r3.FrX
                int r1 = r4.FrX
                if (r0 != r1) goto L_0x0033
            L_0x002e:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0032:
                return r0
            L_0x0033:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0032
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.g.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(119211);
            String str = this.username;
            int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.state) * 31;
            ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList = this.lj;
            if (arrayList != null) {
                i2 = arrayList.hashCode();
            }
            int i3 = ((hashCode + i2) * 31) + this.FrX;
            AppMethodBeat.o(119211);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(119210);
            String str = "UserData(username=" + this.username + ", state=" + this.state + ", items=" + this.lj + ", timestampBound=" + this.FrX + ")";
            AppMethodBeat.o(119210);
            return str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ a(java.lang.String r4, java.util.ArrayList r5) {
            /*
                r3 = this;
                r2 = 119209(0x1d1a9, float:1.67047E-40)
                int r0 = com.tencent.mm.model.cl.aWB()
                com.tencent.mm.plugin.story.f.i$a r1 = com.tencent.mm.plugin.story.f.i.Fmb
                int r1 = com.tencent.mm.plugin.story.f.i.fnT()
                int r0 = r0 - r1
                r3.<init>(r4, r5, r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.g.g.a.<init>(java.lang.String, java.util.ArrayList):void");
        }

        private a(String str, ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList, int i2) {
            p.h(str, ch.COL_USERNAME);
            p.h(arrayList, "items");
            AppMethodBeat.i(119208);
            this.username = str;
            this.state = 0;
            this.lj = arrayList;
            this.FrX = i2;
            AppMethodBeat.o(119208);
        }

        public final void aS(ArrayList<com.tencent.mm.plugin.story.f.d.h> arrayList) {
            AppMethodBeat.i(119207);
            p.h(arrayList, "<set-?>");
            this.lj = arrayList;
            AppMethodBeat.o(119207);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g FrY;
        final /* synthetic */ a FrZ;
        final /* synthetic */ a Fsa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(g gVar, a aVar, a aVar2) {
            super(0);
            this.FrY = gVar;
            this.FrZ = aVar;
            this.Fsa = aVar2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119213);
            a aVar = this.FrZ;
            if (aVar != null) {
                g.a(this.FrY, aVar);
            }
            a aVar2 = this.Fsa;
            if (aVar2 != null) {
                this.FrY.FrO.add(aVar2);
            }
            g.b(this.FrY);
            x xVar = x.SXb;
            AppMethodBeat.o(119213);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ g FrY;
        final /* synthetic */ int Fro;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(g gVar, int i2) {
            super(0);
            this.FrY = gVar;
            this.Fro = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119214);
            this.FrY.iPH.remove(this.Fro);
            this.FrY.FrV.aaM(this.Fro);
            x xVar = x.SXb;
            AppMethodBeat.o(119214);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ArrayList FrB;
        final /* synthetic */ g FrY;
        final /* synthetic */ int Fro;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(g gVar, int i2, ArrayList arrayList) {
            super(0);
            this.FrY = gVar;
            this.Fro = i2;
            this.FrB = arrayList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119215);
            this.FrY.FrV.u(this.Fro, this.FrB);
            this.FrY.FrV.aaN(this.Fro);
            this.FrY.FrV.fpA();
            x xVar = x.SXb;
            AppMethodBeat.o(119215);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ArrayList FrB;
        final /* synthetic */ g FrY;
        final /* synthetic */ int Fro;
        final /* synthetic */ c.b Fsb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(g gVar, int i2, ArrayList arrayList, c.b bVar) {
            super(0);
            this.FrY = gVar;
            this.Fro = i2;
            this.FrB = arrayList;
            this.Fsb = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(119220);
            this.FrY.FrV.u(this.Fro, this.FrB);
            this.FrY.FrV.fpA();
            this.Fsb.a(new android.support.v7.h.d(this) {
                /* class com.tencent.mm.plugin.story.g.g.e.AnonymousClass1 */
                final /* synthetic */ e Fsc;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.Fsc = r1;
                }

                @Override // android.support.v7.h.d
                public final void c(int i2, int i3, Object obj) {
                    AppMethodBeat.i(119216);
                    Log.i(this.Fsc.FrY.TAG, "onChanged: " + i2 + ' ' + i3);
                    this.Fsc.FrY.FrV.aA(this.Fsc.Fro, i2, i3);
                    AppMethodBeat.o(119216);
                }

                @Override // android.support.v7.h.d
                public final void l(int i2, int i3) {
                    AppMethodBeat.i(119217);
                    Log.i(this.Fsc.FrY.TAG, "onMoved: " + i2 + ' ' + i3);
                    AppMethodBeat.o(119217);
                }

                @Override // android.support.v7.h.d
                public final void f(int i2, int i3) {
                    AppMethodBeat.i(119218);
                    Log.i(this.Fsc.FrY.TAG, "onInserted: " + i2 + ' ' + i3);
                    this.Fsc.FrY.FrV.ay(this.Fsc.Fro, i2, i3);
                    AppMethodBeat.o(119218);
                }

                @Override // android.support.v7.h.d
                public final void k(int i2, int i3) {
                    AppMethodBeat.i(119219);
                    Log.i(this.Fsc.FrY.TAG, "onRemoved: " + i2 + ' ' + i3);
                    this.Fsc.FrY.FrV.az(this.Fsc.Fro, i2, i3);
                    AppMethodBeat.o(119219);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(119220);
            return xVar;
        }
    }
}
