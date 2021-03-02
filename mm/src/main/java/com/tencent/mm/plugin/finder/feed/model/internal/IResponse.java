package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.bdr;
import java.util.List;
import kotlin.g.b.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "bgmInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "getBgmInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;", "setBgmInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicBgmInfo;)V", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "incrementList", "", "getIncrementList", "()Ljava/util/List;", "setIncrementList", "(Ljava/util/List;)V", "isNeedClear", "setNeedClear", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "pullType", "getPullType", "setPullType", "(I)V", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "getRequest", "()Ljava/lang/Object;", "setRequest", "(Ljava/lang/Object;)V", "plugin-finder_release"})
public class IResponse<T extends i> {
    private bdr bgmInfo;
    private final int errCode;
    private final String errMsg;
    private final int errType;
    private boolean hasMore;
    private List<? extends T> incrementList;
    private boolean isNeedClear;
    private b lastBuffer;
    private int pullType;
    private Object request;

    public IResponse() {
        this(0, 0, null, 7, null);
    }

    public IResponse(int i2, int i3, String str) {
        this.errType = i2;
        this.errCode = i3;
        this.errMsg = str;
        this.pullType = -1;
        this.hasMore = true;
        this.isNeedClear = true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IResponse(int i2, int i3, String str, int i4, j jVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3, (i4 & 4) != 0 ? null : str);
        AppMethodBeat.i(245025);
        AppMethodBeat.o(245025);
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final int getErrType() {
        return this.errType;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends T extends com.tencent.mm.plugin.finder.feed.model.internal.i>, java.util.List<T extends com.tencent.mm.plugin.finder.feed.model.internal.i> */
    public final List<T> getIncrementList() {
        return (List<? extends T>) this.incrementList;
    }

    public final void setIncrementList(List<? extends T> list) {
        this.incrementList = list;
    }

    public final b getLastBuffer() {
        return this.lastBuffer;
    }

    public final void setLastBuffer(b bVar) {
        this.lastBuffer = bVar;
    }

    public final int getPullType() {
        return this.pullType;
    }

    public final void setPullType(int i2) {
        this.pullType = i2;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public final boolean isNeedClear() {
        return this.isNeedClear;
    }

    public final void setNeedClear(boolean z) {
        this.isNeedClear = z;
    }

    public final Object getRequest() {
        return this.request;
    }

    public final void setRequest(Object obj) {
        this.request = obj;
    }

    public final bdr getBgmInfo() {
        return this.bgmInfo;
    }

    public final void setBgmInfo(bdr bdr) {
        this.bgmInfo = bdr;
    }
}
