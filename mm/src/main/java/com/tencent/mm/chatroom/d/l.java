package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.chatroom.storage.a;
import com.tencent.mm.chatroom.storage.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.dps;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storagebase.h;
import com.tencent.smtt.sdk.TbsListener;

public final class l extends q implements m {
    private i callback;
    public String gsb;
    public int gsc;
    public String gsd;
    public int gse;
    private String roomId = "";
    private final d rr;

    public l(String str) {
        AppMethodBeat.i(12470);
        d.a aVar = new d.a();
        this.roomId = str;
        bky bky = new bky();
        bky.KGO = str;
        aVar.iLN = bky;
        aVar.iLO = new bkz();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.funcId = TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "chatRoomName:%s stack:%s", Util.nullAs(str, ""), Util.getStack().toString());
        AppMethodBeat.o(12470);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        Object valueOf;
        Object valueOf2;
        boolean z;
        h hVar;
        AppMethodBeat.i(12471);
        Log.w("MicroMsg.NetSceneGetChatRoomInfoDetail", "errType = " + i3 + " errCode " + i4 + " errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGetChatRoomInfoDetail", "OK");
            bkz bkz = (bkz) this.rr.iLL.iLR;
            if (bkz.isIncludeUnKnownField()) {
                ap aSX = ((c) g.af(c.class)).aSX();
                ah Kd = aSX.Kd(this.roomId);
                boolean z2 = false;
                if (Kd != null) {
                    Kd.field_saveByteVersion = BuildInfo.CLIENT_VERSION;
                    Kd.field_handleByteVersion = BuildInfo.CLIENT_VERSION;
                    Kd.field_roomInfoDetailResByte = bkz.getData();
                    z2 = aSX.replace(Kd);
                }
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = Kd == null ? BuildConfig.COMMAND : Kd.toString();
                Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "save response byte result:%s, member:%s", objArr);
            }
            this.gsb = bkz.LTP;
            this.gsc = bkz.gsc;
            this.gsd = bkz.gsd;
            this.gse = bkz.gse;
            String str2 = bkz.LTT;
            int i5 = bkz.LTQ;
            String str3 = this.gsb;
            int i6 = this.gsc;
            Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s chatRoomStatus:%s associateOpenIMRoomName:%s isIncludeUnKnownField:%s", this.roomId, Integer.valueOf(i6), Integer.valueOf(this.gse), Integer.valueOf(i5), Util.nullAs(str2, ""), Boolean.valueOf(bkz.isIncludeUnKnownField()));
            v.a(this.roomId, Util.nullAsNil(str3), this.gsd, (long) this.gse, i6, i5);
            if (ab.Eq(this.roomId)) {
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().ce(this.roomId, bkz.fvd);
                aa.a(this.roomId, bkz);
                if (ab.JO(this.roomId)) {
                    b groupBindAppStorage = ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getGroupBindAppStorage();
                    String str4 = this.roomId;
                    dps dps = bkz.LTU;
                    if (groupBindAppStorage.db instanceof h) {
                        hVar = (h) groupBindAppStorage.db;
                    } else {
                        hVar = null;
                    }
                    long j2 = -1;
                    if (hVar != null) {
                        try {
                            j2 = hVar.beginTransaction(Thread.currentThread().getId());
                        } catch (Exception e2) {
                            Log.i("MicroMsg.GroupBindAppStorage", e2.getMessage());
                        }
                    }
                    Log.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, delete: %d", Long.valueOf((long) groupBindAppStorage.db.delete("GroupBindApp", "chatRoomName=?", new String[]{str4})));
                    if (dps != null) {
                        a aVar = new a();
                        aVar.field_chatRoomName = str4;
                        aVar.field_BindAppData = dps.toByteArray();
                        Log.i("MicroMsg.GroupBindAppStorage", "updateChatRoomBindApp, insert: %d", Long.valueOf(groupBindAppStorage.db.insert("GroupBindApp", "chatRoomName", aVar.convertTo())));
                    }
                    if (!(hVar == null || j2 == -1)) {
                        hVar.endTransaction(j2);
                    }
                }
            }
            if (ab.Ix(this.roomId) && !Util.isNullOrNil(str2)) {
                ah Kd2 = ((c) g.af(c.class)).aSX().Kd(this.roomId);
                if (Kd2 == null || !Util.isNullOrNil(Kd2.field_associateOpenIMRoomName)) {
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = Kd2 == null ? BuildConfig.COMMAND : Util.nullAs(Kd2.field_associateOpenIMRoomName, "");
                    Log.e("MicroMsg.NetSceneGetChatRoomInfoDetail", "handleInfo member:%s", objArr2);
                } else {
                    ah Kd3 = ((c) g.af(c.class)).aSX().Kd(str2);
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = this.roomId;
                    if (Kd2 == null) {
                        valueOf = BuildConfig.COMMAND;
                    } else {
                        valueOf = Boolean.valueOf(Kd2.gBC());
                    }
                    objArr3[1] = valueOf;
                    objArr3[2] = str2;
                    if (Kd3 == null) {
                        valueOf2 = BuildConfig.COMMAND;
                    } else {
                        valueOf2 = Boolean.valueOf(Kd3.gBC());
                    }
                    objArr3[3] = valueOf2;
                    Log.i("MicroMsg.NetSceneGetChatRoomInfoDetail", "roomId %s finish %s, associateOpenIMRoomName %s finish %s", objArr3);
                    if (Kd3 == null || Kd3.gBC()) {
                        z = false;
                    } else {
                        z = true;
                        Kd3.field_openIMRoomMigrateStatus = 2;
                        Kd3.field_associateOpenIMRoomName = this.roomId;
                        ((c) g.af(c.class)).aSX().replace(Kd3);
                    }
                    if (z) {
                        Kd2.field_openIMRoomMigrateStatus = 1;
                    } else {
                        Kd2.field_openIMRoomMigrateStatus = 3;
                    }
                    Kd2.field_associateOpenIMRoomName = str2;
                    ((c) g.af(c.class)).aSX().replace(Kd2);
                    if (z) {
                        ((PluginChatroomUI) g.ah(PluginChatroomUI.class)).getOpenImMigrateService().ae(this.roomId, str2);
                    }
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12471);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(12472);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12472);
        return dispatch;
    }
}
