package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J@\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "fragmentTabType", "", "(I)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindConfig", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "bindFriendConfig", "bindLbsConfig", "getLayoutId", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class z extends e<y> {
    private final String TAG = "FinderFeedLiveListItemConvert";
    private final int tDo;
    private final int tDx = 5;

    public z(int i2) {
        this.tDo = i2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, y yVar, int i2, int i3, boolean z, List list) {
        String str;
        String str2;
        FinderAuthInfo finderAuthInfo;
        int i4;
        String str3;
        boolean z2;
        awe awe;
        LinkedList<FinderMedia> linkedList;
        String str4;
        AppMethodBeat.i(243073);
        y yVar2 = yVar;
        p.h(hVar, "holder");
        p.h(yVar2, "item");
        m mVar = m.uJa;
        d<o> dka = m.dka();
        FinderContact finderContact = yVar2.uOo.contact;
        if (finderContact == null || (str = finderContact.headUrl) == null) {
            str = "";
        }
        a aVar = new a(str);
        View Mn = hVar.Mn(R.id.ehy);
        p.g(Mn, "holder.getView(R.id.live_list_item_avatar)");
        m mVar2 = m.uJa;
        dka.a(aVar, (ImageView) Mn, m.a(m.a.AVATAR));
        View Mn2 = hVar.Mn(R.id.ei1);
        p.g(Mn2, "holder.getView<TextView>….live_list_item_nickname)");
        TextView textView = (TextView) Mn2;
        d dVar = d.tyZ;
        View Mn3 = hVar.Mn(R.id.ei1);
        p.g(Mn3, "holder.getView(R.id.live_list_item_nickname)");
        TextView textView2 = (TextView) Mn3;
        FinderContact finderContact2 = yVar2.uOo.contact;
        if (finderContact2 != null && (str4 = finderContact2.nickname) != null) {
            str2 = str4;
        }
        textView.setText(d.a(textView2, str2, this.tDx));
        com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
        View Mn4 = hVar.Mn(R.id.w0);
        p.g(Mn4, "holder.getView(R.id.auth_icon)");
        ImageView imageView = (ImageView) Mn4;
        FinderContact finderContact3 = yVar2.uOo.contact;
        if (finderContact3 != null) {
            finderAuthInfo = finderContact3.authInfo;
        } else {
            finderAuthInfo = null;
        }
        com.tencent.mm.plugin.finder.utils.y.a(imageView, finderAuthInfo);
        awe awe2 = yVar2.uOo.liveInfo;
        if (awe2 != null) {
            i4 = awe2.liveStatus;
        } else {
            i4 = 2;
        }
        FinderObjectDesc finderObjectDesc = yVar2.uOo.objectDesc;
        FinderMedia finderMedia = (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) ? null : (FinderMedia) j.kt(linkedList);
        if (finderMedia == null) {
            StringBuilder sb = new StringBuilder();
            FinderObject finderObject = yVar2.uOo;
            Log.i("Finder.FeedFullLiveConvert", sb.append((finderObject == null || (awe = finderObject.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(" firstMedia is empty").toString());
        }
        if (finderMedia == null || (str3 = finderMedia.coverUrl) == null) {
            str3 = "";
        }
        p.g(str3, "firstMedia?.coverUrl ?: \"\"");
        String I = p.I(finderMedia != null ? finderMedia.thumbUrl : null, Util.nullAsNil(finderMedia != null ? finderMedia.thumb_url_token : null));
        if (!Util.isNullOrNil(str3)) {
            I = str3;
        }
        ((ImageView) hVar.Mn(R.id.ima)).setImageBitmap(null);
        if (i4 == 1) {
            m mVar3 = m.uJa;
            b<o, Bitmap> a2 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(I, x.FULL_IMAGE)).a(new com.tencent.mm.loader.e.d(null, null, 3));
            m mVar4 = m.uJa;
            b<o, Bitmap> a3 = a2.a(m.a(m.a.TIMELINE));
            View Mn5 = hVar.Mn(R.id.ima);
            p.g(Mn5, "holder.getView<ImageView>(R.id.thumb_img)");
            a3.c((ImageView) Mn5);
            View Mn6 = hVar.Mn(R.id.cw_);
            p.g(Mn6, "holder.getView<View>(R.i…inder_live_onlive_widget)");
            Mn6.setVisibility(0);
            View Mn7 = hVar.Mn(R.id.cq1);
            p.g(Mn7, "holder.getView<View>(R.id.finder_live_finish_logo)");
            Mn7.setVisibility(8);
        } else {
            com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
            View Mn8 = hVar.Mn(R.id.ima);
            p.g(Mn8, "holder.getView<ImageView>(R.id.thumb_img)");
            com.tencent.mm.plugin.finder.utils.m.h((ImageView) Mn8, I);
            View Mn9 = hVar.Mn(R.id.cw_);
            p.g(Mn9, "holder.getView<View>(R.i…inder_live_onlive_widget)");
            Mn9.setVisibility(8);
            View Mn10 = hVar.Mn(R.id.cq1);
            p.g(Mn10, "holder.getView<View>(R.id.finder_live_finish_logo)");
            Mn10.setVisibility(0);
        }
        if (this.tDo == 2) {
            String str5 = this.TAG;
            StringBuilder sb2 = new StringBuilder("bindLbsConfig recommendReason is empty:");
            String str6 = yVar2.uOo.recommendReason;
            if (str6 == null || str6.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Log.i(str5, sb2.append(z2).append(",recommendReasonType:").append(yVar2.uOo.recommendReasonType).toString());
            String str7 = yVar2.uOo.recommendReason;
            if (!(str7 == null || str7.length() == 0)) {
                LinearLayout linearLayout = (LinearLayout) hVar.Mn(R.id.ben);
                ImageView imageView2 = (ImageView) hVar.Mn(R.id.beu);
                TextView textView3 = (TextView) hVar.Mn(R.id.bfg);
                p.g(textView3, "containerTxt");
                String str8 = yVar2.uOo.recommendReason;
                textView3.setText(str8 != null ? str8 : "");
                textView3.setVisibility(0);
                switch (yVar2.uOo.recommendReasonType) {
                    case 1:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context = hVar.getContext();
                        Context context2 = hVar.getContext();
                        p.g(context2, "holder.context");
                        imageView2.setImageDrawable(ar.m(context, R.raw.icons_filled_location, context2.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    default:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(8);
                        p.g(imageView2, "image");
                        imageView2.setVisibility(8);
                        textView3.setVisibility(8);
                        break;
                    case 9:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context3 = hVar.getContext();
                        Context context4 = hVar.getContext();
                        p.g(context4, "holder.context");
                        imageView2.setImageDrawable(ar.m(context3, R.raw.icons_filled_me, context4.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                    case 10:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context5 = hVar.getContext();
                        Context context6 = hVar.getContext();
                        p.g(context6, "holder.context");
                        imageView2.setImageDrawable(ar.m(context5, R.raw.finder_icons_filled_topic, context6.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                    case 11:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context7 = hVar.getContext();
                        Context context8 = hVar.getContext();
                        p.g(context8, "holder.context");
                        imageView2.setImageDrawable(ar.m(context7, R.raw.finder_icons_filled_sight, context8.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                    case 12:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context9 = hVar.getContext();
                        Context context10 = hVar.getContext();
                        p.g(context10, "holder.context");
                        imageView2.setImageDrawable(ar.m(context9, R.raw.finder_filled_fire, context10.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                    case 13:
                        p.g(linearLayout, "container");
                        linearLayout.setVisibility(0);
                        Context context11 = hVar.getContext();
                        Context context12 = hVar.getContext();
                        p.g(context12, "holder.context");
                        imageView2.setImageDrawable(ar.m(context11, R.raw.finder_icons_filled_food, context12.getResources().getColor(R.color.am)));
                        p.g(imageView2, "image");
                        imageView2.setVisibility(0);
                        break;
                }
            }
        } else if (this.tDo == 1) {
            LinearLayout linearLayout2 = (LinearLayout) hVar.Mn(R.id.ben);
            ImageView imageView3 = (ImageView) hVar.Mn(R.id.beu);
            p.g(imageView3, "image");
            imageView3.setVisibility(8);
            TextView textView4 = (TextView) hVar.Mn(R.id.bfg);
            int i5 = yVar2.uOo.friendLikeCount;
            if (i5 > 0) {
                p.g(linearLayout2, "container");
                linearLayout2.setVisibility(0);
                p.g(textView4, "containerTxt");
                textView4.setVisibility(0);
                Context context13 = MMApplicationContext.getContext();
                p.g(context13, "MMApplicationContext.getContext()");
                Resources resources = context13.getResources();
                com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
                textView4.setText(resources.getString(R.string.csk, com.tencent.mm.plugin.finder.utils.y.LT(i5)));
            } else {
                p.g(linearLayout2, "container");
                linearLayout2.setVisibility(8);
                p.g(textView4, "containerTxt");
                textView4.setVisibility(8);
            }
            Log.i(this.TAG, "bindFriendConfig item:".concat(String.valueOf(yVar2)));
        }
        Log.i(this.TAG, "[updateLiveList]onBindViewHolder holder:" + hVar + " tabType:" + this.tDo + ",position:" + i2 + ",type:" + i3 + ',' + yVar2);
        AppMethodBeat.o(243073);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        AppMethodBeat.i(243071);
        if (com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.tDo, 0, 2)) {
            AppMethodBeat.o(243071);
            return R.layout.aau;
        }
        AppMethodBeat.o(243071);
        return R.layout.aav;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243072);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243072);
    }
}
