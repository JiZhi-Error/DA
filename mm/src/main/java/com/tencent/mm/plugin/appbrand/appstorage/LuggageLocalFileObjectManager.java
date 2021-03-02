package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ah;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import org.apache.commons.a.d;

public final class LuggageLocalFileObjectManager {
    private static final y kTc = new y() {
        /* class com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.AnonymousClass3 */

        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };
    private final String kSp;
    private final String kSq;
    private final String kSr;
    private final Collection<a> kTa;

    /* access modifiers changed from: package-private */
    public interface a {
        y Wn(String str);

        y Wo(String str);

        y a(y yVar);

        com.tencent.mm.vending.j.a cI(String str, String str2);
    }

    static /* synthetic */ String b(LuggageLocalFileObjectManager luggageLocalFileObjectManager) {
        AppMethodBeat.i(134400);
        String bxt = luggageLocalFileObjectManager.bxt();
        AppMethodBeat.o(134400);
        return bxt;
    }

    LuggageLocalFileObjectManager(String str, String str2, String str3) {
        AppMethodBeat.i(134388);
        this.kSr = aa.z(new o(str).her()) + FilePathGenerator.ANDROID_DIR_SEP;
        this.kSp = str2;
        this.kSq = str3;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new b(this, (byte) 0));
        this.kTa = Collections.unmodifiableCollection(linkedList);
        AppMethodBeat.o(134388);
    }

    @Keep
    public final String genMediaFilePath(String str) {
        AppMethodBeat.i(134389);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134389);
            return null;
        }
        String str2 = bxt() + str;
        AppMethodBeat.o(134389);
        return str2;
    }

    public final List<y> bxw() {
        AppMethodBeat.i(134390);
        o[] bxx = bxx();
        if (bxx == null || bxx.length <= 0) {
            AppMethodBeat.o(134390);
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (o oVar : bxx) {
            y Wk = Wk(oVar.getName());
            if (Wk != null) {
                linkedList.add(Wk);
            }
        }
        AppMethodBeat.o(134390);
        return linkedList;
    }

    /* access modifiers changed from: package-private */
    public final o[] bxx() {
        AppMethodBeat.i(175590);
        o oVar = new o(bxt());
        if (!oVar.exists() || !oVar.isDirectory()) {
            AppMethodBeat.o(175590);
            return null;
        }
        o[] a2 = oVar.a(new q() {
            /* class com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.AnonymousClass1 */

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(175588);
                if (!oVar.exists() || oVar.isDirectory() || Util.isNullOrNil(oVar.getName()) || !oVar.getName().startsWith("store_")) {
                    AppMethodBeat.o(175588);
                    return false;
                }
                AppMethodBeat.o(175588);
                return true;
            }
        });
        AppMethodBeat.o(175590);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T extends com.tencent.mm.plugin.appbrand.appstorage.y> T a(java.lang.String r10, java.lang.Class<T> r11, java.lang.String r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a(java.lang.String, java.lang.Class, java.lang.String, boolean):com.tencent.mm.plugin.appbrand.appstorage.y");
    }

    public final y j(String str, String str2, boolean z) {
        AppMethodBeat.i(134394);
        y a2 = a(str, y.class, str2, z);
        AppMethodBeat.o(134394);
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.appstorage.y a(com.tencent.mm.plugin.appbrand.appstorage.y r5) {
        /*
            r4 = this;
            r3 = 134396(0x20cfc, float:1.88329E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r0 = 0
            java.util.Collection<com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$a> r1 = r4.kTa
            java.util.Iterator r1 = r1.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x001f
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$a r0 = (com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a) r0
            com.tencent.mm.plugin.appbrand.appstorage.y r0 = r0.a(r5)
            if (r0 == 0) goto L_0x000d
        L_0x001f:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a(com.tencent.mm.plugin.appbrand.appstorage.y):com.tencent.mm.plugin.appbrand.appstorage.y");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.plugin.appbrand.appstorage.y Wk(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            r3 = 134397(0x20cfd, float:1.8833E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            boolean r1 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r5)
            if (r1 == 0) goto L_0x0011
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0010:
            return r0
        L_0x0011:
            java.util.Collection<com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$a> r1 = r4.kTa
            java.util.Iterator r1 = r1.iterator()
        L_0x0017:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0029
            java.lang.Object r0 = r1.next()
            com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager$a r0 = (com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a) r0
            com.tencent.mm.plugin.appbrand.appstorage.y r0 = r0.Wo(r5)
            if (r0 == 0) goto L_0x0017
        L_0x0029:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.Wk(java.lang.String):com.tencent.mm.plugin.appbrand.appstorage.y");
    }

    @Deprecated
    public final y Wl(String str) {
        y yVar;
        AppMethodBeat.i(134398);
        if (Util.isNullOrNil(str) || !str.startsWith(this.kSq)) {
            Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", str);
            AppMethodBeat.o(134398);
            return null;
        }
        String substring = str.substring(this.kSq.length());
        Iterator<a> it = this.kTa.iterator();
        y yVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                yVar = yVar2;
                break;
            }
            a next = it.next();
            yVar = next.Wn(substring);
            if (yVar != null) {
                Log.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", next.toString(), yVar);
                break;
            }
            yVar2 = yVar;
        }
        if (kTc == yVar) {
            AppMethodBeat.o(134398);
            return null;
        }
        AppMethodBeat.o(134398);
        return yVar;
    }

    final class b implements a {
        private b() {
        }

        /* synthetic */ b(LuggageLocalFileObjectManager luggageLocalFileObjectManager, byte b2) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a
        public final y Wn(String str) {
            String str2 = null;
            AppMethodBeat.i(134384);
            if (str.startsWith("store_") || str.startsWith("tmp_")) {
                String extension = d.getExtension(str);
                String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
                if (!Util.isNullOrNil(extension)) {
                    replaceFirst = replaceFirst.replaceFirst("\\.".concat(String.valueOf(extension)), "");
                }
                if (Util.isNullOrNil(replaceFirst)) {
                    y yVar = LuggageLocalFileObjectManager.kTc;
                    AppMethodBeat.o(134384);
                    return yVar;
                }
                try {
                    str2 = LuggageLocalFileObjectManager.cJ(replaceFirst, LuggageLocalFileObjectManager.this.kSp);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "retrieveMediaObject, decrypt exp ", new Object[0]);
                }
                if (Util.isNullOrNil(str2)) {
                    Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                    y yVar2 = LuggageLocalFileObjectManager.kTc;
                    AppMethodBeat.o(134384);
                    return yVar2;
                }
                String[] split = str2.split("\\|");
                if (split == null || split.length != 2) {
                    y yVar3 = LuggageLocalFileObjectManager.kTc;
                    AppMethodBeat.o(134384);
                    return yVar3;
                }
                String str3 = str.startsWith("store_") ? "store_" : "tmp_";
                String str4 = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + str3 + replaceFirst;
                long j2 = Util.getLong(split[0], 0);
                String str5 = split[1];
                if (!str5.equalsIgnoreCase(extension)) {
                    y yVar4 = LuggageLocalFileObjectManager.kTc;
                    AppMethodBeat.o(134384);
                    return yVar4;
                }
                try {
                    long Wm = LuggageLocalFileObjectManager.Wm(str4);
                    if (j2 != Wm) {
                        Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", Long.valueOf(Wm), Long.valueOf(j2), str);
                        y yVar5 = LuggageLocalFileObjectManager.kTc;
                        AppMethodBeat.o(134384);
                        return yVar5;
                    }
                    y yVar6 = new y();
                    yVar6.dJX = LuggageLocalFileObjectManager.this.kSq + str;
                    yVar6.iGf = str4;
                    yVar6.mimeType = MimeTypeUtil.getMimeTypeByFileExt(str5);
                    yVar6.kSa = str3.equalsIgnoreCase("store_");
                    o oVar = new o(yVar6.iGf);
                    yVar6.kSb = oVar.lastModified();
                    yVar6.jPY = oVar.length();
                    AppMethodBeat.o(134384);
                    return yVar6;
                } catch (IOException e3) {
                    Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", Util.stackTraceToString(e3));
                    y yVar7 = LuggageLocalFileObjectManager.kTc;
                    AppMethodBeat.o(134384);
                    return yVar7;
                }
            } else {
                AppMethodBeat.o(134384);
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a
        public final y a(y yVar) {
            AppMethodBeat.i(134385);
            if (yVar == null) {
                AppMethodBeat.o(134385);
                return null;
            }
            String replaceFirst = yVar.iGf.replaceFirst("tmp_", "store_");
            if (l.cE(yVar.iGf, replaceFirst)) {
                y yVar2 = new y();
                yVar2.iGf = replaceFirst;
                yVar2.dJX = yVar.dJX.replaceFirst("tmp_", "store_");
                yVar2.jPY = yVar.jPY;
                yVar2.gCr = yVar.gCr;
                yVar2.kSb = new o(yVar2.iGf).lastModified();
                yVar2.mimeType = yVar.mimeType;
                yVar2.kSa = true;
                AppMethodBeat.o(134385);
                return yVar2;
            }
            AppMethodBeat.o(134385);
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a
        public final com.tencent.mm.vending.j.a cI(String str, String str2) {
            String str3;
            AppMethodBeat.i(134386);
            if (Util.isNullOrNil(str2)) {
                str2 = LuggageLocalFileObjectManager.bxA();
            }
            try {
                String format = String.format(Locale.US, "%d|%s", Long.valueOf(LuggageLocalFileObjectManager.Wm(str)), str2);
                try {
                    Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "hy: attach media obj: %s", format);
                    str3 = LuggageLocalFileObjectManager.cK(format, LuggageLocalFileObjectManager.this.kSp);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "attachMediaObject, enc exp = ", new Object[0]);
                    str3 = null;
                }
                if (Util.isNullOrNil(str3)) {
                    AppMethodBeat.o(134386);
                    return null;
                }
                String concat = "tmp_".concat(String.valueOf(str3));
                String str4 = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + concat;
                String str5 = LuggageLocalFileObjectManager.this.kSq + concat + (Util.isNullOrNil(str2) ? "" : ".".concat(String.valueOf(str2)));
                Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", str5, str4);
                com.tencent.mm.vending.j.d i2 = com.tencent.mm.vending.j.a.i(str5, str4, str2);
                AppMethodBeat.o(134386);
                return i2;
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", Util.stackTraceToString(e3));
                AppMethodBeat.o(134386);
                return null;
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.a
        public final y Wo(String str) {
            String str2;
            AppMethodBeat.i(134387);
            String replaceFirst = str.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                str2 = LuggageLocalFileObjectManager.cJ(replaceFirst, LuggageLocalFileObjectManager.this.kSp);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e2, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                str2 = null;
            }
            if (Util.isNullOrNil(str2)) {
                AppMethodBeat.o(134387);
                return null;
            }
            String[] split = str2.split("\\|");
            if (split == null || split.length != 2) {
                AppMethodBeat.o(134387);
                return null;
            }
            String str3 = split[1];
            y yVar = new y();
            yVar.dJX = LuggageLocalFileObjectManager.this.kSq + str + (Util.isNullOrNil(str3) ? "" : ".".concat(String.valueOf(str3)));
            yVar.iGf = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + str;
            yVar.gCr = replaceFirst;
            yVar.kSa = str.startsWith("store_");
            o oVar = new o(yVar.iGf);
            yVar.kSb = oVar.lastModified();
            yVar.jPY = oVar.length();
            AppMethodBeat.o(134387);
            return yVar;
        }
    }

    static {
        AppMethodBeat.i(134403);
        AppMethodBeat.o(134403);
    }

    public final List<y> bxy() {
        LinkedList linkedList = null;
        AppMethodBeat.i(134392);
        o oVar = new o(bxt());
        o[] a2 = (!oVar.exists() || !oVar.isDirectory()) ? null : oVar.a(new q() {
            /* class com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.AnonymousClass2 */

            @Override // com.tencent.mm.vfs.q
            public final boolean accept(o oVar) {
                AppMethodBeat.i(175589);
                if (!oVar.exists() || oVar.isDirectory() || Util.isNullOrNil(oVar.getName()) || !oVar.getName().startsWith("tmp_")) {
                    AppMethodBeat.o(175589);
                    return false;
                }
                AppMethodBeat.o(175589);
                return true;
            }
        });
        if (a2 == null || a2.length <= 0) {
            AppMethodBeat.o(134392);
        } else {
            linkedList = new LinkedList();
            for (o oVar2 : a2) {
                y Wk = Wk(oVar2.getName());
                if (Wk != null) {
                    linkedList.add(Wk);
                }
            }
            AppMethodBeat.o(134392);
        }
        return linkedList;
    }

    private String bxt() {
        AppMethodBeat.i(134395);
        FilePathGenerator.checkMkdir(this.kSr);
        try {
            new o(this.kSr, FilePathGenerator.NO_MEDIA_FILENAME).createNewFile();
        } catch (Exception e2) {
        }
        String str = this.kSr;
        AppMethodBeat.o(134395);
        return str;
    }

    static /* synthetic */ String cJ(String str, String str2) {
        AppMethodBeat.i(134399);
        byte[] decrypt = new ah().decrypt(Util.decodeHexString(str), str2.getBytes());
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(134399);
            return null;
        }
        String str3 = new String(decrypt);
        AppMethodBeat.o(134399);
        return str3;
    }

    static /* synthetic */ long Wm(String str) {
        AppMethodBeat.i(134401);
        InputStream openRead = s.openRead(str);
        CheckedInputStream checkedInputStream = new CheckedInputStream(openRead, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        Util.qualityClose(checkedInputStream);
        Util.qualityClose(openRead);
        AppMethodBeat.o(134401);
        return value;
    }

    static /* synthetic */ String bxA() {
        return "unknown";
    }

    static /* synthetic */ String cK(String str, String str2) {
        AppMethodBeat.i(134402);
        String encodeHexString = Util.encodeHexString(new ah().encrypt(str.getBytes(), str2.getBytes()));
        AppMethodBeat.o(134402);
        return encodeHexString;
    }
}
