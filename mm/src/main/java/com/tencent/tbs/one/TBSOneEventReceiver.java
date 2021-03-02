package com.tencent.tbs.one;

import java.util.Map;

public interface TBSOneEventReceiver {
    void onReceive(String str, Map<String, Object> map);
}
