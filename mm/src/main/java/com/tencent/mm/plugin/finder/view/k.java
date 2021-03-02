package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.feed.model.g;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.j;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0014\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u001b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\fj\b\u0012\u0004\u0012\u00020\u001c`\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H 0\fj\b\u0012\u0004\u0012\u0002H `\u000e\"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\"J\u0006\u0010#\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\rJ\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010(\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u0019J&\u0010*\u001a\u00020\u00192\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\fj\b\u0012\u0004\u0012\u00020\u001c`\u000e2\u0006\u0010,\u001a\u00020\u001eR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "", "context", "Landroid/app/Activity;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Landroid/app/Activity;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "snsRefreshListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1;", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "clearAll", "", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "position", "", "getListOfType", QLog.TAG_REPORTLEVEL_USER, "clazz", "Ljava/lang/Class;", "goSetting", "gotoLive", "item", "initData", "loadMore", "refresh", "release", "statsReport", "exposed", "commentScene", "plugin-finder_release"})
public final class k {
    private final String TAG = "Finder.FinderSnsHeaderPresenter";
    final Activity dKq;
    final ArrayList<bo> kgc = new ArrayList<>();
    private final j tXl;
    final g woJ = new g(this.kgc, this.tXl);
    final a woK = new a(this);

    public k(Activity activity, j jVar) {
        p.h(activity, "context");
        p.h(jVar, "viewCallback");
        AppMethodBeat.i(254920);
        this.dKq = activity;
        this.tXl = jVar;
        AppMethodBeat.o(254920);
    }

    public final void release() {
        AppMethodBeat.i(254917);
        this.woK.dead();
        this.woJ.release();
        AppMethodBeat.o(254917);
    }

    public final void c(bo boVar) {
        int i2;
        int i3;
        FinderObject finderObject;
        awe awe;
        String str;
        AppMethodBeat.i(254918);
        p.h(boVar, "item");
        if (!(boVar instanceof y)) {
            Log.i(this.TAG, "click not FinderFeedLiveListItem");
            AppMethodBeat.o(254918);
        } else if (Util.isEqual(((y) boVar).uOo.username, z.aUg())) {
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Activity activity = this.dKq;
            long j2 = ((y) boVar).uOo.id;
            String str2 = ((y) boVar).uOo.objectNonceId;
            if (str2 == null) {
                str2 = "";
            }
            awe awe2 = ((y) boVar).uOo.liveInfo;
            if (awe2 == null) {
                awe2 = new awe();
            }
            FinderObjectDesc finderObjectDesc = ((y) boVar).uOo.objectDesc;
            if (finderObjectDesc == null || (str = finderObjectDesc.description) == null) {
                str = "";
            }
            com.tencent.mm.plugin.finder.utils.a.a(activity, j2, str2, awe2, false, null, str, null, null, null, ((y) boVar).uOo.sessionBuffer, null, null, 14192);
            AppMethodBeat.o(254918);
        } else {
            ArrayList aO = aO(y.class);
            int i4 = 0;
            Iterator it = aO.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (((y) it.next()).uOo.id == boVar.lT()) {
                    i2 = i4;
                    break;
                }
                i4++;
            }
            Log.i(this.TAG, "click item position:".concat(String.valueOf(i2)));
            if (i2 >= 0) {
                com.tencent.mm.plugin.finder.report.live.k.vkd.a((y) boVar, ((y) boVar).uOo.username, (long) i2, s.p.LIVE_AUDIENCE_CLICK_SINGLE_AVATAR, "61");
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Activity activity2 = this.dKq;
                FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
                finderLiveConfig.uis = i2;
                finderLiveConfig.dLS = 0;
                finderLiveConfig.tCE = 61;
                ArrayList<y> arrayList = aO;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(arrayList, 10));
                for (y yVar : arrayList) {
                    m mVar = m.vVH;
                    arrayList2.add(m.q(yVar.uOo));
                }
                finderLiveConfig.ac(new ArrayList<>(arrayList2));
                y yVar2 = (y) kotlin.a.j.L(aO, i2);
                if (yVar2 == null || (finderObject = yVar2.uOo) == null || (awe = finderObject.liveInfo) == null) {
                    i3 = 0;
                } else {
                    i3 = awe.LGU;
                }
                finderLiveConfig.extFlag = i3;
                com.tencent.mm.plugin.finder.utils.a.a(activity2, finderLiveConfig, (String) null, (String) null, (Intent) null, 28);
            }
            AppMethodBeat.o(254918);
        }
    }

    public final <E> ArrayList<E> aO(Class<E> cls) {
        AppMethodBeat.i(254919);
        p.h(cls, "clazz");
        ArrayList<E> arrayList = new ArrayList<>();
        for (T t : this.kgc) {
            if (cls.isInstance(t)) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(254919);
        return arrayList;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsTimelineRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class a extends IListener<wg> {
        final /* synthetic */ k woL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(k kVar) {
            this.woL = kVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(wg wgVar) {
            AppMethodBeat.i(254915);
            wg wgVar2 = wgVar;
            if (wgVar2 != null && wgVar2.ecq.state == 1) {
                g gVar = this.woL.woJ;
                Log.i(gVar.TAG, "check refresh");
                if (!gVar.tUq) {
                    Log.i(gVar.TAG, "begin refresh");
                    gVar.tUq = true;
                    gVar.tXj = new ch(null, gVar.ttO);
                    com.tencent.mm.kernel.g.azz().b(gVar.tXj);
                }
            }
            AppMethodBeat.o(254915);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int toZ = 61;
        final /* synthetic */ ArrayList woM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ArrayList arrayList) {
            super(0);
            this.woM = arrayList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254916);
            ArrayList<y> arrayList = this.woM;
            ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(arrayList, 10));
            for (y yVar : arrayList) {
                com.tencent.mm.plugin.finder.report.s sVar = com.tencent.mm.plugin.finder.report.s.vhF;
                arrayList2.add(com.tencent.mm.plugin.finder.report.s.a(yVar.uOo.id, yVar.uOo.sessionBuffer, this.toZ));
            }
            bbn bbn = new bbn();
            bbn.tCE = this.toZ;
            com.tencent.mm.plugin.finder.report.s sVar2 = com.tencent.mm.plugin.finder.report.s.vhF;
            com.tencent.mm.plugin.finder.report.s.a(arrayList2, bbn, 0);
            x xVar = x.SXb;
            AppMethodBeat.o(254916);
            return xVar;
        }
    }
}
