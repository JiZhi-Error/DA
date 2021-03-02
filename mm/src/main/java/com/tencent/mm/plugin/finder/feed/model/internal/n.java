package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0015B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "T", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "cmd", "", "insList", "", "isNeedClear", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "(ILjava/util/List;ZLjava/lang/Object;)V", "getCmd", "()I", "getInsList", "()Ljava/util/List;", "()Z", "getRequest", "()Ljava/lang/Object;", "setRequest", "(Ljava/lang/Object;)V", "Companion", "plugin-finder_release"})
public final class n<T extends i> {
    public static final a tYR = new a((byte) 0);
    final int EX;
    final boolean isNeedClear;
    Object request;
    final List<T> tYQ;

    static {
        AppMethodBeat.i(166126);
        AppMethodBeat.o(166126);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends T extends com.tencent.mm.plugin.finder.feed.model.internal.i> */
    /* JADX WARN: Multi-variable type inference failed */
    private n(int i2, List<? extends T> list, boolean z) {
        this.EX = i2;
        this.tYQ = list;
        this.isNeedClear = z;
        this.request = null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(int i2, List list, boolean z, int i3) {
        this(i2, list, (i3 & 4) != 0 ? true : z);
        AppMethodBeat.i(245041);
        AppMethodBeat.o(245041);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp$Companion;", "", "()V", "ADD_LOADMORE", "", "ADD_REFRESH", "ALL_REFRESH", "CLEAN_REFRESH", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT, "INSERT", "LOADMORE_THAT_ALL", "REFRESH_THAT_ALL", "cmd2String", "", "cmd", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String IP(int i2) {
            switch (i2) {
                case 1:
                    return "ADD_LOADMORE";
                case 2:
                    return "ADD_REFRESH";
                case 3:
                    return TMAssistantDownloadSDKClientBase.CONNTECTSTATE_INIT;
                case 4:
                    return "CLEAN_REFRESH";
                case 5:
                    return "LOADMORE_THAT_ALL";
                case 6:
                    return "REFRESH_THAT_ALL";
                case 7:
                default:
                    return "UNKNOWN";
                case 8:
                    return "INSERT";
            }
        }
    }
}
