package com.tencent.smtt.sdk;

import android.os.Bundle;

public interface TbsVideoCacheListener {
    void onVideoDownloadCompletion(TbsVideoCacheTask tbsVideoCacheTask, long j2, long j3, Bundle bundle);

    void onVideoDownloadError(TbsVideoCacheTask tbsVideoCacheTask, int i2, String str, Bundle bundle);

    void onVideoDownloadInit(TbsVideoCacheTask tbsVideoCacheTask, int i2, String str, Bundle bundle);

    void onVideoDownloadProgress(TbsVideoCacheTask tbsVideoCacheTask, int i2, long j2, int i3, Bundle bundle);

    void onVideoDownloadStart(TbsVideoCacheTask tbsVideoCacheTask, Bundle bundle);
}
