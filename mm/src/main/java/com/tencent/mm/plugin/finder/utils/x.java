package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.i.a.ae;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderUIUtil;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUIApi;", "()V", "TAG", "", "initWxProfileSettingPref", "", "context", "Landroid/content/Context;", "preferenceScreen", "", "profileSettingTag", "fromFinderSetting", "loadFeedToImageView", "", "feed", "imageView", "Landroid/widget/ImageView;", "plugin-finder_release"})
public final class x implements ae {
    private static final String TAG = TAG;
    public static final x vXq = new x();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class a extends q implements kotlin.g.a.b<String, kotlin.x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean vXr = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(1);
            this.$context = context;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(String str) {
            AppMethodBeat.i(253555);
            p.h(str, LocaleUtil.ITALIAN);
            Intent intent = new Intent();
            String aTY = z.aTY();
            intent.putExtra("Contact_User", aTY);
            if (aTY != null && aTY.length() > 0) {
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 22);
                c.b(this.$context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            if (this.vXr) {
                k kVar = k.vfA;
                k.b(this.$context, 12, 5);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(253555);
            return xVar;
        }
    }

    static {
        AppMethodBeat.i(253559);
        AppMethodBeat.o(253559);
    }

    private x() {
    }

    public static boolean a(Context context, Object obj, String str) {
        AppMethodBeat.i(253557);
        p.h(context, "context");
        p.h(obj, "preferenceScreen");
        p.h(str, "profileSettingTag");
        if (!(obj instanceof f)) {
            AppMethodBeat.o(253557);
            return false;
        }
        v vVar = v.vXn;
        if (v.dCt()) {
            Log.i(TAG, "initWxProfileSettingPref");
            ((f) obj).m38do(str, false);
            Preference bmg = ((f) obj).bmg(str);
            if (!(bmg instanceof CheckBoxPreference)) {
                bmg = null;
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) bmg;
            if (checkBoxPreference != null) {
                checkBoxPreference.gLR();
                y yVar = y.vXH;
                checkBoxPreference.setChecked(y.dCG());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) context.getString(R.string.d9y));
                SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context, context.getString(R.string.d9z));
                String spannableString = c2.toString();
                p.g(spannableString, "forwardStr.toString()");
                c2.setSpan(new com.tencent.mm.plugin.finder.view.l(spannableString, context.getResources().getColor(R.color.Link), context.getResources().getColor(R.color.Link_Alpha_0_6), new a(context)), 0, c2.length(), 17);
                spannableStringBuilder.append((CharSequence) c2);
                checkBoxPreference.setSummary(spannableStringBuilder);
                checkBoxPreference.a(new b(checkBoxPreference, spannableStringBuilder));
                AppMethodBeat.o(253557);
                return true;
            }
        } else {
            ((f) obj).m38do(str, true);
        }
        AppMethodBeat.o(253557);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "afterOnBind"})
    static final class b implements CheckBoxPreference.a {
        final /* synthetic */ CheckBoxPreference vXs;
        final /* synthetic */ SpannableStringBuilder vXt;

        b(CheckBoxPreference checkBoxPreference, SpannableStringBuilder spannableStringBuilder) {
            this.vXs = checkBoxPreference;
            this.vXt = spannableStringBuilder;
        }

        @Override // com.tencent.mm.ui.base.preference.CheckBoxPreference.a
        public final void dCy() {
            AppMethodBeat.i(253556);
            y yVar = y.vXH;
            TextView gLy = this.vXs.gLy();
            p.g(gLy, "pref.summaryTextView");
            y.a(gLy, this.vXt);
            AppMethodBeat.o(253556);
        }
    }

    @Override // com.tencent.mm.plugin.i.a.ae
    public final void a(Object obj, ImageView imageView) {
        cjl cjl;
        AppMethodBeat.i(253558);
        if (obj == null || imageView == null || !(obj instanceof FinderObject)) {
            AppMethodBeat.o(253558);
            return;
        }
        FinderItem.a aVar = FinderItem.Companion;
        FinderItem a2 = FinderItem.a.a((FinderObject) obj, 1);
        if (a2.isLiveFeed()) {
            cjl = (cjl) j.ks(a2.getLiveMediaList());
        } else {
            cjl = (cjl) j.ks(a2.getMediaList());
        }
        if (cjl.mediaType == 4) {
            if (Util.isNullOrNil(cjl.coverUrl)) {
                com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
                m mVar = m.uJa;
                d<o> djY = m.djY();
                m mVar2 = m.uJa;
                djY.a(kVar, imageView, m.a(m.a.TIMELINE));
                AppMethodBeat.o(253558);
                return;
            }
            com.tencent.mm.plugin.finder.loader.q qVar = new com.tencent.mm.plugin.finder.loader.q(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE);
            m mVar3 = m.uJa;
            d<o> djY2 = m.djY();
            m mVar4 = m.uJa;
            djY2.a(qVar, imageView, m.a(m.a.TIMELINE));
            AppMethodBeat.o(253558);
        } else if (cjl.mediaType == 9) {
            String str = cjl.coverUrl;
            if (str == null) {
                str = "";
            }
            p.g(str, "mediaObj.coverUrl ?: \"\"");
            if (Util.isNullOrNil(str)) {
                str = p.I(cjl.thumbUrl, Util.nullAsNil(cjl.thumb_url_token));
            }
            m mVar5 = m.uJa;
            d<o> djY3 = m.djY();
            com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
            m mVar6 = m.uJa;
            djY3.a(pVar, imageView, m.a(m.a.TIMELINE));
            AppMethodBeat.o(253558);
        } else {
            m mVar7 = m.uJa;
            d<o> djY4 = m.djY();
            com.tencent.mm.plugin.finder.loader.k kVar2 = new com.tencent.mm.plugin.finder.loader.k(cjl, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE, null, null, 12);
            m mVar8 = m.uJa;
            djY4.a(kVar2, imageView, m.a(m.a.TIMELINE));
            AppMethodBeat.o(253558);
        }
    }
}
