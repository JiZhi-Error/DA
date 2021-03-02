package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u001dH&J\u0013\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH&¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u001dH&J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020$H&J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020\u001dH&J\u0006\u0010'\u001a\u00020\bJ\u0010\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001dH\u0002J\u0006\u0010*\u001a\u00020\bJ\u0006\u0010+\u001a\u00020\bJ\u0018\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dH\u0002J(\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020$H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "", "()V", "checkResUpdateCacheFileEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "downloadFileSuccessCallback", "Lkotlin/Function0;", "", "getDownloadFileSuccessCallback", "()Lkotlin/jvm/functions/Function0;", "setDownloadFileSuccessCallback", "(Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "fileExist", "getFileExist", "()Z", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/IVideoResReport;", "afterUnZipRes", "success", "checkFile", "checkRes", "getConfigJson", "Lorg/json/JSONArray;", "getFileDirName", "", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResTmpPath", "getResType", "", "getSubType", "getTag", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "moveFileToTargetPath", DownloadInfo.FILENAME, "reportEdit", "unInit", "unzipFolder", "zipFileString", "outPathString", "unzipRes", "filePath", "type", "subType", "version", "Companion", "plugin-recordvideo_release"})
public abstract class a {
    public static final C1652a BYb = new C1652a((byte) 0);
    public boolean BXZ;
    public kotlin.g.a.a<x> BYa;
    final IListener<bp> iUx = new b(this);

    public abstract b eLh();

    public abstract int eLi();

    public abstract String[] eLj();

    public abstract String eLk();

    public abstract String eLl();

    public abstract String getTag();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$Companion;", "", "()V", "RES_CONFIG", "", "RES_FILE_KEY", "RES_FILE_NAME", "RES_SUB_TYPE", "", "RES_TMP_PATH", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.res.a$a  reason: collision with other inner class name */
    public static final class C1652a {
        private C1652a() {
        }

        public /* synthetic */ C1652a(byte b2) {
            this();
        }
    }

    private final String eLm() {
        return eLk() + "temp/";
    }

    public void tu(boolean z) {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic$checkResUpdateCacheFileEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-recordvideo_release"})
    public static final class b extends IListener<bp> {
        final /* synthetic */ a BYc;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.BYc = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(237477);
            bp bpVar2 = bpVar;
            p.h(bpVar2, "event");
            if (bpVar2.dEN.dEO == this.BYc.eLi() && bpVar2.dEN.subType == 1) {
                Log.i(this.BYc.getTag(), "download res finish, path: %s, fileVersion: %s, fileUpdated: %s", bpVar2.dEN.filePath, Integer.valueOf(bpVar2.dEN.dEP), Boolean.valueOf(bpVar2.dEN.dEQ));
                g.aAk().postToWorker(new RunnableC1653a(this, bpVar2));
                this.BYc.eLh().eLt();
            }
            AppMethodBeat.o(237477);
            return false;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.recordvideo.res.a$b$a  reason: collision with other inner class name */
        static final class RunnableC1653a implements Runnable {
            final /* synthetic */ b BYd;
            final /* synthetic */ bp BYe;

            RunnableC1653a(b bVar, bp bpVar) {
                this.BYd = bVar;
                this.BYe = bpVar;
            }

            public final void run() {
                AppMethodBeat.i(237476);
                a aVar = this.BYd.BYc;
                String str = this.BYe.dEN.filePath;
                p.g(str, "event.data.filePath");
                aVar.o(str, this.BYe.dEN.dEO, this.BYe.dEN.subType, this.BYe.dEN.dEP);
                AppMethodBeat.o(237476);
            }
        }
    }

    public final JSONArray eLn() {
        if (this.BXZ) {
            return new JSONArray(s.boY(eLk() + "config.json"));
        }
        return null;
    }

    public final void bbA() {
        Log.i(getTag(), "checkRes " + eLi());
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(eLi());
        eLh().bbA();
    }

    public final void eLo() {
        if (this.BXZ) {
            eLh().eLr();
        } else {
            eLh().eLs();
        }
    }

    public final void init() {
        Log.i(getTag(), APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.iUx.alive();
        if (bbB()) {
            this.BXZ = true;
        } else {
            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
            String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(eLi(), 1);
            if (s.YS(kC)) {
                Log.i(getTag(), "cache file exist %s", kC);
                p.g(kC, "cacheFile");
                o(kC, eLi(), 1, 1);
            }
        }
        if (this.BXZ) {
            eLh().eLp();
        } else {
            eLh().eLq();
        }
    }

    private final boolean bbB() {
        String str = eLk() + "config.json";
        Log.i(getTag(), "absConfigPath is:".concat(String.valueOf(str)));
        if (s.YS(str)) {
            try {
                JSONArray jSONArray = new JSONArray(s.boY(str));
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String[] eLj = eLj();
                    int length2 = eLj.length;
                    for (int i3 = 0; i3 < length2; i3++) {
                        String str2 = eLk() + jSONObject.optString(eLj[i3]);
                        Log.i(getTag(), "file index:" + i2 + " path:" + str2);
                        if (!s.YS(str2)) {
                            Log.e(getTag(), "file not exist.path:".concat(String.valueOf(str2)));
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace(getTag(), e2, "video res parse config error!", new Object[0]);
                return false;
            }
        } else {
            Log.i(getTag(), "config not exist.");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final synchronized void o(String str, int i2, int i3, int i4) {
        Log.i(getTag(), "unzipRes: %s", str);
        if (s.YS(str)) {
            s.boN(eLm());
            int fW = fW(str, eLm());
            Log.i(getTag(), "unzip file ret:" + fW + "  " + eLm());
            Iterable<e> dC = s.dC(eLm() + eLl(), false);
            if (dC != null) {
                for (e eVar : dC) {
                    Log.i(getTag(), "unzip file path:" + eVar.NGP + " name:" + eVar.name + " size:" + eVar.size);
                }
            }
            boolean z = false;
            if (fW == 0) {
                try {
                    if (s.YS(eLm() + eLl() + "config.json")) {
                        String boY = s.boY(eLm() + eLl() + "config.json");
                        Log.i(getTag(), "meta json: %s", boY);
                        JSONArray jSONArray = new JSONArray(boY);
                        int length = jSONArray.length();
                        for (int i5 = 0; i5 < length; i5++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i5);
                            for (String str2 : eLj()) {
                                String optString = jSONObject.optString(str2);
                                p.g(optString, "item.optString(it)");
                                String str3 = eLm() + eLl() + optString;
                                String str4 = eLk() + optString;
                                Log.i(getTag(), "file tmp:" + str3 + "  real:" + str4);
                                if (!s.YS(str3)) {
                                    Log.e(getTag(), "fuck! config does not matching file list!!!!!!!!");
                                } else if (!s.YS(str4)) {
                                    Log.i(getTag(), "move file ".concat(String.valueOf(optString)));
                                    s.nx(str3, str4);
                                } else if (!p.j(com.tencent.mm.d.g.getMD5(str3), com.tencent.mm.d.g.getMD5(str4))) {
                                    s.deleteFile(str4);
                                    s.nx(str3, str4);
                                    Log.i(getTag(), "replace file ".concat(String.valueOf(optString)));
                                } else {
                                    Log.i(getTag(), "already has file ".concat(String.valueOf(optString)));
                                }
                            }
                        }
                        s.deleteFile(eLk() + "config.json");
                        s.nx(eLm() + eLl() + "config.json", eLk() + "config.json");
                        z = true;
                    }
                    if (!z) {
                        eLh().eLv();
                        Log.i(getTag(), "unzip failed");
                    } else {
                        eLh().eLu();
                        Log.i(getTag(), "unzip success");
                        com.tencent.mm.pluginsdk.j.a.a.b.gnC().aP(i2, i3, i4);
                        this.BXZ = true;
                    }
                    kotlin.g.a.a<x> aVar = this.BYa;
                    if (aVar != null) {
                        aVar.invoke();
                    }
                    s.dy(eLm(), true);
                    tu(z);
                } catch (Exception e2) {
                    Log.printErrStackTrace(getTag(), e2, "unzipRes error: %s", e2.getMessage());
                    eLh().eLv();
                    Log.i(getTag(), "unzip failed");
                    kotlin.g.a.a<x> aVar2 = this.BYa;
                    if (aVar2 != null) {
                        aVar2.invoke();
                    }
                    s.dy(eLm(), true);
                    tu(false);
                } catch (Throwable th) {
                    eLh().eLv();
                    Log.i(getTag(), "unzip failed");
                    kotlin.g.a.a<x> aVar3 = this.BYa;
                    if (aVar3 != null) {
                        aVar3.invoke();
                    }
                    s.dy(eLm(), true);
                    tu(false);
                    throw th;
                }
            }
        }
    }

    private final int fW(String str, String str2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2;
        Throwable th;
        ZipInputStream zipInputStream3;
        ZipEntry zipEntry;
        ZipEntry zipEntry2;
        try {
            ZipInputStream zipInputStream4 = new ZipInputStream(s.openRead(str));
            ZipEntry zipEntry3 = null;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream4.getNextEntry();
                    if (nextEntry != null) {
                        zipEntry = nextEntry;
                        zipEntry2 = nextEntry;
                    } else {
                        zipEntry = null;
                        zipEntry2 = zipEntry3;
                    }
                    if (zipEntry != null) {
                        if (zipEntry2 == null) {
                            p.hyc();
                        }
                        String name = zipEntry2.getName();
                        p.g(name, "zipEntry!!.name");
                        if (n.e(name, "../") || n.e(name, "..\\")) {
                            zipEntry3 = zipEntry2;
                        } else {
                            if (zipEntry2 == null) {
                                p.hyc();
                            }
                            if (zipEntry2.isDirectory()) {
                                int length = name.length() - 1;
                                if (name == null) {
                                    throw new t("null cannot be cast to non-null type java.lang.String");
                                }
                                String substring = name.substring(0, length);
                                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + substring).mkdirs();
                                zipEntry3 = zipEntry2;
                            } else {
                                o oVar = new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name);
                                o heq = oVar.heq();
                                if (heq != null) {
                                    heq.mkdirs();
                                }
                                OutputStream ap = s.ap(oVar);
                                p.g(ap, "VFSFileOp.openWrite(file)");
                                z.d dVar = new z.d();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = zipInputStream4.read(bArr);
                                    dVar.SYE = read;
                                    if (read == -1) {
                                        break;
                                    }
                                    ap.write(bArr, 0, dVar.SYE);
                                }
                                ap.close();
                                zipEntry3 = zipEntry2;
                            }
                        }
                    } else {
                        aa.closeQuietly(zipInputStream4);
                        return 0;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    zipInputStream = zipInputStream4;
                    try {
                        Log.printErrStackTrace(getTag(), e, "", new Object[0]);
                        aa.closeQuietly(zipInputStream);
                        return -1;
                    } catch (Throwable th2) {
                        th = th2;
                        zipInputStream3 = zipInputStream;
                        aa.closeQuietly(zipInputStream3);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    zipInputStream2 = zipInputStream4;
                    Log.printErrStackTrace(getTag(), e, "", new Object[0]);
                    aa.closeQuietly(zipInputStream2);
                    return -2;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream3 = zipInputStream4;
                    aa.closeQuietly(zipInputStream3);
                    throw th;
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            zipInputStream = null;
            Log.printErrStackTrace(getTag(), e, "", new Object[0]);
            aa.closeQuietly(zipInputStream);
            return -1;
        } catch (IOException e5) {
            e = e5;
            zipInputStream2 = null;
            Log.printErrStackTrace(getTag(), e, "", new Object[0]);
            aa.closeQuietly(zipInputStream2);
            return -2;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream3 = null;
            aa.closeQuietly(zipInputStream3);
            throw th;
        }
    }
}
