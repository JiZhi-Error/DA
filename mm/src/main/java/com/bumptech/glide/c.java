package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.k;
import com.bumptech.glide.load.b.a.b;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.j;
import com.bumptech.glide.load.b.b.g;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.b.i;
import com.bumptech.glide.load.b.d.a;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.a;
import com.bumptech.glide.load.c.a.a;
import com.bumptech.glide.load.c.a.b;
import com.bumptech.glide.load.c.a.c;
import com.bumptech.glide.load.c.a.d;
import com.bumptech.glide.load.c.a.e;
import com.bumptech.glide.load.c.b;
import com.bumptech.glide.load.c.d;
import com.bumptech.glide.load.c.e;
import com.bumptech.glide.load.c.f;
import com.bumptech.glide.load.c.k;
import com.bumptech.glide.load.c.s;
import com.bumptech.glide.load.c.t;
import com.bumptech.glide.load.c.u;
import com.bumptech.glide.load.c.v;
import com.bumptech.glide.load.c.w;
import com.bumptech.glide.load.c.x;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.d.a.p;
import com.bumptech.glide.load.d.a.r;
import com.bumptech.glide.load.d.a.s;
import com.bumptech.glide.load.d.b.a;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.f;
import com.bumptech.glide.manager.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class c implements ComponentCallbacks2 {
    private static volatile c aCg;
    private static volatile boolean aCh;
    private final k aCi;
    public final e aCj;
    private final h aCk;
    private final a aCl;
    public final e aCm;
    public final h aCn;
    public final b aCo;
    public final l aCp;
    final d aCq;
    final List<j> aCr = new ArrayList();
    private f aCs = f.NORMAL;

    public static c af(Context context) {
        AppMethodBeat.i(76772);
        if (aCg == null) {
            synchronized (c.class) {
                try {
                    if (aCg == null) {
                        if (aCh) {
                            IllegalStateException illegalStateException = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
                            AppMethodBeat.o(76772);
                            throw illegalStateException;
                        }
                        aCh = true;
                        a(context, new d());
                        aCh = false;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(76772);
                    throw th;
                }
            }
        }
        c cVar = aCg;
        AppMethodBeat.o(76772);
        return cVar;
    }

    private static void a(Context context, d dVar) {
        AppMethodBeat.i(76773);
        Context applicationContext = context.getApplicationContext();
        a nN = nN();
        Collections.emptyList();
        List<com.bumptech.glide.c.b> pU = new com.bumptech.glide.c.d(applicationContext).pU();
        if (nN != null && !nN.nM().isEmpty()) {
            Set<Class<?>> nM = nN.nM();
            Iterator<com.bumptech.glide.c.b> it = pU.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.c.b next = it.next();
                if (nM.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        new StringBuilder("AppGlideModule excludes manifest GlideModule: ").append(next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (com.bumptech.glide.c.b bVar : pU) {
                new StringBuilder("Discovered GlideModule from manifest: ").append(bVar.getClass());
            }
        }
        dVar.aCA = null;
        Iterator<com.bumptech.glide.c.b> it2 = pU.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        if (dVar.aCu == null) {
            dVar.aCu = com.bumptech.glide.load.b.c.a.pn();
        }
        if (dVar.aCv == null) {
            dVar.aCv = com.bumptech.glide.load.b.c.a.pm();
        }
        if (dVar.aCB == null) {
            dVar.aCB = com.bumptech.glide.load.b.c.a.pp();
        }
        if (dVar.aCx == null) {
            dVar.aCx = new i(new i.a(applicationContext));
        }
        if (dVar.aCq == null) {
            dVar.aCq = new f();
        }
        if (dVar.aCj == null) {
            int i2 = dVar.aCx.aJb;
            if (i2 > 0) {
                dVar.aCj = new com.bumptech.glide.load.b.a.k((long) i2);
            } else {
                dVar.aCj = new com.bumptech.glide.load.b.a.f();
            }
        }
        if (dVar.aCo == null) {
            dVar.aCo = new j(dVar.aCx.aJd);
        }
        if (dVar.aCk == null) {
            dVar.aCk = new g((long) dVar.aCx.aJc);
        }
        if (dVar.aCw == null) {
            dVar.aCw = new com.bumptech.glide.load.b.b.f(applicationContext);
        }
        if (dVar.aCi == null) {
            dVar.aCi = new k(dVar.aCk, dVar.aCw, dVar.aCv, dVar.aCu, com.bumptech.glide.load.b.c.a.po(), com.bumptech.glide.load.b.c.a.pp(), dVar.aCC);
        }
        if (dVar.aCD == null) {
            dVar.aCD = Collections.emptyList();
        } else {
            dVar.aCD = Collections.unmodifiableList(dVar.aCD);
        }
        l lVar = new l(dVar.aCA);
        k kVar = dVar.aCi;
        h hVar = dVar.aCk;
        e eVar = dVar.aCj;
        b bVar2 = dVar.aCo;
        d dVar2 = dVar.aCq;
        int i3 = dVar.aCy;
        com.bumptech.glide.e.f fVar = dVar.aCz;
        fVar.aHY = true;
        c cVar = new c(applicationContext, kVar, hVar, eVar, bVar2, lVar, dVar2, i3, fVar, dVar.aCt, dVar.aCD, dVar.aCE);
        Iterator<com.bumptech.glide.c.b> it3 = pU.iterator();
        while (it3.hasNext()) {
            it3.next();
        }
        applicationContext.registerComponentCallbacks(cVar);
        aCg = cVar;
        AppMethodBeat.o(76773);
    }

    private static a nN() {
        a aVar;
        AppMethodBeat.i(76774);
        try {
            aVar = (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e2) {
            Log.isLoggable("Glide", 5);
            aVar = null;
        } catch (InstantiationException e3) {
            d(e3);
            aVar = null;
        } catch (IllegalAccessException e4) {
            d(e4);
            aVar = null;
        } catch (NoSuchMethodException e5) {
            d(e5);
            aVar = null;
        } catch (InvocationTargetException e6) {
            d(e6);
            aVar = null;
        }
        AppMethodBeat.o(76774);
        return aVar;
    }

    private static void d(Exception exc) {
        AppMethodBeat.i(76775);
        IllegalStateException illegalStateException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
        AppMethodBeat.o(76775);
        throw illegalStateException;
    }

    private c(Context context, k kVar, h hVar, e eVar, b bVar, l lVar, d dVar, int i2, com.bumptech.glide.e.f fVar, Map<Class<?>, k<?, ?>> map, List<com.bumptech.glide.e.e<Object>> list, boolean z) {
        AppMethodBeat.i(204440);
        this.aCi = kVar;
        this.aCj = eVar;
        this.aCo = bVar;
        this.aCk = hVar;
        this.aCp = lVar;
        this.aCq = dVar;
        this.aCl = new a(hVar, eVar, (com.bumptech.glide.load.b) fVar.aFV.a(com.bumptech.glide.load.d.a.h.aLc));
        Resources resources = context.getResources();
        this.aCn = new h();
        this.aCn.a(new com.bumptech.glide.load.d.a.f());
        if (Build.VERSION.SDK_INT >= 27) {
            this.aCn.a(new com.bumptech.glide.load.d.a.k());
        }
        List<ImageHeaderParser> nO = this.aCn.nO();
        com.bumptech.glide.load.d.a.h hVar2 = new com.bumptech.glide.load.d.a.h(nO, resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.load.d.e.a aVar = new com.bumptech.glide.load.d.e.a(context, nO, eVar, bVar);
        com.bumptech.glide.load.j<ParcelFileDescriptor, Bitmap> b2 = s.b(eVar);
        com.bumptech.glide.load.d.a.e eVar2 = new com.bumptech.glide.load.d.a.e(hVar2);
        p pVar = new p(hVar2, bVar);
        com.bumptech.glide.load.d.c.d dVar2 = new com.bumptech.glide.load.d.c.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.bumptech.glide.load.d.a.c cVar2 = new com.bumptech.glide.load.d.a.c(bVar);
        com.bumptech.glide.load.d.f.a aVar3 = new com.bumptech.glide.load.d.f.a();
        com.bumptech.glide.load.d.f.d dVar4 = new com.bumptech.glide.load.d.f.d();
        ContentResolver contentResolver = context.getContentResolver();
        this.aCn.a(ByteBuffer.class, new com.bumptech.glide.load.c.c()).a(InputStream.class, new t(bVar)).a("Bitmap", ByteBuffer.class, Bitmap.class, eVar2).a("Bitmap", InputStream.class, Bitmap.class, pVar).a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, b2).a("Bitmap", AssetFileDescriptor.class, Bitmap.class, com.bumptech.glide.load.d.a.s.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.pw()).a("Bitmap", Bitmap.class, Bitmap.class, new r()).a(Bitmap.class, (com.bumptech.glide.load.k) cVar2).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, eVar2)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, pVar)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.d.a.a(resources, b2)).a(BitmapDrawable.class, (com.bumptech.glide.load.k) new com.bumptech.glide.load.d.a.b(eVar, cVar2)).a("Gif", InputStream.class, com.bumptech.glide.load.d.e.c.class, new com.bumptech.glide.load.d.e.j(nO, aVar, bVar)).a("Gif", ByteBuffer.class, com.bumptech.glide.load.d.e.c.class, aVar).a(com.bumptech.glide.load.d.e.c.class, (com.bumptech.glide.load.k) new com.bumptech.glide.load.d.e.d()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, v.a.pw()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.d.e.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new o(dVar2, eVar)).a(new a.C0075a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.bumptech.glide.load.d.d.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.pw()).a(new k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(com.bumptech.glide.load.c.g.class, InputStream.class, new a.C0071a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.pw()).a(Drawable.class, Drawable.class, v.a.pw()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.d.c.e()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.d.f.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.bumptech.glide.load.d.f.c(eVar, aVar3, dVar4)).a(com.bumptech.glide.load.d.e.c.class, byte[].class, dVar4);
        this.aCm = new e(context, bVar, this.aCn, new com.bumptech.glide.e.a.b(), fVar, map, list, kVar, z, i2);
        AppMethodBeat.o(204440);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(com.bumptech.glide.e.a.e<?> eVar) {
        AppMethodBeat.i(76778);
        synchronized (this.aCr) {
            try {
                for (j jVar : this.aCr) {
                    if (jVar.d(eVar)) {
                        return true;
                    }
                }
                AppMethodBeat.o(76778);
                return false;
            } finally {
                AppMethodBeat.o(76778);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public static j ag(Context context) {
        AppMethodBeat.i(76777);
        com.bumptech.glide.g.j.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        j ai = af(context).aCp.ai(context);
        AppMethodBeat.o(76777);
        return ai;
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(76779);
        com.bumptech.glide.g.k.qv();
        this.aCk.trimMemory(i2);
        this.aCj.trimMemory(i2);
        this.aCo.trimMemory(i2);
        AppMethodBeat.o(76779);
    }

    public void onLowMemory() {
        AppMethodBeat.i(76780);
        com.bumptech.glide.g.k.qv();
        this.aCk.oZ();
        this.aCj.oZ();
        this.aCo.oZ();
        AppMethodBeat.o(76780);
    }
}
