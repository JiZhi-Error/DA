package com.tencent.mm.plugin.scanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.h.b;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.ekt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PluginScanTranslation extends f implements i, a, c, e {
    private static HashMap<Integer, h.b> baseDBFactories;
    private k CzC = new k();
    private b CzD;
    private HashMap<Integer, ak> CzE = new HashMap<>();
    private HashMap<Integer, go> CzF = new HashMap<>();
    private HashMap<Integer, Long> CzG = new HashMap<>();
    private k.b CzH = new k.b() {
        /* class com.tencent.mm.plugin.scanner.PluginScanTranslation.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.scanner.util.k.b
        public final void d(int i2, Bitmap bitmap) {
            AppMethodBeat.i(120838);
            if (PluginScanTranslation.this.CzE.containsKey(Integer.valueOf(i2))) {
                if (PluginScanTranslation.this.CzF.containsKey(Integer.valueOf(i2)) && PluginScanTranslation.this.CzG.containsKey(Integer.valueOf(i2))) {
                    ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(i2))).eJW = System.currentTimeMillis() - ((Long) PluginScanTranslation.this.CzG.get(Integer.valueOf(i2))).longValue();
                    ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(i2))).bfK();
                    PluginScanTranslation.this.CzF.remove(Integer.valueOf(i2));
                    PluginScanTranslation.this.CzG.remove(Integer.valueOf(i2));
                    Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()));
                }
                if (!g.aAc()) {
                    AppMethodBeat.o(120838);
                    return;
                }
                String genTranslationResultImgPath = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 80, Bitmap.CompressFormat.JPEG, genTranslationResultImgPath, false);
                    aj ajVar = new aj();
                    ak akVar = (ak) PluginScanTranslation.this.CzE.get(Integer.valueOf(i2));
                    ajVar.field_originMD5 = MD5Util.getMD5String(akVar.jrK + s.boX(akVar.jrK));
                    ajVar.field_resultFile = genTranslationResultImgPath;
                    ajVar.field_fromLang = akVar.eab;
                    ajVar.field_toLang = akVar.eac;
                    ajVar.field_brand = akVar.brand;
                    Log.i("MicroMsg.PluginScanTranslation", "translate %d success, insert translate result %s", Integer.valueOf(i2), genTranslationResultImgPath);
                    ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a(ajVar);
                    tp tpVar = new tp();
                    tpVar.dZZ.dEb = i2;
                    tpVar.dZZ.dDz = true;
                    tpVar.dZZ.eaa = genTranslationResultImgPath;
                    tpVar.dZZ.eab = akVar.eab;
                    tpVar.dZZ.eac = akVar.eac;
                    if (PluginScanTranslation.this.CzF.containsKey(Integer.valueOf(i2))) {
                        tpVar.dZZ.source = (int) ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(i2))).eDV;
                    }
                    EventCenter.instance.publish(tpVar);
                    PluginScanTranslation.this.CzE.remove(Integer.valueOf(i2));
                    AppMethodBeat.o(120838);
                    return;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.PluginScanTranslation", e2, "save translate result file error", new Object[0]);
                    PluginScanTranslation.access$300(PluginScanTranslation.this, i2);
                }
            }
            AppMethodBeat.o(120838);
        }
    };
    private IListener<ay> CzI = new IListener<ay>() {
        /* class com.tencent.mm.plugin.scanner.PluginScanTranslation.AnonymousClass3 */

        {
            AppMethodBeat.i(161736);
            this.__eventId = ay.class.getName().hashCode();
            AppMethodBeat.o(161736);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ay ayVar) {
            AppMethodBeat.i(120839);
            ay ayVar2 = ayVar;
            if (ayVar2.dEa.scene != 1 || !PluginScanTranslation.this.CzE.containsKey(Integer.valueOf(ayVar2.dEa.dEb))) {
                AppMethodBeat.o(120839);
                return false;
            }
            Log.i("MicroMsg.PluginScanTranslation", "cancel translate sessionId %d", Integer.valueOf(ayVar2.dEa.dEb));
            PluginScanTranslation.this.CzE.remove(Integer.valueOf(ayVar2.dEa.dEb));
            if (PluginScanTranslation.this.CzF.containsKey(Integer.valueOf(ayVar2.dEa.dEb)) && PluginScanTranslation.this.CzG.containsKey(Integer.valueOf(ayVar2.dEa.dEb))) {
                ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).eEt = 2;
                ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).eJW = System.currentTimeMillis() - ((Long) PluginScanTranslation.this.CzG.get(Integer.valueOf(ayVar2.dEa.dEb))).longValue();
                ((go) PluginScanTranslation.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).bfK();
                PluginScanTranslation.this.CzF.remove(Integer.valueOf(ayVar2.dEa.dEb));
                PluginScanTranslation.this.CzG.remove(Integer.valueOf(ayVar2.dEa.dEb));
                Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()));
            }
            AppMethodBeat.o(120839);
            return true;
        }
    };
    private IListener<to> CzJ = new IListener<to>() {
        /* class com.tencent.mm.plugin.scanner.PluginScanTranslation.AnonymousClass4 */

        {
            AppMethodBeat.i(161737);
            this.__eventId = to.class.getName().hashCode();
            AppMethodBeat.o(161737);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(to toVar) {
            AppMethodBeat.i(120842);
            boolean a2 = a(toVar);
            AppMethodBeat.o(120842);
            return a2;
        }

        private boolean a(final to toVar) {
            Bitmap decodeFile;
            AppMethodBeat.i(120841);
            if (!Util.isNullOrNil(toVar.dZY.filePath)) {
                try {
                    Log.i("MicroMsg.PluginScanTranslation", "request to translate img %s, sessionId %d", toVar.dZY.filePath, Integer.valueOf(toVar.dZY.dEb));
                    fx aMG = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG(MD5Util.getMD5String(toVar.dZY.filePath + s.boX(toVar.dZY.filePath)));
                    if (aMG != null) {
                        Log.i("MicroMsg.PluginScanTranslation", "already has translation result");
                        String str = aMG.field_resultFile;
                        if (s.YS(str)) {
                            tp tpVar = new tp();
                            tpVar.dZZ.dEb = toVar.dZY.dEb;
                            tpVar.dZZ.dDz = true;
                            tpVar.dZZ.eaa = str;
                            tpVar.dZZ.eab = aMG.field_fromLang;
                            tpVar.dZZ.eac = aMG.field_toLang;
                            EventCenter.instance.publish(tpVar);
                            PluginScanTranslation.this.CzE.remove(Integer.valueOf(toVar.dZY.dEb));
                            AppMethodBeat.o(120841);
                            return true;
                        }
                        Log.w("MicroMsg.PluginScanTranslation", "can not find old translation result!");
                    }
                    final go goVar = new go();
                    goVar.eDV = (long) a.Wo(toVar.dZY.scene);
                    PluginScanTranslation.this.CzF.put(Integer.valueOf(toVar.dZY.dEb), goVar);
                    ak akVar = new ak();
                    akVar.jrK = toVar.dZY.filePath;
                    akVar.CHv = toVar.dZY.filePath;
                    int orientationInDegree = Exif.fromFile(toVar.dZY.filePath).getOrientationInDegree();
                    Log.i("MicroMsg.PluginScanTranslation", "original img degree %s", Integer.valueOf(orientationInDegree));
                    final String str2 = toVar.dZY.filePath;
                    final String aMv = p.aMv(toVar.dZY.filePath);
                    if (!(orientationInDegree == 0 || (decodeFile = BitmapUtil.decodeFile(toVar.dZY.filePath, new BitmapFactory.Options())) == null)) {
                        Bitmap rotate = BitmapUtil.rotate(decodeFile, (float) orientationInDegree);
                        str2 = ((f) g.ah(f.class)).genScanTmpImgPath("jpg");
                        BitmapUtil.saveBitmapToImage(rotate, 80, Bitmap.CompressFormat.JPEG, str2, false);
                        akVar.CHv = str2;
                    }
                    PluginScanTranslation.this.CzE.put(Integer.valueOf(toVar.dZY.dEb), akVar);
                    final long currentTimeMillis = System.currentTimeMillis();
                    PluginScanTranslation.this.CzG.put(Integer.valueOf(toVar.dZY.dEb), Long.valueOf(currentTimeMillis));
                    ((f) g.ah(f.class)).getScanCdnService().a(aMv, str2, com.tencent.mm.i.a.MediaType_IMAGE, new p.a() {
                        /* class com.tencent.mm.plugin.scanner.PluginScanTranslation.AnonymousClass4.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.scanner.util.p.a
                        public final void a(String str, p.b bVar) {
                            AppMethodBeat.i(120840);
                            if (!Util.isNullOrNil(str) && str.equals(aMv)) {
                                goVar.eJU = System.currentTimeMillis() - currentTimeMillis;
                                Log.i("MicroMsg.PluginScanTranslation", "upload img cost %d", Long.valueOf(goVar.eJU));
                                goVar.uq(bVar.fileId);
                                goVar.ur(bVar.aeskey);
                                switch (bVar.errCode) {
                                    case 0:
                                        if (!Util.isNullOrNil(bVar.fileId, bVar.aeskey)) {
                                            Log.i("MicroMsg.PluginScanTranslation", "upload img success, fileId %s", bVar.fileId);
                                            g.azz().a(new m(toVar.dZY.scene, toVar.dZY.dEb, (int) s.boW(str2), bVar.fileId, bVar.aeskey), 0);
                                            AppMethodBeat.o(120840);
                                            return;
                                        }
                                        goVar.eEt = 3;
                                        goVar.eJW = System.currentTimeMillis() - currentTimeMillis;
                                        goVar.bfK();
                                        PluginScanTranslation.this.CzF.remove(Integer.valueOf(toVar.dZY.dEb));
                                        PluginScanTranslation.this.CzG.remove(Integer.valueOf(toVar.dZY.dEb));
                                        Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()));
                                        PluginScanTranslation.access$300(PluginScanTranslation.this, toVar.dZY.dEb);
                                        AppMethodBeat.o(120840);
                                        return;
                                    case -21009:
                                    case -21000:
                                        goVar.eEt = 3;
                                        goVar.eJW = System.currentTimeMillis() - currentTimeMillis;
                                        goVar.bfK();
                                        PluginScanTranslation.this.CzF.remove(Integer.valueOf(toVar.dZY.dEb));
                                        PluginScanTranslation.this.CzG.remove(Integer.valueOf(toVar.dZY.dEb));
                                        Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", Integer.valueOf(PluginScanTranslation.this.CzF.size()), Integer.valueOf(PluginScanTranslation.this.CzG.size()));
                                        PluginScanTranslation.access$300(PluginScanTranslation.this, toVar.dZY.dEb);
                                        break;
                                }
                            }
                            AppMethodBeat.o(120840);
                        }
                    });
                    AppMethodBeat.o(120841);
                    return true;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.PluginScanTranslation", e2, "", new Object[0]);
                    PluginScanTranslation.access$300(PluginScanTranslation.this, toVar.dZY.dEb);
                }
            }
            AppMethodBeat.o(120841);
            return false;
        }
    };

    public PluginScanTranslation() {
        AppMethodBeat.i(120843);
        AppMethodBeat.o(120843);
    }

    static /* synthetic */ void access$300(PluginScanTranslation pluginScanTranslation, int i2) {
        AppMethodBeat.i(120853);
        pluginScanTranslation.sendTranslationFailEvent(i2);
        AppMethodBeat.o(120853);
    }

    static {
        AppMethodBeat.i(120855);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.scanner.PluginScanTranslation.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(120855);
    }

    public k getTranslationRender() {
        return this.CzC;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        return null;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(120844);
        EventCenter.instance.add(this.CzJ);
        EventCenter.instance.add(this.CzI);
        g.azz().a(294, this);
        s.bpc(getTranslationResultDir());
        AppMethodBeat.o(120844);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(120845);
        EventCenter.instance.removeListener(this.CzJ);
        EventCenter.instance.removeListener(this.CzI);
        g.azz().b(294, this);
        AppMethodBeat.o(120845);
    }

    public b getTranslationResultStorage() {
        AppMethodBeat.i(120846);
        g.aAf().azk();
        if (this.CzD == null) {
            this.CzD = new b(g.aAh().hqK);
        }
        b bVar = this.CzD;
        AppMethodBeat.o(120846);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.scanner.e
    public fx getTranslationResult(String str) {
        AppMethodBeat.i(120847);
        String mD5String = MD5Util.getMD5String(str + s.boX(str));
        Log.i("MicroMsg.PluginScanTranslation", "getTranslationResult %s, md5 %s", str, mD5String);
        fx aMG = getTranslationResultStorage().aMG(mD5String);
        AppMethodBeat.o(120847);
        return aMG;
    }

    private void sendTranslationFailEvent(int i2) {
        go goVar;
        AppMethodBeat.i(120848);
        tp tpVar = new tp();
        tpVar.dZZ.dEb = i2;
        tpVar.dZZ.dDz = false;
        if (this.CzE.containsKey(Integer.valueOf(i2)) && (goVar = this.CzF.get(Integer.valueOf(i2))) != null) {
            tpVar.dZZ.source = (int) goVar.eDV;
        }
        EventCenter.instance.publish(tpVar);
        this.CzE.remove(Integer.valueOf(i2));
        AppMethodBeat.o(120848);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(120849);
        Log.i("MicroMsg.PluginScanTranslation", "onSceneEnd errType %d, errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (qVar.getType() == 294) {
            int i4 = ((m) qVar).dEb;
            if (i2 == 0 && i3 == 0) {
                List<ekt> list = ((m) qVar).CFD;
                if (list != null) {
                    Log.i("MicroMsg.PluginScanTranslation", "session %d, angle %f, translationInfos length %d", Integer.valueOf(i4), Float.valueOf(((m) qVar).angle), Integer.valueOf(list.size()));
                    if (this.CzF.containsKey(Integer.valueOf(i4))) {
                        this.CzF.get(Integer.valueOf(i4)).eJV = System.currentTimeMillis() - ((m) qVar).CFE;
                    }
                    if (list.size() <= 0 || !this.CzE.containsKey(Integer.valueOf(i4))) {
                        if (this.CzF.containsKey(Integer.valueOf(i4)) && this.CzG.containsKey(Integer.valueOf(i4))) {
                            this.CzF.get(Integer.valueOf(i4)).eJW = System.currentTimeMillis() - this.CzG.get(Integer.valueOf(i4)).longValue();
                        }
                        sendTranslationFailEvent(i4);
                    } else {
                        ak akVar = this.CzE.get(Integer.valueOf(i4));
                        akVar.eab = ((ctn) ((m) qVar).rr.iLL.iLR).Myw;
                        akVar.eac = ((m) qVar).ePR();
                        akVar.brand = ((ctn) ((m) qVar).rr.iLL.iLR).Myy;
                        if (this.CzF.containsKey(Integer.valueOf(i4))) {
                            this.CzF.get(Integer.valueOf(i4)).eEt = 1;
                        }
                        k translationRender = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationRender();
                        float f2 = ((m) qVar).angle;
                        String str2 = akVar.CHv;
                        k.b bVar = this.CzH;
                        if (!(i4 == 0 || list == null || list.size() <= 0 || bVar == null)) {
                            Bitmap decodeFile = BitmapUtil.decodeFile(str2, new BitmapFactory.Options());
                            if (decodeFile == null) {
                                bVar.d(i4, null);
                                AppMethodBeat.o(120849);
                                return;
                            }
                            if (!(translationRender.CUc == 0 || i4 == translationRender.CUc)) {
                                Log.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(translationRender.CUc), Integer.valueOf(i4));
                                translationRender.eRW();
                            }
                            translationRender.CUc = i4;
                            translationRender.CUd = bVar;
                            translationRender.CUe = new k.a(i4, list, f2, decodeFile);
                            translationRender.CUe.y(new Void[0]);
                        }
                        AppMethodBeat.o(120849);
                        return;
                    }
                }
                AppMethodBeat.o(120849);
                return;
            }
            if (this.CzF.containsKey(Integer.valueOf(i4)) && this.CzG.containsKey(Integer.valueOf(i4))) {
                this.CzF.get(Integer.valueOf(i4)).eJW = System.currentTimeMillis() - this.CzG.get(Integer.valueOf(i4)).longValue();
                this.CzF.get(Integer.valueOf(i4)).eEt = 5;
                this.CzF.get(Integer.valueOf(i4)).bfK();
                this.CzF.remove(Integer.valueOf(i4));
                this.CzG.remove(Integer.valueOf(i4));
                Log.i("MicroMsg.PluginScanTranslation", "translationReports size %d, translationUpload size %d", Integer.valueOf(this.CzF.size()), Integer.valueOf(this.CzG.size()));
            }
            sendTranslationFailEvent(i4);
        }
        AppMethodBeat.o(120849);
    }

    public String getTranslationResultDir() {
        AppMethodBeat.i(120850);
        String str = ((f) g.ah(f.class)).getAccScannerPath() + "scan_result/";
        AppMethodBeat.o(120850);
        return str;
    }

    public String genTranslationResultImgPath(String str) {
        AppMethodBeat.i(120851);
        String str2 = getTranslationResultDir() + String.format("%s_%d.%s", "translation", Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(120851);
        return str2;
    }

    public String genScanTranslateBgImgPath(String str) {
        AppMethodBeat.i(120852);
        String format = String.format("%s.%s", ((f) g.ah(f.class)).getScanImageSaveDir() + "scan_translation_bg", str);
        AppMethodBeat.o(120852);
        return format;
    }
}
