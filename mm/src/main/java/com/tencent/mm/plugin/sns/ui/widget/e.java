package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.ad.g.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.f.a;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.j;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.c;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.s;

public final class e {
    public static CharSequence a(Context context, dzo dzo, j jVar, int i2, String str, int i3, boolean z, boolean z2, SnsInfo snsInfo) {
        AppMethodBeat.i(100534);
        CharSequence b2 = b(context, dzo, jVar, i2, str, i3, z, z2, snsInfo);
        AppMethodBeat.o(100534);
        return b2;
    }

    private static CharSequence b(Context context, dzo dzo, j jVar, int i2, String str, int i3, boolean z, boolean z2, SnsInfo snsInfo) {
        String str2;
        int i4;
        as asVar;
        boolean z3;
        boolean z4;
        boolean z5;
        String str3;
        boolean z6;
        boolean z7;
        String str4;
        ImageSpan textStatusSpanSync;
        ImageSpan textStatusSpanSync2;
        AppMethodBeat.i(100535);
        String str5 = "";
        String b2 = b(dzo);
        if (b(snsInfo, dzo.Username)) {
            str2 = c(snsInfo.getAdXml(), b2);
        } else {
            str2 = b2;
        }
        String str6 = "";
        String str7 = null;
        String str8 = null;
        int i5 = 0;
        int i6 = 0;
        boolean z8 = false;
        as bjK = aj.faC().bjK(dzo.MZm);
        boolean z9 = z && a.aOE(dzo.Username);
        if (i2 == 21) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        String nullAsNil = Util.nullAsNil(dzo.iAc);
        if (!Util.isNullOrNil(str)) {
            g.aAi();
            asVar = ((l) g.af(l.class)).aSN().bjJ(str);
        } else {
            asVar = null;
        }
        if (i3 != 1) {
            z3 = false;
            z4 = false;
        } else if (a.aOD(dzo.Username) && z2 && o.isShowStoryCheck()) {
            z3 = false;
            z4 = true;
            str6 = str2 + "  ";
        } else if (!p.fvK() || !((c) g.ah(c.class)).hasStatus(dzo.Username)) {
            z3 = false;
            z4 = false;
            str6 = str2;
        } else {
            z3 = true;
            z4 = false;
            str6 = str2 + " ";
        }
        if (!iY(dzo.MYX, 1) || !TextUtils.isEmpty(dzo.MZm)) {
            if (iY(dzo.MYX, 8)) {
                String displayName = ((b) g.af(b.class)).getDisplayName(dzo.MZm);
                if (!Util.isNullOrNil(str6)) {
                    str6 = str6 + ": ";
                }
                String str9 = str6 + context.getString(R.string.h53);
                z5 = false;
                i5 = str9.length();
                str8 = displayName;
                str5 = str5 + (str9 + displayName) + " ";
            } else if (!Util.isNullOrNil(dzo.MZm)) {
                String arJ = bjK == null ? dzo.MZm : bjK.arJ();
                if (snsInfo == null || !snsInfo.isAd() || !dzo.MZm.equals(snsInfo.getUserName())) {
                    str3 = arJ;
                } else {
                    str3 = c(snsInfo.getAdXml(), arJ);
                }
                String str10 = str6 + context.getString(R.string.h9y);
                i5 = str10.length();
                if (a.aOD(dzo.MZm) && z2 && o.isShowStoryCheck()) {
                    str4 = str3 + "  ";
                    z6 = false;
                    z7 = true;
                } else if (!p.fvK() || !((c) g.ah(c.class)).hasStatus(dzo.MZm)) {
                    z6 = false;
                    z7 = false;
                    str4 = str3;
                } else {
                    z6 = true;
                    z7 = false;
                    str4 = str3 + " ";
                }
                String str11 = str10 + str4;
                z5 = z6;
                z8 = z7;
                str8 = str4;
                str5 = str5 + str11 + ": ";
            } else {
                if (!Util.isNullOrNil(str6)) {
                    str6 = str6 + ": ";
                }
                z5 = false;
                str5 = str5 + str6;
            }
        } else if (asVar != null) {
            String arJ2 = (asVar == null || TextUtils.isEmpty(asVar.arJ())) ? str : asVar.arJ();
            if (snsInfo != null && snsInfo.isAd()) {
                arJ2 = c(snsInfo.getAdXml(), arJ2);
            }
            String str12 = str6 + context.getString(R.string.h53);
            z5 = false;
            i6 = str12.length();
            str7 = arJ2;
            str5 = str5 + (str12 + arJ2) + ": ";
        } else {
            Log.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", str);
            z5 = false;
        }
        String str13 = str5 + nullAsNil;
        Bundle grY = t.grY();
        grY.putInt("ShareScene", r.a(dzo) ? 5 : 4);
        grY.putString("ShareSceneId", snsInfo.getUserName() + "#" + r.Jb(snsInfo.field_snsId) + "#" + dzo.Username + "#" + dzo.MYT);
        grY.putLong("CreateTime", (long) dzo.CreateTime);
        grY.putInt("TimelineEnterSource", i3 == 2 ? 3 : 1);
        grY.putInt("SnsContentType", snsInfo.field_type);
        a.C1715a aVar = com.tencent.mm.plugin.sns.i.a.DRI;
        a.C1715a.a(context, dzo, snsInfo, i3);
        SpannableString a2 = com.tencent.mm.pluginsdk.ui.span.l.a(context, str13, com.tencent.mm.cb.a.fromDPToPix(context, (int) (15.0f * com.tencent.mm.cb.a.ez(context))), 2, z9, grY);
        int i7 = i2 == 21 ? 3 : 2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2);
        if (i3 == 1) {
            if (b(snsInfo, dzo.Username)) {
                spannableStringBuilder.setSpan(new q(new com.tencent.mm.plugin.sns.data.b(snsInfo.isAd(), dzo.Username, snsInfo.getLocalid(), 0, iY(dzo.MYX, 32) ? 27 : 2), jVar, i7), 0, str2.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new q(dzo.Username, jVar, i7), 0, str2.length(), 33);
            }
            if (z4) {
                spannableStringBuilder.setSpan(new h(((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true)), str2.length() + 1, str2.length() + 2, 17);
            } else if (z3 && (textStatusSpanSync2 = ((c) g.ah(c.class)).getTextStatusSpanSync(dzo.Username, a.b.SNS_COMMENT, (float) com.tencent.mm.cb.a.fromDPToPix(context, (int) (15.0f * com.tencent.mm.cb.a.ez(context))))) != null) {
                spannableStringBuilder.setSpan(textStatusSpanSync2, str2.length(), str2.length() + 1, 17);
            }
        }
        if (!Util.isNullOrNil(str7)) {
            if (snsInfo == null || !snsInfo.isAd() || !str.equals(snsInfo.getUserName())) {
                spannableStringBuilder.setSpan(new q(str, jVar, i4), i6, str7.length() + i6, 33);
            } else {
                spannableStringBuilder.setSpan(new q(new com.tencent.mm.plugin.sns.data.b(snsInfo.isAd(), str, snsInfo.getLocalid(), 0, 2), jVar, i4), i6, str7.length() + i6, 33);
            }
        } else if (!Util.isNullOrNil(str8)) {
            if (snsInfo == null || !snsInfo.isAd() || !dzo.MZm.equals(snsInfo.getUserName())) {
                spannableStringBuilder.setSpan(new q(dzo.MZm, jVar, i4), i5, str8.length() + i5, 33);
            } else {
                spannableStringBuilder.setSpan(new q(new com.tencent.mm.plugin.sns.data.b(snsInfo.isAd(), dzo.MZm, snsInfo.getLocalid(), 0, 2), jVar, i4), i5, str8.length() + i5, 33);
            }
            if (z8) {
                spannableStringBuilder.setSpan(new h(((com.tencent.mm.plugin.story.api.e) g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryUIFactory().vJ(true)), (str8.length() + i5) - 1, str8.length() + i5, 17);
            } else if (z5 && (textStatusSpanSync = ((c) g.ah(c.class)).getTextStatusSpanSync(dzo.MZm, a.b.SNS_COMMENT, (float) com.tencent.mm.cb.a.fromDPToPix(context, (int) (15.0f * com.tencent.mm.cb.a.ez(context))))) != null) {
                spannableStringBuilder.setSpan(textStatusSpanSync, (str8.length() + i5) - 1, str8.length() + i5, 17);
            }
        }
        AppMethodBeat.o(100535);
        return spannableStringBuilder;
    }

    public static String b(dzo dzo) {
        AppMethodBeat.i(100536);
        as bjK = aj.faC().bjK(dzo.Username);
        if (bjK != null) {
            String arJ = bjK.arJ();
            AppMethodBeat.o(100536);
            return arJ;
        } else if (dzo.Nickname != null) {
            String str = dzo.Nickname;
            AppMethodBeat.o(100536);
            return str;
        } else {
            String str2 = dzo.Username;
            AppMethodBeat.o(100536);
            return str2;
        }
    }

    public static boolean iY(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static String c(ADXml aDXml, String str) {
        AppMethodBeat.i(100537);
        if (aDXml != null) {
            if (aDXml.usePreferedInfo) {
                str = aDXml.preferNickName;
            } else if (Util.isNullOrNil(str) && !Util.isNullOrNil(aDXml.nickname)) {
                str = aDXml.nickname;
            }
        }
        AppMethodBeat.o(100537);
        return str;
    }

    public static boolean b(SnsInfo snsInfo, String str) {
        AppMethodBeat.i(100538);
        if (snsInfo == null || !snsInfo.isAd() || str == null || !str.equals(snsInfo.getUserName())) {
            AppMethodBeat.o(100538);
            return false;
        }
        AppMethodBeat.o(100538);
        return true;
    }

    public static boolean a(final ImageView imageView, SnsInfo snsInfo, String str) {
        boolean z;
        ADXml adXml;
        AppMethodBeat.i(100539);
        if (snsInfo == null || !b(snsInfo, str) || (adXml = snsInfo.getAdXml()) == null || !adXml.usePreferedInfo || TextUtils.isEmpty(adXml.preferAvatar)) {
            z = false;
        } else {
            final String str2 = adXml.preferAvatar;
            imageView.setTag(R.id.hzx, str2);
            z = true;
            Log.i("SnsCommentUtil", "trySetAdBossCommentAvater, isSet=true");
            String kz = h.kz("adId", str2);
            if (s.YS(kz)) {
                try {
                    Bitmap bitmap = n.Dwr.getBitmap(kz);
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater use local cache, url=".concat(String.valueOf(str2)));
                    }
                } catch (Throwable th) {
                    Log.e("SnsCommentUtil", "trySetAdBossCommentAvater decode exp=" + th.toString());
                }
            } else {
                h.a(str2, false, (f.a) new f.a() {
                    /* class com.tencent.mm.plugin.sns.ui.widget.e.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                        AppMethodBeat.i(100532);
                        Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadError, url=" + str2);
                        AppMethodBeat.o(100532);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        Bitmap bitmap;
                        AppMethodBeat.i(100533);
                        try {
                            Log.i("SnsCommentUtil", "trySetAdBossCommentAvater onDownloadedSucc, url=" + str2);
                            String str2 = (String) imageView.getTag(R.id.hzx);
                            String kz = TextUtils.isEmpty(str2) ? "" : h.kz("adId", str2);
                            if (!TextUtils.isEmpty(str) && str.equals(kz) && (bitmap = n.Dwr.getBitmap(str)) != null) {
                                imageView.setImageBitmap(bitmap);
                                Log.i("SnsCommentUtil", "trySetAdBossCommentAvater setImageBitmap");
                            }
                            AppMethodBeat.o(100533);
                        } catch (Throwable th) {
                            Log.e("SnsCommentUtil", "trySetAdBossCommentAvater, download decode, exp=" + th.toString());
                            AppMethodBeat.o(100533);
                        }
                    }
                });
            }
        }
        AppMethodBeat.o(100539);
        return z;
    }

    public static CharSequence b(SpannableStringBuilder spannableStringBuilder) {
        com.tencent.mm.pluginsdk.ui.span.p[] pVarArr;
        String str;
        AppMethodBeat.i(204001);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        if (!Util.isNullOrNil(spannableStringBuilder) && (pVarArr = (com.tencent.mm.pluginsdk.ui.span.p[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.tencent.mm.pluginsdk.ui.span.p.class)) != null && pVarArr.length > 0) {
            for (com.tencent.mm.pluginsdk.ui.span.p pVar : pVarArr) {
                if (pVar.getType() == 1 && (str = pVar.getHrefInfo().url) != null && str.length() > ah.DKc && spannableStringBuilder2.toString().contains(str)) {
                    String str2 = str.substring(0, ah.DKc) + "...";
                    SpannableString spannableString = new SpannableString(str2);
                    spannableString.setSpan(new com.tencent.mm.pluginsdk.ui.span.p(2, pVar.getHrefInfo()), 0, str2.length(), 33);
                    int indexOf = spannableStringBuilder2.toString().indexOf(str);
                    spannableStringBuilder2.replace(indexOf, str.length() + indexOf, (CharSequence) spannableString);
                }
            }
        }
        AppMethodBeat.o(204001);
        return spannableStringBuilder2;
    }

    public static boolean c(dzo dzo) {
        return dzo != null && dzo.DeleteFlag > 0;
    }
}
