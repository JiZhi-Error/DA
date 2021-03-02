package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.feed.RoundLinearLayout;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bcq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0005H\u0016J@\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0016J \u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J \u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderSnsLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "()V", "MAX_NAME_COUNT", "", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "setItemSize", "plugin-finder_release"})
public final class cg extends e<y> {
    private final String TAG = "FinderFeedLiveListItemConvert";
    private final int tDx = 5;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, y yVar, int i2, int i3, boolean z, List list) {
        int i4;
        String str;
        String str2;
        LinkedList<FinderMedia> linkedList;
        FinderMedia first;
        LinkedList<FinderMedia> linkedList2;
        FinderMedia first2;
        LinkedList<FinderMedia> linkedList3;
        FinderMedia first3;
        String str3;
        String string;
        String str4;
        LinkedList<FinderContact> linkedList4;
        LinkedList<FinderContact> linkedList5;
        AppMethodBeat.i(243279);
        y yVar2 = yVar;
        p.h(hVar, "holder");
        p.h(yVar2, "item");
        if (!z) {
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) hVar.Mn(R.id.ws);
            ((RoundLinearLayout) hVar.Mn(R.id.wq)).setRadius(0.2f);
            roundLinearLayout.setRadius(0.2f);
            ImageView imageView = (ImageView) hVar.Mn(R.id.ehz);
            ImageView imageView2 = (ImageView) hVar.Mn(R.id.ei0);
            p.g(roundLinearLayout, "avatar2Layout");
            roundLinearLayout.setVisibility(0);
            bcq bcq = yVar2.uOo.snsShareInfo;
            if (((bcq == null || (linkedList5 = bcq.LLL) == null) ? 0 : linkedList5.size()) <= 1) {
                roundLinearLayout.setVisibility(8);
            }
            bcq bcq2 = yVar2.uOo.snsShareInfo;
            if (!(bcq2 == null || (linkedList4 = bcq2.LLL) == null)) {
                FinderContact finderContact = (FinderContact) j.kt(linkedList4);
                if (finderContact != null) {
                    m mVar = m.uJa;
                    d<o> dkc = m.dkc();
                    a aVar = new a(finderContact.headUrl);
                    p.g(imageView, "avatar1");
                    m mVar2 = m.uJa;
                    dkc.a(aVar, imageView, m.a(m.a.RECT_AVATAR));
                }
                FinderContact finderContact2 = (FinderContact) j.L(linkedList4, 1);
                if (finderContact2 != null) {
                    m mVar3 = m.uJa;
                    d<o> dkc2 = m.dkc();
                    a aVar2 = new a(finderContact2.headUrl);
                    p.g(imageView2, "avatar2");
                    m mVar4 = m.uJa;
                    dkc2.a(aVar2, imageView2, m.a(m.a.RECT_AVATAR));
                }
            }
        }
        TextView textView = (TextView) hVar.Mn(R.id.ei1);
        com.tencent.mm.plugin.finder.utils.e.n(textView);
        d dVar = d.tyZ;
        p.g(textView, "this");
        FinderContact finderContact3 = yVar2.uOo.contact;
        textView.setText(d.a(textView, (finderContact3 == null || (str4 = finderContact3.nickname) == null) ? "" : str4, this.tDx));
        ImageView imageView3 = (ImageView) hVar.Mn(R.id.w0);
        p.g(imageView3, "authIcon");
        imageView3.setVisibility(8);
        FinderContact finderContact4 = yVar2.uOo.contact;
        if (finderContact4 != null) {
            imageView3.setVisibility(0);
            com.tencent.mm.plugin.finder.utils.y yVar3 = com.tencent.mm.plugin.finder.utils.y.vXH;
            View Mn = hVar.Mn(R.id.w0);
            p.g(Mn, "holder.getView(R.id.auth_icon)");
            com.tencent.mm.plugin.finder.utils.y.a((ImageView) Mn, finderContact4.authInfo);
        }
        com.tencent.mm.plugin.finder.utils.y yVar4 = com.tencent.mm.plugin.finder.utils.y.vXH;
        View Mn2 = hVar.Mn(R.id.hye);
        bcq bcq3 = yVar2.uOo.snsShareInfo;
        if (!(Mn2 == null || bcq3 == null)) {
            TextView textView2 = (TextView) Mn2;
            textView2.setVisibility(0);
            textView2.setTextSize(0, (float) com.tencent.mm.cb.a.aG(hVar.getContext(), R.dimen.kc));
            switch (bcq3.type) {
                case 1:
                    if (bcq3.msj > 2) {
                        string = hVar.getContext().getString(R.string.d_4, new StringBuilder().append(bcq3.msj).toString());
                    } else {
                        string = hVar.getContext().getString(R.string.yx);
                    }
                    textView2.setText(string);
                    break;
                case 2:
                    textView2.setText(hVar.getContext().getString(R.string.d_3, new StringBuilder().append(bcq3.LLK).toString()));
                    break;
                default:
                    textView2.setVisibility(8);
                    break;
            }
        }
        awe awe = yVar2.uOo.liveInfo;
        if (awe != null) {
            i4 = awe.liveStatus;
        } else {
            i4 = 2;
        }
        FinderObjectDesc finderObjectDesc = yVar2.uOo.objectDesc;
        if (finderObjectDesc == null || (linkedList3 = finderObjectDesc.media) == null || (first3 = linkedList3.getFirst()) == null || (str3 = first3.coverUrl) == null) {
            str = "";
        } else {
            str = str3;
        }
        p.g(str, "item.obj.objectDesc?.media?.first?.coverUrl ?: \"\"");
        FinderObjectDesc finderObjectDesc2 = yVar2.uOo.objectDesc;
        if (finderObjectDesc2 == null || (linkedList2 = finderObjectDesc2.media) == null || (first2 = linkedList2.getFirst()) == null) {
            str2 = null;
        } else {
            str2 = first2.thumbUrl;
        }
        FinderObjectDesc finderObjectDesc3 = yVar2.uOo.objectDesc;
        String I = p.I(str2, Util.nullAsNil((finderObjectDesc3 == null || (linkedList = finderObjectDesc3.media) == null || (first = linkedList.getFirst()) == null) ? null : first.thumb_url_token));
        if (Util.isNullOrNil(str)) {
            str = I;
        }
        String str5 = this.TAG;
        StringBuilder sb = new StringBuilder("refreshMask liveId:");
        awe awe2 = yVar2.uOo.liveInfo;
        Log.i(str5, sb.append(awe2 != null ? Long.valueOf(awe2.liveId) : null).append(", liveStatus:").append(i4).append(", showImageUrl:").append(str).toString());
        ((ImageView) hVar.Mn(R.id.ima)).setImageBitmap(null);
        if (i4 == 1) {
            if (!z) {
                m mVar5 = m.uJa;
                b<o, Bitmap> a2 = m.djY().bQ(new com.tencent.mm.plugin.finder.loader.p(str, x.FULL_IMAGE)).a(new com.tencent.mm.loader.e.d(null, null, 3));
                m mVar6 = m.uJa;
                b<o, Bitmap> a3 = a2.a(m.a(m.a.TIMELINE));
                View Mn3 = hVar.Mn(R.id.ima);
                p.g(Mn3, "holder.getView<ImageView>(R.id.thumb_img)");
                a3.c((ImageView) Mn3);
            }
            View Mn4 = hVar.Mn(R.id.cq1);
            p.g(Mn4, "holder.getView<View>(R.id.finder_live_finish_logo)");
            Mn4.setVisibility(8);
            AppMethodBeat.o(243279);
            return;
        }
        com.tencent.mm.plugin.finder.utils.m mVar7 = com.tencent.mm.plugin.finder.utils.m.vVH;
        View Mn5 = hVar.Mn(R.id.ima);
        p.g(Mn5, "holder.getView<ImageView>(R.id.thumb_img)");
        com.tencent.mm.plugin.finder.utils.m.h((ImageView) Mn5, str);
        View Mn6 = hVar.Mn(R.id.cq1);
        p.g(Mn6, "holder.getView<View>(R.id.finder_live_finish_logo)");
        Mn6.setVisibility(0);
        TextView textView3 = (TextView) hVar.Mn(R.id.hye);
        if (textView3 != null) {
            textView3.setVisibility(8);
            AppMethodBeat.o(243279);
            return;
        }
        AppMethodBeat.o(243279);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ak4;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243278);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        Resources resources = context.getResources();
        p.g(resources, "holder.context.resources");
        int i3 = resources.getDisplayMetrics().widthPixels;
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        Resources resources2 = context2.getResources();
        p.g(resources2, "holder.context.resources");
        float min = ((float) (Math.min(resources2.getDisplayMetrics().heightPixels, i3) - com.tencent.mm.cb.a.fromDPToPix(hVar.getContext(), 16))) / 3.5f;
        if (min <= 0.0f) {
            Context context3 = hVar.getContext();
            p.g(context3, "holder.context");
            min = context3.getResources().getDimension(R.dimen.bz);
        }
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) min;
        layoutParams.height = (int) ((4.0f * min) / 3.0f);
        View view2 = hVar.aus;
        p.g(view2, "holder.itemView");
        view2.setLayoutParams(layoutParams);
        AppMethodBeat.o(243278);
    }
}
