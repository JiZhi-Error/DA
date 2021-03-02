package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.List;

public final class j extends i<com.tencent.mm.plugin.record.a.j> {
    private g.a iZc = new g.a() {
        /* class com.tencent.mm.plugin.record.b.j.AnonymousClass1 */

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, c cVar, final d dVar, boolean z) {
            AppMethodBeat.i(9492);
            Log.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", Integer.valueOf(i2), str);
            if (cVar != null) {
                Log.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", cVar.mediaId, Long.valueOf(cVar.field_toltalLength), Long.valueOf(cVar.field_finishedLength));
            }
            if (i2 == -21006 || i2 == -21005) {
                j.this.eIq();
                AppMethodBeat.o(9492);
                return 0;
            }
            final com.tencent.mm.plugin.record.a.j aKX = ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().aKX(str);
            if (aKX == null) {
                Log.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", str);
                j.this.eIq();
                AppMethodBeat.o(9492);
                return 0;
            }
            if (i2 != 0) {
                Log.w("MicroMsg.RecordMsgCDNService", "[record] tran fail, startRet[%d], mediaId[%s], type[%d]", Integer.valueOf(i2), str, Integer.valueOf(aKX.field_type));
                if (-5103059 == i2) {
                    aKX.field_status = 4;
                } else {
                    aKX.field_status = 3;
                }
                aKX.field_errCode = i2;
                ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
            } else {
                if (cVar != null) {
                    aKX.field_offset = (int) cVar.field_finishedLength;
                    aKX.field_totalLen = (int) cVar.field_toltalLength;
                    aKX.field_status = 1;
                    ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
                } else if (dVar != null) {
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(dVar.field_retCode);
                    objArr[1] = Integer.valueOf(dVar.field_UploadHitCacheType);
                    objArr[2] = Boolean.valueOf(z);
                    objArr[3] = Boolean.valueOf(dVar.field_exist_whencheck);
                    objArr[4] = Util.secPrint(dVar.field_aesKey);
                    objArr[5] = dVar.field_filemd5;
                    objArr[6] = str;
                    objArr[7] = Boolean.valueOf(1 == aKX.field_type);
                    Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s], mediaId:%s, isDownload:%b", objArr);
                    if (dVar.field_retCode >= 0) {
                        aKX.field_status = 2;
                        if (1 == aKX.field_type) {
                            String str2 = aKX.field_path + ".temp";
                            String str3 = aKX.field_path;
                            if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                                Log.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                            } else {
                                o oVar = new o(str2);
                                o oVar2 = new o(str3);
                                if (oVar.exists()) {
                                    Log.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(oVar.am(oVar2)), str2, oVar2);
                                }
                            }
                            ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().a(aKX, ch.COL_LOCALID);
                        } else {
                            Log.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", dVar.mediaId, str);
                            Log.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", dVar);
                            Log.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", dVar.field_aesKey, dVar.field_fileId);
                            if (dVar.alL()) {
                                Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", Boolean.valueOf(dVar.field_upload_by_safecdn), Integer.valueOf(dVar.field_UploadHitCacheType), Integer.valueOf(dVar.field_filecrc), dVar.field_aesKey, dVar.field_mp4identifymd5);
                                com.tencent.mm.kernel.g.aAg().hqi.a(new e(dVar.field_fileId, dVar.field_filemd5, dVar.field_mp4identifymd5, dVar.field_filecrc, new e.a() {
                                    /* class com.tencent.mm.plugin.record.b.j.AnonymousClass1.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.record.b.e.a
                                    public final void ax(String str, int i2, int i3) {
                                        AppMethodBeat.i(9491);
                                        Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                        if (i2 == 4 && i3 == 102) {
                                            Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", Integer.valueOf(aKX.field_status), Integer.valueOf(aKX.field_offset), Integer.valueOf(aKX.field_totalLen));
                                            aKX.field_offset = 0;
                                            aKX.field_totalLen = 0;
                                            aKX.field_status = 0;
                                            ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
                                            j.this.b(aKX, false);
                                            AppMethodBeat.o(9491);
                                            return;
                                        }
                                        aKX.field_cdnKey = str;
                                        aKX.field_cdnUrl = dVar.field_fileId;
                                        ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
                                        j.this.eIq();
                                        AppMethodBeat.o(9491);
                                    }
                                }), 0);
                                AppMethodBeat.o(9492);
                                return 0;
                            }
                            aKX.field_cdnKey = dVar.field_aesKey;
                            aKX.field_cdnUrl = dVar.field_fileId;
                            ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
                        }
                    } else {
                        Log.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", dVar.mediaId, Integer.valueOf(dVar.field_retCode));
                        if (-5103059 == dVar.field_retCode) {
                            aKX.field_status = 4;
                        } else {
                            aKX.field_status = 3;
                        }
                        aKX.field_errCode = dVar.field_retCode;
                        ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().b(aKX, ch.COL_LOCALID);
                    }
                }
                AppMethodBeat.o(9492);
                return 0;
            }
            j.this.eIq();
            AppMethodBeat.o(9492);
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    };

    public j() {
        AppMethodBeat.i(9493);
        AppMethodBeat.o(9493);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.record.b.i
    public final List<com.tencent.mm.plugin.record.a.j> eIp() {
        AppMethodBeat.i(9494);
        List<com.tencent.mm.plugin.record.a.j> eIk = ((a) com.tencent.mm.kernel.g.ah(a.class)).getRecordMsgCDNStorage().eIk();
        Log.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", Integer.valueOf(eIk.size()));
        AppMethodBeat.o(9494);
        return eIk;
    }

    /* access modifiers changed from: package-private */
    public final void b(com.tencent.mm.plugin.record.a.j jVar, boolean z) {
        AppMethodBeat.i(9495);
        Log.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", jVar.field_dataId, jVar.field_mediaId, Integer.valueOf(jVar.field_type), Integer.valueOf(jVar.field_status));
        if (-1 == jVar.field_status) {
            AppMethodBeat.o(9495);
            return;
        }
        g gVar = new g();
        gVar.taskName = "task_RecordMsgCDNService";
        gVar.gqy = this.iZc;
        gVar.field_mediaId = jVar.field_mediaId;
        if (2 == jVar.field_type) {
            gVar.ehd = true;
            gVar.field_priority = com.tencent.mm.i.a.gpL;
            gVar.field_needStorage = false;
            gVar.field_totalLen = jVar.field_totalLen;
            gVar.field_aesKey = jVar.field_cdnKey;
            gVar.field_fileId = jVar.field_cdnUrl;
            gVar.gqy = this.iZc;
            gVar.field_fullpath = jVar.field_path;
            gVar.field_fileType = jVar.field_fileType;
            gVar.field_talker = jVar.field_toUser;
            gVar.field_force_aeskeycdn = false;
            gVar.field_trysafecdn = true;
            gVar.field_enable_hitcheck = z;
            Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(gVar.field_force_aeskeycdn), Integer.valueOf(gVar.field_fileType), gVar.field_aesKey, gVar.field_fileId, Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), Boolean.valueOf(gVar.field_enable_hitcheck), gVar.field_mediaId);
            f.baQ().f(gVar);
        } else {
            gVar.ehd = false;
            gVar.field_priority = com.tencent.mm.i.a.gpM;
            gVar.field_needStorage = false;
            gVar.field_totalLen = jVar.field_totalLen;
            gVar.field_aesKey = jVar.field_cdnKey;
            gVar.field_fileId = jVar.field_cdnUrl;
            gVar.gqy = this.iZc;
            gVar.field_fullpath = jVar.field_path + ".temp";
            gVar.field_fileType = jVar.field_fileType;
            if (!Util.isNullOrNil(jVar.field_tpdataurl)) {
                gVar.field_fileType = 19;
                gVar.field_authKey = jVar.field_tpauthkey;
                gVar.field_aesKey = jVar.field_tpaeskey;
                gVar.gqB = jVar.field_tpdataurl;
                gVar.field_fileId = "";
            }
            Log.i("MicroMsg.RecordMsgCDNService", "[record] summersafecdn doJob TYPE_DOWNLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b], mediaId:%s", Boolean.valueOf(gVar.field_force_aeskeycdn), Integer.valueOf(gVar.field_fileType), gVar.field_aesKey, gVar.field_fileId, Boolean.valueOf(gVar.field_force_aeskeycdn), Boolean.valueOf(gVar.field_trysafecdn), Boolean.valueOf(gVar.field_enable_hitcheck), gVar.field_mediaId);
            f.baQ().b(gVar, -1);
        }
        Log.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", Boolean.valueOf(gVar.ehd), Integer.valueOf(gVar.field_totalLen), gVar.field_aesKey, gVar.field_fileId, gVar.field_fullpath, Integer.valueOf(gVar.field_fileType), Boolean.valueOf(gVar.field_enable_hitcheck), Boolean.valueOf(gVar.field_force_aeskeycdn));
        AppMethodBeat.o(9495);
    }

    @Override // com.tencent.mm.plugin.record.a.b
    public final void a(com.tencent.mm.plugin.record.a.c cVar) {
        AppMethodBeat.i(9496);
        if (cVar instanceof com.tencent.mm.plugin.record.a.j) {
            b((com.tencent.mm.plugin.record.a.j) cVar, true);
        }
        AppMethodBeat.o(9496);
    }
}
