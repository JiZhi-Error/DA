package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.q;
import com.tencent.mm.bb.v;
import com.tencent.mm.g.a.df;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class d implements i {
    private static d yoA = null;
    private boolean gYQ = false;
    private int retryCount = 0;
    IListener yoB = new IListener<df>() {
        /* class com.tencent.mm.plugin.ipcall.model.d.AnonymousClass1 */

        {
            AppMethodBeat.i(161379);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(161379);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(25348);
            boolean a2 = a(dfVar);
            AppMethodBeat.o(25348);
            return a2;
        }

        private boolean a(df dfVar) {
            AppMethodBeat.i(25347);
            if (dfVar instanceof df) {
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "detect DynamicConfigUpdatedEvent");
                bg.aVF();
                int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, (Object) 0)).intValue();
                int i2 = h.aqJ().getInt("WeChatOutCountryCodeRestrictionPackageID", 0);
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "oldConfig: %d, newConfig: %d", Integer.valueOf(intValue), Integer.valueOf(i2));
                if (intValue != i2) {
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(i2));
                    v.bev().tI(26);
                    c ead = c.ead();
                    String str = b.aKB() + "ipcallCountryCodeConfig.cfg";
                    Log.d("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, path: %s", str);
                    try {
                        o oVar = new o(str);
                        if (oVar.exists()) {
                            oVar.delete();
                        }
                        ead.isInit = false;
                        ead.yoz.clear();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.IPCallCountryCodeConfig", "deleteRestrictionCountryConfigIfExist, error: %s", e2.getMessage());
                    }
                    d.this.qo(true);
                }
            }
            AppMethodBeat.o(25347);
            return false;
        }
    };

    private d() {
        AppMethodBeat.i(25349);
        AppMethodBeat.o(25349);
    }

    public static d eah() {
        AppMethodBeat.i(25350);
        if (yoA == null) {
            yoA = new d();
        }
        d dVar = yoA;
        AppMethodBeat.o(25350);
        return dVar;
    }

    public final void qo(boolean z) {
        AppMethodBeat.i(25351);
        if (!bg.aAc()) {
            Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
            AppMethodBeat.o(25351);
        } else if (this.gYQ) {
            Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
            AppMethodBeat.o(25351);
        } else {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", Boolean.valueOf(z));
            if (!z) {
                bg.aVF();
                long longValue = ((Long) c.azQ().get(ar.a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, (Object) 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < Util.MILLSECONDS_OF_DAY) {
                    Log.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    AppMethodBeat.o(25351);
                    return;
                }
            }
            Log.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.gYQ = true;
            bg.azz().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
            bg.azz().a(160, this);
            eai();
            AppMethodBeat.o(25351);
        }
    }

    private static void eai() {
        boolean z;
        AppMethodBeat.i(25352);
        q[] tJ = v.bev().tJ(26);
        if (tJ == null || tJ.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        bg.azz().a(new n(z), 0);
        AppMethodBeat.o(25352);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(25353);
        Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.gYQ));
        if (!this.gYQ) {
            AppMethodBeat.o(25353);
            return;
        }
        if (i2 == 0 || i3 == 0) {
            z = true;
        } else {
            z = false;
        }
        Log.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", Boolean.valueOf(z));
        if (qVar.getType() != 159) {
            if (qVar.getType() == 160 && z) {
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.ead().qn(true);
                eaj();
            }
            AppMethodBeat.o(25353);
        } else if (z) {
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
            q[] tJ = v.bev().tJ(26);
            if (tJ == null || tJ.length == 0) {
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                eaj();
                AppMethodBeat.o(25353);
                return;
            }
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", Integer.valueOf(tJ.length));
            q qVar2 = tJ[0];
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", Integer.valueOf(qVar2.dMe), Integer.valueOf(qVar2.id), Integer.valueOf(qVar2.version), Integer.valueOf(qVar2.status), qVar2.beq());
            if (qVar2.status == 3) {
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                AppMethodBeat.o(25353);
            } else if (qVar2.status != 5) {
                Log.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                c.ead().qn(true);
                eaj();
                AppMethodBeat.o(25353);
            } else {
                bg.azz().a(new m(qVar2.id, 26), 0);
                AppMethodBeat.o(25353);
            }
        } else if (this.retryCount < 3) {
            this.retryCount++;
            eai();
            Log.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", Integer.valueOf(this.retryCount));
            AppMethodBeat.o(25353);
        } else {
            Log.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
            AppMethodBeat.o(25353);
        }
    }

    private void eaj() {
        AppMethodBeat.i(25354);
        this.gYQ = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_IPCALL_COUNTRY_CODE_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(25354);
    }
}
