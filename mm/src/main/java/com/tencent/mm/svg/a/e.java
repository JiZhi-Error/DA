package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.svg.b.c;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class e {
    private static Method NDp = null;
    private static Method NDq = null;
    private static boolean OuK = false;
    private static volatile c OuL;
    private static LongSparseArray<Drawable.ConstantState>[] OuM;
    private static LongSparseArray<Drawable.ConstantState> OuN;
    private static C2067e<Drawable.ConstantState> OuO;
    private static C2067e<Drawable.ConstantState> OuP;
    private static LongSparseArray<b> OuQ;
    private static a OuR;
    protected static Class<d> OuS;
    private static volatile boolean OuT = false;
    private static Map<WeakReference<Resources>, Map<Long, Integer>> OuU = new HashMap();
    private static boolean OuV = false;
    private static ThreadLocal<Boolean> OuW = new ThreadLocal<>();
    private static final boolean OuX = "xiaomi".equalsIgnoreCase(Build.BRAND);
    private static final byte[] OuY = new byte[0];
    private static TypedValue OuZ = new TypedValue();
    private static Class<?> dmm = null;
    protected static Application dmn;
    protected static String sPackageName;
    protected static Resources sResources;

    static /* synthetic */ b b(long j2, d dVar) {
        AppMethodBeat.i(148749);
        b a2 = a(j2, dVar);
        AppMethodBeat.o(148749);
        return a2;
    }

    static {
        AppMethodBeat.i(148752);
        AppMethodBeat.o(148752);
    }

    public static void a(Resources resources, Map<Long, Integer> map) {
        boolean z;
        AppMethodBeat.i(148735);
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:".concat(String.valueOf(resources)), new Object[0]);
        Iterator<WeakReference<Resources>> it = OuU.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().get() == resources) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            OuU.put(new WeakReference<>(resources), map);
        }
        AppMethodBeat.o(148735);
    }

    public static void ab(Class<?> cls) {
        dmm = cls;
    }

    public static void a(c.a aVar) {
        AppMethodBeat.i(148736);
        com.tencent.mm.svg.b.c.b(aVar);
        AppMethodBeat.o(148736);
    }

    public static void c(Application application, String str) {
        AppMethodBeat.i(148737);
        if (OuV) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
            AppMethodBeat.o(148737);
            return;
        }
        sPackageName = str;
        a.gm(str);
        com.tencent.mm.svg.b.b.gm(str);
        dmn = application;
        jF(application);
        AppMethodBeat.o(148737);
    }

    private static boolean b(Application application, Resources resources) {
        AppMethodBeat.i(148738);
        String str = sPackageName + ".svg.SVGPreload";
        try {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str);
            long nanoTime = System.nanoTime();
            dmn = application;
            OuS = cls;
            sResources = resources;
            try {
                if (OuS != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ((d) cls.newInstance()).load(c(application, sResources));
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s, spent %s", Integer.valueOf(c(application, sResources).Ouu.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    OuK = true;
                }
            } catch (Resources.NotFoundException e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "We found one NotFoundException.", new Object[0]);
                OuK = false;
            }
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            AppMethodBeat.o(148738);
            return true;
        } catch (ClassNotFoundException e3) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str);
            AppMethodBeat.o(148738);
            return false;
        } catch (InstantiationException e4) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e4, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str);
            AppMethodBeat.o(148738);
            return false;
        } catch (IllegalAccessException e5) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str);
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e5, "", new Object[0]);
            AppMethodBeat.o(148738);
            return false;
        }
    }

    public static void a(Application application, Resources resources, String str) {
        boolean z;
        AppMethodBeat.i(148739);
        c(application, str);
        if (OuT) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
            AppMethodBeat.o(148739);
            return;
        }
        try {
            if (!b(application, resources)) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                long nanoTime = System.nanoTime();
                jF(application);
                try {
                    d(application, resources);
                } catch (ClassNotFoundException e2) {
                    com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                AppMethodBeat.o(148739);
                return;
            }
            OuT = true;
            AppMethodBeat.o(148739);
        } catch (StackOverflowError e3) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e3, "", new Object[0]);
            try {
                z = b(application, resources);
            } catch (StackOverflowError e4) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "StackOverflowError again.", new Object[0]);
                z = false;
            }
            if (!z) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                long nanoTime2 = System.nanoTime();
                jF(application);
                try {
                    d(application, resources);
                } catch (ClassNotFoundException e5) {
                    com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e5, "", new Object[0]);
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                AppMethodBeat.o(148739);
                return;
            }
            OuT = true;
            AppMethodBeat.o(148739);
        } catch (Throwable th) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
            long nanoTime3 = System.nanoTime();
            jF(application);
            try {
                d(application, resources);
            } catch (ClassNotFoundException e6) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e6, "", new Object[0]);
            }
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime3) / 1000));
            AppMethodBeat.o(148739);
            throw th;
        }
    }

    private static c c(Application application, Resources resources) {
        AppMethodBeat.i(148740);
        if (OuL == null) {
            synchronized (e.class) {
                try {
                    if (OuL == null) {
                        OuL = new c(a.gFO(), application, resources);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(148740);
                    throw th;
                }
            }
        }
        c cVar = OuL;
        AppMethodBeat.o(148740);
        return cVar;
    }

    @TargetApi(16)
    private static void jF(Context context) {
        Object resources;
        AppMethodBeat.i(148741);
        if (OuO == null) {
            try {
                OuN = new LongSparseArray<>();
                C2067e<Drawable.ConstantState> eVar = new C2067e<>();
                OuO = eVar;
                eVar.OuN = (LongSparseArray<T>) OuN;
                C2067e<Drawable.ConstantState> eVar2 = new C2067e<>();
                OuP = eVar2;
                eVar2.OuN = (LongSparseArray<T>) OuN;
                if (Build.VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "mResourcesImpl");
                    if (aVar.apg()) {
                        resources = aVar.get();
                    } else {
                        resources = context.getResources();
                    }
                } else {
                    resources = context.getResources();
                }
                a(context, resources);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
                AppMethodBeat.o(148741);
                return;
            } catch (NoSuchFieldException e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
                AppMethodBeat.o(148741);
                return;
            } catch (IllegalAccessException e3) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e3, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
                AppMethodBeat.o(148741);
                return;
            } catch (IllegalArgumentException e4) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e4, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
        AppMethodBeat.o(148741);
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        AppMethodBeat.i(148742);
        Object obj2 = new com.tencent.mm.svg.b.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
            AppMethodBeat.o(148742);
        } else if (obj2 instanceof LongSparseArray[]) {
            OuM = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", OuM[0]);
            for (int i2 = 0; i2 < OuM[0].size(); i2++) {
                long keyAt = OuM[0].keyAt(i2);
                OuO.put(keyAt, OuM[0].get(keyAt));
            }
            for (int i3 = 0; i3 < OuM[1].size(); i3++) {
                long keyAt2 = OuM[1].keyAt(i3);
                OuP.put(keyAt2, OuM[1].get(keyAt2));
            }
            OuM[0] = OuO;
            OuM[1] = OuP;
            AppMethodBeat.o(148742);
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i4 = 0; i4 < longSparseArray.size(); i4++) {
                long keyAt3 = longSparseArray.keyAt(i4);
                OuO.put(keyAt3, longSparseArray.get(keyAt3));
            }
            C2067e<Drawable.ConstantState> eVar = OuO;
            aVar.prepare();
            if (aVar.bUo == null) {
                NoSuchFieldException noSuchFieldException = new NoSuchFieldException();
                AppMethodBeat.o(148742);
                throw noSuchFieldException;
            }
            aVar.bUo.set(aVar.obj, eVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
            AppMethodBeat.o(148742);
        } else {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
            AppMethodBeat.o(148742);
        }
    }

    private static Class<?> gFT() {
        AppMethodBeat.i(148743);
        if (dmm != null) {
            Class<?> cls = dmm;
            AppMethodBeat.o(148743);
            return cls;
        }
        try {
            Class<?> cls2 = Class.forName(sPackageName + ".R$raw");
            if (cls2 != null) {
                AppMethodBeat.o(148743);
                return cls2;
            }
        } catch (ClassNotFoundException e2) {
        }
        Class<?> gFY = com.tencent.mm.svg.b.b.gFY();
        if (gFY != null) {
            AppMethodBeat.o(148743);
            return gFY;
        }
        AppMethodBeat.o(148743);
        return null;
    }

    private static void d(Application application, Resources resources) {
        AppMethodBeat.i(148744);
        Class<?> gFT = gFT();
        if (gFT == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            AppMethodBeat.o(148744);
            return;
        }
        Field[] declaredFields = gFT.getDeclaredFields();
        c c2 = c(application, resources);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i2 = field.getInt(null);
                if (aVar.j(application.getResources(), i2)) {
                    c2.akD(i2);
                }
            }
            OuK = true;
            AppMethodBeat.o(148744);
        } catch (IllegalAccessException e2) {
            OuK = false;
            AppMethodBeat.o(148744);
        } catch (IllegalArgumentException e3) {
            OuK = false;
            AppMethodBeat.o(148744);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        Drawable.ConstantState Ovc;
        boolean Ovd;

        b(Drawable.ConstantState constantState, boolean z) {
            this.Ovc = constantState;
            this.Ovd = z;
        }
    }

    private static final TypedValue gFU() {
        TypedValue typedValue = null;
        AppMethodBeat.i(148745);
        synchronized (OuY) {
            try {
                if (OuZ != null) {
                    typedValue = OuZ;
                    OuZ = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(148745);
                throw th;
            }
        }
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            AppMethodBeat.o(148745);
            return typedValue2;
        }
        AppMethodBeat.o(148745);
        return typedValue;
    }

    private static final void b(TypedValue typedValue) {
        synchronized (OuY) {
            if (OuZ == null) {
                OuZ = typedValue;
            }
        }
    }

    private static b a(long j2, d dVar) {
        AppMethodBeat.i(148746);
        try {
            if (OuQ == null || OuQ.indexOfKey(j2) < 0) {
                TypedValue gFU = gFU();
                try {
                    dVar.mResources.getValue(dVar.GRb, gFU, true);
                    if (j2 == ((((long) gFU.assetCookie) << 32) | ((long) gFU.data))) {
                        b(gFU);
                        AppMethodBeat.o(148746);
                        return null;
                    }
                    int i2 = gFU.data;
                    b(gFU);
                    com.tencent.mm.svg.b.c.w("MicroMsg.SVGResourceLoader", "Found a res need justify, %s %s %s", Integer.valueOf(dVar.GRb), Long.valueOf(j2), Integer.valueOf(i2));
                    if (OuR == null) {
                        OuR = new a();
                    }
                    String a2 = OuR.a(sResources.getAssets(), j2);
                    if (a2 == null) {
                        AppMethodBeat.o(148746);
                        return null;
                    } else if (!a2.endsWith(".svg")) {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Found a res not SVG, %s %s", Long.valueOf(j2), a2);
                        b bVar = new b(null, true);
                        AppMethodBeat.o(148746);
                        return bVar;
                    } else {
                        String substring = a2.substring(a2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP) + 1, a2.lastIndexOf("."));
                        int identifier = dVar.mResources.getIdentifier(substring, ShareConstants.DEXMODE_RAW, dmn.getPackageName());
                        if (identifier == 0) {
                            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG failed, %s %s %s", Integer.valueOf(identifier), Long.valueOf(j2), substring);
                            AppMethodBeat.o(148746);
                            return null;
                        }
                        if (OuQ == null) {
                            OuQ = new LongSparseArray<>();
                        }
                        b bVar2 = new b(new d(identifier, dVar.mResources, j2, i2), false);
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "Justified SVG done, %s %s %s", Integer.valueOf(identifier), Long.valueOf(j2), substring);
                        OuQ.put(j2, bVar2);
                        AppMethodBeat.o(148746);
                        return bVar2;
                    }
                } catch (Throwable th) {
                    b(gFU);
                    AppMethodBeat.o(148746);
                    throw th;
                }
            } else {
                b bVar3 = OuQ.get(j2);
                AppMethodBeat.o(148746);
                return bVar3;
            }
        } catch (Throwable th2) {
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th2, "", new Object[0]);
            AppMethodBeat.o(148746);
            return null;
        }
    }

    @TargetApi(16)
    /* renamed from: com.tencent.mm.svg.a.e$e  reason: collision with other inner class name */
    public static class C2067e<T> extends LongSparseArray<T> {
        public static boolean Ovh = false;
        LongSparseArray<T> OuN = null;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.Drawable$ConstantState] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.util.LongSparseArray
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final T get(long r8, T r10) {
            /*
            // Method dump skipped, instructions count: 119
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.svg.a.e.C2067e.get(long, java.lang.Object):java.lang.Object");
        }

        public final void delete(long j2) {
            AppMethodBeat.i(148732);
            super.delete(j2);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j2));
            AppMethodBeat.o(148732);
        }

        public final void remove(long j2) {
            AppMethodBeat.i(148733);
            super.remove(j2);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j2));
            AppMethodBeat.o(148733);
        }

        public final void clear() {
            AppMethodBeat.i(148734);
            super.clear();
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
            AppMethodBeat.o(148734);
        }
    }

    public static class c {
        private TypedValue Oup = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> Ouu;
        private Application Ove;
        private Resources mResources;

        public c(Map<Integer, com.tencent.mm.svg.c> map, Application application, Resources resources) {
            AppMethodBeat.i(148724);
            this.Ouu = map;
            this.Ove = application;
            this.mResources = resources;
            AppMethodBeat.o(148724);
        }

        public final void p(Integer num) {
            AppMethodBeat.i(214355);
            e.a(this.Ove, this.mResources, num.intValue(), this.Oup);
            AppMethodBeat.o(214355);
        }

        public final void akD(int i2) {
            AppMethodBeat.i(148726);
            e.a(this.Ove, this.mResources, i2, this.Oup);
            AppMethodBeat.o(148726);
        }
    }

    /* access modifiers changed from: protected */
    public static class a {
        private Field Ova;
        private Method Ovb;
        private boolean mInited = false;

        public a() {
            AppMethodBeat.i(148722);
            try {
                if (Build.VERSION.SDK_INT > 28 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT != 0)) {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "below 28", new Object[0]);
                    AppMethodBeat.o(148722);
                    return;
                }
                this.Ova = AssetManager.class.getDeclaredField("mApkAssets");
                this.Ova.setAccessible(true);
                this.Ovb = Class.forName("android.content.res.ApkAssets").getDeclaredMethod("getStringFromPool", Integer.TYPE);
                this.Ovb.setAccessible(true);
                this.mInited = true;
                AppMethodBeat.o(148722);
            } catch (Throwable th) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                AppMethodBeat.o(148722);
            }
        }

        public final String a(AssetManager assetManager, long j2) {
            AppMethodBeat.i(148723);
            if (!this.mInited) {
                AppMethodBeat.o(148723);
                return null;
            }
            int i2 = (int) (j2 >> 32);
            int i3 = (int) (Util.MAX_32BIT_VALUE & j2);
            try {
                Object obj = ((Object[]) this.Ova.get(assetManager))[i2 - 1];
                String str = (String) this.Ovb.invoke(obj, Integer.valueOf(i3));
                AppMethodBeat.o(148723);
                return str;
            } catch (Throwable th) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", th, "", new Object[0]);
                AppMethodBeat.o(148723);
                return null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public static class d extends Drawable.ConstantState {
        private int GRb = 0;
        private long Ovf = 0;
        private int Ovg = 0;
        private Resources mResources;

        public d(int i2, Resources resources, long j2, int i3) {
            AppMethodBeat.i(148727);
            if (i2 == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i2));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.GRb = i2;
            this.mResources = resources;
            this.Ovf = j2;
            this.Ovg = i3;
            AppMethodBeat.o(148727);
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(148728);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources %s %s %s %s", this.mResources, Integer.valueOf(this.GRb), Long.valueOf(this.Ovf), Integer.valueOf(this.Ovg));
            Drawable h2 = a.h(this.mResources, this.GRb);
            AppMethodBeat.o(148728);
            return h2;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.i(148729);
            try {
                Map i2 = e.i(resources);
                if (i2 != null) {
                    int intValue = ((Integer) i2.get(Long.valueOf(this.Ovf))).intValue();
                    Drawable g2 = e.g(resources, intValue);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(intValue) + ",drawable:" + g2, new Object[0]);
                    AppMethodBeat.o(148729);
                    return g2;
                }
            } catch (Exception e2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + e2.getMessage(), new Object[0]);
            }
            Drawable newDrawable = newDrawable();
            AppMethodBeat.o(148729);
            return newDrawable;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AppMethodBeat.i(148730);
            Drawable newDrawable = newDrawable(resources);
            AppMethodBeat.o(148730);
            return newDrawable;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public static Drawable f(Resources resources, int i2) {
        AppMethodBeat.i(148747);
        if (resources == null) {
            AppMethodBeat.o(148747);
            return null;
        }
        OuW.set(Boolean.TRUE);
        Drawable drawable = resources.getDrawable(i2);
        OuW.set(Boolean.FALSE);
        AppMethodBeat.o(148747);
        return drawable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable g(android.content.res.Resources r9, int r10) {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.svg.a.e.g(android.content.res.Resources, int):android.graphics.drawable.Drawable");
    }

    static /* synthetic */ boolean bHp() {
        return Build.VERSION.SDK_INT >= 28 && OuX;
    }

    static /* synthetic */ void a(Application application, Resources resources, int i2, TypedValue typedValue) {
        AppMethodBeat.i(148750);
        if (i2 == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i2), typedValue);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i2, typedValue, true);
        long j2 = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        d dVar = new d(i2, application.getResources(), j2, typedValue.data);
        synchronized (OuN) {
            try {
                OuN.put(j2, dVar);
            } finally {
                AppMethodBeat.o(148750);
            }
        }
    }

    static /* synthetic */ Map i(Resources resources) {
        AppMethodBeat.i(148751);
        for (WeakReference<Resources> weakReference : OuU.keySet()) {
            Resources resources2 = weakReference.get();
            if (resources2 != null && resources2 == resources) {
                Map<Long, Integer> map = OuU.get(weakReference);
                AppMethodBeat.o(148751);
                return map;
            }
        }
        AppMethodBeat.o(148751);
        return null;
    }
}
