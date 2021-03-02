package com.tencent.mm.plugin.story.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface l {

    public interface a {
        void a(List<String> list, ArrayList<String> arrayList);

        void as(boolean z, boolean z2);

        void cs(String str, boolean z);
    }

    public interface b {
        void fkX();
    }

    public interface c {
        void a(b bVar);

        void b(b bVar);

        List<String> fnj();

        List<String> fnk();

        LinkedHashMap<String, ArrayList<Long>> fnl();

        int fnm();

        List<String> fnn();

        void fno();
    }

    void a(a aVar);

    void destroy();

    void pause();

    void resume();

    void start();

    public static class d {
        public int dUm = 0;
        public String username = null;

        public d(String str, int i2) {
            this.username = str;
            this.dUm = i2;
        }

        public final boolean fnp() {
            return this.dUm == 1;
        }
    }
}
