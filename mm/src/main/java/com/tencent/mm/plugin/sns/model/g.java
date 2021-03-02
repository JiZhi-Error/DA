package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ac;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public final class g implements com.tencent.mm.plugin.sns.b.g {
    private static int DHs = 0;
    public boolean DGJ = true;
    private long DGV = 0;
    private long DGW = 0;
    com.tencent.mm.memory.a.b<n> DGX;
    private ap<String, WeakReference<Bitmap>> DGY;
    private Map<String, LinkedList<WeakReference<c>>> DGZ = new HashMap();
    private ConcurrentHashMap<Integer, String> DHa = new ConcurrentHashMap<>();
    private LinkedList<b> DHb = new LinkedList<>();
    private boolean DHc = false;
    private HashSet<c> DHd = new HashSet<>();
    public HashMap<String, Integer> DHe = new HashMap<>();
    private int DHf = 4;
    public ac DHg;
    public long DHh = 0;
    public long DHi = 0;
    private int DHj = 0;
    private int DHk = 0;
    private HashMap<Long, Integer> DHl = new HashMap<>();
    private HashMap<Integer, Boolean> DHm = new HashMap<>();
    private HashMap<Integer, Boolean> DHn = new HashMap<>();
    private int DHo = 0;
    private int DHp = 0;
    private HashMap<Long, Integer> DHq = new HashMap<>();
    protected Set<String> DHr = new HashSet();
    private Map<Integer, WeakReference<Object>> iXZ = new HashMap();

    public interface d {
        void f(Bitmap bitmap, String str);
    }

    public interface e {
        void ax(Bitmap bitmap);
    }

    static /* synthetic */ void a(g gVar, Object obj, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(95553);
        gVar.a(obj, str, i2, i3, i4);
        AppMethodBeat.o(95553);
    }

    static /* synthetic */ boolean a(g gVar, String str, n nVar) {
        AppMethodBeat.i(95552);
        boolean a2 = gVar.a(str, nVar);
        AppMethodBeat.o(95552);
        return a2;
    }

    static /* synthetic */ int etv() {
        int i2 = DHs;
        DHs = i2 + 1;
        return i2;
    }

    static /* synthetic */ int faf() {
        int i2 = DHs;
        DHs = i2 - 1;
        return i2;
    }

    static /* synthetic */ boolean g(g gVar) {
        AppMethodBeat.i(95551);
        boolean fae = gVar.fae();
        AppMethodBeat.o(95551);
        return fae;
    }

    public enum a {
        IMG_SCENE_NONE,
        IMG_SCENE_SNSUSER;

        public static a valueOf(String str) {
            AppMethodBeat.i(95472);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(95472);
            return aVar;
        }

        static {
            AppMethodBeat.i(95473);
            AppMethodBeat.o(95473);
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void start() {
        AppMethodBeat.i(95481);
        this.DGJ = true;
        fae();
        c faJ = aj.faJ();
        faJ.DGJ = true;
        faJ.bck();
        AppMethodBeat.o(95481);
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void pause() {
        AppMethodBeat.i(95482);
        this.DGJ = false;
        c faJ = aj.faJ();
        faJ.DGJ = false;
        synchronized (faJ.mLock) {
            try {
                LinkedList linkedList = new LinkedList();
                Iterator<o> it = faJ.gCs.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next.requestType != 6) {
                        faJ.DGM.remove(next.key);
                        linkedList.add(next);
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    faJ.gCs.remove((o) it2.next());
                }
                faJ.DGN.clear();
                faJ.DGO.clear();
            } finally {
                AppMethodBeat.o(95482);
            }
        }
    }

    public g() {
        int i2;
        AppMethodBeat.i(95483);
        com.tencent.mm.memory.a.b.a(n.class, new b.a<n>() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.memory.a.b.a
            public final /* synthetic */ int bX(n nVar) {
                AppMethodBeat.i(95455);
                n nVar2 = nVar;
                if (nVar2 == null) {
                    AppMethodBeat.o(95455);
                    return 0;
                }
                int allocationByteCount = nVar2.getAllocationByteCount();
                AppMethodBeat.o(95455);
                return allocationByteCount;
            }
        });
        int largeMemoryClass = ((ActivityManager) MMApplicationContext.getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass();
        Log.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", Integer.valueOf(largeMemoryClass));
        if (largeMemoryClass > 256) {
            i2 = 62914560;
        } else {
            i2 = 31457280;
        }
        this.DGX = new com.tencent.mm.memory.a.b<>(i2, new f.b<String, n>() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f.b
            public final /* synthetic */ void c(String str, n nVar, n nVar2) {
                String aSf;
                String aSf2;
                AppMethodBeat.i(95462);
                String str2 = str;
                n nVar3 = nVar;
                n nVar4 = nVar2;
                if (nVar3 != null && !nVar3.isRecycled() && !nVar3.equals(nVar4)) {
                    nVar3.aSc();
                }
                int i2 = 0;
                if (nVar4 != null) {
                    i2 = nVar4.getAllocationByteCount();
                }
                StringBuilder append = new StringBuilder(" key: ").append(str2).append(" result:").append(i2).append(" ").append(nVar3.bitmap.getRowBytes() * nVar3.bitmap.getHeight()).append(" ").append(nVar3.bitmap.getWidth()).append(" ").append(nVar3.bitmap.getHeight()).append(" oldValue ");
                if (nVar3 == null) {
                    aSf = "NULL";
                } else {
                    aSf = nVar3.aSf();
                }
                StringBuilder append2 = append.append(aSf).append(" newValue: ");
                if (nVar4 == null) {
                    aSf2 = "NULL";
                } else {
                    aSf2 = nVar4.aSf();
                }
                Log.d("MicroMsg.LazyerImageLoader2", append2.append(aSf2).toString());
                AppMethodBeat.o(95462);
            }
        }, getClass());
        this.DGY = new ap<>(this.DHf, new ap.a() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.sns.model.ap.a
            public final boolean dQ(Object obj) {
                boolean z;
                OO oo;
                AppMethodBeat.i(95463);
                String str = (String) obj;
                if (g.a(g.this, str)) {
                    ap apVar = g.this.DGY;
                    try {
                        OO oo2 = apVar.DMl.get(str).obj;
                        if (oo2 instanceof Bitmap) {
                            oo = oo2;
                        } else {
                            OO oo3 = apVar.DMl.get(str).obj;
                            if (oo3 != null) {
                                oo = (Bitmap) oo3.get();
                            } else {
                                oo = null;
                            }
                        }
                        if (oo != null && !oo.isRecycled()) {
                            Log.d("MicroMsg.SnsLRUMap", "remove key:".concat(String.valueOf(str)));
                            oo.recycle();
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SnsLRUMap", e2, "", new Object[0]);
                        Log.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
                    }
                    int size = apVar.DMl.size();
                    ap<K, O>.b remove = apVar.DMl.remove(str);
                    StringBuilder append = new StringBuilder("internalMap ").append(apVar.DMl.size()).append(" bfSize :").append(size).append(" o == null ");
                    if (remove != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Log.d("MicroMsg.SnsLRUMap", append.append(z).toString());
                    Log.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + g.this.DGY.DMl.size() + " listPaitSize:" + g.this.DHd.size());
                    AppMethodBeat.o(95463);
                    return true;
                }
                AppMethodBeat.o(95463);
                return false;
            }
        });
        AppMethodBeat.o(95483);
    }

    public final void fad() {
        AppMethodBeat.i(95484);
        if (this.DGX != null) {
            this.iXZ.clear();
            this.DGY.DMl.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.DGX.putCount() + ";");
            stringBuffer.append("missCount:" + this.DGX.missCount() + ";");
            stringBuffer.append("hitCount:" + this.DGX.hitCount() + ";");
            stringBuffer.append("createCount:" + this.DGX.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.DGX.evictionCount() + ";");
            Log.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.DGX.trimToSize(-1);
        }
        this.DGY.fbt();
        System.gc();
        AppMethodBeat.o(95484);
    }

    private boolean ax(View view, int i2) {
        AppMethodBeat.i(95485);
        if (view.hashCode() == i2) {
            AppMethodBeat.o(95485);
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!ax(viewGroup.getChildAt(childCount), i2));
            AppMethodBeat.o(95485);
            return true;
        }
        AppMethodBeat.o(95485);
        return false;
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void aI(Activity activity) {
        AppMethodBeat.i(95486);
        Log.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.iXZ.size());
        LinkedList<Integer> linkedList = new LinkedList();
        Iterator<c> it = this.DHd.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (ax(activity.getWindow().getDecorView(), next.code)) {
                linkedList.add(Integer.valueOf(next.code));
            }
        }
        for (Integer num : linkedList) {
            int intValue = num.intValue();
            this.iXZ.remove(Integer.valueOf(intValue));
            Iterator<c> it2 = this.DHd.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                c next2 = it2.next();
                if (next2.code == intValue) {
                    this.DHd.remove(next2);
                    break;
                }
            }
        }
        linkedList.clear();
        Iterator<c> it3 = this.DHd.iterator();
        while (it3.hasNext()) {
            c next3 = it3.next();
            if (next3.DHT == activity.hashCode()) {
                linkedList.add(Integer.valueOf(next3.code));
            }
        }
        for (Integer num2 : linkedList) {
            int intValue2 = num2.intValue();
            this.iXZ.remove(Integer.valueOf(intValue2));
            Iterator<c> it4 = this.DHd.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                c next4 = it4.next();
                if (next4.code == intValue2) {
                    this.DHd.remove(next4);
                    break;
                }
            }
        }
        this.DGY.fbt();
        Log.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.iXZ.size());
        AppMethodBeat.o(95486);
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void ff(View view) {
        AppMethodBeat.i(95487);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
            AppMethodBeat.o(95487);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
            AppMethodBeat.o(95487);
        } else {
            AppMethodBeat.o(95487);
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final Bitmap b(cnb cnb) {
        n aOq;
        AppMethodBeat.i(95488);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95488);
            return null;
        }
        String cq = r.cq(1, cnb.Id);
        n aOV = aOV(cq);
        if (r.b(aOV)) {
            Bitmap aSa = aOV.aSa();
            AppMethodBeat.o(95488);
            return aSa;
        }
        String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb);
        if (s.YS(str)) {
            if (cnb.Id.startsWith("pre_temp_extend_pic")) {
                aOq = n.H(com.tencent.mm.plugin.sns.storage.r.aQG(str));
            } else {
                aOq = r.aOq(str);
            }
            if (r.b(aOq)) {
                a(cq, aOq);
                Bitmap aSa2 = aOq.aSa();
                AppMethodBeat.o(95488);
                return aSa2;
            }
            AppMethodBeat.o(95488);
            return null;
        }
        AppMethodBeat.o(95488);
        return null;
    }

    public static String r(cnb cnb) {
        AppMethodBeat.i(95489);
        String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb);
        AppMethodBeat.o(95489);
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void b(cnb cnb, View view, int i2, bp bpVar) {
        AppMethodBeat.i(95490);
        a(cnb, view, -1, i2, bpVar);
        AppMethodBeat.o(95490);
    }

    public final void a(cnb cnb, View view, int i2, a aVar, bp bpVar) {
        AppMethodBeat.i(95491);
        a(cnb, view, -1, i2, aVar, bpVar);
        AppMethodBeat.o(95491);
    }

    private n aOV(String str) {
        AppMethodBeat.i(95492);
        n nVar = this.DGX.get(str);
        if (nVar == null || nVar.isRecycled()) {
            this.DGX.remove(str);
            AppMethodBeat.o(95492);
            return null;
        }
        AppMethodBeat.o(95492);
        return nVar;
    }

    private n aOW(String str) {
        AppMethodBeat.i(95493);
        n nVar = this.DGX.get(str);
        if (nVar == null || nVar.isRecycled()) {
            this.DGX.remove(str);
            AppMethodBeat.o(95493);
            return null;
        }
        AppMethodBeat.o(95493);
        return nVar;
    }

    public final void a(cnb cnb, View view, int i2, int i3, bp bpVar) {
        AppMethodBeat.i(95494);
        a(cnb, view, i2, i3, a.IMG_SCENE_NONE, bpVar);
        AppMethodBeat.o(95494);
    }

    public final void a(final String str, SparseArray<cnb> sparseArray, SparseArray<View> sparseArray2, int i2, final bp bpVar, final int i3) {
        AppMethodBeat.i(95495);
        Log.i("MicroMsg.LazyerImageLoader2", "enter group img download logic!");
        if (sparseArray == null || sparseArray.size() <= 0) {
            Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, medias is invalid.");
            AppMethodBeat.o(95495);
        } else if (sparseArray2 == null || sparseArray2.size() <= 0) {
            Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, imageViews is invalid.");
            AppMethodBeat.o(95495);
        } else {
            int size = sparseArray.size();
            int size2 = sparseArray2.size();
            if (-1 == (size == size2 ? size : -1)) {
                Log.e("MicroMsg.LazyerImageLoader2", "setSnsMultiImg check params, mediaSize(%d) != imgViewSize(%d).", Integer.valueOf(size), Integer.valueOf(size2));
                AppMethodBeat.o(95495);
                return;
            }
            final SparseArray sparseArray3 = new SparseArray();
            final SparseArray sparseArray4 = new SparseArray();
            final SparseArray sparseArray5 = new SparseArray();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                cnb cnb = sparseArray.get(keyAt);
                View view = sparseArray2.get(keyAt);
                view.setDrawingCacheEnabled(false);
                String cq = r.cq(0, cnb.Id);
                a(view, cq, -1, i2, a.IMG_SCENE_NONE);
                n aOV = aOV(cq);
                if (!r.b(aOV)) {
                    Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache miss.");
                    fh(view);
                    if (!this.DHr.contains(cq)) {
                        sparseArray3.put(keyAt, cnb);
                    }
                } else {
                    Log.i("MicroMsg.LazyerImageLoader2", "setSnsMultiImg, cache hit.");
                    a(view, cq, aOV);
                }
            }
            if (sparseArray3.size() != 0) {
                Log.i("MicroMsg.LazyerImageLoader2", "ok, let's download.");
                aj.faB().execute(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(95464);
                        int size = sparseArray3.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            int keyAt = sparseArray3.keyAt(i2);
                            cnb cnb = (cnb) sparseArray3.get(keyAt);
                            if (!g.a(g.this, 0, cnb)) {
                                com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(cnb);
                                nVar.DEs = 0;
                                nVar.dPI = cnb.Id;
                                sparseArray4.put(keyAt, nVar);
                                sparseArray5.put(keyAt, cnb);
                            }
                        }
                        if (sparseArray5.size() > 0) {
                            aj.faJ().a(str, sparseArray5, sparseArray4, bpVar, i3);
                        }
                        AppMethodBeat.o(95464);
                    }
                });
            }
            AppMethodBeat.o(95495);
        }
    }

    public final void a(cnb cnb, View view, int i2, int i3, a aVar, bp bpVar) {
        AppMethodBeat.i(95496);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95496);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String cq = r.cq(0, cnb.Id);
        a(view, cq, i2, i3, aVar);
        n aOV = aOV(cq);
        if (!r.b(aOV)) {
            Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache miss");
            if (i2 == -1) {
                fh(view);
            }
            if (this.DHr.contains(cq)) {
                AppMethodBeat.o(95496);
                return;
            }
            a(0, cnb, bpVar);
            AppMethodBeat.o(95496);
            return;
        }
        Log.d("MicroMsg.LazyerImageLoader2", "setSnsGrid cache hit");
        aj.faJ().aOS(cnb.Id);
        a(view, cq, aOV);
        AppMethodBeat.o(95496);
    }

    private void b(cnb cnb, View view, int i2, a aVar, bp bpVar) {
        AppMethodBeat.i(95497);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95497);
            return;
        }
        view.setDrawingCacheEnabled(false);
        String cq = r.cq(5, cnb.Id);
        a(view, cq, -1, i2, aVar);
        n aOV = aOV(cq);
        if (!r.b(aOV)) {
            fh(view);
            if (this.DHr.contains(cq)) {
                AppMethodBeat.o(95497);
                return;
            }
            a(5, cnb, bpVar);
            AppMethodBeat.o(95497);
            return;
        }
        a(view, cq, aOV);
        AppMethodBeat.o(95497);
    }

    private static void a(Object obj, String str, n nVar) {
        am amVar;
        am amVar2;
        am amVar3;
        long j2;
        long j3 = 0;
        AppMethodBeat.i(95498);
        if (obj == null) {
            AppMethodBeat.o(95498);
            return;
        }
        if (nVar != null) {
            Log.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", obj, str, nVar.aSf());
        }
        if (obj instanceof QFadeImageView) {
            QFadeImageView qFadeImageView = (QFadeImageView) obj;
            Drawable drawable = qFadeImageView.getDrawable();
            if (!Util.isNullOrNil(qFadeImageView.getImageKey()) && qFadeImageView.getImageKey().equals(str)) {
                j3 = qFadeImageView.getStartTimeMillis();
            }
            if (drawable == null || !(drawable instanceof am)) {
                j2 = j3;
            } else {
                j2 = ((am) drawable).DMd;
            }
            am amVar4 = new am(str, nVar, j2);
            qFadeImageView.T(amVar4.DMd, str);
            qFadeImageView.setImageDrawable(amVar4);
            amVar4.invalidateSelf();
            AppMethodBeat.o(95498);
        } else if (obj instanceof QDisFadeImageView) {
            com.tencent.mm.memory.b.a aVar = new com.tencent.mm.memory.b.a(str, nVar);
            ((QDisFadeImageView) obj).setImageDrawable(aVar);
            aVar.invalidateSelf();
            AppMethodBeat.o(95498);
        } else if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 == null || !(drawable2 instanceof am)) {
                amVar3 = new am(str, nVar, 0);
            } else {
                amVar3 = new am(str, nVar, ((am) drawable2).DMd);
            }
            imageView.setImageDrawable(amVar3);
            amVar3.invalidateSelf();
            AppMethodBeat.o(95498);
        } else if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            Log.i("MicroMsg.LazyerImageLoader2", "update sight thumb ".concat(String.valueOf(str)));
            if (obj instanceof SightPlayImageView) {
                SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                Drawable drawable3 = sightPlayImageView.getDrawable();
                if (drawable3 == null || !(drawable3 instanceof am)) {
                    amVar2 = new am(str, nVar, 0);
                } else {
                    amVar2 = new am(str, nVar, ((am) drawable3).DMd);
                }
                sightPlayImageView.setImageDrawable(amVar2);
                amVar2.invalidateSelf();
            }
            AppMethodBeat.o(95498);
        } else {
            if (obj instanceof SnsAdTimelineVideoView) {
                Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setImageDrawable, key=".concat(String.valueOf(str)));
                SnsAdTimelineVideoView snsAdTimelineVideoView = (SnsAdTimelineVideoView) obj;
                Drawable thumbDrawable = snsAdTimelineVideoView.getThumbDrawable();
                if (thumbDrawable == null || !(thumbDrawable instanceof am)) {
                    amVar = new am(str, nVar, 0);
                } else {
                    amVar = new am(str, nVar, ((am) thumbDrawable).DMd);
                }
                snsAdTimelineVideoView.setThumbDrawable(amVar);
                amVar.invalidateSelf();
            }
            AppMethodBeat.o(95498);
        }
    }

    public static String s(cnb cnb) {
        AppMethodBeat.i(95499);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95499);
            return null;
        }
        String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb);
        if (!s.YS(str)) {
            String str2 = cnb.Msz;
            AppMethodBeat.o(95499);
            return str2;
        }
        AppMethodBeat.o(95499);
        return str;
    }

    public static String t(cnb cnb) {
        AppMethodBeat.i(95500);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95500);
            return null;
        }
        String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.d(cnb);
        if (!s.YS(str)) {
            String str2 = cnb.Url;
            AppMethodBeat.o(95500);
            return str2;
        }
        AppMethodBeat.o(95500);
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void a(cnb cnb, View view, int i2, bp bpVar) {
        AppMethodBeat.i(95501);
        b(cnb, view, -1, i2, bpVar);
        AppMethodBeat.o(95501);
    }

    public final boolean a(VideoSightView videoSightView, int i2, int i3) {
        AppMethodBeat.i(176250);
        a(videoSightView, "", -1, i2);
        videoSightView.setThumbBmp(null);
        videoSightView.e(null, false, i3);
        AppMethodBeat.o(176250);
        return true;
    }

    public final boolean a(SnsAdTimelineVideoView snsAdTimelineVideoView, int i2) {
        AppMethodBeat.i(179080);
        a(snsAdTimelineVideoView, "", -1, i2);
        snsAdTimelineVideoView.setThumbBmp(null);
        snsAdTimelineVideoView.clear();
        AppMethodBeat.o(179080);
        return true;
    }

    public final boolean a(SnsInfo snsInfo, cnb cnb, VideoSightView videoSightView, int i2, int i3, bp bpVar, boolean z) {
        AppMethodBeat.i(176251);
        boolean a2 = a(snsInfo, cnb, videoSightView, i2, i3, bpVar, z, false);
        AppMethodBeat.o(176251);
        return a2;
    }

    public final boolean a(SnsInfo snsInfo, cnb cnb, VideoSightView videoSightView, int i2, int i3, bp bpVar, boolean z, boolean z2) {
        AppMethodBeat.i(176252);
        boolean a2 = a(snsInfo, cnb, videoSightView, -1, i2, i3, bpVar, z, z2, true);
        AppMethodBeat.o(176252);
        return a2;
    }

    public final boolean a(SnsInfo snsInfo, cnb cnb, VideoSightView videoSightView, int i2, int i3, int i4, bp bpVar, boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(202719);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(202719);
            return false;
        }
        String cq = r.cq(1, cnb.Id);
        a(videoSightView, cq, -1, i3);
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        String e2 = r.e(cnb);
        if (!s.YS(ki + e2)) {
            com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(cnb);
            nVar.DEs = 1;
            nVar.dPI = cnb.Id;
            aj.faJ().a(cnb, cnb.oUv == 6 ? 5 : 1, nVar, bpVar);
        }
        String str = "";
        if (z && z3) {
            str = a(snsInfo, cnb, bpVar, z);
        }
        Log.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", cq, str, Boolean.valueOf(z));
        if (Util.isNullOrNil(str) || v(cnb)) {
            Log.i("MicroMsg.LazyerImageLoader2", "sightPath %s", str);
            videoSightView.setVideoPath(null);
            videoSightView.clear();
            n aOV = aOV(cq);
            boolean b2 = r.b(aOV);
            Log.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", Boolean.valueOf(b2));
            if (!b2) {
                videoSightView.setPosition(0);
                videoSightView.setThumbBmp(null);
                if (this.DHr.contains(cq)) {
                    AppMethodBeat.o(202719);
                    return false;
                }
                a(1, cnb, bpVar);
                AppMethodBeat.o(202719);
                return false;
            }
            a(videoSightView, cq, aOV);
            AppMethodBeat.o(202719);
            return true;
        }
        if (!str.equals(videoSightView.getVideoPath())) {
            videoSightView.setThumbBmp(z2 ? BitmapUtil.decodeFile(ki + e2) : null);
        }
        videoSightView.setVideoPath(str);
        videoSightView.setPosition(i4);
        AppMethodBeat.o(202719);
        return true;
    }

    public final boolean a(SnsInfo snsInfo, cnb cnb, SnsAdTimelineVideoView snsAdTimelineVideoView, int i2, bp bpVar, boolean z) {
        AppMethodBeat.i(179081);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(179081);
            return false;
        }
        String cq = r.cq(1, cnb.Id);
        a(snsAdTimelineVideoView, cq, -1, i2);
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        String e2 = r.e(cnb);
        if (!s.YS(ki + e2)) {
            com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(cnb);
            nVar.DEs = 1;
            nVar.dPI = cnb.Id;
            aj.faJ().a(cnb, cnb.oUv == 6 ? 5 : 1, nVar, bpVar);
        }
        String str = "";
        if (z) {
            str = a(snsInfo, cnb, bpVar, z);
        }
        Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight %s sightPath %s isAd %b", cq, str, Boolean.valueOf(z));
        if (Util.isNullOrNil(str) || v(cnb)) {
            Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, sightPath %s", str);
            snsAdTimelineVideoView.setVideoPath(null);
            snsAdTimelineVideoView.clear();
            n aOV = aOV(cq);
            boolean b2 = r.b(aOV);
            Log.v("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, setsight thumb  %s", Boolean.valueOf(b2));
            if (!b2) {
                snsAdTimelineVideoView.setThumbBmp(null);
                if (this.DHr.contains(cq)) {
                    AppMethodBeat.o(179081);
                    return false;
                }
                a(1, cnb, bpVar);
                AppMethodBeat.o(179081);
                return false;
            }
            a(snsAdTimelineVideoView, cq, aOV);
            AppMethodBeat.o(179081);
            return true;
        }
        if (!str.equals(snsAdTimelineVideoView.getVideoPath())) {
            snsAdTimelineVideoView.setThumbBmp(BitmapUtil.decodeFile(ki + e2));
            Log.i("MicroMsg.SnsAdTimelineVideoView", "showVideoThumb:true");
            snsAdTimelineVideoView.d(false, 0.0f);
        }
        snsAdTimelineVideoView.setVideoPath(str);
        AppMethodBeat.o(179081);
        return true;
    }

    public final boolean b(cnb cnb, View view, int i2, int i3, bp bpVar) {
        AppMethodBeat.i(95506);
        boolean a2 = a(cnb, view, i2, i3, bpVar, 1);
        AppMethodBeat.o(95506);
        return a2;
    }

    public final boolean a(cnb cnb, View view, int i2, int i3, bp bpVar, int i4) {
        AppMethodBeat.i(95507);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95507);
            return false;
        }
        String cq = r.cq(i4, cnb.Id);
        a(view, cq, i2, i3);
        n aOV = aOV(cq);
        boolean b2 = r.b(aOV);
        Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + b2 + " " + cq);
        if (!b2) {
            if (i2 == -1) {
                fh(view);
            }
            if (this.DHr.contains(cq)) {
                AppMethodBeat.o(95507);
                return true;
            }
            a(i4, cnb, bpVar);
            AppMethodBeat.o(95507);
            return false;
        }
        a(view, cq, aOV);
        AppMethodBeat.o(95507);
        return true;
    }

    private static void fh(View view) {
        AppMethodBeat.i(95508);
        if (view instanceof QImageView) {
            ((QImageView) view).setImageDrawable(new ColorDrawable(view.getResources().getColor(R.color.f3046d)));
            AppMethodBeat.o(95508);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(new ColorDrawable(view.getResources().getColor(R.color.f3046d)));
            AppMethodBeat.o(95508);
        } else {
            AppMethodBeat.o(95508);
        }
    }

    private void a(View view, String str, int i2, a aVar) {
        AppMethodBeat.i(95509);
        a((Object) view, str, true, -1, i2, -1, -1, aVar);
        AppMethodBeat.o(95509);
    }

    private void a(Object obj, String str, int i2, int i3) {
        AppMethodBeat.i(95510);
        a(obj, str, true, i2, i3, -1, -1, a.IMG_SCENE_NONE);
        AppMethodBeat.o(95510);
    }

    private void a(Object obj, String str, int i2, int i3, a aVar) {
        AppMethodBeat.i(95511);
        a(obj, str, true, i2, i3, -1, -1, aVar);
        AppMethodBeat.o(95511);
    }

    private void a(Object obj, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(95512);
        a(obj, str, false, -1, i2, i3, i4, a.IMG_SCENE_NONE);
        AppMethodBeat.o(95512);
    }

    private void a(Object obj, String str, boolean z, int i2, int i3, int i4, int i5, a aVar) {
        LinkedList<WeakReference<c>> linkedList;
        int i6;
        AppMethodBeat.i(95513);
        if (obj == null) {
            AppMethodBeat.o(95513);
            return;
        }
        int hashCode = obj.hashCode();
        this.DHd.remove(new c(null, hashCode, 0, false));
        c cVar = new c(str, hashCode, i3, z);
        this.DHd.add(cVar);
        LinkedList<WeakReference<c>> linkedList2 = this.DGZ.get(str);
        if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
            this.DGZ.put(str, linkedList2);
        }
        linkedList2.add(new WeakReference<>(cVar));
        String str2 = (String) ((View) obj).getTag(2130706432);
        if (!(str2 == null || (linkedList = this.DGZ.get(str2)) == null)) {
            int i7 = 0;
            while (true) {
                i6 = i7;
                if (i6 >= linkedList.size()) {
                    i6 = -1;
                    break;
                }
                c cVar2 = linkedList.get(i6).get();
                if (cVar2 != null && cVar2.code == hashCode) {
                    break;
                }
                i7 = i6 + 1;
            }
            if (i6 != -1) {
                Log.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", str2);
                linkedList.remove(i6);
            }
        }
        ((View) obj).setTag(2130706432, str);
        this.iXZ.put(Integer.valueOf(hashCode), new WeakReference<>(obj));
        if (i2 != -1) {
            if (obj instanceof QFadeImageView) {
                ((QFadeImageView) obj).setImageResource(i2);
            } else if (obj instanceof ImageView) {
                ((ImageView) obj).setImageDrawable(com.tencent.mm.cb.a.l(((ImageView) obj).getContext(), i2));
            } else {
                ((com.tencent.mm.plugin.sight.decode.a.a) obj).e(null, !this.DGJ, 0);
            }
        }
        if (aVar != a.IMG_SCENE_SNSUSER || (!(obj instanceof ImageView) && !(obj instanceof QFadeImageView))) {
            if (str != null && str.startsWith(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
                ForceGpuUtil.decideLayerType((View) obj, i4, i5);
                Log.d("MicroMsg.LazyerImageLoader2", "try to setLayerType " + i4 + " " + i5);
            }
            AppMethodBeat.o(95513);
            return;
        }
        ForceGpuUtil.setLayerType((View) obj);
        AppMethodBeat.o(95513);
    }

    public final boolean fi(View view) {
        AppMethodBeat.i(95514);
        int hashCode = view.hashCode();
        Iterator<c> it = this.DHd.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (hashCode == next.code) {
                this.DHd.remove(next);
                break;
            }
        }
        this.iXZ.remove(Integer.valueOf(hashCode));
        AppMethodBeat.o(95514);
        return true;
    }

    private boolean a(final List<cnb> list, final bp bpVar) {
        AppMethodBeat.i(95515);
        aj.faB().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass9 */
            final /* synthetic */ int DHu = 0;

            public final void run() {
                int i2;
                AppMethodBeat.i(95466);
                long currentTicks = Util.currentTicks();
                com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(list);
                nVar.dPI = r.gN(list);
                nVar.DEs = this.DHu;
                int i3 = 0;
                boolean z = true;
                while (i3 < list.size() && i3 < 4) {
                    cnb cnb = (cnb) list.get(i3);
                    if (aj.faJ().aON(cnb.Id)) {
                        z = false;
                    } else if (!s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb)) && !s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb)) && !s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.m(cnb))) {
                        c faJ = aj.faJ();
                        if (cnb.oUv == 6) {
                            i2 = 5;
                        } else {
                            i2 = 1;
                        }
                        faJ.a(cnb, i2, nVar, bpVar);
                        z = false;
                    }
                    i3++;
                }
                long ticksToNow = Util.ticksToNow(currentTicks);
                if (ticksToNow > 100) {
                    Log.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + ticksToNow + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.aKD() + " " + aj.fbh() + " " + nVar.dPI);
                }
                if (Util.ticksToNow(g.this.DGV) > Util.MILLSECONDS_OF_MINUTE) {
                    h.INSTANCE.a(11696, 1, Long.valueOf(ticksToNow), 0, Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD());
                    g.this.DGV = Util.currentTicks();
                }
                final String gN = r.gN(list);
                if (z) {
                    aj.dRd().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(95465);
                            new i(r.cq(0, gN), gN, list).y("");
                            AppMethodBeat.o(95465);
                        }
                    });
                }
                AppMethodBeat.o(95466);
            }
        });
        AppMethodBeat.o(95515);
        return true;
    }

    private boolean fae() {
        AppMethodBeat.i(95516);
        if (this.DHc) {
            Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            AppMethodBeat.o(95516);
            return false;
        }
        aj.dRd().postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(95467);
                if (g.this.DHc) {
                    Log.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
                    AppMethodBeat.o(95467);
                    return;
                }
                if (g.this.DHb.size() > 0) {
                    Log.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + g.this.DHb.size());
                    ((b) g.this.DHb.removeLast()).y("");
                }
                AppMethodBeat.o(95467);
            }
        }, 0);
        AppMethodBeat.o(95516);
        return true;
    }

    private boolean a(final int i2, final cnb cnb, final bp bpVar) {
        AppMethodBeat.i(95517);
        if (!this.DGJ) {
            if (cnb != null && !Util.isNullOrNil(cnb.Id)) {
                aj.faJ().aOS(cnb.Id);
            }
            AppMethodBeat.o(95517);
            return false;
        }
        aj.faB().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(95469);
                if (!g.a(g.this, i2, cnb)) {
                    com.tencent.mm.plugin.sns.data.n nVar = new com.tencent.mm.plugin.sns.data.n(cnb);
                    nVar.DEs = i2;
                    nVar.dPI = cnb.Id;
                    aj.faJ().a(cnb, cnb.oUv == 6 ? 5 : 1, nVar, bpVar);
                }
                AppMethodBeat.o(95469);
            }
        });
        AppMethodBeat.o(95517);
        return true;
    }

    public static boolean u(cnb cnb) {
        AppMethodBeat.i(95518);
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        if (s.YS(ki + r.j(cnb))) {
            AppMethodBeat.o(95518);
            return true;
        } else if (!s.YS(ki + r.p(cnb)) || Util.isNullOrNil(cnb.Id) || !cnb.Id.startsWith("Locall_path")) {
            AppMethodBeat.o(95518);
            return false;
        } else {
            AppMethodBeat.o(95518);
            return true;
        }
    }

    public final int z(SnsInfo snsInfo) {
        AppMethodBeat.i(259439);
        int a2 = a(snsInfo, (int[]) null);
        AppMethodBeat.o(259439);
        return a2;
    }

    public final int a(SnsInfo snsInfo, int[] iArr) {
        int i2;
        int i3;
        int i4 = 5;
        AppMethodBeat.i(95520);
        if (iArr != null || Util.ticksToNow(this.DHh) > Util.MILLSECONDS_OF_MINUTE) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            com.tencent.mm.modelcontrol.d.baW();
            if (com.tencent.mm.modelcontrol.d.a(pInt, pInt2, pInt3)) {
                this.DHj = 5;
            } else {
                this.DHj = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                iArr[0] = i3;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.DHk = pInt.value;
            this.DHh = Util.currentTicks();
        }
        if (this.DHk == 0 || snsInfo == null) {
            int i5 = this.DHj;
            AppMethodBeat.o(95520);
            return i5;
        } else if (this.DHl.containsKey(Long.valueOf(snsInfo.field_snsId))) {
            int intValue = this.DHl.get(Long.valueOf(snsInfo.field_snsId)).intValue();
            AppMethodBeat.o(95520);
            return intValue;
        } else {
            eaj eaj = new eaj();
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf);
                if (snsObject.ObjectOperations == null) {
                    int i6 = this.DHj;
                    AppMethodBeat.o(95520);
                    return i6;
                }
                eaj.parseFrom(snsObject.ObjectOperations.getBufferToBytes());
                if (eaj.MZL == null || eaj.MZL.info == null) {
                    int i7 = this.DHj;
                    AppMethodBeat.o(95520);
                    return i7;
                }
                String str = eaj.MZL.info;
                int hashCode = str.hashCode();
                if (this.DHk == 1) {
                    if (!this.DHn.containsKey(Integer.valueOf(hashCode))) {
                        this.DHn.put(Integer.valueOf(hashCode), Boolean.valueOf(fy(str, this.DHk)));
                    }
                    i2 = this.DHn.get(Integer.valueOf(hashCode)).booleanValue() ? 5 : 10;
                } else {
                    if (!this.DHm.containsKey(Integer.valueOf(hashCode))) {
                        this.DHm.put(Integer.valueOf(hashCode), Boolean.valueOf(fy(str, this.DHk)));
                    }
                    if (!this.DHm.get(Integer.valueOf(hashCode)).booleanValue()) {
                        i4 = 10;
                    }
                    i2 = i4;
                }
                Log.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(snsInfo.field_snsId), Integer.valueOf(i2));
                this.DHl.put(Long.valueOf(snsInfo.field_snsId), Integer.valueOf(i2));
                AppMethodBeat.o(95520);
                return i2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", e2, "", new Object[0]);
                int i8 = this.DHj;
                AppMethodBeat.o(95520);
                return i8;
            }
        }
    }

    public final int A(SnsInfo snsInfo) {
        AppMethodBeat.i(259440);
        int b2 = b(snsInfo, (int[]) null);
        AppMethodBeat.o(259440);
        return b2;
    }

    public final int b(SnsInfo snsInfo, int[] iArr) {
        int i2;
        int i3;
        int i4 = 5;
        AppMethodBeat.i(95522);
        if (iArr != null || Util.ticksToNow(this.DHi) > Util.MILLSECONDS_OF_MINUTE) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            com.tencent.mm.modelcontrol.d.baW();
            if (com.tencent.mm.modelcontrol.d.a(pInt, pInt2)) {
                this.DHo = 5;
            } else {
                this.DHo = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                iArr[0] = i3;
                iArr[1] = pInt2.value;
            }
            this.DHp = pInt.value;
            this.DHi = Util.currentTicks();
        }
        if (this.DHp == 0 || snsInfo == null) {
            int i5 = this.DHo;
            AppMethodBeat.o(95522);
            return i5;
        } else if (this.DHq.containsKey(Long.valueOf(snsInfo.field_snsId))) {
            int intValue = this.DHq.get(Long.valueOf(snsInfo.field_snsId)).intValue();
            AppMethodBeat.o(95522);
            return intValue;
        } else {
            eaj eaj = new eaj();
            try {
                SnsObject snsObject = (SnsObject) new SnsObject().parseFrom(snsInfo.field_attrBuf);
                if (snsObject.ObjectOperations == null) {
                    int i6 = this.DHo;
                    AppMethodBeat.o(95522);
                    return i6;
                }
                eaj.parseFrom(snsObject.ObjectOperations.getBufferToBytes());
                if (eaj.MZL == null || eaj.MZL.info == null) {
                    int i7 = this.DHj;
                    AppMethodBeat.o(95522);
                    return i7;
                }
                String str = eaj.MZL.info;
                int hashCode = str.hashCode();
                if (this.DHp == 1) {
                    if (!this.DHn.containsKey(Integer.valueOf(hashCode))) {
                        this.DHn.put(Integer.valueOf(hashCode), Boolean.valueOf(fy(str, this.DHp)));
                    }
                    i2 = this.DHn.get(Integer.valueOf(hashCode)).booleanValue() ? 5 : 10;
                } else {
                    if (!this.DHm.containsKey(Integer.valueOf(hashCode))) {
                        this.DHm.put(Integer.valueOf(hashCode), Boolean.valueOf(fy(str, this.DHp)));
                    }
                    if (!this.DHm.get(Integer.valueOf(hashCode)).booleanValue()) {
                        i4 = 10;
                    }
                    i2 = i4;
                }
                Log.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", Long.valueOf(snsInfo.field_snsId), Integer.valueOf(i2));
                this.DHq.put(Long.valueOf(snsInfo.field_snsId), Integer.valueOf(i2));
                AppMethodBeat.o(95522);
                return i2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LazyerImageLoader2", e2, "", new Object[0]);
                int i8 = this.DHo;
                AppMethodBeat.o(95522);
                return i8;
            }
        }
    }

    private static boolean fy(String str, int i2) {
        AppMethodBeat.i(95523);
        Map<String, String> parseXml = XmlParser.parseXml(str, "SightDownloadControl", null);
        if (parseXml == null || parseXml.isEmpty()) {
            AppMethodBeat.o(95523);
            return true;
        } else if (i2 == 1) {
            if (Util.getInt(parseXml.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1) {
                AppMethodBeat.o(95523);
                return true;
            }
            AppMethodBeat.o(95523);
            return false;
        } else if (Util.getInt(parseXml.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1) {
            AppMethodBeat.o(95523);
            return true;
        } else {
            AppMethodBeat.o(95523);
            return false;
        }
    }

    public final boolean v(cnb cnb) {
        AppMethodBeat.i(95524);
        if (!this.DHe.containsKey(cnb.Id)) {
            AppMethodBeat.o(95524);
            return false;
        } else if (this.DHe.get(cnb.Id).intValue() == 1) {
            AppMethodBeat.o(95524);
            return true;
        } else {
            AppMethodBeat.o(95524);
            return false;
        }
    }

    public final boolean w(cnb cnb) {
        AppMethodBeat.i(95525);
        if (!this.DHe.containsKey(cnb.Id)) {
            AppMethodBeat.o(95525);
            return false;
        } else if (this.DHe.get(cnb.Id).intValue() == 2) {
            AppMethodBeat.o(95525);
            return true;
        } else {
            AppMethodBeat.o(95525);
            return false;
        }
    }

    public final boolean x(cnb cnb) {
        AppMethodBeat.i(95526);
        if (!this.DHe.containsKey(cnb.Id)) {
            AppMethodBeat.o(95526);
            return false;
        } else if (this.DHe.get(cnb.Id).intValue() == 3) {
            AppMethodBeat.o(95526);
            return true;
        } else {
            AppMethodBeat.o(95526);
            return false;
        }
    }

    public final boolean y(cnb cnb) {
        AppMethodBeat.i(95527);
        if (!this.DHe.containsKey(cnb.Id)) {
            AppMethodBeat.o(95527);
            return false;
        } else if (this.DHe.get(cnb.Id).intValue() == 4) {
            AppMethodBeat.o(95527);
            return true;
        } else {
            AppMethodBeat.o(95527);
            return false;
        }
    }

    private boolean aOX(String str) {
        AppMethodBeat.i(179083);
        if (this.DHe.containsKey(str) && 4 == this.DHe.get(str).intValue()) {
            this.DHe.remove(str);
        }
        AppMethodBeat.o(179083);
        return true;
    }

    private void setError(String str) {
        AppMethodBeat.i(179084);
        this.DHe.put(str, 4);
        AppMethodBeat.o(179084);
    }

    public final void z(cnb cnb) {
        AppMethodBeat.i(95528);
        this.DHe.put(cnb.Id, 1);
        AppMethodBeat.o(95528);
    }

    public final void A(cnb cnb) {
        AppMethodBeat.i(95529);
        this.DHe.put(cnb.Id, 2);
        AppMethodBeat.o(95529);
    }

    public final void B(cnb cnb) {
        AppMethodBeat.i(95530);
        this.DHe.put(cnb.Id, 3);
        AppMethodBeat.o(95530);
    }

    private String a(SnsInfo snsInfo, final cnb cnb, final bp bpVar, boolean z) {
        AppMethodBeat.i(95531);
        if (v(cnb)) {
            AppMethodBeat.o(95531);
            return "";
        }
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        String j2 = r.j(cnb);
        if (s.YS(ki + j2)) {
            String str = ki + j2;
            AppMethodBeat.o(95531);
            return str;
        } else if (s.YS(ki + r.p(cnb)) && cnb.Id != null && cnb.Id.startsWith("Locall_path")) {
            String str2 = ki + r.p(cnb);
            AppMethodBeat.o(95531);
            return str2;
        } else if (!this.DGJ) {
            AppMethodBeat.o(95531);
            return "";
        } else {
            Log.i("MicroMsg.LazyerImageLoader2", "push sight loader " + cnb.Id + " url: " + cnb.Url);
            if (!z) {
                Log.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
            } else if (b(snsInfo, (int[]) null) == 5) {
                aj.dRd().postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(95470);
                        aj.faJ().a(cnb, 4, (com.tencent.mm.plugin.sns.data.n) null, bpVar);
                        AppMethodBeat.o(95470);
                    }
                }, 0);
            }
            AppMethodBeat.o(95531);
            return "";
        }
    }

    public final boolean a(String str, n nVar, int i2) {
        AppMethodBeat.i(95533);
        a(i2 + "-" + str, nVar);
        AppMethodBeat.o(95533);
        return true;
    }

    private boolean a(String str, n nVar) {
        AppMethodBeat.i(95534);
        if (!(nVar == null || str == null)) {
            this.DGX.put(str, nVar);
        }
        AppMethodBeat.o(95534);
        return true;
    }

    public final void aOY(String str) {
        AppMethodBeat.i(95536);
        b(str, (n) null);
        AppMethodBeat.o(95536);
    }

    public final n aOZ(String str) {
        AppMethodBeat.i(95537);
        if (this.DGX == null) {
            AppMethodBeat.o(95537);
            return null;
        }
        n nVar = this.DGX.get("0-".concat(String.valueOf(str)));
        AppMethodBeat.o(95537);
        return nVar;
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, bp bpVar) {
        AppMethodBeat.i(95538);
        if (z || !Util.isNullOrNil(str)) {
            cnb a2 = com.tencent.mm.modelsns.n.a(str3, 2, str2, str2, 1, 1, "");
            r.cq(2, str3);
            if (str3.equals("")) {
                Bitmap aOp = r.aOp(str);
                if (r.M(aOp)) {
                    AppMethodBeat.o(95538);
                    return aOp;
                }
                AppMethodBeat.o(95538);
                return null;
            } else if (r.M(null)) {
                AppMethodBeat.o(95538);
                return null;
            } else {
                Bitmap aOp2 = r.aOp(ar.ki(aj.getAccSnsPath(), str3) + r.l(a2));
                if (!r.M(aOp2)) {
                    aOp2 = r.aOp(str);
                }
                if (aOp2 == null && z && !Util.isNullOrNil(str2)) {
                    aj.faJ().a(a2, 3, (com.tencent.mm.plugin.sns.data.n) null, bpVar);
                }
                if (!r.M(aOp2)) {
                    AppMethodBeat.o(95538);
                    return null;
                }
                AppMethodBeat.o(95538);
                return aOp2;
            }
        } else {
            AppMethodBeat.o(95538);
            return null;
        }
    }

    public final boolean C(cnb cnb) {
        AppMethodBeat.i(95539);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95539);
            return false;
        } else if (s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.f(cnb))) {
            AppMethodBeat.o(95539);
            return true;
        } else if (s.YS(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb))) {
            AppMethodBeat.o(95539);
            return true;
        } else {
            boolean b2 = r.b(this.DGX.get(r.cq(1, cnb.Id)));
            AppMethodBeat.o(95539);
            return b2;
        }
    }

    public static boolean a(cnb cnb, bp bpVar, boolean z) {
        String str;
        AppMethodBeat.i(95540);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95540);
            return false;
        }
        if (cnb.Id.startsWith("Locall_path")) {
            str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.m(cnb);
        } else {
            str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.d(cnb);
        }
        if (!s.YS(str)) {
            aj.faJ().a(cnb, z ? 8 : 2, (com.tencent.mm.plugin.sns.data.n) null, bpVar);
            AppMethodBeat.o(95540);
            return false;
        }
        AppMethodBeat.o(95540);
        return true;
    }

    public static String D(cnb cnb) {
        String str;
        AppMethodBeat.i(95541);
        if (cnb == null) {
            AppMethodBeat.o(95541);
            return null;
        }
        if (cnb.Id.startsWith("pre_temp_sns_pic")) {
            str = aj.getAccSnsTmpPath() + cnb.Id;
        } else if (cnb.Id.startsWith("Locall_path")) {
            str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.m(cnb);
        } else if (cnb.Id.startsWith("pre_temp_extend_pic")) {
            str = cnb.Id.substring(19);
        } else {
            str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.d(cnb);
        }
        AppMethodBeat.o(95541);
        return str;
    }

    public final void a(final cnb cnb, final View view, final int i2, final boolean z, final bp bpVar, final boolean z2, final e eVar) {
        OO oo;
        Bitmap bitmap;
        AppMethodBeat.i(95542);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95542);
            return;
        }
        final String cq = r.cq(3, cnb.Id);
        final String D = D(cnb);
        if (aj.faJ().aOO(cnb.Id)) {
            Log.d("MicroMsg.LazyerImageLoader2", "zeus passed download " + cnb.Id);
            a(view, cq, i2, -1, -1);
            eVar.ax(null);
            AppMethodBeat.o(95542);
            return;
        }
        ap<String, WeakReference<Bitmap>> apVar = this.DGY;
        ap<K, O>.b bVar = apVar.DMl.get(cq);
        if (bVar == null) {
            oo = null;
        } else {
            apVar.DMl.get(cq).fbu();
            oo = bVar.obj;
        }
        OO oo2 = oo;
        Log.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + cq + "  " + (oo2 == null));
        if (oo2 == null) {
            bitmap = null;
        } else {
            bitmap = (Bitmap) oo2.get();
        }
        if (r.M(bitmap)) {
            Log.d("MicroMsg.LazyerImageLoader2", "get bmp from cache.");
            a(view, cq, i2, bitmap.getWidth(), bitmap.getHeight());
            eVar.ax(bitmap);
            AppMethodBeat.o(95542);
            return;
        }
        aj.faz().execute(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(95459);
                final Bitmap aOp = r.aOp(D);
                aj.dRd().post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(95458);
                        if (r.M(aOp)) {
                            g.a(g.this, view, cq, i2, aOp.getWidth(), aOp.getHeight());
                        } else {
                            g.a(g.this, view, cq, i2, -1, -1);
                        }
                        if (r.M(aOp)) {
                            ap apVar = g.this.DGY;
                            String str = cq;
                            OO oo = (OO) new WeakReference(aOp);
                            if (apVar.DMl.get(str) == null) {
                                apVar.DMl.put(str, new ap.b(oo));
                                apVar.fbt();
                            } else {
                                apVar.DMl.get(str).fbu();
                                apVar.DMl.get(str).obj = oo;
                            }
                        } else if (z) {
                            aj.faJ().a(cnb, z2 ? 8 : 2, (com.tencent.mm.plugin.sns.data.n) null, bpVar);
                        }
                        if (eVar != null) {
                            eVar.ax(aOp);
                        }
                        AppMethodBeat.o(95458);
                    }
                });
                AppMethodBeat.o(95459);
            }
        });
        AppMethodBeat.o(95542);
    }

    public final n a(cnb cnb, ImageView imageView, int i2, bp bpVar) {
        AppMethodBeat.i(95543);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95543);
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String cq = r.cq(0, cnb.Id);
        a(imageView, cq, -1, i2);
        n aOV = aOV(cq);
        if (!r.b(aOV)) {
            a(0, cnb, bpVar);
            AppMethodBeat.o(95543);
            return null;
        }
        AppMethodBeat.o(95543);
        return aOV;
    }

    public final void a(List<cnb> list, View view, int i2, a aVar, bp bpVar) {
        AppMethodBeat.i(95545);
        a(list, view, i2, aVar, bpVar, false);
        AppMethodBeat.o(95545);
    }

    public final void a(List<cnb> list, View view, int i2, a aVar, bp bpVar, boolean z) {
        AppMethodBeat.i(95546);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(95546);
        } else if (list.size() != 1) {
            String cq = r.cq(0, r.gN(list));
            a(view, cq, i2, aVar);
            n aOV = aOV(cq);
            boolean b2 = r.b(aOV);
            Log.v("MicroMsg.LazyerImageLoader2", "set Sns GridList ".concat(String.valueOf(b2)));
            if (!b2) {
                fh(view);
                if (this.DHr.contains(cq)) {
                    AppMethodBeat.o(95546);
                    return;
                }
                new WeakReference(view);
                a(list, bpVar);
                AppMethodBeat.o(95546);
                return;
            }
            a(view, cq, aOV);
            AppMethodBeat.o(95546);
        } else if (!z) {
            b(list.get(0), view, i2, bpVar);
            AppMethodBeat.o(95546);
        } else {
            b(list.get(0), view, i2, a.IMG_SCENE_SNSUSER, bpVar);
            AppMethodBeat.o(95546);
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends h<String, Integer, Boolean> {
        private int DHS = 0;
        private cnb ebR;
        private n iuI = null;
        private String jpM;
        String key = "";
        private String path;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ Boolean doInBackground(String[] strArr) {
            AppMethodBeat.i(259438);
            Boolean fag = fag();
            AppMethodBeat.o(259438);
            return fag;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.sns.model.h
        public final /* synthetic */ void onPostExecute(Boolean bool) {
            AppMethodBeat.i(95478);
            super.onPostExecute(bool);
            g.faf();
            g.this.DHr.remove(this.key);
            g.this.b(this.key, this.iuI);
            g.this.DHc = false;
            g.g(g.this);
            AppMethodBeat.o(95478);
        }

        public b(String str, String str2, String str3, cnb cnb, int i2) {
            AppMethodBeat.i(95474);
            g.this.DHr.add(str);
            this.key = str;
            this.path = str2;
            this.jpM = str3;
            this.ebR = cnb;
            this.DHS = i2;
            g.etv();
            Log.d("MicroMsg.ImageLoader", "peddingCount %d ", Integer.valueOf(g.DHs));
            AppMethodBeat.o(95474);
        }

        private void aL(String str, String str2, String str3) {
            AppMethodBeat.i(95475);
            s.YS(this.jpM + str3);
            if (!s.YS(this.jpM + str)) {
                if (!s.YS(this.jpM + str2)) {
                    str2 = r.m(this.ebR);
                }
                boolean a2 = com.tencent.mm.plugin.sns.storage.r.a(this.jpM, str2, str, (float) aj.fbc());
                if (!a2) {
                    Log.i("MicroMsg.ImageLoader", "delete %s", str2);
                    s.deleteFile(this.jpM + str2);
                }
                Log.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", this.jpM + str2, this.jpM + str, Boolean.valueOf(a2));
            }
            com.tencent.mm.plugin.sns.storage.r.b(this.jpM, str, str3, (float) aj.fbb());
            AppMethodBeat.o(95475);
        }

        private Boolean fag() {
            AppMethodBeat.i(95476);
            g.this.DHc = true;
            if (!g.this.DGJ) {
                Log.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(95476);
                return bool;
            } else if (g.this.DGX.check(this.key)) {
                Log.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
                Boolean bool2 = Boolean.FALSE;
                AppMethodBeat.o(95476);
                return bool2;
            } else {
                s.bpc(this.jpM);
                long currentTimeMillis = System.currentTimeMillis();
                if (!s.YS(this.path)) {
                    aL(r.e(this.ebR), r.l(this.ebR), r.f(this.ebR));
                } else {
                    Log.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", this.path);
                }
                long currentTicks = Util.currentTicks();
                if (this.DHS == 5) {
                    if (!s.YS(this.path)) {
                        aL(r.e(this.ebR), r.l(this.ebR), r.f(this.ebR));
                    }
                    boolean YS = s.YS(this.jpM + r.e(this.ebR));
                    boolean YS2 = s.YS(this.jpM + r.l(this.ebR));
                    boolean YS3 = s.YS(this.jpM + r.f(this.ebR));
                    this.iuI = r.aOo(this.path);
                    if (this.iuI == null) {
                        Log.i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.iuI = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.jpM + r.f(this.ebR), this.path);
                        Log.i("MicroMsg.ImageLoader", "abc a" + YS + " b" + YS2 + " c" + YS3 + " d" + s.YS(this.path));
                    }
                } else if (this.DHS == 4) {
                    this.iuI = r.aOo(this.path);
                    if (this.iuI == null) {
                        Log.i("MicroMsg.ImageLoader", "error path %s", this.path);
                        this.iuI = com.tencent.mm.plugin.sns.lucky.a.a.kd(this.jpM + r.e(this.ebR), this.path);
                    }
                } else {
                    this.iuI = r.aOq(this.path);
                }
                long ticksToNow = Util.ticksToNow(currentTicks);
                int boW = (int) s.boW(this.path);
                if (Util.ticksToNow(g.this.DGW) > Util.MILLSECONDS_OF_MINUTE) {
                    h.INSTANCE.a(11696, 4, Long.valueOf(ticksToNow), Integer.valueOf(boW), Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD());
                    g.this.DGW = Util.currentTicks();
                }
                if (this.iuI == null) {
                    Log.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", this.ebR.Id);
                    s.deleteFile(this.jpM + r.f(this.ebR));
                    s.deleteFile(this.path);
                    h.INSTANCE.idkeyStat(150, 2, 1, true);
                }
                h.INSTANCE.idkeyStat(150, 0, 1, true);
                h.INSTANCE.idkeyStat(150, 1, System.currentTimeMillis() - currentTimeMillis, true);
                Log.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.iuI == null) + " " + this.iuI + " %d ", this.path, Long.valueOf(System.currentTimeMillis() - currentTicks));
                Boolean bool3 = Boolean.TRUE;
                AppMethodBeat.o(95476);
                return bool3;
            }
        }

        @Override // com.tencent.mm.plugin.sns.model.h
        public final ExecutorService eGk() {
            AppMethodBeat.i(179079);
            ExecutorService faz = aj.faz();
            AppMethodBeat.o(179079);
            return faz;
        }
    }

    /* access modifiers changed from: protected */
    public final void b(String str, n nVar) {
        Object obj;
        int position;
        AppMethodBeat.i(95547);
        if (!r.b(nVar)) {
            nVar = aOW(str);
        }
        if (r.b(nVar)) {
            if (!(this.DGX == null || nVar == null || str == null)) {
                this.DGX.put(str, nVar);
            }
            LinkedList<WeakReference<c>> linkedList = this.DGZ.get(str);
            if (linkedList != null) {
                Iterator<WeakReference<c>> it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = it.next().get();
                    if (cVar != null && cVar.DHU && str != null && str.equals(cVar.id)) {
                        WeakReference<Object> weakReference = this.iXZ.get(Integer.valueOf(cVar.code));
                        if (!(weakReference == null || (obj = weakReference.get()) == null)) {
                            if (obj instanceof QFadeImageView) {
                                QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                if (this.DHg != null && (qFadeImageView instanceof TagImageView) && (position = ((TagImageView) qFadeImageView).getPosition()) != -1 && !this.DHg.Zx(position)) {
                                }
                            }
                            if (!r.b(nVar) || obj == null) {
                                Object[] objArr = new Object[3];
                                objArr[0] = Boolean.valueOf(nVar == null);
                                objArr[1] = Boolean.valueOf(obj == null);
                                objArr[2] = Boolean.valueOf(r.b(nVar));
                                Log.d("MicroMsg.LazyerImageLoader2", "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s", objArr);
                            } else {
                                a(obj, str, nVar);
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(95547);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        public int DHT;
        public boolean DHU;
        public int code;
        public String id;

        public c(String str, int i2, int i3, boolean z) {
            this.id = str;
            this.code = i2;
            this.DHT = i3;
            this.DHU = z;
        }

        public final int hashCode() {
            return this.code;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95480);
            if (obj == null || obj.hashCode() != this.code) {
                AppMethodBeat.o(95480);
                return false;
            }
            AppMethodBeat.o(95480);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.g
    public final void eZk() {
        AppMethodBeat.i(95548);
        fad();
        this.DHh = 0;
        this.DHi = 0;
        this.DHb.clear();
        this.DHc = false;
        AppMethodBeat.o(95548);
    }

    public final void c(cnb cnb, View view, int i2, bp bpVar) {
        AppMethodBeat.i(95505);
        if (cnb == null || cnb.Id == null || cnb.Id.equals("")) {
            AppMethodBeat.o(95505);
            return;
        }
        String cq = r.cq(4, cnb.Id);
        a(view, cq, -1, i2);
        n aOV = aOV(cq);
        boolean b2 = r.b(aOV);
        Log.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  ".concat(String.valueOf(b2)));
        if (!b2) {
            fh(view);
            if (!this.DHr.contains(cq)) {
                a(4, cnb, bpVar);
                AppMethodBeat.o(95505);
                return;
            }
        } else {
            a(view, cq, aOV);
        }
        AppMethodBeat.o(95505);
    }

    public final boolean kf(String str, String str2) {
        Object obj;
        AppMethodBeat.i(95532);
        if (this.DHe.containsKey(str) && 3 == this.DHe.get(str).intValue()) {
            this.DHe.remove(str);
        }
        String cq = r.cq(1, str);
        Log.i("MicroMsg.LazyerImageLoader2", "TimeLineAdPreloadHelper, download video complete, mediaId=" + str + ", path=" + str2);
        LinkedList<WeakReference<c>> linkedList = this.DGZ.get(cq);
        if (linkedList == null) {
            AppMethodBeat.o(95532);
            return false;
        }
        Iterator<WeakReference<c>> it = linkedList.iterator();
        while (it.hasNext()) {
            c cVar = it.next().get();
            if (cVar != null && cVar.DHU && cq != null && cq.equals(cVar.id)) {
                WeakReference<Object> weakReference = this.iXZ.get(Integer.valueOf(cVar.code));
                if (!(weakReference == null || (obj = weakReference.get()) == null)) {
                    if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                        Log.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", str, str2);
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.getTagObject() instanceof at) {
                            at atVar = (at) aVar.getTagObject();
                            if (atVar == null) {
                                aVar.e(str2, !this.DGJ, 0);
                            } else if (s.YS(str2)) {
                                aVar.e(str2, !this.DGJ, atVar.position);
                                aVar.setPosition(atVar.position);
                                atVar.Ewv.setVisibility(8);
                                atVar.EeS.setVisibility(8);
                                atVar.EeT.setVisibility(8);
                                aOX(str);
                            } else {
                                setError(str);
                                atVar.Ewv.setVisibility(8);
                                atVar.EeS.setImageResource(R.drawable.btc);
                                atVar.EeS.setVisibility(0);
                            }
                        }
                    } else if (obj instanceof SnsAdTimelineVideoView) {
                        Log.i("MicroMsg.LazyerImageLoader2", "SnsAdTimelineVideoView, download fin set sight %s %s", str, str2);
                        SnsAdTimelineVideoView snsAdTimelineVideoView = (SnsAdTimelineVideoView) obj;
                        if (snsAdTimelineVideoView.getTag() instanceof at) {
                            at atVar2 = (at) snsAdTimelineVideoView.getTag();
                            if (atVar2 == null) {
                                snsAdTimelineVideoView.setVideoPath(str2);
                                snsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
                            } else if (s.YS(str2)) {
                                snsAdTimelineVideoView.setVideoPath(str2);
                                snsAdTimelineVideoView.setShouldPlayWhenPrepared(true);
                                atVar2.Ewv.setVisibility(8);
                                atVar2.EeS.setVisibility(8);
                                atVar2.EeT.setVisibility(8);
                                aOX(str);
                            } else {
                                setError(str);
                                atVar2.Ewv.setVisibility(8);
                                atVar2.EeS.setImageResource(R.drawable.btc);
                                atVar2.EeS.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(95532);
        return true;
    }

    public final boolean a(com.tencent.mm.plugin.sns.data.n nVar, String str) {
        cnb cnb;
        String e2;
        AppMethodBeat.i(95535);
        cnb cnb2 = nVar.list.get(0);
        int i2 = 1;
        while (true) {
            if (i2 >= nVar.list.size()) {
                cnb = cnb2;
                break;
            }
            cnb cnb3 = nVar.list.get(i2);
            if (str != null && str.indexOf(cnb3.Id) >= 0) {
                cnb = cnb3;
                break;
            }
            i2++;
        }
        String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
        if (nVar.DEs == 0) {
            e2 = r.f(cnb);
        } else if (nVar.DEs == 4) {
            e2 = r.g(cnb);
        } else if (nVar.DEs == 5) {
            e2 = r.g(cnb);
        } else if (nVar.DEs == 3) {
            e2 = r.l(cnb);
        } else {
            e2 = r.e(cnb);
        }
        if (!this.DGX.check(r.cq(nVar.DEs, cnb.Id))) {
            new b(r.cq(nVar.DEs, cnb.Id), ki + e2, ki, cnb, nVar.DEs).y("");
        }
        AppMethodBeat.o(95535);
        return true;
    }

    public final void d(View view, int i2, int i3, int i4) {
        AppMethodBeat.i(95544);
        a((Object) view, (String) null, true, -1, i4, -1, -1, a.IMG_SCENE_NONE);
        if (i2 != -1) {
            view.setBackgroundResource(i2);
        }
        if (i3 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i3);
                AppMethodBeat.o(95544);
                return;
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.cb.a.l(view.getContext(), i3));
                AppMethodBeat.o(95544);
                return;
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageDrawable(new ColorDrawable(view.getResources().getColor(R.color.f3046d)));
            AppMethodBeat.o(95544);
            return;
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(new ColorDrawable(view.getResources().getColor(R.color.f3046d)));
        }
        AppMethodBeat.o(95544);
    }

    static /* synthetic */ boolean a(g gVar, String str) {
        AppMethodBeat.i(95549);
        if (gVar.DHd == null || gVar.DHd.size() == 0) {
            AppMethodBeat.o(95549);
            return true;
        }
        for (Integer num : gVar.iXZ.keySet()) {
            int intValue = num.intValue();
            if (gVar.iXZ.get(Integer.valueOf(intValue)).get() == null) {
                Iterator<c> it = gVar.DHd.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next.code == intValue) {
                        gVar.DHd.remove(next);
                        Log.d("MicroMsg.LazyerImageLoader2", "remove code ok rCode: ".concat(String.valueOf(intValue)));
                        break;
                    }
                }
            }
        }
        Iterator<c> it2 = gVar.DHd.iterator();
        while (it2.hasNext()) {
            c next2 = it2.next();
            if (str != null && str.equals(next2.id)) {
                AppMethodBeat.o(95549);
                return false;
            }
        }
        AppMethodBeat.o(95549);
        return true;
    }

    static /* synthetic */ boolean a(g gVar, final int i2, final cnb cnb) {
        final String e2;
        AppMethodBeat.i(95550);
        if (gVar.DGJ) {
            final String ki = ar.ki(aj.getAccSnsPath(), cnb.Id);
            if (i2 == 4) {
                e2 = r.g(cnb);
            } else if (i2 == 5) {
                e2 = r.h(cnb);
            } else if (i2 == 0) {
                e2 = r.f(cnb);
            } else if (i2 == 3) {
                e2 = r.l(cnb);
            } else {
                e2 = r.e(cnb);
            }
            String e3 = r.e(cnb);
            if (!com.tencent.mm.plugin.sns.model.a.c.aPK(cnb.Id)) {
                long ticksToNow = Util.ticksToNow(Util.currentTicks());
                if (ticksToNow > 100) {
                    Log.i("MicroMsg.LazyerImageLoader2", "fileexist check endtime " + ticksToNow + " " + Thread.currentThread().getName() + " " + com.tencent.mm.loader.j.b.aKD() + " " + aj.fbh() + " " + cnb.Id);
                }
                if (Util.ticksToNow(gVar.DGV) > Util.MILLSECONDS_OF_MINUTE) {
                    h.INSTANCE.a(11696, 1, Long.valueOf(ticksToNow), 0, Thread.currentThread().getName(), aj.fbh(), com.tencent.mm.loader.j.b.aKD());
                    gVar.DGV = Util.currentTicks();
                }
                if (s.YS(ki + e3) || s.YS(ki + r.l(cnb)) || s.YS(ki + r.m(cnb))) {
                    aj.dRd().post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.model.g.AnonymousClass11 */

                        public final void run() {
                            AppMethodBeat.i(95468);
                            while (g.this.DHb.size() >= 60) {
                                g.this.DHr.remove(((b) g.this.DHb.removeFirst()).key);
                            }
                            Log.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + g.this.DHb.size());
                            b bVar = new b(r.cq(i2, cnb.Id), ki + e2, ki, cnb, i2);
                            if (!g.this.DGX.check(bVar.key)) {
                                g.this.DHb.add(bVar);
                            } else {
                                g.this.DHr.remove(bVar.key);
                            }
                            g.g(g.this);
                            AppMethodBeat.o(95468);
                        }
                    });
                    AppMethodBeat.o(95550);
                    return true;
                }
            }
        }
        AppMethodBeat.o(95550);
        return false;
    }
}
