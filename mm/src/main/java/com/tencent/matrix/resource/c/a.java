package com.tencent.matrix.resource.c;

import com.tencent.matrix.g.d;
import com.tencent.matrix.resource.c.a.b;
import com.tencent.matrix.resource.c.a.c;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.d.a.j;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.CRC32;

public final class a {
    final Set<b> cYM = new HashSet();
    final Map<b, byte[]> cYN = new HashMap();
    final Map<b, b> cYO = new HashMap();
    final Set<b> cYP = new HashSet();
    b cYQ = null;
    b cYR = null;
    b cYS = null;
    b cYT = null;
    b cYU = null;
    b cYV = null;
    b cYW = null;
    b cYX = null;
    com.tencent.matrix.resource.c.a.a[] cYY = null;
    com.tencent.matrix.resource.c.a.a[] cYZ = null;
    int coW = 0;

    public static boolean a(File file, Properties properties) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Throwable th2;
        h hVar;
        i iVar;
        h hVar2;
        if (!file.exists()) {
            return false;
        }
        if (properties.isEmpty()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file2 = new File(file.getParentFile(), "extra.info");
        File file3 = new File(file.getAbsolutePath() + "_temp");
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2, false));
            try {
                properties.store(bufferedOutputStream2, (String) null);
                d.closeQuietly(bufferedOutputStream2);
                try {
                    iVar = new i(new BufferedOutputStream(new FileOutputStream(file3)));
                    try {
                        hVar2 = new h(file);
                        try {
                            Enumeration<? extends g> entries = hVar2.entries();
                            while (entries.hasMoreElements()) {
                                g gVar = (g) entries.nextElement();
                                if (gVar == null) {
                                    throw new RuntimeException("zipEntry is null when get from oldApk");
                                } else if (!gVar.name.contains("../")) {
                                    j.a(hVar2, gVar, iVar);
                                }
                            }
                            Long y = y(file2);
                            if (y == null) {
                                com.tencent.matrix.g.c.e("Matrix.HprofBufferShrinker", "new crc is null", new Object[0]);
                                d.closeQuietly(hVar2);
                                d.closeQuietly(iVar);
                                file2.delete();
                                return false;
                            }
                            j.a(new g(file2.getName()), file2, y.longValue(), iVar);
                            d.closeQuietly(hVar2);
                            d.closeQuietly(iVar);
                            file2.delete();
                            file.delete();
                            if (!file3.renameTo(file)) {
                                com.tencent.matrix.g.c.e("Matrix.HprofBufferShrinker", "rename error", new Object[0]);
                                return false;
                            }
                            com.tencent.matrix.g.c.i("Matrix.HprofBufferShrinker", "addExtraInfo end, path: %s, cost time: %d", file.getAbsolutePath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            return true;
                        } catch (IOException e2) {
                            e = e2;
                            hVar = hVar2;
                            try {
                                com.tencent.matrix.g.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                                d.closeQuietly(hVar);
                                d.closeQuietly(iVar);
                                file2.delete();
                                return false;
                            } catch (Throwable th3) {
                                th = th3;
                                hVar2 = hVar;
                                d.closeQuietly(hVar2);
                                d.closeQuietly(iVar);
                                file2.delete();
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            d.closeQuietly(hVar2);
                            d.closeQuietly(iVar);
                            file2.delete();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        hVar = null;
                        com.tencent.matrix.g.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                        d.closeQuietly(hVar);
                        d.closeQuietly(iVar);
                        file2.delete();
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        hVar2 = null;
                        d.closeQuietly(hVar2);
                        d.closeQuietly(iVar);
                        file2.delete();
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    hVar = null;
                    iVar = null;
                    com.tencent.matrix.g.c.e("Matrix.HprofBufferShrinker", "zip property error:".concat(String.valueOf(e)), new Object[0]);
                    d.closeQuietly(hVar);
                    d.closeQuietly(iVar);
                    file2.delete();
                    return false;
                } catch (Throwable th6) {
                    th = th6;
                    hVar2 = null;
                    iVar = null;
                    d.closeQuietly(hVar2);
                    d.closeQuietly(iVar);
                    file2.delete();
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                bufferedOutputStream = bufferedOutputStream2;
                d.closeQuietly(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            bufferedOutputStream = null;
            d.closeQuietly(bufferedOutputStream);
            throw th;
        }
    }

    private static Long y(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        CRC32 crc32 = new CRC32();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        crc32.update(bArr, 0, read);
                    } else {
                        Long valueOf = Long.valueOf(crc32.getValue());
                        d.closeQuietly(fileInputStream);
                        return valueOf;
                    }
                }
            } catch (IOException e2) {
                d.closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                d.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            d.closeQuietly(fileInputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            d.closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public class b extends d {
        public b() {
            super(null);
        }

        @Override // com.tencent.matrix.resource.c.d
        public final void a(String str, int i2, long j2) {
            a.this.coW = i2;
            a.this.cYX = new com.tencent.matrix.resource.c.a.b(new byte[i2]);
        }

        @Override // com.tencent.matrix.resource.c.d
        public final void a(com.tencent.matrix.resource.c.a.b bVar, String str, int i2, long j2) {
            if (a.this.cYQ == null && "android.graphics.Bitmap".equals(str)) {
                a.this.cYQ = bVar;
            } else if (a.this.cYS == null && "mBuffer".equals(str)) {
                a.this.cYS = bVar;
            } else if (a.this.cYT == null && "mRecycled".equals(str)) {
                a.this.cYT = bVar;
            } else if (a.this.cYU == null && "java.lang.String".equals(str)) {
                a.this.cYU = bVar;
            } else if (a.this.cYW == null && "value".equals(str)) {
                a.this.cYW = bVar;
            }
        }

        @Override // com.tencent.matrix.resource.c.d
        public final void a(int i2, com.tencent.matrix.resource.c.a.b bVar, int i3, com.tencent.matrix.resource.c.a.b bVar2, int i4, long j2) {
            if (a.this.cYR == null && a.this.cYQ != null && a.this.cYQ.equals(bVar2)) {
                a.this.cYR = bVar;
            } else if (a.this.cYV == null && a.this.cYU != null && a.this.cYU.equals(bVar2)) {
                a.this.cYV = bVar;
            }
        }

        @Override // com.tencent.matrix.resource.c.d
        public final b b(int i2, int i3, long j2) {
            return new b() {
                /* class com.tencent.matrix.resource.c.a.b.AnonymousClass1 */

                @Override // com.tencent.matrix.resource.c.b
                public final void a(com.tencent.matrix.resource.c.a.b bVar, int i2, com.tencent.matrix.resource.c.a.b bVar2, com.tencent.matrix.resource.c.a.b bVar3, int i3, com.tencent.matrix.resource.c.a.a[] aVarArr, com.tencent.matrix.resource.c.a.a[] aVarArr2) {
                    if (a.this.cYY == null && a.this.cYR != null && a.this.cYR.equals(bVar)) {
                        a.this.cYY = aVarArr2;
                    } else if (a.this.cYZ == null && a.this.cYV != null && a.this.cYV.equals(bVar)) {
                        a.this.cYZ = aVarArr2;
                    }
                }
            };
        }
    }

    public class c extends d {
        public c() {
            super(null);
        }

        @Override // com.tencent.matrix.resource.c.d
        public final b b(int i2, int i3, long j2) {
            return new b() {
                /* class com.tencent.matrix.resource.c.a.c.AnonymousClass1 */

                @Override // com.tencent.matrix.resource.c.b
                public final void a(b bVar, int i2, b bVar2, byte[] bArr) {
                    b bVar3 = null;
                    boolean z = false;
                    try {
                        if (a.this.cYR != null && a.this.cYR.equals(bVar2)) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            com.tencent.matrix.resource.c.a.a[] aVarArr = a.this.cYY;
                            Boolean bool = null;
                            b bVar4 = null;
                            for (com.tencent.matrix.resource.c.a.a aVar : aVarArr) {
                                b bVar5 = aVar.cZn;
                                com.tencent.matrix.resource.c.a.c iu = com.tencent.matrix.resource.c.a.c.iu(aVar.cZm);
                                if (iu == null) {
                                    throw new IllegalStateException("visit bmp instance failed, lost type def of typeId: " + aVar.cZm);
                                }
                                if (a.this.cYS.equals(bVar5)) {
                                    bVar4 = (b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, iu, a.this.coW);
                                } else if (!a.this.cYT.equals(bVar5)) {
                                    if (!(bVar4 == null || bool == null)) {
                                        break;
                                    }
                                    com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, iu, a.this.coW);
                                } else {
                                    bool = (Boolean) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, iu, a.this.coW);
                                }
                            }
                            byteArrayInputStream.close();
                            if (bool == null || !bool.booleanValue()) {
                                z = true;
                            }
                            if (!(bVar4 == null || !z || bVar4.equals(a.this.cYX))) {
                                a.this.cYM.add(bVar4);
                            }
                        } else if (a.this.cYV != null && a.this.cYV.equals(bVar2)) {
                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                            com.tencent.matrix.resource.c.a.a[] aVarArr2 = a.this.cYZ;
                            for (com.tencent.matrix.resource.c.a.a aVar2 : aVarArr2) {
                                b bVar6 = aVar2.cZn;
                                com.tencent.matrix.resource.c.a.c iu2 = com.tencent.matrix.resource.c.a.c.iu(aVar2.cZm);
                                if (iu2 == null) {
                                    throw new IllegalStateException("visit string instance failed, lost type def of typeId: " + aVar2.cZm);
                                }
                                if (!a.this.cYW.equals(bVar6)) {
                                    if (bVar3 != null) {
                                        break;
                                    }
                                    com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream2, iu2, a.this.coW);
                                } else {
                                    bVar3 = (b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream2, iu2, a.this.coW);
                                }
                            }
                            byteArrayInputStream2.close();
                            if (!(bVar3 == null || bVar3.equals(a.this.cYX))) {
                                a.this.cYP.add(bVar3);
                            }
                        }
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }

                @Override // com.tencent.matrix.resource.c.b
                public final void a(int i2, b bVar, int i3, int i4, int i5, byte[] bArr) {
                    a.this.cYN.put(bVar, bArr);
                }
            };
        }

        @Override // com.tencent.matrix.resource.c.d
        public final void Td() {
            Set<Map.Entry<b, byte[]>> entrySet = a.this.cYN.entrySet();
            HashMap hashMap = new HashMap();
            for (Map.Entry<b, byte[]> entry : entrySet) {
                b key = entry.getKey();
                byte[] value = entry.getValue();
                if (a.this.cYM.contains(key)) {
                    String mD5String = com.tencent.matrix.resource.a.a.a.getMD5String(value);
                    b bVar = (b) hashMap.get(mD5String);
                    if (bVar == null) {
                        hashMap.put(mD5String, key);
                    } else {
                        a.this.cYO.put(bVar, bVar);
                        a.this.cYO.put(key, bVar);
                    }
                }
            }
            a.this.cYN.clear();
        }
    }

    /* renamed from: com.tencent.matrix.resource.c.a$a  reason: collision with other inner class name */
    public class C0230a extends d {
        public C0230a(e eVar) {
            super(eVar);
        }

        @Override // com.tencent.matrix.resource.c.d
        public final b b(int i2, int i3, long j2) {
            return new b(super.b(i2, i3, j2)) {
                /* class com.tencent.matrix.resource.c.a.C0230a.AnonymousClass1 */

                @Override // com.tencent.matrix.resource.c.b
                public final void a(b bVar, int i2, b bVar2, byte[] bArr) {
                    b bVar3;
                    b bVar4;
                    try {
                        if (bVar2.equals(a.this.cYR)) {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            com.tencent.matrix.resource.c.a.a[] aVarArr = a.this.cYY;
                            int length = aVarArr.length;
                            int i3 = 0;
                            int i4 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    bVar3 = null;
                                    break;
                                }
                                com.tencent.matrix.resource.c.a.a aVar = aVarArr[i3];
                                b bVar5 = aVar.cZn;
                                c iu = c.iu(aVar.cZm);
                                if (iu == null) {
                                    throw new IllegalStateException("visit instance failed, lost type def of typeId: " + aVar.cZm);
                                } else if (a.this.cYS.equals(bVar5)) {
                                    bVar3 = (b) com.tencent.matrix.resource.c.b.a.a(byteArrayInputStream, iu, a.this.coW);
                                    break;
                                } else {
                                    i3++;
                                    i4 = com.tencent.matrix.resource.c.b.a.b(byteArrayInputStream, iu, a.this.coW) + i4;
                                }
                            }
                            if (bVar3 != null && (bVar4 = a.this.cYO.get(bVar3)) != null && !bVar3.equals(bVar4) && !bVar3.equals(a.this.cYX)) {
                                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                wrap.position(i4);
                                wrap.put(bVar4.cZp);
                            }
                        }
                        super.a(bVar, i2, bVar2, bArr);
                    } catch (Throwable th) {
                        throw new RuntimeException(th);
                    }
                }

                @Override // com.tencent.matrix.resource.c.b
                public final void a(int i2, b bVar, int i3, int i4, int i5, byte[] bArr) {
                    b bVar2 = a.this.cYO.get(bVar);
                    if ((bVar2 != null && bVar.equals(bVar2)) || a.this.cYP.contains(bVar)) {
                        super.a(i2, bVar, i3, i4, i5, bArr);
                    }
                }
            };
        }
    }
}
