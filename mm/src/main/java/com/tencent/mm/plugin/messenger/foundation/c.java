package com.tencent.mm.plugin.messenger.foundation;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ap.a;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cl;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.x;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class c implements x {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.messenger.foundation.a.x
    public final void a(abn abn, byte[] bArr, boolean z, aa aaVar) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(116876);
        switch (abn.Lms) {
            case 5:
                de deVar = (de) new de().parseFrom(bArr);
                if (deVar != null) {
                    h.a aVar = new h.a(deVar, false, false, false);
                    processAddMsg(aVar, aaVar);
                    if (!aVar.iLV) {
                        bq aVU = bq.aVU();
                        String a2 = z.a(deVar.KHl);
                        long j2 = deVar.Brn;
                        long j3 = ((long) deVar.CreateTime) * 1000;
                        int i2 = deVar.xKb;
                        if (a2 != null) {
                            try {
                                String aTY = com.tencent.mm.model.z.aTY();
                                if (aTY == null || !aTY.equals(a2)) {
                                    as Kn = ((l) g.af(l.class)).aSN().Kn(a2);
                                    if (a2.endsWith("@chatroom")) {
                                        if (Kn.fuH == 0) {
                                            AppMethodBeat.o(116876);
                                            return;
                                        }
                                        Log.i("MicroMsg.MsgReporter", "it is a normal chatroom? username:%s", a2);
                                    } else if (ab.Jz(a2) || as.bjm(a2) || as.bjo(a2) || ab.Jv(a2) || as.IG(a2) || Kn.gBM()) {
                                        AppMethodBeat.o(116876);
                                        return;
                                    }
                                    long aWy = cl.aWy();
                                    if (aWy <= 0) {
                                        Log.i("MicroMsg.MsgReporter", "current server time is 0l,then return");
                                        AppMethodBeat.o(116876);
                                        return;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long j4 = aWy - j3;
                                    Log.i("MicroMsg.MsgReporter", "current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", Long.valueOf(aWy), Long.valueOf(j3), Long.valueOf(j4), a2, Long.valueOf(j2), Integer.valueOf(i2));
                                    boolean Au = a.Au(j3);
                                    if (Au) {
                                        e.INSTANCE.idkeyStat(780, 100, 1, false);
                                    } else {
                                        e.INSTANCE.idkeyStat(780, 101, 1, false);
                                    }
                                    boolean z4 = false;
                                    boolean z5 = false;
                                    if (Au) {
                                        if (aWy - aVU.iEU[11] >= Util.MILLSECONDS_OF_DAY) {
                                            e.INSTANCE.idkeyStat(780, 210, 1, false);
                                            aVU.iEU[11] = aWy;
                                            z4 = true;
                                        }
                                    } else if (aWy - aVU.iEV[11] >= Util.MILLSECONDS_OF_DAY) {
                                        e.INSTANCE.idkeyStat(780, 211, 1, false);
                                        aVU.iEV[11] = aWy;
                                        z5 = true;
                                    }
                                    int length = bq.iEO.length - 1;
                                    while (true) {
                                        if (length < 0) {
                                            z2 = z5;
                                        } else if (j4 >= bq.iEO[length]) {
                                            if (Au) {
                                                e.INSTANCE.idkeyStat(780, (long) bq.iEP[length], 1, false);
                                            } else {
                                                e.INSTANCE.idkeyStat(780, (long) bq.iEQ[length], 1, false);
                                            }
                                            if (Au) {
                                                if (aWy - aVU.iEU[length] >= Util.MILLSECONDS_OF_DAY) {
                                                    e.INSTANCE.idkeyStat(780, (long) bq.iER[length], 1, false);
                                                    aVU.iEU[length] = aWy;
                                                    z3 = true;
                                                }
                                                z3 = z4;
                                            } else {
                                                if (aWy - aVU.iEV[length] >= Util.MILLSECONDS_OF_DAY) {
                                                    e.INSTANCE.idkeyStat(780, (long) bq.iES[length], 1, false);
                                                    aVU.iEV[length] = aWy;
                                                    z5 = true;
                                                    z3 = z4;
                                                }
                                                z3 = z4;
                                            }
                                            if (j4 < 2000) {
                                                z2 = z5;
                                                z4 = z3;
                                            } else if (Au) {
                                                a.b(length, aWy, currentTimeMillis, j3, j4, j2, a2, i2);
                                                z2 = z5;
                                                z4 = z3;
                                            } else {
                                                a.a(length, aWy, currentTimeMillis, j3, j4, j2, a2, i2);
                                                z2 = z5;
                                                z4 = z3;
                                            }
                                        } else {
                                            length--;
                                        }
                                    }
                                    if (z4) {
                                        StringBuilder sb = new StringBuilder();
                                        for (int i3 = 0; i3 < aVU.iEU.length; i3++) {
                                            if (Util.isEqual(i3, aVU.iEU.length - 1)) {
                                                sb.append(aVU.iEU[i3]);
                                            } else {
                                                sb.append(aVU.iEU[i3] + ",");
                                            }
                                        }
                                        g.aAh().azQ().set(ar.a.USERINFO_FOREGROUND_DELAY_REPORT_LAST_TIMESTAMP_STRING_SYNC, sb.toString());
                                    }
                                    if (z2) {
                                        StringBuilder sb2 = new StringBuilder();
                                        for (int i4 = 0; i4 < aVU.iEV.length; i4++) {
                                            if (Util.isEqual(i4, aVU.iEV.length - 1)) {
                                                sb2.append(aVU.iEV[i4]);
                                            } else {
                                                sb2.append(aVU.iEV[i4] + ",");
                                            }
                                        }
                                        g.aAh().azQ().set(ar.a.USERINFO_BACKGROUND_DELAY_REPORT_LAST_TIMESTAMP_STRING_SYNC, sb2.toString());
                                    }
                                    switch (i2) {
                                        case 1:
                                            if (j4 >= Util.MILLSECONDS_OF_MINUTE) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 113, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 118, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 30000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 112, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 117, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 10000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 111, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 116, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 0) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 110, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 115, 1, false);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (j4 >= Util.MILLSECONDS_OF_MINUTE) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 133, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 138, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 30000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 132, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 137, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 10000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 131, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 136, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 0) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 130, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 135, 1, false);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 34:
                                            if (j4 >= Util.MILLSECONDS_OF_MINUTE) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 123, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 128, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 30000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 122, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 127, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 10000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 121, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 126, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 0) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 120, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 125, 1, false);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 43:
                                            if (j4 >= Util.MILLSECONDS_OF_MINUTE) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 153, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 158, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 30000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 152, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 157, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 10000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 151, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 156, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 0) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 150, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 155, 1, false);
                                                    break;
                                                }
                                            }
                                            break;
                                        case 47:
                                            if (j4 >= Util.MILLSECONDS_OF_MINUTE) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 143, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 148, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 30000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 142, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 147, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 10000) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 141, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 146, 1, false);
                                                    break;
                                                }
                                            } else if (j4 >= 0) {
                                                if (Au) {
                                                    e.INSTANCE.idkeyStat(780, 140, 1, false);
                                                    break;
                                                } else {
                                                    e.INSTANCE.idkeyStat(780, 145, 1, false);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                    int i5 = Au ? 1 : 2;
                                    int i6 = 0;
                                    switch (i2) {
                                        case 1:
                                            i6 = 1;
                                            break;
                                        case 3:
                                            i6 = 3;
                                            break;
                                        case 34:
                                            i6 = 2;
                                            break;
                                        case 37:
                                            i6 = 8;
                                            break;
                                        case 43:
                                            i6 = 5;
                                            break;
                                        case 47:
                                            i6 = 4;
                                            break;
                                        case 49:
                                            i6 = 6;
                                            break;
                                        case 50:
                                            i6 = 7;
                                            break;
                                    }
                                    String str = "";
                                    try {
                                        str = Build.MANUFACTURER;
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.MsgReporter", "kvReport %s %s", e2.getClass().getSimpleName(), e2.getMessage());
                                    }
                                    e.INSTANCE.a(17828, Integer.valueOf(i5), Long.valueOf(j4), Integer.valueOf(i6), Long.valueOf(j2), str);
                                } else {
                                    AppMethodBeat.o(116876);
                                    return;
                                }
                            } catch (Exception e3) {
                                Log.e("MicroMsg.MsgReporter", "something about contact has exception:%s", e3.getMessage());
                                AppMethodBeat.o(116876);
                                return;
                            }
                        }
                    }
                }
                AppMethodBeat.o(116876);
                return;
            case 8:
                afk afk = (afk) new afk().parseFrom(bArr);
                bp.ak(z.a(afk.Lqk), afk.Lqn);
                AppMethodBeat.o(116876);
                return;
            case 9:
                afr afr = (afr) new afr().parseFrom(bArr);
                LinkedList<Integer> linkedList = afr.Lqq;
                for (int i7 = 0; i7 < linkedList.size(); i7++) {
                    bp.D(z.a(afr.Lqk), (long) linkedList.get(i7).intValue());
                }
                break;
        }
        AppMethodBeat.o(116876);
    }

    public static h.b processAddMsg(h.a aVar, aa aaVar) {
        AppMethodBeat.i(116877);
        de deVar = aVar.heO;
        if (10008 == ac.jOC && ac.jOD != 0) {
            Log.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(deVar.Brn), Integer.valueOf(ac.jOD));
            deVar.Brn = (long) ac.jOD;
            ac.jOD = 0;
        }
        if (((l) g.af(l.class)).eiy().Hd(deVar.Brn)) {
            Log.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            AppMethodBeat.o(116877);
            return null;
        }
        String a2 = z.a(deVar.KHl);
        String a3 = z.a(deVar.KHm);
        if (!a2.equals(com.tencent.mm.model.z.aTY()) || !a3.equals("newsapp") || deVar.xKb == 51) {
            Log.i("MicroMsg.MessageSyncExtension", "dkAddMsg from:%s to:%s id:[%d,%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s", a2, a3, Long.valueOf(deVar.Brn), Integer.valueOf(deVar.Brl), Integer.valueOf(deVar.KHs), Integer.valueOf(deVar.oTW), Integer.valueOf(deVar.xKb), Integer.valueOf(deVar.CreateTime), Util.formatUnixTime((long) deVar.CreateTime), Long.valueOf(Util.nowSecond() - ((long) deVar.CreateTime)), Integer.valueOf(deVar.KHo), Integer.valueOf(z.a(deVar.KHp, new byte[0]).length), Integer.valueOf(Util.nullAsNil(deVar.KHq).length()), Integer.valueOf(Util.nullAsNil(deVar.KHr).length()), Util.secPrint(z.a(deVar.KHn, "")));
            Log.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", deVar.KHq, "");
            com.tencent.mm.plugin.messenger.foundation.a.ab.k(deVar);
            if (a2.equals("readerapp")) {
                deVar.KHl = z.Su("newsapp");
                deVar.xKb = 12399999;
            }
            if ((a2.equals("blogapp") || a2.equals("newsapp")) && deVar.xKb != 10002) {
                deVar.xKb = 12399999;
            }
            if (deVar.xKb == 52) {
                deVar.xKb = 1000052;
            }
            if (deVar.xKb == 53) {
                deVar.xKb = 1000053;
            }
            bp.c(aVar);
            boolean z = false;
            h.b bVar = null;
            h ck = h.d.ck(Integer.valueOf(deVar.xKb));
            if (ck == null) {
                ck = h.d.ck(a2);
            }
            if (ck != null) {
                bVar = ck.b(aVar);
                ca caVar = bVar == null ? null : bVar.dCM;
                if (caVar == null) {
                    Log.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", Integer.valueOf(deVar.xKb), Long.valueOf(deVar.Brn), Integer.valueOf(deVar.KHs), Integer.valueOf(deVar.CreateTime), aVar);
                } else if (!aDY(a2)) {
                    Log.d("MicroMsg.MessageSyncExtension", " msg , id =" + caVar.field_msgId + "  " + aaVar);
                    if (caVar.field_msgId > 0 && aaVar != null && bVar.iMb) {
                        aaVar.a(caVar, deVar);
                    }
                }
                z = true;
            }
            com.tencent.mm.plugin.messenger.foundation.a.ab.b(5, deVar);
            if (!z) {
                Log.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(deVar.xKb));
            }
            AppMethodBeat.o(116877);
            return bVar;
        }
        Log.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(deVar.Brn), Integer.valueOf(deVar.xKb));
        AppMethodBeat.o(116877);
        return null;
    }

    private static boolean aDY(String str) {
        AppMethodBeat.i(116878);
        if (!ab.IX(str) || b.isOverseasUser()) {
            AppMethodBeat.o(116878);
            return false;
        }
        AppMethodBeat.o(116878);
        return true;
    }
}
