package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.qbar.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanImageUtils;", "", "()V", "TAG", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imagePath", "getHDScanImagePath", "msgId", "", "canUseThumb", "", "getScanHDImageWithMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "getScanImagePath", "getScanImageWithMsg", "plugin-scan_release"})
public final class ac {
    public static final ac CGB = new ac();

    static {
        AppMethodBeat.i(240452);
        AppMethodBeat.o(240452);
    }

    private ac() {
    }

    public static ScanImagePHashInfo aMA(String str) {
        AppMethodBeat.i(240448);
        p.h(str, "imagePath");
        try {
            Bitmap decodeFile = BitmapUtil.decodeFile(str);
            if (decodeFile != null) {
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                Log.i("MicroMsg.ScanImageUtils", "computeImagePHash width: %d, height: %d", Integer.valueOf(width), Integer.valueOf(height));
                int[] iArr = new int[(width * height)];
                decodeFile.getPixels(iArr, 0, decodeFile.getWidth(), 0, 0, decodeFile.getWidth(), decodeFile.getHeight());
                decodeFile.recycle();
                byte[] bArr = new byte[(width * height)];
                int a2 = d.a(iArr, bArr, width, height);
                if (a2 != 0) {
                    Log.e("MicroMsg.ScanImageUtils", "computeImagePHash transBytes failed result: %d", Integer.valueOf(a2));
                    AppMethodBeat.o(240448);
                    return null;
                }
                ScanImagePHashInfo M = x.M(bArr, width, height);
                Object[] objArr = new Object[2];
                objArr[0] = M != null ? M.pHash : null;
                objArr[1] = M != null ? M.pHashVersion : null;
                Log.d("MicroMsg.ScanImageUtils", "alvinluo computeImagePHash pHash: %s, pHashVersion: %s", objArr);
                AppMethodBeat.o(240448);
                return M;
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.ScanImageUtils", th, "computeImagePHash exception", new Object[0]);
        }
        AppMethodBeat.o(240448);
        return null;
    }

    static String aN(ca caVar) {
        AppMethodBeat.i(240449);
        if (caVar == null) {
            AppMethodBeat.o(240449);
            return null;
        } else if (caVar.gAz() || caVar.gDr()) {
            String str = q.bcR().OA(caVar.ajP()) + "hd";
            Log.i("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdThumbPath: %s", str);
            if (s.YS(str)) {
                AppMethodBeat.o(240449);
                return str;
            }
            AppMethodBeat.o(240449);
            return null;
        } else {
            AppMethodBeat.o(240449);
            return null;
        }
    }

    static String d(ca caVar, boolean z) {
        AppMethodBeat.i(240450);
        if (caVar == null) {
            AppMethodBeat.o(240450);
            return null;
        } else if (caVar.gAz() || caVar.gDr()) {
            if (caVar.ajN() == 1) {
                g H = q.bcR().H(caVar.ajO(), caVar.ajL());
                p.g(H, "SubCoreImage.getImgStg()…sgLocalId(msg.talker, id)");
                if (H.getLocalId() == 0) {
                    long ajM = caVar.ajM();
                    Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath img invalid and try get by msgSvrId: %s", Long.valueOf(ajM));
                    H = q.bcR().G(caVar.ajO(), ajM);
                    p.g(H, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
                }
                String bcr = H.bcr();
                String o = q.bcR().o(bcr, "", "");
                Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath bigImagePath %s, %s", bcr, o);
                if (s.YS(o)) {
                    AppMethodBeat.o(240450);
                    return o;
                }
                String a2 = q.bcR().a(caVar.ajO(), H);
                String o2 = q.bcR().o(a2, "", "");
                Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath hdImagePath %s, %s", a2, o2);
                if (s.YS(o2)) {
                    AppMethodBeat.o(240450);
                    return o2;
                }
            } else {
                g G = q.bcR().G(caVar.ajO(), caVar.ajM());
                p.g(G, "SubCoreImage.getImgStg()…yMsgSvrId(msg.talker, id)");
                String bcr2 = G.bcr();
                String o3 = q.bcR().o(bcr2, "", "");
                Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver bigImagePath %s, %s", bcr2, o3);
                if (s.YS(o3)) {
                    AppMethodBeat.o(240450);
                    return o3;
                }
                if (G.bcv()) {
                    String a3 = q.bcR().a(caVar.ajO(), G);
                    String o4 = q.bcR().o(a3, "", "");
                    Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver hdImagePath %s, %s", a3, o4);
                    if (s.YS(o4)) {
                        AppMethodBeat.o(240450);
                        return o4;
                    }
                }
                if (z) {
                    String bct = G.bct();
                    String OA = q.bcR().OA(bct);
                    Log.d("MicroMsg.ScanImageUtils", "alvinluo getImagePath receiver thumbImagePath: %s, %s", bct, OA);
                    AppMethodBeat.o(240450);
                    return OA;
                }
            }
            AppMethodBeat.o(240450);
            return null;
        } else {
            AppMethodBeat.o(240450);
            return null;
        }
    }

    public static String G(long j2, boolean z) {
        AppMethodBeat.i(240451);
        a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).eiy().Hb(j2);
        p.g(Hb, "msg");
        if (Hb.gAz() || Hb.gDr()) {
            String aN = aN(Hb);
            String str = aN;
            if (str == null || n.aL(str)) {
                aN = d(Hb, z);
            }
            AppMethodBeat.o(240451);
            return aN;
        }
        AppMethodBeat.o(240451);
        return null;
    }
}
