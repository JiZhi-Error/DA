package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.bf;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileFloatBallUIC;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J@\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00052\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0017J \u0010\u001e\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010 \u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010#\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002J \u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002J \u0010+\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMusicInfoData;", "()V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "isSelf", "item", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "refreshProgress", "setImage", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setLikeArea", "setOrigin", "mvInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVInfo;", "playIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setPostFailed", "context", "Landroid/content/Context;", "setPosting", "Companion", "plugin-finder_release"})
public final class ca extends com.tencent.mm.view.recyclerview.e<bf> {
    public static final a tFQ = new a((byte) 0);
    private RecyclerView hak;
    public Boolean tFI;

    static {
        AppMethodBeat.i(243262);
        AppMethodBeat.o(243262);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, bf bfVar, int i2, int i3, boolean z, List list) {
        LinkedList<FinderMedia> linkedList;
        axy axy;
        String str;
        boolean z2;
        AppMethodBeat.i(243256);
        bf bfVar2 = bfVar;
        p.h(hVar, "holder");
        p.h(bfVar2, "item");
        axw dkQ = bfVar2.dkQ();
        String zs = com.tencent.mm.ac.d.zs(bfVar2.feedObject.getFinderObject().id);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            for (Object obj : list) {
                if (obj instanceof o) {
                    switch (((o) obj).first.intValue()) {
                        case 2:
                            a(bfVar2, hVar);
                            continue;
                        case 20:
                            a(bfVar2.uOO, hVar);
                            a(bfVar2, hVar);
                            continue;
                        case 21:
                            StringBuilder append = new StringBuilder("payloadsMusicPause :").append(i2).append("  isTheSameIdPlaying:");
                            ac acVar = ac.vER;
                            Log.i("Finder.ProfileMusicConvert", append.append(ac.avv(zs)).toString());
                            WeImageView weImageView = (WeImageView) hVar.Mn(R.id.gjs);
                            if (weImageView != null) {
                                weImageView.setImageResource(R.raw.icons_outlined_pause2);
                                break;
                            } else {
                                continue;
                            }
                        case 22:
                            StringBuilder append2 = new StringBuilder("payloadsMusicPause :").append(i2).append("  isTheSameIdPlaying:");
                            ac acVar2 = ac.vER;
                            Log.i("Finder.ProfileMusicConvert", append2.append(ac.avv(zs)).toString());
                            WeImageView weImageView2 = (WeImageView) hVar.Mn(R.id.gjs);
                            if (weImageView2 != null) {
                                weImageView2.setImageResource(R.raw.icons_outlined_play2);
                                break;
                            } else {
                                continue;
                            }
                    }
                }
            }
            AppMethodBeat.o(243256);
            return;
        }
        WeImageView weImageView3 = (WeImageView) hVar.Mn(R.id.gjs);
        ViewGroup viewGroup = (ViewGroup) hVar.Mn(R.id.gjr);
        FinderObject feedObject = bfVar2.uOO.getFeedObject();
        if (feedObject != null) {
            g gVar = bfVar2.contact;
            if (gVar != null) {
                str = gVar.field_username;
            } else {
                str = null;
            }
            if (!n.I(str, z.aUg(), false) || !p.j(this.tFI, Boolean.TRUE)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                ((WeImageView) hVar.Mn(R.id.gj8)).setImageResource(R.raw.icons_filled_eyes_on);
                Context context = hVar.getContext();
                p.g(context, "holder.context");
                ((WeImageView) hVar.Mn(R.id.gj8)).setIconColor(context.getResources().getColor(R.color.fm));
                FinderObject feedObject2 = bfVar2.uOO.getFeedObject();
                int i4 = feedObject2 != null ? feedObject2.readCount : 0;
                View Mn = hVar.Mn(R.id.gjc);
                p.g(Mn, "holder.getView<TextView>…id.profile_like_count_tv)");
                ((TextView) Mn).setText(k.Lx(i4));
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                ((TextView) hVar.Mn(R.id.gjc)).setTextColor(context2.getResources().getColor(R.color.fm));
                View Mn2 = hVar.Mn(R.id.gj_);
                p.g(Mn2, "holder.getView<LinearLay…>(R.id.profile_like_area)");
                ((LinearLayout) Mn2).setBackground(hVar.getContext().getDrawable(R.drawable.a3y));
            } else {
                ((WeImageView) hVar.Mn(R.id.gj8)).setImageResource(R.raw.icon_filled_awesome);
                Context context3 = hVar.getContext();
                p.g(context3, "holder.context");
                ((WeImageView) hVar.Mn(R.id.gj8)).setIconColor(context3.getResources().getColor(R.color.am));
                String gm = feedObject.likeCount > 0 ? k.gm(2, feedObject.likeCount) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                View Mn3 = hVar.Mn(R.id.gjc);
                p.g(Mn3, "holder.getView<TextView>…id.profile_like_count_tv)");
                ((TextView) Mn3).setText(gm);
                View Mn4 = hVar.Mn(R.id.gj_);
                p.g(Mn4, "holder.getView<LinearLay…>(R.id.profile_like_area)");
                ((LinearLayout) Mn4).setBackground(hVar.getContext().getDrawable(R.drawable.a3x));
                Context context4 = hVar.getContext();
                p.g(context4, "holder.context");
                ((TextView) hVar.Mn(R.id.gjc)).setTextColor(context4.getResources().getColor(R.color.am));
                View Mn5 = hVar.Mn(R.id.gj_);
                p.g(Mn5, "holder.getView<LinearLay…>(R.id.profile_like_area)");
                ((LinearLayout) Mn5).setVisibility(0);
            }
        }
        if (!(dkQ == null || (axy = dkQ.Aqo) == null)) {
            View Mn6 = hVar.Mn(R.id.gjy);
            p.g(Mn6, "holder.getView<TextView>(R.id.profile_music_title)");
            ((TextView) Mn6).setText(axy.BPc);
            View Mn7 = hVar.Mn(R.id.gjp);
            p.g(Mn7, "holder.getView<TextView>(R.id.profile_music_name)");
            TextView textView = (TextView) Mn7;
            String str2 = axy.lDR;
            textView.setText(str2 != null ? str2 : "");
        }
        a(bfVar2, hVar);
        Log.i("Finder.ProfileMusicConvert", "onBindViewHolder imageUrl: ".concat(String.valueOf(bfVar2.dkR())));
        if (!z) {
            ((ImageView) hVar.Mn(R.id.d2l)).setImageResource(R.drawable.c9a);
            a(bfVar2.uOO, hVar);
        }
        hVar.Mn(R.id.gjj).setOnClickListener(new b(bfVar2));
        hVar.Mn(R.id.gjv).setOnClickListener(new c(bfVar2));
        ac acVar3 = ac.vER;
        if (ac.avv(zs)) {
            ac acVar4 = ac.vER;
            ac.KZ(i2);
            weImageView3.setImageResource(R.raw.icons_outlined_pause2);
        } else {
            weImageView3.setImageResource(R.raw.icons_outlined_play2);
        }
        FinderObjectDesc finderObjectDesc = bfVar2.uOO.getFeedObject().objectDesc;
        FinderMedia finderMedia = (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) ? null : (FinderMedia) j.kt(linkedList);
        viewGroup.setOnClickListener(new d(bfVar2, finderMedia != null ? finderMedia.thumbUrl + finderMedia.thumb_url_token : "", dkQ, hVar, zs));
        if (!z) {
            com.tencent.f.h.RTc.aX(new e(hVar, com.tencent.mm.ac.d.zs(bfVar2.uOO.getId())));
        }
        AppMethodBeat.o(243256);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.aix;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243255);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        this.hak = recyclerView;
        AppMethodBeat.o(243255);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ bf tFR;

        b(bf bfVar) {
            this.tFR = bfVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243250);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderItem finderItem = this.tFR.uOO;
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.FS(this.tFR.uOO.getLocalId());
            c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            c.a.FV(finderItem.getLocalId());
            hg hgVar = new hg();
            hgVar.dLJ.localId = finderItem.getLocalId();
            EventCenter.instance.publish(hgVar);
            Log.i("Finder.ProfileMusicConvert", "deleteItem by localId " + finderItem.getLocalId());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243250);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ bf tFR;

        c(bf bfVar) {
            this.tFR = bfVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243251);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
            com.tencent.mm.plugin.finder.upload.g.vSH.t(this.tFR.uOO);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243251);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ h qhp;
        final /* synthetic */ bf tFR;
        final /* synthetic */ axw tFS;
        final /* synthetic */ String tFT;
        final /* synthetic */ String tra;

        d(bf bfVar, String str, axw axw, h hVar, String str2) {
            this.tFR = bfVar;
            this.tra = str;
            this.tFS = axw;
            this.qhp = hVar;
            this.tFT = str2;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            int i2;
            String str6;
            String str7;
            String str8;
            axy axy;
            axy axy2;
            axy axy3;
            axy axy4;
            axy axy5;
            axy axy6;
            axy axy7;
            axy axy8;
            axy axy9;
            axy axy10;
            axy axy11;
            String str9 = null;
            AppMethodBeat.i(243252);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            css css = new css();
            css.Ktn = com.tencent.mm.ac.d.zs(this.tFR.feedObject.getFinderObject().id);
            css.Kto = this.tFR.feedObject.getFinderObject().objectNonceId;
            css.Ktp = this.tra;
            FinderContact finderContact = this.tFR.feedObject.getFinderObject().contact;
            css.Ktq = finderContact != null ? finderContact.nickname : null;
            axw axw = this.tFS;
            if (axw == null || (axy11 = axw.Aqo) == null) {
                str = null;
            } else {
                str = axy11.lDR;
            }
            css.singerName = str;
            axw axw2 = this.tFS;
            if (axw2 == null || (axy10 = axw2.Aqo) == null) {
                str2 = null;
            } else {
                str2 = axy10.albumName;
            }
            css.albumName = str2;
            axw axw3 = this.tFS;
            if (axw3 == null || (axy9 = axw3.Aqo) == null) {
                str3 = null;
            } else {
                str3 = axy9.extraInfo;
            }
            css.extraInfo = str3;
            axw axw4 = this.tFS;
            if (axw4 == null || (axy8 = axw4.Aqo) == null) {
                str4 = null;
            } else {
                str4 = axy8.LIi;
            }
            css.musicGenre = str4;
            axw axw5 = this.tFS;
            css.issueDate = (axw5 == null || (axy7 = axw5.Aqo) == null) ? 0 : axy7.LIk;
            axw axw6 = this.tFS;
            if (axw6 == null || (axy6 = axw6.Aqo) == null) {
                str5 = null;
            } else {
                str5 = axy6.lDR;
            }
            css.identification = str5;
            axw axw7 = this.tFS;
            if (axw7 == null || (axy5 = axw7.Aqo) == null) {
                i2 = 0;
            } else {
                i2 = axy5.duration;
            }
            css.Alz = i2;
            axw axw8 = this.tFS;
            if (axw8 == null || (axy4 = axw8.Aqo) == null) {
                str6 = null;
            } else {
                str6 = axy4.BPc;
            }
            css.BPc = str6;
            axw axw9 = this.tFS;
            if (axw9 == null || (axy3 = axw9.Aqo) == null) {
                str7 = null;
            } else {
                str7 = axy3.LIh;
            }
            css.songLyric = str7;
            axw axw10 = this.tFS;
            if (axw10 == null || (axy2 = axw10.Aqo) == null) {
                str8 = null;
            } else {
                str8 = axy2.Djf;
            }
            css.EsK = str8;
            css.jfz = this.tra;
            axw axw11 = this.tFS;
            if (!(axw11 == null || (axy = axw11.Aqo) == null)) {
                Log.i("Finder.ProfileMusicConvert", "playOrPauseMusic");
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.qhp.getContext();
                p.g(context, "holder.context");
                ((FinderProfileFloatBallUIC) com.tencent.mm.ui.component.a.ko(context).get(FinderProfileFloatBallUIC.class)).USD = false;
                ((com.tencent.mm.plugin.ball.c.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(false);
                ac acVar = ac.vER;
                p.g(axy, LocaleUtil.ITALIAN);
                String str10 = this.tFT;
                p.h(axy, "musicSongInfo");
                p.h(str10, "musicId");
                com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
                if (bef != null) {
                    str9 = bef.jeV;
                }
                if (str9 == null || !Util.isEqual(bef.jeV, str10)) {
                    Log.i("FinderMvLogic", "playMusic");
                    ac.b(axy, str10, css);
                } else if (com.tencent.mm.ay.a.bec()) {
                    ol olVar = new ol();
                    olVar.PP(2);
                    olVar.PQ(8);
                    aq.a(olVar);
                    com.tencent.mm.ay.a.bea();
                } else {
                    ac.b(axy, str10, css);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243252);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ h qhp;
        final /* synthetic */ String tzi;

        e(h hVar, String str) {
            this.qhp = hVar;
            this.tzi = str;
        }

        public final void run() {
            AppMethodBeat.i(243253);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.qhp.getContext();
            p.g(context, "holder.context");
            ((FinderProfileEduUIC) com.tencent.mm.ui.component.a.ko(context).get(FinderProfileEduUIC.class)).R("mv", 0, this.tzi);
            AppMethodBeat.o(243253);
        }
    }

    private static void a(FinderItem finderItem, h hVar) {
        AppMethodBeat.i(243257);
        cjl cjl = (cjl) j.kt(finderItem.getMediaList());
        if (cjl != null) {
            m mVar = m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = m.djY();
            com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(cjl, x.THUMB_IMAGE, null, null, 12);
            View Mn = hVar.Mn(R.id.d2l);
            p.g(Mn, "holder.getView<ImageView…inder_profile_item_image)");
            m mVar2 = m.uJa;
            djY.a(kVar, (ImageView) Mn, m.a(m.a.TIMELINE));
            AppMethodBeat.o(243257);
            return;
        }
        AppMethodBeat.o(243257);
    }

    private final void a(bf bfVar, h hVar) {
        AppMethodBeat.i(243258);
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.gjs);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        p.g(weImageView, "playIcon");
        b(context, hVar, weImageView);
        if (bfVar.uOO.getFeedObject() != null) {
            if (bfVar.uOO.isPostFailed()) {
                Context context2 = hVar.getContext();
                p.g(context2, "holder.context");
                a(context2, hVar, weImageView);
                AppMethodBeat.o(243258);
                return;
            } else if (bfVar.dkT()) {
                ValueAnimator ofInt = ValueAnimator.ofInt(((FinderPostProgressView) hVar.Mn(R.id.gjz)).getProgress(), bfVar.dkU());
                ofInt.addUpdateListener(new f(this, bfVar, hVar, weImageView));
                ValueAnimator duration = ofInt.setDuration(400L);
                if (duration != null) {
                    duration.start();
                }
                hVar.setTag(ofInt);
                Log.i("Finder.ProfileMusicConvert", "progress animate: " + ((FinderPostProgressView) hVar.Mn(R.id.gjz)).getProgress() + ", " + bfVar.dkU());
                AppMethodBeat.o(243258);
                return;
            } else {
                a(bfVar.dkQ(), hVar, weImageView);
            }
        }
        AppMethodBeat.o(243258);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/convert/FinderProfileMusicConvert$refreshProgress$1$1"})
    public static final class f implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ca tFU;
        final /* synthetic */ bf tFV;
        final /* synthetic */ WeImageView tFW;
        final /* synthetic */ h tzq;

        f(ca caVar, bf bfVar, h hVar, WeImageView weImageView) {
            this.tFU = caVar;
            this.tFV = bfVar;
            this.tzq = hVar;
            this.tFW = weImageView;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(243254);
            FinderPostProgressView finderPostProgressView = (FinderPostProgressView) this.tzq.Mn(R.id.gjz);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(243254);
                throw tVar;
            }
            finderPostProgressView.setProgress(((Integer) animatedValue).intValue());
            ((FinderPostProgressView) this.tzq.Mn(R.id.gjz)).invalidate();
            AppMethodBeat.o(243254);
        }
    }

    private static void a(Context context, h hVar, WeImageView weImageView) {
        AppMethodBeat.i(243259);
        View Mn = hVar.Mn(R.id.gjt);
        p.g(Mn, "holder.getView<LinearLay…ile_music_post_container)");
        ((LinearLayout) Mn).setVisibility(0);
        View Mn2 = hVar.Mn(R.id.gjn);
        p.g(Mn2, "holder.getView<View>(R.id.profile_music_fail_icon)");
        Mn2.setVisibility(0);
        View Mn3 = hVar.Mn(R.id.gju);
        p.g(Mn3, "holder.getView<TextView>…ofile_music_posting_text)");
        ((TextView) Mn3).setText(context.getString(R.string.d5k));
        View Mn4 = hVar.Mn(R.id.gjz);
        p.g(Mn4, "holder.getView<FinderPos…le_music_upload_progress)");
        ((FinderPostProgressView) Mn4).setVisibility(8);
        View Mn5 = hVar.Mn(R.id.gjv);
        p.g(Mn5, "holder.getView<View>(R.i…le_music_retry_container)");
        Mn5.setVisibility(0);
        View Mn6 = hVar.Mn(R.id.gjq);
        p.g(Mn6, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView) Mn6).setVisibility(8);
        weImageView.setVisibility(8);
        AppMethodBeat.o(243259);
    }

    private static void b(Context context, h hVar, WeImageView weImageView) {
        AppMethodBeat.i(243260);
        View Mn = hVar.Mn(R.id.gjt);
        p.g(Mn, "holder.getView<LinearLay…ile_music_post_container)");
        ((LinearLayout) Mn).setVisibility(0);
        View Mn2 = hVar.Mn(R.id.gjn);
        p.g(Mn2, "holder.getView<View>(R.id.profile_music_fail_icon)");
        Mn2.setVisibility(8);
        View Mn3 = hVar.Mn(R.id.gju);
        p.g(Mn3, "holder.getView<TextView>…ofile_music_posting_text)");
        ((TextView) Mn3).setText(context.getString(R.string.d6u));
        View Mn4 = hVar.Mn(R.id.gjz);
        p.g(Mn4, "holder.getView<FinderPos…le_music_upload_progress)");
        ((FinderPostProgressView) Mn4).setVisibility(0);
        View Mn5 = hVar.Mn(R.id.gjv);
        p.g(Mn5, "holder.getView<View>(R.i…le_music_retry_container)");
        Mn5.setVisibility(8);
        View Mn6 = hVar.Mn(R.id.gjq);
        p.g(Mn6, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView) Mn6).setVisibility(8);
        weImageView.setVisibility(8);
        AppMethodBeat.o(243260);
    }

    private static void a(axw axw, h hVar, WeImageView weImageView) {
        axx axx;
        AppMethodBeat.i(243261);
        View Mn = hVar.Mn(R.id.gjt);
        p.g(Mn, "holder.getView<LinearLay…ile_music_post_container)");
        ((LinearLayout) Mn).setVisibility(8);
        View Mn2 = hVar.Mn(R.id.gjq);
        p.g(Mn2, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView) Mn2).setVisibility(0);
        View Mn3 = hVar.Mn(R.id.gjq);
        p.g(Mn3, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView) Mn3).setText("");
        weImageView.setVisibility(0);
        if (axw == null || (axx = axw.ApI) == null) {
            AppMethodBeat.o(243261);
            return;
        }
        Log.i("Finder.ProfileMusicConvert", "setOrigin :" + axx.LIe);
        Context context = hVar.getContext();
        p.g(context, "holder.context");
        String string = context.getResources().getString(R.string.d6z, Integer.valueOf((int) (axx.LIe * 100.0f)));
        p.g(string, "holder.context.resources…iginality * 100).toInt())");
        View Mn4 = hVar.Mn(R.id.gjq);
        p.g(Mn4, "holder.getView<TextView>…rofile_music_origin_text)");
        ((TextView) Mn4).setText(string);
        AppMethodBeat.o(243261);
    }
}
