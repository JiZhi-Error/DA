package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Arrays;

public final class p implements w {
    private VideoTransPara jsd = null;
    private VideoTransPara jse = null;
    private String jsf;
    Boolean jsg = Boolean.FALSE;
    private String srcPath;

    @Override // com.tencent.mm.modelvideo.w
    public final void Qk(String str) {
        cly cly;
        AppMethodBeat.i(126944);
        o.bhj();
        this.srcPath = t.Qw(str);
        StringBuilder sb = new StringBuilder();
        o.bhj();
        this.jsf = sb.append(t.Qw(str)).append(".tmp").toString();
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "srcPath： %s", this.srcPath);
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "dstPath：%s", this.jsf);
        this.jsg = Boolean.valueOf(e.QW(this.srcPath));
        if (!s.YS(this.srcPath) || !this.jsg.booleanValue()) {
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "video format is h264，do not need to tranfer");
            s QN = u.QN(str);
            if (QN != null && !Util.isNullOrNil(QN.bhu()) && s.YS(QN.bhu()) && ((cly = QN.jsx) == null || !cly.Mrn)) {
                String bhu = QN.bhu();
                o.bhj();
                String Qw = t.Qw(str);
                this.jse = e.QX(bhu);
                this.jsd = e.a(this.jse, bhu);
                if (s.YS(Qw) || this.jse == null || this.jsd == null) {
                    Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is a local capture video, do nothing");
                } else {
                    int[] iArr = new int[2];
                    m.d(bhu, iArr);
                    long currentTicks = Util.currentTicks();
                    this.jsg = Boolean.valueOf(e.QW(bhu));
                    Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, local remux file path not exist, do remux here, outsize: %s, localDstFilePath: %s, importPath: %s, isH265: %s", Arrays.toString(iArr), Qw, bhu, this.jsg);
                    if (this.jsg.booleanValue()) {
                        Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms %s", Long.valueOf(Util.ticksToNow(currentTicks)), Integer.valueOf(e.a(bhu, Qw, this.jsd)));
                    } else {
                        int remuxingVFS = SightVideoJNI.remuxingVFS(bhu, Qw, iArr[0], iArr[1], this.jsd.videoBitrate, this.jsd.iSV, 8, this.jsd.iSU, 25.0f, (float) this.jsd.fps, null, 0, c.Dmb, 0, 51);
                        Log.i("MicroMsg.TransferVideoMsgSendCallback", "remux finish: %s, used %sms", Integer.valueOf(remuxingVFS), Long.valueOf(Util.ticksToNow(currentTicks)));
                        ((a) g.af(a.class)).aSV().ar(bhu, Qw, remuxingVFS);
                    }
                    if (this.jse.duration > 0) {
                        QN.iFw = this.jse.duration;
                        o.bhj().c(QN);
                    }
                    AppMethodBeat.o(126944);
                    return;
                }
            }
            AppMethodBeat.o(126944);
            return;
        }
        Log.i("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265");
        long currentTicks2 = Util.currentTicks();
        if (!s.YS(this.srcPath)) {
            Log.e("MicroMsg.TransferVideoMsgSendCallback", "before video send, is h265 file not exist!");
            AppMethodBeat.o(126944);
            return;
        }
        h.INSTANCE.idkeyStat(354, 249, 1, false);
        this.jse = e.QX(this.srcPath);
        this.jsd = e.a(this.jse, this.srcPath);
        if (!(this.jse == null || this.jsd == null)) {
            if (e.a(this.srcPath, this.jsf, this.jsd) < 0) {
                h.INSTANCE.idkeyStat(354, 250, 1, false);
            }
            s.nx(this.jsf, this.srcPath);
            s.deleteFile(this.jsf);
            s QN2 = u.QN(str);
            if (QN2 != null) {
                QN2.videoFormat = 1;
                QN2.cSx = 2;
                o.bhj().c(QN2);
            }
            Log.i("MicroMsg.TransferVideoMsgSendCallback", "transfer to h264 finish, used %sms", Long.valueOf(Util.ticksToNow(currentTicks2)));
        }
        AppMethodBeat.o(126944);
    }
}
