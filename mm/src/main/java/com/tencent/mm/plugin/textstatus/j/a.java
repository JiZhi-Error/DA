package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/util/PathProvider;", "", "()V", "TAG", "", "textStatusAccPath", "getTextStatusAccPath", "()Ljava/lang/String;", "clearPath", "", ch.COL_USERNAME, "getHistoryPath", "url", "getIconPath", "getKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getLocalVideoPath", "getPath", "type", "plugin-textstatus_release"})
public final class a {
    private static String GfT = "";
    public static final a GfU = new a();

    static {
        AppMethodBeat.i(216678);
        AppMethodBeat.o(216678);
    }

    private a() {
    }

    public static String fwF() {
        AppMethodBeat.i(216673);
        StringBuilder sb = new StringBuilder();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String sb2 = sb.append(aAh.getAccPath()).append("textstatus/").toString();
        AppMethodBeat.o(216673);
        return sb2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0077, code lost:
        if (r4.equals("thumb") != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0081, code lost:
        if (r4.equals("video") != false) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006d, code lost:
        if (r4.equals("image") != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String lf(java.lang.String r4, java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.j.a.lf(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String aTo(String str) {
        AppMethodBeat.i(216675);
        p.h(str, ch.COL_USERNAME);
        String str2 = fwF() + "local/video";
        if (!s.YS(str2)) {
            s.boN(str2);
        }
        StringBuilder append = new StringBuilder().append(str2).append(FilePathGenerator.ANDROID_DIR_SEP);
        byte[] bytes = str.getBytes(d.UTF_8);
        p.g(bytes, "(this as java.lang.String).getBytes(charset)");
        String sb = append.append(com.tencent.mm.b.g.getMessageDigest(bytes)).toString();
        AppMethodBeat.o(216675);
        return sb;
    }

    public static void amg(String str) {
        AppMethodBeat.i(257986);
        p.h(str, ch.COL_USERNAME);
        boolean deleteFile = s.deleteFile(lf("thumb", str));
        boolean deleteFile2 = s.deleteFile(lf("image", str));
        Log.i("MicroMsg.TxtStatus.PathProvider", "clearPath " + str + ' ' + deleteFile + ' ' + deleteFile2 + ' ' + s.deleteFile(lf("video", str)));
        AppMethodBeat.o(257986);
    }

    public static String fwG() {
        AppMethodBeat.i(216676);
        String str = b.aKB() + "textstatus/icon_10008";
        if (!s.YS(str)) {
            s.boN(str);
        }
        AppMethodBeat.o(216676);
        return str;
    }

    public static MultiProcessMMKV getKV() {
        AppMethodBeat.i(216677);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("text_status");
        AppMethodBeat.o(216677);
        return mmkv;
    }
}
