package com.tencent.tmassistantsdk.downloadservice.taskmanager;

public class ServiceDownloadTask {
    public String mClientKey = null;
    public long mProgressUpdateTimestamp = 0;
    public long mReceivedBytes = 0;
    public int mState = 0;
    public long mTotalBytes = 0;
    public String mUrl = null;

    public ServiceDownloadTask(String str, String str2) {
        this.mClientKey = str;
        this.mUrl = str2;
    }

    public boolean checkIsNeedUpdateProgress(long j2, long j3, long j4) {
        if (j2 == j3) {
            this.mReceivedBytes = j2;
            this.mTotalBytes = j3;
            this.mProgressUpdateTimestamp = j4;
            return true;
        } else if (j4 - this.mProgressUpdateTimestamp >= 1000 && j2 != this.mReceivedBytes) {
            this.mReceivedBytes = j2;
            this.mTotalBytes = j3;
            this.mProgressUpdateTimestamp = j4;
            return true;
        } else if (j3 <= 0 || ((double) ((((((float) j2) * 1.0f) - (((float) this.mReceivedBytes) * 1.0f)) / ((float) j3)) * 1.0f)) <= 0.009999999776482582d) {
            return false;
        } else {
            this.mReceivedBytes = j2;
            this.mTotalBytes = j3;
            this.mProgressUpdateTimestamp = j4;
            return true;
        }
    }
}
