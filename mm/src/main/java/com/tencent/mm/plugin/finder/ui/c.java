package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\tH\u0002J$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0006J\u0014\u0010\"\u001a\u00020\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060$R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u000e¢\u0006\u0002\n\u0000R4\u0010\u000b\u001a\u001c\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/storage/Contact;", "Lkotlin/collections/ArrayList;", "onItemLongClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function3;)V", "getCount", "", "getItem", "position", "getItemId", "", "getName", UserDataStore.CITY, "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "interest", "likeUsername", "setLikedContactList", "contacts", "", "LikedViewHolder", "plugin-finder_release"})
public final class c extends BaseAdapter {
    private String TAG = "Finder.FinderFriendBlackListAdapter";
    private Activity dKq;
    private ArrayList<as> kgc;
    public q<? super View, ? super String, ? super Boolean, x> vKe;

    public final /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(252377);
        as Ln = Ln(i2);
        AppMethodBeat.o(252377);
        return Ln;
    }

    public c(Activity activity) {
        p.h(activity, "context");
        AppMethodBeat.i(252380);
        this.dKq = activity;
        this.kgc = new ArrayList<>();
        AppMethodBeat.o(252380);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: android.view.View */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"ResourceType"})
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String username;
        AppMethodBeat.i(252374);
        z.f fVar = new z.f();
        fVar.SYG = view;
        if (fVar.SYG == null) {
            fVar.SYG = (T) aa.jQ(this.dKq).inflate(R.layout.a9g, viewGroup, false);
            a aVar = new a();
            T t = fVar.SYG;
            p.g(t, "itemView");
            t.setTag(aVar);
        }
        T t2 = fVar.SYG;
        if (t2 == null) {
            p.hyc();
        }
        Object tag = t2.getTag();
        if (tag == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFriendBlackListAdapter.LikedViewHolder");
            AppMethodBeat.o(252374);
            throw tVar;
        }
        a aVar2 = (a) tag;
        View findViewById = fVar.SYG.findViewById(R.id.cmm);
        p.g(findViewById, "itemView.findViewById(R.id.finder_liked_avatar_iv)");
        ImageView imageView = (ImageView) findViewById;
        p.h(imageView, "<set-?>");
        aVar2.gyr = imageView;
        View findViewById2 = fVar.SYG.findViewById(R.id.cmq);
        p.g(findViewById2, "itemView.findViewById(R.…finder_liked_username_tv)");
        TextView textView = (TextView) findViewById2;
        p.h(textView, "<set-?>");
        aVar2.pIN = textView;
        aVar2.getAvatarIv().setImageResource(R.raw.default_avatar);
        as Ln = Ln(i2);
        TextView textView2 = aVar2.pIN;
        if (textView2 == null) {
            p.btv("nicknameTv");
        }
        Activity activity = this.dKq;
        if (Ln.arH() == 0 || Util.isNullOrNil(Ln.arJ())) {
            username = Ln.getUsername();
            if (username == null) {
                username = "";
            }
        } else {
            username = Ln.arJ();
            p.g(username, "ct.displayRemark");
        }
        textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(activity, username));
        a.b.c(aVar2.getAvatarIv(), Ln.getUsername());
        fVar.SYG.setOnLongClickListener(new b(this, fVar, Ln));
        fVar.SYG.setOnClickListener(new View$OnClickListenerC1294c(this, Ln));
        T t3 = fVar.SYG;
        AppMethodBeat.o(252374);
        return t3;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b implements View.OnLongClickListener {
        final /* synthetic */ z.f rrB;
        final /* synthetic */ c vKf;
        final /* synthetic */ as vKg;

        b(c cVar, z.f fVar, as asVar) {
            this.vKf = cVar;
            this.rrB = fVar;
            this.vKg = asVar;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(252372);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            q<? super View, ? super String, ? super Boolean, x> qVar = this.vKf.vKe;
            if (qVar != null) {
                T t = this.rrB.SYG;
                String username = this.vKg.getUsername();
                p.g(username, "blackUser.username");
                qVar.d(t, username, Boolean.valueOf(this.vKg.ajE() == 1));
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(252372);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.ui.c$c  reason: collision with other inner class name */
    static final class View$OnClickListenerC1294c implements View.OnClickListener {
        final /* synthetic */ c vKf;
        final /* synthetic */ as vKg;

        View$OnClickListenerC1294c(c cVar, as asVar) {
            this.vKf = cVar;
            this.vKg = asVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252373);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.d(this.vKg.getUsername(), this.vKf.dKq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252373);
        }
    }

    public final void avP(String str) {
        AppMethodBeat.i(252375);
        p.h(str, "likeUsername");
        int i2 = 0;
        Iterator<as> it = this.kgc.iterator();
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (p.j(it.next().getUsername(), str)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            this.kgc.remove(i2);
            notifyDataSetChanged();
        }
        AppMethodBeat.o(252375);
    }

    private as Ln(int i2) {
        AppMethodBeat.i(252376);
        as asVar = this.kgc.get(i2);
        p.g(asVar, "dataList[position]");
        as asVar2 = asVar;
        AppMethodBeat.o(252376);
        return asVar2;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getCount() {
        AppMethodBeat.i(252378);
        int size = this.kgc.size();
        AppMethodBeat.o(252378);
        return size;
    }

    public final void ew(List<String> list) {
        AppMethodBeat.i(252379);
        p.h(list, "contacts");
        this.kgc.clear();
        for (T t : list) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
            p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
            as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(t);
            if (Kn != null) {
                this.kgc.add(Kn);
            } else {
                Log.i(this.TAG, "setLikedContactList, not exist contact: ".concat(String.valueOf(t)));
            }
        }
        AppMethodBeat.o(252379);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderFriendBlackListAdapter$LikedViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nicknameTv", "Landroid/widget/TextView;", "getNicknameTv", "()Landroid/widget/TextView;", "setNicknameTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
    public static final class a {
        public ImageView gyr;
        public TextView pIN;

        public final ImageView getAvatarIv() {
            AppMethodBeat.i(252371);
            ImageView imageView = this.gyr;
            if (imageView == null) {
                p.btv("avatarIv");
            }
            AppMethodBeat.o(252371);
            return imageView;
        }
    }
}
