package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appcache.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0010\u001a\u00020\t*\u0004\u0018\u00010\u0007J\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation;", "", "()V", "TAG", "", "mWeAppOpenBundleHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "executeStartAppForResult", "", "context", "Landroid/content/Context;", "openBundle", "pollOpenBundle", "hash", "", "assertValid", "toInternalParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class u {
    private static final SparseArray<g> mTC = new SparseArray<>();
    public static final u mTD = new u();

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation$toInternalParcel$1$2"})
    public static final class a<R extends Parcelable> implements com.tencent.luggage.sdk.launching.a<IPCString> {
        final /* synthetic */ g mTE;

        a(g gVar) {
            this.mTE = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.Parcelable] */
        @Override // com.tencent.luggage.sdk.launching.a
        public final /* synthetic */ void b(IPCString iPCString) {
            String str;
            AppMethodBeat.i(50757);
            IPCString iPCString2 = iPCString;
            ValueCallback<String> valueCallback = this.mTE.kHB;
            if (iPCString2 != null) {
                str = iPCString2.value;
            } else {
                str = null;
            }
            valueCallback.onReceiveValue(str);
            AppMethodBeat.o(50757);
        }
    }

    static {
        AppMethodBeat.i(50758);
        AppMethodBeat.o(50758);
    }

    private u() {
    }

    public static g yi(int i2) {
        AppMethodBeat.i(228648);
        synchronized (mTC) {
            try {
                int indexOfKey = mTC.indexOfKey(i2);
                if (indexOfKey >= 0) {
                    g valueAt = mTC.valueAt(indexOfKey);
                    if (valueAt != null) {
                        mTC.removeAt(indexOfKey);
                    } else {
                        valueAt = null;
                    }
                    return valueAt;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(228648);
                return null;
            } finally {
                AppMethodBeat.o(228648);
            }
        }
    }

    public static void a(g gVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(228649);
        if (gVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(new NullPointerException());
            AppMethodBeat.o(228649);
            throw illegalArgumentException;
        }
        String str = gVar.username;
        if (str == null || str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String str2 = gVar.appId;
            if (str2 == null || str2.length() == 0) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Both username & appId is EMPTY");
                AppMethodBeat.o(228649);
                throw illegalArgumentException2;
            }
        }
        String str3 = gVar.username;
        if (str3 == null || str3.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            String str4 = gVar.username;
            p.g(str4, ch.COL_USERNAME);
            if (!n.nm(str4, "@app")) {
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid weapp username " + gVar.username);
                AppMethodBeat.o(228649);
                throw illegalArgumentException3;
            }
        }
        if (!j.a.vP(gVar.iOo) && !j.a.sE(gVar.iOo)) {
            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Invalid weapp versionType " + gVar.iOo);
            AppMethodBeat.o(228649);
            throw illegalArgumentException4;
        } else if (gVar.scene <= 1000) {
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("Invalid weapp enter scene " + gVar.scene);
            AppMethodBeat.o(228649);
            throw illegalArgumentException5;
        } else {
            AppMethodBeat.o(228649);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ef, code lost:
        if ((r0 == null || r0.length() == 0) == false) goto L_0x00f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel b(com.tencent.mm.plugin.appbrand.api.g r7) {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.u.b(com.tencent.mm.plugin.appbrand.api.g):com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel");
    }
}
