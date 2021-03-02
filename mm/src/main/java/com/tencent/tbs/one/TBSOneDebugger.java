package com.tencent.tbs.one;

import android.content.Context;
import android.view.View;
import java.util.Map;

public interface TBSOneDebugger {
    View createPanelView(Context context);

    void executeCommand(Context context, String str, Map<String, Object> map, TBSOneCallback<Void> tBSOneCallback);
}
