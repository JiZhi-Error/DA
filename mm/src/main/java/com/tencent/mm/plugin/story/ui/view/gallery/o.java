package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import com.facebook.appevents.codeless.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.h.b;
import com.tencent.mm.plugin.story.h.c;
import com.tencent.mm.plugin.story.i.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R2\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\t0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgrPreLoad;", "", "()V", "TAG", "", "pool", "", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "kotlin.jvm.PlatformType", "", "clean", "", "get", "preload", "", ch.COL_USERNAME, "plugin-story_release"})
public final class o {
    private static List<n> FIp = Collections.synchronizedList(new LinkedList());
    public static final o FIq = new o();

    static {
        AppMethodBeat.i(120668);
        AppMethodBeat.o(120668);
    }

    private o() {
    }

    public static boolean aSH(String str) {
        AppMethodBeat.i(120665);
        p.h(str, ch.COL_USERNAME);
        Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "preLoad " + str + " pool " + FIp.size());
        if (FIp.size() > 0) {
            k kVar = k.FmH;
            f aRS = k.aRS(str);
            if (aRS.isValid()) {
                h.a aVar = h.FoY;
                h a2 = h.a.a(aRS);
                List<n> list = FIp;
                p.g(list, "pool");
                n nVar = (n) j.kt(list);
                if (nVar != null) {
                    nVar.a(a2.FoT, false);
                }
            }
            AppMethodBeat.o(120665);
            return false;
        }
        k kVar2 = k.FmH;
        f aRS2 = k.aRS(str);
        c cVar = c.Fuf;
        c.Kn(aRS2.field_syncId);
        b bVar = b.FtL;
        b.Kn(aRS2.field_syncId);
        if (aRS2.fry() > 0) {
            b bVar2 = b.FtL;
            b.fpM();
        }
        if (aRS2.isValid()) {
            h.a aVar2 = h.FoY;
            h a3 = h.a.a(aRS2);
            b bVar3 = b.FtL;
            p.h(a3, "galleryItem");
            p.h(aRS2, Constants.EXTINFO);
            b.FtC = a3;
            b.Fty = new b.a(aRS2.getUserName(), b.EnumC1767b.PLAY);
            if (aRS2.fry() > 0) {
                b.e(b.oIi, 4, 1);
                b.a aVar3 = b.Fty;
                if (aVar3 != null) {
                    aVar3.qeT = false;
                    aVar3.FtQ = Util.nowMilliSecond();
                }
            } else {
                b.a aVar4 = b.Fty;
                if (aVar4 != null) {
                    aVar4.qeT = true;
                    aVar4.FtQ = Util.nowMilliSecond();
                }
            }
            if (a3.FoT != null) {
                if (aRS2.frA()) {
                    b.e(b.oIi, 140, 1);
                    if (aRS2.fry() > 0) {
                        b.e(b.oIi, 142, 1);
                    }
                }
                if (b.d(a3.FoT) == 1) {
                    b.e(b.oIi, 5, 1);
                    if (aRS2.frA()) {
                        b.e(b.oIi, 141, 1);
                    }
                }
            }
            n nVar2 = new n();
            if (nVar2.FIc == null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                nVar2.hm(context);
            }
            nVar2.setMute(true);
            nVar2.a(a3.FoT, false);
            nVar2.PF();
            FIp.add(nVar2);
            AppMethodBeat.o(120665);
            return true;
        }
        AppMethodBeat.o(120665);
        return false;
    }

    public static n fsK() {
        AppMethodBeat.i(120666);
        Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad get " + FIp.size());
        List<n> list = FIp;
        p.g(list, "pool");
        n nVar = (n) j.kt(list);
        if (nVar != null) {
            FIp.remove(nVar);
        }
        AppMethodBeat.o(120666);
        return nVar;
    }

    public static void clean() {
        AppMethodBeat.i(120667);
        Log.i("MicroMsg.StoryVideoViewMgrPreLoad", "StoryVideoViewMgrPreLoad clean " + FIp.size());
        List<n> list = FIp;
        p.g(list, "pool");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            StoryVideoView storyVideoView = it.next().FIc;
            if (storyVideoView != null) {
                storyVideoView.stop();
            }
        }
        FIp.clear();
        AppMethodBeat.o(120667);
    }
}
