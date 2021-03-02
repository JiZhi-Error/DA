package com.tencent.mm.plugin.webview.ui.tools.browser.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "", "dismissDialog", "", "dialog", "Landroid/app/Dialog;", "withAnimation", "", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "showDialog", "plugin-webview_release"})
public interface a {
    void d(Dialog dialog);

    Intent getTargetIntent();

    Context getUIContext();

    void r(int i2, Intent intent);
}
