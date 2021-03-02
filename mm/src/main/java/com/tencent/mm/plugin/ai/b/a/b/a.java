package com.tencent.mm.plugin.ai.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.a.abi;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.b.a.oi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static a kwD;
    private static final HashMap<String, Integer> zZh;
    private int[] AaF = new int[13];
    public IListener<uc> kvR = new IListener<uc>() {
        /* class com.tencent.mm.plugin.ai.b.a.b.a.AnonymousClass1 */

        {
            AppMethodBeat.i(238888);
            this.__eventId = uc.class.getName().hashCode();
            AppMethodBeat.o(238888);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uc ucVar) {
            AppMethodBeat.i(238890);
            uc ucVar2 = ucVar;
            if (ucVar2 != null && ucVar2.eav.type == 0) {
                a.a(a.this, ucVar2.eav.sessionId, ucVar2.eav.eaw);
            }
            AppMethodBeat.o(238890);
            return false;
        }
    };
    public IListener<aal> kvT = new IListener<aal>() {
        /* class com.tencent.mm.plugin.ai.b.a.b.a.AnonymousClass2 */

        {
            AppMethodBeat.i(238891);
            this.__eventId = aal.class.getName().hashCode();
            AppMethodBeat.o(238891);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aal aal) {
            AppMethodBeat.i(238893);
            aal aal2 = aal;
            if (aal2 == null || aal2.ehk == null) {
                AppMethodBeat.o(238893);
            } else {
                if (aal2.ehk.type == 7) {
                    a.this.kwC = aal2.ehk.ehl;
                }
                if (aal2.ehk.type == 8) {
                    a.this.kwC = 0;
                    a.a(a.this, "desktop", aal2.ehk.ehl);
                }
                Log.v("MicroMsg.AiSessionData", "wechat front back event [%d] [%s] [%d]", Integer.valueOf(aal2.ehk.type), aal2.ehk.activity, Long.valueOf(aal2.ehk.ehl));
                AppMethodBeat.o(238893);
            }
            return false;
        }
    };
    private List<b> kwB = new LinkedList();
    private long kwC = 0;
    public IListener<abi> kxn = new IListener<abi>() {
        /* class com.tencent.mm.plugin.ai.b.a.b.a.AnonymousClass3 */

        {
            AppMethodBeat.i(259578);
            this.__eventId = abi.class.getName().hashCode();
            AppMethodBeat.o(259578);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abi abi) {
            int i2 = 1;
            AppMethodBeat.i(259579);
            abi abi2 = abi;
            if (abi2 != null) {
                Log.i("MicroMsg.AiSessionData", "note entry red dot [%s] entry [%b]", abi2.opT.wJe, Boolean.valueOf(abi2.opT.HHY));
                HashMap hashMap = a.this.zZJ;
                String str = abi2.opT.wJe;
                if (!abi2.opT.HHY) {
                    i2 = 0;
                }
                hashMap.put(str, Integer.valueOf(i2));
            }
            AppMethodBeat.o(259579);
            return false;
        }
    };
    private HashMap<String, Integer> zZJ = new HashMap<>();

    static {
        AppMethodBeat.i(259580);
        HashMap<String, Integer> hashMap = new HashMap<>();
        zZh = hashMap;
        hashMap.put("album_dyna_photo_ui_title", 0);
        zZh.put("find_live_friends_by_near", 1);
        zZh.put("find_friends_by_near", 1);
        zZh.put("find_friends_by_shake", 2);
        zZh.put("find_friends_by_qrcode", 3);
        zZh.put("more_tab_game_recommend", 4);
        zZh.put("jd_market_entrance", 5);
        zZh.put("app_brand_entrance", 6);
        zZh.put("ip_call_entrance", 7);
        zZh.put("find_friends_by_look", 8);
        zZh.put("find_friends_by_search", 9);
        zZh.put("my_life_around", 10);
        zZh.put("find_friends_by_finder", 11);
        AppMethodBeat.o(259580);
    }

    private a() {
        AppMethodBeat.i(238894);
        AppMethodBeat.o(238894);
    }

    public static a bqv() {
        AppMethodBeat.i(238895);
        if (kwD == null) {
            kwD = new a();
        }
        a aVar = kwD;
        AppMethodBeat.o(238895);
        return aVar;
    }

    static /* synthetic */ void a(a aVar, String str, long j2) {
        String str2;
        String str3;
        String str4;
        long j3;
        long j4;
        AppMethodBeat.i(238896);
        Log.i("MicroMsg.AiSessionData", "handleSessionEvent sessionId[%s]", str);
        b bVar = new b();
        bVar.id = str;
        bVar.kwF = j2;
        aVar.kwB.add(bVar);
        try {
            int size = aVar.kwB.size();
            if (size > 1) {
                b bVar2 = aVar.kwB.get(size - 1);
                b bVar3 = size >= 2 ? aVar.kwB.get(size - 2) : null;
                b remove = size >= 3 ? aVar.kwB.remove(size - 3) : null;
                f fVar = new f();
                if (remove != null) {
                    str2 = remove.id;
                } else {
                    str2 = "";
                }
                fVar.ejs = fVar.x("lastSessionId", str2, true);
                if (bVar2 != null) {
                    str3 = bVar2.id;
                } else {
                    str3 = "";
                }
                fVar.eju = fVar.x("nextSessionId", str3, true);
                if (bVar3 != null) {
                    str4 = bVar3.id;
                } else {
                    str4 = "";
                }
                fVar.ejt = fVar.x("currSessionId", str4, true);
                if (bVar3 != null) {
                    j3 = bVar3.kwF;
                } else {
                    j3 = 0;
                }
                fVar.ejv = j3;
                if (bVar2 != null) {
                    j4 = bVar2.kwF;
                } else {
                    j4 = 0;
                }
                fVar.ejw = j4;
                fVar.ejx = fVar.ejw - fVar.ejv;
                fVar.bfK();
                Log.i("MicroMsg.AiSessionData", "report size[ %d, %d ] [%s]", Integer.valueOf(size), Integer.valueOf(aVar.kwB.size()), fVar.abW());
                if (bVar3 != null && "2".equals(bVar3.id)) {
                    long currentTicks = Util.currentTicks();
                    for (int i2 = 0; i2 < aVar.AaF.length; i2++) {
                        aVar.AaF[i2] = 0;
                    }
                    for (String str5 : aVar.zZJ.keySet()) {
                        if (zZh.containsKey(str5)) {
                            aVar.AaF[zZh.get(str5).intValue()] = aVar.zZJ.get(str5).intValue();
                        }
                    }
                    Log.d("MicroMsg.AiSessionData", "copyRedDotInfo [%s]", Arrays.toString(aVar.AaF));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(fVar.ejs).append(",");
                    stringBuffer.append(fVar.ejt).append(",");
                    stringBuffer.append(fVar.eju).append(",");
                    stringBuffer.append(fVar.ejv).append(",");
                    stringBuffer.append(fVar.ejw).append(",");
                    stringBuffer.append(fVar.ejx).append(",");
                    for (int i3 = 0; i3 < aVar.AaF.length; i3++) {
                        stringBuffer.append(aVar.AaF[i3]).append(",");
                    }
                    oi oiVar = new oi(stringBuffer.toString());
                    oiVar.bfK();
                    Log.d("MicroMsg.AiSessionData", "report find friend cost[%d] [%s]", Long.valueOf(Util.ticksToNow(currentTicks)), oiVar.abW());
                }
            }
            AppMethodBeat.o(238896);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AiSessionData", e2, "", new Object[0]);
            AppMethodBeat.o(238896);
        }
    }
}
