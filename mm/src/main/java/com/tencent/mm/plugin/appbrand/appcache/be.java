package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.debugger.e;
import com.tencent.mm.plugin.appbrand.debugger.i;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.fch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class be implements cj.a {
    public static final Map<String, c> kNv;

    public interface c {
        void l(String str, Map<String, String> map);
    }

    static {
        AppMethodBeat.i(44366);
        HashMap hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b((byte) 0));
        hashMap.put("AppPublicLibraryNotify", new d((byte) 0));
        hashMap.put("mmbizwxaconfig", new a((byte) 0));
        hashMap.put("ForceOpenAppNotify", new e());
        hashMap.put("AppBrandForceKill", new com.tencent.mm.plugin.appbrand.debugger.d());
        if (DebuggerShell.bAx()) {
            hashMap.put("AppBrandTestUpdateWxaUsageListNotify", new i());
        }
        kNv = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(44366);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(44364);
        final String a2 = z.a(aVar.heO.KHn);
        if (Util.isNullOrNil(a2)) {
            Log.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
            AppMethodBeat.o(44364);
            return;
        }
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.appcache.be.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44357);
                be.fV(a2);
                AppMethodBeat.o(44357);
            }
        }, "MicroMsg.AppBrand.WxaPkgPushingXmlHandler");
        AppMethodBeat.o(44364);
    }

    static final class b implements c {
        private static final String kNz = ("<sysmsg type=\"AppBrandNotify\">\n\t<AppBrandNotify> \t\n\t\t<DebugInfoList> \t\t\n\t\t\t<DebugInfo> \t\t\t\n\t\t\t\t<AppID>wx221a6c79f8176f0a</AppID>\n\t\t\t\t<UserName>gh_495fc098f3aa</UserName>\n\t\t\t\t<Type>1</Type>\n\t\t\t\t<URL>https://" + WeChatHosts.domainString(R.string.e22) + "/weapp-test/debug/E_MGI-1c7F4DvKwqnDNT7VCFLgeSJ6w6GfrdgXutHfo</URL>\n\t\t\t\t<StartTime>1470322794</StartTime>\n\t\t\t\t<EndTime>1470329994</EndTime>\n\t\t\t</DebugInfo>\n\t\t</DebugInfoList>\n\t</AppBrandNotify>\n</sysmsg>");

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.be.c
        public final void l(String str, Map<String, String> map) {
            AppMethodBeat.i(226367);
            m(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i2 = 0;
            do {
                i2++;
            } while (m(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo".concat(String.valueOf(i2)), map));
            AppMethodBeat.o(226367);
        }

        private boolean m(String str, Map<String, String> map) {
            AppMethodBeat.i(44362);
            Log.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", str);
            if (map.get(str) == null) {
                AppMethodBeat.o(44362);
                return false;
            }
            final String str2 = map.get(str + ".AppID");
            String str3 = map.get(str + ".UserName");
            final int i2 = Util.getInt(map.get(str + ".Type"), 1);
            String str4 = map.get(str + ".URL");
            long j2 = Util.getLong(map.get(str + ".StartTime"), Util.nowSecond());
            long j3 = Util.getLong(map.get(str + ".EndTime"), 7200 + j2);
            String str5 = map.get(str + ".MD5");
            boolean a2 = n.buL().a(str2, i2, str4, str5, j2, j3);
            Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", str2, str3, Integer.valueOf(i2), str4, Long.valueOf(j2), Long.valueOf(j3), str5, Boolean.valueOf(a2));
            if (a2) {
                if (999 != i2) {
                    aa.XD(str3);
                    final String Xx = y.Xx(str2);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.be.b.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(44360);
                            com.tencent.mm.plugin.appbrand.task.h.bWb().cl(str2, i2);
                            Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.p9, Util.nullAs(Xx, str2)), 1).show();
                            AppMethodBeat.o(44360);
                        }
                    });
                } else {
                    y.INSTANCE.gB(false);
                }
                n.buJ().bo(str3, i2);
            }
            AppMethodBeat.o(44362);
            return true;
        }

        static {
            AppMethodBeat.i(226368);
            AppMethodBeat.o(226368);
        }
    }

    static final class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.be.c
        public final void l(String str, Map<String, String> map) {
            AppMethodBeat.i(226369);
            if (map.get(".sysmsg.AppPublicLibraryNotify") == null) {
                AppMethodBeat.o(226369);
                return;
            }
            int i2 = Util.getInt(map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
            String str2 = map.get(".sysmsg.AppPublicLibraryNotify.MD5");
            String str3 = map.get(".sysmsg.AppPublicLibraryNotify.URL");
            int i3 = Util.getInt(map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
            if (Util.isNullOrNil(str3) || Util.isNullOrNil(str2) || i2 <= 0) {
                Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", str3, str2, Integer.valueOf(i2));
                AppMethodBeat.o(226369);
                return;
            }
            Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", Integer.valueOf(i2), str2, str3, Integer.valueOf(i3));
            fch fch = new fch();
            fch.version = i2;
            fch.md5 = str2;
            fch.url = str3;
            fch.MKJ = i3;
            au.a(fch);
            AppMethodBeat.o(226369);
        }
    }

    static final class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.appcache.be.c
        public final void l(String str, Map<String, String> map) {
            AppMethodBeat.i(226366);
            if (map.get(".sysmsg.mmbizwxaconfig") == null) {
                AppMethodBeat.o(226366);
                return;
            }
            int i2 = Util.getInt(map.get(".sysmsg.mmbizwxaconfig.command"), -1);
            final int i3 = Util.getInt(map.get(".sysmsg.mmbizwxaconfig.type"), 0);
            final String str2 = map.get(".sysmsg.mmbizwxaconfig.appid");
            int i4 = Util.getInt(map.get(".sysmsg.mmbizwxaconfig.configversion"), 0);
            Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i2), Integer.valueOf(i3), str2, Integer.valueOf(i4));
            LinkedList linkedList = new LinkedList();
            eqm eqm = new eqm();
            eqm.version = i4;
            eqm.type = i3;
            linkedList.add(eqm);
            q.a(str2, linkedList, false);
            q.a(str2, i3, i2, (q.c) new q.c() {
                /* class com.tencent.mm.plugin.appbrand.appcache.be.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.config.q.c
                public final void Vo(String str) {
                    AppMethodBeat.i(44358);
                    Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", str);
                    com.tencent.mm.plugin.appbrand.ipc.e.v(str2, i3, str);
                    AppMethodBeat.o(44358);
                }
            }, true);
            AppMethodBeat.o(226366);
        }
    }

    static /* synthetic */ void fV(String str) {
        c cVar;
        AppMethodBeat.i(44365);
        if (n.buL() == null) {
            Log.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            AppMethodBeat.o(44365);
            return;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "sysmsg", null);
        if (parseXml == null || parseXml.size() <= 0) {
            Log.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            AppMethodBeat.o(44365);
            return;
        }
        String str2 = parseXml.get(".sysmsg.$type");
        Log.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", str2);
        if (!Util.isNullOrNil(str2) && (cVar = kNv.get(str2)) != null) {
            cVar.l(str, parseXml);
        }
        AppMethodBeat.o(44365);
    }
}
