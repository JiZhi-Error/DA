package com.tencent.recovery.option;

public class CommonOptions {
    private String clientVersion;
    private String configUrl;
    private boolean debugMode;
    private long handleRetryInterval;
    private String recoveryHandleService;
    private String recoveryUploadService;
    private long uploadInterval;
    private String uuid;

    private CommonOptions() {
    }

    public long getHandleRetryInterval() {
        return this.handleRetryInterval;
    }

    public long getUploadInterval() {
        return this.uploadInterval;
    }

    public String getConfigUrl() {
        return this.configUrl;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public String getUUID() {
        return this.uuid;
    }

    public String getRecoveryHandleService() {
        return this.recoveryHandleService;
    }

    public String getRecoveryUploadService() {
        return this.recoveryUploadService;
    }

    public boolean isDebugMode() {
        return this.debugMode;
    }

    public static final class Builder {
        private String clientVersion;
        private String configUrl;
        private boolean debugMode;
        private long handleRetryInterval;
        private String recoveryHandleService;
        private String recoveryUploadService;
        private long uploadInterval;
        private String uuid;

        public final void setRecoveryHandleService(String str) {
            this.recoveryHandleService = str;
        }

        public final void setRecoveryUploadService(String str) {
            this.recoveryUploadService = str;
        }

        public final void setUploadInterval(long j2) {
            this.uploadInterval = j2;
        }

        public final void setHandleRetryInterval(long j2) {
            this.handleRetryInterval = j2;
        }

        public final void setConfigUrl(String str) {
            this.configUrl = str;
        }

        public final void setUUID(String str) {
            this.uuid = str;
        }

        public final void setClientVersion(String str) {
            this.clientVersion = str;
        }

        public final void setDebugMode(boolean z) {
            this.debugMode = z;
        }

        public final CommonOptions build() {
            CommonOptions commonOptions = new CommonOptions();
            commonOptions.recoveryHandleService = this.recoveryHandleService;
            commonOptions.recoveryUploadService = this.recoveryUploadService;
            commonOptions.clientVersion = this.clientVersion;
            commonOptions.configUrl = this.configUrl;
            commonOptions.uuid = this.uuid;
            commonOptions.debugMode = this.debugMode;
            commonOptions.uploadInterval = this.uploadInterval;
            commonOptions.handleRetryInterval = this.handleRetryInterval;
            return commonOptions;
        }
    }
}
