package com.tencent.mm.plugin.brandservice.a;

import com.tencent.xweb.WebResourceResponse;
import java.util.List;

public interface e extends com.tencent.mm.kernel.c.a {

    public static class a {
        public String appId;
        public String desc;
        public String extInfo;
        public String from;
        public int pmM = 999;
        public int pmN;
        public String title;
        public String url;
    }

    public static class b {
        public String appId;
        public int hDa;
        public int pmN;
        public long pmO;
        public String pmP;
        public WebResourceResponse pmQ;
        public String url;
    }

    b R(String str, String str2, String str3);

    void a(String str, int i2, String str2, String str3, String str4, String str5, int i3);

    boolean ahB(String str);

    String ahC(String str);

    boolean ahD(String str);

    int ahE(String str);

    b ahF(String str);

    void ahG(String str);

    String ahH(String str);

    void cF(String str, int i2);

    void cu(List<a> list);

    boolean fd(String str, String str2);

    void m(List<a> list, int i2);
}
