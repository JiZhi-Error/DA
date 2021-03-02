package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.a;
import com.tencent.mm.plugin.shake.d.a.m;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends l.b {
    public static j DiY;
    public static boolean iCs = false;
    public a DiX = new a();
    private boolean isActive = false;
    private long ofl;

    static /* synthetic */ void a(j jVar, List list) {
        AppMethodBeat.i(28315);
        jVar.g(list, 4);
        AppMethodBeat.o(28315);
    }

    public static j a(l.a aVar) {
        AppMethodBeat.i(28309);
        if (DiY == null || DiY.DgX == null) {
            DiY = new j(aVar);
        }
        j jVar = DiY;
        AppMethodBeat.o(28309);
        return jVar;
    }

    private j(l.a aVar) {
        super(aVar);
        AppMethodBeat.i(28310);
        AppMethodBeat.o(28310);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void init() {
        AppMethodBeat.i(28312);
        if (!iCs) {
            if (!this.DiX.eUM()) {
                Log.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
                AppMethodBeat.o(28312);
                return;
            }
            iCs = true;
        }
        AppMethodBeat.o(28312);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void eTQ() {
        AppMethodBeat.i(28313);
        this.DiX.ZZ();
        super.eTQ();
        AppMethodBeat.o(28313);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void resume() {
    }

    private void g(List<d> list, long j2) {
        AppMethodBeat.i(28314);
        if (this.DgX != null) {
            this.DgX.f(list, j2);
        }
        AppMethodBeat.o(28314);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void start() {
        AppMethodBeat.i(28311);
        if (this.DgX == null) {
            Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            AppMethodBeat.o(28311);
            return;
        }
        this.ofl = System.currentTimeMillis();
        this.DiX.a(367, new a.AbstractC1691a() {
            /* class com.tencent.mm.plugin.shake.d.a.j.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.shake.d.a.a.AbstractC1691a
            public final void b(dpc dpc, long j2, boolean z) {
                long currentTimeMillis;
                boolean e2;
                AppMethodBeat.i(28308);
                if (j.this.DgX == null) {
                    Log.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                    AppMethodBeat.o(28308);
                    return;
                }
                dwz dwz = (dwz) dpc;
                if (dwz == null) {
                    Log.w("Micromsg.ShakeMusicMgr", "resp null & return");
                    j.a(j.this, new ArrayList());
                    AppMethodBeat.o(28308);
                } else if (dwz.MRg == 1) {
                    if (j2 > j.this.ofl) {
                        currentTimeMillis = System.currentTimeMillis() - j2;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - j.this.ofl;
                    }
                    if (dwz != null && !Util.isNullOrNil(dwz.MXf)) {
                        Log.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", Integer.valueOf(dwz.MXe), dwz.MXf);
                        String str = dwz.MXf;
                        if (str != null) {
                            str = str.trim();
                        }
                        switch (dwz.MXe) {
                            case 0:
                                e2 = j.a(j.this, str);
                                break;
                            case 1:
                                e2 = j.b(j.this, str);
                                break;
                            case 2:
                                e2 = j.c(j.this, str);
                                break;
                            case 3:
                                e2 = j.d(j.this, str);
                                break;
                            case 4:
                                e2 = j.e(j.this, str);
                                break;
                            default:
                                Log.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + dwz.MXe);
                                j.a(j.this, new ArrayList());
                                e2 = false;
                                break;
                        }
                        if (e2) {
                            h.INSTANCE.a(10987, 1, "", 1, Integer.valueOf((int) (System.currentTimeMillis() - j.this.ofl)));
                            h.INSTANCE.n(835, 0, 1);
                            AppMethodBeat.o(28308);
                            return;
                        }
                        h.INSTANCE.a(10987, 1, "", 5, Long.valueOf(currentTimeMillis));
                        h.INSTANCE.n(835, 4, 1);
                        AppMethodBeat.o(28308);
                    } else if (z) {
                        j.a(j.this, new ArrayList());
                        h.INSTANCE.a(10987, 1, "", 4, Integer.valueOf((int) currentTimeMillis));
                        h.INSTANCE.n(835, 3, 1);
                        AppMethodBeat.o(28308);
                    } else {
                        j.a(j.this, new ArrayList());
                        h.INSTANCE.a(10987, 1, "", 3, Integer.valueOf((int) currentTimeMillis));
                        h.INSTANCE.n(835, 2, 1);
                        AppMethodBeat.o(28308);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (dwz != null) {
                        d dVar = new d();
                        if (!(dwz.MXa == null || dwz.MXa.getBuffer() == null)) {
                            dVar.field_username = dwz.MXa.getBuffer().yO();
                        }
                        if (!(dwz.MWZ == null || dwz.MWZ.getBuffer() == null)) {
                            dVar.field_nickname = dwz.MWZ.getBuffer().yO();
                        }
                        if (!(dwz.MXa == null || dwz.MXa.getBuffer() == null)) {
                            dVar.field_distance = dwz.MXa.getBuffer().yO();
                        }
                        if (!(dwz.LZX == null || dwz.LZX.getBuffer() == null)) {
                            dVar.field_sns_bgurl = dwz.LZX.getBuffer().yO();
                        }
                        dVar.field_type = 4;
                        dVar.field_insertBatch = 1;
                        try {
                            dVar.field_lvbuffer = dwz.toByteArray();
                        } catch (IOException e3) {
                            Log.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", e3.getLocalizedMessage());
                        }
                        m.eUm().a(dVar, true);
                        arrayList.add(dVar);
                    }
                    j.this.DgX.f(arrayList, j2);
                    AppMethodBeat.o(28308);
                }
            }
        });
        AppMethodBeat.o(28311);
    }

    static /* synthetic */ boolean a(j jVar, String str) {
        AppMethodBeat.i(28316);
        ArrayList arrayList = new ArrayList();
        m.e aNr = m.e.aNr(str);
        if (aNr == null || aNr.link == null) {
            Log.w("Micromsg.ShakeMusicMgr", "parse url fail");
            jVar.g(arrayList, 4);
            AppMethodBeat.o(28316);
            return false;
        }
        Log.d("Micromsg.ShakeMusicMgr", "parse url: link=" + aNr.link + ", title=" + aNr.title + ", thumburl=" + aNr.thumbUrl);
        d dVar = new d();
        dVar.field_username = aNr.link;
        dVar.field_nickname = aNr.title;
        dVar.field_distance = aNr.dVu;
        dVar.field_sns_bgurl = aNr.thumbUrl;
        dVar.field_type = 7;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        jVar.g(arrayList, 1);
        AppMethodBeat.o(28316);
        return true;
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        AppMethodBeat.i(28317);
        m.f aNs = m.f.aNs(str);
        ArrayList arrayList = new ArrayList();
        if (aNs == null || aNs.userName == null) {
            Log.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.g(arrayList, 4);
            AppMethodBeat.o(28317);
            return false;
        }
        Log.d("Micromsg.ShakeMusicMgr", "parse user: username=" + aNs.userName + ", nickname=" + aNs.nickName + ", showchat=" + aNs.Dje);
        d dVar = new d();
        dVar.field_username = aNs.userName;
        dVar.field_nickname = aNs.nickName;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = aNs.Dje;
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        jVar.g(arrayList, 1);
        AppMethodBeat.o(28317);
        return true;
    }

    static /* synthetic */ boolean c(j jVar, String str) {
        boolean z = true;
        AppMethodBeat.i(28318);
        ArrayList arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("Micromsg.ShakeMusicMgr", "wrong args, xml == null ? [%s]", objArr);
            jVar.g(arrayList, 2);
            AppMethodBeat.o(28318);
            return false;
        }
        c.a aNu = c.aNu(str);
        if (aNu == null) {
            Log.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
            jVar.g(arrayList, 4);
            AppMethodBeat.o(28318);
            return false;
        }
        d dVar = new d();
        dVar.field_username = Util.nullAsNil(aNu.field_subtitle);
        dVar.field_nickname = Util.nullAsNil(aNu.field_topic);
        dVar.field_distance = Util.nullAsNil(aNu.field_title);
        if (aNu.field_thumburl != null) {
            dVar.field_sns_bgurl = aNu.field_thumburl;
        }
        dVar.field_type = 8;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        dVar.field_reserved2 = (int) Util.nowSecond();
        arrayList.add(dVar);
        d eUa = com.tencent.mm.plugin.shake.b.m.eUm().eUa();
        if (eUa.field_type == 8 && dVar.field_distance.equals(eUa.field_distance) && dVar.field_nickname.equals(eUa.field_nickname) && dVar.field_reserved2 - eUa.field_reserved2 < 1800) {
            Log.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + eUa.field_reserved2);
            com.tencent.mm.plugin.shake.b.m.eUm().Xu(eUa.field_shakeItemID);
        }
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        jVar.g(arrayList, 1);
        Log.d("Micromsg.ShakeMusicMgr", "process get tv OK");
        AppMethodBeat.o(28318);
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        AppMethodBeat.i(28319);
        ArrayList arrayList = new ArrayList();
        m.b aNo = m.b.aNo(str);
        if (aNo == null || aNo.Djc == null) {
            Log.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.g(arrayList, 4);
            AppMethodBeat.o(28319);
            return false;
        }
        Log.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + aNo.Djc + ", title=" + aNo.title + ", thumbUrl=" + aNo.thumbUrl);
        d dVar = new d();
        dVar.field_username = aNo.Djc;
        dVar.field_nickname = aNo.title;
        dVar.field_sns_bgurl = aNo.thumbUrl;
        dVar.field_distance = aNo.price;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        jVar.g(arrayList, 1);
        AppMethodBeat.o(28319);
        return true;
    }

    static /* synthetic */ boolean e(j jVar, String str) {
        AppMethodBeat.i(28320);
        ArrayList arrayList = new ArrayList();
        m.c aNp = m.c.aNp(str);
        if (aNp == null || aNp.id == null) {
            Log.w("Micromsg.ShakeMusicMgr", "parse product fail");
            jVar.g(arrayList, 4);
            AppMethodBeat.o(28320);
            return false;
        }
        Log.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + aNp.id + ", title=" + aNp.title + ", thumbUrl=" + aNp.thumbUrl);
        d dVar = new d();
        dVar.field_username = aNp.id;
        dVar.field_nickname = aNp.title;
        dVar.field_sns_bgurl = aNp.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        jVar.g(arrayList, 1);
        AppMethodBeat.o(28320);
        return true;
    }
}
