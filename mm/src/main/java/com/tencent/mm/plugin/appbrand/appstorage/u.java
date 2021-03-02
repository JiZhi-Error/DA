package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.utils.ah;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

public final class u {
    private static final y kTc = new y() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.u.AnonymousClass1 */

        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };
    private k kEy;
    private f kSY;
    private i.a kSZ;
    private final String kSp;
    private final String kSq;
    private final String kSr;
    private final Collection<a> kTa;
    private final Map<String, o> kTb = new ConcurrentHashMap();

    interface a {
        com.tencent.mm.vending.j.a cI(String str, String str2);
    }

    static /* synthetic */ String b(u uVar) {
        AppMethodBeat.i(196176);
        String bxt = uVar.bxt();
        AppMethodBeat.o(196176);
        return bxt;
    }

    u(String str, String str2, String str3, i.a aVar) {
        AppMethodBeat.i(196169);
        this.kSr = aa.z(new o(str).her()) + FilePathGenerator.ANDROID_DIR_SEP;
        this.kSp = str2;
        this.kSq = str3;
        this.kSZ = aVar;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b(this, (byte) 0));
        this.kTa = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(196169);
    }

    public final void clear() {
        AppMethodBeat.i(196170);
        this.kTb.clear();
        s.dy(this.kSr, true);
        AppMethodBeat.o(196170);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.vfs.o Wi(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.u.Wi(java.lang.String):com.tencent.mm.vfs.o");
    }

    public final ByteBuffer dI(String str) {
        boolean z;
        AppMethodBeat.i(196173);
        if (this.kEy == null) {
            if (this.kSY == null) {
                if (this.kSZ != null) {
                    this.kSY = this.kSZ.bxr();
                }
                if (this.kSY == null) {
                    Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "service is null");
                    AppMethodBeat.o(196173);
                    return null;
                }
            }
            this.kEy = (k) this.kSY.getJsRuntime().R(k.class);
        }
        if (this.kEy == null || this.kEy.bMF() == null) {
            Object[] objArr = new Object[1];
            if (this.kEy == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "getBuffer failed, mBufferAddon == null?: [%b]", objArr);
            AppMethodBeat.o(196173);
            return null;
        }
        ByteBuffer dI = this.kEy.bMF().dI(str);
        AppMethodBeat.o(196173);
        return dI;
    }

    final class b implements a {
        private b() {
        }

        /* synthetic */ b(u uVar, byte b2) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.u.a
        public final com.tencent.mm.vending.j.a cI(String str, String str2) {
            String str3;
            AppMethodBeat.i(196168);
            if (Util.isNullOrNil(str2)) {
                str2 = u.bxu();
            }
            try {
                String format = String.format(Locale.US, "%d|%s", Long.valueOf(u.a(u.this, str)), str2);
                try {
                    Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", format);
                    str3 = u.cH(format, u.this.kSp);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "attachMediaObject, enc exp = ", new Object[0]);
                    str3 = null;
                }
                if (Util.isNullOrNil(str3)) {
                    AppMethodBeat.o(196168);
                    return null;
                }
                String concat = "blob_".concat(String.valueOf(str3));
                String str4 = u.b(u.this) + concat;
                String str5 = u.this.kSq + concat + (Util.isNullOrNil(str2) ? "" : ".".concat(String.valueOf(str2)));
                Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", str5, str4);
                d i2 = com.tencent.mm.vending.j.a.i(str5, str4, str2);
                AppMethodBeat.o(196168);
                return i2;
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", Util.stackTraceToString(e3));
                AppMethodBeat.o(196168);
                return null;
            }
        }
    }

    static {
        AppMethodBeat.i(196177);
        AppMethodBeat.o(196177);
    }

    private String bxt() {
        AppMethodBeat.i(196172);
        FilePathGenerator.checkMkdir(this.kSr);
        try {
            new o(this.kSr, FilePathGenerator.NO_MEDIA_FILENAME).createNewFile();
        } catch (Exception e2) {
        }
        String str = this.kSr;
        AppMethodBeat.o(196172);
        return str;
    }

    static /* synthetic */ String bxu() {
        return "unknown";
    }

    static /* synthetic */ long a(u uVar, String str) {
        AppMethodBeat.i(196174);
        ByteBuffer dI = uVar.dI(str);
        if (dI == null) {
            AppMethodBeat.o(196174);
            return -1;
        }
        CheckedInputStream checkedInputStream = new CheckedInputStream(new com.tencent.luggage.h.a(dI), new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        Util.qualityClose(checkedInputStream);
        AppMethodBeat.o(196174);
        return value;
    }

    static /* synthetic */ String cH(String str, String str2) {
        AppMethodBeat.i(196175);
        String encodeHexString = Util.encodeHexString(new ah().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.o(196175);
        return encodeHexString;
    }
}
