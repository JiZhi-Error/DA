package com.tencent.mm.plugin.multimediareport;

import android.graphics.BitmapFactory;
import android.os.Build;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.gogcv.Api;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class g extends q implements m {
    private static boolean gKM = false;
    private static Api zGY = new Api();
    private static boolean zGZ = false;
    private i callback;
    private d hJu;

    /* synthetic */ g(d dVar, int i2, long j2, byte b2) {
        this(dVar, i2, j2);
    }

    static {
        AppMethodBeat.i(194284);
        AppMethodBeat.o(194284);
    }

    public static void a(final d dVar, final int i2, final long j2, final String str) {
        AppMethodBeat.i(194280);
        Log.i("MicroMsg.NetSceneMultiMediaReport", "goto report, id:%d", Long.valueOf(j2));
        if (Util.isOverseasUser(MMApplicationContext.getContext())) {
            AppMethodBeat.o(194280);
        } else if (((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_multi_media_report_open, 0) != 1) {
            AppMethodBeat.o(194280);
        } else {
            if (!BuildInfo.IS_ARM64 && Build.VERSION.SDK_INT >= ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_multi_media_report_filter_api, 29)) {
                String a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_multi_media_report_filter_brand, "");
                if (!Util.isNullOrNil(Build.BRAND) && a2.toLowerCase().contains(Build.BRAND.toLowerCase())) {
                    AppMethodBeat.o(194280);
                    return;
                }
            }
            if (!gKM) {
                com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(83, 2);
                if (s.YS(kC)) {
                    j.load("ginfo");
                    zGZ = zGY.init(kC);
                    Log.w("MicroMsg.NetSceneMultiMediaReport", "init gogcv model! path: %s, result:%b", kC, Boolean.valueOf(zGZ));
                } else {
                    com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                    com.tencent.mm.pluginsdk.j.a.a.b.ahP(83);
                }
                gKM = true;
            }
            if (!zGZ) {
                AppMethodBeat.o(194280);
                return;
            }
            h.RTc.e(new Runnable() {
                /* class com.tencent.mm.plugin.multimediareport.g.AnonymousClass1 */

                public final void run() {
                    byte[] bArr;
                    AppMethodBeat.i(194279);
                    Log.i("MicroMsg.NetSceneMultiMediaReport", "do report, id:%d", Long.valueOf(j2));
                    if (dVar.zGJ == 1) {
                        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
                        int a2 = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_multi_media_report_filter_limit, 2048);
                        if (imageOptions.outWidth * imageOptions.outHeight > a2 * a2) {
                            Log.w("MicroMsg.NetSceneMultiMediaReport", "image too large (%d * %d)", Integer.valueOf(imageOptions.outWidth), Integer.valueOf(imageOptions.outHeight));
                            bArr = new byte[0];
                        } else {
                            if (imageOptions != null) {
                                dVar.zGN = imageOptions.outWidth;
                                dVar.zGO = imageOptions.outHeight;
                            }
                            bArr = g.zGY.checkImage(BitmapUtil.decodeFile(s.k(str, false), null));
                        }
                    } else {
                        try {
                            String[] split = ((b) com.tencent.mm.kernel.g.af(b.class)).a(b.a.clicfg_multi_media_report_video_sample, "0,0.5,1.0").split(",");
                            float[] fArr = new float[split.length];
                            for (int i2 = 0; i2 < split.length; i2++) {
                                fArr[i2] = Util.getFloat(split[i2], 0.0f);
                            }
                            Api unused = g.zGY;
                            bArr = g.zGY.checkVideo(Api.a(s.k(str, false), fArr));
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.NetSceneMultiMediaReport", e2, String.format("error %s", str), new Object[0]);
                            bArr = new byte[0];
                        }
                    }
                    Log.i("MicroMsg.NetSceneMultiMediaReport", "gogcv check result:%s, path:%s", new String(bArr), str);
                    dVar.zGU = new com.tencent.mm.bw.b(bArr);
                    com.tencent.mm.kernel.g.azz().a(new g(dVar, i2, j2, (byte) 0), 0);
                    AppMethodBeat.o(194279);
                }
            }, "ginforeport");
            AppMethodBeat.o(194280);
        }
    }

    private g(d dVar, int i2, long j2) {
        AppMethodBeat.i(194281);
        d.a aVar = new d.a();
        aVar.iLN = new e();
        aVar.iLO = new f();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/micromsg-bin/mulmediareportcgi";
        this.hJu = aVar.aXF();
        e eVar = (e) this.hJu.iLK.iLR;
        eVar.zGX = dVar;
        eVar.scene = i2;
        eVar.timestamp = j2;
        com.tencent.mm.kernel.g.aAf();
        eVar.zGW = (long) a.getUin();
        if (i2 == 2) {
            dVar.zGT = v.Ie(dVar.pPz);
            dVar.zGK = Util.safeParseLong(dVar.pPz.substring(0, dVar.pPz.indexOf(64)));
        }
        Log.i("MicroMsg.NetSceneMultiMediaReport", "NetSceneMultiMediaReport init, MediaScene:%s, mediaid:%s, MediaType:%s, MediaSource:%s, to_username:%s, chatromid:%s, sns_url:%s, fileid:%s, filekey:%s, md5:%s, createtime:%s, media_width:%s, media_height:%s, thumb_url:%s, video_len:%s, video_fps:%s, audio_sample_rate:%s, video_codec:%s, audio_codec:%s, qrcode_url：%s, chatroom_size:%s, uuid:%s", Integer.valueOf(i2), Long.valueOf(dVar.zGI), Integer.valueOf(dVar.zGJ), Integer.valueOf(dVar.source), dVar.pPz, Long.valueOf(dVar.zGK), dVar.zGL, dVar.fileid, dVar.zGM, dVar.md5, Long.valueOf(dVar.createtime), Integer.valueOf(dVar.zGN), Integer.valueOf(dVar.zGO), dVar.gTB, Integer.valueOf(dVar.zGP), Integer.valueOf(dVar.hyI), Integer.valueOf(dVar.zGQ), dVar.zGR, dVar.zGS, dVar.qwo, Integer.valueOf(dVar.zGT), dVar.uuid);
        AppMethodBeat.o(194281);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5865;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(194282);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(194282);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(194283);
        Log.i("MicroMsg.NetSceneMultiMediaReport", "onGYNetEnd, errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(194283);
    }
}
