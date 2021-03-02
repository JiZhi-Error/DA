package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.g.ac;
import com.tencent.mm.plugin.textstatus.g.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.a;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J&\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/WxImeEmojiUtil;", "", "()V", "TAG", "", "emojiSubTypeArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "getAllEmojiByType", "Lcom/tencent/mm/plugin/textstatus/proto/WxImeEmojiDataList;", "context", "Landroid/content/Context;", "typeName", "subTypeName", "getLastEmojiSubType", "emojiType", "getSubTypeByEmojiType", "saveLastEmojiSubType", "", "subType", "plugin-textstatus_release"})
public final class m {
    private static final ArrayList<j> Vdp;
    public static final m Vdq = new m();

    static {
        AppMethodBeat.i(258378);
        ArrayList<j> arrayList = new ArrayList<>(13);
        Vdp = arrayList;
        String string = MMApplicationContext.getContext().getString(R.string.jdb);
        p.g(string, "MMApplicationContext.get…me_emoji_subtype_emotion)");
        arrayList.add(new j(string, "emotion"));
        ArrayList<j> arrayList2 = Vdp;
        String string2 = MMApplicationContext.getContext().getString(R.string.jdg);
        p.g(string2, "MMApplicationContext.get….ime_emoji_subtype_limbs)");
        arrayList2.add(new j(string2, "limbs"));
        ArrayList<j> arrayList3 = Vdp;
        String string3 = MMApplicationContext.getContext().getString(R.string.jdi);
        p.g(string3, "MMApplicationContext.get…ime_emoji_subtype_person)");
        arrayList3.add(new j(string3, "person"));
        ArrayList<j> arrayList4 = Vdp;
        String string4 = MMApplicationContext.getContext().getString(R.string.jd_);
        p.g(string4, "MMApplicationContext.get…ime_emoji_subtype_animal)");
        arrayList4.add(new j(string4, "animal"));
        ArrayList<j> arrayList5 = Vdp;
        String string5 = MMApplicationContext.getContext().getString(R.string.jda);
        p.g(string5, "MMApplicationContext.get…ime_emoji_subtype_botany)");
        arrayList5.add(new j(string5, "botany"));
        ArrayList<j> arrayList6 = Vdp;
        String string6 = MMApplicationContext.getContext().getString(R.string.jdh);
        p.g(string6, "MMApplicationContext.get…ime_emoji_subtype_nature)");
        arrayList6.add(new j(string6, "nature"));
        ArrayList<j> arrayList7 = Vdp;
        String string7 = MMApplicationContext.getContext().getString(R.string.jde);
        p.g(string7, "MMApplicationContext.get…g.ime_emoji_subtype_food)");
        arrayList7.add(new j(string7, "food"));
        ArrayList<j> arrayList8 = Vdp;
        String string8 = MMApplicationContext.getContext().getString(R.string.jdj);
        p.g(string8, "MMApplicationContext.get….ime_emoji_subtype_place)");
        arrayList8.add(new j(string8, "place"));
        ArrayList<j> arrayList9 = Vdp;
        String string9 = MMApplicationContext.getContext().getString(R.string.jdm);
        p.g(string9, "MMApplicationContext.get…me_emoji_subtype_traffic)");
        arrayList9.add(new j(string9, "traffic"));
        ArrayList<j> arrayList10 = Vdp;
        String string10 = MMApplicationContext.getContext().getString(R.string.jdc);
        p.g(string10, "MMApplicationContext.get…e_emoji_subtype_exercise)");
        arrayList10.add(new j(string10, "exercise"));
        ArrayList<j> arrayList11 = Vdp;
        String string11 = MMApplicationContext.getContext().getString(R.string.jdf);
        p.g(string11, "MMApplicationContext.get….ime_emoji_subtype_goods)");
        arrayList11.add(new j(string11, "goods"));
        ArrayList<j> arrayList12 = Vdp;
        String string12 = MMApplicationContext.getContext().getString(R.string.jdl);
        p.g(string12, "MMApplicationContext.get…ime_emoji_subtype_symbol)");
        arrayList12.add(new j(string12, "symbol"));
        ArrayList<j> arrayList13 = Vdp;
        String string13 = MMApplicationContext.getContext().getString(R.string.jdd);
        p.g(string13, "MMApplicationContext.get…g.ime_emoji_subtype_flag)");
        arrayList13.add(new j(string13, "flag"));
        AppMethodBeat.o(258378);
    }

    private m() {
    }

    public static ad af(Context context, String str, String str2) {
        AppMethodBeat.i(258374);
        p.h(context, "context");
        p.h(str, "typeName");
        p.h(str2, "subTypeName");
        InputStream open = context.getAssets().open("text_status_emoji/" + str2 + ".txt");
        p.g(open, "context.assets.open(file…ASSETS_EMOJI_FILE_SUFFIX)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
        ad adVar = new ad();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + str2 + ' ' + e2.getMessage());
                    }
                    AppMethodBeat.o(258374);
                    return adVar;
                } else if (readLine != null) {
                    ac acVar = new ac();
                    switch (str.hashCode()) {
                        case 96632902:
                            if (str.equals("emoji")) {
                                List<String> b2 = n.b(readLine, new String[]{" "});
                                StringBuilder sb = new StringBuilder();
                                for (String str3 : b2) {
                                    sb.append(Character.toChars(Integer.parseInt(str3, a.avR(16))));
                                }
                                acVar.content = sb.toString();
                                acVar.Vez = readLine;
                                break;
                            }
                            break;
                        case 965124621:
                            if (str.equals("kaoemoji")) {
                                acVar.content = readLine;
                                break;
                            }
                            break;
                    }
                    adVar.IND.add(acVar);
                }
            } catch (IOException e3) {
                Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + str2 + ' ' + e3.getMessage());
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + str2 + ' ' + e4.getMessage());
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                    Log.e("WxIme.WxImeEmojiUtil", "getAllEmojiByType " + str2 + ' ' + e5.getMessage());
                }
                AppMethodBeat.o(258374);
                throw th;
            }
        }
    }

    public static ArrayList<j> dn(Context context, String str) {
        AppMethodBeat.i(258375);
        p.h(context, "context");
        p.h(str, "typeName");
        switch (str.hashCode()) {
            case 96632902:
                if (str.equals("emoji")) {
                    ArrayList<j> arrayList = Vdp;
                    AppMethodBeat.o(258375);
                    return arrayList;
                }
                break;
        }
        ArrayList<j> arrayList2 = new ArrayList<>();
        AppMethodBeat.o(258375);
        return arrayList2;
    }

    public static String byr(String str) {
        String str2;
        AppMethodBeat.i(258376);
        p.h(str, "emojiType");
        com.tencent.mm.plugin.textstatus.j.a aVar = com.tencent.mm.plugin.textstatus.j.a.GfU;
        MultiProcessMMKV kv = com.tencent.mm.plugin.textstatus.j.a.getKV();
        if (kv == null || (str2 = kv.getString(str, "emotion")) == null) {
            str2 = "emotion";
        }
        AppMethodBeat.o(258376);
        return str2;
    }

    public static void iC(String str, String str2) {
        SharedPreferences.Editor edit;
        AppMethodBeat.i(258377);
        p.h(str, "emojiType");
        p.h(str2, "subType");
        com.tencent.mm.plugin.textstatus.j.a aVar = com.tencent.mm.plugin.textstatus.j.a.GfU;
        MultiProcessMMKV kv = com.tencent.mm.plugin.textstatus.j.a.getKV();
        if (kv == null || (edit = kv.edit()) == null) {
            AppMethodBeat.o(258377);
            return;
        }
        edit.putString(str, str2);
        AppMethodBeat.o(258377);
    }
}
