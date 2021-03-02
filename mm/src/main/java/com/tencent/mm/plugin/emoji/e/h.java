package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.g;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.emoji.c.f;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private static String qZH = "";
    public static String qZI = "temp";
    private static String qZJ = "newemoji";
    public static String qZK = "panel";
    public static String qZL = "suggest";
    public static String qZM = "egg";
    private static String qZN = "search";
    public static String qZO = "suggest_word";
    private static String qZP = "emoji_anim";
    private static String qZQ = "emoji_anim_config";
    public static String qZR = "config.conf";
    private static String qZS = "emojipanel.zip";
    private static String qZT = "newemoji.zip";
    private static String qZU = "emoji_template.zip";
    private static String qZV = "emojisuggest.zip";
    private static String qZW = "egg.zip";
    private static String qZX = "suggest_word.zip";
    private static String qZY = "newemoji-config.xml";
    public static String qZZ = "emojipanel-config.xml";
    public static String raa = "emojisuggest-config.xml";
    public static String rab = "egg.xml";
    private static String rac = "word2emoji.txt";
    private static String rad = "magicemoji.wxapkg";
    private static String rae = "magicemoji.wxapkg.br";
    private static String raf = "magicemoji.json";
    private static int rag = 0;
    public static int rah = 0;
    private static int rai = 0;
    private static int raj = 0;
    private static int rak = 6;
    private static h ram;
    private final HashMap<a, f> ral = new HashMap<>();
    public g ran;

    public enum a {
        EMOJI,
        PANEL,
        SUGGEST,
        SEARCH,
        EGG,
        SUGGEST_WORD,
        EMOJI_ANIM;

        static {
            AppMethodBeat.i(108508);
            AppMethodBeat.o(108508);
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(108507);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(108507);
            return aVar;
        }
    }

    public static h cFT() {
        AppMethodBeat.i(108509);
        if (ram == null) {
            synchronized (h.class) {
                try {
                    ram = new h();
                } catch (Throwable th) {
                    AppMethodBeat.o(108509);
                    throw th;
                }
            }
        }
        h hVar = ram;
        AppMethodBeat.o(108509);
        return hVar;
    }

    public h() {
        AppMethodBeat.i(240127);
        AppMethodBeat.o(240127);
    }

    public static String getDataEmojiPath() {
        AppMethodBeat.i(108510);
        if (Util.isNullOrNil(qZH)) {
            qZH = com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data");
            qZH += "/emoji";
        }
        String str = qZH;
        AppMethodBeat.o(108510);
        return str;
    }

    public final f a(a aVar) {
        AppMethodBeat.i(240128);
        f fVar = this.ral.get(aVar);
        if (fVar == null) {
            fVar = new f();
            this.ral.put(aVar, fVar);
        }
        switch (aVar) {
            case EMOJI:
                fVar.hcm.eqd = 1;
                break;
            case PANEL:
                fVar.hcm.eqd = 2;
                break;
            case SUGGEST:
                fVar.hcm.eqd = 3;
                break;
            case EGG:
                fVar.hcm.eqd = 5;
                break;
            case SUGGEST_WORD:
                fVar.hcm.eqd = 6;
                break;
            case EMOJI_ANIM:
                fVar.hcm.eqd = 7;
                break;
        }
        AppMethodBeat.o(240128);
        return fVar;
    }

    public static boolean fV(String str, String str2) {
        AppMethodBeat.i(240129);
        o oVar = new o(str);
        if (!oVar.exists() || oVar.length() <= 0) {
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile update file don't exist.");
            AppMethodBeat.o(240129);
            return false;
        }
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "copyAndUnzipFile start. zipPath:%s filePath:%s", str, aa.z(oVar.her()));
        o oVar2 = new o(getDataEmojiPath(), str2);
        if (oVar2.exists()) {
            s.dy(aa.z(oVar2.mUri), true);
        }
        oVar2.mkdirs();
        if (fW(aa.z(oVar.her()), aa.z(oVar2.her())) >= 0) {
            AppMethodBeat.o(240129);
            return true;
        }
        AppMethodBeat.o(240129);
        return false;
    }

    public static int b(a aVar) {
        AppMethodBeat.i(240130);
        switch (aVar) {
            case EMOJI:
                int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_NEW_EMOJI_INT, (Object) 0)).intValue();
                rag = intValue;
                AppMethodBeat.o(240130);
                return intValue;
            case PANEL:
                int intValue2 = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_NEW_PANEL_INT, (Object) 0)).intValue();
                rah = intValue2;
                AppMethodBeat.o(240130);
                return intValue2;
            case SUGGEST:
                int intValue3 = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_NEW_SUGGEST_INT, (Object) 0)).intValue();
                rai = intValue3;
                AppMethodBeat.o(240130);
                return intValue3;
            case EGG:
                int intValue4 = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_EGG_INT, (Object) 0)).intValue();
                raj = intValue4;
                AppMethodBeat.o(240130);
                return intValue4;
            case SUGGEST_WORD:
            case EMOJI_ANIM:
            default:
                AppMethodBeat.o(240130);
                return -1;
            case SEARCH:
                int i2 = com.tencent.mm.aq.a.iUo;
                AppMethodBeat.o(240130);
                return i2;
        }
    }

    public static String cFN() {
        AppMethodBeat.i(108514);
        String avb = n.avb();
        if (Util.isNullOrNil(avb)) {
            avb = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EMOJI_NEW_PANEL_NAME_STRING, qZZ);
        }
        AppMethodBeat.o(108514);
        return avb;
    }

    private void O(o oVar) {
        boolean z;
        AppMethodBeat.i(240131);
        ArrayList<SmileyInfo> d2 = com.tencent.mm.emoji.e.b.d(oVar);
        f a2 = a(a.EMOJI);
        if (!d2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        a2.ef(z);
        a2.hcm.eqa = d2.size();
        a2.hcm.bfK();
        if (!d2.isEmpty() && ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().V(d2)) {
            dh dhVar = new dh();
            dhVar.dGr.subType = 1;
            EventCenter.instance.publish(dhVar);
            rag = N(new o(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZJ, qZR));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(rag));
        }
        AppMethodBeat.o(240131);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean P(com.tencent.mm.vfs.o r15) {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.h.P(com.tencent.mm.vfs.o):boolean");
    }

    public final boolean Q(o oVar) {
        AppMethodBeat.i(240133);
        try {
            g f2 = com.tencent.mm.emoji.e.b.f(oVar);
            if (f2 == null) {
                Log.e("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiEggConfig: error null");
                AppMethodBeat.o(240133);
                return false;
            }
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "parserEmojiEggConfig: %s", Integer.valueOf(f2.jgS.size()));
            this.ran = new g();
            this.ran.jgT = f2.jgT;
            Iterator<e> it = f2.jgS.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.jgP <= rak) {
                    this.ran.jgS.add(next);
                } else {
                    Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "getEggList: unsupport version %s", Integer.valueOf(next.jgP));
                }
            }
            raj = N(new o(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZM, qZR));
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(raj));
            AppMethodBeat.o(240133);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
            AppMethodBeat.o(240133);
            return false;
        }
    }

    public final void b(bp bpVar) {
        AppMethodBeat.i(240134);
        int b2 = b(a.EMOJI);
        f a2 = a(a.EMOJI);
        boolean fV = fV(bpVar.dEN.filePath, qZI);
        a2.cK(b2, N(new o(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZI, qZR)));
        a2.ee(fV);
        a2.hcm.eqa = 0;
        a2.hcm.bfK();
        if (fV) {
            s.cL(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZI, getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZJ);
            o oVar = new o(new o(getDataEmojiPath(), qZJ), qZY);
            if (oVar.exists()) {
                O(oVar);
                com.tencent.mm.pluginsdk.j.a.a.b.gnC().aP(bpVar.dEN.dEO, bpVar.dEN.subType, bpVar.dEN.dEP);
                AppMethodBeat.o(240134);
                return;
            }
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
            AppMethodBeat.o(240134);
            return;
        }
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
        AppMethodBeat.o(240134);
    }

    public static boolean c(bp bpVar) {
        AppMethodBeat.i(108519);
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.ce.b.gxI();
        long j2 = com.tencent.mm.ce.b.gxI().NKB;
        com.tencent.mm.ce.b.gxI();
        int bhZ = com.tencent.mm.ce.b.bhZ(bpVar.dEN.filePath);
        com.tencent.mm.ce.b.gxI();
        long bhY = com.tencent.mm.ce.b.bhY(bpVar.dEN.filePath);
        Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "currentSupportVersion:%d current version:%d supportVersion:%d file version:%d use time:%d", 1, Long.valueOf(j2), Integer.valueOf(bhZ), Long.valueOf(bhY), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (bhZ != 1 || bhY <= j2) {
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "need not update color emoji");
            AppMethodBeat.o(108519);
            return false;
        }
        AppMethodBeat.o(108519);
        return true;
    }

    public final boolean amD(String str) {
        AppMethodBeat.i(240135);
        f a2 = a(a.EMOJI_ANIM);
        boolean fV = fV(str, qZP);
        a2.ee(fV);
        a2.hcm.bfK();
        AppMethodBeat.o(240135);
        return fV;
    }

    public final g cFL() {
        AppMethodBeat.i(108520);
        if (this.ran == null) {
            o oVar = new o(new o(getDataEmojiPath(), qZM), rab);
            if (oVar.exists()) {
                Q(oVar);
            }
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "getEggList: from xml");
        }
        try {
            if (this.ran == null) {
                byte[] aW = s.aW(com.tencent.mm.kernel.g.aAh().cachePath + "eggingfo.ini", 0, -1);
                if (aW == null) {
                    Log.d("MicroMsg.emoji.EmojiResUpdateMgr", "data is null, parse EggList from config file fail");
                } else {
                    g gVar = (g) new g().parseFrom(aW);
                    this.ran = new g();
                    this.ran.jgT = gVar.jgT;
                    Iterator<e> it = gVar.jgS.iterator();
                    while (it.hasNext()) {
                        e next = it.next();
                        if (next.jgP <= rak) {
                            this.ran.jgS.add(next);
                        } else {
                            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "getEggList: unsupport version %s", Integer.valueOf(next.jgP));
                        }
                    }
                    Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "getEggList: from proto");
                }
            }
        } catch (Exception e2) {
            Log.w("MicroMsg.emoji.EmojiResUpdateMgr", "init crash : %s, try delete egg file", e2.getLocalizedMessage());
            Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "", new Object[0]);
        }
        g gVar2 = this.ran;
        AppMethodBeat.o(108520);
        return gVar2;
    }

    public final int aiX(String str) {
        b R;
        AppMethodBeat.i(258210);
        if (!fV(str, qZI) || (R = R(new o(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZI, raf))) == null) {
            AppMethodBeat.o(258210);
            return 0;
        }
        int i2 = R.version;
        bd VF = ((v) com.tencent.mm.kernel.g.af(v.class)).VF(R.appId);
        if (VF == null || VF.field_version < R.version) {
            String str2 = getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZI + FilePathGenerator.ANDROID_DIR_SEP + rad;
            if (!((l) com.tencent.mm.kernel.g.af(l.class)).cq(getDataEmojiPath() + FilePathGenerator.ANDROID_DIR_SEP + qZI + FilePathGenerator.ANDROID_DIR_SEP + rae, str2)) {
                Log.e("MicroMsg.emoji.EmojiResUpdateMgr", "magic emoji pkg br decompress failed");
            } else if (((v) com.tencent.mm.kernel.g.af(v.class)).s(R.appId, R.version, str2)) {
                ((com.tencent.mm.plugin.emoji.magicemoji.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFz();
                Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "insert magic emoji pkg success");
            } else {
                Log.e("MicroMsg.emoji.EmojiResUpdateMgr", "insert magic emoji pkg failed");
            }
        } else {
            Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "magic emoji version %d should bigger than %d", Integer.valueOf(R.version), Integer.valueOf(VF.field_version));
        }
        AppMethodBeat.o(258210);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public class b {
        public String appId;
        public int version;

        private b() {
        }

        /* synthetic */ b(h hVar, byte b2) {
            this();
        }
    }

    private b R(o oVar) {
        AppMethodBeat.i(240137);
        b bVar = new b(this, (byte) 0);
        if (oVar.exists()) {
            try {
                JSONObject jSONObject = new JSONObject(s.boY(aa.z(oVar.her())));
                bVar.appId = jSONObject.getString("appId");
                bVar.version = jSONObject.getInt("version");
                Log.i("MicroMsg.emoji.EmojiResUpdateMgr", "read magic emoji pkg info, appId:%s version:%d", bVar.appId, Integer.valueOf(bVar.version));
                AppMethodBeat.o(240137);
                return bVar;
            } catch (IOException | JSONException e2) {
                Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e2, "read magic emoji pkg info failed", new Object[0]);
                AppMethodBeat.o(240137);
                return null;
            }
        } else {
            AppMethodBeat.o(240137);
            return null;
        }
    }

    private static int fW(String str, String str2) {
        ZipInputStream zipInputStream;
        AppMethodBeat.i(240138);
        try {
            zipInputStream = new ZipInputStream(s.openRead(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            if (nextEntry.isDirectory()) {
                                new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                o oVar = new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name);
                                oVar.heq().mkdirs();
                                OutputStream ap = s.ap(oVar);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    ap.write(bArr, 0, read);
                                }
                                ap.close();
                            }
                        }
                    } else {
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(240138);
                        return 0;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(240138);
                        return -1;
                    } catch (Throwable th) {
                        th = th;
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(240138);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
                    aa.closeQuietly(zipInputStream);
                    AppMethodBeat.o(240138);
                    return -2;
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            zipInputStream = null;
            Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(240138);
            return -1;
        } catch (IOException e5) {
            e = e5;
            zipInputStream = null;
            Log.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateMgr", e, "", new Object[0]);
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(240138);
            return -2;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(240138);
            throw th;
        }
    }

    public static int N(o oVar) {
        AppMethodBeat.i(108512);
        int EY = com.tencent.mm.emoji.e.b.EY(aa.z(oVar.mUri));
        AppMethodBeat.o(108512);
        return EY;
    }
}
