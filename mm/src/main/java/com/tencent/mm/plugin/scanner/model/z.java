package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0010\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010IR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001c\u0010?\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\u001c\u0010B\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "", "()V", "catId", "", "getCatId", "()I", "setCatId", "(I)V", "centerX", "", "getCenterX", "()F", "setCenterX", "(F)V", "centerY", "getCenterY", "setCenterY", "imgUrl", "", "getImgUrl", "()Ljava/lang/String;", "setImgUrl", "(Ljava/lang/String;)V", "jumpKeyWord", "getJumpKeyWord", "setJumpKeyWord", "jumpType", "getJumpType", "setJumpType", "matchObj", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getMatchObj", "()Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "setMatchObj", "(Lcom/tencent/mm/protocal/protobuf/GoodsObject;)V", "reqKey", "getReqKey", "setReqKey", "returnType", "getReturnType", "setReturnType", "scanId", "getScanId", "setScanId", "seqNum", "getSeqNum", "setSeqNum", "sessionId", "", "getSessionId", "()J", "setSessionId", "(J)V", "shouldShowResult", "", "getShouldShowResult", "()Z", "setShouldShowResult", "(Z)V", "source", "getSource", "setSource", "wxaAppid", "getWxaAppid", "setWxaAppid", "wxaPath", "getWxaPath", "setWxaPath", "convertFromResponse", "", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageSceneResponse;", "Companion", "plugin-scan_release"})
public final class z {
    public static final a CGq = new a((byte) 0);
    public boolean CGj;
    String CGk;
    String CGl;
    GoodsObject CGm;
    public int CGn;
    public int CGo;
    private String CGp = "";
    public float centerX;
    public float centerY;
    public String dDL;
    public int jumpType;
    public long sessionId;
    public int source;
    String twt;

    static {
        AppMethodBeat.i(52214);
        AppMethodBeat.o(52214);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
