package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

public final class j extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> mdL;

    /* access modifiers changed from: package-private */
    public interface b {
        com.tencent.mm.vending.j.a i(AppBrandRuntime appBrandRuntime, String str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(139878);
        final s sVar2 = sVar;
        sVar2.getAppId();
        final String optString = jSONObject.optString("src");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(139878);
            return;
        }
        final WeakReference weakReference = new WeakReference(sVar2);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.j.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:3:0x0017  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 240
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.j.AnonymousClass1.run():void");
            }
        }, String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", optString), 10);
        AppMethodBeat.o(139878);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.j$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] mdO = new int[e.values().length];

        static {
            AppMethodBeat.i(139872);
            try {
                mdO[e.FILE_NOT_FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mdO[e.RESOLVED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                mdO[e.UNKNOWN_FAIL.ordinal()] = 3;
                AppMethodBeat.o(139872);
            } catch (NoSuchFieldError e4) {
                AppMethodBeat.o(139872);
            }
        }
    }

    static {
        AppMethodBeat.i(139879);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new a((byte) 0));
        linkedList.add(new d((byte) 0));
        mdL = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(139879);
    }

    enum e {
        FILE_NOT_FOUND,
        UNKNOWN_FAIL,
        RESOLVED;

        public static e valueOf(String str) {
            AppMethodBeat.i(139876);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(139876);
            return eVar;
        }

        static {
            AppMethodBeat.i(139877);
            AppMethodBeat.o(139877);
        }
    }

    static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.j.b
        public final com.tencent.mm.vending.j.a i(AppBrandRuntime appBrandRuntime, String str) {
            AppMethodBeat.i(139873);
            o VY = appBrandRuntime.getFileSystem().VY(str);
            if (VY == null) {
                AppMethodBeat.o(139873);
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(aa.z(VY.her()), options);
            c cVar = new c((byte) 0);
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.luggage.e.a.a.e(options);
            cVar.cBG = com.tencent.luggage.e.a.a.d(options) ? com.tencent.luggage.e.a.a.hN(com.tencent.luggage.e.a.a.getExifOrientation(aa.z(VY.her()))) : "up";
            com.tencent.mm.vending.j.c Q = com.tencent.mm.vending.j.a.Q(e.RESOLVED, cVar);
            AppMethodBeat.o(139873);
            return Q;
        }
    }

    static final class d implements b {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.media.j.b
        public final com.tencent.mm.vending.j.a i(AppBrandRuntime appBrandRuntime, String str) {
            AppMethodBeat.i(139874);
            InputStream f2 = bg.f(appBrandRuntime, str);
            if (f2 != null) {
                f2.mark(0);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(f2, new Rect(), options);
                c cVar = new c((byte) 0);
                cVar.width = options.outWidth;
                cVar.height = options.outHeight;
                cVar.type = com.tencent.luggage.e.a.a.e(options);
                boolean d2 = com.tencent.luggage.e.a.a.d(options);
                try {
                    f2.reset();
                } catch (IOException e2) {
                }
                cVar.cBG = d2 ? com.tencent.luggage.e.a.a.hN(com.tencent.luggage.e.a.a.m(f2)) : "up";
                Util.qualityClose(f2);
                com.tencent.mm.vending.j.c Q = com.tencent.mm.vending.j.a.Q(e.RESOLVED, cVar);
                AppMethodBeat.o(139874);
                return Q;
            }
            com.tencent.mm.vending.j.b ep = com.tencent.mm.vending.j.a.ep(e.FILE_NOT_FOUND);
            AppMethodBeat.o(139874);
            return ep;
        }
    }

    static final class c {
        public String cBG;
        public int height;
        public String type;
        public int width;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }
}
