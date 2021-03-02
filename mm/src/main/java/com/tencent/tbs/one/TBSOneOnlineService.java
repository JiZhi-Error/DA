package com.tencent.tbs.one;

import android.os.Bundle;

public interface TBSOneOnlineService {
    void cancelUpdate();

    void update(Bundle bundle, TBSOneCallback<Void> tBSOneCallback);
}
