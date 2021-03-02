package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;

public final class a extends IListener<oc> {
    public a() {
        AppMethodBeat.i(161476);
        this.__eventId = oc.class.getName().hashCode();
        AppMethodBeat.o(161476);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(oc ocVar) {
        AppMethodBeat.i(30259);
        boolean a2 = a(ocVar);
        AppMethodBeat.o(30259);
        return a2;
    }

    private static boolean a(oc ocVar) {
        boolean z;
        AppMethodBeat.i(30258);
        switch (ocVar.dUe.type) {
            case 0:
                c.gjz().JGL.b(ocVar);
                break;
            case 2:
                EventCenter.instance.publish(new gy((byte) 0));
                g gVar = new g();
                gVar.JGY = com.tencent.mm.plugin.wenote.b.a.a(ocVar.dUe);
                gVar.JGZ = 1;
                c.gjz().JGL = gVar;
                if (ocVar.dUe.dUn == 4) {
                    h.INSTANCE.a(14789, 4);
                    Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    Context context = ocVar.dUe.context;
                    anb anb = ocVar.dUe.field_favProto;
                    Bundle bundle = ocVar.dUe.dUl;
                    boolean z2 = ocVar.dUe.dUo;
                    String str = "";
                    String str2 = "";
                    long j2 = 0;
                    if (bundle != null) {
                        str = bundle.getString("noteauthor", "");
                        str2 = bundle.getString("noteeditor", "");
                        j2 = bundle.getLong("edittime", 0);
                        gVar.JHa = bundle.getString("snslocalid");
                        gVar.JHb = bundle.getString("notexml", "");
                        gVar.JHj = bundle.getByteArray("key_multi_task_common_info");
                        gVar.JHh = bundle.getString("snsthumbpath", "");
                        gVar.JHi = bundle.getString("snsnotelinkxml", "");
                    }
                    gVar.dUt = System.currentTimeMillis();
                    gVar.dUo = z2;
                    gVar.JGV = false;
                    gVar.JHe = str + ";" + str2 + ";" + j2;
                    gVar.aw(context, 4);
                    bg.aAk().postToWorker(new Runnable(anb) {
                        /* class com.tencent.mm.plugin.wenote.model.g.AnonymousClass1 */
                        final /* synthetic */ anb JHl;

                        {
                            this.JHl = r2;
                        }

                        public final void run() {
                            AppMethodBeat.i(30309);
                            com.tencent.mm.plugin.fav.a.g gVar = new com.tencent.mm.plugin.fav.a.g();
                            gVar.field_localId = g.this.dUt;
                            gVar.field_favProto = this.JHl;
                            g.this.JGW = gVar.field_favProto;
                            g.this.JGP = gVar;
                            g.this.tfP = gVar;
                            if (g.JHc.containsKey(g.this.tfP)) {
                                g.this.JGO = (m) g.JHc.get(g.this.tfP);
                            } else {
                                g.c(g.this);
                            }
                            g.this.iq(g.this.JGO.BHs);
                            if (k.gjR() != null) {
                                k.gjV();
                            }
                            AppMethodBeat.o(30309);
                        }

                        public final String toString() {
                            AppMethodBeat.i(30310);
                            String str = super.toString() + "|dealWNoteInfo";
                            AppMethodBeat.o(30310);
                            return str;
                        }
                    });
                    break;
                } else {
                    h.INSTANCE.a(14789, 1);
                    Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                    if (ocVar.dUe.dUn == 5) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!(ocVar.dUe.field_favProto == null || ocVar.dUe.field_favProto.Lya == null)) {
                        gVar.JHf = ocVar.dUe.field_favProto.Lya.sourceType;
                    }
                    if (ocVar.dUe.dUl != null) {
                        gVar.JHg = ocVar.dUe.dUl.getLong("edittime", 0);
                        gVar.JHj = ocVar.dUe.dUl.getByteArray("key_multi_task_common_info");
                    }
                    if (!z) {
                        gVar.a(ocVar.dUe.field_localId, ocVar.dUe.context, Boolean.valueOf(ocVar.dUe.dUo), ocVar.dUe.dUh, 0, ocVar.dUe.dUp, null, gVar.JHj);
                        break;
                    } else {
                        gVar.JHk = true;
                        gVar.a(ocVar.dUe.field_localId, ocVar.dUe.context, Boolean.valueOf(ocVar.dUe.dUo), 0, 0, ocVar.dUe.dUp, ocVar.dUe.field_favProto, gVar.JHj);
                        break;
                    }
                }
            case 3:
                ocVar.dUf.path = ao.cVh();
                break;
            case 7:
                switch (ocVar.dUe.dUm) {
                    case 2:
                        com.tencent.mm.plugin.wenote.model.h.bf(ocVar.dUe.lj);
                        break;
                    case 3:
                        try {
                            com.tencent.mm.plugin.wenote.model.h.bbS(ocVar.dUe.dUi);
                            break;
                        } catch (JSONException e2) {
                            Log.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e2, "", new Object[0]);
                            break;
                        }
                    case 4:
                        com.tencent.mm.plugin.wenote.model.h.p(ocVar.dUe.context, ocVar.dUe.path, ocVar.dUe.dUn);
                        break;
                    case 5:
                        com.tencent.mm.plugin.wenote.model.h.bbR(ocVar.dUe.path);
                        break;
                }
            case 8:
                com.tencent.mm.plugin.wenote.model.h.cb(ocVar.dUe.context, ocVar.dUe.path);
                break;
            case 9:
                Log.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                g gVar2 = new g();
                gVar2.JGY = com.tencent.mm.plugin.wenote.b.a.a(ocVar.dUe);
                gVar2.JGZ = 1;
                gVar2.dUt = ocVar.dUe.field_localId;
                c.gjz().JGL = gVar2;
                Context context2 = ocVar.dUe.context;
                gVar2.JGV = true;
                gVar2.aw(context2, 2);
                break;
            case 10:
                f.O(ocVar.dUe.field_localId, ocVar.dUe.path);
                break;
            case 11:
                f.be(ocVar.dUe.lj);
                break;
            case 12:
                EventCenter.instance.publish(new gy((byte) 0));
                bg.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.wenote.model.nativenote.manager.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(30407);
                        Log.i("MicroMsg.Note.NoteDataManager", "NoteDataManager onDestroy");
                        c.this.cDp();
                        c.this.JId = null;
                        c.this.qQq = null;
                        c.this.qQr = 0;
                        c unused = c.JIc = null;
                        AppMethodBeat.o(30407);
                    }
                }, 700);
                break;
        }
        AppMethodBeat.o(30258);
        return false;
    }
}
