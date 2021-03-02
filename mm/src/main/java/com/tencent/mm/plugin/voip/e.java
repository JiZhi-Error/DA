package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.protocal.protobuf.ett;
import com.tencent.mm.q.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class e extends IListener<zj> {
    public e() {
        AppMethodBeat.i(161652);
        this.__eventId = zj.class.getName().hashCode();
        AppMethodBeat.o(161652);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(zj zjVar) {
        AppMethodBeat.i(114812);
        boolean a2 = a(zjVar);
        AppMethodBeat.o(114812);
        return a2;
    }

    private static boolean a(zj zjVar) {
        boolean z = true;
        AppMethodBeat.i(114811);
        if (zjVar instanceof zj) {
            if (g.aAc()) {
                switch (zjVar.efx.dKy) {
                    case 1:
                        c.fFg();
                        p.a aUy = u.aUy(zjVar.efx.content);
                        if (aUy != null) {
                            if (!aUy.fGY()) {
                                if (aUy.GXQ != p.a.GXX) {
                                    z = false;
                                }
                                if (z) {
                                    zjVar.efy.type = 3;
                                    break;
                                }
                            } else {
                                zjVar.efy.type = 2;
                                break;
                            }
                        }
                        break;
                    case 2:
                        zjVar.efy.calling = c.fFg().dya;
                        break;
                    case 3:
                        u fFg = c.fFg();
                        byte[] bArr = zjVar.efx.efs;
                        if (bArr != null && bArr.length >= 10 && bArr[0] == 1) {
                            byte[] bArr2 = new byte[(bArr.length - 1)];
                            System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
                            o oVar = fFg.GYS.GSZ.GVV.Hcw;
                            oVar.GXI = System.currentTimeMillis();
                            com.tencent.mm.plugin.voip.b.e.Logd("MicroMsg.VoipDailReport", "devin:recvInvite:" + oVar.GXI);
                            try {
                                ett ett = (ett) new ett().parseFrom(bArr2);
                                Log.i("MicroMsg.Voip.VoipService", "doTaskCallin in onInviteNotify, roomid:%d, roomkey:%s, time:%d", Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.CreateTime));
                                if (!fFg.GZm) {
                                    com.tencent.mm.plugin.voip.b.e.c(ett.LsZ, ett.Lta, 1, 2);
                                    fFg.GZm = true;
                                }
                                if (fFg.GYS.fIq()) {
                                    h.INSTANCE.a(11523, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 0, Long.valueOf(System.currentTimeMillis()));
                                    break;
                                } else {
                                    h.INSTANCE.a(11523, true, true, Integer.valueOf(ett.LsZ), Long.valueOf(ett.Lta), Integer.valueOf(ett.NqJ), 0, Long.valueOf(System.currentTimeMillis()));
                                    fFg.c(ett);
                                    break;
                                }
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.Voip.VoipService", e2, "", new Object[0]);
                                break;
                            }
                        }
                    case 4:
                        zj.b bVar = zjVar.efy;
                        u fFg2 = c.fFg();
                        Context context = MMApplicationContext.getContext();
                        if (fFg2.dya && fFg2.GZh && !fFg2.GZi) {
                            Log.d("MicroMsg.Voip.VoipService", "isVideoCalling " + fFg2.GYU + " isAudioCalling " + fFg2.GYV);
                            if (!Util.isNullOrNil(fFg2.talker) && ((l) g.af(l.class)).aSN().Kn(fFg2.talker) != null) {
                                fFg2.a(context, fFg2.talker, fFg2.GYS.GSZ.GVV.ypH, true, fFg2.GYU, true);
                                bVar.efz = z;
                                break;
                            }
                        }
                        z = false;
                        bVar.efz = z;
                    case 5:
                        if (!a.att()) {
                            if (!a.cB(zjVar.efx.context)) {
                                if (zjVar.efx.eft != 2) {
                                    if (zjVar.efx.eft != 3) {
                                        if (zjVar.efx.eft == 4) {
                                            s.bJ(zjVar.efx.context, zjVar.efx.talker);
                                            break;
                                        }
                                    } else {
                                        s.bI(zjVar.efx.context, zjVar.efx.talker);
                                        break;
                                    }
                                } else {
                                    s.bH(zjVar.efx.context, zjVar.efx.talker);
                                    break;
                                }
                            }
                        } else {
                            com.tencent.mm.ui.base.h.n(zjVar.efx.context, R.string.i3d, R.string.zb);
                            break;
                        }
                        break;
                    case 6:
                        u fFg3 = c.fFg();
                        byte[] bArr3 = zjVar.efx.efs;
                        if (bArr3 != null) {
                            Log.i("MicroMsg.Voip.VoipService", "____voipNotify with data size:" + bArr3.length);
                            int i2 = ByteBuffer.wrap(bArr3, 0, 4).getInt();
                            long j2 = ByteBuffer.wrap(bArr3, 4, 8).getLong();
                            Log.i("MicroMsg.Voip.VoipService", "voipNotify roomid:" + i2 + " roomkey:" + j2);
                            if (fFg3.GZk == null) {
                                v vVar = fFg3.GYS;
                                Log.i("MicroMsg.Voip.VoipServiceEx", "current roomid:%d, params roomid:%d", Integer.valueOf(vVar.GSZ.GVV.roomId), Integer.valueOf(i2));
                                if (i2 == 0 || vVar.GSZ.GVV.roomId != i2) {
                                    z = false;
                                }
                                if (!z) {
                                    Log.e("MicroMsg.Voip.VoipService", "voipSyncStatus ignored , not current roomid");
                                    break;
                                }
                            }
                            if (bArr3.length > 12) {
                                fFg3.b(u.ae(bArr3, bArr3.length - 12), i2, j2);
                            }
                            v vVar2 = fFg3.GYS;
                            com.tencent.mm.plugin.voip.b.e.Logi("MicroMsg.Voip.VoipServiceEx", f.apq() + " need doSync by notify, status:" + vVar2.GSZ.mStatus);
                            vVar2.GSZ.GVY.a(null, false, 7);
                            break;
                        } else {
                            Log.i("MicroMsg.Voip.VoipService", "sidney:notify content null");
                            break;
                        }
                    case 9:
                        u fFg4 = c.fFg();
                        byte[] bArr4 = zjVar.efx.efs;
                        if (!Util.isNullOrNil(bArr4) && bArr4[0] == 3) {
                            try {
                                Log.i("MicroMsg.Voip.VoipService", "onCancelNotify");
                                byte[] bArr5 = new byte[(bArr4.length - 1)];
                                System.arraycopy(bArr4, 1, bArr5, 0, bArr5.length);
                                ett ett2 = new ett();
                                ett2.parseFrom(bArr5);
                                fFg4.adm(ett2.LsZ);
                                if (fFg4.GZk != null && ett2.LsZ == fFg4.GZk.LsZ && !fFg4.zNd.stopped()) {
                                    fFg4.GZk = null;
                                    fFg4.GZl = 0;
                                    fFg4.zNd.stopTimer();
                                }
                                v vVar3 = fFg4.GYS;
                                Log.i("MicroMsg.Voip.VoipServiceEx", "onCancelInviteNotify, roomId: %s", Integer.valueOf(ett2.LsZ));
                                if (vVar3.GSZ.GWa != null && ett2.LsZ == vVar3.GSZ.GWa.LsZ) {
                                    vVar3.fIy();
                                    vVar3.GSZ.shutdown();
                                    break;
                                }
                            } catch (Exception e3) {
                                Log.e("MicroMsg.Voip.VoipService", "onCancelNotify error: %s", e3.getMessage());
                                break;
                            }
                        }
                    case 10:
                        u fFg5 = c.fFg();
                        byte[] bArr6 = zjVar.efx.efs;
                        if (!Util.isNullOrNil(bArr6) && bArr6[0] == 2) {
                            try {
                                Log.i("MicroMsg.Voip.VoipService", "onAnswerNotify");
                                byte[] bArr7 = new byte[(bArr6.length - 1)];
                                System.arraycopy(bArr6, 1, bArr7, 0, bArr7.length);
                                ett ett3 = new ett();
                                ett3.parseFrom(bArr7);
                                v vVar4 = fFg5.GYS;
                                Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, roomId: %s", Integer.valueOf(ett3.LsZ));
                                if (ett3.LsZ == vVar4.GSZ.GWa.LsZ) {
                                    if (!vVar4.GSZ.dWM) {
                                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, not accept, hangout");
                                        vVar4.fIy();
                                        vVar4.GSZ.shutdown();
                                        break;
                                    } else {
                                        Log.i("MicroMsg.Voip.VoipServiceEx", "onAnswerNotify, already accept, ignore it");
                                        break;
                                    }
                                }
                            } catch (Exception e4) {
                                Log.e("MicroMsg.Voip.VoipService", "onAnswerNotify error: %s", e4.getMessage());
                                break;
                            }
                        }
                        break;
                }
            } else {
                AppMethodBeat.o(114811);
                return false;
            }
        }
        AppMethodBeat.o(114811);
        return false;
    }
}
