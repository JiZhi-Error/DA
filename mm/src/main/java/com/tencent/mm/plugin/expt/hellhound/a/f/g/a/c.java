package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.m;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public final Map<String, List<Pair<String, String>>> sIU = new HashMap();
    public final com.tencent.mm.hellhoundlib.a.c sIV = new a(this, (byte) 0);
    boolean sIW = false;
    public String sIX = null;
    public int sIY = 0;

    public c() {
        AppMethodBeat.i(122288);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create("finish", "()V"));
        arrayList.add(Pair.create("dealContentView", "(Landroid/view/View;)V"));
        arrayList.add(Pair.create("onKeyDown", "(ILandroid/view/KeyEvent;)Z"));
        this.sIU.put("com/tencent/mm/plugin/voip/ui/VideoActivity", arrayList);
        AppMethodBeat.o(122288);
    }

    final class a implements com.tencent.mm.hellhoundlib.a.c {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object[] objArr) {
            AppMethodBeat.i(184391);
            if (obj != null) {
                c.this.sIX = obj.getClass().getCanonicalName();
                c.this.sIY = obj.hashCode();
            }
            if (!"finish".equals(str2) || !"()V".equals(str3)) {
                if ("dealContentView".equals(str2) && "(Landroid/view/View;)V".equals(str3)) {
                    c.this.sIW = false;
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(TbsListener.ErrorCode.RENAME_EXCEPTION, Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.o(184391);
                    return;
                } else if ("onKeyDown".equals(str2) && "(ILandroid/view/KeyEvent;)Z".equals(str3)) {
                    if (objArr != null && objArr.length >= 2) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        if (intValue == 4) {
                            AppMethodBeat.o(184391);
                            return;
                        } else if (intValue == 25 || intValue == 24) {
                            AppMethodBeat.o(184391);
                            return;
                        }
                    }
                    com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(218, Long.valueOf(System.currentTimeMillis()));
                }
            } else if (!c.this.sIW) {
                c.this.sIW = true;
                com.tencent.mm.plugin.expt.hellhound.core.a.a.c.cNJ().m(217, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(184391);
                return;
            }
            AppMethodBeat.o(184391);
        }

        @Override // com.tencent.mm.hellhoundlib.a.c
        public final void a(String str, String str2, String str3, Object obj, Object obj2) {
        }
    }

    public static void Dy(long j2) {
        AppMethodBeat.i(184392);
        Log.i("HABBYGE-MALI.VoipFloatSession", "onVoipSessionExit");
        Dz(j2);
        dvl cQD = l.cQD();
        if (cQD == null) {
            AppMethodBeat.o(184392);
            return;
        }
        if (cQD.MWw) {
            b(cQD.MWs, j2);
        }
        AppMethodBeat.o(184392);
    }

    private static void Dz(long j2) {
        AppMethodBeat.i(122290);
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, 不是合法session !!!");
            AppMethodBeat.o(122290);
            return;
        }
        Log.i("HABBYGE-MALI.VoipFloatSession", "_exitVoipSession, curSession: %s", cQo.sessionId);
        b.cPO().a(cQo, j2);
        AppMethodBeat.o(122290);
    }

    private static void b(cyl cyl, long j2) {
        AppMethodBeat.i(122291);
        String aqn = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqn(cyl.sessionId);
        if (aqn == null) {
            AppMethodBeat.o(122291);
            return;
        }
        cyl a2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(cyl, aqn + "_" + j2, j2);
        cbm aoF = com.tencent.mm.plugin.expt.hellhound.core.b.aoF(cyl.sessionId);
        if (aoF != null) {
            Log.i("HABBYGE-MALI.VoipFloatSession", "restoreLastSesssion, curPage: %s, %s", aoF.dMl, aoF.dRM);
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.a(a2, aoF.dMl, aoF.aHK, j2);
        }
        String cPR = m.cPR();
        if (cPR == null) {
            cPR = "";
        }
        a2.kvy = cPR;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.l(a2);
        b.cPO();
        b.e(a2);
        AppMethodBeat.o(122291);
    }
}
