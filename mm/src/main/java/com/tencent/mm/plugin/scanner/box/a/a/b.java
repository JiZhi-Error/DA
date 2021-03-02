package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.mars.cdn.CdnLogic;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "controlByte", "", "getControlByte", "()I", "lastShowToastTimestamp", "", "canShowToast", "", "current", "Companion", "plugin-scan_release"})
public abstract class b extends com.tencent.mm.plugin.webview.d.c.a {
    public static final a CDL = new a((byte) 0);
    private final int CDJ = CdnLogic.kMediaTypeFavoriteBigFile;
    private long CDK;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi$Companion;", "", "()V", "SHOW_TOAST_TIME_MIN_LIMIT", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return this.CDJ;
    }

    /* access modifiers changed from: protected */
    public final boolean Iu(long j2) {
        if (this.CDK != 0 && System.currentTimeMillis() - this.CDK < 2000) {
            return false;
        }
        this.CDK = j2;
        return true;
    }
}
