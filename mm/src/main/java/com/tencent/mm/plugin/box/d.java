package com.tencent.mm.plugin.box;

public interface d extends com.tencent.mm.kernel.b.d {
    String checkAllHotWords(String str);

    String checkFirstHotWord(String str);

    String getExposedFingerWord(String str);

    String getMatchedFingerWord(String str, String str2);

    int getSearchDuration();

    String getWordBankVersionForStat();
}
