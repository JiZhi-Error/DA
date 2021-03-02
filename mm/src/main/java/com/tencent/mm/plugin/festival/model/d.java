package com.tencent.mm.plugin.festival.model;

public interface d {
    public static final String UxB = (com.tencent.mm.loader.j.b.aKB() + "festival2021/");

    public interface b {
        public static final a UxC = new a("/cgi-bin/micromsg-bin/festivalwishheartbeat", 6861);
        public static final a UxD = new a("/cgi-bin/micromsg-bin/getfestivalwishlist", 6623);
        public static final a UxE = new a("/cgi-bin/micromsg-bin/postfestivalwish", 4243);
        public static final a UxF = new a("/cgi-bin/micromsg-bin/getfestivalwish", 4127);
        public static final a UxG = new a("/cgi-bin/micromsg-bin/likefestivalwish", 4030);
        public static final a UxH = new a("/cgi-bin/micromsg-bin/batchgetfestivalwish", 4056);
        public static final a UxI = new a("/cgi-bin/micromsg-bin/festivalwishreport", 4278);
    }

    public static final class a {
        public final int cmdId;
        public final String uri;

        public a(String str, int i2) {
            this.uri = str;
            this.cmdId = i2;
        }
    }
}
