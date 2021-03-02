package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ak.h;
import com.tencent.mm.bb.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import java.util.ArrayList;
import java.util.List;

public interface d extends e {
    boolean V(ArrayList<SmileyInfo> arrayList);

    boolean W(ArrayList<SmileyPanelConfigInfo> arrayList);

    EmojiInfo a(String str, String str2, int i2, int i3, int i4, String str3);

    String a(Context context, WXMediaMessage wXMediaMessage, String str);

    void a(Context context, ca caVar, String str);

    void a(String str, EmojiInfo emojiInfo, ca caVar);

    boolean a(Context context, EmojiInfo emojiInfo, int i2, String str);

    boolean a(EmojiInfo emojiInfo, boolean z);

    boolean a(String str, String str2, long j2, String str3, h.a aVar);

    @Override // com.tencent.mm.pluginsdk.a.e
    byte[] a(EmojiInfo emojiInfo);

    EmojiInfo aml(String str);

    String amn(String str);

    List<EmojiInfo> amo(String str);

    boolean amq(String str);

    ArrayList<String> amr(String str);

    String ams(String str);

    String amt(String str);

    int amu(String str);

    String amv(String str);

    void amw(String str);

    boolean cFH();

    g cFL();

    boolean cFM();

    int d(EmojiInfo emojiInfo, boolean z);

    bi fT(String str, String str2);

    String fU(String str, String str2);

    String getDataEmojiPath();

    int q(EmojiInfo emojiInfo);

    int[] r(EmojiInfo emojiInfo);

    byte[] s(EmojiInfo emojiInfo);

    boolean u(Context context, String str, String str2);

    @Override // com.tencent.mm.pluginsdk.a.e
    void updateEmojiInfo(EmojiInfo emojiInfo);
}
