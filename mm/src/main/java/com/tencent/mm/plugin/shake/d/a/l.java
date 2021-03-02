package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.a;
import com.tencent.mm.plugin.shake.d.a.m;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends l.b {
    private static boolean iCs = false;
    private static boolean isRunning = false;
    private a DiX = new a();
    private Context context;
    private boolean isActive = false;
    private long ofl;

    static /* synthetic */ void a(l lVar, List list) {
        AppMethodBeat.i(28340);
        lVar.g(list, 4);
        AppMethodBeat.o(28340);
    }

    public l(Context context2, l.a aVar) {
        super(aVar);
        AppMethodBeat.i(28327);
        this.context = context2;
        isRunning = false;
        AppMethodBeat.o(28327);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void init() {
        AppMethodBeat.i(28329);
        if (!iCs) {
            if (!this.DiX.eUM()) {
                Log.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
                AppMethodBeat.o(28329);
                return;
            }
            iCs = true;
        }
        AppMethodBeat.o(28329);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void pause() {
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void eTQ() {
        AppMethodBeat.i(28330);
        super.eTQ();
        this.DiX.ZZ();
        if (isRunning) {
            long currentTimeMillis = System.currentTimeMillis() - this.ofl;
            Log.d("Micromsg.ShakeTVService", "a%s, isRunning=%s", Long.valueOf(currentTimeMillis), Boolean.valueOf(isRunning));
            h.INSTANCE.a(10987, 1, "", 2, Integer.valueOf((int) currentTimeMillis));
            h.INSTANCE.n(835, 1, 1);
            isRunning = false;
        }
        AppMethodBeat.o(28330);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void resume() {
    }

    private void g(List<d> list, long j2) {
        AppMethodBeat.i(28331);
        if (this.DgX != null) {
            this.DgX.f(list, j2);
        }
        AppMethodBeat.o(28331);
    }

    @Override // com.tencent.mm.plugin.shake.b.l.b
    public final void start() {
        AppMethodBeat.i(28328);
        Log.v("Micromsg.ShakeTVService", "hy: start shake tv!");
        if (this.DgX == null) {
            Log.w("Micromsg.ShakeTVService", "shakeGetListener == null");
            AppMethodBeat.o(28328);
        } else if (!(this.context instanceof Activity)) {
            Log.e("Micromsg.ShakeTVService", "context not an Activity");
            this.DgX.f(new ArrayList(), 0);
            AppMethodBeat.o(28328);
        } else {
            isRunning = true;
            this.ofl = System.currentTimeMillis();
            this.DiX.a(408, new a.AbstractC1691a() {
                /* class com.tencent.mm.plugin.shake.d.a.l.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.shake.d.a.a.AbstractC1691a
                public final void b(dpc dpc, long j2, boolean z) {
                    long currentTimeMillis;
                    boolean g2;
                    AppMethodBeat.i(28326);
                    Log.i("Micromsg.ShakeTVService", "hy: shake tv call back. isNetworkFail; %b", Boolean.valueOf(z));
                    if (j2 > l.this.ofl) {
                        currentTimeMillis = System.currentTimeMillis() - j2;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - l.this.ofl;
                    }
                    if (dpc != null && !Util.isNullOrNil(((dxd) dpc).MbV)) {
                        dxd dxd = (dxd) dpc;
                        Log.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", Integer.valueOf(dxd.oUv), dxd.MbV);
                        String str = null;
                        String str2 = null;
                        if (dxd.MbV != null) {
                            dxd.MbV = dxd.MbV.trim();
                            int indexOf = dxd.MbV.indexOf("<tvinfo>");
                            if (indexOf > 0) {
                                str = dxd.MbV.substring(0, indexOf);
                                str2 = dxd.MbV.substring(indexOf);
                            } else if (indexOf == 0) {
                                str2 = dxd.MbV;
                            } else {
                                str = dxd.MbV;
                            }
                        }
                        l.aNm(str2);
                        switch (dxd.oUv) {
                            case 0:
                                g2 = l.a(l.this, str);
                                break;
                            case 1:
                                g2 = l.b(l.this, str);
                                break;
                            case 2:
                                g2 = l.c(l.this, str);
                                break;
                            case 3:
                                g2 = l.d(l.this, str);
                                break;
                            case 4:
                                g2 = l.e(l.this, str);
                                break;
                            case 5:
                                g2 = l.f(l.this, str);
                                break;
                            case 6:
                                g2 = l.g(l.this, str);
                                break;
                            default:
                                Log.w("Micromsg.ShakeTVService", "parse unknown type:" + dxd.oUv);
                                l.a(l.this, new ArrayList());
                                g2 = false;
                                break;
                        }
                        if (g2) {
                            h.INSTANCE.a(10987, 1, "", 1, Integer.valueOf((int) (System.currentTimeMillis() - l.this.ofl)));
                            h.INSTANCE.n(835, 0, 1);
                        } else {
                            h.INSTANCE.a(10987, 1, "", 5, Long.valueOf(currentTimeMillis));
                            h.INSTANCE.n(835, 4, 1);
                        }
                    } else if (z) {
                        l.a(l.this, new ArrayList());
                        h.INSTANCE.a(10987, 1, "", 4, Integer.valueOf((int) currentTimeMillis));
                        h.INSTANCE.n(835, 3, 1);
                    } else {
                        l.a(l.this, new ArrayList());
                        h.INSTANCE.a(10987, 1, "", 3, Integer.valueOf((int) currentTimeMillis));
                        h.INSTANCE.n(835, 2, 1);
                    }
                    boolean unused = l.isRunning = false;
                    AppMethodBeat.o(28326);
                }
            });
            h.INSTANCE.n(835, 5, 1);
            AppMethodBeat.o(28328);
        }
    }

    static /* synthetic */ void aNm(String str) {
        n nVar;
        n nVar2;
        n nVar3 = null;
        AppMethodBeat.i(28332);
        if (Util.isNullOrNil(str)) {
            nVar2 = null;
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "tvinfo", null);
            if (parseXml != null) {
                String str2 = parseXml.get(".tvinfo.username");
                if (Util.isNullOrNil(str2)) {
                    nVar2 = null;
                } else {
                    n nVar4 = new n();
                    nVar4.field_username = str2;
                    nVar4.field_iconurl = Util.nullAsNil(parseXml.get(".tvinfo.iconurl"));
                    nVar4.field_title = Util.nullAsNil(parseXml.get(".tvinfo.title"));
                    nVar4.field_deeplink = Util.nullAsNil(parseXml.get(".tvinfo.deeplinkjumpurl"));
                    nVar4.field_createtime = Util.getLong(parseXml.get(".tvinfo.createtime"), 0);
                    nVar = nVar4;
                }
            } else {
                nVar = null;
            }
            nVar2 = nVar;
        }
        if (nVar2 != null) {
            o eUo = m.eUo();
            String str3 = nVar2.field_username;
            Cursor query = eUo.db.query("shaketvhistory", null, "username=?", new String[]{str3}, null, null, null, 2);
            if (!query.moveToFirst()) {
                Log.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:".concat(String.valueOf(str3)));
                query.close();
            } else {
                nVar3 = new n();
                nVar3.convertFrom(query);
                query.close();
            }
            if (nVar3 != null) {
                Log.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                o eUo2 = m.eUo();
                String str4 = nVar2.field_username;
                if (Util.isNullOrNil(str4)) {
                    Log.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    AppMethodBeat.o(28332);
                    return;
                }
                eUo2.db.update("shaketvhistory", nVar2.convertTo(), "username=?", new String[]{str4});
                AppMethodBeat.o(28332);
                return;
            }
            Log.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            m.eUo().insert(nVar2);
        }
        AppMethodBeat.o(28332);
    }

    static /* synthetic */ boolean a(l lVar, String str) {
        AppMethodBeat.i(28333);
        ArrayList arrayList = new ArrayList();
        m.e aNr = m.e.aNr(str);
        if (aNr == null || aNr.link == null) {
            Log.w("Micromsg.ShakeTVService", "parse url fail");
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28333);
            return false;
        }
        Log.d("Micromsg.ShakeTVService", "parse url: link=" + aNr.link + ", title=" + aNr.title + ", thumburl=" + aNr.thumbUrl);
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
        lVar.g(arrayList, 1);
        AppMethodBeat.o(28333);
        return true;
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        AppMethodBeat.i(28334);
        m.f aNs = m.f.aNs(str);
        ArrayList arrayList = new ArrayList();
        if (aNs == null || aNs.userName == null) {
            Log.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28334);
            return false;
        }
        Log.d("Micromsg.ShakeTVService", "parse user: username=" + aNs.userName + ", nickname=" + aNs.nickName + ", showchat=" + aNs.Dje);
        d dVar = new d();
        dVar.field_username = aNs.userName;
        dVar.field_nickname = aNs.nickName;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = aNs.Dje;
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        lVar.g(arrayList, 1);
        AppMethodBeat.o(28334);
        return true;
    }

    static /* synthetic */ boolean c(l lVar, String str) {
        boolean z = true;
        AppMethodBeat.i(28335);
        ArrayList arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.e("Micromsg.ShakeTVService", "wrong args, xml == null ? [%s]", objArr);
            lVar.g(arrayList, 2);
            AppMethodBeat.o(28335);
            return false;
        }
        c.a aNu = c.aNu(str);
        if (aNu == null) {
            Log.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
            isRunning = false;
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28335);
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
            Log.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + eUa.field_reserved2);
            com.tencent.mm.plugin.shake.b.m.eUm().Xu(eUa.field_shakeItemID);
        }
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        lVar.g(arrayList, 1);
        Log.d("Micromsg.ShakeTVService", "process get tv OK");
        AppMethodBeat.o(28335);
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        AppMethodBeat.i(28336);
        ArrayList arrayList = new ArrayList();
        m.b aNo = m.b.aNo(str);
        if (aNo == null || aNo.Djc == null) {
            Log.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28336);
            return false;
        }
        Log.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + aNo.Djc + ", title=" + aNo.title + ", thumbUrl=" + aNo.thumbUrl);
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
        lVar.g(arrayList, 1);
        AppMethodBeat.o(28336);
        return true;
    }

    static /* synthetic */ boolean e(l lVar, String str) {
        AppMethodBeat.i(28337);
        ArrayList arrayList = new ArrayList();
        m.c aNp = m.c.aNp(str);
        if (aNp == null || aNp.id == null) {
            Log.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28337);
            return false;
        }
        Log.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + aNp.id + ", title=" + aNp.title + ", thumbUrl=" + aNp.thumbUrl);
        d dVar = new d();
        dVar.field_username = aNp.id;
        dVar.field_nickname = aNp.title;
        dVar.field_sns_bgurl = aNp.thumbUrl;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        lVar.g(arrayList, 1);
        AppMethodBeat.o(28337);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        AppMethodBeat.i(28338);
        ArrayList arrayList = new ArrayList();
        m.d aNq = m.d.aNq(str);
        if (aNq == null || Util.isNullOrNil(aNq.Djd)) {
            Log.w("Micromsg.ShakeTVService", "parse TempSession fail");
            lVar.g(arrayList, 4);
            AppMethodBeat.o(28338);
            return false;
        }
        d dVar = new d();
        dVar.field_username = aNq.Djd;
        dVar.field_nickname = aNq.title;
        dVar.field_distance = aNq.username;
        dVar.field_sns_bgurl = aNq.thumbUrl;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
        arrayList.add(dVar);
        lVar.g(arrayList, 1);
        AppMethodBeat.o(28338);
        return true;
    }

    static /* synthetic */ boolean g(l lVar, String str) {
        AppMethodBeat.i(28339);
        ArrayList arrayList = new ArrayList();
        m.a aNn = m.a.aNn(str);
        if (aNn != null) {
            d dVar = new d();
            dVar.field_username = aNn.username;
            dVar.field_nickname = aNn.title;
            dVar.field_reserved3 = aNn.path;
            dVar.field_sns_bgurl = aNn.thumbUrl;
            dVar.field_reserved2 = aNn.version;
            dVar.field_type = 13;
            dVar.field_insertBatch = 1;
            dVar.field_lvbuffer = str.getBytes();
            com.tencent.mm.plugin.shake.b.m.eUm().a(dVar, true);
            arrayList.add(dVar);
            lVar.g(arrayList, 1);
            AppMethodBeat.o(28339);
            return true;
        }
        Log.w("Micromsg.ShakeTVService", "parse appBrand fail");
        lVar.g(arrayList, 4);
        AppMethodBeat.o(28339);
        return false;
    }
}
