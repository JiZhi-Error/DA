package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.luggage.h.b;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bn;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.appstorage.v;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class at extends v {
    static {
        AppMethodBeat.i(147172);
        at.class.getClassLoader();
        j.Ed("appbrandcommon");
        AppMethodBeat.o(147172);
    }

    public at(final d dVar, d dVar2) {
        super(new LinkedList());
        q K;
        AppMethodBeat.i(147163);
        if (bn.O(dVar) != null) {
            K = new bb(bg.M(dVar));
        } else {
            K = bc.K(dVar);
        }
        this.kTe.clear();
        i iVar = new i(AppBrandLocalMediaObjectManager.cbh() + dVar.mAppId + "/blobTmp/", dVar.mAppId, "wxblob://", new i.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.at.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.appstorage.i.a
            public final f bxr() {
                AppMethodBeat.i(229902);
                s NY = dVar.NY();
                AppMethodBeat.o(229902);
                return NY;
            }
        });
        iVar.kSt = dVar2.cyR * 1048576;
        this.kTe.add(iVar);
        o oVar = new o(AppBrandLocalMediaObjectManager.cbh() + dVar.mAppId + FilePathGenerator.ANDROID_DIR_SEP, dVar.mAppId, "wxfile://");
        oVar.kSt = dVar2.cyR * 1048576;
        z dt = dt(p.getString(dVar.ON().uin), dVar.mAppId);
        dt.kTk = dVar2.cyR * 1048576;
        z du = du(p.getString(dVar.ON().uin), dVar.mAppId);
        du.kTk = dVar2.ldl * 1048576;
        this.kTe.add(du);
        z dv = dv(p.getString(dVar.ON().uin), dVar.mAppId);
        dv.kTk = MAlarmHandler.NEXT_FIRE_INTERVAL;
        this.kTe.add(dv);
        z dw = dw(p.getString(dVar.ON().uin), dVar.mAppId);
        dw.kTk = dVar2.cyR * 1048576;
        this.kTe.add(dw);
        this.kTe.add(dt);
        this.kTe.add(oVar);
        this.kTe.add(K);
        initialize();
        AppMethodBeat.o(147163);
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.v
    public final m a(String str, com.tencent.mm.plugin.appbrand.ac.i<List<k>> iVar) {
        AppMethodBeat.i(147164);
        Uri parse = Uri.parse(str);
        if (!"wxfile".equals(parse.getScheme()) || !Util.isNullOrNil(parse.getAuthority())) {
            m a2 = super.a(str, iVar);
            AppMethodBeat.o(147164);
            return a2;
        }
        T t = (T) new LinkedList();
        ((o) az(o.class)).a("", iVar);
        if (!Util.isNullOrNil((List) iVar.value)) {
            for (k kVar : iVar.value) {
                kVar.fileName = kVar.fileName.replaceFirst(Pattern.quote("wxfile://"), "");
            }
        }
        b.c(t, iVar.value);
        ((z) Wj("wxfile://usr")).a("wxfile://usr", iVar);
        b.c(t, iVar.value);
        iVar.value = t;
        m mVar = m.OK;
        AppMethodBeat.o(147164);
        return mVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.v
    public m a(com.tencent.mm.vfs.o oVar, String str, boolean z, com.tencent.mm.plugin.appbrand.ac.i<String> iVar) {
        AppMethodBeat.i(169493);
        m a2 = ((o) az(o.class)).a(oVar, str, z, iVar);
        AppMethodBeat.o(169493);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.v
    public final com.tencent.mm.vfs.o Wa(String str) {
        AppMethodBeat.i(147166);
        com.tencent.mm.vfs.o Wa = ((o) az(o.class)).Wa(str);
        AppMethodBeat.o(147166);
        return Wa;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q, com.tencent.mm.plugin.appbrand.appstorage.v
    public final List<y> bxs() {
        AppMethodBeat.i(147167);
        List<y> bxw = ((o) az(o.class)).kSN.bxw();
        AppMethodBeat.o(147167);
        return bxw;
    }

    public static String bGo() {
        AppMethodBeat.i(261893);
        String cbh = AppBrandLocalMediaObjectManager.cbh();
        AppMethodBeat.o(261893);
        return cbh;
    }

    public static z dt(String str, String str2) {
        AppMethodBeat.i(147168);
        z zVar = new z(o(str, str2), "wxfile://usr");
        AppMethodBeat.o(147168);
        return zVar;
    }

    public static z du(String str, String str2) {
        AppMethodBeat.i(147169);
        z zVar = new z(o(str, str2, "opendata"), "wxfile://opendata");
        AppMethodBeat.o(147169);
        return zVar;
    }

    public static z dv(String str, String str2) {
        AppMethodBeat.i(147170);
        z zVar = new z(o(str, str2, "clientdata"), "wxfile://clientdata");
        AppMethodBeat.o(147170);
        return zVar;
    }

    public static z dw(String str, String str2) {
        AppMethodBeat.i(182990);
        z zVar = new z(o(str, str2, "singlePage"), "wxfile://singlepage");
        AppMethodBeat.o(182990);
        return zVar;
    }

    public static String o(String... strArr) {
        com.tencent.mm.vfs.o oVar;
        AppMethodBeat.i(147171);
        StringBuilder sb = new StringBuilder(";");
        for (String str : strArr) {
            sb.append(Util.nullAsNil(str)).append(';');
        }
        String messageDigest = g.getMessageDigest(sb.toString().getBytes());
        if (!e.apn()) {
            oVar = null;
        } else {
            String aKJ = com.tencent.mm.loader.j.b.aKJ();
            if (!aKJ.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                aKJ = aKJ + FilePathGenerator.ANDROID_DIR_SEP;
            }
            oVar = new com.tencent.mm.vfs.o(aKJ + "wxanewfiles/");
        }
        if (oVar == null) {
            Log.e("MicroMsg.AppBrand.LuggageFileSystemRegistryWC", "getIndependentRootPath, extRoot NULL");
            AppMethodBeat.o(147171);
            return null;
        }
        String z = aa.z(new com.tencent.mm.vfs.o(aa.z(oVar.mUri) + FilePathGenerator.ANDROID_DIR_SEP + messageDigest).mUri);
        AppMethodBeat.o(147171);
        return z;
    }
}
