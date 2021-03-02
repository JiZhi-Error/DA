package com.tencent.mm.plugin.sns.ad.landingpage.helper.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.pluginsdk.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class a implements b, AdLandingPagesProxy.e, c {
    private Reference<Context> Duf;
    private AbstractC1706a Dug;
    private volatile boolean Duh;
    private String Dui;
    private Runnable Duj = new Runnable() {
        /* class com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(202013);
            try {
                a.this.a(3, "get_location:timeout", 0.0d, 0.0d, 0.0d, 0.0d);
                AppMethodBeat.o(202013);
            } catch (Throwable th) {
                AppMethodBeat.o(202013);
            }
        }
    };
    private MMHandler kAn;

    /* renamed from: com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1706a {
        void aH(Map<String, Object> map);
    }

    public static b a(Context context, AbstractC1706a aVar) {
        a aVar2;
        AppMethodBeat.i(202015);
        if (context == null) {
            AppMethodBeat.o(202015);
            return null;
        }
        try {
            aVar2 = new a(context, aVar);
        } catch (Throwable th) {
            aVar2 = null;
        }
        AppMethodBeat.o(202015);
        return aVar2;
    }

    private a(Context context, AbstractC1706a aVar) {
        AppMethodBeat.i(202016);
        this.Duf = new WeakReference(context);
        this.kAn = new MMHandler(Looper.getMainLooper());
        this.Dug = aVar;
        AppMethodBeat.o(202016);
    }

    private void start(String str) {
        AppMethodBeat.i(202017);
        if (str == null) {
            str = "";
        }
        AdLandingPagesProxy.getInstance().geoLocation(str, this);
        AppMethodBeat.o(202017);
    }

    @Override // com.tencent.mm.pluginsdk.permission.c
    public final void b(int i2, int[] iArr) {
        boolean z = false;
        AppMethodBeat.i(202018);
        if (i2 == 1) {
            if (iArr != null) {
                try {
                    int length = iArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (iArr[i3] != 0) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(202018);
                    return;
                }
            }
            z = true;
            if (z) {
                start(this.Dui);
                AppMethodBeat.o(202018);
                return;
            }
            a(1, "get_location:no_permission", 0.0d, 0.0d, 0.0d, 0.0d);
        }
        AppMethodBeat.o(202018);
    }

    @Override // com.tencent.mm.plugin.sns.ad.landingpage.helper.a.b
    public final void request(String str) {
        boolean z;
        AppMethodBeat.i(202019);
        try {
            Log.d("GeoClientRequester", "the geo request is called, and the getType is ".concat(String.valueOf(str)));
            this.kAn.removeCallbacks(this.Duj);
            this.kAn.postDelayed(this.Duj, 20000);
            this.Dui = str;
            Context context = this.Duf.get();
            if (context == null) {
                z = false;
            } else if (!b.n(context, "android.permission.ACCESS_FINE_LOCATION")) {
                b.a(1, this, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
                z = false;
            } else {
                z = true;
            }
            if (z) {
                start(str);
            }
            AppMethodBeat.o(202019);
        } catch (Throwable th) {
            AppMethodBeat.o(202019);
        }
    }

    @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
    public final void bn(Object obj) {
        int i2 = 0;
        AppMethodBeat.i(202020);
        if (obj instanceof Bundle) {
            try {
                Bundle bundle = (Bundle) obj;
                bundle.setClassLoader(getClass().getClassLoader());
                boolean z = g.getBoolean(bundle, "result", false);
                double h2 = g.h(bundle, "latitude");
                double h3 = g.h(bundle, "longitude");
                double h4 = g.h(bundle, "accuracy");
                double h5 = g.h(bundle, "speed");
                if (!z) {
                    i2 = 2;
                }
                a(i2, z ? "get_location:ok" : "get_location:failed", h2, h3, h5, h4);
                AppMethodBeat.o(202020);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202020);
    }

    @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
    public final void h(int i2, int i3, Object obj) {
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, final String str, final double d2, final double d3, final double d4, final double d5) {
        AppMethodBeat.i(202021);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            b(i2, str, d2, d3, d4, d5);
            AppMethodBeat.o(202021);
            return;
        }
        this.kAn.post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.ad.landingpage.helper.a.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(202014);
                try {
                    a.this.b(i2, str, d2, d3, d4, d5);
                    AppMethodBeat.o(202014);
                } catch (Throwable th) {
                    AppMethodBeat.o(202014);
                }
            }
        });
        AppMethodBeat.o(202021);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, String str, double d2, double d3, double d4, double d5) {
        AppMethodBeat.i(202022);
        try {
            Log.d("GeoClientRequester", "the doCallback is called, latitude = ".concat(String.valueOf(d2)));
            if (!this.Duh) {
                this.Duh = true;
                if (this.Dug != null) {
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put("ret", Integer.valueOf(i2));
                    arrayMap.put("err_msg", str);
                    if (i2 == 0) {
                        arrayMap.put("latitude", Double.valueOf(d2));
                        arrayMap.put("longitude", Double.valueOf(d3));
                        arrayMap.put("speed", Double.valueOf(d4));
                        arrayMap.put("accuracy", Double.valueOf(d5));
                    }
                    this.Dug.aH(arrayMap);
                }
                this.kAn.removeCallbacks(this.Duj);
            }
            AppMethodBeat.o(202022);
        } catch (Throwable th) {
            Log.e("GeoClientRequester", "the do Callback has something wrong");
            AppMethodBeat.o(202022);
        }
    }
}
