package com.tencent.mm.plugin.luckymoney.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.g.a.av;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.luckymoney.model.aa;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;

public final class n extends IListener<av> {
    private ArrayList<String> yUP = new ArrayList<>();

    public n() {
        AppMethodBeat.i(65177);
        this.__eventId = av.class.getName().hashCode();
        AppMethodBeat.o(65177);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(av avVar) {
        AppMethodBeat.i(65178);
        av avVar2 = avVar;
        if (!g.aAc()) {
            Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (avVar2 instanceof av) {
            Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            g.aAi();
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, (Object) 1)).intValue();
            Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:".concat(String.valueOf(intValue)));
            if (intValue == 0) {
                Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = avVar2.dDS.dDT;
                String str2 = avVar2.dDS.dDU;
                int i2 = avVar2.dDS.dDV;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 <= 0) {
                    Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                    Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.yUP.contains(str)) {
                    Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:".concat(String.valueOf(str)));
                } else {
                    String str3 = af.aDx(str) + ".temp";
                    if (!new o(str3).exists()) {
                        Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.yUP.add(str);
                        aa aaVar = new aa();
                        AnonymousClass1 r5 = new aa.a() {
                            /* class com.tencent.mm.plugin.luckymoney.model.n.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.luckymoney.model.aa.a
                            public final void bN(String str, boolean z) {
                                AppMethodBeat.i(65176);
                                if (z) {
                                    Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:".concat(String.valueOf(str)));
                                    AppMethodBeat.o(65176);
                                    return;
                                }
                                Log.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:".concat(String.valueOf(str)));
                                AppMethodBeat.o(65176);
                            }
                        };
                        Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", str);
                        aaVar.yWA = false;
                        aaVar.rCh = Util.nullAsNil(c.a("NewYearImg", System.currentTimeMillis(), z.aUL().field_username, ""));
                        Log.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", aaVar.rCh);
                        aaVar.yWz = str3;
                        aaVar.yWy = r5;
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.taskName = "task_LuckyMoneyNewYearImageUploader_2";
                        gVar.ehd = false;
                        gVar.gqy = aaVar;
                        gVar.field_fullpath = str3;
                        gVar.field_mediaId = aaVar.rCh;
                        gVar.field_fileId = str;
                        gVar.field_aesKey = str2;
                        gVar.field_totalLen = i2;
                        gVar.field_fileType = a.MediaType_FILE;
                        gVar.field_priority = a.gpM;
                        gVar.field_needStorage = false;
                        gVar.field_isStreamMedia = false;
                        gVar.field_appType = 0;
                        gVar.field_bzScene = 0;
                        if (!f.baQ().b(gVar, -1)) {
                            Log.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", str);
                        }
                    } else {
                        Log.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    }
                }
            }
        }
        AppMethodBeat.o(65178);
        return false;
    }
}
