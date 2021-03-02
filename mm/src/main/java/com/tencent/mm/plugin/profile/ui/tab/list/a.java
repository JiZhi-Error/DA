package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.stats.CodePackage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.chatting.viewitems.e;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMCollapsibleTextView;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 G2\u00020\u0001:\bEFGHIJKLB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u00101\u001a\u00020\u0005H\u0016J\u000e\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u0005J\b\u00104\u001a\u00020\u0005H\u0002J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0005H\u0016J&\u00108\u001a\u0004\u0018\u0001092\u0006\u00103\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u0001092\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u000e\u0010=\u001a\u00020(2\u0006\u0010>\u001a\u00020?J\u0018\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010DR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001dj\b\u0012\u0004\u0012\u00020\u0005`\u001eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b!\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u00100¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "addContactScene", "", "contact", "Lcom/tencent/mm/storage/Contact;", "enterTime", "", "(Landroid/content/Context;ILcom/tencent/mm/storage/Contact;J)V", "getAddContactScene", "()I", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "changedPlayId", "", "getContact", "()Lcom/tencent/mm/storage/Contact;", "getContext", "()Landroid/content/Context;", "getEnterTime", "()J", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getExpandSet", "()Ljava/util/HashSet;", "isBizPayOpen", "", "()Z", "messageHandler", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/model/BizMessageAdapter;", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "originalCount", "getOriginalCount", "setOriginalCount", "(I)V", "getCount", "getDateString", "position", "getFooterCount", "getItem", "", "getItemId", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onMusicStateChanged", "event", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "update", "msgList", "Lcom/tencent/mm/protocal/protobuf/BizMessageList;", "notifyInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "BizMsgViewHolder", "CommonSlotViewModel", "Companion", "SlotType", "SlotViewModel", "TopSlotViewModel", "VideoChannelViewHolder", "ViewHolder", "app_release"})
public final class a extends BaseAdapter {
    public static final c BmV = new c((byte) 0);
    private static final String TAG = TAG;
    private String Bkv;
    private int Bkw;
    private final kotlin.f Bkx;
    final boolean Bky;
    private final HashSet<Integer> Bkz;
    private final com.tencent.mm.plugin.profile.ui.newbizinfo.b.a BmT;
    kotlin.g.a.a<x> BmU;
    final as contact;
    final Context context;
    final long enterTime;
    final int kgm = 0;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "", "(Ljava/lang/String;I)V", "TOP", CodePackage.COMMON, "BOTTOM", "SINGLE", "app_release"})
    public enum d {
        TOP,
        Bnb,
        BOTTOM,
        SINGLE;

        static {
            AppMethodBeat.i(230748);
            AppMethodBeat.o(230748);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(230750);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(230750);
            return dVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$ViewHolder;", "", "()V", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "app_release"})
    static abstract class h {
    }

    private final com.tencent.mm.plugin.brandservice.a.b eFj() {
        AppMethodBeat.i(230809);
        com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) this.Bkx.getValue();
        AppMethodBeat.o(230809);
        return bVar;
    }

    public a(Context context2, as asVar, long j2) {
        p.h(context2, "context");
        p.h(asVar, "contact");
        AppMethodBeat.i(230811);
        this.context = context2;
        this.contact = asVar;
        this.enterTime = j2;
        this.BmT = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.a();
        com.tencent.mm.plugin.brandservice.b.c.init();
        this.Bkv = "none";
        this.Bkx = kotlin.g.ah(i.Bnk);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
        p.g(af, "MMKernel.service(IBrandService::class.java)");
        this.Bky = ((com.tencent.mm.plugin.brandservice.a.b) af).cle();
        this.Bkz = new HashSet<>();
        AppMethodBeat.o(230811);
    }

    public final void d(ov ovVar) {
        AppMethodBeat.i(230807);
        p.h(ovVar, "msgList");
        this.BmT.b(ovVar);
        this.BmT.a(null);
        notifyDataSetChanged();
        AppMethodBeat.o(230807);
    }

    public final int getCount() {
        AppMethodBeat.i(230808);
        int size = this.BmT.getSize();
        AppMethodBeat.o(230808);
        return size;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(230810);
        int i3 = (i2 - this.Bkw) + 0;
        switch (d.$EnumSwitchMapping$0[this.BmT.UU(i3).ordinal()]) {
            case 1:
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.wr, viewGroup, false);
                kotlin.g.a.a<x> aVar = this.BmU;
                if (aVar != null) {
                    aVar.invoke();
                }
                AppMethodBeat.o(230810);
                return inflate;
            case 2:
                Object item = this.BmT.getItem(i3);
                if (item == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMessage");
                    AppMethodBeat.o(230810);
                    throw tVar;
                }
                ou ouVar = (ou) item;
                if (ouVar.KVq.xKb == 49 && eFj().CR(16)) {
                    com.tencent.mm.plugin.brandservice.a.b eFj = eFj();
                    LinkedList<nh> linkedList = ouVar.KVv.KSK;
                    p.g(linkedList, "bizMessage.AppMsg.DetailInfo");
                    LinkedList<nh> linkedList2 = linkedList;
                    ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
                    for (T t : linkedList2) {
                        arrayList.add(j.listOf((Object[]) new String[]{t.KSj, String.valueOf(t.iAb)}));
                    }
                    eFj.j(arrayList, 126);
                }
                View view2 = new C1597a(this, view, viewGroup, ouVar, this.Bkz, i3 / 2).view;
                AppMethodBeat.o(230810);
                return view2;
            case 3:
                Context context2 = this.context;
                Object item2 = this.BmT.getItem(i3);
                if (item2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.ProfileNotifyInfo");
                    AppMethodBeat.o(230810);
                    throw tVar2;
                }
                View view3 = new g(context2, this, view, viewGroup, (dey) item2).view;
                AppMethodBeat.o(230810);
                return view3;
            default:
                View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.wp, viewGroup, false);
                if (inflate2 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(230810);
                    throw tVar3;
                }
                ViewGroup viewGroup2 = (ViewGroup) inflate2;
                TextView textView = (TextView) viewGroup2.findViewById(R.id.a7_);
                if (textView != null) {
                    textView.setText(this.BmT.UT(i3));
                }
                ViewGroup viewGroup3 = viewGroup2;
                AppMethodBeat.o(230810);
                return viewGroup3;
        }
    }

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010>\u001a\u00020?2\u0006\u0010\u0006\u001a\u00020@2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010A\u001a\u00020BH\u0014J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010D\u001a\u00020?H\u0014J\b\u0010E\u001a\u00020?H\u0014J8\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u001f2\b\b\u0002\u0010J\u001a\u00020\u00032\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010L\u001a\u00020\u0003H\u0004R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8DX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR#\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000bR\u0014\u0010*\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000bR\u0014\u0010,\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u0014\u0010.\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u00102\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u000bR\u0018\u00104\u001a\u000205*\u0002058DX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0018\u00108\u001a\u000205*\u00020\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0018\u0010;\u001a\u00020\u0003*\u00020\u00038DX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "audioPadding", "getAudioPadding", "()I", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "imageDefaultRes", "getImageDefaultRes", "imageIv", "Landroid/widget/ImageView;", "getImageIv", "()Landroid/widget/ImageView;", "imageIv$delegate", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "value", "", "imageUrl", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "item", "getItem", "()Landroid/view/ViewGroup;", "item$delegate", "getItemShowType", "largePading", "getLargePading", "listPadding", "getListPadding", "normalPading", "getNormalPading", "getSlotType", "()Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "smallPadding", "getSmallPadding", "dpToPixel", "", "getDpToPixel", "(F)F", "resFromRaw", "getResFromRaw", "(I)F", "resToPixel", "getResToPixel", "(I)I", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "isPayMsg", "url", "scene", "app_release"})
    public static class e {
        private final int BkL = R.color.j6;
        private final kotlin.f BkY;
        private final kotlin.f BkZ = kotlin.g.ah(new b(this));
        final int Bla = ((int) bJ(36.0f));
        private final int Blb = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.i1);
        final int Blc = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.ir);
        final int Bld = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.hs);
        private final int Ble = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.k5);
        private final float[] Blf = kotlin.a.e.b(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)});
        final d Bnf;
        String imageUrl = "";
        final int iwc;
        private final kotlin.f tMy = kotlin.g.ah(new C1601a(this));

        public final ViewGroup eFo() {
            AppMethodBeat.i(230758);
            ViewGroup viewGroup = (ViewGroup) this.BkY.getValue();
            AppMethodBeat.o(230758);
            return viewGroup;
        }

        /* access modifiers changed from: package-private */
        public final ImageView eFp() {
            AppMethodBeat.i(230759);
            ImageView imageView = (ImageView) this.BkZ.getValue();
            AppMethodBeat.o(230759);
            return imageView;
        }

        /* access modifiers changed from: protected */
        public final Context getContext() {
            AppMethodBeat.i(230761);
            Context context = (Context) this.tMy.getValue();
            AppMethodBeat.o(230761);
            return context;
        }

        public e(int i2, d dVar, ViewGroup viewGroup) {
            p.h(dVar, "slotType");
            p.h(viewGroup, "container");
            AppMethodBeat.i(230767);
            this.iwc = i2;
            this.Bnf = dVar;
            this.BkY = kotlin.g.ah(new C1602e(this, viewGroup));
            AppMethodBeat.o(230767);
        }

        /* access modifiers changed from: protected */
        public ViewGroup c(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(230760);
            p.h(context, "context");
            p.h(viewGroup, "container");
            n nVar = new n();
            AppMethodBeat.o(230760);
            throw nVar;
        }

        public static /* synthetic */ void a(e eVar, View view, d dVar) {
            AppMethodBeat.i(230763);
            eVar.a(view, dVar, true);
            AppMethodBeat.o(230763);
        }

        /* access modifiers changed from: protected */
        public void a(View view, d dVar, boolean z) {
            int i2;
            AppMethodBeat.i(230762);
            p.h(view, "container");
            p.h(dVar, "slotType");
            switch (c.$EnumSwitchMapping$0[dVar.ordinal()]) {
                case 1:
                    view.setPadding(this.Bld, this.Ble, this.Bld, 0);
                    view.setBackgroundResource(z ? R.drawable.hh : R.drawable.hf);
                    AppMethodBeat.o(230762);
                    return;
                case 2:
                    view.setPadding(this.Bld, this.Ble, this.Bld, 0);
                    i2 = R.drawable.hb;
                    break;
                case 3:
                    view.setPadding(this.Bld, this.Ble, this.Bld, this.Bld);
                    i2 = R.drawable.ha;
                    break;
                case 4:
                    view.setPadding(this.Bld, this.Ble, this.Bld, this.Ble);
                    if (!z) {
                        i2 = R.drawable.hc;
                        break;
                    } else {
                        i2 = R.drawable.he;
                        break;
                    }
                default:
                    AppMethodBeat.o(230762);
            }
            view.setBackgroundResource(i2);
            AppMethodBeat.o(230762);
        }

        /* access modifiers changed from: protected */
        public final void a(MMNeat7extView mMNeat7extView, String str, int i2, String str2, int i3) {
            boolean z = true;
            AppMethodBeat.i(230764);
            p.h(mMNeat7extView, "neatText");
            p.h(str, "text");
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(mMNeat7extView.getContext(), str);
            if (!(this.iwc == 0 && i2 == 1)) {
                z = false;
            }
            com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
            p.g(c2, "text");
            aVar.a(c2, mMNeat7extView, z, str2, i3);
            mMNeat7extView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(mMNeat7extView, new o(mMNeat7extView.getContext())));
            AppMethodBeat.o(230764);
        }

        /* access modifiers changed from: protected */
        public float[] eFl() {
            return this.Blf;
        }

        /* access modifiers changed from: protected */
        public int eFm() {
            return this.BkL;
        }

        public final void setImageUrl(String str) {
            boolean z;
            AppMethodBeat.i(230765);
            p.h(str, "value");
            if (kotlin.n.n.aL(str)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                AppMethodBeat.o(230765);
                return;
            }
            String u = com.tencent.mm.api.b.u(str, 2);
            p.g(u, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
            this.imageUrl = u;
            c cVar = a.BmV;
            Log.v(a.TAG, "imageUrl:" + this.imageUrl);
            float[] eFl = eFl();
            String str2 = this.imageUrl;
            c.a bdp = new c.a().bdp();
            StringBuilder sb = new StringBuilder("radius_");
            String arrays = Arrays.toString(eFl);
            p.g(arrays, "java.util.Arrays.toString(this)");
            com.tencent.mm.av.a.a.c bdv = bdp.OU(sb.append(arrays).toString()).tz(eFm()).a(new com.tencent.mm.pluginsdk.ui.applet.n(3)).a(new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(s.bdu(this.imageUrl)).bdv();
            d dVar = new d(this);
            m mVar = new m(3, -1, -1, eFl, dVar);
            mVar.aG(new c(this, str2, bdv, eFl, dVar));
            q.bcV().a(str2, eFp(), bdv, mVar);
            AppMethodBeat.o(230765);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel$imageUrl$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
        public static final class d implements m.a {
            final /* synthetic */ e Bng;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(e eVar) {
                this.Bng = eVar;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(230755);
                c cVar = a.BmV;
                Log.v(a.TAG, "imageUrl onFinish:" + this.Bng.imageUrl);
                this.Bng.eFk();
                AppMethodBeat.o(230755);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
                AppMethodBeat.i(230756);
                c cVar = a.BmV;
                Log.v(a.TAG, "imageUrl onStart:" + this.Bng.imageUrl);
                this.Bng.eFq();
                AppMethodBeat.o(230756);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel$imageUrl$imageLoaderListener$1$1"})
        static final class c implements Runnable {
            final /* synthetic */ com.tencent.mm.av.a.a.c Bli;
            final /* synthetic */ float[] Blj;
            final /* synthetic */ e Bng;
            final /* synthetic */ d Bnh;
            final /* synthetic */ String pFh;

            c(e eVar, String str, com.tencent.mm.av.a.a.c cVar, float[] fArr, d dVar) {
                this.Bng = eVar;
                this.pFh = str;
                this.Bli = cVar;
                this.Blj = fArr;
                this.Bnh = dVar;
            }

            public final void run() {
                AppMethodBeat.i(230754);
                com.tencent.mm.av.a.a bcV = q.bcV();
                String str = this.pFh;
                ImageView eFp = this.Bng.eFp();
                com.tencent.mm.av.a.a.c cVar = this.Bli;
                ImageView eFp2 = this.Bng.eFp();
                p.g(eFp2, "imageIv");
                int measuredWidth = eFp2.getMeasuredWidth();
                ImageView eFp3 = this.Bng.eFp();
                p.g(eFp3, "imageIv");
                bcV.a(str, eFp, cVar, new m(3, measuredWidth, eFp3.getMeasuredHeight(), this.Blj, this.Bnh));
                AppMethodBeat.o(230754);
            }
        }

        /* access modifiers changed from: protected */
        public void eFk() {
        }

        /* access modifiers changed from: protected */
        public void eFq() {
        }

        protected static float bJ(float f2) {
            AppMethodBeat.i(230766);
            Resources resources = MMApplicationContext.getResources();
            p.g(resources, "MMApplicationContext.getResources()");
            float f3 = (resources.getDisplayMetrics().density * f2) + 0.5f;
            AppMethodBeat.o(230766);
            return f3;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$e$e  reason: collision with other inner class name */
        static final class C1602e extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
            final /* synthetic */ ViewGroup Bll;
            final /* synthetic */ e Bng;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1602e(e eVar, ViewGroup viewGroup) {
                super(0);
                this.Bng = eVar;
                this.Bll = viewGroup;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ViewGroup invoke() {
                AppMethodBeat.i(230757);
                e eVar = this.Bng;
                Context context = this.Bll.getContext();
                p.g(context, "container.context");
                ViewGroup c2 = eVar.c(context, this.Bll);
                e.a(this.Bng, c2, this.Bng.Bnf);
                AppMethodBeat.o(230757);
                return c2;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
            final /* synthetic */ e Bng;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar) {
                super(0);
                this.Bng = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ImageView invoke() {
                AppMethodBeat.i(230753);
                ImageView imageView = (ImageView) this.Bng.eFo().findViewById(R.id.a7b);
                AppMethodBeat.o(230753);
                return imageView;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$e$a  reason: collision with other inner class name */
        static final class C1601a extends kotlin.g.b.q implements kotlin.g.a.a<Context> {
            final /* synthetic */ e Bng;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1601a(e eVar) {
                super(0);
                this.Bng = eVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Context invoke() {
                AppMethodBeat.i(230752);
                Context context = this.Bng.eFo().getContext();
                AppMethodBeat.o(230752);
                return context;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010[\u001a\u00020\\2\u0006\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010]\u001a\u00020\u001bH\u0014J\u0018\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020`2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010a\u001a\u00020\\H\u0014J\b\u0010b\u001a\u00020\\H\u0014J.\u0010c\u001a\u00020\\2\u0006\u0010d\u001a\u00020\u00032\u0016\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u00030fj\b\u0012\u0004\u0012\u00020\u0003`g2\u0006\u0010h\u001a\u00020>J\u0010\u0010i\u001a\u00020\\2\u0006\u0010j\u001a\u00020\u0003H\u0002R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\u00160\u00168FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\"\u0010 R\u000e\u0010#\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u00038TX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8TX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u001eR#\u00100\u001a\n \u000b*\u0004\u0018\u000101018FX\u0002¢\u0006\f\n\u0004\b4\u0010\u000f\u001a\u0004\b2\u00103R#\u00105\u001a\n \u000b*\u0004\u0018\u000101018FX\u0002¢\u0006\f\n\u0004\b7\u0010\u000f\u001a\u0004\b6\u00103R#\u00108\u001a\n \u000b*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b:\u0010\u000f\u001a\u0004\b9\u0010\u0013R#\u0010;\u001a\n \u000b*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b=\u0010\u000f\u001a\u0004\b<\u0010\u0018R$\u0010?\u001a\u00020>2\u0006\u0010\u001a\u001a\u00020>@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001e\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00110Ej\b\u0012\u0004\u0012\u00020\u0011`FX\u000e¢\u0006\u0002\n\u0000R#\u0010G\u001a\n \u000b*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\bI\u0010\u000f\u001a\u0004\bH\u0010\u0018R#\u0010J\u001a\n \u000b*\u0004\u0018\u00010K0K8BX\u0002¢\u0006\f\n\u0004\bN\u0010\u000f\u001a\u0004\bL\u0010MR\u001c\u0010O\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010A\"\u0004\bQ\u0010CR#\u0010R\u001a\n \u000b*\u0004\u0018\u00010K0K8BX\u0002¢\u0006\f\n\u0004\bT\u0010\u000f\u001a\u0004\bS\u0010MR#\u0010U\u001a\n \u000b*\u0004\u0018\u000101018FX\u0002¢\u0006\f\n\u0004\bW\u0010\u000f\u001a\u0004\bV\u00103R#\u0010X\u001a\n \u000b*\u0004\u0018\u000101018FX\u0002¢\u0006\f\n\u0004\bZ\u0010\u000f\u001a\u0004\bY\u00103¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$TopSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "collapseTextLayout", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "getCollapseTextLayout", "()Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "collapseTextLayout$delegate", "Lkotlin/Lazy;", "descMask", "Landroid/view/View;", "getDescMask", "()Landroid/view/View;", "descMask$delegate", "digestTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getDigestTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "digestTv$delegate", "value", "", "hasAudioDesc", "getHasAudioDesc", "()Z", "setHasAudioDesc", "(Z)V", "hasDesc", "setHasDesc", "hasSingleInfo", "hasTitle", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "isSingleImage", "picCntTv", "Landroid/widget/TextView;", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "singleDescLayout", "getSingleDescLayout", "singleDescLayout$delegate", "singleTitleTv", "getSingleTitleTv", "singleTitleTv$delegate", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleDescViews", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "titleTv", "getTitleTv", "titleTv$delegate", "topMask", "Landroid/widget/ImageView;", "getTopMask", "()Landroid/widget/ImageView;", "topMask$delegate", "url", "getUrl", "setUrl", "videPlayImg", "getVidePlayImg", "videPlayImg$delegate", "videoDurationTv", "getVideoDurationTv", "videoDurationTv$delegate", "voiceDurationTv", "getVoiceDurationTv", "voiceDurationTv$delegate", "fillBackground", "", "selector", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "onImageLoadStart", "setText", "id", "expandSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "text", "setTitleDescTextColor", "color", "app_release"})
    static final class f extends e {
        final kotlin.f BkO = kotlin.g.ah(new e(this));
        private final kotlin.f BkP = kotlin.g.ah(new h(this));
        private final kotlin.f BkQ;
        int BkR;
        private boolean Blm;
        boolean Bln;
        boolean Blo;
        ArrayList<View> Blp = new ArrayList<>();
        private final kotlin.f Blq = kotlin.g.ah(new l(this));
        private final kotlin.f Blr = kotlin.g.ah(new b(this));
        final kotlin.f Bls = kotlin.g.ah(new n(this));
        final kotlin.f Blt = kotlin.g.ah(new o(this));
        private final kotlin.f Blu;
        private final kotlin.f Blv;
        private final kotlin.f Blw;
        final kotlin.f Blx;
        private final kotlin.f Bly;
        boolean Blz;
        private String title;
        String url = "";

        private final ImageView eFt() {
            AppMethodBeat.i(230788);
            ImageView imageView = (ImageView) this.Blq.getValue();
            AppMethodBeat.o(230788);
            return imageView;
        }

        private final MMNeat7extView eFu() {
            AppMethodBeat.i(230790);
            MMNeat7extView mMNeat7extView = (MMNeat7extView) this.BkQ.getValue();
            AppMethodBeat.o(230790);
            return mMNeat7extView;
        }

        private final ImageView eFv() {
            AppMethodBeat.i(230791);
            ImageView imageView = (ImageView) this.Blu.getValue();
            AppMethodBeat.o(230791);
            return imageView;
        }

        private MMCollapsibleTextView eFx() {
            AppMethodBeat.i(230793);
            MMCollapsibleTextView mMCollapsibleTextView = (MMCollapsibleTextView) this.Bly.getValue();
            AppMethodBeat.o(230793);
            return mMCollapsibleTextView;
        }

        public final TextView eFn() {
            AppMethodBeat.i(230789);
            TextView textView = (TextView) this.BkP.getValue();
            AppMethodBeat.o(230789);
            return textView;
        }

        /* access modifiers changed from: package-private */
        public final View eFw() {
            AppMethodBeat.i(230792);
            View view = (View) this.Blv.getValue();
            AppMethodBeat.o(230792);
            return view;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(int i2, d dVar, ViewGroup viewGroup) {
            super(i2, dVar, viewGroup);
            p.h(dVar, "slotType");
            p.h(viewGroup, "container");
            AppMethodBeat.i(230799);
            this.BkQ = kotlin.g.ah(new k(this, i2));
            this.Blu = kotlin.g.ah(new m(this));
            this.Blv = kotlin.g.ah(new i(this));
            this.Blw = kotlin.g.ah(new j(this));
            this.Blx = kotlin.g.ah(new c(this));
            this.Bly = kotlin.g.ah(new C1603a(this));
            this.title = "";
            AppMethodBeat.o(230799);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final ViewGroup c(Context context, ViewGroup viewGroup) {
            int i2;
            ViewGroup viewGroup2;
            AppMethodBeat.i(230783);
            p.h(context, "context");
            p.h(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ws, viewGroup, false);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(230783);
                throw tVar;
            }
            ViewGroup viewGroup3 = (ViewGroup) inflate;
            switch (this.iwc) {
                case 5:
                    i2 = R.id.bah;
                    viewGroup2 = viewGroup3;
                    break;
                case 6:
                case 7:
                    i2 = R.id.bad;
                    viewGroup2 = viewGroup3;
                    break;
                case 8:
                    eFr();
                    i2 = R.id.baf;
                    viewGroup2 = viewGroup3;
                    break;
                case 9:
                default:
                    i2 = R.id.bae;
                    viewGroup2 = viewGroup3;
                    break;
                case 10:
                    i2 = R.id.bag;
                    viewGroup2 = viewGroup3;
                    break;
            }
            ((ViewStub) viewGroup2.findViewById(i2)).inflate();
            viewGroup.addView(viewGroup3);
            AppMethodBeat.o(230783);
            return viewGroup3;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final float[] eFl() {
            AppMethodBeat.i(230785);
            if (eFs()) {
                float[] b2 = kotlin.a.e.b(new Float[]{Float.valueOf(bJ(8.0f)), Float.valueOf(bJ(8.0f)), Float.valueOf(bJ(8.0f)), Float.valueOf(bJ(8.0f))});
                AppMethodBeat.o(230785);
                return b2;
            }
            float[] b3 = kotlin.a.e.b(new Float[]{Float.valueOf(bJ(8.0f)), Float.valueOf(bJ(8.0f)), Float.valueOf(0.0f), Float.valueOf(0.0f)});
            AppMethodBeat.o(230785);
            return b3;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final int eFm() {
            AppMethodBeat.i(230786);
            if (eFs()) {
                AppMethodBeat.o(230786);
                return R.drawable.aov;
            }
            AppMethodBeat.o(230786);
            return R.drawable.aow;
        }

        /* access modifiers changed from: package-private */
        public final void eFr() {
            AppMethodBeat.i(230787);
            this.Blm = true;
            if (this.iwc == 5) {
                ImageView eFv = eFv();
                p.g(eFv, "videPlayImg");
                ViewGroup.LayoutParams layoutParams = eFv.getLayoutParams();
                if (layoutParams == null) {
                    t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                    AppMethodBeat.o(230787);
                    throw tVar;
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                if (layoutParams2.verticalBias != 0.56f) {
                    layoutParams2.verticalBias = 0.56f;
                    ImageView eFv2 = eFv();
                    p.g(eFv2, "videPlayImg");
                    eFv2.setLayoutParams(layoutParams2);
                }
            }
            AppMethodBeat.o(230787);
        }

        public final void a(int i2, HashSet<Integer> hashSet, String str) {
            AppMethodBeat.i(230795);
            p.h(hashSet, "expandSet");
            p.h(str, "text");
            MMCollapsibleTextView eFx = eFx();
            p.g(eFx, "collapseTextLayout");
            SpannableString j2 = com.tencent.mm.pluginsdk.ui.span.l.j(eFx.getContext(), str, (int) eFx().getTextSize());
            eFx().setCollapsed(!hashSet.contains(Integer.valueOf(i2)));
            MMCollapsibleTextView eFx2 = eFx();
            p.g(j2, "text");
            eFx2.setText(j2);
            if (eFx().getContentText() instanceof MMNeat7extView) {
                View contentText = eFx().getContentText();
                if (contentText == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMNeat7extView");
                    AppMethodBeat.o(230795);
                    throw tVar;
                }
                MMNeat7extView mMNeat7extView = (MMNeat7extView) contentText;
                eFx().setOnTextTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(mMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.o(mMNeat7extView.getContext())));
            }
            eFx().setOnCollapse(new C1604f(hashSet, i2));
            eFx().setOnExpand(new g(hashSet, i2));
            AppMethodBeat.o(230795);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final void eFq() {
            AppMethodBeat.i(230796);
            com.tencent.mm.ac.d.h(new d(this));
            AppMethodBeat.o(230796);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final void eFk() {
            int i2;
            AppMethodBeat.i(230797);
            Context context = getContext();
            p.g(context, "context");
            Va(context.getResources().getColor(R.color.ag2));
            if (this.Blm) {
                View view = (View) this.Blr.getValue();
                if (eFs()) {
                    i2 = this.Bln ? R.drawable.ap0 : R.drawable.aoz;
                } else {
                    i2 = this.Bln ? R.drawable.aoy : R.drawable.aox;
                }
                view.setBackgroundResource(i2);
            }
            eFt().setBackgroundResource(this.Bnf == d.TOP ? R.drawable.hp : R.drawable.hr);
            AppMethodBeat.o(230797);
        }

        /* access modifiers changed from: package-private */
        public final void Va(int i2) {
            AppMethodBeat.i(230798);
            for (T t : this.Blp) {
                if (t instanceof TextView) {
                    t.setTextColor(i2);
                } else if (t instanceof MMNeat7extView) {
                    t.setTextColor(i2);
                }
            }
            AppMethodBeat.o(230798);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class l extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            l(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ImageView invoke() {
                AppMethodBeat.i(230779);
                View findViewById = this.Bni.eFo().findViewById(R.id.a7j);
                ((ImageView) findViewById).setVisibility(0);
                ImageView imageView = (ImageView) findViewById;
                AppMethodBeat.o(230779);
                return imageView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<View> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ View invoke() {
                AppMethodBeat.i(230769);
                View findViewById = this.Bni.eFo().findViewById(R.id.a7a);
                this.Bni.eFr();
                AppMethodBeat.o(230769);
                return findViewById;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class h extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230775);
                View findViewById = this.Bni.eFo().findViewById(R.id.biz_slot_show_desc_tv);
                TextView textView = (TextView) findViewById;
                this.Bni.eFr();
                textView.setVisibility(0);
                this.Bni.Blp.add(textView);
                TextView textView2 = (TextView) findViewById;
                AppMethodBeat.o(230775);
                return textView2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class n extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            n(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230781);
                TextView textView = (TextView) this.Bni.eFo().findViewById(R.id.a7k);
                AppMethodBeat.o(230781);
                return textView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class o extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            o(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230782);
                TextView textView = (TextView) this.Bni.eFo().findViewById(R.id.a7o);
                AppMethodBeat.o(230782);
                return textView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class e extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230772);
                TextView textView = (TextView) this.Bni.eFo().findViewById(R.id.biz_slot_pic_cnt);
                AppMethodBeat.o(230772);
                return textView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class k extends kotlin.g.b.q implements kotlin.g.a.a<MMNeat7extView> {
            final /* synthetic */ f Bni;
            final /* synthetic */ int pmn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            k(f fVar, int i2) {
                super(0);
                this.Bni = fVar;
                this.pmn = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ MMNeat7extView invoke() {
                AppMethodBeat.i(230778);
                View findViewById = this.Bni.eFo().findViewById(R.id.biz_slot_title_neat_tv);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById;
                mMNeat7extView.setVisibility(0);
                switch (this.pmn) {
                    case 0:
                    case 5:
                    case 8:
                        TextPaint paint = mMNeat7extView.getPaint();
                        if (paint != null) {
                            paint.setFakeBoldText(true);
                            break;
                        }
                        break;
                }
                this.Bni.eFr();
                this.Bni.Bln = true;
                this.Bni.Blp.add(mMNeat7extView);
                MMNeat7extView mMNeat7extView2 = (MMNeat7extView) findViewById;
                AppMethodBeat.o(230778);
                return mMNeat7extView2;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class m extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            m(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ImageView invoke() {
                AppMethodBeat.i(230780);
                ImageView imageView = (ImageView) this.Bni.eFo().findViewById(R.id.a7l);
                AppMethodBeat.o(230780);
                return imageView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
        static final class i extends kotlin.g.b.q implements kotlin.g.a.a<View> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ View invoke() {
                AppMethodBeat.i(230776);
                View inflate = ((ViewStub) this.Bni.eFo().findViewById(R.id.a7c)).inflate();
                this.Bni.Blo = true;
                AppMethodBeat.o(230776);
                return inflate;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class j extends kotlin.g.b.q implements kotlin.g.a.a<MMNeat7extView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            j(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ MMNeat7extView invoke() {
                AppMethodBeat.i(230777);
                View findViewById = this.Bni.eFw().findViewById(R.id.a7f);
                ((MMNeat7extView) findViewById).setVisibility(0);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) findViewById;
                AppMethodBeat.o(230777);
                return mMNeat7extView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<MMNeat7extView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ MMNeat7extView invoke() {
                AppMethodBeat.i(230770);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) this.Bni.eFw().findViewById(R.id.a7e);
                AppMethodBeat.o(230770);
                return mMNeat7extView;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMCollapsibleTextView;", "kotlin.jvm.PlatformType", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$f$a  reason: collision with other inner class name */
        static final class C1603a extends kotlin.g.b.q implements kotlin.g.a.a<MMCollapsibleTextView> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1603a(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ MMCollapsibleTextView invoke() {
                AppMethodBeat.i(230768);
                MMCollapsibleTextView mMCollapsibleTextView = (MMCollapsibleTextView) this.Bni.eFo().findViewById(R.id.a7g);
                AppMethodBeat.o(230768);
                return mMCollapsibleTextView;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$f$f  reason: collision with other inner class name */
        public static final class C1604f extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ HashSet BlB;
            final /* synthetic */ int BlC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1604f(HashSet hashSet, int i2) {
                super(0);
                this.BlB = hashSet;
                this.BlC = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(230773);
                this.BlB.remove(Integer.valueOf(this.BlC));
                x xVar = x.SXb;
                AppMethodBeat.o(230773);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ HashSet BlB;
            final /* synthetic */ int BlC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(HashSet hashSet, int i2) {
                super(0);
                this.BlB = hashSet;
                this.BlC = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(230774);
                this.BlB.add(Integer.valueOf(this.BlC));
                x xVar = x.SXb;
                AppMethodBeat.o(230774);
                return xVar;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ f Bni;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(f fVar) {
                super(0);
                this.Bni = fVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(230771);
                f fVar = this.Bni;
                Context context = this.Bni.getContext();
                p.g(context, "context");
                fVar.Va(context.getResources().getColor(R.color.wu));
                x xVar = x.SXb;
                AppMethodBeat.o(230771);
                return xVar;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final void a(View view, d dVar, boolean z) {
            AppMethodBeat.i(230784);
            p.h(view, "container");
            p.h(dVar, "slotType");
            switch (this.iwc) {
                case 6:
                case 7:
                    if (dVar == d.TOP) {
                        View findViewById = view.findViewById(R.id.a7i);
                        p.g(findViewById, "container.findViewById<V…R.id.biz_slot_top_line_v)");
                        findViewById.setVisibility(0);
                    }
                    super.a(view, dVar, false);
                    view.setPadding(0, 0, 0, 0);
                    AppMethodBeat.o(230784);
                    return;
                case 8:
                case 9:
                default:
                    view.setPadding(0, 0, 0, 0);
                    view.setBackgroundResource(0);
                    AppMethodBeat.o(230784);
                    return;
                case 10:
                    super.a(view, dVar, false);
                    AppMethodBeat.o(230784);
                    return;
            }
        }

        private final boolean eFs() {
            return this.Bnf == d.SINGLE && !this.Blo;
        }

        public final void setTitle(String str) {
            int i2 = 4;
            AppMethodBeat.i(230794);
            p.h(str, "value");
            switch (this.iwc) {
                case 6:
                case 7:
                    MMNeat7extView eFu = eFu();
                    p.g(eFu, "titleTv");
                    a(eFu, str, this.BkR, this.url, 4);
                    eFt().setBackgroundResource(this.Bnf == d.TOP ? R.drawable.hr : R.drawable.hp);
                    AppMethodBeat.o(230794);
                    return;
                default:
                    MMNeat7extView eFu2 = this.Bnf == d.SINGLE ? (MMNeat7extView) this.Blw.getValue() : eFu();
                    p.g(eFu2, "if (slotType == SlotType…ingleTitleTv else titleTv");
                    int i3 = this.BkR;
                    String str2 = this.url;
                    if (this.Bnf != d.SINGLE) {
                        i2 = 41;
                    }
                    a(eFu2, str, i3, str2, i2);
                    AppMethodBeat.o(230794);
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u00105\u001a\u0002062\u0006\u0010\u0006\u001a\u0002072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00108\u001a\u000209H\u0014J\u0018\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010=\u001a\u000206H\u0014R\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR#\u0010\u001f\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148FX\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b \u0010\u0017R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R#\u0010)\u001a\n \u0015*\u0004\u0018\u00010*0*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0019\u001a\u0004\b+\u0010,R\u001c\u0010.\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001f\u00101\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u001b0\u001b02¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$CommonSlotViewModel;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotViewModel;", "itemShowType", "", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "container", "Landroid/view/ViewGroup;", "(ILcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;Landroid/view/ViewGroup;)V", "imageDefaultRes", "getImageDefaultRes", "()I", "imageRadiusPxArray", "", "getImageRadiusPxArray", "()[F", "isPayMsg", "setPayMsg", "(I)V", "picCntTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getPicCntTv", "()Landroid/widget/TextView;", "picCntTv$delegate", "Lkotlin/Lazy;", "picInfo", "Landroid/support/constraint/ConstraintLayout;", "getPicInfo", "()Landroid/support/constraint/ConstraintLayout;", "picInfo$delegate", "showDescTv", "getShowDescTv", "showDescTv$delegate", "value", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "titleTv", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTv", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "titleTv$delegate", "url", "getUrl", "setUrl", "weakPicInfo", "Ljava/lang/ref/WeakReference;", "getWeakPicInfo", "()Ljava/lang/ref/WeakReference;", "fillBackground", "", "Landroid/view/View;", "selector", "", "inflate", "context", "Landroid/content/Context;", "onImageLoadFinish", "app_release"})
    public static final class b extends e {
        private final int BkL = R.drawable.aou;
        private final kotlin.f BkM = kotlin.g.ah(new C1600b(this));
        private final WeakReference<ConstraintLayout> BkN = new WeakReference<>((ConstraintLayout) this.BkM.getValue());
        final kotlin.f BkO = kotlin.g.ah(new C1599a(this));
        private final kotlin.f BkP = kotlin.g.ah(new c(this));
        private final kotlin.f BkQ = kotlin.g.ah(new d(this));
        int BkR;
        private String title = "";
        String url = "";

        public final TextView eFn() {
            AppMethodBeat.i(230745);
            TextView textView = (TextView) this.BkP.getValue();
            AppMethodBeat.o(230745);
            return textView;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i2, d dVar, ViewGroup viewGroup) {
            super(i2, dVar, viewGroup);
            p.h(dVar, "slotType");
            p.h(viewGroup, "container");
            AppMethodBeat.i(230747);
            AppMethodBeat.o(230747);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final ViewGroup c(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(230741);
            p.h(context, "context");
            p.h(viewGroup, "container");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wo, viewGroup, false);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(230741);
                throw tVar;
            }
            ViewGroup viewGroup2 = (ViewGroup) inflate;
            viewGroup.addView(viewGroup2);
            AppMethodBeat.o(230741);
            return viewGroup2;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final void a(View view, d dVar, boolean z) {
            LinearLayout.LayoutParams layoutParams;
            AppMethodBeat.i(230742);
            p.h(view, "container");
            p.h(dVar, "slotType");
            switch (b.$EnumSwitchMapping$0[dVar.ordinal()]) {
                case 1:
                case 2:
                    View findViewById = view.findViewById(R.id.a77);
                    p.g(findViewById, "container.findViewById<V…d.biz_slot_common_line_v)");
                    findViewById.setVisibility(0);
                    break;
            }
            View findViewById2 = view.findViewById(R.id.a7p);
            p.g(findViewById2, "container.findViewById<F…id.biz_slot_voice_layout)");
            ((FrameLayout) findViewById2).setVisibility(8);
            switch (this.iwc) {
                case 5:
                    View findViewById3 = view.findViewById(R.id.a7b);
                    p.g(findViewById3, "container.findViewById<I…iew>(R.id.biz_slot_image)");
                    ((ImageView) findViewById3).setVisibility(0);
                    View findViewById4 = view.findViewById(R.id.a7l);
                    p.g(findViewById4, "container.findViewById<I….biz_slot_video_play_img)");
                    ((ImageView) findViewById4).setVisibility(0);
                    break;
                case 6:
                case 9:
                default:
                    View findViewById5 = view.findViewById(R.id.a7b);
                    p.g(findViewById5, "container.findViewById<I…iew>(R.id.biz_slot_image)");
                    ((ImageView) findViewById5).setVisibility(0);
                    break;
                case 7:
                    View findViewById6 = view.findViewById(R.id.a7p);
                    p.g(findViewById6, "container.findViewById<F…id.biz_slot_voice_layout)");
                    ((FrameLayout) findViewById6).setVisibility(0);
                    break;
                case 8:
                    View findViewById7 = view.findViewById(R.id.a7b);
                    p.g(findViewById7, "container.findViewById<I…iew>(R.id.biz_slot_image)");
                    ((ImageView) findViewById7).setVisibility(0);
                    View findViewById8 = view.findViewById(R.id.a73);
                    p.g(findViewById8, "container.findViewById<C…slot_common_content_desc)");
                    ((ConstraintLayout) findViewById8).setVisibility(0);
                    break;
                case 10:
                    MMNeat7extView mMNeat7extView = (MMNeat7extView) view.findViewById(R.id.biz_slot_title_neat_tv);
                    p.g(mMNeat7extView, "tv");
                    if (mMNeat7extView.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                        ViewGroup.LayoutParams layoutParams2 = mMNeat7extView.getLayoutParams();
                        if (layoutParams2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                            AppMethodBeat.o(230742);
                            throw tVar;
                        }
                        layoutParams = (ConstraintLayout.LayoutParams) layoutParams2;
                    } else {
                        ViewGroup.LayoutParams layoutParams3 = mMNeat7extView.getLayoutParams();
                        if (!(layoutParams3 instanceof LinearLayout.LayoutParams)) {
                            layoutParams3 = null;
                        }
                        layoutParams = (LinearLayout.LayoutParams) layoutParams3;
                    }
                    if (layoutParams != null) {
                        layoutParams.setMarginEnd(0);
                        mMNeat7extView.setLayoutParams(layoutParams);
                    }
                    View findViewById9 = view.findViewById(R.id.a7b);
                    p.g(findViewById9, "container.findViewById<I…iew>(R.id.biz_slot_image)");
                    ((ImageView) findViewById9).setVisibility(8);
                    break;
            }
            super.a(view, dVar, z);
            AppMethodBeat.o(230742);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final void eFk() {
            AppMethodBeat.i(230743);
            if (this.BkN == null) {
                AppMethodBeat.o(230743);
                return;
            }
            ConstraintLayout constraintLayout = this.BkN.get();
            if (constraintLayout != null) {
                constraintLayout.setBackgroundResource(R.drawable.h7);
                AppMethodBeat.o(230743);
                return;
            }
            AppMethodBeat.o(230743);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final float[] eFl() {
            AppMethodBeat.i(230744);
            float[] b2 = kotlin.a.e.b(new Float[]{Float.valueOf(bJ(1.0f)), Float.valueOf(bJ(1.0f)), Float.valueOf(bJ(1.0f)), Float.valueOf(bJ(1.0f))});
            AppMethodBeat.o(230744);
            return b2;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.profile.ui.tab.list.a.e
        public final int eFm() {
            return this.BkL;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/constraint/ConstraintLayout;", "kotlin.jvm.PlatformType", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$b$b  reason: collision with other inner class name */
        static final class C1600b extends kotlin.g.b.q implements kotlin.g.a.a<ConstraintLayout> {
            final /* synthetic */ b BmZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1600b(b bVar) {
                super(0);
                this.BmZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ ConstraintLayout invoke() {
                AppMethodBeat.i(230738);
                ConstraintLayout constraintLayout = (ConstraintLayout) this.BmZ.eFo().findViewById(R.id.a73);
                AppMethodBeat.o(230738);
                return constraintLayout;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$b$a  reason: collision with other inner class name */
        static final class C1599a extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ b BmZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1599a(b bVar) {
                super(0);
                this.BmZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230737);
                TextView textView = (TextView) this.BmZ.eFo().findViewById(R.id.biz_slot_pic_cnt);
                AppMethodBeat.o(230737);
                return textView;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
            final /* synthetic */ b BmZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(b bVar) {
                super(0);
                this.BmZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ TextView invoke() {
                AppMethodBeat.i(230739);
                View findViewById = this.BmZ.eFo().findViewById(R.id.biz_slot_show_desc_tv);
                ((TextView) findViewById).setVisibility(0);
                TextView textView = (TextView) findViewById;
                AppMethodBeat.o(230739);
                return textView;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "kotlin.jvm.PlatformType", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<MMNeat7extView> {
            final /* synthetic */ b BmZ;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar) {
                super(0);
                this.BmZ = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ MMNeat7extView invoke() {
                AppMethodBeat.i(230740);
                MMNeat7extView mMNeat7extView = (MMNeat7extView) this.BmZ.eFo().findViewById(R.id.biz_slot_title_neat_tv);
                AppMethodBeat.o(230740);
                return mMNeat7extView;
            }
        }

        public final void setTitle(String str) {
            AppMethodBeat.i(230746);
            p.h(str, "value");
            MMNeat7extView mMNeat7extView = (MMNeat7extView) this.BkQ.getValue();
            p.g(mMNeat7extView, "titleTv");
            a(mMNeat7extView, str, this.BkR, this.url, 5);
            AppMethodBeat.o(230746);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$VideoChannelViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$ViewHolder;", "context", "Landroid/content/Context;", "widget", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "position", "", "videoInfo", "Lcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;Landroid/view/View;Landroid/view/ViewGroup;ILcom/tencent/mm/protocal/protobuf/ProfileNotifyInfo;)V", "coverSize", "radius", "", "view", "getView", "()Landroid/view/View;", "fillVideoChannel", "", "fillVideoItem", "videoItem", "Lcom/tencent/mm/protocal/protobuf/NotifyVideoInfo;", "itemView", "getDurationText", "", "app_release"})
    static final class g extends h {
        private int BlD;
        final a BmW;
        final Context context;
        private float radius = 2.0f;
        final View view;

        public g(Context context2, a aVar, View view2, ViewGroup viewGroup, dey dey) {
            String string;
            String string2;
            String format;
            p.h(context2, "context");
            p.h(aVar, "widget");
            p.h(dey, "videoInfo");
            AppMethodBeat.i(230803);
            this.context = context2;
            this.BmW = aVar;
            this.BlD = com.tencent.mm.cb.a.fromDPToPix(context2, 64);
            if (p.j(view2 != null ? view2.getTag() : null, dey)) {
                this.view = view2;
            } else {
                View inflate = LayoutInflater.from(context2).inflate(R.layout.x7, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(cont…o_channel, parent, false)");
                this.view = inflate;
                this.view.setTag(dey);
            }
            TextView textView = (TextView) this.view.findViewById(R.id.j4s);
            String str = dey.MJZ;
            if (!(str == null || str.length() == 0)) {
                string = dey.MJZ;
            } else {
                Context context3 = textView.getContext();
                p.g(context3, "context");
                string = context3.getResources().getString(R.string.aj8);
            }
            textView.setText(string);
            com.tencent.mm.plugin.brandservice.ui.b.d dVar = com.tencent.mm.plugin.brandservice.ui.b.d.pMy;
            com.tencent.mm.plugin.brandservice.ui.b.d.i(textView);
            TextView textView2 = (TextView) this.view.findViewById(R.id.j4r);
            String str2 = dey.dQx;
            if (!(str2 == null || str2.length() == 0)) {
                string2 = dey.dQx;
            } else {
                Context context4 = textView2.getContext();
                p.g(context4, "context");
                string2 = context4.getResources().getString(R.string.aj7);
            }
            textView2.setText(string2);
            LinkedList<cty> linkedList = dey.MJY;
            c cVar = a.BmV;
            Log.v(a.TAG, "alvinluo fillVideoChannel size: %d", Integer.valueOf(linkedList.size()));
            LinearLayout linearLayout = (LinearLayout) this.view.findViewById(R.id.j41);
            linearLayout.removeAllViews();
            if (linkedList != null) {
                for (T t : linkedList) {
                    if (t != null) {
                        c cVar2 = a.BmV;
                        Log.d(a.TAG, "alvinluo videoItem url: %s, duration: %d", t.Mzi, Integer.valueOf(t.duration));
                        View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.x8, (ViewGroup) null, false);
                        linearLayout.addView(inflate2);
                        p.g(inflate2, "itemView");
                        View findViewById = inflate2.findViewById(R.id.j4l);
                        p.g(findViewById, "itemView.findViewById<Te…iew>(R.id.video_duration)");
                        TextView textView3 = (TextView) findViewById;
                        int i2 = t.duration / LocalCache.TIME_HOUR;
                        int i3 = (t.duration - (i2 * LocalCache.TIME_HOUR)) / 60;
                        int i4 = t.duration % 60;
                        c cVar3 = a.BmV;
                        Log.i(a.TAG, "alvinluo getDurationText " + i2 + ':' + i3 + ':' + i4);
                        if (i2 > 0) {
                            ae aeVar = ae.SYK;
                            format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
                            p.g(format, "java.lang.String.format(format, *args)");
                        } else {
                            ae aeVar2 = ae.SYK;
                            format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
                            p.g(format, "java.lang.String.format(format, *args)");
                        }
                        textView3.setText(format);
                        ImageView imageView = (ImageView) inflate2.findViewById(R.id.j48);
                        String u = com.tencent.mm.api.b.u(t.Mzi, 2);
                        q.bcV().a(u, imageView, new c.a().bdp().dr(this.BlD, this.BlD).OU("radius_" + this.radius).tz(R.drawable.aou).a(new com.tencent.mm.pluginsdk.ui.applet.n(3)).a(new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(s.bdu(u)).bdv(), new m(3, this.BlD, this.BlD, true, true, this.radius, new b(u, imageView)));
                    }
                }
            }
            View findViewById2 = this.view.findViewById(R.id.h93);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View$OnClickListenerC1605a(this, dey));
                AppMethodBeat.o(230803);
                return;
            }
            AppMethodBeat.o(230803);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$g$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC1605a implements View.OnClickListener {
            final /* synthetic */ dey BlF;
            final /* synthetic */ g Bnj;

            View$OnClickListenerC1605a(g gVar, dey dey) {
                this.Bnj = gVar;
                this.BlF = dey;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230800);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = this.BlF.pTL;
                if (!(str == null || str.length() == 0)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.BlF.pTL);
                    intent.putExtra("geta8key_username", this.Bnj.BmW.contact.getUsername());
                    com.tencent.mm.br.c.b(this.Bnj.context, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.Bnj.BmW.contact.getUsername(), 1402, this.Bnj.BmW.kgm, this.Bnj.BmW.enterTime);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230800);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$VideoChannelViewHolder$fillVideoItem$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
        public static final class b implements m.a {
            final /* synthetic */ ImageView BlG;
            final /* synthetic */ String tra;

            b(String str, ImageView imageView) {
                this.tra = str;
                this.BlG = imageView;
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onFinish() {
                AppMethodBeat.i(230801);
                c cVar = a.BmV;
                Log.v(a.TAG, "imageUrl onFinish:" + this.tra);
                this.BlG.setBackgroundResource(R.drawable.aij);
                AppMethodBeat.o(230801);
            }

            @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
            public final void onStart() {
                AppMethodBeat.i(230802);
                c cVar = a.BmV;
                Log.v(a.TAG, "imageUrl onStart:" + this.tra);
                AppMethodBeat.o(230802);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BK\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0002\u0010\u000fJ0\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\fH\u0002J \u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010 \u001a\u00020'H\u0002J(\u0010(\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\fH\u0002J8\u0010)\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010*\u001a\u00020'H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020,H\u0002J\u0017\u0010/\u001a\u00020,*\b\u0012\u0004\u0012\u00020,00H\u0002¢\u0006\u0002\u00101R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder;", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$ViewHolder;", "interpolator", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;", "convertView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "bizMsg", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "expandSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "position", "(Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter;Landroid/view/View;Landroid/view/ViewGroup;Lcom/tencent/mm/protocal/protobuf/BizMessage;Ljava/util/HashSet;I)V", "context", "Landroid/content/Context;", "isBizPayOpen", "", "()Z", "setBizPayOpen", "(Z)V", "view", "getView", "()Landroid/view/View;", "widget", "fillCommonSlot", "", "container", "detail", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "base", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgBaseInfo;", "slotType", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$SlotType;", "fillSingleText", "text", "Lcom/tencent/mm/protocal/protobuf/BizTextMsgInfo;", "Lcom/tencent/mm/protocal/protobuf/CommMsgBaseInfo;", "fillSlotTarget", "fillTopSlot", "commBase", "getPlayId", "", "isPlaying", "playId", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "app_release"})
    /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$a  reason: collision with other inner class name */
    static final class C1597a extends h {
        private boolean Bky = true;
        private HashSet<Integer> Bkz;
        a BmW;
        Context context;
        final View view;

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007b, code lost:
            if (r2 != true) goto L_0x007d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C1597a(com.tencent.mm.plugin.profile.ui.tab.list.a r14, android.view.View r15, android.view.ViewGroup r16, com.tencent.mm.protocal.protobuf.ou r17, java.util.HashSet<java.lang.Integer> r18, int r19) {
            /*
            // Method dump skipped, instructions count: 850
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.tab.list.a.C1597a.<init>(com.tencent.mm.plugin.profile.ui.tab.list.a, android.view.View, android.view.ViewGroup, com.tencent.mm.protocal.protobuf.ou, java.util.HashSet, int):void");
        }

        private final void a(ViewGroup viewGroup, nh nhVar, ng ngVar, d dVar, int i2) {
            String[] strArr;
            int i3;
            AppMethodBeat.i(230731);
            c cVar = a.BmV;
            Log.v(a.TAG, "fillCommonSlot:" + nhVar.KSj);
            b bVar = new b(nhVar.iAb, dVar, viewGroup);
            bVar.BkR = nhVar.KSF;
            bVar.url = nhVar.KSj;
            String str = nhVar.Title;
            p.g(str, "detail.Title");
            bVar.setTitle(str);
            String str2 = nhVar.KSy;
            if (!(str2 == null || kotlin.n.n.aL(str2))) {
                TextView eFn = bVar.eFn();
                p.g(eFn, "view.showDescTv");
                eFn.setText(nhVar.KSy);
            }
            TextView eFn2 = bVar.eFn();
            if (eFn2 != null) {
                if (bVar.BkR != 1 || this.Bky) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                eFn2.setVisibility(i3);
            }
            if (nhVar.iAb == 8 && nhVar.zbj > 1) {
                TextView textView = (TextView) bVar.BkO.getValue();
                p.g(textView, "view.picCntTv");
                textView.setText(String.valueOf(nhVar.zbj));
            }
            switch (nhVar.iAb) {
                case 5:
                    strArr = new String[]{nhVar.KSl, nhVar.KSm};
                    break;
                default:
                    strArr = new String[]{nhVar.KSm, nhVar.KSl};
                    break;
            }
            bVar.setImageUrl(L(strArr));
            a(bVar.eFo(), nhVar, ngVar, i2);
            AppMethodBeat.o(230731);
        }

        private static boolean gO(String str) {
            AppMethodBeat.i(230732);
            com.tencent.mm.ay.f bef = com.tencent.mm.ay.a.bef();
            if (bef == null) {
                AppMethodBeat.o(230732);
                return false;
            } else if (!p.j(bef.jeV, str) || bef.jeT != 0 || !com.tencent.mm.ay.a.bec()) {
                AppMethodBeat.o(230732);
                return false;
            } else {
                AppMethodBeat.o(230732);
                return true;
            }
        }

        private static String a(nh nhVar) {
            AppMethodBeat.i(230733);
            String str = nhVar.KSj;
            p.g(str, "detail.ContentUrl");
            String ahX = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.ahX(str);
            AppMethodBeat.o(230733);
            return ahX;
        }

        private final void a(View view2, nh nhVar, ng ngVar, int i2) {
            ImageView imageView;
            AppMethodBeat.i(230734);
            if (nhVar.iAb == 7 && (imageView = (ImageView) view2.findViewById(R.id.a7m)) != null) {
                b bVar = new b(imageView);
                c cVar = new c(imageView);
                String a2 = a(nhVar);
                if (gO(a2)) {
                    bVar.invoke();
                } else {
                    cVar.invoke();
                }
                imageView.setOnClickListener(new View$OnClickListenerC1598a(bVar, a2, this, nhVar));
            }
            view2.setOnClickListener(new d(this, nhVar, ngVar, view2, i2));
            AppMethodBeat.o(230734);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"drawPlaying", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$a$b */
        public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ ImageView tqC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(ImageView imageView) {
                super(0);
                this.tqC = imageView;
            }

            @Override // kotlin.g.a.a
            public final void invoke() {
                AppMethodBeat.i(230726);
                this.tqC.setImageResource(R.drawable.ie);
                Drawable drawable = this.tqC.getDrawable();
                if (drawable == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(230726);
                    throw tVar;
                }
                AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                if (animationDrawable != null) {
                    animationDrawable.start();
                    AppMethodBeat.o(230726);
                    return;
                }
                AppMethodBeat.o(230726);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"drawPlay", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$a$c */
        public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ ImageView tqC;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(ImageView imageView) {
                super(0);
                this.tqC = imageView;
            }

            @Override // kotlin.g.a.a
            public final void invoke() {
                AppMethodBeat.i(230728);
                this.tqC.setImageResource(R.drawable.id);
                AppMethodBeat.o(230728);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder$fillSlotTarget$1$3"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC1598a implements View.OnClickListener {
            final /* synthetic */ String BkG;
            final /* synthetic */ nh BkI;
            final /* synthetic */ b BmX;
            final /* synthetic */ C1597a BmY;

            View$OnClickListenerC1598a(b bVar, String str, C1597a aVar, nh nhVar) {
                this.BmX = bVar;
                this.BkG = str;
                this.BmY = aVar;
                this.BkI = nhVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230724);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.BmX.invoke();
                e.g gVar = new e.g();
                e.h hVar = new e.h();
                hVar.JwO = this.BkG;
                hVar.url = this.BkI.KSj;
                hVar.title = this.BkI.Title;
                hVar.iAA = "";
                hVar.playUrl = this.BkI.KSt;
                hVar.coverUrl = this.BkI.KSl;
                gVar.PJr = hVar;
                view.setTag(gVar);
                com.tencent.mm.ui.chatting.s.gA(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder$fillSlotTarget$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230724);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.a$a$d */
        public static final class d implements View.OnClickListener {
            final /* synthetic */ nh BkJ;
            final /* synthetic */ ng BkK;
            final /* synthetic */ C1597a BmY;
            final /* synthetic */ int gUj;
            final /* synthetic */ View qCr;

            d(C1597a aVar, nh nhVar, ng ngVar, View view, int i2) {
                this.BmY = aVar;
                this.BkJ = nhVar;
                this.BkK = ngVar;
                this.qCr = view;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230729);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c cVar = a.BmV;
                Log.i(a.TAG, "onClick jump to url:%s", this.BkJ.KSj);
                Intent intent = new Intent();
                String d2 = com.tencent.mm.ag.m.d(this.BkJ.KSj, 126, -1, 0);
                intent.putExtra("rawUrl", d2);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.putExtra("geta8key_scene", 3);
                intent.putExtra("geta8key_username", this.BmY.BmW.contact.getUsername());
                String stringExtra = intent.getStringExtra("prePublishId");
                if (!Util.isNullOrNil(stringExtra)) {
                    intent.putExtra("KPublisherId", stringExtra);
                    intent.putExtra("prePublishId", stringExtra);
                    intent.putExtra("preUsername", intent.getStringExtra("preUsername"));
                    intent.putExtra("preChatName", intent.getStringExtra("preChatName"));
                } else {
                    intent.putExtra("prePublishId", "brand_profile");
                    intent.putExtra("KPublisherId", "brand_profile");
                }
                intent.putExtra("preChatTYPE", intent.getIntExtra("preChatTYPE", 0));
                int intExtra = intent.getIntExtra("KOpenArticleSceneFromScene", 10000);
                if (this.BkJ.iAb == 5) {
                    com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
                    p.g(af, "MMKernel.service(IBrandService::class.java)");
                    if (((com.tencent.mm.plugin.brandservice.a.b) af).cld()) {
                        intent.putExtra(e.b.OyQ, 126);
                        intent.putExtra(e.b.OyR, intExtra);
                        intent.putExtra("biz_video_session_id", ab.getSessionId());
                        com.tencent.mm.ag.x xVar = new com.tencent.mm.ag.x();
                        xVar.iAh = intent.getStringExtra("KPublisherId");
                        xVar.dHc = this.BmY.BmW.contact.getUsername();
                        xVar.iAg = this.BmY.BmW.contact.arI();
                        xVar.iAi.url = d2;
                        xVar.iAi.title = this.BkJ.Title;
                        xVar.iAi.iAq = "detail.videoDigest";
                        xVar.iAi.iAo = this.BkJ.KSl;
                        xVar.iAi.type = this.BkJ.iAb;
                        xVar.iAi.time = (long) this.BkK.CreateTime;
                        xVar.iAi.iAs = this.BkJ.KSx;
                        xVar.iAi.videoWidth = this.BkJ.KSv;
                        xVar.iAi.videoHeight = this.BkJ.KSw;
                        xVar.iAi.vid = this.BkJ.KSu;
                        xVar.t(intent);
                        c cVar2 = a.BmV;
                        Log.i(a.TAG, "jump to native video");
                        int[] iArr = new int[2];
                        ImageView imageView = (ImageView) this.qCr.findViewById(R.id.a7b);
                        if (imageView != null) {
                            int width = imageView.getWidth();
                            int height = imageView.getHeight();
                            imageView.getLocationInWindow(iArr);
                            intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                        }
                        intent.addFlags(268435456);
                    }
                }
                if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(6) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.BmY.context, d2, this.BkJ.iAb, 126, intExtra, intent)) {
                    com.tencent.mm.br.c.b(this.BmY.context, "webview", ".ui.tools.WebViewUI", intent);
                } else {
                    c cVar3 = a.BmV;
                    Log.i(a.TAG, "jump to TmplWebview");
                }
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.d dVar = com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.BlR;
                String username = this.BmY.BmW.contact.getUsername();
                p.g(username, "widget.contact.username");
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.d.b(username, this.BmY.BmW.enterTime, this.BkK.KSf, this.BkJ.KSi, this.BkJ.iAb, this.gUj, this.BkK.CreateTime, this.BmY.BmW.kgm);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizMsgViewHolder$fillSlotTarget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230729);
            }
        }

        private static String L(String[] strArr) {
            String str;
            AppMethodBeat.i(230730);
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    str = null;
                    break;
                }
                String str2 = strArr[i2];
                String str3 = str2;
                if (!(str3 == null || kotlin.n.n.aL(str3))) {
                    str = str2;
                    break;
                }
                i2++;
            }
            if (str == null) {
                str = "";
            }
            AppMethodBeat.o(230730);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(230812);
        AppMethodBeat.o(230812);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.brandservice.a.b> {
        public static final i Bnk = new i();

        static {
            AppMethodBeat.i(230806);
            AppMethodBeat.o(230806);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.brandservice.a.b invoke() {
            AppMethodBeat.i(230805);
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            AppMethodBeat.o(230805);
            return bVar;
        }
    }
}
