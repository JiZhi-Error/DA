package com.tencent.recovery.option;

import com.tencent.recovery.config.Express;

public class ProcessOptions {
    private Express express;
    private int timeout;

    public int getTimeout() {
        return this.timeout;
    }

    public Express getExpress() {
        return this.express;
    }

    public static final class Builder {
        private Express express;
        private int timeout;

        public final Builder setTimeout(int i2) {
            this.timeout = i2;
            return this;
        }

        public final Builder setExpress(Express express2) {
            this.express = express2;
            return this;
        }

        public final ProcessOptions build() {
            ProcessOptions processOptions = new ProcessOptions();
            processOptions.timeout = this.timeout;
            processOptions.express = this.express;
            return processOptions;
        }
    }
}
