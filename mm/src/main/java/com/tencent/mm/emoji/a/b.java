package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0014R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "itemList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "EmojiAnimItem", "EmojiAnimScreenEffect", "plugin-emojisdk_release"})
public final class b extends com.tencent.mm.emoji.b.a {
    public final ArrayList<a> gUV = new ArrayList<>();

    public b() {
        AppMethodBeat.i(199874);
        AppMethodBeat.o(199874);
    }

    @Override // com.tencent.mm.emoji.b.a
    public final void c(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(199872);
        p.h(xmlPullParser, "parser");
        this.gUV.clear();
        super.c(xmlPullParser);
        AppMethodBeat.o(199872);
    }

    @Override // com.tencent.mm.emoji.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(199873);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 3242771:
                if (str.equals("item")) {
                    a aVar = new a();
                    aVar.c(xmlPullParser);
                    this.gUV.add(aVar);
                    AppMethodBeat.o(199873);
                    return;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    AppMethodBeat.o(199873);
                    return;
                }
                break;
        }
        skip(xmlPullParser);
        AppMethodBeat.o(199873);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "animFile", "", "getAnimFile", "()Ljava/lang/String;", "setAnimFile", "(Ljava/lang/String;)V", "key", "getKey", "setKey", "screenEffect", "Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "getScreenEffect", "()Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "setScreenEffect", "(Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
    public static final class a extends com.tencent.mm.emoji.b.a {
        public String gUW = "";
        C0317b gUX;
        public String key = "";

        @Override // com.tencent.mm.emoji.b.a
        public final void a(String str, XmlPullParser xmlPullParser) {
            AppMethodBeat.i(199870);
            p.h(str, "tag");
            p.h(xmlPullParser, "parser");
            switch (str.hashCode()) {
                case -2092800739:
                    if (str.equals("screenEffect")) {
                        C0317b bVar = new C0317b();
                        bVar.c(xmlPullParser);
                        this.gUX = bVar;
                        AppMethodBeat.o(199870);
                        return;
                    }
                    break;
                case -796017875:
                    if (str.equals("animFile")) {
                        this.gUW = d(xmlPullParser);
                        AppMethodBeat.o(199870);
                        return;
                    }
                    break;
                case 106079:
                    if (str.equals("key")) {
                        this.key = d(xmlPullParser);
                        AppMethodBeat.o(199870);
                        return;
                    }
                    break;
            }
            skip(xmlPullParser);
            AppMethodBeat.o(199870);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/emoji/egg/EmojiAnimConfig$EmojiAnimScreenEffect;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "delay", "", "getDelay", "()I", "setDelay", "(I)V", "effectId", "", "getEffectId", "()Ljava/lang/String;", "setEffectId", "(Ljava/lang/String;)V", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.a.b$b  reason: collision with other inner class name */
    public static final class C0317b extends com.tencent.mm.emoji.b.a {
        public int delay;
        public String effectId = "";

        @Override // com.tencent.mm.emoji.b.a
        public final void a(String str, XmlPullParser xmlPullParser) {
            AppMethodBeat.i(199871);
            p.h(str, "tag");
            p.h(xmlPullParser, "parser");
            switch (str.hashCode()) {
                case -1017208180:
                    if (str.equals("effectId")) {
                        this.effectId = d(xmlPullParser);
                        AppMethodBeat.o(199871);
                        return;
                    }
                    break;
                case 95467907:
                    if (str.equals("delay")) {
                        this.delay = e(xmlPullParser);
                        AppMethodBeat.o(199871);
                        return;
                    }
                    break;
            }
            skip(xmlPullParser);
            AppMethodBeat.o(199871);
        }
    }
}
