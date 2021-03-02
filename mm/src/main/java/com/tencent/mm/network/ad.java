package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;

public final class ad {
    private static final byte[] jFy = o.iC(7);
    public o jFz;

    static {
        AppMethodBeat.i(132892);
        AppMethodBeat.o(132892);
    }

    public final void j(int i2, byte[] bArr) {
        AppMethodBeat.i(132891);
        Log.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i2);
        switch (i2) {
            case 5:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.jFz.f(138, jFy);
                AppMethodBeat.o(132891);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.jFz.f(10, bArr);
                    AppMethodBeat.o(132891);
                    return;
                }
                break;
            case 11:
                AppMethodBeat.o(132891);
                return;
            case 12:
                AppMethodBeat.o(132891);
                return;
            case 24:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", Util.dumpHex(bArr));
                this.jFz.f(138, bArr);
                AppMethodBeat.o(132891);
                return;
            case 39:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.jFz.f(39, null);
                AppMethodBeat.o(132891);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                this.jFz.f(TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, bArr);
                AppMethodBeat.o(132891);
                return;
            case 120:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.jFz.f(120, bArr);
                    AppMethodBeat.o(132891);
                    return;
                }
                break;
            case 122:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.jFz.f(268369921, bArr);
                    AppMethodBeat.o(132891);
                    return;
                }
                break;
            case 192:
                this.jFz.f(192, bArr);
                AppMethodBeat.o(132891);
                return;
            case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.jFz.f(TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, bArr);
                AppMethodBeat.o(132891);
                return;
            case 244:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.jFz.f(244, bArr);
                AppMethodBeat.o(132891);
                return;
            case a.C0691a.CTRL_INDEX /*{ENCODED_INT: 271}*/:
                this.jFz.f(a.C0691a.CTRL_INDEX, bArr);
                AppMethodBeat.o(132891);
                return;
            case TPNativePlayerInitConfig.INT_WIDTH /*{ENCODED_INT: 311}*/:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.jFz.f(TPNativePlayerInitConfig.INT_WIDTH, bArr);
                AppMethodBeat.o(132891);
                return;
            case 318:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.jFz.f(318, bArr);
                AppMethodBeat.o(132891);
                return;
            case TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5 /*{ENCODED_INT: 319}*/:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on byp notify");
                this.jFz.f(TbsListener.ErrorCode.ERROR_QBSDK_INIT_CANLOADX5, bArr);
                AppMethodBeat.o(132891);
                return;
            case 3941:
                this.jFz.f(3941, bArr);
                break;
            case 268369923:
                Log.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.jFz.f(268369923, bArr);
                AppMethodBeat.o(132891);
                return;
            case 1000000205:
                this.jFz.f(1000000205, bArr);
                AppMethodBeat.o(132891);
                return;
        }
        AppMethodBeat.o(132891);
    }
}
