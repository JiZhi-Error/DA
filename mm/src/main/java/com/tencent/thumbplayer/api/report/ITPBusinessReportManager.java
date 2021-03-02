package com.tencent.thumbplayer.api.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public interface ITPBusinessReportManager {
    public static final int EVENT_ID_302_REDIRECT = 1001;
    public static final int EVENT_ID_EARLY_ERROR = 1100;
    public static final int EVENT_ID_GET_CDN_URL = 1000;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventId {
    }

    void reportEvent(int i2, Map<String, Object> map);

    void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo);
}
