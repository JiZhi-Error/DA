package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.lite.b.e;
import com.tencent.mm.plugin.wepkg.d.b;
import com.tencent.mm.pluginsdk.j.a.d.a;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.protocal.protobuf.eya;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class g {
    private static int JNa = 4;
    private static ByteOrder JNb = ByteOrder.BIG_ENDIAN;
    private volatile int JNc;
    private volatile int JNd = 0;
    public volatile eya JNe = null;
    private volatile LinkedList<aod> JNf = null;
    private volatile String JNg = "";
    volatile boolean kKk = false;
    private volatile String mDesc = "";
    private o mFile;

    public g(o oVar) {
        boolean z = false;
        AppMethodBeat.i(177090);
        this.mFile = oVar;
        this.kKk = bwk() ? true : z;
        AppMethodBeat.o(177090);
    }

    public final WebResourceResponse mt(String str, String str2) {
        AppMethodBeat.i(110684);
        if (Util.isNullOrNil(this.JNf) || this.JNd < JNa || Util.isNullOrNil(str)) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            AppMethodBeat.o(110684);
            return null;
        }
        Iterator<aod> it = this.JNf.iterator();
        while (it.hasNext()) {
            aod next = it.next();
            if (Util.nullAsNil(next.LzG).equals(str)) {
                if (bcC(next.LzI)) {
                    Log.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", str);
                    AppMethodBeat.o(110684);
                    return null;
                } else if (((long) next.oUq) <= 5242880) {
                    try {
                        Log.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", str);
                        WebResourceResponse webResourceResponse = new WebResourceResponse(next.LzI, str2, new b(this.mFile, ((long) this.JNd) + next.LzH, (long) next.oUq));
                        if (!Util.isNullOrNil(next.LzJ)) {
                            HashMap hashMap = new HashMap();
                            Iterator<aob> it2 = next.LzJ.iterator();
                            while (it2.hasNext()) {
                                aob next2 = it2.next();
                                hashMap.put(next2.key, next2.value);
                            }
                            webResourceResponse.mResponseHeaders = hashMap;
                        }
                        AppMethodBeat.o(110684);
                        return webResourceResponse;
                    } catch (IOException e2) {
                        Log.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", str, Long.valueOf(next.LzH), Integer.valueOf(next.oUq), next.LzI, e2.getMessage());
                    }
                } else {
                    Log.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", Integer.valueOf(next.oUq), 5242880L, str, Long.valueOf(next.LzH), next.LzI);
                }
            }
        }
        AppMethodBeat.o(110684);
        return null;
    }

    private boolean bwk() {
        boolean z = false;
        AppMethodBeat.i(110685);
        FileChannel fileChannel = null;
        try {
            fileChannel = s.dB(aa.z(this.mFile.mUri), false).getChannel();
        } catch (Exception e2) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e2.getMessage());
        }
        if (fileChannel == null) {
            AppMethodBeat.o(110685);
        } else {
            try {
                fileChannel.position(0L);
                ByteBuffer allocate = ByteBuffer.allocate(JNa);
                allocate.order(JNb);
                fileChannel.read(allocate);
                this.JNc = allocate.getInt(0);
                z = b(fileChannel);
            } catch (Exception e3) {
                Log.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e3.getMessage());
            } finally {
                c(fileChannel);
                AppMethodBeat.o(110685);
            }
        }
        return z;
    }

    private boolean b(FileChannel fileChannel) {
        AppMethodBeat.i(110686);
        if (this.JNc <= 0) {
            AppMethodBeat.o(110686);
            return false;
        }
        try {
            fileChannel.position((long) JNa);
            ByteBuffer allocate = ByteBuffer.allocate(this.JNc);
            allocate.order(JNb);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                AppMethodBeat.o(110686);
                return false;
            }
            this.JNe = new eya();
            this.JNe.parseFrom(array);
            this.JNf = this.JNe.Nvh;
            this.JNg = this.JNe.Nvi;
            this.mDesc = this.JNe.Desc;
            this.JNd = JNa + this.JNc;
            AppMethodBeat.o(110686);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e2.getMessage());
            AppMethodBeat.o(110686);
            return false;
        }
    }

    private static void c(FileChannel fileChannel) {
        AppMethodBeat.i(110687);
        if (fileChannel != null) {
            try {
                fileChannel.close();
                AppMethodBeat.o(110687);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(110687);
    }

    private static boolean bcC(String str) {
        AppMethodBeat.i(200171);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(200171);
            return false;
        } else if (str.startsWith("video/") || str.startsWith("audio/")) {
            AppMethodBeat.o(200171);
            return true;
        } else {
            AppMethodBeat.o(200171);
            return false;
        }
    }

    public final String gkR() {
        AppMethodBeat.i(200172);
        if (Util.isNullOrNil(this.JNf) || this.JNd < JNa) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode, mFileIndexList is null");
            AppMethodBeat.o(200172);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<aod> it = this.JNf.iterator();
        while (it.hasNext()) {
            aod next = it.next();
            if (!bcC(next.LzI)) {
                try {
                    String convertStreamToString = d.convertStreamToString(new b(this.mFile, ((long) this.JNd) + next.LzH, (long) next.oUq));
                    if (convertStreamToString != null) {
                        sb.append("\n");
                        sb.append(convertStreamToString);
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.Wepkg.WePkgReader", "getAllCode: " + e2.getMessage());
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(200172);
        return sb2;
    }

    public final String bcD(String str) {
        AppMethodBeat.i(200173);
        if (Util.isNullOrNil(this.JNf) || this.JNd < JNa) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile, mFileIndexList is null");
            AppMethodBeat.o(200173);
            return null;
        }
        Iterator<aod> it = this.JNf.iterator();
        while (it.hasNext()) {
            aod next = it.next();
            if (Util.nullAsNil(str).equals(next.LzG) && !bcC(next.LzI)) {
                try {
                    String convertStreamToString = d.convertStreamToString(new b(this.mFile, ((long) this.JNd) + next.LzH, (long) next.oUq));
                    AppMethodBeat.o(200173);
                    return convertStreamToString;
                } catch (IOException e2) {
                    Log.e("MicroMsg.Wepkg.WePkgReader", "getTargetFile: " + e2.getMessage());
                }
            }
        }
        AppMethodBeat.o(200173);
        return null;
    }

    public final LinkedList<d> gkS() {
        Exception e2;
        OutputStream outputStream;
        b bVar;
        Throwable th;
        String str;
        String str2;
        AppMethodBeat.i(200174);
        if (Util.isNullOrNil(this.JNf) || this.JNd < JNa) {
            Log.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            AppMethodBeat.o(200174);
            return null;
        }
        LinkedList<d> linkedList = new LinkedList<>();
        Iterator<aod> it = this.JNf.iterator();
        while (it.hasNext()) {
            aod next = it.next();
            if (next.LzK != null && !Util.isNullOrNil(next.LzK.LzG)) {
                d dVar = new d();
                dVar.izu = next.LzK.jfi;
                dVar.izv = next.LzK.xut;
                dVar.JMW = next.LzK.LQp;
                dVar.cri = next.LzK.LQq;
                try {
                    b bVar2 = new b(this.mFile, ((long) this.JNd) + next.LzH, (long) next.oUq);
                    try {
                        str = com.tencent.mm.plugin.game.commlib.util.b.dTg() + "liteapp/" + dVar.izu + FilePathGenerator.ANDROID_DIR_SEP;
                        if (!s.YS(str)) {
                            s.boN(str);
                        }
                        str2 = str + dVar.cri;
                        outputStream = s.d(new o(str2), false);
                    } catch (Exception e3) {
                        e2 = e3;
                        outputStream = null;
                        bVar = bVar2;
                        try {
                            Log.e("MicroMsg.Wepkg.WePkgReader", e2.getMessage());
                            a.c(bVar);
                            a.c(outputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            a.c(bVar);
                            a.c(outputStream);
                            AppMethodBeat.o(200174);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = null;
                        bVar = bVar2;
                        a.c(bVar);
                        a.c(outputStream);
                        AppMethodBeat.o(200174);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = bVar2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                        e.ix(str2, str);
                        dVar.filePath = str;
                        linkedList.add(dVar);
                        a.c(bVar2);
                        a.c(outputStream);
                    } catch (Exception e4) {
                        e2 = e4;
                        bVar = bVar2;
                        Log.e("MicroMsg.Wepkg.WePkgReader", e2.getMessage());
                        a.c(bVar);
                        a.c(outputStream);
                    } catch (Throwable th4) {
                        th = th4;
                        bVar = bVar2;
                        a.c(bVar);
                        a.c(outputStream);
                        AppMethodBeat.o(200174);
                        throw th;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    outputStream = null;
                    bVar = null;
                    Log.e("MicroMsg.Wepkg.WePkgReader", e2.getMessage());
                    a.c(bVar);
                    a.c(outputStream);
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    bVar = null;
                    a.c(bVar);
                    a.c(outputStream);
                    AppMethodBeat.o(200174);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(200174);
        return linkedList;
    }
}
