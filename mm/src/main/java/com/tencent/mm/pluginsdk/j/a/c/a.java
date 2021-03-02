package com.tencent.mm.pluginsdk.j.a.c;

public abstract class a {
    public final int JYA;
    public final String JYs;
    public final String JZK;
    private final String JZL;
    private final String JZM;
    private final String filePath;
    private volatile int jgF;
    private final long jmW;
    private final String md5;
    public final int networkType;
    public final int priority;
    protected volatile int status = 0;
    private final String url;

    protected a(String str, String str2, String str3, int i2, int i3, String str4, long j2, String str5, String str6, String str7, int i4) {
        this.url = str;
        this.JYs = str2;
        this.JZK = str3;
        this.networkType = i2;
        this.JYA = i3;
        this.jgF = this.JYA;
        this.filePath = str4;
        this.jmW = j2;
        this.JZL = str6;
        this.JZM = str7;
        this.md5 = str5;
        this.priority = i4;
    }

    public s gnJ() {
        s sVar = new s();
        sVar.field_url = this.url;
        sVar.field_urlKey = this.JYs;
        sVar.field_fileVersion = this.JZK;
        sVar.field_networkType = this.networkType;
        sVar.field_maxRetryTimes = this.JYA;
        sVar.field_retryTimes = this.jgF;
        sVar.field_filePath = this.filePath;
        sVar.field_status = this.status;
        sVar.field_expireTime = this.jmW;
        sVar.field_groupId1 = this.JZL;
        sVar.field_groupId2 = this.JZM;
        sVar.field_md5 = this.md5;
        sVar.field_priority = this.priority;
        return sVar;
    }

    /* access modifiers changed from: protected */
    public int bdX(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.JYs + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.jmW + ", fileVersion=" + this.JZK + ", maxRetryTimes=" + this.JYA + ", md5='" + this.md5 + '\'' + ", groupId1='" + this.JZL + '\'' + ", groupId2='" + this.JZM + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.jgF + ", status=" + this.status + ", priority=" + this.priority;
    }

    /* renamed from: com.tencent.mm.pluginsdk.j.a.c.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC2019a<T extends a> {
        protected int JYA;
        protected String JYs;
        protected long jmW;
        protected String md5;
        protected int networkType;
        protected int priority;
        protected final String url;

        public AbstractC2019a(String str) {
            this.url = str;
        }

        public final AbstractC2019a<T> bea(String str) {
            this.JYs = str;
            return this;
        }

        public final AbstractC2019a<T> ahX(int i2) {
            this.networkType = i2;
            return this;
        }

        public final AbstractC2019a<T> Ms(long j2) {
            this.jmW = j2;
            return this;
        }

        public final AbstractC2019a<T> ahY(int i2) {
            this.JYA = i2;
            return this;
        }

        public final AbstractC2019a<T> beb(String str) {
            this.md5 = str;
            return this;
        }

        public final AbstractC2019a<T> ahZ(int i2) {
            this.priority = i2;
            return this;
        }
    }
}
