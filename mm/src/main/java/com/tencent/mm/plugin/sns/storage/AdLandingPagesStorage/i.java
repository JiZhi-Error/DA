package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class i {
    public static int Eln = 750;
    public static int Elo = 10;
    private static Set<b> Elp = null;

    static /* synthetic */ z b(Map map, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(97358);
        z a2 = a(map, i2, i3, i4, i5, str);
        AppMethodBeat.o(97358);
        return a2;
    }

    static /* synthetic */ void b(z zVar, Map map, String str, int i2, int i3, int i4) {
        AppMethodBeat.i(97359);
        a(zVar, map, str, i2, i3, i4);
        AppMethodBeat.o(97359);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int Elu;
        int Elv;
        int Elw;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.Elu == this.Elu && bVar.Elv == this.Elv && bVar.Elw == this.Elw) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.Elu + this.Elv + this.Elw;
        }

        public final String toString() {
            AppMethodBeat.i(97331);
            String str = "[nodeType=" + this.Elu + ",compType=" + this.Elv + ",subCompType=" + this.Elw + "]";
            AppMethodBeat.o(97331);
            return str;
        }
    }

    public static boolean Zi(int i2) {
        if (i2 == 101 || i2 == 103 || i2 == 104 || i2 == 105 || i2 == 139) {
            return true;
        }
        return false;
    }

    public static boolean Zj(int i2) {
        if (i2 == 101) {
            return true;
        }
        return false;
    }

    public static boolean Zk(int i2) {
        if (i2 == 103) {
            return true;
        }
        return false;
    }

    public static boolean Zl(int i2) {
        if (i2 == 104) {
            return true;
        }
        return false;
    }

    public static boolean Zm(int i2) {
        if (i2 == 105) {
            return true;
        }
        return false;
    }

    public static boolean Zn(int i2) {
        return i2 == 139;
    }

    public static float a(double d2, int i2, int i3, int i4) {
        AppMethodBeat.i(97332);
        if (i2 == 0) {
            float f2 = (float) d2;
            AppMethodBeat.o(97332);
            return f2;
        } else if (i3 == 0) {
            float f3 = (float) d2;
            AppMethodBeat.o(97332);
            return f3;
        } else {
            int[] ha = ap.ha(MMApplicationContext.getContext());
            float bU = (float) ap.bU((((float) Math.min(ha[0], ha[1])) * (((float) d2) * ((float) i4))) / ((float) i3));
            AppMethodBeat.o(97332);
            return bU;
        }
    }

    private static Intent aR(Map<String, String> map) {
        AppMethodBeat.i(203159);
        com.tencent.mm.plugin.sns.device.appstore.a b2 = com.tencent.mm.plugin.sns.device.appstore.a.b(MMApplicationContext.getContext(), map);
        if (b2 != null) {
            Intent eZA = b2.eZA();
            AppMethodBeat.o(203159);
            return eZA;
        }
        AppMethodBeat.o(203159);
        return null;
    }

    private static z a(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        z zVar;
        int argb;
        String str2;
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b qVar;
        String str3;
        Intent aR;
        AppMethodBeat.i(97333);
        int safeParseInt = Util.safeParseInt(map.get(str + ".type"));
        int safeParseInt2 = Util.safeParseInt(map.get(str + ".subType"));
        switch (safeParseInt) {
            case 1:
                ag agVar = new ag();
                agVar.DZj = safeParseInt;
                agVar.subType = safeParseInt2;
                agVar.DZP = Util.nullAs(map.get(str + ".content"), "");
                agVar.textAlignment = Util.safeParseInt(map.get(str + ".textAlignment"));
                agVar.zyf = Util.nullAs(map.get(str + ".fontColor"), "");
                agVar.textSize = a(Util.safeParseDouble(map.get(str + ".fontSize")), i2, i3, i4);
                agVar.DZQ = (Util.safeParseInt(map.get(new StringBuilder().append(str).append(".showType").toString())) & ag.DZK) > 0;
                agVar.DZR = (Util.safeParseInt(map.get(new StringBuilder().append(str).append(".showType").toString())) & ag.DZL) > 0;
                agVar.DZS = (Util.safeParseInt(map.get(new StringBuilder().append(str).append(".showType").toString())) & ag.DZM) > 0;
                agVar.maxLines = Util.safeParseInt(map.get(str + ".maxLines"));
                agVar.DYv = Util.safeParseInt(map.get(str + ".fontType"));
                agVar.DZT = Util.safeParseFloat(map.get(str + ".lineSpace"));
                zVar = agVar;
                break;
            case 21:
                if (safeParseInt2 == 2) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b();
                    bVar.dNI = map.get(str + ".appid");
                    bVar.DXy = map.get(str + ".wxAppid");
                    bVar.DXz = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".useGameDownloadWidget").toString())) == 1;
                    bVar.appPageUrl = map.get(str + ".appPageUrlAndroid");
                    bVar.channelId = map.get(str + ".channelId");
                    bVar.LG = map.get(str + ".pkg");
                    bVar.DXC = Util.safeParseInt(map.get(str + ".platform"));
                    bVar.DXD = map.get(str + ".warningAndroid");
                    bVar.DXE = map.get(str + ".btnBgColorTheme");
                    bVar.DXG = map.get(str + ".btnBgColorThemePressed");
                    bVar.DXF = map.get(str + ".btnBgColorThemeDisable");
                    bVar.DXH = map.get(str + ".btnBorderColorTheme");
                    bVar.DXJ = map.get(str + ".btnBorderColorThemePressed");
                    bVar.DXI = map.get(str + ".btnBorderColorThemeDisable");
                    bVar.DXK = map.get(str + ".fontColor");
                    bVar.DXM = map.get(str + ".fontColorPressed");
                    bVar.DXL = map.get(str + ".fontColorDisable");
                    bVar.DXP = Util.safeParseInt(map.get(str + ".showDownloadTip"));
                    bVar.DXQ = Util.safeParseInt(map.get(str + ".marketFlag"));
                    if (bVar.DXQ > 0 && (aR = aR(map)) != null) {
                        bVar.DXR = aR;
                    }
                    qVar = bVar;
                } else if (safeParseInt2 == 4) {
                    f fVar = new f();
                    fVar.cardTpId = Util.nullAs(map.get(str + ".cardTpId"), "");
                    fVar.cardExt = Util.nullAs(map.get(str + ".cardExt"), "");
                    qVar = fVar;
                } else if (safeParseInt2 == 7) {
                    l lVar = new l();
                    lVar.DYd = Util.nullAs(map.get(str + ".jumpCanvasId"), "");
                    lVar.DYe = Util.nullAs(map.get(str + ".jumpCanvasExt"), "");
                    lVar.DYf = Util.safeParseInt(map.get(str + ".jumpCanvasNoStore"));
                    lVar.DYg = Util.safeParseInt(map.get(str + ".btnCanvasEnterType"));
                    lVar.DYh = Util.safeParseInt(map.get(str + ".btnCanvasSource"));
                    qVar = lVar;
                } else if (safeParseInt2 == 8) {
                    k kVar = new k();
                    kVar.username = map.get(str + ".weappUserName");
                    kVar.ecK = map.get(str + ".weappPath");
                    kVar.weAppType = Util.safeParseInt(map.get(str + ".miniProgramType"));
                    qVar = kVar;
                } else if (safeParseInt2 == 9) {
                    double safeParseDouble = Util.safeParseDouble(map.get(str + ".location.$x"));
                    double safeParseDouble2 = Util.safeParseDouble(map.get(str + ".location.$y"));
                    int safeParseInt3 = Util.safeParseInt(map.get(str + ".location.$scale"));
                    String str4 = map.get(str + ".location.$label");
                    String str5 = map.get(str + ".location.$poiname");
                    if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str5)) {
                        qVar = new h(new h.a(safeParseDouble, safeParseDouble2, safeParseInt3, str4, str5));
                    } else {
                        AppMethodBeat.o(97333);
                        return null;
                    }
                } else if (safeParseInt2 == 10) {
                    String str6 = str + ".phoneNumList.phoneNum";
                    ArrayList arrayList = new ArrayList();
                    int i6 = 0;
                    while (true) {
                        if (i6 == 0) {
                            str3 = map.get(str6);
                        } else {
                            str3 = map.get(str6 + i6);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            arrayList.add(str3);
                            i6++;
                        } else if (!arrayList.isEmpty()) {
                            qVar = new j(arrayList);
                        } else {
                            AppMethodBeat.o(97333);
                            return null;
                        }
                    }
                } else if (safeParseInt2 == 12) {
                    n nVar = new n();
                    nVar.weappUserName = map.get(str + ".weappUserName");
                    nVar.DYj = map.get(str + ".weAppID");
                    nVar.businessId = map.get(str + ".businessId");
                    nVar.lRW = map.get(str + ".sessionFrom");
                    nVar.DYk = Util.safeParseInt(map.get(str + ".showMessageCard"));
                    nVar.lSf = Util.nullAsNil(map.get(str + ".sendMessageTitle"));
                    nVar.lSh = Util.nullAsNil(map.get(str + ".sendMessageImg"));
                    nVar.lSg = Util.nullAsNil(map.get(str + ".sendMessagePath"));
                    qVar = nVar;
                } else if (safeParseInt2 == 13) {
                    o oVar = new o();
                    oVar.DYl = Util.safeParseInt(map.get(str + ".sid"));
                    oVar.DYm = Util.safeParseInt(map.get(str + ".compid"));
                    qVar = oVar;
                } else if (safeParseInt2 == 14) {
                    g gVar = new g();
                    gVar.DXZ = Util.nullAsNil(map.get(str + ".redEnvelopsSkinBtnDisableWording"));
                    gVar.DYa = Util.safeParseLong(str + ".redEnvelopsSkinDisableTime");
                    gVar.dOD = Util.nullAsNil(map.get(str + ".redEnvelopesSkinId"));
                    qVar = gVar;
                } else if (safeParseInt2 == 15) {
                    ab abVar = new ab();
                    abVar.DZy = Util.nullAs(map.get(str + ".qrUrl"), "");
                    abVar.DYM = Util.nullAs(map.get(str + ".qrExtInfo"), "");
                    abVar.DZz = Util.safeParseInt(map.get(str + ".needUpdateQrUrl"));
                    qVar = abVar;
                } else if (safeParseInt2 == 16) {
                    ac acVar = new ac();
                    acVar.DZA = ADXml.b.F(map, ".adxml.adScanInfo");
                    qVar = acVar;
                } else if (safeParseInt2 == 17) {
                    w wVar = new w();
                    wVar.brandUsername = Util.nullAs(map.get(str + ".brandUsername"), "");
                    wVar.brandHead = Util.nullAs(map.get(str + ".brandHead"), "");
                    wVar.brandName = Util.nullAs(map.get(str + ".brandName"), "");
                    wVar.brandDesc = Util.nullAs(map.get(str + ".brandDesc"), "");
                    wVar.btnTitleAfterAddBrand = Util.nullAs(map.get(str + ".btnTitleAfterAddBrand"), "");
                    qVar = wVar;
                } else if (safeParseInt2 == 18) {
                    m mVar = new m();
                    mVar.DYi = Util.nullAsNil(map.get(str + ".wxGroupInfo"));
                    qVar = mVar;
                } else if (safeParseInt2 == 19) {
                    com.tencent.mm.plugin.sns.ad.landingpage.component.b.a aVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.a();
                    aVar.couponAppId = Util.nullAs(map.get(str + ".couponAppId"), "");
                    aVar.couponStockId = Util.nullAs(map.get(str + ".couponStockId"), "");
                    qVar = aVar;
                } else if (safeParseInt2 == 20) {
                    c cVar = new c();
                    cVar.finderUsername = Util.nullAsNil(map.get(str + ".finderUsername"));
                    cVar.finderLiveNoticeId = Util.nullAsNil(map.get(str + ".finderLiveNoticeId"));
                    qVar = cVar;
                } else if (safeParseInt2 == 21) {
                    e eVar = new e();
                    eVar.finderUsername = Util.nullAsNil(map.get(str + ".finderUsername"));
                    qVar = eVar;
                } else {
                    qVar = new q();
                }
                qVar.DZj = safeParseInt;
                qVar.subType = safeParseInt2;
                qVar.title = Util.nullAs(map.get(str + ".btnTitle"), "");
                qVar.DYq = Util.safeParseInt(map.get(str + ".btnType"));
                qVar.DYr = Util.nullAs(map.get(str + ".btnJumpUrl"), "");
                qVar.DYs = Util.nullAs(map.get(str + ".btnJumpApp"), "");
                qVar.DYt = Util.nullAs(map.get(str + ".fontColor"), "");
                qVar.fontSize = a(Util.safeParseDouble(map.get(str + ".fontSize")), i2, i3, i4);
                qVar.DYv = Util.safeParseInt(map.get(str + ".btnFontType"));
                qVar.textAlignment = Util.safeParseInt(map.get(str + ".btnAlignment"));
                qVar.DYu = a(Util.safeParseDouble(map.get(str + ".borderSize")), i2, i3, i4);
                qVar.height = a(Util.safeParseDouble(map.get(str + ".btnHeight")), i2, i3, i4);
                qVar.DYw = Util.nullAs(map.get(str + ".btnBgColorTheme"), "");
                qVar.DYx = Util.nullAs(map.get(str + ".btnBorderColorTheme"), "");
                qVar.DYy = Util.nullAs(map.get(str + ".btnBgImgUrl"), "");
                qVar.DYz = Util.safeParseInt(map.get(str + ".bCanLongPress"));
                qVar.DYA = Util.safeParseInt(map.get(str + ".bHideActionSheet"));
                qVar.DYB = Util.safeParseInt(map.get(str + ".hideProductActionHeader"));
                qVar.DYC = Util.safeParseInt(map.get(str + ".showProductActionCancelButton"));
                qVar.DYE = Util.nullAs(map.get(str + ".productActionTitle"), "");
                qVar.DYD = Util.nullAs(map.get(str + ".productActionBuffer"), "");
                qVar.DYF = Util.nullAs(map.get(str + ".productActionIconUrl"), "");
                qVar.tt = a((double) Util.safeParseInt(map.get(str + ".cornerRadius")), i2, i3, i4);
                qVar.DYH = Util.nullAs(map.get(str + ".btnIconUrl"), "");
                if (map.containsKey(str + ".productActionItem.componentItem.type")) {
                    qVar.DYG = a(map, i2, i3, i4, i5, str + ".productActionItem.componentItem");
                }
                zVar = qVar;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                t tVar = new t();
                tVar.DZj = safeParseInt;
                tVar.subType = safeParseInt2;
                tVar.DYK = Util.nullAs(map.get(str + ".pureImageUrl"), "");
                tVar.DWN = Util.nullAs(map.get(str + ".bgColor"), "");
                if (map.containsKey(str + ".bgColorAlpha") && tVar.DWN.length() > 0) {
                    tVar.DWN = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str + ".bgColorAlpha")) * 255.0d)), tVar.DWN.substring(1));
                }
                tVar.width = a(Util.safeParseDouble(map.get(str + ".imageWidth")), i2, i3, i4);
                tVar.height = a(Util.safeParseDouble(map.get(str + ".imageHeight")), i2, i3, i4);
                tVar.DYJ = false;
                tVar.DYL = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".enableQRScan").toString())) == 1;
                tVar.DYM = Util.nullAs(map.get(str + ".qrExtInfo"), "");
                tVar.DYN = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".needUpdateQrUrl").toString())) == 1;
                tVar.tt = a((double) Util.safeParseInt(map.get(str + ".cornerRadius")), i2, i3, i4);
                zVar = tVar;
                break;
            case 44:
                s sVar = new s();
                sVar.DZj = safeParseInt;
                sVar.subType = safeParseInt2;
                sVar.DYK = Util.nullAs(map.get(str + ".panoramaImageUrl"), "");
                sVar.width = a(Util.safeParseDouble(map.get(str + ".imageWidth")), i2, i3, i4);
                sVar.height = a(Util.safeParseDouble(map.get(str + ".imageHeight")), i2, i3, i4);
                zVar = sVar;
                break;
            case 45:
                t tVar2 = new t();
                tVar2.DZj = safeParseInt;
                tVar2.subType = safeParseInt2;
                tVar2.DYK = Util.nullAs(map.get(str + ".fullScreenImageUrl"), "");
                tVar2.DYJ = true;
                tVar2.DYL = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".enableQRScan").toString())) == 1;
                tVar2.scaleType = Util.safeParseInt(map.get(str + ".scaleType"));
                zVar = tVar2;
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                v vVar = new v();
                vVar.DZj = safeParseInt;
                vVar.subType = safeParseInt2;
                vVar.DYQ = Util.nullAs(map.get(str + ".sightVideoUrl"), "");
                vVar.DYR = Util.nullAs(map.get(str + ".sightThumbUrl"), "");
                vVar.DYS = Util.nullAs(map.get(str + ".streamVideoUrl"), "");
                vVar.DYT = Util.nullAs(map.get(str + ".jumpText"), "");
                vVar.DYd = Util.nullAs(map.get(str + ".jumpCanvasId"), "");
                vVar.DYe = Util.nullAs(map.get(str + ".jumpCanvasExt"), "");
                vVar.DYf = Util.safeParseInt(map.get(str + ".jumpCanvasNoStore"));
                try {
                    vVar.DYU = Color.parseColor(map.get(str + ".jumpTextColor"));
                } catch (Exception e2) {
                    vVar.DYU = Color.rgb(255, 255, 255);
                }
                try {
                    vVar.DYV = Color.parseColor(map.get(str + ".separatorColor"));
                } catch (Exception e3) {
                    vVar.DYV = Color.rgb(255, 255, 255);
                }
                vVar.width = a(Util.safeParseDouble(map.get(str + ".sightDisplayWidth")), i2, i3, i4);
                vVar.height = a(Util.safeParseDouble(map.get(str + ".sightDisplayHeight")), i2, i3, i4);
                vVar.DYW = Util.safeParseInt(map.get(str + ".sightDisplayType"));
                String nullAsNil = Util.nullAsNil(map.get(str + ".floatComponentId"));
                int safeParseInt4 = Util.safeParseInt(map.get(str + ".floatStartTime"));
                if (!Util.isNullOrNil(nullAsNil) && safeParseInt4 > 0) {
                    ai aiVar = new ai();
                    aiVar.dVe = nullAsNil;
                    aiVar.Eab = safeParseInt4;
                    vVar.DYX = aiVar;
                }
                vVar.DYY = Util.safeParseInt(map.get(".adxml.adCanvasInfo.heightRoundingType")) > 0;
                vVar.DYZ = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".downloadVideoByCdn").toString())) > 0;
                vVar.DZa = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".forbiddenControlView").toString())) > 0;
                vVar.DZc = j(map, str + ".floatBarComponentItem", i2, i3, i4, i5);
                vVar.DZb = Util.safeParseLong(map.get(str + ".fileSize"));
                zVar = vVar;
                break;
            case 62:
                am amVar = new am();
                amVar.DZj = safeParseInt;
                amVar.subType = safeParseInt2;
                amVar.DYS = Util.nullAs(map.get(str + ".streamVideoUrl"), "");
                amVar.Ead = Util.nullAs(map.get(str + ".streamVideoThumb"), "");
                amVar.width = a(Util.safeParseDouble(map.get(str + ".streamDisplayWidth")), i2, i3, i4);
                amVar.height = a(Util.safeParseDouble(map.get(str + ".streamDisplayHeight")), i2, i3, i4);
                amVar.Eae = Util.safeParseInt(map.get(str + ".streamDisplayType"));
                String nullAsNil2 = Util.nullAsNil(map.get(str + ".floatComponentId"));
                int safeParseInt5 = Util.safeParseInt(map.get(str + ".floatStartTime"));
                if (!Util.isNullOrNil(nullAsNil2) && safeParseInt5 > 0) {
                    ai aiVar2 = new ai();
                    aiVar2.dVe = nullAsNil2;
                    aiVar2.Eab = safeParseInt5;
                    amVar.DYX = aiVar2;
                }
                amVar.DYY = Util.safeParseInt(map.get(".adxml.adCanvasInfo.heightRoundingType")) > 0;
                amVar.DZc = j(map, str + ".floatBarComponentItem", i2, i3, i4, i5);
                amVar.Eaf = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".alwaysAutoPlay").toString())) == 1;
                amVar.Eag = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".forceLandscapeWhenTurnToFullScreen").toString())) == 1;
                zVar = amVar;
                break;
            case 81:
                al alVar = new al();
                alVar.DZj = safeParseInt;
                alVar.subType = safeParseInt2;
                alVar.h5Url = Util.nullAs(map.get(str + ".webviewUrl"), "");
                zVar = alVar;
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*{ENCODED_INT: 82}*/:
                an anVar = new an();
                anVar.url = Util.nullAs(map.get(str + ".webviewUrl"), "");
                anVar.DYM = Util.nullAs(map.get(str + ".qrExtInfo"), "");
                zVar = anVar;
                break;
            case 102:
                zVar = c(map, str, i2, i3, i4, i5);
                break;
            case 121:
            case 122:
                double a2 = (double) a(Util.safeParseDouble(map.get(str + ".topLineSize")), i2, i3, i4);
                double a3 = (double) a(Util.safeParseDouble(map.get(str + ".bottomLineSize")), i2, i3, i4);
                if (Zo(i5)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (safeParseInt != 121) {
                    if (safeParseInt != 122) {
                        zVar = null;
                        break;
                    } else {
                        String str7 = str + ".phoneNumList.phoneNum";
                        ArrayList arrayList2 = new ArrayList();
                        int i7 = 0;
                        while (true) {
                            if (i7 == 0) {
                                str2 = map.get(str7);
                            } else {
                                str2 = map.get(str7 + i7);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                arrayList2.add(str2);
                                i7++;
                            } else if (!arrayList2.isEmpty()) {
                                zVar = new d(a2, a3, argb, arrayList2);
                                break;
                            } else {
                                AppMethodBeat.o(97333);
                                return null;
                            }
                        }
                    }
                } else {
                    double safeParseDouble3 = Util.safeParseDouble(map.get(str + ".location.$x"));
                    double safeParseDouble4 = Util.safeParseDouble(map.get(str + ".location.$y"));
                    int safeParseInt6 = Util.safeParseInt(map.get(str + ".location.$scale"));
                    String str8 = map.get(str + ".location.$label");
                    String str9 = map.get(str + ".location.$poiname");
                    if (!TextUtils.isEmpty(str8) || !TextUtils.isEmpty(str9)) {
                        zVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i(a2, a3, new i.a(safeParseDouble3, safeParseDouble4, safeParseInt6, str8, str9), argb);
                        break;
                    } else {
                        AppMethodBeat.o(97333);
                        return null;
                    }
                }
                break;
            case TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE /*{ENCODED_INT: 131}*/:
                ae aeVar = new ae();
                aeVar.DZj = safeParseInt;
                aeVar.subType = safeParseInt2;
                aeVar.label = Util.nullAs(map.get(str + ".label"), "");
                aeVar.value = (float) Util.safeParseDouble(map.get(str + ".value"));
                aeVar.DZI = Util.nullAs(map.get(str + ".foregroundImage"), "");
                aeVar.fontSize = a(Util.safeParseDouble(map.get(str + ".fontSize")), i2, i3, i4);
                aeVar.lco = Util.nullAs(map.get(str + ".backgroundColor"), "");
                zVar = aeVar;
                break;
            case 132:
                zVar = b(map, str, i2, i3, i4);
                break;
            case 133:
                u uVar = new u();
                uVar.DWM = Util.nullAs(map.get(str + ".sphereThumbUrl"), "");
                uVar.DWw = Util.safeParseInt(map.get(str + ".displayType"));
                uVar.DWK = Util.safeParseInt(map.get(str + ".gestureDelayTime"));
                uVar.DWL = Util.nullAs(map.get(str + ".sphereImageUrl"), "");
                try {
                    uVar.DWN = Util.nullAs(map.get(str + ".bgColor"), "");
                    if (map.containsKey(str + ".bgColorAlpha") && uVar.DWN.length() > 0) {
                        uVar.DWN = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str + ".bgColorAlpha")) * 255.0d)), uVar.DWN.substring(1));
                    }
                } catch (Exception e4) {
                    Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + e4.toString());
                }
                try {
                    uVar.width = a(Util.safeParseDouble(map.get(str + ".imageWidth")), i2, i3, i4);
                    uVar.height = a(Util.safeParseDouble(map.get(str + ".imageHeight")), i2, i3, i4);
                } catch (Exception e5) {
                    uVar.width = 0.0f;
                    uVar.height = 0.0f;
                    Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse size exp=" + e5.toString());
                }
                uVar.DYO = Util.nullAs(map.get(".adxml.adSphereCardInfo.sphereImageUrl"), "");
                uVar.DYP = Util.nullAs(map.get(".adxml.adSphereCardInfo.sphereThumbUrl"), "");
                zVar = uVar;
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX:
                ad adVar = new ad();
                adVar.DZB = Util.nullAs(map.get(str + ".backgroundImg"), "");
                adVar.iconUrl = Util.nullAs(map.get(str + ".iconUrl"), "");
                adVar.title = Util.nullAs(map.get(str + ".title"), "");
                adVar.desc = Util.nullAs(map.get(str + ".desc"), "");
                adVar.DZG = Util.safeParseInt(map.get(str + ".onlyShowInTimelineAd"));
                adVar.DZD = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".isFullClickable").toString())) == 1;
                adVar.DZE = (int) a(Util.safeParseDouble(map.get(str + ".appearPaddingTop")), i2, i3, i4);
                adVar.DZF = (int) a(Util.safeParseDouble(map.get(str + ".appearPaddingBottom")), i2, i3, i4);
                try {
                    String str10 = str + ".backgroundColorAlpha";
                    adVar.lco = Util.nullAs(map.get(str + ".backgroundColor"), "");
                    if (map.containsKey(str10) && adVar.lco.length() > 0) {
                        adVar.lco = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str10)) * 255.0d)), adVar.lco.substring(1));
                    }
                } catch (Exception e6) {
                    Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse backgroundColor exp=" + e6.toString());
                }
                try {
                    String str11 = str + ".titleColorAlpha";
                    adVar.iyd = Util.nullAs(map.get(str + ".titleColor"), "");
                    if (map.containsKey(str11) && adVar.iyd.length() > 0) {
                        adVar.iyd = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str11)) * 255.0d)), adVar.iyd.substring(1));
                    }
                } catch (Exception e7) {
                    Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse titleColor exp=" + e7.toString());
                }
                try {
                    String str12 = str + ".descColorAlpha";
                    adVar.DZC = Util.nullAs(map.get(str + ".descColor"), "");
                    if (map.containsKey(str12) && adVar.DZC.length() > 0) {
                        adVar.DZC = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str12)) * 255.0d)), adVar.DZC.substring(1));
                    }
                } catch (Exception e8) {
                    Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + e8.toString());
                }
                adVar.DZH = a(map, str + ".componentItem", i2, i3, i4, i5);
                if (!(adVar.DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b)) {
                    zVar = adVar;
                    break;
                } else {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) adVar.DZH).DXO = true;
                    zVar = adVar;
                    break;
                }
            case com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX:
                p pVar = new p();
                pVar.DYo = Util.nullAs(map.get(str + ".swipeText"), "");
                pVar.DYp = Util.safeParseInt(map.get(str + ".swipeActionType"));
                pVar.jumpUrl = Util.nullAs(map.get(str + ".jumpUrl"), "");
                zVar = pVar;
                break;
            case r.CTRL_INDEX:
                zVar = L(map, str);
                break;
            case 138:
                zVar = i(map, str, i2, i3, i4, i5);
                break;
            case 140:
                af afVar = new af();
                afVar.DZJ = Util.nullAsNil(map.get(str + ".shareText"));
                afVar.DYt = Util.nullAsNil(map.get(str + ".fontColor"));
                zVar = afVar;
                break;
            default:
                AppMethodBeat.o(97333);
                return null;
        }
        if (zVar != null) {
            zVar.DZm = Zo(i5);
            zVar.type = safeParseInt;
            zVar.subType = safeParseInt2;
            a(zVar, map, str, i2, i3, i4);
        }
        AppMethodBeat.o(97333);
        return zVar;
    }

    private static ao b(Map<String, String> map, String str, int i2, int i3, int i4) {
        String str2;
        AppMethodBeat.i(97334);
        ao aoVar = new ao();
        try {
            String str3 = str + ".radarChart";
            aoVar.Eah = map.get(str3 + ".borderImg");
            aoVar.Ean = map.get(str3 + ".maskImg");
            aoVar.Eai = map.get(str3 + ".coverColor");
            aoVar.Eaj = Color.parseColor(map.get(str3 + ".labelFont.$color"));
            aoVar.Eak = (int) a(Util.safeParseDouble(map.get(str3 + ".labelFont.$size")), i2, i3, i4);
            aoVar.Eal = Color.parseColor(map.get(str3 + ".scoreFont.$color"));
            aoVar.Eam = (int) a(Util.safeParseDouble(map.get(str3 + ".scoreFont.$size")), i2, i3, i4);
            aoVar.borderWidth = a(Util.safeParseDouble(map.get(str3 + ".borderImgWidth")), i2, i3, i4);
            String str4 = str3 + ".itemList.item";
            int i5 = 0;
            while (true) {
                if (i5 != 0) {
                    str2 = str4 + i5;
                } else {
                    str2 = str4;
                }
                ao.a aVar = new ao.a();
                aVar.label = map.get(str2 + ".label");
                aVar.Eao = map.get(str2 + ".score");
                aVar.value = (float) Util.safeParseDouble(map.get(str2 + ".value"));
                if (TextUtils.isEmpty(aVar.label) && TextUtils.isEmpty(aVar.Eao)) {
                    break;
                }
                aoVar.jzm.add(aVar);
                i5++;
            }
        } catch (Exception e2) {
            Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(97334);
        return aoVar;
    }

    private static List<z> b(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        String str2;
        AppMethodBeat.i(97335);
        ArrayList arrayList = new ArrayList();
        String str3 = str + ".layoutItems.componentItem";
        int i6 = 0;
        while (true) {
            if (i6 == 0) {
                str2 = str3;
            } else {
                str2 = str3 + i6;
            }
            z a2 = a(map, i2, i3, i4, i5, str2);
            if (a2 != null) {
                if (a2.DZq) {
                    arrayList.add(a2);
                } else {
                    Log.i("AdLandingPagesParseHelper", "comp " + a2.toString() + " ifCondition is false");
                }
                i6++;
            } else {
                AppMethodBeat.o(97335);
                return arrayList;
            }
        }
    }

    private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r c(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        String str2;
        AppMethodBeat.i(97336);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r rVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r();
        try {
            rVar.backgroundColor = (((int) (Util.getDouble(map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (Color.parseColor(map.get(str + ".bgColorTheme")) & 16777215);
        } catch (Exception e2) {
            Log.e("AdLandingPagesParseHelper", "%s", Util.stackTraceToString(e2));
            rVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str3 = (str + ".componentGroupList") + ".componentItem";
        int i6 = 0;
        while (true) {
            if (i6 == 0) {
                str2 = str3;
            } else {
                str2 = str3 + i6;
            }
            z a2 = a(map, i2, i3, i4, i5, str2);
            if (a2 != null) {
                if (a2.DZq) {
                    rVar.DYI.add(a2);
                }
                i6++;
            } else {
                AppMethodBeat.o(97336);
                return rVar;
            }
        }
    }

    private static ak d(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        String str2;
        String str3;
        AppMethodBeat.i(97337);
        ak akVar = new ak();
        a(akVar, map, str, i2, i3, i4);
        akVar.Eac = Util.safeParseInt(map.get(str + ".pageCtrType"));
        akVar.onr = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        akVar.autoCarousel = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".autoCarousel").toString())) == 1;
        String str4 = str + ".componentGroupList.componentGroup";
        int i6 = 0;
        while (true) {
            if (i6 == 0) {
                str2 = str4;
            } else {
                str2 = str4 + i6;
            }
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r rVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r();
            String str5 = str2 + ".componentItem";
            int i7 = 0;
            while (true) {
                if (i7 == 0) {
                    str3 = str5;
                } else {
                    str3 = str5 + i7;
                }
                z a2 = a(map, i2, i3, i4, i5, str3);
                if (a2 == null) {
                    break;
                }
                if (a2.DZq) {
                    rVar.DYI.add(a2);
                }
                i7++;
            }
            if (rVar.DYI.size() != 0) {
                akVar.DYI.add(rVar);
                i6++;
            } else {
                AppMethodBeat.o(97337);
                return akVar;
            }
        }
    }

    private static void a(z zVar, Map<String, String> map, String str, int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(97338);
        zVar.DZj = Util.safeParseInt(map.get(str + ".type"));
        zVar.type = zVar.DZj;
        zVar.DZi = Util.nullAs(map.get(str + ".id"), "");
        zVar.paddingTop = a(Util.safeParseDouble(map.get(str + ".paddingTop")), i2, i3, i4);
        zVar.paddingBottom = a(Util.safeParseDouble(map.get(str + ".paddingBottom")), i2, i3, i4);
        zVar.paddingLeft = a(Util.safeParseDouble(map.get(str + ".paddingLeft")), i2, i3, i4);
        zVar.paddingRight = a(Util.safeParseDouble(map.get(str + ".paddingRight")), i2, i3, i4);
        zVar.subType = Util.safeParseInt(map.get(str + ".subType"));
        zVar.DZn = Util.nullAs(map.get(str + ".cellBackgroundColor"), "");
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            zVar.DZq = "1".equals(map.get(str2));
        } else {
            zVar.DZq = true;
        }
        String str3 = str + ".noReport";
        if (map.containsKey(str3)) {
            if ("1".equals(map.get(str3))) {
                z2 = true;
            } else {
                z2 = false;
            }
            zVar.DZr = z2;
        } else {
            zVar.DZr = false;
        }
        String nullAs = Util.nullAs(map.get(str + ".layoutWidth"), "");
        String nullAs2 = Util.nullAs(map.get(str + ".layoutHeight"), "");
        if (!TextUtils.isEmpty(nullAs)) {
            double safeParseDouble = Util.safeParseDouble(nullAs);
            if (safeParseDouble < 0.0d) {
                zVar.DZk = (float) safeParseDouble;
            } else {
                zVar.DZk = a(safeParseDouble, i2, i3, i4);
            }
        } else {
            zVar.DZk = 2.14748365E9f;
        }
        if (!TextUtils.isEmpty(nullAs2)) {
            double safeParseDouble2 = Util.safeParseDouble(nullAs2);
            if (safeParseDouble2 < 0.0d) {
                zVar.DZl = (float) safeParseDouble2;
            } else {
                zVar.DZl = a(safeParseDouble2, i2, i3, i4);
            }
        } else {
            zVar.DZl = 2.14748365E9f;
        }
        String str4 = map.get(str + ".verticalAlignment");
        String str5 = map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str4)) {
            zVar.DZo = -1;
        } else {
            zVar.DZo = Util.safeParseInt(str4);
        }
        if (TextUtils.isEmpty(str5)) {
            zVar.DZp = -1;
        } else {
            zVar.DZp = Util.safeParseInt(str5);
        }
        if (Util.safeParseInt(map.get(str + ".isTwistAnimView")) == 1) {
            z = true;
        } else {
            z = false;
        }
        zVar.DZs = z;
        if (Util.safeParseInt(map.get(str + ".isDefaultTwistCard")) != 1) {
            z3 = false;
        }
        zVar.DZt = z3;
        zVar.DZu = Util.nullAsNil(map.get(str + ".twistCardId"));
        zVar.DZv = Util.nullAsNil(map.get(str + ".jumpExtInfo"));
        AppMethodBeat.o(97338);
    }

    private static z e(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        String str2;
        AppMethodBeat.i(97339);
        aa aaVar = new aa();
        aaVar.DZx = Util.safeParseInt(map.get(str + ".subType"));
        aaVar.DZh = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap.a(map, str, i2, i3, i4);
        a(aaVar, map, str, i2, i3, i4);
        String str3 = str + ".layoutItems.componentItem";
        int i6 = 0;
        while (true) {
            if (i6 == 0) {
                str2 = str3;
            } else {
                str2 = str3 + i6;
            }
            z a2 = a(map, i2, i3, i4, i5, str2);
            if (a2 != null) {
                if (a2.DZq) {
                    aaVar.DZw.add(a2);
                }
                i6++;
            } else {
                AppMethodBeat.o(97339);
                return aaVar;
            }
        }
    }

    private static z f(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(97340);
        List<z> b2 = b(map, str, i2, i3, i4, i5);
        y yVar = new y();
        yVar.hH = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt(map.get(str + ".cornerRadius")));
        yVar.aQz = b2;
        yVar.DZh = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap.a(map, str, i2, i3, i4);
        a(yVar, map, str, i2, i3, i4);
        AppMethodBeat.o(97340);
        return yVar;
    }

    private static z g(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        String str2;
        AppMethodBeat.i(97341);
        List<z> b2 = b(map, str, i2, i3, i4, i5);
        x xVar = new x();
        xVar.hH = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), Util.safeParseInt(map.get(str + ".cornerRadius")));
        xVar.DZd = Util.safeParseInt(map.get(str + ".autoShow"));
        xVar.DZe = Util.safeParseInt(map.get(str + ".noAnimation"));
        xVar.DZf = Util.safeParseInt(map.get(str + ".forbiddenToClose"));
        xVar.DZg = Util.safeParseInt(map.get(str + ".noBackground"));
        xVar.aQz = b2;
        a(xVar, map, str, i2, i3, i4);
        String str3 = str + ".layoutItems.componentItem";
        int i6 = 0;
        while (true) {
            if (i6 == 0) {
                str2 = str3;
            } else {
                str2 = str3 + i6;
            }
            z a2 = a(map, i2, i3, i4, i5, str2);
            if (a2 != null) {
                if (a2.DZq) {
                    xVar.aQz.add(a2);
                }
                i6++;
            } else {
                AppMethodBeat.o(97341);
                return xVar;
            }
        }
    }

    private static z h(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(203160);
        List<z> b2 = b(map, str, i2, i3, i4, i5);
        com.tencent.mm.plugin.sns.ad.landingpage.component.b.b bVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.b();
        bVar.aQz = b2;
        bVar.DtQ = Util.nullAsNil(map.get(str + ".transitionImg"));
        try {
            bVar.DtR = com.tencent.mm.plugin.sns.data.k.jV(Util.nullAsNil(map.get(str + ".transitionColor")), Util.nullAsNil(map.get(str + ".transitionColorAlpha")));
        } catch (Exception e2) {
            Log.e("AdLandingPagesParseHelper", "sphereImageView adlandinginfo parse color exp=" + e2.toString());
        }
        a(bVar, map, str, i2, i3, i4);
        AppMethodBeat.o(203160);
        return bVar;
    }

    public static String kE(String str, String str2) {
        AppMethodBeat.i(97342);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(97342);
            return str;
        }
        String replaceAll = str.replaceAll("\\{\\{.*?\\}\\}", str2);
        AppMethodBeat.o(97342);
        return replaceAll;
    }

    public static class a {
        public LinkedList<g> Elq = new LinkedList<>();
        public ad Elr = null;
        public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e Els = null;
        public com.tencent.mm.plugin.sns.ad.landingpage.component.b.d Elt = null;

        public a(String str, String str2) {
            AppMethodBeat.i(97329);
            long currentTimeMillis = System.currentTimeMillis();
            kH(str, str2);
            Log.i("AdLandingPagesParseHelper", "parse adlanding xml, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(97329);
        }

        private void kH(String str, String str2) {
            String str3;
            String str4;
            String str5;
            z b2;
            String str6;
            String str7;
            AppMethodBeat.i(97330);
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(97330);
                return;
            }
            String kE = i.kE(str, "");
            Map<String, String> parseXml = XmlParser.parseXml(kE, str2, null);
            if (parseXml == null) {
                Log.w("AdLandingPagesParseHelper", " parse landingpages xml is error ,".concat(String.valueOf(kE)));
                AppMethodBeat.o(97330);
                return;
            }
            int safeParseInt = Util.safeParseInt(parseXml.get("." + str2 + ".adCanvasInfo.sizeType"));
            int safeParseInt2 = Util.safeParseInt(parseXml.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
            int safeParseInt3 = Util.safeParseInt(parseXml.get("." + str2 + ".adCanvasInfo.basicWidth"));
            if (safeParseInt2 == 0 && safeParseInt == 1) {
                safeParseInt2 = i.Elo;
            }
            if (safeParseInt3 == 0 && safeParseInt == 1) {
                safeParseInt3 = i.Eln;
            }
            if (Util.isNullOrNil(str2) || ".adCanvasInfo.PageList.Page".equals("adCanvasInfo")) {
                str3 = ".adCanvasInfo.PageList.Page";
            } else {
                str3 = "." + str2 + ".adCanvasInfo.PageList.Page";
            }
            int i2 = 0;
            while (true) {
                if (i2 == 0) {
                    str4 = str3;
                } else {
                    str4 = str3 + i2;
                }
                g gVar = new g();
                gVar.Elg = Util.nullAs(parseXml.get(str4 + ".backgroundCover"), "");
                gVar.lco = Util.nullAs(parseXml.get(str4 + ".backgroundColor"), "");
                gVar.Elh = Util.safeParseInt(parseXml.get(new StringBuilder().append(str4).append(".backgroundCover.$isAddBlur").toString())) > 0;
                gVar.id = i2;
                String str8 = str4 + ".if";
                if (parseXml.containsKey(str8)) {
                    gVar.Elk = "1".equals(parseXml.get(str8));
                } else {
                    gVar.Elk = true;
                }
                if (gVar.Elk) {
                    String str9 = str4 + ".componentItemList.componentItem";
                    int i3 = 0;
                    while (true) {
                        if (i3 == 0) {
                            str5 = str9;
                        } else {
                            str5 = str9 + i3;
                        }
                        try {
                            b2 = i.b(parseXml, safeParseInt, safeParseInt3, safeParseInt2, !TextUtils.isEmpty(gVar.lco) ? Color.parseColor(gVar.lco) : 0, str5);
                        } catch (Exception e2) {
                            Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(e2));
                            b2 = i.b(parseXml, safeParseInt, safeParseInt3, safeParseInt2, 0, str5);
                        }
                        if (b2 == null) {
                            break;
                        }
                        if (b2.DZq) {
                            i.b(b2, parseXml, str5, safeParseInt, safeParseInt3, safeParseInt2);
                            if (b2 instanceof x) {
                                gVar.Elj.put(b2.DZi, b2);
                            } else {
                                gVar.Eli.add(b2);
                            }
                        } else {
                            Log.i("AdLandingPagesParseHelper", "comp " + b2.toString() + " ifCondition is false");
                        }
                        i3++;
                    }
                    String str10 = str4 + ".forbiddenGlobalItems.id";
                    int i4 = 0;
                    while (true) {
                        if (i4 == 0) {
                            str6 = str10;
                        } else {
                            str6 = str10 + i4;
                        }
                        String nullAs = Util.nullAs(parseXml.get(str6), "");
                        if (TextUtils.isEmpty(nullAs)) {
                            break;
                        }
                        gVar.Ell.add(nullAs);
                        i4++;
                    }
                    if (gVar.Eli.size() == 0) {
                        break;
                    }
                    this.Elq.add(gVar);
                }
                i2++;
            }
            if (this.Elq != null && this.Elq.size() > 0) {
                this.Elq.get(0).xwi = true;
            }
            String str11 = "." + str2 + ".adCanvasInfo.globalComponentItems.componentItem";
            int i5 = 0;
            while (true) {
                if (i5 == 0) {
                    str7 = str11;
                } else {
                    str7 = str11 + i5;
                }
                z zVar = null;
                try {
                    zVar = i.b(parseXml, safeParseInt, safeParseInt3, safeParseInt2, 0, str7);
                } catch (Exception e3) {
                    Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(e3));
                }
                if (zVar == null) {
                    break;
                }
                Log.d("AdLandingPagesParseHelper", "parse the item: the global item existed, globalItemsStr = ".concat(String.valueOf(str7)));
                if (zVar instanceof ad) {
                    this.Elr = (ad) zVar;
                }
                if (zVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) {
                    this.Els = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e) zVar;
                }
                if (zVar instanceof com.tencent.mm.plugin.sns.ad.landingpage.component.b.d) {
                    this.Elt = (com.tencent.mm.plugin.sns.ad.landingpage.component.b.d) zVar;
                }
                i5++;
            }
            Log.d("AdLandingPagesParseHelper", "parse the item: the global item is null, globalItemsStr = ".concat(String.valueOf(str7)));
            if (this.Elr != null) {
                Iterator<g> it = this.Elq.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next.Ell.size() > 0) {
                        Iterator<String> it2 = next.Ell.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(this.Elr.DZi) && next2.equals(this.Elr.DZi)) {
                                next.Elm = true;
                                break;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(97330);
        }
    }

    private static z a(Map<String, String> map, int i2, int i3, int i4, int i5, String str) {
        AppMethodBeat.i(97343);
        int safeParseInt = Util.safeParseInt(map.get(str + ".type"));
        z zVar = null;
        if (!Zi(safeParseInt)) {
            try {
                zVar = a(map, str, i2, i3, i4, i5);
            } catch (Exception e2) {
                zVar = a(map, str, i2, i3, i4, 0);
            }
        } else if (Zj(safeParseInt)) {
            zVar = d(map, str, i2, i3, i4, i5);
        } else if (Zk(safeParseInt)) {
            zVar = e(map, str, i2, i3, i4, i5);
        } else if (Zl(safeParseInt)) {
            zVar = f(map, str, i2, i3, i4, i5);
        } else if (Zm(safeParseInt)) {
            zVar = g(map, str, i2, i3, i4, i5);
        } else if (Zn(safeParseInt)) {
            zVar = h(map, str, i2, i3, i4, i5);
        } else {
            Log.e("AdLandingPagesParseHelper", "the type" + safeParseInt + " is not client known type");
        }
        AppMethodBeat.o(97343);
        return zVar;
    }

    public static String kF(String str, String str2) {
        String str3;
        AppMethodBeat.i(97344);
        String str4 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Log.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && (next instanceof String)) {
                    String str5 = next;
                    String string = jSONObject.getString(str5);
                    if (!Util.isNullOrNil(string)) {
                        str3 = str4.replace("{{" + str5 + "}}", "<![CDATA[" + string + "]]>");
                        str4 = str3;
                    }
                }
                str3 = str4;
                str4 = str3;
            }
        } catch (Exception e2) {
            Log.e("AdLandingPagesParseHelper", "the json is parsed error : ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(97344);
        return str4;
    }

    private static boolean Zo(int i2) {
        int i3 = i2 | WebView.NIGHT_MODE_COLOR;
        return i3 - WebView.NIGHT_MODE_COLOR > -1 - i3;
    }

    private static boolean aQf(String str) {
        AppMethodBeat.i(97345);
        if (Util.safeParseInt(Util.nullAs(XmlParser.parseXml(str, "adCanvasInfo", null).get(".adCanvasInfo.bizId"), "")) == 1) {
            AppMethodBeat.o(97345);
            return true;
        }
        AppMethodBeat.o(97345);
        return false;
    }

    private static boolean a(String str, Context context, boolean z, int i2) {
        AppMethodBeat.i(97346);
        String str2 = XmlParser.parseXml(str, "adCanvasInfo", null).get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(97346);
            return false;
        }
        if (z) {
            try {
                str2 = n(str2, "exp=" + com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i2);
            } catch (URISyntaxException e2) {
            }
            Log.i("AdLandingPagesParseHelper", "canvas jump url ".concat(String.valueOf(str2)));
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(97346);
        return true;
    }

    public static String n(String str, String... strArr) {
        AppMethodBeat.i(97347);
        URI uri = new URI(str);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2).append("&");
        }
        if (sb.length() > 1) {
            StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
            String query = uri.getQuery();
            String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), query == null ? deleteCharAt.toString() : query + "&" + deleteCharAt.toString(), uri.getFragment()).toString();
            AppMethodBeat.o(97347);
            return uri2;
        }
        AppMethodBeat.o(97347);
        return str;
    }

    public static String o(String str, String... strArr) {
        AppMethodBeat.i(97348);
        if (str == null) {
            str = "";
        }
        String join = TextUtils.join("&", strArr);
        String str2 = "?";
        if (str.contains("?")) {
            str2 = "&";
        }
        if (str.contains("#")) {
            try {
                int indexOf = str.indexOf("#");
                String str3 = str.substring(0, indexOf) + str2 + join + str.substring(indexOf + 1);
                AppMethodBeat.o(97348);
                return str3;
            } catch (Exception e2) {
                Log.e("AdLandingPagesParseHelper", "append url params failed, %s", e2.toString());
                AppMethodBeat.o(97348);
                return str;
            }
        } else {
            String str4 = str + str2 + join;
            AppMethodBeat.o(97348);
            return str4;
        }
    }

    private static boolean fex() {
        AppMethodBeat.i(97349);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100150");
        if (Fu.isValid()) {
            int i2 = Util.getInt(Fu.gzz().get("openCanvas"), 0);
            Log.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=".concat(String.valueOf(i2)));
            if (i2 == 1) {
                AppMethodBeat.o(97349);
                return true;
            }
            AppMethodBeat.o(97349);
            return false;
        }
        AppMethodBeat.o(97349);
        return false;
    }

    public static boolean y(Intent intent, Context context) {
        boolean z;
        AppMethodBeat.i(97350);
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !kG(stringExtra, "adCanvasInfo")) {
                Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", stringExtra);
            } else {
                String str = "";
                boolean aQf = aQf(stringExtra);
                if (aQf) {
                    str = com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (!TextUtils.isEmpty(str)) {
                        int gO = com.tencent.mm.model.c.d.aXv().gO("Sns_Canvas_GameShare_JumpWay", 0);
                        Log.i("AdLandingPagesParseHelper", "abtestvalue = ".concat(String.valueOf(gO)));
                        if (gO == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } else {
                        z = fex();
                    }
                } else {
                    z = true;
                }
                if (z) {
                    Intent intent2 = new Intent(intent);
                    intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                    intent2.putExtra("sns_landing_pages_expid", str);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    if ((context instanceof Activity) && ADXml.k.aPT(stringExtra)) {
                        ((Activity) context).overridePendingTransition(0, 0);
                    }
                    AppMethodBeat.o(97350);
                    return true;
                }
                boolean a2 = a(stringExtra, context, aQf, intent.getIntExtra("sns_landig_pages_from_source", -1));
                AppMethodBeat.o(97350);
                return a2;
            }
        }
        AppMethodBeat.o(97350);
        return false;
    }

    public static boolean a(TimeLineObject timeLineObject, Activity activity) {
        boolean z;
        AppMethodBeat.i(97351);
        String str = timeLineObject.canvasInfo;
        long longValue = new BigInteger(timeLineObject.Id).longValue();
        LinkedList<cnb> linkedList = timeLineObject.ContentObj.LoV;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !aQg(str)) {
                Log.i("AdLandingPagesParseHelper", "invalid canvas xml %s", str);
            } else {
                String str2 = "";
                boolean aQf = aQf(str);
                if (aQf) {
                    str2 = com.tencent.mm.model.c.d.aXv().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (com.tencent.mm.model.c.d.aXv().gO("Sns_Canvas_GameShare_JumpWay", 0) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z && fex()) {
                        z = true;
                    }
                } else {
                    z = true;
                }
                if (z) {
                    SnsInfo JJ = aj.faO().JJ(longValue);
                    Intent intent = new Intent();
                    if (JJ != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", JJ.getSnsId());
                        intent.putExtra("sns_landing_pages_rawSnsId", JJ.getTimeLine().Id);
                        intent.putExtra("sns_landing_pages_ux_info", JJ.getUxinfo());
                        intent.putExtra("sns_landing_pages_aid", JJ.getAid());
                        intent.putExtra("sns_landing_pages_traceid", JJ.getTraceid());
                        intent.putExtra("sns_landing_pages_rec_src", JJ.getAdRecSrc());
                    }
                    if (linkedList != null && linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                    }
                    intent.putExtra("sns_landing_pages_expid", str2);
                    intent.putExtra("sns_landig_pages_from_source", 11);
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landing_pages_xml", str);
                    intent.putExtra("sns_landing_pages_xml_prefix", com.tencent.mm.g.c.f.COL_ADXML);
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPagesParseHelper", "openCanvas", "(Ljava/lang/String;JLjava/util/List;Landroid/app/Activity;IZ)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(97351);
                    return true;
                }
                a(str, activity, aQf, 11);
            }
        }
        AppMethodBeat.o(97351);
        return false;
    }

    public static boolean aQg(String str) {
        AppMethodBeat.i(259446);
        boolean kG = kG(str, "adCanvasInfo");
        AppMethodBeat.o(259446);
        return kG;
    }

    public static boolean kG(String str, String str2) {
        AppMethodBeat.i(97353);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(97353);
            return false;
        }
        if (Elp == null) {
            fey();
        }
        if (Elp == null || Elp.isEmpty()) {
            AppMethodBeat.o(97353);
            return false;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, str2, null);
        if (parseXml == null || parseXml.isEmpty()) {
            Log.w("AdLandingPagesParseHelper", "invalid landingpages xml,".concat(String.valueOf(str)));
            AppMethodBeat.o(97353);
            return false;
        }
        b bVar = new b((byte) 0);
        bVar.Elu = 0;
        bVar.Elv = Util.safeParseInt(parseXml.get(".adCanvasInfo.type"));
        bVar.Elw = Util.safeParseInt(parseXml.get(".adCanvasInfo.subtype"));
        if (!Elp.contains(bVar)) {
            Log.i("AdLandingPagesParseHelper", "invalid canvas type ".concat(String.valueOf(bVar)));
            AppMethodBeat.o(97353);
            return false;
        }
        int i2 = 0;
        while (true) {
            bVar.Elu = 1;
            String str3 = i2 == 0 ? ".adCanvasInfo.PageList.Page" : ".adCanvasInfo.PageList.Page" + i2;
            if (parseXml.containsKey(str3 + ".componentItemList.componentItem.type")) {
                bVar.Elv = Util.safeParseInt(parseXml.get(str3 + ".type"));
                bVar.Elw = Util.safeParseInt(parseXml.get(str3 + ".subType"));
                if (Elp.contains(bVar)) {
                    String str4 = str3 + ".componentItemList.componentItem";
                    bVar.Elu = 2;
                    int i3 = 0;
                    while (true) {
                        String str5 = i3 == 0 ? str4 : str4 + i3;
                        if (!parseXml.containsKey(str5 + ".type")) {
                            break;
                        }
                        bVar.Elv = Util.safeParseInt(parseXml.get(str5 + ".type"));
                        bVar.Elw = Util.safeParseInt(parseXml.get(str5 + ".subType"));
                        if (!Elp.contains(bVar)) {
                            Log.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(bVar)));
                            AppMethodBeat.o(97353);
                            return false;
                        }
                        i3++;
                    }
                } else {
                    Log.i("AdLandingPagesParseHelper", "invalid page type ".concat(String.valueOf(bVar)));
                    AppMethodBeat.o(97353);
                    return false;
                }
            } else {
                bVar.Elu = 2;
                for (Map.Entry<String, String> entry : parseXml.entrySet()) {
                    if (entry.getKey() != null && entry.getKey().matches("[\\s\\S]*\\.componentItem[0-9]*\\.type$")) {
                        String replace = entry.getKey().replace(".type", ".subType");
                        bVar.Elv = Util.safeParseInt(parseXml.get(entry.getKey()));
                        bVar.Elw = Util.safeParseInt(parseXml.get(replace));
                        if (!Elp.contains(bVar)) {
                            Log.i("AdLandingPagesParseHelper", "invalid component type ".concat(String.valueOf(bVar)));
                            AppMethodBeat.o(97353);
                            return false;
                        }
                    }
                }
                AppMethodBeat.o(97353);
                return true;
            }
            i2++;
        }
    }

    private static void fey() {
        int i2;
        boolean z;
        AppMethodBeat.i(97354);
        if (Elp != null) {
            AppMethodBeat.o(97354);
            return;
        }
        Elp = new HashSet();
        InputStream inputStream = null;
        try {
            InputStream open = MMApplicationContext.getContext().getAssets().open("sns/canvas_valid_type.xml");
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(open, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            int i3 = -1;
            int i4 = -1;
            int eventType = newPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    if ("canvastype".equals(name)) {
                        i4 = 0;
                        z = false;
                    } else if ("pagetype".equals(name)) {
                        i4 = 1;
                        z = true;
                    } else if ("componenttype".equals(name)) {
                        i4 = 2;
                        z = true;
                    } else {
                        z = "subtype".equals(name) ? true : true;
                    }
                    if (!z) {
                        if (Util.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1) {
                            i2 = Util.getInt(newPullParser.getAttributeValue(null, "val"), -1);
                        } else {
                            i2 = -1;
                        }
                        switch (z) {
                            case false:
                            case true:
                            case true:
                                eventType = newPullParser.next();
                                i3 = i2;
                            case true:
                                if (!(i4 == -1 || i3 == -1 || i2 == -1)) {
                                    b bVar = new b((byte) 0);
                                    bVar.Elu = i4;
                                    bVar.Elv = i3;
                                    bVar.Elw = i2;
                                    Elp.add(bVar);
                                    Log.i("AdLandingPagesParseHelper", "valid canvas type ".concat(String.valueOf(bVar)));
                                    break;
                                }
                        }
                    }
                }
                i2 = i3;
                eventType = newPullParser.next();
                i3 = i2;
            }
            if (open != null) {
                try {
                    open.close();
                    AppMethodBeat.o(97354);
                    return;
                } catch (IOException e2) {
                    AppMethodBeat.o(97354);
                    return;
                }
            }
        } catch (IOException e3) {
            Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(e3));
            if (0 != 0) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(97354);
                    return;
                } catch (IOException e4) {
                    AppMethodBeat.o(97354);
                    return;
                }
            }
        } catch (XmlPullParserException e5) {
            Log.e("AdLandingPagesParseHelper", Util.stackTraceToString(e5));
            if (0 != 0) {
                try {
                    inputStream.close();
                    AppMethodBeat.o(97354);
                    return;
                } catch (IOException e6) {
                    AppMethodBeat.o(97354);
                    return;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                }
            }
            AppMethodBeat.o(97354);
            throw th;
        }
        AppMethodBeat.o(97354);
    }

    public static String Q(SnsInfo snsInfo) {
        AppMethodBeat.i(97355);
        if (snsInfo == null) {
            Log.e("AdLandingPagesParseHelper", "the snsinfo is null");
            AppMethodBeat.o(97355);
            return null;
        } else if (!snsInfo.isAd()) {
            Log.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            AppMethodBeat.o(97355);
            return null;
        } else {
            AdSnsInfo adSnsInfo = snsInfo.getAdSnsInfo();
            if (adSnsInfo == null) {
                Log.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                AppMethodBeat.o(97355);
                return null;
            }
            ADXml adXml = snsInfo.getAdXml();
            if (adXml == null) {
                Log.e("AdLandingPagesParseHelper", "the adxml is null");
                AppMethodBeat.o(97355);
                return null;
            }
            ADInfo adInfo = snsInfo.getAdInfo();
            if (adInfo == null) {
                Log.e("AdLandingPagesParseHelper", "the adInfo is null");
                AppMethodBeat.o(97355);
                return null;
            } else if (!adXml.isLandingPagesAd()) {
                Log.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                AppMethodBeat.o(97355);
                return null;
            } else if (adInfo.mappedCanvasCardExt == null || adInfo.mappedCanvasCardExt.size() == 0) {
                Log.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                AppMethodBeat.o(97355);
                return null;
            } else {
                String K = K(adSnsInfo.field_adxml, adInfo.mappedCanvasCardExt);
                AppMethodBeat.o(97355);
                return K;
            }
        }
    }

    private static String K(String str, Map<String, String> map) {
        String str2;
        AppMethodBeat.i(97356);
        if (str == null || str.length() == 0) {
            Log.e("AdLandingPagesParseHelper", "the adLandingPagesXml is empty");
            AppMethodBeat.o(97356);
            return null;
        } else if (map == null || map.size() == 0) {
            Log.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
            AppMethodBeat.o(97356);
            return null;
        } else {
            LinkedList<g> linkedList = new a(str, com.tencent.mm.g.c.f.COL_ADXML).Elq;
            for (String str3 : map.keySet()) {
                if (!Util.isNullOrNil(str3)) {
                    String str4 = map.get(str3);
                    if (!Util.isNullOrNil(str4)) {
                        Iterator<g> it = linkedList.iterator();
                        String str5 = null;
                        while (true) {
                            if (!it.hasNext()) {
                                str2 = str5;
                                break;
                            }
                            Iterator<z> it2 = it.next().Eli.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    str2 = str5;
                                    break;
                                }
                                z next = it2.next();
                                if ((next instanceof f) && !Util.isNullOrNil(((f) next).cardTpId) && ((f) next).cardTpId.equals(str3)) {
                                    str2 = ((f) next).cardExt;
                                    break;
                                }
                            }
                            if (str2 != null) {
                                break;
                            }
                            str5 = str2;
                        }
                        if (!Util.isNullOrNil(str2)) {
                            Log.i("AdLandingPagesParseHelper", "old card ext is " + str2 + " and new card ext is " + str4);
                            str = str.replace(str2, str4);
                            try {
                                str = str.replace(Util.escapeStringForXml(str2), Util.escapeStringForXml(str4));
                            } catch (Exception e2) {
                                Log.e("AdLandingPagesParseHelper", "the xml is error");
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(97356);
            return str;
        }
    }

    public static void gU(List<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m> list) {
        AppMethodBeat.i(97357);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(97357);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m mVar : list) {
            if (Zi(mVar.fdk().type)) {
                arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) mVar).eWU());
            }
        }
        if (!arrayList.isEmpty()) {
            gU(arrayList);
            list.addAll(arrayList);
        }
        AppMethodBeat.o(97357);
    }

    private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e L(Map<String, String> map, String str) {
        AppMethodBeat.i(203162);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
        eVar.DXV = Util.nullAs(map.get(str + ".webViewUrl"), "");
        eVar.DXX = Util.safeParseInt(map.get(str + ".webViewHeight"));
        eVar.DXW = Util.safeParseInt(map.get(str + ".webViewWidth"));
        eVar.DXY = Util.safeParseInt(map.get(str + ".hideWebViewProgress"));
        AppMethodBeat.o(203162);
        return eVar;
    }

    private static com.tencent.mm.plugin.sns.ad.landingpage.component.b.d i(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(203163);
        com.tencent.mm.plugin.sns.ad.landingpage.component.b.d dVar = new com.tencent.mm.plugin.sns.ad.landingpage.component.b.d();
        dVar.DtS = Util.nullAs(map.get(str + ".title"), "");
        dVar.DtT = Util.safeParseInt(map.get(str + ".autoJump"));
        dVar.DtU = Util.safeParseInt(map.get(str + ".swipeJumpOffset"));
        z a2 = a(map, str + ".componentItem", i2, i3, i4, i5);
        if (a2 instanceof q) {
            dVar.DtV = (q) a2;
        }
        AppMethodBeat.o(203163);
        return dVar;
    }

    private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj j(Map<String, String> map, String str, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(203164);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj ajVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj();
        a(ajVar, map, str, i2, i3, i4);
        ajVar.desc = Util.nullAs(map.get(str + ".desc"), "");
        ajVar.DZD = Util.safeParseInt(map.get(new StringBuilder().append(str).append(".isFullClickable").toString())) == 1;
        try {
            String str2 = str + ".descColorAlpha";
            ajVar.DZC = Util.nullAs(map.get(str + ".descColor"), "");
            if (map.containsKey(str2) && ajVar.DZC.length() > 0) {
                ajVar.DZC = String.format("#%02x%s", Integer.valueOf((int) (Util.safeParseDouble(map.get(str2)) * 255.0d)), ajVar.DZC.substring(1));
            }
        } catch (Exception e2) {
            Log.e("AdLandingPagesParseHelper", "AdLandingPageComponetFloatBarInfo parse descColor exp=" + e2.toString());
        }
        ajVar.DZH = a(map, str + ".componentItem", i2, i3, i4, i5);
        if (ajVar.DZH instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) ajVar.DZH).DXO = true;
        }
        AppMethodBeat.o(203164);
        return ajVar;
    }
}
