package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.o;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/model/EggGameParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "gameInfo", "Lcom/tencent/mm/modelpackage/EggGame;", "getGameInfo", "()Lcom/tencent/mm/modelpackage/EggGame;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class g extends a {
    final d gWY = new d();

    public g() {
        AppMethodBeat.i(199912);
        AppMethodBeat.o(199912);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.emoji.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(199911);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case -1578523488:
                if (str.equals("AndroidURL")) {
                    this.gWY.jgI = d(xmlPullParser);
                    AppMethodBeat.o(199911);
                    return;
                }
                break;
            case -1213391326:
                if (str.equals("iOSURL")) {
                    this.gWY.jgH = d(xmlPullParser);
                    AppMethodBeat.o(199911);
                    return;
                }
                break;
            case -1061003427:
                if (str.equals("EntryAnimType")) {
                    o oVar = new o();
                    oVar.jhq = 1;
                    int e2 = e(xmlPullParser, "size");
                    oVar.jhr = e2;
                    oVar.maxSize = e2;
                    oVar.fileName = d(xmlPullParser, DownloadInfo.FILENAME);
                    oVar.jhn = e(xmlPullParser);
                    this.gWY.jgJ = oVar;
                    AppMethodBeat.o(199911);
                    return;
                }
                break;
            case 63475452:
                if (str.equals("AppId")) {
                    this.gWY.appId = d(xmlPullParser);
                    AppMethodBeat.o(199911);
                    return;
                }
                break;
        }
        skip(xmlPullParser);
        AppMethodBeat.o(199911);
    }
}