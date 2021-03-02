package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.protocal.protobuf.dpa;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class t extends IListener<bp> implements i {
    public static final String yWf = (b.aKB() + "luckymoney/");

    public t() {
        AppMethodBeat.i(160802);
        this.__eventId = bp.class.getName().hashCode();
        AppMethodBeat.o(160802);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(bp bpVar) {
        AppMethodBeat.i(65219);
        final bp bpVar2 = bpVar;
        if (bpVar2.dEN.dEO == 58) {
            Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(bpVar2.dEN.dEO), Integer.valueOf(bpVar2.dEN.subType), bpVar2.dEN.filePath);
            h.INSTANCE.dN(991, 0);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.luckymoney.model.t.AnonymousClass1 */

                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(65216);
                    if (!Util.isNullOrNil(bpVar2.dEN.filePath)) {
                        if (t.bD(bpVar2.dEN.subType, bpVar2.dEN.filePath)) {
                            h.INSTANCE.dN(991, 15);
                            if (t.gU(bpVar2.dEN.subType, bpVar2.dEN.dEP)) {
                                Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "not retry");
                                h.INSTANCE.dN(991, 14);
                            } else {
                                h.INSTANCE.dN(991, 1);
                                z = false;
                            }
                        } else {
                            h.INSTANCE.dN(991, 2);
                            z = false;
                        }
                        com.tencent.mm.pluginsdk.j.a.a.b.gnC().g(bpVar2.dEN.dEO, bpVar2.dEN.subType, bpVar2.dEN.dEP, z);
                    }
                    AppMethodBeat.o(65216);
                }
            }, "lucky_money_envelope_resource_checker");
        }
        AppMethodBeat.o(65219);
        return false;
    }

    static {
        AppMethodBeat.i(65222);
        AppMethodBeat.o(65222);
    }

    public static void efh() {
        AppMethodBeat.i(65217);
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(58);
        AppMethodBeat.o(65217);
    }

    public static String PK(int i2) {
        AppMethodBeat.i(65218);
        String str = yWf + i2 + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(65218);
        return str;
    }

    public static String awX(int i2) {
        AppMethodBeat.i(258585);
        String str = PK(i2) + "story/";
        AppMethodBeat.o(258585);
        return str;
    }

    public static String nk(int i2, int i3) {
        AppMethodBeat.i(258586);
        String str = awX(i2) + "detail_video_" + i3 + ".mp4";
        AppMethodBeat.o(258586);
        return str;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(258587);
        Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resourceType.errType:%s，errCode：%s", Integer.valueOf(i2), Integer.valueOf(i3));
        if ((qVar instanceof m) && i2 == 0 && i3 == 0) {
            zi ziVar = (zi) ((d) qVar.getReqResp()).iLL.iLR;
            if (!Util.isNullOrNil(ziVar.LkC)) {
                for (dpa dpa : ziVar.LkC) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(dpa.oUv);
                    objArr[1] = Util.isNullOrNil(dpa.MSz) ? BuildConfig.COMMAND : String.valueOf(dpa.MSz.size());
                    Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resType：%d，responses.size()：%s", objArr);
                    if (dpa.oUv == 58 && !Util.isNullOrNil(dpa.MSz)) {
                        h.INSTANCE.dN(991, 15);
                    }
                }
            }
        }
        AppMethodBeat.o(258587);
    }

    static /* synthetic */ boolean bD(int i2, String str) {
        AppMethodBeat.i(65220);
        String str2 = yWf;
        String str3 = yWf + i2;
        if (s.YS(str3)) {
            Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "fileExists exist,first delete file ：%s", str3);
            s.dy(str3, true);
        }
        new o(str2).mkdirs();
        int fW = s.fW(str, str2);
        Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "unzip ret: %s", Integer.valueOf(fW));
        if (fW == 0) {
            AppMethodBeat.o(65220);
            return true;
        }
        AppMethodBeat.o(65220);
        return false;
    }

    static /* synthetic */ boolean gU(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(65221);
        String str = yWf + i2 + FilePathGenerator.ANDROID_DIR_SEP;
        if (!s.YS(str)) {
            AppMethodBeat.o(65221);
            return false;
        }
        u uVar = new u();
        uVar.field_subtype = i2;
        boolean z2 = a.eex().eet().get(uVar, new String[0]);
        o[] het = new o(str).het();
        if (het == null || het.length <= 0) {
            z = false;
        } else {
            z = false;
            for (o oVar : het) {
                if (oVar.isFile()) {
                    String bhK = s.bhK(aa.z(new o(aa.z(oVar.her())).mUri));
                    if (oVar.getName().equals("bubble.png")) {
                        uVar.field_bubbleMd5 = bhK;
                        z = true;
                    } else if (oVar.getName().equals("cover.png")) {
                        uVar.field_coverMd5 = bhK;
                        z = true;
                    } else if (oVar.getName().equals("minilogo.png")) {
                        uVar.field_minilogoMd5 = bhK;
                        z = true;
                    } else if (oVar.getName().equals("detail.png")) {
                        uVar.field_detailMd5 = bhK;
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            Log.w("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "error file dir");
            AppMethodBeat.o(65221);
            return false;
        }
        uVar.field_version = i3;
        Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "insert or update resource: %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2));
        if (z2) {
            boolean update = a.eex().eet().update(uVar, new String[0]);
            AppMethodBeat.o(65221);
            return update;
        }
        boolean insert = a.eex().eet().insert(uVar);
        AppMethodBeat.o(65221);
        return insert;
    }
}
