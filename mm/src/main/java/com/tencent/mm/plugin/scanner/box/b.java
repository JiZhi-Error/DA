package com.tencent.mm.plugin.scanner.box;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u000b\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "", "getVieHeight", "", "onZoomStateChanged", "", "zoomState", "release", "setOpListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "OpListener", "ZoomState", "plugin-scan_release"})
public interface b {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "", "onClick", "", "view", "Landroid/view/View;", "plugin-scan_release"})
    public interface a {
        void bmr();
    }

    void Ws(int i2);

    int getVieHeight();

    void release();

    void setOpListener(a aVar);
}
