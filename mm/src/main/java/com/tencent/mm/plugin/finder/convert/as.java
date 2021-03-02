package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J@\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J \u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderLikeConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "TAG", "", "formatDesc", "", "preCount", "", "incCount", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "id", "descTv", "Landroid/widget/TextView;", "getLayoutId", "onBindViewHolder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class as extends e<BaseFinderFeed> {
    final String TAG = "Finder.FinderLikeConvert";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, BaseFinderFeed baseFinderFeed, int i2, int i3, boolean z, List list) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(243153);
        BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
        p.h(hVar, "holder");
        p.h(baseFinderFeed2, "item");
        ImageView imageView = (ImageView) hVar.Mn(R.id.ebg);
        imageView.setImageResource(R.color.BW_97);
        cjl cjl = (cjl) j.kt(baseFinderFeed2.feedObject.getMediaList());
        if (cjl != null) {
            if (cjl.mediaType == 4) {
                k kVar = new k(cjl, x.THUMB_IMAGE, null, null, 12);
                m mVar = m.uJa;
                d<o> djY = m.djY();
                p.g(imageView, "thumbIv");
                m mVar2 = m.uJa;
                djY.a(kVar, imageView, m.a(m.a.TIMELINE));
            } else {
                m mVar3 = m.uJa;
                d<o> djY2 = m.djY();
                k kVar2 = new k(cjl, x.THUMB_IMAGE, null, null, 12);
                p.g(imageView, "thumbIv");
                m mVar4 = m.uJa;
                djY2.a(kVar2, imageView, m.a(m.a.TIMELINE));
            }
        }
        hVar.aus.setOnClickListener(null);
        List<? extends FinderCommentInfo> list2 = baseFinderFeed2.msgEventLikeList;
        long id = baseFinderFeed2.feedObject.getId();
        String objectNonceId = baseFinderFeed2.feedObject.getObjectNonceId();
        com.tencent.mm.bw.b bVar = baseFinderFeed2.feedObject.getFeedObject().likeBuffer;
        Log.i(this.TAG, "onBindViewHolder name:" + baseFinderFeed2.feedObject.getNickName() + ", likeList size:" + list2.size() + ", jumpFeedId:" + id);
        View Mn = hVar.Mn(R.id.gtp);
        if (Mn != null) {
            Mn.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(hVar.Mn(R.id.da_));
            arrayList.add(hVar.Mn(R.id.dab));
            arrayList.add(hVar.Mn(R.id.dad));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(hVar.Mn(R.id.daa));
            arrayList2.add(hVar.Mn(R.id.dac));
            arrayList2.add(hVar.Mn(R.id.dae));
            int i4 = 0;
            for (Object obj : arrayList) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                ImageView imageView2 = (ImageView) obj;
                if (imageView2 != null) {
                    if (i4 >= list2.size()) {
                        View view = (View) arrayList2.get(i4);
                        if (view != null) {
                            view.setVisibility(8);
                            i4 = i5;
                        } else {
                            i4 = i5;
                        }
                    } else {
                        View view2 = (View) arrayList2.get(i4);
                        if (view2 != null) {
                            view2.setVisibility(0);
                        }
                        String str4 = ((FinderCommentInfo) list2.get(i4)).headUrl;
                        if (str4 == null) {
                            str3 = "";
                        } else {
                            str3 = str4;
                        }
                        p.g(str3, "likeList[index].headUrl ?: \"\"");
                        if (p.j(((FinderCommentInfo) list2.get(i4)).username, z.aTY())) {
                            com.tencent.mm.ui.g.a.a.c(imageView2, z.aTY());
                            i4 = i5;
                        } else {
                            m mVar5 = m.uJa;
                            d<o> dka = m.dka();
                            com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str3);
                            m mVar6 = m.uJa;
                            dka.a(aVar, imageView2, m.a(m.a.AVATAR));
                        }
                    }
                }
                i4 = i5;
            }
            TextView textView = (TextView) hVar.Mn(R.id.gtq);
            if (textView != null) {
                FinderCommentInfo finderCommentInfo = (FinderCommentInfo) j.kt(list2);
                Context context = hVar.getContext();
                y yVar = y.vXH;
                if (finderCommentInfo == null || (str = finderCommentInfo.username) == null) {
                    str = "";
                }
                if (finderCommentInfo == null || (str2 = finderCommentInfo.nickname) == null) {
                    str2 = "";
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, y.hf(str, str2)));
            }
            TextView textView2 = (TextView) hVar.Mn(R.id.gtn);
            int i6 = baseFinderFeed2.msgEventFriendLikeCount;
            int i7 = baseFinderFeed2.msgEventIncCount;
            int i8 = i6 - i7;
            if (i6 == 1) {
                p.g(textView2, "descTv");
                textView2.setText(hVar.getContext().getString(R.string.d7o));
            } else if (i6 > 3 || i7 > 0) {
                if (i7 > 0) {
                    p.g(textView2, "descTv");
                    a(i8, i7, hVar, R.string.d7n, textView2);
                } else {
                    p.g(textView2, "descTv");
                    textView2.setText(hVar.getContext().getString(R.string.d7n, String.valueOf(i6).toString()));
                }
            } else if (i7 > 0) {
                p.g(textView2, "descTv");
                a(i8, i7, hVar, R.string.d7p, textView2);
            } else {
                p.g(textView2, "descTv");
                textView2.setText(hVar.getContext().getString(R.string.d7p, String.valueOf(i6).toString()));
            }
            hVar.aus.setOnClickListener(new a(this, hVar, list2, baseFinderFeed2, bVar));
        }
        imageView.setOnClickListener(new b(this, id, objectNonceId, bVar, hVar));
        AppMethodBeat.o(243153);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.t;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243152);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.Mn(R.id.gtq);
        TextView textView2 = (TextView) hVar.Mn(R.id.gtn);
        p.g(textView, "nicknameTv");
        ao.a(textView.getPaint(), 0.8f);
        p.g(textView2, "descTv");
        ao.a(textView2.getPaint(), 0.8f);
        AppMethodBeat.o(243152);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$2$3"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ BaseFinderFeed tAz;
        final /* synthetic */ as tEw;
        final /* synthetic */ List tEx;
        final /* synthetic */ com.tencent.mm.bw.b tEy;
        final /* synthetic */ h tzq;

        a(as asVar, h hVar, List list, BaseFinderFeed baseFinderFeed, com.tencent.mm.bw.b bVar) {
            this.tEw = asVar;
            this.tzq = hVar;
            this.tEx = list;
            this.tAz = baseFinderFeed;
            this.tEy = bVar;
        }

        public final void onClick(View view) {
            FinderLikeDrawer finderLikeDrawer;
            AppMethodBeat.i(243150);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Context context = this.tzq.getContext();
            if (!(context instanceof Activity)) {
                context = null;
            }
            Activity activity = (Activity) context;
            if (activity != null) {
                finderLikeDrawer = (FinderLikeDrawer) activity.findViewById(R.id.clq);
            } else {
                finderLikeDrawer = null;
            }
            if (finderLikeDrawer != null) {
                finderLikeDrawer.a(this.tAz.feedObject, this.tEy);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243150);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ String tEA;
        final /* synthetic */ com.tencent.mm.bw.b tEB;
        final /* synthetic */ as tEw;
        final /* synthetic */ long tEz;

        b(as asVar, long j2, String str, com.tencent.mm.bw.b bVar, h hVar) {
            this.tEw = asVar;
            this.tEz = j2;
            this.tEA = str;
            this.tEB = bVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243151);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("feed_object_id", this.tEz);
            intent.putExtra("feed_object_nonceId", this.tEA);
            intent.putExtra("key_show_jump_entry", false);
            com.tencent.mm.bw.b bVar2 = this.tEB;
            intent.putExtra("key_like_buffer", Util.encodeHexString(bVar2 != null ? bVar2.toByteArray() : null));
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            com.tencent.mm.plugin.finder.utils.a.G(context, intent);
            Log.i(this.tEw.TAG, "go detail, jumpFeedId:" + this.tEz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderLikeConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243151);
        }
    }

    private static void a(int i2, int i3, h hVar, int i4, TextView textView) {
        AppMethodBeat.i(243154);
        String str = i2 + " + " + i3;
        int length = str.length() - n.a((CharSequence) str, '+', 0, false, 6);
        String string = hVar.getContext().getString(i4, i2 + " + " + i3);
        p.g(string, "holder.context.getString… \"$preCount + $incCount\")");
        int a2 = n.a((CharSequence) string, '+', 0, false, 6);
        if (a2 <= 0 || a2 + length >= string.length()) {
            textView.setText(string);
            AppMethodBeat.o(243154);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.Red)), a2, length + a2, 17);
        textView.setText(spannableStringBuilder);
        AppMethodBeat.o(243154);
    }
}
