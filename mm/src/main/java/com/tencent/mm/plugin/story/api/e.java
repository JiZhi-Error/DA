package com.tencent.mm.plugin.story.api;

import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.plugin.story.api.l;
import com.tencent.mm.protocal.protobuf.eel;
import java.util.List;

public interface e extends d {
    void addStoryStatusNotifyListener(m mVar);

    boolean canPostStory();

    void checkPost();

    boolean checkReportFromChatting(int i2, String str);

    void enterGallery(List<String> list);

    String getAccStoryCachePath();

    String getAccStoryPath();

    String getAccStoryTmpPath();

    l.c getContactFetcher();

    b getFavourUserChecker();

    f getStoryBasicConfig();

    j getStoryNewFeatureConfig();

    l getStoryStateFetcher(String str);

    n getStoryUIFactory();

    eel getStoryUserInfo();

    boolean hasNewStory(String str);

    boolean isShowStoryCheck();

    boolean isStoryExist(String str);

    boolean isStoryUnread(String str);

    void loadStory(String str, String str2);

    boolean preLoadVideoViewMgr(String str);

    void preloadForSnsUser(String str, boolean z);

    void reportWaitPlayList(List<String> list, long j2);

    boolean showStoryEntranceDialog(Context context, String str, int i2);

    void startStoryCaptureForResult(Context context, int i2, long j2, int i3);

    void updateStoryUserInfo(String str, eel eel);
}
