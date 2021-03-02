package com.tencent.mm.plugin.recordvideo.background;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004J\u001e\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/BgMixManager;", "", "()V", "TAG", "", "callbacks", "Landroid/util/SparseArray;", "", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "getCallbacks", "()Landroid/util/SparseArray;", "addCallback", "", "scene", "", "callback", "getFakeImageToVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "context", "Landroid/content/Context;", "getFakeVideoLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "notifyFinish", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "notifyInit", "notifyRun", "runNum", "notifyWait", "removeCallback", "plugin-recordvideo_release"})
public final class a {
    public static final a BKb = new a();
    private static final SparseArray<Set<b>> zwK = new SparseArray<>();

    static {
        AppMethodBeat.i(75166);
        AppMethodBeat.o(75166);
    }

    private a() {
    }

    public static SparseArray<Set<b>> eIG() {
        return zwK;
    }

    public static void a(int i2, b bVar) {
        AppMethodBeat.i(75158);
        p.h(bVar, "callback");
        LinkedHashSet linkedHashSet = zwK.get(i2);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet();
            zwK.put(i2, linkedHashSet);
        }
        linkedHashSet.add(bVar);
        AppMethodBeat.o(75158);
    }

    public static void b(int i2, b bVar) {
        AppMethodBeat.i(75159);
        p.h(bVar, "callback");
        Set<b> set = zwK.get(i2);
        if (set != null) {
            set.remove(bVar);
        }
        if (set != null) {
            if (set.isEmpty()) {
                zwK.remove(i2);
            }
            AppMethodBeat.o(75159);
            return;
        }
        AppMethodBeat.o(75159);
    }

    public static void bT(int i2, String str) {
        AppMethodBeat.i(75160);
        p.h(str, "taskId");
        Log.i("MicroMsg.mix_background.BgMixManager", "notifyInit, taskId:".concat(String.valueOf(str)));
        h.RTc.b(new b(i2, str), "BgMixManager_notifyInit");
        AppMethodBeat.o(75160);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ String BKc;

        b(int i2, String str) {
            this.$scene = i2;
            this.BKc = str;
        }

        public final void run() {
            AppMethodBeat.i(75155);
            a aVar = a.BKb;
            Set<b> set = a.eIG().get(this.$scene);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    it.next().aAd(this.BKc);
                }
                AppMethodBeat.o(75155);
                return;
            }
            AppMethodBeat.o(75155);
        }
    }

    public static void p(int i2, String str, int i3) {
        AppMethodBeat.i(75161);
        p.h(str, "taskId");
        Log.i("MicroMsg.mix_background.BgMixManager", "notifyRun, taskId:" + str + ", runNum:" + i3);
        h.RTc.b(new c(i2, str, i3), "BgMixManager_notifyRun");
        AppMethodBeat.o(75161);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ String BKc;
        final /* synthetic */ int BKe;

        c(int i2, String str, int i3) {
            this.$scene = i2;
            this.BKc = str;
            this.BKe = i3;
        }

        public final void run() {
            AppMethodBeat.i(75156);
            a aVar = a.BKb;
            Set<b> set = a.eIG().get(this.$scene);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    it.next().eh(this.BKc, this.BKe);
                }
                AppMethodBeat.o(75156);
                return;
            }
            AppMethodBeat.o(75156);
        }
    }

    public static void bU(int i2, String str) {
        AppMethodBeat.i(75162);
        p.h(str, "taskId");
        Log.i("MicroMsg.mix_background.BgMixManager", "notifyWait, taskId:".concat(String.valueOf(str)));
        h.RTc.b(new d(i2, str), "BgMixManager_notifyWait");
        AppMethodBeat.o(75162);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ String BKc;

        d(int i2, String str) {
            this.$scene = i2;
            this.BKc = str;
        }

        public final void run() {
            AppMethodBeat.i(75157);
            a aVar = a.BKb;
            Set<b> set = a.eIG().get(this.$scene);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    it.next().aAe(this.BKc);
                }
                AppMethodBeat.o(75157);
                return;
            }
            AppMethodBeat.o(75157);
        }
    }

    public static void a(int i2, String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
        AppMethodBeat.i(75163);
        p.h(str, "taskId");
        Log.i("MicroMsg.mix_background.BgMixManager", "notifyFinish, taskId:" + str + ", success:" + z + ", model:" + captureVideoNormalModel);
        h.RTc.b(new RunnableC1640a(i2, str, z, captureVideoNormalModel), "BgMixManager_notifyFinish");
        AppMethodBeat.o(75163);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.background.a$a  reason: collision with other inner class name */
    static final class RunnableC1640a implements Runnable {
        final /* synthetic */ int $scene;
        final /* synthetic */ boolean $success;
        final /* synthetic */ String BKc;
        final /* synthetic */ CaptureDataManager.CaptureVideoNormalModel BKd;

        RunnableC1640a(int i2, String str, boolean z, CaptureDataManager.CaptureVideoNormalModel captureVideoNormalModel) {
            this.$scene = i2;
            this.BKc = str;
            this.$success = z;
            this.BKd = captureVideoNormalModel;
        }

        public final void run() {
            AppMethodBeat.i(75154);
            a aVar = a.BKb;
            Set<b> set = a.eIG().get(this.$scene);
            if (set != null) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    it.next().a(this.BKc, this.$success, this.BKd);
                }
                AppMethodBeat.o(75154);
                return;
            }
            AppMethodBeat.o(75154);
        }
    }

    public static FakeVideoViewLayer gN(Context context) {
        AppMethodBeat.i(75164);
        if (context != null) {
            FakeVideoViewLayer fakeVideoViewLayer = new FakeVideoViewLayer(context);
            AppMethodBeat.o(75164);
            return fakeVideoViewLayer;
        }
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        FakeVideoViewLayer fakeVideoViewLayer2 = new FakeVideoViewLayer(context2);
        AppMethodBeat.o(75164);
        return fakeVideoViewLayer2;
    }

    public static f gO(Context context) {
        AppMethodBeat.i(75165);
        if (context != null) {
            f fVar = new f(context);
            AppMethodBeat.o(75165);
            return fVar;
        }
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        f fVar2 = new f(context2);
        AppMethodBeat.o(75165);
        return fVar2;
    }
}
