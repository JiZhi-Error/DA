package com.tencent.mm.plugin.updater.a;

import com.tencent.mm.kernel.b.d;

public interface a extends d {
    void addManualCheckUpdateListener(b bVar);

    void clickAboutWechatRedDot();

    void clickBottomTabRedDot();

    void clickCheckUpdateRedDot();

    void clickSettingTabRedDot();

    int getUpdateVersion();

    boolean hasAboutWechatRedDot();

    boolean hasBottomTabRedDot();

    boolean hasCheckUpdateTabRedDot();

    boolean hasSettingTabRedDot();

    void manualCheckUpdate(int i2);

    boolean openUpdater();

    void removeManualCheckUpdateListener(b bVar);

    void setFullCheckUpdateRedDot(int i2);
}
