package com.tencent.mm.plugin.wenote.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.od;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.a.w;
import com.tencent.mm.plugin.wenote.model.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;

public final class c implements p, d {
    @Override // com.tencent.mm.plugin.fav.a.p
    public final void e(com.tencent.mm.plugin.fav.a.c cVar) {
        AppMethodBeat.i(30261);
        g HT = f.HT(cVar.field_favLocalId);
        if (HT == null) {
            com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL;
            if (dVar == null || dVar.JGO == null) {
                AppMethodBeat.o(30261);
                return;
            } else if (cVar.field_favLocalId != dVar.JGO.dUt) {
                Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "info null and not match localId:%s, %s", Long.valueOf(cVar.field_favLocalId), Long.valueOf(dVar.JGO.dUt));
                AppMethodBeat.o(30261);
                return;
            }
        } else if (HT.field_type != 18) {
            Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", Long.valueOf(cVar.field_favLocalId));
            AppMethodBeat.o(30261);
            return;
        }
        if (cVar.field_status == 3 && s.YS(cVar.field_path) && cVar.field_path.endsWith("..htm")) {
            f.O(cVar.field_favLocalId, cVar.field_path);
        }
        e eVar = new e();
        eVar.field_favLocalId = cVar.field_favLocalId;
        eVar.field_dataId = cVar.field_dataId;
        eVar.field_status = cVar.field_status;
        eVar.field_offset = cVar.field_offset;
        eVar.field_totalLen = cVar.field_totalLen;
        eVar.field_path = cVar.field_path;
        a(eVar);
        AppMethodBeat.o(30261);
    }

    private static void a(e eVar) {
        w wVar;
        w wVar2;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(30263);
        com.tencent.mm.plugin.wenote.model.d dVar = com.tencent.mm.plugin.wenote.model.c.gjz().JGL;
        if (dVar == null) {
            AppMethodBeat.o(30263);
            return;
        }
        if (eVar.isFinished()) {
            if (!s.YS(eVar.field_path)) {
                AppMethodBeat.o(30263);
                return;
            }
            String str = dVar.JGR.get(eVar.field_dataId);
            if (!Util.isNullOrNil(str)) {
                Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", str);
                if (!eVar.field_dataId.endsWith("_t") || dVar.JGS.get(str) == null) {
                    if (!str.equals("WeNoteHtmlFile")) {
                        if (dVar.JGR.containsValue("WeNoteHtmlFile")) {
                            if (dVar.JGO.dUt == -1) {
                                wVar2 = dVar.JGQ.get(Long.toString(dVar.JGO.msgId));
                            } else {
                                wVar2 = dVar.JGQ.get(Long.toString(dVar.JGO.dUt));
                            }
                            if (wVar2 != null && wVar2.qPU != null) {
                                Iterator<o> it = wVar2.qPU.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    o next = it.next();
                                    if (next.qPN.equals(str)) {
                                        next.qPO = true;
                                        if (next.type == 4) {
                                            v vVar = (v) next;
                                            vVar.mav = com.tencent.mm.plugin.wenote.model.d.qPf;
                                            aml bbP = dVar.bbP(eVar.field_dataId);
                                            if (bbP == null) {
                                                Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                            } else {
                                                i3 = bbP.duration;
                                            }
                                            vVar.length = (int) f.AO((long) i3);
                                            vVar.qPR = f.W(MMApplicationContext.getContext(), vVar.length);
                                            vVar.dLu = i3;
                                        } else if (next.getType() == 2) {
                                            com.tencent.mm.plugin.wenote.c.c.fK(eVar.field_path, dVar.JGS.get(str).dUs);
                                        } else {
                                            next.dUs = eVar.field_path;
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, next);
                                    }
                                }
                            } else {
                                AppMethodBeat.o(30263);
                                return;
                            }
                        } else {
                            od odVar = new od();
                            odVar.dUq.dUg = str;
                            odVar.dUq.dUs = eVar.field_path;
                            odVar.dUq.type = 1;
                            odVar.dUq.dUm = dVar.JGS.get(str).type;
                            if (odVar.dUq.dUm != 4) {
                                o oVar = dVar.JGS.get(str);
                                if (odVar.dUq.dUm != 2) {
                                    oVar.dUs = eVar.field_path;
                                } else {
                                    com.tencent.mm.plugin.wenote.c.c.fK(eVar.field_path, oVar.dUs);
                                }
                                oVar.qPO = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, oVar);
                            }
                            if (5 == odVar.dUq.dUm) {
                                AppMethodBeat.o(30263);
                                return;
                            }
                            if (odVar.dUq.dUm == 4) {
                                aml bbP2 = dVar.bbP(eVar.field_dataId);
                                if (bbP2 == null) {
                                    Log.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                    i2 = 0;
                                } else {
                                    i2 = bbP2.duration;
                                }
                                odVar.dUq.dLu = i2;
                                dVar.JGS.get(str).dUs = eVar.field_path;
                                dVar.JGS.get(str).qPO = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, dVar.JGS.get(str));
                            }
                            Log.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", odVar.dUq.dUg, odVar.dUq.dUs);
                        }
                    } else {
                        Log.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                        if (dVar.JGO.dUt == -1) {
                            wVar = dVar.JGQ.get(Long.toString(dVar.JGO.msgId));
                        } else {
                            wVar = dVar.JGQ.get(Long.toString(dVar.JGO.dUt));
                        }
                        if (wVar == null) {
                            AppMethodBeat.o(30263);
                            return;
                        }
                        try {
                            wVar.qPT = s.boY(eVar.field_path);
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().bbU(wVar.qPT);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e2, "", new Object[0]);
                        }
                    }
                    dVar.JGR.remove(eVar.field_dataId);
                } else {
                    if (dVar.JGS.get(str).getType() == 2) {
                        dVar.JGS.get(str).dUs = eVar.field_path;
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(str, dVar.JGS.get(str));
                    dVar.JGR.remove(eVar.field_dataId);
                    AppMethodBeat.o(30263);
                    return;
                }
            }
        }
        AppMethodBeat.o(30263);
    }

    @Override // com.tencent.mm.plugin.record.a.d
    public final void a(int i2, j jVar) {
        AppMethodBeat.i(30262);
        e eVar = new e();
        eVar.field_localId = jVar.field_localId;
        eVar.field_dataId = jVar.field_dataId;
        eVar.field_status = jVar.field_status;
        eVar.field_offset = jVar.field_offset;
        eVar.field_totalLen = jVar.field_totalLen;
        eVar.field_path = jVar.field_path;
        a(eVar);
        AppMethodBeat.o(30262);
    }
}
