package com.tencent.mm.plugin.recordvideo.activity.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.b.a.Cif;
import com.tencent.mm.plugin.recordvideo.activity.MMRecordUI;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.RecordPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\t2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J \u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J+\u0010%\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\t2\u000e\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*¢\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u0018J\u001a\u0010-\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014X\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter;", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "toWhere", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;I)V", "currentRouter", "currentView", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "enableRecordPage", "", "isFinishing", "getProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "viewMap", "Landroid/util/SparseArray;", "viewTable", "Ljava/lang/Class;", "finish", "", "loadViewFromClass", "key", "clazz", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "scene", "onDestroy", "onPause", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", TencentExtraKeys.LOCATION_KEY_ROUTE, "model", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "Companion", "plugin-recordvideo_release"})
public final class b implements com.tencent.mm.plugin.recordvideo.activity.a {
    public static final a BJA = new a((byte) 0);
    public BasePluginLayout BJw;
    private boolean BJx;
    private int BJy = -2;
    private final RecordConfigProvider BJz;
    private final Context context;
    private final SparseArray<Class<?>> hwn = new SparseArray<>();
    private final SparseArray<BasePluginLayout> hwo = new SparseArray<>();
    private final ViewGroup hwr;
    public boolean isFinishing;

    static {
        AppMethodBeat.i(75075);
        AppMethodBeat.o(75075);
    }

    public static final int q(List<String> list, List<String> list2) {
        AppMethodBeat.i(75077);
        int c2 = a.c(-1, list, list2);
        AppMethodBeat.o(75077);
        return c2;
    }

    public b(Context context2, ViewGroup viewGroup, RecordConfigProvider recordConfigProvider, int i2) {
        p.h(context2, "context");
        p.h(viewGroup, "root");
        p.h(recordConfigProvider, "provider");
        AppMethodBeat.i(75074);
        this.context = context2;
        this.hwr = viewGroup;
        this.BJz = recordConfigProvider;
        Log.i("MicroMsg.RecordUIRouter", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.hwn.put(0, RecordPluginLayout.class);
        this.hwn.put(1, EditPhotoPluginLayout.class);
        this.hwn.put(2, EditorVideoPluginLayoutNew.class);
        HashMap hashMap = this.BJz.hwc;
        p.g(hashMap, "routerMap");
        if (!hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                StringBuilder sb = new StringBuilder("add route key:");
                Object key = entry.getKey();
                if (key == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(75074);
                    throw tVar;
                }
                Log.i("MicroMsg.RecordUIRouter", sb.append(((Integer) key).intValue()).append(" value:").append(entry.getValue()).toString());
                SparseArray<Class<?>> sparseArray = this.hwn;
                Object key2 = entry.getKey();
                if (key2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                    AppMethodBeat.o(75074);
                    throw tVar2;
                }
                int intValue = ((Integer) key2).intValue();
                Object value = entry.getValue();
                if (value == null) {
                    t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(75074);
                    throw tVar3;
                }
                sparseArray.put(intValue, Class.forName((String) value));
            }
        }
        g gVar = g.BXY;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (g.BXW != 0) {
            Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReport In setInitRouterTImeStamp");
            g.BXV.vQ(g.eLg());
            g.BXV.bfK();
        }
        Log.i("MicroMsg.VideoWidgetReporter", "videoWidgetReporter doReset");
        g.BXV = new Cif();
        g.BXX.clear();
        g.BXW = elapsedRealtime;
        g.BXV.qY(elapsedRealtime);
        g gVar2 = g.BXY;
        g.g(this.hwn);
        if (i2 == 0) {
            this.BJx = true;
            Class<?> cls = this.hwn.get(0);
            p.g(cls, "viewTable[KEY_TO_RECORD]");
            e(0, cls);
        }
        Log.i("MicroMsg.RecordUIRouter", "setEnableRecordPage " + this.BJx);
        AppMethodBeat.o(75074);
    }

    public static final /* synthetic */ void a(b bVar, int i2, Class cls) {
        AppMethodBeat.i(75076);
        bVar.e(i2, cls);
        AppMethodBeat.o(75076);
    }

    @Override // com.tencent.mm.plugin.recordvideo.activity.a
    public final void a(int i2, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2 = null;
        AppMethodBeat.i(75072);
        if (this.isFinishing) {
            Log.i("MicroMsg.RecordUIRouter", "isFinishing toWhere:" + i2 + "  MediaCaptureInfo:" + bVar);
            AppMethodBeat.o(75072);
            return;
        }
        if (bVar != null) {
            arrayList = bVar.iqm;
        } else {
            arrayList = null;
        }
        ArrayList<String> arrayList3 = arrayList;
        if (bVar != null) {
            arrayList2 = bVar.iqn;
        }
        int c2 = a.c(i2, arrayList3, arrayList2);
        Log.i("MicroMsg.RecordUIRouter", "toWhere:" + i2 + " real:" + c2 + " current:" + this.BJy + " MediaCaptureInfo:" + bVar);
        if (c2 == this.BJy) {
            AppMethodBeat.o(75072);
            return;
        }
        this.BJy = c2;
        MMHandlerThread.postToMainThread(new d(this, c2, bVar, i2));
        AppMethodBeat.o(75072);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ b BJB;
        final /* synthetic */ int BJC;
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.b.b BJD;
        final /* synthetic */ int BJE;

        d(b bVar, int i2, com.tencent.mm.media.widget.camerarecordview.b.b bVar2, int i3) {
            this.BJB = bVar;
            this.BJC = i2;
            this.BJD = bVar2;
            this.BJE = i3;
        }

        public final void run() {
            AppMethodBeat.i(75071);
            if (this.BJC != 0 || this.BJB.BJx) {
                if (this.BJB.hwo.get(this.BJC) == null) {
                    if (this.BJB.hwn.get(this.BJC) == null) {
                        Log.e("MicroMsg.RecordUIRouter", "No corresponding " + this.BJC);
                        AppMethodBeat.o(75071);
                        return;
                    }
                    Object obj = this.BJB.hwn.get(this.BJC);
                    if (obj == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.Class<*>");
                        AppMethodBeat.o(75071);
                        throw tVar;
                    }
                    Class cls = (Class) obj;
                    Log.i("MicroMsg.RecordUIRouter", "create BasePluginLayout :" + cls.getSimpleName());
                    b.a(this.BJB, this.BJC, cls);
                }
                BasePluginLayout basePluginLayout = this.BJB.BJw;
                this.BJB.BJw = (BasePluginLayout) this.BJB.hwo.get(this.BJC);
                BasePluginLayout basePluginLayout2 = this.BJB.BJw;
                if (basePluginLayout2 != null) {
                    basePluginLayout2.a(this.BJD);
                }
                BasePluginLayout basePluginLayout3 = this.BJB.BJw;
                if (basePluginLayout3 != null) {
                    basePluginLayout3.bringToFront();
                }
                if (basePluginLayout != null) {
                    basePluginLayout.onPause();
                }
                if (basePluginLayout != null) {
                    basePluginLayout.onDetach();
                }
                switch (this.BJC) {
                    case 1:
                        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                        break;
                    case 2:
                        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                        break;
                    case 3:
                        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.VI(19);
                        com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EXIT_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
                        break;
                }
                g gVar = g.BXY;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Object obj2 = this.BJB.hwn.get(this.BJE);
                p.g(obj2, "viewTable.get(toWhere)");
                String simpleName = ((Class) obj2).getSimpleName();
                p.g(simpleName, "viewTable.get(toWhere).simpleName");
                g.F(elapsedRealtime, simpleName);
                AppMethodBeat.o(75071);
                return;
            }
            Context context = this.BJB.context;
            if (context == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.activity.MMRecordUI");
                AppMethodBeat.o(75071);
                throw tVar2;
            }
            ((MMRecordUI) context).finish();
            AppMethodBeat.o(75071);
        }
    }

    private final void e(int i2, Class<?> cls) {
        AppMethodBeat.i(75073);
        try {
            Constructor<?> constructor = cls.getConstructor(Context.class, AttributeSet.class);
            p.g(constructor, "clazz.getConstructor(Con…AttributeSet::class.java)");
            Object newInstance = constructor.newInstance(this.context, null);
            if (newInstance == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout");
                AppMethodBeat.o(75073);
                throw tVar;
            }
            BasePluginLayout basePluginLayout = (BasePluginLayout) newInstance;
            basePluginLayout.a(this, this.BJz);
            this.hwo.put(i2, basePluginLayout);
            this.hwr.addView(basePluginLayout, new ViewGroup.LayoutParams(-1, -1));
            basePluginLayout.setVisibility(8);
            AppMethodBeat.o(75073);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.RecordUIRouter", e2, "", new Object[0]);
            AppMethodBeat.o(75073);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b BJB;

        public c(b bVar) {
            this.BJB = bVar;
        }

        public final void run() {
            AppMethodBeat.i(75070);
            int size = this.BJB.hwo.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((BasePluginLayout) this.BJB.hwo.valueAt(i2)).release();
            }
            AppMethodBeat.o(75070);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.activity.a.b$b  reason: collision with other inner class name */
    public static final class RunnableC1635b implements Runnable {
        final /* synthetic */ b BJB;

        public RunnableC1635b(b bVar) {
            this.BJB = bVar;
        }

        public final void run() {
            AppMethodBeat.i(75069);
            int size = this.BJB.hwo.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((BasePluginLayout) this.BJB.hwo.valueAt(i2)).onDetach();
            }
            AppMethodBeat.o(75069);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/activity/controller/RecordUIRouter$Companion;", "", "()V", "TAG", "", "autoRoute", "", "toWhere", "photoList", "", "videoList", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static int c(int i2, List<String> list, List<String> list2) {
            int size;
            boolean z;
            int size2;
            AppMethodBeat.i(75068);
            if (-1 == i2) {
                List<String> list3 = list;
                if (list3 == null || list3.isEmpty()) {
                    size = 0;
                } else {
                    if (list == null) {
                        p.hyc();
                    }
                    size = list.size();
                }
                List<String> list4 = list2;
                if (list4 == null || list4.isEmpty()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    size2 = 0;
                } else {
                    if (list2 == null) {
                        p.hyc();
                    }
                    size2 = list2.size();
                }
                if (size <= 2 && size2 == 0) {
                    AppMethodBeat.o(75068);
                    return 1;
                } else if (size > 2 && size2 == 0) {
                    AppMethodBeat.o(75068);
                    return 3;
                } else if ((size > 0 && size2 > 0) || size2 > 1 || size > 1) {
                    AppMethodBeat.o(75068);
                    return 4;
                } else if (size == 0 && size2 == 1) {
                    AppMethodBeat.o(75068);
                    return 2;
                } else {
                    AppMethodBeat.o(75068);
                    return 0;
                }
            } else {
                AppMethodBeat.o(75068);
                return i2;
            }
        }
    }
}
