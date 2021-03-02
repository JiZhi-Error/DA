package com.tencent.mm.plugin.festival.model;

import com.tencent.mm.sdk.event.IEvent;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalLiveHeartbeatErrorResp;", "Lcom/tencent/mm/sdk/event/IEvent;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "getErrCode", "()I", "getErrType", "plugin-festival_release"})
public final class n extends IEvent {
    public final int errCode;
    private final int errType;

    public n(int i2, int i3) {
        this.errType = i2;
        this.errCode = i3;
    }
}
