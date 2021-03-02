package com.tencent.mm.plugin.music.model.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.j;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamResponse;
import com.tencent.mm.plugin.music.model.a.a.a;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements com.tencent.mm.plugin.music.cache.c {
    @Override // com.tencent.mm.plugin.music.cache.c
    public final boolean etG() {
        AppMethodBeat.i(63064);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_open_mix_audio, 0);
        Log.i("MicroMsg.PieceDataSourceService", "open_mix_audio:%d", Integer.valueOf(a2));
        if (a2 == 1) {
            AppMethodBeat.o(63064);
            return true;
        }
        AppMethodBeat.o(63064);
        return false;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final boolean etD() {
        AppMethodBeat.i(63048);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, null, a.j.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(63048);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(63048);
        return z;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final int etE() {
        AppMethodBeat.i(63049);
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCInteger(3), a.f.class);
        if (iPCInteger == null) {
            AppMethodBeat.o(63049);
            return 3;
        }
        int i2 = iPCInteger.value;
        AppMethodBeat.o(63049);
        return i2;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final String getAccPath() {
        AppMethodBeat.i(63050);
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, null, a.b.class);
        if (iPCString == null) {
            AppMethodBeat.o(63050);
            return null;
        }
        String str = iPCString.value;
        AppMethodBeat.o(63050);
        return str;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final String aHr(String str) {
        AppMethodBeat.i(63051);
        String aHr = b.aHr(str);
        AppMethodBeat.o(63051);
        return aHr;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final long etF() {
        AppMethodBeat.i(63052);
        IPCLong iPCLong = (IPCLong) XIPCInvoker.a(MainProcessIPCService.dkO, null, a.c.class);
        if (iPCLong == null) {
            AppMethodBeat.o(63052);
            return 0;
        }
        long j2 = iPCLong.value;
        AppMethodBeat.o(63052);
        return j2;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void Hn(long j2) {
        AppMethodBeat.i(63053);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCLong(j2), a.h.class);
        AppMethodBeat.o(63053);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final j aHs(String str) {
        AppMethodBeat.i(63054);
        IPCAudioParamResponse iPCAudioParamResponse = (IPCAudioParamResponse) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.e.class);
        if (iPCAudioParamResponse != null) {
            j jVar = new j();
            jVar.dSF = iPCAudioParamResponse.dSF;
            jVar.musicUrl = iPCAudioParamResponse.musicUrl;
            jVar.fileName = iPCAudioParamResponse.fileName;
            jVar.jfB = iPCAudioParamResponse.jfB;
            jVar.jfC = iPCAudioParamResponse.jfC;
            jVar.jfA = iPCAudioParamResponse.jfA;
            jVar.jfD = iPCAudioParamResponse.jfD;
            AppMethodBeat.o(63054);
            return jVar;
        }
        AppMethodBeat.o(63054);
        return null;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final String aHt(String str) {
        AppMethodBeat.i(63055);
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.l.class);
        if (iPCString == null) {
            String aId = com.tencent.mm.plugin.music.h.b.aId(str);
            AppMethodBeat.o(63055);
            return aId;
        }
        String str2 = iPCString.value;
        AppMethodBeat.o(63055);
        return str2;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void aHu(String str) {
        AppMethodBeat.i(63056);
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.C1536a.class);
        AppMethodBeat.o(63056);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void t(String str, byte[] bArr) {
        AppMethodBeat.i(63057);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.dSF = str;
        iPCAudioParamRequest.jfA = bArr;
        XIPCInvoker.a(MainProcessIPCService.dkO, iPCAudioParamRequest, a.k.class);
        AppMethodBeat.o(63057);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void eS(String str, int i2) {
        AppMethodBeat.i(63058);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.dSF = str;
        iPCAudioParamRequest.AiS = i2;
        XIPCInvoker.a(MainProcessIPCService.dkO, iPCAudioParamRequest, a.m.class);
        AppMethodBeat.o(63058);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void iU(String str, String str2) {
        AppMethodBeat.i(63059);
        IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
        iPCAudioParamRequest.dSF = str;
        iPCAudioParamRequest.mimeType = str2;
        XIPCInvoker.a(MainProcessIPCService.dkO, iPCAudioParamRequest, a.i.class);
        AppMethodBeat.o(63059);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final String aHv(String str) {
        AppMethodBeat.i(63060);
        IPCString iPCString = (IPCString) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.d.class);
        if (iPCString == null) {
            AppMethodBeat.o(63060);
            return null;
        }
        String str2 = iPCString.value;
        AppMethodBeat.o(63060);
        return str2;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final com.tencent.mm.plugin.music.c.a aHw(String str) {
        AppMethodBeat.i(63061);
        com.tencent.mm.plugin.music.model.e.a aHW = o.euD().aHW(com.tencent.mm.plugin.music.model.a.a.b.aHT(str));
        com.tencent.mm.plugin.music.c.a aVar = new com.tencent.mm.plugin.music.c.a();
        if (aHW != null) {
            aVar.AiV = aHW.field_wifiDownloadedLength;
            aVar.AiX = aHW.field_songWifiFileLength;
            aVar.AiW = aHW.field_wifiEndFlag;
            aVar.AiT = aHW.field_downloadedLength;
            aVar.AiU = aHW.field_songFileLength;
            aVar.endFlag = aHW.field_endFlag;
            aVar.mimeType = aHW.field_mimetype;
        }
        AppMethodBeat.o(63061);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void a(String str, com.tencent.mm.plugin.music.c.a aVar) {
        AppMethodBeat.i(63062);
        String aHT = com.tencent.mm.plugin.music.model.a.a.b.aHT(str);
        com.tencent.mm.plugin.music.model.e.b euD = o.euD();
        long j2 = aVar.AiV;
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j2));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", Integer.valueOf(euD.db.update("Music", contentValues, "musicId=?", new String[]{aHT})), aHT, Long.valueOf(j2));
        com.tencent.mm.plugin.music.model.e.a aVar2 = euD.AlG.get(aHT);
        if (aVar2 != null) {
            aVar2.field_wifiDownloadedLength = j2;
        }
        com.tencent.mm.plugin.music.model.e.b euD2 = o.euD();
        int i2 = aVar.AiW;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("wifiEndFlag", Integer.valueOf(i2));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", Integer.valueOf(euD2.db.update("Music", contentValues2, "musicId=?", new String[]{aHT})), aHT, Integer.valueOf(i2));
        com.tencent.mm.plugin.music.model.e.a aVar3 = euD2.AlG.get(aHT);
        if (aVar3 != null) {
            aVar3.field_wifiEndFlag = i2;
        }
        com.tencent.mm.plugin.music.model.e.b euD3 = o.euD();
        long j3 = aVar.AiX;
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("songWifiFileLength", Long.valueOf(j3));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", Integer.valueOf(euD3.db.update("Music", contentValues3, "musicId=?", new String[]{aHT})), aHT, Long.valueOf(j3));
        com.tencent.mm.plugin.music.model.e.a aVar4 = euD3.AlG.get(aHT);
        if (aVar4 != null) {
            aVar4.field_songWifiFileLength = j3;
        }
        com.tencent.mm.plugin.music.model.e.b euD4 = o.euD();
        long j4 = aVar.AiT;
        ContentValues contentValues4 = new ContentValues();
        contentValues4.put("downloadedLength", Long.valueOf(j4));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", Integer.valueOf(euD4.db.update("Music", contentValues4, "musicId=?", new String[]{aHT})), aHT, Long.valueOf(j4));
        com.tencent.mm.plugin.music.model.e.a aVar5 = euD4.AlG.get(aHT);
        if (aVar5 != null) {
            aVar5.field_downloadedLength = j4;
        }
        com.tencent.mm.plugin.music.model.e.b euD5 = o.euD();
        int i3 = aVar.endFlag;
        ContentValues contentValues5 = new ContentValues();
        contentValues5.put("endFlag", Integer.valueOf(i3));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", Integer.valueOf(euD5.db.update("Music", contentValues5, "musicId=?", new String[]{aHT})), aHT, Integer.valueOf(i3));
        com.tencent.mm.plugin.music.model.e.a aVar6 = euD5.AlG.get(aHT);
        if (aVar6 != null) {
            aVar6.field_endFlag = i3;
        }
        com.tencent.mm.plugin.music.model.e.b euD6 = o.euD();
        long j5 = aVar.AiU;
        ContentValues contentValues6 = new ContentValues();
        contentValues6.put("songFileLength", Long.valueOf(j5));
        Log.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", Integer.valueOf(euD6.db.update("Music", contentValues6, "musicId=?", new String[]{aHT})), aHT, Long.valueOf(j5));
        com.tencent.mm.plugin.music.model.e.a aVar7 = euD6.AlG.get(aHT);
        if (aVar7 != null) {
            aVar7.field_songFileLength = j5;
        }
        AppMethodBeat.o(63062);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final void iV(String str, String str2) {
        AppMethodBeat.i(63063);
        String aHT = com.tencent.mm.plugin.music.model.a.a.b.aHT(str);
        com.tencent.mm.plugin.music.model.e.b euD = o.euD();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", str2);
        euD.db.update("Music", contentValues, "musicId=?", new String[]{aHT});
        com.tencent.mm.plugin.music.model.e.a aVar = euD.AlG.get(aHT);
        if (aVar != null) {
            aVar.field_mimetype = str2;
        }
        AppMethodBeat.o(63063);
    }

    @Override // com.tencent.mm.plugin.music.cache.c
    public final boolean etH() {
        AppMethodBeat.i(63065);
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a(MainProcessIPCService.dkO, null, a.g.class);
        if (iPCBoolean == null) {
            AppMethodBeat.o(63065);
            return false;
        }
        boolean z = iPCBoolean.value;
        AppMethodBeat.o(63065);
        return z;
    }
}
