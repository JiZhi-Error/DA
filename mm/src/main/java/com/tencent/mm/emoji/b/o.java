package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/emoji/model/LuckyBagParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "luckyBag", "Lcom/tencent/mm/modelpackage/LuckyBag;", "getLuckyBag", "()Lcom/tencent/mm/modelpackage/LuckyBag;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class o extends a {
    final k gXT = new k();

    public o() {
        AppMethodBeat.i(105525);
        AppMethodBeat.o(105525);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.emoji.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(105524);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case -2025406440:
                if (str.equals("SubTitle")) {
                    this.gXT.jgZ = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -1563547017:
                if (str.equals("CouponSmallTitle")) {
                    this.gXT.jhh = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -1282287868:
                if (str.equals("ButtonTextColor")) {
                    this.gXT.jhk = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -1061003427:
                if (str.equals("EntryAnimType")) {
                    com.tencent.mm.bb.l lVar = new com.tencent.mm.bb.l();
                    lVar.size = e(xmlPullParser, "size");
                    lVar.fileName = d(xmlPullParser, DownloadInfo.FILENAME);
                    lVar.jhn = e(xmlPullParser);
                    this.gXT.jhm = lVar;
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -834434302:
                if (str.equals("UseLightStyle")) {
                    this.gXT.zpS = e(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -511925738:
                if (str.equals("DefaultCover")) {
                    this.gXT.jhl = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -473313749:
                if (str.equals("SubTitleColor")) {
                    this.gXT.jha = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case -270362873:
                if (str.equals("RedEnvelopeCoverSmallTitle")) {
                    this.gXT.jhf = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 6969246:
                if (str.equals("CouponBigTitle")) {
                    this.gXT.jhg = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 63475452:
                if (str.equals("AppId")) {
                    this.gXT.appId = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 231778350:
                if (str.equals("RedEnvelopeCoverBigTitle")) {
                    this.gXT.jhe = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 290107061:
                if (str.equals("BackgroundColor")) {
                    this.gXT.jhc = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 425268249:
                if (str.equals("BackgroundLogo")) {
                    this.gXT.jhd = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 1216348288:
                if (str.equals("BrandIcon")) {
                    this.gXT.jhb = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 1216495250:
                if (str.equals("BrandName")) {
                    this.gXT.brandName = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 1435418957:
                if (str.equals("LoadingAnim")) {
                    this.gXT.jhi = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 1465142563:
                if (str.equals("ButtonBackgroundColor")) {
                    this.gXT.jhj = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 1742469119:
                if (str.equals("MainTitle")) {
                    this.gXT.jgX = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
            case 2098097828:
                if (str.equals("MainTitleColor")) {
                    this.gXT.jgY = d(xmlPullParser);
                    AppMethodBeat.o(105524);
                    return;
                }
                break;
        }
        skip(xmlPullParser);
        AppMethodBeat.o(105524);
    }
}
