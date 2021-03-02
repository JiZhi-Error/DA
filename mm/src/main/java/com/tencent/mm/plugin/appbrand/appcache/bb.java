package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class bb extends j implements IWxaFileSystemWithModularizing {
    private final r kNd;
    private Map<String, Long> kNe = new HashMap();

    public bb(q qVar) {
        AppMethodBeat.i(178529);
        Assert.assertTrue(qVar instanceof r);
        this.kNd = (r) qVar;
        AppMethodBeat.o(178529);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing
    public final WxaPkg.Info openReadPartialInfo(String str) {
        AppMethodBeat.i(178530);
        q.a UV = this.kNd.UV(str);
        if (UV != null) {
            WxaPkg.Info bvB = UV.bvB();
            AppMethodBeat.o(178530);
            return bvB;
        }
        AppMethodBeat.o(178530);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Vi(String str) {
        AppMethodBeat.i(178531);
        try {
            this.kNd.UX(str);
            AppMethodBeat.o(178531);
            return true;
        } catch (IllegalArgumentException e2) {
            AppMethodBeat.o(178531);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vj(String str) {
        m mVar;
        String str2;
        AppMethodBeat.i(178532);
        m Vk = Vk(str);
        if (Vk == m.RET_NOT_EXISTS) {
            if (str.length() != 0) {
                String We = n.We(str);
                if (!We.substring(We.length() - 1).equals(FilePathGenerator.ANDROID_DIR_SEP)) {
                    str2 = We + FilePathGenerator.ANDROID_DIR_SEP;
                } else {
                    str2 = We;
                }
                List<String> bvA = this.kNd.bvA();
                if (bvA == null) {
                    bvA = Collections.emptyList();
                }
                Iterator<String> it = bvA.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Util.nullAsNil(it.next()).startsWith(str2)) {
                            mVar = m.OK;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                m mVar2 = m.RET_NOT_EXISTS;
                AppMethodBeat.o(178532);
                return mVar2;
            }
        }
        mVar = Vk;
        AppMethodBeat.o(178532);
        return mVar;
    }

    private m Vk(String str) {
        AppMethodBeat.i(178533);
        if (!this.kNd.UW(str)) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(178533);
            return mVar;
        }
        m mVar2 = m.OK;
        AppMethodBeat.o(178533);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, i<List<k>> iVar) {
        AppMethodBeat.i(178534);
        if (Vk(str) == m.OK) {
            m mVar = m.ERR_IS_FILE;
            AppMethodBeat.o(178534);
            return mVar;
        }
        String We = n.We(str);
        List<String> bvA = this.kNd.bvA();
        if (bvA == null) {
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(178534);
            return mVar2;
        }
        String quote = Pattern.quote(We);
        for (String str2 : bvA) {
            if (Util.nullAsNil(str2).startsWith(We)) {
                String replaceFirst = str2.replaceFirst(quote, "");
                if (replaceFirst.split(FilePathGenerator.ANDROID_DIR_SEP).length <= 1) {
                    k kVar = new k();
                    kVar.fileName = replaceFirst;
                    iVar.value = iVar.value == null ? (T) new LinkedList() : iVar.value;
                    iVar.value.add(kVar);
                }
            }
        }
        if (iVar.value == null) {
            m mVar3 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(178534);
            return mVar3;
        }
        m mVar4 = m.OK;
        AppMethodBeat.o(178534);
        return mVar4;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vl(String str) {
        AppMethodBeat.i(178535);
        m a2 = a(str, new i<>());
        AppMethodBeat.o(178535);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        String str2;
        AppMethodBeat.i(178536);
        InputStream UU = this.kNd.UU(str);
        if (UU == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(178536);
            return mVar;
        }
        try {
            m g2 = g(j2, j3, (long) UU.available());
            if (g2 != m.OK) {
                Util.qualityClose(UU);
                AppMethodBeat.o(178536);
                return g2;
            }
            if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                j3 = ((long) UU.available()) - j2;
            }
            T t = (T) ByteBuffer.allocateDirect(UU.available());
            if (!(j2 == 0 && j3 == ((long) UU.available())) || !(UU instanceof a)) {
                t.put(ByteBuffer.wrap(d.a(UU, j2, j3)));
            } else {
                t.put(((a) UU).cDi);
            }
            t.rewind();
            iVar.value = t;
            if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str2 = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
            } else {
                str2 = str;
            }
            if (!str2.contains("\\") && !str2.trim().isEmpty()) {
                while (true) {
                    if (!str2.equals("")) {
                        if (str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                            Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", str2);
                            break;
                        }
                        str2 = str2.substring(0, str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP));
                        if (str2.equals("")) {
                            this.kNe.put(FilePathGenerator.ANDROID_DIR_SEP, Long.valueOf(System.currentTimeMillis() / 1000));
                        } else {
                            this.kNe.put(str2 + FilePathGenerator.ANDROID_DIR_SEP, Long.valueOf(System.currentTimeMillis() / 1000));
                        }
                    } else {
                        break;
                    }
                }
            } else {
                Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "updateDirAccessTimeRecord: path = [%s] is illegal", str2);
            }
            m mVar2 = m.OK;
            Util.qualityClose(UU);
            AppMethodBeat.o(178536);
            return mVar2;
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", e2, "readFile", new Object[0]);
            Util.qualityClose(UU);
            m mVar3 = m.ERR_OP_FAIL;
            AppMethodBeat.o(178536);
            return mVar3;
        } catch (Throwable th) {
            Util.qualityClose(UU);
            AppMethodBeat.o(178536);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m b(String str, i<ByteBuffer> iVar) {
        AppMethodBeat.i(178537);
        InputStream UU = this.kNd.UU(str);
        if (UU == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(178537);
            return mVar;
        }
        try {
            int available = UU.available();
            Util.qualityClose(UU);
            m a2 = a(str, 0, (long) available, iVar);
            AppMethodBeat.o(178537);
            return a2;
        } catch (IOException e2) {
            Log.printErrStackTrace("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", e2, "readFile", new Object[0]);
            m mVar2 = m.ERR_OP_FAIL;
            Util.qualityClose(UU);
            AppMethodBeat.o(178537);
            return mVar2;
        } catch (Throwable th) {
            Util.qualityClose(UU);
            AppMethodBeat.o(178537);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m h(String str, List<x> list) {
        AppMethodBeat.i(219301);
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
        }
        if (str.contains("\\") || str.trim().isEmpty()) {
            Log.e("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: path = [%s] is illegal", str);
            m h2 = super.h(str, list);
            AppMethodBeat.o(219301);
            return h2;
        }
        for (String str2 : this.kNd.bvA()) {
            if (str2 != null && str2.startsWith(str)) {
                x xVar = new x(str2);
                String name = a(str2, xVar).name();
                if (name.equals(m.OK.name())) {
                    list.add(xVar);
                } else {
                    Log.w("Luggage.WXA.WxaPkgFileSystemWithModularizingNewImpl", "statDir: stat [%s] fail:[%s]", str2, name);
                }
            }
        }
        m mVar = m.OK;
        AppMethodBeat.o(219301);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, FileStructStat fileStructStat) {
        WxaPkg UT;
        AppMethodBeat.i(178538);
        q.a UV = this.kNd.UV(str);
        if (UV == null) {
            if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str + FilePathGenerator.ANDROID_DIR_SEP;
            }
            if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
            }
            if (Vk(str) != m.RET_NOT_EXISTS || (UT = this.kNd.UT(str)) == null) {
                m mVar = m.RET_NOT_EXISTS;
                AppMethodBeat.o(178538);
                return mVar;
            }
            UT.bwg().fillAnother(fileStructStat);
            fileStructStat.makeItIsDir();
            fileStructStat.st_size = 0;
            Long l = this.kNe.get(str);
            if (l != null) {
                fileStructStat.st_atime = l.longValue();
            }
            m mVar2 = m.OK;
            AppMethodBeat.o(178538);
            return mVar2;
        }
        UV.kKH.bwg().fillAnother(fileStructStat);
        fileStructStat.st_size = (long) UV.kKK;
        m mVar3 = m.OK;
        AppMethodBeat.o(178538);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final o ag(String str, boolean z) {
        AppMethodBeat.i(178539);
        if (!z) {
            if (Vl(str) == m.OK) {
                AppMethodBeat.o(178539);
                return null;
            }
        }
        q.a UV = this.kNd.UV(str);
        if (UV == null) {
            AppMethodBeat.o(178539);
            return null;
        }
        String a2 = ab.a(UV.kKH, UV.fileName);
        if (!TextUtils.isEmpty(a2)) {
            o oVar = new o(a2);
            AppMethodBeat.o(178539);
            return oVar;
        }
        AppMethodBeat.o(178539);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void initialize() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void release() {
        AppMethodBeat.i(178540);
        this.kNd.close();
        AppMethodBeat.o(178540);
    }
}
