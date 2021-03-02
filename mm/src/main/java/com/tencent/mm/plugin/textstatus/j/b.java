package com.tencent.mm.plugin.textstatus.j;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import kotlin.k.j;
import kotlin.x;

public final class b {
    private static HashMap<String, C1825b> GfV = new HashMap<>();
    private static c GfW;
    private static final Map<String, Bitmap> GfX = new LinkedHashMap();
    private static final Map<String, Bitmap> GfY = new LinkedHashMap();
    public static final b GfZ = new b();
    private static final IListener<lx> Vfp = new g();
    private static final Object lock = new Object();
    private static final IListener<bp> qxe = new d();

    static {
        Integer num;
        Integer num2 = null;
        AppMethodBeat.i(216693);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        a aVar = a.GfU;
        String sb2 = sb.append(a.fwG()).append("/TextStateIconConfig.xml").toString();
        if (!new o(sb2).exists()) {
            a aVar2 = a.GfU;
            s.deleteDir(a.fwG());
            a aVar3 = a.GfU;
            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "unzip file from assets, result:".concat(String.valueOf(n.a(new ZipInputStream(MMApplicationContext.getContext().getAssets().open("TextState.zip")), new o(a.fwG()).getAbsolutePath()))));
        }
        if (new o(sb2).exists()) {
            String boY = s.boY(new o(sb2).getAbsolutePath());
            Map<String, String> parseXml = XmlParser.parseXml(boY, "textStateResource", "");
            if (parseXml == null) {
                Log.e("MicroMsg.TxtStatus.StatusIconHelper", "xmlMap is null, xml:" + Util.secPrint(boY));
                a aVar4 = a.GfU;
                s.deleteDir(a.fwG());
                p.VcB = false;
                a aVar5 = a.GfU;
                MultiProcessMMKV kv = a.getKV();
                if (kv != null) {
                    kv.putString("key_icon_res_version", "");
                }
                a aVar6 = a.GfU;
                MultiProcessMMKV kv2 = a.getKV();
                if (kv2 != null) {
                    kv2.putString("key_icon_res_md5", "");
                }
            } else {
                c cVar = new c(parseXml);
                a(cVar);
                GfW = cVar;
                a aVar7 = a.GfU;
                MultiProcessMMKV kv3 = a.getKV();
                if (kv3 != null) {
                    c cVar2 = GfW;
                    if (cVar2 != null) {
                        num = Integer.valueOf(cVar2.version);
                    } else {
                        num = null;
                    }
                    kv3.putString("key_icon_res_version", String.valueOf(num));
                }
                StringBuilder sb3 = new StringBuilder("load version:");
                c cVar3 = GfW;
                if (cVar3 != null) {
                    num2 = Integer.valueOf(cVar3.version);
                }
                Log.i("MicroMsg.TxtStatus.StatusIconHelper", sb3.append(num2).toString());
            }
            h.RTc.aX(AnonymousClass1.Vfq);
        } else {
            Log.e("MicroMsg.TxtStatus.StatusIconHelper", "configPath no exist");
        }
        qxe.alive();
        Vfp.alive();
        com.tencent.mm.pluginsdk.j.a.a.b.gnC();
        com.tencent.mm.pluginsdk.j.a.a.b.ahP(86);
        Log.i("MicroMsg.TxtStatus.StatusIconHelper", "init time " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(216693);
    }

    private b() {
    }

    public static final class d extends IListener<bp> {
        d() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(216687);
            boolean a2 = a(bpVar);
            AppMethodBeat.o(216687);
            return a2;
        }

        private static boolean a(bp bpVar) {
            String str;
            AppMethodBeat.i(216686);
            kotlin.g.b.p.h(bpVar, "event");
            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent callback");
            if (bpVar.dEN.dEO == 86) {
                b bVar = b.GfZ;
                synchronized (b.lock) {
                    try {
                        Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", Integer.valueOf(bpVar.dEN.dEO), Integer.valueOf(bpVar.dEN.subType), bpVar.dEN.dER, Integer.valueOf(bpVar.dEN.dEP));
                        if (bpVar.dEN.subType == 1) {
                            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_ICON");
                            a aVar = a.GfU;
                            MultiProcessMMKV kv = a.getKV();
                            if (kv == null || (str = kv.getString("key_icon_res_md5", "")) == null) {
                                str = "";
                            }
                            kotlin.g.b.p.g(str, "PathProvider.getKV()?.ge…Y_ICON_RES_MD5, \"\") ?: \"\"");
                            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent lastMd5:" + str + " curMd5:" + s.bhK(bpVar.dEN.filePath));
                            b bVar2 = b.GfZ;
                            String str2 = bpVar.dEN.filePath;
                            kotlin.g.b.p.g(str2, "event.data.filePath");
                            if (!b.byv(str2)) {
                                Log.e("MicroMsg.TxtStatus.StatusIconHelper", "update fail");
                            }
                        }
                        x xVar = x.SXb;
                    } finally {
                        AppMethodBeat.o(216686);
                    }
                }
            }
            return false;
        }
    }

    public static final class g extends IListener<lx> {
        g() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lx lxVar) {
            AppMethodBeat.i(258528);
            boolean a2 = a(lxVar);
            AppMethodBeat.o(258528);
            return a2;
        }

        private static boolean a(lx lxVar) {
            String str;
            AppMethodBeat.i(258527);
            if (lxVar != null) {
                Log.i("MicroMsg.TxtStatus.StatusIconHelper", "LocalCheckResUpdateCacheFileEvent callback");
                if (lxVar.dRu.dEO == 86) {
                    b bVar = b.GfZ;
                    synchronized (b.lock) {
                        try {
                            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "LocalCheckResUpdateCacheFileEvent resTyep:%s subType:%s fileVersion:%s", Integer.valueOf(lxVar.dRu.dEO), Integer.valueOf(lxVar.dRu.subType), Integer.valueOf(lxVar.dRu.dEP));
                            if (lxVar.dRu.subType == 1) {
                                Log.i("MicroMsg.TxtStatus.StatusIconHelper", "LocalCheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_ICON");
                                a aVar = a.GfU;
                                MultiProcessMMKV kv = a.getKV();
                                if (kv == null || (str = kv.getString("key_icon_res_md5", "")) == null) {
                                    str = "";
                                }
                                kotlin.g.b.p.g(str, "PathProvider.getKV()?.ge…Y_ICON_RES_MD5, \"\") ?: \"\"");
                                Log.i("MicroMsg.TxtStatus.StatusIconHelper", "LocalCheckResUpdateCacheFileEvent lastMd5:" + str + " curMd5:" + s.bhK(lxVar.dRu.filePath));
                                b bVar2 = b.GfZ;
                                String str2 = lxVar.dRu.filePath;
                                kotlin.g.b.p.g(str2, "event.data.filePath");
                                if (!b.byv(str2)) {
                                    Log.e("MicroMsg.TxtStatus.StatusIconHelper", "update fail");
                                }
                            }
                            x xVar = x.SXb;
                        } finally {
                            AppMethodBeat.o(258527);
                        }
                    }
                }
            }
            return false;
        }
    }

    public static final class c {
        List<C1825b> Ggf;
        List<a> lgE = new LinkedList();
        int version;

        public c(Map<String, String> map) {
            int i2 = 1;
            kotlin.g.b.p.h(map, "xmlMap");
            AppMethodBeat.i(216684);
            this.version = Util.safeParseInt(map.get(".textStateResource.version"));
            String str = ".textStateResource.categoryArray.categoryItem";
            int i3 = 1;
            while (map.get(str) != null) {
                a aVar = new a(str, map);
                str = ".textStateResource.categoryArray.categoryItem" + i3;
                i3++;
                this.lgE.add(aVar);
            }
            this.Ggf = new LinkedList();
            String str2 = ".textStateResource.otherIcons.iconArray.iconItem";
            while (map.get(str2) != null) {
                C1825b bVar = new C1825b(str2, map);
                String str3 = ".textStateResource.otherIcons.iconArray.iconItem" + i2;
                i2++;
                this.Ggf.add(bVar);
                b bVar2 = b.GfZ;
                b.GfV.put(bVar.Ggc, bVar);
                str2 = str3;
            }
            AppMethodBeat.o(216684);
        }
    }

    public static final class a {
        final Map<String, String> Ggb = new HashMap();
        List<C1825b> iHf = new LinkedList();
        String id;

        public a(String str, Map<String, String> map) {
            kotlin.g.b.p.h(str, "prefix");
            kotlin.g.b.p.h(map, "xmlMap");
            AppMethodBeat.i(216681);
            String safeFormatString = Util.safeFormatString(Util.nullAs(map.get(str + ".$categoryId"), ""), "");
            kotlin.g.b.p.g(safeFormatString, "Util.safeFormatString(Ut…x.\\$categoryId\"], \"\"),\"\")");
            this.id = safeFormatString;
            String str2 = str + ".iconArray.iconItem";
            String str3 = str2;
            int i2 = 1;
            while (map.get(str3) != null) {
                C1825b bVar = new C1825b(str3, map);
                String str4 = str2 + i2;
                i2++;
                this.iHf.add(bVar);
                b bVar2 = b.GfZ;
                b.GfV.put(bVar.Ggc, bVar);
                str3 = str4;
            }
            Map<String, String> map2 = this.Ggb;
            String safeFormatString2 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_CN"), ""), "");
            kotlin.g.b.p.g(safeFormatString2, "Util.safeFormatString(Ut…cription.zh_CN\"],\"\"), \"\")");
            map2.put(LocaleUtil.CHINA, safeFormatString2);
            Map<String, String> map3 = this.Ggb;
            String safeFormatString3 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.en"), ""), "");
            kotlin.g.b.p.g(safeFormatString3, "Util.safeFormatString(Ut…description.en\"],\"\"), \"\")");
            map3.put(LocaleUtil.ENGLISH, safeFormatString3);
            Map<String, String> map4 = this.Ggb;
            String safeFormatString4 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_HK"), ""), "");
            kotlin.g.b.p.g(safeFormatString4, "Util.safeFormatString(Ut…cription.zh_HK\"],\"\"), \"\")");
            map4.put(LocaleUtil.HONGKONG, safeFormatString4);
            Map<String, String> map5 = this.Ggb;
            String safeFormatString5 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_TW"), ""), "");
            kotlin.g.b.p.g(safeFormatString5, "Util.safeFormatString(Ut…cription.zh_TW\"],\"\"), \"\")");
            map5.put(LocaleUtil.TAIWAN, safeFormatString5);
            AppMethodBeat.o(216681);
        }
    }

    /* renamed from: com.tencent.mm.plugin.textstatus.j.b$b */
    public static final class C1825b {
        private Map<String, String> Ggb = new HashMap();
        public String Ggc;
        long Ggd;
        String Gge;
        int Vfr;
        String Vfs;
        private Map<String, String> Vft = new HashMap();
        e Vfu;
        private long cWb;

        public C1825b(String str, Map<String, String> map) {
            kotlin.g.b.p.h(str, "prefix");
            kotlin.g.b.p.h(map, "xmlMap");
            AppMethodBeat.i(216683);
            String safeFormatString = Util.safeFormatString(Util.nullAs(map.get(str + ".$iconId"), ""), "");
            kotlin.g.b.p.g(safeFormatString, "Util.safeFormatString(Ut…efix.\\$iconId\"], \"\"), \"\")");
            this.Ggc = safeFormatString;
            this.Ggd = Util.safeParseLong(map.get(str + ".effectTime"));
            this.cWb = Util.safeParseLong(map.get(str + ".expireTime"));
            String safeFormatString2 = Util.safeFormatString(Util.nullAs(map.get(str + ".useOriginalImage"), ""), "");
            kotlin.g.b.p.g(safeFormatString2, "Util.safeFormatString(Ut…OriginalImage\"], \"\"), \"\")");
            this.Gge = safeFormatString2;
            this.Vfr = Util.safeParseInt(Util.nullAs(map.get(str + ".residentAfterPublish"), ""));
            String safeFormatString3 = Util.safeFormatString(Util.nullAs(map.get(str + ".residentCategoryId"), ""), "");
            kotlin.g.b.p.g(safeFormatString3, "Util.safeFormatString(Ut…entCategoryId\"], \"\"), \"\")");
            this.Vfs = safeFormatString3;
            this.Vfu = new e(str + ".styleArray", map);
            Map<String, String> map2 = this.Ggb;
            String safeFormatString4 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_CN"), ""), "");
            kotlin.g.b.p.g(safeFormatString4, "Util.safeFormatString(Ut…ription.zh_CN\"], \"\"), \"\")");
            map2.put(LocaleUtil.CHINA, safeFormatString4);
            Map<String, String> map3 = this.Ggb;
            String safeFormatString5 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.en"), ""), "");
            kotlin.g.b.p.g(safeFormatString5, "Util.safeFormatString(Ut…escription.en\"], \"\"), \"\")");
            map3.put(LocaleUtil.ENGLISH, safeFormatString5);
            Map<String, String> map4 = this.Ggb;
            String safeFormatString6 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_HK"), ""), "");
            kotlin.g.b.p.g(safeFormatString6, "Util.safeFormatString(Ut…ription.zh_HK\"], \"\"), \"\")");
            map4.put(LocaleUtil.HONGKONG, safeFormatString6);
            Map<String, String> map5 = this.Ggb;
            String safeFormatString7 = Util.safeFormatString(Util.nullAs(map.get(str + ".description.zh_TW"), ""), "");
            kotlin.g.b.p.g(safeFormatString7, "Util.safeFormatString(Ut…ription.zh_TW\"], \"\"), \"\")");
            map5.put(LocaleUtil.TAIWAN, safeFormatString7);
            Map<String, String> map6 = this.Vft;
            String safeFormatString8 = Util.safeFormatString(Util.nullAs(map.get(str + ".sameFriendsTip.zh_CN"), ""), "");
            kotlin.g.b.p.g(safeFormatString8, "Util.safeFormatString(Ut…endsTip.zh_CN\"], \"\"), \"\")");
            map6.put(LocaleUtil.CHINA, safeFormatString8);
            Map<String, String> map7 = this.Vft;
            String safeFormatString9 = Util.safeFormatString(Util.nullAs(map.get(str + ".sameFriendsTip.en"), ""), "");
            kotlin.g.b.p.g(safeFormatString9, "Util.safeFormatString(Ut…FriendsTip.en\"], \"\"), \"\")");
            map7.put(LocaleUtil.ENGLISH, safeFormatString9);
            Map<String, String> map8 = this.Vft;
            String safeFormatString10 = Util.safeFormatString(Util.nullAs(map.get(str + ".sameFriendsTip.zh_HK"), ""), "");
            kotlin.g.b.p.g(safeFormatString10, "Util.safeFormatString(Ut…endsTip.zh_HK\"], \"\"), \"\")");
            map8.put(LocaleUtil.HONGKONG, safeFormatString10);
            Map<String, String> map9 = this.Vft;
            String safeFormatString11 = Util.safeFormatString(Util.nullAs(map.get(str + ".sameFriendsTip.zh_TW"), ""), "");
            kotlin.g.b.p.g(safeFormatString11, "Util.safeFormatString(Ut…endsTip.zh_TW\"], \"\"), \"\")");
            map9.put(LocaleUtil.TAIWAN, safeFormatString11);
            AppMethodBeat.o(216683);
        }

        public final String fwJ() {
            AppMethodBeat.i(216682);
            if (kotlin.g.b.p.j(this.Ggc, "custom")) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                String a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_CUSTOM_STATUS_NAME_STRING, "");
                String str = a2;
                if (!(str == null || str.length() == 0)) {
                    AppMethodBeat.o(216682);
                    return a2;
                }
            }
            String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.CHINA)) {
                String str2 = this.Ggb.get(currentLanguage);
                AppMethodBeat.o(216682);
                return str2;
            } else if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.HONGKONG)) {
                String str3 = this.Ggb.get(currentLanguage);
                AppMethodBeat.o(216682);
                return str3;
            } else if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.TAIWAN)) {
                String str4 = this.Ggb.get(currentLanguage);
                AppMethodBeat.o(216682);
                return str4;
            } else {
                String str5 = this.Ggb.get(LocaleUtil.ENGLISH);
                AppMethodBeat.o(216682);
                return str5;
            }
        }

        public final boolean hXA() {
            AppMethodBeat.i(258524);
            long aM = j.aM(this.Ggd, 0);
            long j2 = (this.cWb <= 0 || this.cWb <= this.Ggd) ? MAlarmHandler.NEXT_FIRE_INTERVAL : this.cWb;
            long aWB = (long) cl.aWB();
            if (aM <= aWB && j2 >= aWB) {
                AppMethodBeat.o(258524);
                return true;
            }
            AppMethodBeat.o(258524);
            return false;
        }
    }

    public static final class e {
        List<f> iHf = new LinkedList();

        public e(String str, Map<String, String> map) {
            kotlin.g.b.p.h(str, "prefix");
            kotlin.g.b.p.h(map, "xmlMap");
            AppMethodBeat.i(258525);
            int i2 = 1;
            String str2 = str + ".styleItem";
            while (map.get(str2) != null) {
                f fVar = new f(str2, map);
                str2 = str + i2;
                i2++;
                this.iHf.add(fVar);
            }
            AppMethodBeat.o(258525);
        }
    }

    public static final class f {
        long beginTime;
        long endTime;
        int lYF;

        public f(String str, Map<String, String> map) {
            kotlin.g.b.p.h(str, "prefix");
            kotlin.g.b.p.h(map, "xmlMap");
            AppMethodBeat.i(258526);
            this.lYF = Util.safeParseInt(Util.nullAs(map.get(str + ".$styleId"), ""));
            this.beginTime = Util.safeParseLong(map.get(str + ".beginTime"));
            this.endTime = Util.safeParseLong(map.get(str + ".endTime"));
            AppMethodBeat.o(258526);
        }
    }

    public static /* synthetic */ Drawable a(String str, a.c cVar, a.EnumC1808a aVar, int i2) {
        AppMethodBeat.i(216689);
        if ((i2 & 2) != 0) {
            cVar = a.c.FILLED;
        }
        if ((i2 & 4) != 0) {
            aVar = a.EnumC1808a.DEFAULT;
        }
        Drawable a2 = a(str, cVar, aVar);
        AppMethodBeat.o(216689);
        return a2;
    }

    public static Drawable a(String str, a.c cVar, a.EnumC1808a aVar) {
        boolean z;
        Bitmap bitmap;
        Bitmap bitmap2;
        String str2;
        String str3;
        int color;
        boolean z2;
        AppMethodBeat.i(216688);
        kotlin.g.b.p.h(cVar, "iconType");
        kotlin.g.b.p.h(aVar, "iconColor");
        if (str != null) {
            if (!(str.length() > 0)) {
                str = null;
            }
            if (str != null) {
                String.valueOf(str);
                C1825b bVar = GfV.get(str);
                if (bVar != null) {
                    long aM = j.aM(bVar.Ggd, 0);
                    long aWB = (long) cl.aWB();
                    if (aM <= aWB && MAlarmHandler.NEXT_FIRE_INTERVAL >= aWB) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        String str4 = bVar.Ggc;
                        for (T t : bVar.Vfu.iHf) {
                            long aM2 = j.aM(t.beginTime, 0);
                            long j2 = (t.endTime <= 0 || t.endTime <= t.beginTime) ? MAlarmHandler.NEXT_FIRE_INTERVAL : t.endTime;
                            long aWB2 = (long) cl.aWB();
                            if (aM2 <= aWB2 && j2 >= aWB2) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                str4 = str4 + '_' + t.lYF;
                            }
                        }
                        switch (c.uqL[cVar.ordinal()]) {
                            case 1:
                                bitmap = GfX.get(str4);
                                break;
                            default:
                                bitmap = GfY.get(str4);
                                break;
                        }
                        if (bitmap == null || bitmap.isRecycled()) {
                            a aVar2 = a.GfU;
                            o oVar = new o(String.valueOf(a.fwG()));
                            if (TextUtils.isEmpty(str4) || !oVar.exists()) {
                                bitmap2 = bitmap;
                            } else {
                                switch (c.vke[cVar.ordinal()]) {
                                    case 1:
                                        str2 = "_outlined";
                                        break;
                                    default:
                                        str2 = "_filled";
                                        break;
                                }
                                Bitmap decodeFile = BitmapUtil.decodeFile(new o(oVar, str4 + str2 + ".png").getAbsolutePath(), null);
                                if (decodeFile != null) {
                                    decodeFile.setDensity(320);
                                    if (cVar == a.c.FILLED) {
                                        GfX.put(str4, decodeFile);
                                        bitmap2 = decodeFile;
                                    } else {
                                        GfY.put(str4, decodeFile);
                                        bitmap2 = decodeFile;
                                    }
                                } else {
                                    bitmap2 = decodeFile;
                                }
                            }
                        } else {
                            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "cache icon ".concat(String.valueOf(str4)));
                            bitmap2 = bitmap;
                        }
                        if (bitmap2 != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap2);
                            C1825b bVar2 = GfV.get(str);
                            if (bVar2 != null) {
                                str3 = bVar2.Gge;
                            } else {
                                str3 = null;
                            }
                            if (Util.isEqual(str3, "1")) {
                                AppMethodBeat.o(216688);
                                return bitmapDrawable;
                            }
                            switch (c.haE[cVar.ordinal()]) {
                                case 1:
                                    switch (c.$EnumSwitchMapping$0[aVar.ordinal()]) {
                                        case 1:
                                            color = -1;
                                            break;
                                        case 2:
                                            color = MMApplicationContext.getResources().getColor(R.color.BW_0_Alpha_0_2);
                                            break;
                                        default:
                                            color = MMApplicationContext.getResources().getColor(R.color.aj);
                                            break;
                                    }
                                    int alpha = Color.alpha(color);
                                    if (alpha != 0) {
                                        bitmapDrawable.setAlpha(alpha);
                                    }
                                    Drawable e2 = com.tencent.mm.ui.ar.e(bitmapDrawable, color);
                                    kotlin.g.b.p.g(e2, "WeUIColorHelper.getColorDrawable(drawable, color)");
                                    AppMethodBeat.o(216688);
                                    return e2;
                                default:
                                    Drawable e3 = com.tencent.mm.ui.ar.e(bitmapDrawable, MMApplicationContext.getResources().getColor(R.color.am));
                                    kotlin.g.b.p.g(e3, "WeUIColorHelper.getColor….getColor(R.color.White))");
                                    AppMethodBeat.o(216688);
                                    return e3;
                            }
                        } else {
                            AppMethodBeat.o(216688);
                            return null;
                        }
                    } else {
                        AppMethodBeat.o(216688);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(216688);
                    return null;
                }
            }
        }
        AppMethodBeat.o(216688);
        return null;
    }

    public static String getName(String str) {
        AppMethodBeat.i(216690);
        C1825b bVar = GfV.get(str);
        if (bVar != null) {
            String fwJ = bVar.fwJ();
            AppMethodBeat.o(216690);
            return fwJ;
        }
        AppMethodBeat.o(216690);
        return null;
    }

    public static String a(w wVar) {
        AppMethodBeat.i(258529);
        kotlin.g.b.p.h(wVar, "topicInfo");
        if (kotlin.g.b.p.j(wVar.Gan, "custom")) {
            String str = wVar.title;
            AppMethodBeat.o(258529);
            return str;
        }
        String name = getName(wVar.Gan);
        AppMethodBeat.o(258529);
        return name;
    }

    public static ArrayList<com.tencent.mm.view.recyclerview.a> getDataList() {
        String str;
        AppMethodBeat.i(258530);
        ArrayList<com.tencent.mm.view.recyclerview.a> arrayList = new ArrayList<>();
        arrayList.add(new com.tencent.mm.plugin.textstatus.f.e.b(MMApplicationContext.getContext().getString(R.string.hnl)));
        c cVar = GfW;
        if (cVar != null) {
            for (a aVar : cVar.lgE) {
                LinkedList linkedList = new LinkedList();
                for (C1825b bVar : aVar.iHf) {
                    if (bVar.hXA()) {
                        linkedList.add(bVar);
                    }
                }
                if (linkedList.size() > 0) {
                    String currentLanguage = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
                    if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.CHINA)) {
                        str = aVar.Ggb.get(currentLanguage);
                    } else if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.HONGKONG)) {
                        str = aVar.Ggb.get(currentLanguage);
                    } else if (kotlin.g.b.p.j(currentLanguage, LocaleUtil.TAIWAN)) {
                        str = aVar.Ggb.get(currentLanguage);
                    } else {
                        str = aVar.Ggb.get(LocaleUtil.ENGLISH);
                    }
                    arrayList.add(new com.tencent.mm.plugin.textstatus.f.e.a(str));
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        C1825b bVar2 = (C1825b) it.next();
                        String fwJ = bVar2.fwJ();
                        kotlin.g.b.p.g(bVar2, "iconItem");
                        arrayList.add(new com.tencent.mm.plugin.textstatus.f.e.c(fwJ, bVar2));
                    }
                }
            }
        }
        AppMethodBeat.o(258530);
        return arrayList;
    }

    public static String aTp(String str) {
        AppMethodBeat.i(216691);
        kotlin.g.b.p.h(str, "iconId");
        Iterator<com.tencent.mm.view.recyclerview.a> it = getDataList().iterator();
        while (it.hasNext()) {
            com.tencent.mm.view.recyclerview.a next = it.next();
            if ((next instanceof com.tencent.mm.plugin.textstatus.f.e.c) && kotlin.g.b.p.j(((com.tencent.mm.plugin.textstatus.f.e.c) next).VdG.Ggc, str)) {
                String valueOf = String.valueOf(((com.tencent.mm.plugin.textstatus.f.e.c) next).name);
                AppMethodBeat.o(216691);
                return valueOf;
            }
        }
        AppMethodBeat.o(216691);
        return "";
    }

    public static void byt(String str) {
        AppMethodBeat.i(258532);
        kotlin.g.b.p.h(str, "iconId");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        String a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_RESIDENT_CONFIG_STRING, "");
        String str2 = "<" + str + ":1>";
        kotlin.g.b.p.g(a2, "residentConfig");
        if (kotlin.n.n.e(a2, str2)) {
            AppMethodBeat.o(258532);
            return;
        }
        String str3 = a2 + str2;
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_TEXT_STATUS_RESIDENT_CONFIG_STRING, str3);
        c cVar = GfW;
        if (cVar != null) {
            a(cVar);
            AppMethodBeat.o(258532);
            return;
        }
        AppMethodBeat.o(258532);
    }

    public static String hXz() {
        AppMethodBeat.i(258533);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        String a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_CUSTOM_STATUS_NAME_STRING, "");
        kotlin.g.b.p.g(a2, "MMKernel.storage().confi…M_STATUS_NAME_STRING, \"\")");
        AppMethodBeat.o(258533);
        return a2;
    }

    public static void byu(String str) {
        AppMethodBeat.i(258534);
        kotlin.g.b.p.h(str, "name");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_TEXT_STATUS_CUSTOM_STATUS_NAME_STRING, str);
        AppMethodBeat.o(258534);
    }

    private static void a(c cVar) {
        AppMethodBeat.i(258531);
        for (T t : cVar.Ggf) {
            if (t.Vfr == 1) {
                String str = t.Ggc;
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                String a2 = aAh.azQ().a(ar.a.USERINFO_TEXT_STATUS_RESIDENT_CONFIG_STRING, "");
                String str2 = "<" + str + ":1>";
                kotlin.g.b.p.g(a2, "residentConfig");
                if (kotlin.n.n.e(a2, str2) && t.hXA()) {
                    Iterator<T> it = cVar.lgE.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (kotlin.g.b.p.j(next.id, t.Vfs)) {
                            next.iHf.add(t);
                            break;
                        }
                    }
                }
            }
        }
        AppMethodBeat.o(258531);
    }

    public static final /* synthetic */ boolean byv(String str) {
        Integer num = null;
        AppMethodBeat.i(258535);
        a aVar = a.GfU;
        boolean deleteDir = s.deleteDir(a.fwG());
        a aVar2 = a.GfU;
        int a2 = n.a(new ZipInputStream(s.openRead(str)), new o(a.fwG()).getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        a aVar3 = a.GfU;
        String sb2 = sb.append(a.fwG()).append("/TextStateIconConfig.xml").toString();
        if (s.YS(sb2)) {
            String boY = s.boY(new o(sb2).getAbsolutePath());
            Map<String, String> parseXml = XmlParser.parseXml(boY, "textStateResource", "");
            if (parseXml == null) {
                Log.e("MicroMsg.TxtStatus.StatusIconHelper", "handleUpdate: xmlMap is null, xml:" + Util.secPrint(boY));
                a aVar4 = a.GfU;
                s.deleteDir(a.fwG());
                p.VcB = false;
                a aVar5 = a.GfU;
                MultiProcessMMKV kv = a.getKV();
                if (kv != null) {
                    kv.putString("key_icon_res_version", "");
                }
                a aVar6 = a.GfU;
                MultiProcessMMKV kv2 = a.getKV();
                if (kv2 != null) {
                    kv2.putString("key_icon_res_md5", "");
                }
            } else {
                p.VcB = true;
                int safeParseInt = Util.safeParseInt(parseXml.get(".textStateResource.version"));
                a aVar7 = a.GfU;
                MultiProcessMMKV kv3 = a.getKV();
                Integer valueOf = kv3 != null ? Integer.valueOf(kv3.getInt("key_icon_res_version", 0)) : null;
                Log.i("MicroMsg.TxtStatus.StatusIconHelper", "handleUpdate curVersion:" + safeParseInt + " lastVersion:" + valueOf);
                if (valueOf == null || safeParseInt != valueOf.intValue()) {
                    GfV.clear();
                    GfX.clear();
                    GfY.clear();
                    c cVar = new c(parseXml);
                    a(cVar);
                    GfW = cVar;
                    a aVar8 = a.GfU;
                    MultiProcessMMKV kv4 = a.getKV();
                    if (kv4 != null) {
                        c cVar2 = GfW;
                        if (cVar2 != null) {
                            num = Integer.valueOf(cVar2.version);
                        }
                        kv4.putString("key_icon_res_version", String.valueOf(num));
                    }
                    a aVar9 = a.GfU;
                    MultiProcessMMKV kv5 = a.getKV();
                    if (kv5 != null) {
                        kv5.putString("key_icon_res_md5", s.bhK(str));
                    }
                    AppMethodBeat.o(258535);
                    return true;
                }
            }
        } else {
            Log.e("MicroMsg.TxtStatus.StatusIconHelper", "xml no exist");
        }
        Log.i("MicroMsg.TxtStatus.StatusIconHelper", "deleteResult:" + deleteDir + ", success update icon res, result:" + a2);
        AppMethodBeat.o(258535);
        return false;
    }
}
