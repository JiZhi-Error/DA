package com.tencent.mm.plugin.appbrand.config;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.protocal.protobuf.eqm;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class q {

    public interface b {
        void a(int i2, int i3, String str, d dVar);
    }

    public interface c {
        void Vo(String str);
    }

    public static void b(String str, LinkedList<eqm> linkedList) {
        AppMethodBeat.i(44866);
        a(str, linkedList, true);
        AppMethodBeat.o(44866);
    }

    public static void a(final String str, LinkedList<eqm> linkedList, boolean z) {
        AppMethodBeat.i(44867);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
            AppMethodBeat.o(44867);
        } else if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
            AppMethodBeat.o(44867);
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator<eqm> it = linkedList.iterator();
            while (it.hasNext()) {
                eqm next = it.next();
                Log.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", Integer.valueOf(next.version), Integer.valueOf(next.type));
                int bB = a.bB(str, next.type);
                int i2 = next.version;
                a.O(str, next.type, i2);
                if (i2 != 0) {
                    if (i2 > bB) {
                        linkedList2.add(M(str, next.type, next.version));
                    } else if (i2 != bB) {
                        Log.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", Integer.valueOf(bB), Integer.valueOf(i2));
                        if (Util.isNullOrNil(a.bD(str, next.type))) {
                            linkedList2.add(M(str, next.type, next.version));
                        }
                    } else if (Util.isNullOrNil(a.bD(str, next.type))) {
                        linkedList2.add(M(str, next.type, next.version));
                    }
                }
            }
            Log.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (z) {
                if (linkedList2.size() == 0) {
                    AppMethodBeat.o(44867);
                    return;
                }
                Log.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", str);
                a(linkedList2, new b() {
                    /* class com.tencent.mm.plugin.appbrand.config.q.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.config.q.b
                    public final void a(int i2, int i3, String str, d dVar) {
                        AppMethodBeat.i(44854);
                        if (i2 == 0 && i3 == 0) {
                            bic bic = (bic) dVar.iLL.iLR;
                            if (bic.LSs == null || bic.LSs.size() == 0) {
                                Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                AppMethodBeat.o(44854);
                                return;
                            }
                            Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", Integer.valueOf(bic.LSs.size()));
                            Iterator<ew> it = bic.LSs.iterator();
                            while (it.hasNext()) {
                                ew next = it.next();
                                Log.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", next.KIn, Integer.valueOf(next.KIm));
                                if (!Util.isNullOrNil(next.KIn)) {
                                    a.N(str, next.oUv, next.KIm);
                                    a.O(str, next.oUv, next.KIm);
                                    a.t(str, next.oUv, next.KIn);
                                }
                            }
                            AppMethodBeat.o(44854);
                            return;
                        }
                        Log.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        AppMethodBeat.o(44854);
                    }
                });
            }
            AppMethodBeat.o(44867);
        }
    }

    private static bia M(String str, int i2, int i3) {
        AppMethodBeat.i(44868);
        bia bia = new bia();
        bia.jfi = str;
        bia.oUv = i2;
        bia.KIm = i3;
        AppMethodBeat.o(44868);
        return bia;
    }

    public static String a(final String str, int i2, int i3, final c cVar, boolean z) {
        AppMethodBeat.i(44869);
        if (n.NL() == null) {
            AppMethodBeat.o(44869);
            return "";
        }
        int bB = a.bB(str, i2);
        int bC = a.bC(str, i2);
        String bD = a.bD(str, i2);
        boolean z2 = bC != 0 && (Util.isNullOrNil(bD) || bC > bB);
        Log.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", Integer.valueOf(bC), Integer.valueOf(bB));
        Log.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", bD, Boolean.valueOf(z2));
        if (!z2) {
            cVar.Vo(bD);
        } else if (z) {
            a(str, i2, bC, i3, new b() {
                /* class com.tencent.mm.plugin.appbrand.config.q.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.config.q.b
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(44855);
                    if (i2 == 0 && i3 == 0) {
                        bic bic = (bic) dVar.iLL.iLR;
                        if (bic.LSs == null || bic.LSs.size() == 0) {
                            Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (cVar != null) {
                                cVar.Vo("");
                            }
                            AppMethodBeat.o(44855);
                            return;
                        }
                        ew ewVar = bic.LSs.get(0);
                        Log.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", ewVar.KIn, Integer.valueOf(ewVar.KIm));
                        if (!Util.isNullOrNil(ewVar.KIn)) {
                            a.N(str, ewVar.oUv, ewVar.KIm);
                            a.O(str, ewVar.oUv, ewVar.KIm);
                            a.t(str, ewVar.oUv, ewVar.KIn);
                            if (cVar != null) {
                                cVar.Vo(ewVar.KIn);
                                AppMethodBeat.o(44855);
                                return;
                            }
                        } else if (cVar != null) {
                            cVar.Vo("");
                        }
                        AppMethodBeat.o(44855);
                        return;
                    }
                    Log.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    if (cVar != null) {
                        cVar.Vo("");
                    }
                    AppMethodBeat.o(44855);
                }
            });
        }
        AppMethodBeat.o(44869);
        return bD;
    }

    private static void a(String str, int i2, int i3, int i4, b bVar) {
        AppMethodBeat.i(44870);
        LinkedList linkedList = new LinkedList();
        bia bia = new bia();
        bia.jfi = str;
        bia.oUv = i2;
        bia.KIm = i3;
        bia.LSq = i4;
        linkedList.add(bia);
        a(linkedList, bVar);
        AppMethodBeat.o(44870);
    }

    private static void a(LinkedList<bia> linkedList, final b bVar) {
        AppMethodBeat.i(44871);
        d.a aVar = new d.a();
        aVar.funcId = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.iLO = new bic();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        bib bib = new bib();
        bib.LSr = linkedList;
        aVar.iLN = bib;
        aa.a(aVar.aXF(), new aa.a() {
            /* class com.tencent.mm.plugin.appbrand.config.q.AnonymousClass3 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(44856);
                if (bVar != null) {
                    bVar.a(i2, i3, str, dVar);
                }
                AppMethodBeat.o(44856);
                return 0;
            }
        }, true);
        AppMethodBeat.o(44871);
    }

    public static class a {
        private static String by(String str, int i2) {
            AppMethodBeat.i(44857);
            String format = String.format("%s_%s_local_version", str, Integer.valueOf(i2));
            AppMethodBeat.o(44857);
            return format;
        }

        private static String bz(String str, int i2) {
            AppMethodBeat.i(44858);
            String format = String.format("%s_%s_server_version", str, Integer.valueOf(i2));
            AppMethodBeat.o(44858);
            return format;
        }

        private static String bA(String str, int i2) {
            AppMethodBeat.i(44859);
            String format = String.format("%s_%s_config", str, Integer.valueOf(i2));
            AppMethodBeat.o(44859);
            return format;
        }

        public static String Xj(String str) {
            AppMethodBeat.i(226466);
            String format = String.format("%s#NotifyMessageStatus", str);
            AppMethodBeat.o(226466);
            return format;
        }

        public static void N(String str, int i2, int i3) {
            AppMethodBeat.i(44860);
            if (n.NL() == null) {
                AppMethodBeat.o(44860);
                return;
            }
            n.NL().cN(by(str, i2), String.valueOf(i3));
            AppMethodBeat.o(44860);
        }

        public static void O(String str, int i2, int i3) {
            AppMethodBeat.i(44861);
            if (n.NL() == null) {
                AppMethodBeat.o(44861);
                return;
            }
            n.NL().cN(bz(str, i2), String.valueOf(i3));
            AppMethodBeat.o(44861);
        }

        public static void t(String str, int i2, String str2) {
            AppMethodBeat.i(44862);
            if (n.NL() == null) {
                AppMethodBeat.o(44862);
                return;
            }
            n.NL().cN(bA(str, i2), str2);
            AppMethodBeat.o(44862);
        }

        public static int bB(String str, int i2) {
            AppMethodBeat.i(44863);
            if (n.NL() == null) {
                AppMethodBeat.o(44863);
                return 0;
            }
            int i3 = Util.getInt(n.NL().get(by(str, i2), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.o(44863);
            return i3;
        }

        public static int bC(String str, int i2) {
            AppMethodBeat.i(44864);
            if (n.NL() == null) {
                AppMethodBeat.o(44864);
                return 0;
            }
            int i3 = Util.getInt(n.NL().get(bz(str, i2), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            AppMethodBeat.o(44864);
            return i3;
        }

        public static String bD(String str, int i2) {
            AppMethodBeat.i(44865);
            if (n.NL() == null) {
                AppMethodBeat.o(44865);
                return "";
            }
            String str2 = n.NL().get(bA(str, i2), "");
            AppMethodBeat.o(44865);
            return str2;
        }
    }
}
