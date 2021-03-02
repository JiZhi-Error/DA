package com.tencent.mm.plugin.finder.feed.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.q;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\b\u000b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0004J\b\u0010\u0017\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001aH\u0016J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001aH\u0016J\u0018\u0010)\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0016H\u0016J\u0018\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001aH\u0016J\u0016\u0010-\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020$H\u0016J\u0010\u00103\u001a\u0002012\u0006\u0010#\u001a\u00020$H\u0016J\u0016\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u0002012\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u00106\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u000201H\u0002J\u0010\u00107\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0016H\u0004J\u001a\u00107\u001a\u0004\u0018\u0001012\u0006\u0010&\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0016H\u0004J\u000e\u00109\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u0016R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006:"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "addRvFeed", "", FirebaseAnalytics.b.INDEX, "", "feed", "colletExtraPageName", "", "getItem", "feedId", "", "getPageName", "insert", "notify", "", "interceptMvFeed", "interceptMvPostStart", "interceptPostStart", "isObservePostEvent", "onAlive", "onDataChanged", "onDead", "onMvPostStart", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onPostEnd", ch.COL_LOCALID, "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "isFromSns", "remove", "removeByLocalId", "feedLocalId", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "transformToMusicData", "updateByLocalId", "newFeed", "updateFinderPageItem", "updateItem", "svrId", "updateProgressByLocalId", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader extends BaseFeedLoader<bo> implements q {
    private byte _hellAccFlag_;
    private final BaseFinderFeedLoader$feedChangeListener$1 feedChangeListener;
    private final BaseFinderFeedLoader$feedDeleteListener$1 feedDeleteListener;

    public BaseFinderFeedLoader() {
        this(null, 1, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.feed.model.internal.IResponse] */
    @Override // com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader, com.tencent.mm.plugin.finder.feed.model.internal.f
    public void onFetchDone(IResponse<bo> iResponse) {
        b bVar = new b();
        bVar.bm(iResponse);
        a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, bVar.axR());
        super.onFetchDone(iResponse);
        a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    }

    public BaseFinderFeedLoader(bbn bbn) {
        super(bbn);
        this.feedDeleteListener = new BaseFinderFeedLoader$feedDeleteListener$1(this);
        this.feedChangeListener = new BaseFinderFeedLoader$feedChangeListener$1(this, bbn);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseFinderFeedLoader(bbn bbn, int i2, j jVar) {
        this((i2 & 1) != 0 ? null : bbn);
    }

    public void onDataChanged() {
    }

    public boolean interceptPostStart() {
        return false;
    }

    public boolean interceptMvPostStart() {
        return true;
    }

    public boolean interceptMvFeed() {
        return false;
    }

    /* access modifiers changed from: private */
    public final void updateFinderPageItem(BaseFinderFeed baseFinderFeed) {
        arl arl;
        LinkedList<aqq> linkedList;
        ArrayList<Number> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getPageName()));
        arrayList.addAll(colletExtraPageName());
        for (Number number : arrayList) {
            int intValue = number.intValue();
            if (intValue >= 0) {
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                long lT = baseFinderFeed.lT();
                FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                p.h(feedObject, "item");
                Log.i("Finder.FinderPage", "updatePageData pageName:" + intValue + ", svrId:" + lT);
                if (intValue >= 0) {
                    try {
                        l.a.Lf(intValue);
                        LinkedList<arl> linkedList2 = com.tencent.mm.plugin.finder.storage.data.l.vGv.Lg(intValue).vFP.zns;
                        if (!(linkedList2 == null || (arl = (arl) kotlin.a.j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null)) {
                            i iVar = i.vGl;
                            if (i.a(lT, feedObject, linkedList)) {
                                l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                                l.a.a(com.tencent.mm.plugin.finder.storage.data.l.vGv.Lg(intValue));
                            }
                        }
                    } catch (Throwable th) {
                        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
                            throw th;
                        }
                        Log.printErrStackTrace("Finder.FinderPage", th, "updatePageData ".concat(String.valueOf(intValue)), new Object[0]);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public BaseFinderFeed transformFinderObj(FinderItem finderItem) {
        p.h(finderItem, "feedObj");
        c.a aVar = c.vGN;
        return c.a.s(finderItem);
    }

    public BaseFinderFeed transformToMusicData(FinderItem finderItem) {
        p.h(finderItem, "item");
        return transformFinderObj(finderItem);
    }

    public boolean isObservePostEvent() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onAlive() {
        super.onAlive();
        if (isObservePostEvent()) {
            g.a aVar = g.vSJ;
            g.vSH.a(this);
        }
        this.feedDeleteListener.alive();
        this.feedChangeListener.alive();
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.Dispatcher, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public void onDead() {
        super.onDead();
        if (isObservePostEvent()) {
            g.a aVar = g.vSJ;
            g.vSH.b(this);
        }
        this.feedDeleteListener.dead();
        this.feedChangeListener.dead();
    }

    public void onPostStart(long j2, boolean z) {
        boolean z2;
        onDataChanged();
        if (!interceptPostStart()) {
            c.a aVar = c.vGN;
            FinderItem FS = c.a.FS(j2);
            if (FS != null) {
                ArrayList arrayList = new ArrayList();
                BaseFinderFeed transformFinderObj = transformFinderObj(FS);
                if (!transformFinderObj.feedObject.isMvFeed() || !interceptMvPostStart()) {
                    Log.i(getTAG(), "onPostStart localId " + j2 + " feed " + transformFinderObj);
                    y yVar = y.vXH;
                    if (!y.dnv()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    transformFinderObj.showLikeTips = z2;
                    transformFinderObj.showShareSns = z;
                    if (kotlin.a.j.kt(getDataList()) instanceof x) {
                        d.h(new BaseFinderFeedLoader$onPostStart$$inlined$also$lambda$1(transformFinderObj, arrayList, this, FS, j2, z));
                        return;
                    }
                    arrayList.add(transformFinderObj);
                    com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(getMerger(), 2, arrayList, true, null, 8, null);
                }
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostStart(long j2) {
        onPostStart(j2, false);
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostEnd(long j2, boolean z) {
        updateItem(j2);
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostNotify(long j2, boolean z) {
        updateItem(j2);
    }

    @Override // com.tencent.mm.plugin.finder.upload.q
    public void onPostOk(long j2, long j3) {
        BaseFinderFeed updateItem = updateItem(j2, j3);
        if (updateItem != null) {
            updateItem.isFinishPostSoon = true;
        }
    }

    public void onMvPostStart(FinderItem finderItem) {
        p.h(finderItem, "item");
    }

    public final void updateProgressByLocalId(long j2) {
        if (j2 > 0) {
            d.h(new BaseFinderFeedLoader$updateProgressByLocalId$1(this, j2));
        }
    }

    /* access modifiers changed from: protected */
    public final BaseFinderFeed updateItem(long j2, long j3) {
        e.a aVar = e.vFX;
        FinderItem Fy = e.a.Fy(j3);
        if (Fy != null) {
            Fy.setLocalId(j2);
        }
        if (Fy == null) {
            return null;
        }
        Log.i(getTAG(), "updateItem localId:" + j2 + " itemLoadId:" + Fy.getLocalId() + " itemId:" + Fy.getId());
        BaseFinderFeed transformFinderObj = transformFinderObj(Fy);
        updateByLocalId(transformFinderObj, true);
        return transformFinderObj;
    }

    /* access modifiers changed from: protected */
    public final void updateItem(long j2) {
        c.a aVar = c.vGN;
        FinderItem FS = c.a.FS(j2);
        if (FS != null) {
            Log.i(getTAG(), "updateItem localId:" + j2 + " itemLoadId:" + FS.getLocalId() + " itemId:" + FS.getId());
            updateByLocalId(transformFinderObj(FS), true);
        }
    }

    /* access modifiers changed from: protected */
    public final bo getItem(long j2) {
        boolean z;
        Iterator it = getDataList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((bo) it.next()).lT() == j2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            i2++;
        }
        if (i2 == -1 || i2 >= getDataList().size()) {
            return null;
        }
        return (bo) getDataList().get(i2);
    }

    public final int remove(long j2, boolean z) {
        Iterator it = getDataList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            if (((bo) it.next()).lT() == j2) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            p.g(getDataList().remove(i2), "dataList.removeAt(index)");
            if (z) {
                dispatcher().onItemRangeRemoved(i2, 1);
                onDataChanged();
            }
        }
        return i2;
    }

    public int insert(bo boVar, int i2, boolean z) {
        p.h(boVar, "feed");
        int indexOf = getDataList().indexOf(boVar);
        if (indexOf != i2) {
            if (indexOf >= 0) {
                getDataList().remove(boVar);
            }
            if (i2 >= 0) {
                addRvFeed(i2, boVar);
                if (z) {
                    dispatcher().onItemRangeRemoved(i2, 1);
                }
            }
        }
        return i2;
    }

    public void addRvFeed(int i2, bo boVar) {
        p.h(boVar, "feed");
        getDataList().add(i2, boVar);
    }

    public final int removeByLocalId(long j2, boolean z) {
        Iterator it = getDataList().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            bo boVar = (bo) it.next();
            if ((boVar instanceof BaseFinderFeed) && ((BaseFinderFeed) boVar).feedObject.getLocalId() == j2) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            p.g(getDataList().remove(i2), "dataList.removeAt(index)");
            if (z) {
                dispatcher().onItemRangeRemoved(i2, 1);
            }
        }
        return i2;
    }

    public int getPageName() {
        return -1;
    }

    public List<Integer> colletExtraPageName() {
        return new ArrayList();
    }

    public final int updateByLocalId(BaseFinderFeed baseFinderFeed, boolean z) {
        p.h(baseFinderFeed, "newFeed");
        if (baseFinderFeed.feedObject.getLocalId() <= 0) {
            return -1;
        }
        int i2 = 0;
        for (Object obj : getDataList()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.j.hxH();
            }
            bo boVar = (bo) obj;
            if (!(boVar instanceof BaseFinderFeed) || ((BaseFinderFeed) boVar).feedObject.getLocalId() != baseFinderFeed.feedObject.getLocalId()) {
                i2 = i3;
            } else {
                baseFinderFeed.showLikeTips = ((BaseFinderFeed) boVar).showLikeTips;
                baseFinderFeed.showShareSns = ((BaseFinderFeed) boVar).showShareSns;
                getDataList().set(i2, baseFinderFeed);
                if (!z) {
                    return i2;
                }
                Log.i(getTAG(), "updateByLocalId " + baseFinderFeed.feedObject.getLocalId());
                if (interceptMvFeed()) {
                    dispatcher().onItemRangeChanged(i2, 1, new o(20, 1));
                    return i2;
                }
                dispatcher().onItemRangeChanged(i2, 1, 1);
                return i2;
            }
        }
        return -1;
    }
}
