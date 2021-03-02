package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.aw;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyExtStatsReport;", "", "()V", "TAG", "", "sendExtStatsReport", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feedActionValue", "", "plugin-finder_release"})
public final class a {
    public static final a uSY = new a();

    static {
        AppMethodBeat.i(249332);
        AppMethodBeat.o(249332);
    }

    private a() {
    }

    public static void a(bbn bbn, bo boVar) {
        int i2;
        LinkedList<cjl> mediaList;
        cjl cjl;
        AppMethodBeat.i(249331);
        p.h(bbn, "contextObj");
        p.h(boVar, "feed");
        if (!(boVar instanceof BaseFinderFeed)) {
            AppMethodBeat.o(249331);
            return;
        }
        BaseFinderFeed baseFinderFeed = (BaseFinderFeed) boVar;
        alc alc = new alc();
        alc.hFK = baseFinderFeed.lT();
        alc.finderUsername = baseFinderFeed.feedObject.getUserName();
        k kVar = k.vfA;
        alc.sessionBuffer = k.G(baseFinderFeed.lT(), bbn.tCE);
        e.a aVar = e.vdS;
        alc.Lub = e.a.ah(ae.b(s.U("feedActionType", 18)));
        FinderItem finderItem = baseFinderFeed.feedObject;
        if (finderItem == null || (mediaList = finderItem.getMediaList()) == null || (cjl = (cjl) j.kt(mediaList)) == null) {
            i2 = 0;
        } else {
            i2 = cjl.videoDuration;
        }
        alc.videoDuration = i2;
        alc.mediaType = baseFinderFeed.feedObject.getMediaType();
        Log.i("NearbyExtStatsReport", "sendExtStatsReport " + d.zs(alc.hFK));
        g.azz().b(new aw(bbn, alc));
        AppMethodBeat.o(249331);
    }
}
