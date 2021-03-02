package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* access modifiers changed from: package-private */
@Deprecated
public final class z implements q, Closeable {
    final String appId;
    final WxaPkgWrappingInfo kLC;
    private final Map<String, WxaPkg> kLD = new HashMap();

    z(String str, WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(178521);
        this.appId = str;
        this.kLC = wxaPkgWrappingInfo;
        this.kLC.Vv(str);
        AppMethodBeat.o(178521);
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final q.a UV(String str) {
        AppMethodBeat.i(178523);
        WxaPkg UT = UT(str);
        WxaPkg.Info openReadPartialInfo = UT == null ? null : UT.openReadPartialInfo(str);
        if (openReadPartialInfo != null) {
            q.a aVar = new q.a();
            aVar.kKF = this.appId;
            aVar.appVersion = this.kLC.pkgVersion();
            aVar.kKG = this.kLC.checksumMd5();
            aVar.kKH = UT;
            aVar.kKI = aa.z(UT.mFile.her());
            aVar.fileName = openReadPartialInfo.fileName;
            aVar.kKJ = openReadPartialInfo.kKJ;
            aVar.kKK = openReadPartialInfo.kKK;
            AppMethodBeat.o(178523);
            return aVar;
        }
        AppMethodBeat.o(178523);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final InputStream UU(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(178524);
        WxaPkg UT = UT(str);
        if (str.startsWith(ModulePkgInfo.PLUGINCODE_PREFIX) && UT != null) {
            InputStream UR = UT.UR(str);
            if (UR != null) {
                AppMethodBeat.o(178524);
                return UR;
            }
            String substring = ModulePkgInfo.PLUGINCODE_PREFIX.substring(1, 11);
            String[] split = str.split(FilePathGenerator.ANDROID_DIR_SEP);
            int i4 = 0;
            while (true) {
                if (i4 >= split.length) {
                    i2 = -1;
                    i3 = -1;
                    break;
                }
                if (split[i4].equalsIgnoreCase(substring) && i4 + 1 < split.length) {
                    String str2 = split[i4 + 1];
                    if (!Util.isNullOrNil(str2)) {
                        int indexOf = str.indexOf(str2);
                        i2 = str2.length();
                        i3 = indexOf;
                        break;
                    }
                }
                i4++;
            }
            InputStream UR2 = UT.UR(str.substring(i2 + i3));
            AppMethodBeat.o(178524);
            return UR2;
        } else if (UT == null) {
            AppMethodBeat.o(178524);
            return null;
        } else {
            InputStream UR3 = UT.UR(str);
            AppMethodBeat.o(178524);
            return UR3;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final WxaPkg UT(String str) {
        String str2;
        AppMethodBeat.i(134674);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134674);
            return null;
        }
        String We = n.We(str);
        if (WxaPkgWrappingInfo.kNV != null) {
            ModulePkgInfo b2 = WxaPkgWrappingInfo.kNV.b(this.kLC.kNZ, We, String.format(Locale.ENGLISH, "findAppropriateModuleInfo with appId[%s]", this.appId));
            if (b2 != null) {
                str2 = b2.name;
            } else {
                str2 = ModulePkgInfo.MAIN_MODULE_NAME;
            }
        } else {
            Iterator<ModulePkgInfo> it = this.kLC.kNZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                ModulePkgInfo next = it.next();
                if (We.startsWith(next.name)) {
                    str2 = next.name;
                    break;
                }
            }
            if (Util.isNullOrNil(str2)) {
                str2 = ModulePkgInfo.MAIN_MODULE_NAME;
            }
        }
        WxaPkg Vc = Vc(str2);
        AppMethodBeat.o(134674);
        return Vc;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final boolean UW(String str) {
        AppMethodBeat.i(178525);
        if (UV(str) != null) {
            AppMethodBeat.o(178525);
            return true;
        }
        AppMethodBeat.o(178525);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final void bvy() {
        AppMethodBeat.i(178526);
        this.kLC.Vv(this.appId);
        synchronized (this.kLD) {
            try {
                Vc(ModulePkgInfo.MAIN_MODULE_NAME);
                Iterator<ModulePkgInfo> it = this.kLC.kNZ.iterator();
                while (it.hasNext()) {
                    Vc(it.next().name);
                }
            } finally {
                AppMethodBeat.o(178526);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<ModulePkgInfo> bvz() {
        AppMethodBeat.i(178527);
        LinkedList linkedList = new LinkedList(this.kLC.kNZ);
        AppMethodBeat.o(178527);
        return linkedList;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q
    public final List<String> bvA() {
        AppMethodBeat.i(219300);
        LinkedList linkedList = new LinkedList();
        synchronized (this.kLD) {
            try {
                for (WxaPkg wxaPkg : this.kLD.values()) {
                    if (wxaPkg != null) {
                        linkedList.addAll(wxaPkg.bwj());
                    }
                }
            } finally {
                AppMethodBeat.o(219300);
            }
        }
        return linkedList;
    }

    private WxaPkg Vc(String str) {
        WxaPkg wxaPkg;
        String str2;
        AppMethodBeat.i(134677);
        synchronized (this.kLD) {
            try {
                wxaPkg = this.kLD.get(str);
                if (wxaPkg == null) {
                    if (!ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
                        Iterator<ModulePkgInfo> it = this.kLC.kNZ.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                str2 = null;
                                break;
                            }
                            ModulePkgInfo next = it.next();
                            if (str.equals(next.name)) {
                                str2 = next.pkgPath;
                                break;
                            }
                        }
                    } else {
                        str2 = this.kLC.pkgPath;
                    }
                    if (!Util.isNullOrNil(str2)) {
                        wxaPkg = new WxaPkg(str2);
                        this.kLD.put(str, wxaPkg);
                    }
                }
            } finally {
                AppMethodBeat.o(134677);
            }
        }
        if (wxaPkg != null) {
            wxaPkg.bvf();
        }
        return wxaPkg;
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.q, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Collection<WxaPkg> values;
        AppMethodBeat.i(134678);
        synchronized (this.kLD) {
            try {
                values = this.kLD.values();
                this.kLD.clear();
            } finally {
                AppMethodBeat.o(134678);
            }
        }
        for (WxaPkg wxaPkg : values) {
            wxaPkg.close();
        }
    }
}
