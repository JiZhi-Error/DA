package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.api.n;
import com.tencent.mm.plugin.story.ui.a.d;
import com.tencent.mm.plugin.story.ui.layout.AvatarLayoutManager;
import com.tencent.mm.ui.ar;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u0000 [2\u00020\u0001:\u0001[B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010D\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010E\u001a\u00020\u0019J\b\u0010F\u001a\u00020\u001aH\u0002J\b\u0010G\u001a\u00020\u001aH\u0002J\b\u0010H\u001a\u00020\u001aH\u0002J\u000e\u0010I\u001a\u00020\u001a2\u0006\u0010J\u001a\u00020\tJ\u0016\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020\u001aJ\u0014\u0010P\u001a\u00020\u001a2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00100RJ\u000e\u0010S\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u0019J\u000e\u0010U\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u0019J\u000e\u0010V\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u0019J\u000e\u0010W\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020\u0019J\u000e\u0010X\u001a\u00020\u001a2\u0006\u0010Y\u001a\u00020\u0019J\u000e\u0010Z\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,RL\u0010-\u001a4\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R\"\u00109\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R\u000e\u0010?\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allFavBtn", "Landroid/widget/ImageView;", "avatarRecycler", "Landroid/support/v7/widget/RecyclerView;", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "checkedChangeListener", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "", "", "closeView", "dataAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "dataLayoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/AvatarLayoutManager;", "favCheckBox", "Landroid/widget/CheckBox;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "itemStatusGroup", "Landroid/view/View;", "menuBtn", "onAllFav", "Lkotlin/Function0;", "getOnAllFav", "()Lkotlin/jvm/functions/Function0;", "setOnAllFav", "(Lkotlin/jvm/functions/Function0;)V", "onCheckedFav", "Lkotlin/ParameterName;", "name", "checkBox", "isChecked", "getOnCheckedFav", "()Lkotlin/jvm/functions/Function2;", "setOnCheckedFav", "(Lkotlin/jvm/functions/Function2;)V", "onClickRangeIcon", "getOnClickRangeIcon", "setOnClickRangeIcon", "onClose", "getOnClose", "setOnClose", "onMenu", "getOnMenu", "setOnMenu", "privacyIcon", "rangeIcon", "recyclerViewContainer", "Landroid/widget/FrameLayout;", "snsIcon", "initWithGalleryType", "needAction", "relayoutDateRecyclerView", "relayoutProfileRecyclerView", "relayoutSelfFavBtn", "removeUser", "userIndex", "setScrollOffset", "position", "offset", "", "setShowClose", "setUserList", "userList", "", "showFavoriteIcon", "isShow", "showPrivacyIcon", "showRangeIcon", "showSnsIcon", "toggleActiveState", "active", "updateFavCheckedStatus", "Companion", "plugin-story_release"})
public final class GalleryVerticalControlView extends RelativeLayout {
    public static final a FFQ = new a((byte) 0);
    private static final String TAG = TAG;
    final ImageView Cdq;
    final ImageView DnY;
    private final ImageView FEx;
    final ImageView FFB;
    final ImageView FFC;
    final RecyclerView FFD;
    private final View FFE;
    final ImageView FFF;
    final CheckBox FFG;
    n.a FFH;
    d<?> FFI;
    AvatarLayoutManager FFJ;
    private m<? super CompoundButton, ? super Boolean, x> FFK;
    private kotlin.g.a.a<x> FFL;
    private kotlin.g.a.a<x> FFM;
    private kotlin.g.a.a<x> FFN;
    m<? super CompoundButton, ? super Boolean, x> FFO;
    private kotlin.g.a.a<x> FFP;
    final FrameLayout jBO;
    private String jVv;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "checkBox", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke", "(Landroid/widget/CompoundButton;Z)Lkotlin/Unit;"})
    static final class b extends q implements m<CompoundButton, Boolean, x> {
        final /* synthetic */ GalleryVerticalControlView FFR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GalleryVerticalControlView galleryVerticalControlView) {
            super(2);
            this.FFR = galleryVerticalControlView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(CompoundButton compoundButton, Boolean bool) {
            AppMethodBeat.i(120384);
            CompoundButton compoundButton2 = compoundButton;
            boolean booleanValue = bool.booleanValue();
            p.h(compoundButton2, "checkBox");
            m<CompoundButton, Boolean, x> onCheckedFav = this.FFR.getOnCheckedFav();
            if (onCheckedFav != null) {
                x invoke = onCheckedFav.invoke(compoundButton2, Boolean.valueOf(booleanValue));
                AppMethodBeat.o(120384);
                return invoke;
            }
            AppMethodBeat.o(120384);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [kotlin.g.a.m, kotlin.g.a.m<? super android.widget.CompoundButton, ? super java.lang.Boolean, kotlin.x>] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GalleryVerticalControlView(android.content.Context r5, android.util.AttributeSet r6, int r7) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.GalleryVerticalControlView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GalleryVerticalControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120391);
        AppMethodBeat.o(120391);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(120392);
        AppMethodBeat.o(120392);
    }

    public final String getChatRoom() {
        return this.jVv;
    }

    public final void setChatRoom(String str) {
        this.jVv = str;
        d<?> dVar = this.FFI;
        if (!(dVar instanceof com.tencent.mm.plugin.story.ui.a.b)) {
            dVar = null;
        }
        com.tencent.mm.plugin.story.ui.a.b bVar = (com.tencent.mm.plugin.story.ui.a.b) dVar;
        if (bVar != null) {
            bVar.jVv = str;
        }
    }

    public final kotlin.g.a.a<x> getOnClose() {
        return this.FFL;
    }

    public final void setOnClose(kotlin.g.a.a<x> aVar) {
        this.FFL = aVar;
    }

    public final kotlin.g.a.a<x> getOnMenu() {
        return this.FFM;
    }

    public final void setOnMenu(kotlin.g.a.a<x> aVar) {
        this.FFM = aVar;
    }

    public final kotlin.g.a.a<x> getOnAllFav() {
        return this.FFN;
    }

    public final void setOnAllFav(kotlin.g.a.a<x> aVar) {
        this.FFN = aVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super android.widget.CompoundButton, ? super java.lang.Boolean, kotlin.x>, kotlin.g.a.m<android.widget.CompoundButton, java.lang.Boolean, kotlin.x> */
    public final m<CompoundButton, Boolean, x> getOnCheckedFav() {
        return this.FFO;
    }

    public final void setOnCheckedFav(m<? super CompoundButton, ? super Boolean, x> mVar) {
        this.FFO = mVar;
    }

    public final kotlin.g.a.a<x> getOnClickRangeIcon() {
        return this.FFP;
    }

    public final void setOnClickRangeIcon(kotlin.g.a.a<x> aVar) {
        this.FFP = aVar;
    }

    public final void setUserList(List<String> list) {
        AppMethodBeat.i(120386);
        p.h(list, "userList");
        d<?> dVar = this.FFI;
        if (dVar != null) {
            p.h(list, "users");
            dVar.kgc.clear();
            dVar.kgc.add("");
            dVar.kgc.addAll(list);
            dVar.kgc.add("");
        }
        d<?> dVar2 = this.FFI;
        if (dVar2 != null) {
            dVar2.notifyDataSetChanged();
            AppMethodBeat.o(120386);
            return;
        }
        AppMethodBeat.o(120386);
    }

    public final void vY(boolean z) {
        AppMethodBeat.i(120387);
        if (z) {
            this.FEx.setVisibility(0);
            this.FEx.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_lock, getResources().getColor(R.color.aad)));
            AppMethodBeat.o(120387);
            return;
        }
        this.FEx.setVisibility(8);
        AppMethodBeat.o(120387);
    }

    public final void vZ(boolean z) {
        AppMethodBeat.i(120388);
        if (!z || !com.tencent.mm.plugin.story.c.a.a.FkW.fnd()) {
            this.FEx.setVisibility(8);
            AppMethodBeat.o(120388);
            return;
        }
        this.FEx.setVisibility(0);
        this.FEx.setImageDrawable(ar.m(getContext(), R.raw.icons_filled_star, getResources().getColor(R.color.aad)));
        AppMethodBeat.o(120388);
    }

    public final void wa(boolean z) {
        AppMethodBeat.i(120389);
        if (z) {
            setVisibility(0);
            AppMethodBeat.o(120389);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(120389);
    }
}
