package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.scanner.h.a;
import com.tencent.mm.plugin.scanner.h.b;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.e;
import com.tencent.mm.plugin.scanner.model.m;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.util.k;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;

public class j implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, h.b> kvw = new HashMap<>();
    private e CAA = new e();
    private s CAx = new s();
    private u CAy = new u();
    private a CAz;
    private HashMap<Integer, ak> CzE = new HashMap<>();
    private HashMap<Integer, go> CzF = new HashMap<>();
    private HashMap<Integer, Long> CzG = new HashMap<>();
    private k.b CzH = new k.b() {
        /* class com.tencent.mm.plugin.scanner.j.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.scanner.util.k.b
        public final void d(int i2, Bitmap bitmap) {
            AppMethodBeat.i(169947);
            if (j.this.CzE.containsKey(Integer.valueOf(i2))) {
                if (j.this.CzF.containsKey(Integer.valueOf(i2)) && j.this.CzG.containsKey(Integer.valueOf(i2))) {
                    ((go) j.this.CzF.get(Integer.valueOf(i2))).eJW = System.currentTimeMillis() - ((Long) j.this.CzG.get(Integer.valueOf(i2))).longValue();
                    ((go) j.this.CzF.get(Integer.valueOf(i2))).bfK();
                    j.this.CzF.remove(Integer.valueOf(i2));
                    j.this.CzG.remove(Integer.valueOf(i2));
                    Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(j.this.CzF.size()), Integer.valueOf(j.this.CzG.size()));
                }
                if (!g.aAc()) {
                    AppMethodBeat.o(169947);
                    return;
                }
                String genTranslationResultImgPath = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).genTranslationResultImgPath("jpg");
                try {
                    BitmapUtil.saveBitmapToImage(bitmap, 80, Bitmap.CompressFormat.JPEG, genTranslationResultImgPath, false);
                    aj ajVar = new aj();
                    ak akVar = (ak) j.this.CzE.get(Integer.valueOf(i2));
                    ajVar.field_originMD5 = com.tencent.mm.vfs.s.bhK(akVar.jrK + com.tencent.mm.vfs.s.boX(akVar.jrK));
                    ajVar.field_resultFile = genTranslationResultImgPath;
                    ajVar.field_fromLang = akVar.eab;
                    ajVar.field_toLang = akVar.eac;
                    ajVar.field_brand = akVar.brand;
                    Log.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", Integer.valueOf(i2), genTranslationResultImgPath);
                    ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().a(ajVar);
                    tp tpVar = new tp();
                    tpVar.dZZ.dEb = i2;
                    tpVar.dZZ.dDz = true;
                    tpVar.dZZ.eaa = genTranslationResultImgPath;
                    tpVar.dZZ.eab = akVar.eab;
                    tpVar.dZZ.eac = akVar.eac;
                    EventCenter.instance.publish(tpVar);
                    j.this.CzE.remove(Integer.valueOf(i2));
                    AppMethodBeat.o(169947);
                    return;
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e2, "save translate result file error", new Object[0]);
                    j.a(j.this, i2);
                }
            }
            AppMethodBeat.o(169947);
        }
    };
    private IListener<ay> CzI = new IListener<ay>() {
        /* class com.tencent.mm.plugin.scanner.j.AnonymousClass2 */

        {
            AppMethodBeat.i(169948);
            this.__eventId = ay.class.getName().hashCode();
            AppMethodBeat.o(169948);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ay ayVar) {
            AppMethodBeat.i(169949);
            ay ayVar2 = ayVar;
            if (ayVar2.dEa.scene != 1 || !j.this.CzE.containsKey(Integer.valueOf(ayVar2.dEa.dEb))) {
                AppMethodBeat.o(169949);
                return false;
            }
            Log.i("MicroMsg.scanner.SubCoreScanner", "cancel translate sessionId %d", Integer.valueOf(ayVar2.dEa.dEb));
            j.this.CzE.remove(Integer.valueOf(ayVar2.dEa.dEb));
            if (j.this.CzF.containsKey(Integer.valueOf(ayVar2.dEa.dEb)) && j.this.CzG.containsKey(Integer.valueOf(ayVar2.dEa.dEb))) {
                ((go) j.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).eEt = 2;
                ((go) j.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).eJW = System.currentTimeMillis() - ((Long) j.this.CzG.get(Integer.valueOf(ayVar2.dEa.dEb))).longValue();
                ((go) j.this.CzF.get(Integer.valueOf(ayVar2.dEa.dEb))).bfK();
                j.this.CzF.remove(Integer.valueOf(ayVar2.dEa.dEb));
                j.this.CzG.remove(Integer.valueOf(ayVar2.dEa.dEb));
                Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(j.this.CzF.size()), Integer.valueOf(j.this.CzG.size()));
            }
            AppMethodBeat.o(169949);
            return true;
        }
    };
    private IListener<to> CzJ = new IListener<to>() {
        /* class com.tencent.mm.plugin.scanner.j.AnonymousClass3 */

        {
            AppMethodBeat.i(169951);
            this.__eventId = to.class.getName().hashCode();
            AppMethodBeat.o(169951);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(to toVar) {
            AppMethodBeat.i(169953);
            boolean a2 = a(toVar);
            AppMethodBeat.o(169953);
            return a2;
        }

        private boolean a(final to toVar) {
            Bitmap decodeFile;
            AppMethodBeat.i(169952);
            if (toVar.dZY.scene == 1 && !Util.isNullOrNil(toVar.dZY.filePath)) {
                try {
                    Log.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", toVar.dZY.filePath, Integer.valueOf(toVar.dZY.dEb));
                    fx aMG = ((PluginScanTranslation) g.ah(PluginScanTranslation.class)).getTranslationResultStorage().aMG(com.tencent.mm.vfs.s.bhK(toVar.dZY.filePath + com.tencent.mm.vfs.s.boX(toVar.dZY.filePath)));
                    if (aMG != null) {
                        Log.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
                        String str = aMG.field_resultFile;
                        if (com.tencent.mm.vfs.s.YS(str)) {
                            tp tpVar = new tp();
                            tpVar.dZZ.dEb = toVar.dZY.dEb;
                            tpVar.dZZ.dDz = true;
                            tpVar.dZZ.eaa = str;
                            tpVar.dZZ.eab = aMG.field_fromLang;
                            tpVar.dZZ.eac = aMG.field_toLang;
                            EventCenter.instance.publish(tpVar);
                            j.this.CzE.remove(Integer.valueOf(toVar.dZY.dEb));
                            AppMethodBeat.o(169952);
                            return true;
                        }
                        Log.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
                    }
                    final go goVar = new go();
                    goVar.eDV = 4;
                    j.this.CzF.put(Integer.valueOf(toVar.dZY.dEb), goVar);
                    ak akVar = new ak();
                    akVar.jrK = toVar.dZY.filePath;
                    akVar.CHv = toVar.dZY.filePath;
                    final int orientationInDegree = Exif.fromFile(toVar.dZY.filePath).getOrientationInDegree();
                    Log.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", Integer.valueOf(orientationInDegree));
                    final String str2 = toVar.dZY.filePath;
                    final String aMv = p.aMv(toVar.dZY.filePath);
                    if (!(orientationInDegree == 0 || (decodeFile = BitmapUtil.decodeFile(toVar.dZY.filePath, new MMBitmapFactory.Options())) == null)) {
                        Bitmap rotate = BitmapUtil.rotate(decodeFile, (float) orientationInDegree);
                        j.eOR();
                        str2 = j.genScanTmpImgPath("jpg");
                        BitmapUtil.saveBitmapToImage(rotate, 80, Bitmap.CompressFormat.JPEG, str2, false);
                        akVar.CHv = str2;
                    }
                    j.this.CzE.put(Integer.valueOf(toVar.dZY.dEb), akVar);
                    final long currentTimeMillis = System.currentTimeMillis();
                    j.this.CzG.put(Integer.valueOf(toVar.dZY.dEb), Long.valueOf(currentTimeMillis));
                    ((f) g.ah(f.class)).getScanCdnService().a(aMv, str2, com.tencent.mm.i.a.MediaType_IMAGE, new p.a() {
                        /* class com.tencent.mm.plugin.scanner.j.AnonymousClass3.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.scanner.util.p.a
                        public final void a(String str, p.b bVar) {
                            AppMethodBeat.i(169950);
                            if (!Util.isNullOrNil(str) && str.equals(aMv)) {
                                goVar.eJU = System.currentTimeMillis() - currentTimeMillis;
                                Log.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", Long.valueOf(goVar.eJU));
                                goVar.uq(bVar.fileId);
                                goVar.ur(bVar.aeskey);
                                switch (bVar.errCode) {
                                    case -21009:
                                    case -21000:
                                        goVar.eEt = 3;
                                        goVar.eJW = System.currentTimeMillis() - currentTimeMillis;
                                        goVar.bfK();
                                        j.this.CzF.remove(Integer.valueOf(toVar.dZY.dEb));
                                        j.this.CzG.remove(Integer.valueOf(toVar.dZY.dEb));
                                        Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(j.this.CzF.size()), Integer.valueOf(j.this.CzG.size()));
                                        j.a(j.this, toVar.dZY.dEb);
                                        break;
                                    case 0:
                                        if (Util.isNullOrNil(bVar.fileId, bVar.aeskey)) {
                                            goVar.eEt = 3;
                                            goVar.eJW = System.currentTimeMillis() - currentTimeMillis;
                                            goVar.bfK();
                                            j.this.CzF.remove(Integer.valueOf(toVar.dZY.dEb));
                                            j.this.CzG.remove(Integer.valueOf(toVar.dZY.dEb));
                                            Log.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(j.this.CzF.size()), Integer.valueOf(j.this.CzG.size()));
                                            j.a(j.this, toVar.dZY.dEb);
                                            break;
                                        } else {
                                            Log.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", bVar.fileId);
                                            g.azz().a(new m(toVar.dZY.dEb, (int) com.tencent.mm.vfs.s.boW(str2), bVar.fileId, bVar.aeskey), 0);
                                            break;
                                        }
                                }
                                if (orientationInDegree != 0) {
                                    Log.i("delete tmp path %s", str2);
                                    com.tencent.mm.vfs.s.deleteFile(str2);
                                }
                            }
                            AppMethodBeat.o(169950);
                        }
                    });
                    AppMethodBeat.o(169952);
                    return true;
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e2, "", new Object[0]);
                    j.a(j.this, toVar.dZY.dEb);
                }
            }
            AppMethodBeat.o(169952);
            return false;
        }
    };
    public String hqG;
    private r.a kvx;

    public j() {
        AppMethodBeat.i(51562);
        AppMethodBeat.o(51562);
    }

    static {
        AppMethodBeat.i(51571);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.scanner.j.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return a.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("scan_translation_result_table".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.scanner.j.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.SQL_CREATE;
            }
        });
        AppMethodBeat.o(51571);
    }

    public static synchronized j eOR() {
        j jVar;
        synchronized (j.class) {
            AppMethodBeat.i(51563);
            jVar = (j) y.at(j.class);
            AppMethodBeat.o(51563);
        }
        return jVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(51564);
        EventCenter.instance.removeListener(this.CAx);
        EventCenter.instance.removeListener(this.CAy.CFM);
        EventCenter.instance.removeListener(this.CAy.CFN);
        e eVar = this.CAA;
        EventCenter.instance.removeListener(eVar.CFv);
        EventCenter.instance.removeListener(eVar.CFw);
        EventCenter.instance.removeListener(eVar.CFx);
        eVar.ePN();
        if (this.kvx != null) {
            this.kvx.uS(hashCode());
            this.kvx = null;
        }
        this.hqG = "";
        com.tencent.mm.plugin.scanner.util.b bVar = com.tencent.mm.plugin.scanner.util.b.CTi;
        com.tencent.mm.plugin.scanner.util.b.release();
        AppMethodBeat.o(51564);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(51565);
        this.kvx = r.a(hashCode(), g.aAh().cachePath + "CommonOneMicroMsg.db", kvw, false);
        e eVar = this.CAA;
        EventCenter.instance.addListener(eVar.CFv);
        EventCenter.instance.addListener(eVar.CFw);
        EventCenter.instance.addListener(eVar.CFx);
        EventCenter.instance.addListener(this.CAx);
        EventCenter.instance.addListener(this.CAy.CFM);
        EventCenter.instance.addListener(this.CAy.CFN);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.scanner.j.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(169954);
                if (!g.aAc()) {
                    AppMethodBeat.o(169954);
                } else if (Util.isNullOrNil(j.this.hqG)) {
                    Log.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                    AppMethodBeat.o(169954);
                } else {
                    Util.deleteOutOfDateFile(j.this.hqG + "image/scan/img", "scanbook", 604800000);
                    AppMethodBeat.o(169954);
                }
            }

            public final String toString() {
                AppMethodBeat.i(169955);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(169955);
                return str;
            }
        }, "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
        com.tencent.mm.plugin.scanner.util.b bVar = com.tencent.mm.plugin.scanner.util.b.CTi;
        com.tencent.mm.plugin.scanner.util.b.init();
        AppMethodBeat.o(51565);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
        AppMethodBeat.i(51566);
        Log.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + g.aAh().hqG);
        String str = g.aAh().hqG;
        Log.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(str)));
        this.hqG = str;
        o oVar = new o(str);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        o oVar2 = new o(str + "image/scan/img");
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        o oVar3 = new o(str + "image/scan/music");
        if (!oVar3.exists()) {
            oVar3.mkdirs();
        }
        o oVar4 = new o(getAccScannerPath());
        if (!oVar4.exists()) {
            oVar4.mkdirs();
        }
        eOR();
        com.tencent.mm.vfs.s.bpc(getScanImageSaveDir());
        AppMethodBeat.o(51566);
    }

    public final String jP(String str, String str2) {
        AppMethodBeat.i(51567);
        if (!g.aAc() || Util.isNullOrNil(str)) {
            AppMethodBeat.o(51567);
            return "";
        }
        String format = String.format("%s/scanbook%s_%s", this.hqG + "image/scan/img", str2, com.tencent.mm.b.g.getMessageDigest(str.getBytes()));
        AppMethodBeat.o(51567);
        return format;
    }

    public static String getAccScannerPath() {
        AppMethodBeat.i(51568);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("scanner/").toString();
        AppMethodBeat.o(51568);
        return sb2;
    }

    public static String getScanImageSaveDir() {
        AppMethodBeat.i(51569);
        String str = getAccScannerPath() + "scan_camera/";
        AppMethodBeat.o(51569);
        return str;
    }

    public static String genScanTmpImgPath(String str) {
        AppMethodBeat.i(169956);
        String str2 = getScanImageSaveDir() + String.format("%s_%d.%s", "tmp", Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(169956);
        return str2;
    }

    public final a eOS() {
        AppMethodBeat.i(51570);
        g.aAf().azk();
        if (this.CAz == null) {
            this.CAz = new a(g.aAh().hqK);
        }
        a aVar = this.CAz;
        AppMethodBeat.o(51570);
        return aVar;
    }

    static /* synthetic */ void a(j jVar, int i2) {
        AppMethodBeat.i(169957);
        tp tpVar = new tp();
        tpVar.dZZ.dEb = i2;
        if (jVar.CzE.containsKey(Integer.valueOf(i2))) {
            tpVar.dZZ.source = (int) jVar.CzF.get(Integer.valueOf(i2)).eDV;
        }
        tpVar.dZZ.dDz = false;
        EventCenter.instance.publish(tpVar);
        jVar.CzE.remove(Integer.valueOf(i2));
        AppMethodBeat.o(169957);
    }
}
