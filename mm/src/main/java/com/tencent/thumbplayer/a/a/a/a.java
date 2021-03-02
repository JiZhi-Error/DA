package com.tencent.thumbplayer.a.a.a;

public interface a {

    /* renamed from: com.tencent.thumbplayer.a.a.a.a$a  reason: collision with other inner class name */
    public interface AbstractC2198a {
        void a(c cVar);
    }

    public interface b {
        long getCurrentPosition();
    }

    void a(AbstractC2198a aVar);

    void a(b bVar);

    void prepare();

    void release();

    void reset();

    void setDataSource(String str);

    void stop();

    public static class c {
        String text;

        public c(String str) {
            this.text = str;
        }
    }
}
