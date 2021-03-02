package com.tencent.mm.live.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG extends MMActivity {
    public static final c hUJ = new c((byte) 0);
    private final LinkedList<d> hUG = new LinkedList<>();
    private a hUH;
    private ListView hUI;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "", "showAlert", "", "view", "Landroid/view/View;", "title", "", "value", "plugin-logic_release"})
    public interface d {
        String auk();

        void cp(View view);

        String value();
    }

    static {
        AppMethodBeat.i(208427);
        AppMethodBeat.o(208427);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LiveUIG() {
        AppMethodBeat.i(208426);
        AppMethodBeat.o(208426);
    }

    public static final /* synthetic */ a a(LiveUIG liveUIG) {
        AppMethodBeat.i(208428);
        a aVar = liveUIG.hUH;
        if (aVar == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(208428);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIG$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b1h;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(208425);
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.ek8);
        if (findViewById == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.ListView");
            AppMethodBeat.o(208425);
            throw tVar;
        }
        this.hUI = (ListView) findViewById;
        this.hUH = new a();
        ListView listView = this.hUI;
        if (listView == null) {
            p.hyc();
        }
        a aVar = this.hUH;
        if (aVar == null) {
            p.btv("adapter");
        }
        listView.setAdapter((ListAdapter) aVar);
        this.hUG.add(new b(this, "Live Mode 开关", ar.a.USERINFO_LIVE_MODE_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        this.hUG.add(new b(this, "Live DebugView 开关", ar.a.USERINFO_LIVE_DEBUG_VIEW_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        this.hUG.add(new b(this, "主播自定义房间id", ar.a.USERINFO_LIVE_ANCHOR_CUSTOM_ROOM_ID_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        this.hUG.add(new b(this, "观众自定义房间id", ar.a.USERINFO_LIVE_VISITOR_CUSTOM_ROOM_ID_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        this.hUG.add(new b(this, "Live Entrance 开关", ar.a.USERINFO_LIVE_ENTRANCE_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close", BuildConfig.KINDA_DEFAULT}, new int[]{1, 2, 0}));
        this.hUG.add(new b(this, "观众首次微信群直播功能使用条款", ar.a.USERINFO_LIVE_FIRST_VISITOR_INT_SYNC, new String[]{WeChatBrands.Business.GROUP_OPEN, "close"}, new int[]{1, 0}));
        AppMethodBeat.o(208425);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\tH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006%"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceItem;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/live/ui/LiveUIG;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-logic_release"})
    public final class b implements d {
        final /* synthetic */ LiveUIG hUK;
        private String hUN;
        ar.a hUO;
        private String[] hUP;
        Object hUQ;

        public b(LiveUIG liveUIG, String str, ar.a aVar, String[] strArr, Object obj) {
            p.h(str, "_showtitle");
            p.h(aVar, "_key");
            p.h(strArr, "_items");
            p.h(obj, "_vals");
            this.hUK = liveUIG;
            AppMethodBeat.i(208424);
            this.hUN = str;
            this.hUO = aVar;
            this.hUP = strArr;
            this.hUQ = obj;
            AppMethodBeat.o(208424);
        }

        @Override // com.tencent.mm.live.ui.LiveUIG.d
        public final String auk() {
            return this.hUN;
        }

        @Override // com.tencent.mm.live.ui.LiveUIG.d
        public final void cp(View view) {
            AppMethodBeat.i(208423);
            p.h(view, "view");
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            int length = this.hUP.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.add(this.hUP[i2]);
                linkedList2.add(Integer.valueOf(i2));
            }
            h.a(this.hUK, "", linkedList, linkedList2, "", new a(this));
            AppMethodBeat.o(208423);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
        static final class a implements h.e {
            final /* synthetic */ b hUR;

            a(b bVar) {
                this.hUR = bVar;
            }

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(208421);
                try {
                    Object obj = this.hUR.hUQ;
                    if (obj instanceof long[]) {
                        e aAh = g.aAh();
                        p.g(aAh, "MMKernel.storage()");
                        ao azQ = aAh.azQ();
                        ar.a aVar = this.hUR.hUO;
                        Object obj2 = this.hUR.hUQ;
                        if (obj2 == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.LongArray");
                            AppMethodBeat.o(208421);
                            throw tVar;
                        }
                        azQ.set(aVar, Long.valueOf(((long[]) obj2)[i2]));
                    } else if (obj instanceof int[]) {
                        e aAh2 = g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        ao azQ2 = aAh2.azQ();
                        ar.a aVar2 = this.hUR.hUO;
                        Object obj3 = this.hUR.hUQ;
                        if (obj3 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.IntArray");
                            AppMethodBeat.o(208421);
                            throw tVar2;
                        }
                        azQ2.set(aVar2, Integer.valueOf(((int[]) obj3)[i2]));
                    }
                    LiveUIG.a(this.hUR.hUK).notifyDataSetChanged();
                    AppMethodBeat.o(208421);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicorMsg.LiveSettingUI", e2, "", new Object[0]);
                    AppMethodBeat.o(208421);
                }
            }
        }

        @Override // com.tencent.mm.live.ui.LiveUIG.d
        public final String value() {
            int i2;
            int i3;
            AppMethodBeat.i(208422);
            if (this.hUQ instanceof long[]) {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                i2 = (int) aAh.azQ().a(this.hUO, 0);
            } else {
                e aAh2 = g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                i2 = aAh2.azQ().getInt(this.hUO, 0);
            }
            int i4 = -1;
            Object obj = this.hUQ;
            if (!(obj instanceof int[])) {
                obj = null;
            }
            int[] iArr = (int[]) obj;
            if (iArr != null) {
                int length = iArr.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length) {
                    int i7 = i6 + 1;
                    if (iArr[i5] == i2) {
                        i4 = i6;
                    }
                    i5++;
                    i6 = i7;
                }
            }
            Object obj2 = this.hUQ;
            if (!(obj2 instanceof long[])) {
                obj2 = null;
            }
            long[] jArr = (long[]) obj2;
            if (jArr != null) {
                int length2 = jArr.length;
                int i8 = 0;
                int i9 = 0;
                i3 = i4;
                while (i8 < length2) {
                    int i10 = i9 + 1;
                    if (((int) jArr[i8]) == i2) {
                        i3 = i9;
                    }
                    i8++;
                    i9 = i10;
                }
            } else {
                i3 = i4;
            }
            if (i3 < 0 || i3 >= this.hUP.length) {
                AppMethodBeat.o(208422);
                return "";
            }
            String str = this.hUP[i3];
            AppMethodBeat.o(208422);
            return str;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0017¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/live/ui/LiveUIG;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-logic_release"})
    public final class a extends BaseAdapter {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        public final int getCount() {
            AppMethodBeat.i(208418);
            int size = LiveUIG.this.hUG.size();
            AppMethodBeat.o(208418);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(208419);
            Object obj = LiveUIG.this.hUG.get(i2);
            p.g(obj, "selectsList[position]");
            AppMethodBeat.o(208419);
            return obj;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        @SuppressLint({"SetTextI18n"})
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(208420);
            p.h(viewGroup, "parent");
            TextView textView = new TextView(LiveUIG.this);
            Object item = getItem(i2);
            if (item == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.live.ui.LiveUIG.ITestMenu");
                AppMethodBeat.o(208420);
                throw tVar;
            }
            d dVar = (d) item;
            textView.setTag(dVar);
            textView.setText(dVar.auk() + "->:" + dVar.value());
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50));
            if (i2 % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new View$OnClickListenerC0391a(dVar, textView));
            TextView textView2 = textView;
            AppMethodBeat.o(208420);
            return textView2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.live.ui.LiveUIG$a$a  reason: collision with other inner class name */
        static final class View$OnClickListenerC0391a implements View.OnClickListener {
            final /* synthetic */ d hUL;
            final /* synthetic */ TextView hUM;

            View$OnClickListenerC0391a(d dVar, TextView textView) {
                this.hUL = dVar;
                this.hUM = textView;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208417);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.hUL.cp(this.hUM);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUIG$ChoiceAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208417);
            }
        }
    }
}
