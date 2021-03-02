package com.tencent.mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.gcm.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cga;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class cf {
    public static final int iFH;
    public static final int iFI;
    public static final int iFJ = (iFH + 2);
    private static cf iFM;
    private long iFK = 0;
    private Map<Integer, a> iFL = new HashMap();

    static {
        AppMethodBeat.i(143765);
        int hashCode = "kv_key_start".hashCode();
        iFH = hashCode;
        iFI = hashCode + 1;
        AppMethodBeat.o(143765);
    }

    private cf() {
        AppMethodBeat.i(143757);
        this.iFL.put(Integer.valueOf(iFI), new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass1 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143733);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143733);
                    return false;
                }
                cf.I(23, cdVar.iFF + "_3");
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143733);
                return true;
            }
        });
        this.iFL.put(Integer.valueOf(iFJ), new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass12 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143744);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143744);
                    return false;
                }
                cf.I(23, cdVar.iFF + "_43");
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143744);
                return true;
            }
        });
        this.iFL.put(24, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass16 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143748);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143748);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143748);
                return true;
            }
        });
        this.iFL.put(25, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass17 */

            @Override // com.tencent.mm.model.cf.a
            public final cd g(int i2, Object... objArr) {
                AppMethodBeat.i(143749);
                cd cdVar = new cd();
                cdVar.key = i2;
                if (objArr != null && objArr.length > 0) {
                    cdVar.iFF = new StringBuilder().append(objArr[0]).toString();
                }
                cdVar.hwQ = 0;
                AppMethodBeat.o(143749);
                return cdVar;
            }

            @Override // com.tencent.mm.model.cf.a
            public final void a(cd cdVar, Object... objArr) {
                AppMethodBeat.i(143750);
                if (objArr != null && objArr.length > 0) {
                    cdVar.iFF = new StringBuilder().append(objArr[0]).toString();
                }
                AppMethodBeat.o(143750);
            }

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143751);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || cdVar.iFF.length() <= 0) {
                    AppMethodBeat.o(143751);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = "";
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143751);
                return true;
            }
        });
        this.iFL.put(26, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass18 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143752);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143752);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143752);
                return true;
            }
        });
        this.iFL.put(10071, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass19 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143753);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_DAY || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143753);
                    return false;
                }
                cf.I(cdVar.key, "1");
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143753);
                return true;
            }
        });
        this.iFL.put(10076, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass20 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143754);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_HOUR || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143754);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143754);
                return true;
            }
        });
        this.iFL.put(19, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass21 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143755);
                if (System.currentTimeMillis() - cdVar.hwQ <= Util.MILLSECONDS_OF_DAY || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143755);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143755);
                return true;
            }
        });
        this.iFL.put(10112, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass22 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143756);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143756);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143756);
                return true;
            }
        });
        this.iFL.put(10113, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass2 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143734);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143734);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143734);
                return true;
            }
        });
        this.iFL.put(10114, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass3 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143735);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143735);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143735);
                return true;
            }
        });
        this.iFL.put(10115, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass4 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143736);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143736);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143736);
                return true;
            }
        });
        this.iFL.put(Integer.valueOf((int) Task.EXTRAS_LIMIT_BYTES), new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass5 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143737);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143737);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143737);
                return true;
            }
        });
        this.iFL.put(10241, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass6 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143738);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143738);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143738);
                return true;
            }
        });
        this.iFL.put(15, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass7 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143739);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143739);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143739);
                return true;
            }
        });
        this.iFL.put(16, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass8 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143740);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143740);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143740);
                return true;
            }
        });
        this.iFL.put(27, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass9 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143741);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143741);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143741);
                return true;
            }
        });
        this.iFL.put(38, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass10 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143742);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143742);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143742);
                return true;
            }
        });
        this.iFL.put(10090, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass11 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143743);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143743);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143743);
                return true;
            }
        });
        this.iFL.put(10237, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass13 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143745);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143745);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143745);
                return true;
            }
        });
        this.iFL.put(10238, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass14 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143746);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143746);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143746);
                return true;
            }
        });
        this.iFL.put(10239, new a() {
            /* class com.tencent.mm.model.cf.AnonymousClass15 */

            @Override // com.tencent.mm.model.cf.a
            public final boolean a(cd cdVar) {
                AppMethodBeat.i(143747);
                if (System.currentTimeMillis() - cdVar.hwQ <= 1800000 || Util.getInt(cdVar.iFF, 0) <= 0) {
                    AppMethodBeat.o(143747);
                    return false;
                }
                cf.I(cdVar.key, cdVar.iFF);
                cdVar.iFF = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                cdVar.hwQ = System.currentTimeMillis();
                AppMethodBeat.o(143747);
                return true;
            }
        });
        AppMethodBeat.o(143757);
    }

    public static cf aWl() {
        AppMethodBeat.i(143758);
        if (iFM == null) {
            iFM = new cf();
        }
        cf cfVar = iFM;
        AppMethodBeat.o(143758);
        return cfVar;
    }

    public static void I(int i2, String str) {
        AppMethodBeat.i(143759);
        LinkedList linkedList = new LinkedList();
        cga cga = new cga();
        cga.Cya = i2;
        cga.Cyk = str;
        linkedList.add(cga);
        b(linkedList);
        AppMethodBeat.o(143759);
    }

    public static void b(LinkedList<cga> linkedList) {
        AppMethodBeat.i(143760);
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                cgb cgb = new cgb();
                cgb.oTA = linkedList;
                cgb.oTz = linkedList.size();
                ((l) g.af(l.class)).aSM().d(new k.a(36, cgb));
            }
        }
        AppMethodBeat.o(143760);
    }

    public final void f(int i2, Object... objArr) {
        AppMethodBeat.i(143761);
        a aVar = this.iFL.get(Integer.valueOf(i2));
        if (aVar == null) {
            AppMethodBeat.o(143761);
            return;
        }
        ce aWn = aWn();
        aVar.a(aWn, i2, objArr);
        a(aWn);
        AppMethodBeat.o(143761);
    }

    public final void aWm() {
        AppMethodBeat.i(143762);
        if (System.currentTimeMillis() - this.iFK < Util.MILLSECONDS_OF_MINUTE) {
            AppMethodBeat.o(143762);
            return;
        }
        this.iFK = System.currentTimeMillis();
        try {
            ce aWn = aWn();
            boolean z = false;
            for (cd cdVar : aWn.iFG) {
                a aVar = this.iFL.get(Integer.valueOf(cdVar.key));
                z = (aVar == null || !aVar.a(cdVar)) ? z : true;
            }
            if (z) {
                a(aWn);
            }
            AppMethodBeat.o(143762);
        } catch (Exception e2) {
            Log.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(143762);
        }
    }

    private static ce aWn() {
        AppMethodBeat.i(143763);
        if (g.aAf().azp()) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj() && g.aAh().azQ() != null) {
                byte[] decodeHexString = Util.decodeHexString((String) g.aAh().azQ().get(8215, (Object) null));
                if (decodeHexString == null || decodeHexString.length <= 0) {
                    ce ceVar = new ce();
                    AppMethodBeat.o(143763);
                    return ceVar;
                }
                try {
                    ce ceVar2 = new ce();
                    ceVar2.parseFrom(decodeHexString);
                    AppMethodBeat.o(143763);
                    return ceVar2;
                } catch (IOException e2) {
                    Log.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        ce ceVar3 = new ce();
        AppMethodBeat.o(143763);
        return ceVar3;
    }

    private static void a(ce ceVar) {
        AppMethodBeat.i(143764);
        if (!(ceVar == null || !g.aAf().azp() || g.aAh().azQ() == null)) {
            g.aAf();
            if (!com.tencent.mm.kernel.a.azj()) {
                try {
                    g.aAh().azQ().set(8215, Util.encodeHexString(ceVar.toByteArray()));
                    AppMethodBeat.o(143764);
                    return;
                } catch (IOException e2) {
                    Log.e("MicroMsg.StatisticsKVReportLogic", "exception:%s", Util.stackTraceToString(e2));
                }
            }
        }
        AppMethodBeat.o(143764);
    }

    /* access modifiers changed from: package-private */
    public abstract class a {
        public abstract boolean a(cd cdVar);

        private a() {
        }

        /* synthetic */ a(cf cfVar, byte b2) {
            this();
        }

        public final void a(ce ceVar, int i2, Object... objArr) {
            if (ceVar != null) {
                for (cd cdVar : ceVar.iFG) {
                    if (cdVar.key == i2) {
                        a(cdVar, objArr);
                        return;
                    }
                }
                ceVar.iFG.add(g(i2, objArr));
            }
        }

        public cd g(int i2, Object... objArr) {
            int i3 = 1;
            if (objArr != null && objArr.length > 0) {
                i3 = Util.nullAsInt(objArr[0], 1);
            }
            cd cdVar = new cd();
            cdVar.key = i2;
            cdVar.iFF = String.valueOf(i3);
            cdVar.hwQ = 0;
            return cdVar;
        }

        public void a(cd cdVar, Object... objArr) {
            int i2 = 1;
            if (objArr != null && objArr.length > 0) {
                i2 = Util.nullAsInt(objArr[0], 1);
            }
            cdVar.iFF = new StringBuilder().append(i2 + Util.getInt(cdVar.iFF, 0)).toString();
        }
    }
}
