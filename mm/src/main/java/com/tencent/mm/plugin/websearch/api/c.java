package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.kernel.b.a;
import java.util.List;

public interface c extends a {
    String getExposedWord(String str);

    List<String> getNeedReuseBrands();

    List<String> getNeedReuseItems();

    int getSosLimitLength();

    boolean isOpenFingerSearch();

    boolean isOpenHotWordSearch();

    boolean isOpenImageSearch();

    boolean isOpenInlineC2CTag();

    boolean isOpenInlineSnsTag();

    void startImageSearch(o oVar);
}
