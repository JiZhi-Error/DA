package com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public String DrQ;
    public final List<b> DxV = new ArrayList();

    public a() {
        AppMethodBeat.i(202155);
        AppMethodBeat.o(202155);
    }

    public final String toString() {
        AppMethodBeat.i(202156);
        String str = "TopicCardResponseModel{relationText='" + this.DrQ + '\'' + ", resInfos=" + this.DxV + '}';
        AppMethodBeat.o(202156);
        return str;
    }

    public static class b {
        public String DrT;
        public String DrV;
        public C1711a DxW;
        public String desc;
        public String nickname;
        public String tag;
        public String uNR;

        public final String toString() {
            AppMethodBeat.i(202154);
            String str = "TopicResInfo{avatar='" + this.uNR + '\'' + ", nickname='" + this.nickname + '\'' + ", tag='" + this.tag + '\'' + ", desc='" + this.desc + '\'' + ", barBgColor='" + this.DrT + '\'' + ", duration='" + this.DrV + '\'' + ", mediaInfo=" + this.DxW + '}';
            AppMethodBeat.o(202154);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a$a  reason: collision with other inner class name */
    public static class C1711a {
        public int cnR;
        public String dWJ;
        public int height;
        public String url;
        public String wQO;
        public int width;

        public final String toString() {
            AppMethodBeat.i(202153);
            String str = "MediaInfo{mid='" + this.wQO + '\'' + ", url='" + this.url + '\'' + ", thumb='" + this.dWJ + '\'' + ", width=" + this.width + ", height=" + this.height + ", totalSize=" + this.cnR + '}';
            AppMethodBeat.o(202153);
            return str;
        }
    }
}
