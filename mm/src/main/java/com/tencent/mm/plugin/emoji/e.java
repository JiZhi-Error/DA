package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class e implements c {
    private static e qWy;

    public static e cEM() {
        AppMethodBeat.i(104534);
        if (qWy == null) {
            qWy = new e();
        }
        e eVar = qWy;
        AppMethodBeat.o(104534);
        return eVar;
    }

    private e() {
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final boolean cEN() {
        AppMethodBeat.i(104535);
        int errorCode = MMWXGFJNI.getErrorCode();
        Log.i("MicroMsg.HevcHelperService", "checkHevcReady: %s", Integer.valueOf(errorCode));
        if (errorCode == 0) {
            AppMethodBeat.o(104535);
            return true;
        }
        AppMethodBeat.o(104535);
        return false;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final String alX(String str) {
        AppMethodBeat.i(104536);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(104536);
            return str;
        }
        String str2 = str + "_hevc";
        AppMethodBeat.o(104536);
        return str2;
    }

    public static int a(byte[] bArr, String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(199780);
        long currentTicks = Util.currentTicks();
        int i6 = 7;
        if (".gif".equals(ImgUtil.identifyImgType(str))) {
            i6 = 3;
        }
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            String k = s.k(str2, true);
            int length = bArr.length;
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_sns_wxam_params, 25);
            if (a2 < 0) {
                a2 = cEQ();
            }
            errorCode = MMWXGFJNI.pic2WxamWithWH(k, bArr, length, i6, a2, i2, i3, i4, i5);
            if (s.boW(str2) <= 0) {
                errorCode = -10;
            }
            if (errorCode != 0) {
                h.INSTANCE.dN(944, 0);
            } else {
                h.INSTANCE.dN(944, 2);
                h.INSTANCE.n(944, 3, Util.ticksToNow(currentTicks));
            }
        }
        Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d，%s", Integer.valueOf(errorCode), Integer.valueOf(i6), Long.valueOf(s.boW(str2)), Long.valueOf(Util.ticksToNow(currentTicks)), s.k(str2, true));
        AppMethodBeat.o(199780);
        return errorCode;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final int fO(String str, String str2) {
        AppMethodBeat.i(104537);
        long currentTicks = Util.currentTicks();
        String identifyImgType = ImgUtil.identifyImgType(str);
        int i2 = 0;
        if (".png".equals(identifyImgType)) {
            i2 = 1;
        } else if (".gif".equals(identifyImgType)) {
            i2 = 3;
        }
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            int pic2Wxam = MMWXGFJNI.pic2Wxam(s.k(str, false), s.k(str2, true), i2, cEQ());
            if (s.boW(str2) <= 0) {
                pic2Wxam = -10;
            }
            if (pic2Wxam != 0) {
                h.INSTANCE.dN(944, 0);
                errorCode = pic2Wxam;
            } else {
                h.INSTANCE.dN(944, 2);
                h.INSTANCE.n(944, 3, Util.ticksToNow(currentTicks));
                errorCode = pic2Wxam;
            }
        }
        Log.i("MicroMsg.HevcHelperService", "pic2wxam %d, %d, %d, %d, %d", Integer.valueOf(errorCode), Integer.valueOf(i2), Long.valueOf(s.boW(str)), Long.valueOf(s.boW(str2)), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(104537);
        return errorCode;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final int nativeWxam2Pic(String str, String str2) {
        AppMethodBeat.i(104538);
        long currentTicks = Util.currentTicks();
        int errorCode = MMWXGFJNI.getErrorCode();
        if (errorCode == 0) {
            errorCode = MMWXGFJNI.wxam2Pic(s.k(str, false), s.k(str2, true));
            if (s.boW(str2) <= 0) {
                errorCode = -10;
            }
            if (errorCode != 0) {
                h.INSTANCE.dN(944, 1);
            } else {
                h.INSTANCE.dN(944, 5);
                h.INSTANCE.n(944, 6, Util.ticksToNow(currentTicks));
            }
        }
        Log.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", Integer.valueOf(errorCode), Long.valueOf(s.boW(str)), Long.valueOf(s.boW(str2)), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(104538);
        return errorCode;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final byte[] bn(byte[] bArr) {
        AppMethodBeat.i(104539);
        long currentTicks = Util.currentTicks();
        int errorCode = MMWXGFJNI.getErrorCode();
        byte[] bArr2 = null;
        if (errorCode == 0) {
            bArr2 = MMWXGFJNI.nativeWxam2PicBuf(bArr);
            if (bArr2 == null) {
                h.INSTANCE.dN(944, 1);
            } else {
                h.INSTANCE.dN(944, 5);
                h.INSTANCE.n(944, 6, Util.ticksToNow(currentTicks));
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(errorCode);
        objArr[1] = Integer.valueOf(bArr.length);
        objArr[2] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
        objArr[3] = Long.valueOf(Util.ticksToNow(currentTicks));
        Log.i("MicroMsg.HevcHelperService", "wxam2pic %d, %d, %d, %d", objArr);
        AppMethodBeat.o(104539);
        return bArr2;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final boolean cEO() {
        AppMethodBeat.i(104540);
        boolean a2 = ((b) g.af(b.class)).a(b.a.mmc2c_image_upload_hevc_and, false);
        Log.i("MicroMsg.HevcHelperService", "hevc upload %s", Boolean.valueOf(a2));
        if (!cEN() || !a2) {
            AppMethodBeat.o(104540);
            return false;
        }
        AppMethodBeat.o(104540);
        return true;
    }

    @Override // com.tencent.mm.plugin.emoji.b.c
    public final boolean cEP() {
        AppMethodBeat.i(104541);
        boolean a2 = ((b) g.af(b.class)).a(b.a.mmc2c_image_download_hevc_and, false);
        Log.i("MicroMsg.HevcHelperService", "hevc download %s", Boolean.valueOf(a2));
        if (!cEN() || !a2) {
            AppMethodBeat.o(104541);
            return false;
        }
        AppMethodBeat.o(104541);
        return true;
    }

    private static int cEQ() {
        int i2;
        AppMethodBeat.i(104542);
        try {
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                i2 = Util.getInt(((a) g.af(a.class)).aqJ().getValue("CompressPicLevelForWifi"), 60);
            } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                i2 = Util.getInt(((a) g.af(a.class)).aqJ().getValue("CompressPicLevelFor2G"), 40);
            } else {
                i2 = NetStatusUtil.is3G(MMApplicationContext.getContext()) ? Util.getInt(((a) g.af(a.class)).aqJ().getValue("CompressPicLevelFor3G"), 40) : Util.getInt(((a) g.af(a.class)).aqJ().getValue("CompressPicLevelFor4G"), 60);
            }
        } catch (Exception e2) {
            i2 = 60;
        }
        int round = Math.round(39.0f - (((float) i2) / 5.0f));
        AppMethodBeat.o(104542);
        return round;
    }
}
