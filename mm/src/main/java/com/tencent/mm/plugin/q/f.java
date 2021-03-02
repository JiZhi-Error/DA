package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.i.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.plugin.q.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayOutputStream;
import java.util.LinkedList;

public final class f implements a.AbstractC1608a {
    private static f zGs;
    public int dSo;
    private c zGt;
    long zGu;
    boolean zGv = false;
    boolean zGw = false;

    public static f rr(boolean z) {
        AppMethodBeat.i(26530);
        if (zGs == null) {
            zGs = new f();
        } else if (z) {
            zGs.cancel();
            zGs = new f();
        }
        f fVar = zGs;
        AppMethodBeat.o(26530);
        return fVar;
    }

    public final void d(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(26531);
        Log.i("MicroMsg.MsgSynchronizeServer", "start, action:%s, extInfo:%s, loginDevice[%d]", str, str2, Integer.valueOf(this.dSo));
        if (this.zGw) {
            Log.e("MicroMsg.MsgSynchronizeServer", "synchronize has Started!!!!! reject! action:%s", str);
            AppMethodBeat.o(26531);
            return;
        }
        this.zGw = true;
        this.zGu = Util.nowMilliSecond();
        if (this.zGt != null) {
            this.zGt.zGa = true;
        }
        this.zGt = new c();
        d dVar = new d(str);
        dVar.zGg = bArr;
        if (str.equals(b.zFN)) {
            a(dVar, this.dSo);
            AppMethodBeat.o(26531);
            return;
        }
        bg.aVF();
        if (!((Boolean) c.azQ().get(ar.a.USERINFO_MSG_SYNCHRONIZE_BOOLEAN, Boolean.FALSE)).booleanValue()) {
            Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!User did not approve synchroinze!!!!");
            cancel();
            AppMethodBeat.o(26531);
            return;
        }
        String[] split = str2.split(",");
        if (!str.equals(b.zFO)) {
            if (str.equals(b.zFP)) {
                if (b.zFY <= 0) {
                    Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
                    cancel();
                    AppMethodBeat.o(26531);
                    return;
                } else if (split.length < 5) {
                    Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
                    cancel();
                    AppMethodBeat.o(26531);
                    return;
                } else {
                    dVar.aFv(split[3]);
                    a(dVar, split[0], g.agC(split[1]) * 1000, g.agC(split[2]) * 1000, g.cv(split[4], 0), this.dSo);
                }
            }
            AppMethodBeat.o(26531);
        } else if (b.zFX <= 0) {
            Log.e("MicroMsg.MsgSynchronizeServer", "start reject!!!Abtest reject synchroinze after sleep.");
            cancel();
            AppMethodBeat.o(26531);
        } else if (split.length < 2) {
            Log.e("MicroMsg.MsgSynchronizeServer", "start extinfo size wrong, action:%s, exinfo:%s", str, split);
            cancel();
            AppMethodBeat.o(26531);
        } else {
            a(dVar, g.agC(split[0]) * 1000, g.agC(split[1]) * 1000, this.dSo);
            AppMethodBeat.o(26531);
        }
    }

    private void a(d dVar, int i2) {
        long milliSecondsToNow;
        AppMethodBeat.i(26532);
        Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, loginDevice[%d]", Integer.valueOf(i2));
        h.INSTANCE.idkeyStat(466, 0, 1, false);
        d.cgP().cgS();
        this.zGt.zGb = this;
        LinkedList<c.a> elu = this.zGt.elu();
        Log.i("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize calculateConversationList finish. conversationList size:%d", Integer.valueOf(elu.size()));
        if (elu.size() == 0) {
            Log.e("MicroMsg.MsgSynchronizeServer", "startLoginSynchronize, No conversation to synchronize");
            cancel();
            long milliSecondsToNow2 = Util.milliSecondsToNow(this.zGu);
            h.INSTANCE.idkeyStat(466, 1, 1, false);
            h.INSTANCE.idkeyStat(466, 5, 0, false);
            h.INSTANCE.idkeyStat(466, 7, milliSecondsToNow2, false);
            h.INSTANCE.idkeyStat(466, 11, 0, false);
            h.INSTANCE.idkeyStat(466, 12, 0, false);
            b.l(milliSecondsToNow2, i2, 1);
            AppMethodBeat.o(26532);
            return;
        }
        if (b.zFW < 0) {
            milliSecondsToNow = (long) b.zFW;
        } else {
            milliSecondsToNow = Util.milliSecondsToNow((long) (b.zFW * 24 * 60 * 60 * 1000));
        }
        this.zGt.a(dVar, elu, milliSecondsToNow, System.currentTimeMillis(), b.zFU);
        AppMethodBeat.o(26532);
    }

    private void a(d dVar, long j2, long j3, int i2) {
        long milliSecondsToNow;
        long j4;
        AppMethodBeat.i(26533);
        Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, loginDevice[%d]", Integer.valueOf(i2));
        h.INSTANCE.idkeyStat(466, 15, 1, false);
        d.cgP().cgS();
        this.zGt.zGb = this;
        LinkedList<c.a> elu = this.zGt.elu();
        Log.i("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize getConversationList finish. conversationList size:%d", Integer.valueOf(elu.size()));
        if (elu.size() == 0) {
            Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize, No conversation to synchronize");
            cancel();
            long milliSecondsToNow2 = Util.milliSecondsToNow(this.zGu);
            h.INSTANCE.idkeyStat(466, 16, 1, false);
            h.INSTANCE.idkeyStat(466, 20, 0, false);
            h.INSTANCE.idkeyStat(466, 22, milliSecondsToNow2, false);
            h.INSTANCE.idkeyStat(466, 26, 0, false);
            h.INSTANCE.idkeyStat(466, 27, 0, false);
            b.l(milliSecondsToNow2, i2, 2);
            AppMethodBeat.o(26533);
            return;
        }
        if (b.zFW < 0) {
            milliSecondsToNow = (long) b.zFW;
        } else {
            milliSecondsToNow = Util.milliSecondsToNow((long) (b.zFW * 24 * 60 * 60 * 1000));
        }
        if (j2 >= milliSecondsToNow) {
            milliSecondsToNow = j2;
        }
        if (j3 == 0) {
            j4 = System.currentTimeMillis();
        } else {
            j4 = j3;
        }
        if (milliSecondsToNow > j4) {
            Log.e("MicroMsg.MsgSynchronizeServer", "startAfterSleepSynchronize no msg should be synchroinzed. startTime[%d], endTIme[%d]", Long.valueOf(milliSecondsToNow), Long.valueOf(j4));
            a(dVar, true);
            AppMethodBeat.o(26533);
            return;
        }
        this.zGt.a(dVar, elu, milliSecondsToNow, j4, b.zFU);
        AppMethodBeat.o(26533);
    }

    private void a(d dVar, String str, long j2, long j3, int i2, int i3) {
        AppMethodBeat.i(26534);
        Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, loginDevice[%d]", Integer.valueOf(i3));
        h.INSTANCE.idkeyStat(466, 31, 1, false);
        d.cgP().cgS();
        this.zGt.zGb = this;
        LinkedList<c.a> aFu = c.aFu(str);
        Log.i("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize addConversationList finish. conversationList size:%d", Integer.valueOf(aFu.size()));
        if (aFu.size() == 0) {
            Log.e("MicroMsg.MsgSynchronizeServer", "startGetMoreSynchronize, No conversation to synchronize");
            cancel();
            long milliSecondsToNow = Util.milliSecondsToNow(this.zGu);
            h.INSTANCE.idkeyStat(466, 32, 1, false);
            h.INSTANCE.idkeyStat(466, 36, 0, false);
            h.INSTANCE.idkeyStat(466, 38, milliSecondsToNow, false);
            h.INSTANCE.idkeyStat(466, 42, 0, false);
            h.INSTANCE.idkeyStat(466, 43, 0, false);
            b.l(milliSecondsToNow, i3, 3);
            AppMethodBeat.o(26534);
            return;
        }
        this.zGt.a(dVar, aFu, j2, j3, i2);
        AppMethodBeat.o(26534);
    }

    @Override // com.tencent.mm.plugin.q.a.AbstractC1608a
    public final void a(final d dVar, String str, int i2) {
        AppMethodBeat.i(26535);
        Log.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d, msgSyncSessionCount:%d, msgSyncMsgCount:%d, msgSyncMsgSize:%d", str, Integer.valueOf(i2), Long.valueOf(dVar.zGh), Long.valueOf(dVar.zGi), Long.valueOf(dVar.zGj));
        if (dVar.zGh > 0 || dVar.zGi > 0 || dVar.zGj > 0) {
            final AnonymousClass1 r2 = new bc() {
                /* class com.tencent.mm.plugin.q.f.AnonymousClass1 */

                @Override // com.tencent.mm.model.bc
                public final void aVw() {
                    AppMethodBeat.i(26527);
                    Log.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", Boolean.valueOf(f.this.zGv), Boolean.valueOf(com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS)));
                    if (f.this.zGv && com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS)) {
                        Log.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
                        bg.aVF();
                        com.tencent.mm.model.c.b(this);
                        f.this.zGv = false;
                        f.this.a(dVar, false);
                    }
                    AppMethodBeat.o(26527);
                }
            };
            AnonymousClass2 r3 = new g.a() {
                /* class com.tencent.mm.plugin.q.f.AnonymousClass2 */

                @Override // com.tencent.mm.i.g.a
                public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                    AppMethodBeat.i(26528);
                    Log.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
                    if (i2 == -21005) {
                        Log.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", str);
                        AppMethodBeat.o(26528);
                        return 0;
                    } else if (i2 != 0) {
                        Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", str, Integer.valueOf(i2));
                        f.this.cancel();
                        f.aFw(dVar.action);
                        b.a(0, 0, 0, 0, 1, f.this.dSo, dVar.action);
                        AppMethodBeat.o(26528);
                        return 0;
                    } else {
                        if (dVar != null) {
                            if (dVar.field_retCode != 0) {
                                Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", Integer.valueOf(dVar.field_retCode), dVar.field_arg, dVar.field_transInfo, str, dVar.field_filemd5);
                                f.aFw(dVar.action);
                                f.this.cancel();
                                b.a(0, 0, 0, 0, 1, f.this.dSo, dVar.action);
                            } else {
                                Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", str, dVar.field_filemd5, Integer.valueOf(dVar.field_UploadHitCacheType));
                                PByteArray pByteArray = new PByteArray();
                                if (!MMProtocalJni.rsaPublicEncryptPemkey(dVar.field_aesKey.getBytes(), pByteArray, dVar.zGg)) {
                                    Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                                    AppMethodBeat.o(26528);
                                    return -1;
                                }
                                String encodeHexString = Util.encodeHexString(pByteArray.value);
                                d dVar2 = dVar;
                                String str2 = dVar.field_fileId;
                                int i3 = (int) dVar.field_fileLength;
                                dVar2.zGm = new String(str2);
                                dVar2.zGn = new String(encodeHexString);
                                dVar2.zGo = i3;
                                if (com.tencent.mm.kernel.a.qd(com.tencent.mm.kernel.g.aAf().hpS)) {
                                    Log.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                                    f.this.a(dVar, false);
                                } else {
                                    Log.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                                    bg.aVF();
                                    com.tencent.mm.model.c.a(r2);
                                    f.this.zGv = true;
                                }
                            }
                        }
                        AppMethodBeat.o(26528);
                        return 0;
                    }
                }

                @Override // com.tencent.mm.i.g.a
                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                @Override // com.tencent.mm.i.g.a
                public final byte[] f(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            String str2 = "MSG_SYNCHRONIZE_" + i2 + "_" + Util.nowMilliSecond();
            com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
            gVar.taskName = "task_MsgSynchronizeServer";
            gVar.gqy = r3;
            gVar.field_mediaId = str2;
            gVar.field_fullpath = str;
            gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
            gVar.field_talker = (String) d.cgP().cgQ().azQ().get(2, (Object) null);
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            if (!com.tencent.mm.an.f.baQ().f(gVar)) {
                Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", str2);
                aFw(dVar.action);
                b.a(0, 0, 0, 0, 1, this.dSo, dVar.action);
            }
            AppMethodBeat.o(26535);
            return;
        }
        Log.i("MicroMsg.MsgSynchronizeServer", "no data should be synchronize");
        a(dVar, true);
        AppMethodBeat.o(26535);
    }

    static void aFw(String str) {
        AppMethodBeat.i(26536);
        if (str.equals(b.zFN)) {
            h.INSTANCE.idkeyStat(466, 2, 1, false);
            AppMethodBeat.o(26536);
        } else if (str.equals(b.zFO)) {
            h.INSTANCE.idkeyStat(466, 17, 1, false);
            AppMethodBeat.o(26536);
        } else {
            if (str.equals(b.zFP)) {
                h.INSTANCE.idkeyStat(466, 33, 1, false);
            }
            AppMethodBeat.o(26536);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(final d dVar, boolean z) {
        e eVar;
        AppMethodBeat.i(26537);
        Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg, isEmpty[%b].", Boolean.valueOf(z));
        bg.azz().a(TbsListener.ErrorCode.UNLZMA_FAIURE, new i() {
            /* class com.tencent.mm.plugin.q.f.AnonymousClass3 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(26529);
                bg.azz().b(TbsListener.ErrorCode.UNLZMA_FAIURE, this);
                if (i2 == 0 && i3 == 0) {
                    Log.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
                    com.tencent.mm.plugin.backup.b.g.agw(g.elw());
                    com.tencent.mm.plugin.backup.b.g.agw(g.elx());
                    f.this.zGw = false;
                    long milliSecondsToNow = Util.milliSecondsToNow(f.this.zGu);
                    if (dVar.action.equals(b.zFN)) {
                        h.INSTANCE.idkeyStat(466, 1, 1, false);
                        h.INSTANCE.idkeyStat(466, 5, dVar.zGj, false);
                        h.INSTANCE.idkeyStat(466, 7, milliSecondsToNow, false);
                        h.INSTANCE.idkeyStat(466, 11, dVar.zGi, false);
                        h.INSTANCE.idkeyStat(466, 12, dVar.zGh, false);
                    } else if (dVar.action.equals(b.zFO)) {
                        h.INSTANCE.idkeyStat(466, 16, 1, false);
                        h.INSTANCE.idkeyStat(466, 20, dVar.zGj, false);
                        h.INSTANCE.idkeyStat(466, 22, milliSecondsToNow, false);
                        h.INSTANCE.idkeyStat(466, 26, dVar.zGi, false);
                        h.INSTANCE.idkeyStat(466, 27, dVar.zGh, false);
                    } else if (dVar.action.equals(b.zFP)) {
                        h.INSTANCE.idkeyStat(466, 32, 1, false);
                        h.INSTANCE.idkeyStat(466, 36, dVar.zGj, false);
                        h.INSTANCE.idkeyStat(466, 38, milliSecondsToNow, false);
                        h.INSTANCE.idkeyStat(466, 42, dVar.zGi, false);
                        h.INSTANCE.idkeyStat(466, 43, dVar.zGh, false);
                    }
                    b.a(dVar.zGj, milliSecondsToNow, dVar.zGi, dVar.zGh, 0, f.this.dSo, dVar.action);
                    AppMethodBeat.o(26529);
                    return;
                }
                Log.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                f.this.cancel();
                if (dVar.action.equals(b.zFN)) {
                    h.INSTANCE.idkeyStat(466, 3, 1, false);
                } else if (dVar.action.equals(b.zFO)) {
                    h.INSTANCE.idkeyStat(466, 18, 1, false);
                } else if (dVar.action.equals(b.zFP)) {
                    h.INSTANCE.idkeyStat(466, 34, 1, false);
                }
                b.a(0, 0, 0, 0, 2, f.this.dSo, dVar.action);
                AppMethodBeat.o(26529);
            }
        });
        String str = "";
        if (dVar.action.equals(b.zFP)) {
            str = dVar.zGk + "," + dVar.zGl;
        }
        if (z) {
            eVar = new e("", "NULL", 0, dVar.gna, dVar.action, str);
        } else {
            eVar = new e(dVar.zGm, dVar.zGn, dVar.zGo, dVar.gna, dVar.action, str);
        }
        bg.azz().a(eVar, 0);
        AppMethodBeat.o(26537);
    }

    public final void cancel() {
        AppMethodBeat.i(26538);
        Log.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", MMStack.getCaller());
        this.zGt.zGa = true;
        this.zGw = false;
        AppMethodBeat.o(26538);
    }

    @Override // com.tencent.mm.plugin.q.a.AbstractC1608a
    public final void onCancel() {
        AppMethodBeat.i(26539);
        cancel();
        AppMethodBeat.o(26539);
    }
}
