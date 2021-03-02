package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ag.v;
import com.tencent.mm.ag.x;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.n;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.cmb;
import com.tencent.mm.protocal.protobuf.ff;
import com.tencent.mm.protocal.protobuf.fg;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.protocal.protobuf.fi;
import com.tencent.mm.protocal.protobuf.fj;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.ql;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010z\u001a\u00020{J\b\u0010|\u001a\u0004\u0018\u00010lJ\u0006\u0010}\u001a\u00020{J\u000f\u0010~\u001a\u00020{2\u0007\u0010\u001a\u00030\u0001J\u001b\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\r2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u001a\u00030\u0001J\u0007\u0010\u0001\u001a\u00020{J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\rJ\u0007\u0010\u0001\u001a\u00020\rJ\u0007\u0010\u0001\u001a\u000200J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004J7\u0010\u0001\u001a\u00020{2\u0006\u0010j\u001a\u00020l2\u0006\u0010X\u001a\u00020\r2\u0006\u0010d\u001a\u00020\r2\u0006\u0010L\u001a\u00020M2\u0006\u0010C\u001a\u00020D2\u0006\u0010\u0015\u001a\u00020\rJ\u0007\u0010\u0001\u001a\u00020\"J\u0007\u0010\u0001\u001a\u00020\"J\u0007\u0010\u0001\u001a\u00020{J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\rJ\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\u0006J\u0010\u0010\u0001\u001a\u00020{2\u0007\u0010\u0001\u001a\u00020\rJ\u0013\u0010\u0001\u001a\u00020{2\b\u0010q\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0001\u001a\u00020{2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u000e\u0010*\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001a\u0010C\u001a\u00020DX.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R\u001a\u0010L\u001a\u00020MX.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000f\"\u0004\bZ\u0010\u0011R\u001a\u0010[\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000f\"\u0004\b]\u0010\u0011R\u001c\u0010^\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\t\"\u0004\b`\u0010\u000bR\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\t\"\u0004\bc\u0010\u000bR\u001a\u0010d\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u000f\"\u0004\bf\u0010\u0011R\u001a\u0010g\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u000f\"\u0004\bi\u0010\u0011R \u0010j\u001a\b\u0012\u0004\u0012\u00020l0kX.¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001c\u0010q\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\t\"\u0004\bs\u0010\u000bR\u001c\u0010t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\t\"\u0004\bv\u0010\u000bR\u001a\u0010w\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u000f\"\u0004\by\u0010\u0011¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "", "()V", "TAG", "", "cgiCallback", "Lcom/tencent/mm/ipcinvoker/wx_extension/IPCRunCgi$ICGICallback;", "channelSessionId", "getChannelSessionId", "()Ljava/lang/String;", "setChannelSessionId", "(Ljava/lang/String;)V", "commentOffset", "", "getCommentOffset", "()I", "setCommentOffset", "(I)V", "copyUrl", "getCopyUrl", "setCopyUrl", "enterId", "getEnterId", "setEnterId", FFmpegMetadataRetriever.METADATA_KEY_FILESIZE, "", "getFilesize", "()J", "setFilesize", "(J)V", "funcFlag", "getFuncFlag", "setFuncFlag", "hasShowWifiTips", "", "getHasShowWifiTips", "()Z", "setHasShowWifiTips", "(Z)V", "idx", "getIdx", "setIdx", "isDoingGetFansComment", "isDoingGetMyComment", "itemShowType", "getItemShowType", "setItemShowType", "kV17149", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "getKV17149", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;", "setKV17149", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/KV17149;)V", "landingPageType", "getLandingPageType", "setLandingPageType", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "maliciousTitleInfo", "Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "getMaliciousTitleInfo", "()Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;", "setMaliciousTitleInfo", "(Lcom/tencent/mm/protocal/protobuf/MaliciousTitleInfo;)V", "mid", "getMid", "setMid", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "myCommentOffset", "getMyCommentOffset", "setMyCommentOffset", "readerItem", "Lcom/tencent/mm/message/BizReaderItem;", "getReaderItem", "()Lcom/tencent/mm/message/BizReaderItem;", "setReaderItem", "(Lcom/tencent/mm/message/BizReaderItem;)V", "report", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "getReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;", "setReport", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MPDataReportHelper;)V", "scene", "getScene", "setScene", "simcardType", "getSimcardType", "setSimcardType", "srcDisPlayName", "getSrcDisPlayName", "setSrcDisPlayName", "srcUserName", "getSrcUserName", "setSrcUserName", "subScene", "getSubScene", "setSubScene", "timeLineSessionId", "getTimeLineSessionId", "setTimeLineSessionId", "ui", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "getUi$plugin_brandservice_release", "()Ljava/lang/ref/WeakReference;", "setUi$plugin_brandservice_release", "(Ljava/lang/ref/WeakReference;)V", "url", "getUrl", "setUrl", "vid", "getVid", "setVid", "wifiTipsFlag", "getWifiTipsFlag", "setWifiTipsFlag", "appMsgGet", "", "context", "disMissProgressDlg", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "doAppMsgLike", "actionType", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "doAppMsgLikeComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgLikeCommentReq;", "doAppMsgOperateComment", "Lcom/tencent/mm/protocal/protobuf/AppMsgOperateCommentReq;", "doCommentExposure", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommentExposureReq;", "geAppMsgExtData", "getAppMsgCommentList", "getFileSizeKB", "getKv17149", "getTalker", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "isFinished", "isMaliciousTitle", "onDestroy", "onShowWifiTips", "mode", "setCgiCallBack", "callback", "setMsgFuncFlag", "flag", "setShareUrl", "showProgressDlg", "wording", "plugin-brandservice_release"})
public final class b {
    final String TAG = "MicroMsg.BizNativePageController";
    String dHc = "";
    private q gxX;
    public long iAQ;
    public int idx;
    public int iwc;
    public int iwg = -1;
    IPCRunCgi.a lma;
    public WeakReference<TmplShareWebViewToolUI> nhy;
    public int pHA;
    public cmb pHB;
    public m pHC;
    String pHo = "";
    public String pHp = "";
    public n pHq = new n();
    long pHr;
    int pHs;
    boolean pHt;
    public int pHu = ((int) (System.currentTimeMillis() / 1000));
    public x pHv;
    public int pHw;
    public int pHx;
    int pHy;
    public String pHz = "";
    public v ptH;
    public int scene;
    public String url = "";
    public String vid = "";

    public b() {
        AppMethodBeat.i(7081);
        m mVar = new m();
        m.a aVar = m.pLL;
        m.g(new WeakReference(mVar));
        this.pHC = mVar;
        AppMethodBeat.o(7081);
    }

    public final v cpS() {
        AppMethodBeat.i(7070);
        v vVar = this.ptH;
        if (vVar == null) {
            p.btv("readerItem");
        }
        AppMethodBeat.o(7070);
        return vVar;
    }

    public final void aiF(String str) {
        if (str != null) {
            this.url = str;
        }
    }

    public final void cpT() {
        int i2;
        fs fsVar;
        AppMethodBeat.i(7073);
        fs fsVar2 = new fs();
        fsVar2.url = this.url;
        fsVar2.vid = this.vid;
        fsVar2.scene = this.scene;
        fsVar2.KIL = this.pHw;
        fsVar2.nettype = com.tencent.mm.ag.m.ape();
        if (fsVar2.nettype == 100) {
            fsVar2.nettype = 0;
        }
        fsVar2.session_id = new StringBuilder().append(this.pHx).toString();
        fsVar2.KIK = this.pHu;
        x xVar = this.pHv;
        if (xVar == null) {
            p.btv("msgInfo");
        }
        if (x.rK(xVar.iwg)) {
            fsVar2.KJl = 1;
        } else {
            fsVar2.KJl = 0;
        }
        int i3 = this.pHy;
        if (i3 == 0) {
            i2 = 0;
            fsVar = fsVar2;
        } else if (i3 == 1) {
            i2 = 1;
            fsVar = fsVar2;
        } else {
            i2 = 2;
            fsVar = fsVar2;
        }
        fsVar.KJm = i2;
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.TAG);
        if (mmkv != null) {
            fsVar2.KJn = mmkv.decodeLong("BizVideoLastPlayTimestamp", 0);
            fsVar2.KJo = mmkv.decodeLong("BizVideoLastPlayFileSize", 0);
            fsVar2.KJr = mmkv.decodeInt("BizVideoLastShowWifiTipsMode", 0);
        }
        if (cpV() != null) {
            fsVar2.KJp = new ql();
            fsVar2.KJp.KXn = com.tencent.mm.cb.a.jn(cpV());
            fsVar2.KJp.KXo = com.tencent.mm.cb.a.jo(cpV());
            fsVar2.KJp.KXp = ao.gJO().densityDpi;
        }
        fsVar2.KJt = this.pHz;
        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a aVar = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.pKk;
        fsVar2.KJs = com.tencent.mm.plugin.brandservice.ui.timeline.video.util.a.cqV() ? 1 : 0;
        Log.i(this.TAG, "simType: %s,last_play_timestamp %d, last_play_filesize %d, width %d, height %d, dpi %d", Integer.valueOf(i3), Long.valueOf(fsVar2.KJn), Long.valueOf(fsVar2.KJo), Integer.valueOf(fsVar2.KJp.KXn), Integer.valueOf(fsVar2.KJp.KXo), Integer.valueOf(fsVar2.KJp.KXp));
        d.a aVar2 = new d.a();
        aVar2.c(fsVar2);
        aVar2.d(new ft());
        aVar2.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_get");
        aVar2.sG(1179);
        aVar2.sI(0);
        aVar2.sJ(0);
        IPCRunCgi.a(aVar2.aXF(), new a(this));
        AppMethodBeat.o(7073);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class a implements IPCRunCgi.a {
        final /* synthetic */ b pHD;

        a(b bVar) {
            this.pHD = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(7064);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.b.a.AnonymousClass1 */
                final /* synthetic */ a pHE;

                {
                    this.pHE = r1;
                }

                public final void run() {
                    AppMethodBeat.i(7063);
                    IPCRunCgi.a aVar = this.pHE.pHD.lma;
                    if (aVar != null) {
                        aVar.a(i2, i3, str, dVar);
                        AppMethodBeat.o(7063);
                        return;
                    }
                    AppMethodBeat.o(7063);
                }
            });
            AppMethodBeat.o(7064);
        }
    }

    public final void DJ(int i2) {
        AppMethodBeat.i(175498);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.TAG);
        if (mmkv != null) {
            mmkv.encode("BizVideoLastPlayTimestamp", System.currentTimeMillis() / 1000);
            mmkv.encode("BizVideoLastPlayFileSize", this.pHr);
            mmkv.encode("BizVideoLastShowWifiTipsMode", i2);
        }
        AppMethodBeat.o(175498);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aJ(int r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 265
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.video.b.aJ(int, java.lang.String):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class c implements IPCRunCgi.a {
        final /* synthetic */ b pHD;

        c(b bVar) {
            this.pHD = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(final int i2, final int i3, final String str, final com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(7067);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.brandservice.ui.timeline.video.b.c.AnonymousClass1 */
                final /* synthetic */ c pHF;

                {
                    this.pHF = r1;
                }

                public final void run() {
                    AppMethodBeat.i(7066);
                    IPCRunCgi.a aVar = this.pHF.pHD.lma;
                    if (aVar != null) {
                        aVar.a(i2, i3, str, dVar);
                        AppMethodBeat.o(7066);
                        return;
                    }
                    AppMethodBeat.o(7066);
                }
            });
            AppMethodBeat.o(7067);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    static final class d implements IPCRunCgi.a {
        final /* synthetic */ b pHD;

        d(b bVar) {
            this.pHD = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(7068);
            Log.i(this.pHD.TAG, "appmsg_comment_exposure errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            AppMethodBeat.o(7068);
        }
    }

    public final void a(fg fgVar) {
        AppMethodBeat.i(7076);
        p.h(fgVar, "req");
        d.a aVar = new d.a();
        aVar.c(fgVar);
        aVar.d(new fh());
        aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
        aVar.sG(1870);
        aVar.sI(0);
        aVar.sJ(0);
        IPCRunCgi.a(aVar.aXF(), new C0895b(this));
        AppMethodBeat.o(7076);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.b$b  reason: collision with other inner class name */
    public static final class C0895b implements IPCRunCgi.a {
        final /* synthetic */ b pHD;

        C0895b(b bVar) {
            this.pHD = bVar;
        }

        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
        public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
            AppMethodBeat.i(7065);
            Log.i(this.pHD.TAG, "appmsg_report errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
            AppMethodBeat.o(7065);
        }
    }

    public final void onDestroy() {
        AppMethodBeat.i(7077);
        cpU();
        n nVar = this.pHq;
        if (nVar.pLM.size() > 0) {
            LinkedList<acd> linkedList = new LinkedList<>();
            for (Map.Entry<String, acd> entry : nVar.pLM.entrySet()) {
                p.g(entry, "it.next()");
                acd value = entry.getValue();
                p.g(value, "entry.value");
                linkedList.add(value);
            }
            fj fjVar = new fj();
            fjVar.KII = linkedList;
            b bVar = nVar.pIL;
            if (bVar == null) {
                p.btv("controller");
            }
            p.h(fjVar, "req");
            fjVar.KIK = bVar.pHu;
            fjVar.session_id = new StringBuilder().append(bVar.pHx).toString();
            fjVar.KIJ = bVar.iwc;
            fjVar.url = bVar.url;
            d.a aVar = new d.a();
            aVar.c(fjVar);
            aVar.d(new fk());
            aVar.MB("/cgi-bin/mmbiz-bin/appmsg/appmsg_comment_exposure");
            aVar.sG(2827);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), new d(bVar));
            nVar.pLM.clear();
        }
        fg fgVar = new fg();
        ff ffVar = new ff();
        ffVar.type = 1;
        b bVar2 = nVar.pIL;
        if (bVar2 == null) {
            p.btv("controller");
        }
        String valueOf = String.valueOf(bVar2.scene);
        LinkedList<fi> linkedList2 = ffVar.KEQ;
        p.g(linkedList2, "reportData.item");
        n.a("scene", valueOf, linkedList2);
        String formatedNetType = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        LinkedList<fi> linkedList3 = ffVar.KEQ;
        p.g(linkedList3, "reportData.item");
        n.a(DownloadInfo.NETTYPE, formatedNetType, linkedList3);
        String valueOf2 = String.valueOf(nVar.pLN);
        LinkedList<fi> linkedList4 = ffVar.KEQ;
        p.g(linkedList4, "reportData.item");
        n.a("StartTimeMs", valueOf2, linkedList4);
        String valueOf3 = String.valueOf(System.currentTimeMillis());
        LinkedList<fi> linkedList5 = ffVar.KEQ;
        p.g(linkedList5, "reportData.item");
        n.a("EndTimeMs", valueOf3, linkedList5);
        b bVar3 = nVar.pIL;
        if (bVar3 == null) {
            p.btv("controller");
        }
        String valueOf4 = String.valueOf(bVar3.iwc);
        LinkedList<fi> linkedList6 = ffVar.KEQ;
        p.g(linkedList6, "reportData.item");
        n.a("ItemShowType", valueOf4, linkedList6);
        StringBuilder sb = new StringBuilder();
        b bVar4 = nVar.pIL;
        if (bVar4 == null) {
            p.btv("controller");
        }
        String sb2 = sb.append(bVar4.pHx).toString();
        LinkedList<fi> linkedList7 = ffVar.KEQ;
        p.g(linkedList7, "reportData.item");
        n.a("SessionId", sb2, linkedList7);
        b bVar5 = nVar.pIL;
        if (bVar5 == null) {
            p.btv("controller");
        }
        String valueOf5 = String.valueOf(bVar5.pHu);
        LinkedList<fi> linkedList8 = ffVar.KEQ;
        p.g(linkedList8, "reportData.item");
        n.a("EnterId", valueOf5, linkedList8);
        LinkedList<fi> linkedList9 = ffVar.KEQ;
        p.g(linkedList9, "reportData.item");
        n.a("NativePage", "1", linkedList9);
        b bVar6 = nVar.pIL;
        if (bVar6 == null) {
            p.btv("controller");
        }
        String str = bVar6.url;
        LinkedList<fi> linkedList10 = ffVar.KEQ;
        p.g(linkedList10, "reportData.item");
        n.a("#AppMsgUrl#", str, linkedList10);
        fgVar.KIG.add(ffVar);
        b bVar7 = nVar.pIL;
        if (bVar7 == null) {
            p.btv("controller");
        }
        bVar7.a(fgVar);
        LinkedList<fi> linkedList11 = ffVar.KEQ;
        p.g(linkedList11, "reportData.item");
        nVar.b(10945, linkedList11);
        this.lma = null;
        AppMethodBeat.o(7077);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class e implements DialogInterface.OnCancelListener {
        final /* synthetic */ b pHD;

        e(b bVar) {
            this.pHD = bVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(7069);
            try {
                dialogInterface.dismiss();
                AppMethodBeat.o(7069);
            } catch (Exception e2) {
                Log.e(this.pHD.TAG, "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                AppMethodBeat.o(7069);
            }
        }
    }

    public final void cpU() {
        q qVar;
        AppMethodBeat.i(7078);
        if (this.gxX != null) {
            q qVar2 = this.gxX;
            Boolean valueOf = qVar2 != null ? Boolean.valueOf(qVar2.isShowing()) : null;
            if (valueOf == null) {
                p.hyc();
            }
            if (valueOf.booleanValue() && (qVar = this.gxX) != null) {
                qVar.dismiss();
                AppMethodBeat.o(7078);
                return;
            }
        }
        AppMethodBeat.o(7078);
    }

    public final String ajO() {
        AppMethodBeat.i(7079);
        x xVar = this.pHv;
        if (xVar == null) {
            p.btv("msgInfo");
        }
        String ajO = xVar.ajO();
        AppMethodBeat.o(7079);
        return ajO;
    }

    private TmplShareWebViewToolUI cpV() {
        AppMethodBeat.i(7080);
        WeakReference<TmplShareWebViewToolUI> weakReference = this.nhy;
        if (weakReference == null) {
            p.btv("ui");
        }
        if (weakReference.get() == null) {
            AppMethodBeat.o(7080);
            return null;
        }
        WeakReference<TmplShareWebViewToolUI> weakReference2 = this.nhy;
        if (weakReference2 == null) {
            p.btv("ui");
        }
        TmplShareWebViewToolUI tmplShareWebViewToolUI = weakReference2.get();
        if (tmplShareWebViewToolUI == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
            AppMethodBeat.o(7080);
            throw tVar;
        }
        TmplShareWebViewToolUI tmplShareWebViewToolUI2 = tmplShareWebViewToolUI;
        AppMethodBeat.o(7080);
        return tmplShareWebViewToolUI2;
    }

    public final boolean cpW() {
        return (this.iwg & 4) != 0;
    }

    public final int cpX() {
        return (int) (this.pHr / 1024);
    }
}
