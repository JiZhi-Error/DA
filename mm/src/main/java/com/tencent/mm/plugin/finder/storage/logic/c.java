package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aa;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ac;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class c {
    private static final String TAG = TAG;
    private static final f vGM = g.ah(b.vGO);
    public static final a vGN = new a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u000fJ$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005J.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J \u0010\"\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010$\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0016J.\u0010'\u001a\u00020\u00132\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00042\u0006\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\rJ\u000e\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0016J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0016J\u0016\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", ch.COL_LOCALID, "deleteGroupFeed", "", "deleteMegaVideoFeed", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", ch.COL_USERNAME, "startTime", "endTime", "handleFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "handleMegaVideoFeedList", "megaVideoList", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "saveCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isNeedClear", "saveToDb", "finderObj", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", ch.COL_FINDEROBJECT, "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
    public static final class a {
        public static List<Integer> dyN() {
            AppMethodBeat.i(167092);
            f fVar = c.vGM;
            a aVar = c.vGN;
            List<Integer> list = (List) fVar.getValue();
            AppMethodBeat.o(167092);
            return list;
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static /* synthetic */ List s(List list, int i2) {
            AppMethodBeat.i(252061);
            List<FinderItem> a2 = a(list, i2, null);
            AppMethodBeat.o(252061);
            return a2;
        }

        public static List<FinderItem> a(List<? extends FinderObject> list, int i2, bbn bbn) {
            AppMethodBeat.i(252060);
            p.h(list, "feedList");
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            List<? extends FinderObject> list2 = list;
            ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
            for (T t : list2) {
                FinderItem.a aVar = FinderItem.Companion;
                FinderItem a2 = FinderItem.a.a((FinderObject) t, i2);
                n nVar = n.uNU;
                n.d(a2);
                e.a aVar2 = e.vFX;
                e.a.n(a2);
                i3++;
                if (a2.getMegaVideo() != null) {
                    a aVar3 = c.vGN;
                    List listOf = j.listOf(a2.getFeedObject());
                    bbn bbn2 = new bbn();
                    bbn2.tCE = 45;
                    b(listOf, bbn2);
                }
                if (bbn != null) {
                    String str = a2.getFeedObject().sessionBuffer;
                    if (str != null) {
                        k kVar = k.vfA;
                        k.e(a2.getId(), bbn.tCE, str);
                    }
                    e.a aVar4 = e.vFX;
                    e.a.k(bbn.tCE, list);
                }
                FinderContact finderContact = a2.getFeedObject().contact;
                if (finderContact != null) {
                    c.a aVar5 = com.tencent.mm.plugin.finder.api.c.tsp;
                    c.a.b(finderContact);
                }
                Log.i(c.TAG, "insert item index id:" + t.nickname + " obj=" + t.id + " sourceType " + i2 + ' ');
                arrayList2.add(a2);
            }
            arrayList.addAll(arrayList2);
            Log.i(c.TAG, "[insertFeedList] insert count=" + list.size() + " successfulCount=" + i3 + " sourceType=" + i2);
            ArrayList arrayList3 = arrayList;
            AppMethodBeat.o(252060);
            return arrayList3;
        }

        public static void b(List<? extends FinderObject> list, bbn bbn) {
            cng cng;
            LinkedList<aop> linkedList;
            aop aop;
            bei bei;
            String str;
            Object obj;
            String str2;
            LinkedList<aop> linkedList2;
            aop aop2;
            bei bei2;
            AppMethodBeat.i(252062);
            p.h(list, "megaVideoList");
            for (T t : list) {
                e.a aVar = e.vFX;
                e.a.j(t);
                aoq aoq = t.attachmentList;
                cng cng2 = (aoq == null || (linkedList2 = aoq.LAM) == null || (aop2 = (aop) j.kt(linkedList2)) == null || (bei2 = aop2.LAL) == null) ? null : bei2.LIA;
                if (!(bbn == null || cng2 == null || (str2 = cng2.sessionBuffer) == null)) {
                    k kVar = k.vfA;
                    k.d(cng2.id, bbn.tCE, str2);
                }
                String str3 = c.TAG;
                StringBuilder sb = new StringBuilder("handleFeedList: insert mega video item index id:");
                FinderContact finderContact = t.contact;
                if (finderContact == null || (str = finderContact.nickname) == null) {
                    str = "";
                }
                StringBuilder append = sb.append(str).append(" obj=");
                if (cng2 != null) {
                    obj = Long.valueOf(cng2.id);
                } else {
                    obj = "";
                }
                Log.i(str3, append.append(obj).append(' ').toString());
            }
            if (bbn != null) {
                e.a aVar2 = e.vFX;
                int i2 = bbn.tCE;
                List<? extends FinderObject> list2 = list;
                ArrayList arrayList = new ArrayList(j.a(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    aoq aoq2 = it.next().attachmentList;
                    if (aoq2 == null || (linkedList = aoq2.LAM) == null || (aop = (aop) j.kt(linkedList)) == null || (bei = aop.LAL) == null || (cng = bei.LIA) == null) {
                        cng = new cng();
                    }
                    arrayList.add(cng);
                }
                e.a.l(i2, arrayList);
            }
            Log.i(c.TAG, "[handleFeedList] insert mega video count=" + list.size());
            AppMethodBeat.o(252062);
        }

        public static /* synthetic */ void b(List list, int i2, boolean z) {
            AppMethodBeat.i(252064);
            a(list, i2, "", z);
            AppMethodBeat.o(252064);
        }

        public static void a(List<? extends bo> list, int i2, String str, boolean z) {
            AppMethodBeat.i(252063);
            p.h(list, "list");
            p.h(str, ch.COL_USERNAME);
            if (!z) {
                AppMethodBeat.o(252063);
                return;
            }
            y yVar = y.vXH;
            int LJ = y.LJ(i2);
            int i3 = (!(str.length() > 0) || !(!p.j(str, z.aUg())) || LJ != 1) ? LJ : 3;
            LinkedList linkedList = new LinkedList();
            for (T t : list) {
                if (t instanceof BaseFinderFeed) {
                    FinderObject feedObject = t.feedObject.getFeedObject();
                    linkedList.add(new r(0, feedObject.id, feedObject, i2));
                }
            }
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.a(i3, str, linkedList);
            AppMethodBeat.o(252063);
        }

        public static LinkedList<FinderItem> af(String str, int i2, int i3) {
            AppMethodBeat.i(252065);
            p.h(str, ch.COL_USERNAME);
            LinkedList<FinderItem> af = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().af(str, i2, i3);
            AppMethodBeat.o(252065);
            return af;
        }

        public static boolean FR(long j2) {
            AppMethodBeat.i(167096);
            if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(j2) != null) {
                AppMethodBeat.o(167096);
                return true;
            }
            AppMethodBeat.o(167096);
            return false;
        }

        public static FinderItem FS(long j2) {
            AppMethodBeat.i(167097);
            Log.d(c.TAG, "get feed local id %s", Long.valueOf(j2));
            FinderItem Fz = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(j2);
            AppMethodBeat.o(167097);
            return Fz;
        }

        public static boolean FT(long j2) {
            AppMethodBeat.i(167098);
            boolean FA = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().FA(j2);
            Log.i(c.TAG, "delete feed " + j2 + " success " + FA);
            AppMethodBeat.o(167098);
            return FA;
        }

        public static void FU(long j2) {
            AppMethodBeat.i(252066);
            e.a aVar = e.vFX;
            e.a.FE(j2);
            l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.FP(j2);
            AppMethodBeat.o(252066);
        }

        public static boolean FV(long j2) {
            AppMethodBeat.i(167099);
            Log.i(c.TAG, "Finder.PostLog delete feed localId " + j2 + " success " + com.tencent.mm.plugin.finder.storage.l.a(((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage(), j2));
            AppMethodBeat.o(167099);
            return true;
        }

        public static void q(FinderItem finderItem) {
            AppMethodBeat.i(252067);
            p.h(finderItem, "finderObj");
            LinkedList<FinderItem> linkedList = new LinkedList<>();
            linkedList.addAll(finderItem.getClipListExt());
            finderItem.setClipListExt(linkedList);
            r(finderItem);
            AppMethodBeat.o(252067);
        }

        public static boolean r(FinderItem finderItem) {
            boolean a2;
            AppMethodBeat.i(167100);
            p.h(finderItem, "feedObject");
            long j2 = finderItem.field_id;
            long localId = finderItem.getLocalId();
            com.tencent.mm.plugin.finder.storage.l feedStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage();
            long j3 = -1;
            if (FR(localId)) {
                a2 = feedStorage.b(localId, finderItem);
            } else {
                a2 = j2 != 0 ? feedStorage.a(j2, finderItem) : false;
            }
            if (a2) {
                j3 = finderItem.getLocalId();
            }
            Log.i(c.TAG, "replace feedSucc %s, rowId %d", Boolean.valueOf(a2), Long.valueOf(j3));
            AppMethodBeat.o(167100);
            return a2;
        }

        public static cjl b(FinderMedia finderMedia) {
            AppMethodBeat.i(252068);
            p.h(finderMedia, "feedMedia");
            cjl a2 = com.tencent.mm.plugin.finder.storage.data.j.a(finderMedia);
            AppMethodBeat.o(252068);
            return a2;
        }

        public static BaseFinderFeed s(FinderItem finderItem) {
            w wVar;
            com.tencent.mm.plugin.finder.api.g gVar = null;
            AppMethodBeat.i(167102);
            p.h(finderItem, ch.COL_FINDEROBJECT);
            switch (finderItem.getMediaType()) {
                case 1:
                    wVar = new ab(finderItem);
                    break;
                case 2:
                    wVar = new u(finderItem);
                    break;
                case 3:
                case 5:
                case 6:
                default:
                    wVar = new ab(finderItem);
                    break;
                case 4:
                    wVar = new ad(finderItem);
                    break;
                case 7:
                    wVar = new ac(finderItem);
                    break;
                case 8:
                    wVar = new aa(finderItem);
                    break;
                case 9:
                    wVar = new w(finderItem);
                    break;
            }
            FinderContact finderContact = finderItem.getFeedObject().contact;
            if (finderContact != null) {
                gVar = com.tencent.mm.plugin.finder.api.b.a(finderContact, null);
            }
            wVar.contact = gVar;
            AppMethodBeat.o(167102);
            return wVar;
        }
    }

    static {
        AppMethodBeat.i(167103);
        AppMethodBeat.o(167103);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<List<? extends Integer>> {
        public static final b vGO = new b();

        static {
            AppMethodBeat.i(167090);
            AppMethodBeat.o(167090);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends Integer> invoke() {
            AppMethodBeat.i(167089);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            int intValue = com.tencent.mm.plugin.finder.storage.c.dtj().value().intValue();
            if (intValue != -1) {
                List listOf = j.listOf(Integer.valueOf(intValue));
                AppMethodBeat.o(167089);
                return listOf;
            }
            List listOf2 = j.listOf((Object[]) new Integer[]{2, 4, 9});
            AppMethodBeat.o(167089);
            return listOf2;
        }
    }
}
