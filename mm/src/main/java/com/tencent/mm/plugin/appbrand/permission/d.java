package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class d {
    private static final Map<Class<? extends e>, Integer> nxn = new ConcurrentHashMap();
    private static final Map<Class<? extends e>, String> nxo = new ConcurrentHashMap();
    public static final String[] nxx = {com.tencent.mm.plugin.appbrand.jsapi.o.e.NAME, "createDownloadTask", com.tencent.mm.plugin.appbrand.jsapi.o.b.b.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.c.b.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.c.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.b.c.NAME, com.tencent.mm.plugin.appbrand.jsapi.o.c.c.NAME};
    public final AppBrandRuntime kEc;
    public final int nxp;
    private final boolean nxq;
    public final LinkedList<b> nxr = new LinkedList<>();
    public final Object nxs;
    private AppRuntimeApiPermissionBundle nxt;
    private final byte[] nxu;
    private HashMap<String, AppRuntimeApiPermissionBundle> nxv = new HashMap<>();
    public List<c> nxw = new ArrayList();

    public interface b {
        void a(a aVar);
    }

    public interface c {
        void g(byte[] bArr, byte[] bArr2);
    }

    public static final class a {
        private static final a nxA = new a(-1, "fail:auth canceled");
        private static final a nxB = new a(-1, "fail:auth denied");
        private static final a nxC = new a(-2, "");
        private static final a nxD = new a(-1, "fail:access denied");
        private static final a nxE = new a(0, "");
        public final String msg;
        public final int ret;

        public a(int i2, String str) {
            this.ret = i2;
            this.msg = str;
        }

        static {
            AppMethodBeat.i(147644);
            AppMethodBeat.o(147644);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.tencent.mm.plugin.appbrand.permission.d */
    /* JADX WARN: Multi-variable type inference failed */
    public final int a(f fVar, e eVar, String str, boolean z) {
        AppMethodBeat.i(147646);
        int a2 = a(fVar, eVar.getClass(), str, aE(eVar.getClass()), z);
        AppMethodBeat.o(147646);
        return a2;
    }

    private int a(f fVar, Class<? extends e> cls, String str, int i2, boolean z) {
        AppMethodBeat.i(147648);
        int i3 = this.nxp;
        String appId = fVar.getAppId();
        if (i3 == -1) {
            Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", appId, Integer.valueOf(i2));
            AppMethodBeat.o(147648);
            return 1;
        } else if (i3 == -2) {
            Log.d("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", appId, Integer.valueOf(i2));
            AppMethodBeat.o(147648);
            return 0;
        } else if (!cls.isAssignableFrom(aa.class) || !(fVar instanceof ac)) {
            String aF = aF(cls);
            int e2 = c.e(fVar, aF, str);
            if (e2 != Integer.MIN_VALUE) {
                AppMethodBeat.o(147648);
                return e2;
            }
            com.tencent.mm.plugin.appbrand.a.b[] bVarArr = new com.tencent.mm.plugin.appbrand.a.b[1];
            byte[] a2 = a(fVar, bVarArr);
            int H = H(a2, i2);
            if (z) {
                k kVar = (k) fVar.M(k.class);
                if (kVar == null || !kVar.aG(cls)) {
                    Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "getCtrlByte, appId = %s, apiName = %s, state = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", appId, aF, bVarArr[0], Integer.valueOf(i2), Integer.valueOf(a2.length), Integer.valueOf(H));
                }
            }
            AppMethodBeat.o(147648);
            return H;
        } else {
            AppMethodBeat.o(147648);
            return 1;
        }
    }

    public final byte[] a(f fVar, com.tencent.mm.plugin.appbrand.a.b[] bVarArr) {
        byte[] bArr;
        AppMethodBeat.i(229965);
        int i2 = this.nxp;
        if (i2 == -1) {
            byte[] bArr2 = {1};
            AppMethodBeat.o(229965);
            return bArr2;
        } else if (i2 == -2) {
            byte[] bArr3 = {0};
            AppMethodBeat.o(229965);
            return bArr3;
        } else {
            AppRuntimeApiPermissionBundle bSX = bSX();
            if (fVar instanceof s) {
                int[] iArr = AnonymousClass2.kRf;
                com.tencent.mm.plugin.appbrand.a.b bwY = this.kEc.kAH.kQM.bwY();
                switch (iArr[bwY.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        bArr = bSX.nxl;
                        break;
                    default:
                        bArr = bSX.nxk;
                        break;
                }
                if (bVarArr != null && bVarArr.length > 0) {
                    bVarArr[0] = bwY;
                }
            } else {
                bArr = bSX.nxk;
            }
            AppMethodBeat.o(229965);
            return bArr;
        }
    }

    public final int H(byte[] bArr, int i2) {
        int i3 = this.nxp;
        if (i3 == -1) {
            return 1;
        }
        if (i3 == -2) {
            return 0;
        }
        if (i2 == -2) {
            return 1;
        }
        if (i2 == -1) {
            return !this.nxq ? 0 : 1;
        }
        if (i2 >= bArr.length || i2 < 0) {
            return 0;
        }
        return bArr[i2];
    }

    public final boolean a(f fVar, Class<? extends e> cls) {
        AppMethodBeat.i(147650);
        switch (a(fVar, cls, null, aE(cls), false)) {
            case 0:
                AppMethodBeat.o(147650);
                return false;
            case 1:
                AppMethodBeat.o(147650);
                return true;
            case 2:
            case 3:
            case 5:
            default:
                AppMethodBeat.o(147650);
                return false;
            case 4:
                AppMethodBeat.o(147650);
                return false;
            case 6:
                l(fVar, aF(cls));
                AppMethodBeat.o(147650);
                return false;
            case 7:
                boolean bwZ = this.kEc.kAH.kQM.bwZ();
                AppMethodBeat.o(147650);
                return bwZ;
            case 8:
                AppMethodBeat.o(147650);
                return true;
        }
    }

    static {
        AppMethodBeat.i(147660);
        AppMethodBeat.o(147660);
    }

    private static int aE(Class<? extends e> cls) {
        int i2;
        AppMethodBeat.i(147652);
        Integer num = nxn.get(cls);
        if (num != null) {
            int intValue = num.intValue();
            AppMethodBeat.o(147652);
            return intValue;
        }
        try {
            i2 = ((Integer) org.a.a.bF(cls).get("CTRL_INDEX")).intValue();
        } catch (org.a.b e2) {
            Assert.assertTrue("Must declare CTRL_INDEX in JsApi Class: " + cls.getName(), true);
            i2 = -1;
        }
        nxn.put(cls, Integer.valueOf(i2));
        AppMethodBeat.o(147652);
        return i2;
    }

    private static String aF(Class<? extends e> cls) {
        AppMethodBeat.i(147653);
        String str = nxo.get(cls);
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(147653);
            return str;
        }
        try {
            String str2 = (String) org.a.a.bF(cls).get("NAME");
            nxo.put(cls, str2);
            AppMethodBeat.o(147653);
            return str2;
        } catch (org.a.b e2) {
            Assert.assertTrue("Must declare NAME in JsApi Class: " + cls.getName(), true);
            String simpleName = cls.getSimpleName();
            AppMethodBeat.o(147653);
            return simpleName;
        }
    }

    public d(AppBrandRuntime appBrandRuntime, int i2, boolean z) {
        AppMethodBeat.i(147654);
        this.kEc = appBrandRuntime;
        this.nxs = new byte[0];
        this.nxu = new byte[0];
        this.nxp = i2;
        this.nxq = z;
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = (AppRuntimeApiPermissionBundle) appBrandRuntime.d(AppRuntimeApiPermissionBundle.class, false);
        if (appRuntimeApiPermissionBundle == null) {
            Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "<init> get NULL permission from runtime");
        }
        a(appRuntimeApiPermissionBundle);
        if (((e) appBrandRuntime.d(e.class, false)) != null) {
            this.nxv = ((e) appBrandRuntime.d(e.class, false)).nxF;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.nxv == null ? 0 : this.nxv.size());
            Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "mPluginPermission size:%d", objArr);
        }
        AppMethodBeat.o(147654);
    }

    public final void a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.i(147655);
        if (appRuntimeApiPermissionBundle == null) {
            AppMethodBeat.o(147655);
            return;
        }
        synchronized (this.nxs) {
            try {
                AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle2 = this.nxt;
                if (appRuntimeApiPermissionBundle2 == null || appRuntimeApiPermissionBundle2.nxk.length <= appRuntimeApiPermissionBundle.nxk.length) {
                    this.nxt = appRuntimeApiPermissionBundle;
                    b(this.nxt);
                    Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission old %s, updated %s", appRuntimeApiPermissionBundle2, appRuntimeApiPermissionBundle);
                    AppMethodBeat.o(147655);
                    return;
                }
                Log.e("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePermission, old %s, new %s, ignore", appRuntimeApiPermissionBundle2, appRuntimeApiPermissionBundle);
            } finally {
                AppMethodBeat.o(147655);
            }
        }
    }

    public final void g(HashMap<String, AppRuntimeApiPermissionBundle> hashMap) {
        int i2 = 0;
        AppMethodBeat.i(229966);
        synchronized (this.nxu) {
            try {
                Object[] objArr = new Object[1];
                if (hashMap != null) {
                    i2 = hashMap.size();
                }
                objArr[0] = Integer.valueOf(i2);
                Log.i("MicroMsg.AppRuntimeApiPermissionController[permission]", "updatePluginPermission size:%d", objArr);
                this.nxv = hashMap;
            } finally {
                AppMethodBeat.o(229966);
            }
        }
    }

    private void b(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        AppMethodBeat.i(147656);
        byte[] bArr = appRuntimeApiPermissionBundle.nxk;
        byte[] bArr2 = appRuntimeApiPermissionBundle.nxl;
        for (int i2 = 0; i2 < this.nxw.size(); i2++) {
            this.nxw.get(i2).g(bArr, bArr2);
        }
        AppMethodBeat.o(147656);
    }

    public final Vector<byte[]> bSW() {
        AppMethodBeat.i(147657);
        synchronized (this.nxs) {
            try {
                if (this.nxt == null) {
                    return null;
                }
                byte[] bArr = this.nxt.nxk;
                byte[] bArr2 = this.nxt.nxl;
                byte[] bArr3 = this.nxt.nxm;
                Vector<byte[]> vector = new Vector<>(3);
                vector.addElement(bArr);
                vector.addElement(bArr2);
                vector.addElement(bArr3);
                AppMethodBeat.o(147657);
                return vector;
            } finally {
                AppMethodBeat.o(147657);
            }
        }
    }

    private AppRuntimeApiPermissionBundle bSX() {
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle;
        synchronized (this.nxs) {
            appRuntimeApiPermissionBundle = this.nxt;
        }
        return appRuntimeApiPermissionBundle;
    }

    public final AppRuntimeApiPermissionBundle aen(String str) {
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle;
        AppMethodBeat.i(229967);
        synchronized (this.nxu) {
            try {
                if (this.nxv == null) {
                    appRuntimeApiPermissionBundle = null;
                } else {
                    appRuntimeApiPermissionBundle = this.nxv.get(str);
                    AppMethodBeat.o(229967);
                }
            } finally {
                AppMethodBeat.o(229967);
            }
        }
        return appRuntimeApiPermissionBundle;
    }

    public static void l(f fVar, String str) {
        AppMethodBeat.i(229968);
        j jVar = fVar == null ? null : (j) fVar.M(j.class);
        if (jVar != null) {
            jVar.aep(str);
        }
        AppMethodBeat.o(229968);
    }
}
