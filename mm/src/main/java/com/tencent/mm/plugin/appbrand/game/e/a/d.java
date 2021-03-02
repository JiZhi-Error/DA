package com.tencent.mm.plugin.appbrand.game.e.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.game.e.a.b;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class d extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.e.a.c
    public final void a(final c cVar, final int i2, b.a aVar, String str, ArrayList<GameShareOption> arrayList, b.d dVar) {
        String str2;
        VideoTransPara videoTransPara = null;
        AppMethodBeat.i(45144);
        Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: wc start edit screen recorder, with result is %s", dVar);
        final int aK = a.aK(this);
        Activity ay = cVar.ay(Activity.class);
        if (ay == null) {
            cVar.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(45144);
            return;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.game.e.a.d.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174728);
                if (i2 == aK) {
                    Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: on result callback, result code: %d", Integer.valueOf(i3));
                    if (i3 == 0 || i3 == 3001) {
                        Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: user cancelled share!");
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("errCode", 803);
                        cVar.i(i2, d.this.n("fail: user cancelled", hashMap));
                    } else if (i3 != -1 || intent == null || !intent.hasExtra("key_req_result")) {
                        d.this.a(cVar, i2, 1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "edit file failed!");
                    } else {
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        int intExtra = intent.getIntExtra("key_selected_item", 0);
                        String stringExtra = intent.getStringExtra("key_ext_url");
                        Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: is video: %b, video path %s, thumb path: %s, md5: %s, selectedItem: %d, extUrl: %s", Boolean.valueOf(sightCaptureResult.tkD), sightCaptureResult.zsA, sightCaptureResult.zsB, sightCaptureResult.zsD, Integer.valueOf(intExtra), stringExtra);
                        if (!sightCaptureResult.tkD) {
                            d.this.a(cVar, i2, 3, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "not a video");
                        } else if (Util.isNullOrNil(sightCaptureResult.zsC) || Util.isNullOrNil(sightCaptureResult.zsD)) {
                            d.this.a(cVar, i2, 1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "edit failed!");
                        } else {
                            String str = sightCaptureResult.zsA;
                            String str2 = sightCaptureResult.zsB;
                            Bitmap PF = com.tencent.mm.plugin.mmsight.d.PF(str);
                            if (PF != null) {
                                try {
                                    BitmapUtil.saveBitmapToImage(PF, 100, Bitmap.CompressFormat.JPEG, str2, true);
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderEditWC", e2, "hy: exception when convert bitmap", new Object[0]);
                                }
                            } else {
                                Log.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: generated thumb path is null!");
                            }
                            b.a a2 = d.this.a(cVar, str, "edited_video.mp4", Util.isNullOrNil(stringExtra));
                            b.a a3 = d.this.a(cVar, str2, "edited_video_thumb.jpg", Util.isNullOrNil(stringExtra));
                            if (a2 == null) {
                                Log.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save video temp file failed!");
                                d.this.a(cVar, i2, 1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "video file save to file system failed!");
                                AppMethodBeat.o(174728);
                                return true;
                            } else if (a3 == null) {
                                Log.w("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: save thumb temp file failed!");
                                d.this.a(cVar, i2, 1, TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED, "video thumb file save to file system failed!");
                                AppMethodBeat.o(174728);
                                return true;
                            } else {
                                HashMap hashMap2 = new HashMap(3);
                                hashMap2.put("errCode", 0);
                                hashMap2.put("videoPath", a2.lsC);
                                hashMap2.put("thumbPath", a3.lsC);
                                hashMap2.put("videoMD5", sightCaptureResult.zsD);
                                hashMap2.put("chosenId", Integer.valueOf(intExtra));
                                hashMap2.put("extUrl", stringExtra);
                                cVar.i(i2, d.this.n("ok", hashMap2));
                            }
                        }
                    }
                    AppMethodBeat.o(174728);
                    return true;
                }
                AppMethodBeat.o(174728);
                return false;
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("k_ext_wording", str);
        bundle.putParcelableArrayList("k_ext_share_options", arrayList);
        com.tencent.mm.plugin.appbrand.game.g.b g2 = g(cVar);
        if (g2.luP != null) {
            videoTransPara = g2.luP.bDA();
        }
        videoTransPara.audioBitrate = 64000;
        videoTransPara.audioSampleRate = dVar.audioSampleRate;
        videoTransPara.audioChannelCount = 1;
        bundle.putParcelable("k_preferred_trans_param", videoTransPara);
        if (cVar.getRuntime() == null || cVar.getRuntime().bsB() == null) {
            str2 = "";
        } else {
            str2 = cVar.getRuntime().bsB().brandName;
        }
        ((g) com.tencent.mm.kernel.g.af(g.class)).a(ay, cVar.getAppId(), str2, aVar.lsB, aK, bundle);
        AppMethodBeat.o(45144);
    }
}
