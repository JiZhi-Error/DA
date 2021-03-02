package com.tencent.mm.plugin.expt.hellhound.core.b.b.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.d;
import com.tencent.mm.plugin.expt.hellhound.core.b.c.e;
import com.tencent.mm.protocal.protobuf.erd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static b sAn;
    public int mRl = -1;
    private final c sAd = new c() {
        /* class com.tencent.mm.plugin.expt.hellhound.core.b.b.a.b.AnonymousClass1 */

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(184336);
            if ("onPostOpen".equals(str2)) {
                if (objArr.length > 0) {
                    Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostOpen: %b", objArr[0]);
                    b.a(b.this, 0, System.currentTimeMillis());
                    b.e(obj, true);
                    AppMethodBeat.o(184336);
                    return;
                }
            } else if ("onPostClose".equals(str2)) {
                Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, onPostClose:");
                b.a(b.this, 1, System.currentTimeMillis());
                b.e(obj, false);
            }
            AppMethodBeat.o(184336);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    };
    private a sAo;
    private final Map<String, Map<String, List<Pair<String, String>>>> sAp;

    static /* synthetic */ void a(b bVar, int i2, long j2) {
        AppMethodBeat.i(184339);
        bVar.Y(i2, j2);
        AppMethodBeat.o(184339);
    }

    private void Y(int i2, long j2) {
        AppMethodBeat.i(184337);
        this.mRl = i2;
        if (this.sAo != null) {
            this.sAo.X(i2, j2);
        }
        AppMethodBeat.o(184337);
    }

    public static b cOl() {
        AppMethodBeat.i(122022);
        if (sAn == null) {
            synchronized (b.class) {
                try {
                    if (sAn == null) {
                        sAn = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122022);
                    throw th;
                }
            }
        }
        b bVar = sAn;
        AppMethodBeat.o(122022);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(177362);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("onPostOpen", "(Z)V"));
        arrayList.add(Pair.create("onPostClose", "()V"));
        HashMap hashMap = new HashMap();
        hashMap.put("com/tencent/mm/ui/widget/listview/PullDownListView$IPullDownCallback", arrayList);
        this.sAp = new HashMap();
        this.sAp.put("com/tencent/mm/ui/MoreTabUI$", hashMap);
        AppMethodBeat.o(177362);
    }

    public final void a(FragmentActivity fragmentActivity, a aVar) {
        AppMethodBeat.i(122023);
        if (!a.cNo()) {
            Log.w("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, startHook, fetchHellhoundConfig: FALSE");
            AppMethodBeat.o(122023);
            return;
        }
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook");
        Fragment c2 = h.c(fragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
        if (c2 == null) {
            Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook: curFragment == null");
            AppMethodBeat.o(122023);
            return;
        }
        String canonicalName = c2.getClass().getCanonicalName();
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook-2: %s", canonicalName);
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(canonicalName)) {
            Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook Fail: %s", canonicalName);
            AppMethodBeat.o(122023);
            return;
        }
        this.sAo = aVar;
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor startHook real: %s", canonicalName);
        cOm();
        AppMethodBeat.o(122023);
    }

    private void cOm() {
        AppMethodBeat.i(177363);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.e(this.sAp, this.sAd);
        AppMethodBeat.o(177363);
    }

    public final void e(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(122024);
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, endHook");
        Fragment c2 = h.c(fragmentActivity, com.tencent.mm.plugin.expt.hellhound.core.b.syZ);
        if (c2 == null) {
            Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor, curFragment == null");
            AppMethodBeat.o(122024);
            return;
        }
        String canonicalName = c2.getClass().getCanonicalName();
        if (!com.tencent.mm.plugin.expt.hellhound.core.b.syZ.equals(canonicalName)) {
            Log.e("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook FALSE: %s", canonicalName);
            AppMethodBeat.o(122024);
            return;
        }
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "StoryGalleryMonitor endHook real: %s", canonicalName);
        com.tencent.mm.hellhoundlib.a.axP();
        com.tencent.mm.hellhoundlib.a.f(this.sAp, this.sAd);
        AppMethodBeat.o(122024);
    }

    public final void af(String str, long j2) {
        AppMethodBeat.i(184338);
        Log.i("HABBYGE-MALI.StoryGalleryMonitor", "_finishMMFecordUI: %s", str);
        if ("com.tencent.mm.plugin.recordvideo.activity.MMRecordUI".equals(str)) {
            Y(1, j2);
        }
        AppMethodBeat.o(184338);
    }

    public static int GU(int i2) {
        if (i2 == 0) {
            return 300;
        }
        if (i2 == 1) {
            return 301;
        }
        return -1;
    }

    public static int GV(int i2) {
        if (i2 == 300) {
            return 0;
        }
        if (i2 == 301) {
            return 1;
        }
        return -1;
    }

    static /* synthetic */ void e(Object obj, boolean z) {
        AppMethodBeat.i(220449);
        erd erd = new erd();
        erd.id = z ? "onStoryOpen" : "onStoryClose";
        erd.timestamp = System.currentTimeMillis();
        erd.NoL = erd.id;
        Fragment apm = h.apm("com.tencent.mm.ui.LauncherUI");
        erd.dMl = apm == null ? "MoreTabUI" : apm.getClass().getSimpleName();
        erd.NoN = apm == null ? -1 : apm.hashCode();
        erd.typeName = erd.dMl;
        erd.NoM = obj == null ? erd.dMl : obj.getClass().getName();
        erd.eventId = d.GLIDE.value;
        erd.type = 0;
        e eVar = e.sAU;
        e.a(erd);
        AppMethodBeat.o(220449);
    }
}
