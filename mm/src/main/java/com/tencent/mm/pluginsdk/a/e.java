package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.List;

public interface e {
    byte[] a(EmojiInfo emojiInfo);

    boolean amA(String str);

    void amB(String str);

    void amC(String str);

    EmojiInfo amm(String str);

    String amp(String str);

    void amy(String str);

    boolean amz(String str);

    boolean ave();

    boolean avf();

    <T> T c(ar.a aVar, T t);

    ArrayList<SmileyInfo> cFJ();

    ArrayList<SmileyPanelConfigInfo> cFK();

    String cFN();

    void cFO();

    boolean cFP();

    List<v> cFQ();

    void cFR();

    boolean cFS();

    void d(ar.a aVar, Object obj);

    String getAccPath();

    void h(MStorage.IOnStorageChange iOnStorageChange);

    void i(MStorage.IOnStorageChange iOnStorageChange);

    void j(MStorage.IOnStorageChange iOnStorageChange);

    void k(MStorage.IOnStorageChange iOnStorageChange);

    EmojiInfo l(String str, int i2, int i3, int i4);

    void onDestroy();

    EmojiInfo p(EmojiInfo emojiInfo);

    void t(EmojiInfo emojiInfo);

    void updateEmojiInfo(EmojiInfo emojiInfo);
}
