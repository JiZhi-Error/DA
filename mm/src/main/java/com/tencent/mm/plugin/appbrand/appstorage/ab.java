package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Deprecated
public final class ab extends j {
    static final /* synthetic */ boolean $assertionsDisabled = (!ab.class.desiredAssertionStatus());
    public final WxaPkg kMl;
    private Map<String, Long> kNe = new HashMap();

    static {
        AppMethodBeat.i(178575);
        AppMethodBeat.o(178575);
    }

    public ab(WxaPkg wxaPkg) {
        AppMethodBeat.i(178574);
        if ($assertionsDisabled || wxaPkg != null) {
            this.kMl = wxaPkg;
            AppMethodBeat.o(178574);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(178574);
        throw assertionError;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final boolean Vi(String str) {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vj(String str) {
        m mVar;
        String str2;
        AppMethodBeat.i(134747);
        m Vk = Vk(str);
        if (Vk == m.RET_NOT_EXISTS) {
            if (str.length() != 0) {
                String We = n.We(str);
                if (!We.substring(We.length() - 1).equals(FilePathGenerator.ANDROID_DIR_SEP)) {
                    str2 = We + FilePathGenerator.ANDROID_DIR_SEP;
                } else {
                    str2 = We;
                }
                Iterator<WxaPkg.Info> it = this.kMl.bwi().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().fileName.startsWith(str2)) {
                            mVar = m.OK;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                m mVar2 = m.RET_NOT_EXISTS;
                AppMethodBeat.o(134747);
                return mVar2;
            }
        }
        mVar = Vk;
        AppMethodBeat.o(134747);
        return mVar;
    }

    private m Vk(String str) {
        AppMethodBeat.i(134748);
        InputStream UR = this.kMl.UR(str);
        if (UR == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134748);
            return mVar;
        }
        Util.qualityClose(UR);
        m mVar2 = m.OK;
        AppMethodBeat.o(134748);
        return mVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, i<List<k>> iVar) {
        AppMethodBeat.i(134749);
        if (Vk(str) == m.OK) {
            m mVar = m.ERR_IS_FILE;
            AppMethodBeat.o(134749);
            return mVar;
        }
        String We = n.We(str);
        List<WxaPkg.Info> bwi = this.kMl.bwi();
        String quote = Pattern.quote(We);
        for (WxaPkg.Info info : bwi) {
            if (info.fileName.startsWith(We)) {
                String replaceFirst = info.fileName.replaceFirst(quote, "");
                if (replaceFirst.split(FilePathGenerator.ANDROID_DIR_SEP).length <= 1) {
                    k kVar = new k();
                    kVar.fileName = replaceFirst;
                    iVar.value = iVar.value == null ? (T) new LinkedList() : iVar.value;
                    iVar.value.add(kVar);
                }
            }
        }
        if (iVar.value == null) {
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134749);
            return mVar2;
        }
        m mVar3 = m.OK;
        AppMethodBeat.o(134749);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m Vl(String str) {
        AppMethodBeat.i(134750);
        m a2 = a(str, new i<>());
        AppMethodBeat.o(134750);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, long j2, long j3, i<ByteBuffer> iVar) {
        String str2;
        AppMethodBeat.i(134751);
        InputStream UR = this.kMl.UR(str);
        if (UR == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134751);
            return mVar;
        }
        try {
            m g2 = g(j2, j3, (long) UR.available());
            if (g2 != m.OK) {
                Util.qualityClose(UR);
                AppMethodBeat.o(134751);
                return g2;
            }
            if (j3 == MAlarmHandler.NEXT_FIRE_INTERVAL) {
                j3 = ((long) UR.available()) - j2;
            }
            T t = (T) ByteBuffer.allocateDirect(UR.available());
            if (!(j2 == 0 && j3 == ((long) UR.available())) || !(UR instanceof a)) {
                t.put(ByteBuffer.wrap(d.a(UR, j2, j3)));
            } else {
                t.put(((a) UR).cDi);
            }
            t.rewind();
            iVar.value = t;
            if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str2 = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
            } else {
                str2 = str;
            }
            if (str2.contains("\\") || str2.trim().isEmpty()) {
                Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: path = [%s] is illegal", str2);
            } else {
                ArrayList<String> arrayList = new ArrayList();
                while (true) {
                    if (str2.equals("")) {
                        break;
                    }
                    if (str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        Log.e("MicroMsg.WxaPkgFileSystem", "updateDirAccessTimeRecord: file = [%s] is illegal", str2);
                        break;
                    }
                    str2 = str2.substring(0, str2.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP));
                    if (str2.equals("")) {
                        arrayList.add(FilePathGenerator.ANDROID_DIR_SEP);
                    } else {
                        arrayList.add(str2 + FilePathGenerator.ANDROID_DIR_SEP);
                    }
                }
                for (String str3 : arrayList) {
                    this.kNe.put(str3, Long.valueOf(System.currentTimeMillis() / 1000));
                }
            }
            m mVar2 = m.OK;
            Util.qualityClose(UR);
            AppMethodBeat.o(134751);
            return mVar2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", e2, "readFile", new Object[0]);
            Util.qualityClose(UR);
            m mVar3 = m.ERR_OP_FAIL;
            AppMethodBeat.o(134751);
            return mVar3;
        } catch (Throwable th) {
            Util.qualityClose(UR);
            AppMethodBeat.o(134751);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m b(String str, i<ByteBuffer> iVar) {
        AppMethodBeat.i(134752);
        InputStream UR = this.kMl.UR(str);
        if (UR == null) {
            m mVar = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134752);
            return mVar;
        }
        try {
            int available = UR.available();
            Util.qualityClose(UR);
            m a2 = a(str, 0, (long) available, iVar);
            AppMethodBeat.o(134752);
            return a2;
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.WxaPkgFileSystem", e2, "readFile", new Object[0]);
            m mVar2 = m.ERR_OP_FAIL;
            Util.qualityClose(UR);
            AppMethodBeat.o(134752);
            return mVar2;
        } catch (Throwable th) {
            Util.qualityClose(UR);
            AppMethodBeat.o(134752);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m h(String str, List<x> list) {
        AppMethodBeat.i(219306);
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
        }
        if (str.contains("\\") || str.trim().isEmpty()) {
            Log.e("MicroMsg.WxaPkgFileSystem", "statDir: path = [%s] is illegal", str);
            m h2 = super.h(str, list);
            AppMethodBeat.o(219306);
            return h2;
        }
        for (String str2 : this.kMl.bwj()) {
            if (str2.startsWith(str)) {
                x xVar = new x(str2);
                String name = a(str2, xVar).name();
                if (name.equals(m.OK.name())) {
                    list.add(xVar);
                } else {
                    Log.w("MicroMsg.WxaPkgFileSystem", "statDir: stat [%s] fail:[%s]", str2, name);
                }
            }
        }
        m mVar = m.OK;
        AppMethodBeat.o(219306);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final m a(String str, FileStructStat fileStructStat) {
        AppMethodBeat.i(134753);
        InputStream UR = this.kMl.UR(str);
        if (UR == null) {
            if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = str + FilePathGenerator.ANDROID_DIR_SEP;
            }
            if (!str.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                str = FilePathGenerator.ANDROID_DIR_SEP.concat(String.valueOf(str));
            }
            if (Vk(str) == m.RET_NOT_EXISTS && Vj(str) == m.OK) {
                this.kMl.bwg().fillAnother(fileStructStat);
                fileStructStat.makeItIsDir();
                fileStructStat.st_size = 0;
                Long l = this.kNe.get(str);
                if (l != null) {
                    fileStructStat.st_atime = l.longValue();
                }
                m mVar = m.OK;
                AppMethodBeat.o(134753);
                return mVar;
            }
            m mVar2 = m.RET_NOT_EXISTS;
            AppMethodBeat.o(134753);
            return mVar2;
        }
        this.kMl.bwg().fillAnother(fileStructStat);
        try {
            fileStructStat.st_size = (long) UR.available();
            Util.qualityClose(UR);
        } catch (Exception e2) {
            Log.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", str);
        }
        m mVar3 = m.OK;
        AppMethodBeat.o(134753);
        return mVar3;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final o ag(String str, boolean z) {
        AppMethodBeat.i(176548);
        if (!z) {
            if (Vl(str) == m.OK) {
                AppMethodBeat.o(176548);
                return null;
            }
        }
        String a2 = com.tencent.mm.plugin.appbrand.appcache.ab.a(this.kMl, str);
        if (!TextUtils.isEmpty(a2)) {
            o oVar = new o(a2);
            AppMethodBeat.o(176548);
            return oVar;
        }
        AppMethodBeat.o(176548);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void initialize() {
        AppMethodBeat.i(134755);
        this.kMl.bvf();
        AppMethodBeat.o(134755);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.j
    public final void release() {
        AppMethodBeat.i(134756);
        this.kMl.close();
        AppMethodBeat.o(134756);
    }
}
