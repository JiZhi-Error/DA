package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.o;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/emoji/model/EggItemParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "isNewItem", "", "(Z)V", "defaultAnim", "Lcom/tencent/mm/modelpackage/NewAnim;", "info", "Lcom/tencent/mm/modelpackage/EggInfo;", "getInfo", "()Lcom/tencent/mm/modelpackage/EggInfo;", "luckyBagValid", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "plugin-emojisdk_release"})
public final class h extends a {
    final e gWZ = new e();
    private final o gXa = new o();
    private final boolean gXb;

    public h(boolean z) {
        AppMethodBeat.i(105504);
        this.gXb = z;
        AppMethodBeat.o(105504);
    }

    @Override // com.tencent.mm.emoji.b.a
    public final void c(XmlPullParser xmlPullParser) {
        int i2;
        int i3;
        int i4 = LocalCache.TIME_DAY;
        int i5 = 0;
        AppMethodBeat.i(105502);
        p.h(xmlPullParser, "parser");
        this.gWZ.name = d(xmlPullParser, "name");
        this.gWZ.dYn = e(xmlPullParser, "reportType");
        this.gWZ.jgO = d(xmlPullParser, "langs");
        String d2 = d(xmlPullParser, "BeginDate");
        String d3 = d(xmlPullParser, "EndDate");
        String d4 = d(xmlPullParser, "BeginTimeInterval");
        String d5 = d(xmlPullParser, "EndTimeInterval");
        super.c(xmlPullParser);
        this.gWZ.jgM = Util.getSeconds(d2, 0);
        this.gWZ.jgN = Util.getSeconds(d3, 0);
        if (this.gWZ.jgM == 0 && this.gWZ.jgN == 0) {
            AppMethodBeat.o(105502);
            return;
        }
        if (this.gWZ.jgP >= 3) {
            if (!Util.isNullOrNil(d4)) {
                i2 = Util.safeParseInt(d4);
            } else {
                i2 = 0;
            }
            if (!Util.isNullOrNil(d5)) {
                i3 = Util.safeParseInt(d5);
            } else {
                i3 = 86400;
            }
            int max = Math.max(0, Math.min(i2, (int) LocalCache.TIME_DAY));
            i4 = Math.max(0, Math.min(i3, (int) LocalCache.TIME_DAY));
            i5 = max;
        }
        e eVar = this.gWZ;
        eVar.jgM = i5 + eVar.jgM;
        this.gWZ.jgN += i4;
        AppMethodBeat.o(105502);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.emoji.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(105503);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case -1289878496:
                if (str.equals("LuckyBag")) {
                    o oVar = new o();
                    oVar.c(xmlPullParser);
                    if (Util.isNullOrNil(oVar.gXT.appId)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1263, 0);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        this.gWZ.gXT = oVar.gXT;
                        AppMethodBeat.o(105503);
                        return;
                    }
                }
                skip(xmlPullParser);
                break;
            case -730941173:
                if (str.equals("AnimType")) {
                    this.gXa.jhq = e(xmlPullParser, "viewcount");
                    this.gXa.jhr = e(xmlPullParser, "minSize");
                    this.gXa.maxSize = e(xmlPullParser, "maxSize");
                    this.gXa.jhn = e(xmlPullParser);
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case -671077817:
                if (str.equals("FileName")) {
                    this.gWZ.jgQ.add(this.gXa);
                    this.gXa.fileName = d(xmlPullParser);
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case -177232682:
                if (str.equals("RedEnvelopeCover")) {
                    q qVar = new q();
                    qVar.c(xmlPullParser);
                    this.gWZ.uBT = qVar.uBT;
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case 2211858:
                if (str.equals("Game")) {
                    g gVar = new g();
                    gVar.c(xmlPullParser);
                    this.gWZ.gWY = gVar.gWY;
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case 2622298:
                if (str.equals("Type")) {
                    this.gWZ.type = e(xmlPullParser);
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case 849291753:
                if (str.equals("KeyWord")) {
                    f fVar = new f();
                    fVar.lang = d(xmlPullParser, "lang");
                    fVar.jgR = d(xmlPullParser);
                    String str2 = fVar.jgR;
                    p.g(str2, "eggKeyWord.keyWord");
                    if (str2.length() <= 0) {
                        z2 = false;
                    }
                    if (z2) {
                        this.gWZ.jgK.add(fVar);
                        AppMethodBeat.o(105503);
                        return;
                    }
                }
                skip(xmlPullParser);
                break;
            case 947396446:
                if (str.equals("ClientEggVersion")) {
                    if (this.gXb) {
                        this.gWZ.jgP = e(xmlPullParser);
                        AppMethodBeat.o(105503);
                        return;
                    }
                    skip(xmlPullParser);
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            case 2129029771:
                if (str.equals("NewAnimType")) {
                    o oVar2 = new o();
                    oVar2.jhq = e(xmlPullParser, "viewcount");
                    oVar2.jhr = e(xmlPullParser, "minSize");
                    oVar2.maxSize = e(xmlPullParser, "maxSize");
                    oVar2.fileName = d(xmlPullParser, DownloadInfo.FILENAME);
                    oVar2.jhn = e(xmlPullParser);
                    this.gWZ.jgQ.add(oVar2);
                    AppMethodBeat.o(105503);
                    return;
                }
                skip(xmlPullParser);
                break;
            default:
                skip(xmlPullParser);
                break;
        }
        AppMethodBeat.o(105503);
    }
}
