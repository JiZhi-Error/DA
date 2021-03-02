package com.tencent.mm.plugin.story.g;

import android.support.v7.h.c;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.a;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.f.q;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.protocal.protobuf.eek;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J*\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0014H\u0016¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "", "()V", "cancelDeleteItem", "", "row", "", "column", "checkLoadMore", "deleteItem", "destroy", "initExpectPosition", "expectPos", "initLoad", "loadMore", "onGalleryState", "state", "onMsgListState", FirebaseAnalytics.b.INDEX, "isSelf", "", "onSelected", "pause", "resume", "setFavorite", "isFavorite", "replaceStory", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "setPrivacy", "nowPrivacy", "Companion", "plugin-story_release"})
public abstract class f {
    public static final a FrJ = new a((byte) 0);
    static final String TAG = TAG;

    public void resume() {
    }

    public void pause() {
    }

    public void destroy() {
    }

    public void aaK(int i2) {
    }

    public void B(int i2, int i3, boolean z) {
    }

    public void fpz() {
    }

    public void cJk() {
    }

    public void je(int i2, int i3) {
    }

    public void fpy() {
    }

    public void jf(int i2, int i3) {
    }

    public void aaO(int i2) {
    }

    public void aaP(int i2) {
    }

    public void C(int i2, int i3, boolean z) {
    }

    public void D(int i2, int i3, boolean z) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007JB\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00142\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0010J.\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000fj\b\u0012\u0004\u0012\u00020\f`\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0004J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion;", "", "()V", "GalleryStateImage", "", "GalleryStateVideo", "TAG", "", "calculateDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItems", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "newItems", "getFavGalleryItemsFromDb", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ch.COL_USERNAME, "getGalleryItemsFromDb", "isForSns", "", "getGalleryItemsFromDbByDate", FFmpegMetadataRetriever.METADATA_KEY_DATE, "getGalleryItemsFromDbByStoryId", "isSelf", "storyIds", "", "getUnreadGalleryItemsFromDb", AppMeasurement.Param.TIMESTAMP, "loadSyncData", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h ct(String str, boolean z) {
            boolean z2;
            eek frG;
            AppMethodBeat.i(119201);
            p.h(str, ch.COL_USERNAME);
            Log.i(f.TAG, "LogStory: loadSyncData ".concat(String.valueOf(str)));
            k kVar = k.FmH;
            com.tencent.mm.plugin.story.i.f aRS = k.aRS(str);
            if (aRS.field_syncId == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(119201);
                return null;
            } else if (z) {
                h.a aVar = h.FoY;
                p.h(aRS, IssueStorage.COLUMN_EXT_INFO);
                j.b bVar = j.Fmy;
                com.tencent.mm.plugin.story.i.j KA = j.b.foc().KA(aRS.field_syncId);
                com.tencent.mm.plugin.story.i.j jVar = new com.tencent.mm.plugin.story.i.j();
                jVar.field_storyID = aRS.field_syncId;
                jVar.field_createTime = aRS.field_storyPostTime;
                jVar.field_userName = aRS.getUserName();
                q.a aVar2 = q.FmO;
                eek fox = q.a.fox();
                fox.UserName = aRS.getUserName();
                fox.CreateTime = aRS.field_storyPostTime;
                q.a aVar3 = q.FmO;
                edt edt = new edt();
                edt.Id = "empty_" + cl.aWz();
                if (!(KA == null || (frG = KA.frG()) == null || frG.NeD != 0)) {
                    edt.Msz = aRS.aBE();
                    edt.Url = aRS.frx();
                }
                fox.NeB.LoV.add(edt);
                jVar.c(fox);
                h hVar = new h(jVar, fox);
                AppMethodBeat.o(119201);
                return hVar;
            } else {
                h.a aVar4 = h.FoY;
                h a2 = h.a.a(aRS);
                AppMethodBeat.o(119201);
                return a2;
            }
        }

        public static ArrayList<h> cu(String str, boolean z) {
            List<com.tencent.mm.plugin.story.i.j> a2;
            AppMethodBeat.i(119202);
            p.h(str, ch.COL_USERNAME);
            ArrayList<h> arrayList = new ArrayList<>();
            if (z) {
                j.b bVar = j.Fmy;
                com.tencent.mm.plugin.story.i.k foc = j.b.foc();
                j.b bVar2 = j.Fmy;
                boolean isEqual = Util.isEqual(j.b.fau(), str);
                int aWB = cl.aWB();
                i.a aVar = i.Fmb;
                a2 = foc.j(str, isEqual, aWB - i.FlY);
            } else {
                j.b bVar3 = j.Fmy;
                com.tencent.mm.plugin.story.i.k foc2 = j.b.foc();
                j.b bVar4 = j.Fmy;
                boolean isEqual2 = Util.isEqual(j.b.fau(), str);
                int aWB2 = cl.aWB();
                i.a aVar2 = i.Fmb;
                a2 = foc2.a(str, isEqual2, aWB2 - i.FlY, true);
            }
            for (com.tencent.mm.plugin.story.i.j jVar : a2) {
                eek frG = jVar.frG();
                if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                    h.a aVar3 = h.FoY;
                    arrayList.add(h.a.b(jVar));
                    Log.i(f.TAG, "getGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + frG.NeB.LoV.get(0).Msz + ' ' + "and " + frG.NeB.LoV.get(0).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName + " tryCount:" + jVar.frI().ibG + " flag:" + jVar.field_localFlag);
                }
            }
            AppMethodBeat.o(119202);
            return arrayList;
        }

        public static ArrayList<h> i(String str, boolean z, int i2) {
            List<com.tencent.mm.plugin.story.i.j> a2;
            AppMethodBeat.i(119203);
            p.h(str, ch.COL_USERNAME);
            ArrayList<h> arrayList = new ArrayList<>();
            if (z) {
                j.b bVar = j.Fmy;
                com.tencent.mm.plugin.story.i.k foc = j.b.foc();
                j.b bVar2 = j.Fmy;
                a2 = foc.j(str, Util.isEqual(j.b.fau(), str), i2);
            } else {
                j.b bVar3 = j.Fmy;
                com.tencent.mm.plugin.story.i.k foc2 = j.b.foc();
                j.b bVar4 = j.Fmy;
                a2 = foc2.a(str, Util.isEqual(j.b.fau(), str), i2, true);
            }
            for (com.tencent.mm.plugin.story.i.j jVar : a2) {
                eek frG = jVar.frG();
                if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                    h.a aVar = h.FoY;
                    arrayList.add(h.a.b(jVar));
                    Log.i(f.TAG, "getGalleryItemsFromDb story username " + str + ' ' + arrayList.size() + ' ' + "content " + frG.NeB.LoV.get(0).Msz + ' ' + "and " + frG.NeB.LoV.get(0).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName + " tryCount:" + jVar.frI().ibG + " flag:" + jVar.field_localFlag);
                }
            }
            AppMethodBeat.o(119203);
            return arrayList;
        }

        public static ArrayList<h> la(String str, String str2) {
            AppMethodBeat.i(119204);
            p.h(str, ch.COL_USERNAME);
            p.h(str2, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            ArrayList<h> arrayList = new ArrayList<>();
            a.C1747a aVar = com.tencent.mm.plugin.story.e.a.Flw;
            int aRN = a.C1747a.aRN(str2);
            j.b bVar = j.Fmy;
            for (com.tencent.mm.plugin.story.i.j jVar : j.b.foc().fN(str, aRN)) {
                eek frG = jVar.frG();
                if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                    h.a aVar2 = h.FoY;
                    arrayList.add(h.a.b(jVar));
                    Log.i(f.TAG, "getGalleryItemsFromDbByDate story username " + str + ' ' + arrayList.size() + ' ' + "content " + frG.NeB.LoV.get(0).Msz + ' ' + "and " + frG.NeB.LoV.get(0).Url + " id:" + jVar.field_storyID + " storyUsername: " + jVar.field_userName);
                }
            }
            AppMethodBeat.o(119204);
            return arrayList;
        }

        public static ArrayList<h> b(String str, boolean z, ArrayList<Long> arrayList) {
            AppMethodBeat.i(119205);
            p.h(str, ch.COL_USERNAME);
            c cVar = new c("getGalleryItemsFromDbByStoryId");
            ArrayList<h> arrayList2 = new ArrayList<>();
            j.b bVar = j.Fmy;
            ArrayList<com.tencent.mm.plugin.story.i.j> arrayList3 = new ArrayList();
            for (T t : j.b.foc().cw(str, z)) {
                if (arrayList != null ? arrayList.contains(Long.valueOf(((com.tencent.mm.plugin.story.i.j) t).field_storyID)) : true) {
                    arrayList3.add(t);
                }
            }
            for (com.tencent.mm.plugin.story.i.j jVar : arrayList3) {
                eek frG = jVar.frG();
                if (!(frG.NeB == null || frG.NeB.LoV.size() == 0)) {
                    h.a aVar = h.FoY;
                    arrayList2.add(h.a.a(jVar, com.tencent.mm.plugin.story.f.d.i.UNREAD_FIRST));
                    Log.i(f.TAG, "getGalleryItemsFromDbByStoryId story:" + jVar + ", content:" + frG.NeB.LoV.get(0).Msz + ' ' + "and " + frG.NeB.LoV.get(0).Url + ", id:" + jVar.field_storyID + ", storyUsername:" + jVar.field_userName);
                }
            }
            cVar.aBw();
            AppMethodBeat.o(119205);
            return arrayList2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/story/presenter/IGalleryPresenter$Companion$calculateDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-story_release"})
        /* renamed from: com.tencent.mm.plugin.story.g.f$a$a  reason: collision with other inner class name */
        public static final class C1763a extends c.a {
            final /* synthetic */ List FrK;
            final /* synthetic */ List FrL;

            C1763a(List list, List list2) {
                this.FrK = list;
                this.FrL = list2;
            }

            @Override // android.support.v7.h.c.a
            public final int aB() {
                AppMethodBeat.i(119197);
                int size = this.FrK.size();
                AppMethodBeat.o(119197);
                return size;
            }

            @Override // android.support.v7.h.c.a
            public final int aC() {
                AppMethodBeat.i(119198);
                int size = this.FrL.size();
                AppMethodBeat.o(119198);
                return size;
            }

            @Override // android.support.v7.h.c.a
            public final boolean i(int i2, int i3) {
                AppMethodBeat.i(119199);
                if (((h) this.FrK.get(i2)).edx == ((h) this.FrL.get(i3)).edx) {
                    AppMethodBeat.o(119199);
                    return true;
                }
                AppMethodBeat.o(119199);
                return false;
            }

            @Override // android.support.v7.h.c.a
            public final boolean j(int i2, int i3) {
                AppMethodBeat.i(119200);
                boolean j2 = p.j((h) this.FrK.get(i2), (h) this.FrL.get(i3));
                AppMethodBeat.o(119200);
                return j2;
            }
        }

        public static c.b u(List<h> list, List<h> list2) {
            AppMethodBeat.i(119206);
            p.h(list, "oldItems");
            p.h(list2, "newItems");
            c.b a2 = android.support.v7.h.c.a(new C1763a(list, list2), false);
            p.g(a2, "DiffUtil.calculateDiff(o…  }\n            }, false)");
            AppMethodBeat.o(119206);
            return a2;
        }
    }
}
