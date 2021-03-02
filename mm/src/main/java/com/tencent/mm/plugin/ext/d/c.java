package com.tencent.mm.plugin.ext.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.d.b;
import com.tencent.mm.plugin.ext.d.e;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.j.a.a.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    private static IListener kiA = new IListener<bp>() {
        /* class com.tencent.mm.plugin.ext.d.c.AnonymousClass1 */

        {
            AppMethodBeat.i(161362);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(161362);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(24474);
            bp bpVar2 = bpVar;
            if (bpVar2.dEN.dEO == 46 && bpVar2.dEN.subType == 0) {
                Log.i("MicroMsg.ExtQbarDataManager", "hy: got ext qrcode config. trigger copy");
                c.CS(bpVar2.dEN.filePath);
                c.access$100();
            }
            AppMethodBeat.o(24474);
            return false;
        }
    };
    private static HashSet<String> sNW = new HashSet<>();
    private static HashSet<String> sNX = new HashSet<>();
    private static ArrayList<a> sNY = new ArrayList<>();
    private static HashMap<String, e.a> sNZ = new HashMap<>();

    static /* synthetic */ void access$100() {
        AppMethodBeat.i(24488);
        cSA();
        AppMethodBeat.o(24488);
    }

    static {
        AppMethodBeat.i(24489);
        AppMethodBeat.o(24489);
    }

    private static String cSz() {
        String str;
        AppMethodBeat.i(24475);
        if (ExtControlProviderOpenApi.IS_DEBUG) {
            str = MMApplicationContext.getContext().getExternalCacheDir().getParent() + "/extqbar";
        } else {
            str = MMApplicationContext.getContext().getFilesDir().getParent() + "/extqbar";
        }
        o oVar = new o(str);
        if (!oVar.exists()) {
            Log.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
            oVar.mkdirs();
        }
        String str2 = str + "/ext_qbar_config.csv";
        AppMethodBeat.o(24475);
        return str2;
    }

    private static void cSA() {
        boolean z;
        AppMethodBeat.i(24476);
        if (!s.YS(cSz())) {
            Log.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
            g.azz().a(new m(46), 0);
            AppMethodBeat.o(24476);
            return;
        }
        try {
            String boY = s.boY(cSz());
            Log.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
            Log.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", boY);
            if (Util.isNullOrNil(boY)) {
                Log.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
            }
            BufferedReader bufferedReader = new BufferedReader(new StringReader(boY));
            long currentTicks = Util.currentTicks();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
                    String[] split = readLine.split(",");
                    if (split.length < 3) {
                        Log.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", readLine);
                    } else {
                        a aVar = new a();
                        aVar.url = split[2].toUpperCase();
                        if ("white".equalsIgnoreCase(split[0])) {
                            aVar.sNN = b.EnumC1032b.WHITE;
                            if ("prefix".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.PREFIX;
                                z = true;
                            } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.SUBDOMAIN;
                                z = true;
                            } else if ("domain".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.DOMAIN;
                                z = true;
                            } else {
                                Log.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", split[1]);
                                z = false;
                            }
                        } else if ("black".equalsIgnoreCase(split[0])) {
                            aVar.sNN = b.EnumC1032b.BLACK;
                            if ("prefix".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.PREFIX;
                                z = true;
                            } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.SUBDOMAIN;
                                z = true;
                            } else if ("domain".equalsIgnoreCase(split[1])) {
                                aVar.sNM = b.a.DOMAIN;
                                z = true;
                            } else {
                                Log.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", split[1]);
                                z = false;
                            }
                        } else {
                            Log.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", split[0]);
                            z = false;
                        }
                        if (z) {
                            sNY.add(aVar);
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: exception when parse config!", new Object[0]);
                }
            }
            Log.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
            AppMethodBeat.o(24476);
        } catch (IOException e3) {
            Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", e3, "hy: read config file failed!", new Object[0]);
            AppMethodBeat.o(24476);
        }
    }

    public static void cSB() {
        AppMethodBeat.i(24477);
        cSA();
        EventCenter.instance.addListener(kiA);
        AppMethodBeat.o(24477);
    }

    public static void cSC() {
        AppMethodBeat.i(24478);
        EventCenter.instance.removeListener(kiA);
        AppMethodBeat.o(24478);
    }

    public static void arr(String str) {
        AppMethodBeat.i(24479);
        sNW.add(str);
        AppMethodBeat.o(24479);
    }

    public static void ars(String str) {
        AppMethodBeat.i(24480);
        sNX.add(str);
        AppMethodBeat.o(24480);
    }

    public static void a(String str, e.a aVar) {
        AppMethodBeat.i(24481);
        sNZ.put(str, aVar);
        AppMethodBeat.o(24481);
    }

    public static e.a art(String str) {
        AppMethodBeat.i(24482);
        e.a aVar = sNZ.get(str);
        AppMethodBeat.o(24482);
        return aVar;
    }

    public static void clearCache() {
        AppMethodBeat.i(24483);
        sNZ.clear();
        AppMethodBeat.o(24483);
    }

    public static boolean aru(String str) {
        AppMethodBeat.i(24484);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
            AppMethodBeat.o(24484);
            return false;
        } else if (sNW.contains(str)) {
            Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", str);
            AppMethodBeat.o(24484);
            return true;
        } else {
            AppMethodBeat.o(24484);
            return false;
        }
    }

    public static boolean arv(String str) {
        AppMethodBeat.i(24485);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
            AppMethodBeat.o(24485);
            return false;
        } else if (sNX.contains(str)) {
            Log.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", str);
            AppMethodBeat.o(24485);
            return true;
        } else {
            AppMethodBeat.o(24485);
            return false;
        }
    }

    public static b.EnumC1032b arw(String str) {
        AppMethodBeat.i(24486);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
            b.EnumC1032b bVar = b.EnumC1032b.NONE;
            AppMethodBeat.o(24486);
            return bVar;
        }
        Iterator<a> it = sNY.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.sNM != b.a.PREFIX) {
                try {
                    String host = new URL(str).getHost();
                    Log.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", host);
                    if (Util.isNullOrNil(new String[0])) {
                        Log.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
                    } else if (next.sNM == b.a.DOMAIN) {
                        if (next.url.equals(host)) {
                            Log.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", next.sNM);
                            b.EnumC1032b bVar2 = next.sNN;
                            AppMethodBeat.o(24486);
                            return bVar2;
                        }
                    } else if (next.sNM == b.a.SUBDOMAIN) {
                        String[] split = next.url.split("\\.");
                        String[] split2 = host.split("\\.");
                        if (split.length > 0 && split2.length > 0 && split.length <= split2.length) {
                            int length = split.length - 1;
                            int length2 = split2.length - 1;
                            boolean z = true;
                            while (length >= 0 && length2 >= 0) {
                                if (!split[length].equals(split2[length2])) {
                                    z = false;
                                }
                                length--;
                                length2--;
                            }
                            if (z) {
                                Log.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", str, next.url);
                                b.EnumC1032b bVar3 = next.sNN;
                                AppMethodBeat.o(24486);
                                return bVar3;
                            }
                        }
                    } else {
                        Log.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
                    }
                } catch (MalformedURLException e2) {
                    Log.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: error in url convert: %s", str);
                }
            } else if (str.startsWith(next.url)) {
                Log.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", next.url);
                b.EnumC1032b bVar4 = next.sNN;
                AppMethodBeat.o(24486);
                return bVar4;
            }
        }
        b.EnumC1032b bVar5 = b.EnumC1032b.NONE;
        AppMethodBeat.o(24486);
        return bVar5;
    }

    static /* synthetic */ void CS(String str) {
        AppMethodBeat.i(24487);
        s.nw(str, cSz());
        AppMethodBeat.o(24487);
    }
}
